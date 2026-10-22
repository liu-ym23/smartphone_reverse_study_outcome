package com.bytedance.android.monitorV2;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.j;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.r;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.salamander.anniex.SLHybridSettingsManager;
import com.bytedance.salamander.anniex.a6;
import com.bytedance.salamander.anniex.f7;
import com.bytedance.salamander.anniex.j5;
import com.bytedance.salamander.anniex.x5;
import com.bytedance.salamander.anniex.y5;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile g f163039k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Application f163040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f163041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f163042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f163043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f163044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile com.bytedance.android.monitorV2.hybridSetting.h f163045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.monitorV2.a f163046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<fz2.d> f163047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.bytedance.android.monitorV2.listener.g> f163048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.bytedance.android.monitorV2.listener.f> f163049j;

    public class a implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.monitorV2.listener.a f163050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f163051b;

        public a(g r100) {
            this.f163051b = r100;
            this.f163050a = new com.bytedance.android.monitorV2.listener.a();
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences r100, String r101) {
            if (r100.getBoolean("monitor_validation_switch", false) == false) goto L14;
            this.f163051b.i(this.f163050a);
            g r102 = this.f163051b;
            com.bytedance.android.monitorV2.listener.a r103 = this.f163050a;
            r102.getClass();
            if (r103 == null) goto L10;
            monitor-enter(r103);
            ((CopyOnWriteArrayList) r102.f163048i).add(r103);     // Catch: Throwable -> L11
            monitor-exit(r103);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        L10:
            com.bytedance.apm.d.f190514b = true;
            xu3.a.f565088a = com.bytedance.apm.d.j();
        L15:
            boolean r104 = gz2.b.f483372a;
            gz2.b.f483372a = r100.getBoolean("monitor_immediate_switch", false);
            hz2.a.f487670b = r100.getBoolean("monitor_hdt_ignore_sample", false);
            hz2.a.f487671c = r100.getBoolean("monitor_skip_inject_check", false);
            return;
        L14:
            this.f163051b.i(this.f163050a);
            com.bytedance.apm.d.f190514b = false;
            xu3.a.f565088a = com.bytedance.apm.d.j();
            goto L15
        }
    }

    public static class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Integer> f163052a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
        }

        public b() {
            this.f163052a = new HashSet();
        }

        public final void a(Activity r100) {
            if (r100 != null) goto L11;
            boolean r101 = false;
        L5:
            if (r101 == false) goto L13;
            ((HashSet) this.f163052a).add(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L8
            Window r102 = r100.getWindow();     // Catch: Exception -> L8
            r102.setCallback(new c(r102.getCallback()));     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.android.monitorV2.util.f.b(e);
            return;
        L13:
            return;
        L11:
            r101 = !((HashSet) this.f163052a).contains(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L8
            goto L5
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Set<Integer> r101 = this.f163052a;
            HashSet r102 = (HashSet) r101;
            r102.remove(Integer.valueOf(r100.hashCode()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            a(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            a(r100);
        }
    }

    public static class c implements Window.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window.Callback f163053a;

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.f163053a.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            this.f163053a.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.f163053a.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.f163053a.onSearchRequested();
        }

        public c(Window.Callback r100) {
            this.f163053a = r100;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
            return this.f163053a.dispatchGenericMotionEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent r100) {
            return this.f163053a.dispatchKeyEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
            return this.f163053a.dispatchKeyShortcutEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
            return this.f163053a.dispatchPopulateAccessibilityEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent r100) {
            if (r100 == null) goto L7;
            if (r100.getAction() != 0) goto L7;
            r.f163253a = System.currentTimeMillis();
        L7:
            return this.f163053a.dispatchTouchEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent r100) {
            return this.f163053a.dispatchTrackballEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode r100) {
            this.f163053a.onActionModeFinished(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode r100) {
            this.f163053a.onActionModeStarted(r100);
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int r100) {
            return this.f163053a.onCreatePanelView(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent r100) {
            return this.f163053a.onSearchRequested(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
            this.f163053a.onWindowAttributesChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean r100) {
            this.f163053a.onWindowFocusChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
            return this.f163053a.onWindowStartingActionMode(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int r100, Menu r101) {
            return this.f163053a.onCreatePanelMenu(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int r100, MenuItem r101) {
            return this.f163053a.onMenuItemSelected(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int r100, Menu r101) {
            return this.f163053a.onMenuOpened(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int r100, Menu r101) {
            this.f163053a.onPanelClosed(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
            return this.f163053a.onWindowStartingActionMode(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int r100, View r101, Menu r102) {
            return this.f163053a.onPreparePanel(r100, r101, r102);
        }
    }

    public static g e() {
        if (f163039k != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f163039k != null) goto L9;
        f163039k = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f163039k;
    }

    public final com.bytedance.android.monitorV2.hybridSetting.h d() {
        if (this.f163045f == null) goto L7;
        return this.f163045f;
    L7:
        if (com.bytedance.android.monitorV2.hybridSetting.b.f163062e != null) goto L19;
        monitor-enter(com.bytedance.android.monitorV2.hybridSetting.b.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (com.bytedance.android.monitorV2.hybridSetting.b.f163062e != null) goto L13;
        com.bytedance.android.monitorV2.hybridSetting.b.f163062e = new com.bytedance.android.monitorV2.hybridSetting.b();     // Catch: Throwable -> L15
    L13:
        monitor-exit(com.bytedance.android.monitorV2.hybridSetting.b.class);     // Catch: Throwable -> L15
    L19:
        return com.bytedance.android.monitorV2.hybridSetting.b.f163062e;
    }

    public g() {
        this.f163041b = false;
        this.f163042c = false;
        this.f163046g = new com.bytedance.android.monitorV2.a();
        CopyOnWriteArrayList<com.bytedance.android.monitorV2.listener.g> r100 = gz2.e.f483376a;
        this.f163048i = gz2.e.f483376a;
        this.f163049j = gz2.e.f483377b;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void c(jz2.d r100) {
        String r101 = r100.f501109i;
        if (r101 == null) goto L16;
        sz2.a r102 = sz2.a.f543906a;
        if (sz2.a.f(r101) == null) goto L16;
        sz2.f r103 = sz2.a.f(r100.f501109i);
        if (r103 == null) goto L15;
        String r104 = r103.getType();
        if (r104.equals("web") == false) goto L13;
        m.f163358f.c(r103.a(), r100);
        goto L15
    L13:
        if (r104.equals("lynx") == false) goto L15;
        LynxViewMonitor.f163126b.c(r103.a(), r100);
    L15:
        SLMonitorCompat r105 = SLMonitorCompat.f41001a;
        String r106 = r100.f501109i;
        r105.getClass();
        SLMonitorCompat.l(r106, r100);
        return;
    L16:
        com.bytedance.android.monitorV2.event.b r107 = new com.bytedance.android.monitorV2.event.b(r100);
        TypedDataDispatcher r108 = DataReporter.f162979a;
        DataReporter.h(r107, Boolean.TRUE);
        SLMonitorCompat.f41001a.getClass();
        SLMonitorCompat.k(r100);
    }

    public final void f(Application r100) {
        if (com.bytedance.android.monitorV2.util.h.d() == false) goto L6;
        nz2.b.f("HybridMultiMonitor_undropped", "init: v2 global offline");
        return;
    L6:
        if (this.f163041b == true) goto L39;
        this.f163041b = true;
        this.f163040a = r100;
    L29:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
        return;
    L10:
        if (this.f163040a != null) goto L12;
    L14:
        com.bytedance.android.anniex.assemble.a.h();     // Catch: Throwable -> L29
        nz2.b.f("HybridMultiMonitor_undropped", "init sdkinfo: 10.4.0, " + AnnieXMonitorConstants.a() + ", false");     // Catch: Throwable -> L29
        StringBuilder r101 = new StringBuilder("init hostinfo: ");     // Catch: Throwable -> L29
        String r102 = l.l(com.bytedance.apm.d.d(), "version_name");     // Catch: Throwable -> L17
    L19:
        r101.append(r102);     // Catch: Throwable -> L29
        r101.append(", ");     // Catch: Throwable -> L29
        int r103 = l.g(com.bytedance.apm.d.d(), "version_code");     // Catch: Throwable -> L22
    L24:
        r101.append(r103);     // Catch: Throwable -> L29
        nz2.b.f("HybridMultiMonitor_undropped", r101.toString());     // Catch: Throwable -> L29
        com.bytedance.android.monitorV2.executor.a.a().execute(new com.bytedance.android.monitorV2.b(this));     // Catch: Throwable -> L29
        e r104 = new e();     // Catch: Throwable -> L29
        if (this.f163047h != null) goto L27;
        this.f163047h = new CopyOnWriteArrayList();     // Catch: Throwable -> L29
    L27:
        ((CopyOnWriteArrayList) this.f163047h).add(r104);     // Catch: Throwable -> L29
        com.bytedance.android.monitorV2.executor.a.d(new f(this));     // Catch: Throwable -> L29
        return;
    L22:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L29
        r103 = 0;
        goto L24
    L17:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L29
        r102 = "";
        goto L19
    L12:
        if (this.f163042c == true) goto L14;
        this.f163043d = new b();     // Catch: Throwable -> L29
        this.f163040a.registerActivityLifecycleCallbacks(this.f163043d);     // Catch: Throwable -> L29
        this.f163040a.registerActivityLifecycleCallbacks(mz2.d.f516473a);     // Catch: Throwable -> L29
        this.f163042c = true;     // Catch: Throwable -> L29
        goto L14
    }

    public final void g(com.bytedance.android.monitorV2.listener.f r100) {
        monitor-enter(r100);
        ((CopyOnWriteArrayList) this.f163049j).add(r100);     // Catch: Throwable -> L6
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void h(HybridSettingInitConfig r110) {
        kz2.a.b r100 = kz2.a.f506728b;
        if (r100.f506732a == true) goto L5;
        nz2.b.f("HybridMultiMonitor_undropped", "inner initSLMonitor false: sl monitor disable by host");
    L45:
        if (com.bytedance.android.monitorV2.util.h.d() == false) goto L47;
        nz2.b.f("HybridMultiMonitor_undropped", "v2 setConfig disabled by global offline");
        return;
    L47:
        int r101 = j.f163105a;
        this.f163045f = new com.bytedance.android.monitorV2.hybridSetting.d(r110);
        this.f163045f.init(this.f163040a);     // Catch: Throwable -> L50
    L81:
        com.bytedance.android.monitorV2.executor.a.d(new com.bytedance.android.monitorV2.c(this, r110));     // Catch: Throwable -> L54
    L56:
        Application r102 = this.f163040a;
        if (r102 == null) goto L84;
        JSONObject r103 = new JSONObject();
        r103.put("device_id", r110.f163094f);     // Catch: JSONException -> L62
        r103.put("host_aid", r110.f163089a);     // Catch: JSONException -> L62
        r103.put("sdk_version", "10.4.0");     // Catch: JSONException -> L62
        r103.put("channel", r110.f163095g);     // Catch: JSONException -> L62
        r103.put("app_version", r110.f163096h);     // Catch: JSONException -> L62
        r103.put("update_version_code", r110.f163097i);     // Catch: JSONException -> L62
    L65:
        if (r110.a() == null) goto L68;
        SDKMonitorUtils.setConfigUrl("8560", r110.a());
    L68:
        if (r110.b() == null) goto L70;
        SDKMonitorUtils.setDefaultReportUrl("8560", r110.b());
    L70:
        SDKMonitorUtils.initMonitor(r102.getApplicationContext(), "8560", r103, new d());
        return;
    L62:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", e);
        goto L65
    L84:
        return;
    L54:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
    L50:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
        goto L81
    L5:
        SLMonitorCompat.f41001a.getClass();
        SLMonitorCompat.f41002b = true;
        f7 r104 = new f7();
        a6 r105 = new a6();
        String r106 = r110.f163089a;
        if (r106 == null) goto L8;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f267956a = r106;
    L8:
        String r107 = r110.f163090b;
        if (r107 == null) goto L11;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f267957b = r107;
    L11:
        Intrinsics.checkNotNullParameter("Android", "<set-?>");
        r105.f267958c = "Android";
        String r108 = String.valueOf(Build.VERSION.RELEASE);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r105.f267959d = r108;
        String r109 = r110.f163093e;
        if (r109 == null) goto L14;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r105.f267960e = r109;
    L14:
        String r111 = r110.f163094f;
        if (r111 == null) goto L17;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r105.f267961f = r111;
    L17:
        String r112 = r110.f163095g;
        if (r112 == null) goto L20;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r105.f267962g = r112;
    L20:
        String r113 = r110.f163096h;
        if (r113 == null) goto L23;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r105.f267963h = r113;
    L23:
        String r114 = r110.f163097i;
        if (r114 == null) goto L26;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r105.f267964i = r114;
    L26:
        String r115 = r110.f163098j;
        if (r115 == null) goto L29;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r105.f267965j = r115;
    L29:
        String r116 = r110.f163099k;
        if (r116 == null) goto L32;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r105.f267966k = r116;
    L32:
        String r117 = Build.MODEL;
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r105.f267967l = r117;
        Intrinsics.checkNotNullParameter("10.4.0", "<set-?>");
        r105.f267968m = "10.4.0";
        String r118 = Build.BRAND;
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r105.f267969n = r118;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f268063a = r105;
        r104.f268064b = r100.f506733b;
        r104.f268065c = r100.f506734c;
        r104.f268066d = com.bytedance.android.monitorV2.util.h.d();
        j5 r119 = j5.f268155j;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r104, "setupConfig");
        com.bytedance.salamander.adapter.e r120 = j5.f268154i;
        r120.a();
        if (r119.f268160d == false) goto L35;
        r120.b();
    L43:
        nz2.b.f("HybridMultiMonitor_undropped", "init SLMonitor success");
        goto L45
    L35:
        r119.f268160d = true;
        r119.f268157a = true;
        r119.f268158b = r104.f268064b;
        r119.f268159c = r104.f268065c;
        if (r104.f268066d == false) goto L38;
        new SLHybridSettingsManager(r104.f268063a);
    L38:
        int r121 = x5.f268505a;
        List<fx5.a> r122 = com.bytedance.forest.f.f244205a;
        y5 r123 = new y5();
        List<fx5.a> r124 = com.bytedance.forest.f.f244205a;
        monitor-enter(r124);
        ((ArrayList) r124).add(r123);     // Catch: Throwable -> L72
        monitor-exit(r124);
        r120.b();
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("SLAnnieXMonitor", "setup done, enableLogService: " + r119.f268158b);
    L72:
        th = move-exception;
        throw th;
    }

    public final void i(com.bytedance.android.monitorV2.listener.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<com.bytedance.android.monitorV2.listener.g> r101 = this.f163048i;
        if (r101 != null) goto L7;
        return;
    L7:
        if (((CopyOnWriteArrayList) r101).size() == 0) goto L19;
        monitor-enter(r100);
        ((CopyOnWriteArrayList) this.f163048i).remove(r100);     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void b(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104, JSONObject r105, int r106) {
        new JSONObject();
        jz2.d.a r107 = new jz2.d.a(r101);
        r107.f501113a = r100;
        r107.f501114b = "";
        r107.f501116d = r102;
        r107.f501117e = r103;
        r107.f501118f = r104;
        r107.f501120h = r105;
        r107.b(r106);
        c(r107.a());
    }
}
