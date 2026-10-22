package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowAppIntentIDL extends IInterface {
    public static final String ACTION_BAR_KEY_FILE_PERCEIVE = "obric_document_perception";
    public static final String ACTION_BAR_KEY_IM_PERCEIVE = "obric_im_perception";
    public static final String ACTION_BAR_KEY_PHOTO_PERCEIVE = "obric_photo_perception";
    public static final String ACTION_BAR_KEY_SCREEN_SHOT = "obric_screen_qa";
    public static final String ACTION_BAR_KEY_VIDEO_PERCEIVE = "obric_video_perception";
    public static final String ACTION_BAR_KEY_WEB_PERCEIVE = "obric_web_perception";
    public static final String PARAM_APPLET_ID = "appletId";
    public static final String PERMISSION_BACKGROUND_LOCATION = "BACKGROUND_LOCATION";
    public static final String PERMISSION_CALENDAR = "calendar";
    public static final String PERMISSION_LOCATION = "location";
    public static final String PERMISSION_NOTIFICATION = "notification";

    public static class Default implements IFlowAppIntentIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean checkPermission(String r1, boolean r2, long r3) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public long currentTimeMillis() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void getLocation(IFlowGetLocationCallbackIDL r2) {
            IFlowGetLocationCallbackIDL r1 = (IFlowGetLocationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public OTaskTimeoutConfig getObricTaskTimeoutConfig() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public String getUserId() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean isDoraConnected() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean isEnterpriseAccount() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean isLogin() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void jumpDoraPage() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean openMiniApp(String r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void setAppIntentActive(boolean r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void stopComplexTask(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean syncAppletData(String r1) {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppIntentIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowAppIntentIDL";
        static final int TRANSACTION_checkPermission = 2;
        static final int TRANSACTION_currentTimeMillis = 9;
        static final int TRANSACTION_getLocation = 11;
        static final int TRANSACTION_getObricTaskTimeoutConfig = 6;
        static final int TRANSACTION_getUserId = 10;
        static final int TRANSACTION_isDoraConnected = 7;
        static final int TRANSACTION_isEnterpriseAccount = 5;
        static final int TRANSACTION_isLogin = 4;
        static final int TRANSACTION_jumpDoraPage = 8;
        static final int TRANSACTION_openMiniApp = 12;
        static final int TRANSACTION_setAppIntentActive = 1;
        static final int TRANSACTION_stopComplexTask = 3;
        static final int TRANSACTION_syncAppletData = 13;

        private static class Proxy implements IFlowAppIntentIDL {
            public static IFlowAppIntentIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void setAppIntentActive(boolean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAppIntentActive(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean checkPermission(String r6, boolean r7, long r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeString(r6);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                r0.writeLong(r8);     // Catch: Throwable -> L20
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
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
                boolean r5 = Stub.getDefaultImpl().checkPermission(r6, r7, r8);     // Catch: Throwable -> L20
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

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void stopComplexTask(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopComplexTask(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean isLogin() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isLogin();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean isEnterpriseAccount() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().isEnterpriseAccount();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public OTaskTimeoutConfig getObricTaskTimeoutConfig() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                OTaskTimeoutConfig r4 = (OTaskTimeoutConfig) ZeusTransformUtils.preCheckCast(OTaskTimeoutConfig.CREATOR.createFromParcel(r1), OTaskTimeoutConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OTaskTimeoutConfig r5 = Stub.getDefaultImpl().getObricTaskTimeoutConfig();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean isDoraConnected() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isDoraConnected();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void jumpDoraPage() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().jumpDoraPage();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public long currentTimeMillis() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().currentTimeMillis();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public String getUserId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getUserId();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void getLocation(IFlowGetLocationCallbackIDL r5) {
                IFlowGetLocationCallbackIDL r6 = (IFlowGetLocationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
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
                Stub.getDefaultImpl().getLocation(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean openMiniApp(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().openMiniApp(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean syncAppletData(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().syncAppletData(r5);     // Catch: Throwable -> L15
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

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAppIntentIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowAppIntentIDL.class) == false) goto L13;
            return (IFlowAppIntentIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L43;
            boolean r0 = false;
            switch(r5) {
                case 1: goto L38;
                case 2: goto L33;
                case 3: goto L31;
                case 4: goto L29;
                case 5: goto L27;
                case 6: goto L22;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            boolean r4 = syncAppletData(r6.readString());
            r7.writeNoException();
            r7.writeInt(r4 ? 1 : 0);
            return true;
        L10:
            r6.enforceInterface(DESCRIPTOR);
            boolean r9 = openMiniApp(r6.readString());
            r7.writeNoException();
            r7.writeInt(r9 ? 1 : 0);
            return true;
        L12:
            r6.enforceInterface(DESCRIPTOR);
            getLocation(IFlowGetLocationCallbackIDL.Stub.asInterface(r6.readStrongBinder()));
            return true;
        L14:
            r6.enforceInterface(DESCRIPTOR);
            String r10 = getUserId();
            r7.writeNoException();
            r7.writeString(r10);
            return true;
        L16:
            r6.enforceInterface(DESCRIPTOR);
            long r11 = currentTimeMillis();
            r7.writeNoException();
            r7.writeLong(r11);
            return true;
        L18:
            r6.enforceInterface(DESCRIPTOR);
            jumpDoraPage();
            return true;
        L20:
            r6.enforceInterface(DESCRIPTOR);
            boolean r12 = isDoraConnected();
            r7.writeNoException();
            r7.writeInt(r12 ? 1 : 0);
            return true;
        L22:
            r6.enforceInterface(DESCRIPTOR);
            OTaskTimeoutConfig r13 = getObricTaskTimeoutConfig();
            r7.writeNoException();
            if (r13 == null) goto L25;
            r7.writeInt(1);
            r13.writeToParcel(r7, 1);
        L26:
            return true;
        L25:
            r7.writeInt(0);
            goto L26
        L27:
            r6.enforceInterface(DESCRIPTOR);
            boolean r14 = isEnterpriseAccount();
            r7.writeNoException();
            r7.writeInt(r14 ? 1 : 0);
            return true;
        L29:
            r6.enforceInterface(DESCRIPTOR);
            boolean r15 = isLogin();
            r7.writeNoException();
            r7.writeInt(r15 ? 1 : 0);
            return true;
        L31:
            r6.enforceInterface(DESCRIPTOR);
            stopComplexTask(r6.readString());
            return true;
        L33:
            r6.enforceInterface(DESCRIPTOR);
            String r16 = r6.readString();
            if (r6.readInt() == 0) goto L36;
            r0 = true;
        L36:
            boolean r17 = checkPermission(r16, r0, r6.readLong());
            r7.writeNoException();
            r7.writeInt(r17 ? 1 : 0);
            return true;
        L38:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L41;
            r0 = true;
        L41:
            setAppIntentActive(r0);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L43:
            r7.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowAppIntentIDL r2) {
            IFlowAppIntentIDL r3 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowAppIntentIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    boolean checkPermission(String r1, boolean r2, long r3);

    long currentTimeMillis();

    void getLocation(IFlowGetLocationCallbackIDL r1);

    OTaskTimeoutConfig getObricTaskTimeoutConfig();

    String getUserId();

    boolean isDoraConnected();

    boolean isEnterpriseAccount();

    boolean isLogin();

    void jumpDoraPage();

    boolean openMiniApp(String r1);

    void setAppIntentActive(boolean r1);

    void stopComplexTask(String r1);

    boolean syncAppletData(String r1);
}
