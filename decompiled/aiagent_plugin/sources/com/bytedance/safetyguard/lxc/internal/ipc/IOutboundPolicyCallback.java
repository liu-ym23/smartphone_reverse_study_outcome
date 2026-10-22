package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IOutboundPolicyCallback extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback";

    public static class Default implements IOutboundPolicyCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback
        public void evaluate(long r1, OutboundTargetParcel r3, IPolicyResultCallback r4) {
            IPolicyResultCallback r0 = (IPolicyResultCallback) ZeusTransformUtils.wrapperContextForParams(r4, IPolicyResultCallback.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IOutboundPolicyCallback {
        static final int TRANSACTION_evaluate = 1;

        private static class Proxy implements IOutboundPolicyCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IOutboundPolicyCallback.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback
            public void evaluate(long r3, OutboundTargetParcel r5, IPolicyResultCallback r6) {
                IPolicyResultCallback r7 = (IPolicyResultCallback) ZeusTransformUtils.wrapperContextForParams(r6, IPolicyResultCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IOutboundPolicyCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeLong(r3);     // Catch: Throwable -> L6
                a.a(r0, r5, 0);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
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
            attachInterface(this, IOutboundPolicyCallback.DESCRIPTOR);
        }

        public static IOutboundPolicyCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IOutboundPolicyCallback.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IOutboundPolicyCallback.class) == false) goto L13;
            return (IOutboundPolicyCallback) ZeusTransformUtils.preCheckCast(r0, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IOutboundPolicyCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IOutboundPolicyCallback.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            evaluate(r5.readLong(), (OutboundTargetParcel) ZeusTransformUtils.preCheckCast(a.a(r5, OutboundTargetParcel.CREATOR), OutboundTargetParcel.class, "com.obric.aiagent.plugin"), IPolicyResultCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L13:
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

    void evaluate(long r1, OutboundTargetParcel r3, IPolicyResultCallback r4);
}
