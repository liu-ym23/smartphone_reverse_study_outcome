package com.stepos.ability.mcpserver.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpErrorPayload;", "", "code", "", "message", "", SettingsConfig.KEY_DATA, AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class McpErrorPayload {
    private final int code;
    private final Object data;
    private final String message;

    public McpErrorPayload(int i, String message, Object obj) {
        k.f(message, "message");
        this.code = i;
        this.message = message;
        this.data = obj;
    }

    public static /* synthetic */ McpErrorPayload copy$default(McpErrorPayload mcpErrorPayload, int i, String str, Object obj, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            i = mcpErrorPayload.code;
        }
        if ((i6 & 2) != 0) {
            str = mcpErrorPayload.message;
        }
        if ((i6 & 4) != 0) {
            obj = mcpErrorPayload.data;
        }
        return mcpErrorPayload.copy(i, str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final McpErrorPayload copy(int code, String message, Object data) {
        k.f(message, "message");
        return new McpErrorPayload(code, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpErrorPayload)) {
            return false;
        }
        McpErrorPayload mcpErrorPayload = (McpErrorPayload) other;
        return this.code == mcpErrorPayload.code && k.b(this.message, mcpErrorPayload.message) && k.b(this.data, mcpErrorPayload.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final Object getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iC = a.c(Integer.hashCode(this.code) * 31, 31, this.message);
        Object obj = this.data;
        return iC + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        int i = this.code;
        String str = this.message;
        Object obj = this.data;
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "McpErrorPayload(code=", ", message=", str, ", data=");
        sbK.append(obj);
        sbK.append(")");
        return sbK.toString();
    }

    public /* synthetic */ McpErrorPayload(int i, String str, Object obj, int i6, e eVar) {
        this(i, str, (i6 & 4) != 0 ? null : obj);
    }
}
