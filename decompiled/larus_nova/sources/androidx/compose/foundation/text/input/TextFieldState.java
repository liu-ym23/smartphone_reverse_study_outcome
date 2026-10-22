package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\\]B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\"\u0010/\u001a\u0002002\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0086\bJ\b\u00104\u001a\u00020\u0003H\u0016J\b\u0010:\u001a\u00020\u000fH\u0001J\u0010\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020\u000fH\u0001J\b\u0010=\u001a\u000200H\u0001JE\u0010>\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020C2\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bDJ'\u0010E\u001a\u0002002\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bFJ&\u0010G\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020CH\u0002J \u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u0017H\u0002J(\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020N2\u0006\u0010B\u001a\u00020CH\u0002J\u0015\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bRJ\u0015\u0010S\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bTJ%\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u0017H\u0001¢\u0006\u0002\bYR\u0014\u0010\u000b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u001e8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001d\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u00105\u001a\u0002068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0011\u001a\u0004\b8\u00109R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020Q0[X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "initialTextUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "<init>", "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "textUndoManager", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "mainBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "getMainBuffer$foundation_release$annotations", "()V", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "<set-?>", "", "isEditing", "()Z", "setEditing", "(Z)V", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "getValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value$delegate", "text", "", "getText", "()Ljava/lang/CharSequence;", "selection", "getSelection-d9O1mEE", "()J", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "edit", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toString", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "startEdit", "commitEdit", "newValue", "finishEditing", "editAsUser", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "restartImeIfContentChanges", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "editAsUser$foundation_release", "editWithNoSideEffects", "editWithNoSideEffects$foundation_release", "commitEditAsUser", "updateValueAndNotifyListeners", "oldValue", "recordEditForUndo", "previousValue", "postValue", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "addNotifyImeListener", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "addNotifyImeListener$foundation_release", "removeNotifyImeListener", "removeNotifyImeListener$foundation_release", "syncMainBufferToTemporaryBuffer", "temporaryBuffer", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer$foundation_release", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldState {
    public static final int $stable = 0;
    private final MutableState isEditing$delegate;
    private TextFieldBuffer mainBuffer;
    private final MutableVector<NotifyImeListener> notifyImeListeners;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;
    private final MutableState value$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "newValue", "restartIme", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence r100, TextFieldCharSequence r101, boolean r102);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "<init>", "()V", SVGRenderEngine.SAVE, "Landroidx/compose/runtime/saveable/SaverScope;", "value", SVGRenderEngine.RESTORE, "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = null;

        static {
            INSTANCE = new Saver();
        }

        private Saver() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.runtime.saveable.Saver
        public TextFieldState restore(Object r110) {
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List r111 = (List) r110;
            Object r100 = ListProtector.get(r111, 0);
            Object r101 = ListProtector.get(r111, 1);
            Object r102 = ListProtector.get(r111, 2);
            Object r112 = ListProtector.get(r111, 3);
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.String");
            String r103 = (String) r100;
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r104 = ((Integer) r101).intValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            long r105 = TextRangeKt.TextRange(r104, ((Integer) r102).intValue());
            TextUndoManager.Companion.Saver r106 = TextUndoManager.Companion.Saver.INSTANCE;
            Intrinsics.checkNotNull(r112);
            TextUndoManager r107 = r106.restore(r112);
            Intrinsics.checkNotNull(r107);
            return new TextFieldState(r103, r105, r107, null);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public /* bridge */ /* synthetic */ TextFieldState restore(Object r100) {
            return restore(r100);
        }

        /* JADX INFO: renamed from: save, reason: avoid collision after fix types in other method */
        public Object save2(SaverScope r100, TextFieldState r101) {
            return CollectionsKt.listOf(new Object[]{r101.getText().toString(), Integer.valueOf(TextRange.m6998getStartimpl(r101.m1199getSelectiond9O1mEE())), Integer.valueOf(TextRange.m6993getEndimpl(r101.m1199getSelectiond9O1mEE())), TextUndoManager.Companion.Saver.INSTANCE.save2(r100, r101.getTextUndoManager$foundation_release())});
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public /* bridge */ /* synthetic */ Object save(SaverScope r100, TextFieldState r101) {
            return save2(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[TextFieldEditUndoBehavior.values().length];
            r100[TextFieldEditUndoBehavior.ClearHistory.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TextFieldEditUndoBehavior.MergeIfPossible.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TextFieldEditUndoBehavior.NeverMerge.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public /* synthetic */ TextFieldState(String r100, long r101, TextUndoManager r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ TextFieldState(String r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public static /* synthetic */ void getMainBuffer$foundation_release$annotations() {
    }

    public static /* synthetic */ void getUndoState$annotations() {
    }

    public final void finishEditing() {
        setEditing(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isEditing() {
        return ((Boolean) this.isEditing$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldCharSequence getValue$foundation_release() {
        return (TextFieldCharSequence) this.value$delegate.getValue();
    }

    public final TextFieldBuffer startEdit() {
        Snapshot.Companion r100 = Snapshot.Companion;
        Snapshot r101 = r100.getCurrentThreadSnapshot();
        if (r101 == null) goto L5;
        Function1<Object, Unit> r102 = r101.getReadObserver();
    L6:
        Snapshot r103 = r100.makeCurrentNonObservable(r101);
        boolean r104 = isEditing();     // Catch: Throwable -> L13
        r100.restoreNonObservable(r101, r103, r102);
        if ((!r104) == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("TextFieldState does not support concurrent or nested editing.");
    L11:
        setEditing(true);
        return new TextFieldBuffer(getValue$foundation_release(), null, null, null, 14, null);
    L13:
        th = move-exception;
        r100.restoreNonObservable(r101, r103, r102);
        throw th;
    L5:
        r102 = null;
        goto L6
    }

    public String toString() {
        Snapshot.Companion r100 = Snapshot.Companion;
        Snapshot r101 = r100.getCurrentThreadSnapshot();
        if (r101 == null) goto L5;
        Function1<Object, Unit> r102 = r101.getReadObserver();
    L6:
        Snapshot r103 = r100.makeCurrentNonObservable(r101);
        String r104 = "TextFieldState(selection=" + TextRange.m7001toStringimpl(m1199getSelectiond9O1mEE()) + ", text=\"" + getText() + "\")";     // Catch: Throwable -> L10
        r100.restoreNonObservable(r101, r103, r102);
        return r104;
    L10:
        th = move-exception;
        r100.restoreNonObservable(r101, r103, r102);
        throw th;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m1198getCompositionMzsxiRA() {
        return getValue$foundation_release().m1196getCompositionMzsxiRA();
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1199getSelectiond9O1mEE() {
        return getValue$foundation_release().m1197getSelectiond9O1mEE();
    }

    public final CharSequence getText() {
        return getValue$foundation_release().getText();
    }

    public final TextFieldBuffer getMainBuffer$foundation_release() {
        return this.mainBuffer;
    }

    public final TextUndoManager getTextUndoManager$foundation_release() {
        return this.textUndoManager;
    }

    public final UndoState getUndoState() {
        return this.undoState;
    }

    private final void setEditing(boolean r100) {
        this.isEditing$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setValue(TextFieldCharSequence r100) {
        this.value$delegate.setValue(r100);
    }

    public final void addNotifyImeListener$foundation_release(NotifyImeListener r100) {
        this.notifyImeListeners.add(r100);
    }

    public final void commitEdit(TextFieldBuffer r110) {
        if (r110.getChanges().getChangeCount() <= 0) goto L5;
        boolean r100 = true;
    L6:
        boolean r101 = !TextRange.m6991equalsimpl0(r110.m1189getSelectiond9O1mEE(), this.mainBuffer.m1189getSelectiond9O1mEE());
        if (r100 == true) goto L10;
        if (r101 == true) goto L10;
        r110.setCanCallAddStyle$foundation_release(true);
    L10:
        if (r100 == false) goto L12;
        recordEditForUndo(getValue$foundation_release(), TextFieldBuffer.m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(r110, 0, null, null, null, 15, null), r110.getChanges(), TextFieldEditUndoBehavior.NeverMerge);
    L12:
        syncMainBufferToTemporaryBuffer$foundation_release(r110, r100, r101);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void edit(Function1<? super TextFieldBuffer, Unit> r100) {
        TextFieldBuffer r101 = startEdit();
        r100.invoke(r101);     // Catch: Throwable -> L6
        commitEdit(r101);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        finishEditing();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        finishEditing();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void editWithNoSideEffects$foundation_release(Function1<? super TextFieldBuffer, Unit> r110) {
        getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r110.invoke(getMainBuffer$foundation_release());
        TextFieldCharSequence r111 = TextFieldBuffer.m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(getMainBuffer$foundation_release(), 0, null, null, null, 15, null);
        access$updateValueAndNotifyListeners(this, getValue$foundation_release(), r111, true);
    }

    public final void removeNotifyImeListener$foundation_release(NotifyImeListener r100) {
        this.notifyImeListeners.remove(r100);
    }

    public final void setMainBuffer$foundation_release(TextFieldBuffer r100) {
        this.mainBuffer = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldState(String r100, long r101) {
        Object[] r102 = 0 == true ? 1 : 0;
        this(r100, r101, new TextUndoManager(null, r102, 3, 0 == true ? 1 : 0), null);
    }

    private TextFieldState(String r210, long r211, TextUndoManager r212) {
        this.textUndoManager = r212;
        this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(r210, TextRangeKt.m7004coerceIn8ffj60Q(r211, 0, r210.length()), null, null, null, null, 60, null), null, null, null, 14, null);
        this.isEditing$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(new TextFieldCharSequence(r210, r211, null, null, null, null, 60, null), null, 2, null);
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector(new NotifyImeListener[16], 0);
    }

    private final void commitEditAsUser(InputTransformation r210, boolean r211, TextFieldEditUndoBehavior r212) {
        TextFieldCharSequence r110 = getValue$foundation_release();
        if (this.mainBuffer.getChangeTracker$foundation_release().getChangeCount() == 0) goto L5;
    L14:
        boolean r100 = false;
        if (this.mainBuffer.getChangeTracker$foundation_release().getChangeCount() == 0) goto L17;
        boolean r101 = true;
    L18:
        TextFieldCharSequence r111 = new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1189getSelectiond9O1mEE(), this.mainBuffer.m1187getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getHighlight$foundation_release(), TextFieldStateKt.m1200access$finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1187getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getComposingAnnotations$foundation_release()), null, 32, null);
        if (r210 != null) goto L25;
        if (r101 == false) goto L23;
        if (r211 == false) goto L23;
        r100 = true;
    L23:
        updateValueAndNotifyListeners(r110, r111, r100);
        recordEditForUndo(r110, r111, this.mainBuffer.getChangeTracker$foundation_release(), r212);
        return;
    L25:
        TextFieldBuffer r112 = new TextFieldBuffer(r111, this.mainBuffer.getChangeTracker$foundation_release(), r110, null, 8, null);
        r210.transformInput(r112);
        boolean r102 = !StringsKt.contentEquals(r112.asCharSequence(), r111);
        boolean r103 = !TextRange.m6991equalsimpl0(r112.m1189getSelectiond9O1mEE(), r111.m1197getSelectiond9O1mEE());
        if (r102 == true) goto L30;
        if (r103 == true) goto L30;
        TextFieldBuffer r104 = r112;
        updateValueAndNotifyListeners(r110, TextFieldBuffer.m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(r112, 0, r111.m1196getCompositionMzsxiRA(), null, null, 13, null), r211);
    L31:
        recordEditForUndo(r110, getValue$foundation_release(), r104.getChanges(), r212);
        return;
    L30:
        r104 = r112;
        syncMainBufferToTemporaryBuffer$foundation_release(r104, r102, r103);
        goto L31
    L17:
        r101 = false;
        goto L18
    L5:
        if (TextRange.m6991equalsimpl0(r110.m1197getSelectiond9O1mEE(), this.mainBuffer.m1189getSelectiond9O1mEE()) == false) goto L14;
        if (Intrinsics.areEqual(r110.m1196getCompositionMzsxiRA(), this.mainBuffer.m1187getCompositionMzsxiRA$foundation_release()) == true) goto L9;
    L12:
        updateValueAndNotifyListeners(getValue$foundation_release(), new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1189getSelectiond9O1mEE(), this.mainBuffer.m1187getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getHighlight$foundation_release(), TextFieldStateKt.m1200access$finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1187getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getComposingAnnotations$foundation_release()), null, 32, null), r211);
        return;
    L9:
        if (Intrinsics.areEqual(r110.getHighlight(), this.mainBuffer.getHighlight$foundation_release()) == false) goto L12;
        if (Intrinsics.areEqual(r110.getComposingAnnotations(), this.mainBuffer.getComposingAnnotations$foundation_release()) == false) goto L12;
    }

    private final void updateValueAndNotifyListeners(TextFieldCharSequence r100, TextFieldCharSequence r101, boolean r102) {
        setValue(r101);
        finishEditing();
        MutableVector<NotifyImeListener> r103 = this.notifyImeListeners;
        NotifyImeListener[] r104 = r103.content;
        int r105 = r103.getSize();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L13;
        NotifyImeListener r107 = r104[r106];
        if (r102 == true) goto L7;
    L11:
        boolean r108 = false;
    L12:
        r107.onChange(r100, r101, r108);
        r106 = r106 + 1;
        goto L3
    L7:
        if (r100.contentEquals(r101) == true) goto L11;
        if (r100.m1196getCompositionMzsxiRA() == null) goto L11;
        r108 = true;
        goto L12
    }

    public final void syncMainBufferToTemporaryBuffer$foundation_release(TextFieldBuffer r210, boolean r211, boolean r212) {
        TextFieldCharSequence r100 = TextFieldBuffer.m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(this.mainBuffer, 0, null, null, null, 15, null);
        if (r211 == false) goto L5;
        this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(r210.toString(), r210.m1189getSelectiond9O1mEE(), null, null, null, null, 60, null), null, null, null, 14, null);
    L7:
        if (r211 == true) goto L11;
        if (r212 == true) goto L11;
        if (Intrinsics.areEqual(r100.m1196getCompositionMzsxiRA(), r210.m1187getCompositionMzsxiRA$foundation_release()) == false) goto L11;
    L12:
        updateValueAndNotifyListeners(r100, TextFieldBuffer.m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(this.mainBuffer, 0, null, null, null, 15, null), true);
        return;
    L11:
        this.mainBuffer.commitComposition$foundation_release();
        goto L12
    L5:
        if (r212 == false) goto L7;
        this.mainBuffer.m1191setSelection5zctL8(TextRangeKt.TextRange(TextRange.m6998getStartimpl(r210.m1189getSelectiond9O1mEE()), TextRange.m6993getEndimpl(r210.m1189getSelectiond9O1mEE())));
        goto L7
    }

    public /* synthetic */ TextFieldState(String r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = TextRangeKt.TextRange(r100.length());
    L8:
        this(r100, r101, null);
    }

    public static final /* synthetic */ void access$commitEditAsUser(TextFieldState r100, InputTransformation r101, boolean r102, TextFieldEditUndoBehavior r103) {
        r100.commitEditAsUser(r101, r102, r103);
    }

    public static final /* synthetic */ void access$updateValueAndNotifyListeners(TextFieldState r100, TextFieldCharSequence r101, TextFieldCharSequence r102, boolean r103) {
        r100.updateValueAndNotifyListeners(r101, r102, r103);
    }

    private final void recordEditForUndo(TextFieldCharSequence r100, TextFieldCharSequence r101, TextFieldBuffer.ChangeList r102, TextFieldEditUndoBehavior r103) {
        int r104 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
        if (r104 != 1) goto L5;
        this.textUndoManager.clearHistory();
        return;
    L5:
        if (r104 != 2) goto L7;
        TextUndoManagerKt.recordChanges(this.textUndoManager, r100, r101, r102, true);
        return;
    L7:
        if (r104 != 3) goto L10;
        TextUndoManagerKt.recordChanges(this.textUndoManager, r100, r101, r102, false);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void editAsUser$foundation_release(InputTransformation r100, boolean r101, TextFieldEditUndoBehavior r102, Function1<? super TextFieldBuffer, Unit> r103) {
        getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r103.invoke(getMainBuffer$foundation_release());
        access$commitEditAsUser(this, r100, r101, r102);
    }

    public static /* synthetic */ void commitEditAsUser$default(TextFieldState r100, InputTransformation r101, boolean r102, TextFieldEditUndoBehavior r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = TextFieldEditUndoBehavior.MergeIfPossible;
    L8:
        r100.commitEditAsUser(r101, r102, r103);
    }

    public static /* synthetic */ void editAsUser$foundation_release$default(TextFieldState r100, InputTransformation r101, boolean r102, TextFieldEditUndoBehavior r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r103 = TextFieldEditUndoBehavior.MergeIfPossible;
    L8:
        r100.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        r104.invoke(r100.getMainBuffer$foundation_release());
        access$commitEditAsUser(r100, r101, r102, r103);
    }
}
