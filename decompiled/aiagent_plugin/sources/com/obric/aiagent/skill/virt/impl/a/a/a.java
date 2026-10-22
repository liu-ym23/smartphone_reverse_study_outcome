package com.obric.aiagent.skill.virt.impl.a.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.ProxyReady;
import com.bytedance.safetyguard.lxc.api.ProxyReadyException;
import com.bytedance.safetyguard.lxc.api.ProxySession;
import com.bytedance.safetyguard.lxc.api.ProxySessionOptions;
import com.bytedance.safetyguard.lxc.api.ProxySessionReadyKt;
import com.bytedance.safetyguard.lxc.api.ProxySessionResult;
import com.bytedance.safetyguard.lxc.api.SafetyGuard;
import com.bytedance.safetyguard.lxc.api.SafetyGuardKt;
import com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.bytedance.virt.Ctrd;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.entity.ResultCode;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.co;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: CtrdBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.aiagent.skill.virt.impl.a.k, com.obric.aiagent.skill.virt.impl.a.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f21638a = null;
    private static final d.o.k p = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.c.b f21640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21642e;
    private final kotlinx.coroutines.f.a f;
    private final Context g;
    private final kotlinx.coroutines.am h;
    private final AtomicReference<String> i;
    private final ConcurrentHashMap<String, b> j;
    private final com.obric.aiagent.skill.virt.impl.a.a.c k;
    private final d.f l;
    private volatile e m;
    private volatile boolean n;
    private final com.obric.aiagent.skill.virt.impl.a.b.d o;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CtrdBackend.kt */
    private static final class C0457a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProxySession f21643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ActionContextToken f21644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f21645c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0457a.class) == true) goto L8;
            return false;
        L8:
            C0457a r6 = (C0457a) ZeusTransformUtils.preCheckCast(r5, C0457a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21643a, r6.f21643a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21644b, r6.f21644b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21645c, r6.f21645c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f21643a.hashCode() * 31) + this.f21644b.hashCode()) * 31) + this.f21645c.hashCode();
        }

        public String toString() {
            return "ActionLease(session=" + this.f21643a + ", token=" + this.f21644b + ", finished=" + this.f21645c + ')';
        }

        public C0457a(ProxySession r3, ActionContextToken r4, AtomicBoolean r5) {
            ProxySession r6 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, SensitiveType.SESSION);
            d.h.b.o.e(r4, "token");
            d.h.b.o.e(r5, "finished");
            this.f21643a = r6;
            this.f21644b = r4;
            this.f21645c = r5;
        }

        public final ProxySession a() {
            return this.f21643a;
        }

        public final ActionContextToken b() {
            return this.f21644b;
        }

        public /* synthetic */ C0457a(ProxySession r2, ActionContextToken r3, AtomicBoolean r4, int r5, d.h.b.h r6) {
            ProxySession r7 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r2, ProxySession.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r4 = new AtomicBoolean(false);
        L5:
            this(r7, r3, r4);
        }

        public final AtomicBoolean c() {
            return this.f21645c;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {338, 353}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$exportFile$2")
    static final class aa extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.virt.api.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f21650e;
        final /* synthetic */ com.obric.aiagent.skill.virt.api.c f;
        final /* synthetic */ com.obric.aiagent.skill.virt.api.b g;

        aa(String r3, a r4, com.obric.aiagent.skill.virt.api.c r5, com.obric.aiagent.skill.virt.api.b r6, d.c.d<? super aa> r7) {
            com.obric.aiagent.skill.virt.api.c r8 = (com.obric.aiagent.skill.virt.api.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.virt.api.c.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21649d = r3;
            this.f21650e = r4;
            this.f = r8;
            this.g = r6;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.d> r4) {
            return ((aa) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aa(this.f21649d, this.f21650e, this.f, this.g, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.d> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            com.obric.aiagent.skill.virt.impl.a.b.b r1 = this.f21648c;
            boolean r3 = false;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            File r2 = (File) ZeusTransformUtils.preCheckCast(this.f21647b, File.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.virt.impl.a.b.b r4 = (com.obric.aiagent.skill.virt.impl.a.b.b) ZeusTransformUtils.preCheckCast(this.f21646a, com.obric.aiagent.skill.virt.impl.a.b.b.class, "com.obric.aiagent.plugin");
            d.o.a(r13);     // Catch: Throwable -> L48
        L34:
            com.obric.aiagent.skill.virt.impl.a.c.a r14 = (com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
            if (r14.c() != 0) goto L37;
            r3 = true;
        L37:
            if (r3 == false) goto L40;
            File r7 = r2;
        L41:
            String r5 = r7.getAbsolutePath();     // Catch: Throwable -> L48
            d.h.b.o.c(r5, "getAbsolutePath(...)");     // Catch: Throwable -> L48
            String r6 = r7.getName();     // Catch: Throwable -> L48
            d.h.b.o.c(r6, "getName(...)");     // Catch: Throwable -> L48
            com.obric.aiagent.skill.virt.api.d r15 = new com.obric.aiagent.skill.virt.api.d(r5, r6, r7.length());     // Catch: Throwable -> L48
            a.a(this.f21650e).a(r4.a());
            return r15;
        L40:
            throw new IllegalStateException(("Ctrd destructive export cleanup failed exit=" + r14.c() + " stderr=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r14.b())).toString());     // Catch: Throwable -> L48
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f21647b, String.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.virt.impl.a.b.b r9 = (com.obric.aiagent.skill.virt.impl.a.b.b) ZeusTransformUtils.preCheckCast(this.f21646a, com.obric.aiagent.skill.virt.impl.a.b.b.class, "com.obric.aiagent.plugin");
            d.o.a(r13);     // Catch: Throwable -> L14
            String r10 = r8;
            r4 = r9;
        L21:
            com.obric.aiagent.skill.virt.impl.a.c.a r16 = (com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
            if (r16.c() != 0) goto L24;
            boolean r11 = true;
        L25:
            if (r11 == false) goto L47;
            File r17 = new File(r4.a(), r10);     // Catch: Throwable -> L48
            if (r17.isFile() == false) goto L45;
            r7 = a.a(this.f21650e).a(this.f, r10, this.g);     // Catch: Throwable -> L48
            a.a(this.f21650e).a(r17, r7);     // Catch: Throwable -> L48
            if (this.g.a() == false) goto L41;
            a r18 = this.f21650e;     // Catch: Throwable -> L48
            String r12 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.d(this.f21649d);     // Catch: Throwable -> L48
            d.c.d r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
            this.f21646a = r4;     // Catch: Throwable -> L48
            this.f21647b = r7;     // Catch: Throwable -> L48
            this.f21648c = 2;     // Catch: Throwable -> L48
            r13 = a.a(r18, r12, "export_source_delete", r19);     // Catch: Throwable -> L48
            if (r13 != r0) goto L33;
            return r0;
        L33:
            r2 = r7;
            goto L34
        L45:
            throw new IllegalStateException(("Ctrd export staging file missing: " + r17.getAbsolutePath()).toString());     // Catch: Throwable -> L48
        L47:
            throw new IllegalStateException(("Ctrd export failed exit=" + r16.c() + " stderr=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r16.b())).toString());     // Catch: Throwable -> L48
        L24:
            r11 = false;
        L14:
            th = th;
            r1 = r9;
        L49:
            a.a(this.f21650e).a(r1.a());
            throw th;
        L16:
            d.o.a(r13);
            com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(this.f21649d, "sourcePath", true);
            r4 = a.a(this.f21650e).a(com.obric.aiagent.skill.virt.impl.a.b.c.f21904b, com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a());
            String r110 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(d.o.o.c(this.f21649d, '/', null, 2, null));     // Catch: Throwable -> L48
            String r20 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(this.f21649d, r4.b(), com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(r4.b(), r110), false);     // Catch: Throwable -> L48
            a r21 = this.f21650e;     // Catch: Throwable -> L48
            d.c.d r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
            this.f21646a = r4;     // Catch: Throwable -> L48
            this.f21647b = r110;     // Catch: Throwable -> L48
            this.f21648c = 1;     // Catch: Throwable -> L48
            Object r22 = a.a(r21, r20, "export_staging_copy", r111);     // Catch: Throwable -> L48
            if (r22 != r0) goto L20;
            return r0;
        L20:
            r10 = r110;
            r13 = r22;
        L48:
            th = th;
            goto L49
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {ResultCode.ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$importFile$2")
    static final class ab extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.virt.api.h>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.f f21653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.g f21654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f21655e;

        ab(String r3, com.obric.aiagent.skill.virt.api.f r4, com.obric.aiagent.skill.virt.api.g r5, a r6, d.c.d<? super ab> r7) {
            com.obric.aiagent.skill.virt.api.g r8 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21652b = r3;
            this.f21653c = r4;
            this.f21654d = r8;
            this.f21655e = r6;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r4) {
            return ((ab) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ab.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ab(this.f21652b, this.f21653c, this.f21654d, this.f21655e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21651a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L31:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(this.f21652b, "targetPath", false);
            if (this.f21653c.c() == true) goto L11;
        L15:
            boolean r9 = a.a(this.f21655e).a(this.f21652b);
            if (r9 == true) goto L18;
        L23:
            if (r9 == true) goto L25;
        L28:
            a r10 = this.f21655e;
            com.obric.aiagent.skill.virt.api.g r3 = this.f21654d;
            String r4 = this.f21652b;
            com.obric.aiagent.skill.virt.api.f r5 = this.f21653c;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21651a = 1;
            r8 = a.a(r10, r3, r4, r5, r2);
            if (r8 != r0) goto L31;
            return r0;
        L25:
            if (ZeusTransformUtils.instanceOf(this.f21654d, com.obric.aiagent.skill.virt.api.g.a.class) == false) goto L28;
            return a.a(this.f21655e).a((com.obric.aiagent.skill.virt.api.g.a) ZeusTransformUtils.preCheckCast(this.f21654d, com.obric.aiagent.skill.virt.api.g.a.class, "com.obric.aiagent.plugin"), this.f21652b, this.f21653c);
        L18:
            if (this.f21653c.c() == false) goto L23;
            if (ZeusTransformUtils.instanceOf(this.f21654d, com.obric.aiagent.skill.virt.api.g.b.class) == false) goto L23;
            return a.a(this.f21655e).a((com.obric.aiagent.skill.virt.api.g.b) ZeusTransformUtils.preCheckCast(this.f21654d, com.obric.aiagent.skill.virt.api.g.b.class, "com.obric.aiagent.plugin"), this.f21652b, this.f21653c);
        L11:
            if (ZeusTransformUtils.instanceOf(this.f21654d, com.obric.aiagent.skill.virt.api.g.c.class) == false) goto L15;
            throw new IllegalStateException("moveSource=true is only valid for Host{File,Directory}".toString());
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {541, 543}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$killSyncShell$2")
    static final class ac extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> f21657b;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$ac$1, reason: invalid class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {543}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$killSyncShell$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21658a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<d.c.d<? super Ctrd.i>, Object> f21659b;

            AnonymousClass1(d.h.a.b<? super d.c.d<? super Ctrd.i>, ? extends Object> r3, d.c.d<? super AnonymousClass1> r4) {
                d.h.a.b<d.c.d<? super Ctrd.i>, Object> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21659b = r5;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f21659b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21658a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r4);
                d.h.a.b<d.c.d<? super Ctrd.i>, Object> r5 = this.f21659b;
                this.f21658a = 1;
                r4 = r5.invoke(this);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$ac$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {541}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$killSyncShell$2$kill$1")
        static final class C0458a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.h.a.b<? super d.c.d<? super Ctrd.i>, ? extends Object>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21660a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> f21661b;

            C0458a(kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r3, d.c.d<? super C0458a> r4) {
                kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r5 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21661b = r5;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.h.a.b<? super d.c.d<? super Ctrd.i>, ? extends Object>> r4) {
                return ((C0458a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0458a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0458a(this.f21661b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.h.a.b<? super d.c.d<? super Ctrd.i>, ? extends Object>> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21660a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r6 = this.f21661b;
                d.c.d<? super d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21660a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        ac(kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r3, d.c.d<? super ac> r4) {
            kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r5 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21657b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return ((ac) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f21657b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21656a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r9);
        L19:
            return r9;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r9);
        L13:
            d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
            if (r10 != null) goto L16;
            return null;
        L16:
            d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21656a = 2;
            r9 = dg.b(10000, r11, r2);
            if (r9 != r0) goto L19;
            return r0;
        L10:
            d.o.a(r9);
            d.h.a.m r12 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0458a(this.f21657b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21656a = 1;
            r9 = dg.b(10000, r12, r3);
            if (r9 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    /* synthetic */ class ad extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.virt.api.w, Boolean> {
        ad(Object r8) {
            super(1, r8, com.obric.aiagent.skill.virt.impl.c.b.class, "onDiagnostics", "onDiagnostics(Lcom/obric/aiagent/skill/virt/api/VirtDiagnosticsReport;)Z", 0);
        }

        public final Boolean a(com.obric.aiagent.skill.virt.api.w r3) {
            d.h.b.o.e(r3, "p0");
            return Boolean.valueOf(((com.obric.aiagent.skill.virt.impl.c.b) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.virt.impl.c.b.class, "com.obric.aiagent.plugin")).a(r3));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(com.obric.aiagent.skill.virt.api.w r3) {
            return a((com.obric.aiagent.skill.virt.api.w) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.virt.api.w.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {1154, 118, ApWakeEvent.ACCELERATING_START, 150, 155, 175, 176, 180, 181}, d = "open", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class ae extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21666e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        ae(a r3, d.c.d<? super ae> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {IdlErrors.E_RejectInferDeviceOverheat}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$open$2$openResult$1")
    static final class af extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21667a;

        af(d.c.d<? super af> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.e> r4) {
            return ((af) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), af.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new af((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.e> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21667a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Ctrd r7 = Ctrd.INSTANCE;
            Ctrd.o r2 = Ctrd.o.f11632a;
            d.c.d<? super Ctrd.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21667a = 1;
            r6 = r7.open(r2, true, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$open$2$sharePaths$1")
    static final class ag extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.g>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ctrd.d f21669b;

        ag(Ctrd.d r3, d.c.d<? super ag> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21669b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.g> r4) {
            return ((ag) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ag.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ag(this.f21669b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.g> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21668a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Ctrd r7 = Ctrd.INSTANCE;
            Ctrd.d r2 = this.f21669b;
            d.c.d<? super Ctrd.g> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21668a = 1;
            r6 = r7.getSharePaths(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {738}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$requestKill$1")
    static final class ah extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ctrd.h f21671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f21672c;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$ah$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {738}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$requestKill$1$1$1")
        static final class C0459a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21673a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ctrd.h f21674b;

            C0459a(Ctrd.h r3, d.c.d<? super C0459a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21674b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return ((C0459a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0459a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0459a(this.f21674b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21673a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                Ctrd r7 = Ctrd.INSTANCE;
                Ctrd.h r2 = this.f21674b;
                d.c.d<? super Ctrd.i> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21673a = 1;
                r6 = r7.killShell(r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        ah(Ctrd.h r3, d.c.d<? super ah> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21671b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ah) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ah.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            ah r0 = new ah(this.f21671b, r5);
            r0.f21672c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21670a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r8);     // Catch: Throwable -> L15
        L13:
            d.n.f((Ctrd.i) ZeusTransformUtils.preCheckCast(r8, Ctrd.i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        L18:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
            kotlinx.coroutines.am r9 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f21672c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            Ctrd.h r10 = this.f21671b;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
            d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0459a(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            this.f21670a = 1;     // Catch: Throwable -> L15
            r8 = dg.a(10000, r11, this);     // Catch: Throwable -> L15
            if (r8 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r12 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {402}, d = "stagedImport", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class ai extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f21678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21679e;
        final /* synthetic */ a f;
        int g;

        ai(a r3, d.c.d<? super ai> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21679e = r3;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {1154, 573, 630}, d = "startAsync-eH_QyT8", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class aj extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21684e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        /* synthetic */ Object k;
        final /* synthetic */ a l;
        int m;

        aj(a r3, d.c.d<? super aj> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.k = r10;
            this.m |= Integer.MIN_VALUE;
            Object r9 = this.l.a(null, null, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r9 != d.c.a.b.a()) goto L6;
            return r9;
        L6:
            return d.n.g(r9);
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {697}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$startAsync$2$1")
    static final class ak extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ctrd.m f21686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f21688d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f21689e;

        ak(Ctrd.m r3, a r4, b r5, d.c.d<? super ak> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21686b = r3;
            this.f21687c = r4;
            this.f21688d = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ak) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ak.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            ak r0 = new ak(this.f21686b, this.f21687c, this.f21688d, r7);
            r0.f21689e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21685a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r11);     // Catch: Throwable -> L15
        L13:
            Object r12 = d.n.f((Ctrd.i) ZeusTransformUtils.preCheckCast(r11, Ctrd.i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        L17:
            a r4 = this.f21687c;
            b r5 = this.f21688d;
            Throwable r10 = d.n.c(r12);
            if (r10 != null) goto L20;
            a.a(r4, r5, (Ctrd.i) ZeusTransformUtils.preCheckCast(r12, Ctrd.i.class, "com.obric.aiagent.plugin"), false, 4, null);
        L22:
            return d.x.f38692a;
        L20:
            a.a(r4, r5, r10);
            goto L22
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r11);
            kotlinx.coroutines.am r13 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f21689e, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            Ctrd.m r14 = this.f21686b;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
            au<Ctrd.i> r15 = r14.b();     // Catch: Throwable -> L15
            this.f21685a = 1;     // Catch: Throwable -> L15
            r11 = r15.a(this);     // Catch: Throwable -> L15
            if (r11 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r3 = d.n.f38560a;
            r12 = d.n.f(d.o.a(th));
            goto L17
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    public static final class al implements com.obric.aiagent.skill.virt.impl.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f21690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference<Ctrd.h> f21691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f21693d;

        al(a r1, AtomicReference<Ctrd.h> r2, String r3, AtomicBoolean r4) {
            this.f21690a = r1;
            this.f21691b = r2;
            this.f21692c = r3;
            this.f21693d = r4;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.g
        public Object a() {
            return a.a(this.f21690a, this.f21691b, this.f21692c, this.f21693d);
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.g
        public Object b() {
            return a.a(this.f21690a, this.f21691b, this.f21692c, this.f21693d);
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {631}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$startAsync$2$streaming$1")
    static final class am extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.m>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f21695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21698e;
        final /* synthetic */ Map<String, String> f;
        final /* synthetic */ AtomicReference<Ctrd.h> g;
        final /* synthetic */ AtomicReference<Character> h;
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.f i;
        final /* synthetic */ AtomicReference<Character> j;
        final /* synthetic */ AtomicReference<String> k;

        am(e r3, a r4, String r5, String r6, Map<String, String> r7, AtomicReference<Ctrd.h> r8, AtomicReference<Character> r9, com.obric.aiagent.skill.virt.impl.a.f r10, AtomicReference<Character> r11, AtomicReference<String> r12, d.c.d<? super am> r13) {
            Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21695b = r3;
            this.f21696c = r4;
            this.f21697d = r5;
            this.f21698e = r6;
            this.f = r14;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            super(2, r15);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.m> r4) {
            return ((am) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r14, d.c.d<?> r15) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new am(this.f21695b, this.f21696c, this.f21697d, this.f21698e, this.f, this.g, this.h, this.i, this.j, this.k, r12), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.m> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21694a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r13);
        L11:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r13);
            Ctrd r2 = Ctrd.INSTANCE;
            Ctrd.d r14 = this.f21695b.a();
            String r3 = a.a(this.f21696c, this.f21697d, this.f21698e);
            List<String> r4 = a.a(this.f21696c, this.f);
            final AtomicReference<Ctrd.h> r6 = this.g;
            final AtomicReference<Character> r7 = this.h;
            final com.obric.aiagent.skill.virt.impl.a.f r8 = this.i;
            final AtomicReference<Character> r9 = this.j;
            final AtomicReference<String> r10 = this.k;
            Ctrd.n r5 = (Ctrd.n) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, r7, r8, r9, r10), Ctrd.n.class, "com.obric.aiagent.plugin");
            d.c.d<? super Ctrd.m> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21694a = 1;
            r13 = r2.startShell(r14, r3, r4, r5, r11);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {940, 954, 956}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$watchGatewayAttachment$1")
    static final class an extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21706c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21707d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f21708e;
        final /* synthetic */ e f;
        final /* synthetic */ a g;
        private /* synthetic */ Object h;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$an$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {954}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$watchGatewayAttachment$1$1$1$1")
        static final class C0460a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21709a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f21710b;

            C0460a(b r3, d.c.d<? super C0460a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21710b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return ((C0460a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0460a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0460a(this.f21710b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21709a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                Ctrd r7 = Ctrd.INSTANCE;
                Ctrd.h r2 = this.f21710b.b();
                d.c.d<? super Ctrd.i> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21709a = 1;
                r6 = r7.killShell(r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {957}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$watchGatewayAttachment$1$1$reconciled$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21711a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f21712b;

            b(b r3, d.c.d<? super b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21712b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f21712b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21711a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L12:
                return d.c.b.a.b.a(true);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                com.obric.aiagent.skill.virt.impl.a.f r6 = this.f21712b.c();
                d.c.d<? super com.obric.aiagent.skill.virt.impl.a.h> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21711a = 1;
                if (r6.a(r2) != r0) goto L12;
                return r0;
            }
        }

        an(d r3, e r4, a r5, d.c.d<? super an> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21708e = r3;
            this.f = r4;
            this.g = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((an) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), an.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            an r0 = new an(this.f21708e, this.f, this.g, r7);
            r0.h = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x019d -> B:44:0x01a0). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21707d;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            b r2 = (b) ZeusTransformUtils.preCheckCast(this.f21706c, b.class, "com.obric.aiagent.plugin");
            Iterator r6 = (Iterator) ZeusTransformUtils.preCheckCast(this.f21705b, Iterator.class, "com.obric.aiagent.plugin");
            a r9 = (a) ZeusTransformUtils.preCheckCast(this.f21704a, a.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.am r10 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L44:
            Boolean r14 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L47;
            boolean r15 = r14.booleanValue();
        L48:
            if (r15 == true) goto L33;
            d.h.b.o.a(r2);
            a.a(r9, r2, (Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Ctrd proxy session terminated"), Throwable.class, "com.obric.aiagent.plugin"));
        L33:
            if (r6.hasNext() == false) goto L51;
            r2 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin");
            d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L13
            d.h.a.m r17 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0460a(r2, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
            this.h = r10;     // Catch: Throwable -> L13
            this.f21704a = r9;     // Catch: Throwable -> L13
            this.f21705b = r6;     // Catch: Throwable -> L13
            this.f21706c = r2;     // Catch: Throwable -> L13
            this.f21707d = 2;     // Catch: Throwable -> L13
            r13 = dg.a(10000, r17, this);     // Catch: Throwable -> L13
            if (r13 != r0) goto L38;
            return r0;
        L38:
            d.n.f((Ctrd.i) ZeusTransformUtils.preCheckCast(r13, Ctrd.i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        L41:
            d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r2, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            this.h = r10;
            this.f21704a = r9;
            this.f21705b = r6;
            this.f21706c = r2;
            this.f21707d = 3;
            r13 = dg.b(10000, r18, this);
            if (r13 != r0) goto L44;
            return r0;
        L13:
            th = move-exception;
            d.n.a r11 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L41
        L51:
            return d.x.f38692a;
        L47:
            r15 = false;
            goto L48
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = (b) ZeusTransformUtils.preCheckCast(this.f21706c, b.class, "com.obric.aiagent.plugin");
            r6 = (Iterator) ZeusTransformUtils.preCheckCast(this.f21705b, Iterator.class, "com.obric.aiagent.plugin");
            r9 = (a) ZeusTransformUtils.preCheckCast(this.f21704a, a.class, "com.obric.aiagent.plugin");
            r10 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.o.a(r13);     // Catch: Throwable -> L13
            goto L38
        L15:
            kotlinx.coroutines.am r3 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L19:
            Object r19 = ((d.n) ZeusTransformUtils.preCheckCast(r13, d.n.class, "com.obric.aiagent.plugin")).a();
            if (this.f21708e.c().get() == false) goto L24;
            return d.x.f38692a;
        L24:
            if (this.f.d().compareAndSet(this.f21708e, null) == true) goto L28;
            return d.x.f38692a;
        L28:
            if (IAppContext.Companion.isDebug() == false) goto L30;
            ILogDepend.Companion.e("Virt/CtrdProxy", "Ctrd proxy terminated unexpectedly success=" + d.n.a(r19), d.n.c(r19));
        L31:
            Collection r110 = a.b(this.g).values();
            d.h.b.o.c(r110, "<get-values>(...)");
            Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
            r10 = r3;
            r9 = this.g;
            r6 = r111.iterator();
            goto L33
        L30:
            ILogDepend.Companion.e("Virt/CtrdProxy", "Ctrd proxy terminated unexpectedly");
            goto L31
        L16:
            d.o.a(r13);
            r3 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            au<d.n<d.x>> r112 = this.f21708e.b();
            d.c.d<? super d.n<d.x>> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            this.f21707d = 1;
            r13 = r112.a(r12);
            if (r13 != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Ctrd.h f21714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.aiagent.skill.virt.impl.a.f f21715c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f21716d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicReference<Character> f21717e;
        private final AtomicReference<Character> f;
        private final C0457a g;
        private final AtomicBoolean h;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21713a, r6.f21713a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21714b, r6.f21714b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21715c, r6.f21715c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f21716d, r6.f21716d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f21717e, r6.f21717e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((this.f21713a.hashCode() * 31) + this.f21714b.hashCode()) * 31) + this.f21715c.hashCode()) * 31) + this.f21716d.hashCode()) * 31) + this.f21717e.hashCode()) * 31) + this.f.hashCode()) * 31;
            C0457a r1 = this.g;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.h.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ActiveExecution(executionId=" + this.f21713a + ", handle=" + this.f21714b + ", calling=" + this.f21715c + ", killRequested=" + this.f21716d + ", stdoutLastChar=" + this.f21717e + ", stderrLastChar=" + this.f + ", actionLease=" + this.g + ", terminal=" + this.h + ')';
        }

        public b(String r2, Ctrd.h r3, com.obric.aiagent.skill.virt.impl.a.f r4, AtomicBoolean r5, AtomicReference<Character> r6, AtomicReference<Character> r7, C0457a r8, AtomicBoolean r9) {
            d.h.b.o.e(r2, "executionId");
            d.h.b.o.e(r3, "handle");
            d.h.b.o.e(r4, "calling");
            d.h.b.o.e(r5, "killRequested");
            d.h.b.o.e(r6, "stdoutLastChar");
            d.h.b.o.e(r7, "stderrLastChar");
            d.h.b.o.e(r9, "terminal");
            this.f21713a = r2;
            this.f21714b = r3;
            this.f21715c = r4;
            this.f21716d = r5;
            this.f21717e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final String a() {
            return this.f21713a;
        }

        public final Ctrd.h b() {
            return this.f21714b;
        }

        public final com.obric.aiagent.skill.virt.impl.a.f c() {
            return this.f21715c;
        }

        public final AtomicBoolean d() {
            return this.f21716d;
        }

        public final AtomicReference<Character> e() {
            return this.f21717e;
        }

        public final AtomicReference<Character> f() {
            return this.f;
        }

        public final C0457a g() {
            return this.g;
        }

        public /* synthetic */ b(String r12, Ctrd.h r13, com.obric.aiagent.skill.virt.impl.a.f r14, AtomicBoolean r15, AtomicReference r16, AtomicReference r17, C0457a r18, AtomicBoolean r19, int r20, d.h.b.h r21) {
            if ((r20 & 128) == 0) goto L5;
            AtomicBoolean r10 = new AtomicBoolean(false);
        L6:
            this(r12, r13, r14, r15, r16, r17, r18, r10);
            return;
        L5:
            r10 = r19;
            goto L6
        }

        public final AtomicBoolean h() {
            return this.h;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    private static final class c {
        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProxySession f21718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final au<d.n<d.x>> f21719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f21720c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21718a, r6.f21718a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21719b, r6.f21719b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21720c, r6.f21720c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f21718a.hashCode() * 31) + this.f21719b.hashCode()) * 31) + this.f21720c.hashCode();
        }

        public String toString() {
            return "GatewayAttachment(session=" + this.f21718a + ", terminal=" + this.f21719b + ", expectedClose=" + this.f21720c + ')';
        }

        public d(ProxySession r3, au<d.n<d.x>> r4, AtomicBoolean r5) {
            ProxySession r6 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
            au<d.n<d.x>> r7 = (au) ZeusTransformUtils.wrapperContextForParams(r4, au.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, SensitiveType.SESSION);
            d.h.b.o.e(r7, "terminal");
            d.h.b.o.e(r5, "expectedClose");
            this.f21718a = r6;
            this.f21719b = r7;
            this.f21720c = r5;
        }

        public final ProxySession a() {
            return this.f21718a;
        }

        public final au<d.n<d.x>> b() {
            return this.f21719b;
        }

        public /* synthetic */ d(ProxySession r2, au r3, AtomicBoolean r4, int r5, d.h.b.h r6) {
            ProxySession r7 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r2, ProxySession.class, "com.obric.aiagent.plugin");
            au r8 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r4 = new AtomicBoolean(false);
        L5:
            this(r7, r8, r4);
        }

        public final AtomicBoolean c() {
            return this.f21720c;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Ctrd.d f21721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicReference<d> f21724d;

        public e(Ctrd.d r2, String r3, String r4, d r5) {
            d.h.b.o.e(r2, "handle");
            d.h.b.o.e(r3, "hostSharePath");
            d.h.b.o.e(r4, "containerSharePath");
            d.h.b.o.e(r5, "initialGateway");
            this.f21721a = r2;
            this.f21722b = r3;
            this.f21723c = r4;
            this.f21724d = new AtomicReference(r5);
        }

        public final Ctrd.d a() {
            return this.f21721a;
        }

        public final String b() {
            return this.f21722b;
        }

        public final String c() {
            return this.f21723c;
        }

        public final AtomicReference<d> d() {
            return this.f21724d;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {817}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$bestEffortKill$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ctrd.h f21726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f21727c;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$f$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {817}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$bestEffortKill$1$1$1")
        static final class C0461a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21728a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ctrd.h f21729b;

            C0461a(Ctrd.h r3, d.c.d<? super C0461a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21729b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return ((C0461a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0461a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0461a(this.f21729b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21728a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                Ctrd r7 = Ctrd.INSTANCE;
                Ctrd.h r2 = this.f21729b;
                d.c.d<? super Ctrd.i> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21728a = 1;
                r6 = r7.killShell(r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        f(Ctrd.h r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21726b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f21726b, r5);
            r0.f21727c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21725a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r8);     // Catch: Throwable -> L15
        L13:
            d.n.f((Ctrd.i) ZeusTransformUtils.preCheckCast(r8, Ctrd.i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        L18:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
            kotlinx.coroutines.am r9 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f21727c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            Ctrd.h r10 = this.f21726b;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
            d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0461a(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            this.f21725a = 1;     // Catch: Throwable -> L15
            r8 = dg.a(10000, r11, this);     // Catch: Throwable -> L15
            if (r8 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r12 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {1154, 200, 217, 230, 234}, d = "close", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21734e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ a i;
        int j;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return this.i.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {201}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$close$2$1$killResult$1$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f21736b;

        h(b r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21736b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f21736b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21735a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Ctrd r7 = Ctrd.INSTANCE;
            Ctrd.h r2 = this.f21736b.b();
            d.c.d<? super Ctrd.i> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21735a = 1;
            r6 = r7.killShell(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {217}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$close$2$2$completed$1$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.h>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f21738b;

        i(b r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21738b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.h> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f21738b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.h> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21737a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            com.obric.aiagent.skill.virt.impl.a.f r6 = this.f21738b.c();
            d.c.d<? super com.obric.aiagent.skill.virt.impl.a.h> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21737a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {234}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$close$2$closeResult$1$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f21740b;

        j(e r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21740b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.c> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f21740b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21739a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Ctrd r7 = Ctrd.INSTANCE;
            Ctrd.d r2 = this.f21740b.a();
            d.c.d<? super Ctrd.c> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21739a = 1;
            r6 = r7.close(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$closeAfterFailedOpen$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.n<? extends Ctrd.c>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ctrd.d f21742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f21743c;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$k$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$closeAfterFailedOpen$2$1$1")
        static final class C0462a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.c>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21744a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ctrd.d f21745b;

            C0462a(Ctrd.d r3, d.c.d<? super C0462a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21745b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.c> r4) {
                return ((C0462a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0462a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0462a(this.f21745b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.c> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21744a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                Ctrd r7 = Ctrd.INSTANCE;
                Ctrd.d r2 = this.f21745b;
                d.c.d<? super Ctrd.c> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21744a = 1;
                r6 = r7.close(r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        k(Ctrd.d r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21742b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.n<Ctrd.c>> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f21742b, r5);
            r0.f21743c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.n<? extends Ctrd.c>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21741a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r8);     // Catch: Throwable -> L15
        L13:
            Object r7 = d.n.f((Ctrd.c) ZeusTransformUtils.preCheckCast(r8, Ctrd.c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        L18:
            return d.n.g(r7);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
            kotlinx.coroutines.am r9 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f21743c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            Ctrd.d r10 = this.f21742b;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
            d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0462a(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            this.f21741a = 1;     // Catch: Throwable -> L15
            r8 = dg.a(15000, r11, this);     // Catch: Throwable -> L15
            if (r8 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r12 = d.n.f38560a;
            r7 = d.n.f(d.o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {983}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$closeGatewayAttachment$2")
    static final class l extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f21747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21749d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f21750e;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$l$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {984}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$closeGatewayAttachment$2$closed$1$1")
        static final class C0463a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21751a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f21752b;

            C0463a(d r3, d.c.d<? super C0463a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21752b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
                return ((C0463a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0463a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0463a(this.f21752b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21751a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L12:
                return d.c.b.a.b.a(true);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                au<d.n<d.x>> r6 = this.f21752b.b();
                d.c.d<? super d.n<d.x>> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21751a = 1;
                if (r6.a(r2) != r0) goto L12;
                return r0;
            }
        }

        l(d r3, a r4, String r5, d.c.d<? super l> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21747b = r3;
            this.f21748c = r4;
            this.f21749d = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            l r0 = new l(this.f21747b, this.f21748c, this.f21749d, r7);
            r0.f21750e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f21746a;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            d.o.a(r8);     // Catch: Throwable -> L7
        L22:
            Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            if (r9 == null) goto L25;
            boolean r10 = r9.booleanValue();     // Catch: Throwable -> L7
        L26:
            Object r11 = d.n.f(d.c.b.a.b.a(r10));     // Catch: Throwable -> L7
        L29:
            Boolean r0 = d.c.b.a.b.a(true);
            if (d.n.b(r11) == false) goto L33;
            r11 = r0;
        L33:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L36;
            ILogDepend.Companion.w("Virt/CtrdProxy", "Ctrd proxy close timed out reason=" + this.f21749d);
        L36:
            return d.x.f38692a;
        L25:
            r10 = false;
            goto L26
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r8);
            kotlinx.coroutines.am r12 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f21750e, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            this.f21747b.c().set(true);
            Object r13 = this.f21747b.a().mo32closed1pmJ48();     // Catch: Throwable -> L16
            a r3 = this.f21748c;     // Catch: Throwable -> L16
            String r5 = this.f21749d;     // Catch: Throwable -> L16
            Throwable r14 = d.n.c(r13);     // Catch: Throwable -> L16
            if (r14 == null) goto L18;
            a.a(r3, "Ctrd proxy close failed reason=" + r5, r14);     // Catch: Throwable -> L16
        L18:
            d r15 = this.f21747b;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L7
            d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0463a(r15, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f21746a = 1;     // Catch: Throwable -> L7
            r8 = dg.b(5000, r16, this);     // Catch: Throwable -> L7
            if (r8 != r1) goto L22;
            return r1;
        L16:
            th = move-exception;
            a.a(this.f21748c, "Ctrd proxy close failed reason=" + this.f21749d, th);
        L7:
            th = move-exception;
            d.n.a r6 = d.n.f38560a;
            r11 = d.n.f(d.o.a(th));
            goto L29
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {997}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$closeProxySessionAfterFailedAttach$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.n<? extends ProxySessionResult>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxySession f21754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f21755c;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.a$m$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdBackend.kt */
        @d.c.b.a.f(b = "CtrdBackend.kt", c = {997}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$closeProxySessionAfterFailedAttach$2$2$1")
        static final class C0464a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ProxySessionResult>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21756a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ProxySession f21757b;

            C0464a(ProxySession r3, d.c.d<? super C0464a> r4) {
                ProxySession r5 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21757b = r5;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ProxySessionResult> r4) {
                return ((C0464a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0464a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0464a(this.f21757b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ProxySessionResult> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21756a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                ProxySession r6 = this.f21757b;
                d.c.d<? super ProxySessionResult> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21756a = 1;
                r5 = r6.await(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        m(ProxySession r3, d.c.d<? super m> r4) {
            ProxySession r5 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21754b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.n<ProxySessionResult>> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            m r0 = new m(this.f21754b, r5);
            r0.f21755c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.n<? extends ProxySessionResult>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21753a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r8);     // Catch: Throwable -> L7
        L20:
            Object r7 = d.n.f((ProxySessionResult) ZeusTransformUtils.preCheckCast(r8, ProxySessionResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        L24:
            return d.n.g(r7);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r8);
            kotlinx.coroutines.am r9 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f21755c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            ProxySession r10 = this.f21754b;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
            d.n.f(d.n.g(r10.mo32closed1pmJ48()));     // Catch: Throwable -> L14
        L16:
            ProxySession r11 = this.f21754b;
            d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L7
            d.h.a.m r12 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0464a(r11, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f21753a = 1;     // Catch: Throwable -> L7
            r8 = dg.b(5000, r12, this);     // Catch: Throwable -> L7
            if (r8 != r0) goto L20;
            return r0;
        L14:
            th = move-exception;
            d.n.a r4 = d.n.f38560a;
            d.n.f(d.o.a(th));
        L7:
            th = move-exception;
            d.n.a r13 = d.n.f38560a;
            r7 = d.n.f(d.o.a(th));
            goto L24
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {868, 870}, d = "createGatewayAttachment", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f21762e;
        int f;

        n(a r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21762e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21761d = r3;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f21762e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {868}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$createGatewayAttachment$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ProxyReady>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxySession f21764b;

        o(ProxySession r3, d.c.d<? super o> r4) {
            ProxySession r5 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21764b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ProxyReady> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f21764b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ProxyReady> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21763a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            ProxySession r6 = this.f21764b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21763a = 1;
            r5 = ProxySessionReadyKt.awaitReady(r6, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {875}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$createGatewayAttachment$terminal$1")
    static final class p extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.n<? extends d.x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxySession f21766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f21767c;

        p(ProxySession r3, d.c.d<? super p> r4) {
            ProxySession r5 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r3, ProxySession.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21766b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.n<d.x>> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            p r0 = new p(this.f21766b, r5);
            r0.f21767c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.n<? extends d.x>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21765a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r5);     // Catch: Throwable -> L15
        L13:
            Object r4 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L15
        L18:
            return d.n.g(r4);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r5);
            kotlinx.coroutines.am r6 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f21767c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            ProxySession r7 = this.f21766b;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L15
            this.f21765a = 1;     // Catch: Throwable -> L15
            if (r7.await(this) != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r8 = d.n.f38560a;
            r4 = d.n.f(d.o.a(th));
            goto L18
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {904, 915}, d = "createGatewayAttachmentWithColdRetry", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class q extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21772e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        q(a r3, d.c.d<? super q> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return a.b(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {916}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$createGatewayAttachmentWithColdRetry$retry$1")
    static final class r extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ctrd.d f21774b;

        r(Ctrd.d r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21774b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.b> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f21774b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.b> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21773a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Ctrd r7 = Ctrd.INSTANCE;
            Ctrd.d r2 = this.f21774b;
            d.c.d<? super Ctrd.b> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21773a = 1;
            r6 = r7.enableGateway(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {823, 835, 844}, d = "ensureGatewayAttachment", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class s extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f21778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21779e;

        s(a r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21778d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21777c = r3;
            this.f21779e |= Integer.MIN_VALUE;
            return a.a(this.f21778d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {824}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$ensureGatewayAttachment$result$1")
    static final class t extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f21781b;

        t(e r3, d.c.d<? super t> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21781b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.b> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f21781b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.b> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21780a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Ctrd r7 = Ctrd.INSTANCE;
            Ctrd.d r2 = this.f21781b.a();
            d.c.d<? super Ctrd.b> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21780a = 1;
            r6 = r7.enableGateway(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {BDAbstractUpload.KeyIsSocketConnectTimeout}, d = "executeFileCommand", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class u extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f21785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21786e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        u(a r3, d.c.d<? super u> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return a.a(this.g, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {1154, 510, 512, 513, 532}, d = "executeSyncInternal", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend")
    static final class v extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21790d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21791e;
        final /* synthetic */ a f;
        int g;

        v(a r3, d.c.d<? super v> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21791e = r3;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {532}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$executeSyncInternal$3")
    static final class w extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f21793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> f21794c;

        w(a r3, kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r4, d.c.d<? super w> r5) {
            kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r6 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21793b = r3;
            this.f21794c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return ((w) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new w(this.f21793b, this.f21794c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21792a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            a r7 = this.f21793b;
            kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r2 = this.f21794c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21792a = 1;
            r6 = a.a(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {498}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$executeSyncInternal$evalJob$1")
    static final class x extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f21796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.b f21798d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> f21799e;

        x(e r3, a r4, com.obric.aiagent.skill.virt.impl.a.b r5, kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r6, d.c.d<? super x> r7) {
            kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r8 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21796b = r3;
            this.f21797c = r4;
            this.f21798d = r5;
            this.f21799e = r8;
            super(2, r9);
        }

        public static /* synthetic */ d.x lambda$xyXi9ygIkSIBCY0PZCv80KAVvmo(kotlinx.coroutines.w r0, d.h.a.b r1) {
            return a(r0, r1);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return ((x) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new x(this.f21796b, this.f21797c, this.f21798d, this.f21799e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21795a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            Ctrd r2 = Ctrd.INSTANCE;
            Ctrd.d r12 = this.f21796b.a();
            a r3 = this.f21797c;
            String r4 = a.a(r3, r3.a(this.f21798d.b()), this.f21798d.a());
            final kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r5 = this.f21799e;
            d.h.a.b r6 = new $$Lambda$a$x$xyXi9ygIkSIBCY0PZCv80KAVvmo(r5);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21795a = 1;
            r11 = Ctrd.evalShell$default(r2, r12, r4, null, r6, r7, 4, null);
            if (r11 != r0) goto L11;
            return r0;
        }

        private static final d.x a(kotlinx.coroutines.w r2, d.h.a.b r3) {
            kotlinx.coroutines.w r4 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
            d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            if (r4.i() == true) goto L6;
            r4.a(r5);
        L6:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {510}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$executeSyncInternal$result$1")
    static final class y extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ au<Ctrd.i> f21801b;

        y(au<Ctrd.i> r3, d.c.d<? super y> r4) {
            au<Ctrd.i> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21801b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return ((y) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new y(this.f21801b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21800a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            au<Ctrd.i> r6 = this.f21801b;
            d.c.d<? super Ctrd.i> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21800a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdBackend.kt */
    @d.c.b.a.f(b = "CtrdBackend.kt", c = {514}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdBackend$executeSyncInternal$terminal$1")
    static final class z extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Ctrd.i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ au<Ctrd.i> f21803b;

        z(au<Ctrd.i> r3, d.c.d<? super z> r4) {
            au<Ctrd.i> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21803b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new z(this.f21803b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Ctrd.i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21802a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            au<Ctrd.i> r6 = this.f21803b;
            d.c.d<? super Ctrd.i> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21802a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$-OEMHxnwsFCmQ2mfMBNiy05CCbk, reason: not valid java name */
    public static /* synthetic */ d.x m373lambda$OEMHxnwsFCmQ2mfMBNiy05CCbk(d.h.a.b r0, String r1, String r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$12Jl8CCtObskLqkod-cwpLH_l-4, reason: not valid java name */
    public static /* synthetic */ String m374lambda$12Jl8CCtObskLqkodcwpLH_l4(a r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$5-EhChN-kzt22bpe2erRjQacoWQ, reason: not valid java name */
    public static /* synthetic */ d.x m375lambda$5EhChNkzt22bpe2erRjQacoWQ(d.h.a.b r0, String r1, String r2, String r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ Throwable lambda$6x1Ka6bMA9ehTfU91WTXLFQJXR8(Throwable r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$J66a-7D2c-DZjUunWgoNsRnZPKU, reason: not valid java name */
    public static /* synthetic */ File m376lambda$J66a7D2cDZjUunWgoNsRnZPKU(a r0) {
        return f(r0);
    }

    public static /* synthetic */ SafetyGuardProxyRuntime lambda$mIqsfXeEOXhZZdUMprC_n5Y6B3U(a r0) {
        return c(r0);
    }

    public static /* synthetic */ File lambda$uGSgKJ18dkC1hH8pUMON19Sf2ao(a r0) {
        return d(r0);
    }

    public a(Context r9, String r10, com.obric.aiagent.skill.virt.impl.c.b r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "context");
        d.h.b.o.e(r10, "businessName");
        d.h.b.o.e(r11, "shellMonitor");
        this.f21639b = r10;
        this.f21640c = r11;
        this.f21641d = "ctrd";
        this.f21642e = 1;
        this.f = kotlinx.coroutines.f.c.a(false, 1, null);
        Context r13 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.g = r13;
        this.h = kotlinx.coroutines.an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.i = new AtomicReference(null);
        this.j = new ConcurrentHashMap();
        d.h.b.o.c(r13, "appContext");
        this.k = new com.obric.aiagent.skill.virt.impl.a.a.c(r13, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ad(r11), d.h.a.b.class, "com.obric.aiagent.plugin"));
        this.l = d.g.a(new $$Lambda$a$mIqsfXeEOXhZZdUMprC_n5Y6B3U(this));
        this.o = new com.obric.aiagent.skill.virt.impl.a.b.d(new $$Lambda$a$uGSgKJ18dkC1hH8pUMON19Sf2ao(this), new $$Lambda$a$12Jl8CCtObskLqkodcwpLH_l4(this), new $$Lambda$a$J66a7D2cDZjUunWgoNsRnZPKU(this), null, null, 24, null);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.virt.impl.a.b.d a(a r0) {
        return r0.o;
    }

    public static final /* synthetic */ Object a(a r2, Ctrd.d r3, ParcelFileDescriptor r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, com.obric.aiagent.skill.virt.api.g r3, String r4, com.obric.aiagent.skill.virt.api.f r5, d.c.d r6) {
        return r2.b((com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, e r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, com.obric.aiagent.skill.virt.impl.a.b r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, String r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r0, AtomicReference r1, String r2, AtomicBoolean r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ Object a(a r2, kotlinx.coroutines.w r3, d.c.d r4) {
        return r2.a((kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(a r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ List a(a r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, b r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ Object b(a r2, Ctrd.d r3, ParcelFileDescriptor r4, String r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.j;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public String a() {
        return this.f21641d;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public int c() {
        return this.f21642e;
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public com.obric.aiagent.skill.virt.impl.a.a b() {
        String r1 = e();
        e r2 = this.m;
        if (r2 == null) goto L6;
        String r3 = r2.c();
        if (r3 == null) goto L6;
    L8:
        return new com.obric.aiagent.skill.virt.impl.a.a(r1, r3);
    L6:
        r3 = "/home/share";
        goto L8
    }

    private final String e() {
        return com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a("/home/virt", this.f21639b);
    }

    private final SafetyGuardProxyRuntime f() {
        return (SafetyGuardProxyRuntime) ZeusTransformUtils.preCheckCast(this.l.b(), SafetyGuardProxyRuntime.class, "com.obric.aiagent.plugin");
    }

    private static final SafetyGuardProxyRuntime c(a r2) {
        Context r3 = r2.g;
        d.h.b.o.c(r3, "appContext");
        return SafetyGuard.DefaultImpls.createProxyRuntime$default(SafetyGuardKt.getSafetyGuard(r3), null, 1, null);
    }

    private static final File d(a r1) {
        return new File(r1.g().b());
    }

    private static final String e(a r0) {
        return r0.g().c();
    }

    private static final File f(a r2) {
        return new File(r2.g.getCacheDir(), "runtime_exports");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x03cb: MOVE (r1 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:150:0x03cb */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Class, java.lang.Class<com.obric.aiagent.skill.virt.impl.a.a.a>] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(d.c.d<? super d.x> r18) {
        a r0 = this;
        ?? r1 = a.class;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ae.class) == false) goto L7;
        ae r4 = (ae) ZeusTransformUtils.preCheckCast(r2, ae.class, "com.obric.aiagent.plugin");
        if ((r4.i & Integer.MIN_VALUE) == 0) goto L7;
        r4.i -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.g;
        Object r5 = d.c.a.b.a();
        int r9 = 0;
        switch(r4.i) {
            case 0: goto L55;
            case 1: goto L54;
            case 2: goto L47;
            case 3: goto L42;
            case 4: goto L33;
            case 5: goto L26;
            case 6: goto L21;
            case 7: goto L18;
            case 8: goto L15;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        th = (Throwable) ZeusTransformUtils.preCheckCast(r4.f21663b, Throwable.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r6 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21662a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L45
    L143:
        throw th;     // Catch: Throwable -> L45
    L15:
        th = (Throwable) ZeusTransformUtils.preCheckCast(r4.f21665d, Throwable.class, "com.obric.aiagent.plugin");
        Ctrd.d r7 = (Ctrd.d) ZeusTransformUtils.preCheckCast(r4.f21664c, Ctrd.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r8 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21663b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r4.f21662a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L24
    L138:
        kotlinx.coroutines.f.a r14 = r8;
    L139:
        r4.f21662a = r14;     // Catch: Throwable -> L149
        r4.f21663b = th;     // Catch: Throwable -> L149
        r4.f21664c = null;     // Catch: Throwable -> L149
        r4.f21665d = null;     // Catch: Throwable -> L149
        r4.f21666e = null;     // Catch: Throwable -> L149
        r4.i = 9;     // Catch: Throwable -> L149
        if (r10.a(r7, r4) != r5) goto L143;
        return r5;
    L18:
        e = (CancellationException) ZeusTransformUtils.preCheckCast(r4.f21663b, CancellationException.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r11 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21662a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L45
    L161:
        throw e;     // Catch: Throwable -> L45
    L21:
        e = (CancellationException) ZeusTransformUtils.preCheckCast(r4.f21665d, CancellationException.class, "com.obric.aiagent.plugin");
        Ctrd.d r12 = (Ctrd.d) ZeusTransformUtils.preCheckCast(r4.f21664c, Ctrd.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r13 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21663b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r10 = (a) ZeusTransformUtils.preCheckCast(r4.f21662a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L24
    L156:
        r14 = r13;
    L157:
        r4.f21662a = r14;     // Catch: Throwable -> L149
        r4.f21663b = e;     // Catch: Throwable -> L149
        r4.f21664c = null;     // Catch: Throwable -> L149
        r4.f21665d = null;     // Catch: Throwable -> L149
        r4.f21666e = null;     // Catch: Throwable -> L149
        r4.i = 7;     // Catch: Throwable -> L149
        if (r10.a(r12, r4) != r5) goto L161;
        return r5;
    L26:
        int r15 = r4.f;
        d r16 = (d) ZeusTransformUtils.preCheckCast(r4.f21666e, d.class, "com.obric.aiagent.plugin");
        Ctrd.d r17 = (Ctrd.d) ZeusTransformUtils.preCheckCast(r4.f21665d, Ctrd.d.class, "com.obric.aiagent.plugin");
        Ctrd.e r19 = (Ctrd.e) ZeusTransformUtils.preCheckCast(r4.f21664c, Ctrd.e.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r110 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21663b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r10 = (a) ZeusTransformUtils.preCheckCast(r4.f21662a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L29 CancellationException -> L31
        r14 = r110;
    L196:
        Ctrd.g r20 = (Ctrd.g) ZeusTransformUtils.preCheckCast(r3, Ctrd.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108 CancellationException -> L110
        if (r20.d() == true) goto L93;
    L97:
        if (r9 == 0) goto L107;
        String r21 = r20.a();     // Catch: Throwable -> L108 CancellationException -> L110
        String r22 = r20.b();     // Catch: Throwable -> L108 CancellationException -> L110
        if (r16 == null) goto L105;
        e r23 = new e(r17, r21, r22, r16);     // Catch: Throwable -> L108 CancellationException -> L110
        r10.m = r23;     // Catch: Throwable -> L108 CancellationException -> L110
        r10.a(r23, r16);     // Catch: Throwable -> L108 CancellationException -> L110
        d.x r24 = d.x.f38692a;     // Catch: Throwable -> L149
        r14.b(null);
        return d.x.f38692a;
    L105:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L108 CancellationException -> L110
    L107:
        throw new IllegalStateException(("Ctrd share path failed: error=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r20.c())).toString());     // Catch: Throwable -> L108 CancellationException -> L110
    L93:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L97;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20.b(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L97;
        r9 = 1;
    L110:
        e = e;
        r9 = r15;
        r12 = r17;
    L147:
        if (r9 != 0) goto L151;
        com.obric.aiagent.skill.virt.impl.a.a.b.a(r19.d());     // Catch: Throwable -> L149
    L151:
        if (r16 == null) goto L157;
        r4.f21662a = r10;     // Catch: Throwable -> L149
        r4.f21663b = r14;     // Catch: Throwable -> L149
        r4.f21664c = r12;     // Catch: Throwable -> L149
        r4.f21665d = e;     // Catch: Throwable -> L149
        r4.f21666e = null;     // Catch: Throwable -> L149
        r4.i = 6;     // Catch: Throwable -> L149
        if (r10.a(r16, "open_cancelled", r4) != r5) goto L155;
        return r5;
    L155:
        r13 = r14;
    L108:
        th = th;
        r9 = r15;
        r7 = r17;
    L131:
        if (r9 != 0) goto L133;
        com.obric.aiagent.skill.virt.impl.a.a.b.a(r19.d());     // Catch: Throwable -> L149
    L133:
        if (r16 == null) goto L139;
        r4.f21662a = r10;     // Catch: Throwable -> L149
        r4.f21663b = r14;     // Catch: Throwable -> L149
        r4.f21664c = r7;     // Catch: Throwable -> L149
        r4.f21665d = th;     // Catch: Throwable -> L149
        r4.f21666e = null;     // Catch: Throwable -> L149
        r4.i = 8;     // Catch: Throwable -> L149
        if (r10.a(r16, "open_failed", r4) != r5) goto L137;
        return r5;
    L137:
        r8 = r14;
        goto L138
    L31:
        e = e;
        r9 = r15;
        r12 = r17;
        r14 = r110;
    L29:
        th = th;
        r9 = r15;
        r7 = r17;
        r14 = r110;
        goto L131
    L33:
        r15 = r4.f;
        Ctrd.d r25 = (Ctrd.d) ZeusTransformUtils.preCheckCast(r4.f21665d, Ctrd.d.class, "com.obric.aiagent.plugin");
        Ctrd.e r26 = (Ctrd.e) ZeusTransformUtils.preCheckCast(r4.f21664c, Ctrd.e.class, "com.obric.aiagent.plugin");
        r14 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21663b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r10 = (a) ZeusTransformUtils.preCheckCast(r4.f21662a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L36 CancellationException -> L39
        r17 = r25;
        Ctrd.e r27 = r26;
    L189:
        d r28 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L116 CancellationException -> L118
    L194:
        d.h.a.m r29 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new ag(r17, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L112 CancellationException -> L114
        r4.f21662a = r10;     // Catch: Throwable -> L112 CancellationException -> L114
        r4.f21663b = r14;     // Catch: Throwable -> L112 CancellationException -> L114
        r4.f21664c = r27;     // Catch: Throwable -> L112 CancellationException -> L114
        r4.f21665d = r17;     // Catch: Throwable -> L112 CancellationException -> L114
        r4.f21666e = r28;     // Catch: Throwable -> L112 CancellationException -> L114
        r4.f = r15;     // Catch: Throwable -> L112 CancellationException -> L114
        r4.i = 5;     // Catch: Throwable -> L112 CancellationException -> L114
        Object r30 = dg.a(15000, r29, r4);     // Catch: Throwable -> L112 CancellationException -> L114
        if (r30 != r5) goto L89;
        return r5;
    L89:
        r19 = r27;
        r16 = r28;
        r3 = r30;
        goto L196
    L114:
        e = e;
        r9 = r15;
        r19 = r27;
        r12 = r17;
        r16 = r28;
    L112:
        th = th;
        r9 = r15;
        r19 = r27;
        r7 = r17;
        r16 = r28;
    L118:
        e = e;
        r9 = r15;
        r19 = r27;
        r12 = r17;
    L41:
        r16 = null;
    L116:
        th = th;
        r9 = r15;
        r19 = r27;
        r7 = r17;
    L38:
        r16 = null;
        goto L131
    L39:
        e = e;
        r9 = r15;
        r12 = r25;
        r19 = r26;
    L36:
        th = th;
        r9 = r15;
        r7 = r25;
        r19 = r26;
        goto L38
    L42:
        Ctrd.e r31 = (Ctrd.e) ZeusTransformUtils.preCheckCast(r4.f21663b, Ctrd.e.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r32 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21662a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L45
    L168:
        r19 = r31;
    L171:
        throw new IllegalStateException(("Ctrd open failed: code=" + r19.a() + " gatewayState=" + r19.c() + " error=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r19.f()) + " ctrdout=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r19.e())).toString());     // Catch: Throwable -> L45
    L47:
        kotlinx.coroutines.f.a r33 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21663b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r4.f21662a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L50 LinkageError -> L52
    L49:
        r10 = r0;
        r19 = (Ctrd.e) ZeusTransformUtils.preCheckCast(r3, Ctrd.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50 LinkageError -> L52
        Ctrd.d r111 = r19.b();     // Catch: Throwable -> L50
        if (r19.g() == false) goto L162;
        if (r111 == null) goto L162;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r111.a(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L162;
    L144:
        e = e;
    L146:
        r16 = null;
        r14 = r33;
        r12 = r111;
    L128:
        th = th;
    L130:
        r16 = null;
        r14 = r33;
        r7 = r111;
        goto L131
    L78:
        if (r19.h() == false) goto L127;
        ParcelFileDescriptor r34 = r19.d();     // Catch: Throwable -> L128 CancellationException -> L144
        if (r34 == null) goto L125;
        r4.f21662a = r10;     // Catch: Throwable -> L120 CancellationException -> L122
        r4.f21663b = r33;     // Catch: Throwable -> L120 CancellationException -> L122
        r4.f21664c = r19;     // Catch: Throwable -> L120 CancellationException -> L122
        r4.f21665d = r111;     // Catch: Throwable -> L120 CancellationException -> L122
        r4.f = 1;     // Catch: Throwable -> L120 CancellationException -> L122
        r4.i = 4;     // Catch: Throwable -> L120 CancellationException -> L122
        Object r35 = r10.b(r111, r34, "open", r4);     // Catch: Throwable -> L120 CancellationException -> L122
        if (r35 != r5) goto L84;
        return r5;
    L84:
        r27 = r19;
        r17 = r111;
        r3 = r35;
        r14 = r33;
        r15 = 1;
        goto L189
    L122:
        e = e;
        r9 = 1;
    L120:
        th = th;
        r9 = 1;
        goto L130
    L125:
        throw new IllegalStateException("Ctrd Gateway started without a proxy fd".toString());     // Catch: Throwable -> L128 CancellationException -> L144
    L127:
        throw new IllegalStateException(("Ctrd Gateway failed to start: code=" + r19.a() + " gatewayState=" + r19.c() + " error=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r19.f())).toString());     // Catch: Throwable -> L128 CancellationException -> L144
    L162:
        com.obric.aiagent.skill.virt.impl.a.a.b.a(r19.d());     // Catch: Throwable -> L50
        if (r111 == null) goto L171;
        r4.f21662a = r33;     // Catch: Throwable -> L50
        r4.f21663b = r19;     // Catch: Throwable -> L50
        r4.i = 3;     // Catch: Throwable -> L50
        if (r10.a(r111, r4) != r5) goto L167;
        return r5;
    L167:
        r31 = r19;
    L52:
        e = e;
    L174:
        throw new IllegalStateException("Ctrd system runtime API is incompatible with the pinned 1.0.1 SDK", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L45
    L50:
        th = th;
        r1 = r33;
    L177:
        r1.b(null);
        throw th;
    L54:
        kotlinx.coroutines.f.a r36 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21663b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        a r37 = (a) ZeusTransformUtils.preCheckCast(r4.f21662a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);
        kotlinx.coroutines.f.a r38 = r36;
        r0 = r37;
    L59:
        if (r0.m == null) goto L65;
        d.x r39 = d.x.f38692a;     // Catch: Throwable -> L45
        r38.b(null);
        return r39;
    L65:
        if ((!r0.n) == false) goto L176;
        d.h.a.m r40 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new af(null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45 LinkageError -> L172
        r4.f21662a = r0;     // Catch: Throwable -> L45 LinkageError -> L172
        r4.f21663b = r38;     // Catch: Throwable -> L45 LinkageError -> L172
        r4.i = 2;     // Catch: Throwable -> L45 LinkageError -> L172
        r3 = dg.a(15000, r40, r4);     // Catch: Throwable -> L45 LinkageError -> L172
        if (r3 != r5) goto L69;
        return r5;
    L69:
        r33 = r38;
    L172:
        e = e;
        goto L174
    L176:
        throw new IllegalStateException("Ctrd runtime is closing".toString());     // Catch: Throwable -> L45
    L55:
        d.o.a(r3);
        r38 = r0.f;
        r4.f21662a = r0;
        r4.f21663b = r38;
        r4.i = 1;
        if (r38.a(null, r4) != r5) goto L59;
        return r5;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L45:
        th = th;
    L149:
        th = th;
        r1 = r14;
    L24:
        th = th;
        r1 = " error=";
    L7:
        r4 = new ae(r0, r2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v3, types: [d.h.b.z$a] */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [com.obric.aiagent.skill.virt.impl.a.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19, types: [com.obric.aiagent.skill.virt.impl.a.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r13v3, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r13v32, types: [d.h.b.z$a] */
    /* JADX WARN: Type inference failed for: r13v35, types: [d.h.b.z$a] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v41 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v49 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v50 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v22, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r14v29, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.aiagent.skill.virt.impl.a.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v41, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3, types: [d.h.b.z$a] */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34, types: [d.h.b.z$a] */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v4, types: [d.h.b.z$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v41, types: [d.h.b.z$a] */
    /* JADX WARN: Type inference failed for: r6v57, types: [d.h.b.z$a] */
    /* JADX WARN: Type inference failed for: r6v58 */
    /* JADX WARN: Type inference failed for: r6v59 */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r6v61 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0231 -> B:63:0x0239). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x035d -> B:208:0x0368). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object b(d.c.d<? super d.x> r28) {
        ?? r1 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L7;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin");
        if ((r4.j & Integer.MIN_VALUE) == 0) goto L7;
        r4.j -= Integer.MIN_VALUE;
    L8:
        Object r2 = r4.h;
        Object r5 = d.c.a.b.a();
        int r6 = r4.j;
        ?? r12 = 4;
        ?? r13 = 3;
        ?? r14 = 3;
        boolean r7 = true;
        d.c.d r8 = null;
        if (r6 == 0) goto L43;
        if (r6 == 1) goto L38;
        if (r6 == 2) goto L33;
        if (r6 == 3) goto L27;
        if (r6 == 4) goto L22;
        if (r6 != 5) goto L21;
        List r3 = (List) ZeusTransformUtils.preCheckCast(r4.f21733d, List.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r9 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21732c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        ?? r10 = (d.h.b.z.a) ZeusTransformUtils.preCheckCast(r4.f21731b, d.h.b.z.a.class, "com.obric.aiagent.plugin");
        ?? r11 = (a) ZeusTransformUtils.preCheckCast(r4.f21730a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L18
        r11 = r11;
        r10 = r10;
    L121:
        Object r15 = d.n.f((Ctrd.c) ZeusTransformUtils.preCheckCast(r2, Ctrd.c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        ?? r16 = r11;
        ?? r17 = r10;
    L126:
        r13 = r16;
        kotlinx.coroutines.f.a r18 = r9;
        ?? r19 = r17;
        Throwable r20 = d.n.c(r15);     // Catch: Throwable -> L25
        if (r20 == null) goto L131;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add("close: " + com.obric.aiagent.skill.virt.impl.a.a.b.a(r20));     // Catch: Throwable -> L25
        r15 = null;
    L131:
        Ctrd.c r21 = (Ctrd.c) ZeusTransformUtils.preCheckCast(r15, Ctrd.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r21 != null) goto L134;
    L136:
        Collection<b> r22 = r13.j.values();     // Catch: Throwable -> L157
        d.h.b.o.c(r22, "<get-values>(...)");     // Catch: Throwable -> L157
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L157
    L138:
        if (r23.hasNext() == false) goto L140;
        b r24 = (b) ZeusTransformUtils.preCheckCast(r23.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L157
        d.h.b.o.a(r24);     // Catch: Throwable -> L157
        r13.a(r24, null, true);     // Catch: Throwable -> L157
        goto L138
    L140:
        r13.j.clear();     // Catch: Throwable -> L157
        r13.i.set(null);     // Catch: Throwable -> L157
        r13.m = null;     // Catch: Throwable -> L157
        r13.n = false;     // Catch: Throwable -> L157
        if (r3.isEmpty() == false) goto L144;
        ?? r25 = r19;
        r1 = r13;
    L204:
        d.x r26 = d.x.f38692a;     // Catch: Throwable -> L168
        r18.b(null);     // Catch: Throwable -> L178
        if (r25.f38499a == false) goto L167;
        r1.k.a("close");
    L167:
        return d.x.f38692a;
    L178:
        th = th;
    L180:
        if (r25.f38499a == false) goto L182;
        r1.k.a("close");
    L182:
        throw th;
    L168:
        th = th;
        ?? r110 = r1;
        r25 = r25;
    L183:
        r18.b(null);     // Catch: Throwable -> L176
        throw th;     // Catch: Throwable -> L176
    L176:
        th = th;
        r1 = r110;
        goto L180
    L144:
        throw new IllegalStateException(("Ctrd close did not fully reconcile: " + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null)).toString());     // Catch: Throwable -> L157
    L134:
        if (r21.d() == true) goto L136;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add("close: code=" + r21.a() + " error=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r21.c()) + " ctrdout=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r21.b()));     // Catch: Throwable -> L25
    L18:
        th = th;
    L196:
        d.n.a r27 = d.n.f38560a;     // Catch: Throwable -> L145
        r15 = d.n.f(d.o.a(th));     // Catch: Throwable -> L145
        r16 = r11;
        r17 = r10;
    L145:
        th = th;
        r13 = r11;
    L151:
        Collection<b> r29 = r13.j.values();     // Catch: Throwable -> L157
        d.h.b.o.c(r29, "<get-values>(...)");     // Catch: Throwable -> L157
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L157
    L153:
        if (r30.hasNext() == false) goto L155;
        b r31 = (b) ZeusTransformUtils.preCheckCast(r30.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L157
        d.h.b.o.a(r31);     // Catch: Throwable -> L157
        r13.a(r31, null, true);     // Catch: Throwable -> L157
        goto L153
    L155:
        r13.j.clear();     // Catch: Throwable -> L157
        r13.i.set(null);     // Catch: Throwable -> L157
        r13.m = null;     // Catch: Throwable -> L157
        r13.n = false;     // Catch: Throwable -> L157
        throw th;     // Catch: Throwable -> L157
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        e r32 = (e) ZeusTransformUtils.preCheckCast(r4.f21734e, e.class, "com.obric.aiagent.plugin");
        List r33 = (List) ZeusTransformUtils.preCheckCast(r4.f21733d, List.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r34 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21732c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.h.b.z.a r111 = (d.h.b.z.a) ZeusTransformUtils.preCheckCast(r4.f21731b, d.h.b.z.a.class, "com.obric.aiagent.plugin");
        a r112 = (a) ZeusTransformUtils.preCheckCast(r4.f21730a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L25
        ?? r113 = r111;
        ?? r114 = r112;
    L114:
        d.x r35 = d.x.f38692a;     // Catch: Throwable -> L25
        Object r36 = r5;
        r9 = r34;
        ?? r115 = r113;
        ?? r116 = r114;
    L194:
        d.n.a r37 = d.n.f38560a;     // Catch: Throwable -> L123
        a r38 = (a) ZeusTransformUtils.preCheckCast(r116, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L123
        d.h.a.m r39 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r32, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L123
        r4.f21730a = r116;     // Catch: Throwable -> L123
        r4.f21731b = r115;     // Catch: Throwable -> L123
        r4.f21732c = r9;     // Catch: Throwable -> L123
        r4.f21733d = r33;     // Catch: Throwable -> L123
        r4.f21734e = null;     // Catch: Throwable -> L123
        r4.f = null;     // Catch: Throwable -> L123
        r4.g = null;     // Catch: Throwable -> L123
        r4.j = 5;     // Catch: Throwable -> L123
        Object r40 = dg.a(15000, r39, r4);     // Catch: Throwable -> L123
        if (r40 != r36) goto L120;
        return r36;
    L120:
        r2 = r40;
        r3 = r33;
        r10 = r115;
        r11 = r116;
    L123:
        th = th;
        r3 = r33;
        r10 = r115;
        r11 = r116;
        goto L196
    L27:
        b r41 = (b) ZeusTransformUtils.preCheckCast(r4.g, b.class, "com.obric.aiagent.plugin");
        Iterator r42 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f, Iterator.class, "com.obric.aiagent.plugin");
        e r43 = (e) ZeusTransformUtils.preCheckCast(r4.f21734e, e.class, "com.obric.aiagent.plugin");
        List r117 = (List) ZeusTransformUtils.preCheckCast(r4.f21733d, List.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r118 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21732c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        ?? r119 = (d.h.b.z.a) ZeusTransformUtils.preCheckCast(r4.f21731b, d.h.b.z.a.class, "com.obric.aiagent.plugin");
        ?? r120 = (a) ZeusTransformUtils.preCheckCast(r4.f21730a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L30
        e r44 = r43;
        r119 = r119;
        r120 = r120;
    L208:
        Object r45 = d.n.f((com.obric.aiagent.skill.virt.impl.a.h) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.virt.impl.a.h.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L91
        r18 = r118;
        ?? r121 = r119;
        r13 = r120;
    L100:
        if (d.n.a(r45) == true) goto L102;
        ((Collection) ZeusTransformUtils.preCheckCast(r117, Collection.class, "com.obric.aiagent.plugin")).add("reconcile " + r41.a() + ": timeout");     // Catch: Throwable -> L25
        d.h.b.o.a(r41);     // Catch: Throwable -> L25
        r13.a(r41, null, true);     // Catch: Throwable -> L25
    L102:
        r32 = r44;
        r121 = r121;
        r13 = r13;
    L81:
        if (r42.hasNext() == true) goto L190;
        kotlinx.coroutines.f.a r122 = r18;
        d r46 = (d) ZeusTransformUtils.preCheckCast(r32.d().getAndSet(null), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L147
        if (r46 == null) goto L116;
        r4.f21730a = r13;     // Catch: Throwable -> L147
        r4.f21731b = r121;     // Catch: Throwable -> L147
        r34 = r122;
        r4.f21732c = r34;     // Catch: Throwable -> L25
        r4.f21733d = r117;     // Catch: Throwable -> L25
        r4.f21734e = r32;     // Catch: Throwable -> L25
        r4.f = null;     // Catch: Throwable -> L25
        r4.g = null;     // Catch: Throwable -> L25
        r4.j = 4;     // Catch: Throwable -> L25
        if (r13.a(r46, "runtime_close", r4) != r5) goto L113;
        return r5;
    L113:
        r33 = r117;
        r113 = r121;
        r114 = r13;
        goto L114
    L116:
        r36 = r5;
        r9 = r122;
        r33 = r117;
        r115 = r121;
        r116 = r13;
    L147:
        th = th;
        goto L151
    L190:
        b r47 = (b) ZeusTransformUtils.preCheckCast(r42.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
        d.n.a r48 = d.n.f38560a;     // Catch: Throwable -> L95
        a r49 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        d.h.a.m r50 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r47, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        r4.f21730a = r13;     // Catch: Throwable -> L95
        r4.f21731b = r121;     // Catch: Throwable -> L95
        r4.f21732c = r18;     // Catch: Throwable -> L95
        r4.f21733d = r117;     // Catch: Throwable -> L95
        r4.f21734e = r32;     // Catch: Throwable -> L95
        r4.f = r42;     // Catch: Throwable -> L95
        r4.g = r47;     // Catch: Throwable -> L95
        r4.j = 3;     // Catch: Throwable -> L95
        kotlinx.coroutines.f.a r123 = r18;
        r2 = dg.a(10000, r50, r4);     // Catch: Throwable -> L93
        if (r2 != r5) goto L88;
        return r5;
    L88:
        r44 = r32;
        r41 = r47;
        ?? r210 = r13;
        r119 = r121;
        r118 = r123;
        r120 = r210;
    L93:
        th = th;
        r18 = r123;
    L97:
        r44 = r32;
        r41 = r47;
        d.n.a r51 = d.n.f38560a;     // Catch: Throwable -> L25
        r45 = d.n.f(d.o.a(th));     // Catch: Throwable -> L25
    L95:
        th = th;
    L103:
        th = th;
    L91:
        Throwable th = th;
    L32:
        r18 = r118;
        r121 = r119;
        r13 = r120;
        d.n.a r52 = d.n.f38560a;     // Catch: Throwable -> L25
        r45 = d.n.f(d.o.a(th));     // Catch: Throwable -> L25
    L30:
        th = th;
        r44 = r43;
        goto L32
    L33:
        b r53 = (b) ZeusTransformUtils.preCheckCast(r4.g, b.class, "com.obric.aiagent.plugin");
        Iterator r54 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f, Iterator.class, "com.obric.aiagent.plugin");
        e r55 = (e) ZeusTransformUtils.preCheckCast(r4.f21734e, e.class, "com.obric.aiagent.plugin");
        r117 = (List) ZeusTransformUtils.preCheckCast(r4.f21733d, List.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r124 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21732c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        ?? r125 = (d.h.b.z.a) ZeusTransformUtils.preCheckCast(r4.f21731b, d.h.b.z.a.class, "com.obric.aiagent.plugin");
        ?? r126 = (a) ZeusTransformUtils.preCheckCast(r4.f21730a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L36
        r125 = r125;
        r126 = r126;
    L63:
        Object r56 = d.n.f((Ctrd.i) ZeusTransformUtils.preCheckCast(r2, Ctrd.i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L36
        e r57 = r55;
        r18 = r124;
        ?? r127 = r125;
        ?? r128 = r126;
    L68:
        Throwable r58 = d.n.c(r56);     // Catch: Throwable -> L25
        e r129 = r57;
        if (r58 == null) goto L73;
        ((Collection) ZeusTransformUtils.preCheckCast(r117, Collection.class, "com.obric.aiagent.plugin")).add("kill " + r53.a() + ": " + com.obric.aiagent.skill.virt.impl.a.a.b.a(r58));     // Catch: Throwable -> L25
        r56 = null;
    L73:
        Ctrd.i r59 = (Ctrd.i) ZeusTransformUtils.preCheckCast(r56, Ctrd.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r59 != null) goto L76;
    L78:
        r32 = r129;
        r4 = r4;
        r5 = r5;
        r7 = true;
        r8 = null;
        r127 = r127;
        r128 = r128;
    L57:
        if (r54.hasNext() == false) goto L79;
        b r130 = (b) ZeusTransformUtils.preCheckCast(r54.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r130.d().set(r7);     // Catch: Throwable -> L25
        d.n.a r60 = d.n.f38560a;     // Catch: Throwable -> L65
        a r61 = (a) ZeusTransformUtils.preCheckCast(r128, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        d.h.a.m r62 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r130, r8), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        r4.f21730a = r128;     // Catch: Throwable -> L65
        r4.f21731b = r127;     // Catch: Throwable -> L65
        r4.f21732c = r18;     // Catch: Throwable -> L65
        r4.f21733d = r117;     // Catch: Throwable -> L65
        r4.f21734e = r32;     // Catch: Throwable -> L65
        r4.f = r54;     // Catch: Throwable -> L65
        r4.g = r130;     // Catch: Throwable -> L65
        r4.j = 2;     // Catch: Throwable -> L65
        r2 = dg.a(10000, r62, r4);     // Catch: Throwable -> L65
        if (r2 != r5) goto L62;
        return r5;
    L62:
        kotlinx.coroutines.f.a r211 = r18;
        r55 = r32;
        r53 = r130;
        r126 = r128;
        r125 = r127;
        r124 = r211;
    L65:
        th = move-exception;
        r57 = r32;
        r53 = r130;
        d.n.a r63 = d.n.f38560a;     // Catch: Throwable -> L25
        r56 = d.n.f(d.o.a(th));     // Catch: Throwable -> L25
        goto L68
    L79:
        Collection<b> r64 = r128.j.values();     // Catch: Throwable -> L25
        d.h.b.o.c(r64, "<get-values>(...)");     // Catch: Throwable -> L25
        r42 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r64, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L25
        r121 = r127;
        r13 = r128;
        goto L81
    L76:
        if (r59.f() == true) goto L78;
        ((Collection) ZeusTransformUtils.preCheckCast(r117, Collection.class, "com.obric.aiagent.plugin")).add("kill " + r53.a() + ": " + com.obric.aiagent.skill.virt.impl.a.a.b.b(r59.e()) + ' ' + com.obric.aiagent.skill.virt.impl.a.a.b.b(r59.d()));     // Catch: Throwable -> L25
    L36:
        th = move-exception;
        r57 = r55;
        r18 = r124;
        r127 = r125;
        r128 = r126;
        d.n.a r65 = d.n.f38560a;     // Catch: Throwable -> L25
        r56 = d.n.f(d.o.a(th));     // Catch: Throwable -> L25
        goto L68
    L38:
        kotlinx.coroutines.f.a r66 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21732c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r25 = (d.h.b.z.a) ZeusTransformUtils.preCheckCast(r4.f21731b, d.h.b.z.a.class, "com.obric.aiagent.plugin");
        a r67 = (a) ZeusTransformUtils.preCheckCast(r4.f21730a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L41
        r12 = r25;
        r18 = r66;
        ?? r68 = r67;
    L210:
        e r69 = r68.m;     // Catch: Throwable -> L170
        if (r69 != null) goto L52;
    L159:
        r25 = r12;
        r1 = r68;
        goto L204
    L52:
        if (r68.n == true) goto L159;
        r12.f38499a = true;     // Catch: Throwable -> L170
        r68.n = true;     // Catch: Throwable -> L170
        List r70 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L170
        Collection<b> r131 = r68.j.values();     // Catch: Throwable -> L149
        d.h.b.o.c(r131, "<get-values>(...)");     // Catch: Throwable -> L149
        Iterator r132 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r131, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L149
        r128 = r68;
        r32 = r69;
        r117 = r70;
        r54 = r132;
        r127 = r12;
    L149:
        th = th;
        r13 = r68;
    L170:
        th = th;
        r14 = r68;
    L172:
        r25 = r12;
        r110 = r14;
    L41:
        th = th;
        r1 = r67;
        goto L180
    L43:
        d.o.a(r2);
        r25 = new d.h.b.z.a();
        kotlinx.coroutines.f.a r71 = r1.f;     // Catch: Throwable -> L178
        r4.f21730a = r1;     // Catch: Throwable -> L178
        r4.f21731b = r25;     // Catch: Throwable -> L178
        r4.f21732c = r71;     // Catch: Throwable -> L178
        r4.j = 1;     // Catch: Throwable -> L178
        if (r71.a(null, r4) != r5) goto L47;
        return r5;
    L47:
        r18 = r71;
        r12 = r25;
        r68 = r1;
    L157:
        th = th;
    L25:
        th = th;
    L7:
        r4 = new g(r1, r0);
        goto L8
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.l
    public void b(String r2) {
        d.h.b.o.e(r2, "trigger");
        this.k.a(r2);
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.l
    public Object a(String r3, d.c.d<? super String> r4) {
        d.c.d<? super String> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return this.k.a(r3, r5);
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.l
    public String d() {
        return this.k.a();
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public String a(String r7) {
        d.h.b.o.e(r7, "workDir");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString(), new char[]{'/'}), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r0) == false) goto L5;
        r0 = e();
    L5:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == false) goto L13;
        if ((!com.obric.aiagent.skill.virt.impl.a.a.b.a(r6)) == false) goto L11;
        return r6;
    L11:
        throw new IllegalArgumentException(("Ctrd workDir must not contain parent traversal: " + r7).toString());
    L13:
        throw new IllegalArgumentException(("Ctrd workDir must be absolute: " + r7).toString());
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(com.obric.aiagent.skill.virt.api.g r9, String r10, com.obric.aiagent.skill.virt.api.f r11, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r12) {
        com.obric.aiagent.skill.virt.api.g r5 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ab(r10, r11, r5, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(String r9, com.obric.aiagent.skill.virt.api.c r10, com.obric.aiagent.skill.virt.api.b r11, d.c.d<? super com.obric.aiagent.skill.virt.api.d> r12) {
        com.obric.aiagent.skill.virt.api.c r5 = (com.obric.aiagent.skill.virt.api.c) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.aiagent.skill.virt.api.c.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new aa(r9, this, r5, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    private final Object b(com.obric.aiagent.skill.virt.api.g r21, String r22, com.obric.aiagent.skill.virt.api.f r23, d.c.d<? super com.obric.aiagent.skill.virt.api.h> r24) {
        a r1 = this;
        String r0 = r22;
        com.obric.aiagent.skill.virt.api.g r2 = (com.obric.aiagent.skill.virt.api.g) ZeusTransformUtils.wrapperContextForParams(r21, com.obric.aiagent.skill.virt.api.g.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ai.class) == false) goto L7;
        ai r4 = (ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        ai r10 = r4;
        Object r5 = r10.f21679e;
        Object r11 = d.c.a.b.a();
        int r6 = r10.g;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r7 = r10.f21678d;
        com.obric.aiagent.skill.virt.impl.a.b.b r8 = (com.obric.aiagent.skill.virt.impl.a.b.b) ZeusTransformUtils.preCheckCast(r10.f21677c, com.obric.aiagent.skill.virt.impl.a.b.b.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r10.f21676b, String.class, "com.obric.aiagent.plugin");
        a r12 = (a) ZeusTransformUtils.preCheckCast(r10.f21675a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L14
        r0 = r9;
        r1 = r12;
        boolean r13 = true;
        long r14 = r7;
    L45:
        com.obric.aiagent.skill.virt.impl.a.c.a r15 = (com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r15.c() == 0) goto L31;
        r13 = false;
    L31:
        if (r13 == false) goto L36;
        com.obric.aiagent.skill.virt.api.h r16 = new com.obric.aiagent.skill.virt.api.h(com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.b(r0), r14);     // Catch: Throwable -> L37
        r1.o.a(r8.a());
        return r16;
    L36:
        throw new IllegalStateException(("Ctrd import failed exit=" + r15.c() + " stderr=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r15.b())).toString());     // Catch: Throwable -> L37
    L37:
        th = th;
    L41:
        r1.o.a(r8.a());
        throw th;
    L14:
        th = th;
        r1 = r12;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r5);
        com.obric.aiagent.skill.virt.impl.a.b.b r17 = r1.o.a(com.obric.aiagent.skill.virt.impl.a.b.c.f21903a, com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a());
        String r18 = r1.o.a(r2, r0);     // Catch: Throwable -> L39
        File r19 = new File(r17.a(), r18);     // Catch: Throwable -> L39
        boolean r20 = ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.virt.api.g.a.class);     // Catch: Throwable -> L39
        long r25 = r1.o.a(r2, r19, r23.c());     // Catch: Throwable -> L39
        String r26 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a.a(r17.b(), r18);     // Catch: Throwable -> L39
        com.obric.aiagent.skill.virt.impl.a.b.d.a r27 = com.obric.aiagent.skill.virt.impl.a.b.d.f21908a;     // Catch: Throwable -> L39
        boolean r28 = r23.a();     // Catch: Throwable -> L39
        boolean r110 = r23.b();     // Catch: Throwable -> L39
        if (r20 == false) goto L22;
        boolean r111 = true;
    L23:
        r14 = r25;
        String r29 = r27.a(r26, r22, r28, r110, r111, r23.d());     // Catch: Throwable -> L39
        r10.f21675a = r1;     // Catch: Throwable -> L39
        r10.f21676b = r0;     // Catch: Throwable -> L39
        r10.f21677c = r17;     // Catch: Throwable -> L39
        r10.f21678d = r14;     // Catch: Throwable -> L39
        r13 = true;
        r10.g = 1;     // Catch: Throwable -> L39
        r5 = r1.a(r29, "import_staging_move", r10);     // Catch: Throwable -> L39
        if (r5 != r11) goto L26;
        return r11;
    L26:
        r8 = r17;
        goto L45
    L22:
        r111 = false;
    L39:
        th = th;
        r8 = r17;
    L7:
        r4 = new ai(r1, r3);
        goto L8
    }

    private final Object a(String r26, String r27, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c.a> r28) {
        a r1 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, u.class) == false) goto L7;
        u r3 = (u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        Object r4 = d.c.a.b.a();
        int r5 = r3.h;
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L19;
        int r6 = r3.f21786e;
        long r7 = r3.f21785d;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.f21784c, String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.f21783b, String.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r3.f21782a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L14 CancellationException -> L16
        long r23 = r7;
        String r11 = r8;
        int r12 = r6;
        r1 = r10;
        String r13 = r9;
    L86:
        com.obric.aiagent.skill.virt.impl.a.c r14 = (com.obric.aiagent.skill.virt.impl.a.c) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.virt.impl.a.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50 CancellationException -> L52
        com.obric.aiagent.skill.virt.impl.c.b r15 = r1.f21640c;     // Catch: Throwable -> L50 CancellationException -> L52
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class) == false) goto L33;
        com.obric.aiagent.skill.virt.impl.c.b.c r16 = (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.impl.c.b.c.C0477b(((com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin")).c()), com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50 CancellationException -> L52
    L35:
        r15.a(r11, "ctrd", r13, r16, true, r23, 0, 0, r14.a().length(), r14.b().length());     // Catch: Throwable -> L50 CancellationException -> L52
    L46:
        e = e;
        r12 = 1;
        long r17 = r23;
        String r18 = r13;
    L73:
        if (r12 != 0) goto L75;
        r1.f21640c.a(r11, "ctrd", r18, (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.a.f22160a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin"), true, r17, 0, 0, 0, 0);
    L75:
        throw e;
    L44:
        th = th;
        r12 = 1;
        long r19 = r23;
        String r20 = r13;
    L66:
        if (r12 != 0) goto L68;
        r1.f21640c.a(r11, "ctrd", r20, (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.C0478c.f22162a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin"), false, r19, 0, 0, 0, 0);
    L68:
        throw th;
    L37:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class) == false) goto L39;
        com.obric.aiagent.skill.virt.impl.a.c.a r21 = (com.obric.aiagent.skill.virt.impl.a.c.a) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.virt.impl.a.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44 CancellationException -> L46
    L40:
        if (r21 == null) goto L43;
        return r21;
    L43:
        throw new IllegalStateException("Ctrd file command timed out");     // Catch: Throwable -> L44 CancellationException -> L46
    L39:
        r21 = null;
        goto L40
    L33:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aiagent.skill.virt.impl.a.c.b.class) == false) goto L49;
        r16 = (com.obric.aiagent.skill.virt.impl.c.b.c) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.virt.impl.c.b.c.d.f22163a, com.obric.aiagent.skill.virt.impl.c.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50 CancellationException -> L52
        goto L35
    L49:
        throw new d.k();     // Catch: Throwable -> L50 CancellationException -> L52
    L52:
        e = e;
        r18 = r13;
        r17 = r23;
    L50:
        th = th;
        r20 = r13;
        r19 = r23;
        goto L66
    L16:
        e = e;
        r17 = r7;
        r11 = r8;
        r18 = r9;
        r12 = r6;
        r1 = r10;
    L14:
        th = th;
        r19 = r7;
        r11 = r8;
        r20 = r9;
        r12 = r6;
        r1 = r10;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r2);
        long r22 = SystemClock.elapsedRealtime();
        r12 = 0;
        com.obric.aiagent.skill.virt.impl.a.b r24 = new com.obric.aiagent.skill.virt.impl.a.b(r26, e(), 60000, r27);     // Catch: Throwable -> L62 CancellationException -> L69
        r3.f21782a = r1;     // Catch: Throwable -> L62 CancellationException -> L69
        String r25 = r26;
        r3.f21783b = r25;     // Catch: Throwable -> L58 CancellationException -> L60
        String r110 = r27;
        r3.f21784c = r110;     // Catch: Throwable -> L54 CancellationException -> L56
        r3.f21785d = r22;     // Catch: Throwable -> L54 CancellationException -> L56
        r3.f21786e = 0;     // Catch: Throwable -> L54 CancellationException -> L56
        r3.h = 1;     // Catch: Throwable -> L54 CancellationException -> L56
        r2 = r1.b(r24, r3);     // Catch: Throwable -> L54 CancellationException -> L56
        if (r2 != r4) goto L28;
        return r4;
    L28:
        r23 = r22;
        r13 = r25;
        r11 = r110;
        goto L86
    L56:
        e = e;
    L72:
        r18 = r25;
        r11 = r110;
        r17 = r22;
    L54:
        th = th;
    L65:
        r20 = r25;
        r11 = r110;
        r19 = r22;
        goto L66
    L60:
        e = e;
    L71:
        r110 = r27;
    L58:
        th = th;
    L64:
        r110 = r27;
        goto L65
    L69:
        e = e;
        r25 = r26;
    L62:
        th = th;
        r25 = r26;
    L7:
        r3 = new u(r1, r0);
        goto L8
    }

    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(com.obric.aiagent.skill.virt.impl.a.b r3, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r4) {
        return b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object b(com.obric.aiagent.skill.virt.impl.a.b r22, d.c.d<? super com.obric.aiagent.skill.virt.impl.a.c> r23) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, v.class) == false) goto L7;
        v r4 = (v) ZeusTransformUtils.preCheckCast(r2, v.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f21791e;
        Object r5 = d.c.a.b.a();
        int r6 = r4.g;
        if (r6 == 0) goto L34;
        if (r6 == 1) goto L33;
        if (r6 == 2) goto L28;
        if (r6 == 3) goto L23;
        if (r6 == 4) goto L18;
        if (r6 != 5) goto L16;
        e = (CancellationException) ZeusTransformUtils.preCheckCast(r4.f21788b, CancellationException.class, "com.obric.aiagent.plugin");
        au r1 = (au) ZeusTransformUtils.preCheckCast(r4.f21787a, au.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L91:
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(r1, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
        throw e;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        Ctrd.i r0 = (Ctrd.i) ZeusTransformUtils.preCheckCast(r4.f21790d, Ctrd.i.class, "com.obric.aiagent.plugin");
        au r7 = (au) ZeusTransformUtils.preCheckCast(r4.f21789c, au.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r8 = (kotlinx.coroutines.w) ZeusTransformUtils.preCheckCast(r4.f21788b, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        a r9 = (a) ZeusTransformUtils.preCheckCast(r4.f21787a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: CancellationException -> L21
    L56:
        Ctrd.i r10 = (Ctrd.i) ZeusTransformUtils.preCheckCast(r3, Ctrd.i.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L21
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(r7, ca.class, "com.obric.aiagent.plugin"), null, 1, null);     // Catch: CancellationException -> L21
        String r11 = "";
        if (r10 == null) goto L61;
        String r12 = r10.b();     // Catch: CancellationException -> L21
        if (r12 == null) goto L61;
    L66:
        if (r10 == null) goto L71;
        String r13 = r10.c();     // Catch: CancellationException -> L21
        if (r13 == null) goto L71;
        r11 = r13;
    L77:
        return new com.obric.aiagent.skill.virt.impl.a.c.b(r12, r11);
    L71:
        if (r0 == null) goto L73;
        String r14 = r0.c();     // Catch: CancellationException -> L21
    L74:
        if (r14 == null) goto L77;
        r11 = r14;
        goto L77
    L73:
        r14 = null;
    L61:
        if (r0 == null) goto L63;
        r12 = r0.b();     // Catch: CancellationException -> L21
    L64:
        if (r12 != null) goto L66;
        r12 = "";
        goto L66
    L63:
        r12 = null;
    L21:
        e = e;
    L87:
        d.c.g r15 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new w(r9, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r4.f21787a = r7;
        r4.f21788b = e;
        r4.f21789c = null;
        r4.f21790d = null;
        r4.g = 5;
        if (kotlinx.coroutines.i.a(r15, r16, r4) != r5) goto L90;
        return r5;
    L90:
        r1 = r7;
        goto L91
    L23:
        r7 = (au) ZeusTransformUtils.preCheckCast(r4.f21789c, au.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r17 = (kotlinx.coroutines.w) ZeusTransformUtils.preCheckCast(r4.f21788b, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        r9 = (a) ZeusTransformUtils.preCheckCast(r4.f21787a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: CancellationException -> L26
    L52:
        r0 = (Ctrd.i) ZeusTransformUtils.preCheckCast(r3, Ctrd.i.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L26
        d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new z(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L26
        r4.f21787a = r9;     // Catch: CancellationException -> L26
        r4.f21788b = r17;     // Catch: CancellationException -> L26
        r4.f21789c = r7;     // Catch: CancellationException -> L26
        r4.f21790d = r0;     // Catch: CancellationException -> L26
        r4.g = 4;     // Catch: CancellationException -> L26
        r3 = dg.b(10000, r18, r4);     // Catch: CancellationException -> L26
        if (r3 != r5) goto L55;
        return r5;
    L55:
        r8 = r17;
    L26:
        e = e;
        r8 = r17;
        goto L87
    L28:
        r7 = (au) ZeusTransformUtils.preCheckCast(r4.f21789c, au.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r19 = (kotlinx.coroutines.w) ZeusTransformUtils.preCheckCast(r4.f21788b, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        r9 = (a) ZeusTransformUtils.preCheckCast(r4.f21787a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: CancellationException -> L31
    L46:
        Ctrd.i r20 = (Ctrd.i) ZeusTransformUtils.preCheckCast(r3, Ctrd.i.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L31
        if (r20 != null) goto L80;
        r4.f21787a = r9;     // Catch: CancellationException -> L31
        r4.f21788b = r19;     // Catch: CancellationException -> L31
        r4.f21789c = r7;     // Catch: CancellationException -> L31
        r4.g = 3;     // Catch: CancellationException -> L31
        r3 = r9.a(r19, r4);     // Catch: CancellationException -> L31
        if (r3 != r5) goto L51;
        return r5;
    L51:
        r17 = r19;
        goto L52
    L80:
        if (r20.f() == false) goto L84;
        return (com.obric.aiagent.skill.virt.impl.a.c) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.impl.a.c.a(r20.a(), r20.b(), r20.c()), com.obric.aiagent.skill.virt.impl.a.c.class, "com.obric.aiagent.plugin");
    L84:
        throw new IllegalStateException(("Ctrd sync shell failed: exit=" + r20.a() + " error=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r20.e()) + " ctrdout=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r20.d())).toString());     // Catch: CancellationException -> L31
    L31:
        e = e;
        r8 = r19;
        goto L87
    L33:
        kotlinx.coroutines.f.a r21 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21789c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.b r24 = (com.obric.aiagent.skill.virt.impl.a.b) ZeusTransformUtils.preCheckCast(r4.f21788b, com.obric.aiagent.skill.virt.impl.a.b.class, "com.obric.aiagent.plugin");
        r9 = (a) ZeusTransformUtils.preCheckCast(r4.f21787a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        com.obric.aiagent.skill.virt.impl.a.b r25 = r24;
        kotlinx.coroutines.f.a r26 = r21;
    L102:
    L95:
        th = move-exception;
        r26.b(null);
        throw th;
    L39:
        if ((!r9.n) == false) goto L94;
        e r110 = r9.g();     // Catch: Throwable -> L95
        r26.b(null);
        kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r27 = kotlinx.coroutines.y.a(null, 1, null);
        au r28 = kotlinx.coroutines.i.b(r9.h, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new x(r110, r9, r25, r27, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        long r111 = r25.c();     // Catch: CancellationException -> L85
        d.h.a.m r29 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new y(r28, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L85
        r4.f21787a = r9;     // Catch: CancellationException -> L85
        r4.f21788b = r27;     // Catch: CancellationException -> L85
        r4.f21789c = r28;     // Catch: CancellationException -> L85
        r4.g = 2;     // Catch: CancellationException -> L85
        r3 = dg.b(r111, r29, r4);     // Catch: CancellationException -> L85
        if (r3 != r5) goto L45;
        return r5;
    L45:
        r19 = r27;
        r7 = r28;
    L85:
        e = e;
        r8 = r27;
        r7 = r28;
        goto L87
    L94:
        throw new IllegalStateException("Ctrd runtime is closing".toString());     // Catch: Throwable -> L95
    L34:
        d.o.a(r3);
        kotlinx.coroutines.f.a r30 = this.f;
        r4.f21787a = this;
        r25 = r22;
        r4.f21788b = r25;
        r4.f21789c = r30;
        r4.g = 1;
        if (r30.a(null, r4) != r5) goto L37;
        return r5;
    L37:
        r26 = r30;
        r9 = this;
    L7:
        r4 = new v(this, r2);
        goto L8
    }

    private final Object a(kotlinx.coroutines.w<d.h.a.b<d.c.d<? super Ctrd.i>, Object>> r4, d.c.d<? super Ctrd.i> r5) {
        kotlinx.coroutines.w r3 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v87, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v33, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v29, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v3, types: [com.obric.aiagent.skill.virt.impl.a.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6, types: [com.obric.aiagent.skill.virt.impl.a.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v1, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.aiagent.skill.virt.impl.a.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v18, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20, types: [com.obric.aiagent.skill.virt.impl.a.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v23, types: [com.obric.aiagent.skill.virt.impl.a.a.a] */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.obric.aiagent.skill.virt.impl.a.k
    public Object a(String r32, String r33, String r34, String r35, Map<String, String> r36, String r37, d.h.a.b<? super com.obric.aiagent.skill.virt.api.r, d.x> r38, d.c.d<? super d.n<com.obric.aiagent.skill.virt.impl.a.f>> r39) {
        ?? r1 = this;
        ?? r2 = r32;
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r38, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r39, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, aj.class) == false) goto L7;
        aj r7 = (aj) ZeusTransformUtils.preCheckCast(r6, aj.class, "com.obric.aiagent.plugin");
        if ((r7.m & Integer.MIN_VALUE) == 0) goto L7;
        r7.m -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.k;
        Object r9 = d.c.a.b.a();
        int r10 = r7.m;
        ?? r11 = 2;
        r11 = 2;
        if (r10 == 0) goto L38;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L24;
        if (r10 != 3) goto L23;
        C0457a r4 = (C0457a) ZeusTransformUtils.preCheckCast(r7.j, C0457a.class, "com.obric.aiagent.plugin");
        AtomicReference r12 = (AtomicReference) ZeusTransformUtils.preCheckCast(r7.i, AtomicReference.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.virt.impl.a.f r13 = (com.obric.aiagent.skill.virt.impl.a.f) ZeusTransformUtils.preCheckCast(r7.h, com.obric.aiagent.skill.virt.impl.a.f.class, "com.obric.aiagent.plugin");
        AtomicReference r14 = (AtomicReference) ZeusTransformUtils.preCheckCast(r7.g, AtomicReference.class, "com.obric.aiagent.plugin");
        AtomicReference r15 = (AtomicReference) ZeusTransformUtils.preCheckCast(r7.f, AtomicReference.class, "com.obric.aiagent.plugin");
        AtomicReference r16 = (AtomicReference) ZeusTransformUtils.preCheckCast(r7.f21684e, AtomicReference.class, "com.obric.aiagent.plugin");
        AtomicBoolean r17 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r7.f21683d, AtomicBoolean.class, "com.obric.aiagent.plugin");
        r11 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r7.f21682c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        final ?? r18 = (String) ZeusTransformUtils.preCheckCast(r7.f21681b, String.class, "com.obric.aiagent.plugin");
        ?? r19 = (a) ZeusTransformUtils.preCheckCast(r7.f21680a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L20
        AtomicReference r22 = r14;
        AtomicReference r21 = r15;
        AtomicBoolean r20 = r17;
        r19 = r19;
        r11 = r11;
        r18 = r18;
    L82:
        Ctrd.m r0 = (Ctrd.m) ZeusTransformUtils.preCheckCast(r8, Ctrd.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L20
        Ctrd.h r23 = r0.a();     // Catch: Throwable -> L16
        String r24 = "";
        if (r23 != null) goto L93;
        ((a) ZeusTransformUtils.preCheckCast(r19, a.class, "com.obric.aiagent.plugin")).a(r4, r13, r18);     // Catch: Throwable -> L16
        d.n.a r25 = d.n.f38560a;     // Catch: Throwable -> L16
        StringBuilder r26 = new StringBuilder().append("Ctrd startShell returned no handle: ");     // Catch: Throwable -> L16
        String r27 = (String) ZeusTransformUtils.preCheckCast(r12.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r27 == null) goto L91;
        r24 = r27;
    L91:
        Object r28 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(r26.append(r24).toString()), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L16
        ?? r29 = r19;
        ?? r110 = r11;
        ?? r111 = r18;
    L117:
        ?? r30 = r110;
        ?? r31 = r29;
        ?? r112 = r111;
    L138:
        r30.b(null);     // Catch: Throwable -> L154 CancellationException -> L156
        if (r31.j.get(r112) != null) goto L142;
        r31.i.compareAndSet((String) r112, null);
    L142:
        return r28;
    L93:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r23.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L99;
        r19.a(r4, r13, r18);     // Catch: Throwable -> L16
        d.n.a r40 = d.n.f38560a;     // Catch: Throwable -> L16
        StringBuilder r41 = new StringBuilder().append("Ctrd startShell returned no handle: ");     // Catch: Throwable -> L16
        String r42 = (String) ZeusTransformUtils.preCheckCast(r12.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r42 == null) goto L98;
        r24 = r42;
    L98:
        r28 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(r41.append(r24).toString()), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L16
        r29 = r19;
        r110 = r11;
        r111 = r18;
        goto L117
    L99:
        r16.set(r23);     // Catch: Throwable -> L16
        b r43 = new b(r18, r23, r13, r20, r21, r22, r4, null, 128, null);     // Catch: Throwable -> L16
        ((Map) ZeusTransformUtils.preCheckCast(r19.j, Map.class, "com.obric.aiagent.plugin")).put(r18, r43);     // Catch: Throwable -> L16 Exception -> L102 CancellationException -> L104
        kotlinx.coroutines.i.a(r19.h, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ak(r0, r19, r43, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L16 Exception -> L102 CancellationException -> L104
        d.n.a r44 = d.n.f38560a;     // Catch: Throwable -> L16 Exception -> L102 CancellationException -> L104
        r28 = d.n.f(r13);     // Catch: Throwable -> L16 Exception -> L102 CancellationException -> L104
        r29 = r19;
        r110 = r11;
        r111 = r18;
    L104:
        e = move-exception;
        r19.a(r23);     // Catch: Throwable -> L16
        r19.a(r4, r13, r18);     // Catch: Throwable -> L16
        throw e;     // Catch: Throwable -> L16
    L102:
        e = move-exception;
        r19.a(r23);     // Catch: Throwable -> L16
        r19.a(r4, r13, r18);     // Catch: Throwable -> L16
        d.n.a r45 = d.n.f38560a;     // Catch: Throwable -> L16
        r28 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L16
        r29 = r19;
        r110 = r11;
        r111 = r18;
        goto L117
    L20:
        e = e;
    L121:
        r19.a(r4, r13, r18);     // Catch: Throwable -> L16
        throw e;     // Catch: Throwable -> L16
    L18:
        e = e;
    L116:
        r19.a(r4, r13, r18);     // Catch: Throwable -> L16
        d.n.a r46 = d.n.f38560a;     // Catch: Throwable -> L16
        r28 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L16
        r29 = r19;
        r110 = r11;
        r111 = r18;
        goto L117
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        e r47 = (e) ZeusTransformUtils.preCheckCast(r7.j, e.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r48 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r7.i, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        final d.h.a.b r49 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r7.h, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r50 = (String) ZeusTransformUtils.preCheckCast(r7.g, String.class, "com.obric.aiagent.plugin");
        Map r51 = (Map) ZeusTransformUtils.preCheckCast(r7.f, Map.class, "com.obric.aiagent.plugin");
        String r113 = (String) ZeusTransformUtils.preCheckCast(r7.f21684e, String.class, "com.obric.aiagent.plugin");
        String r114 = (String) ZeusTransformUtils.preCheckCast(r7.f21683d, String.class, "com.obric.aiagent.plugin");
        String r115 = (String) ZeusTransformUtils.preCheckCast(r7.f21682c, String.class, "com.obric.aiagent.plugin");
        String r116 = (String) ZeusTransformUtils.preCheckCast(r7.f21681b, String.class, "com.obric.aiagent.plugin");
        a r117 = (a) ZeusTransformUtils.preCheckCast(r7.f21680a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L27 CancellationException -> L29
        e r118 = r47;
        Map r52 = r51;
        final String r53 = r115;
        r18 = r116;
        String r119 = r114;
        kotlinx.coroutines.f.a r54 = r48;
        ?? r120 = r117;
    L180:
        d r55 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L128 CancellationException -> L130
        String r121 = r120.a(r113);     // Catch: Throwable -> L125
        AtomicBoolean r122 = new AtomicBoolean(false);     // Catch: Throwable -> L125
        AtomicReference r123 = new AtomicReference(null);     // Catch: Throwable -> L125
        AtomicReference r56 = new AtomicReference(null);     // Catch: Throwable -> L125
        kotlinx.coroutines.f.a r310 = r54;
        AtomicReference r57 = new AtomicReference(null);     // Catch: Throwable -> L123
        aj r210 = r7;
        com.obric.aiagent.skill.virt.impl.a.f r58 = new com.obric.aiagent.skill.virt.impl.a.f(r18, r53, r119, (com.obric.aiagent.skill.virt.impl.a.g) ZeusTransformUtils.preCheckCast(new al(r120, r123, r18, r122), com.obric.aiagent.skill.virt.impl.a.g.class, "com.obric.aiagent.plugin"), new $$Lambda$a$OEMHxnwsFCmQ2mfMBNiy05CCbk(r49, r53, r18), new $$Lambda$a$5EhChNkzt22bpe2erRjQacoWQ(r49, r53, r18));     // Catch: Throwable -> L123
        AtomicReference r59 = new AtomicReference(null);     // Catch: Throwable -> L123
        if (r50 != null) goto L169;
        C0457a r60 = null;
    L186:
        d.h.a.m r61 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new am(r118, r120, r121, r119, r52, r123, r56, r58, r57, r59, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L113 CancellationException -> L118 Throwable -> L123
        r210.f21680a = r120;     // Catch: Exception -> L113 CancellationException -> L118 Throwable -> L123
        r210.f21681b = r18;     // Catch: Exception -> L113 CancellationException -> L118 Throwable -> L123
        kotlinx.coroutines.f.a r124 = r310;
        r210.f21682c = r124;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.f21683d = r122;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.f21684e = r123;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.f = r56;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.g = r57;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.h = r58;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.i = r59;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.j = r60;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r210.m = 3;     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
        r8 = dg.a(15000, r61, r210);     // Catch: Throwable -> L107 Exception -> L109 CancellationException -> L111
    L79:
        if (r8 != r9) goto L81;
        return r9;
    L81:
        r21 = r56;
        r22 = r57;
        r12 = r59;
        r4 = r60;
        r13 = r58;
        r20 = r122;
        r16 = r123;
        r19 = r120;
        r11 = r124;
        r18 = r18;
    L111:
        e = e;
        kotlinx.coroutines.f.a r125 = r124;
    L120:
        r4 = r60;
        r13 = r58;
        r19 = r120;
    L109:
        e = e;
        kotlinx.coroutines.f.a r126 = r124;
    L115:
        r4 = r60;
        r13 = r58;
        r11 = r126;
        r19 = r120;
    L107:
        th = th;
        kotlinx.coroutines.f.a r127 = r124;
    L127:
        r11 = r127;
        ?? r128 = r120;
    L152:
        r11.b(null);     // Catch: Throwable -> L154 CancellationException -> L156
        throw th;     // Catch: Throwable -> L154 CancellationException -> L156
    L118:
        e = e;
        r125 = r310;
    L113:
        e = e;
        r126 = r310;
        goto L115
    L169:
        r60 = r120.a(r55, r18, r50);     // Catch: Throwable -> L65 CancellationException -> L68
    L68:
        e = move-exception;
        throw e;     // Catch: Throwable -> L71
    L65:
        th = move-exception;
        d.n.a r62 = d.n.f38560a;     // Catch: Throwable -> L71
        r28 = d.n.f(d.o.a(th));     // Catch: Throwable -> L71
        kotlinx.coroutines.f.a r63 = r310;
        ?? r129 = r18;
        ?? r130 = r120;
    L136:
        r31 = r130;
        r30 = r63;
        r112 = r129;
    L71:
        th = th;
        r11 = r310;
        r128 = r120;
    L123:
        th = th;
        r127 = r310;
    L125:
        th = th;
        r127 = r54;
        goto L127
    L130:
        e = move-exception;
        throw e;     // Catch: Throwable -> L146
    L128:
        th = th;
        kotlinx.coroutines.f.a r131 = r54;
        ?? r132 = r18;
        ?? r133 = r120;
    L134:
        d.n.a r64 = d.n.f38560a;     // Catch: Throwable -> L146
        r28 = d.n.f(d.o.a(th));     // Catch: Throwable -> L146
        r129 = r132;
        r63 = r131;
        r130 = r133;
        goto L136
    L29:
        e = move-exception;
        throw e;     // Catch: Throwable -> L146
    L27:
        th = th;
        r131 = r48;
        r132 = r116;
        r133 = r117;
        goto L134
    L31:
        kotlinx.coroutines.f.a r65 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r7.i, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r7.h, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r66 = (String) ZeusTransformUtils.preCheckCast(r7.g, String.class, "com.obric.aiagent.plugin");
        r3 = (Map) ZeusTransformUtils.preCheckCast(r7.f, Map.class, "com.obric.aiagent.plugin");
        String r67 = (String) ZeusTransformUtils.preCheckCast(r7.f21684e, String.class, "com.obric.aiagent.plugin");
        r119 = (String) ZeusTransformUtils.preCheckCast(r7.f21683d, String.class, "com.obric.aiagent.plugin");
        String r134 = (String) ZeusTransformUtils.preCheckCast(r7.f21682c, String.class, "com.obric.aiagent.plugin");
        String r135 = (String) ZeusTransformUtils.preCheckCast(r7.f21681b, String.class, "com.obric.aiagent.plugin");
        a r136 = (a) ZeusTransformUtils.preCheckCast(r7.f21680a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L34 CancellationException -> L36
        kotlinx.coroutines.f.a r68 = r65;
        String r69 = r67;
        r53 = r134;
        ?? r137 = r135;
        ?? r138 = r136;
    L172:
        e r139 = r138.m;     // Catch: Throwable -> L149
        if (r139 != null) goto L51;
        d.n.a r70 = d.n.f38560a;     // Catch: Throwable -> L149
        r28 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Ctrd runtime is not open"), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L149
    L49:
        r129 = r137;
        r63 = r68;
        r130 = r138;
        goto L136
    L51:
        if (r138.n == false) goto L178;
        d.n.a r71 = d.n.f38560a;     // Catch: Throwable -> L149
        r28 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Ctrd runtime is closing"), Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L149
        goto L49
    L178:
        r7.f21680a = r138;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.f21681b = r137;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.f21682c = r53;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.f21683d = r119;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.f21684e = r69;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.f = r3;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.g = r66;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.h = r5;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.i = r68;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.j = r139;     // Catch: Throwable -> L132 CancellationException -> L143
        r7.m = 2;     // Catch: Throwable -> L132 CancellationException -> L143
        Object r140 = r138.a(r139, r7);     // Catch: Throwable -> L132 CancellationException -> L143
        if (r140 != r9) goto L57;
        return r9;
    L57:
        r118 = r139;
        r18 = r137;
        r113 = r69;
        r52 = r3;
        r49 = r5;
        r50 = r66;
        r54 = r68;
        r8 = r140;
        r120 = r138;
        goto L180
    L143:
        e = move-exception;
        throw e;     // Catch: Throwable -> L146
    L132:
        th = th;
        r131 = r68;
        r132 = r137;
        r133 = r138;
    L149:
        th = th;
        r11 = r68;
        r128 = r138;
        goto L152
    L36:
        e = move-exception;
        throw e;     // Catch: Throwable -> L158
    L34:
        th = th;
        r2 = r135;
        r1 = r136;
    L163:
        if (r1.j.get(r2) != null) goto L165;
        r1.i.compareAndSet((String) r2, null);
    L165:
        throw th;
    L38:
        d.o.a(r8);
        if (r1.i.compareAndSet(null, (String) r2) == true) goto L166;
        d.n.a r72 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Ctrd already has an active shell execution"), Throwable.class, "com.obric.aiagent.plugin")));
    L166:
        kotlinx.coroutines.f.a r73 = r1.f;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.f21680a = r1;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.f21681b = r2;     // Catch: Throwable -> L158 CancellationException -> L160
        r53 = r33;
        r7.f21682c = r53;     // Catch: Throwable -> L158 CancellationException -> L160
        r119 = r34;
        r7.f21683d = r119;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.f21684e = r35;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.f = r3;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.g = r37;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.h = r5;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.i = r73;     // Catch: Throwable -> L158 CancellationException -> L160
        r7.m = 1;     // Catch: Throwable -> L158 CancellationException -> L160
        if (r73.a(null, r7) != r9) goto L45;
        return r9;
    L45:
        r138 = r1;
        r69 = r35;
        r137 = r2;
        r66 = r37;
        r68 = r73;
    L160:
        e = move-exception;
        throw e;     // Catch: Throwable -> L158
    L158:
        th = th;
    L146:
        th = th;
    L16:
        th = th;
    L156:
        e = move-exception;
        throw e;     // Catch: Throwable -> L158
    L154:
        th = th;
        r1 = r7;
        r2 = 1;
    L7:
        r7 = new aj(r1, r6);
        goto L8
    }

    private static final d.x a(d.h.a.b r2, String r3, String r4, String r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, MonitorConstants.CHUNK);
        r6.invoke(new com.obric.aiagent.skill.virt.api.r(r3, r4, com.obric.aiagent.skill.virt.api.s.f21602a, r5));
        return d.x.f38692a;
    }

    private static final d.x b(d.h.a.b r2, String r3, String r4, String r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, MonitorConstants.CHUNK);
        r6.invoke(new com.obric.aiagent.skill.virt.api.r(r3, r4, com.obric.aiagent.skill.virt.api.s.f21603b, r5));
        return d.x.f38692a;
    }

    private final Object a(AtomicReference<Ctrd.h> r9, String r10, AtomicBoolean r11) {
        Ctrd.h r12 = (Ctrd.h) ZeusTransformUtils.preCheckCast(r9.get(), Ctrd.h.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L7;
        d.n.a r8 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Ctrd shell handle is unavailable"), Throwable.class, "com.obric.aiagent.plugin")));
    L7:
        if (this.j.get(r10) != null) goto L10;
        d.n.a r13 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Ctrd execution is not active"), Throwable.class, "com.obric.aiagent.plugin")));
    L10:
        r11.set(true);
        kotlinx.coroutines.i.a(this.h, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ah(r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        d.n.a r14 = d.n.f38560a;
        return d.n.f(d.x.f38692a);
    }

    static /* synthetic */ void a(a r0, b r1, Ctrd.i r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(b r6, Ctrd.i r7, boolean r8) {
        boolean r1 = false;
        if (r6.h().compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.j.remove(r6.a(), r6);
        this.i.compareAndSet(r6.a(), null);
        a(r6);
        a(r6.g(), r6.c(), r6.a());
        if (r8 == false) goto L8;
    L9:
        r1 = true;
    L10:
        if (r7 == null) goto L12;
        int r5 = r7.a();
    L13:
        if (r7 != null) goto L15;
    L18:
        r6.c().a(new com.obric.aiagent.skill.virt.impl.a.h(r5, com.obric.aiagent.skill.virt.impl.a.a.b.a(r5), r1));
        return;
    L15:
        if (r7.f() == false) goto L18;
        r6.c().a(new com.obric.aiagent.skill.virt.impl.a.h(r5, com.obric.aiagent.skill.virt.impl.a.a.b.a(r5), r1));
        return;
    L12:
        r5 = -1;
        goto L13
    L8:
        if (r6.d().get() == false) goto L10;
        goto L9
    }

    private final void a(b r5, Throwable r6) {
        if (r5.h().compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.j.remove(r5.a(), r5);
        this.i.compareAndSet(r5.a(), null);
        a(r5);
        a(r5.g(), r5.c(), r5.a());
        r5.c().a(new com.obric.aiagent.skill.virt.impl.a.h(-1, null, r5.d().get()));
        if (IAppContext.Companion.isDebug() == false) goto L8;
        ILogDepend.Companion.e("Virt/CtrdShell", "Ctrd shell execution failed executionId=" + r5.a(), r6);
        return;
    L8:
        ILogDepend.Companion.e("Virt/CtrdShell", "Ctrd shell execution failed");
    }

    private final void a(b r6) {
        if (r6.e().get() == null) goto L11;
        Character r5 = (Character) ZeusTransformUtils.preCheckCast(r6.e().get(), Character.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L8;
    L9:
        r6.c().b("\n");
        r6.e().set('\n');
        goto L11
    L8:
        if (r5.charValue() != '\n') goto L9;
    L11:
        if (r6.f().get() == null) goto L19;
        Character r7 = (Character) ZeusTransformUtils.preCheckCast(r6.f().get(), Character.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L16;
    L17:
        r6.c().c("\n");
        r6.f().set('\n');
        return;
    L16:
        if (r7.charValue() != '\n') goto L17;
        return;
    }

    private final void a(Ctrd.h r7) {
        kotlinx.coroutines.i.a(this.h, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object a(e r13, d.c.d<? super d> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, s.class) == false) goto L7;
        s r1 = (s) ZeusTransformUtils.preCheckCast(r15, s.class, "com.obric.aiagent.plugin");
        if ((r1.f21779e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f21779e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.f21777c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f21779e;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        e r12 = (e) ZeusTransformUtils.preCheckCast(r1.f21775a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L39:
        d r17 = (d) ZeusTransformUtils.preCheckCast(r12.d().get(), d.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L43;
        return r17;
    L43:
        throw new IllegalStateException("Ctrd Gateway attachment changed during recovery".toString());
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r12 = (e) ZeusTransformUtils.preCheckCast(r1.f21776b, e.class, "com.obric.aiagent.plugin");
        a r18 = (a) ZeusTransformUtils.preCheckCast(r1.f21775a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L32:
        d r19 = (d) ZeusTransformUtils.preCheckCast(r16, d.class, "com.obric.aiagent.plugin");
        if (r12.d().compareAndSet(null, r19) == false) goto L36;
        r18.a(r12, r19);
        return r19;
    L36:
        r1.f21775a = r12;
        r1.f21776b = null;
        r1.f21779e = 3;
        if (r18.a(r19, "superseded", r1) != r3) goto L39;
        return r3;
    L17:
        r13 = (e) ZeusTransformUtils.preCheckCast(r1.f21776b, e.class, "com.obric.aiagent.plugin");
        a this = (a) ZeusTransformUtils.preCheckCast(r1.f21775a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L24:
        Ctrd.b r110 = (Ctrd.b) ZeusTransformUtils.preCheckCast(r16, Ctrd.b.class, "com.obric.aiagent.plugin");
        if (r110.e() == false) goto L46;
        ParcelFileDescriptor r111 = r110.c();
        if (r111 == null) goto L45;
        Ctrd.d r0 = r13.a();
        r1.f21775a = this;
        r1.f21776b = r13;
        r1.f21779e = 2;
        r16 = this.b(r0, r111, "enableGateway", r1);
        if (r16 != r3) goto L31;
        return r3;
    L31:
        e r11 = r13;
        r18 = this;
        r12 = r11;
        goto L32
    L45:
        throw new IllegalStateException("Ctrd Gateway recovery returned no proxy fd".toString());
    L46:
        com.obric.aiagent.skill.virt.impl.a.a.b.a(r110.c());
        throw new IllegalStateException(("Ctrd Gateway recovery failed: code=" + r110.a() + " gatewayState=" + r110.b() + " error=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r110.d())).toString());
    L18:
        d.o.a(r16);
        d r112 = (d) ZeusTransformUtils.preCheckCast(r13.d().get(), d.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L21;
        return r112;
    L21:
        d.h.a.m r113 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(r13, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r1.f21775a = this;
        r1.f21776b = r13;
        r1.f21779e = 1;
        r16 = dg.a(15000, r113, r1);
        if (r16 != r3) goto L24;
        return r3;
    L7:
        r1 = new s(this, r15);
        goto L8
    }

    private final Object a(Ctrd.d r21, ParcelFileDescriptor r22, String r23, d.c.d<? super d> r24) {
        a r1 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, n.class) == false) goto L7;
        n r3 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f21761d;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f;
        boolean r7 = true;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L13;
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r3.f21758a, Throwable.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L48:
        throw new IllegalStateException("Ctrd proxy session did not become ready", r6);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ProxySession r8 = (ProxySession) ZeusTransformUtils.preCheckCast(r3.f21760c, ProxySession.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.f21759b, String.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r3.f21758a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L18
        ProxySession r13 = r8;
        String r11 = r9;
        r1 = r10;
    L75:
        ProxyReady r12 = (ProxyReady) ZeusTransformUtils.preCheckCast(r2, ProxyReady.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        au r14 = kotlinx.coroutines.i.b(r1.h, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        if (IAppContext.Companion.isDebug() == false) goto L37;
        ILogDepend.Companion.i("Virt/CtrdProxy", "Ctrd proxy attached source=" + r11 + " proxySessionId=" + r13.getSessionId());
    L39:
        return new d(r13, r14, null, 4, null);
    L37:
        ILogDepend.Companion.i("Virt/CtrdProxy", "Ctrd proxy attached source=" + r11);
    L40:
        th = th;
        ProxySession r15 = r13;
    L43:
        r3.f21758a = th;
        r3.f21759b = null;
        r3.f21760c = null;
        r3.f = 2;
        if (r1.a(r15, r3) != r4) goto L46;
        return r4;
    L46:
        r6 = th;
    L18:
        th = th;
        r15 = r8;
        r1 = r10;
        goto L43
    L20:
        d.o.a(r2);
        if (f().isAvailable() == false) goto L71;
        Object r16 = f().mo37startSessiongIAlus(r22, new ProxySessionOptions("ctrd-" + r21.a()));     // Catch: Throwable -> L51
        Throwable r17 = d.n.c(r16);     // Catch: Throwable -> L51
        if (r17 != null) goto L50;
        r15 = (ProxySession) ZeusTransformUtils.preCheckCast(r16, ProxySession.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r15, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        r3.f21758a = r1;     // Catch: Throwable -> L42
        r11 = r23;
        r3.f21759b = r11;     // Catch: Throwable -> L42
        r3.f21760c = r15;     // Catch: Throwable -> L42
        r3.f = 1;     // Catch: Throwable -> L42
        r2 = dg.a(10000, r18, r3);     // Catch: Throwable -> L42
        if (r2 != r4) goto L32;
        return r4;
    L32:
        r13 = r15;
    L42:
        th = th;
        goto L43
    L50:
        throw new IllegalStateException("Ctrd proxy session rejected", r17);     // Catch: Throwable -> L51
    L51:
        th = th;
    L63:
        if (r7 == true) goto L65;
        com.obric.aiagent.skill.virt.impl.a.a.b.a(r22);
    L65:
        throw th;
    L53:
        th = th;
        goto L63
    L71:
    L58:
        th = th;
    L62:
        r7 = false;
        goto L63
    L57:
        throw new IllegalStateException("SafetyGuard proxy runtime is not available".toString());     // Catch: Throwable -> L58
    L60:
        th = th;
    L7:
        r3 = new n(r1, r0);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x011c -> B:40:0x0123). Please report as a decompilation issue!!! */
    private final Object b(Ctrd.d r18, ParcelFileDescriptor r19, String r20, d.c.d<? super d> r21) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, q.class) == false) goto L7;
        q r3 = (q) ZeusTransformUtils.preCheckCast(r1, q.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
        a r4 = this;
    L8:
        Object r2 = r3.f;
        Object r5 = d.c.a.b.a();
        int r6 = r3.h;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r7 = r3.f21772e;
        Throwable r8 = (Throwable) ZeusTransformUtils.preCheckCast(r3.f21771d, Throwable.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.f21770c, String.class, "com.obric.aiagent.plugin");
        Ctrd.d r11 = (Ctrd.d) ZeusTransformUtils.preCheckCast(r3.f21769b, Ctrd.d.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.f21768a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        r4 = r0;
        int r9 = r7;
        q r12 = r3;
        String r13 = r10;
        Object r14 = r5;
    L40:
        Ctrd.b r15 = (Ctrd.b) ZeusTransformUtils.preCheckCast(r2, Ctrd.b.class, "com.obric.aiagent.plugin");
        if (r15.e() == false) goto L47;
        ParcelFileDescriptor r16 = r15.c();
        if (r16 == null) goto L46;
        int r17 = r9;
        ParcelFileDescriptor r22 = r16;
        Ctrd.d r23 = r11;
    L56:
        r12.f21768a = r4;     // Catch: CancellationException -> L20 Throwable -> L27
        r12.f21769b = r23;     // Catch: CancellationException -> L20 Throwable -> L27
        r12.f21770c = r13;     // Catch: CancellationException -> L20 Throwable -> L27
        r12.f21771d = null;     // Catch: CancellationException -> L20 Throwable -> L27
        r12.f21772e = r17;     // Catch: CancellationException -> L20 Throwable -> L27
        r12.h = 1;     // Catch: CancellationException -> L20 Throwable -> L27
        r2 = r4.a(r23, r22, r13, r12);     // Catch: CancellationException -> L20 Throwable -> L27
        if (r2 != r14) goto L51;
        return r14;
    L51:
        return r2;
    L27:
        th = move-exception;
        a r110 = r4;
        int r24 = r17;
        r8 = th;
        String r25 = r13;
        r3 = r12;
        r5 = r14;
        Ctrd.d r111 = r23;
    L29:
        if (r24 == 0) goto L31;
        throw r8;
    L31:
        if (r110.a(r8) == false) goto L58;
        int r26 = r24 + 1;
        if (IAppContext.Companion.isDebug() == false) goto L35;
        ILogDepend.Companion.w("Virt/CtrdProxy", "Retrying Ctrd Gateway after cold proxy handshake");
    L36:
        d.h.a.m r27 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r111, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r3.f21768a = r110;
        r3.f21769b = r111;
        r3.f21770c = r25;
        r3.f21771d = r8;
        r3.f21772e = r26;
        r3.h = 2;
        r2 = dg.a(15000, r27, r3);
        if (r2 != r5) goto L39;
        return r5;
    L39:
        q r112 = r3;
        r13 = r25;
        r9 = r26;
        r4 = r110;
        r11 = r111;
        r14 = r5;
        r12 = r112;
        goto L40
    L35:
        ILogDepend.Companion.w("Virt/CtrdProxy", "Retrying Ctrd Gateway attachment");
        goto L36
    L58:
        throw r8;
    L46:
        throw new IllegalStateException("Ctrd Gateway cold retry returned no proxy fd", r8);
    L47:
        com.obric.aiagent.skill.virt.impl.a.a.b.a(r15.c());
        throw new IllegalStateException("Ctrd Gateway cold retry failed: code=" + r15.a() + " gatewayState=" + r15.b() + " error=" + com.obric.aiagent.skill.virt.impl.a.a.b.b(r15.d()), r8);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r24 = r3.f21772e;
        String r28 = (String) ZeusTransformUtils.preCheckCast(r3.f21770c, String.class, "com.obric.aiagent.plugin");
        r111 = (Ctrd.d) ZeusTransformUtils.preCheckCast(r3.f21769b, Ctrd.d.class, "com.obric.aiagent.plugin");
        r110 = (a) ZeusTransformUtils.preCheckCast(r3.f21768a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L18 CancellationException -> L20
    L18:
        th = move-exception;
        r8 = th;
        r25 = r28;
        goto L29
    L22:
        d.o.a(r2);
        r23 = r18;
        r17 = 0;
        r14 = r5;
        r22 = r19;
        r12 = r3;
        r13 = r20;
    L20:
        e = move-exception;
        throw e;
    L7:
        r4 = this;
        r3 = new q(r4, r1);
        goto L8
    }

    private final void a(e r7, d r8) {
        kotlinx.coroutines.i.a(this.h, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new an(r8, r7, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object a(d r5, String r6, d.c.d<? super d.x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r5, this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return d.x.f38692a;
    }

    private final Object a(ProxySession r4, d.c.d<? super d.x> r5) {
        ProxySession r3 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r4, ProxySession.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
        if (r7 != d.c.a.b.a()) goto L6;
        return r7;
    L6:
        return d.x.f38692a;
    }

    private final C0457a a(d r7, String r8, String r9) {
        Object r10 = r7.a().mo31activateActionIoAF18A(r9);     // Catch: Throwable -> L13
        Throwable r0 = d.n.c(r10);
        if (r0 != null) goto L12;
        ActionContextToken r2 = (ActionContextToken) ZeusTransformUtils.preCheckCast(r10, ActionContextToken.class, "com.obric.aiagent.plugin");
        if (IAppContext.Companion.isDebug() == false) goto L10;
        ILogDepend.Companion.i("Virt/CtrdProxy", "Ctrd proxy action activated executionId=" + r8);
    L10:
        return new C0457a(r7.a(), r2, null, 4, null);
    L12:
        throw new IllegalStateException("Ctrd proxy action activation failed", r0);
    L13:
        th = move-exception;
        throw new IllegalStateException("Ctrd proxy action activation failed", th);
    }

    private final void a(C0457a r5, com.obric.aiagent.skill.virt.impl.a.f r6, String r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.c().compareAndSet(false, true) == false) goto L20;
        Object r8 = r5.a().mo33finishActionIoAF18A(r5.b());     // Catch: Throwable -> L13
        Throwable r1 = d.n.c(r8);
        if (r1 != null) goto L11;
        r6.a(com.obric.aiagent.skill.virt.impl.a.e.f22042a.a((ActionEgressResult) ZeusTransformUtils.preCheckCast(r8, ActionEgressResult.class, "com.obric.aiagent.plugin")));
        return;
    L11:
        a("Ctrd proxy action finish failed executionId=" + r7, r1);
        return;
    L13:
        th = move-exception;
        a("Ctrd proxy action finish failed executionId=" + r7, th);
        return;
    }

    private final void a(String r4, Throwable r5) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e("Virt/CtrdProxy", r4, r5);
        return;
    L5:
        ILogDepend.Companion.e("Virt/CtrdProxy", d.o.o.a(r4, " executionId=", null, 2, null));
    }

    private final boolean a(Throwable r3) {
        Iterator r2 = d.n.m.a(r3, $$Lambda$a$6x1Ka6bMA9ehTfU91WTXLFQJXR8.INSTANCE).a();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r2.next(), Throwable.class, "com.obric.aiagent.plugin"), ProxyReadyException.class) == false) goto L4;
        return true;
    L8:
        return false;
    }

    private static final Throwable b(Throwable r1) {
        d.h.b.o.e(r1, "it");
        return r1.getCause();
    }

    private final Object a(Ctrd.d r4, d.c.d<? super d.x> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r6 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
        if (r6 != d.c.a.b.a()) goto L6;
        return r6;
    L6:
        return d.x.f38692a;
    }

    private final String a(String r3, String r4) {
        String r5 = com.obric.aiagent.skill.virt.impl.a.a.b.c(r3);
        return "mkdir -p " + r5 + " && cd -- " + r5 + " || exit $?; export HOME=" + com.obric.aiagent.skill.virt.impl.a.a.b.c(e()) + "; " + r4;
    }

    private final List<String> a(Map<String, String> r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(ao.a(ao.a(d.s.a("HOME", e())), (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")).entrySet(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");
        if (p.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        r7.add(r2 + '=' + r1);
        goto L4
    L9:
        throw new IllegalArgumentException(("Invalid environment variable name: " + r2).toString());
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    }

    private final e g() {
        e r1 = this.m;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Ctrd runtime is not open".toString());
    }

    static {
        f21638a = new c(null);
        p = new d.o.k("[A-Za-z_][A-Za-z0-9_]*");
    }
}
