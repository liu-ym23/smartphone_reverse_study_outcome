package androidx.compose.ui.focus;

import C7.c;
import C7.r;
import S7.k;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001RB\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028V@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tRB\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028V@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001c\u0010\u0016\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\"\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR$\u0010%\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010(\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR$\u0010+\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR$\u0010.\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR$\u00101\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR<\u00106\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR<\u00109\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006:À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusProperties;", "", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "Landroidx/compose/ui/focus/FocusRequester;", "value", "getEnter", "()LS7/k;", "setEnter", "(LS7/k;)V", "getEnter$annotations", "()V", "enter", "getExit", "setExit", "getExit$annotations", "exit", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "canFocus", "_", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "next", "getPrevious", "setPrevious", "previous", "getUp", "setUp", "up", "getDown", "setDown", "down", "getLeft", "setLeft", "left", "getRight", "setRight", "right", "getStart", "setStart", "start", "getEnd", "setEnd", "end", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "LC7/r;", "getOnEnter", "setOnEnter", "onEnter", "getOnExit", "setOnExit", "onExit", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusProperties {
    @ExperimentalComposeUiApi
    static /* synthetic */ void getEnter$annotations() {
    }

    @ExperimentalComposeUiApi
    static /* synthetic */ void getExit$annotations() {
    }

    boolean getCanFocus();

    default FocusRequester getDown() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getEnd() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default k getEnter() {
        return new k() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m3798invoke3ESFkO8(((FocusDirection) obj).getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m3798invoke3ESFkO8(int i) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    default k getExit() {
        return new k() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m3799invoke3ESFkO8(((FocusDirection) obj).getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m3799invoke3ESFkO8(int i) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    default FocusRequester getLeft() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getNext() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default k getOnEnter() {
        return new k() { // from class: androidx.compose.ui.focus.FocusProperties$onEnter$1
            public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusEnterExitScope) obj);
                return r.f317a;
            }
        };
    }

    default k getOnExit() {
        return new k() { // from class: androidx.compose.ui.focus.FocusProperties$onExit$1
            public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusEnterExitScope) obj);
                return r.f317a;
            }
        };
    }

    default FocusRequester getPrevious() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getRight() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getStart() {
        return FocusRequester.INSTANCE.getDefault();
    }

    default FocusRequester getUp() {
        return FocusRequester.INSTANCE.getDefault();
    }

    void setCanFocus(boolean z10);

    default void setDown(FocusRequester focusRequester) {
    }

    default void setEnd(FocusRequester focusRequester) {
    }

    @c
    default void setEnter(k kVar) {
        setOnEnter(FocusPropertiesKt.toUsingEnterExitScope(kVar));
    }

    @c
    default void setExit(k kVar) {
        setOnExit(FocusPropertiesKt.toUsingEnterExitScope(kVar));
    }

    default void setLeft(FocusRequester focusRequester) {
    }

    default void setNext(FocusRequester focusRequester) {
    }

    default void setOnEnter(k kVar) {
    }

    default void setOnExit(k kVar) {
    }

    default void setPrevious(FocusRequester focusRequester) {
    }

    default void setRight(FocusRequester focusRequester) {
    }

    default void setStart(FocusRequester focusRequester) {
    }

    default void setUp(FocusRequester focusRequester) {
    }
}
