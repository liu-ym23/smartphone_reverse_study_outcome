package com.android.server.location.provider.proxy;

import android.content.Context;
import android.location.Location;
import android.location.LocationResult;
import android.location.provider.ILocationProvider;
import android.location.provider.ILocationProviderManager;
import android.location.provider.ProviderProperties;
import android.location.provider.ProviderRequest;
import android.location.util.identity.CallerIdentity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import com.android.internal.util.ConcurrentUtils;
import com.android.server.FgThread;
import com.android.server.location.LocationManagerService;
import com.android.server.location.provider.AbstractLocationProvider;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyLocationProvider extends AbstractLocationProvider implements ServiceWatcher.ServiceListener<CurrentUserServiceSupplier.BoundServiceInfo> {
    private static final String EXTRA_LOCATION_TAGS = "android:location_allow_listed_tags";
    private static final String LOCATION_TAGS_SEPARATOR = ";";
    private static final long RESET_DELAY_MS = 10000;
    CurrentUserServiceSupplier.BoundServiceInfo mBoundServiceInfo;
    final Context mContext;
    final ArrayList<Runnable> mFlushListeners;
    final Object mLock;
    final String mName;
    Proxy mProxy;
    private volatile ProviderRequest mRequest;
    Runnable mResetter;
    final ServiceWatcher mServiceWatcher;

    /* JADX INFO: renamed from: com.android.server.location.provider.proxy.ProxyLocationProvider$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ProxyLocationProvider this$0;

        public static /* synthetic */ AbstractLocationProvider.State $r8$lambda$NpVYyz_7AUBxLdPXQhWgbBcYbjI(AbstractLocationProvider.State r0) {
            return lambda$run$0(r0);
        }

        AnonymousClass1(ProxyLocationProvider this$0) {
            this.this$0 = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mResetter != this) goto L9;
            ProxyLocationProvider.access$000(this.this$0, new ProxyLocationProvider$1$$ExternalSyntheticLambda0());     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private static /* synthetic */ AbstractLocationProvider.State lambda$run$0(AbstractLocationProvider.State prevState) {
            return AbstractLocationProvider.State.EMPTY_STATE;
        }
    }

    private class Proxy extends ILocationProviderManager.Stub {
        final /* synthetic */ ProxyLocationProvider this$0;

        public static /* synthetic */ AbstractLocationProvider.State $r8$lambda$ahStkXOFheXDf68f4rSpZILgStI(boolean r0, ProviderProperties r1, CallerIdentity r2, ArraySet r3, AbstractLocationProvider.State r4) {
            return lambda$onInitialize$0(r0, r1, r2, r3, r4);
        }

        Proxy(ProxyLocationProvider r1) {
            this.this$0 = r1;
        }

        public void onInitialize(final boolean allowed, final ProviderProperties properties, String attributionTag) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mProxy == this) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.this$0.mResetter == null) goto L13;
            FgThread.getHandler().removeCallbacks(this.this$0.mResetter);     // Catch: Throwable -> L8
            this.this$0.mResetter = null;     // Catch: Throwable -> L8
        L13:
            String[] attributionTags = new String[0];     // Catch: Throwable -> L8
            if (this.this$0.mBoundServiceInfo.getMetadata() == null) goto L18;
            String tagsStr = this.this$0.mBoundServiceInfo.getMetadata().getString(ProxyLocationProvider.EXTRA_LOCATION_TAGS);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(tagsStr) == true) goto L18;
            attributionTags = tagsStr.split(ProxyLocationProvider.LOCATION_TAGS_SEPARATOR);     // Catch: Throwable -> L8
            Log.i(LocationManagerService.TAG, this.this$0.mName + " provider loaded extra attribution tags: " + Arrays.toString(attributionTags));     // Catch: Throwable -> L8
        L18:
            final ArraySet<String> extraAttributionTags = new ArraySet(attributionTags);     // Catch: Throwable -> L8
            final CallerIdentity identity = CallerIdentity.fromBinderUnsafe(this.this$0.mBoundServiceInfo.getComponentName().getPackageName(), attributionTag);     // Catch: Throwable -> L8
            ProxyLocationProvider.access$100(this.this$0, new ProxyLocationProvider$Proxy$$ExternalSyntheticLambda0(allowed, properties, identity, extraAttributionTags));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private static /* synthetic */ AbstractLocationProvider.State lambda$onInitialize$0(boolean allowed, ProviderProperties properties, CallerIdentity identity, ArraySet extraAttributionTags, AbstractLocationProvider.State prevState) {
            return AbstractLocationProvider.State.EMPTY_STATE.withAllowed(allowed).withProperties(properties).withIdentity(identity).withExtraAttributionTags(extraAttributionTags);
        }

        public void onSetProperties(ProviderProperties properties) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mProxy == this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            ProxyLocationProvider.access$200(this.this$0, properties);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public void onSetAllowed(boolean allowed) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mProxy == this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            ProxyLocationProvider.access$300(this.this$0, allowed);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public void onReportLocation(Location location) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mProxy == this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            ProxyLocationProvider.access$400(this.this$0, LocationResult.wrap(new Location[]{location}));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public void onReportLocations(List<Location> locations) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mProxy == this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            ProxyLocationProvider.access$500(this.this$0, LocationResult.wrap(locations));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public void onFlushComplete() {
            Runnable callback = null;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mProxy == this) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.this$0.mFlushListeners.isEmpty() == true) goto L13;
            callback = this.this$0.mFlushListeners.remove(0);     // Catch: Throwable -> L8
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L8
            if (callback == null) goto L20;
            callback.run();
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3-LqQvljoygf2rsXpfzafkZBZyc, reason: not valid java name */
    public static /* synthetic */ void m5416$r8$lambda$3LqQvljoygf2rsXpfzafkZBZyc(String r0, Bundle r1, IBinder r2) {
        lambda$onExtraCommand$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$7VMdFID5UKJaFx-7qHYncL9kLJk, reason: not valid java name */
    public static /* synthetic */ void m5417$r8$lambda$7VMdFID5UKJaFx7qHYncL9kLJk(ProviderRequest r0, IBinder r1) {
        lambda$onSetRequest$0(r0, r1);
    }

    static /* synthetic */ void access$000(ProxyLocationProvider x0, UnaryOperator x1) {
        x0.setState(x1);
    }

    static /* synthetic */ void access$100(ProxyLocationProvider x0, UnaryOperator x1) {
        x0.setState(x1);
    }

    static /* synthetic */ void access$200(ProxyLocationProvider x0, ProviderProperties x1) {
        x0.setProperties(x1);
    }

    static /* synthetic */ void access$300(ProxyLocationProvider x0, boolean x1) {
        x0.setAllowed(x1);
    }

    static /* synthetic */ void access$400(ProxyLocationProvider x0, LocationResult x1) {
        x0.reportLocation(x1);
    }

    static /* synthetic */ void access$500(ProxyLocationProvider x0, LocationResult x1) {
        x0.reportLocation(x1);
    }

    public /* bridge */ /* synthetic */ void onBind(IBinder r1, ServiceWatcher.BoundServiceInfo r2) throws RemoteException {
        onBind(r1, (CurrentUserServiceSupplier.BoundServiceInfo) r2);
    }

    public static ProxyLocationProvider create(Context context, String provider, String action, int enableOverlayResId, int nonOverlayPackageResId) {
        ProxyLocationProvider proxy = new ProxyLocationProvider(context, provider, action, enableOverlayResId, nonOverlayPackageResId);
        if (proxy.checkServiceResolves() == false) goto L5;
        return proxy;
    L5:
        return null;
    }

    public static ProxyLocationProvider create(Context context, String provider, String action, int enableOverlayResId, int nonOverlayPackageResId, int unstableOverlayFallbackResId) {
        ProxyLocationProvider proxy = new ProxyLocationProvider(context, provider, action, enableOverlayResId, nonOverlayPackageResId, unstableOverlayFallbackResId);
        if (proxy.checkServiceResolves() == false) goto L5;
        return proxy;
    L5:
        return null;
    }

    private ProxyLocationProvider(Context context, String provider, String action, int enableOverlayResId, int nonOverlayPackageResId) {
        super(ConcurrentUtils.DIRECT_EXECUTOR, null, null, Collections.emptySet());
        this.mLock = new Object();
        this.mFlushListeners = new ArrayList(0);
        this.mContext = context;
        this.mServiceWatcher = ServiceWatcher.create(context, provider, CurrentUserServiceSupplier.createFromConfig(context, action, enableOverlayResId, nonOverlayPackageResId), this);
        this.mName = provider;
        this.mProxy = null;
        this.mRequest = ProviderRequest.EMPTY_REQUEST;
    }

    private ProxyLocationProvider(Context context, String provider, String action, int enableOverlayResId, int nonOverlayPackageResId, int unstableOverlayFallbackResId) {
        super(ConcurrentUtils.DIRECT_EXECUTOR, null, null, Collections.emptySet());
        this.mLock = new Object();
        this.mFlushListeners = new ArrayList(0);
        this.mContext = context;
        boolean unstableFallbackEnabled = context.getResources().getBoolean(unstableOverlayFallbackResId);
        this.mServiceWatcher = ServiceWatcher.create(context, provider, unstableFallbackEnabled, CurrentUserServiceSupplier.createFromConfig(context, action, enableOverlayResId, nonOverlayPackageResId), this);
        this.mName = provider;
        this.mProxy = null;
        this.mRequest = ProviderRequest.EMPTY_REQUEST;
    }

    private boolean checkServiceResolves() {
        return this.mServiceWatcher.checkServiceResolves();
    }

    public void onBind(IBinder binder, CurrentUserServiceSupplier.BoundServiceInfo boundServiceInfo) throws RemoteException {
        ILocationProvider provider = ILocationProvider.Stub.asInterface(binder);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mProxy = new Proxy(this);     // Catch: Throwable -> L7
        this.mBoundServiceInfo = boundServiceInfo;     // Catch: Throwable -> L7
        provider.setLocationProviderManager(this.mProxy);     // Catch: Throwable -> L7
        ProviderRequest request = this.mRequest;     // Catch: Throwable -> L7
        if (request.equals(ProviderRequest.EMPTY_REQUEST) == true) goto L9;
        provider.setRequest(request);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUnbind() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mProxy = null;     // Catch: Throwable -> L8
        this.mBoundServiceInfo = null;     // Catch: Throwable -> L8
        if (this.mResetter != null) goto L10;
        this.mResetter = new AnonymousClass1(this);     // Catch: Throwable -> L8
        FgThread.getHandler().postDelayed(this.mResetter, 10000);     // Catch: Throwable -> L8
    L10:
        Runnable[] flushListeners = (Runnable[]) this.mFlushListeners.toArray(new Runnable[0]);     // Catch: Throwable -> L8
        this.mFlushListeners.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int size = flushListeners.length;
        int i = 0;
    L13:
        if (i >= size) goto L16;
        flushListeners[i].run();
        i = i + 1;
        goto L13
    L16:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onStart() {
        this.mServiceWatcher.register();
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onStop() {
        this.mServiceWatcher.unregister();
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onSetRequest(final ProviderRequest request) {
        this.mRequest = request;
        this.mServiceWatcher.runOnBinder(new ProxyLocationProvider$$ExternalSyntheticLambda1(request));
    }

    private static /* synthetic */ void lambda$onSetRequest$0(ProviderRequest request, IBinder binder) throws RemoteException {
        ILocationProvider provider = ILocationProvider.Stub.asInterface(binder);
        provider.setRequest(request);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onFlush(final Runnable callback) {
        this.mServiceWatcher.runOnBinder(new AnonymousClass2(this, callback));
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    public void onExtraCommand(int uid, int pid, final String command, final Bundle extras) {
        this.mServiceWatcher.runOnBinder(new ProxyLocationProvider$$ExternalSyntheticLambda0(command, extras));
    }

    private static /* synthetic */ void lambda$onExtraCommand$1(String command, Bundle extras, IBinder binder) throws RemoteException {
        ILocationProvider provider = ILocationProvider.Stub.asInterface(binder);
        provider.sendExtraCommand(command, extras);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        this.mServiceWatcher.dump(pw);
    }
}
