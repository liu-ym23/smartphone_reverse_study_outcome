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
public final class LocationUiOnOffTime extends GeneratedMessageLite<LocationUiOnOffTime, Builder> implements LocationUiOnOffTimeOrBuilder {
    private static final LocationUiOnOffTime DEFAULT_INSTANCE = null;
    private static volatile Parser<LocationUiOnOffTime> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    public static final int UI_ON_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private long timestamp_;
    private boolean uiOn_;
    private int userId_;

    /* JADX INFO: renamed from: com.bytedance.location.LocationUiOnOffTime$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LocationUiOnOffTime, Builder> implements LocationUiOnOffTimeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(LocationUiOnOffTime.access$000());
        }

        @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
        public boolean hasUiOn() {
            return ((LocationUiOnOffTime) this.instance).hasUiOn();
        }

        @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
        public boolean getUiOn() {
            return ((LocationUiOnOffTime) this.instance).getUiOn();
        }

        public Builder setUiOn(boolean value) {
            copyOnWrite();
            LocationUiOnOffTime.access$100((LocationUiOnOffTime) this.instance, value);
            return this;
        }

        public Builder clearUiOn() {
            copyOnWrite();
            LocationUiOnOffTime.access$200((LocationUiOnOffTime) this.instance);
            return this;
        }

        @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
        public boolean hasUserId() {
            return ((LocationUiOnOffTime) this.instance).hasUserId();
        }

        @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
        public int getUserId() {
            return ((LocationUiOnOffTime) this.instance).getUserId();
        }

        public Builder setUserId(int value) {
            copyOnWrite();
            LocationUiOnOffTime.access$300((LocationUiOnOffTime) this.instance, value);
            return this;
        }

        public Builder clearUserId() {
            copyOnWrite();
            LocationUiOnOffTime.access$400((LocationUiOnOffTime) this.instance);
            return this;
        }

        @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
        public boolean hasTimestamp() {
            return ((LocationUiOnOffTime) this.instance).hasTimestamp();
        }

        @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
        public long getTimestamp() {
            return ((LocationUiOnOffTime) this.instance).getTimestamp();
        }

        public Builder setTimestamp(long value) {
            copyOnWrite();
            LocationUiOnOffTime.access$500((LocationUiOnOffTime) this.instance, value);
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            LocationUiOnOffTime.access$600((LocationUiOnOffTime) this.instance);
            return this;
        }
    }

    static /* synthetic */ LocationUiOnOffTime access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(LocationUiOnOffTime x0, boolean x1) {
        x0.setUiOn(x1);
    }

    static /* synthetic */ void access$200(LocationUiOnOffTime x0) {
        x0.clearUiOn();
    }

    static /* synthetic */ void access$300(LocationUiOnOffTime x0, int x1) {
        x0.setUserId(x1);
    }

    static /* synthetic */ void access$400(LocationUiOnOffTime x0) {
        x0.clearUserId();
    }

    static /* synthetic */ void access$500(LocationUiOnOffTime x0, long x1) {
        x0.setTimestamp(x1);
    }

    static /* synthetic */ void access$600(LocationUiOnOffTime x0) {
        x0.clearTimestamp();
    }

    private LocationUiOnOffTime() {
    }

    @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
    public boolean hasUiOn() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
    public boolean getUiOn() {
        return this.uiOn_;
    }

    private void setUiOn(boolean value) {
        this.bitField0_ |= 1;
        this.uiOn_ = value;
    }

    private void clearUiOn() {
        this.bitField0_ &= -2;
        this.uiOn_ = false;
    }

    @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
    public boolean hasUserId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
    public int getUserId() {
        return this.userId_;
    }

    private void setUserId(int value) {
        this.bitField0_ |= 2;
        this.userId_ = value;
    }

    private void clearUserId() {
        this.bitField0_ &= -3;
        this.userId_ = 0;
    }

    @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.LocationUiOnOffTimeOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    private void setTimestamp(long value) {
        this.bitField0_ |= 4;
        this.timestamp_ = value;
    }

    private void clearTimestamp() {
        this.bitField0_ &= -5;
        this.timestamp_ = 0;
    }

    public static LocationUiOnOffTime parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationUiOnOffTime parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationUiOnOffTime parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationUiOnOffTime parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationUiOnOffTime parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationUiOnOffTime parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationUiOnOffTime parseFrom(InputStream input) throws IOException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationUiOnOffTime parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocationUiOnOffTime parseDelimitedFrom(InputStream input) throws IOException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationUiOnOffTime parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocationUiOnOffTime parseFrom(CodedInputStream input) throws IOException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationUiOnOffTime parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationUiOnOffTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(LocationUiOnOffTime prototype) {
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
        Parser<LocationUiOnOffTime> parser = PARSER;
        if (parser == null) goto L12;
    L22:
        return parser;
    L12:
        monitor-enter(LocationUiOnOffTime.class);
        parser = PARSER;     // Catch: Throwable -> L16
        if (parser != null) goto L18;
        parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L16
        PARSER = parser;     // Catch: Throwable -> L16
    L18:
        monitor-exit(LocationUiOnOffTime.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L25:
        Object[] objects = {"bitField0_", "uiOn_", "userId_", "timestamp_"};
        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001\u0003ဃ\u0002", objects);
    L5:
        throw new UnsupportedOperationException();
    L8:
        return (byte) 1;
    L24:
        return DEFAULT_INSTANCE;
    L28:
        return new Builder(r1);
    L30:
        return new LocationUiOnOffTime();
    }

    static {
        LocationUiOnOffTime defaultInstance = new LocationUiOnOffTime();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(LocationUiOnOffTime.class, defaultInstance);
    }

    public static LocationUiOnOffTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LocationUiOnOffTime> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
