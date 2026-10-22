package com.obric.aiagent.executionengine.scheduler.impl;

import android.app.Application;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.executionengine.scheduler.impl.a.d;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.BuildConfig;
import com.obric.capabilitykit.ActionDispatcher;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.ICapabilityActionHandler;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.b.ae;
import d.h.b.o;
import d.m;
import d.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "CapabilityActionDispatcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f17968b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f17969c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ServiceConnection> f17970d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<m<String, String>, b> f17971e = null;
    private static final ConcurrentHashMap<String, IBinder.DeathRecipient> f = null;
    private static final ConcurrentHashMap<String, ArrayList<IntentCalling>> g = null;
    private static final ConcurrentHashMap<String, HashMap<String, IntentCalling>> h = null;
    private static final kotlinx.coroutines.f.a i = null;
    private static final Handler j = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    private static final class C0369a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0369a f17972a = null;

        static {
            f17972a = new C0369a();
        }

        private C0369a() {
        }

        public final String a(String r8, String r9) {
            o.e(r8, "key");
            o.e(r9, "defaultValue");
            Class r0 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Exception -> L5 Throwable -> L8
            Object r10 = r0.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r0, new Object[]{r8, r9});     // Catch: Exception -> L5 Throwable -> L8
            o.a(r10, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L5 Throwable -> L8
            return (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        L5:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L8
        L7:
            return r9;
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ICapabilityActionHandler f17973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f17974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f17975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f17976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f17977e;
        private final d.h.a.b<d.c.d<? super ICapabilityActionHandler>, Object> f;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
        @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {108}, d = "callTheImplementer", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher$ProxyWrapper")
        static final class C0370a<T> extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f17978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f17979b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f17980c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f17981d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f17982e;

            C0370a(b r3, d.c.d<? super C0370a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f17981d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f17980c = r3;
                this.f17982e |= Integer.MIN_VALUE;
                return this.f17981d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
        @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {109}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher$ProxyWrapper$callTheImplementer$rebindResult$1")
        static final class C0371b extends l implements d.h.a.m<am, d.c.d<? super ICapabilityActionHandler>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f17983a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f17984b;

            C0371b(b r3, d.c.d<? super C0371b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f17984b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super ICapabilityActionHandler> r4) {
                return ((C0371b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0371b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0371b(this.f17984b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super ICapabilityActionHandler> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f17983a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r4);
                d.h.a.b<d.c.d<? super ICapabilityActionHandler>, Object> r5 = this.f17984b.d();
                this.f17983a = 1;
                r4 = r5.invoke(this);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        public b(ICapabilityActionHandler r3, String r4, String r5, boolean r6, long r7, d.h.a.b<? super d.c.d<? super ICapabilityActionHandler>, ? extends Object> r9) {
            ICapabilityActionHandler r8 = (ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");
            d.h.a.b<d.c.d<? super ICapabilityActionHandler>, Object> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r8, "api");
            this.f17973a = r8;
            this.f17974b = r4;
            this.f17975c = r5;
            this.f17976d = r6;
            this.f17977e = r7;
            this.f = r10;
        }

        public final ICapabilityActionHandler a() {
            return this.f17973a;
        }

        public final String b() {
            return this.f17974b;
        }

        public final String c() {
            return this.f17975c;
        }

        public final d.h.a.b<d.c.d<? super ICapabilityActionHandler>, Object> d() {
            return this.f;
        }

        public final <T> Object a(d.h.a.b<? super ICapabilityActionHandler, ? extends T> r12, d.c.d<? super T> r13) {
            d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r15, C0370a.class) == false) goto L7;
            C0370a r2 = (C0370a) ZeusTransformUtils.preCheckCast(r15, C0370a.class, "com.obric.aiagent.plugin");
            if ((r2.f17982e & Integer.MIN_VALUE) == 0) goto L7;
            r2.f17982e -= Integer.MIN_VALUE;
        L8:
            Object r16 = r2.f17980c;
            Object r4 = d.c.a.b.a();
            int r5 = r2.f17982e;
            if (r5 == 0) goto L14;
            if (r5 != 1) goto L13;
            r14 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r2.f17979b, d.h.a.b.class, "com.obric.aiagent.plugin");
            b this = (b) ZeusTransformUtils.preCheckCast(r2.f17978a, b.class, "com.obric.aiagent.plugin");
            d.o.a(r16);
        L37:
            ICapabilityActionHandler r17 = (ICapabilityActionHandler) ZeusTransformUtils.preCheckCast(r16, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");
            if (r17 != null) goto L40;
            return null;
        L40:
            this.f17973a = r17;
            return r14.invoke(r17);
        L43:
            th = move-exception;
            ILogDepend.Companion.e(a.TAG, "callTheImplementer " + this.f17974b + " failed; e=" + th);
            return null;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r16);
            return r14.invoke(this.f17973a);
        L28:
            ILogDepend.Companion.w(a.TAG, "callTheImplementer " + this.f17974b + " failed; rebind=" + this.f17976d);
            if (this.f17976d == true) goto L31;
            return null;
        L31:
            ILogDepend.Companion.i(a.TAG, "callTheImplementer " + this.f17974b + " need re-establish a binder");
            if (this.f != null) goto L34;
            return null;
        L34:
            long r0 = this.f17977e;
            d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0371b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            r2.f17978a = this;
            r2.f17979b = r14;
            r2.f17982e = 1;
            r16 = dg.b(r0, r18, r2);
            if (r16 != r4) goto L37;
            return r4;
        L20:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e.getCause(), DeadObjectException.class) == false) goto L26;
            ILogDepend.Companion.w(a.TAG, "callTheImplementer " + this.f17974b + " failed; rebind=" + this.f17976d);
            if (this.f17976d == true) goto L31;
            return null;
        L26:
            ILogDepend.Companion.e(a.TAG, "callTheImplementer " + this.f17974b + " failed; not handleable exception, e=" + e);
            return null;
        L17:
            th = move-exception;
            ILogDepend.Companion.e(a.TAG, "callTheImplementer " + this.f17974b + " failed; not handleable exception, e=" + th);
            return null;
        L7:
            r2 = new C0370a(this, r15);
            goto L8
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {310, 311}, d = "dispatchAction", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f17988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f17989e;
        int f;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17989e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17988d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f17989e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {367, 368}, d = "dispatchIntent", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f17993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f17994e;
        int f;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17994e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17993d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f17994e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {393, 409}, d = "dispatchUriFileAccessRequest", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f17997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17998d;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17997c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17996b = r3;
            this.f17998d |= Integer.MIN_VALUE;
            return this.f17997c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {453}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher$getBinder$2")
    static final class f extends l implements d.h.a.m<am, d.c.d<? super ICapabilityActionHandler>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f18001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f18002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f18003e;

        f(String r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18002d = r3;
            this.f18003e = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ICapabilityActionHandler> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f18002d, this.f18003e, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ICapabilityActionHandler> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18001c;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f18000b, String.class, "com.obric.aiagent.plugin");
            String r13 = (String) ZeusTransformUtils.preCheckCast(this.f17999a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r14);
        L58:
            return r14;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r14);
            String r15 = this.f18002d;
            final String r4 = this.f18003e;
            this.f17999a = r15;
            this.f18000b = r4;
            this.f18001c = 1;
            kotlinx.coroutines.o r5 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r5.e();
            final n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
            ServiceConnection r7 = new CapabilityActionDispatcher$getBinder$2$1$connection$1(r6, r4);
            PackageManager r8 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
            Intent r9 = new Intent("com.obric.capabilitykit.CapabilityHandleService");
            r9.setPackage(r4);
            List<ResolveInfo> r10 = r8.queryIntentServices(r9, 0);
            o.c(r10, "queryIntentServices(...)");
            if (r15 == null) goto L19;
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L12:
            if (r11.hasNext() == false) goto L16;
            Object r12 = r11.next();
            if (o.a(((ResolveInfo) ZeusTransformUtils.preCheckCast(r12, ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo.name, r15) == false) goto L12;
        L17:
            ResolveInfo r16 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r12, ResolveInfo.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L19;
        L20:
            if (r16 == null) goto L24;
            ServiceInfo r17 = r16.serviceInfo;
            if (r17 == null) goto L24;
            String r18 = r17.name;
        L26:
            if (r18 != null) goto L28;
            ILogDepend.Companion.e(a.TAG, "Failed to find CapabilityHandleService from package " + r4);
            d.c.d r19 = (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r20 = d.n.f38560a;
            r19.resumeWith(d.n.f(null));
        L53:
            r14 = r5.h();
            if (r14 != d.c.a.b.a()) goto L56;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L56:
            if (r14 != r0) goto L58;
            return r0;
        L28:
            Intent r110 = new Intent();
            r110.setPackage(r4);
            r110.setClassName(r4, r18);
            d.n.a r111 = d.n.f38560a;     // Catch: Throwable -> L41
            if (ZeusTransformUtils.bindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r110, (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.aiagent.plugin"), 1, "com.obric.aiagent.plugin") == true) goto L39;
            a.b().remove(r4);     // Catch: Throwable -> L41
            ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
            boolean r112 = r6.a();     // Catch: Throwable -> L41
            if (r112 == false) goto L34;
            d.c.d r21 = (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
            d.n.a r113 = d.n.f38560a;     // Catch: Throwable -> L41
            r21.resumeWith(d.n.f(null));     // Catch: Throwable -> L41
        L34:
            ILogDepend.Companion r22 = ILogDepend.Companion;     // Catch: Throwable -> L41
            StringBuilder r23 = new StringBuilder().append("bindService fail. coroutineActive: ");     // Catch: Throwable -> L41
            if (r112 == true) goto L38;
            r2 = false;
        L38:
            r22.e(a.TAG, r23.append(r2).toString());     // Catch: Throwable -> L41
        L39:
            Object r114 = d.n.f(x.f38692a);     // Catch: Throwable -> L41
        L43:
            Throwable r115 = d.n.c(r114);
            if (r115 == null) goto L53;
            ILogDepend.Companion.e(a.TAG, "bindService throw exception: " + d.a.a(r115));
            r115.printStackTrace();
            a.b().remove(r4);
            d.n.a r116 = d.n.f38560a;     // Catch: Throwable -> L48
            ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
            Object r117 = d.n.f(x.f38692a);     // Catch: Throwable -> L48
        L50:
            Throwable r118 = d.n.c(r117);
            if (r118 == null) goto L53;
            ILogDepend.Companion.e(a.TAG, "unbindService throw exception: " + d.a.a(r118));
        L48:
            th = move-exception;
            d.n.a r24 = d.n.f38560a;
            r117 = d.n.f(d.o.a(th));
        L41:
            th = move-exception;
            d.n.a r25 = d.n.f38560a;
            r114 = d.n.f(d.o.a(th));
        L24:
            r18 = null;
            goto L26
        L16:
            r12 = null;
        L19:
            r16 = (ResolveInfo) ZeusTransformUtils.preCheckCast(p.l(r10), ResolveInfo.class, "com.obric.aiagent.plugin");
            goto L20
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {457, 160, 172}, d = "getBinderAndStore", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f18008e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {182}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher$getBinderAndStore$2$wrapper$1")
    static final class h extends l implements d.h.a.b<d.c.d<? super ICapabilityActionHandler>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f18011c;

        h(String r3, String r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18010b = r3;
            this.f18011c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super ICapabilityActionHandler> r3) {
            return ((h) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f18010b, this.f18011c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super ICapabilityActionHandler> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18009a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            ILogDepend.Companion.i(a.TAG, "retrying to getBinder " + this.f18010b + "; rebind timeout=" + a.a());
            a.a(a.f17967a, this.f18010b, this.f18011c);
            a r8 = a.f17967a;
            String r2 = this.f18010b;
            String r3 = this.f18011c;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18009a = 1;
            r7 = a.a(r8, r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {457}, d = "onReceiveIntentResult", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18015d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18016e;
        final /* synthetic */ a f;
        int g;

        i(a r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18016e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {457}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher$onUpdateIntentResult$1")
    static final class j extends l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ IntentResult<?> f18021e;
        final /* synthetic */ String f;

        j(IntentResult<?> r3, String r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18021e = r3;
            this.f = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f18021e, this.f, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18020d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) ZeusTransformUtils.preCheckCast(this.f18019c, String.class, "com.obric.aiagent.plugin");
            IntentResult<?> r3 = (IntentResult) ZeusTransformUtils.preCheckCast(this.f18018b, IntentResult.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r8 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f18017a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
        L24:
        L21:
            th = move-exception;
            r8.b(null);
            throw th;
        L13:
            if (r3.isFinal() == false) goto L18;
            Iterator r10 = ((Map) ZeusTransformUtils.preCheckCast(a.d(), Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L21
        L16:
            if (r10.hasNext() == false) goto L18;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            ae.j((Map) ZeusTransformUtils.preCheckCast(r4.getValue(), Map.class, "com.obric.aiagent.plugin")).remove(r2);     // Catch: Throwable -> L21
            ILogDepend.Companion.i(a.TAG, "onUpdateIntentResult remove intent: " + ((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")) + ' ' + r2 + ' ' + a.d());     // Catch: Throwable -> L21
        L18:
            x r11 = x.f38692a;     // Catch: Throwable -> L21
            r8.b(null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            kotlinx.coroutines.f.a r12 = a.c();
            r3 = this.f18021e;
            String r5 = this.f;
            d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18017a = r12;
            this.f18018b = r3;
            this.f18019c = r5;
            this.f18020d = 1;
            if (r12.a(null, r6) != r0) goto L11;
            return r0;
        L11:
            r8 = r12;
            r2 = r5;
            goto L24
        }
    }

    /* JADX INFO: compiled from: CapabilityActionDispatcher.kt */
    @d.c.b.a.f(b = "CapabilityActionDispatcher.kt", c = {457}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.CapabilityActionDispatcher$timeoutHandler$1$1$1")
    static final class k extends l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f18026e;
        final /* synthetic */ Message f;
        private /* synthetic */ Object g;

        k(String r3, Message r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18026e = r3;
            this.f = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f18026e, this.f, r6);
            r0.g = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18025d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(this.f18024c, Message.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f18023b, String.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r4 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f18022a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            am r8 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
        L49:
            ILogDepend.Companion.i(a.TAG, "binder timeout: " + r3);     // Catch: Throwable -> L44
            ServiceConnection r10 = (ServiceConnection) ZeusTransformUtils.preCheckCast(a.b().remove(r3), ServiceConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
            ConcurrentHashMap r11 = a.e();     // Catch: Throwable -> L44
            Object r5 = r2.obj;     // Catch: Throwable -> L44
            if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L15;
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        L16:
            if (r6 == null) goto L18;
            String r7 = r6.c();     // Catch: Throwable -> L44
        L19:
            b r12 = (b) ZeusTransformUtils.preCheckCast(r11.remove(new m(r3, r7)), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
            IBinder.DeathRecipient r13 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(a.f().remove(r3), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
            a.g().remove(r3);     // Catch: Throwable -> L44
            a.d().remove(r3);     // Catch: Throwable -> L44
            d.n.a r14 = d.n.f38560a;     // Catch: Throwable -> L26
            if (r10 == null) goto L23;
            ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r10, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
            x r15 = x.f38692a;     // Catch: Throwable -> L26
        L24:
            d.n.f(r15);     // Catch: Throwable -> L26
        L47:
            d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L39
            if (r13 == null) goto L36;
            if (r12 == null) goto L36;
            ICapabilityActionHandler r17 = r12.a();     // Catch: Throwable -> L39
            if (r17 == null) goto L36;
            IBinder r18 = r17.asBinder();     // Catch: Throwable -> L39
            if (r18 == null) goto L36;
            Boolean r19 = d.c.b.a.b.a(r18.unlinkToDeath(r13, 0));     // Catch: Throwable -> L39
        L37:
            d.n.f(r19);     // Catch: Throwable -> L39
        L41:
            x r20 = x.f38692a;     // Catch: Throwable -> L44
            r4.b(null);
            return x.f38692a;
        L36:
            r19 = null;
        L39:
            th = move-exception;
            d.n.a r21 = d.n.f38560a;     // Catch: Throwable -> L44
            d.n.f(d.o.a(th));     // Catch: Throwable -> L44
            goto L41
        L23:
            r15 = null;
        L26:
            th = move-exception;
            d.n.a r22 = d.n.f38560a;     // Catch: Throwable -> L44
            d.n.f(d.o.a(th));     // Catch: Throwable -> L44
            goto L47
        L18:
            r7 = null;
            goto L19
        L15:
            r6 = null;
        L44:
            th = move-exception;
            r4.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            am r23 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r24 = a.c();
            String r25 = this.f18026e;
            Message r26 = this.f;
            d.c.d<? super x> r27 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r23;
            this.f18022a = r24;
            this.f18023b = r25;
            this.f18024c = r26;
            this.f18025d = 1;
            if (r24.a(null, r27) != r0) goto L11;
            return r0;
        L11:
            r4 = r24;
            r3 = r25;
            r2 = r26;
            goto L49
        }
    }

    /* JADX INFO: renamed from: lambda$8pz2fMVbKIjSFzCTJ9P-XkqZreY, reason: not valid java name */
    public static /* synthetic */ boolean m179lambda$8pz2fMVbKIjSFzCTJ9PXkqZreY(Message r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$RJjEo5bfDqxOKimVjZ9LYbaNFwQ(IntentCalling r0, ICapabilityActionHandler r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$SnncTdiGDsv9bm0ulTnkFqK_F-Q, reason: not valid java name */
    public static /* synthetic */ boolean m180lambda$SnncTdiGDsv9bm0ulTnkFqK_FQ(com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a r0, String r1, ICapabilityActionHandler r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$nW93r3TZ0E4_tcUyUEdoa-NUqfA, reason: not valid java name */
    public static /* synthetic */ boolean m181lambda$nW93r3TZ0E4_tcUyUEdoaNUqfA(IMAppAction r0, ICapabilityActionHandler r1) {
        return a(r0, r1);
    }

    private a() {
    }

    public static final /* synthetic */ long a() {
        return f17969c;
    }

    public static final /* synthetic */ Object a(a r2, String r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return f17970d;
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a c() {
        return i;
    }

    public static final /* synthetic */ ConcurrentHashMap d() {
        return h;
    }

    public static final /* synthetic */ ConcurrentHashMap e() {
        return f17971e;
    }

    public static final /* synthetic */ ConcurrentHashMap f() {
        return f;
    }

    public static final /* synthetic */ ConcurrentHashMap g() {
        return g;
    }

    public static final /* synthetic */ Handler h() {
        return j;
    }

    static {
        f17967a = new a();
        f17968b = Long.parseLong(C0369a.f17972a.a("debug.capability.binder.timeout", "30")) * 1000;
        f17969c = Long.parseLong(C0369a.f17972a.a("debug.capability.binder.rebind.timeout", "10")) * 1000;
        f17970d = new ConcurrentHashMap();
        f17971e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
        i = kotlinx.coroutines.f.c.a(false, 1, null);
        j = new Handler(Looper.getMainLooper(), $$Lambda$a$8pz2fMVbKIjSFzCTJ9PXkqZreY.INSTANCE);
    }

    private static final boolean a(Message r10) {
        o.e(r10, "it");
        Object r0 = r10.obj;
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L5;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L12;
        String r2 = r1.b();
        if (r2 == null) goto L13;
        kotlinx.coroutines.i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.d(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r2, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return true;
    L13:
        return true;
    L12:
        return true;
    L5:
        r1 = null;
        goto L6
    }

    private final void a(String r9, String r10) {
        b r11 = (b) ZeusTransformUtils.preCheckCast(f17971e.remove(new m(r9, r10)), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        IBinder.DeathRecipient r2 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(f.remove(r9), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        g.remove(r9);     // Catch: Throwable -> L25
        h.remove(r9);     // Catch: Throwable -> L25
        ServiceConnection r3 = (ServiceConnection) ZeusTransformUtils.preCheckCast(f17970d.remove(r9), ServiceConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r11 == null) goto L33;
        j.removeMessages(0, r11);     // Catch: Throwable -> L25
        Boolean r4 = null;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L13
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r3, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        x r5 = x.f38692a;     // Catch: Throwable -> L13
    L11:
        d.n.f(r5);     // Catch: Throwable -> L13
    L29:
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L22
        a r12 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r2 == null) goto L20;
        IBinder r13 = r11.a().asBinder();     // Catch: Throwable -> L22
        if (r13 == null) goto L20;
        r4 = Boolean.valueOf(r13.unlinkToDeath(r2, 0));     // Catch: Throwable -> L22
    L20:
        d.n.f(r4);     // Catch: Throwable -> L22
    L34:
        return;
    L22:
        th = move-exception;
        d.n.a r14 = d.n.f38560a;     // Catch: Throwable -> L25
        d.n.f(d.o.a(th));     // Catch: Throwable -> L25
        return;
    L10:
        r5 = null;
    L13:
        th = move-exception;
        d.n.a r15 = d.n.f38560a;     // Catch: Throwable -> L25
        d.n.f(d.o.a(th));     // Catch: Throwable -> L25
        goto L29
    L33:
        return;
    L25:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "unbind " + r9 + " failed; e=", th);
    }

    public static /* synthetic */ Object a(a r1, String r2, IntentCalling r3, d.c.d r4, int r5, Object r6) {
        d.c.d<? super b> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return r1.a(r2, r3, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    public final Object a(String r23, IntentCalling r24, d.c.d<? super b> r25) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L7;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin");
        if ((r3.i & Integer.MIN_VALUE) == 0) goto L7;
        r3.i -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.g;
        Object r4 = d.c.a.b.a();
        int r5 = r3.i;
        ?? r8 = 2;
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L17;
        long r6 = r3.f;
        m r0 = (m) ZeusTransformUtils.preCheckCast(r3.f18008e, m.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.f18007d, String.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r9 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r3.f18006c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        IntentCalling r12 = (IntentCalling) ZeusTransformUtils.preCheckCast(r3.f18005b, IntentCalling.class, "com.obric.aiagent.plugin");
        final String r10 = (String) ZeusTransformUtils.preCheckCast(r3.f18004a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L21
        String r15 = r7;
        IntentCalling r11 = r12;
        final m r13 = r0;
        kotlinx.coroutines.f.a r14 = r9;
        long r16 = r6;
    L114:
        ICapabilityActionHandler r17 = (ICapabilityActionHandler) ZeusTransformUtils.preCheckCast(r2, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
        if (r17 != null) goto L79;
        r14.b(null);
        return null;
    L79:
        com.obric.aiagent.executionengine.scheduler.impl.d.b.a r18 = com.obric.aiagent.executionengine.scheduler.impl.d.b.f18388a;     // Catch: Throwable -> L108
        d.n.a r19 = d.n.f38560a;     // Catch: Throwable -> L85
        Object r20 = Proxy.newProxyInstance(ICapabilityActionHandler.class.getClassLoader(), new Class[]{ICapabilityActionHandler.class}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.executionengine.scheduler.impl.d.b((IInterface) ZeusTransformUtils.preCheckCast(r17, IInterface.class, "com.obric.aiagent.plugin"), TAG, ICapabilityActionHandler.class), InvocationHandler.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L85
        if (r20 == null) goto L84;
        IInterface r21 = (IInterface) ZeusTransformUtils.preCheckCast((ICapabilityActionHandler) ZeusTransformUtils.preCheckCast(r20, ICapabilityActionHandler.class, "com.obric.aiagent.plugin"), IInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L85
    L90:
        final b r22 = new b((ICapabilityActionHandler) ZeusTransformUtils.preCheckCast(r21, ICapabilityActionHandler.class, "com.obric.aiagent.plugin"), r10, r15, true, f17969c, (d.h.a.b) ZeusTransformUtils.preCheckCast(new h(r10, r15, null), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L108
        ((Map) ZeusTransformUtils.preCheckCast(f17971e, Map.class, "com.obric.aiagent.plugin")).put(r13, r22);     // Catch: Throwable -> L108
        IBinder.DeathRecipient r26 = new CapabilityActionDispatcher$getBinderAndStore$2$recipient$1(r10, r22, r13);     // Catch: Throwable -> L108
        ((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.aiagent.plugin")).put(r10, r26);     // Catch: Throwable -> L108
        if (r11 == null) goto L115;
        ConcurrentMap r110 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(g, ConcurrentMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
        Object r111 = r110.get(r10);     // Catch: Throwable -> L108
        if (r111 != null) goto L98;
        r111 = new ArrayList();     // Catch: Throwable -> L108
        Object r112 = r110.putIfAbsent(r10, r111);     // Catch: Throwable -> L108
        if (r112 == null) goto L98;
        r111 = r112;
    L98:
        d.c.b.a.b.a(((ArrayList) ZeusTransformUtils.preCheckCast(r111, ArrayList.class, "com.obric.aiagent.plugin")).add(r11));     // Catch: Throwable -> L108
    L115:
        IBinder r27 = r17.asBinder();     // Catch: Throwable -> L104
        if (r27 == null) goto L102;
        r27.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r26, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L104
    L102:
        Handler r28 = j;     // Catch: Throwable -> L104
        r28.sendMessageDelayed(Message.obtain(r28, 0, r22), r16);     // Catch: Throwable -> L104
    L106:
        r14.b(null);
        return r22;
    L104:
        f.remove(r10);     // Catch: Throwable -> L108
        g.remove(r10);     // Catch: Throwable -> L108
        h.remove(r10);     // Catch: Throwable -> L108
        f17971e.remove(r13);     // Catch: Throwable -> L108
        f17970d.remove(r10);     // Catch: Throwable -> L108
        r22 = null;
        goto L106
    L84:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilityActionHandler");     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        d.n.a r113 = d.n.f38560a;     // Catch: Throwable -> L108
        if (d.n.c(d.n.f(d.o.a(th))) == null) goto L89;
        ILogDepend.Companion.e(TAG, "DeadDetectableBinderProxy createProxyInstance for " + ((IInterface) ZeusTransformUtils.preCheckCast(r17, IInterface.class, "com.obric.aiagent.plugin")).getClass() + " fail");     // Catch: Throwable -> L108
    L89:
        r21 = (IInterface) ZeusTransformUtils.preCheckCast(r17, IInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L108
    L108:
        th = th;
        r8 = r14;
    L112:
        r8.b(null);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r114 = r3.f;
        kotlinx.coroutines.f.a r29 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r3.f18006c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        IntentCalling r30 = (IntentCalling) ZeusTransformUtils.preCheckCast(r3.f18005b, IntentCalling.class, "com.obric.aiagent.plugin");
        String r31 = (String) ZeusTransformUtils.preCheckCast(r3.f18004a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L21
        long r115 = r114;
        String r116 = r31;
    L58:
        String r32 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        ILogDepend.Companion.i(TAG, "getBinderAndStore " + r116 + " timeoutConfig:" + r115 + "ms serviceName:" + r32);     // Catch: Throwable -> L21
        r13 = new m(r116, r32);     // Catch: Throwable -> L21
        b r33 = (b) ZeusTransformUtils.preCheckCast(f17971e.get(r13), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r33 == null) goto L71;
        Handler r34 = j;     // Catch: Throwable -> L21
        r34.removeMessages(0, r33);     // Catch: Throwable -> L21
        r34.sendMessageDelayed(Message.obtain(r34, 0, r33), r115);     // Catch: Throwable -> L21
        if (r30 == null) goto L69;
        ConcurrentMap r35 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(g, ConcurrentMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Object r36 = r35.get(r116);     // Catch: Throwable -> L21
        if (r36 != null) goto L68;
        r36 = new ArrayList();     // Catch: Throwable -> L21
        Object r37 = r35.putIfAbsent(r116, r36);     // Catch: Throwable -> L21
        if (r37 == null) goto L68;
        r36 = r37;
    L68:
        ((ArrayList) ZeusTransformUtils.preCheckCast(r36, ArrayList.class, "com.obric.aiagent.plugin")).add(r30);     // Catch: Throwable -> L21
    L69:
        r29.b(null);
        return r33;
    L71:
        a r38 = f17967a;     // Catch: Throwable -> L21
        r3.f18004a = r116;     // Catch: Throwable -> L21
        r3.f18005b = r30;     // Catch: Throwable -> L21
        r3.f18006c = r29;     // Catch: Throwable -> L21
        r3.f18007d = r32;     // Catch: Throwable -> L21
        r3.f18008e = r13;     // Catch: Throwable -> L21
        r3.f = r115;     // Catch: Throwable -> L21
        r3.i = 3;     // Catch: Throwable -> L21
        Object r39 = r38.a(r116, r32, r3);     // Catch: Throwable -> L21
        if (r39 != r4) goto L74;
        return r4;
    L74:
        r11 = r30;
        r15 = r32;
        r2 = r39;
        r14 = r29;
        r10 = r116;
        r16 = r115;
        goto L114
    L23:
        kotlinx.coroutines.f.a r40 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r3.f18006c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        IntentCalling r41 = (IntentCalling) ZeusTransformUtils.preCheckCast(r3.f18005b, IntentCalling.class, "com.obric.aiagent.plugin");
        r116 = (String) ZeusTransformUtils.preCheckCast(r3.f18004a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        kotlinx.coroutines.f.a r42 = r40;
    L31:
        if (r116 != null) goto L118;
    L49:
        r115 = f17968b;     // Catch: Throwable -> L110
    L50:
        com.obric.aiagent.executionengine.capabilitymanager.publish.a r43 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;     // Catch: Throwable -> L110
        if (r41 == null) goto L53;
        String r117 = r41.getIntentName();     // Catch: Throwable -> L110
    L54:
        r3.f18004a = r116;     // Catch: Throwable -> L110
        r3.f18005b = r41;     // Catch: Throwable -> L110
        r3.f18006c = r42;     // Catch: Throwable -> L110
        r3.f = r115;     // Catch: Throwable -> L110
        r3.i = 2;     // Catch: Throwable -> L110
        Object r44 = r43.a(r117, r116, r3);     // Catch: Throwable -> L110
        if (r44 != r4) goto L57;
        return r4;
    L57:
        r29 = r42;
        r2 = r44;
        r30 = r41;
    L110:
        th = th;
        r8 = r42;
        goto L112
    L53:
        r117 = null;
        goto L54
    L118:
        switch(r116.hashCode()) {
            case -1954901677: goto L46;
            case -1090707539: goto L42;
            case 379189486: goto L39;
            case 1221195815: goto L36;
            default: goto L49;
        };     // Catch: Throwable -> L110
    L36:
        if (r116.equals(BuildConfig.LIBRARY_PACKAGE_NAME) == false) goto L49;
        r115 = 1200000;
        goto L50
    L39:
        if (r116.equals("com.ss.android.lark") == false) goto L49;
    L48:
        r115 = 120000;
        goto L50
    L42:
        if (r116.equals("com.obric.memorydata") == false) goto L49;
        r115 = 186000;
        goto L50
    L46:
        if (r116.equals("com.ss.android.lark.debug") == true) goto L48;
    L24:
        d.o.a(r2);
        if (r23 != null) goto L27;
        return null;
    L27:
        r42 = i;
        r3.f18004a = r23;
        r41 = r24;
        r3.f18005b = r41;
        r3.f18006c = r42;
        r3.i = 1;
        if (r42.a(null, r3) != r4) goto L30;
        return r4;
    L30:
        r116 = r23;
    L21:
        th = th;
    L7:
        r3 = new g(this, r1);
        goto L8
    }

    private final Object a(String r4, String r5, d.c.d<? super ICapabilityActionHandler> r6) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "getBinder " + r4);
        return dg.b(10000, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r5, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object a(final IMAppAction r13, String r14, d.c.d<? super Boolean> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r16, c.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f17988d;
        Object r8 = d.c.a.b.a();
        int r2 = r0.f;
        boolean r10 = true;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        b r12 = (b) ZeusTransformUtils.preCheckCast(r0.f17987c, b.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f17986b, String.class, "com.obric.aiagent.plugin");
        IMAppAction r19 = (IMAppAction) ZeusTransformUtils.preCheckCast(r0.f17985a, IMAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L26:
        Boolean r110 = (Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.aiagent.plugin");
        IMAppAction r11 = r19;
        b r111 = r12;
        String r112 = r18;
        r13 = r11;
    L29:
        if (o.a(r110, d.c.b.a.b.a(true)) == true) goto L31;
        com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.a(ActionDispatcher.INSTANCE.getAppActionFailResult(r13, ErrorCode.DISPATCH_ERROR, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_dispatch_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_failed_dispatch_error"))));
        ILogDepend.Companion.i(TAG, "sdk dispatchAction fail. send fail result.");
    L31:
        if (r111 == null) goto L33;
        ILogDepend.Companion.i(TAG, "dispatchAction by capability sdk: " + r112);
    L35:
        return d.c.b.a.b.a(r10);
    L33:
        r10 = false;
        goto L35
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r112 = (String) ZeusTransformUtils.preCheckCast(r0.f17986b, String.class, "com.obric.aiagent.plugin");
        r13 = (IMAppAction) ZeusTransformUtils.preCheckCast(r0.f17985a, IMAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L20:
        r111 = (b) ZeusTransformUtils.preCheckCast(r17, b.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L27;
        d.h.a.b r113 = new $$Lambda$a$nW93r3TZ0E4_tcUyUEdoaNUqfA(r13);
        r0.f17985a = r13;
        r0.f17986b = r112;
        r0.f17987c = r111;
        r0.f = 2;
        r17 = r111.a(r113, r0);
        if (r17 != r8) goto L25;
        return r8;
    L25:
        IMAppAction r114 = r13;
        r18 = r112;
        r12 = r111;
        r19 = r114;
        goto L26
    L27:
        r110 = null;
        goto L29
    L16:
        d.o.a(r17);
        String r115 = r13.getAction().getAction();
        r0.f17985a = r13;
        r0.f17986b = r115;
        r0.f = 1;
        Object r116 = a(this, r14, null, r0, 2, null);
        if (r116 != r8) goto L19;
        return r8;
    L19:
        r17 = r116;
        r112 = r115;
    L7:
        r0 = new c(this, r16);
        goto L8
    }

    private static final boolean a(IMAppAction r2, ICapabilityActionHandler r3) {
        ICapabilityActionHandler r4 = (ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        return r4.handleAction(com.obric.capabilitykit.common.a.a().toJson(r2));
    }

    public final Object a(IntentCalling r7, IntentResult<?> r8, String r9, d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f18016e;
        Object r12 = d.c.a.b.a();
        int r2 = r0.g;
        boolean r4 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.f.a r13 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f18015d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r0.f18014c, String.class, "com.obric.aiagent.plugin");
        r8 = (IntentResult) ZeusTransformUtils.preCheckCast(r0.f18013b, IntentResult.class, "com.obric.aiagent.plugin");
        IntentCalling r14 = (IntentCalling) ZeusTransformUtils.preCheckCast(r0.f18012a, IntentCalling.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        kotlinx.coroutines.f.a r15 = r13;
        r7 = r14;
    L40:
        ArrayList r16 = (ArrayList) ZeusTransformUtils.preCheckCast(g.get(r9), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r16 == null) goto L21;
        d.c.b.a.b.a(r16.remove(r7));     // Catch: Throwable -> L37
    L21:
        if (r8 != null) goto L23;
    L25:
        r4 = false;
    L26:
        if (r4 == false) goto L34;
        ILogDepend.Companion.i(TAG, "onReceiveIntentResult add need update intent: " + r9 + ' ' + r7.getJobId());     // Catch: Throwable -> L37
        ConcurrentMap r17 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(h, ConcurrentMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        Object r18 = r17.get(r9);     // Catch: Throwable -> L37
        if (r18 != null) goto L33;
        r18 = new HashMap();     // Catch: Throwable -> L37
        Object r19 = r17.putIfAbsent(r9, r18);     // Catch: Throwable -> L37
        if (r19 == null) goto L33;
        r18 = r19;
    L33:
        o.c(r18, "getOrPut(...)");     // Catch: Throwable -> L37
        ((Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r7.getJobId()), r7);     // Catch: Throwable -> L37
    L34:
        x r20 = x.f38692a;     // Catch: Throwable -> L37
        r15.b(null);
        return x.f38692a;
    L23:
        if (r8.isFinal() == true) goto L25;
    L37:
        th = move-exception;
        r15.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        r15 = i;
        r0.f18012a = r7;
        r0.f18013b = r8;
        r0.f18014c = r9;
        r0.f18015d = r15;
        r0.g = 1;
        if (r15.a(null, r0) != r12) goto L40;
        return r12;
    L7:
        r0 = new i(this, r11);
        goto L8
    }

    public final void a(String r7, IntentResult<?> r8) {
        o.e(r8, "intentResult");
        if (com.obric.aiagent.executionengine.scheduler.impl.d.a.a(r8) == false) goto L6;
        ILogDepend.Companion.i(TAG, "onUpdateIntentResult remove intent: return by bind died tag");
        return;
    L6:
        kotlinx.coroutines.i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.d(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r8, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object a(IntentCalling r18, String r19, d.c.d<? super Boolean> r20) {
        final IntentCalling r1 = r18;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f17993d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        boolean r8 = true;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r4.f17992c, b.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.f17991b, String.class, "com.obric.aiagent.plugin");
        IntentCalling r9 = (IntentCalling) ZeusTransformUtils.preCheckCast(r4.f17990a, IntentCalling.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L26:
        Boolean r10 = (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin");
        IntentCalling r11 = r9;
        String r16 = r7;
        b r12 = r0;
        String r13 = r16;
    L29:
        if (o.a(r10, d.c.b.a.b.a(true)) == true) goto L31;
        com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r14 = d.a(d.f18035a, r11, ErrorCode.DISPATCH_ERROR, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_dispatch_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_failed_dispatch_error")), null, 8, null);
        com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.a(r14.a(), r14.b());
        ILogDepend.Companion.i(TAG, "sdk dispatchAction fail. send fail result.");
    L31:
        if (r12 == null) goto L33;
        ILogDepend.Companion.i(TAG, "dispatchAction by capability sdk: " + r13);
    L35:
        return d.c.b.a.b.a(r8);
    L33:
        r8 = false;
        goto L35
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (String) ZeusTransformUtils.preCheckCast(r4.f17991b, String.class, "com.obric.aiagent.plugin");
        r1 = (IntentCalling) ZeusTransformUtils.preCheckCast(r4.f17990a, IntentCalling.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L20:
        b r15 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L27;
        d.h.a.b r17 = new $$Lambda$a$RJjEo5bfDqxOKimVjZ9LYbaNFwQ(r1);
        r4.f17990a = r1;
        r4.f17991b = r13;
        r4.f17992c = r15;
        r4.f = 2;
        Object r21 = r15.a(r17, r4);
        if (r21 != r5) goto L25;
        return r5;
    L25:
        IntentCalling r110 = r1;
        r7 = r13;
        r0 = r15;
        r3 = r21;
        r9 = r110;
        goto L26
    L27:
        r11 = r1;
        r12 = r15;
        r10 = null;
        goto L29
    L16:
        d.o.a(r3);
        String r22 = r18.getIntentName();
        r4.f17990a = r1;
        r4.f17991b = r22;
        r4.f = 1;
        Object r23 = a(r19, r1, r4);
        if (r23 != r5) goto L19;
        return r5;
    L19:
        r3 = r23;
        r13 = r22;
    L7:
        r4 = new d(this, r2);
        goto L8
    }

    private static final boolean a(IntentCalling r2, ICapabilityActionHandler r3) {
        ICapabilityActionHandler r4 = (ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        return r4.handleIntentCalling(r2);
    }

    public final Object a(com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a r18, d.c.d<? super Boolean> r19) {
        final com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a r0 = r18;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L7;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");
        if ((r3.f17998d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f17998d -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f17996b;
        Object r10 = d.c.a.b.a();
        int r5 = r3.f17998d;
        boolean r9 = true;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        r0 = (com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a) ZeusTransformUtils.preCheckCast(r3.f17995a, com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        Object r4 = r2;
        String r8 = TAG;
        r9 = true;
    L35:
        if (o.a((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(r9)) == true) goto L46;
        ILogDepend.Companion.e(r8, "dispatchUriFileAccessRequest failed; sharer rejected; req=" + r0);
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L39
        IUriFileReceiver r7 = r0.e();     // Catch: Throwable -> L39
        String r11 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_uri_access_error_accessing_sharer, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_uri_access_error_accessing_sharer"));     // Catch: Throwable -> L39
        o.c(r11, "getString(...)");     // Catch: Throwable -> L39
        r7.onSessionReady(new UriFileAccessSession(8, r11, null, 4, null));     // Catch: Throwable -> L39
        Object r12 = d.n.f(x.f38692a);     // Catch: Throwable -> L39
    L41:
        Throwable r13 = d.n.c(r12);
        if (r13 == null) goto L45;
        ILogDepend.Companion.e(r8, "receiver is bad; ex=" + r13);
    L45:
        return d.c.b.a.b.a(false);
    L39:
        th = move-exception;
        d.n.a r14 = d.n.f38560a;
        r12 = d.n.f(d.o.a(th));
        goto L41
    L46:
        ILogDepend.Companion.d(r8, "dispatchUriFileAccessRequest; succeeded req=" + r0);
        return d.c.b.a.b.a(r9);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r0 = (com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a) ZeusTransformUtils.preCheckCast(r3.f17995a, com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        Object r15 = r2;
    L19:
        b r16 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L31;
        ILogDepend.Companion.e(r8, "dispatchUriFileAccessRequest failed; binder failed to retrieve; req=" + r0);
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L24
        IUriFileReceiver r20 = r0.e();     // Catch: Throwable -> L24
        String r21 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_uri_access_error_invalid_sharer, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_uri_access_error_invalid_sharer"));     // Catch: Throwable -> L24
        o.c(r21, "getString(...)");     // Catch: Throwable -> L24
        r20.onSessionReady(new UriFileAccessSession(3, r21, null, 4, null));     // Catch: Throwable -> L24
        Object r22 = d.n.f(x.f38692a);     // Catch: Throwable -> L24
    L26:
        Throwable r23 = d.n.c(r22);
        if (r23 == null) goto L30;
        ILogDepend.Companion.e(TAG, "receiver is bad; ex=" + r23);
    L30:
        return d.c.b.a.b.a(false);
    L24:
        th = move-exception;
        d.n.a r24 = d.n.f38560a;
        r22 = d.n.f(d.o.a(th));
        goto L26
    L31:
        final String r25 = r0.c() + ';' + r0.b();
        d.h.a.b r26 = new $$Lambda$a$SnncTdiGDsv9bm0ulTnkFqK_FQ(r0, r25);
        r3.f17995a = r0;
        r3.f17998d = 2;
        r4 = r16.a(r26, r3);
        if (r4 != r10) goto L35;
        return r10;
    L16:
        d.o.a(r2);
        ILogDepend.Companion.d(TAG, "dispatchUriFileAccessRequest; req=" + r0);
        String r27 = r18.d();
        r3.f17995a = r0;
        r3.f17998d = 1;
        r15 = a(this, r27, null, r3, 2, null);
        if (r15 != r10) goto L19;
        return r10;
    L7:
        r3 = new e(this, r1);
        goto L8
    }

    private static final boolean a(com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b.a r2, String r3, ICapabilityActionHandler r4) {
        ICapabilityActionHandler r5 = (ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r4, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");
        o.e(r5, "it");
        return r5.openUriFile(r2.a(), r2.e(), r3);
    }
}
