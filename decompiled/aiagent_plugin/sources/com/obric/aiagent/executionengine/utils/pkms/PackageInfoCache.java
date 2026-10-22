package com.obric.aiagent.executionengine.utils.pkms;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: PackageInfoCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageInfoCache {
    private static final String TAG = "PackageInfoCache";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PackageInfoCache f18569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Intent f18570b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f18571c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ExecutorService f18572d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f18573e = null;
    private static final f f = null;
    private static final LauncherCallback g = null;
    private static final b h = null;

    /* JADX INFO: compiled from: PackageInfoCache.kt */
    private static final class LauncherCallback extends LauncherApps.Callback {
        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesAvailable(String[] r1, UserHandle r2, boolean r3) {
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesUnavailable(String[] r1, UserHandle r2, boolean r3) {
        }

        public LauncherCallback() {
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageRemoved(String r2, UserHandle r3) {
            if (r2 == null) goto L5;
            PackageInfoCache.a(PackageInfoCache.f18569a, (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageAdded(String r2, UserHandle r3) {
            if (r2 == null) goto L5;
            PackageInfoCache.a(PackageInfoCache.f18569a, (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageChanged(String r2, UserHandle r3) {
            if (r2 == null) goto L5;
            PackageInfoCache.a(PackageInfoCache.f18569a, (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: PackageInfoCache.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ApplicationInfo f18574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f18575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Intent f18576c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f18574a, r6.f18574a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f18575b, r6.f18575b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f18576c, r6.f18576c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.f18574a.hashCode() * 31;
            CharSequence r1 = this.f18575b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Intent r5 = this.f18576c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AppInfoEntry(appInfo=" + this.f18574a + ", appLabel=" + this.f18575b + ", launchIntent=" + this.f18576c + ')';
        }

        public a(ApplicationInfo r3, CharSequence r4, Intent r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r3, "appInfo");
            this.f18574a = r3;
            this.f18575b = r6;
            this.f18576c = r5;
        }

        public final ApplicationInfo a() {
            return this.f18574a;
        }

        public final CharSequence b() {
            return this.f18575b;
        }

        public final Intent c() {
            return this.f18576c;
        }
    }

    /* JADX INFO: compiled from: PackageInfoCache.kt */
    public static final class b extends PluginBroadcastReceiver {
        b() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L7:
            if (o.a(r4, "android.intent.action.LOCALE_CHANGED") == false) goto L10;
            ILogDepend.Companion.i(PackageInfoCache.TAG, "System locale changed, refreshing app info cache");
            PackageInfoCache.a(PackageInfoCache.f18569a, (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    public static /* synthetic */ Thread lambda$Pzvum096NKNZFlS2JflGYtbEPs8(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$UaUMi0Uis0zCnXbEf33WrChjiM4() {
        g();
    }

    public static /* synthetic */ LauncherApps lambda$XEWebbple9phD692T27xoTPImN0() {
        return f();
    }

    public static /* synthetic */ void lambda$axwP7nB00JFG4LF3Hcg0cUn8JLk(Context r0) {
        d(r0);
    }

    public static /* synthetic */ PackageManager lambda$sCLE8gtKz6mTTHifbdCJOIJBwMs() {
        return e();
    }

    private PackageInfoCache() {
    }

    public static final /* synthetic */ void a(PackageInfoCache r2, Context r3) {
        r2.c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    static {
        f18569a = new PackageInfoCache();
        f18570b = new Intent();
        f18571c = new ConcurrentHashMap();
        f18572d = Executors.newSingleThreadExecutor($$Lambda$PackageInfoCache$Pzvum096NKNZFlS2JflGYtbEPs8.INSTANCE);
        f18573e = g.a($$Lambda$PackageInfoCache$sCLE8gtKz6mTTHifbdCJOIJBwMs.INSTANCE);
        f = g.a($$Lambda$PackageInfoCache$XEWebbple9phD692T27xoTPImN0.INSTANCE);
        g = new LauncherCallback();
        h = new b();
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "package-info-cache-refresh");
        r0.setDaemon(true);
        return r0;
    }

    private final PackageManager c() {
        return (PackageManager) ZeusTransformUtils.preCheckCast(f18573e.b(), PackageManager.class, "com.obric.aiagent.plugin");
    }

    private static final PackageManager e() {
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
    }

    private final LauncherApps d() {
        return (LauncherApps) ZeusTransformUtils.preCheckCast(f.b(), LauncherApps.class, "com.obric.aiagent.plugin");
    }

    private static final LauncherApps f() {
        return (LauncherApps) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin");
    }

    private final void a(ApplicationInfo r6) {
        CharSequence r0 = c().getApplicationLabel(r6);     // Catch: Throwable -> L17
        o.a(r0);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        String r2 = r6.packageName;     // Catch: Throwable -> L6
        o.c(r2, "packageName");     // Catch: Throwable -> L6
        Intent r5 = b(r1, r2);     // Catch: Throwable -> L6
    L8:
        ConcurrentHashMap<String, a> r3 = f18571c;
        monitor-enter(r3);
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")).put(r6.packageName, new a(r6, r0, r5));     // Catch: Throwable -> L14
        x r7 = x.f38692a;     // Catch: Throwable -> L14
        monitor-exit(r3);
        ISecureLogDepend.Companion.i(TAG, "added app-info entry: " + r6.packageName);
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "got null when finding launchIntent for `" + r6.packageName + "`; e=" + th, th);
        r5 = null;
    L17:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "got null when finding getApplicationLabel for `" + r6.packageName + "`; e=" + th, th);
    }

    public final void a() {
        com.obric.aiagent.executionengine.utils.a.f18564a.a().post($$Lambda$PackageInfoCache$UaUMi0Uis0zCnXbEf33WrChjiM4.INSTANCE);
        c((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    private static final void g() {
        f18569a.d().registerCallback((LauncherApps.Callback) ZeusTransformUtils.preCheckCast(g, LauncherApps.Callback.class, "com.obric.aiagent.plugin"));
        IntentFilter r0 = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        ZeusTransformUtils.registerReceiver((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(h, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r0, "com.obric.aiagent.plugin");
    }

    public final boolean a(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        ConcurrentHashMap<String, a> r8 = f18571c;
        monitor-enter(r8);
        boolean r1 = true;
        if ((!((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L20;
        Set<String> r0 = r8.keySet();     // Catch: Throwable -> L23
        o.c(r0, "<get-keys>(...)");     // Catch: Throwable -> L23
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L9;
    L11:
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L23
    L12:
        if (r3.hasNext() == false) goto L17;
        if (o.a((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin"), r6.getPackageName()) == true) goto L12;
        boolean r9 = false;
    L18:
        if (r9 == true) goto L20;
    L21:
        monitor-exit(r8);
        return r1;
    L17:
        r9 = true;
        goto L18
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
    L20:
        r1 = false;
    L23:
        th = move-exception;
        throw th;
    }

    public final List<a> b() {
        ConcurrentHashMap<String, a> r3 = f18571c;
        monitor-enter(r3);
        Collection<a> r0 = r3.values();     // Catch: Throwable -> L7
        o.c(r0, "<get-values>(...)");     // Catch: Throwable -> L7
        List<a> r1 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        monitor-exit(r3);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        if (r5.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") == 0) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, a> r0 = f18571c;
        monitor-enter(r0);
        r0.clear();     // Catch: Throwable -> L18
        x r1 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        ILogDepend.Companion.i(TAG, "refreshing AppInfoCache...");
        List<ApplicationInfo> r6 = r5.getPackageManager().getInstalledApplications(128);
        o.c(r6, "getInstalledApplications(...)");
        if (r6.isEmpty() == false) goto L13;
        ILogDepend.Companion.e(TAG, "getInstalledApplications apps is empty!");
        return;
    L13:
        Iterator<ApplicationInfo> r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        ApplicationInfo r2 = (ApplicationInfo) ZeusTransformUtils.preCheckCast(r7.next(), ApplicationInfo.class, "com.obric.aiagent.plugin");
        o.a(r2);
        a(r2);
        goto L15
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private final void c(Context r2) {
        final Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        f18572d.execute(new $$Lambda$PackageInfoCache$axwP7nB00JFG4LF3Hcg0cUn8JLk(r1));
    }

    private static final void d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        f18569a.b(r3);
    }

    private final Intent b(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getLaunchIntentForPackage(r3);
    }

    public final boolean a(Context r2, String r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r3, "packageName");
        ConcurrentHashMap<String, a> r1 = f18571c;
        monitor-enter(r1);
        a r4 = (a) ZeusTransformUtils.preCheckCast(r1.get(r3), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        boolean r5 = true;
        if (r4 == null) goto L11;
        ApplicationInfo r6 = r4.a();     // Catch: Throwable -> L14
        if (r6 == null) goto L11;
        if (r6.enabled != true) goto L11;
    L12:
        monitor-exit(r1);
        return r5;
    L11:
        r5 = false;
    L14:
        th = move-exception;
        throw th;
    }
}
