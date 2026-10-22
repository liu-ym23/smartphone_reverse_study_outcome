package com.google.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public interface StructOrBuilder {
    boolean containsFields(String str);

    /* synthetic */ MessageLite getDefaultInstanceForType();

    @Deprecated
    Map<String, n4> getFields();

    int getFieldsCount();

    Map<String, n4> getFieldsMap();

    n4 getFieldsOrDefault(String str, n4 n4Var);

    n4 getFieldsOrThrow(String str);

    /* synthetic */ boolean isInitialized();
}
