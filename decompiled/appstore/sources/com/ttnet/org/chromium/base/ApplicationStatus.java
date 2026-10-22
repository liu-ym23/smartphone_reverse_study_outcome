package com.ttnet.org.chromium.base;

import android.app.Activity;
import androidx.annotation.AnyThread;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
public class ApplicationStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f18217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f18218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Activity f18219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ApplicationStateListener f18220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ObserverList f18221e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ObserverList f18222f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ObserverList f18223g = null;

    public interface ActivityStateListener {
        void onActivityStateChange(Activity r10, int r11);
    }

    public interface ApplicationStateListener {
        void onApplicationStateChange(int r10);
    }

    public interface Natives {
        void onApplicationStateChange(int r10);
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity r10, boolean r11);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: com.ttnet.org.chromium.base.ApplicationStatus$a$a, reason: collision with other inner class name */
        public class C0221a implements ApplicationStateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f18224a;

            public C0221a(a r10) {
                this.f18224a = r10;
            }

            @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
            public void onApplicationStateChange(int r10) {
                b.b().onApplicationStateChange(r10);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApplicationStatus.a() == null) goto L5;
            return;
        L5:
            ApplicationStatus.b(new C0221a(this));
            ApplicationStatus.d(ApplicationStatus.a());
        }
    }

    static {
        f18217a = Collections.synchronizedMap(new HashMap());
        f18218b = 0;
        f18221e = new ObserverList();
        f18222f = new ObserverList();
        f18223g = new ObserverList();
    }

    public static /* synthetic */ ApplicationStateListener a() {
        return f18220d;
    }

    public static /* synthetic */ ApplicationStateListener b(ApplicationStateListener r10) {
        f18220d = r10;
        return r10;
    }

    public static Activity c() {
        return f18219c;
    }

    public static void d(ApplicationStateListener r10) {
        f18222f.e(r10);
    }

    public static void e(ApplicationStateListener r10) {
        f18222f.k(r10);
    }

    @AnyThread
    @CalledByNative
    public static int getStateForApplication() {
        Map r10 = f18217a;
        monitor-enter(r10);
        int r11 = f18218b;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @AnyThread
    @CalledByNative
    public static boolean hasVisibleActivities() {
        int r10 = getStateForApplication();
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.d(new a());
    }
}
