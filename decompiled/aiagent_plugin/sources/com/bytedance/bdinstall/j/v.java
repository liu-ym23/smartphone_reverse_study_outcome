package com.bytedance.bdinstall.j;

import android.util.Pair;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TicketGuardHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.bdinstall.i.a f6341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.bdinstall.i.b f6342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile String f6343c;

    public v() {
    }

    static /* synthetic */ com.bytedance.bdinstall.i.a a(v r0) {
        return r0.f6341a;
    }

    public void a(com.bytedance.bdinstall.i.b r3) {
        this.f6342b = (com.bytedance.bdinstall.i.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdinstall.i.b.class, "com.obric.aiagent.plugin");
    }

    public com.bytedance.bdinstall.i.b a() {
        return this.f6342b;
    }

    public void a(an r7, com.bytedance.bdinstall.i.c r8) {
        final com.bytedance.bdinstall.i.c r9 = (com.bytedance.bdinstall.i.c) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.bdinstall.i.c.class, "com.obric.aiagent.plugin");
        if (this.f6341a != null) goto L5;
        this.f6341a = (com.bytedance.bdinstall.i.a) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.bdinstall.ticket.TicketGuardAdapter", "com.obric.aiagent.plugin").getConstructor(new Class[]{an.class}).newInstance(new Object[]{r7}), com.bytedance.bdinstall.i.a.class, "com.obric.aiagent.plugin");
    L5:
        Future r6 = com.bytedance.bdinstall.w.a(new AnonymousClass1(this, r9));
        if (com.bytedance.bdinstall.i.f().d() <= 0) goto L8;
        long r10 = com.bytedance.bdinstall.i.f().d();
    L9:
        r6.get(r10, TimeUnit.MILLISECONDS);
        return;
    L8:
        r10 = 200;
        goto L9
    }

    public List<Pair<String, String>> a(String r2, boolean r3, boolean r4) {
        if (this.f6341a == null) goto L7;
        this.f6343c = UUID.randomUUID().toString();
        return this.f6341a.a(r2, r3, r4, this.f6343c);
    L7:
        return new ArrayList();
    }

    public List<Map<String, String>> a(long r9, String r11, String r12, boolean r13, List<Pair<String, String>> r14) {
        List<Pair<String, String>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.i.a r0 = this.f6341a;
        if (r0 == null) goto L7;
        return r0.a(r9, r11, r12, r13, r6, this.f6343c);
    L7:
        return new ArrayList();
    }

    public List<Pair<String, String>> a(String r1, String r2, String r3, boolean r4) {
        com.bytedance.bdinstall.i.a r0 = this.f6341a;
        if (r0 == null) goto L7;
        return r0.a(r1, r2, r3, r4);
    L7:
        return new ArrayList();
    }

    public void a(com.bytedance.bdinstall.e.a r6, com.bytedance.bdinstall.h.i r7, List<Map<String, String>> r8) {
        com.bytedance.bdinstall.h.i r9 = (com.bytedance.bdinstall.h.i) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.bdinstall.h.i.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L24;
        if (r9 != null) goto L6;
        return;
    L6:
        if (this.f6341a == null) goto L27;
        Map<String, String> r11 = null;
        if (r10 == null) goto L18;
        int r0 = 0;
    L12:
        if (r0 >= r10.size()) goto L18;
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(r10.get(r0), Map.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        r9.a("ticket", (String) ZeusTransformUtils.preCheckCast(r2.get("ticket"), String.class, "com.obric.aiagent.plugin"));
        r9.a("ts_sign", (String) ZeusTransformUtils.preCheckCast(r2.get("ts_sign"), String.class, "com.obric.aiagent.plugin"));
        com.bytedance.bdinstall.t.a("TicketGuard# parse ticketData by response " + r2);
        r11 = r2;
    L16:
        r0 = r0 + 1;
    L18:
        if (a() == null) goto L26;
        com.bytedance.bdinstall.t.a("TicketGuard# TicketParseResultCallback , " + r11);
        a().a(r11);
        return;
    L26:
        return;
    L27:
        return;
    }

    public String a(byte[] r1) {
        com.bytedance.bdinstall.i.a r0 = this.f6341a;
        if (r0 == null) goto L8;
        byte[] r2 = r0.a(r1);
        if (r2 != null) goto L7;
        return "";
    L7:
        return new String(r2);
    L8:
        return "";
    }

    public Map<String, Long> b() {
        com.bytedance.bdinstall.i.a r0 = this.f6341a;
        if (r0 == null) goto L7;
        return r0.a();
    L7:
        return new HashMap();
    }
}
