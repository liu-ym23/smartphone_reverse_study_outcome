package b9a;

import com.bytedance.apm.util.w;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends a9a.a implements h9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f18365b;

    @Override // a9a.a
    public final String f() {
        return CloudControlInf.NET_FLOW;
    }

    @Override // h9a.a
    public final List<String> a() {
        ArrayList r100 = new ArrayList();
        PolarisFileWrapper r101 = this.f18365b;
        if (r101 == null) goto L5;
        r100.add(r101.getAbsolutePath());
    L5:
        return r100;
    }

    public i() {
        this.f18365b = null;
    }

    @Override // a9a.a
    public final boolean g(z8a.a r110) throws Exception {
        JSONObject r100 = new JSONObject(r110.f570965a);
        if (a9a.a.e(r100, r110) == false) goto L5;
        return true;
    L5:
        long r101 = r100.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r102 = r101 * 1000;
        long r103 = 1000 * r100.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        long r104 = w.a(x8a.c.b().getContext(), r102, r103, 1);
        long r105 = w.a(x8a.c.b().getContext(), r102, r103, 0);
        JSONObject r106 = new JSONObject();
        r106.put("netStatsWifi", r104);     // Catch: JSONException -> L8
        r106.put("netStatsMobile", r105);     // Catch: JSONException -> L8
        r106.put("netStatsTotal", r105 + r104);     // Catch: JSONException -> L8
    L10:
        String r107 = com.monitor.cloudmessage.utils.a.e(x8a.c.b().getContext()).getAbsolutePath();
        String r108 = r107 + File.separator + "netFlow.txt";
        BufferedWriter r109 = null;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r107);     // Catch: Throwable -> L30 IOException -> L32
        if (r111.exists() == true) goto L14;
        r111.mkdirs();     // Catch: Throwable -> L30 IOException -> L32
    L14:
        PolarisFileWriterWrapper r112 = new PolarisFileWriterWrapper(r108);     // Catch: Throwable -> L30 IOException -> L32
    L74:
        BufferedWriter r113 = new BufferedWriter(r112);     // Catch: Throwable -> L26 IOException -> L28
        r113.write(r106.toString());     // Catch: Throwable -> L22 IOException -> L24
        r113.close();     // Catch: IOException -> L19
        r112.close();     // Catch: IOException -> L19
    L21:
        PolarisFileWrapper r114 = new PolarisFileWrapper(r108);
    L44:
        if (r114 != null) goto L47;
        a9a.a.h("网络流量信息文件生成失败", r110);
        return true;
    L47:
        this.f18365b = r114;
        g9a.a.b(new i9a.a("json", r110.f570967c, this, null));
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L24:
        e = e;
    L60:
        e.printStackTrace();     // Catch: Throwable -> L49
        if (r113 != null) goto L62;
    L39:
        if (r112 == null) goto L43;
        r112.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L43:
        r114 = null;
        goto L44
    L62:
        r113.close();     // Catch: IOException -> L37
    L49:
        th = move-exception;
        Throwable r115 = th;
        r109 = r113;
    L51:
        if (r109 != null) goto L64;
    L55:
        if (r112 == null) goto L76;
        r112.close();     // Catch: IOException -> L53
        throw r115;
    L53:
        e = move-exception;
        e.printStackTrace();
        throw r115;
    L76:
        throw r115;
    L64:
        r109.close();     // Catch: IOException -> L53
    L22:
        th = th;
        r109 = r113;
    L27:
        r115 = th;
        goto L51
    L28:
        e = e;
        r113 = null;
    L26:
        th = th;
    L32:
        e = e;
        r112 = null;
        r113 = null;
    L30:
        th = move-exception;
        r115 = th;
        r112 = null;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
