package com.baidu.mshield.rp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mshield.utility.b;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class Receiver extends BroadcastReceiver {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f32391a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mshield_rp_Receiver$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mshield_rp_Receiver$a__run$___twin___() {
            com.baidu.mshield.sharedpreferences.a r100 = com.baidu.mshield.sharedpreferences.a.a(this.f32391a);
            com.baidu.mshield.utility.a.a(this.f32391a, r100.J() * BaseConstants.Time.HOUR);
            r100.b(System.currentTimeMillis());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mshield_rp_Receiver$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mshield_rp_Receiver$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Receiver r100, Context r101) {
            this.f32391a = r101;
        }
    }

    public Receiver() {
    }

    public void a(Context r100, Intent r101) {
        if (r101 != null) goto L9;
        return;
    L9:
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this, r100), "d/rp/Receiver"));     // Catch: Throwable -> L6
        b.a(r100).d();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L14;
        return;
    L14:
        String r102 = r101.getAction();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return;
    L8:
        if (r102.equals("com.b.r.p") == false) goto L16;
        a(r100, r101);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }
}
