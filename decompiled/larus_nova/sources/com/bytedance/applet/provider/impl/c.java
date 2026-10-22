package com.bytedance.applet.provider.impl;

import androidx.collection.LruCache;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.j;
import com.bytedance.ai.utils.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import jw3.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f192187a = null;

    static {
        f192187a = new c();
    }

    public c() {
    }

    @Override // jw3.e
    public final int e() {
        com.bytedance.ai.settings.a<Integer> r100 = com.bytedance.ai.settings.b.f37574a;
        return com.bytedance.ai.settings.b.f37575b.a().intValue();
    }

    @Override // jw3.e
    public final void a(Long r210) {
        LruCache<Long, j.a> r100 = j.f37639a;
        if (r210 == null) goto L29;
        r210.longValue();
        j.a r101 = j.f37639a.remove(r210);
        if (r101 == null) goto L30;
        String r102 = r101.f37645e;
        if (r102 == null) goto L9;
        j.a r103 = j.f37640b.remove(r102);
    L9:
        com.bytedance.ai.monitor.b.d("applet_local_plugin_summary", new k(r101));
        h2.a r104 = f2.b.f475099c;
        if (r104 == null) goto L14;
        boolean r105 = true;
        if (r104.f483573l != true) goto L14;
    L15:
        if (r105 == false) goto L31;
        long r106 = j.a(r101.f37651k.f37673d, r101.f37650j.f37673d);
        long r107 = j.a(r101.f37652l.f37673d, r101.f37651k.f37673d);
        long r108 = j.a(r101.f37653m.f37673d, r101.f37652l.f37673d);
        long r109 = j.a(r101.f37654n.f37673d, r101.f37653m.f37673d);
        long r110 = j.a(r101.f37657q.f37673d, r101.f37654n.f37673d);
        long r111 = j.a(r101.f37659s.f37673d, r101.f37657q.f37673d);
        long r112 = j.a(r101.f37661u.f37673d, r101.f37660t.f37673d);
        long r113 = j.a(r101.f37661u.f37673d, Long.valueOf(r101.f37646f));
        StringBuilder r114 = new StringBuilder("\n================================================================================================\nBasic info:\nmsgId: ");
        r114.append(r101.f37641a);
        r114.append(", questionId: ");
        r114.append(r101.f37642b);
        r114.append(", apiName: ");
        r114.append(r101.f37643c);
        r114.append(":\nreceived time: ");
        r114.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(r101.f37646f)));
        r114.append("\n-------------------------\ntimestamp:\n");
        StringBuilder r115 = new StringBuilder();
        Iterator<T> r116 = r101.f37663w.iterator();
    L18:
        if (r116.hasNext() == false) goto L24;
        j.c r117 = (j.c) r116.next();
        String r118 = r117.f37672c;
        Long r119 = r117.f37673d;
        long r120 = r101.f37646f;
        j.a r211 = r101;
        StringBuilder r121 = new StringBuilder();
        r121.append(r118);
        r121.append(" time: ");
        if (r119 == null) goto L22;
        Object r122 = Long.valueOf(r119.longValue() - r120);
    L23:
        r121.append(r122);
        r121.append(" ms");
        r115.append(r121.toString());
        r115.append("\r\n");
        r101 = r211;
        goto L18
    L22:
        r122 = "unknown";
        goto L23
    L24:
        r114.append(r115.toString());
        r114.append("\n-------------------------\ncosts:\ntotal cost: ");
        r114.append(r113);
        r114.append(" ms\n\n");
        r114.append(j.c("app action listener", r106, r113));
        r114.append('\n');
        r114.append(j.c("applet runtime manager", r107, r113));
        r114.append('\n');
        r114.append(j.c("run applet", r108, r113));
        r114.append('\n');
        r114.append(j.c("applet runtime", r109, r113));
        r114.append('\n');
        r114.append(j.c("front end", r110, r113));
        r114.append('\n');
        r114.append(j.c("reply to report", r111, r113));
        r114.append('\n');
        r114.append(j.c("send ack", r112, r113));
        r114.append("\n================================================================================================\n        ");
        String r123 = StringsKt.trimIndent(r114.toString());
        g.f37637a.d("LocalPluginPerformanceManager", "LocalPlugin status\n" + r123);
        return;
    L31:
        return;
    L14:
        r105 = false;
        goto L15
    L30:
        return;
    }

    @Override // jw3.e
    public final void d(Object r100) {
        if ((r100 instanceof j.a) == false) goto L5;
        j.a r101 = (j.a) r100;
    L6:
        if (r101 == null) goto L11;
        j.c r102 = r101.f37662v;
        if (r102 == null) goto L12;
        r102.a();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // jw3.e
    public final void f(Object r100) {
        if ((r100 instanceof j.a) == false) goto L5;
        j.a r101 = (j.a) r100;
    L6:
        if (r101 == null) goto L11;
        j.c r102 = r101.f37661u;
        if (r102 == null) goto L12;
        r102.a();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // jw3.e
    public final j.a h(Long r100) {
        j.a r101 = j.b(r100);
        if (r101 == null) goto L7;
        j.c r102 = r101.f37660t;
        if (r102 == null) goto L7;
        r102.a();
    L7:
        return r101;
    }

    @Override // jw3.e
    public final void b(Object r100, int r101) {
        if ((r100 instanceof j.a) == false) goto L5;
        j.a r102 = (j.a) r100;
    L6:
        if (r102 == null) goto L9;
        r102.f37648h = r101;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // jw3.e
    public final void g(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        if ((r100 instanceof j.a) == false) goto L5;
        j.a r102 = (j.a) r100;
    L6:
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(r101, "msg");
        r102.f37649i = new j.b.C0715b(r101);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // jw3.e
    public final void c(Long r100, Long r101, String r110, String r111) {
        LruCache<Long, j.a> r102 = j.f37639a;
        if (r100 == null) goto L6;
        r100.longValue();
        j.a r103 = new j.a(r100, r101, r110, r111, 48);
        j.f37639a.put(r100, r103);
        return;
    }
}
