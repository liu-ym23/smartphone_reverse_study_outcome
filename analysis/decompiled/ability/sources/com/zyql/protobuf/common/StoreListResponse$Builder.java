package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import q7.W;

/* loaded from: classes2.dex */
public final class StoreListResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreListResponse$Builder(int i) {
        this();
    }

    public StoreListResponse$Builder addAllKeys(Iterable<String> iterable) {
        copyOnWrite();
        W.D((W) this.instance, iterable);
        return this;
    }

    public StoreListResponse$Builder addKeys(String str) {
        copyOnWrite();
        W.E((W) this.instance, str);
        return this;
    }

    public StoreListResponse$Builder addKeysBytes(ByteString byteString) {
        copyOnWrite();
        W.F((W) this.instance, byteString);
        return this;
    }

    public StoreListResponse$Builder clearKeys() {
        copyOnWrite();
        W.G((W) this.instance);
        return this;
    }

    public StoreListResponse$Builder clearNextCursor() {
        copyOnWrite();
        W.H((W) this.instance);
        return this;
    }

    public String getKeys(int i) {
        return ((W) this.instance).N(i);
    }

    public ByteString getKeysBytes(int i) {
        return ((W) this.instance).O(i);
    }

    public int getKeysCount() {
        return ((W) this.instance).P();
    }

    public List<String> getKeysList() {
        return Collections.unmodifiableList(((W) this.instance).Q());
    }

    public String getNextCursor() {
        return ((W) this.instance).R();
    }

    public ByteString getNextCursorBytes() {
        return ((W) this.instance).S();
    }

    public StoreListResponse$Builder setKeys(int i, String str) {
        copyOnWrite();
        W.I((W) this.instance, i, str);
        return this;
    }

    public StoreListResponse$Builder setNextCursor(String str) {
        copyOnWrite();
        W.J((W) this.instance, str);
        return this;
    }

    public StoreListResponse$Builder setNextCursorBytes(ByteString byteString) {
        copyOnWrite();
        W.K((W) this.instance, byteString);
        return this;
    }

    private StoreListResponse$Builder() {
        super(W.DEFAULT_INSTANCE);
    }
}
