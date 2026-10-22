package androidx.compose.foundation.text.input;

import H4.o;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextUndoManager;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Stable
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0002klB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ$\u0010\u000f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0018\u0010\u0019JB\u0010#\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0\u000bH\u0080\b¢\u0006\u0004\b!\u0010\"J$\u0010%\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0\u000bH\u0080\b¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010*\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0000¢\u0006\u0004\b+\u0010)J4\u00103\u001a\u00020\r2\u0006\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cH\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J-\u00104\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b4\u00105J'\u00108\u001a\u00020\r2\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b8\u00109J/\u0010>\u001a\u00020\r2\u0006\u0010:\u001a\u0002062\u0006\u0010;\u001a\u0002062\u0006\u0010=\u001a\u00020<2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR(\u0010D\u001a\u00020 8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bD\u0010E\u0012\u0004\bJ\u0010\u0019\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR+\u0010N\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR+\u0010W\u001a\u0002062\u0006\u0010K\u001a\u0002068@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010M\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR \u0010Y\u001a\u00020X8GX\u0087\u0004¢\u0006\u0012\n\u0004\bY\u0010Z\u0012\u0004\b]\u0010\u0019\u001a\u0004\b[\u0010\\R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020&0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0011\u0010d\u001a\u00020a8F¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0017\u0010g\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\be\u0010fR\u0019\u0010j\u001a\u0004\u0018\u00010\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bh\u0010i\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "", "", "initialText", "Landroidx/compose/ui/text/TextRange;", "initialSelection", "Landroidx/compose/foundation/text/input/TextUndoManager;", "initialTextUndoManager", AppAgent.CONSTRUCT, "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/e;)V", "(Ljava/lang/String;JLkotlin/jvm/internal/e;)V", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "LC7/r;", "block", "edit", "(LS7/k;)V", "toString", "()Ljava/lang/String;", "startEdit", "()Landroidx/compose/foundation/text/input/TextFieldBuffer;", "newValue", "commitEdit", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "finishEditing", "()V", "Landroidx/compose/foundation/text/input/InputTransformation;", "inputTransformation", "", "restartImeIfContentChanges", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "editAsUser$foundation_release", "(Landroidx/compose/foundation/text/input/InputTransformation;ZLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;LS7/k;)V", "editAsUser", "editWithNoSideEffects$foundation_release", "editWithNoSideEffects", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "notifyImeListener", "addNotifyImeListener$foundation_release", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;)V", "addNotifyImeListener", "removeNotifyImeListener$foundation_release", "removeNotifyImeListener", "textFieldBuffer", "newComposition", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;Landroidx/compose/ui/text/TextRange;ZZ)V", "syncMainBufferToTemporaryBuffer", "commitEditAsUser", "(Landroidx/compose/foundation/text/input/InputTransformation;ZLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;)V", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "oldValue", "updateValueAndNotifyListeners", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Z)V", "previousValue", "postValue", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "changes", "recordEditForUndo", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;)V", "textUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "mainBuffer", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text/input/internal/EditingBuffer;)V", "getMainBuffer$foundation_release$annotations", "<set-?>", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "isEditing", "()Z", "setEditing", "(Z)V", "value$delegate", "getValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value", "Landroidx/compose/foundation/text/input/UndoState;", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "Landroidx/compose/runtime/collection/MutableVector;", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "", "getText", "()Ljava/lang/CharSequence;", "text", "getSelection-d9O1mEE", "()J", "selection", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "composition", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldState {
    public static final int $stable = 0;

    /* renamed from: isEditing$delegate, reason: from kotlin metadata */
    private final MutableState isEditing;
    private EditingBuffer mainBuffer;
    private final MutableVector<NotifyImeListener> notifyImeListeners;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "oldValue", "newValue", "", "restartImeIfContentChanges", "LC7/r;", "onChange", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Z)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence oldValue, TextFieldCharSequence newValue, boolean restartImeIfContentChanges);
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "()V", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = new Saver();

        private Saver() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.runtime.saveable.Saver
        public TextFieldState restore(Object value) {
            k.d(value, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) value;
            Object obj = list.get(0);
            Object obj2 = list.get(1);
            Object obj3 = list.get(2);
            Object obj4 = list.get(3);
            k.d(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj2).intValue();
            k.d(obj3, "null cannot be cast to non-null type kotlin.Int");
            long jTextRange = TextRangeKt.TextRange(iIntValue, ((Integer) obj3).intValue());
            TextUndoManager.Companion.Saver saver = TextUndoManager.Companion.Saver.INSTANCE;
            k.c(obj4);
            TextUndoManager textUndoManagerRestore = saver.restore(obj4);
            k.c(textUndoManagerRestore);
            return new TextFieldState(str, jTextRange, textUndoManagerRestore, (e) null);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaverScope saverScope, TextFieldState textFieldState) {
            return o.N(textFieldState.getText().toString(), Integer.valueOf(TextRange.m6311getStartimpl(textFieldState.m1144getSelectiond9O1mEE())), Integer.valueOf(TextRange.m6306getEndimpl(textFieldState.m1144getSelectiond9O1mEE())), TextUndoManager.Companion.Saver.INSTANCE.save(saverScope, textFieldState.getTextUndoManager()));
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldEditUndoBehavior.values().length];
            try {
                iArr[TextFieldEditUndoBehavior.ClearHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.MergeIfPossible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.NeverMerge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ TextFieldState(String str, long j5, TextUndoManager textUndoManager, e eVar) {
        this(str, j5, textUndoManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitEditAsUser(InputTransformation inputTransformation, boolean restartImeIfContentChanges, TextFieldEditUndoBehavior undoBehavior) {
        TextFieldCharSequence value$foundation_release = getValue$foundation_release();
        if (this.mainBuffer.getChangeTracker().getChangeCount() == 0 && TextRange.m6304equalsimpl0(value$foundation_release.getSelection(), this.mainBuffer.m1173getSelectiond9O1mEE())) {
            if (k.b(value$foundation_release.getComposition(), this.mainBuffer.m1172getCompositionMzsxiRA()) && k.b(value$foundation_release.getHighlight(), this.mainBuffer.getHighlight())) {
                return;
            }
            updateValueAndNotifyListeners(getValue$foundation_release(), new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1173getSelectiond9O1mEE(), this.mainBuffer.m1172getCompositionMzsxiRA(), this.mainBuffer.getHighlight(), null), restartImeIfContentChanges);
            return;
        }
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1173getSelectiond9O1mEE(), this.mainBuffer.m1172getCompositionMzsxiRA(), this.mainBuffer.getHighlight(), null);
        if (inputTransformation == null) {
            updateValueAndNotifyListeners(value$foundation_release, textFieldCharSequence, restartImeIfContentChanges);
            recordEditForUndo(value$foundation_release, textFieldCharSequence, this.mainBuffer.getChangeTracker(), undoBehavior);
            return;
        }
        TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence, this.mainBuffer.getChangeTracker(), value$foundation_release, null, 8, null);
        inputTransformation.transformInput(textFieldBuffer);
        boolean zV = t.V(textFieldBuffer.asCharSequence(), textFieldCharSequence);
        boolean z10 = !zV;
        boolean zM6304equalsimpl0 = TextRange.m6304equalsimpl0(textFieldBuffer.getSelectionInChars(), textFieldCharSequence.getSelection());
        boolean z11 = !zM6304equalsimpl0;
        if (zV && zM6304equalsimpl0) {
            updateValueAndNotifyListeners(value$foundation_release, TextFieldBuffer.m1134toTextFieldCharSequenceudt6zUU$foundation_release$default(textFieldBuffer, 0L, textFieldCharSequence.getComposition(), 1, null), restartImeIfContentChanges);
        } else {
            m1145syncMainBufferToTemporaryBufferTS3Rm5k$foundation_release(textFieldBuffer, null, z10, z11);
        }
        recordEditForUndo(value$foundation_release, getValue$foundation_release(), textFieldBuffer.getChanges(), undoBehavior);
    }

    public static /* synthetic */ void commitEditAsUser$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z10, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.commitEditAsUser(inputTransformation, z10, textFieldEditUndoBehavior);
    }

    public static /* synthetic */ void editAsUser$foundation_release$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z10, TextFieldEditUndoBehavior textFieldEditUndoBehavior, S7.k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        kVar.invoke(textFieldState.getMainBuffer());
        textFieldState.commitEditAsUser(inputTransformation, z10, textFieldEditUndoBehavior);
    }

    @VisibleForTesting
    public static /* synthetic */ void getMainBuffer$foundation_release$annotations() {
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getUndoState$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isEditing() {
        return ((Boolean) this.isEditing.getValue()).booleanValue();
    }

    private final void recordEditForUndo(TextFieldCharSequence previousValue, TextFieldCharSequence postValue, TextFieldBuffer.ChangeList changes, TextFieldEditUndoBehavior undoBehavior) {
        int i = WhenMappings.$EnumSwitchMapping$0[undoBehavior.ordinal()];
        if (i == 1) {
            this.textUndoManager.clearHistory();
        } else if (i == 2) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, previousValue, postValue, changes, true);
        } else {
            if (i != 3) {
                return;
            }
            TextUndoManagerKt.recordChanges(this.textUndoManager, previousValue, postValue, changes, false);
        }
    }

    private final void setEditing(boolean z10) {
        this.isEditing.setValue(Boolean.valueOf(z10));
    }

    private final void setValue(TextFieldCharSequence textFieldCharSequence) {
        this.value.setValue(textFieldCharSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateValueAndNotifyListeners(TextFieldCharSequence oldValue, TextFieldCharSequence newValue, boolean restartImeIfContentChanges) {
        setValue(newValue);
        finishEditing();
        MutableVector<NotifyImeListener> mutableVector = this.notifyImeListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            NotifyImeListener[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].onChange(oldValue, newValue, restartImeIfContentChanges);
                i++;
            } while (i < size);
        }
    }

    public final void addNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.add(notifyImeListener);
    }

    public final void commitEdit(TextFieldBuffer newValue) {
        boolean z10 = newValue.getChanges().getChangeCount() > 0;
        boolean zM6304equalsimpl0 = true ^ TextRange.m6304equalsimpl0(newValue.getSelectionInChars(), this.mainBuffer.m1173getSelectiond9O1mEE());
        if (z10) {
            this.textUndoManager.clearHistory();
        }
        m1145syncMainBufferToTemporaryBufferTS3Rm5k$foundation_release(newValue, null, z10, zM6304equalsimpl0);
    }

    public final void edit(S7.k block) {
        TextFieldBuffer textFieldBufferStartEdit = startEdit();
        try {
            block.invoke(textFieldBufferStartEdit);
            commitEdit(textFieldBufferStartEdit);
        } finally {
            finishEditing();
        }
    }

    public final void editAsUser$foundation_release(InputTransformation inputTransformation, boolean restartImeIfContentChanges, TextFieldEditUndoBehavior undoBehavior, S7.k block) {
        getMainBuffer().getChangeTracker().clearChanges();
        block.invoke(getMainBuffer());
        commitEditAsUser(inputTransformation, restartImeIfContentChanges, undoBehavior);
    }

    public final void editWithNoSideEffects$foundation_release(S7.k block) {
        getMainBuffer().getChangeTracker().clearChanges();
        block.invoke(getMainBuffer());
        updateValueAndNotifyListeners(getValue$foundation_release(), new TextFieldCharSequence(getMainBuffer().toString(), getMainBuffer().m1173getSelectiond9O1mEE(), getMainBuffer().m1172getCompositionMzsxiRA(), null, 8, null), true);
    }

    public final void finishEditing() {
        setEditing(false);
    }

    /* renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m1143getCompositionMzsxiRA() {
        return getValue$foundation_release().getComposition();
    }

    /* renamed from: getMainBuffer$foundation_release, reason: from getter */
    public final EditingBuffer getMainBuffer() {
        return this.mainBuffer;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1144getSelectiond9O1mEE() {
        return getValue$foundation_release().getSelection();
    }

    public final CharSequence getText() {
        return getValue$foundation_release().getText();
    }

    /* renamed from: getTextUndoManager$foundation_release, reason: from getter */
    public final TextUndoManager getTextUndoManager() {
        return this.textUndoManager;
    }

    @ExperimentalFoundationApi
    public final UndoState getUndoState() {
        return this.undoState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldCharSequence getValue$foundation_release() {
        return (TextFieldCharSequence) this.value.getValue();
    }

    public final void removeNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.remove(notifyImeListener);
    }

    public final void setMainBuffer$foundation_release(EditingBuffer editingBuffer) {
        this.mainBuffer = editingBuffer;
    }

    public final TextFieldBuffer startEdit() {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        S7.k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (isEditing()) {
                throw new IllegalStateException("TextFieldState does not support concurrent or nested editing.");
            }
            setEditing(true);
            return new TextFieldBuffer(getValue$foundation_release(), null, null, null, 14, null);
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    @VisibleForTesting
    /* renamed from: syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release, reason: not valid java name */
    public final void m1145syncMainBufferToTemporaryBufferTS3Rm5k$foundation_release(TextFieldBuffer textFieldBuffer, TextRange newComposition, boolean textChanged, boolean selectionChanged) {
        String string = this.mainBuffer.toString();
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(string, this.mainBuffer.m1173getSelectiond9O1mEE(), this.mainBuffer.m1172getCompositionMzsxiRA(), null, 8, null);
        boolean zB = k.b(newComposition, this.mainBuffer.m1172getCompositionMzsxiRA());
        if (textChanged) {
            this.mainBuffer = new EditingBuffer(textFieldBuffer.toString(), textFieldBuffer.getSelectionInChars(), (e) null);
        } else if (selectionChanged) {
            this.mainBuffer.setSelection(TextRange.m6311getStartimpl(textFieldBuffer.getSelectionInChars()), TextRange.m6306getEndimpl(textFieldBuffer.getSelectionInChars()));
        }
        if (newComposition == null || TextRange.m6305getCollapsedimpl(newComposition.getPackedValue())) {
            this.mainBuffer.commitComposition();
        } else {
            this.mainBuffer.setComposition(TextRange.m6309getMinimpl(newComposition.getPackedValue()), TextRange.m6308getMaximpl(newComposition.getPackedValue()));
        }
        if (textChanged || (!selectionChanged && !zB)) {
            this.mainBuffer.commitComposition();
        }
        if (textChanged) {
            string = textFieldBuffer.toString();
        }
        updateValueAndNotifyListeners(textFieldCharSequence, new TextFieldCharSequence(string, this.mainBuffer.m1173getSelectiond9O1mEE(), this.mainBuffer.m1172getCompositionMzsxiRA(), null, 8, null), true);
    }

    public String toString() {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        S7.k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            return "TextFieldState(selection=" + ((Object) TextRange.m6314toStringimpl(m1144getSelectiond9O1mEE())) + ", text=\"" + ((Object) getText()) + "\")";
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public /* synthetic */ TextFieldState(String str, long j5, e eVar) {
        this(str, j5);
    }

    private TextFieldState(String str, long j5, TextUndoManager textUndoManager) {
        this.textUndoManager = textUndoManager;
        this.mainBuffer = new EditingBuffer(str, TextRangeKt.m6317coerceIn8ffj60Q(j5, 0, str.length()), (e) null);
        this.isEditing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldCharSequence(str, j5, null, null, 12, null), null, 2, null);
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector<>(new NotifyImeListener[16], 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextFieldState(String str, long j5, int i, e eVar) {
        str = (i & 1) != 0 ? "" : str;
        this(str, (i & 2) != 0 ? TextRangeKt.TextRange(str.length()) : j5, (e) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldState(String str, long j5) {
        this(str, j5, new TextUndoManager(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), (e) null);
    }
}
