package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010,\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020.0-H\u0002J\f\u0010,\u001a\u00020\u0017*\u00020.H\u0002J\u0019\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u00101\u001a\u000202¢\u0006\u0004\b6\u00107J!\u00108\u001a\u00020\u00172\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b;H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006<"}, d2 = {"Landroidx/compose/foundation/text/TextFieldKeyInput;", "", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "selectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "preparedSelectionState", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "keyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "onValueChange", "Lkotlin/Function1;", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "<init>", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/DeadKeyCombiner;Landroidx/compose/foundation/text/KeyMapping;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getEditable", "()Z", "getSingleLine", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "I", com.bytedance.android.livesdk.chatroom.model.interact.e1.REPLY_ACTION_APPLY, "", "Landroidx/compose/ui/text/input/EditCommand;", "typedCommand", "Landroidx/compose/ui/text/input/CommitTextCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "process", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "commandExecutionContext", "block", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldKeyInput {
    public static final int $stable = 8;
    private final boolean editable;
    private final int imeAction;
    private final DeadKeyCombiner keyCombiner;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final LegacyTextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

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

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState r100, TextFieldSelectionManager r101, TextFieldValue r102, boolean r103, boolean r104, TextPreparedSelectionState r105, OffsetMapping r106, UndoManager r107, DeadKeyCombiner r108, KeyMapping r110, Function1 r111, int r112, DefaultConstructorMarker r113) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112);
    }

    public static /* synthetic */ EditCommand a(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$12(r100);
    }

    public static /* synthetic */ EditCommand b(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$8(r100);
    }

    public static /* synthetic */ EditCommand c(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$6(r100);
    }

    public static /* synthetic */ EditCommand d(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$10(r100);
    }

    public static /* synthetic */ Unit e(TextFieldValue r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ EditCommand f(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$5(r100);
    }

    public static /* synthetic */ Unit g(KeyCommand r100, TextFieldKeyInput r101, Ref.BooleanRef r102, TextFieldPreparedSelection r103) {
        return process_ZmokQxo$lambda$17(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit h(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$3(r100);
    }

    public static /* synthetic */ Unit i(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$4(r100);
    }

    public static /* synthetic */ EditCommand j(TextFieldPreparedSelection r100) {
        return process_ZmokQxo$lambda$17$lambda$14(r100);
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    private static final Unit _init_$lambda$0(TextFieldValue r100) {
        return Unit.INSTANCE;
    }

    private final void apply(List<? extends EditCommand> r100) {
        EditProcessor r101 = this.state.getProcessor();
        List<? extends EditCommand> r102 = CollectionsKt.toMutableList(r100);
        ListProtector.add(r102, 0, new FinishComposingTextCommand());
        TextFieldValue r103 = r101.apply(r102);
        this.onValueChange.invoke(r103);
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> r100) {
        TextFieldPreparedSelection r101 = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        r100.invoke(r101);
        if (TextRange.m6991equalsimpl0(r101.m1437getSelectiond9O1mEE(), this.value.m7249getSelectiond9O1mEE()) == true) goto L5;
    L6:
        this.onValueChange.invoke(r101.getValue());
        return;
    L5:
        if (Intrinsics.areEqual(r101.getAnnotatedString(), this.value.getAnnotatedString()) == false) goto L6;
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$10(TextFieldPreparedSelection r100) {
        Integer r101 = r100.getNextWordOffset();
        if (r101 != null) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(0, r101.intValue() - TextRange.m6993getEndimpl(r100.m1437getSelectiond9O1mEE()));
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$12(TextFieldPreparedSelection r100) {
        Integer r101 = r100.getLineStartByOffset();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        return new DeleteSurroundingTextCommand(TextRange.m6993getEndimpl(r100.m1437getSelectiond9O1mEE()) - r102, 0);
    L5:
        return null;
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$14(TextFieldPreparedSelection r100) {
        Integer r101 = r100.getLineEndByOffset();
        if (r101 != null) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(0, r101.intValue() - TextRange.m6993getEndimpl(r100.m1437getSelectiond9O1mEE()));
    }

    private static final Unit process_ZmokQxo$lambda$17$lambda$3(TextFieldPreparedSelection r100) {
        r100.moveCursorLeft();
        return Unit.INSTANCE;
    }

    private static final Unit process_ZmokQxo$lambda$17$lambda$4(TextFieldPreparedSelection r100) {
        r100.moveCursorRight();
        return Unit.INSTANCE;
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$5(TextFieldPreparedSelection r100) {
        int r101 = r100.getPrecedingCodePointOrEmojiStartIndex();
        if (r101 != (-1)) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(TextRange.m6993getEndimpl(r100.m1437getSelectiond9O1mEE()) - r101, 0);
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$6(TextFieldPreparedSelection r100) {
        int r101 = r100.getNextCharacterIndex();
        if (r101 != (-1)) goto L7;
        return null;
    L7:
        return new DeleteSurroundingTextCommand(0, r101 - TextRange.m6993getEndimpl(r100.m1437getSelectiond9O1mEE()));
    }

    private static final EditCommand process_ZmokQxo$lambda$17$lambda$8(TextFieldPreparedSelection r100) {
        Integer r101 = r100.getPreviousWordOffset();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        return new DeleteSurroundingTextCommand(TextRange.m6993getEndimpl(r100.m1437getSelectiond9O1mEE()) - r102, 0);
    L5:
        return null;
    }

    /* JADX INFO: renamed from: typedCommand-ZmokQxo, reason: not valid java name */
    private final CommitTextCommand m1145typedCommandZmokQxo(KeyEvent r100) {
        if (TextFieldKeyInput_androidKt.m1150isTypedEventZmokQxo(r100) == true) goto L5;
        return null;
    L5:
        Integer r101 = this.keyCombiner.m1050consumeZmokQxo(r100);
        if (r101 == null) goto L9;
        int r102 = r101.intValue();
        return new CommitTextCommand(StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), r102).toString(), 1);
    L9:
        return null;
    }

    /* JADX INFO: renamed from: process-ZmokQxo, reason: not valid java name */
    public final boolean m1146processZmokQxo(KeyEvent r100) {
        CommitTextCommand r101 = m1145typedCommandZmokQxo(r100);
        if (r101 == null) goto L10;
        if (this.editable == false) goto L7;
        apply(r101);
        this.preparedSelectionState.resetCachedX();
        return true;
    L7:
        return false;
    L10:
        if (KeyEventType.m5970equalsimpl0(KeyEvent_androidKt.m5978getTypeZmokQxo(r100), KeyEventType.Companion.m5974getKeyDownCS__XNY()) == true) goto L12;
        return false;
    L12:
        final KeyCommand r102 = this.keyMapping.mo1052mapZmokQxo(r100);
        if (r102 != null) goto L15;
    L24:
        return false;
    L15:
        if (r102.getEditsText() == true) goto L17;
    L19:
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = true;
        commandExecutionContext(new u3(r102, this, r103));
        UndoManager r104 = this.undoManager;
        if (r104 == null) goto L23;
        r104.forceNextSnapshot();
    L23:
        return r103.element;
    L17:
        if (this.editable == true) goto L19;
        goto L19
    }

    private final void apply(EditCommand r100) {
        apply(CollectionsKt.listOf(r100));
    }

    private static final Unit process_ZmokQxo$lambda$17(KeyCommand r100, TextFieldKeyInput r101, Ref.BooleanRef r102, TextFieldPreparedSelection r103) {
        if (r100 != null) goto L4;
        int r104 = -1;
    L6:
        switch(r104) {
            case 1: goto L88;
            case 2: goto L87;
            case 3: goto L86;
            case 4: goto L85;
            case 5: goto L84;
            case 6: goto L83;
            case 7: goto L82;
            case 8: goto L81;
            case 9: goto L80;
            case 10: goto L79;
            case 11: goto L78;
            case 12: goto L77;
            case 13: goto L76;
            case 14: goto L75;
            case 15: goto L74;
            case 16: goto L73;
            case 17: goto L72;
            case 18: goto L71;
            case 19: goto L70;
            case 20: goto L67;
            case 21: goto L64;
            case 22: goto L61;
            case 23: goto L58;
            case 24: goto L55;
            case 25: goto L52;
            case 26: goto L48;
            case 27: goto L43;
            case 28: goto L41;
            case 29: goto L40;
            case 30: goto L39;
            case 31: goto L38;
            case 32: goto L37;
            case 33: goto L36;
            case 34: goto L35;
            case 35: goto L34;
            case 36: goto L33;
            case 37: goto L32;
            case 38: goto L31;
            case 39: goto L30;
            case 40: goto L29;
            case 41: goto L28;
            case 42: goto L27;
            case 43: goto L26;
            case 44: goto L25;
            case 45: goto L24;
            case 46: goto L16;
            case 47: goto L11;
            case 48: goto L9;
            case 49: goto L10;
            default: goto L8;
        };
    L9:
        KeyEventHelpers_androidKt.showCharacterPalette();
    L10:
        Unit r105 = Unit.INSTANCE;
    L90:
        return Unit.INSTANCE;
    L11:
        UndoManager r106 = r101.undoManager;
        if (r106 == null) goto L90;
        TextFieldValue r107 = r106.redo();
        if (r107 == null) goto L90;
        r101.onValueChange.invoke(r107);
        Unit r108 = Unit.INSTANCE;
        goto L90
    L16:
        UndoManager r109 = r101.undoManager;
        if (r109 == null) goto L19;
        r109.makeSnapshot(r103.getValue());
    L19:
        UndoManager r110 = r101.undoManager;
        if (r110 == null) goto L90;
        TextFieldValue r111 = r110.undo();
        if (r111 == null) goto L90;
        r101.onValueChange.invoke(r111);
        Unit r112 = Unit.INSTANCE;
        goto L90
    L24:
        r103.deselect();
        goto L90
    L25:
        r103.moveCursorToEnd().selectMovement();
        goto L90
    L26:
        r103.moveCursorToHome().selectMovement();
        goto L90
    L27:
        r103.moveCursorDownByPage().selectMovement();
        goto L90
    L28:
        r103.moveCursorUpByPage().selectMovement();
        goto L90
    L29:
        r103.moveCursorDownByLine().selectMovement();
        goto L90
    L30:
        r103.moveCursorUpByLine().selectMovement();
        goto L90
    L31:
        r103.moveCursorToLineRightSide().selectMovement();
        goto L90
    L32:
        r103.moveCursorToLineLeftSide().selectMovement();
        goto L90
    L33:
        r103.moveCursorToLineEnd().selectMovement();
        goto L90
    L34:
        r103.moveCursorToLineStart().selectMovement();
        goto L90
    L35:
        r103.moveCursorNextByParagraph().selectMovement();
        goto L90
    L36:
        r103.moveCursorPrevByParagraph().selectMovement();
        goto L90
    L37:
        r103.moveCursorRightByWord().selectMovement();
        goto L90
    L38:
        r103.moveCursorLeftByWord().selectMovement();
        goto L90
    L39:
        r103.moveCursorRight().selectMovement();
        goto L90
    L40:
        r103.moveCursorLeft().selectMovement();
        goto L90
    L41:
        r103.selectAll();
        goto L90
    L52:
        List<EditCommand> r113 = r103.deleteIfSelectedOr(new s3());
        if (r113 == null) goto L90;
        r101.apply(r113);
        Unit r114 = Unit.INSTANCE;
        goto L90
    L55:
        List<EditCommand> r115 = r103.deleteIfSelectedOr(new r3());
        if (r115 == null) goto L90;
        r101.apply(r115);
        Unit r116 = Unit.INSTANCE;
        goto L90
    L58:
        List<EditCommand> r117 = r103.deleteIfSelectedOr(new q3());
        if (r117 == null) goto L90;
        r101.apply(r117);
        Unit r118 = Unit.INSTANCE;
        goto L90
    L61:
        List<EditCommand> r119 = r103.deleteIfSelectedOr(new p3());
        if (r119 == null) goto L90;
        r101.apply(r119);
        Unit r120 = Unit.INSTANCE;
        goto L90
    L64:
        List<EditCommand> r121 = r103.deleteIfSelectedOr(new o3());
        if (r121 == null) goto L90;
        r101.apply(r121);
        Unit r122 = Unit.INSTANCE;
        goto L90
    L67:
        List<EditCommand> r123 = r103.deleteIfSelectedOr(new n3());
        if (r123 == null) goto L90;
        r101.apply(r123);
        Unit r124 = Unit.INSTANCE;
        goto L90
    L70:
        r103.moveCursorToEnd();
        goto L90
    L71:
        r103.moveCursorToHome();
        goto L90
    L72:
        r103.moveCursorToLineRightSide();
        goto L90
    L73:
        r103.moveCursorToLineLeftSide();
        goto L90
    L74:
        r103.moveCursorToLineEnd();
        goto L90
    L75:
        r103.moveCursorToLineStart();
        goto L90
    L76:
        r103.moveCursorDownByPage();
        goto L90
    L77:
        r103.moveCursorUpByPage();
        goto L90
    L78:
        r103.moveCursorDownByLine();
        goto L90
    L79:
        r103.moveCursorUpByLine();
        goto L90
    L80:
        r103.moveCursorNextByParagraph();
        goto L90
    L81:
        r103.moveCursorPrevByParagraph();
        goto L90
    L82:
        r103.moveCursorRightByWord();
        goto L90
    L83:
        r103.moveCursorLeftByWord();
        goto L90
    L84:
        r103.collapseRightOr(new m3());
        goto L90
    L85:
        r103.collapseLeftOr(new l3());
        goto L90
    L86:
        r101.selectionManager.cut$foundation_release();
        goto L90
    L87:
        r101.selectionManager.paste$foundation_release();
        goto L90
    L88:
        r101.selectionManager.copy$foundation_release(false);
        goto L90
    L8:
        throw new NoWhenBranchMatchedException();
    L43:
        if (r101.singleLine == true) goto L45;
        r101.apply(new CommitTextCommand("\t", 1));
    L46:
        Unit r125 = Unit.INSTANCE;
        goto L90
    L45:
        r102.element = false;
        goto L46
    L48:
        if (r101.singleLine == true) goto L50;
        r101.apply(new CommitTextCommand("\n", 1));
    L51:
        Unit r126 = Unit.INSTANCE;
        goto L90
    L50:
        r102.element = r101.state.getOnImeActionPerformedWithResult().invoke(ImeAction.m7164boximpl(r101.imeAction)).booleanValue();
        goto L51
    L4:
        r104 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldKeyInput(LegacyTextFieldState r100, TextFieldSelectionManager r101, TextFieldValue r102, boolean r103, boolean r104, TextPreparedSelectionState r105, OffsetMapping r106, UndoManager r107, DeadKeyCombiner r108, KeyMapping r110, Function1<? super TextFieldValue, Unit> r111, int r112) {
        this.state = r100;
        this.selectionManager = r101;
        this.value = r102;
        this.editable = r103;
        this.singleLine = r104;
        this.preparedSelectionState = r105;
        this.offsetMapping = r106;
        this.undoManager = r107;
        this.keyCombiner = r108;
        this.keyMapping = r110;
        this.onValueChange = r111;
        this.imeAction = r112;
    }

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState r210, TextFieldSelectionManager r211, TextFieldValue r212, boolean r213, boolean r214, TextPreparedSelectionState r215, OffsetMapping r310, UndoManager r311, DeadKeyCombiner r312, KeyMapping r313, Function1 r314, int r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 4) == 0) goto L5;
        TextFieldValue r110 = new TextFieldValue(null, 0, null, 7, null);
    L7:
        if ((r316 & 8) == 0) goto L9;
        boolean r111 = true;
    L11:
        if ((r316 & 16) == 0) goto L13;
        boolean r112 = false;
    L15:
        if ((r316 & 64) == 0) goto L17;
        OffsetMapping r113 = OffsetMapping.Companion.getIdentity();
    L19:
        if ((r316 & 128) == 0) goto L21;
        UndoManager r114 = null;
    L23:
        if ((r316 & 512) == 0) goto L25;
        KeyMapping r115 = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    L27:
        if ((r316 & 1024) == 0) goto L29;
        Function1 r216 = new t3();
    L30:
        this(r210, r211, r110, r111, r112, r215, r113, r114, r312, r115, r216, r315, null);
        return;
    L29:
        r216 = r314;
        goto L30
    L25:
        r115 = r313;
        goto L27
    L21:
        r114 = r311;
        goto L23
    L17:
        r113 = r310;
        goto L19
    L13:
        r112 = r214;
        goto L15
    L9:
        r111 = r213;
        goto L11
    L5:
        r110 = r212;
        goto L7
    }
}
