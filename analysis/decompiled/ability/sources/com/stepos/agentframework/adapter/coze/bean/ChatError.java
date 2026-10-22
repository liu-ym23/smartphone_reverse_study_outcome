package com.stepos.agentframework.adapter.coze.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/ChatError;", "", "last_error", "Lcom/stepos/agentframework/adapter/coze/bean/Error;", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/coze/bean/Error;)V", "getLast_error", "()Lcom/stepos/agentframework/adapter/coze/bean/Error;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatError {

    @SerializedName("last_error")
    private final Error last_error;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ChatError copy$default(ChatError chatError, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = chatError.last_error;
        }
        return chatError.copy(error);
    }

    /* renamed from: component1, reason: from getter */
    public final Error getLast_error() {
        return this.last_error;
    }

    public final ChatError copy(Error last_error) {
        return new ChatError(last_error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChatError) && k.b(this.last_error, ((ChatError) other).last_error);
    }

    public final Error getLast_error() {
        return this.last_error;
    }

    public int hashCode() {
        Error error = this.last_error;
        if (error == null) {
            return 0;
        }
        return error.hashCode();
    }

    public String toString() {
        return "ChatError(last_error=" + this.last_error + ")";
    }

    public ChatError(Error error) {
        this.last_error = error;
    }

    public /* synthetic */ ChatError(Error error, int i, e eVar) {
        this((i & 1) != 0 ? null : error);
    }
}
