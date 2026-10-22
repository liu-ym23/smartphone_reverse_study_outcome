package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import r7.f;
import r7.k;

/* loaded from: classes2.dex */
public final class StreamMsg$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StreamMsg$Builder(int i) {
        this();
    }

    public StreamMsg$Builder clearBody() {
        copyOnWrite();
        k.D((k) this.instance);
        return this;
    }

    public StreamMsg$Builder clearHead() {
        copyOnWrite();
        k.E((k) this.instance);
        return this;
    }

    public ByteString getBody() {
        return ((k) this.instance).J();
    }

    public f getHead() {
        return ((k) this.instance).K();
    }

    public boolean hasHead() {
        return ((k) this.instance).L();
    }

    public StreamMsg$Builder mergeHead(f fVar) {
        copyOnWrite();
        k.F((k) this.instance, fVar);
        return this;
    }

    public StreamMsg$Builder setBody(ByteString byteString) {
        copyOnWrite();
        k.G((k) this.instance, byteString);
        return this;
    }

    public StreamMsg$Builder setHead(f fVar) {
        copyOnWrite();
        k.H((k) this.instance, fVar);
        return this;
    }

    private StreamMsg$Builder() {
        super(k.DEFAULT_INSTANCE);
    }

    public StreamMsg$Builder setHead(Head$Builder head$Builder) {
        copyOnWrite();
        k.H((k) this.instance, (f) head$Builder.k());
        return this;
    }
}
