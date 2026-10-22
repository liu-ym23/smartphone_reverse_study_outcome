package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001d\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001f\u0010\fJ\t\u0010 \u001a\u00020\bHÆ\u0003JB\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011¨\u0006+"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "isLayoutDirectionAware", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", FaceService.girlLabel, "getTop-D9Ej5fM", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM", "()Z", "roundToTouchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "density", "Landroidx/compose/ui/unit/Density;", "roundToTouchBoundsExpansion-TW6G1oQ", "(Landroidx/compose/ui/unit/Density;)J", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "component5", "copy", "copy-lDy3nrA", "(FFFFZ)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DpTouchBoundsExpansion {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final float bottom;
    private final float end;
    private final boolean isLayoutDirectionAware;
    private final float start;
    private final float top;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion$Companion;", "", "<init>", "()V", "Absolute", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "Absolute-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: Absolute-a9UjIt4, reason: not valid java name */
        public final DpTouchBoundsExpansion m6447Absolutea9UjIt4(float r100, float r110, float r111, float r112) {
            return new DpTouchBoundsExpansion(r100, r110, r111, r112, false, null);
        }

        /* JADX INFO: renamed from: Absolute-a9UjIt4$default, reason: not valid java name */
        public static /* synthetic */ DpTouchBoundsExpansion m6446Absolutea9UjIt4$default(Companion r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = Dp.m7544constructorimpl(0);
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = Dp.m7544constructorimpl(0);
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = Dp.m7544constructorimpl(0);
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = Dp.m7544constructorimpl(0);
        L15:
            return r100.m6447Absolutea9UjIt4(r101, r102, r103, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DpTouchBoundsExpansion(float r100, float r101, float r102, float r103, boolean r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: copy-lDy3nrA$default, reason: not valid java name */
    public static /* synthetic */ DpTouchBoundsExpansion m6435copylDy3nrA$default(DpTouchBoundsExpansion r100, float r101, float r102, float r103, float r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.start;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.top;
    L8:
        float r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.end;
    L11:
        float r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.bottom;
    L14:
        float r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isLayoutDirectionAware;
    L17:
        float r109 = r101;
        return r100.m6440copylDy3nrA(r109, r111, r107, r108, r105);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public final float m6436component1D9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public final float m6437component2D9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name */
    public final float m6438component3D9Ej5fM() {
        return this.end;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name */
    public final float m6439component4D9Ej5fM() {
        return this.bottom;
    }

    public final boolean component5() {
        return this.isLayoutDirectionAware;
    }

    /* JADX INFO: renamed from: copy-lDy3nrA, reason: not valid java name */
    public final DpTouchBoundsExpansion m6440copylDy3nrA(float r100, float r110, float r111, float r112, boolean r113) {
        return new DpTouchBoundsExpansion(r100, r110, r111, r112, r113, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DpTouchBoundsExpansion) == true) goto L8;
        return false;
    L8:
        DpTouchBoundsExpansion r101 = (DpTouchBoundsExpansion) r100;
        if (Dp.m7549equalsimpl0(this.start, r101.start) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.top, r101.top) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.end, r101.end) == true) goto L18;
        return false;
    L18:
        if (Dp.m7549equalsimpl0(this.bottom, r101.bottom) == true) goto L21;
        return false;
    L21:
        if (this.isLayoutDirectionAware == r101.isLayoutDirectionAware) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((Dp.m7550hashCodeimpl(this.start) * 31) + Dp.m7550hashCodeimpl(this.top)) * 31) + Dp.m7550hashCodeimpl(this.end)) * 31) + Dp.m7550hashCodeimpl(this.bottom)) * 31;
        if (this.isLayoutDirectionAware == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "DpTouchBoundsExpansion(start=" + Dp.m7555toStringimpl(this.start) + ", top=" + Dp.m7555toStringimpl(this.top) + ", end=" + Dp.m7555toStringimpl(this.end) + ", bottom=" + Dp.m7555toStringimpl(this.bottom) + ", isLayoutDirectionAware=" + this.isLayoutDirectionAware + ')';
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m6441getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m6442getEndD9Ej5fM() {
        return this.end;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m6443getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m6444getTopD9Ej5fM() {
        return this.top;
    }

    public final boolean isLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    /* JADX INFO: renamed from: roundToTouchBoundsExpansion-TW6G1oQ, reason: not valid java name */
    public final long m6445roundToTouchBoundsExpansionTW6G1oQ(Density r100) {
        return TouchBoundsExpansion.m6642constructorimpl(TouchBoundsExpansion.Companion.pack$ui_release(r100.mo365roundToPx0680j_4(this.start), r100.mo365roundToPx0680j_4(this.top), r100.mo365roundToPx0680j_4(this.end), r100.mo365roundToPx0680j_4(this.bottom), this.isLayoutDirectionAware));
    }

    private DpTouchBoundsExpansion(float r100, float r101, float r102, float r103, boolean r104) {
        this.start = r100;
        this.top = r101;
        this.end = r102;
        this.bottom = r103;
        this.isLayoutDirectionAware = r104;
        boolean r105 = true;
        if (r100 < 0.0f) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("Left must be non-negative");
    L9:
        if (r101 < 0.0f) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L15;
        InlineClassHelperKt.throwIllegalArgumentException("Top must be non-negative");
    L15:
        if (r102 < 0.0f) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == true) goto L21;
        InlineClassHelperKt.throwIllegalArgumentException("Right must be non-negative");
    L21:
        if (r103 >= 0.0f) goto L24;
        r105 = false;
    L24:
        if (r105 == true) goto L27;
        InlineClassHelperKt.throwIllegalArgumentException("Bottom must be non-negative");
        return;
    L27:
        return;
    L17:
        r108 = false;
        goto L18
    L11:
        r107 = false;
        goto L12
    L5:
        r106 = false;
        goto L6
    }
}
