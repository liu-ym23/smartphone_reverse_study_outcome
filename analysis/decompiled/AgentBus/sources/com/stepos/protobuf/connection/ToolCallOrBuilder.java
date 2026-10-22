package com.stepos.protobuf.connection;

import b7.f;
import b7.h;
import b7.i;
import com.google.protobuf.MessageLite;
import com.google.protobuf.l;

/* loaded from: classes.dex */
public interface ToolCallOrBuilder {
    String getCallId();

    l getCallIdBytes();

    /* synthetic */ MessageLite getDefaultInstanceForType();

    h getParams();

    i getResult();

    f getTool();

    boolean hasParams();

    boolean hasResult();

    boolean hasTool();

    /* synthetic */ boolean isInitialized();
}
