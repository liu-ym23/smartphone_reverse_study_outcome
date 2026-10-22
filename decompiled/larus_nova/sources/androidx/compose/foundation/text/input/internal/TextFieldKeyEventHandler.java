package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.SelectionMovementDeletionContext;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J]\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0016¢\u0006\u0004\b#\u0010$JU\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002¢\u0006\u0004\b&\u0010'J\f\u0010(\u001a\u00020)*\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "<init>", "()V", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "currentlyConsumedDownKeys", "Landroidx/collection/MutableLongSet;", "onPreKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "processKeyDownEvent", "processKeyDownEvent-q0GpTC0", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "getVisibleTextLayoutHeight", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private MutableLongSet currentlyConsumedDownKeys;
    private final DeadKeyCombiner deadKeyCombiner;
    private final KeyMapping keyMapping;
    private final TextFieldPreparedSelectionState preparedSelectionState;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[KeyCommand.values().length];
            r100[KeyCommand.COPY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
        L133:
            r100[KeyCommand.PASTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
        L151:
            r100[KeyCommand.CUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L56
        L165:
            r100[KeyCommand.LEFT_CHAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L57
        L169:
            r100[KeyCommand.RIGHT_CHAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L58
        L179:
            r100[KeyCommand.LEFT_WORD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L59
        L193:
            r100[KeyCommand.RIGHT_WORD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L60
        L121:
            r100[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;     // Catch: NoSuchFieldError -> L61
        L137:
            r100[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;     // Catch: NoSuchFieldError -> L62
        L141:
            r100[KeyCommand.UP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L63
        L157:
            r100[KeyCommand.DOWN.ordinal()] = 11;     // Catch: NoSuchFieldError -> L64
        L185:
            r100[KeyCommand.PAGE_UP.ordinal()] = 12;     // Catch: NoSuchFieldError -> L65
        L199:
            r100[KeyCommand.PAGE_DOWN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L66
        L105:
            r100[KeyCommand.LINE_START.ordinal()] = 14;     // Catch: NoSuchFieldError -> L67
        L117:
            r100[KeyCommand.LINE_END.ordinal()] = 15;     // Catch: NoSuchFieldError -> L68
        L147:
            r100[KeyCommand.LINE_LEFT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L69
        L163:
            r100[KeyCommand.LINE_RIGHT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L70
        L167:
            r100[KeyCommand.HOME.ordinal()] = 18;     // Catch: NoSuchFieldError -> L71
        L181:
            r100[KeyCommand.END.ordinal()] = 19;     // Catch: NoSuchFieldError -> L72
        L109:
            r100[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;     // Catch: NoSuchFieldError -> L73
        L125:
            r100[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;     // Catch: NoSuchFieldError -> L74
        L127:
            r100[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;     // Catch: NoSuchFieldError -> L75
        L143:
            r100[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;     // Catch: NoSuchFieldError -> L76
        L173:
            r100[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;     // Catch: NoSuchFieldError -> L77
        L187:
            r100[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;     // Catch: NoSuchFieldError -> L78
        L189:
            r100[KeyCommand.NEW_LINE.ordinal()] = 26;     // Catch: NoSuchFieldError -> L79
        L107:
            r100[KeyCommand.TAB.ordinal()] = 27;     // Catch: NoSuchFieldError -> L80
        L131:
            r100[KeyCommand.SELECT_ALL.ordinal()] = 28;     // Catch: NoSuchFieldError -> L81
        L149:
            r100[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;     // Catch: NoSuchFieldError -> L82
        L153:
            r100[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;     // Catch: NoSuchFieldError -> L83
        L171:
            r100[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;     // Catch: NoSuchFieldError -> L84
        L195:
            r100[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;     // Catch: NoSuchFieldError -> L85
        L111:
            r100[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;     // Catch: NoSuchFieldError -> L86
        L113:
            r100[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;     // Catch: NoSuchFieldError -> L87
        L129:
            r100[KeyCommand.SELECT_LINE_START.ordinal()] = 35;     // Catch: NoSuchFieldError -> L88
        L159:
            r100[KeyCommand.SELECT_LINE_END.ordinal()] = 36;     // Catch: NoSuchFieldError -> L89
        L175:
            r100[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;     // Catch: NoSuchFieldError -> L90
        L177:
            r100[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;     // Catch: NoSuchFieldError -> L91
        L191:
            r100[KeyCommand.SELECT_UP.ordinal()] = 39;     // Catch: NoSuchFieldError -> L92
        L119:
            r100[KeyCommand.SELECT_DOWN.ordinal()] = 40;     // Catch: NoSuchFieldError -> L93
        L135:
            r100[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;     // Catch: NoSuchFieldError -> L94
        L139:
            r100[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;     // Catch: NoSuchFieldError -> L95
        L155:
            r100[KeyCommand.SELECT_HOME.ordinal()] = 43;     // Catch: NoSuchFieldError -> L96
        L183:
            r100[KeyCommand.SELECT_END.ordinal()] = 44;     // Catch: NoSuchFieldError -> L97
        L197:
            r100[KeyCommand.DESELECT.ordinal()] = 45;     // Catch: NoSuchFieldError -> L98
        L103:
            r100[KeyCommand.UNDO.ordinal()] = 46;     // Catch: NoSuchFieldError -> L99
        L115:
            r100[KeyCommand.REDO.ordinal()] = 47;     // Catch: NoSuchFieldError -> L100
        L145:
            r100[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;     // Catch: NoSuchFieldError -> L101
        L161:
            r100[KeyCommand.CENTER.ordinal()] = 49;     // Catch: NoSuchFieldError -> L102
        L52:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static /* synthetic */ Unit a(SelectionMovementDeletionContext r100) {
        return processKeyDownEvent_q0GpTC0$lambda$4$lambda$1(r100);
    }

    public static /* synthetic */ Unit b(SelectionMovementDeletionContext r100) {
        return processKeyDownEvent_q0GpTC0$lambda$4$lambda$2(r100);
    }

    public TextFieldKeyEventHandler() {
        this.preparedSelectionState = new TextFieldPreparedSelectionState();
        this.deadKeyCombiner = new DeadKeyCombiner();
        this.keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState r100) {
        LayoutCoordinates r101 = r100.getTextLayoutNodeCoordinates();
        if (r101 == null) goto L19;
        Rect r102 = null;
        if (r101.isAttached() == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L19;
        LayoutCoordinates r103 = r100.getDecoratorNodeCoordinates();
        if (r103 != null) goto L12;
    L17:
        if (r102 == null) goto L19;
        return Float.intBitsToFloat((int) (r102.m4615getSizeNHjbRc() & BodyPartID.bodyIdMax));
    L12:
        if (r103.isAttached() == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        r102 = LayoutCoordinates.CC.localBoundingBoxOf$default(r103, r101, false, 2, null);
    L19:
        return Float.NaN;
    }

    private static final Unit processKeyDownEvent_q0GpTC0$lambda$4$lambda$1(SelectionMovementDeletionContext r100) {
        r100.moveCursorLeftByChar();
        return Unit.INSTANCE;
    }

    private static final Unit processKeyDownEvent_q0GpTC0$lambda$4$lambda$2(SelectionMovementDeletionContext r100) {
        r100.moveCursorRightByChar();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: onPreKeyEvent-MyFupTE */
    public boolean mo1224onPreKeyEventMyFupTE(KeyEvent r100, TransformedTextFieldState r101, TextFieldSelectionState r102, FocusManager r103, SoftwareKeyboardController r104) {
        if (TextRange.m6992getCollapsedimpl(r101.getVisualText().m1197getSelectiond9O1mEE()) == false) goto L5;
    L7:
        return false;
    L5:
        if (KeyEventHelpers_androidKt.m1051cancelsTextSelectionZmokQxo(r100) == false) goto L7;
        r102.deselect();
        return true;
    }

    /* JADX INFO: renamed from: processKeyDownEvent-q0GpTC0, reason: not valid java name */
    private final boolean m1294processKeyDownEventq0GpTC0(KeyEvent r110, TransformedTextFieldState r111, TextLayoutState r112, Function1<? super KeyCommand, ? extends Unit> r113, SoftwareKeyboardController r114, boolean r115, boolean r210, Function0<Boolean> r211) {
        boolean r100 = false;
        if (TextFieldKeyInput_androidKt.m1150isTypedEventZmokQxo(r110) == false) goto L10;
        Integer r101 = this.deadKeyCombiner.m1050consumeZmokQxo(r110);
        if (r101 == null) goto L10;
        String r102 = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(2), r101.intValue()).toString();
        if (r115 == false) goto L99;
        TransformedTextFieldState.replaceSelectedText$default(r111, r102, true, null, !TextFieldKeyEventHandler_androidKt.m1296isFromSoftKeyboardZmokQxo(r110), 4, null);
        this.preparedSelectionState.resetCachedX();
        return true;
    L99:
        return false;
    L10:
        KeyCommand r116 = this.keyMapping.mo1052mapZmokQxo(r110);
        if (r116 != null) goto L13;
    L98:
        return r100;
    L13:
        if (r116.getEditsText() == false) goto L16;
        if (r115 == false) goto L98;
    L16:
        SelectionMovementDeletionContext r117 = new SelectionMovementDeletionContext(r111, r112.getLayoutResult(), TextFieldKeyEventHandler_androidKt.m1296isFromSoftKeyboardZmokQxo(r110), getVisibleTextLayoutHeight(r112), this.preparedSelectionState);
        switch(WhenMappings.$EnumSwitchMapping$0[r116.ordinal()]) {
            case 1: goto L74;
            case 2: goto L74;
            case 3: goto L74;
            case 4: goto L73;
            case 5: goto L72;
            case 6: goto L71;
            case 7: goto L70;
            case 8: goto L69;
            case 9: goto L68;
            case 10: goto L67;
            case 11: goto L66;
            case 12: goto L65;
            case 13: goto L64;
            case 14: goto L63;
            case 15: goto L62;
            case 16: goto L61;
            case 17: goto L60;
            case 18: goto L59;
            case 19: goto L58;
            case 20: goto L57;
            case 21: goto L56;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L53;
            case 25: goto L52;
            case 26: goto L48;
            case 27: goto L45;
            case 28: goto L44;
            case 29: goto L43;
            case 30: goto L42;
            case 31: goto L41;
            case 32: goto L40;
            case 33: goto L39;
            case 34: goto L38;
            case 35: goto L37;
            case 36: goto L36;
            case 37: goto L35;
            case 38: goto L34;
            case 39: goto L33;
            case 40: goto L32;
            case 41: goto L31;
            case 42: goto L30;
            case 43: goto L29;
            case 44: goto L28;
            case 45: goto L27;
            case 46: goto L26;
            case 47: goto L25;
            case 48: goto L24;
            case 49: goto L21;
            default: goto L19;
        };
    L24:
        KeyEventHelpers_androidKt.showCharacterPalette();
        Unit r103 = Unit.INSTANCE;
    L75:
        r100 = true;
    L77:
        if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled == false) goto L88;
        if (r116 != KeyCommand.UP) goto L81;
    L86:
        r100 = !TextRange.m6991equalsimpl0(r117.getInitialValue().m1197getSelectiond9O1mEE(), r117.m1344getSelectiond9O1mEE());
        goto L88
    L81:
        if (r116 == KeyCommand.DOWN) goto L86;
        if (r116 == KeyCommand.LEFT_CHAR) goto L86;
        if (r116 == KeyCommand.RIGHT_CHAR) goto L86;
    L88:
        if (TextRange.m6991equalsimpl0(r117.m1344getSelectiond9O1mEE(), r117.getInitialValue().m1197getSelectiond9O1mEE()) == true) goto L91;
        r111.m1324selectCharsIn5zctL8(r117.m1344getSelectiond9O1mEE());
    L91:
        if (r117.getWedgeAffinity() == null) goto L98;
        WedgeAffinity r104 = r117.getWedgeAffinity();
        if (r104 == null) goto L98;
        if (TextRange.m6992getCollapsedimpl(r111.getUntransformedText().m1197getSelectiond9O1mEE()) == false) goto L97;
        r111.setSelectionWedgeAffinity(new SelectionWedgeAffinity(r104));
        goto L98
    L97:
        r111.setSelectionWedgeAffinity(SelectionWedgeAffinity.copy$default(r117.getInitialWedgeAffinity(), null, r104, 1, null));
        goto L98
    L25:
        r111.redo();
        Unit r105 = Unit.INSTANCE;
        goto L75
    L26:
        r111.undo();
        Unit r106 = Unit.INSTANCE;
        goto L75
    L27:
        r117.deselect();
        goto L75
    L28:
        r117.moveCursorToEnd().selectMovement();
        goto L75
    L29:
        r117.moveCursorToHome().selectMovement();
        goto L75
    L30:
        r117.moveCursorDownByPage().selectMovement();
        goto L75
    L31:
        r117.moveCursorUpByPage().selectMovement();
        goto L75
    L32:
        r117.moveCursorDownByLine().selectMovement();
        goto L75
    L33:
        r117.moveCursorUpByLine().selectMovement();
        goto L75
    L34:
        r117.moveCursorToLineRightSide().selectMovement();
        goto L75
    L35:
        r117.moveCursorToLineLeftSide().selectMovement();
        goto L75
    L36:
        r117.moveCursorToLineEnd().selectMovement();
        goto L75
    L37:
        r117.moveCursorToLineStart().selectMovement();
        goto L75
    L38:
        r117.moveCursorNextByParagraph().selectMovement();
        goto L75
    L39:
        r117.moveCursorPrevByParagraph().selectMovement();
        goto L75
    L40:
        r117.moveCursorRightByWord().selectMovement();
        goto L75
    L41:
        r117.moveCursorLeftByWord().selectMovement();
        goto L75
    L42:
        r117.moveCursorRightByChar().selectMovement();
        goto L75
    L43:
        r117.moveCursorLeftByChar().selectMovement();
        goto L75
    L44:
        r117.selectAll();
        goto L75
    L45:
        if (r210 == true) goto L47;
        TransformedTextFieldState.replaceSelectedText$default(r111, "\t", true, null, !TextFieldKeyEventHandler_androidKt.m1296isFromSoftKeyboardZmokQxo(r110), 4, null);
        r100 = true;
    L47:
        Unit r107 = Unit.INSTANCE;
        goto L77
    L48:
        if (r210 == true) goto L50;
        TransformedTextFieldState.replaceSelectedText$default(r111, "\n", true, null, !TextFieldKeyEventHandler_androidKt.m1296isFromSoftKeyboardZmokQxo(r110), 4, null);
        r100 = true;
    L51:
        Unit r108 = Unit.INSTANCE;
        goto L77
    L50:
        r100 = r211.invoke().booleanValue();
        goto L51
    L52:
        r117.moveCursorToLineEnd().deleteMovement();
        goto L75
    L53:
        r117.moveCursorToLineStart().deleteMovement();
        goto L75
    L54:
        r117.moveCursorNextByWord().deleteMovement();
        goto L75
    L55:
        r117.moveCursorPrevByWord().deleteMovement();
        goto L75
    L56:
        r117.moveCursorNextByChar().deleteMovement();
        goto L75
    L57:
        r117.moveCursorPrevByCodePointOrEmoji().deleteMovement();
        goto L75
    L58:
        r117.moveCursorToEnd();
        goto L75
    L59:
        r117.moveCursorToHome();
        goto L75
    L60:
        r117.moveCursorToLineRightSide();
        goto L75
    L61:
        r117.moveCursorToLineLeftSide();
        goto L75
    L62:
        r117.moveCursorToLineEnd();
        goto L75
    L63:
        r117.moveCursorToLineStart();
        goto L75
    L64:
        r117.moveCursorDownByPage();
        goto L75
    L65:
        r117.moveCursorUpByPage();
        goto L75
    L66:
        r117.moveCursorDownByLine();
        goto L75
    L67:
        r117.moveCursorUpByLine();
        goto L75
    L68:
        r117.moveCursorNextByParagraph();
        goto L75
    L69:
        r117.moveCursorPrevByParagraph();
        goto L75
    L70:
        r117.moveCursorRightByWord();
        goto L75
    L71:
        r117.moveCursorLeftByWord();
        goto L75
    L72:
        r117.collapseRightOr(new x1());
        goto L75
    L73:
        r117.collapseLeftOr(new w1());
        goto L75
    L74:
        r113.invoke(r116);
        Unit r109 = Unit.INSTANCE;
        goto L75
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled == false) goto L23;
        r114.show();
        r100 = true;
    L23:
        Unit r118 = Unit.INSTANCE;
        goto L77
    }

    /* JADX INFO: renamed from: onKeyEvent-8zsqlwg */
    public boolean mo1223onKeyEvent8zsqlwg(KeyEvent r110, TransformedTextFieldState r111, TextLayoutState r112, TextFieldSelectionState r113, Function1<? super KeyCommand, ? extends Unit> r114, SoftwareKeyboardController r115, boolean r116, boolean r210, Function0<Boolean> r211) {
        long r117 = KeyEvent_androidKt.m5977getKeyZmokQxo(r110);
        int r100 = KeyEvent_androidKt.m5978getTypeZmokQxo(r110);
        KeyEventType.Companion r101 = KeyEventType.Companion;
        if (KeyEventType.m5970equalsimpl0(r100, r101.m5975getKeyUpCS__XNY()) == false) goto L17;
        MutableLongSet r102 = this.currentlyConsumedDownKeys;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L15;
        MutableLongSet r104 = this.currentlyConsumedDownKeys;
        if (r104 == null) goto L14;
        r104.remove(r117);
    L14:
        return true;
    L15:
        return false;
    L7:
        if (r102.contains(r117) != true) goto L9;
        r103 = true;
        goto L10
    L17:
        if (KeyEventType.m5970equalsimpl0(KeyEvent_androidKt.m5978getTypeZmokQxo(r110), r101.m5976getUnknownCS__XNY()) == true) goto L19;
    L21:
        boolean r105 = m1294processKeyDownEventq0GpTC0(r110, r111, r112, r114, r115, r116, r210, r211);
        if (r105 == false) goto L27;
        MutableLongSet r106 = this.currentlyConsumedDownKeys;
        if (r106 != null) goto L26;
        r106 = new MutableLongSet(3);
        this.currentlyConsumedDownKeys = r106;
    L26:
        r106.plusAssign(r117);
    L27:
        return r105;
    L19:
        if (TextFieldKeyInput_androidKt.m1150isTypedEventZmokQxo(r110) == true) goto L21;
        return false;
    }
}
