package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.o;

/* loaded from: classes2.dex */
public final class GetStoreResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ GetStoreResponse$Builder(int i) {
        this();
    }

    public GetStoreResponse$Builder clearError() {
        copyOnWrite();
        o.D((o) this.instance);
        return this;
    }

    public GetStoreResponse$Builder clearKey() {
        copyOnWrite();
        o.E((o) this.instance);
        return this;
    }

    public GetStoreResponse$Builder clearStoreId() {
        copyOnWrite();
        o.F((o) this.instance);
        return this;
    }

    public GetStoreResponse$Builder clearSuccess() {
        copyOnWrite();
        o.G((o) this.instance);
        return this;
    }

    public GetStoreResponse$Builder clearValue() {
        copyOnWrite();
        o.H((o) this.instance);
        return this;
    }

    public String getError() {
        return ((o) this.instance).S();
    }

    public ByteString getErrorBytes() {
        return ((o) this.instance).T();
    }

    public String getKey() {
        return ((o) this.instance).U();
    }

    public ByteString getKeyBytes() {
        return ((o) this.instance).V();
    }

    public String getStoreId() {
        return ((o) this.instance).W();
    }

    public ByteString getStoreIdBytes() {
        return ((o) this.instance).X();
    }

    public boolean getSuccess() {
        return ((o) this.instance).Y();
    }

    public ByteString getValue() {
        return ((o) this.instance).Z();
    }

    public GetStoreResponse$Builder setError(String str) {
        copyOnWrite();
        o.I((o) this.instance, str);
        return this;
    }

    public GetStoreResponse$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        o.J((o) this.instance, byteString);
        return this;
    }

    public GetStoreResponse$Builder setKey(String str) {
        copyOnWrite();
        o.K((o) this.instance, str);
        return this;
    }

    public GetStoreResponse$Builder setKeyBytes(ByteString byteString) {
        copyOnWrite();
        o.L((o) this.instance, byteString);
        return this;
    }

    public GetStoreResponse$Builder setStoreId(String str) {
        copyOnWrite();
        o.M((o) this.instance, str);
        return this;
    }

    public GetStoreResponse$Builder setStoreIdBytes(ByteString byteString) {
        copyOnWrite();
        o.N((o) this.instance, byteString);
        return this;
    }

    public GetStoreResponse$Builder setSuccess(boolean z10) {
        copyOnWrite();
        o.O((o) this.instance, z10);
        return this;
    }

    public GetStoreResponse$Builder setValue(ByteString byteString) {
        copyOnWrite();
        o.P((o) this.instance, byteString);
        return this;
    }

    private GetStoreResponse$Builder() {
        super(o.DEFAULT_INSTANCE);
    }
}
