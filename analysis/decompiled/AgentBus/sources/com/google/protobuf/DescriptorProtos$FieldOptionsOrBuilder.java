package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$FieldOptionsOrBuilder extends GeneratedMessageLite$ExtendableMessageOrBuilder<x0, z> {
    r0 getCtype();

    boolean getDebugRedact();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ MessageLite getDefaultInstanceForType();

    boolean getDeprecated();

    s0 getEditionDefaults(int i2);

    int getEditionDefaultsCount();

    List<s0> getEditionDefaultsList();

    t0 getFeatureSupport();

    m0 getFeatures();

    u0 getJstype();

    boolean getLazy();

    boolean getPacked();

    v0 getRetention();

    w0 getTargets(int i2);

    int getTargetsCount();

    List<w0> getTargetsList();

    o1 getUninterpretedOption(int i2);

    int getUninterpretedOptionCount();

    List<o1> getUninterpretedOptionList();

    boolean getUnverifiedLazy();

    boolean getWeak();

    boolean hasCtype();

    boolean hasDebugRedact();

    boolean hasDeprecated();

    boolean hasFeatureSupport();

    boolean hasFeatures();

    boolean hasJstype();

    boolean hasLazy();

    boolean hasPacked();

    boolean hasRetention();

    boolean hasUnverifiedLazy();

    boolean hasWeak();

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    /* synthetic */ boolean isInitialized();
}
