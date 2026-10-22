package com.baidu.xclient.gdid;

import android.content.Context;
import android.util.Base64;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f9499a;

    /* renamed from: b, reason: collision with root package name */
    public Context f9500b;

    public static c a() {
        if (f9499a == null) {
            synchronized (c.class) {
                try {
                    if (f9499a == null) {
                        f9499a = new c();
                    }
                } finally {
                }
            }
        }
        return f9499a;
    }

    public void b() {
        long jF = e.e().f();
        if (System.currentTimeMillis() - jF < e.e().g()) {
            return;
        }
        c();
    }

    public final void c() {
        String strB;
        try {
            if (com.baidu.xclient.gdid.j.d.a(this.f9500b) && com.baidu.mshield.b.e.a.d(this.f9500b) && (strB = new com.baidu.xclient.gdid.g.a(this.f9500b, null).b()) != null) {
                e.e().a(System.currentTimeMillis());
                if ("".equals(strB)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strB);
                e.e().a(jSONObject.optInt("1", 1));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("2");
                if (jSONObjectOptJSONObject != null) {
                    long jOptLong = jSONObjectOptJSONObject.optLong("j");
                    if (jOptLong >= 0) {
                        e.e().d(jOptLong * com.baidu.xclient.gdid.d.a.f9511a);
                    }
                    int iOptInt = jSONObjectOptJSONObject.optInt(ANSIConstants.ESC_END, -1);
                    if (iOptInt != -1) {
                        if (iOptInt == 1) {
                            e.e().a(true);
                        } else {
                            e.e().a(false);
                        }
                    }
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("e", -1);
                    if (iOptInt2 != -1) {
                        if (iOptInt2 == 1) {
                            e.e().b(true);
                        } else {
                            e.e().b(false);
                        }
                    }
                    int iOptInt3 = jSONObjectOptJSONObject.optInt(DateTokenConverter.CONVERTER_KEY, -1);
                    if (iOptInt3 == 1) {
                        e.e().c(true);
                    } else if (iOptInt3 == 0) {
                        e.e().c(false);
                    }
                    int iOptInt4 = jSONObjectOptJSONObject.optInt(IntegerTokenConverter.CONVERTER_KEY, -1);
                    if (iOptInt4 != -1) {
                        if (iOptInt4 == 1) {
                            e.e().g(true);
                        } else {
                            e.e().g(false);
                        }
                    }
                    int iOptInt5 = jSONObjectOptJSONObject.optInt("w", -1);
                    if (iOptInt5 != -1) {
                        if (iOptInt5 == 1) {
                            e.e().i(true);
                        } else {
                            e.e().i(false);
                        }
                    }
                    String strOptString = jSONObjectOptJSONObject.optString("p", "-1");
                    if (!strOptString.equals("-1")) {
                        e.e().f(strOptString);
                    }
                    e.e().b(Base64.encodeToString(jSONObjectOptJSONObject.toString().getBytes(), 1));
                    int iOptInt6 = jSONObjectOptJSONObject.optInt("o", -1);
                    if (iOptInt6 == 1) {
                        e.e().h(true);
                    } else if (iOptInt6 == 0) {
                        e.e().h(false);
                    }
                    int iOptInt7 = jSONObjectOptJSONObject.optInt("a", -1);
                    if (iOptInt7 == 1) {
                        e.e().j(true);
                    } else if (iOptInt7 == 0) {
                        e.e().j(false);
                    }
                    int iOptInt8 = jSONObjectOptJSONObject.optInt("t", -1);
                    if (iOptInt8 == 1) {
                        e.e().k(true);
                    } else if (iOptInt8 == 0) {
                        e.e().k(false);
                    }
                    int iOptInt9 = jSONObjectOptJSONObject.optInt("n", -1);
                    if (iOptInt9 == 1) {
                        e.e().l(true);
                    } else if (iOptInt9 == 0) {
                        e.e().l(false);
                    }
                    int iOptInt10 = jSONObjectOptJSONObject.optInt("h", -1);
                    if (iOptInt10 == 1) {
                        e.e().e(true);
                    } else if (iOptInt10 == 0) {
                        e.e().e(false);
                    }
                    int iOptInt11 = jSONObjectOptJSONObject.optInt("f", -1);
                    if (iOptInt11 == 1) {
                        e.e().f(true);
                    } else if (iOptInt11 == 0) {
                        e.e().f(false);
                    }
                    int iOptInt12 = jSONObjectOptJSONObject.optInt("aa", -1);
                    if (iOptInt12 == 1) {
                        e.e().d(true);
                    } else if (iOptInt12 == 0) {
                        e.e().d(false);
                    }
                }
                if (jSONObject.optJSONObject("6") != null) {
                    e.e().b(r0.optInt("1", 0) * com.baidu.xclient.gdid.d.a.f9511a);
                    e.e().f(r0.optInt("2", 0) * com.baidu.xclient.gdid.d.a.f9511a);
                    e.e().h(r0.optInt("4", 0) * com.baidu.xclient.gdid.d.a.f9511a);
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("7");
                if (jSONObjectOptJSONObject2 != null) {
                    e.e().e(jSONObjectOptJSONObject2.optInt("s", -1));
                    e.e().b(jSONObjectOptJSONObject2.optInt(DateTokenConverter.CONVERTER_KEY, -1));
                    e.e().c(jSONObjectOptJSONObject2.optInt("j", -1));
                    e.e().d(jSONObjectOptJSONObject2.optInt("c", -1));
                    e.e().f(jSONObjectOptJSONObject2.optInt("o", -1));
                }
                String strOptString2 = jSONObject.optString("5");
                if (e.e().j().equals(strOptString2)) {
                    return;
                }
                e.e().a(strOptString2);
                String strOptString3 = jSONObject.optString("3", "");
                String strOptString4 = jSONObject.optString("4", "");
                String strOptString5 = jSONObject.optString("8", "");
                e.e().d(strOptString3);
                e.e().e(strOptString4);
                e.e().g(strOptString5);
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public void a(Context context) {
        this.f9500b = context;
        b();
    }
}
