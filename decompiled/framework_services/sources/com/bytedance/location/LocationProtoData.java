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
public final class LocationProtoData extends GeneratedMessageLite<LocationProtoData, Builder> implements LocationProtoDataOrBuilder {
    public static final int APP_LOCATION_USAGE_FIELD_NUMBER = 3;
    private static final LocationProtoData DEFAULT_INSTANCE = null;
    public static final int GNSS_POSITIONING_FIELD_NUMBER = 2;
    public static final int LOCATION_UI_ON_OFF_TIME_FIELD_NUMBER = 1;
    private static volatile Parser<LocationProtoData> PARSER;
    private AppLocationUsage appLocationUsage_;
    private int bitField0_;
    private GnssPositioning gnssPositioning_;
    private LocationUiOnOffTime locationUiOnOffTime_;

    /* JADX INFO: renamed from: com.bytedance.location.LocationProtoData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LocationProtoData, Builder> implements LocationProtoDataOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(LocationProtoData.access$000());
        }

        @Override // com.bytedance.location.LocationProtoDataOrBuilder
        public boolean hasLocationUiOnOffTime() {
            return ((LocationProtoData) this.instance).hasLocationUiOnOffTime();
        }

        @Override // com.bytedance.location.LocationProtoDataOrBuilder
        public LocationUiOnOffTime getLocationUiOnOffTime() {
            return ((LocationProtoData) this.instance).getLocationUiOnOffTime();
        }

        public Builder setLocationUiOnOffTime(LocationUiOnOffTime value) {
            copyOnWrite();
            LocationProtoData.access$100((LocationProtoData) this.instance, value);
            return this;
        }

        public Builder setLocationUiOnOffTime(LocationUiOnOffTime.Builder builderForValue) {
            copyOnWrite();
            LocationProtoData.access$100((LocationProtoData) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeLocationUiOnOffTime(LocationUiOnOffTime value) {
            copyOnWrite();
            LocationProtoData.access$200((LocationProtoData) this.instance, value);
            return this;
        }

        public Builder clearLocationUiOnOffTime() {
            copyOnWrite();
            LocationProtoData.access$300((LocationProtoData) this.instance);
            return this;
        }

        @Override // com.bytedance.location.LocationProtoDataOrBuilder
        public boolean hasGnssPositioning() {
            return ((LocationProtoData) this.instance).hasGnssPositioning();
        }

        @Override // com.bytedance.location.LocationProtoDataOrBuilder
        public GnssPositioning getGnssPositioning() {
            return ((LocationProtoData) this.instance).getGnssPositioning();
        }

        public Builder setGnssPositioning(GnssPositioning value) {
            copyOnWrite();
            LocationProtoData.access$400((LocationProtoData) this.instance, value);
            return this;
        }

        public Builder setGnssPositioning(GnssPositioning.Builder builderForValue) {
            copyOnWrite();
            LocationProtoData.access$400((LocationProtoData) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeGnssPositioning(GnssPositioning value) {
            copyOnWrite();
            LocationProtoData.access$500((LocationProtoData) this.instance, value);
            return this;
        }

        public Builder clearGnssPositioning() {
            copyOnWrite();
            LocationProtoData.access$600((LocationProtoData) this.instance);
            return this;
        }

        @Override // com.bytedance.location.LocationProtoDataOrBuilder
        public boolean hasAppLocationUsage() {
            return ((LocationProtoData) this.instance).hasAppLocationUsage();
        }

        @Override // com.bytedance.location.LocationProtoDataOrBuilder
        public AppLocationUsage getAppLocationUsage() {
            return ((LocationProtoData) this.instance).getAppLocationUsage();
        }

        public Builder setAppLocationUsage(AppLocationUsage value) {
            copyOnWrite();
            LocationProtoData.access$700((LocationProtoData) this.instance, value);
            return this;
        }

        public Builder setAppLocationUsage(AppLocationUsage.Builder builderForValue) {
            copyOnWrite();
            LocationProtoData.access$700((LocationProtoData) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeAppLocationUsage(AppLocationUsage value) {
            copyOnWrite();
            LocationProtoData.access$800((LocationProtoData) this.instance, value);
            return this;
        }

        public Builder clearAppLocationUsage() {
            copyOnWrite();
            LocationProtoData.access$900((LocationProtoData) this.instance);
            return this;
        }
    }

    static /* synthetic */ LocationProtoData access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(LocationProtoData x0, LocationUiOnOffTime x1) {
        x0.setLocationUiOnOffTime(x1);
    }

    static /* synthetic */ void access$200(LocationProtoData x0, LocationUiOnOffTime x1) {
        x0.mergeLocationUiOnOffTime(x1);
    }

    static /* synthetic */ void access$300(LocationProtoData x0) {
        x0.clearLocationUiOnOffTime();
    }

    static /* synthetic */ void access$400(LocationProtoData x0, GnssPositioning x1) {
        x0.setGnssPositioning(x1);
    }

    static /* synthetic */ void access$500(LocationProtoData x0, GnssPositioning x1) {
        x0.mergeGnssPositioning(x1);
    }

    static /* synthetic */ void access$600(LocationProtoData x0) {
        x0.clearGnssPositioning();
    }

    static /* synthetic */ void access$700(LocationProtoData x0, AppLocationUsage x1) {
        x0.setAppLocationUsage(x1);
    }

