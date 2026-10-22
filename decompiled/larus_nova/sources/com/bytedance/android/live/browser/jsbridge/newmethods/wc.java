package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class wc implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xc f63712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f63713b;

    public wc(xc r100, JSONObject r101) {
        this.f63712a = r100;
        this.f63713b = r101;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f63712a.finishWithResult(this.f63713b);
    }
}
