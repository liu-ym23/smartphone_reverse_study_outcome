package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class ee<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ge f63364a;

    public ee(ge r100) {
        this.f63364a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        b30.h0 r101 = (b30.h0) r100;
        ge r102 = this.f63364a;
        boolean r103 = r101.f17134a;
        CallContext r104 = r102.getCallContext();
        JSONObject r105 = new JSONObject();
        r105.put("code", r103 ? 1 : 0);
        Unit r106 = Unit.INSTANCE;
        r104.b("H5_zmCertStatus", r105);
        if (r101.f17134a == false) goto L5;
        this.f63364a.finishWithSuccess();
        return;
    L5:
        this.f63364a.finishWithFailure();
    }
}