    static /* synthetic */ void access$800(LocationProtoData x0, AppLocationUsage x1) {
        x0.mergeAppLocationUsage(x1);
    }

    static /* synthetic */ void access$900(LocationProtoData x0) {
        x0.clearAppLocationUsage();
    }

    private LocationProtoData() {
    }

    @Override // com.bytedance.location.LocationProtoDataOrBuilder
    public boolean hasLocationUiOnOffTime() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.location.LocationProtoDataOrBuilder
    public LocationUiOnOffTime getLocationUiOnOffTime() {
        if (this.locationUiOnOffTime_ != null) goto L6;
        return LocationUiOnOffTime.getDefaultInstance();
    L6:
        return this.locationUiOnOffTime_;
    }

    private void setLocationUiOnOffTime(LocationUiOnOffTime value) {
        value.getClass();
        this.locationUiOnOffTime_ = value;
        this.bitField0_ |= 1;
    }

    private void mergeLocationUiOnOffTime(LocationUiOnOffTime value) {
        value.getClass();
        if (this.locationUiOnOffTime_ != null) goto L5;
    L7:
        this.locationUiOnOffTime_ = value;
    L8:
        this.bitField0_ |= 1;
        return;
    L5:
        if (this.locationUiOnOffTime_ == LocationUiOnOffTime.getDefaultInstance()) goto L7;
        this.locationUiOnOffTime_ = LocationUiOnOffTime.newBuilder(this.locationUiOnOffTime_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearLocationUiOnOffTime() {
        this.locationUiOnOffTime_ = null;
        this.bitField0_ &= -2;
    }

    @Override // com.bytedance.location.LocationProtoDataOrBuilder
    public boolean hasGnssPositioning() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.LocationProtoDataOrBuilder
    public GnssPositioning getGnssPositioning() {
        if (this.gnssPositioning_ != null) goto L6;
        return GnssPositioning.getDefaultInstance();
    L6:
        return this.gnssPositioning_;
    }

    private void setGnssPositioning(GnssPositioning value) {
        value.getClass();
        this.gnssPositioning_ = value;
        this.bitField0_ |= 2;
    }

    private void mergeGnssPositioning(GnssPositioning value) {
        value.getClass();
        if (this.gnssPositioning_ != null) goto L5;
    L7:
        this.gnssPositioning_ = value;
    L8:
        this.bitField0_ |= 2;
        return;
    L5:
        if (this.gnssPositioning_ == GnssPositioning.getDefaultInstance()) goto L7;
        this.gnssPositioning_ = GnssPositioning.newBuilder(this.gnssPositioning_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearGnssPositioning() {
        this.gnssPositioning_ = null;
        this.bitField0_ &= -3;
    }

    @Override // com.bytedance.location.LocationProtoDataOrBuilder
    public boolean hasAppLocationUsage() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.LocationProtoDataOrBuilder
    public AppLocationUsage getAppLocationUsage() {
        if (this.appLocationUsage_ != null) goto L6;
        return AppLocationUsage.getDefaultInstance();
    L6:
        return this.appLocationUsage_;
    }

    private void setAppLocationUsage(AppLocationUsage value) {
        value.getClass();
        this.appLocationUsage_ = value;
        this.bitField0_ |= 4;
    }

    private void mergeAppLocationUsage(AppLocationUsage value) {
        value.getClass();
        if (this.appLocationUsage_ != null) goto L5;
    L7:
        this.appLocationUsage_ = value;
    L8:
        this.bitField0_ |= 4;
        return;
    L5:
        if (this.appLocationUsage_ == AppLocationUsage.getDefaultInstance()) goto L7;
        this.appLocationUsage_ = AppLocationUsage.newBuilder(this.appLocationUsage_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearAppLocationUsage() {
        this.appLocationUsage_ = null;
        this.bitField0_ &= -5;
    }

    public static LocationProtoData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationProtoData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationProtoData parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationProtoData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationProtoData parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationProtoData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationProtoData parseFrom(InputStream input) throws IOException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationProtoData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocationProtoData parseDelimitedFrom(InputStream input) throws IOException {
        return (LocationProtoData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationProtoData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationProtoData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocationProtoData parseFrom(CodedInputStream input) throws IOException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationProtoData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationProtoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(LocationProtoData prototype) {
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
        Parser<LocationProtoData> parser = PARSER;
        if (parser == null) goto L12;
    L22:
        return parser;
    L12:
        monitor-enter(LocationProtoData.class);
        parser = PARSER;     // Catch: Throwable -> L16
        if (parser != null) goto L18;
        parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L16
        PARSER = parser;     // Catch: Throwable -> L16
    L18:
        monitor-exit(LocationProtoData.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L25:
        Object[] objects = {"bitField0_", "locationUiOnOffTime_", "gnssPositioning_", "appLocationUsage_"};
        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", objects);
    L5:
        throw new UnsupportedOperationException();
    L8:
        return (byte) 1;
    L24:
        return DEFAULT_INSTANCE;
    L28:
        return new Builder(r1);
    L30:
        return new LocationProtoData();
    }

    static {
        LocationProtoData defaultInstance = new LocationProtoData();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(LocationProtoData.class, defaultInstance);
    }

    public static LocationProtoData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LocationProtoData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
