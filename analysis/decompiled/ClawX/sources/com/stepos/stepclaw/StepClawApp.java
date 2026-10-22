package com.stepos.stepclaw;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.webkit.WebView;
import b5.e;
import b8.h;
import c5.l;
import com.stepos.stepclaw.base.framework.ServiceLocator;
import com.stepos.stepclaw.base.track.ClawEventReporter;
import com.stepos.stepclaw.base.track.ClawReportBridge;
import com.stepos.stepclaw.base.track.ClawReporterDependenciesImpl;
import com.stepos.stepclaw.provider.backend.OpenClawProviderBackend;
import com.stepos.stepclaw.provider.impl.GatewayManagerImpl;
import com.stepos.stepclaw.provider.impl.LazyConfigStore;
import com.stepos.stepclaw.provider.impl.MountedRootfsAccess;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u0003R\u001b\u0010\u0012\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/StepClawApp;", "Landroid/app/Application;", "<init>", "()V", "Lcom/stepos/stepclaw/provider/impl/MountedRootfsAccess;", "createRootfsAccess", "()Lcom/stepos/stepclaw/provider/impl/MountedRootfsAccess;", "Landroid/content/Context;", "base", "Lb5/a0;", "attachBaseContext", "(Landroid/content/Context;)V", "onCreate", "Lcom/stepos/stepclaw/GatewayRuntime;", "runtime$delegate", "Lb5/e;", "getRuntime", "()Lcom/stepos/stepclaw/GatewayRuntime;", "runtime", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepClawApp extends Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isWebViewAllowed = true;

    /* renamed from: runtime$delegate, reason: from kotlin metadata */
    private final e runtime = h.x(new d(this, 0));

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/StepClawApp$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isWebViewAllowed", "()Z", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean isWebViewAllowed() {
            return StepClawApp.isWebViewAllowed;
        }

        private Companion() {
        }
    }

    private final MountedRootfsAccess createRootfsAccess() {
        return new MountedRootfsAccess(OpenClawRuntimeConfig.INSTANCE.fromContext(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GatewayRuntime runtime_delegate$lambda$0(StepClawApp stepClawApp) {
        return new GatewayRuntime(stepClawApp);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context base) {
        p.e(base, "base");
        Log.e("StepClawApp", "attachBaseContext " + Process.myTid() + "  " + Process.myPid());
        ServiceLocator.INSTANCE.init(this);
        super.attachBaseContext(base);
        Log.i("StepClawApp", "attachBaseContext: ServiceLocator.init called pid=" + Process.myPid());
        Object obj = k3.c.f3584a;
        k3.c.a(l.S(new Integer[]{5, 6, 7}));
        OpenClawProviderBackend.INSTANCE.install(new OpenClawProviderBackend.Backend(createRootfsAccess(), new LazyConfigStore(new d(this, 1)), new GatewayManagerImpl(this)));
    }

    public final GatewayRuntime getRuntime() {
        return (GatewayRuntime) this.runtime.getValue();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Object obj = k3.c.f3584a;
        k3.c.a(l.S(new Integer[]{5, 6, 7}));
        ClawReportBridge.INSTANCE.init(this, new ClawEventReporter(new ClawReporterDependenciesImpl()));
        StepClawManager stepClawManager = StepClawManager.INSTANCE;
        stepClawManager.init(this);
        stepClawManager.setDebug(false);
        try {
            new WebView(this);
        } catch (UnsupportedOperationException unused) {
            isWebViewAllowed = false;
        }
        UserSetupCompletionGate.INSTANCE.startGatewayWhenComplete(this, "application_on_create");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context attachBaseContext$lambda$0(StepClawApp stepClawApp) {
        return stepClawApp;
    }
}
