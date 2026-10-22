package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import r7.b;

/* loaded from: classes2.dex */
public final class AuthBindReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AuthBindReq$Builder(int i) {
        this();
    }

    public AuthBindReq$Builder clearAppVersion() {
        copyOnWrite();
        b.D((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearChannel() {
        copyOnWrite();
        b.E((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearDevice() {
        copyOnWrite();
        b.F((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearDid() {
        copyOnWrite();
        b.G((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearPlatform() {
        copyOnWrite();
        b.H((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearProduct() {
        copyOnWrite();
        b.I((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearReserved() {
        copyOnWrite();
        b.M((b) this.instance).clear();
        return this;
    }

    public AuthBindReq$Builder clearToken() {
        copyOnWrite();
        b.J((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearTokenType() {
        copyOnWrite();
        b.K((b) this.instance);
        return this;
    }

    public AuthBindReq$Builder clearUid() {
        copyOnWrite();
        b.L((b) this.instance);
        return this;
    }

    public boolean containsReserved(String str) {
        str.getClass();
        return ((b) this.instance).q0().containsKey(str);
    }

    public String getAppVersion() {
        return ((b) this.instance).f0();
    }

    public ByteString getAppVersionBytes() {
        return ((b) this.instance).g0();
    }

    public String getChannel() {
        return ((b) this.instance).h0();
    }

    public ByteString getChannelBytes() {
        return ((b) this.instance).i0();
    }

    public String getDevice() {
        return ((b) this.instance).j0();
    }

    public ByteString getDeviceBytes() {
        return ((b) this.instance).k0();
    }

    public String getDid() {
        return ((b) this.instance).l0();
    }

    public ByteString getDidBytes() {
        return ((b) this.instance).m0();
    }

    public int getPlatform() {
        return ((b) this.instance).n0();
    }

    public String getProduct() {
        return ((b) this.instance).o0();
    }

    public ByteString getProductBytes() {
        return ((b) this.instance).p0();
    }

    @Deprecated
    public Map<String, String> getReserved() {
        return getReservedMap();
    }

    public int getReservedCount() {
        return ((b) this.instance).q0().size();
    }

    public Map<String, String> getReservedMap() {
        return Collections.unmodifiableMap(((b) this.instance).q0());
    }

    public String getReservedOrDefault(String str, String str2) {
        str.getClass();
        Map mapQ0 = ((b) this.instance).q0();
        return mapQ0.containsKey(str) ? (String) mapQ0.get(str) : str2;
    }

    public String getReservedOrThrow(String str) {
        str.getClass();
        Map mapQ0 = ((b) this.instance).q0();
        if (mapQ0.containsKey(str)) {
            return (String) mapQ0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getToken() {
        return ((b) this.instance).r0();
    }

    public ByteString getTokenBytes() {
        return ((b) this.instance).s0();
    }

    public String getTokenType() {
        return ((b) this.instance).t0();
    }

    public ByteString getTokenTypeBytes() {
        return ((b) this.instance).u0();
    }

    public String getUid() {
        return ((b) this.instance).v0();
    }

    public ByteString getUidBytes() {
        return ((b) this.instance).w0();
    }

    public AuthBindReq$Builder putAllReserved(Map<String, String> map) {
        copyOnWrite();
        b.M((b) this.instance).putAll(map);
        return this;
    }

    public AuthBindReq$Builder putReserved(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        b.M((b) this.instance).put(str, str2);
        return this;
    }

    public AuthBindReq$Builder removeReserved(String str) {
        str.getClass();
        copyOnWrite();
        b.M((b) this.instance).remove(str);
        return this;
    }

    public AuthBindReq$Builder setAppVersion(String str) {
        copyOnWrite();
        b.N((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setAppVersionBytes(ByteString byteString) {
        copyOnWrite();
        b.O((b) this.instance, byteString);
        return this;
    }

    public AuthBindReq$Builder setChannel(String str) {
        copyOnWrite();
        b.P((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setChannelBytes(ByteString byteString) {
        copyOnWrite();
        b.Q((b) this.instance, byteString);
        return this;
    }

    public AuthBindReq$Builder setDevice(String str) {
        copyOnWrite();
        b.R((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setDeviceBytes(ByteString byteString) {
        copyOnWrite();
        b.S((b) this.instance, byteString);
        return this;
    }

    public AuthBindReq$Builder setDid(String str) {
        copyOnWrite();
        b.T((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setDidBytes(ByteString byteString) {
        copyOnWrite();
        b.U((b) this.instance, byteString);
        return this;
    }

    public AuthBindReq$Builder setPlatform(int i) {
        copyOnWrite();
        b.V((b) this.instance, i);
        return this;
    }

    public AuthBindReq$Builder setProduct(String str) {
        copyOnWrite();
        b.W((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setProductBytes(ByteString byteString) {
        copyOnWrite();
        b.X((b) this.instance, byteString);
        return this;
    }

    public AuthBindReq$Builder setToken(String str) {
        copyOnWrite();
        b.Y((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setTokenBytes(ByteString byteString) {
        copyOnWrite();
        b.Z((b) this.instance, byteString);
        return this;
    }

    public AuthBindReq$Builder setTokenType(String str) {
        copyOnWrite();
        b.a0((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setTokenTypeBytes(ByteString byteString) {
        copyOnWrite();
        b.b0((b) this.instance, byteString);
        return this;
    }

    public AuthBindReq$Builder setUid(String str) {
        copyOnWrite();
        b.c0((b) this.instance, str);
        return this;
    }

    public AuthBindReq$Builder setUidBytes(ByteString byteString) {
        copyOnWrite();
        b.d0((b) this.instance, byteString);
        return this;
    }

    private AuthBindReq$Builder() {
        super(b.DEFAULT_INSTANCE);
    }
}
