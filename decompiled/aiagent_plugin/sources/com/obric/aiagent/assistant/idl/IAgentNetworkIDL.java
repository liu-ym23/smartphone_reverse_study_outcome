package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentNetworkIDL extends IInterface {

    public static class Default implements IAgentNetworkIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
        public void notifyRequestStatus(boolean r1, Map r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
        public void updateExcludeRules(RequestRestrictRule r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentNetworkIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentNetworkIDL";
        static final int TRANSACTION_notifyRequestStatus = 1;
        static final int TRANSACTION_updateExcludeRules = 2;

        private static class Proxy implements IAgentNetworkIDL {
            public static IAgentNetworkIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
            public void notifyRequestStatus(boolean r4, Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                r0.writeMap(r6);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyRequestStatus(r4, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
            public void updateExcludeRules(RequestRestrictRule r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateExcludeRules(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
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

        public static IAgentNetworkIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentNetworkIDL.class) == false) goto L13;
            return (IAgentNetworkIDL) ZeusTransformUtils.preCheckCast(r0, IAgentNetworkIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L21;
            boolean r8 = true;
        L22:
            notifyRequestStatus(r8, r5.readHashMap(getClass().getClassLoader()));
            return true;
        L21:
            r8 = false;
            goto L22
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L15;
            RequestRestrictRule r9 = (RequestRestrictRule) ZeusTransformUtils.preCheckCast(RequestRestrictRule.CREATOR.createFromParcel(r5), RequestRestrictRule.class, "com.obric.aiagent.plugin");
        L16:
            updateExcludeRules(r9);
            return true;
        L15:
            r9 = null;
            goto L16
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAgentNetworkIDL r2) {
            IAgentNetworkIDL r3 = (IAgentNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentNetworkIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentNetworkIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void notifyRequestStatus(boolean r1, Map r2);

    void updateExcludeRules(RequestRestrictRule r1);
}
