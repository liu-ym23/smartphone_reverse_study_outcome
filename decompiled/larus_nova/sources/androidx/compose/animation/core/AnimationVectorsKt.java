package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a&\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u001b\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a#\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000b2\u0006\u0010\u0011\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", "", "Landroidx/compose/animation/core/AnimationVector2D;", "v2", "Landroidx/compose/animation/core/AnimationVector3D;", "v3", "Landroidx/compose/animation/core/AnimationVector4D;", DevicePlans.DEVICE_PLAN_VIVO4, "newInstance", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copy", "copyFrom", "", "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationVectorsKt {
    public static final AnimationVector1D AnimationVector(float r100) {
        return new AnimationVector1D(r100);
    }

    public static final <T extends AnimationVector> T copy(T r100) {
        T r101 = (T) newInstance(r100);
        int r102 = r101.getSize$animation_core();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.set$animation_core(r103, r100.get$animation_core(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final <T extends AnimationVector> T newInstance(T r100) {
        T r101 = (T) r100.newVector$animation_core();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return r101;
    }

    public static final AnimationVector2D AnimationVector(float r100, float r101) {
        return new AnimationVector2D(r100, r101);
    }

    public static final <T extends AnimationVector> void copyFrom(T r100, T r101) {
        int r102 = r100.getSize$animation_core();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.set$animation_core(r103, r101.get$animation_core(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final AnimationVector3D AnimationVector(float r100, float r101, float r102) {
        return new AnimationVector3D(r100, r101, r102);
    }

    public static final AnimationVector4D AnimationVector(float r100, float r101, float r102, float r103) {
        return new AnimationVector4D(r100, r101, r102, r103);
    }
}
