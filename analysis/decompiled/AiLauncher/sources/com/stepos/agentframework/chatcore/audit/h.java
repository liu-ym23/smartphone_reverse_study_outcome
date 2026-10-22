package com.stepos.agentframework.chatcore.audit;

import Ac.o;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.annotation.BaseUrl;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import yc.v;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\u0006J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/h;", "", "Lcom/stepos/agentframework/chatcore/audit/c;", "request", "Lyc/v;", "Lcom/stepos/agentframework/chatcore/audit/f;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/audit/c;Le9/c;)Ljava/lang/Object;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface h {
    public static final String AUDIT_BASE_URL_KEY = "audit_base_url_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/h$a;", "", "<init>", "()V", "", "AUDIT_BASE_URL_KEY", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.audit.h$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AUDIT_BASE_URL_KEY = "audit_base_url_key";
    }

    @BaseUrl(key = "audit_base_url_key")
    @o("cloud-risk-audit/api/v1/inner/risk-audit/rich-text ")
    Object a(@Ac.a AuditRequest auditRequest, InterfaceC4014c<? super v<AuditResponse>> interfaceC4014c);
}
