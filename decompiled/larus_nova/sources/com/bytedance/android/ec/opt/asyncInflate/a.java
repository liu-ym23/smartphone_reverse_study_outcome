package com.bytedance.android.ec.opt.asyncInflate;

import android.os.Handler;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.android.ec.opt.asynctask.x;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsyncInflaterImpl f48024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AsyncInflaterImpl.b f48025b;

    @Override // com.bytedance.android.ec.opt.asynctask.w
    public final k r() {
        r r100 = new r();
        r100.f48048c = true;
        x r101 = r100.f48052g;
        r101.f48041b = true;
        return r101.f48042c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Handler) this.f48024a.f48014f.getValue()).post(new AsyncInflaterImpl.InflateTask(this.f48024a, this.f48025b));
    }

    public a(AsyncInflaterImpl r100, AsyncInflaterImpl.b r101) {
        this.f48024a = r100;
        this.f48025b = r101;
    }
}
