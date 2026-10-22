package com.bumptech.glide.load.engine.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LruArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.engine.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<a, Object> f3537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f3538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f3539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.a.a<?>> f3540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3541e;
    private int f;

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f3543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f3544c;

        a(b r1) {
            this.f3543b = r1;
        }

        void a(int r1, Class<?> r2) {
            this.f3542a = r1;
            this.f3544c = r2;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L10;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
            if (this.f3542a == r5.f3542a) goto L7;
            return false;
        L7:
            if (this.f3544c != r5.f3544c) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public String toString() {
            return "Key{size=" + this.f3542a + "array=" + this.f3544c + '}';
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void a() {
            this.f3543b.a(this);
        }

        public int hashCode() {
            int r0 = this.f3542a * 31;
            Class<?> r1 = this.f3544c;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }
    }

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class b extends d<a> {
        @Override // com.bumptech.glide.load.engine.a.d
        public /* synthetic */ m b() {
            return a();
        }

        b() {
        }

        a a(int r3, Class<?> r4) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(c(), a.class, "com.obric.aiagent.plugin");
            r2.a(r3, r4);
            return r2;
        }

        public a a() {
            return new a(this);
        }
    }

    public j() {
        this.f3537a = new h();
        this.f3538b = new b();
        this.f3539c = new HashMap();
        this.f3540d = new HashMap();
        this.f3541e = UiType.FLAG_NO_FEEDBACK;
    }

    public j(int r2) {
        this.f3537a = new h();
        this.f3538b = new b();
        this.f3539c = new HashMap();
        this.f3540d = new HashMap();
        this.f3541e = r2;
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> void a(T r6) {
        monitor-enter(this);
        Class<?> r0 = r6.getClass();     // Catch: Throwable -> L14
        com.bumptech.glide.load.engine.a.a<T> r1 = b(r0);     // Catch: Throwable -> L14
        int r2 = r1.a(r6);     // Catch: Throwable -> L14
        int r3 = r1.b() * r2;     // Catch: Throwable -> L14
        if (b(r3) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        a r4 = this.f3538b.a(r2, r0);     // Catch: Throwable -> L14
        this.f3537a.a(r4, r6);     // Catch: Throwable -> L14
        NavigableMap<Integer, Integer> r7 = a(r0);     // Catch: Throwable -> L14
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r7.get(Integer.valueOf(r4.f3542a)), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Integer r8 = Integer.valueOf(r4.f3542a);     // Catch: Throwable -> L14
        int r9 = 1;
        if (r5 == null) goto L11;
        r9 = 1 + r5.intValue();     // Catch: Throwable -> L14
    L11:
        r7.put(r8, Integer.valueOf(r9));     // Catch: Throwable -> L14
        this.f += r3;     // Catch: Throwable -> L14
        c();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> T b(int r2, Class<T> r3) {
        monitor-enter(this);
        T r4 = (T) a(this.f3538b.a(r2, r3), r3);
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> T a(int r4, Class<T> r5) {
        monitor-enter(this);
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(a(r5).ceilingKey(Integer.valueOf(r4)), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (a(r4, r0) == false) goto L6;
        a r6 = this.f3538b.a(r0.intValue(), r5);     // Catch: Throwable -> L10
    L7:
        T r7 = (T) a(r6, r5);
        monitor-exit(this);
        return r7;
    L6:
        r6 = this.f3538b.a(r4, r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private <T> T a(a r6, Class<T> r7) {
        com.bumptech.glide.load.engine.a.a<T> r0 = b(r7);
        T r1 = (T) a(r6);
        if (r1 == null) goto L5;
        this.f -= r0.a(r1) * r0.b();
        c(r0.a(r1), r7);
    L5:
        if (r1 == null) goto L7;
        return r1;
    L7:
        if (a(r0.a(), 2) == false) goto L10;
        a(r0.a(), "Allocated " + r6.f3542a + " bytes");
    L10:
        return r0.a(r6.f3542a);
    }

    private <T> T a(a r1) {
        return (T) this.f3537a.a(r1);
    }

    private boolean b(int r1) {
        if (r1 > (this.f3541e / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean a(int r1, Integer r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (b() == false) goto L6;
    L7:
        return true;
    L6:
        if (r2.intValue() > (r1 * 8)) goto L8;
        goto L7
    }

    private boolean b() {
        int r0 = this.f;
        if (r0 != 0) goto L5;
    L8:
        return true;
    L5:
        if ((this.f3541e / r0) >= 2) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized void a() {
        monitor-enter(this);
        c(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized void a(int r2) {
        monitor-enter(this);
        if (r2 < 40) goto L9;
        a();     // Catch: Throwable -> L6
    L17:
    L13:
        monitor-exit(this);
        return;
    L9:
        if (r2 < 20) goto L11;
    L12:
        c(this.f3541e / 2);     // Catch: Throwable -> L6
        goto L17
    L11:
        if (r2 != 15) goto L13;
    L6:
        th = move-exception;
        throw th;
    }

    private void c() {
        c(this.f3541e);
    }

    private void c(int r6) {
    L3:
        if (this.f <= r6) goto L7;
        Object r0 = this.f3537a.a();
        com.bumptech.glide.f.j.a(r0);
        com.bumptech.glide.load.engine.a.a r1 = b(r0);
        this.f -= r1.a(r0) * r1.b();
        c(r1.a(r0), r0.getClass());
        if (a(r1.a(), 2) == false) goto L3;
        a(r1.a(), "evicted: " + r1.a(r0));
        goto L3
    }

    private void c(int r4, Class<?> r5) {
        NavigableMap<Integer, Integer> r6 = a(r5);
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r6.get(Integer.valueOf(r4)), Integer.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L7;
        r6.remove(Integer.valueOf(r4));
        return;
    L7:
        r6.put(Integer.valueOf(r4), Integer.valueOf(r0.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r4 + ", this: " + this);
    }

    private NavigableMap<Integer, Integer> a(Class<?> r4) {
        NavigableMap<Integer, Integer> r0 = (NavigableMap) ZeusTransformUtils.preCheckCast(this.f3539c.get(r4), NavigableMap.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        TreeMap r1 = new TreeMap();
        this.f3539c.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    private <T> com.bumptech.glide.load.engine.a.a<T> b(T r1) {
        return b(r1.getClass());
    }

    private <T> com.bumptech.glide.load.engine.a.a<T> b(Class<T> r4) {
        com.bumptech.glide.load.engine.a.a<T> r0 = (com.bumptech.glide.load.engine.a.a) ZeusTransformUtils.preCheckCast(this.f3540d.get(r4), com.bumptech.glide.load.engine.a.a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
    L13:
        return r0;
    L5:
        if (r4.equals(int[].class) == false) goto L8;
        r0 = new i();
    L10:
        this.f3540d.put(r4, r0);
        goto L13
    L8:
        if (r4.equals(byte[].class) == false) goto L12;
        r0 = new g();
        goto L10
    L12:
        throw new IllegalArgumentException("No array pool found for: " + r4.getSimpleName());
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
