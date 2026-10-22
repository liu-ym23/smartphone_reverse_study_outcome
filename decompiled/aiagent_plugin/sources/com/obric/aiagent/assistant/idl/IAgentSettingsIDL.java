package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentSettingsIDL extends IInterface {

    public static class Default implements IAgentSettingsIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
        public boolean isAutoGuiInstall() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
        public boolean isMemoryRecommendActivityEnabled() {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
        public void setSystemProperty(String r1, String r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentSettingsIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentSettingsIDL";
        static final int TRANSACTION_isAutoGuiInstall = 1;
        static final int TRANSACTION_isMemoryRecommendActivityEnabled = 2;
        static final int TRANSACTION_setSystemProperty = 3;

        private static class Proxy implements IAgentSettingsIDL {
            public static IAgentSettingsIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
            public boolean isAutoGuiInstall() {
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
                boolean r4 = Stub.getDefaultImpl().isAutoGuiInstall();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
            public boolean isMemoryRecommendActivityEnabled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
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
                boolean r4 = Stub.getDefaultImpl().isMemoryRecommendActivityEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
            public void setSystemProperty(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setSystemProperty(r5, r6);     // Catch: Throwable -> L12
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

        public static IAgentSettingsIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentSettingsIDL.class) == false) goto L13;
            return (IAgentSettingsIDL) ZeusTransformUtils.preCheckCast(r0, IAgentSettingsIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            boolean r3 = isAutoGuiInstall();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = isMemoryRecommendActivityEnabled();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            setSystemProperty(r5.readString(), r5.readString());
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAgentSettingsIDL r2) {
            IAgentSettingsIDL r3 = (IAgentSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentSettingsIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentSettingsIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    boolean isAutoGuiInstall();

    boolean isMemoryRecommendActivityEnabled();

    void setSystemProperty(String r1, String r2);
}
