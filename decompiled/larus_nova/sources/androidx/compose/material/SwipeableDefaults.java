package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/material/SwipeableDefaults;", "", "<init>", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "VelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "getVelocityThreshold-D9Ej5fM", "()F", FaceService.girlLabel, "StiffResistanceFactor", "StandardResistanceFactor", "resistanceConfig", "Landroidx/compose/material/ResistanceConfig;", "anchors", "", "factorAtMin", "factorAtMax", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeableDefaults {
    public static final int $stable = 0;
    private static final SpringSpec<Float> AnimationSpec = null;
    public static final SwipeableDefaults INSTANCE = null;
    public static final float StandardResistanceFactor = 10.0f;
    public static final float StiffResistanceFactor = 20.0f;
    private static final float VelocityThreshold = 0.0f;

    private SwipeableDefaults() {
    }

    static {
        INSTANCE = new SwipeableDefaults();
        AnimationSpec = new SpringSpec(0.0f, 0.0f, null, 7, null);
        VelocityThreshold = Dp.m7544constructorimpl(125);
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM, reason: not valid java name */
    public final float m1755getVelocityThresholdD9Ej5fM() {
        return VelocityThreshold;
    }

    public final ResistanceConfig resistanceConfig(Set<Float> r100, float r101, float r102) {
        if (r100.size() > 1) goto L5;
        return null;
    L5:
        Set<Float> r103 = r100;
        Float r104 = CollectionsKt.m9877maxOrNull(r103);
        Intrinsics.checkNotNull(r104);
        float r105 = r104.floatValue();
        Float r106 = CollectionsKt.m9879minOrNull(r103);
        Intrinsics.checkNotNull(r106);
        return new ResistanceConfig(r105 - r106.floatValue(), r101, r102);
    }

    public static /* synthetic */ ResistanceConfig resistanceConfig$default(SwipeableDefaults r100, Set r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 10.0f;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 10.0f;
    L9:
        return r100.resistanceConfig(r101, r102, r103);
    }
}
