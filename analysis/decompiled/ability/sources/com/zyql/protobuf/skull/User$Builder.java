package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.y;

/* loaded from: classes2.dex */
public final class User$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ User$Builder(int i) {
        this();
    }

    public User$Builder clearUserId() {
        copyOnWrite();
        y.D((y) this.instance);
        return this;
    }

    public String getUserId() {
        return ((y) this.instance).I();
    }

    public ByteString getUserIdBytes() {
        return ((y) this.instance).J();
    }

    public User$Builder setUserId(String str) {
        copyOnWrite();
        y.E((y) this.instance, str);
        return this;
    }

    public User$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        y.F((y) this.instance, byteString);
        return this;
    }

    private User$Builder() {
        super(y.DEFAULT_INSTANCE);
    }
}
