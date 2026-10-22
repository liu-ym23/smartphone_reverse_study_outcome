package com.bytedance.android.live.broadcastgame.opengame.utils;

import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f61150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f61151b;

    public c(d r100, String r101) {
        this.f61150a = r100;
        this.f61151b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Long r111 = (Long) r110;
        d r100 = this.f61150a;
        monitor-enter(r100);
        int r101 = this.f61150a.f61153b.size();     // Catch: Throwable -> L71
        if (r101 != 0) goto L8;
    L68:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L71
        monitor-exit(r100);
        return;
    L8:
        if (r101 > 4) goto L61;
        Iterator<Map.Entry<Integer, Long>> r102 = this.f61150a.f61153b.entrySet().iterator();     // Catch: Throwable -> L71
    L11:
        if (r102.hasNext() == false) goto L67;
        long r103 = TimeUnit.NANOSECONDS.toMillis(r111.longValue() - r102.next().getValue().longValue());     // Catch: Throwable -> L71
        int r104 = x10.a.f562101a;     // Catch: Throwable -> L71
        x10.a.C8179a.C8180a r105 = x10.a.a(this.f61150a.f61154c, "bootconfig_499");     // Catch: Throwable -> L71
        r105.a("1");     // Catch: Throwable -> L71
        Integer r106 = Integer.valueOf((int) r103);     // Catch: Throwable -> L71
        HashMap<String, String> r107 = r105.f562103a;     // Catch: Throwable -> L71
        if (r106 == null) goto L16;
        String r108 = String.valueOf(r106.intValue());     // Catch: Throwable -> L71
        if (r108 == null) goto L16;
    L17:
        r107.put("param3", r108);     // Catch: Throwable -> L71
        this.f61150a.getClass();     // Catch: Throwable -> L71
        long r109 = 50;
        if (1 <= r103) goto L21;
    L23:
        long r113 = 100;
        if (51 <= r103) goto L27;
    L29:
        long r114 = 500;
        if (101 <= r103) goto L33;
    L35:
        long r115 = 1000;
        if (501 <= r103) goto L39;
    L41:
        long r116 = 2000;
        if (1001 <= r103) goto L45;
    L47:
        long r117 = 5000;
        if (2001 <= r103) goto L51;
    L53:
        long r118 = 10000;
        if (5001 <= r103) goto L57;
    L59:
        String r119 = "(10000, more)";
    L60:
        r105.f562103a.put("param4", r119);     // Catch: Throwable -> L71
        r105.f562103a.put("param5", this.f61151b);     // Catch: Throwable -> L71
        new x10.a.C8179a(r105).a();     // Catch: Throwable -> L71
        goto L11
    L57:
        if (r118 < r103) goto L59;
        r119 = "(5001, 10000)";
        goto L60
    L51:
        if (r117 < r103) goto L53;
        r119 = "(2001, 5000)";
        goto L60
    L45:
        if (r116 < r103) goto L47;
        r119 = "(1001, 2000)";
        goto L60
    L39:
        if (r115 < r103) goto L41;
        r119 = "(501, 1000)";
        goto L60
    L33:
        if (r114 < r103) goto L35;
        r119 = "(101, 500)";
        goto L60
    L27:
        if (r113 < r103) goto L29;
        r119 = "(51, 100)";
        goto L60
    L21:
        if (r109 < r103) goto L23;
        r119 = "(1, 50)";
    L16:
        r108 = "";
    L67:
        this.f61150a.f61153b.clear();     // Catch: Throwable -> L71
        goto L68
    L61:
        int r120 = x10.a.f562101a;     // Catch: Throwable -> L71
        x10.a.C8179a.C8180a r121 = x10.a.a(this.f61150a.f61154c, "bootconfig_499");     // Catch: Throwable -> L71
        r121.a(String.valueOf(r101));     // Catch: Throwable -> L71
        Integer r122 = -1;     // Catch: Throwable -> L71
        HashMap<String, String> r123 = r121.f562103a;     // Catch: Throwable -> L71
        if (r122 == null) goto L65;
        String r124 = String.valueOf(r122.intValue());     // Catch: Throwable -> L71
        if (r124 == null) goto L65;
    L66:
        r123.put("param3", r124);     // Catch: Throwable -> L71
        r121.f562103a.put("param4", "unknown");     // Catch: Throwable -> L71
        r121.f562103a.put("param5", this.f61151b);     // Catch: Throwable -> L71
        new x10.a.C8179a(r121).a();     // Catch: Throwable -> L71
    L65:
        r124 = "";
    L71:
        th = move-exception;
        throw th;
    }
}
