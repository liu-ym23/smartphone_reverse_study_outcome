package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentSkillManagerIDL extends IInterface {

    public static class Default implements IAgentSkillManagerIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public long getSkillListVersion() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public OSkillManagerConfig getSkillManagerConfig() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public String getSkillManagerStatus(String r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public List<OSkill> listSkills() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public void registerSkillObserver(IAgentSkillManagerObserverIDL r2) {
            IAgentSkillManagerObserverIDL r1 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public boolean setSkillManagerConfigValues(Bundle r1) {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentSkillManagerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL";
        static final int TRANSACTION_getSkillListVersion = 2;
        static final int TRANSACTION_getSkillManagerConfig = 7;
        static final int TRANSACTION_getSkillManagerStatus = 9;
        static final int TRANSACTION_listSkills = 1;
        static final int TRANSACTION_registerSkillObserver = 3;
        static final int TRANSACTION_setSkillManagerConfigValues = 8;

        private static class Proxy implements IAgentSkillManagerIDL {
            public static IAgentSkillManagerIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public List<OSkill> listSkills() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(OSkill.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<OSkill> r5 = Stub.getDefaultImpl().listSkills();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public long getSkillListVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().getSkillListVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public void registerSkillObserver(IAgentSkillManagerObserverIDL r5) {
                IAgentSkillManagerObserverIDL r6 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
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
                Stub.getDefaultImpl().registerSkillObserver(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public OSkillManagerConfig getSkillManagerConfig() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                OSkillManagerConfig r4 = (OSkillManagerConfig) ZeusTransformUtils.preCheckCast(OSkillManagerConfig.CREATOR.createFromParcel(r1), OSkillManagerConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OSkillManagerConfig r5 = Stub.getDefaultImpl().getSkillManagerConfig();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public boolean setSkillManagerConfigValues(Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
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
                boolean r5 = Stub.getDefaultImpl().setSkillManagerConfigValues(r6);     // Catch: Throwable -> L20
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

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public String getSkillManagerStatus(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r6 = Stub.getDefaultImpl().getSkillManagerStatus(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
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

        public static IAgentSkillManagerIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentSkillManagerIDL.class) == false) goto L13;
            return (IAgentSkillManagerIDL) ZeusTransformUtils.preCheckCast(r0, IAgentSkillManagerIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            List<OSkill> r3 = listSkills();
            r6.writeNoException();
            r6.writeTypedList(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            long r8 = getSkillListVersion();
            r6.writeNoException();
            r6.writeLong(r8);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            registerSkillObserver(IAgentSkillManagerObserverIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L9:
            if (r4 != 7) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            OSkillManagerConfig r9 = getSkillManagerConfig();
            r6.writeNoException();
            if (r9 == null) goto L31;
            r6.writeInt(1);
            r9.writeToParcel(r6, 1);
        L32:
            return true;
        L31:
            r6.writeInt(0);
            goto L32
        L11:
            if (r4 != 8) goto L13;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L25;
            Bundle r10 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.aiagent.plugin");
        L26:
            boolean r11 = setSkillManagerConfigValues(r10);
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            return true;
        L25:
            r10 = null;
            goto L26
        L13:
            if (r4 != 9) goto L15;
            r5.enforceInterface(DESCRIPTOR);
            String r12 = getSkillManagerStatus(r5.readString());
            r6.writeNoException();
            r6.writeString(r12);
            return true;
        L15:
            if (r4 != 1598968902) goto L17;
            r6.writeString(DESCRIPTOR);
            return true;
        L17:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAgentSkillManagerIDL r2) {
            IAgentSkillManagerIDL r3 = (IAgentSkillManagerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentSkillManagerIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentSkillManagerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    long getSkillListVersion();

    OSkillManagerConfig getSkillManagerConfig();

    String getSkillManagerStatus(String r1);

    List<OSkill> listSkills();

    void registerSkillObserver(IAgentSkillManagerObserverIDL r1);

    boolean setSkillManagerConfigValues(Bundle r1);
}
