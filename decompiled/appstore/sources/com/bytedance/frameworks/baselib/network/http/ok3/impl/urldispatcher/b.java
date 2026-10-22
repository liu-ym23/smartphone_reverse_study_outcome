package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends BaseDispatchAction {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f7473s = "b";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7475p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7476q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map f7477r;

    static {
    }

    public b() {
        this.f7474o = 0;
        this.f7475p = 0;
        this.f7476q = 0;
        this.f7477r = new HashMap();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean e(JSONObject r10, String r11, long r12) {
        j(r10);
        String r13 = r10.optString("tag");
        int r14 = 0;
        if (TextUtils.isEmpty(r13) == true) goto L17;
        String[] r15 = r13.split(";");
        int r16 = r15.length;
        int r17 = 0;
    L5:
        if (r17 >= r16) goto L17;
        String r18 = r15[r17];
        ArrayList r19 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.e.b(r18, ",", "=", r19) == false) goto L16;
        Iterator r20 = r19.iterator();
    L11:
        if (r20.hasNext() == false) goto L16;
        Pair r21 = (Pair) r20.next();
        Set r22 = (Set) this.f7477r.get(r21.first);
        if (r22 != null) goto L15;
        r22 = new HashSet();
    L15:
        r22.add(r21.second);
        this.f7477r.put(r21.first, r22);
    L16:
        r17 = r17 + 1;
    L17:
        this.f7474o = r10.optInt("delay");
        JSONArray r23 = r10.optJSONArray("random");
        if (this.f7474o > 0) goto L37;
        if (r23 == null) goto L37;
        if (r23.length() == 2) goto L44;
        return false;
    L44:
        int r24 = r23.getInt(0);     // Catch: JSONException -> L28
        int r25 = r23.getInt(1);     // Catch: JSONException -> L26
    L31:
        if (r24 <= 0) goto L36;
        if (r25 <= 0) goto L36;
        if (r24 >= r25) goto L36;
        r14 = r24;
    L38:
        this.f7475p = r14;
        this.f7476q = r25;
        if (Logger.debug() == false) goto L41;
        Logger.d(f7473s, "initwithparam tnc tag map is " + this.f7477r);
    L41:
        return true;
    L36:
        return false;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        r25 = 0;
    L28:
        e = e;
        r24 = 0;
    L37:
        r25 = 0;
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BaseDispatchAction.DispatchResultEnum q(String r10, String r11, List r12) {
        Uri r13 = Uri.parse(r10);
        if (r13.getHost() == null) goto L59;
        if (i(r13) == false) goto L59;
        if (this.f7477r.isEmpty() == false) goto L15;
        r12.set(0, Integer.valueOf(r()));
        if (Logger.debug() == false) goto L13;
        Logger.d(f7473s, "tnc tag map is empty, result delay time is " + r12.get(0));
    L13:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
    L15:
        if (TTDelayStateManager.c() == true) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d(f7473s, "this action with tag is not enabled");
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if ("".equals(r11) == false) goto L24;
        r11 = "s=0;p=0";
    L24:
        HashMap r14 = new HashMap();
        ArrayList r15 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.e.b(r11, ";", "=", r15) == false) goto L27;
        Iterator r16 = r15.iterator();
    L30:
        if (r16.hasNext() == false) goto L32;
        Pair r17 = (Pair) r16.next();
        r14.put(r17.first, r17.second);
        goto L30
    L32:
        TTDelayStateManager.AppStartState r18 = TTDelayStateManager.AppStartState.NormalStart;
        String r19 = Integer.toString(r18.getValue());
        if (TTDelayStateManager.a() == r18) goto L35;
        r19 = Integer.toString(TTDelayStateManager.b().getValue());
    L35:
        r14.put("s", r19);
        Context r20 = g.l().b();
        if (r20 == null) goto L38;
        boolean r21 = com.bytedance.frameworks.baselib.network.http.util.f.e(r20);
    L39:
        r14.put("p", Integer.toString(!r21));
        if (Logger.debug() == false) goto L42;
        Logger.d(f7473s, "request tag string is " + r11);
    L42:
        BaseDispatchAction.DispatchResultEnum r22 = BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
        Iterator r23 = this.f7477r.entrySet().iterator();
    L44:
        if (r23.hasNext() == false) goto L52;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r14.get(r24.getKey());
        if (r25 == null) goto L47;
        if (((Set) r24.getValue()).contains(r25) == true) goto L44;
        r22 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        goto L52
    L47:
        r22 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L52:
        if (r22 != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L55;
        r12.set(0, Integer.valueOf(r()));
    L55:
        if (Logger.debug() == false) goto L57;
        String r26 = f7473s;
        Logger.d(r26, "match tag result is " + r22);
        Logger.d(r26, "will delay time is " + r12.get(0));
        Logger.d(r26, "request tag map is " + r14);
        Logger.d(r26, "tnc tag map is " + this.f7477r);
    L57:
        return r22;
    L38:
        r21 = 1;
        goto L39
    L27:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L59:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    }

    public final int r() {
        int r10 = this.f7474o;
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        if (this.f7475p < this.f7476q) goto L8;
        return 0;
    L8:
        return new Random().nextInt(this.f7476q - this.f7475p) + this.f7475p;
    }

    public BaseDispatchAction.DispatchResultEnum s(String r10, String r11, List r12) {
        Logger.d(f7473s, "take delay action");
        if (g() == true) goto L5;
    L9:
        r12.set(0, 0);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        return q(r10, r11, r12);
    }
}
