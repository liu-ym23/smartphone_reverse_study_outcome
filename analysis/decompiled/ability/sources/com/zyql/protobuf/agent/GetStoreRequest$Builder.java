package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.n;

/* loaded from: classes2.dex */
public final class GetStoreRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ GetStoreRequest$Builder(int i) {
        this();
    }

    public GetStoreRequest$Builder clearKey() {
        copyOnWrite();
        n.D((n) this.instance);
        return this;
    }

    public GetStoreRequest$Builder clearStoreId() {
        copyOnWrite();
        n.E((n) this.instance);
        return this;
    }

    public String getKey() {
        return ((n) this.instance).L();
    }

    public ByteString getKeyBytes() {
        return ((n) this.instance).M();
    }

    public String getStoreId() {
        return ((n) this.instance).N();
    }

    public ByteString getStoreIdBytes() {
        return ((n) this.instance).O();
    }

    public GetStoreRequest$Builder setKey(String str) {
        copyOnWrite();
        n.F((n) this.instance, str);
        return this;
    }

    public GetStoreRequest$Builder setKeyBytes(ByteString byteString) {
        copyOnWrite();
        n.G((n) this.instance, byteString);
        return this;
    }

    public GetStoreRequest$Builder setStoreId(String str) {
        copyOnWrite();
        n.H((n) this.instance, str);
        return this;
    }

    public GetStoreRequest$Builder setStoreIdBytes(ByteString byteString) {
        copyOnWrite();
        n.I((n) this.instance, byteString);
        return this;
    }

    private GetStoreRequest$Builder() {
        super(n.DEFAULT_INSTANCE);
    }
}
