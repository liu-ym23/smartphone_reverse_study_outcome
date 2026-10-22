package com.zyql.protobuf.skull;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.i;
import v7.q;
import v7.r;

/* loaded from: classes2.dex */
public final class TaskInput$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskInput$Builder(int i) {
        this();
    }

    public TaskInput$Builder clearContext() {
        copyOnWrite();
        r.D((r) this.instance);
        return this;
    }

    public TaskInput$Builder clearMessage() {
        copyOnWrite();
        r.E((r) this.instance);
        return this;
    }

    public q getContext() {
        return ((r) this.instance).K();
    }

    public i getMessage() {
        return ((r) this.instance).M();
    }

    public boolean hasContext() {
        return ((r) this.instance).N();
    }

    public boolean hasMessage() {
        return ((r) this.instance).O();
    }

    public TaskInput$Builder mergeContext(q qVar) {
        copyOnWrite();
        r.F((r) this.instance, qVar);
        return this;
    }

    public TaskInput$Builder mergeMessage(i iVar) {
        copyOnWrite();
        r.G((r) this.instance, iVar);
        return this;
    }

    public TaskInput$Builder setContext(q qVar) {
        copyOnWrite();
        r.H((r) this.instance, qVar);
        return this;
    }

    public TaskInput$Builder setMessage(i iVar) {
        copyOnWrite();
        r.I((r) this.instance, iVar);
        return this;
    }

    private TaskInput$Builder() {
        super(r.DEFAULT_INSTANCE);
    }

    public TaskInput$Builder setContext(TaskContext$Builder taskContext$Builder) {
        copyOnWrite();
        r.H((r) this.instance, (q) taskContext$Builder.k());
        return this;
    }

    public TaskInput$Builder setMessage(Message$Builder message$Builder) {
        copyOnWrite();
        r.I((r) this.instance, (i) message$Builder.k());
        return this;
    }
}
