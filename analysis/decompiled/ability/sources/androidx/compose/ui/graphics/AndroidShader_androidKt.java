package androidx.compose.ui.graphics;

import D7.v;
import H4.o;
import android.graphics.BitmapShader;
import android.graphics.ComposeShader;
import android.graphics.Shader;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aI\u0010\u000e\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\r\u001aI\u0010\u0013\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a9\u0010\u0016\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u000f\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u001d\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001f\u001a\u00020\u001e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b\u001f\u0010 \u001a%\u0010#\u001a\u00020\"2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010!\u001a\u00020\u001eH\u0001¢\u0006\u0004\b#\u0010$\u001a7\u0010'\u001a\u0004\u0018\u00010&2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010!\u001a\u00020\u001eH\u0001¢\u0006\u0004\b'\u0010(\u001a-\u0010*\u001a\u00020)2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0002¢\u0006\u0004\b*\u0010+\u001a3\u00102\u001a\u00060\nj\u0002`\u000b2\n\u0010,\u001a\u00060\nj\u0002`\u000b2\n\u0010-\u001a\u00060\nj\u0002`\u000b2\u0006\u0010/\u001a\u00020.H\u0000¢\u0006\u0004\b0\u00101*\n\u00103\"\u00020\n2\u00020\n¨\u00064"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "", "Landroidx/compose/ui/graphics/Color;", "colors", "", "colorStops", "Landroidx/compose/ui/graphics/TileMode;", "tileMode", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualLinearGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ActualSweepGradientShader", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "tileModeX", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "ActualImageShader", "", "countTransparentColors", "(Ljava/util/List;)I", "numTransparentColors", "", "makeTransparentColors", "(Ljava/util/List;I)[I", "stops", "", "makeTransparentStops", "(Ljava/util/List;Ljava/util/List;I)[F", "LC7/r;", "validateColorStops", "(Ljava/util/List;Ljava/util/List;)V", "dst", "src", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "ActualCompositeShader-7EN7VTw", "(Landroid/graphics/Shader;Landroid/graphics/Shader;I)Landroid/graphics/Shader;", "ActualCompositeShader", "Shader", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidShader_androidKt {
    /* renamed from: ActualCompositeShader-7EN7VTw, reason: not valid java name */
    public static final Shader m4037ActualCompositeShader7EN7VTw(Shader shader, Shader shader2, int i) {
        return new ComposeShader(shader, shader2, AndroidBlendMode_androidKt.m3987toAndroidBlendModes9anfk8(i));
    }

    /* renamed from: ActualImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m4038ActualImageShaderF49vj9s(ImageBitmap imageBitmap, int i, int i6) {
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), AndroidTileMode_androidKt.m4043toAndroidTileMode0vamqd0(i), AndroidTileMode_androidKt.m4043toAndroidTileMode0vamqd0(i6));
    }

    /* renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m4039ActualLinearGradientShaderVjE6UOU(long j5, long j6, List<Color> list, List<Float> list2, int i) {
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new android.graphics.LinearGradient(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 >> 32)), Float.intBitsToFloat((int) (j6 & 4294967295L)), makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors), AndroidTileMode_androidKt.m4043toAndroidTileMode0vamqd0(i));
    }

    /* renamed from: ActualRadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m4040ActualRadialGradientShader8uybcMk(long j5, float f, List<Color> list, List<Float> list2, int i) {
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new android.graphics.RadialGradient(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j5 & 4294967295L)), f, makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors), AndroidTileMode_androidKt.m4043toAndroidTileMode0vamqd0(i));
    }

    /* renamed from: ActualSweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m4041ActualSweepGradientShader9KIMszo(long j5, List<Color> list, List<Float> list2) {
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new android.graphics.SweepGradient(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j5 & 4294967295L)), makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors));
    }

    @VisibleForTesting
    public static final int countTransparentColors(List<Color> list) {
        return 0;
    }

    @VisibleForTesting
    public static final int[] makeTransparentColors(List<Color> list, int i) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = ColorKt.m4193toArgb8_81llA(list.get(i6).m4149unboximpl());
        }
        return iArr;
    }

    @VisibleForTesting
    public static final float[] makeTransparentStops(List<Float> list, List<Color> list2, int i) {
        if (i == 0) {
            if (list != null) {
                return v.d1(list);
            }
            return null;
        }
        float[] fArr = new float[list2.size() + i];
        fArr[0] = list != null ? list.get(0).floatValue() : 0.0f;
        int iH = o.H(list2);
        int i6 = 1;
        for (int i10 = 1; i10 < iH; i10++) {
            long jM4149unboximpl = list2.get(i10).m4149unboximpl();
            float fFloatValue = list != null ? list.get(i10).floatValue() : i10 / o.H(list2);
            int i11 = i6 + 1;
            fArr[i6] = fFloatValue;
            if (Color.m4141getAlphaimpl(jM4149unboximpl) == 0.0f) {
                i6 += 2;
                fArr[i11] = fFloatValue;
            } else {
                i6 = i11;
            }
        }
        fArr[i6] = list != null ? list.get(o.H(list2)).floatValue() : 1.0f;
        return fArr;
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
