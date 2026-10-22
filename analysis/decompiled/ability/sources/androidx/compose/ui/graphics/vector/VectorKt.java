package androidx.compose.ui.graphics.vector;

import S7.k;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\u0011\u001a\u00020\u000e*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0013\u001a\u00020\u000e*\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001a\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019\"\u0014\u0010\u001c\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019\"\u0014\u0010\u001d\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019\"\u0014\u0010\u001e\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019\"\u0014\u0010\u001f\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019\"\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0016\"\u0014\u0010%\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0019\"\u0014\u0010&\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u0019\"\u0014\u0010'\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u0019\"\u0014\u0010(\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u0019\"\u0014\u0010)\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u0019\"\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0017\u00100\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.\"\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.\"\u0017\u00105\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0017\u0010:\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010,\u001a\u0004\b;\u0010.¨\u0006<"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "LC7/r;", "block", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "PathData", "(LS7/k;)Ljava/util/List;", "", "pathStr", "addPathNodes", "(Ljava/lang/String;)Ljava/util/List;", "Landroidx/compose/ui/graphics/Color;", "other", "", "rgbEqual--OWjLjI", "(JJ)Z", "rgbEqual", "Landroidx/compose/ui/graphics/ColorFilter;", "tintableWithAlphaMask", "(Landroidx/compose/ui/graphics/ColorFilter;)Z", "DefaultGroupName", "Ljava/lang/String;", "", "DefaultRotation", "F", "DefaultPivotX", "DefaultPivotY", "DefaultScaleX", "DefaultScaleY", "DefaultTranslationX", "DefaultTranslationY", "EmptyPath", "Ljava/util/List;", "getEmptyPath", "()Ljava/util/List;", "DefaultPathName", "DefaultStrokeLineWidth", "DefaultStrokeLineMiter", "DefaultTrimPathStart", "DefaultTrimPathEnd", "DefaultTrimPathOffset", "Landroidx/compose/ui/graphics/StrokeCap;", "DefaultStrokeLineCap", "I", "getDefaultStrokeLineCap", "()I", "Landroidx/compose/ui/graphics/StrokeJoin;", "DefaultStrokeLineJoin", "getDefaultStrokeLineJoin", "Landroidx/compose/ui/graphics/BlendMode;", "DefaultTintBlendMode", "getDefaultTintBlendMode", "DefaultTintColor", "J", "getDefaultTintColor", "()J", "Landroidx/compose/ui/graphics/PathFillType;", "DefaultFillType", "getDefaultFillType", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorKt {
    public static final String DefaultGroupName = "";
    public static final String DefaultPathName = "";
    public static final float DefaultPivotX = 0.0f;
    public static final float DefaultPivotY = 0.0f;
    public static final float DefaultRotation = 0.0f;
    public static final float DefaultScaleX = 1.0f;
    public static final float DefaultScaleY = 1.0f;
    public static final float DefaultStrokeLineMiter = 4.0f;
    public static final float DefaultStrokeLineWidth = 0.0f;
    public static final float DefaultTranslationX = 0.0f;
    public static final float DefaultTranslationY = 0.0f;
    public static final float DefaultTrimPathEnd = 1.0f;
    public static final float DefaultTrimPathOffset = 0.0f;
    public static final float DefaultTrimPathStart = 0.0f;
    private static final List<PathNode> EmptyPath = EmptyList.f4893a;
    private static final int DefaultStrokeLineCap = StrokeCap.INSTANCE.m4508getButtKaPHkGw();
    private static final int DefaultStrokeLineJoin = StrokeJoin.INSTANCE.m4519getMiterLxFBmk8();
    private static final int DefaultTintBlendMode = BlendMode.INSTANCE.m4078getSrcIn0nO6VwU();
    private static final long DefaultTintColor = Color.INSTANCE.m4174getTransparent0d7_KjU();
    private static final int DefaultFillType = PathFillType.INSTANCE.m4433getNonZeroRgk1Os();

    public static final List<PathNode> PathData(k kVar) {
        PathBuilder pathBuilder = new PathBuilder();
        kVar.invoke(pathBuilder);
        return pathBuilder.getNodes();
    }

    public static final List<PathNode> addPathNodes(String str) {
        return str == null ? EmptyPath : new PathParser().parsePathString(str).toNodes();
    }

    public static final int getDefaultFillType() {
        return DefaultFillType;
    }

    public static final int getDefaultStrokeLineCap() {
        return DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return DefaultStrokeLineJoin;
    }

    public static final int getDefaultTintBlendMode() {
        return DefaultTintBlendMode;
    }

    public static final long getDefaultTintColor() {
        return DefaultTintColor;
    }

    public static final List<PathNode> getEmptyPath() {
        return EmptyPath;
    }

    /* renamed from: rgbEqual--OWjLjI, reason: not valid java name */
    public static final boolean m4882rgbEqualOWjLjI(long j5, long j6) {
        return Color.m4145getRedimpl(j5) == Color.m4145getRedimpl(j6) && Color.m4144getGreenimpl(j5) == Color.m4144getGreenimpl(j6) && Color.m4142getBlueimpl(j5) == Color.m4142getBlueimpl(j6);
    }

    public static final boolean tintableWithAlphaMask(ColorFilter colorFilter) {
        if (!(colorFilter instanceof BlendModeColorFilter)) {
            return colorFilter == null;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) colorFilter;
        int blendMode = blendModeColorFilter.getBlendMode();
        BlendMode.Companion companion = BlendMode.INSTANCE;
        return BlendMode.m4049equalsimpl0(blendMode, companion.m4078getSrcIn0nO6VwU()) || BlendMode.m4049equalsimpl0(blendModeColorFilter.getBlendMode(), companion.m4080getSrcOver0nO6VwU());
    }
}
