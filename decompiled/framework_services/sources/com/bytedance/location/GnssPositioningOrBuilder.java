package com.bytedance.location;

import com.bytedance.location.protobuf.ByteString;
import com.bytedance.location.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface GnssPositioningOrBuilder extends MessageLiteOrBuilder {
    int getGlpTtff();

    int getGnssErrorCode();

    int getGnssFixCnt();

    int getGnssReportInterval();

    float getGnssTtffCn0(int r1);

    int getGnssTtffCn0Count();

    List<Float> getGnssTtffCn0List();

    float getLoseLocationCn0(int r1);

    int getLoseLocationCn0Count();

    List<Float> getLoseLocationCn0List();

    long getLoseLocationTimestamp(int r1);

    int getLoseLocationTimestampCount();

    List<Long> getLoseLocationTimestampList();

    String getNmeaRmc(int r1);

    ByteString getNmeaRmcBytes(int r1);

    int getNmeaRmcCount();

    List<String> getNmeaRmcList();

    long getNoGnssSignalTime();

    float getResumeLocationCn0(int r1);

    int getResumeLocationCn0Count();

    List<Float> getResumeLocationCn0List();

    long getResumeLocationTimestamp(int r1);

    int getResumeLocationTimestampCount();

    List<Long> getResumeLocationTimestampList();

    long getStartTimestamp();

    long getStopTimestamp();

    long getStrongGnssSignalTime();

    long getWeakGnssSignalTime();

    boolean hasGlpTtff();

    boolean hasGnssErrorCode();

    boolean hasGnssFixCnt();

    boolean hasGnssReportInterval();

    boolean hasNoGnssSignalTime();

    boolean hasStartTimestamp();

    boolean hasStopTimestamp();

    boolean hasStrongGnssSignalTime();

    boolean hasWeakGnssSignalTime();
}
