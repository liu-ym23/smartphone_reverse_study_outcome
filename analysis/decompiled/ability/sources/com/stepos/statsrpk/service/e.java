package com.stepos.statsrpk.service;

import android.content.Context;
import com.zyql.common.utils.upload.TOSUploader;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Context f3986a;
    public Y5.a b;
    public ScheduledExecutorService c;

    public static void a(e eVar) {
        W5.c.a("a", "flushQueueInternalByTimer");
        Y5.a aVar = eVar.b;
        Iterator it = aVar.d().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            aVar.c();
            eVar.b(str, aVar.a(str));
        }
        eVar.c.schedule(new d(eVar, 1), TOSUploader.EXPIRED_TIMES, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:247:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0545 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r18, java.util.ArrayList r19) {
        /*
            Method dump skipped, instructions count: 1715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.service.e.b(java.lang.String, java.util.ArrayList):void");
    }

    public final void c(String str) {
        W5.c.a("a", "flushQueueInternalWhenEnvChanged, appKey: " + str);
        Y5.a aVar = this.b;
        aVar.c();
        b(str, aVar.a(str));
    }
}
