package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowPermissionIDL extends IInterface {

    public static class Default implements IFlowPermissionIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public Map isAppletPermissionGranted(String r1, List<String> r2) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public Map isPermissionGranted(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public Map isPersonalPermissionGranted(String r1, List<String> r2) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public boolean requestPermission(String r1, String r2) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public void updateAppletPermissions(List<Permission> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public void updatePersonalPermissions(List<Permission> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowPermissionIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowPermissionIDL";
        static final int TRANSACTION_isAppletPermissionGranted = 3;
        static final int TRANSACTION_isPermissionGranted = 1;
        static final int TRANSACTION_isPersonalPermissionGranted = 5;
        static final int TRANSACTION_requestPermission = 2;
        static final int TRANSACTION_updateAppletPermissions = 4;
        static final int TRANSACTION_updatePersonalPermissions = 6;

        private static class Proxy implements IFlowPermissionIDL {
            public static IFlowPermissionIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public Map isPermissionGranted(List<String> r6) {
                List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r7);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                HashMap r5 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r8 = Stub.getDefaultImpl().isPermissionGranted(r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public boolean requestPermission(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().requestPermission(r5, r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public Map isAppletPermissionGranted(String r6, List<String> r7) {
                List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeStringList(r8);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                HashMap r5 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r9 = Stub.getDefaultImpl().isAppletPermissionGranted(r6, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public void updateAppletPermissions(List<Permission> r5) {
                List<Permission> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateAppletPermissions(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public Map isPersonalPermissionGranted(String r6, List<String> r7) {
                List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeStringList(r8);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                HashMap r5 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r9 = Stub.getDefaultImpl().isPersonalPermissionGranted(r6, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public void updatePersonalPermissions(List<Permission> r5) {
                List<Permission> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updatePersonalPermissions(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
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

        public static IFlowPermissionIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowPermissionIDL.class) == false) goto L13;
            return (IFlowPermissionIDL) ZeusTransformUtils.preCheckCast(r0, IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            updatePersonalPermissions(r5.createTypedArrayList(Permission.CREATOR));
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            Map r3 = isPersonalPermissionGranted(r5.readString(), r5.createStringArrayList());
            r6.writeNoException();
            r6.writeMap(r3);
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            updateAppletPermissions(r5.createTypedArrayList(Permission.CREATOR));
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            Map r8 = isAppletPermissionGranted(r5.readString(), r5.createStringArrayList());
            r6.writeNoException();
            r6.writeMap(r8);
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = requestPermission(r5.readString(), r5.readString());
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            Map r10 = isPermissionGranted(r5.createStringArrayList());
            r6.writeNoException();
            r6.writeMap(r10);
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L19:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowPermissionIDL r2) {
            IFlowPermissionIDL r3 = (IFlowPermissionIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowPermissionIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    Map isAppletPermissionGranted(String r1, List<String> r2);

    Map isPermissionGranted(List<String> r1);

    Map isPersonalPermissionGranted(String r1, List<String> r2);

    boolean requestPermission(String r1, String r2);

    void updateAppletPermissions(List<Permission> r1);

    void updatePersonalPermissions(List<Permission> r1);
}
