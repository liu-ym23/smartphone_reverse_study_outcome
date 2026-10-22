package com.android.contacts.calllog.v2;

import android.view.View;
import com.obric.model.CallFeatureModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogV2Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/android/contacts/calllog/v2/CallLogV2Fragment$callFeatureListener$1", "Lcom/obric/model/CallFeatureModel$CallFeatureModelListener;", "onDataReady", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogV2Fragment$callFeatureListener$1 implements CallFeatureModel.CallFeatureModelListener {
    final /* synthetic */ CallLogV2Fragment this$0;

    public static /* synthetic */ void $r8$lambda$QY4p1JGoJM0vhor0fg82IbceEnM(CallLogV2Fragment r0) {
        onDataReady$lambda$0(r0);
    }

    CallLogV2Fragment$callFeatureListener$1(CallLogV2Fragment r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.model.CallFeatureModel.CallFeatureModelListener
    public void onDataReady() {
        View r0 = this.this$0.getView();
        if (r0 == null) goto L6;
        final CallLogV2Fragment r2 = this.this$0;
        r0.post(new CallLogV2Fragment$callFeatureListener$1$$ExternalSyntheticLambda0(r2));
        return;
    }

    private static final void onDataReady$lambda$0(CallLogV2Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r3.isAdded() == true) goto L5;
        return;
    L5:
        CallLogListAdapter r0 = CallLogV2Fragment.access$getListAdapter$p(r3);
        CallLogListAdapter r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r0 = null;
    L8:
        CallLogListAdapter r4 = CallLogV2Fragment.access$getListAdapter$p(r3);
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L12:
        r0.notifyItemRangeChanged(0, r1.getItemCount(), CallLogListAdapter.PAYLOAD_CONTACT_INFO);
        return;
    L11:
        r1 = r4;
        goto L12
    }
}
