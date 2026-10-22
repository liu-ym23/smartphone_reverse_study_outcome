package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$FileDescriptorProtoOrBuilder {
    /* synthetic */ MessageLite getDefaultInstanceForType();

    String getDependency(int i2);

    l getDependencyBytes(int i2);

    int getDependencyCount();

    List<String> getDependencyList();

    w getEdition();

    y getEnumType(int i2);

    int getEnumTypeCount();

    List<y> getEnumTypeList();

    q0 getExtension(int i2);

    int getExtensionCount();

    List<q0> getExtensionList();

    u getMessageType(int i2);

    int getMessageTypeCount();

    List<u> getMessageTypeList();

    String getName();

    l getNameBytes();

    /* renamed from: getOptions */
    a1 mo0getOptions();

    String getPackage();

    l getPackageBytes();

    int getPublicDependency(int i2);

    int getPublicDependencyCount();

    List<Integer> getPublicDependencyList();

    j1 getService(int i2);

    int getServiceCount();

    List<j1> getServiceList();

    m1 getSourceCodeInfo();

    /* renamed from: getSyntax */
    String mo11getSyntax();

    l getSyntaxBytes();

    int getWeakDependency(int i2);

    int getWeakDependencyCount();

    List<Integer> getWeakDependencyList();

    boolean hasEdition();

    boolean hasName();

    boolean hasOptions();

    boolean hasPackage();

    boolean hasSourceCodeInfo();

    boolean hasSyntax();

    /* synthetic */ boolean isInitialized();
}
