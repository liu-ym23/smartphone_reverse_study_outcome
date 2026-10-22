package com.stepos.taskrobot.appwhitelist.remote;

import F9.F;
import H7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import f6.AbstractC1439d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import ra.C1884a;
import u1.d;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/remote/RetrofitWhitelistRemoteSource;", "Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistRemoteSource;", "", "baseUrl", "LF9/F;", "okHttpClient", AppAgent.CONSTRUCT, "(Ljava/lang/String;LF9/F;)V", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "fetch", "(LH7/c;)Ljava/lang/Object;", "Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistApi;", "api", "Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistApi;", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RetrofitWhitelistRemoteSource implements WhitelistRemoteSource {
    private final WhitelistApi api;

    public RetrofitWhitelistRemoteSource(String str, F f, int i, e eVar) {
        this(str, (i & 2) != 0 ? (F) AbstractC1439d.f4442a.getF4884a() : f);
    }

    @Override // com.stepos.taskrobot.appwhitelist.remote.WhitelistRemoteSource
    public Object fetch(c<? super WhitelistManifestDto> cVar) {
        return this.api.fetchManifest(cVar);
    }

    public RetrofitWhitelistRemoteSource(String baseUrl, F okHttpClient) {
        k.f(baseUrl, "baseUrl");
        k.f(okHttpClient, "okHttpClient");
        d dVar = new d(20);
        dVar.I(baseUrl);
        dVar.b = okHttpClient;
        ((ArrayList) dVar.d).add(C1884a.c(new Gson()));
        Object objB = dVar.J().b(WhitelistApi.class);
        k.e(objB, "create(...)");
        this.api = (WhitelistApi) objB;
    }
}
