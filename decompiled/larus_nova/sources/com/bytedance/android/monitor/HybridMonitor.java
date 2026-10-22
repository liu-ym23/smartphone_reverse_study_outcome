package com.bytedance.android.monitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
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
import bz2.i;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import ny2.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class HybridMonitor {
    private static volatile HybridMonitor instance;
    public boolean AB_TEST;
    private Application application;
    private ny2.d exceptionHandler;
    private List<h> interceptorList;
    private boolean isInitialized;
    private boolean isRegisterTouchCallback;
    private ly2.a normalCustomMonitor;
    private zy2.b settingManager;
    private e touchTraceCallback;

    public class a implements h {
        public a() {
        }

        @Override // ny2.h
        public final void onReport(String r100, JSONObject r110) {
            if (HybridMonitor.isOutputFile() == false) goto L36;
            int r101 = bz2.f.f21872a;
            if (Intrinsics.areEqual("samplecustom", r100) == false) goto L7;
        L12:
            boolean r102 = true;
        L14:
            if (r102 == false) goto L34;
            String r103 = JSONObjectProtectorUtils.getJSONObject(r110, "extra").optString("url", "");     // Catch: Exception -> L21
            File r104 = bz2.d.a(HybridMonitor.getInstance().getApplication(), "monitor_data_debug");     // Catch: Exception -> L21
            if (r104 != null) goto L18;
            return;
        L18:
            if (r104.exists() == false) goto L38;
            bz2.d.c(new PolarisFileWrapper(r104, "custom_with_" + UriProtector.getQueryParameter(UriProtector.parse(r103), "bytest_case_id")).getAbsolutePath(), StringsKt.trimIndent("\n     " + r110 + "\n     \n     "));     // Catch: Exception -> L21
            return;
        L38:
            return;
        L21:
            e = move-exception;
            e.printStackTrace();
            return;
        L34:
            JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r110, "extra"), "nativeBase");     // Catch: Exception -> L29
            String r106 = JSONObjectProtectorUtils.getString(r105, "navigation_id");     // Catch: Exception -> L29
            String r107 = r105.optString("url", "");     // Catch: Exception -> L29
            File r108 = bz2.d.a(HybridMonitor.getInstance().getApplication(), "monitor_data_debug");     // Catch: Exception -> L29
            if (r108 != null) goto L26;
            return;
        L26:
            if (r108.exists() == false) goto L41;
            String r109 = new PolarisFileWrapper(r108, r106 + "_with_" + UriProtector.getQueryParameter(UriProtector.parse(r107), "bytest_case_id")).getAbsolutePath();     // Catch: Exception -> L29
            StringBuilder r111 = new StringBuilder("\n     ");     // Catch: Exception -> L29
            r111.append(r110);     // Catch: Exception -> L29
            r111.append("\n     \n     ");     // Catch: Exception -> L29
            bz2.d.c(r109, StringsKt.trimIndent(r111.toString()));     // Catch: Exception -> L29
            return;
        L41:
            return;
        L29:
            e = move-exception;
            e.printStackTrace();
            return;
        L7:
            if (Intrinsics.areEqual("newcustom", r100) == true) goto L12;
            if (Intrinsics.areEqual("custom", r100) == true) goto L12;
            r102 = false;
            goto L14
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridMonitor f162820a;

        public final void a() {
            Application r100 = this.f162820a.getApplication();
            if (r100 == null) goto L19;
            File r101 = bz2.d.a(r100, "monitor_data_switch");     // Catch: Throwable -> L15
            PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "is_debug");     // Catch: Throwable -> L15
            if (r102.isFile() == true) goto L7;
        L9:
            PolarisFileWrapper r103 = new PolarisFileWrapper(r101, "is_output_file");     // Catch: Throwable -> L15
            if (r103.isFile() == true) goto L12;
            return;
        L12:
            if (r103.exists() == false) goto L21;
            oy2.a.b(true, false);     // Catch: Throwable -> L15
            return;
        L21:
            return;
        L7:
            if (r102.exists() == false) goto L9;
            oy2.a.a(true, false);     // Catch: Throwable -> L15
        L15:
            bz2.c.a();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(HybridMonitor r100) {
            this.f162820a = r100;
        }
    }

    public class c implements Runnable {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.bytedance.webx.monitor.weboffline.WebOfflineMonitor");
        }

        @Override // java.lang.Runnable
        public final void run() {
            Class r100 = a();     // Catch: Throwable -> L4 Exception -> L6
            bz2.h.b(r100, "beginMonitor", new Object[]{bz2.h.b(r100, "getInstance", new Object[0])});     // Catch: Throwable -> L4 Exception -> L6
        L15:
            return;
        L6:
            bz2.c.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public c() {
        }
    }

    public class d implements Runnable {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.bytedance.webx.monitor.falconx.FalconXMonitor");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.webx.monitor.falconx.FalconXMonitor");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.webx.monitor.falconx.FalconXMonitor");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.bytedance.webx.monitor.falconx.FalconXMonitor");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.webx.monitor.falconx.FalconXMonitor");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.bytedance.webx.monitor.falconx.FalconXMonitor");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.bytedance.webx.monitor.falconx.FalconXMonitor");
        }

        @Override // java.lang.Runnable
        public final void run() {
            Class r100 = a();     // Catch: Throwable -> L4 Exception -> L6
            bz2.h.b(r100, "beginMonitor", new Object[]{bz2.h.b(r100, "getInstance", new Object[0])});     // Catch: Throwable -> L4 Exception -> L6
        L15:
            return;
        L6:
            bz2.c.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public d() {
        }
    }

    public static class e implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Integer> f162821a;

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

        public e() {
            this.f162821a = new HashSet();
        }

        public final void a(Activity r100) {
            if (r100 != null) goto L10;
            boolean r101 = false;
        L5:
            if (r101 == false) goto L12;
            ((HashSet) this.f162821a).add(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L8
            Window r102 = r100.getWindow();     // Catch: Exception -> L8
            r102.setCallback(new f(r102.getCallback()));     // Catch: Exception -> L8
            return;
        L8:
            bz2.c.a();
            return;
        L12:
            return;
        L10:
            r101 = !((HashSet) this.f162821a).contains(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L8
            goto L5
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Set<Integer> r101 = this.f162821a;
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

    public static class f implements Window.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window.Callback f162822a;

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.f162822a.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            this.f162822a.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.f162822a.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.f162822a.onSearchRequested();
        }

        public f(Window.Callback r100) {
            this.f162822a = r100;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
            return this.f162822a.dispatchGenericMotionEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent r100) {
            return this.f162822a.dispatchKeyEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
            return this.f162822a.dispatchKeyShortcutEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
            return this.f162822a.dispatchPopulateAccessibilityEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent r100) {
            if (r100 == null) goto L7;
            if (r100.getAction() != 0) goto L7;
            i.f21873a = System.currentTimeMillis();
        L7:
            return this.f162822a.dispatchTouchEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent r100) {
            return this.f162822a.dispatchTrackballEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode r100) {
            this.f162822a.onActionModeFinished(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode r100) {
            this.f162822a.onActionModeStarted(r100);
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int r100) {
            return this.f162822a.onCreatePanelView(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent r100) {
            return this.f162822a.onSearchRequested(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
            this.f162822a.onWindowAttributesChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean r100) {
            this.f162822a.onWindowFocusChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
            return this.f162822a.onWindowStartingActionMode(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int r100, Menu r101) {
            return this.f162822a.onCreatePanelMenu(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int r100, MenuItem r101) {
            return this.f162822a.onMenuItemSelected(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int r100, Menu r101) {
            return this.f162822a.onMenuOpened(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int r100, Menu r101) {
            this.f162822a.onPanelClosed(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
            return this.f162822a.onWindowStartingActionMode(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int r100, View r101, Menu r102) {
            return this.f162822a.onPreparePanel(r100, r101, r102);
        }
    }

    public ny2.d getExceptionHandler() {
        return null;
    }

    public void setExceptionHandler(ny2.d r100) {
    }

    public static HybridMonitor getInstance() {
        if (instance != null) goto L15;
        monitor-enter(HybridMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new HybridMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HybridMonitor.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void initDebugEnvir() {
        ry2.b.b(new b(this));
    }

    private void initFileRecord() {
        registerReportInterceptor(new a());
    }

    public void clearSetting() {
        zy2.b r100 = this.settingManager;
        if (r100 == null) goto L6;
        r100.getClass();
        this.settingManager = null;
        return;
    }

    public com.bytedance.android.monitor.webview.a getCustomReportMonitor() {
        return this.normalCustomMonitor.f511291a;
    }

    public zy2.b getSettingManager() {
        zy2.b r100 = this.settingManager;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (zy2.a.f573915c != null) goto L18;
        monitor-enter(zy2.a.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (zy2.a.f573915c != null) goto L12;
        zy2.a.f573915c = new zy2.a();     // Catch: Throwable -> L14
    L12:
        monitor-exit(zy2.a.class);     // Catch: Throwable -> L14
    L18:
        return zy2.a.f573915c;
    }

    public void registerTouchCallback() {
        if (this.application != null) goto L5;
        return;
    L5:
        if (this.isRegisterTouchCallback == true) goto L9;
        e r100 = new e();
        this.touchTraceCallback = r100;
        this.application.registerActivityLifecycleCallbacks(r100);
        this.isRegisterTouchCallback = true;
        return;
    }

    public HybridMonitor() {
        this.isInitialized = false;
        this.isRegisterTouchCallback = false;
        this.normalCustomMonitor = new ly2.a();
        this.AB_TEST = false;
    }

    private void initComponent() {
        injectWebOffline();
        injectFalconX();
    }

    private void injectFalconX() {
        ry2.b.a().execute(new d());
    }

    private void injectWebOffline() {
        ry2.b.a().execute(new c());
    }

    public void DisableReportInfo() {
        ((ConcurrentHashMap) ly2.d.a().f511297a).clear();
    }

    public static boolean isDebuggable() {
        return oy2.a.f527123a;
    }

    public static boolean isOutputFile() {
        return oy2.a.f527124b;
    }

    public Application getApplication() {
        return this.application;
    }

    public boolean isAbTestEnable() {
        return this.AB_TEST;
    }

    public static void setDebuggable(boolean r100) {
        oy2.a.a(r100, false);
    }

    public static void setOutputFile(boolean r100) {
        oy2.a.b(r100, false);
    }

    public void clearDisableReportInfo(String r100) {
        ly2.d r101 = ly2.d.a();
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        ((ConcurrentHashMap) r101.f511297a).remove(r100);
        return;
    }

    public void customReport(py2.d r100) {
        this.normalCustomMonitor.getClass();
        ly2.a.b(r100);
    }

    public void init(Application r100) {
        init(r100, true);
    }

    public void initSetting(zy2.b r100) {
        if (r100 == null) goto L5;
        this.settingManager = r100;
        return;
    }

    public void registerReportInterceptor(h r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.interceptorList != null) goto L7;
        this.interceptorList = new CopyOnWriteArrayList();
    L7:
        this.interceptorList.add(r100);
    }

    public void setAbTestEnable(boolean r100) {
        this.AB_TEST = r100;
    }

    public void setCustomReportMonitor(com.bytedance.android.monitor.webview.a r100) {
        this.normalCustomMonitor.f511291a = r100;
    }

    public void unregisterReportInterceptor(h r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<h> r101 = this.interceptorList;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.size() == 0) goto L12;
        this.interceptorList.remove(r100);
        return;
    }

    public void wrapTouchTraceCallback(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.isRegisterTouchCallback == false) goto L10;
        e r101 = this.touchTraceCallback;
        if (r101 == null) goto L11;
        r101.a(r100);
        return;
    L11:
        return;
    }

    public static void setDebuggable(boolean r100, boolean r101) {
        oy2.a.a(r100, r101);
    }

    public static void setOutputFile(boolean r100, boolean r101) {
        oy2.a.b(r100, r101);
    }

    public void init(Application r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.isInitialized == true) goto L12;
        this.isInitialized = true;
        this.application = r100;
        if (r101 == false) goto L9;
        registerTouchCallback();
    L9:
        initComponent();
        initFileRecord();
        initDebugEnvir();
        return;
    }

    public void registerDisableReportInfo(String r100, List<String> r101) {
        ly2.d r102 = ly2.d.a();
        r102.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L23;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.size() == 0) goto L24;
        Set r103 = (Set) ((ConcurrentHashMap) r102.f511297a).get(r100);
        if (r103 != null) goto L12;
        r103 = Collections.synchronizedSet(new HashSet());
        ((ConcurrentHashMap) r102.f511297a).put(r100, r103);
    L12:
        monitor-enter(r102);
        r103.addAll(r101);     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L24:
        return;
    }

    public void notifyReportInterceptor(String r100, String r101, String r102, JSONObject r103) {
        List<h> r104 = this.interceptorList;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.size() <= 0) goto L18;
        Iterator<h> r105 = this.interceptorList.iterator();
    L8:
        if (r105.hasNext() == false) goto L19;
        h r106 = r105.next();
        if (r106 == null) goto L8;
        r106.onReport(r101, r103);
        goto L8
    L19:
        return;
    }

    public void customReport(String r110, String r111, String r112, JSONObject r113, JSONObject r114, JSONObject r115, JSONObject r116, boolean r117) {
        ly2.a.a(r110, r111, r112, r113, r114, r115, r116, r117, this.normalCustomMonitor.f511291a);
    }

    public void customReport(String r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, JSONObject r106, boolean r107, com.bytedance.android.monitor.webview.a r110) {
        this.normalCustomMonitor.getClass();
        ly2.a.a(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }
}
