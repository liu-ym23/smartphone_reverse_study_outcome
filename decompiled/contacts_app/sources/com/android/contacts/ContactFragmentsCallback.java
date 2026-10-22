package com.android.contacts;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class ContactFragmentsCallback {
    private static final int MSG_HIDE_VEIL = 30;
    private static final int MSG_SHOW_VEIL = 10;
    private static final int PROTECTED_TIME = 2000;
    private static final int PROTECTED_TIME_UP = 20;
    private static final String TAG = "ContactFragmentsCallback";
    private Context mContext;
    private Handler mHandler;
    private View mVeilView;

    static /* synthetic */ View access$000(ContactFragmentsCallback r0) {
        return r0.mVeilView;
    }

    public ContactFragmentsCallback(Context r2) {
        this.mContext = r2;
        final Looper r0 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r0);
    }

    public void setVeilView(View r1) {
        this.mVeilView = r1;
    }

    public void coverVeil() {
        coverVeilForTime(0);
    }

    public void coverVeilForTime(long r3) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "cover veil");
    L5:
        removeAllMessages();
        this.mHandler.sendEmptyMessage(10);
        if (r3 <= 0) goto L8;
        this.mHandler.sendEmptyMessageDelayed(30, r3);
        return;
    L8:
        this.mHandler.sendEmptyMessageDelayed(20, 2000);
    }

    public void liftVeil() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "left veil");
    L5:
        removeAllMessages();
        this.mHandler.sendEmptyMessage(30);
    }

    private void removeAllMessages() {
        this.mHandler.removeMessages(20);
        this.mHandler.removeMessages(10);
        this.mHandler.removeMessages(30);
    }
}
