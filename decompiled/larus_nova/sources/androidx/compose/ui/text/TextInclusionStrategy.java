package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy;", "", "isIncluded", "", "textBounds", "Landroidx/compose/ui/geometry/Rect;", SVGRenderEngine.RECT, "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TextInclusionStrategy {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy$Companion;", "", "<init>", "()V", "AnyOverlap", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getAnyOverlap", "()Landroidx/compose/ui/text/TextInclusionStrategy;", "ContainsAll", "getContainsAll", "ContainsCenter", "getContainsCenter", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final TextInclusionStrategy AnyOverlap = null;
        private static final TextInclusionStrategy ContainsAll = null;
        private static final TextInclusionStrategy ContainsCenter = null;

        private Companion() {
        }

        public static /* synthetic */ boolean a(Rect r100, Rect r101) {
            return AnyOverlap$lambda$0(r100, r101);
        }

        public static /* synthetic */ boolean b(Rect r100, Rect r101) {
            return ContainsCenter$lambda$2(r100, r101);
        }

        public static /* synthetic */ boolean c(Rect r100, Rect r101) {
            return ContainsAll$lambda$1(r100, r101);
        }

        static {
            $$INSTANCE = new Companion();
            AnyOverlap = new l1();
            ContainsAll = new m1();
            ContainsCenter = new n1();
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

        private static final boolean AnyOverlap$lambda$0(Rect r100, Rect r101) {
            return r100.overlaps(r101);
        }

        private static final boolean ContainsAll$lambda$1(Rect r100, Rect r101) {
            if (r101.isEmpty() == false) goto L5;
        L13:
            return false;
        L5:
            if (r100.getLeft() < r101.getLeft()) goto L13;
            if (r100.getRight() > r101.getRight()) goto L13;
            if (r100.getTop() < r101.getTop()) goto L13;
            if (r100.getBottom() > r101.getBottom()) goto L13;
            return true;
        }

        private static final boolean ContainsCenter$lambda$2(Rect r100, Rect r101) {
            return r101.m4608containsk4lQ0M(r100.m4612getCenterF1C5BW0());
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean isIncluded(Rect r100, Rect r101);
}
