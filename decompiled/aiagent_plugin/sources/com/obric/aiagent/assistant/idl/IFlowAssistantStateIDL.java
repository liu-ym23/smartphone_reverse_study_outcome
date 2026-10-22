package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowAssistantStateIDL extends IInterface {

    public static class Default implements IFlowAssistantStateIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public int getCurrentNightMode() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public boolean isActive() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public boolean isBackgroundIntercepting() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r2) {
            IFlowAssistantActiveStateListenerIDL r1 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r2) {
            IFlowBackgroundInterceptStateListenerIDL r1 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerNightModeListener(IFlowNightModeChangeListenerIDL r2) {
            IFlowNightModeChangeListenerIDL r1 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r2) {
            IFlowAssistantTTSStateListenerIDL r1 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r2) {
            IFlowAssistantActiveStateListenerIDL r1 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r2) {
            IFlowBackgroundInterceptStateListenerIDL r1 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r2) {
            IFlowNightModeChangeListenerIDL r1 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r2) {
            IFlowAssistantTTSStateListenerIDL r1 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAssistantStateIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL";
        static final int TRANSACTION_getCurrentNightMode = 9;
        static final int TRANSACTION_isActive = 1;
        static final int TRANSACTION_isBackgroundIntercepting = 6;
        static final int TRANSACTION_registerActiveStateListener = 2;
        static final int TRANSACTION_registerBackgroundInterceptingListener = 7;
        static final int TRANSACTION_registerNightModeListener = 10;
        static final int TRANSACTION_registerTTSStateListener = 4;
        static final int TRANSACTION_unregisterActiveStateListener = 3;
        static final int TRANSACTION_unregisterBackgroundInterceptingListener = 8;
        static final int TRANSACTION_unregisterNightModeListener = 11;
        static final int TRANSACTION_unregisterTTSStateListener = 5;

        private static class Proxy implements IFlowAssistantStateIDL {
            public static IFlowAssistantStateIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public boolean isActive() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r2 = false;
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r2 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isActive();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r5) {
                IFlowAssistantActiveStateListenerIDL r6 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerActiveStateListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r5) {
                IFlowAssistantActiveStateListenerIDL r6 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterActiveStateListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r5) {
                IFlowAssistantTTSStateListenerIDL r6 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerTTSStateListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r5) {
                IFlowAssistantTTSStateListenerIDL r6 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTTSStateListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public boolean isBackgroundIntercepting() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isBackgroundIntercepting();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r5) {
                IFlowBackgroundInterceptStateListenerIDL r6 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerBackgroundInterceptingListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r5) {
                IFlowBackgroundInterceptStateListenerIDL r6 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterBackgroundInterceptingListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public int getCurrentNightMode() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getCurrentNightMode();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerNightModeListener(IFlowNightModeChangeListenerIDL r5) {
                IFlowNightModeChangeListenerIDL r6 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerNightModeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r5) {
                IFlowNightModeChangeListenerIDL r6 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterNightModeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAssistantStateIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowAssistantStateIDL.class) == false) goto L13;
            return (IFlowAssistantStateIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L29;
            switch(r4) {
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L11;
                case 10: goto L9;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            unregisterNightModeListener(IFlowNightModeChangeListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            registerNightModeListener(IFlowNightModeChangeListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            int r3 = getCurrentNightMode();
            r6.writeNoException();
            r6.writeInt(r3);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = isBackgroundIntercepting();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L21:
            r5.enforceInterface(DESCRIPTOR);
            registerTTSStateListener(IFlowAssistantTTSStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L25:
            r5.enforceInterface(DESCRIPTOR);
            registerActiveStateListener(IFlowAssistantActiveStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L27:
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = isActive();
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L29:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowAssistantStateIDL r2) {
            IFlowAssistantStateIDL r3 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowAssistantStateIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    int getCurrentNightMode();

    boolean isActive();

    boolean isBackgroundIntercepting();

    void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r1);

    void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r1);

    void registerNightModeListener(IFlowNightModeChangeListenerIDL r1);

    void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r1);

    void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r1);

    void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r1);

    void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r1);

    void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r1);
}
