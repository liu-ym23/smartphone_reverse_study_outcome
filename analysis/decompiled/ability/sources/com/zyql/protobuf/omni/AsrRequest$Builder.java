package com.zyql.protobuf.omni;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.C2018a;
import t7.C2020c;

/* loaded from: classes2.dex */
public final class AsrRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AsrRequest$Builder(int i) {
        this();
    }

    public AsrRequest$Builder clearAudio() {
        copyOnWrite();
        C2018a.D((C2018a) this.instance);
        return this;
    }

    public C2020c getAudio() {
        return ((C2018a) this.instance).H();
    }

    public boolean hasAudio() {
        return ((C2018a) this.instance).I();
    }

    public AsrRequest$Builder mergeAudio(C2020c c2020c) {
        copyOnWrite();
        C2018a.E((C2018a) this.instance, c2020c);
        return this;
    }

    public AsrRequest$Builder setAudio(C2020c c2020c) {
        copyOnWrite();
        C2018a.F((C2018a) this.instance, c2020c);
        return this;
    }

    private AsrRequest$Builder() {
        super(C2018a.DEFAULT_INSTANCE);
    }

    public AsrRequest$Builder setAudio(Audio$Builder audio$Builder) {
        copyOnWrite();
        C2018a.F((C2018a) this.instance, (C2020c) audio$Builder.k());
        return this;
    }
}
