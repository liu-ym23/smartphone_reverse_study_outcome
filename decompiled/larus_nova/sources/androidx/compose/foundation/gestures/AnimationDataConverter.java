package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/AnimationDataConverter;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/foundation/gestures/AnimationData;", "Landroidx/compose/animation/core/AnimationVector4D;", "<init>", "()V", "convertToVector", "Lkotlin/Function1;", "getConvertToVector", "()Lkotlin/jvm/functions/Function1;", "convertFromVector", "getConvertFromVector", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimationDataConverter implements TwoWayConverter<AnimationData, AnimationVector4D> {
    public static final AnimationDataConverter INSTANCE = null;

    static {
        INSTANCE = new AnimationDataConverter();
    }

    private AnimationDataConverter() {
    }

    public static /* synthetic */ AnimationData a(AnimationVector4D r100) {
        return _get_convertFromVector_$lambda$1(r100);
    }

    public static /* synthetic */ AnimationVector4D b(AnimationData r100) {
        return _get_convertToVector_$lambda$0(r100);
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1<AnimationVector4D, AnimationData> getConvertFromVector() {
        return new a0();
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1<AnimationData, AnimationVector4D> getConvertToVector() {
        return new z();
    }

    private static final AnimationData _get_convertFromVector_$lambda$1(AnimationVector4D r100) {
        float r101 = r100.getV1();
        float r102 = r100.getV2();
        float r103 = r100.getV3();
        return new AnimationData(r101, Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(r103))), r100.getV4(), null);
    }

    private static final AnimationVector4D _get_convertToVector_$lambda$0(AnimationData r100) {
        return new AnimationVector4D(r100.getZoom(), Float.intBitsToFloat((int) (r100.m396getOffsetF1C5BW0() >> 32)), Float.intBitsToFloat((int) (r100.m396getOffsetF1C5BW0() & BodyPartID.bodyIdMax)), r100.getDegrees());
    }
}
