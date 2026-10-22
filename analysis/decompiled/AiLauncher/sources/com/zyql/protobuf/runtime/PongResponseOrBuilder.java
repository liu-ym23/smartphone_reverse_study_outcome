package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface PongResponseOrBuilder extends MessageLiteOrBuilder {
    long getTimestamp();

    String getVersion();

    ByteString getVersionBytes();
}
