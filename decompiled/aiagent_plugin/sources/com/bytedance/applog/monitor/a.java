package com.bytedance.applog.monitor;

import com.bytedance.applog.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: LogReportMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<n> f5731a;

    public a() {
        this.f5731a = new CopyOnWriteArraySet();
    }

    public void a(String r4, String r5) {
        Iterator<n> r3 = this.f5731a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.aiagent.plugin")).a(r4, r5);
        goto L4
    }

    public void a(String r4, Throwable r5) {
        if (this.f5731a.isEmpty() == true) goto L10;
        if (r5 == null) goto L12;
        String r6 = r5.toString();
        Iterator<n> r3 = this.f5731a.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        ((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.aiagent.plugin")).b(r4, r6);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public void b(String r4, String r5) {
        if (this.f5731a.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<n> r3 = this.f5731a.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.aiagent.plugin")).b(r4, r5);
        goto L7
    }
}
