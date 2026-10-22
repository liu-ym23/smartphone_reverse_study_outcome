package com.zyql.protobuf.task.engine;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.h;

/* loaded from: classes2.dex */
public final class TaskStateResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskStateResp$Builder(int i) {
        this();
    }

    public TaskStateResp$Builder clearState() {
        copyOnWrite();
        h.D((h) this.instance);
        return this;
    }

    public TaskState getState() {
        return ((h) this.instance).H();
    }

    public int getStateValue() {
        return ((h) this.instance).I();
    }

    public TaskStateResp$Builder setState(TaskState taskState) {
        copyOnWrite();
        h.E((h) this.instance, taskState);
        return this;
    }

    public TaskStateResp$Builder setStateValue(int i) {
        copyOnWrite();
        h.F((h) this.instance, i);
        return this;
    }

    private TaskStateResp$Builder() {
        super(h.DEFAULT_INSTANCE);
    }
}
