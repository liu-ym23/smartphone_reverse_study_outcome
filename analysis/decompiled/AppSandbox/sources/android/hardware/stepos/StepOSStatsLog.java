package android.hardware.stepos;

import android.hardware.stepos.StepOSAtoms;
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
public final class StepOSStatsLog {

    public interface AggregatedAtomInfoOrBuilder extends MessageLiteOrBuilder {
        StepOSAtoms.Atom getAtom();

        long getElapsedTimestampNanos(int i);

        int getElapsedTimestampNanosCount();

        List<Long> getElapsedTimestampNanosList();

        boolean hasAtom();
    }

    public interface ConfigMetricsReportListOrBuilder extends MessageLiteOrBuilder {
        ConfigMetricsReportList.ConfigKey getConfigKey();

        ConfigMetricsReport getReports(int i);

        int getReportsCount();

        List<ConfigMetricsReport> getReportsList();

        boolean hasConfigKey();
    }

    public interface ConfigMetricsReportOrBuilder extends MessageLiteOrBuilder {
        StatsLogReport getMetrics(int i);

        int getMetricsCount();

        List<StatsLogReport> getMetricsList();

        String getStrings(int i);

        ByteString getStringsBytes(int i);

        int getStringsCount();

        List<String> getStringsList();
    }

    public interface DimensionsValueOrBuilder extends MessageLiteOrBuilder {
        int getField();

        boolean getValueBool();

        DimensionsValue.ValueCase getValueCase();

        float getValueFloat();

        int getValueInt();

        long getValueLong();

        String getValueStr();

        ByteString getValueStrBytes();

        long getValueStrHash();

        DimensionsValueTuple getValueTuple();

        boolean hasField();

        boolean hasValueBool();

        boolean hasValueFloat();

        boolean hasValueInt();

        boolean hasValueLong();

        boolean hasValueStr();

        boolean hasValueStrHash();

        boolean hasValueTuple();
    }

    public interface DimensionsValueTupleOrBuilder extends MessageLiteOrBuilder {
        DimensionsValue getDimensionsValue(int i);

        int getDimensionsValueCount();

        List<DimensionsValue> getDimensionsValueList();
    }

    public interface EventMetricDataOrBuilder extends MessageLiteOrBuilder {
        AggregatedAtomInfo getAggregatedAtomInfo();

        StepOSAtoms.Atom getAtom();

        long getElapsedTimestampNanos();

        boolean hasAggregatedAtomInfo();

        boolean hasAtom();

        boolean hasElapsedTimestampNanos();
    }

    public interface GaugeBucketInfoOrBuilder extends MessageLiteOrBuilder {
        AggregatedAtomInfo getAggregatedAtomInfo(int i);

        int getAggregatedAtomInfoCount();

        List<AggregatedAtomInfo> getAggregatedAtomInfoList();

        StepOSAtoms.Atom getAtom(int i);

        int getAtomCount();

        List<StepOSAtoms.Atom> getAtomList();

        long getElapsedTimestampNanos(int i);

        int getElapsedTimestampNanosCount();

        List<Long> getElapsedTimestampNanosList();
    }

    public interface GaugeMetricDataOrBuilder extends MessageLiteOrBuilder {
        GaugeBucketInfo getBucketInfo(int i);

        int getBucketInfoCount();

        List<GaugeBucketInfo> getBucketInfoList();

        DimensionsValue getDimensionLeafValuesInWhat(int i);

        int getDimensionLeafValuesInWhatCount();

        List<DimensionsValue> getDimensionLeafValuesInWhatList();
    }

    public interface StatsLogReportOrBuilder extends MessageLiteOrBuilder {
        StatsLogReport.DataCase getDataCase();

        DimensionsValue getDimensionsPathInWhat();

        StatsLogReport.EventMetricDataWrapper getEventMetrics();

        StatsLogReport.GaugeMetricDataWrapper getGaugeMetrics();

        boolean getIsActive();

        long getMetricId();

        boolean hasDimensionsPathInWhat();

        boolean hasEventMetrics();

        boolean hasGaugeMetrics();

        boolean hasIsActive();

        boolean hasMetricId();
    }

    public interface StatsdStatsReportOrBuilder extends MessageLiteOrBuilder {
        StatsdStatsReport.ConfigStats getConfigStats(int i);

        int getConfigStatsCount();

        List<StatsdStatsReport.ConfigStats> getConfigStatsList();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private StepOSStatsLog() {
    }

    public static final class DimensionsValueTuple extends GeneratedMessageLite<DimensionsValueTuple, Builder> implements DimensionsValueTupleOrBuilder {
        private static final DimensionsValueTuple DEFAULT_INSTANCE;
        public static final int DIMENSIONS_VALUE_FIELD_NUMBER = 1;
        private static volatile Parser<DimensionsValueTuple> PARSER;
        private Internal.ProtobufList<DimensionsValue> dimensionsValue_ = emptyProtobufList();

