package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface MessageOrBuilder extends MessageLiteOrBuilder {
    List<String> findInitializationErrors();

    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    Message getDefaultInstanceForType();

    Descriptors.Descriptor getDescriptorForType();

    Object getField(Descriptors.FieldDescriptor r10);

    String getInitializationErrorString();

    Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10);

    Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11);

    int getRepeatedFieldCount(Descriptors.FieldDescriptor r10);

    UnknownFieldSet getUnknownFields();

    boolean hasField(Descriptors.FieldDescriptor r10);

    boolean hasOneof(Descriptors.OneofDescriptor r10);
}
