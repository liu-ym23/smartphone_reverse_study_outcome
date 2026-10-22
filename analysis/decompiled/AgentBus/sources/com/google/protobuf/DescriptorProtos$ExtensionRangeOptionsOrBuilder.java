package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite$ExtendableMessageOrBuilder<f0, z> {
    d0 getDeclaration(int i2);

    int getDeclarationCount();

    List<d0> getDeclarationList();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ MessageLite getDefaultInstanceForType();

    m0 getFeatures();

    o1 getUninterpretedOption(int i2);

    int getUninterpretedOptionCount();

    List<o1> getUninterpretedOptionList();

    e0 getVerification();

    boolean hasFeatures();

    boolean hasVerification();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ boolean isInitialized();
}
