package com.stepos.ailauncher.foundation.credential.api;

import Ac.a;
import Ac.f;
import Ac.o;
import Ac.p;
import Ac.s;
import Ac.t;
import Ac.y;
import e9.InterfaceC4014c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\t\u001a\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\b\u0001\u0010\r\u001a\u00020\fH§@¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\t\u001a\u00020\u00022\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H§@¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\b\b\u0001\u0010\t\u001a\u00020\u00022\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H§@¢\u0006\u0004\b\u0015\u0010\u0013J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\b\b\u0001\u0010\t\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0016\u0010\u000bJ \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0018\u0010\u000b¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/CredentialApi;", "", "", "vendorId", "integrationId", "Lcom/stepos/ailauncher/foundation/credential/api/ApiEnvelope;", "Lcom/stepos/ailauncher/foundation/credential/api/CredentialStatusDto;", com.stepos.ailauncher.task.space.credential.CredentialApi.BASE_URL_KEY, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "path", "credentialAtPath", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/credential/api/SaveCredentialRequest;", "body", "Lcom/stepos/ailauncher/foundation/credential/api/SaveCredentialDto;", "saveCredential", "(Lcom/stepos/ailauncher/foundation/credential/api/SaveCredentialRequest;Le9/c;)Ljava/lang/Object;", "", "completeA2a", "(Ljava/lang/String;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;", "session", "pollSession", "Lcom/stepos/ailauncher/foundation/credential/api/IntegrationDto;", "integration", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CredentialApi {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object credential$default(CredentialApi credentialApi, String str, String str2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: credential");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return credentialApi.credential(str, str2, interfaceC4014c);
    }

    @p
    Object completeA2a(@y String str, @a Map<String, Object> map, InterfaceC4014c<? super ApiEnvelope<CredentialStatusDto>> interfaceC4014c);

    @f("v1/credentials/{vendor_id}")
    Object credential(@s("vendor_id") String str, @t("integration_id") String str2, InterfaceC4014c<? super ApiEnvelope<CredentialStatusDto>> interfaceC4014c);

    @f
    Object credentialAtPath(@y String str, InterfaceC4014c<? super ApiEnvelope<CredentialStatusDto>> interfaceC4014c);

    @f("v1/integrations/{integration_id}")
    Object integration(@s("integration_id") String str, InterfaceC4014c<? super ApiEnvelope<IntegrationDto>> interfaceC4014c);

    @f
    Object pollSession(@y String str, InterfaceC4014c<? super ApiEnvelope<AuthSessionDto>> interfaceC4014c);

    @o("v1/credentials")
    Object saveCredential(@a SaveCredentialRequest saveCredentialRequest, InterfaceC4014c<? super ApiEnvelope<SaveCredentialDto>> interfaceC4014c);

    @o
    Object session(@y String str, @a Map<String, Object> map, InterfaceC4014c<? super ApiEnvelope<AuthSessionDto>> interfaceC4014c);
}
