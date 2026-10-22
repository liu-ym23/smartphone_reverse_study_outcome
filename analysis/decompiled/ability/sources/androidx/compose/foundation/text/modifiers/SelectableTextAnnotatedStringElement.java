package androidx.compose.foundation.text.modifiers;

import S7.k;
import androidx.appfunctions.metadata.a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B¯\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014\u0012\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0007HÂ\u0003¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÂ\u0003¢\u0006\u0004\b&\u0010'J\u0016\u0010*\u001a\u00020\rHÂ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020\u000fHÂ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0011HÂ\u0003¢\u0006\u0004\b-\u0010)J\u0010\u0010.\u001a\u00020\u0011HÂ\u0003¢\u0006\u0004\b.\u0010)J\u001e\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014HÂ\u0003¢\u0006\u0004\b/\u00100J&\u00101\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÂ\u0003¢\u0006\u0004\b1\u0010'J\u0012\u00102\u001a\u0004\u0018\u00010\u001aHÂ\u0003¢\u0006\u0004\b2\u00103J\u0012\u00104\u001a\u0004\u0018\u00010\u001cHÂ\u0003¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0002H\u0016¢\u0006\u0004\b9\u0010:J\u001a\u0010=\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010;H\u0096\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0011H\u0016¢\u0006\u0004\b?\u0010)J\u0013\u0010A\u001a\u00020\u000b*\u00020@H\u0016¢\u0006\u0004\bA\u0010BJÁ\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0001ø\u0001\u0001¢\u0006\u0004\bC\u0010DJ\u0010\u0010G\u001a\u00020FHÖ\u0001¢\u0006\u0004\bG\u0010HR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010IR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010JR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010KR\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010LR\u001a\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010MR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010NR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010MR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010MR\"\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010OR*\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010LR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010PR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010Q\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "LC7/r;", "onTextLayout", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "", "softWrap", "", "maxLines", "minLines", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/geometry/Rect;", "onPlaceholderLayout", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "selectionController", "Landroidx/compose/ui/graphics/ColorProducer;", TypedValues.Custom.S_COLOR, AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;LS7/k;IZIILjava/util/List;LS7/k;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/e;)V", "component1", "()Landroidx/compose/ui/text/AnnotatedString;", "component2", "()Landroidx/compose/ui/text/TextStyle;", "component3", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "component4", "()LS7/k;", "component5-gIe3tQ8", "()I", "component5", "component6", "()Z", "component7", "component8", "component9", "()Ljava/util/List;", "component10", "component11", "()Landroidx/compose/foundation/text/modifiers/SelectionController;", "component12", "()Landroidx/compose/ui/graphics/ColorProducer;", "create", "()Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "node", "update", "(Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "copy-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;LS7/k;IZIILjava/util/List;LS7/k;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "copy", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "LS7/k;", "I", "Z", "Ljava/util/List;", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/ui/graphics/ColorProducer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SelectableTextAnnotatedStringElement extends ModifierNodeElement<SelectableTextAnnotatedStringNode> {
    public static final int $stable = 0;
    private final ColorProducer color;
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final k onPlaceholderLayout;
    private final k onTextLayout;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, k kVar, int i, boolean z10, int i6, int i10, List list, k kVar2, SelectionController selectionController, ColorProducer colorProducer, e eVar) {
        this(annotatedString, textStyle, resolver, kVar, i, z10, i6, i10, list, kVar2, selectionController, colorProducer);
    }

    /* renamed from: component1, reason: from getter */
    private final AnnotatedString getText() {
        return this.text;
    }

    /* renamed from: component10, reason: from getter */
    private final k getOnPlaceholderLayout() {
        return this.onPlaceholderLayout;
    }

    /* renamed from: component11, reason: from getter */
    private final SelectionController getSelectionController() {
        return this.selectionController;
    }

    /* renamed from: component12, reason: from getter */
    private final ColorProducer getColor() {
        return this.color;
    }

    /* renamed from: component2, reason: from getter */
    private final TextStyle getStyle() {
        return this.style;
    }

    /* renamed from: component3, reason: from getter */
    private final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    /* renamed from: component4, reason: from getter */
    private final k getOnTextLayout() {
        return this.onTextLayout;
    }

    /* renamed from: component5-gIe3tQ8, reason: not valid java name and from getter */
    private final int getOverflow() {
        return this.overflow;
    }

    /* renamed from: component6, reason: from getter */
    private final boolean getSoftWrap() {
        return this.softWrap;
    }

    /* renamed from: component7, reason: from getter */
    private final int getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: component8, reason: from getter */
    private final int getMinLines() {
        return this.minLines;
    }

    private final List<AnnotatedString.Range<Placeholder>> component9() {
        return this.placeholders;
    }

    /* renamed from: copy-VhcvRP8$default, reason: not valid java name */
    public static /* synthetic */ SelectableTextAnnotatedStringElement m1366copyVhcvRP8$default(SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement, AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, k kVar, int i, boolean z10, int i6, int i10, List list, k kVar2, SelectionController selectionController, ColorProducer colorProducer, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            annotatedString = selectableTextAnnotatedStringElement.text;
        }
        if ((i11 & 2) != 0) {
            textStyle = selectableTextAnnotatedStringElement.style;
        }
        if ((i11 & 4) != 0) {
            resolver = selectableTextAnnotatedStringElement.fontFamilyResolver;
        }
        if ((i11 & 8) != 0) {
            kVar = selectableTextAnnotatedStringElement.onTextLayout;
        }
        if ((i11 & 16) != 0) {
            i = selectableTextAnnotatedStringElement.overflow;
        }
        if ((i11 & 32) != 0) {
            z10 = selectableTextAnnotatedStringElement.softWrap;
        }
        if ((i11 & 64) != 0) {
            i6 = selectableTextAnnotatedStringElement.maxLines;
        }
        if ((i11 & 128) != 0) {
            i10 = selectableTextAnnotatedStringElement.minLines;
        }
        if ((i11 & 256) != 0) {
            list = selectableTextAnnotatedStringElement.placeholders;
        }
        if ((i11 & 512) != 0) {
            kVar2 = selectableTextAnnotatedStringElement.onPlaceholderLayout;
        }
        if ((i11 & 1024) != 0) {
            selectionController = selectableTextAnnotatedStringElement.selectionController;
        }
        if ((i11 & 2048) != 0) {
            colorProducer = selectableTextAnnotatedStringElement.color;
        }
        SelectionController selectionController2 = selectionController;
        ColorProducer colorProducer2 = colorProducer;
        List list2 = list;
        k kVar3 = kVar2;
        int i12 = i6;
        int i13 = i10;
        int i14 = i;
        boolean z11 = z10;
        return selectableTextAnnotatedStringElement.m1367copyVhcvRP8(annotatedString, textStyle, resolver, kVar, i14, z11, i12, i13, list2, kVar3, selectionController2, colorProducer2);
    }

    /* renamed from: copy-VhcvRP8, reason: not valid java name */
    public final SelectableTextAnnotatedStringElement m1367copyVhcvRP8(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, k onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders, k onPlaceholderLayout, SelectionController selectionController, ColorProducer color) {
        return new SelectableTextAnnotatedStringElement(text, style, fontFamilyResolver, onTextLayout, overflow, softWrap, maxLines, minLines, placeholders, onPlaceholderLayout, selectionController, color, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) other;
        return kotlin.jvm.internal.k.b(this.color, selectableTextAnnotatedStringElement.color) && kotlin.jvm.internal.k.b(this.text, selectableTextAnnotatedStringElement.text) && kotlin.jvm.internal.k.b(this.style, selectableTextAnnotatedStringElement.style) && kotlin.jvm.internal.k.b(this.placeholders, selectableTextAnnotatedStringElement.placeholders) && kotlin.jvm.internal.k.b(this.fontFamilyResolver, selectableTextAnnotatedStringElement.fontFamilyResolver) && this.onTextLayout == selectableTextAnnotatedStringElement.onTextLayout && TextOverflow.m6770equalsimpl0(this.overflow, selectableTextAnnotatedStringElement.overflow) && this.softWrap == selectableTextAnnotatedStringElement.softWrap && this.maxLines == selectableTextAnnotatedStringElement.maxLines && this.minLines == selectableTextAnnotatedStringElement.minLines && this.onPlaceholderLayout == selectableTextAnnotatedStringElement.onPlaceholderLayout && kotlin.jvm.internal.k.b(this.selectionController, selectableTextAnnotatedStringElement.selectionController);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = (this.fontFamilyResolver.hashCode() + ((this.style.hashCode() + (this.text.hashCode() * 31)) * 31)) * 31;
        k kVar = this.onTextLayout;
        int iD = (((a.d((TextOverflow.m6771hashCodeimpl(this.overflow) + ((iHashCode + (kVar != null ? kVar.hashCode() : 0)) * 31)) * 31, 31, this.softWrap) + this.maxLines) * 31) + this.minLines) * 31;
        List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
        int iHashCode2 = (iD + (list != null ? list.hashCode() : 0)) * 31;
        k kVar2 = this.onPlaceholderLayout;
        int iHashCode3 = (iHashCode2 + (kVar2 != null ? kVar2.hashCode() : 0)) * 31;
        SelectionController selectionController = this.selectionController;
        int iHashCode4 = (iHashCode3 + (selectionController != null ? selectionController.hashCode() : 0)) * 31;
        ColorProducer colorProducer = this.color;
        return iHashCode4 + (colorProducer != null ? colorProducer.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "SelectableTextAnnotatedStringElement(text=" + ((Object) this.text) + ", style=" + this.style + ", fontFamilyResolver=" + this.fontFamilyResolver + ", onTextLayout=" + this.onTextLayout + ", overflow=" + ((Object) TextOverflow.m6772toStringimpl(this.overflow)) + ", softWrap=" + this.softWrap + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", placeholders=" + this.placeholders + ", onPlaceholderLayout=" + this.onPlaceholderLayout + ", selectionController=" + this.selectionController + ", color=" + this.color + ')';
    }

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, k kVar, int i, boolean z10, int i6, int i10, List list, k kVar2, SelectionController selectionController, ColorProducer colorProducer, int i11, e eVar) {
        this(annotatedString, textStyle, resolver, (i11 & 8) != 0 ? null : kVar, (i11 & 16) != 0 ? TextOverflow.INSTANCE.m6779getClipgIe3tQ8() : i, (i11 & 32) != 0 ? true : z10, (i11 & 64) != 0 ? Integer.MAX_VALUE : i6, (i11 & 128) != 0 ? 1 : i10, (i11 & 256) != 0 ? null : list, (i11 & 512) != 0 ? null : kVar2, (i11 & 1024) != 0 ? null : selectionController, (i11 & 2048) != 0 ? null : colorProducer, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public SelectableTextAnnotatedStringNode getNode() {
        return new SelectableTextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, null, 4096, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SelectableTextAnnotatedStringNode node) {
        node.m1368updateL09Iy8E(this.text, this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.color);
    }

    private SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, k kVar, int i, boolean z10, int i6, int i10, List<AnnotatedString.Range<Placeholder>> list, k kVar2, SelectionController selectionController, ColorProducer colorProducer) {
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
        this.color = colorProducer;
    }
}
