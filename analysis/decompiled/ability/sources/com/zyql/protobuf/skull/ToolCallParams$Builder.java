package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.w;

/* loaded from: classes2.dex */
public final class ToolCallParams$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolCallParams$Builder(int i) {
        this();
    }

    public ToolCallParams$Builder clearParams() {
        copyOnWrite();
        w.D((w) this.instance);
        return this;
    }

    public String getParams() {
        return ((w) this.instance).I();
    }

    public ByteString getParamsBytes() {
        return ((w) this.instance).J();
    }

    public ToolCallParams$Builder setParams(String str) {
        copyOnWrite();
        w.E((w) this.instance, str);
        return this;
    }

    public ToolCallParams$Builder setParamsBytes(ByteString byteString) {
        copyOnWrite();
        w.F((w) this.instance, byteString);
        return this;
    }

    private ToolCallParams$Builder() {
        super(w.DEFAULT_INSTANCE);
    }
}
