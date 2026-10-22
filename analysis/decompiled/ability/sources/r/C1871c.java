package r;

import D7.N;
import a.AbstractC0291a;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import ca.AbstractC0897f;
import e2.C1404a;
import e2.C1406c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q.C1794a;
import t.C2011a;
import v.j;
import v.k;
import v.l;
import x.i;

/* renamed from: r.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1871c implements Handler.Callback, Comparator {

    /* renamed from: t, reason: collision with root package name */
    public static HandlerThread f5662t;

    /* renamed from: a, reason: collision with root package name */
    public boolean f5663a;
    public final Application b;
    public final s.g c;
    public volatile v.d e;
    public final s.h f;
    public volatile Handler g;
    public C1873e h;
    public f i;
    public A5.c k;
    public final Handler l;
    public long m;
    public volatile C1872d n;
    public volatile boolean p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f5665q;
    public final ArrayList d = new ArrayList(32);
    public final CopyOnWriteArrayList o = new CopyOnWriteArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f5666r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public boolean f5667s = true;

    /* renamed from: j, reason: collision with root package name */
    public final h f5664j = new h(this);

    public C1871c(Application application, s.g gVar, s.h hVar) {
        this.b = application;
        this.c = gVar;
        this.f = hVar;
        if (f5662t == null) {
            synchronized (C1871c.class) {
                try {
                    if (f5662t == null) {
                        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
                        handlerThread.start();
                        f5662t = handlerThread;
                    }
                } finally {
                }
            }
        }
        Handler handler = new Handler(f5662t.getLooper(), this);
        this.l = handler;
        ((l) hVar.g.c).G0(handler);
        if (C1404a.l) {
            ((i) x.f.f6862a.b(hVar.b)).a();
        }
        gVar.b.getClass();
        gVar.b.getClass();
        handler.sendEmptyMessage(10);
        gVar.b.getClass();
        handler.sendEmptyMessage(1);
    }

    public final void a(AbstractC1869a abstractC1869a) {
        if (this.g == null || abstractC1869a == null) {
            return;
        }
        StringBuilder sbF = M.a.f("setImmediately, ");
        sbF.append(abstractC1869a.d());
        w.h.a(sbF.toString(), null);
        abstractC1869a.c = true;
        if (Looper.myLooper() == this.g.getLooper()) {
            abstractC1869a.a();
        } else {
            this.g.removeMessages(6);
            this.g.sendEmptyMessage(6);
        }
    }

    public final void b(v.b bVar) {
        int size;
        if (bVar.b == 0) {
            w.h.b(null);
        }
        synchronized (this.d) {
            size = this.d.size();
            this.d.add(bVar);
        }
        boolean z10 = bVar instanceof j;
        if (size % 10 == 0 || z10) {
            this.l.removeMessages(4);
            if (z10 || size != 0) {
                this.l.sendEmptyMessage(4);
            } else {
                this.l.sendEmptyMessageDelayed(4, 300L);
            }
        }
    }

    public final void c(boolean z10) {
        if ((!this.f5663a || z10) && this.g != null) {
            this.f5663a = true;
            this.g.removeMessages(11);
            this.g.sendEmptyMessage(11);
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        long j5 = ((v.b) obj).b - ((v.b) obj2).b;
        if (j5 < 0) {
            return -1;
        }
        return j5 > 0 ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.String[] r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.C1871c.d(java.lang.String[], boolean):void");
    }

    public final v.d e() {
        if (this.e == null) {
            synchronized (this) {
                try {
                    v.d dVar = this.e;
                    if (dVar == null) {
                        C1406c c1406c = this.c.b;
                        c1406c.getClass();
                        StringBuilder sbF = M.a.f("bd_tea_agent_");
                        sbF.append(c1406c.f4335a);
                        dVar = new v.d(this, sbF.toString());
                    }
                    this.e = dVar;
                } finally {
                }
            }
        }
        return this.e;
    }

    public final A5.c f() {
        if (this.k == null) {
            A5.c cVar = this.c.b.f;
            this.k = cVar;
            if (cVar == null) {
                this.k = w.i.f6805a;
            }
        }
        return this.k;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        C1873e c1873e;
        byte[] bytes;
        boolean z10 = false;
        String[] strArr = null;
        switch (message.what) {
            case 1:
                this.c.e.getBoolean("bav_log_collect", false);
                if (!this.f.h()) {
                    this.l.removeMessages(1);
                    this.l.sendEmptyMessageDelayed(1, 1000L);
                    return true;
                }
                if (this.c.b()) {
                    HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                    handlerThread.start();
                    this.g = new Handler(handlerThread.getLooper(), this);
                    this.g.sendEmptyMessage(2);
                    if (this.d.size() > 0) {
                        this.l.removeMessages(4);
                        this.l.sendEmptyMessageDelayed(4, 1000L);
                    }
                    Application application = this.b;
                    N.e = true;
                    E2.g.f460a.submit(new V1.a(application, 1));
                    w.h.a("net|worker start", null);
                }
                return true;
            case 2:
                C1873e c1873e2 = new C1873e(this, this.f.d.optLong("register_time", 0L));
                this.h = c1873e2;
                this.o.add(c1873e2);
                f fVar = new f(this);
                s.g gVar = this.c;
                C2011a c2011a = new C2011a();
                c2011a.f6650a = gVar;
                c2011a.b = 0;
                SharedPreferences sharedPreferences = gVar.e;
                if (System.currentTimeMillis() - sharedPreferences.getLong("sender_downgrade_time", 0L) < 10800000) {
                    c2011a.b = sharedPreferences.getInt("sender_downgrade_index", 0);
                } else {
                    sharedPreferences.edit().remove("sender_downgrade_time").remove("sender_downgrade_index").apply();
                }
                fVar.f = c2011a;
                this.i = fVar;
                this.o.add(fVar);
                f();
                if ((this.f.f.getInt("version_code", 0) != this.f.f() || !TextUtils.equals(this.c.e.getString("channel", ""), this.c.a())) && (c1873e = this.h) != null) {
                    StringBuilder sbF = M.a.f("setImmediately, ");
                    sbF.append("register");
                    w.h.a(sbF.toString(), null);
                    c1873e.c = true;
                }
                this.c.b.getClass();
                this.g.removeMessages(6);
                this.g.sendEmptyMessage(6);
                return true;
            case 3:
            case 5:
            default:
                w.h.b(null);
                return true;
            case 4:
                d((String[]) message.obj, false);
                return true;
            case 6:
                this.g.removeMessages(6);
                this.c.b.getClass();
                Iterator it = this.o.iterator();
                long j5 = Long.MAX_VALUE;
                while (it.hasNext()) {
                    AbstractC1869a abstractC1869a = (AbstractC1869a) it.next();
                    if (!abstractC1869a.e) {
                        long jA = abstractC1869a.a();
                        if (jA < j5) {
                            j5 = jA;
                        }
                    }
                }
                long jCurrentTimeMillis = j5 - System.currentTimeMillis();
                if (this.f5667s && jCurrentTimeMillis > 15000) {
                    jCurrentTimeMillis = 15000;
                }
                this.g.sendEmptyMessageDelayed(6, jCurrentTimeMillis);
                if (this.f5666r.size() > 0) {
                    synchronized (this.f5666r) {
                        try {
                            Iterator it2 = this.f5666r.iterator();
                            while (it2.hasNext()) {
                            }
                            this.f5666r.clear();
                        } finally {
                        }
                    }
                    return true;
                }
                return true;
            case 7:
                synchronized (this.d) {
                    try {
                        ArrayList arrayList = this.d;
                        if (h.m == null) {
                            h.m = new g();
                        }
                        h.m.c(0L);
                        arrayList.add(h.m);
                    } finally {
                    }
                }
                d(null, false);
                return true;
            case 8:
                ArrayList arrayList2 = (ArrayList) message.obj;
                s.h hVar = this.f;
                String[] strArrI = AbstractC0897f.i(this, hVar.d(), true);
                JSONObject jSONObjectF = U7.a.f(hVar.d());
                if (strArrI.length > 0) {
                    try {
                        v.i iVar = new v.i();
                        JSONArray[] jSONArrayArr = {new JSONArray(), new JSONArray(), null};
                        long[] jArr = new long[3];
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            v.b bVar = (v.b) it3.next();
                            if (NotificationCompat.CATEGORY_EVENT.equals(bVar.m())) {
                                jSONArrayArr[0].put(bVar.o());
                            } else if ("eventv3".equals(bVar.m())) {
                                jSONArrayArr[1].put(bVar.o());
                            }
                        }
                        iVar.p(jSONObjectF, null, null, null, jSONArrayArr, jArr, null);
                        bytes = iVar.n().toString().getBytes();
                    } catch (JSONException e) {
                        w.h.b(e);
                        bytes = null;
                    }
                    int iC = AbstractC0291a.c(strArrI, bytes, this.c);
                    if (iC == 200) {
                        this.m = 0L;
                        z10 = true;
                    } else if (iC >= 500 && iC < 600) {
                        this.m = System.currentTimeMillis();
                    }
                }
                w.h.a("sendRealTime, " + z10, null);
                if (!z10) {
                    e().f(arrayList2);
                }
                return true;
            case 9:
                throw null;
            case 10:
                synchronized (this.d) {
                    ArrayList arrayList3 = this.d;
                    LinkedList linkedList = s.b.f5971a;
                    synchronized (linkedList) {
                        linkedList.size();
                        arrayList3.addAll(linkedList);
                        linkedList.clear();
                    }
                }
                LinkedList linkedList2 = s.b.b;
                int size = linkedList2.size();
                if (size > 0) {
                    strArr = new String[size];
                    linkedList2.toArray(strArr);
                    linkedList2.clear();
                }
                d(strArr, false);
                return true;
            case 11:
            case 13:
                return true;
            case 12:
                Object[] objArr = (Object[]) message.obj;
                String str = (String) objArr[0];
                j jVar = (j) objArr[1];
                a(this.i);
                if (jVar == null) {
                    j jVar2 = C1794a.b;
                    j jVar3 = jVar2 != null ? jVar2 : null;
                    jVar = jVar3 != null ? (j) jVar3.clone() : jVar3;
                }
                ArrayList arrayList4 = new ArrayList();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jVar != null) {
                    long j6 = jCurrentTimeMillis2 - jVar.b;
                    jVar.c(jCurrentTimeMillis2);
                    jVar.l = j6 >= 0 ? j6 : 0L;
                    jVar.p = this.f5664j.k;
                    this.f5664j.c(jVar);
                    arrayList4.add(jVar);
                }
                s.h hVar2 = this.f;
                if (hVar2.c(str, "user_unique_id")) {
                    hVar2.c.c.edit().putString("user_unique_id", str).apply();
                    if (str != null) {
                        this.c.getClass();
                    }
                    this.p = true;
                    a(this.h);
                    c(true);
                }
                if (jVar != null) {
                    j jVar4 = (j) jVar.clone();
                    jVar4.c(jCurrentTimeMillis2 + 1);
                    jVar4.l = -1L;
                    this.f5664j.b(jVar4, arrayList4, true).o = this.f5664j.k;
                    this.f5664j.c(jVar4);
                    arrayList4.add(jVar4);
                }
                if (!arrayList4.isEmpty()) {
                    e().f(arrayList4);
                }
                a(this.i);
                return true;
            case 14:
                d(null, true);
                return true;
            case 15:
                Object[] objArr2 = (Object[]) message.obj;
                boolean zBooleanValue = ((Boolean) objArr2[0]).booleanValue();
                String str2 = (String) objArr2[1];
                if (zBooleanValue) {
                    if (this.n == null) {
                        this.n = new C1872d(this, str2);
                        this.o.add(this.n);
                        this.g.removeMessages(6);
                        this.g.sendEmptyMessage(6);
                        return true;
                    }
                } else if (this.n != null) {
                    this.n.e = true;
                    this.o.remove(this.n);
                    this.n = null;
                    return true;
                }
                return true;
            case 16:
                v.b bVar2 = (v.b) message.obj;
                C1872d c1872d = this.n;
                if (((bVar2 instanceof v.g) || (bVar2 instanceof k)) && c1872d != null) {
                    AbstractC0291a.n(this, bVar2.n(), c1872d.f);
                    return true;
                }
                return true;
        }
    }
}
