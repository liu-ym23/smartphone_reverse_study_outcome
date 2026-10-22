package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.FeedbackBean;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowFeedbackIDL extends IInterface {

    public static class Default implements IFlowFeedbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFeedbackIDL
        public void onFeedback(FeedbackBean r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowFeedbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowFeedbackIDL";
        static final int TRANSACTION_onFeedback = 1;

        private static class Proxy implements IFlowFeedbackIDL {
            public static IFlowFeedbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowFeedbackIDL
            public void onFeedback(FeedbackBean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onFeedback(r4);     // Catch: Throwable -> L16
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

        public static IFlowFeedbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowFeedbackIDL.class) == false) goto L13;
            return (IFlowFeedbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L13;
            FeedbackBean r8 = (FeedbackBean) ZeusTransformUtils.preCheckCast(FeedbackBean.CREATOR.createFromParcel(r5), FeedbackBean.class, "com.obric.aiagent.plugin");
        L14:
            onFeedback(r8);
            return true;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IFlowFeedbackIDL r2) {
            IFlowFeedbackIDL r3 = (IFlowFeedbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFeedbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowFeedbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onFeedback(FeedbackBean r1);
}
