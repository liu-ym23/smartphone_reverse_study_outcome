package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ICapabilityFeedbackReceiver extends IInterface {

    public static class Default implements ICapabilityFeedbackReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isCardViewVisible(long r1) {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isKeyguardReallyLocked() {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onActionResultRecv(String r1, String r2, boolean r3) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onFinishFloatingActivity(long r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onHideIntentResultCard(long r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onJobResultRecv(String r1, String r2, boolean r3, JobResult r4) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResult(long r1, IntentResult r3, boolean r4, Map r5) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResultWithRequest(String r1, IntentResult r2, boolean r3, Map r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityFeedbackReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityFeedbackReceiver";
        public static final int TRANSACTION_isCardViewVisible = 6;
        public static final int TRANSACTION_isKeyguardReallyLocked = 7;
        public static final int TRANSACTION_onActionResultRecv = 1;
        public static final int TRANSACTION_onFinishFloatingActivity = 5;
        public static final int TRANSACTION_onHideIntentResultCard = 3;
        public static final int TRANSACTION_onJobResultRecv = 4;
        public static final int TRANSACTION_onUpdateIntentResult = 2;
        public static final int TRANSACTION_onUpdateIntentResultWithRequest = 8;

        public static class Proxy implements ICapabilityFeedbackReceiver {
            public static ICapabilityFeedbackReceiver sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isCardViewVisible(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isCardViewVisible(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isKeyguardReallyLocked() {
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
                boolean r4 = Stub.getDefaultImpl().isKeyguardReallyLocked();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onActionResultRecv(String r4, String r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r4);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onActionResultRecv(r4, r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onFinishFloatingActivity(long r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onFinishFloatingActivity(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onHideIntentResultCard(long r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onHideIntentResultCard(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onJobResultRecv(String r5, String r6, boolean r7, JobResult r8) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onJobResultRecv(r5, r6, r7, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResult(long r7, IntentResult r9, boolean r10, Map r11) {
                Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r12.writeLong(r7);     // Catch: Throwable -> L16
                if (r9 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L16
                r9.writeToParcel(r12, 0);     // Catch: Throwable -> L16
            L7:
                r12.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L16
                r12.writeMap(r5);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r12, null, 1) == false) goto L10;
            L14:
                r12.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResult(r7, r9, r10, r5);     // Catch: Throwable -> L16
                r12.recycle();
                return;
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResultWithRequest(String r5, IntentResult r6, boolean r7, Map r8) {
                Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L16
                r0.writeMap(r9);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResultWithRequest(r5, r6, r7, r9);     // Catch: Throwable -> L16
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityFeedbackReceiver asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICapabilityFeedbackReceiver.class) == false) goto L13;
            return (ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(r0, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICapabilityFeedbackReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityFeedbackReceiver r2) {
            ICapabilityFeedbackReceiver r3 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r2, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) {
            if (r8 == 1598968902) goto L46;
            IntentResult<?> r2 = null;
            IntentResult<?> r3 = null;
            JobResult r4 = null;
            boolean r5 = false;
            switch(r8) {
                case 1: goto L41;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r9.enforceInterface(DESCRIPTOR);
            String r12 = r9.readString();
            if (r9.readInt() == 0) goto L12;
            r3 = IntentResult.CREATOR.a(r9);
        L12:
            if (r9.readInt() == 0) goto L14;
            r5 = true;
        L14:
            onUpdateIntentResultWithRequest(r12, r3, r5, r9.readHashMap(getClass().getClassLoader()));
            return true;
        L16:
            r9.enforceInterface(DESCRIPTOR);
            boolean r7 = isKeyguardReallyLocked();
            r10.writeNoException();
            r10.writeInt(r7 ? 1 : 0);
            return true;
        L18:
            r9.enforceInterface(DESCRIPTOR);
            boolean r13 = isCardViewVisible(r9.readLong());
            r10.writeNoException();
            r10.writeInt(r13 ? 1 : 0);
            return true;
        L20:
            r9.enforceInterface(DESCRIPTOR);
            onFinishFloatingActivity(r9.readLong());
            return true;
        L22:
            r9.enforceInterface(DESCRIPTOR);
            String r14 = r9.readString();
            String r15 = r9.readString();
            if (r9.readInt() == 0) goto L26;
            r5 = true;
        L26:
            if (r9.readInt() == 0) goto L28;
            r4 = (JobResult) ZeusTransformUtils.preCheckCast(JobResult.CREATOR.createFromParcel(r9), JobResult.class, "com.obric.aiagent.plugin");
        L28:
            onJobResultRecv(r14, r15, r5, r4);
            return true;
        L30:
            r9.enforceInterface(DESCRIPTOR);
            onHideIntentResultCard(r9.readLong());
            return true;
        L32:
            r9.enforceInterface(DESCRIPTOR);
            long r16 = r9.readLong();
            if (r9.readInt() == 0) goto L35;
            r2 = IntentResult.CREATOR.a(r9);
        L35:
            IntentResult<?> r6 = r2;
            if (r9.readInt() == 0) goto L38;
            boolean r17 = true;
        L39:
            onUpdateIntentResult(r16, r6, r17, r9.readHashMap(getClass().getClassLoader()));
            return true;
        L38:
            r17 = false;
            goto L39
        L41:
            r9.enforceInterface(DESCRIPTOR);
            String r18 = r9.readString();
            String r19 = r9.readString();
            if (r9.readInt() == 0) goto L44;
            r5 = true;
        L44:
            onActionResultRecv(r18, r19, r5);
            return true;
        L7:
            return super.onTransact(r8, r9, r10, r11);
        L46:
            r10.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean isCardViewVisible(long r1);

    boolean isKeyguardReallyLocked();

    void onActionResultRecv(String r1, String r2, boolean r3);

    void onFinishFloatingActivity(long r1);

    void onHideIntentResultCard(long r1);

    void onJobResultRecv(String r1, String r2, boolean r3, JobResult r4);

    void onUpdateIntentResult(long r1, IntentResult r3, boolean r4, Map r5);

    void onUpdateIntentResultWithRequest(String r1, IntentResult r2, boolean r3, Map r4);
}
