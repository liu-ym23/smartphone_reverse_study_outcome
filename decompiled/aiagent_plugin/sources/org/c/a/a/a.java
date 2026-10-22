package org.c.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.c.a.d.d;
import org.c.a.d.g;

/* JADX INFO: compiled from: CommentEventsCollector.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f40333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<g> f40334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c[] f40335c;

    public a(Queue<g> r3, c... r4) {
        this.f40334b = (Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.aiagent.plugin");
        this.f40335c = r4;
        this.f40333a = new ArrayList();
    }

    private boolean c(g r6) {
        if (r6 != null) goto L5;
    L14:
        return false;
    L5:
        if (r6.a(g.a.f40399b) == false) goto L14;
        d r7 = (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.aiagent.plugin");
        c[] r5 = this.f40335c;
        int r1 = r5.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        if (r7.c() == r5[r2]) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return true;
    }

    public a a() {
        a(null);
        return this;
    }

    public g a(g r5) {
        if (r5 == null) goto L9;
        if (c(r5) == false) goto L7;
        this.f40333a.add(new b((d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin")));
        goto L9
    L7:
        return r5;
    L9:
        if (c((g) ZeusTransformUtils.preCheckCast(this.f40334b.peek(), g.class, "com.obric.aiagent.plugin")) == false) goto L11;
        this.f40333a.add(new b((d) ZeusTransformUtils.preCheckCast(this.f40334b.poll(), d.class, "com.obric.aiagent.plugin")));
        goto L9
    L11:
        return null;
    }

    public g b(g r2) {
        g r3 = a(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return (g) ZeusTransformUtils.preCheckCast(this.f40334b.poll(), g.class, "com.obric.aiagent.plugin");
    }

    public List<b> b() {
        List<b> r0 = this.f40333a;     // Catch: Throwable -> L5
        this.f40333a = new ArrayList();
        return r0;
    L5:
        th = move-exception;
        this.f40333a = new ArrayList();
        throw th;
    }

    public boolean c() {
        return this.f40333a.isEmpty();
    }
}
