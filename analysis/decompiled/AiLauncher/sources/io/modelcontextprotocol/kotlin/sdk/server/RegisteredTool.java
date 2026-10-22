package io.modelcontextprotocol.kotlin.sdk.server;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.modelcontextprotocol.kotlin.sdk.CallToolRequest;
import io.modelcontextprotocol.kotlin.sdk.CallToolResult;
import io.modelcontextprotocol.kotlin.sdk.Tool;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\fR3\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredTool;", "", "Lio/modelcontextprotocol/kotlin/sdk/Tool;", "tool", "Lkotlin/Function2;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "Le9/c;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;", "handler", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Tool;Lp9/p;)V", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/Tool;", "component2", "()Lp9/p;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/Tool;Lp9/p;)Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredTool;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/Tool;", "getTool", "Lp9/p;", "getHandler", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegisteredTool {
    private final p9.p<CallToolRequest, InterfaceC4014c<? super CallToolResult>, Object> handler;
    private final Tool tool;

    /* JADX WARN: Multi-variable type inference failed */
    public RegisteredTool(Tool tool, p9.p<? super CallToolRequest, ? super InterfaceC4014c<? super CallToolResult>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(tool, "tool");
        kotlin.jvm.internal.p.i(handler, "handler");
        this.tool = tool;
        this.handler = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisteredTool copy$default(RegisteredTool registeredTool, Tool tool, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            tool = registeredTool.tool;
        }
        if ((i10 & 2) != 0) {
            pVar = registeredTool.handler;
        }
        return registeredTool.copy(tool, pVar);
    }

    /* renamed from: component1, reason: from getter */
    public final Tool getTool() {
        return this.tool;
    }

    public final p9.p<CallToolRequest, InterfaceC4014c<? super CallToolResult>, Object> component2() {
        return this.handler;
    }

    public final RegisteredTool copy(Tool tool, p9.p<? super CallToolRequest, ? super InterfaceC4014c<? super CallToolResult>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(tool, "tool");
        kotlin.jvm.internal.p.i(handler, "handler");
        return new RegisteredTool(tool, handler);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisteredTool)) {
            return false;
        }
        RegisteredTool registeredTool = (RegisteredTool) other;
        return kotlin.jvm.internal.p.d(this.tool, registeredTool.tool) && kotlin.jvm.internal.p.d(this.handler, registeredTool.handler);
    }

    public final p9.p<CallToolRequest, InterfaceC4014c<? super CallToolResult>, Object> getHandler() {
        return this.handler;
    }

    public final Tool getTool() {
        return this.tool;
    }

    public int hashCode() {
        return (this.tool.hashCode() * 31) + this.handler.hashCode();
    }

    public String toString() {
        return "RegisteredTool(tool=" + this.tool + ", handler=" + this.handler + ')';
    }
}
