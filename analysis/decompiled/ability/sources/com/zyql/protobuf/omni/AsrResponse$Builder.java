package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.C2019b;

/* loaded from: classes2.dex */
public final class AsrResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AsrResponse$Builder(int i) {
        this();
    }

    public AsrResponse$Builder clearText() {
        copyOnWrite();
        C2019b.D((C2019b) this.instance);
        return this;
    }

    public String getText() {
        return ((C2019b) this.instance).H();
    }

    public ByteString getTextBytes() {
        return ((C2019b) this.instance).I();
    }

    public AsrResponse$Builder setText(String str) {
        copyOnWrite();
        C2019b.E((C2019b) this.instance, str);
        return this;
    }

    public AsrResponse$Builder setTextBytes(ByteString byteString) {
        copyOnWrite();
        C2019b.F((C2019b) this.instance, byteString);
        return this;
    }

    private AsrResponse$Builder() {
        super(C2019b.DEFAULT_INSTANCE);
    }
}
