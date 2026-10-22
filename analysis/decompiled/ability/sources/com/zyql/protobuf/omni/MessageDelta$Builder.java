package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.j;

/* loaded from: classes2.dex */
public final class MessageDelta$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ MessageDelta$Builder(int i) {
        this();
    }

    public MessageDelta$Builder clearIsEnd() {
        copyOnWrite();
        j.D((j) this.instance);
        return this;
    }

    public MessageDelta$Builder clearMessageId() {
        copyOnWrite();
        j.E((j) this.instance);
        return this;
    }

    public MessageDelta$Builder clearRole() {
        copyOnWrite();
        j.F((j) this.instance);
        return this;
    }

    public MessageDelta$Builder clearText() {
        copyOnWrite();
        j.G((j) this.instance);
        return this;
    }

    public boolean getIsEnd() {
        return ((j) this.instance).Q();
    }

    public String getMessageId() {
        return ((j) this.instance).R();
    }

    public ByteString getMessageIdBytes() {
        return ((j) this.instance).S();
    }

    public String getRole() {
        return ((j) this.instance).T();
    }

    public ByteString getRoleBytes() {
        return ((j) this.instance).U();
    }

    public String getText() {
        return ((j) this.instance).V();
    }

    public ByteString getTextBytes() {
        return ((j) this.instance).W();
    }

    public MessageDelta$Builder setIsEnd(boolean z10) {
        copyOnWrite();
        j.H((j) this.instance, z10);
        return this;
    }

    public MessageDelta$Builder setMessageId(String str) {
        copyOnWrite();
        j.I((j) this.instance, str);
        return this;
    }

    public MessageDelta$Builder setMessageIdBytes(ByteString byteString) {
        copyOnWrite();
        j.J((j) this.instance, byteString);
        return this;
    }

    public MessageDelta$Builder setRole(String str) {
        copyOnWrite();
        j.K((j) this.instance, str);
        return this;
    }

    public MessageDelta$Builder setRoleBytes(ByteString byteString) {
        copyOnWrite();
        j.L((j) this.instance, byteString);
        return this;
    }

    public MessageDelta$Builder setText(String str) {
        copyOnWrite();
        j.M((j) this.instance, str);
        return this;
    }

    public MessageDelta$Builder setTextBytes(ByteString byteString) {
        copyOnWrite();
        j.N((j) this.instance, byteString);
        return this;
    }

    private MessageDelta$Builder() {
        super(j.DEFAULT_INSTANCE);
    }
}
