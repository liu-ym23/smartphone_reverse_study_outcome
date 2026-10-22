package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1809g;

/* loaded from: classes2.dex */
public final class FileData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ FileData$Builder(int i) {
        this();
    }

    public FileData$Builder clearDisplayName() {
        copyOnWrite();
        C1809g.D((C1809g) this.instance);
        return this;
    }

    public FileData$Builder clearMimeType() {
        copyOnWrite();
        C1809g.E((C1809g) this.instance);
        return this;
    }

    public FileData$Builder clearUri() {
        copyOnWrite();
        C1809g.F((C1809g) this.instance);
        return this;
    }

    public String getDisplayName() {
        return ((C1809g) this.instance).O();
    }

    public ByteString getDisplayNameBytes() {
        return ((C1809g) this.instance).P();
    }

    public String getMimeType() {
        return ((C1809g) this.instance).Q();
    }

    public ByteString getMimeTypeBytes() {
        return ((C1809g) this.instance).R();
    }

    public String getUri() {
        return ((C1809g) this.instance).S();
    }

    public ByteString getUriBytes() {
        return ((C1809g) this.instance).T();
    }

    public FileData$Builder setDisplayName(String str) {
        copyOnWrite();
        C1809g.G((C1809g) this.instance, str);
        return this;
    }

    public FileData$Builder setDisplayNameBytes(ByteString byteString) {
        copyOnWrite();
        C1809g.H((C1809g) this.instance, byteString);
        return this;
    }

    public FileData$Builder setMimeType(String str) {
        copyOnWrite();
        C1809g.I((C1809g) this.instance, str);
        return this;
    }

    public FileData$Builder setMimeTypeBytes(ByteString byteString) {
        copyOnWrite();
        C1809g.J((C1809g) this.instance, byteString);
        return this;
    }

    public FileData$Builder setUri(String str) {
        copyOnWrite();
        C1809g.K((C1809g) this.instance, str);
        return this;
    }

    public FileData$Builder setUriBytes(ByteString byteString) {
        copyOnWrite();
        C1809g.L((C1809g) this.instance, byteString);
        return this;
    }

    private FileData$Builder() {
        super(C1809g.DEFAULT_INSTANCE);
    }
}
