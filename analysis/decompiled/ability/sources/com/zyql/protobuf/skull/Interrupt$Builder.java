package com.zyql.protobuf.skull;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.g;
import v7.i;

/* loaded from: classes2.dex */
public final class Interrupt$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Interrupt$Builder(int i) {
        this();
    }

    public Interrupt$Builder clearMessage() {
        copyOnWrite();
        g.D((g) this.instance);
        return this;
    }

    public i getMessage() {
        return ((g) this.instance).I();
    }

    public boolean hasMessage() {
        return ((g) this.instance).J();
    }

    public Interrupt$Builder mergeMessage(i iVar) {
        copyOnWrite();
        g.E((g) this.instance, iVar);
        return this;
    }

    public Interrupt$Builder setMessage(i iVar) {
        copyOnWrite();
        g.F((g) this.instance, iVar);
        return this;
    }

    private Interrupt$Builder() {
        super(g.DEFAULT_INSTANCE);
    }

    public Interrupt$Builder setMessage(Message$Builder message$Builder) {
        copyOnWrite();
        g.F((g) this.instance, (i) message$Builder.k());
        return this;
    }
}
