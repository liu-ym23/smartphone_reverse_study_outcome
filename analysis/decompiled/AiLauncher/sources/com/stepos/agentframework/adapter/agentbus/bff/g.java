package com.stepos.agentframework.adapter.agentbus.bff;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.annotation.BaseUrl;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import yc.v;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\rJ0\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\t\u0010\nJ0\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000bH§@¢\u0006\u0004\b\r\u0010\u000eJ0\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/g;", "", "", "authorization", "Lcom/stepos/agentframework/adapter/agentbus/bff/l;", "body", "Lyc/v;", "Lcom/stepos/agentframework/adapter/agentbus/bff/p;", "Lcom/stepos/agentframework/adapter/agentbus/bff/o;", "c", "(Ljava/lang/String;Lcom/stepos/agentframework/adapter/agentbus/bff/l;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/agentbus/bff/m;", "Lcom/stepos/agentframework/adapter/agentbus/bff/n;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/agentframework/adapter/agentbus/bff/m;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/agentbus/bff/q;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/stepos/agentframework/adapter/agentbus/bff/q;Le9/c;)Ljava/lang/Object;", "Companion", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface g {
    public static final String AGENT_PROXY_BASE_URL_KEY = "agent_proxy_base_url_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/g$a;", "", "<init>", "()V", "", "AGENT_PROXY_BASE_URL_KEY", "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.bff.g$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AGENT_PROXY_BASE_URL_KEY = "agent_proxy_base_url_key";
    }

    @BaseUrl(key = "agent_proxy_base_url_key")
    @Ac.o("SessionDelete")
    Object a(@Ac.i("Authorization") String str, @Ac.a SessionDeleteRequest sessionDeleteRequest, InterfaceC4014c<? super v<SessionEnvelope<SessionDeleteResponseData>>> interfaceC4014c);

    @BaseUrl(key = "agent_proxy_base_url_key")
    @Ac.o("SessionRename")
    Object b(@Ac.i("Authorization") String str, @Ac.a SessionRenameRequest sessionRenameRequest, InterfaceC4014c<? super v<SessionEnvelope<SessionDto>>> interfaceC4014c);

    @BaseUrl(key = "agent_proxy_base_url_key")
    @Ac.o("SessionCreate")
    Object c(@Ac.i("Authorization") String str, @Ac.a SessionCreateRequest sessionCreateRequest, InterfaceC4014c<? super v<SessionEnvelope<SessionDto>>> interfaceC4014c);
}
