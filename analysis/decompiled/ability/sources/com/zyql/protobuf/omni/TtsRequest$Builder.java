package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.l;

/* loaded from: classes2.dex */
public final class TtsRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TtsRequest$Builder(int i) {
        this();
    }

    public TtsRequest$Builder clearText() {
        copyOnWrite();
        l.D((l) this.instance);
        return this;
    }

    public String getText() {
        return ((l) this.instance).H();
    }

    public ByteString getTextBytes() {
        return ((l) this.instance).I();
    }

    public TtsRequest$Builder setText(String str) {
        copyOnWrite();
        l.E((l) this.instance, str);
        return this;
    }

    public TtsRequest$Builder setTextBytes(ByteString byteString) {
        copyOnWrite();
        l.F((l) this.instance, byteString);
        return this;
    }

    private TtsRequest$Builder() {
        super(l.DEFAULT_INSTANCE);
    }
}
