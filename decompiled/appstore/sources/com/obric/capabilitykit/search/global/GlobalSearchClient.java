package com.obric.capabilitykit.search.global;

import android.annotation.SuppressLint;
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
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchService;
import com.obric.capabilitykit.logger.Logger;
import fb.c;
import fb.d;
import fb.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001bJ\b\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/search/global/GlobalSearchClient;", "", "()V", "NONE_ERROR_ENTITY_TYPE", "", "TAG", "", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", WsConstants.KEY_CONNECTION, "com/obric/capabilitykit/search/global/GlobalSearchClient$connection$1", "Lcom/obric/capabilitykit/search/global/GlobalSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchService;", "bindService", "cancel", "", "businessName", "isCancelled", "timestamp", "startGlobalSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "callback", "Lcom/obric/capabilitykit/search/global/IGlobalSearchCallback;", "stop", "unbindService", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class GlobalSearchClient {

    @NotNull
    public static final GlobalSearchClient INSTANCE = null;
    public static final int NONE_ERROR_ENTITY_TYPE = -1;

    @NotNull
    private static final String TAG = "GlobalSearchClient";

    @NotNull
    private static final ConcurrentHashMap<String, Long> businessMap = null;

    @NotNull
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;

    @NotNull
    private static final Handler mainHandler = null;

    @NotNull
    private static final Queue<Function0<Object>> pendingOperations = null;

    @Nullable
    private static IGlobalSearchService service;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            GlobalSearchClient r12 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(IGlobalSearchService.a.a(r11));
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceConnected " + r10);
            GlobalSearchClient.access$setBound$p(true);
        L4:
            if (GlobalSearchClient.access$getPendingOperations$p().isEmpty() == true) goto L8;
            Function0 r13 = (Function0) GlobalSearchClient.access$getPendingOperations$p().poll();
            if (r13 == null) goto L4;
            r13.invoke();
            goto L4
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceDisconnected " + r10);
            GlobalSearchClient.access$setService$p(null);
            GlobalSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGlobalSearchCallback f11399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GlobalSearchRequest f11401c;

        public static final class a extends com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f11402a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f11403b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IGlobalSearchCallback f11404c;

            public a(String r10, long r11, IGlobalSearchCallback r12) {
                this.f11402a = r10;
                this.f11403b = r11;
                this.f11404c = r12;
            }

            public static /* synthetic */ void a(String r10, long r11, IGlobalSearchCallback r12, GlobalSearchResult r13) {
                h(r10, r11, r12, r13);
            }

            public static /* synthetic */ void b(String r10, long r11, IGlobalSearchCallback r12, int r13) {
                f(r10, r11, r12, r13);
            }

            public static /* synthetic */ void c(String r10, long r11, IGlobalSearchCallback r12, int r13, String r14) {
                g(r10, r11, r12, r13, r14);
            }

            public static /* synthetic */ void d(String r10, long r11, IGlobalSearchCallback r12) {
                e(r10, r11, r12);
            }

            public static final void e(String r10, long r11, IGlobalSearchCallback r12) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onAllCompleted();
                GlobalSearchClient.access$getBusinessMap$p().remove(r10);
                return;
            }

            public static final void f(String r10, long r11, IGlobalSearchCallback r12, int r13) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onCompleted(r13);
                return;
            }

            public static final void g(String r10, long r11, IGlobalSearchCallback r12, int r13, String r14) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                q.g(r14, "$errorMsg");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onError(r13, -1, r14);
                GlobalSearchClient.access$getBusinessMap$p().remove(r10);
                return;
            }

            public static final void h(String r10, long r11, IGlobalSearchCallback r12, GlobalSearchResult r13) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                q.g(r13, "$result");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onSearchResult(r13);
                return;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onAllCompleted");
                Handler r10 = GlobalSearchClient.access$getMainHandler$p();
                final String r11 = this.f11402a;
                final long r12 = this.f11403b;
                final IGlobalSearchCallback r13 = this.f11404c;
                r10.post(new c(r11, r12, r13));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(final int r10) {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onCompleted " + r10);
                Handler r11 = GlobalSearchClient.access$getMainHandler$p();
                final String r12 = this.f11402a;
                final long r13 = this.f11403b;
                final IGlobalSearchCallback r14 = this.f11404c;
                r11.post(new fb.b(r12, r13, r14, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(final int r10, int r11, final String r12) {
                q.g(r12, "errorMsg");
                Logger.INSTANCE.w(GlobalSearchClient.TAG, "onError: " + r10 + TokenParser.SP + r12);
                Handler r13 = GlobalSearchClient.access$getMainHandler$p();
                final String r14 = this.f11402a;
                final long r15 = this.f11403b;
                final IGlobalSearchCallback r16 = this.f11404c;
                r13.post(new d(r14, r15, r16, r10, r12));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(final GlobalSearchResult r10) {
                q.g(r10, "result");
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onSearchResult: " + r10);
                Handler r11 = GlobalSearchClient.access$getMainHandler$p();
                final String r12 = this.f11402a;
                final long r13 = this.f11403b;
                final IGlobalSearchCallback r14 = this.f11404c;
                r11.post(new e(r12, r13, r14, r10));
            }
        }

        public b(IGlobalSearchCallback r10, String r11, GlobalSearchRequest r12) {
            this.f11399a = r10;
            this.f11400b = r11;
            this.f11401c = r12;
            super(0);
        }

        private static final void a(IGlobalSearchCallback r10, Throwable r11) {
            q.g(r10, "$callback");
            q.g(r11, "$e");
            String r12 = r11.getMessage();
            if (r12 != null) goto L5;
            r12 = "";
        L5:
            r10.onError(1, -1, r12);
        }

        public static /* synthetic */ void b(IGlobalSearchCallback r10, Throwable r11) {
            a(r10, r11);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Object invoke() {
        L5:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(GlobalSearchClient.TAG, "exception " + th.getMessage());
            Handler r10 = GlobalSearchClient.access$getMainHandler$p();
            final IGlobalSearchCallback r11 = this.f11399a;
            return Boolean.valueOf(r10.post(new fb.a(r11, th)));
        L3:
            if (GlobalSearchClient.access$getService$p() != null) goto L7;
            this.f11399a.onError(2, -1, "service not ready");     // Catch: Throwable -> L5
        L10:
            return Unit.f21064a;
        L7:
            long r12 = System.currentTimeMillis();     // Catch: Throwable -> L5
            GlobalSearchClient.access$getBusinessMap$p().put(this.f11400b, Long.valueOf(r12));     // Catch: Throwable -> L5
            IGlobalSearchService r13 = GlobalSearchClient.access$getService$p();     // Catch: Throwable -> L5
            if (r13 == null) goto L12;
            r13.startGlobalSearch(this.f11400b, this.f11401c, new a(this.f11400b, r12, this.f11399a));     // Catch: Throwable -> L5
            goto L10
        L12:
            return null;
        }
    }

    static {
        INSTANCE = new GlobalSearchClient();
        context = AppHost.Companion.getApplication().getApplicationContext();
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

    public static final /* synthetic */ boolean access$isCancelled(GlobalSearchClient r10, String r11, long r12) {
        return r10.isCancelled(r11, r12);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r10) {
        isBound = r10;
    }

    public static final /* synthetic */ void access$setService$p(IGlobalSearchService r10) {
        service = r10;
    }

    private final boolean bindService() {
        Logger.INSTANCE.d(TAG, "start bindService");
        Intent r10 = new Intent("com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE");
        List<ResolveInfo> r11 = context.getPackageManager().queryIntentServices(r10, 0);
        q.f(r11, "context.packageManager.q…IntentServices(intent, 0)");
        Iterator<T> r12 = r11.iterator();
    L3:
        String r13 = null;
        if (r12.hasNext() == false) goto L8;
        Object r14 = r12.next();
        if (((ResolveInfo) r14).serviceInfo == null) goto L3;
    L9:
        ResolveInfo r15 = (ResolveInfo) r14;
        if (r15 == null) goto L12;
        ServiceInfo r16 = r15.serviceInfo;
    L13:
        if (r16 != null) goto L16;
        Logger.INSTANCE.e(TAG, "No service found for action: " + r10.getAction());
        return false;
    L16:
        r10.setPackage(r16.packageName);
        boolean r17 = context.bindService(r10, connection, 1);
        if (r17 == true) goto L22;
        Logger r18 = Logger.INSTANCE;
        StringBuilder r19 = new StringBuilder();
        r19.append("not found service ");
        ComponentName r20 = r10.getComponent();
        if (r20 == null) goto L21;
        r13 = r20.getShortClassName();
    L21:
        r19.append(r13);
        r18.w(TAG, r19.toString());
    L22:
        return r17;
    L12:
        r16 = null;
        goto L13
    L8:
        r14 = null;
        goto L9
    }

    private final boolean isCancelled(String r10, long r11) {
        Long r12 = businessMap.get(r10);
        if (r12 != null) goto L6;
    L7:
        Logger.INSTANCE.d(TAG, "ignore expired search");
        return true;
    L6:
        if (r12.longValue() != r11) goto L7;
        return false;
    }

    private final void unbindService() {
        if (isBound == false) goto L6;
        context.unbindService(connection);
        isBound = false;
        return;
    }

    public final void cancel(@NotNull String r10) {
        q.g(r10, "businessName");
        db.a r11 = db.a.f19145a;
        Context r12 = context;
        q.f(r12, "context");
        if (r11.b(r12) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r10);
        if (isBound == false) goto L17;
        IGlobalSearchService r13 = service;     // Catch: RemoteException -> L12
        if (r13 == null) goto L18;
        r13.cancel(r10);     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void startGlobalSearch(@NotNull String r10, @NotNull GlobalSearchRequest r11, @NotNull IGlobalSearchCallback r12) {
        q.g(r10, "businessName");
        q.g(r11, Ext.KEY_REQUEST);
        q.g(r12, "callback");
        db.a r13 = db.a.f19145a;
        Context r14 = context;
        q.f(r14, "context");
        if (r13.b(r14) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip startGlobalSearch");
        r12.onError(6, -1, "Global search service is not available");
        return;
    L6:
        b r15 = new b(r12, r10, r11);
        if (isBound == false) goto L9;
        r15.invoke();
        return;
    L9:
        pendingOperations.add(r15);
        bindService();
    }

    public final void stop() {
        db.a r10 = db.a.f19145a;
        Context r11 = context;
        q.f(r11, "context");
        if (r10.b(r11) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }
}
