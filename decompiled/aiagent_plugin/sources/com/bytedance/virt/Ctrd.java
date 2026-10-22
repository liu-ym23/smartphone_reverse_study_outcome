package com.bytedance.virt;

import android.os.ParcelFileDescriptor;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.virt.ObricCtrdManager;
import com.obric.virt.common.CtrdOperationResult;
import com.obric.virt.runtime.CtrdGatewayResult;
import com.obric.virt.runtime.CtrdRuntimeHandle;
import com.obric.virt.runtime.CtrdRuntimeOpenResult;
import com.obric.virt.runtime.CtrdRuntimeStatus;
import com.obric.virt.shell.CtrdShellHandle;
import com.obric.virt.shell.CtrdShellOutputListener;
import com.obric.virt.shell.CtrdShellResult;
import com.obric.virt.shell.CtrdShellStartResult;
import com.obric.virt.workspace.CtrdSharePathsResult;
import com.obric.virt.workspace.CtrdStorageUsageResult;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.co;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: Ctrd.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Ctrd {
    private static final int DEFAULT_GHOTFIX_MODE = 493;
    private static final long GHOTFIX_PIPE_WRITER_TIMEOUT_MS = 30000;
    public static final Ctrd INSTANCE = null;
    private static final kotlinx.coroutines.am ioScope = null;

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f11540c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11538a, r6.f11538a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11539b, r6.f11539b) == true) goto L15;
            return false;
        L15:
            if (this.f11540c == r6.f11540c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11538a.hashCode() * 31) + this.f11539b.hashCode()) * 31) + Boolean.hashCode(this.f11540c);
        }

        public String toString() {
            return "CtrdLogResult(content=" + this.f11538a + ", error=" + this.f11539b + ", successful=" + this.f11540c + ')';
        }

        public a(String r2, String r3, boolean r4) {
            d.h.b.o.e(r2, "content");
            d.h.b.o.e(r3, WsConstants.KEY_CONNECTION_ERROR);
            this.f11538a = r2;
            this.f11539b = r3;
            this.f11540c = r4;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$getRuntimeStatus$2")
    static final class aa extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11542b;

        aa(d r3, d.c.d<? super aa> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11542b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super f> r4) {
            return ((aa) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aa(this.f11542b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super f> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f11541a != 0) goto L15;
            d.o.a(r5);
            CtrdRuntimeHandle r6 = this.f11542b.b();     // Catch: Exception -> L11
            if (r6 == null) goto L8;
            Ctrd r0 = Ctrd.INSTANCE;     // Catch: Exception -> L11
            CtrdRuntimeStatus r7 = Ctrd.access$manager(Ctrd.INSTANCE).getRuntimeManager().getStatus(r6);     // Catch: Exception -> L11
            d.h.b.o.c(r7, "getStatus(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkRuntimeStatusToClient(r0, r7);
        L8:
            return Ctrd.access$missingRuntimeStatus(Ctrd.INSTANCE, this.f11542b, "ctrd getRuntimeStatus failed: missing framework runtime handle");
        L11:
            e = move-exception;
            return Ctrd.access$missingRuntimeStatus(Ctrd.INSTANCE, this.f11542b, Ctrd.access$frameworkError(Ctrd.INSTANCE, "getRuntimeStatus", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$getSharePaths$2")
    static final class ab extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super g>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11544b;

        ab(d r3, d.c.d<? super ab> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11544b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super g> r4) {
            return ((ab) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ab.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ab(this.f11544b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super g> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f11543a != 0) goto L15;
            d.o.a(r6);
            CtrdRuntimeHandle r5 = this.f11544b.b();     // Catch: Exception -> L11
            if (r5 == null) goto L8;
            CtrdSharePathsResult r7 = Ctrd.access$manager(Ctrd.INSTANCE).getWorkspaceManager().getSharePaths(r5);     // Catch: Exception -> L11
            d.h.b.o.c(r7, "getSharePaths(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkSharePathsResultToClient(Ctrd.INSTANCE, r7);
        L8:
            return new g("", "", "ctrd getSharePaths failed: missing framework runtime handle", false);
        L11:
            e = move-exception;
            return new g("", "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "getSharePaths", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), false);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$getWorkspaceStorageUsage$2")
    static final class ac extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super l>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11546b;

        ac(d r3, d.c.d<? super ac> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11546b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super l> r4) {
            return ((ac) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f11546b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super l> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f11545a != 0) goto L15;
            d.o.a(r6);
            CtrdRuntimeHandle r5 = this.f11546b.b();     // Catch: Exception -> L11
            if (r5 == null) goto L8;
            CtrdStorageUsageResult r7 = Ctrd.access$manager(Ctrd.INSTANCE).getWorkspaceManager().getStorageUsage(r5);     // Catch: Exception -> L11
            d.h.b.o.c(r7, "getStorageUsage(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkStorageUsageResultToClient(Ctrd.INSTANCE, r7);
        L8:
            return new l(d.a.p.b(), "ctrd getWorkspaceStorageUsage failed: missing framework runtime handle", false);
        L11:
            e = move-exception;
            return new l(d.a.p.b(), Ctrd.access$frameworkError(Ctrd.INSTANCE, "getWorkspaceStorageUsage", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), false);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {616}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$installGHotfix$3")
    static final class ad extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f11547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f11548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f11549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f11550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f11551e;
        final /* synthetic */ Integer f;
        final /* synthetic */ String g;

        /* JADX INFO: renamed from: com.bytedance.virt.Ctrd$ad$1, reason: invalid class name */
        /* JADX INFO: compiled from: Ctrd.kt */
        @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$installGHotfix$3$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f11552a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ File f11553b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.w<Throwable> f11554c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ParcelFileDescriptor f11555d;

            AnonymousClass1(File r3, kotlinx.coroutines.w<Throwable> r4, ParcelFileDescriptor r5, d.c.d<? super AnonymousClass1> r6) {
                kotlinx.coroutines.w<Throwable> r7 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f11553b = r3;
                this.f11554c = r7;
                this.f11555d = r5;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f11553b, this.f11554c, this.f11555d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                d.c.a.b.a();
                if (this.f11552a != 0) goto L26;
                d.o.a(r7);
                Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(this.f11553b), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
                ParcelFileDescriptor r1 = this.f11555d;     // Catch: Throwable -> L21
                FileInputStream r2 = (FileInputStream) ZeusTransformUtils.preCheckCast(r8, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
                Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new ParcelFileDescriptor.AutoCloseOutputStream(r1), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
                ParcelFileDescriptor.AutoCloseOutputStream r4 = (ParcelFileDescriptor.AutoCloseOutputStream) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.AutoCloseOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
                d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast(r2, InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r4, OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L11
                d.f.c.a(r3, null);     // Catch: Throwable -> L16
                d.f.c.a(r8, null);     // Catch: Throwable -> L21
                this.f11554c.a(null);     // Catch: Throwable -> L21
            L24:
                return d.x.f38692a;
            L11:
                th = move-exception;
                throw th;     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                d.f.c.a(r3, th);     // Catch: Throwable -> L16
                throw th;     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                throw th;     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                d.f.c.a(r8, th);     // Catch: Throwable -> L21
                throw th;     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                this.f11554c.a(th);
                goto L24
            L26:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: Ctrd.kt */
        @d.c.b.a.f(b = "Ctrd.kt", c = {617}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$installGHotfix$3$pipeWriterOutcome$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.m<? extends Boolean, ? extends Throwable>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f11556a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f11557b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.w<Throwable> f11558c;

            a(kotlinx.coroutines.w<Throwable> r3, d.c.d<? super a> r4) {
                kotlinx.coroutines.w<Throwable> r5 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f11558c = r5;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.m<Boolean, ? extends Throwable>> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f11558c, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.m<? extends Boolean, ? extends Throwable>> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f11557b;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                Boolean r6 = (Boolean) ZeusTransformUtils.preCheckCast(this.f11556a, Boolean.class, "com.obric.aiagent.plugin");
                d.o.a(r7);
            L13:
                return new d.m(r6, r7);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r7);
                Boolean r8 = d.c.b.a.b.a(true);
                kotlinx.coroutines.w<Throwable> r2 = this.f11558c;
                d.c.d<? super Throwable> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f11556a = r8;
                this.f11557b = 1;
                Object r9 = r2.a(r3);
                if (r9 != r0) goto L11;
                return r0;
            L11:
                r7 = r9;
                r6 = r8;
                goto L13
            }
        }

        ad(File r3, Integer r4, String r5, d.c.d<? super ad> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11551e = r3;
            this.f = r4;
            this.g = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((ad) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ad.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ad(this.f11551e, this.f, this.g, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f11550d;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            c r3 = (c) ZeusTransformUtils.preCheckCast(this.f11549c, c.class, "com.obric.aiagent.plugin");
            ParcelFileDescriptor r4 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(this.f11548b, ParcelFileDescriptor.class, "com.obric.aiagent.plugin");
            String r0 = (String) ZeusTransformUtils.preCheckCast(this.f11547a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r18);
            ParcelFileDescriptor r6 = r4;
            String r5 = r0;
            Object r7 = r18;
        L36:
            d.m r8 = (d.m) ZeusTransformUtils.preCheckCast(r7, d.m.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L40;
            Ctrd r9 = Ctrd.INSTANCE;
            d.h.b.o.a(r6);
            Ctrd.access$closeQuietly(r9, r6);
            return new c(-1, r3.b(), Ctrd.access$appendMessage(Ctrd.INSTANCE, r3.c(), "ghotfix source write source pipe timed out: path=" + r5));
        L40:
            Throwable r10 = (Throwable) ZeusTransformUtils.preCheckCast(r8.b(), Throwable.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L44;
            String r11 = r3.b();
            Ctrd r12 = Ctrd.INSTANCE;
            String r13 = r3.c();
            Ctrd r14 = Ctrd.INSTANCE;
            d.h.b.o.a(r5);
            return new c(-1, r11, Ctrd.access$appendMessage(r12, r13, Ctrd.access$localGHotfixSourceError(r14, "write source pipe", r5, r10)));
        L44:
            return r3;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r18);
            r5 = this.f11551e.getAbsolutePath();
            if (this.f11551e.exists() == true) goto L13;
            return new c(-1, "", "ghotfix source file does not exist before calling ObricCtrdManager: " + r5);
        L13:
            if (this.f11551e.isFile() == true) goto L17;
            return new c(-1, "", "ghotfix source is not a regular file before calling ObricCtrdManager: " + r5);
        L17:
            if (this.f11551e.canRead() == false) goto L19;
            ParcelFileDescriptor[] r15 = ParcelFileDescriptor.createPipe();     // Catch: Exception -> L55
            ParcelFileDescriptor r16 = r15[0];
            r6 = r15[1];
            kotlinx.coroutines.w r17 = kotlinx.coroutines.y.a(null, 1, null);
            kotlinx.coroutines.i.a(Ctrd.access$getIoScope$p(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f11551e, r17, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            Integer r19 = this.f;
            if (r19 == null) goto L24;
            int r110 = r19.intValue();
        L62:
            Closeable r111 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L52
            String r112 = this.g;     // Catch: Exception -> L52
            ParcelFileDescriptor r113 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r111, ParcelFileDescriptor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
            CtrdOperationResult r20 = Ctrd.access$manager(Ctrd.INSTANCE).getWorkspaceManager().installGHotfix(r16, r112, r110);     // Catch: Throwable -> L45
            d.f.c.a(r111, null);     // Catch: Exception -> L52
            d.h.b.o.a(r20);
            c r21 = Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r20);
            if (r21.d() == true) goto L32;
            Ctrd r22 = Ctrd.INSTANCE;
            d.h.b.o.a(r6);
            Ctrd.access$closeQuietly(r22, r6);
            return r21;
        L32:
            d.h.a.m r23 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r17, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r24 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11547a = r5;
            this.f11548b = r6;
            this.f11549c = r21;
            this.f11550d = 1;
            r7 = dg.b(30000, r23, r24);
            if (r7 != r1) goto L35;
            return r1;
        L35:
            r3 = r21;
            goto L36
        L45:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            d.f.c.a(r111, th);     // Catch: Exception -> L52
            throw th;     // Catch: Exception -> L52
        L52:
            e = move-exception;
            Ctrd r25 = Ctrd.INSTANCE;
            d.h.b.o.a(r6);
            Ctrd.access$closeQuietly(r25, r6);
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "installGHotfix", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L24:
            r110 = Ctrd.DEFAULT_GHOTFIX_MODE;
        L55:
            e = move-exception;
            Ctrd r26 = Ctrd.INSTANCE;
            d.h.b.o.a(r5);
            return new c(-1, "", Ctrd.access$localGHotfixSourceError(r26, "create source pipe", r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L19:
            return new c(-1, "", "ghotfix source is not readable by app before calling ObricCtrdManager: " + r5);
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$killShell$2")
    static final class ae extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f11560b;

        ae(h r3, d.c.d<? super ae> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11560b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return ((ae) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ae.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ae(this.f11560b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f11559a != 0) goto L15;
            d.o.a(r11);
            CtrdShellHandle r12 = Ctrd.access$frameworkShellHandle(Ctrd.INSTANCE, this.f11560b);     // Catch: Exception -> L11
            if (r12 == null) goto L8;
            CtrdShellResult r13 = Ctrd.access$manager(Ctrd.INSTANCE).getShellManager().killShell(r12);     // Catch: Exception -> L11
            d.h.b.o.c(r13, "killShell(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkShellResultToClient(Ctrd.INSTANCE, r13);
        L8:
            return new i(this.f11560b, -1, "", "", null, "ctrd killShell failed: shell handle was not created by this SDK instance", 16, null);
        L11:
            e = move-exception;
            String r3 = "";
            String r4 = "";
            return new i(this.f11560b, -1, r3, r4, null, Ctrd.access$frameworkError(Ctrd.INSTANCE, "killShell", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 16, null);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$migrateLegacyHomeData$2")
    static final class af extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11562b;

        af(d r3, d.c.d<? super af> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11562b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((af) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), af.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new af(this.f11562b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f11561a != 0) goto L15;
            d.o.a(r6);
            CtrdRuntimeHandle r5 = this.f11562b.b();     // Catch: Exception -> L11
            if (r5 == null) goto L8;
            CtrdOperationResult r7 = Ctrd.access$manager(Ctrd.INSTANCE).getWorkspaceManager().migrateLegacyHomeData(r5);     // Catch: Exception -> L11
            d.h.b.o.c(r7, "migrateLegacyHomeData(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r7);
        L8:
            return new c(-1, "", "ctrd migrateLegacyHomeData failed: missing framework runtime handle");
        L11:
            e = move-exception;
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "migrateLegacyHomeData", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$open$3")
    static final class ag extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f11564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f11565c;

        ag(o r3, boolean r4, d.c.d<? super ag> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11564b = r3;
            this.f11565c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super e> r4) {
            return ((ag) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ag.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ag(this.f11564b, this.f11565c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super e> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f11563a != 0) goto L11;
            d.o.a(r8);
            CtrdRuntimeOpenResult r7 = Ctrd.access$manager(Ctrd.INSTANCE).getRuntimeManager().open(this.f11564b.a(), this.f11565c);     // Catch: Exception -> L7
            d.h.b.o.c(r7, "open(...)");     // Catch: Exception -> L7
            return Ctrd.access$frameworkRuntimeOpenResultToClient(Ctrd.INSTANCE, r7);
        L7:
            e = move-exception;
            return new e(-1, null, 3, null, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "open", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {686}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$queryLogs$2")
    static final class ah extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f11567b;

        ah(int r3, d.c.d<? super ah> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11567b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super a> r4) {
            return ((ah) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ah.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ah(this.f11567b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super a> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f11566a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r9);     // Catch: Exception -> L7
        L18:
            Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            InputStream r2 = (InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L28
            byte[] r6 = new byte[65536];     // Catch: Throwable -> L28
        L21:
            int r7 = r2.read(r6);     // Catch: Throwable -> L28
            if (r7 < 0) goto L23;
            r3.write(r6, 0, r7);     // Catch: Throwable -> L28
            goto L21
        L23:
            String r4 = r3.toString(d.o.d.f38623b.name());     // Catch: Throwable -> L28
            d.h.b.o.c(r4, "toString(...)");     // Catch: Throwable -> L28
            a r5 = new a(r4, "", true);     // Catch: Throwable -> L28
            d.f.c.a(r8, null);     // Catch: Exception -> L7
            return r5;
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            d.f.c.a(r8, th);     // Catch: Exception -> L7
            throw th;     // Catch: Exception -> L7
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r9);
            if (this.f11567b <= 0) goto L14;
            Ctrd r10 = Ctrd.INSTANCE;     // Catch: Exception -> L7
            int r11 = this.f11567b;     // Catch: Exception -> L7
            d.c.d<? super InputStream> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            this.f11566a = 1;     // Catch: Exception -> L7
            r9 = r10.queryLogsStream(r11, r12);     // Catch: Exception -> L7
            if (r9 != r0) goto L18;
            return r0;
        L14:
            return new a("", "maxBytes must be greater than zero", false);
        L7:
            e = move-exception;
            return new a("", Ctrd.access$frameworkError(Ctrd.INSTANCE, "queryLogs", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), false);
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$queryLogsStream$2")
    static final class ai extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ParcelFileDescriptor.AutoCloseInputStream>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f11569b;

        ai(int r3, d.c.d<? super ai> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11569b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ParcelFileDescriptor.AutoCloseInputStream> r4) {
            return ((ai) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ai.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ai(this.f11569b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ParcelFileDescriptor.AutoCloseInputStream> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f11568a != 0) goto L15;
            d.o.a(r4);
            ParcelFileDescriptor r3 = Ctrd.access$manager(Ctrd.INSTANCE).getObservabilityManager().queryLogs(this.f11569b);     // Catch: Exception -> L11
            if (r3 == null) goto L10;
            return new ParcelFileDescriptor.AutoCloseInputStream(r3);
        L10:
            throw new IllegalStateException("ctrd queryLogs stream unavailable");     // Catch: Exception -> L11
        L11:
            e = move-exception;
            throw new IllegalStateException(Ctrd.access$frameworkError(Ctrd.INSTANCE, "queryLogsStream", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$release$2")
    static final class aj extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11571b;

        aj(d r3, d.c.d<? super aj> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11571b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((aj) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aj.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aj(this.f11571b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f11570a != 0) goto L15;
            d.o.a(r6);
            CtrdRuntimeHandle r5 = this.f11571b.b();     // Catch: Exception -> L11
            if (r5 == null) goto L8;
            CtrdOperationResult r7 = Ctrd.access$manager(Ctrd.INSTANCE).getRuntimeManager().release(r5);     // Catch: Exception -> L11
            d.h.b.o.c(r7, "release(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r7);
        L8:
            return new c(-1, "", "ctrd release failed: missing framework runtime handle");
        L11:
            e = move-exception;
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "release", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$resetMyWorkspaces$2")
    static final class ak extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11572a;

        ak(d.c.d<? super ak> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((ak) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ak.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ak((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f11572a != 0) goto L11;
            d.o.a(r5);
            CtrdOperationResult r4 = Ctrd.access$manager(Ctrd.INSTANCE).getWorkspaceManager().resetMyWorkspaces();     // Catch: Exception -> L7
            d.h.b.o.c(r4, "resetMyWorkspaces(...)");     // Catch: Exception -> L7
            return Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r4);
        L7:
            e = move-exception;
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "resetMyWorkspaces", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$startShell$2")
    static final class al extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super m>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f11575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f11576d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<String> f11577e;

        al(d r3, n r4, String r5, List<String> r6, d.c.d<? super al> r7) {
            n r8 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11574b = r3;
            this.f11575c = r8;
            this.f11576d = r5;
            this.f11577e = r9;
            super(2, r10);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super m> r4) {
            return ((al) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), al.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new al(this.f11574b, this.f11575c, this.f11576d, this.f11577e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super m> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            d.c.a.b.a();
            if (this.f11573a != 0) goto L18;
            d.o.a(r12);
            CtrdRuntimeHandle r13 = this.f11574b.b();     // Catch: Exception -> L11
            if (r13 == null) goto L8;
            CtrdShellStartResult r14 = Ctrd.access$manager(Ctrd.INSTANCE).getShellManager().startShell(r13, this.f11576d, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(this.f11577e, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"), Ctrd.access$streamingListener(Ctrd.INSTANCE, this.f11575c));     // Catch: Exception -> L11
            d.h.b.o.c(r14, "startShell(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkStreamingHandleToClient(Ctrd.INSTANCE, r14, this.f11575c);
        L8:
            return Ctrd.access$missingStreamingHandle(Ctrd.INSTANCE, "ctrd startShell failed: missing framework runtime handle", this.f11575c);
        L11:
            e = move-exception;
            String r4 = "";
            String r5 = "";
            i r10 = new i(null, -1, r4, r5, null, Ctrd.access$frameworkError(Ctrd.INSTANCE, "startShell", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 16, null);
            n r11 = this.f11575c;
            if (r11 == null) goto L16;
            r11.a(r10.e());
        L16:
            return new m(null, (au) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.y.a(r10), au.class, "com.obric.aiagent.plugin"));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class am implements CtrdShellOutputListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f11578a;

        am(n r3) {
            this.f11578a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$uninstallGHotfix$2")
    static final class an extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11580b;

        an(String r3, d.c.d<? super an> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11580b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((an) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), an.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new an(this.f11580b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f11579a != 0) goto L11;
            d.o.a(r5);
            CtrdOperationResult r4 = Ctrd.access$manager(Ctrd.INSTANCE).getWorkspaceManager().uninstallGHotfix(this.f11580b);     // Catch: Exception -> L7
            d.h.b.o.c(r4, "uninstallGHotfix(...)");     // Catch: Exception -> L7
            return Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r4);
        L7:
            e = move-exception;
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "uninstallGHotfix", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$waitShell$2")
    static final class ao extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f11582b;

        ao(h r3, d.c.d<? super ao> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11582b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return ((ao) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ao.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ao(this.f11582b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f11581a != 0) goto L15;
            d.o.a(r11);
            CtrdShellHandle r12 = Ctrd.access$frameworkShellHandle(Ctrd.INSTANCE, this.f11582b);     // Catch: Exception -> L11
            if (r12 == null) goto L8;
            CtrdShellResult r13 = Ctrd.access$manager(Ctrd.INSTANCE).getShellManager().waitShell(r12);     // Catch: Exception -> L11
            d.h.b.o.c(r13, "waitShell(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkShellResultToClient(Ctrd.INSTANCE, r13);
        L8:
            return new i(this.f11582b, -1, "", "", null, "ctrd waitShell failed: shell handle was not created by this SDK instance", 16, null);
        L11:
            e = move-exception;
            String r3 = "";
            String r4 = "";
            return new i(this.f11582b, -1, r3, r4, null, Ctrd.access$frameworkError(Ctrd.INSTANCE, "waitShell", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 16, null);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptor f11585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f11586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f11587e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f11583a == r6.f11583a) goto L12;
            return false;
        L12:
            if (this.f11584b == r6.f11584b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11585c, r6.f11585c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11586d, r6.f11586d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f11587e, r6.f11587e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f11583a) * 31) + Integer.hashCode(this.f11584b)) * 31;
            ParcelFileDescriptor r1 = this.f11585c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.f11586d.hashCode()) * 31) + this.f11587e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "GatewayResult(resultCode=" + this.f11583a + ", gatewayState=" + this.f11584b + ", proxyFd=" + this.f11585c + ", ctrdout=" + this.f11586d + ", error=" + this.f11587e + ')';
        }

        public b(int r2, int r3, ParcelFileDescriptor r4, String r5, String r6) {
            d.h.b.o.e(r5, "ctrdout");
            d.h.b.o.e(r6, WsConstants.KEY_CONNECTION_ERROR);
            this.f11583a = r2;
            this.f11584b = r3;
            this.f11585c = r4;
            this.f11586d = r5;
            this.f11587e = r6;
        }

        public final int a() {
            return this.f11583a;
        }

        public final int b() {
            return this.f11584b;
        }

        public final ParcelFileDescriptor c() {
            return this.f11585c;
        }

        public final String d() {
            return this.f11587e;
        }

        public final boolean e() {
            if (this.f11583a != 0) goto L17;
            if (this.f11584b != 2) goto L17;
            ParcelFileDescriptor r4 = this.f11585c;
            if (r4 == null) goto L13;
            FileDescriptor r5 = r4.getFileDescriptor();
            if (r5 == null) goto L13;
            if (r5.valid() != true) goto L13;
            boolean r6 = true;
        L14:
            if (r6 == false) goto L17;
            return true;
        L13:
            r6 = false;
        L17:
            return false;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11590c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f11588a == r6.f11588a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11589b, r6.f11589b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11590c, r6.f11590c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f11588a) * 31) + this.f11589b.hashCode()) * 31) + this.f11590c.hashCode();
        }

        public String toString() {
            return "OperationResult(resultCode=" + this.f11588a + ", ctrdout=" + this.f11589b + ", error=" + this.f11590c + ')';
        }

        public c(int r2, String r3, String r4) {
            d.h.b.o.e(r3, "ctrdout");
            d.h.b.o.e(r4, WsConstants.KEY_CONNECTION_ERROR);
            this.f11588a = r2;
            this.f11589b = r3;
            this.f11590c = r4;
        }

        public final int a() {
            return this.f11588a;
        }

        public final String b() {
            return this.f11589b;
        }

        public final String c() {
            return this.f11590c;
        }

        public final boolean d() {
            if (this.f11588a != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f11594d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final CtrdRuntimeHandle f11595e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11591a, r6.f11591a) == true) goto L12;
            return false;
        L12:
            if (this.f11592b == r6.f11592b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11593c, r6.f11593c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11594d, r6.f11594d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f11595e, r6.f11595e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.f11591a.hashCode() * 31) + Integer.hashCode(this.f11592b)) * 31) + this.f11593c.hashCode()) * 31) + this.f11594d.hashCode()) * 31;
            CtrdRuntimeHandle r2 = this.f11595e;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "RuntimeHandle(id=" + this.f11591a + ", resultCode=" + this.f11592b + ", ctrdout=" + this.f11593c + ", error=" + this.f11594d + ", frameworkHandleRef=" + this.f11595e + ')';
        }

        public d(String r3, int r4, String r5, String r6, CtrdRuntimeHandle r7) {
            CtrdRuntimeHandle r8 = (CtrdRuntimeHandle) ZeusTransformUtils.wrapperContextForParams(r7, CtrdRuntimeHandle.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, DbHelper.COL_ID);
            d.h.b.o.e(r5, "ctrdout");
            d.h.b.o.e(r6, WsConstants.KEY_CONNECTION_ERROR);
            this.f11591a = r3;
            this.f11592b = r4;
            this.f11593c = r5;
            this.f11594d = r6;
            this.f11595e = r8;
        }

        public final String a() {
            return this.f11591a;
        }

        public final CtrdRuntimeHandle b() {
            return this.f11595e;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f11597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f11598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ParcelFileDescriptor f11599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f11600e;
        private final String f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f11596a == r6.f11596a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11597b, r6.f11597b) == true) goto L15;
            return false;
        L15:
            if (this.f11598c == r6.f11598c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11599d, r6.f11599d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f11600e, r6.f11600e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f11596a) * 31;
            d r1 = this.f11597b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.f11598c)) * 31;
            ParcelFileDescriptor r5 = this.f11599d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.f11600e.hashCode()) * 31) + this.f.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "RuntimeOpenResult(resultCode=" + this.f11596a + ", handle=" + this.f11597b + ", gatewayState=" + this.f11598c + ", proxyFd=" + this.f11599d + ", ctrdout=" + this.f11600e + ", error=" + this.f + ')';
        }

        public e(int r2, d r3, int r4, ParcelFileDescriptor r5, String r6, String r7) {
            d.h.b.o.e(r6, "ctrdout");
            d.h.b.o.e(r7, WsConstants.KEY_CONNECTION_ERROR);
            this.f11596a = r2;
            this.f11597b = r3;
            this.f11598c = r4;
            this.f11599d = r5;
            this.f11600e = r6;
            this.f = r7;
        }

        public final int a() {
            return this.f11596a;
        }

        public final d b() {
            return this.f11597b;
        }

        public final int c() {
            return this.f11598c;
        }

        public final ParcelFileDescriptor d() {
            return this.f11599d;
        }

        public final String e() {
            return this.f11600e;
        }

        public final String f() {
            return this.f;
        }

        public final boolean g() {
            if (this.f11596a != 0) goto L18;
            d r4 = this.f11597b;
            if (r4 == null) goto L14;
            String r5 = r4.a();
            if (r5 == null) goto L14;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
            boolean r6 = true;
        L12:
            if (r6 != true) goto L14;
            boolean r7 = true;
        L15:
            if (r7 == false) goto L18;
            return true;
        L11:
            r6 = false;
        L14:
            r7 = false;
        L18:
            return false;
        }

        public final boolean h() {
            if (this.f11596a != 0) goto L17;
            if (this.f11598c != 2) goto L17;
            ParcelFileDescriptor r4 = this.f11599d;
            if (r4 == null) goto L13;
            FileDescriptor r5 = r4.getFileDescriptor();
            if (r5 == null) goto L13;
            if (r5.valid() != true) goto L13;
            boolean r6 = true;
        L14:
            if (r6 == false) goto L17;
            return true;
        L13:
            r6 = false;
        L17:
            return false;
        }

        public final boolean i() {
            return g();
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f11602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f11604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f11605e;
        private final String f;
        private final int g;
        private final boolean h;
        private final boolean i;
        private final int j;
        private final int k;
        private final int l;
        private final int m;
        private final int n;
        private final String o;
        private final int p;
        private final int q;
        private final String r;
        private final String s;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (this.f11601a == r6.f11601a) goto L12;
            return false;
        L12:
            if (this.f11602b == r6.f11602b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11603c, r6.f11603c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11604d, r6.f11604d) == true) goto L21;
            return false;
        L21:
            if (this.f11605e == r6.f11605e) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (d.h.b.o.a(this.o, r6.o) == true) goto L54;
            return false;
        L54:
            if (this.p == r6.p) goto L57;
            return false;
        L57:
            if (this.q == r6.q) goto L60;
            return false;
        L60:
            if (d.h.b.o.a(this.r, r6.r) == true) goto L63;
            return false;
        L63:
            if (d.h.b.o.a(this.s, r6.s) == true) goto L65;
            return false;
        L65:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((Integer.hashCode(this.f11601a) * 31) + Boolean.hashCode(this.f11602b)) * 31) + this.f11603c.hashCode()) * 31) + this.f11604d.hashCode()) * 31) + Integer.hashCode(this.f11605e)) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n)) * 31) + this.o.hashCode()) * 31) + Integer.hashCode(this.p)) * 31) + Integer.hashCode(this.q)) * 31) + this.r.hashCode()) * 31) + this.s.hashCode();
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("RuntimeStatus(resultCode=").append(this.f11601a).append(", exists=").append(this.f11602b).append(", runtimeHandle=").append(this.f11603c).append(", scenario=").append(this.f11604d).append(", workspaceId=").append(this.f11605e).append(", containerName=").append(this.f).append(", ownerUid=").append(this.g).append(", runtimeClosed=").append(this.h).append(", containerRunning=").append(this.i).append(", initPid=").append(this.j).append(", exitStatus=").append(this.k).append(", gatewayStartupMode=");
            r0.append(this.l).append(", gatewayState=").append(this.m).append(", gatewayPid=").append(this.n).append(", gatewayLastError=").append(this.o).append(", activeClientCount=").append(this.p).append(", activeShellCount=").append(this.q).append(", ctrdout=").append(this.r).append(", error=").append(this.s).append(')');
            return r0.toString();
        }

        public f(int r9, boolean r10, String r11, String r12, int r13, String r14, int r15, boolean r16, boolean r17, int r18, int r19, int r20, int r21, int r22, String r23, int r24, int r25, String r26, String r27) {
            d.h.b.o.e(r11, "runtimeHandle");
            d.h.b.o.e(r12, "scenario");
            d.h.b.o.e(r14, "containerName");
            d.h.b.o.e(r23, "gatewayLastError");
            d.h.b.o.e(r26, "ctrdout");
            d.h.b.o.e(r27, WsConstants.KEY_CONNECTION_ERROR);
            this.f11601a = r9;
            this.f11602b = r10;
            this.f11603c = r11;
            this.f11604d = r12;
            this.f11605e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
            this.i = r17;
            this.j = r18;
            this.k = r19;
            this.l = r20;
            this.m = r21;
            this.n = r22;
            this.o = r23;
            this.p = r24;
            this.q = r25;
            this.r = r26;
            this.s = r27;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f11609d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11606a, r6.f11606a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11607b, r6.f11607b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11608c, r6.f11608c) == true) goto L18;
            return false;
        L18:
            if (this.f11609d == r6.f11609d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f11606a.hashCode() * 31) + this.f11607b.hashCode()) * 31) + this.f11608c.hashCode()) * 31) + Boolean.hashCode(this.f11609d);
        }

        public String toString() {
            return "SharePathsResult(hostPath=" + this.f11606a + ", containerPath=" + this.f11607b + ", error=" + this.f11608c + ", successful=" + this.f11609d + ')';
        }

        public g(String r2, String r3, String r4, boolean r5) {
            d.h.b.o.e(r2, "hostPath");
            d.h.b.o.e(r3, "containerPath");
            d.h.b.o.e(r4, WsConstants.KEY_CONNECTION_ERROR);
            this.f11606a = r2;
            this.f11607b = r3;
            this.f11608c = r4;
            this.f11609d = r5;
        }

        public final String a() {
            return this.f11606a;
        }

        public final String b() {
            return this.f11607b;
        }

        public final String c() {
            return this.f11608c;
        }

        public final boolean d() {
            return this.f11609d;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f11611b;

        public h(String r2, Object r3) {
            d.h.b.o.e(r2, DbHelper.COL_ID);
            this.f11610a = r2;
            this.f11611b = r3;
        }

        public final String a() {
            return this.f11610a;
        }

        public final Object b() {
            return this.f11611b;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f11612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f11615d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f11616e;
        private final String f;

        public static /* synthetic */ i a(i r4, h r5, int r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.f11612a;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.f11613b;
        L8:
            int r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.f11614c;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.f11615d;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.f11616e;
        L17:
            String r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.f;
        L20:
            h r14 = r5;
            return r4.a(r14, r13, r0, r1, r2, r10);
        }

        public final i a(h r8, int r9, String r10, String r11, String r12, String r13) {
            d.h.b.o.e(r10, "stdout");
            d.h.b.o.e(r11, "stderr");
            d.h.b.o.e(r12, "ctrdout");
            d.h.b.o.e(r13, WsConstants.KEY_CONNECTION_ERROR);
            return new i(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
            return false;
        L8:
            i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11612a, r6.f11612a) == true) goto L12;
            return false;
        L12:
            if (this.f11613b == r6.f11613b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11614c, r6.f11614c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f11615d, r6.f11615d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f11616e, r6.f11616e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            h r0 = this.f11612a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((((((r1 * 31) + Integer.hashCode(this.f11613b)) * 31) + this.f11614c.hashCode()) * 31) + this.f11615d.hashCode()) * 31) + this.f11616e.hashCode()) * 31) + this.f.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ShellResult(handle=" + this.f11612a + ", exitCode=" + this.f11613b + ", stdout=" + this.f11614c + ", stderr=" + this.f11615d + ", ctrdout=" + this.f11616e + ", error=" + this.f + ')';
        }

        public i(h r2, int r3, String r4, String r5, String r6, String r7) {
            d.h.b.o.e(r4, "stdout");
            d.h.b.o.e(r5, "stderr");
            d.h.b.o.e(r6, "ctrdout");
            d.h.b.o.e(r7, WsConstants.KEY_CONNECTION_ERROR);
            this.f11612a = r2;
            this.f11613b = r3;
            this.f11614c = r4;
            this.f11615d = r5;
            this.f11616e = r6;
            this.f = r7;
        }

        public /* synthetic */ i(h r10, int r11, String r12, String r13, String r14, String r15, int r16, d.h.b.h r17) {
            if ((r16 & 16) == 0) goto L5;
            String r7 = "";
        L7:
            if ((r16 & 32) == 0) goto L9;
            String r8 = "";
        L10:
            this(r10, r11, r12, r13, r7, r8);
            return;
        L9:
            r8 = r15;
            goto L10
        L5:
            r7 = r14;
            goto L7
        }

        public final int a() {
            return this.f11613b;
        }

        public final String b() {
            return this.f11614c;
        }

        public final String c() {
            return this.f11615d;
        }

        public final String d() {
            return this.f11616e;
        }

        public final String e() {
            return this.f;
        }

        public final boolean f() {
            if (this.f11612a == null) goto L13;
            if (this.f11613b < 0) goto L13;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == false) goto L13;
            return true;
        L9:
            r4 = false;
        L13:
            return false;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final enum j extends Enum<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11617a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f11618b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f11619c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final j f11620d = null;
        private static final /* synthetic */ j[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f11621e;

        /* JADX INFO: compiled from: Ctrd.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }
        }

        private static final /* synthetic */ j[] b() {
            return new j[]{f11618b, f11619c, f11620d};
        }

        public static j valueOf(String r2) {
            return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
        }

        public static j[] values() {
            return (j[]) ZeusTransformUtils.preCheckCast(f.clone(), j[].class, "com.obric.aiagent.plugin");
        }

        private j(String r1, int r2, String r3) {
            super(r1, r2);
            this.f11621e = r3;
        }

        public final String a() {
            return this.f11621e;
        }

        static {
            f11618b = new j("HOME", 0, "home");
            f11619c = new j("TMP", 1, "tmp");
            f11620d = new j("SHARE", 2, "share");
            j[] r0 = b();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            f11617a = new a(null);
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f11625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f11626e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, k.class) == true) goto L8;
            return false;
        L8:
            k r10 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11622a, r10.f11622a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11623b, r10.f11623b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f11624c, r10.f11624c) == true) goto L18;
            return false;
        L18:
            if (this.f11625d == r10.f11625d) goto L21;
            return false;
        L21:
            if (this.f11626e == r10.f11626e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f11622a.hashCode() * 31) + this.f11623b.hashCode()) * 31) + this.f11624c.hashCode()) * 31) + Long.hashCode(this.f11625d)) * 31) + Boolean.hashCode(this.f11626e);
        }

        public String toString() {
            return "StorageUsageEntry(target=" + this.f11622a + ", displayName=" + this.f11623b + ", containerPath=" + this.f11624c + ", usedBytes=" + this.f11625d + ", clearable=" + this.f11626e + ')';
        }

        public k(String r2, String r3, String r4, long r5, boolean r7) {
            d.h.b.o.e(r2, "target");
            d.h.b.o.e(r3, "displayName");
            d.h.b.o.e(r4, "containerPath");
            this.f11622a = r2;
            this.f11623b = r3;
            this.f11624c = r4;
            this.f11625d = r5;
            this.f11626e = r7;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<k> f11627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f11629c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
            return false;
        L8:
            l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11627a, r6.f11627a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11628b, r6.f11628b) == true) goto L15;
            return false;
        L15:
            if (this.f11629c == r6.f11629c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11627a.hashCode() * 31) + this.f11628b.hashCode()) * 31) + Boolean.hashCode(this.f11629c);
        }

        public String toString() {
            return "StorageUsageResult(entries=" + this.f11627a + ", error=" + this.f11628b + ", successful=" + this.f11629c + ')';
        }

        public l(List<k> r3, String r4, boolean r5) {
            List<k> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "entries");
            d.h.b.o.e(r4, WsConstants.KEY_CONNECTION_ERROR);
            this.f11627a = r6;
            this.f11628b = r4;
            this.f11629c = r5;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f11630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final au<i> f11631b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
            return false;
        L8:
            m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11630a, r6.f11630a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11631b, r6.f11631b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            h r0 = this.f11630a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f11631b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "StreamingHandle(handle=" + this.f11630a + ", result=" + this.f11631b + ')';
        }

        public m(h r3, au<i> r4) {
            au<i> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r4, au.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "result");
            this.f11630a = r3;
            this.f11631b = r5;
        }

        public final h a() {
            return this.f11630a;
        }

        public final au<i> b() {
            return this.f11631b;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public interface n {
        void a(h r1);

        void a(i r1);

        void a(String r1);
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    public static final enum o extends Enum<o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f11632a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final o f11633b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final o f11634c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final o f11635d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final o f11636e = null;
        private static final /* synthetic */ o[] g = null;
        private static final /* synthetic */ d.d.a h = null;
        private final String f;

        private static final /* synthetic */ o[] b() {
            return new o[]{f11632a, f11633b, f11634c, f11635d, f11636e};
        }

        public static o valueOf(String r2) {
            return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
        }

        public static o[] values() {
            return (o[]) ZeusTransformUtils.preCheckCast(g.clone(), o[].class, "com.obric.aiagent.plugin");
        }

        private o(String r1, int r2, String r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final String a() {
            return this.f;
        }

        static {
            f11632a = new o("DEFAULT", 0, DownloadSettingKeys.BugFix.DEFAULT);
            f11633b = new o("MONITORED", 1, "monitored");
            f11634c = new o("UNMONITORED", 2, "unmonitored");
            f11635d = new o("ONESHOT", 3, "oneshot");
            f11636e = new o("POWER_SAVING", 4, "power_saving");
            o[] r0 = b();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$clearLogs$2")
    static final class p extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11637a;

        p(d.c.d<? super p> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f11637a != 0) goto L11;
            d.o.a(r5);
            CtrdOperationResult r4 = Ctrd.access$manager(Ctrd.INSTANCE).getObservabilityManager().clearLogs();     // Catch: Exception -> L7
            d.h.b.o.c(r4, "clearLogs(...)");     // Catch: Exception -> L7
            return Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r4);
        L7:
            e = move-exception;
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "clearLogs", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$clearWorkspaceStorage$2")
    static final class q extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f11640c;

        q(d r3, j r4, d.c.d<? super q> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11639b = r3;
            this.f11640c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f11639b, this.f11640c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f11638a != 0) goto L15;
            d.o.a(r6);
            CtrdRuntimeHandle r1 = this.f11639b.b();     // Catch: Exception -> L11
            if (r1 == null) goto L8;
            CtrdOperationResult r5 = Ctrd.access$manager(Ctrd.INSTANCE).getWorkspaceManager().clearStorage(r1, this.f11640c.a());     // Catch: Exception -> L11
            d.h.b.o.c(r5, "clearStorage(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r5);
        L8:
            return new c(-1, "", "ctrd clearWorkspaceStorage failed: missing framework runtime handle");
        L11:
            e = move-exception;
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "clearWorkspaceStorage", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$close$2")
    static final class r extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11642b;

        r(d r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11642b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f11642b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f11641a != 0) goto L15;
            d.o.a(r6);
            CtrdRuntimeHandle r5 = this.f11642b.b();     // Catch: Exception -> L11
            if (r5 == null) goto L8;
            CtrdOperationResult r7 = Ctrd.access$manager(Ctrd.INSTANCE).getRuntimeManager().close(r5);     // Catch: Exception -> L11
            d.h.b.o.c(r7, "close(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkOperationResultToClient(Ctrd.INSTANCE, r7);
        L8:
            return new c(-1, "", "ctrd close failed: missing framework runtime handle");
        L11:
            e = move-exception;
            return new c(-1, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "close", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$enableGateway$2")
    static final class s extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11644b;

        s(d r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11644b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super b> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f11644b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super b> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f11643a != 0) goto L15;
            d.o.a(r7);
            CtrdRuntimeHandle r6 = this.f11644b.b();     // Catch: Exception -> L11
            if (r6 == null) goto L8;
            Ctrd r8 = Ctrd.INSTANCE;     // Catch: Exception -> L11
            CtrdGatewayResult r9 = Ctrd.access$manager(Ctrd.INSTANCE).getRuntimeManager().enableGateway(r6);     // Catch: Exception -> L11
            d.h.b.o.c(r9, "enableGateway(...)");     // Catch: Exception -> L11
            return Ctrd.access$frameworkGatewayResultToClient(r8, r9);
        L8:
            return new b(-1, 3, null, "", "ctrd enableGateway failed: missing framework runtime handle");
        L11:
            e = move-exception;
            return new b(-1, 3, null, "", Ctrd.access$frameworkError(Ctrd.INSTANCE, "enableGateway", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {332}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$eval$2")
    static final class t extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o f11647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f11648d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> f11649e;

        t(String r3, o r4, List<String> r5, d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r6, d.c.d<? super t> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.a.b<d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11646b = r3;
            this.f11647c = r4;
            this.f11648d = r8;
            this.f11649e = r9;
            super(2, r10);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f11646b, this.f11647c, this.f11648d, this.f11649e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f11645a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r13);     // Catch: Exception -> L7
        L18:
            return r13;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r13);
            Ctrd r14 = Ctrd.INSTANCE;     // Catch: Exception -> L7
            String r4 = this.f11646b;     // Catch: Exception -> L7
            o r2 = this.f11647c;     // Catch: Exception -> L7
            if (r2 != null) goto L15;
            r2 = o.f11632a;     // Catch: Exception -> L7
        L15:
            o r5 = r2;
            List<String> r6 = this.f11648d;     // Catch: Exception -> L7
            d.h.a.b<d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r7 = this.f11649e;     // Catch: Exception -> L7
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            this.f11645a = 1;     // Catch: Exception -> L7
            r13 = Ctrd.access$evalWithStartedCallback(r14, r4, r5, r6, r7, r8);     // Catch: Exception -> L7
            if (r13 != r0) goto L18;
            return r0;
        L7:
            e = move-exception;
            String r9 = "";
            String r10 = "";
            return new i(null, -1, r9, r10, null, Ctrd.access$frameworkError(Ctrd.INSTANCE, "eval", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 16, null);
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {417}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$evalShell$2")
    static final class u extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super i>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f11653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> f11654e;

        /* JADX INFO: compiled from: Ctrd.kt */
        @d.c.b.a.f(b = "Ctrd.kt", c = {BDVideoUploaderBase.KeyIsPrivateVideo}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$evalShell$2$1$1")
        static final class a extends d.c.b.a.l implements d.h.a.b<d.c.d<? super i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f11655a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f11656b;

            a(h r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f11656b = r3;
                super(1, r5);
            }

            public final Object a(d.c.d<? super i> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f11656b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super i> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f11655a;
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
                h r2 = this.f11656b;
                d.c.d<? super i> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f11655a = 1;
                r6 = r7.killShell(r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        u(d r3, String r4, List<String> r5, d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r6, d.c.d<? super u> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.a.b<d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11651b = r3;
            this.f11652c = r4;
            this.f11653d = r8;
            this.f11654e = r9;
            super(2, r10);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return ((u) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), u.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new u(this.f11651b, this.f11652c, this.f11653d, this.f11654e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super i> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f11650a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r14);     // Catch: Exception -> L7
        L29:
            return (i) ZeusTransformUtils.preCheckCast(r14, i.class, "com.obric.aiagent.plugin");
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r14);
            CtrdRuntimeHandle r15 = this.f11651b.b();     // Catch: Exception -> L7
            if (r15 == null) goto L15;
            CtrdShellStartResult r16 = Ctrd.access$manager(Ctrd.INSTANCE).getShellManager().startShell(r15, this.f11652c, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(this.f11653d, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"), null);     // Catch: Exception -> L7
            d.h.b.o.c(r16, "startShell(...)");     // Catch: Exception -> L7
            m r17 = Ctrd.access$frameworkStreamingHandleToClient(Ctrd.INSTANCE, r16, null);     // Catch: Exception -> L7
            h r2 = r17.a();     // Catch: Exception -> L7
            if (r2 == null) goto L21;
            d.h.a.b<d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r4 = this.f11654e;     // Catch: Exception -> L7
            if (r4 == null) goto L21;
            r4.invoke(new a(r2, null));     // Catch: Exception -> L7
        L21:
            au<i> r18 = r17.b();     // Catch: Exception -> L7
            d.c.d<? super i> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            this.f11650a = 1;     // Catch: Exception -> L7
            r14 = r18.a(r3);     // Catch: Exception -> L7
            if (r14 != r0) goto L29;
            return r0;
        L15:
            return new i(null, -1, "", "", null, "ctrd evalShell failed: missing framework runtime handle", 16, null);
        L7:
            e = move-exception;
            String r7 = "";
            String r8 = "";
            return new i(null, -1, r7, r8, null, Ctrd.access$frameworkError(Ctrd.INSTANCE, "evalShell", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 16, null);
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {349, 363, 366, 366, 375}, d = "evalWithStartedCallback", e = "com.bytedance.virt.Ctrd")
    static final class v extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f11657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f11658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f11659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f11660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f11661e;
        final /* synthetic */ Ctrd f;
        int g;

        v(Ctrd r3, d.c.d<? super v> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f11661e = r7;
            this.g |= Integer.MIN_VALUE;
            return Ctrd.access$evalWithStartedCallback(this.f, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {367}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$evalWithStartedCallback$2")
    static final class w extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11663b;

        w(d r3, d.c.d<? super w> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11663b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((w) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new w(this.f11663b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f11662a;
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
            d r2 = this.f11663b;
            d.c.d<? super c> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11662a = 1;
            r6 = r7.close(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {376}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$evalWithStartedCallback$closeResult$1")
    static final class x extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f11665b;

        x(d r3, d.c.d<? super x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11665b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return ((x) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new x(this.f11665b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super c> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f11664a;
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
            d r2 = this.f11665b;
            d.c.d<? super c> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11664a = 1;
            r6 = r7.close(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$frameworkStreamingHandleToClient$1")
    static final class y extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CompletableFuture<CtrdShellResult> f11667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.w<i> f11668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f11669d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f11670e;

        y(CompletableFuture<CtrdShellResult> r3, kotlinx.coroutines.w<i> r4, n r5, h r6, d.c.d<? super y> r7) {
            kotlinx.coroutines.w<i> r8 = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
            n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f11667b = r3;
            this.f11668c = r8;
            this.f11669d = r9;
            this.f11670e = r6;
            super(2, r10);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((y) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new y(this.f11667b, this.f11668c, this.f11669d, this.f11670e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            d.c.a.b.a();
            if (this.f11666a != 0) goto L16;
            d.o.a(r12);
            Ctrd r13 = Ctrd.INSTANCE;     // Catch: Exception -> L9
            CtrdShellResult r1 = this.f11667b.get();     // Catch: Exception -> L9
            d.h.b.o.c(r1, "get(...)");     // Catch: Exception -> L9
            i r14 = Ctrd.access$frameworkShellResultToClient(r13, (CtrdShellResult) ZeusTransformUtils.preCheckCast(r1, CtrdShellResult.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L9
            this.f11668c.a(r14);     // Catch: Exception -> L9
            n r2 = this.f11669d;     // Catch: Exception -> L9
            if (r2 == null) goto L14;
            r2.a(r14);     // Catch: Exception -> L9
        L14:
            return d.x.f38692a;
        L9:
            e = move-exception;
            String r4 = "";
            String r5 = "";
            i r10 = new i(this.f11670e, -1, r4, r5, null, Ctrd.access$frameworkError(Ctrd.INSTANCE, "startShell wait", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 16, null);
            this.f11668c.a(r10);
            n r11 = this.f11669d;
            if (r11 == null) goto L14;
            r11.a(r10.e());
            goto L14
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Ctrd.kt */
    @d.c.b.a.f(b = "Ctrd.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.virt.Ctrd$getApiVersion$2")
    static final class z extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11671a;

        z(d.c.d<? super z> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new z((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f11671a != 0) goto L7;
            d.o.a(r1);
            return d.c.b.a.b.a(Ctrd.access$manager(Ctrd.INSTANCE).getApiVersion());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private Ctrd() {
    }

    public static final /* synthetic */ String access$appendMessage(Ctrd r0, String r1, String r2) {
        return r0.appendMessage(r1, r2);
    }

    public static final /* synthetic */ void access$closeQuietly(Ctrd r0, ParcelFileDescriptor r1) {
        r0.closeQuietly(r1);
    }

    public static final /* synthetic */ Object access$evalWithStartedCallback(Ctrd r8, String r9, o r10, List r11, d.h.a.b r12, d.c.d r13) {
        return r8.evalWithStartedCallback(r9, r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String access$frameworkError(Ctrd r0, String r1, Throwable r2) {
        return r0.frameworkError(r1, r2);
    }

    public static final /* synthetic */ b access$frameworkGatewayResultToClient(Ctrd r2, CtrdGatewayResult r3) {
        return r2.frameworkGatewayResultToClient((CtrdGatewayResult) ZeusTransformUtils.wrapperContextForParams(r3, CtrdGatewayResult.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ c access$frameworkOperationResultToClient(Ctrd r2, CtrdOperationResult r3) {
        return r2.frameworkOperationResultToClient((CtrdOperationResult) ZeusTransformUtils.wrapperContextForParams(r3, CtrdOperationResult.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ e access$frameworkRuntimeOpenResultToClient(Ctrd r2, CtrdRuntimeOpenResult r3) {
        return r2.frameworkRuntimeOpenResultToClient((CtrdRuntimeOpenResult) ZeusTransformUtils.wrapperContextForParams(r3, CtrdRuntimeOpenResult.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ f access$frameworkRuntimeStatusToClient(Ctrd r2, CtrdRuntimeStatus r3) {
        return r2.frameworkRuntimeStatusToClient((CtrdRuntimeStatus) ZeusTransformUtils.wrapperContextForParams(r3, CtrdRuntimeStatus.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ g access$frameworkSharePathsResultToClient(Ctrd r2, CtrdSharePathsResult r3) {
        return r2.frameworkSharePathsResultToClient((CtrdSharePathsResult) ZeusTransformUtils.wrapperContextForParams(r3, CtrdSharePathsResult.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ CtrdShellHandle access$frameworkShellHandle(Ctrd r0, h r1) {
        return r0.frameworkShellHandle(r1);
    }

    public static final /* synthetic */ i access$frameworkShellResultToClient(Ctrd r2, CtrdShellResult r3) {
        return r2.frameworkShellResultToClient((CtrdShellResult) ZeusTransformUtils.wrapperContextForParams(r3, CtrdShellResult.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ l access$frameworkStorageUsageResultToClient(Ctrd r2, CtrdStorageUsageResult r3) {
        return r2.frameworkStorageUsageResultToClient((CtrdStorageUsageResult) ZeusTransformUtils.wrapperContextForParams(r3, CtrdStorageUsageResult.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ m access$frameworkStreamingHandleToClient(Ctrd r2, CtrdShellStartResult r3, n r4) {
        return r2.frameworkStreamingHandleToClient((CtrdShellStartResult) ZeusTransformUtils.wrapperContextForParams(r3, CtrdShellStartResult.class, "com.obric.aiagent.plugin"), (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.am access$getIoScope$p() {
        return ioScope;
    }

    public static final /* synthetic */ String access$localGHotfixSourceError(Ctrd r0, String r1, String r2, Throwable r3) {
        return r0.localGHotfixSourceError(r1, r2, r3);
    }

    public static final /* synthetic */ ObricCtrdManager access$manager(Ctrd r0) {
        return r0.manager();
    }

    public static final /* synthetic */ f access$missingRuntimeStatus(Ctrd r0, d r1, String r2) {
        return r0.missingRuntimeStatus(r1, r2);
    }

    public static final /* synthetic */ m access$missingStreamingHandle(Ctrd r2, String r3, n r4) {
        return r2.missingStreamingHandle(r3, (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ CtrdShellOutputListener access$streamingListener(Ctrd r2, n r3) {
        return r2.streamingListener((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin"));
    }

    static {
        INSTANCE = new Ctrd();
        ioScope = kotlinx.coroutines.an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    public final Object getApiVersion(d.c.d<? super Integer> r4) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new z(null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public static /* synthetic */ Object open$default(Ctrd r1, o r2, d.c.d r3, int r4, Object r5) {
        d.c.d<? super e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = o.f11632a;
    L6:
        return r1.open(r2, r6);
    }

    public final Object open(o r3, d.c.d<? super e> r4) {
        return open(r3, true, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object open(o r4, boolean r5, d.c.d<? super e> r6) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ag(r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object enableGateway(d r4, d.c.d<? super b> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new s(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object getRuntimeStatus(d r4, d.c.d<? super f> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new aa(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object close(d r4, d.c.d<? super c> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object release(d r4, d.c.d<? super c> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new aj(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public static /* synthetic */ Object eval$default(Ctrd r6, String r7, o r8, List r9, d.h.a.b r10, d.c.d r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super i> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r12 & 2) == 0) goto L5;
        o r2 = null;
    L7:
        if ((r12 & 4) == 0) goto L9;
        r14 = d.a.p.b();
    L9:
        List<String> r3 = r14;
        if ((r12 & 8) == 0) goto L12;
        d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r4 = null;
    L14:
        return r6.eval(r7, r2, r3, r4, r5);
    L12:
        r4 = r15;
        goto L14
    L5:
        r2 = r8;
        goto L7
    }

    public final Object eval(String r8, o r9, List<String> r10, d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r11, d.c.d<? super i> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(r8, r9, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object evalWithStartedCallback(String r26, o r27, List<String> r28, d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r29, d.c.d<? super i> r30) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r29, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, v.class) == false) goto L7;
        v r6 = (v) ZeusTransformUtils.preCheckCast(r5, v.class, "com.obric.aiagent.plugin");
        if ((r6.g & Integer.MIN_VALUE) == 0) goto L7;
        r6.g -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.f11661e;
        Object r8 = d.c.a.b.a();
        int r9 = r6.g;
        boolean r13 = true;
        d.x r14 = null;
        if (r9 == 0) goto L36;
        if (r9 == 1) goto L35;
        if (r9 == 2) goto L30;
        if (r9 == 3) goto L25;
        if (r9 == 4) goto L20;
        if (r9 != 5) goto L19;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r6.f11659c, i.class, "com.obric.aiagent.plugin");
        e r3 = (e) ZeusTransformUtils.preCheckCast(r6.f11658b, e.class, "com.obric.aiagent.plugin");
        Ctrd r10 = (Ctrd) ZeusTransformUtils.preCheckCast(r6.f11657a, Ctrd.class, "com.obric.aiagent.plugin");
        d.o.a(r7);     // Catch: Throwable -> L23
        i r15 = r0;
    L68:
        c r1 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r1.d() == true) goto L121;
        r15 = i.a(r15, null, 0, null, null, r10.appendMessage(r15.d(), r1.b()), r10.appendMessage(r15.e(), "ctrd close failed: " + r1.c()), 15, null);     // Catch: Throwable -> L23
    L121:
        d.n.a r11 = d.n.f38560a;     // Catch: Throwable -> L76
        Ctrd r12 = (Ctrd) ZeusTransformUtils.preCheckCast(r10, Ctrd.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L76
        ParcelFileDescriptor r16 = r3.d();     // Catch: Throwable -> L76
        if (r16 == null) goto L74;
        r16.close();     // Catch: Throwable -> L76
        r14 = d.x.f38692a;     // Catch: Throwable -> L76
    L74:
        d.n.f(r14);     // Catch: Throwable -> L76
    L78:
        return r15;
    L76:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L78
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        th = (Throwable) ZeusTransformUtils.preCheckCast(r6.f11659c, Throwable.class, "com.obric.aiagent.plugin");
        e r18 = (e) ZeusTransformUtils.preCheckCast(r6.f11658b, e.class, "com.obric.aiagent.plugin");
        Ctrd r19 = (Ctrd) ZeusTransformUtils.preCheckCast(r6.f11657a, Ctrd.class, "com.obric.aiagent.plugin");
        d.o.a(r7);     // Catch: Throwable -> L23
    L85:
        throw th;     // Catch: Throwable -> L23
    L25:
        i r20 = (i) ZeusTransformUtils.preCheckCast(r6.f11660d, i.class, "com.obric.aiagent.plugin");
        d r21 = (d) ZeusTransformUtils.preCheckCast(r6.f11659c, d.class, "com.obric.aiagent.plugin");
        e r22 = (e) ZeusTransformUtils.preCheckCast(r6.f11658b, e.class, "com.obric.aiagent.plugin");
        Ctrd r23 = (Ctrd) ZeusTransformUtils.preCheckCast(r6.f11657a, Ctrd.class, "com.obric.aiagent.plugin");
        d.o.a(r7);     // Catch: Throwable -> L28
    L54:
        if (r20 != null) goto L64;
        i r24 = new i(null, -1, "", "", null, "ctrd eval failed", 16, null);     // Catch: Throwable -> L28
        d.n.a r25 = d.n.f38560a;     // Catch: Throwable -> L61
        Ctrd r31 = (Ctrd) ZeusTransformUtils.preCheckCast(r23, Ctrd.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
        ParcelFileDescriptor r32 = r22.d();     // Catch: Throwable -> L61
        if (r32 == null) goto L59;
        r32.close();     // Catch: Throwable -> L61
        r14 = d.x.f38692a;     // Catch: Throwable -> L61
    L59:
        d.n.f(r14);     // Catch: Throwable -> L61
    L63:
        return r24;
    L61:
        th = move-exception;
        d.n.a r33 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L63
    L64:
        d.c.g r34 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        d.h.a.m r35 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new x(r21, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        r6.f11657a = r23;     // Catch: Throwable -> L28
        r6.f11658b = r22;     // Catch: Throwable -> L28
        r6.f11659c = r20;     // Catch: Throwable -> L28
        r6.f11660d = null;     // Catch: Throwable -> L28
        r6.g = 5;     // Catch: Throwable -> L28
        r7 = kotlinx.coroutines.i.a(r34, r35, r6);     // Catch: Throwable -> L28
        if (r7 != r8) goto L67;
        return r8;
    L67:
        r15 = r20;
        r3 = r22;
        r10 = r23;
        goto L68
    L30:
        r21 = (d) ZeusTransformUtils.preCheckCast(r6.f11659c, d.class, "com.obric.aiagent.plugin");
        r22 = (e) ZeusTransformUtils.preCheckCast(r6.f11658b, e.class, "com.obric.aiagent.plugin");
        r23 = (Ctrd) ZeusTransformUtils.preCheckCast(r6.f11657a, Ctrd.class, "com.obric.aiagent.plugin");
        d.o.a(r7);     // Catch: Throwable -> L33
    L49:
        r20 = (i) ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        if (r20 != null) goto L54;
        d.c.g r36 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        d.h.a.m r110 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new w(r21, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        r6.f11657a = r23;     // Catch: Throwable -> L28
        r6.f11658b = r22;     // Catch: Throwable -> L28
        r6.f11659c = r21;     // Catch: Throwable -> L28
        r6.f11660d = r20;     // Catch: Throwable -> L28
        r6.g = 3;     // Catch: Throwable -> L28
        if (kotlinx.coroutines.i.a(r36, r110, r6) != r8) goto L54;
        return r8;
    L33:
        th = th;
        e r37 = r22;
    L81:
        d.c.g r38 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L101
        d.h.a.m r39 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new w(r21, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L101
        r6.f11657a = r23;     // Catch: Throwable -> L101
        r6.f11658b = r37;     // Catch: Throwable -> L101
        r6.f11659c = th;     // Catch: Throwable -> L101
        r6.f11660d = null;     // Catch: Throwable -> L101
        r6.g = 4;     // Catch: Throwable -> L101
        if (kotlinx.coroutines.i.a(r38, r39, r6) != r8) goto L85;
        return r8;
    L35:
        r4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r6.f11660d, d.h.a.b.class, "com.obric.aiagent.plugin");
        List<String> r40 = (List) ZeusTransformUtils.preCheckCast(r6.f11659c, List.class, "com.obric.aiagent.plugin");
        String r41 = (String) ZeusTransformUtils.preCheckCast(r6.f11658b, String.class, "com.obric.aiagent.plugin");
        r23 = (Ctrd) ZeusTransformUtils.preCheckCast(r6.f11657a, Ctrd.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        List<String> r42 = r40;
    L40:
        r37 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        d r111 = r37.b();     // Catch: Throwable -> L101
        if (r37.i() == false) goto L86;
        if (r111 == null) goto L86;
        r6.f11657a = r23;     // Catch: Throwable -> L79
        r6.f11658b = r37;     // Catch: Throwable -> L79
        r6.f11659c = r111;     // Catch: Throwable -> L79
        r6.f11660d = null;     // Catch: Throwable -> L79
        r6.g = 2;     // Catch: Throwable -> L79
        Object r43 = r23.evalShell(r111, r41, r42, r4, r6);     // Catch: Throwable -> L79
        if (r43 != r8) goto L48;
        return r8;
    L48:
        r22 = r37;
        r21 = r111;
        r7 = r43;
    L79:
        th = th;
        r21 = r111;
    L86:
        CharSequence r44 = (CharSequence) ZeusTransformUtils.preCheckCast(r37.f(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L101
        if (r44.length() == 0) goto L90;
        r13 = false;
    L90:
        if (r13 == false) goto L92;
        r44 = "ctrd open failed";
    L92:
        i r45 = new i(null, -1, "", "", r37.e(), (String) ZeusTransformUtils.preCheckCast(r44, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L101
        d.n.a r46 = d.n.f38560a;     // Catch: Throwable -> L98
        Ctrd r47 = (Ctrd) ZeusTransformUtils.preCheckCast(r23, Ctrd.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L98
        ParcelFileDescriptor r48 = r37.d();     // Catch: Throwable -> L98
        if (r48 == null) goto L96;
        r48.close();     // Catch: Throwable -> L98
        r14 = d.x.f38692a;     // Catch: Throwable -> L98
    L96:
        d.n.f(r14);     // Catch: Throwable -> L98
    L100:
        return r45;
    L98:
        th = move-exception;
        d.n.a r49 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L101:
        th = move-exception;
        Throwable r50 = th;
        e r51 = r37;
    L123:
        d.n.a r52 = d.n.f38560a;     // Catch: Throwable -> L108
        ParcelFileDescriptor r53 = r51.d();     // Catch: Throwable -> L108
        if (r53 == null) goto L106;
        r53.close();     // Catch: Throwable -> L108
        r14 = d.x.f38692a;     // Catch: Throwable -> L108
    L106:
        d.n.f(r14);     // Catch: Throwable -> L108
        throw r50;
    L108:
        th = move-exception;
        d.n.a r54 = d.n.f38560a;
        d.n.f(d.o.a(th));
        throw r50;
    L36:
        d.o.a(r7);
        r6.f11657a = this;
        r6.f11658b = r26;
        r6.f11659c = r2;
        r6.f11660d = r4;
        r6.g = 1;
        Object r55 = open(r27, r6);
        if (r55 != r8) goto L39;
        return r8;
    L39:
        r23 = this;
        r41 = r26;
        r7 = r55;
        r42 = r2;
    L28:
        th = move-exception;
        r50 = th;
        r51 = r4;
    L23:
        th = move-exception;
        r50 = th;
        r51 = r2;
    L7:
        r6 = new v(this, r5);
        goto L8
    }

    public static /* synthetic */ Object evalShell$default(Ctrd r6, d r7, String r8, List r9, d.h.a.b r10, d.c.d r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super i> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        r14 = d.a.p.b();
    L5:
        List<String> r3 = r14;
        if ((r12 & 8) == 0) goto L9;
        r15 = null;
    L9:
        return r6.evalShell(r7, r8, r3, r15, r5);
    }

    public final Object evalShell(d r8, String r9, List<String> r10, d.h.a.b<? super d.h.a.b<? super d.c.d<? super i>, ? extends Object>, d.x> r11, d.c.d<? super i> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new u(r8, r9, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    public static /* synthetic */ Object startShell$default(Ctrd r6, d r7, String r8, List r9, n r10, d.c.d r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        n r15 = (n) ZeusTransformUtils.wrapperContextForParams(r10, n.class, "com.obric.aiagent.plugin");
        d.c.d<? super m> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        r14 = d.a.p.b();
    L5:
        List<String> r3 = r14;
        if ((r12 & 8) == 0) goto L9;
        r15 = null;
    L9:
        return r6.startShell(r7, r8, r3, r15, r5);
    }

    public final Object startShell(d r8, String r9, List<String> r10, n r11, d.c.d<? super m> r12) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r11, n.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new al(r8, r3, r9, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    public final Object waitShell(h r4, d.c.d<? super i> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ao(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object killShell(h r4, d.c.d<? super i> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ae(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object getWorkspaceStorageUsage(d r4, d.c.d<? super l> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object clearWorkspaceStorage(d r4, j r5, d.c.d<? super c> r6) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object migrateLegacyHomeData(d r4, d.c.d<? super c> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new af(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public static /* synthetic */ Object installGHotfix$default(Ctrd r1, String r2, String r3, Integer r4, d.c.d r5, int r6, Object r7) {
        d.c.d<? super c> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = new File(r2).getName();
        d.h.b.o.c(r3, "getName(...)");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.installGHotfix(r2, r3, r4, r8);
    }

    public final Object installGHotfix(String r3, String r4, Integer r5, d.c.d<? super c> r6) {
        d.c.d<? super c> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return installGHotfix(new File(r3), r4, r5, r7);
    }

    public static /* synthetic */ Object installGHotfix$default(Ctrd r1, File r2, String r3, Integer r4, d.c.d r5, int r6, Object r7) {
        d.c.d<? super c> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = r2.getName();
        d.h.b.o.c(r3, "getName(...)");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.installGHotfix(r2, r3, r4, r8);
    }

    public final Object installGHotfix(File r4, String r5, Integer r6, d.c.d<? super c> r7) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ad(r4, r6, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object uninstallGHotfix(String r4, d.c.d<? super c> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new an(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object getSharePaths(d r4, d.c.d<? super g> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ab(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public static /* synthetic */ Object queryLogs$default(Ctrd r1, int r2, d.c.d r3, int r4, Object r5) {
        d.c.d<? super a> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 10485760;
    L6:
        return r1.queryLogs(r2, r6);
    }

    public final Object queryLogs(int r4, d.c.d<? super a> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ah(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public static /* synthetic */ Object queryLogsStream$default(Ctrd r1, int r2, d.c.d r3, int r4, Object r5) {
        d.c.d<? super InputStream> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        return r1.queryLogsStream(r2, r6);
    }

    public final Object queryLogsStream(int r4, d.c.d<? super InputStream> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ai(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object clearLogs(d.c.d<? super c> r4) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object resetMyWorkspaces(d.c.d<? super c> r4) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ak(null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    private final CtrdShellOutputListener streamingListener(n r2) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return (CtrdShellOutputListener) ZeusTransformUtils.preCheckCast(new am(r1), CtrdShellOutputListener.class, "com.obric.aiagent.plugin");
    }

    private final m frameworkStreamingHandleToClient(CtrdShellStartResult r18, n r19) {
        CtrdShellStartResult r0 = (CtrdShellStartResult) ZeusTransformUtils.wrapperContextForParams(r18, CtrdShellStartResult.class, "com.obric.aiagent.plugin");
        n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r19, n.class, "com.obric.aiagent.plugin");
        CtrdShellHandle r2 = r0.handle;
        CompletableFuture r4 = r0.completion;
        boolean r5 = true;
        if (r0.isSuccessful() == false) goto L12;
        if (r2 == null) goto L12;
        if (r4 == null) goto L12;
        h r1 = frameworkShellHandleToClient(r2);
        if (r6 == null) goto L10;
        r6.a(r1);
    L10:
        kotlinx.coroutines.w r3 = kotlinx.coroutines.y.a(null, 1, null);
        kotlinx.coroutines.i.a(ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new y(r4, r3, r6, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return new m(r1, (au) ZeusTransformUtils.preCheckCast(r3, au.class, "com.obric.aiagent.plugin"));
    L12:
        h r9 = null;
        int r10 = -1;
        String r13 = null;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r0.error, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7.length() == 0) goto L16;
        r5 = false;
    L16:
        if (r5 == false) goto L18;
        r7 = "ctrd startShell failed";
    L18:
        d.h.b.o.c(r7, "ifEmpty(...)");
        String r11 = "";
        String r12 = "";
        i r8 = new i(r9, r10, r11, r12, r13, (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin"), 16, null);
        if (r6 == null) goto L22;
        r6.a(r8.e());
    L22:
        return new m(null, (au) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.y.a(r8), au.class, "com.obric.aiagent.plugin"));
    }

    private final e frameworkRuntimeOpenResultToClient(CtrdRuntimeOpenResult r10) {
        CtrdRuntimeOpenResult r9 = (CtrdRuntimeOpenResult) ZeusTransformUtils.wrapperContextForParams(r10, CtrdRuntimeOpenResult.class, "com.obric.aiagent.plugin");
        int r1 = r9.resultCode;
        CtrdRuntimeHandle r7 = r9.handle;
        if (r7 == null) goto L5;
        String r3 = r7.getId();
        d.h.b.o.c(r3, "getId(...)");
        int r4 = r9.resultCode;
        String r5 = r9.ctrdout;
        d.h.b.o.c(r5, "ctrdout");
        String r6 = r9.error;
        d.h.b.o.c(r6, WsConstants.KEY_CONNECTION_ERROR);
        d r2 = new d(r3, r4, r5, r6, r7);
    L6:
        int r8 = r9.gatewayState;
        ParcelFileDescriptor r11 = r9.proxyFd;
        String r12 = r9.ctrdout;
        d.h.b.o.c(r12, "ctrdout");
        String r13 = r9.error;
        d.h.b.o.c(r13, WsConstants.KEY_CONNECTION_ERROR);
        return new e(r1, r2, r8, r11, r12, r13);
    L5:
        r2 = null;
        goto L6
    }

    private final b frameworkGatewayResultToClient(CtrdGatewayResult r7) {
        CtrdGatewayResult r6 = (CtrdGatewayResult) ZeusTransformUtils.wrapperContextForParams(r7, CtrdGatewayResult.class, "com.obric.aiagent.plugin");
        int r1 = r6.resultCode;
        int r2 = r6.gatewayState;
        ParcelFileDescriptor r3 = r6.proxyFd;
        String r4 = r6.ctrdout;
        d.h.b.o.c(r4, "ctrdout");
        String r5 = r6.error;
        d.h.b.o.c(r5, WsConstants.KEY_CONNECTION_ERROR);
        return new b(r1, r2, r3, r4, r5);
    }

    private final f frameworkRuntimeStatusToClient(CtrdRuntimeStatus r23) {
        CtrdRuntimeStatus r0 = (CtrdRuntimeStatus) ZeusTransformUtils.wrapperContextForParams(r23, CtrdRuntimeStatus.class, "com.obric.aiagent.plugin");
        int r2 = r0.resultCode;
        boolean r3 = r0.exists;
        String r5 = r0.runtimeHandle;
        d.h.b.o.c(r5, "runtimeHandle");
        String r6 = r0.scenario;
        d.h.b.o.c(r6, "scenario");
        int r7 = r0.workspaceId;
        String r8 = r0.containerName;
        d.h.b.o.c(r8, "containerName");
        int r9 = r0.ownerUid;
        boolean r10 = r0.runtimeClosed;
        boolean r11 = r0.containerRunning;
        int r12 = r0.initPid;
        int r13 = r0.exitStatus;
        int r14 = r0.gatewayStartupMode;
        int r15 = r0.gatewayState;
        int r16 = r0.gatewayPid;
        String r1 = r0.gatewayLastError;
        d.h.b.o.c(r1, "gatewayLastError");
        int r4 = r0.activeClientCount;
        int r17 = r0.activeShellCount;
        String r18 = r0.ctrdout;
        d.h.b.o.c(r18, "ctrdout");
        String r19 = r0.error;
        d.h.b.o.c(r19, WsConstants.KEY_CONNECTION_ERROR);
        return new f(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r1, r4, r17, r18, r19);
    }

    private final h frameworkShellHandleToClient(CtrdShellHandle r3) {
        CtrdShellHandle r2 = (CtrdShellHandle) ZeusTransformUtils.wrapperContextForParams(r3, CtrdShellHandle.class, "com.obric.aiagent.plugin");
        String r0 = r2.getId();
        d.h.b.o.c(r0, "getId(...)");
        return new h(r0, r2);
    }

    private final CtrdShellHandle frameworkShellHandle(h r2) {
        Object r1 = r2.b();
        if (ZeusTransformUtils.instanceOf(r1, CtrdShellHandle.class) == true) goto L7;
        return null;
    L7:
        return (CtrdShellHandle) ZeusTransformUtils.preCheckCast(r1, CtrdShellHandle.class, "com.obric.aiagent.plugin");
    }

    private final i frameworkShellResultToClient(CtrdShellResult r8) {
        CtrdShellResult r7 = (CtrdShellResult) ZeusTransformUtils.wrapperContextForParams(r8, CtrdShellResult.class, "com.obric.aiagent.plugin");
        CtrdShellHandle r9 = r7.handle;
        if (r9 == null) goto L5;
        h r10 = INSTANCE.frameworkShellHandleToClient(r9);
    L6:
        int r2 = r7.exitCode;
        String r3 = r7.stdout;
        d.h.b.o.c(r3, "stdout");
        String r4 = r7.stderr;
        d.h.b.o.c(r4, "stderr");
        String r5 = r7.ctrdout;
        d.h.b.o.c(r5, "ctrdout");
        String r6 = r7.error;
        d.h.b.o.c(r6, WsConstants.KEY_CONNECTION_ERROR);
        return new i(r10, r2, r3, r4, r5, r6);
    L5:
        r10 = null;
        goto L6
    }

    private final c frameworkOperationResultToClient(CtrdOperationResult r4) {
        CtrdOperationResult r3 = (CtrdOperationResult) ZeusTransformUtils.wrapperContextForParams(r4, CtrdOperationResult.class, "com.obric.aiagent.plugin");
        int r0 = r3.resultCode;
        String r1 = r3.ctrdout;
        d.h.b.o.c(r1, "ctrdout");
        String r5 = r3.error;
        d.h.b.o.c(r5, WsConstants.KEY_CONNECTION_ERROR);
        return new c(r0, r1, r5);
    }

    private final g frameworkSharePathsResultToClient(CtrdSharePathsResult r5) {
        CtrdSharePathsResult r4 = (CtrdSharePathsResult) ZeusTransformUtils.wrapperContextForParams(r5, CtrdSharePathsResult.class, "com.obric.aiagent.plugin");
        String r0 = r4.hostPath;
        d.h.b.o.c(r0, "hostPath");
        String r1 = r4.containerPath;
        d.h.b.o.c(r1, "containerPath");
        String r2 = r4.error;
        d.h.b.o.c(r2, WsConstants.KEY_CONNECTION_ERROR);
        return new g(r0, r1, r2, r4.isSuccessful());
    }

    private final l frameworkStorageUsageResultToClient(CtrdStorageUsageResult r14) {
        CtrdStorageUsageResult r13 = (CtrdStorageUsageResult) ZeusTransformUtils.wrapperContextForParams(r14, CtrdStorageUsageResult.class, "com.obric.aiagent.plugin");
        CtrdStorageUsageResult.Entry[] r15 = r13.getEntries();
        d.h.b.o.c(r15, "getEntries(...)");
        Object[] r16 = (Object[]) ZeusTransformUtils.preCheckCast(r15, Object[].class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r16.length), Collection.class, "com.obric.aiagent.plugin");
        int r2 = r16.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        CtrdStorageUsageResult.Entry r4 = (CtrdStorageUsageResult.Entry) ZeusTransformUtils.preCheckCast(r16[r3], CtrdStorageUsageResult.Entry.class, "com.obric.aiagent.plugin");
        String r6 = r4.target;
        d.h.b.o.c(r6, "target");
        String r7 = r4.displayName;
        d.h.b.o.c(r7, "displayName");
        String r8 = r4.containerPath;
        d.h.b.o.c(r8, "containerPath");
        r1.add(new k(r6, r7, r8, r4.usedBytes, r4.clearable));
        r3 = r3 + 1;
        goto L3
    L5:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        String r0 = r13.error;
        d.h.b.o.c(r0, WsConstants.KEY_CONNECTION_ERROR);
        return new l(r17, r0, r13.isSuccessful());
    }

    private final String appendMessage(String r4, String r5) {
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        return r4;
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L15;
        return r5;
    L15:
        return r4 + '\n' + r5;
    L5:
        r3 = false;
        goto L6
    }

    private final ObricCtrdManager manager() {
        ObricCtrdManager r1 = ObricCtrdManager.getInstance();
        d.h.b.o.c(r1, "getInstance(...)");
        return r1;
    }

    private final m missingStreamingHandle(String r11, n r12) {
        n r10 = (n) ZeusTransformUtils.wrapperContextForParams(r12, n.class, "com.obric.aiagent.plugin");
        i r13 = new i(null, -1, "", "", null, r11, 16, null);
        if (r10 == null) goto L6;
        r10.a(r11);
    L6:
        return new m(null, (au) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.y.a(r13), au.class, "com.obric.aiagent.plugin"));
    }

    private final f missingRuntimeStatus(d r22, String r23) {
        return new f(-1, false, r22.a(), "", -1, "", -1, false, false, -1, -1, 1, 3, -1, "", 0, 0, "", r23);
    }

    private final String frameworkError(String r2, Throwable r3) {
        String r1 = r3.getMessage();
        if (r1 != null) goto L6;
        r1 = r3.getClass().getSimpleName();
    L6:
        return "ctrd " + r2 + " failed via ObricCtrdManager: " + r1;
    }

    private final String localGHotfixSourceError(String r2, String r3, Throwable r4) {
        String r1 = r4.getMessage();
        if (r1 != null) goto L6;
        r1 = r4.getClass().getSimpleName();
    L6:
        return "ghotfix source " + r2 + " failed: path=" + r3 + ", error=" + r1;
    }

    private final void closeQuietly(ParcelFileDescriptor r1) {
        r1.close();     // Catch: Exception -> L4
        return;
    }
}
