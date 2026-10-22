package com.obric.memorydata.sdk.service;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.memorydata.sdk.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MemoryDataServiceProxy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MemoryDataServiceProxy$deathRecipient$1 implements IBinder.DeathRecipient {
    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$ESr7yfutRe9Goczfo_d9dF5Su8g() {
        return binderDied$lambda$0();
    }

    public static /* synthetic */ void lambda$MfO30tWstsN4iJ0I5fBe6OwxoIc() {
        binderDied$lambda$2();
    }

    MemoryDataServiceProxy$deathRecipient$1() {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        INVOKESTATIC_com_obric_memorydata_sdk_service_MemoryDataServiceProxy$deathRecipient$1_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("MemoryDataServiceProxy", "binderDied");     // Catch: Exception -> L14
        IMemoryDataService r2 = MemoryDataServiceProxy.b();     // Catch: Exception -> L14
        if (r2 == null) goto L8;
        IBinder r3 = r2.asBinder();     // Catch: Exception -> L14
        if (r3 == null) goto L8;
        r3.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(this, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Exception -> L14
    L8:
        c.a($$Lambda$MemoryDataServiceProxy$deathRecipient$1$ESr7yfutRe9Goczfo_d9dF5Su8g.INSTANCE);     // Catch: Exception -> L14
        MemoryDataServiceProxy r5 = MemoryDataServiceProxy.f33905a;     // Catch: Exception -> L14
        MemoryDataServiceProxy.a(null);     // Catch: Exception -> L14
        MemoryDataServiceProxy.c().removeCallbacks(MemoryDataServiceProxy.d());     // Catch: Exception -> L14
        MemoryDataServiceProxy r6 = MemoryDataServiceProxy.f33905a;     // Catch: Exception -> L14
        MemoryDataServiceProxy.a(false);     // Catch: Exception -> L14
        Collection r7 = MemoryDataServiceProxy.e().values();     // Catch: Exception -> L14
        o.c(r7, "<get-values>(...)");     // Catch: Exception -> L14
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L14
    L10:
        if (r8.hasNext() == false) goto L12;
        ((MemoryDataServiceProxy.a) ZeusTransformUtils.preCheckCast(r8.next(), MemoryDataServiceProxy.a.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L14
        goto L10
    L12:
        MemoryDataServiceProxy.c().postDelayed($$Lambda$MemoryDataServiceProxy$deathRecipient$1$MfO30tWstsN4iJ0I5fBe6OwxoIc.INSTANCE, 5000);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        INVOKESTATIC_com_obric_memorydata_sdk_service_MemoryDataServiceProxy$deathRecipient$1_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MemoryDataServiceProxy", "binderDied error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private static final x binderDied$lambda$0() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(MemoryDataServiceProxy.f(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        ZeusTransformUtils.unbindService(r0, MemoryDataServiceProxy.g(), "com.obric.aiagent.plugin");
        return x.f38692a;
    L5:
        return null;
    }

    private static final void binderDied$lambda$2() {
        MemoryDataServiceProxy.a(MemoryDataServiceProxy.f33905a);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_memorydata_sdk_service_MemoryDataServiceProxy$deathRecipient$1_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_memorydata_sdk_service_MemoryDataServiceProxy$deathRecipient$1_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
