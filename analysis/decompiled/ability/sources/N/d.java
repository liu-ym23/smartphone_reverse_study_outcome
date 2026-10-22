package N;

import A6.l;
import H.h;
import L0.e;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import l0.AbstractC1654a;
import m0.C1667a;
import m0.C1669c;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements e, C.a, v1.c, B.c {
    public boolean b;
    public long c;
    public long d;
    public long f;
    public int g;
    public int h;
    public long i;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f1005a = new LinkedList();
    public boolean e = true;

    public static void d(String str, ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(((C1669c) arrayList.get(i)).d);
        }
        U7.a.o("<monitor><verify>", str, jSONArray.toString());
    }

    public static void h(ArrayList arrayList) {
        int size = arrayList.size() / 2;
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1669c c1669c = (C1669c) it.next();
            if (c1669c != null) {
                if (TextUtils.equals("network", c1669c.b)) {
                    arrayList3.add((C1667a) c1669c);
                } else {
                    arrayList2.add(c1669c);
                }
            }
        }
        if (!S0.b.a0(arrayList2)) {
            ((x1.b) v1.b.f6765a.c).m(arrayList2);
            if (h.b) {
                d("savedb_default", arrayList2);
            }
        }
        if (S0.b.a0(arrayList3)) {
            return;
        }
        ((x1.b) v1.b.f6765a.d).m(arrayList3);
        if (h.b) {
            d("savedb_api", arrayList3);
        }
    }

    @Override // v1.c
    public final int a() {
        return this.g;
    }

    @Override // v1.c
    public final int b() {
        return this.h;
    }

    @Override // B.c
    public final void c(Activity activity) {
    }

    @Override // L0.e
    public final void e(long j5) {
        i(false);
        if (this.e && j5 - this.i >= 1200000) {
            this.i = j5;
            if (Environment.getDataDirectory().getFreeSpace() < this.f * 1048576) {
                this.e = false;
                K1.a aVar = v1.b.f6765a;
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(5, -5);
                calendar.set(11, 23);
                calendar.set(12, 59);
                calendar.set(13, 59);
                long timeInMillis = calendar.getTimeInMillis();
                ((x1.b) aVar.c).f(timeInMillis);
                ((x1.b) aVar.d).f(timeInMillis);
            }
        }
    }

    @Override // B.c
    public final void f(Activity activity) {
        L0.d.f925a.b(new l(this, 13));
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    public final void i(boolean z10) {
        int size;
        ArrayList arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((this.b || jCurrentTimeMillis - this.c >= 60000 || z10) && (size = this.f1005a.size()) != 0) {
            if (z10 || size >= 5 || jCurrentTimeMillis - this.d > 30000) {
                this.d = jCurrentTimeMillis;
                synchronized (this.f1005a) {
                    arrayList = new ArrayList(this.f1005a);
                    this.f1005a.clear();
                }
                try {
                    if (h.b && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            AbstractC1654a.f5271a.b("DATA_SAVE_TO_DB", ((C1669c) it.next()).d);
                        }
                    }
                    h(arrayList);
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    @Override // C.a
    public final void onReady() {
        v1.d.c = this;
        L0.d.f925a.a(this);
    }

    @Override // C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("general");
        if (jSONObjectOptJSONObject2 != null) {
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("slardar_api_settings");
            if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("report_setting")) != null) {
                this.e = jSONObjectOptJSONObject.optBoolean("local_monitor_switch", true);
                this.f = jSONObjectOptJSONObject.optLong("local_monitor_min_free_disk_mb", 150L);
                jSONObjectOptJSONObject.optInt("memory_store_cache_max_count", 500);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("cleanup");
            if (jSONObjectOptJSONObject4 != null) {
                this.g = jSONObjectOptJSONObject4.optInt("log_reserve_days", 5);
                this.h = jSONObjectOptJSONObject4.optInt("log_max_size_mb", 80);
            }
        }
    }

    @Override // B.c
    /* renamed from: c */
    public final void mo0c() {
    }
}
