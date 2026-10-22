package t1;

import A0.f;
import J2.c;
import L0.d;
import L0.e;
import android.text.TextUtils;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.zyql.common.utils.upload.TOSUploader;
import h2.RunnableC1484b;
import j0.AbstractC1591a;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a implements e {
    public static String h = AbstractC1591a.e;
    public static final Object i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static volatile a f6651j;

    /* renamed from: a, reason: collision with root package name */
    public volatile long f6652a;
    public volatile int b;
    public volatile boolean c;
    public volatile long d;
    public volatile JSONObject e;
    public final LinkedList f = new LinkedList();
    public volatile f g;

    public a() {
        d.f925a.a(this);
        f fVar = new f();
        fVar.b = new LinkedList();
        fVar.f72a = false;
        this.g = fVar;
    }

    public static a a() {
        if (f6651j == null) {
            synchronized (i) {
                try {
                    if (f6651j == null) {
                        f6651j = new a();
                    }
                } finally {
                }
            }
        }
        return f6651j;
    }

    public final void b(String str, String str2, boolean z10) {
        boolean z11;
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        SlardarConfigManagerImpl slardarConfigManagerImpl2;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty("core_exception_monitor") && !TextUtils.isEmpty(str)) {
            if (z10) {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("log_type", "log_exception");
                if (str2 != null) {
                    if (str2.length() > 10240) {
                        jSONObject.put("extraMessage", str2.substring(0, 10240));
                    } else {
                        jSONObject.put("extraMessage", str2);
                    }
                }
            }
            J2.d dVar = c.f865a;
            if (!dVar.e) {
                if (this.g != null) {
                    f fVar = this.g;
                    if (fVar.f72a) {
                        return;
                    }
                    synchronized (((LinkedList) fVar.b)) {
                        try {
                            if (((LinkedList) fVar.b).size() > 40) {
                                ((LinkedList) fVar.b).poll();
                            }
                            ((LinkedList) fVar.b).add(new b(str));
                        } finally {
                        }
                    }
                    return;
                }
                return;
            }
            boolean logTypeSwitch = (!dVar.e || (slardarConfigManagerImpl2 = dVar.d) == null) ? false : slardarConfigManagerImpl2.getLogTypeSwitch("core_exception_monitor");
            boolean serviceSwitch = (!dVar.e || (slardarConfigManagerImpl = dVar.d) == null) ? false : slardarConfigManagerImpl.getServiceSwitch(str2);
            if ((logTypeSwitch || serviceSwitch) && !this.c) {
                synchronized (i) {
                    int size = this.f.size();
                    z11 = size >= 20;
                    this.f.add(new b(str));
                    this.b = size + 1;
                }
                if (z11) {
                    this.f6652a = System.currentTimeMillis();
                    d.f925a.c(new RunnableC1484b(this, 6));
                    return;
                }
                return;
            }
            return;
            th.printStackTrace();
        }
    }

    @Override // L0.e
    public final void e(long j5) {
        try {
            if (this.g != null) {
                f fVar = this.g;
                if (!fVar.f72a) {
                    if (c.f865a.e) {
                        fVar.f72a = true;
                    }
                    d.f925a.c(new RunnableC1484b(fVar, 5));
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if ((jCurrentTimeMillis - this.f6652a > 1200000 && this.b > 0) || this.b > 20) {
                this.f6652a = System.currentTimeMillis();
                d.f925a.c(new RunnableC1484b(this, 6));
            }
            if (!this.c || jCurrentTimeMillis - this.d <= TOSUploader.EXPIRED_TIMES) {
                return;
            }
            this.c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
