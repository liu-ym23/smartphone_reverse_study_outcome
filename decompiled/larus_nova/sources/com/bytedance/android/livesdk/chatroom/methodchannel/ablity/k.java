package com.bytedance.android.livesdk.chatroom.methodchannel.ablity;

import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f106847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f106848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f106849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f106850d;

    public k(j r100, List r101, Map r102, long r103) {
        this.f106847a = r100;
        this.f106848b = r101;
        this.f106849c = r102;
        this.f106850d = r103;
    }

    public final void a() {
        ALogger.i("WarmingUpBeforeEnterMethod", "start in " + ThreadMethodProxy.currentThread());
        Iterator r100 = this.f106848b.iterator();
    L4:
        if (r100.hasNext() == false) goto L23;
        Class r101 = j.b(this.f106847a, ((Class) r100.next()).getCanonicalName(), this.f106849c);
        if (r101 == null) goto L4;
        Field[] r102 = r101.getDeclaredFields();
        if (r102 == null) goto L4;
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L4;
        Field r105 = r102[r104];
        String r106 = r105.getType().getCanonicalName();
        if (r106 == null) goto L22;
        if (this.f106849c.containsKey(r106) == true) goto L22;
        if (StringsKt.startsWith$default(r106, "android", false, 2, null) == true) goto L22;
        if (StringsKt.startsWith$default(r106, "java", false, 2, null) == true) goto L22;
        if (r105.getType().isPrimitive() == true) goto L22;
        j.b(this.f106847a, r106, this.f106849c);
    L22:
        r104 = r104 + 1;
        goto L10
    L23:
        ALogger.i("WarmingUpBeforeEnterMethod", "yao, warming up: " + this.f106849c.size() + " classes, " + (SystemClock.uptimeMillis() - this.f106850d) + "ms in total");
        j r107 = this.f106847a;
        Map r108 = this.f106849c;
        r107.getClass();
        double r109 = CollectionsKt.averageOfLong(r108.values());
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r111 = r108.entrySet().iterator();
    L25:
        if (r111.hasNext() == false) goto L32;
        Map.Entry r112 = (Map.Entry) r111.next();
        if (((Number) r112.getValue()).doubleValue() <= (r109 / ((double) 2))) goto L29;
        boolean r113 = true;
    L30:
        if (r113 == false) goto L25;
        r110.put(r112.getKey(), r112.getValue());
        goto L25
    L29:
        r113 = false;
        goto L30
    L32:
        Iterator r114 = r110.entrySet().iterator();
    L34:
        if (r114.hasNext() == false) goto L36;
        Map.Entry r115 = (Map.Entry) r114.next();
        ALogger.v("WarmingUpBeforeEnterMethod", "Load " + ((String) r115.getKey()) + " cost " + ((Number) r115.getValue()).longValue() + " us");
        goto L34
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
