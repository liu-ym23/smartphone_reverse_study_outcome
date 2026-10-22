package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import r7.c;

/* loaded from: classes2.dex */
public final class AuthBindResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AuthBindResp$Builder(int i) {
        this();
    }

    public AuthBindResp$Builder clearCode() {
        copyOnWrite();
        c.D((c) this.instance);
        return this;
    }

    public AuthBindResp$Builder clearConn() {
        copyOnWrite();
        c.E((c) this.instance);
        return this;
    }

    public AuthBindResp$Builder clearError() {
        copyOnWrite();
        c.F((c) this.instance);
        return this;
    }

    public AuthBindResp$Builder clearLogined() {
        copyOnWrite();
        c.G((c) this.instance);
        return this;
    }

    public AuthBindResp$Builder clearNew() {
        copyOnWrite();
        c.H((c) this.instance);
        return this;
    }

    public AuthBindResp$Builder clearUid() {
        copyOnWrite();
        c.I((c) this.instance);
        return this;
    }

    public int getCode() {
        return ((c) this.instance).T();
    }

    public String getConn() {
        return ((c) this.instance).U();
    }

    public ByteString getConnBytes() {
        return ((c) this.instance).V();
    }

    public String getError() {
        return ((c) this.instance).W();
    }

    public ByteString getErrorBytes() {
        return ((c) this.instance).X();
    }

    public int getLogined() {
        return ((c) this.instance).Y();
    }

    public boolean getNew() {
        return ((c) this.instance).Z();
    }

    public String getUid() {
        return ((c) this.instance).a0();
    }

    public ByteString getUidBytes() {
        return ((c) this.instance).b0();
    }

    public AuthBindResp$Builder setCode(int i) {
        copyOnWrite();
        c.J((c) this.instance, i);
        return this;
    }

    public AuthBindResp$Builder setConn(String str) {
        copyOnWrite();
        c.K((c) this.instance, str);
        return this;
    }

    public AuthBindResp$Builder setConnBytes(ByteString byteString) {
        copyOnWrite();
        c.L((c) this.instance, byteString);
        return this;
    }

    public AuthBindResp$Builder setError(String str) {
        copyOnWrite();
        c.M((c) this.instance, str);
        return this;
    }

    public AuthBindResp$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        c.N((c) this.instance, byteString);
        return this;
    }

    public AuthBindResp$Builder setLogined(int i) {
        copyOnWrite();
        c.O((c) this.instance, i);
        return this;
    }

    public AuthBindResp$Builder setNew(boolean z10) {
        copyOnWrite();
        c.P((c) this.instance, z10);
        return this;
    }

    public AuthBindResp$Builder setUid(String str) {
        copyOnWrite();
        c.Q((c) this.instance, str);
        return this;
    }

    public AuthBindResp$Builder setUidBytes(ByteString byteString) {
        copyOnWrite();
        c.R((c) this.instance, byteString);
        return this;
    }

    private AuthBindResp$Builder() {
        super(c.DEFAULT_INSTANCE);
    }
}
