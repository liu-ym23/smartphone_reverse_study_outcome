package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.FunctionCall$Builder;
import java.util.Collections;
import java.util.List;
import o7.C1768d;
import o7.C1770f;
import o7.y;
import q7.C1810h;

/* loaded from: classes2.dex */
public final class CompletionResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ CompletionResponse$Builder(int i) {
        this();
    }

    public CompletionResponse$Builder addAllToolCalls(Iterable<? extends C1810h> iterable) {
        copyOnWrite();
        C1770f.D((C1770f) this.instance, iterable);
        return this;
    }

    public CompletionResponse$Builder addToolCalls(C1810h c1810h) {
        copyOnWrite();
        C1770f.F((C1770f) this.instance, c1810h);
        return this;
    }

    public CompletionResponse$Builder clearFinishReason() {
        copyOnWrite();
        C1770f.G((C1770f) this.instance);
        return this;
    }

    public CompletionResponse$Builder clearMessage() {
        copyOnWrite();
        C1770f.H((C1770f) this.instance);
        return this;
    }

    public CompletionResponse$Builder clearProviderError() {
        copyOnWrite();
        C1770f.I((C1770f) this.instance);
        return this;
    }

    public CompletionResponse$Builder clearTokenUsage() {
        copyOnWrite();
        C1770f.J((C1770f) this.instance);
        return this;
    }

    public CompletionResponse$Builder clearToolCalls() {
        copyOnWrite();
        C1770f.K((C1770f) this.instance);
        return this;
    }

    public String getFinishReason() {
        return ((C1770f) this.instance).X();
    }

    public ByteString getFinishReasonBytes() {
        return ((C1770f) this.instance).Y();
    }

    public C1768d getMessage() {
        return ((C1770f) this.instance).Z();
    }

    public String getProviderError() {
        return ((C1770f) this.instance).a0();
    }

    public ByteString getProviderErrorBytes() {
        return ((C1770f) this.instance).b0();
    }

    public y getTokenUsage() {
        return ((C1770f) this.instance).c0();
    }

    public C1810h getToolCalls(int i) {
        return ((C1770f) this.instance).d0(i);
    }

    public int getToolCallsCount() {
        return ((C1770f) this.instance).e0();
    }

    public List<C1810h> getToolCallsList() {
        return Collections.unmodifiableList(((C1770f) this.instance).f0());
    }

    public boolean hasMessage() {
        return ((C1770f) this.instance).g0();
    }

    public boolean hasProviderError() {
        return ((C1770f) this.instance).h0();
    }

    public boolean hasTokenUsage() {
        return ((C1770f) this.instance).i0();
    }

    public CompletionResponse$Builder mergeMessage(C1768d c1768d) {
        copyOnWrite();
        C1770f.L((C1770f) this.instance, c1768d);
        return this;
    }

    public CompletionResponse$Builder mergeTokenUsage(y yVar) {
        copyOnWrite();
        C1770f.M((C1770f) this.instance, yVar);
        return this;
    }

    public CompletionResponse$Builder removeToolCalls(int i) {
        copyOnWrite();
        C1770f.N((C1770f) this.instance, i);
        return this;
    }

    public CompletionResponse$Builder setFinishReason(String str) {
        copyOnWrite();
        C1770f.O((C1770f) this.instance, str);
        return this;
    }

    public CompletionResponse$Builder setFinishReasonBytes(ByteString byteString) {
        copyOnWrite();
        C1770f.P((C1770f) this.instance, byteString);
        return this;
    }

    public CompletionResponse$Builder setMessage(C1768d c1768d) {
        copyOnWrite();
        C1770f.Q((C1770f) this.instance, c1768d);
        return this;
    }

    public CompletionResponse$Builder setProviderError(String str) {
        copyOnWrite();
        C1770f.R((C1770f) this.instance, str);
        return this;
    }

    public CompletionResponse$Builder setProviderErrorBytes(ByteString byteString) {
        copyOnWrite();
        C1770f.S((C1770f) this.instance, byteString);
        return this;
    }

    public CompletionResponse$Builder setTokenUsage(y yVar) {
        copyOnWrite();
        C1770f.T((C1770f) this.instance, yVar);
        return this;
    }

    public CompletionResponse$Builder setToolCalls(int i, C1810h c1810h) {
        copyOnWrite();
        C1770f.U((C1770f) this.instance, i, c1810h);
        return this;
    }

    private CompletionResponse$Builder() {
        super(C1770f.DEFAULT_INSTANCE);
    }

    public CompletionResponse$Builder addToolCalls(int i, C1810h c1810h) {
        copyOnWrite();
        C1770f.E((C1770f) this.instance, i, c1810h);
        return this;
    }

    public CompletionResponse$Builder setMessage(ChatMessage$Builder chatMessage$Builder) {
        copyOnWrite();
        C1770f.Q((C1770f) this.instance, (C1768d) chatMessage$Builder.k());
        return this;
    }

    public CompletionResponse$Builder setTokenUsage(TokenUsage$Builder tokenUsage$Builder) {
        copyOnWrite();
        C1770f.T((C1770f) this.instance, (y) tokenUsage$Builder.k());
        return this;
    }

    public CompletionResponse$Builder setToolCalls(int i, FunctionCall$Builder functionCall$Builder) {
        copyOnWrite();
        C1770f.U((C1770f) this.instance, i, (C1810h) functionCall$Builder.k());
        return this;
    }

    public CompletionResponse$Builder addToolCalls(FunctionCall$Builder functionCall$Builder) {
        copyOnWrite();
        C1770f.F((C1770f) this.instance, (C1810h) functionCall$Builder.k());
        return this;
    }

    public CompletionResponse$Builder addToolCalls(int i, FunctionCall$Builder functionCall$Builder) {
        copyOnWrite();
        C1770f.E((C1770f) this.instance, i, (C1810h) functionCall$Builder.k());
        return this;
    }
}
