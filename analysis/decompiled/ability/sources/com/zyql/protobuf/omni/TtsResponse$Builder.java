package com.zyql.protobuf.omni;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.C2020c;
import t7.m;

/* loaded from: classes2.dex */
public final class TtsResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TtsResponse$Builder(int i) {
        this();
    }

    public TtsResponse$Builder clearAudio() {
        copyOnWrite();
        m.D((m) this.instance);
        return this;
    }

    public C2020c getAudio() {
        return ((m) this.instance).H();
    }

    public boolean hasAudio() {
        return ((m) this.instance).I();
    }

    public TtsResponse$Builder mergeAudio(C2020c c2020c) {
        copyOnWrite();
        m.E((m) this.instance, c2020c);
        return this;
    }

    public TtsResponse$Builder setAudio(C2020c c2020c) {
        copyOnWrite();
        m.F((m) this.instance, c2020c);
        return this;
    }

    private TtsResponse$Builder() {
        super(m.DEFAULT_INSTANCE);
    }

    public TtsResponse$Builder setAudio(Audio$Builder audio$Builder) {
        copyOnWrite();
        m.F((m) this.instance, (C2020c) audio$Builder.k());
        return this;
    }
}
