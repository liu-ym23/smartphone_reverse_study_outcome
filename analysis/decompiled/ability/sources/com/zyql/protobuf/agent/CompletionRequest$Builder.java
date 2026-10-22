package com.zyql.protobuf.agent;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import o7.C1768d;
import o7.C1769e;
import o7.v;
import o7.z;

/* loaded from: classes2.dex */
public final class CompletionRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ CompletionRequest$Builder(int i) {
        this();
    }

    public CompletionRequest$Builder addAllMessages(Iterable<? extends C1768d> iterable) {
        copyOnWrite();
        C1769e.D((C1769e) this.instance, iterable);
        return this;
    }

    public CompletionRequest$Builder addAllTools(Iterable<? extends z> iterable) {
        copyOnWrite();
        C1769e.E((C1769e) this.instance, iterable);
        return this;
    }

    public CompletionRequest$Builder addMessages(C1768d c1768d) {
        copyOnWrite();
        C1769e.G((C1769e) this.instance, c1768d);
        return this;
    }

    public CompletionRequest$Builder addTools(z zVar) {
        copyOnWrite();
        C1769e.I((C1769e) this.instance, zVar);
        return this;
    }

    public CompletionRequest$Builder clearConfig() {
        copyOnWrite();
        C1769e.J((C1769e) this.instance);
        return this;
    }

    public CompletionRequest$Builder clearMessages() {
        copyOnWrite();
        C1769e.K((C1769e) this.instance);
        return this;
    }

    public CompletionRequest$Builder clearTools() {
        copyOnWrite();
        C1769e.L((C1769e) this.instance);
        return this;
    }

    public v getConfig() {
        return ((C1769e) this.instance).V();
    }

    public C1768d getMessages(int i) {
        return ((C1769e) this.instance).W(i);
    }

    public int getMessagesCount() {
        return ((C1769e) this.instance).X();
    }

    public List<C1768d> getMessagesList() {
        return Collections.unmodifiableList(((C1769e) this.instance).Y());
    }

    public z getTools(int i) {
        return ((C1769e) this.instance).Z(i);
    }

    public int getToolsCount() {
        return ((C1769e) this.instance).a0();
    }

    public List<z> getToolsList() {
        return Collections.unmodifiableList(((C1769e) this.instance).b0());
    }

    public boolean hasConfig() {
        return ((C1769e) this.instance).c0();
    }

    public CompletionRequest$Builder mergeConfig(v vVar) {
        copyOnWrite();
        C1769e.M((C1769e) this.instance, vVar);
        return this;
    }

    public CompletionRequest$Builder removeMessages(int i) {
        copyOnWrite();
        C1769e.N((C1769e) this.instance, i);
        return this;
    }

    public CompletionRequest$Builder removeTools(int i) {
        copyOnWrite();
        C1769e.O((C1769e) this.instance, i);
        return this;
    }

    public CompletionRequest$Builder setConfig(v vVar) {
        copyOnWrite();
        C1769e.P((C1769e) this.instance, vVar);
        return this;
    }

    public CompletionRequest$Builder setMessages(int i, C1768d c1768d) {
        copyOnWrite();
        C1769e.Q((C1769e) this.instance, i, c1768d);
        return this;
    }

    public CompletionRequest$Builder setTools(int i, z zVar) {
        copyOnWrite();
        C1769e.R((C1769e) this.instance, i, zVar);
        return this;
    }

    private CompletionRequest$Builder() {
        super(C1769e.DEFAULT_INSTANCE);
    }

    public CompletionRequest$Builder addMessages(int i, C1768d c1768d) {
        copyOnWrite();
        C1769e.F((C1769e) this.instance, i, c1768d);
        return this;
    }

    public CompletionRequest$Builder addTools(int i, z zVar) {
        copyOnWrite();
        C1769e.H((C1769e) this.instance, i, zVar);
        return this;
    }

    public CompletionRequest$Builder setConfig(ModelConfig$Builder modelConfig$Builder) {
        copyOnWrite();
        C1769e.P((C1769e) this.instance, (v) modelConfig$Builder.k());
        return this;
    }

    public CompletionRequest$Builder setMessages(int i, ChatMessage$Builder chatMessage$Builder) {
        copyOnWrite();
        C1769e.Q((C1769e) this.instance, i, (C1768d) chatMessage$Builder.k());
        return this;
    }

    public CompletionRequest$Builder setTools(int i, ToolDefinition$Builder toolDefinition$Builder) {
        copyOnWrite();
        C1769e.R((C1769e) this.instance, i, (z) toolDefinition$Builder.k());
        return this;
    }

    public CompletionRequest$Builder addMessages(ChatMessage$Builder chatMessage$Builder) {
        copyOnWrite();
        C1769e.G((C1769e) this.instance, (C1768d) chatMessage$Builder.k());
        return this;
    }

    public CompletionRequest$Builder addTools(ToolDefinition$Builder toolDefinition$Builder) {
        copyOnWrite();
        C1769e.I((C1769e) this.instance, (z) toolDefinition$Builder.k());
        return this;
    }

    public CompletionRequest$Builder addMessages(int i, ChatMessage$Builder chatMessage$Builder) {
        copyOnWrite();
        C1769e.F((C1769e) this.instance, i, (C1768d) chatMessage$Builder.k());
        return this;
    }

    public CompletionRequest$Builder addTools(int i, ToolDefinition$Builder toolDefinition$Builder) {
        copyOnWrite();
        C1769e.H((C1769e) this.instance, i, (z) toolDefinition$Builder.k());
        return this;
    }
}
