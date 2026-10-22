package com.stepos.agentframework.adapter.error;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", "", "code", "", "message", "", AppAgent.CONSTRUCT, "(ILjava/lang/String;)V", "Companion", "NotInit", "NoNetwork", "ClientNotFound", "AgentInternalError", "Unknow", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$AgentInternalError;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$ClientNotFound;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$NoNetwork;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$NotInit;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$Unknow;", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AdapterErrorCode {
    public static final int ERROR_AGENT_INTERNAL_ERROR = -300;
    public static final int ERROR_CLIENT_NOT_FOUND = -201;
    public static final int ERROR_NOT_INIT = -200;
    public static final int ERROR_NO_NETWORK = -100;
    public static final int ERROR_UNKNOW = -999;
    public final int code;
    public final String message;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$AgentInternalError;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", "originMsg", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getOriginMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AgentInternalError extends AdapterErrorCode {
        private final String originMsg;

        public AgentInternalError(String str) {
            super(AdapterErrorCode.ERROR_AGENT_INTERNAL_ERROR, str == null ? "Agent端 内部错误" : str, null);
            this.originMsg = str;
        }

        public static /* synthetic */ AgentInternalError copy$default(AgentInternalError agentInternalError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = agentInternalError.originMsg;
            }
            return agentInternalError.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getOriginMsg() {
            return this.originMsg;
        }

        public final AgentInternalError copy(String originMsg) {
            return new AgentInternalError(originMsg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AgentInternalError) && k.b(this.originMsg, ((AgentInternalError) other).originMsg);
        }

        public final String getOriginMsg() {
            return this.originMsg;
        }

        public int hashCode() {
            String str = this.originMsg;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return a.m("AgentInternalError(originMsg=", this.originMsg, ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$ClientNotFound;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", "type", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ClientNotFound extends AdapterErrorCode {
        private final String type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientNotFound(String type) {
            super(AdapterErrorCode.ERROR_CLIENT_NOT_FOUND, "未找到 " + type + " 类型的 Client", null);
            k.f(type, "type");
            this.type = type;
        }

        public static /* synthetic */ ClientNotFound copy$default(ClientNotFound clientNotFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clientNotFound.type;
            }
            return clientNotFound.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final ClientNotFound copy(String type) {
            k.f(type, "type");
            return new ClientNotFound(type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ClientNotFound) && k.b(this.type, ((ClientNotFound) other).type);
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return a.m("ClientNotFound(type=", this.type, ")");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$NoNetwork;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", AppAgent.CONSTRUCT, "()V", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NoNetwork extends AdapterErrorCode {
        public static final NoNetwork INSTANCE = new NoNetwork();

        private NoNetwork() {
            super(-100, "当前网络不可用，请检查网络", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$NotInit;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", AppAgent.CONSTRUCT, "()V", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NotInit extends AdapterErrorCode {
        public static final NotInit INSTANCE = new NotInit();

        private NotInit() {
            super(AdapterErrorCode.ERROR_NOT_INIT, "SDK 未初始化，请先调用 init()", null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterErrorCode$Unknow;", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", "e", "", AppAgent.CONSTRUCT, "(Ljava/lang/Throwable;)V", "getE", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unknow extends AdapterErrorCode {
        private final Throwable e;

        /* JADX WARN: Multi-variable type inference failed */
        public Unknow() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Unknow copy$default(Unknow unknow, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = unknow.e;
            }
            return unknow.copy(th);
        }

        /* renamed from: component1, reason: from getter */
        public final Throwable getE() {
            return this.e;
        }

        public final Unknow copy(Throwable e) {
            return new Unknow(e);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unknow) && k.b(this.e, ((Unknow) other).e);
        }

        public final Throwable getE() {
            return this.e;
        }

        public int hashCode() {
            Throwable th = this.e;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            return "Unknow(e=" + this.e + ")";
        }

        public Unknow(Throwable th) {
            super(AdapterErrorCode.ERROR_UNKNOW, "未知错误", null);
            this.e = th;
        }

        public /* synthetic */ Unknow(Throwable th, int i, e eVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    public /* synthetic */ AdapterErrorCode(int i, String str, e eVar) {
        this(i, str);
    }

    private AdapterErrorCode(int i, String str) {
        this.code = i;
        this.message = str;
    }
}
