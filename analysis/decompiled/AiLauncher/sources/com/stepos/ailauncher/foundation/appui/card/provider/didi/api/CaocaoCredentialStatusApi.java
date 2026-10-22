package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import Ac.f;
import Ac.s;
import Ac.t;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import yc.v;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusApi;", "", "", "vendorId", "integrationId", "Lyc/v;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusEnvelope;", "status", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CaocaoCredentialStatusApi {
    @f("v1/credentials/{vendor_id}")
    Object status(@s("vendor_id") String str, @t("integration_id") String str2, InterfaceC4014c<? super v<CaocaoCredentialStatusEnvelope>> interfaceC4014c);
}
