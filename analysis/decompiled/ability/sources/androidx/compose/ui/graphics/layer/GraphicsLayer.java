package androidx.compose.ui.graphics.layer;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.appfunctions.metadata.a;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
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
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Ñ\u00012\u00020\u0001:\u0002Ñ\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010 \u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010\"\u001a\u00020\u000eH\u0001¢\u0006\u0004\b!\u0010\u001dJ\u0015\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J+\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010\u000b\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J!\u00101\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010\u000b\u001a\u00020)¢\u0006\u0004\b/\u00100J\u0010\u00103\u001a\u000202H\u0086@¢\u0006\u0004\b3\u00104J\u001f\u00107\u001a\u00020\u000e2\u0006\u0010(\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b6\u00100J\u000f\u00108\u001a\u00020\u000eH\u0002¢\u0006\u0004\b8\u0010\u001dJ\u0013\u00109\u001a\u00020\u000e*\u00020\rH\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u0000H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u000eH\u0002¢\u0006\u0004\bB\u0010\u001dJ\u000f\u0010C\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010\u001dJ\u000f\u0010D\u001a\u00020\u000eH\u0002¢\u0006\u0004\bD\u0010\u001dJ\u000f\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u000eH\u0002¢\u0006\u0004\bH\u0010\u001dJ0\u0010K\u001a\u00028\u0000\"\u0004\b\u0000\u0010I2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00028\u00000JH\u0082\b¢\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020MH\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u000eH\u0002¢\u0006\u0004\bR\u0010\u001dJ\u000f\u0010S\u001a\u00020\u000eH\u0002¢\u0006\u0004\bS\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010WR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010XR\"\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR \u0010[\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010bR\u0016\u0010d\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010jR\u0016\u0010l\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010`R\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010w\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR$\u0010z\u001a\u00020^2\u0006\u0010y\u001a\u00020^8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bz\u0010`\u001a\u0004\bz\u0010{R*\u0010(\u001a\u0002052\u0006\u0010y\u001a\u0002058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010b\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR,\u0010\u000b\u001a\u00020\n2\u0006\u0010y\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\u0014\n\u0004\b\u000b\u0010b\u001a\u0005\b\u0080\u0001\u0010}\"\u0005\b\u0081\u0001\u0010\u007fR.\u0010\u0082\u0001\u001a\u00020'2\u0006\u0010y\u001a\u00020'8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010b\u001a\u0005\b\u0083\u0001\u0010}\"\u0005\b\u0084\u0001\u0010\u007fR6\u0010\u0085\u0001\u001a\u00020^2\u0006\u0010y\u001a\u00020^8\u0006@FX\u0086\u000e¢\u0006\u001d\n\u0005\b\u0085\u0001\u0010`\u0012\u0005\b\u0089\u0001\u0010\u001d\u001a\u0005\b\u0086\u0001\u0010{\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u0091\u0001\u001a\u00030\u008c\u00012\u0007\u0010y\u001a\u00030\u008c\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R)\u0010\u0096\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R+\u0010\u009a\u0001\u001a\u00030\u0097\u00012\u0007\u0010y\u001a\u00030\u0097\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0098\u0001\u0010\u008e\u0001\"\u0006\b\u0099\u0001\u0010\u0090\u0001R/\u0010 \u0001\u001a\u0005\u0018\u00010\u009b\u00012\t\u0010y\u001a\u0005\u0018\u00010\u009b\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R)\u0010£\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¡\u0001\u0010\u0093\u0001\"\u0006\b¢\u0001\u0010\u0095\u0001R)\u0010¦\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¤\u0001\u0010\u0093\u0001\"\u0006\b¥\u0001\u0010\u0095\u0001R)\u0010©\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b§\u0001\u0010\u0093\u0001\"\u0006\b¨\u0001\u0010\u0095\u0001R)\u0010¬\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bª\u0001\u0010\u0093\u0001\"\u0006\b«\u0001\u0010\u0095\u0001R)\u0010¯\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010\u0093\u0001\"\u0006\b®\u0001\u0010\u0095\u0001R)\u0010²\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b°\u0001\u0010\u0093\u0001\"\u0006\b±\u0001\u0010\u0095\u0001R)\u0010µ\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b³\u0001\u0010\u0093\u0001\"\u0006\b´\u0001\u0010\u0095\u0001R)\u0010¸\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¶\u0001\u0010\u0093\u0001\"\u0006\b·\u0001\u0010\u0095\u0001R)\u0010»\u0001\u001a\u00020*2\u0006\u0010y\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010\u0093\u0001\"\u0006\bº\u0001\u0010\u0095\u0001R/\u0010Á\u0001\u001a\u0005\u0018\u00010¼\u00012\t\u0010y\u001a\u0005\u0018\u00010¼\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R\u0014\u0010Ä\u0001\u001a\u00030Â\u00018F¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010}R\u0014\u0010Æ\u0001\u001a\u00030Â\u00018F¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010}R\u0014\u0010É\u0001\u001a\u00020f8F¢\u0006\b\u001a\u0006\bÇ\u0001\u0010È\u0001R)\u0010Í\u0001\u001a\u00030Ê\u00012\u0007\u0010y\u001a\u00030Ê\u00018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bË\u0001\u0010}\"\u0005\bÌ\u0001\u0010\u007fR)\u0010Ð\u0001\u001a\u00030Ê\u00012\u0007\u0010y\u001a\u00030Ê\u00018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÎ\u0001\u0010}\"\u0005\bÏ\u0001\u0010\u007f¨\u0006Ò\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "impl", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/IntSize;", "size", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "LC7/r;", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLS7/k;)V", "record", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "drawForPersistence$ui_graphics_release", "(Landroidx/compose/ui/graphics/Canvas;)V", "drawForPersistence", "parentLayer", "draw$ui_graphics_release", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "draw", "release$ui_graphics_release", "()V", "release", "discardDisplayList$ui_graphics_release", "discardDisplayList", "emulateTrimMemory$ui_graphics_release", "emulateTrimMemory", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "setPathOutline", "(Landroidx/compose/ui/graphics/Path;)V", "Landroidx/compose/ui/geometry/Offset;", "topLeft", "Landroidx/compose/ui/geometry/Size;", "", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "setRoundRectOutline", "setRectOutline-tz77jQw", "(JJ)V", "setRectOutline", "Landroidx/compose/ui/graphics/ImageBitmap;", "toImageBitmap", "(LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/unit/IntOffset;", "setPosition-VbeCjmY", "setPosition", "recordInternal", "drawWithChildTracking", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "graphicsLayer", "addSubLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroid/graphics/Canvas;", "androidCanvas", "transformCanvas", "(Landroid/graphics/Canvas;)V", "recreateDisplayListIfNeeded", "onAddedToParentLayer", "onRemovedFromParentLayer", "Landroid/graphics/RectF;", "obtainPathBounds", "()Landroid/graphics/RectF;", "configureOutlineAndClip", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "resolveOutlinePosition", "(LS7/n;)Ljava/lang/Object;", "Landroid/graphics/Outline;", "updatePathOutline", "(Landroidx/compose/ui/graphics/Path;)Landroid/graphics/Outline;", "obtainAndroidOutline", "()Landroid/graphics/Outline;", "discardContentIfReleasedAndHaveNoParentLayerUsages", "resetOutlineParams", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "drawBlock", "LS7/k;", "clipDrawBlock", "androidOutline", "Landroid/graphics/Outline;", "", "outlineDirty", "Z", "roundRectOutlineTopLeft", "J", "roundRectOutlineSize", "roundRectCornerRadius", "F", "Landroidx/compose/ui/graphics/Outline;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "roundRectClipPath", "usePathForClip", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "softwareDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/Paint;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "", "parentLayerUsages", "I", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "value", "isReleased", "()Z", "getTopLeft-nOcc-ac", "()J", "setTopLeft--gyyYBs", "(J)V", "getSize-YbymL2g", "setSize-ozmzZPI", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "clip", "getClip", "setClip", "(Z)V", "getClip$annotations", "pathBounds", "Landroid/graphics/RectF;", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "compositingStrategy", "getAlpha", "()F", "setAlpha", "(F)V", "alpha", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter", "getScaleX", "setScaleX", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getShadowElevation", "setShadowElevation", "shadowElevation", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getRotationZ", "setRotationZ", "rotationZ", "getCameraDistance", "setCameraDistance", "cameraDistance", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "", "getLayerId", "layerId", "getOwnerViewId", "ownerViewId", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "ambientShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "spotShadowColor", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayer {
    private static final LayerSnapshotImpl SnapshotImpl;
    private static final boolean isRobolectric;
    private Outline androidOutline;
    private final ChildLayerDependenciesTracker childDependenciesTracker;
    private boolean clip;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
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
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private k drawBlock = new k() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        public final void invoke(DrawScope drawScope) {
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return r.f317a;
        }
    };
    private final k clipDrawBlock = new k() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$clipDrawBlock$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return r.f317a;
        }

        public final void invoke(DrawScope drawScope) {
            Path path = this.this$0.outlinePath;
            if (!this.this$0.usePathForClip || !this.this$0.getClip() || path == null) {
                this.this$0.drawWithChildTracking(drawScope);
                return;
            }
            GraphicsLayer graphicsLayer = this.this$0;
            int iM4128getIntersectrtfAjoo = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo4630clipPathmtrdDE(path, iM4128getIntersectrtfAjoo);
                graphicsLayer.drawWithChildTracking(drawScope);
            } finally {
                a.A(drawContext, jMo4628getSizeNHjbRc);
            }
        }
    };
    private boolean outlineDirty = true;

    @c(c = "androidx.compose.ui.graphics.layer.GraphicsLayer", f = "AndroidGraphicsLayer.android.kt", l = {869}, m = "toImageBitmap")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphicsLayer.this.toImageBitmap(this);
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
        boolean zEquals = lowerCase.equals("robolectric");
        isRobolectric = zEquals;
        SnapshotImpl = zEquals ? LayerSnapshotV21.INSTANCE : LayerSnapshotV28.INSTANCE;
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl) {
        this.impl = graphicsLayerImpl;
        Offset.Companion companion = Offset.INSTANCE;
        this.roundRectOutlineTopLeft = companion.m3911getZeroF1C5BW0();
        this.roundRectOutlineSize = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
        this.childDependenciesTracker = new ChildLayerDependenciesTracker();
        graphicsLayerImpl.setClip(false);
        this.topLeft = IntOffset.INSTANCE.m6983getZeronOccac();
        this.size = IntSize.INSTANCE.m7020getZeroYbymL2g();
        this.pivotOffset = companion.m3910getUnspecifiedF1C5BW0();
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void configureOutlineAndClip() {
        if (this.outlineDirty) {
            Outline outline = null;
            if (this.clip || getShadowElevation() > 0.0f) {
                Path path = this.outlinePath;
                if (path != null) {
                    RectF rectFObtainPathBounds = obtainPathBounds();
                    if (!(path instanceof AndroidPath)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((AndroidPath) path).getInternalPath().computeBounds(rectFObtainPathBounds, false);
                    Outline outlineUpdatePathOutline = updatePathOutline(path);
                    if (outlineUpdatePathOutline != null) {
                        outlineUpdatePathOutline.setAlpha(getAlpha());
                        outline = outlineUpdatePathOutline;
                    }
                    this.impl.mo4818setOutlineO0kMr_c(outline, IntSize.m7010constructorimpl((4294967295L & Math.round(rectFObtainPathBounds.height())) | (Math.round(rectFObtainPathBounds.width()) << 32)));
                    if (this.usePathForClip && this.clip) {
                        this.impl.setClip(false);
                        this.impl.discardDisplayList();
                    } else {
                        this.impl.setClip(this.clip);
                    }
                } else {
                    this.impl.setClip(this.clip);
                    Size.INSTANCE.m3973getZeroNHjbRc();
                    Outline outlineObtainAndroidOutline = obtainAndroidOutline();
                    long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(this.size);
                    long j5 = this.roundRectOutlineTopLeft;
                    long j6 = this.roundRectOutlineSize;
                    long j10 = j6 == InlineClassHelperKt.UnspecifiedPackedFloats ? jM7027toSizeozmzZPI : j6;
                    int i = (int) (j5 >> 32);
                    int i6 = (int) (j5 & 4294967295L);
                    outlineObtainAndroidOutline.setRoundRect(Math.round(Float.intBitsToFloat(i)), Math.round(Float.intBitsToFloat(i6)), Math.round(Float.intBitsToFloat((int) (j10 >> 32)) + Float.intBitsToFloat(i)), Math.round(Float.intBitsToFloat((int) (j10 & 4294967295L)) + Float.intBitsToFloat(i6)), this.roundRectCornerRadius);
                    outlineObtainAndroidOutline.setAlpha(getAlpha());
                    this.impl.mo4818setOutlineO0kMr_c(outlineObtainAndroidOutline, IntSizeKt.m7023roundToIntSizeuvyYCjk(j10));
                }
            } else {
                this.impl.setClip(false);
                this.impl.mo4818setOutlineO0kMr_c(null, IntSize.INSTANCE.m7020getZeroYbymL2g());
            }
        }
        this.outlineDirty = false;
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            discardDisplayList$ui_graphics_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawWithChildTracking(androidx.compose.ui.graphics.drawscope.DrawScope r14) {
        /*
            r13 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r13.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r0)
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependency$p(r0, r1)
            androidx.collection.MutableScatterSet r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r0)
            if (r1 == 0) goto L28
            boolean r2 = r1.isNotEmpty()
            if (r2 == 0) goto L28
            androidx.collection.MutableScatterSet r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r0)
            if (r2 != 0) goto L22
            androidx.collection.MutableScatterSet r2 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(r0, r2)
        L22:
            r2.addAll(r1)
            r1.clear()
        L28:
            r1 = 1
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r0, r1)
            S7.k r13 = r13.drawBlock
            r13.invoke(r14)
            r13 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r0, r13)
            androidx.compose.ui.graphics.layer.GraphicsLayer r14 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependency$p(r0)
            if (r14 == 0) goto L3e
            r14.onRemovedFromParentLayer()
        L3e:
            androidx.collection.MutableScatterSet r14 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r0)
            if (r14 == 0) goto L91
            boolean r0 = r14.isNotEmpty()
            if (r0 == 0) goto L91
            java.lang.Object[] r0 = r14.elements
            long[] r1 = r14.metadata
            int r2 = r1.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L8e
            r3 = r13
        L54:
            r4 = r1[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L89
            int r6 = r3 - r2
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r13
        L6e:
            if (r8 >= r6) goto L87
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L83
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            androidx.compose.ui.graphics.layer.GraphicsLayer r9 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r9
            r9.onRemovedFromParentLayer()
        L83:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L6e
        L87:
            if (r6 != r7) goto L8e
        L89:
            if (r3 == r2) goto L8e
            int r3 = r3 + 1
            goto L54
        L8e:
            r14.clear()
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.drawWithChildTracking(androidx.compose.ui.graphics.drawscope.DrawScope):void");
    }

    public static /* synthetic */ void getClip$annotations() {
    }

    private final Outline obtainAndroidOutline() {
        Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        Outline outline2 = new Outline();
        this.androidOutline = outline2;
        return outline2;
    }

    private final RectF obtainPathBounds() {
        RectF rectF = this.pathBounds;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF();
        this.pathBounds = rectF2;
        return rectF2;
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
        if (this.impl.getHasDisplayList()) {
            return;
        }
        try {
            recordInternal();
        } catch (Throwable unused) {
        }
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.INSTANCE.m3911getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    private final <T> T resolveOutlinePosition(n block) {
        long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(this.size);
        long j5 = this.roundRectOutlineTopLeft;
        long j6 = this.roundRectOutlineSize;
        if (j6 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM7027toSizeozmzZPI = j6;
        }
        return (T) block.invoke(Offset.m3884boximpl(j5), Size.m3952boximpl(jM7027toSizeozmzZPI));
    }

    /* renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m4790setPositionVbeCjmY(long topLeft, long size) {
        this.impl.mo4820setPositionH0pRuoY(IntOffset.m6972getXimpl(topLeft), IntOffset.m6973getYimpl(topLeft), size);
    }

    /* renamed from: setRectOutline-tz77jQw$default, reason: not valid java name */
    public static /* synthetic */ void m4791setRectOutlinetz77jQw$default(GraphicsLayer graphicsLayer, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = Offset.INSTANCE.m3911getZeroF1C5BW0();
        }
        if ((i & 2) != 0) {
            j6 = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
        }
        graphicsLayer.m4806setRectOutlinetz77jQw(j5, j6);
    }

    /* renamed from: setRoundRectOutline-TNW_H78$default, reason: not valid java name */
    public static /* synthetic */ void m4792setRoundRectOutlineTNW_H78$default(GraphicsLayer graphicsLayer, long j5, long j6, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = Offset.INSTANCE.m3911getZeroF1C5BW0();
        }
        long j10 = j5;
        if ((i & 2) != 0) {
            j6 = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
        }
        long j11 = j6;
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        graphicsLayer.m4807setRoundRectOutlineTNW_H78(j10, j11, f);
    }

    /* renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m4793setSizeozmzZPI(long j5) {
        if (IntSize.m7013equalsimpl0(this.size, j5)) {
            return;
        }
        this.size = j5;
        m4790setPositionVbeCjmY(this.topLeft, j5);
        if (this.roundRectOutlineSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        Canvas canvas;
        float fM6972getXimpl = IntOffset.m6972getXimpl(this.topLeft);
        float fM6973getYimpl = IntOffset.m6973getYimpl(this.topLeft);
        float fM6972getXimpl2 = IntOffset.m6972getXimpl(this.topLeft) + ((int) (this.size >> 32));
        float fM6973getYimpl2 = IntOffset.m6973getYimpl(this.topLeft) + ((int) (this.size & 4294967295L));
        float alpha = getAlpha();
        ColorFilter colorFilter = getColorFilter();
        int iM4795getBlendMode0nO6VwU = m4795getBlendMode0nO6VwU();
        if (alpha < 1.0f || !BlendMode.m4049equalsimpl0(iM4795getBlendMode0nO6VwU, BlendMode.INSTANCE.m4080getSrcOver0nO6VwU()) || colorFilter != null || CompositingStrategy.m4783equalsimpl0(m4796getCompositingStrategyke2Ky5w(), CompositingStrategy.INSTANCE.m4789getOffscreenke2Ky5w())) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(alpha);
            Paint.mo4015setBlendModes9anfk8(iM4795getBlendMode0nO6VwU);
            Paint.setColorFilter(colorFilter);
            canvas = androidCanvas;
            canvas.saveLayer(fM6972getXimpl, fM6973getYimpl, fM6972getXimpl2, fM6973getYimpl2, Paint.getInternalPaint());
        } else {
            androidCanvas.save();
            canvas = androidCanvas;
        }
        canvas.translate(fM6972getXimpl, fM6973getYimpl);
        canvas.concat(this.impl.calculateMatrix());
    }

    private final Outline updatePathOutline(Path path) {
        Outline outlineObtainAndroidOutline = obtainAndroidOutline();
        OutlineVerificationHelper.INSTANCE.setPath(outlineObtainAndroidOutline, path);
        this.usePathForClip = !outlineObtainAndroidOutline.canClip();
        this.outlinePath = path;
        return outlineObtainAndroidOutline;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void discardDisplayList$ui_graphics_release() {
        /*
            r15 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r15.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r0)
            if (r1 == 0) goto Lf
            r1.onRemovedFromParentLayer()
            r1 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setDependency$p(r0, r1)
        Lf:
            androidx.collection.MutableScatterSet r0 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r0)
            if (r0 == 0) goto L5d
            java.lang.Object[] r1 = r0.elements
            long[] r2 = r0.metadata
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5a
            r4 = 0
            r5 = r4
        L20:
            r6 = r2[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L55
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L3a:
            if (r10 >= r8) goto L53
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L4f
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r1[r11]
            androidx.compose.ui.graphics.layer.GraphicsLayer r11 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r11
            r11.onRemovedFromParentLayer()
        L4f:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L3a
        L53:
            if (r8 != r9) goto L5a
        L55:
            if (r5 == r3) goto L5a
            int r5 = r5 + 1
            goto L20
        L5a:
            r0.clear()
        L5d:
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r15 = r15.impl
            r15.discardDisplayList()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.discardDisplayList$ui_graphics_release():void");
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer parentLayer) {
        boolean z10;
        boolean z11;
        if (this.isReleased) {
            return;
        }
        configureOutlineAndClip();
        recreateDisplayListIfNeeded();
        boolean z12 = getShadowElevation() > 0.0f;
        if (z12) {
            canvas.enableZ();
        }
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean zIsHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            transformCanvas(nativeCanvas);
        }
        boolean z13 = !zIsHardwareAccelerated && this.clip;
        if (z13) {
            canvas.save();
            androidx.compose.ui.graphics.Outline outline = getOutline();
            if (outline instanceof Outline.Rectangle) {
                androidx.compose.ui.graphics.Canvas.m4112clipRectmtrdDE$default(canvas, ((Outline.Rectangle) outline).getRect(), 0, 2, null);
            } else if (outline instanceof Outline.Rounded) {
                Path Path = this.roundRectClipPath;
                if (Path != null) {
                    Path.rewind();
                } else {
                    Path = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = Path;
                }
                Path.addRoundRect$default(Path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
                androidx.compose.ui.graphics.Canvas.m4110clipPathmtrdDE$default(canvas, Path, 0, 2, null);
            } else {
                if (!(outline instanceof Outline.Generic)) {
                    throw new NoWhenBranchMatchedException();
                }
                androidx.compose.ui.graphics.Canvas.m4110clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated() || this.impl.getSupportsSoftwareRendering()) {
            z10 = z12;
            z11 = z13;
            this.impl.draw(canvas);
        } else {
            CanvasDrawScope canvasDrawScope = this.softwareDrawScope;
            if (canvasDrawScope == null) {
                canvasDrawScope = new CanvasDrawScope();
                this.softwareDrawScope = canvasDrawScope;
            }
            Density density = this.density;
            LayoutDirection layoutDirection = this.layoutDirection;
            long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(this.size);
            Density density2 = canvasDrawScope.getDrawContext().getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas2 = canvasDrawScope.getDrawContext().getCanvas();
            long jMo4628getSizeNHjbRc = canvasDrawScope.getDrawContext().mo4628getSizeNHjbRc();
            z10 = z12;
            GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
            z11 = z13;
            DrawContext drawContext = canvasDrawScope.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(canvas);
            drawContext.mo4629setSizeuvyYCjk(jM7027toSizeozmzZPI);
            drawContext.setGraphicsLayer(this);
            canvas.save();
            try {
                drawWithChildTracking(canvasDrawScope);
            } finally {
                canvas.restore();
                DrawContext drawContext2 = canvasDrawScope.getDrawContext();
                drawContext2.setDensity(density2);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas2);
                drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
            }
        }
        if (z11) {
            canvas.restore();
        }
        if (z10) {
            canvas.disableZ();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        nativeCanvas.restore();
    }

    public final void drawForPersistence$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas) {
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated() || this.impl.getSupportsSoftwareRendering()) {
            recreateDisplayListIfNeeded();
            this.impl.draw(canvas);
        }
    }

    public final void emulateTrimMemory$ui_graphics_release() {
        this.impl.discardDisplayList();
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public final long m4794getAmbientShadowColor0d7_KjU() {
        return this.impl.getAmbientShadowColor();
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m4795getBlendMode0nO6VwU() {
        return this.impl.getBlendMode();
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m4796getCompositingStrategyke2Ky5w() {
        return this.impl.getCompositingStrategy();
    }

    /* renamed from: getImpl$ui_graphics_release, reason: from getter */
    public final GraphicsLayerImpl getImpl() {
        return this.impl;
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline rectangle;
        androidx.compose.ui.graphics.Outline outline = this.internalOutline;
        Path path = this.outlinePath;
        if (outline != null) {
            return outline;
        }
        if (path != null) {
            Outline.Generic generic = new Outline.Generic(path);
            this.internalOutline = generic;
            return generic;
        }
        long jM7027toSizeozmzZPI = IntSizeKt.m7027toSizeozmzZPI(this.size);
        long j5 = this.roundRectOutlineTopLeft;
        long j6 = this.roundRectOutlineSize;
        if (j6 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM7027toSizeozmzZPI = j6;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jM7027toSizeozmzZPI >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jM7027toSizeozmzZPI & 4294967295L)) + fIntBitsToFloat2;
        if (this.roundRectCornerRadius > 0.0f) {
            rectangle = new Outline.Rounded(RoundRectKt.m3949RoundRectgG7oq9Y(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, CornerRadius.m3849constructorimpl((Float.floatToRawIntBits(r0) << 32) | (4294967295L & Float.floatToRawIntBits(r0)))));
        } else {
            rectangle = new Outline.Rectangle(new Rect(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.internalOutline = rectangle;
        return rectangle;
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    /* renamed from: getPivotOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getPivotOffset() {
        return this.pivotOffset;
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

    /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public final long m4799getSpotShadowColor0d7_KjU() {
        return this.impl.getSpotShadowColor();
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name and from getter */
    public final long getTopLeft() {
        return this.topLeft;
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    /* renamed from: isReleased, reason: from getter */
    public final boolean getIsReleased() {
        return this.isReleased;
    }

    /* renamed from: record-mL-hObY, reason: not valid java name */
    public final void m4801recordmLhObY(Density density, LayoutDirection layoutDirection, long size, k block) {
        m4793setSizeozmzZPI(size);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = block;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    public final void release$ui_graphics_release() {
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    public final void setAlpha(float f) {
        if (this.impl.getAlpha() == f) {
            return;
        }
        this.impl.setAlpha(f);
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m4802setAmbientShadowColor8_81llA(long j5) {
        if (Color.m4140equalsimpl0(j5, this.impl.getAmbientShadowColor())) {
            return;
        }
        this.impl.mo4815setAmbientShadowColor8_81llA(j5);
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m4803setBlendModes9anfk8(int i) {
        if (BlendMode.m4049equalsimpl0(this.impl.getBlendMode(), i)) {
            return;
        }
        this.impl.mo4816setBlendModes9anfk8(i);
    }

    public final void setCameraDistance(float f) {
        if (this.impl.getCameraDistance() == f) {
            return;
        }
        this.impl.setCameraDistance(f);
    }

    public final void setClip(boolean z10) {
        if (this.clip != z10) {
            this.clip = z10;
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (kotlin.jvm.internal.k.b(this.impl.getColorFilter(), colorFilter)) {
            return;
        }
        this.impl.setColorFilter(colorFilter);
    }

    /* renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m4804setCompositingStrategyWpw9cng(int i) {
        if (CompositingStrategy.m4783equalsimpl0(this.impl.getCompositingStrategy(), i)) {
            return;
        }
        this.impl.mo4817setCompositingStrategyWpw9cng(i);
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutlineAndClip();
    }

    /* renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m4805setPivotOffsetk4lQ0M(long j5) {
        if (Offset.m3892equalsimpl0(this.pivotOffset, j5)) {
            return;
        }
        this.pivotOffset = j5;
        this.impl.mo4819setPivotOffsetk4lQ0M(j5);
    }

    /* renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m4806setRectOutlinetz77jQw(long topLeft, long size) {
        m4807setRoundRectOutlineTNW_H78(topLeft, size, 0.0f);
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        if (kotlin.jvm.internal.k.b(this.impl.getRenderEffect(), renderEffect)) {
            return;
        }
        this.impl.setRenderEffect(renderEffect);
    }

    public final void setRotationX(float f) {
        if (this.impl.getRotationX() == f) {
            return;
        }
        this.impl.setRotationX(f);
    }

    public final void setRotationY(float f) {
        if (this.impl.getRotationY() == f) {
            return;
        }
        this.impl.setRotationY(f);
    }

    public final void setRotationZ(float f) {
        if (this.impl.getRotationZ() == f) {
            return;
        }
        this.impl.setRotationZ(f);
    }

    /* renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m4807setRoundRectOutlineTNW_H78(long topLeft, long size, float cornerRadius) {
        if (Offset.m3892equalsimpl0(this.roundRectOutlineTopLeft, topLeft) && Size.m3960equalsimpl0(this.roundRectOutlineSize, size) && this.roundRectCornerRadius == cornerRadius && this.outlinePath == null) {
            return;
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = topLeft;
        this.roundRectOutlineSize = size;
        this.roundRectCornerRadius = cornerRadius;
        configureOutlineAndClip();
    }

    public final void setScaleX(float f) {
        if (this.impl.getScaleX() == f) {
            return;
        }
        this.impl.setScaleX(f);
    }

    public final void setScaleY(float f) {
        if (this.impl.getScaleY() == f) {
            return;
        }
        this.impl.setScaleY(f);
    }

    public final void setShadowElevation(float f) {
        if (this.impl.getShadowElevation() == f) {
            return;
        }
        this.impl.setShadowElevation(f);
        this.outlineDirty = true;
        configureOutlineAndClip();
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m4808setSpotShadowColor8_81llA(long j5) {
        if (Color.m4140equalsimpl0(j5, this.impl.getSpotShadowColor())) {
            return;
        }
        this.impl.mo4821setSpotShadowColor8_81llA(j5);
    }

    /* renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m4809setTopLeftgyyYBs(long j5) {
        if (IntOffset.m6971equalsimpl0(this.topLeft, j5)) {
            return;
        }
        this.topLeft = j5;
        m4790setPositionVbeCjmY(j5, this.size);
    }

    public final void setTranslationX(float f) {
        if (this.impl.getTranslationX() == f) {
            return;
        }
        this.impl.setTranslationX(f);
    }

    public final void setTranslationY(float f) {
        if (this.impl.getTranslationY() == f) {
            return;
        }
        this.impl.setTranslationY(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object toImageBitmap(H7.c<? super androidx.compose.ui.graphics.ImageBitmap> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = (androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = new androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            androidx.compose.ui.graphics.layer.LayerSnapshotImpl r5 = androidx.compose.ui.graphics.layer.GraphicsLayer.SnapshotImpl
            r0.label = r3
            java.lang.Object r5 = r5.toBitmap(r4, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            androidx.compose.ui.graphics.ImageBitmap r4 = androidx.compose.ui.graphics.AndroidImageBitmap_androidKt.asImageBitmap(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.toImageBitmap(H7.c):java.lang.Object");
    }
}
