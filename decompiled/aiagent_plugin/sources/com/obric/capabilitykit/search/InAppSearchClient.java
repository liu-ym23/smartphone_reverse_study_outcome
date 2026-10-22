package com.obric.capabilitykit.search;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.entity.search.EntityChangeMonitorRequest;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.entity.search.IEntityChangeCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchService;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppSearchClient {
    private static final String ACTION_SEARCH_SERVICE = "com.obric.memorydata.action.SEARCH_SERVICE";
    public static final InAppSearchClient INSTANCE = null;
    private static final String TAG = "InAppSearchClient";
    private static final ConcurrentHashMap<String, Long> businessMap = null;
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;
    private static final Handler mainHandler = null;
    private static final Queue<d.h.a.a<Object>> pendingOperations = null;
    private static IInAppSearchService service;

    public static final class a implements ServiceConnection {
        public a() {
        }

        private static final void a() {
        L3:
            if ((!InAppSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L7;
            d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(InAppSearchClient.access$getPendingOperations$p().poll(), d.h.a.a.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L3;
            r0.invoke();
            goto L3
        }

        public static /* synthetic */ void lambda$xMSkcGzi_FM8nzlUTjitRYf_NNI() {
            a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            InAppSearchClient r4 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(IInAppSearchService.Stub.asInterface(r1));
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceConnected " + r2);
            InAppSearchClient.access$setBound$p(true);
            new Thread($$Lambda$InAppSearchClient$a$xMSkcGzi_FM8nzlUTjitRYf_NNI.INSTANCE).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceDisconnected " + r3);
            InAppSearchClient r2 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(null);
            InAppSearchClient.access$setBound$p(false);
        }
    }

    public static final class b extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32226a = null;

        static {
            f32226a = new b();
        }

        public b() {
            super(0);
        }

        public final x a() {
            IInAppSearchService r3 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L7
            if (r3 == null) goto L6;
            r3.prepareSearch();     // Catch: Throwable -> L7
            return x.f38692a;
        L6:
            return null;
        L7:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            return x.f38692a;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            return a();
        }
    }

    public static final class c extends p implements d.h.a.a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAppEntityChangeCallback f32227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EntityChangeMonitorRequest f32228b;

        public static final class a extends IEntityChangeCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IAppEntityChangeCallback f32229a;

            public a(IAppEntityChangeCallback r3) {
                this.f32229a = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityChangeCallback.class, "com.obric.aiagent.plugin");
            }

            private static final void a(IAppEntityChangeCallback r2, int r3, String r4) {
                IAppEntityChangeCallback r5 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityChangeCallback.class, "com.obric.aiagent.plugin");
                o.e(r5, "$callback");
                o.e(r4, "$errorMsg");
                r5.onError(r3, r4);
            }

            private static final void a(IAppEntityChangeCallback r2, EntityChangeResult r3) {
                IAppEntityChangeCallback r4 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityChangeCallback.class, "com.obric.aiagent.plugin");
                o.e(r4, "$callback");
                o.e(r3, "$result");
                r4.onChange(r3);
            }

            public static /* synthetic */ void lambda$MBBpeLO7AFlkGu6ujqV986rfyb4(IAppEntityChangeCallback r0, EntityChangeResult r1) {
                a(r0, r1);
            }

            public static /* synthetic */ void lambda$geX8TvJO2QDvzLJPLNBPvr2dfUE(IAppEntityChangeCallback r0, int r1, String r2) {
                a(r0, r1, r2);
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onChange(final EntityChangeResult r3) {
                o.e(r3, "result");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r2 = this.f32229a;
                r0.post(new $$Lambda$InAppSearchClient$c$a$MBBpeLO7AFlkGu6ujqV986rfyb4(r2, r3));
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onError(final int r4, final String r5) {
                o.e(r5, "errorMsg");
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r4 + ' ' + r5);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r3 = this.f32229a;
                r0.post(new $$Lambda$InAppSearchClient$c$a$geX8TvJO2QDvzLJPLNBPvr2dfUE(r3, r4, r5));
            }
        }

        public c(IAppEntityChangeCallback r3, EntityChangeMonitorRequest r4) {
            this.f32227a = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityChangeCallback.class, "com.obric.aiagent.plugin");
            this.f32228b = r4;
            super(0);
        }

        private static final void a(IAppEntityChangeCallback r2, Throwable r3) {
            IAppEntityChangeCallback r4 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityChangeCallback.class, "com.obric.aiagent.plugin");
            o.e(r4, "$callback");
            o.e(r3, "$e");
            String r5 = r3.getMessage();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r4.onError(1, r5);
        }

        /* JADX INFO: renamed from: lambda$oGDEIdie0g-vMy3k6uqLBju-nCM, reason: not valid java name */
        public static /* synthetic */ void m929lambda$oGDEIdie0gvMy3k6uqLBjunCM(IAppEntityChangeCallback r0, Throwable r1) {
            a(r0, r1);
        }

        @Override // d.h.a.a
        public final Object invoke() {
            com.obric.capabilitykit.entity.memory.a r2 = com.obric.capabilitykit.entity.memory.a.f32135a;     // Catch: Throwable -> L16
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(InAppSearchClient.access$getContext$p(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
            o.c(r0, "context");     // Catch: Throwable -> L16
            if (r2.a(r0) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L8;
            Logger.INSTANCE.w(InAppSearchClient.TAG, "Memory search service is not available, skip registerEntityObserver");     // Catch: Throwable -> L16
            IAppEntityChangeCallback r1 = this.f32227a;     // Catch: Throwable -> L16
            int r3 = 6;
            String r4 = "Memory search service is disabled";
        L6:
            r1.onError(r3, r4);     // Catch: Throwable -> L16
        L13:
            return x.f38692a;
        L8:
            if (InAppSearchClient.access$getService$p() != null) goto L10;
            r1 = this.f32227a;     // Catch: Throwable -> L16
            r3 = 2;
            r4 = "service not ready";
            goto L6
        L10:
            IInAppSearchService r5 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L16
            if (r5 == null) goto L15;
            r5.registerEntityObserver(this.f32228b, new a(this.f32227a));     // Catch: Throwable -> L16
            goto L13
        L15:
            return null;
        L16:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r6 = InAppSearchClient.access$getMainHandler$p();
            final IAppEntityChangeCallback r7 = this.f32227a;
            return Boolean.valueOf(r6.post(new $$Lambda$InAppSearchClient$c$oGDEIdie0gvMy3k6uqLBjunCM(r7, th)));
        }
    }

    public static final class d extends p implements d.h.a.a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAppSearchCallback f32230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f32231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InAppSearchRequest f32232c;

        public static final class a extends IInAppSearchCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f32233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f32234b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IAppSearchCallback f32235c;

            public a(String r3, long r4, IAppSearchCallback r6) {
                IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAppSearchCallback.class, "com.obric.aiagent.plugin");
                this.f32233a = r3;
                this.f32234b = r4;
                this.f32235c = r7;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5) {
                IAppSearchCallback r6 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r6, "$callback");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r6.onCompleted();
                InAppSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5, int r6, String r7) {
                IAppSearchCallback r8 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r8, "$callback");
                o.e(r7, "$errorMsg");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r8.onError(r6, r7);
                InAppSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5, InAppSearchResult r6) {
                IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r7, "$callback");
                o.e(r6, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onSearchResult(r6);
                return;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5, InAppSearchResultWithoutEntity r6) {
                IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r7, "$callback");
                o.e(r6, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onSearchResultWithoutEntity(r6);
                return;
            }

            public static /* synthetic */ void lambda$M7YiRtclisfG5SQX_uad561zL88(String r0, long r1, IAppSearchCallback r3, int r4, String r5) {
                a(r0, r1, r3, r4, r5);
            }

            /* JADX INFO: renamed from: lambda$MMtM6GzrBtGSw9wXZeHLcJP-s6U, reason: not valid java name */
            public static /* synthetic */ void m930lambda$MMtM6GzrBtGSw9wXZeHLcJPs6U(String r0, long r1, IAppSearchCallback r3) {
                a(r0, r1, r3);
            }

            public static /* synthetic */ void lambda$ZWtYUYYv5POfkGzZOdIwIKcCsO8(String r0, long r1, IAppSearchCallback r3, InAppSearchResultWithoutEntity r4) {
                a(r0, r1, r3, r4);
            }

            /* JADX INFO: renamed from: lambda$kIR1dlnQntc1kjTKjeCj3-P-MJs, reason: not valid java name */
            public static /* synthetic */ void m931lambda$kIR1dlnQntc1kjTKjeCj3PMJs(String r0, long r1, IAppSearchCallback r3, InAppSearchResult r4) {
                a(r0, r1, r3, r4);
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onCompleted() {
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onCompleted");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r1 = this.f32233a;
                final long r2 = this.f32234b;
                final IAppSearchCallback r5 = this.f32235c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$MMtM6GzrBtGSw9wXZeHLcJPs6U(r1, r2, r5));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onError(final int r9, final String r10) {
                o.e(r10, "errorMsg");
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r9 + ' ' + r10);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.f32233a;
                final long r3 = this.f32234b;
                final IAppSearchCallback r5 = this.f32235c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$M7YiRtclisfG5SQX_uad561zL88(r2, r3, r5, r9, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResult(final InAppSearchResult r8) {
                o.e(r8, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResult: " + r8);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.f32233a;
                final long r3 = this.f32234b;
                final IAppSearchCallback r5 = this.f32235c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$kIR1dlnQntc1kjTKjeCj3PMJs(r2, r3, r5, r8));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResultWithoutEntity(final InAppSearchResultWithoutEntity r8) {
                o.e(r8, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResultWithoutEntity");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.f32233a;
                final long r3 = this.f32234b;
                final IAppSearchCallback r5 = this.f32235c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$ZWtYUYYv5POfkGzZOdIwIKcCsO8(r2, r3, r5, r8));
            }
        }

        public d(IAppSearchCallback r3, String r4, InAppSearchRequest r5) {
            this.f32230a = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAppSearchCallback.class, "com.obric.aiagent.plugin");
            this.f32231b = r4;
            this.f32232c = r5;
            super(0);
        }

        private static final void a(IAppSearchCallback r2, Throwable r3) {
            IAppSearchCallback r4 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppSearchCallback.class, "com.obric.aiagent.plugin");
            o.e(r4, "$callback");
            o.e(r3, "$e");
            String r5 = r3.getMessage();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r4.onError(1, r5);
        }

        public static /* synthetic */ void lambda$uYcuRoSw_QM7xokr3pEPv6pJAgo(IAppSearchCallback r0, Throwable r1) {
            a(r0, r1);
        }

        @Override // d.h.a.a
        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r1 = InAppSearchClient.access$getMainHandler$p();
            final IAppSearchCallback r8 = this.f32230a;
            return Boolean.valueOf(r1.post(new $$Lambda$InAppSearchClient$d$uYcuRoSw_QM7xokr3pEPv6pJAgo(r8, th)));
        L3:
            if (InAppSearchClient.access$getService$p() != null) goto L5;
            this.f32230a.onError(2, "service not ready");     // Catch: Throwable -> L11
        L8:
            return x.f38692a;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            InAppSearchClient.access$getBusinessMap$p().put(this.f32231b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IInAppSearchService r2 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r2 == null) goto L10;
            r2.startAppSearch(this.f32231b, this.f32232c, new a(this.f32231b, r0, this.f32230a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    public static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32236a = null;

        static {
            f32236a = new e();
        }

        public e() {
            super(0);
        }

        public final x a() {
            IInAppSearchService r0 = InAppSearchClient.access$getService$p();     // Catch: RemoteException -> L7
            if (r0 == null) goto L6;
            r0.unregisterEntityObserver();     // Catch: RemoteException -> L7
            return x.f38692a;
        L6:
            return null;
        L7:
            e = move-exception;
            e.printStackTrace();
            return x.f38692a;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            return a();
        }
    }

    static {
        INSTANCE = new InAppSearchClient();
        context = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        mainHandler = new Handler(Looper.getMainLooper());
        pendingOperations = new LinkedList();
        businessMap = new ConcurrentHashMap();
        connection = new a();
    }

    private InAppSearchClient() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBusinessMap$p() {
        return businessMap;
    }

    public static final /* synthetic */ Context access$getContext$p() {
        return context;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ Queue access$getPendingOperations$p() {
        return pendingOperations;
    }

    public static final /* synthetic */ IInAppSearchService access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isCancelled(InAppSearchClient r0, String r1, long r2) {
        return r0.isCancelled(r1, r2);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IInAppSearchService r2) {
        service = (IInAppSearchService) ZeusTransformUtils.wrapperContextForParams(r2, IInAppSearchService.class, "com.obric.aiagent.plugin");
    }

    private final boolean bindService() {
        Logger r0 = Logger.INSTANCE;
        r0.d(TAG, "start bindService");
        Context r2 = context;
        o.c(r2, "context");
        List<String> r7 = queryServicePackagesByAction(r2, ACTION_SEARCH_SERVICE);
        if (r7.size() != 1) goto L12;
        Intent r4 = new Intent(ACTION_SEARCH_SERVICE);
        r4.setPackage((String) ZeusTransformUtils.preCheckCast(d.a.p.k(r7), String.class, "com.obric.aiagent.plugin"));
        boolean r8 = ZeusTransformUtils.bindService(r2, r4, connection, 1, "com.obric.aiagent.plugin");
        if (r8 == true) goto L11;
        StringBuilder r3 = new StringBuilder().append("not found service ");
        ComponentName r5 = r4.getComponent();
        if (r5 == null) goto L9;
        String r6 = r5.getShortClassName();
    L10:
        r0.w(TAG, r3.append(r6).toString());
        goto L11
    L9:
        r6 = null;
    L11:
        return r8;
    L12:
        r0.w(TAG, "not found trusted service com.obric.memorydata.action.SEARCH_SERVICE, result = " + r7);
        return false;
    }

    private final boolean isCancelled(String r2, long r3) {
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(businessMap.get(r2), Long.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
    L7:
        Logger.INSTANCE.d(TAG, "ignore expired search");
        return true;
    L6:
        if (r1.longValue() != r3) goto L7;
        return false;
    }

    private final void unbindService() {
        if (isBound == false) goto L6;
        ZeusTransformUtils.unbindService(context, connection, "com.obric.aiagent.plugin");
        isBound = false;
        return;
    }

    public final void cancel(String r3) {
        o.e(r3, "businessName");
        com.obric.capabilitykit.entity.memory.a r2 = com.obric.capabilitykit.entity.memory.a.f32135a;
        Context r0 = context;
        o.c(r0, "context");
        if (r2.a(r0) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IInAppSearchService r4 = service;     // Catch: RemoteException -> L12
        if (r4 == null) goto L18;
        r4.cancel(r3);     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void prepareSearch() {
        com.obric.capabilitykit.entity.memory.a r0 = com.obric.capabilitykit.entity.memory.a.f32135a;
        Context r1 = context;
        o.c(r1, "context");
        if (r0.a(r1) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip prepareSearch");
        return;
    L6:
        b r2 = b.f32226a;
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }

    public final List<String> queryServicePackagesByAction(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r5, "action");
        Intent r6 = new Intent(r5);
        List<ResolveInfo> r7 = r3.getPackageManager().queryIntentServices(r6, UiType.FLAG_PHONE_CARD);
        o.c(r7, "pm.queryIntentServices(i…PackageManager.MATCH_ALL)");
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        ServiceInfo r10 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r9.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo;
        if (r10 == null) goto L8;
        String r11 = r10.packageName;
    L9:
        if (r11 == null) goto L4;
        r8.add(r11);
        goto L4
    L8:
        r11 = null;
        goto L9
    L11:
        List r12 = d.a.p.s(r8);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        Object r15 = r14.next();
        String r1 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin");
        if (PackageUtils.INSTANCE.checkSignature(r1) == false) goto L13;
        r13.add(r15);
        goto L13
    L17:
        return r13;
    }

    public final void registerEntityObserver(EntityChangeMonitorRequest r3, IAppEntityChangeCallback r4) {
        IAppEntityChangeCallback r5 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityChangeCallback.class, "com.obric.aiagent.plugin");
        o.e(r3, "entityChangeMonitorRequest");
        o.e(r5, "callback");
        c r0 = new c(r5, r3);
        if (isBound == false) goto L5;
        r0.invoke();
        return;
    L5:
        pendingOperations.add(r0);
        bindService();
    }

    public final void startAppSearch(String r4, InAppSearchRequest r5, IAppSearchCallback r6) {
        IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAppSearchCallback.class, "com.obric.aiagent.plugin");
        o.e(r4, "businessName");
        o.e(r5, Ext.KEY_REQUEST);
        o.e(r7, "callback");
        com.obric.capabilitykit.entity.memory.a r0 = com.obric.capabilitykit.entity.memory.a.f32135a;
        Context r1 = context;
        o.c(r1, "context");
        if (r0.a(r1) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip startAppSearch");
        r7.onError(6, "Memory search service is disabled");
        return;
    L6:
        d r2 = new d(r7, r4, r5);
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }

    public final void stop() {
        com.obric.capabilitykit.entity.memory.a r0 = com.obric.capabilitykit.entity.memory.a.f32135a;
        Context r1 = context;
        o.c(r1, "context");
        if (r0.a(r1) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }

    public final void stopSearch() {
        com.obric.capabilitykit.entity.memory.a r2 = com.obric.capabilitykit.entity.memory.a.f32135a;
        Context r0 = context;
        o.c(r0, "context");
        if (r2.a(r0) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L7;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stopSearch");
        return;
    L7:
        if (isBound == false) goto L17;
        IInAppSearchService r3 = service;     // Catch: RemoteException -> L12
        if (r3 == null) goto L18;
        r3.stopSearch();     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void unregisterEntityObserver() {
        com.obric.capabilitykit.entity.memory.a r0 = com.obric.capabilitykit.entity.memory.a.f32135a;
        Context r1 = context;
        o.c(r1, "context");
        if (r0.a(r1) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip unregisterEntityObserver");
        return;
    L6:
        e r2 = e.f32236a;
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }
}
