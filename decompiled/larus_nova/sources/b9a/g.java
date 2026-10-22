package b9a;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends a9a.a implements h9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f18357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18358c;

    @Override // a9a.a
    public final String f() {
        return CloudControlInf.HEAP_OOM;
    }

    @Override // h9a.a
    public final List<String> a() {
        ArrayList r100 = new ArrayList(1);
        PolarisFileWrapper r101 = this.f18357b;
        if (r101 == null) goto L5;
        r100.add(r101.getAbsolutePath());
    L5:
        return r100;
    }

    public g() {
        this.f18357b = null;
        this.f18358c = 0;
    }

    @Override // a9a.a
    public final boolean g(z8a.a r100) throws Exception {
        JSONObject r101 = new JSONObject(r100.f570965a);
        if (a9a.a.e(r101, r100) == false) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - this.f18358c) >= 300000) goto L8;
        return false;
    L8:
        this.f18358c = System.currentTimeMillis();
        boolean r102 = r101.optBoolean("isTryToCatch", false);
        String r103 = x8a.c.f562941l;
        String r104 = "本地未设置dumpFileName";
        if (TextUtils.isEmpty(r103) == false) goto L12;
        a9a.a.h("本地未设置dumpFileName", r100);
        return true;
    L12:
        if (r102 == true) goto L30;
    L17:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103);
        if (TextUtils.isEmpty(r103) == true) goto L22;
        r104 = null;
    L22:
        if (r105.exists() == true) goto L25;
        r104 = "dumpFile不存在";
    L25:
        if (TextUtils.isEmpty(r104) == true) goto L28;
        a9a.a.h(r104, r100);
        return true;
    L28:
        this.f18357b = r105;
        i9a.a r106 = new i9a.a("log_heap_oom", r100.f570967c, this, null);
        r106.f488815k = true;
        g9a.a.b(r106);
        return true;
    L30:
        Debug.dumpHprofData(r103);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
