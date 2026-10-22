package com.obric.capabilitykit.common;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorCode {
    public static final int ACTION_EXECUTE_ERROR = -2003;
    public static final int ACTION_TIMEOUT_ERROR = 4;
    public static final int APPLETS_ERROR = 101;
    public static final int APP_NOT_EXIST_ERROR = 100;
    public static final int APP_VERSION_TOO_LOW = 106;
    public static final int AUTHENTICATION_ERROR = 111;
    public static final Companion Companion = null;
    public static final int DEVICE_LOCK_ERROR = 112;
    public static final int DISPATCH_ERROR = -2000;
    public static final int ENTITY_NOT_EXIST_ERROR = 200;
    public static final int EXECUTE_ACTION_ERROR = 102;
    public static final int GENERAL_ERROR = 1;
    public static final int INTENT_EXECUTE_ERROR = -2002;
    public static final int INTENT_NO_IMPL_ERROR = -2005;
    public static final int JOB_PARSE_ERROR = -2001;
    public static final int NETWORK_ERROR = 2;
    public static final int NOT_SUPPORTED = 999;
    public static final int NO_ERROR = 0;
    public static final int NO_LOGIN = 202;
    public static final int PARAMETER_ERROR = 103;
    public static final int PARAMS_MISS_ERROR = -2004;
    public static final int PERMISSION_ERROR = 113;
    public static final int PRIVACY_STATEMENT_NOT_AGREE_ERROR = 201;
    public static final int REGISTER_ERROR = 104;
    public static final int RESULT_TIMEOUT_ERROR = 5;
    public static final int UNREGISTER_ERROR = 105;

    public static final class AudioControl {
        public static final Companion Companion = null;
        public static final int EXISTED_PLAYING_SESSION_ERROR = 3002;
        public static final int NO_CONTROLLABLE_SESSION_ERROR = 3001;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public AudioControl() {
        }
    }

    public static final class AutoGui {
        public static final int AUTO_GUI_QUEUE_HAS_RUNNING_TASK_ERROR = 5001;
        public static final int AUTO_GUI_SYSTEM_ACCOUNT_NOT_LOGIN = 5002;
        public static final Companion Companion = null;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public AutoGui() {
        }
    }

    public static final class Clock {
        public static final Companion Companion = null;
        public static final int TIMER_NOT_EXIST_ERROR = 2001;
        public static final int UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR = 2003;
        public static final int UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR = 2002;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Clock() {
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(d.h.b.h r1) {
            this();
        }
    }

    public static final class Contacts {
        public static final int CONTACT_NO_PHONE_NUMBER_ERROR = 1001;
        public static final Companion Companion = null;
        public static final int PHONE_NO_PAGE_ERROR = 1100;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Contacts() {
        }
    }

    public static final class EventTask {
        public static final int ADD_TASK_ERROR = 8035;
        public static final int BATTERY_CHARGED_TO_PARAMS_EMPTY = 8026;
        public static final int BATTERY_DISCHARGED_TO_PARAMS_EMPTY = 8027;
        public static final int BLUETOOTH_CANDIDATE_INFO_EMPTY = 8038;
        public static final int BLUETOOTH_INFO_EMPTY = 8052;
        public static final int BLUETOOTH_NO_PERMISSION = 8054;
        public static final int BLUETOOTH_PARAMS_EMPTY = 8017;
        public static final int BLUETOOTH_SELECTED_ID_CONDITION_EMPTY = 8034;
        public static final int BLUETOOTH_SELECTED_ID_EMPTY = 8033;
        public static final int BLUETOOTH_SELECTED_NAME_EMPTY = 8018;
        public static final int BLUETOOTH_SWITCH_NOT_ENABLED = 8055;
        public static final int CONDITION_EMPTY = 8005;
        public static final Companion Companion = null;
        public static final int DEVICE_CONDITION_SIZE_ERROR = 8012;
        public static final int DEVICE_CONDITION_TYPE_ERROR = 8025;
        public static final int INSTRUCTION_EMPTY = 8003;
        public static final int INSTRUCTION_ILLEGAL = 8004;
        public static final int JSON_MERGE_ERROR = 8022;
        public static final int JSON_PARSE_ERROR = 8002;
        public static final int LOCATION_CUSTOM_INFO_EMPTY = 8011;
        public static final int LOCATION_CUSTOM_NAME_EMPTY = 8049;
        public static final int LOCATION_DATA_EMPTY = 8048;
        public static final int LOCATION_EVENT_TYPE_EMPTY = 8006;
        public static final int LOCATION_FLOW_ERROR = 8050;
        public static final int LOCATION_LOCATION_TYPE_EMPTY = 8007;
        public static final int LOCATION_NOT_PERMISSION = 8008;
        public static final int LOCATION_PLACE_ALIAS_INFO_EMPTY = 8009;
        public static final int LOCATION_SELECTED_ID_CONDITION_EMPTY = 8024;
        public static final int LOCATION_SELECTED_ID_EMPTY = 8023;
        public static final int LOCATION_SELECTED_NAME_EMPTY = 8010;
        public static final int PARAMS_EMPTY = 8001;
        public static final int PARSE_ENTITY_TO_JSON_ERROR = 8019;
        public static final int REPEATTYPE_ERROR = 8047;
        public static final int REPEATTYPE_MONTHLY_PARAMS_ERROR = 8045;
        public static final int REPEATTYPE_WEEKLY_PARAMS_ERROR = 8044;
        public static final int REPEATTYPE_YEARLY_PARAMS_ERROR = 8046;
        public static final int SMS_PARAMS_EMPTY = 8013;
        public static final int SMS_SELECTED_ID_CONDITION_EMPTY = 8030;
        public static final int SMS_SELECTED_ID_EMPTY = 8029;
        public static final int SMS_SELECTED_NAME_EMPTY = 8014;
        public static final int START_TIME_OR_END_TIME_ERROR = 8056;
        public static final int STORAGE_LOW_TO_PARAMS_EMPTY = 8028;
        public static final int TARGET_DATA_NOT_FOUND = 8021;
        public static final int TARGET_EMPTY = 8020;
        public static final int TIME_CONDITION_INTERVAL_ERROR = 8041;
        public static final int TIME_CONDITION_PARAMS_ERROR = 8040;
        public static final int TIME_CONDITION_TIME_FRAME_ERROR = 8043;
        public static final int TIME_CONDITION_TIME_POINT_ERROR = 8042;
        public static final int UPDATE_STATUS_ERROR = 8036;
        public static final int WIFI_CANDIDATE_INFO_EMPTY = 8037;
        public static final int WIFI_INFO_EMPTY = 8051;
        public static final int WIFI_NO_PERMISSION = 8053;
        public static final int WIFI_PARAMS_EMPTY = 8015;
        public static final int WIFI_SELECTED_ID_CONDITION_EMPTY = 8032;
        public static final int WIFI_SELECTED_ID_EMPTY = 8031;
        public static final int WIFI_SELECTED_NAME_EMPTY = 8016;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public EventTask() {
        }
    }

    public static final class Memory {
        public static final Companion Companion = null;
        public static final int ERROR_CLASSIFY = 6300;
        public static final int ERROR_UPDATE_BUT_RECALL_EMPTY = 6401;
        public static final int ERROR_UPDATE_BUT_RESULT_CREATE = 6402;
        public static final int ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT = 6400;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Memory() {
        }
    }

    public static final class Message {
        public static final Companion Companion = null;
        public static final int MESSAGE_SEND_AIRPLANE_MODE = 9002;
        public static final int MESSAGE_SEND_NO_SIM = 9001;
        public static final int MESSAGE_TARGET_NOT_FOUND = 9003;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Message() {
        }
    }

    public static final class Music {
        public static final Companion Companion = null;
        public static final int NO_PLAYABLE_SEARCH_RESULT = 10003;
        public static final int NO_SEARCH_RESULT = 10001;
        public static final int PLAYLIST_EMPTY = 10002;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Music() {
        }
    }

    public static final class Office {
        public static final int CONTACT_NOT_EXIST_ERROR = 7002;
        public static final Companion Companion = null;
        public static final int EMPTY_COTENT_ERROR = 7003;
        public static final int GROUP_NOT_EXIST_ERROR = 7011;
        public static final int INVALID_ACCOUNT_ERROR = 7001;
        public static final int INVALID_COTENT_ERROR = 7010;
        public static final int KNOWLEDGE_GEN_FAIL = 7006;
        public static final int KNOWLEDGE_INSUFFICIENT_ERROR = 7012;
        public static final int KNOWLEDGE_NOT_AUTHORIZE = 7005;
        public static final int KNOWLEDGE_NOT_AVAILABLE = 7004;
        public static final int SEND_CANCEL_ERROR = 7013;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Office() {
        }
    }

    public static final class System {
        public static final Companion Companion = null;
        public static final int DOUBLE_CONFIRMATION_BEFORE_DOWNLOADING_ERROR = 4011;
        public static final int NO_SCREEN_RECORDING_ERROR = 4002;
        public static final int UNSUPPORTED_SCREEN_RECORDER_WHEN_KEYGUARD_LOCKED_ERROR = 4001;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(d.h.b.h r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public System() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ErrorCode() {
    }
}
