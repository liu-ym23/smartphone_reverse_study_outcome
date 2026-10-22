package com.bytedance.android.live.ktv.common.ordersong.feedback;

import com.bytedance.android.live.core.utils.d2;

/* JADX INFO: loaded from: classes45.dex */
public final class g extends d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvFeedbackDialog f70167a;

    public g(KtvFeedbackDialog r100) {
        this.f70167a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 == null) goto L7;
        String r104 = r100.toString();
        if (r104 == null) goto L8;
        KtvFeedbackDialog r105 = this.f70167a;
        r105.f70140n = r104;
        r105.Z90();
        return;
    L8:
        return;
    }
}
