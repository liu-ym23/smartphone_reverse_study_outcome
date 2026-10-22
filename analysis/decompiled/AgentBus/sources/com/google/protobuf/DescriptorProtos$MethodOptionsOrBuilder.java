package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$MethodOptionsOrBuilder extends GeneratedMessageLite$ExtendableMessageOrBuilder<g1, z> {
    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ MessageLite getDefaultInstanceForType();

    boolean getDeprecated();

    m0 getFeatures();

    f1 getIdempotencyLevel();

    o1 getUninterpretedOption(int i2);

    int getUninterpretedOptionCount();

    List<o1> getUninterpretedOptionList();

    boolean hasDeprecated();

    boolean hasFeatures();

    boolean hasIdempotencyLevel();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ boolean isInitialized();
}
