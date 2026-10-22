package com.stepos.agentframework.adapter.netcore.service;

import Ac.i;
import Ac.o;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.annotation.BaseUrl;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.VoteRequest;
import yc.v;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\bJ,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/a;", "", "", "authorization", "LK6/O;", "request", "Lyc/v;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;LK6/O;Le9/c;)Ljava/lang/Object;", "Companion", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface a {
    public static final String BFF_BASE_URL_KEY = "bff_base_url_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/a$a;", "", "<init>", "()V", "", "VOTE_PATH", "Ljava/lang/String;", "BFF_BASE_URL_KEY", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.netcore.service.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String BFF_BASE_URL_KEY = "bff_base_url_key";
        private static final String VOTE_PATH = "otter-interaction/Vote";
    }

    @BaseUrl(key = "bff_base_url_key")
    @o("otter-interaction/Vote")
    Object a(@i("Authorization") String str, @Ac.a VoteRequest voteRequest, InterfaceC4014c<? super v<t>> interfaceC4014c);
}
