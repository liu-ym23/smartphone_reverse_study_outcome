package com.obric.autogui.agents.scripted.impl;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.obric.autogui.resourcemanage.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import javax.crypto.AEADBadTagException;

/* JADX INFO: compiled from: ScriptModuleReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    private static final String TAG = "ScriptModuleReader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f27041b;

    /* JADX INFO: compiled from: ScriptModuleReader.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptModuleReader.kt */
    public interface b {

        /* JADX INFO: compiled from: ScriptModuleReader.kt */
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f27042a = null;

            static {
                f27042a = new a();
            }

            private a() {
            }

            @Override // com.obric.autogui.agents.scripted.impl.p.b
            public String a() {
                return C0676b.a(this);
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.scripted.impl.p$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ScriptModuleReader.kt */
        public static final class C0676b {
            public static String a(b r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L5;
                d r5 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
            L6:
                if (r5 != null) goto L8;
                return null;
            L8:
                return r5.b();
            L5:
                r5 = null;
                goto L6
            }
        }

        /* JADX INFO: compiled from: ScriptModuleReader.kt */
        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f27043a = null;

            static {
                f27043a = new c();
            }

            private c() {
            }

            @Override // com.obric.autogui.agents.scripted.impl.p.b
            public String a() {
                return C0676b.a(this);
            }
        }

        /* JADX INFO: compiled from: ScriptModuleReader.kt */
        public static final class d implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f27044a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
                return false;
            L8:
                d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f27044a, r6.f27044a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f27044a.hashCode();
            }

            public String toString() {
                return "Ok(content=" + this.f27044a + ')';
            }

            public d(String r2) {
                d.h.b.o.e(r2, "content");
                this.f27044a = r2;
            }

            @Override // com.obric.autogui.agents.scripted.impl.p.b
            public String a() {
                return C0676b.a(this);
            }

            public final String b() {
                return this.f27044a;
            }
        }

        String a();
    }

    static {
        f27040a = new a(null);
    }

    public p(o r2) {
        d.h.b.o.e(r2, "decryptorPool");
        this.f27041b = r2;
    }

    public final m a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        d.h.b.o.e(r5, "packageName");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.i() == true) goto L5;
        return null;
    L5:
        File r7 = ac.f30597a.a(r6, r5);
        if (r7 != null) goto L9;
        return null;
    L9:
        if (new File(r7, "meta.json").exists() == true) goto L12;
        return null;
    L12:
        return this.f27041b.a(r5, r7);
    }

    public final b b(Context r10, String r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        return a(r3, a(r3, "com.obric.script_engine"), "com.obric.script_engine", "auto-shortcut-engine.js", (com.obric.autogui.resourcemanage.s) ZeusTransformUtils.preCheckCast(new com.obric.autogui.resourcemanage.s.a("auto-shortcut-engine.js"), com.obric.autogui.resourcemanage.s.class, "com.obric.aiagent.plugin"), r11);
    }

    public static /* synthetic */ List a(p r1, Context r2, m r3, String r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r1.a(r7, r3, r4);
    }

    public final List<com.obric.autogui.agents.scripted.api.a> a(Context r10, m r11, String r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        String r9 = a(r3, r11, "com.obric.ability.script", "manifest.json", (com.obric.autogui.resourcemanage.s) ZeusTransformUtils.preCheckCast(new com.obric.autogui.resourcemanage.s.a("manifest.json"), com.obric.autogui.resourcemanage.s.class, "com.obric.aiagent.plugin"), r12).a();
        if (r9 == null) goto L5;
        com.obric.autogui.agents.scripted.api.c r13 = (com.obric.autogui.agents.scripted.api.c) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r9, com.obric.autogui.agents.scripted.api.c.class), com.obric.autogui.agents.scripted.api.c.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        if (r13 == null) goto L10;
        List<com.obric.autogui.agents.scripted.api.a> r14 = r13.a();     // Catch: Exception -> L12
        if (r14 == null) goto L10;
        return r14;
    L10:
        return d.a.p.b();
    L12:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "parse manifest failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return d.a.p.b();
    L5:
        return d.a.p.b();
    }

    public static /* synthetic */ b a(p r9, Context r10, m r11, String r12, String r13, com.obric.autogui.resourcemanage.s r14, String r15, int r16, Object r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.resourcemanage.s r7 = (com.obric.autogui.resourcemanage.s) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.autogui.resourcemanage.s.class, "com.obric.aiagent.plugin");
        if ((r16 & 32) == 0) goto L5;
        String r8 = null;
    L7:
        return r9.a(r3, r11, r12, r13, r7, r8);
    L5:
        r8 = r15;
        goto L7
    }

    public final b a(Context r19, m r20, String r21, String r22, com.obric.autogui.resourcemanage.s r23, String r24) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.resourcemanage.s r1 = (com.obric.autogui.resourcemanage.s) ZeusTransformUtils.wrapperContextForParams(r23, com.obric.autogui.resourcemanage.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "context");
        d.h.b.o.e(r21, "packageName");
        d.h.b.o.e(r22, "moduleName");
        d.h.b.o.e(r1, "legacySelector");
        if (r20 == null) goto L19;
        boolean r2 = !r20.a(r22);
        long r16 = System.currentTimeMillis();
        String r3 = r20.c(r22);     // Catch: Exception -> L10 IllegalArgumentException -> L12 IllegalStateException -> L14 AEADBadTagException -> L16
        if (r2 == false) goto L8;
        n r5 = n.f27031a;     // Catch: Exception -> L10 IllegalArgumentException -> L12 IllegalStateException -> L14 AEADBadTagException -> L16
        String r8 = r20.a().b();     // Catch: Exception -> L10 IllegalArgumentException -> L12 IllegalStateException -> L14 AEADBadTagException -> L16
        long r10 = System.currentTimeMillis() - r16;     // Catch: Exception -> L10 IllegalArgumentException -> L12 IllegalStateException -> L14 AEADBadTagException -> L16
        byte[] r4 = r3.getBytes(d.o.d.f38623b);     // Catch: Exception -> L10 IllegalArgumentException -> L12 IllegalStateException -> L14 AEADBadTagException -> L16
        d.h.b.o.c(r4, "getBytes(...)");     // Catch: Exception -> L10 IllegalArgumentException -> L12 IllegalStateException -> L14 AEADBadTagException -> L16
        r5.a(r21, r22, r8, "success", r10, r4.length, "", r24);     // Catch: Exception -> L10 IllegalArgumentException -> L12 IllegalStateException -> L14 AEADBadTagException -> L16
    L8:
    L32:
        return (b) ZeusTransformUtils.preCheckCast(new b.d(r3), b.class, "com.obric.aiagent.plugin");
    L12:
        e = move-exception;
        a(r21, r22, r20, "module_not_found", r16, r24, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (b) ZeusTransformUtils.preCheckCast(b.a.f27042a, b.class, "com.obric.aiagent.plugin");
    L14:
        e = move-exception;
        a(r21, r22, r20, "resource_error", r16, r24, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (b) ZeusTransformUtils.preCheckCast(b.a.f27042a, b.class, "com.obric.aiagent.plugin");
    L16:
        e = move-exception;
        a(r21, r22, r20, "aead_failed", r16, r24, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (b) ZeusTransformUtils.preCheckCast(b.a.f27042a, b.class, "com.obric.aiagent.plugin");
    L10:
        e = move-exception;
        a(r21, r22, r20, WsConstants.KEY_CONNECTION_ERROR, r16, r24, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (b) ZeusTransformUtils.preCheckCast(b.a.f27042a, b.class, "com.obric.aiagent.plugin");
    L19:
        File r6 = ac.f30597a.a(r0, r21, r1);
        if (r6 != null) goto L22;
    L24:
        Object r7 = ZeusTransformUtils.preCheckCast(b.c.f27043a, b.class, "com.obric.aiagent.plugin");
    L26:
        return (b) r7;
    L22:
        if (r6.exists() == false) goto L24;
        r7 = ZeusTransformUtils.preCheckCast(new b.d(d.f.k.a(r6, null, 1, null)), b.class, "com.obric.aiagent.plugin");
        goto L26
    }

    private final void a(String r13, String r14, m r15, String r16, long r17, String r19, Throwable r20) {
        com.obric.autogui.agents.scripted.c.c.a(TAG, "decrypt module failed (" + r16 + "): pkg=" + r13 + ", module=" + r14, r20);
        n.f27031a.a(r13, r14, r15.a().b(), r16, System.currentTimeMillis() - r17, -1, n.f27031a.a(r20), r19);
    }
}
