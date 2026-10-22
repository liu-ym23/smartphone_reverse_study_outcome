package androidx.compose.ui.text;

import X6.h;
import androidx.compose.ui.geometry.Rect;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy;", "", "isIncluded", "", "textBounds", "Landroidx/compose/ui/geometry/Rect;", "rect", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TextInclusionStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy$Companion;", "", AppAgent.CONSTRUCT, "()V", "AnyOverlap", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getAnyOverlap", "()Landroidx/compose/ui/text/TextInclusionStrategy;", "ContainsAll", "getContainsAll", "ContainsCenter", "getContainsCenter", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final TextInclusionStrategy AnyOverlap = new h(19);
        private static final TextInclusionStrategy ContainsAll = new h(20);
        private static final TextInclusionStrategy ContainsCenter = new h(21);

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean ContainsAll$lambda$1(Rect rect, Rect rect2) {
            return !rect2.isEmpty() && rect.getLeft() >= rect2.getLeft() && rect.getRight() <= rect2.getRight() && rect.getTop() >= rect2.getTop() && rect.getBottom() <= rect2.getBottom();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean ContainsCenter$lambda$2(Rect rect, Rect rect2) {
            return rect2.m3921containsk4lQ0M(rect.m3925getCenterF1C5BW0());
        }

        public final TextInclusionStrategy getAnyOverlap() {
            return AnyOverlap;
        }

        public final TextInclusionStrategy getContainsAll() {
            return ContainsAll;
        }

        public final TextInclusionStrategy getContainsCenter() {
            return ContainsCenter;
        }
    }

    boolean isIncluded(Rect textBounds, Rect rect);
}
