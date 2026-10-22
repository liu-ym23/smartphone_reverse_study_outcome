package com.android.contacts.calllog.v2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.provider.CallLog;
import android.security.bytedance.guard.BDSettingsEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.CubicInterpolator;
import com.android.contacts.util.OAlertDialogUtils;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.utils.OAutoSecurityGuardUtils;
import com.obric.utils.ObriceRecordSummaryUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CallLogDeleteHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0002$%BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\fH\u0002J\u0016\u0010\u001b\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u0010 \u001a\u00020\fJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0016H\u0002J\u0006\u0010#\u001a\u00020\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogDeleteHelper;", "", "fragment", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/android/contacts/calllog/v2/CallLogViewModel;", "getRecyclerView", "Lkotlin/Function0;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getAdapter", "Lcom/android/contacts/calllog/v2/CallLogListAdapter;", "onExitEditAfterDelete", "", "(Landroidx/fragment/app/Fragment;Lcom/android/contacts/calllog/v2/CallLogViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "deleteConfirmDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "<set-?>", "Lcom/android/contacts/calllog/v2/CallLogDeleteHelper$DeleteState;", "deleteState", "getDeleteState", "()Lcom/android/contacts/calllog/v2/CallLogDeleteHelper$DeleteState;", "isPendingExitAfterDelete", "", "()Z", "shouldSkipExitAnimation", "getShouldSkipExitAnimation", "animateAndDeleteSelected", "checkHasRecord", "selectedIds", "", "", "destroy", "onDiffCompleted", "showConfirmDialog", "hasRecord", "showDeleteDialog", "Companion", "DeleteState", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogDeleteHelper {
    public static final Companion Companion = null;
    private static final String TAG = "CallLogV2";
    private OAlertDialog deleteConfirmDialog;
    private DeleteState deleteState;
    private final Fragment fragment;
    private final Function0<CallLogListAdapter> getAdapter;
    private final Function0<RecyclerView> getRecyclerView;
    private final Function0<Unit> onExitEditAfterDelete;
    private final CallLogViewModel viewModel;

    /* JADX INFO: compiled from: CallLogDeleteHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogDeleteHelper$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CallLogDeleteHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogDeleteHelper$DeleteState;", "", "(Ljava/lang/String;I)V", "IDLE", "CONFIRMING", "ANIMATING", "DIFF_PENDING", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum DeleteState extends Enum<DeleteState> {
        private static final /* synthetic */ DeleteState[] $VALUES = null;
        public static final DeleteState ANIMATING = null;
        public static final DeleteState CONFIRMING = null;
        public static final DeleteState DIFF_PENDING = null;
        public static final DeleteState IDLE = null;

        private static final /* synthetic */ DeleteState[] $values() {
            return new DeleteState[]{IDLE, CONFIRMING, ANIMATING, DIFF_PENDING};
        }

        public static DeleteState valueOf(String r1) {
            return (DeleteState) Enum.valueOf(DeleteState.class, r1);
        }

        public static DeleteState[] values() {
            return (DeleteState[]) $VALUES.clone();
        }

        private DeleteState(String r1, int r2) {
            super(r1, r2);
        }

        static {
            IDLE = new DeleteState("IDLE", 0);
            CONFIRMING = new DeleteState("CONFIRMING", 1);
            ANIMATING = new DeleteState("ANIMATING", 2);
            DIFF_PENDING = new DeleteState("DIFF_PENDING", 3);
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogDeleteHelper$showDeleteDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogDeleteHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogDeleteHelper$showDeleteDialog$1", f = "CallLogDeleteHelper.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<Long> $selectedIds;
        int label;
        final /* synthetic */ CallLogDeleteHelper this$0;

        AnonymousClass1(CallLogDeleteHelper r1, Set<Long> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$selectedIds = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, this.$selectedIds, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            boolean r8 = ((Boolean) r7).booleanValue();
            if (CallLogDeleteHelper.access$getFragment$p(this.this$0).isAdded() == true) goto L15;
            CallLogDeleteHelper.access$setDeleteState$p(this.this$0, DeleteState.IDLE);
            return Unit.INSTANCE;
        L15:
            CallLogDeleteHelper.access$showConfirmDialog(this.this$0, r8);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            this.label = 1;
            r7 = BuildersKt.withContext(Dispatchers.getIO(), new CallLogDeleteHelper$showDeleteDialog$1$hasRecord$1(this.this$0, this.$selectedIds, null), this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$AsyzgP84UOL3NRbdau4-Tsz0n4M, reason: not valid java name */
    public static /* synthetic */ void m156$r8$lambda$AsyzgP84UOL3NRbdau4Tsz0n4M(CallLogDeleteHelper r0, DialogInterface r1) {
        showConfirmDialog$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JmIfLLcUVH2zWWEQ7AUxzsPSRaI(CallLogDeleteHelper r0, int r1, DialogInterface r2, int r3) {
        showConfirmDialog$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$eja3RKLPkGtoZt0PkveADP3Qoz0(CallLogDeleteHelper r0, int r1, DialogInterface r2, int r3) {
        showConfirmDialog$lambda$1(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallLogDeleteHelper(Fragment r2, CallLogViewModel r3, Function0<? extends RecyclerView> r4, Function0<CallLogListAdapter> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "getRecyclerView");
        Intrinsics.checkNotNullParameter(r5, "getAdapter");
        Intrinsics.checkNotNullParameter(r6, "onExitEditAfterDelete");
        this.fragment = r2;
        this.viewModel = r3;
        this.getRecyclerView = r4;
        this.getAdapter = r5;
        this.onExitEditAfterDelete = r6;
        this.deleteState = DeleteState.IDLE;
    }

    public static final /* synthetic */ boolean access$checkHasRecord(CallLogDeleteHelper r0, Set r1) {
        return r0.checkHasRecord(r1);
    }

    public static final /* synthetic */ Fragment access$getFragment$p(CallLogDeleteHelper r0) {
        return r0.fragment;
    }

    public static final /* synthetic */ CallLogViewModel access$getViewModel$p(CallLogDeleteHelper r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$setDeleteState$p(CallLogDeleteHelper r0, DeleteState r1) {
        r0.deleteState = r1;
    }

    public static final /* synthetic */ void access$showConfirmDialog(CallLogDeleteHelper r0, boolean r1) {
        r0.showConfirmDialog(r1);
    }

    public final DeleteState getDeleteState() {
        return this.deleteState;
    }

    public final boolean isPendingExitAfterDelete() {
        if (this.deleteState != DeleteState.DIFF_PENDING) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getShouldSkipExitAnimation() {
        if (this.deleteState == DeleteState.IDLE) goto L5;
        return true;
    L5:
        return false;
    }

    public final void showDeleteDialog() {
        if (this.fragment.isAdded() == true) goto L5;
        return;
    L5:
        Set<Long> r0 = this.viewModel.getUiState().getValue().getEditMode().getSelectedIds();
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        this.deleteState = DeleteState.CONFIRMING;
        LifecycleOwner r1 = this.fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "fragment.viewLifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new AnonymousClass1(this, r0, null), 3, null);
    }

    public final void onDiffCompleted() {
        RecyclerView r0 = this.getRecyclerView.invoke();
        if (r0 != null) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onDiffCompleted: exiting edit");
        r0.setEnabled(true);
        this.deleteState = DeleteState.IDLE;
        this.onExitEditAfterDelete.invoke();
    }

    public final void destroy() {
        OAlertDialog r0 = this.deleteConfirmDialog;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        OAlertDialog r2 = this.deleteConfirmDialog;
        if (r2 == null) goto L11;
        r2.dismiss();
    L11:
        this.deleteConfirmDialog = null;
        this.deleteState = DeleteState.IDLE;
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L7
    }

    private final boolean checkHasRecord(Set<Long> r15) {
        FragmentActivity r0 = this.fragment.getActivity();
        if (r0 == null) goto L5;
        ContentResolver r2 = r0.getContentResolver();
    L7:
        if (r2 != null) goto L9;
        return false;
    L9:
        Cursor r3 = r2.query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date"}, "_id IN (" + CollectionsKt.joinToString$default(r15, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null) + ')', null, null);
        if (r3 == null) goto L31;
        Cursor r4 = r3;
        Cursor r5 = r4;     // Catch: Throwable -> L26
        int r16 = r5.getColumnIndex("number");     // Catch: Throwable -> L26
        int r6 = r5.getColumnIndex("date");     // Catch: Throwable -> L26
        if (r16 == (-1)) goto L24;
        if (r6 == (-1)) goto L24;
    L17:
        if (r5.moveToNext() == false) goto L22;
        if (ObriceRecordSummaryUtils.recordFileNotExists(this.fragment.getActivity(), Long.valueOf(r5.getLong(r6)), r5.getString(r16)) == true) goto L17;
        CloseableKt.closeFinally(r4, null);
        return true;
    L22:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r4, null);
    L24:
        CloseableKt.closeFinally(r4, null);
        return false;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L31:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    private final void showConfirmDialog(boolean r14) {
        if (r14 == false) goto L4;
        int r15 = R.string.dialog_title_delete_call_log;
    L5:
        final int r0 = BDSettingsEvent.EVENT_TYPE_CALL_LOGS_DELETE.getType();
        OAlertDialogUtils r1 = OAlertDialogUtils.INSTANCE;
        Context r2 = this.fragment.requireContext();
        String r16 = this.fragment.getString(r15);
        String r3 = this.fragment.getString(R.string.btn_confirm_delete);
        DialogInterface.OnClickListener r6 = new CallLogDeleteHelper$$ExternalSyntheticLambda0(this, r0);
        String r4 = this.fragment.getString(R.string.btn_cancel);
        ButtonStyleController.TextColorType r7 = ButtonStyleController.TextColorType.Negative;
        DialogInterface.OnClickListener r9 = new CallLogDeleteHelper$$ExternalSyntheticLambda1(this, r0);
        Intrinsics.checkNotNullExpressionValue(r2, "requireContext()");
        OAlertDialog r17 = OAlertDialogUtils.showConfirmationDialog$default(r2, r16, null, r3, r6, r7, r4, r9, null, 256, null);
        this.deleteConfirmDialog = r17;
        if (r17 == null) goto L8;
        r17.setCanceledOnTouchOutside(true);
    L8:
        OAlertDialog r18 = this.deleteConfirmDialog;
        if (r18 == null) goto L11;
        r18.setOnCancelListener(new CallLogDeleteHelper$$ExternalSyntheticLambda2(this));
    L11:
        OAlertDialog r19 = this.deleteConfirmDialog;
        if (r19 == null) goto L14;
        r19.show();
    L14:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(this.fragment.getActivity(), r0, true, false);
        return;
    L4:
        r15 = R.string.dialog_title_delete_call_log_no_record;
        goto L5
    }

    private static final void showConfirmDialog$lambda$1(CallLogDeleteHelper r1, int r2, DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r1.fragment.getActivity(), r2, false, true);
        r1.animateAndDeleteSelected();
        OAlertDialog r5 = r1.deleteConfirmDialog;
        if (r5 == null) goto L6;
        r5.dismiss();
        return;
    }

    private static final void showConfirmDialog$lambda$2(CallLogDeleteHelper r0, int r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r0.fragment.getActivity(), r1, false, false);
        r0.deleteState = DeleteState.IDLE;
        OAlertDialog r4 = r0.deleteConfirmDialog;
        if (r4 == null) goto L6;
        r4.dismiss();
        return;
    }

    private static final void showConfirmDialog$lambda$3(CallLogDeleteHelper r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.deleteState = DeleteState.IDLE;
    }

    private final void animateAndDeleteSelected() {
        this.deleteState = DeleteState.ANIMATING;
        final RecyclerView r3 = this.getRecyclerView.invoke();
        if (r3 != null) goto L6;
        this.deleteState = DeleteState.DIFF_PENDING;
        this.viewModel.deleteSelected();
        return;
    L6:
        final Set<Long> r5 = this.viewModel.getUiState().getValue().getEditMode().getSelectedIds();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "animateAndDeleteSelected: selectedIds=" + r5.size());
        r3.setEnabled(false);
        r3.suppressLayout(true);
        final ArrayList r4 = new ArrayList();
        final CallLogListAdapter r6 = this.getAdapter.invoke();
        int r7 = r3.getChildCount();
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L34;
        View r9 = r3.getChildAt(r8);
        if (r9 == null) goto L33;
        RecyclerView.ViewHolder r10 = r3.getChildViewHolder(r9);
        if ((r10 instanceof CallLogListAdapter.ViewHolder) == false) goto L14;
        CallLogListAdapter.ViewHolder r11 = (CallLogListAdapter.ViewHolder) r10;
    L15:
        if (r11 == null) goto L33;
        List<CallLogItem> r12 = r6.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(r12, "adapter.currentList");
        CallLogItem r13 = (CallLogItem) CollectionsKt.getOrNull(r12, r11.getAdapterPosition());
        if (r13 == null) goto L33;
        List<Long> r14 = r13.getChildIds();
        if ((r14 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r15 = r14.iterator();
    L27:
        if (r15.hasNext() == false) goto L24;
        if (r5.contains(Long.valueOf(((Number) r15.next()).longValue())) == false) goto L27;
        boolean r16 = true;
    L31:
        if (r16 == false) goto L33;
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r9, "translationX", new float[]{0.0f, r9.getWidth()});
        Intrinsics.checkNotNullExpressionValue(r17, "ofFloat(child, \"translationX\", 0f, width)");
        r4.add(r17);
    L24:
        r16 = false;
        goto L31
    L23:
        if (r14.isEmpty() == false) goto L25;
    L14:
        r11 = null;
    L33:
        r8 = r8 + 1;
        goto L7
    L34:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "animateAndDeleteSelected: animators=" + r4.size());
        if (r4.isEmpty() == false) goto L38;
        r3.setEnabled(true);
        r3.suppressLayout(false);
        this.deleteState = DeleteState.DIFF_PENDING;
        this.viewModel.deleteSelected();
        return;
    L38:
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(r4);
        r0.setDuration(200);
        r0.setInterpolator(CubicInterpolator.OUT);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[DEL-ANIM] batch: Phase1 START, " + r4.size() + " items sliding out");
        r0.addListener(new AnonymousClass2(r4, r3, r6, r5, this));
        r0.start();
    }
}
