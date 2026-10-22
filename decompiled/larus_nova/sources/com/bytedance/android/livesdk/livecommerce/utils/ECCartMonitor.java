package com.bytedance.android.livesdk.livecommerce.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes10.dex */
public final class ECCartMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f153028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f153029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, List<LogRule>> f153030c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static v0 f153031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f153032e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Handler f153033f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f153034g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LogRuleInsertDelay f153035a;

        public a(LogRuleInsertDelay r100) {
            this.f153035a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r100 = ECCartMonitor.f153028a;     // Catch: Throwable -> L4
            ECCartMonitor.b(this.f153035a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f153030c = new LinkedHashMap();
        f153032e = new LinkedHashMap();
        f153033f = new Handler(Looper.getMainLooper());
    }

    @JvmStatic
    public static final void f() {
        if (f153031d != null) goto L5;
        return;
    L5:
        Handler r100 = f153033f;
        LogRule r101 = null;
        r100.removeCallbacksAndMessages(null);
        List r102 = (List) ((LinkedHashMap) f153030c).get(LogRuleInsertDelay.RULE_STR_CART_INSERT_DELAY);
        if (r102 == null) goto L8;
        LogRule r103 = (LogRule) CollectionsKt.firstOrNull(r102);
    L10:
        if ((r103 instanceof LogRuleInsertDelay) == false) goto L13;
        r101 = r103;
    L13:
        LogRuleInsertDelay r104 = (LogRuleInsertDelay) r101;
        if (r104 == null) goto L17;
        r100.postDelayed(new a(r104), ((long) r104.getDelaySeconds()) * 1000);
        return;
    L17:
        return;
    L8:
        r103 = null;
        goto L10
    }

    public static void a(a1 r100) {
        v0 r101 = f153031d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f153119a != null) goto L7;
        r101.f153119a = new LinkedList();
    L7:
        LinkedList<a1> r102 = r101.f153119a;
        if (r102 == null) goto L52;
        monitor-enter(r102);
    L41:
        th = move-exception;
        throw th;
    L11:
        if (c(r100) == false) goto L13;
    L14:
        int r103 = r102.size() - 1;     // Catch: Throwable -> L41
    L15:
        if (r103 < 0) goto L38;
        a1 r104 = r102.get(r103);     // Catch: Throwable -> L41
        a1 r105 = r104;     // Catch: Throwable -> L41
        if (c(r105) == false) goto L19;
    L22:
        boolean r106 = true;
    L23:
        if (r106 == true) goto L26;
        r104 = null;
    L26:
        a1 r107 = r104;     // Catch: Throwable -> L41
        if (r107 == null) goto L38;
        if (c(r100) == false) goto L33;
        if (c(r107) == false) goto L33;
    L36:
        r102.remove(r103);     // Catch: Throwable -> L41
    L37:
        r103 = r103 - 1;     // Catch: Throwable -> L41
    L33:
        if (d(r100) == false) goto L37;
        if (d(r107) == false) goto L37;
    L19:
        if (d(r105) == true) goto L22;
        r106 = false;
    L38:
        r102.add(r100);     // Catch: Throwable -> L41
        monitor-exit(r102);
        return;
    L13:
        if (d(r100) == false) goto L38;
    }

    public static void b(LogRule r100) {
        String r101 = r100.getRequire();
        if (r101 != null) goto L6;
        return;
    L6:
        switch(r101.hashCode()) {
            case -1317299234: goto L15;
            case -592211387: goto L14;
            case 140325285: goto L12;
            case 2109773534: goto L9;
            default: goto L23;
        };
    L14:
        r101.equals(LogRule.REQUIRE_NO_AUTHORITY);
        return;
    L15:
        r101.equals(LogRule.REQUIRE_HAS_AUTHORITY);
        return;
    L23:
        return;
    L9:
        if (r101.equals(LogRule.REQUIRE_NO_CART) == false) goto L17;
        boolean r102 = p.f153104a;
        return;
    L17:
        return;
    L12:
        if (r101.equals(LogRule.REQUIRE_HAS_CART) == false) goto L19;
        boolean r103 = p.f153104a;
        return;
    }

    public static boolean c(a1 r100) {
        if ((r100 instanceof r0) == true) goto L5;
        return false;
    L5:
        if (((r0) r100).f153113c != 10) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public static boolean d(a1 r100) {
        if ((r100 instanceof z0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((z0) r100).f153128c == false) goto L7;
        return true;
    }

    public static void e(String r100, String r101) {
        if (f153028a == true) goto L5;
        return;
    L5:
        if (f153031d != null) goto L9;
        final v0 r102 = new v0();
        int r103 = RoomContextController.f151593h;
        final RoomContextController r104 = RoomContextController.a.b(r100, r101);
        UtilityKotlinExtentionsKt.i(new ECCartMonitor$onEnterRoom$1$1(r102, r104));
        f153031d = r102;
        ((LinkedHashMap) f153032e).clear();
        return;
    }

    public static void g(int r100, long r101) {
        if (r100 != 10) goto L5;
    L9:
        a(new r0(r100, r101));
    L11:
        if (f153031d != null) goto L14;
        return;
    L14:
        if (f153034g == false) goto L39;
        List r102 = (List) ((LinkedHashMap) f153030c).get(LogRuleRevMsg.RULE_STR_REV_MSG);
        if (r102 == null) goto L30;
        Iterator r103 = r102.iterator();
    L20:
        if (r103.hasNext() == false) goto L40;
        LogRule r104 = (LogRule) r103.next();
        if ((r104 instanceof LogRuleRevMsg) == true) goto L24;
        LogRule r105 = null;
    L25:
        LogRuleRevMsg r106 = (LogRuleRevMsg) r105;
        if (r106 == null) goto L20;
        if (r106.isHandleMsgType(r100) != true) goto L20;
        b(r104);
        goto L20
    L24:
        r105 = r104;
        goto L25
    L40:
        return;
    L30:
        return;
    L39:
        return;
    L5:
        if (r100 == 11) goto L9;
        if (r100 == 13) goto L9;
        if (r100 != 14) goto L11;
        goto L9
    }
}
