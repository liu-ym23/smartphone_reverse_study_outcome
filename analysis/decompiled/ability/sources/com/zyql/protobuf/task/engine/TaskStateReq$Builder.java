package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.g;

/* loaded from: classes2.dex */
public final class TaskStateReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskStateReq$Builder(int i) {
        this();
    }

    public TaskStateReq$Builder clearTaskId() {
        copyOnWrite();
        g.D((g) this.instance);
        return this;
    }

    public String getTaskId() {
        return ((g) this.instance).H();
    }

    public ByteString getTaskIdBytes() {
        return ((g) this.instance).I();
    }

    public TaskStateReq$Builder setTaskId(String str) {
        copyOnWrite();
        g.E((g) this.instance, str);
        return this;
    }

    public TaskStateReq$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        g.F((g) this.instance, byteString);
        return this;
    }

    private TaskStateReq$Builder() {
        super(g.DEFAULT_INSTANCE);
    }
}
