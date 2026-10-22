package com.obric.capabilitykit.search.global;

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
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchService;
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
public final class GlobalSearchClient {
    public static final GlobalSearchClient INSTANCE = null;
    public static final int NONE_ERROR_ENTITY_TYPE = -1;
    private static final String TAG = "GlobalSearchClient";
    private static final ConcurrentHashMap<String, Long> businessMap = null;
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;
    private static final Handler mainHandler = null;
    private static final Queue<d.h.a.a<Object>> pendingOperations = null;
    private static IGlobalSearchService service;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            GlobalSearchClient r5 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(IGlobalSearchService.Stub.asInterface(r2));
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceConnected " + r3);
            GlobalSearchClient.access$setBound$p(true);
        L4:
            if ((!GlobalSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L8;
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.preCheckCast(GlobalSearchClient.access$getPendingOperations$p().poll(), d.h.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L4;
            r6.invoke();
            goto L4
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceDisconnected " + r3);
            GlobalSearchClient r2 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(null);
            GlobalSearchClient.access$setBound$p(false);
        }
    }

    public static final class b extends p implements d.h.a.a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGlobalSearchCallback f32237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f32238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GlobalSearchRequest f32239c;

        public static final class a extends com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f32240a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f32241b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IGlobalSearchCallback f32242c;

            public a(String r3, long r4, IGlobalSearchCallback r6) {
                IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
                this.f32240a = r3;
                this.f32241b = r4;
                this.f32242c = r7;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5) {
                IGlobalSearchCallback r6 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r6, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r6.onAllCompleted();
                GlobalSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5, int r6) {
                IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r7, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onCompleted(r6);
                return;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5, int r6, String r7) {
                IGlobalSearchCallback r8 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r8, "$callback");
                o.e(r7, "$errorMsg");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r8.onError(r6, -1, r7);
                GlobalSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5, GlobalSearchResult r6) {
                IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
                o.e(r2, "$businessName");
                o.e(r7, "$callback");
                o.e(r6, "$result");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onSearchResult(r6);
                return;
            }

            /* JADX INFO: renamed from: lambda$-854c9zS8KC34Ppoz9ldVs9kRYc, reason: not valid java name */
            public static /* synthetic */ void m933lambda$854c9zS8KC34Ppoz9ldVs9kRYc(String r0, long r1, IGlobalSearchCallback r3) {
                a(r0, r1, r3);
            }

            /* JADX INFO: renamed from: lambda$5E8VhNMmoWxBB-8MitBgOadozG4, reason: not valid java name */
            public static /* synthetic */ void m934lambda$5E8VhNMmoWxBB8MitBgOadozG4(String r0, long r1, IGlobalSearchCallback r3, int r4) {
                a(r0, r1, r3, r4);
            }

            public static /* synthetic */ void lambda$qK42MxT_Ij_sOuhvobgChalC40g(String r0, long r1, IGlobalSearchCallback r3, int r4, String r5) {
                a(r0, r1, r3, r4, r5);
            }

