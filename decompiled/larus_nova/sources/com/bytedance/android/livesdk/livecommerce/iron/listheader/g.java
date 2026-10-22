package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f148830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f148831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gi2.a f148832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f148833d;

    public g(boolean r100, String r101, gi2.a r102, Map r103) {
        this.f148830a = r100;
        this.f148831b = r101;
        this.f148832c = r102;
        this.f148833d = r103;
    }

    public final void a() {
        if (this.f148830a == false) goto L8;
        String r100 = "livesdk_click_" + this.f148831b;
        com.bytedance.android.ec.common.api.jump.model.a r101 = this.f148832c;
        if (r101 != null) goto L7;
        r101 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
    L7:
        v r102 = new v(r100, r101);
        r102.c(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "live_list");
        r102.d(this.f148833d);
        r102.i(null);
        return;
    L8:
        String r103 = "livesdk_show_" + this.f148831b;
        com.bytedance.android.ec.common.api.jump.model.a r104 = this.f148832c;
        if (r104 != null) goto L11;
        r104 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
    L11:
        v r105 = new v(r103, r104);
        r105.c(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "live_list");
        r105.d(this.f148833d);
        r105.i(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
