package com.obric.cae.libs.mpflow;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeMpflowManager extends IInterface {
    public static final int SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_1 = 0;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_2 = 1;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_WIFI_1 = 2;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_WIFI_2 = 3;

    public static class Default implements ICaeMpflowManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByPid(int r1, int r2, boolean r3) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByUid(int r1, int r2, boolean r3) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByPid(int r1) {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByUid(int r1) {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int modifyNetName(int r1, String r2) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int setSocketOptByUid(int r1, int r2, int r3) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByPid(int r1, int r2, boolean r3) {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByUid(int r1, int r2, boolean r3) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeMpflowManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.mpflow.ICaeMpflowManager";
        static final int TRANSACTION_bindNetByPid = 5;
        static final int TRANSACTION_bindNetByUid = 3;
        static final int TRANSACTION_disconnectSocketByPid = 7;
        static final int TRANSACTION_disconnectSocketByUid = 6;
        static final int TRANSACTION_modifyNetName = 1;
        static final int TRANSACTION_setSocketOptByUid = 8;
        static final int TRANSACTION_switchNetByPid = 4;
        static final int TRANSACTION_switchNetByUid = 2;

        public static class Proxy implements ICaeMpflowManager {
            public static ICaeMpflowManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByPid(int r5, int r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().bindNetByPid(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByUid(int r5, int r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().bindNetByUid(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByPid(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByPid(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByUid(int r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByUid(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int modifyNetName(int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().modifyNetName(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int setSocketOptByUid(int r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().setSocketOptByUid(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByPid(int r5, int r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().switchNetByPid(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByUid(int r5, int r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().switchNetByUid(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeMpflowManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeMpflowManager.class) == false) goto L13;
            return (ICaeMpflowManager) ZeusTransformUtils.preCheckCast(r0, ICaeMpflowManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeMpflowManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeMpflowManager r2) {
            ICaeMpflowManager r3 = (ICaeMpflowManager) ZeusTransformUtils.wrapperContextForParams(r2, ICaeMpflowManager.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L36;
            boolean r2 = false;
            switch(r4) {
                case 1: goto L34;
                case 2: goto L29;
                case 3: goto L24;
                case 4: goto L19;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            int r3 = setSocketOptByUid(r5.readInt(), r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r3);
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            disconnectSocketByPid(r5.readInt());
            return true;
        L12:
            r5.enforceInterface(DESCRIPTOR);
            disconnectSocketByUid(r5.readInt());
            return true;
        L14:
            r5.enforceInterface(DESCRIPTOR);
            int r8 = r5.readInt();
            int r9 = r5.readInt();
            if (r5.readInt() == 0) goto L17;
            r2 = true;
        L17:
            int r10 = bindNetByPid(r8, r9, r2);
            r6.writeNoException();
            r6.writeInt(r10);
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            int r11 = r5.readInt();
            int r12 = r5.readInt();
            if (r5.readInt() == 0) goto L22;
            r2 = true;
        L22:
            int r13 = switchNetByPid(r11, r12, r2);
            r6.writeNoException();
            r6.writeInt(r13);
            return true;
        L24:
            r5.enforceInterface(DESCRIPTOR);
            int r14 = r5.readInt();
            int r15 = r5.readInt();
            if (r5.readInt() == 0) goto L27;
            r2 = true;
        L27:
            int r16 = bindNetByUid(r14, r15, r2);
            r6.writeNoException();
            r6.writeInt(r16);
            return true;
        L29:
            r5.enforceInterface(DESCRIPTOR);
            int r17 = r5.readInt();
            int r18 = r5.readInt();
            if (r5.readInt() == 0) goto L32;
            r2 = true;
        L32:
            int r19 = switchNetByUid(r17, r18, r2);
            r6.writeNoException();
            r6.writeInt(r19);
            return true;
        L34:
            r5.enforceInterface(DESCRIPTOR);
            int r20 = modifyNetName(r5.readInt(), r5.readString());
            r6.writeNoException();
            r6.writeInt(r20);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L36:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int bindNetByPid(int r1, int r2, boolean r3);

    int bindNetByUid(int r1, int r2, boolean r3);

    void disconnectSocketByPid(int r1);

    void disconnectSocketByUid(int r1);

    int modifyNetName(int r1, String r2);

    int setSocketOptByUid(int r1, int r2, int r3);

    int switchNetByPid(int r1, int r2, boolean r3);

    int switchNetByUid(int r1, int r2, boolean r3);
}
