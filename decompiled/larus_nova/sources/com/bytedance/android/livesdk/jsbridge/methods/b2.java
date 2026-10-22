package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class b2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c2 f142057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f142058b;

    public b2(c2 r100, CallContext r101) {
        this.f142057a = r100;
        this.f142058b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        JSONObject r102 = new JSONObject();
        r102.put("code", 0);
        this.f142058b.b("H5_lottieAnimationStatus", r102);
        this.f142057a.finishWithSuccess();
    }
}
