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
public final class LocationProto extends GeneratedMessageLite<LocationProto, Builder> implements LocationProtoOrBuilder {
    private static final LocationProto DEFAULT_INSTANCE = null;
    public static final int LOCATION_PROTO_FIELD_NUMBER = 1;
    private static volatile Parser<LocationProto> PARSER;
    private Internal.ProtobufList<LocationProtoData> locationProto_;

    /* JADX INFO: renamed from: com.bytedance.location.LocationProto$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LocationProto, Builder> implements LocationProtoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(LocationProto.access$000());
        }

        @Override // com.bytedance.location.LocationProtoOrBuilder
        public List<LocationProtoData> getLocationProtoList() {
            return Collections.unmodifiableList(((LocationProto) this.instance).getLocationProtoList());
        }

        @Override // com.bytedance.location.LocationProtoOrBuilder
        public int getLocationProtoCount() {
            return ((LocationProto) this.instance).getLocationProtoCount();
        }

        @Override // com.bytedance.location.LocationProtoOrBuilder
        public LocationProtoData getLocationProto(int index) {
            return ((LocationProto) this.instance).getLocationProto(index);
        }

        public Builder setLocationProto(int index, LocationProtoData value) {
            copyOnWrite();
            LocationProto.access$100((LocationProto) this.instance, index, value);
            return this;
        }

        public Builder setLocationProto(int index, LocationProtoData.Builder builderForValue) {
            copyOnWrite();
            LocationProto.access$100((LocationProto) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addLocationProto(LocationProtoData value) {
            copyOnWrite();
            LocationProto.access$200((LocationProto) this.instance, value);
            return this;
        }

        public Builder addLocationProto(int index, LocationProtoData value) {
            copyOnWrite();
            LocationProto.access$300((LocationProto) this.instance, index, value);
            return this;
        }

        public Builder addLocationProto(LocationProtoData.Builder builderForValue) {
            copyOnWrite();
            LocationProto.access$200((LocationProto) this.instance, builderForValue.build());
            return this;
        }

        public Builder addLocationProto(int index, LocationProtoData.Builder builderForValue) {
            copyOnWrite();
            LocationProto.access$300((LocationProto) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllLocationProto(Iterable<? extends LocationProtoData> values) {
            copyOnWrite();
            LocationProto.access$400((LocationProto) this.instance, values);
            return this;
        }

        public Builder clearLocationProto() {
            copyOnWrite();
            LocationProto.access$500((LocationProto) this.instance);
            return this;
        }

        public Builder removeLocationProto(int index) {
            copyOnWrite();
            LocationProto.access$600((LocationProto) this.instance, index);
            return this;
        }
    }

    static /* synthetic */ LocationProto access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(LocationProto x0, int x1, LocationProtoData x2) {
        x0.setLocationProto(x1, x2);
    }

    static /* synthetic */ void access$200(LocationProto x0, LocationProtoData x1) {
        x0.addLocationProto(x1);
    }

    static /* synthetic */ void access$300(LocationProto x0, int x1, LocationProtoData x2) {
        x0.addLocationProto(x1, x2);
    }

    static /* synthetic */ void access$400(LocationProto x0, Iterable x1) {
        x0.addAllLocationProto(x1);
    }

    static /* synthetic */ void access$500(LocationProto x0) {
        x0.clearLocationProto();
    }

    static /* synthetic */ void access$600(LocationProto x0, int x1) {
        x0.removeLocationProto(x1);
    }

    private LocationProto() {
        this.locationProto_ = GeneratedMessageLite.emptyProtobufList();
    }

    @Override // com.bytedance.location.LocationProtoOrBuilder
    public List<LocationProtoData> getLocationProtoList() {
        return this.locationProto_;
    }

    public List<? extends LocationProtoDataOrBuilder> getLocationProtoOrBuilderList() {
        return this.locationProto_;
    }

    @Override // com.bytedance.location.LocationProtoOrBuilder
    public int getLocationProtoCount() {
        return this.locationProto_.size();
    }

    @Override // com.bytedance.location.LocationProtoOrBuilder
    public LocationProtoData getLocationProto(int index) {
        return this.locationProto_.get(index);
    }

    public LocationProtoDataOrBuilder getLocationProtoOrBuilder(int index) {
        return this.locationProto_.get(index);
    }

    private void ensureLocationProtoIsMutable() {
        Internal.ProtobufList<LocationProtoData> tmp = this.locationProto_;
        if (tmp.isModifiable() == true) goto L6;
        this.locationProto_ = GeneratedMessageLite.mutableCopy(tmp);
        return;
    }

    private void setLocationProto(int index, LocationProtoData value) {
        value.getClass();
        ensureLocationProtoIsMutable();
        this.locationProto_.set(index, value);
    }

    private void addLocationProto(LocationProtoData value) {
        value.getClass();
        ensureLocationProtoIsMutable();
        this.locationProto_.add(value);
    }

    private void addLocationProto(int index, LocationProtoData value) {
        value.getClass();
        ensureLocationProtoIsMutable();
        this.locationProto_.add(index, value);
    }

    private void addAllLocationProto(Iterable<? extends LocationProtoData> values) {
        ensureLocationProtoIsMutable();
        AbstractMessageLite.addAll(values, this.locationProto_);
    }

    private void clearLocationProto() {
        this.locationProto_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void removeLocationProto(int index) {
        ensureLocationProtoIsMutable();
        this.locationProto_.remove(index);
    }

    public static LocationProto parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationProto parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static LocationProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static LocationProto parseFrom(InputStream input) throws IOException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocationProto parseDelimitedFrom(InputStream input) throws IOException {
        return (LocationProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static LocationProto parseFrom(CodedInputStream input) throws IOException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static LocationProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (LocationProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(LocationProto prototype) {
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
        Parser<LocationProto> parser = PARSER;
        if (parser == null) goto L12;
    L22:
        return parser;
    L12:
        monitor-enter(LocationProto.class);
        parser = PARSER;     // Catch: Throwable -> L16
        if (parser != null) goto L18;
        parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L16
        PARSER = parser;     // Catch: Throwable -> L16
    L18:
        monitor-exit(LocationProto.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L25:
        Object[] objects = {"locationProto_", LocationProtoData.class};
        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objects);
    L5:
        throw new UnsupportedOperationException();
    L8:
        return (byte) 1;
    L24:
        return DEFAULT_INSTANCE;
    L28:
        return new Builder(r1);
    L30:
        return new LocationProto();
    }

    static {
        LocationProto defaultInstance = new LocationProto();
        DEFAULT_INSTANCE = defaultInstance;
        GeneratedMessageLite.registerDefaultInstance(LocationProto.class, defaultInstance);
    }

    public static LocationProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LocationProto> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
