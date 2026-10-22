package com.obric.aiagent.ttnet.interceptor;

import com.bytedance.retrofit2.b.c;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.obric.aiagent.ttnet.d;
import com.obric.aiagent.ttnet.e;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RequestRestrictPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f22262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.ttnet.b f22263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f22265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f22266e;

    /* JADX INFO: compiled from: RequestRestrictPolicy.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f22267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f22268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f22269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22270d;

        public a() {
            this(null, null, null, null, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22267a, r6.f22267a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f22268b, r6.f22268b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f22269c, r6.f22269c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f22270d, r6.f22270d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f22267a.hashCode() * 31) + this.f22268b.hashCode()) * 31) + this.f22269c.hashCode()) * 31) + this.f22270d.hashCode();
        }

        public String toString() {
            return "UserInfo(did=" + this.f22267a + ", uid=" + this.f22268b + ", flowDid=" + this.f22269c + ", flowUid=" + this.f22270d + ')';
        }

        public a(String r2, String r3, String r4, String r5) {
            o.e(r2, "did");
            o.e(r3, "uid");
            o.e(r4, "flowDid");
            o.e(r5, "flowUid");
            this.f22267a = r2;
            this.f22268b = r3;
            this.f22269c = r4;
            this.f22270d = r5;
        }

        public /* synthetic */ a(String r2, String r3, String r4, String r5, int r6, h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = "";
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = "";
        L14:
            this(r2, r3, r4, r5);
        }

        public final void a() {
            boolean r1 = true;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f22267a, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L6:
            String r4 = "";
            if (r0 == false) goto L16;
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L11;
            String r3 = r2.getFlowDid();
        L12:
            if (r3 != null) goto L14;
            r3 = "";
        L14:
            this.f22267a = r3;
            goto L16
        L11:
            r3 = null;
        L16:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f22268b, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L18;
            boolean r5 = true;
        L19:
            if (r5 == false) goto L22;
            this.f22268b = ITraceDepend.Companion.getUserID();
        L22:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f22269c, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L24;
            boolean r6 = true;
        L25:
            if (r6 == false) goto L31;
            String r7 = com.obric.aiagent.flow.applog.a.f18577a.d();
            if (r7 != null) goto L29;
            r7 = "";
        L29:
            this.f22269c = r7;
        L31:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f22270d, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L34;
            r1 = false;
        L34:
            if (r1 == false) goto L41;
            String r8 = com.obric.aiagent.flow.applog.a.f18577a.e();
            if (r8 == null) goto L39;
            r4 = r8;
        L39:
            this.f22270d = r4;
            return;
        L41:
            return;
        L24:
            r6 = false;
            goto L25
        L18:
            r5 = false;
            goto L19
        L5:
            r0 = false;
            goto L6
        }

        public final List<String> b() {
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{this.f22267a, this.f22269c, this.f22268b, this.f22270d}), Iterable.class, "com.obric.aiagent.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L12;
            Object r4 = r8.next();
            if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L4;
            r0.add(r4);
            goto L4
        L8:
            r5 = false;
            goto L9
        L12:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        }
    }

    public b(e r8, com.obric.aiagent.ttnet.b r9) {
        com.obric.aiagent.ttnet.b r10 = (com.obric.aiagent.ttnet.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.aiagent.ttnet.b.class, "com.obric.aiagent.plugin");
        o.e(r8, "config");
        o.e(r10, "manager");
        this.f22262a = r8;
        this.f22263b = r10;
        this.f22264c = "RequestRestrictPolicy";
        a r11 = new a(null, null, null, null, 15, null);
        r11.a();
        this.f22265d = r11;
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r12 = true;
    L9:
        this.f22266e = r12;
        return;
    L5:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L8;
        r12 = false;
        goto L9
    }

    public final boolean a(c r6) {
        o.e(r6, Ext.KEY_REQUEST);
        if (b() == true) goto L5;
        Iterator<d> r0 = this.f22262a.c().iterator();
    L10:
        if (r0.hasNext() == false) goto L17;
        if (((d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.aiagent.plugin")).a(r6) == false) goto L10;
        if (this.f22266e == false) goto L16;
        ILogDepend.Companion.i(this.f22264c, "exclude rule match.");
    L16:
        return true;
    L17:
        Iterator<d> r1 = this.f22263b.a().iterator();
    L19:
        if (r1.hasNext() == false) goto L26;
        if (((d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.aiagent.plugin")).a(r6) == false) goto L19;
        if (this.f22266e == false) goto L25;
        ILogDepend.Companion.i(this.f22264c, "rule match.");
    L25:
        return true;
    L26:
        return false;
    L5:
        if (this.f22266e == false) goto L7;
        ILogDepend.Companion.i(this.f22264c, "user match.");
    L7:
        return true;
    }

    public final boolean a() {
        if (this.f22266e == false) goto L6;
        ILogDepend.Companion.i(this.f22264c, "shouldRestrict " + com.obric.aiagent.utils.a.b.f22307a.a());
    L6:
        if (com.obric.aiagent.utils.a.b.f22307a.a() == false) goto L9;
        return false;
    L9:
        if (com.obric.aiagent.utils.a.b.f22307a.b() >= this.f22262a.a()) goto L11;
        return false;
    L11:
        return true;
    }

    private final boolean b() {
        this.f22265d.a();
        Iterator<String> r0 = this.f22265d.b().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (this.f22262a.b().contains(r1) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
