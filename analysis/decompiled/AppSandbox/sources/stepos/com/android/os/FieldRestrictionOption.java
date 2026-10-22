package stepos.com.android.os;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class FieldRestrictionOption extends GeneratedMessageLite<FieldRestrictionOption, Builder> implements FieldRestrictionOptionOrBuilder {
    public static final int ACCESSIBILITY_FIELD_NUMBER = 5;
    public static final int AMBIENT_SENSING_FIELD_NUMBER = 8;
    public static final int APP_ACTIVITY_FIELD_NUMBER = 3;
    public static final int APP_USAGE_FIELD_NUMBER = 2;
    private static final FieldRestrictionOption DEFAULT_INSTANCE;
    public static final int DEMOGRAPHIC_CLASSIFICATION_FIELD_NUMBER = 9;
    public static final int HEALTH_CONNECT_FIELD_NUMBER = 4;
    private static volatile Parser<FieldRestrictionOption> PARSER = null;
    public static final int PERIPHERAL_DEVICE_INFO_FIELD_NUMBER = 1;
    public static final int SYSTEM_SEARCH_FIELD_NUMBER = 6;
    public static final int USER_ENGAGEMENT_FIELD_NUMBER = 7;
    private boolean accessibility_;
    private boolean ambientSensing_;
    private boolean appActivity_;
    private boolean appUsage_;
    private int bitField0_;
    private boolean demographicClassification_;
    private boolean healthConnect_;
    private boolean peripheralDeviceInfo_;
    private boolean systemSearch_;
    private boolean userEngagement_;

    private FieldRestrictionOption() {
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasPeripheralDeviceInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getPeripheralDeviceInfo() {
        return this.peripheralDeviceInfo_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeripheralDeviceInfo(boolean z) {
        this.bitField0_ |= 1;
        this.peripheralDeviceInfo_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPeripheralDeviceInfo() {
        this.bitField0_ &= -2;
        this.peripheralDeviceInfo_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasAppUsage() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getAppUsage() {
        return this.appUsage_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppUsage(boolean z) {
        this.bitField0_ |= 2;
        this.appUsage_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppUsage() {
        this.bitField0_ &= -3;
        this.appUsage_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasAppActivity() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getAppActivity() {
        return this.appActivity_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppActivity(boolean z) {
        this.bitField0_ |= 4;
        this.appActivity_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppActivity() {
        this.bitField0_ &= -5;
        this.appActivity_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasHealthConnect() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getHealthConnect() {
        return this.healthConnect_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHealthConnect(boolean z) {
        this.bitField0_ |= 8;
        this.healthConnect_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHealthConnect() {
        this.bitField0_ &= -9;
        this.healthConnect_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasAccessibility() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getAccessibility() {
        return this.accessibility_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessibility(boolean z) {
        this.bitField0_ |= 16;
        this.accessibility_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccessibility() {
        this.bitField0_ &= -17;
        this.accessibility_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasSystemSearch() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getSystemSearch() {
        return this.systemSearch_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemSearch(boolean z) {
        this.bitField0_ |= 32;
        this.systemSearch_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSystemSearch() {
        this.bitField0_ &= -33;
        this.systemSearch_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasUserEngagement() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getUserEngagement() {
        return this.userEngagement_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserEngagement(boolean z) {
        this.bitField0_ |= 64;
        this.userEngagement_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserEngagement() {
        this.bitField0_ &= -65;
        this.userEngagement_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasAmbientSensing() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getAmbientSensing() {
        return this.ambientSensing_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmbientSensing(boolean z) {
        this.bitField0_ |= 128;
        this.ambientSensing_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAmbientSensing() {
        this.bitField0_ &= -129;
        this.ambientSensing_ = false;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean hasDemographicClassification() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
    public boolean getDemographicClassification() {
        return this.demographicClassification_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDemographicClassification(boolean z) {
        this.bitField0_ |= 256;
        this.demographicClassification_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDemographicClassification() {
        this.bitField0_ &= -257;
        this.demographicClassification_ = false;
    }

    public static FieldRestrictionOption parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static FieldRestrictionOption parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FieldRestrictionOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FieldRestrictionOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FieldRestrictionOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FieldRestrictionOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FieldRestrictionOption parseFrom(InputStream inputStream) throws IOException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FieldRestrictionOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FieldRestrictionOption parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FieldRestrictionOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FieldRestrictionOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldRestrictionOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FieldRestrictionOption parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FieldRestrictionOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FieldRestrictionOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(FieldRestrictionOption fieldRestrictionOption) {
        return DEFAULT_INSTANCE.createBuilder(fieldRestrictionOption);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<FieldRestrictionOption, Builder> implements FieldRestrictionOptionOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(FieldRestrictionOption.DEFAULT_INSTANCE);
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasPeripheralDeviceInfo() {
            return ((FieldRestrictionOption) this.instance).hasPeripheralDeviceInfo();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getPeripheralDeviceInfo() {
            return ((FieldRestrictionOption) this.instance).getPeripheralDeviceInfo();
        }

        public Builder setPeripheralDeviceInfo(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setPeripheralDeviceInfo(z);
            return this;
        }

        public Builder clearPeripheralDeviceInfo() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearPeripheralDeviceInfo();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasAppUsage() {
            return ((FieldRestrictionOption) this.instance).hasAppUsage();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getAppUsage() {
            return ((FieldRestrictionOption) this.instance).getAppUsage();
        }

        public Builder setAppUsage(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setAppUsage(z);
            return this;
        }

        public Builder clearAppUsage() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearAppUsage();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasAppActivity() {
            return ((FieldRestrictionOption) this.instance).hasAppActivity();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getAppActivity() {
            return ((FieldRestrictionOption) this.instance).getAppActivity();
        }

        public Builder setAppActivity(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setAppActivity(z);
            return this;
        }

        public Builder clearAppActivity() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearAppActivity();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasHealthConnect() {
            return ((FieldRestrictionOption) this.instance).hasHealthConnect();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getHealthConnect() {
            return ((FieldRestrictionOption) this.instance).getHealthConnect();
        }

        public Builder setHealthConnect(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setHealthConnect(z);
            return this;
        }

        public Builder clearHealthConnect() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearHealthConnect();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasAccessibility() {
            return ((FieldRestrictionOption) this.instance).hasAccessibility();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getAccessibility() {
            return ((FieldRestrictionOption) this.instance).getAccessibility();
        }

        public Builder setAccessibility(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setAccessibility(z);
            return this;
        }

        public Builder clearAccessibility() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearAccessibility();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasSystemSearch() {
            return ((FieldRestrictionOption) this.instance).hasSystemSearch();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getSystemSearch() {
            return ((FieldRestrictionOption) this.instance).getSystemSearch();
        }

        public Builder setSystemSearch(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setSystemSearch(z);
            return this;
        }

        public Builder clearSystemSearch() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearSystemSearch();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasUserEngagement() {
            return ((FieldRestrictionOption) this.instance).hasUserEngagement();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getUserEngagement() {
            return ((FieldRestrictionOption) this.instance).getUserEngagement();
        }

        public Builder setUserEngagement(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setUserEngagement(z);
            return this;
        }

        public Builder clearUserEngagement() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearUserEngagement();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasAmbientSensing() {
            return ((FieldRestrictionOption) this.instance).hasAmbientSensing();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getAmbientSensing() {
            return ((FieldRestrictionOption) this.instance).getAmbientSensing();
        }

        public Builder setAmbientSensing(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setAmbientSensing(z);
            return this;
        }

        public Builder clearAmbientSensing() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearAmbientSensing();
            return this;
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean hasDemographicClassification() {
            return ((FieldRestrictionOption) this.instance).hasDemographicClassification();
        }

        @Override // stepos.com.android.os.FieldRestrictionOptionOrBuilder
        public boolean getDemographicClassification() {
            return ((FieldRestrictionOption) this.instance).getDemographicClassification();
        }

        public Builder setDemographicClassification(boolean z) {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).setDemographicClassification(z);
            return this;
        }

        public Builder clearDemographicClassification() {
            copyOnWrite();
            ((FieldRestrictionOption) this.instance).clearDemographicClassification();
            return this;
        }
    }

    /* renamed from: stepos.com.android.os.FieldRestrictionOption$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new FieldRestrictionOption();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b", new Object[]{"bitField0_", "peripheralDeviceInfo_", "appUsage_", "appActivity_", "healthConnect_", "accessibility_", "systemSearch_", "userEngagement_", "ambientSensing_", "demographicClassification_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FieldRestrictionOption> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (FieldRestrictionOption.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        FieldRestrictionOption fieldRestrictionOption = new FieldRestrictionOption();
        DEFAULT_INSTANCE = fieldRestrictionOption;
        GeneratedMessageLite.registerDefaultInstance(FieldRestrictionOption.class, fieldRestrictionOption);
    }

    public static FieldRestrictionOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FieldRestrictionOption> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
