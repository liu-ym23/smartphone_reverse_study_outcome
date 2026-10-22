package com.zyql.agentfront;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.zyql.agentfront.IMessageListener;
import com.zyql.agentfront.bean.AbilityMetaQueryReq;
import com.zyql.agentfront.bean.AbilityMetadata;
import com.zyql.agentfront.bean.BatchToolResultRequest;
import com.zyql.agentfront.bean.BatchToolResultResponse;
import com.zyql.agentfront.bean.CancelMessageRequest;
import com.zyql.agentfront.bean.CancelMessageResponse;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.PauseTaskRequest;
import com.zyql.agentfront.bean.PauseTaskResponse;
import com.zyql.agentfront.bean.ResumeTaskRequest;
import com.zyql.agentfront.bean.ResumeTaskResponse;
import com.zyql.agentfront.bean.SessionOperationRequest;
import com.zyql.agentfront.bean.SessionOperationResponse;
import com.zyql.agentfront.bean.SyncConversationsResponse;
import com.zyql.agentfront.bean.SyncHistoryRequest;
import com.zyql.agentfront.bean.SyncHistoryResponse;
import com.zyql.agentfront.bean.ToolCall;
import com.zyql.agentfront.bean.ToolResultRequest;
import com.zyql.agentfront.bean.ToolResultResponse;
import java.util.List;

