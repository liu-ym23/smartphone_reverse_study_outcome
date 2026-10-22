package com.obric.capabilitykit.common;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ICapabilityActionHandler extends IInterface {

    public static class Default implements ICapabilityActionHandler {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int getVersion() {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleAction(String r1) {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleIntentCalling(IntentCalling r1) {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int isTaskRunning(String r1, String r2) {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean openUriFile(Uri r1, IUriFileReceiver r2, String r3) {
            IUriFileReceiver r0 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r2, IUriFileReceiver.class, "com.obric.aiagent.plugin");
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopAction(String r1, String r2) {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopComplexTask(String r1) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityActionHandler {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityActionHandler";
        public static final int TRANSACTION_getVersion = 1;
        public static final int TRANSACTION_handleAction = 2;
        public static final int TRANSACTION_handleIntentCalling = 3;
        public static final int TRANSACTION_isTaskRunning = 7;
        public static final int TRANSACTION_openUriFile = 4;
        public static final int TRANSACTION_stopAction = 6;
        public static final int TRANSACTION_stopComplexTask = 5;

        public static class Proxy implements ICapabilityActionHandler {
            public static ICapabilityActionHandler sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int getVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleAction(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().handleAction(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleIntentCalling(IntentCalling r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().handleIntentCalling(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int isTaskRunning(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().isTaskRunning(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean openUriFile(Uri r6, IUriFileReceiver r7, String r8) {
                IUriFileReceiver r9 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r7, IUriFileReceiver.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                if (r9 == null) goto L9;
                IBinder r4 = r9.asBinder();     // Catch: Throwable -> L23
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L23
                r0.writeString(r8);     // Catch: Throwable -> L23
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() != 0) goto L21;
                r2 = false;
            L21:
                r1.recycle();
                r0.recycle();
                return r2;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r5 = Stub.getDefaultImpl().openUriFile(r6, r9, r8);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return r5;
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopAction(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().stopAction(r5, r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopComplexTask(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().stopComplexTask(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityActionHandler asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICapabilityActionHandler.class) == false) goto L13;
            return (ICapabilityActionHandler) ZeusTransformUtils.preCheckCast(r0, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICapabilityActionHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityActionHandler r2) {
            ICapabilityActionHandler r3 = (ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r2, ICapabilityActionHandler.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L23;
            IntentCalling r3 = null;
            Uri r4 = null;
            switch(r5) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L17;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            int r9 = isTaskRunning(r6.readString(), r6.readString());
        L9:
            r7.writeNoException();
            r7.writeInt(r9);
            return true;
        L11:
            r6.enforceInterface(DESCRIPTOR);
            r9 = stopAction(r6.readString(), r6.readString());
            goto L9
        L12:
            r6.enforceInterface(DESCRIPTOR);
            r9 = stopComplexTask(r6.readString());
            goto L9
        L13:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L16;
            r4 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r6), Uri.class, "com.obric.aiagent.plugin");
        L16:
            r9 = openUriFile(r4, IUriFileReceiver.Stub.asInterface(r6.readStrongBinder()), r6.readString());
            goto L9
        L17:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L20;
            r3 = (IntentCalling) ZeusTransformUtils.preCheckCast(IntentCalling.CREATOR.createFromParcel(r6), IntentCalling.class, "com.obric.aiagent.plugin");
        L20:
            r9 = handleIntentCalling(r3);
            goto L9
        L21:
            r6.enforceInterface(DESCRIPTOR);
            r9 = handleAction(r6.readString());
            goto L9
        L22:
            r6.enforceInterface(DESCRIPTOR);
            r9 = getVersion();
            goto L9
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L23:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getVersion();

    boolean handleAction(String r1);

    boolean handleIntentCalling(IntentCalling r1);

    int isTaskRunning(String r1, String r2);

    boolean openUriFile(Uri r1, IUriFileReceiver r2, String r3);

    boolean stopAction(String r1, String r2);

    boolean stopComplexTask(String r1);
}
