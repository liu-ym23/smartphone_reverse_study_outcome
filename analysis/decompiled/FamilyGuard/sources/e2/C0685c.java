package e2;

import android.app.KeyguardManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.j;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import e2.C0683a;
import f2.C0697b;
import f2.C0702g;
import f2.C0711p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: e2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0685c {

    /* renamed from: a, reason: collision with root package name */
    private final UsageStatsManager f16684a;

    /* renamed from: c, reason: collision with root package name */
    private long f16686c;

    /* renamed from: d, reason: collision with root package name */
    private Context f16687d;

    /* renamed from: g, reason: collision with root package name */
    private long f16690g;

    /* renamed from: h, reason: collision with root package name */
    private long f16691h;

    /* renamed from: i, reason: collision with root package name */
    private long f16692i;

    /* renamed from: j, reason: collision with root package name */
    private long f16693j;

    /* renamed from: n, reason: collision with root package name */
    private String f16697n;

    /* renamed from: o, reason: collision with root package name */
    private C0683a f16698o;

    /* renamed from: p, reason: collision with root package name */
    private final KeyguardManager f16699p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f16700q;

    /* renamed from: b, reason: collision with root package name */
    private long f16685b = 5000;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Long> f16688e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private boolean f16689f = true;

    /* renamed from: k, reason: collision with root package name */
    private Map<String, a> f16694k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private Map<String, Long> f16695l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private List<C0683a> f16696m = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    private final Set<String> f16701r = new HashSet();

    /* renamed from: e2.c$a */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        String f16702a;

        /* renamed from: b, reason: collision with root package name */
        String f16703b;

        /* renamed from: c, reason: collision with root package name */
        long f16704c;

        private a() {
        }
    }

    public C0685c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f16687d = applicationContext;
        this.f16684a = (UsageStatsManager) applicationContext.getSystemService("usagestats");
        this.f16699p = (KeyguardManager) this.f16687d.getSystemService("keyguard");
    }

    private long f() {
        return C0711p.x();
    }

    private static String h(UsageEvents.Event event) {
        if (event == null) {
            return null;
        }
        return event.getPackageName() + "#" + event.getClassName();
    }

    private long i() {
        return C0711p.y();
    }

    private static long j(Map<String, Long> map, String str) {
        if (map == null) {
            C0702g.O("UsageStatsAnalyzer", "map = null");
            return 0L;
        }
        if (str == null) {
            C0702g.O("UsageStatsAnalyzer", "key = null");
            return 0L;
        }
        if (!map.containsKey(str)) {
            C0702g.O("UsageStatsAnalyzer", "map not containsKey");
            return 0L;
        }
        Long l5 = map.get(str);
        if (l5 != null) {
            return l5.longValue();
        }
        C0702g.O("UsageStatsAnalyzer", "getKey == null");
        return 0L;
    }

    private void k(UsageEvents.Event event) {
        String packageName = event.getPackageName();
        if (TextUtils.equals(packageName, this.f16697n) || TextUtils.isEmpty(this.f16697n)) {
            this.f16698o = new C0683a(event.getPackageName(), event.getTimeStamp(), C0683a.b.STOP);
            this.f16697n = packageName;
        }
    }

    private void l(UsageEvents.Event event) {
        if (TextUtils.equals(event.getPackageName(), this.f16697n)) {
            return;
        }
        C0683a c0683a = this.f16698o;
        if (c0683a == null || !TextUtils.equals(c0683a.f16648a, this.f16697n)) {
            this.f16698o = new C0683a(this.f16697n, event.getTimeStamp() - 5, C0683a.b.STOP);
        }
        this.f16696m.add(this.f16698o);
        C0683a c0683a2 = new C0683a(event.getPackageName(), event.getTimeStamp(), C0683a.b.START);
        this.f16696m.add(c0683a2);
        this.f16697n = c0683a2.f16648a;
    }

    private boolean m(String str) {
        return this.f16700q && o(str);
    }

    private static boolean n(String str) {
        return PackageUtils.u(str);
    }

    private boolean o(String str) {
        return str.contains("com.youdao.hardware.panda.parentcontrol.ParentControlLockActivity") || str.contains("com.youdao.hardware.call.activity.CallActivity");
    }

    private void p() {
        Iterator<String> it = this.f16694k.keySet().iterator();
        while (it.hasNext()) {
            a aVar = this.f16694k.get(it.next());
            if (aVar != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() - Math.max(aVar.f16704c, j(this.f16695l, aVar.f16702a));
                if (m(aVar.f16703b)) {
                    this.f16692i += jCurrentTimeMillis;
                }
                this.f16688e.put(aVar.f16702a, Long.valueOf(j(this.f16688e, aVar.f16702a) + jCurrentTimeMillis));
            }
        }
        this.f16696m.add(new C0683a(this.f16687d.getPackageName(), System.currentTimeMillis(), C0683a.b.QUERY_END));
    }

    private void q() {
        C0702g.b("UsageStatsAnalyzer", "onAnalyzeStart");
        this.f16694k.clear();
        this.f16688e.clear();
        this.f16695l.clear();
        this.f16696m.clear();
        this.f16689f = true;
        this.f16697n = null;
        this.f16700q = false;
        this.f16690g = -1L;
        this.f16691h = -1L;
        r();
    }

    private void r() {
        this.f16696m.add(new C0683a(this.f16687d.getPackageName(), C0711p.y(), C0683a.b.DAY_START));
    }

    private void s(UsageEvents.Event event) {
        k(event);
    }

    private void t(UsageEvents.Event event) {
        String packageName = event.getPackageName();
        String strH = h(event);
        if (n(packageName)) {
            this.f16689f = false;
            Iterator<String> it = this.f16694k.keySet().iterator();
            while (it.hasNext()) {
                a aVar = this.f16694k.get(it.next());
                if (aVar != null) {
                    long timeStamp = event.getTimeStamp() - Math.max(j(this.f16695l, packageName), aVar.f16704c);
                    if (this.f16688e.containsKey(packageName)) {
                        timeStamp += j(this.f16688e, aVar.f16702a);
                    }
                    this.f16695l.put(aVar.f16702a, Long.valueOf(event.getTimeStamp()));
                    this.f16688e.put(aVar.f16702a, Long.valueOf(timeStamp));
                }
            }
            this.f16694k.clear();
            a aVarX = x(event);
            this.f16694k.put(aVarX.f16703b, aVarX);
        } else if (this.f16694k.containsKey(strH)) {
            a aVar2 = this.f16694k.get(strH);
            if (aVar2 == null) {
                return;
            }
            this.f16694k.remove(strH);
            long j5 = j(this.f16695l, packageName);
            long timeStamp2 = event.getTimeStamp() - Math.max(aVar2.f16704c, j5);
            if (this.f16688e.containsKey(packageName)) {
                timeStamp2 += j(this.f16688e, packageName);
            }
            this.f16688e.put(packageName, Long.valueOf(timeStamp2));
            a aVarX2 = x(event);
            this.f16694k.put(aVarX2.f16703b, aVarX2);
            this.f16695l.put(packageName, Long.valueOf(event.getTimeStamp()));
        } else {
            this.f16694k.put(strH, x(event));
            this.f16695l.remove(packageName);
        }
        l(event);
    }

    private void u(UsageEvents.Event event) {
        long j5;
        String packageName = event.getPackageName();
        String strH = h(event);
        long timeStamp = event.getTimeStamp();
        if (this.f16694k.containsKey(strH)) {
            a aVar = this.f16694k.get(strH);
            if (aVar == null) {
                return;
            }
            long jMax = timeStamp - Math.max(aVar.f16704c, j(this.f16695l, packageName));
            if (this.f16688e.containsKey(packageName)) {
                j5 = j(this.f16688e, packageName) + jMax;
                if (m(strH)) {
                    this.f16692i += jMax;
                }
            } else {
                j5 = 0;
            }
            this.f16688e.put(packageName, Long.valueOf(j5));
            this.f16694k.remove(strH);
            this.f16695l.put(packageName, Long.valueOf(timeStamp));
            return;
        }
        if (this.f16689f) {
            if (j.n(this.f16687d, packageName, timeStamp, i())) {
                Log.w("UsageStatsAnalyzer", "skip unattended overnight stop package=" + packageName + " fromMidnight=" + C0711p.t(timeStamp - i()));
                return;
            }
            long timeStamp2 = event.getTimeStamp() - i();
            if (m(strH)) {
                Log.d("UsageStatsAnalyzer", "onStopEvent isInLock mUsageTime = " + this.f16692i + " usageTime = " + timeStamp2);
                this.f16692i = this.f16692i + timeStamp2;
            }
            this.f16688e.put(packageName, Long.valueOf(timeStamp2));
        }
    }

    private boolean w() {
        return System.currentTimeMillis() - this.f16686c > this.f16685b;
    }

    private static a x(UsageEvents.Event event) {
        a aVar = new a();
        aVar.f16702a = event.getPackageName();
        aVar.f16704c = event.getTimeStamp();
        aVar.f16703b = h(event);
        return aVar;
    }

    public synchronized void a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C0702g.O("UsageStatsAnalyzer", "analyze skipped on main thread");
        } else if (!w()) {
            C0702g.b("UsageStatsAnalyzer", "should not reAnalyze");
        } else {
            this.f16686c = System.currentTimeMillis();
            b(this.f16684a.queryEvents(i(), f()));
        }
    }

    public void b(UsageEvents usageEvents) {
        long j5;
        boolean z5;
        if (usageEvents == null) {
            C0702g.p("UsageStatsAnalyzer", "analyze no events");
            return;
        }
        C0702g.b("UsageStatsAnalyzer", "analyzePackages() called with: events = [" + usageEvents + "]");
        q();
        long j6 = 0;
        this.f16692i = 0L;
        this.f16693j = 0L;
        List<UsageEvents.Event> listD = d(usageEvents);
        UsageEvents.Event eventV = (listD == null || listD.isEmpty() || listD.get(0) == null || listD.get(0).getEventType() == 26) ? v(7) : null;
        if (eventV != null && !C0697b.n()) {
            if (eventV.getEventType() == 17) {
                this.f16691h = i();
            } else if (eventV.getEventType() == 15) {
                this.f16690g = i();
            }
        }
        for (UsageEvents.Event event : listD) {
            int eventType = event.getEventType();
            long j7 = j6;
            if (eventType == 1 || eventType == 23 || eventType == 15 || eventType == 16 || eventType == 26 || eventType == 17 || eventType == 18 || eventType == 2) {
                if (C0702g.d("UsageStatsAnalyzer", 3)) {
                    C0702g.b("UsageStatsAnalyzer", "event = " + c(event));
                }
            } else if (C0702g.d("UsageStatsAnalyzer", 2)) {
                C0702g.M("UsageStatsAnalyzer", "event = " + c(event));
            }
            if (eventType == 1) {
                t(event);
            } else if (eventType == 23) {
                u(event);
            } else if (eventType == 15) {
                this.f16690g = event.getTimeStamp();
            } else if (eventType == 16) {
                if (this.f16690g > j7) {
                    this.f16692i += event.getTimeStamp() - this.f16690g;
                }
                this.f16690g = -1L;
            } else {
                if (eventType == 26) {
                    if (this.f16690g > j7) {
                        this.f16692i += event.getTimeStamp() - this.f16690g;
                    }
                    this.f16690g = -1L;
                    z5 = false;
                    this.f16700q = false;
                } else if (eventType == 17) {
                    this.f16691h = event.getTimeStamp();
                    this.f16700q = true;
                } else if (eventType == 18) {
                    this.f16693j += event.getTimeStamp() - this.f16691h;
                    this.f16691h = -1L;
                    z5 = false;
                    this.f16700q = false;
                } else {
                    z5 = false;
                    if (eventType == 2) {
                        s(event);
                    }
                }
                j6 = j7;
            }
            z5 = false;
            j6 = j7;
        }
        long j8 = j6;
        long j9 = this.f16690g;
        if (j9 == this.f16691h && j9 == i()) {
            if (this.f16699p.isKeyguardLocked()) {
                this.f16690g = -1L;
            } else {
                this.f16691h = -1L;
            }
        }
        if (this.f16690g > j8) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f16690g;
            if (C0697b.n()) {
                long jE = C0697b.e();
                if (jE != Long.MAX_VALUE && jCurrentTimeMillis > jE) {
                    Log.w("UsageStatsAnalyzer", "clamp open screen session after clock jump from " + C0711p.t(jCurrentTimeMillis) + " to " + C0711p.t(jE));
                    jCurrentTimeMillis = jE;
                }
            }
            j5 = j8;
            this.f16692i += Math.max(j5, jCurrentTimeMillis);
        } else {
            j5 = j8;
        }
        if (this.f16691h > j5) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - this.f16691h;
            if (C0697b.n()) {
                long jE2 = C0697b.e();
                if (jE2 != Long.MAX_VALUE && jCurrentTimeMillis2 > jE2) {
                    jCurrentTimeMillis2 = jE2;
                }
            }
            this.f16693j += Math.max(0L, jCurrentTimeMillis2);
        }
        p();
        if (C0702g.d("UsageStatsAnalyzer", 3)) {
            HashMap map = new HashMap();
            for (String str : this.f16688e.keySet()) {
                map.put(str, C0711p.m(this.f16687d, j(this.f16688e, str)));
            }
            Log.d("UsageStatsAnalyzer", "mUsageTimeMap2 = " + C0702g.m(map));
            Log.d("UsageStatsAnalyzer", "usageTime = " + C0711p.m(this.f16687d, this.f16692i) + " mLockTime = " + C0711p.m(this.f16687d, this.f16693j));
        }
    }

    public String c(UsageEvents.Event event) {
        if (event == null) {
            return null;
        }
        return "[" + C0702g.H(event, true) + "]";
    }

    List<UsageEvents.Event> d(UsageEvents usageEvents) {
        ArrayList arrayList = new ArrayList();
        if (usageEvents != null) {
            for (UsageEvents.Event event = new UsageEvents.Event(); usageEvents.getNextEvent(event); event = new UsageEvents.Event()) {
                arrayList.add(event);
            }
        }
        return arrayList;
    }

    UsageEvents.Event e(List<UsageEvents.Event> list) {
        if (list == null) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            UsageEvents.Event event = list.get(size);
            if (event.getEventType() == 15 || event.getEventType() == 16 || event.getEventType() == 17 || event.getEventType() == 18) {
                return event;
            }
        }
        return null;
    }

    public String g() {
        a();
        return this.f16697n;
    }

    UsageEvents.Event v(int i5) {
        int i6 = 0;
        while (i6 < i5) {
            i6++;
            long j5 = i6 * 86400000;
            UsageEvents.Event eventE = e(d(this.f16684a.queryEvents(i() - j5, f() - j5)));
            if (eventE != null) {
                return eventE;
            }
        }
        return null;
    }
}
