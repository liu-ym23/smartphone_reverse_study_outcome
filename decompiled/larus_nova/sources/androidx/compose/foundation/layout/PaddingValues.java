package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateLeftPadding", "Landroidx/compose/ui/unit/Dp;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "Absolute", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PaddingValues {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0018\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM$annotations", "()V", FaceService.girlLabel, "getTop-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getBottom-D9Ej5fM$annotations", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float r100, float r101, float r102, float r103, DefaultConstructorMarker r104) {
            this(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m744getBottomD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m745getLeftD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m746getRightD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m747getTopD9Ej5fM$annotations() {
        }

        public int hashCode() {
            return (((((Dp.m7550hashCodeimpl(this.left) * 31) + Dp.m7550hashCodeimpl(this.top)) * 31) + Dp.m7550hashCodeimpl(this.right)) * 31) + Dp.m7550hashCodeimpl(this.bottom);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + Dp.m7555toStringimpl(this.left) + ", top=" + Dp.m7555toStringimpl(this.top) + ", right=" + Dp.m7555toStringimpl(this.right) + ", bottom=" + Dp.m7555toStringimpl(this.bottom) + ')';
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
        public float mo680calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
        public float mo683calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
        public float mo681calculateLeftPaddingu2uoSUM(LayoutDirection r100) {
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
        public float mo682calculateRightPaddingu2uoSUM(LayoutDirection r100) {
            return this.right;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Absolute) == true) goto L5;
            return false;
        L5:
            Absolute r101 = (Absolute) r100;
            if (Dp.m7549equalsimpl0(this.left, r101.left) == true) goto L8;
            return false;
        L8:
            if (Dp.m7549equalsimpl0(this.top, r101.top) == true) goto L10;
            return false;
        L10:
            if (Dp.m7549equalsimpl0(this.right, r101.right) == true) goto L12;
            return false;
        L12:
            if (Dp.m7549equalsimpl0(this.bottom, r101.bottom) == false) goto L18;
            return true;
        L18:
            return false;
        }

        private Absolute(float r100, float r101, float r102, float r103) {
            this.left = r100;
            this.top = r101;
            this.right = r102;
            this.bottom = r103;
            boolean r104 = true;
            if (r100 < 0.0f) goto L5;
            boolean r105 = true;
        L7:
            if (r101 < 0.0f) goto L9;
            boolean r106 = true;
        L10:
            boolean r107 = r105 & r106;
            if (r102 < 0.0f) goto L13;
            boolean r108 = true;
        L14:
            boolean r109 = r107 & r108;
            if (r103 >= 0.0f) goto L19;
            r104 = false;
        L19:
            if ((r109 & r104) == true) goto L22;
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
            return;
        L22:
            return;
        L13:
            r108 = false;
            goto L14
        L9:
            r106 = false;
            goto L10
        L5:
            r105 = false;
            goto L7
        }

        public /* synthetic */ Absolute(float r100, float r101, float r110, float r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            r100 = Dp.m7544constructorimpl(0);
        L5:
            float r102 = r100;
            if ((r112 & 2) == 0) goto L8;
            r101 = Dp.m7544constructorimpl(0);
        L8:
            float r103 = r101;
            if ((r112 & 4) == 0) goto L11;
            r110 = Dp.m7544constructorimpl(0);
        L11:
            float r104 = r110;
            if ((r112 & 8) == 0) goto L14;
            r111 = Dp.m7544constructorimpl(0);
        L14:
            this(r102, r103, r104, r111, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/foundation/layout/PaddingValues;", "getZero$annotations", "getZero", "()Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final PaddingValues Zero = null;

        private Companion() {
        }

        public static /* synthetic */ void getZero$annotations() {
        }

        static {
            $$INSTANCE = new Companion();
            Zero = new Absolute(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }

        public final PaddingValues getZero() {
            return Zero;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    float mo680calculateBottomPaddingD9Ej5fM();

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    float mo681calculateLeftPaddingu2uoSUM(LayoutDirection r100);

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    float mo682calculateRightPaddingu2uoSUM(LayoutDirection r100);

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    float mo683calculateTopPaddingD9Ej5fM();
}
