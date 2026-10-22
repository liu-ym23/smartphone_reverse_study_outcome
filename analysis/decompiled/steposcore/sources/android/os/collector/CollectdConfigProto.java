package android.os.collector;

import android.hardware.display.StepOSDisplayManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class CollectdConfigProto {
    private static final int WIRETYPE_FIXED32 = 5;
    private static final int WIRETYPE_FIXED64 = 1;
    private static final int WIRETYPE_LENGTH_DELIMITED = 2;
    private static final int WIRETYPE_VARINT = 0;

    private CollectdConfigProto() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeTag(ByteArrayOutputStream baos, int fieldNumber, int wireType) throws IOException {
        writeVarint(baos, (fieldNumber << 3) | wireType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeVarint(ByteArrayOutputStream baos, long value) throws IOException {
        while (((-128) & value) != 0) {
            baos.write((int) ((127 & value) | 128));
            value >>>= 7;
        }
        baos.write((int) value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeFixed64(ByteArrayOutputStream baos, long value) throws IOException {
        for (int i = 0; i < 8; i++) {
            baos.write((int) ((value >>> (i * 8)) & 255));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readVarint(ByteArrayInputStream bais) throws IOException {
        int b;
        long result = 0;
        int shift = 0;
        do {
            b = bais.read();
            if (b < 0) {
                throw new IOException("Unexpected end of stream while reading varint");
            }
            result |= (b & 127) << shift;
            shift += 7;
            if (shift >= 64) {
                throw new IOException("Varint too long");
            }
        } while ((b & 128) != 0);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readFixed64(ByteArrayInputStream bais) throws IOException {
        long result = 0;
        for (int i = 0; i < 8; i++) {
            int b = bais.read();
            if (b < 0) {
                throw new IOException("Unexpected end of stream while reading fixed64");
            }
            result |= (b & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX) << (i * 8);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void skipField(ByteArrayInputStream bais, int wireType) throws IOException {
        switch (wireType) {
            case 0:
                readVarint(bais);
                return;
            case 1:
                if (bais.skip(8L) != 8) {
                    throw new IOException("Failed to skip fixed64");
                }
                return;
            case 2:
                int length = (int) readVarint(bais);
                if (bais.skip(length) != length) {
                    throw new IOException("Failed to skip length-delimited");
                }
                return;
            case 3:
            case 4:
            default:
                throw new IOException("Unknown wire type: " + wireType);
            case 5:
                if (bais.skip(4L) != 4) {
                    throw new IOException("Failed to skip fixed32");
                }
                return;
        }
    }

    public enum PrivacyLevel {
        PRIVACY_LEVEL_UNSPECIFIED(0),
        PRIVACY_LEVEL_LOW(1),
        PRIVACY_LEVEL_MEDIUM(2),
        PRIVACY_LEVEL_HIGH(3);

        private final int value;

        PrivacyLevel(int value) {
            this.value = value;
        }

        public int getNumber() {
            return this.value;
        }

        public static PrivacyLevel forNumber(int value) {
            for (PrivacyLevel e : values()) {
                if (e.value == value) {
                    return e;
                }
            }
            return PRIVACY_LEVEL_UNSPECIFIED;
        }
    }

    public enum StepOSDomain {
        DEVICE(0),
        SYSTEM(1),
        USER(2),
        INTENTION(3),
        SENSOR(4),
        SCENE(5);

        private final int value;

        StepOSDomain(int value) {
            this.value = value;
        }

        public int getNumber() {
            return this.value;
        }

        public static StepOSDomain forNumber(int value) {
            for (StepOSDomain e : values()) {
                if (e.value == value) {
                    return e;
                }
            }
            return DEVICE;
        }
    }

    public static final class AtomConfig implements Serializable {
        private static final long serialVersionUID = 1;
        private final int mAtomId;
        private final boolean mAtomIdSet;
        private final double mBaseSamplingRate;
        private final boolean mBaseSamplingRateSet;
        private final long mCollectionIntervalMs;
        private final boolean mCollectionIntervalMsSet;
        private final long mDataFreshnessThresholdMs;
        private final boolean mDataFreshnessThresholdMsSet;
        private final int mDataRetentionDays;
        private final boolean mDataRetentionDaysSet;
        private final boolean mEnabled;
        private final boolean mEnabledSet;
        private final PrivacyLevel mPrivacyLevel;
        private final boolean mPrivacyLevelSet;

        private AtomConfig(Builder b) {
            this.mAtomId = b.mAtomId;
            this.mAtomIdSet = b.mAtomIdSet;
            this.mEnabled = b.mEnabled;
            this.mEnabledSet = b.mEnabledSet;
            this.mBaseSamplingRate = b.mBaseSamplingRate;
            this.mBaseSamplingRateSet = b.mBaseSamplingRateSet;
            this.mCollectionIntervalMs = b.mCollectionIntervalMs;
            this.mCollectionIntervalMsSet = b.mCollectionIntervalMsSet;
            this.mDataFreshnessThresholdMs = b.mDataFreshnessThresholdMs;
            this.mDataFreshnessThresholdMsSet = b.mDataFreshnessThresholdMsSet;
            this.mDataRetentionDays = b.mDataRetentionDays;
            this.mDataRetentionDaysSet = b.mDataRetentionDaysSet;
            this.mPrivacyLevel = b.mPrivacyLevel;
            this.mPrivacyLevelSet = b.mPrivacyLevelSet;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            Builder b = new Builder();
            if (this.mAtomIdSet) {
                b.setAtomId(this.mAtomId);
            }
            if (this.mEnabledSet) {
                b.setEnabled(this.mEnabled);
            }
            if (this.mBaseSamplingRateSet) {
                b.setBaseSamplingRate(this.mBaseSamplingRate);
            }
            if (this.mCollectionIntervalMsSet) {
                b.setCollectionIntervalMs(this.mCollectionIntervalMs);
            }
            if (this.mDataFreshnessThresholdMsSet) {
                b.setDataFreshnessThresholdMs(this.mDataFreshnessThresholdMs);
            }
            if (this.mDataRetentionDaysSet) {
                b.setDataRetentionDays(this.mDataRetentionDays);
            }
            if (this.mPrivacyLevelSet) {
                b.setPrivacyLevel(this.mPrivacyLevel);
            }
            return b;
        }

        public static AtomConfig getDefaultInstance() {
            return newBuilder().build();
        }

        public boolean hasAtomId() {
            return this.mAtomIdSet;
        }

        public int getAtomId() {
            return this.mAtomId;
        }

        public boolean hasEnabled() {
            return this.mEnabledSet;
        }

        public boolean getEnabled() {
            return this.mEnabled;
        }

        public boolean hasBaseSamplingRate() {
            return this.mBaseSamplingRateSet;
        }

        public double getBaseSamplingRate() {
            return this.mBaseSamplingRate;
        }

        public boolean hasCollectionIntervalMs() {
            return this.mCollectionIntervalMsSet;
        }

        public long getCollectionIntervalMs() {
            return this.mCollectionIntervalMs;
        }

        public boolean hasDataFreshnessThresholdMs() {
            return this.mDataFreshnessThresholdMsSet;
        }

        public long getDataFreshnessThresholdMs() {
            return this.mDataFreshnessThresholdMs;
        }

        public boolean hasDataRetentionDays() {
            return this.mDataRetentionDaysSet;
        }

        public int getDataRetentionDays() {
            return this.mDataRetentionDays;
        }

        public boolean hasPrivacyLevel() {
            return this.mPrivacyLevelSet;
        }

        public PrivacyLevel getPrivacyLevel() {
            return this.mPrivacyLevel;
        }

        public static final class Builder {
            private int mAtomId;
            private boolean mAtomIdSet;
            private double mBaseSamplingRate;
            private boolean mBaseSamplingRateSet;
            private long mCollectionIntervalMs;
            private boolean mCollectionIntervalMsSet;
            private long mDataFreshnessThresholdMs;
            private boolean mDataFreshnessThresholdMsSet;
            private int mDataRetentionDays;
            private boolean mDataRetentionDaysSet;
            private boolean mEnabled;
            private boolean mEnabledSet;
            private PrivacyLevel mPrivacyLevel;
            private boolean mPrivacyLevelSet;

            private Builder() {
                this.mAtomId = 0;
                this.mEnabled = false;
                this.mBaseSamplingRate = 0.0d;
                this.mCollectionIntervalMs = 0L;
                this.mDataFreshnessThresholdMs = 0L;
                this.mDataRetentionDays = 0;
            }

            public Builder setAtomId(int v) {
                this.mAtomId = v;
                this.mAtomIdSet = true;
                return this;
            }

            public Builder clearAtomId() {
                this.mAtomIdSet = false;
                this.mAtomId = 0;
                return this;
            }

            public Builder setEnabled(boolean v) {
                this.mEnabled = v;
                this.mEnabledSet = true;
                return this;
            }

            public Builder clearEnabled() {
                this.mEnabledSet = false;
                this.mEnabled = false;
                return this;
            }

            public Builder setBaseSamplingRate(double v) {
                this.mBaseSamplingRate = v;
                this.mBaseSamplingRateSet = true;
                return this;
            }

            public Builder clearBaseSamplingRate() {
                this.mBaseSamplingRateSet = false;
                this.mBaseSamplingRate = 0.0d;
                return this;
            }

            public Builder setCollectionIntervalMs(long v) {
                this.mCollectionIntervalMs = v;
                this.mCollectionIntervalMsSet = true;
                return this;
            }

            public Builder clearCollectionIntervalMs() {
                this.mCollectionIntervalMsSet = false;
                this.mCollectionIntervalMs = 0L;
                return this;
            }

            public Builder setDataFreshnessThresholdMs(long v) {
                this.mDataFreshnessThresholdMs = v;
                this.mDataFreshnessThresholdMsSet = true;
                return this;
            }

            public Builder clearDataFreshnessThresholdMs() {
                this.mDataFreshnessThresholdMsSet = false;
                this.mDataFreshnessThresholdMs = 0L;
                return this;
            }

            public Builder setDataRetentionDays(int v) {
                this.mDataRetentionDays = v;
                this.mDataRetentionDaysSet = true;
                return this;
            }

            public Builder clearDataRetentionDays() {
                this.mDataRetentionDaysSet = false;
                this.mDataRetentionDays = 0;
                return this;
            }

            public Builder setPrivacyLevel(PrivacyLevel v) {
                if (v == null) {
                    throw new NullPointerException("privacy_level value");
                }
                this.mPrivacyLevel = v;
                this.mPrivacyLevelSet = true;
                return this;
            }

            public Builder clearPrivacyLevel() {
                this.mPrivacyLevelSet = false;
                this.mPrivacyLevel = null;
                return this;
            }

            public AtomConfig build() {
                return new AtomConfig(this);
            }
        }

        public byte[] toByteArray() {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                if (this.mAtomIdSet) {
                    CollectdConfigProto.writeTag(baos, 1, 0);
                    CollectdConfigProto.writeVarint(baos, this.mAtomId);
                }
                if (this.mEnabledSet) {
                    CollectdConfigProto.writeTag(baos, 2, 0);
                    CollectdConfigProto.writeVarint(baos, this.mEnabled ? serialVersionUID : 0L);
                }
                if (this.mBaseSamplingRateSet) {
                    CollectdConfigProto.writeTag(baos, 3, 1);
                    CollectdConfigProto.writeFixed64(baos, Double.doubleToRawLongBits(this.mBaseSamplingRate));
                }
                if (this.mCollectionIntervalMsSet) {
                    CollectdConfigProto.writeTag(baos, 4, 0);
                    CollectdConfigProto.writeVarint(baos, this.mCollectionIntervalMs);
                }
                if (this.mDataFreshnessThresholdMsSet) {
                    CollectdConfigProto.writeTag(baos, 5, 0);
                    CollectdConfigProto.writeVarint(baos, this.mDataFreshnessThresholdMs);
                }
                if (this.mDataRetentionDaysSet) {
                    CollectdConfigProto.writeTag(baos, 6, 0);
                    CollectdConfigProto.writeVarint(baos, this.mDataRetentionDays);
                }
                if (this.mPrivacyLevelSet) {
                    CollectdConfigProto.writeTag(baos, 7, 0);
                    CollectdConfigProto.writeVarint(baos, this.mPrivacyLevel.getNumber());
                }
                return baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Failed to serialize AtomConfig", e);
            }
        }

        public static AtomConfig parseFrom(byte[] data) throws IOException {
            Builder b = newBuilder();
            if (data == null || data.length == 0) {
                return b.build();
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            while (bais.available() > 0) {
                long tag = CollectdConfigProto.readVarint(bais);
                int fieldNumber = (int) (tag >>> 3);
                int wireType = (int) (7 & tag);
                switch (fieldNumber) {
                    case 1:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setAtomId((int) CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 2:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setEnabled(CollectdConfigProto.readVarint(bais) != 0);
                            break;
                        }
                    case 3:
                        if (wireType != 1) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setBaseSamplingRate(Double.longBitsToDouble(CollectdConfigProto.readFixed64(bais)));
                            break;
                        }
                    case 4:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setCollectionIntervalMs(CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 5:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setDataFreshnessThresholdMs(CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 6:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setDataRetentionDays((int) CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 7:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setPrivacyLevel(PrivacyLevel.forNumber((int) CollectdConfigProto.readVarint(bais)));
                            break;
                        }
                    default:
                        CollectdConfigProto.skipField(bais, wireType);
                        break;
                }
            }
            return b.build();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof AtomConfig)) {
                return false;
            }
            AtomConfig other = (AtomConfig) o;
            return this.mAtomIdSet == other.mAtomIdSet && (!this.mAtomIdSet || this.mAtomId == other.mAtomId) && this.mEnabledSet == other.mEnabledSet && ((!this.mEnabledSet || this.mEnabled == other.mEnabled) && this.mBaseSamplingRateSet == other.mBaseSamplingRateSet && ((!this.mBaseSamplingRateSet || Double.doubleToRawLongBits(this.mBaseSamplingRate) == Double.doubleToRawLongBits(other.mBaseSamplingRate)) && this.mCollectionIntervalMsSet == other.mCollectionIntervalMsSet && ((!this.mCollectionIntervalMsSet || this.mCollectionIntervalMs == other.mCollectionIntervalMs) && this.mDataFreshnessThresholdMsSet == other.mDataFreshnessThresholdMsSet && ((!this.mDataFreshnessThresholdMsSet || this.mDataFreshnessThresholdMs == other.mDataFreshnessThresholdMs) && this.mDataRetentionDaysSet == other.mDataRetentionDaysSet && ((!this.mDataRetentionDaysSet || this.mDataRetentionDays == other.mDataRetentionDays) && this.mPrivacyLevelSet == other.mPrivacyLevelSet && (!this.mPrivacyLevelSet || Objects.equals(this.mPrivacyLevel, other.mPrivacyLevel)))))));
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.mAtomId), Boolean.valueOf(this.mEnabled), Double.valueOf(this.mBaseSamplingRate), Long.valueOf(this.mCollectionIntervalMs), Long.valueOf(this.mDataFreshnessThresholdMs), Integer.valueOf(this.mDataRetentionDays), this.mPrivacyLevel);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AtomConfig{");
            boolean first = true;
            if (this.mAtomIdSet) {
                if (1 == 0) {
                    sb.append(", ");
                }
                sb.append("atom_id=").append(this.mAtomId);
                first = false;
            }
            if (this.mEnabledSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("enabled=").append(this.mEnabled);
                first = false;
            }
            if (this.mBaseSamplingRateSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("base_sampling_rate=").append(this.mBaseSamplingRate);
                first = false;
            }
            if (this.mCollectionIntervalMsSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("collection_interval_ms=").append(this.mCollectionIntervalMs);
                first = false;
            }
            if (this.mDataFreshnessThresholdMsSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("data_freshness_threshold_ms=").append(this.mDataFreshnessThresholdMs);
                first = false;
            }
            if (this.mDataRetentionDaysSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("data_retention_days=").append(this.mDataRetentionDays);
                first = false;
            }
            if (this.mPrivacyLevelSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("privacy_level=").append(this.mPrivacyLevel);
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static final class DomainConfig implements Serializable {
        private static final long serialVersionUID = 1;
        private final List<AtomConfig> mAtomConfigs;
        private final long mDataFreshnessThresholdMs;
        private final boolean mDataFreshnessThresholdMsSet;
        private final int mDataRetentionDays;
        private final boolean mDataRetentionDaysSet;
        private final StepOSDomain mDomain;
        private final boolean mDomainSet;
        private final boolean mEnabled;
        private final boolean mEnabledSet;
        private final PrivacyLevel mPrivacyLevel;
        private final boolean mPrivacyLevelSet;

        private DomainConfig(Builder b) {
            this.mDomain = b.mDomain;
            this.mDomainSet = b.mDomainSet;
            this.mEnabled = b.mEnabled;
            this.mEnabledSet = b.mEnabledSet;
            this.mDataRetentionDays = b.mDataRetentionDays;
            this.mDataRetentionDaysSet = b.mDataRetentionDaysSet;
            this.mDataFreshnessThresholdMs = b.mDataFreshnessThresholdMs;
            this.mDataFreshnessThresholdMsSet = b.mDataFreshnessThresholdMsSet;
            this.mPrivacyLevel = b.mPrivacyLevel;
            this.mPrivacyLevelSet = b.mPrivacyLevelSet;
            this.mAtomConfigs = Collections.unmodifiableList(new ArrayList(b.mAtomConfigs));
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            Builder b = new Builder();
            if (this.mDomainSet) {
                b.setDomain(this.mDomain);
            }
            if (this.mEnabledSet) {
                b.setEnabled(this.mEnabled);
            }
            if (this.mDataRetentionDaysSet) {
                b.setDataRetentionDays(this.mDataRetentionDays);
            }
            if (this.mDataFreshnessThresholdMsSet) {
                b.setDataFreshnessThresholdMs(this.mDataFreshnessThresholdMs);
            }
            if (this.mPrivacyLevelSet) {
                b.setPrivacyLevel(this.mPrivacyLevel);
            }
            b.mAtomConfigs.addAll(this.mAtomConfigs);
            return b;
        }

        public static DomainConfig getDefaultInstance() {
            return newBuilder().build();
        }

        public boolean hasDomain() {
            return this.mDomainSet;
        }

        public StepOSDomain getDomain() {
            return this.mDomain;
        }

        public boolean hasEnabled() {
            return this.mEnabledSet;
        }

        public boolean getEnabled() {
            return this.mEnabled;
        }

        public boolean hasDataRetentionDays() {
            return this.mDataRetentionDaysSet;
        }

        public int getDataRetentionDays() {
            return this.mDataRetentionDays;
        }

        public boolean hasDataFreshnessThresholdMs() {
            return this.mDataFreshnessThresholdMsSet;
        }

        public long getDataFreshnessThresholdMs() {
            return this.mDataFreshnessThresholdMs;
        }

        public boolean hasPrivacyLevel() {
            return this.mPrivacyLevelSet;
        }

        public PrivacyLevel getPrivacyLevel() {
            return this.mPrivacyLevel;
        }

        public List<AtomConfig> getAtomConfigsList() {
            return this.mAtomConfigs;
        }

        public int getAtomConfigsCount() {
            return this.mAtomConfigs.size();
        }

        public AtomConfig getAtomConfigs(int index) {
            return this.mAtomConfigs.get(index);
        }

        public static final class Builder {
            private final List<AtomConfig> mAtomConfigs;
            private long mDataFreshnessThresholdMs;
            private boolean mDataFreshnessThresholdMsSet;
            private int mDataRetentionDays;
            private boolean mDataRetentionDaysSet;
            private StepOSDomain mDomain;
            private boolean mDomainSet;
            private boolean mEnabled;
            private boolean mEnabledSet;
            private PrivacyLevel mPrivacyLevel;
            private boolean mPrivacyLevelSet;

            private Builder() {
                this.mEnabled = false;
                this.mDataRetentionDays = 0;
                this.mDataFreshnessThresholdMs = 0L;
                this.mAtomConfigs = new ArrayList();
            }

            public Builder setDomain(StepOSDomain v) {
                if (v == null) {
                    throw new NullPointerException("domain value");
                }
                this.mDomain = v;
                this.mDomainSet = true;
                return this;
            }

            public Builder clearDomain() {
                this.mDomainSet = false;
                this.mDomain = null;
                return this;
            }

            public Builder setEnabled(boolean v) {
                this.mEnabled = v;
                this.mEnabledSet = true;
                return this;
            }

            public Builder clearEnabled() {
                this.mEnabledSet = false;
                this.mEnabled = false;
                return this;
            }

            public Builder setDataRetentionDays(int v) {
                this.mDataRetentionDays = v;
                this.mDataRetentionDaysSet = true;
                return this;
            }

            public Builder clearDataRetentionDays() {
                this.mDataRetentionDaysSet = false;
                this.mDataRetentionDays = 0;
                return this;
            }

            public Builder setDataFreshnessThresholdMs(long v) {
                this.mDataFreshnessThresholdMs = v;
                this.mDataFreshnessThresholdMsSet = true;
                return this;
            }

            public Builder clearDataFreshnessThresholdMs() {
                this.mDataFreshnessThresholdMsSet = false;
                this.mDataFreshnessThresholdMs = 0L;
                return this;
            }

            public Builder setPrivacyLevel(PrivacyLevel v) {
                if (v == null) {
                    throw new NullPointerException("privacy_level value");
                }
                this.mPrivacyLevel = v;
                this.mPrivacyLevelSet = true;
                return this;
            }

            public Builder clearPrivacyLevel() {
                this.mPrivacyLevelSet = false;
                this.mPrivacyLevel = null;
                return this;
            }

            public Builder addAtomConfigs(AtomConfig v) {
                if (v == null) {
                    throw new NullPointerException("atom_configs value");
                }
                this.mAtomConfigs.add(v);
                return this;
            }

            public Builder addAllAtomConfigs(Collection<? extends AtomConfig> v) {
                for (AtomConfig item : v) {
                    if (item == null) {
                        throw new NullPointerException("atom_configs value");
                    }
                    this.mAtomConfigs.add(item);
                }
                return this;
            }

            public Builder clearAtomConfigs() {
                this.mAtomConfigs.clear();
                return this;
            }

            public DomainConfig build() {
                return new DomainConfig(this);
            }
        }

        public byte[] toByteArray() {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                if (this.mDomainSet) {
                    CollectdConfigProto.writeTag(baos, 1, 0);
                    CollectdConfigProto.writeVarint(baos, this.mDomain.getNumber());
                }
                if (this.mEnabledSet) {
                    CollectdConfigProto.writeTag(baos, 2, 0);
                    CollectdConfigProto.writeVarint(baos, this.mEnabled ? serialVersionUID : 0L);
                }
                if (this.mDataRetentionDaysSet) {
                    CollectdConfigProto.writeTag(baos, 3, 0);
                    CollectdConfigProto.writeVarint(baos, this.mDataRetentionDays);
                }
                if (this.mDataFreshnessThresholdMsSet) {
                    CollectdConfigProto.writeTag(baos, 4, 0);
                    CollectdConfigProto.writeVarint(baos, this.mDataFreshnessThresholdMs);
                }
                if (this.mPrivacyLevelSet) {
                    CollectdConfigProto.writeTag(baos, 5, 0);
                    CollectdConfigProto.writeVarint(baos, this.mPrivacyLevel.getNumber());
                }
                for (AtomConfig v : this.mAtomConfigs) {
                    byte[] sub = v.toByteArray();
                    CollectdConfigProto.writeTag(baos, 6, 2);
                    CollectdConfigProto.writeVarint(baos, sub.length);
                    baos.write(sub);
                }
                return baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Failed to serialize DomainConfig", e);
            }
        }

        public static DomainConfig parseFrom(byte[] data) throws IOException {
            Builder b = newBuilder();
            if (data == null || data.length == 0) {
                return b.build();
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            while (bais.available() > 0) {
                long tag = CollectdConfigProto.readVarint(bais);
                int fieldNumber = (int) (tag >>> 3);
                int wireType = (int) (7 & tag);
                switch (fieldNumber) {
                    case 1:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setDomain(StepOSDomain.forNumber((int) CollectdConfigProto.readVarint(bais)));
                            break;
                        }
                    case 2:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setEnabled(CollectdConfigProto.readVarint(bais) != 0);
                            break;
                        }
                    case 3:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setDataRetentionDays((int) CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 4:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setDataFreshnessThresholdMs(CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 5:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setPrivacyLevel(PrivacyLevel.forNumber((int) CollectdConfigProto.readVarint(bais)));
                            break;
                        }
                    case 6:
                        if (wireType == 2) {
                            int len = (int) CollectdConfigProto.readVarint(bais);
                            byte[] sub = new byte[len];
                            if (bais.read(sub) != len) {
                                throw new IOException("short read on atom_configs");
                            }
                            b.addAtomConfigs(AtomConfig.parseFrom(sub));
                            break;
                        } else {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        }
                    default:
                        CollectdConfigProto.skipField(bais, wireType);
                        break;
                }
            }
            return b.build();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof DomainConfig)) {
                return false;
            }
            DomainConfig other = (DomainConfig) o;
            return this.mDomainSet == other.mDomainSet && (!this.mDomainSet || Objects.equals(this.mDomain, other.mDomain)) && this.mEnabledSet == other.mEnabledSet && ((!this.mEnabledSet || this.mEnabled == other.mEnabled) && this.mDataRetentionDaysSet == other.mDataRetentionDaysSet && ((!this.mDataRetentionDaysSet || this.mDataRetentionDays == other.mDataRetentionDays) && this.mDataFreshnessThresholdMsSet == other.mDataFreshnessThresholdMsSet && ((!this.mDataFreshnessThresholdMsSet || this.mDataFreshnessThresholdMs == other.mDataFreshnessThresholdMs) && this.mPrivacyLevelSet == other.mPrivacyLevelSet && ((!this.mPrivacyLevelSet || Objects.equals(this.mPrivacyLevel, other.mPrivacyLevel)) && Objects.equals(this.mAtomConfigs, other.mAtomConfigs)))));
        }

        public int hashCode() {
            return Objects.hash(this.mDomain, Boolean.valueOf(this.mEnabled), Integer.valueOf(this.mDataRetentionDays), Long.valueOf(this.mDataFreshnessThresholdMs), this.mPrivacyLevel, this.mAtomConfigs);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("DomainConfig{");
            boolean first = true;
            if (this.mDomainSet) {
                if (1 == 0) {
                    sb.append(", ");
                }
                sb.append("domain=").append(this.mDomain);
                first = false;
            }
            if (this.mEnabledSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("enabled=").append(this.mEnabled);
                first = false;
            }
            if (this.mDataRetentionDaysSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("data_retention_days=").append(this.mDataRetentionDays);
                first = false;
            }
            if (this.mDataFreshnessThresholdMsSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("data_freshness_threshold_ms=").append(this.mDataFreshnessThresholdMs);
                first = false;
            }
            if (this.mPrivacyLevelSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("privacy_level=").append(this.mPrivacyLevel);
                first = false;
            }
            if (!first) {
                sb.append(", ");
            }
            sb.append("atom_configs=").append(this.mAtomConfigs);
            sb.append("}");
            return sb.toString();
        }
    }

    public static final class CollectorConfig implements Serializable {
        private static final long serialVersionUID = 1;
        private final List<DomainConfig> mDomainConfigs;
        private final long mId;
        private final boolean mIdSet;
        private final int mSchemaVersion;
        private final boolean mSchemaVersionSet;
        private final long mTtlSeconds;
        private final boolean mTtlSecondsSet;

        private CollectorConfig(Builder b) {
            this.mId = b.mId;
            this.mIdSet = b.mIdSet;
            this.mTtlSeconds = b.mTtlSeconds;
            this.mTtlSecondsSet = b.mTtlSecondsSet;
            this.mDomainConfigs = Collections.unmodifiableList(new ArrayList(b.mDomainConfigs));
            this.mSchemaVersion = b.mSchemaVersion;
            this.mSchemaVersionSet = b.mSchemaVersionSet;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            Builder b = new Builder();
            if (this.mIdSet) {
                b.setId(this.mId);
            }
            if (this.mTtlSecondsSet) {
                b.setTtlSeconds(this.mTtlSeconds);
            }
            b.mDomainConfigs.addAll(this.mDomainConfigs);
            if (this.mSchemaVersionSet) {
                b.setSchemaVersion(this.mSchemaVersion);
            }
            return b;
        }

        public static CollectorConfig getDefaultInstance() {
            return newBuilder().build();
        }

        public boolean hasId() {
            return this.mIdSet;
        }

        public long getId() {
            return this.mId;
        }

        public boolean hasTtlSeconds() {
            return this.mTtlSecondsSet;
        }

        public long getTtlSeconds() {
            return this.mTtlSeconds;
        }

        public List<DomainConfig> getDomainConfigsList() {
            return this.mDomainConfigs;
        }

        public int getDomainConfigsCount() {
            return this.mDomainConfigs.size();
        }

        public DomainConfig getDomainConfigs(int index) {
            return this.mDomainConfigs.get(index);
        }

        public boolean hasSchemaVersion() {
            return this.mSchemaVersionSet;
        }

        public int getSchemaVersion() {
            return this.mSchemaVersion;
        }

        public static final class Builder {
            private final List<DomainConfig> mDomainConfigs;
            private long mId;
            private boolean mIdSet;
            private int mSchemaVersion;
            private boolean mSchemaVersionSet;
            private long mTtlSeconds;
            private boolean mTtlSecondsSet;

            private Builder() {
                this.mId = 0L;
                this.mTtlSeconds = 0L;
                this.mDomainConfigs = new ArrayList();
                this.mSchemaVersion = 0;
            }

            public Builder setId(long v) {
                this.mId = v;
                this.mIdSet = true;
                return this;
            }

            public Builder clearId() {
                this.mIdSet = false;
                this.mId = 0L;
                return this;
            }

            public Builder setTtlSeconds(long v) {
                this.mTtlSeconds = v;
                this.mTtlSecondsSet = true;
                return this;
            }

            public Builder clearTtlSeconds() {
                this.mTtlSecondsSet = false;
                this.mTtlSeconds = 0L;
                return this;
            }

            public Builder addDomainConfigs(DomainConfig v) {
                if (v == null) {
                    throw new NullPointerException("domain_configs value");
                }
                this.mDomainConfigs.add(v);
                return this;
            }

            public Builder addAllDomainConfigs(Collection<? extends DomainConfig> v) {
                for (DomainConfig item : v) {
                    if (item == null) {
                        throw new NullPointerException("domain_configs value");
                    }
                    this.mDomainConfigs.add(item);
                }
                return this;
            }

            public Builder clearDomainConfigs() {
                this.mDomainConfigs.clear();
                return this;
            }

            public Builder setSchemaVersion(int v) {
                this.mSchemaVersion = v;
                this.mSchemaVersionSet = true;
                return this;
            }

            public Builder clearSchemaVersion() {
                this.mSchemaVersionSet = false;
                this.mSchemaVersion = 0;
                return this;
            }

            public CollectorConfig build() {
                return new CollectorConfig(this);
            }
        }

        public byte[] toByteArray() {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                if (this.mIdSet) {
                    CollectdConfigProto.writeTag(baos, 1, 0);
                    CollectdConfigProto.writeVarint(baos, this.mId);
                }
                if (this.mTtlSecondsSet) {
                    CollectdConfigProto.writeTag(baos, 2, 0);
                    CollectdConfigProto.writeVarint(baos, this.mTtlSeconds);
                }
                for (DomainConfig v : this.mDomainConfigs) {
                    byte[] sub = v.toByteArray();
                    CollectdConfigProto.writeTag(baos, 3, 2);
                    CollectdConfigProto.writeVarint(baos, sub.length);
                    baos.write(sub);
                }
                if (this.mSchemaVersionSet) {
                    CollectdConfigProto.writeTag(baos, 4, 0);
                    CollectdConfigProto.writeVarint(baos, this.mSchemaVersion);
                }
                return baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Failed to serialize CollectorConfig", e);
            }
        }

        public static CollectorConfig parseFrom(byte[] data) throws IOException {
            Builder b = newBuilder();
            if (data == null || data.length == 0) {
                return b.build();
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            while (bais.available() > 0) {
                long tag = CollectdConfigProto.readVarint(bais);
                int fieldNumber = (int) (tag >>> 3);
                int wireType = (int) (7 & tag);
                switch (fieldNumber) {
                    case 1:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setId(CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 2:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setTtlSeconds(CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    case 3:
                        if (wireType == 2) {
                            int len = (int) CollectdConfigProto.readVarint(bais);
                            byte[] sub = new byte[len];
                            if (bais.read(sub) != len) {
                                throw new IOException("short read on domain_configs");
                            }
                            b.addDomainConfigs(DomainConfig.parseFrom(sub));
                            break;
                        } else {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        }
                    case 4:
                        if (wireType != 0) {
                            CollectdConfigProto.skipField(bais, wireType);
                            break;
                        } else {
                            b.setSchemaVersion((int) CollectdConfigProto.readVarint(bais));
                            break;
                        }
                    default:
                        CollectdConfigProto.skipField(bais, wireType);
                        break;
                }
            }
            return b.build();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof CollectorConfig)) {
                return false;
            }
            CollectorConfig other = (CollectorConfig) o;
            return this.mIdSet == other.mIdSet && (!this.mIdSet || this.mId == other.mId) && this.mTtlSecondsSet == other.mTtlSecondsSet && ((!this.mTtlSecondsSet || this.mTtlSeconds == other.mTtlSeconds) && Objects.equals(this.mDomainConfigs, other.mDomainConfigs) && this.mSchemaVersionSet == other.mSchemaVersionSet && (!this.mSchemaVersionSet || this.mSchemaVersion == other.mSchemaVersion));
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.mId), Long.valueOf(this.mTtlSeconds), this.mDomainConfigs, Integer.valueOf(this.mSchemaVersion));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CollectorConfig{");
            boolean first = true;
            if (this.mIdSet) {
                if (1 == 0) {
                    sb.append(", ");
                }
                sb.append("id=").append(this.mId);
                first = false;
            }
            if (this.mTtlSecondsSet) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("ttl_seconds=").append(this.mTtlSeconds);
                first = false;
            }
            if (!first) {
                sb.append(", ");
            }
            sb.append("domain_configs=").append(this.mDomainConfigs);
            if (this.mSchemaVersionSet) {
                if (0 == 0) {
                    sb.append(", ");
                }
                sb.append("schema_version=").append(this.mSchemaVersion);
            }
            sb.append("}");
            return sb.toString();
        }
    }
}
