package io.modelcontextprotocol.kotlin.sdk.server;

import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.modelcontextprotocol.kotlin.sdk.GetPromptRequest;
import io.modelcontextprotocol.kotlin.sdk.GetPromptResult;
import io.modelcontextprotocol.kotlin.sdk.Prompt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\fR3\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredPrompt;", "", "Lio/modelcontextprotocol/kotlin/sdk/Prompt;", HighlightArgsBundle.KEY_PROMPT, "Lkotlin/Function2;", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "Le9/c;", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptResult;", "messageProvider", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Prompt;Lp9/p;)V", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/Prompt;", "component2", "()Lp9/p;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/Prompt;Lp9/p;)Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredPrompt;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/Prompt;", "getPrompt", "Lp9/p;", "getMessageProvider", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegisteredPrompt {
    private final p9.p<GetPromptRequest, InterfaceC4014c<? super GetPromptResult>, Object> messageProvider;
    private final Prompt prompt;

    /* JADX WARN: Multi-variable type inference failed */
    public RegisteredPrompt(Prompt prompt, p9.p<? super GetPromptRequest, ? super InterfaceC4014c<? super GetPromptResult>, ? extends Object> messageProvider) {
        kotlin.jvm.internal.p.i(prompt, "prompt");
        kotlin.jvm.internal.p.i(messageProvider, "messageProvider");
        this.prompt = prompt;
        this.messageProvider = messageProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisteredPrompt copy$default(RegisteredPrompt registeredPrompt, Prompt prompt, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            prompt = registeredPrompt.prompt;
        }
        if ((i10 & 2) != 0) {
            pVar = registeredPrompt.messageProvider;
        }
        return registeredPrompt.copy(prompt, pVar);
    }

    /* renamed from: component1, reason: from getter */
    public final Prompt getPrompt() {
        return this.prompt;
    }

    public final p9.p<GetPromptRequest, InterfaceC4014c<? super GetPromptResult>, Object> component2() {
        return this.messageProvider;
    }

    public final RegisteredPrompt copy(Prompt prompt, p9.p<? super GetPromptRequest, ? super InterfaceC4014c<? super GetPromptResult>, ? extends Object> messageProvider) {
        kotlin.jvm.internal.p.i(prompt, "prompt");
        kotlin.jvm.internal.p.i(messageProvider, "messageProvider");
        return new RegisteredPrompt(prompt, messageProvider);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisteredPrompt)) {
            return false;
        }
        RegisteredPrompt registeredPrompt = (RegisteredPrompt) other;
        return kotlin.jvm.internal.p.d(this.prompt, registeredPrompt.prompt) && kotlin.jvm.internal.p.d(this.messageProvider, registeredPrompt.messageProvider);
    }

    public final p9.p<GetPromptRequest, InterfaceC4014c<? super GetPromptResult>, Object> getMessageProvider() {
        return this.messageProvider;
    }

    public final Prompt getPrompt() {
        return this.prompt;
    }

    public int hashCode() {
        return (this.prompt.hashCode() * 31) + this.messageProvider.hashCode();
    }

    public String toString() {
        return "RegisteredPrompt(prompt=" + this.prompt + ", messageProvider=" + this.messageProvider + ')';
    }
}
