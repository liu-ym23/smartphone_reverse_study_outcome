package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u008f\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b@\u0010AJ\b\u0010B\u001a\u00020CH\u0016R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R+\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0019\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R+\u0010\t\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R+\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0019\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R+\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0019\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R+\u0010\r\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0019\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R+\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0019\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0019\u001a\u0004\b\u000f\u0010;\"\u0004\b<\u0010=¨\u0006D"}, d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", LynxVideoManagerLite.EVENT_ON_ERROR, "isLight", "", "<init>", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getPrimary-0d7_KjU", "()J", "setPrimary-8_81llA$material", "(J)V", "primary$delegate", "Landroidx/compose/runtime/MutableState;", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material", "secondaryVariant$delegate", "getBackground-0d7_KjU", "setBackground-8_81llA$material", "background$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material", "surface$delegate", "getError-0d7_KjU", "setError-8_81llA$material", "error$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material", "onSecondary$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material", "onBackground$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material", "onSurface$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material", "onError$delegate", "()Z", "setLight$material", "(Z)V", "isLight$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Colors {
    public static final int $stable = 0;
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState isLight$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryVariant$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryVariant$delegate;
    private final MutableState surface$delegate;

    public /* synthetic */ Colors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, boolean r212, DefaultConstructorMarker r213) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1585getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1586getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1587getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1588getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1589getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1590getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1591getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1592getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1593getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m1594getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1595getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m1596getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m4837unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    public String toString() {
        return "Colors(primary=" + Color.m4835toStringimpl(m1592getPrimary0d7_KjU()) + ", primaryVariant=" + Color.m4835toStringimpl(m1593getPrimaryVariant0d7_KjU()) + ", secondary=" + Color.m4835toStringimpl(m1594getSecondary0d7_KjU()) + ", secondaryVariant=" + Color.m4835toStringimpl(m1595getSecondaryVariant0d7_KjU()) + ", background=" + Color.m4835toStringimpl(m1585getBackground0d7_KjU()) + ", surface=" + Color.m4835toStringimpl(m1596getSurface0d7_KjU()) + ", error=" + Color.m4835toStringimpl(m1586getError0d7_KjU()) + ", onPrimary=" + Color.m4835toStringimpl(m1589getOnPrimary0d7_KjU()) + ", onSecondary=" + Color.m4835toStringimpl(m1590getOnSecondary0d7_KjU()) + ", onBackground=" + Color.m4835toStringimpl(m1587getOnBackground0d7_KjU()) + ", onSurface=" + Color.m4835toStringimpl(m1591getOnSurface0d7_KjU()) + ", onError=" + Color.m4835toStringimpl(m1588getOnError0d7_KjU()) + ", isLight=" + isLight() + ')';
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material, reason: not valid java name */
    public final void m1597setBackground8_81llA$material(long r100) {
        this.background$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setError-8_81llA$material, reason: not valid java name */
    public final void m1598setError8_81llA$material(long r100) {
        this.error$delegate.setValue(Color.m4817boximpl(r100));
    }

    public final void setLight$material(boolean r100) {
        this.isLight$delegate.setValue(Boolean.valueOf(r100));
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material, reason: not valid java name */
    public final void m1599setOnBackground8_81llA$material(long r100) {
        this.onBackground$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material, reason: not valid java name */
    public final void m1600setOnError8_81llA$material(long r100) {
        this.onError$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material, reason: not valid java name */
    public final void m1601setOnPrimary8_81llA$material(long r100) {
        this.onPrimary$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material, reason: not valid java name */
    public final void m1602setOnSecondary8_81llA$material(long r100) {
        this.onSecondary$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material, reason: not valid java name */
    public final void m1603setOnSurface8_81llA$material(long r100) {
        this.onSurface$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material, reason: not valid java name */
    public final void m1604setPrimary8_81llA$material(long r100) {
        this.primary$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setPrimaryVariant-8_81llA$material, reason: not valid java name */
    public final void m1605setPrimaryVariant8_81llA$material(long r100) {
        this.primaryVariant$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material, reason: not valid java name */
    public final void m1606setSecondary8_81llA$material(long r100) {
        this.secondary$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setSecondaryVariant-8_81llA$material, reason: not valid java name */
    public final void m1607setSecondaryVariant8_81llA$material(long r100) {
        this.secondaryVariant$delegate.setValue(Color.m4817boximpl(r100));
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material, reason: not valid java name */
    public final void m1608setSurface8_81llA$material(long r100) {
        this.surface$delegate.setValue(Color.m4817boximpl(r100));
    }

    private Colors(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, boolean r214) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r100), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r101), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r102), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r110), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r111), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r112), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r113), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r114), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r210), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r211), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r212), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m4817boximpl(r213), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(r214), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* JADX INFO: renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m1584copypvPzIIM(long r210, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, boolean r511) {
        return new Colors(r210, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, null);
    }

    /* JADX INFO: renamed from: copy-pvPzIIM$default, reason: not valid java name */
    public static /* synthetic */ Colors m1583copypvPzIIM$default(Colors r110, long r111, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, boolean r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        long r100 = r110.m1592getPrimary0d7_KjU();
    L7:
        if ((r412 & 2) == 0) goto L9;
        long r101 = r110.m1593getPrimaryVariant0d7_KjU();
    L11:
        if ((r412 & 4) == 0) goto L13;
        long r102 = r110.m1594getSecondary0d7_KjU();
    L15:
        if ((r412 & 8) == 0) goto L17;
        long r103 = r110.m1595getSecondaryVariant0d7_KjU();
    L19:
        if ((r412 & 16) == 0) goto L21;
        long r104 = r110.m1585getBackground0d7_KjU();
    L23:
        if ((r412 & 32) == 0) goto L25;
        long r112 = r110.m1596getSurface0d7_KjU();
    L27:
        if ((r412 & 64) == 0) goto L29;
        long r113 = r110.m1586getError0d7_KjU();
    L31:
        if ((r412 & 128) == 0) goto L33;
        long r114 = r110.m1589getOnPrimary0d7_KjU();
    L34:
        long r315 = r114;
        if ((r412 & 256) == 0) goto L37;
        long r115 = r110.m1590getOnSecondary0d7_KjU();
    L38:
        long r316 = r115;
        if ((r412 & 512) == 0) goto L41;
        long r116 = r110.m1587getOnBackground0d7_KjU();
    L42:
        long r317 = r116;
        if ((r412 & 1024) == 0) goto L45;
        long r117 = r110.m1591getOnSurface0d7_KjU();
    L46:
        long r318 = r117;
        if ((r412 & 2048) == 0) goto L49;
        long r118 = r110.m1588getOnError0d7_KjU();
    L51:
        if ((r412 & 4096) == 0) goto L53;
        boolean r105 = r110.isLight();
    L55:
        return r110.m1584copypvPzIIM(r100, r101, r102, r103, r104, r112, r113, r315, r316, r317, r318, r118, r105);
    L53:
        r105 = r411;
        goto L55
    L49:
        r118 = r410;
        goto L51
    L45:
        r117 = r314;
        goto L46
    L41:
        r116 = r313;
        goto L42
    L37:
        r115 = r312;
        goto L38
    L33:
        r114 = r311;
        goto L34
    L29:
        r113 = r310;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
