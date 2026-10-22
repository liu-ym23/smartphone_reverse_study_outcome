package com.zyql.protobuf.task.engine;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.f;

/* loaded from: classes2.dex */
public final class TaskDealResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskDealResp$Builder(int i) {
        this();
    }

    public TaskDealResp$Builder clearState() {
        copyOnWrite();
        f.D((f) this.instance);
        return this;
    }

    public InvokeState getState() {
        return ((f) this.instance).H();
    }

    public int getStateValue() {
        return ((f) this.instance).I();
    }

    public TaskDealResp$Builder setState(InvokeState invokeState) {
        copyOnWrite();
        f.E((f) this.instance, invokeState);
        return this;
    }

    public TaskDealResp$Builder setStateValue(int i) {
        copyOnWrite();
        f.F((f) this.instance, i);
        return this;
    }

    private TaskDealResp$Builder() {
        super(f.DEFAULT_INSTANCE);
    }
}
