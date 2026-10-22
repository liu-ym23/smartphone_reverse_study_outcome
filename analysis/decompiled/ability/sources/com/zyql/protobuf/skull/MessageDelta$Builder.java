package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.j;

/* loaded from: classes2.dex */
public final class MessageDelta$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ MessageDelta$Builder(int i) {
        this();
    }

    public MessageDelta$Builder clearDelta() {
        copyOnWrite();
        j.D((j) this.instance);
        return this;
    }

    public String getDelta() {
        return ((j) this.instance).I();
    }

    public ByteString getDeltaBytes() {
        return ((j) this.instance).J();
    }

    public MessageDelta$Builder setDelta(String str) {
        copyOnWrite();
        j.E((j) this.instance, str);
        return this;
    }

    public MessageDelta$Builder setDeltaBytes(ByteString byteString) {
        copyOnWrite();
        j.F((j) this.instance, byteString);
        return this;
    }

    private MessageDelta$Builder() {
        super(j.DEFAULT_INSTANCE);
    }
}
