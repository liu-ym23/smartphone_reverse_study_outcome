package com.obric.settings;

import com.GlobalProxyLancet;
import com.obric.contactprovider.ObricCallRecordSummaryDeleteObserver;
import com.obric.widget.EmptySupportRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallRecordList.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/settings/CallRecordList$recordDeleteListener$1", "Lcom/obric/contactprovider/ObricCallRecordSummaryDeleteObserver$RecordSummaryChangeListener;", "deleteRecord", "", "callCreateTime", "", "phoneNumber", "deleteSummary", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallRecordList$recordDeleteListener$1 implements ObricCallRecordSummaryDeleteObserver.RecordSummaryChangeListener {
    final /* synthetic */ CallRecordList this$0;

    /* JADX INFO: renamed from: $r8$lambda$UETCKomER4p-1AJE-4AHArskLYw, reason: not valid java name */
    public static /* synthetic */ void m765$r8$lambda$UETCKomER4p1AJE4AHArskLYw(CallRecordList r0) {
        deleteRecord$lambda$1(r0);
    }

    CallRecordList$recordDeleteListener$1(CallRecordList r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.contactprovider.ObricCallRecordSummaryDeleteObserver.RecordSummaryChangeListener
    public void deleteRecord(String r1, String r2) {
        final CallRecordList r0 = this.this$0;
        r0.runOnUiThread(new CallRecordList$recordDeleteListener$1$$ExternalSyntheticLambda0(r0));
    }

    private static final void deleteRecord$lambda$1(CallRecordList r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        EmptySupportRecyclerView r0 = CallRecordList.access$getRecyclerView$p(r1);
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L5:
        Adapter r2 = CallRecordList.access$getAdapter$p(r1);
        r2.startQuery();
        r0.setAdapter(r2);
    }

    @Override // com.obric.contactprovider.ObricCallRecordSummaryDeleteObserver.RecordSummaryChangeListener
    public void deleteSummary(String r1, String r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CallRecordList", "recordDeleteListener#deleteSummary");
    }
}
