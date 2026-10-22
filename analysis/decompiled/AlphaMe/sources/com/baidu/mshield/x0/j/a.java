package com.baidu.mshield.x0.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.mshield.b.a.c;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.l;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f8431a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8432b;

    /* renamed from: com.baidu.mshield.x0.j.a$a, reason: collision with other inner class name */
    public class C0041a extends com.baidu.mshield.x0.d.h.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f8433b;

        public C0041a(b bVar) {
            this.f8433b = bVar;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            a.this.a(this.f8433b);
        }
    }

    public interface b {
        void a(int i4);
    }

    public a(Context context) {
        this.f8432b = context;
    }

    public final void b(JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("handleRmfPolicy:" + jSONObject);
            if (jSONObject == null) {
                l.f8522e = "";
                return;
            }
            boolean zA = f.a(this.f8432b, false);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f8432b);
            if (zA) {
                bVar.v(jSONObject.toString());
                l.f8522e = "";
            } else {
                l.f8522e = jSONObject.toString();
                bVar.p();
            }
            com.baidu.mshield.b.c.a.b("handleRmfPolicy ungz:".concat(new String(c.b(Base64.decode(jSONObject.optString("1").getBytes(), 0)), "utf-8")));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a a(Context context) {
        try {
            if (f8431a == null) {
                f8431a = new a(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8431a;
    }

    public final int a(b bVar) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(this.f8432b);
            long j4 = aVar.j();
            long jM = aVar.m() * 60000;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jM <= 0) {
                if (bVar != null) {
                    bVar.a(1);
                }
                return 1;
            }
            if (jCurrentTimeMillis - j4 >= jM) {
                boolean zA = d.n(this.f8432b) ? a() : false;
                aVar.c(jCurrentTimeMillis);
                if (zA) {
                    if (bVar != null) {
                        bVar.a(0);
                    }
                    return 0;
                }
            }
            if (bVar != null) {
                bVar.a(1);
            }
            return 1;
        } catch (Throwable th) {
            d.a(th);
            if (bVar != null) {
                bVar.a(2);
            }
            return 2;
        }
    }

    public final void b(String str) {
        try {
            com.baidu.mshield.b.c.a.b("handleFgPolicy:" + str);
            l.b(this.f8432b, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public int a(b bVar, boolean z4) {
        if (z4) {
            com.baidu.mshield.x0.d.h.d.b().a(new C0041a(bVar));
            return 0;
        }
        return a(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[Catch: all -> 0x0168, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0168, blocks: (B:6:0x0010, B:23:0x0052, B:27:0x0061, B:83:0x0162, B:79:0x0140, B:71:0x0126, B:63:0x010c, B:55:0x00db, B:51:0x00b7, B:43:0x00a0, B:35:0x0089, B:22:0x004d, B:80:0x0143, B:28:0x0075, B:30:0x007d, B:33:0x0083, B:56:0x00de, B:58:0x00e6, B:61:0x0106, B:72:0x0129, B:74:0x0131, B:77:0x0137, B:36:0x008c, B:38:0x0094, B:41:0x009a, B:52:0x00ba, B:64:0x010f, B:66:0x0117, B:69:0x011d, B:44:0x00a3, B:46:0x00ab, B:49:0x00b1), top: B:106:0x0010, inners: #0, #1, #3, #4, #6, #9, #10, #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean a() {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.j.a.a():boolean");
    }

    public final void a(JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("handleDrfPolicy:" + jSONObject);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f8432b);
            if (jSONObject == null) {
                l.f8521d = "";
                return;
            }
            l.f8521d = jSONObject.toString();
            com.baidu.mshield.b.c.a.b("handleDrfPolicy ungz:".concat(new String(c.b(Base64.decode(jSONObject.optString("1").getBytes(), 0)), "utf-8")));
            bVar.g(jSONObject.optString("2"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(com.baidu.mshield.x0.l.a aVar, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("5");
        if (jSONObjectOptJSONObject != null) {
            int iOptInt = jSONObjectOptJSONObject.optInt("1", 0);
            if (iOptInt == 0 && aVar.d()) {
                EngineImpl.getInstance(this.f8432b).unload();
            }
            aVar.b(iOptInt);
            aVar.f(jSONObjectOptJSONObject.optInt("9", 0));
            aVar.g(jSONObjectOptJSONObject.optInt("15", 3));
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2, String str3) {
        String str4;
        String strOptString;
        String strOptString2;
        int iOptInt;
        try {
            com.baidu.mshield.b.c.a.b("handleSecPolicy:" + jSONObject.toString());
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(this.f8432b);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("3");
            if (jSONObjectOptJSONObject != null) {
                str4 = "95";
                aVar.b("plc03", jSONObjectOptJSONObject.toString());
                com.baidu.mshield.b.c.a.b("3" + jSONObjectOptJSONObject);
            } else {
                str4 = "95";
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("15");
            if (jSONObjectOptJSONObject2 != null) {
                aVar.b("plc15", jSONObjectOptJSONObject2.toString());
                com.baidu.mshield.b.c.a.b("15" + jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("16");
            if (jSONObjectOptJSONObject3 != null) {
                aVar.b("plc16", jSONObjectOptJSONObject3.toString());
                com.baidu.mshield.b.c.a.b("16" + jSONObjectOptJSONObject3);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("18");
            if (jSONObjectOptJSONObject4 != null) {
                aVar.b("plc18", jSONObjectOptJSONObject4.toString());
                com.baidu.mshield.b.c.a.b("18" + jSONObjectOptJSONObject4);
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("20");
            if (jSONObjectOptJSONObject5 != null) {
                aVar.b("plc20", jSONObjectOptJSONObject5.toString());
                com.baidu.mshield.b.c.a.b("20" + jSONObjectOptJSONObject5);
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject(ANSIConstants.CYAN_FG);
            if (jSONObjectOptJSONObject6 != null) {
                aVar.b("plc36", jSONObjectOptJSONObject6.toString());
                com.baidu.mshield.b.c.a.b(ANSIConstants.CYAN_FG + jSONObjectOptJSONObject6);
            }
            JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("62");
            if (jSONObjectOptJSONObject7 != null) {
                aVar.b("plc62", jSONObjectOptJSONObject7.toString());
                com.baidu.mshield.b.c.a.b("62" + jSONObjectOptJSONObject7.toString());
            }
            JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("71");
            if (jSONObjectOptJSONObject8 != null) {
                aVar.b("plc71", jSONObjectOptJSONObject8.toString());
                com.baidu.mshield.b.c.a.b("71" + jSONObjectOptJSONObject8);
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("83");
            if (jSONObjectOptJSONObject9 != null) {
                aVar.b("plc83", jSONObjectOptJSONObject9.toString());
                com.baidu.mshield.b.c.a.b("83" + jSONObjectOptJSONObject9);
            }
            JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("84");
            if (jSONObjectOptJSONObject10 != null) {
                aVar.b("plc84", jSONObjectOptJSONObject10.toString());
                com.baidu.mshield.b.c.a.b("84" + jSONObjectOptJSONObject10);
            }
            JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("94");
            if (jSONObjectOptJSONObject11 != null) {
                aVar.b("plc94", jSONObjectOptJSONObject11.toString());
                com.baidu.mshield.b.c.a.b("94" + jSONObjectOptJSONObject11);
            }
            String str5 = str4;
            JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject(str5);
            if (jSONObjectOptJSONObject12 != null) {
                aVar.b("plc95", jSONObjectOptJSONObject12.toString());
                com.baidu.mshield.b.c.a.b(str5 + jSONObjectOptJSONObject12.toString());
            }
            JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("107");
            if (jSONObjectOptJSONObject13 != null) {
                aVar.b("plc107", jSONObjectOptJSONObject13.toString());
                com.baidu.mshield.b.c.a.b("107" + jSONObjectOptJSONObject13.toString());
                if (jSONObjectOptJSONObject13.has("5")) {
                    JSONObject jSONObjectOptJSONObject14 = jSONObjectOptJSONObject13.optJSONObject("5");
                    if (jSONObjectOptJSONObject14.has("t")) {
                        aVar.d(jSONObjectOptJSONObject14.optInt("t", Opcodes.GETFIELD));
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("51");
            if (jSONObjectOptJSONObject15 != null) {
                aVar.b("plc51", jSONObjectOptJSONObject15.toString());
                a(aVar, jSONObjectOptJSONObject15);
                com.baidu.mshield.b.c.a.b("51" + jSONObjectOptJSONObject15.toString());
            }
            JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("102");
            if (jSONObjectOptJSONObject16 != null) {
                aVar.b("plc102", jSONObjectOptJSONObject16.toString());
                int iOptInt2 = jSONObjectOptJSONObject16.optJSONObject("5").optInt("1", 60);
                aVar.c(iOptInt2);
                com.baidu.mshield.x0.g.a.f8418d = iOptInt2;
                com.baidu.mshield.b.c.a.b("102" + jSONObjectOptJSONObject16.toString());
            }
            JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("104");
            if (jSONObjectOptJSONObject17 != null) {
                aVar.b("plc104", jSONObjectOptJSONObject17.toString());
                com.baidu.mshield.b.c.a.b("104" + jSONObjectOptJSONObject17.toString());
            }
            JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("114");
            if (jSONObjectOptJSONObject18 != null) {
                com.baidu.mshield.b.c.a.b("114" + jSONObjectOptJSONObject18.toString());
                JSONObject jSONObjectOptJSONObject19 = jSONObjectOptJSONObject18.optJSONObject("5");
                if (jSONObjectOptJSONObject19.has("uv6") && jSONObjectOptJSONObject19.optJSONObject("uv6").has("2")) {
                    com.baidu.mshield.x0.c.a.f8368a = jSONObjectOptJSONObject19.optJSONObject("uv6").optString("2");
                    com.baidu.mshield.b.c.a.b("policy detect app encrypt===" + com.baidu.mshield.x0.c.a.f8368a);
                    jSONObjectOptJSONObject19.optJSONObject("uv6").remove("2");
                    com.baidu.mshield.b.c.a.b("policy detect encryptStr====" + com.baidu.mshield.x0.c.a.f8368a);
                    aVar.b("plc114", jSONObjectOptJSONObject18.toString());
                } else {
                    aVar.b("plc114", jSONObjectOptJSONObject18.toString());
                }
            }
            JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject("115");
            if (jSONObjectOptJSONObject20 != null) {
                String strC = aVar.c("plc115");
                String strOptString3 = "";
                if (TextUtils.isEmpty(strC)) {
                    strOptString = "";
                    strOptString2 = strOptString;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strC);
                    aVar.a(jSONObject2.optInt("3"));
                    JSONObject jSONObjectOptJSONObject21 = jSONObject2.optJSONObject("5");
                    strOptString2 = (jSONObjectOptJSONObject21.has("uv4") && jSONObjectOptJSONObject21.optJSONObject("uv4").has("2")) ? jSONObjectOptJSONObject21.optJSONObject("uv4").optString("2") : "";
                    strOptString = (jSONObjectOptJSONObject21.has("uv4") && jSONObjectOptJSONObject21.optJSONObject("uv4").has("4")) ? jSONObjectOptJSONObject21.optJSONObject("uv4").optString("4") : "";
                }
                com.baidu.mshield.b.c.a.b("115" + jSONObjectOptJSONObject20.toString());
                JSONObject jSONObjectOptJSONObject22 = jSONObjectOptJSONObject20.optJSONObject("5");
                if (jSONObjectOptJSONObject22.has("uv4")) {
                    JSONObject jSONObjectOptJSONObject23 = jSONObjectOptJSONObject22.optJSONObject("uv4");
                    if (jSONObjectOptJSONObject23.has("4")) {
                        strOptString3 = jSONObjectOptJSONObject23.optString("4");
                        aVar.e(strOptString3);
                    }
                    int i4 = 0;
                    if (jSONObjectOptJSONObject23.has("7")) {
                        int iOptInt3 = jSONObjectOptJSONObject23.optJSONObject("7").optInt("2", 0);
                        iOptInt = jSONObjectOptJSONObject23.optJSONObject("7").optInt("3", 0);
                        i4 = iOptInt3;
                    } else {
                        iOptInt = 0;
                    }
                    if (jSONObjectOptJSONObject23.has("2")) {
                        String strOptString4 = jSONObjectOptJSONObject23.optString("2");
                        if (i4 != 0 && !TextUtils.isEmpty(strOptString3)) {
                            if (TextUtils.isEmpty(strOptString4) && !TextUtils.isEmpty(strOptString3) && strOptString3.equals(strOptString)) {
                                jSONObjectOptJSONObject23.put("2", strOptString2);
                            }
                        } else {
                            com.baidu.mshield.x0.c.c.f8372a = strOptString4;
                            jSONObjectOptJSONObject23.remove("2");
                        }
                    }
                    if (!TextUtils.isEmpty(strOptString3) && !strOptString3.equals(strOptString) && iOptInt == 1) {
                        aVar.a(0L);
                    }
                    aVar.b("plc115", jSONObjectOptJSONObject20.toString());
                } else {
                    aVar.b("plc115", jSONObjectOptJSONObject20.toString());
                }
            }
            aVar.a(true);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(String str) {
        try {
            com.baidu.mshield.b.c.a.b("handleEmulatorSig:" + str);
            if (!TextUtils.isEmpty(str)) {
                String strA = e.a(str);
                l.f8520c = strA;
                new com.baidu.mshield.x6.b.b(this.f8432b).h(strA);
                String str2 = new String(c.b(Base64.decode(str.getBytes(), 0)), "utf-8");
                com.baidu.mshield.b.c.a.b("handleEmulatorSig ungz:".concat(str2));
                l.f8518a = str2;
            } else {
                f.c(this.f8432b);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
