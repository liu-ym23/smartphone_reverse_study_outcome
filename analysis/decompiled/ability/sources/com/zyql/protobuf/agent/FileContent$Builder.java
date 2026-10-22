package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.k;

/* loaded from: classes2.dex */
public final class FileContent$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ FileContent$Builder(int i) {
        this();
    }

    public FileContent$Builder clearContent() {
        copyOnWrite();
        k.D((k) this.instance);
        return this;
    }

    public FileContent$Builder clearPath() {
        copyOnWrite();
        k.E((k) this.instance);
        return this;
    }

    public ByteString getContent() {
        return ((k) this.instance).J();
    }

    public String getPath() {
        return ((k) this.instance).K();
    }

    public ByteString getPathBytes() {
        return ((k) this.instance).L();
    }

    public FileContent$Builder setContent(ByteString byteString) {
        copyOnWrite();
        k.F((k) this.instance, byteString);
        return this;
    }

    public FileContent$Builder setPath(String str) {
        copyOnWrite();
        k.G((k) this.instance, str);
        return this;
    }

    public FileContent$Builder setPathBytes(ByteString byteString) {
        copyOnWrite();
        k.H((k) this.instance, byteString);
        return this;
    }

    private FileContent$Builder() {
        super(k.DEFAULT_INSTANCE);
    }
}
