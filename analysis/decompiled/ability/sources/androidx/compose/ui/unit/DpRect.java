package androidx.compose.ui.unit;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010$\u0012\u0004\b&\u0010'\u001a\u0004\b%\u0010\u000fR \u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010$\u0012\u0004\b)\u0010'\u001a\u0004\b(\u0010\u000fR \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010$\u0012\u0004\b+\u0010'\u001a\u0004\b*\u0010\u000fR \u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010$\u0012\u0004\b-\u0010'\u001a\u0004\b,\u0010\u000f¨\u0006/"}, d2 = {"Landroidx/compose/ui/unit/DpRect;", "", "Landroidx/compose/ui/unit/Dp;", "left", "top", "right", "bottom", AppAgent.CONSTRUCT, "(FFFFLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/unit/DpOffset;", "origin", "Landroidx/compose/ui/unit/DpSize;", "size", "(JJLkotlin/jvm/internal/e;)V", "component1-D9Ej5fM", "()F", "component1", "component2-D9Ej5fM", "component2", "component3-D9Ej5fM", "component3", "component4-D9Ej5fM", "component4", "copy-a9UjIt4", "(FFFF)Landroidx/compose/ui/unit/DpRect;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "getLeft-D9Ej5fM", "getLeft-D9Ej5fM$annotations", "()V", "getTop-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getRight-D9Ej5fM", "getRight-D9Ej5fM$annotations", "getBottom-D9Ej5fM", "getBottom-D9Ej5fM$annotations", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DpRect {
    public static final int $stable = 0;
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public /* synthetic */ DpRect(float f, float f7, float f9, float f10, e eVar) {
        this(f, f7, f9, f10);
    }

    /* renamed from: copy-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ DpRect m6916copya9UjIt4$default(DpRect dpRect, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpRect.left;
        }
        if ((i & 2) != 0) {
            f7 = dpRect.top;
        }
        if ((i & 4) != 0) {
            f9 = dpRect.right;
        }
        if ((i & 8) != 0) {
            f10 = dpRect.bottom;
        }
        return dpRect.m6925copya9UjIt4(f, f7, f9, f10);
    }

    @Stable
    /* renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6917getBottomD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6918getLeftD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6919getRightD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6920getTopD9Ej5fM$annotations() {
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getLeft() {
        return this.left;
    }

    /* renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    /* renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRight() {
        return this.right;
    }

    /* renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: copy-a9UjIt4, reason: not valid java name */
    public final DpRect m6925copya9UjIt4(float left, float top, float right, float bottom) {
        return new DpRect(left, top, right, bottom, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DpRect)) {
            return false;
        }
        DpRect dpRect = (DpRect) other;
        return Dp.m6849equalsimpl0(this.left, dpRect.left) && Dp.m6849equalsimpl0(this.top, dpRect.top) && Dp.m6849equalsimpl0(this.right, dpRect.right) && Dp.m6849equalsimpl0(this.bottom, dpRect.bottom);
    }

    /* renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m6926getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m6927getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m6928getRightD9Ej5fM() {
        return this.right;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m6929getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return Dp.m6850hashCodeimpl(this.bottom) + b.b(this.right, b.b(this.top, Dp.m6850hashCodeimpl(this.left) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DpRect(left=");
        a.B(sb, ", top=", this.left);
        a.B(sb, ", right=", this.top);
        a.B(sb, ", bottom=", this.right);
        sb.append((Object) Dp.m6855toStringimpl(this.bottom));
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ DpRect(long j5, long j6, e eVar) {
        this(j5, j6);
    }

    private DpRect(float f, float f7, float f9, float f10) {
        this.left = f;
        this.top = f7;
        this.right = f9;
        this.bottom = f10;
    }

    private DpRect(long j5, long j6) {
        this(DpOffset.m6905getXD9Ej5fM(j5), DpOffset.m6907getYD9Ej5fM(j5), Dp.m6844constructorimpl(DpSize.m6942getWidthD9Ej5fM(j6) + DpOffset.m6905getXD9Ej5fM(j5)), Dp.m6844constructorimpl(DpSize.m6940getHeightD9Ej5fM(j6) + DpOffset.m6907getYD9Ej5fM(j5)), null);
    }
}
