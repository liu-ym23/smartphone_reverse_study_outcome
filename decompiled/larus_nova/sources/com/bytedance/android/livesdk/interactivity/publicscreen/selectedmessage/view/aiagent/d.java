package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AiAgentPSSelectedMsgView f139516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f139517b;

    public d(AiAgentPSSelectedMsgView r100, GestureDetector r101) {
        this.f139516a = r100;
        this.f139517b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 == null) goto L4;
        Integer r102 = Integer.valueOf(r101.getAction());
    L6:
        if (r102 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
        return false;
    L14:
        return this.f139517b.onTouchEvent(r101);
    L9:
        if (r102.intValue() != 3) goto L11;
        this.f139516a.f139466a = false;
        goto L11
    L4:
        r102 = null;
        goto L6
    }
}
