package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowNetworkIDL extends IInterface {

    public static class Default implements IFlowNetworkIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void clearOmniTasks(Map r2, IFlowNetworkResultCallbackIDL r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r4 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void createConditionalTask(String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, Map r18, IFlowNetworkResultCallbackIDL r19) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r1 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r19, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void deleteConditionalTask(String r1, Map r2, IFlowNetworkResultCallbackIDL r3) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r4 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public int getCurrentNetworkStatus() {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyStopComplexTaskByHttp(long r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyStopComplexTaskByHttpWithScene(long r1, String r3) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyStopOmniTaskByHttp(String r1, Map r2, IFlowNetworkResultCallbackIDL r3) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r4 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyUserOperateQueue(String r1, IFlowNetworkResultCallbackIDL r2) {
            IFlowNetworkResultCallbackIDL r0 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r1, boolean r2, IFlowNetworkResultCallbackIDL r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r4 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendIntentResultForCompensationByHttp(List<OPushEvent> r1, boolean r2, IFlowNetworkResultCallbackIDL r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r4 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendNormalRouterByHttp(String r1, String r2, IFlowNetworkResultCallbackIDL r3) {
            IFlowNetworkResultCallbackIDL r0 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendReplyAskUserByHttp(String r1, String r2, String r3, Map r4, IFlowNetworkResultCallbackIDL r5) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sweepConditionalTask(ObricConditionalTaskSweepRequest r1, IFlowNetworkResultCallbackIDL r2) {
            IFlowNetworkResultCallbackIDL r0 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniDataFeedbackByHttp(String r1, String r2, int r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12, String r13, String r14, IFlowNetworkResultCallbackIDL r15) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r16 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r15, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniDataFeedbackByHttpV2(String r4, String r5, int r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, List<String> r15, String r16, String r17, boolean r18, IFlowNetworkResultCallbackIDL r19) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r1 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r19, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniScreenshotByHttp(String r1, String r2, int r3, String r4, String r5, String r6, String r7, List<String> r8, String r9, String r10, IFlowNetworkResultCallbackIDL r11) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r12 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r11, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniScreenshotByHttpV2(String r1, String r2, int r3, String r4, String r5, String r6, String r7, List<String> r8, String r9, String r10, boolean r11, IFlowNetworkResultCallbackIDL r12) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r13 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r12, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadUserTakeOverByHttp(String r1, String r2, String r3, long r4, Map r6, IFlowNetworkResultCallbackIDL r7) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowNetworkIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowNetworkIDL";
        static final int TRANSACTION_clearOmniTasks = 11;
        static final int TRANSACTION_createConditionalTask = 13;
        static final int TRANSACTION_deleteConditionalTask = 15;
        static final int TRANSACTION_getCurrentNetworkStatus = 6;
        static final int TRANSACTION_notifyStopComplexTaskByHttp = 5;
        static final int TRANSACTION_notifyStopComplexTaskByHttpWithScene = 12;
        static final int TRANSACTION_notifyStopOmniTaskByHttp = 10;
        static final int TRANSACTION_notifyUserOperateQueue = 9;
        static final int TRANSACTION_sendIntentResultForAsyncNotifyByHttp = 2;
        static final int TRANSACTION_sendIntentResultForCompensationByHttp = 1;
        static final int TRANSACTION_sendNormalRouterByHttp = 3;
        static final int TRANSACTION_sendReplyAskUserByHttp = 4;
        static final int TRANSACTION_sweepConditionalTask = 14;
        static final int TRANSACTION_uploadOmniDataFeedbackByHttp = 16;
        static final int TRANSACTION_uploadOmniDataFeedbackByHttpV2 = 18;
        static final int TRANSACTION_uploadOmniScreenshotByHttp = 8;
        static final int TRANSACTION_uploadOmniScreenshotByHttpV2 = 17;
        static final int TRANSACTION_uploadUserTakeOverByHttp = 7;

        private static class Proxy implements IFlowNetworkIDL {
            public static IFlowNetworkIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendIntentResultForCompensationByHttp(List<OPushEvent> r5, boolean r6, IFlowNetworkResultCallbackIDL r7) {
                List<OPushEvent> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r9 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeTypedList(r8);     // Catch: Throwable -> L20
                if (r6 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L20
                if (r9 == null) goto L10;
                IBinder r3 = r9.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendIntentResultForCompensationByHttp(r8, r6, r9);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r2 = 0;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r5, boolean r6, IFlowNetworkResultCallbackIDL r7) {
                List<OPushEvent> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r9 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeTypedList(r8);     // Catch: Throwable -> L20
                if (r6 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L20
                if (r9 == null) goto L10;
                IBinder r3 = r9.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendIntentResultForAsyncNotifyByHttp(r8, r6, r9);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r2 = 0;
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendNormalRouterByHttp(String r5, String r6, IFlowNetworkResultCallbackIDL r7) {
                IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendNormalRouterByHttp(r5, r6, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendReplyAskUserByHttp(String r9, String r10, String r11, Map r12, IFlowNetworkResultCallbackIDL r13) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r13, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r14.writeString(r9);     // Catch: Throwable -> L16
                r14.writeString(r10);     // Catch: Throwable -> L16
                r14.writeString(r11);     // Catch: Throwable -> L16
                r14.writeMap(r6);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r0 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r14.writeStrongBinder(r0);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r14, null, 1) == false) goto L10;
            L14:
                r14.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendReplyAskUserByHttp(r9, r10, r11, r6, r7);     // Catch: Throwable -> L16
                r14.recycle();
                return;
            L6:
                r0 = null;
            L16:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyStopComplexTaskByHttp(long r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopComplexTaskByHttp(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public int getCurrentNetworkStatus() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getCurrentNetworkStatus();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadUserTakeOverByHttp(String r13, String r14, String r15, long r16, Map r18, IFlowNetworkResultCallbackIDL r19) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r9 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r19, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r1.writeString(r13);     // Catch: Throwable -> L16
                r1.writeString(r14);     // Catch: Throwable -> L16
                r1.writeString(r15);     // Catch: Throwable -> L16
                r1.writeLong(r16);     // Catch: Throwable -> L16
                r1.writeMap(r8);     // Catch: Throwable -> L16
                if (r9 == null) goto L6;
                IBinder r3 = r9.asBinder();     // Catch: Throwable -> L16
            L7:
                r1.writeStrongBinder(r3);     // Catch: Throwable -> L16
                if (this.mRemote.transact(7, r1, null, 1) == false) goto L10;
            L14:
                r1.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadUserTakeOverByHttp(r13, r14, r15, r16, r8, r9);     // Catch: Throwable -> L16
                r1.recycle();
                return;
            L6:
                r3 = null;
            L16:
                th = move-exception;
                r1.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniScreenshotByHttp(String r17, String r18, int r19, String r20, String r21, String r22, String r23, List<String> r24, String r25, String r26, IFlowNetworkResultCallbackIDL r27) {
                List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r13 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r1.writeString(r17);     // Catch: Throwable -> L16
                r1.writeString(r18);     // Catch: Throwable -> L16
                r1.writeInt(r19);     // Catch: Throwable -> L16
                r1.writeString(r20);     // Catch: Throwable -> L16
                r1.writeString(r21);     // Catch: Throwable -> L16
                r1.writeString(r22);     // Catch: Throwable -> L16
                r1.writeString(r23);     // Catch: Throwable -> L16
                r1.writeStringList(r10);     // Catch: Throwable -> L16
                r1.writeString(r25);     // Catch: Throwable -> L16
                r1.writeString(r26);     // Catch: Throwable -> L16
                if (r13 == null) goto L6;
                IBinder r3 = r13.asBinder();     // Catch: Throwable -> L16
            L7:
                r1.writeStrongBinder(r3);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r1, null, 1) == false) goto L10;
            L14:
                r1.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadOmniScreenshotByHttp(r17, r18, r19, r20, r21, r22, r23, r10, r25, r26, r13);     // Catch: Throwable -> L16
                r1.recycle();
                return;
            L6:
                r3 = null;
            L16:
                th = move-exception;
                r1.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyUserOperateQueue(String r5, IFlowNetworkResultCallbackIDL r6) {
                IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyUserOperateQueue(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyStopOmniTaskByHttp(String r5, Map r6, IFlowNetworkResultCallbackIDL r7) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r9 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeMap(r8);     // Catch: Throwable -> L16
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyStopOmniTaskByHttp(r5, r8, r9);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void clearOmniTasks(Map r5, IFlowNetworkResultCallbackIDL r6) {
                Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeMap(r7);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().clearOmniTasks(r7, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyStopComplexTaskByHttpWithScene(long r5, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(12, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopComplexTaskByHttpWithScene(r5, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void createConditionalTask(String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, Map r34, IFlowNetworkResultCallbackIDL r35) {
                Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r18 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r35, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r1.writeString(r20);     // Catch: Throwable -> L16
                r1.writeString(r21);     // Catch: Throwable -> L16
                r1.writeString(r22);     // Catch: Throwable -> L16
                r1.writeString(r23);     // Catch: Throwable -> L16
                r1.writeString(r24);     // Catch: Throwable -> L16
                r1.writeString(r25);     // Catch: Throwable -> L16
                r1.writeString(r26);     // Catch: Throwable -> L16
                r1.writeString(r27);     // Catch: Throwable -> L16
                r1.writeString(r28);     // Catch: Throwable -> L16
                r1.writeString(r29);     // Catch: Throwable -> L16
                r1.writeString(r30);     // Catch: Throwable -> L16
                r1.writeString(r31);     // Catch: Throwable -> L16
                r1.writeString(r32);     // Catch: Throwable -> L16
                r1.writeString(r33);     // Catch: Throwable -> L16
                r1.writeMap(r0);     // Catch: Throwable -> L16
                if (r18 == null) goto L6;
                IBinder r2 = r18.asBinder();     // Catch: Throwable -> L16
            L7:
                r1.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(13, r1, null, 1) == false) goto L10;
            L14:
                r1.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().createConditionalTask(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r0, r18);     // Catch: Throwable -> L16
                r1.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r1.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sweepConditionalTask(ObricConditionalTaskSweepRequest r5, IFlowNetworkResultCallbackIDL r6) {
                IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (r7 == null) goto L10;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sweepConditionalTask(r5, r7);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void deleteConditionalTask(String r5, Map r6, IFlowNetworkResultCallbackIDL r7) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r9 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeMap(r8);     // Catch: Throwable -> L16
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(15, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().deleteConditionalTask(r5, r8, r9);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniDataFeedbackByHttp(String r19, String r20, int r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, List<String> r30, String r31, String r32, IFlowNetworkResultCallbackIDL r33) {
                List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r17 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r1.writeString(r19);     // Catch: Throwable -> L16
                r1.writeString(r20);     // Catch: Throwable -> L16
                r1.writeInt(r21);     // Catch: Throwable -> L16
                r1.writeString(r22);     // Catch: Throwable -> L16
                r1.writeString(r23);     // Catch: Throwable -> L16
                r1.writeString(r24);     // Catch: Throwable -> L16
                r1.writeString(r25);     // Catch: Throwable -> L16
                r1.writeString(r26);     // Catch: Throwable -> L16
                r1.writeString(r27);     // Catch: Throwable -> L16
                r1.writeString(r28);     // Catch: Throwable -> L16
                r1.writeString(r29);     // Catch: Throwable -> L16
                r1.writeStringList(r14);     // Catch: Throwable -> L16
                r1.writeString(r31);     // Catch: Throwable -> L16
                r1.writeString(r32);     // Catch: Throwable -> L16
                if (r17 == null) goto L6;
                IBinder r2 = r17.asBinder();     // Catch: Throwable -> L16
            L7:
                r1.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(16, r1, null, 1) == false) goto L10;
            L14:
                r1.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadOmniDataFeedbackByHttp(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r14, r31, r32, r17);     // Catch: Throwable -> L16
                r1.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r1.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniScreenshotByHttpV2(String r17, String r18, int r19, String r20, String r21, String r22, String r23, List<String> r24, String r25, String r26, boolean r27, IFlowNetworkResultCallbackIDL r28) {
                List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r14 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r1.writeString(r17);     // Catch: Throwable -> L20
                r1.writeString(r18);     // Catch: Throwable -> L20
                r1.writeInt(r19);     // Catch: Throwable -> L20
                r1.writeString(r20);     // Catch: Throwable -> L20
                r1.writeString(r21);     // Catch: Throwable -> L20
                r1.writeString(r22);     // Catch: Throwable -> L20
                r1.writeString(r23);     // Catch: Throwable -> L20
                r1.writeStringList(r10);     // Catch: Throwable -> L20
                r1.writeString(r25);     // Catch: Throwable -> L20
                r1.writeString(r26);     // Catch: Throwable -> L20
                if (r27 == false) goto L6;
                int r3 = 1;
            L7:
                r1.writeInt(r3);     // Catch: Throwable -> L20
                if (r14 == null) goto L10;
                IBinder r13 = r14.asBinder();     // Catch: Throwable -> L20
            L11:
                r1.writeStrongBinder(r13);     // Catch: Throwable -> L20
                if (this.mRemote.transact(17, r1, null, 1) == false) goto L14;
            L18:
                r1.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().uploadOmniScreenshotByHttpV2(r17, r18, r19, r20, r21, r22, r23, r10, r25, r26, r27, r14);     // Catch: Throwable -> L20
                r1.recycle();
                return;
            L10:
                r13 = null;
                goto L11
            L6:
                r3 = 0;
            L20:
                th = move-exception;
                r1.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniDataFeedbackByHttpV2(String r20, String r21, int r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, List<String> r31, String r32, String r33, boolean r34, IFlowNetworkResultCallbackIDL r35) {
                List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
                IFlowNetworkResultCallbackIDL r18 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r35, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r1.writeString(r20);     // Catch: Throwable -> L20
                r1.writeString(r21);     // Catch: Throwable -> L20
                r1.writeInt(r22);     // Catch: Throwable -> L20
                r1.writeString(r23);     // Catch: Throwable -> L20
                r1.writeString(r24);     // Catch: Throwable -> L20
                r1.writeString(r25);     // Catch: Throwable -> L20
                r1.writeString(r26);     // Catch: Throwable -> L20
                r1.writeString(r27);     // Catch: Throwable -> L20
                r1.writeString(r28);     // Catch: Throwable -> L20
                r1.writeString(r29);     // Catch: Throwable -> L20
                r1.writeString(r30);     // Catch: Throwable -> L20
                r1.writeStringList(r14);     // Catch: Throwable -> L20
                r1.writeString(r32);     // Catch: Throwable -> L20
                r1.writeString(r33);     // Catch: Throwable -> L20
                if (r34 == false) goto L6;
                int r2 = 1;
            L7:
                r1.writeInt(r2);     // Catch: Throwable -> L20
                if (r18 == null) goto L10;
                IBinder r3 = r18.asBinder();     // Catch: Throwable -> L20
            L11:
                r1.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(18, r1, null, 1) == false) goto L14;
            L18:
                r1.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().uploadOmniDataFeedbackByHttpV2(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r14, r32, r33, r34, r18);     // Catch: Throwable -> L20
                r1.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r2 = 0;
            L20:
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

        public static IFlowNetworkIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowNetworkIDL.class) == false) goto L13;
            return (IFlowNetworkIDL) ZeusTransformUtils.preCheckCast(r0, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r21, Parcel r22, Parcel r23, int r24) {
            if (r21 == 1598968902) goto L62;
            boolean r3 = false;
            switch(r21) {
                case 1: goto L57;
                case 2: goto L52;
                case 3: goto L50;
                case 4: goto L48;
                case 5: goto L46;
                case 6: goto L44;
                case 7: goto L42;
                case 8: goto L40;
                case 9: goto L38;
                case 10: goto L36;
                case 11: goto L34;
                case 12: goto L32;
                case 13: goto L30;
                case 14: goto L24;
                case 15: goto L22;
                case 16: goto L20;
                case 17: goto L14;
                case 18: goto L8;
                default: goto L7;
            };
        L8:
            r22.enforceInterface(DESCRIPTOR);
            String r1 = r22.readString();
            String r2 = r22.readString();
            int r4 = r22.readInt();
            String r5 = r22.readString();
            String r6 = r22.readString();
            String r7 = r22.readString();
            String r8 = r22.readString();
            String r9 = r22.readString();
            String r10 = r22.readString();
            String r11 = r22.readString();
            String r12 = r22.readString();
            ArrayList<String> r13 = r22.createStringArrayList();
            String r14 = r22.readString();
            String r18 = r22.readString();
            if (r22.readInt() == 0) goto L11;
            boolean r19 = true;
        L12:
            uploadOmniDataFeedbackByHttpV2(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r18, r19, IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L11:
            r19 = false;
            goto L12
        L14:
            r22.enforceInterface(DESCRIPTOR);
            String r15 = r22.readString();
            String r16 = r22.readString();
            int r17 = r22.readInt();
            String r20 = r22.readString();
            String r25 = r22.readString();
            String r26 = r22.readString();
            String r27 = r22.readString();
            ArrayList<String> r28 = r22.createStringArrayList();
            String r110 = r22.readString();
            String r111 = r22.readString();
            if (r22.readInt() == 0) goto L17;
            boolean r112 = true;
        L18:
            uploadOmniScreenshotByHttpV2(r15, r16, r17, r20, r25, r26, r27, r28, r110, r111, r112, IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L17:
            r112 = false;
            goto L18
        L20:
            r22.enforceInterface(DESCRIPTOR);
            uploadOmniDataFeedbackByHttp(r22.readString(), r22.readString(), r22.readInt(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.createStringArrayList(), r22.readString(), r22.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L22:
            r22.enforceInterface(DESCRIPTOR);
            deleteConditionalTask(r22.readString(), r22.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L24:
            r22.enforceInterface(DESCRIPTOR);
            if (r22.readInt() == 0) goto L27;
            ObricConditionalTaskSweepRequest r29 = (ObricConditionalTaskSweepRequest) ZeusTransformUtils.preCheckCast(ObricConditionalTaskSweepRequest.CREATOR.createFromParcel(r22), ObricConditionalTaskSweepRequest.class, "com.obric.aiagent.plugin");
        L28:
            sweepConditionalTask(r29, IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L27:
            r29 = null;
            goto L28
        L30:
            r22.enforceInterface(DESCRIPTOR);
            createConditionalTask(r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L32:
            r22.enforceInterface(DESCRIPTOR);
            notifyStopComplexTaskByHttpWithScene(r22.readLong(), r22.readString());
            return true;
        L34:
            r22.enforceInterface(DESCRIPTOR);
            clearOmniTasks(r22.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L36:
            r22.enforceInterface(DESCRIPTOR);
            notifyStopOmniTaskByHttp(r22.readString(), r22.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L38:
            r22.enforceInterface(DESCRIPTOR);
            notifyUserOperateQueue(r22.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L40:
            r22.enforceInterface(DESCRIPTOR);
            uploadOmniScreenshotByHttp(r22.readString(), r22.readString(), r22.readInt(), r22.readString(), r22.readString(), r22.readString(), r22.readString(), r22.createStringArrayList(), r22.readString(), r22.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L42:
            r22.enforceInterface(DESCRIPTOR);
            uploadUserTakeOverByHttp(r22.readString(), r22.readString(), r22.readString(), r22.readLong(), r22.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L44:
            r22.enforceInterface(DESCRIPTOR);
            int r0 = getCurrentNetworkStatus();
            r23.writeNoException();
            r23.writeInt(r0);
            return true;
        L46:
            r22.enforceInterface(DESCRIPTOR);
            notifyStopComplexTaskByHttp(r22.readLong());
            return true;
        L48:
            r22.enforceInterface(DESCRIPTOR);
            sendReplyAskUserByHttp(r22.readString(), r22.readString(), r22.readString(), r22.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L50:
            r22.enforceInterface(DESCRIPTOR);
            sendNormalRouterByHttp(r22.readString(), r22.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L52:
            r22.enforceInterface(DESCRIPTOR);
            ArrayList r30 = r22.createTypedArrayList(OPushEvent.CREATOR);
            if (r22.readInt() == 0) goto L55;
            r3 = true;
        L55:
            sendIntentResultForAsyncNotifyByHttp(r30, r3, IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L57:
            r22.enforceInterface(DESCRIPTOR);
            ArrayList r31 = r22.createTypedArrayList(OPushEvent.CREATOR);
            if (r22.readInt() == 0) goto L60;
            r3 = true;
        L60:
            sendIntentResultForCompensationByHttp(r31, r3, IFlowNetworkResultCallbackIDL.Stub.asInterface(r22.readStrongBinder()));
            return true;
        L7:
            return super.onTransact(r21, r22, r23, r24);
        L62:
            r23.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowNetworkIDL r2) {
            IFlowNetworkIDL r3 = (IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowNetworkIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void clearOmniTasks(Map r1, IFlowNetworkResultCallbackIDL r2);

    void createConditionalTask(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, Map r15, IFlowNetworkResultCallbackIDL r16);

    void deleteConditionalTask(String r1, Map r2, IFlowNetworkResultCallbackIDL r3);

    int getCurrentNetworkStatus();

    void notifyStopComplexTaskByHttp(long r1);

    void notifyStopComplexTaskByHttpWithScene(long r1, String r3);

    void notifyStopOmniTaskByHttp(String r1, Map r2, IFlowNetworkResultCallbackIDL r3);

    void notifyUserOperateQueue(String r1, IFlowNetworkResultCallbackIDL r2);

    void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r1, boolean r2, IFlowNetworkResultCallbackIDL r3);

    void sendIntentResultForCompensationByHttp(List<OPushEvent> r1, boolean r2, IFlowNetworkResultCallbackIDL r3);

    void sendNormalRouterByHttp(String r1, String r2, IFlowNetworkResultCallbackIDL r3);

    void sendReplyAskUserByHttp(String r1, String r2, String r3, Map r4, IFlowNetworkResultCallbackIDL r5);

    void sweepConditionalTask(ObricConditionalTaskSweepRequest r1, IFlowNetworkResultCallbackIDL r2);

    void uploadOmniDataFeedbackByHttp(String r1, String r2, int r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12, String r13, String r14, IFlowNetworkResultCallbackIDL r15);

    void uploadOmniDataFeedbackByHttpV2(String r1, String r2, int r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12, String r13, String r14, boolean r15, IFlowNetworkResultCallbackIDL r16);

    void uploadOmniScreenshotByHttp(String r1, String r2, int r3, String r4, String r5, String r6, String r7, List<String> r8, String r9, String r10, IFlowNetworkResultCallbackIDL r11);

    void uploadOmniScreenshotByHttpV2(String r1, String r2, int r3, String r4, String r5, String r6, String r7, List<String> r8, String r9, String r10, boolean r11, IFlowNetworkResultCallbackIDL r12);

    void uploadUserTakeOverByHttp(String r1, String r2, String r3, long r4, Map r6, IFlowNetworkResultCallbackIDL r7);
}
