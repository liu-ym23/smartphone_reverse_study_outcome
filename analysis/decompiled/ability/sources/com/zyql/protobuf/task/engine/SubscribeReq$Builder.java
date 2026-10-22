package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.C2107c;

/* loaded from: classes2.dex */
public final class SubscribeReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ SubscribeReq$Builder(int i) {
        this();
    }

    public SubscribeReq$Builder clearTaskId() {
        copyOnWrite();
        C2107c.D((C2107c) this.instance);
        return this;
    }

    public String getTaskId() {
        return ((C2107c) this.instance).H();
    }

    public ByteString getTaskIdBytes() {
        return ((C2107c) this.instance).I();
    }

    public SubscribeReq$Builder setTaskId(String str) {
        copyOnWrite();
        C2107c.E((C2107c) this.instance, str);
        return this;
    }

    public SubscribeReq$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        C2107c.F((C2107c) this.instance, byteString);
        return this;
    }

    private SubscribeReq$Builder() {
        super(C2107c.DEFAULT_INSTANCE);
    }
}
