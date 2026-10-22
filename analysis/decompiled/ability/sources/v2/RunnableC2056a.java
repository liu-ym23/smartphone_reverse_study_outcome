package v2;

import S0.b;
import android.os.Handler;
import android.text.TextUtils;
import com.apm.insight.g;
import java.io.File;
import java.util.Map;
import n2.c;
import u1.d;
import z2.l;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC2056a implements Runnable {
    public static final A1.a d = new A1.a(18);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6767a;
    public final long b;
    public final /* synthetic */ int c;

    public RunnableC2056a(Handler handler, int i, long j5) {
        this.c = i;
        this.f6767a = handler;
        this.b = j5;
    }

    public static void a() {
        l.i().b(d, 100L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map mapM;
        String str;
        switch (this.c) {
            case 0:
                try {
                    mapM = g.a().m();
                } catch (Throwable unused) {
                    mapM = null;
                }
                try {
                    d.B().A(mapM, c.g());
                    break;
                } catch (Throwable unused2) {
                    return;
                }
            default:
                if (((String) g.e().b) != null) {
                    str = "[DeviceIdTask] did is done, stop check.";
                } else {
                    String strR = g.a().r();
                    if (TextUtils.isEmpty(strR) || "0".equals(strR)) {
                        long j5 = this.b;
                        Handler handler = this.f6767a;
                        if (j5 > 0) {
                            handler.postDelayed(this, j5);
                        } else {
                            handler.post(this);
                        }
                        str = "[DeviceIdTask] did is null, continue check.";
                    } else {
                        g.e().b = strR;
                        d dVarB = d.B();
                        dVarB.getClass();
                        try {
                            M.a.t(strR, (File) dVarB.c, false);
                        } catch (Throwable unused3) {
                        }
                        str = "[DeviceIdTask] did is " + strR;
                    }
                }
                b.N(str);
                break;
        }
    }
}
