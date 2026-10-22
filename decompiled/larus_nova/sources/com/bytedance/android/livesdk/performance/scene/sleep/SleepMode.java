package com.bytedance.android.livesdk.performance.scene.sleep;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.android.livesdk.config.t81;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import df6.g;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class SleepMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f154768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PthreadHandlerThreadV2 f154769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f154770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f154771d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SleepModeBroadcastReceiver f154772e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f154773f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f154774g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f154775h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f154776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f154777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f154778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f154779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Date f154780m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Date f154781n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static t81 f154782o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final SleepMode f154783p = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/performance/scene/sleep/SleepMode$SleepModeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SleepModeBroadcastReceiver extends BroadcastReceiver {
        public SleepModeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 == null) goto L28;
            boolean r102 = SleepMode.f154768a;
            String r103 = r101.getAction();
            if (r103 != null) goto L7;
            return;
        L7:
            if ("android.intent.action.SCREEN_OFF".equals(r103) == false) goto L10;
            ALogger.d("LiveSleep_Mode", "receiver:screen off");
            return;
        L10:
            if ("android.intent.action.SCREEN_ON".equals(r103) == false) goto L13;
            b r104 = SleepMode.f154771d;
            r104.f154794i = System.currentTimeMillis();
            SleepMode.f();
            ALogger.d("LiveSleep_Mode", "receiver:screen on, set screen on time:");
            return;
        L13:
            if ("android.intent.action.USER_PRESENT".equals(r103) == false) goto L16;
            ALogger.d("LiveSleep_Mode", "receiver:screen unlock");
            return;
        L16:
            if ("android.intent.action.TIME_SET".equals(r103) == false) goto L18;
        L26:
            SleepMode.a();
            SleepMode.f();
            ALogger.d("LiveSleep_Mode", "receiver:time change");
            return;
        L18:
            if ("android.intent.action.TIMEZONE_CHANGED".equals(r103) == true) goto L26;
            if ("android.intent.action.DATE_CHANGED".equals(r103) == false) goto L24;
            SleepMode.a();
            SleepMode.f();
            ALogger.d("LiveSleep_Mode", "receiver:date change");
            return;
        L24:
            if ("com.ss.android.ugc.aweme.action.sleep".equals(r103) == false) goto L33;
            ALogger.d("LiveSleep_Mode", "receiver:test");
            SleepMode.f();
            return;
        L33:
            return;
        }
    }

    public SleepMode() {
    }

    static {
        f154783p = new SleepMode();
        f154771d = new b();
        f154772e = new SleepModeBroadcastReceiver();
        f154773f = 86400000;
        f154774g = 3600000;
        f154775h = 3000;
        f154777j = -1;
        f154778k = -1;
        f154779l = "";
    }

    public static boolean d() {
        if (f154776i == true) goto L33;
        long r100 = System.currentTimeMillis();
        int r101 = b(r100);
        if (r101 != 0) goto L19;
        f154776i = true;
        ALogger.i("LiveSleep_Mode", "now in sleep time range： " + f154779l);
        b r102 = f154771d;
        ALogger.d(r102.f154786a, "enterSleepModeRange");
        r102.f154790e = true;
        a r103 = a.f154785a;
        Map<String, String> r104 = r102.b();
        r103.getClass();
        a.a("action_enter_sleep_range", r104);
        r102.a();
        c r105 = f154770c;
        if (r105 != null) goto L9;
    L17:
        return true;
    L9:
        if (r105.hasMessages(1) == false) goto L12;
        r105.removeMessages(1);
    L12:
        if ((f154778k - r100) < 0) goto L17;
        if (r105.hasMessages(2) == false) goto L16;
        r105.removeMessages(2);
    L16:
        r105.sendEmptyMessageDelayed(2, f154778k - r100);
        ALogger.d("LiveSleep_Mode", "in sleep time range, set new check end delay time:" + io2.b.b(f154778k - r100));
        goto L17
    L19:
        if (r101 == (-2)) goto L34;
        if (r101 != 1) goto L23;
        a();
        ALogger.d("LiveSleep_Mode", "try start，now beyond sleep time range，adjust");
    L23:
        if ((f154777j - r100) < 0) goto L35;
        c r106 = f154770c;
        if (r106 != null) goto L27;
    L30:
        ALogger.d("LiveSleep_Mode", "not in sleep time range, set new check start delay time:" + io2.b.b(f154777j - r100));
        return false;
    L27:
        if (r106.hasMessages(1) == false) goto L29;
        r106.removeMessages(1);
    L29:
        r106.sendEmptyMessageDelayed(1, f154777j - r100);
        goto L30
    L35:
        return false;
    L34:
        return false;
    L33:
        return false;
    }

    public static boolean e() {
        if (f154776i == false) goto L36;
        long r100 = System.currentTimeMillis();
        int r101 = b(r100);
        if (r101 != 1) goto L7;
    L21:
        f154776i = false;
        ALogger.i("LiveSleep_Mode", "now out sleep time range");
        b r102 = f154771d;
        ALogger.d(r102.f154786a, "exitSleepModeRange");
        r102.f154790e = false;
        a r103 = a.f154785a;
        Map<String, String> r104 = r102.b();
        r103.getClass();
        a.a("action_exit_sleep_range", r104);
        r102.a();
        a();
        c r105 = f154770c;
        if (r105 == null) goto L27;
        if (r105.hasMessages(2) == false) goto L27;
        r105.removeMessages(2);
    L27:
        if ((f154777j - r100) < 0) goto L35;
        c r106 = f154770c;
        if (r106 != null) goto L31;
    L34:
        ALogger.d("LiveSleep_Mode", "not in sleep time range, set new check start delay time:" + (f154777j - r100));
        goto L35
    L31:
        if (r106.hasMessages(1) == false) goto L33;
        r106.removeMessages(1);
    L33:
        r106.sendEmptyMessageDelayed(1, f154777j - r100);
    L35:
        return true;
    L7:
        if (r101 == (-1)) goto L21;
        if (r101 == (-2)) goto L21;
        if ((f154778k - r100) < 0) goto L20;
        c r107 = f154770c;
        if (r107 != null) goto L16;
    L19:
        ALogger.d("LiveSleep_Mode", "in sleep time range, set new check end delay time:" + (f154778k - r100));
        goto L20
    L16:
        if (r107.hasMessages(2) == false) goto L18;
        r107.removeMessages(2);
    L18:
        r107.sendEmptyMessageDelayed(2, f154778k - r100);
    L20:
        return false;
    L36:
        return false;
    }

    public static void f() {
        ALogger.d("LiveSleep_Mode", "trySleepMode");
        c r100 = f154770c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.hasMessages(3) == false) goto L7;
        r100.removeMessages(3);
    L7:
        r100.sendEmptyMessageDelayed(3, f154775h);
    }

    public static void a() {
        Map<String, t81> r100 = SleepModeTimePeriodManager.a().g();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        String r102 = "22:00:00-07:00:00";
        if (r101 == false) goto L17;
        t81 r103 = SleepModeTimePeriodManager.a().a();
        if (r103 == null) goto L44;
        String r104 = r103.b();
        if (r104 == null) goto L44;
    L16:
        r102 = r104;
    L44:
        String r105 = r102;
    L45:
        f154779l = r105;
        int r106 = io2.b.f495193a;
        Intrinsics.checkNotNullParameter(r105, "curPeriod");
        List r107 = StringsKt.split$default(r105, new String[]{"-"}, false, 0, 6, null);
        Pair r108 = new Pair(io2.b.c((String) ListProtector.get(r107, 0)), io2.b.c((String) ListProtector.get(r107, 1)));
        f154780m = (Date) r108.getFirst();
        f154781n = (Date) r108.getSecond();
        String r109 = f154779l;
        Intrinsics.checkNotNullParameter(r109, "timePeriod");
        Map<String, t81> r110 = SleepModeTimePeriodManager.a().g();
        if (r110 == null) goto L49;
        t81 r111 = r110.get(r109);
        if (r111 == null) goto L49;
    L52:
        f154782o = r111;
        b r112 = f154771d;
        r112.f154791f = r111.c();
        t81 r113 = f154782o;
        if (r113 == null) goto L55;
        float r114 = r113.a();
    L56:
        r112.f154792g = (long) (r114 * f154774g);
        ALogger.i("LiveSleep_Mode", "adjustStartAndEndTime  =======当前时间段====================:" + f154779l);
        ALogger.i("LiveSleep_Mode", "adjustStartAndEndTime  =======当前时间段-熄屏次数限制====================:" + r112.f154791f);
        ALogger.i("LiveSleep_Mode", "adjustStartAndEndTime  =======当前时间段-无交互时间限制====================:" + r112.f154792g);
        Date r115 = f154780m;
        if (r115 == null) goto L59;
        long r116 = io2.b.a(r115);
    L60:
        f154777j = r116;
        Date r117 = f154781n;
        if (r117 == null) goto L63;
        long r118 = io2.b.a(r117);
    L64:
        f154778k = r118;
        if (f154777j != (-1)) goto L67;
    L77:
        StringBuilder r119 = new StringBuilder("sleep mode init config, startTime:");
        r119.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(f154777j)));
        r119.append(", endTime:");
        r119.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(f154778k)));
        r119.append(", triggerDuration:");
        r119.append(r112.f154792g);
        r119.append(", limitCnt:");
        r119.append(r112.f154791f);
        ALogger.i("LiveSleep_Mode", r119.toString());
        return;
    L67:
        if (r118 == (-1)) goto L77;
        long r120 = System.currentTimeMillis();
        long r121 = f154777j;
        long r122 = f154778k;
        if (r121 < r122) goto L75;
        if (r120 >= r122) goto L73;
        f154777j = r121 - f154773f;
        ALogger.i("LiveSleep_Mode", "sleep mode adapt startTime ,minus a day");
        goto L77
    L73:
        f154778k = r122 + f154773f;
        ALogger.i("LiveSleep_Mode", "sleep mode adapt endTime ,add a day");
        goto L77
    L75:
        if (r120 <= r122) goto L77;
        long r123 = f154773f;
        f154777j = r121 + r123;
        f154778k = r122 + r123;
        ALogger.i("LiveSleep_Mode", "sleep mode adapt startTime endTime when now beyond endTime");
        goto L77
    L63:
        r118 = -1;
        goto L64
    L59:
        r116 = -1;
        goto L60
    L55:
        r114 = 1.5f;
    L49:
        r111 = SleepModeTimePeriodManager.a().a();
        if (r111 != null) goto L52;
        r111 = new t81(0);
        goto L52
    L17:
        Iterator<T> r124 = r100.keySet().iterator();
    L19:
        if (r124.hasNext() == false) goto L40;
        String r125 = (String) r124.next();
        List r126 = StringsKt.split$default(r125, new String[]{"-"}, false, 0, 6, null);
        if (r126.size() != 2) goto L19;
        String r127 = (String) ListProtector.get(r126, 0);
        String r128 = (String) ListProtector.get(r126, 1);
        int r129 = io2.b.f495193a;
        Intrinsics.checkNotNullParameter(r127, DyPayConstant.KEY_START_TIME);
        Intrinsics.checkNotNullParameter(r128, "endTime");
        Triple r130 = io2.b.d(r127);
        int r131 = ((Number) r130.component1()).intValue();
        int r132 = ((Number) r130.component2()).intValue();
        int r133 = ((Number) r130.component3()).intValue();
        Triple r134 = io2.b.d(r128);
        int r135 = ((Number) r134.component1()).intValue();
        int r136 = ((Number) r134.component2()).intValue();
        int r137 = ((Number) r134.component3()).intValue();
        Calendar r138 = Calendar.getInstance();
        int r139 = ((r138.get(11) * AnnouncementViewModel.HOUR_DURATION) + (r138.get(12) * 60)) + r138.get(13);
        int r140 = ((r131 * AnnouncementViewModel.HOUR_DURATION) + (r132 * 60)) + r133;
        int r141 = ((r135 * AnnouncementViewModel.HOUR_DURATION) + (r136 * 60)) + r137;
        if (r141 > r140) goto L25;
        r141 = r141 + 86400;
    L25:
        if (r141 <= 86400) goto L33;
        if (r140 > r139) goto L28;
        if (r141 <= r139) goto L28;
    L36:
        boolean r142 = true;
    L38:
        if (r142 == false) goto L19;
        ALogger.e("POWER_SleepMode", "======getCurTimePeriod from AB: " + r125);
        r105 = r125;
    L28:
        int r143 = r141 - 86400;
        if (r139 < 0) goto L37;
        if (r143 > r139) goto L36;
    L37:
        r142 = false;
        goto L38
    L33:
        if (r140 > r139) goto L37;
        if (r141 <= r139) goto L37;
    L40:
        t81 r144 = SleepModeTimePeriodManager.a().a();
        if (r144 == null) goto L44;
        r104 = r144.b();
        if (r104 != null) goto L16;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static int b(long r100) {
        long r101 = f154777j;
        if (r101 == (-1)) goto L20;
        long r102 = f154778k;
        if (r102 != (-1)) goto L7;
        return -2;
    L7:
        if (r101 <= r102) goto L10;
        return -2;
    L10:
        if (r100 >= r101) goto L12;
    L15:
        if (r100 >= r101) goto L18;
        return -1;
    L18:
        return 1;
    L12:
        if (r100 > r102) goto L15;
        return 0;
    L20:
        return -2;
    }

    private final void registerReceiver(Handler r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        SleepModeBroadcastReceiver r100 = f154772e;
        if (r100 == null) goto L61;
        IntentFilter r101 = new IntentFilter();
        r101.addAction("android.intent.action.SCREEN_OFF");
        r101.addAction("android.intent.action.SCREEN_ON");
        r101.addAction("android.intent.action.USER_PRESENT");
        r101.addAction("android.intent.action.TIME_SET");
        r101.addAction("android.intent.action.DATE_CHANGED");
        Lazy r102 = SleepModeTimePeriodManager.f154784a;
        if (v.a() == true) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        r101.addAction("com.ss.android.ugc.aweme.action.sleep");
    L14:
        Context r111 = g.getContext();
        if (r111 != null) goto L17;
        return;
    L17:
        if (Build.VERSION.SDK_INT < 34) goto L40;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L63;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L63:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r100, r101, null, r110, 4);
    L59:
        ALogger.d("LiveSleep_Mode", "register receiver");
        return;
    L38:
        throw e;
    L22:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L24;
    L32:
        r111.registerReceiver(r100, r101, null, r110, 4);     // Catch: Exception -> L34
    L62:
        goto L59
    L24:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L32;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r101, 4, null, r110, 5, r111).result;     // Catch: Exception -> L34
        if (r104 == 1) goto L31;
        if (r104 == 2) goto L30;
        if (r104 == 3) goto L62;
        r111.registerReceiver(r100, r101, null, r110, 4);     // Catch: Exception -> L34
        goto L62
    L30:
        new Intent();     // Catch: Exception -> L34
        goto L62
    L31:
        r111.registerReceiver(r100, r101, null, r110, 4);     // Catch: Exception -> L34
        goto L62
    L40:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L66;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L66:
    L55:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L60;
        ReceiverRegisterCrashOptimizer.registerReceiver(r100, r101, null, r110);
        goto L59
    L60:
        throw e;
    L43:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L45;
    L53:
        r111.registerReceiver(r100, r101, null, r110);     // Catch: Exception -> L55
    L65:
        goto L59
    L45:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L53;
        int r105 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r101, 0, null, r110, 4, r111).result;     // Catch: Exception -> L55
        if (r105 == 1) goto L52;
        if (r105 == 2) goto L51;
        if (r105 == 3) goto L65;
        r111.registerReceiver(r100, r101, null, r110);     // Catch: Exception -> L55
        goto L65
    L51:
        new Intent();     // Catch: Exception -> L55
        goto L65
    L52:
        r111.registerReceiver(r100, r101, null, r110);     // Catch: Exception -> L55
        goto L65
    L9:
        if (SleepModeTimePeriodManager.a().c() == false) goto L11;
        r103 = true;
        goto L12
    }

    public final void c(Activity r100) {
        if (SleepModeTimePeriodManager.a().b() == true) goto L6;
        return;
    L6:
        if (f154768a == false) goto L8;
        return;
    L8:
        f154768a = true;
        a();
        if (f154777j != (-1)) goto L11;
        return;
    L11:
        if (f154778k == (-1)) goto L40;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("live_sleep_handler");
        f154769b = r101;
        ThreadMethodProxy.start(r101);
        PthreadHandlerThreadV2 r102 = f154769b;
        if (r102 == null) goto L18;
        Looper r103 = r102.getLooper();
        if (r103 == null) goto L18;
        f154770c = new c(r103, f154771d);
    L18:
        c r104 = f154770c;
        if (r104 == null) goto L21;
        f154783p.registerReceiver(r104);
    L21:
        b r105 = f154771d;
        if (r105.f154795j == true) goto L31;
        r105.f154795j = true;
        r105.f154793h = 0;
        if (SleepModeTimePeriodManager.a().f() == false) goto L28;
        r105.f154797l.f486213c = r100;
    L28:
        if (SleepModeTimePeriodManager.a().e() == false) goto L30;
        r105.f154796k.getClass();
    L30:
        ALogger.d(r105.f154786a, "initAction:" + r105.f154795j);
    L31:
        r105.f154793h = System.currentTimeMillis();
        if (i60.b.f488348a.booleanValue() == false) goto L37;
        CopyOnWriteArrayList r106 = (CopyOnWriteArrayList) i60.b.f488349b;
        if (r106.contains(this) == true) goto L37;
        r106.add(this);
        ALogger.d("LiveActivityTouchListener", "add touch listener:" + this);
    L37:
        f();
        ALogger.i("LiveSleep_Mode", "initSleepMode");
        return;
    }
}
