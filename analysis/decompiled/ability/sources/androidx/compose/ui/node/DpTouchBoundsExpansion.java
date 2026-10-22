package androidx.compose.ui.node;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJB\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b*\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b+\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b,\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010-\u001a\u0004\b\b\u0010\u001b¨\u0006/"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "", "Landroidx/compose/ui/unit/Dp;", "start", "top", "end", "bottom", "", "isLayoutDirectionAware", AppAgent.CONSTRUCT, "(FFFFZLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "roundToTouchBoundsExpansion-TW6G1oQ", "(Landroidx/compose/ui/unit/Density;)J", "roundToTouchBoundsExpansion", "component1-D9Ej5fM", "()F", "component1", "component2-D9Ej5fM", "component2", "component3-D9Ej5fM", "component3", "component4-D9Ej5fM", "component4", "component5", "()Z", "copy-lDy3nrA", "(FFFFZ)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "F", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM", "Z", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DpTouchBoundsExpansion {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float bottom;
    private final float end;
    private final boolean isLayoutDirectionAware;
    private final float start;
    private final float top;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion$Companion;", "", AppAgent.CONSTRUCT, "()V", "Absolute", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "Absolute-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: Absolute-a9UjIt4$default, reason: not valid java name */
        public static /* synthetic */ DpTouchBoundsExpansion m5739Absolutea9UjIt4$default(Companion companion, float f, float f7, float f9, float f10, int i, Object obj) {
            if ((i & 1) != 0) {
                f = Dp.m6844constructorimpl(0);
            }
            if ((i & 2) != 0) {
                f7 = Dp.m6844constructorimpl(0);
            }
            if ((i & 4) != 0) {
                f9 = Dp.m6844constructorimpl(0);
            }
            if ((i & 8) != 0) {
                f10 = Dp.m6844constructorimpl(0);
            }
            return companion.m5740Absolutea9UjIt4(f, f7, f9, f10);
        }

        /* renamed from: Absolute-a9UjIt4, reason: not valid java name */
        public final DpTouchBoundsExpansion m5740Absolutea9UjIt4(float left, float top, float right, float bottom) {
            return new DpTouchBoundsExpansion(left, top, right, bottom, false, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ DpTouchBoundsExpansion(float f, float f7, float f9, float f10, boolean z10, e eVar) {
        this(f, f7, f9, f10, z10);
    }

    /* renamed from: copy-lDy3nrA$default, reason: not valid java name */
    public static /* synthetic */ DpTouchBoundsExpansion m5728copylDy3nrA$default(DpTouchBoundsExpansion dpTouchBoundsExpansion, float f, float f7, float f9, float f10, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpTouchBoundsExpansion.start;
        }
        if ((i & 2) != 0) {
            f7 = dpTouchBoundsExpansion.top;
        }
        if ((i & 4) != 0) {
            f9 = dpTouchBoundsExpansion.end;
        }
        if ((i & 8) != 0) {
            f10 = dpTouchBoundsExpansion.bottom;
        }
        if ((i & 16) != 0) {
            z10 = dpTouchBoundsExpansion.isLayoutDirectionAware;
        }
        boolean z11 = z10;
        float f11 = f9;
        return dpTouchBoundsExpansion.m5733copylDy3nrA(f, f7, f11, f10, z11);
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    /* renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    /* renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    /* renamed from: copy-lDy3nrA, reason: not valid java name */
    public final DpTouchBoundsExpansion m5733copylDy3nrA(float start, float top, float end, float bottom, boolean isLayoutDirectionAware) {
        return new DpTouchBoundsExpansion(start, top, end, bottom, isLayoutDirectionAware, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DpTouchBoundsExpansion)) {
            return false;
        }
        DpTouchBoundsExpansion dpTouchBoundsExpansion = (DpTouchBoundsExpansion) other;
        return Dp.m6849equalsimpl0(this.start, dpTouchBoundsExpansion.start) && Dp.m6849equalsimpl0(this.top, dpTouchBoundsExpansion.top) && Dp.m6849equalsimpl0(this.end, dpTouchBoundsExpansion.end) && Dp.m6849equalsimpl0(this.bottom, dpTouchBoundsExpansion.bottom) && this.isLayoutDirectionAware == dpTouchBoundsExpansion.isLayoutDirectionAware;
    }

    /* renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m5734getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m5735getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m5736getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m5737getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLayoutDirectionAware) + b.b(this.bottom, b.b(this.end, b.b(this.top, Dp.m6850hashCodeimpl(this.start) * 31, 31), 31), 31);
    }

    public final boolean isLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    /* renamed from: roundToTouchBoundsExpansion-TW6G1oQ, reason: not valid java name */
    public final long m5738roundToTouchBoundsExpansionTW6G1oQ(Density density) {
        return TouchBoundsExpansion.m5946constructorimpl(TouchBoundsExpansion.INSTANCE.pack$ui_release(density.mo375roundToPx0680j_4(this.start), density.mo375roundToPx0680j_4(this.top), density.mo375roundToPx0680j_4(this.end), density.mo375roundToPx0680j_4(this.bottom), this.isLayoutDirectionAware));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DpTouchBoundsExpansion(start=");
        a.B(sb, ", top=", this.start);
        a.B(sb, ", end=", this.top);
        a.B(sb, ", bottom=", this.end);
        a.B(sb, ", isLayoutDirectionAware=", this.bottom);
        return a.r(sb, this.isLayoutDirectionAware, ')');
    }

    private DpTouchBoundsExpansion(float f, float f7, float f9, float f10, boolean z10) {
        this.start = f;
        this.top = f7;
        this.end = f9;
        this.bottom = f10;
        this.isLayoutDirectionAware = z10;
        if (!(f >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Left must be non-negative");
        }
        if (!(f7 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Top must be non-negative");
        }
        if (!(f9 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Right must be non-negative");
        }
        if (f10 >= 0.0f) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Bottom must be non-negative");
    }
}
