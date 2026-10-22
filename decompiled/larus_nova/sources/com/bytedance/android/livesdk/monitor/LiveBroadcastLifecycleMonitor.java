package com.bytedance.android.livesdk.monitor;

import android.app.Activity;
import b30.f0;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.config.v90;
import com.bytedance.android.livesdkapi.CommerceFragmentDispatcher;
import com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveBroadcastLifecycleMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f153970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f153971b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f153972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Disposable f153973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f153974e;

    public static final class a extends IHostAppMonitorListener.Stub {
        public a() {
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Intrinsics.areEqual(v90.f121429a.getValue(), Boolean.FALSE) == false) goto L5;
            return;
        L5:
            String r101 = r100.getClass().getSimpleName();
            NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_PAGE_DESTROY, null, null, 14);
            r102.c(r101);
            r102.i("status_msg", r101);
            if (LiveBroadcastLifecycleMonitor.f153972c == false) goto L8;
            String r103 = "1";
        L9:
            r102.e("isLivePage", r103);
            if (StringsKt.contains$default(r100.getLocalClassName(), "live.LiveBroadcastActivity", false, 2, null) == false) goto L12;
        L13:
            IHostApp r104 = (IHostApp) k.f(IHostApp.class);
            if (r104 == null) goto L18;
            Activity r105 = r104.getTopActivity();
            if (r105 == null) goto L18;
            String r106 = r105.getClass().getSimpleName();
            r102.d(r106);
            r102.i("topActivity", r106);
        L18:
            r102.a().report();
            return;
        L12:
            if (StringsKt.contains$default(r100.getLocalClassName(), "live.TransparentLiveBroadcastActivity", false, 2, null) == false) goto L18;
        L8:
            r103 = "0";
            goto L9
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            String r101 = r100.getClass().getSimpleName();
            NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_PAGE_DISMISS, null, null, 14);
            r102.c(r101);
            r102.i("status_msg", r101);
            if (LiveBroadcastLifecycleMonitor.f153972c == false) goto L5;
            String r103 = "1";
        L6:
            r102.e("isLivePage", r103);
            r102.a().report();
            return;
        L5:
            r103 = "0";
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            String r101 = r100.getClass().getSimpleName();
            NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_PAGE_SHOW, null, null, 14);
            r102.c(r101);
            r102.i("status_msg", r101);
            if (LiveBroadcastLifecycleMonitor.f153972c == false) goto L5;
            String r103 = "1";
        L6:
            r102.e("isLivePage", r103);
            r102.a().report();
            return;
        L5:
            r103 = "0";
            goto L6
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r101) {
            super.appEnterBackground(r100, r101);
            if (r101 == false) goto L5;
            return;
        L5:
            if (r100 == false) goto L7;
            NewBroadcastMonitor.f(NewBroadcastMonitor.SERVICE.SERVICE_ENTER_BACKGROUND);
            return;
        L7:
            NewBroadcastMonitor.f(NewBroadcastMonitor.SERVICE.SERVICE_ENTER_FOREGROUND);
        }
    }

    public static void a() {
        f153972c = true;
        if (f153974e == true) goto L7;
        f153974e = true;
        Lazy r100 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().a(f153970a);
        f153973d = xs2.b.a().b(f0.class).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.livesdk.monitor.a.f153975a);
        CommerceFragmentDispatcher.INSTANCE.registerListener((IDialogFragmentLifecycle) f153971b.getValue());
        return;
    }

    public static void b() {
        f153972c = false;
        if (f153974e == false) goto L10;
        f153974e = false;
        Lazy r100 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().b(f153970a);
        Disposable r101 = f153973d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    L9:
        return;
    }

    static {
        f153970a = new a();
        f153971b = LazyKt.lazy(LiveBroadcastLifecycleMonitor$commerceFragmentLifecycleListener$2.INSTANCE);
    }
}
