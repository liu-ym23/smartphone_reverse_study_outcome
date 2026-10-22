package androidx.compose.animation;

import S7.k;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"-\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0000*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "ColorToVector", "LS7/k;", "Landroidx/compose/ui/graphics/Color$Companion;", "getVectorConverter", "(Landroidx/compose/ui/graphics/Color$Companion;)LS7/k;", "VectorConverter", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorVectorConverterKt {
    private static final k ColorToVector = new k() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1
        @Override // S7.k
        public final TwoWayConverter<Color, AnimationVector4D> invoke(final ColorSpace colorSpace) {
            return VectorConvertersKt.TwoWayConverter(new k() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m69invoke8_81llA(((Color) obj).m4149unboximpl());
                }

                /* renamed from: invoke-8_81llA, reason: not valid java name */
                public final AnimationVector4D m69invoke8_81llA(long j5) {
                    long jM4136convertvNxB06k = Color.m4136convertvNxB06k(j5, ColorSpaces.INSTANCE.getOklab());
                    return new AnimationVector4D(Color.m4141getAlphaimpl(jM4136convertvNxB06k), Color.m4145getRedimpl(jM4136convertvNxB06k), Color.m4144getGreenimpl(jM4136convertvNxB06k), Color.m4142getBlueimpl(jM4136convertvNxB06k));
                }
            }, new k() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Color.m4129boximpl(m70invokevNxB06k((AnimationVector4D) obj));
                }

                /* renamed from: invoke-vNxB06k, reason: not valid java name */
                public final long m70invokevNxB06k(AnimationVector4D animationVector4D) {
                    float v22 = animationVector4D.getV2();
                    if (v22 < 0.0f) {
                        v22 = 0.0f;
                    }
                    if (v22 > 1.0f) {
                        v22 = 1.0f;
                    }
                    float v32 = animationVector4D.getV3();
                    if (v32 < -0.5f) {
                        v32 = -0.5f;
                    }
                    if (v32 > 0.5f) {
                        v32 = 0.5f;
                    }
                    float v42 = animationVector4D.getV4();
                    float f = v42 >= -0.5f ? v42 : -0.5f;
                    float f7 = f <= 0.5f ? f : 0.5f;
                    float v12 = animationVector4D.getV1();
                    float f9 = v12 >= 0.0f ? v12 : 0.0f;
                    return Color.m4136convertvNxB06k(ColorKt.Color(v22, v32, f7, f9 <= 1.0f ? f9 : 1.0f, ColorSpaces.INSTANCE.getOklab()), colorSpace);
                }
            });
        }
    };

    public static final k getVectorConverter(Color.Companion companion) {
        return ColorToVector;
    }
}
