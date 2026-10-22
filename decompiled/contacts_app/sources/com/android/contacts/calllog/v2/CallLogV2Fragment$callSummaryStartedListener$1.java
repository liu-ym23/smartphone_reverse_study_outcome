package com.android.contacts.calllog.v2;

import android.view.View;
import com.GlobalProxyLancet;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.model.CallFeatureModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogV2Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016¨\u0006\b"}, d2 = {"com/android/contacts/calllog/v2/CallLogV2Fragment$callSummaryStartedListener$1", "Lcom/obric/model/CallFeatureModel$CallSummaryStartedListener;", "onCallSummaryStarted", "", "data", "Lkotlin/Pair;", "", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogV2Fragment$callSummaryStartedListener$1 implements CallFeatureModel.CallSummaryStartedListener {
    final /* synthetic */ CallLogV2Fragment this$0;

    /* JADX INFO: renamed from: $r8$lambda$C6jvEPA6lnJ6es-uBK2JmgTojM4, reason: not valid java name */
    public static /* synthetic */ void m160$r8$lambda$C6jvEPA6lnJ6esuBK2JmgTojM4(CallLogV2Fragment r0, Pair r1) {
        onCallSummaryStarted$lambda$0(r0, r1);
    }

    CallLogV2Fragment$callSummaryStartedListener$1(CallLogV2Fragment r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.model.CallFeatureModel.CallSummaryStartedListener
    public void onCallSummaryStarted(final Pair<Long, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "fragment summaryStarted date=" + r4.getFirst().longValue());
        View r0 = this.this$0.getView();
        if (r0 == null) goto L6;
        final CallLogV2Fragment r3 = this.this$0;
        r0.post(new CallLogV2Fragment$callSummaryStartedListener$1$$ExternalSyntheticLambda0(r3, r4));
        return;
    }

    private static final void onCallSummaryStarted$lambda$0(CallLogV2Fragment r6, Pair r7) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$data");
        if (r6.isAdded() == true) goto L5;
        return;
    L5:
        CallLogListAdapter r0 = CallLogV2Fragment.access$getListAdapter$p(r6);
        CallLogListAdapter r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r0 = null;
    L8:
        Integer r2 = r0.findPositionByDateNumber(((Number) r7.getFirst()).longValue(), (String) r7.getSecond());
        if (r2 == null) goto L16;
        int r3 = r2.intValue();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "fragment notifySummaryStarted date=" + ((Number) r7.getFirst()).longValue() + " pos=" + r3);
        CallLogListAdapter r8 = CallLogV2Fragment.access$getListAdapter$p(r6);
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L14:
        r1.notifyItemChanged(r3);
        return;
    L13:
        r1 = r8;
        goto L14
    }
}
