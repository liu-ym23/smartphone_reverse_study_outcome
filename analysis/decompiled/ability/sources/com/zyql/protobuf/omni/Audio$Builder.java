package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.C2020c;

/* loaded from: classes2.dex */
public final class Audio$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Audio$Builder(int i) {
        this();
    }

    public Audio$Builder clearData() {
        copyOnWrite();
        C2020c.D((C2020c) this.instance);
        return this;
    }

    public Audio$Builder clearIsEnd() {
        copyOnWrite();
        C2020c.E((C2020c) this.instance);
        return this;
    }

    public ByteString getData() {
        return ((C2020c) this.instance).I();
    }

    public boolean getIsEnd() {
        return ((C2020c) this.instance).K();
    }

    public Audio$Builder setData(ByteString byteString) {
        copyOnWrite();
        C2020c.F((C2020c) this.instance, byteString);
        return this;
    }

    public Audio$Builder setIsEnd(boolean z10) {
        copyOnWrite();
        C2020c.G((C2020c) this.instance, z10);
        return this;
    }

    private Audio$Builder() {
        super(C2020c.DEFAULT_INSTANCE);
    }
}
