package com.obric.aiagent.executionengine.capabilitymanager.api.appfunction;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0330a f16409a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f16410e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<String> f16413d;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppFunctionSettings.kt */
    public static final class C0330a {
        public /* synthetic */ C0330a(h r1) {
            this();
        }

        private C0330a() {
        }

        public final a a() {
            IAppFunctionSettingsService r2 = (IAppFunctionSettingsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppFunctionSettingsService.class), IAppFunctionSettingsService.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L7;
            a r3 = r2.getSettings();
            if (r3 == null) goto L7;
            return r3;
        L7:
            return a.d();
        }
    }

    public a() {
        this(false, false, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f16411b == r6.f16411b) goto L12;
        return false;
    L12:
        if (this.f16412c == r6.f16412c) goto L15;
        return false;
    L15:
        if (o.a(this.f16413d, r6.f16413d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f16411b) * 31) + Boolean.hashCode(this.f16412c)) * 31) + this.f16413d.hashCode();
    }

    public String toString() {
        return "AppFunctionSettings(enableIndex=" + this.f16411b + ", enableKDoc=" + this.f16412c + ", blockApps=" + this.f16413d + ')';
    }

    public a(boolean r3, boolean r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "blockApps");
        this.f16411b = r3;
        this.f16412c = r4;
        this.f16413d = r6;
    }

    public static final /* synthetic */ a d() {
        return f16410e;
    }

    public final boolean a() {
        return this.f16411b;
    }

    public final boolean b() {
        return this.f16412c;
    }

    public /* synthetic */ a(boolean r2, boolean r3, List r4, int r5, h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r7 = p.b();
    L11:
        this(r2, r3, r7);
    }

    public final List<String> c() {
        return this.f16413d;
    }

    static {
        f16409a = new C0330a(null);
        f16410e = new a(false, false, null, 7, null);
    }
}
