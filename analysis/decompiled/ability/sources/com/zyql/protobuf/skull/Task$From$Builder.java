package com.zyql.protobuf.skull;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.C2062a;
import v7.m;
import v7.y;

/* loaded from: classes2.dex */
public final class Task$From$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Task$From$Builder(int i) {
        this();
    }

    public Task$From$Builder clearAgent() {
        copyOnWrite();
        m.D((m) this.instance);
        return this;
    }

    public Task$From$Builder clearUser() {
        copyOnWrite();
        m.E((m) this.instance);
        return this;
    }

    public C2062a getAgent() {
        return ((m) this.instance).K();
    }

    public y getUser() {
        return ((m) this.instance).L();
    }

    public boolean hasAgent() {
        return ((m) this.instance).M();
    }

    public boolean hasUser() {
        return ((m) this.instance).N();
    }

    public Task$From$Builder mergeAgent(C2062a c2062a) {
        copyOnWrite();
        m.F((m) this.instance, c2062a);
        return this;
    }

    public Task$From$Builder mergeUser(y yVar) {
        copyOnWrite();
        m.G((m) this.instance, yVar);
        return this;
    }

    public Task$From$Builder setAgent(C2062a c2062a) {
        copyOnWrite();
        m.H((m) this.instance, c2062a);
        return this;
    }

    public Task$From$Builder setUser(y yVar) {
        copyOnWrite();
        m.I((m) this.instance, yVar);
        return this;
    }

    private Task$From$Builder() {
        super(m.DEFAULT_INSTANCE);
    }

    public Task$From$Builder setAgent(Agent$Builder agent$Builder) {
        copyOnWrite();
        m.H((m) this.instance, (C2062a) agent$Builder.k());
        return this;
    }

    public Task$From$Builder setUser(User$Builder user$Builder) {
        copyOnWrite();
        m.I((m) this.instance, (y) user$Builder.k());
        return this;
    }
}
