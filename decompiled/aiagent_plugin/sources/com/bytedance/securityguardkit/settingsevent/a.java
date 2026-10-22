package com.bytedance.securityguardkit.settingsevent;

import android.util.Log;
import com.aiassistant.security.guard.AssistantSecurityGuardManager;
import com.aiassistant.security.guard.IAssistantSettingsEventObserver;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.security.guard.IObricSettingsEventObserver;
import com.obric.security.guard.ObricSecurityGuardManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BDSettingsEventObserver.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "BDSettingsEventObserver";
    private static volatile a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IObricSettingsEventObserver f11147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IAssistantSettingsEventObserver f11148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObricSecurityGuardManager f11149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AssistantSecurityGuardManager f11150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, Set<Integer>> f11151e;
    private b g;

    static /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.f11151e;
    }

    static /* synthetic */ b b(a r0) {
        return r0.g;
    }

    public static a a() {
        if (f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    private a() {
        this.f11151e = new ConcurrentHashMap();
        this.f11147a = new BDSettingsEventObserver$1(this);
        this.f11148b = new BDSettingsEventObserver$2(this);
        this.f11149c = new ObricSecurityGuardManager();
        this.f11150d = new AssistantSecurityGuardManager();
    }

    public void a(b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        this.f11149c.registerSettingsEventObserver(this.f11147a);     // Catch: Exception -> L5
    L15:
        this.f11150d.registerSettingsEventObserver(this.f11148b);     // Catch: Exception -> L9
    L11:
        this.g = r6;
        return;
    L9:
        e = move-exception;
        a(TAG, "mAssistantGuardManager.registerSettingsEventObserver failed, " + e);
    L5:
        e = move-exception;
        a(TAG, "mGuardManager.registerSettingsEventObserver failed, " + e);
        goto L15
    }

    public void b() {
        this.f11149c.unregisterSettingsEventObserver(this.f11147a);     // Catch: Exception -> L5
    L15:
        this.f11150d.unregisterSettingsEventObserver(this.f11148b);     // Catch: Exception -> L9
    L11:
        this.f11151e.clear();
        return;
    L9:
        e = move-exception;
        a(TAG, "mAssistantGuardManager.unregisterSettingsEventObserver failed, " + e);
    L5:
        e = move-exception;
        a(TAG, "mGuardManager.unregisterSettingsEventObserver failed, " + e);
        goto L15
    }

    public boolean a(String r3) {
        b(TAG, "checkSettingsEvent packageName:" + r3);
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(this.f11151e.get(r3), Set.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        c(TAG, "checkSettingsEvent return false");
        return false;
    L5:
        if (r2.size() <= 0) goto L8;
        c(TAG, "checkSettingsEvent return true");
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
