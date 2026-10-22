package com.bytedance.android.livesdk.authorize;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import io.reactivex.functions.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SilentAuthProtocolDialog f104225a;

    public v(SilentAuthProtocolDialog r100) {
        this.f104225a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        if (this.f104225a.f104197a == false) goto L13;
        IHostCommerceServiceLive r102 = (IHostCommerceServiceLive) jc1.k.f(IHostCommerceServiceLive.class);
        if (r102 == null) goto L14;
        r102.sendMessage(new JSONObject().put("applyNormalCoupon", true), null);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        return;
    }
}
