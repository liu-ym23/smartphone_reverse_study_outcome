package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface BlobOrBuilder extends MessageLiteOrBuilder {
    ByteString getData();

    String getDisplayName();

    ByteString getDisplayNameBytes();

    String getMimeType();

    ByteString getMimeTypeBytes();
}
