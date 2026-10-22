package com.stepos.stepclaw.base.util;

import android.app.Application;
import android.provider.Settings;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0003J\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/stepos/stepclaw/base/util/StepModel;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "readModelName", "()Ljava/lang/String;", "readApiToken", "Landroid/app/Application;", "app", "Lb5/a0;", "init", "(Landroid/app/Application;)V", "refreshLightMemConfig", "getModelName", "getApiToken", "TAG", "Ljava/lang/String;", "application", "Landroid/app/Application;", "cachedModelName", "cachedApiToken", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepModel {
    private static final String TAG = "StepModel";
    private static Application application;
    public static final StepModel INSTANCE = new StepModel();
    private static volatile String cachedModelName = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    private static volatile String cachedApiToken = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;

    private StepModel() {
    }

    private final String readApiToken() {
        Application application2 = application;
        if (application2 != null) {
            String string = Settings.Secure.getString(application2.getContentResolver(), "lightmem_key");
            return string == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : string;
        }
        p.l("application");
        throw null;
    }

    private final String readModelName() {
        Application application2 = application;
        if (application2 != null) {
            String string = Settings.Secure.getString(application2.getContentResolver(), "lightmem_model");
            return string == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : string;
        }
        p.l("application");
        throw null;
    }

    public final String getApiToken() {
        return cachedApiToken;
    }

    public final String getModelName() {
        return cachedModelName;
    }

    public final void init(Application app) {
        p.e(app, "app");
        application = app;
        refreshLightMemConfig();
    }

    public final void refreshLightMemConfig() {
        cachedModelName = readModelName();
        cachedApiToken = readApiToken();
        ALog.i$default(TAG, f.c("lightmem updated: model=", cachedModelName), null, 4, null);
    }
}
