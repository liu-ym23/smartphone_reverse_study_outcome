package androidx.compose.ui.semantics;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001a¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150\u001a¢\u0006\u0002\u0010\u001bJ!\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u001eH\u0096\u0002J*\u0010\u001f\u001a\u00020 \"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010!\u001a\u0002H\u0015H\u0096\u0002¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020$\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002J\r\u0010%\u001a\u00020$H\u0000¢\u0006\u0002\b&J\u0015\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0000H\u0000¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u0000H\u0000¢\u0006\u0002\b2J\u0006\u00103\u001a\u00020\u0000J\u0013\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016R&\u0010\b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010'\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*¨\u0006:"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "<init>", "()V", SlcElement.KEY_PROPS, "Landroidx/collection/MutableScatterMap;", "getProps$ui_release", "()Landroidx/collection/MutableScatterMap;", "mapWrapper", "", "_accessibilityExtraKeys", "Landroidx/collection/MutableScatterSet;", "accessibilityExtraKeys", "Landroidx/collection/ScatterSet;", "getAccessibilityExtraKeys$ui_release", "()Landroidx/collection/ScatterSet;", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "key", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "iterator", "", "set", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "contains", "", "containsImportantForAccessibility", "containsImportantForAccessibility$ui_release", "isMergingSemanticsOfDescendants", "()Z", "setMergingSemanticsOfDescendants", "(Z)V", "isClearingSemantics", "setClearingSemantics", "mergeChild", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "mergeChild$ui_release", "collapsePeer", "peer", "collapsePeer$ui_release", "copy", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {
    public static final int $stable = 8;
    private MutableScatterSet<SemanticsPropertyKey<?>> _accessibilityExtraKeys;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    private Map<SemanticsPropertyKey<?>, ? extends Object> mapWrapper;
    private final MutableScatterMap<SemanticsPropertyKey<?>, Object> props;

    public final boolean containsImportantForAccessibility$ui_release() {
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r100 = this.props;
        Object[] r101 = r100.keys;
        Object[] r102 = r100.values;
        long[] r103 = r100.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L21;
        int r105 = 0;
    L5:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r107 = 8 - ((~(r105 - r104)) >>> 31);
        int r110 = 0;
    L8:
        if (r110 >= r107) goto L18;
        if ((255 & r106) >= 128) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L17;
        int r112 = (r105 << 3) + r110;
        Object r113 = r101[r112];
        Object r114 = r102[r112];
        if (((SemanticsPropertyKey) r113).isImportantForAccessibility$ui_release() == false) goto L17;
        return true;
    L17:
        r106 = r106 >> 8;
        r110 = r110 + 1;
        goto L8
    L12:
        r111 = false;
        goto L13
    L18:
        if (r107 == 8) goto L19;
        return false;
    L19:
        if (r105 == r104) goto L30;
        r105 = r105 + 1;
        goto L5
    L30:
        return false;
    L21:
        return false;
    }

    public final SemanticsConfiguration copy() {
        SemanticsConfiguration r100 = new SemanticsConfiguration();
        r100.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        r100.isClearingSemantics = this.isClearingSemantics;
        r100.props.putAll(this.props);
        return r100;
    }

    public int hashCode() {
        int r100 = this.props.hashCode() * 31;
        int r101 = 1231;
        if (this.isMergingSemanticsOfDescendants == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isClearingSemantics == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        Map<SemanticsPropertyKey<?>, ? extends Object> r100 = this.mapWrapper;
        if (r100 != null) goto L6;
        r100 = this.props.asMap();
        this.mapWrapper = r100;
    L6:
        return r100.entrySet().iterator();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.isMergingSemanticsOfDescendants == false) goto L5;
        r100.append("mergeDescendants=true");
        String r101 = ", ";
    L7:
        if (this.isClearingSemantics == false) goto L9;
        r100.append(r101);
        r100.append("isClearingSemantics=true");
        r101 = ", ";
    L9:
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r102 = this.props;
        Object[] r103 = r102.keys;
        Object[] r104 = r102.values;
        long[] r105 = r102.metadata;
        int r106 = r105.length - 2;
        if (r106 < 0) goto L27;
        int r107 = 0;
    L12:
        long r110 = r105[r107];
        if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r111 = 8 - ((~(r107 - r106)) >>> 31);
        int r112 = 0;
    L15:
        if (r112 >= r111) goto L23;
        if ((255 & r110) >= 128) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == false) goto L22;
        int r114 = (r107 << 3) + r112;
        Object r115 = r103[r114];
        Object r116 = r104[r114];
        r100.append(r101);
        r100.append(((SemanticsPropertyKey) r115).getName());
        r100.append(" : ");
        r100.append(r116);
        r101 = ", ";
    L22:
        r110 = r110 >> 8;
        r112 = r112 + 1;
        goto L15
    L19:
        r113 = false;
        goto L20
    L23:
        if (r111 != 8) goto L27;
    L24:
        if (r107 == r106) goto L27;
        r107 = r107 + 1;
    L27:
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + "{ " + r100 + " }";
    L5:
        r101 = "";
        goto L7
    }

    public SemanticsConfiguration() {
        this.props = ScatterMapKt.mutableScatterMapOf();
    }

    public final ScatterSet<SemanticsPropertyKey<?>> getAccessibilityExtraKeys$ui_release() {
        return this._accessibilityExtraKeys;
    }

    public final MutableScatterMap<SemanticsPropertyKey<?>, Object> getProps$ui_release() {
        return this.props;
    }

    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    public final void collapsePeer$ui_release(SemanticsConfiguration r110) {
        if (r110.isMergingSemanticsOfDescendants == false) goto L6;
        this.isMergingSemanticsOfDescendants = true;
    L6:
        if (r110.isClearingSemantics == false) goto L8;
        this.isClearingSemantics = true;
    L8:
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r100 = r110.props;
        Object[] r101 = r100.keys;
        Object[] r102 = r100.values;
        long[] r103 = r100.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L37;
        int r105 = 0;
    L11:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L35;
        int r111 = 8 - ((~(r105 - r104)) >>> 31);
        int r112 = 0;
    L14:
        if (r112 >= r111) goto L34;
        if ((255 & r106) >= 128) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L32;
        int r114 = (r105 << 3) + r112;
        Object r115 = r101[r114];
        Object r116 = r102[r114];
        SemanticsPropertyKey<?> r117 = (SemanticsPropertyKey) r115;
        if (this.props.contains(r117) == true) goto L24;
        this.props.set(r117, r116);
        goto L32
    L24:
        if ((r116 instanceof AccessibilityAction) == false) goto L32;
        Object r118 = this.props.get(r117);
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
        AccessibilityAction r119 = (AccessibilityAction) r118;
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r107 = this.props;
        String r120 = r119.getLabel();
        if (r120 != null) goto L28;
        r120 = ((AccessibilityAction) r116).getLabel();
    L28:
        String r121 = r120;
        Function r122 = r119.getAction();
        if (r122 != null) goto L31;
        r122 = ((AccessibilityAction) r116).getAction();
    L31:
        r107.set(r117, new AccessibilityAction(r121, r122));
    L32:
        r106 = r106 >> 8;
        r112 = r112 + 1;
        goto L14
    L18:
        r113 = false;
        goto L19
    L34:
        if (r111 == 8) goto L35;
        return;
    L35:
        if (r105 == r104) goto L46;
        r105 = r105 + 1;
        goto L11
    L46:
        return;
    }

    public final <T> boolean contains(SemanticsPropertyKey<T> r100) {
        return this.props.containsKey(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SemanticsConfiguration) == true) goto L8;
        return false;
    L8:
        SemanticsConfiguration r101 = (SemanticsConfiguration) r100;
        if (Intrinsics.areEqual(this.props, r101.props) == true) goto L12;
        return false;
    L12:
        if (this.isMergingSemanticsOfDescendants == r101.isMergingSemanticsOfDescendants) goto L15;
        return false;
    L15:
        if (this.isClearingSemantics == r101.isClearingSemantics) goto L17;
        return false;
    L17:
        return true;
    }

    public final <T> T get(SemanticsPropertyKey<T> r100) {
        T r101 = (T) this.props.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Key not present: " + r100 + " - consider getOrElse or getOrNull");
    }

    public final void mergeChild$ui_release(SemanticsConfiguration r110) {
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r100 = r110.props;
        Object[] r101 = r100.keys;
        Object[] r102 = r100.values;
        long[] r103 = r100.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L21;
        int r105 = 0;
    L5:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r107 = 8 - ((~(r105 - r104)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r107) goto L18;
        if ((255 & r106) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r105 << 3) + r111;
        Object r114 = r101[r113];
        Object r115 = r102[r113];
        SemanticsPropertyKey<?> r116 = (SemanticsPropertyKey) r114;
        Object r117 = this.props.get(r116);
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
        Object r118 = r116.merge(r117, r115);
        if (r118 == null) goto L17;
        this.props.set(r116, r118);
    L17:
        r106 = r106 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r107 == 8) goto L19;
        return;
    L19:
        if (r105 == r104) goto L29;
        r105 = r105 + 1;
        goto L5
    L29:
        return;
    }

    public final void setClearingSemantics(boolean r100) {
        this.isClearingSemantics = r100;
    }

    public final void setMergingSemanticsOfDescendants(boolean r100) {
        this.isMergingSemanticsOfDescendants = r100;
    }

    public final <T> T getOrElse(SemanticsPropertyKey<T> r100, Function0<? extends T> r101) {
        T r102 = (T) this.props.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return r101.invoke();
    }

    public final <T> T getOrElseNullable(SemanticsPropertyKey<T> r100, Function0<? extends T> r101) {
        T r102 = (T) this.props.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return r101.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public <T> void set(SemanticsPropertyKey<T> r100, T r101) {
        if ((r101 instanceof AccessibilityAction) == true) goto L5;
    L13:
        this.props.set(r100, r101);
    L15:
        if (r100.getAccessibilityExtraKey$ui_release() != null) goto L17;
        return;
    L17:
        if (this._accessibilityExtraKeys != null) goto L19;
        this._accessibilityExtraKeys = ScatterSetKt.mutableScatterSetOf();
    L19:
        MutableScatterSet<SemanticsPropertyKey<?>> r102 = this._accessibilityExtraKeys;
        if (r102 == null) goto L24;
        r102.add(r100);
        return;
    L24:
        return;
    L5:
        if (contains(r100) == false) goto L13;
        Object r103 = this.props.get(r100);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
        AccessibilityAction r104 = (AccessibilityAction) r103;
        MutableScatterMap<SemanticsPropertyKey<?>, Object> r105 = this.props;
        AccessibilityAction r106 = (AccessibilityAction) r101;
        String r107 = r106.getLabel();
        if (r107 != null) goto L9;
        r107 = r104.getLabel();
    L9:
        Function r108 = r106.getAction();
        if (r108 != null) goto L12;
        r108 = r104.getAction();
    L12:
        r105.set(r100, new AccessibilityAction(r107, r108));
        goto L15
    }
}
