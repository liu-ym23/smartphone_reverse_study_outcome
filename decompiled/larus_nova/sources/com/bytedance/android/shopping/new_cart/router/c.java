package com.bytedance.android.shopping.new_cart.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f179173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f179174b;

    @Override // com.bytedance.android.ec.opt.asynctask.w
    public final k r() {
        r r100 = new r();
        r100.f48047b = true;
        return r100.f48051f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = ECSdk.f48106a;
        o r101 = (o) ECSdk.a(o.class);
        if (r101 == null) goto L6;
        o.a.a(r101, this.f179173a, "cart_page", this.f179174b.toString(), VmSdkSetting.a().b());
        return;
    }

    public c(Context r100, Uri r101) {
        this.f179173a = r100;
        this.f179174b = r101;
    }
}
