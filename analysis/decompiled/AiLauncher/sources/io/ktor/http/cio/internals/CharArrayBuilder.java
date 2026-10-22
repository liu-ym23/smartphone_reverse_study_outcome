package io.ktor.http.cio.internals;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.utils.io.pool.ObjectPool;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001FB\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J/\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b&\u0010\rJ\u001f\u0010'\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010\u0011J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010+H\u0096\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010%J\u001b\u00100\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010/\u001a\u00020\u000bH\u0016¢\u0006\u0004\b0\u00101J-\u00100\u001a\u00060\u0002j\u0002`\u00032\b\u0010/\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u00102J\u001d\u00100\u001a\u00060\u0002j\u0002`\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b0\u00103J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b8\u00109R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010\u001d\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u001d\u0010D\u001a\u0004\bE\u0010%¨\u0006G"}, d2 = {"Lio/ktor/http/cio/internals/CharArrayBuilder;", "", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/utils/io/pool/ObjectPool;", "", "pool", "<init>", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "", "index", "", "getImpl", "(I)C", "startIndex", "endIndex", ChatTracker.CLICK_COPY, "(II)Ljava/lang/CharSequence;", "bufferForIndex", "(I)[C", "", "throwSingleBuffer", "(I)Ljava/lang/Void;", "nonFullBuffer", "()[C", "appendNewArray", "start", "other", "otherStart", "length", "", "rangeEqualsImpl", "(ILjava/lang/CharSequence;II)Z", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "hashCodeImpl", "(II)I", "currentPosition", "()I", "get", "subSequence", "", "toString", "()Ljava/lang/String;", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", UxipConstants.f30680s, "append", "(C)Ljava/lang/Appendable;", "(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "(Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "LY8/t;", "release", "()V", "Lio/ktor/utils/io/pool/ObjectPool;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "", "buffers", "Ljava/util/List;", "current", "[C", "stringified", "Ljava/lang/String;", "released", "Z", "remaining", "I", "getLength", "SubSequenceImpl", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CharArrayBuilder implements CharSequence, Appendable {
    private List<char[]> buffers;
    private char[] current;
    private int length;
    private final ObjectPool<char[]> pool;
    private boolean released;
    private int remaining;
    private String stringified;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"Lio/ktor/http/cio/internals/CharArrayBuilder$SubSequenceImpl;", "", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "<init>", "(Lio/ktor/http/cio/internals/CharArrayBuilder;II)V", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getStart", "getEnd", "stringified", "Ljava/lang/String;", "getLength", "length", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class SubSequenceImpl implements CharSequence {
        private final int end;
        private final int start;
        private String stringified;

        public SubSequenceImpl(int i10, int i11) {
            this.start = i10;
            this.end = i11;
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int i10) {
            return get(i10);
        }

        public boolean equals(Object other) {
            if (!(other instanceof CharSequence)) {
                return false;
            }
            CharSequence charSequence = (CharSequence) other;
            if (charSequence.length() != length()) {
                return false;
            }
            return CharArrayBuilder.this.rangeEqualsImpl(this.start, charSequence, 0, length());
        }

        public char get(int index) {
            int i10 = this.start + index;
            if (index < 0) {
                throw new IllegalArgumentException(("index is negative: " + index).toString());
            }
            if (i10 < this.end) {
                return CharArrayBuilder.this.getImpl(i10);
            }
            throw new IllegalArgumentException(("index (" + index + ") should be less than length (" + length() + ')').toString());
        }

        public final int getEnd() {
            return this.end;
        }

        public int getLength() {
            return this.end - this.start;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            String str = this.stringified;
            return str != null ? str.hashCode() : CharArrayBuilder.this.hashCodeImpl(this.start, this.end);
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return getLength();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int startIndex, int endIndex) {
            if (startIndex < 0) {
                throw new IllegalArgumentException(("start is negative: " + startIndex).toString());
            }
            if (startIndex > endIndex) {
                throw new IllegalArgumentException(("start (" + startIndex + ") should be less or equal to end (" + endIndex + ')').toString());
            }
            int i10 = this.end;
            int i11 = this.start;
            if (endIndex <= i10 - i11) {
                return startIndex == endIndex ? "" : CharArrayBuilder.this.new SubSequenceImpl(startIndex + i11, i11 + endIndex);
            }
            throw new IllegalArgumentException(("end should be less than length (" + length() + ')').toString());
        }

        @Override // java.lang.CharSequence
        public String toString() {
            String str = this.stringified;
            if (str != null) {
                return str;
            }
            String string = CharArrayBuilder.this.copy(this.start, this.end).toString();
            this.stringified = string;
            return string;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CharArrayBuilder() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final char[] appendNewArray() {
        char[] cArrBorrow = this.pool.borrow();
        char[] cArr = this.current;
        this.current = cArrBorrow;
        this.remaining = cArrBorrow.length;
        this.released = false;
        if (cArr != null) {
            List<char[]> list = this.buffers;
            List<char[]> list2 = list;
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                this.buffers = arrayList;
                arrayList.add(cArr);
                list2 = arrayList;
            }
            list2.add(cArrBorrow);
        }
        return cArrBorrow;
    }

    private final char[] bufferForIndex(int index) {
        List<char[]> list = this.buffers;
        if (list != null) {
            char[] cArr = this.current;
            p.f(cArr);
            return list.get(index / cArr.length);
        }
        if (index >= 2048) {
            throwSingleBuffer(index);
            throw new KotlinNothingValueException();
        }
        char[] cArr2 = this.current;
        if (cArr2 != null) {
            return cArr2;
        }
        throwSingleBuffer(index);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence copy(int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(endIndex - startIndex);
        for (int i10 = startIndex - (startIndex % 2048); i10 < endIndex; i10 += 2048) {
            char[] cArrBufferForIndex = bufferForIndex(i10);
            int iMin = Math.min(endIndex - i10, 2048);
            for (int iMax = Math.max(0, startIndex - i10); iMax < iMin; iMax++) {
                sb2.append(cArrBufferForIndex[iMax]);
            }
        }
        return sb2;
    }

    private final int currentPosition() {
        char[] cArr = this.current;
        p.f(cArr);
        return cArr.length - this.remaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final char getImpl(int index) {
        char[] cArrBufferForIndex = bufferForIndex(index);
        char[] cArr = this.current;
        p.f(cArr);
        return cArrBufferForIndex[index % cArr.length];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int hashCodeImpl(int start, int end) {
        int impl = 0;
        while (start < end) {
            impl = (impl * 31) + getImpl(start);
            start++;
        }
        return impl;
    }

    private final char[] nonFullBuffer() {
        if (this.remaining == 0) {
            return appendNewArray();
        }
        char[] cArr = this.current;
        p.f(cArr);
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean rangeEqualsImpl(int start, CharSequence other, int otherStart, int length) {
        for (int i10 = 0; i10 < length; i10++) {
            if (getImpl(start + i10) != other.charAt(otherStart + i10)) {
                return false;
            }
        }
        return true;
    }

    private final Void throwSingleBuffer(int index) {
        if (this.released) {
            throw new IllegalStateException("Buffer is already released");
        }
        throw new IndexOutOfBoundsException(index + " is not in range [0; " + currentPosition() + ')');
    }

    @Override // java.lang.Appendable
    public Appendable append(char value) {
        char[] cArrNonFullBuffer = nonFullBuffer();
        char[] cArr = this.current;
        p.f(cArr);
        int length = cArr.length;
        int i10 = this.remaining;
        cArrNonFullBuffer[length - i10] = value;
        this.stringified = null;
        this.remaining = i10 - 1;
        this.length = length() + 1;
        return this;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i10) {
        return get(i10);
    }

    public boolean equals(Object other) {
        if (!(other instanceof CharSequence)) {
            return false;
        }
        CharSequence charSequence = (CharSequence) other;
        if (length() != charSequence.length()) {
            return false;
        }
        return rangeEqualsImpl(0, charSequence, 0, length());
    }

    public char get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException(("index is negative: " + index).toString());
        }
        if (index < length()) {
            return getImpl(index);
        }
        throw new IllegalArgumentException(("index " + index + " is not in range [0, " + length() + ')').toString());
    }

    public int getLength() {
        return this.length;
    }

    public final ObjectPool<char[]> getPool() {
        return this.pool;
    }

    public int hashCode() {
        String str = this.stringified;
        return str != null ? str.hashCode() : hashCodeImpl(0, length());
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final void release() {
        List<char[]> list = this.buffers;
        if (list != null) {
            this.current = null;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.pool.recycle(list.get(i10));
            }
        } else {
            char[] cArr = this.current;
            if (cArr != null) {
                this.pool.recycle(cArr);
            }
            this.current = null;
        }
        this.released = true;
        this.buffers = null;
        this.stringified = null;
        this.length = 0;
        this.remaining = 0;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException(("startIndex (" + startIndex + ") should be less or equal to endIndex (" + endIndex + ')').toString());
        }
        if (startIndex < 0) {
            throw new IllegalArgumentException(("startIndex is negative: " + startIndex).toString());
        }
        if (endIndex <= length()) {
            return new SubSequenceImpl(startIndex, endIndex);
        }
        throw new IllegalArgumentException(("endIndex (" + endIndex + ") is greater than length (" + length() + ')').toString());
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.stringified;
        if (str != null) {
            return str;
        }
        String string = copy(0, length()).toString();
        this.stringified = string;
        return string;
    }

    public CharArrayBuilder(ObjectPool<char[]> pool) {
        p.i(pool, "pool");
        this.pool = pool;
    }

    public /* synthetic */ CharArrayBuilder(ObjectPool objectPool, int i10, i iVar) {
        this((i10 & 1) != 0 ? CharArrayPoolKt.getCharArrayPool() : objectPool);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence value, int startIndex, int endIndex) {
        if (value == null) {
            return this;
        }
        int i10 = startIndex;
        while (i10 < endIndex) {
            char[] cArrNonFullBuffer = nonFullBuffer();
            int length = cArrNonFullBuffer.length;
            int i11 = this.remaining;
            int i12 = length - i11;
            int iMin = Math.min(endIndex - i10, i11);
            for (int i13 = 0; i13 < iMin; i13++) {
                cArrNonFullBuffer[i12 + i13] = value.charAt(i10 + i13);
            }
            i10 += iMin;
            this.remaining -= iMin;
        }
        this.stringified = null;
        this.length = length() + (endIndex - startIndex);
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence value) {
        return value == null ? this : append(value, 0, value.length());
    }
}
