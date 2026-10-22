package stepos.com.android.os;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class HistogramBinOption extends GeneratedMessageLite<HistogramBinOption, Builder> implements HistogramBinOptionOrBuilder {
    private static final HistogramBinOption DEFAULT_INSTANCE;
    public static final int EXPLICIT_BINS_FIELD_NUMBER = 2;
    public static final int GENERATED_BINS_FIELD_NUMBER = 1;
    private static volatile Parser<HistogramBinOption> PARSER;
    private int binningStrategyCase_ = 0;
    private Object binningStrategy_;
    private int bitField0_;

    public interface ExplicitBinsOrBuilder extends MessageLiteOrBuilder {
        float getBin(int i);

        int getBinCount();

        List<Float> getBinList();
    }

    public interface GeneratedBinsOrBuilder extends MessageLiteOrBuilder {
        int getCount();

        float getMax();

        float getMin();

        GeneratedBins.Strategy getStrategy();

        boolean hasCount();

        boolean hasMax();

        boolean hasMin();

        boolean hasStrategy();
    }

    private HistogramBinOption() {
    }

    public static final class ExplicitBins extends GeneratedMessageLite<ExplicitBins, Builder> implements ExplicitBinsOrBuilder {
        public static final int BIN_FIELD_NUMBER = 1;
        private static final ExplicitBins DEFAULT_INSTANCE;
        private static volatile Parser<ExplicitBins> PARSER;
        private Internal.FloatList bin_ = emptyFloatList();

        private ExplicitBins() {
        }

        @Override // stepos.com.android.os.HistogramBinOption.ExplicitBinsOrBuilder
        public List<Float> getBinList() {
            return this.bin_;
        }

        @Override // stepos.com.android.os.HistogramBinOption.ExplicitBinsOrBuilder
        public int getBinCount() {
            return this.bin_.size();
        }

        @Override // stepos.com.android.os.HistogramBinOption.ExplicitBinsOrBuilder
        public float getBin(int i) {
            return this.bin_.getFloat(i);
        }

        private void ensureBinIsMutable() {
            Internal.FloatList floatList = this.bin_;
            if (floatList.isModifiable()) {
                return;
            }
            this.bin_ = GeneratedMessageLite.mutableCopy(floatList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBin(int i, float f) {
            ensureBinIsMutable();
            this.bin_.setFloat(i, f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addBin(float f) {
            ensureBinIsMutable();
            this.bin_.addFloat(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllBin(Iterable<? extends Float> iterable) {
            ensureBinIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.bin_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBin() {
            this.bin_ = emptyFloatList();
        }

        public static ExplicitBins parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ExplicitBins parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExplicitBins parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExplicitBins parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExplicitBins parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExplicitBins parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExplicitBins parseFrom(InputStream inputStream) throws IOException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExplicitBins parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExplicitBins parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExplicitBins) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExplicitBins parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExplicitBins) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExplicitBins parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExplicitBins parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExplicitBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExplicitBins explicitBins) {
            return DEFAULT_INSTANCE.createBuilder(explicitBins);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ExplicitBins, Builder> implements ExplicitBinsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ExplicitBins.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.HistogramBinOption.ExplicitBinsOrBuilder
            public List<Float> getBinList() {
                return Collections.unmodifiableList(((ExplicitBins) this.instance).getBinList());
            }

            @Override // stepos.com.android.os.HistogramBinOption.ExplicitBinsOrBuilder
            public int getBinCount() {
                return ((ExplicitBins) this.instance).getBinCount();
            }

            @Override // stepos.com.android.os.HistogramBinOption.ExplicitBinsOrBuilder
            public float getBin(int i) {
                return ((ExplicitBins) this.instance).getBin(i);
            }

            public Builder setBin(int i, float f) {
                copyOnWrite();
                ((ExplicitBins) this.instance).setBin(i, f);
                return this;
            }

            public Builder addBin(float f) {
                copyOnWrite();
                ((ExplicitBins) this.instance).addBin(f);
                return this;
            }

            public Builder addAllBin(Iterable<? extends Float> iterable) {
                copyOnWrite();
                ((ExplicitBins) this.instance).addAllBin(iterable);
                return this;
            }

            public Builder clearBin() {
                copyOnWrite();
                ((ExplicitBins) this.instance).clearBin();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ExplicitBins();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0013", new Object[]{"bin_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExplicitBins> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ExplicitBins.class) {
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
            ExplicitBins explicitBins = new ExplicitBins();
            DEFAULT_INSTANCE = explicitBins;
            GeneratedMessageLite.registerDefaultInstance(ExplicitBins.class, explicitBins);
        }

        public static ExplicitBins getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExplicitBins> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: stepos.com.android.os.HistogramBinOption$1, reason: invalid class name */
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

    public static final class GeneratedBins extends GeneratedMessageLite<GeneratedBins, Builder> implements GeneratedBinsOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 3;
        private static final GeneratedBins DEFAULT_INSTANCE;
        public static final int MAX_FIELD_NUMBER = 2;
        public static final int MIN_FIELD_NUMBER = 1;
        private static volatile Parser<GeneratedBins> PARSER = null;
        public static final int STRATEGY_FIELD_NUMBER = 4;
        private int bitField0_;
        private int count_;
        private float max_;
        private float min_;
        private int strategy_;

        private GeneratedBins() {
        }

        public enum Strategy implements Internal.EnumLite {
            STRATEGY_UNKNOWN(0),
            LINEAR(1),
            EXPONENTIAL(2);

            public static final int EXPONENTIAL_VALUE = 2;
            public static final int LINEAR_VALUE = 1;
            public static final int STRATEGY_UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<Strategy> internalValueMap = new Internal.EnumLiteMap<Strategy>() { // from class: stepos.com.android.os.HistogramBinOption.GeneratedBins.Strategy.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Strategy findValueByNumber(int i) {
                    return Strategy.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Strategy valueOf(int i) {
                return forNumber(i);
            }

            public static Strategy forNumber(int i) {
                if (i == 0) {
                    return STRATEGY_UNKNOWN;
                }
                if (i == 1) {
                    return LINEAR;
                }
                if (i != 2) {
                    return null;
                }
                return EXPONENTIAL;
            }

            public static Internal.EnumLiteMap<Strategy> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return StrategyVerifier.INSTANCE;
            }

            private static final class StrategyVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new StrategyVerifier();

                private StrategyVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Strategy.forNumber(i) != null;
                }
            }

            Strategy(int i) {
                this.value = i;
            }
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public boolean hasMin() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public float getMin() {
            return this.min_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMin(float f) {
            this.bitField0_ |= 1;
            this.min_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMin() {
            this.bitField0_ &= -2;
            this.min_ = 0.0f;
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public boolean hasMax() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public float getMax() {
            return this.max_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMax(float f) {
            this.bitField0_ |= 2;
            this.max_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMax() {
            this.bitField0_ &= -3;
            this.max_ = 0.0f;
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public boolean hasCount() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCount(int i) {
            this.bitField0_ |= 4;
            this.count_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCount() {
            this.bitField0_ &= -5;
            this.count_ = 0;
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public boolean hasStrategy() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
        public Strategy getStrategy() {
            Strategy strategyForNumber = Strategy.forNumber(this.strategy_);
            return strategyForNumber == null ? Strategy.STRATEGY_UNKNOWN : strategyForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrategy(Strategy strategy) {
            this.strategy_ = strategy.getNumber();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrategy() {
            this.bitField0_ &= -9;
            this.strategy_ = 0;
        }

        public static GeneratedBins parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GeneratedBins parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GeneratedBins parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GeneratedBins parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GeneratedBins parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GeneratedBins parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GeneratedBins parseFrom(InputStream inputStream) throws IOException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedBins parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedBins parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GeneratedBins) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedBins parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedBins) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedBins parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GeneratedBins parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedBins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GeneratedBins generatedBins) {
            return DEFAULT_INSTANCE.createBuilder(generatedBins);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedBins, Builder> implements GeneratedBinsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(GeneratedBins.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public boolean hasMin() {
                return ((GeneratedBins) this.instance).hasMin();
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public float getMin() {
                return ((GeneratedBins) this.instance).getMin();
            }

            public Builder setMin(float f) {
                copyOnWrite();
                ((GeneratedBins) this.instance).setMin(f);
                return this;
            }

            public Builder clearMin() {
                copyOnWrite();
                ((GeneratedBins) this.instance).clearMin();
                return this;
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public boolean hasMax() {
                return ((GeneratedBins) this.instance).hasMax();
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public float getMax() {
                return ((GeneratedBins) this.instance).getMax();
            }

            public Builder setMax(float f) {
                copyOnWrite();
                ((GeneratedBins) this.instance).setMax(f);
                return this;
            }

            public Builder clearMax() {
                copyOnWrite();
                ((GeneratedBins) this.instance).clearMax();
                return this;
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public boolean hasCount() {
                return ((GeneratedBins) this.instance).hasCount();
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public int getCount() {
                return ((GeneratedBins) this.instance).getCount();
            }

            public Builder setCount(int i) {
                copyOnWrite();
                ((GeneratedBins) this.instance).setCount(i);
                return this;
            }

            public Builder clearCount() {
                copyOnWrite();
                ((GeneratedBins) this.instance).clearCount();
                return this;
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public boolean hasStrategy() {
                return ((GeneratedBins) this.instance).hasStrategy();
            }

            @Override // stepos.com.android.os.HistogramBinOption.GeneratedBinsOrBuilder
            public Strategy getStrategy() {
                return ((GeneratedBins) this.instance).getStrategy();
            }

            public Builder setStrategy(Strategy strategy) {
                copyOnWrite();
                ((GeneratedBins) this.instance).setStrategy(strategy);
                return this;
            }

            public Builder clearStrategy() {
                copyOnWrite();
                ((GeneratedBins) this.instance).clearStrategy();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new GeneratedBins();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဌ\u0003", new Object[]{"bitField0_", "min_", "max_", "count_", "strategy_", Strategy.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GeneratedBins> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GeneratedBins.class) {
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
            GeneratedBins generatedBins = new GeneratedBins();
            DEFAULT_INSTANCE = generatedBins;
            GeneratedMessageLite.registerDefaultInstance(GeneratedBins.class, generatedBins);
        }

        public static GeneratedBins getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GeneratedBins> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public enum BinningStrategyCase {
        GENERATED_BINS(1),
        EXPLICIT_BINS(2),
        BINNINGSTRATEGY_NOT_SET(0);

        private final int value;

        BinningStrategyCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static BinningStrategyCase valueOf(int i) {
            return forNumber(i);
        }

        public static BinningStrategyCase forNumber(int i) {
            if (i == 0) {
                return BINNINGSTRATEGY_NOT_SET;
            }
            if (i == 1) {
                return GENERATED_BINS;
            }
            if (i != 2) {
                return null;
            }
            return EXPLICIT_BINS;
        }

        public int getNumber() {
            return this.value;
        }
    }

    @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
    public BinningStrategyCase getBinningStrategyCase() {
        return BinningStrategyCase.forNumber(this.binningStrategyCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBinningStrategy() {
        this.binningStrategyCase_ = 0;
        this.binningStrategy_ = null;
    }

    @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
    public boolean hasGeneratedBins() {
        return this.binningStrategyCase_ == 1;
    }

    @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
    public GeneratedBins getGeneratedBins() {
        if (this.binningStrategyCase_ == 1) {
            return (GeneratedBins) this.binningStrategy_;
        }
        return GeneratedBins.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGeneratedBins(GeneratedBins generatedBins) {
        generatedBins.getClass();
        this.binningStrategy_ = generatedBins;
        this.binningStrategyCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGeneratedBins(GeneratedBins generatedBins) {
        generatedBins.getClass();
        if (this.binningStrategyCase_ == 1 && this.binningStrategy_ != GeneratedBins.getDefaultInstance()) {
            this.binningStrategy_ = GeneratedBins.newBuilder((GeneratedBins) this.binningStrategy_).mergeFrom((GeneratedBins.Builder) generatedBins).buildPartial();
        } else {
            this.binningStrategy_ = generatedBins;
        }
        this.binningStrategyCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGeneratedBins() {
        if (this.binningStrategyCase_ == 1) {
            this.binningStrategyCase_ = 0;
            this.binningStrategy_ = null;
        }
    }

    @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
    public boolean hasExplicitBins() {
        return this.binningStrategyCase_ == 2;
    }

    @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
    public ExplicitBins getExplicitBins() {
        if (this.binningStrategyCase_ == 2) {
            return (ExplicitBins) this.binningStrategy_;
        }
        return ExplicitBins.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExplicitBins(ExplicitBins explicitBins) {
        explicitBins.getClass();
        this.binningStrategy_ = explicitBins;
        this.binningStrategyCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeExplicitBins(ExplicitBins explicitBins) {
        explicitBins.getClass();
        if (this.binningStrategyCase_ == 2 && this.binningStrategy_ != ExplicitBins.getDefaultInstance()) {
            this.binningStrategy_ = ExplicitBins.newBuilder((ExplicitBins) this.binningStrategy_).mergeFrom((ExplicitBins.Builder) explicitBins).buildPartial();
        } else {
            this.binningStrategy_ = explicitBins;
        }
        this.binningStrategyCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExplicitBins() {
        if (this.binningStrategyCase_ == 2) {
            this.binningStrategyCase_ = 0;
            this.binningStrategy_ = null;
        }
    }

    public static HistogramBinOption parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static HistogramBinOption parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HistogramBinOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HistogramBinOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HistogramBinOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HistogramBinOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HistogramBinOption parseFrom(InputStream inputStream) throws IOException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HistogramBinOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HistogramBinOption parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HistogramBinOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HistogramBinOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HistogramBinOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HistogramBinOption parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HistogramBinOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HistogramBinOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HistogramBinOption histogramBinOption) {
        return DEFAULT_INSTANCE.createBuilder(histogramBinOption);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HistogramBinOption, Builder> implements HistogramBinOptionOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(HistogramBinOption.DEFAULT_INSTANCE);
        }

        @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
        public BinningStrategyCase getBinningStrategyCase() {
            return ((HistogramBinOption) this.instance).getBinningStrategyCase();
        }

        public Builder clearBinningStrategy() {
            copyOnWrite();
            ((HistogramBinOption) this.instance).clearBinningStrategy();
            return this;
        }

        @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
        public boolean hasGeneratedBins() {
            return ((HistogramBinOption) this.instance).hasGeneratedBins();
        }

        @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
        public GeneratedBins getGeneratedBins() {
            return ((HistogramBinOption) this.instance).getGeneratedBins();
        }

        public Builder setGeneratedBins(GeneratedBins generatedBins) {
            copyOnWrite();
            ((HistogramBinOption) this.instance).setGeneratedBins(generatedBins);
            return this;
        }

        public Builder setGeneratedBins(GeneratedBins.Builder builder) {
            copyOnWrite();
            ((HistogramBinOption) this.instance).setGeneratedBins(builder.build());
            return this;
        }

        public Builder mergeGeneratedBins(GeneratedBins generatedBins) {
            copyOnWrite();
            ((HistogramBinOption) this.instance).mergeGeneratedBins(generatedBins);
            return this;
        }

        public Builder clearGeneratedBins() {
            copyOnWrite();
            ((HistogramBinOption) this.instance).clearGeneratedBins();
            return this;
        }

        @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
        public boolean hasExplicitBins() {
            return ((HistogramBinOption) this.instance).hasExplicitBins();
        }

        @Override // stepos.com.android.os.HistogramBinOptionOrBuilder
        public ExplicitBins getExplicitBins() {
            return ((HistogramBinOption) this.instance).getExplicitBins();
        }

        public Builder setExplicitBins(ExplicitBins explicitBins) {
            copyOnWrite();
            ((HistogramBinOption) this.instance).setExplicitBins(explicitBins);
            return this;
        }

        public Builder setExplicitBins(ExplicitBins.Builder builder) {
            copyOnWrite();
            ((HistogramBinOption) this.instance).setExplicitBins(builder.build());
            return this;
        }

        public Builder mergeExplicitBins(ExplicitBins explicitBins) {
            copyOnWrite();
            ((HistogramBinOption) this.instance).mergeExplicitBins(explicitBins);
            return this;
        }

        public Builder clearExplicitBins() {
            copyOnWrite();
            ((HistogramBinOption) this.instance).clearExplicitBins();
            return this;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new HistogramBinOption();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0001\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ြ\u0000\u0002ြ\u0000", new Object[]{"binningStrategy_", "binningStrategyCase_", "bitField0_", GeneratedBins.class, ExplicitBins.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HistogramBinOption> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HistogramBinOption.class) {
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
        HistogramBinOption histogramBinOption = new HistogramBinOption();
        DEFAULT_INSTANCE = histogramBinOption;
        GeneratedMessageLite.registerDefaultInstance(HistogramBinOption.class, histogramBinOption);
    }

    public static HistogramBinOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HistogramBinOption> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
