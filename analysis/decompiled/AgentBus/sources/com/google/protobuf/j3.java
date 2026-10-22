package com.google.protobuf;

import com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class j3 extends f2 implements MixinOrBuilder, OptionOrBuilder, SourceContextOrBuilder, StructOrBuilder, ValueOrBuilder, AuthBindRespOrBuilder {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2416h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j3(int i2, i2 i2Var) {
        super(i2Var);
        this.f2416h = i2;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(String str) {
        str.getClass();
        return ((z3) this.f2351g).getFieldsMap().containsKey(str);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        return ((n4) this.f2351g).getBoolValue();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public int getCode() {
        return ((l4.d) this.f2351g).getCode();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public String getConn() {
        return ((l4.d) this.f2351g).getConn();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public l getConnBytes() {
        return ((l4.d) this.f2351g).getConnBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public String getError() {
        return ((l4.d) this.f2351g).getError();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public l getErrorBytes() {
        return ((l4.d) this.f2351g).getErrorBytes();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Map getFields() {
        return getFieldsMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return ((z3) this.f2351g).getFieldsMap().size();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Map getFieldsMap() {
        return Collections.unmodifiableMap(((z3) this.f2351g).getFieldsMap());
    }

    @Override // com.google.protobuf.StructOrBuilder
    public n4 getFieldsOrDefault(String str, n4 n4Var) {
        str.getClass();
        Map fieldsMap = ((z3) this.f2351g).getFieldsMap();
        return fieldsMap.containsKey(str) ? (n4) fieldsMap.get(str) : n4Var;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public n4 getFieldsOrThrow(String str) {
        str.getClass();
        Map fieldsMap = ((z3) this.f2351g).getFieldsMap();
        if (fieldsMap.containsKey(str)) {
            return (n4) fieldsMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.SourceContextOrBuilder
    public String getFileName() {
        return ((x3) this.f2351g).getFileName();
    }

    @Override // com.google.protobuf.SourceContextOrBuilder
    public l getFileNameBytes() {
        return ((x3) this.f2351g).getFileNameBytes();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public m4 getKindCase() {
        return ((n4) this.f2351g).getKindCase();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public w2 getListValue() {
        return ((n4) this.f2351g).getListValue();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public int getLogined() {
        return ((l4.d) this.f2351g).getLogined();
    }

    @Override // com.google.protobuf.MixinOrBuilder, com.google.protobuf.OptionOrBuilder
    public String getName() {
        switch (this.f2416h) {
            case 0:
                return ((k3) this.f2351g).getName();
            default:
                return ((o3) this.f2351g).getName();
        }
    }

    @Override // com.google.protobuf.MixinOrBuilder, com.google.protobuf.OptionOrBuilder
    public l getNameBytes() {
        switch (this.f2416h) {
            case 0:
                return ((k3) this.f2351g).getNameBytes();
            default:
                return ((o3) this.f2351g).getNameBytes();
        }
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public boolean getNew() {
        return ((l4.d) this.f2351g).getNew();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public n3 getNullValue() {
        return ((n4) this.f2351g).getNullValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        return ((n4) this.f2351g).getNullValueValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public double getNumberValue() {
        return ((n4) this.f2351g).getNumberValue();
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public String getRoot() {
        return ((k3) this.f2351g).getRoot();
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public l getRootBytes() {
        return ((k3) this.f2351g).getRootBytes();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public String getStringValue() {
        return ((n4) this.f2351g).getStringValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public l getStringValueBytes() {
        return ((n4) this.f2351g).getStringValueBytes();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public z3 getStructValue() {
        return ((n4) this.f2351g).getStructValue();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public String getUid() {
        return ((l4.d) this.f2351g).getUid();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public l getUidBytes() {
        return ((l4.d) this.f2351g).getUidBytes();
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public f getValue() {
        return ((o3) this.f2351g).getValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasBoolValue() {
        return ((n4) this.f2351g).hasBoolValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        return ((n4) this.f2351g).hasListValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasNullValue() {
        return ((n4) this.f2351g).hasNullValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasNumberValue() {
        return ((n4) this.f2351g).hasNumberValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStringValue() {
        return ((n4) this.f2351g).hasStringValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        return ((n4) this.f2351g).hasStructValue();
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public boolean hasValue() {
        return ((o3) this.f2351g).hasValue();
    }
}
