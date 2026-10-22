package com.stepos.agentframework.chatcore.safehint;

import Ac.o;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.annotation.BaseUrl;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import yc.v;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\u0006J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/safehint/d;", "", "Lcom/stepos/agentframework/chatcore/safehint/b;", "request", "Lyc/v;", "Lcom/stepos/agentframework/chatcore/safehint/c;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/safehint/b;Le9/c;)Ljava/lang/Object;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String SAFE_HINT_BASE_URL_KEY = "safe_hint_base_url_key";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/safehint/d$a;", "", "<init>", "()V", "", "SAFE_HINT_BASE_URL_KEY", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.safehint.d$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String SAFE_HINT_BASE_URL_KEY = "safe_hint_base_url_key";
    }

    @BaseUrl(key = "safe_hint_base_url_key")
    @o("safe-hint-service/v1/safety_hint")
    Object a(@Ac.a SafeHintRequest safeHintRequest, InterfaceC4014c<? super v<SafeHintResponse>> interfaceC4014c);
}
