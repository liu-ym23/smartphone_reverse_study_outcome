package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.matrix.platform.sdk.ones.safecushion.ui.CushionActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.h.b.p;
import d.m;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SafeCushionCrashCounter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final String TAG = "SafeModeCounter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f33728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f33729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f33730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f33731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f33732e;
    private static volatile boolean f;
    private static boolean g;
    private static volatile boolean h;
    private static final com.obric.matrix.platform.sdk.ones.safecushion.b.b i = null;
    private static final f j = null;
    private static final f k = null;

    /* JADX INFO: compiled from: SafeCushionCrashCounter.kt */
    static final class a extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33733a = null;

        static {
            f33733a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }

        public final Boolean a() {
            return Boolean.valueOf(com.obric.matrix.platform.sdk.ones.safecushion.b.a.f33719a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        }
    }

    /* JADX INFO: compiled from: SafeCushionCrashCounter.kt */
    static final class b extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f33734a = null;

        static {
            f33734a = new b();
        }

        b() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }

        public final Boolean a() {
            return Boolean.valueOf(com.obric.matrix.platform.sdk.ones.safecushion.b.a.f33719a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        }
    }

    /* JADX INFO: compiled from: SafeCushionCrashCounter.kt */
    static final class c extends p implements d.h.a.b<File, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f33735a = null;

        static {
            f33735a = new c();
        }

        c() {
            super(1);
        }

        public final Boolean a(File r1) {
            o.e(r1, "it");
            return Boolean.valueOf(d.a(d.f33728a, r1));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(File r3) {
            return a((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"));
        }
    }

    private d() {
    }

    public static final /* synthetic */ boolean a(d r0, File r1) {
        return r0.a(r1);
    }

    static {
        d r0 = new d();
        f33728a = r0;
        f33729b = -1;
        f33730c = -1;
        f33731d = -1;
        i = new com.obric.matrix.platform.sdk.ones.safecushion.b.b();
        j = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f33733a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        k = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(b.f33734a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r0.b() == false) goto L5;
        f33729b = r0.a("supposeCrash");
        int r1 = r0.a("crashInfo");
        f33731d = r1;
        f33730c = r1;
        r0.d();
    L5:
        r0.a();
    }

    private final boolean b() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(j.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final boolean c() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(k.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public final int a(String r8) {
        o.e(r8, "crashFileNamePrefix");
        File r0 = com.obric.matrix.platform.sdk.ones.safecushion.b.c.f33722a.a(r8);
        if (r0 == null) goto L14;
        String r1 = r0.getName();     // Catch: Exception -> L8
        o.c(r1, "it.name");     // Catch: Exception -> L8
        List r2 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L8
        if (r2.size() <= 1) goto L15;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.get(1), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, r8 + " getCrashCount: " + r7, null, 4, null);     // Catch: Exception -> L8
        return Integer.parseInt(r7);
    L15:
        return 0;
    L8:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L14:
        return 0;
    }

    private final void d() {
        if (b() == false) goto L6;
        e();
        return;
    }

    private final void e() {
        if (b() == true) goto L5;
        return;
    L5:
        if (f33730c >= f()) goto L9;
        if (f33729b >= 4) goto L9;
        return;
    L9:
        if (g() == false) goto L11;
        i();
        return;
    L11:
        a(true);
    }

    public final void a() {
        if (c() == false) goto L13;
        com.obric.matrix.platform.sdk.ones.safecushion.b.b r2 = i;
        String r0 = r2.e();
        if (r2.c(r0) == true) goto L7;
        return;
    L7:
        if (r0 != null) goto L10;
        r2.a("repair");
        return;
    L10:
        if (o.a(r0, "repair") == false) goto L16;
        r2.a("upgrade");
        return;
    L16:
        return;
    }

    private final int f() {
        int r0 = com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().a().b();
        if (r0 > 0) goto L7;
        return 3;
    L7:
        return r0;
    }

    private final boolean g() {
        if (com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().a().c() != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void b(String r10) {
        if (b() == false) goto L8;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "increaseCrashCount currentCrashCount:" + f33731d, null, 4, null);
        if (a(this, "crashInfo", "crashInfo-" + (f33731d + 1) + '-' + System.currentTimeMillis() + '-' + r10, null, 4, null) == false) goto L9;
        f33732e = true;
        f33731d++;
        return;
    L9:
        return;
    }

    static /* synthetic */ boolean a(d r1, String r2, String r3, d.h.a.b r4, int r5, Object r6) {
        d.h.a.b<? super File, Boolean> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f33735a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r2, r3, r7);
    }

    private final boolean a(String r12, String r13, d.h.a.b<? super File, Boolean> r14) {
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        File r2 = com.obric.matrix.platform.sdk.ones.safecushion.b.c.f33722a.a();     // Catch: Exception -> L38
        File r3 = new File(r2, r13);     // Catch: Exception -> L38
        File[] r4 = r2.listFiles();     // Catch: Exception -> L38
        StringBuilder r16 = new StringBuilder().append("updateCrashCount crashFileName:").append(r13).append(",containFile:");     // Catch: Exception -> L38
        if (r4 != null) goto L6;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        boolean r6 = true;
    L16:
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, r16.append(r6).toString(), null, 4, null);     // Catch: Exception -> L38
        if (r4 == null) goto L36;
        int r17 = r4.length;     // Catch: Exception -> L38
        int r7 = 0;
    L19:
        if (r7 >= r17) goto L36;
        File r8 = r4[r7];     // Catch: Exception -> L38
        String r9 = r8.getName();     // Catch: Exception -> L38
        o.c(r9, "it.name");     // Catch: Exception -> L38
        if (d.o.o.b(r9, r12, false, 2, null) == true) goto L23;
        r7 = r7 + 1;     // Catch: Exception -> L38
        goto L19
    L23:
        if (r15 == null) goto L27;
        o.c(r8, "it");     // Catch: Exception -> L38
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15.invoke(r8), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L27;
        boolean r18 = true;
    L28:
        if (r18 == false) goto L32;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "updateCrashCount: interrupt", null, 4, null);     // Catch: Exception -> L38
        return false;
    L32:
        if (r8.renameTo(r3) == true) goto L34;
        com.obric.matrix.platform.sdk.ones.safecushion.b.c r11 = com.obric.matrix.platform.sdk.ones.safecushion.b.c.f33722a;     // Catch: Exception -> L38
        o.c(r8, "it");     // Catch: Exception -> L38
        r11.a(r8);     // Catch: Exception -> L38
        r3.createNewFile();     // Catch: Exception -> L38
    L34:
        return true;
    L27:
        r18 = false;
    L36:
        r3.createNewFile();     // Catch: Exception -> L38
        return true;
    L15:
        r6 = false;
        goto L16
    L6:
        if (r4.length != 0) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L12;
        r5 = false;
        goto L13
    L8:
        r10 = false;
    L38:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private final boolean a(File r8) {
        String r7 = r8.getName();
        o.c(r7, "file.name");
        List r9 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r9.size() <= 2) goto L8;
        long r10 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r9.get(2), String.class, "com.obric.aiagent.plugin"));
        if ((System.currentTimeMillis() - r10) >= 1000) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public final synchronized void a(String r5, String r6, Thread r7) {
        monitor-enter(this);
        o.e(r5, "crashType");     // Catch: Throwable -> L27
        String r3 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "onCrash:" + r5 + ",thread:" + r7 + ",crashMsg:" + r6, null, 4, null);     // Catch: Throwable -> L27
        if (b() == true) goto L9;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "onCrash isn't main process", null, 4, null);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L9:
        if (h == false) goto L14;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "onCrash haveDealtWithCrash", null, 4, null);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L14:
        if (f == false) goto L19;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "onCrash already normalStart", null, 4, null);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L19:
        if (f33732e == true) goto L21;
        b(r5);     // Catch: Throwable -> L27
    L21:
        com.obric.matrix.platform.sdk.ones.safecushion.b.c r0 = com.obric.matrix.platform.sdk.ones.safecushion.b.c.f33722a;     // Catch: Throwable -> L27
        if (r7 == null) goto L24;
        r3 = r7.toString();     // Catch: Throwable -> L27
    L24:
        r0.a(r5, r6, r3, f33731d);     // Catch: Throwable -> L27
        b(r5, r6, r7);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    }

    private final void b(String r3, String r4, Thread r5) {
        boolean r6 = !com.obric.matrix.platform.sdk.ones.safecushion.b.a.f33719a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "performStartSafeMode currentCrashCount:" + f33731d + ",isForeground:" + r6, null, 4, null);
        if (f33731d < f()) goto L5;
    L6:
        if (r6 == true) goto L8;
        return;
    L8:
        if (g() == false) goto L10;
        i();
        return;
    L10:
        a(false);
        return;
    L5:
        if (f33729b > f()) goto L6;
    }

    private final void a(boolean r11) {
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "startActivityIfNeed isLaunchCheckCrash:" + r11, null, 4, null);
        com.obric.matrix.platform.sdk.ones.safecushion.b.b r0 = i;
        m<Boolean, Long> r4 = r0.b();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L22;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "lastStartSafeModeInfo success", null, 4, null);
        if ((System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).longValue()) > 2000) goto L8;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "lastStartSafeModeInfo success,but time is near,return", null, 4, null);
        return;
    L8:
        m<String, Long> r5 = r0.c();
        m<String, Long> r6 = r0.d();
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "lastStartSafeModeProcess success,lastStartSafeModeProcess:" + ((String) ZeusTransformUtils.preCheckCast(r5.a(), String.class, "com.obric.aiagent.plugin")) + ",lastSafeModeFlag:" + ((String) ZeusTransformUtils.preCheckCast(r6.a(), String.class, "com.obric.aiagent.plugin")), null, 4, null);
        if (r5.a() != null) goto L11;
        a("zhoupeng.725999", "lastStartSafeModeProcess fail");
        b(r11);
        return;
    L11:
        if (r6.a() != null) goto L17;
        long r1 = System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r1 > WsConstants.EXIT_DELAY_TIME) goto L15;
        a("zhoupeng.725999", "wait for start Activity,duration:" + r1);
        return;
    L15:
        a("zhoupeng.725999", "start Activity failed,duration:" + r1);
        b(r11);
        return;
    L17:
        if (r0.f() == false) goto L19;
        a("zhoupeng.725999", "upgradeFinish,openAppStore");
        b(r11);
        return;
    L19:
        if (r11 == true) goto L27;
        a("zhoupeng.725999", "!isLaunchCheckCrash,startSafeMode");
        i();
        return;
    L27:
        return;
    L22:
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "not startSafeModeInfo,startSafeMode now", null, 4, null);
        g = true;
        i();
        c(r11);
    }

    private final void b(boolean r5) {
        if (g == true) goto L6;
        h = true;
        com.obric.matrix.platform.sdk.ones.safecushion.a.f33709a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        c(r5);
        return;
    }

    private final void c(boolean r1) {
        if (r1 == false) goto L5;
        h();
        return;
    }

    private final void h() {
        System.exit(1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "exitProcess: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final boolean i() {
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "startSafeMode", null, 4, null);
        h = true;
        i.a();
        if (g() == true) goto L5;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        Intent r3 = new Intent(r5, CushionActivity.class);     // Catch: Exception -> L8
        r3.addFlags(268435456);     // Catch: Exception -> L8
        ZeusTransformUtils.startActivity(r5, r3, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "openSafeMode: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    L5:
        return j();
    }

    private final boolean j() {
        List<com.obric.matrix.platform.sdk.ones.safecushion.a.a> r1 = com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().a().a(f33731d);     // Catch: Exception -> L16
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "startHeadlessRepair repairCount:" + r1.size() + ",crashCount:" + f33731d, null, 4, null);     // Catch: Exception -> L16
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L16
    L5:
        if (r2.hasNext() == false) goto L11;
        ((com.obric.matrix.platform.sdk.ones.safecushion.a.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.matrix.platform.sdk.ones.safecushion.a.a.class, "com.obric.aiagent.plugin")).run();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "startHeadlessRepair: repair error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L16
        goto L5
    L11:
        com.obric.matrix.platform.sdk.ones.safecushion.b.b r3 = i;     // Catch: Exception -> L16
        String r4 = r3.e();     // Catch: Exception -> L16
        if (r4 != null) goto L14;
        r4 = "repair";
    L14:
        r3.b(r4, "finish");     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "startHeadlessRepair: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
