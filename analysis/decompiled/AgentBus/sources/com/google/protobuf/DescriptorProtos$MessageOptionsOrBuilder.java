package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$MessageOptionsOrBuilder extends GeneratedMessageLite$ExtendableMessageOrBuilder<d1, z> {
    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ MessageLite getDefaultInstanceForType();

    boolean getDeprecated();

    @Deprecated
    boolean getDeprecatedLegacyJsonFieldConflicts();

    m0 getFeatures();

    boolean getMapEntry();

    boolean getMessageSetWireFormat();

    boolean getNoStandardDescriptorAccessor();

    o1 getUninterpretedOption(int i2);

    int getUninterpretedOptionCount();

    List<o1> getUninterpretedOptionList();

    boolean hasDeprecated();

    @Deprecated
    boolean hasDeprecatedLegacyJsonFieldConflicts();

    boolean hasFeatures();

    boolean hasMapEntry();

    boolean hasMessageSetWireFormat();

    boolean hasNoStandardDescriptorAccessor();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ boolean isInitialized();
}
