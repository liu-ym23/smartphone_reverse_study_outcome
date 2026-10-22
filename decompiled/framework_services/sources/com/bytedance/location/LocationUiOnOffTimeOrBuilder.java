package com.bytedance.location;

import com.bytedance.location.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface LocationUiOnOffTimeOrBuilder extends MessageLiteOrBuilder {
    long getTimestamp();

    boolean getUiOn();

    int getUserId();

    boolean hasTimestamp();

    boolean hasUiOn();

    boolean hasUserId();
}
