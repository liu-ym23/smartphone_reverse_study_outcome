package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000e\u001aK\u0010\u000f\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013\u001a9\u0010\u0014\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0017\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001d\u001a1\u0010\u001e\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u00022\n\u0010 \u001a\u00060\u0001j\u0002`\u00022\u0006\u0010!\u001a\u00020\"¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"LinearGradientShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", TypedValues.TransitionType.S_FROM, "Landroidx/compose/ui/geometry/Offset;", TypedValues.TransitionType.S_TO, "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", "radius", "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ImageShader", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "CompositeShader", "dst", "src", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "CompositeShader-7EN7VTw", "(Landroid/graphics/Shader;Landroid/graphics/Shader;I)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShaderKt {
    /* renamed from: CompositeShader-7EN7VTw, reason: not valid java name */
    public static final Shader m4465CompositeShader7EN7VTw(Shader shader, Shader shader2, int i) {
        return AndroidShader_androidKt.m4037ActualCompositeShader7EN7VTw(shader, shader2, i);
    }

    /* renamed from: ImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m4466ImageShaderF49vj9s(ImageBitmap imageBitmap, int i, int i6) {
        return AndroidShader_androidKt.m4038ActualImageShaderF49vj9s(imageBitmap, i, i6);
    }

    /* renamed from: ImageShader-F49vj9s$default, reason: not valid java name */
    public static /* synthetic */ Shader m4467ImageShaderF49vj9s$default(ImageBitmap imageBitmap, int i, int i6, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i = TileMode.INSTANCE.m4528getClamp3opZhB0();
        }
        if ((i10 & 4) != 0) {
            i6 = TileMode.INSTANCE.m4528getClamp3opZhB0();
        }
        return m4466ImageShaderF49vj9s(imageBitmap, i, i6);
    }

    /* renamed from: LinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m4468LinearGradientShaderVjE6UOU(long j5, long j6, List<Color> list, List<Float> list2, int i) {
        return AndroidShader_androidKt.m4039ActualLinearGradientShaderVjE6UOU(j5, j6, list, list2, i);
    }

    /* renamed from: LinearGradientShader-VjE6UOU$default, reason: not valid java name */
    public static /* synthetic */ Shader m4469LinearGradientShaderVjE6UOU$default(long j5, long j6, List list, List list2, int i, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i6 & 16) != 0) {
            i = TileMode.INSTANCE.m4528getClamp3opZhB0();
        }
        return m4468LinearGradientShaderVjE6UOU(j5, j6, list, list3, i);
    }

    /* renamed from: RadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m4470RadialGradientShader8uybcMk(long j5, float f, List<Color> list, List<Float> list2, int i) {
        return AndroidShader_androidKt.m4040ActualRadialGradientShader8uybcMk(j5, f, list, list2, i);
    }

    /* renamed from: RadialGradientShader-8uybcMk$default, reason: not valid java name */
    public static /* synthetic */ Shader m4471RadialGradientShader8uybcMk$default(long j5, float f, List list, List list2, int i, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i6 & 16) != 0) {
            i = TileMode.INSTANCE.m4528getClamp3opZhB0();
        }
        return m4470RadialGradientShader8uybcMk(j5, f, list, list3, i);
    }

    /* renamed from: SweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m4472SweepGradientShader9KIMszo(long j5, List<Color> list, List<Float> list2) {
        return AndroidShader_androidKt.m4041ActualSweepGradientShader9KIMszo(j5, list, list2);
    }

    /* renamed from: SweepGradientShader-9KIMszo$default, reason: not valid java name */
    public static /* synthetic */ Shader m4473SweepGradientShader9KIMszo$default(long j5, List list, List list2, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = null;
        }
        return m4472SweepGradientShader9KIMszo(j5, list, list2);
    }
}
