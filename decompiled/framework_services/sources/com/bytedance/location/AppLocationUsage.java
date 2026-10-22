package com.bytedance.location;

import com.bytedance.location.protobuf.ByteString;
import com.bytedance.location.protobuf.CodedInputStream;
import com.bytedance.location.protobuf.ExtensionRegistryLite;
import com.bytedance.location.protobuf.GeneratedMessageLite;
import com.bytedance.location.protobuf.InvalidProtocolBufferException;
import com.bytedance.location.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class AppLocationUsage extends GeneratedMessageLite<AppLocationUsage, Builder> implements AppLocationUsageOrBuilder {
    public static final int ACTIVE_TIME_FIELD_NUMBER = 7;
    public static final int APP_PACKAGE_NAME_FIELD_NUMBER = 3;
    public static final int APP_TTFF_FIELD_NUMBER = 9;
    private static final AppLocationUsage DEFAULT_INSTANCE = null;
    public static final int ERROR_CODE_FIELD_NUMBER = 11;
    public static final int FOREGROUND_TIME_FIELD_NUMBER = 8;
    public static final int HAS_NAV_REQ_FIELD_NUMBER = 12;
    public static final int LOCATION_PROVIDER_FIELD_NUMBER = 4;
    public static final int LOCATION_RECEIVED_FIELD_NUMBER = 10;
    private static volatile Parser<AppLocationUsage> PARSER = null;
    public static final int REQUEST_INTERVAL_FIELD_NUMBER = 5;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 1;
    public static final int STOP_TIMESTAMP_FIELD_NUMBER = 2;
    public static final int TOTAL_TIME_FIELD_NUMBER = 6;
    private long activeTime_;
    private String appPackageName_;
    private long appTtff_;
    private int bitField0_;
    private int errorCode_;
    private long foregroundTime_;
    private boolean hasNavReq_;
    private String locationProvider_;
    private int locationReceived_;
    private long requestInterval_;
    private long startTimestamp_;
    private long stopTimestamp_;
    private long totalTime_;

    /* JADX INFO: renamed from: com.bytedance.location.AppLocationUsage$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AppLocationUsage, Builder> implements AppLocationUsageOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AppLocationUsage.access$000());
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasStartTimestamp() {
            return ((AppLocationUsage) this.instance).hasStartTimestamp();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public long getStartTimestamp() {
            return ((AppLocationUsage) this.instance).getStartTimestamp();
        }

        public Builder setStartTimestamp(long value) {
            copyOnWrite();
            AppLocationUsage.access$100((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearStartTimestamp() {
            copyOnWrite();
            AppLocationUsage.access$200((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasStopTimestamp() {
            return ((AppLocationUsage) this.instance).hasStopTimestamp();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public long getStopTimestamp() {
            return ((AppLocationUsage) this.instance).getStopTimestamp();
        }

        public Builder setStopTimestamp(long value) {
            copyOnWrite();
            AppLocationUsage.access$300((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearStopTimestamp() {
            copyOnWrite();
            AppLocationUsage.access$400((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasAppPackageName() {
            return ((AppLocationUsage) this.instance).hasAppPackageName();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public String getAppPackageName() {
            return ((AppLocationUsage) this.instance).getAppPackageName();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public ByteString getAppPackageNameBytes() {
            return ((AppLocationUsage) this.instance).getAppPackageNameBytes();
        }

        public Builder setAppPackageName(String value) {
            copyOnWrite();
            AppLocationUsage.access$500((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearAppPackageName() {
            copyOnWrite();
            AppLocationUsage.access$600((AppLocationUsage) this.instance);
            return this;
        }

        public Builder setAppPackageNameBytes(ByteString value) {
            copyOnWrite();
            AppLocationUsage.access$700((AppLocationUsage) this.instance, value);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasLocationProvider() {
            return ((AppLocationUsage) this.instance).hasLocationProvider();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public String getLocationProvider() {
            return ((AppLocationUsage) this.instance).getLocationProvider();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public ByteString getLocationProviderBytes() {
            return ((AppLocationUsage) this.instance).getLocationProviderBytes();
        }

        public Builder setLocationProvider(String value) {
            copyOnWrite();
            AppLocationUsage.access$800((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearLocationProvider() {
            copyOnWrite();
            AppLocationUsage.access$900((AppLocationUsage) this.instance);
            return this;
        }

        public Builder setLocationProviderBytes(ByteString value) {
            copyOnWrite();
            AppLocationUsage.access$1000((AppLocationUsage) this.instance, value);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasRequestInterval() {
            return ((AppLocationUsage) this.instance).hasRequestInterval();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public long getRequestInterval() {
            return ((AppLocationUsage) this.instance).getRequestInterval();
        }

        public Builder setRequestInterval(long value) {
            copyOnWrite();
            AppLocationUsage.access$1100((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearRequestInterval() {
            copyOnWrite();
            AppLocationUsage.access$1200((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasTotalTime() {
            return ((AppLocationUsage) this.instance).hasTotalTime();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public long getTotalTime() {
            return ((AppLocationUsage) this.instance).getTotalTime();
        }

        public Builder setTotalTime(long value) {
            copyOnWrite();
            AppLocationUsage.access$1300((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearTotalTime() {
            copyOnWrite();
            AppLocationUsage.access$1400((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasActiveTime() {
            return ((AppLocationUsage) this.instance).hasActiveTime();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public long getActiveTime() {
            return ((AppLocationUsage) this.instance).getActiveTime();
        }

        public Builder setActiveTime(long value) {
            copyOnWrite();
            AppLocationUsage.access$1500((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearActiveTime() {
            copyOnWrite();
            AppLocationUsage.access$1600((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasForegroundTime() {
            return ((AppLocationUsage) this.instance).hasForegroundTime();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public long getForegroundTime() {
            return ((AppLocationUsage) this.instance).getForegroundTime();
        }

        public Builder setForegroundTime(long value) {
            copyOnWrite();
            AppLocationUsage.access$1700((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearForegroundTime() {
            copyOnWrite();
            AppLocationUsage.access$1800((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasAppTtff() {
            return ((AppLocationUsage) this.instance).hasAppTtff();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public long getAppTtff() {
            return ((AppLocationUsage) this.instance).getAppTtff();
        }

        public Builder setAppTtff(long value) {
            copyOnWrite();
            AppLocationUsage.access$1900((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearAppTtff() {
            copyOnWrite();
            AppLocationUsage.access$2000((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasLocationReceived() {
            return ((AppLocationUsage) this.instance).hasLocationReceived();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public int getLocationReceived() {
            return ((AppLocationUsage) this.instance).getLocationReceived();
        }

        public Builder setLocationReceived(int value) {
            copyOnWrite();
            AppLocationUsage.access$2100((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearLocationReceived() {
            copyOnWrite();
            AppLocationUsage.access$2200((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasErrorCode() {
            return ((AppLocationUsage) this.instance).hasErrorCode();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public int getErrorCode() {
            return ((AppLocationUsage) this.instance).getErrorCode();
        }

        public Builder setErrorCode(int value) {
            copyOnWrite();
            AppLocationUsage.access$2300((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearErrorCode() {
            copyOnWrite();
            AppLocationUsage.access$2400((AppLocationUsage) this.instance);
            return this;
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean hasHasNavReq() {
            return ((AppLocationUsage) this.instance).hasHasNavReq();
        }

        @Override // com.bytedance.location.AppLocationUsageOrBuilder
        public boolean getHasNavReq() {
            return ((AppLocationUsage) this.instance).getHasNavReq();
        }

        public Builder setHasNavReq(boolean value) {
            copyOnWrite();
            AppLocationUsage.access$2500((AppLocationUsage) this.instance, value);
            return this;
        }

        public Builder clearHasNavReq() {
            copyOnWrite();
            AppLocationUsage.access$2600((AppLocationUsage) this.instance);
            return this;
        }
    }

    static /* synthetic */ AppLocationUsage access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(AppLocationUsage x0, long x1) {
        x0.setStartTimestamp(x1);
    }

    static /* synthetic */ void access$1000(AppLocationUsage x0, ByteString x1) {
        x0.setLocationProviderBytes(x1);
    }

    static /* synthetic */ void access$1100(AppLocationUsage x0, long x1) {
        x0.setRequestInterval(x1);
    }

    static /* synthetic */ void access$1200(AppLocationUsage x0) {
        x0.clearRequestInterval();
    }

    static /* synthetic */ void access$1300(AppLocationUsage x0, long x1) {
        x0.setTotalTime(x1);
    }

    static /* synthetic */ void access$1400(AppLocationUsage x0) {
        x0.clearTotalTime();
    }

    static /* synthetic */ void access$1500(AppLocationUsage x0, long x1) {
        x0.setActiveTime(x1);
    }

    static /* synthetic */ void access$1600(AppLocationUsage x0) {
        x0.clearActiveTime();
    }

    static /* synthetic */ void access$1700(AppLocationUsage x0, long x1) {
        x0.setForegroundTime(x1);
    }

    static /* synthetic */ void access$1800(AppLocationUsage x0) {
        x0.clearForegroundTime();
    }

    static /* synthetic */ void access$1900(AppLocationUsage x0, long x1) {
        x0.setAppTtff(x1);
    }

    static /* synthetic */ void access$200(AppLocationUsage x0) {
        x0.clearStartTimestamp();
    }

    static /* synthetic */ void access$2000(AppLocationUsage x0) {
        x0.clearAppTtff();
    }

    static /* synthetic */ void access$2100(AppLocationUsage x0, int x1) {
        x0.setLocationReceived(x1);
    }

    static /* synthetic */ void access$2200(AppLocationUsage x0) {
        x0.clearLocationReceived();
    }

    static /* synthetic */ void access$2300(AppLocationUsage x0, int x1) {
        x0.setErrorCode(x1);
    }

    static /* synthetic */ void access$2400(AppLocationUsage x0) {
        x0.clearErrorCode();
    }

    static /* synthetic */ void access$2500(AppLocationUsage x0, boolean x1) {
        x0.setHasNavReq(x1);
    }

    static /* synthetic */ void access$2600(AppLocationUsage x0) {
        x0.clearHasNavReq();
    }

    static /* synthetic */ void access$300(AppLocationUsage x0, long x1) {
        x0.setStopTimestamp(x1);
    }

    static /* synthetic */ void access$400(AppLocationUsage x0) {
        x0.clearStopTimestamp();
    }

    static /* synthetic */ void access$500(AppLocationUsage x0, String x1) {
        x0.setAppPackageName(x1);
    }

    static /* synthetic */ void access$600(AppLocationUsage x0) {
        x0.clearAppPackageName();
    }

    static /* synthetic */ void access$700(AppLocationUsage x0, ByteString x1) {
        x0.setAppPackageNameBytes(x1);
    }

    static /* synthetic */ void access$800(AppLocationUsage x0, String x1) {
        x0.setLocationProvider(x1);
    }

    static /* synthetic */ void access$900(AppLocationUsage x0) {
        x0.clearLocationProvider();
    }

    private AppLocationUsage() {
        this.appPackageName_ = "";
        this.locationProvider_ = "";
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasStartTimestamp() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
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

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasStopTimestamp() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
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

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasAppPackageName() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public String getAppPackageName() {
        return this.appPackageName_;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public ByteString getAppPackageNameBytes() {
        return ByteString.copyFromUtf8(this.appPackageName_);
    }

    private void setAppPackageName(String value) {
        value.getClass();
        this.bitField0_ |= 4;
        this.appPackageName_ = value;
    }

    private void clearAppPackageName() {
        this.bitField0_ &= -5;
        this.appPackageName_ = getDefaultInstance().getAppPackageName();
    }

    private void setAppPackageNameBytes(ByteString value) {
        this.appPackageName_ = value.toStringUtf8();
        this.bitField0_ |= 4;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasLocationProvider() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public String getLocationProvider() {
        return this.locationProvider_;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public ByteString getLocationProviderBytes() {
        return ByteString.copyFromUtf8(this.locationProvider_);
    }

    private void setLocationProvider(String value) {
        value.getClass();
        this.bitField0_ |= 8;
        this.locationProvider_ = value;
    }

    private void clearLocationProvider() {
        this.bitField0_ &= -9;
        this.locationProvider_ = getDefaultInstance().getLocationProvider();
    }

    private void setLocationProviderBytes(ByteString value) {
        this.locationProvider_ = value.toStringUtf8();
        this.bitField0_ |= 8;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasRequestInterval() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public long getRequestInterval() {
        return this.requestInterval_;
    }

    private void setRequestInterval(long value) {
        this.bitField0_ |= 16;
        this.requestInterval_ = value;
    }

    private void clearRequestInterval() {
        this.bitField0_ &= -17;
        this.requestInterval_ = 0;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasTotalTime() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public long getTotalTime() {
        return this.totalTime_;
    }

    private void setTotalTime(long value) {
        this.bitField0_ |= 32;
        this.totalTime_ = value;
    }

    private void clearTotalTime() {
        this.bitField0_ &= -33;
        this.totalTime_ = 0;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasActiveTime() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public long getActiveTime() {
        return this.activeTime_;
    }

    private void setActiveTime(long value) {
        this.bitField0_ |= 64;
        this.activeTime_ = value;
    }

    private void clearActiveTime() {
        this.bitField0_ &= -65;
        this.activeTime_ = 0;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasForegroundTime() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public long getForegroundTime() {
        return this.foregroundTime_;
    }

    private void setForegroundTime(long value) {
        this.bitField0_ |= 128;
        this.foregroundTime_ = value;
    }

    private void clearForegroundTime() {
        this.bitField0_ &= -129;
        this.foregroundTime_ = 0;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasAppTtff() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public long getAppTtff() {
        return this.appTtff_;
    }

    private void setAppTtff(long value) {
        this.bitField0_ |= 256;
        this.appTtff_ = value;
    }

    private void clearAppTtff() {
        this.bitField0_ &= -257;
        this.appTtff_ = 0;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasLocationReceived() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public int getLocationReceived() {
        return this.locationReceived_;
    }

    private void setLocationReceived(int value) {
        this.bitField0_ |= 512;
        this.locationReceived_ = value;
    }

    private void clearLocationReceived() {
        this.bitField0_ &= -513;
        this.locationReceived_ = 0;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasErrorCode() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public int getErrorCode() {
        return this.errorCode_;
    }

    private void setErrorCode(int value) {
        this.bitField0_ |= 1024;
        this.errorCode_ = value;
    }

    private void clearErrorCode() {
        this.bitField0_ &= -1025;
        this.errorCode_ = 0;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean hasHasNavReq() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.AppLocationUsageOrBuilder
    public boolean getHasNavReq() {
        return this.hasNavReq_;
    }

    private void setHasNavReq(boolean value) {
        this.bitField0_ |= 2048;
        this.hasNavReq_ = value;
    }

    private void clearHasNavReq() {
        this.bitField0_ &= -2049;
        this.hasNavReq_ = false;
    }

    public static AppLocationUsage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AppLocationUsage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AppLocationUsage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AppLocationUsage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AppLocationUsage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AppLocationUsage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AppLocationUsage parseFrom(InputStream input) throws IOException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AppLocationUsage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AppLocationUsage parseDelimitedFrom(InputStream input) throws IOException {
        return (AppLocationUsage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AppLocationUsage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AppLocationUsage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AppLocationUsage parseFrom(CodedInputStream input) throws IOException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AppLocationUsage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AppLocationUsage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AppLocationUsage prototype) {
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
        Parser<AppLocationUsage> parser = PARSER;
        if (parser == null) goto L12;
    L22:
        return parser;
    L12:
        monitor-enter(AppLocationUsage.class);
        parser = PARSER;     // Catch: Throwable -> L16
        if (parser != null) goto L18;
        parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L16
        PARSER = parser;     // Catch: Throwable -> L16
    L18:
        monitor-exit(AppLocationUsage.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L25:
        Object[] objects = {"bitField0_", "startTimestamp_", "stopTimestamp_", "appPackageName_", "locationProvider_", "requestInterval_", "totalTime_", "activeTime_", "foregroundTime_", "appTtff_", "locationReceived_", "errorCode_", "hasNavReq_"};
        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဃ\u0004\u0006ဃ\u0005\u0007ဃ\u0006\bဃ\u0007\tဃ\b\nဋ\t\u000bဋ\n\fဇ\u000b", objects);
    L5:
        throw new UnsupportedOperationException();
    L8:
        return (byte) 1;
    L24:
        return DEFAULT_INSTANCE;
    L28:
        return new Builder(r1);
    L30:
        return new AppLocationUsage();
    }

    static {
        AppLocationUsage defaultInstance = new AppLocationUsage();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(AppLocationUsage.class, defaultInstance);
    }

    public static AppLocationUsage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AppLocationUsage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
