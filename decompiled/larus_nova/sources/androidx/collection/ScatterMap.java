package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!J'\u0010\"\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010$J/\u0010%\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020&0(H\u0081\bø\u0001\u0000JD\u0010,\u001a\u00020&26\u0010'\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020&0-H\u0086\bø\u0001\u0000J/\u0010/\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020&0(H\u0086\bø\u0001\u0000J/\u00100\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020&0(H\u0086\bø\u0001\u0000J&\u00101\u001a\u00020\u00182\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00180-H\u0086\bø\u0001\u0000J&\u0010\u0017\u001a\u00020\u00182\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00180-H\u0086\bø\u0001\u0000J\u0006\u00103\u001a\u00020\u0010J&\u00103\u001a\u00020\u00102\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00180-H\u0086\bø\u0001\u0000J\u0016\u00104\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u00105J\u0013\u00107\u001a\u00020\u00182\u0006\u0010.\u001a\u00028\u0001¢\u0006\u0002\u00105Jv\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020\u00102\b\b\u0002\u0010?\u001a\u00020;2:\b\u0002\u0010@\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020;\u0018\u00010-H\u0007J\b\u0010A\u001a\u00020\u0010H\u0016J\u0013\u0010B\u001a\u00020\u00182\b\u0010C\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010D\u001a\u000209H\u0016J\r\u0010E\u001a\u000209H\u0000¢\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\bH\u0010IJ\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010KR\u0018\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0005R\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\u000b\u0010\u0005R\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013\u0082\u0001\u0001L\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006M"}, d2 = {"Landroidx/collection/ScatterMap;", "K", "V", "", "<init>", "()V", "metadata", "", "getMetadata$annotations", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "values", "getValues$annotations", "_capacity", "", "capacity", "getCapacity", "()I", "_size", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", MonitorConstants.CONNECT_TYPE_GET, "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "forEachIndexed", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "forEach", "Lkotlin/Function2;", "value", "forEachKey", "forEachValue", "all", "predicate", "count", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "joinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "transform", "hashCode", "equals", "other", "toString", "asDebugString", "asDebugString$collection", "findKeyIndex", "findKeyIndex$collection", "(Ljava/lang/Object;)I", "asMap", "", "Landroidx/collection/MutableScatterMap;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ScatterMap<K, V> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public Object[] values;

    public /* synthetic */ ScatterMap(DefaultConstructorMarker r100) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
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

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String asDebugString$collection() {
        StringBuilder r100 = new StringBuilder("{metadata=[");
        int r101 = getCapacity();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L13;
        long r104 = (this.metadata[r103 >> 3] >> ((r103 & 7) << 3)) & 255;
        if (r104 != 128) goto L9;
        r100.append("Empty");
    L12:
        r100.append(", ");
        r103 = r103 + 1;
        goto L4
    L9:
        if (r104 != 254) goto L11;
        r100.append("Deleted");
        goto L12
    L11:
        r100.append(r104);
        goto L12
    L13:
        r100.append("], keys=[");
        int r105 = this.keys.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L16;
        r100.append(this.keys[r106]);
        r100.append(", ");
        r106 = r106 + 1;
        goto L14
    L16:
        r100.append("], values=[");
        int r107 = this.values.length;
    L17:
        if (r102 >= r107) goto L19;
        r100.append(this.values[r102]);
        r100.append(", ");
        r102 = r102 + 1;
        goto L17
    L19:
        r100.append("]}");
        return r100.toString();
    }

    public final Map<K, V> asMap() {
        return new MapWrapper(this);
    }

    public int hashCode() {
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        int r104 = 0;
        if (r103 < 0) goto L28;
        int r105 = 0;
        int r106 = 0;
    L5:
        long r107 = r102[r105];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r110 = 8 - ((~(r105 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L23;
        if ((255 & r107) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L22;
        int r113 = (r105 << 3) + r111;
        Object r114 = r100[r113];
        Object r115 = r101[r113];
        if (r114 == null) goto L17;
        int r116 = r114.hashCode();
    L18:
        if (r115 == null) goto L20;
        int r117 = r115.hashCode();
    L21:
        r106 = r106 + (r117 ^ r116);
        goto L22
    L20:
        r117 = 0;
        goto L21
    L17:
        r116 = 0;
    L22:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L23:
        if (r110 == 8) goto L24;
        return r106;
    L24:
        if (r105 == r103) goto L26;
        r105 = r105 + 1;
        goto L5
    L26:
        r104 = r106;
    L28:
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
        Object[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L31;
        int r105 = 0;
        int r106 = 0;
    L9:
        long r107 = r103[r105];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L29;
        int r110 = 8 - ((~(r105 - r104)) >>> 31);
        int r111 = 0;
    L12:
        if (r111 >= r110) goto L28;
        if ((255 & r107) >= 128) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == false) goto L27;
        int r113 = (r105 << 3) + r111;
        Object r114 = r101[r113];
        Object r115 = r102[r113];
        if (r114 != this) goto L21;
        r114 = "(this)";
    L21:
        r100.append(r114);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r115 != this) goto L24;
        r115 = "(this)";
    L24:
        r100.append(r115);
        r106 = r106 + 1;
        if (r106 >= this._size) goto L27;
        r100.append(", ");
    L27:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L12
    L16:
        r112 = false;
        goto L17
    L28:
        if (r110 != 8) goto L31;
    L29:
        if (r105 == r104) goto L31;
        r105 = r105 + 1;
    L31:
        r100.append('}');
        return r100.toString();
    }

    private ScatterMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        Object[] r100 = ContainerHelpersKt.EMPTY_OBJECTS;
        this.keys = r100;
        this.values = r100;
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

    public final boolean all(Function2<? super K, ? super V, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
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
        if (r210.invoke(r100[r113], r101[r113]).booleanValue() == true) goto L17;
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

    public final boolean any(Function2<? super K, ? super V, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
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
        if (r210.invoke(r100[r113], r101[r113]).booleanValue() == false) goto L17;
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

    public final boolean contains(K r110) {
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
        if (Intrinsics.areEqual(this.keys[r115], r110) == true) goto L20;
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

    public final boolean containsKey(K r110) {
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
        if (Intrinsics.areEqual(this.keys[r115], r110) == true) goto L20;
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

    public final boolean containsValue(V r110) {
        Object[] r100 = this.values;
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
        if (Intrinsics.areEqual(r110, r100[(r103 << 3) + r111]) == false) goto L18;
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

    public final int count(Function2<? super K, ? super V, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
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
        if (r210.invoke(r100[r113], r101[r113]).booleanValue() == false) goto L17;
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
        if ((r210 instanceof ScatterMap) == true) goto L8;
        return false;
    L8:
        ScatterMap r100 = (ScatterMap) r210;
        if (r100.getSize() == getSize()) goto L11;
        return false;
    L11:
        Object[] r101 = this.keys;
        Object[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L37;
        int r105 = 0;
    L14:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L35;
        int r110 = 8 - ((~(r105 - r104)) >>> 31);
        int r111 = 0;
    L17:
        if (r111 >= r110) goto L34;
        if ((255 & r106) >= 128) goto L21;
        boolean r112 = true;
    L22:
        if (r112 == false) goto L33;
        int r113 = (r105 << 3) + r111;
        Object r114 = r101[r113];
        Object r115 = r102[r113];
        if (r115 != null) goto L31;
        if (r100.get(r114) != null) goto L29;
        if (r100.containsKey(r114) == true) goto L33;
    L29:
        return false;
    L31:
        if (Intrinsics.areEqual(r115, r100.get(r114)) == true) goto L33;
        return false;
    L33:
        r106 = r106 >> 8;
        r111 = r111 + 1;
        goto L17
    L21:
        r112 = false;
        goto L22
    L34:
        if (r110 != 8) goto L37;
    L35:
        if (r105 == r104) goto L37;
        r105 = r105 + 1;
    L37:
        return true;
    }

    public final int findKeyIndex$collection(K r110) {
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

    public final void forEach(Function2<? super K, ? super V, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
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
        r110.invoke(r100[r114], r101[r114]);
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

    public final void forEachValue(Function1<? super V, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.values;
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

    public final V get(K r110) {
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
        if (Intrinsics.areEqual(this.keys[r115], r110) == true) goto L20;
        r113 = r113 & (r113 - 1);
    L20:
        if (r115 >= 0) goto L28;
        return null;
    L28:
        return (V) this.values[r115];
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

    public final V getOrDefault(K r110, V r111) {
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
        long r112 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r113 = (((long) r103) * ScatterMapKt.BitmaskLsb) ^ r112;
        long r114 = ((~r113) & (r113 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r114 == 0) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        int r116 = ((Long.numberOfTrailingZeros(r114) >> 3) + r105) & r104;
        if (Intrinsics.areEqual(this.keys[r116], r110) == true) goto L20;
        r114 = r114 & (r114 - 1);
    L20:
        if (r116 >= 0) goto L22;
        return r111;
    L22:
        return (V) this.values[r116];
    L18:
        if (((r112 & ((~r112) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r106 = r106 + 8;
        r105 = (r105 + r106) & r104;
        goto L7
    L19:
        r116 = -1;
        goto L20
    L11:
        r115 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public final V getOrElse(K r100, Function0<? extends V> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        V r102 = get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return r101.invoke();
    }

    public final String joinToString(CharSequence r210, CharSequence r211, CharSequence r212, int r213, CharSequence r214, Function2<? super K, ? super V, ? extends CharSequence> r215) {
        Intrinsics.checkNotNullParameter(r210, "separator");
        Intrinsics.checkNotNullParameter(r211, "prefix");
        Intrinsics.checkNotNullParameter(r212, "postfix");
        Intrinsics.checkNotNullParameter(r214, "truncated");
        StringBuilder r100 = new StringBuilder();
        r100.append(r211);
        Object[] r101 = this.keys;
        Object[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L32;
        int r110 = 0;
        int r111 = 0;
    L5:
        long r112 = r103[r110];
        int r113 = r110;
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r114 = 8 - ((~(r113 - r104)) >>> 31);
        int r115 = 0;
    L8:
        if (r115 >= r114) goto L25;
        if ((r112 & 255) >= 128) goto L12;
        boolean r116 = true;
    L13:
        if (r116 == false) goto L24;
        int r117 = (r113 << 3) + r115;
        Object r105 = r101[r117];
        Object r106 = r102[r117];
        if (r111 == r213) goto L16;
        if (r111 == 0) goto L19;
        r100.append(r210);
    L19:
        if (r215 != null) goto L21;
        r100.append(r105);
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(r106);
    L22:
        r111 = r111 + 1;
        goto L24
    L21:
        r100.append(r215.invoke(r105, r106));
        goto L22
    L16:
        r100.append(r214);
    L34:
        return r100.toString();
    L24:
        r112 = r112 >> 8;
        r115 = r115 + 1;
        r102 = r102;
        r101 = r101;
        goto L8
    L12:
        r116 = false;
        goto L13
    L25:
        Object[] r118 = r101;
        Object[] r119 = r102;
        if (r114 != 8) goto L32;
    L30:
        if (r113 == r104) goto L32;
        r110 = r113 + 1;
        r102 = r119;
        r101 = r118;
        goto L5
    L28:
        r118 = r101;
        r119 = r102;
    L32:
        r100.append(r212);
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String joinToString$default(ScatterMap r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function2 r110, int r111, Object r112) {
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
        Function2 r109 = r110;
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
