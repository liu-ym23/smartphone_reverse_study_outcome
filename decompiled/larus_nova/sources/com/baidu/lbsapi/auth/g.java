package com.baidu.lbsapi.auth;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f30453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f30454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f30455c;

    public interface a {
        void a(Object r100);
    }

    public g(Context r100) {
        this.f30454b = null;
        this.f30455c = null;
        this.f30453a = r100;
    }

    public static /* synthetic */ List a(g r100) {
        return r100.f30454b;
    }

    private List a(HashMap r100, String[] r101) {
        ArrayList r102 = new ArrayList();
        if (r101 != null) goto L5;
    L14:
        HashMap r103 = new HashMap();
        Iterator r104 = r100.keySet().iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        String r105 = ((String) r104.next()).toString();
        r103.put(r105, (String) r100.get(r105));
        goto L16
    L18:
        r102.add(r103);
    L19:
        return r102;
    L5:
        if (r101.length <= 0) goto L14;
        int r106 = 0;
    L8:
        if (r106 >= r101.length) goto L19;
        HashMap r107 = new HashMap();
        Iterator r108 = r100.keySet().iterator();
    L11:
        if (r108.hasNext() == false) goto L13;
        String r109 = ((String) r108.next()).toString();
        r107.put(r109, (String) r100.get(r109));
        goto L11
    L13:
        r107.put("mcode", r101[r106]);
        r102.add(r107);
        r106 = r106 + 1;
        goto L8
    }

    public static /* synthetic */ void a(g r100, List r101, String r102, int r103, String r104, String r105) {
        r100.a(r101, r102, r103, r104, r105);
    }

    private void a(String r100) {
        if (r100 != null) goto L19;
        r100 = "";
    L19:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L10
        if (r101.has("status") == true) goto L15;
        r101.put("status", -1);     // Catch: JSONException -> L10
    L15:
        a r102 = this.f30455c;
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

    private void a(List r110, String r111, int r112, String r113, String r114) {
        b.a("syncConnect start Thread id = " + String.valueOf(ThreadMethodProxy.currentThread().getId()));
        if (r110 != null) goto L5;
    L44:
        b.c("syncConnect failed,params list is null or size is 0");
        return;
    L5:
        if (r110.size() == 0) goto L44;
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L9:
        if (r101 >= r110.size()) goto L25;
        b.a("syncConnect resuest " + r101 + "  start!!!");
        HashMap r102 = (HashMap) ListProtector.get(r110, r101);
        i r103 = new i(this.f30453a);
        if (r103.a() == false) goto L23;
        String r104 = r103.a(r102, r111, r112, r113, r114);
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        b.a("syncConnect resuest " + r101 + "  result:" + r104);
        r100.add(r104);
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L22
        if (r105.has("status") == false) goto L24;
        if (JSONObjectProtectorUtils.getInt(r105, "status") != 0) goto L24;
        b.a("auth end and break");     // Catch: JSONException -> L22
        a(r104);     // Catch: JSONException -> L22
        return;
    L24:
        b.a("syncConnect end");
        r101 = r101 + 1;
    L22:
        b.a("continue-------------------------------");
        goto L24
    L23:
        b.a("Current network is not available.");
        r100.add(ErrorMessage.a("Current network is not available."));
        goto L24
    L25:
        b.a("--iiiiii:" + r101 + "<><>paramList.size():" + r110.size() + "<><>authResults.size():" + r100.size());
        if (r110.size() > 0) goto L28;
        return;
    L28:
        if (r101 == r110.size()) goto L30;
        return;
    L30:
        if (r100.size() > 0) goto L32;
        return;
    L32:
        if (r101 != r100.size()) goto L59;
        int r106 = r101 - 1;
        if (r106 <= 0) goto L60;
        JSONObject r107 = new JSONObject((String) ListProtector.get(r100, r106));     // Catch: JSONException -> L41
        if (r107.has("status") == true) goto L38;
        return;
    L38:
        if (JSONObjectProtectorUtils.getInt(r107, "status") == 0) goto L62;
        b.a("i-1 result is not 0,return first result");     // Catch: JSONException -> L41
        a((String) ListProtector.get(r100, 0));     // Catch: JSONException -> L41
        return;
    L62:
        return;
    L41:
        e = move-exception;
        a(ErrorMessage.a("JSONException:" + e.getMessage()));
        return;
    L60:
        return;
    }

    public void a(HashMap r100, String[] r101, String r102, int r110, String r111, String r112, a r113) {
        this.f30454b = a(r100, r101);
        this.f30455c = r113;
        ThreadMethodProxy.start(new PthreadThreadV2(new h(this, r102, r110, r111, r112), "lbsapi/auth/g"));
    }
}
