package com.stepos.agentframework.adapter.netcore.service;

import C7.r;
import F9.P;
import H7.c;
import V4.I;
import V4.m;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.net.annotation.BaseUrl;
import kotlin.Metadata;
import qa.L;
import sa.InterfaceC1926a;
import sa.i;
import sa.o;
import sa.t;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\b\u0010\tJ4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0012\u0010\u0011J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0017\u0010\u0011¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "", "", "authorization", "LV4/I;", "request", "Lqa/L;", "LC7/r;", "vote", "(Ljava/lang/String;LV4/I;LH7/c;)Ljava/lang/Object;", "deviceId", "LV4/m;", "body", "LF9/P;", "createVM", "(Ljava/lang/String;Ljava/lang/String;LV4/m;LH7/c;)Ljava/lang/Object;", "deleteVM", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "doctorFixVM", "mode", "reInstallVM", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "restartVM", "queryVMStatus", "Companion", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BffService {
    public static final String BFF_BASE_URL_KEY = "bff_base_url_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService$Companion;", "", AppAgent.CONSTRUCT, "()V", "VOTE_PATH", "", "BFF_BASE_URL_KEY", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String BFF_BASE_URL_KEY = "bff_base_url_key";
        private static final String VOTE_PATH = "otter-interaction/Vote";

        private Companion() {
        }
    }

    @BaseUrl(key = "bff_base_url_key")
    @o("task-engine/api/botway/deploy/create")
    Object createVM(@i("Authorization") String str, @i("zy-device-id") String str2, @InterfaceC1926a m mVar, c<? super L<P>> cVar);

    @BaseUrl(key = "bff_base_url_key")
    @o("task-engine/api/botway/deploy/delete")
    Object deleteVM(@i("Authorization") String str, c<? super L<P>> cVar);

    @BaseUrl(key = "bff_base_url_key")
    @o("task-engine/api/botway/deploy/doctor-fix")
    Object doctorFixVM(@i("Authorization") String str, c<? super L<P>> cVar);

    @BaseUrl(key = "bff_base_url_key")
    @o("task-engine/api/botway/deploy/status")
    Object queryVMStatus(@i("Authorization") String str, c<? super L<P>> cVar);

    @BaseUrl(key = "bff_base_url_key")
    @o("task-engine/api/botway/deploy/reinstall")
    Object reInstallVM(@i("Authorization") String str, @t("mode") String str2, c<? super L<P>> cVar);

    @BaseUrl(key = "bff_base_url_key")
    @o("task-engine/api/botway/deploy/restart")
    Object restartVM(@i("Authorization") String str, c<? super L<P>> cVar);

    @BaseUrl(key = "bff_base_url_key")
    @o("otter-interaction/Vote")
    Object vote(@i("Authorization") String str, @InterfaceC1926a I i, c<? super L<r>> cVar);
}
