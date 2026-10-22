package androidx.compose.ui.text;

import C7.i;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary_androidKt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBk\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0014\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00110\u0010\u0012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\n\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J'\u0010-\u001a\u00020*2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u00100J)\u00108\u001a\u0002052\u0006\u00101\u001a\u00020*2\u0006\u00103\u001a\u0002022\b\b\u0001\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u00107J\u001f\u0010<\u001a\u00020;2\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b>\u00100J\u0017\u0010A\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bE\u0010DJ\u0017\u0010F\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bF\u0010DJ\u0017\u0010H\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0000¢\u0006\u0004\bG\u0010DJ\u0017\u0010I\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bI\u0010DJ\u0017\u0010K\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0000¢\u0006\u0004\bJ\u0010DJ\u0017\u0010L\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bL\u0010DJ\u0017\u0010M\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bM\u0010DJ\u0017\u0010N\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bN\u0010DJ\u0017\u0010O\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bO\u0010PJ\u001f\u0010S\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u00020Q2\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004H\u0000¢\u0006\u0004\bW\u0010PJ\u0017\u0010Z\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004H\u0000¢\u0006\u0004\bY\u0010PJ\u0017\u0010[\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b[\u0010PJ\u001f\u0010]\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020QH\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020_2\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b`\u0010aJ\u0017\u0010b\u001a\u00020_2\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\bb\u0010aJ3\u0010m\u001a\u0002052\u0006\u0010d\u001a\u00020c2\u0006\u0010f\u001a\u00020e2\b\u0010h\u001a\u0004\u0018\u00010g2\b\u0010j\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\bk\u0010lJE\u0010m\u001a\u0002052\u0006\u0010d\u001a\u00020c2\u0006\u0010f\u001a\u00020e2\b\u0010h\u001a\u0004\u0018\u00010g2\b\u0010j\u001a\u0004\u0018\u00010i2\b\u0010o\u001a\u0004\u0018\u00010n2\u0006\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\br\u0010sJM\u0010m\u001a\u0002052\u0006\u0010d\u001a\u00020c2\u0006\u0010u\u001a\u00020t2\u0006\u0010v\u001a\u00020\u001b2\b\u0010h\u001a\u0004\u0018\u00010g2\b\u0010j\u001a\u0004\u0018\u00010i2\b\u0010o\u001a\u0004\u0018\u00010n2\u0006\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bw\u0010xJ\u001b\u0010|\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010z*\u00020yH\u0002¢\u0006\u0004\b|\u0010}J#\u0010\u0081\u0001\u001a\u00020Q*\u00020~2\u000b\u0010\u0080\u0001\u001a\u0006\u0012\u0002\b\u00030\u007fH\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0018\u0010m\u001a\u0002052\u0006\u0010d\u001a\u00020cH\u0002¢\u0006\u0005\bm\u0010\u0083\u0001Jh\u0010\u008e\u0001\u001a\u00020y2\u0007\u0010\u0084\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u00042\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u00042\u0007\u0010\u0089\u0001\u001a\u00020\u00042\u0007\u0010\u008a\u0001\u001a\u00020\u00042\u0007\u0010\u008b\u0001\u001a\u00020\u00042\n\b\u0002\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u000f\n\u0005\b\u0005\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\u000f\n\u0005\b\u0007\u0010\u0093\u0001\u001a\u0006\b\u0096\u0001\u0010\u0095\u0001R\u001a\u0010\t\u001a\u00020\b8\u0006¢\u0006\u000f\n\u0005\b\t\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0017\u0010\u009a\u0001\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R(\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0000X\u0081\u0004¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u009c\u0001\u0012\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R'\u0010¡\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00108\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u0017\u0010§\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0017\u0010©\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010¦\u0001R\u0017\u0010«\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010¦\u0001R\u0017\u0010\u00ad\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010¦\u0001R\u0017\u0010¯\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¦\u0001R\u0017\u0010±\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b°\u0001\u0010¦\u0001R\u0017\u0010´\u0001\u001a\u00020Q8VX\u0096\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R \u0010¹\u0001\u001a\u00030µ\u00018@X\u0081\u0004¢\u0006\u0010\u0012\u0006\b¸\u0001\u0010 \u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u0017\u0010»\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010\u0095\u0001R \u0010À\u0001\u001a\u00030¼\u00018@X\u0081\u0004¢\u0006\u0010\u0012\u0006\b¿\u0001\u0010 \u0001\u001a\u0006\b½\u0001\u0010¾\u0001¨\u0006Á\u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "paragraphIntrinsics", "", "maxLines", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "Landroidx/compose/ui/unit/Constraints;", "constraints", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IIJLkotlin/jvm/internal/e;)V", "", "text", "Landroidx/compose/ui/text/TextStyle;", "style", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "annotations", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Landroidx/compose/ui/unit/Density;", "density", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IIJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/e;)V", "", "vertical", "getLineForVerticalPosition", "(F)I", "Landroidx/compose/ui/geometry/Offset;", "position", "getOffsetForPosition-k-4lQ0M", "(J)I", "getOffsetForPosition", "Landroidx/compose/ui/geometry/Rect;", "rect", "Landroidx/compose/ui/text/TextGranularity;", "granularity", "Landroidx/compose/ui/text/TextInclusionStrategy;", "inclusionStrategy", "Landroidx/compose/ui/text/TextRange;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForRect", TypedValues.CycleType.S_WAVE_OFFSET, "getBoundingBox", "(I)Landroidx/compose/ui/geometry/Rect;", "range", "", "array", "arrayStart", "LC7/r;", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "fillBoundingBoxes", "start", "end", "Landroidx/compose/ui/graphics/Path;", "getPathForRange", "(II)Landroidx/compose/ui/graphics/Path;", "getCursorRect", "getWordBoundary--jx7JFs", "(I)J", "getWordBoundary", "lineIndex", "getLineLeft", "(I)F", "getLineRight", "getLineTop", "getLineAscent$ui_text", "getLineAscent", "getLineBaseline", "getLineDescent$ui_text", "getLineDescent", "getLineBottom", "getLineHeight", "getLineWidth", "getLineStart", "(I)I", "", "visibleEnd", "getLineEnd", "(IZ)I", "isLineEllipsized", "(I)Z", "getLineEllipsisOffset$ui_text", "getLineEllipsisOffset", "getLineEllipsisCount$ui_text", "getLineEllipsisCount", "getLineForOffset", "usePrimaryDirection", "getHorizontalPosition", "(IZ)F", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getParagraphDirection", "(I)Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/text/android/TextLayout;", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "getShaderBrushSpans", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "Landroid/text/Spanned;", "Ljava/lang/Class;", "clazz", "hasSpan", "(Landroid/text/Spanned;Ljava/lang/Class;)Z", "(Landroidx/compose/ui/graphics/Canvas;)V", "alignment", "justificationMode", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "", "charSequence", "constructTextLayout", "(IILandroid/text/TextUtils$TruncateAt;IIIIILjava/lang/CharSequence;)Landroidx/compose/ui/text/android/TextLayout;", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "I", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "J", "getConstraints-msEJaDk", "()J", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "Ljava/lang/CharSequence;", "getCharSequence$ui_text", "()Ljava/lang/CharSequence;", "getCharSequence$ui_text$annotations", "()V", "placeholderRects", "Ljava/util/List;", "getPlaceholderRects", "()Ljava/util/List;", "getWidth", "()F", "width", "getHeight", "height", "getMaxIntrinsicWidth", "maxIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth", "getFirstBaseline", "firstBaseline", "getLastBaseline", "lastBaseline", "getDidExceedMaxLines", "()Z", "didExceedMaxLines", "Ljava/util/Locale;", "getTextLocale$ui_text", "()Ljava/util/Locale;", "getTextLocale$ui_text$annotations", "textLocale", "getLineCount", "lineCount", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text$annotations", "textPaint", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidParagraph implements Paragraph {
    public static final int $stable = 8;
    private final CharSequence charSequence;
    private final long constraints;
    private final TextLayout layout;
    private final int maxLines;
    private final int overflow;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, int i6, long j5, e eVar) {
        this(androidParagraphIntrinsics, i, i6, j5);
    }

    private final TextLayout constructTextLayout(int alignment, int justificationMode, TextUtils.TruncateAt ellipsize, int maxLines, int hyphens, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle, CharSequence charSequence) {
        return new TextLayout(charSequence, getWidth(), getTextPaint$ui_text(), alignment, ellipsize, this.paragraphIntrinsics.getTextDirectionHeuristic(), 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, maxLines, breakStrategy, lineBreakStyle, lineBreakWordStyle, hyphens, justificationMode, null, null, this.paragraphIntrinsics.getLayoutIntrinsics(), 196736, null);
    }

    public static /* synthetic */ TextLayout constructTextLayout$default(AndroidParagraph androidParagraph, int i, int i6, TextUtils.TruncateAt truncateAt, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, Object obj) {
        return androidParagraph.constructTextLayout(i, i6, truncateAt, i10, i11, i12, i13, i14, (i15 & 256) != 0 ? androidParagraph.charSequence : charSequence);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCharSequence$ui_text$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRangeForRect_8_6BmAI$lambda$6(TextInclusionStrategy textInclusionStrategy, RectF rectF, RectF rectF2) {
        return textInclusionStrategy.isIncluded(RectHelper_androidKt.toComposeRect(rectF), RectHelper_androidKt.toComposeRect(rectF2));
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        if (!(textLayout.getText() instanceof Spanned)) {
            return null;
        }
        CharSequence text = textLayout.getText();
        k.d(text, "null cannot be cast to non-null type android.text.Spanned");
        if (!hasSpan((Spanned) text, ShaderBrushSpan.class)) {
            return null;
        }
        CharSequence text2 = textLayout.getText();
        k.d(text2, "null cannot be cast to non-null type android.text.Spanned");
        return (ShaderBrushSpan[]) ((Spanned) text2).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
    }

    @VisibleForTesting
    public static /* synthetic */ void getTextLocale$ui_text$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTextPaint$ui_text$annotations() {
    }

    private final boolean hasSpan(Spanned spanned, Class<?> cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public void mo6125fillBoundingBoxes8ffj60Q(long range, float[] array, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int arrayStart) {
        this.layout.fillBoundingBoxes(TextRange.m6309getMinimpl(range), TextRange.m6308getMaximpl(range), array, arrayStart);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getBidiRunDirection(int offset) {
        return this.layout.isRtlCharAt(offset) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getBoundingBox(int offset) {
        boolean z10 = false;
        if (offset >= 0 && offset < this.charSequence.length()) {
            z10 = true;
        }
        if (!z10) {
            StringBuilder sbU = B7.a.u(offset, "offset(", ") is out of bounds [0,");
            sbU.append(this.charSequence.length());
            sbU.append(')');
            InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
        }
        RectF boundingBox = this.layout.getBoundingBox(offset);
        return new Rect(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
    }

    /* renamed from: getCharSequence$ui_text, reason: from getter */
    public final CharSequence getCharSequence() {
        return this.charSequence;
    }

    /* renamed from: getConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getCursorRect(int offset) {
        if (!(offset >= 0 && offset <= this.charSequence.length())) {
            StringBuilder sbU = B7.a.u(offset, "offset(", ") is out of bounds [0,");
            sbU.append(this.charSequence.length());
            sbU.append(']');
            InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
        }
        float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, null);
        int lineForOffset = this.layout.getLineForOffset(offset);
        return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getFirstBaseline() {
        return getLineBaseline(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return this.layout.getHeight();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        return usePrimaryDirection ? TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, null) : TextLayout.getSecondaryHorizontal$default(this.layout, offset, false, 2, null);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLastBaseline() {
        return getLineBaseline(getLineCount() - 1);
    }

    public final float getLineAscent$ui_text(int lineIndex) {
        return this.layout.getLineAscent(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBaseline(int lineIndex) {
        return this.layout.getLineBaseline(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBottom(int lineIndex) {
        return this.layout.getLineBottom(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public final float getLineDescent$ui_text(int lineIndex) {
        return this.layout.getLineDescent(lineIndex);
    }

    public final int getLineEllipsisCount$ui_text(int lineIndex) {
        return this.layout.getLineEllipsisCount(lineIndex);
    }

    public final int getLineEllipsisOffset$ui_text(int lineIndex) {
        return this.layout.getLineEllipsisOffset(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineEnd(int lineIndex, boolean visibleEnd) {
        return visibleEnd ? this.layout.getLineVisibleEnd(lineIndex) : this.layout.getLineEnd(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForVerticalPosition(float vertical) {
        return this.layout.getLineForVertical((int) vertical);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineHeight(int lineIndex) {
        return this.layout.getLineHeight(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineTop(int lineIndex) {
        return this.layout.getLineTop(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public int mo6127getOffsetForPositionk4lQ0M(long position) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Float.intBitsToFloat((int) (4294967295L & position))), Float.intBitsToFloat((int) (position >> 32)));
    }

    /* renamed from: getOverflow-gIe3tQ8, reason: not valid java name and from getter */
    public final int getOverflow() {
        return this.overflow;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getParagraphDirection(int offset) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(offset)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Path getPathForRange(int start, int end) {
        if (!(start >= 0 && start <= end && end <= this.charSequence.length())) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(start, "start(", end, ") or end(", ") is out of range [0..");
            sbS.append(this.charSequence.length());
            sbS.append("], or start > end!");
            InlineClassHelperKt.throwIllegalArgumentException(sbS.toString());
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(start, end, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public long mo6129getRangeForRect86BmAI(Rect rect, int granularity, TextInclusionStrategy inclusionStrategy) {
        int[] rangeForRect = this.layout.getRangeForRect(RectHelper_androidKt.toAndroidRectF(rect), AndroidParagraph_androidKt.m6145toLayoutTextGranularityduNsdkg(granularity), new G6.e(inclusionStrategy, 3));
        return rangeForRect == null ? TextRange.INSTANCE.m6316getZerod9O1mEE() : TextRangeKt.TextRange(rangeForRect[0], rangeForRect[1]);
    }

    public final Locale getTextLocale$ui_text() {
        return this.paragraphIntrinsics.getTextPaint().getTextLocale();
    }

    public final AndroidTextPaint getTextPaint$ui_text() {
        return this.paragraphIntrinsics.getTextPaint();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return Constraints.m6797getMaxWidthimpl(this.constraints);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public long mo6130getWordBoundaryjx7JFs(int offset) {
        WordIterator wordIterator = this.layout.getWordIterator();
        return TextRangeKt.TextRange(WordBoundary_androidKt.getWordStart(wordIterator, offset), WordBoundary_androidKt.getWordEnd(wordIterator, offset));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean isLineEllipsized(int lineIndex) {
        return this.layout.isLineEllipsized(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-LG529CI, reason: not valid java name */
    public void mo6131paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        int iM6573getBlendMode0nO6VwU = getTextPaint$ui_text().getBackingBlendMode();
        AndroidTextPaint textPaint$ui_text = getTextPaint$ui_text();
        textPaint$ui_text.m6578setColor8_81llA(color);
        textPaint$ui_text.setShadow(shadow);
        textPaint$ui_text.setTextDecoration(textDecoration);
        textPaint$ui_text.setDrawStyle(drawStyle);
        textPaint$ui_text.m6575setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text().m6575setBlendModes9anfk8(iM6573getBlendMode0nO6VwU);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-RPmYEkk, reason: not valid java name */
    public void mo6132paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration) {
        AndroidTextPaint textPaint$ui_text = getTextPaint$ui_text();
        textPaint$ui_text.m6578setColor8_81llA(color);
        textPaint$ui_text.setShadow(shadow);
        textPaint$ui_text.setTextDecoration(textDecoration);
        paint(canvas);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-hn5TExg, reason: not valid java name */
    public void mo6133painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        int iM6573getBlendMode0nO6VwU = getTextPaint$ui_text().getBackingBlendMode();
        AndroidTextPaint textPaint$ui_text = getTextPaint$ui_text();
        float width = getWidth();
        float height = getHeight();
        textPaint$ui_text.m6576setBrush12SF9DM(brush, Size.m3955constructorimpl((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), alpha);
        textPaint$ui_text.setShadow(shadow);
        textPaint$ui_text.setTextDecoration(textDecoration);
        textPaint$ui_text.setDrawStyle(drawStyle);
        textPaint$ui_text.m6575setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text().m6575setBlendModes9anfk8(iM6573getBlendMode0nO6VwU);
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i, int i6, long j5, FontFamily.Resolver resolver, Density density, e eVar) {
        this(str, textStyle, list, list2, i, i6, j5, resolver, density);
    }

    private AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, int i6, long j5) {
        CharSequence charSequence;
        TextUtils.TruncateAt truncateAt;
        int i10;
        AndroidParagraph androidParagraph;
        int i11;
        int i12;
        List<Rect> list;
        Rect rect;
        float horizontalPosition;
        float lineBaseline;
        int heightPx;
        float lineTop;
        float heightPx2;
        float lineBaseline2;
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        this.maxLines = i;
        this.overflow = i6;
        this.constraints = j5;
        if (Constraints.m6798getMinHeightimpl(j5) != 0 || Constraints.m6799getMinWidthimpl(j5) != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        if (i < 1) {
            InlineClassHelperKt.throwIllegalArgumentException("maxLines should be greater than 0");
        }
        TextStyle style = androidParagraphIntrinsics.getStyle();
        TextOverflow.Companion companion = TextOverflow.INSTANCE;
        if (AndroidParagraph_androidKt.shouldAttachIndentationFixSpan(style, TextOverflow.m6770equalsimpl0(i6, companion.m6780getEllipsisgIe3tQ8()))) {
            charSequence = AndroidParagraph_androidKt.attachIndentationFixSpan(androidParagraphIntrinsics.getCharSequence());
        } else {
            charSequence = androidParagraphIntrinsics.getCharSequence();
        }
        this.charSequence = charSequence;
        int iM6140toLayoutAlignaXe7zB0 = AndroidParagraph_androidKt.m6140toLayoutAlignaXe7zB0(style.m6352getTextAligne0LSkKk());
        boolean zM6724equalsimpl0 = TextAlign.m6724equalsimpl0(style.m6352getTextAligne0LSkKk(), TextAlign.INSTANCE.m6730getJustifye0LSkKk());
        int iM6142toLayoutHyphenationFrequency3fSNIE = AndroidParagraph_androidKt.m6142toLayoutHyphenationFrequency3fSNIE(style.getParagraphStyle().getHyphens());
        int iM6141toLayoutBreakStrategyxImikfE = AndroidParagraph_androidKt.m6141toLayoutBreakStrategyxImikfE(LineBreak.m6636getStrategyfcGXIks(style.m6349getLineBreakrAG3T2k()));
        int iM6143toLayoutLineBreakStylehpcqdu8 = AndroidParagraph_androidKt.m6143toLayoutLineBreakStylehpcqdu8(LineBreak.m6637getStrictnessusljTpc(style.m6349getLineBreakrAG3T2k()));
        int iM6144toLayoutLineBreakWordStylewPN0Rpw = AndroidParagraph_androidKt.m6144toLayoutLineBreakWordStylewPN0Rpw(LineBreak.m6638getWordBreakjp8hJ3c(style.m6349getLineBreakrAG3T2k()));
        if (TextOverflow.m6770equalsimpl0(i6, companion.m6780getEllipsisgIe3tQ8())) {
            truncateAt = TextUtils.TruncateAt.END;
        } else if (TextOverflow.m6770equalsimpl0(i6, companion.m6781getMiddleEllipsisgIe3tQ8())) {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        } else {
            truncateAt = TextOverflow.m6770equalsimpl0(i6, companion.m6782getStartEllipsisgIe3tQ8()) ? TextUtils.TruncateAt.START : null;
        }
        CharSequence charSequence2 = charSequence;
        TextUtils.TruncateAt truncateAt2 = truncateAt;
        TextLayout textLayoutConstructTextLayout$default = constructTextLayout$default(this, iM6140toLayoutAlignaXe7zB0, zM6724equalsimpl0 ? 1 : 0, truncateAt2, i, iM6142toLayoutHyphenationFrequency3fSNIE, iM6141toLayoutBreakStrategyxImikfE, iM6143toLayoutLineBreakStylehpcqdu8, iM6144toLayoutLineBreakWordStylewPN0Rpw, null, 256, null);
        if (Build.VERSION.SDK_INT >= 35 || getTextPaint$ui_text().getLetterSpacing() == 0.0f || (!(TextOverflow.m6770equalsimpl0(i6, companion.m6782getStartEllipsisgIe3tQ8()) || TextOverflow.m6770equalsimpl0(i6, companion.m6781getMiddleEllipsisgIe3tQ8())) || textLayoutConstructTextLayout$default.getLineEllipsisCount(0) <= 0)) {
            i10 = i;
        } else {
            int lineEllipsisOffset = textLayoutConstructTextLayout$default.getLineEllipsisOffset(0);
            i10 = i;
            textLayoutConstructTextLayout$default = constructTextLayout(iM6140toLayoutAlignaXe7zB0, zM6724equalsimpl0 ? 1 : 0, truncateAt2, i10, iM6142toLayoutHyphenationFrequency3fSNIE, iM6141toLayoutBreakStrategyxImikfE, iM6143toLayoutLineBreakStylehpcqdu8, iM6144toLayoutLineBreakWordStylewPN0Rpw, TextUtils.concat(charSequence2.subSequence(0, lineEllipsisOffset), "…", charSequence2.subSequence(textLayoutConstructTextLayout$default.getLineEllipsisCount(0) + lineEllipsisOffset, charSequence2.length())));
        }
        if (TextOverflow.m6770equalsimpl0(i6, companion.m6780getEllipsisgIe3tQ8()) && textLayoutConstructTextLayout$default.getHeight() > Constraints.m6796getMaxHeightimpl(j5) && i10 > 1) {
            int iNumberOfLinesThatFitMaxHeight = AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight(textLayoutConstructTextLayout$default, Constraints.m6796getMaxHeightimpl(j5));
            if (iNumberOfLinesThatFitMaxHeight < 0 || iNumberOfLinesThatFitMaxHeight == i10) {
                androidParagraph = this;
                i11 = 2;
                i12 = 0;
            } else {
                int i13 = iNumberOfLinesThatFitMaxHeight < 1 ? 1 : iNumberOfLinesThatFitMaxHeight;
                i12 = 0;
                i11 = 2;
                androidParagraph = this;
                textLayoutConstructTextLayout$default = constructTextLayout$default(androidParagraph, iM6140toLayoutAlignaXe7zB0, zM6724equalsimpl0 ? 1 : 0, truncateAt2, i13, iM6142toLayoutHyphenationFrequency3fSNIE, iM6141toLayoutBreakStrategyxImikfE, iM6143toLayoutLineBreakStylehpcqdu8, iM6144toLayoutLineBreakWordStylewPN0Rpw, null, 256, null);
            }
            androidParagraph.layout = textLayoutConstructTextLayout$default;
        } else {
            androidParagraph = this;
            i11 = 2;
            i12 = 0;
            androidParagraph.layout = textLayoutConstructTextLayout$default;
        }
        androidParagraph.getTextPaint$ui_text().m6576setBrush12SF9DM(style.getBrush(), Size.m3955constructorimpl((Float.floatToRawIntBits(androidParagraph.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(androidParagraph.getWidth()) << 32)), style.getAlpha());
        ShaderBrushSpan[] shaderBrushSpans = androidParagraph.getShaderBrushSpans(androidParagraph.layout);
        if (shaderBrushSpans != null) {
            i iVarJ = k.j(shaderBrushSpans);
            while (iVarJ.hasNext()) {
                ((ShaderBrushSpan) iVarJ.next()).m6599setSizeuvyYCjk(Size.m3955constructorimpl((Float.floatToRawIntBits(androidParagraph.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(androidParagraph.getWidth()) << 32)));
            }
        }
        CharSequence charSequence3 = androidParagraph.charSequence;
        if (!(charSequence3 instanceof Spanned)) {
            list = EmptyList.f4893a;
        } else {
            Spanned spanned = (Spanned) charSequence3;
            Object[] spans = spanned.getSpans(i12, charSequence3.length(), PlaceholderSpan.class);
            ArrayList arrayList = new ArrayList(spans.length);
            int length = spans.length;
            for (int i14 = i12; i14 < length; i14++) {
                PlaceholderSpan placeholderSpan = (PlaceholderSpan) spans[i14];
                int spanStart = spanned.getSpanStart(placeholderSpan);
                int spanEnd = spanned.getSpanEnd(placeholderSpan);
                int lineForOffset = androidParagraph.layout.getLineForOffset(spanStart);
                int i15 = lineForOffset >= androidParagraph.maxLines ? 1 : i12;
                int i16 = (androidParagraph.layout.getLineEllipsisCount(lineForOffset) <= 0 || spanEnd <= androidParagraph.layout.getLineEllipsisOffset(lineForOffset)) ? i12 : 1;
                int i17 = spanEnd > androidParagraph.layout.getLineEnd(lineForOffset) ? 1 : i12;
                if (i16 == 0 && i17 == 0 && i15 == 0) {
                    int i18 = WhenMappings.$EnumSwitchMapping$0[androidParagraph.getBidiRunDirection(spanStart).ordinal()];
                    if (i18 == 1) {
                        horizontalPosition = androidParagraph.getHorizontalPosition(spanStart, true);
                    } else if (i18 == i11) {
                        horizontalPosition = androidParagraph.getHorizontalPosition(spanStart, true) - placeholderSpan.getWidthPx();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    float widthPx = placeholderSpan.getWidthPx() + horizontalPosition;
                    TextLayout textLayout = androidParagraph.layout;
                    switch (placeholderSpan.getVerticalAlign()) {
                        case 0:
                            lineBaseline = textLayout.getLineBaseline(lineForOffset);
                            heightPx = placeholderSpan.getHeightPx();
                            lineTop = lineBaseline - heightPx;
                            rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                            break;
                        case 1:
                            lineTop = textLayout.getLineTop(lineForOffset);
                            rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                            break;
                        case 2:
                            lineBaseline = textLayout.getLineBottom(lineForOffset);
                            heightPx = placeholderSpan.getHeightPx();
                            lineTop = lineBaseline - heightPx;
                            rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                            break;
                        case 3:
                            lineTop = ((textLayout.getLineBottom(lineForOffset) + textLayout.getLineTop(lineForOffset)) - placeholderSpan.getHeightPx()) / i11;
                            rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                            break;
                        case 4:
                            heightPx2 = placeholderSpan.getFontMetrics().ascent;
                            lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                            lineTop = lineBaseline2 + heightPx2;
                            rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                            break;
                        case 5:
                            lineBaseline = textLayout.getLineBaseline(lineForOffset) + placeholderSpan.getFontMetrics().descent;
                            heightPx = placeholderSpan.getHeightPx();
                            lineTop = lineBaseline - heightPx;
                            rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                            break;
                        case 6:
                            Paint.FontMetricsInt fontMetrics = placeholderSpan.getFontMetrics();
                            heightPx2 = ((fontMetrics.ascent + fontMetrics.descent) - placeholderSpan.getHeightPx()) / i11;
                            lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                            lineTop = lineBaseline2 + heightPx2;
                            rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                            break;
                        default:
                            throw new IllegalStateException("unexpected verticalAlignment");
                    }
                } else {
                    rect = null;
                }
                arrayList.add(rect);
            }
            list = arrayList;
        }
        androidParagraph.placeholderRects = list;
    }

    private AndroidParagraph(String str, TextStyle textStyle, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, int i6, long j5, FontFamily.Resolver resolver, Density density) {
        this(new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density), i, i6, j5, null);
    }
}
