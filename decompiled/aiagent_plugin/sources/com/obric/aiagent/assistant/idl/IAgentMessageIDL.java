package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentMessageIDL extends IInterface {

    public static class Default implements IAgentMessageIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
        public PicInfo getScreenPicInfo() {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentMessageIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentMessageIDL";
        static final int TRANSACTION_getScreenPicInfo = 1;

        private static class Proxy implements IAgentMessageIDL {
            public static IAgentMessageIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
            public PicInfo getScreenPicInfo() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                PicInfo r4 = (PicInfo) ZeusTransformUtils.preCheckCast(PicInfo.CREATOR.createFromParcel(r1), PicInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                PicInfo r5 = Stub.getDefaultImpl().getScreenPicInfo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
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

        public static IAgentMessageIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentMessageIDL.class) == false) goto L13;
            return (IAgentMessageIDL) ZeusTransformUtils.preCheckCast(r0, IAgentMessageIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            PicInfo r3 = getScreenPicInfo();
            r6.writeNoException();
            if (r3 == null) goto L13;
            r6.writeInt(1);
            r3.writeToParcel(r6, 1);
        L14:
            return true;
        L13:
            r6.writeInt(0);
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAgentMessageIDL r2) {
            IAgentMessageIDL r3 = (IAgentMessageIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentMessageIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentMessageIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    PicInfo getScreenPicInfo();
}
