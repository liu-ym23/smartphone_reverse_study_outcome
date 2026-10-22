package com.obric.autogui.operator.a.b.a;

import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: OpenAppResultType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f29445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f29446b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f29447c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f29448d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f29449e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    public static final b j = null;
    public static final b k = null;
    public static final b l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    public static final b p = null;
    private static final /* synthetic */ b[] t = null;
    private static final /* synthetic */ d.d.a u = null;
    private final int q;
    private final String r;
    private final boolean s;

    private static final /* synthetic */ b[] d() {
        return new b[]{f29445a, f29446b, f29447c, f29448d, f29449e, f, g, h, i, j, k, l, m, n, o, p};
    }

    private b(String r1, int r2, int r3, String r4, boolean r5) {
        super(r1, r2);
        this.q = r3;
        this.r = r4;
        this.s = r5;
    }

    /* synthetic */ b(String r7, int r8, int r9, String r10, boolean r11, int r12, h r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = false;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public final int a() {
        return this.q;
    }

    public final String b() {
        return this.r;
    }

    public final boolean c() {
        return this.s;
    }

    static {
        f29445a = new b("Ok", 0, 0, "opened_app", true);
        f29446b = new b("InternalFailure", 1, -1, "failed", false, 4, null);
        f29447c = new b("InputNotRecognised", 2, -101, "input_not_recognised", false, 4, null);
        boolean r6 = false;
        int r7 = 4;
        h r8 = null;
        f29448d = new b("UserInterrupt", 3, -102, "user_interrupt", r6, r7, r8);
        boolean r14 = false;
        int r15 = 4;
        h r16 = null;
        f29449e = new b("NotAuthorized", 4, -107, "not_authorized", r14, r15, r16);
        f = new b("AppNotInstalled", 5, -103, "no_matching_packages", r6, r7, r8);
        g = new b("NoCandidateFound", 6, -104, "no_candidate_found", r14, r15, r16);
        h = new b("NoLauncherEntryFound", 7, -105, "no_launcher_entry_found", r6, r7, r8);
        i = new b("AppRestartTimesExceeded", 8, -106, "app_restart_times_exceeded", r14, r15, r16);
        j = new b("OpenedInPlace", 9, 200, "open_app_in_place", true);
        k = new b("AlreadyOpened", 10, 201, "already_opened", true);
        l = new b("StartActivityFailed", 11, -202, "start_activity_failed", false, 4, null);
        m = new b("CannotResolveImplicitIntent", 12, -203, "implicit_intent_unresolved", false, 4, null);
        n = new b("OpenedDesiredPackage", 13, EntityType.SIM_CARD, "opened_desired_package", true);
        o = new b("OpenedDeepLink", 14, 205, "opened_deeplink", true);
        p = new b("OpenedShortcut", 15, 206, "opened_shortcut", true);
        b[] r0 = d();
        t = r0;
        u = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(t.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
