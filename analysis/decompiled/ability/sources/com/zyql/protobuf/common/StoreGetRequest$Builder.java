package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.T;

/* loaded from: classes2.dex */
public final class StoreGetRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreGetRequest$Builder(int i) {
        this();
    }

    public StoreGetRequest$Builder clearAppId() {
        copyOnWrite();
        T.D((T) this.instance);
        return this;
    }

    public StoreGetRequest$Builder clearDefaultValue() {
        copyOnWrite();
        T.E((T) this.instance);
        return this;
    }

    public StoreGetRequest$Builder clearKey() {
        copyOnWrite();
        T.F((T) this.instance);
        return this;
    }

    public StoreGetRequest$Builder clearScope() {
        copyOnWrite();
        T.G((T) this.instance);
        return this;
    }

    public StoreGetRequest$Builder clearSessionId() {
        copyOnWrite();
        T.H((T) this.instance);
        return this;
    }

    public StoreGetRequest$Builder clearUserId() {
        copyOnWrite();
        T.I((T) this.instance);
        return this;
    }

    public String getAppId() {
        return ((T) this.instance).W();
    }

    public ByteString getAppIdBytes() {
        return ((T) this.instance).X();
    }

    public String getDefaultValue() {
        return ((T) this.instance).Y();
    }

    public ByteString getDefaultValueBytes() {
        return ((T) this.instance).Z();
    }

    public String getKey() {
        return ((T) this.instance).a0();
    }

    public ByteString getKeyBytes() {
        return ((T) this.instance).b0();
    }

    public StoreScope getScope() {
        return ((T) this.instance).c0();
    }

    public int getScopeValue() {
        return ((T) this.instance).d0();
    }

    public String getSessionId() {
        return ((T) this.instance).e0();
    }

    public ByteString getSessionIdBytes() {
        return ((T) this.instance).f0();
    }

    public String getUserId() {
        return ((T) this.instance).g0();
    }

    public ByteString getUserIdBytes() {
        return ((T) this.instance).h0();
    }

    public boolean hasDefaultValue() {
        return ((T) this.instance).i0();
    }

    public StoreGetRequest$Builder setAppId(String str) {
        copyOnWrite();
        T.J((T) this.instance, str);
        return this;
    }

    public StoreGetRequest$Builder setAppIdBytes(ByteString byteString) {
        copyOnWrite();
        T.K((T) this.instance, byteString);
        return this;
    }

    public StoreGetRequest$Builder setDefaultValue(String str) {
        copyOnWrite();
        T.L((T) this.instance, str);
        return this;
    }

    public StoreGetRequest$Builder setDefaultValueBytes(ByteString byteString) {
        copyOnWrite();
        T.M((T) this.instance, byteString);
        return this;
    }

    public StoreGetRequest$Builder setKey(String str) {
        copyOnWrite();
        T.N((T) this.instance, str);
        return this;
    }

    public StoreGetRequest$Builder setKeyBytes(ByteString byteString) {
        copyOnWrite();
        T.O((T) this.instance, byteString);
        return this;
    }

    public StoreGetRequest$Builder setScope(StoreScope storeScope) {
        copyOnWrite();
        T.P((T) this.instance, storeScope);
        return this;
    }

    public StoreGetRequest$Builder setScopeValue(int i) {
        copyOnWrite();
        T.Q((T) this.instance, i);
        return this;
    }

    public StoreGetRequest$Builder setSessionId(String str) {
        copyOnWrite();
        T.R((T) this.instance, str);
        return this;
    }

    public StoreGetRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        T.S((T) this.instance, byteString);
        return this;
    }

    public StoreGetRequest$Builder setUserId(String str) {
        copyOnWrite();
        T.T((T) this.instance, str);
        return this;
    }

    public StoreGetRequest$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        T.U((T) this.instance, byteString);
        return this;
    }

    private StoreGetRequest$Builder() {
        super(T.DEFAULT_INSTANCE);
    }
}
