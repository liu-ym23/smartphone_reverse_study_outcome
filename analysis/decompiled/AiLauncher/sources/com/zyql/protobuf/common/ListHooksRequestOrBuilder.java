package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface ListHooksRequestOrBuilder extends MessageLiteOrBuilder {
    HookPoint getHookPoint();

    int getHookPointValue();

    HookLayer getLayer();

    int getLayerValue();

    String getSessionId();

    ByteString getSessionIdBytes();
}
