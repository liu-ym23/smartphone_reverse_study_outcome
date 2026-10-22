package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.C2021d;

/* loaded from: classes2.dex */
public final class CancelTaskRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ CancelTaskRequest$Builder(int i) {
        this();
    }

    public CancelTaskRequest$Builder clearTaskId() {
        copyOnWrite();
        C2021d.D((C2021d) this.instance);
        return this;
    }

    public String getTaskId() {
        return ((C2021d) this.instance).H();
    }

    public ByteString getTaskIdBytes() {
        return ((C2021d) this.instance).I();
    }

    public CancelTaskRequest$Builder setTaskId(String str) {
        copyOnWrite();
        C2021d.E((C2021d) this.instance, str);
        return this;
    }

    public CancelTaskRequest$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        C2021d.F((C2021d) this.instance, byteString);
        return this;
    }

    private CancelTaskRequest$Builder() {
        super(C2021d.DEFAULT_INSTANCE);
    }
}
