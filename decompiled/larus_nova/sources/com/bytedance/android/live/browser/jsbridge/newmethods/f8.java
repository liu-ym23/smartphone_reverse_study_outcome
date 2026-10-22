package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.hardware.SensorManager;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class f8<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g8 f63376a;

    public f8(g8 r100) {
        this.f63376a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        g8 r102 = this.f63376a;
        SensorManager r103 = r102.f63392a;
        if (r103 == null) goto L9;
        if (fna.g.d() == true) goto L7;
        r103.unregisterListener(r102);
        goto L9
    L7:
        r103.unregisterListener(r102);
        ona.b.c(new ona.a(r102.hashCode(), null));
    L9:
        if (this.f63376a.f63394c == true) goto L12;
        JSONObject r104 = new JSONObject();
        r104.put("code", 0);
        this.f63376a.finishWithResult(r104);
        return;
    }
}
