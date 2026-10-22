package com.stepos.taskrobot.llmapi.stepfun;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4033a;
    public final /* synthetic */ FullScreenHelper b;
    public final /* synthetic */ String c;

    public /* synthetic */ e(FullScreenHelper fullScreenHelper, String str, int i) {
        this.f4033a = i;
        this.b = fullScreenHelper;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4033a) {
            case 0:
                FullScreenHelper.onActivityCreated$lambda$0(this.c, this.b);
                break;
            case 1:
                FullScreenHelper.dismissFullScreenOverlay$lambda$0(this.b, this.c);
                break;
            case 2:
                FullScreenHelper.resumeFullScreenOverlay$lambda$0(this.b, this.c);
                break;
            case 3:
                FullScreenHelper.showActivity$lambda$0$0(this.c, this.b);
                break;
            case 4:
                FullScreenHelper.showActivity$lambda$0$1(this.c, this.b);
                break;
            case 5:
                FullScreenHelper.hideActivity$lambda$0(this.b, this.c);
                break;
            case 6:
                FullScreenHelper.onActivityForeground$lambda$1(this.b, this.c);
                break;
            default:
                FullScreenHelper.onLlmRequestTakeover$lambda$0(this.b, this.c);
                break;
        }
    }

    public /* synthetic */ e(String str, FullScreenHelper fullScreenHelper, int i) {
        this.f4033a = i;
        this.c = str;
        this.b = fullScreenHelper;
    }
}
