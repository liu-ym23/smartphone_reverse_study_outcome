package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentSkillManagerObserverIDL extends IInterface {

    public static class Default implements IAgentSkillManagerObserverIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
        public void onSkillListChanged(long r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentSkillManagerObserverIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL";
        static final int TRANSACTION_onSkillListChanged = 1;

        private static class Proxy implements IAgentSkillManagerObserverIDL {
            public static IAgentSkillManagerObserverIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
            public void onSkillListChanged(long r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r4);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSkillListChanged(r4);     // Catch: Throwable -> L12
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

        public static IAgentSkillManagerObserverIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentSkillManagerObserverIDL.class) == false) goto L13;
            return (IAgentSkillManagerObserverIDL) ZeusTransformUtils.preCheckCast(r0, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onSkillListChanged(r5.readLong());
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAgentSkillManagerObserverIDL r2) {
            IAgentSkillManagerObserverIDL r3 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentSkillManagerObserverIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onSkillListChanged(long r1);
}