            /* JADX INFO: renamed from: lambda$r8WYu-23Ups3PQTqvFwx_0CJVx4, reason: not valid java name */
            public static /* synthetic */ void m935lambda$r8WYu23Ups3PQTqvFwx_0CJVx4(String r0, long r1, IGlobalSearchCallback r3, GlobalSearchResult r4) {
                a(r0, r1, r3, r4);
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onAllCompleted");
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.f32240a;
                final long r2 = this.f32241b;
                final IGlobalSearchCallback r5 = this.f32242c;
                r0.post(new $$Lambda$GlobalSearchClient$b$a$854c9zS8KC34Ppoz9ldVs9kRYc(r1, r2, r5));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(final int r8) {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onCompleted " + r8);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.f32240a;
                final long r3 = this.f32241b;
                final IGlobalSearchCallback r5 = this.f32242c;
                r0.post(new $$Lambda$GlobalSearchClient$b$a$5E8VhNMmoWxBB8MitBgOadozG4(r2, r3, r5, r8));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(final int r8, int r9, final String r10) {
                o.e(r10, "errorMsg");
                Logger.INSTANCE.w(GlobalSearchClient.TAG, "onError: " + r8 + ' ' + r10);
                Handler r11 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.f32240a;
                final long r2 = this.f32241b;
                final IGlobalSearchCallback r4 = this.f32242c;
                r11.post(new $$Lambda$GlobalSearchClient$b$a$qK42MxT_Ij_sOuhvobgChalC40g(r1, r2, r4, r8, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(final GlobalSearchResult r8) {
                o.e(r8, "result");
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onSearchResult: " + r8);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.f32240a;
                final long r3 = this.f32241b;
                final IGlobalSearchCallback r5 = this.f32242c;
                r0.post(new $$Lambda$GlobalSearchClient$b$a$r8WYu23Ups3PQTqvFwx_0CJVx4(r2, r3, r5, r8));
            }
        }

        public b(IGlobalSearchCallback r3, String r4, GlobalSearchRequest r5) {
            this.f32237a = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
            this.f32238b = r4;
            this.f32239c = r5;
            super(0);
        }

        private static final void a(IGlobalSearchCallback r2, Throwable r3) {
            IGlobalSearchCallback r4 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r2, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
            o.e(r4, "$callback");
            o.e(r3, "$e");
            String r5 = r3.getMessage();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r4.onError(1, -1, r5);
        }

        /* JADX INFO: renamed from: lambda$iqeFuGxDJkRxGq-kKhciR7U1NQ0, reason: not valid java name */
        public static /* synthetic */ void m932lambda$iqeFuGxDJkRxGqkKhciR7U1NQ0(IGlobalSearchCallback r0, Throwable r1) {
            a(r0, r1);
        }

        @Override // d.h.a.a
        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(GlobalSearchClient.TAG, "exception " + th.getMessage());
            Handler r1 = GlobalSearchClient.access$getMainHandler$p();
            final IGlobalSearchCallback r8 = this.f32237a;
            return Boolean.valueOf(r1.post(new $$Lambda$GlobalSearchClient$b$iqeFuGxDJkRxGqkKhciR7U1NQ0(r8, th)));
        L3:
            if (GlobalSearchClient.access$getService$p() != null) goto L5;
            this.f32237a.onError(2, -1, "service not ready");     // Catch: Throwable -> L11
        L8:
            return x.f38692a;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            GlobalSearchClient.access$getBusinessMap$p().put(this.f32238b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IGlobalSearchService r2 = GlobalSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r2 == null) goto L10;
            r2.startGlobalSearch(this.f32238b, this.f32239c, new a(this.f32238b, r0, this.f32237a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    static {
        INSTANCE = new GlobalSearchClient();
        context = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        mainHandler = new Handler(Looper.getMainLooper());
        pendingOperations = new LinkedList();
        businessMap = new ConcurrentHashMap();
        connection = new a();
    }

    private GlobalSearchClient() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBusinessMap$p() {
        return businessMap;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ Queue access$getPendingOperations$p() {
        return pendingOperations;
    }

    public static final /* synthetic */ IGlobalSearchService access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isCancelled(GlobalSearchClient r0, String r1, long r2) {
        return r0.isCancelled(r1, r2);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IGlobalSearchService r2) {
        service = (IGlobalSearchService) ZeusTransformUtils.wrapperContextForParams(r2, IGlobalSearchService.class, "com.obric.aiagent.plugin");
    }

    private final boolean bindService() {
        Logger.INSTANCE.d(TAG, "start bindService");
        Intent r8 = new Intent("com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE");
        List<ResolveInfo> r1 = context.getPackageManager().queryIntentServices(r8, 0);
        o.c(r1, "context.packageManager.q…IntentServices(intent, 0)");
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ServiceInfo r4 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r2.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo;
        if (r4 == null) goto L4;
        r3.add(r4);
        goto L4
    L8:
        Iterator r5 = r3.iterator();
    L9:
        String r6 = null;
        if (r5.hasNext() == false) goto L14;
        Object r7 = r5.next();
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) ZeusTransformUtils.preCheckCast(r7, ServiceInfo.class, "com.obric.aiagent.plugin")).packageName) == false) goto L9;
    L15:
        ServiceInfo r9 = (ServiceInfo) ZeusTransformUtils.preCheckCast(r7, ServiceInfo.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L19;
        Logger.INSTANCE.e(TAG, "No trusted service found for action: " + r8.getAction());
        return false;
    L19:
        r8.setComponent(new ComponentName(r9.packageName, r9.name));
        r8.setPackage(r9.packageName);
        boolean r10 = ZeusTransformUtils.bindService(context, r8, connection, 1, "com.obric.aiagent.plugin");
        if (r10 == true) goto L25;
        Logger r11 = Logger.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("not found service ");
        ComponentName r13 = r8.getComponent();
        if (r13 == null) goto L24;
        r6 = r13.getShortClassName();
    L24:
        r11.w(TAG, r12.append(r6).toString());
    L25:
        return r10;
    L14:
        r7 = null;
        goto L15
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
        if (r2.b(r0) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IGlobalSearchService r4 = service;     // Catch: RemoteException -> L12
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

    public final void startGlobalSearch(String r4, GlobalSearchRequest r5, IGlobalSearchCallback r6) {
        IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IGlobalSearchCallback.class, "com.obric.aiagent.plugin");
        o.e(r4, "businessName");
        o.e(r5, Ext.KEY_REQUEST);
        o.e(r7, "callback");
        com.obric.capabilitykit.entity.memory.a r0 = com.obric.capabilitykit.entity.memory.a.f32135a;
        Context r1 = context;
        o.c(r1, "context");
        if (r0.b(r1) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip startGlobalSearch");
        r7.onError(6, -1, "Global search service is not available");
        return;
    L6:
        b r2 = new b(r7, r4, r5);
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
        if (r0.b(r1) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }
}
