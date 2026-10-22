package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.N;

/* loaded from: classes2.dex */
public final class StoreClearRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreClearRequest$Builder(int i) {
        this();
    }

    public StoreClearRequest$Builder clearAppId() {
        copyOnWrite();
        N.D((N) this.instance);
        return this;
    }

    public StoreClearRequest$Builder clearPrefix() {
        copyOnWrite();
        N.E((N) this.instance);
        return this;
    }

    public StoreClearRequest$Builder clearScope() {
        copyOnWrite();
        N.F((N) this.instance);
        return this;
    }

    public StoreClearRequest$Builder clearSessionId() {
        copyOnWrite();
        N.G((N) this.instance);
        return this;
    }

    public StoreClearRequest$Builder clearUserId() {
        copyOnWrite();
        N.H((N) this.instance);
        return this;
    }

    public String getAppId() {
        return ((N) this.instance).T();
    }

    public ByteString getAppIdBytes() {
        return ((N) this.instance).U();
    }

    public String getPrefix() {
        return ((N) this.instance).V();
    }

    public ByteString getPrefixBytes() {
        return ((N) this.instance).W();
    }

    public StoreScope getScope() {
        return ((N) this.instance).X();
    }

    public int getScopeValue() {
        return ((N) this.instance).Y();
    }

    public String getSessionId() {
        return ((N) this.instance).Z();
    }

    public ByteString getSessionIdBytes() {
        return ((N) this.instance).a0();
    }

    public String getUserId() {
        return ((N) this.instance).b0();
    }

    public ByteString getUserIdBytes() {
        return ((N) this.instance).c0();
    }

    public StoreClearRequest$Builder setAppId(String str) {
        copyOnWrite();
        N.I((N) this.instance, str);
        return this;
    }

    public StoreClearRequest$Builder setAppIdBytes(ByteString byteString) {
        copyOnWrite();
        N.J((N) this.instance, byteString);
        return this;
    }

    public StoreClearRequest$Builder setPrefix(String str) {
        copyOnWrite();
        N.K((N) this.instance, str);
        return this;
    }

    public StoreClearRequest$Builder setPrefixBytes(ByteString byteString) {
        copyOnWrite();
        N.L((N) this.instance, byteString);
        return this;
    }

    public StoreClearRequest$Builder setScope(StoreScope storeScope) {
        copyOnWrite();
        N.M((N) this.instance, storeScope);
        return this;
    }

    public StoreClearRequest$Builder setScopeValue(int i) {
        copyOnWrite();
        N.N((N) this.instance, i);
        return this;
    }

    public StoreClearRequest$Builder setSessionId(String str) {
        copyOnWrite();
        N.O((N) this.instance, str);
        return this;
    }

    public StoreClearRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        N.P((N) this.instance, byteString);
        return this;
    }

    public StoreClearRequest$Builder setUserId(String str) {
        copyOnWrite();
        N.Q((N) this.instance, str);
        return this;
    }

    public StoreClearRequest$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        N.R((N) this.instance, byteString);
        return this;
    }

    private StoreClearRequest$Builder() {
        super(N.DEFAULT_INSTANCE);
    }
}
