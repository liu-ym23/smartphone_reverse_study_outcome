package com.bytedance.location;

import com.bytedance.location.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface LocationProtoDataOrBuilder extends MessageLiteOrBuilder {
    AppLocationUsage getAppLocationUsage();

    GnssPositioning getGnssPositioning();

    LocationUiOnOffTime getLocationUiOnOffTime();

    boolean hasAppLocationUsage();

    boolean hasGnssPositioning();

    boolean hasLocationUiOnOffTime();
}
