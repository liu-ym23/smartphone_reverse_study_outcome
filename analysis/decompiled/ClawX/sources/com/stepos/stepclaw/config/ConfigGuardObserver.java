package com.stepos.stepclaw.config;

import a.a;
import a6.z;
import a8.b;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.emoji2.text.t;
import b5.a0;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import d5.c;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p5.l;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/stepclaw/config/ConfigGuardObserver;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/io/File;", "configDir", "Lcom/stepos/stepclaw/config/JsonConfigStore;", "configStore", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lb5/a0;", "onLog", "<init>", "(Ljava/io/File;Lcom/stepos/stepclaw/config/JsonConfigStore;Lp5/l;)V", "scheduleCheck", "()V", "checkAndEnforce", "start", "stop", "Ljava/io/File;", "Lcom/stepos/stepclaw/config/JsonConfigStore;", "Lp5/l;", "Landroid/os/FileObserver;", "observer", "Landroid/os/FileObserver;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "pendingCheck", "Ljava/lang/Runnable;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConfigGuardObserver {
    private static final long DEBOUNCE_MS = 500;
    private static final String TAG = "ConfigGuard";
    private final File configDir;
    private final JsonConfigStore configStore;
    private final Handler handler;
    private FileObserver observer;
    private final l onLog;
    private Runnable pendingCheck;

    public ConfigGuardObserver(File configDir, JsonConfigStore configStore, l onLog) {
        p.e(configDir, "configDir");
        p.e(configStore, "configStore");
        p.e(onLog, "onLog");
        this.configDir = configDir;
        this.configStore = configStore;
        this.onLog = onLog;
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 _init_$lambda$0(String it) {
        p.e(it, "it");
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndEnforce() {
        try {
            boolean zEnsureGatewayBind = this.configStore.ensureGatewayBind();
            boolean zEnsureGatewayAuthTokenMode = this.configStore.ensureGatewayAuthTokenMode();
            boolean zEnsureGatewayPort = this.configStore.ensureGatewayPort();
            boolean zEnsureGatewayModeLocal = this.configStore.ensureGatewayModeLocal();
            boolean zEnsureGatewayTlsDisabled = this.configStore.ensureGatewayTlsDisabled();
            boolean zEnsureGatewayExperimental = this.configStore.ensureGatewayExperimental();
            if (!zEnsureGatewayBind && !zEnsureGatewayAuthTokenMode && !zEnsureGatewayPort && !zEnsureGatewayModeLocal && !zEnsureGatewayTlsDisabled && !zEnsureGatewayExperimental) {
                return;
            }
            c cVarP = a.p();
            if (zEnsureGatewayBind) {
                cVarP.add("gateway.bind");
            }
            if (zEnsureGatewayAuthTokenMode) {
                cVarP.add("gateway.auth");
            }
            if (zEnsureGatewayPort) {
                cVarP.add("gateway.port");
            }
            if (zEnsureGatewayModeLocal) {
                cVarP.add("gateway.mode");
            }
            if (zEnsureGatewayTlsDisabled) {
                cVarP.add("gateway.tls");
            }
            if (zEnsureGatewayExperimental) {
                cVarP.add("gateway.experimental");
            }
            c cVarE = a.e(cVarP);
            Log.w(TAG, "auto-rollback: corrected " + m.A0(cVarE, null, null, null, null, 63));
            this.onLog.invoke("[ConfigGuard] auto-rollback: " + m.A0(cVarE, null, null, null, null, 63));
        } catch (Exception e9) {
            Log.e(TAG, "checkAndEnforce failed", e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleCheck() {
        Runnable runnable = this.pendingCheck;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        t tVar = new t(2, this);
        this.handler.postDelayed(tVar, DEBOUNCE_MS);
        this.pendingCheck = tVar;
    }

    public final void start() {
        stop();
        if (!this.configDir.isDirectory()) {
            b.y("config dir does not exist: ", this.configDir.getAbsolutePath(), TAG);
            return;
        }
        FileObserver fileObserver = new FileObserver(394, this.configDir) { // from class: com.stepos.stepclaw.config.ConfigGuardObserver.start.1
            @Override // android.os.FileObserver
            public void onEvent(int event, String path) {
                if (path == null) {
                    return;
                }
                if (path.equals("openclaw.json") || u.c1(path, "openclaw.json.", false)) {
                    this.scheduleCheck();
                }
            }
        };
        fileObserver.startWatching();
        this.observer = fileObserver;
        Log.i(TAG, "started on " + this.configDir.getAbsolutePath());
    }

    public final void stop() {
        Runnable runnable = this.pendingCheck;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.pendingCheck = null;
        FileObserver fileObserver = this.observer;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        this.observer = null;
    }

    public /* synthetic */ ConfigGuardObserver(File file, JsonConfigStore jsonConfigStore, l lVar, int i8, i iVar) {
        this(file, jsonConfigStore, (i8 & 4) != 0 ? new z(24) : lVar);
    }
}
