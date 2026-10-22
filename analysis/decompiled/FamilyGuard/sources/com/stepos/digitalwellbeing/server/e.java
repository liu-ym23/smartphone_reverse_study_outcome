package com.stepos.digitalwellbeing.server;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.os.PowerManager;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.e;
import com.stepos.minor.WhitelistApp;
import f2.C0702g;
import f2.C0711p;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C0813a;
import org.libpag.BuildConfig;
import x3.AbstractC1286b;
import x3.EnumC1285a;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Q1.c<A3.c> f14536a;

    /* renamed from: b, reason: collision with root package name */
    private x3.g<a> f14537b;

    /* renamed from: c, reason: collision with root package name */
    private final Queue<a> f14538c = new ConcurrentLinkedQueue();

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentMap<Integer, c> f14539d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentMap<String, Integer> f14540e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Set<String> f14541f = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: g, reason: collision with root package name */
    private Q1.c<A3.c> f14542g = Q1.c.a();

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f14543h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private volatile b f14544i;

    /* JADX INFO: Access modifiers changed from: private */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f14545a;

        /* renamed from: b, reason: collision with root package name */
        public String f14546b;

        /* renamed from: c, reason: collision with root package name */
        public long f14547c;

        public String toString() {
            return "Event{commandId=" + e.h(this.f14545a) + ", packageName='" + this.f14546b + "', time=" + C0711p.j(this.f14547c) + '}';
        }

        private a() {
        }
    }

    public interface b {
        void a(String str);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f14548a;

        /* renamed from: b, reason: collision with root package name */
        private final Set<String> f14549b;

        /* renamed from: c, reason: collision with root package name */
        private final int f14550c;

        /* renamed from: d, reason: collision with root package name */
        private long f14551d;

        /* renamed from: e, reason: collision with root package name */
        private long f14552e;

        /* renamed from: f, reason: collision with root package name */
        private long f14553f;

        /* renamed from: g, reason: collision with root package name */
        private final Set<String> f14554g;

        /* renamed from: h, reason: collision with root package name */
        private PendingIntent f14555h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f14556i;

        /* renamed from: j, reason: collision with root package name */
        private Q1.c<A3.c> f14557j;

        /* renamed from: k, reason: collision with root package name */
        private final AtomicBoolean f14558k;

        /* renamed from: l, reason: collision with root package name */
        private volatile boolean f14559l;

        public c(int i5, String[] strArr, int i6, long j5, PendingIntent pendingIntent, boolean z5) {
            HashSet hashSet = new HashSet();
            this.f14549b = hashSet;
            this.f14554g = Collections.newSetFromMap(new ConcurrentHashMap());
            this.f14556i = true;
            this.f14557j = Q1.c.a();
            this.f14558k = new AtomicBoolean(false);
            this.f14555h = pendingIntent;
            this.f14551d = j5;
            this.f14553f = j5;
            this.f14550c = i6;
            this.f14548a = i5;
            hashSet.addAll(Arrays.asList(strArr));
            this.f14556i = z5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            PendingIntent pendingIntent;
            this.f14557j.c(new V1.l());
            this.f14557j = Q1.c.a();
            AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
            if (alarmManager != null && (pendingIntent = this.f14555h) != null) {
                alarmManager.cancel(pendingIntent);
            }
            if (this.f14552e == 0) {
                C0702g.b("AppsTimeLimitController", "cancelObserve: mLastStartTime = 0，cancel recheck alarm only");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f14553f -= jCurrentTimeMillis - this.f14552e;
            this.f14552e = jCurrentTimeMillis;
            C0702g.c("AppsTimeLimitController", "cancelObserve group = " + this, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            return this.f14558k.compareAndSet(false, true);
        }

        private void g() throws PendingIntent.CanceledException {
            PendingIntent pendingIntent;
            if (!this.f14558k.compareAndSet(false, true)) {
                C0702g.b("AppsTimeLimitController", "dispatchCallbackOnce skipped, already dispatched id=" + this.f14548a);
                return;
            }
            this.f14557j.c(new V1.l());
            this.f14557j = Q1.c.a();
            AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
            if (alarmManager != null && (pendingIntent = this.f14555h) != null) {
                alarmManager.cancel(pendingIntent);
            }
            try {
                h().send();
            } catch (PendingIntent.CanceledException unused) {
                C0702g.p("AppsTimeLimitController", "PendingIntent was canceled");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m() throws PendingIntent.CanceledException {
            C0702g.b("AppsTimeLimitController", "group id = " + this.f14548a + " in-process timer fired, send callbackIntent = " + this.f14555h);
            g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n() throws PendingIntent.CanceledException {
            PendingIntent pendingIntent;
            this.f14557j.c(new V1.l());
            this.f14558k.set(false);
            if (!e.p()) {
                AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
                if (alarmManager != null && (pendingIntent = this.f14555h) != null) {
                    alarmManager.cancel(pendingIntent);
                }
                this.f14552e = 0L;
                this.f14559l = true;
                C0702g.b("AppsTimeLimitController", "observe skip wall-clock, screen off id=" + this.f14548a + " remaining=" + C0711p.t(this.f14553f));
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j5 = this.f14553f + jCurrentTimeMillis;
            AlarmManager alarmManager2 = (AlarmManager) P1.a.a().getSystemService("alarm");
            C0702g.b("AppsTimeLimitController", "observe: 开始监控，mRemainingTime = " + C0711p.t(this.f14553f) + " perceptibleEmpty=" + this.f14554g.isEmpty());
            if (this.f14553f <= 0) {
                C0702g.b("AppsTimeLimitController", "observe: 剩余时间小于等于0，直接发送广播");
                this.f14552e = jCurrentTimeMillis;
                g();
                return;
            }
            this.f14552e = jCurrentTimeMillis;
            if (this.f14554g.isEmpty()) {
                w(alarmManager2, j5);
            } else {
                alarmManager2.setExactAndAllowWhileIdle(0, j5, this.f14555h);
            }
            this.f14557j = Q1.c.e(AbstractC1286b.k(this.f14553f, TimeUnit.MILLISECONDS).j(T3.a.a()).h(new D3.a() { // from class: com.stepos.digitalwellbeing.server.f
                @Override // D3.a
                public final void run() throws PendingIntent.CanceledException {
                    this.f14560a.m();
                }
            }, S1.a.b()));
            C0702g.b("AppsTimeLimitController", "group id = " + this.f14548a + " set Alarm alarmTime = " + C0711p.j(j5) + ", mRemainingTime = " + C0711p.t(this.f14553f) + " mCallbackIntent = " + this.f14555h);
        }

        private void s() throws PendingIntent.CanceledException {
            PendingIntent pendingIntent;
            if (this.f14559l) {
                return;
            }
            this.f14557j.c(new V1.l());
            this.f14557j = Q1.c.a();
            AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
            if (alarmManager != null && (pendingIntent = this.f14555h) != null) {
                alarmManager.cancel(pendingIntent);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j5 = this.f14552e;
            if (j5 != 0) {
                this.f14553f -= jCurrentTimeMillis - j5;
            }
            this.f14552e = 0L;
            this.f14558k.set(false);
            this.f14559l = true;
            C0702g.b("AppsTimeLimitController", "pauseObserveForScreenOff id=" + this.f14548a + " remaining=" + C0711p.t(this.f14553f));
            if (this.f14553f <= 0) {
                C0702g.b("AppsTimeLimitController", "pauseObserveForScreenOff remaining<=0, dispatch id=" + this.f14548a);
                this.f14559l = false;
                g();
            }
        }

        private void t() throws PendingIntent.CanceledException {
            PendingIntent pendingIntent;
            this.f14557j.c(new V1.l());
            this.f14557j = Q1.c.a();
            AlarmManager alarmManager = (AlarmManager) P1.a.a().getSystemService("alarm");
            if (alarmManager != null && (pendingIntent = this.f14555h) != null) {
                alarmManager.cancel(pendingIntent);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j5 = this.f14552e;
            if (j5 != 0) {
                this.f14553f -= jCurrentTimeMillis - j5;
            }
            this.f14552e = 0L;
            this.f14558k.set(false);
            if (this.f14553f <= 0) {
                C0702g.b("AppsTimeLimitController", "pauseObserveWithRecheckAlarm remaining<=0, dispatch id=" + this.f14548a);
                g();
                return;
            }
            if (this.f14559l || !e.p()) {
                this.f14559l = true;
                C0702g.b("AppsTimeLimitController", "pauseObserveWithRecheckAlarm skip recheck, screen off id=" + this.f14548a + " remaining=" + C0711p.t(this.f14553f));
                return;
            }
            long j6 = jCurrentTimeMillis + this.f14553f;
            C0702g.b("AppsTimeLimitController", "pauseObserveWithRecheckAlarm id=" + this.f14548a + " remaining=" + C0711p.t(this.f14553f) + " alarmTime=" + C0711p.j(j6));
            w(alarmManager, j6);
        }

        private void u() {
            this.f14557j.c(new V1.l());
            this.f14557j = Q1.c.a();
            ((AlarmManager) P1.a.a().getSystemService("alarm")).cancel(this.f14555h);
            C0702g.b("AppsTimeLimitController", "group id = " + this.f14548a + " resetObserve: 重置监控  mCallbackIntent = " + this.f14555h);
        }

        private void v() throws PendingIntent.CanceledException {
            if (this.f14559l) {
                this.f14559l = false;
                if (!this.f14554g.isEmpty()) {
                    C0702g.b("AppsTimeLimitController", "resumeObserveAfterScreenOn observe id=" + this.f14548a + " remaining=" + C0711p.t(this.f14553f));
                    n();
                    return;
                }
                C0702g.b("AppsTimeLimitController", "resumeObserveAfterScreenOn restore recheck id=" + this.f14548a + " remaining=" + C0711p.t(this.f14553f));
                long j5 = this.f14553f;
                if (j5 > 0) {
                    t();
                } else if (j5 <= 0) {
                    g();
                }
            }
        }

        private void w(AlarmManager alarmManager, long j5) {
            if (alarmManager == null || this.f14555h == null) {
                return;
            }
            try {
                alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j5, this.f14555h), this.f14555h);
                C0702g.b("AppsTimeLimitController", "scheduleExactWakeup setAlarmClock alarmTime=" + C0711p.j(j5) + " id=" + this.f14548a);
            } catch (Exception e6) {
                C0702g.O("AppsTimeLimitController", "scheduleExactWakeup setAlarmClock failed: " + e6.getMessage());
                alarmManager.setExactAndAllowWhileIdle(0, j5, this.f14555h);
            }
        }

        public PendingIntent h() {
            return this.f14555h;
        }

        public int i() {
            return this.f14548a;
        }

        public Set<String> j() {
            return this.f14549b;
        }

        public Set<String> k() {
            return this.f14554g;
        }

        public void l(Set<String> set) {
            if (set == null || set.isEmpty()) {
                return;
            }
            C0702g.c("AppsTimeLimitController", "#" + this.f14548a + " initPerceptibleAppSet: " + C0702g.l(set), false);
            this.f14554g.clear();
            for (String str : set) {
                if (this.f14549b.contains(str)) {
                    this.f14554g.add(str);
                }
            }
        }

        public void o(String str) throws PendingIntent.CanceledException {
            C0702g.D("AppsTimeLimitController", R1.a.f4966b);
            C0702g.b("AppsTimeLimitController", "onPackagePerceptible packageName = " + str + " group = " + this);
            boolean zIsEmpty = this.f14554g.isEmpty();
            if (!this.f14549b.contains(str)) {
                C0702g.O("AppsTimeLimitController", "onPackagePerceptible: packageName is not observed, packageName = " + str);
                C0702g.E("AppsTimeLimitController", R1.a.f4966b);
                return;
            }
            if (this.f14554g.contains(str)) {
                C0702g.O("AppsTimeLimitController", "onPackagePerceptible: packageName is already perceptible, packageName = " + str);
                C0702g.E("AppsTimeLimitController", R1.a.f4966b);
                return;
            }
            C0702g.b("AppsTimeLimitController", "before add: " + C0702g.l(this.f14554g));
            this.f14554g.add(str);
            C0702g.b("AppsTimeLimitController", "after add: " + C0702g.l(this.f14554g));
            if (zIsEmpty) {
                if (this.f14559l || !e.p()) {
                    C0702g.b("AppsTimeLimitController", "onPackagePerceptible skip observe, screen off id=" + this.f14548a);
                    C0702g.E("AppsTimeLimitController", R1.a.f4966b);
                    return;
                }
                u();
                n();
            }
            C0702g.E("AppsTimeLimitController", R1.a.f4966b);
        }

        public void p(String str) throws PendingIntent.CanceledException {
            C0702g.D("AppsTimeLimitController", R1.a.f4966b);
            C0702g.c("AppsTimeLimitController", "onPackageUnPerceptible packageName = " + str + " group = " + this, false);
            if (!this.f14549b.contains(str)) {
                C0702g.O("AppsTimeLimitController", "onPackageUnPerceptible: packageName is not observed, packageName = " + str);
                C0702g.E("AppsTimeLimitController", R1.a.f4966b);
                return;
            }
            C0702g.c("AppsTimeLimitController", "before remove: " + C0702g.l(this.f14554g), false);
            this.f14554g.remove(str);
            C0702g.c("AppsTimeLimitController", "after remove: " + C0702g.l(this.f14554g), false);
            if (this.f14554g.isEmpty()) {
                t();
            }
            C0702g.E("AppsTimeLimitController", R1.a.f4966b);
        }

        public void q(long j5) throws PendingIntent.CanceledException {
            C0702g.b("AppsTimeLimitController", "onScreenOff: 屏幕熄灭，time = " + C0711p.j(j5));
            s();
        }

        public void r(long j5) throws PendingIntent.CanceledException {
            C0702g.b("AppsTimeLimitController", "onScreenOn: 屏幕亮起，time = " + C0711p.j(j5));
            if (!this.f14556i) {
                this.f14553f = this.f14551d;
                this.f14552e = j5;
                C0702g.b("AppsTimeLimitController", "group id = " + this.f14548a + " onScreenOn: 屏幕亮起，set mRemainingTime = " + C0711p.t(this.f14553f));
            }
            v();
        }

        public String toString() {
            return "ObservedGroup{mId=" + this.f14548a + ", mGroupType=" + this.f14550c + ", mTimeLimit=" + this.f14551d + ", mLastStartTime=" + this.f14552e + ", mRemainingTime=" + C0711p.t(this.f14553f) + ", mCallbackIntent=" + this.f14555h + ", mCumulative=" + this.f14556i + '}';
        }
    }

    public e() {
        this.f14536a = Q1.c.a();
        this.f14536a = Q1.c.e(x3.f.h(new x3.h() { // from class: com.stepos.digitalwellbeing.server.b
            @Override // x3.h
            public final void a(x3.g gVar) {
                this.f14524a.r(gVar);
            }
        }, EnumC1285a.BUFFER).X(T3.a.d()).T(new D3.c() { // from class: com.stepos.digitalwellbeing.server.c
            @Override // D3.c
            public final void accept(Object obj) throws PendingIntent.CanceledException {
                this.f14525a.k((e.a) obj);
            }
        }, S1.a.b()));
    }

    private void B() {
        this.f14542g.c(new V1.l());
        this.f14542g = Q1.c.a();
        C0702g.b("AppsTimeLimitController", "stopForegroundPoll");
    }

    private void D() {
    }

    private void e(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                ConcurrentMap<String, Integer> concurrentMap = this.f14540e;
                concurrentMap.put(str, Integer.valueOf(((Integer) C0813a.a(concurrentMap, str, 0)).intValue() + 1));
            }
        }
        D();
    }

    private void f(int i5, String str, long j5) {
        a aVar = new a();
        aVar.f14545a = i5;
        aVar.f14546b = str;
        aVar.f14547c = j5;
        x3.g<a> gVar = this.f14537b;
        if (gVar == null) {
            this.f14538c.add(aVar);
        } else {
            gVar.d(aVar);
        }
    }

    private void g() {
        if (!this.f14542g.d() || this.f14542g.b().g()) {
            C0702g.b("AppsTimeLimitController", "ensureForegroundPoll start interval = 3000");
            this.f14542g = Q1.c.e(x3.f.A(3000L, TimeUnit.MILLISECONDS).X(T3.a.a()).T(new D3.c() { // from class: com.stepos.digitalwellbeing.server.d
                @Override // D3.c
                public final void accept(Object obj) {
                    this.f14526a.q((Long) obj);
                }
            }, S1.a.b()));
        }
    }

    public static String h(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? "UNKNOWN" : "COMMAND_SCREEN_OFF" : "COMMAND_SCREEN_ON" : "COMMAND_APP_END" : "COMMAND_APP_START";
    }

    private void i(a aVar) throws PendingIntent.CanceledException {
        if (aVar == null) {
            C0702g.O("AppsTimeLimitController", "handleAppEnd: event is null");
            return;
        }
        String str = aVar.f14546b;
        if (p() && TextUtils.equals(str, u())) {
            C0702g.b("AppsTimeLimitController", "handleAppEnd ignored, still resumed package=" + str);
            return;
        }
        for (c cVar : this.f14539d.values()) {
            if (cVar.j().contains(str)) {
                cVar.p(str);
            }
        }
        this.f14541f.remove(str);
    }

    private void j(a aVar) throws PendingIntent.CanceledException {
        if (aVar == null) {
            C0702g.O("AppsTimeLimitController", "handleAppStart: event is null");
            return;
        }
        String str = aVar.f14546b;
        this.f14541f.add(str);
        boolean z5 = false;
        for (c cVar : this.f14539d.values()) {
            if (cVar.j().contains(str)) {
                cVar.o(str);
                z5 = true;
            }
        }
        if (!z5 || this.f14544i == null) {
            return;
        }
        this.f14544i.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(a aVar) throws PendingIntent.CanceledException {
        C0702g.c("AppsTimeLimitController", "handleEvent: " + aVar, false);
        int i5 = aVar.f14545a;
        if (i5 == 1) {
            j(aVar);
            return;
        }
        if (i5 == 2) {
            i(aVar);
        } else if (i5 == 3) {
            n(aVar);
        } else if (i5 == 4) {
            m(aVar);
        }
    }

    private void m(a aVar) throws PendingIntent.CanceledException {
        this.f14543h.set(true);
        Iterator<c> it = this.f14539d.values().iterator();
        while (it.hasNext()) {
            it.next().q(aVar.f14547c);
        }
    }

    private void n(a aVar) throws PendingIntent.CanceledException {
        this.f14543h.set(false);
        Iterator<c> it = this.f14539d.values().iterator();
        while (it.hasNext()) {
            it.next().r(aVar.f14547c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p() {
        try {
            PowerManager powerManager = (PowerManager) P1.a.a().getSystemService("power");
            if (powerManager != null) {
                return powerManager.isInteractive();
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Long l5) {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(x3.g gVar) {
        this.f14537b = gVar;
        while (!this.f14538c.isEmpty()) {
            a aVarPoll = this.f14538c.poll();
            if (aVarPoll != null) {
                gVar.d(aVarPoll);
            }
        }
    }

    private void t() {
        if (this.f14539d.isEmpty()) {
            B();
            return;
        }
        if (!p()) {
            if (this.f14543h.compareAndSet(false, true)) {
                C0702g.b("AppsTimeLimitController", "pollForeground enqueue SCREEN_OFF to pause observers");
                f(4, BuildConfig.FLAVOR, System.currentTimeMillis());
                return;
            }
            return;
        }
        if (this.f14543h.compareAndSet(true, false)) {
            C0702g.b("AppsTimeLimitController", "pollForeground enqueue SCREEN_ON to resume observers");
            f(3, BuildConfig.FLAVOR, System.currentTimeMillis());
        }
        String strV = v();
        if (TextUtils.isEmpty(strV)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f14541f.contains(strV)) {
            C0702g.b("AppsTimeLimitController", "pollForeground synthesize APP_START package = " + strV);
            f(1, strV, jCurrentTimeMillis);
        }
        for (String str : new HashSet(this.f14541f)) {
            if (!TextUtils.equals(str, strV)) {
                C0702g.b("AppsTimeLimitController", "pollForeground synthesize APP_END package = " + str);
                f(2, str, jCurrentTimeMillis);
            }
        }
    }

    public static String u() {
        try {
            UsageStatsManager usageStatsManager = (UsageStatsManager) P1.a.a().getSystemService("usagestats");
            if (usageStatsManager != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(jCurrentTimeMillis - 600000, jCurrentTimeMillis);
                UsageEvents.Event event = new UsageEvents.Event();
                String packageName = null;
                while (usageEventsQueryEvents != null && usageEventsQueryEvents.hasNextEvent()) {
                    usageEventsQueryEvents.getNextEvent(event);
                    if (event.getEventType() == 1 && !TextUtils.isEmpty(event.getPackageName())) {
                        packageName = event.getPackageName();
                    }
                }
                if (!TextUtils.isEmpty(packageName)) {
                    return packageName;
                }
            }
        } catch (Exception e6) {
            C0702g.O("AppsTimeLimitController", "queryLastResumedPackage usageStats failed: " + e6.getMessage());
        }
        return null;
    }

    private String v() {
        return u();
    }

    private void x(String[] strArr) {
        int iIntValue;
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && (iIntValue = ((Integer) C0813a.a(this.f14540e, str, 0)).intValue()) > 0) {
                this.f14540e.put(str, Integer.valueOf(iIntValue - 1));
            }
        }
        D();
    }

    private void y(c cVar) {
        if (cVar == null || !cVar.k().isEmpty()) {
            return;
        }
        String strV = v();
        if (TextUtils.isEmpty(strV) || !cVar.j().contains(strV)) {
            return;
        }
        C0702g.b("AppsTimeLimitController", "seedPerceptibleFromCurrentForeground top = " + strV + " groupId = " + cVar.i());
        this.f14541f.add(strV);
        cVar.l(this.f14541f);
    }

    public boolean A(String[] strArr) {
        if (p()) {
            return !o(strArr);
        }
        return true;
    }

    public void C(int i5) {
        C0702g.b("AppsTimeLimitController", "unregisterAppUsageObserver: observerId = " + i5);
        c cVarRemove = this.f14539d.remove(Integer.valueOf(i5));
        C0702g.c("AppsTimeLimitController", "unregisterAppUsageObserver: " + cVarRemove, false);
        if (cVarRemove != null) {
            x((String[]) cVarRemove.j().toArray(new String[0]));
            cVarRemove.e();
        }
        if (this.f14539d.isEmpty()) {
            B();
        }
    }

    public void l(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("command_id", 0);
            String stringExtra = intent.getStringExtra(WhitelistApp.COLUMN_PACKAGE_NAME);
            long longExtra = intent.getLongExtra("time", 0L);
            a aVar = new a();
            aVar.f14545a = intExtra;
            aVar.f14546b = stringExtra;
            aVar.f14547c = longExtra;
            x3.g<a> gVar = this.f14537b;
            if (gVar == null) {
                this.f14538c.add(aVar);
            } else {
                gVar.d(aVar);
            }
        }
    }

    public boolean o(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            String strU = u();
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (TextUtils.equals(str, strU) || this.f14541f.contains(str))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean s(int i5) {
        C0702g.b("AppsTimeLimitController", "onObservedApproach: observerId = " + i5);
        c cVarRemove = this.f14539d.remove(Integer.valueOf(i5));
        C0702g.c("AppsTimeLimitController", "onObservedApproach: " + cVarRemove, false);
        if (cVarRemove == null) {
            return false;
        }
        cVarRemove.f();
        x((String[]) cVarRemove.j().toArray(new String[0]));
        cVarRemove.e();
        if (!this.f14539d.isEmpty()) {
            return true;
        }
        B();
        return true;
    }

    public void w(int i5, String[] strArr, int i6, long j5, PendingIntent pendingIntent, boolean z5) {
        C0702g.b("AppsTimeLimitController", "registerAppUsageObserver: observerId = " + i5 + ", packages = " + C0702g.h(strArr) + ", timeLimit = " + j5 + ", callbackIntent = " + pendingIntent);
        e(strArr);
        c cVar = new c(i5, strArr, i6, j5, pendingIntent, z5);
        this.f14539d.put(Integer.valueOf(i5), cVar);
        StringBuilder sb = new StringBuilder();
        sb.append("registerAppUsageObserver: ");
        sb.append(cVar);
        C0702g.c("AppsTimeLimitController", sb.toString(), false);
        cVar.l(this.f14541f);
        y(cVar);
        cVar.n();
        g();
    }

    public void z(b bVar) {
        this.f14544i = bVar;
    }
}
