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

/* loaded from: classes2.dex */
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

        public String has(char[] cArr, int i, int i6) {
            if (this.symbol.length() != i6) {
                return null;
            }
            int i10 = 0;
            while (this.symbol.charAt(i10) == cArr[i + i10]) {
                i10++;
                if (i10 >= i6) {
                    return this.symbol;
                }
            }
            return null;
        }
    }

    private CharsToNameCanonicalizer(StreamReadConstraints streamReadConstraints, int i, int i6) {
        this._parent = null;
        this._seed = i6;
        this._streamReadConstraints = streamReadConstraints;
        this._canonicalize = true;
        this._factoryFeatures = i;
        this._hashShared = false;
        this._longestCollisionList = 0;
        this._tableInfo = new AtomicReference<>(TableInfo.createInitial(64));
    }

    private String _addSymbol(char[] cArr, int i, int i6, int i10, int i11) throws IOException {
        if (this._hashShared) {
            copyArrays();
            this._hashShared = false;
        } else if (this._size >= this._sizeThreshold) {
            rehash();
            i11 = _hashToIndex(calcHash(cArr, i, i6));
        }
        String str = new String(cArr, i, i6);
        if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(this._factoryFeatures)) {
            str = InternCache.instance.intern(str);
        }
        this._size++;
        String[] strArr = this._symbols;
        if (strArr[i11] == null) {
            strArr[i11] = str;
            return str;
        }
        int i12 = i11 >> 1;
        Bucket bucket = new Bucket(str, this._buckets[i12]);
        int i13 = bucket.length;
        if (i13 > 150) {
            _handleSpillOverflow(i12, bucket, i11);
            return str;
        }
        this._buckets[i12] = bucket;
        this._longestCollisionList = Math.max(i13, this._longestCollisionList);
        return str;
    }

    private String _findSymbol2(char[] cArr, int i, int i6, Bucket bucket) {
        while (bucket != null) {
            String strHas = bucket.has(cArr, i, i6);
            if (strHas != null) {
                return strHas;
            }
            bucket = bucket.next;
        }
        return null;
    }

    private void _handleSpillOverflow(int i, Bucket bucket, int i6) throws IOException {
        BitSet bitSet = this._overflows;
        if (bitSet == null) {
            BitSet bitSet2 = new BitSet();
            this._overflows = bitSet2;
            bitSet2.set(i);
        } else if (bitSet.get(i)) {
            if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this._factoryFeatures)) {
                _reportTooManyCollisions(150);
            }
            this._canonicalize = false;
        } else {
            this._overflows.set(i);
        }
        this._symbols[i6] = bucket.symbol;
        this._buckets[i] = null;
        this._size -= bucket.length;
        this._longestCollisionList = -1;
    }

    private static int _thresholdSize(int i) {
        return i - (i >> 2);
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
        int i = tableInfo.size;
        TableInfo tableInfo2 = this._tableInfo.get();
        if (i == tableInfo2.size) {
            return;
        }
        if (i > MAX_ENTRIES_FOR_REUSE) {
            tableInfo = TableInfo.createInitial(64);
        }
        this._tableInfo.compareAndSet(tableInfo2, tableInfo);
    }

    private void rehash() throws IOException {
        String[] strArr = this._symbols;
        int length = strArr.length;
        int i = length + length;
        if (i > 65536) {
            this._size = 0;
            this._canonicalize = false;
            this._symbols = new String[64];
            this._buckets = new Bucket[32];
            this._indexMask = 63;
            this._hashShared = false;
            return;
        }
        Bucket[] bucketArr = this._buckets;
        this._symbols = new String[i];
        this._buckets = new Bucket[i >> 1];
        this._indexMask = i - 1;
        this._sizeThreshold = _thresholdSize(i);
        int i6 = 0;
        int iMax = 0;
        for (String str : strArr) {
            if (str != null) {
                i6++;
                int i_hashToIndex = _hashToIndex(calcHash(str));
                String[] strArr2 = this._symbols;
                if (strArr2[i_hashToIndex] == null) {
                    strArr2[i_hashToIndex] = str;
                } else {
                    int i10 = i_hashToIndex >> 1;
                    Bucket bucket = new Bucket(str, this._buckets[i10]);
                    this._buckets[i10] = bucket;
                    iMax = Math.max(iMax, bucket.length);
                }
            }
        }
        int i11 = length >> 1;
        for (int i12 = 0; i12 < i11; i12++) {
            for (Bucket bucket2 = bucketArr[i12]; bucket2 != null; bucket2 = bucket2.next) {
                i6++;
                String str2 = bucket2.symbol;
                int i_hashToIndex2 = _hashToIndex(calcHash(str2));
                String[] strArr3 = this._symbols;
                if (strArr3[i_hashToIndex2] == null) {
                    strArr3[i_hashToIndex2] = str2;
                } else {
                    int i13 = i_hashToIndex2 >> 1;
                    Bucket bucket3 = new Bucket(str2, this._buckets[i13]);
                    this._buckets[i13] = bucket3;
                    iMax = Math.max(iMax, bucket3.length);
                }
            }
        }
        this._longestCollisionList = iMax;
        this._overflows = null;
        if (i6 != this._size) {
            throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", Integer.valueOf(this._size), Integer.valueOf(i6)));
        }
    }

    public int _hashToIndex(int i) {
        int i6 = i + (i >>> 15);
        int i10 = i6 ^ (i6 << 7);
        return this._indexMask & (i10 + (i10 >>> 3));
    }

    public void _reportTooManyCollisions(int i) throws StreamConstraintsException {
        throw new StreamConstraintsException("Longest collision chain in symbol table (of size " + this._size + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }

    public int bucketCount() {
        return this._symbols.length;
    }

    public int calcHash(char[] cArr, int i, int i6) {
        int i10 = this._seed;
        int i11 = i6 + i;
        while (i < i11) {
            i10 = (i10 * 33) + cArr[i];
            i++;
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public int collisionCount() {
        int i = 0;
        for (Bucket bucket : this._buckets) {
            if (bucket != null) {
                i += bucket.length;
            }
        }
        return i;
    }

    public String findSymbol(char[] cArr, int i, int i6, int i10) throws IOException {
        if (i6 < 1) {
            return "";
        }
        if (!this._canonicalize) {
            this._streamReadConstraints.validateNameLength(i6);
            return new String(cArr, i, i6);
        }
        int i_hashToIndex = _hashToIndex(i10);
        String str = this._symbols[i_hashToIndex];
        if (str != null) {
            if (str.length() == i6) {
                int i11 = 0;
                while (str.charAt(i11) == cArr[i + i11]) {
                    i11++;
                    if (i11 == i6) {
                        return str;
                    }
                }
            }
            Bucket bucket = this._buckets[i_hashToIndex >> 1];
            if (bucket != null) {
                String strHas = bucket.has(cArr, i, i6);
                if (strHas != null) {
                    return strHas;
                }
                String str_findSymbol2 = _findSymbol2(cArr, i, i6, bucket.next);
                if (str_findSymbol2 != null) {
                    return str_findSymbol2;
                }
            }
        }
        this._streamReadConstraints.validateNameLength(i6);
        return _addSymbol(cArr, i, i6, i10, i_hashToIndex);
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
        int i = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (this._symbols[i6] != null) {
                i++;
            }
        }
        int i10 = length >> 1;
        for (int i11 = 0; i11 < i10; i11++) {
            for (Bucket bucket = this._buckets[i11]; bucket != null; bucket = bucket.next) {
                i++;
            }
        }
        if (i != this._size) {
            throw new IllegalStateException(String.format("Internal error: expected internal size %d vs calculated count %d", Integer.valueOf(this._size), Integer.valueOf(i)));
        }
    }

    @Deprecated
    public static CharsToNameCanonicalizer createRoot(int i) {
        return createRoot(null, i);
    }

    public static CharsToNameCanonicalizer createRoot(TokenStreamFactory tokenStreamFactory) {
        return createRoot(tokenStreamFactory, 0);
    }

    public int calcHash(String str) {
        int length = str.length();
        int iCharAt = this._seed;
        for (int i = 0; i < length; i++) {
            iCharAt = (iCharAt * 33) + str.charAt(i);
        }
        if (iCharAt == 0) {
            return 1;
        }
        return iCharAt;
    }

    @Deprecated
    public CharsToNameCanonicalizer makeChild(int i) {
        return makeChild();
    }

    public static CharsToNameCanonicalizer createRoot(TokenStreamFactory tokenStreamFactory, int i) {
        int factoryFeatures;
        StreamReadConstraints streamReadConstraintsDefaults;
        if (i == 0) {
            i = System.identityHashCode(tokenStreamFactory);
        }
        if (tokenStreamFactory == null) {
            streamReadConstraintsDefaults = StreamReadConstraints.defaults();
            factoryFeatures = 0;
        } else {
            StreamReadConstraints streamReadConstraints = tokenStreamFactory.streamReadConstraints();
            factoryFeatures = tokenStreamFactory.getFactoryFeatures();
            streamReadConstraintsDefaults = streamReadConstraints;
        }
        return new CharsToNameCanonicalizer(streamReadConstraintsDefaults, factoryFeatures, i);
    }

    public static final class TableInfo {
        final Bucket[] buckets;
        final int longestCollisionList;
        final int size;
        final String[] symbols;

        public TableInfo(int i, int i6, String[] strArr, Bucket[] bucketArr) {
            this.size = i;
            this.longestCollisionList = i6;
            this.symbols = strArr;
            this.buckets = bucketArr;
        }

        public static TableInfo createInitial(int i) {
            return new TableInfo(0, 0, new String[i], new Bucket[i >> 1]);
        }

        public TableInfo(CharsToNameCanonicalizer charsToNameCanonicalizer) {
            this.size = charsToNameCanonicalizer._size;
            this.longestCollisionList = charsToNameCanonicalizer._longestCollisionList;
            this.symbols = charsToNameCanonicalizer._symbols;
            this.buckets = charsToNameCanonicalizer._buckets;
        }
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, StreamReadConstraints streamReadConstraints, int i, int i6, TableInfo tableInfo) {
        this._parent = charsToNameCanonicalizer;
        this._streamReadConstraints = streamReadConstraints;
        this._seed = i6;
        this._tableInfo = null;
        this._factoryFeatures = i;
        this._canonicalize = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i);
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
