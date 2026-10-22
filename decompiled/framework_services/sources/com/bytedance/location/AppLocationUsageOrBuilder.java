package com.bytedance.location;

import com.bytedance.location.protobuf.ByteString;
import com.bytedance.location.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface AppLocationUsageOrBuilder extends MessageLiteOrBuilder {
    long getActiveTime();

    String getAppPackageName();

    ByteString getAppPackageNameBytes();

    long getAppTtff();

    int getErrorCode();

    long getForegroundTime();

    boolean getHasNavReq();

    String getLocationProvider();

    ByteString getLocationProviderBytes();

    int getLocationReceived();

    long getRequestInterval();

    long getStartTimestamp();

    long getStopTimestamp();

    long getTotalTime();

    boolean hasActiveTime();

    boolean hasAppPackageName();

    boolean hasAppTtff();

    boolean hasErrorCode();

    boolean hasForegroundTime();

    boolean hasHasNavReq();

    boolean hasLocationProvider();

    boolean hasLocationReceived();

    boolean hasRequestInterval();

    boolean hasStartTimestamp();

    boolean hasStopTimestamp();

    boolean hasTotalTime();
}
