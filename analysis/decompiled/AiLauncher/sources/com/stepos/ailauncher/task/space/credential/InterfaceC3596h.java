package com.stepos.ailauncher.task.space.credential;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\fH§@¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0011\u0010\u000b¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/h;", "", "", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/task/space/credential/a;", "Lcom/stepos/ailauncher/task/space/credential/g;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "vendorId", "Lcom/stepos/ailauncher/task/space/credential/f;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/task/space/credential/t;", "request", "Lcom/stepos/ailauncher/task/space/credential/s;", "c", "(Ljava/lang/String;Lcom/stepos/ailauncher/task/space/credential/t;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC3596h {
    @Ac.f("v1/credentials")
    Object a(@Ac.i("Authorization") String str, InterfaceC4014c<? super ApiWrapper<CredentialListData>> interfaceC4014c);

    @Ac.f("v1/credentials/{vendor_id}")
    Object b(@Ac.i("Authorization") String str, @Ac.s("vendor_id") String str2, InterfaceC4014c<? super ApiWrapper<CredentialItem>> interfaceC4014c);

    @Ac.o("v1/credentials")
    Object c(@Ac.i("Authorization") String str, @Ac.a SaveCredentialRequest saveCredentialRequest, InterfaceC4014c<? super ApiWrapper<SaveCredentialData>> interfaceC4014c);

    @Ac.b("v1/credentials/{vendor_id}")
    Object d(@Ac.i("Authorization") String str, @Ac.s("vendor_id") String str2, InterfaceC4014c<? super ApiWrapper<Object>> interfaceC4014c);
}
