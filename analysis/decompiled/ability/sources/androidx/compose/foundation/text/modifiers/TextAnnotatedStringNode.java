package androidx.compose.foundation.text.modifiers;

import C7.r;
import S7.a;
import S7.k;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u007fBÇ\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u0016\u0012\u001e\b\u0002\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b'\u0010(JV\u0010,\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b*\u0010+Ja\u0010-\u001a\u00020\u00112\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u001c\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b-\u0010.J-\u00103\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u00020\rH\u0000¢\u0006\u0004\b5\u00106J\u0013\u00109\u001a\u00020\r*\u000208H\u0016¢\u0006\u0004\b9\u0010:J(\u0010D\u001a\u00020A2\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ&\u0010F\u001a\u00020A*\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?H\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010CJ%\u0010K\u001a\u00020\u00132\u0006\u0010H\u001a\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0013¢\u0006\u0004\bK\u0010LJ#\u0010M\u001a\u00020\u0013*\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0013H\u0016¢\u0006\u0004\bM\u0010LJ%\u0010O\u001a\u00020\u00132\u0006\u0010H\u001a\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0013¢\u0006\u0004\bO\u0010LJ#\u0010P\u001a\u00020\u0013*\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0013H\u0016¢\u0006\u0004\bP\u0010LJ%\u0010Q\u001a\u00020\u00132\u0006\u0010H\u001a\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0013¢\u0006\u0004\bQ\u0010LJ#\u0010R\u001a\u00020\u0013*\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0013H\u0016¢\u0006\u0004\bR\u0010LJ%\u0010S\u001a\u00020\u00132\u0006\u0010H\u001a\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0013¢\u0006\u0004\bS\u0010LJ#\u0010T\u001a\u00020\u0013*\u00020G2\u0006\u0010>\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0013H\u0016¢\u0006\u0004\bT\u0010LJ\u0015\u0010W\u001a\u00020\r2\u0006\u0010V\u001a\u00020U¢\u0006\u0004\bW\u0010XJ\u0013\u0010Y\u001a\u00020\r*\u00020UH\u0016¢\u0006\u0004\bY\u0010XJ\u0017\u0010]\u001a\u00020\\2\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\u0005H\u0002¢\u0006\u0004\b`\u0010(J\u000f\u0010a\u001a\u00020\rH\u0002¢\u0006\u0004\ba\u00106R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010bR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010cR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010dR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0010\u0010fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010gR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010fR\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010fR$\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010hR,\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010eR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010iR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010jR$\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010eR*\u0010m\u001a\u0010\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u0013\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bm\u0010n\u0012\u0004\bo\u00106R\u0018\u0010p\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR*\u0010s\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0r\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010eR$\u0010t\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0014\u0010|\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0014\u0010~\u001a\u00020\\8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010}\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0080\u0001"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "LC7/r;", "onTextLayout", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "", "softWrap", "", "maxLines", "minLines", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/geometry/Rect;", "onPlaceholderLayout", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "selectionController", "Landroidx/compose/ui/graphics/ColorProducer;", "overrideColor", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "onShowTranslation", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;LS7/k;IZIILjava/util/List;LS7/k;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;LS7/k;Lkotlin/jvm/internal/e;)V", TypedValues.Custom.S_COLOR, "updateDraw", "(Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/ui/text/TextStyle;)Z", "updateText$foundation_release", "(Landroidx/compose/ui/text/AnnotatedString;)Z", "updateText", "updateLayoutRelatedArgs-MPT68mk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateLayoutRelatedArgs", "updateCallbacks", "(LS7/k;LS7/k;Landroidx/compose/foundation/text/modifiers/SelectionController;LS7/k;)Z", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "doInvalidations", "(ZZZZ)V", "clearSubstitution$foundation_release", "()V", "clearSubstitution", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Landroidx/compose/ui/layout/MeasureScope;", "measureScope", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measureNonExtension", "measure-3p2s80s", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidthNonExtension", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "minIntrinsicWidth", "width", "minIntrinsicHeightNonExtension", "minIntrinsicHeight", "maxIntrinsicWidthNonExtension", "maxIntrinsicWidth", "maxIntrinsicHeightNonExtension", "maxIntrinsicHeight", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "contentDrawScope", "drawNonExtension", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "draw", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "getLayoutCache", "(Landroidx/compose/ui/unit/Density;)Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "updatedText", "setSubstitution", "invalidateForTranslate", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "LS7/k;", "I", "Z", "Ljava/util/List;", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/ui/graphics/ColorProducer;", "", "Landroidx/compose/ui/layout/AlignmentLine;", "baselineCache", "Ljava/util/Map;", "getBaselineCache$annotations", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "", "semanticsTextLayoutResult", "textSubstitution", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "getTextSubstitution$foundation_release", "()Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "setTextSubstitution$foundation_release", "(Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;)V", "getShouldClearDescendantSemantics", "()Z", "shouldClearDescendantSemantics", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "layoutCache", "TextSubstitutionValue", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private MultiParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private k onPlaceholderLayout;
    private k onShowTranslation;
    private k onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private SelectionController selectionController;
    private k semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;
    private TextSubstitutionValue textSubstitution;

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, k kVar, int i, boolean z10, int i6, int i10, List list, k kVar2, SelectionController selectionController, ColorProducer colorProducer, k kVar3, e eVar) {
        this(annotatedString, textStyle, resolver, kVar, i, z10, i6, i10, list, kVar2, selectionController, colorProducer, kVar3);
    }

    private static /* synthetic */ void getBaselineCache$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        kotlin.jvm.internal.k.c(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics(this);
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setSubstitution(AnnotatedString updatedText) {
        r rVar;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            TextSubstitutionValue textSubstitutionValue2 = new TextSubstitutionValue(this.text, updatedText, false, null, 12, null);
            MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
            multiParagraphLayoutCache.setDensity$foundation_release(getLayoutCache().getDensity());
            textSubstitutionValue2.setLayoutCache(multiParagraphLayoutCache);
            this.textSubstitution = textSubstitutionValue2;
            return true;
        }
        if (kotlin.jvm.internal.k.b(updatedText, textSubstitutionValue.getSubstitution())) {
            return false;
        }
        textSubstitutionValue.setSubstitution(updatedText);
        MultiParagraphLayoutCache layoutCache = textSubstitutionValue.getLayoutCache();
        if (layoutCache != null) {
            layoutCache.m1358updateZNqEYIc(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
            rVar = r.f317a;
        } else {
            rVar = null;
        }
        return rVar != null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        k kVar = this.semanticsTextLayoutResult;
        if (kVar == null) {
            kVar = new k() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.1
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x00b9  */
                @Override // S7.k
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<androidx.compose.ui.text.TextLayoutResult> r38) {
                    /*
                        r37 = this;
                        r0 = r37
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.this
                        androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.access$getLayoutCache(r1)
                        androidx.compose.ui.text.TextLayoutResult r2 = r1.getLayoutCache()
                        if (r2 == 0) goto Lb9
                        androidx.compose.ui.text.TextLayoutInput r3 = new androidx.compose.ui.text.TextLayoutInput
                        androidx.compose.ui.text.TextLayoutInput r1 = r2.getLayoutInput()
                        androidx.compose.ui.text.AnnotatedString r4 = r1.getText()
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.this
                        androidx.compose.ui.text.TextStyle r5 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.access$getStyle$p(r1)
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r0 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.this
                        androidx.compose.ui.graphics.ColorProducer r0 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.access$getOverrideColor$p(r0)
                        if (r0 == 0) goto L2c
                        long r0 = r0.mo1813invoke0d7_KjU()
                    L2a:
                        r6 = r0
                        goto L33
                    L2c:
                        androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.INSTANCE
                        long r0 = r0.m4175getUnspecified0d7_KjU()
                        goto L2a
                    L33:
                        r35 = 16777214(0xfffffe, float:2.3509884E-38)
                        r36 = 0
                        r8 = 0
                        r10 = 0
                        r11 = 0
                        r12 = 0
                        r13 = 0
                        r14 = 0
                        r15 = 0
                        r17 = 0
                        r18 = 0
                        r19 = 0
                        r20 = 0
                        r22 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 0
                        r27 = 0
                        r29 = 0
                        r30 = 0
                        r31 = 0
                        r32 = 0
                        r33 = 0
                        r34 = 0
                        androidx.compose.ui.text.TextStyle r5 = androidx.compose.ui.text.TextStyle.m6331mergedA7vx0o$default(r5, r6, r8, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r33, r34, r35, r36)
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        java.util.List r6 = r0.getPlaceholders()
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        int r7 = r0.getMaxLines()
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        boolean r8 = r0.getSoftWrap()
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        int r9 = r0.getOverflow()
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        androidx.compose.ui.unit.Density r10 = r0.getDensity()
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        androidx.compose.ui.unit.LayoutDirection r11 = r0.getLayoutDirection()
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        androidx.compose.ui.text.font.FontFamily$Resolver r12 = r0.getFontFamilyResolver()
                        androidx.compose.ui.text.TextLayoutInput r0 = r2.getLayoutInput()
                        long r13 = r0.getConstraints()
                        r15 = 0
                        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15)
                        r6 = 2
                        r7 = 0
                        r4 = 0
                        androidx.compose.ui.text.TextLayoutResult r0 = androidx.compose.ui.text.TextLayoutResult.m6279copyO0kMr_c$default(r2, r3, r4, r6, r7)
                        if (r0 == 0) goto Lb9
                        r1 = r38
                        r1.add(r0)
                        goto Lba
                    Lb9:
                        r0 = 0
                    Lba:
                        if (r0 == 0) goto Lbe
                        r0 = 1
                        goto Lbf
                    Lbe:
                        r0 = 0
                    Lbf:
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.AnonymousClass1.invoke(java.util.List):java.lang.Boolean");
                }
            };
            this.semanticsTextLayoutResult = kVar;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, this.text);
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null) {
            SemanticsPropertiesKt.setTextSubstitution(semanticsPropertyReceiver, textSubstitutionValue.getSubstitution());
            SemanticsPropertiesKt.setShowingTextSubstitution(semanticsPropertyReceiver, textSubstitutionValue.isShowingSubstitution());
        }
        SemanticsPropertiesKt.setTextSubstitution$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.2
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(AnnotatedString annotatedString) {
                TextAnnotatedStringNode.this.setSubstitution(annotatedString);
                TextAnnotatedStringNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.showTextSubstitution$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.3
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Boolean) obj).booleanValue());
            }

            public final Boolean invoke(boolean z10) {
                if (TextAnnotatedStringNode.this.getTextSubstitution() == null) {
                    return Boolean.FALSE;
                }
                k kVar2 = TextAnnotatedStringNode.this.onShowTranslation;
                if (kVar2 != null) {
                    TextSubstitutionValue textSubstitution = TextAnnotatedStringNode.this.getTextSubstitution();
                    kotlin.jvm.internal.k.c(textSubstitution);
                    kVar2.invoke(textSubstitution);
                }
                TextSubstitutionValue textSubstitution2 = TextAnnotatedStringNode.this.getTextSubstitution();
                if (textSubstitution2 != null) {
                    textSubstitution2.setShowingSubstitution(z10);
                }
                TextAnnotatedStringNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.clearTextSubstitution$default(semanticsPropertyReceiver, null, new a() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.4
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                TextAnnotatedStringNode.this.clearSubstitution$foundation_release();
                TextAnnotatedStringNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, kVar, 1, null);
    }

    public final void clearSubstitution$foundation_release() {
        this.textSubstitution = null;
    }

    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged, boolean callbacksChanged) {
        if (textChanged || layoutChanged || callbacksChanged) {
            getLayoutCache().m1358updateZNqEYIc(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
        }
        if (getIsAttached()) {
            if (textChanged || (drawChanged && this.semanticsTextLayoutResult != null)) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            if (textChanged || layoutChanged || callbacksChanged) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }
            if (drawChanged) {
                DrawModifierNodeKt.invalidateDraw(this);
            }
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        if (!getIsAttached()) {
            return;
        }
        SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            selectionController.draw(contentDrawScope);
        }
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        TextLayoutResult textLayoutResult = getLayoutCache(contentDrawScope).getTextLayoutResult();
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        boolean z10 = true;
        boolean z11 = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m6770equalsimpl0(this.overflow, TextOverflow.INSTANCE.m6783getVisiblegIe3tQ8());
        if (z11) {
            Rect rectM3935Recttz77jQw = RectKt.m3935Recttz77jQw(Offset.INSTANCE.m3911getZeroF1C5BW0(), SizeKt.Size(IntSize.m7015getWidthimpl(textLayoutResult.getSize()), IntSize.m7014getHeightimpl(textLayoutResult.getSize())));
            canvas.save();
            Canvas.m4112clipRectmtrdDE$default(canvas, rectM3935Recttz77jQw, 0, 2, null);
        }
        try {
            TextDecoration textDecoration = this.style.getTextDecoration();
            if (textDecoration == null) {
                textDecoration = TextDecoration.INSTANCE.getNone();
            }
            TextDecoration textDecoration2 = textDecoration;
            Shadow shadow = this.style.getShadow();
            if (shadow == null) {
                shadow = Shadow.INSTANCE.getNone();
            }
            Shadow shadow2 = shadow;
            DrawStyle drawStyle = this.style.getDrawStyle();
            if (drawStyle == null) {
                drawStyle = Fill.INSTANCE;
            }
            DrawStyle drawStyle2 = drawStyle;
            Brush brush = this.style.getBrush();
            if (brush != null) {
                MultiParagraph.m6170painthn5TExg$default(multiParagraph, canvas, brush, this.style.getAlpha(), shadow2, textDecoration2, drawStyle2, 0, 64, null);
            } else {
                ColorProducer colorProducer = this.overrideColor;
                long jMo1813invoke0d7_KjU = colorProducer != null ? colorProducer.mo1813invoke0d7_KjU() : Color.INSTANCE.m4175getUnspecified0d7_KjU();
                if (jMo1813invoke0d7_KjU == 16) {
                    jMo1813invoke0d7_KjU = this.style.m6341getColor0d7_KjU() != 16 ? this.style.m6341getColor0d7_KjU() : Color.INSTANCE.m4165getBlack0d7_KjU();
                }
                multiParagraph.m6175paintLG529CI(canvas, (32 & 2) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : jMo1813invoke0d7_KjU, (32 & 4) != 0 ? null : shadow2, (32 & 8) != 0 ? null : textDecoration2, (32 & 16) == 0 ? drawStyle2 : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m4709getDefaultBlendMode0nO6VwU() : 0);
            }
            if (z11) {
                canvas.restore();
            }
            TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
            if (!((textSubstitutionValue == null || !textSubstitutionValue.isShowingSubstitution()) ? TextAnnotatedStringNodeKt.hasLinks(this.text) : false)) {
                List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
                if (list != null && !list.isEmpty()) {
                    z10 = false;
                }
                if (z10) {
                    return;
                }
            }
            contentDrawScope.drawContent();
        } finally {
        }
    }

    public final void drawNonExtension(ContentDrawScope contentDrawScope) {
        draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* renamed from: getShouldClearDescendantSemantics */
    public boolean getIsClearingSemantics() {
        return true;
    }

    /* renamed from: getTextSubstitution$foundation_release, reason: from getter */
    public final TextSubstitutionValue getTextSubstitution() {
        return this.textSubstitution;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return maxIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).maxIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return maxIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        MultiParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
        boolean zM1357layoutWithConstraintsK40F9xA = layoutCache.m1357layoutWithConstraintsK40F9xA(j5, measureScope.getLayoutDirection());
        TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
        if (zM1357layoutWithConstraintsK40F9xA) {
            LayoutModifierNodeKt.invalidateLayer(this);
            k kVar = this.onTextLayout;
            if (kVar != null) {
                kVar.invoke(textLayoutResult);
            }
            SelectionController selectionController = this.selectionController;
            if (selectionController != null) {
                selectionController.updateTextLayout(textLayoutResult);
            }
            Map<AlignmentLine, Integer> linkedHashMap = this.baselineCache;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>(2);
            }
            linkedHashMap.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(textLayoutResult.getFirstBaseline())));
            linkedHashMap.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(textLayoutResult.getLastBaseline())));
            this.baselineCache = linkedHashMap;
        }
        k kVar2 = this.onPlaceholderLayout;
        if (kVar2 != null) {
            kVar2.invoke(textLayoutResult.getPlaceholderRects());
        }
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(Constraints.INSTANCE.m6806fitPrioritizingWidthZbe2FdA(IntSize.m7015getWidthimpl(textLayoutResult.getSize()), IntSize.m7015getWidthimpl(textLayoutResult.getSize()), IntSize.m7014getHeightimpl(textLayoutResult.getSize()), IntSize.m7014getHeightimpl(textLayoutResult.getSize())));
        int iM7015getWidthimpl = IntSize.m7015getWidthimpl(textLayoutResult.getSize());
        int iM7014getHeightimpl = IntSize.m7014getHeightimpl(textLayoutResult.getSize());
        Map<AlignmentLine, Integer> map = this.baselineCache;
        kotlin.jvm.internal.k.c(map);
        return measureScope.layout(iM7015getWidthimpl, iM7014getHeightimpl, map, new k() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$measure$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        });
    }

    /* renamed from: measureNonExtension-3p2s80s, reason: not valid java name */
    public final MeasureResult m1369measureNonExtension3p2s80s(MeasureScope measureScope, Measurable measurable, long constraints) {
        return mo89measure3p2s80s(measureScope, measurable, constraints);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return minIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).minIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return minIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    public final void setTextSubstitution$foundation_release(TextSubstitutionValue textSubstitutionValue) {
        this.textSubstitution = textSubstitutionValue;
    }

    public final boolean updateCallbacks(k onTextLayout, k onPlaceholderLayout, SelectionController selectionController, k onShowTranslation) {
        boolean z10;
        if (this.onTextLayout != onTextLayout) {
            this.onTextLayout = onTextLayout;
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.onPlaceholderLayout != onPlaceholderLayout) {
            this.onPlaceholderLayout = onPlaceholderLayout;
            z10 = true;
        }
        if (!kotlin.jvm.internal.k.b(this.selectionController, selectionController)) {
            this.selectionController = selectionController;
            z10 = true;
        }
        if (this.onShowTranslation == onShowTranslation) {
            return z10;
        }
        this.onShowTranslation = onShowTranslation;
        return true;
    }

    public final boolean updateDraw(ColorProducer color, TextStyle style) {
        boolean zB = kotlin.jvm.internal.k.b(color, this.overrideColor);
        this.overrideColor = color;
        return (zB && style.hasSameDrawAffectingAttributes(this.style)) ? false : true;
    }

    /* renamed from: updateLayoutRelatedArgs-MPT68mk, reason: not valid java name */
    public final boolean m1370updateLayoutRelatedArgsMPT68mk(TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int minLines, int maxLines, boolean softWrap, FontFamily.Resolver fontFamilyResolver, int overflow) {
        boolean z10 = !this.style.hasSameLayoutAffectingAttributes(style);
        this.style = style;
        if (!kotlin.jvm.internal.k.b(this.placeholders, placeholders)) {
            this.placeholders = placeholders;
            z10 = true;
        }
        if (this.minLines != minLines) {
            this.minLines = minLines;
            z10 = true;
        }
        if (this.maxLines != maxLines) {
            this.maxLines = maxLines;
            z10 = true;
        }
        if (this.softWrap != softWrap) {
            this.softWrap = softWrap;
            z10 = true;
        }
        if (!kotlin.jvm.internal.k.b(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            z10 = true;
        }
        if (TextOverflow.m6770equalsimpl0(this.overflow, overflow)) {
            return z10;
        }
        this.overflow = overflow;
        return true;
    }

    public final boolean updateText$foundation_release(AnnotatedString text) {
        boolean zB = kotlin.jvm.internal.k.b(this.text.getText(), text.getText());
        boolean z10 = (zB && kotlin.jvm.internal.k.b(this.text.getSpanStyles(), text.getSpanStyles()) && kotlin.jvm.internal.k.b(this.text.getParagraphStyles(), text.getParagraphStyles()) && this.text.hasEqualAnnotations(text)) ? false : true;
        if (z10) {
            this.text = text;
        }
        if (!zB) {
            clearSubstitution$foundation_release();
        }
        return z10;
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, k kVar, int i, boolean z10, int i6, int i10, List list, k kVar2, SelectionController selectionController, ColorProducer colorProducer, k kVar3, int i11, e eVar) {
        this(annotatedString, textStyle, resolver, (i11 & 8) != 0 ? null : kVar, (i11 & 16) != 0 ? TextOverflow.INSTANCE.m6779getClipgIe3tQ8() : i, (i11 & 32) != 0 ? true : z10, (i11 & 64) != 0 ? Integer.MAX_VALUE : i6, (i11 & 128) != 0 ? 1 : i10, (i11 & 256) != 0 ? null : list, (i11 & 512) != 0 ? null : kVar2, (i11 & 1024) != 0 ? null : selectionController, (i11 & 2048) != 0 ? null : colorProducer, (i11 & 4096) != 0 ? null : kVar3, null);
    }

    private TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, k kVar, int i, boolean z10, int i6, int i10, List<AnnotatedString.Range<Placeholder>> list, k kVar2, SelectionController selectionController, ColorProducer colorProducer, k kVar3) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.onTextLayout = kVar;
        this.overflow = i;
        this.softWrap = z10;
        this.maxLines = i6;
        this.minLines = i10;
        this.placeholders = list;
        this.onPlaceholderLayout = kVar2;
        this.selectionController = selectionController;
        this.overrideColor = colorProducer;
        this.onShowTranslation = kVar3;
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "", "original", "Landroidx/compose/ui/text/AnnotatedString;", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;ZLandroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "getOriginal", "()Landroidx/compose/ui/text/AnnotatedString;", "getSubstitution", "setSubstitution", "(Landroidx/compose/ui/text/AnnotatedString;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private MultiParagraphLayoutCache layoutCache;
        private final AnnotatedString original;
        private AnnotatedString substitution;

        public TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z10, MultiParagraphLayoutCache multiParagraphLayoutCache) {
            this.original = annotatedString;
            this.substitution = annotatedString2;
            this.isShowingSubstitution = z10;
            this.layoutCache = multiParagraphLayoutCache;
        }

        public static /* synthetic */ TextSubstitutionValue copy$default(TextSubstitutionValue textSubstitutionValue, AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z10, MultiParagraphLayoutCache multiParagraphLayoutCache, int i, Object obj) {
            if ((i & 1) != 0) {
                annotatedString = textSubstitutionValue.original;
            }
            if ((i & 2) != 0) {
                annotatedString2 = textSubstitutionValue.substitution;
            }
            if ((i & 4) != 0) {
                z10 = textSubstitutionValue.isShowingSubstitution;
            }
            if ((i & 8) != 0) {
                multiParagraphLayoutCache = textSubstitutionValue.layoutCache;
            }
            return textSubstitutionValue.copy(annotatedString, annotatedString2, z10, multiParagraphLayoutCache);
        }

        /* renamed from: component1, reason: from getter */
        public final AnnotatedString getOriginal() {
            return this.original;
        }

        /* renamed from: component2, reason: from getter */
        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        /* renamed from: component4, reason: from getter */
        public final MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final TextSubstitutionValue copy(AnnotatedString original, AnnotatedString substitution, boolean isShowingSubstitution, MultiParagraphLayoutCache layoutCache) {
            return new TextSubstitutionValue(original, substitution, isShowingSubstitution, layoutCache);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) other;
            return kotlin.jvm.internal.k.b(this.original, textSubstitutionValue.original) && kotlin.jvm.internal.k.b(this.substitution, textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && kotlin.jvm.internal.k.b(this.layoutCache, textSubstitutionValue.layoutCache);
        }

        public final MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final AnnotatedString getOriginal() {
            return this.original;
        }

        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        public int hashCode() {
            int iD = androidx.appfunctions.metadata.a.d((this.substitution.hashCode() + (this.original.hashCode() * 31)) * 31, 31, this.isShowingSubstitution);
            MultiParagraphLayoutCache multiParagraphLayoutCache = this.layoutCache;
            return iD + (multiParagraphLayoutCache == null ? 0 : multiParagraphLayoutCache.hashCode());
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(MultiParagraphLayoutCache multiParagraphLayoutCache) {
            this.layoutCache = multiParagraphLayoutCache;
        }

        public final void setShowingSubstitution(boolean z10) {
            this.isShowingSubstitution = z10;
        }

        public final void setSubstitution(AnnotatedString annotatedString) {
            this.substitution = annotatedString;
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + ((Object) this.original) + ", substitution=" + ((Object) this.substitution) + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ')';
        }

        public /* synthetic */ TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z10, MultiParagraphLayoutCache multiParagraphLayoutCache, int i, e eVar) {
            this(annotatedString, annotatedString2, (i & 4) != 0 ? false : z10, (i & 8) != 0 ? null : multiParagraphLayoutCache);
        }
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null && textSubstitutionValue.isShowingSubstitution() && (layoutCache = textSubstitutionValue.getLayoutCache()) != null) {
            layoutCache.setDensity$foundation_release(density);
            return layoutCache;
        }
        MultiParagraphLayoutCache layoutCache2 = getLayoutCache();
        layoutCache2.setDensity$foundation_release(density);
        return layoutCache2;
    }
}
