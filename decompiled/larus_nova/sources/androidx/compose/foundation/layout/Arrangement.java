package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005FGHIJB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u001f\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010*J\u001f\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020+H\u0007¢\u0006\u0004\b)\u0010,J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010-\u001a\u00020\r2\u0006\u0010'\u001a\u00020+H\u0007J-\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J%\u00108\u001a\u00020/2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b9J-\u0010:\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b;J-\u0010<\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b=J-\u0010>\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b?J-\u0010@\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\bAJ/\u0010B\u001a\u00020/*\u0002032\u0006\u0010C\u001a\u0002062\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0EH\u0082\bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\u0018¨\u0006K"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "<init>", "()V", "Start", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getStart$annotations", "getStart", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "End", "getEnd$annotations", "getEnd", "Top", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTop$annotations", "getTop", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Bottom", "getBottom$annotations", "getBottom", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "aligned", "placeRightOrBottom", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeRightOrBottom$foundation_layout", "placeLeftOrTop", "placeLeftOrTop$foundation_layout", "placeCenter", "placeCenter$foundation_layout", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout", "placeSpaceBetween", "placeSpaceBetween$foundation_layout", "placeSpaceAround", "placeSpaceAround$foundation_layout", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Horizontal", "Vertical", "HorizontalOrVertical", "Absolute", "SpacedAligned", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Arrangement {
    public static final int $stable = 0;
    private static final Vertical Bottom = null;
    private static final HorizontalOrVertical Center = null;
    private static final Horizontal End = null;
    public static final Arrangement INSTANCE = null;
    private static final HorizontalOrVertical SpaceAround = null;
    private static final HorizontalOrVertical SpaceBetween = null;
    private static final HorizontalOrVertical SpaceEvenly = null;
    private static final Horizontal Start = null;
    private static final Vertical Top = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010\u0018\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020#H\u0007¢\u0006\u0004\b \u0010$J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\b¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "<init>", "()V", "Left", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getLeft$annotations", "getLeft", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Center", "getCenter$annotations", "getCenter", "Right", "getRight$annotations", "getRight", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "aligned", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Absolute {
        public static final int $stable = 0;
        private static final Horizontal Center = null;
        public static final Absolute INSTANCE = null;
        private static final Horizontal Left = null;
        private static final Horizontal Right = null;
        private static final Horizontal SpaceAround = null;
        private static final Horizontal SpaceBetween = null;
        private static final Horizontal SpaceEvenly = null;

        private Absolute() {
        }

        public static /* synthetic */ int a(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
            return aligned$lambda$2(r100, r101, r102);
        }

        public static /* synthetic */ int b(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
            return spacedBy_D5KLDUw$lambda$0(r100, r101, r102);
        }

        public static /* synthetic */ int c(Alignment.Vertical r100, int r101, LayoutDirection r102) {
            return spacedBy_D5KLDUw$lambda$1(r100, r101, r102);
        }

        public static /* synthetic */ void getCenter$annotations() {
        }

        public static /* synthetic */ void getLeft$annotations() {
        }

        public static /* synthetic */ void getRight$annotations() {
        }

        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        static {
            INSTANCE = new Absolute();
            Left = new Arrangement$Absolute$Left$1();
            Center = new Arrangement$Absolute$Center$1();
            Right = new Arrangement$Absolute$Right$1();
            SpaceBetween = new Arrangement$Absolute$SpaceBetween$1();
            SpaceEvenly = new Arrangement$Absolute$SpaceEvenly$1();
            SpaceAround = new Arrangement$Absolute$SpaceAround$1();
        }

        public final Horizontal getCenter() {
            return Center;
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getRight() {
            return Right;
        }

        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        public final Horizontal aligned(final Alignment.Horizontal r100) {
            return new SpacedAligned(Dp.m7544constructorimpl(0), false, new g(r100), null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
        public final HorizontalOrVertical m614spacedBy0680j_4(float r100) {
            return new SpacedAligned(r100, false, null, 0 == true ? 1 : 0);
        }

        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Horizontal m615spacedByD5KLDUw(float r100, final Alignment.Horizontal r101) {
            boolean r102 = false;
            return new SpacedAligned(r100, r102, new i(r101), null);
        }

        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Vertical m616spacedByD5KLDUw(float r100, final Alignment.Vertical r101) {
            boolean r102 = false;
            return new SpacedAligned(r100, r102, new h(r101), null);
        }

        private static final int aligned$lambda$2(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
            return r100.align(0, r101, r102);
        }

        private static final int spacedBy_D5KLDUw$lambda$0(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
            return r100.align(0, r101, r102);
        }

        private static final int spacedBy_D5KLDUw$lambda$1(Alignment.Vertical r100, int r101, LayoutDirection r102) {
            return r100.align(0, r101);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Horizontal {

        /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$Horizontal$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            /* JADX INFO: renamed from: $default$getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m618$default$getSpacingD9Ej5fM(Horizontal r100) {
                return Dp.m7544constructorimpl(0);
            }

            /* JADX INFO: renamed from: access$getSpacing-D9Ej5fM$jd, reason: not valid java name */
            public static /* synthetic */ float m619access$getSpacingD9Ej5fM$jd(Horizontal r100) {
                return m618$default$getSpacingD9Ej5fM(r100);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m620getSpacingD9Ej5fM(Horizontal r100) {
                return CC.m619access$getSpacingD9Ej5fM$jd(r100);
            }
        }

        void arrange(Density r100, int r101, int[] r102, LayoutDirection r103, int[] r104);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo617getSpacingD9Ej5fM();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            /* JADX INFO: renamed from: $default$getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m621$default$getSpacingD9Ej5fM(HorizontalOrVertical r100) {
                return Dp.m7544constructorimpl(0);
            }

            /* JADX INFO: renamed from: access$getSpacing-D9Ej5fM$jd, reason: not valid java name */
            public static /* synthetic */ float m622access$getSpacingD9Ej5fM$jd(HorizontalOrVertical r100) {
                return m621$default$getSpacingD9Ej5fM(r100);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m623getSpacingD9Ej5fM(HorizontalOrVertical r100) {
                return CC.m622access$getSpacingD9Ej5fM$jd(r100);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo617getSpacingD9Ej5fM();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J$\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010\rJ\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JB\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSpace-D9Ej5fM", "()F", FaceService.girlLabel, "getRtlMirror", "()Z", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "spacing", "getSpacing-D9Ej5fM", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "toString", "", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SpacedAligned implements HorizontalOrVertical {
        public static final int $stable = 0;
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;

        /* JADX INFO: renamed from: space, reason: collision with root package name */
        private final float f5974space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float r100, boolean r101, Function2 r102, DefaultConstructorMarker r103) {
            this(r100, r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-8Feqmps$default, reason: not valid java name */
        public static /* synthetic */ SpacedAligned m624copy8Feqmps$default(SpacedAligned r100, float r101, boolean r102, Function2 r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.f5974space;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.rtlMirror;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.alignment;
        L12:
            return r100.m626copy8Feqmps(r101, r102, r103);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
        public final float m625component1D9Ej5fM() {
            return this.f5974space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        /* JADX INFO: renamed from: copy-8Feqmps, reason: not valid java name */
        public final SpacedAligned m626copy8Feqmps(float r100, boolean r101, Function2<? super Integer, ? super LayoutDirection, Integer> r102) {
            return new SpacedAligned(r100, r101, r102, null);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SpacedAligned) == true) goto L8;
            return false;
        L8:
            SpacedAligned r101 = (SpacedAligned) r100;
            if (Dp.m7549equalsimpl0(this.f5974space, r101.f5974space) == true) goto L12;
            return false;
        L12:
            if (this.rtlMirror == r101.rtlMirror) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.alignment, r101.alignment) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = Dp.m7550hashCodeimpl(this.f5974space) * 31;
            if (this.rtlMirror == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            Function2<Integer, LayoutDirection, Integer> r103 = this.alignment;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder();
            if (this.rtlMirror == false) goto L5;
            String r101 = "";
        L6:
            r100.append(r101);
            r100.append("Arrangement#spacedAligned(");
            r100.append(Dp.m7555toStringimpl(this.f5974space));
            r100.append(", ");
            r100.append(this.alignment);
            r100.append(')');
            return r100.toString();
        L5:
            r101 = "Absolute";
            goto L6
        }

        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        /* JADX INFO: renamed from: getSpace-D9Ej5fM, reason: not valid java name */
        public final float m627getSpaceD9Ej5fM() {
            return this.f5974space;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo617getSpacingD9Ej5fM() {
            return this.spacing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SpacedAligned(float r100, boolean r101, Function2<? super Integer, ? super LayoutDirection, Integer> r102) {
            this.f5974space = r100;
            this.rtlMirror = r101;
            this.alignment = r102;
            this.spacing = r100;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density r100, int r101, int[] r102, int[] r110) {
            arrange(r100, r101, r102, LayoutDirection.Ltr, r110);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density r110, int r111, int[] r112, LayoutDirection r113, int[] r114) {
            int r100 = 0;
            if (r112.length != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            return;
        L8:
            int r115 = r110.mo365roundToPx0680j_4(this.f5974space);
            if (this.rtlMirror == true) goto L11;
        L13:
            boolean r102 = false;
        L14:
            Arrangement r103 = Arrangement.INSTANCE;
            if (r102 == true) goto L19;
            int r104 = r112.length;
            int r105 = 0;
            int r106 = 0;
            int r107 = 0;
            int r108 = 0;
        L17:
            if (r105 >= r104) goto L23;
            int r109 = r112[r105];
            int r116 = Math.min(r106, r111 - r109);
            r114[r108] = r116;
            int r117 = Math.min(r115, (r111 - r116) - r109);
            int r118 = (r114[r108] + r109) + r117;
            r105 = r105 + 1;
            r108 = r108 + 1;
            r107 = r117;
            r106 = r118;
        L23:
            int r119 = r106 - r107;
            Function2<Integer, LayoutDirection, Integer> r120 = this.alignment;
            if (r120 == null) goto L29;
            if (r119 >= r111) goto L33;
            int r121 = r120.invoke(Integer.valueOf(r111 - r119), r113).intValue();
            int r122 = r114.length;
        L27:
            if (r100 >= r122) goto L34;
            r114[r100] = r114[r100] + r121;
            r100 = r100 + 1;
            goto L27
        L34:
            return;
        L33:
            return;
        L29:
            return;
        L19:
            int r123 = r112.length - 1;
            r106 = 0;
            r107 = 0;
        L21:
            if ((-1) >= r123) goto L23;
            int r124 = r112[r123];
            int r125 = Math.min(r106, r111 - r124);
            r114[r123] = r125;
            r107 = Math.min(r115, (r111 - r125) - r124);
            r106 = (r114[r123] + r124) + r107;
            r123 = r123 - 1;
            goto L21
        L11:
            if (r113 != LayoutDirection.Rtl) goto L13;
            r102 = true;
            goto L14
        L5:
            r101 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Vertical {

        /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$Vertical$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            /* JADX INFO: renamed from: $default$getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m628$default$getSpacingD9Ej5fM(Vertical r100) {
                return Dp.m7544constructorimpl(0);
            }

            /* JADX INFO: renamed from: access$getSpacing-D9Ej5fM$jd, reason: not valid java name */
            public static /* synthetic */ float m629access$getSpacingD9Ej5fM$jd(Vertical r100) {
                return m628$default$getSpacingD9Ej5fM(r100);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m630getSpacingD9Ej5fM(Vertical r100) {
                return CC.m629access$getSpacingD9Ej5fM$jd(r100);
            }
        }

        void arrange(Density r100, int r101, int[] r102, int[] r103);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo617getSpacingD9Ej5fM();
    }

    private Arrangement() {
    }

    public static /* synthetic */ int a(Alignment.Vertical r100, int r101, LayoutDirection r102) {
        return aligned$lambda$4(r100, r101, r102);
    }

    public static /* synthetic */ int b(int r100, LayoutDirection r101) {
        return spacedBy_0680j_4$lambda$0(r100, r101);
    }

    public static /* synthetic */ int c(Alignment.Vertical r100, int r101, LayoutDirection r102) {
        return spacedBy_D5KLDUw$lambda$2(r100, r101, r102);
    }

    public static /* synthetic */ int d(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
        return spacedBy_D5KLDUw$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ int e(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
        return aligned$lambda$3(r100, r101, r102);
    }

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getCenter$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    static {
        INSTANCE = new Arrangement();
        Start = new Arrangement$Start$1();
        End = new Arrangement$End$1();
        Top = new Arrangement$Top$1();
        Bottom = new Arrangement$Bottom$1();
        Center = new Arrangement$Center$1();
        SpaceEvenly = new Arrangement$SpaceEvenly$1();
        SpaceBetween = new Arrangement$SpaceBetween$1();
        SpaceAround = new Arrangement$SpaceAround$1();
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Vertical getTop() {
        return Top;
    }

    public final Horizontal aligned(final Alignment.Horizontal r100) {
        return new SpacedAligned(Dp.m7544constructorimpl(0), true, new c(r100), null);
    }

    /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
    public final HorizontalOrVertical m611spacedBy0680j_4(float r100) {
        boolean r101 = true;
        return new SpacedAligned(r100, r101, new b(), null);
    }

    public final Vertical aligned(final Alignment.Vertical r100) {
        return new SpacedAligned(Dp.m7544constructorimpl(0), false, new e(r100), null);
    }

    private static final int spacedBy_0680j_4$lambda$0(int r100, LayoutDirection r101) {
        return Alignment.Companion.getStart().align(0, r100, r101);
    }

    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Horizontal m612spacedByD5KLDUw(float r100, final Alignment.Horizontal r101) {
        boolean r102 = true;
        return new SpacedAligned(r100, r102, new d(r101), null);
    }

    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Vertical m613spacedByD5KLDUw(float r100, final Alignment.Vertical r101) {
        boolean r102 = false;
        return new SpacedAligned(r100, r102, new f(r101), null);
    }

    private static final int aligned$lambda$3(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
        return r100.align(0, r101, r102);
    }

    private static final int aligned$lambda$4(Alignment.Vertical r100, int r101, LayoutDirection r102) {
        return r100.align(0, r101);
    }

    private final void forEachIndexed(int[] r100, boolean r101, Function2<? super Integer, ? super Integer, Unit> r102) {
        if (r101 == true) goto L6;
        int r103 = r100.length;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r103) goto L10;
        r102.invoke(Integer.valueOf(r105), Integer.valueOf(r100[r104]));
        r104 = r104 + 1;
        r105 = r105 + 1;
        goto L4
    L10:
        return;
    L6:
        int r106 = r100.length;
    L7:
        r106 = r106 - 1;
        if ((-1) >= r106) goto L13;
        r102.invoke(Integer.valueOf(r106), Integer.valueOf(r100[r106]));
        goto L7
    }

    private static final int spacedBy_D5KLDUw$lambda$1(Alignment.Horizontal r100, int r101, LayoutDirection r102) {
        return r100.align(0, r101, r102);
    }

    private static final int spacedBy_D5KLDUw$lambda$2(Alignment.Vertical r100, int r101, LayoutDirection r102) {
        return r100.align(0, r101);
    }

    public final void placeLeftOrTop$foundation_layout(int[] r100, int[] r101, boolean r102) {
        int r103 = 0;
        if (r102 == true) goto L7;
        int r104 = r100.length;
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r103 >= r104) goto L11;
        int r107 = r100[r103];
        r101[r105] = r106;
        r106 = r106 + r107;
        r103 = r103 + 1;
        r105 = r105 + 1;
        goto L5
    L11:
        return;
    L7:
        int r108 = r100.length;
    L8:
        r108 = r108 - 1;
        if ((-1) >= r108) goto L14;
        int r109 = r100[r108];
        r101[r108] = r103;
        r103 = r103 + r109;
        goto L8
    }

    public final void placeCenter$foundation_layout(int r100, int[] r101, int[] r102, boolean r103) {
        int r104 = r101.length;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r106 >= r104) goto L5;
        r107 = r107 + r101[r106];
        r106 = r106 + 1;
        goto L3
    L5:
        float r108 = (r100 - r107) / 2;
        if (r103 == true) goto L10;
        int r109 = r101.length;
        int r110 = 0;
    L8:
        if (r105 >= r109) goto L14;
        int r111 = r101[r105];
        r102[r110] = Math.round(r108);
        r108 = r108 + r111;
        r105 = r105 + 1;
        r110 = r110 + 1;
        goto L8
    L14:
        return;
    L10:
        int r112 = r101.length;
    L11:
        r112 = r112 - 1;
        if ((-1) >= r112) goto L18;
        int r113 = r101[r112];
        r102[r112] = Math.round(r108);
        r108 = r108 + r113;
        goto L11
    }

    public final void placeRightOrBottom$foundation_layout(int r100, int[] r101, int[] r102, boolean r103) {
        int r104 = r101.length;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r106 >= r104) goto L5;
        r107 = r107 + r101[r106];
        r106 = r106 + 1;
        goto L3
    L5:
        int r108 = r100 - r107;
        if (r103 == true) goto L10;
        int r109 = r101.length;
        int r110 = 0;
    L8:
        if (r105 >= r109) goto L14;
        int r111 = r101[r105];
        r102[r110] = r108;
        r108 = r108 + r111;
        r105 = r105 + 1;
        r110 = r110 + 1;
        goto L8
    L14:
        return;
    L10:
        int r112 = r101.length;
    L11:
        r112 = r112 - 1;
        if ((-1) >= r112) goto L18;
        int r113 = r101[r112];
        r102[r112] = r108;
        r108 = r108 + r113;
        goto L11
    }

    public final void placeSpaceAround$foundation_layout(int r100, int[] r101, int[] r102, boolean r110) {
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r103) goto L6;
        r106 = r106 + r101[r105];
        r105 = r105 + 1;
        goto L3
    L6:
        if (r101.length != 0) goto L8;
        boolean r107 = true;
    L10:
        if ((!r107) == false) goto L12;
        float r108 = (r100 - r106) / r101.length;
    L13:
        float r109 = r108 / 2;
        if (r110 == true) goto L18;
        int r111 = r101.length;
        int r112 = 0;
    L16:
        if (r104 >= r111) goto L22;
        int r113 = r101[r104];
        r102[r112] = Math.round(r109);
        r109 = r109 + (r113 + r108);
        r104 = r104 + 1;
        r112 = r112 + 1;
        goto L16
    L22:
        return;
    L18:
        int r114 = r101.length - 1;
    L20:
        if ((-1) >= r114) goto L26;
        int r115 = r101[r114];
        r102[r114] = Math.round(r109);
        r109 = r109 + (r115 + r108);
        r114 = r114 - 1;
        goto L20
    L26:
        return;
    L12:
        r108 = 0.0f;
        goto L13
    L8:
        r107 = false;
        goto L10
    }

    public final void placeSpaceBetween$foundation_layout(int r100, int[] r101, int[] r102, boolean r110) {
        int r103 = 0;
        if (r101.length != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return;
    L8:
        int r105 = r101.length;
        int r106 = 0;
        int r107 = 0;
    L9:
        if (r106 >= r105) goto L11;
        r107 = r107 + r101[r106];
        r106 = r106 + 1;
        goto L9
    L11:
        float r108 = (r100 - r107) / Math.max(ArraysKt.getLastIndex(r101), 1);
        if (r110 == true) goto L14;
    L16:
        float r109 = 0.0f;
    L17:
        if (r110 == true) goto L21;
        int r111 = r101.length;
        int r112 = 0;
    L19:
        if (r103 >= r111) goto L25;
        int r113 = r101[r103];
        r102[r112] = Math.round(r109);
        r109 = r109 + (r113 + r108);
        r103 = r103 + 1;
        r112 = r112 + 1;
        goto L19
    L25:
        return;
    L21:
        int r114 = r101.length - 1;
    L23:
        if ((-1) >= r114) goto L29;
        int r115 = r101[r114];
        r102[r114] = Math.round(r109);
        r109 = r109 + (r115 + r108);
        r114 = r114 - 1;
        goto L23
    L29:
        return;
    L14:
        if (r101.length != 1) goto L16;
        r109 = r108;
        goto L17
    L5:
        r104 = false;
        goto L6
    }

    public final void placeSpaceEvenly$foundation_layout(int r100, int[] r101, int[] r102, boolean r110) {
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r106 = r106 + r101[r105];
        r105 = r105 + 1;
        goto L3
    L5:
        float r107 = (r100 - r106) / (r101.length + 1);
        if (r110 == true) goto L10;
        int r111 = r101.length;
        float r108 = r107;
        int r109 = 0;
    L8:
        if (r104 >= r111) goto L14;
        int r112 = r101[r104];
        r102[r109] = Math.round(r108);
        r108 = r108 + (r112 + r107);
        r104 = r104 + 1;
        r109 = r109 + 1;
        goto L8
    L14:
        return;
    L10:
        int r113 = r101.length - 1;
        float r114 = r107;
    L12:
        if ((-1) >= r113) goto L18;
        int r115 = r101[r113];
        r102[r113] = Math.round(r114);
        r114 = r114 + (r115 + r107);
        r113 = r113 - 1;
        goto L12
    }
}
