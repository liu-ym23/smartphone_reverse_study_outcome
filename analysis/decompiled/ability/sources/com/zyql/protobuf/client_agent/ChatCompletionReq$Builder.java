package com.zyql.protobuf.client_agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import p7.a;

/* loaded from: classes2.dex */
public final class ChatCompletionReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ChatCompletionReq$Builder(int i) {
        this();
    }

    public ChatCompletionReq$Builder clearBody() {
        copyOnWrite();
        a.D((a) this.instance);
        return this;
    }

    public ByteString getBody() {
        return ((a) this.instance).G();
    }

    public ChatCompletionReq$Builder setBody(ByteString byteString) {
        copyOnWrite();
        a.E((a) this.instance, byteString);
        return this;
    }

    private ChatCompletionReq$Builder() {
        super(a.DEFAULT_INSTANCE);
    }
}
