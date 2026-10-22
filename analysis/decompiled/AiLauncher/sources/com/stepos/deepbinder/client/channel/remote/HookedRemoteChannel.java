package com.stepos.deepbinder.client.channel.remote;

import Y8.t;
import Z8.r;
import android.annotation.SuppressLint;
import android.app.ActivityThread;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.net.Uri;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.cache.ListenerCache;
import com.stepos.deepbinder.core.api.IRemoteService;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.utils.IPCUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u001d\u0010\u0019\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u001c\u0010$\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/stepos/deepbinder/client/channel/remote/HookedRemoteChannel;", "Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "Landroid/content/ComponentName;", "remoteComponentName", "<init>", "(Landroid/content/ComponentName;)V", "LY8/t;", Constants.FORCE_BINDER_GC, "()V", "Landroid/net/Uri;", "uri", "Landroid/content/IContentProvider;", "getContentProvider", "(Landroid/net/Uri;)Landroid/content/IContentProvider;", "Lcom/stepos/deepbinder/core/api/IRemoteService;", "getRemoteService", "(Landroid/net/Uri;)Lcom/stepos/deepbinder/core/api/IRemoteService;", "", "t", "throwIPCException", "(Ljava/lang/Throwable;)V", "internalConnect", "", "", "ids", "internalRecycle", "([Ljava/lang/Long;)V", "Lcom/stepos/deepbinder/core/entity/Call;", "call", "Lcom/stepos/deepbinder/core/entity/Reply;", "internalSendCall", "(Lcom/stepos/deepbinder/core/entity/Call;)Lcom/stepos/deepbinder/core/entity/Reply;", "release", "Landroid/content/ComponentName;", "Landroid/app/ActivityThread;", "kotlin.jvm.PlatformType", "activityThread", "Landroid/app/ActivityThread;", "Landroid/content/ContentResolver;", "contentResolver", "Landroid/content/ContentResolver;", "remoteProviderUri", "Landroid/net/Uri;", "remoteService", "Lcom/stepos/deepbinder/core/api/IRemoteService;", "Companion", "HookedBinderDeathRecipient", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HookedRemoteChannel extends BaseRemoteChannel {
    private static final String TAG = "HookedRemoteChannel";
    private final ActivityThread activityThread;
    private final ContentResolver contentResolver;
    private final ComponentName remoteComponentName;
    private final Uri remoteProviderUri;
    private IRemoteService remoteService;
    private static final CopyOnWriteArraySet<ComponentName> processDeathSet = new CopyOnWriteArraySet<>();

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/deepbinder/client/channel/remote/HookedRemoteChannel$HookedBinderDeathRecipient;", "Landroid/os/IBinder$DeathRecipient;", "Lcom/stepos/deepbinder/core/api/IRemoteService;", "remoteService", "Landroid/content/ComponentName;", "remoteComponentName", "<init>", "(Lcom/stepos/deepbinder/core/api/IRemoteService;Landroid/content/ComponentName;)V", "LY8/t;", "binderDied", "()V", "Lcom/stepos/deepbinder/core/api/IRemoteService;", "Landroid/content/ComponentName;", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HookedBinderDeathRecipient implements IBinder.DeathRecipient {
        private final ComponentName remoteComponentName;
        private final IRemoteService remoteService;

        public HookedBinderDeathRecipient(IRemoteService remoteService, ComponentName componentName) {
            p.i(remoteService, "remoteService");
            this.remoteService = remoteService;
            this.remoteComponentName = componentName;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            try {
                synchronized (HookedRemoteChannel.class) {
                    try {
                        ComponentName componentName = this.remoteComponentName;
                        if (componentName != null) {
                            if (HookedRemoteChannel.processDeathSet.contains(componentName)) {
                                ListenerCache.INSTANCE.getInstance().notifyProcessDisconnect(componentName);
                                HookedRemoteChannel.processDeathSet.remove(componentName);
                                String processName = IPCUtils.INSTANCE.queryComponentInternalInfoFromProvider(componentName).getProcessName();
                                CallbackCache callbackCache = CallbackCache.INSTANCE;
                                p.f(processName);
                                callbackCache.notifyCallbackToRecycle(processName);
                                IPCLog.INSTANCE.i(HookedRemoteChannel.TAG, "[binderDied] processName: " + processName, new Object[0]);
                            }
                            t tVar = t.f7040a;
                        }
                    } finally {
                    }
                }
                this.remoteService.asBinder().unlinkToDeath(this, 0);
                DeepBinderClient deepBinderClient = DeepBinderClient.INSTANCE;
                ComponentName componentName2 = this.remoteComponentName;
                p.f(componentName2);
                deepBinderClient.disconnect(componentName2);
            } catch (Throwable th) {
                IPCLog.INSTANCE.w(HookedRemoteChannel.TAG, "[binderDied] exception: " + th, new Object[0]);
            }
        }
    }

    public HookedRemoteChannel(ComponentName remoteComponentName) {
        p.i(remoteComponentName, "remoteComponentName");
        this.remoteComponentName = remoteComponentName;
        this.activityThread = ActivityThread.currentActivityThread();
        ContentResolver contentResolver = DeepBinderClient.INSTANCE.getContext().getContentResolver();
        p.h(contentResolver, "getContentResolver(...)");
        this.contentResolver = contentResolver;
        Uri authority = IPCUtils.INSTANCE.queryComponentInternalInfoFromProvider(remoteComponentName).getAuthority();
        BaseRemoteChannel.INSTANCE.setCacheUri(authority);
        p.f(authority);
        this.remoteProviderUri = authority;
        ListenerCache.INSTANCE.getInstance().registerProviderObserver(authority);
    }

    @SuppressLint({"BlockedPrivateApi"})
    private final void forceBinderGc() {
        try {
            Method declaredMethod = Class.forName(Constants.BINDER_INTERNAL_CLASS).getDeclaredMethod(Constants.FORCE_BINDER_GC, null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, null);
        } catch (Throwable th) {
            IPCLog.INSTANCE.e(TAG, "[forceBinderGc] exception: " + th, new Object[0]);
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private final IContentProvider getContentProvider(Uri uri) {
        IContentProvider iContentProviderAcquireProvider;
        try {
            ActivityThread activityThread = this.activityThread;
            Application context = DeepBinderClient.INSTANCE.getContext();
            IPCUtils iPCUtils = IPCUtils.INSTANCE;
            String authority = uri.getAuthority();
            p.f(authority);
            String authorityWithoutUserId = iPCUtils.getAuthorityWithoutUserId(authority);
            String authority2 = uri.getAuthority();
            p.f(authority2);
            iContentProviderAcquireProvider = activityThread.acquireProvider(context, authorityWithoutUserId, iPCUtils.getUserIdFromAuthority(authority2, Process.myUserHandle().hashCode()), false);
        } catch (Throwable th) {
            IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireProvider1] exception: " + th, new Object[0]);
            iContentProviderAcquireProvider = null;
        }
        if (iContentProviderAcquireProvider == null) {
            try {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = DeepBinderClient.INSTANCE.getContext().getContentResolver().acquireUnstableContentProviderClient(uri);
                Field declaredField = ContentProviderClient.class.getDeclaredField(Constants.CONTENT_PROVIDER);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(contentProviderClientAcquireUnstableContentProviderClient);
                iContentProviderAcquireProvider = obj instanceof IContentProvider ? (IContentProvider) obj : null;
            } catch (Throwable th2) {
                IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireUnstableProvider2] exception: " + th2, new Object[0]);
            }
        }
        if (iContentProviderAcquireProvider == null) {
            try {
                Method declaredMethod = ContentResolver.class.getDeclaredMethod(Constants.ACQUIRE_UNSTABLE_PROVIDER, Uri.class);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(this.contentResolver, uri);
                iContentProviderAcquireProvider = objInvoke instanceof IContentProvider ? (IContentProvider) objInvoke : null;
            } catch (Throwable th3) {
                IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireUnstableProvider3] exception: " + th3, new Object[0]);
            }
        }
        if (iContentProviderAcquireProvider == null) {
            try {
                String authority3 = uri.getAuthority();
                Method declaredMethod2 = ContentResolver.class.getDeclaredMethod(Constants.ACQUIRE_UNSTABLE_PROVIDER, String.class);
                declaredMethod2.setAccessible(true);
                Object objInvoke2 = declaredMethod2.invoke(this.contentResolver, authority3);
                iContentProviderAcquireProvider = objInvoke2 instanceof IContentProvider ? (IContentProvider) objInvoke2 : null;
            } catch (Throwable th4) {
                IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireUnstableProvider4] exception: " + th4, new Object[0]);
            }
        }
        if (iContentProviderAcquireProvider != null) {
            return iContentProviderAcquireProvider;
        }
        try {
            String authority4 = uri.getAuthority();
            Method declaredMethod3 = ContentResolver.class.getDeclaredMethod(Constants.ACQUIRE_UNSTABLE_PROVIDER, Context.class, String.class);
            declaredMethod3.setAccessible(true);
            Object objInvoke3 = declaredMethod3.invoke(this.contentResolver, DeepBinderClient.INSTANCE.getContext(), authority4);
            return objInvoke3 instanceof IContentProvider ? (IContentProvider) objInvoke3 : null;
        } catch (Throwable th5) {
            IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireUnstableProvider5] exception: " + th5, new Object[0]);
            return iContentProviderAcquireProvider;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.deepbinder.core.api.IRemoteService getRemoteService(android.net.Uri r6) throws android.os.RemoteException {
        /*
            r5 = this;
            com.stepos.deepbinder.core.api.IRemoteService r0 = r5.remoteService
            java.lang.String r1 = "HookedRemoteChannel"
            r2 = 0
            if (r0 == 0) goto L1f
            kotlin.jvm.internal.p.f(r0)
            boolean r0 = r0.isRemote()
            if (r0 == 0) goto L4c
            com.stepos.deepbinder.core.api.IRemoteService r0 = r5.remoteService
            kotlin.jvm.internal.p.f(r0)
            android.os.IBinder r0 = r0.asBinder()
            boolean r0 = r0.isBinderAlive()
            if (r0 != 0) goto L4c
        L1f:
            com.stepos.deepbinder.core.api.IRemoteService r0 = r5.remoteService
            if (r0 == 0) goto L26
            r5.release()
        L26:
            android.content.IContentProvider r6 = r5.getContentProvider(r6)
            if (r6 == 0) goto L9e
            com.stepos.deepbinder.client.proxy.RemoteServiceProxy$Companion r0 = com.stepos.deepbinder.client.proxy.RemoteServiceProxy.INSTANCE
            com.stepos.deepbinder.core.api.IRemoteService r6 = r0.getProxy(r6)
            r5.remoteService = r6
            com.stepos.deepbinder.core.log.IPCLog r0 = com.stepos.deepbinder.core.log.IPCLog.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[getRemoteService][success] "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.i(r1, r6, r3)
        L4c:
            com.stepos.deepbinder.core.api.IRemoteService r6 = r5.remoteService
            kotlin.jvm.internal.p.f(r6)
            boolean r6 = r6.isRemote()
            if (r6 == 0) goto L98
            java.util.concurrent.CopyOnWriteArraySet<android.content.ComponentName> r6 = com.stepos.deepbinder.client.channel.remote.HookedRemoteChannel.processDeathSet
            android.content.ComponentName r0 = r5.remoteComponentName
            boolean r0 = r6.contains(r0)
            if (r0 != 0) goto L98
            android.content.ComponentName r0 = r5.remoteComponentName
            r6.add(r0)
            com.stepos.deepbinder.core.api.IRemoteService r6 = r5.remoteService     // Catch: android.os.RemoteException -> L7f
            kotlin.jvm.internal.p.f(r6)     // Catch: android.os.RemoteException -> L7f
            android.os.IBinder r6 = r6.asBinder()     // Catch: android.os.RemoteException -> L7f
            com.stepos.deepbinder.client.channel.remote.HookedRemoteChannel$HookedBinderDeathRecipient r0 = new com.stepos.deepbinder.client.channel.remote.HookedRemoteChannel$HookedBinderDeathRecipient     // Catch: android.os.RemoteException -> L7f
            com.stepos.deepbinder.core.api.IRemoteService r3 = r5.remoteService     // Catch: android.os.RemoteException -> L7f
            kotlin.jvm.internal.p.f(r3)     // Catch: android.os.RemoteException -> L7f
            android.content.ComponentName r4 = r5.remoteComponentName     // Catch: android.os.RemoteException -> L7f
            r0.<init>(r3, r4)     // Catch: android.os.RemoteException -> L7f
            r6.linkToDeath(r0, r2)     // Catch: android.os.RemoteException -> L7f
            goto L98
        L7f:
            r6 = move-exception
            com.stepos.deepbinder.core.log.IPCLog r0 = com.stepos.deepbinder.core.log.IPCLog.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[getRemoteService][linkToDeath] exception: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.e(r1, r6, r2)
        L98:
            com.stepos.deepbinder.core.api.IRemoteService r5 = r5.remoteService
            kotlin.jvm.internal.p.f(r5)
            return r5
        L9e:
            com.stepos.deepbinder.core.log.IPCLog r5 = com.stepos.deepbinder.core.log.IPCLog.INSTANCE
            java.lang.String r6 = "[getRemoteService][fail]"
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r5.w(r1, r6, r0)
            com.stepos.deepbinder.core.exception.IPCException r5 = new com.stepos.deepbinder.core.exception.IPCException
            r6 = 19
            java.lang.String r0 = "can't get content provider"
            r5.<init>(r6, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.client.channel.remote.HookedRemoteChannel.getRemoteService(android.net.Uri):com.stepos.deepbinder.core.api.IRemoteService");
    }

    private final void throwIPCException(Throwable t10) throws Throwable {
        if (t10 instanceof IPCException) {
            throw t10;
        }
        if (!(t10 instanceof RemoteException)) {
            throw new IPCException(9, t10);
        }
        throw new IPCException(1, t10);
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public void internalConnect() throws Throwable {
        try {
            getRemoteService(this.remoteProviderUri).connect();
        } catch (Throwable th) {
            if (!(th instanceof DeadObjectException)) {
                throwIPCException(th);
            } else {
                forceBinderGc();
                getRemoteService(this.remoteProviderUri).connect();
            }
        }
    }

    @Override // com.stepos.deepbinder.core.channel.IChannel
    public void internalRecycle(Long[] ids) throws Throwable {
        p.i(ids, "ids");
        try {
            getRemoteService(this.remoteProviderUri).recycle(Process.myPid(), r.W0(ids));
        } catch (Throwable th) {
            if (!(th instanceof DeadObjectException)) {
                throwIPCException(th);
            } else {
                forceBinderGc();
                getRemoteService(this.remoteProviderUri).recycle(Process.myPid(), r.W0(ids));
            }
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public Reply internalSendCall(Call call) throws Throwable {
        p.i(call, "call");
        try {
            return getRemoteService(this.remoteProviderUri).sendCall(call);
        } catch (Throwable th) {
            if (th instanceof DeadObjectException) {
                this.forceBinderGc();
                return this.getRemoteService(this.remoteProviderUri).sendCall(call);
            }
            this.throwIPCException(th);
            return Reply.INSTANCE.obtain();
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public void release() {
        IPCLog.INSTANCE.i(TAG, "release " + this.remoteService, new Object[0]);
        IRemoteService iRemoteService = this.remoteService;
        if (iRemoteService != null) {
            iRemoteService.disconnect();
        }
        this.remoteService = null;
    }
}
