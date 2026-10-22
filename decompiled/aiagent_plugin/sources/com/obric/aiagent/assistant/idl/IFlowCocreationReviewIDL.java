package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowCocreationReviewIDL extends IInterface {

    public static class Default implements IFlowCocreationReviewIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
        public void logOmniStep(String r1, long r2, String r4, int r5, String r6, String r7, boolean r8, boolean r9, long r10, String r12) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
        public void logOmniUserStop(String r1, long r2, String r4, long r5, String r7, String r8) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowCocreationReviewIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL";
        static final int TRANSACTION_logOmniStep = 1;
        static final int TRANSACTION_logOmniUserStop = 2;

        private static class Proxy implements IFlowCocreationReviewIDL {
            public static IFlowCocreationReviewIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
            public void logOmniStep(String r16, long r17, String r19, int r20, String r21, String r22, boolean r23, boolean r24, long r25, String r27) {
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r1.writeString(r16);     // Catch: Throwable -> L19
                r1.writeLong(r17);     // Catch: Throwable -> L19
                r1.writeString(r19);     // Catch: Throwable -> L19
                r1.writeInt(r20);     // Catch: Throwable -> L19
                r1.writeString(r21);     // Catch: Throwable -> L19
                r1.writeString(r22);     // Catch: Throwable -> L19
                int r2 = 0;
                if (r23 == false) goto L6;
                int r10 = 1;
            L7:
                r1.writeInt(r10);     // Catch: Throwable -> L19
                if (r24 == false) goto L10;
                r2 = 1;
            L10:
                r1.writeInt(r2);     // Catch: Throwable -> L19
                r1.writeLong(r25);     // Catch: Throwable -> L19
                r1.writeString(r27);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r1, null, 1) == false) goto L13;
            L17:
                r1.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().logOmniStep(r16, r17, r19, r20, r21, r22, r23, r24, r25, r27);     // Catch: Throwable -> L19
                r1.recycle();
                return;
            L6:
                r10 = 0;
            L19:
                th = move-exception;
                r1.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
            public void logOmniUserStop(String r14, long r15, String r17, long r18, String r20, String r21) {
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r1.writeString(r14);     // Catch: Throwable -> L12
                r1.writeLong(r15);     // Catch: Throwable -> L12
                r1.writeString(r17);     // Catch: Throwable -> L12
                r1.writeLong(r18);     // Catch: Throwable -> L12
                r1.writeString(r20);     // Catch: Throwable -> L12
                r1.writeString(r21);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r1, null, 1) == false) goto L6;
            L10:
                r1.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().logOmniUserStop(r14, r15, r17, r18, r20, r21);     // Catch: Throwable -> L12
                r1.recycle();
                return;
            L12:
                th = move-exception;
                r1.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowCocreationReviewIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowCocreationReviewIDL.class) == false) goto L13;
            return (IFlowCocreationReviewIDL) ZeusTransformUtils.preCheckCast(r0, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r27, Parcel r28, Parcel r29, int r30) {
            if (r27 != 1) goto L5;
            r28.enforceInterface(DESCRIPTOR);
            String r14 = r28.readString();
            long r15 = r28.readLong();
            String r17 = r28.readString();
            int r18 = r28.readInt();
            String r19 = r28.readString();
            String r20 = r28.readString();
            if (r28.readInt() == 0) goto L17;
            boolean r21 = true;
        L19:
            if (r28.readInt() == 0) goto L21;
            boolean r22 = true;
        L22:
            logOmniStep(r14, r15, r17, r18, r19, r20, r21, r22, r28.readLong(), r28.readString());
            return true;
        L21:
            r22 = false;
            goto L22
        L17:
            r21 = false;
            goto L19
        L5:
            if (r27 != 2) goto L7;
            r28.enforceInterface(DESCRIPTOR);
            logOmniUserStop(r28.readString(), r28.readLong(), r28.readString(), r28.readLong(), r28.readString(), r28.readString());
            return true;
        L7:
            if (r27 != 1598968902) goto L9;
            r29.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r27, r28, r29, r30);
        }

        public static boolean setDefaultImpl(IFlowCocreationReviewIDL r2) {
            IFlowCocreationReviewIDL r3 = (IFlowCocreationReviewIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowCocreationReviewIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void logOmniStep(String r1, long r2, String r4, int r5, String r6, String r7, boolean r8, boolean r9, long r10, String r12);

    void logOmniUserStop(String r1, long r2, String r4, long r5, String r7, String r8);
}
