package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.P;

/* loaded from: classes2.dex */
public final class StoreDeleteRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreDeleteRequest$Builder(int i) {
        this();
    }

    public StoreDeleteRequest$Builder clearAppId() {
        copyOnWrite();
        P.D((P) this.instance);
        return this;
    }

    public StoreDeleteRequest$Builder clearKey() {
        copyOnWrite();
        P.E((P) this.instance);
        return this;
    }

    public StoreDeleteRequest$Builder clearScope() {
        copyOnWrite();
        P.F((P) this.instance);
        return this;
    }

    public StoreDeleteRequest$Builder clearSessionId() {
        copyOnWrite();
        P.G((P) this.instance);
        return this;
    }

    public StoreDeleteRequest$Builder clearUserId() {
        copyOnWrite();
        P.H((P) this.instance);
        return this;
    }

    public String getAppId() {
        return ((P) this.instance).T();
    }

    public ByteString getAppIdBytes() {
        return ((P) this.instance).U();
    }

    public String getKey() {
        return ((P) this.instance).V();
    }

    public ByteString getKeyBytes() {
        return ((P) this.instance).W();
    }

    public StoreScope getScope() {
        return ((P) this.instance).X();
    }

    public int getScopeValue() {
        return ((P) this.instance).Y();
    }

    public String getSessionId() {
        return ((P) this.instance).Z();
    }

    public ByteString getSessionIdBytes() {
        return ((P) this.instance).a0();
    }

    public String getUserId() {
        return ((P) this.instance).b0();
    }

    public ByteString getUserIdBytes() {
        return ((P) this.instance).c0();
    }

    public StoreDeleteRequest$Builder setAppId(String str) {
        copyOnWrite();
        P.I((P) this.instance, str);
        return this;
    }

    public StoreDeleteRequest$Builder setAppIdBytes(ByteString byteString) {
        copyOnWrite();
        P.J((P) this.instance, byteString);
        return this;
    }

    public StoreDeleteRequest$Builder setKey(String str) {
        copyOnWrite();
        P.K((P) this.instance, str);
        return this;
    }

    public StoreDeleteRequest$Builder setKeyBytes(ByteString byteString) {
        copyOnWrite();
        P.L((P) this.instance, byteString);
        return this;
    }

    public StoreDeleteRequest$Builder setScope(StoreScope storeScope) {
        copyOnWrite();
        P.M((P) this.instance, storeScope);
        return this;
    }

    public StoreDeleteRequest$Builder setScopeValue(int i) {
        copyOnWrite();
        P.N((P) this.instance, i);
        return this;
    }

    public StoreDeleteRequest$Builder setSessionId(String str) {
        copyOnWrite();
        P.O((P) this.instance, str);
        return this;
    }

    public StoreDeleteRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        P.P((P) this.instance, byteString);
        return this;
    }

    public StoreDeleteRequest$Builder setUserId(String str) {
        copyOnWrite();
        P.Q((P) this.instance, str);
        return this;
    }

    public StoreDeleteRequest$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        P.R((P) this.instance, byteString);
        return this;
    }

    private StoreDeleteRequest$Builder() {
        super(P.DEFAULT_INSTANCE);
    }
}
