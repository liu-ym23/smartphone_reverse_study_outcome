package com.bytedance.android.shopping.mall.feed.help;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f176998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f176999b;

    public m(Map r100, String r101) {
        this.f176998a = r100;
        this.f176999b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r100 = com.bytedance.android.ec.hybrid.list.util.k.b(this.f176998a);     // Catch: Throwable -> L4
        r100.putOpt("business_type", this.f176999b);     // Catch: Throwable -> L4
        AppLogNewUtils.onEventV3("mall_card_tag_repeat", r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
