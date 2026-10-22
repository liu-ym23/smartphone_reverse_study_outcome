package com.bytedance.android.livesdk.authorize;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import io.reactivex.functions.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f104214a = null;

    static {
        f104214a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        IHostCommerceServiceLive r102 = (IHostCommerceServiceLive) jc1.k.f(IHostCommerceServiceLive.class);
        if (r102 == null) goto L11;
        r102.sendMessage(new JSONObject().put("applyNormalCoupon", true), null);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
