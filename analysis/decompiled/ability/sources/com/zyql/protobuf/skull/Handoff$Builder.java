package com.zyql.protobuf.skull;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.f;
import v7.o;

/* loaded from: classes2.dex */
public final class Handoff$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Handoff$Builder(int i) {
        this();
    }

    public Handoff$Builder clearTask() {
        copyOnWrite();
        f.D((f) this.instance);
        return this;
    }

    public o getTask() {
        return ((f) this.instance).I();
    }

    public boolean hasTask() {
        return ((f) this.instance).J();
    }

    public Handoff$Builder mergeTask(o oVar) {
        copyOnWrite();
        f.E((f) this.instance, oVar);
        return this;
    }

    public Handoff$Builder setTask(o oVar) {
        copyOnWrite();
        f.F((f) this.instance, oVar);
        return this;
    }

    private Handoff$Builder() {
        super(f.DEFAULT_INSTANCE);
    }

    public Handoff$Builder setTask(Task$Builder task$Builder) {
        copyOnWrite();
        f.F((f) this.instance, (o) task$Builder.k());
        return this;
    }
}
