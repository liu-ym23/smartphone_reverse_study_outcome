package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.ExpressiveMotionTokens;
import androidx.compose.material3.tokens.StandardMotionTokens;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\ba\u0018\u0000 \n2\u00020\u0001:\u0003\n\u000b\fJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/MotionScheme;", "", "defaultSpatialSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", ExifInterface.GPS_DIRECTION_TRUE, "fastSpatialSpec", "slowSpatialSpec", "defaultEffectsSpec", "fastEffectsSpec", "slowEffectsSpec", "Companion", "StandardMotionSchemeImpl", "ExpressiveMotionSchemeImpl", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MotionScheme {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/material3/MotionScheme$Companion;", "", "<init>", "()V", "standard", "Landroidx/compose/material3/MotionScheme;", "standard$material3", "expressive", "expressive$material3", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final MotionScheme expressive$material3() {
            return ExpressiveMotionSchemeImpl.INSTANCE;
        }

        public final MotionScheme standard$material3() {
            return StandardMotionSchemeImpl.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/MotionScheme$ExpressiveMotionSchemeImpl;", "Landroidx/compose/material3/MotionScheme;", "<init>", "()V", "defaultSpatialSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "fastSpatialSpec", "slowSpatialSpec", "defaultEffectsSpec", "fastEffectsSpec", "slowEffectsSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", ExifInterface.GPS_DIRECTION_TRUE, "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExpressiveMotionSchemeImpl implements MotionScheme {
        public static final ExpressiveMotionSchemeImpl INSTANCE = null;
        private static final SpringSpec<Object> defaultEffectsSpec = null;
        private static final SpringSpec<Object> defaultSpatialSpec = null;
        private static final SpringSpec<Object> fastEffectsSpec = null;
        private static final SpringSpec<Object> fastSpatialSpec = null;
        private static final SpringSpec<Object> slowEffectsSpec = null;
        private static final SpringSpec<Object> slowSpatialSpec = null;

        private ExpressiveMotionSchemeImpl() {
        }

        static {
            INSTANCE = new ExpressiveMotionSchemeImpl();
            ExpressiveMotionTokens r100 = ExpressiveMotionTokens.INSTANCE;
            defaultSpatialSpec = AnimationSpecKt.spring$default(r100.getSpringDefaultSpatialDamping(), r100.getSpringDefaultSpatialStiffness(), null, 4, null);
            fastSpatialSpec = AnimationSpecKt.spring$default(r100.getSpringFastSpatialDamping(), r100.getSpringFastSpatialStiffness(), null, 4, null);
            slowSpatialSpec = AnimationSpecKt.spring$default(r100.getSpringSlowSpatialDamping(), r100.getSpringSlowSpatialStiffness(), null, 4, null);
            defaultEffectsSpec = AnimationSpecKt.spring$default(r100.getSpringDefaultEffectsDamping(), r100.getSpringDefaultEffectsStiffness(), null, 4, null);
            fastEffectsSpec = AnimationSpecKt.spring$default(r100.getSpringFastEffectsDamping(), r100.getSpringFastEffectsStiffness(), null, 4, null);
            slowEffectsSpec = AnimationSpecKt.spring$default(r100.getSpringSlowEffectsDamping(), r100.getSpringSlowEffectsStiffness(), null, 4, null);
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> defaultEffectsSpec() {
            SpringSpec<Object> r100 = defaultEffectsSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.defaultEffectsSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> defaultSpatialSpec() {
            SpringSpec<Object> r100 = defaultSpatialSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.defaultSpatialSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> fastEffectsSpec() {
            SpringSpec<Object> r100 = fastEffectsSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.fastEffectsSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> fastSpatialSpec() {
            SpringSpec<Object> r100 = fastSpatialSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.fastSpatialSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> slowEffectsSpec() {
            SpringSpec<Object> r100 = slowEffectsSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.slowEffectsSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> slowSpatialSpec() {
            SpringSpec<Object> r100 = slowSpatialSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.slowSpatialSpec>");
            return r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/MotionScheme$StandardMotionSchemeImpl;", "Landroidx/compose/material3/MotionScheme;", "<init>", "()V", "defaultSpatialSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "fastSpatialSpec", "slowSpatialSpec", "defaultEffectsSpec", "fastEffectsSpec", "slowEffectsSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", ExifInterface.GPS_DIRECTION_TRUE, "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StandardMotionSchemeImpl implements MotionScheme {
        public static final StandardMotionSchemeImpl INSTANCE = null;
        private static final SpringSpec<Object> defaultEffectsSpec = null;
        private static final SpringSpec<Object> defaultSpatialSpec = null;
        private static final SpringSpec<Object> fastEffectsSpec = null;
        private static final SpringSpec<Object> fastSpatialSpec = null;
        private static final SpringSpec<Object> slowEffectsSpec = null;
        private static final SpringSpec<Object> slowSpatialSpec = null;

        private StandardMotionSchemeImpl() {
        }

        static {
            INSTANCE = new StandardMotionSchemeImpl();
            StandardMotionTokens r100 = StandardMotionTokens.INSTANCE;
            defaultSpatialSpec = AnimationSpecKt.spring$default(r100.getSpringDefaultSpatialDamping(), r100.getSpringDefaultSpatialStiffness(), null, 4, null);
            fastSpatialSpec = AnimationSpecKt.spring$default(r100.getSpringFastSpatialDamping(), r100.getSpringFastSpatialStiffness(), null, 4, null);
            slowSpatialSpec = AnimationSpecKt.spring$default(r100.getSpringSlowSpatialDamping(), r100.getSpringSlowSpatialStiffness(), null, 4, null);
            defaultEffectsSpec = AnimationSpecKt.spring$default(r100.getSpringDefaultEffectsDamping(), r100.getSpringDefaultEffectsStiffness(), null, 4, null);
            fastEffectsSpec = AnimationSpecKt.spring$default(r100.getSpringFastEffectsDamping(), r100.getSpringFastEffectsStiffness(), null, 4, null);
            slowEffectsSpec = AnimationSpecKt.spring$default(r100.getSpringSlowEffectsDamping(), r100.getSpringSlowEffectsStiffness(), null, 4, null);
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> defaultEffectsSpec() {
            SpringSpec<Object> r100 = defaultEffectsSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.defaultEffectsSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> defaultSpatialSpec() {
            SpringSpec<Object> r100 = defaultSpatialSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.defaultSpatialSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> fastEffectsSpec() {
            SpringSpec<Object> r100 = fastEffectsSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.fastEffectsSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> fastSpatialSpec() {
            SpringSpec<Object> r100 = fastSpatialSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.fastSpatialSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> slowEffectsSpec() {
            SpringSpec<Object> r100 = slowEffectsSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.slowEffectsSpec>");
            return r100;
        }

        @Override // androidx.compose.material3.MotionScheme
        public <T> FiniteAnimationSpec<T> slowSpatialSpec() {
            SpringSpec<Object> r100 = slowSpatialSpec;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.slowSpatialSpec>");
            return r100;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    <T> FiniteAnimationSpec<T> defaultEffectsSpec();

    <T> FiniteAnimationSpec<T> defaultSpatialSpec();

    <T> FiniteAnimationSpec<T> fastEffectsSpec();

    <T> FiniteAnimationSpec<T> fastSpatialSpec();

    <T> FiniteAnimationSpec<T> slowEffectsSpec();

    <T> FiniteAnimationSpec<T> slowSpatialSpec();
}
