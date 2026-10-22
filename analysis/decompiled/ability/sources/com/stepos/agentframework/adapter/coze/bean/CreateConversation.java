package com.stepos.agentframework.adapter.coze.bean;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/CreateConversation;", "", "bot_id", "", "connector_id", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getBot_id", "()Ljava/lang/String;", "getConnector_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CreateConversation {
    private final String bot_id;
    private final String connector_id;

    public CreateConversation(String bot_id, String connector_id) {
        k.f(bot_id, "bot_id");
        k.f(connector_id, "connector_id");
        this.bot_id = bot_id;
        this.connector_id = connector_id;
    }

    public static /* synthetic */ CreateConversation copy$default(CreateConversation createConversation, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createConversation.bot_id;
        }
        if ((i & 2) != 0) {
            str2 = createConversation.connector_id;
        }
        return createConversation.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBot_id() {
        return this.bot_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConnector_id() {
        return this.connector_id;
    }

    public final CreateConversation copy(String bot_id, String connector_id) {
        k.f(bot_id, "bot_id");
        k.f(connector_id, "connector_id");
        return new CreateConversation(bot_id, connector_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateConversation)) {
            return false;
        }
        CreateConversation createConversation = (CreateConversation) other;
        return k.b(this.bot_id, createConversation.bot_id) && k.b(this.connector_id, createConversation.connector_id);
    }

    public final String getBot_id() {
        return this.bot_id;
    }

    public final String getConnector_id() {
        return this.connector_id;
    }

    public int hashCode() {
        return this.connector_id.hashCode() + (this.bot_id.hashCode() * 31);
    }

    public String toString() {
        return a.m("CreateConversation(bot_id=", this.bot_id, ", connector_id=", this.connector_id, ")");
    }

    public /* synthetic */ CreateConversation(String str, String str2, int i, e eVar) {
        this(str, (i & 2) != 0 ? "1024" : str2);
    }
}
