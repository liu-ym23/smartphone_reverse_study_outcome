package com.obric.cae.libs.mpflow;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeMpflowManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.mpflow.ICaeMpflowManager";
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
        public int bindNetByPid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByUid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByPid(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByUid(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int modifyNetName(int r1, String r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int setSocketOptByUid(int r1, int r2, int r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByPid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByUid(int r1, int r2, boolean r3) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeMpflowManager {
        static final int TRANSACTION_bindNetByPid = 5;
        static final int TRANSACTION_bindNetByUid = 3;
        static final int TRANSACTION_disconnectSocketByPid = 7;
        static final int TRANSACTION_disconnectSocketByUid = 6;
        static final int TRANSACTION_modifyNetName = 1;
        static final int TRANSACTION_setSocketOptByUid = 8;
        static final int TRANSACTION_switchNetByPid = 4;
        static final int TRANSACTION_switchNetByUid = 2;

        public static class Proxy implements ICaeMpflowManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByPid(int r4, int r5, boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r7 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByUid(int r4, int r5, boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r7 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByPid(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByUid(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return ICaeMpflowManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int modifyNetName(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r6 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int setSocketOptByUid(int r4, int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r7 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByPid(int r4, int r5, boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r7 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByUid(int r4, int r5, boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMpflowManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r7 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeMpflowManager.DESCRIPTOR);
        }

        public static ICaeMpflowManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeMpflowManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeMpflowManager) == false) goto L12;
            return (ICaeMpflowManager) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ICaeMpflowManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L34;
            boolean r0 = false;
            switch(r4) {
                case 1: goto L32;
                case 2: goto L28;
                case 3: goto L24;
                case 4: goto L20;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                default: goto L12;
            };
        L13:
            int r8 = setSocketOptByUid(r5.readInt(), r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8);
        L33:
            return true;
        L14:
            disconnectSocketByPid(r5.readInt());
            goto L33
        L15:
            disconnectSocketByUid(r5.readInt());
            goto L33
        L16:
            int r9 = r5.readInt();
            int r10 = r5.readInt();
            if (r5.readInt() == 0) goto L19;
            r0 = true;
        L19:
            int r11 = bindNetByPid(r9, r10, r0);
            r6.writeNoException();
            r6.writeInt(r11);
            goto L33
        L20:
            int r12 = r5.readInt();
            int r13 = r5.readInt();
            if (r5.readInt() == 0) goto L23;
            r0 = true;
        L23:
            int r14 = switchNetByPid(r12, r13, r0);
            r6.writeNoException();
            r6.writeInt(r14);
            goto L33
        L24:
            int r15 = r5.readInt();
            int r16 = r5.readInt();
            if (r5.readInt() == 0) goto L27;
            r0 = true;
        L27:
            int r17 = bindNetByUid(r15, r16, r0);
            r6.writeNoException();
            r6.writeInt(r17);
            goto L33
        L28:
            int r18 = r5.readInt();
            int r19 = r5.readInt();
            if (r5.readInt() == 0) goto L31;
            r0 = true;
        L31:
            int r20 = switchNetByUid(r18, r19, r0);
            r6.writeNoException();
            r6.writeInt(r20);
            goto L33
        L32:
            int r21 = modifyNetName(r5.readInt(), r5.readString());
            r6.writeNoException();
            r6.writeInt(r21);
            goto L33
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L34:
            r6.writeString(ICaeMpflowManager.DESCRIPTOR);
            return true;
        }
    }

    int bindNetByPid(int r1, int r2, boolean r3) throws RemoteException;

    int bindNetByUid(int r1, int r2, boolean r3) throws RemoteException;

    void disconnectSocketByPid(int r1) throws RemoteException;

    void disconnectSocketByUid(int r1) throws RemoteException;

    int modifyNetName(int r1, String r2) throws RemoteException;

    int setSocketOptByUid(int r1, int r2, int r3) throws RemoteException;

    int switchNetByPid(int r1, int r2, boolean r3) throws RemoteException;

    int switchNetByUid(int r1, int r2, boolean r3) throws RemoteException;
}
