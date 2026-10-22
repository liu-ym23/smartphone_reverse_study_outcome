package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1807e;

/* loaded from: classes2.dex */
public final class Blob$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Blob$Builder(int i) {
        this();
    }

    public Blob$Builder clearData() {
        copyOnWrite();
        C1807e.D((C1807e) this.instance);
        return this;
    }

    public Blob$Builder clearDisplayName() {
        copyOnWrite();
        C1807e.E((C1807e) this.instance);
        return this;
    }

    public Blob$Builder clearMimeType() {
        copyOnWrite();
        C1807e.F((C1807e) this.instance);
        return this;
    }

    public ByteString getData() {
        return ((C1807e) this.instance).M();
    }

    public String getDisplayName() {
        return ((C1807e) this.instance).O();
    }

    public ByteString getDisplayNameBytes() {
        return ((C1807e) this.instance).P();
    }

    public String getMimeType() {
        return ((C1807e) this.instance).Q();
    }

    public ByteString getMimeTypeBytes() {
        return ((C1807e) this.instance).R();
    }

    public Blob$Builder setData(ByteString byteString) {
        copyOnWrite();
        C1807e.G((C1807e) this.instance, byteString);
        return this;
    }

    public Blob$Builder setDisplayName(String str) {
        copyOnWrite();
        C1807e.H((C1807e) this.instance, str);
        return this;
    }

    public Blob$Builder setDisplayNameBytes(ByteString byteString) {
        copyOnWrite();
        C1807e.I((C1807e) this.instance, byteString);
        return this;
    }

    public Blob$Builder setMimeType(String str) {
        copyOnWrite();
        C1807e.J((C1807e) this.instance, str);
        return this;
    }

    public Blob$Builder setMimeTypeBytes(ByteString byteString) {
        copyOnWrite();
        C1807e.K((C1807e) this.instance, byteString);
        return this;
    }

    private Blob$Builder() {
        super(C1807e.DEFAULT_INSTANCE);
    }
}
