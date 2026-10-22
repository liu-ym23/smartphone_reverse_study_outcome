package com.android.contacts.dialpad;

import com.GlobalProxyLancet;
import com.android.contacts.recommend.BaseFlowAdapter;
import com.android.contacts.recommend.RecommendUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewDialpadFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/android/contacts/dialpad/NewDialpadFragment$preloadRecommendData$t$1", "Ljava/lang/Thread;", "run", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewDialpadFragment$preloadRecommendData$t$1 extends Thread {
    final /* synthetic */ NewDialpadFragment this$0;

    /* JADX INFO: renamed from: $r8$lambda$oNtUMpc4J_K9-OdIcQQu3y2O7Sk, reason: not valid java name */
    public static /* synthetic */ void m185$r8$lambda$oNtUMpc4J_K9OdIcQQu3y2O7Sk(NewDialpadFragment r0, List r1) {
        run$lambda$0(r0, r1);
    }

    NewDialpadFragment$preloadRecommendData$t$1(NewDialpadFragment r1) {
        this.this$0 = r1;
        super("PreloadRecommendData");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        final List<BaseFlowAdapter.FlowEntry> r0 = RecommendUtil.loadRecommendDataFromFile();
        if (r0 != null) goto L5;
        return;
    L5:
        if (NewDialpadFragment.access$getDEBUG$cp() == false) goto L7;
        NewDialpadFragment.Companion.access$log(NewDialpadFragment.Companion, "Dialpad preloadRecommendData: loadSize=" + r0.size() + ", isPreLoading=" + NewDialpadFragment.access$getMIsLoadingCalls$p(this.this$0) + ", " + NewDialpadFragment.access$getMTmpDataList$p(this.this$0));
    L7:
        NewDialpadFragment$mHandler$1 r1 = NewDialpadFragment.access$getMHandler$p(this.this$0);
        if (r1 == null) goto L12;
        final NewDialpadFragment r4 = this.this$0;
        r1.post(new NewDialpadFragment$preloadRecommendData$t$1$$ExternalSyntheticLambda0(r4, r0));
        return;
    }

    private static final void run$lambda$0(NewDialpadFragment r3, List r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        StringBuilder r0 = new StringBuilder("Preload recommend data : ");
        Integer r2 = null;
        if (NewDialpadFragment.access$getMTmpDataList$p(r3) == null) goto L8;
        List r1 = NewDialpadFragment.access$getMTmpDataList$p(r3);
        if (r1 == null) goto L8;
        r2 = Integer.valueOf(r1.size());
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("DialpadFragment", r0.append(r2).append(", ").append(NewDialpadFragment.access$getMIsLoadingCalls$p(r3)).append(", ").append(r4.isEmpty()).toString());
        if (NewDialpadFragment.access$getMTmpDataList$p(r3) == null) goto L11;
        return;
    L11:
        if (NewDialpadFragment.access$getMIsLoadingCalls$p(r3) == true) goto L13;
        return;
    L13:
        if (r4.isEmpty() == true) goto L18;
        NewDialpadFragment.access$updateCallLogList(r3, r4);
        return;
    }
}
