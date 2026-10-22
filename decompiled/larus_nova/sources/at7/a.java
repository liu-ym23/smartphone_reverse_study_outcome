package at7;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<Activity> f16265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<b> f16266b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f16267c;

    /* JADX INFO: renamed from: at7.a$a, reason: collision with other inner class name */
    public static final class C0225a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16268a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        public final void a() {
            int r100 = this.f16268a - 1;     // Catch: Exception -> L10
            this.f16268a = r100;     // Catch: Exception -> L10
            if (r100 != 0) goto L9;
            a.f16267c = true;     // Catch: Exception -> L10
            Iterator<T> r101 = a.f16266b.iterator();     // Catch: Exception -> L10
        L6:
            if (r101.hasNext() == false) goto L16;
            ((b) r101.next()).onBackground();     // Catch: Exception -> L10
        L16:
            return;
        L9:
            return;
        }

        public C0225a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            LinkedList<Activity> r101 = a.f16265a;
            a.f16265a.remove(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Build.VERSION.SDK_INT < 29) goto L6;
            a();
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = this.f16268a + 1;
            this.f16268a = r101;
            if (r101 == 1) goto L5;
            return;
        L5:
            if (a.f16267c == false) goto L12;
            a.f16267c = false;
            Iterator<T> r102 = a.f16266b.iterator();
        L8:
            if (r102.hasNext() == false) goto L13;
            ((b) r102.next()).onForeground(r100);
            goto L8
        L13:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            a();
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            LinkedList<Activity> r102 = a.f16265a;
            LinkedList<Activity> r103 = a.f16265a;
            r103.remove(r100);
            r103.add(r100);
        }
    }

    public interface b {
        void onBackground();

        void onForeground(Activity r100);
    }

    static {
        f16265a = new LinkedList();
        f16266b = new LinkedList();
        f16267c = true;
    }
}
