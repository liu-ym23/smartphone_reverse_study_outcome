package com.baidu.xclient.gdid.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.xclient.gdid.d;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f33603a = "action_tir_mshield";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f33604b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f33605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f33606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f33607c;

        public a(b r100, Intent r101, Context r102) {
            this.f33607c = r100;
            this.f33605a = r101;
            this.f33606b = r102;
        }

        public void com_baidu_xclient_gdid_d_b$a__run$___twin___() {
            Intent r100 = this.f33605a;     // Catch: Throwable -> L19
            if (r100 != null) goto L5;
            return;
        L5:
            String r101 = r100.getAction();     // Catch: Throwable -> L19
            if (b.f33603a.equals(r101) == false) goto L9;
            d.a().a(false, true);     // Catch: Throwable -> L19
            return;
        L9:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101) == true) goto L11;
            return;
        L11:
            if (b.a(this.f33607c) == false) goto L15;
            b.a(this.f33607c, false);     // Catch: Throwable -> L19
            return;
        L15:
            if (com.baidu.xclient.gdid.j.d.a(this.f33606b) == true) goto L17;
            return;
        L17:
            d.a().a(false, false);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            com.baidu.xclient.gdid.j.d.a(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_xclient_gdid_d_b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_xclient_gdid_d_b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_xclient_gdid_d_b$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b() {
        this.f33604b = true;
    }

    public static /* synthetic */ boolean a(b r100) {
        return r100.f33604b;
    }

    public static /* synthetic */ boolean a(b r100, boolean r101) {
        r100.f33604b = r101;
        return r101;
    }

    public final void a(Context r100, Intent r101) {
        com.baidu.xclient.gdid.j.b.a().a(new a(this, r101, r100));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        a(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }
}
