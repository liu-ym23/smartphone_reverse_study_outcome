package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.MdnsServiceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class b7<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z6 f63315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f63316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f63317c;

    public b7(z6 r100, CallContext r101, String r102) {
        this.f63315a = r100;
        this.f63316b = r101;
        this.f63317c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.i("DiscoverServicesMethod", "timeout start stopDiscovery");
        MdnsServiceManager.f158767c.c(this.f63316b.getContext(), this.f63317c);
        z6 r102 = this.f63315a;
        LiveStartDiscoveryServiceResultModel r103 = new LiveStartDiscoveryServiceResultModel();
        r103.b(LiveStartDiscoveryServiceResultModel.Code.Timeout);
        r103.a(0);
        Unit r104 = Unit.INSTANCE;
        r102.finishWithResult(r103);
    }
}
