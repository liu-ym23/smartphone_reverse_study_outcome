package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface HookDefinitionOrBuilder extends MessageLiteOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    HookPoint getHookPoint();

    int getHookPointValue();

    HookLayer getLayer();

    int getLayerValue();

    HookExecutionMode getMode();

    int getModeValue();

    String getName();

    ByteString getNameBytes();

    int getTimeoutMs();

    String getToolNamePattern();

    ByteString getToolNamePatternBytes();

    boolean hasToolNamePattern();
}