/* loaded from: classes4.dex */
public interface IMessageBridge extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.agentfront.IMessageBridge";

    public static class Default implements IMessageBridge {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public CancelMessageResponse cancelMessage(CancelMessageRequest cancelMessageRequest) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public boolean cancelToolExecution(String str) throws RemoteException {
            return false;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public int getConnectionState() throws RemoteException {
            return 0;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public String getRegisteredClients(String str) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public boolean isReady() throws RemoteException {
            return false;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public SessionOperationResponse manageSession(SessionOperationRequest sessionOperationRequest) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public PauseTaskResponse pauseTask(PauseTaskRequest pauseTaskRequest) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public List<AbilityMetadata> queryAbilityMetasByReq(AbilityMetaQueryReq abilityMetaQueryReq) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public boolean registerListener(IMessageListener iMessageListener, String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public String requestToolExecution(ToolCall toolCall) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public List<String> requestToolExecutions(List<ToolCall> list) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public ResumeTaskResponse resumeTask(ResumeTaskRequest resumeTaskRequest) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public String sendAgentMessage(Message message) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public String sendMessage(Message message) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public ToolResultResponse submitToolResult(ToolResultRequest toolResultRequest) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public BatchToolResultResponse submitToolResults(BatchToolResultRequest batchToolResultRequest) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public SyncConversationsResponse syncConversations() throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public SyncHistoryResponse syncHistory(SyncHistoryRequest syncHistoryRequest) throws RemoteException {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageBridge
        public void unregisterListener(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMessageBridge {
        static final int TRANSACTION_cancelMessage = 6;
        static final int TRANSACTION_cancelToolExecution = 10;
        static final int TRANSACTION_getConnectionState = 13;
        static final int TRANSACTION_getRegisteredClients = 11;
        static final int TRANSACTION_isReady = 12;
        static final int TRANSACTION_manageSession = 18;
        static final int TRANSACTION_pauseTask = 15;
        static final int TRANSACTION_queryAbilityMetasByReq = 14;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_requestToolExecution = 8;
        static final int TRANSACTION_requestToolExecutions = 9;
        static final int TRANSACTION_resumeTask = 16;
        static final int TRANSACTION_sendAgentMessage = 7;
        static final int TRANSACTION_sendMessage = 3;
        static final int TRANSACTION_submitToolResult = 4;
        static final int TRANSACTION_submitToolResults = 5;
        static final int TRANSACTION_syncConversations = 19;
        static final int TRANSACTION_syncHistory = 17;
        static final int TRANSACTION_unregisterListener = 2;

        public static class Proxy implements IMessageBridge {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public CancelMessageResponse cancelMessage(CancelMessageRequest cancelMessageRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, cancelMessageRequest, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (CancelMessageResponse) a.d(parcelObtain2, CancelMessageResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public boolean cancelToolExecution(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public int getConnectionState() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IMessageBridge.DESCRIPTOR;
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public String getRegisteredClients(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public boolean isReady() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public SessionOperationResponse manageSession(SessionOperationRequest sessionOperationRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, sessionOperationRequest, 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (SessionOperationResponse) a.d(parcelObtain2, SessionOperationResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public PauseTaskResponse pauseTask(PauseTaskRequest pauseTaskRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, pauseTaskRequest, 0);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PauseTaskResponse) a.d(parcelObtain2, PauseTaskResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public List<AbilityMetadata> queryAbilityMetasByReq(AbilityMetaQueryReq abilityMetaQueryReq) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, abilityMetaQueryReq, 0);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(AbilityMetadata.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public boolean registerListener(IMessageListener iMessageListener, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMessageListener);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public String requestToolExecution(ToolCall toolCall) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, toolCall, 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public List<String> requestToolExecutions(List<ToolCall> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.e(parcelObtain, list, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public ResumeTaskResponse resumeTask(ResumeTaskRequest resumeTaskRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, resumeTaskRequest, 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ResumeTaskResponse) a.d(parcelObtain2, ResumeTaskResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public String sendAgentMessage(Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, message, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public String sendMessage(Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, message, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public ToolResultResponse submitToolResult(ToolResultRequest toolResultRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, toolResultRequest, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ToolResultResponse) a.d(parcelObtain2, ToolResultResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public BatchToolResultResponse submitToolResults(BatchToolResultRequest batchToolResultRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, batchToolResultRequest, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (BatchToolResultResponse) a.d(parcelObtain2, BatchToolResultResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public SyncConversationsResponse syncConversations() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (SyncConversationsResponse) a.d(parcelObtain2, SyncConversationsResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public SyncHistoryResponse syncHistory(SyncHistoryRequest syncHistoryRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    a.f(parcelObtain, syncHistoryRequest, 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (SyncHistoryResponse) a.d(parcelObtain2, SyncHistoryResponse.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public void unregisterListener(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMessageBridge.DESCRIPTOR);
        }

        public static IMessageBridge asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMessageBridge.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMessageBridge)) ? new Proxy(iBinder) : (IMessageBridge) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IMessageBridge.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IMessageBridge.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    boolean zRegisterListener = registerListener(IMessageListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterListener ? 1 : 0);
                    return true;
                case 2:
                    unregisterListener(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    String strSendMessage = sendMessage((Message) a.d(parcel, Message.INSTANCE));
                    parcel2.writeNoException();
                    parcel2.writeString(strSendMessage);
                    return true;
                case 4:
                    ToolResultResponse toolResultResponseSubmitToolResult = submitToolResult((ToolResultRequest) a.d(parcel, ToolResultRequest.INSTANCE));
                    parcel2.writeNoException();
                    a.f(parcel2, toolResultResponseSubmitToolResult, 1);
                    return true;
                case 5:
                    BatchToolResultResponse batchToolResultResponseSubmitToolResults = submitToolResults((BatchToolResultRequest) a.d(parcel, BatchToolResultRequest.INSTANCE));
                    parcel2.writeNoException();
                    a.f(parcel2, batchToolResultResponseSubmitToolResults, 1);
                    return true;
                case 6:
                    CancelMessageResponse cancelMessageResponseCancelMessage = cancelMessage((CancelMessageRequest) a.d(parcel, CancelMessageRequest.INSTANCE));
                    parcel2.writeNoException();
                    a.f(parcel2, cancelMessageResponseCancelMessage, 1);
                    return true;
                case 7:
                    String strSendAgentMessage = sendAgentMessage((Message) a.d(parcel, Message.INSTANCE));
                    parcel2.writeNoException();
                    parcel2.writeString(strSendAgentMessage);
                    return true;
                case 8:
                    String strRequestToolExecution = requestToolExecution((ToolCall) a.d(parcel, ToolCall.INSTANCE));
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestToolExecution);
                    return true;
                case 9:
                    List<String> listRequestToolExecutions = requestToolExecutions(parcel.createTypedArrayList(ToolCall.INSTANCE));
                    parcel2.writeNoException();
                    parcel2.writeStringList(listRequestToolExecutions);
                    return true;
                case 10:
                    boolean zCancelToolExecution = cancelToolExecution(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancelToolExecution ? 1 : 0);
                    return true;
                case 11:
                    String registeredClients = getRegisteredClients(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(registeredClients);
                    return true;
                case 12:
                    boolean zIsReady = isReady();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsReady ? 1 : 0);
                    return true;
                case 13:
                    int connectionState = getConnectionState();
                    parcel2.writeNoException();
                    parcel2.writeInt(connectionState);
                    return true;
                case 14:
                    List<AbilityMetadata> listQueryAbilityMetasByReq = queryAbilityMetasByReq((AbilityMetaQueryReq) a.d(parcel, AbilityMetaQueryReq.INSTANCE));
                    parcel2.writeNoException();
                    a.e(parcel2, listQueryAbilityMetasByReq, 1);
                    return true;
                case 15:
                    PauseTaskResponse pauseTaskResponsePauseTask = pauseTask((PauseTaskRequest) a.d(parcel, PauseTaskRequest.INSTANCE));
                    parcel2.writeNoException();
                    a.f(parcel2, pauseTaskResponsePauseTask, 1);
                    return true;
                case 16:
                    ResumeTaskResponse resumeTaskResponseResumeTask = resumeTask((ResumeTaskRequest) a.d(parcel, ResumeTaskRequest.INSTANCE));
                    parcel2.writeNoException();
                    a.f(parcel2, resumeTaskResponseResumeTask, 1);
                    return true;
                case 17:
                    SyncHistoryResponse syncHistoryResponseSyncHistory = syncHistory((SyncHistoryRequest) a.d(parcel, SyncHistoryRequest.INSTANCE));
                    parcel2.writeNoException();
                    a.f(parcel2, syncHistoryResponseSyncHistory, 1);
                    return true;
                case 18:
                    SessionOperationResponse sessionOperationResponseManageSession = manageSession((SessionOperationRequest) a.d(parcel, SessionOperationRequest.INSTANCE));
                    parcel2.writeNoException();
                    a.f(parcel2, sessionOperationResponseManageSession, 1);
                    return true;
                case 19:
                    SyncConversationsResponse syncConversationsResponseSyncConversations = syncConversations();
                    parcel2.writeNoException();
                    a.f(parcel2, syncConversationsResponseSyncConversations, 1);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class a {
        public static <T> T d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void e(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                f(parcel, list.get(i11), i10);
            }
        }

        public static <T extends Parcelable> void f(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    CancelMessageResponse cancelMessage(CancelMessageRequest cancelMessageRequest) throws RemoteException;

    boolean cancelToolExecution(String str) throws RemoteException;

    int getConnectionState() throws RemoteException;

    String getRegisteredClients(String str) throws RemoteException;

    boolean isReady() throws RemoteException;

    SessionOperationResponse manageSession(SessionOperationRequest sessionOperationRequest) throws RemoteException;

    PauseTaskResponse pauseTask(PauseTaskRequest pauseTaskRequest) throws RemoteException;

    List<AbilityMetadata> queryAbilityMetasByReq(AbilityMetaQueryReq abilityMetaQueryReq) throws RemoteException;

    boolean registerListener(IMessageListener iMessageListener, String str, String str2) throws RemoteException;

    String requestToolExecution(ToolCall toolCall) throws RemoteException;

    List<String> requestToolExecutions(List<ToolCall> list) throws RemoteException;

    ResumeTaskResponse resumeTask(ResumeTaskRequest resumeTaskRequest) throws RemoteException;

    String sendAgentMessage(Message message) throws RemoteException;

    String sendMessage(Message message) throws RemoteException;

    ToolResultResponse submitToolResult(ToolResultRequest toolResultRequest) throws RemoteException;

    BatchToolResultResponse submitToolResults(BatchToolResultRequest batchToolResultRequest) throws RemoteException;

    SyncConversationsResponse syncConversations() throws RemoteException;

    SyncHistoryResponse syncHistory(SyncHistoryRequest syncHistoryRequest) throws RemoteException;

    void unregisterListener(String str) throws RemoteException;
}
