package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.amap.api.col.jmsl.C1602s0;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.n1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1584n1 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public Context f16774a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference<InterfaceC1552f1> f16775b;

    public C1584n1(Context context, InterfaceC1552f1 interfaceC1552f1) {
        this.f16775b = null;
        this.f16774a = context;
        this.f16775b = new WeakReference<>(interfaceC1552f1);
    }

    public final Pair<JSONObject, C1602s0.c.a> a(StringBuilder sb2) {
        String str;
        JSONObject jSONObject;
        C1602s0.c.a aVar;
        WeakReference<InterfaceC1552f1> weakReference;
        try {
            Object objB = r.b(this.f16774a, "cloud_config_pull", "cloud_config_pull_timestamp", 0L);
            long jLongValue = objB instanceof Long ? ((Long) objB).longValue() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - jLongValue) >= 86400000) {
                String string = sb2.toString();
                string.replaceAll(";;", Const.STR_MART_SEMICOLON);
                r.n(this.f16774a, "cloud_config_pull", "cloud_config_pull_timestamp", new Long(jCurrentTimeMillis));
                str = string;
            } else {
                str = "";
            }
            C1602s0.c cVarB = C1602s0.b(this.f16774a, C1570k.c(), str, null, false, "DEF_ID", null, null, null);
            if (C1602s0.f16864a != 1 && str != "" && (weakReference = this.f16775b) != null && weakReference.get() != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Key验证失败：[");
                String str2 = cVarB.f16894a;
                if (str2 != null) {
                    sb3.append(str2);
                } else {
                    sb3.append(C1602s0.f16865b);
                }
                sb3.append("]");
                Log.w("amapsdk", sb3.toString());
            }
            String str3 = r.a(this.f16774a).getAbsolutePath() + "/authCustomConfigName";
            if (TextUtils.isEmpty(str) || (jSONObject = cVarB.f16896c) == null) {
                jSONObject = new JSONObject(new String(r.o(str3)));
            } else {
                r.j(str3, jSONObject.toString().getBytes());
            }
            String str4 = r.a(this.f16774a).getAbsolutePath() + "/authLogConfigName";
            if (TextUtils.isEmpty(str) || cVarB.f16897d == null) {
                byte[] bArrO = r.o(str4);
                C1602s0.c.a aVar2 = new C1602s0.c.a();
                JSONObject jSONObject2 = new JSONObject(new String(bArrO));
                aVar2.f16898a = jSONObject2.getBoolean("IsExceptionUpdate");
                if (jSONObject2.has("mOfflineLoc")) {
                    aVar2.f16899b = jSONObject2.getJSONObject("mOfflineLoc");
                }
                aVar = aVar2;
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("IsExceptionUpdate", cVarB.f16897d.f16898a);
                jSONObject3.put("mOfflineLoc", cVarB.f16897d.f16899b);
                r.j(str4, jSONObject3.toString().getBytes());
                aVar = cVarB.f16897d;
            }
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void b(C1602s0.c.a aVar) {
        try {
            if (aVar == null) {
                if (C1623x1.f17030a) {
                    r.h("config|get ", "log json is null", 111);
                    return;
                }
                return;
            }
            boolean z10 = aVar.f16898a;
            if (C1623x1.f17030a) {
                r.h("config|get ", "isUploadLog is: " + z10, 111);
            }
            r.n(this.f16774a, "maploc", "ue", Boolean.valueOf(z10));
            JSONObject jSONObject = aVar.f16899b;
            int iOptInt = jSONObject.optInt(Const.SP_KEY_FILENUM, 1000);
            int iOptInt2 = jSONObject.optInt(Const.SP_KEY_MAX_POINT_NUM, 0);
            if (iOptInt2 > 500) {
                iOptInt2 = 500;
            }
            if (iOptInt2 < 30) {
                iOptInt2 = 30;
            }
            e3.b(iOptInt, C1602s0.u(jSONObject.optString(Const.SP_KEY_GSM_UPLOAD), false));
            if (C1623x1.f17030a) {
                r.h("config|get ", "maxpointnum is: " + iOptInt2, 111);
            }
            r.n(this.f16774a, "maploc", "opn", Integer.valueOf(iOptInt2));
        } catch (Throwable th) {
            C1541c2.b(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    @Override // java.lang.Thread
    public void interrupt() {
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        JSONObject jSONObjectOptJSONObject;
        WeakReference<InterfaceC1552f1> weakReference;
        Object obj;
        Object obj2;
        JSONObject jSONObjectOptJSONObject2;
        C1569j2 c1569j2C;
        Object obj3;
        JSONObject jSONObjectOptJSONObject3;
        Object obj4;
        JSONObject jSONObjectOptJSONObject4;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                C1607t1.a().b(this.f16774a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("11K");
                sb2.append(Const.STR_MART_SEMICOLON);
                sb2.append("154");
                sb2.append(Const.STR_MART_SEMICOLON);
                sb2.append("156");
                sb2.append(Const.STR_MART_SEMICOLON);
                sb2.append("17E");
                sb2.append(Const.STR_MART_SEMICOLON);
                sb2.append("18X");
                Pair<JSONObject, C1602s0.c.a> pairA = a(sb2);
                if (pairA != null && (obj4 = pairA.first) != null && (jSONObjectOptJSONObject4 = ((JSONObject) obj4).optJSONObject("154")) != null && C1602s0.u(jSONObjectOptJSONObject4.getString("able"), true)) {
                    String strOptString = jSONObjectOptJSONObject4.optString("mc");
                    String strOptString2 = jSONObjectOptJSONObject4.optString("si");
                    if (!TextUtils.isEmpty(strOptString)) {
                        r.n(this.f16774a, "approval_number", "mc", strOptString);
                    }
                    if (!TextUtils.isEmpty(strOptString2)) {
                        r.n(this.f16774a, "approval_number", "si", strOptString2);
                    }
                }
                if (pairA != null && (obj3 = pairA.first) != null && (jSONObjectOptJSONObject3 = ((JSONObject) obj3).optJSONObject("18X")) != null && C1602s0.u(jSONObjectOptJSONObject3.optString("able"), true)) {
                    String strOptString3 = jSONObjectOptJSONObject3.optString("version", "");
                    String strOptString4 = jSONObjectOptJSONObject3.optString("url", "");
                    int iOptInt = jSONObjectOptJSONObject3.optInt("reason", -1);
                    WeakReference<InterfaceC1552f1> weakReference2 = this.f16775b;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        this.f16775b.get().P(strOptString3, strOptString4, iOptInt);
                    }
                }
                if (pairA != null && pairA.second != null && (c1569j2C = C1570k.c()) != null) {
                    c1569j2C.c(((C1602s0.c.a) pairA.second).f16898a);
                }
                if (pairA != null) {
                    b((C1602s0.c.a) pairA.second);
                }
                if (pairA != null) {
                    try {
                        Object obj5 = pairA.first;
                        if (obj5 != null && (jSONObjectOptJSONObject = ((JSONObject) obj5).optJSONObject("14M")) != null && jSONObjectOptJSONObject.has("able") && C1602s0.u(jSONObjectOptJSONObject.getString("able"), true)) {
                            int iMax = jSONObjectOptJSONObject.has("time") ? Math.max(60, jSONObjectOptJSONObject.getInt("time")) : 2592000;
                            Object objB = r.b(this.f16774a, "Map3DCache", "time", 0L);
                            if (System.currentTimeMillis() - (objB instanceof Long ? ((Long) objB).longValue() : 0L) > iMax * 1000 && (weakReference = this.f16775b) != null && weakReference.get() != null) {
                                this.f16775b.get().O();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (pairA != null && (obj2 = pairA.first) != null && (jSONObjectOptJSONObject2 = ((JSONObject) obj2).optJSONObject("156")) != null) {
                    C1553f2.c(C1602s0.u(jSONObjectOptJSONObject2.optString("able"), false));
                }
                if (pairA != null && (obj = pairA.first) != null) {
                    try {
                        A.b(((JSONObject) obj).optJSONObject("17E"));
                    } catch (Throwable unused) {
                    }
                }
                C1541c2.e(this.f16774a, C1570k.c());
                super.interrupt();
                WeakReference<InterfaceC1552f1> weakReference3 = this.f16775b;
                if (weakReference3 == null || weakReference3.get() == null) {
                    return;
                }
                this.f16775b.get().l(false);
            }
        } catch (Throwable th2) {
            super.interrupt();
            C1541c2.b(th2, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th2.printStackTrace();
            A.a("[map][network]", "auth exception " + th2.getMessage());
        }
    }
}
