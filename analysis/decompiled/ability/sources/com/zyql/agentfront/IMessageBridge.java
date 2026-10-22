package com.zyql.agentfront;

import N9.j;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.zyql.agentfront.IMessageListener;
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

/* loaded from: classes3.dex */
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
        public List<AbilityMetadata> queryAbilityMetas(List<String> list, String str) throws RemoteException {
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
        static final int TRANSACTION_queryAbilityMetas = 14;
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
                    j.R(parcelObtain, cancelMessageRequest, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (CancelMessageResponse) j.a(parcelObtain2, CancelMessageResponse.CREATOR);
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
                    j.R(parcelObtain, sessionOperationRequest, 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (SessionOperationResponse) j.a(parcelObtain2, SessionOperationResponse.CREATOR);
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
                    j.R(parcelObtain, pauseTaskRequest, 0);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PauseTaskResponse) j.a(parcelObtain2, PauseTaskResponse.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageBridge
            public List<AbilityMetadata> queryAbilityMetas(List<String> list, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageBridge.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(AbilityMetadata.CREATOR);
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
                    j.R(parcelObtain, toolCall, 0);
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
                    j.b(parcelObtain, list, 0);
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
                    j.R(parcelObtain, resumeTaskRequest, 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ResumeTaskResponse) j.a(parcelObtain2, ResumeTaskResponse.CREATOR);
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
                    j.R(parcelObtain, message, 0);
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
                    j.R(parcelObtain, message, 0);
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
                    j.R(parcelObtain, toolResultRequest, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ToolResultResponse) j.a(parcelObtain2, ToolResultResponse.CREATOR);
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
                    j.R(parcelObtain, batchToolResultRequest, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (BatchToolResultResponse) j.a(parcelObtain2, BatchToolResultResponse.CREATOR);
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
                    return (SyncConversationsResponse) j.a(parcelObtain2, SyncConversationsResponse.CREATOR);
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
                    j.R(parcelObtain, syncHistoryRequest, 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (SyncHistoryResponse) j.a(parcelObtain2, SyncHistoryResponse.CREATOR);
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
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMessageBridge.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMessageBridge.DESCRIPTOR);
                return true;
            }
            switch (i) {
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
                    String strSendMessage = sendMessage((Message) j.a(parcel, Message.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeString(strSendMessage);
                    return true;
                case 4:
                    ToolResultResponse toolResultResponseSubmitToolResult = submitToolResult((ToolResultRequest) j.a(parcel, ToolResultRequest.CREATOR));
                    parcel2.writeNoException();
                    j.R(parcel2, toolResultResponseSubmitToolResult, 1);
                    return true;
                case 5:
                    BatchToolResultResponse batchToolResultResponseSubmitToolResults = submitToolResults((BatchToolResultRequest) j.a(parcel, BatchToolResultRequest.CREATOR));
                    parcel2.writeNoException();
                    j.R(parcel2, batchToolResultResponseSubmitToolResults, 1);
                    return true;
                case 6:
                    CancelMessageResponse cancelMessageResponseCancelMessage = cancelMessage((CancelMessageRequest) j.a(parcel, CancelMessageRequest.CREATOR));
                    parcel2.writeNoException();
                    j.R(parcel2, cancelMessageResponseCancelMessage, 1);
                    return true;
                case 7:
                    String strSendAgentMessage = sendAgentMessage((Message) j.a(parcel, Message.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeString(strSendAgentMessage);
                    return true;
                case 8:
                    String strRequestToolExecution = requestToolExecution((ToolCall) j.a(parcel, ToolCall.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestToolExecution);
                    return true;
                case 9:
                    List<String> listRequestToolExecutions = requestToolExecutions(parcel.createTypedArrayList(ToolCall.CREATOR));
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
                    List<AbilityMetadata> listQueryAbilityMetas = queryAbilityMetas(parcel.createStringArrayList(), parcel.readString());
                    parcel2.writeNoException();
                    j.b(parcel2, listQueryAbilityMetas, 1);
                    return true;
                case 15:
                    PauseTaskResponse pauseTaskResponsePauseTask = pauseTask((PauseTaskRequest) j.a(parcel, PauseTaskRequest.CREATOR));
                    parcel2.writeNoException();
                    j.R(parcel2, pauseTaskResponsePauseTask, 1);
                    return true;
                case 16:
                    ResumeTaskResponse resumeTaskResponseResumeTask = resumeTask((ResumeTaskRequest) j.a(parcel, ResumeTaskRequest.CREATOR));
                    parcel2.writeNoException();
                    j.R(parcel2, resumeTaskResponseResumeTask, 1);
                    return true;
                case 17:
                    SyncHistoryResponse syncHistoryResponseSyncHistory = syncHistory((SyncHistoryRequest) j.a(parcel, SyncHistoryRequest.CREATOR));
                    parcel2.writeNoException();
                    j.R(parcel2, syncHistoryResponseSyncHistory, 1);
                    return true;
                case 18:
                    SessionOperationResponse sessionOperationResponseManageSession = manageSession((SessionOperationRequest) j.a(parcel, SessionOperationRequest.CREATOR));
                    parcel2.writeNoException();
                    j.R(parcel2, sessionOperationResponseManageSession, 1);
                    return true;
                case 19:
                    SyncConversationsResponse syncConversationsResponseSyncConversations = syncConversations();
                    parcel2.writeNoException();
                    j.R(parcel2, syncConversationsResponseSyncConversations, 1);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
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

    List<AbilityMetadata> queryAbilityMetas(List<String> list, String str) throws RemoteException;

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
