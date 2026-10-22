package x;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import e1.C1403b;
import fa.C1449a;
import h2.RunnableC1484b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class i {
    public static final String i = i.class.getSimpleName().concat("#");

    /* renamed from: j, reason: collision with root package name */
    public static final ArrayList f6863j = new ArrayList();
    public final j b;
    public final boolean c;
    public final h2.d d;
    public final Context e;
    public HashMap g;
    public Long h;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f6864a = new ReentrantLock();
    public final AtomicBoolean f = new AtomicBoolean(false);

    public i(Context context) throws IOException {
        j hVar;
        boolean zContains = false;
        this.e = context.getApplicationContext();
        if (S0.b.D0()) {
            hVar = new C1449a(new p());
        } else if (p.b != null && p.f6868a != null && p.c != null) {
            hVar = new p();
        } else if (((Boolean) k.f6865a.b(new Object[0])).booleanValue()) {
            hVar = new k();
        } else {
            String str = Build.MANUFACTURER;
            if ((str == null ? "" : str.trim()).toUpperCase().contains("HUAWEI") || S0.b.R0()) {
                hVar = new M0.h(10);
            } else if ("OnePlus".equalsIgnoreCase(str)) {
                hVar = new C1449a((p) null);
            } else {
                String str2 = Build.BRAND;
                if (str2 == null ? false : str2.toLowerCase(Locale.ENGLISH).contains("meizu")) {
                    a5.d dVar = new a5.d(9);
                    dVar.b = new d(3);
                    hVar = dVar;
                } else {
                    if ("samsung".equalsIgnoreCase(str2) || "samsung".equalsIgnoreCase(str)) {
                        hVar = new b("com.samsung.android.deviceidservice", 3);
                    } else {
                        if ((str == null ? "" : str.trim()).toUpperCase().contains("NUBIA")) {
                            hVar = new C1403b(10);
                        } else {
                            String str3 = Build.FINGERPRINT;
                            if (TextUtils.isEmpty(str3)) {
                                String strN = S0.b.n("ro.build.version.incremental");
                                if (!TextUtils.isEmpty(strN) && strN.contains("VIBEUI_V2")) {
                                    zContains = true;
                                }
                            } else {
                                zContains = str3.contains("VIBEUI_V2");
                            }
                            if (zContains) {
                                hVar = new b("com.zui.deviceidservice", 2);
                            } else {
                                hVar = (str != null ? str.trim() : "").toUpperCase().contains("ASUS") ? new b("com.asus.msa.SupplementaryDID", 0) : new b("com.mdid.msa", 1);
                            }
                        }
                    }
                }
            }
        }
        this.b = hVar;
        this.c = hVar.g(context);
        this.d = new h2.d(context, 12);
    }

    public static void b(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static Object[] c() {
        Object[] array;
        ArrayList arrayList = f6863j;
        synchronized (arrayList) {
            try {
                array = arrayList.size() > 0 ? arrayList.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array;
    }

    public final void a() {
        if (this.f.compareAndSet(false, true)) {
            RunnableC1484b runnableC1484b = new RunnableC1484b(this, 10);
            String strQ = B7.a.q(new StringBuilder(), i, "-query");
            if (TextUtils.isEmpty(strQ)) {
                strQ = "TrackerDr";
            }
            new Thread(new RunnableC1484b(runnableC1484b, 9), strQ).start();
        }
    }
}
