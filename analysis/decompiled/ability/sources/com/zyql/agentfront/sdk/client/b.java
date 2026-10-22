package com.zyql.agentfront.sdk.client;

import A6.i;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.zyql.agentfront.IMessageBridge;
import com.zyql.agentfront.bean.CancelMessageRequest;
import com.zyql.agentfront.bean.CancelMessageResponse;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.SessionOperationRequest;
import com.zyql.agentfront.bean.SessionOperationResponse;
import com.zyql.agentfront.bean.SyncConversationsResponse;
import com.zyql.agentfront.bean.SyncHistoryRequest;
import com.zyql.agentfront.bean.SyncHistoryResponse;
import j9.m;
import j9.t;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import k7.o;
import k7.p;
import k7.r;
import kotlin.jvm.internal.k;
import l7.AbstractC1663a;
import m7.C1680a;

/* loaded from: classes3.dex */
public final class b extends AbstractC1663a {
    public static volatile e p;

    /* renamed from: q, reason: collision with root package name */
    public static volatile Context f4241q;

    /* renamed from: r, reason: collision with root package name */
    public static volatile b f4242r;

    /* renamed from: s, reason: collision with root package name */
    public static volatile C1680a f4243s = m7.b.f5305a;

    /* renamed from: j, reason: collision with root package name */
    public final Context f4244j;
    public final ConcurrentHashMap k;
    public final ConcurrentHashMap l;
    public volatile e m;
    public final Handler n;
    public final AgentFrontClient$messageListenerStub$1 o;

    public b(Context context) {
        l7.c cVar = new l7.c();
        k.f(context, "context");
        super(cVar);
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        this.f4244j = applicationContext;
        f4242r = this;
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.n = new Handler(Looper.getMainLooper());
        this.o = new AgentFrontClient$messageListenerStub$1(this);
    }

    public final void g(CancelMessageRequest cancelMessageRequest) {
        String msg = "[API] cancelMessage. request:" + cancelMessageRequest;
        f4243s.getClass();
        k.f(msg, "msg");
        Log.d("AgentFrontClient", msg);
        try {
            try {
                IMessageBridge iMessageBridge = this.f5289a;
                f4243s.b("AgentFrontClient", "[API] cancel message:" + cancelMessageRequest.getMessageId() + ", traceId:" + cancelMessageRequest.getTraceId() + " start. service:" + (iMessageBridge != null));
                if (iMessageBridge == null || !d()) {
                    j(null, new i(14, this, cancelMessageRequest));
                } else {
                    IMessageBridge iMessageBridge2 = this.f5289a;
                    CancelMessageResponse cancelMessageResponseCancelMessage = iMessageBridge2 != null ? iMessageBridge2.cancelMessage(cancelMessageRequest) : null;
                    f4243s.a("AgentFrontClient", "[API] cancelMessage message:" + cancelMessageRequest.getMessageId() + ", traceId:" + cancelMessageRequest.getTraceId() + " end. result:" + cancelMessageResponseCancelMessage, null);
                }
                new CancelMessageResponse(true, null, null, null, null, 30, null);
            } catch (RemoteException e) {
                f4243s.a("AgentFrontClient", "[API] cancelMessage message:" + cancelMessageRequest.getMessageId() + ", traceId:" + cancelMessageRequest.getTraceId() + " failed: " + e.getMessage(), e);
                k(e);
                k7.e eVar = CancelMessageResponse.CREATOR;
                String message = e.getMessage();
                if (message == null) {
                    message = "RemoteException";
                }
                String traceId = cancelMessageRequest.getTraceId();
                eVar.getClass();
                new CancelMessageResponse(false, null, message, null, traceId, 8, null);
            }
            this.k.remove(cancelMessageRequest.getMessageId());
        } catch (Throwable th) {
            this.k.remove(cancelMessageRequest.getMessageId());
            throw th;
        }
    }

    public final void h() {
        a(this.f4244j);
        f4243s.b("AgentFrontClient", "[API] connect call");
    }

    public final void i() {
        f4243s.b("AgentFrontClient", "[API] destroy call");
        if (f4242r == this) {
            f4242r = null;
        }
        this.k.clear();
        this.l.clear();
        Context context = this.f4244j;
        k.f(context, "context");
        this.h = true;
        b(context);
        this.c = null;
    }

