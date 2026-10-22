package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.U;

/* loaded from: classes2.dex */
public final class StoreGetResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreGetResponse$Builder(int i) {
        this();
    }

    public StoreGetResponse$Builder clearFound() {
        copyOnWrite();
        U.D((U) this.instance);
        return this;
    }

    public StoreGetResponse$Builder clearTtlSeconds() {
        copyOnWrite();
        U.E((U) this.instance);
        return this;
    }

    public StoreGetResponse$Builder clearUpdatedAt() {
        copyOnWrite();
        U.F((U) this.instance);
        return this;
    }

    public StoreGetResponse$Builder clearValue() {
        copyOnWrite();
        U.G((U) this.instance);
        return this;
    }

    public boolean getFound() {
        return ((U) this.instance).N();
    }

    public long getTtlSeconds() {
        return ((U) this.instance).O();
    }

    public long getUpdatedAt() {
        return ((U) this.instance).P();
    }

    public String getValue() {
        return ((U) this.instance).Q();
    }

    public ByteString getValueBytes() {
        return ((U) this.instance).R();
    }

    public StoreGetResponse$Builder setFound(boolean z10) {
        copyOnWrite();
        U.H((U) this.instance, z10);
        return this;
    }

    public StoreGetResponse$Builder setTtlSeconds(long j5) {
        copyOnWrite();
        U.I((U) this.instance, j5);
        return this;
    }

    public StoreGetResponse$Builder setUpdatedAt(long j5) {
        copyOnWrite();
        U.J((U) this.instance, j5);
        return this;
    }

    public StoreGetResponse$Builder setValue(String str) {
        copyOnWrite();
        U.K((U) this.instance, str);
        return this;
    }

    public StoreGetResponse$Builder setValueBytes(ByteString byteString) {
        copyOnWrite();
        U.L((U) this.instance, byteString);
        return this;
    }

    private StoreGetResponse$Builder() {
        super(U.DEFAULT_INSTANCE);
    }
}
