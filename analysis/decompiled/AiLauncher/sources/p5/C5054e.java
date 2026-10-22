package p5;

import Y8.t;
import android.annotation.SuppressLint;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.sdk.client.AgentServiceClient;
import h8.C4148a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R@\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR:\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060 8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b!\u0010\"\u0012\u0004\b'\u0010\u0003\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lp5/e;", "", "<init>", "()V", "", "taskId", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lp5/e$a;", "pendingByTaskId", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "Lp5/g;", "uiHost", "Lp5/g;", "Lkotlin/Function3;", "aidlSubmit", "Lp9/q;", "getAidlSubmit$chat_release", "()Lp9/q;", "setAidlSubmit$chat_release", "(Lp9/q;)V", "getAidlSubmit$chat_release$annotations", "Lkotlin/Function2;", "aidlCancel", "Lp9/p;", "getAidlCancel$chat_release", "()Lp9/p;", "setAidlCancel$chat_release", "(Lp9/p;)V", "getAidlCancel$chat_release$annotations", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* renamed from: p5.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5054e {
    private static final String TAG = "GuiAgentInfoController";
    private static volatile Context appContext;
    private static volatile InterfaceC5056g uiHost;
    public static final C5054e INSTANCE = new C5054e();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, PendingInfoRequest> pendingByTaskId = new ConcurrentHashMap<>();
    private static volatile q<? super String, ? super String, ? super String, t> aidlSubmit = new q() { // from class: p5.a
        @Override // p9.q
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return C5054e.g((String) obj, (String) obj2, (String) obj3);
        }
    };
    private static volatile p<? super String, ? super String, t> aidlCancel = new p() { // from class: p5.b
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return C5054e.e((String) obj, (String) obj2);
        }
    };

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lp5/e$a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "taskId", "Ljava/lang/String;", "getTaskId", "requestId", Const.INTENT_KEY_APIKEY, "inputType", "getInputType", "message", "getMessage", "Lp5/f;", "payload", "Lp5/f;", "getPayload", "()Lp5/f;", "chatSessionId", "getChatSessionId", "", "createdAt", "J", "getCreatedAt", "()J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: p5.e$a, reason: from toString */
    public static final /* data */ class PendingInfoRequest {
        private final String chatSessionId;
        private final long createdAt;
        private final String inputType;
        private final String message;
        private final InfoPayload payload;
        private final String requestId;
        private final String taskId;

        /* renamed from: a, reason: from getter */
        public final String getRequestId() {
            return this.requestId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingInfoRequest)) {
                return false;
            }
            PendingInfoRequest pendingInfoRequest = (PendingInfoRequest) other;
            return kotlin.jvm.internal.p.d(this.taskId, pendingInfoRequest.taskId) && kotlin.jvm.internal.p.d(this.requestId, pendingInfoRequest.requestId) && kotlin.jvm.internal.p.d(this.inputType, pendingInfoRequest.inputType) && kotlin.jvm.internal.p.d(this.message, pendingInfoRequest.message) && kotlin.jvm.internal.p.d(this.payload, pendingInfoRequest.payload) && kotlin.jvm.internal.p.d(this.chatSessionId, pendingInfoRequest.chatSessionId) && this.createdAt == pendingInfoRequest.createdAt;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.taskId.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.inputType.hashCode()) * 31) + this.message.hashCode()) * 31) + this.payload.hashCode()) * 31;
            String str = this.chatSessionId;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.createdAt);
        }

        public String toString() {
            return "PendingInfoRequest(taskId=" + this.taskId + ", requestId=" + this.requestId + ", inputType=" + this.inputType + ", message=" + this.message + ", payload=" + this.payload + ", chatSessionId=" + this.chatSessionId + ", createdAt=" + this.createdAt + ")";
        }
    }

    public static final t e(final String taskId, final String requestId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        com.stepos.agentframework.chatcore.intent.d.INSTANCE.n(new InterfaceC5063a() { // from class: p5.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C5054e.f(taskId, requestId);
            }
        });
        return t.f7040a;
    }

    public static final t f(String str, String str2) {
        AgentServiceClient.f22085a.I(str, str2);
        return t.f7040a;
    }

    public static final t g(final String taskId, final String requestId, final String content) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(content, "content");
        com.stepos.agentframework.chatcore.intent.d.INSTANCE.n(new InterfaceC5063a() { // from class: p5.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C5054e.h(taskId, requestId, content);
            }
        });
        return t.f7040a;
    }

    public static final t h(String str, String str2, String str3) {
        AgentServiceClient.f22085a.j0(str, str2, str3);
        return t.f7040a;
    }

    public final void i(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        PendingInfoRequest pendingInfoRequestRemove = pendingByTaskId.remove(taskId);
        if (pendingInfoRequestRemove == null) {
            C4148a.u(TAG, "cancelUserInput: no pending for taskId=" + taskId + "; ignored", false, 4, null);
            return;
        }
        C4148a.k(TAG, "cancelUserInput: taskId=" + taskId + " requestId=" + pendingInfoRequestRemove.getRequestId(), false, 4, null);
        aidlCancel.invoke(taskId, pendingInfoRequestRemove.getRequestId());
    }
}
