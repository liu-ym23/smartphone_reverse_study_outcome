package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class fe<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ge f63378a;

    public fe(ge r100) {
        this.f63378a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        CallContext r102 = this.f63378a.getCallContext();
        JSONObject r103 = new JSONObject();
        r103.put("code", 0);
        Unit r104 = Unit.INSTANCE;
        r102.b("H5_zmCertStatus", r103);
        this.f63378a.finishWithFailure();
    }
}
