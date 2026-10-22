package androidx.compose.foundation.text;

import C7.r;
import S7.k;
import S7.n;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010%\u001a\u00020\u001d2\u0016\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d0\"H\u0003¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001dH\u0007¢\u0006\u0004\b'\u0010(J\u000f\u0010+\u001a\u00020\u0002H\u0000¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010*R/\u00106\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u0010,\u001a\u0004\b8\u0010*\"\u0004\b9\u0010\u0005R&\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d0\"0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8F¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006E²\u0006\f\u0010B\u001a\u00020>8\nX\u008a\u0084\u0002²\u0006\f\u0010C\u001a\u00020>8\nX\u008a\u0084\u0002²\u0006\f\u0010D\u001a\u00020>8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "Landroidx/compose/ui/text/AnnotatedString;", "initialText", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString;)V", "Landroidx/compose/ui/Modifier;", "", "start", "end", "textRange", "(Landroidx/compose/ui/Modifier;II)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/foundation/text/LinkRange;", "range", "Landroidx/compose/ui/graphics/Shape;", "shapeForRange", "(Landroidx/compose/ui/text/AnnotatedString$Range;)Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Path;", "pathForRangeInRangeCoordinates", "(Landroidx/compose/ui/text/AnnotatedString$Range;)Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/SpanStyle;", "other", "mergeOrUse", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "link", "Landroidx/compose/ui/platform/UriHandler;", "uriHandler", "LC7/r;", "handleLink", "(Landroidx/compose/ui/text/LinkAnnotation;Landroidx/compose/ui/platform/UriHandler;)V", "", "keys", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "block", "StyleAnnotation", "([Ljava/lang/Object;LS7/k;Landroidx/compose/runtime/Composer;I)V", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "applyAnnotators$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "applyAnnotators", "Landroidx/compose/ui/text/AnnotatedString;", "getInitialText$foundation_release", "Landroidx/compose/ui/text/TextLayoutResult;", "<set-?>", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult", "text", "getText$foundation_release", "setText$foundation_release", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()LS7/a;", "shouldMeasureLinks", "isHovered", "isFocused", "isPressed", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextLinkScope {
    public static final int $stable = 8;
    private final SnapshotStateList<k> annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;

    /* renamed from: textLayoutResult$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public TextLinkScope(AnnotatedString annotatedString) {
        SpanStyle style;
        this.initialText = annotatedString;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(annotatedString);
        List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
        int size = linkAnnotations.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<LinkAnnotation> range = linkAnnotations.get(i);
            TextLinkStyles styles = range.getItem().getStyles();
            if (styles != null && (style = styles.getStyle()) != null) {
                builder.addStyle(style, range.getStart(), range.getEnd());
            }
        }
        this.text = builder.toAnnotatedString();
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public final void StyleAnnotation(final Object[] objArr, final k kVar, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2083052099);
        int i6 = (i & 48) == 0 ? (composerStartRestartGroup.changedInstance(kVar) ? 32 : 16) | i : i;
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        composerStartRestartGroup.startMovableGroup(-416717687, Integer.valueOf(objArr.length));
        for (Object obj : objArr) {
            i6 |= composerStartRestartGroup.changedInstance(obj) ? 4 : 0;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i6 & 14) == 0) {
            i6 |= 2;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2083052099, i6, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:237)");
            }
            Z0.a aVar = new Z0.a(2);
            ArrayList arrayList = (ArrayList) aVar.f1582a;
            aVar.D(kVar);
            aVar.E(objArr);
            Object[] array = arrayList.toArray(new Object[arrayList.size()]);
            boolean zChangedInstance = ((i6 & 112) == 32) | composerStartRestartGroup.changedInstance(this);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        this.this$0.annotators.add(kVar);
                        final TextLinkScope textLinkScope = this.this$0;
                        final k kVar2 = kVar;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                textLinkScope.annotators.remove(kVar2);
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(array, (k) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.TextLinkScope.StyleAnnotation.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    TextLinkScope textLinkScope = TextLinkScope.this;
                    Object[] objArr2 = objArr;
                    textLinkScope.StyleAnnotation(Arrays.copyOf(objArr2, objArr2.length), kVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        LinkInteractionListener linkInteractionListener;
        r rVar;
        if (!(link instanceof LinkAnnotation.Url)) {
            if (!(link instanceof LinkAnnotation.Clickable) || (linkInteractionListener = link.getLinkInteractionListener()) == null) {
                return;
            }
            linkInteractionListener.onClick(link);
            return;
        }
        LinkInteractionListener linkInteractionListener2 = link.getLinkInteractionListener();
        if (linkInteractionListener2 != null) {
            linkInteractionListener2.onClick(link);
            rVar = r.f317a;
        } else {
            rVar = null;
        }
        if (rVar == null) {
            try {
                uriHandler.openUri(((LinkAnnotation.Url) link).getUrl());
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpanStyle mergeOrUse(SpanStyle spanStyle, SpanStyle spanStyle2) {
        SpanStyle spanStyleMerge;
        return (spanStyle == null || (spanStyleMerge = spanStyle.merge(spanStyle2)) == null) ? spanStyle2 : spanStyleMerge;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> range) {
        TextLayoutResult textLayoutResult;
        if (!((Boolean) getShouldMeasureLinks().invoke()).booleanValue() || (textLayoutResult = getTextLayoutResult()) == null) {
            return null;
        }
        Path pathForRange = textLayoutResult.getPathForRange(range.getStart(), range.getEnd());
        Rect boundingBox = textLayoutResult.getBoundingBox(range.getStart());
        pathForRange.mo4032translatek4lQ0M(Offset.m3904unaryMinusF1C5BW0(OffsetKt.Offset(textLayoutResult.getLineForOffset(range.getStart()) == textLayoutResult.getLineForOffset(range.getEnd()) ? Math.min(textLayoutResult.getBoundingBox(range.getEnd() - 1).getLeft(), boundingBox.getLeft()) : 0.0f, boundingBox.getTop())));
        return pathForRange;
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> range) {
        final Path pathPathForRangeInRangeCoordinates = pathForRangeInRangeCoordinates(range);
        if (pathPathForRangeInRangeCoordinates != null) {
            return new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
                @Override // androidx.compose.ui.graphics.Shape
                /* renamed from: createOutline-Pq9zytI */
                public Outline mo289createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                    return new Outline.Generic(pathPathForRangeInRangeCoordinates);
                }
            };
        }
        return null;
    }

    private final Modifier textRange(Modifier modifier, final int i, final int i6) {
        return modifier.then(new TextRangeLayoutModifier(new TextRangeScopeMeasurePolicy() { // from class: androidx.compose.foundation.text.b
            @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
            public final TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
                return TextLinkScope.textRange$lambda$3(this.f1736a, i, i6, textRangeLayoutMeasureScope);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult textRange$lambda$3(TextLinkScope textLinkScope, int i, int i6, TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        if (textLayoutResult == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new S7.a() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$layoutResult$1
                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    return IntOffset.m6963boximpl(m1132invokenOccac());
                }

                /* renamed from: invoke-nOcc-ac, reason: not valid java name */
                public final long m1132invokenOccac() {
                    return IntOffset.INSTANCE.m6983getZeronOccac();
                }
            });
        }
        final IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(textLayoutResult.getPathForRange(i, i6).getBounds());
        return textRangeLayoutMeasureScope.layout(intRectRoundToIntRect.getWidth(), intRectRoundToIntRect.getHeight(), new S7.a() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                return IntOffset.m6963boximpl(m1131invokenOccac());
            }

            /* renamed from: invoke-nOcc-ac, reason: not valid java name */
            public final long m1131invokenOccac() {
                return intRectRoundToIntRect.m7001getTopLeftnOccac();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v6 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void LinksComposables(Composer composer, final int i) {
        int i6;
        Modifier modifierClip;
        Composer composerStartRestartGroup = composer.startRestartGroup(1154651354);
        int i10 = 2;
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154651354, i6, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:152)");
            }
            final UriHandler uriHandler = (UriHandler) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
            AnnotatedString annotatedString = this.text;
            ?? r11 = 0;
            List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
            int size = linkAnnotations.size();
            int i11 = 0;
            while (i11 < size) {
                final AnnotatedString.Range<LinkAnnotation> range = linkAnnotations.get(i11);
                Shape shapeShapeForRange = shapeForRange(range);
                if (shapeShapeForRange == null || (modifierClip = ClipKt.clip(Modifier.INSTANCE, shapeShapeForRange)) == null) {
                    modifierClip = Modifier.INSTANCE;
                }
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                Modifier modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(textRange(modifierClip, range.getStart(), range.getEnd()), mutableInteractionSource, r11, i10, null), PointerIcon.INSTANCE.getHand(), r11, i10, null);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(range) | composerStartRestartGroup.changedInstance(uriHandler);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new S7.a() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // S7.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1130invoke();
                            return r.f317a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m1130invoke() {
                            this.this$0.handleLink(range.getItem(), uriHandler);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                BoxKt.Box(ClickableKt.m276combinedClickableXVZzFYc$default(modifierPointerHoverIcon$default, mutableInteractionSource, null, false, null, null, null, null, null, (S7.a) objRememberedValue2, 252, null), composerStartRestartGroup, r11);
                final State<Boolean> stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource, composerStartRestartGroup, 6);
                final State<Boolean> stateCollectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource, composerStartRestartGroup, 6);
                final State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource, composerStartRestartGroup, 6);
                Boolean boolValueOf = Boolean.valueOf(LinksComposables$lambda$13$lambda$9(stateCollectIsHoveredAsState));
                Boolean boolValueOf2 = Boolean.valueOf(LinksComposables$lambda$13$lambda$10(stateCollectIsFocusedAsState));
                Boolean boolValueOf3 = Boolean.valueOf(LinksComposables$lambda$13$lambda$11(stateCollectIsPressedAsState));
                TextLinkStyles styles = range.getItem().getStyles();
                SpanStyle style = styles != null ? styles.getStyle() : null;
                TextLinkStyles styles2 = range.getItem().getStyles();
                SpanStyle focusedStyle = styles2 != null ? styles2.getFocusedStyle() : null;
                TextLinkStyles styles3 = range.getItem().getStyles();
                SpanStyle hoveredStyle = styles3 != null ? styles3.getHoveredStyle() : null;
                TextLinkStyles styles4 = range.getItem().getStyles();
                Object[] objArr = {boolValueOf, boolValueOf2, boolValueOf3, style, focusedStyle, hoveredStyle, styles4 != null ? styles4.getPressedStyle() : null};
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(range) | composerStartRestartGroup.changed(stateCollectIsFocusedAsState) | composerStartRestartGroup.changed(stateCollectIsHoveredAsState) | composerStartRestartGroup.changed(stateCollectIsPressedAsState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    Object obj = new k() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((TextAnnotatorScope) obj2);
                            return r.f317a;
                        }

                        public final void invoke(TextAnnotatorScope textAnnotatorScope) {
                            TextLinkStyles styles5;
                            TextLinkStyles styles6;
                            TextLinkStyles styles7;
                            TextLinkScope textLinkScope = this.this$0;
                            TextLinkStyles styles8 = range.getItem().getStyles();
                            SpanStyle pressedStyle = null;
                            SpanStyle spanStyleMergeOrUse = textLinkScope.mergeOrUse(textLinkScope.mergeOrUse(styles8 != null ? styles8.getStyle() : null, (!TextLinkScope.LinksComposables$lambda$13$lambda$10(stateCollectIsFocusedAsState) || (styles7 = range.getItem().getStyles()) == null) ? null : styles7.getFocusedStyle()), (!TextLinkScope.LinksComposables$lambda$13$lambda$9(stateCollectIsHoveredAsState) || (styles6 = range.getItem().getStyles()) == null) ? null : styles6.getHoveredStyle());
                            if (TextLinkScope.LinksComposables$lambda$13$lambda$11(stateCollectIsPressedAsState) && (styles5 = range.getItem().getStyles()) != null) {
                                pressedStyle = styles5.getPressedStyle();
                            }
                            SpanStyle spanStyleMergeOrUse2 = textLinkScope.mergeOrUse(spanStyleMergeOrUse, pressedStyle);
                            if (spanStyleMergeOrUse2 != null) {
                                AnnotatedString.Range<LinkAnnotation> range2 = range;
                                textAnnotatorScope.replaceStyle(spanStyleMergeOrUse2, range2.getStart(), range2.getEnd());
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                    objRememberedValue3 = obj;
                }
                StyleAnnotation(objArr, (k) objRememberedValue3, composerStartRestartGroup, (i6 << 6) & 896);
                i11++;
                i10 = 2;
                r11 = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.TextLinkScope.LinksComposables.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    TextLinkScope.this.LinksComposables(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final AnnotatedString applyAnnotators$foundation_release() {
        AnnotatedString annotatedString;
        if (this.annotators.isEmpty()) {
            annotatedString = this.text;
        } else {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            builder.append(this.initialText);
            TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(builder);
            SnapshotStateList<k> snapshotStateList = this.annotators;
            int size = snapshotStateList.size();
            for (int i = 0; i < size; i++) {
                snapshotStateList.get(i).invoke(textAnnotatorScope);
            }
            annotatedString = builder.toAnnotatedString();
        }
        this.text = annotatedString;
        return annotatedString;
    }

    /* renamed from: getInitialText$foundation_release, reason: from getter */
    public final AnnotatedString getInitialText() {
        return this.initialText;
    }

    public final S7.a getShouldMeasureLinks() {
        return new S7.a() { // from class: androidx.compose.foundation.text.TextLinkScope$shouldMeasureLinks$1
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                TextLayoutInput layoutInput;
                AnnotatedString text = this.this$0.getText();
                TextLayoutResult textLayoutResult = this.this$0.getTextLayoutResult();
                return Boolean.valueOf(kotlin.jvm.internal.k.b(text, (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : layoutInput.getText()));
            }
        };
    }

    /* renamed from: getText$foundation_release, reason: from getter */
    public final AnnotatedString getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextLayoutResult getTextLayoutResult() {
        return (TextLayoutResult) this.textLayoutResult.getValue();
    }

    public final void setText$foundation_release(AnnotatedString annotatedString) {
        this.text = annotatedString;
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        this.textLayoutResult.setValue(textLayoutResult);
    }
}