    public final void j(R3.k kVar, S7.a aVar) {
        if (d()) {
            aVar.invoke();
            return;
        }
        f4243s.getClass();
        Log.d("AgentFrontClient", "Service not connected, starting service and binding...");
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zyql.agentfront", "com.zyql.agentfront.service.MessageBridgeService");
            this.f4244j.startService(intent);
            f4243s.getClass();
            Log.d("AgentFrontClient", "startService success for com.zyql.agentfront.service.MessageBridgeService");
            a(this.f4244j);
            this.c = new u1.d(this.c, this, aVar, kVar, 15);
        } catch (Exception e) {
            f4243s.a("AgentFrontClient", "Failed to start remote service: " + e.getMessage(), e);
            f4243s.a("AgentFrontClient", "Failed to start service", null);
            if (kVar != null) {
                kVar.invoke("Failed to start service");
            }
        }
    }

    public final void k(Exception exc) {
        f4243s.a("AgentFrontClient", "Remote communication failed: " + exc.getMessage(), null);
        if (this.h) {
            return;
        }
        f4243s.b("AgentFrontClient", "Remote communication failed. reconnect");
        b(this.f4244j);
        h();
    }

    public final SessionOperationResponse l(SessionOperationRequest sessionOperationRequest) {
        C1680a c1680a = f4243s;
        String sessionKey = sessionOperationRequest.getSessionKey();
        int operation = sessionOperationRequest.getOperation();
        String traceId = sessionOperationRequest.getTraceId();
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(operation, "[API] manageSession: sessionKey=", sessionKey, ", operation=", ", traceId=");
        sbT.append(traceId);
        String msg = sbT.toString();
        c1680a.getClass();
        k.f(msg, "msg");
        Log.d("AgentFrontClient", msg);
        try {
            IMessageBridge iMessageBridge = this.f5289a;
            if (iMessageBridge != null && d()) {
                SessionOperationResponse sessionOperationResponseManageSession = iMessageBridge.manageSession(sessionOperationRequest);
                f4243s.b("AgentFrontClient", "[API] manageSession sessionKey:" + sessionOperationRequest.getSessionKey() + " operation:" + sessionOperationRequest.getOperation() + " end. success=" + sessionOperationResponseManageSession.getSuccess());
                return sessionOperationResponseManageSession;
            }
            f4243s.getClass();
            Log.w("AgentFrontClient", "[API] manageSession: Service not connected");
            o oVar = SessionOperationResponse.CREATOR;
            String traceId2 = sessionOperationRequest.getTraceId();
            oVar.getClass();
            return new SessionOperationResponse(false, "Service not connected", traceId2);
        } catch (RemoteException e) {
            f4243s.a("AgentFrontClient", "[API] manageSession failed: " + e.getMessage(), e);
            k(e);
            o oVar2 = SessionOperationResponse.CREATOR;
            String message = e.getMessage();
            String traceId3 = sessionOperationRequest.getTraceId();
            oVar2.getClass();
            return new SessionOperationResponse(false, message, traceId3);
        }
    }

    public final void m(Message message, c callback) {
        IBinder iBinderAsBinder;
        k.f(message, "message");
        k.f(callback, "callback");
        C1680a c1680a = f4243s;
        String messageId = message.getMessageId();
        String conversationId = message.getConversationId();
        String traceId = message.getTraceId();
        String targetPackage = message.getTargetPackage();
        String type = message.getType();
        StringBuilder sbW = B7.a.w("[API] sendMessage: messageId=", messageId, ", conversationId:", conversationId, ", traceId:");
        androidx.constraintlayout.core.dsl.a.A(sbW, traceId, ", targetPackage=", targetPackage, ", type=");
        sbW.append(type);
        String msg = sbW.toString();
        c1680a.getClass();
        k.f(msg, "msg");
        Log.d("AgentFrontClient", msg);
        String packageName = this.f4244j.getPackageName();
        String sourcePackage = message.getSourcePackage();
        if (sourcePackage == null || m.s0(sourcePackage)) {
            message.setSourcePackage(packageName);
        }
        if (m.s0(message.getMessageId()) || k.b(message.getMessageId(), "0")) {
            k.c(packageName);
            String strI0 = m.I0('.', packageName, packageName);
            String string = UUID.randomUUID().toString();
            k.e(string, "toString(...)");
            message.setMessageId(strI0 + "_" + t.c0(string, "-", ""));
            C1680a c1680a2 = f4243s;
            String msg2 = "[API] Generate messageId=" + message.getMessageId();
            c1680a2.getClass();
            k.f(msg2, "msg");
            Log.d("AgentFrontClient", msg2);
        }
        this.k.put(message.getMessageId(), callback);
        f4243s.getClass();
        Log.d("AgentFrontClient", "[API] start getService.");
        IMessageBridge iMessageBridge = this.f5289a;
        f4243s.getClass();
        Log.d("AgentFrontClient", "[API] end getService.");
        boolean zIsBinderAlive = (iMessageBridge == null || (iBinderAsBinder = iMessageBridge.asBinder()) == null) ? false : iBinderAsBinder.isBinderAlive();
        String msg3 = "[API] isBinderAlive=" + zIsBinderAlive;
        f4243s.getClass();
        k.f(msg3, "msg");
        Log.d("AgentFrontClient", msg3);
        if (iMessageBridge != null && d() && zIsBinderAlive) {
            try {
                k.c(iMessageBridge.sendMessage(message));
                return;
            } catch (Exception e) {
                f4243s.a("AgentFrontClient", "Failed to send message: " + e.getMessage(), null);
                synchronized (this.g) {
                    this.g.add(message);
                    k(e);
                    f4243s.b("AgentFrontClient", "sendMessage caught exception, message pending for retry. msgId:" + message.getMessageId());
                    message.getMessageId();
                    return;
                }
            }
        }
        String msg4 = "Service connection invalid (Alive=" + zIsBinderAlive + "). reconnecting...";
        f4243s.getClass();
        k.f(msg4, "msg");
        Log.w("AgentFrontClient", msg4);
        synchronized (this.g) {
            this.g.add(message);
        }
        if (iMessageBridge == null || !zIsBinderAlive) {
            k(new Exception("Binder is dead or null"));
        }
        C1680a c1680a3 = f4243s;
        String msg5 = "Service not connected, starting service and queuing message: " + message.getMessageId();
        c1680a3.getClass();
        k.f(msg5, "msg");
        Log.w("AgentFrontClient", msg5);
        j(new R3.k(message, callback, this, 9), new D6.i(this, 25));
        message.getMessageId();
    }

    public final void n(e eVar) {
        this.m = eVar;
        p = eVar;
        f4241q = this.f4244j;
        C1680a c1680a = f4243s;
        String msg = "[API] setPushMessageListener: listener set = " + (eVar != null);
        c1680a.getClass();
        k.f(msg, "msg");
        Log.d("AgentFrontClient", msg);
        if (eVar == null || d()) {
            return;
        }
        f4243s.getClass();
        Log.d("AgentFrontClient", "[API] setPushMessageListener: service not connected, ensuring connection...");
        j(null, new com.uxsense.parse.a(14));
    }

    public final SyncConversationsResponse o() {
        f4243s.getClass();
        Log.d("AgentFrontClient", "[API] syncConversations");
        try {
            IMessageBridge iMessageBridge = this.f5289a;
            if (iMessageBridge != null && d()) {
                SyncConversationsResponse syncConversationsResponseSyncConversations = iMessageBridge.syncConversations();
                f4243s.b("AgentFrontClient", "[API] syncConversations end. success=" + syncConversationsResponseSyncConversations.getSuccess() + ", sessions=" + syncConversationsResponseSyncConversations.getSessions().size());
                return syncConversationsResponseSyncConversations;
            }
            f4243s.getClass();
            Log.w("AgentFrontClient", "[API] syncConversations: Service not connected");
            SyncConversationsResponse.CREATOR.getClass();
            return new SyncConversationsResponse(null, false, "Service not connected", 1, null);
        } catch (RemoteException e) {
            f4243s.a("AgentFrontClient", "[API] syncConversations failed: " + e.getMessage(), e);
            k(e);
            p pVar = SyncConversationsResponse.CREATOR;
            String message = e.getMessage();
            pVar.getClass();
            return new SyncConversationsResponse(null, false, message, 1, null);
        }
    }

    public final SyncHistoryResponse p(SyncHistoryRequest syncHistoryRequest) {
        C1680a c1680a = f4243s;
        String msg = "[API] syncHistory: sessionKey=" + syncHistoryRequest.getSessionKey() + ", traceId=" + syncHistoryRequest.getTraceId();
        c1680a.getClass();
        k.f(msg, "msg");
        Log.d("AgentFrontClient", msg);
        try {
            IMessageBridge iMessageBridge = this.f5289a;
            if (iMessageBridge != null && d()) {
                SyncHistoryResponse syncHistoryResponseSyncHistory = iMessageBridge.syncHistory(syncHistoryRequest);
                f4243s.b("AgentFrontClient", "[API] syncHistory sessionKey:" + syncHistoryRequest.getSessionKey() + " end. success=" + syncHistoryResponseSyncHistory.getSuccess() + ", messages=" + syncHistoryResponseSyncHistory.getMessages().size());
                return syncHistoryResponseSyncHistory;
            }
            f4243s.getClass();
            Log.w("AgentFrontClient", "[API] syncHistory: Service not connected");
            r rVar = SyncHistoryResponse.CREATOR;
            String traceId = syncHistoryRequest.getTraceId();
            rVar.getClass();
            return new SyncHistoryResponse(null, false, "Service not connected", traceId, 1, null);
        } catch (RemoteException e) {
            f4243s.a("AgentFrontClient", "[API] syncHistory failed: " + e.getMessage(), e);
            k(e);
            r rVar2 = SyncHistoryResponse.CREATOR;
            String message = e.getMessage();
            String traceId2 = syncHistoryRequest.getTraceId();
            rVar2.getClass();
            return new SyncHistoryResponse(null, false, message, traceId2, 1, null);
        }
    }
}
