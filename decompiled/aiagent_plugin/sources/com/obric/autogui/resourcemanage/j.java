package com.obric.autogui.resourcemanage;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Set;

/* JADX INFO: compiled from: RequestPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<k> f30626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f30627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f30628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f30629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f30630e;
    private final l f;
    private volatile d.h.a.a<m> g;

    public j() {
        this(null, 0, 0, false, false, 31, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f30626a, r10.f30626a) == true) goto L12;
        return false;
    L12:
        if (this.f30627b == r10.f30627b) goto L15;
        return false;
    L15:
        if (this.f30628c == r10.f30628c) goto L18;
        return false;
    L18:
        if (this.f30629d == r10.f30629d) goto L21;
        return false;
    L21:
        if (this.f30630e == r10.f30630e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f30626a.hashCode() * 31) + Long.hashCode(this.f30627b)) * 31) + Long.hashCode(this.f30628c)) * 31) + Boolean.hashCode(this.f30629d)) * 31) + Boolean.hashCode(this.f30630e);
    }

    public String toString() {
        return "RequestPolicy(allowedScenes=" + this.f30626a + ", minIntervalMs=" + this.f30627b + ", failureBackoffMs=" + this.f30628c + ", requireNetworkOn=" + this.f30629d + ", requireWifi=" + this.f30630e + ')';
    }

    public j(Set<? extends k> r3, long r4, long r6, boolean r8, boolean r9) {
        Set<k> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "allowedScenes");
        this.f30626a = r5;
        this.f30627b = r4;
        this.f30628c = r6;
        this.f30629d = r8;
        this.f30630e = r9;
        this.f = new l();
    }

    public /* synthetic */ j(Set r6, long r7, long r9, boolean r11, boolean r12, int r13, d.h.b.h r14) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if ((r13 & 1) == 0) goto L6;
        r8 = ax.a(new k[]{k.f30631a, k.f30632b, k.f30633c, k.f30634d, k.f30635e, k.f, k.g, k.h});
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = com.obric.autogui.resourcemanage.a.a.f30587a.a();
    L8:
        long r1 = r7;
        if ((r13 & 4) == 0) goto L11;
        r9 = 300000;
    L11:
        long r3 = r9;
        if ((r13 & 8) == 0) goto L14;
        boolean r15 = true;
    L16:
        if ((r13 & 16) != 0) goto L19;
        r0 = r12;
    L19:
        this(r8, r1, r3, r15, r0);
        return;
    L14:
        r15 = r11;
        goto L16
    }

    public final j a(d.h.a.a<m> r4) {
        d.h.a.a<m> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "provider");
        ((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin")).g = r5;
        return (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");
    }

    public final m a() {
        d.h.a.a<m> r0 = this.g;
        if (r0 == null) goto L7;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r0.invoke(), m.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new m(this.f30627b, this.f30628c);
    }

    public final boolean a(Context r19, v r20, k r21) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r20, "requestParams");
        d.h.b.o.e(r21, DBHelper.BATTERY_COL_SCENE);
        if (r21 == k.f30632b) goto L11;
        if (this.f30626a.contains(r21) == true) goto L11;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L9;
        Loog.INSTANCE.d("resource_downloader", "validateRequestStrategy: scene=" + r21 + " not allowed, key=" + r20.b());
    L9:
        return false;
    L11:
        if (this.f30629d == false) goto L19;
        if (g.f30624a.a(r3) == true) goto L19;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L17;
        Loog.INSTANCE.d("resource_downloader", "validateRequestStrategy: network off, key=" + r20.b());
    L17:
        return false;
    L19:
        if (this.f30630e == false) goto L27;
        if (g.f30624a.b(r3) == true) goto L27;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L25;
        Loog.INSTANCE.d("resource_downloader", "validateRequestStrategy: validated unmetered wifi required, key=" + r20.b());
    L25:
        return false;
    L27:
        if (r21 != k.f30632b) goto L29;
        m r4 = null;
    L31:
        if (r21 != k.f30632b) goto L33;
    L47:
        String r5 = "resource_downloader";
    L49:
        if (r21 == k.f30632b) goto L64;
        long r6 = System.currentTimeMillis();
        long r12 = d.f30616a.b(r20);
        if (r4 == null) goto L62;
        long r14 = r4.b();
        if (r14 <= 0) goto L64;
        if ((r6 - r12) >= r14) goto L64;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L82;
        Loog.INSTANCE.d(r5, "validateRequestStrategy: config failure backoff, key=" + r20.b() + ", lastAttempt=" + r12 + ", now=" + r6 + ", intervalMs=" + r14);
        return false;
    L82:
        return false;
    L62:
        throw new IllegalStateException("Required value was null.".toString());
    L64:
        if (this.f.a(r20.b()) == false) goto L66;
        d.f30616a.a(r20, System.currentTimeMillis());     // Catch: Exception -> L73
        return true;
    L73:
        e = move-exception;
        this.f.b(r20.b());
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L84;
        Loog.INSTANCE.d(r5, "validateRequestStrategy: persist attempt failed, key=" + r20.b() + ", error=" + e);
        return false;
    L84:
        return false;
    L66:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L83;
        Loog.INSTANCE.d(r5, "validateRequestStrategy: request already in progress, key=" + r20.b());
        return false;
    L83:
        return false;
    L33:
        if (r21 == k.g) goto L47;
        long r13 = System.currentTimeMillis();
        long r15 = d.f30616a.a(r20);
        if (r4 == null) goto L46;
        r5 = "resource_downloader";
        long r7 = r4.a();
        if (r7 <= 0) goto L49;
        if ((r13 - r15) >= r7) goto L49;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L81;
        Loog.INSTANCE.d(r5, "validateRequestStrategy: short interval, key=" + r20.b() + ", last=" + r15 + ", now=" + r13 + ", intervalMs=" + r7);
        return false;
    L81:
        return false;
    L46:
        throw new IllegalStateException("Required value was null.".toString());
    L29:
        r4 = a();
        goto L31
    }

    public final void a(v r3) {
        d.h.b.o.e(r3, "requestParams");
        this.f.b(r3.b());
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L6;
        Loog.INSTANCE.d("resource_downloader", "Request for PKG " + r3.a() + " completed, key=" + r3.b());
        return;
    }
}
