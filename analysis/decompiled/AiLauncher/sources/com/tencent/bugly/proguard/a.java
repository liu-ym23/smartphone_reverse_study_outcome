package com.tencent.bugly.proguard;

import O6.l;
import Z7.C1130b;
import Z7.C1132d;
import Z7.C1138j;
import Z7.C1139k;
import Z7.V;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f31539a;

    /* renamed from: b, reason: collision with root package name */
    public final C1132d f31540b;

    /* renamed from: com.tencent.bugly.proguard.a$a, reason: collision with other inner class name */
    public class RunnableC0379a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f31541a;

        public RunnableC0379a(List list) {
            this.f31541a = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.g(this.f31541a);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f31543a = new a(0);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f31544a;

        /* renamed from: b, reason: collision with root package name */
        public long f31545b;

        /* renamed from: c, reason: collision with root package name */
        public String f31546c;

        public final String toString() {
            return "SLAData{uuid='" + this.f31544a + "', time=" + this.f31545b + ", data='" + this.f31546c + "'}";
        }
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static String a(String str, Iterable<c> iterable) {
        Iterator<c> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("'");
        sb2.append(it.next().f31544a);
        sb2.append("'");
        while (it.hasNext()) {
            sb2.append(str);
            sb2.append("'");
            sb2.append(it.next().f31544a);
            sb2.append("'");
        }
        return sb2.toString();
    }

    public static List<c> b() {
        Cursor cursorK = V.f().k("t_sla", new String[]{StepOSRecipientEmailHistory._ID, "_tm", "_dt"}, null, "_tm", "30");
        if (cursorK == null) {
            return null;
        }
        if (cursorK.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursorK.moveToNext()) {
            try {
                c cVar = new c();
                cVar.f31544a = cursorK.getString(cursorK.getColumnIndex(StepOSRecipientEmailHistory._ID));
                cVar.f31545b = cursorK.getLong(cursorK.getColumnIndex("_tm"));
                cVar.f31546c = cursorK.getString(cursorK.getColumnIndex("_dt"));
                C1139k.h(cVar.toString(), new Object[0]);
                arrayList.add(cVar);
            } catch (Throwable th) {
                try {
                    C1139k.g(th);
                    return arrayList;
                } finally {
                    cursorK.close();
                }
            }
        }
        return arrayList;
    }

    public static void g(List<c> list) {
        if (list == null || list.isEmpty()) {
            C1139k.h("sla batch report data is empty", new Object[0]);
            return;
        }
        C1139k.h("sla batch report list size:%s", Integer.valueOf(list.size()));
        if (list.size() > 30) {
            list = list.subList(0, 29);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f31546c);
        }
        Pair<Integer, String> pairB = C1132d.b(arrayList);
        C1139k.h("sla batch report result, rspCode:%s rspMsg:%s", pairB.first, pairB.second);
        if (((Integer) pairB.first).intValue() == 200) {
            h(list);
        }
    }

    public static void h(List<c> list) {
        if (list == null || list.isEmpty()) {
            C1139k.h("sla batch delete list is null", new Object[0]);
            return;
        }
        C1139k.h("sla batch delete list size:%s", Integer.valueOf(list.size()));
        try {
            String str = "_id in (" + a(Const.STR_MART_COMMA, list) + ")";
            C1139k.h("sla batch delete where:%s", str);
            V.f().b("t_sla", str);
        } catch (Throwable th) {
            C1139k.g(th);
        }
    }

    public static void i(List<c> list) {
        for (c cVar : list) {
            C1139k.h("sla save id:%s time:%s msg:%s", cVar.f31544a, Long.valueOf(cVar.f31545b), cVar.f31546c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(StepOSRecipientEmailHistory._ID, cVar.f31544a);
                contentValues.put("_tm", Long.valueOf(cVar.f31545b));
                contentValues.put("_dt", cVar.f31546c);
                V.f().e("t_sla", contentValues, null);
            } catch (Throwable th) {
                C1139k.g(th);
            }
        }
    }

    public final void c(d dVar) {
        if (TextUtils.isEmpty(dVar.f31548b)) {
            C1139k.i("sla report event is null", new Object[0]);
        } else {
            C1139k.h("sla report single event", new Object[0]);
            d(Collections.singletonList(dVar));
        }
    }

    public final void d(List<d> list) {
        if (list == null || list.isEmpty()) {
            C1139k.i("sla batch report event is null", new Object[0]);
            return;
        }
        C1139k.h("sla batch report event size:%s", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            c cVarE = e(it.next());
            if (cVarE != null) {
                arrayList.add(cVarE);
            }
        }
        i(arrayList);
        f(arrayList);
    }

    public final c e(d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.f31548b)) {
            C1139k.i("sla convert event is null", new Object[0]);
            return null;
        }
        C1130b c1130bL = C1130b.l();
        if (c1130bL == null) {
            C1139k.i("sla convert failed because ComInfoManager is null", new Object[0]);
            return null;
        }
        StringBuilder sb2 = new StringBuilder("&app_version=");
        sb2.append(c1130bL.f7422D);
        sb2.append("&app_name=");
        sb2.append(c1130bL.f7424F);
        sb2.append("&app_bundle_id=");
        sb2.append(c1130bL.f7453e);
        sb2.append("&client_type=android&user_id=");
        sb2.append(c1130bL.t());
        sb2.append("&sdk_version=");
        sb2.append(c1130bL.f7463j);
        sb2.append("&event_code=");
        sb2.append(dVar.f31548b);
        sb2.append("&event_result=");
        sb2.append(dVar.f31550d ? 1 : 0);
        sb2.append("&event_time=");
        sb2.append(this.f31539a.format(new Date(dVar.f31549c)));
        sb2.append("&event_cost=");
        sb2.append(dVar.f31551e);
        sb2.append("&device_id=");
        sb2.append(c1130bL.u());
        sb2.append("&debug=");
        sb2.append(c1130bL.f7444Z ? 1 : 0);
        sb2.append("&param_0=");
        sb2.append(dVar.f31552f);
        sb2.append("&param_1=");
        sb2.append(dVar.f31547a);
        sb2.append("&param_2=");
        sb2.append(c1130bL.f7462i0 ? "rqd" : "ext");
        sb2.append("&param_4=");
        sb2.append(c1130bL.r());
        String string = sb2.toString();
        if (!TextUtils.isEmpty(dVar.f31553g)) {
            string = string + "&param_3=" + dVar.f31553g;
        }
        C1139k.h("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", dVar.f31547a, dVar.f31548b, Long.valueOf(dVar.f31549c), Boolean.valueOf(dVar.f31550d), Long.valueOf(dVar.f31551e), dVar.f31552f, dVar.f31553g);
        String str = dVar.f31547a + l.DATE_SEPARATOR + dVar.f31548b;
        c cVar = new c();
        cVar.f31544a = str;
        cVar.f31545b = dVar.f31549c;
        cVar.f31546c = string;
        return cVar;
    }

    public final void f(List<c> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C1138j.a().b(new RunnableC0379a(list));
        } else {
            g(list);
        }
    }

    public a() {
        this.f31539a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.f31540b = new C1132d();
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f31547a;

        /* renamed from: b, reason: collision with root package name */
        public String f31548b;

        /* renamed from: c, reason: collision with root package name */
        public long f31549c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f31550d;

        /* renamed from: e, reason: collision with root package name */
        public long f31551e;

        /* renamed from: f, reason: collision with root package name */
        public String f31552f;

        /* renamed from: g, reason: collision with root package name */
        public String f31553g;

        public d(String str, String str2, long j10, boolean z10, long j11, String str3, String str4) {
            this.f31547a = str;
            this.f31548b = str2;
            this.f31549c = j10;
            this.f31550d = z10;
            this.f31551e = j11;
            this.f31552f = str3;
            this.f31553g = str4;
        }

        public d() {
        }
    }
}
