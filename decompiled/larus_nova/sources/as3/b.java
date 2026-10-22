package as3;

import android.content.ContentValues;
import android.os.Build;
import android.text.TextUtils;
import bs3.l;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.d;
import com.bytedance.apm.util.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public yr3.a f16094c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16095a = null;

        static {
            f16095a = new b();
        }
    }

    public final yr3.a e() {
        if (this.f16094c != null) goto L18;
        if (yr3.a.f568906e == null) goto L7;
    L16:
        this.f16094c = yr3.a.f568906e;
        goto L18
    L7:
        monitor-enter(yr3.a.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (yr3.a.f568906e != null) goto L11;
        yr3.a.f568906e = new yr3.a();     // Catch: Throwable -> L13
    L11:
        monitor-exit(yr3.a.class);     // Catch: Throwable -> L13
    L18:
        return this.f16094c;
    }

    public final JSONObject f() {
        JSONObject r100 = new JSONObject();
        List<ms3.a> r101 = d(true, 0);
        if (k.b(r101) == false) goto L5;
        return r100;
    L5:
        c r102 = new c();
        Object r103 = vr3.b.C;
        Map<String, l> r104 = vr3.b.e.f556835a.f556810g;
        StringBuilder r105 = new StringBuilder();
        Iterator<ms3.a> r106 = r101.iterator();
        String r107 = null;
    L7:
        if (r106.hasNext() == false) goto L22;
        ms3.a r108 = r106.next();
        if (r107 != null) goto L11;
    L12:
        r107 = r108.f515475l;
        r105.append(r107);
    L14:
        if (BatteryTypeInf.BATTERY_GROUND_RECORD.equals(r108.f515467d) == true) goto L16;
        l r109 = (l) ((ConcurrentHashMap) r104).get(r108.f515467d);
        if (r109 == null) goto L7;
        r109.a(r102, r108);
        goto L7
    L16:
        if (r108.f515465b == true) goto L17;
        r102.f16098b += r108.f515470g;
        goto L7
    L17:
        r102.f16097a += r108.f515470g;
        goto L7
    L11:
        if (r107.equals(r108.f515475l) == true) goto L14;
    L22:
        ms3.a r110 = (ms3.a) ListProtector.get(r101, 0);
        r102.f16119w = r110.f515474k;
        r102.f16120x = r110.f515473j;
        r102.f16121y = r105.toString();
        JSONObject r111 = r102.a(true);     // Catch: Exception -> L26
        if (r111 == null) goto L28;
        return r111;
    L28:
        return r100;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public b() {
        this.f16092a = "";
    }

    public final void i() {
        if (d.k() == true) goto L5;
        return;
    L5:
        c r100 = new c();
        List<ms3.a> r101 = d(true, 0);
        if (k.b(r101) == false) goto L8;
        return;
    L8:
        boolean r102 = c(r100, r101);
        long r103 = r100.f16099c;
        if (r103 <= r100.A) goto L11;
        r100.A = r103;
    L11:
        r100.f16099c = 0;
        long r104 = r100.f16100d;
        if (r104 <= r100.B) goto L14;
        r100.B = r104;
    L14:
        r100.f16100d = 0;
        ms3.a r105 = (ms3.a) ListProtector.get(r101, r101.size() - 1);
        long r106 = r105.f515464a;
        long r107 = r105.f515466c;
        if (r102 == true) goto L22;
        if (d.j() == false) goto L19;
        ps3.b.a(new String[]{"report main process data failed, clean data and stop calc data of other process"});
    L19:
        a(r106);
        return;
    L22:
        if (d.j() == false) goto L24;
        ps3.b.a(new String[]{"report main process data over, begin handle other process data"});
    L24:
        List<ms3.a> r108 = d(false, r107);
        HashMap r109 = new HashMap(4);
        Iterator<ms3.a> r110 = r108.iterator();
    L26:
        if (r110.hasNext() == false) goto L49;
        ms3.a r111 = r110.next();
        String r112 = r111.f515473j;
        List r113 = (List) r109.get(r112);
        if (r113 != null) goto L29;
        LinkedList r114 = new LinkedList();
        r114.add(r111);
        r109.put(r112, r114);
        goto L26
    L29:
        r113.add(r111);
        goto L26
    L49:
        Iterator r115 = r109.values().iterator();     // Catch: Exception -> L42
    L32:
        if (r115.hasNext() == false) goto L44;
        c(r100, (List) r115.next());     // Catch: Exception -> L42
        long r116 = r100.f16099c;     // Catch: Exception -> L42
        if (r116 <= r100.A) goto L37;
        r100.A = r116;     // Catch: Exception -> L42
    L37:
        r100.f16099c = 0;     // Catch: Exception -> L42
        long r117 = r100.f16100d;     // Catch: Exception -> L42
        if (r117 <= r100.B) goto L40;
        r100.B = r117;     // Catch: Exception -> L42
    L40:
        r100.f16100d = 0;     // Catch: Exception -> L42
    L44:
        r100.f16104h = r100.C;
        r100.f16101e = r100.F;
        r100.f16102f = r100.D;
        r100.f16103g = r100.E;
        r100.f16097a = r100.A;
        r100.f16105i = r100.G;
        r100.f16106j = r100.H;
        r100.f16107k = r100.I;
        r100.f16108l = r100.f16096J;
        r100.f16113q = r100.K;
        r100.f16110n = r100.N;
        r100.f16111o = r100.L;
        r100.f16112p = r100.M;
        r100.f16098b = r100.B;
        r100.f16114r = r100.O;
        r100.f16115s = r100.P;
        r100.f16116t = r100.Q;
        r100.f16117u = r100.R;
        r100.f16119w = false;
        r100.f16120x = "all_process";
        r100.f16118v = false;
        r100.f16122z = "";
        r100.b(false);     // Catch: Exception -> L48
    L46:
        a(r106);
        return;
    L42:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "reportLastTimeBattery");
        goto L44
    }

    public static void j(ms3.a r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        r101.put(NewBroadcastMonitor.CAPTURE.FRONT, r100.f515465b);
        r101.put("time", r100.f515466c);
        r101.put("type", r100.f515467d);
        r101.put("scene", r100.f515469f);
        r101.put("processName", r100.f515473j);
        if (TextUtils.equals(r100.getType(), BatteryTypeInf.BATTERY_CPU_ACTIVE) == false) goto L6;
        r101.put("accumulation", (r100.f515470g * 1000) / com.bytedance.apm.util.b.f());
    L9:
        r101.toString();
        return;
    L6:
        if (TextUtils.equals(r100.getType(), "traffic") == false) goto L8;
        r101.put("accumulation", r100.f515470g / 1024);
        goto L9
    L8:
        r101.put("accumulation", r100.f515470g);
        goto L9
    }

    public final void a(long r100) {
        yr3.a r101 = e();     // Catch: Exception -> L10
        monitor-enter(r101);     // Catch: Exception -> L10
        ContentValues r102 = new ContentValues();     // Catch: Throwable -> L7
        r102.put("delete_flag", 1);     // Catch: Throwable -> L7
        r101.update(r102, "_id <= ? ", new String[]{String.valueOf(r100)});     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Exception -> L10
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "cleanBatteryLog");
    }

    public final void g(ms3.a r100) {
        if (TextUtils.isEmpty(this.f16093b) == false) goto L5;
        this.f16093b = String.valueOf(System.currentTimeMillis());
    L5:
        r100.f515474k = d.k();
        r100.f515473j = d.c();
        r100.f515475l = this.f16093b;
        if (r100.f515465b == false) goto L8;
        String r101 = this.f16092a;
    L10:
        if (TextUtils.isEmpty(r100.f515469f) == true) goto L13;
        r101 = r100.f515469f + "#" + r101;
    L13:
        r100.f515469f = r101;
        if (Build.VERSION.SDK_INT < 34) goto L28;
        if (r100.f515465b == true) goto L28;
        r100.f515468e = false;
    L28:
    L25:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "saveBatteryLog");
        return;
    L21:
        if (d.j() == false) goto L23;
        ps3.b.a(new String[]{"saveBatteryLog into db: " + r100});     // Catch: Exception -> L25
    L23:
        j(r100);     // Catch: Exception -> L25
        e().i(r100);     // Catch: Exception -> L25
        return;
    L8:
        r101 = "background";
        goto L10
    }

    public static boolean b(c r100, List r101) {
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L25;
        ms3.a r105 = (ms3.a) r104.next();
        if (r105.f515468e == true) goto L7;
        r103.add(r105);
        goto L4
    L7:
        r102.add(r105);
        goto L4
    L25:
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "divideByChargingStatusAndReport");
        return false;
    L11:
        if (r102.isEmpty() == false) goto L13;
    L15:
        boolean r106 = true;
    L17:
        if (r103.isEmpty() == true) goto L33;
        if (h(r100, r103) == true) goto L33;
        return false;
    L33:
        return r106;
    L13:
        if (h(r100, r102) == true) goto L15;
        r106 = false;
        goto L17
    }

    public static boolean c(c r100, List r101) {
        HashMap r102 = new HashMap(4);
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L20;
        ms3.a r104 = (ms3.a) r103.next();
        String r105 = r104.f515469f;
        List r106 = (List) r102.get(r105);
        if (r106 != null) goto L7;
        LinkedList r107 = new LinkedList();
        r107.add(r104);
        r102.put(r105, r107);
        goto L4
    L7:
        r106.add(r104);
        goto L4
    L20:
        Iterator r108 = r102.values().iterator();     // Catch: Exception -> L17
        boolean r109 = true;
    L12:
        if (r108.hasNext() == false) goto L33;
        if (b(r100, (List) r108.next()) == true) goto L12;
        r109 = false;
        goto L12
    L33:
        return r109;
    L17:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "divideBySceneAndReport");
        return false;
    }

    public static boolean h(c r100, List r110) throws Exception {
        Object r101 = vr3.b.C;
        Map<String, l> r102 = vr3.b.e.f556835a.f556810g;
        StringBuilder r103 = new StringBuilder();
        ArrayList r104 = (ArrayList) r110;
        Iterator r105 = r104.iterator();
        String r106 = null;
    L4:
        if (r105.hasNext() == false) goto L19;
        ms3.a r107 = (ms3.a) r105.next();
        if (r106 != null) goto L8;
    L9:
        r106 = r107.f515475l;
        r103.append(r106);
    L11:
        if (BatteryTypeInf.BATTERY_GROUND_RECORD.equals(r107.f515467d) == true) goto L13;
        l r108 = (l) ((ConcurrentHashMap) r102).get(r107.f515467d);
        if (r108 == null) goto L4;
        r108.a(r100, r107);
        goto L4
    L13:
        if (r107.f515465b == true) goto L14;
        r100.f16098b += r107.f515470g;
        goto L4
    L14:
        r100.f16097a += r107.f515470g;
        goto L4
    L8:
        if (r106.equals(r107.f515475l) == true) goto L11;
    L19:
        ms3.a r111 = (ms3.a) ListProtector.get(r110, 0);
        r100.f16119w = r111.f515474k;
        r100.f16120x = r111.f515473j;
        r100.f16121y = r103.toString();
        r100.f16122z = r111.f515469f;
        r100.f16118v = r111.f515468e;
        r104.size();
        return r100.b(true);
    }

    public final List<ms3.a> d(boolean r100, long r101) {
        yr3.a r102 = e();     // Catch: Exception -> L12
        monitor-enter(r102);     // Catch: Exception -> L12
        if (r100 == false) goto L6;
        List<ms3.a> r103 = r102.query("main_process = 1 AND delete_flag = 0", null, DBDefinition.ID, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Exception -> L12
        return r103;
        goto L13
    L6:
        r103 = r102.query("main_process = 0 AND delete_flag = 0 AND timestamp <= ? ", new String[]{String.valueOf(r101)}, DBDefinition.ID, r102);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;     // Catch: Exception -> L12
    L13:
        return Collections.emptyList();
    }
}
