package com.android.contacts.calllog.v2;

import com.GlobalProxyLancet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: EditModeManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0011J$\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/calllog/v2/EditModeManager;", "", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/android/contacts/calllog/v2/EditModeState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "deselectAll", "", "enter", "exit", "selectAll", "allIds", "", "", "toggle", "id", "toggleGroup", "ids", "", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EditModeManager {
    public static final Companion Companion = null;
    private static final String TAG = "CallLogV2";
    private final MutableStateFlow<EditModeState> _state;
    private final StateFlow<EditModeState> state;

    /* JADX INFO: compiled from: EditModeManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/v2/EditModeManager$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EditModeManager() {
        MutableStateFlow<EditModeState> r0 = StateFlowKt.MutableStateFlow(EditModeState.Companion.getINACTIVE());
        this._state = r0;
        this.state = FlowKt.asStateFlow(r0);
    }

    public final StateFlow<EditModeState> getState() {
        return this.state;
    }

    public final void enter() {
        MutableStateFlow<EditModeState> r8 = this._state;
    L4:
        if (r8.compareAndSet(r8.getValue(), new EditModeState(true, null, false, 6, null)) == false) goto L4;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "editMode: enter");
    }

    public final void exit() {
        this._state.setValue(EditModeState.Companion.getINACTIVE());
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "editMode: exit");
    }

    public final void toggle(long r8) {
        MutableStateFlow<EditModeState> r7 = this._state;
    L3:
        EditModeState r0 = r7.getValue();
        EditModeState r1 = r0;
        if (r1.getSelectedIds().contains(Long.valueOf(r8)) == false) goto L6;
        Set r2 = SetsKt.minus(r1.getSelectedIds(), Long.valueOf(r8));
    L8:
        if (r7.compareAndSet(r0, EditModeState.copy$default(r1, false, r2, false, 1, null)) == false) goto L3;
        return;
    L6:
        r2 = SetsKt.plus(r1.getSelectedIds(), Long.valueOf(r8));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void toggleGroup$default(EditModeManager r0, Collection r1, Collection r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r1;
    L5:
        r0.toggleGroup(r1, r2);
    }

    public final void toggleGroup(Collection<Long> r10, Collection<Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "ids");
        Intrinsics.checkNotNullParameter(r11, "allIds");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        Set r12 = CollectionsKt.toSet(r10);
        Set r13 = CollectionsKt.toSet(r11);
        MutableStateFlow<EditModeState> r9 = this._state;
    L6:
        EditModeState r0 = r9.getValue();
        EditModeState r1 = r0;
        Set r2 = r12;
        boolean r4 = false;
        if ((r2 instanceof Collection) == true) goto L9;
    L11:
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L10;
        if (r1.getSelectedIds().contains(Long.valueOf(((Number) r3.next()).longValue())) == true) goto L13;
        boolean r5 = false;
    L17:
        if (r5 == false) goto L19;
        Set r6 = SetsKt.minus(r1.getSelectedIds(), r2);
    L20:
        Set r7 = r6;
        Set r8 = r13;
        if ((!r8.isEmpty()) == false) goto L26;
        if (r7.containsAll(r8) == false) goto L26;
        r4 = true;
    L26:
        if (r9.compareAndSet(r0, EditModeState.copy$default(r1, false, r7, r4, 1, null)) == false) goto L6;
        return;
    L19:
        r6 = SetsKt.plus(r1.getSelectedIds(), r2);
    L10:
        r5 = true;
        goto L17
    L9:
        if (r2.isEmpty() == false) goto L11;
        goto L10
    }

    public final void selectAll(List<Long> r8) {
        Intrinsics.checkNotNullParameter(r8, "allIds");
        MutableStateFlow<EditModeState> r7 = this._state;
    L3:
        EditModeState r0 = r7.getValue();
        if (r7.compareAndSet(r0, EditModeState.copy$default(r0, false, CollectionsKt.toSet(r8), true, 1, null)) == false) goto L3;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "editMode: selectAll, count=" + r8.size());
    }

    public final void deselectAll() {
        MutableStateFlow<EditModeState> r7 = this._state;
    L3:
        EditModeState r0 = r7.getValue();
        if (r7.compareAndSet(r0, EditModeState.copy$default(r0, false, SetsKt.emptySet(), false, 1, null)) == false) goto L3;
    }
}
