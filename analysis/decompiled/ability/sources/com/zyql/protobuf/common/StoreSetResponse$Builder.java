package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.Y;

/* loaded from: classes2.dex */
public final class StoreSetResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreSetResponse$Builder(int i) {
        this();
    }

    public StoreSetResponse$Builder clearPreviousValue() {
        copyOnWrite();
        Y.D((Y) this.instance);
        return this;
    }

    public StoreSetResponse$Builder clearSuccess() {
        copyOnWrite();
        Y.E((Y) this.instance);
        return this;
    }

    public StoreSetResponse$Builder clearUpdated() {
        copyOnWrite();
        Y.F((Y) this.instance);
        return this;
    }

    public String getPreviousValue() {
        return ((Y) this.instance).L();
    }

    public ByteString getPreviousValueBytes() {
        return ((Y) this.instance).M();
    }

    public boolean getSuccess() {
        return ((Y) this.instance).N();
    }

    public boolean getUpdated() {
        return ((Y) this.instance).O();
    }

    public boolean hasPreviousValue() {
        return ((Y) this.instance).P();
    }

    public StoreSetResponse$Builder setPreviousValue(String str) {
        copyOnWrite();
        Y.G((Y) this.instance, str);
        return this;
    }

    public StoreSetResponse$Builder setPreviousValueBytes(ByteString byteString) {
        copyOnWrite();
        Y.H((Y) this.instance, byteString);
        return this;
    }

    public StoreSetResponse$Builder setSuccess(boolean z10) {
        copyOnWrite();
        Y.I((Y) this.instance, z10);
        return this;
    }

    public StoreSetResponse$Builder setUpdated(boolean z10) {
        copyOnWrite();
        Y.J((Y) this.instance, z10);
        return this;
    }

    private StoreSetResponse$Builder() {
        super(Y.DEFAULT_INSTANCE);
    }
}
