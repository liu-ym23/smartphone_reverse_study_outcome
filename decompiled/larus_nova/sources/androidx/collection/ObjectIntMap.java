package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u001b\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0002\u0010#J'\u0010$\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00028\u00002\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100%H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010&J/\u0010'\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020(0*H\u0081\bø\u0001\u0000JD\u0010.\u001a\u00020(26\u0010)\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020(0/H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020(0*H\u0086\bø\u0001\u0000J/\u00102\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020(0*H\u0086\bø\u0001\u0000J&\u00103\u001a\u00020\u001a2\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a0/H\u0086\bø\u0001\u0000J&\u0010\u0019\u001a\u00020\u001a2\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a0/H\u0086\bø\u0001\u0000J\u0006\u00105\u001a\u00020\u0010J&\u00105\u001a\u00020\u00102\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a0/H\u0086\bø\u0001\u0000J\u0016\u00106\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u00107J\u000e\u00109\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u0010J:\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020=H\u0007Jx\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020=28\b\u0004\u0010B\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020=0/H\u0087\bø\u0001\u0000J\b\u0010C\u001a\u00020\u0010H\u0016J\u0013\u0010D\u001a\u00020\u001a2\b\u0010E\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010F\u001a\u00020;H\u0016J\u0015\u0010G\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010 R\u0018\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\n\u0010\u0004R\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0004R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0004R\u0011\u0010\u0017\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014\u0082\u0001\u0001H\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"Landroidx/collection/ObjectIntMap;", "K", "", "<init>", "()V", "metadata", "", "getMetadata$annotations", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "values", "", "getValues$annotations", "_capacity", "", "get_capacity$collection$annotations", "capacity", "getCapacity", "()I", "_size", "get_size$collection$annotations", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", MonitorConstants.CONNECT_TYPE_GET, "key", "(Ljava/lang/Object;)I", "getOrDefault", "defaultValue", "(Ljava/lang/Object;I)I", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)I", "forEachIndexed", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "forEach", "Lkotlin/Function2;", "value", "forEachKey", "forEachValue", "all", "predicate", "count", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "joinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "transform", "hashCode", "equals", "other", "toString", "findKeyIndex", "Landroidx/collection/MutableObjectIntMap;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObjectIntMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public int[] values;

    public /* synthetic */ ObjectIntMap(DefaultConstructorMarker r100) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
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

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        Object[] r100 = this.keys;
        int[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        int r104 = 0;
        if (r103 < 0) goto L25;
        int r105 = 0;
        int r106 = 0;
    L5:
        long r107 = r102[r105];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r110 = 8 - ((~(r105 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L20;
        if ((255 & r107) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L19;
        int r113 = (r105 << 3) + r111;
        Object r114 = r100[r113];
        int r115 = r101[r113];
        if (r114 == null) goto L17;
        int r116 = r114.hashCode();
    L18:
        r106 = r106 + (r115 ^ r116);
        goto L19
    L17:
        r116 = 0;
    L19:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L20:
        if (r110 == 8) goto L21;
        return r106;
    L21:
        if (r105 == r103) goto L23;
        r105 = r105 + 1;
        goto L5
    L23:
        r104 = r106;
    L25:
        return r104;
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

    public String toString() {
        if (isEmpty() == false) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        StringBuilder r100 = new StringBuilder("{");
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L28;
        int r105 = 0;
        int r106 = 0;
    L9:
        long r107 = r103[r105];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r110 = 8 - ((~(r105 - r104)) >>> 31);
        int r111 = 0;
    L12:
        if (r111 >= r110) goto L25;
        if ((255 & r107) >= 128) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == false) goto L24;
        int r113 = (r105 << 3) + r111;
        Object r114 = r101[r113];
        int r115 = r102[r113];
        if (r114 != this) goto L21;
        r114 = "(this)";
    L21:
        r100.append(r114);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r115);
        r106 = r106 + 1;
        if (r106 >= this._size) goto L24;
        r100.append(", ");
    L24:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L12
    L16:
        r112 = false;
        goto L17
    L25:
        if (r110 != 8) goto L28;
    L26:
        if (r105 == r104) goto L28;
        r105 = r105 + 1;
    L28:
        r100.append('}');
        return r100.toString();
    }

    private ObjectIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = IntSetKt.getEmptyIntArray();
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

    public final boolean all(Function2<? super K, ? super Integer, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        int[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L21;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        if (r210.invoke(r100[r113], Integer.valueOf(r101[r113])).booleanValue() == true) goto L17;
        return false;
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 != 8) goto L21;
    L19:
        if (r104 == r103) goto L21;
        r104 = r104 + 1;
    L21:
        return true;
    }

    public final boolean any(Function2<? super K, ? super Integer, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        int[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L21;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        if (r210.invoke(r100[r113], Integer.valueOf(r101[r113])).booleanValue() == false) goto L17;
        return true;
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 != 8) goto L21;
    L19:
        if (r104 == r103) goto L21;
        r104 = r104 + 1;
    L21:
        return false;
    }

    public final boolean contains(K r100) {
        return containsKey(r100);
    }

    public final boolean containsKey(K r100) {
        if (findKeyIndex(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsValue(int r110) {
        int[] r100 = this.values;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L25;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L20;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L18;
        if (r110 != r100[(r103 << 3) + r111]) goto L18;
        return true;
    L18:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L20:
        if (r105 != 8) goto L25;
    L23:
        if (r103 == r102) goto L25;
        r103 = r103 + 1;
    L25:
        return false;
    }

    public final int count(Function2<? super K, ? super Integer, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        int[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        int r104 = 0;
        if (r103 < 0) goto L23;
        int r105 = 0;
        int r106 = 0;
    L5:
        long r107 = r102[r105];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r105 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r107) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r105 << 3) + r111;
        if (r210.invoke(r100[r113], Integer.valueOf(r101[r113])).booleanValue() == false) goto L17;
        r106 = r106 + 1;
    L17:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 == 8) goto L19;
        return r106;
    L19:
        if (r105 == r103) goto L21;
        r105 = r105 + 1;
        goto L5
    L21:
        r104 = r106;
    L23:
        return r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r210) {
        if (r210 != this) goto L6;
        return true;
    L6:
        if ((r210 instanceof ObjectIntMap) == true) goto L8;
        return false;
    L8:
        ObjectIntMap r100 = (ObjectIntMap) r210;
        if (r100.getSize() == getSize()) goto L11;
        return false;
    L11:
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L32;
        int r105 = 0;
    L14:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L30;
        int r110 = 8 - ((~(r105 - r104)) >>> 31);
        int r111 = 0;
    L17:
        if (r111 >= r110) goto L29;
        if ((255 & r106) >= 128) goto L21;
        boolean r112 = true;
    L22:
        if (r112 == false) goto L28;
        int r113 = (r105 << 3) + r111;
        Object r114 = r101[r113];
        int r115 = r102[r113];
        int r116 = r100.findKeyIndex(r114);
        if (r116 < 0) goto L27;
        if (r115 == r100.values[r116]) goto L28;
    L27:
        return false;
    L28:
        r106 = r106 >> 8;
        r111 = r111 + 1;
        goto L17
    L21:
        r112 = false;
        goto L22
    L29:
        if (r110 == 8) goto L30;
        return true;
    L30:
        if (r105 == r104) goto L42;
        r105 = r105 + 1;
        goto L14
    L42:
        return true;
    L32:
        return true;
    }

    public final int findKeyIndex(K r110) {
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
        if (Intrinsics.areEqual(this.keys[r115], r110) == true) goto L15;
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

    public final void forEach(Function2<? super K, ? super Integer, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.keys;
        int[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L19;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r111 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L16;
        if ((255 & r105) >= 128) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L15;
        int r114 = (r104 << 3) + r112;
        r110.invoke(r100[r114], Integer.valueOf(r101[r114]));
    L15:
        r105 = r105 >> 8;
        r112 = r112 + 1;
        goto L8
    L12:
        r113 = false;
        goto L13
    L16:
        if (r111 == 8) goto L17;
        return;
    L17:
        if (r104 == r103) goto L26;
        r104 = r104 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> r110) {
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

    public final void forEachKey(Function1<? super K, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.keys;
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

    public final void forEachValue(Function1<? super Integer, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        int[] r100 = this.values;
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
        r110.invoke(Integer.valueOf(r100[(r103 << 3) + r111]));
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

    public final int get(K r100) {
        int r101 = findKeyIndex(r100);
        if (r101 >= 0) goto L6;
        RuntimeHelpersKt.throwNoSuchElementException("There is no key " + r100 + " in the map");
    L6:
        return this.values[r101];
    }

    public final String joinToString(Function2<? super K, ? super Integer, ? extends CharSequence> r210) {
        Intrinsics.checkNotNullParameter(r210, "transform");
        StringBuilder r100 = new StringBuilder("");
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L25;
        int r105 = 0;
        int r110 = 0;
    L5:
        long r111 = r103[r105];
        if (((((~r111) << 7) & r111) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r112 = 8 - ((~(r105 - r104)) >>> 31);
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L22;
        if ((r111 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L20;
        int r115 = (r105 << 3) + r113;
        Object r106 = r101[r115];
        int r116 = r102[r115];
        if (r110 == (-1)) goto L16;
        if (r110 == 0) goto L19;
        r100.append(", ");
    L19:
        r100.append(r210.invoke(r106, Integer.valueOf(r116)));
        r110 = r110 + 1;
        goto L20
    L16:
        r100.append("...");
    L27:
        return r100.toString();
    L20:
        r111 = r111 >> 8;
        r113 = r113 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L22:
        if (r112 != 8) goto L25;
    L23:
        if (r105 == r104) goto L25;
        r105 = r105 + 1;
    L25:
        r100.append("");
        goto L27
    }

    public final int getOrDefault(K r100, int r101) {
        int r102 = findKeyIndex(r100);
        if (r102 >= 0) goto L5;
        return r101;
    L5:
        return this.values[r102];
    }

    public final int getOrElse(K r100, Function0<Integer> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        int r102 = findKeyIndex(r100);
        if (r102 < 0) goto L7;
        return this.values[r102];
    L7:
        return r101.invoke().intValue();
    }

    public final String joinToString(CharSequence r210, Function2<? super K, ? super Integer, ? extends CharSequence> r211) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "transform");
        StringBuilder r100 = new StringBuilder("");
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L25;
        int r110 = 0;
        int r111 = 0;
    L5:
        long r112 = r103[r110];
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r113 = 8 - ((~(r110 - r104)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r113) goto L22;
        if ((r112 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L20;
        int r115 = (r110 << 3) + r105;
        Object r116 = r101[r115];
        int r117 = r102[r115];
        if (r111 == (-1)) goto L16;
        if (r111 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r211.invoke(r116, Integer.valueOf(r117)));
        r111 = r111 + 1;
        goto L20
    L16:
        r100.append("...");
    L27:
        return r100.toString();
    L20:
        r112 = r112 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L22:
        if (r113 != 8) goto L25;
    L23:
        if (r110 == r104) goto L25;
        r110 = r110 + 1;
    L25:
        r100.append("");
        goto L27
    }

    public final String joinToString(CharSequence r210, CharSequence r211, Function2<? super K, ? super Integer, ? extends CharSequence> r212) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "transform");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L25;
        int r105 = 0;
        int r110 = 0;
    L5:
        long r111 = r103[r105];
        if (((((~r111) << 7) & r111) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r112 = 8 - ((~(r105 - r104)) >>> 31);
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L22;
        if ((r111 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L20;
        int r115 = (r105 << 3) + r113;
        Object r106 = r101[r115];
        int r116 = r102[r115];
        if (r110 == (-1)) goto L16;
        if (r110 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r212.invoke(r106, Integer.valueOf(r116)));
        r110 = r110 + 1;
        goto L20
    L16:
        r100.append("...");
    L27:
        return r100.toString();
    L20:
        r111 = r111 >> 8;
        r113 = r113 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L22:
        if (r112 != 8) goto L25;
    L23:
        if (r105 == r104) goto L25;
        r105 = r105 + 1;
    L25:
        r100.append("");
        goto L27
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, Function2<? super K, ? super Integer, ? extends CharSequence> r213) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r213, "transform");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L25;
        int r110 = 0;
        int r111 = 0;
    L5:
        long r112 = r103[r110];
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r113 = 8 - ((~(r110 - r104)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r113) goto L22;
        if ((r112 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L20;
        int r115 = (r110 << 3) + r105;
        Object r116 = r101[r115];
        int r117 = r102[r115];
        if (r111 == (-1)) goto L16;
        if (r111 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r213.invoke(r116, Integer.valueOf(r117)));
        r111 = r111 + 1;
        goto L20
    L16:
        r100.append("...");
    L27:
        return r100.toString();
    L20:
        r112 = r112 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L22:
        if (r113 != 8) goto L25;
    L23:
        if (r110 == r104) goto L25;
        r110 = r110 + 1;
    L25:
        r100.append(r212);
        goto L27
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, int r213, CharSequence r214) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r214, "truncated");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L28;
        int r110 = 0;
        int r111 = 0;
    L5:
        long r112 = r103[r110];
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r113 = 8 - ((~(r110 - r104)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r113) goto L22;
        if ((r112 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L21;
        int r115 = (r110 << 3) + r105;
        Object r116 = r101[r115];
        int r106 = r102[r115];
        if (r111 == r213) goto L16;
        if (r111 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r116);
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(r106);
        r111 = r111 + 1;
        goto L21
    L16:
        r100.append(r214);
    L30:
        return r100.toString();
    L21:
        r112 = r112 >> 8;
        r105 = r105 + 1;
        r101 = r101;
        goto L8
    L12:
        r114 = false;
        goto L13
    L22:
        Object[] r117 = r101;
        if (r113 != 8) goto L28;
    L26:
        if (r110 == r104) goto L28;
        r110 = r110 + 1;
        r101 = r117;
        goto L5
    L25:
        r117 = r101;
    L28:
        r100.append(r212);
        goto L30
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, int r213, Function2<? super K, ? super Integer, ? extends CharSequence> r214) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r214, "transform");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        Object[] r101 = this.keys;
        int[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L25;
        int r110 = 0;
        int r111 = 0;
    L5:
        long r112 = r103[r110];
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r113 = 8 - ((~(r110 - r104)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r113) goto L22;
        if ((r112 & 255) >= 128) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L20;
        int r115 = (r110 << 3) + r105;
        Object r116 = r101[r115];
        int r117 = r102[r115];
        if (r111 == r213) goto L16;
        if (r111 == 0) goto L19;
        r100.append(r210);
    L19:
        r100.append(r214.invoke(r116, Integer.valueOf(r117)));
        r111 = r111 + 1;
        goto L20
    L16:
        r100.append("...");
    L27:
        return r100.toString();
    L20:
        r112 = r112 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r114 = false;
        goto L13
    L22:
        if (r113 != 8) goto L25;
    L23:
        if (r110 == r104) goto L25;
        r110 = r110 + 1;
    L25:
        r100.append(r212);
        goto L27
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, int r213, CharSequence r214, Function2<? super K, ? super Integer, ? extends CharSequence> r215) {
        CharSequence r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r214, "truncated");
        Intrinsics.checkNotNullParameter(r215, "transform");
        StringBuilder r101 = new StringBuilder();
        r101.append(r211);
        Object[] r102 = this.keys;
        int[] r103 = this.values;
        long[] r104 = this.metadata;
        int r105 = r104.length - 2;
        if (r105 < 0) goto L29;
        int r110 = 0;
        int r111 = 0;
    L5:
        long r112 = r104[r110];
        int r113 = r110;
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r114 = 8 - ((~(r113 - r105)) >>> 31);
        int r115 = 0;
    L8:
        if (r115 >= r114) goto L22;
        if ((r112 & 255) >= 128) goto L12;
        boolean r116 = true;
    L13:
        if (r116 == false) goto L21;
        int r117 = (r113 << 3) + r115;
        Object r106 = r102[r117];
        int r118 = r103[r117];
        if (r111 == r213) goto L16;
        if (r111 == 0) goto L19;
        r101.append(r100);
    L19:
        r101.append(r215.invoke(r106, Integer.valueOf(r118)));
        r111 = r111 + 1;
        goto L21
    L16:
        r101.append(r214);
    L31:
        return r101.toString();
    L21:
        r112 = r112 >> 8;
        r115 = r115 + 1;
        r100 = r210;
        r102 = r102;
        goto L8
    L12:
        r116 = false;
        goto L13
    L22:
        Object[] r119 = r102;
        if (r114 != 8) goto L29;
    L27:
        if (r113 == r105) goto L29;
        r110 = r113 + 1;
        r100 = r210;
        r102 = r119;
        goto L5
    L25:
        r119 = r102;
    L29:
        r101.append(r212);
        goto L31
    }

    public static /* synthetic */ String joinToString$default(ObjectIntMap r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, int r106, Object r110) {
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

    public static /* synthetic */ String joinToString$default(ObjectIntMap r210, CharSequence r211, CharSequence r212, CharSequence r213, int r214, CharSequence r215, Function2 r216, int r217, Object r218) {
        if (r218 != null) goto L55;
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
        Object[] r106 = r210.keys;
        int[] r107 = r210.values;
        long[] r108 = r210.metadata;
        int r109 = r108.length - 2;
        if (r109 < 0) goto L51;
        int r110 = 0;
        int r111 = 0;
    L27:
        long r112 = r108[r110];
        int r219 = r110;
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L47;
        int r113 = 8 - ((~(r219 - r109)) >>> 31);
        int r114 = 0;
    L30:
        if (r114 >= r113) goto L44;
        if ((r112 & 255) >= 128) goto L34;
        boolean r115 = true;
    L35:
        if (r115 == false) goto L43;
        int r116 = (r219 << 3) + r114;
        Object r117 = r106[r116];
        int r118 = r107[r116];
        if (r111 == r103) goto L38;
        if (r111 == 0) goto L41;
        r105.append(r100);
    L41:
        r105.append((CharSequence) r216.invoke(r117, Integer.valueOf(r118)));
        r111 = r111 + 1;
        goto L43
    L38:
        r105.append(r104);
    L53:
        return r105.toString();
    L43:
        r112 = r112 >> 8;
        r114 = r114 + 1;
        r108 = r108;
        goto L30
    L34:
        r115 = false;
        goto L35
    L44:
        long[] r119 = r108;
        if (r113 != 8) goto L51;
    L49:
        if (r219 == r109) goto L51;
        r110 = r219 + 1;
        r108 = r119;
        goto L27
    L47:
        r119 = r108;
    L51:
        r105.append(r101);
        goto L53
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
    L55:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
