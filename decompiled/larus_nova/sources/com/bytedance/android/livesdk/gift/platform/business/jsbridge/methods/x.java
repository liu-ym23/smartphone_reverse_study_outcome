package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftFailedException;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f129744a;

    public x(y r100) {
        this.f129744a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        JSONObject r102 = new JSONObject();
        r102.put("code", 0);
        if ((r101 instanceof ApiServerException) == false) goto L6;
        ApiServerException r103 = (ApiServerException) r101;
        r102.put("code", r103.getErrorCode());
        r102.put("message", r103.getPrompt());
    L8:
        this.f129744a.finishWithResult(r102);
        return;
    L6:
        if ((r101 instanceof SendGiftFailedException) == false) goto L8;
        JSONObject r104 = new JSONObject();
        r104.put("code", "0");
        r104.put("message", r101.getMessage());
        r102.put("error_data", r104);
        goto L8
    }
}
