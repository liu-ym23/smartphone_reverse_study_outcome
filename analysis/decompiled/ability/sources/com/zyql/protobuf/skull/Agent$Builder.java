package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.C2062a;

/* loaded from: classes2.dex */
public final class Agent$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Agent$Builder(int i) {
        this();
    }

    public Agent$Builder clearDescription() {
        copyOnWrite();
        C2062a.D((C2062a) this.instance);
        return this;
    }

    public Agent$Builder clearId() {
        copyOnWrite();
        C2062a.E((C2062a) this.instance);
        return this;
    }

    public Agent$Builder clearName() {
        copyOnWrite();
        C2062a.F((C2062a) this.instance);
        return this;
    }

    public Agent$Builder clearVersion() {
        copyOnWrite();
        C2062a.G((C2062a) this.instance);
        return this;
    }

    public String getDescription() {
        return ((C2062a) this.instance).R();
    }

    public ByteString getDescriptionBytes() {
        return ((C2062a) this.instance).S();
    }

    public String getId() {
        return ((C2062a) this.instance).T();
    }

    public ByteString getIdBytes() {
        return ((C2062a) this.instance).U();
    }

    public String getName() {
        return ((C2062a) this.instance).V();
    }

    public ByteString getNameBytes() {
        return ((C2062a) this.instance).W();
    }

    public String getVersion() {
        return ((C2062a) this.instance).X();
    }

    public ByteString getVersionBytes() {
        return ((C2062a) this.instance).Y();
    }

    public Agent$Builder setDescription(String str) {
        copyOnWrite();
        C2062a.H((C2062a) this.instance, str);
        return this;
    }

    public Agent$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        C2062a.I((C2062a) this.instance, byteString);
        return this;
    }

    public Agent$Builder setId(String str) {
        copyOnWrite();
        C2062a.J((C2062a) this.instance, str);
        return this;
    }

    public Agent$Builder setIdBytes(ByteString byteString) {
        copyOnWrite();
        C2062a.K((C2062a) this.instance, byteString);
        return this;
    }

    public Agent$Builder setName(String str) {
        copyOnWrite();
        C2062a.L((C2062a) this.instance, str);
        return this;
    }

    public Agent$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        C2062a.M((C2062a) this.instance, byteString);
        return this;
    }

    public Agent$Builder setVersion(String str) {
        copyOnWrite();
        C2062a.N((C2062a) this.instance, str);
        return this;
    }

    public Agent$Builder setVersionBytes(ByteString byteString) {
        copyOnWrite();
        C2062a.O((C2062a) this.instance, byteString);
        return this;
    }

    private Agent$Builder() {
        super(C2062a.DEFAULT_INSTANCE);
    }
}
