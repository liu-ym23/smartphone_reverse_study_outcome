package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.Q;

/* loaded from: classes2.dex */
public final class StoreDeleteResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreDeleteResponse$Builder(int i) {
        this();
    }

    public StoreDeleteResponse$Builder clearDeleted() {
        copyOnWrite();
        Q.D((Q) this.instance);
        return this;
    }

    public StoreDeleteResponse$Builder clearPreviousValue() {
        copyOnWrite();
        Q.E((Q) this.instance);
        return this;
    }

    public boolean getDeleted() {
        return ((Q) this.instance).J();
    }

    public String getPreviousValue() {
        return ((Q) this.instance).K();
    }

    public ByteString getPreviousValueBytes() {
        return ((Q) this.instance).L();
    }

    public boolean hasPreviousValue() {
        return ((Q) this.instance).M();
    }

    public StoreDeleteResponse$Builder setDeleted(boolean z10) {
        copyOnWrite();
        Q.F((Q) this.instance, z10);
        return this;
    }

    public StoreDeleteResponse$Builder setPreviousValue(String str) {
        copyOnWrite();
        Q.G((Q) this.instance, str);
        return this;
    }

    public StoreDeleteResponse$Builder setPreviousValueBytes(ByteString byteString) {
        copyOnWrite();
        Q.H((Q) this.instance, byteString);
        return this;
    }

    private StoreDeleteResponse$Builder() {
        super(Q.DEFAULT_INSTANCE);
    }
}
