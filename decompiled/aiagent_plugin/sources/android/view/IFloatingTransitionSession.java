package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IFloatingTransitionSession extends IInterface {

    public static class Default implements IFloatingTransitionSession {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IFloatingTransitionSession
        public void notifyFloatingTransitionFinished(IBinder r2) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.IFloatingTransitionSession
        public void notifyFloatingTransitionLaunch(IBinder r2) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.IFloatingTransitionSession
        public boolean registerTitleBar(IBinder r2, IFloatingTransitionCallback r3, IFloatingTransitionStateProvider r4) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            IFloatingTransitionCallback r5 = (IFloatingTransitionCallback) ZeusTransformUtils.wrapperContextForParams(r3, IFloatingTransitionCallback.class, "com.obric.aiagent.plugin");
            IFloatingTransitionStateProvider r6 = (IFloatingTransitionStateProvider) ZeusTransformUtils.wrapperContextForParams(r4, IFloatingTransitionStateProvider.class, "com.obric.aiagent.plugin");
            return false;
        }

        @Override // android.view.IFloatingTransitionSession
        public void unregisterTitleBar(IBinder r2) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.IFloatingTransitionSession
        public void updateState(IBinder r1, Bundle r2) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r1, IBinder.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFloatingTransitionSession {
        private static final String DESCRIPTOR = "android.view.IFloatingTransitionSession";
        static final int TRANSACTION_notifyFloatingTransitionFinished = 5;
        static final int TRANSACTION_notifyFloatingTransitionLaunch = 4;
        static final int TRANSACTION_registerTitleBar = 1;
        static final int TRANSACTION_unregisterTitleBar = 2;
        static final int TRANSACTION_updateState = 3;

        private static class Proxy implements IFloatingTransitionSession {
            public static IFloatingTransitionSession sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.view.IFloatingTransitionSession
            public boolean registerTitleBar(IBinder r5, IFloatingTransitionCallback r6, IFloatingTransitionStateProvider r7) {
                IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                IFloatingTransitionCallback r9 = (IFloatingTransitionCallback) ZeusTransformUtils.wrapperContextForParams(r6, IFloatingTransitionCallback.class, "com.obric.aiagent.plugin");
                IFloatingTransitionStateProvider r10 = (IFloatingTransitionStateProvider) ZeusTransformUtils.wrapperContextForParams(r7, IFloatingTransitionStateProvider.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                r0.writeStrongBinder(r8);     // Catch: Throwable -> L22
                IBinder r2 = null;
                if (r9 == null) goto L6;
                IBinder r3 = r9.asBinder();     // Catch: Throwable -> L22
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L22
                if (r10 == null) goto L10;
                r2 = r10.asBinder();     // Catch: Throwable -> L22
            L10:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L22
                boolean r4 = false;
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L22
                if (r1.readInt() == 0) goto L20;
                r4 = true;
            L20:
                r1.recycle();
                r0.recycle();
                return r4;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r11 = Stub.getDefaultImpl().registerTitleBar(r8, r9, r10);     // Catch: Throwable -> L22
                r1.recycle();
                r0.recycle();
                return r11;
            L6:
                r3 = null;
            L22:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void unregisterTitleBar(IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterTitleBar(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void updateState(IBinder r5, Bundle r6) {
                IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeStrongBinder(r7);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateState(r7, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void notifyFloatingTransitionLaunch(IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyFloatingTransitionLaunch(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void notifyFloatingTransitionFinished(IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyFloatingTransitionFinished(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFloatingTransitionSession asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFloatingTransitionSession.class) == false) goto L13;
            return (IFloatingTransitionSession) ZeusTransformUtils.preCheckCast(r0, IFloatingTransitionSession.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            boolean r3 = registerTitleBar(r5.readStrongBinder(), IFloatingTransitionCallback.Stub.asInterface(r5.readStrongBinder()), IFloatingTransitionStateProvider.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            unregisterTitleBar(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            IBinder r8 = r5.readStrongBinder();
            if (r5.readInt() == 0) goto L25;
            Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.aiagent.plugin");
        L26:
            updateState(r8, r9);
            r6.writeNoException();
            return true;
        L25:
            r9 = null;
            goto L26
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            notifyFloatingTransitionLaunch(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface(DESCRIPTOR);
            notifyFloatingTransitionFinished(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IFloatingTransitionSession r2) {
            IFloatingTransitionSession r3 = (IFloatingTransitionSession) ZeusTransformUtils.wrapperContextForParams(r2, IFloatingTransitionSession.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IFloatingTransitionSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void notifyFloatingTransitionFinished(IBinder r1);

    void notifyFloatingTransitionLaunch(IBinder r1);

    boolean registerTitleBar(IBinder r1, IFloatingTransitionCallback r2, IFloatingTransitionStateProvider r3);

    void unregisterTitleBar(IBinder r1);

    void updateState(IBinder r1, Bundle r2);
}
