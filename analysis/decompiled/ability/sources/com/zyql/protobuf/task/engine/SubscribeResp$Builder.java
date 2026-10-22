package com.zyql.protobuf.task.engine;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.d;

/* loaded from: classes2.dex */
public final class SubscribeResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ SubscribeResp$Builder(int i) {
        this();
    }

    public SubscribeResp$Builder clearState() {
        copyOnWrite();
        d.D((d) this.instance);
        return this;
    }

    public InvokeState getState() {
        return ((d) this.instance).H();
    }

    public int getStateValue() {
        return ((d) this.instance).I();
    }

    public SubscribeResp$Builder setState(InvokeState invokeState) {
        copyOnWrite();
        d.E((d) this.instance, invokeState);
        return this;
    }

    public SubscribeResp$Builder setStateValue(int i) {
        copyOnWrite();
        d.F((d) this.instance, i);
        return this;
    }

    private SubscribeResp$Builder() {
        super(d.DEFAULT_INSTANCE);
    }
}
