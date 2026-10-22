package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0011J5\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH&¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H&¢\u0006\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u0010\b\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u0010\t\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00102R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R\u0014\u0010\u000b\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00102R\u0014\u00107\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00102R\u0014\u00109\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00102R\u001c\u0010?\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010B\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001c\u0010E\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R\u001c\u0010H\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>R\u001c\u0010K\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\u001c\u0010N\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bL\u00102\"\u0004\bM\u0010\u0011R\u001c\u0010Q\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bO\u00102\"\u0004\bP\u0010\u0011R\u001c\u0010T\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\bR\u0010<\"\u0004\bS\u0010>R\u001c\u0010W\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\bU\u0010<\"\u0004\bV\u0010>R\u001c\u0010Z\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\bX\u0010<\"\u0004\bY\u0010>R\u001c\u0010]\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b[\u0010<\"\u0004\b\\\u0010>R\u001c\u0010`\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b^\u0010<\"\u0004\b_\u0010>R\u001c\u0010c\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\ba\u0010<\"\u0004\bb\u0010>R\u001c\u0010h\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010k\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\bi\u0010e\"\u0004\bj\u0010gR\u001c\u0010n\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\bl\u0010<\"\u0004\bm\u0010>R\u001e\u0010t\u001a\u0004\u0018\u00010o8&@&X¦\u000e¢\u0006\f\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010x\u001a\u00020u8&@&X¦\u000e¢\u0006\f\u001a\u0004\bv\u00102\"\u0004\bw\u0010\u0011R\u001e\u0010~\u001a\u0004\u0018\u00010y8&@&X¦\u000e¢\u0006\f\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0015\u0010\u0080\u0001\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010eR \u0010\u0084\u0001\u001a\u00030\u0081\u00018&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u00102\"\u0005\b\u0083\u0001\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0085\u0001À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/DeviceRenderNode;", "", "Landroid/graphics/Outline;", "outline", "LC7/r;", "setOutline", "(Landroid/graphics/Outline;)V", "", "left", "top", "right", "bottom", "", "setPosition", "(IIII)Z", TypedValues.CycleType.S_WAVE_OFFSET, "offsetLeftAndRight", "(I)V", "offsetTopAndBottom", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "drawBlock", "record", "(Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/Path;LS7/k;)V", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "(Landroid/graphics/Matrix;)V", "getInverseMatrix", "Landroid/graphics/Canvas;", "canvas", "drawInto", "(Landroid/graphics/Canvas;)V", "hasOverlappingRendering", "setHasOverlappingRendering", "(Z)Z", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "dumpRenderNodeData", "()Landroidx/compose/ui/platform/DeviceRenderNodeData;", "discardDisplayList", "()V", "", "getUniqueId", "()J", "uniqueId", "getLeft", "()I", "getTop", "getRight", "getBottom", "getWidth", "width", "getHeight", "height", "", "getScaleX", "()F", "setScaleX", "(F)V", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getElevation", "setElevation", "elevation", "getAmbientShadowColor", "setAmbientShadowColor", "ambientShadowColor", "getSpotShadowColor", "setSpotShadowColor", "spotShadowColor", "getRotationZ", "setRotationZ", "rotationZ", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getCameraDistance", "setCameraDistance", "cameraDistance", "getPivotX", "setPivotX", "pivotX", "getPivotY", "setPivotY", "pivotY", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "clipToOutline", "getClipToBounds", "setClipToBounds", "clipToBounds", "getAlpha", "setAlpha", "alpha", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter", "getHasDisplayList", "hasDisplayList", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "compositingStrategy", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DeviceRenderNode {
    void discardDisplayList();

    void drawInto(Canvas canvas);

    DeviceRenderNodeData dumpRenderNodeData();

    float getAlpha();

    int getAmbientShadowColor();

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    int mo5996getBlendMode0nO6VwU();

    int getBottom();

    float getCameraDistance();

    boolean getClipToBounds();

    boolean getClipToOutline();

    ColorFilter getColorFilter();

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    int mo5997getCompositingStrategyNrFUSI();

    float getElevation();

    boolean getHasDisplayList();

    int getHeight();

    void getInverseMatrix(Matrix matrix);

    int getLeft();

    void getMatrix(Matrix matrix);

    float getPivotX();

    float getPivotY();

    RenderEffect getRenderEffect();

    int getRight();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    int getSpotShadowColor();

    int getTop();

    float getTranslationX();

    float getTranslationY();

    long getUniqueId();

    int getWidth();

    void offsetLeftAndRight(int offset);

    void offsetTopAndBottom(int offset);

    void record(CanvasHolder canvasHolder, Path clipPath, S7.k drawBlock);

    void setAlpha(float f);

    void setAmbientShadowColor(int i);

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    void mo5998setBlendModes9anfk8(int i);

    void setCameraDistance(float f);

    void setClipToBounds(boolean z10);

    void setClipToOutline(boolean z10);

    void setColorFilter(ColorFilter colorFilter);

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    void mo5999setCompositingStrategyaDBOjCE(int i);

    void setElevation(float f);

    boolean setHasOverlappingRendering(boolean hasOverlappingRendering);

    void setOutline(Outline outline);

    void setPivotX(float f);

    void setPivotY(float f);

    boolean setPosition(int left, int top, int right, int bottom);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setSpotShadowColor(int i);

    void setTranslationX(float f);

    void setTranslationY(float f);
}
