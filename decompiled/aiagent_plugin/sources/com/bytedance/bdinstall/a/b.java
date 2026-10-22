package com.bytedance.bdinstall.a;

import android.os.Looper;
import com.bytedance.bdinstall.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: CallbackCenter.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<c, Object> f6096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f6097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f6098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Type, a> f6099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6100e;

    /* JADX INFO: compiled from: CallbackCenter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f6107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ConcurrentHashMap<com.bytedance.bdinstall.a.a, Object> f6108b;

        private a() {
            this.f6108b = new ConcurrentHashMap();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        Set<com.bytedance.bdinstall.a.a> a() {
            return this.f6108b.keySet();
        }

        public void a(com.bytedance.bdinstall.a.a r3, Object r4) {
            com.bytedance.bdinstall.a.a r5 = (com.bytedance.bdinstall.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdinstall.a.a.class, "com.obric.aiagent.plugin");
            this.f6108b.put(r5, r4);
        }
    }

    public b() {
        this.f6097b = new Object();
        this.f6098c = new Object();
        this.f6099d = new ConcurrentHashMap();
        this.f6096a = new ConcurrentHashMap();
        this.f6100e = null;
    }

    public void a(String r1) {
        this.f6100e = r1;
    }

    public <EVENT> void a(boolean r6, com.bytedance.bdinstall.a.a<EVENT> r7) {
        com.bytedance.bdinstall.a.a<EVENT> r8 = (com.bytedance.bdinstall.a.a) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.bdinstall.a.a.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        Type r0 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r8.getClass().getGenericInterfaces()[0], ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments()[0];
        Object r1 = this.f6097b;
        monitor-enter(r1);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f6099d.get(r0), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r2 != null) goto L10;
        r2 = new a(null);     // Catch: Throwable -> L19
        this.f6099d.put(r0, r2);     // Catch: Throwable -> L19
    L10:
        r2.a(r8, this.f6098c);     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L13;
        this.f6096a.put((c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin"), this.f6098c);     // Catch: Throwable -> L19
    L13:
        if (r6 == true) goto L15;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L15:
        if (r2.f6107a == null) goto L17;
        a(r8, r2, r2.f6107a);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private <EVENT> void a(com.bytedance.bdinstall.a.a<EVENT> r3, final a r4, final Object r5) {
        final com.bytedance.bdinstall.a.a r6 = (com.bytedance.bdinstall.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdinstall.a.a.class, "com.obric.aiagent.plugin");
        w.c(this.f6100e, new AnonymousClass1(this, r4, r6, r5));
    }

    public void a(Object r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Object r0 = this.f6097b;
        monitor-enter(r0);
        Object r1 = null;
        Iterator<c> r2 = this.f6096a.keySet().iterator();     // Catch: Throwable -> L17
    L9:
        if (r2.hasNext() == false) goto L13;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r3.a() != r7) goto L9;
        r1 = r3;
    L13:
        if (r1 == null) goto L15;
        a(r1);     // Catch: Throwable -> L17
        this.f6096a.remove(r1);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public <Event> void b(final Event r5) {
        if (Looper.myLooper() == w.a(this.f6100e)) goto L6;
        w.c(this.f6100e, new AnonymousClass2(this, r5));
        return;
    L6:
        Object r0 = this.f6097b;
        monitor-enter(r0);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f6099d.get(r5.getClass()), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r1 != null) goto L11;
        r1 = new a(null);     // Catch: Throwable -> L19
        this.f6099d.put(r5.getClass(), r1);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L19
        r1.f6107a = r5;
        Iterator<com.bytedance.bdinstall.a.a> r4 = r1.a().iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        com.bytedance.bdinstall.a.a r2 = (com.bytedance.bdinstall.a.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.bdinstall.a.a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        r2.a(r5);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
