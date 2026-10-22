package com.mdisdk.capability.input.impl.gesture;

import com.mdisdk.capability.input.EventCallback;
import com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2996a = 1;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(FullScreenHelper fullScreenHelper, String str, boolean z10) {
        this.d = fullScreenHelper;
        this.b = str;
        this.c = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2996a) {
            case 0:
                BaseGestureExecutor.lambda$execute$1(this.c, (EventCallback) this.d, this.b);
                break;
            default:
                FullScreenHelper.onActivityForeground$lambda$0((FullScreenHelper) this.d, this.b, this.c);
                break;
        }
    }

    public /* synthetic */ a(boolean z10, EventCallback eventCallback, String str) {
        this.c = z10;
        this.d = eventCallback;
        this.b = str;
    }
}
