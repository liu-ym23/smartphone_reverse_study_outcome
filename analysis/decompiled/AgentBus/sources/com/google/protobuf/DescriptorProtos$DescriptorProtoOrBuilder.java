package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$DescriptorProtoOrBuilder {
    /* synthetic */ MessageLite getDefaultInstanceForType();

    y getEnumType(int i2);

    int getEnumTypeCount();

    List<y> getEnumTypeList();

    q0 getExtension(int i2);

    int getExtensionCount();

    List<q0> getExtensionList();

    s getExtensionRange(int i2);

    int getExtensionRangeCount();

    List<s> getExtensionRangeList();

    q0 getField(int i2);

    int getFieldCount();

    List<q0> getFieldList();

    String getName();

    l getNameBytes();

    u getNestedType(int i2);

    int getNestedTypeCount();

    List<u> getNestedTypeList();

    h1 getOneofDecl(int i2);

    int getOneofDeclCount();

    List<h1> getOneofDeclList();

    /* renamed from: getOptions */
    d1 mo2getOptions();

    String getReservedName(int i2);

    l getReservedNameBytes(int i2);

    int getReservedNameCount();

    List<String> getReservedNameList();

    t getReservedRange(int i2);

    int getReservedRangeCount();

    List<t> getReservedRangeList();

    boolean hasName();

    boolean hasOptions();

    /* synthetic */ boolean isInitialized();
}
