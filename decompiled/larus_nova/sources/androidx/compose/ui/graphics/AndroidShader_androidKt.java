package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.ComposeShader;
import android.graphics.Shader;
import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aI\u0010\u0002\u001a\u00060\u0001j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aI\u0010\u0010\u001a\u00060\u0001j\u0002`\u00032\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a9\u0010\u0015\u001a\u00060\u0001j\u0002`\u00032\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0018\u001a\u00060\u0001j\u0002`\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0016\u0010\u001f\u001a\u00020 2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001\u001a\u001e\u0010!\u001a\u00020\"2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010#\u001a\u00020 H\u0001\u001a0\u0010$\u001a\u0004\u0018\u00010%2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010#\u001a\u00020 H\u0001\u001a&\u0010'\u001a\u00020(2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0002\u001a3\u0010)\u001a\u00060\u0001j\u0002`\u00032\n\u0010*\u001a\u00060\u0001j\u0002`\u00032\n\u0010+\u001a\u00060\u0001j\u0002`\u00032\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0004\b.\u0010/*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00060"}, d2 = {"Shader", "Landroid/graphics/Shader;", "ActualLinearGradientShader", "Landroidx/compose/ui/graphics/Shader;", "from", "Landroidx/compose/ui/geometry/Offset;", RemoteMessageConst.TO, "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualSweepGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ActualImageShader", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "countTransparentColors", "", "makeTransparentColors", "", "numTransparentColors", "makeTransparentStops", "", "stops", "validateColorStops", "", "ActualCompositeShader", "dst", "src", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "ActualCompositeShader-7EN7VTw", "(Landroid/graphics/Shader;Landroid/graphics/Shader;I)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidShader_androidKt {
    public static final int countTransparentColors(List<Color> r100) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return 0;
    L5:
        int r101 = CollectionsKt.getLastIndex(r100);
        int r102 = 1;
        int r103 = 0;
    L6:
        if (r102 >= r101) goto L14;
        if (Color.m4829getAlphaimpl(((Color) ListProtector.get(r100, r102)).m4837unboximpl()) != 0.0f) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        r103 = r103 + 1;
    L13:
        r102 = r102 + 1;
        goto L6
    L10:
        r104 = false;
        goto L11
    L14:
        return r103;
    }

    public static final int[] makeTransparentColors(List<Color> r110, int r111) {
        int r100 = 0;
        if (Build.VERSION.SDK_INT < 26) goto L8;
        int r101 = r110.size();
        int[] r102 = new int[r101];
    L5:
        if (r100 >= r101) goto L7;
        r102[r100] = ColorKt.m4881toArgb8_81llA(((Color) ListProtector.get(r110, r100)).m4837unboximpl());
        r100 = r100 + 1;
        goto L5
    L7:
        return r102;
    L8:
        int[] r103 = new int[r110.size() + r111];
        int r104 = CollectionsKt.getLastIndex(r110);
        int r105 = r110.size();
        int r106 = 0;
        int r107 = 0;
    L9:
        if (r106 >= r105) goto L23;
        long r108 = ((Color) ListProtector.get(r110, r106)).m4837unboximpl();
        if (Color.m4829getAlphaimpl(r108) != 0.0f) goto L13;
        boolean r109 = true;
    L14:
        if (r109 == false) goto L21;
        if (r106 != 0) goto L18;
        int r112 = r107 + 1;
        r103[r107] = ColorKt.m4881toArgb8_81llA(Color.m4826copywmQWz5c$default(((Color) ListProtector.get(r110, 1)).m4837unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
    L17:
        r107 = r112;
    L22:
        r106 = r106 + 1;
        goto L9
    L18:
        if (r106 != r104) goto L20;
        r112 = r107 + 1;
        r103[r107] = ColorKt.m4881toArgb8_81llA(Color.m4826copywmQWz5c$default(((Color) ListProtector.get(r110, r106 - 1)).m4837unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
        goto L17
    L20:
        int r113 = r107 + 1;
        r103[r107] = ColorKt.m4881toArgb8_81llA(Color.m4826copywmQWz5c$default(((Color) ListProtector.get(r110, r106 - 1)).m4837unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
        r107 = r113 + 1;
        r103[r113] = ColorKt.m4881toArgb8_81llA(Color.m4826copywmQWz5c$default(((Color) ListProtector.get(r110, r106 + 1)).m4837unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
        goto L22
    L21:
        r103[r107] = ColorKt.m4881toArgb8_81llA(r108);
        r107 = r107 + 1;
        goto L22
    L13:
        r109 = false;
        goto L14
    L23:
        return r103;
    }

    private static final void validateColorStops(List<Color> r100, List<Float> r101) {
        if (r101 != null) goto L9;
        if (r100.size() < 2) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
    L9:
        if (r100.size() != r101.size()) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
    }

    /* JADX INFO: renamed from: ActualCompositeShader-7EN7VTw, reason: not valid java name */
    public static final Shader m4725ActualCompositeShader7EN7VTw(Shader r100, Shader r101, int r102) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return new ComposeShader(r100, r101, AndroidBlendMode_androidKt.m4674toAndroidBlendModes9anfk8(r102));
    L6:
        return new ComposeShader(r100, r101, AndroidBlendMode_androidKt.m4675toPorterDuffModes9anfk8(r102));
    }

    /* JADX INFO: renamed from: ActualImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m4726ActualImageShaderF49vj9s(ImageBitmap r100, int r101, int r102) {
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(r100), AndroidTileMode_androidKt.m4731toAndroidTileMode0vamqd0(r101), AndroidTileMode_androidKt.m4731toAndroidTileMode0vamqd0(r102));
    }

    /* JADX INFO: renamed from: ActualSweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m4729ActualSweepGradientShader9KIMszo(long r100, List<Color> r101, List<Float> r102) {
        validateColorStops(r101, r102);
        int r103 = countTransparentColors(r101);
        return new android.graphics.SweepGradient(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), makeTransparentColors(r101, r103), makeTransparentStops(r102, r101, r103));
    }

    public static final float[] makeTransparentStops(List<Float> r110, List<Color> r111, int r112) {
        if (r112 != 0) goto L7;
        if (r110 != null) goto L33;
        return null;
    L33:
        return CollectionsKt.toFloatArray(r110);
    L7:
        float[] r113 = new float[r111.size() + r112];
        if (r110 == null) goto L10;
        float r100 = ((Number) ListProtector.get(r110, 0)).floatValue();
    L11:
        r113[0] = r100;
        int r101 = CollectionsKt.getLastIndex(r111);
        int r102 = 1;
        int r103 = 1;
    L12:
        if (r102 >= r101) goto L25;
        long r104 = ((Color) ListProtector.get(r111, r102)).m4837unboximpl();
        if (r110 == null) goto L16;
        float r105 = ((Number) ListProtector.get(r110, r102)).floatValue();
    L17:
        int r106 = r103 + 1;
        r113[r103] = r105;
        if (Color.m4829getAlphaimpl(r104) != 0.0f) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
        r103 = r106 + 1;
        r113[r106] = r105;
    L24:
        r102 = r102 + 1;
        goto L12
    L23:
        r103 = r106;
        goto L24
    L20:
        r107 = false;
        goto L21
    L16:
        r105 = r102 / CollectionsKt.getLastIndex(r111);
        goto L17
    L25:
        if (r110 == null) goto L27;
        float r114 = ((Number) ListProtector.get(r110, CollectionsKt.getLastIndex(r111))).floatValue();
    L28:
        r113[r103] = r114;
        return r113;
    L27:
        r114 = 1.0f;
        goto L28
    L10:
        r100 = 0.0f;
        goto L11
    }

    /* JADX INFO: renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m4727ActualLinearGradientShaderVjE6UOU(long r110, long r111, List<Color> r112, List<Float> r113, int r114) {
        validateColorStops(r112, r113);
        int r100 = countTransparentColors(r112);
        return new android.graphics.LinearGradient(Float.intBitsToFloat((int) (r110 >> 32)), Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r111 >> 32)), Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r111)), makeTransparentColors(r112, r100), makeTransparentStops(r113, r112, r100), AndroidTileMode_androidKt.m4731toAndroidTileMode0vamqd0(r114));
    }

    /* JADX INFO: renamed from: ActualRadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m4728ActualRadialGradientShader8uybcMk(long r100, float r110, List<Color> r111, List<Float> r112, int r113) {
        validateColorStops(r111, r112);
        int r101 = countTransparentColors(r111);
        return new android.graphics.RadialGradient(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), r110, makeTransparentColors(r111, r101), makeTransparentStops(r112, r111, r101), AndroidTileMode_androidKt.m4731toAndroidTileMode0vamqd0(r113));
    }
}
