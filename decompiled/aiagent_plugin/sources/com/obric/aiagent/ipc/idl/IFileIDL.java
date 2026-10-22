package com.obric.aiagent.ipc.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IFileIDL extends IInterface {

    public static class Default implements IFileIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public boolean deleteFile(FilePath r1) {
            return false;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public List listAllFile(FilePath r1) {
            return null;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public List listDir(FilePath r1) {
            return null;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public ParcelFileDescriptor openFile(FilePath r1, int r2) {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFileIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.ipc.idl.IFileIDL";
        static final int TRANSACTION_deleteFile = 4;
        static final int TRANSACTION_listAllFile = 3;
        static final int TRANSACTION_listDir = 2;
        static final int TRANSACTION_openFile = 1;

        private static class Proxy implements IFileIDL {
            public static IFileIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public ParcelFileDescriptor openFile(FilePath r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L21
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                ParcelFileDescriptor r4 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(ParcelFileDescriptor.CREATOR.createFromParcel(r1), ParcelFileDescriptor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ParcelFileDescriptor r7 = Stub.getDefaultImpl().openFile(r5, r6);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public List listDir(FilePath r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                ArrayList r5 = r1.readArrayList(getClass().getClassLoader());     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List r7 = Stub.getDefaultImpl().listDir(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public List listAllFile(FilePath r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                ArrayList r5 = r1.readArrayList(getClass().getClassLoader());     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List r7 = Stub.getDefaultImpl().listAllFile(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public boolean deleteFile(FilePath r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
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
                boolean r5 = Stub.getDefaultImpl().deleteFile(r6);     // Catch: Throwable -> L20
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
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFileIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFileIDL.class) == false) goto L13;
            return (IFileIDL) ZeusTransformUtils.preCheckCast(r0, IFileIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            FilePath r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L34;
            r1 = (FilePath) ZeusTransformUtils.preCheckCast(FilePath.CREATOR.createFromParcel(r7), FilePath.class, "com.obric.aiagent.plugin");
        L34:
            ParcelFileDescriptor r5 = openFile(r1, r7.readInt());
            r8.writeNoException();
            if (r5 == null) goto L37;
            r8.writeInt(1);
            r5.writeToParcel(r8, 1);
        L38:
            return true;
        L37:
            r8.writeInt(0);
            goto L38
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L29;
            r1 = (FilePath) ZeusTransformUtils.preCheckCast(FilePath.CREATOR.createFromParcel(r7), FilePath.class, "com.obric.aiagent.plugin");
        L29:
            List r10 = listDir(r1);
            r8.writeNoException();
            r8.writeList(r10);
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L24;
            r1 = (FilePath) ZeusTransformUtils.preCheckCast(FilePath.CREATOR.createFromParcel(r7), FilePath.class, "com.obric.aiagent.plugin");
        L24:
            List r11 = listAllFile(r1);
            r8.writeNoException();
            r8.writeList(r11);
            return true;
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L19;
            r1 = (FilePath) ZeusTransformUtils.preCheckCast(FilePath.CREATOR.createFromParcel(r7), FilePath.class, "com.obric.aiagent.plugin");
        L19:
            boolean r12 = deleteFile(r1);
            r8.writeNoException();
            r8.writeInt(r12 ? 1 : 0);
            return true;
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IFileIDL r2) {
            IFileIDL r3 = (IFileIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFileIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFileIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    boolean deleteFile(FilePath r1);

    List listAllFile(FilePath r1);

    List listDir(FilePath r1);

    ParcelFileDescriptor openFile(FilePath r1, int r2);
}
