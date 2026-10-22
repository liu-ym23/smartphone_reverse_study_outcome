package com.obric.cae.libs.multipath;

import android.os.IBinder;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CaeMultipathClient.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaeMultipathClient f31753a;

    public a(CaeMultipathClient r1) {
        this.f31753a = r1;
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        INVOKESTATIC_com_obric_cae_libs_multipath_a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("CaeMultipathClient", "Service binder died, reconnecting...");
        CaeMultipathClient r2 = this.f31753a;
        r2.f31748a = null;
        r2.f31750c.sendEmptyMessage(1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_multipath_a_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
