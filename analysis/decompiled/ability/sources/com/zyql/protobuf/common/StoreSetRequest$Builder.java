package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.X;

/* loaded from: classes2.dex */
public final class StoreSetRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreSetRequest$Builder(int i) {
        this();
    }

    public StoreSetRequest$Builder clearAppId() {
        copyOnWrite();
        X.D((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearIfExists() {
        copyOnWrite();
        X.E((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearIfNotExists() {
        copyOnWrite();
        X.F((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearKey() {
        copyOnWrite();
        X.G((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearScope() {
        copyOnWrite();
        X.H((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearSessionId() {
        copyOnWrite();
        X.I((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearTtlSeconds() {
        copyOnWrite();
        X.J((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearUserId() {
        copyOnWrite();
        X.K((X) this.instance);
        return this;
    }

    public StoreSetRequest$Builder clearValue() {
        copyOnWrite();
        X.L((X) this.instance);
        return this;
    }

    public String getAppId() {
        return ((X) this.instance).c0();
    }

    public ByteString getAppIdBytes() {
        return ((X) this.instance).d0();
    }

    public boolean getIfExists() {
        return ((X) this.instance).e0();
    }

    public boolean getIfNotExists() {
        return ((X) this.instance).f0();
    }

    public String getKey() {
        return ((X) this.instance).g0();
    }

    public ByteString getKeyBytes() {
        return ((X) this.instance).h0();
    }

    public StoreScope getScope() {
        return ((X) this.instance).i0();
    }

    public int getScopeValue() {
        return ((X) this.instance).j0();
    }

    public String getSessionId() {
        return ((X) this.instance).k0();
    }

    public ByteString getSessionIdBytes() {
        return ((X) this.instance).l0();
    }

    public long getTtlSeconds() {
        return ((X) this.instance).m0();
    }

    public String getUserId() {
        return ((X) this.instance).n0();
    }

    public ByteString getUserIdBytes() {
        return ((X) this.instance).o0();
    }

    public String getValue() {
        return ((X) this.instance).p0();
    }

    public ByteString getValueBytes() {
        return ((X) this.instance).q0();
    }

    public StoreSetRequest$Builder setAppId(String str) {
        copyOnWrite();
        X.M((X) this.instance, str);
        return this;
    }

    public StoreSetRequest$Builder setAppIdBytes(ByteString byteString) {
        copyOnWrite();
        X.N((X) this.instance, byteString);
        return this;
    }

    public StoreSetRequest$Builder setIfExists(boolean z10) {
        copyOnWrite();
        X.O((X) this.instance, z10);
        return this;
    }

    public StoreSetRequest$Builder setIfNotExists(boolean z10) {
        copyOnWrite();
        X.P((X) this.instance, z10);
        return this;
    }

    public StoreSetRequest$Builder setKey(String str) {
        copyOnWrite();
        X.Q((X) this.instance, str);
        return this;
    }

    public StoreSetRequest$Builder setKeyBytes(ByteString byteString) {
        copyOnWrite();
        X.R((X) this.instance, byteString);
        return this;
    }

    public StoreSetRequest$Builder setScope(StoreScope storeScope) {
        copyOnWrite();
        X.S((X) this.instance, storeScope);
        return this;
    }

    public StoreSetRequest$Builder setScopeValue(int i) {
        copyOnWrite();
        X.T((X) this.instance, i);
        return this;
    }

    public StoreSetRequest$Builder setSessionId(String str) {
        copyOnWrite();
        X.U((X) this.instance, str);
        return this;
    }

    public StoreSetRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        X.V((X) this.instance, byteString);
        return this;
    }

    public StoreSetRequest$Builder setTtlSeconds(long j5) {
        copyOnWrite();
        X.W((X) this.instance, j5);
        return this;
    }

    public StoreSetRequest$Builder setUserId(String str) {
        copyOnWrite();
        X.X((X) this.instance, str);
        return this;
    }

    public StoreSetRequest$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        X.Y((X) this.instance, byteString);
        return this;
    }

    public StoreSetRequest$Builder setValue(String str) {
        copyOnWrite();
        X.Z((X) this.instance, str);
        return this;
    }

    public StoreSetRequest$Builder setValueBytes(ByteString byteString) {
        copyOnWrite();
        X.a0((X) this.instance, byteString);
        return this;
    }

    private StoreSetRequest$Builder() {
        super(X.DEFAULT_INSTANCE);
    }
}
