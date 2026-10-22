package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000b\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J?\u0010\u001f\u001a\u00028\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&JA\u0010'\u001a\u0004\u0018\u00018\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&J\u000b\u0010(\u001a\u00028\u0000¢\u0006\u0002\u0010 J?\u0010(\u001a\u00028\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&JA\u0010)\u001a\u0004\u0018\u00018\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&J?\u0010*\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020+0\"H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\b.J:\u0010/\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020+0\"H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00100\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020+0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00101\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020+0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00102\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020+0\"H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0086\bJ:\u00105\u001a\u00020\u001b2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001a\u001a\u00020\u001b2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u00106\u001a\u00020\u000fH\u0007J:\u00106\u001a\u00020\u000f2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u00107\u001a\u00020\u001b2\u0006\u0010%\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00108JR\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020\u000f2\b\b\u0002\u0010@\u001a\u00020<2\u0016\b\u0002\u0010A\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020<\u0018\u00010\"H\u0007J\b\u0010B\u001a\u00020\u000fH\u0016J\u0013\u0010C\u001a\u00020\u001b2\b\u0010D\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010E\u001a\u00020:H\u0016J\u0018\u0010F\u001a\u00020\u000f2\u0006\u0010%\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\bG\u0010HJ\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000JR\u0018\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\n\u0010\u0004R\u0018\u0010\f\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0011\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u0012\u0010\u0013\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016\u0082\u0001\u0001K\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006L"}, d2 = {"Landroidx/collection/OrderedScatterSet;", ExifInterface.LONGITUDE_EAST, "", "<init>", "()V", "metadata", "", "getMetadata$annotations", SlcElement.KEY_ELEMENTS, "", "getElements$annotations", "[Ljava/lang/Object;", "nodes", "getNodes$annotations", "head", "", "getHead$annotations", "tail", "getTail$annotations", "_capacity", "capacity", "getCapacity", "()I", "_size", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", SoloKtvContext.SOLO_PAGE_FIRST, "()Ljava/lang/Object;", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "forEachIndex", "", "block", "index", "forEachIndex$collection", "unorderedForEachIndex", "forEach", "forEachReverse", "unorderedForEach", "toList", "", "all", "count", "contains", "(Ljava/lang/Object;)Z", "joinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "transform", "hashCode", "equals", "other", "toString", "findElementIndex", "findElementIndex$collection", "(Ljava/lang/Object;)I", "asSet", "", "Landroidx/collection/MutableOrderedScatterSet;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class OrderedScatterSet<E> {
    public int _capacity;
    public int _size;
    public Object[] elements;
    public int head;
    public long[] metadata;
    public long[] nodes;
    public int tail;

    public /* synthetic */ OrderedScatterSet(DefaultConstructorMarker r100) {
        this();
    }

    public static /* synthetic */ CharSequence a(OrderedScatterSet r100, Object r101) {
        return toString$lambda$16(r100, r101);
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getHead$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getNodes$annotations() {
    }

    public static /* synthetic */ void getTail$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final String joinToString(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        return joinToString$default(this, r110, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        return joinToString$default(this, r110, r111, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        return joinToString$default(this, r110, r111, r112, r113, null, null, 48, null);
    }

    public final String joinToString(CharSequence r110, CharSequence r111, CharSequence r112, int r113, CharSequence r114) {
        Intrinsics.checkNotNullParameter(r110, "separator");
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "postfix");
        Intrinsics.checkNotNullParameter(r114, "truncated");
        return joinToString$default(this, r110, r111, r112, r113, r114, null, 32, null);
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new b(this), 25, null);
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Set<E> asSet() {
        return new OrderedSetWrapper(this);
    }

    public final E first() {
        Object[] r100 = this.elements;
        long[] r101 = this.nodes;
        int r102 = this.tail;
        if (r102 == Integer.MAX_VALUE) goto L6;
        long r103 = r101[r102];
        return (E) r100[r102];
    L6:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        int r100 = (this._capacity * 31) + this._size;
        Object[] r101 = this.elements;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r110 = 0;
    L8:
        if (r110 >= r106) goto L21;
        if ((255 & r105) >= 128) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L20;
        Object r112 = r101[(r104 << 3) + r110];
        if (Intrinsics.areEqual(r112, this) == true) goto L20;
        if (r112 == null) goto L18;
        int r113 = r112.hashCode();
    L19:
        r100 = r100 + r113;
        goto L20
    L18:
        r113 = 0;
    L20:
        r105 = r105 >> 8;
        r110 = r110 + 1;
        goto L8
    L12:
        r111 = false;
        goto L13
    L21:
        if (r106 != 8) goto L24;
    L22:
        if (r104 == r103) goto L24;
        r104 = r104 + 1;
    L24:
        return r100;
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

    public final E last() {
        Object[] r100 = this.elements;
        long[] r101 = this.nodes;
        int r102 = this.head;
        if (r102 == Integer.MAX_VALUE) goto L6;
        long r103 = r101[r102];
        return (E) r100[r102];
    L6:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
        throw new KotlinNothingValueException();
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<E> toList() {
        ArrayList r100 = new ArrayList(getSize());
        Object[] r101 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.tail;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L6;
        int r104 = (int) ((r102[r103] >> 31) & SieveCacheKt.NodeLinkMask);
        r100.add(r101[r103]);
        r103 = r104;
        goto L4
    L6:
        return r100;
    }

    private OrderedScatterSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
    }

    public final int count() {
        return getSize();
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean all(Function1<? super E, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        Object[] r100 = this.elements;
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
        if (r110.invoke(r100[(r103 << 3) + r112]).booleanValue() == true) goto L17;
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

    public final boolean any(Function1<? super E, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        Object[] r100 = this.elements;
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
        if (r110.invoke(r100[(r103 << 3) + r111]).booleanValue() == false) goto L17;
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

    public final boolean contains(E r110) {
        if (r110 == null) goto L5;
        int r100 = r110.hashCode();
    L6:
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        int r102 = r101 ^ (r101 << 16);
        int r103 = r102 & 127;
        int r104 = this._capacity;
        int r105 = (r102 >>> 7) & r104;
        int r106 = 0;
    L7:
        long[] r107 = this.metadata;
        int r108 = r105 >> 3;
        int r109 = (r105 & 7) << 3;
        long r111 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r112 = (((long) r103) * ScatterMapKt.BitmaskLsb) ^ r111;
        long r113 = ((~r112) & (r112 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r113 == 0) goto L11;
        boolean r114 = true;
    L12:
        if (r114 == false) goto L18;
        int r115 = ((Long.numberOfTrailingZeros(r113) >> 3) + r105) & r104;
        if (Intrinsics.areEqual(this.elements[r115], r110) == true) goto L20;
        r113 = r113 & (r113 - 1);
    L20:
        if (r115 < 0) goto L27;
        return true;
    L27:
        return false;
    L18:
        if (((r111 & ((~r111) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r106 = r106 + 8;
        r105 = (r105 + r106) & r104;
        goto L7
    L19:
        r115 = -1;
        goto L20
    L11:
        r114 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public final int count(Function1<? super E, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        Object[] r100 = this.elements;
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
        if (r110.invoke(r100[(r104 << 3) + r112]).booleanValue() == false) goto L17;
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

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r110) {
        if (r110 != this) goto L6;
        return true;
    L6:
        if ((r110 instanceof OrderedScatterSet) == true) goto L8;
        return false;
    L8:
        OrderedScatterSet r100 = (OrderedScatterSet) r110;
        if (r100.getSize() == getSize()) goto L11;
        return false;
    L11:
        Object[] r101 = this.elements;
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

    public final int findElementIndex$collection(E r110) {
        if (r110 == null) goto L5;
        int r100 = r110.hashCode();
    L6:
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        int r102 = r101 ^ (r101 << 16);
        int r103 = r102 & 127;
        int r104 = this._capacity;
        int r105 = (r102 >>> 7) & r104;
        int r106 = 0;
    L7:
        long[] r107 = this.metadata;
        int r108 = r105 >> 3;
        int r109 = (r105 & 7) << 3;
        long r111 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r112 = (((long) r103) * ScatterMapKt.BitmaskLsb) ^ r111;
        long r113 = ((~r112) & (r112 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r113 == 0) goto L11;
        boolean r114 = true;
    L12:
        if (r114 == false) goto L18;
        int r115 = ((Long.numberOfTrailingZeros(r113) >> 3) + r105) & r104;
        if (Intrinsics.areEqual(this.elements[r115], r110) == true) goto L15;
        r113 = r113 & (r113 - 1);
        goto L9
    L15:
        return r115;
    L18:
        if (((r111 & ((~r111) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r106 = r106 + 8;
        r105 = (r105 + r106) & r104;
        goto L7
    L19:
        return -1;
    L11:
        r114 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E first(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.tail;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L9;
        int r104 = (int) ((r102[r103] >> 31) & SieveCacheKt.NodeLinkMask);
        ?? r105 = (Object) r101[r103];
        if (r100.invoke(r105).booleanValue() == true) goto L7;
        r103 = r104;
        goto L4
    L7:
        return r105;
    L9:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E firstOrNull(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.tail;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L9;
        int r104 = (int) ((r102[r103] >> 31) & SieveCacheKt.NodeLinkMask);
        ?? r105 = (Object) r101[r103];
        if (r100.invoke(r105).booleanValue() == true) goto L7;
        r103 = r104;
        goto L4
    L7:
        return r105;
    L9:
        return null;
    }

    public final void forEach(Function1<? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Object[] r101 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.tail;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L6;
        int r104 = (int) ((r102[r103] >> 31) & SieveCacheKt.NodeLinkMask);
        r100.invoke(r101[r103]);
        r103 = r104;
        goto L4
    }

    public final void forEachIndex$collection(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        long[] r101 = this.nodes;
        int r102 = this.tail;
    L4:
        if (r102 == Integer.MAX_VALUE) goto L6;
        int r103 = (int) ((r101[r102] >> 31) & SieveCacheKt.NodeLinkMask);
        r100.invoke(Integer.valueOf(r102));
        r102 = r103;
        goto L4
    }

    public final void forEachReverse(Function1<? super E, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Object[] r101 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.head;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L6;
        int r104 = (int) (r102[r103] & SieveCacheKt.NodeLinkMask);
        r100.invoke(r101[r103]);
        r103 = r104;
        goto L4
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E last(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.head;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L9;
        int r104 = (int) (r102[r103] & SieveCacheKt.NodeLinkMask);
        ?? r105 = (Object) r101[r103];
        if (r100.invoke(r105).booleanValue() == true) goto L7;
        r103 = r104;
        goto L4
    L7:
        return r105;
    L9:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [E, java.lang.Object] */
    public final E lastOrNull(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Object[] r101 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.head;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L9;
        int r104 = (int) (r102[r103] & SieveCacheKt.NodeLinkMask);
        ?? r105 = (Object) r101[r103];
        if (r100.invoke(r105).booleanValue() == true) goto L7;
        r103 = r104;
        goto L4
    L7:
        return r105;
    L9:
        return null;
    }

    public final void unorderedForEach(Function1<? super E, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.elements;
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
        r110.invoke(r100[(r103 << 3) + r111]);
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

    public final void unorderedForEachIndex(Function1<? super Integer, Unit> r110) {
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

    private static final CharSequence toString$lambda$16(OrderedScatterSet r100, Object r101) {
        if (r101 != r100) goto L5;
        return "(this)";
    L5:
        return String.valueOf(r101);
    }

    public final String joinToString(CharSequence r100, CharSequence r110, CharSequence r111, int r112, CharSequence r113, Function1<? super E, ? extends CharSequence> r114) {
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r110, "prefix");
        Intrinsics.checkNotNullParameter(r111, "postfix");
        Intrinsics.checkNotNullParameter(r113, "truncated");
        StringBuilder r101 = new StringBuilder();
        r101.append(r110);
        Object[] r115 = this.elements;
        long[] r102 = this.nodes;
        int r103 = this.tail;
        int r104 = 0;
    L4:
        if (r103 == Integer.MAX_VALUE) goto L14;
        int r105 = (int) ((r102[r103] >> 31) & SieveCacheKt.NodeLinkMask);
        Object r106 = r115[r103];
        if (r104 == r112) goto L7;
        if (r104 == 0) goto L10;
        r101.append(r100);
    L10:
        if (r114 != null) goto L12;
        r101.append(r106);
    L13:
        r104 = r104 + 1;
        r103 = r105;
        goto L4
    L12:
        r101.append(r114.invoke(r106));
        goto L13
    L7:
        r101.append(r113);
    L16:
        return r101.toString();
    L14:
        r101.append(r111);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String joinToString$default(OrderedScatterSet r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r110, int r111, Object r112) {
        if (r112 != null) goto L27;
        if ((r111 & 1) == 0) goto L6;
        r101 = ", ";
    L6:
        CharSequence r106 = "";
        if ((r111 & 2) == 0) goto L9;
        CharSequence r113 = "";
    L11:
        if ((r111 & 4) != 0) goto L15;
        r106 = r103;
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r107 = -1;
    L19:
        if ((r111 & 16) == 0) goto L21;
        r105 = "...";
    L21:
        CharSequence r108 = r105;
        if ((r111 & 32) == 0) goto L24;
        r110 = null;
    L24:
        Function1 r109 = r110;
        return r100.joinToString(r101, r113, r106, r107, r108, r109);
    L17:
        r107 = r104;
        goto L19
    L9:
        r113 = r102;
        goto L11
    L27:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