        private DimensionsValueTuple() {
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueTupleOrBuilder
        public List<DimensionsValue> getDimensionsValueList() {
            return this.dimensionsValue_;
        }

        public List<? extends DimensionsValueOrBuilder> getDimensionsValueOrBuilderList() {
            return this.dimensionsValue_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueTupleOrBuilder
        public int getDimensionsValueCount() {
            return this.dimensionsValue_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueTupleOrBuilder
        public DimensionsValue getDimensionsValue(int i) {
            return this.dimensionsValue_.get(i);
        }

        public DimensionsValueOrBuilder getDimensionsValueOrBuilder(int i) {
            return this.dimensionsValue_.get(i);
        }

        private void ensureDimensionsValueIsMutable() {
            Internal.ProtobufList<DimensionsValue> protobufList = this.dimensionsValue_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dimensionsValue_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDimensionsValue(int i, DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            ensureDimensionsValueIsMutable();
            this.dimensionsValue_.set(i, dimensionsValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDimensionsValue(DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            ensureDimensionsValueIsMutable();
            this.dimensionsValue_.add(dimensionsValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDimensionsValue(int i, DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            ensureDimensionsValueIsMutable();
            this.dimensionsValue_.add(i, dimensionsValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDimensionsValue(Iterable<? extends DimensionsValue> iterable) {
            ensureDimensionsValueIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dimensionsValue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDimensionsValue() {
            this.dimensionsValue_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDimensionsValue(int i) {
            ensureDimensionsValueIsMutable();
            this.dimensionsValue_.remove(i);
        }

        public static DimensionsValueTuple parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DimensionsValueTuple parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DimensionsValueTuple parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DimensionsValueTuple parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DimensionsValueTuple parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DimensionsValueTuple parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DimensionsValueTuple parseFrom(InputStream inputStream) throws IOException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DimensionsValueTuple parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DimensionsValueTuple parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DimensionsValueTuple) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DimensionsValueTuple parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DimensionsValueTuple) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DimensionsValueTuple parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DimensionsValueTuple parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DimensionsValueTuple) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DimensionsValueTuple dimensionsValueTuple) {
            return DEFAULT_INSTANCE.createBuilder(dimensionsValueTuple);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DimensionsValueTuple, Builder> implements DimensionsValueTupleOrBuilder {
            private Builder() {
                super(DimensionsValueTuple.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueTupleOrBuilder
            public List<DimensionsValue> getDimensionsValueList() {
                return Collections.unmodifiableList(((DimensionsValueTuple) this.instance).getDimensionsValueList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueTupleOrBuilder
            public int getDimensionsValueCount() {
                return ((DimensionsValueTuple) this.instance).getDimensionsValueCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueTupleOrBuilder
            public DimensionsValue getDimensionsValue(int i) {
                return ((DimensionsValueTuple) this.instance).getDimensionsValue(i);
            }

            public Builder setDimensionsValue(int i, DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).setDimensionsValue(i, dimensionsValue);
                return this;
            }

            public Builder setDimensionsValue(int i, DimensionsValue.Builder builder) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).setDimensionsValue(i, builder.build());
                return this;
            }

            public Builder addDimensionsValue(DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).addDimensionsValue(dimensionsValue);
                return this;
            }

            public Builder addDimensionsValue(int i, DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).addDimensionsValue(i, dimensionsValue);
                return this;
            }

            public Builder addDimensionsValue(DimensionsValue.Builder builder) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).addDimensionsValue(builder.build());
                return this;
            }

            public Builder addDimensionsValue(int i, DimensionsValue.Builder builder) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).addDimensionsValue(i, builder.build());
                return this;
            }

            public Builder addAllDimensionsValue(Iterable<? extends DimensionsValue> iterable) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).addAllDimensionsValue(iterable);
                return this;
            }

            public Builder clearDimensionsValue() {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).clearDimensionsValue();
                return this;
            }

            public Builder removeDimensionsValue(int i) {
                copyOnWrite();
                ((DimensionsValueTuple) this.instance).removeDimensionsValue(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new DimensionsValueTuple();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"dimensionsValue_", DimensionsValue.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DimensionsValueTuple> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DimensionsValueTuple.class) {
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
            DimensionsValueTuple dimensionsValueTuple = new DimensionsValueTuple();
            DEFAULT_INSTANCE = dimensionsValueTuple;
            GeneratedMessageLite.registerDefaultInstance(DimensionsValueTuple.class, dimensionsValueTuple);
        }

        public static DimensionsValueTuple getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DimensionsValueTuple> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: android.hardware.stepos.StepOSStatsLog$1, reason: invalid class name */
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

    public static final class DimensionsValue extends GeneratedMessageLite<DimensionsValue, Builder> implements DimensionsValueOrBuilder {
        private static final DimensionsValue DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile Parser<DimensionsValue> PARSER = null;
        public static final int VALUE_BOOL_FIELD_NUMBER = 5;
        public static final int VALUE_FLOAT_FIELD_NUMBER = 6;
        public static final int VALUE_INT_FIELD_NUMBER = 3;
        public static final int VALUE_LONG_FIELD_NUMBER = 4;
        public static final int VALUE_STR_FIELD_NUMBER = 2;
        public static final int VALUE_STR_HASH_FIELD_NUMBER = 8;
        public static final int VALUE_TUPLE_FIELD_NUMBER = 7;
        private int bitField0_;
        private int field_;
        private int valueCase_ = 0;
        private Object value_;

        private DimensionsValue() {
        }

        public enum ValueCase {
            VALUE_STR(2),
            VALUE_INT(3),
            VALUE_LONG(4),
            VALUE_BOOL(5),
            VALUE_FLOAT(6),
            VALUE_TUPLE(7),
            VALUE_STR_HASH(8),
            VALUE_NOT_SET(0);

            private final int value;

            ValueCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static ValueCase valueOf(int i) {
                return forNumber(i);
            }

            public static ValueCase forNumber(int i) {
                if (i != 0) {
                    switch (i) {
                        case 2:
                            return VALUE_STR;
                        case 3:
                            return VALUE_INT;
                        case 4:
                            return VALUE_LONG;
                        case 5:
                            return VALUE_BOOL;
                        case 6:
                            return VALUE_FLOAT;
                        case 7:
                            return VALUE_TUPLE;
                        case 8:
                            return VALUE_STR_HASH;
                        default:
                            return null;
                    }
                }
                return VALUE_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public ValueCase getValueCase() {
            return ValueCase.forNumber(this.valueCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.valueCase_ = 0;
            this.value_ = null;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasField() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public int getField() {
            return this.field_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(int i) {
            this.bitField0_ |= 1;
            this.field_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearField() {
            this.bitField0_ &= -2;
            this.field_ = 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasValueStr() {
            return this.valueCase_ == 2;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public String getValueStr() {
            if (this.valueCase_ == 2) {
                return (String) this.value_;
            }
            return "";
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public ByteString getValueStrBytes() {
            String str;
            if (this.valueCase_ != 2) {
                str = "";
            } else {
                str = (String) this.value_;
            }
            return ByteString.copyFromUtf8(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueStr(String str) {
            str.getClass();
            this.valueCase_ = 2;
            this.value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValueStr() {
            if (this.valueCase_ == 2) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueStrBytes(ByteString byteString) {
            this.value_ = byteString.toStringUtf8();
            this.valueCase_ = 2;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasValueInt() {
            return this.valueCase_ == 3;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public int getValueInt() {
            if (this.valueCase_ == 3) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueInt(int i) {
            this.valueCase_ = 3;
            this.value_ = Integer.valueOf(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValueInt() {
            if (this.valueCase_ == 3) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasValueLong() {
            return this.valueCase_ == 4;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public long getValueLong() {
            if (this.valueCase_ == 4) {
                return ((Long) this.value_).longValue();
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueLong(long j) {
            this.valueCase_ = 4;
            this.value_ = Long.valueOf(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValueLong() {
            if (this.valueCase_ == 4) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasValueBool() {
            return this.valueCase_ == 5;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean getValueBool() {
            if (this.valueCase_ == 5) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueBool(boolean z) {
            this.valueCase_ = 5;
            this.value_ = Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValueBool() {
            if (this.valueCase_ == 5) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasValueFloat() {
            return this.valueCase_ == 6;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public float getValueFloat() {
            if (this.valueCase_ == 6) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueFloat(float f) {
            this.valueCase_ = 6;
            this.value_ = Float.valueOf(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValueFloat() {
            if (this.valueCase_ == 6) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasValueTuple() {
            return this.valueCase_ == 7;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public DimensionsValueTuple getValueTuple() {
            if (this.valueCase_ == 7) {
                return (DimensionsValueTuple) this.value_;
            }
            return DimensionsValueTuple.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueTuple(DimensionsValueTuple dimensionsValueTuple) {
            dimensionsValueTuple.getClass();
            this.value_ = dimensionsValueTuple;
            this.valueCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeValueTuple(DimensionsValueTuple dimensionsValueTuple) {
            dimensionsValueTuple.getClass();
            if (this.valueCase_ == 7 && this.value_ != DimensionsValueTuple.getDefaultInstance()) {
                this.value_ = DimensionsValueTuple.newBuilder((DimensionsValueTuple) this.value_).mergeFrom((DimensionsValueTuple.Builder) dimensionsValueTuple).buildPartial();
            } else {
                this.value_ = dimensionsValueTuple;
            }
            this.valueCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValueTuple() {
            if (this.valueCase_ == 7) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public boolean hasValueStrHash() {
            return this.valueCase_ == 8;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
        public long getValueStrHash() {
            if (this.valueCase_ == 8) {
                return ((Long) this.value_).longValue();
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueStrHash(long j) {
            this.valueCase_ = 8;
            this.value_ = Long.valueOf(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValueStrHash() {
            if (this.valueCase_ == 8) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        public static DimensionsValue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DimensionsValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DimensionsValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DimensionsValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DimensionsValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DimensionsValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DimensionsValue parseFrom(InputStream inputStream) throws IOException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DimensionsValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DimensionsValue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DimensionsValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DimensionsValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DimensionsValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DimensionsValue parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DimensionsValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DimensionsValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DimensionsValue dimensionsValue) {
            return DEFAULT_INSTANCE.createBuilder(dimensionsValue);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DimensionsValue, Builder> implements DimensionsValueOrBuilder {
            private Builder() {
                super(DimensionsValue.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public ValueCase getValueCase() {
                return ((DimensionsValue) this.instance).getValueCase();
            }

            public Builder clearValue() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValue();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasField() {
                return ((DimensionsValue) this.instance).hasField();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public int getField() {
                return ((DimensionsValue) this.instance).getField();
            }

            public Builder setField(int i) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setField(i);
                return this;
            }

            public Builder clearField() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearField();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasValueStr() {
                return ((DimensionsValue) this.instance).hasValueStr();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public String getValueStr() {
                return ((DimensionsValue) this.instance).getValueStr();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public ByteString getValueStrBytes() {
                return ((DimensionsValue) this.instance).getValueStrBytes();
            }

            public Builder setValueStr(String str) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueStr(str);
                return this;
            }

            public Builder clearValueStr() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValueStr();
                return this;
            }

            public Builder setValueStrBytes(ByteString byteString) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueStrBytes(byteString);
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasValueInt() {
                return ((DimensionsValue) this.instance).hasValueInt();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public int getValueInt() {
                return ((DimensionsValue) this.instance).getValueInt();
            }

            public Builder setValueInt(int i) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueInt(i);
                return this;
            }

            public Builder clearValueInt() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValueInt();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasValueLong() {
                return ((DimensionsValue) this.instance).hasValueLong();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public long getValueLong() {
                return ((DimensionsValue) this.instance).getValueLong();
            }

            public Builder setValueLong(long j) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueLong(j);
                return this;
            }

            public Builder clearValueLong() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValueLong();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasValueBool() {
                return ((DimensionsValue) this.instance).hasValueBool();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean getValueBool() {
                return ((DimensionsValue) this.instance).getValueBool();
            }

            public Builder setValueBool(boolean z) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueBool(z);
                return this;
            }

            public Builder clearValueBool() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValueBool();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasValueFloat() {
                return ((DimensionsValue) this.instance).hasValueFloat();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public float getValueFloat() {
                return ((DimensionsValue) this.instance).getValueFloat();
            }

            public Builder setValueFloat(float f) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueFloat(f);
                return this;
            }

            public Builder clearValueFloat() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValueFloat();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasValueTuple() {
                return ((DimensionsValue) this.instance).hasValueTuple();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public DimensionsValueTuple getValueTuple() {
                return ((DimensionsValue) this.instance).getValueTuple();
            }

            public Builder setValueTuple(DimensionsValueTuple dimensionsValueTuple) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueTuple(dimensionsValueTuple);
                return this;
            }

            public Builder setValueTuple(DimensionsValueTuple.Builder builder) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueTuple(builder.build());
                return this;
            }

            public Builder mergeValueTuple(DimensionsValueTuple dimensionsValueTuple) {
                copyOnWrite();
                ((DimensionsValue) this.instance).mergeValueTuple(dimensionsValueTuple);
                return this;
            }

            public Builder clearValueTuple() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValueTuple();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public boolean hasValueStrHash() {
                return ((DimensionsValue) this.instance).hasValueStrHash();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.DimensionsValueOrBuilder
            public long getValueStrHash() {
                return ((DimensionsValue) this.instance).getValueStrHash();
            }

            public Builder setValueStrHash(long j) {
                copyOnWrite();
                ((DimensionsValue) this.instance).setValueStrHash(j);
                return this;
            }

            public Builder clearValueStrHash() {
                copyOnWrite();
                ((DimensionsValue) this.instance).clearValueStrHash();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new DimensionsValue();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001င\u0000\u0002ျ\u0000\u0003့\u0000\u0004ဵ\u0000\u0005်\u0000\u0006ဴ\u0000\u0007ြ\u0000\bံ\u0000", new Object[]{"value_", "valueCase_", "bitField0_", "field_", DimensionsValueTuple.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DimensionsValue> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DimensionsValue.class) {
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
            DimensionsValue dimensionsValue = new DimensionsValue();
            DEFAULT_INSTANCE = dimensionsValue;
            GeneratedMessageLite.registerDefaultInstance(DimensionsValue.class, dimensionsValue);
        }

        public static DimensionsValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DimensionsValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregatedAtomInfo extends GeneratedMessageLite<AggregatedAtomInfo, Builder> implements AggregatedAtomInfoOrBuilder {
        public static final int ATOM_FIELD_NUMBER = 1;
        private static final AggregatedAtomInfo DEFAULT_INSTANCE;
        public static final int ELAPSED_TIMESTAMP_NANOS_FIELD_NUMBER = 2;
        private static volatile Parser<AggregatedAtomInfo> PARSER;
        private StepOSAtoms.Atom atom_;
        private int bitField0_;
        private Internal.LongList elapsedTimestampNanos_ = emptyLongList();

        private AggregatedAtomInfo() {
        }

        @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
        public boolean hasAtom() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
        public StepOSAtoms.Atom getAtom() {
            StepOSAtoms.Atom atom = this.atom_;
            return atom == null ? StepOSAtoms.Atom.getDefaultInstance() : atom;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAtom(StepOSAtoms.Atom atom) {
            atom.getClass();
            this.atom_ = atom;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAtom(StepOSAtoms.Atom atom) {
            atom.getClass();
            StepOSAtoms.Atom atom2 = this.atom_;
            if (atom2 != null && atom2 != StepOSAtoms.Atom.getDefaultInstance()) {
                this.atom_ = StepOSAtoms.Atom.newBuilder(this.atom_).mergeFrom((StepOSAtoms.Atom.Builder) atom).buildPartial();
            } else {
                this.atom_ = atom;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAtom() {
            this.atom_ = null;
            this.bitField0_ &= -2;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
        public List<Long> getElapsedTimestampNanosList() {
            return this.elapsedTimestampNanos_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
        public int getElapsedTimestampNanosCount() {
            return this.elapsedTimestampNanos_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
        public long getElapsedTimestampNanos(int i) {
            return this.elapsedTimestampNanos_.getLong(i);
        }

        private void ensureElapsedTimestampNanosIsMutable() {
            Internal.LongList longList = this.elapsedTimestampNanos_;
            if (longList.isModifiable()) {
                return;
            }
            this.elapsedTimestampNanos_ = GeneratedMessageLite.mutableCopy(longList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setElapsedTimestampNanos(int i, long j) {
            ensureElapsedTimestampNanosIsMutable();
            this.elapsedTimestampNanos_.setLong(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addElapsedTimestampNanos(long j) {
            ensureElapsedTimestampNanosIsMutable();
            this.elapsedTimestampNanos_.addLong(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllElapsedTimestampNanos(Iterable<? extends Long> iterable) {
            ensureElapsedTimestampNanosIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.elapsedTimestampNanos_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearElapsedTimestampNanos() {
            this.elapsedTimestampNanos_ = emptyLongList();
        }

        public static AggregatedAtomInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AggregatedAtomInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AggregatedAtomInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AggregatedAtomInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AggregatedAtomInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AggregatedAtomInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AggregatedAtomInfo parseFrom(InputStream inputStream) throws IOException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregatedAtomInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregatedAtomInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AggregatedAtomInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregatedAtomInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregatedAtomInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregatedAtomInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AggregatedAtomInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregatedAtomInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregatedAtomInfo aggregatedAtomInfo) {
            return DEFAULT_INSTANCE.createBuilder(aggregatedAtomInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregatedAtomInfo, Builder> implements AggregatedAtomInfoOrBuilder {
            private Builder() {
                super(AggregatedAtomInfo.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
            public boolean hasAtom() {
                return ((AggregatedAtomInfo) this.instance).hasAtom();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
            public StepOSAtoms.Atom getAtom() {
                return ((AggregatedAtomInfo) this.instance).getAtom();
            }

            public Builder setAtom(StepOSAtoms.Atom atom) {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).setAtom(atom);
                return this;
            }

            public Builder setAtom(StepOSAtoms.Atom.Builder builder) {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).setAtom(builder.build());
                return this;
            }

            public Builder mergeAtom(StepOSAtoms.Atom atom) {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).mergeAtom(atom);
                return this;
            }

            public Builder clearAtom() {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).clearAtom();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
            public List<Long> getElapsedTimestampNanosList() {
                return Collections.unmodifiableList(((AggregatedAtomInfo) this.instance).getElapsedTimestampNanosList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
            public int getElapsedTimestampNanosCount() {
                return ((AggregatedAtomInfo) this.instance).getElapsedTimestampNanosCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.AggregatedAtomInfoOrBuilder
            public long getElapsedTimestampNanos(int i) {
                return ((AggregatedAtomInfo) this.instance).getElapsedTimestampNanos(i);
            }

            public Builder setElapsedTimestampNanos(int i, long j) {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).setElapsedTimestampNanos(i, j);
                return this;
            }

            public Builder addElapsedTimestampNanos(long j) {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).addElapsedTimestampNanos(j);
                return this;
            }

            public Builder addAllElapsedTimestampNanos(Iterable<? extends Long> iterable) {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).addAllElapsedTimestampNanos(iterable);
                return this;
            }

            public Builder clearElapsedTimestampNanos() {
                copyOnWrite();
                ((AggregatedAtomInfo) this.instance).clearElapsedTimestampNanos();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new AggregatedAtomInfo();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0014", new Object[]{"bitField0_", "atom_", "elapsedTimestampNanos_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AggregatedAtomInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (AggregatedAtomInfo.class) {
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
            AggregatedAtomInfo aggregatedAtomInfo = new AggregatedAtomInfo();
            DEFAULT_INSTANCE = aggregatedAtomInfo;
            GeneratedMessageLite.registerDefaultInstance(AggregatedAtomInfo.class, aggregatedAtomInfo);
        }

        public static AggregatedAtomInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregatedAtomInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EventMetricData extends GeneratedMessageLite<EventMetricData, Builder> implements EventMetricDataOrBuilder {
        public static final int AGGREGATED_ATOM_INFO_FIELD_NUMBER = 4;
        public static final int ATOM_FIELD_NUMBER = 2;
        private static final EventMetricData DEFAULT_INSTANCE;
        public static final int ELAPSED_TIMESTAMP_NANOS_FIELD_NUMBER = 1;
        private static volatile Parser<EventMetricData> PARSER;
        private AggregatedAtomInfo aggregatedAtomInfo_;
        private StepOSAtoms.Atom atom_;
        private int bitField0_;
        private long elapsedTimestampNanos_;

        private EventMetricData() {
        }

        @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
        public boolean hasElapsedTimestampNanos() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
        public long getElapsedTimestampNanos() {
            return this.elapsedTimestampNanos_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setElapsedTimestampNanos(long j) {
            this.bitField0_ |= 1;
            this.elapsedTimestampNanos_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearElapsedTimestampNanos() {
            this.bitField0_ &= -2;
            this.elapsedTimestampNanos_ = 0L;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
        public boolean hasAtom() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
        public StepOSAtoms.Atom getAtom() {
            StepOSAtoms.Atom atom = this.atom_;
            return atom == null ? StepOSAtoms.Atom.getDefaultInstance() : atom;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAtom(StepOSAtoms.Atom atom) {
            atom.getClass();
            this.atom_ = atom;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAtom(StepOSAtoms.Atom atom) {
            atom.getClass();
            StepOSAtoms.Atom atom2 = this.atom_;
            if (atom2 != null && atom2 != StepOSAtoms.Atom.getDefaultInstance()) {
                this.atom_ = StepOSAtoms.Atom.newBuilder(this.atom_).mergeFrom((StepOSAtoms.Atom.Builder) atom).buildPartial();
            } else {
                this.atom_ = atom;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAtom() {
            this.atom_ = null;
            this.bitField0_ &= -3;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
        public boolean hasAggregatedAtomInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
        public AggregatedAtomInfo getAggregatedAtomInfo() {
            AggregatedAtomInfo aggregatedAtomInfo = this.aggregatedAtomInfo_;
            return aggregatedAtomInfo == null ? AggregatedAtomInfo.getDefaultInstance() : aggregatedAtomInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregatedAtomInfo(AggregatedAtomInfo aggregatedAtomInfo) {
            aggregatedAtomInfo.getClass();
            this.aggregatedAtomInfo_ = aggregatedAtomInfo;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAggregatedAtomInfo(AggregatedAtomInfo aggregatedAtomInfo) {
            aggregatedAtomInfo.getClass();
            AggregatedAtomInfo aggregatedAtomInfo2 = this.aggregatedAtomInfo_;
            if (aggregatedAtomInfo2 != null && aggregatedAtomInfo2 != AggregatedAtomInfo.getDefaultInstance()) {
                this.aggregatedAtomInfo_ = AggregatedAtomInfo.newBuilder(this.aggregatedAtomInfo_).mergeFrom((AggregatedAtomInfo.Builder) aggregatedAtomInfo).buildPartial();
            } else {
                this.aggregatedAtomInfo_ = aggregatedAtomInfo;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAggregatedAtomInfo() {
            this.aggregatedAtomInfo_ = null;
            this.bitField0_ &= -5;
        }

        public static EventMetricData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EventMetricData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EventMetricData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EventMetricData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EventMetricData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EventMetricData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EventMetricData parseFrom(InputStream inputStream) throws IOException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventMetricData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventMetricData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EventMetricData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventMetricData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventMetricData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventMetricData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EventMetricData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EventMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(EventMetricData eventMetricData) {
            return DEFAULT_INSTANCE.createBuilder(eventMetricData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EventMetricData, Builder> implements EventMetricDataOrBuilder {
            private Builder() {
                super(EventMetricData.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
            public boolean hasElapsedTimestampNanos() {
                return ((EventMetricData) this.instance).hasElapsedTimestampNanos();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
            public long getElapsedTimestampNanos() {
                return ((EventMetricData) this.instance).getElapsedTimestampNanos();
            }

            public Builder setElapsedTimestampNanos(long j) {
                copyOnWrite();
                ((EventMetricData) this.instance).setElapsedTimestampNanos(j);
                return this;
            }

            public Builder clearElapsedTimestampNanos() {
                copyOnWrite();
                ((EventMetricData) this.instance).clearElapsedTimestampNanos();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
            public boolean hasAtom() {
                return ((EventMetricData) this.instance).hasAtom();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
            public StepOSAtoms.Atom getAtom() {
                return ((EventMetricData) this.instance).getAtom();
            }

            public Builder setAtom(StepOSAtoms.Atom atom) {
                copyOnWrite();
                ((EventMetricData) this.instance).setAtom(atom);
                return this;
            }

            public Builder setAtom(StepOSAtoms.Atom.Builder builder) {
                copyOnWrite();
                ((EventMetricData) this.instance).setAtom(builder.build());
                return this;
            }

            public Builder mergeAtom(StepOSAtoms.Atom atom) {
                copyOnWrite();
                ((EventMetricData) this.instance).mergeAtom(atom);
                return this;
            }

            public Builder clearAtom() {
                copyOnWrite();
                ((EventMetricData) this.instance).clearAtom();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
            public boolean hasAggregatedAtomInfo() {
                return ((EventMetricData) this.instance).hasAggregatedAtomInfo();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.EventMetricDataOrBuilder
            public AggregatedAtomInfo getAggregatedAtomInfo() {
                return ((EventMetricData) this.instance).getAggregatedAtomInfo();
            }

            public Builder setAggregatedAtomInfo(AggregatedAtomInfo aggregatedAtomInfo) {
                copyOnWrite();
                ((EventMetricData) this.instance).setAggregatedAtomInfo(aggregatedAtomInfo);
                return this;
            }

            public Builder setAggregatedAtomInfo(AggregatedAtomInfo.Builder builder) {
                copyOnWrite();
                ((EventMetricData) this.instance).setAggregatedAtomInfo(builder.build());
                return this;
            }

            public Builder mergeAggregatedAtomInfo(AggregatedAtomInfo aggregatedAtomInfo) {
                copyOnWrite();
                ((EventMetricData) this.instance).mergeAggregatedAtomInfo(aggregatedAtomInfo);
                return this;
            }

            public Builder clearAggregatedAtomInfo() {
                copyOnWrite();
                ((EventMetricData) this.instance).clearAggregatedAtomInfo();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new EventMetricData();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "elapsedTimestampNanos_", "atom_", "aggregatedAtomInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EventMetricData> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EventMetricData.class) {
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
            EventMetricData eventMetricData = new EventMetricData();
            DEFAULT_INSTANCE = eventMetricData;
            GeneratedMessageLite.registerDefaultInstance(EventMetricData.class, eventMetricData);
        }

        public static EventMetricData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EventMetricData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GaugeBucketInfo extends GeneratedMessageLite<GaugeBucketInfo, Builder> implements GaugeBucketInfoOrBuilder {
        public static final int AGGREGATED_ATOM_INFO_FIELD_NUMBER = 9;
        public static final int ATOM_FIELD_NUMBER = 3;
        private static final GaugeBucketInfo DEFAULT_INSTANCE;
        public static final int ELAPSED_TIMESTAMP_NANOS_FIELD_NUMBER = 4;
        private static volatile Parser<GaugeBucketInfo> PARSER;
        private Internal.ProtobufList<StepOSAtoms.Atom> atom_ = emptyProtobufList();
        private Internal.LongList elapsedTimestampNanos_ = emptyLongList();
        private Internal.ProtobufList<AggregatedAtomInfo> aggregatedAtomInfo_ = emptyProtobufList();

        private GaugeBucketInfo() {
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public List<StepOSAtoms.Atom> getAtomList() {
            return this.atom_;
        }

        public List<? extends StepOSAtoms.AtomOrBuilder> getAtomOrBuilderList() {
            return this.atom_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public int getAtomCount() {
            return this.atom_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public StepOSAtoms.Atom getAtom(int i) {
            return this.atom_.get(i);
        }

        public StepOSAtoms.AtomOrBuilder getAtomOrBuilder(int i) {
            return this.atom_.get(i);
        }

        private void ensureAtomIsMutable() {
            Internal.ProtobufList<StepOSAtoms.Atom> protobufList = this.atom_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.atom_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAtom(int i, StepOSAtoms.Atom atom) {
            atom.getClass();
            ensureAtomIsMutable();
            this.atom_.set(i, atom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAtom(StepOSAtoms.Atom atom) {
            atom.getClass();
            ensureAtomIsMutable();
            this.atom_.add(atom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAtom(int i, StepOSAtoms.Atom atom) {
            atom.getClass();
            ensureAtomIsMutable();
            this.atom_.add(i, atom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAtom(Iterable<? extends StepOSAtoms.Atom> iterable) {
            ensureAtomIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.atom_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAtom() {
            this.atom_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAtom(int i) {
            ensureAtomIsMutable();
            this.atom_.remove(i);
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public List<Long> getElapsedTimestampNanosList() {
            return this.elapsedTimestampNanos_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public int getElapsedTimestampNanosCount() {
            return this.elapsedTimestampNanos_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public long getElapsedTimestampNanos(int i) {
            return this.elapsedTimestampNanos_.getLong(i);
        }

        private void ensureElapsedTimestampNanosIsMutable() {
            Internal.LongList longList = this.elapsedTimestampNanos_;
            if (longList.isModifiable()) {
                return;
            }
            this.elapsedTimestampNanos_ = GeneratedMessageLite.mutableCopy(longList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setElapsedTimestampNanos(int i, long j) {
            ensureElapsedTimestampNanosIsMutable();
            this.elapsedTimestampNanos_.setLong(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addElapsedTimestampNanos(long j) {
            ensureElapsedTimestampNanosIsMutable();
            this.elapsedTimestampNanos_.addLong(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllElapsedTimestampNanos(Iterable<? extends Long> iterable) {
            ensureElapsedTimestampNanosIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.elapsedTimestampNanos_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearElapsedTimestampNanos() {
            this.elapsedTimestampNanos_ = emptyLongList();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public List<AggregatedAtomInfo> getAggregatedAtomInfoList() {
            return this.aggregatedAtomInfo_;
        }

        public List<? extends AggregatedAtomInfoOrBuilder> getAggregatedAtomInfoOrBuilderList() {
            return this.aggregatedAtomInfo_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public int getAggregatedAtomInfoCount() {
            return this.aggregatedAtomInfo_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
        public AggregatedAtomInfo getAggregatedAtomInfo(int i) {
            return this.aggregatedAtomInfo_.get(i);
        }

        public AggregatedAtomInfoOrBuilder getAggregatedAtomInfoOrBuilder(int i) {
            return this.aggregatedAtomInfo_.get(i);
        }

        private void ensureAggregatedAtomInfoIsMutable() {
            Internal.ProtobufList<AggregatedAtomInfo> protobufList = this.aggregatedAtomInfo_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.aggregatedAtomInfo_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregatedAtomInfo(int i, AggregatedAtomInfo aggregatedAtomInfo) {
            aggregatedAtomInfo.getClass();
            ensureAggregatedAtomInfoIsMutable();
            this.aggregatedAtomInfo_.set(i, aggregatedAtomInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAggregatedAtomInfo(AggregatedAtomInfo aggregatedAtomInfo) {
            aggregatedAtomInfo.getClass();
            ensureAggregatedAtomInfoIsMutable();
            this.aggregatedAtomInfo_.add(aggregatedAtomInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAggregatedAtomInfo(int i, AggregatedAtomInfo aggregatedAtomInfo) {
            aggregatedAtomInfo.getClass();
            ensureAggregatedAtomInfoIsMutable();
            this.aggregatedAtomInfo_.add(i, aggregatedAtomInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAggregatedAtomInfo(Iterable<? extends AggregatedAtomInfo> iterable) {
            ensureAggregatedAtomInfoIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.aggregatedAtomInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAggregatedAtomInfo() {
            this.aggregatedAtomInfo_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAggregatedAtomInfo(int i) {
            ensureAggregatedAtomInfoIsMutable();
            this.aggregatedAtomInfo_.remove(i);
        }

        public static GaugeBucketInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GaugeBucketInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GaugeBucketInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GaugeBucketInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GaugeBucketInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GaugeBucketInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GaugeBucketInfo parseFrom(InputStream inputStream) throws IOException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GaugeBucketInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GaugeBucketInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GaugeBucketInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GaugeBucketInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GaugeBucketInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GaugeBucketInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GaugeBucketInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GaugeBucketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GaugeBucketInfo gaugeBucketInfo) {
            return DEFAULT_INSTANCE.createBuilder(gaugeBucketInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GaugeBucketInfo, Builder> implements GaugeBucketInfoOrBuilder {
            private Builder() {
                super(GaugeBucketInfo.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public List<StepOSAtoms.Atom> getAtomList() {
                return Collections.unmodifiableList(((GaugeBucketInfo) this.instance).getAtomList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public int getAtomCount() {
                return ((GaugeBucketInfo) this.instance).getAtomCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public StepOSAtoms.Atom getAtom(int i) {
                return ((GaugeBucketInfo) this.instance).getAtom(i);
            }

            public Builder setAtom(int i, StepOSAtoms.Atom atom) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).setAtom(i, atom);
                return this;
            }

            public Builder setAtom(int i, StepOSAtoms.Atom.Builder builder) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).setAtom(i, builder.build());
                return this;
            }

            public Builder addAtom(StepOSAtoms.Atom atom) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAtom(atom);
                return this;
            }

            public Builder addAtom(int i, StepOSAtoms.Atom atom) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAtom(i, atom);
                return this;
            }

            public Builder addAtom(StepOSAtoms.Atom.Builder builder) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAtom(builder.build());
                return this;
            }

            public Builder addAtom(int i, StepOSAtoms.Atom.Builder builder) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAtom(i, builder.build());
                return this;
            }

            public Builder addAllAtom(Iterable<? extends StepOSAtoms.Atom> iterable) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAllAtom(iterable);
                return this;
            }

            public Builder clearAtom() {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).clearAtom();
                return this;
            }

            public Builder removeAtom(int i) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).removeAtom(i);
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public List<Long> getElapsedTimestampNanosList() {
                return Collections.unmodifiableList(((GaugeBucketInfo) this.instance).getElapsedTimestampNanosList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public int getElapsedTimestampNanosCount() {
                return ((GaugeBucketInfo) this.instance).getElapsedTimestampNanosCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public long getElapsedTimestampNanos(int i) {
                return ((GaugeBucketInfo) this.instance).getElapsedTimestampNanos(i);
            }

            public Builder setElapsedTimestampNanos(int i, long j) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).setElapsedTimestampNanos(i, j);
                return this;
            }

            public Builder addElapsedTimestampNanos(long j) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addElapsedTimestampNanos(j);
                return this;
            }

            public Builder addAllElapsedTimestampNanos(Iterable<? extends Long> iterable) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAllElapsedTimestampNanos(iterable);
                return this;
            }

            public Builder clearElapsedTimestampNanos() {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).clearElapsedTimestampNanos();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public List<AggregatedAtomInfo> getAggregatedAtomInfoList() {
                return Collections.unmodifiableList(((GaugeBucketInfo) this.instance).getAggregatedAtomInfoList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public int getAggregatedAtomInfoCount() {
                return ((GaugeBucketInfo) this.instance).getAggregatedAtomInfoCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeBucketInfoOrBuilder
            public AggregatedAtomInfo getAggregatedAtomInfo(int i) {
                return ((GaugeBucketInfo) this.instance).getAggregatedAtomInfo(i);
            }

            public Builder setAggregatedAtomInfo(int i, AggregatedAtomInfo aggregatedAtomInfo) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).setAggregatedAtomInfo(i, aggregatedAtomInfo);
                return this;
            }

            public Builder setAggregatedAtomInfo(int i, AggregatedAtomInfo.Builder builder) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).setAggregatedAtomInfo(i, builder.build());
                return this;
            }

            public Builder addAggregatedAtomInfo(AggregatedAtomInfo aggregatedAtomInfo) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAggregatedAtomInfo(aggregatedAtomInfo);
                return this;
            }

            public Builder addAggregatedAtomInfo(int i, AggregatedAtomInfo aggregatedAtomInfo) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAggregatedAtomInfo(i, aggregatedAtomInfo);
                return this;
            }

            public Builder addAggregatedAtomInfo(AggregatedAtomInfo.Builder builder) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAggregatedAtomInfo(builder.build());
                return this;
            }

            public Builder addAggregatedAtomInfo(int i, AggregatedAtomInfo.Builder builder) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAggregatedAtomInfo(i, builder.build());
                return this;
            }

            public Builder addAllAggregatedAtomInfo(Iterable<? extends AggregatedAtomInfo> iterable) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).addAllAggregatedAtomInfo(iterable);
                return this;
            }

            public Builder clearAggregatedAtomInfo() {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).clearAggregatedAtomInfo();
                return this;
            }

            public Builder removeAggregatedAtomInfo(int i) {
                copyOnWrite();
                ((GaugeBucketInfo) this.instance).removeAggregatedAtomInfo(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new GaugeBucketInfo();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0000\u0003\t\u0003\u0000\u0003\u0000\u0003\u001b\u0004\u0014\t\u001b", new Object[]{"atom_", StepOSAtoms.Atom.class, "elapsedTimestampNanos_", "aggregatedAtomInfo_", AggregatedAtomInfo.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GaugeBucketInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GaugeBucketInfo.class) {
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
            GaugeBucketInfo gaugeBucketInfo = new GaugeBucketInfo();
            DEFAULT_INSTANCE = gaugeBucketInfo;
            GeneratedMessageLite.registerDefaultInstance(GaugeBucketInfo.class, gaugeBucketInfo);
        }

        public static GaugeBucketInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GaugeBucketInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GaugeMetricData extends GeneratedMessageLite<GaugeMetricData, Builder> implements GaugeMetricDataOrBuilder {
        public static final int BUCKET_INFO_FIELD_NUMBER = 3;
        private static final GaugeMetricData DEFAULT_INSTANCE;
        public static final int DIMENSION_LEAF_VALUES_IN_WHAT_FIELD_NUMBER = 4;
        private static volatile Parser<GaugeMetricData> PARSER;
        private Internal.ProtobufList<GaugeBucketInfo> bucketInfo_ = emptyProtobufList();
        private Internal.ProtobufList<DimensionsValue> dimensionLeafValuesInWhat_ = emptyProtobufList();

        private GaugeMetricData() {
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
        public List<GaugeBucketInfo> getBucketInfoList() {
            return this.bucketInfo_;
        }

        public List<? extends GaugeBucketInfoOrBuilder> getBucketInfoOrBuilderList() {
            return this.bucketInfo_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
        public int getBucketInfoCount() {
            return this.bucketInfo_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
        public GaugeBucketInfo getBucketInfo(int i) {
            return this.bucketInfo_.get(i);
        }

        public GaugeBucketInfoOrBuilder getBucketInfoOrBuilder(int i) {
            return this.bucketInfo_.get(i);
        }

        private void ensureBucketInfoIsMutable() {
            Internal.ProtobufList<GaugeBucketInfo> protobufList = this.bucketInfo_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.bucketInfo_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBucketInfo(int i, GaugeBucketInfo gaugeBucketInfo) {
            gaugeBucketInfo.getClass();
            ensureBucketInfoIsMutable();
            this.bucketInfo_.set(i, gaugeBucketInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addBucketInfo(GaugeBucketInfo gaugeBucketInfo) {
            gaugeBucketInfo.getClass();
            ensureBucketInfoIsMutable();
            this.bucketInfo_.add(gaugeBucketInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addBucketInfo(int i, GaugeBucketInfo gaugeBucketInfo) {
            gaugeBucketInfo.getClass();
            ensureBucketInfoIsMutable();
            this.bucketInfo_.add(i, gaugeBucketInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllBucketInfo(Iterable<? extends GaugeBucketInfo> iterable) {
            ensureBucketInfoIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.bucketInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBucketInfo() {
            this.bucketInfo_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeBucketInfo(int i) {
            ensureBucketInfoIsMutable();
            this.bucketInfo_.remove(i);
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
        public List<DimensionsValue> getDimensionLeafValuesInWhatList() {
            return this.dimensionLeafValuesInWhat_;
        }

        public List<? extends DimensionsValueOrBuilder> getDimensionLeafValuesInWhatOrBuilderList() {
            return this.dimensionLeafValuesInWhat_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
        public int getDimensionLeafValuesInWhatCount() {
            return this.dimensionLeafValuesInWhat_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
        public DimensionsValue getDimensionLeafValuesInWhat(int i) {
            return this.dimensionLeafValuesInWhat_.get(i);
        }

        public DimensionsValueOrBuilder getDimensionLeafValuesInWhatOrBuilder(int i) {
            return this.dimensionLeafValuesInWhat_.get(i);
        }

        private void ensureDimensionLeafValuesInWhatIsMutable() {
            Internal.ProtobufList<DimensionsValue> protobufList = this.dimensionLeafValuesInWhat_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dimensionLeafValuesInWhat_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDimensionLeafValuesInWhat(int i, DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            ensureDimensionLeafValuesInWhatIsMutable();
            this.dimensionLeafValuesInWhat_.set(i, dimensionsValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDimensionLeafValuesInWhat(DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            ensureDimensionLeafValuesInWhatIsMutable();
            this.dimensionLeafValuesInWhat_.add(dimensionsValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDimensionLeafValuesInWhat(int i, DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            ensureDimensionLeafValuesInWhatIsMutable();
            this.dimensionLeafValuesInWhat_.add(i, dimensionsValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDimensionLeafValuesInWhat(Iterable<? extends DimensionsValue> iterable) {
            ensureDimensionLeafValuesInWhatIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dimensionLeafValuesInWhat_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDimensionLeafValuesInWhat() {
            this.dimensionLeafValuesInWhat_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDimensionLeafValuesInWhat(int i) {
            ensureDimensionLeafValuesInWhatIsMutable();
            this.dimensionLeafValuesInWhat_.remove(i);
        }

        public static GaugeMetricData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GaugeMetricData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GaugeMetricData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GaugeMetricData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GaugeMetricData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GaugeMetricData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GaugeMetricData parseFrom(InputStream inputStream) throws IOException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GaugeMetricData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GaugeMetricData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GaugeMetricData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GaugeMetricData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GaugeMetricData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GaugeMetricData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GaugeMetricData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GaugeMetricData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GaugeMetricData gaugeMetricData) {
            return DEFAULT_INSTANCE.createBuilder(gaugeMetricData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GaugeMetricData, Builder> implements GaugeMetricDataOrBuilder {
            private Builder() {
                super(GaugeMetricData.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
            public List<GaugeBucketInfo> getBucketInfoList() {
                return Collections.unmodifiableList(((GaugeMetricData) this.instance).getBucketInfoList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
            public int getBucketInfoCount() {
                return ((GaugeMetricData) this.instance).getBucketInfoCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
            public GaugeBucketInfo getBucketInfo(int i) {
                return ((GaugeMetricData) this.instance).getBucketInfo(i);
            }

            public Builder setBucketInfo(int i, GaugeBucketInfo gaugeBucketInfo) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).setBucketInfo(i, gaugeBucketInfo);
                return this;
            }

            public Builder setBucketInfo(int i, GaugeBucketInfo.Builder builder) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).setBucketInfo(i, builder.build());
                return this;
            }

            public Builder addBucketInfo(GaugeBucketInfo gaugeBucketInfo) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addBucketInfo(gaugeBucketInfo);
                return this;
            }

            public Builder addBucketInfo(int i, GaugeBucketInfo gaugeBucketInfo) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addBucketInfo(i, gaugeBucketInfo);
                return this;
            }

            public Builder addBucketInfo(GaugeBucketInfo.Builder builder) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addBucketInfo(builder.build());
                return this;
            }

            public Builder addBucketInfo(int i, GaugeBucketInfo.Builder builder) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addBucketInfo(i, builder.build());
                return this;
            }

            public Builder addAllBucketInfo(Iterable<? extends GaugeBucketInfo> iterable) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addAllBucketInfo(iterable);
                return this;
            }

            public Builder clearBucketInfo() {
                copyOnWrite();
                ((GaugeMetricData) this.instance).clearBucketInfo();
                return this;
            }

            public Builder removeBucketInfo(int i) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).removeBucketInfo(i);
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
            public List<DimensionsValue> getDimensionLeafValuesInWhatList() {
                return Collections.unmodifiableList(((GaugeMetricData) this.instance).getDimensionLeafValuesInWhatList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
            public int getDimensionLeafValuesInWhatCount() {
                return ((GaugeMetricData) this.instance).getDimensionLeafValuesInWhatCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.GaugeMetricDataOrBuilder
            public DimensionsValue getDimensionLeafValuesInWhat(int i) {
                return ((GaugeMetricData) this.instance).getDimensionLeafValuesInWhat(i);
            }

            public Builder setDimensionLeafValuesInWhat(int i, DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).setDimensionLeafValuesInWhat(i, dimensionsValue);
                return this;
            }

            public Builder setDimensionLeafValuesInWhat(int i, DimensionsValue.Builder builder) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).setDimensionLeafValuesInWhat(i, builder.build());
                return this;
            }

            public Builder addDimensionLeafValuesInWhat(DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addDimensionLeafValuesInWhat(dimensionsValue);
                return this;
            }

            public Builder addDimensionLeafValuesInWhat(int i, DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addDimensionLeafValuesInWhat(i, dimensionsValue);
                return this;
            }

            public Builder addDimensionLeafValuesInWhat(DimensionsValue.Builder builder) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addDimensionLeafValuesInWhat(builder.build());
                return this;
            }

            public Builder addDimensionLeafValuesInWhat(int i, DimensionsValue.Builder builder) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addDimensionLeafValuesInWhat(i, builder.build());
                return this;
            }

            public Builder addAllDimensionLeafValuesInWhat(Iterable<? extends DimensionsValue> iterable) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).addAllDimensionLeafValuesInWhat(iterable);
                return this;
            }

            public Builder clearDimensionLeafValuesInWhat() {
                copyOnWrite();
                ((GaugeMetricData) this.instance).clearDimensionLeafValuesInWhat();
                return this;
            }

            public Builder removeDimensionLeafValuesInWhat(int i) {
                copyOnWrite();
                ((GaugeMetricData) this.instance).removeDimensionLeafValuesInWhat(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new GaugeMetricData();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0000\u0003\u0004\u0002\u0000\u0002\u0000\u0003\u001b\u0004\u001b", new Object[]{"bucketInfo_", GaugeBucketInfo.class, "dimensionLeafValuesInWhat_", DimensionsValue.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GaugeMetricData> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GaugeMetricData.class) {
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
            GaugeMetricData gaugeMetricData = new GaugeMetricData();
            DEFAULT_INSTANCE = gaugeMetricData;
            GeneratedMessageLite.registerDefaultInstance(GaugeMetricData.class, gaugeMetricData);
        }

        public static GaugeMetricData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GaugeMetricData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StatsLogReport extends GeneratedMessageLite<StatsLogReport, Builder> implements StatsLogReportOrBuilder {
        private static final StatsLogReport DEFAULT_INSTANCE;
        public static final int DIMENSIONS_PATH_IN_WHAT_FIELD_NUMBER = 11;
        public static final int EVENT_METRICS_FIELD_NUMBER = 4;
        public static final int GAUGE_METRICS_FIELD_NUMBER = 8;
        public static final int IS_ACTIVE_FIELD_NUMBER = 14;
        public static final int METRIC_ID_FIELD_NUMBER = 1;
        private static volatile Parser<StatsLogReport> PARSER;
        private int bitField0_;
        private int dataCase_ = 0;
        private Object data_;
        private DimensionsValue dimensionsPathInWhat_;
        private boolean isActive_;
        private long metricId_;

        public interface EventMetricDataWrapperOrBuilder extends MessageLiteOrBuilder {
            EventMetricData getData(int i);

            int getDataCount();

            List<EventMetricData> getDataList();
        }

        public interface GaugeMetricDataWrapperOrBuilder extends MessageLiteOrBuilder {
            GaugeMetricData getData(int i);

            int getDataCount();

            List<GaugeMetricData> getDataList();
        }

        private StatsLogReport() {
        }

        public static final class EventMetricDataWrapper extends GeneratedMessageLite<EventMetricDataWrapper, Builder> implements EventMetricDataWrapperOrBuilder {
            public static final int DATA_FIELD_NUMBER = 1;
            private static final EventMetricDataWrapper DEFAULT_INSTANCE;
            private static volatile Parser<EventMetricDataWrapper> PARSER;
            private Internal.ProtobufList<EventMetricData> data_ = emptyProtobufList();

            private EventMetricDataWrapper() {
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.EventMetricDataWrapperOrBuilder
            public List<EventMetricData> getDataList() {
                return this.data_;
            }

            public List<? extends EventMetricDataOrBuilder> getDataOrBuilderList() {
                return this.data_;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.EventMetricDataWrapperOrBuilder
            public int getDataCount() {
                return this.data_.size();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.EventMetricDataWrapperOrBuilder
            public EventMetricData getData(int i) {
                return this.data_.get(i);
            }

            public EventMetricDataOrBuilder getDataOrBuilder(int i) {
                return this.data_.get(i);
            }

            private void ensureDataIsMutable() {
                Internal.ProtobufList<EventMetricData> protobufList = this.data_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.data_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setData(int i, EventMetricData eventMetricData) {
                eventMetricData.getClass();
                ensureDataIsMutable();
                this.data_.set(i, eventMetricData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addData(EventMetricData eventMetricData) {
                eventMetricData.getClass();
                ensureDataIsMutable();
                this.data_.add(eventMetricData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addData(int i, EventMetricData eventMetricData) {
                eventMetricData.getClass();
                ensureDataIsMutable();
                this.data_.add(i, eventMetricData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllData(Iterable<? extends EventMetricData> iterable) {
                ensureDataIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.data_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearData() {
                this.data_ = emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeData(int i) {
                ensureDataIsMutable();
                this.data_.remove(i);
            }

            public static EventMetricDataWrapper parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static EventMetricDataWrapper parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static EventMetricDataWrapper parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static EventMetricDataWrapper parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static EventMetricDataWrapper parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static EventMetricDataWrapper parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static EventMetricDataWrapper parseFrom(InputStream inputStream) throws IOException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static EventMetricDataWrapper parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EventMetricDataWrapper parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (EventMetricDataWrapper) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static EventMetricDataWrapper parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EventMetricDataWrapper) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EventMetricDataWrapper parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static EventMetricDataWrapper parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EventMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(EventMetricDataWrapper eventMetricDataWrapper) {
                return DEFAULT_INSTANCE.createBuilder(eventMetricDataWrapper);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<EventMetricDataWrapper, Builder> implements EventMetricDataWrapperOrBuilder {
                private Builder() {
                    super(EventMetricDataWrapper.DEFAULT_INSTANCE);
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.EventMetricDataWrapperOrBuilder
                public List<EventMetricData> getDataList() {
                    return Collections.unmodifiableList(((EventMetricDataWrapper) this.instance).getDataList());
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.EventMetricDataWrapperOrBuilder
                public int getDataCount() {
                    return ((EventMetricDataWrapper) this.instance).getDataCount();
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.EventMetricDataWrapperOrBuilder
                public EventMetricData getData(int i) {
                    return ((EventMetricDataWrapper) this.instance).getData(i);
                }

                public Builder setData(int i, EventMetricData eventMetricData) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).setData(i, eventMetricData);
                    return this;
                }

                public Builder setData(int i, EventMetricData.Builder builder) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).setData(i, builder.build());
                    return this;
                }

                public Builder addData(EventMetricData eventMetricData) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).addData(eventMetricData);
                    return this;
                }

                public Builder addData(int i, EventMetricData eventMetricData) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).addData(i, eventMetricData);
                    return this;
                }

                public Builder addData(EventMetricData.Builder builder) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).addData(builder.build());
                    return this;
                }

                public Builder addData(int i, EventMetricData.Builder builder) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).addData(i, builder.build());
                    return this;
                }

                public Builder addAllData(Iterable<? extends EventMetricData> iterable) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).addAllData(iterable);
                    return this;
                }

                public Builder clearData() {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).clearData();
                    return this;
                }

                public Builder removeData(int i) {
                    copyOnWrite();
                    ((EventMetricDataWrapper) this.instance).removeData(i);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new EventMetricDataWrapper();
                    case 2:
                        return new Builder();
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"data_", EventMetricData.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<EventMetricDataWrapper> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (EventMetricDataWrapper.class) {
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
                EventMetricDataWrapper eventMetricDataWrapper = new EventMetricDataWrapper();
                DEFAULT_INSTANCE = eventMetricDataWrapper;
                GeneratedMessageLite.registerDefaultInstance(EventMetricDataWrapper.class, eventMetricDataWrapper);
            }

            public static EventMetricDataWrapper getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<EventMetricDataWrapper> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class GaugeMetricDataWrapper extends GeneratedMessageLite<GaugeMetricDataWrapper, Builder> implements GaugeMetricDataWrapperOrBuilder {
            public static final int DATA_FIELD_NUMBER = 1;
            private static final GaugeMetricDataWrapper DEFAULT_INSTANCE;
            private static volatile Parser<GaugeMetricDataWrapper> PARSER;
            private Internal.ProtobufList<GaugeMetricData> data_ = emptyProtobufList();

            private GaugeMetricDataWrapper() {
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.GaugeMetricDataWrapperOrBuilder
            public List<GaugeMetricData> getDataList() {
                return this.data_;
            }

            public List<? extends GaugeMetricDataOrBuilder> getDataOrBuilderList() {
                return this.data_;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.GaugeMetricDataWrapperOrBuilder
            public int getDataCount() {
                return this.data_.size();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.GaugeMetricDataWrapperOrBuilder
            public GaugeMetricData getData(int i) {
                return this.data_.get(i);
            }

            public GaugeMetricDataOrBuilder getDataOrBuilder(int i) {
                return this.data_.get(i);
            }

            private void ensureDataIsMutable() {
                Internal.ProtobufList<GaugeMetricData> protobufList = this.data_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.data_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setData(int i, GaugeMetricData gaugeMetricData) {
                gaugeMetricData.getClass();
                ensureDataIsMutable();
                this.data_.set(i, gaugeMetricData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addData(GaugeMetricData gaugeMetricData) {
                gaugeMetricData.getClass();
                ensureDataIsMutable();
                this.data_.add(gaugeMetricData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addData(int i, GaugeMetricData gaugeMetricData) {
                gaugeMetricData.getClass();
                ensureDataIsMutable();
                this.data_.add(i, gaugeMetricData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllData(Iterable<? extends GaugeMetricData> iterable) {
                ensureDataIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.data_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearData() {
                this.data_ = emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeData(int i) {
                ensureDataIsMutable();
                this.data_.remove(i);
            }

            public static GaugeMetricDataWrapper parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static GaugeMetricDataWrapper parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static GaugeMetricDataWrapper parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static GaugeMetricDataWrapper parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static GaugeMetricDataWrapper parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static GaugeMetricDataWrapper parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static GaugeMetricDataWrapper parseFrom(InputStream inputStream) throws IOException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static GaugeMetricDataWrapper parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static GaugeMetricDataWrapper parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (GaugeMetricDataWrapper) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static GaugeMetricDataWrapper parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GaugeMetricDataWrapper) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static GaugeMetricDataWrapper parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static GaugeMetricDataWrapper parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GaugeMetricDataWrapper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(GaugeMetricDataWrapper gaugeMetricDataWrapper) {
                return DEFAULT_INSTANCE.createBuilder(gaugeMetricDataWrapper);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<GaugeMetricDataWrapper, Builder> implements GaugeMetricDataWrapperOrBuilder {
                private Builder() {
                    super(GaugeMetricDataWrapper.DEFAULT_INSTANCE);
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.GaugeMetricDataWrapperOrBuilder
                public List<GaugeMetricData> getDataList() {
                    return Collections.unmodifiableList(((GaugeMetricDataWrapper) this.instance).getDataList());
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.GaugeMetricDataWrapperOrBuilder
                public int getDataCount() {
                    return ((GaugeMetricDataWrapper) this.instance).getDataCount();
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReport.GaugeMetricDataWrapperOrBuilder
                public GaugeMetricData getData(int i) {
                    return ((GaugeMetricDataWrapper) this.instance).getData(i);
                }

                public Builder setData(int i, GaugeMetricData gaugeMetricData) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).setData(i, gaugeMetricData);
                    return this;
                }

                public Builder setData(int i, GaugeMetricData.Builder builder) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).setData(i, builder.build());
                    return this;
                }

                public Builder addData(GaugeMetricData gaugeMetricData) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).addData(gaugeMetricData);
                    return this;
                }

                public Builder addData(int i, GaugeMetricData gaugeMetricData) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).addData(i, gaugeMetricData);
                    return this;
                }

                public Builder addData(GaugeMetricData.Builder builder) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).addData(builder.build());
                    return this;
                }

                public Builder addData(int i, GaugeMetricData.Builder builder) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).addData(i, builder.build());
                    return this;
                }

                public Builder addAllData(Iterable<? extends GaugeMetricData> iterable) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).addAllData(iterable);
                    return this;
                }

                public Builder clearData() {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).clearData();
                    return this;
                }

                public Builder removeData(int i) {
                    copyOnWrite();
                    ((GaugeMetricDataWrapper) this.instance).removeData(i);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new GaugeMetricDataWrapper();
                    case 2:
                        return new Builder();
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"data_", GaugeMetricData.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<GaugeMetricDataWrapper> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (GaugeMetricDataWrapper.class) {
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
                GaugeMetricDataWrapper gaugeMetricDataWrapper = new GaugeMetricDataWrapper();
                DEFAULT_INSTANCE = gaugeMetricDataWrapper;
                GeneratedMessageLite.registerDefaultInstance(GaugeMetricDataWrapper.class, gaugeMetricDataWrapper);
            }

            public static GaugeMetricDataWrapper getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<GaugeMetricDataWrapper> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public enum DataCase {
            EVENT_METRICS(4),
            GAUGE_METRICS(8),
            DATA_NOT_SET(0);

            private final int value;

            DataCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static DataCase valueOf(int i) {
                return forNumber(i);
            }

            public static DataCase forNumber(int i) {
                if (i == 0) {
                    return DATA_NOT_SET;
                }
                if (i == 4) {
                    return EVENT_METRICS;
                }
                if (i != 8) {
                    return null;
                }
                return GAUGE_METRICS;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public DataCase getDataCase() {
            return DataCase.forNumber(this.dataCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.dataCase_ = 0;
            this.data_ = null;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public boolean hasMetricId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public long getMetricId() {
            return this.metricId_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetricId(long j) {
            this.bitField0_ |= 1;
            this.metricId_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetricId() {
            this.bitField0_ &= -2;
            this.metricId_ = 0L;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public boolean hasEventMetrics() {
            return this.dataCase_ == 4;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public EventMetricDataWrapper getEventMetrics() {
            if (this.dataCase_ == 4) {
                return (EventMetricDataWrapper) this.data_;
            }
            return EventMetricDataWrapper.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventMetrics(EventMetricDataWrapper eventMetricDataWrapper) {
            eventMetricDataWrapper.getClass();
            this.data_ = eventMetricDataWrapper;
            this.dataCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEventMetrics(EventMetricDataWrapper eventMetricDataWrapper) {
            eventMetricDataWrapper.getClass();
            if (this.dataCase_ == 4 && this.data_ != EventMetricDataWrapper.getDefaultInstance()) {
                this.data_ = EventMetricDataWrapper.newBuilder((EventMetricDataWrapper) this.data_).mergeFrom((EventMetricDataWrapper.Builder) eventMetricDataWrapper).buildPartial();
            } else {
                this.data_ = eventMetricDataWrapper;
            }
            this.dataCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventMetrics() {
            if (this.dataCase_ == 4) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public boolean hasGaugeMetrics() {
            return this.dataCase_ == 8;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public GaugeMetricDataWrapper getGaugeMetrics() {
            if (this.dataCase_ == 8) {
                return (GaugeMetricDataWrapper) this.data_;
            }
            return GaugeMetricDataWrapper.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGaugeMetrics(GaugeMetricDataWrapper gaugeMetricDataWrapper) {
            gaugeMetricDataWrapper.getClass();
            this.data_ = gaugeMetricDataWrapper;
            this.dataCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeGaugeMetrics(GaugeMetricDataWrapper gaugeMetricDataWrapper) {
            gaugeMetricDataWrapper.getClass();
            if (this.dataCase_ == 8 && this.data_ != GaugeMetricDataWrapper.getDefaultInstance()) {
                this.data_ = GaugeMetricDataWrapper.newBuilder((GaugeMetricDataWrapper) this.data_).mergeFrom((GaugeMetricDataWrapper.Builder) gaugeMetricDataWrapper).buildPartial();
            } else {
                this.data_ = gaugeMetricDataWrapper;
            }
            this.dataCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGaugeMetrics() {
            if (this.dataCase_ == 8) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public boolean hasDimensionsPathInWhat() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public DimensionsValue getDimensionsPathInWhat() {
            DimensionsValue dimensionsValue = this.dimensionsPathInWhat_;
            return dimensionsValue == null ? DimensionsValue.getDefaultInstance() : dimensionsValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDimensionsPathInWhat(DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            this.dimensionsPathInWhat_ = dimensionsValue;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDimensionsPathInWhat(DimensionsValue dimensionsValue) {
            dimensionsValue.getClass();
            DimensionsValue dimensionsValue2 = this.dimensionsPathInWhat_;
            if (dimensionsValue2 != null && dimensionsValue2 != DimensionsValue.getDefaultInstance()) {
                this.dimensionsPathInWhat_ = DimensionsValue.newBuilder(this.dimensionsPathInWhat_).mergeFrom((DimensionsValue.Builder) dimensionsValue).buildPartial();
            } else {
                this.dimensionsPathInWhat_ = dimensionsValue;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDimensionsPathInWhat() {
            this.dimensionsPathInWhat_ = null;
            this.bitField0_ &= -9;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public boolean hasIsActive() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
        public boolean getIsActive() {
            return this.isActive_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsActive(boolean z) {
            this.bitField0_ |= 16;
            this.isActive_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsActive() {
            this.bitField0_ &= -17;
            this.isActive_ = false;
        }

        public static StatsLogReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StatsLogReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StatsLogReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StatsLogReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StatsLogReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StatsLogReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StatsLogReport parseFrom(InputStream inputStream) throws IOException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StatsLogReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StatsLogReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StatsLogReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StatsLogReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatsLogReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StatsLogReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StatsLogReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatsLogReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StatsLogReport statsLogReport) {
            return DEFAULT_INSTANCE.createBuilder(statsLogReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StatsLogReport, Builder> implements StatsLogReportOrBuilder {
            private Builder() {
                super(StatsLogReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public DataCase getDataCase() {
                return ((StatsLogReport) this.instance).getDataCase();
            }

            public Builder clearData() {
                copyOnWrite();
                ((StatsLogReport) this.instance).clearData();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public boolean hasMetricId() {
                return ((StatsLogReport) this.instance).hasMetricId();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public long getMetricId() {
                return ((StatsLogReport) this.instance).getMetricId();
            }

            public Builder setMetricId(long j) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setMetricId(j);
                return this;
            }

            public Builder clearMetricId() {
                copyOnWrite();
                ((StatsLogReport) this.instance).clearMetricId();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public boolean hasEventMetrics() {
                return ((StatsLogReport) this.instance).hasEventMetrics();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public EventMetricDataWrapper getEventMetrics() {
                return ((StatsLogReport) this.instance).getEventMetrics();
            }

            public Builder setEventMetrics(EventMetricDataWrapper eventMetricDataWrapper) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setEventMetrics(eventMetricDataWrapper);
                return this;
            }

            public Builder setEventMetrics(EventMetricDataWrapper.Builder builder) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setEventMetrics(builder.build());
                return this;
            }

            public Builder mergeEventMetrics(EventMetricDataWrapper eventMetricDataWrapper) {
                copyOnWrite();
                ((StatsLogReport) this.instance).mergeEventMetrics(eventMetricDataWrapper);
                return this;
            }

            public Builder clearEventMetrics() {
                copyOnWrite();
                ((StatsLogReport) this.instance).clearEventMetrics();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public boolean hasGaugeMetrics() {
                return ((StatsLogReport) this.instance).hasGaugeMetrics();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public GaugeMetricDataWrapper getGaugeMetrics() {
                return ((StatsLogReport) this.instance).getGaugeMetrics();
            }

            public Builder setGaugeMetrics(GaugeMetricDataWrapper gaugeMetricDataWrapper) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setGaugeMetrics(gaugeMetricDataWrapper);
                return this;
            }

            public Builder setGaugeMetrics(GaugeMetricDataWrapper.Builder builder) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setGaugeMetrics(builder.build());
                return this;
            }

            public Builder mergeGaugeMetrics(GaugeMetricDataWrapper gaugeMetricDataWrapper) {
                copyOnWrite();
                ((StatsLogReport) this.instance).mergeGaugeMetrics(gaugeMetricDataWrapper);
                return this;
            }

            public Builder clearGaugeMetrics() {
                copyOnWrite();
                ((StatsLogReport) this.instance).clearGaugeMetrics();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public boolean hasDimensionsPathInWhat() {
                return ((StatsLogReport) this.instance).hasDimensionsPathInWhat();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public DimensionsValue getDimensionsPathInWhat() {
                return ((StatsLogReport) this.instance).getDimensionsPathInWhat();
            }

            public Builder setDimensionsPathInWhat(DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setDimensionsPathInWhat(dimensionsValue);
                return this;
            }

            public Builder setDimensionsPathInWhat(DimensionsValue.Builder builder) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setDimensionsPathInWhat(builder.build());
                return this;
            }

            public Builder mergeDimensionsPathInWhat(DimensionsValue dimensionsValue) {
                copyOnWrite();
                ((StatsLogReport) this.instance).mergeDimensionsPathInWhat(dimensionsValue);
                return this;
            }

            public Builder clearDimensionsPathInWhat() {
                copyOnWrite();
                ((StatsLogReport) this.instance).clearDimensionsPathInWhat();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public boolean hasIsActive() {
                return ((StatsLogReport) this.instance).hasIsActive();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsLogReportOrBuilder
            public boolean getIsActive() {
                return ((StatsLogReport) this.instance).getIsActive();
            }

            public Builder setIsActive(boolean z) {
                copyOnWrite();
                ((StatsLogReport) this.instance).setIsActive(z);
                return this;
            }

            public Builder clearIsActive() {
                copyOnWrite();
                ((StatsLogReport) this.instance).clearIsActive();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new StatsLogReport();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0001\u0001\u0001\u000e\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0004ြ\u0000\bြ\u0000\u000bဉ\u0003\u000eဇ\u0004", new Object[]{"data_", "dataCase_", "bitField0_", "metricId_", EventMetricDataWrapper.class, GaugeMetricDataWrapper.class, "dimensionsPathInWhat_", "isActive_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StatsLogReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StatsLogReport.class) {
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
            StatsLogReport statsLogReport = new StatsLogReport();
            DEFAULT_INSTANCE = statsLogReport;
            GeneratedMessageLite.registerDefaultInstance(StatsLogReport.class, statsLogReport);
        }

        public static StatsLogReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StatsLogReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ConfigMetricsReport extends GeneratedMessageLite<ConfigMetricsReport, Builder> implements ConfigMetricsReportOrBuilder {
        private static final ConfigMetricsReport DEFAULT_INSTANCE;
        public static final int METRICS_FIELD_NUMBER = 1;
        private static volatile Parser<ConfigMetricsReport> PARSER = null;
        public static final int STRINGS_FIELD_NUMBER = 9;
        private Internal.ProtobufList<StatsLogReport> metrics_ = emptyProtobufList();
        private Internal.ProtobufList<String> strings_ = GeneratedMessageLite.emptyProtobufList();

        private ConfigMetricsReport() {
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
        public List<StatsLogReport> getMetricsList() {
            return this.metrics_;
        }

        public List<? extends StatsLogReportOrBuilder> getMetricsOrBuilderList() {
            return this.metrics_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
        public int getMetricsCount() {
            return this.metrics_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
        public StatsLogReport getMetrics(int i) {
            return this.metrics_.get(i);
        }

        public StatsLogReportOrBuilder getMetricsOrBuilder(int i) {
            return this.metrics_.get(i);
        }

        private void ensureMetricsIsMutable() {
            Internal.ProtobufList<StatsLogReport> protobufList = this.metrics_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.metrics_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetrics(int i, StatsLogReport statsLogReport) {
            statsLogReport.getClass();
            ensureMetricsIsMutable();
            this.metrics_.set(i, statsLogReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetrics(StatsLogReport statsLogReport) {
            statsLogReport.getClass();
            ensureMetricsIsMutable();
            this.metrics_.add(statsLogReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetrics(int i, StatsLogReport statsLogReport) {
            statsLogReport.getClass();
            ensureMetricsIsMutable();
            this.metrics_.add(i, statsLogReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMetrics(Iterable<? extends StatsLogReport> iterable) {
            ensureMetricsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.metrics_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetrics() {
            this.metrics_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMetrics(int i) {
            ensureMetricsIsMutable();
            this.metrics_.remove(i);
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
        public List<String> getStringsList() {
            return this.strings_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
        public int getStringsCount() {
            return this.strings_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
        public String getStrings(int i) {
            return this.strings_.get(i);
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
        public ByteString getStringsBytes(int i) {
            return ByteString.copyFromUtf8(this.strings_.get(i));
        }

        private void ensureStringsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.strings_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.strings_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStrings(int i, String str) {
            str.getClass();
            ensureStringsIsMutable();
            this.strings_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addStrings(String str) {
            str.getClass();
            ensureStringsIsMutable();
            this.strings_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllStrings(Iterable<String> iterable) {
            ensureStringsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.strings_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStrings() {
            this.strings_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addStringsBytes(ByteString byteString) {
            ensureStringsIsMutable();
            this.strings_.add(byteString.toStringUtf8());
        }

        public static ConfigMetricsReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConfigMetricsReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConfigMetricsReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConfigMetricsReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConfigMetricsReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConfigMetricsReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConfigMetricsReport parseFrom(InputStream inputStream) throws IOException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigMetricsReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigMetricsReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigMetricsReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigMetricsReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigMetricsReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigMetricsReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConfigMetricsReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigMetricsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConfigMetricsReport configMetricsReport) {
            return DEFAULT_INSTANCE.createBuilder(configMetricsReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigMetricsReport, Builder> implements ConfigMetricsReportOrBuilder {
            private Builder() {
                super(ConfigMetricsReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
            public List<StatsLogReport> getMetricsList() {
                return Collections.unmodifiableList(((ConfigMetricsReport) this.instance).getMetricsList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
            public int getMetricsCount() {
                return ((ConfigMetricsReport) this.instance).getMetricsCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
            public StatsLogReport getMetrics(int i) {
                return ((ConfigMetricsReport) this.instance).getMetrics(i);
            }

            public Builder setMetrics(int i, StatsLogReport statsLogReport) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).setMetrics(i, statsLogReport);
                return this;
            }

            public Builder setMetrics(int i, StatsLogReport.Builder builder) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).setMetrics(i, builder.build());
                return this;
            }

            public Builder addMetrics(StatsLogReport statsLogReport) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addMetrics(statsLogReport);
                return this;
            }

            public Builder addMetrics(int i, StatsLogReport statsLogReport) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addMetrics(i, statsLogReport);
                return this;
            }

            public Builder addMetrics(StatsLogReport.Builder builder) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addMetrics(builder.build());
                return this;
            }

            public Builder addMetrics(int i, StatsLogReport.Builder builder) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addMetrics(i, builder.build());
                return this;
            }

            public Builder addAllMetrics(Iterable<? extends StatsLogReport> iterable) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addAllMetrics(iterable);
                return this;
            }

            public Builder clearMetrics() {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).clearMetrics();
                return this;
            }

            public Builder removeMetrics(int i) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).removeMetrics(i);
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
            public List<String> getStringsList() {
                return Collections.unmodifiableList(((ConfigMetricsReport) this.instance).getStringsList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
            public int getStringsCount() {
                return ((ConfigMetricsReport) this.instance).getStringsCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
            public String getStrings(int i) {
                return ((ConfigMetricsReport) this.instance).getStrings(i);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportOrBuilder
            public ByteString getStringsBytes(int i) {
                return ((ConfigMetricsReport) this.instance).getStringsBytes(i);
            }

            public Builder setStrings(int i, String str) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).setStrings(i, str);
                return this;
            }

            public Builder addStrings(String str) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addStrings(str);
                return this;
            }

            public Builder addAllStrings(Iterable<String> iterable) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addAllStrings(iterable);
                return this;
            }

            public Builder clearStrings() {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).clearStrings();
                return this;
            }

            public Builder addStringsBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigMetricsReport) this.instance).addStringsBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ConfigMetricsReport();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0000\u0001\t\u0002\u0000\u0002\u0000\u0001\u001b\t\u001a", new Object[]{"metrics_", StatsLogReport.class, "strings_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConfigMetricsReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ConfigMetricsReport.class) {
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
            ConfigMetricsReport configMetricsReport = new ConfigMetricsReport();
            DEFAULT_INSTANCE = configMetricsReport;
            GeneratedMessageLite.registerDefaultInstance(ConfigMetricsReport.class, configMetricsReport);
        }

        public static ConfigMetricsReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConfigMetricsReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ConfigMetricsReportList extends GeneratedMessageLite<ConfigMetricsReportList, Builder> implements ConfigMetricsReportListOrBuilder {
        public static final int CONFIG_KEY_FIELD_NUMBER = 1;
        private static final ConfigMetricsReportList DEFAULT_INSTANCE;
        private static volatile Parser<ConfigMetricsReportList> PARSER = null;
        public static final int REPORTS_FIELD_NUMBER = 2;
        private int bitField0_;
        private ConfigKey configKey_;
        private Internal.ProtobufList<ConfigMetricsReport> reports_ = emptyProtobufList();

        public interface ConfigKeyOrBuilder extends MessageLiteOrBuilder {
            long getId();

            int getUid();

            boolean hasId();

            boolean hasUid();
        }

        private ConfigMetricsReportList() {
        }

        public static final class ConfigKey extends GeneratedMessageLite<ConfigKey, Builder> implements ConfigKeyOrBuilder {
            private static final ConfigKey DEFAULT_INSTANCE;
            public static final int ID_FIELD_NUMBER = 2;
            private static volatile Parser<ConfigKey> PARSER = null;
            public static final int UID_FIELD_NUMBER = 1;
            private int bitField0_;
            private long id_;
            private int uid_;

            private ConfigKey() {
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
            public boolean hasUid() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
            public int getUid() {
                return this.uid_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUid(int i) {
                this.bitField0_ |= 1;
                this.uid_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUid() {
                this.bitField0_ &= -2;
                this.uid_ = 0;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
            public long getId() {
                return this.id_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setId(long j) {
                this.bitField0_ |= 2;
                this.id_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearId() {
                this.bitField0_ &= -3;
                this.id_ = 0L;
            }

            public static ConfigKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ConfigKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ConfigKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ConfigKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ConfigKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ConfigKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ConfigKey parseFrom(InputStream inputStream) throws IOException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ConfigKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ConfigKey parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ConfigKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ConfigKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ConfigKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ConfigKey parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ConfigKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ConfigKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ConfigKey configKey) {
                return DEFAULT_INSTANCE.createBuilder(configKey);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ConfigKey, Builder> implements ConfigKeyOrBuilder {
                private Builder() {
                    super(ConfigKey.DEFAULT_INSTANCE);
                }

                @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
                public boolean hasUid() {
                    return ((ConfigKey) this.instance).hasUid();
                }

                @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
                public int getUid() {
                    return ((ConfigKey) this.instance).getUid();
                }

                public Builder setUid(int i) {
                    copyOnWrite();
                    ((ConfigKey) this.instance).setUid(i);
                    return this;
                }

                public Builder clearUid() {
                    copyOnWrite();
                    ((ConfigKey) this.instance).clearUid();
                    return this;
                }

                @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
                public boolean hasId() {
                    return ((ConfigKey) this.instance).hasId();
                }

                @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportList.ConfigKeyOrBuilder
                public long getId() {
                    return ((ConfigKey) this.instance).getId();
                }

                public Builder setId(long j) {
                    copyOnWrite();
                    ((ConfigKey) this.instance).setId(j);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((ConfigKey) this.instance).clearId();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new ConfigKey();
                    case 2:
                        return new Builder();
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"bitField0_", "uid_", "id_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ConfigKey> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ConfigKey.class) {
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
                ConfigKey configKey = new ConfigKey();
                DEFAULT_INSTANCE = configKey;
                GeneratedMessageLite.registerDefaultInstance(ConfigKey.class, configKey);
            }

            public static ConfigKey getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ConfigKey> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
        public boolean hasConfigKey() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
        public ConfigKey getConfigKey() {
            ConfigKey configKey = this.configKey_;
            return configKey == null ? ConfigKey.getDefaultInstance() : configKey;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConfigKey(ConfigKey configKey) {
            configKey.getClass();
            this.configKey_ = configKey;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeConfigKey(ConfigKey configKey) {
            configKey.getClass();
            ConfigKey configKey2 = this.configKey_;
            if (configKey2 != null && configKey2 != ConfigKey.getDefaultInstance()) {
                this.configKey_ = ConfigKey.newBuilder(this.configKey_).mergeFrom((ConfigKey.Builder) configKey).buildPartial();
            } else {
                this.configKey_ = configKey;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConfigKey() {
            this.configKey_ = null;
            this.bitField0_ &= -2;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
        public List<ConfigMetricsReport> getReportsList() {
            return this.reports_;
        }

        public List<? extends ConfigMetricsReportOrBuilder> getReportsOrBuilderList() {
            return this.reports_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
        public int getReportsCount() {
            return this.reports_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
        public ConfigMetricsReport getReports(int i) {
            return this.reports_.get(i);
        }

        public ConfigMetricsReportOrBuilder getReportsOrBuilder(int i) {
            return this.reports_.get(i);
        }

        private void ensureReportsIsMutable() {
            Internal.ProtobufList<ConfigMetricsReport> protobufList = this.reports_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.reports_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReports(int i, ConfigMetricsReport configMetricsReport) {
            configMetricsReport.getClass();
            ensureReportsIsMutable();
            this.reports_.set(i, configMetricsReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReports(ConfigMetricsReport configMetricsReport) {
            configMetricsReport.getClass();
            ensureReportsIsMutable();
            this.reports_.add(configMetricsReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReports(int i, ConfigMetricsReport configMetricsReport) {
            configMetricsReport.getClass();
            ensureReportsIsMutable();
            this.reports_.add(i, configMetricsReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllReports(Iterable<? extends ConfigMetricsReport> iterable) {
            ensureReportsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.reports_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReports() {
            this.reports_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeReports(int i) {
            ensureReportsIsMutable();
            this.reports_.remove(i);
        }

        public static ConfigMetricsReportList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConfigMetricsReportList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConfigMetricsReportList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConfigMetricsReportList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConfigMetricsReportList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConfigMetricsReportList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConfigMetricsReportList parseFrom(InputStream inputStream) throws IOException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigMetricsReportList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigMetricsReportList parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigMetricsReportList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigMetricsReportList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigMetricsReportList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigMetricsReportList parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConfigMetricsReportList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigMetricsReportList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConfigMetricsReportList configMetricsReportList) {
            return DEFAULT_INSTANCE.createBuilder(configMetricsReportList);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigMetricsReportList, Builder> implements ConfigMetricsReportListOrBuilder {
            private Builder() {
                super(ConfigMetricsReportList.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
            public boolean hasConfigKey() {
                return ((ConfigMetricsReportList) this.instance).hasConfigKey();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
            public ConfigKey getConfigKey() {
                return ((ConfigMetricsReportList) this.instance).getConfigKey();
            }

            public Builder setConfigKey(ConfigKey configKey) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).setConfigKey(configKey);
                return this;
            }

            public Builder setConfigKey(ConfigKey.Builder builder) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).setConfigKey(builder.build());
                return this;
            }

            public Builder mergeConfigKey(ConfigKey configKey) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).mergeConfigKey(configKey);
                return this;
            }

            public Builder clearConfigKey() {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).clearConfigKey();
                return this;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
            public List<ConfigMetricsReport> getReportsList() {
                return Collections.unmodifiableList(((ConfigMetricsReportList) this.instance).getReportsList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
            public int getReportsCount() {
                return ((ConfigMetricsReportList) this.instance).getReportsCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.ConfigMetricsReportListOrBuilder
            public ConfigMetricsReport getReports(int i) {
                return ((ConfigMetricsReportList) this.instance).getReports(i);
            }

            public Builder setReports(int i, ConfigMetricsReport configMetricsReport) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).setReports(i, configMetricsReport);
                return this;
            }

            public Builder setReports(int i, ConfigMetricsReport.Builder builder) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).setReports(i, builder.build());
                return this;
            }

            public Builder addReports(ConfigMetricsReport configMetricsReport) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).addReports(configMetricsReport);
                return this;
            }

            public Builder addReports(int i, ConfigMetricsReport configMetricsReport) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).addReports(i, configMetricsReport);
                return this;
            }

            public Builder addReports(ConfigMetricsReport.Builder builder) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).addReports(builder.build());
                return this;
            }

            public Builder addReports(int i, ConfigMetricsReport.Builder builder) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).addReports(i, builder.build());
                return this;
            }

            public Builder addAllReports(Iterable<? extends ConfigMetricsReport> iterable) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).addAllReports(iterable);
                return this;
            }

            public Builder clearReports() {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).clearReports();
                return this;
            }

            public Builder removeReports(int i) {
                copyOnWrite();
                ((ConfigMetricsReportList) this.instance).removeReports(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ConfigMetricsReportList();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "configKey_", "reports_", ConfigMetricsReport.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConfigMetricsReportList> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ConfigMetricsReportList.class) {
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
            ConfigMetricsReportList configMetricsReportList = new ConfigMetricsReportList();
            DEFAULT_INSTANCE = configMetricsReportList;
            GeneratedMessageLite.registerDefaultInstance(ConfigMetricsReportList.class, configMetricsReportList);
        }

        public static ConfigMetricsReportList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConfigMetricsReportList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StatsdStatsReport extends GeneratedMessageLite<StatsdStatsReport, Builder> implements StatsdStatsReportOrBuilder {
        public static final int CONFIG_STATS_FIELD_NUMBER = 3;
        private static final StatsdStatsReport DEFAULT_INSTANCE;
        private static volatile Parser<StatsdStatsReport> PARSER;
        private Internal.ProtobufList<ConfigStats> configStats_ = emptyProtobufList();

        public interface ConfigStatsOrBuilder extends MessageLiteOrBuilder {
            long getId();

            boolean getIsValid();

            int getUid();

            boolean hasId();

            boolean hasIsValid();

            boolean hasUid();
        }

        private StatsdStatsReport() {
        }

        public static final class ConfigStats extends GeneratedMessageLite<ConfigStats, Builder> implements ConfigStatsOrBuilder {
            private static final ConfigStats DEFAULT_INSTANCE;
            public static final int ID_FIELD_NUMBER = 2;
            public static final int IS_VALID_FIELD_NUMBER = 9;
            private static volatile Parser<ConfigStats> PARSER = null;
            public static final int UID_FIELD_NUMBER = 1;
            private int bitField0_;
            private long id_;
            private boolean isValid_;
            private int uid_;

            private ConfigStats() {
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
            public boolean hasUid() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
            public int getUid() {
                return this.uid_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUid(int i) {
                this.bitField0_ |= 1;
                this.uid_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUid() {
                this.bitField0_ &= -2;
                this.uid_ = 0;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
            public long getId() {
                return this.id_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setId(long j) {
                this.bitField0_ |= 2;
                this.id_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearId() {
                this.bitField0_ &= -3;
                this.id_ = 0L;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
            public boolean hasIsValid() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
            public boolean getIsValid() {
                return this.isValid_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIsValid(boolean z) {
                this.bitField0_ |= 4;
                this.isValid_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIsValid() {
                this.bitField0_ &= -5;
                this.isValid_ = false;
            }

            public static ConfigStats parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ConfigStats parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ConfigStats parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ConfigStats parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ConfigStats parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ConfigStats parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ConfigStats parseFrom(InputStream inputStream) throws IOException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ConfigStats parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ConfigStats parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ConfigStats) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ConfigStats parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ConfigStats) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ConfigStats parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ConfigStats parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ConfigStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ConfigStats configStats) {
                return DEFAULT_INSTANCE.createBuilder(configStats);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ConfigStats, Builder> implements ConfigStatsOrBuilder {
                private Builder() {
                    super(ConfigStats.DEFAULT_INSTANCE);
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
                public boolean hasUid() {
                    return ((ConfigStats) this.instance).hasUid();
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
                public int getUid() {
                    return ((ConfigStats) this.instance).getUid();
                }

                public Builder setUid(int i) {
                    copyOnWrite();
                    ((ConfigStats) this.instance).setUid(i);
                    return this;
                }

                public Builder clearUid() {
                    copyOnWrite();
                    ((ConfigStats) this.instance).clearUid();
                    return this;
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
                public boolean hasId() {
                    return ((ConfigStats) this.instance).hasId();
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
                public long getId() {
                    return ((ConfigStats) this.instance).getId();
                }

                public Builder setId(long j) {
                    copyOnWrite();
                    ((ConfigStats) this.instance).setId(j);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((ConfigStats) this.instance).clearId();
                    return this;
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
                public boolean hasIsValid() {
                    return ((ConfigStats) this.instance).hasIsValid();
                }

                @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReport.ConfigStatsOrBuilder
                public boolean getIsValid() {
                    return ((ConfigStats) this.instance).getIsValid();
                }

                public Builder setIsValid(boolean z) {
                    copyOnWrite();
                    ((ConfigStats) this.instance).setIsValid(z);
                    return this;
                }

                public Builder clearIsValid() {
                    copyOnWrite();
                    ((ConfigStats) this.instance).clearIsValid();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new ConfigStats();
                    case 2:
                        return new Builder();
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\t\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001\tဇ\u0002", new Object[]{"bitField0_", "uid_", "id_", "isValid_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ConfigStats> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ConfigStats.class) {
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
                ConfigStats configStats = new ConfigStats();
                DEFAULT_INSTANCE = configStats;
                GeneratedMessageLite.registerDefaultInstance(ConfigStats.class, configStats);
            }

            public static ConfigStats getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ConfigStats> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReportOrBuilder
        public List<ConfigStats> getConfigStatsList() {
            return this.configStats_;
        }

        public List<? extends ConfigStatsOrBuilder> getConfigStatsOrBuilderList() {
            return this.configStats_;
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReportOrBuilder
        public int getConfigStatsCount() {
            return this.configStats_.size();
        }

        @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReportOrBuilder
        public ConfigStats getConfigStats(int i) {
            return this.configStats_.get(i);
        }

        public ConfigStatsOrBuilder getConfigStatsOrBuilder(int i) {
            return this.configStats_.get(i);
        }

        private void ensureConfigStatsIsMutable() {
            Internal.ProtobufList<ConfigStats> protobufList = this.configStats_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.configStats_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConfigStats(int i, ConfigStats configStats) {
            configStats.getClass();
            ensureConfigStatsIsMutable();
            this.configStats_.set(i, configStats);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addConfigStats(ConfigStats configStats) {
            configStats.getClass();
            ensureConfigStatsIsMutable();
            this.configStats_.add(configStats);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addConfigStats(int i, ConfigStats configStats) {
            configStats.getClass();
            ensureConfigStatsIsMutable();
            this.configStats_.add(i, configStats);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllConfigStats(Iterable<? extends ConfigStats> iterable) {
            ensureConfigStatsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.configStats_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConfigStats() {
            this.configStats_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeConfigStats(int i) {
            ensureConfigStatsIsMutable();
            this.configStats_.remove(i);
        }

        public static StatsdStatsReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StatsdStatsReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StatsdStatsReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StatsdStatsReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StatsdStatsReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StatsdStatsReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StatsdStatsReport parseFrom(InputStream inputStream) throws IOException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StatsdStatsReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StatsdStatsReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StatsdStatsReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StatsdStatsReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatsdStatsReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StatsdStatsReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StatsdStatsReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatsdStatsReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StatsdStatsReport statsdStatsReport) {
            return DEFAULT_INSTANCE.createBuilder(statsdStatsReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StatsdStatsReport, Builder> implements StatsdStatsReportOrBuilder {
            private Builder() {
                super(StatsdStatsReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReportOrBuilder
            public List<ConfigStats> getConfigStatsList() {
                return Collections.unmodifiableList(((StatsdStatsReport) this.instance).getConfigStatsList());
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReportOrBuilder
            public int getConfigStatsCount() {
                return ((StatsdStatsReport) this.instance).getConfigStatsCount();
            }

            @Override // android.hardware.stepos.StepOSStatsLog.StatsdStatsReportOrBuilder
            public ConfigStats getConfigStats(int i) {
                return ((StatsdStatsReport) this.instance).getConfigStats(i);
            }

            public Builder setConfigStats(int i, ConfigStats configStats) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).setConfigStats(i, configStats);
                return this;
            }

            public Builder setConfigStats(int i, ConfigStats.Builder builder) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).setConfigStats(i, builder.build());
                return this;
            }

            public Builder addConfigStats(ConfigStats configStats) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).addConfigStats(configStats);
                return this;
            }

            public Builder addConfigStats(int i, ConfigStats configStats) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).addConfigStats(i, configStats);
                return this;
            }

            public Builder addConfigStats(ConfigStats.Builder builder) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).addConfigStats(builder.build());
                return this;
            }

            public Builder addConfigStats(int i, ConfigStats.Builder builder) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).addConfigStats(i, builder.build());
                return this;
            }

            public Builder addAllConfigStats(Iterable<? extends ConfigStats> iterable) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).addAllConfigStats(iterable);
                return this;
            }

            public Builder clearConfigStats() {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).clearConfigStats();
                return this;
            }

            public Builder removeConfigStats(int i) {
                copyOnWrite();
                ((StatsdStatsReport) this.instance).removeConfigStats(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new StatsdStatsReport();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0003\u0003\u0001\u0000\u0001\u0000\u0003\u001b", new Object[]{"configStats_", ConfigStats.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StatsdStatsReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StatsdStatsReport.class) {
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
            StatsdStatsReport statsdStatsReport = new StatsdStatsReport();
            DEFAULT_INSTANCE = statsdStatsReport;
            GeneratedMessageLite.registerDefaultInstance(StatsdStatsReport.class, statsdStatsReport);
        }

        public static StatsdStatsReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StatsdStatsReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
