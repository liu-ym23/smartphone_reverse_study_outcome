package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.p;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.ttnet.org.chromium.net.NetError;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6204a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f6205b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f6206c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Application f6207d;

    public interface Callback<T> {
        void onCall(T r10);
    }

    public static final class FileProvider4UtilCode extends FileProvider {
        public FileProvider4UtilCode() {
        }

        @Override // androidx.core.content.FileProvider, android.content.ContentProvider
        public boolean onCreate() {
            Utils.k(getContext());
            Class.forName("com.blankj.utildebug.DebugUtils");     // Catch: ClassNotFoundException -> L6
            return true;
        L9:
            return true;
        }
    }

    public interface Func1<Ret, Par> {
        Ret call(Par r10);
    }

    public interface OnActivityDestroyedListener {
        void onActivityDestroyed(Activity r10);
    }

    public interface OnAppStatusChangedListener {
        void onBackground(Activity r10);

        void onForeground(Activity r10);
    }

    public static final class TransActivity extends FragmentActivity {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map f6208a = null;

        static {
            f6208a = new HashMap();
        }

        public TransActivity() {
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent r10) {
            p.a(f6208a.get(this));
            return super.dispatchTouchEvent(r10);
        }

        @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
        public void onActivityResult(int r10, int r11, Intent r12) {
            super.onActivityResult(r10, r11, r12);
            p.a(f6208a.get(this));
        }

        @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r10) {
            overridePendingTransition(0, 0);
            super.onCreate(r10);
            finish();
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onDestroy() {
            super.onDestroy();
            p.a(f6208a.get(this));
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            overridePendingTransition(0, 0);
            super.onPause();
            p.a(f6208a.get(this));
        }

        @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
        public void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
            super.onRequestPermissionsResult(r10, r11, r12);
            p.a(f6208a.get(this));
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            super.onResume();
            p.a(f6208a.get(this));
        }

        @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onSaveInstanceState(Bundle r10) {
            super.onSaveInstanceState(r10);
            p.a(f6208a.get(this));
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStart() {
            super.onStart();
            p.a(f6208a.get(this));
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            super.onStop();
            p.a(f6208a.get(this));
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.blankj.utilcode.util.a.e();
        }
    }

    public static class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedList f6209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f6210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map f6211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6212d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6213e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6214f;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Activity f6215a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f6216b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f6217c;

            public a(b r10, Activity r11, Object r12) {
                this.f6217c = r10;
                this.f6215a = r11;
                this.f6216b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                Window r10 = this.f6215a.getWindow();
                if (r10 == null) goto L6;
                r10.setSoftInputMode(((Integer) this.f6216b).intValue());
                return;
            }
        }

        public b() {
            this.f6209a = new LinkedList();
            this.f6210b = new ArrayList();
            this.f6211c = new HashMap();
            this.f6212d = 0;
            this.f6213e = 0;
            this.f6214f = false;
        }

        public final void a(Activity r10) {
            Iterator r11 = this.f6211c.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            Map.Entry r12 = (Map.Entry) r11.next();
            if (r12.getKey() != r10) goto L4;
            Iterator r13 = ((List) r12.getValue()).iterator();
        L9:
            if (r13.hasNext() == false) goto L11;
            ((OnActivityDestroyedListener) r13.next()).onActivityDestroyed(r10);
            goto L9
        L11:
            r11.remove();
            goto L4
        }

        public void addOnAppStatusChangedListener(OnAppStatusChangedListener r10) {
            this.f6210b.add(r10);
        }

        public final void b(Activity r10, boolean r11) {
            if (this.f6210b.isEmpty() == false) goto L5;
            return;
        L5:
            Iterator r12 = this.f6210b.iterator();
        L7:
            if (r12.hasNext() == false) goto L12;
            OnAppStatusChangedListener r13 = (OnAppStatusChangedListener) r12.next();
            if (r11 == true) goto L10;
            r13.onBackground(r10);
            goto L7
        L10:
            r13.onForeground(r10);
            goto L7
        }

        public final void c(Activity r10, boolean r11) {
            if (r11 == false) goto L5;
            int r12 = r10.getWindow().getAttributes().softInputMode;
            r10.getWindow().getDecorView().setTag(NetError.ERR_SSL_NO_RENEGOTIATION, Integer.valueOf(r12));
            r10.getWindow().setSoftInputMode(3);
            return;
        L5:
            Object r13 = r10.getWindow().getDecorView().getTag(NetError.ERR_SSL_NO_RENEGOTIATION);
            if ((r13 instanceof Integer) == true) goto L8;
            return;
        L8:
            Utils.m(new a(this, r10, r13), 100);
        }

        public final void d(Activity r10) {
            if (this.f6209a.contains(r10) == true) goto L5;
            this.f6209a.addLast(r10);
            return;
        L5:
            if (((Activity) this.f6209a.getLast()).equals(r10) == true) goto L9;
            this.f6209a.remove(r10);
            this.f6209a.addLast(r10);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
            d.a(r10);
            Utils.a();
            d(r10);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
            this.f6209a.remove(r10);
            a(r10);
            Utils.b(r10.getWindow());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r10) {
            d(r10);
            if (this.f6214f == false) goto L5;
            this.f6214f = false;
            b(r10, true);
        L5:
            c(r10, false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r10) {
            if (this.f6214f == true) goto L5;
            d(r10);
        L5:
            int r11 = this.f6213e;
            if (r11 >= 0) goto L8;
            this.f6213e = r11 + 1;
            return;
        L8:
            this.f6212d++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r10) {
            if (r10.isChangingConfigurations() == false) goto L5;
            this.f6213e--;
        L8:
            c(r10, true);
            return;
        L5:
            int r11 = this.f6212d - 1;
            this.f6212d = r11;
            if (r11 > 0) goto L8;
            this.f6214f = true;
            b(r10, false);
            goto L8
        }

        public void removeOnAppStatusChangedListener(OnAppStatusChangedListener r10) {
            this.f6210b.remove(r10);
        }
    }

    static {
        f6204a = new b();
        f6205b = ThreadUtils.b();
        f6206c = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void a() {
        n();
    }

    public static void b(Window r10) {
        InputMethodManager r11 = (InputMethodManager) c().getSystemService("input_method");
        if (r11 != null) goto L5;
        return;
    L5:
        String[] r12 = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        int r13 = 0;
    L7:
        if (r13 >= 4) goto L19;
        Field r14 = InputMethodManager.class.getDeclaredField(r12[r13]);     // Catch: Throwable -> L20
        if (r14.isAccessible() == true) goto L12;
        r14.setAccessible(true);     // Catch: Throwable -> L20
    L12:
        Object r15 = r14.get(r11);     // Catch: Throwable -> L20
        if ((r15 instanceof View) == false) goto L18;
        if (((View) r15).getRootView() != r10.getDecorView().getRootView()) goto L18;
        r14.set(r11, null);     // Catch: Throwable -> L20
    L18:
        r13 = r13 + 1;
        goto L7
    }

    public static Application c() {
        Application r10 = f6207d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Application r11 = d();
        j(r11);
        return r11;
    }

    public static Application d() {
        Class<?> r10 = Class.forName("android.app.ActivityThread");     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
        Object r11 = r10.getMethod("currentActivityThread", null).invoke(null, null);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
        Object r12 = r10.getMethod("getApplication", null).invoke(r11, null);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
        if (r12 == null) goto L16;
        return (Application) r12;
    L16:
        throw new NullPointerException("u should init first");     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
    L7:
        e = move-exception;
        e.printStackTrace();
    L22:
        throw new NullPointerException("u should init first");
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public static String e() {
        String r10 = g();
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        String r11 = f();
        if (TextUtils.isEmpty(r11) == true) goto L9;
        return r11;
    L9:
        return h();
    }

    public static String f() {
        ActivityManager r10 = (ActivityManager) c().getSystemService("activity");
        if (r10 != null) goto L5;
        return "";
    L5:
        List<ActivityManager.RunningAppProcessInfo> r11 = r10.getRunningAppProcesses();
        if (r11 != null) goto L8;
    L18:
        return "";
    L8:
        if (r11.size() == 0) goto L18;
        int r12 = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = r11.iterator();
    L12:
        if (r13.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();
        if (r14.pid != r12) goto L12;
        String r15 = r14.processName;
        if (r15 == null) goto L12;
        return r15;
    }

    public static String g() {
        BufferedReader r10 = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));     // Catch: Exception -> L4
        String r11 = r10.readLine().trim();     // Catch: Exception -> L4
        r10.close();     // Catch: Exception -> L4
        return r11;
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String h() {
        Application r10 = c();     // Catch: Exception -> L4
        Field r11 = r10.getClass().getField("mLoadedApk");     // Catch: Exception -> L4
        r11.setAccessible(true);     // Catch: Exception -> L4
        Object r12 = r11.get(r10);     // Catch: Exception -> L4
        Field r13 = r12.getClass().getDeclaredField("mActivityThread");     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        Object r14 = r13.get(r12);     // Catch: Exception -> L4
        return (String) r14.getClass().getDeclaredMethod("getProcessName", null).invoke(r14, null);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static e i() {
        return e.a("Utils");
    }

    public static void j(Application r10) {
        if (f6207d != null) goto L8;
        if (r10 != null) goto L6;
        f6207d = d();
    L7:
        f6207d.registerActivityLifecycleCallbacks(f6204a);
        f6205b.execute(new a());
        return;
    L6:
        f6207d = r10;
        goto L7
    L8:
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.getClass() == f6207d.getClass()) goto L15;
        Application r11 = f6207d;
        b r12 = f6204a;
        r11.unregisterActivityLifecycleCallbacks(r12);
        r12.f6209a.clear();
        f6207d = r10;
        r10.registerActivityLifecycleCallbacks(r12);
        return;
    }

    public static void k(Context r10) {
        if (r10 != null) goto L5;
        j(d());
        return;
    L5:
        j((Application) r10.getApplicationContext());
    }

    public static void l(Runnable r10) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r10.run();
        return;
    L5:
        f6206c.post(r10);
    }

    public static void m(Runnable r10, long r11) {
        f6206c.postDelayed(r10, r11);
    }

    public static void n() {
        if (ValueAnimator.areAnimatorsEnabled() == false) goto L16;
        return;
    L16:
        Field r10 = ValueAnimator.class.getDeclaredField("sDurationScale");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        if (((Float) r10.get(null)).floatValue() != 0.0f) goto L18;
        r10.set(null, Float.valueOf(1.0f));     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        Log.i("Utils", "setAnimatorsEnabled: Animators are enabled now!");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
    L20:
        return;
    L18:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
