package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IProxyClientCallback extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback";

    public static class Default implements IProxyClientCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onDiagnostic(ProxyDiagnosticParcel r1) {
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onReady(String r1, ProxyReadyParcel r2) {
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onRecovering(int r1, String r2) {
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
        public void onTerminal(String r1, ProxySessionResultParcel r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IProxyClientCallback {
        static final int TRANSACTION_onDiagnostic = 4;
        static final int TRANSACTION_onReady = 1;
        static final int TRANSACTION_onRecovering = 2;
        static final int TRANSACTION_onTerminal = 3;

        private static class Proxy implements IProxyClientCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IProxyClientCallback.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
            public void onReady(String r3, ProxyReadyParcel r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IProxyClientCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                a.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
            public void onRecovering(int r3, String r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IProxyClientCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
            public void onTerminal(String r3, ProxySessionResultParcel r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IProxyClientCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                a.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback
            public void onDiagnostic(ProxyDiagnosticParcel r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IProxyClientCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                a.a(r0, r4, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IProxyClientCallback.DESCRIPTOR);
        }

        public static IProxyClientCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IProxyClientCallback.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IProxyClientCallback.class) == false) goto L13;
            return (IProxyClientCallback) ZeusTransformUtils.preCheckCast(r0, IProxyClientCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IProxyClientCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L12;
            r6.writeString(IProxyClientCallback.DESCRIPTOR);
            return true;
        L12:
            if (r4 != 1) goto L14;
            onReady(r5.readString(), (ProxyReadyParcel) ZeusTransformUtils.preCheckCast(a.a(r5, ProxyReadyParcel.CREATOR), ProxyReadyParcel.class, "com.obric.aiagent.plugin"));
        L25:
            return true;
        L14:
            if (r4 != 2) goto L16;
            onRecovering(r5.readInt(), r5.readString());
            goto L25
        L16:
            if (r4 != 3) goto L18;
            onTerminal(r5.readString(), (ProxySessionResultParcel) ZeusTransformUtils.preCheckCast(a.a(r5, ProxySessionResultParcel.CREATOR), ProxySessionResultParcel.class, "com.obric.aiagent.plugin"));
            goto L25
        L18:
            if (r4 != 4) goto L20;
            onDiagnostic((ProxyDiagnosticParcel) ZeusTransformUtils.preCheckCast(a.a(r5, ProxyDiagnosticParcel.CREATOR), ProxyDiagnosticParcel.class, "com.obric.aiagent.plugin"));
            goto L25
        L20:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    public static class a {
        static /* synthetic */ Object a(Parcel r2, Parcelable.Creator r3) {
            return b(r2, (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        }

        static /* synthetic */ void a(Parcel r2, Parcelable r3, int r4) {
            b(r2, (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"), r4);
        }

        private static <T> T b(Parcel r2, Parcelable.Creator<T> r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.aiagent.plugin");
            if (r2.readInt() != 0) goto L5;
            return null;
        L5:
            return (T) r4.createFromParcel(r2);
        }

        private static <T extends Parcelable> void b(Parcel r2, T r3, int r4) {
            Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L5;
            r2.writeInt(1);
            r5.writeToParcel(r2, r4);
            return;
        L5:
            r2.writeInt(0);
        }
    }

    void onDiagnostic(ProxyDiagnosticParcel r1);

    void onReady(String r1, ProxyReadyParcel r2);

    void onRecovering(int r1, String r2);

    void onTerminal(String r1, ProxySessionResultParcel r2);
}
