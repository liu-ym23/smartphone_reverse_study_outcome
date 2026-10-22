package com.android.contacts.calllog.v2;

import android.view.View;
import com.GlobalProxyLancet;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.model.CallFeatureModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogV2Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/android/contacts/calllog/v2/CallLogV2Fragment$callSummaryFinishedListener$1", "Lcom/obric/model/CallFeatureModel$CallSummaryFinishedListener;", "onCallSummaryFinished", "", "data", "Lkotlin/Pair;", "", "", "callSummary", "Lcom/obric/callsummary/bean/CallSummaryResult;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogV2Fragment$callSummaryFinishedListener$1 implements CallFeatureModel.CallSummaryFinishedListener {
    final /* synthetic */ CallLogV2Fragment this$0;

    /* JADX INFO: renamed from: $r8$lambda$Uq0-w5NjHtEfNoruVORGfTBJvb0, reason: not valid java name */
    public static /* synthetic */ void m159$r8$lambda$Uq0w5NjHtEfNoruVORGfTBJvb0(CallLogV2Fragment r0, Pair r1) {
        onCallSummaryFinished$lambda$0(r0, r1);
    }

    CallLogV2Fragment$callSummaryFinishedListener$1(CallLogV2Fragment r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.model.CallFeatureModel.CallSummaryFinishedListener
    public void onCallSummaryFinished(final Pair<Long, String> r4, CallSummaryResult r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        StringBuilder r0 = new StringBuilder("fragment summaryFinished date=").append(r4.getFirst().longValue()).append(" resultError=");
        Integer r1 = null;
        if (r5 == null) goto L5;
        Integer r2 = Integer.valueOf(r5.getErrorCode());
    L6:
        StringBuilder r3 = r0.append(r2).append(" summaryError=");
        if (r5 == null) goto L11;
        CallSummary r6 = r5.getData();
        if (r6 == null) goto L11;
        r1 = Integer.valueOf(r6.getErrorCode());
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r3.append(r1).toString());
        if (r5 == null) goto L14;
        return;
    L14:
        View r7 = this.this$0.getView();
        if (r7 == null) goto L18;
        final CallLogV2Fragment r8 = this.this$0;
        r7.post(new CallLogV2Fragment$callSummaryFinishedListener$1$$ExternalSyntheticLambda0(r8, r4));
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private static final void onCallSummaryFinished$lambda$0(CallLogV2Fragment r6, Pair r7) {
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
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "fragment notifyTransientFailure date=" + ((Number) r7.getFirst()).longValue() + " pos=" + r3);
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
