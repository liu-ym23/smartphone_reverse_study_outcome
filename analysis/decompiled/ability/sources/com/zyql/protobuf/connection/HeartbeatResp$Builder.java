package com.zyql.protobuf.connection;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import r7.h;

/* loaded from: classes2.dex */
public final class HeartbeatResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HeartbeatResp$Builder(int i) {
        this();
    }

    public HeartbeatResp$Builder clearInterval() {
        copyOnWrite();
        h.D((h) this.instance);
        return this;
    }

    public int getInterval() {
        return ((h) this.instance).G();
    }

    public HeartbeatResp$Builder setInterval(int i) {
        copyOnWrite();
        h.E((h) this.instance, i);
        return this;
    }

    private HeartbeatResp$Builder() {
        super(h.DEFAULT_INSTANCE);
    }
}
