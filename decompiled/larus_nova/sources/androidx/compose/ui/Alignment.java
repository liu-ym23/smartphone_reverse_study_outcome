package androidx.compose.ui;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0080\u0001\u0018\u0000 \r2\u00020\u0001:\u0003\u000b\f\rJ'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment;", "", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "Horizontal", "Vertical", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Alignment {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\bR\u001c\u0010!\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010%R\u001c\u0010)\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010%R\u001c\u0010,\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u00100R\u001c\u00104\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0003\u001a\u0004\b6\u00100¨\u00067"}, d2 = {"Landroidx/compose/ui/Alignment$Companion;", "", "<init>", "()V", "TopStart", "Landroidx/compose/ui/Alignment;", "getTopStart$annotations", "getTopStart", "()Landroidx/compose/ui/Alignment;", "TopCenter", "getTopCenter$annotations", "getTopCenter", "TopEnd", "getTopEnd$annotations", "getTopEnd", "CenterStart", "getCenterStart$annotations", "getCenterStart", "Center", "getCenter$annotations", "getCenter", "CenterEnd", "getCenterEnd$annotations", "getCenterEnd", "BottomStart", "getBottomStart$annotations", "getBottomStart", "BottomCenter", "getBottomCenter$annotations", "getBottomCenter", "BottomEnd", "getBottomEnd$annotations", "getBottomEnd", "Top", "Landroidx/compose/ui/Alignment$Vertical;", "getTop$annotations", "getTop", "()Landroidx/compose/ui/Alignment$Vertical;", "CenterVertically", "getCenterVertically$annotations", "getCenterVertically", "Bottom", "getBottom$annotations", "getBottom", "Start", "Landroidx/compose/ui/Alignment$Horizontal;", "getStart$annotations", "getStart", "()Landroidx/compose/ui/Alignment$Horizontal;", "CenterHorizontally", "getCenterHorizontally$annotations", "getCenterHorizontally", "End", "getEnd$annotations", "getEnd", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Vertical Bottom = null;
        private static final Alignment BottomCenter = null;
        private static final Alignment BottomEnd = null;
        private static final Alignment BottomStart = null;
        private static final Alignment Center = null;
        private static final Alignment CenterEnd = null;
        private static final Horizontal CenterHorizontally = null;
        private static final Alignment CenterStart = null;
        private static final Vertical CenterVertically = null;
        private static final Horizontal End = null;
        private static final Horizontal Start = null;
        private static final Vertical Top = null;
        private static final Alignment TopCenter = null;
        private static final Alignment TopEnd = null;
        private static final Alignment TopStart = null;

        private Companion() {
        }

        public static /* synthetic */ void getBottom$annotations() {
        }

        public static /* synthetic */ void getBottomCenter$annotations() {
        }

        public static /* synthetic */ void getBottomEnd$annotations() {
        }

        public static /* synthetic */ void getBottomStart$annotations() {
        }

        public static /* synthetic */ void getCenter$annotations() {
        }

        public static /* synthetic */ void getCenterEnd$annotations() {
        }

        public static /* synthetic */ void getCenterHorizontally$annotations() {
        }

        public static /* synthetic */ void getCenterStart$annotations() {
        }

        public static /* synthetic */ void getCenterVertically$annotations() {
        }

        public static /* synthetic */ void getEnd$annotations() {
        }

        public static /* synthetic */ void getStart$annotations() {
        }

        public static /* synthetic */ void getTop$annotations() {
        }

        public static /* synthetic */ void getTopCenter$annotations() {
        }

        public static /* synthetic */ void getTopEnd$annotations() {
        }

        public static /* synthetic */ void getTopStart$annotations() {
        }

        static {
            $$INSTANCE = new Companion();
            TopStart = new BiasAlignment(-1.0f, -1.0f);
            TopCenter = new BiasAlignment(0.0f, -1.0f);
            TopEnd = new BiasAlignment(1.0f, -1.0f);
            CenterStart = new BiasAlignment(-1.0f, 0.0f);
            Center = new BiasAlignment(0.0f, 0.0f);
            CenterEnd = new BiasAlignment(1.0f, 0.0f);
            BottomStart = new BiasAlignment(-1.0f, 1.0f);
            BottomCenter = new BiasAlignment(0.0f, 1.0f);
            BottomEnd = new BiasAlignment(1.0f, 1.0f);
            Top = new BiasAlignment.Vertical(-1.0f);
            CenterVertically = new BiasAlignment.Vertical(0.0f);
            Bottom = new BiasAlignment.Vertical(1.0f);
            Start = new BiasAlignment.Horizontal(-1.0f);
            CenterHorizontally = new BiasAlignment.Horizontal(0.0f);
            End = new BiasAlignment.Horizontal(1.0f);
        }

        public final Vertical getBottom() {
            return Bottom;
        }

        public final Alignment getBottomCenter() {
            return BottomCenter;
        }

        public final Alignment getBottomEnd() {
            return BottomEnd;
        }

        public final Alignment getBottomStart() {
            return BottomStart;
        }

        public final Alignment getCenter() {
            return Center;
        }

        public final Alignment getCenterEnd() {
            return CenterEnd;
        }

        public final Horizontal getCenterHorizontally() {
            return CenterHorizontally;
        }

        public final Alignment getCenterStart() {
            return CenterStart;
        }

        public final Vertical getCenterVertically() {
            return CenterVertically;
        }

        public final Horizontal getEnd() {
            return End;
        }

        public final Horizontal getStart() {
            return Start;
        }

        public final Vertical getTop() {
            return Top;
        }

        public final Alignment getTopCenter() {
            return TopCenter;
        }

        public final Alignment getTopEnd() {
            return TopEnd;
        }

        public final Alignment getTopStart() {
            return TopStart;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment$Horizontal;", "", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Vertical;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Horizontal {

        /* JADX INFO: renamed from: androidx.compose.ui.Alignment$Horizontal$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Alignment $default$plus(Horizontal r100, Vertical r101) {
                return new CombinedAlignment(r100, r101);
            }
        }

        int align(int r100, int r101, LayoutDirection r102);

        Alignment plus(Vertical r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment$Vertical;", "", "align", "", "size", "space", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Horizontal;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Vertical {

        /* JADX INFO: renamed from: androidx.compose.ui.Alignment$Vertical$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Alignment $default$plus(Vertical r100, Horizontal r101) {
                return new CombinedAlignment(r101, r100);
            }
        }

        int align(int r100, int r101);

        Alignment plus(Horizontal r100);
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: align-KFBX0sM, reason: not valid java name */
    long mo4305alignKFBX0sM(long r100, long r101, LayoutDirection r102);
}
