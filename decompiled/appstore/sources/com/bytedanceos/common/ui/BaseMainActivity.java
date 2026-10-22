package com.bytedanceos.common.ui;

import android.os.Bundle;
import android.os.Handler;
import com.bytedanceos.common.core.ui.presenter.APresenter;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.toolbox.s;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMainActivity extends StatusBarActivity {
    protected String mFromPkg;
    protected Handler mHandler;
    protected APresenter mPresenter;

    public BaseMainActivity() {
    }

    public boolean isGame() {
        return false;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.mHasExitAnimation.set(false);
        this.mHandler = new Handler();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        APresenter r10 = this.mPresenter;
        if (r10 == null) goto L5;
        r10.c();
    L5:
        AdsReportManager.h().n();
        Handler r11 = this.mHandler;
        if (r11 == null) goto L8;
        r11.removeCallbacksAndMessages(null);
    L8:
        qa.f.e().h();
        if (s.h(getApplicationContext()) == false) goto L11;
    L13:
        d9.a.e().c();
        this.mFromPkg = null;
        return;
    L11:
        if (com.bytedanceos.common.toolbox.e.y0(this.mFromPkg) == true) goto L13;
        y8.f.h();
        y8.f.m();
        goto L13
    }
}
