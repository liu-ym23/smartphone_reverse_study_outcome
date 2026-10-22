package com.obric.capabilitykit.search;

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
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.search.EntityChangeMonitorRequest;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.entity.search.IEntityChangeCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchService;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.logger.Logger;
import eb.f;
import eb.g;
import eb.h;
import eb.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001aJ\b\u0010-\u001a\u00020\u001aH\u0002J\u0006\u0010.\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/search/InAppSearchClient;", "", "()V", "ACTION_SEARCH_SERVICE", "", "TAG", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", WsConstants.KEY_CONNECTION, "com/obric/capabilitykit/search/InAppSearchClient$connection$1", "Lcom/obric/capabilitykit/search/InAppSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/IInAppSearchService;", "bindService", "cancel", "", "businessName", "isCancelled", "timestamp", "prepareSearch", "queryServicePackagesByAction", "", "action", "registerEntityObserver", "entityChangeMonitorRequest", "Lcom/obric/capabilitykit/entity/search/EntityChangeMonitorRequest;", "callback", "Lcom/obric/capabilitykit/search/IAppEntityChangeCallback;", "startAppSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "stop", "stopSearch", "unbindService", "unregisterEntityObserver", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class InAppSearchClient {

    @NotNull
    private static final String ACTION_SEARCH_SERVICE = "com.obric.memorydata.action.SEARCH_SERVICE";

    @NotNull
    public static final InAppSearchClient INSTANCE = null;

    @NotNull
    private static final String TAG = "InAppSearchClient";

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
    private static IInAppSearchService service;

    public static final class a implements ServiceConnection {
        public a() {
        }

        public static /* synthetic */ void a() {
            b();
        }

        public static final void b() {
        L3:
            if (InAppSearchClient.access$getPendingOperations$p().isEmpty() == true) goto L7;
            Function0 r10 = (Function0) InAppSearchClient.access$getPendingOperations$p().poll();
            if (r10 == null) goto L3;
            r10.invoke();
            goto L3
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            InAppSearchClient r12 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(IInAppSearchService.a.a(r11));
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceConnected " + r10);
            InAppSearchClient.access$setBound$p(true);
            new Thread(new eb.a()).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceDisconnected " + r10);
            InAppSearchClient.access$setService$p(null);
            InAppSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11388a = null;

        static {
            f11388a = new b();
        }

        public b() {
            super(0);
        }

        @Nullable
        public final Unit a() {
            IInAppSearchService r10 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L6
            if (r10 == null) goto L8;
            r10.prepareSearch();     // Catch: Throwable -> L6
            return Unit.f21064a;
        L8:
            return null;
        L6:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            return Unit.f21064a;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAppEntityChangeCallback f11389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EntityChangeMonitorRequest f11390b;

        public static final class a extends IEntityChangeCallback.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IAppEntityChangeCallback f11391a;

            public a(IAppEntityChangeCallback r10) {
                this.f11391a = r10;
            }

            public static /* synthetic */ void a(IAppEntityChangeCallback r10, EntityChangeResult r11) {
                d(r10, r11);
            }

            public static /* synthetic */ void b(IAppEntityChangeCallback r10, int r11, String r12) {
                c(r10, r11, r12);
            }

            public static final void c(IAppEntityChangeCallback r10, int r11, String r12) {
                q.g(r10, "$callback");
                q.g(r12, "$errorMsg");
                r10.onError(r11, r12);
            }

            public static final void d(IAppEntityChangeCallback r10, EntityChangeResult r11) {
                q.g(r10, "$callback");
                q.g(r11, "$result");
                r10.onChange(r11);
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onChange(final EntityChangeResult r10) {
                q.g(r10, "result");
                Handler r11 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r12 = this.f11391a;
                r11.post(new eb.d(r12, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onError(final int r10, final String r11) {
                q.g(r11, "errorMsg");
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r10 + TokenParser.SP + r11);
                Handler r12 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r13 = this.f11391a;
                r12.post(new eb.c(r13, r10, r11));
            }
        }

        public c(IAppEntityChangeCallback r10, EntityChangeMonitorRequest r11) {
            this.f11389a = r10;
            this.f11390b = r11;
            super(0);
        }

        private static final void a(IAppEntityChangeCallback r10, Throwable r11) {
            q.g(r10, "$callback");
            q.g(r11, "$e");
            String r12 = r11.getMessage();
            if (r12 != null) goto L5;
            r12 = "";
        L5:
            r10.onError(1, r12);
        }

        public static /* synthetic */ void b(IAppEntityChangeCallback r10, Throwable r11) {
            a(r10, r11);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Object invoke() {
            db.a r10 = db.a.f19145a;     // Catch: Throwable -> L6
            Context r11 = InAppSearchClient.access$getContext$p();     // Catch: Throwable -> L6
            q.f(r11, "context");     // Catch: Throwable -> L6
            if (r10.c(r11) == MemoryServiceStatus.AVAILABLE) goto L9;
            Logger.INSTANCE.w(InAppSearchClient.TAG, "Memory search service is not available, skip registerEntityObserver");     // Catch: Throwable -> L6
            this.f11389a.onError(6, "Memory search service is disabled");     // Catch: Throwable -> L6
        L14:
            return Unit.f21064a;
        L9:
            if (InAppSearchClient.access$getService$p() != null) goto L11;
            this.f11389a.onError(2, "service not ready");     // Catch: Throwable -> L6
            goto L14
        L11:
            IInAppSearchService r12 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L6
            if (r12 == null) goto L16;
            r12.registerEntityObserver(this.f11390b, new a(this.f11389a));     // Catch: Throwable -> L6
            goto L14
        L16:
            return null;
        L6:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r13 = InAppSearchClient.access$getMainHandler$p();
            final IAppEntityChangeCallback r14 = this.f11389a;
            return Boolean.valueOf(r13.post(new eb.b(r14, th)));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAppSearchCallback f11392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InAppSearchRequest f11394c;

        public static final class a extends IInAppSearchCallback.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f11395a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f11396b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IAppSearchCallback f11397c;

            public a(String r10, long r11, IAppSearchCallback r12) {
                this.f11395a = r10;
                this.f11396b = r11;
                this.f11397c = r12;
            }

            public static /* synthetic */ void a(String r10, long r11, IAppSearchCallback r12) {
                e(r10, r11, r12);
            }

            public static /* synthetic */ void b(String r10, long r11, IAppSearchCallback r12, InAppSearchResultWithoutEntity r13) {
                h(r10, r11, r12, r13);
            }

            public static /* synthetic */ void c(String r10, long r11, IAppSearchCallback r12, int r13, String r14) {
                f(r10, r11, r12, r13, r14);
            }

            public static /* synthetic */ void d(String r10, long r11, IAppSearchCallback r12, InAppSearchResult r13) {
                g(r10, r11, r12, r13);
            }

            public static final void e(String r10, long r11, IAppSearchCallback r12) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onCompleted();
                InAppSearchClient.access$getBusinessMap$p().remove(r10);
                return;
            }

            public static final void f(String r10, long r11, IAppSearchCallback r12, int r13, String r14) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                q.g(r14, "$errorMsg");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onError(r13, r14);
                InAppSearchClient.access$getBusinessMap$p().remove(r10);
                return;
            }

            public static final void g(String r10, long r11, IAppSearchCallback r12, InAppSearchResult r13) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                q.g(r13, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onSearchResult(r13);
                return;
            }

            public static final void h(String r10, long r11, IAppSearchCallback r12, InAppSearchResultWithoutEntity r13) {
                q.g(r10, "$businessName");
                q.g(r12, "$callback");
                q.g(r13, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r10, r11) == true) goto L6;
                r12.onSearchResultWithoutEntity(r13);
                return;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onCompleted() {
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onCompleted");
                Handler r10 = InAppSearchClient.access$getMainHandler$p();
                final String r11 = this.f11395a;
                final long r12 = this.f11396b;
                final IAppSearchCallback r13 = this.f11397c;
                r10.post(new g(r11, r12, r13));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onError(final int r10, final String r11) {
                q.g(r11, "errorMsg");
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r10 + TokenParser.SP + r11);
                Handler r12 = InAppSearchClient.access$getMainHandler$p();
                final String r13 = this.f11395a;
                final long r14 = this.f11396b;
                final IAppSearchCallback r15 = this.f11397c;
                r12.post(new i(r13, r14, r15, r10, r11));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResult(final InAppSearchResult r10) {
                q.g(r10, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResult: " + r10);
                Handler r11 = InAppSearchClient.access$getMainHandler$p();
                final String r12 = this.f11395a;
                final long r13 = this.f11396b;
                final IAppSearchCallback r14 = this.f11397c;
                r11.post(new f(r12, r13, r14, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResultWithoutEntity(final InAppSearchResultWithoutEntity r10) {
                q.g(r10, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResultWithoutEntity");
                Handler r11 = InAppSearchClient.access$getMainHandler$p();
                final String r12 = this.f11395a;
                final long r13 = this.f11396b;
                final IAppSearchCallback r14 = this.f11397c;
                r11.post(new h(r12, r13, r14, r10));
            }
        }

        public d(IAppSearchCallback r10, String r11, InAppSearchRequest r12) {
            this.f11392a = r10;
            this.f11393b = r11;
            this.f11394c = r12;
            super(0);
        }

        private static final void a(IAppSearchCallback r10, Throwable r11) {
            q.g(r10, "$callback");
            q.g(r11, "$e");
            String r12 = r11.getMessage();
            if (r12 != null) goto L5;
            r12 = "";
        L5:
            r10.onError(1, r12);
        }

        public static /* synthetic */ void b(IAppSearchCallback r10, Throwable r11) {
            a(r10, r11);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Object invoke() {
        L5:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r10 = InAppSearchClient.access$getMainHandler$p();
            final IAppSearchCallback r11 = this.f11392a;
            return Boolean.valueOf(r10.post(new eb.e(r11, th)));
        L3:
            if (InAppSearchClient.access$getService$p() != null) goto L7;
            this.f11392a.onError(2, "service not ready");     // Catch: Throwable -> L5
        L10:
            return Unit.f21064a;
        L7:
            long r12 = System.currentTimeMillis();     // Catch: Throwable -> L5
            InAppSearchClient.access$getBusinessMap$p().put(this.f11393b, Long.valueOf(r12));     // Catch: Throwable -> L5
            IInAppSearchService r13 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L5
            if (r13 == null) goto L12;
            r13.startAppSearch(this.f11393b, this.f11394c, new a(this.f11393b, r12, this.f11392a));     // Catch: Throwable -> L5
            goto L10
        L12:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f11398a = null;

        static {
            f11398a = new e();
        }

        public e() {
            super(0);
        }

        @Nullable
        public final Unit a() {
            IInAppSearchService r10 = InAppSearchClient.access$getService$p();     // Catch: RemoteException -> L6
            if (r10 == null) goto L8;
            r10.unregisterEntityObserver();     // Catch: RemoteException -> L6
            return Unit.f21064a;
        L8:
            return null;
        L6:
            e = move-exception;
            e.printStackTrace();
            return Unit.f21064a;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            return a();
        }
    }

    static {
        INSTANCE = new InAppSearchClient();
        context = AppHost.Companion.getApplication().getApplicationContext();
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

    public static final /* synthetic */ boolean access$isCancelled(InAppSearchClient r10, String r11, long r12) {
        return r10.isCancelled(r11, r12);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r10) {
        isBound = r10;
    }

    public static final /* synthetic */ void access$setService$p(IInAppSearchService r10) {
        service = r10;
    }

    private final boolean bindService() {
        Logger r10 = Logger.INSTANCE;
        r10.d(TAG, "start bindService");
        Context r11 = context;
        q.f(r11, "context");
        List<String> r12 = queryServicePackagesByAction(r11, ACTION_SEARCH_SERVICE);
        if (r12.size() != 1) goto L12;
        Intent r13 = new Intent(ACTION_SEARCH_SERVICE);
        r13.setPackage((String) b0.Y(r12));
        boolean r14 = r11.bindService(r13, connection, 1);
        if (r14 == true) goto L11;
        StringBuilder r15 = new StringBuilder();
        r15.append("not found service ");
        ComponentName r16 = r13.getComponent();
        if (r16 == null) goto L9;
        String r17 = r16.getShortClassName();
    L10:
        r15.append(r17);
        r10.w(TAG, r15.toString());
        goto L11
    L9:
        r17 = null;
    L11:
        return r14;
    L12:
        r10.w(TAG, "not found service com.obric.memorydata.action.SEARCH_SERVICE, result = " + r12);
        return false;
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
        if (r11.c(r12) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r10);
        if (isBound == false) goto L17;
        IInAppSearchService r13 = service;     // Catch: RemoteException -> L12
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

    public final void prepareSearch() {
        db.a r10 = db.a.f19145a;
        Context r11 = context;
        q.f(r11, "context");
        if (r10.c(r11) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip prepareSearch");
        return;
    L6:
        b r12 = b.f11388a;
        if (isBound == false) goto L9;
        r12.invoke();
        return;
    L9:
        pendingOperations.add(r12);
        bindService();
    }

    @NotNull
    public final List<String> queryServicePackagesByAction(@NotNull Context r10, @NotNull String r11) {
        q.g(r10, "context");
        q.g(r11, "action");
        Intent r12 = new Intent(r11);
        List<ResolveInfo> r13 = r10.getPackageManager().queryIntentServices(r12, UiType.FLAG_PHONE_CARD);
        q.f(r13, "pm.queryIntentServices(i…PackageManager.MATCH_ALL)");
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L12;
        ServiceInfo r16 = ((ResolveInfo) r15.next()).serviceInfo;
        if (r16 == null) goto L8;
        String r17 = r16.packageName;
    L9:
        if (r17 == null) goto L4;
        r14.add(r17);
        goto L4
    L8:
        r17 = null;
        goto L9
    L12:
        return b0.T(r14);
    }

    public final void registerEntityObserver(@NotNull EntityChangeMonitorRequest r10, @NotNull IAppEntityChangeCallback r11) {
        q.g(r10, "entityChangeMonitorRequest");
        q.g(r11, "callback");
        c r12 = new c(r11, r10);
        if (isBound == false) goto L5;
        r12.invoke();
        return;
    L5:
        pendingOperations.add(r12);
        bindService();
    }

    public final void startAppSearch(@NotNull String r10, @NotNull InAppSearchRequest r11, @NotNull IAppSearchCallback r12) {
        q.g(r10, "businessName");
        q.g(r11, Ext.KEY_REQUEST);
        q.g(r12, "callback");
        db.a r13 = db.a.f19145a;
        Context r14 = context;
        q.f(r14, "context");
        if (r13.c(r14) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip startAppSearch");
        r12.onError(6, "Memory search service is disabled");
        return;
    L6:
        d r15 = new d(r12, r10, r11);
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
        if (r10.c(r11) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }

    public final void stopSearch() {
        db.a r10 = db.a.f19145a;
        Context r11 = context;
        q.f(r11, "context");
        if (r10.c(r11) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stopSearch");
        return;
    L7:
        if (isBound == false) goto L17;
        IInAppSearchService r12 = service;     // Catch: RemoteException -> L12
        if (r12 == null) goto L18;
        r12.stopSearch();     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void unregisterEntityObserver() {
        db.a r10 = db.a.f19145a;
        Context r11 = context;
        q.f(r11, "context");
        if (r10.c(r11) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip unregisterEntityObserver");
        return;
    L6:
        e r12 = e.f11398a;
        if (isBound == false) goto L9;
        r12.invoke();
        return;
    L9:
        pendingOperations.add(r12);
        bindService();
    }
}
