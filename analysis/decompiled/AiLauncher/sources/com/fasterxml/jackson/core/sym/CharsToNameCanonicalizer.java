package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class CharsToNameCanonicalizer {
    private static final int DEFAULT_T_SIZE = 64;
    public static final int HASH_MULT = 33;
    static final int MAX_COLL_CHAIN_LENGTH = 150;
    static final int MAX_ENTRIES_FOR_REUSE = 12000;
    private static final int MAX_T_SIZE = 65536;
    protected Bucket[] _buckets;
    protected boolean _canonicalize;
    protected final int _factoryFeatures;
    protected boolean _hashShared;
    protected int _indexMask;
    protected int _longestCollisionList;
    protected BitSet _overflows;
    protected final CharsToNameCanonicalizer _parent;
    protected final int _seed;
    protected int _size;
    protected int _sizeThreshold;
    protected final StreamReadConstraints _streamReadConstraints;
    protected String[] _symbols;
    protected final AtomicReference<TableInfo> _tableInfo;

    public static final class Bucket {
        public final int length;
        public final Bucket next;
        public final String symbol;

        public Bucket(String str, Bucket bucket) {
            this.symbol = str;
            this.next = bucket;
            this.length = bucket != null ? 1 + bucket.length : 1;
        }

        public String has(char[] cArr, int i10, int i11) {
            if (this.symbol.length() != i11) {
                return null;
            }
            int i12 = 0;
            while (this.symbol.charAt(i12) == cArr[i10 + i12]) {
                i12++;
                if (i12 >= i11) {
                    return this.symbol;
                }
            }
            return null;
        }
    }

    private CharsToNameCanonicalizer(StreamReadConstraints streamReadConstraints, int i10, int i11) {
        this._parent = null;
        this._seed = i11;
        this._streamReadConstraints = streamReadConstraints;
        this._canonicalize = true;
        this._factoryFeatures = i10;
        this._hashShared = false;
        this._longestCollisionList = 0;
        this._tableInfo = new AtomicReference<>(TableInfo.createInitial(64));
    }

    private String _addSymbol(char[] cArr, int i10, int i11, int i12, int i13) throws IOException {
        if (this._hashShared) {
            copyArrays();
            this._hashShared = false;
        } else if (this._size >= this._sizeThreshold) {
            rehash();
            i13 = _hashToIndex(calcHash(cArr, i10, i11));
        }
        String str = new String(cArr, i10, i11);
        if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(this._factoryFeatures)) {
            str = InternCache.instance.intern(str);
        }
        this._size++;
        String[] strArr = this._symbols;
        if (strArr[i13] == null) {
            strArr[i13] = str;
            return str;
        }
        int i14 = i13 >> 1;
        Bucket bucket = new Bucket(str, this._buckets[i14]);
        int i15 = bucket.length;
        if (i15 > 150) {
            _handleSpillOverflow(i14, bucket, i13);
            return str;
        }
        this._buckets[i14] = bucket;
        this._longestCollisionList = Math.max(i15, this._longestCollisionList);
        return str;
    }

    private String _findSymbol2(char[] cArr, int i10, int i11, Bucket bucket) {
        while (bucket != null) {
            String strHas = bucket.has(cArr, i10, i11);
            if (strHas != null) {
                return strHas;
            }
            bucket = bucket.next;
        }
        return null;
    }

    private void _handleSpillOverflow(int i10, Bucket bucket, int i11) throws IOException {
        BitSet bitSet = this._overflows;
        if (bitSet == null) {
            BitSet bitSet2 = new BitSet();
            this._overflows = bitSet2;
            bitSet2.set(i10);
        } else if (bitSet.get(i10)) {
            if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this._factoryFeatures)) {
                _reportTooManyCollisions(150);
            }
            this._canonicalize = false;
        } else {
            this._overflows.set(i10);
        }
        this._symbols[i11] = bucket.symbol;
        this._buckets[i10] = null;
        this._size -= bucket.length;
        this._longestCollisionList = -1;
    }

    private static int _thresholdSize(int i10) {
        return i10 - (i10 >> 2);
    }

    private void copyArrays() {
        String[] strArr = this._symbols;
        this._symbols = (String[]) Arrays.copyOf(strArr, strArr.length);
        Bucket[] bucketArr = this._buckets;
        this._buckets = (Bucket[]) Arrays.copyOf(bucketArr, bucketArr.length);
    }

    @Deprecated
    public static CharsToNameCanonicalizer createRoot() {
        return createRoot((TokenStreamFactory) null);
    }

    private void mergeChild(TableInfo tableInfo) {
        int i10 = tableInfo.size;
        TableInfo tableInfo2 = this._tableInfo.get();
        if (i10 == tableInfo2.size) {
            return;
        }
        if (i10 > MAX_ENTRIES_FOR_REUSE) {
            tableInfo = TableInfo.createInitial(64);
        }
        this._tableInfo.compareAndSet(tableInfo2, tableInfo);
    }

    private void rehash() throws IOException {
        String[] strArr = this._symbols;
        int length = strArr.length;
        int i10 = length + length;
        if (i10 > 65536) {
            this._size = 0;
            this._canonicalize = false;
            this._symbols = new String[64];
            this._buckets = new Bucket[32];
            this._indexMask = 63;
            this._hashShared = false;
            return;
        }
        Bucket[] bucketArr = this._buckets;
        this._symbols = new String[i10];
        this._buckets = new Bucket[i10 >> 1];
        this._indexMask = i10 - 1;
        this._sizeThreshold = _thresholdSize(i10);
        int i11 = 0;
        int iMax = 0;
        for (String str : strArr) {
            if (str != null) {
                i11++;
                int i_hashToIndex = _hashToIndex(calcHash(str));
                String[] strArr2 = this._symbols;
                if (strArr2[i_hashToIndex] == null) {
                    strArr2[i_hashToIndex] = str;
                } else {
                    int i12 = i_hashToIndex >> 1;
                    Bucket bucket = new Bucket(str, this._buckets[i12]);
                    this._buckets[i12] = bucket;
                    iMax = Math.max(iMax, bucket.length);
                }
            }
        }
        int i13 = length >> 1;
        for (int i14 = 0; i14 < i13; i14++) {
            for (Bucket bucket2 = bucketArr[i14]; bucket2 != null; bucket2 = bucket2.next) {
                i11++;
                String str2 = bucket2.symbol;
                int i_hashToIndex2 = _hashToIndex(calcHash(str2));
                String[] strArr3 = this._symbols;
                if (strArr3[i_hashToIndex2] == null) {
                    strArr3[i_hashToIndex2] = str2;
                } else {
                    int i15 = i_hashToIndex2 >> 1;
                    Bucket bucket3 = new Bucket(str2, this._buckets[i15]);
                    this._buckets[i15] = bucket3;
                    iMax = Math.max(iMax, bucket3.length);
                }
            }
        }
        this._longestCollisionList = iMax;
        this._overflows = null;
        if (i11 != this._size) {
            throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", Integer.valueOf(this._size), Integer.valueOf(i11)));
        }
    }

    public int _hashToIndex(int i10) {
        int i11 = i10 + (i10 >>> 15);
        int i12 = i11 ^ (i11 << 7);
        return this._indexMask & (i12 + (i12 >>> 3));
    }

    public void _reportTooManyCollisions(int i10) throws StreamConstraintsException {
        throw new StreamConstraintsException("Longest collision chain in symbol table (of size " + this._size + ") now exceeds maximum, " + i10 + " -- suspect a DoS attack based on hash collisions");
    }

    public int bucketCount() {
        return this._symbols.length;
    }

    public int calcHash(char[] cArr, int i10, int i11) {
        int i12 = this._seed;
        int i13 = i11 + i10;
        while (i10 < i13) {
            i12 = (i12 * 33) + cArr[i10];
            i10++;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public int collisionCount() {
        int i10 = 0;
        for (Bucket bucket : this._buckets) {
            if (bucket != null) {
                i10 += bucket.length;
            }
        }
        return i10;
    }

    public String findSymbol(char[] cArr, int i10, int i11, int i12) throws IOException {
        if (i11 < 1) {
            return "";
        }
        if (!this._canonicalize) {
            this._streamReadConstraints.validateNameLength(i11);
            return new String(cArr, i10, i11);
        }
        int i_hashToIndex = _hashToIndex(i12);
        String str = this._symbols[i_hashToIndex];
        if (str != null) {
            if (str.length() == i11) {
                int i13 = 0;
                while (str.charAt(i13) == cArr[i10 + i13]) {
                    i13++;
                    if (i13 == i11) {
                        return str;
                    }
                }
            }
            Bucket bucket = this._buckets[i_hashToIndex >> 1];
            if (bucket != null) {
                String strHas = bucket.has(cArr, i10, i11);
                if (strHas != null) {
                    return strHas;
                }
                String str_findSymbol2 = _findSymbol2(cArr, i10, i11, bucket.next);
                if (str_findSymbol2 != null) {
                    return str_findSymbol2;
                }
            }
        }
        this._streamReadConstraints.validateNameLength(i11);
        return _addSymbol(cArr, i10, i11, i12, i_hashToIndex);
    }

    public int hashSeed() {
        return this._seed;
    }

    public CharsToNameCanonicalizer makeChild() {
        return new CharsToNameCanonicalizer(this, this._streamReadConstraints, this._factoryFeatures, this._seed, this._tableInfo.get());
    }

    public int maxCollisionLength() {
        return this._longestCollisionList;
    }

    public boolean maybeDirty() {
        return !this._hashShared;
    }

    public void release() {
        CharsToNameCanonicalizer charsToNameCanonicalizer;
        if (maybeDirty() && (charsToNameCanonicalizer = this._parent) != null && this._canonicalize) {
            charsToNameCanonicalizer.mergeChild(new TableInfo(this));
            this._hashShared = true;
        }
    }

    public int size() {
        AtomicReference<TableInfo> atomicReference = this._tableInfo;
        return atomicReference != null ? atomicReference.get().size : this._size;
    }

    public void verifyInternalConsistency() {
        int length = this._symbols.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (this._symbols[i11] != null) {
                i10++;
            }
        }
        int i12 = length >> 1;
        for (int i13 = 0; i13 < i12; i13++) {
            for (Bucket bucket = this._buckets[i13]; bucket != null; bucket = bucket.next) {
                i10++;
            }
        }
        if (i10 != this._size) {
            throw new IllegalStateException(String.format("Internal error: expected internal size %d vs calculated count %d", Integer.valueOf(this._size), Integer.valueOf(i10)));
        }
    }

    @Deprecated
    public static CharsToNameCanonicalizer createRoot(int i10) {
        return createRoot(null, i10);
    }

    public static CharsToNameCanonicalizer createRoot(TokenStreamFactory tokenStreamFactory) {
        return createRoot(tokenStreamFactory, 0);
    }

    public int calcHash(String str) {
        int length = str.length();
        int iCharAt = this._seed;
        for (int i10 = 0; i10 < length; i10++) {
            iCharAt = (iCharAt * 33) + str.charAt(i10);
        }
        if (iCharAt == 0) {
            return 1;
        }
        return iCharAt;
    }

    @Deprecated
    public CharsToNameCanonicalizer makeChild(int i10) {
        return makeChild();
    }

    public static CharsToNameCanonicalizer createRoot(TokenStreamFactory tokenStreamFactory, int i10) {
        int factoryFeatures;
        StreamReadConstraints streamReadConstraintsDefaults;
        if (i10 == 0) {
            i10 = System.identityHashCode(tokenStreamFactory);
        }
        if (tokenStreamFactory == null) {
            streamReadConstraintsDefaults = StreamReadConstraints.defaults();
            factoryFeatures = 0;
        } else {
            StreamReadConstraints streamReadConstraints = tokenStreamFactory.streamReadConstraints();
            factoryFeatures = tokenStreamFactory.getFactoryFeatures();
            streamReadConstraintsDefaults = streamReadConstraints;
        }
        return new CharsToNameCanonicalizer(streamReadConstraintsDefaults, factoryFeatures, i10);
    }

    public static final class TableInfo {
        final Bucket[] buckets;
        final int longestCollisionList;
        final int size;
        final String[] symbols;

        public TableInfo(int i10, int i11, String[] strArr, Bucket[] bucketArr) {
            this.size = i10;
            this.longestCollisionList = i11;
            this.symbols = strArr;
            this.buckets = bucketArr;
        }

        public static TableInfo createInitial(int i10) {
            return new TableInfo(0, 0, new String[i10], new Bucket[i10 >> 1]);
        }

        public TableInfo(CharsToNameCanonicalizer charsToNameCanonicalizer) {
            this.size = charsToNameCanonicalizer._size;
            this.longestCollisionList = charsToNameCanonicalizer._longestCollisionList;
            this.symbols = charsToNameCanonicalizer._symbols;
            this.buckets = charsToNameCanonicalizer._buckets;
        }
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, StreamReadConstraints streamReadConstraints, int i10, int i11, TableInfo tableInfo) {
        this._parent = charsToNameCanonicalizer;
        this._streamReadConstraints = streamReadConstraints;
        this._seed = i11;
        this._tableInfo = null;
        this._factoryFeatures = i10;
        this._canonicalize = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i10);
        String[] strArr = tableInfo.symbols;
        this._symbols = strArr;
        this._buckets = tableInfo.buckets;
        this._size = tableInfo.size;
        this._longestCollisionList = tableInfo.longestCollisionList;
        int length = strArr.length;
        this._sizeThreshold = _thresholdSize(length);
        this._indexMask = length - 1;
        this._hashShared = true;
    }
}
