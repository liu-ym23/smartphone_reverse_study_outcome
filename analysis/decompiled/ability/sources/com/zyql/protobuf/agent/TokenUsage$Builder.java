package com.zyql.protobuf.agent;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.y;

/* loaded from: classes2.dex */
public final class TokenUsage$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TokenUsage$Builder(int i) {
        this();
    }

    public TokenUsage$Builder clearCompletionTokens() {
        copyOnWrite();
        y.D((y) this.instance);
        return this;
    }

    public TokenUsage$Builder clearPromptTokens() {
        copyOnWrite();
        y.E((y) this.instance);
        return this;
    }

    public TokenUsage$Builder clearTotalTokens() {
        copyOnWrite();
        y.F((y) this.instance);
        return this;
    }

    public int getCompletionTokens() {
        return ((y) this.instance).K();
    }

    public int getPromptTokens() {
        return ((y) this.instance).M();
    }

    public int getTotalTokens() {
        return ((y) this.instance).N();
    }

    public TokenUsage$Builder setCompletionTokens(int i) {
        copyOnWrite();
        y.G((y) this.instance, i);
        return this;
    }

    public TokenUsage$Builder setPromptTokens(int i) {
        copyOnWrite();
        y.H((y) this.instance, i);
        return this;
    }

    public TokenUsage$Builder setTotalTokens(int i) {
        copyOnWrite();
        y.I((y) this.instance, i);
        return this;
    }

    private TokenUsage$Builder() {
        super(y.DEFAULT_INSTANCE);
    }
}
