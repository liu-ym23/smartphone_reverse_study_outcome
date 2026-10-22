package androidx.compose.ui.unit;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0019\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0011J\u0010\u0010\u001b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0011J\u0010\u0010\u001d\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0011J\u0010\u0010\u001f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010\u0011J8\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011¨\u0006,"}, d2 = {"Landroidx/compose/ui/unit/DpRect;", "", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", PlayerResolution.SDKKEY.ORIGIN, "Landroidx/compose/ui/unit/DpOffset;", "size", "Landroidx/compose/ui/unit/DpSize;", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM$annotations", "()V", "getLeft-D9Ej5fM", "()F", FaceService.girlLabel, "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "getRight-D9Ej5fM$annotations", "getRight-D9Ej5fM", "getBottom-D9Ej5fM$annotations", "getBottom-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "copy", "copy-a9UjIt4", "(FFFF)Landroidx/compose/ui/unit/DpRect;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DpRect {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/unit/DpRect$Companion;", "", "<init>", "()V", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DpRect(float r100, float r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public /* synthetic */ DpRect(long r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    /* JADX INFO: renamed from: copy-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ DpRect m7616copya9UjIt4$default(DpRect r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.top;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.right;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottom;
    L15:
        return r100.m7625copya9UjIt4(r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7617getBottomD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7618getLeftD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7619getRightD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7620getTopD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public final float m7621component1D9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public final float m7622component2D9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name */
    public final float m7623component3D9Ej5fM() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name */
    public final float m7624component4D9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: copy-a9UjIt4, reason: not valid java name */
    public final DpRect m7625copya9UjIt4(float r100, float r101, float r110, float r111) {
        return new DpRect(r100, r101, r110, r111, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DpRect) == true) goto L8;
        return false;
    L8:
        DpRect r101 = (DpRect) r100;
        if (Dp.m7549equalsimpl0(this.left, r101.left) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.top, r101.top) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.right, r101.right) == true) goto L18;
        return false;
    L18:
        if (Dp.m7549equalsimpl0(this.bottom, r101.bottom) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Dp.m7550hashCodeimpl(this.left) * 31) + Dp.m7550hashCodeimpl(this.top)) * 31) + Dp.m7550hashCodeimpl(this.right)) * 31) + Dp.m7550hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "DpRect(left=" + Dp.m7555toStringimpl(this.left) + ", top=" + Dp.m7555toStringimpl(this.top) + ", right=" + Dp.m7555toStringimpl(this.right) + ", bottom=" + Dp.m7555toStringimpl(this.bottom) + ')';
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m7626getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m7627getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m7628getRightD9Ej5fM() {
        return this.right;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m7629getTopD9Ej5fM() {
        return this.top;
    }

    private DpRect(long r100, long r101) {
        this(DpOffset.m7605getXD9Ej5fM(r100), DpOffset.m7607getYD9Ej5fM(r100), Dp.m7544constructorimpl(DpOffset.m7605getXD9Ej5fM(r100) + DpSize.m7642getWidthD9Ej5fM(r101)), Dp.m7544constructorimpl(DpOffset.m7607getYD9Ej5fM(r100) + DpSize.m7640getHeightD9Ej5fM(r101)), null);
    }

    private DpRect(float r100, float r101, float r102, float r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }
}
