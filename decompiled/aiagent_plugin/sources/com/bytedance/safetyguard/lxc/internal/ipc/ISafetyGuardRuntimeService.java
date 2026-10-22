package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface ISafetyGuardRuntimeService extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService";

    public static class Default implements ISafetyGuardRuntimeService {
        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public ActionActivationResultParcel activateAction(int r1, String r2, IBinder r3, String r4) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public void attachProxy(ProxyAttachRequestParcel r1, ParcelFileDescriptor r2, IBinder r3, IProxyClientCallback r4, IOutboundPolicyCallback r5) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            IProxyClientCallback r6 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r4, IProxyClientCallback.class, "com.obric.aiagent.plugin");
            IOutboundPolicyCallback r7 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r5, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public void cancelSidecar(int r1, String r2, IBinder r3) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public void closeClient(int r1, IBinder r2) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public void detachProxy(int r1, String r2, IBinder r3) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public boolean endSidecarSession(int r1, String r2, IBinder r3) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            return false;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public void executeSidecar(SidecarCommandParcel r1, IBinder r2, ISidecarCallback r3) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            ISidecarCallback r4 = (ISidecarCallback) ZeusTransformUtils.wrapperContextForParams(r3, ISidecarCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
        public ActionFinishResultParcel finishAction(int r1, String r2, IBinder r3, ActionContextTokenParcel r4) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISafetyGuardRuntimeService {
        static final int TRANSACTION_activateAction = 7;
        static final int TRANSACTION_attachProxy = 1;
        static final int TRANSACTION_cancelSidecar = 5;
        static final int TRANSACTION_closeClient = 3;
        static final int TRANSACTION_detachProxy = 2;
        static final int TRANSACTION_endSidecarSession = 6;
        static final int TRANSACTION_executeSidecar = 4;
        static final int TRANSACTION_finishAction = 8;

        private static class Proxy implements ISafetyGuardRuntimeService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return ISafetyGuardRuntimeService.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public void attachProxy(ProxyAttachRequestParcel r4, ParcelFileDescriptor r5, IBinder r6, IProxyClientCallback r7, IOutboundPolicyCallback r8) {
                IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
                IProxyClientCallback r10 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r7, IProxyClientCallback.class, "com.obric.aiagent.plugin");
                IOutboundPolicyCallback r11 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r8, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L6
                a.a(r0, r4, 0);     // Catch: Throwable -> L6
                a.a(r0, r5, 0);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r9);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r10);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public void detachProxy(int r4, String r5, IBinder r6) {
                IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public void closeClient(int r4, IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public void executeSidecar(SidecarCommandParcel r4, IBinder r5, ISidecarCallback r6) {
                IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                ISidecarCallback r8 = (ISidecarCallback) ZeusTransformUtils.wrapperContextForParams(r6, ISidecarCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L6
                a.a(r0, r4, 0);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r7);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public void cancelSidecar(int r4, String r5, IBinder r6) {
                IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public boolean endSidecarSession(int r4, String r5, IBinder r6) {
                IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
                r0.writeString(r5);     // Catch: Throwable -> L8
                r0.writeStrongBinder(r7);     // Catch: Throwable -> L8
                boolean r8 = false;
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r8 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public ActionActivationResultParcel activateAction(int r5, String r6, IBinder r7, String r8) {
                IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r7, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r9);     // Catch: Throwable -> L6
                r0.writeString(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r2, 0);     // Catch: Throwable -> L6
                r2.readException();     // Catch: Throwable -> L6
                ActionActivationResultParcel r4 = (ActionActivationResultParcel) ZeusTransformUtils.preCheckCast(a.a(r2, ActionActivationResultParcel.CREATOR), ActionActivationResultParcel.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
                r2.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r2.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.safetyguard.lxc.internal.ipc.ISafetyGuardRuntimeService
            public ActionFinishResultParcel finishAction(int r5, String r6, IBinder r7, ActionContextTokenParcel r8) {
                IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r7, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r0.writeInterfaceToken(ISafetyGuardRuntimeService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeStrongBinder(r9);     // Catch: Throwable -> L6
                a.a(r0, r8, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r2, 0);     // Catch: Throwable -> L6
                r2.readException();     // Catch: Throwable -> L6
                ActionFinishResultParcel r4 = (ActionFinishResultParcel) ZeusTransformUtils.preCheckCast(a.a(r2, ActionFinishResultParcel.CREATOR), ActionFinishResultParcel.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
                r2.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r2.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISafetyGuardRuntimeService.DESCRIPTOR);
        }

        public static ISafetyGuardRuntimeService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(ISafetyGuardRuntimeService.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ISafetyGuardRuntimeService.class) == false) goto L13;
            return (ISafetyGuardRuntimeService) ZeusTransformUtils.preCheckCast(r0, ISafetyGuardRuntimeService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) {
            if (r9 < 1) goto L8;
            if (r9 > 16777215) goto L8;
            r10.enforceInterface(ISafetyGuardRuntimeService.DESCRIPTOR);
        L8:
            if (r9 != 1598968902) goto L12;
            r11.writeString(ISafetyGuardRuntimeService.DESCRIPTOR);
            return true;
        L12:
            switch(r9) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L14;
            };
        L15:
            ActionFinishResultParcel r8 = finishAction(r10.readInt(), r10.readString(), r10.readStrongBinder(), (ActionContextTokenParcel) ZeusTransformUtils.preCheckCast(a.a(r10, ActionContextTokenParcel.CREATOR), ActionContextTokenParcel.class, "com.obric.aiagent.plugin"));
            r11.writeNoException();
            a.a(r11, r8, 1);
        L23:
            return true;
        L16:
            ActionActivationResultParcel r13 = activateAction(r10.readInt(), r10.readString(), r10.readStrongBinder(), r10.readString());
            r11.writeNoException();
            a.a(r11, r13, 1);
            goto L23
        L17:
            boolean r14 = endSidecarSession(r10.readInt(), r10.readString(), r10.readStrongBinder());
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            goto L23
        L18:
            cancelSidecar(r10.readInt(), r10.readString(), r10.readStrongBinder());
            r11.writeNoException();
            goto L23
        L19:
            executeSidecar((SidecarCommandParcel) ZeusTransformUtils.preCheckCast(a.a(r10, SidecarCommandParcel.CREATOR), SidecarCommandParcel.class, "com.obric.aiagent.plugin"), r10.readStrongBinder(), ISidecarCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L23
        L20:
            closeClient(r10.readInt(), r10.readStrongBinder());
            r11.writeNoException();
            goto L23
        L21:
            detachProxy(r10.readInt(), r10.readString(), r10.readStrongBinder());
            r11.writeNoException();
            goto L23
        L22:
            attachProxy((ProxyAttachRequestParcel) ZeusTransformUtils.preCheckCast(a.a(r10, ProxyAttachRequestParcel.CREATOR), ProxyAttachRequestParcel.class, "com.obric.aiagent.plugin"), (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(a.a(r10, ParcelFileDescriptor.CREATOR), ParcelFileDescriptor.class, "com.obric.aiagent.plugin"), r10.readStrongBinder(), IProxyClientCallback.Stub.asInterface(r10.readStrongBinder()), IOutboundPolicyCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L23
        L14:
            return super.onTransact(r9, r10, r11, r12);
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

    ActionActivationResultParcel activateAction(int r1, String r2, IBinder r3, String r4);

    void attachProxy(ProxyAttachRequestParcel r1, ParcelFileDescriptor r2, IBinder r3, IProxyClientCallback r4, IOutboundPolicyCallback r5);

    void cancelSidecar(int r1, String r2, IBinder r3);

    void closeClient(int r1, IBinder r2);

    void detachProxy(int r1, String r2, IBinder r3);

    boolean endSidecarSession(int r1, String r2, IBinder r3);

    void executeSidecar(SidecarCommandParcel r1, IBinder r2, ISidecarCallback r3);

    ActionFinishResultParcel finishAction(int r1, String r2, IBinder r3, ActionContextTokenParcel r4);
}
