package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$EnumOptionsOrBuilder extends GeneratedMessageLite$ExtendableMessageOrBuilder<a0, z> {
    boolean getAllowAlias();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ MessageLite getDefaultInstanceForType();

    boolean getDeprecated();

    @Deprecated
    boolean getDeprecatedLegacyJsonFieldConflicts();

    m0 getFeatures();

    o1 getUninterpretedOption(int i2);

    int getUninterpretedOptionCount();

    List<o1> getUninterpretedOptionList();

    boolean hasAllowAlias();

    boolean hasDeprecated();

    @Deprecated
    boolean hasDeprecatedLegacyJsonFieldConflicts();

    boolean hasFeatures();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ boolean isInitialized();
}
