package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowMessageIDL extends IInterface {
    public static final int MESSAGE_EVENT_ALL = 31;
    public static final int MESSAGE_EVENT_INSERT = 16;
    public static final int MESSAGE_EVENT_LEGACY_ALL = 15;
    public static final int MESSAGE_EVENT_RECEIVE = 2;
    public static final int MESSAGE_EVENT_REGEN = 8;
    public static final int MESSAGE_EVENT_SEND = 1;
    public static final int MESSAGE_EVENT_UPDATE = 4;

    public static class Default implements IFlowMessageIDL {
        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void addMessage(IMMessage r1, String r2, String r3) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void appendMessageExt(String r1, Map r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void deleteMessage(String r1, IFlowDeleteMessageCallbackIDL r2) {
            IFlowDeleteMessageCallbackIDL r0 = (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void deleteRemoteResource(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void fetchLatestMessages(int r1, IFlowFindMessagesCallbackIDL r2) {
            IFlowFindMessagesCallbackIDL r0 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void findAnswersbyQueryId(String r1, IFlowFindMessagesCallbackIDL r2) {
            IFlowFindMessagesCallbackIDL r0 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void findMessagebyId(String r1, IFlowFindMessageCallbackIDL r2) {
            IFlowFindMessageCallbackIDL r0 = (IFlowFindMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public String generateLocalMessageId() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void getMainTxtContentForMessage(String r1, IFlowMessageMainTextBlockCallbackIDL r2) {
            IFlowMessageMainTextBlockCallbackIDL r0 = (IFlowMessageMainTextBlockCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowMessageMainTextBlockCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public String getMainTxtContentFromMessage(IMMessage r1) {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void imageXUpload(String r1, IImageXUploadCallbackIDL r2) {
            IImageXUploadCallbackIDL r0 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public boolean isConversationTtsEnabled(String r1) {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void isMessageLocalInterrupted(String r1, IFlowIsMessageInterruptedCallbackIDL r2) {
            IFlowIsMessageInterruptedCallbackIDL r0 = (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void notifySemanticUserEditEvent(String r1, String r2, Map r3, IFlowSemanticEditCallbackIDL r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            IFlowSemanticEditCallbackIDL r5 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void notifySemanticUserEditEventWithIdentifier(String r1, String r2, String r3, Map r4, IFlowSemanticEditCallbackIDL r5) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            IFlowSemanticEditCallbackIDL r6 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void notifySemanticUserEditEventWithUri(String r1, String r2, String r3, Map r4, IFlowSemanticEditCallbackIDL r5) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            IFlowSemanticEditCallbackIDL r6 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void refreshLatestMessages(String r1, int r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerCallback(IFlowMessageCallbackIDL r2) {
            IFlowMessageCallbackIDL r1 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerCallbackWithEvents(IFlowMessageCallbackIDL r1, int r2) {
            IFlowMessageCallbackIDL r0 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r2) {
            IFlowSendMessageExtCallbackIDL r1 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerStreamObserver(IFlowStreamObserverIDL r2) {
            IFlowStreamObserverIDL r1 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void retryFetchMessage(IMMessage r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void sendMessage(String r1, String r2, String r3, String r4) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void sendMessageWithExtra(String r1, String r2, String r3, String r4, Map r5) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void unregisterCallback(IFlowMessageCallbackIDL r2) {
            IFlowMessageCallbackIDL r1 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r2) {
            IFlowSendMessageExtCallbackIDL r1 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void unregisterStreamObserver(IFlowStreamObserverIDL r2) {
            IFlowStreamObserverIDL r1 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void updateMessageExt(String r1, Map r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void updateMutableMessageContent(String r1, String r2) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void updateMutableWidgetRenderData(String r1, String r2, String r3) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void uploadImage(String r1, String r2, IImageXUploadCallbackIDL r3) {
            IImageXUploadCallbackIDL r0 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowMessageIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowMessageIDL";
        static final int TRANSACTION_addMessage = 5;
        static final int TRANSACTION_appendMessageExt = 3;
        static final int TRANSACTION_deleteMessage = 6;
        static final int TRANSACTION_deleteRemoteResource = 16;
        static final int TRANSACTION_fetchLatestMessages = 25;
        static final int TRANSACTION_findAnswersbyQueryId = 28;
        static final int TRANSACTION_findMessagebyId = 7;
        static final int TRANSACTION_generateLocalMessageId = 4;
        static final int TRANSACTION_getMainTxtContentForMessage = 26;
        static final int TRANSACTION_getMainTxtContentFromMessage = 27;
        static final int TRANSACTION_imageXUpload = 10;
        static final int TRANSACTION_isConversationTtsEnabled = 20;
        static final int TRANSACTION_isMessageLocalInterrupted = 15;
        static final int TRANSACTION_notifySemanticUserEditEvent = 11;
        static final int TRANSACTION_notifySemanticUserEditEventWithIdentifier = 12;
        static final int TRANSACTION_notifySemanticUserEditEventWithUri = 13;
        static final int TRANSACTION_refreshLatestMessages = 24;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerCallbackWithEvents = 30;
        static final int TRANSACTION_registerSendMessageExtCallback = 8;
        static final int TRANSACTION_registerStreamObserver = 18;
        static final int TRANSACTION_retryFetchMessage = 23;
        static final int TRANSACTION_sendMessage = 14;
        static final int TRANSACTION_sendMessageWithExtra = 21;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_unregisterSendMessageExtCallback = 9;
        static final int TRANSACTION_unregisterStreamObserver = 19;
        static final int TRANSACTION_updateMessageExt = 22;
        static final int TRANSACTION_updateMutableMessageContent = 29;
        static final int TRANSACTION_updateMutableWidgetRenderData = 31;
        static final int TRANSACTION_uploadImage = 17;

        private static class Proxy implements IFlowMessageIDL {
            public static IFlowMessageIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerCallback(IFlowMessageCallbackIDL r4) {
                IFlowMessageCallbackIDL r5 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void unregisterCallback(IFlowMessageCallbackIDL r5) {
                IFlowMessageCallbackIDL r6 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void appendMessageExt(String r5, Map r6) {
                Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeMap(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().appendMessageExt(r5, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public String generateLocalMessageId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().generateLocalMessageId();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void addMessage(IMMessage r5, String r6, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L16
                r0.writeString(r7);     // Catch: Throwable -> L16
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addMessage(r5, r6, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void deleteMessage(String r5, IFlowDeleteMessageCallbackIDL r6) {
                IFlowDeleteMessageCallbackIDL r7 = (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().deleteMessage(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void findMessagebyId(String r5, IFlowFindMessageCallbackIDL r6) {
                IFlowFindMessageCallbackIDL r7 = (IFlowFindMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().findMessagebyId(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r5) {
                IFlowSendMessageExtCallbackIDL r6 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSendMessageExtCallback(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r5) {
                IFlowSendMessageExtCallbackIDL r6 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSendMessageExtCallback(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void imageXUpload(String r5, IImageXUploadCallbackIDL r6) {
                IImageXUploadCallbackIDL r7 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().imageXUpload(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void notifySemanticUserEditEvent(String r5, String r6, Map r7, IFlowSemanticEditCallbackIDL r8) {
                Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
                IFlowSemanticEditCallbackIDL r10 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                r0.writeMap(r9);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                IBinder r2 = r10.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifySemanticUserEditEvent(r5, r6, r9, r10);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void notifySemanticUserEditEventWithIdentifier(String r9, String r10, String r11, Map r12, IFlowSemanticEditCallbackIDL r13) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
                IFlowSemanticEditCallbackIDL r7 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r13, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
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
                if (this.mRemote.transact(12, r14, null, 1) == false) goto L10;
            L14:
                r14.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifySemanticUserEditEventWithIdentifier(r9, r10, r11, r6, r7);     // Catch: Throwable -> L16
                r14.recycle();
                return;
            L6:
                r0 = null;
            L16:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void notifySemanticUserEditEventWithUri(String r9, String r10, String r11, Map r12, IFlowSemanticEditCallbackIDL r13) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
                IFlowSemanticEditCallbackIDL r7 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r13, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
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
                if (this.mRemote.transact(13, r14, null, 1) == false) goto L10;
            L14:
                r14.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifySemanticUserEditEventWithUri(r9, r10, r11, r6, r7);     // Catch: Throwable -> L16
                r14.recycle();
                return;
            L6:
                r0 = null;
            L16:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void sendMessage(String r5, String r6, String r7, String r8) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                r0.writeString(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendMessage(r5, r6, r7, r8);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void isMessageLocalInterrupted(String r5, IFlowIsMessageInterruptedCallbackIDL r6) {
                IFlowIsMessageInterruptedCallbackIDL r7 = (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(15, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().isMessageLocalInterrupted(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void deleteRemoteResource(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeStringList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(16, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().deleteRemoteResource(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void uploadImage(String r5, String r6, IImageXUploadCallbackIDL r7) {
                IImageXUploadCallbackIDL r8 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r7, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(17, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadImage(r5, r6, r8);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerStreamObserver(IFlowStreamObserverIDL r5) {
                IFlowStreamObserverIDL r6 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(18, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerStreamObserver(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void unregisterStreamObserver(IFlowStreamObserverIDL r5) {
                IFlowStreamObserverIDL r6 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(19, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterStreamObserver(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public boolean isConversationTtsEnabled(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().isConversationTtsEnabled(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void sendMessageWithExtra(String r7, String r8, String r9, String r10, Map r11) {
                Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeString(r7);     // Catch: Throwable -> L12
                r12.writeString(r8);     // Catch: Throwable -> L12
                r12.writeString(r9);     // Catch: Throwable -> L12
                r12.writeString(r10);     // Catch: Throwable -> L12
                r12.writeMap(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(21, r12, null, 1) == false) goto L6;
            L10:
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendMessageWithExtra(r7, r8, r9, r10, r5);     // Catch: Throwable -> L12
                r12.recycle();
                return;
            L12:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void updateMessageExt(String r5, Map r6) {
                Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeMap(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(22, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateMessageExt(r5, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void retryFetchMessage(IMMessage r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(23, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().retryFetchMessage(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void refreshLatestMessages(String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(24, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().refreshLatestMessages(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void fetchLatestMessages(int r5, IFlowFindMessagesCallbackIDL r6) {
                IFlowFindMessagesCallbackIDL r7 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(25, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().fetchLatestMessages(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void getMainTxtContentForMessage(String r5, IFlowMessageMainTextBlockCallbackIDL r6) {
                IFlowMessageMainTextBlockCallbackIDL r7 = (IFlowMessageMainTextBlockCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowMessageMainTextBlockCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(26, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getMainTxtContentForMessage(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public String getMainTxtContentFromMessage(IMMessage r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(27, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                String r4 = r1.readString();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                String r6 = Stub.getDefaultImpl().getMainTxtContentFromMessage(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void findAnswersbyQueryId(String r5, IFlowFindMessagesCallbackIDL r6) {
                IFlowFindMessagesCallbackIDL r7 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(28, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().findAnswersbyQueryId(r5, r7);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void updateMutableMessageContent(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(29, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateMutableMessageContent(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerCallbackWithEvents(IFlowMessageCallbackIDL r5, int r6) {
                IFlowMessageCallbackIDL r7 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                r0.writeInt(r6);     // Catch: Throwable -> L16
                if (this.mRemote.transact(30, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallbackWithEvents(r7, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void updateMutableWidgetRenderData(String r5, String r6, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(31, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateMutableWidgetRenderData(r5, r6, r7);     // Catch: Throwable -> L12
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

        public static IFlowMessageIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowMessageIDL.class) == false) goto L13;
            return (IFlowMessageIDL) ZeusTransformUtils.preCheckCast(r0, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) {
            if (r9 == 1598968902) goto L79;
            IMMessage r7 = null;
            switch(r9) {
                case 1: goto L77;
                case 2: goto L75;
                case 3: goto L73;
                case 4: goto L71;
                case 5: goto L66;
                case 6: goto L64;
                case 7: goto L62;
                case 8: goto L60;
                case 9: goto L58;
                case 10: goto L56;
                case 11: goto L54;
                case 12: goto L52;
                case 13: goto L50;
                case 14: goto L48;
                case 15: goto L46;
                case 16: goto L44;
                case 17: goto L42;
                case 18: goto L40;
                case 19: goto L38;
                case 20: goto L36;
                case 21: goto L34;
                case 22: goto L32;
                case 23: goto L27;
                case 24: goto L25;
                case 25: goto L23;
                case 26: goto L21;
                case 27: goto L16;
                case 28: goto L14;
                case 29: goto L12;
                case 30: goto L10;
                case 31: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            updateMutableWidgetRenderData(r10.readString(), r10.readString(), r10.readString());
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            registerCallbackWithEvents(IFlowMessageCallbackIDL.Stub.asInterface(r10.readStrongBinder()), r10.readInt());
            return true;
        L12:
            r10.enforceInterface(DESCRIPTOR);
            updateMutableMessageContent(r10.readString(), r10.readString());
            return true;
        L14:
            r10.enforceInterface(DESCRIPTOR);
            findAnswersbyQueryId(r10.readString(), IFlowFindMessagesCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L16:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L19;
            r7 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r10), IMMessage.class, "com.obric.aiagent.plugin");
        L19:
            String r0 = getMainTxtContentFromMessage(r7);
            r11.writeNoException();
            r11.writeString(r0);
            return true;
        L21:
            r10.enforceInterface(DESCRIPTOR);
            getMainTxtContentForMessage(r10.readString(), IFlowMessageMainTextBlockCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L23:
            r10.enforceInterface(DESCRIPTOR);
            fetchLatestMessages(r10.readInt(), IFlowFindMessagesCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L25:
            r10.enforceInterface(DESCRIPTOR);
            refreshLatestMessages(r10.readString(), r10.readInt());
            return true;
        L27:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L30;
            r7 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r10), IMMessage.class, "com.obric.aiagent.plugin");
        L30:
            retryFetchMessage(r7);
            return true;
        L32:
            r10.enforceInterface(DESCRIPTOR);
            updateMessageExt(r10.readString(), r10.readHashMap(getClass().getClassLoader()));
            return true;
        L34:
            r10.enforceInterface(DESCRIPTOR);
            sendMessageWithExtra(r10.readString(), r10.readString(), r10.readString(), r10.readString(), r10.readHashMap(getClass().getClassLoader()));
            return true;
        L36:
            r10.enforceInterface(DESCRIPTOR);
            boolean r1 = isConversationTtsEnabled(r10.readString());
            r11.writeNoException();
            r11.writeInt(r1 ? 1 : 0);
            return true;
        L38:
            r10.enforceInterface(DESCRIPTOR);
            unregisterStreamObserver(IFlowStreamObserverIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L40:
            r10.enforceInterface(DESCRIPTOR);
            registerStreamObserver(IFlowStreamObserverIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L42:
            r10.enforceInterface(DESCRIPTOR);
            uploadImage(r10.readString(), r10.readString(), IImageXUploadCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L44:
            r10.enforceInterface(DESCRIPTOR);
            deleteRemoteResource(r10.createStringArrayList());
            return true;
        L46:
            r10.enforceInterface(DESCRIPTOR);
            isMessageLocalInterrupted(r10.readString(), IFlowIsMessageInterruptedCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L48:
            r10.enforceInterface(DESCRIPTOR);
            sendMessage(r10.readString(), r10.readString(), r10.readString(), r10.readString());
            return true;
        L50:
            r10.enforceInterface(DESCRIPTOR);
            notifySemanticUserEditEventWithUri(r10.readString(), r10.readString(), r10.readString(), r10.readHashMap(getClass().getClassLoader()), IFlowSemanticEditCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L52:
            r10.enforceInterface(DESCRIPTOR);
            notifySemanticUserEditEventWithIdentifier(r10.readString(), r10.readString(), r10.readString(), r10.readHashMap(getClass().getClassLoader()), IFlowSemanticEditCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L54:
            r10.enforceInterface(DESCRIPTOR);
            notifySemanticUserEditEvent(r10.readString(), r10.readString(), r10.readHashMap(getClass().getClassLoader()), IFlowSemanticEditCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L56:
            r10.enforceInterface(DESCRIPTOR);
            imageXUpload(r10.readString(), IImageXUploadCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L58:
            r10.enforceInterface(DESCRIPTOR);
            unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L60:
            r10.enforceInterface(DESCRIPTOR);
            registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L62:
            r10.enforceInterface(DESCRIPTOR);
            findMessagebyId(r10.readString(), IFlowFindMessageCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L64:
            r10.enforceInterface(DESCRIPTOR);
            deleteMessage(r10.readString(), IFlowDeleteMessageCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L66:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L69;
            r7 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r10), IMMessage.class, "com.obric.aiagent.plugin");
        L69:
            addMessage(r7, r10.readString(), r10.readString());
            return true;
        L71:
            r10.enforceInterface(DESCRIPTOR);
            String r2 = generateLocalMessageId();
            r11.writeNoException();
            r11.writeString(r2);
            return true;
        L73:
            r10.enforceInterface(DESCRIPTOR);
            appendMessageExt(r10.readString(), r10.readHashMap(getClass().getClassLoader()));
            return true;
        L75:
            r10.enforceInterface(DESCRIPTOR);
            unregisterCallback(IFlowMessageCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L77:
            r10.enforceInterface(DESCRIPTOR);
            registerCallback(IFlowMessageCallbackIDL.Stub.asInterface(r10.readStrongBinder()));
            return true;
        L7:
            return super.onTransact(r9, r10, r11, r12);
        L79:
            r11.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IFlowMessageIDL r2) {
            IFlowMessageIDL r3 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowMessageIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void addMessage(IMMessage r1, String r2, String r3);

    void appendMessageExt(String r1, Map r2);

    void deleteMessage(String r1, IFlowDeleteMessageCallbackIDL r2);

    void deleteRemoteResource(List<String> r1);

    void fetchLatestMessages(int r1, IFlowFindMessagesCallbackIDL r2);

    void findAnswersbyQueryId(String r1, IFlowFindMessagesCallbackIDL r2);

    void findMessagebyId(String r1, IFlowFindMessageCallbackIDL r2);

    String generateLocalMessageId();

    void getMainTxtContentForMessage(String r1, IFlowMessageMainTextBlockCallbackIDL r2);

    String getMainTxtContentFromMessage(IMMessage r1);

    void imageXUpload(String r1, IImageXUploadCallbackIDL r2);

    boolean isConversationTtsEnabled(String r1);

    void isMessageLocalInterrupted(String r1, IFlowIsMessageInterruptedCallbackIDL r2);

    void notifySemanticUserEditEvent(String r1, String r2, Map r3, IFlowSemanticEditCallbackIDL r4);

    void notifySemanticUserEditEventWithIdentifier(String r1, String r2, String r3, Map r4, IFlowSemanticEditCallbackIDL r5);

    void notifySemanticUserEditEventWithUri(String r1, String r2, String r3, Map r4, IFlowSemanticEditCallbackIDL r5);

    void refreshLatestMessages(String r1, int r2);

    void registerCallback(IFlowMessageCallbackIDL r1);

    void registerCallbackWithEvents(IFlowMessageCallbackIDL r1, int r2);

    void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r1);

    void registerStreamObserver(IFlowStreamObserverIDL r1);

    void retryFetchMessage(IMMessage r1);

    void sendMessage(String r1, String r2, String r3, String r4);

    void sendMessageWithExtra(String r1, String r2, String r3, String r4, Map r5);

    void unregisterCallback(IFlowMessageCallbackIDL r1);

    void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r1);

    void unregisterStreamObserver(IFlowStreamObserverIDL r1);

    void updateMessageExt(String r1, Map r2);

    void updateMutableMessageContent(String r1, String r2);

    void updateMutableWidgetRenderData(String r1, String r2, String r3);

    void uploadImage(String r1, String r2, IImageXUploadCallbackIDL r3);
}
