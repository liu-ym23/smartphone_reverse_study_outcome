package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class m2 implements n56.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f142157a;

    public m2(WeakReference<Context> r100) {
        this.f142157a = r100;
    }

    @Override // n56.c
    public void call(n56.f r100, JSONObject r101) throws Exception {
        if ((this.f142157a.get() instanceof Activity) == false) goto L5;
        ((IHostApp) jc1.k.f(IHostApp.class)).startBindPhoneDialogFragment((Activity) this.f142157a.get(), "", "", new l2());
        r101.put("code", 1);
        return;
    L5:
        r101.put("code", 0);
    }
}
