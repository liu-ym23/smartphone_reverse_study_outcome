package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.s;

/* loaded from: classes2.dex */
public final class TaskError$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskError$Builder(int i) {
        this();
    }

    public TaskError$Builder clearCode() {
        copyOnWrite();
        s.D((s) this.instance);
        return this;
    }

    public TaskError$Builder clearMessage() {
        copyOnWrite();
        s.E((s) this.instance);
        return this;
    }

    public int getCode() {
        return ((s) this.instance).J();
    }

    public String getMessage() {
        return ((s) this.instance).L();
    }

    public ByteString getMessageBytes() {
        return ((s) this.instance).M();
    }

    public TaskError$Builder setCode(int i) {
        copyOnWrite();
        s.F((s) this.instance, i);
        return this;
    }

    public TaskError$Builder setMessage(String str) {
        copyOnWrite();
        s.G((s) this.instance, str);
        return this;
    }

    public TaskError$Builder setMessageBytes(ByteString byteString) {
        copyOnWrite();
        s.H((s) this.instance, byteString);
        return this;
    }

    private TaskError$Builder() {
        super(s.DEFAULT_INSTANCE);
    }
}
