package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1768d;

/* loaded from: classes2.dex */
public final class ChatMessage$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ChatMessage$Builder(int i) {
        this();
    }

    public ChatMessage$Builder clearContent() {
        copyOnWrite();
        C1768d.D((C1768d) this.instance);
        return this;
    }

    public ChatMessage$Builder clearName() {
        copyOnWrite();
        C1768d.E((C1768d) this.instance);
        return this;
    }

    public ChatMessage$Builder clearRole() {
        copyOnWrite();
        C1768d.F((C1768d) this.instance);
        return this;
    }

    public String getContent() {
        return ((C1768d) this.instance).N();
    }

    public ByteString getContentBytes() {
        return ((C1768d) this.instance).O();
    }

    public String getName() {
        return ((C1768d) this.instance).Q();
    }

    public ByteString getNameBytes() {
        return ((C1768d) this.instance).R();
    }

    public String getRole() {
        return ((C1768d) this.instance).S();
    }

    public ByteString getRoleBytes() {
        return ((C1768d) this.instance).T();
    }

    public boolean hasName() {
        return ((C1768d) this.instance).U();
    }

    public ChatMessage$Builder setContent(String str) {
        copyOnWrite();
        C1768d.G((C1768d) this.instance, str);
        return this;
    }

    public ChatMessage$Builder setContentBytes(ByteString byteString) {
        copyOnWrite();
        C1768d.H((C1768d) this.instance, byteString);
        return this;
    }

    public ChatMessage$Builder setName(String str) {
        copyOnWrite();
        C1768d.I((C1768d) this.instance, str);
        return this;
    }

    public ChatMessage$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        C1768d.J((C1768d) this.instance, byteString);
        return this;
    }

    public ChatMessage$Builder setRole(String str) {
        copyOnWrite();
        C1768d.K((C1768d) this.instance, str);
        return this;
    }

    public ChatMessage$Builder setRoleBytes(ByteString byteString) {
        copyOnWrite();
        C1768d.L((C1768d) this.instance, byteString);
        return this;
    }

    private ChatMessage$Builder() {
        super(C1768d.DEFAULT_INSTANCE);
    }
}
