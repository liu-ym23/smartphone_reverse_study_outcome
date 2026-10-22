package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a9\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\u0002¢\u0006\u0002\u0010\u0006\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a9\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000f\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\u0004\b\u0000\u0010\u00022\u001d\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\b\u001bH\u0007\u001a1\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\b\u0000\u0010\u00022\u001d\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\b\u001b\u001a;\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\b\u0000\u0010\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00112\u001d\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\b\u001b\u001aE\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020!\"\u0004\b\u0000\u0010\u00022\u0006\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010*\u001a4\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020!\"\u0004\b\u0000\u0010\u00022\u0006\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a=\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u00020,\"\u0004\b\u0000\u0010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0004\b-\u0010.\u001a,\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u00020,\"\u0004\b\u0000\u0010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u001e\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u000200\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001a*\u00101\u001a\b\u0012\u0004\u0012\u0002H\u000202\"\u0004\b\u0000\u0010\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u0002022\u0006\u00104\u001a\u000205H\u0001¨\u00066"}, d2 = {"convert", "V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "data", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "tween", "Landroidx/compose/animation/core/TweenSpec;", "durationMillis", "", "delayMillis", "easing", "Landroidx/compose/animation/core/Easing;", "spring", "Landroidx/compose/animation/core/SpringSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)Landroidx/compose/animation/core/SpringSpec;", "keyframes", "Landroidx/compose/animation/core/KeyframesSpec;", "init", "Lkotlin/Function1;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "", "Lkotlin/ExtensionFunctionType;", "keyframesWithSpline", "Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "periodicBias", "repeatable", "Landroidx/compose/animation/core/RepeatableSpec;", "iterations", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "repeatable-91I0pcU", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/RepeatableSpec;", "infiniteRepeatable", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "infiniteRepeatable-9IiC70o", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "snap", "Landroidx/compose/animation/core/SnapSpec;", "delayed", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "startDelayNanos", "", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationSpecKt {
    public static final <T> KeyframesSpec<T> keyframes(Function1<? super KeyframesSpec.KeyframesSpecConfig<T>, Unit> r100) {
        KeyframesSpec.KeyframesSpecConfig r101 = new KeyframesSpec.KeyframesSpecConfig();
        r100.invoke(r101);
        return new KeyframesSpec(r101);
    }

    public static final <T> KeyframesWithSplineSpec<T> keyframesWithSpline(Function1<? super KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T>, Unit> r100) {
        KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig r101 = new KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig();
        r100.invoke(r101);
        return new KeyframesWithSplineSpec(r101);
    }

    public static final <T> SnapSpec<T> snap(int r100) {
        return new SnapSpec(r100);
    }

    public static final /* synthetic */ AnimationVector access$convert(TwoWayConverter r100, Object r101) {
        return convert(r100, r101);
    }

    private static final <T, V extends AnimationVector> V convert(TwoWayConverter<T, V> r100, T r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return r100.getConvertToVector().invoke(r101);
    }

    public static final <T> AnimationSpec<T> delayed(AnimationSpec<T> r100, long r101) {
        return new StartDelayAnimationSpec(r100, r101);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the infinite repeatable function that accepts start offset.")
    public static final /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable(DurationBasedAnimationSpec r100, RepeatMode r101) {
        return new InfiniteRepeatableSpec(r100, r101, StartOffset.m174constructorimpl$default(0, 0, 2, null), null);
    }

    public static final <T> KeyframesWithSplineSpec<T> keyframesWithSpline(float r100, Function1<? super KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T>, Unit> r101) {
        KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig r102 = new KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig();
        r101.invoke(r102);
        return new KeyframesWithSplineSpec(r102, r100);
    }

    /* JADX INFO: renamed from: infiniteRepeatable-9IiC70o, reason: not valid java name */
    public static final <T> InfiniteRepeatableSpec<T> m140infiniteRepeatable9IiC70o(DurationBasedAnimationSpec<T> r100, RepeatMode r101, long r102) {
        return new InfiniteRepeatableSpec(r100, r101, r102, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the repeatable function that accepts start offset.")
    public static final /* synthetic */ RepeatableSpec repeatable(int r100, DurationBasedAnimationSpec r101, RepeatMode r110) {
        return new RepeatableSpec(r100, r101, r110, StartOffset.m174constructorimpl$default(0, 0, 2, null), null);
    }

    public static /* synthetic */ SnapSpec snap$default(int r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        return snap(r100);
    }

    public static final <T> SpringSpec<T> spring(float r100, float r101, T r102) {
        return new SpringSpec(r100, r101, r102);
    }

    public static final <T> TweenSpec<T> tween(int r100, int r101, Easing r102) {
        return new TweenSpec(r100, r101, r102);
    }

    public static /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable$default(DurationBasedAnimationSpec r100, RepeatMode r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = RepeatMode.Restart;
    L6:
        return infiniteRepeatable(r100, r101);
    }

    /* JADX INFO: renamed from: repeatable-91I0pcU, reason: not valid java name */
    public static final <T> RepeatableSpec<T> m142repeatable91I0pcU(int r100, DurationBasedAnimationSpec<T> r101, RepeatMode r110, long r111) {
        return new RepeatableSpec(r100, r101, r110, r111, null);
    }

    /* JADX INFO: renamed from: infiniteRepeatable-9IiC70o$default, reason: not valid java name */
    public static /* synthetic */ InfiniteRepeatableSpec m141infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec r100, RepeatMode r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = RepeatMode.Restart;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = StartOffset.m174constructorimpl$default(0, 0, 2, null);
    L9:
        return m140infiniteRepeatable9IiC70o(r100, r101, r102);
    }

    public static /* synthetic */ RepeatableSpec repeatable$default(int r100, DurationBasedAnimationSpec r101, RepeatMode r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = RepeatMode.Restart;
    L6:
        return repeatable(r100, r101, r102);
    }

    public static /* synthetic */ SpringSpec spring$default(float r100, float r101, Object r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1500.0f;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = null;
    L12:
        return spring(r100, r101, r102);
    }

    public static /* synthetic */ TweenSpec tween$default(int r100, int r101, Easing r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 300;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = EasingKt.getFastOutSlowInEasing();
    L12:
        return tween(r100, r101, r102);
    }

    /* JADX INFO: renamed from: repeatable-91I0pcU$default, reason: not valid java name */
    public static /* synthetic */ RepeatableSpec m143repeatable91I0pcU$default(int r100, DurationBasedAnimationSpec r101, RepeatMode r102, long r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = RepeatMode.Restart;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r103 = StartOffset.m174constructorimpl$default(0, 0, 2, null);
    L9:
        return m142repeatable91I0pcU(r100, r101, r102, r103);
    }
}
