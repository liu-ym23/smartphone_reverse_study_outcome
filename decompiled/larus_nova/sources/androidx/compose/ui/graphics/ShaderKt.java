package androidx.compose.ui.graphics;

import android.graphics.Shader;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000e\u001aK\u0010\u000f\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013\u001a9\u0010\u0014\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0017\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001d\u001a1\u0010\u001e\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u00022\n\u0010 \u001a\u00060\u0001j\u0002`\u00022\u0006\u0010!\u001a\u00020\"¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"LinearGradientShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "from", "Landroidx/compose/ui/geometry/Offset;", RemoteMessageConst.TO, "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", "radius", "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ImageShader", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "CompositeShader", "dst", "src", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "CompositeShader-7EN7VTw", "(Landroid/graphics/Shader;Landroid/graphics/Shader;I)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShaderKt {
    /* JADX INFO: renamed from: CompositeShader-7EN7VTw, reason: not valid java name */
    public static final Shader m5163CompositeShader7EN7VTw(Shader r100, Shader r101, int r102) {
        return AndroidShader_androidKt.m4725ActualCompositeShader7EN7VTw(r100, r101, r102);
    }

    /* JADX INFO: renamed from: ImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m5164ImageShaderF49vj9s(ImageBitmap r100, int r101, int r102) {
        return AndroidShader_androidKt.m4726ActualImageShaderF49vj9s(r100, r101, r102);
    }

    /* JADX INFO: renamed from: SweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m5170SweepGradientShader9KIMszo(long r100, List<Color> r101, List<Float> r102) {
        return AndroidShader_androidKt.m4729ActualSweepGradientShader9KIMszo(r100, r101, r102);
    }

    /* JADX INFO: renamed from: ImageShader-F49vj9s$default, reason: not valid java name */
    public static /* synthetic */ Shader m5165ImageShaderF49vj9s$default(ImageBitmap r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = TileMode.Companion.m5226getClamp3opZhB0();
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = TileMode.Companion.m5226getClamp3opZhB0();
    L9:
        return m5164ImageShaderF49vj9s(r100, r101, r102);
    }

    /* JADX INFO: renamed from: LinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m5166LinearGradientShaderVjE6UOU(long r100, long r101, List<Color> r102, List<Float> r103, int r104) {
        return AndroidShader_androidKt.m4727ActualLinearGradientShaderVjE6UOU(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: RadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m5168RadialGradientShader8uybcMk(long r100, float r101, List<Color> r102, List<Float> r103, int r104) {
        return AndroidShader_androidKt.m4728ActualRadialGradientShader8uybcMk(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: SweepGradientShader-9KIMszo$default, reason: not valid java name */
    public static /* synthetic */ Shader m5171SweepGradientShader9KIMszo$default(long r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = null;
    L6:
        return m5170SweepGradientShader9KIMszo(r100, r101, r102);
    }

    /* JADX INFO: renamed from: LinearGradientShader-VjE6UOU$default, reason: not valid java name */
    public static /* synthetic */ Shader m5167LinearGradientShaderVjE6UOU$default(long r100, long r101, List r110, List r111, int r112, int r113, Object r114) {
        if ((r113 & 8) == 0) goto L5;
        r111 = null;
    L5:
        List r102 = r111;
        if ((r113 & 16) == 0) goto L9;
        r112 = TileMode.Companion.m5226getClamp3opZhB0();
    L9:
        return m5166LinearGradientShaderVjE6UOU(r100, r101, r110, r102, r112);
    }

    /* JADX INFO: renamed from: RadialGradientShader-8uybcMk$default, reason: not valid java name */
    public static /* synthetic */ Shader m5169RadialGradientShader8uybcMk$default(long r100, float r101, List r102, List r110, int r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = null;
    L5:
        List r103 = r110;
        if ((r112 & 16) == 0) goto L9;
        r111 = TileMode.Companion.m5226getClamp3opZhB0();
    L9:
        return m5168RadialGradientShader8uybcMk(r100, r101, r102, r103, r111);
    }
}
