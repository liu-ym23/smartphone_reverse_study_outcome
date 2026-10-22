package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AiAgentPSSelectedMsgView f139509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f139510b;

    public a(AiAgentPSSelectedMsgView r100, Context r101) {
        this.f139509a = r100;
        this.f139510b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f139509a.o(this.f139510b);
    }
}
