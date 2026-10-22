package com.obric.aiagent.skill.credentials.api;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SidecarAuthWebViewBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f18996a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, WeakReference<o>> f18997b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, CopyOnWriteArraySet<n>> f18998c = null;

    private m() {
    }

    static {
        f18996a = new m();
        f18997b = new ConcurrentHashMap();
        f18998c = new ConcurrentHashMap();
    }

    public final void a(String r3, o r4) {
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r4, "controller");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        ((Map) ZeusTransformUtils.preCheckCast(f18997b, Map.class, "com.obric.aiagent.plugin")).put(r3, new WeakReference(r4));
    }

    public final void b(String r5, o r6) {
        d.h.b.o.e(r5, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r6, "controller");
        ConcurrentHashMap<String, WeakReference<o>> r0 = f18997b;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5), WeakReference.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        o r2 = (o) ZeusTransformUtils.preCheckCast(r1.get(), o.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != r6) goto L9;
        r0.remove(r5);
        b(r5);
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void c(String r4, o r5) {
        d.h.b.o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r5, "controller");
        ConcurrentHashMap<String, WeakReference<o>> r3 = f18997b;
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(r3.get(r4), WeakReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        o r1 = (o) ZeusTransformUtils.preCheckCast(r0.get(), o.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != r5) goto L9;
        r3.remove(r4);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean a(String r4, String r5, String r6) {
        d.h.b.o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r5, "url");
        d.h.b.o.e(r6, "flowId");
        ConcurrentHashMap<String, WeakReference<o>> r3 = f18997b;
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(r3.get(r4), WeakReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        o r1 = (o) ZeusTransformUtils.preCheckCast(r0.get(), o.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L9;
        r3.remove(r4);
        return false;
    L9:
        r1.a(r5, r6);
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean a(String r4) {
        d.h.b.o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        ConcurrentHashMap<String, WeakReference<o>> r3 = f18997b;
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(r3.get(r4), WeakReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        o r1 = (o) ZeusTransformUtils.preCheckCast(r0.get(), o.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L9;
        r3.remove(r4);
        return false;
    L9:
        r1.a();
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final void a(String r3, n r4) {
        n r2 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r2, "listener");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        ConcurrentMap r5 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(f18998c, ConcurrentMap.class, "com.obric.aiagent.plugin");
        Object r1 = r5.get(r3);
        if (r1 != null) goto L11;
        r1 = new CopyOnWriteArraySet();
        Object r6 = r5.putIfAbsent(r3, r1);
        if (r6 == null) goto L11;
        r1 = r6;
    L11:
        ((CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(r1, CopyOnWriteArraySet.class, "com.obric.aiagent.plugin")).add(r2);
    }

    public final void b(String r4, n r5) {
        n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r3, "listener");
        ConcurrentHashMap<String, CopyOnWriteArraySet<n>> r6 = f18998c;
        CopyOnWriteArraySet r0 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(r6.get(r4), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r3);
        if (r0.isEmpty() == false) goto L9;
        r6.remove(r4);
        return;
    }

    private final void b(String r4) {
        CopyOnWriteArraySet r3 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(f18998c.get(r4), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ((n) ZeusTransformUtils.preCheckCast(r5.next(), n.class, "com.obric.aiagent.plugin")).onClosed(r4);
        goto L6
    L10:
        return;
    }
}
