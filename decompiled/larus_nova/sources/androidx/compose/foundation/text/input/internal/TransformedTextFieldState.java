package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 `2\u00020\u0001:\u0002_`B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010!\u001a\u00020\"2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%J\u0015\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020(¢\u0006\u0004\b-\u0010*J\u001d\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020(¢\u0006\u0004\b1\u00102J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\"J\u0006\u00107\u001a\u00020\"J1\u00108\u001a\u00020\"2\u0006\u00104\u001a\u0002052\u0006\u00109\u001a\u00020(2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=¢\u0006\u0004\b>\u0010?J,\u0010@\u001a\u00020\"2\u0006\u00104\u001a\u0002052\b\b\u0002\u0010A\u001a\u00020=2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=J\u0006\u0010B\u001a\u00020\"J\u0006\u0010C\u001a\u00020\"J\u0006\u0010D\u001a\u00020\"J\u0006\u0010E\u001a\u00020\"J,\u0010F\u001a\u00020\"2\b\b\u0002\u0010<\u001a\u00020=2\u0017\u0010G\u001a\u0013\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\"0H¢\u0006\u0002\bJH\u0086\bJ\f\u0010K\u001a\u00020\"*\u00020IH\u0002J\u0015\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020%¢\u0006\u0004\bN\u0010OJ\u0015\u0010L\u001a\u00020(2\u0006\u00109\u001a\u00020(¢\u0006\u0004\bP\u0010QJ\u0015\u0010R\u001a\u00020(2\u0006\u0010M\u001a\u00020%¢\u0006\u0004\bS\u0010OJ\u0015\u0010R\u001a\u00020(2\u0006\u00109\u001a\u00020(¢\u0006\u0004\bT\u0010QJ\u0016\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0086@¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020=2\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\\\u001a\u00020%H\u0016J\b\u0010]\u001a\u00020^H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "outputTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "codepointTransformedText", "untransformedText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getUntransformedText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputText", "getOutputText", "visualText", "getVisualText", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "placeCursorBeforeCharAt", "transformedOffset", "", "selectCharsIn", "transformedRange", "Landroidx/compose/ui/text/TextRange;", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightCharsIn-7RAjNK8", "(IJ)V", "replaceAll", "newText", "", "selectAll", "deleteSelectedText", "replaceText", FilterData.FilterOptionItem.Type.RANGE, "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "restartImeIfContentChanges", "", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "replaceSelectedText", "clearComposition", "collapseSelectionToMax", "collapseSelectionToEnd", "undo", "redo", "editUntransformedTextAsUser", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Lkotlin/ExtensionFunctionType;", "updateWedgeAffinity", "mapToTransformed", "offset", "mapToTransformed--jx7JFs", "(I)J", "mapToTransformed-GEjPoXI", "(J)J", "mapFromTransformed", "mapFromTransformed--jx7JFs", "mapFromTransformed-GEjPoXI", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "TransformedText", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private final CodepointTransformation codepointTransformation;
    private final State<TransformedText> codepointTransformedText;
    private InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    private final State<TransformedText> outputTransformedText;
    private final MutableState selectionWedgeAffinity$delegate;
    private final TextFieldState textFieldState;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0003J+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "<init>", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapToTransformed", "Landroidx/compose/ui/text/TextRange;", FilterData.FilterOptionItem.Type.RANGE, "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "selectionWedgeAffinity", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "mapFromTransformed", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[WedgeAffinity.values().length];
                r100[WedgeAffinity.Start.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[WedgeAffinity.End.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r100;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
        private final long m1328mapFromTransformedxdX6G0(long r100, OffsetMappingCalculator r101) {
            long r102 = r101.m1269mapFromDestjx7JFs(TextRange.m6998getStartimpl(r100));
            if (TextRange.m6992getCollapsedimpl(r100) == false) goto L5;
            long r103 = r102;
        L6:
            int r104 = Math.min(TextRange.m6996getMinimpl(r102), TextRange.m6996getMinimpl(r103));
            int r105 = Math.max(TextRange.m6995getMaximpl(r102), TextRange.m6995getMaximpl(r103));
            if (TextRange.m6997getReversedimpl(r100) == false) goto L10;
            return TextRangeKt.TextRange(r105, r104);
        L10:
            return TextRangeKt.TextRange(r104, r105);
        L5:
            r103 = r101.m1269mapFromDestjx7JFs(TextRange.m6993getEndimpl(r100));
            goto L6
        }

        /* JADX INFO: renamed from: access$mapFromTransformed-xdX6-G0, reason: not valid java name */
        public static final /* synthetic */ long m1326access$mapFromTransformedxdX6G0(Companion r100, long r101, OffsetMappingCalculator r102) {
            return r100.m1328mapFromTransformedxdX6G0(r101, r102);
        }

        @JvmStatic
        private final TransformedText calculateTransformedText(TextFieldCharSequence r110, OutputTransformation r111, SelectionWedgeAffinity r112) {
            OffsetMappingCalculator r100 = new OffsetMappingCalculator();
            TextFieldBuffer r101 = new TextFieldBuffer(r110, null, null, r100, 6, null);
            boolean r102 = true;
            r101.setCanCallAddStyle$foundation_release(true);
            r111.transformOutput(r101);
            r101.setCanCallAddStyle$foundation_release(false);
            List<AnnotatedString.Range<AnnotatedString.Annotation>> r103 = r101.getOutputTransformationAnnotations$foundation_release();
            if (r101.getChanges().getChangeCount() != 0) goto L12;
            List<AnnotatedString.Range<AnnotatedString.Annotation>> r104 = r103;
            if (r104 != null) goto L7;
        L10:
            if (r102 == false) goto L12;
            return null;
        L7:
            if (r104.isEmpty() == true) goto L10;
            r102 = false;
        L12:
            long r105 = m1329mapToTransformedXGyztTk(r110.m1197getSelectiond9O1mEE(), r100, r112);
            TextRange r106 = r110.m1196getCompositionMzsxiRA();
            if (r106 == null) goto L15;
            TextRange r107 = TextRange.m6986boximpl(TransformedTextFieldState.access$getCompanion$p().m1329mapToTransformedXGyztTk(r106.m7002unboximpl(), r100, r112));
        L17:
            return new TransformedText(TextFieldBuffer.m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(r101, r105, r107, null, r103, 4, null), r100);
        L15:
            r107 = null;
            goto L17
        }

        @JvmStatic
        /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
        private final long m1329mapToTransformedXGyztTk(long r100, OffsetMappingCalculator r110, SelectionWedgeAffinity r111) {
            long r101 = r110.m1270mapFromSourcejx7JFs(TextRange.m6998getStartimpl(r100));
            if (TextRange.m6992getCollapsedimpl(r100) == false) goto L5;
            long r102 = r101;
        L6:
            WedgeAffinity r112 = null;
            if (r111 == null) goto L9;
            WedgeAffinity r103 = r111.getStartAffinity();
        L11:
            if (TextRange.m6992getCollapsedimpl(r100) == false) goto L13;
            r112 = r103;
        L16:
            if (r103 != null) goto L18;
        L26:
            if (r112 != null) goto L28;
        L37:
            int r113 = Math.min(TextRange.m6996getMinimpl(r101), TextRange.m6996getMinimpl(r102));
            int r114 = Math.max(TextRange.m6995getMaximpl(r101), TextRange.m6995getMaximpl(r102));
            if (TextRange.m6997getReversedimpl(r100) == false) goto L41;
            return TextRangeKt.TextRange(r114, r113);
        L41:
            return TextRangeKt.TextRange(r113, r114);
        L28:
            if (TextRange.m6992getCollapsedimpl(r102) == true) goto L37;
            int r115 = WhenMappings.$EnumSwitchMapping$0[r112.ordinal()];
            if (r115 == 1) goto L35;
            if (r115 != 2) goto L34;
            long r116 = TextRangeKt.TextRange(TextRange.m6993getEndimpl(r102));
        L36:
            r102 = r116;
            goto L37
        L34:
            throw new NoWhenBranchMatchedException();
        L35:
            r116 = TextRangeKt.TextRange(TextRange.m6998getStartimpl(r102));
            goto L36
        L18:
            if (TextRange.m6992getCollapsedimpl(r101) == true) goto L26;
            int r104 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
            if (r104 == 1) goto L25;
            if (r104 != 2) goto L24;
            r101 = TextRangeKt.TextRange(TextRange.m6993getEndimpl(r101));
            goto L26
        L24:
            throw new NoWhenBranchMatchedException();
        L25:
            r101 = TextRangeKt.TextRange(TextRange.m6998getStartimpl(r101));
            goto L26
        L13:
            if (r111 == null) goto L16;
            r112 = r111.getEndAffinity();
            goto L16
        L9:
            r103 = null;
            goto L11
        L5:
            r102 = r110.m1270mapFromSourcejx7JFs(TextRange.m6993getEndimpl(r100));
            goto L6
        }

        @JvmStatic
        private final TransformedText calculateTransformedText(TextFieldCharSequence r110, CodepointTransformation r111, SelectionWedgeAffinity r112) {
            OffsetMappingCalculator r100 = new OffsetMappingCalculator();
            CharSequence r101 = CodepointTransformationKt.toVisualText(r110, r111, r100);
            if (r101 != r110) goto L5;
            return null;
        L5:
            long r102 = m1329mapToTransformedXGyztTk(r110.m1197getSelectiond9O1mEE(), r100, r112);
            TextRange r113 = r110.m1196getCompositionMzsxiRA();
            if (r113 == null) goto L8;
            TextRange r103 = TextRange.m6986boximpl(TransformedTextFieldState.access$getCompanion$p().m1329mapToTransformedXGyztTk(r113.m7002unboximpl(), r100, r112));
        L10:
            return new TransformedText(new TextFieldCharSequence(r101, r102, r103, null, null, null, 56, null), r100);
        L8:
            r103 = null;
            goto L10
        }

        public static final /* synthetic */ TransformedText access$calculateTransformedText(Companion r100, TextFieldCharSequence r101, OutputTransformation r102, SelectionWedgeAffinity r103) {
            return r100.calculateTransformedText(r101, r102, r103);
        }

        /* JADX INFO: renamed from: access$mapToTransformed-XGyztTk, reason: not valid java name */
        public static final /* synthetic */ long m1327access$mapToTransformedXGyztTk(Companion r100, long r101, OffsetMappingCalculator r102, SelectionWedgeAffinity r103) {
            return r100.m1329mapToTransformedXGyztTk(r101, r102, r103);
        }

        public static final /* synthetic */ TransformedText access$calculateTransformedText(Companion r100, TextFieldCharSequence r101, CodepointTransformation r102, SelectionWedgeAffinity r103) {
            return r100.calculateTransformedText(r101, r102, r103);
        }

        /* JADX INFO: renamed from: mapToTransformed-XGyztTk$default, reason: not valid java name */
        public static /* synthetic */ long m1330mapToTransformedXGyztTk$default(Companion r100, long r101, OffsetMappingCalculator r102, SelectionWedgeAffinity r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            return r100.m1329mapToTransformedXGyztTk(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText r100, TextFieldCharSequence r101, OffsetMappingCalculator r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.text;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.offsetMapping;
        L9:
            return r100.copy(r101, r102);
        }

        public final TextFieldCharSequence component1() {
            return this.text;
        }

        public final OffsetMappingCalculator component2() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence r100, OffsetMappingCalculator r101) {
            return new TransformedText(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TransformedText) == true) goto L8;
            return false;
        L8:
            TransformedText r101 = (TransformedText) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.offsetMapping, r101.offsetMapping) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + this.text + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public TransformedText(TextFieldCharSequence r100, OffsetMappingCalculator r101) {
            this.text = r100;
            this.offsetMapping = r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TransformedTextFieldState", f = "TransformedTextFieldState.kt", i = {0}, l = {755}, m = "collectImeNotifications", n = {"transformedNotifyImeListener"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TransformedTextFieldState this$0;

        public AnonymousClass1(TransformedTextFieldState r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collectImeNotifications(null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(TextFieldState.NotifyImeListener r100, TransformedTextFieldState r101, TextFieldCharSequence r102, TextFieldCharSequence r103, boolean r104) {
        collectImeNotifications$lambda$20(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ TransformedText b(TransformedTextFieldState r100, CodepointTransformation r101) {
        return codepointTransformedText$lambda$3$lambda$2(r100, r101);
    }

    public static /* synthetic */ TransformedText c(TransformedTextFieldState r100, OutputTransformation r101) {
        return outputTransformedText$lambda$1$lambda$0(r100, r101);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence r100, OutputTransformation r101, SelectionWedgeAffinity r102) {
        return Companion.access$calculateTransformedText(Companion, r100, r101, r102);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence r100, CodepointTransformation r101, SelectionWedgeAffinity r102) {
        return Companion.access$calculateTransformedText(Companion, r100, r101, r102);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
    private static final long m1315mapFromTransformedxdX6G0(long r100, OffsetMappingCalculator r101) {
        return Companion.m1326access$mapFromTransformedxdX6G0(Companion, r100, r101);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
    private static final long m1316mapToTransformedXGyztTk(long r100, OffsetMappingCalculator r101, SelectionWedgeAffinity r102) {
        return Companion.m1327access$mapToTransformedXGyztTk(Companion, r100, r101, r102);
    }

    public final void collapseSelectionToEnd() {
        TextFieldState r100 = this.textFieldState;
        InputTransformation r101 = this.inputTransformation;
        TextFieldEditUndoBehavior r102 = TextFieldEditUndoBehavior.MergeIfPossible;
        r100.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r103 = r100.getMainBuffer$foundation_release();
        TextFieldBufferKt.setSelectionCoerced$default(r103, TextRange.m6993getEndimpl(r103.m1189getSelectiond9O1mEE()), 0, 2, null);
        TextFieldState.access$commitEditAsUser(r100, r101, true, r102);
    }

    public final void collapseSelectionToMax() {
        TextFieldState r100 = this.textFieldState;
        InputTransformation r101 = this.inputTransformation;
        TextFieldEditUndoBehavior r102 = TextFieldEditUndoBehavior.MergeIfPossible;
        r100.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r103 = r100.getMainBuffer$foundation_release();
        TextFieldBufferKt.setSelectionCoerced$default(r103, TextRange.m6995getMaximpl(r103.m1189getSelectiond9O1mEE()), 0, 2, null);
        TextFieldState.access$commitEditAsUser(r100, r101, true, r102);
    }

    public final void deleteSelectedText() {
        TextFieldState r100 = this.textFieldState;
        InputTransformation r101 = this.inputTransformation;
        TextFieldEditUndoBehavior r102 = TextFieldEditUndoBehavior.NeverMerge;
        r100.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r103 = r100.getMainBuffer$foundation_release();
        TextFieldBufferKt.delete(r103, TextRange.m6996getMinimpl(r103.m1189getSelectiond9O1mEE()), TextRange.m6995getMaximpl(r103.m1189getSelectiond9O1mEE()));
        TextFieldBufferKt.setSelectionCoerced$default(r103, TextRange.m6996getMinimpl(r103.m1189getSelectiond9O1mEE()), 0, 2, null);
        updateWedgeAffinity(r103);
        TextFieldState.access$commitEditAsUser(r100, r101, true, r102);
    }

    public final TextFieldCharSequence getOutputText() {
        State<TransformedText> r100 = this.outputTransformedText;
        if (r100 == null) goto L9;
        TransformedText r101 = r100.getValue();
        if (r101 == null) goto L9;
        TextFieldCharSequence r102 = r101.getText();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return getUntransformedText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        return (SelectionWedgeAffinity) this.selectionWedgeAffinity$delegate.getValue();
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation_release();
    }

    public final TextFieldCharSequence getVisualText() {
        State<TransformedText> r100 = this.codepointTransformedText;
        if (r100 == null) goto L9;
        TransformedText r101 = r100.getValue();
        if (r101 == null) goto L9;
        TextFieldCharSequence r102 = r101.getText();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return getOutputText();
    }

    public int hashCode() {
        int r100 = this.textFieldState.hashCode() * 31;
        CodepointTransformation r101 = this.codepointTransformation;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        OutputTransformation r105 = this.outputTransformation;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public final void selectAll() {
        TextFieldState r100 = this.textFieldState;
        InputTransformation r101 = this.inputTransformation;
        TextFieldEditUndoBehavior r102 = TextFieldEditUndoBehavior.MergeIfPossible;
        r100.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r103 = r100.getMainBuffer$foundation_release();
        TextFieldBufferKt.setSelectionCoerced(r103, 0, r103.getLength());
        TextFieldState.access$commitEditAsUser(r100, r101, true, r102);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + getOutputText() + "\", visualText=\"" + getVisualText() + "\")";
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public static final /* synthetic */ Companion access$getCompanion$p() {
        return Companion;
    }

    public static final /* synthetic */ InputTransformation access$getInputTransformation$p(TransformedTextFieldState r100) {
        return r100.inputTransformation;
    }

    public static final /* synthetic */ TextFieldState access$getTextFieldState$p(TransformedTextFieldState r100) {
        return r100.textFieldState;
    }

    private final void updateWedgeAffinity(TextFieldBuffer r100) {
        if (r100.getChangeTracker$foundation_release().getChangeCount() > 0) goto L5;
        return;
    L5:
        if (TextRange.m6992getCollapsedimpl(r100.m1189getSelectiond9O1mEE()) == false) goto L9;
        setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TransformedTextFieldState) == true) goto L8;
        return false;
    L8:
        TransformedTextFieldState r101 = (TransformedTextFieldState) r100;
        if (Intrinsics.areEqual(this.textFieldState, r101.textFieldState) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.codepointTransformation, r101.codepointTransformation) == true) goto L15;
        return false;
    L15:
        return Intrinsics.areEqual(this.outputTransformation, r101.outputTransformation);
    }

    /* JADX INFO: renamed from: mapFromTransformed--jx7JFs, reason: not valid java name */
    public final long m1319mapFromTransformedjx7JFs(int r100) {
        State<TransformedText> r101 = this.outputTransformedText;
        OffsetMappingCalculator r102 = null;
        if (r101 == null) goto L7;
        TransformedText r103 = r101.getValue();
        if (r103 == null) goto L7;
        OffsetMappingCalculator r104 = r103.getOffsetMapping();
    L8:
        State<TransformedText> r105 = this.codepointTransformedText;
        if (r105 == null) goto L13;
        TransformedText r106 = r105.getValue();
        if (r106 == null) goto L13;
        r102 = r106.getOffsetMapping();
    L13:
        if (r102 == null) goto L15;
        long r107 = r102.m1269mapFromDestjx7JFs(r100);
    L16:
        if (r104 != null) goto L18;
        return r107;
    L18:
        return Companion.m1326access$mapFromTransformedxdX6G0(Companion, r107, r104);
    L15:
        r107 = TextRangeKt.TextRange(r100);
    L7:
        r104 = null;
        goto L8
    }

    /* JADX INFO: renamed from: mapFromTransformed-GEjPoXI, reason: not valid java name */
    public final long m1320mapFromTransformedGEjPoXI(long r100) {
        State<TransformedText> r101 = this.outputTransformedText;
        OffsetMappingCalculator r102 = null;
        if (r101 == null) goto L7;
        TransformedText r103 = r101.getValue();
        if (r103 == null) goto L7;
        OffsetMappingCalculator r104 = r103.getOffsetMapping();
    L8:
        State<TransformedText> r105 = this.codepointTransformedText;
        if (r105 == null) goto L13;
        TransformedText r106 = r105.getValue();
        if (r106 == null) goto L13;
        r102 = r106.getOffsetMapping();
    L13:
        if (r102 == null) goto L15;
        r100 = Companion.m1326access$mapFromTransformedxdX6G0(Companion, r100, r102);
    L15:
        if (r104 != null) goto L17;
        return r100;
    L17:
        return Companion.m1326access$mapFromTransformedxdX6G0(Companion, r100, r104);
    L7:
        r104 = null;
        goto L8
    }

    /* JADX INFO: renamed from: mapToTransformed--jx7JFs, reason: not valid java name */
    public final long m1321mapToTransformedjx7JFs(int r100) {
        State<TransformedText> r101 = this.outputTransformedText;
        OffsetMappingCalculator r102 = null;
        if (r101 == null) goto L7;
        TransformedText r103 = r101.getValue();
        if (r103 == null) goto L7;
        OffsetMappingCalculator r104 = r103.getOffsetMapping();
    L8:
        State<TransformedText> r105 = this.codepointTransformedText;
        if (r105 == null) goto L13;
        TransformedText r106 = r105.getValue();
        if (r106 == null) goto L13;
        r102 = r106.getOffsetMapping();
    L13:
        if (r104 == null) goto L15;
        long r107 = r104.m1270mapFromSourcejx7JFs(r100);
    L16:
        if (r102 != null) goto L18;
        return r107;
    L18:
        return Companion.m1327access$mapToTransformedXGyztTk(Companion, r107, r102, getSelectionWedgeAffinity());
    L15:
        r107 = TextRangeKt.TextRange(r100);
    L7:
        r104 = null;
        goto L8
    }

    /* JADX INFO: renamed from: mapToTransformed-GEjPoXI, reason: not valid java name */
    public final long m1322mapToTransformedGEjPoXI(long r110) {
        State<TransformedText> r100 = this.outputTransformedText;
        OffsetMappingCalculator r101 = null;
        if (r100 == null) goto L7;
        TransformedText r102 = r100.getValue();
        if (r102 == null) goto L7;
        OffsetMappingCalculator r103 = r102.getOffsetMapping();
    L8:
        State<TransformedText> r104 = this.codepointTransformedText;
        if (r104 == null) goto L13;
        TransformedText r105 = r104.getValue();
        if (r105 == null) goto L13;
        r101 = r105.getOffsetMapping();
    L13:
        if (r103 == null) goto L15;
        r110 = Companion.m1330mapToTransformedXGyztTk$default(Companion, r110, r103, null, 4, null);
    L15:
        if (r101 != null) goto L17;
        return r110;
    L17:
        return Companion.m1327access$mapToTransformedXGyztTk(Companion, r110, r101, getSelectionWedgeAffinity());
    L7:
        r103 = null;
        goto L8
    }

    public final void placeCursorBeforeCharAt(int r100) {
        m1324selectCharsIn5zctL8(TextRangeKt.TextRange(r100));
    }

    public final void replaceAll(CharSequence r100) {
        TextFieldState r101 = this.textFieldState;
        InputTransformation r102 = this.inputTransformation;
        TextFieldEditUndoBehavior r103 = TextFieldEditUndoBehavior.MergeIfPossible;
        r101.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r104 = r101.getMainBuffer$foundation_release();
        TextFieldBufferKt.delete(r104, 0, r104.getLength());
        r104.append(r100.toString());
        updateWedgeAffinity(r104);
        TextFieldState.access$commitEditAsUser(r101, r102, true, r103);
    }

    /* JADX INFO: renamed from: selectCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1324selectCharsIn5zctL8(long r100) {
        m1325selectUntransformedCharsIn5zctL8(m1320mapFromTransformedGEjPoXI(r100));
    }

    /* JADX INFO: renamed from: selectUntransformedCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1325selectUntransformedCharsIn5zctL8(long r100) {
        TextFieldState r101 = this.textFieldState;
        InputTransformation r102 = this.inputTransformation;
        TextFieldEditUndoBehavior r103 = TextFieldEditUndoBehavior.MergeIfPossible;
        r101.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBufferKt.setSelectionCoerced(r101.getMainBuffer$foundation_release(), TextRange.m6998getStartimpl(r100), TextRange.m6993getEndimpl(r100));
        TextFieldState.access$commitEditAsUser(r101, r102, true, r103);
    }

    public final void setSelectionWedgeAffinity(SelectionWedgeAffinity r100) {
        this.selectionWedgeAffinity$delegate.setValue(r100);
    }

    public final void update(InputTransformation r100) {
        this.inputTransformation = r100;
    }

    public static final /* synthetic */ void access$updateWedgeAffinity(TransformedTextFieldState r100, TextFieldBuffer r101) {
        r100.updateWedgeAffinity(r101);
    }

    private static final TransformedText codepointTransformedText$lambda$3$lambda$2(TransformedTextFieldState r100, CodepointTransformation r101) {
        Companion r102 = Companion;
        State<TransformedText> r103 = r100.outputTransformedText;
        if (r103 == null) goto L8;
        TransformedText r104 = r103.getValue();
        if (r104 == null) goto L8;
        TextFieldCharSequence r105 = r104.getText();
        if (r105 == null) goto L8;
    L10:
        return Companion.access$calculateTransformedText(r102, r105, r101, r100.getSelectionWedgeAffinity());
    L8:
        r105 = r100.textFieldState.getValue$foundation_release();
        goto L10
    }

    private static final TransformedText outputTransformedText$lambda$1$lambda$0(TransformedTextFieldState r100, OutputTransformation r101) {
        return Companion.access$calculateTransformedText(Companion, r100.textFieldState.getValue$foundation_release(), r101, r100.getSelectionWedgeAffinity());
    }

    public final Object collectImeNotifications(final TextFieldState.NotifyImeListener r100, Continuation<?> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L12;
        TextFieldState.NotifyImeListener r107 = (TextFieldState.NotifyImeListener) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (this.outputTransformation == null) goto L17;
        r100 = new c2(r100, this);
    L17:
        r102.L$0 = r100;
        r102.label = 1;
        kotlinx.coroutines.j r108 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r108.C();
        access$getTextFieldState$p(this).addNotifyImeListener$foundation_release(r100);
        r108.i(new TransformedTextFieldState$collectImeNotifications$2$1(this, r100));
        Object r109 = r108.B();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L20:
        if (r109 != r105) goto L23;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    public final void editUntransformedTextAsUser(boolean r100, Function1<? super TextFieldBuffer, Unit> r101) {
        TextFieldState r102 = access$getTextFieldState$p(this);
        InputTransformation r103 = access$getInputTransformation$p(this);
        TextFieldEditUndoBehavior r104 = TextFieldEditUndoBehavior.MergeIfPossible;
        r102.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r105 = r102.getMainBuffer$foundation_release();
        r101.invoke(r105);
        access$updateWedgeAffinity(this, r105);
        TextFieldState.access$commitEditAsUser(r102, r103, r100, r104);
    }

    /* JADX INFO: renamed from: highlightCharsIn-7RAjNK8, reason: not valid java name */
    public final void m1318highlightCharsIn7RAjNK8(int r100, long r101) {
        long r102 = m1320mapFromTransformedGEjPoXI(r101);
        TextFieldState r103 = this.textFieldState;
        InputTransformation r104 = this.inputTransformation;
        TextFieldEditUndoBehavior r105 = TextFieldEditUndoBehavior.MergeIfPossible;
        r103.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r103.getMainBuffer$foundation_release().m1190setHighlightK7f2yys$foundation_release(r100, TextRange.m6998getStartimpl(r102), TextRange.m6993getEndimpl(r102));
        TextFieldState.access$commitEditAsUser(r103, r104, true, r105);
    }

    public TransformedTextFieldState(TextFieldState r100, InputTransformation r101, final CodepointTransformation r102, final OutputTransformation r103) {
        this.textFieldState = r100;
        this.inputTransformation = r101;
        this.codepointTransformation = r102;
        this.outputTransformation = r103;
        if (r103 == null) goto L5;
        State<TransformedText> r104 = SnapshotStateKt.derivedStateOf(new a2(this, r103));
    L6:
        this.outputTransformedText = r104;
        if (r102 == null) goto L9;
        State<TransformedText> r105 = SnapshotStateKt.derivedStateOf(new b2(this, r102));
    L10:
        this.codepointTransformedText = r105;
        this.selectionWedgeAffinity$delegate = SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), null, 2, null);
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void replaceSelectedText(CharSequence r100, boolean r101, TextFieldEditUndoBehavior r102, boolean r110) {
        TextFieldState r103 = this.textFieldState;
        InputTransformation r104 = this.inputTransformation;
        r103.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r105 = r103.getMainBuffer$foundation_release();
        if (r101 == false) goto L5;
        r105.commitComposition$foundation_release();
    L5:
        long r106 = r105.m1189getSelectiond9O1mEE();
        r105.replace(TextRange.m6996getMinimpl(r106), TextRange.m6995getMaximpl(r106), r100);
        TextFieldBufferKt.setSelectionCoerced$default(r105, TextRange.m6996getMinimpl(r106) + r100.length(), 0, 2, null);
        updateWedgeAffinity(r105);
        TextFieldState.access$commitEditAsUser(r103, r104, r110, r102);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk, reason: not valid java name */
    public final void m1323replaceTextM8tDOmk(CharSequence r100, long r101, TextFieldEditUndoBehavior r102, boolean r110) {
        TextFieldState r103 = this.textFieldState;
        InputTransformation r104 = this.inputTransformation;
        r103.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r105 = r103.getMainBuffer$foundation_release();
        long r106 = m1320mapFromTransformedGEjPoXI(r101);
        r105.replace(TextRange.m6996getMinimpl(r106), TextRange.m6995getMaximpl(r106), r100);
        TextFieldBufferKt.setSelectionCoerced$default(r105, TextRange.m6996getMinimpl(r106) + r100.length(), 0, 2, null);
        updateWedgeAffinity(r105);
        TextFieldState.access$commitEditAsUser(r103, r104, r110, r102);
    }

    private static final void collectImeNotifications$lambda$20(TextFieldState.NotifyImeListener r100, TransformedTextFieldState r101, TextFieldCharSequence r102, TextFieldCharSequence r103, boolean r104) {
        TransformedText r105 = Companion.access$calculateTransformedText(Companion, r102, r101.outputTransformation, r101.getSelectionWedgeAffinity());
        if (r105 == null) goto L7;
        TextFieldCharSequence r106 = r105.getText();
        if (r106 == null) goto L7;
        r102 = r106;
    L7:
        r100.onChange(r102, r101.getVisualText(), r104);
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = true;
    L5:
        TextFieldState r105 = access$getTextFieldState$p(r100);
        InputTransformation r106 = access$getInputTransformation$p(r100);
        TextFieldEditUndoBehavior r107 = TextFieldEditUndoBehavior.MergeIfPossible;
        r105.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r108 = r105.getMainBuffer$foundation_release();
        r102.invoke(r108);
        access$updateWedgeAffinity(r100, r108);
        TextFieldState.access$commitEditAsUser(r105, r106, r101, r107);
    }

    public /* synthetic */ TransformedTextFieldState(TextFieldState r100, InputTransformation r101, CodepointTransformation r102, OutputTransformation r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState r100, CharSequence r101, boolean r102, TextFieldEditUndoBehavior r103, boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = TextFieldEditUndoBehavior.MergeIfPossible;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = true;
    L11:
        r100.replaceSelectedText(r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk$default, reason: not valid java name */
    public static /* synthetic */ void m1317replaceTextM8tDOmk$default(TransformedTextFieldState r100, CharSequence r101, long r102, TextFieldEditUndoBehavior r110, boolean r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L5;
        r110 = TextFieldEditUndoBehavior.MergeIfPossible;
    L5:
        TextFieldEditUndoBehavior r103 = r110;
        if ((r112 & 8) == 0) goto L8;
        boolean r104 = true;
    L9:
        r100.m1323replaceTextM8tDOmk(r101, r102, r103, r104);
        return;
    L8:
        r104 = r111;
        goto L9
    }
}
