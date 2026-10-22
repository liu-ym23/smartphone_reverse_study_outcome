package com.bytedance.applog.h;

import com.bytedance.applog.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: EventObserverHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, CopyOnWriteArraySet<j>> f5642a;

    public a() {
        this.f5642a = new ConcurrentHashMap();
    }

    public void a(int r13, String r14, String r15, String r16, long r17, long r19, String r21) {
        if (a(r13) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r0 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.f5642a.get(Integer.valueOf(r13)), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        ((j) ZeusTransformUtils.preCheckCast(r1.next(), j.class, "com.obric.aiagent.plugin")).a(r14, r15, r16, r17, r19, r21);
        goto L10
    }

    public void a(int r3, String r4, String r5) {
        if (a(r3) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r2 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.f5642a.get(Integer.valueOf(r3)), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((j) ZeusTransformUtils.preCheckCast(r6.next(), j.class, "com.obric.aiagent.plugin")).a(r4, r5);
        goto L10
    }

    public void b(int r3, String r4, String r5) {
        if (a(r3) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r2 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.f5642a.get(Integer.valueOf(r3)), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((j) ZeusTransformUtils.preCheckCast(r6.next(), j.class, "com.obric.aiagent.plugin")).b(r4, r5);
        goto L10
    }

    public boolean a(int r1) {
        return !this.f5642a.containsKey(Integer.valueOf(r1));
    }
}
