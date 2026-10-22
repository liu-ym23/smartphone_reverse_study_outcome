package androidx.compose.ui.text;

import C7.r;
import D7.A;
import D7.v;
import H4.o;
import S7.k;
import androidx.annotation.IntRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B-\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB[\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\n\u0010\u0018B[\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u001bB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\n\u0010 B-\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010!B[\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\"B[\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\n\u0010#J9\u0010/\u001a\u00020,2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b-\u0010.JM\u0010/\u001a\u00020,2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b4\u00105JU\u0010/\u001a\u00020,2\u0006\u0010%\u001a\u00020$2\u0006\u00107\u001a\u0002062\b\b\u0002\u00108\u001a\u00020\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b9\u0010:J\u001d\u0010>\u001a\u00020=2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\b¢\u0006\u0004\bA\u0010BJ\u0015\u0010G\u001a\u00020\u00042\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ%\u0010Q\u001a\u00020N2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bO\u0010PJ\u0015\u0010S\u001a\u00020H2\u0006\u0010R\u001a\u00020\u0004¢\u0006\u0004\bS\u0010TJ'\u0010[\u001a\u00020V2\u0006\u0010U\u001a\u00020N2\u0006\u0010W\u001a\u00020V2\b\b\u0001\u0010X\u001a\u00020\u0004¢\u0006\u0004\bY\u0010ZJ\u001d\u0010]\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0006¢\u0006\u0004\b]\u0010^J\u0015\u0010`\u001a\u00020_2\u0006\u0010R\u001a\u00020\u0004¢\u0006\u0004\b`\u0010aJ\u0015\u0010b\u001a\u00020_2\u0006\u0010R\u001a\u00020\u0004¢\u0006\u0004\bb\u0010aJ\u0015\u0010e\u001a\u00020N2\u0006\u0010R\u001a\u00020\u0004¢\u0006\u0004\bc\u0010dJ\u0015\u0010f\u001a\u00020H2\u0006\u0010R\u001a\u00020\u0004¢\u0006\u0004\bf\u0010TJ\u0015\u0010g\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004¢\u0006\u0004\bg\u0010hJ\u0015\u0010j\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bj\u0010kJ\u0015\u0010l\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bl\u0010kJ\u0015\u0010m\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bm\u0010kJ\u0015\u0010n\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bn\u0010kJ\u0015\u0010o\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bo\u0010kJ\u0015\u0010p\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bp\u0010kJ\u0015\u0010q\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bq\u0010kJ\u0015\u0010r\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\br\u0010hJ\u001f\u0010t\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u0006¢\u0006\u0004\bt\u0010uJ\u0015\u0010v\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bv\u0010wJ\u0017\u0010x\u001a\u00020,2\u0006\u0010R\u001a\u00020\u0004H\u0002¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020,2\u0006\u0010R\u001a\u00020\u0004H\u0002¢\u0006\u0004\bz\u0010yJ\u0017\u0010{\u001a\u00020,2\u0006\u0010i\u001a\u00020\u0004H\u0002¢\u0006\u0004\b{\u0010yR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010|\u001a\u0004\b}\u0010~R\u0019\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u000e\n\u0004\b\u0005\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0082\u0001\u001a\u00020\u00068\u0006¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\t\u001a\u00020\b8\u0006¢\u0006\u000f\n\u0005\b\t\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u0089\u0001\u001a\u00020\b8\u0006¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u0086\u0001\u001a\u0006\b\u008a\u0001\u0010\u0088\u0001R\u001b\u0010\u008b\u0001\u001a\u00020\u00048\u0006¢\u0006\u000f\n\u0005\b\u008b\u0001\u0010\u007f\u001a\u0006\b\u008c\u0001\u0010\u0081\u0001R$\u0010\u008d\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0\u00108\u0006¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R&\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010\u00108\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u008e\u0001\u001a\u0006\b\u0093\u0001\u0010\u0090\u0001R\u0014\u0010\u0095\u0001\u001a\u00020\b8F¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0088\u0001R\u0014\u0010\u0097\u0001\u001a\u00020\b8F¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0088\u0001R\u0014\u0010\u0099\u0001\u001a\u00020\b8F¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0088\u0001R\u0014\u0010\u009b\u0001\u001a\u00020\b8F¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u0088\u0001R\u0016\u0010\r\u001a\u00020\f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001¨\u0006\u009e\u0001"}, d2 = {"Landroidx/compose/ui/text/MultiParagraph;", "", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "intrinsics", "", "maxLines", "", "ellipsis", "", "width", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "Landroidx/compose/ui/text/AnnotatedString;", "annotatedString", "Landroidx/compose/ui/text/TextStyle;", "style", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "resourceLoader", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIILkotlin/jvm/internal/e;)V", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/e;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/e;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IILkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/style/TextDecoration;", "decoration", "LC7/r;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "start", "end", "Landroidx/compose/ui/graphics/Path;", "getPathForRange", "(II)Landroidx/compose/ui/graphics/Path;", "vertical", "getLineForVerticalPosition", "(F)I", "Landroidx/compose/ui/geometry/Offset;", "position", "getOffsetForPosition-k-4lQ0M", "(J)I", "getOffsetForPosition", "Landroidx/compose/ui/geometry/Rect;", "rect", "Landroidx/compose/ui/text/TextGranularity;", "granularity", "Landroidx/compose/ui/text/TextInclusionStrategy;", "inclusionStrategy", "Landroidx/compose/ui/text/TextRange;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForRect", TypedValues.CycleType.S_WAVE_OFFSET, "getBoundingBox", "(I)Landroidx/compose/ui/geometry/Rect;", "range", "", "array", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)[F", "fillBoundingBoxes", "usePrimaryDirection", "getHorizontalPosition", "(IZ)F", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getParagraphDirection", "(I)Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "getWordBoundary--jx7JFs", "(I)J", "getWordBoundary", "getCursorRect", "getLineForOffset", "(I)I", "lineIndex", "getLineLeft", "(I)F", "getLineRight", "getLineTop", "getLineBaseline", "getLineBottom", "getLineHeight", "getLineWidth", "getLineStart", "visibleEnd", "getLineEnd", "(IZ)I", "isLineEllipsized", "(I)Z", "requireIndexInRange", "(I)V", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "I", "getMaxLines", "()I", "didExceedMaxLines", "Z", "getDidExceedMaxLines", "()Z", "F", "getWidth", "()F", "height", "getHeight", "lineCount", "getLineCount", "placeholderRects", "Ljava/util/List;", "getPlaceholderRects", "()Ljava/util/List;", "Landroidx/compose/ui/text/ParagraphInfo;", "paragraphInfoList", "getParagraphInfoList$ui_text", "getMinIntrinsicWidth", "minIntrinsicWidth", "getMaxIntrinsicWidth", "maxIntrinsicWidth", "getFirstBaseline", "firstBaseline", "getLastBaseline", "lastBaseline", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiParagraph {
    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List<ParagraphInfo> paragraphInfoList;
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List list, int i, int i6, e eVar) {
        this(annotatedString, textStyle, j5, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r fillBoundingBoxes_8ffj60Q$lambda$19(long j5, float[] fArr, Ref$IntRef ref$IntRef, Ref$FloatRef ref$FloatRef, ParagraphInfo paragraphInfo) {
        long jTextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(paragraphInfo.getStartIndex() > TextRange.m6309getMinimpl(j5) ? paragraphInfo.getStartIndex() : TextRange.m6309getMinimpl(j5)), paragraphInfo.toLocalIndex(paragraphInfo.getEndIndex() < TextRange.m6308getMaximpl(j5) ? paragraphInfo.getEndIndex() : TextRange.m6308getMaximpl(j5)));
        paragraphInfo.getParagraph().mo6125fillBoundingBoxes8ffj60Q(jTextRange, fArr, ref$IntRef.f4918a);
        int iM6307getLengthimpl = (TextRange.m6307getLengthimpl(jTextRange) * 4) + ref$IntRef.f4918a;
        for (int i = ref$IntRef.f4918a; i < iM6307getLengthimpl; i += 4) {
            int i6 = i + 1;
            float f = fArr[i6];
            float f7 = ref$FloatRef.f4917a;
            fArr[i6] = f + f7;
            int i10 = i + 3;
            fArr[i10] = fArr[i10] + f7;
        }
        ref$IntRef.f4918a = iM6307getLengthimpl;
        ref$FloatRef.f4917a = paragraphInfo.getParagraph().getHeight() + ref$FloatRef.f4917a;
        return r.f317a;
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public static /* synthetic */ int getLineEnd$default(MultiParagraph multiParagraph, int i, boolean z10, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        return multiParagraph.getLineEnd(i, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r getPathForRange$lambda$11(Path path, int i, int i6, ParagraphInfo paragraphInfo) {
        Path.m4420addPathUv8p0NA$default(path, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(i), paragraphInfo.toLocalIndex(i6))), 0L, 2, null);
        return r.f317a;
    }

    /* renamed from: paint-RPmYEkk$default, reason: not valid java name */
    public static /* synthetic */ void m6169paintRPmYEkk$default(MultiParagraph multiParagraph, Canvas canvas, long j5, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
        multiParagraph.m6176paintRPmYEkk(canvas, j5, (i & 4) != 0 ? null : shadow, (i & 8) != 0 ? null : textDecoration);
    }

    /* renamed from: paint-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m6170painthn5TExg$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            f = Float.NaN;
        }
        multiParagraph.m6177painthn5TExg(canvas, brush, f, (i6 & 8) != 0 ? null : shadow, (i6 & 16) != 0 ? null : textDecoration, (i6 & 32) != 0 ? null : drawStyle, (i6 & 64) != 0 ? DrawScope.INSTANCE.m4709getDefaultBlendMode0nO6VwU() : i);
    }

    private final void requireIndexInRange(int offset) {
        boolean z10 = false;
        if (offset >= 0 && offset < getAnnotatedString().getText().length()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        StringBuilder sbU = B7.a.u(offset, "offset(", ") is out of bounds [0, ");
        sbU.append(getAnnotatedString().length());
        sbU.append(')');
        InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
    }

    private final void requireIndexInRangeInclusiveEnd(int offset) {
        boolean z10 = false;
        if (offset >= 0 && offset <= getAnnotatedString().getText().length()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        StringBuilder sbU = B7.a.u(offset, "offset(", ") is out of bounds [0, ");
        sbU.append(getAnnotatedString().length());
        sbU.append(']');
        InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
    }

    private final void requireLineIndexInRange(int lineIndex) {
        boolean z10 = false;
        if (lineIndex >= 0 && lineIndex < this.lineCount) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        StringBuilder sbU = B7.a.u(lineIndex, "lineIndex(", ") is out of bounds [0, ");
        sbU.append(this.lineCount);
        sbU.append(')');
        InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final float[] m6171fillBoundingBoxes8ffj60Q(long range, float[] array, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int arrayStart) {
        requireIndexInRange(TextRange.m6309getMinimpl(range));
        requireIndexInRangeInclusiveEnd(TextRange.m6308getMaximpl(range));
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f4918a = arrayStart;
        MultiParagraphKt.m6178findParagraphsByRangeSbBc2M(this.paragraphInfoList, range, new R3.a(range, array, ref$IntRef, new Ref$FloatRef()));
        return array;
    }

    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? o.H(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getBidiRunDirection(paragraphInfo.toLocalIndex(offset));
    }

    public final Rect getBoundingBox(int offset) {
        requireIndexInRange(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getBoundingBox(paragraphInfo.toLocalIndex(offset)));
    }

    public final Rect getCursorRect(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? o.H(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getCursorRect(paragraphInfo.toLocalIndex(offset)));
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? o.H(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getHorizontalPosition(paragraphInfo.toLocalIndex(offset), usePrimaryDirection);
    }

    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) v.K0(this.paragraphInfoList);
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLastBaseline());
    }

    public final float getLineBaseline(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBaseline(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineBottom(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBottom(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineEnd(paragraphInfo.toLocalLineIndex(lineIndex), visibleEnd));
    }

    public final int getLineForOffset(int offset) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset >= getAnnotatedString().length() ? o.H(this.paragraphInfoList) : offset < 0 ? 0 : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForOffset(paragraphInfo.toLocalIndex(offset)));
    }

    public final int getLineForVerticalPosition(float vertical) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, vertical));
        return paragraphInfo.getLength() == 0 ? paragraphInfo.getStartLineIndex() : paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForVerticalPosition(paragraphInfo.toLocalYPosition(vertical)));
    }

    public final float getLineHeight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineHeight(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineLeft(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineLeft(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineRight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineRight(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final int getLineStart(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineStart(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineTop(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineTop(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineWidth(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineWidth(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMinIntrinsicWidth();
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m6172getOffsetForPositionk4lQ0M(long position) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Float.intBitsToFloat((int) (4294967295L & position))));
        return paragraphInfo.getLength() == 0 ? paragraphInfo.getStartIndex() : paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().mo6127getOffsetForPositionk4lQ0M(paragraphInfo.m6187toLocalMKHz9U(position)));
    }

    public final ResolvedTextDirection getParagraphDirection(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? o.H(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getParagraphDirection(paragraphInfo.toLocalIndex(offset));
    }

    public final List<ParagraphInfo> getParagraphInfoList$ui_text() {
        return this.paragraphInfoList;
    }

    public final Path getPathForRange(final int start, final int end) {
        if (start < 0 || start > end || end > getAnnotatedString().getText().length()) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(start, "Start(", end, ") or End(", ") is out of range [0..");
            sbS.append(getAnnotatedString().getText().length());
            sbS.append("), or start > end!");
            InlineClassHelperKt.throwIllegalArgumentException(sbS.toString());
        }
        if (start == end) {
            return AndroidPath_androidKt.Path();
        }
        final Path Path = AndroidPath_androidKt.Path();
        MultiParagraphKt.m6178findParagraphsByRangeSbBc2M(this.paragraphInfoList, TextRangeKt.TextRange(start, end), new k() { // from class: androidx.compose.ui.text.b
            @Override // S7.k
            public final Object invoke(Object obj) {
                return MultiParagraph.getPathForRange$lambda$11(Path, start, end, (ParagraphInfo) obj);
            }
        });
        return Path;
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    /* renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m6173getRangeForRect86BmAI(Rect rect, int granularity, TextInclusionStrategy inclusionStrategy) {
        TextRange.Companion companion;
        TextRange.Companion companion2;
        int iFindParagraphByY = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getTop());
        if (this.paragraphInfoList.get(iFindParagraphByY).getBottom() >= rect.getBottom() || iFindParagraphByY == o.H(this.paragraphInfoList)) {
            ParagraphInfo paragraphInfo = this.paragraphInfoList.get(iFindParagraphByY);
            return ParagraphInfo.m6185toGlobalxdX6G0$default(paragraphInfo, paragraphInfo.getParagraph().mo6129getRangeForRect86BmAI(paragraphInfo.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
        }
        int iFindParagraphByY2 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getBottom());
        long jM6316getZerod9O1mEE = TextRange.INSTANCE.m6316getZerod9O1mEE();
        while (true) {
            companion = TextRange.INSTANCE;
            if (!TextRange.m6304equalsimpl0(jM6316getZerod9O1mEE, companion.m6316getZerod9O1mEE()) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo2 = this.paragraphInfoList.get(iFindParagraphByY);
            jM6316getZerod9O1mEE = ParagraphInfo.m6185toGlobalxdX6G0$default(paragraphInfo2, paragraphInfo2.getParagraph().mo6129getRangeForRect86BmAI(paragraphInfo2.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            iFindParagraphByY++;
        }
        if (TextRange.m6304equalsimpl0(jM6316getZerod9O1mEE, companion.m6316getZerod9O1mEE())) {
            return companion.m6316getZerod9O1mEE();
        }
        long jM6316getZerod9O1mEE2 = companion.m6316getZerod9O1mEE();
        while (true) {
            companion2 = TextRange.INSTANCE;
            if (!TextRange.m6304equalsimpl0(jM6316getZerod9O1mEE2, companion2.m6316getZerod9O1mEE()) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo3 = this.paragraphInfoList.get(iFindParagraphByY2);
            jM6316getZerod9O1mEE2 = ParagraphInfo.m6185toGlobalxdX6G0$default(paragraphInfo3, paragraphInfo3.getParagraph().mo6129getRangeForRect86BmAI(paragraphInfo3.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            iFindParagraphByY2--;
        }
        return TextRange.m6304equalsimpl0(jM6316getZerod9O1mEE2, companion2.m6316getZerod9O1mEE()) ? jM6316getZerod9O1mEE : TextRangeKt.TextRange(TextRange.m6311getStartimpl(jM6316getZerod9O1mEE), TextRange.m6306getEndimpl(jM6316getZerod9O1mEE2));
    }

    public final float getWidth() {
        return this.width;
    }

    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m6174getWordBoundaryjx7JFs(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? o.H(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.m6186toGlobalxdX6G0(paragraphInfo.getParagraph().mo6130getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(offset)), false);
    }

    public final boolean isLineEllipsized(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        return this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex)).getParagraph().isLineEllipsized(lineIndex);
    }

    /* renamed from: paint-LG529CI, reason: not valid java name */
    public final void m6175paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = list.get(i);
            paragraphInfo.getParagraph().mo6131paintLG529CI(canvas, color, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    @C7.c
    /* renamed from: paint-RPmYEkk, reason: not valid java name */
    public final /* synthetic */ void m6176paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration decoration) {
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = list.get(i);
            Paragraph.m6179paintLG529CI$default(paragraphInfo.getParagraph(), canvas, color, shadow, decoration, null, 0, 48, null);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m6177painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        AndroidMultiParagraphDraw_androidKt.m6564drawMultiParagraph7AXcY_I(this, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
    }

    @C7.c
    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List list, int i, boolean z10, e eVar) {
        this(annotatedString, textStyle, j5, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, z10);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i, int i6, e eVar) {
        this(multiParagraphIntrinsics, j5, i, i6);
    }

    @C7.c
    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i, boolean z10, e eVar) {
        this(multiParagraphIntrinsics, j5, i, z10);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i, int i6) {
        boolean z10;
        int iM6796getMaxHeightimpl;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = i;
        if (Constraints.m6799getMinWidthimpl(j5) != 0 || Constraints.m6798getMinHeightimpl(j5) != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        List<ParagraphIntrinsicInfo> infoList$ui_text = multiParagraphIntrinsics.getInfoList$ui_text();
        int size = infoList$ui_text.size();
        int i10 = 0;
        float f = 0.0f;
        int i11 = 0;
        while (i11 < size) {
            ParagraphIntrinsicInfo paragraphIntrinsicInfo = infoList$ui_text.get(i11);
            ParagraphIntrinsics intrinsics = paragraphIntrinsicInfo.getIntrinsics();
            int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
            if (Constraints.m6792getHasBoundedHeightimpl(j5)) {
                iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5) - ParagraphKt.ceilToInt(f);
                if (iM6796getMaxHeightimpl < 0) {
                    iM6796getMaxHeightimpl = 0;
                }
            } else {
                iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
            }
            Paragraph paragraphM6194ParagraphczeNHc = ParagraphKt.m6194ParagraphczeNHc(intrinsics, ConstraintsKt.Constraints$default(0, iM6797getMaxWidthimpl, 0, iM6796getMaxHeightimpl, 5, null), this.maxLines - i10, i6);
            float height = paragraphM6194ParagraphczeNHc.getHeight() + f;
            int lineCount = paragraphM6194ParagraphczeNHc.getLineCount() + i10;
            arrayList.add(new ParagraphInfo(paragraphM6194ParagraphczeNHc, paragraphIntrinsicInfo.getStartIndex(), paragraphIntrinsicInfo.getEndIndex(), i10, lineCount, f, height));
            if (paragraphM6194ParagraphczeNHc.getDidExceedMaxLines() || (lineCount == this.maxLines && i11 != o.H(this.intrinsics.getInfoList$ui_text()))) {
                z10 = true;
                i10 = lineCount;
                f = height;
                break;
            } else {
                i11++;
                i10 = lineCount;
                f = height;
            }
        }
        z10 = false;
        this.height = f;
        this.lineCount = i10;
        this.didExceedMaxLines = z10;
        this.paragraphInfoList = arrayList;
        this.width = Constraints.m6797getMaxWidthimpl(j5);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i12 = 0; i12 < size2; i12++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i12);
            List<Rect> placeholderRects = paragraphInfo.getParagraph().getPlaceholderRects();
            ArrayList arrayList3 = new ArrayList(placeholderRects.size());
            int size3 = placeholderRects.size();
            for (int i13 = 0; i13 < size3; i13++) {
                Rect rect = placeholderRects.get(i13);
                arrayList3.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
            }
            A.e0(arrayList3, arrayList2);
        }
        if (arrayList2.size() < this.intrinsics.getPlaceholders().size()) {
            int size4 = this.intrinsics.getPlaceholders().size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size4);
            for (int i14 = 0; i14 < size4; i14++) {
                arrayList4.add(null);
            }
            arrayList2 = v.Q0(arrayList4, arrayList2);
        }
        this.placeholderRects = arrayList2;
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i, int i6, int i10, e eVar) {
        this(multiParagraphIntrinsics, j5, (i10 & 4) != 0 ? Integer.MAX_VALUE : i, (i10 & 8) != 0 ? TextOverflow.INSTANCE.m6779getClipgIe3tQ8() : i6, (e) null);
    }

    public MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List list, int i, boolean z10, int i6, e eVar) {
        this(annotatedString, textStyle, f, density, resolver, (List<AnnotatedString.Range<Placeholder>>) ((i6 & 32) != 0 ? EmptyList.f4893a : list), (i6 & 64) != 0 ? Integer.MAX_VALUE : i, (i6 & 128) != 0 ? false : z10);
    }

    public MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List list, int i, int i6, int i10, e eVar) {
        this(annotatedString, textStyle, j5, density, resolver, (i10 & 32) != 0 ? EmptyList.f4893a : list, (i10 & 64) != 0 ? Integer.MAX_VALUE : i, (i10 & 128) != 0 ? TextOverflow.INSTANCE.m6779getClipgIe3tQ8() : i6, (e) null);
    }

    public MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List list, int i, boolean z10, int i6, e eVar) {
        this(annotatedString, textStyle, j5, density, resolver, (i6 & 32) != 0 ? EmptyList.f4893a : list, (i6 & 64) != 0 ? Integer.MAX_VALUE : i, (i6 & 128) != 0 ? false : z10, (e) null);
    }

    public MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z10, float f, Density density, Font.ResourceLoader resourceLoader, int i6, e eVar) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) ((i6 & 4) != 0 ? EmptyList.f4893a : list), (i6 & 8) != 0 ? Integer.MAX_VALUE : i, (i6 & 16) != 0 ? false : z10, f, density, resourceLoader);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i, boolean z10, int i6, e eVar) {
        this(multiParagraphIntrinsics, j5, (i6 & 4) != 0 ? Integer.MAX_VALUE : i, (i6 & 8) != 0 ? false : z10, (e) null);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i, boolean z10) {
        this(multiParagraphIntrinsics, j5, i, z10 ? TextOverflow.INSTANCE.m6780getEllipsisgIe3tQ8() : TextOverflow.INSTANCE.m6779getClipgIe3tQ8(), (e) null);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z10, float f, int i6, e eVar) {
        this(multiParagraphIntrinsics, (i6 & 2) != 0 ? Integer.MAX_VALUE : i, (i6 & 4) != 0 ? false : z10, f);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @C7.c
    public MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z10, float f) {
        long jConstraints$default = ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null);
        TextOverflow.Companion companion = TextOverflow.INSTANCE;
        this(multiParagraphIntrinsics, jConstraints$default, i, z10 ? companion.m6780getEllipsisgIe3tQ8() : companion.m6779getClipgIe3tQ8(), (e) null);
    }

    @C7.c
    public MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z10, float f, Density density, Font.ResourceLoader resourceLoader) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
        TextOverflow.Companion companion = TextOverflow.INSTANCE;
        this(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z10 ? companion.m6780getEllipsisgIe3tQ8() : companion.m6779getClipgIe3tQ8(), (e) null);
    }

    @C7.c
    public MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z10) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver);
        TextOverflow.Companion companion = TextOverflow.INSTANCE;
        this(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z10 ? companion.m6780getEllipsisgIe3tQ8() : companion.m6779getClipgIe3tQ8(), (e) null);
    }

    private MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z10) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver);
        TextOverflow.Companion companion = TextOverflow.INSTANCE;
        this(multiParagraphIntrinsics, j5, i, z10 ? companion.m6780getEllipsisgIe3tQ8() : companion.m6779getClipgIe3tQ8(), (e) null);
    }

    private MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, int i, int i6) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), j5, i, i6, (e) null);
    }
}
