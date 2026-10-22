package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.x;

/* loaded from: classes2.dex */
public final class ToolCallResult$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolCallResult$Builder(int i) {
        this();
    }

    public ToolCallResult$Builder clearResult() {
        copyOnWrite();
        x.D((x) this.instance);
        return this;
    }

    public String getResult() {
        return ((x) this.instance).I();
    }

    public ByteString getResultBytes() {
        return ((x) this.instance).J();
    }

    public ToolCallResult$Builder setResult(String str) {
        copyOnWrite();
        x.E((x) this.instance, str);
        return this;
    }

    public ToolCallResult$Builder setResultBytes(ByteString byteString) {
        copyOnWrite();
        x.F((x) this.instance, byteString);
        return this;
    }

    private ToolCallResult$Builder() {
        super(x.DEFAULT_INSTANCE);
    }
}
