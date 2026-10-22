package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;

/* loaded from: classes4.dex */
public interface ToolProviderOrBuilder extends MessageLiteOrBuilder {
    Struct getMetadata();

    String getOverrideDescription();

    ByteString getOverrideDescriptionBytes();

    String getOverrideName();

    ByteString getOverrideNameBytes();

    String getOverrideParametersSchema();

    ByteString getOverrideParametersSchemaBytes();

    String getType();

    ByteString getTypeBytes();

    boolean hasMetadata();

    boolean hasOverrideDescription();

    boolean hasOverrideName();

    boolean hasOverrideParametersSchema();
}
