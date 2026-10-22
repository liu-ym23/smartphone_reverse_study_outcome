package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ResourceOrBuilder extends MessageLiteOrBuilder {
    boolean containsExtra(String str);

    String getContent();

    ByteString getContentBytes();

    String getDescription();

    ByteString getDescriptionBytes();

    @Deprecated
    Map<String, String> getExtra();

    int getExtraCount();

    Map<String, String> getExtraMap();

    String getExtraOrDefault(String str, String str2);

    String getExtraOrThrow(String str);

    String getMimeType();

    ByteString getMimeTypeBytes();

    String getTitle();

    ByteString getTitleBytes();

    String getType();

    ByteString getTypeBytes();

    String getUri();

    ByteString getUriBytes();
}
