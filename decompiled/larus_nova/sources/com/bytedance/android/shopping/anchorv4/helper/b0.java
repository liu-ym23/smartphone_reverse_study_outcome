package com.bytedance.android.shopping.anchorv4.helper;

import android.content.Context;

/* JADX INFO: loaded from: classes12.dex */
public final class b0 implements com.bytedance.android.ec.opt.asynctask.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f166937a;

    @Override // com.bytedance.android.ec.opt.asynctask.w
    public final com.bytedance.android.ec.opt.asynctask.k r() {
        com.bytedance.android.ec.opt.asynctask.r r100 = new com.bytedance.android.ec.opt.asynctask.r();
        r100.f48046a = true;
        return r100.f48050e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f166937a;
        if (r100 == null) goto L6;
        r100.getSharedPreferences("js_kv_methods_20191113", 0);
        return;
    }

    public b0(Context r100) {
        this.f166937a = r100;
    }
}
