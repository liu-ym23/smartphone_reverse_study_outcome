package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.S;

/* loaded from: classes2.dex */
public final class StoreEntry$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreEntry$Builder(int i) {
        this();
    }

    public StoreEntry$Builder clearAppId() {
        copyOnWrite();
        S.D((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearCreatedAt() {
        copyOnWrite();
        S.E((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearExpiresAt() {
        copyOnWrite();
        S.F((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearKey() {
        copyOnWrite();
        S.G((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearScope() {
        copyOnWrite();
        S.H((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearSessionId() {
        copyOnWrite();
        S.I((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearTtlSeconds() {
        copyOnWrite();
        S.J((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearUpdatedAt() {
        copyOnWrite();
        S.K((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearUserId() {
        copyOnWrite();
        S.L((S) this.instance);
        return this;
    }

    public StoreEntry$Builder clearValue() {
        copyOnWrite();
        S.M((S) this.instance);
        return this;
    }

    public String getAppId() {
        return ((S) this.instance).e0();
    }

    public ByteString getAppIdBytes() {
        return ((S) this.instance).f0();
    }

    public long getCreatedAt() {
        return ((S) this.instance).g0();
    }

    public long getExpiresAt() {
        return ((S) this.instance).h0();
    }

    public String getKey() {
        return ((S) this.instance).i0();
    }

    public ByteString getKeyBytes() {
        return ((S) this.instance).j0();
    }

    public StoreScope getScope() {
        return ((S) this.instance).k0();
    }

    public int getScopeValue() {
        return ((S) this.instance).l0();
    }

    public String getSessionId() {
        return ((S) this.instance).m0();
    }

    public ByteString getSessionIdBytes() {
        return ((S) this.instance).n0();
    }

    public long getTtlSeconds() {
        return ((S) this.instance).o0();
    }

    public long getUpdatedAt() {
        return ((S) this.instance).p0();
    }

    public String getUserId() {
        return ((S) this.instance).q0();
    }

    public ByteString getUserIdBytes() {
        return ((S) this.instance).r0();
    }

    public String getValue() {
        return ((S) this.instance).s0();
    }

    public ByteString getValueBytes() {
        return ((S) this.instance).t0();
    }

    public StoreEntry$Builder setAppId(String str) {
        copyOnWrite();
        S.N((S) this.instance, str);
        return this;
    }

    public StoreEntry$Builder setAppIdBytes(ByteString byteString) {
        copyOnWrite();
        S.O((S) this.instance, byteString);
        return this;
    }

    public StoreEntry$Builder setCreatedAt(long j5) {
        copyOnWrite();
        S.P((S) this.instance, j5);
        return this;
    }

    public StoreEntry$Builder setExpiresAt(long j5) {
        copyOnWrite();
        S.Q((S) this.instance, j5);
        return this;
    }

    public StoreEntry$Builder setKey(String str) {
        copyOnWrite();
        S.R((S) this.instance, str);
        return this;
    }

    public StoreEntry$Builder setKeyBytes(ByteString byteString) {
        copyOnWrite();
        S.S((S) this.instance, byteString);
        return this;
    }

    public StoreEntry$Builder setScope(StoreScope storeScope) {
        copyOnWrite();
        S.T((S) this.instance, storeScope);
        return this;
    }

    public StoreEntry$Builder setScopeValue(int i) {
        copyOnWrite();
        S.U((S) this.instance, i);
        return this;
    }

    public StoreEntry$Builder setSessionId(String str) {
        copyOnWrite();
        S.V((S) this.instance, str);
        return this;
    }

    public StoreEntry$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        S.W((S) this.instance, byteString);
        return this;
    }

    public StoreEntry$Builder setTtlSeconds(long j5) {
        copyOnWrite();
        S.X((S) this.instance, j5);
        return this;
    }

    public StoreEntry$Builder setUpdatedAt(long j5) {
        copyOnWrite();
        S.Y((S) this.instance, j5);
        return this;
    }

    public StoreEntry$Builder setUserId(String str) {
        copyOnWrite();
        S.Z((S) this.instance, str);
        return this;
    }

    public StoreEntry$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        S.a0((S) this.instance, byteString);
        return this;
    }

    public StoreEntry$Builder setValue(String str) {
        copyOnWrite();
        S.b0((S) this.instance, str);
        return this;
    }

    public StoreEntry$Builder setValueBytes(ByteString byteString) {
        copyOnWrite();
        S.c0((S) this.instance, byteString);
        return this;
    }

    private StoreEntry$Builder() {
        super(S.DEFAULT_INSTANCE);
    }
}
