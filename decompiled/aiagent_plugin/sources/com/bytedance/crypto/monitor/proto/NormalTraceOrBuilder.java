package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface NormalTraceOrBuilder extends MessageOrBuilder {
    String getAppId();

    ByteString getAppIdBytes();

    int getErrCode();

    int getEventId();

    int getModuleId();

    String getPackageName();

    ByteString getPackageNameBytes();

    long getTimeConsumption();

    int getTotalCalls();

    long getTotalDataSize();

    int getUserid();

    boolean hasAppId();

    boolean hasErrCode();

    boolean hasEventId();

    boolean hasModuleId();

    boolean hasPackageName();

    boolean hasTimeConsumption();

    boolean hasTotalCalls();

    boolean hasTotalDataSize();

    boolean hasUserid();
}
