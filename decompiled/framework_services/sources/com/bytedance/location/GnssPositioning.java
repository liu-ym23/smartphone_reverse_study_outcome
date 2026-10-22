package com.bytedance.location;

import com.bytedance.location.protobuf.AbstractMessageLite;
import com.bytedance.location.protobuf.ByteString;
import com.bytedance.location.protobuf.CodedInputStream;
import com.bytedance.location.protobuf.ExtensionRegistryLite;
import com.bytedance.location.protobuf.GeneratedMessageLite;
import com.bytedance.location.protobuf.Internal;
import com.bytedance.location.protobuf.InvalidProtocolBufferException;
import com.bytedance.location.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class GnssPositioning extends GeneratedMessageLite<GnssPositioning, Builder> implements GnssPositioningOrBuilder {
    private static final GnssPositioning DEFAULT_INSTANCE = null;
    public static final int GLP_TTFF_FIELD_NUMBER = 8;
    public static final int GNSS_ERROR_CODE_FIELD_NUMBER = 10;
    public static final int GNSS_FIX_CNT_FIELD_NUMBER = 7;
    public static final int GNSS_REPORT_INTERVAL_FIELD_NUMBER = 6;
    public static final int GNSS_TTFF_CN0_FIELD_NUMBER = 9;
    public static final int LOSE_LOCATION_CN0_FIELD_NUMBER = 12;
    public static final int LOSE_LOCATION_TIMESTAMP_FIELD_NUMBER = 11;
    public static final int NMEA_RMC_FIELD_NUMBER = 15;
    public static final int NO_GNSS_SIGNAL_TIME_FIELD_NUMBER = 3;
    private static volatile Parser<GnssPositioning> PARSER = null;
    public static final int RESUME_LOCATION_CN0_FIELD_NUMBER = 14;
    public static final int RESUME_LOCATION_TIMESTAMP_FIELD_NUMBER = 13;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 1;
    public static final int STOP_TIMESTAMP_FIELD_NUMBER = 2;
    public static final int STRONG_GNSS_SIGNAL_TIME_FIELD_NUMBER = 5;
    public static final int WEAK_GNSS_SIGNAL_TIME_FIELD_NUMBER = 4;
    private int bitField0_;
    private int glpTtff_;
    private int gnssErrorCode_;
    private int gnssFixCnt_;
    private int gnssReportInterval_;
    private Internal.FloatList gnssTtffCn0_;
    private Internal.FloatList loseLocationCn0_;
    private Internal.LongList loseLocationTimestamp_;
    private Internal.ProtobufList<String> nmeaRmc_;
    private long noGnssSignalTime_;
    private Internal.FloatList resumeLocationCn0_;
    private Internal.LongList resumeLocationTimestamp_;
    private long startTimestamp_;
    private long stopTimestamp_;
    private long strongGnssSignalTime_;
    private long weakGnssSignalTime_;

    /* JADX INFO: renamed from: com.bytedance.location.GnssPositioning$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = null;

        static {
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L35:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L27:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L25:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L29:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GnssPositioning, Builder> implements GnssPositioningOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(GnssPositioning.access$000());
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasStartTimestamp() {
            return ((GnssPositioning) this.instance).hasStartTimestamp();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public long getStartTimestamp() {
            return ((GnssPositioning) this.instance).getStartTimestamp();
        }

        public Builder setStartTimestamp(long value) {
            copyOnWrite();
            GnssPositioning.access$100((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearStartTimestamp() {
            copyOnWrite();
            GnssPositioning.access$200((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasStopTimestamp() {
            return ((GnssPositioning) this.instance).hasStopTimestamp();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public long getStopTimestamp() {
            return ((GnssPositioning) this.instance).getStopTimestamp();
        }

        public Builder setStopTimestamp(long value) {
            copyOnWrite();
            GnssPositioning.access$300((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearStopTimestamp() {
            copyOnWrite();
            GnssPositioning.access$400((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasNoGnssSignalTime() {
            return ((GnssPositioning) this.instance).hasNoGnssSignalTime();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public long getNoGnssSignalTime() {
            return ((GnssPositioning) this.instance).getNoGnssSignalTime();
        }

        public Builder setNoGnssSignalTime(long value) {
            copyOnWrite();
            GnssPositioning.access$500((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearNoGnssSignalTime() {
            copyOnWrite();
            GnssPositioning.access$600((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasWeakGnssSignalTime() {
            return ((GnssPositioning) this.instance).hasWeakGnssSignalTime();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public long getWeakGnssSignalTime() {
            return ((GnssPositioning) this.instance).getWeakGnssSignalTime();
        }

        public Builder setWeakGnssSignalTime(long value) {
            copyOnWrite();
            GnssPositioning.access$700((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearWeakGnssSignalTime() {
            copyOnWrite();
            GnssPositioning.access$800((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasStrongGnssSignalTime() {
            return ((GnssPositioning) this.instance).hasStrongGnssSignalTime();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public long getStrongGnssSignalTime() {
            return ((GnssPositioning) this.instance).getStrongGnssSignalTime();
        }

        public Builder setStrongGnssSignalTime(long value) {
            copyOnWrite();
            GnssPositioning.access$900((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearStrongGnssSignalTime() {
            copyOnWrite();
            GnssPositioning.access$1000((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasGnssReportInterval() {
            return ((GnssPositioning) this.instance).hasGnssReportInterval();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getGnssReportInterval() {
            return ((GnssPositioning) this.instance).getGnssReportInterval();
        }

        public Builder setGnssReportInterval(int value) {
            copyOnWrite();
            GnssPositioning.access$1100((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearGnssReportInterval() {
            copyOnWrite();
            GnssPositioning.access$1200((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasGnssFixCnt() {
            return ((GnssPositioning) this.instance).hasGnssFixCnt();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getGnssFixCnt() {
            return ((GnssPositioning) this.instance).getGnssFixCnt();
        }

        public Builder setGnssFixCnt(int value) {
            copyOnWrite();
            GnssPositioning.access$1300((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearGnssFixCnt() {
            copyOnWrite();
            GnssPositioning.access$1400((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasGlpTtff() {
            return ((GnssPositioning) this.instance).hasGlpTtff();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getGlpTtff() {
            return ((GnssPositioning) this.instance).getGlpTtff();
        }

        public Builder setGlpTtff(int value) {
            copyOnWrite();
            GnssPositioning.access$1500((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearGlpTtff() {
            copyOnWrite();
            GnssPositioning.access$1600((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public List<Float> getGnssTtffCn0List() {
            return Collections.unmodifiableList(((GnssPositioning) this.instance).getGnssTtffCn0List());
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getGnssTtffCn0Count() {
            return ((GnssPositioning) this.instance).getGnssTtffCn0Count();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public float getGnssTtffCn0(int index) {
            return ((GnssPositioning) this.instance).getGnssTtffCn0(index);
        }

        public Builder setGnssTtffCn0(int index, float value) {
            copyOnWrite();
            GnssPositioning.access$1700((GnssPositioning) this.instance, index, value);
            return this;
        }

        public Builder addGnssTtffCn0(float value) {
            copyOnWrite();
            GnssPositioning.access$1800((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder addAllGnssTtffCn0(Iterable<? extends Float> values) {
            copyOnWrite();
            GnssPositioning.access$1900((GnssPositioning) this.instance, values);
            return this;
        }

        public Builder clearGnssTtffCn0() {
            copyOnWrite();
            GnssPositioning.access$2000((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public boolean hasGnssErrorCode() {
            return ((GnssPositioning) this.instance).hasGnssErrorCode();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getGnssErrorCode() {
            return ((GnssPositioning) this.instance).getGnssErrorCode();
        }

        public Builder setGnssErrorCode(int value) {
            copyOnWrite();
            GnssPositioning.access$2100((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder clearGnssErrorCode() {
            copyOnWrite();
            GnssPositioning.access$2200((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public List<Long> getLoseLocationTimestampList() {
            return Collections.unmodifiableList(((GnssPositioning) this.instance).getLoseLocationTimestampList());
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getLoseLocationTimestampCount() {
            return ((GnssPositioning) this.instance).getLoseLocationTimestampCount();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public long getLoseLocationTimestamp(int index) {
            return ((GnssPositioning) this.instance).getLoseLocationTimestamp(index);
        }

        public Builder setLoseLocationTimestamp(int index, long value) {
            copyOnWrite();
            GnssPositioning.access$2300((GnssPositioning) this.instance, index, value);
            return this;
        }

        public Builder addLoseLocationTimestamp(long value) {
            copyOnWrite();
            GnssPositioning.access$2400((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder addAllLoseLocationTimestamp(Iterable<? extends Long> values) {
            copyOnWrite();
            GnssPositioning.access$2500((GnssPositioning) this.instance, values);
            return this;
        }

        public Builder clearLoseLocationTimestamp() {
            copyOnWrite();
            GnssPositioning.access$2600((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public List<Float> getLoseLocationCn0List() {
            return Collections.unmodifiableList(((GnssPositioning) this.instance).getLoseLocationCn0List());
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getLoseLocationCn0Count() {
            return ((GnssPositioning) this.instance).getLoseLocationCn0Count();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public float getLoseLocationCn0(int index) {
            return ((GnssPositioning) this.instance).getLoseLocationCn0(index);
        }

        public Builder setLoseLocationCn0(int index, float value) {
            copyOnWrite();
            GnssPositioning.access$2700((GnssPositioning) this.instance, index, value);
            return this;
        }

        public Builder addLoseLocationCn0(float value) {
            copyOnWrite();
            GnssPositioning.access$2800((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder addAllLoseLocationCn0(Iterable<? extends Float> values) {
            copyOnWrite();
            GnssPositioning.access$2900((GnssPositioning) this.instance, values);
            return this;
        }

        public Builder clearLoseLocationCn0() {
            copyOnWrite();
            GnssPositioning.access$3000((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public List<Long> getResumeLocationTimestampList() {
            return Collections.unmodifiableList(((GnssPositioning) this.instance).getResumeLocationTimestampList());
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getResumeLocationTimestampCount() {
            return ((GnssPositioning) this.instance).getResumeLocationTimestampCount();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public long getResumeLocationTimestamp(int index) {
            return ((GnssPositioning) this.instance).getResumeLocationTimestamp(index);
        }

        public Builder setResumeLocationTimestamp(int index, long value) {
            copyOnWrite();
            GnssPositioning.access$3100((GnssPositioning) this.instance, index, value);
            return this;
        }

        public Builder addResumeLocationTimestamp(long value) {
            copyOnWrite();
            GnssPositioning.access$3200((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder addAllResumeLocationTimestamp(Iterable<? extends Long> values) {
            copyOnWrite();
            GnssPositioning.access$3300((GnssPositioning) this.instance, values);
            return this;
        }

        public Builder clearResumeLocationTimestamp() {
            copyOnWrite();
            GnssPositioning.access$3400((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public List<Float> getResumeLocationCn0List() {
            return Collections.unmodifiableList(((GnssPositioning) this.instance).getResumeLocationCn0List());
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getResumeLocationCn0Count() {
            return ((GnssPositioning) this.instance).getResumeLocationCn0Count();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public float getResumeLocationCn0(int index) {
            return ((GnssPositioning) this.instance).getResumeLocationCn0(index);
        }

        public Builder setResumeLocationCn0(int index, float value) {
            copyOnWrite();
            GnssPositioning.access$3500((GnssPositioning) this.instance, index, value);
            return this;
        }

        public Builder addResumeLocationCn0(float value) {
            copyOnWrite();
            GnssPositioning.access$3600((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder addAllResumeLocationCn0(Iterable<? extends Float> values) {
            copyOnWrite();
            GnssPositioning.access$3700((GnssPositioning) this.instance, values);
            return this;
        }

        public Builder clearResumeLocationCn0() {
            copyOnWrite();
            GnssPositioning.access$3800((GnssPositioning) this.instance);
            return this;
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public List<String> getNmeaRmcList() {
            return Collections.unmodifiableList(((GnssPositioning) this.instance).getNmeaRmcList());
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public int getNmeaRmcCount() {
            return ((GnssPositioning) this.instance).getNmeaRmcCount();
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public String getNmeaRmc(int index) {
            return ((GnssPositioning) this.instance).getNmeaRmc(index);
        }

        @Override // com.bytedance.location.GnssPositioningOrBuilder
        public ByteString getNmeaRmcBytes(int index) {
            return ((GnssPositioning) this.instance).getNmeaRmcBytes(index);
        }

        public Builder setNmeaRmc(int index, String value) {
            copyOnWrite();
            GnssPositioning.access$3900((GnssPositioning) this.instance, index, value);
            return this;
        }

        public Builder addNmeaRmc(String value) {
            copyOnWrite();
            GnssPositioning.access$4000((GnssPositioning) this.instance, value);
            return this;
        }

        public Builder addAllNmeaRmc(Iterable<String> values) {
            copyOnWrite();
            GnssPositioning.access$4100((GnssPositioning) this.instance, values);
            return this;
        }

        public Builder clearNmeaRmc() {
            copyOnWrite();
            GnssPositioning.access$4200((GnssPositioning) this.instance);
            return this;
        }

        public Builder addNmeaRmcBytes(ByteString value) {
            copyOnWrite();
            GnssPositioning.access$4300((GnssPositioning) this.instance, value);
            return this;
        }
    }

    static /* synthetic */ GnssPositioning access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(GnssPositioning x0, long x1) {
        x0.setStartTimestamp(x1);
    }

    static /* synthetic */ void access$1000(GnssPositioning x0) {
        x0.clearStrongGnssSignalTime();
    }

    static /* synthetic */ void access$1100(GnssPositioning x0, int x1) {
        x0.setGnssReportInterval(x1);
    }

    static /* synthetic */ void access$1200(GnssPositioning x0) {
        x0.clearGnssReportInterval();
    }

    static /* synthetic */ void access$1300(GnssPositioning x0, int x1) {
        x0.setGnssFixCnt(x1);
    }

    static /* synthetic */ void access$1400(GnssPositioning x0) {
        x0.clearGnssFixCnt();
    }

    static /* synthetic */ void access$1500(GnssPositioning x0, int x1) {
        x0.setGlpTtff(x1);
    }

    static /* synthetic */ void access$1600(GnssPositioning x0) {
        x0.clearGlpTtff();
    }

    static /* synthetic */ void access$1700(GnssPositioning x0, int x1, float x2) {
        x0.setGnssTtffCn0(x1, x2);
    }

    static /* synthetic */ void access$1800(GnssPositioning x0, float x1) {
        x0.addGnssTtffCn0(x1);
    }

    static /* synthetic */ void access$1900(GnssPositioning x0, Iterable x1) {
        x0.addAllGnssTtffCn0(x1);
    }

    static /* synthetic */ void access$200(GnssPositioning x0) {
        x0.clearStartTimestamp();
    }

    static /* synthetic */ void access$2000(GnssPositioning x0) {
        x0.clearGnssTtffCn0();
    }

    static /* synthetic */ void access$2100(GnssPositioning x0, int x1) {
        x0.setGnssErrorCode(x1);
    }

    static /* synthetic */ void access$2200(GnssPositioning x0) {
        x0.clearGnssErrorCode();
    }

    static /* synthetic */ void access$2300(GnssPositioning x0, int x1, long x2) {
        x0.setLoseLocationTimestamp(x1, x2);
    }

    static /* synthetic */ void access$2400(GnssPositioning x0, long x1) {
        x0.addLoseLocationTimestamp(x1);
    }

    static /* synthetic */ void access$2500(GnssPositioning x0, Iterable x1) {
        x0.addAllLoseLocationTimestamp(x1);
    }

    static /* synthetic */ void access$2600(GnssPositioning x0) {
        x0.clearLoseLocationTimestamp();
    }

    static /* synthetic */ void access$2700(GnssPositioning x0, int x1, float x2) {
        x0.setLoseLocationCn0(x1, x2);
    }

    static /* synthetic */ void access$2800(GnssPositioning x0, float x1) {
        x0.addLoseLocationCn0(x1);
    }

    static /* synthetic */ void access$2900(GnssPositioning x0, Iterable x1) {
        x0.addAllLoseLocationCn0(x1);
    }

    static /* synthetic */ void access$300(GnssPositioning x0, long x1) {
        x0.setStopTimestamp(x1);
    }

    static /* synthetic */ void access$3000(GnssPositioning x0) {
        x0.clearLoseLocationCn0();
    }

    static /* synthetic */ void access$3100(GnssPositioning x0, int x1, long x2) {
        x0.setResumeLocationTimestamp(x1, x2);
    }

    static /* synthetic */ void access$3200(GnssPositioning x0, long x1) {
        x0.addResumeLocationTimestamp(x1);
    }

    static /* synthetic */ void access$3300(GnssPositioning x0, Iterable x1) {
        x0.addAllResumeLocationTimestamp(x1);
    }

    static /* synthetic */ void access$3400(GnssPositioning x0) {
        x0.clearResumeLocationTimestamp();
    }

    static /* synthetic */ void access$3500(GnssPositioning x0, int x1, float x2) {
        x0.setResumeLocationCn0(x1, x2);
    }

    static /* synthetic */ void access$3600(GnssPositioning x0, float x1) {
        x0.addResumeLocationCn0(x1);
    }

    static /* synthetic */ void access$3700(GnssPositioning x0, Iterable x1) {
        x0.addAllResumeLocationCn0(x1);
    }

    static /* synthetic */ void access$3800(GnssPositioning x0) {
        x0.clearResumeLocationCn0();
    }

    static /* synthetic */ void access$3900(GnssPositioning x0, int x1, String x2) {
        x0.setNmeaRmc(x1, x2);
    }

    static /* synthetic */ void access$400(GnssPositioning x0) {
        x0.clearStopTimestamp();
    }

    static /* synthetic */ void access$4000(GnssPositioning x0, String x1) {
        x0.addNmeaRmc(x1);
    }

    static /* synthetic */ void access$4100(GnssPositioning x0, Iterable x1) {
        x0.addAllNmeaRmc(x1);
    }

    static /* synthetic */ void access$4200(GnssPositioning x0) {
        x0.clearNmeaRmc();
    }

    static /* synthetic */ void access$4300(GnssPositioning x0, ByteString x1) {
        x0.addNmeaRmcBytes(x1);
    }

    static /* synthetic */ void access$500(GnssPositioning x0, long x1) {
        x0.setNoGnssSignalTime(x1);
    }

    static /* synthetic */ void access$600(GnssPositioning x0) {
        x0.clearNoGnssSignalTime();
    }

    static /* synthetic */ void access$700(GnssPositioning x0, long x1) {
        x0.setWeakGnssSignalTime(x1);
    }

    static /* synthetic */ void access$800(GnssPositioning x0) {
        x0.clearWeakGnssSignalTime();
    }

    static /* synthetic */ void access$900(GnssPositioning x0, long x1) {
        x0.setStrongGnssSignalTime(x1);
    }

    private GnssPositioning() {
        this.gnssTtffCn0_ = GeneratedMessageLite.emptyFloatList();
        this.loseLocationTimestamp_ = GeneratedMessageLite.emptyLongList();
        this.loseLocationCn0_ = GeneratedMessageLite.emptyFloatList();
        this.resumeLocationTimestamp_ = GeneratedMessageLite.emptyLongList();
        this.resumeLocationCn0_ = GeneratedMessageLite.emptyFloatList();
        this.nmeaRmc_ = GeneratedMessageLite.emptyProtobufList();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasStartTimestamp() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public long getStartTimestamp() {
        return this.startTimestamp_;
    }

    private void setStartTimestamp(long value) {
        this.bitField0_ |= 1;
        this.startTimestamp_ = value;
    }

    private void clearStartTimestamp() {
        this.bitField0_ &= -2;
        this.startTimestamp_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasStopTimestamp() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public long getStopTimestamp() {
        return this.stopTimestamp_;
    }

    private void setStopTimestamp(long value) {
        this.bitField0_ |= 2;
        this.stopTimestamp_ = value;
    }

    private void clearStopTimestamp() {
        this.bitField0_ &= -3;
        this.stopTimestamp_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasNoGnssSignalTime() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public long getNoGnssSignalTime() {
        return this.noGnssSignalTime_;
    }

    private void setNoGnssSignalTime(long value) {
        this.bitField0_ |= 4;
        this.noGnssSignalTime_ = value;
    }

    private void clearNoGnssSignalTime() {
        this.bitField0_ &= -5;
        this.noGnssSignalTime_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasWeakGnssSignalTime() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public long getWeakGnssSignalTime() {
        return this.weakGnssSignalTime_;
    }

    private void setWeakGnssSignalTime(long value) {
        this.bitField0_ |= 8;
        this.weakGnssSignalTime_ = value;
    }

    private void clearWeakGnssSignalTime() {
        this.bitField0_ &= -9;
        this.weakGnssSignalTime_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasStrongGnssSignalTime() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public long getStrongGnssSignalTime() {
        return this.strongGnssSignalTime_;
    }

    private void setStrongGnssSignalTime(long value) {
        this.bitField0_ |= 16;
        this.strongGnssSignalTime_ = value;
    }

    private void clearStrongGnssSignalTime() {
        this.bitField0_ &= -17;
        this.strongGnssSignalTime_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasGnssReportInterval() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getGnssReportInterval() {
        return this.gnssReportInterval_;
    }

    private void setGnssReportInterval(int value) {
        this.bitField0_ |= 32;
        this.gnssReportInterval_ = value;
    }

    private void clearGnssReportInterval() {
        this.bitField0_ &= -33;
        this.gnssReportInterval_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasGnssFixCnt() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getGnssFixCnt() {
        return this.gnssFixCnt_;
    }

    private void setGnssFixCnt(int value) {
        this.bitField0_ |= 64;
        this.gnssFixCnt_ = value;
    }

    private void clearGnssFixCnt() {
        this.bitField0_ &= -65;
        this.gnssFixCnt_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasGlpTtff() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getGlpTtff() {
        return this.glpTtff_;
    }

    private void setGlpTtff(int value) {
        this.bitField0_ |= 128;
        this.glpTtff_ = value;
    }

    private void clearGlpTtff() {
        this.bitField0_ &= -129;
        this.glpTtff_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public List<Float> getGnssTtffCn0List() {
        return this.gnssTtffCn0_;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getGnssTtffCn0Count() {
        return this.gnssTtffCn0_.size();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public float getGnssTtffCn0(int index) {
        return this.gnssTtffCn0_.getFloat(index);
    }

    private void ensureGnssTtffCn0IsMutable() {
        Internal.FloatList tmp = this.gnssTtffCn0_;
        if (tmp.isModifiable() == true) goto L6;
        this.gnssTtffCn0_ = GeneratedMessageLite.mutableCopy(tmp);
        return;
    }

    private void setGnssTtffCn0(int index, float value) {
        ensureGnssTtffCn0IsMutable();
        this.gnssTtffCn0_.setFloat(index, value);
    }

    private void addGnssTtffCn0(float value) {
        ensureGnssTtffCn0IsMutable();
        this.gnssTtffCn0_.addFloat(value);
    }

    private void addAllGnssTtffCn0(Iterable<? extends Float> values) {
        ensureGnssTtffCn0IsMutable();
        AbstractMessageLite.addAll(values, this.gnssTtffCn0_);
    }

    private void clearGnssTtffCn0() {
        this.gnssTtffCn0_ = GeneratedMessageLite.emptyFloatList();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public boolean hasGnssErrorCode() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getGnssErrorCode() {
        return this.gnssErrorCode_;
    }

    private void setGnssErrorCode(int value) {
        this.bitField0_ |= 256;
        this.gnssErrorCode_ = value;
    }

    private void clearGnssErrorCode() {
        this.bitField0_ &= -257;
        this.gnssErrorCode_ = 0;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public List<Long> getLoseLocationTimestampList() {
        return this.loseLocationTimestamp_;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getLoseLocationTimestampCount() {
        return this.loseLocationTimestamp_.size();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public long getLoseLocationTimestamp(int index) {
        return this.loseLocationTimestamp_.getLong(index);
    }

    private void ensureLoseLocationTimestampIsMutable() {
        Internal.LongList tmp = this.loseLocationTimestamp_;
        if (tmp.isModifiable() == true) goto L6;
        this.loseLocationTimestamp_ = GeneratedMessageLite.mutableCopy(tmp);
        return;
    }

    private void setLoseLocationTimestamp(int index, long value) {
        ensureLoseLocationTimestampIsMutable();
        this.loseLocationTimestamp_.setLong(index, value);
    }

    private void addLoseLocationTimestamp(long value) {
        ensureLoseLocationTimestampIsMutable();
        this.loseLocationTimestamp_.addLong(value);
    }

    private void addAllLoseLocationTimestamp(Iterable<? extends Long> values) {
        ensureLoseLocationTimestampIsMutable();
        AbstractMessageLite.addAll(values, this.loseLocationTimestamp_);
    }

    private void clearLoseLocationTimestamp() {
        this.loseLocationTimestamp_ = GeneratedMessageLite.emptyLongList();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public List<Float> getLoseLocationCn0List() {
        return this.loseLocationCn0_;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getLoseLocationCn0Count() {
        return this.loseLocationCn0_.size();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public float getLoseLocationCn0(int index) {
        return this.loseLocationCn0_.getFloat(index);
    }

    private void ensureLoseLocationCn0IsMutable() {
        Internal.FloatList tmp = this.loseLocationCn0_;
        if (tmp.isModifiable() == true) goto L6;
        this.loseLocationCn0_ = GeneratedMessageLite.mutableCopy(tmp);
        return;
    }

    private void setLoseLocationCn0(int index, float value) {
        ensureLoseLocationCn0IsMutable();
        this.loseLocationCn0_.setFloat(index, value);
    }

    private void addLoseLocationCn0(float value) {
        ensureLoseLocationCn0IsMutable();
        this.loseLocationCn0_.addFloat(value);
    }

    private void addAllLoseLocationCn0(Iterable<? extends Float> values) {
        ensureLoseLocationCn0IsMutable();
        AbstractMessageLite.addAll(values, this.loseLocationCn0_);
    }

    private void clearLoseLocationCn0() {
        this.loseLocationCn0_ = GeneratedMessageLite.emptyFloatList();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public List<Long> getResumeLocationTimestampList() {
        return this.resumeLocationTimestamp_;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getResumeLocationTimestampCount() {
        return this.resumeLocationTimestamp_.size();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public long getResumeLocationTimestamp(int index) {
        return this.resumeLocationTimestamp_.getLong(index);
    }

    private void ensureResumeLocationTimestampIsMutable() {
        Internal.LongList tmp = this.resumeLocationTimestamp_;
        if (tmp.isModifiable() == true) goto L6;
        this.resumeLocationTimestamp_ = GeneratedMessageLite.mutableCopy(tmp);
        return;
    }

    private void setResumeLocationTimestamp(int index, long value) {
        ensureResumeLocationTimestampIsMutable();
        this.resumeLocationTimestamp_.setLong(index, value);
    }

    private void addResumeLocationTimestamp(long value) {
        ensureResumeLocationTimestampIsMutable();
        this.resumeLocationTimestamp_.addLong(value);
    }

    private void addAllResumeLocationTimestamp(Iterable<? extends Long> values) {
        ensureResumeLocationTimestampIsMutable();
        AbstractMessageLite.addAll(values, this.resumeLocationTimestamp_);
    }

    private void clearResumeLocationTimestamp() {
        this.resumeLocationTimestamp_ = GeneratedMessageLite.emptyLongList();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public List<Float> getResumeLocationCn0List() {
        return this.resumeLocationCn0_;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getResumeLocationCn0Count() {
        return this.resumeLocationCn0_.size();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public float getResumeLocationCn0(int index) {
        return this.resumeLocationCn0_.getFloat(index);
    }

    private void ensureResumeLocationCn0IsMutable() {
        Internal.FloatList tmp = this.resumeLocationCn0_;
        if (tmp.isModifiable() == true) goto L6;
        this.resumeLocationCn0_ = GeneratedMessageLite.mutableCopy(tmp);
        return;
    }

    private void setResumeLocationCn0(int index, float value) {
        ensureResumeLocationCn0IsMutable();
        this.resumeLocationCn0_.setFloat(index, value);
    }

    private void addResumeLocationCn0(float value) {
        ensureResumeLocationCn0IsMutable();
        this.resumeLocationCn0_.addFloat(value);
    }

    private void addAllResumeLocationCn0(Iterable<? extends Float> values) {
        ensureResumeLocationCn0IsMutable();
        AbstractMessageLite.addAll(values, this.resumeLocationCn0_);
    }

    private void clearResumeLocationCn0() {
        this.resumeLocationCn0_ = GeneratedMessageLite.emptyFloatList();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public List<String> getNmeaRmcList() {
        return this.nmeaRmc_;
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public int getNmeaRmcCount() {
        return this.nmeaRmc_.size();
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public String getNmeaRmc(int index) {
        return this.nmeaRmc_.get(index);
    }

    @Override // com.bytedance.location.GnssPositioningOrBuilder
    public ByteString getNmeaRmcBytes(int index) {
        return ByteString.copyFromUtf8(this.nmeaRmc_.get(index));
    }

    private void ensureNmeaRmcIsMutable() {
        Internal.ProtobufList<String> tmp = this.nmeaRmc_;
        if (tmp.isModifiable() == true) goto L6;
        this.nmeaRmc_ = GeneratedMessageLite.mutableCopy(tmp);
        return;
    }

    private void setNmeaRmc(int index, String value) {
        value.getClass();
        ensureNmeaRmcIsMutable();
        this.nmeaRmc_.set(index, value);
    }

    private void addNmeaRmc(String value) {
        value.getClass();
        ensureNmeaRmcIsMutable();
        this.nmeaRmc_.add(value);
    }

    private void addAllNmeaRmc(Iterable<String> values) {
        ensureNmeaRmcIsMutable();
        AbstractMessageLite.addAll(values, this.nmeaRmc_);
    }

    private void clearNmeaRmc() {
        this.nmeaRmc_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void addNmeaRmcBytes(ByteString value) {
        ensureNmeaRmcIsMutable();
        this.nmeaRmc_.add(value.toStringUtf8());
    }

    public static GnssPositioning parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static GnssPositioning parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static GnssPositioning parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static GnssPositioning parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static GnssPositioning parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static GnssPositioning parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static GnssPositioning parseFrom(InputStream input) throws IOException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static GnssPositioning parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static GnssPositioning parseDelimitedFrom(InputStream input) throws IOException {
        return (GnssPositioning) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static GnssPositioning parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (GnssPositioning) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static GnssPositioning parseFrom(CodedInputStream input) throws IOException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static GnssPositioning parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (GnssPositioning) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(GnssPositioning prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    @Override // com.bytedance.location.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        AnonymousClass1 r1 = null;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L9:
        Parser<GnssPositioning> parser = PARSER;
        if (parser == null) goto L12;
    L22:
        return parser;
    L12:
        monitor-enter(GnssPositioning.class);
        parser = PARSER;     // Catch: Throwable -> L16
        if (parser != null) goto L18;
        parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L16
        PARSER = parser;     // Catch: Throwable -> L16
    L18:
        monitor-exit(GnssPositioning.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L25:
        Object[] objects = {"bitField0_", "startTimestamp_", "stopTimestamp_", "noGnssSignalTime_", "weakGnssSignalTime_", "strongGnssSignalTime_", "gnssReportInterval_", "gnssFixCnt_", "glpTtff_", "gnssTtffCn0_", "gnssErrorCode_", "loseLocationTimestamp_", "loseLocationCn0_", "resumeLocationTimestamp_", "resumeLocationCn0_", "nmeaRmc_"};
        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0006\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဋ\u0005\u0007ဋ\u0006\bဋ\u0007\t\u0013\nဋ\b\u000b\u0015\f\u0013\r\u0015\u000e\u0013\u000f\u001a", objects);
    L5:
        throw new UnsupportedOperationException();
    L8:
        return (byte) 1;
    L24:
        return DEFAULT_INSTANCE;
    L28:
        return new Builder(r1);
    L30:
        return new GnssPositioning();
    }

    static {
        GnssPositioning defaultInstance = new GnssPositioning();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(GnssPositioning.class, defaultInstance);
    }

    public static GnssPositioning getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<GnssPositioning> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
