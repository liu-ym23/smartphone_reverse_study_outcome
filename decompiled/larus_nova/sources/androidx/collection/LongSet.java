package androidx.collection;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\t\u0010\u0016\u001a\u00020\u0017H\u0086\bJ:\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001d\u001a\u00020\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001e0\u0019H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010!\u001a\u00020\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\"\u001a\u00020\u00122!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u0011\u001a\u00020\u00122!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010#\u001a\u00020\nH\u0007J:\u0010#\u001a\u00020\n2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010$\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0017H\u0086\u0002J:\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020(H\u0007JT\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020(2\u0014\b\u0004\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020(0\u0019H\u0087\bø\u0001\u0000J\b\u0010.\u001a\u00020\nH\u0016J\u0013\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00101\u001a\u00020&H\u0016J\u0016\u00102\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0017H\u0080\b¢\u0006\u0002\b3R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0012\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r\u0082\u0001\u00014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/collection/LongSet;", "", "<init>", "()V", "metadata", "", "getMetadata$annotations", SlcElement.KEY_ELEMENTS, "getElements$annotations", "_capacity", "", "capacity", "getCapacity", "()I", "_size", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", SoloKtvContext.SOLO_PAGE_FIRST, "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "forEachIndex", "", "block", "index", "forEach", "all", "count", "contains", "joinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "transform", "hashCode", "equals", "other", "toString", "findElementIndex", "findElementIndex$collection", "Landroidx/collection/MutableLongSet;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LongSet {
    public int _capacity;
    public int _size;
    public long[] elements;
    public long[] metadata;

    public /* synthetic */ LongSet(DefaultConstructorMarker r100) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        return joinToString$default(this, r110, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        return joinToString$default(this, r110, r111, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, 0, null, 24, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, r113, null, 16, null);
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long first() {
        long[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L21;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L17;
        if ((255 & r104) >= 128) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == true) goto L15;
        r104 = r104 >> 8;
        r106 = r106 + 1;
        goto L8
    L15:
        return r100[(r103 << 3) + r106];
    L12:
        r110 = false;
        goto L13
    L17:
        if (r105 != 8) goto L21;
    L18:
        if (r103 == r102) goto L21;
        r103 = r103 + 1;
    L21:
        throw new NoSuchElementException("The LongSet is empty");
    }

    public int hashCode() {
        long[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        int r103 = 0;
        if (r102 < 0) goto L21;
        int r104 = 0;
        int r105 = 0;
    L5:
        long r106 = r101[r104];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r107 = 8 - ((~(r104 - r102)) >>> 31);
        int r110 = 0;
    L8:
        if (r110 >= r107) goto L16;
        if ((255 & r106) >= 128) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L15;
        long r112 = r100[(r104 << 3) + r110];
        r105 = r105 + ((int) (r112 ^ (r112 >>> 32)));
    L15:
        r106 = r106 >> 8;
        r110 = r110 + 1;
        goto L8
    L12:
        r111 = false;
        goto L13
    L16:
        if (r107 == 8) goto L17;
        return r105;
    L17:
        if (r104 == r102) goto L19;
        r104 = r104 + 1;
        goto L5
    L19:
        r103 = r105;
    L21:
        return r103;
    }

    public final boolean isEmpty() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private LongSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = LongSetKt.getEmptyLongArray();
    }

    public final int count() {
        return this._size;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean all(Function1<? super Long, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        long[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L21;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r111 = 8 - ((~(r103 - r102)) >>> 31);
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L18;
        if ((255 & r104) >= 128) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L17;
        if (r110.invoke(Long.valueOf(r100[(r103 << 3) + r112])).booleanValue() == true) goto L17;
        return false;
    L17:
        r104 = r104 >> 8;
        r112 = r112 + 1;
        goto L8
    L12:
        r113 = false;
        goto L13
    L18:
        if (r111 != 8) goto L21;
    L19:
        if (r103 == r102) goto L21;
        r103 = r103 + 1;
    L21:
        return true;
    }

    public final boolean any(Function1<? super Long, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        long[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L21;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L18;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        if (r110.invoke(Long.valueOf(r100[(r103 << 3) + r111])).booleanValue() == false) goto L17;
        return true;
    L17:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r105 != 8) goto L21;
    L19:
        if (r103 == r102) goto L21;
        r103 = r103 + 1;
    L21:
        return false;
    }

    public final boolean contains(long r110) {
        int r100 = ((int) (r110 ^ (r110 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r101 = (r100 << 16) ^ r100;
        int r102 = r101 & 127;
        int r103 = this._capacity;
        int r104 = (r101 >>> 7) & r103;
        int r105 = 0;
    L3:
        long[] r106 = this.metadata;
        int r107 = r104 >> 3;
        int r108 = (r104 & 7) << 3;
        long r109 = ((r106[r107 + 1] << (64 - r108)) & ((-r108) >> 63)) | (r106[r107] >>> r108);
        long r111 = (((long) r102) * ScatterMapKt.BitmaskLsb) ^ r109;
        long r112 = ((~r111) & (r111 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r112 == 0) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == false) goto L14;
        int r114 = ((Long.numberOfTrailingZeros(r112) >> 3) + r104) & r103;
        if (this.elements[r114] == r110) goto L16;
        r112 = r112 & (r112 - 1);
    L16:
        if (r114 < 0) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (((r109 & ((~r109) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r105 = r105 + 8;
        r104 = (r104 + r105) & r103;
        goto L3
    L15:
        r114 = -1;
        goto L16
    L7:
        r113 = false;
        goto L8
    }

    public final int count(Function1<? super Long, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        long[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        int r103 = 0;
        if (r102 < 0) goto L23;
        int r104 = 0;
        int r105 = 0;
    L5:
        long r106 = r101[r104];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r111 = 8 - ((~(r104 - r102)) >>> 31);
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L18;
        if ((255 & r106) >= 128) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L17;
        if (r110.invoke(Long.valueOf(r100[(r104 << 3) + r112])).booleanValue() == false) goto L17;
        r105 = r105 + 1;
    L17:
        r106 = r106 >> 8;
        r112 = r112 + 1;
        goto L8
    L12:
        r113 = false;
        goto L13
    L18:
        if (r111 == 8) goto L19;
        return r105;
    L19:
        if (r104 == r102) goto L21;
        r104 = r104 + 1;
        goto L5
    L21:
        r103 = r105;
    L23:
        return r103;
    }

    public boolean equals(Object r110) {
        if (r110 != this) goto L6;
        return true;
    L6:
        if ((r110 instanceof LongSet) == true) goto L8;
        return false;
    L8:
        LongSet r100 = (LongSet) r110;
        if (r100._size == this._size) goto L11;
        return false;
    L11:
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L30;
        int r104 = 0;
    L14:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r111 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L17:
        if (r112 >= r111) goto L27;
        if ((255 & r105) >= 128) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L26;
        if (r100.contains(r101[(r104 << 3) + r112]) == true) goto L26;
        return false;
    L26:
        r105 = r105 >> 8;
        r112 = r112 + 1;
        goto L17
    L21:
        r113 = false;
        goto L22
    L27:
        if (r111 != 8) goto L30;
    L28:
        if (r104 == r103) goto L30;
        r104 = r104 + 1;
    L30:
        return true;
    }

    public final int findElementIndex$collection(long r110) {
        int r100 = ((int) (r110 ^ (r110 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r101 = (r100 << 16) ^ r100;
        int r102 = r101 & 127;
        int r103 = this._capacity;
        int r104 = (r101 >>> 7) & r103;
        int r105 = 0;
    L3:
        long[] r106 = this.metadata;
        int r107 = r104 >> 3;
        int r108 = (r104 & 7) << 3;
        long r109 = ((r106[r107 + 1] << (64 - r108)) & ((-r108) >> 63)) | (r106[r107] >>> r108);
        long r111 = (((long) r102) * ScatterMapKt.BitmaskLsb) ^ r109;
        long r112 = ((~r111) & (r111 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r112 == 0) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == false) goto L14;
        int r114 = ((Long.numberOfTrailingZeros(r112) >> 3) + r104) & r103;
        if (this.elements[r114] == r110) goto L11;
        r112 = r112 & (r112 - 1);
        goto L5
    L11:
        return r114;
    L14:
        if (((r109 & ((~r109) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r105 = r105 + 8;
        r104 = (r104 + r105) & r103;
        goto L3
    L15:
        return -1;
    L7:
        r113 = false;
        goto L8
    }

    public final long first(Function1<? super Long, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        long[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L22;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L18;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        long r113 = r100[(r103 << 3) + r111];
        if (r110.invoke(Long.valueOf(r113)).booleanValue() == false) goto L17;
        return r113;
    L17:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r105 != 8) goto L22;
    L19:
        if (r103 == r102) goto L22;
        r103 = r103 + 1;
    L22:
        throw new NoSuchElementException("Could not find a match");
    }

    public final void forEach(Function1<? super Long, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        long[] r100 = this.elements;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L19;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L16;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L15;
        r110.invoke(Long.valueOf(r100[(r103 << 3) + r111]));
    L15:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L16:
        if (r105 == 8) goto L17;
        return;
    L17:
        if (r103 == r102) goto L26;
        r103 = r103 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndex(Function1<? super Integer, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        long[] r100 = this.metadata;
        int r101 = r100.length - 2;
        if (r101 < 0) goto L20;
        int r102 = 0;
    L5:
        long r103 = r100[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        r110.invoke(Integer.valueOf((r102 << 3) + r105));
    L15:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L16:
        if (r104 == 8) goto L18;
        return;
    L18:
        if (r102 == r101) goto L26;
        r102 = r102 + 1;
        goto L5
    L26:
        return;
    }

    public final String joinToString(Function1<? super Long, ? extends CharSequence> r210) {
        Intrinsics.checkNotNullParameter(r210, "transform");
        StringBuilder r100 = new StringBuilder("");
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
        int r105 = 0;
    L5:
        long r110 = r102[r104];
        if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r111 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L21;
        if ((255 & r110) >= 128) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L20;
        long r114 = r101[(r104 << 3) + r112];
        if (r105 == (-1)) goto L16;
        if (r105 == 0) goto L19;
        r100.append(", ");
    L19:
        r100.append(r210.invoke(Long.valueOf(r114)));
        r105 = r105 + 1;
        goto L20
    L16:
        r100.append("...");
    L26:
        return r100.toString();
    L20:
        r110 = r110 >> 8;
        r112 = r112 + 1;
        goto L8
    L12:
        r113 = false;
        goto L13
    L21:
        if (r111 != 8) goto L24;
    L22:
        if (r104 == r103) goto L24;
        r104 = r104 + 1;
    L24:
        r100.append("");
        goto L26
    }

    public final String joinToString(CharSequence r210, Function1<? super Long, ? extends CharSequence> r211) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "transform");
        StringBuilder r100 = new StringBuilder("");
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
        int r110 = 0;
    L5:
        long r111 = r102[r104];
        if (((((~r111) << 7) & r111) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r112 = 8 - ((~(r104 - r103)) >>> 31);
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L21;
        if ((r111 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L20;
        long r115 = r101[(r104 << 3) + r113];
        if (r110 == (-1)) goto L16;
        if (r110 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r211.invoke(Long.valueOf(r115)));
        r110 = r110 + 1;
        goto L20
    L16:
        r100.append("...");
    L26:
        return r100.toString();
    L20:
        r111 = r111 >> 8;
        r113 = r113 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L21:
        if (r112 != 8) goto L24;
    L22:
        if (r104 == r103) goto L24;
        r104 = r104 + 1;
    L24:
        r100.append("");
        goto L26
    }

    public final String joinToString(CharSequence r210, CharSequence r211, Function1<? super Long, ? extends CharSequence> r212) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "transform");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
        int r105 = 0;
    L5:
        long r110 = r102[r104];
        if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r111 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L21;
        if ((255 & r110) >= 128) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L20;
        long r114 = r101[(r104 << 3) + r112];
        if (r105 == (-1)) goto L16;
        if (r105 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r212.invoke(Long.valueOf(r114)));
        r105 = r105 + 1;
        goto L20
    L16:
        r100.append("...");
    L26:
        return r100.toString();
    L20:
        r110 = r110 >> 8;
        r112 = r112 + 1;
        goto L8
    L12:
        r113 = false;
        goto L13
    L21:
        if (r111 != 8) goto L24;
    L22:
        if (r104 == r103) goto L24;
        r104 = r104 + 1;
    L24:
        r100.append("");
        goto L26
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, Function1<? super Long, ? extends CharSequence> r213) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r213, "transform");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
        int r110 = 0;
    L5:
        long r111 = r102[r104];
        if (((((~r111) << 7) & r111) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r112 = 8 - ((~(r104 - r103)) >>> 31);
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L21;
        if ((r111 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L20;
        long r115 = r101[(r104 << 3) + r113];
        if (r110 == (-1)) goto L16;
        if (r110 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r213.invoke(Long.valueOf(r115)));
        r110 = r110 + 1;
        goto L20
    L16:
        r100.append("...");
    L26:
        return r100.toString();
    L20:
        r111 = r111 >> 8;
        r113 = r113 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L21:
        if (r112 != 8) goto L24;
    L22:
        if (r104 == r103) goto L24;
        r104 = r104 + 1;
    L24:
        r100.append(r212);
        goto L26
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, int r213, CharSequence r214) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r214, "truncated");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L28;
        int r104 = 0;
        int r110 = 0;
    L5:
        long r111 = r102[r104];
        if (((((~r111) << 7) & r111) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r112 = 8 - ((~(r104 - r103)) >>> 31);
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L22;
        if ((r111 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L21;
        long r105 = r101[(r104 << 3) + r113];
        if (r110 == r213) goto L16;
        if (r110 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r105);
        r110 = r110 + 1;
        goto L21
    L16:
        r100.append(r214);
    L30:
        return r100.toString();
    L21:
        r111 = r111 >> 8;
        r113 = r113 + 1;
        r104 = r104;
        goto L8
    L12:
        r114 = false;
        goto L13
    L22:
        int r115 = r104;
        if (r112 != 8) goto L28;
        int r106 = r115;
    L26:
        if (r106 == r103) goto L28;
        r104 = r106 + 1;
        goto L5
    L25:
        r106 = r104;
    L28:
        r100.append(r212);
        goto L30
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, int r213, Function1<? super Long, ? extends CharSequence> r214) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r214, "transform");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L28;
        int r104 = 0;
        int r110 = 0;
    L5:
        long r111 = r102[r104];
        if (((((~r111) << 7) & r111) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r112 = 8;
        int r113 = 8 - ((~(r104 - r103)) >>> 31);
        int r114 = 0;
    L8:
        if (r114 >= r113) goto L23;
        if ((r111 & 255) >= 128) goto L12;
        boolean r115 = true;
    L13:
        if (r115 == false) goto L21;
        long r116 = r101[(r104 << 3) + r114];
        if (r110 == r213) goto L16;
        if (r110 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r214.invoke(Long.valueOf(r116)));
        r110 = r110 + 1;
        r112 = 8;
        goto L21
    L16:
        r100.append("...");
    L30:
        return r100.toString();
    L21:
        r111 = r111 >> r112;
        r114 = r114 + 1;
        goto L8
    L12:
        r115 = false;
        goto L13
    L23:
        if (r113 != r112) goto L28;
    L26:
        if (r104 == r103) goto L28;
        r104 = r104 + 1;
    L28:
        r100.append(r212);
        goto L30
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, int r213, CharSequence r214, Function1<? super Long, ? extends CharSequence> r215) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r214, "truncated");
        Intrinsics.checkNotNullParameter(r215, "transform");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        long[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L28;
        int r110 = 0;
        int r111 = 0;
    L5:
        long r112 = r102[r110];
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r113 = 8 - ((~(r110 - r103)) >>> 31);
        int r104 = 0;
    L8:
        if (r104 >= r113) goto L23;
        if ((r112 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L21;
        long r115 = r101[(r110 << 3) + r104];
        if (r111 == r213) goto L16;
        if (r111 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r215.invoke(Long.valueOf(r115)));
        r111 = r111 + 1;
        goto L21
    L16:
        r100.append(r214);
    L30:
        return r100.toString();
    L21:
        r112 = r112 >> 8;
        r104 = r104 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L23:
        if (r113 != 8) goto L28;
    L26:
        if (r110 == r103) goto L28;
        r110 = r110 + 1;
    L28:
        r100.append(r212);
        goto L30
    }

    public static /* synthetic */ String joinToString$default(LongSet r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, int r106, Object r110) {
        if (r110 != null) goto L24;
        if ((r106 & 1) == 0) goto L6;
        r101 = ", ";
    L6:
        CharSequence r107 = "";
        if ((r106 & 2) == 0) goto L9;
        CharSequence r111 = "";
    L11:
        if ((r106 & 4) != 0) goto L15;
        r107 = r103;
    L15:
        if ((r106 & 8) == 0) goto L17;
        int r108 = -1;
    L19:
        if ((r106 & 16) == 0) goto L21;
        r105 = "...";
    L21:
        CharSequence r109 = r105;
        return r100.joinToString(r101, r111, r107, r108, r109);
    L17:
        r108 = r104;
        goto L19
    L9:
        r111 = r102;
        goto L11
    L24:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static /* synthetic */ String joinToString$default(LongSet r210, CharSequence r211, CharSequence r212, CharSequence r213, int r214, CharSequence r215, Function1 r216, int r217, Object r218) {
        if (r218 != null) goto L50;
        if ((r217 & 1) == 0) goto L7;
        CharSequence r100 = ", ";
    L8:
        CharSequence r101 = "";
        if ((r217 & 2) == 0) goto L11;
        CharSequence r102 = "";
    L13:
        if ((r217 & 4) != 0) goto L17;
        r101 = r213;
    L17:
        if ((r217 & 8) == 0) goto L19;
        int r103 = -1;
    L21:
        if ((r217 & 16) == 0) goto L23;
        CharSequence r104 = "...";
    L24:
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r102, "prefix");
        Intrinsics.checkNotNullParameter(r101, "postfix");
        Intrinsics.checkNotNullParameter(r104, "truncated");
        Intrinsics.checkNotNullParameter(r216, "transform");
        StringBuilder r105 = new StringBuilder();
        r105.append(r102);
        long[] r106 = r210.elements;
        long[] r107 = r210.metadata;
        int r108 = r107.length - 2;
        if (r108 < 0) goto L46;
        int r110 = 0;
        int r111 = 0;
    L27:
        long r112 = r107[r110];
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L44;
        int r113 = 8;
        int r114 = 8 - ((~(r110 - r108)) >>> 31);
        int r109 = 0;
    L30:
        if (r109 >= r114) goto L43;
        if ((r112 & 255) >= 128) goto L34;
        boolean r115 = true;
    L35:
        if (r115 == false) goto L42;
        long r116 = r106[(r110 << 3) + r109];
        if (r111 == r103) goto L38;
        if (r111 == 0) goto L41;
        r105.append(r100);
    L41:
        r105.append((CharSequence) r216.invoke(Long.valueOf(r116)));
        r111 = r111 + 1;
        r113 = 8;
        goto L42
    L38:
        r105.append(r104);
    L48:
        return r105.toString();
    L42:
        r112 = r112 >> r113;
        r109 = r109 + 1;
        goto L30
    L34:
        r115 = false;
        goto L35
    L43:
        if (r114 != r113) goto L46;
    L44:
        if (r110 == r108) goto L46;
        r110 = r110 + 1;
    L46:
        r105.append(r101);
        goto L48
    L23:
        r104 = r215;
        goto L24
    L19:
        r103 = r214;
        goto L21
    L11:
        r102 = r212;
        goto L13
    L7:
        r100 = r211;
        goto L8
    L50:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
