package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PreActionPageChangeBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f28895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, aa> f28896c;

    public z(int r3) {
        this.f28894a = d.l.n.c(r3, 0);
        this.f28895b = new Object();
        this.f28896c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(int r4) {
        Object r0 = this.f28895b;
        monitor-enter(r0);
        boolean r2 = false;
        if (b(r4) == false) goto L10;
        if (this.f28896c.remove(Integer.valueOf(r4)) == null) goto L10;
        r2 = true;
    L10:
        monitor-exit(r0);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    public final boolean a(int r8, Boolean r9, Boolean r10, Boolean r11) {
        Object r0 = this.f28895b;
        monitor-enter(r0);
        boolean r2 = false;
        if (b(r8) == false) goto L25;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new Boolean[]{r9, r10, r11}), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L9;
    L11:
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L27
    L13:
        if (r3.hasNext() == false) goto L20;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.next(), Boolean.class, "com.obric.aiagent.plugin")) != null) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == true) goto L13;
        boolean r5 = false;
    L21:
        if (r5 == true) goto L25;
        this.f28896c.put(Integer.valueOf(r8), new aa(r9, r10, r11));     // Catch: Throwable -> L27
        r2 = true;
        goto L25
    L17:
        r4 = false;
    L20:
        r5 = true;
        goto L21
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
    L25:
        monitor-exit(r0);
        return r2;
    L27:
        th = move-exception;
        throw th;
    }

    public final ab a() {
        Object r0 = this.f28895b;
        monitor-enter(r0);
        ab r1 = new ab(this.f28894a, ao.d(this.f28896c));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private final boolean b(int r2) {
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= this.f28894a) goto L9;
        return true;
    L9:
        return false;
    }
}
