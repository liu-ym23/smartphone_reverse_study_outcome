package com.baidu.lbsapi.auth;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f30445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap f30446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f30447c;

    public interface a {
        void a(Object r100);
    }

    public e(Context r100) {
        this.f30446b = null;
        this.f30447c = null;
        this.f30445a = r100;
    }

    public static /* synthetic */ Context a(e r100) {
        return r100.f30445a;
    }

    private HashMap a(HashMap r100) {
        HashMap r101 = new HashMap();
        Iterator r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = ((String) r102.next()).toString();
        r101.put(r103, (String) r100.get(r103));
        goto L4
    L6:
        return r101;
    }

    public static /* synthetic */ void a(e r100, String r101) {
        r100.a(r101);
    }

    private void a(String r100) {
        if (r100 != null) goto L19;
        r100 = "";
    L19:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L10
        if (r101.has("status") == true) goto L15;
        r101.put("status", -1);     // Catch: JSONException -> L10
    L15:
        a r102 = this.f30447c;
        if (r102 == null) goto L23;
        r102.a(r101.toString());
        return;
    L23:
        return;
    L10:
        r101 = new JSONObject();
        r101.put("status", -1);     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static /* synthetic */ HashMap b(e r100) {
        return r100.f30446b;
    }

    public void a(HashMap r100, String r101, int r102, String r110, String r111, a r112) {
        this.f30446b = a(r100);
        this.f30447c = r112;
        ThreadMethodProxy.start(new PthreadThreadV2(new f(this, r101, r102, r110, r111), "lbsapi/auth/e"));
    }
}
