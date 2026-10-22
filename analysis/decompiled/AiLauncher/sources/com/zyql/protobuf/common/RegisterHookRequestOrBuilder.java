package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface RegisterHookRequestOrBuilder extends MessageLiteOrBuilder {
    HookDefinition getHook();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean hasHook();
}
