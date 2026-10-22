package stepos.com.android.os;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public final class StatsLogEnums {
    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private StatsLogEnums() {
    }

    public enum BucketDropReason implements Internal.EnumLite {
        DUMP_REPORT_REQUESTED(1),
        EVENT_IN_WRONG_BUCKET(2),
        CONDITION_UNKNOWN(3),
        PULL_FAILED(4),
        PULL_DELAYED(5),
        DIMENSION_GUARDRAIL_REACHED(6),
        MULTIPLE_BUCKETS_SKIPPED(7),
        BUCKET_TOO_SMALL(8),
        NO_DATA(9);

        public static final int BUCKET_TOO_SMALL_VALUE = 8;
        public static final int CONDITION_UNKNOWN_VALUE = 3;
        public static final int DIMENSION_GUARDRAIL_REACHED_VALUE = 6;
        public static final int DUMP_REPORT_REQUESTED_VALUE = 1;
        public static final int EVENT_IN_WRONG_BUCKET_VALUE = 2;
        public static final int MULTIPLE_BUCKETS_SKIPPED_VALUE = 7;
        public static final int NO_DATA_VALUE = 9;
        public static final int PULL_DELAYED_VALUE = 5;
        public static final int PULL_FAILED_VALUE = 4;
        private static final Internal.EnumLiteMap<BucketDropReason> internalValueMap = new Internal.EnumLiteMap<BucketDropReason>() { // from class: stepos.com.android.os.StatsLogEnums.BucketDropReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public BucketDropReason findValueByNumber(int i) {
                return BucketDropReason.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static BucketDropReason valueOf(int i) {
            return forNumber(i);
        }

        public static BucketDropReason forNumber(int i) {
            switch (i) {
                case 1:
                    return DUMP_REPORT_REQUESTED;
                case 2:
                    return EVENT_IN_WRONG_BUCKET;
                case 3:
                    return CONDITION_UNKNOWN;
                case 4:
                    return PULL_FAILED;
                case 5:
                    return PULL_DELAYED;
                case 6:
                    return DIMENSION_GUARDRAIL_REACHED;
                case 7:
                    return MULTIPLE_BUCKETS_SKIPPED;
                case 8:
                    return BUCKET_TOO_SMALL;
                case 9:
                    return NO_DATA;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<BucketDropReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return BucketDropReasonVerifier.INSTANCE;
        }

        private static final class BucketDropReasonVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new BucketDropReasonVerifier();

            private BucketDropReasonVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return BucketDropReason.forNumber(i) != null;
            }
        }

        BucketDropReason(int i) {
            this.value = i;
        }
    }

    public enum DataCorruptedReason implements Internal.EnumLite {
        DATA_CORRUPTED_UNKNOWN(0),
        DATA_CORRUPTED_EVENT_QUEUE_OVERFLOW(1),
        DATA_CORRUPTED_SOCKET_LOSS(2);

        public static final int DATA_CORRUPTED_EVENT_QUEUE_OVERFLOW_VALUE = 1;
        public static final int DATA_CORRUPTED_SOCKET_LOSS_VALUE = 2;
        public static final int DATA_CORRUPTED_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<DataCorruptedReason> internalValueMap = new Internal.EnumLiteMap<DataCorruptedReason>() { // from class: stepos.com.android.os.StatsLogEnums.DataCorruptedReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public DataCorruptedReason findValueByNumber(int i) {
                return DataCorruptedReason.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DataCorruptedReason valueOf(int i) {
            return forNumber(i);
        }

        public static DataCorruptedReason forNumber(int i) {
            if (i == 0) {
                return DATA_CORRUPTED_UNKNOWN;
            }
            if (i == 1) {
                return DATA_CORRUPTED_EVENT_QUEUE_OVERFLOW;
            }
            if (i != 2) {
                return null;
            }
            return DATA_CORRUPTED_SOCKET_LOSS;
        }

        public static Internal.EnumLiteMap<DataCorruptedReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DataCorruptedReasonVerifier.INSTANCE;
        }

        private static final class DataCorruptedReasonVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new DataCorruptedReasonVerifier();

            private DataCorruptedReasonVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return DataCorruptedReason.forNumber(i) != null;
            }
        }

        DataCorruptedReason(int i) {
            this.value = i;
        }
    }

    public enum DumpReportReason implements Internal.EnumLite {
        DEVICE_SHUTDOWN(1),
        CONFIG_UPDATED(2),
        CONFIG_REMOVED(3),
        GET_DATA_CALLED(4),
        ADB_DUMP(5),
        CONFIG_RESET(6),
        STATSCOMPANION_DIED(7),
        TERMINATION_SIGNAL_RECEIVED(8);

        public static final int ADB_DUMP_VALUE = 5;
        public static final int CONFIG_REMOVED_VALUE = 3;
        public static final int CONFIG_RESET_VALUE = 6;
        public static final int CONFIG_UPDATED_VALUE = 2;
        public static final int DEVICE_SHUTDOWN_VALUE = 1;
        public static final int GET_DATA_CALLED_VALUE = 4;
        public static final int STATSCOMPANION_DIED_VALUE = 7;
        public static final int TERMINATION_SIGNAL_RECEIVED_VALUE = 8;
        private static final Internal.EnumLiteMap<DumpReportReason> internalValueMap = new Internal.EnumLiteMap<DumpReportReason>() { // from class: stepos.com.android.os.StatsLogEnums.DumpReportReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public DumpReportReason findValueByNumber(int i) {
                return DumpReportReason.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DumpReportReason valueOf(int i) {
            return forNumber(i);
        }

        public static DumpReportReason forNumber(int i) {
            switch (i) {
                case 1:
                    return DEVICE_SHUTDOWN;
                case 2:
                    return CONFIG_UPDATED;
                case 3:
                    return CONFIG_REMOVED;
                case 4:
                    return GET_DATA_CALLED;
                case 5:
                    return ADB_DUMP;
                case 6:
                    return CONFIG_RESET;
                case 7:
                    return STATSCOMPANION_DIED;
                case 8:
                    return TERMINATION_SIGNAL_RECEIVED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<DumpReportReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DumpReportReasonVerifier.INSTANCE;
        }

        private static final class DumpReportReasonVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new DumpReportReasonVerifier();

            private DumpReportReasonVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return DumpReportReason.forNumber(i) != null;
            }
        }

        DumpReportReason(int i) {
            this.value = i;
        }
    }

    public enum InvalidConfigReasonEnum implements Internal.EnumLite {
        INVALID_CONFIG_REASON_UNKNOWN(0),
        INVALID_CONFIG_REASON_LOG_SOURCE_ALLOWLIST_EMPTY(1),
        INVALID_CONFIG_REASON_TOO_MANY_LOG_SOURCES(2),
        INVALID_CONFIG_REASON_DEFAULT_PULL_PACKAGES_NOT_IN_MAP(3),
        INVALID_CONFIG_REASON_TOO_MANY_SOURCES_IN_PULL_PACKAGES(4),
        INVALID_CONFIG_REASON_TOO_MANY_METRICS(5),
        INVALID_CONFIG_REASON_TOO_MANY_CONDITIONS(6),
        INVALID_CONFIG_REASON_TOO_MANY_MATCHERS(7),
        INVALID_CONFIG_REASON_TOO_MANY_ALERTS(8),
        INVALID_CONFIG_REASON_PACKAGE_CERT_HASH_SIZE_TOO_LARGE(9),
        INVALID_CONFIG_REASON_NO_REPORT_METRIC_NOT_FOUND(10),
        INVALID_CONFIG_REASON_METRIC_NOT_IN_PREV_CONFIG(11),
        INVALID_CONFIG_REASON_METRIC_UPDATE_STATUS_UNKNOWN(12),
        INVALID_CONFIG_REASON_METRIC_HAS_MULTIPLE_ACTIVATIONS(13),
        INVALID_CONFIG_REASON_METRIC_SLICED_STATE_ATOM_ALLOWED_FROM_ANY_UID(14),
        INVALID_CONFIG_REASON_METRIC_MISSING_ID_OR_WHAT(15),
        INVALID_CONFIG_REASON_METRIC_CONDITIONLINK_NO_CONDITION(16),
        INVALID_CONFIG_REASON_METRIC_STATELINK_NO_STATE(17),
        INVALID_CONFIG_REASON_METRIC_BAD_THRESHOLD(18),
        INVALID_CONFIG_REASON_METRIC_MATCHER_NOT_FOUND(19),
        INVALID_CONFIG_REASON_METRIC_MATCHER_MORE_THAN_ONE_ATOM(20),
        INVALID_CONFIG_REASON_METRIC_CONDITION_NOT_FOUND(21),
        INVALID_CONFIG_REASON_METRIC_CONDITION_LINK_NOT_FOUND(22),
        INVALID_CONFIG_REASON_METRIC_STATE_NOT_FOUND(23),
        INVALID_CONFIG_REASON_METRIC_STATELINKS_NOT_SUBSET_DIM_IN_WHAT(24),
        INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND(25),
        INVALID_CONFIG_REASON_METRIC_DEACTIVATION_MATCHER_NOT_FOUND(26),
        INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND_NEW(27),
        INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND_EXISTING(28),
        INVALID_CONFIG_REASON_METRIC_ACTIVATION_NOT_FOUND_EXISTING(29),
        INVALID_CONFIG_REASON_METRIC_DEACTIVATION_MATCHER_NOT_FOUND_NEW(30),
        INVALID_CONFIG_REASON_METRIC_SERIALIZATION_FAILED(31),
        INVALID_CONFIG_REASON_METRIC_ACTIVATION_SERIALIZATION_FAILED(32),
        INVALID_CONFIG_REASON_DURATION_METRIC_WHAT_NOT_SIMPLE(33),
        INVALID_CONFIG_REASON_DURATION_METRIC_WHAT_NOT_FOUND(34),
        INVALID_CONFIG_REASON_DURATION_METRIC_MISSING_START(35),
        INVALID_CONFIG_REASON_DURATION_METRIC_PRODUCER_INVALID(36),
        INVALID_CONFIG_REASON_DURATION_METRIC_MAX_SPARSE_HAS_SLICE_BY_STATE(37),
        INVALID_CONFIG_REASON_VALUE_METRIC_MISSING_VALUE_FIELD(38),
        INVALID_CONFIG_REASON_VALUE_METRIC_VALUE_FIELD_HAS_POSITION_ALL(39),
        INVALID_CONFIG_REASON_VALUE_METRIC_HAS_INCORRECT_VALUE_FIELD(40),
        INVALID_CONFIG_REASON_KLL_METRIC_MISSING_KLL_FIELD(41),
        INVALID_CONFIG_REASON_KLL_METRIC_KLL_FIELD_HAS_POSITION_ALL(42),
        INVALID_CONFIG_REASON_KLL_METRIC_HAS_INCORRECT_KLL_FIELD(43),
        INVALID_CONFIG_REASON_METRIC_INCORRECT_FIELD_FILTER(44),
        INVALID_CONFIG_REASON_GAUGE_METRIC_TRIGGER_NO_PULL_ATOM(45),
        INVALID_CONFIG_REASON_GAUGE_METRIC_TRIGGER_NO_FIRST_N_SAMPLES(46),
        INVALID_CONFIG_REASON_GAUGE_METRIC_FIRST_N_SAMPLES_WITH_WRONG_EVENT(47),
        INVALID_CONFIG_REASON_MATCHER_NOT_IN_PREV_CONFIG(48),
        INVALID_CONFIG_REASON_MATCHER_UPDATE_STATUS_UNKNOWN(49),
        INVALID_CONFIG_REASON_MATCHER_DUPLICATE(50),
        INVALID_CONFIG_REASON_MATCHER_SERIALIZATION_FAILED(51),
        INVALID_CONFIG_REASON_MATCHER_MALFORMED_CONTENTS_CASE(52),
        INVALID_CONFIG_REASON_MATCHER_TRACKER_NOT_INITIALIZED(53),
        INVALID_CONFIG_REASON_MATCHER_NO_OPERATION(54),
        INVALID_CONFIG_REASON_MATCHER_NOT_OPERATION_IS_NOT_UNARY(55),
        INVALID_CONFIG_REASON_MATCHER_CYCLE(56),
        INVALID_CONFIG_REASON_MATCHER_CHILD_NOT_FOUND(57),
        INVALID_CONFIG_REASON_CONDITION_NOT_IN_PREV_CONFIG(58),
        INVALID_CONFIG_REASON_CONDITION_UPDATE_STATUS_UNKNOWN(59),
        INVALID_CONFIG_REASON_CONDITION_DUPLICATE(60),
        INVALID_CONFIG_REASON_CONDITION_SERIALIZATION_FAILED(61),
        INVALID_CONFIG_REASON_CONDITION_MALFORMED_CONTENTS_CASE(62),
        INVALID_CONFIG_REASON_CONDITION_TRACKER_NOT_INITIALIZED(63),
        INVALID_CONFIG_REASON_CONDITION_NO_OPERATION(64),
        INVALID_CONFIG_REASON_CONDITION_NOT_OPERATION_IS_NOT_UNARY(65),
        INVALID_CONFIG_REASON_CONDITION_CYCLE(66),
        INVALID_CONFIG_REASON_CONDITION_CHILD_NOT_FOUND(67),
        INVALID_CONFIG_REASON_STATE_SERIALIZATION_FAILED(68),
        INVALID_CONFIG_REASON_ALERT_METRIC_NOT_FOUND(69),
        INVALID_CONFIG_REASON_ALERT_THRESHOLD_MISSING(70),
        INVALID_CONFIG_REASON_ALERT_INVALID_TRIGGER_OR_NUM_BUCKETS(71),
        INVALID_CONFIG_REASON_ALERT_CANNOT_ADD_ANOMALY(72),
        INVALID_CONFIG_REASON_ALERT_NOT_IN_PREV_CONFIG(73),
        INVALID_CONFIG_REASON_ALERT_UPDATE_STATUS_UNKNOWN(74),
        INVALID_CONFIG_REASON_ALERT_SERIALIZATION_FAILED(75),
        INVALID_CONFIG_REASON_ALARM_OFFSET_LESS_THAN_OR_EQUAL_ZERO(76),
        INVALID_CONFIG_REASON_ALARM_PERIOD_LESS_THAN_OR_EQUAL_ZERO(77),
        INVALID_CONFIG_REASON_SUBSCRIPTION_SUBSCRIBER_INFO_MISSING(78),
        INVALID_CONFIG_REASON_SUBSCRIPTION_RULE_NOT_FOUND(79),
        INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_INCORRECT_SHARD_COUNT(80),
        INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_MISSING_SAMPLED_FIELD(81),
        INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELD_INCORRECT_SIZE(82),
        INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELDS_NOT_SUBSET_DIM_IN_WHAT(83),
        INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_ENABLED(84),
        INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_SUPPORTED(85),
        INVALID_CONFIG_REASON_METRIC_INCORRECT_SAMPLING_PERCENTAGE(86),
        INVALID_CONFIG_REASON_GAUGE_METRIC_PULLED_WITH_SAMPLING(87),
        INVALID_CONFIG_REASON_MATCHER_NO_VALUE_MATCHER_NOR_STRING_REPLACER(88),
        INVALID_CONFIG_REASON_MATCHER_VALUE_MATCHER_WITH_POSITION_ALL(89),
        INVALID_CONFIG_REASON_MATCHER_INVALID_VALUE_MATCHER_WITH_STRING_REPLACE(90),
        INVALID_CONFIG_REASON_MATCHER_COMBINATION_WITH_STRING_REPLACE(91),
        INVALID_CONFIG_REASON_MATCHER_STRING_REPLACE_WITH_NO_VALUE_MATCHER_WITH_POSITION_ANY(92),
        INVALID_CONFIG_REASON_METRIC_INCORRECT_PULL_PROBABILITY(93),
        INVALID_CONFIG_REASON_GAUGE_METRIC_PUSHED_WITH_PULL_PROBABILITY(94),
        INVALID_CONFIG_REASON_GAUGE_METRIC_RANDOM_ONE_SAMPLE_WITH_PULL_PROBABILITY(95),
        INVALID_CONFIG_REASON_VALUE_METRIC_DEFINES_SINGLE_AND_MULTIPLE_AGG_TYPES(96),
        INVALID_CONFIG_REASON_VALUE_METRIC_AGG_TYPES_DNE_VALUE_FIELDS_SIZE(97),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_COUNT_DNE_HIST_BIN_CONFIGS_COUNT(98),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_BIN_CONFIG_ID(99),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_UNKNOWN_BINNING_STRATEGY(100),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_GENERATED_BINS_ARGS(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_GENERATED_BINS_ARGS_VALUE),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX_VALUE),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_FEW_BINS(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_FEW_BINS_VALUE),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_MANY_BINS(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_MANY_BINS_VALUE),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_EXPLICIT_BINS_NOT_STRICTLY_ORDERED(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_EXPLICIT_BINS_NOT_STRICTLY_ORDERED_VALUE),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_WITH_UPLOAD_THRESHOLD(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_WITH_UPLOAD_THRESHOLD_VALUE),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_INVALID_VALUE_DIRECTION(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_INVALID_VALUE_DIRECTION_VALUE),
        INVALID_CONFIG_REASON_VALUE_METRIC_HIST_CLIENT_AGGREGATED_NO_POSITION_ALL(INVALID_CONFIG_REASON_VALUE_METRIC_HIST_CLIENT_AGGREGATED_NO_POSITION_ALL_VALUE),
        INVALID_CONFIG_REASON_UID_FIELDS_WITH_POSITION_ANY(INVALID_CONFIG_REASON_UID_FIELDS_WITH_POSITION_ANY_VALUE);

        public static final int INVALID_CONFIG_REASON_ALARM_OFFSET_LESS_THAN_OR_EQUAL_ZERO_VALUE = 76;
        public static final int INVALID_CONFIG_REASON_ALARM_PERIOD_LESS_THAN_OR_EQUAL_ZERO_VALUE = 77;
        public static final int INVALID_CONFIG_REASON_ALERT_CANNOT_ADD_ANOMALY_VALUE = 72;
        public static final int INVALID_CONFIG_REASON_ALERT_INVALID_TRIGGER_OR_NUM_BUCKETS_VALUE = 71;
        public static final int INVALID_CONFIG_REASON_ALERT_METRIC_NOT_FOUND_VALUE = 69;
        public static final int INVALID_CONFIG_REASON_ALERT_NOT_IN_PREV_CONFIG_VALUE = 73;
        public static final int INVALID_CONFIG_REASON_ALERT_SERIALIZATION_FAILED_VALUE = 75;
        public static final int INVALID_CONFIG_REASON_ALERT_THRESHOLD_MISSING_VALUE = 70;
        public static final int INVALID_CONFIG_REASON_ALERT_UPDATE_STATUS_UNKNOWN_VALUE = 74;
        public static final int INVALID_CONFIG_REASON_CONDITION_CHILD_NOT_FOUND_VALUE = 67;
        public static final int INVALID_CONFIG_REASON_CONDITION_CYCLE_VALUE = 66;
        public static final int INVALID_CONFIG_REASON_CONDITION_DUPLICATE_VALUE = 60;
        public static final int INVALID_CONFIG_REASON_CONDITION_MALFORMED_CONTENTS_CASE_VALUE = 62;
        public static final int INVALID_CONFIG_REASON_CONDITION_NOT_IN_PREV_CONFIG_VALUE = 58;
        public static final int INVALID_CONFIG_REASON_CONDITION_NOT_OPERATION_IS_NOT_UNARY_VALUE = 65;
        public static final int INVALID_CONFIG_REASON_CONDITION_NO_OPERATION_VALUE = 64;
        public static final int INVALID_CONFIG_REASON_CONDITION_SERIALIZATION_FAILED_VALUE = 61;
        public static final int INVALID_CONFIG_REASON_CONDITION_TRACKER_NOT_INITIALIZED_VALUE = 63;
        public static final int INVALID_CONFIG_REASON_CONDITION_UPDATE_STATUS_UNKNOWN_VALUE = 59;
        public static final int INVALID_CONFIG_REASON_DEFAULT_PULL_PACKAGES_NOT_IN_MAP_VALUE = 3;
        public static final int INVALID_CONFIG_REASON_DURATION_METRIC_MAX_SPARSE_HAS_SLICE_BY_STATE_VALUE = 37;
        public static final int INVALID_CONFIG_REASON_DURATION_METRIC_MISSING_START_VALUE = 35;
        public static final int INVALID_CONFIG_REASON_DURATION_METRIC_PRODUCER_INVALID_VALUE = 36;
        public static final int INVALID_CONFIG_REASON_DURATION_METRIC_WHAT_NOT_FOUND_VALUE = 34;
        public static final int INVALID_CONFIG_REASON_DURATION_METRIC_WHAT_NOT_SIMPLE_VALUE = 33;

        @Deprecated
        public static final int INVALID_CONFIG_REASON_GAUGE_METRIC_FIRST_N_SAMPLES_WITH_WRONG_EVENT_VALUE = 47;
        public static final int INVALID_CONFIG_REASON_GAUGE_METRIC_PULLED_WITH_SAMPLING_VALUE = 87;
        public static final int INVALID_CONFIG_REASON_GAUGE_METRIC_PUSHED_WITH_PULL_PROBABILITY_VALUE = 94;
        public static final int INVALID_CONFIG_REASON_GAUGE_METRIC_RANDOM_ONE_SAMPLE_WITH_PULL_PROBABILITY_VALUE = 95;
        public static final int INVALID_CONFIG_REASON_GAUGE_METRIC_TRIGGER_NO_FIRST_N_SAMPLES_VALUE = 46;
        public static final int INVALID_CONFIG_REASON_GAUGE_METRIC_TRIGGER_NO_PULL_ATOM_VALUE = 45;
        public static final int INVALID_CONFIG_REASON_KLL_METRIC_HAS_INCORRECT_KLL_FIELD_VALUE = 43;
        public static final int INVALID_CONFIG_REASON_KLL_METRIC_KLL_FIELD_HAS_POSITION_ALL_VALUE = 42;
        public static final int INVALID_CONFIG_REASON_KLL_METRIC_MISSING_KLL_FIELD_VALUE = 41;
        public static final int INVALID_CONFIG_REASON_LOG_SOURCE_ALLOWLIST_EMPTY_VALUE = 1;
        public static final int INVALID_CONFIG_REASON_MATCHER_CHILD_NOT_FOUND_VALUE = 57;
        public static final int INVALID_CONFIG_REASON_MATCHER_COMBINATION_WITH_STRING_REPLACE_VALUE = 91;
        public static final int INVALID_CONFIG_REASON_MATCHER_CYCLE_VALUE = 56;
        public static final int INVALID_CONFIG_REASON_MATCHER_DUPLICATE_VALUE = 50;
        public static final int INVALID_CONFIG_REASON_MATCHER_INVALID_VALUE_MATCHER_WITH_STRING_REPLACE_VALUE = 90;
        public static final int INVALID_CONFIG_REASON_MATCHER_MALFORMED_CONTENTS_CASE_VALUE = 52;
        public static final int INVALID_CONFIG_REASON_MATCHER_NOT_IN_PREV_CONFIG_VALUE = 48;
        public static final int INVALID_CONFIG_REASON_MATCHER_NOT_OPERATION_IS_NOT_UNARY_VALUE = 55;
        public static final int INVALID_CONFIG_REASON_MATCHER_NO_OPERATION_VALUE = 54;
        public static final int INVALID_CONFIG_REASON_MATCHER_NO_VALUE_MATCHER_NOR_STRING_REPLACER_VALUE = 88;
        public static final int INVALID_CONFIG_REASON_MATCHER_SERIALIZATION_FAILED_VALUE = 51;
        public static final int INVALID_CONFIG_REASON_MATCHER_STRING_REPLACE_WITH_NO_VALUE_MATCHER_WITH_POSITION_ANY_VALUE = 92;
        public static final int INVALID_CONFIG_REASON_MATCHER_TRACKER_NOT_INITIALIZED_VALUE = 53;
        public static final int INVALID_CONFIG_REASON_MATCHER_UPDATE_STATUS_UNKNOWN_VALUE = 49;
        public static final int INVALID_CONFIG_REASON_MATCHER_VALUE_MATCHER_WITH_POSITION_ALL_VALUE = 89;
        public static final int INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND_EXISTING_VALUE = 28;
        public static final int INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND_NEW_VALUE = 27;
        public static final int INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND_VALUE = 25;
        public static final int INVALID_CONFIG_REASON_METRIC_ACTIVATION_NOT_FOUND_EXISTING_VALUE = 29;
        public static final int INVALID_CONFIG_REASON_METRIC_ACTIVATION_SERIALIZATION_FAILED_VALUE = 32;
        public static final int INVALID_CONFIG_REASON_METRIC_BAD_THRESHOLD_VALUE = 18;
        public static final int INVALID_CONFIG_REASON_METRIC_CONDITIONLINK_NO_CONDITION_VALUE = 16;
        public static final int INVALID_CONFIG_REASON_METRIC_CONDITION_LINK_NOT_FOUND_VALUE = 22;
        public static final int INVALID_CONFIG_REASON_METRIC_CONDITION_NOT_FOUND_VALUE = 21;
        public static final int INVALID_CONFIG_REASON_METRIC_DEACTIVATION_MATCHER_NOT_FOUND_NEW_VALUE = 30;
        public static final int INVALID_CONFIG_REASON_METRIC_DEACTIVATION_MATCHER_NOT_FOUND_VALUE = 26;
        public static final int INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_INCORRECT_SHARD_COUNT_VALUE = 80;
        public static final int INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_MISSING_SAMPLED_FIELD_VALUE = 81;
        public static final int INVALID_CONFIG_REASON_METRIC_HAS_MULTIPLE_ACTIVATIONS_VALUE = 13;
        public static final int INVALID_CONFIG_REASON_METRIC_INCORRECT_FIELD_FILTER_VALUE = 44;
        public static final int INVALID_CONFIG_REASON_METRIC_INCORRECT_PULL_PROBABILITY_VALUE = 93;
        public static final int INVALID_CONFIG_REASON_METRIC_INCORRECT_SAMPLING_PERCENTAGE_VALUE = 86;
        public static final int INVALID_CONFIG_REASON_METRIC_MATCHER_MORE_THAN_ONE_ATOM_VALUE = 20;
        public static final int INVALID_CONFIG_REASON_METRIC_MATCHER_NOT_FOUND_VALUE = 19;
        public static final int INVALID_CONFIG_REASON_METRIC_MISSING_ID_OR_WHAT_VALUE = 15;
        public static final int INVALID_CONFIG_REASON_METRIC_NOT_IN_PREV_CONFIG_VALUE = 11;
        public static final int INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELDS_NOT_SUBSET_DIM_IN_WHAT_VALUE = 83;
        public static final int INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELD_INCORRECT_SIZE_VALUE = 82;
        public static final int INVALID_CONFIG_REASON_METRIC_SERIALIZATION_FAILED_VALUE = 31;
        public static final int INVALID_CONFIG_REASON_METRIC_SLICED_STATE_ATOM_ALLOWED_FROM_ANY_UID_VALUE = 14;
        public static final int INVALID_CONFIG_REASON_METRIC_STATELINKS_NOT_SUBSET_DIM_IN_WHAT_VALUE = 24;
        public static final int INVALID_CONFIG_REASON_METRIC_STATELINK_NO_STATE_VALUE = 17;
        public static final int INVALID_CONFIG_REASON_METRIC_STATE_NOT_FOUND_VALUE = 23;
        public static final int INVALID_CONFIG_REASON_METRIC_UPDATE_STATUS_UNKNOWN_VALUE = 12;
        public static final int INVALID_CONFIG_REASON_NO_REPORT_METRIC_NOT_FOUND_VALUE = 10;
        public static final int INVALID_CONFIG_REASON_PACKAGE_CERT_HASH_SIZE_TOO_LARGE_VALUE = 9;
        public static final int INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_ENABLED_VALUE = 84;
        public static final int INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_SUPPORTED_VALUE = 85;
        public static final int INVALID_CONFIG_REASON_STATE_SERIALIZATION_FAILED_VALUE = 68;
        public static final int INVALID_CONFIG_REASON_SUBSCRIPTION_RULE_NOT_FOUND_VALUE = 79;
        public static final int INVALID_CONFIG_REASON_SUBSCRIPTION_SUBSCRIBER_INFO_MISSING_VALUE = 78;
        public static final int INVALID_CONFIG_REASON_TOO_MANY_ALERTS_VALUE = 8;
        public static final int INVALID_CONFIG_REASON_TOO_MANY_CONDITIONS_VALUE = 6;
        public static final int INVALID_CONFIG_REASON_TOO_MANY_LOG_SOURCES_VALUE = 2;
        public static final int INVALID_CONFIG_REASON_TOO_MANY_MATCHERS_VALUE = 7;
        public static final int INVALID_CONFIG_REASON_TOO_MANY_METRICS_VALUE = 5;
        public static final int INVALID_CONFIG_REASON_TOO_MANY_SOURCES_IN_PULL_PACKAGES_VALUE = 4;
        public static final int INVALID_CONFIG_REASON_UID_FIELDS_WITH_POSITION_ANY_VALUE = 109;
        public static final int INVALID_CONFIG_REASON_UNKNOWN_VALUE = 0;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_AGG_TYPES_DNE_VALUE_FIELDS_SIZE_VALUE = 97;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_DEFINES_SINGLE_AND_MULTIPLE_AGG_TYPES_VALUE = 96;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HAS_INCORRECT_VALUE_FIELD_VALUE = 40;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_CLIENT_AGGREGATED_NO_POSITION_ALL_VALUE = 108;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_COUNT_DNE_HIST_BIN_CONFIGS_COUNT_VALUE = 98;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_EXPLICIT_BINS_NOT_STRICTLY_ORDERED_VALUE = 105;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX_VALUE = 102;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_INVALID_VALUE_DIRECTION_VALUE = 107;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_BIN_CONFIG_ID_VALUE = 99;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_GENERATED_BINS_ARGS_VALUE = 101;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_FEW_BINS_VALUE = 103;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_MANY_BINS_VALUE = 104;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_UNKNOWN_BINNING_STRATEGY_VALUE = 100;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_HIST_WITH_UPLOAD_THRESHOLD_VALUE = 106;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_MISSING_VALUE_FIELD_VALUE = 38;
        public static final int INVALID_CONFIG_REASON_VALUE_METRIC_VALUE_FIELD_HAS_POSITION_ALL_VALUE = 39;
        private static final Internal.EnumLiteMap<InvalidConfigReasonEnum> internalValueMap = new Internal.EnumLiteMap<InvalidConfigReasonEnum>() { // from class: stepos.com.android.os.StatsLogEnums.InvalidConfigReasonEnum.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public InvalidConfigReasonEnum findValueByNumber(int i) {
                return InvalidConfigReasonEnum.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static InvalidConfigReasonEnum valueOf(int i) {
            return forNumber(i);
        }

        public static InvalidConfigReasonEnum forNumber(int i) {
            switch (i) {
                case 0:
                    return INVALID_CONFIG_REASON_UNKNOWN;
                case 1:
                    return INVALID_CONFIG_REASON_LOG_SOURCE_ALLOWLIST_EMPTY;
                case 2:
                    return INVALID_CONFIG_REASON_TOO_MANY_LOG_SOURCES;
                case 3:
                    return INVALID_CONFIG_REASON_DEFAULT_PULL_PACKAGES_NOT_IN_MAP;
                case 4:
                    return INVALID_CONFIG_REASON_TOO_MANY_SOURCES_IN_PULL_PACKAGES;
                case 5:
                    return INVALID_CONFIG_REASON_TOO_MANY_METRICS;
                case 6:
                    return INVALID_CONFIG_REASON_TOO_MANY_CONDITIONS;
                case 7:
                    return INVALID_CONFIG_REASON_TOO_MANY_MATCHERS;
                case 8:
                    return INVALID_CONFIG_REASON_TOO_MANY_ALERTS;
                case 9:
                    return INVALID_CONFIG_REASON_PACKAGE_CERT_HASH_SIZE_TOO_LARGE;
                case 10:
                    return INVALID_CONFIG_REASON_NO_REPORT_METRIC_NOT_FOUND;
                case 11:
                    return INVALID_CONFIG_REASON_METRIC_NOT_IN_PREV_CONFIG;
                case 12:
                    return INVALID_CONFIG_REASON_METRIC_UPDATE_STATUS_UNKNOWN;
                case 13:
                    return INVALID_CONFIG_REASON_METRIC_HAS_MULTIPLE_ACTIVATIONS;
                case 14:
                    return INVALID_CONFIG_REASON_METRIC_SLICED_STATE_ATOM_ALLOWED_FROM_ANY_UID;
                case 15:
                    return INVALID_CONFIG_REASON_METRIC_MISSING_ID_OR_WHAT;
                case 16:
                    return INVALID_CONFIG_REASON_METRIC_CONDITIONLINK_NO_CONDITION;
                case 17:
                    return INVALID_CONFIG_REASON_METRIC_STATELINK_NO_STATE;
                case 18:
                    return INVALID_CONFIG_REASON_METRIC_BAD_THRESHOLD;
                case 19:
                    return INVALID_CONFIG_REASON_METRIC_MATCHER_NOT_FOUND;
                case 20:
                    return INVALID_CONFIG_REASON_METRIC_MATCHER_MORE_THAN_ONE_ATOM;
                case 21:
                    return INVALID_CONFIG_REASON_METRIC_CONDITION_NOT_FOUND;
                case 22:
                    return INVALID_CONFIG_REASON_METRIC_CONDITION_LINK_NOT_FOUND;
                case 23:
                    return INVALID_CONFIG_REASON_METRIC_STATE_NOT_FOUND;
                case 24:
                    return INVALID_CONFIG_REASON_METRIC_STATELINKS_NOT_SUBSET_DIM_IN_WHAT;
                case 25:
                    return INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND;
                case 26:
                    return INVALID_CONFIG_REASON_METRIC_DEACTIVATION_MATCHER_NOT_FOUND;
                case 27:
                    return INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND_NEW;
                case 28:
                    return INVALID_CONFIG_REASON_METRIC_ACTIVATION_MATCHER_NOT_FOUND_EXISTING;
                case 29:
                    return INVALID_CONFIG_REASON_METRIC_ACTIVATION_NOT_FOUND_EXISTING;
                case 30:
                    return INVALID_CONFIG_REASON_METRIC_DEACTIVATION_MATCHER_NOT_FOUND_NEW;
                case 31:
                    return INVALID_CONFIG_REASON_METRIC_SERIALIZATION_FAILED;
                case 32:
                    return INVALID_CONFIG_REASON_METRIC_ACTIVATION_SERIALIZATION_FAILED;
                case 33:
                    return INVALID_CONFIG_REASON_DURATION_METRIC_WHAT_NOT_SIMPLE;
                case 34:
                    return INVALID_CONFIG_REASON_DURATION_METRIC_WHAT_NOT_FOUND;
                case 35:
                    return INVALID_CONFIG_REASON_DURATION_METRIC_MISSING_START;
                case 36:
                    return INVALID_CONFIG_REASON_DURATION_METRIC_PRODUCER_INVALID;
                case 37:
                    return INVALID_CONFIG_REASON_DURATION_METRIC_MAX_SPARSE_HAS_SLICE_BY_STATE;
                case 38:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_MISSING_VALUE_FIELD;
                case 39:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_VALUE_FIELD_HAS_POSITION_ALL;
                case 40:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HAS_INCORRECT_VALUE_FIELD;
                case 41:
                    return INVALID_CONFIG_REASON_KLL_METRIC_MISSING_KLL_FIELD;
                case 42:
                    return INVALID_CONFIG_REASON_KLL_METRIC_KLL_FIELD_HAS_POSITION_ALL;
                case INVALID_CONFIG_REASON_KLL_METRIC_HAS_INCORRECT_KLL_FIELD_VALUE:
                    return INVALID_CONFIG_REASON_KLL_METRIC_HAS_INCORRECT_KLL_FIELD;
                case 44:
                    return INVALID_CONFIG_REASON_METRIC_INCORRECT_FIELD_FILTER;
                case 45:
                    return INVALID_CONFIG_REASON_GAUGE_METRIC_TRIGGER_NO_PULL_ATOM;
                case INVALID_CONFIG_REASON_GAUGE_METRIC_TRIGGER_NO_FIRST_N_SAMPLES_VALUE:
                    return INVALID_CONFIG_REASON_GAUGE_METRIC_TRIGGER_NO_FIRST_N_SAMPLES;
                case INVALID_CONFIG_REASON_GAUGE_METRIC_FIRST_N_SAMPLES_WITH_WRONG_EVENT_VALUE:
                    return INVALID_CONFIG_REASON_GAUGE_METRIC_FIRST_N_SAMPLES_WITH_WRONG_EVENT;
                case INVALID_CONFIG_REASON_MATCHER_NOT_IN_PREV_CONFIG_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_NOT_IN_PREV_CONFIG;
                case INVALID_CONFIG_REASON_MATCHER_UPDATE_STATUS_UNKNOWN_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_UPDATE_STATUS_UNKNOWN;
                case INVALID_CONFIG_REASON_MATCHER_DUPLICATE_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_DUPLICATE;
                case INVALID_CONFIG_REASON_MATCHER_SERIALIZATION_FAILED_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_SERIALIZATION_FAILED;
                case INVALID_CONFIG_REASON_MATCHER_MALFORMED_CONTENTS_CASE_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_MALFORMED_CONTENTS_CASE;
                case INVALID_CONFIG_REASON_MATCHER_TRACKER_NOT_INITIALIZED_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_TRACKER_NOT_INITIALIZED;
                case INVALID_CONFIG_REASON_MATCHER_NO_OPERATION_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_NO_OPERATION;
                case INVALID_CONFIG_REASON_MATCHER_NOT_OPERATION_IS_NOT_UNARY_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_NOT_OPERATION_IS_NOT_UNARY;
                case INVALID_CONFIG_REASON_MATCHER_CYCLE_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_CYCLE;
                case INVALID_CONFIG_REASON_MATCHER_CHILD_NOT_FOUND_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_CHILD_NOT_FOUND;
                case INVALID_CONFIG_REASON_CONDITION_NOT_IN_PREV_CONFIG_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_NOT_IN_PREV_CONFIG;
                case INVALID_CONFIG_REASON_CONDITION_UPDATE_STATUS_UNKNOWN_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_UPDATE_STATUS_UNKNOWN;
                case INVALID_CONFIG_REASON_CONDITION_DUPLICATE_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_DUPLICATE;
                case INVALID_CONFIG_REASON_CONDITION_SERIALIZATION_FAILED_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_SERIALIZATION_FAILED;
                case INVALID_CONFIG_REASON_CONDITION_MALFORMED_CONTENTS_CASE_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_MALFORMED_CONTENTS_CASE;
                case INVALID_CONFIG_REASON_CONDITION_TRACKER_NOT_INITIALIZED_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_TRACKER_NOT_INITIALIZED;
                case 64:
                    return INVALID_CONFIG_REASON_CONDITION_NO_OPERATION;
                case INVALID_CONFIG_REASON_CONDITION_NOT_OPERATION_IS_NOT_UNARY_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_NOT_OPERATION_IS_NOT_UNARY;
                case INVALID_CONFIG_REASON_CONDITION_CYCLE_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_CYCLE;
                case INVALID_CONFIG_REASON_CONDITION_CHILD_NOT_FOUND_VALUE:
                    return INVALID_CONFIG_REASON_CONDITION_CHILD_NOT_FOUND;
                case INVALID_CONFIG_REASON_STATE_SERIALIZATION_FAILED_VALUE:
                    return INVALID_CONFIG_REASON_STATE_SERIALIZATION_FAILED;
                case INVALID_CONFIG_REASON_ALERT_METRIC_NOT_FOUND_VALUE:
                    return INVALID_CONFIG_REASON_ALERT_METRIC_NOT_FOUND;
                case INVALID_CONFIG_REASON_ALERT_THRESHOLD_MISSING_VALUE:
                    return INVALID_CONFIG_REASON_ALERT_THRESHOLD_MISSING;
                case INVALID_CONFIG_REASON_ALERT_INVALID_TRIGGER_OR_NUM_BUCKETS_VALUE:
                    return INVALID_CONFIG_REASON_ALERT_INVALID_TRIGGER_OR_NUM_BUCKETS;
                case INVALID_CONFIG_REASON_ALERT_CANNOT_ADD_ANOMALY_VALUE:
                    return INVALID_CONFIG_REASON_ALERT_CANNOT_ADD_ANOMALY;
                case INVALID_CONFIG_REASON_ALERT_NOT_IN_PREV_CONFIG_VALUE:
                    return INVALID_CONFIG_REASON_ALERT_NOT_IN_PREV_CONFIG;
                case INVALID_CONFIG_REASON_ALERT_UPDATE_STATUS_UNKNOWN_VALUE:
                    return INVALID_CONFIG_REASON_ALERT_UPDATE_STATUS_UNKNOWN;
                case INVALID_CONFIG_REASON_ALERT_SERIALIZATION_FAILED_VALUE:
                    return INVALID_CONFIG_REASON_ALERT_SERIALIZATION_FAILED;
                case 76:
                    return INVALID_CONFIG_REASON_ALARM_OFFSET_LESS_THAN_OR_EQUAL_ZERO;
                case INVALID_CONFIG_REASON_ALARM_PERIOD_LESS_THAN_OR_EQUAL_ZERO_VALUE:
                    return INVALID_CONFIG_REASON_ALARM_PERIOD_LESS_THAN_OR_EQUAL_ZERO;
                case 78:
                    return INVALID_CONFIG_REASON_SUBSCRIPTION_SUBSCRIBER_INFO_MISSING;
                case 79:
                    return INVALID_CONFIG_REASON_SUBSCRIPTION_RULE_NOT_FOUND;
                case INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_INCORRECT_SHARD_COUNT_VALUE:
                    return INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_INCORRECT_SHARD_COUNT;
                case INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_MISSING_SAMPLED_FIELD_VALUE:
                    return INVALID_CONFIG_REASON_METRIC_DIMENSIONAL_SAMPLING_INFO_MISSING_SAMPLED_FIELD;
                case INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELD_INCORRECT_SIZE_VALUE:
                    return INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELD_INCORRECT_SIZE;
                case INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELDS_NOT_SUBSET_DIM_IN_WHAT_VALUE:
                    return INVALID_CONFIG_REASON_METRIC_SAMPLED_FIELDS_NOT_SUBSET_DIM_IN_WHAT;
                case INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_ENABLED_VALUE:
                    return INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_ENABLED;
                case INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_SUPPORTED_VALUE:
                    return INVALID_CONFIG_REASON_RESTRICTED_METRIC_NOT_SUPPORTED;
                case INVALID_CONFIG_REASON_METRIC_INCORRECT_SAMPLING_PERCENTAGE_VALUE:
                    return INVALID_CONFIG_REASON_METRIC_INCORRECT_SAMPLING_PERCENTAGE;
                case INVALID_CONFIG_REASON_GAUGE_METRIC_PULLED_WITH_SAMPLING_VALUE:
                    return INVALID_CONFIG_REASON_GAUGE_METRIC_PULLED_WITH_SAMPLING;
                case INVALID_CONFIG_REASON_MATCHER_NO_VALUE_MATCHER_NOR_STRING_REPLACER_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_NO_VALUE_MATCHER_NOR_STRING_REPLACER;
                case INVALID_CONFIG_REASON_MATCHER_VALUE_MATCHER_WITH_POSITION_ALL_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_VALUE_MATCHER_WITH_POSITION_ALL;
                case INVALID_CONFIG_REASON_MATCHER_INVALID_VALUE_MATCHER_WITH_STRING_REPLACE_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_INVALID_VALUE_MATCHER_WITH_STRING_REPLACE;
                case INVALID_CONFIG_REASON_MATCHER_COMBINATION_WITH_STRING_REPLACE_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_COMBINATION_WITH_STRING_REPLACE;
                case INVALID_CONFIG_REASON_MATCHER_STRING_REPLACE_WITH_NO_VALUE_MATCHER_WITH_POSITION_ANY_VALUE:
                    return INVALID_CONFIG_REASON_MATCHER_STRING_REPLACE_WITH_NO_VALUE_MATCHER_WITH_POSITION_ANY;
                case INVALID_CONFIG_REASON_METRIC_INCORRECT_PULL_PROBABILITY_VALUE:
                    return INVALID_CONFIG_REASON_METRIC_INCORRECT_PULL_PROBABILITY;
                case INVALID_CONFIG_REASON_GAUGE_METRIC_PUSHED_WITH_PULL_PROBABILITY_VALUE:
                    return INVALID_CONFIG_REASON_GAUGE_METRIC_PUSHED_WITH_PULL_PROBABILITY;
                case INVALID_CONFIG_REASON_GAUGE_METRIC_RANDOM_ONE_SAMPLE_WITH_PULL_PROBABILITY_VALUE:
                    return INVALID_CONFIG_REASON_GAUGE_METRIC_RANDOM_ONE_SAMPLE_WITH_PULL_PROBABILITY;
                case INVALID_CONFIG_REASON_VALUE_METRIC_DEFINES_SINGLE_AND_MULTIPLE_AGG_TYPES_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_DEFINES_SINGLE_AND_MULTIPLE_AGG_TYPES;
                case INVALID_CONFIG_REASON_VALUE_METRIC_AGG_TYPES_DNE_VALUE_FIELDS_SIZE_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_AGG_TYPES_DNE_VALUE_FIELDS_SIZE;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_COUNT_DNE_HIST_BIN_CONFIGS_COUNT_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_COUNT_DNE_HIST_BIN_CONFIGS_COUNT;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_BIN_CONFIG_ID_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_BIN_CONFIG_ID;
                case 100:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_UNKNOWN_BINNING_STRATEGY;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_GENERATED_BINS_ARGS_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_MISSING_GENERATED_BINS_ARGS;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_FEW_BINS_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_FEW_BINS;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_MANY_BINS_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_TOO_MANY_BINS;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_EXPLICIT_BINS_NOT_STRICTLY_ORDERED_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_EXPLICIT_BINS_NOT_STRICTLY_ORDERED;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_WITH_UPLOAD_THRESHOLD_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_WITH_UPLOAD_THRESHOLD;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_INVALID_VALUE_DIRECTION_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_INVALID_VALUE_DIRECTION;
                case INVALID_CONFIG_REASON_VALUE_METRIC_HIST_CLIENT_AGGREGATED_NO_POSITION_ALL_VALUE:
                    return INVALID_CONFIG_REASON_VALUE_METRIC_HIST_CLIENT_AGGREGATED_NO_POSITION_ALL;
                case INVALID_CONFIG_REASON_UID_FIELDS_WITH_POSITION_ANY_VALUE:
                    return INVALID_CONFIG_REASON_UID_FIELDS_WITH_POSITION_ANY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<InvalidConfigReasonEnum> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return InvalidConfigReasonEnumVerifier.INSTANCE;
        }

        private static final class InvalidConfigReasonEnumVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new InvalidConfigReasonEnumVerifier();

            private InvalidConfigReasonEnumVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return InvalidConfigReasonEnum.forNumber(i) != null;
            }
        }

        InvalidConfigReasonEnum(int i) {
            this.value = i;
        }
    }

    public enum InvalidQueryReason implements Internal.EnumLite {
        UNKNOWN_REASON(0),
        FLAG_DISABLED(1),
        UNSUPPORTED_SQLITE_VERSION(2),
        AMBIGUOUS_CONFIG_KEY(3),
        CONFIG_KEY_NOT_FOUND(4),
        CONFIG_KEY_WITH_UNMATCHED_DELEGATE(5),
        QUERY_FAILURE(6),
        INCONSISTENT_ROW_SIZE(7),
        NULL_CALLBACK(8);

        public static final int AMBIGUOUS_CONFIG_KEY_VALUE = 3;
        public static final int CONFIG_KEY_NOT_FOUND_VALUE = 4;
        public static final int CONFIG_KEY_WITH_UNMATCHED_DELEGATE_VALUE = 5;
        public static final int FLAG_DISABLED_VALUE = 1;
        public static final int INCONSISTENT_ROW_SIZE_VALUE = 7;
        public static final int NULL_CALLBACK_VALUE = 8;
        public static final int QUERY_FAILURE_VALUE = 6;
        public static final int UNKNOWN_REASON_VALUE = 0;
        public static final int UNSUPPORTED_SQLITE_VERSION_VALUE = 2;
        private static final Internal.EnumLiteMap<InvalidQueryReason> internalValueMap = new Internal.EnumLiteMap<InvalidQueryReason>() { // from class: stepos.com.android.os.StatsLogEnums.InvalidQueryReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public InvalidQueryReason findValueByNumber(int i) {
                return InvalidQueryReason.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static InvalidQueryReason valueOf(int i) {
            return forNumber(i);
        }

        public static InvalidQueryReason forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_REASON;
                case 1:
                    return FLAG_DISABLED;
                case 2:
                    return UNSUPPORTED_SQLITE_VERSION;
                case 3:
                    return AMBIGUOUS_CONFIG_KEY;
                case 4:
                    return CONFIG_KEY_NOT_FOUND;
                case 5:
                    return CONFIG_KEY_WITH_UNMATCHED_DELEGATE;
                case 6:
                    return QUERY_FAILURE;
                case 7:
                    return INCONSISTENT_ROW_SIZE;
                case 8:
                    return NULL_CALLBACK;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<InvalidQueryReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return InvalidQueryReasonVerifier.INSTANCE;
        }

        private static final class InvalidQueryReasonVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new InvalidQueryReasonVerifier();

            private InvalidQueryReasonVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return InvalidQueryReason.forNumber(i) != null;
            }
        }

        InvalidQueryReason(int i) {
            this.value = i;
        }
    }

    public enum CounterType implements Internal.EnumLite {
        COUNTER_TYPE_UNKNOWN(0),
        COUNTER_TYPE_ERROR_ATOM_FILTER_SKIPPED(1);

        public static final int COUNTER_TYPE_ERROR_ATOM_FILTER_SKIPPED_VALUE = 1;
        public static final int COUNTER_TYPE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<CounterType> internalValueMap = new Internal.EnumLiteMap<CounterType>() { // from class: stepos.com.android.os.StatsLogEnums.CounterType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CounterType findValueByNumber(int i) {
                return CounterType.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static CounterType valueOf(int i) {
            return forNumber(i);
        }

        public static CounterType forNumber(int i) {
            if (i == 0) {
                return COUNTER_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return COUNTER_TYPE_ERROR_ATOM_FILTER_SKIPPED;
        }

        public static Internal.EnumLiteMap<CounterType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CounterTypeVerifier.INSTANCE;
        }

        private static final class CounterTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new CounterTypeVerifier();

            private CounterTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return CounterType.forNumber(i) != null;
            }
        }

        CounterType(int i) {
            this.value = i;
        }
    }
}
