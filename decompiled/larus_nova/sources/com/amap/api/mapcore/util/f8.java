package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.col.s.ce;
import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.connect.common.Constants;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class f8 {

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f27279b;

        @Override // java.lang.Runnable
        public final void run() {
            com_amap_api_mapcore_util_f8$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_amap_api_mapcore_util_f8$a__run$___twin___() {
            monitor-enter(f8.class);
            String r100 = t5.a(x5.e(this.f27278a));     // Catch: Throwable -> L11
            d8 r101 = e8.a(null);     // Catch: Throwable -> L11
            Context r102 = this.f27279b;     // Catch: Throwable -> L11
            int r103 = q6.f27894c;     // Catch: Throwable -> L11
            e8.a(r102, r101, ce.f26395j, 50, 102400, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);     // Catch: Throwable -> L11
            if (r101.f27185e != null) goto L9;
            r101.f27185e = new i7(new l7(new k7()));     // Catch: Throwable -> L11
        L9:
            e8.a(r100, x5.e(" \"timestamp\":\"" + x5.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss") + "\",\"details\":" + this.f27278a), r101);     // Catch: Throwable -> L11
        L13:
            monitor-exit(f8.class);     // Catch: Throwable -> L15
            return;
        L11:
            th = move-exception;
            t6.a(th, "mam", "ap");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_f8$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_mapcore_util_f8$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, Context r101) {
            this.f27278a = r100;
            this.f27279b = r101;
        }
    }

    public f8() {
    }

    public static void a(String r100, Context r101) {
        t6.a().submit(new a(r100, r101));
    }
}
