package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface FileContentOrBuilder extends MessageLiteOrBuilder {
    ByteString getContent();

    String getPath();

    ByteString getPathBytes();
}
