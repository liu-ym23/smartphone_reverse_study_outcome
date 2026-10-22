package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c2 f142049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f142050b;

    public a2(c2 r100, CallContext r101) {
        this.f142049a = r100;
        this.f142050b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        c2 r101 = this.f142049a;
        int r102 = ((Integer) r100).intValue();
        CallContext r103 = this.f142050b;
        r101.getClass();
        if (r102 != 0) goto L5;
        JSONObject r104 = new JSONObject();
        r104.put("code", 0);
        r103.b("H5_lottieAnimationStatus", r104);
        r101.finishWithSuccess();
        return;
    L5:
        if (r102 != 1) goto L7;
        JSONObject r105 = new JSONObject();
        r105.put("code", 1);
        r103.b("H5_lottieAnimationStatus", r105);
        return;
    L7:
        if (r102 != 2) goto L15;
        JSONObject r106 = new JSONObject();
        r106.put("code", 2);
        r103.b("H5_lottieAnimationStatus", r106);
        r101.finishWithSuccess();
        return;
    }
}
