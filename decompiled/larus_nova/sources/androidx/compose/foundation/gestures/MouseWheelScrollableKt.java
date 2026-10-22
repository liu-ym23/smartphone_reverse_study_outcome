package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"isLowScrollingDelta", "", "", "AnimationThreshold", "Landroidx/compose/ui/unit/Dp;", FaceService.girlLabel, "AnimationSpeed", "MaxAnimationDuration", "", "ScrollProgressTimeout", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MouseWheelScrollableKt {
    private static final float AnimationSpeed = 0.0f;
    private static final float AnimationThreshold = 0.0f;
    private static final int MaxAnimationDuration = 100;
    private static final long ScrollProgressTimeout = 50;

    static {
        AnimationThreshold = Dp.m7544constructorimpl(6);
        AnimationSpeed = Dp.m7544constructorimpl(1);
    }

    public static final /* synthetic */ float access$getAnimationSpeed$p() {
        return AnimationSpeed;
    }

    public static final /* synthetic */ float access$getAnimationThreshold$p() {
        return AnimationThreshold;
    }

    public static final /* synthetic */ boolean access$isLowScrollingDelta(float r100) {
        return isLowScrollingDelta(r100);
    }

    private static final boolean isLowScrollingDelta(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Math.abs(r100) < 0.5f) goto L8;
        return false;
    }
}
