package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1767c;

/* loaded from: classes2.dex */
public final class AgentTool$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AgentTool$Builder(int i) {
        this();
    }

    public AgentTool$Builder clearDescription() {
        copyOnWrite();
        C1767c.D((C1767c) this.instance);
        return this;
    }

    public AgentTool$Builder clearName() {
        copyOnWrite();
        C1767c.E((C1767c) this.instance);
        return this;
    }

    public AgentTool$Builder clearParametersSchema() {
        copyOnWrite();
        C1767c.F((C1767c) this.instance);
        return this;
    }

    public String getDescription() {
        return ((C1767c) this.instance).O();
    }

    public ByteString getDescriptionBytes() {
        return ((C1767c) this.instance).P();
    }

    public String getName() {
        return ((C1767c) this.instance).Q();
    }

    public ByteString getNameBytes() {
        return ((C1767c) this.instance).R();
    }

    public String getParametersSchema() {
        return ((C1767c) this.instance).S();
    }

    public ByteString getParametersSchemaBytes() {
        return ((C1767c) this.instance).T();
    }

    public AgentTool$Builder setDescription(String str) {
        copyOnWrite();
        C1767c.G((C1767c) this.instance, str);
        return this;
    }

    public AgentTool$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        C1767c.H((C1767c) this.instance, byteString);
        return this;
    }

    public AgentTool$Builder setName(String str) {
        copyOnWrite();
        C1767c.I((C1767c) this.instance, str);
        return this;
    }

    public AgentTool$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        C1767c.J((C1767c) this.instance, byteString);
        return this;
    }

    public AgentTool$Builder setParametersSchema(String str) {
        copyOnWrite();
        C1767c.K((C1767c) this.instance, str);
        return this;
    }

    public AgentTool$Builder setParametersSchemaBytes(ByteString byteString) {
        copyOnWrite();
        C1767c.L((C1767c) this.instance, byteString);
        return this;
    }

    private AgentTool$Builder() {
        super(C1767c.DEFAULT_INSTANCE);
    }
}
