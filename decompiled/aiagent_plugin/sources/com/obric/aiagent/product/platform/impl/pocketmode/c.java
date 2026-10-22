package com.obric.aiagent.product.platform.impl.pocketmode;

import android.app.Application;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.e;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: ObricPocketModeDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.obric.aiagent.product.platform.impl.pocketmode.a {
    private static final String TAG = "ObricPocketModeDetector";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18865b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f18866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f18867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f18868e;
    private static final ObricPocketModeDetector$Companion$systemUIStateObserver$1 f = null;
    private static final ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1 g = null;

    /* JADX INFO: compiled from: ObricPocketModeDetector.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ void a(a r0) {
            r0.b();
        }

        public static final /* synthetic */ void b(a r0) {
            r0.c();
        }

        private final void b() {
            boolean r1 = false;
            if (Settings.Global.getInt(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), "obric_proximity_hint_dismissed", 0) != 1) goto L6;
            r1 = true;
        L6:
            c.b(r1);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            ILogDepend.Companion.e(c.TAG, "updateSystemUIState failed", th);
        }

        private final void c() {
            boolean r1 = true;
            if (Settings.System.getInt(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), "pocket_mode_enable", 1) == 1) goto L7;
            r1 = false;
        L7:
            c.c(r1);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            ILogDepend.Companion.e(c.TAG, "updatePocketModeEnableState failed", th);
        }

        public final synchronized void a() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (c.i() == false) goto L18;
            ILogDepend.Companion.i(c.TAG, "init() already called, skip");     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L18:
            ZeusProviderTransform.registerContentObserver(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), Settings.Global.getUriFor("obric_proximity_hint_dismissed"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(c.j(), ContentObserver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            ZeusProviderTransform.registerContentObserver(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), Settings.System.getUriFor("pocket_mode_enable"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(c.k(), ContentObserver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            b();     // Catch: Throwable -> L10
            c();     // Catch: Throwable -> L10
            c.d(true);     // Catch: Throwable -> L10
            ILogDepend.Companion.i(c.TAG, "init() called");     // Catch: Throwable -> L10
        L12:
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            ILogDepend.Companion.e(c.TAG, "init() failed", th);     // Catch: Throwable -> L14
            goto L12
        }
    }

    public c() {
    }

    public static final /* synthetic */ void b(boolean r0) {
        f18867d = r0;
    }

    public static final /* synthetic */ void c(boolean r0) {
        f18866c = r0;
    }

    public static final /* synthetic */ void d(boolean r0) {
        f18868e = r0;
    }

    public static final /* synthetic */ boolean i() {
        return f18868e;
    }

    public static final /* synthetic */ ObricPocketModeDetector$Companion$systemUIStateObserver$1 j() {
        return f;
    }

    public static final /* synthetic */ ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1 k() {
        return g;
    }

    public static final /* synthetic */ boolean l() {
        return f18867d;
    }

    public static final /* synthetic */ boolean m() {
        return f18866c;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.aiagent.product.platform.impl.pocketmode.ObricPocketModeDetector$Companion$systemUIStateObserver$1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.aiagent.product.platform.impl.pocketmode.ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1] */
    static {
        f18865b = new a(null);
        f18866c = true;
        final Handler r0 = e.f18781a.a();
        f = new ObricPocketModeDetector$Companion$systemUIStateObserver$1(r0);
        final Handler r1 = e.f18781a.b();
        g = new ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1(r1);
    }

    @Override // com.obric.aiagent.product.platform.impl.pocketmode.a, com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void init() {
        f18865b.a();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void showProximityNearAlert() {
        ILogDepend.Companion.i(TAG, "showProximityNearAlert() called");
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        Intent r0 = new Intent("com.obric.systemui.FORCE_ALERT_PROXIMITY_NEAR");
        r0.setPackage(IslandImpl.LIVE_CARD_HOST);
        r2.sendBroadcast(r0);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeManuallyDismissed() {
        ILogDepend.Companion.i(TAG, "isPocketModeManuallyDismissed() return " + f18867d);
        return f18867d;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeEnabled() {
        ILogDepend.Companion.i(TAG, "isPocketModeEnabled() return " + f18866c);
        return f18866c;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isProximityNearAlertShowing() {
        ILogDepend.Companion.i(TAG, "isProximityNearAlertShowing() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void hideProximityNearAlert() {
        ILogDepend.Companion.d(TAG, "hideProximityNearAlert() called, do nothing");
    }
}
