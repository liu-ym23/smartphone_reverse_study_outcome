package androidx.compose.animation.core;

import S7.k;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\" \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\" \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011\" \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011\" \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011\" \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011\" \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011\" \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00170\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011\" \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0011\" \u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0011\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u0006*\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0006*\u00020(8F¢\u0006\u0006\u001a\u0004\b%\u0010)\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u0006*\u00020*8F¢\u0006\u0006\u001a\u0004\b%\u0010+\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u0006*\u00020,8F¢\u0006\u0006\u001a\u0004\b%\u0010-\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0006*\u00020.8F¢\u0006\u0006\u001a\u0004\b%\u0010/\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\u0006*\u0002008F¢\u0006\u0006\u001a\u0004\b%\u00101\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170\u0006*\u0002028F¢\u0006\u0006\u001a\u0004\b%\u00103\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00170\u0006*\u0002048F¢\u0006\u0006\u001a\u0004\b%\u00105\"!\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u0006*\u0002068F¢\u0006\u0006\u001a\u0004\b%\u00107¨\u00068"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Function1;", "convertToVector", "convertFromVector", "Landroidx/compose/animation/core/TwoWayConverter;", "TwoWayConverter", "(LS7/k;LS7/k;)Landroidx/compose/animation/core/TwoWayConverter;", "", "start", "stop", "fraction", "lerp", "(FFF)F", "Landroidx/compose/animation/core/AnimationVector1D;", "FloatToVector", "Landroidx/compose/animation/core/TwoWayConverter;", "", "IntToVector", "Landroidx/compose/ui/unit/Dp;", "DpToVector", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/animation/core/AnimationVector2D;", "DpOffsetToVector", "Landroidx/compose/ui/geometry/Size;", "SizeToVector", "Landroidx/compose/ui/geometry/Offset;", "OffsetToVector", "Landroidx/compose/ui/unit/IntOffset;", "IntOffsetToVector", "Landroidx/compose/ui/unit/IntSize;", "IntSizeToVector", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "RectToVector", "Lkotlin/Float$Companion;", "getVectorConverter", "(Lkotlin/jvm/internal/f;)Landroidx/compose/animation/core/TwoWayConverter;", "VectorConverter", "Lkotlin/Int$Companion;", "(Lkotlin/jvm/internal/i;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/Dp$Companion;", "(Landroidx/compose/ui/unit/Dp$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/DpOffset$Companion;", "(Landroidx/compose/ui/unit/DpOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Size$Companion;", "(Landroidx/compose/ui/geometry/Size$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "(Landroidx/compose/ui/unit/IntOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntSize$Companion;", "(Landroidx/compose/ui/unit/IntSize$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorConvertersKt {
    private static final TwoWayConverter<Float, AnimationVector1D> FloatToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$1
        public final AnimationVector1D invoke(float f) {
            return new AnimationVector1D(f);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).floatValue());
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$2
        @Override // S7.k
        public final Float invoke(AnimationVector1D animationVector1D) {
            return Float.valueOf(animationVector1D.getValue());
        }
    });
    private static final TwoWayConverter<Integer, AnimationVector1D> IntToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$1
        public final AnimationVector1D invoke(int i) {
            return new AnimationVector1D(i);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$2
        @Override // S7.k
        public final Integer invoke(AnimationVector1D animationVector1D) {
            return Integer.valueOf((int) animationVector1D.getValue());
        }
    });
    private static final TwoWayConverter<Dp, AnimationVector1D> DpToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m196invoke0680j_4(((Dp) obj).m6858unboximpl());
        }

        /* renamed from: invoke-0680j_4, reason: not valid java name */
        public final AnimationVector1D m196invoke0680j_4(float f) {
            return new AnimationVector1D(f);
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Dp.m6842boximpl(m197invokeu2uoSUM((AnimationVector1D) obj));
        }

        /* renamed from: invoke-u2uoSUM, reason: not valid java name */
        public final float m197invokeu2uoSUM(AnimationVector1D animationVector1D) {
            return Dp.m6844constructorimpl(animationVector1D.getValue());
        }
    });
    private static final TwoWayConverter<DpOffset, AnimationVector2D> DpOffsetToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m194invokejoFl9I(((DpOffset) obj).m6913unboximpl());
        }

        /* renamed from: invoke-jo-Fl9I, reason: not valid java name */
        public final AnimationVector2D m194invokejoFl9I(long j5) {
            return new AnimationVector2D(DpOffset.m6905getXD9Ej5fM(j5), DpOffset.m6907getYD9Ej5fM(j5));
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return DpOffset.m6899boximpl(m195invokegVRvYmI((AnimationVector2D) obj));
        }

        /* renamed from: invoke-gVRvYmI, reason: not valid java name */
        public final long m195invokegVRvYmI(AnimationVector2D animationVector2D) {
            return DpKt.m6865DpOffsetYgX7TsA(Dp.m6844constructorimpl(animationVector2D.getV1()), Dp.m6844constructorimpl(animationVector2D.getV2()));
        }
    });
    private static final TwoWayConverter<Size, AnimationVector2D> SizeToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m204invokeuvyYCjk(((Size) obj).m3969unboximpl());
        }

        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
        public final AnimationVector2D m204invokeuvyYCjk(long j5) {
            return new AnimationVector2D(Size.m3964getWidthimpl(j5), Size.m3961getHeightimpl(j5));
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Size.m3952boximpl(m205invoke7Ah8Wj8((AnimationVector2D) obj));
        }

        /* renamed from: invoke-7Ah8Wj8, reason: not valid java name */
        public final long m205invoke7Ah8Wj8(AnimationVector2D animationVector2D) {
            return SizeKt.Size(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });
    private static final TwoWayConverter<Offset, AnimationVector2D> OffsetToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m202invokek4lQ0M(((Offset) obj).m3905unboximpl());
        }

        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final AnimationVector2D m202invokek4lQ0M(long j5) {
            return new AnimationVector2D(Offset.m3895getXimpl(j5), Offset.m3896getYimpl(j5));
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.m3884boximpl(m203invoketuRUvjQ((AnimationVector2D) obj));
        }

        /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m203invoketuRUvjQ(AnimationVector2D animationVector2D) {
            return OffsetKt.Offset(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });
    private static final TwoWayConverter<IntOffset, AnimationVector2D> IntOffsetToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m198invokegyyYBs(((IntOffset) obj).m6981unboximpl());
        }

        /* renamed from: invoke--gyyYBs, reason: not valid java name */
        public final AnimationVector2D m198invokegyyYBs(long j5) {
            return new AnimationVector2D(IntOffset.m6972getXimpl(j5), IntOffset.m6973getYimpl(j5));
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.m6963boximpl(m199invokeBjo55l4((AnimationVector2D) obj));
        }

        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
        public final long m199invokeBjo55l4(AnimationVector2D animationVector2D) {
            return IntOffsetKt.IntOffset(Math.round(animationVector2D.getV1()), Math.round(animationVector2D.getV2()));
        }
    });
    private static final TwoWayConverter<IntSize, AnimationVector2D> IntSizeToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m200invokeozmzZPI(((IntSize) obj).m7019unboximpl());
        }

        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
        public final AnimationVector2D m200invokeozmzZPI(long j5) {
            return new AnimationVector2D(IntSize.m7015getWidthimpl(j5), IntSize.m7014getHeightimpl(j5));
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m7007boximpl(m201invokeYEO4UFw((AnimationVector2D) obj));
        }

        /* renamed from: invoke-YEO4UFw, reason: not valid java name */
        public final long m201invokeYEO4UFw(AnimationVector2D animationVector2D) {
            int iRound = Math.round(animationVector2D.getV1());
            if (iRound < 0) {
                iRound = 0;
            }
            int iRound2 = Math.round(animationVector2D.getV2());
            return IntSizeKt.IntSize(iRound, iRound2 >= 0 ? iRound2 : 0);
        }
    });
    private static final TwoWayConverter<Rect, AnimationVector4D> RectToVector = TwoWayConverter(new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$1
        @Override // S7.k
        public final AnimationVector4D invoke(Rect rect) {
            return new AnimationVector4D(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        }
    }, new k() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$2
        @Override // S7.k
        public final Rect invoke(AnimationVector4D animationVector4D) {
            return new Rect(animationVector4D.getV1(), animationVector4D.getV2(), animationVector4D.getV3(), animationVector4D.getV4());
        }
    });

    public static final <T, V extends AnimationVector> TwoWayConverter<T, V> TwoWayConverter(k kVar, k kVar2) {
        return new TwoWayConverterImpl(kVar, kVar2);
    }

    public static final TwoWayConverter<Float, AnimationVector1D> getVectorConverter(f fVar) {
        return FloatToVector;
    }

    public static final float lerp(float f, float f7, float f9) {
        return (f7 * f9) + ((1 - f9) * f);
    }

    public static final TwoWayConverter<Integer, AnimationVector1D> getVectorConverter(i iVar) {
        return IntToVector;
    }

    public static final TwoWayConverter<Rect, AnimationVector4D> getVectorConverter(Rect.Companion companion) {
        return RectToVector;
    }

    public static final TwoWayConverter<Dp, AnimationVector1D> getVectorConverter(Dp.Companion companion) {
        return DpToVector;
    }

    public static final TwoWayConverter<DpOffset, AnimationVector2D> getVectorConverter(DpOffset.Companion companion) {
        return DpOffsetToVector;
    }

    public static final TwoWayConverter<Size, AnimationVector2D> getVectorConverter(Size.Companion companion) {
        return SizeToVector;
    }

    public static final TwoWayConverter<Offset, AnimationVector2D> getVectorConverter(Offset.Companion companion) {
        return OffsetToVector;
    }

    public static final TwoWayConverter<IntOffset, AnimationVector2D> getVectorConverter(IntOffset.Companion companion) {
        return IntOffsetToVector;
    }

    public static final TwoWayConverter<IntSize, AnimationVector2D> getVectorConverter(IntSize.Companion companion) {
        return IntSizeToVector;
    }
}
