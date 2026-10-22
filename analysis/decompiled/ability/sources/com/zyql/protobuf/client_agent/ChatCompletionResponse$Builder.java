package com.zyql.protobuf.client_agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import p7.b;

/* loaded from: classes2.dex */
public final class ChatCompletionResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ChatCompletionResponse$Builder(int i) {
        this();
    }

    public ChatCompletionResponse$Builder clearBody() {
        copyOnWrite();
        b.D((b) this.instance);
        return this;
    }

    public ByteString getBody() {
        return ((b) this.instance).G();
    }

    public ChatCompletionResponse$Builder setBody(ByteString byteString) {
        copyOnWrite();
        b.E((b) this.instance, byteString);
        return this;
    }

    private ChatCompletionResponse$Builder() {
        super(b.DEFAULT_INSTANCE);
    }
}
