package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IPlatformApiIDL extends IInterface {

    public static class Default implements IPlatformApiIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
        public List<String> getTasksPackages(int r1, boolean r2, boolean r3, int r4) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
        public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IPlatformApiIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IPlatformApiIDL";
        static final int TRANSACTION_getTasksPackages = 2;
        static final int TRANSACTION_moveTaskToDisplay = 1;

        private static class Proxy implements IPlatformApiIDL {
            public static IPlatformApiIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
            public boolean moveTaskToDisplay(int r6, int r7, boolean r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeInt(r6);     // Catch: Throwable -> L20
                r0.writeInt(r7);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r8 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
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
                boolean r5 = Stub.getDefaultImpl().moveTaskToDisplay(r6, r7, r8);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r4 = 0;
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
            public List<String> getTasksPackages(int r6, boolean r7, boolean r8, int r9) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r0.writeInt(r6);     // Catch: Throwable -> L21
                int r2 = 1;
                if (r7 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L21
                if (r8 == true) goto L11;
                r2 = 0;
            L11:
                r0.writeInt(r2);     // Catch: Throwable -> L21
                r0.writeInt(r9);     // Catch: Throwable -> L21
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                ArrayList<String> r5 = r1.createStringArrayList();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r5;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                List<String> r10 = Stub.getDefaultImpl().getTasksPackages(r6, r7, r8, r9);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r10;
            L6:
                r4 = 0;
            L21:
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

        public static IPlatformApiIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IPlatformApiIDL.class) == false) goto L13;
            return (IPlatformApiIDL) ZeusTransformUtils.preCheckCast(r0, IPlatformApiIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            boolean r0 = false;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            int r9 = r6.readInt();
            int r10 = r6.readInt();
            if (r6.readInt() == 0) goto L24;
            r0 = true;
        L24:
            boolean r4 = moveTaskToDisplay(r9, r10, r0);
            r7.writeNoException();
            r7.writeInt(r4 ? 1 : 0);
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            int r11 = r6.readInt();
            if (r6.readInt() == 0) goto L15;
            boolean r12 = true;
        L17:
            if (r6.readInt() == 0) goto L19;
            r0 = true;
        L19:
            List<String> r13 = getTasksPackages(r11, r12, r0, r6.readInt());
            r7.writeNoException();
            r7.writeStringList(r13);
            return true;
        L15:
            r12 = false;
            goto L17
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }

        public static boolean setDefaultImpl(IPlatformApiIDL r2) {
            IPlatformApiIDL r3 = (IPlatformApiIDL) ZeusTransformUtils.wrapperContextForParams(r2, IPlatformApiIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IPlatformApiIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    List<String> getTasksPackages(int r1, boolean r2, boolean r3, int r4);

    boolean moveTaskToDisplay(int r1, int r2, boolean r3);
}
