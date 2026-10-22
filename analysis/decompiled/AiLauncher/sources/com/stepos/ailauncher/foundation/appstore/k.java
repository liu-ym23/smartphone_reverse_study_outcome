package com.stepos.ailauncher.foundation.appstore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionListApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/k;", "", "Lkotlin/Function1;", "", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListApi;", "create", "<init>", "(Lp9/l;)V", "baseUrl", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListApi;", "Lp9/l;", "Lkotlin/Pair;", "cached", "Lkotlin/Pair;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class k {
    private Pair<String, ? extends AppVersionListApi> cached;
    private final InterfaceC5074l<String, AppVersionListApi> create;

    /* JADX WARN: Multi-variable type inference failed */
    public k(InterfaceC5074l<? super String, ? extends AppVersionListApi> create) {
        p.i(create, "create");
        this.create = create;
    }

    public final synchronized AppVersionListApi a(String baseUrl) {
        p.i(baseUrl, "baseUrl");
        Pair<String, ? extends AppVersionListApi> pair = this.cached;
        if (pair != null) {
            if (!p.d(pair.e(), baseUrl)) {
                pair = null;
            }
            if (pair != null) {
                return pair.f();
            }
        }
        AppVersionListApi appVersionListApiInvoke = this.create.invoke(baseUrl);
        this.cached = Y8.j.a(baseUrl, appVersionListApiInvoke);
        return appVersionListApiInvoke;
    }
}
