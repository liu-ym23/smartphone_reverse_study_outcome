package com.stepos.ailauncher.oobe.api;

import Ac.a;
import Ac.i;
import Ac.o;
import M5.b;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import tb.AbstractC5529B;
import tb.AbstractC5531D;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/OobeMemoryIngestService;", "", "", b.CREDENTIAL_TOKEN, "Ltb/B;", "body", "Ltb/D;", "ingestMemory", "(Ljava/lang/String;Ltb/B;Le9/c;)Ljava/lang/Object;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OobeMemoryIngestService {
    @o("stepmem-cloud-user/oobe/ingest")
    Object ingestMemory(@i("Authorization") String str, @a AbstractC5529B abstractC5529B, InterfaceC4014c<? super AbstractC5531D> interfaceC4014c);
}
