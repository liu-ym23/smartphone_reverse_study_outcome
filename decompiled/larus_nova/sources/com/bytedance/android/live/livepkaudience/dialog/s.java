package com.bytedance.android.live.livepkaudience.dialog;

import android.text.TextUtils;
import android.widget.Button;
import com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class s implements PkWithAudienceFeedbackView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkWithAudienceFeedbackDialog f81848a;

    @Override // com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView.a
    public final void a() {
        PkWithAudienceFeedbackDialog r100 = this.f81848a;
        int r101 = PkWithAudienceFeedbackDialog.f81743m;
        r100.W90();
        if (TextUtils.isEmpty(((PkWithAudienceFeedbackView) this.f81848a.S90(R.id.feedback_view)).getSelectedTag()) == false) goto L7;
        Button r102 = (Button) this.f81848a.S90(R.id.ttlive_submit);
        if (r102 == null) goto L11;
        r102.setAlpha(0.34f);
        return;
    L11:
        return;
    L7:
        Button r103 = (Button) this.f81848a.S90(R.id.ttlive_submit);
        if (r103 == null) goto L13;
        r103.setAlpha(1.0f);
        return;
    }

    public s(PkWithAudienceFeedbackDialog r100) {
        this.f81848a = r100;
    }
}
