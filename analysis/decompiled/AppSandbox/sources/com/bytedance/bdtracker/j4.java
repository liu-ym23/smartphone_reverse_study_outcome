package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.event.EventBasicData;
import com.bytedance.applog.event.EventPolicy;
import com.bytedance.applog.event.IEventHandler;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j4 {
    public final e0 a;
    public final i4 b;

    public j4(e0 e0Var, i4 i4Var) {
        this.a = e0Var;
        this.b = i4Var;
    }

    public final EventPolicy a(IEventHandler iEventHandler, int i, String str, e4 e4Var, JSONObject jSONObject) {
        e4Var.h();
        String strE = e4Var.e();
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(strE)) {
            try {
                jSONObject2 = new JSONObject(strE);
            } catch (Throwable unused) {
                this.a.d.D.error(5, "Param:[{}] is not a json string", strE);
            }
        }
        if (jSONObject != null) {
            r.c(jSONObject, jSONObject2);
        }
        EventPolicy eventPolicyOnReceive = iEventHandler.onReceive(i, str, jSONObject2, new EventBasicData(e4Var));
        e4Var.o = jSONObject2;
        return eventPolicyOnReceive;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x020f A[Catch: all -> 0x0253, TryCatch #0 {all -> 0x0253, blocks: (B:104:0x0205, B:105:0x0209, B:107:0x020f, B:109:0x022e, B:110:0x023b, B:112:0x0247), top: B:121:0x0205 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0181 A[Catch: all -> 0x01f5, TryCatch #2 {all -> 0x01f5, blocks: (B:83:0x0177, B:84:0x017b, B:86:0x0181, B:88:0x018f, B:90:0x019b, B:91:0x01a9, B:93:0x01b5, B:94:0x01c1, B:96:0x01cd, B:98:0x01dd, B:100:0x01e9), top: B:125:0x0177 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.util.List<com.bytedance.bdtracker.e4> r17) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.j4.b(java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.bytedance.applog.event.IEventHandler r9, com.bytedance.bdtracker.e4 r10, boolean r11) {
        /*
            r8 = this;
            r0 = 1
            if (r10 == 0) goto L7f
            if (r9 == 0) goto L6c
            int r1 = r9.acceptType()
            boolean r2 = r10 instanceof com.bytedance.bdtracker.g4
            if (r2 == 0) goto L24
            r2 = 8
            boolean r1 = com.bytedance.applog.event.EventType.a(r1, r2)
            if (r1 == 0) goto L6c
            org.json.JSONObject r7 = r10.o
            r4 = 8
            java.lang.String r5 = "bav2b_click"
            r2 = r8
            r3 = r9
            r6 = r10
            com.bytedance.applog.event.EventPolicy r8 = r2.a(r3, r4, r5, r6, r7)
            r5 = r6
            goto L6e
        L24:
            r2 = r8
            r3 = r9
            r5 = r10
            boolean r8 = r5 instanceof com.bytedance.bdtracker.l4
            if (r8 == 0) goto L3a
            boolean r8 = com.bytedance.applog.event.EventType.a(r1, r0)
            if (r8 == 0) goto L6d
            r10 = r5
            com.bytedance.bdtracker.l4 r10 = (com.bytedance.bdtracker.l4) r10
            java.lang.String r8 = r10.u
            r1 = r2
            r2 = r3
            r3 = r0
            goto L65
        L3a:
            boolean r8 = r5 instanceof com.bytedance.bdtracker.o4
            if (r8 == 0) goto L51
            r8 = 4
            boolean r8 = com.bytedance.applog.event.EventType.a(r1, r8)
            if (r8 == 0) goto L6d
            org.json.JSONObject r6 = r5.o
            r1 = r2
            r2 = r3
            r3 = 4
            java.lang.String r4 = "bav2b_page"
        L4c:
            com.bytedance.applog.event.EventPolicy r8 = r1.a(r2, r3, r4, r5, r6)
            goto L6e
        L51:
            boolean r8 = r5 instanceof com.bytedance.bdtracker.p4
            if (r8 == 0) goto L6d
            r8 = 2
            boolean r9 = com.bytedance.applog.event.EventType.a(r1, r8)
            if (r9 == 0) goto L6d
            r10 = r5
            com.bytedance.bdtracker.p4 r10 = (com.bytedance.bdtracker.p4) r10
            java.lang.String r9 = r10.t
            r1 = r2
            r2 = r3
            r3 = r8
            r8 = r9
        L65:
            java.lang.String r4 = com.bytedance.bdtracker.r.a(r8)
            org.json.JSONObject r6 = r5.o
            goto L4c
        L6c:
            r5 = r10
        L6d:
            r8 = 0
        L6e:
            boolean r9 = r5 instanceof com.bytedance.bdtracker.m4
            if (r9 == 0) goto L79
            if (r11 == 0) goto L77
            com.bytedance.applog.event.EventPolicy r8 = com.bytedance.applog.event.EventPolicy.ACCEPT
            goto L79
        L77:
            com.bytedance.applog.event.EventPolicy r8 = com.bytedance.applog.event.EventPolicy.DENY
        L79:
            com.bytedance.applog.event.EventPolicy r9 = com.bytedance.applog.event.EventPolicy.DENY
            if (r8 != r9) goto L7f
            r8 = 0
            return r8
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.j4.a(com.bytedance.applog.event.IEventHandler, com.bytedance.bdtracker.e4, boolean):boolean");
    }

    public void a(List<e4> list) {
        try {
            for (e4 e4Var : list) {
                if ("eventv3".equals(e4Var.f())) {
                    l4 l4Var = (l4) e4Var;
                    i1 i1Var = this.a.d.c;
                    String str = l4Var.u;
                    String str2 = l4Var.s;
                    i1Var.onEventV3(str, str2 != null ? new JSONObject(str2) : null);
                    if (this.a.d.c.a()) {
                        this.a.d.c.eventJson(l4Var.u, l4Var.h());
                    }
                }
            }
        } catch (Throwable th) {
            this.a.d.D.debug(5, "Notify event observer failed", th);
        }
    }
}
