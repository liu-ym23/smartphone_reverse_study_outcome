package com.obric.aiagent.ttnet;

import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: RequestMatchingRule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f22225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f22226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArraySet<d.o.k> f22227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet<d.h.a.b<com.bytedance.retrofit2.b.c, Boolean>> f22228d;

    public d() {
        this.f22225a = new CopyOnWriteArraySet();
        this.f22226b = new CopyOnWriteArraySet();
        this.f22227c = new CopyOnWriteArraySet();
        this.f22228d = new CopyOnWriteArraySet();
    }

    public final void a(String r2) {
        o.e(r2, "host");
        this.f22225a.add(r2);
    }

    public final void b(String r2) {
        o.e(r2, DownloadConstants.PATH_KEY);
        this.f22226b.add(r2);
    }

    public final CopyOnWriteArraySet<String> a() {
        return this.f22225a;
    }

    public final CopyOnWriteArraySet<String> b() {
        return this.f22226b;
    }

    public final void c(String r3) {
        o.e(r3, "regex");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(new d.o.k(r3));     // Catch: Throwable -> L5
    L8:
        if (n.a(r4) == false) goto L13;
        d.o.k r5 = (d.o.k) ZeusTransformUtils.preCheckCast(r4, d.o.k.class, "com.obric.aiagent.plugin");
        this.f22227c.add(r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r6 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L8
    }

    public final boolean a(com.bytedance.retrofit2.b.c r2) {
        o.e(r2, Ext.KEY_REQUEST);
        if (d(r2.n()) == false) goto L5;
    L12:
        return true;
    L5:
        if (e(r2.o()) == true) goto L12;
        if (f(r2.b()) == true) goto L12;
        if (b(r2) == true) goto L12;
        return false;
    }

    private final boolean d(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.f22225a.contains(r1) == false) goto L6;
        return true;
    }

    private final boolean e(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.f22226b.contains(r1) == false) goto L6;
        return true;
    }

    private final boolean f(String r6) {
        if (r6 == null) goto L18;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f22227c, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L7;
    L9:
        Iterator r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L8;
        if (((d.o.k) ZeusTransformUtils.preCheckCast(r7.next(), d.o.k.class, "com.obric.aiagent.plugin")).a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L18;
        return true;
    L8:
        r8 = false;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
    L18:
        return false;
    }

    private final boolean b(com.bytedance.retrofit2.b.c r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f22228d, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.preCheckCast(r6.next(), d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r5), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }
}
