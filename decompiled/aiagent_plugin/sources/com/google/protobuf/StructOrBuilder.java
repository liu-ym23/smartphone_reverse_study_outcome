package com.google.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface StructOrBuilder extends MessageOrBuilder {
    boolean containsFields(String r1);

    @Deprecated
    Map<String, Value> getFields();

    int getFieldsCount();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String r1, Value r2);

    Value getFieldsOrThrow(String r1);
}
