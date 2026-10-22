package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowFrontierIDL extends IInterface {
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_CONNECTING = 0;
    public static final int STATE_DISCONNECTED = 2;

    public static class Default implements IFlowFrontierIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void cacheScreenshot(int r1, Bitmap r2, Map r3) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void cacheScreenshotFd(int r1, String r2, ParcelFileDescriptor r3, Map r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public int getState() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void registerDataListener(int r1, IFlowFrontierDataListenerIDL r2) {
            IFlowFrontierDataListenerIDL r0 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void registerStateListener(int r1, IFlowFrontierStateListenerIDL r2) {
            IFlowFrontierStateListenerIDL r0 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void sendData(int r1, byte[] r2, Map r3) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void unregisterDataListener(int r1, IFlowFrontierDataListenerIDL r2) {
            IFlowFrontierDataListenerIDL r0 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void unregisterStateListener(int r1, IFlowFrontierStateListenerIDL r2) {
            IFlowFrontierStateListenerIDL r0 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowFrontierIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowFrontierIDL";
        static final int TRANSACTION_cacheScreenshot = 7;
        static final int TRANSACTION_cacheScreenshotFd = 8;
        static final int TRANSACTION_getState = 1;
        static final int TRANSACTION_registerDataListener = 2;
        static final int TRANSACTION_registerStateListener = 4;
        static final int TRANSACTION_sendData = 6;
        static final int TRANSACTION_unregisterDataListener = 3;
        static final int TRANSACTION_unregisterStateListener = 5;

        private static class Proxy implements IFlowFrontierIDL {
            public static IFlowFrontierIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public int getState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getState();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void registerDataListener(int r5, IFlowFrontierDataListenerIDL r6) {
                IFlowFrontierDataListenerIDL r7 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDataListener(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void unregisterDataListener(int r5, IFlowFrontierDataListenerIDL r6) {
                IFlowFrontierDataListenerIDL r7 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterDataListener(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void registerStateListener(int r5, IFlowFrontierStateListenerIDL r6) {
                IFlowFrontierStateListenerIDL r7 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerStateListener(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void unregisterStateListener(int r5, IFlowFrontierStateListenerIDL r6) {
                IFlowFrontierStateListenerIDL r7 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterStateListener(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void sendData(int r5, byte[] r6, Map r7) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeByteArray(r6);     // Catch: Throwable -> L12
                r0.writeMap(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendData(r5, r6, r8);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void cacheScreenshot(int r5, Bitmap r6, Map r7) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L7:
                r0.writeMap(r8);     // Catch: Throwable -> L17
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cacheScreenshot(r5, r6, r8);     // Catch: Throwable -> L17
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

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void cacheScreenshotFd(int r5, String r6, ParcelFileDescriptor r7, Map r8) {
                Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeMap(r9);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cacheScreenshotFd(r5, r6, r7, r9);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
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

        public static IFlowFrontierIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowFrontierIDL.class) == false) goto L13;
            return (IFlowFrontierIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L30;
            Bitmap r3 = null;
            ParcelFileDescriptor r4 = null;
            switch(r5) {
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L13;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            int r9 = r6.readInt();
            String r10 = r6.readString();
            if (r6.readInt() == 0) goto L11;
            r4 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(ParcelFileDescriptor.CREATOR.createFromParcel(r6), ParcelFileDescriptor.class, "com.obric.aiagent.plugin");
        L11:
            cacheScreenshotFd(r9, r10, r4, r6.readHashMap(getClass().getClassLoader()));
            return true;
        L13:
            r6.enforceInterface(DESCRIPTOR);
            int r11 = r6.readInt();
            if (r6.readInt() == 0) goto L16;
            r3 = (Bitmap) ZeusTransformUtils.preCheckCast(Bitmap.CREATOR.createFromParcel(r6), Bitmap.class, "com.obric.aiagent.plugin");
        L16:
            cacheScreenshot(r11, r3, r6.readHashMap(getClass().getClassLoader()));
            r7.writeNoException();
            return true;
        L18:
            r6.enforceInterface(DESCRIPTOR);
            sendData(r6.readInt(), r6.createByteArray(), r6.readHashMap(getClass().getClassLoader()));
            return true;
        L20:
            r6.enforceInterface(DESCRIPTOR);
            unregisterStateListener(r6.readInt(), IFlowFrontierStateListenerIDL.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L22:
            r6.enforceInterface(DESCRIPTOR);
            registerStateListener(r6.readInt(), IFlowFrontierStateListenerIDL.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L24:
            r6.enforceInterface(DESCRIPTOR);
            unregisterDataListener(r6.readInt(), IFlowFrontierDataListenerIDL.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L26:
            r6.enforceInterface(DESCRIPTOR);
            registerDataListener(r6.readInt(), IFlowFrontierDataListenerIDL.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L28:
            r6.enforceInterface(DESCRIPTOR);
            int r12 = getState();
            r7.writeNoException();
            r7.writeInt(r12);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L30:
            r7.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowFrontierIDL r2) {
            IFlowFrontierIDL r3 = (IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowFrontierIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void cacheScreenshot(int r1, Bitmap r2, Map r3);

    void cacheScreenshotFd(int r1, String r2, ParcelFileDescriptor r3, Map r4);

    int getState();

    void registerDataListener(int r1, IFlowFrontierDataListenerIDL r2);

    void registerStateListener(int r1, IFlowFrontierStateListenerIDL r2);

    void sendData(int r1, byte[] r2, Map r3);

    void unregisterDataListener(int r1, IFlowFrontierDataListenerIDL r2);

    void unregisterStateListener(int r1, IFlowFrontierStateListenerIDL r2);
}
