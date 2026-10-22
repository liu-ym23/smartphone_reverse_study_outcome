package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentAssistantStateIDL extends IInterface {

    public static class Default implements IAgentAssistantStateIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentAssistantStateIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentAssistantStateIDL";

        private static class Proxy implements IAgentAssistantStateIDL {
            public static IAgentAssistantStateIDL sDefaultImpl;
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
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAgentAssistantStateIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentAssistantStateIDL.class) == false) goto L13;
            return (IAgentAssistantStateIDL) ZeusTransformUtils.preCheckCast(r0, IAgentAssistantStateIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) {
            if (r2 != 1598968902) goto L5;
            r4.writeString(DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r2, r3, r4, r5);
        }

        public static boolean setDefaultImpl(IAgentAssistantStateIDL r2) {
            IAgentAssistantStateIDL r3 = (IAgentAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentAssistantStateIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentAssistantStateIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
