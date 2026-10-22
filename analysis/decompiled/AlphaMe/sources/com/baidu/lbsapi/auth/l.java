package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class l extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f4948a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f4948a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException {
        b.a("handleMessage !!");
        if (message.what == 0) {
            this.f4948a.a((JSONObject) message.obj);
        }
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) LBSAuthManager.f4907j.get(message.getData().getString("listenerKey"));
        b.a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}
