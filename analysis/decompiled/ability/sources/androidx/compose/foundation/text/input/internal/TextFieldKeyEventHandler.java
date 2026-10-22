package androidx.compose.foundation.text.input.internal;

import C7.r;
import S7.k;
import android.view.KeyEvent;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0082\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J:\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJP\u0010%\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0!H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "state", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textLayoutState", "", "isFromSoftKeyboard", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "LC7/r;", "block", "preparedSelectionContext", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;ZLS7/k;)V", "", "getVisibleTextLayoutHeight", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)F", "Landroidx/compose/ui/input/key/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "textFieldState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textFieldSelectionState", "Landroidx/compose/ui/focus/FocusManager;", "focusManager", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "keyboardController", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onPreKeyEvent", "editable", "singleLine", "Lkotlin/Function0;", "onSubmit", "onKeyEvent-6ptp14s", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZZLS7/a;)Z", "onKeyEvent", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "Landroidx/compose/foundation/text/KeyMapping;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private final TextFieldPreparedSelectionState preparedSelectionState = new TextFieldPreparedSelectionState();
    private final DeadKeyCombiner deadKeyCombiner = new DeadKeyCombiner();
    private final KeyMapping keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyCommand.PASTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyCommand.CUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[KeyCommand.UP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[KeyCommand.DOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[KeyCommand.LINE_START.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[KeyCommand.LINE_END.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[KeyCommand.HOME.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[KeyCommand.END.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[KeyCommand.TAB.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[KeyCommand.DESELECT.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[KeyCommand.UNDO.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[KeyCommand.REDO.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState textLayoutState) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        Rect rectLocalBoundingBoxOf$default = null;
        if (!textLayoutNodeCoordinates.isAttached()) {
            textLayoutNodeCoordinates = null;
        }
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
        if (decoratorNodeCoordinates != null) {
            if (!decoratorNodeCoordinates.isAttached()) {
                decoratorNodeCoordinates = null;
            }
            if (decoratorNodeCoordinates != null) {
                rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, null);
            }
        }
        if (rectLocalBoundingBoxOf$default != null) {
            return Size.m3961getHeightimpl(rectLocalBoundingBoxOf$default.m3928getSizeNHjbRc());
        }
        return Float.NaN;
    }

    private final void preparedSelectionContext(TransformedTextFieldState state, TextLayoutState textLayoutState, boolean isFromSoftKeyboard, k block) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(state, textLayoutState.getLayoutResult(), isFromSoftKeyboard, getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
        block.invoke(textFieldPreparedSelection);
        if (TextRange.m6304equalsimpl0(textFieldPreparedSelection.getSelection(), textFieldPreparedSelection.getInitialValue().getSelection())) {
            return;
        }
        state.m1268selectCharsIn5zctL8(textFieldPreparedSelection.getSelection());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: onKeyEvent-6ptp14s */
    public boolean mo1167onKeyEvent6ptp14s(KeyEvent event, TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, boolean editable, boolean singleLine, S7.a onSubmit) {
        TextRange textRangeM6299boximpl;
        Integer numM1023consumeZmokQxo;
        boolean z10 = false;
        if (!KeyEventType.m5268equalsimpl0(KeyEvent_androidKt.m5276getTypeZmokQxo(event), KeyEventType.INSTANCE.m5272getKeyDownCS__XNY())) {
            return false;
        }
        if (TextFieldKeyInput_androidKt.m1112isTypedEventZmokQxo(event) && (numM1023consumeZmokQxo = this.deadKeyCombiner.m1023consumeZmokQxo(event)) != null) {
            String string = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(2), numM1023consumeZmokQxo.intValue()).toString();
            if (!editable) {
                return false;
            }
            boolean z11 = !TextFieldKeyEventHandler_androidKt.m1240isFromSoftKeyboardZmokQxo(event);
            TextFieldState textFieldState2 = textFieldState.textFieldState;
            InputTransformation inputTransformation = textFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState2.getMainBuffer().getChangeTracker().clearChanges();
            EditingBuffer mainBuffer = textFieldState2.getMainBuffer();
            mainBuffer.commitComposition();
            EditCommandKt.commitText(mainBuffer, string, 1);
            textFieldState2.commitEditAsUser(inputTransformation, z11, textFieldEditUndoBehavior);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        KeyCommand keyCommandMo1025mapZmokQxo = this.keyMapping.mo1025mapZmokQxo(event);
        if (keyCommandMo1025mapZmokQxo != null && (!keyCommandMo1025mapZmokQxo.getEditsText() || editable)) {
            TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(textFieldState, textLayoutState.getLayoutResult(), TextFieldKeyEventHandler_androidKt.m1240isFromSoftKeyboardZmokQxo(event), getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
            switch (WhenMappings.$EnumSwitchMapping$0[keyCommandMo1025mapZmokQxo.ordinal()]) {
                case 1:
                    textFieldSelectionState.copy(false);
                    z10 = true;
                    break;
                case 2:
                    textFieldSelectionState.paste();
                    z10 = true;
                    break;
                case 3:
                    textFieldSelectionState.cut();
                    z10 = true;
                    break;
                case 4:
                    textFieldPreparedSelection.collapseLeftOr(new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$1
                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((TextFieldPreparedSelection) obj);
                            return r.f317a;
                        }

                        public final void invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            textFieldPreparedSelection2.moveCursorLeft();
                        }
                    });
                    z10 = true;
                    break;
                case 5:
                    textFieldPreparedSelection.collapseRightOr(new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$2
                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((TextFieldPreparedSelection) obj);
                            return r.f317a;
                        }

                        public final void invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                            textFieldPreparedSelection2.moveCursorRight();
                        }
                    });
                    z10 = true;
                    break;
                case 6:
                    textFieldPreparedSelection.moveCursorLeftByWord();
                    z10 = true;
                    break;
                case 7:
                    textFieldPreparedSelection.moveCursorRightByWord();
                    z10 = true;
                    break;
                case 8:
                    textFieldPreparedSelection.moveCursorPrevByParagraph();
                    z10 = true;
                    break;
                case 9:
                    textFieldPreparedSelection.moveCursorNextByParagraph();
                    z10 = true;
                    break;
                case 10:
                    textFieldPreparedSelection.moveCursorUpByLine();
                    z10 = true;
                    break;
                case 11:
                    textFieldPreparedSelection.moveCursorDownByLine();
                    z10 = true;
                    break;
                case 12:
                    textFieldPreparedSelection.moveCursorUpByPage();
                    z10 = true;
                    break;
                case 13:
                    textFieldPreparedSelection.moveCursorDownByPage();
                    z10 = true;
                    break;
                case 14:
                    textFieldPreparedSelection.moveCursorToLineStart();
                    z10 = true;
                    break;
                case 15:
                    textFieldPreparedSelection.moveCursorToLineEnd();
                    z10 = true;
                    break;
                case 16:
                    textFieldPreparedSelection.moveCursorToLineLeftSide();
                    z10 = true;
                    break;
                case 17:
                    textFieldPreparedSelection.moveCursorToLineRightSide();
                    z10 = true;
                    break;
                case 18:
                    textFieldPreparedSelection.moveCursorToHome();
                    z10 = true;
                    break;
                case 19:
                    textFieldPreparedSelection.moveCursorToEnd();
                    z10 = true;
                    break;
                case 20:
                    if (TextRange.m6305getCollapsedimpl(textFieldPreparedSelection.getSelection())) {
                        Integer numValueOf = Integer.valueOf(textFieldPreparedSelection.getPrecedingCharacterIndex());
                        if (numValueOf.intValue() == -1) {
                            numValueOf = null;
                        }
                        textRangeM6299boximpl = numValueOf != null ? TextRange.m6299boximpl(TextRangeKt.TextRange(numValueOf.intValue(), TextRange.m6306getEndimpl(textFieldPreparedSelection.getSelection()))) : null;
                        if (textRangeM6299boximpl != null) {
                            TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textRangeM6299boximpl.getPackedValue(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                        }
                    } else {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textFieldPreparedSelection.getSelection(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    }
                    z10 = true;
                    break;
                case 21:
                    if (TextRange.m6305getCollapsedimpl(textFieldPreparedSelection.getSelection())) {
                        Integer numValueOf2 = Integer.valueOf(textFieldPreparedSelection.getNextCharacterIndex());
                        if (numValueOf2.intValue() == -1) {
                            numValueOf2 = null;
                        }
                        textRangeM6299boximpl = numValueOf2 != null ? TextRange.m6299boximpl(TextRangeKt.TextRange(TextRange.m6311getStartimpl(textFieldPreparedSelection.getSelection()), numValueOf2.intValue())) : null;
                        if (textRangeM6299boximpl != null) {
                            TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textRangeM6299boximpl.getPackedValue(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                        }
                    } else {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textFieldPreparedSelection.getSelection(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    }
                    z10 = true;
                    break;
                case 22:
                    if (TextRange.m6305getCollapsedimpl(textFieldPreparedSelection.getSelection())) {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", TextRangeKt.TextRange(textFieldPreparedSelection.getPreviousWordOffset(), TextRange.m6306getEndimpl(textFieldPreparedSelection.getSelection())), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    } else {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textFieldPreparedSelection.getSelection(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    }
                    z10 = true;
                    break;
                case 23:
                    if (TextRange.m6305getCollapsedimpl(textFieldPreparedSelection.getSelection())) {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", TextRangeKt.TextRange(TextRange.m6311getStartimpl(textFieldPreparedSelection.getSelection()), textFieldPreparedSelection.getNextWordOffset()), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    } else {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textFieldPreparedSelection.getSelection(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    }
                    z10 = true;
                    break;
                case 24:
                    if (TextRange.m6305getCollapsedimpl(textFieldPreparedSelection.getSelection())) {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", TextRangeKt.TextRange(textFieldPreparedSelection.getLineStartByOffset(), TextRange.m6306getEndimpl(textFieldPreparedSelection.getSelection())), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    } else {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textFieldPreparedSelection.getSelection(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    }
                    z10 = true;
                    break;
                case 25:
                    if (TextRange.m6305getCollapsedimpl(textFieldPreparedSelection.getSelection())) {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", TextRangeKt.TextRange(TextRange.m6311getStartimpl(textFieldPreparedSelection.getSelection()), textFieldPreparedSelection.getLineEndByOffset()), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    } else {
                        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(textFieldPreparedSelection.state, "", textFieldPreparedSelection.getSelection(), null, !textFieldPreparedSelection.isFromSoftKeyboard, 4, null);
                    }
                    z10 = true;
                    break;
                case 26:
                    if (singleLine) {
                        onSubmit.invoke();
                    } else {
                        TextFieldState textFieldState3 = textFieldState.textFieldState;
                        InputTransformation inputTransformation2 = textFieldState.inputTransformation;
                        TextFieldEditUndoBehavior textFieldEditUndoBehavior2 = TextFieldEditUndoBehavior.MergeIfPossible;
                        textFieldState3.getMainBuffer().getChangeTracker().clearChanges();
                        EditingBuffer mainBuffer2 = textFieldState3.getMainBuffer();
                        mainBuffer2.commitComposition();
                        EditCommandKt.commitText(mainBuffer2, "\n", 1);
                        textFieldState3.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior2);
                    }
                    z10 = true;
                    break;
                case 27:
                    if (!singleLine) {
                        TextFieldState textFieldState4 = textFieldState.textFieldState;
                        InputTransformation inputTransformation3 = textFieldState.inputTransformation;
                        TextFieldEditUndoBehavior textFieldEditUndoBehavior3 = TextFieldEditUndoBehavior.MergeIfPossible;
                        textFieldState4.getMainBuffer().getChangeTracker().clearChanges();
                        EditingBuffer mainBuffer3 = textFieldState4.getMainBuffer();
                        mainBuffer3.commitComposition();
                        EditCommandKt.commitText(mainBuffer3, "\t", 1);
                        textFieldState4.commitEditAsUser(inputTransformation3, true, textFieldEditUndoBehavior3);
                        z10 = true;
                        break;
                    }
                    break;
                case 28:
                    textFieldPreparedSelection.selectAll();
                    z10 = true;
                    break;
                case 29:
                    textFieldPreparedSelection.moveCursorLeft().selectMovement();
                    z10 = true;
                    break;
                case 30:
                    textFieldPreparedSelection.moveCursorRight().selectMovement();
                    z10 = true;
                    break;
                case 31:
                    textFieldPreparedSelection.moveCursorLeftByWord().selectMovement();
                    z10 = true;
                    break;
                case 32:
                    textFieldPreparedSelection.moveCursorRightByWord().selectMovement();
                    z10 = true;
                    break;
                case 33:
                    textFieldPreparedSelection.moveCursorPrevByParagraph().selectMovement();
                    z10 = true;
                    break;
                case 34:
                    textFieldPreparedSelection.moveCursorNextByParagraph().selectMovement();
                    z10 = true;
                    break;
                case 35:
                    textFieldPreparedSelection.moveCursorToLineStart().selectMovement();
                    z10 = true;
                    break;
                case 36:
                    textFieldPreparedSelection.moveCursorToLineEnd().selectMovement();
                    z10 = true;
                    break;
                case 37:
                    textFieldPreparedSelection.moveCursorToLineLeftSide().selectMovement();
                    z10 = true;
                    break;
                case 38:
                    textFieldPreparedSelection.moveCursorToLineRightSide().selectMovement();
                    z10 = true;
                    break;
                case 39:
                    textFieldPreparedSelection.moveCursorUpByLine().selectMovement();
                    z10 = true;
                    break;
                case 40:
                    textFieldPreparedSelection.moveCursorDownByLine().selectMovement();
                    z10 = true;
                    break;
                case 41:
                    textFieldPreparedSelection.moveCursorUpByPage().selectMovement();
                    z10 = true;
                    break;
                case 42:
                    textFieldPreparedSelection.moveCursorDownByPage().selectMovement();
                    z10 = true;
                    break;
                case 43:
                    textFieldPreparedSelection.moveCursorToHome().selectMovement();
                    z10 = true;
                    break;
                case 44:
                    textFieldPreparedSelection.moveCursorToEnd().selectMovement();
                    z10 = true;
                    break;
                case 45:
                    textFieldPreparedSelection.deselect();
                    z10 = true;
                    break;
                case 46:
                    textFieldState.undo();
                    z10 = true;
                    break;
                case 47:
                    textFieldState.redo();
                    z10 = true;
                    break;
                case 48:
                    KeyEventHelpers_androidKt.showCharacterPalette();
                    z10 = true;
                    break;
                default:
                    z10 = true;
                    break;
            }
            if (!TextRange.m6304equalsimpl0(textFieldPreparedSelection.getSelection(), textFieldPreparedSelection.getInitialValue().getSelection())) {
                textFieldState.m1268selectCharsIn5zctL8(textFieldPreparedSelection.getSelection());
            }
        }
        return z10;
    }

    /* renamed from: onPreKeyEvent-MyFupTE */
    public boolean mo1168onPreKeyEventMyFupTE(KeyEvent event, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController keyboardController) {
        if (TextRange.m6305getCollapsedimpl(textFieldState.getVisualText().getSelection()) || !KeyEventHelpers_androidKt.m1024cancelsTextSelectionZmokQxo(event)) {
            return false;
        }
        textFieldSelectionState.deselect();
        return true;
    }
}
