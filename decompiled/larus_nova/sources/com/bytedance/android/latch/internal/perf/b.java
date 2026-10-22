package com.bytedance.android.latch.internal.perf;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f58351a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f58352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f58353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f58354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i f58355d;

        public a() {
            this(0);
        }

        public a(int r100) {
            Intrinsics.checkNotNullParameter("", "methodName");
            this.f58352a = "";
            this.f58353b = -1;
            this.f58354c = -1;
            this.f58355d = null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.latch.internal.perf.b$b, reason: collision with other inner class name */
    public static final class RunnableC0928b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f58356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f58357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f58358c;

        public RunnableC0928b(b r100, String r101, i r102) {
            this.f58356a = r100;
            this.f58357b = r101;
            this.f58358c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = b.a(this.f58356a, this.f58357b);     // Catch: Throwable -> L4
            r100.f58355d = this.f58358c;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hx.a f58359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f58360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f58361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.latch.a.d f58362d;

        public c(hx.a r100, b r101, String r102, com.bytedance.android.latch.a.d r103) {
            this.f58359a = r100;
            this.f58360b = r101;
            this.f58361c = r102;
            this.f58362d = r103;
        }

        public final void a() {
            hx.a r100 = this.f58359a;
            if (r100 == null) goto L19;
            a r101 = this.f58360b.f58351a.remove(this.f58361c);
            if (r101 == null) goto L20;
            i r102 = r101.f58355d;
            if (r102 == null) goto L21;
            String r103 = r101.f58352a;
            long r104 = r101.f58354c;
            if (r104 <= 0) goto L12;
            int r105 = 0;
        L13:
            long r106 = r101.f58353b;
            Intrinsics.checkNotNullParameter(r103, "name");
            JSONObject r107 = new JSONObject();
            r107.put("status_code", r102.f58383a);
            r107.put("promise_status", r102.f58383a);
            r107.put("timeout_value", r102.f58386d);
            r107.put("jsb_status", r105);
            r107.put("jsb_name", r103);
            JSONObject r108 = new JSONObject();
            if (r104 <= 0) goto L16;
            long r109 = r104 - r106;
        L17:
            r108.put("jsb_cost", r109);
            r108.put("promise_cost", r102.f58385c - r102.f58384b);
            JSONObject r110 = new JSONObject();
            r110.put("jsb_start", r106);
            r110.put("jsb_end", r104);
            r110.put("promise_start", r102.f58384b);
            r110.put("promise_end", r102.f58385c);
            r100.b(this.f58362d, new com.bytedance.android.latch.internal.perf.a(r107, r108, r110));
            return;
        L16:
            r109 = -1;
            goto L17
        L12:
            r105 = 1;
            goto L13
        L21:
            return;
        L20:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b() {
        this.f58351a = new LinkedHashMap();
    }

    public static final a a(b r100, String r101) {
        a r102 = (a) ((LinkedHashMap) r100.f58351a).get(r101);
        if (r102 != null) goto L6;
        a r103 = new a(0);
        r100.f58351a.put(r101, r103);
        return r103;
    L6:
        return r102;
    }

    public final void b(String r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "callbackId");
        Intrinsics.checkNotNullParameter(r101, "promiseMetric");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new RunnableC0928b(this, r100, r101));
        return;
    L5:
        a(this, r100).f58355d = r101;
    }

    public final void c(com.bytedance.android.latch.a.d r110, String r111, hx.a r112) {
        Intrinsics.checkNotNullParameter(r110, "process");
        Intrinsics.checkNotNullParameter(r111, "callbackId");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new c(r112, this, r111, r110));
        return;
    L5:
        if (r112 == null) goto L22;
        a r113 = this.f58351a.remove(r111);
        if (r113 == null) goto L23;
        i r100 = r113.f58355d;
        if (r100 == null) goto L24;
        String r101 = r113.f58352a;
        long r102 = r113.f58354c;
        if (r102 <= 0) goto L14;
        int r103 = 0;
    L15:
        long r104 = r113.f58353b;
        Intrinsics.checkNotNullParameter(r101, "name");
        JSONObject r114 = new JSONObject();
        r114.put("status_code", r100.f58383a);
        r114.put("promise_status", r100.f58383a);
        r114.put("timeout_value", r100.f58386d);
        r114.put("jsb_status", r103);
        r114.put("jsb_name", r101);
        JSONObject r105 = new JSONObject();
        if (r102 <= 0) goto L18;
        long r106 = r102 - r104;
    L19:
        r105.put("jsb_cost", r106);
        r105.put("promise_cost", r100.f58385c - r100.f58384b);
        JSONObject r107 = new JSONObject();
        r107.put("jsb_start", r104);
        r107.put("jsb_end", r102);
        r107.put("promise_start", r100.f58384b);
        r107.put("promise_end", r100.f58385c);
        r112.b(r110, new com.bytedance.android.latch.internal.perf.a(r114, r105, r107));
        return;
    L18:
        r106 = -1;
        goto L19
    L14:
        r103 = 1;
        goto L15
    L24:
        return;
    L23:
        return;
    }
}
