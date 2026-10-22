package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes4.dex */
public interface StoreListResponseOrBuilder extends MessageLiteOrBuilder {
    String getKeys(int i10);

    ByteString getKeysBytes(int i10);

    int getKeysCount();

    List<String> getKeysList();

    String getNextCursor();

    ByteString getNextCursorBytes();
}
