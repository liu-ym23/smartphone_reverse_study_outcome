package com.bytedance.android.livesdk.saas;

import android.content.Context;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public class b implements t60.a {
    public b() {
    }

    @Override // t60.a
    public boolean handle(Context r100, String r101) {
        return ((ILiveActionHandler) k.n(ILiveActionHandler.class)).handle(r100, r101);
    }
}
