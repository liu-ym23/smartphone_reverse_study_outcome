package com.google.android.material.textfield;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity;
import com.stepos.taskrobot.llmapi.stepfun.mirror.UnifiedMirrorView;
import com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2667a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i) {
        this.f2667a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i = this.f2667a;
        Object obj = this.b;
        switch (i) {
            case 0:
                j jVar = (j) obj;
                if (motionEvent.getAction() == 1) {
                    long jUptimeMillis = SystemClock.uptimeMillis() - jVar.o;
                    if (jUptimeMillis < 0 || jUptimeMillis > 300) {
                        jVar.m = false;
                    }
                    jVar.u();
                    jVar.m = true;
                    jVar.o = SystemClock.uptimeMillis();
                }
                return false;
            case 1:
                return FullScreenActivity.initViews$lambda$0((FullScreenActivity) obj, view, motionEvent);
            case 2:
                return UnifiedMirrorView.touchListener$lambda$0((UnifiedMirrorView) obj, view, motionEvent);
            default:
                return PassiveTakeoverPromptPopup.show$lambda$2((PassiveTakeoverPromptPopup) obj, view, motionEvent);
        }
    }
}
