package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface FileDataOrBuilder extends MessageLiteOrBuilder {
    String getDisplayName();

    ByteString getDisplayNameBytes();

    String getMimeType();

    ByteString getMimeTypeBytes();

    String getUri();

    ByteString getUriBytes();
}
