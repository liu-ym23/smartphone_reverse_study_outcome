package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f118192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f118193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OnBindPhoneListener f118194c;

    public e(Activity r100, OnBindPhoneListener r101) {
        this.f118192a = r100;
        this.f118193b = "send_message";
        this.f118194c = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        Activity r102 = this.f118192a;
        String r103 = this.f118193b;
        OnBindPhoneListener r104 = this.f118194c;
        ((IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class)).startBindMobileFullFragment(r102, "live_detail", "live_detail", r104);
        HashMap r105 = new HashMap();
        r105.put("bind_page_source", r103);
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.f118008b.d("phone_bind_page_show", r105, new Object[0]);
    }
}
