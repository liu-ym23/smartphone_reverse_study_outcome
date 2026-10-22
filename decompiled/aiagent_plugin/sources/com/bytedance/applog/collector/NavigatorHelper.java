package com.bytedance.applog.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.applog.c;
import com.bytedance.applog.store.h;

/* JADX INFO: loaded from: classes.dex */
public class NavigatorHelper implements Handler.Callback {
    private final int MSG_PAGE_PAUSE;
    private final c appLogInstance;
    private int existsPageCount;
    private final Handler handler;
    private boolean isBackground;
    private boolean isColdLaunch;

    public NavigatorHelper(c r3, Looper r4) {
        this.isColdLaunch = true;
        this.existsPageCount = 0;
        this.MSG_PAGE_PAUSE = 9999;
        this.isBackground = false;
        this.appLogInstance = r3;
        this.handler = new Handler(r4, this);
    }

    public void onPageReceived(h r5) {
        if (r5.u <= 0) goto L5;
        this.handler.sendEmptyMessageDelayed(9999, 500);
        this.existsPageCount = Math.max(0, this.existsPageCount - 1);
        return;
    L5:
        this.handler.removeMessages(9999);
        this.existsPageCount++;
        if (this.isColdLaunch == false) goto L9;
        this.isColdLaunch = false;
        onAppColdLaunch();
    L9:
        if (this.isBackground == false) goto L13;
        this.isBackground = false;
        onAppHotLaunch();
        return;
    }

    private void onAppHotLaunch() {
        this.appLogInstance.Z().d("App back to frontend...", new Object[0]);
        if (this.appLogInstance.f() != null) goto L5;
        return;
    L5:
        if (this.appLogInstance.f().Q() == false) goto L9;
        this.appLogInstance.c();
        return;
    }

    private void onAppColdLaunch() {
        this.appLogInstance.Z().d("App first to frontend...", new Object[0]);
    }

    private void onAppToBackground() {
        this.appLogInstance.Z().d("App enter to background...", new Object[0]);
        if (this.appLogInstance.f() == null) goto L8;
        if (this.appLogInstance.f().P() == false) goto L8;
        this.appLogInstance.g();
    L8:
        if (this.appLogInstance.f() != null) goto L10;
    L12:
        this.appLogInstance.N().flush();
        return;
    L10:
        if (this.appLogInstance.f().Q() == false) goto L12;
        this.appLogInstance.d();
        goto L12
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (r2.what != 9999) goto L7;
        this.isBackground = true;
        onAppToBackground();
        return false;
    L7:
        return false;
    }
}
