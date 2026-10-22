package androidx.compose.foundation.shape;

import androidx.annotation.IntRange;
import androidx.compose.ui.unit.Dp;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a8\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\u000e\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0003\u0010\u0011\u001a\u00020\u00102\b\b\u0003\u0010\u0012\u001a\u00020\u00102\b\b\u0003\u0010\u0013\u001a\u00020\u00102\b\b\u0003\u0010\u0014\u001a\u00020\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"AbsoluteRoundedCornerShape", "Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteRoundedCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteRoundedCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "", "percent", "", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AbsoluteRoundedCornerShapeKt {
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(CornerSize cornerSize) {
        return new AbsoluteRoundedCornerShape(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i & 4) != 0) {
            f9 = 0.0f;
        }
        if ((i & 8) != 0) {
            f10 = 0.0f;
        }
        return AbsoluteRoundedCornerShape(f, f7, f9, f10);
    }

    /* renamed from: AbsoluteRoundedCornerShape-0680j_4, reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m975AbsoluteRoundedCornerShape0680j_4(float f) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.m979CornerSize0680j_4(f));
    }

    /* renamed from: AbsoluteRoundedCornerShape-a9UjIt4, reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m976AbsoluteRoundedCornerShapea9UjIt4(float f, float f7, float f9, float f10) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.m979CornerSize0680j_4(f), CornerSizeKt.m979CornerSize0680j_4(f7), CornerSizeKt.m979CornerSize0680j_4(f9), CornerSizeKt.m979CornerSize0680j_4(f10));
    }

    /* renamed from: AbsoluteRoundedCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ AbsoluteRoundedCornerShape m977AbsoluteRoundedCornerShapea9UjIt4$default(float f, float f7, float f9, float f10, int i, Object obj) {
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
        return m976AbsoluteRoundedCornerShapea9UjIt4(f, f7, f9, f10);
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float f) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(f));
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = 0;
        }
        if ((i12 & 2) != 0) {
            i6 = 0;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return AbsoluteRoundedCornerShape(i, i6, i10, i11);
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(int i) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(i));
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float f, float f7, float f9, float f10) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(f), CornerSizeKt.CornerSize(f7), CornerSizeKt.CornerSize(f9), CornerSizeKt.CornerSize(f10));
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 100) int i, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 100) int i6, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 100) int i10, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = 100) int i11) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(i), CornerSizeKt.CornerSize(i6), CornerSizeKt.CornerSize(i10), CornerSizeKt.CornerSize(i11));
    }
}
