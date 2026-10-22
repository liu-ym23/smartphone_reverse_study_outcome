package com.android.contacts.calllog;

import android.os.Handler;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.model.CallFeatureModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewCallLogFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/android/contacts/calllog/NewCallLogFragment$callSummaryFinishedListener$1", "Lcom/obric/model/CallFeatureModel$CallSummaryFinishedListener;", "onCallSummaryFinished", "", "data", "Lkotlin/Pair;", "", "", "callSummary", "Lcom/obric/callsummary/bean/CallSummaryResult;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewCallLogFragment$callSummaryFinishedListener$1 implements CallFeatureModel.CallSummaryFinishedListener {
    final /* synthetic */ NewCallLogFragment this$0;

    public static /* synthetic */ void $r8$lambda$6rJ98cREt9ymnQ67oD2Cp2VsVTc(NewCallLogFragment r0) {
        onCallSummaryFinished$lambda$0(r0);
    }

    NewCallLogFragment$callSummaryFinishedListener$1(NewCallLogFragment r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.model.CallFeatureModel.CallSummaryFinishedListener
    public void onCallSummaryFinished(Pair<Long, String> r2, CallSummaryResult r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r3 == null) goto L5;
        return;
    L5:
        Handler r4 = NewCallLogFragment.access$getMHandler$p(this.this$0);
        final NewCallLogFragment r1 = this.this$0;
        r4.post(new NewCallLogFragment$callSummaryFinishedListener$1$$ExternalSyntheticLambda0(r1));
    }

    private static final void onCallSummaryFinished$lambda$0(NewCallLogFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        CallLogAdapter r2 = r1.getCallLogAdapter();
        if (r2 == null) goto L6;
        r2.notifyDataSetChanged();
        return;
    }
}
