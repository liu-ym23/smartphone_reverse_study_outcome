package com.obric.autoaction.vdplayer.a;

import android.content.ComponentName;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: VDPlayerDebugBridgeConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0605a f25176a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f25177d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f25179c;

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VDPlayerDebugBridgeConfig.kt */
    public static final class C0605a {
        public /* synthetic */ C0605a(h r1) {
            this();
        }

        private C0605a() {
        }

        public final a a() {
            return a.b();
        }

        public final a a(Intent r8) {
            String r0 = null;
            if (r8 == null) goto L7;
            ComponentName r1 = r8.getComponent();
            if (r1 == null) goto L7;
            String r2 = r1.getPackageName();
        L9:
            if (o.a(r2, "com.obric.autoaction.vdplayer.demo") == false) goto L11;
            boolean r3 = true;
            if (r8 == null) goto L28;
            String r4 = r8.getStringExtra("vd_debug_bridge_url");
            if (r4 == null) goto L28;
            String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r5 == null) goto L28;
            String r6 = d.o.o.c(r5, new char[]{'/'});
            if (r6 == null) goto L28;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L23;
            boolean r7 = true;
        L24:
            if (r7 == false) goto L26;
            r0 = r6;
        L26:
            if (r0 == null) goto L28;
        L29:
            if (r8 != null) goto L31;
        L33:
            boolean r9 = false;
        L34:
            if (r9 == true) goto L44;
            if (r8 != null) goto L37;
        L39:
            boolean r10 = false;
        L40:
            if (r10 == true) goto L44;
            r3 = false;
            goto L44
        L37:
            if (r8.hasExtra("vd_debug_bridge_url") != true) goto L39;
            r10 = true;
        L44:
            return new a(r3, r0);
        L31:
            if (r8.getBooleanExtra("vd_debug_bridge_enabled", false) != true) goto L33;
            r9 = true;
            goto L34
        L23:
            r7 = false;
        L28:
            r0 = "http://127.0.0.1:5174";
            goto L29
        L11:
            return a();
        L7:
            r2 = null;
            goto L9
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f25178b == r6.f25178b) goto L12;
        return false;
    L12:
        if (o.a(this.f25179c, r6.f25179c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f25178b) * 31) + this.f25179c.hashCode();
    }

    public String toString() {
        return "VDPlayerDebugBridgeConfig(enabled=" + this.f25178b + ", bridgeUrl=" + this.f25179c + ')';
    }

    public a(boolean r2, String r3) {
        o.e(r3, "bridgeUrl");
        this.f25178b = r2;
        this.f25179c = r3;
    }

    public static final /* synthetic */ a b() {
        return f25177d;
    }

    public final boolean a() {
        return this.f25178b;
    }

    static {
        f25176a = new C0605a(null);
        f25177d = new a(false, "http://127.0.0.1:5174");
    }
}
