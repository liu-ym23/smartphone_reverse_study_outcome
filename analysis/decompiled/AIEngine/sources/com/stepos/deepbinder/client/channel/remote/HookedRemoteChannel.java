package com.stepos.deepbinder.client.channel.remote;

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
import com.stepos.core.ability.e;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.core.api.IRemoteService;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import gc.q;
import gc.r;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class HookedRemoteChannel extends com.stepos.deepbinder.client.channel.remote.a {
    private static final String TAG = "HookedRemoteChannel";
    private final ActivityThread activityThread;
    private final ContentResolver contentResolver;
    private final ComponentName remoteComponentName;
    private final Uri remoteProviderUri;
    private IRemoteService remoteService;
    public static final a Companion = new a();
    private static final CopyOnWriteArraySet<ComponentName> processDeathSet = new CopyOnWriteArraySet<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @f.a
    public static final class HookedBinderDeathRecipient implements IBinder.DeathRecipient {
        private final ComponentName remoteComponentName;
        private final IRemoteService remoteService;

        public HookedBinderDeathRecipient(IRemoteService remoteService, ComponentName componentName) {
            g.f(remoteService, "remoteService");
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
                                i9.a.a(componentName);
                                HookedRemoteChannel.processDeathSet.remove(componentName);
                                String str = x9.c.c(componentName).f13759a;
                                n9.b bVar = n9.b.f10675a;
                                g.c(str);
                                IPCLog iPCLog = IPCLog.INSTANCE;
                                iPCLog.d("CallbackCache", "[notifyCallbackToRecycle]", "processName", str);
                                n9.b.f10676b.entrySet().removeIf(new b9.b(new e(str, 4), 9));
                                iPCLog.i(HookedRemoteChannel.TAG, "[binderDied] processName: ".concat(str), new Object[0]);
                            }
                            n nVar = n.f10413a;
                        }
                    } finally {
                    }
                }
                this.remoteService.asBinder().unlinkToDeath(this, 0);
                DeepBinderClient deepBinderClient = DeepBinderClient.INSTANCE;
                ComponentName componentName2 = this.remoteComponentName;
                g.c(componentName2);
                deepBinderClient.disconnect(componentName2);
            } catch (Throwable th) {
                IPCLog.INSTANCE.w(HookedRemoteChannel.TAG, "[binderDied] exception: " + th, new Object[0]);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public HookedRemoteChannel(ComponentName remoteComponentName) {
        g.f(remoteComponentName, "remoteComponentName");
        this.remoteComponentName = remoteComponentName;
        this.activityThread = ActivityThread.currentActivityThread();
        ContentResolver contentResolver = DeepBinderClient.INSTANCE.getContext().getContentResolver();
        g.e(contentResolver, "getContentResolver(...)");
        this.contentResolver = contentResolver;
        Uri uri = x9.c.c(remoteComponentName).f13761c;
        com.stepos.deepbinder.client.channel.remote.a.Companion.getClass();
        com.stepos.deepbinder.client.channel.remote.a.cacheUri = uri;
        g.c(uri);
        this.remoteProviderUri = uri;
        i9.a.b(uri);
    }

    @SuppressLint({"BlockedPrivateApi"})
    private final void forceBinderGc() {
        try {
            Method declaredMethod = Class.forName("com.android.internal.os.BinderInternal").getDeclaredMethod("forceBinderGc", null);
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
            String authority = uri.getAuthority();
            g.c(authority);
            String strH0 = q.H0(authority, '@', authority);
            String authority2 = uri.getAuthority();
            g.c(authority2);
            int iHashCode = Process.myUserHandle().hashCode();
            int iV0 = q.v0(authority2, '@', 0, 6);
            if (iV0 != -1) {
                try {
                    iHashCode = Integer.parseInt(r.R0(iV0, authority2));
                } catch (NumberFormatException unused) {
                }
            }
            iContentProviderAcquireProvider = activityThread.acquireProvider(context, strH0, iHashCode, false);
        } catch (Throwable th) {
            IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireProvider1] exception: " + th, new Object[0]);
            iContentProviderAcquireProvider = null;
        }
        if (iContentProviderAcquireProvider == null) {
            try {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = DeepBinderClient.INSTANCE.getContext().getContentResolver().acquireUnstableContentProviderClient(uri);
                Field declaredField = ContentProviderClient.class.getDeclaredField("mContentProvider");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(contentProviderClientAcquireUnstableContentProviderClient);
                iContentProviderAcquireProvider = obj instanceof IContentProvider ? (IContentProvider) obj : null;
            } catch (Throwable th2) {
                IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireUnstableProvider2] exception: " + th2, new Object[0]);
            }
        }
        if (iContentProviderAcquireProvider == null) {
            try {
                Method declaredMethod = ContentResolver.class.getDeclaredMethod("acquireUnstableProvider", Uri.class);
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
                Method declaredMethod2 = ContentResolver.class.getDeclaredMethod("acquireUnstableProvider", String.class);
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
            Method declaredMethod3 = ContentResolver.class.getDeclaredMethod("acquireUnstableProvider", Context.class, String.class);
            declaredMethod3.setAccessible(true);
            Object objInvoke3 = declaredMethod3.invoke(this.contentResolver, DeepBinderClient.INSTANCE.getContext(), authority4);
            return objInvoke3 instanceof IContentProvider ? (IContentProvider) objInvoke3 : null;
        } catch (Throwable th5) {
            IPCLog.INSTANCE.w(TAG, "[getRemoteService][acquireUnstableProvider5] exception: " + th5, new Object[0]);
            return iContentProviderAcquireProvider;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.deepbinder.core.api.IRemoteService getRemoteService(android.net.Uri r6) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.client.channel.remote.HookedRemoteChannel.getRemoteService(android.net.Uri):com.stepos.deepbinder.core.api.IRemoteService");
    }

    private final void throwIPCException(Throwable th) throws Throwable {
        if (th instanceof IPCException) {
            throw th;
        }
        if (!(th instanceof RemoteException)) {
            throw new IPCException(9, th);
        }
        throw new IPCException(1, th);
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
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

    @Override // o9.b
    public void internalRecycle(Long[] ids) throws Throwable {
        g.f(ids, "ids");
        try {
            getRemoteService(this.remoteProviderUri).recycle(Process.myPid(), l.r0(ids));
        } catch (Throwable th) {
            if (!(th instanceof DeadObjectException)) {
                throwIPCException(th);
            } else {
                forceBinderGc();
                getRemoteService(this.remoteProviderUri).recycle(Process.myPid(), l.r0(ids));
            }
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public Reply internalSendCall(Call call) throws Throwable {
        g.f(call, "call");
        try {
            return getRemoteService(this.remoteProviderUri).sendCall(call);
        } catch (Throwable th) {
            if (th instanceof DeadObjectException) {
                this.forceBinderGc();
                return this.getRemoteService(this.remoteProviderUri).sendCall(call);
            }
            this.throwIPCException(th);
            return Reply.CREATOR.obtain();
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public void release() {
        IPCLog.INSTANCE.i(TAG, "release " + this.remoteService, new Object[0]);
        IRemoteService iRemoteService = this.remoteService;
        if (iRemoteService != null) {
            iRemoteService.disconnect();
        }
        this.remoteService = null;
    }
}
