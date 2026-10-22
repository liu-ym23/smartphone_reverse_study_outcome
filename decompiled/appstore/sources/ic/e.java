package ic;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.obric.matrix.sdk.network.InterfaceRequestListener;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f20559a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f20560b;

    static {
        f20559a = new e();
    }

    public e() {
    }

    public final d a() {
        d r10 = f20560b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("config");
        return null;
    }

    public final void b(Context r10, Application r11, String r12, d r13, List r14, InterfaceRequestListener r15) {
        q.g(r10, "context");
        q.g(r11, "application");
        q.g(r12, "host");
        q.g(r13, "config");
        long r16 = System.currentTimeMillis();
        Log.i("NetworkSDKInit", "init start, startTime: " + r16);
        f20559a.c(r13);     // Catch: Throwable -> L5
        k r17 = k.f20573a;     // Catch: Throwable -> L5
        r17.e(r10, r11);     // Catch: Throwable -> L5
        r17.j(r15);     // Catch: Throwable -> L5
        f.f20561a.c(r12, r14);     // Catch: Throwable -> L5
        Log.i("NetworkSDKInit", "init success, 初始化耗时: " + (System.currentTimeMillis() - r16) + " ms");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("NetworkSDKInit", "init failed, 初始化耗时: " + (System.currentTimeMillis() - r16) + " ms", th);
    }

    public final void c(d r10) {
        q.g(r10, "<set-?>");
        f20560b = r10;
    }
}
