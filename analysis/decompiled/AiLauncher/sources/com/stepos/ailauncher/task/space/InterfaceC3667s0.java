package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import tb.AbstractC5529B;
import tb.AbstractC5531D;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\t\u0010\bJ$\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u000b\u0010\bJ$\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\f\u0010\b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/task/space/s0;", "", "", M5.b.CREDENTIAL_TOKEN, "Ltb/B;", "body", "Lcom/stepos/ailauncher/task/space/MemorySettingResponse;", "c", "(Ljava/lang/String;Ltb/B;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Ltb/D;", Const.INTENT_KEY_PKGNAME, "ingestMemory", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.s0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC3667s0 {
    @Ac.o("stepmem-cloud-user/memory_setting/update")
    Object a(@Ac.i("Authorization") String str, @Ac.a AbstractC5529B abstractC5529B, InterfaceC4014c<? super MemorySettingResponse> interfaceC4014c);

    @Ac.o("stepmem-cloud-user/ux_memory/get")
    Object b(@Ac.i("Authorization") String str, @Ac.a AbstractC5529B abstractC5529B, InterfaceC4014c<? super AbstractC5531D> interfaceC4014c);

    @Ac.o("stepmem-cloud-user/memory_setting/get")
    Object c(@Ac.i("Authorization") String str, @Ac.a AbstractC5529B abstractC5529B, InterfaceC4014c<? super MemorySettingResponse> interfaceC4014c);

    @Ac.o("stepmem-cloud-user/oobe/ingest")
    Object ingestMemory(@Ac.i("Authorization") String str, @Ac.a AbstractC5529B abstractC5529B, InterfaceC4014c<? super AbstractC5531D> interfaceC4014c);
}
