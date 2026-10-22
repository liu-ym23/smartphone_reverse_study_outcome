package com.obric.capabilitykit;

import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Process;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.logger.Logger;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f32190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IUriFileReceiver f32191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32192d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }
    }

    @d.c.b.a.f(b = "UriFileOpener.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$1")
    public static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f32194b;

        public b(q r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32194b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return new b(this.f32194b, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f32193a != 0) goto L15;
            d.o.a(r9);
            Logger.INSTANCE.e("UriFileOpener", "return failure to the receiver: " + this.f32194b.c() + " ---> URI " + this.f32194b.a());
            q r8 = this.f32194b;
            r8.b().onSessionReady(new UriFileAccessSession(4, "分享方未能开启 URI = " + r8.a(), null, 4, null));     // Catch: Throwable -> L7
            Object r10 = d.n.f(x.f38692a);     // Catch: Throwable -> L7
        L9:
            Throwable r11 = d.n.c(r10);
            if (r11 == null) goto L13;
            Logger.INSTANCE.e("UriFileOpener", "cannot notify failure to the receiver; e=" + r11, r11);
        L13:
            return x.f38692a;
        L7:
            th = move-exception;
            r10 = d.n.f(d.o.a(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d.c.b.a.f(b = "UriFileOpener.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$2")
    public static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f32196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f32197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f32198d;

        public c(AssetFileDescriptor r3, q r4, int r5, d.c.d<? super c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32196b = r3;
            this.f32197c = r4;
            this.f32198d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return new c(this.f32196b, this.f32197c, this.f32198d, r5);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f32195a != 0) goto L27;
            d.o.a(r8);
            Logger.INSTANCE.i("UriFileOpener", "returning & closing opened fd/" + this.f32196b.hashCode() + " to the receiver: " + this.f32197c.c() + " ---> URI " + this.f32197c.a());
            this.f32197c.b().onSessionReady(new UriFileAccessSession(0, "成功", this.f32196b));     // Catch: Throwable -> L7
            Object r9 = d.n.f(x.f38692a);     // Catch: Throwable -> L7
        L9:
            Throwable r10 = d.n.c(r9);
            if (r10 == null) goto L12;
            Logger.INSTANCE.e("UriFileOpener", "cannot notify opened fd to the receiver; e=" + r10, r10);
        L12:
            int r11 = this.f32198d;
            AssetFileDescriptor r0 = this.f32196b;
            q r2 = this.f32197c;
            int r3 = Process.myPid();     // Catch: Throwable -> L19
            if (r11 != r3) goto L16;
            Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L19
            String r12 = "not closing fd because the sharer/receiver are with the same PID (" + r11 + ").";     // Catch: Throwable -> L19
        L17:
            r1.d("UriFileOpener", r12);     // Catch: Throwable -> L19
            Object r13 = d.n.f(x.f38692a);     // Catch: Throwable -> L19
        L21:
            AssetFileDescriptor r7 = this.f32196b;
            Throwable r14 = d.n.c(r13);
            if (r14 == null) goto L25;
            Logger.INSTANCE.e("UriFileOpener", "cannot close opened fd/" + r7.hashCode() + "; e=" + r14, r14);
        L25:
            return x.f38692a;
        L16:
            r0.close();     // Catch: Throwable -> L19
            Logger r4 = Logger.INSTANCE;     // Catch: Throwable -> L19
            r12 = "sharer closed the shared fd/" + r0.hashCode() + " for URI: " + r2.a() + "; rcvPid=" + r11 + "; myPid=" + r3 + '.';     // Catch: Throwable -> L19
            r1 = r4;
        L19:
            th = move-exception;
            r13 = d.n.f(d.o.a(th));
        L7:
            th = move-exception;
            r9 = d.n.f(d.o.a(th));
            goto L9
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f32189a = new a(null);
    }

    public q(Uri r3, IUriFileReceiver r4, String r5) {
        IUriFileReceiver r6 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r4, IUriFileReceiver.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "uriToOpen");
        d.h.b.o.e(r6, "forReceiver");
        d.h.b.o.e(r5, "receiverPackage");
        this.f32190b = r3;
        this.f32191c = r6;
        this.f32192d = r5;
    }

    public final Uri a() {
        return this.f32190b;
    }

    public final void a(int r10) {
        AssetFileDescriptor r1 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver().openAssetFileDescriptor(this.f32190b, DownloadFileUtils.MODE_READ);     // Catch: Exception -> L5
    L7:
        if (r1 != null) goto L9;
        Logger.INSTANCE.w("UriFileOpener", "openFd = null; UriFileOpener: " + this.f32192d + " ---> URI " + this.f32190b);
        am r3 = ActionDispatcher.INSTANCE.getScope();
        d.h.a.m r6 = new b(this, null);
    L10:
        kotlinx.coroutines.i.a(r3, null, null, r6, 3, null);
        return;
    L9:
        r3 = ActionDispatcher.INSTANCE.getScope();
        r6 = new c(r1, this, r10, null);
    L5:
        e = move-exception;
        Logger.INSTANCE.e("UriFileOpener", "failed to open URI " + this.f32190b + " (for " + this.f32192d + "); e=" + e, e);
        r1 = null;
        goto L7
    }

    public final IUriFileReceiver b() {
        return this.f32191c;
    }

    public final String c() {
        return this.f32192d;
    }
}
