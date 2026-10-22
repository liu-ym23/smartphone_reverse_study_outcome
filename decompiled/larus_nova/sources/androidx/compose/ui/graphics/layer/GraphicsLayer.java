package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 »\u00012\u00020\u0001:\u0002»\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010w\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\bx\u0010yJ>\u0010z\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:2\u0017\u0010{\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0004\b|\u0010}J\b\u0010~\u001a\u00020\u000fH\u0002J\f\u0010\u007f\u001a\u00020\u000f*\u00020\u000eH\u0002J\u0012\u0010\u0080\u0001\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u0000H\u0002J\u0013\u0010\u0082\u0001\u001a\u00020\u000f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0019\u0010\u0085\u0001\u001a\u00020\u000f2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0000¢\u0006\u0003\b\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020\u000fH\u0002J$\u0010\u008a\u0001\u001a\u00020\u000f2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\b\u008c\u0001J\t\u0010\u008d\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008e\u0001\u001a\u00020\u000fH\u0002J\n\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0002J\t\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J4\u0010\u0093\u0001\u001a\u0003H\u0094\u0001\"\u0005\b\u0000\u0010\u0094\u00012\u001a\u0010{\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a\u0012\u0005\u0012\u0003H\u0094\u00010\u0095\u0001H\u0082\b¢\u0006\u0003\u0010\u0096\u0001J\u0014\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u0098\u0001\u001a\u00020 H\u0002J\t\u0010\u0099\u0001\u001a\u00020\u0013H\u0002J\u000f\u0010\u009a\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u009b\u0001J\t\u0010\u009c\u0001\u001a\u00020\u000fH\u0002J\u000f\u0010\u009d\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u009e\u0001J\u000f\u0010\u009f\u0001\u001a\u00020\u000fH\u0001¢\u0006\u0003\b \u0001J\t\u0010©\u0001\u001a\u00020\u000fH\u0002J\u0010\u0010ª\u0001\u001a\u00020\u000f2\u0007\u0010\u0098\u0001\u001a\u00020 J/\u0010«\u0001\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u00172\b\b\u0002\u0010;\u001a\u00020\u001a2\t\b\u0002\u0010¬\u0001\u001a\u00020\u001c¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J#\u0010¯\u0001\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u00172\b\b\u0002\u0010;\u001a\u00020\u001a¢\u0006\u0005\b°\u0001\u0010yJ\u0011\u0010¸\u0001\u001a\u00030¹\u0001H\u0086@¢\u0006\u0003\u0010º\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R$\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00105\u001a\u0002042\u0006\u0010+\u001a\u000204@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b6\u00107\"\u0004\b8\u00109R&\u0010;\u001a\u00020:2\u0006\u0010+\u001a\u00020:@BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b<\u00107\"\u0004\b=\u00109R$\u0010>\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u00020C2\u0006\u0010+\u001a\u00020C8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u00101\"\u0004\bF\u00103R(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010+\u001a\u0004\u0018\u00010G8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR&\u0010M\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bN\u00107\"\u0004\bO\u00109R$\u0010P\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010@\"\u0004\bR\u0010BR$\u0010S\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010@\"\u0004\bU\u0010BR$\u0010V\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010@\"\u0004\bX\u0010BR$\u0010Y\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010@\"\u0004\b[\u0010BR$\u0010\\\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010@\"\u0004\b^\u0010BR$\u0010_\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010@\"\u0004\ba\u0010BR$\u0010b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010@\"\u0004\bd\u0010BR$\u0010e\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010@\"\u0004\bg\u0010BR$\u0010h\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010@\"\u0004\bj\u0010BR*\u0010k\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bl\u0010m\u001a\u0004\bn\u0010-\"\u0004\bo\u0010pR(\u0010r\u001a\u0004\u0018\u00010q2\b\u0010+\u001a\u0004\u0018\u00010q8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0012\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010¡\u0001\u001a\u00030¢\u00018F¢\u0006\u0007\u001a\u0005\b£\u0001\u00107R\u0014\u0010¤\u0001\u001a\u00030¢\u00018F¢\u0006\u0007\u001a\u0005\b¥\u0001\u00107R\u0014\u0010¦\u0001\u001a\u00020\u001e8F¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R)\u0010²\u0001\u001a\u00030±\u00012\u0007\u0010+\u001a\u00030±\u00018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b³\u0001\u00107\"\u0005\b´\u0001\u00109R)\u0010µ\u0001\u001a\u00030±\u00012\u0007\u0010+\u001a\u00030±\u00018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¶\u0001\u00107\"\u0005\b·\u0001\u00109¨\u0006¼\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;)V", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "clipDrawBlock", "androidOutline", "Landroid/graphics/Outline;", "outlineDirty", "", "roundRectOutlineTopLeft", "Landroidx/compose/ui/geometry/Offset;", "J", "roundRectOutlineSize", "Landroidx/compose/ui/geometry/Size;", "roundRectCornerRadius", "", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "roundRectClipPath", "usePathForClip", "softwareDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "parentLayerUsages", "", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "value", "isReleased", "()Z", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "getTopLeft-nOcc-ac", "()J", "setTopLeft--gyyYBs", "(J)V", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "setSize-ozmzZPI", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", LiveDegradeFpsAnimator.SCALE_X, "getScaleX", "setScaleX", LiveDegradeFpsAnimator.SCALE_Y, "getScaleY", "setScaleY", LiveDegradeFpsAnimator.TRANSLATION_X, "getTranslationX", "setTranslationX", LiveDegradeFpsAnimator.TRANSLATION_Y, "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip$annotations", "()V", "getClip", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "record", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "recordInternal", "drawWithChildTracking", "addSubLayer", "graphicsLayer", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "drawForPersistence", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "drawForPersistence$ui_graphics_release", "recreateDisplayListIfNeeded", "draw", "parentLayer", "draw$ui_graphics_release", "onAddedToParentLayer", "onRemovedFromParentLayer", "pathBounds", "Landroid/graphics/RectF;", "obtainPathBounds", "configureOutlineAndClip", "resolveOutlinePosition", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "updatePathOutline", "path", "obtainAndroidOutline", "release", "release$ui_graphics_release", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics_release", "emulateTrimMemory", "emulateTrimMemory$ui_graphics_release", "layerId", "", "getLayerId", "ownerViewId", "getOwnerViewId", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "resetOutlineParams", "setPathOutline", "setRoundRectOutline", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "setRectOutline", "setRectOutline-tz77jQw", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GraphicsLayer {
    public static final Companion Companion = null;
    private static final LayerSnapshotImpl SnapshotImpl = null;
    private static final boolean isRobolectric = false;
    private Outline androidOutline;
    private final ChildLayerDependenciesTracker childDependenciesTracker;
    private boolean clip;
    private final Function1<DrawScope, Unit> clipDrawBlock;
    private Density density;
    private Function1<? super DrawScope, Unit> drawBlock;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private LayoutDirection layoutDirection;
    private boolean outlineDirty;
    private Path outlinePath;
    private int parentLayerUsages;
    private RectF pathBounds;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long roundRectOutlineSize;
    private long roundRectOutlineTopLeft;
    private long size;
    private CanvasDrawScope softwareDrawScope;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer$Companion;", "", "<init>", "()V", "isRobolectric", "", "SnapshotImpl", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.graphics.layer.GraphicsLayer", f = "AndroidGraphicsLayer.android.kt", i = {}, l = {869}, m = "toImageBitmap", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GraphicsLayer this$0;

        public AnonymousClass1(GraphicsLayer r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.toImageBitmap(this);
        }
    }

    public static /* synthetic */ void getClip$annotations() {
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.Companion.m4659getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.Companion.m4598getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    static {
        Companion = new Companion(null);
        boolean r100 = Intrinsics.areEqual(Build.FINGERPRINT.toLowerCase(Locale.ROOT), "robolectric");
        isRobolectric = r100;
        if (r100 == false) goto L5;
        LayerSnapshotImpl r101 = LayerSnapshotV21.INSTANCE;
    L14:
        SnapshotImpl = r101;
        return;
    L5:
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 28) goto L9;
        r101 = LayerSnapshotV28.INSTANCE;
        goto L14
    L9:
        if (r102 >= 22) goto L11;
    L13:
        r101 = LayerSnapshotV21.INSTANCE;
        goto L14
    L11:
        if (SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable() == false) goto L13;
        r101 = LayerSnapshotV22.INSTANCE;
        goto L14
    }

    private final void configureOutlineAndClip() {
        if (this.outlineDirty == false) goto L37;
        boolean r100 = true;
        if (this.clip == false) goto L7;
    L10:
        boolean r101 = true;
    L11:
        Outline r102 = null;
        if (r101 == true) goto L14;
        this.impl.setClip(false);
        this.impl.mo5521setOutlineO0kMr_c(null, IntSize.Companion.m7724getZeroYbymL2g());
        goto L37
    L14:
        Path r103 = this.outlinePath;
        if (r103 == null) goto L29;
        RectF r104 = obtainPathBounds();
        if ((r103 instanceof AndroidPath) == false) goto L28;
        ((AndroidPath) r103).getInternalPath().computeBounds(r104, false);
        Outline r105 = updatePathOutline(r103);
        if (r105 == null) goto L21;
        r105.setAlpha(getAlpha());
        r102 = r105;
    L21:
        GraphicsLayerImpl r106 = this.impl;
        int r107 = Math.round(r104.width());
        long r108 = BodyPartID.bodyIdMax & ((long) Math.round(r104.height()));
        r106.mo5521setOutlineO0kMr_c(r102, IntSize.m7714constructorimpl(r108 | (((long) r107) << 32)));
        if (this.usePathForClip == true) goto L24;
    L26:
        this.impl.setClip(this.clip);
        goto L37
    L24:
        if (this.clip == false) goto L26;
        this.impl.setClip(false);
        this.impl.discardDisplayList();
        goto L37
    L28:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    L29:
        this.impl.setClip(this.clip);
        Size.Companion.m4660getZeroNHjbRc();
        Outline r109 = obtainAndroidOutline();
        long r110 = IntSizeKt.m7731toSizeozmzZPI(this.size);
        long r111 = this.roundRectOutlineTopLeft;
        long r112 = this.roundRectOutlineSize;
        if (r112 == InlineClassHelperKt.UnspecifiedPackedFloats) goto L33;
        r100 = false;
    L33:
        if (r100 == false) goto L35;
        long r113 = r110;
    L36:
        int r114 = (int) (r111 >> 32);
        int r115 = Math.round(Float.intBitsToFloat(r114));
        int r116 = (int) (r111 & BodyPartID.bodyIdMax);
        r109.setRoundRect(r115, Math.round(Float.intBitsToFloat(r116)), Math.round(Float.intBitsToFloat(r114) + Float.intBitsToFloat((int) (r113 >> 32))), Math.round(Float.intBitsToFloat(r116) + Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r113))), this.roundRectCornerRadius);
        r109.setAlpha(getAlpha());
        this.impl.mo5521setOutlineO0kMr_c(r109, IntSizeKt.m7727roundToIntSizeuvyYCjk(r113));
        goto L37
    L35:
        r113 = r112;
        goto L36
    L7:
        if (getShadowElevation() > 0.0f) goto L10;
        r101 = false;
    L37:
        this.outlineDirty = false;
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased == true) goto L5;
        return;
    L5:
        if (this.parentLayerUsages != 0) goto L9;
        discardDisplayList$ui_graphics_release();
        return;
    }

    private final Outline obtainAndroidOutline() {
        Outline r100 = this.androidOutline;
        if (r100 != null) goto L6;
        Outline r101 = new Outline();
        this.androidOutline = r101;
        return r101;
    L6:
        return r100;
    }

    private final RectF obtainPathBounds() {
        RectF r100 = this.pathBounds;
        if (r100 != null) goto L6;
        RectF r101 = new RectF();
        this.pathBounds = r101;
        return r101;
    L6:
        return r100;
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void recordInternal() {
        this.impl.record(this.density, this.layoutDirection, this, this.clipDrawBlock);
    }

    private final void recreateDisplayListIfNeeded() {
        if (this.impl.getHasDisplayList() == true) goto L9;
        recordInternal();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public final void discardDisplayList$ui_graphics_release() {
        ChildLayerDependenciesTracker r100 = this.childDependenciesTracker;
        GraphicsLayer r101 = ChildLayerDependenciesTracker.access$getDependency$p(r100);
        if (r101 == null) goto L5;
        r101.onRemovedFromParentLayer();
        ChildLayerDependenciesTracker.access$setDependency$p(r100, null);
    L5:
        MutableScatterSet r102 = ChildLayerDependenciesTracker.access$getDependenciesSet$p(r100);
        if (r102 == null) goto L25;
        Object[] r103 = r102.elements;
        long[] r104 = r102.metadata;
        int r105 = r104.length - 2;
        if (r105 < 0) goto L24;
        int r106 = 0;
    L10:
        long r107 = r104[r106];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r108 = 8 - ((~(r106 - r105)) >>> 31);
        int r110 = 0;
    L13:
        if (r110 >= r108) goto L21;
        if ((255 & r107) >= 128) goto L17;
        boolean r111 = true;
    L18:
        if (r111 == false) goto L20;
        ((GraphicsLayer) r103[(r106 << 3) + r110]).onRemovedFromParentLayer();
    L20:
        r107 = r107 >> 8;
        r110 = r110 + 1;
        goto L13
    L17:
        r111 = false;
        goto L18
    L21:
        if (r108 != 8) goto L24;
    L22:
        if (r106 == r105) goto L24;
        r106 = r106 + 1;
    L24:
        r102.clear();
    L25:
        this.impl.discardDisplayList();
    }

    public final void emulateTrimMemory$ui_graphics_release() {
        this.impl.discardDisplayList();
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public final long m5497getAmbientShadowColor0d7_KjU() {
        return this.impl.mo5513getAmbientShadowColor0d7_KjU();
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m5498getBlendMode0nO6VwU() {
        return this.impl.mo5514getBlendMode0nO6VwU();
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m5499getCompositingStrategyke2Ky5w() {
        return this.impl.mo5515getCompositingStrategyke2Ky5w();
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline r100 = this.internalOutline;
        Path r101 = this.outlinePath;
        if (r100 != null) goto L21;
        if (r101 == null) goto L7;
        androidx.compose.ui.graphics.Outline.Generic r102 = new androidx.compose.ui.graphics.Outline.Generic(r101);
        this.internalOutline = r102;
        return r102;
    L7:
        long r103 = IntSizeKt.m7731toSizeozmzZPI(this.size);
        long r104 = this.roundRectOutlineTopLeft;
        long r105 = this.roundRectOutlineSize;
        if (r105 != InlineClassHelperKt.UnspecifiedPackedFloats) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == true) goto L14;
        r103 = r105;
    L14:
        float r107 = Float.intBitsToFloat((int) (r104 >> 32));
        float r108 = Float.intBitsToFloat((int) (r104 & BodyPartID.bodyIdMax));
        float r109 = r107 + Float.intBitsToFloat((int) (r103 >> 32));
        float r110 = r108 + Float.intBitsToFloat((int) (r103 & BodyPartID.bodyIdMax));
        float r111 = this.roundRectCornerRadius;
        if (r111 <= 0.0f) goto L17;
        androidx.compose.ui.graphics.Outline r112 = new androidx.compose.ui.graphics.Outline.Rounded(RoundRectKt.m4636RoundRectgG7oq9Y(r107, r108, r109, r110, CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r111) << 32) | (((long) Float.floatToRawIntBits(r111)) & BodyPartID.bodyIdMax))));
    L18:
        this.internalOutline = r112;
        return r112;
    L17:
        r112 = new androidx.compose.ui.graphics.Outline.Rectangle(new Rect(r107, r108, r109, r110));
        goto L18
    L10:
        r106 = false;
        goto L11
    L21:
        return r100;
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public final long m5502getSpotShadowColor0d7_KjU() {
        return this.impl.mo5517getSpotShadowColor0d7_KjU();
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void release$ui_graphics_release() {
        if (this.isReleased == true) goto L6;
        this.isReleased = true;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
        return;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final GraphicsLayerImpl getImpl$ui_graphics_release() {
        return this.impl;
    }

    /* JADX INFO: renamed from: getPivotOffset-F1C5BW0, reason: not valid java name */
    public final long m5500getPivotOffsetF1C5BW0() {
        return this.pivotOffset;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m5501getSizeYbymL2g() {
        return this.size;
    }

    /* JADX INFO: renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m5503getTopLeftnOccac() {
        return this.topLeft;
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    public GraphicsLayer(GraphicsLayerImpl r100) {
        this.impl = r100;
        this.density = DrawContextKt.getDefaultDensity();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayer$drawBlock$1.INSTANCE;
        this.clipDrawBlock = new GraphicsLayer$clipDrawBlock$1(this);
        this.outlineDirty = true;
        Offset.Companion r101 = Offset.Companion;
        this.roundRectOutlineTopLeft = r101.m4598getZeroF1C5BW0();
        this.roundRectOutlineSize = Size.Companion.m4659getUnspecifiedNHjbRc();
        this.childDependenciesTracker = new ChildLayerDependenciesTracker();
        r100.setClip(false);
        this.topLeft = IntOffset.Companion.m7687getZeronOccac();
        this.size = IntSize.Companion.m7724getZeroYbymL2g();
        this.pivotOffset = r101.m4597getUnspecifiedF1C5BW0();
    }

    public static final /* synthetic */ Path access$getOutlinePath$p(GraphicsLayer r100) {
        return r100.outlinePath;
    }

    public static final /* synthetic */ boolean access$getUsePathForClip$p(GraphicsLayer r100) {
        return r100.usePathForClip;
    }

    private final void addSubLayer(GraphicsLayer r100) {
        if (this.childDependenciesTracker.onDependencyAdded(r100) == false) goto L6;
        r100.onAddedToParentLayer();
        return;
    }

    private final void drawWithChildTracking(DrawScope r110) {
        ChildLayerDependenciesTracker r100 = this.childDependenciesTracker;
        ChildLayerDependenciesTracker.access$setOldDependency$p(r100, ChildLayerDependenciesTracker.access$getDependency$p(r100));
        MutableScatterSet r101 = ChildLayerDependenciesTracker.access$getDependenciesSet$p(r100);
        if (r101 != null) goto L5;
    L10:
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r100, true);
        this.drawBlock.invoke(r110);
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r100, false);
        GraphicsLayer r102 = ChildLayerDependenciesTracker.access$getOldDependency$p(r100);
        if (r102 == null) goto L13;
        r102.onRemovedFromParentLayer();
    L13:
        MutableScatterSet r103 = ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r100);
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.isNotEmpty() == false) goto L42;
        Object[] r104 = r103.elements;
        long[] r105 = r103.metadata;
        int r106 = r105.length - 2;
        if (r106 < 0) goto L34;
        int r107 = 0;
    L20:
        long r108 = r105[r107];
        if (((((~r108) << 7) & r108) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L32;
        int r111 = 8 - ((~(r107 - r106)) >>> 31);
        int r112 = 0;
    L23:
        if (r112 >= r111) goto L31;
        if ((255 & r108) >= 128) goto L27;
        boolean r113 = true;
    L28:
        if (r113 == false) goto L30;
        ((GraphicsLayer) r104[(r107 << 3) + r112]).onRemovedFromParentLayer();
    L30:
        r108 = r108 >> 8;
        r112 = r112 + 1;
        goto L23
    L27:
        r113 = false;
        goto L28
    L31:
        if (r111 != 8) goto L34;
    L32:
        if (r107 == r106) goto L34;
        r107 = r107 + 1;
    L34:
        r103.clear();
        return;
    L42:
        return;
    L5:
        if (r101.isNotEmpty() == false) goto L10;
        MutableScatterSet r109 = ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r100);
        if (r109 != null) goto L9;
        r109 = ScatterSetKt.mutableScatterSetOf();
        ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(r100, r109);
    L9:
        r109.addAll(r101);
        r101.clear();
        goto L10
    }

    private final <T> T resolveOutlinePosition(Function2<? super Offset, ? super Size, ? extends T> r110) {
        long r100 = IntSizeKt.m7731toSizeozmzZPI(this.size);
        long r101 = this.roundRectOutlineTopLeft;
        long r102 = this.roundRectOutlineSize;
        if (r102 != InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L10;
        r100 = r102;
    L10:
        return r110.invoke(Offset.m4571boximpl(r101), Size.m4639boximpl(r100));
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m5496setSizeozmzZPI(long r100) {
        if (IntSize.m7717equalsimpl0(this.size, r100) == true) goto L11;
        this.size = r100;
        m5493setPositionVbeCjmY(this.topLeft, r100);
        if (this.roundRectOutlineSize != InlineClassHelperKt.UnspecifiedPackedFloats) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        this.outlineDirty = true;
        configureOutlineAndClip();
        return;
    L12:
        return;
    L7:
        r101 = false;
        goto L8
    }

    private final void transformCanvas(Canvas r110) {
        float r100 = IntOffset.m7676getXimpl(this.topLeft);
        float r101 = IntOffset.m7677getYimpl(this.topLeft);
        float r102 = IntOffset.m7676getXimpl(this.topLeft) + ((int) (this.size >> 32));
        float r103 = IntOffset.m7677getYimpl(this.topLeft) + ((int) (this.size & BodyPartID.bodyIdMax));
        float r104 = getAlpha();
        ColorFilter r105 = getColorFilter();
        int r106 = m5498getBlendMode0nO6VwU();
        if (r104 >= 1.0f) goto L5;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L17;
        Paint r108 = this.softwareLayerPaint;
        if (r108 != null) goto L16;
        r108 = AndroidPaint_androidKt.Paint();
        this.softwareLayerPaint = r108;
    L16:
        r108.setAlpha(r104);
        r108.mo4703setBlendModes9anfk8(r106);
        r108.setColorFilter(r105);
        r110.saveLayer(r100, r101, r102, r103, r108.asFrameworkPaint());
    L18:
        r110.translate(r100, r101);
        r110.concat(this.impl.calculateMatrix());
        return;
    L17:
        r110.save();
        goto L18
    L5:
        if (BlendMode.m4737equalsimpl0(r106, BlendMode.Companion.m4768getSrcOver0nO6VwU()) == false) goto L11;
        if (r105 != null) goto L11;
        if (CompositingStrategy.m5486equalsimpl0(m5499getCompositingStrategyke2Ky5w(), CompositingStrategy.Companion.m5492getOffscreenke2Ky5w()) == true) goto L11;
        r107 = false;
        goto L12
    }

    private final Outline updatePathOutline(Path r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 <= 28) goto L5;
    L11:
        Outline r102 = obtainAndroidOutline();
        if (r101 < 30) goto L15;
        OutlineVerificationHelper.INSTANCE.setPath(r102, r100);
    L17:
        this.usePathForClip = !r102.canClip();
        Outline r103 = r102;
    L18:
        this.outlinePath = r100;
        return r103;
    L15:
        if ((r100 instanceof AndroidPath) == false) goto L21;
        r102.setConvexPath(((AndroidPath) r100).getInternalPath());
        goto L17
    L21:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    L5:
        if (r100.isConvex() == true) goto L11;
        Outline r104 = this.androidOutline;
        if (r104 == null) goto L10;
        r104.setEmpty();
    L10:
        this.usePathForClip = true;
        this.impl.setInvalidated(true);
        r103 = null;
        goto L18
    }

    public final void drawForPersistence$ui_graphics_release(androidx.compose.ui.graphics.Canvas r100) {
        if (AndroidCanvas_androidKt.getNativeCanvas(r100).isHardwareAccelerated() == false) goto L5;
    L6:
        recreateDisplayListIfNeeded();
        this.impl.draw(r100);
        return;
    L5:
        if (this.impl.getSupportsSoftwareRendering() == true) goto L6;
    }

    public final void setAlpha(float r100) {
        if (this.impl.getAlpha() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setAlpha(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m5505setAmbientShadowColor8_81llA(long r100) {
        if (Color.m4828equalsimpl0(r100, this.impl.mo5513getAmbientShadowColor0d7_KjU()) == true) goto L6;
        this.impl.mo5518setAmbientShadowColor8_81llA(r100);
        return;
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m5506setBlendModes9anfk8(int r100) {
        if (BlendMode.m4737equalsimpl0(this.impl.mo5514getBlendMode0nO6VwU(), r100) == true) goto L6;
        this.impl.mo5519setBlendModes9anfk8(r100);
        return;
    }

    public final void setCameraDistance(float r100) {
        if (this.impl.getCameraDistance() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setCameraDistance(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setClip(boolean r100) {
        if (this.clip == r100) goto L6;
        this.clip = r100;
        this.outlineDirty = true;
        configureOutlineAndClip();
        return;
    }

    public final void setColorFilter(ColorFilter r100) {
        if (Intrinsics.areEqual(this.impl.getColorFilter(), r100) == true) goto L6;
        this.impl.setColorFilter(r100);
        return;
    }

    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m5507setCompositingStrategyWpw9cng(int r100) {
        if (CompositingStrategy.m5486equalsimpl0(this.impl.mo5515getCompositingStrategyke2Ky5w(), r100) == true) goto L6;
        this.impl.mo5520setCompositingStrategyWpw9cng(r100);
        return;
    }

    public final void setPathOutline(Path r100) {
        resetOutlineParams();
        this.outlinePath = r100;
        configureOutlineAndClip();
    }

    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m5508setPivotOffsetk4lQ0M(long r100) {
        if (Offset.m4579equalsimpl0(this.pivotOffset, r100) == true) goto L6;
        this.pivotOffset = r100;
        this.impl.mo5522setPivotOffsetk4lQ0M(r100);
        return;
    }

    public final void setRenderEffect(RenderEffect r100) {
        if (Intrinsics.areEqual(this.impl.getRenderEffect(), r100) == true) goto L6;
        this.impl.setRenderEffect(r100);
        return;
    }

    public final void setRotationX(float r100) {
        if (this.impl.getRotationX() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setRotationX(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setRotationY(float r100) {
        if (this.impl.getRotationY() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setRotationY(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setRotationZ(float r100) {
        if (this.impl.getRotationZ() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setRotationZ(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setScaleX(float r100) {
        if (this.impl.getScaleX() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setScaleX(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setScaleY(float r100) {
        if (this.impl.getScaleY() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setScaleY(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setShadowElevation(float r100) {
        if (this.impl.getShadowElevation() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setShadowElevation(r100);
        this.outlineDirty = true;
        configureOutlineAndClip();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m5511setSpotShadowColor8_81llA(long r100) {
        if (Color.m4828equalsimpl0(r100, this.impl.mo5517getSpotShadowColor0d7_KjU()) == true) goto L6;
        this.impl.mo5524setSpotShadowColor8_81llA(r100);
        return;
    }

    /* JADX INFO: renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m5512setTopLeftgyyYBs(long r100) {
        if (IntOffset.m7675equalsimpl0(this.topLeft, r100) == true) goto L6;
        this.topLeft = r100;
        m5493setPositionVbeCjmY(r100, this.size);
        return;
    }

    public final void setTranslationX(float r100) {
        if (this.impl.getTranslationX() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setTranslationX(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setTranslationY(float r100) {
        if (this.impl.getTranslationY() != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.impl.setTranslationY(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final Object toImageBitmap(Continuation<? super ImageBitmap> r100) {
        if ((r100 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L18:
        return AndroidImageBitmap_androidKt.asImageBitmap((Bitmap) r103);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        LayerSnapshotImpl r106 = SnapshotImpl;
        r101.label = 1;
        r103 = r106.toBitmap(this, r101);
        if (r103 != r104) goto L18;
        return r104;
    L7:
        r101 = new AnonymousClass1(this, r100);
        goto L8
    }

    public static final /* synthetic */ void access$drawWithChildTracking(GraphicsLayer r100, DrawScope r101) {
        r100.drawWithChildTracking(r101);
    }

    /* JADX INFO: renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m5493setPositionVbeCjmY(long r100, long r101) {
        this.impl.mo5523setPositionH0pRuoY(IntOffset.m7676getXimpl(r100), IntOffset.m7677getYimpl(r100), r101);
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas r110, GraphicsLayer r210) {
        if (this.isReleased == false) goto L5;
        return;
    L5:
        configureOutlineAndClip();
        recreateDisplayListIfNeeded();
        boolean r100 = true;
        if (getShadowElevation() <= 0.0f) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        r110.enableZ();
    L11:
        Canvas r102 = AndroidCanvas_androidKt.getNativeCanvas(r110);
        boolean r103 = !r102.isHardwareAccelerated();
        if (r103 == false) goto L14;
        transformCanvas(r102);
    L14:
        if (r103 == true) goto L16;
    L18:
        r100 = false;
    L19:
        if (r100 == false) goto L35;
        r110.save();
        androidx.compose.ui.graphics.Outline r104 = getOutline();
        if ((r104 instanceof androidx.compose.ui.graphics.Outline.Rectangle) == false) goto L24;
        androidx.compose.ui.graphics.Canvas.CC.m4801clipRectmtrdDE$default(r110, ((androidx.compose.ui.graphics.Outline.Rectangle) r104).getBounds(), 0, 2, null);
        goto L35
    L24:
        if ((r104 instanceof androidx.compose.ui.graphics.Outline.Rounded) == false) goto L31;
        Path r105 = this.roundRectClipPath;
        if (r105 == null) goto L28;
        r105.rewind();
    L29:
        Path.CC.addRoundRect$default(r105, ((androidx.compose.ui.graphics.Outline.Rounded) r104).getRoundRect(), null, 2, null);
        androidx.compose.ui.graphics.Canvas.CC.m4799clipPathmtrdDE$default(r110, r105, 0, 2, null);
        goto L35
    L28:
        r105 = AndroidPath_androidKt.Path();
        this.roundRectClipPath = r105;
        goto L29
    L31:
        if ((r104 instanceof androidx.compose.ui.graphics.Outline.Generic) == false) goto L34;
        androidx.compose.ui.graphics.Canvas.CC.m4799clipPathmtrdDE$default(r110, ((androidx.compose.ui.graphics.Outline.Generic) r104).getPath(), 0, 2, null);
        goto L35
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        if (r210 == null) goto L38;
        r210.addSubLayer(this);
    L38:
        if (AndroidCanvas_androidKt.getNativeCanvas(r110).isHardwareAccelerated() == false) goto L40;
    L51:
        this.impl.draw(r110);
    L52:
        if (r100 == false) goto L54;
        r110.restore();
    L54:
        if (r101 == false) goto L56;
        r110.disableZ();
    L56:
        if (r103 == false) goto L61;
        r102.restore();
        return;
    L61:
        return;
    L40:
        if (this.impl.getSupportsSoftwareRendering() == true) goto L51;
        CanvasDrawScope r106 = this.softwareDrawScope;
        if (r106 != null) goto L45;
        r106 = new CanvasDrawScope();
        this.softwareDrawScope = r106;
    L45:
        DrawScope r107 = r106;
        Density r108 = this.density;
        LayoutDirection r109 = this.layoutDirection;
        long r111 = IntSizeKt.m7731toSizeozmzZPI(this.size);
        Density r112 = r107.getDrawContext().getDensity();
        LayoutDirection r113 = r107.getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas r114 = r107.getDrawContext().getCanvas();
        long r115 = r107.getDrawContext().mo5329getSizeNHjbRc();
        GraphicsLayer r116 = r107.getDrawContext().getGraphicsLayer();
        DrawContext r117 = r107.getDrawContext();
        r117.setDensity(r108);
        r117.setLayoutDirection(r109);
        r117.setCanvas(r110);
        r117.mo5330setSizeuvyYCjk(r111);
        r117.setGraphicsLayer(this);
        r110.save();
        drawWithChildTracking(r107);     // Catch: Throwable -> L48
        r110.restore();
        DrawContext r118 = r107.getDrawContext();
        r118.setDensity(r112);
        r118.setLayoutDirection(r113);
        r118.setCanvas(r114);
        r118.mo5330setSizeuvyYCjk(r115);
        r118.setGraphicsLayer(r116);
    L48:
        th = move-exception;
        r110.restore();
        DrawContext r119 = r107.getDrawContext();
        r119.setDensity(r112);
        r119.setLayoutDirection(r113);
        r119.setCanvas(r114);
        r119.mo5330setSizeuvyYCjk(r115);
        r119.setGraphicsLayer(r116);
        throw th;
    L16:
        if (this.clip == false) goto L18;
    L8:
        r101 = false;
        goto L9
    }

    /* JADX INFO: renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m5509setRectOutlinetz77jQw(long r100, long r101) {
        m5510setRoundRectOutlineTNW_H78(r100, r101, 0.0f);
    }

    /* JADX INFO: renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m5510setRoundRectOutlineTNW_H78(long r100, long r101, float r102) {
        if (Offset.m4579equalsimpl0(this.roundRectOutlineTopLeft, r100) == true) goto L5;
    L13:
        resetOutlineParams();
        this.roundRectOutlineTopLeft = r100;
        this.roundRectOutlineSize = r101;
        this.roundRectCornerRadius = r102;
        configureOutlineAndClip();
        return;
    L5:
        if (Size.m4647equalsimpl0(this.roundRectOutlineSize, r101) == false) goto L13;
        if (this.roundRectCornerRadius != r102) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        if (this.outlinePath != null) goto L13;
        return;
    L9:
        r103 = false;
        goto L10
    }

    /* JADX INFO: renamed from: record-mL-hObY, reason: not valid java name */
    public final void m5504recordmLhObY(Density r100, LayoutDirection r101, long r102, Function1<? super DrawScope, Unit> r103) {
        m5496setSizeozmzZPI(r102);
        this.density = r100;
        this.layoutDirection = r101;
        this.drawBlock = r103;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    /* JADX INFO: renamed from: setRectOutline-tz77jQw$default, reason: not valid java name */
    public static /* synthetic */ void m5494setRectOutlinetz77jQw$default(GraphicsLayer r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Offset.Companion.m4598getZeroF1C5BW0();
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = Size.Companion.m4659getUnspecifiedNHjbRc();
    L8:
        r100.m5509setRectOutlinetz77jQw(r101, r102);
    }

    /* JADX INFO: renamed from: setRoundRectOutline-TNW_H78$default, reason: not valid java name */
    public static /* synthetic */ void m5495setRoundRectOutlineTNW_H78$default(GraphicsLayer r100, long r101, long r102, float r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = Offset.Companion.m4598getZeroF1C5BW0();
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = Size.Companion.m4659getUnspecifiedNHjbRc();
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L11;
        float r105 = 0.0f;
    L12:
        r100.m5510setRoundRectOutlineTNW_H78(r103, r104, r105);
        return;
    L11:
        r105 = r110;
        goto L12
    }
}
