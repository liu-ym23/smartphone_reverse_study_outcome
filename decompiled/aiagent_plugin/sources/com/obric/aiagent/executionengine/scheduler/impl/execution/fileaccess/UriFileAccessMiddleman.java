package com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess;

import android.app.Application;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Binder;
import com.obric.aiagent.executionengine.scheduler.api.IUriFileAccessApi;
import com.obric.aiagent.executionengine.scheduler.impl.execution.b.c;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: UriFileAccessMiddleman.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriFileAccessMiddleman implements IUriFileAccessApi {
    private final am mWorker;
    private final String sTag;

    /* JADX INFO: compiled from: UriFileAccessMiddleman.kt */
    @f(b = "UriFileAccessMiddleman.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.UriFileAccessMiddleman$requestCloseFile$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Uri f18407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f18408d;

        a(String r3, Uri r4, String r5, d<? super a> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f18406b = r3;
            this.f18407c = r4;
            this.f18408d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f18406b, this.f18407c, this.f18408d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f18405a != 0) goto L7;
            o.a(r4);
            c.f18403a.b(new com.obric.aiagent.executionengine.scheduler.impl.execution.b.a(this.f18406b, this.f18407c, this.f18408d));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: UriFileAccessMiddleman.kt */
    @f(b = "UriFileAccessMiddleman.kt", c = {91}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.UriFileAccessMiddleman$requestOpenFile$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ UriFileAccessMiddleman f18410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f18411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f18412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f18413e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ IUriFileReceiver h;

        b(UriFileAccessMiddleman r3, String r4, Uri r5, int r6, String r7, String r8, IUriFileReceiver r9, d<? super b> r10) {
            IUriFileReceiver r11 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r9, IUriFileReceiver.class, "com.obric.aiagent.plugin");
            d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
            this.f18410b = r3;
            this.f18411c = r4;
            this.f18412d = r5;
            this.f18413e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r11;
            super(2, r12);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r11, d<?> r12) {
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f18410b, this.f18411c, this.f18412d, this.f18413e, this.f, this.g, this.h, r9), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18409a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L16;
            ILogDepend.Companion.e(UriFileAccessMiddleman.access$getSTag$p(this.f18410b), "requestOpenFile: requestToken=" + this.f18411c + " failed to establish");
            return x.f38692a;
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            ILogDepend.Companion.i(UriFileAccessMiddleman.access$getSTag$p(this.f18410b), "requestOpenFile: start establish; requestToken=" + this.f18411c);
            com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a r13 = new com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a(this.f18412d, this.f18413e, this.f, this.g, this.h);
            d<? super Boolean> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f18409a = 1;
            r12 = r13.a(r2);
            if (r12 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$hExeQxk2avuw6oTh-wd-LJfzobE, reason: not valid java name */
    public static /* synthetic */ Thread m186lambda$hExeQxk2avuw6oThwdLJfzobE(Runnable r0) {
        return mWorker$lambda$0(r0);
    }

    public UriFileAccessMiddleman() {
        this.sTag = "UFAMiddleman";
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$UriFileAccessMiddleman$hExeQxk2avuw6oThwdLJfzobE.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        this.mWorker = an.a((g) ZeusTransformUtils.preCheckCast(br.a(r0), g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String access$getSTag$p(UriFileAccessMiddleman r0) {
        return r0.sTag;
    }

    private static final Thread mWorker$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "UriFileAccessMiddleman-worker");
    }

    private final String getRequesterPackage() {
        String r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getNameForUid(Binder.getCallingUid());
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    private final String getRequestToken(Uri r2, String r3) {
        return Binder.getCallingUid() + ':' + r3 + '/' + r2;
    }

    static /* synthetic */ UriFileAccessSession generateFailedSession$default(UriFileAccessMiddleman r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        return r0.generateFailedSession(r1, r2);
    }

    private final UriFileAccessSession generateFailedSession(int r2, String r3) {
        return new UriFileAccessSession(r2, r3, null);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IUriFileAccessApi
    public boolean requestOpenFile(IUriFileReceiver r18, Uri r19, String r20, int r21) {
        IUriFileReceiver r7 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r18, IUriFileReceiver.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(this.sTag, "requestOpenFile: argument: r=" + r7 + ", u=" + r19 + ", p=" + r20);
        if (r7 == null) goto L20;
        if (r19 == null) goto L20;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L20;
        if (checkOpenFilePermission(r19, r20) == true) goto L18;
        ILogDepend.Companion.e(this.sTag, "requestOpenFile: uri=(" + r19 + ") permission: not allowed");
        return false;
    L18:
        String r5 = getRequesterPackage();
        i.a(this.mWorker, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, getRequestToken(r19, r20), r19, r21, r5, r20, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return true;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
    L20:
        ILogDepend.Companion.e(this.sTag, "requestOpenFile: invalid argument");
        return false;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IUriFileAccessApi
    public void requestCloseFile(Uri r9, String r10) {
        ILogDepend.Companion.d(this.sTag, "requestCloseFile: argument: u=" + r9 + ", p=" + r10);
        if (r9 == null) goto L15;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L15;
        i.a(this.mWorker, null, null, (m) ZeusTransformUtils.preCheckCast(new a(r10, r9, getRequesterPackage(), null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
    L15:
        ILogDepend.Companion.e(this.sTag, "requestCloseFile: invalid argument");
    }

    private final boolean checkOpenFilePermission(Uri r7, String r8) {
        PackageManager r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
        int r2 = Binder.getCallingUid();
        int r3 = Binder.getCallingPid();
        String r4 = "";
        if (10000 > r2) goto L12;
        if (r2 > 19999) goto L12;
        String r1 = r0.getNameForUid(r2);
        if (r1 == null) goto L10;
        r4 = r1;
    L10:
        com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a.d r5 = new com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a.d(r4, r2, r3);
        String r6 = "normal";
    L14:
        boolean r9 = com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a.b.f18414a.a(r5, r8, r7);
        ILogDepend.Companion.d(this.sTag, "checkOpenFilePermission: type=" + r6 + ", permitted=" + r9 + ", r=" + r5 + ", s=" + r8 + ", u=" + r7);
        return r9;
    L12:
        if (r0.checkSignatures(1000, r2) != 0) goto L16;
        r5 = new com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a.d("", r2, r3);
        r6 = "system";
        goto L14
    L16:
        String r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getNameForUid(r2);
        if (r10 == null) goto L20;
        r4 = r10;
    L20:
        ILogDepend.Companion.e(this.sTag, "checkOpenFilePermission: the URI requester (uid=" + r2 + ", pid=" + r3 + ", name=" + r4 + ") is not an app, nor the system; this case is currently not supported by the Intent framework. The request to (uri: " + r7 + ") is blocked.");
        return false;
    }
}
