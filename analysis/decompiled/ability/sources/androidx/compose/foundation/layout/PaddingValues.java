package androidx.compose.foundation.layout;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Stable
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0015\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "Absolute", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PaddingValues {

    @Immutable
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\fJ\u0015\u0010\u0014\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR \u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010 \u0012\u0004\b!\u0010\"R \u0010\u0004\u001a\u00020\u00028\u0002X\u0083\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0004\u0010 \u0012\u0004\b#\u0010\"R \u0010\u0005\u001a\u00020\u00028\u0002X\u0083\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0005\u0010 \u0012\u0004\b$\u0010\"R \u0010\u0006\u001a\u00020\u00028\u0002X\u0083\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0006\u0010 \u0012\u0004\b%\u0010\"\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "Landroidx/compose/ui/unit/Dp;", "left", "top", "right", "bottom", AppAgent.CONSTRUCT, "(FFFFLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateLeftPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateTopPadding", "calculateRightPadding-u2uoSUM", "calculateRightPadding", "calculateBottomPadding-D9Ej5fM", "calculateBottomPadding", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "F", "getLeft-D9Ej5fM$annotations", "()V", "getTop-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getBottom-D9Ej5fM$annotations", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float f, float f7, float f9, float f10, e eVar) {
            this(f, f7, f9, f10);
        }

        @Stable
        /* renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m713getBottomD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m714getLeftD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m715getRightD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m716getTopD9Ej5fM$annotations() {
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateBottomPadding-D9Ej5fM, reason: from getter */
        public float getBottom() {
            return this.bottom;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateLeftPadding-u2uoSUM */
        public float mo651calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateRightPadding-u2uoSUM */
        public float mo652calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
            return this.right;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateTopPadding-D9Ej5fM, reason: from getter */
        public float getTop() {
            return this.top;
        }

        public boolean equals(Object other) {
            if (!(other instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) other;
            return Dp.m6849equalsimpl0(this.left, absolute.left) && Dp.m6849equalsimpl0(this.top, absolute.top) && Dp.m6849equalsimpl0(this.right, absolute.right) && Dp.m6849equalsimpl0(this.bottom, absolute.bottom);
        }

        public int hashCode() {
            return Dp.m6850hashCodeimpl(this.bottom) + b.b(this.right, b.b(this.top, Dp.m6850hashCodeimpl(this.left) * 31, 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("PaddingValues.Absolute(left=");
            a.B(sb, ", top=", this.left);
            a.B(sb, ", right=", this.top);
            a.B(sb, ", bottom=", this.right);
            sb.append((Object) Dp.m6855toStringimpl(this.bottom));
            sb.append(')');
            return sb.toString();
        }

        private Absolute(float f, float f7, float f9, float f10) {
            this.left = f;
            this.top = f7;
            this.right = f9;
            this.bottom = f10;
            if (f < 0.0f) {
                throw new IllegalArgumentException("Left padding must be non-negative");
            }
            if (f7 < 0.0f) {
                throw new IllegalArgumentException("Top padding must be non-negative");
            }
            if (f9 < 0.0f) {
                throw new IllegalArgumentException("Right padding must be non-negative");
            }
            if (f10 < 0.0f) {
                throw new IllegalArgumentException("Bottom padding must be non-negative");
            }
        }

        public /* synthetic */ Absolute(float f, float f7, float f9, float f10, int i, e eVar) {
            this((i & 1) != 0 ? Dp.m6844constructorimpl(0) : f, (i & 2) != 0 ? Dp.m6844constructorimpl(0) : f7, (i & 4) != 0 ? Dp.m6844constructorimpl(0) : f9, (i & 8) != 0 ? Dp.m6844constructorimpl(0) : f10, null);
        }
    }

    /* renamed from: calculateBottomPadding-D9Ej5fM */
    float getBottom();

    /* renamed from: calculateLeftPadding-u2uoSUM */
    float mo651calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* renamed from: calculateRightPadding-u2uoSUM */
    float mo652calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* renamed from: calculateTopPadding-D9Ej5fM */
    float getTop();
}
