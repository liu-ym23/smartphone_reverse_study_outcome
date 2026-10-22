package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.V;

/* loaded from: classes2.dex */
public final class StoreListRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreListRequest$Builder(int i) {
        this();
    }

    public StoreListRequest$Builder clearAppId() {
        copyOnWrite();
        V.D((V) this.instance);
        return this;
    }

    public StoreListRequest$Builder clearCount() {
        copyOnWrite();
        V.E((V) this.instance);
        return this;
    }

    public StoreListRequest$Builder clearCursor() {
        copyOnWrite();
        V.F((V) this.instance);
        return this;
    }

    public StoreListRequest$Builder clearPrefix() {
        copyOnWrite();
        V.G((V) this.instance);
        return this;
    }

    public StoreListRequest$Builder clearScope() {
        copyOnWrite();
        V.H((V) this.instance);
        return this;
    }

    public StoreListRequest$Builder clearSessionId() {
        copyOnWrite();
        V.I((V) this.instance);
        return this;
    }

    public StoreListRequest$Builder clearUserId() {
        copyOnWrite();
        V.J((V) this.instance);
        return this;
    }

    public String getAppId() {
        return ((V) this.instance).Y();
    }

    public ByteString getAppIdBytes() {
        return ((V) this.instance).Z();
    }

    public int getCount() {
        return ((V) this.instance).a0();
    }

    public String getCursor() {
        return ((V) this.instance).b0();
    }

    public ByteString getCursorBytes() {
        return ((V) this.instance).c0();
    }

    public String getPrefix() {
        return ((V) this.instance).d0();
    }

    public ByteString getPrefixBytes() {
        return ((V) this.instance).e0();
    }

    public StoreScope getScope() {
        return ((V) this.instance).f0();
    }

    public int getScopeValue() {
        return ((V) this.instance).g0();
    }

    public String getSessionId() {
        return ((V) this.instance).h0();
    }

    public ByteString getSessionIdBytes() {
        return ((V) this.instance).i0();
    }

    public String getUserId() {
        return ((V) this.instance).j0();
    }

    public ByteString getUserIdBytes() {
        return ((V) this.instance).k0();
    }

    public StoreListRequest$Builder setAppId(String str) {
        copyOnWrite();
        V.K((V) this.instance, str);
        return this;
    }

    public StoreListRequest$Builder setAppIdBytes(ByteString byteString) {
        copyOnWrite();
        V.L((V) this.instance, byteString);
        return this;
    }

    public StoreListRequest$Builder setCount(int i) {
        copyOnWrite();
        V.M((V) this.instance, i);
        return this;
    }

    public StoreListRequest$Builder setCursor(String str) {
        copyOnWrite();
        V.N((V) this.instance, str);
        return this;
    }

    public StoreListRequest$Builder setCursorBytes(ByteString byteString) {
        copyOnWrite();
        V.O((V) this.instance, byteString);
        return this;
    }

    public StoreListRequest$Builder setPrefix(String str) {
        copyOnWrite();
        V.P((V) this.instance, str);
        return this;
    }

    public StoreListRequest$Builder setPrefixBytes(ByteString byteString) {
        copyOnWrite();
        V.Q((V) this.instance, byteString);
        return this;
    }

    public StoreListRequest$Builder setScope(StoreScope storeScope) {
        copyOnWrite();
        V.R((V) this.instance, storeScope);
        return this;
    }

    public StoreListRequest$Builder setScopeValue(int i) {
        copyOnWrite();
        V.S((V) this.instance, i);
        return this;
    }

    public StoreListRequest$Builder setSessionId(String str) {
        copyOnWrite();
        V.T((V) this.instance, str);
        return this;
    }

    public StoreListRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        V.U((V) this.instance, byteString);
        return this;
    }

    public StoreListRequest$Builder setUserId(String str) {
        copyOnWrite();
        V.V((V) this.instance, str);
        return this;
    }

    public StoreListRequest$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        V.W((V) this.instance, byteString);
        return this;
    }

    private StoreListRequest$Builder() {
        super(V.DEFAULT_INSTANCE);
    }
}
