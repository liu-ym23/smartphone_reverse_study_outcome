package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import o7.C1764C;

/* loaded from: classes2.dex */
public final class ToolProvider$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolProvider$Builder(int i) {
        this();
    }

    public ToolProvider$Builder clearMetadata() {
        copyOnWrite();
        C1764C.D((C1764C) this.instance);
        return this;
    }

    public ToolProvider$Builder clearOverrideDescription() {
        copyOnWrite();
        C1764C.E((C1764C) this.instance);
        return this;
    }

    public ToolProvider$Builder clearOverrideName() {
        copyOnWrite();
        C1764C.F((C1764C) this.instance);
        return this;
    }

    public ToolProvider$Builder clearOverrideParametersSchema() {
        copyOnWrite();
        C1764C.G((C1764C) this.instance);
        return this;
    }

    public ToolProvider$Builder clearType() {
        copyOnWrite();
        C1764C.H((C1764C) this.instance);
        return this;
    }

    public Struct getMetadata() {
        return ((C1764C) this.instance).T();
    }

    public String getOverrideDescription() {
        return ((C1764C) this.instance).U();
    }

    public ByteString getOverrideDescriptionBytes() {
        return ((C1764C) this.instance).V();
    }

    public String getOverrideName() {
        return ((C1764C) this.instance).W();
    }

    public ByteString getOverrideNameBytes() {
        return ((C1764C) this.instance).X();
    }

    public String getOverrideParametersSchema() {
        return ((C1764C) this.instance).Y();
    }

    public ByteString getOverrideParametersSchemaBytes() {
        return ((C1764C) this.instance).Z();
    }

    public String getType() {
        return ((C1764C) this.instance).a0();
    }

    public ByteString getTypeBytes() {
        return ((C1764C) this.instance).b0();
    }

    public boolean hasMetadata() {
        return ((C1764C) this.instance).c0();
    }

    public boolean hasOverrideDescription() {
        return ((C1764C) this.instance).d0();
    }

    public boolean hasOverrideName() {
        return ((C1764C) this.instance).e0();
    }

    public boolean hasOverrideParametersSchema() {
        return ((C1764C) this.instance).f0();
    }

    public ToolProvider$Builder mergeMetadata(Struct struct) {
        copyOnWrite();
        C1764C c1764c = (C1764C) this.instance;
        int i = C1764C.TYPE_FIELD_NUMBER;
        c1764c.g0(struct);
        return this;
    }

    public ToolProvider$Builder setMetadata(Struct struct) {
        copyOnWrite();
        C1764C.I((C1764C) this.instance, struct);
        return this;
    }

    public ToolProvider$Builder setOverrideDescription(String str) {
        copyOnWrite();
        C1764C.J((C1764C) this.instance, str);
        return this;
    }

    public ToolProvider$Builder setOverrideDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        C1764C.K((C1764C) this.instance, byteString);
        return this;
    }

    public ToolProvider$Builder setOverrideName(String str) {
        copyOnWrite();
        C1764C.L((C1764C) this.instance, str);
        return this;
    }

    public ToolProvider$Builder setOverrideNameBytes(ByteString byteString) {
        copyOnWrite();
        C1764C.M((C1764C) this.instance, byteString);
        return this;
    }

    public ToolProvider$Builder setOverrideParametersSchema(String str) {
        copyOnWrite();
        C1764C.N((C1764C) this.instance, str);
        return this;
    }

    public ToolProvider$Builder setOverrideParametersSchemaBytes(ByteString byteString) {
        copyOnWrite();
        C1764C.O((C1764C) this.instance, byteString);
        return this;
    }

    public ToolProvider$Builder setType(String str) {
        copyOnWrite();
        C1764C.P((C1764C) this.instance, str);
        return this;
    }

    public ToolProvider$Builder setTypeBytes(ByteString byteString) {
        copyOnWrite();
        C1764C.Q((C1764C) this.instance, byteString);
        return this;
    }

    private ToolProvider$Builder() {
        super(C1764C.DEFAULT_INSTANCE);
    }

    public ToolProvider$Builder setMetadata(C1014y2 c1014y2) {
        copyOnWrite();
        C1764C.I((C1764C) this.instance, (Struct) c1014y2.k());
        return this;
    }
}
