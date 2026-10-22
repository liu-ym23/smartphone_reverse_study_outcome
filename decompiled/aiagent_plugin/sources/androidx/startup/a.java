package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AppInitializer.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f2751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f2752e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<Class<?>, Object> f2753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set<Class<? extends b<?>>> f2754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f2755c;

    static {
        f2752e = new Object();
    }

    a(Context r3) {
        this.f2755c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f2754b = new HashSet();
        this.f2753a = new HashMap();
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f2751d != null) goto L15;
        Object r0 = f2752e;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2751d != null) goto L9;
        f2751d = new a(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return f2751d;
    }

    public <T> T a(Class<? extends b<T>> r1) {
        return (T) c(r1);
    }

    public boolean b(Class<? extends b<?>> r1) {
        return this.f2754b.contains(r1);
    }

    <T> T c(Class<? extends b<?>> r3) {
        Object r0 = f2752e;
        monitor-enter(r0);
        T r1 = (T) this.f2753a.get(r3);
        if (r1 != null) goto L7;
        r1 = (T) a(r3, new HashSet());
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    private <T> T a(Class<? extends b<?>> r6, Set<Class<?>> r7) {
        Set<Class<?>> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        if (androidx.d.a.a() == false) goto L6;
        androidx.d.a.a(r6.getSimpleName());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        androidx.d.a.b();
        throw th;
    L6:
        if (r8.contains(r6) == true) goto L27;
        if (this.f2753a.containsKey(r6) == true) goto L23;
        r8.add(r6);     // Catch: Throwable -> L28
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        List<Class<? extends b<?>>> r2 = r0.b();     // Catch: Throwable -> L20
        if (r2.isEmpty() == true) goto L18;
        Iterator<Class<? extends b<?>>> r3 = r2.iterator();     // Catch: Throwable -> L20
    L14:
        if (r3.hasNext() == false) goto L18;
        Class<? extends b<?>> r4 = (Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (this.f2753a.containsKey(r4) == true) goto L14;
        a(r4, r8);     // Catch: Throwable -> L20
    L18:
        T r1 = (T) r0.c(this.f2755c);
        r8.remove(r6);     // Catch: Throwable -> L20
        this.f2753a.put(r6, r1);     // Catch: Throwable -> L20
    L24:
        androidx.d.a.b();
        return r1;
    L20:
        th = move-exception;
        throw new c(th);     // Catch: Throwable -> L28
    L23:
        r1 = (T) this.f2753a.get(r6);
        goto L24
    L27:
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{r6.getName()}));     // Catch: Throwable -> L28
    }

    void a() {
        androidx.d.a.a("Startup");     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        ComponentName r0 = new ComponentName(this.f2755c.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        a(this.f2755c.getPackageManager().getProviderInfo(r0, 128).metaData);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        androidx.d.a.b();
        return;
    L5:
        th = move-exception;
        androidx.d.a.b();
        throw th;
    L7:
        e = move-exception;
        throw new c(e);     // Catch: Throwable -> L5
    }

    void a(Bundle r7) {
        String r0 = this.f2755c.getString(ZeusTransformUtils.mapRes(R.string.androidx_startup, WsChannelMultiProcessSharedProvider.STRING_TYPE, "androidx_startup"));
        if (r7 != null) goto L22;
        return;
    L22:
        HashSet r1 = new HashSet();     // Catch: ClassNotFoundException -> L18
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: ClassNotFoundException -> L18
    L7:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L18
        if (r0.equals(r7.getString(r3, null)) == false) goto L7;
        Class<? extends b<?>> r4 = ZeusTransformUtils.forName(r3, "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L18
        if (b.class.isAssignableFrom(r4) == false) goto L7;
        this.f2754b.add(r4);     // Catch: ClassNotFoundException -> L18
        goto L7
    L13:
        Iterator<Class<? extends b<?>>> r8 = this.f2754b.iterator();     // Catch: ClassNotFoundException -> L18
    L14:
        if (r8.hasNext() == false) goto L32;
        a((Class) ZeusTransformUtils.preCheckCast(r8.next(), Class.class, "com.obric.aiagent.plugin"), r1);     // Catch: ClassNotFoundException -> L18
        goto L14
    L32:
        return;
    L18:
        e = move-exception;
        throw new c(e);
    }
}
