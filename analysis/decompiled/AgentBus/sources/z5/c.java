package z5;

import c7.j;
import com.stepos.account.oauth.OAuthConstants;
import d7.a0;
import d7.e0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k5.t;
import m.x;
import org.json.JSONObject;
import q7.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final e f11808a;

    /* renamed from: b, reason: collision with root package name */
    public final t f11809b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11810c;

    /* renamed from: d, reason: collision with root package name */
    public final q5.t f11811d;

    /* renamed from: e, reason: collision with root package name */
    public final q5.t f11812e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f11813f;

    public c(e eVar, k5.g gVar, boolean z4, q5.t tVar) {
        k.e(gVar, "logger");
        this.f11808a = eVar;
        this.f11809b = gVar;
        this.f11810c = z4;
        this.f11811d = tVar;
        this.f11812e = new q5.t(3);
        this.f11813f = ConcurrentHashMap.newKeySet();
    }

    public static e7.g a(String str, String str2, i iVar) {
        e7.g gVar = new e7.g();
        gVar.put("msg_type", str);
        gVar.put("agent_id", iVar.f11822b);
        gVar.put("session_id", str2);
        return gVar.c();
    }

    public static void e(c cVar, g gVar, boolean z4, String str, String str2, int i2) {
        String str3 = (i2 & 4) != 0 ? null : str;
        int i10 = z4 ? 200 : 500;
        String str4 = (i2 & 16) != 0 ? null : str2;
        cVar.getClass();
        e eVar = cVar.f11808a;
        String str5 = gVar.f11819e;
        String str6 = gVar.f11818d;
        String str7 = gVar.f11817c;
        if (cVar.f11810c) {
            String str8 = gVar.f11815a;
            String str9 = str8.length() > 0 ? str8 : null;
            if (str9 == null) {
                return;
            }
            String str10 = gVar.f11816b;
            if (z4) {
                d.reportEvent$default(eVar, str9, "agent_bus_toolcall", n("downlink", "", str10, str7), m(str7), null, str3 == null ? "" : str3, OAuthConstants.RESPONSE_CODE_OK, 16, null);
                h hVar = h.INFO;
                if (str3 == null) {
                    str3 = "";
                }
                d.reportLog$default(eVar, str9, "agent_bus_toolcall", hVar, "tool_node_invoke_result", x.n(a1.a.p("tool=", str6, " toolCallId=", str7, " command="), str5, " ok=true result=", ga.k.L0(OAuthConstants.RESPONSE_CODE_OK, str3)), null, 0, 96, null);
                return;
            }
            if (str4 != null) {
                str3 = str4;
            } else if (str3 == null) {
                str3 = "node_invoke_failed";
            }
            String str11 = str9;
            d.reportEvent$default(eVar, str11, "agent_bus_toolcall", e0.W(n("downlink", "", str10, str7), e0.U(new j("status_code", Integer.valueOf(i10)), new j("status_message", str3))), m(str7), null, null, i10, 48, null);
            d.reportLog$default(eVar, str11, "agent_bus_toolcall", h.ERROR, "tool_node_invoke_result", x.n(a1.a.p("tool=", str6, " toolCallId=", str7, " command="), str5, " ok=false error=", str3), null, i10, 32, null);
        }
    }

    public static void i(c cVar, String str, String str2, String str3, String str4, String str5) {
        cVar.getClass();
        e eVar = cVar.f11808a;
        k.e(str3, "toolCallId");
        if (cVar.f11810c && str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str == null) {
                return;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            String str6 = str;
            d.reportEvent$default(eVar, str6, "agent_bus_toolcall", e0.W(n("downlink", "", str2, str3), e0.U(new j("status_code", 500), new j("status_message", str5))), m(str3), null, null, 500, 48, null);
            h hVar = h.ERROR;
            StringBuilder sbP = a1.a.p("tool=", str4, " toolCallId=", str3, " error=");
            sbP.append(str5);
            eVar.e(str6, "agent_bus_toolcall", hVar, "tool_exec_failed", sbP.toString(), null, 500);
        }
    }

    public static Map m(String str) {
        return str.length() == 0 ? a0.f2944f : e0.T(new j("tool_call_id", str));
    }

    public static Map n(String str, String str2, String str3, String str4) {
        return e0.U(new j("msg_type", str), new j("agent_id", str2), new j("session_id", str3), new j("msg_id", str4));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(z5.i r4, java.util.Map r5, boolean r6) {
        /*
            r3 = this;
            java.lang.String r0 = "metadata"
            java.lang.Object r0 = r5.get(r0)
            boolean r1 = r0 instanceof java.util.Map
            r2 = 0
            if (r1 == 0) goto Le
            java.util.Map r0 = (java.util.Map) r0
            goto Lf
        Le:
            r0 = r2
        Lf:
            if (r0 != 0) goto L13
            d7.a0 r0 = d7.a0.f2944f
        L13:
            java.lang.String r1 = "runId"
            java.lang.Object r0 = r0.get(r1)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L20
            java.lang.String r0 = (java.lang.String) r0
            goto L21
        L20:
            r0 = r2
        L21:
            if (r0 == 0) goto L2d
            int r1 = r0.length()
            if (r1 <= 0) goto L2a
            goto L2b
        L2a:
            r0 = r2
        L2b:
            if (r0 != 0) goto L40
        L2d:
            java.lang.String r0 = "replyTo"
            java.lang.Object r5 = r5.get(r0)
            boolean r0 = r5 instanceof java.lang.String
            if (r0 == 0) goto L3a
            r2 = r5
            java.lang.String r2 = (java.lang.String) r2
        L3a:
            if (r2 != 0) goto L3f
            java.lang.String r0 = ""
            goto L40
        L3f:
            r0 = r2
        L40:
            java.lang.String r4 = r4.f11821a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "runId="
            r5.<init>(r1)
            r5.append(r0)
            java.lang.String r0 = " streaming=false error="
            r5.append(r0)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "claw_downlink_complete"
            r3.k(r4, r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.c.b(z5.i, java.util.Map, boolean):void");
    }

    public final void c(String str, String str2, String str3) {
        if (this.f11810c) {
            if (str3 == null) {
                str3 = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            k(str, "cloud_send_plain", a1.a.k("frameId=", str3, " method=", str2));
        }
    }

    public final void d(g gVar, String str) {
        String str2 = gVar.f11815a;
        k.e(str, "localInvocationId");
        if (this.f11810c && str2.length() != 0) {
            l(str2, gVar.f11816b, gVar.f11817c, gVar.f11818d, gVar.f11820f, "tool_node_invoke_request", a1.a.k("command=", gVar.f11819e, " localInvocationId=", str));
        }
    }

    public final void f(String str, String str2, String str3, boolean z4) {
        if (this.f11810c) {
            if (str2 == null) {
                str2 = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            StringBuilder sbP = a1.a.p("frameId=", str2, " method=", str3, " allowed=");
            sbP.append(z4);
            k(str, "privacy_guard_end", sbP.toString());
        }
    }

    public final void g(String str, String str2, String str3, boolean z4) {
        if (this.f11810c) {
            if (str3 == null) {
                str3 = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            StringBuilder sbP = a1.a.p("frameId=", str3, " method=", str2, " encrypted=");
            sbP.append(z4);
            k(str, "secure_data_wire_end", sbP.toString());
        }
    }

    public final void h(String str, String str2, String str3, String str4) {
        k.e(str2, "toolCallId");
        k.e(str3, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (this.f11810c && str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            String str5 = str;
            if (str5 == null) {
                return;
            }
            this.f11808a.e(str5, "agent_bus_toolcall", h.ERROR, "tool_callback_failed", a1.a.k("toolCallId=", str2, " callback failed: ", str3), str4, 500);
        }
    }

    public final void j(String str, String str2, String str3, String str4, String str5) {
        k.e(str3, "toolCallId");
        if (this.f11810c && str != null) {
            String str6 = null;
            String str7 = str.length() > 0 ? str : null;
            if (str7 == null) {
                return;
            }
            if (str2 != null && str2.length() > 0) {
                str6 = str2;
            }
            if (str6 == null) {
                str6 = "";
            }
            Map mapN = n("downlink", "", str6, str3);
            Map mapM = m(str3);
            e eVar = this.f11808a;
            d.reportEvent$default(eVar, str7, "agent_bus_toolcall", mapN, mapM, null, str5, OAuthConstants.RESPONSE_CODE_OK, 16, null);
            d.reportLog$default(eVar, str7, "agent_bus_toolcall", h.INFO, "tool_exec_success", x.n(a1.a.p("tool=", str4, " toolCallId=", str3, " sessionId="), str6, " ok result=", ga.k.L0(OAuthConstants.RESPONSE_CODE_OK, str5)), null, 0, 96, null);
        }
    }

    public final void k(String str, String str2, String str3) {
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            String str4 = str;
            if (str4 == null) {
                return;
            }
            h hVar = h.INFO;
            String string = new JSONObject().put("phase", str2).put("detail", str3).toString();
            k.d(string, "toString(...)");
            d.reportLog$default(this.f11808a, str4, "agent_bus", hVar, str2, string, null, 0, 96, null);
        }
    }

    public final void l(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.f11810c && str != null) {
            String str8 = null;
            String str9 = str.length() > 0 ? str : null;
            if (str9 == null) {
                return;
            }
            if (str2 != null && str2.length() > 0) {
                str8 = str2;
            }
            if (str8 == null) {
                str8 = "";
            }
            Map mapN = n("uplink", "", str8, str3);
            Map mapM = m(str3);
            String strX = a1.a.x(str4, ": ", str5);
            e eVar = this.f11808a;
            d.reportEvent$default(eVar, str9, "agent_bus_toolcall", mapN, mapM, strX, null, OAuthConstants.RESPONSE_CODE_OK, 32, null);
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sbP = a1.a.p("tool=", str4, " toolCallId=", str3, " sessionId=");
            sbP.append(str8);
            sb2.append(sbP.toString());
            if (str7 != null && !ga.k.t0(str7)) {
                sb2.append(' ');
                sb2.append(str7);
            }
            d.reportLog$default(eVar, str9, "agent_bus_toolcall", h.INFO, str6, sb2.toString(), null, 0, 96, null);
        }
    }
}
