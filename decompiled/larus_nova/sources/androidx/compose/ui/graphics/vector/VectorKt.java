package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a(\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*¢\u0006\u0002\b-H\u0086\b\u001a\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001\u001a\u001b\u00100\u001a\u000201*\u00020!2\u0006\u00102\u001a\u00020!H\u0000¢\u0006\u0004\b3\u00104\u001a\u0013\u00105\u001a\u00020!*\u00020!H\u0000¢\u0006\u0004\b6\u00107\u001a\u000e\u00108\u001a\u000201*\u0004\u0018\u000109H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0015\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u0013\u0010\u001a\u001a\u00020\u001b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018\"\u0013\u0010\u001d\u001a\u00020\u001e¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0018\"\u0013\u0010 \u001a\u00020!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#\"\u0013\u0010%\u001a\u00020&¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0018¨\u0006:"}, d2 = {"DefaultGroupName", "", "DefaultRotation", "", "DefaultPivotX", "DefaultPivotY", "DefaultScaleX", "DefaultScaleY", "DefaultTranslationX", "DefaultTranslationY", "EmptyPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "getEmptyPath", "()Ljava/util/List;", "DefaultPathName", "DefaultStrokeLineWidth", "DefaultStrokeLineMiter", "DefaultTrimPathStart", "DefaultTrimPathEnd", "DefaultTrimPathOffset", "DefaultStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultStrokeLineCap", "()I", "I", "DefaultStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultStrokeLineJoin", "DefaultTintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultTintBlendMode", "DefaultTintColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultTintColor", "()J", "J", "DefaultFillType", "Landroidx/compose/ui/graphics/PathFillType;", "getDefaultFillType", "PathData", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "Lkotlin/ExtensionFunctionType;", "addPathNodes", "pathStr", "rgbEqual", "", "other", "rgbEqual--OWjLjI", "(JJ)Z", "toOpaque", "toOpaque-8_81llA", "(J)J", "tintableWithAlphaMask", "Landroidx/compose/ui/graphics/ColorFilter;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VectorKt {
    private static final int DefaultFillType = 0;
    public static final String DefaultGroupName = "";
    public static final String DefaultPathName = "";
    public static final float DefaultPivotX = 0.0f;
    public static final float DefaultPivotY = 0.0f;
    public static final float DefaultRotation = 0.0f;
    public static final float DefaultScaleX = 1.0f;
    public static final float DefaultScaleY = 1.0f;
    private static final int DefaultStrokeLineCap = 0;
    private static final int DefaultStrokeLineJoin = 0;
    public static final float DefaultStrokeLineMiter = 4.0f;
    public static final float DefaultStrokeLineWidth = 0.0f;
    private static final int DefaultTintBlendMode = 0;
    private static final long DefaultTintColor = 0;
    public static final float DefaultTranslationX = 0.0f;
    public static final float DefaultTranslationY = 0.0f;
    public static final float DefaultTrimPathEnd = 1.0f;
    public static final float DefaultTrimPathOffset = 0.0f;
    public static final float DefaultTrimPathStart = 0.0f;
    private static final List<PathNode> EmptyPath = null;

    static {
        EmptyPath = CollectionsKt.emptyList();
        DefaultStrokeLineCap = StrokeCap.Companion.m5206getButtKaPHkGw();
        DefaultStrokeLineJoin = StrokeJoin.Companion.m5217getMiterLxFBmk8();
        DefaultTintBlendMode = BlendMode.Companion.m4766getSrcIn0nO6VwU();
        DefaultTintColor = Color.Companion.m4862getTransparent0d7_KjU();
        DefaultFillType = PathFillType.Companion.m5131getNonZeroRgk1Os();
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

    public static final List<PathNode> PathData(Function1<? super PathBuilder, Unit> r100) {
        PathBuilder r101 = new PathBuilder();
        r100.invoke(r101);
        return r101.getNodes();
    }

    public static final List<PathNode> addPathNodes(String r100) {
        if (r100 != null) goto L5;
        return EmptyPath;
    L5:
        return new PathParser().parsePathString(r100).toNodes();
    }

    public static final boolean tintableWithAlphaMask(ColorFilter r100) {
        if ((r100 instanceof BlendModeColorFilter) == false) goto L9;
        BlendModeColorFilter r101 = (BlendModeColorFilter) r100;
        int r102 = r101.m4770getBlendMode0nO6VwU();
        BlendMode.Companion r103 = BlendMode.Companion;
        if (BlendMode.m4737equalsimpl0(r102, r103.m4766getSrcIn0nO6VwU()) == false) goto L7;
        return true;
    L7:
        if (BlendMode.m4737equalsimpl0(r101.m4770getBlendMode0nO6VwU(), r103.m4768getSrcOver0nO6VwU()) == true) goto L14;
    L11:
        return false;
    L14:
        return true;
    L9:
        if (r100 != null) goto L11;
        return true;
    }

    /* JADX INFO: renamed from: toOpaque-8_81llA, reason: not valid java name */
    public static final long m5585toOpaque8_81llA(long r100) {
        if (Color.m4829getAlphaimpl(r100) != 1.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r100;
    L8:
        return Color.m4826copywmQWz5c$default(r100, 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: rgbEqual--OWjLjI, reason: not valid java name */
    public static final boolean m5584rgbEqualOWjLjI(long r100, long r101) {
        if (Color.m4833getRedimpl(r100) != Color.m4833getRedimpl(r101)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L18:
        return false;
    L8:
        if (Color.m4832getGreenimpl(r100) != Color.m4832getGreenimpl(r101)) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L18;
        if (Color.m4830getBlueimpl(r100) != Color.m4830getBlueimpl(r101)) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        return true;
    L15:
        r104 = false;
        goto L16
    L10:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L6
    }
}
