package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes.dex */
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> cls);
}
