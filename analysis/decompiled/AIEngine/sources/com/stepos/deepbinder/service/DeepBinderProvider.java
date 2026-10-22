package com.stepos.deepbinder.service;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetFileDescriptor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallback;
import androidx.appcompat.widget.y0;
import androidx.room.o;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.api.IRemoteService;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.service.cache.ServiceCache;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import w9.e;
import x9.c;
import y9.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public class DeepBinderProvider extends ContentProvider implements IRemoteService {
    public static final a Companion = new a();
    private static final String TAG = "DeepBinderProvider";
    private final AtomicBoolean isConnectFlag = new AtomicBoolean(false);

    @f.a
    private final HookContentProvider mHookIContentProvider = new HookContentProvider();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @f.a
    public final class HookContentProvider extends Binder implements IContentProvider {
        /* JADX WARN: Multi-variable type inference failed */
        public HookContentProvider() {
            attachInterface(this, "android.content.IContentProvider");
        }

        public ContentProviderResult[] applyBatch(AttributionSource attributionSource, String str, ArrayList<ContentProviderOperation> arrayList) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public int bulkInsert(AttributionSource attributionSource, Uri uri, ContentValues[] contentValuesArr) {
            g.f(attributionSource, "attributionSource");
            return 0;
        }

        public Bundle call(AttributionSource attributionSource, String str, String str2, String str3, Bundle bundle) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public Uri canonicalize(AttributionSource attributionSource, Uri uri) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public void canonicalizeAsync(AttributionSource attributionSource, Uri uri, RemoteCallback remoteCallback) {
            g.f(attributionSource, "attributionSource");
        }

        public int checkUriPermission(AttributionSource attributionSource, Uri uri, int i10, int i11) {
            g.f(attributionSource, "attributionSource");
            return 0;
        }

        public ICancellationSignal createCancellationSignal() {
            return null;
        }

        public int delete(AttributionSource attributionSource, Uri uri, Bundle bundle) {
            g.f(attributionSource, "attributionSource");
            return 0;
        }

        public final String getProviderName() {
            return DeepBinderProvider.this.getClass().getName();
        }

        public String[] getStreamTypes(AttributionSource attributionSource, Uri uri, String str) {
            return null;
        }

        public String getType(AttributionSource attributionSource, Uri uri) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public void getTypeAsync(AttributionSource attributionSource, Uri uri, RemoteCallback remoteCallback) {
            g.f(attributionSource, "attributionSource");
        }

        public Uri insert(AttributionSource attributionSource, Uri uri, ContentValues contentValues, Bundle bundle) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        @Override // android.os.Binder
        @f.a
        public boolean onTransact(int i10, Parcel data, Parcel parcel, int i11) {
            Bundle bundle;
            g.f(data, "data");
            if (i10 == 0) {
                Reply replyProcessMethodSend = DeepBinderProvider.this.processMethodSend(Call.CREATOR.createFromParcel(data));
                if (replyProcessMethodSend != null) {
                    g.c(parcel);
                    replyProcessMethodSend.writeToParcel(parcel, 0);
                }
            } else if (i10 == 1) {
                IPCLog.INSTANCE.i(DeepBinderProvider.TAG, "[onTransact][connect]", new Object[0]);
                DeepBinderProvider.this.connect();
            } else if (i10 == 2) {
                IPCLog.INSTANCE.i(DeepBinderProvider.TAG, "[onTransact][recycleRemote]", new Object[0]);
                DeepBinderProvider.this.processMethodRecycleRemote(data.createLongArray(), data.readInt());
            } else if (i10 == 21) {
                try {
                    data.enforceInterface("android.content.IContentProvider");
                    data.setDataPosition(data.dataPosition() + data.readInt());
                    data.readString();
                    String string = data.readString();
                    String string2 = data.readString();
                    Bundle bundle2 = data.readBundle(HookContentProvider.class.getClassLoader());
                    int i12 = bundle2 != null ? bundle2.getInt("protocolVersion", 2) : 2;
                    if (string != null) {
                        bundle = DeepBinderProvider.this.call(string, string2, bundle2);
                    } else {
                        bundle = new Bundle();
                        bundle.putParcelable("reply", Reply.CREATOR.obtain().withProtocolVersion(i12).withIPCException(new IPCException(38, "read method null from default call parcel.")));
                    }
                    if (parcel != null) {
                        parcel.writeNoException();
                    }
                    if (parcel != null) {
                        parcel.writeBundle(bundle);
                    }
                } catch (Throwable th) {
                    IPCLog.INSTANCE.w(DeepBinderProvider.TAG, "[onTransact][callTransaction]", "exception", th);
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("reply", Reply.CREATOR.obtain().withProtocolVersion(2).withIPCException(new IPCException(39, th)));
                    if (parcel != null) {
                        parcel.writeNoException();
                    }
                    if (parcel != null) {
                        parcel.writeBundle(bundle3);
                    }
                }
            }
            return true;
        }

        public AssetFileDescriptor openAssetFile(AttributionSource attributionSource, Uri uri, String str, ICancellationSignal iCancellationSignal) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public ParcelFileDescriptor openFile(AttributionSource attributionSource, Uri uri, String str, ICancellationSignal iCancellationSignal) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public AssetFileDescriptor openTypedAssetFile(AttributionSource attributionSource, Uri uri, String str, Bundle bundle, ICancellationSignal iCancellationSignal) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public Cursor query(AttributionSource attributionSource, Uri uri, String[] strArr, Bundle bundle, ICancellationSignal iCancellationSignal) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public boolean refresh(AttributionSource attributionSource, Uri uri, Bundle bundle, ICancellationSignal iCancellationSignal) {
            g.f(attributionSource, "attributionSource");
            return false;
        }

        public Uri uncanonicalize(AttributionSource attributionSource, Uri uri) {
            g.f(attributionSource, "attributionSource");
            return null;
        }

        public void uncanonicalizeAsync(AttributionSource attributionSource, Uri uri, RemoteCallback remoteCallback) {
            g.f(attributionSource, "attributionSource");
        }

        public int update(AttributionSource attributionSource, Uri uri, ContentValues contentValues, Bundle bundle) {
            g.f(attributionSource, "attributionSource");
            return 0;
        }

        public Bundle call(String str, String str2, String str3, Bundle bundle) {
            DeepBinderProvider deepBinderProvider = DeepBinderProvider.this;
            if (str2 == null) {
                str2 = "";
            }
            return deepBinderProvider.call(str2, str3, bundle);
        }

        public IBinder asBinder() {
            return this;
        }

        public void getTypeAnonymousAsync(Uri uri, RemoteCallback remoteCallback) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f7639a;

        public b(Application application) {
            this.f7639a = application;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f7639a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this.f7639a.unbindService(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connect$lambda$4(DeepBinderProvider deepBinderProvider) {
        try {
            x9.a aVarC = c.c(new ComponentName(DeepBinderInternal.getContext(), deepBinderProvider.getClass()));
            String name = aVarC.f13760b;
            DeepBinderInternal.getContext().getContentResolver().notifyChange(Uri.parse("content://" + aVarC.f13761c), (ContentObserver) null, 32768);
            Application context = DeepBinderInternal.getContext();
            if (name == null || name.length() != 0) {
                g.c(name);
            } else {
                name = ProcessStateService.class.getName();
            }
            ComponentName componentName = new ComponentName(context.getPackageName(), name);
            if (c.a().equals(c.e(componentName))) {
                context.bindService(new Intent().setComponent(componentName), new b(context), 1);
            }
        } catch (Exception e10) {
            IPCLog.INSTANCE.e(TAG, "[connect][notify]", "exception", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processMethodRecycleRemote(long[] jArr, int i10) {
        try {
            IPCLog.INSTANCE.i(TAG, "[onTransact][recycleRemote] " + jArr, new Object[0]);
            e.f13612e.b(new com.stepos.core.common.telemetry.scene.a(i10, 1, jArr), false, false);
        } catch (Throwable th) {
            IPCLog.INSTANCE.w(TAG, "[onTransact][recycle]", "exception", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processMethodRecycleRemote$lambda$1(long[] jArr, int i10) {
        if (jArr != null) {
            ServiceCache.f7640b.a().c(i10, jArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Reply processMethodSend(Call call) {
        try {
            if (call.getProtocolInvalidFlag()) {
                return Reply.CREATOR.obtain().withIPCException(new IPCException(52, "the protocol from the caller is higher than the server, please update server DeepBinder version to match the caller side!", "2"));
            }
            boolean zIsOneway = call.getMethodWrapper().isOneway();
            boolean zIsVoid = call.getMethodWrapper().isVoid();
            int protocolVersion = call.getProtocolVersion();
            Reply replySendCall = sendCall(call);
            if (zIsOneway) {
                return null;
            }
            if (zIsVoid && replySendCall.getIpcException() == null && replySendCall.getFlowParameterWrappers() == null) {
                return null;
            }
            return replySendCall.withProtocolVersion(protocolVersion);
        } catch (Throwable th) {
            IPCLog.INSTANCE.w(TAG, "[onTransact][sendCall]", "exception", th);
            return Reply.CREATOR.obtain().withIPCException(new IPCException(10, th));
        }
    }

    private final Reply sendAsyncCall(Call call) {
        e.f13612e.b(new o(11, this, call), false, false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Reply sendSyncCall(Call call) {
        a.C0178a c0178a = y9.a.f14176c;
        try {
            Reply replyA = xb.a.c(call).a();
            c0178a.a().f14179b.remove();
            call.recycle();
            return replyA;
        } catch (Throwable th) {
            try {
                Reply replyObtain = Reply.CREATOR.obtain();
                if (th instanceof IPCException) {
                    replyObtain.withIPCException(th);
                } else {
                    replyObtain.withIPCException(new IPCException(11, th));
                }
                c0178a.a().f14179b.remove();
                call.recycle();
                return replyObtain;
            } catch (Throwable th2) {
                c0178a.a().f14179b.remove();
                call.recycle();
                throw th2;
            }
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String str, Bundle bundle) {
        g.f(method, "method");
        IPCLog.INSTANCE.i(TAG, "call: " + getCallingPackage() + ' ' + method, new Object[0]);
        Bundle bundle2 = new Bundle();
        int iHashCode = method.hashCode();
        if (iHashCode != 3045982) {
            if (iHashCode != 951351530) {
                if (iHashCode == 1930954610 && method.equals("recycle_remote")) {
                    processMethodRecycleRemote(bundle != null ? bundle.getLongArray("timeStamps") : null, bundle != null ? bundle.getInt("pid") : 0);
                    return bundle2;
                }
            } else if (method.equals("connect")) {
                connect();
                return bundle2;
            }
        } else if (method.equals("call")) {
            if (bundle != null) {
                bundle.setClassLoader(DeepBinderInternal.class.getClassLoader());
            }
            Call call = bundle != null ? (Call) bundle.getParcelable("call") : null;
            g.c(call);
            Reply replyProcessMethodSend = processMethodSend(call);
            if (replyProcessMethodSend != null) {
                bundle2.putParcelable("reply", replyProcessMethodSend);
            }
        }
        return bundle2;
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    @SuppressLint({"WrongConstant"})
    public void connect() {
        if (this.isConnectFlag.compareAndSet(false, true)) {
            e.f13612e.b(new y0(this, 8), false, false);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        g.f(uri, "uri");
        return 0;
    }

    @f.a
    public IContentProvider getIContentProvider() {
        return this.mHookIContentProvider;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        g.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        g.f(uri, "uri");
        return null;
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public boolean isRemote() {
        return false;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext;
        Context context = getContext();
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            DeepBinderInternal.init((Application) applicationContext);
        }
        connect();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        g.f(uri, "uri");
        return null;
    }

    @Override // com.stepos.deepbinder.core.api.IService
    public void recycle(int i10, long[] timestamps) {
        g.f(timestamps, "timestamps");
        ServiceCache.f7640b.a().c(i10, timestamps);
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public Reply sendCall(Call call) {
        g.f(call, "call");
        call.setCallerData(new CallerData(null, null, Binder.getCallingUid(), call.getMethodWrapper().isOneway() ? call.getMethodWrapper().getPid() : Binder.getCallingPid(), 3, null));
        if (!call.getMethodWrapper().isOneway()) {
            return sendSyncCall(call);
        }
        Reply replySendAsyncCall = sendAsyncCall(call);
        return replySendAsyncCall == null ? Reply.CREATOR.obtain() : replySendAsyncCall;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        g.f(uri, "uri");
        return 0;
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public void disconnect() {
    }
}
