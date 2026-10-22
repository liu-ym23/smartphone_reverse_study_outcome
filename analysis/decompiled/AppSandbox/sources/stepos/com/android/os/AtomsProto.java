package stepos.com.android.os;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.stepos.pps.data.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.io.ConstantsKt;
import okhttp3.internal.http2.Http2;
import okio.Segment;
import stepos.android.server.ErrorSource;

/* loaded from: classes.dex */
public final class AtomsProto {

    public interface ANROccurredOrBuilder extends MessageLiteOrBuilder {
        long getDataLoaderBindDelayMillis();

        int getDataLoaderStatusCode();

        ErrorSource getErrorSource();

        ANROccurred.ForegroundState getForegroundState();

        boolean getIsIncremental();

        ANROccurred.InstantApp getIsInstantApp();

        int getLastReadErrorCode();

        long getLastReadErrorMillisSince();

        int getLastReadErrorUid();

        float getLoadingProgress();

        long getMillisSinceLastDataLoaderBind();

        long getMillisSinceOldestPendingRead();

        String getPackageName();

        ByteString getPackageNameBytes();

        String getProcessName();

        ByteString getProcessNameBytes();

        boolean getReadLogsEnabled();

        String getReason();

        ByteString getReasonBytes();

        String getShortComponentName();

        ByteString getShortComponentNameBytes();

        int getStorageHealthCode();

        int getTotalDelayedReads();

        long getTotalDelayedReadsDurationMillis();

        int getTotalFailedReads();

        int getUid();

        boolean hasDataLoaderBindDelayMillis();

        boolean hasDataLoaderStatusCode();

        boolean hasErrorSource();

        boolean hasForegroundState();

        boolean hasIsIncremental();

        boolean hasIsInstantApp();

        boolean hasLastReadErrorCode();

        boolean hasLastReadErrorMillisSince();

        boolean hasLastReadErrorUid();

        boolean hasLoadingProgress();

        boolean hasMillisSinceLastDataLoaderBind();

        boolean hasMillisSinceOldestPendingRead();

        boolean hasPackageName();

        boolean hasProcessName();

        boolean hasReadLogsEnabled();

        boolean hasReason();

        boolean hasShortComponentName();

        boolean hasStorageHealthCode();

        boolean hasTotalDelayedReads();

        boolean hasTotalDelayedReadsDurationMillis();

        boolean hasTotalFailedReads();

        boolean hasUid();
    }

    public interface AppCrashOccurredOrBuilder extends MessageLiteOrBuilder {
        long getDataLoaderBindDelayMillis();

        int getDataLoaderStatusCode();

        ErrorSource getErrorSource();

        String getEventType();

        ByteString getEventTypeBytes();

        AppCrashOccurred.ForegroundState getForegroundState();

        boolean getIsIncremental();

        AppCrashOccurred.InstantApp getIsInstantApp();

        int getLastReadErrorCode();

        long getLastReadErrorMillisSince();

        int getLastReadErrorUid();

        float getLoadingProgress();

        long getMillisSinceLastDataLoaderBind();

        long getMillisSinceOldestPendingRead();

        String getPackageName();

        ByteString getPackageNameBytes();

        int getPid();

        String getProcessName();

        ByteString getProcessNameBytes();

        boolean getReadLogsEnabled();

        int getStorageHealthCode();

        int getTotalDelayedReads();

        long getTotalDelayedReadsDurationMillis();

        int getTotalFailedReads();

        int getUid();

        boolean hasDataLoaderBindDelayMillis();

        boolean hasDataLoaderStatusCode();

        boolean hasErrorSource();

        boolean hasEventType();

        boolean hasForegroundState();

        boolean hasIsIncremental();

        boolean hasIsInstantApp();

        boolean hasLastReadErrorCode();

        boolean hasLastReadErrorMillisSince();

        boolean hasLastReadErrorUid();

        boolean hasLoadingProgress();

        boolean hasMillisSinceLastDataLoaderBind();

        boolean hasMillisSinceOldestPendingRead();

        boolean hasPackageName();

        boolean hasPid();

        boolean hasProcessName();

        boolean hasReadLogsEnabled();

        boolean hasStorageHealthCode();

        boolean hasTotalDelayedReads();

        boolean hasTotalDelayedReadsDurationMillis();

        boolean hasTotalFailedReads();

        boolean hasUid();
    }

    public interface AtomOrBuilder extends MessageLiteOrBuilder {
        ANROccurred getAnrOccurred();

        AppCrashOccurred getAppCrashOccurred();

        Atom.PushedCase getPushedCase();

        StepOSEventBluetoothCodeReport getSteposEventBluetoothCodeReport();

        StepOSEventFrameworkCodeReport getSteposEventFrameworkCodeReport();

        StepOSEventGNSSCodeReport getSteposEventGnssCodeReport();

        StepOSEventKernelCodeReport getSteposEventKernelCodeReport();

        StepOSEventModemCodeReport getSteposEventModemCodeReport();

        StepOSEventNfcCodeReport getSteposEventNfcCodeReport();

        StepOSEventPerformanceCodeReport getSteposEventPerformanceCodeReport();

        StepOSEventPowerCodeReport getSteposEventPowerCodeReport();

        StepOSEventStabilityCodeReport getSteposEventStabilityCodeReport();

        StepOSEventWifiCodeReport getSteposEventWifiCodeReport();

        StepOSSystemRestartOccurred getSteposSystemRestartOccurred();

        StepOSSystemTombstoneOccurred getSteposSystemTombstoneOccurred();

        SystemServerWatchdogOccurred getSystemServerWatchdogOccurred();

        boolean hasAnrOccurred();

        boolean hasAppCrashOccurred();

        boolean hasSteposEventBluetoothCodeReport();

        boolean hasSteposEventFrameworkCodeReport();

        boolean hasSteposEventGnssCodeReport();

        boolean hasSteposEventKernelCodeReport();

        boolean hasSteposEventModemCodeReport();

        boolean hasSteposEventNfcCodeReport();

        boolean hasSteposEventPerformanceCodeReport();

        boolean hasSteposEventPowerCodeReport();

        boolean hasSteposEventStabilityCodeReport();

        boolean hasSteposEventWifiCodeReport();

        boolean hasSteposSystemRestartOccurred();

        boolean hasSteposSystemTombstoneOccurred();

        boolean hasSystemServerWatchdogOccurred();
    }

    public interface StepOSEventBluetoothCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventFrameworkCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventGNSSCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventKernelCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventModemCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventNfcCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventPerformanceCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventPowerCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventStabilityCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSEventWifiCodeReportOrBuilder extends MessageLiteOrBuilder {
        String getEventCode();

        ByteString getEventCodeBytes();

        String getEventInfo();

        ByteString getEventInfoBytes();

        String getTime();

        ByteString getTimeBytes();

        boolean hasEventCode();

        boolean hasEventInfo();

        boolean hasTime();
    }

    public interface StepOSSystemRestartOccurredOrBuilder extends MessageLiteOrBuilder {
        String getSubject();

        ByteString getSubjectBytes();

        boolean hasSubject();
    }

    public interface StepOSSystemTombstoneOccurredOrBuilder extends MessageLiteOrBuilder {
        int getPid();

        String getProcessName();

        ByteString getProcessNameBytes();

        boolean hasPid();

        boolean hasProcessName();
    }

    public interface SystemServerWatchdogOccurredOrBuilder extends MessageLiteOrBuilder {
        String getSubject();

        ByteString getSubjectBytes();

        boolean hasSubject();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private AtomsProto() {
    }

    public static final class Atom extends GeneratedMessageLite<Atom, Builder> implements AtomOrBuilder {
        public static final int ANR_OCCURRED_FIELD_NUMBER = 79;
        public static final int APP_CRASH_OCCURRED_FIELD_NUMBER = 78;
        private static final Atom DEFAULT_INSTANCE;
        private static volatile Parser<Atom> PARSER = null;
        public static final int STEPOS_EVENT_BLUETOOTH_CODE_REPORT_FIELD_NUMBER = 120003;
        public static final int STEPOS_EVENT_FRAMEWORK_CODE_REPORT_FIELD_NUMBER = 120009;
        public static final int STEPOS_EVENT_GNSS_CODE_REPORT_FIELD_NUMBER = 120002;
        public static final int STEPOS_EVENT_KERNEL_CODE_REPORT_FIELD_NUMBER = 120008;
        public static final int STEPOS_EVENT_MODEM_CODE_REPORT_FIELD_NUMBER = 120004;
        public static final int STEPOS_EVENT_NFC_CODE_REPORT_FIELD_NUMBER = 120001;
        public static final int STEPOS_EVENT_PERFORMANCE_CODE_REPORT_FIELD_NUMBER = 120005;
        public static final int STEPOS_EVENT_POWER_CODE_REPORT_FIELD_NUMBER = 120006;
        public static final int STEPOS_EVENT_STABILITY_CODE_REPORT_FIELD_NUMBER = 120007;
        public static final int STEPOS_EVENT_WIFI_CODE_REPORT_FIELD_NUMBER = 120000;
        public static final int STEPOS_SYSTEM_RESTART_OCCURRED_FIELD_NUMBER = 110000;
        public static final int STEPOS_SYSTEM_TOMBSTONE_OCCURRED_FIELD_NUMBER = 110001;
        public static final int SYSTEM_SERVER_WATCHDOG_OCCURRED_FIELD_NUMBER = 185;
        private int bitField0_;
        private int pushedCase_ = 0;
        private Object pushed_;

        private Atom() {
        }

        public enum PushedCase {
            APP_CRASH_OCCURRED(78),
            ANR_OCCURRED(79),
            SYSTEM_SERVER_WATCHDOG_OCCURRED(Atom.SYSTEM_SERVER_WATCHDOG_OCCURRED_FIELD_NUMBER),
            STEPOS_SYSTEM_RESTART_OCCURRED(110000),
            STEPOS_SYSTEM_TOMBSTONE_OCCURRED(110001),
            STEPOS_EVENT_WIFI_CODE_REPORT(120000),
            STEPOS_EVENT_NFC_CODE_REPORT(120001),
            STEPOS_EVENT_GNSS_CODE_REPORT(120002),
            STEPOS_EVENT_BLUETOOTH_CODE_REPORT(120003),
            STEPOS_EVENT_MODEM_CODE_REPORT(120004),
            STEPOS_EVENT_PERFORMANCE_CODE_REPORT(120005),
            STEPOS_EVENT_POWER_CODE_REPORT(120006),
            STEPOS_EVENT_STABILITY_CODE_REPORT(120007),
            STEPOS_EVENT_KERNEL_CODE_REPORT(120008),
            STEPOS_EVENT_FRAMEWORK_CODE_REPORT(120009),
            PUSHED_NOT_SET(0);

            private final int value;

            PushedCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static PushedCase valueOf(int i) {
                return forNumber(i);
            }

            public static PushedCase forNumber(int i) {
                if (i == 0) {
                    return PUSHED_NOT_SET;
                }
                if (i == 185) {
                    return SYSTEM_SERVER_WATCHDOG_OCCURRED;
                }
                if (i == 78) {
                    return APP_CRASH_OCCURRED;
                }
                if (i == 79) {
                    return ANR_OCCURRED;
                }
                switch (i) {
                    case 110000:
                        return STEPOS_SYSTEM_RESTART_OCCURRED;
                    case 110001:
                        return STEPOS_SYSTEM_TOMBSTONE_OCCURRED;
                    default:
                        switch (i) {
                            case 120000:
                                return STEPOS_EVENT_WIFI_CODE_REPORT;
                            case 120001:
                                return STEPOS_EVENT_NFC_CODE_REPORT;
                            case 120002:
                                return STEPOS_EVENT_GNSS_CODE_REPORT;
                            case 120003:
                                return STEPOS_EVENT_BLUETOOTH_CODE_REPORT;
                            case 120004:
                                return STEPOS_EVENT_MODEM_CODE_REPORT;
                            case 120005:
                                return STEPOS_EVENT_PERFORMANCE_CODE_REPORT;
                            case 120006:
                                return STEPOS_EVENT_POWER_CODE_REPORT;
                            case 120007:
                                return STEPOS_EVENT_STABILITY_CODE_REPORT;
                            case 120008:
                                return STEPOS_EVENT_KERNEL_CODE_REPORT;
                            case 120009:
                                return STEPOS_EVENT_FRAMEWORK_CODE_REPORT;
                            default:
                                return null;
                        }
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public PushedCase getPushedCase() {
            return PushedCase.forNumber(this.pushedCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPushed() {
            this.pushedCase_ = 0;
            this.pushed_ = null;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasAppCrashOccurred() {
            return this.pushedCase_ == 78;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public AppCrashOccurred getAppCrashOccurred() {
            if (this.pushedCase_ == 78) {
                return (AppCrashOccurred) this.pushed_;
            }
            return AppCrashOccurred.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppCrashOccurred(AppCrashOccurred appCrashOccurred) {
            appCrashOccurred.getClass();
            this.pushed_ = appCrashOccurred;
            this.pushedCase_ = 78;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppCrashOccurred(AppCrashOccurred appCrashOccurred) {
            appCrashOccurred.getClass();
            if (this.pushedCase_ == 78 && this.pushed_ != AppCrashOccurred.getDefaultInstance()) {
                this.pushed_ = AppCrashOccurred.newBuilder((AppCrashOccurred) this.pushed_).mergeFrom((AppCrashOccurred.Builder) appCrashOccurred).buildPartial();
            } else {
                this.pushed_ = appCrashOccurred;
            }
            this.pushedCase_ = 78;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppCrashOccurred() {
            if (this.pushedCase_ == 78) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasAnrOccurred() {
            return this.pushedCase_ == 79;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public ANROccurred getAnrOccurred() {
            if (this.pushedCase_ == 79) {
                return (ANROccurred) this.pushed_;
            }
            return ANROccurred.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAnrOccurred(ANROccurred aNROccurred) {
            aNROccurred.getClass();
            this.pushed_ = aNROccurred;
            this.pushedCase_ = 79;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAnrOccurred(ANROccurred aNROccurred) {
            aNROccurred.getClass();
            if (this.pushedCase_ == 79 && this.pushed_ != ANROccurred.getDefaultInstance()) {
                this.pushed_ = ANROccurred.newBuilder((ANROccurred) this.pushed_).mergeFrom((ANROccurred.Builder) aNROccurred).buildPartial();
            } else {
                this.pushed_ = aNROccurred;
            }
            this.pushedCase_ = 79;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAnrOccurred() {
            if (this.pushedCase_ == 79) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSystemServerWatchdogOccurred() {
            return this.pushedCase_ == 185;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public SystemServerWatchdogOccurred getSystemServerWatchdogOccurred() {
            if (this.pushedCase_ == 185) {
                return (SystemServerWatchdogOccurred) this.pushed_;
            }
            return SystemServerWatchdogOccurred.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSystemServerWatchdogOccurred(SystemServerWatchdogOccurred systemServerWatchdogOccurred) {
            systemServerWatchdogOccurred.getClass();
            this.pushed_ = systemServerWatchdogOccurred;
            this.pushedCase_ = SYSTEM_SERVER_WATCHDOG_OCCURRED_FIELD_NUMBER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSystemServerWatchdogOccurred(SystemServerWatchdogOccurred systemServerWatchdogOccurred) {
            systemServerWatchdogOccurred.getClass();
            if (this.pushedCase_ == 185 && this.pushed_ != SystemServerWatchdogOccurred.getDefaultInstance()) {
                this.pushed_ = SystemServerWatchdogOccurred.newBuilder((SystemServerWatchdogOccurred) this.pushed_).mergeFrom((SystemServerWatchdogOccurred.Builder) systemServerWatchdogOccurred).buildPartial();
            } else {
                this.pushed_ = systemServerWatchdogOccurred;
            }
            this.pushedCase_ = SYSTEM_SERVER_WATCHDOG_OCCURRED_FIELD_NUMBER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSystemServerWatchdogOccurred() {
            if (this.pushedCase_ == 185) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposSystemRestartOccurred() {
            return this.pushedCase_ == 110000;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSSystemRestartOccurred getSteposSystemRestartOccurred() {
            if (this.pushedCase_ == 110000) {
                return (StepOSSystemRestartOccurred) this.pushed_;
            }
            return StepOSSystemRestartOccurred.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposSystemRestartOccurred(StepOSSystemRestartOccurred stepOSSystemRestartOccurred) {
            stepOSSystemRestartOccurred.getClass();
            this.pushed_ = stepOSSystemRestartOccurred;
            this.pushedCase_ = 110000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposSystemRestartOccurred(StepOSSystemRestartOccurred stepOSSystemRestartOccurred) {
            stepOSSystemRestartOccurred.getClass();
            if (this.pushedCase_ == 110000 && this.pushed_ != StepOSSystemRestartOccurred.getDefaultInstance()) {
                this.pushed_ = StepOSSystemRestartOccurred.newBuilder((StepOSSystemRestartOccurred) this.pushed_).mergeFrom((StepOSSystemRestartOccurred.Builder) stepOSSystemRestartOccurred).buildPartial();
            } else {
                this.pushed_ = stepOSSystemRestartOccurred;
            }
            this.pushedCase_ = 110000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposSystemRestartOccurred() {
            if (this.pushedCase_ == 110000) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposSystemTombstoneOccurred() {
            return this.pushedCase_ == 110001;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSSystemTombstoneOccurred getSteposSystemTombstoneOccurred() {
            if (this.pushedCase_ == 110001) {
                return (StepOSSystemTombstoneOccurred) this.pushed_;
            }
            return StepOSSystemTombstoneOccurred.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposSystemTombstoneOccurred(StepOSSystemTombstoneOccurred stepOSSystemTombstoneOccurred) {
            stepOSSystemTombstoneOccurred.getClass();
            this.pushed_ = stepOSSystemTombstoneOccurred;
            this.pushedCase_ = 110001;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposSystemTombstoneOccurred(StepOSSystemTombstoneOccurred stepOSSystemTombstoneOccurred) {
            stepOSSystemTombstoneOccurred.getClass();
            if (this.pushedCase_ == 110001 && this.pushed_ != StepOSSystemTombstoneOccurred.getDefaultInstance()) {
                this.pushed_ = StepOSSystemTombstoneOccurred.newBuilder((StepOSSystemTombstoneOccurred) this.pushed_).mergeFrom((StepOSSystemTombstoneOccurred.Builder) stepOSSystemTombstoneOccurred).buildPartial();
            } else {
                this.pushed_ = stepOSSystemTombstoneOccurred;
            }
            this.pushedCase_ = 110001;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposSystemTombstoneOccurred() {
            if (this.pushedCase_ == 110001) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventWifiCodeReport() {
            return this.pushedCase_ == 120000;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventWifiCodeReport getSteposEventWifiCodeReport() {
            if (this.pushedCase_ == 120000) {
                return (StepOSEventWifiCodeReport) this.pushed_;
            }
            return StepOSEventWifiCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventWifiCodeReport(StepOSEventWifiCodeReport stepOSEventWifiCodeReport) {
            stepOSEventWifiCodeReport.getClass();
            this.pushed_ = stepOSEventWifiCodeReport;
            this.pushedCase_ = 120000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventWifiCodeReport(StepOSEventWifiCodeReport stepOSEventWifiCodeReport) {
            stepOSEventWifiCodeReport.getClass();
            if (this.pushedCase_ == 120000 && this.pushed_ != StepOSEventWifiCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventWifiCodeReport.newBuilder((StepOSEventWifiCodeReport) this.pushed_).mergeFrom((StepOSEventWifiCodeReport.Builder) stepOSEventWifiCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventWifiCodeReport;
            }
            this.pushedCase_ = 120000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventWifiCodeReport() {
            if (this.pushedCase_ == 120000) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventNfcCodeReport() {
            return this.pushedCase_ == 120001;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventNfcCodeReport getSteposEventNfcCodeReport() {
            if (this.pushedCase_ == 120001) {
                return (StepOSEventNfcCodeReport) this.pushed_;
            }
            return StepOSEventNfcCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventNfcCodeReport(StepOSEventNfcCodeReport stepOSEventNfcCodeReport) {
            stepOSEventNfcCodeReport.getClass();
            this.pushed_ = stepOSEventNfcCodeReport;
            this.pushedCase_ = 120001;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventNfcCodeReport(StepOSEventNfcCodeReport stepOSEventNfcCodeReport) {
            stepOSEventNfcCodeReport.getClass();
            if (this.pushedCase_ == 120001 && this.pushed_ != StepOSEventNfcCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventNfcCodeReport.newBuilder((StepOSEventNfcCodeReport) this.pushed_).mergeFrom((StepOSEventNfcCodeReport.Builder) stepOSEventNfcCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventNfcCodeReport;
            }
            this.pushedCase_ = 120001;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventNfcCodeReport() {
            if (this.pushedCase_ == 120001) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventGnssCodeReport() {
            return this.pushedCase_ == 120002;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventGNSSCodeReport getSteposEventGnssCodeReport() {
            if (this.pushedCase_ == 120002) {
                return (StepOSEventGNSSCodeReport) this.pushed_;
            }
            return StepOSEventGNSSCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventGnssCodeReport(StepOSEventGNSSCodeReport stepOSEventGNSSCodeReport) {
            stepOSEventGNSSCodeReport.getClass();
            this.pushed_ = stepOSEventGNSSCodeReport;
            this.pushedCase_ = 120002;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventGnssCodeReport(StepOSEventGNSSCodeReport stepOSEventGNSSCodeReport) {
            stepOSEventGNSSCodeReport.getClass();
            if (this.pushedCase_ == 120002 && this.pushed_ != StepOSEventGNSSCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventGNSSCodeReport.newBuilder((StepOSEventGNSSCodeReport) this.pushed_).mergeFrom((StepOSEventGNSSCodeReport.Builder) stepOSEventGNSSCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventGNSSCodeReport;
            }
            this.pushedCase_ = 120002;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventGnssCodeReport() {
            if (this.pushedCase_ == 120002) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventBluetoothCodeReport() {
            return this.pushedCase_ == 120003;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventBluetoothCodeReport getSteposEventBluetoothCodeReport() {
            if (this.pushedCase_ == 120003) {
                return (StepOSEventBluetoothCodeReport) this.pushed_;
            }
            return StepOSEventBluetoothCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventBluetoothCodeReport(StepOSEventBluetoothCodeReport stepOSEventBluetoothCodeReport) {
            stepOSEventBluetoothCodeReport.getClass();
            this.pushed_ = stepOSEventBluetoothCodeReport;
            this.pushedCase_ = 120003;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventBluetoothCodeReport(StepOSEventBluetoothCodeReport stepOSEventBluetoothCodeReport) {
            stepOSEventBluetoothCodeReport.getClass();
            if (this.pushedCase_ == 120003 && this.pushed_ != StepOSEventBluetoothCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventBluetoothCodeReport.newBuilder((StepOSEventBluetoothCodeReport) this.pushed_).mergeFrom((StepOSEventBluetoothCodeReport.Builder) stepOSEventBluetoothCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventBluetoothCodeReport;
            }
            this.pushedCase_ = 120003;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventBluetoothCodeReport() {
            if (this.pushedCase_ == 120003) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventModemCodeReport() {
            return this.pushedCase_ == 120004;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventModemCodeReport getSteposEventModemCodeReport() {
            if (this.pushedCase_ == 120004) {
                return (StepOSEventModemCodeReport) this.pushed_;
            }
            return StepOSEventModemCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventModemCodeReport(StepOSEventModemCodeReport stepOSEventModemCodeReport) {
            stepOSEventModemCodeReport.getClass();
            this.pushed_ = stepOSEventModemCodeReport;
            this.pushedCase_ = 120004;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventModemCodeReport(StepOSEventModemCodeReport stepOSEventModemCodeReport) {
            stepOSEventModemCodeReport.getClass();
            if (this.pushedCase_ == 120004 && this.pushed_ != StepOSEventModemCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventModemCodeReport.newBuilder((StepOSEventModemCodeReport) this.pushed_).mergeFrom((StepOSEventModemCodeReport.Builder) stepOSEventModemCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventModemCodeReport;
            }
            this.pushedCase_ = 120004;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventModemCodeReport() {
            if (this.pushedCase_ == 120004) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventPerformanceCodeReport() {
            return this.pushedCase_ == 120005;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventPerformanceCodeReport getSteposEventPerformanceCodeReport() {
            if (this.pushedCase_ == 120005) {
                return (StepOSEventPerformanceCodeReport) this.pushed_;
            }
            return StepOSEventPerformanceCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventPerformanceCodeReport(StepOSEventPerformanceCodeReport stepOSEventPerformanceCodeReport) {
            stepOSEventPerformanceCodeReport.getClass();
            this.pushed_ = stepOSEventPerformanceCodeReport;
            this.pushedCase_ = 120005;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventPerformanceCodeReport(StepOSEventPerformanceCodeReport stepOSEventPerformanceCodeReport) {
            stepOSEventPerformanceCodeReport.getClass();
            if (this.pushedCase_ == 120005 && this.pushed_ != StepOSEventPerformanceCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventPerformanceCodeReport.newBuilder((StepOSEventPerformanceCodeReport) this.pushed_).mergeFrom((StepOSEventPerformanceCodeReport.Builder) stepOSEventPerformanceCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventPerformanceCodeReport;
            }
            this.pushedCase_ = 120005;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventPerformanceCodeReport() {
            if (this.pushedCase_ == 120005) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventPowerCodeReport() {
            return this.pushedCase_ == 120006;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventPowerCodeReport getSteposEventPowerCodeReport() {
            if (this.pushedCase_ == 120006) {
                return (StepOSEventPowerCodeReport) this.pushed_;
            }
            return StepOSEventPowerCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventPowerCodeReport(StepOSEventPowerCodeReport stepOSEventPowerCodeReport) {
            stepOSEventPowerCodeReport.getClass();
            this.pushed_ = stepOSEventPowerCodeReport;
            this.pushedCase_ = 120006;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventPowerCodeReport(StepOSEventPowerCodeReport stepOSEventPowerCodeReport) {
            stepOSEventPowerCodeReport.getClass();
            if (this.pushedCase_ == 120006 && this.pushed_ != StepOSEventPowerCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventPowerCodeReport.newBuilder((StepOSEventPowerCodeReport) this.pushed_).mergeFrom((StepOSEventPowerCodeReport.Builder) stepOSEventPowerCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventPowerCodeReport;
            }
            this.pushedCase_ = 120006;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventPowerCodeReport() {
            if (this.pushedCase_ == 120006) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventStabilityCodeReport() {
            return this.pushedCase_ == 120007;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventStabilityCodeReport getSteposEventStabilityCodeReport() {
            if (this.pushedCase_ == 120007) {
                return (StepOSEventStabilityCodeReport) this.pushed_;
            }
            return StepOSEventStabilityCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventStabilityCodeReport(StepOSEventStabilityCodeReport stepOSEventStabilityCodeReport) {
            stepOSEventStabilityCodeReport.getClass();
            this.pushed_ = stepOSEventStabilityCodeReport;
            this.pushedCase_ = 120007;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventStabilityCodeReport(StepOSEventStabilityCodeReport stepOSEventStabilityCodeReport) {
            stepOSEventStabilityCodeReport.getClass();
            if (this.pushedCase_ == 120007 && this.pushed_ != StepOSEventStabilityCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventStabilityCodeReport.newBuilder((StepOSEventStabilityCodeReport) this.pushed_).mergeFrom((StepOSEventStabilityCodeReport.Builder) stepOSEventStabilityCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventStabilityCodeReport;
            }
            this.pushedCase_ = 120007;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventStabilityCodeReport() {
            if (this.pushedCase_ == 120007) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventKernelCodeReport() {
            return this.pushedCase_ == 120008;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventKernelCodeReport getSteposEventKernelCodeReport() {
            if (this.pushedCase_ == 120008) {
                return (StepOSEventKernelCodeReport) this.pushed_;
            }
            return StepOSEventKernelCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventKernelCodeReport(StepOSEventKernelCodeReport stepOSEventKernelCodeReport) {
            stepOSEventKernelCodeReport.getClass();
            this.pushed_ = stepOSEventKernelCodeReport;
            this.pushedCase_ = 120008;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventKernelCodeReport(StepOSEventKernelCodeReport stepOSEventKernelCodeReport) {
            stepOSEventKernelCodeReport.getClass();
            if (this.pushedCase_ == 120008 && this.pushed_ != StepOSEventKernelCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventKernelCodeReport.newBuilder((StepOSEventKernelCodeReport) this.pushed_).mergeFrom((StepOSEventKernelCodeReport.Builder) stepOSEventKernelCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventKernelCodeReport;
            }
            this.pushedCase_ = 120008;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventKernelCodeReport() {
            if (this.pushedCase_ == 120008) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public boolean hasSteposEventFrameworkCodeReport() {
            return this.pushedCase_ == 120009;
        }

        @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
        public StepOSEventFrameworkCodeReport getSteposEventFrameworkCodeReport() {
            if (this.pushedCase_ == 120009) {
                return (StepOSEventFrameworkCodeReport) this.pushed_;
            }
            return StepOSEventFrameworkCodeReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposEventFrameworkCodeReport(StepOSEventFrameworkCodeReport stepOSEventFrameworkCodeReport) {
            stepOSEventFrameworkCodeReport.getClass();
            this.pushed_ = stepOSEventFrameworkCodeReport;
            this.pushedCase_ = 120009;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposEventFrameworkCodeReport(StepOSEventFrameworkCodeReport stepOSEventFrameworkCodeReport) {
            stepOSEventFrameworkCodeReport.getClass();
            if (this.pushedCase_ == 120009 && this.pushed_ != StepOSEventFrameworkCodeReport.getDefaultInstance()) {
                this.pushed_ = StepOSEventFrameworkCodeReport.newBuilder((StepOSEventFrameworkCodeReport) this.pushed_).mergeFrom((StepOSEventFrameworkCodeReport.Builder) stepOSEventFrameworkCodeReport).buildPartial();
            } else {
                this.pushed_ = stepOSEventFrameworkCodeReport;
            }
            this.pushedCase_ = 120009;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposEventFrameworkCodeReport() {
            if (this.pushedCase_ == 120009) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        public static Atom parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Atom parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Atom parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Atom parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Atom parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Atom parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Atom parseFrom(InputStream inputStream) throws IOException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Atom parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Atom parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Atom) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Atom parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Atom) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Atom parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Atom parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Atom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Atom atom) {
            return DEFAULT_INSTANCE.createBuilder(atom);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Atom, Builder> implements AtomOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Atom.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public PushedCase getPushedCase() {
                return ((Atom) this.instance).getPushedCase();
            }

            public Builder clearPushed() {
                copyOnWrite();
                ((Atom) this.instance).clearPushed();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasAppCrashOccurred() {
                return ((Atom) this.instance).hasAppCrashOccurred();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public AppCrashOccurred getAppCrashOccurred() {
                return ((Atom) this.instance).getAppCrashOccurred();
            }

            public Builder setAppCrashOccurred(AppCrashOccurred appCrashOccurred) {
                copyOnWrite();
                ((Atom) this.instance).setAppCrashOccurred(appCrashOccurred);
                return this;
            }

            public Builder setAppCrashOccurred(AppCrashOccurred.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setAppCrashOccurred(builder.build());
                return this;
            }

            public Builder mergeAppCrashOccurred(AppCrashOccurred appCrashOccurred) {
                copyOnWrite();
                ((Atom) this.instance).mergeAppCrashOccurred(appCrashOccurred);
                return this;
            }

            public Builder clearAppCrashOccurred() {
                copyOnWrite();
                ((Atom) this.instance).clearAppCrashOccurred();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasAnrOccurred() {
                return ((Atom) this.instance).hasAnrOccurred();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public ANROccurred getAnrOccurred() {
                return ((Atom) this.instance).getAnrOccurred();
            }

            public Builder setAnrOccurred(ANROccurred aNROccurred) {
                copyOnWrite();
                ((Atom) this.instance).setAnrOccurred(aNROccurred);
                return this;
            }

            public Builder setAnrOccurred(ANROccurred.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setAnrOccurred(builder.build());
                return this;
            }

            public Builder mergeAnrOccurred(ANROccurred aNROccurred) {
                copyOnWrite();
                ((Atom) this.instance).mergeAnrOccurred(aNROccurred);
                return this;
            }

            public Builder clearAnrOccurred() {
                copyOnWrite();
                ((Atom) this.instance).clearAnrOccurred();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSystemServerWatchdogOccurred() {
                return ((Atom) this.instance).hasSystemServerWatchdogOccurred();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public SystemServerWatchdogOccurred getSystemServerWatchdogOccurred() {
                return ((Atom) this.instance).getSystemServerWatchdogOccurred();
            }

            public Builder setSystemServerWatchdogOccurred(SystemServerWatchdogOccurred systemServerWatchdogOccurred) {
                copyOnWrite();
                ((Atom) this.instance).setSystemServerWatchdogOccurred(systemServerWatchdogOccurred);
                return this;
            }

            public Builder setSystemServerWatchdogOccurred(SystemServerWatchdogOccurred.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSystemServerWatchdogOccurred(builder.build());
                return this;
            }

            public Builder mergeSystemServerWatchdogOccurred(SystemServerWatchdogOccurred systemServerWatchdogOccurred) {
                copyOnWrite();
                ((Atom) this.instance).mergeSystemServerWatchdogOccurred(systemServerWatchdogOccurred);
                return this;
            }

            public Builder clearSystemServerWatchdogOccurred() {
                copyOnWrite();
                ((Atom) this.instance).clearSystemServerWatchdogOccurred();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposSystemRestartOccurred() {
                return ((Atom) this.instance).hasSteposSystemRestartOccurred();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSSystemRestartOccurred getSteposSystemRestartOccurred() {
                return ((Atom) this.instance).getSteposSystemRestartOccurred();
            }

            public Builder setSteposSystemRestartOccurred(StepOSSystemRestartOccurred stepOSSystemRestartOccurred) {
                copyOnWrite();
                ((Atom) this.instance).setSteposSystemRestartOccurred(stepOSSystemRestartOccurred);
                return this;
            }

            public Builder setSteposSystemRestartOccurred(StepOSSystemRestartOccurred.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposSystemRestartOccurred(builder.build());
                return this;
            }

            public Builder mergeSteposSystemRestartOccurred(StepOSSystemRestartOccurred stepOSSystemRestartOccurred) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposSystemRestartOccurred(stepOSSystemRestartOccurred);
                return this;
            }

            public Builder clearSteposSystemRestartOccurred() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposSystemRestartOccurred();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposSystemTombstoneOccurred() {
                return ((Atom) this.instance).hasSteposSystemTombstoneOccurred();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSSystemTombstoneOccurred getSteposSystemTombstoneOccurred() {
                return ((Atom) this.instance).getSteposSystemTombstoneOccurred();
            }

            public Builder setSteposSystemTombstoneOccurred(StepOSSystemTombstoneOccurred stepOSSystemTombstoneOccurred) {
                copyOnWrite();
                ((Atom) this.instance).setSteposSystemTombstoneOccurred(stepOSSystemTombstoneOccurred);
                return this;
            }

            public Builder setSteposSystemTombstoneOccurred(StepOSSystemTombstoneOccurred.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposSystemTombstoneOccurred(builder.build());
                return this;
            }

            public Builder mergeSteposSystemTombstoneOccurred(StepOSSystemTombstoneOccurred stepOSSystemTombstoneOccurred) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposSystemTombstoneOccurred(stepOSSystemTombstoneOccurred);
                return this;
            }

            public Builder clearSteposSystemTombstoneOccurred() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposSystemTombstoneOccurred();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventWifiCodeReport() {
                return ((Atom) this.instance).hasSteposEventWifiCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventWifiCodeReport getSteposEventWifiCodeReport() {
                return ((Atom) this.instance).getSteposEventWifiCodeReport();
            }

            public Builder setSteposEventWifiCodeReport(StepOSEventWifiCodeReport stepOSEventWifiCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventWifiCodeReport(stepOSEventWifiCodeReport);
                return this;
            }

            public Builder setSteposEventWifiCodeReport(StepOSEventWifiCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventWifiCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventWifiCodeReport(StepOSEventWifiCodeReport stepOSEventWifiCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventWifiCodeReport(stepOSEventWifiCodeReport);
                return this;
            }

            public Builder clearSteposEventWifiCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventWifiCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventNfcCodeReport() {
                return ((Atom) this.instance).hasSteposEventNfcCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventNfcCodeReport getSteposEventNfcCodeReport() {
                return ((Atom) this.instance).getSteposEventNfcCodeReport();
            }

            public Builder setSteposEventNfcCodeReport(StepOSEventNfcCodeReport stepOSEventNfcCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventNfcCodeReport(stepOSEventNfcCodeReport);
                return this;
            }

            public Builder setSteposEventNfcCodeReport(StepOSEventNfcCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventNfcCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventNfcCodeReport(StepOSEventNfcCodeReport stepOSEventNfcCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventNfcCodeReport(stepOSEventNfcCodeReport);
                return this;
            }

            public Builder clearSteposEventNfcCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventNfcCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventGnssCodeReport() {
                return ((Atom) this.instance).hasSteposEventGnssCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventGNSSCodeReport getSteposEventGnssCodeReport() {
                return ((Atom) this.instance).getSteposEventGnssCodeReport();
            }

            public Builder setSteposEventGnssCodeReport(StepOSEventGNSSCodeReport stepOSEventGNSSCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventGnssCodeReport(stepOSEventGNSSCodeReport);
                return this;
            }

            public Builder setSteposEventGnssCodeReport(StepOSEventGNSSCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventGnssCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventGnssCodeReport(StepOSEventGNSSCodeReport stepOSEventGNSSCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventGnssCodeReport(stepOSEventGNSSCodeReport);
                return this;
            }

            public Builder clearSteposEventGnssCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventGnssCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventBluetoothCodeReport() {
                return ((Atom) this.instance).hasSteposEventBluetoothCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventBluetoothCodeReport getSteposEventBluetoothCodeReport() {
                return ((Atom) this.instance).getSteposEventBluetoothCodeReport();
            }

            public Builder setSteposEventBluetoothCodeReport(StepOSEventBluetoothCodeReport stepOSEventBluetoothCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventBluetoothCodeReport(stepOSEventBluetoothCodeReport);
                return this;
            }

            public Builder setSteposEventBluetoothCodeReport(StepOSEventBluetoothCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventBluetoothCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventBluetoothCodeReport(StepOSEventBluetoothCodeReport stepOSEventBluetoothCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventBluetoothCodeReport(stepOSEventBluetoothCodeReport);
                return this;
            }

            public Builder clearSteposEventBluetoothCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventBluetoothCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventModemCodeReport() {
                return ((Atom) this.instance).hasSteposEventModemCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventModemCodeReport getSteposEventModemCodeReport() {
                return ((Atom) this.instance).getSteposEventModemCodeReport();
            }

            public Builder setSteposEventModemCodeReport(StepOSEventModemCodeReport stepOSEventModemCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventModemCodeReport(stepOSEventModemCodeReport);
                return this;
            }

            public Builder setSteposEventModemCodeReport(StepOSEventModemCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventModemCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventModemCodeReport(StepOSEventModemCodeReport stepOSEventModemCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventModemCodeReport(stepOSEventModemCodeReport);
                return this;
            }

            public Builder clearSteposEventModemCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventModemCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventPerformanceCodeReport() {
                return ((Atom) this.instance).hasSteposEventPerformanceCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventPerformanceCodeReport getSteposEventPerformanceCodeReport() {
                return ((Atom) this.instance).getSteposEventPerformanceCodeReport();
            }

            public Builder setSteposEventPerformanceCodeReport(StepOSEventPerformanceCodeReport stepOSEventPerformanceCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventPerformanceCodeReport(stepOSEventPerformanceCodeReport);
                return this;
            }

            public Builder setSteposEventPerformanceCodeReport(StepOSEventPerformanceCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventPerformanceCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventPerformanceCodeReport(StepOSEventPerformanceCodeReport stepOSEventPerformanceCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventPerformanceCodeReport(stepOSEventPerformanceCodeReport);
                return this;
            }

            public Builder clearSteposEventPerformanceCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventPerformanceCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventPowerCodeReport() {
                return ((Atom) this.instance).hasSteposEventPowerCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventPowerCodeReport getSteposEventPowerCodeReport() {
                return ((Atom) this.instance).getSteposEventPowerCodeReport();
            }

            public Builder setSteposEventPowerCodeReport(StepOSEventPowerCodeReport stepOSEventPowerCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventPowerCodeReport(stepOSEventPowerCodeReport);
                return this;
            }

            public Builder setSteposEventPowerCodeReport(StepOSEventPowerCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventPowerCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventPowerCodeReport(StepOSEventPowerCodeReport stepOSEventPowerCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventPowerCodeReport(stepOSEventPowerCodeReport);
                return this;
            }

            public Builder clearSteposEventPowerCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventPowerCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventStabilityCodeReport() {
                return ((Atom) this.instance).hasSteposEventStabilityCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventStabilityCodeReport getSteposEventStabilityCodeReport() {
                return ((Atom) this.instance).getSteposEventStabilityCodeReport();
            }

            public Builder setSteposEventStabilityCodeReport(StepOSEventStabilityCodeReport stepOSEventStabilityCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventStabilityCodeReport(stepOSEventStabilityCodeReport);
                return this;
            }

            public Builder setSteposEventStabilityCodeReport(StepOSEventStabilityCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventStabilityCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventStabilityCodeReport(StepOSEventStabilityCodeReport stepOSEventStabilityCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventStabilityCodeReport(stepOSEventStabilityCodeReport);
                return this;
            }

            public Builder clearSteposEventStabilityCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventStabilityCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventKernelCodeReport() {
                return ((Atom) this.instance).hasSteposEventKernelCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventKernelCodeReport getSteposEventKernelCodeReport() {
                return ((Atom) this.instance).getSteposEventKernelCodeReport();
            }

            public Builder setSteposEventKernelCodeReport(StepOSEventKernelCodeReport stepOSEventKernelCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventKernelCodeReport(stepOSEventKernelCodeReport);
                return this;
            }

            public Builder setSteposEventKernelCodeReport(StepOSEventKernelCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventKernelCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventKernelCodeReport(StepOSEventKernelCodeReport stepOSEventKernelCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventKernelCodeReport(stepOSEventKernelCodeReport);
                return this;
            }

            public Builder clearSteposEventKernelCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventKernelCodeReport();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public boolean hasSteposEventFrameworkCodeReport() {
                return ((Atom) this.instance).hasSteposEventFrameworkCodeReport();
            }

            @Override // stepos.com.android.os.AtomsProto.AtomOrBuilder
            public StepOSEventFrameworkCodeReport getSteposEventFrameworkCodeReport() {
                return ((Atom) this.instance).getSteposEventFrameworkCodeReport();
            }

            public Builder setSteposEventFrameworkCodeReport(StepOSEventFrameworkCodeReport stepOSEventFrameworkCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventFrameworkCodeReport(stepOSEventFrameworkCodeReport);
                return this;
            }

            public Builder setSteposEventFrameworkCodeReport(StepOSEventFrameworkCodeReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposEventFrameworkCodeReport(builder.build());
                return this;
            }

            public Builder mergeSteposEventFrameworkCodeReport(StepOSEventFrameworkCodeReport stepOSEventFrameworkCodeReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposEventFrameworkCodeReport(stepOSEventFrameworkCodeReport);
                return this;
            }

            public Builder clearSteposEventFrameworkCodeReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposEventFrameworkCodeReport();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Atom();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000f\u0001\u0001N\uf4c9\u000e\u000f\u0000\u0000\u0000Nြ\u0000Oြ\u0000¹ြ\u0000\uedb0\rြ\u0000\uedb1\rြ\u0000\uf4c0\u000eြ\u0000\uf4c1\u000eြ\u0000\uf4c2\u000eြ\u0000\uf4c3\u000eြ\u0000\uf4c4\u000eြ\u0000\uf4c5\u000eြ\u0000\uf4c6\u000eြ\u0000\uf4c7\u000eြ\u0000\uf4c8\u000eြ\u0000\uf4c9\u000eြ\u0000", new Object[]{"pushed_", "pushedCase_", "bitField0_", AppCrashOccurred.class, ANROccurred.class, SystemServerWatchdogOccurred.class, StepOSSystemRestartOccurred.class, StepOSSystemTombstoneOccurred.class, StepOSEventWifiCodeReport.class, StepOSEventNfcCodeReport.class, StepOSEventGNSSCodeReport.class, StepOSEventBluetoothCodeReport.class, StepOSEventModemCodeReport.class, StepOSEventPerformanceCodeReport.class, StepOSEventPowerCodeReport.class, StepOSEventStabilityCodeReport.class, StepOSEventKernelCodeReport.class, StepOSEventFrameworkCodeReport.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Atom> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Atom.class) {
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
            Atom atom = new Atom();
            DEFAULT_INSTANCE = atom;
            GeneratedMessageLite.registerDefaultInstance(Atom.class, atom);
        }

        public static Atom getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Atom> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: stepos.com.android.os.AtomsProto$1, reason: invalid class name */
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

    public static final class AppCrashOccurred extends GeneratedMessageLite<AppCrashOccurred, Builder> implements AppCrashOccurredOrBuilder {
        public static final int DATA_LOADER_BIND_DELAY_MILLIS_FIELD_NUMBER = 16;
        public static final int DATA_LOADER_STATUS_CODE_FIELD_NUMBER = 13;
        private static final AppCrashOccurred DEFAULT_INSTANCE;
        public static final int ERROR_SOURCE_FIELD_NUMBER = 8;
        public static final int EVENT_TYPE_FIELD_NUMBER = 2;
        public static final int FOREGROUND_STATE_FIELD_NUMBER = 7;
        public static final int IS_INCREMENTAL_FIELD_NUMBER = 9;
        public static final int IS_INSTANT_APP_FIELD_NUMBER = 6;
        public static final int LAST_READ_ERROR_CODE_FIELD_NUMBER = 21;
        public static final int LAST_READ_ERROR_MILLIS_SINCE_FIELD_NUMBER = 20;
        public static final int LAST_READ_ERROR_UID_FIELD_NUMBER = 19;
        public static final int LOADING_PROGRESS_FIELD_NUMBER = 10;
        public static final int MILLIS_SINCE_LAST_DATA_LOADER_BIND_FIELD_NUMBER = 15;
        public static final int MILLIS_SINCE_OLDEST_PENDING_READ_FIELD_NUMBER = 11;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 5;
        private static volatile Parser<AppCrashOccurred> PARSER = null;
        public static final int PID_FIELD_NUMBER = 4;
        public static final int PROCESS_NAME_FIELD_NUMBER = 3;
        public static final int READ_LOGS_ENABLED_FIELD_NUMBER = 14;
        public static final int STORAGE_HEALTH_CODE_FIELD_NUMBER = 12;
        public static final int TOTAL_DELAYED_READS_DURATION_MILLIS_FIELD_NUMBER = 22;
        public static final int TOTAL_DELAYED_READS_FIELD_NUMBER = 17;
        public static final int TOTAL_FAILED_READS_FIELD_NUMBER = 18;
        public static final int UID_FIELD_NUMBER = 1;
        private int bitField0_;
        private long dataLoaderBindDelayMillis_;
        private int dataLoaderStatusCode_;
        private int errorSource_;
        private int foregroundState_;
        private boolean isIncremental_;
        private int isInstantApp_;
        private int lastReadErrorCode_;
        private long lastReadErrorMillisSince_;
        private int lastReadErrorUid_;
        private float loadingProgress_;
        private long millisSinceLastDataLoaderBind_;
        private long millisSinceOldestPendingRead_;
        private int pid_;
        private boolean readLogsEnabled_;
        private int storageHealthCode_;
        private long totalDelayedReadsDurationMillis_;
        private int totalDelayedReads_;
        private int totalFailedReads_;
        private int uid_;
        private String eventType_ = "";
        private String processName_ = "";
        private String packageName_ = "";

        private AppCrashOccurred() {
        }

        public enum InstantApp implements Internal.EnumLite {
            UNAVAILABLE(0),
            FALSE(1),
            TRUE(2);

            public static final int FALSE_VALUE = 1;
            public static final int TRUE_VALUE = 2;
            public static final int UNAVAILABLE_VALUE = 0;
            private static final Internal.EnumLiteMap<InstantApp> internalValueMap = new Internal.EnumLiteMap<InstantApp>() { // from class: stepos.com.android.os.AtomsProto.AppCrashOccurred.InstantApp.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public InstantApp findValueByNumber(int i) {
                    return InstantApp.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static InstantApp valueOf(int i) {
                return forNumber(i);
            }

            public static InstantApp forNumber(int i) {
                if (i == 0) {
                    return UNAVAILABLE;
                }
                if (i == 1) {
                    return FALSE;
                }
                if (i != 2) {
                    return null;
                }
                return TRUE;
            }

            public static Internal.EnumLiteMap<InstantApp> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return InstantAppVerifier.INSTANCE;
            }

            private static final class InstantAppVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new InstantAppVerifier();

                private InstantAppVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return InstantApp.forNumber(i) != null;
                }
            }

            InstantApp(int i) {
                this.value = i;
            }
        }

        public enum ForegroundState implements Internal.EnumLite {
            UNKNOWN(0),
            BACKGROUND(1),
            FOREGROUND(2);

            public static final int BACKGROUND_VALUE = 1;
            public static final int FOREGROUND_VALUE = 2;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<ForegroundState> internalValueMap = new Internal.EnumLiteMap<ForegroundState>() { // from class: stepos.com.android.os.AtomsProto.AppCrashOccurred.ForegroundState.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ForegroundState findValueByNumber(int i) {
                    return ForegroundState.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ForegroundState valueOf(int i) {
                return forNumber(i);
            }

            public static ForegroundState forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return BACKGROUND;
                }
                if (i != 2) {
                    return null;
                }
                return FOREGROUND;
            }

            public static Internal.EnumLiteMap<ForegroundState> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ForegroundStateVerifier.INSTANCE;
            }

            private static final class ForegroundStateVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ForegroundStateVerifier();

                private ForegroundStateVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return ForegroundState.forNumber(i) != null;
                }
            }

            ForegroundState(int i) {
                this.value = i;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
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

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasEventType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public String getEventType() {
            return this.eventType_;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public ByteString getEventTypeBytes() {
            return ByteString.copyFromUtf8(this.eventType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventType(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.eventType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventType() {
            this.bitField0_ &= -3;
            this.eventType_ = getDefaultInstance().getEventType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventTypeBytes(ByteString byteString) {
            this.eventType_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasProcessName() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public String getProcessName() {
            return this.processName_;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public ByteString getProcessNameBytes() {
            return ByteString.copyFromUtf8(this.processName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessName(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.processName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProcessName() {
            this.bitField0_ &= -5;
            this.processName_ = getDefaultInstance().getProcessName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessNameBytes(ByteString byteString) {
            this.processName_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasPid() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public int getPid() {
            return this.pid_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPid(int i) {
            this.bitField0_ |= 8;
            this.pid_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPid() {
            this.bitField0_ &= -9;
            this.pid_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasPackageName() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public String getPackageName() {
            return this.packageName_;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public ByteString getPackageNameBytes() {
            return ByteString.copyFromUtf8(this.packageName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageName(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.packageName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageName() {
            this.bitField0_ &= -17;
            this.packageName_ = getDefaultInstance().getPackageName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageNameBytes(ByteString byteString) {
            this.packageName_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasIsInstantApp() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public InstantApp getIsInstantApp() {
            InstantApp instantAppForNumber = InstantApp.forNumber(this.isInstantApp_);
            return instantAppForNumber == null ? InstantApp.UNAVAILABLE : instantAppForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsInstantApp(InstantApp instantApp) {
            this.isInstantApp_ = instantApp.getNumber();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsInstantApp() {
            this.bitField0_ &= -33;
            this.isInstantApp_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasForegroundState() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public ForegroundState getForegroundState() {
            ForegroundState foregroundStateForNumber = ForegroundState.forNumber(this.foregroundState_);
            return foregroundStateForNumber == null ? ForegroundState.UNKNOWN : foregroundStateForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForegroundState(ForegroundState foregroundState) {
            this.foregroundState_ = foregroundState.getNumber();
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearForegroundState() {
            this.bitField0_ &= -65;
            this.foregroundState_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasErrorSource() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public ErrorSource getErrorSource() {
            ErrorSource errorSourceForNumber = ErrorSource.forNumber(this.errorSource_);
            return errorSourceForNumber == null ? ErrorSource.ERROR_SOURCE_UNKNOWN : errorSourceForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSource(ErrorSource errorSource) {
            this.errorSource_ = errorSource.getNumber();
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorSource() {
            this.bitField0_ &= -129;
            this.errorSource_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasIsIncremental() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean getIsIncremental() {
            return this.isIncremental_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsIncremental(boolean z) {
            this.bitField0_ |= 256;
            this.isIncremental_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsIncremental() {
            this.bitField0_ &= -257;
            this.isIncremental_ = false;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasLoadingProgress() {
            return (this.bitField0_ & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public float getLoadingProgress() {
            return this.loadingProgress_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoadingProgress(float f) {
            this.bitField0_ |= ConstantsKt.MINIMUM_BLOCK_SIZE;
            this.loadingProgress_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoadingProgress() {
            this.bitField0_ &= -513;
            this.loadingProgress_ = 0.0f;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasMillisSinceOldestPendingRead() {
            return (this.bitField0_ & Segment.SHARE_MINIMUM) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public long getMillisSinceOldestPendingRead() {
            return this.millisSinceOldestPendingRead_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMillisSinceOldestPendingRead(long j) {
            this.bitField0_ |= Segment.SHARE_MINIMUM;
            this.millisSinceOldestPendingRead_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMillisSinceOldestPendingRead() {
            this.bitField0_ &= -1025;
            this.millisSinceOldestPendingRead_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasStorageHealthCode() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public int getStorageHealthCode() {
            return this.storageHealthCode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStorageHealthCode(int i) {
            this.bitField0_ |= 2048;
            this.storageHealthCode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStorageHealthCode() {
            this.bitField0_ &= -2049;
            this.storageHealthCode_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasDataLoaderStatusCode() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public int getDataLoaderStatusCode() {
            return this.dataLoaderStatusCode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataLoaderStatusCode(int i) {
            this.bitField0_ |= 4096;
            this.dataLoaderStatusCode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataLoaderStatusCode() {
            this.bitField0_ &= -4097;
            this.dataLoaderStatusCode_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasReadLogsEnabled() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean getReadLogsEnabled() {
            return this.readLogsEnabled_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReadLogsEnabled(boolean z) {
            this.bitField0_ |= 8192;
            this.readLogsEnabled_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReadLogsEnabled() {
            this.bitField0_ &= -8193;
            this.readLogsEnabled_ = false;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasMillisSinceLastDataLoaderBind() {
            return (this.bitField0_ & Http2.INITIAL_MAX_FRAME_SIZE) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public long getMillisSinceLastDataLoaderBind() {
            return this.millisSinceLastDataLoaderBind_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMillisSinceLastDataLoaderBind(long j) {
            this.bitField0_ |= Http2.INITIAL_MAX_FRAME_SIZE;
            this.millisSinceLastDataLoaderBind_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMillisSinceLastDataLoaderBind() {
            this.bitField0_ &= -16385;
            this.millisSinceLastDataLoaderBind_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasDataLoaderBindDelayMillis() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public long getDataLoaderBindDelayMillis() {
            return this.dataLoaderBindDelayMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataLoaderBindDelayMillis(long j) {
            this.bitField0_ |= 32768;
            this.dataLoaderBindDelayMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataLoaderBindDelayMillis() {
            this.bitField0_ &= -32769;
            this.dataLoaderBindDelayMillis_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasTotalDelayedReads() {
            return (this.bitField0_ & 65536) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public int getTotalDelayedReads() {
            return this.totalDelayedReads_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalDelayedReads(int i) {
            this.bitField0_ |= 65536;
            this.totalDelayedReads_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalDelayedReads() {
            this.bitField0_ &= -65537;
            this.totalDelayedReads_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasTotalFailedReads() {
            return (this.bitField0_ & 131072) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public int getTotalFailedReads() {
            return this.totalFailedReads_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalFailedReads(int i) {
            this.bitField0_ |= 131072;
            this.totalFailedReads_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalFailedReads() {
            this.bitField0_ &= -131073;
            this.totalFailedReads_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasLastReadErrorUid() {
            return (this.bitField0_ & Constants.DROPBOX_MAX_SIZE) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public int getLastReadErrorUid() {
            return this.lastReadErrorUid_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastReadErrorUid(int i) {
            this.bitField0_ |= Constants.DROPBOX_MAX_SIZE;
            this.lastReadErrorUid_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastReadErrorUid() {
            this.bitField0_ &= -262145;
            this.lastReadErrorUid_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasLastReadErrorMillisSince() {
            return (this.bitField0_ & 524288) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public long getLastReadErrorMillisSince() {
            return this.lastReadErrorMillisSince_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastReadErrorMillisSince(long j) {
            this.bitField0_ |= 524288;
            this.lastReadErrorMillisSince_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastReadErrorMillisSince() {
            this.bitField0_ &= -524289;
            this.lastReadErrorMillisSince_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasLastReadErrorCode() {
            return (this.bitField0_ & 1048576) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public int getLastReadErrorCode() {
            return this.lastReadErrorCode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastReadErrorCode(int i) {
            this.bitField0_ |= 1048576;
            this.lastReadErrorCode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastReadErrorCode() {
            this.bitField0_ &= -1048577;
            this.lastReadErrorCode_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public boolean hasTotalDelayedReadsDurationMillis() {
            return (this.bitField0_ & 2097152) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
        public long getTotalDelayedReadsDurationMillis() {
            return this.totalDelayedReadsDurationMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalDelayedReadsDurationMillis(long j) {
            this.bitField0_ |= 2097152;
            this.totalDelayedReadsDurationMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalDelayedReadsDurationMillis() {
            this.bitField0_ &= -2097153;
            this.totalDelayedReadsDurationMillis_ = 0L;
        }

        public static AppCrashOccurred parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AppCrashOccurred parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AppCrashOccurred parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AppCrashOccurred parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AppCrashOccurred parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AppCrashOccurred parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AppCrashOccurred parseFrom(InputStream inputStream) throws IOException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppCrashOccurred parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppCrashOccurred parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AppCrashOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppCrashOccurred parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppCrashOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppCrashOccurred parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AppCrashOccurred parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppCrashOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AppCrashOccurred appCrashOccurred) {
            return DEFAULT_INSTANCE.createBuilder(appCrashOccurred);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AppCrashOccurred, Builder> implements AppCrashOccurredOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(AppCrashOccurred.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasUid() {
                return ((AppCrashOccurred) this.instance).hasUid();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getUid() {
                return ((AppCrashOccurred) this.instance).getUid();
            }

            public Builder setUid(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setUid(i);
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearUid();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasEventType() {
                return ((AppCrashOccurred) this.instance).hasEventType();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public String getEventType() {
                return ((AppCrashOccurred) this.instance).getEventType();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public ByteString getEventTypeBytes() {
                return ((AppCrashOccurred) this.instance).getEventTypeBytes();
            }

            public Builder setEventType(String str) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setEventType(str);
                return this;
            }

            public Builder clearEventType() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearEventType();
                return this;
            }

            public Builder setEventTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setEventTypeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasProcessName() {
                return ((AppCrashOccurred) this.instance).hasProcessName();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public String getProcessName() {
                return ((AppCrashOccurred) this.instance).getProcessName();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public ByteString getProcessNameBytes() {
                return ((AppCrashOccurred) this.instance).getProcessNameBytes();
            }

            public Builder setProcessName(String str) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setProcessName(str);
                return this;
            }

            public Builder clearProcessName() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearProcessName();
                return this;
            }

            public Builder setProcessNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setProcessNameBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasPid() {
                return ((AppCrashOccurred) this.instance).hasPid();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getPid() {
                return ((AppCrashOccurred) this.instance).getPid();
            }

            public Builder setPid(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setPid(i);
                return this;
            }

            public Builder clearPid() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearPid();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasPackageName() {
                return ((AppCrashOccurred) this.instance).hasPackageName();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public String getPackageName() {
                return ((AppCrashOccurred) this.instance).getPackageName();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public ByteString getPackageNameBytes() {
                return ((AppCrashOccurred) this.instance).getPackageNameBytes();
            }

            public Builder setPackageName(String str) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setPackageName(str);
                return this;
            }

            public Builder clearPackageName() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearPackageName();
                return this;
            }

            public Builder setPackageNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setPackageNameBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasIsInstantApp() {
                return ((AppCrashOccurred) this.instance).hasIsInstantApp();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public InstantApp getIsInstantApp() {
                return ((AppCrashOccurred) this.instance).getIsInstantApp();
            }

            public Builder setIsInstantApp(InstantApp instantApp) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setIsInstantApp(instantApp);
                return this;
            }

            public Builder clearIsInstantApp() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearIsInstantApp();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasForegroundState() {
                return ((AppCrashOccurred) this.instance).hasForegroundState();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public ForegroundState getForegroundState() {
                return ((AppCrashOccurred) this.instance).getForegroundState();
            }

            public Builder setForegroundState(ForegroundState foregroundState) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setForegroundState(foregroundState);
                return this;
            }

            public Builder clearForegroundState() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearForegroundState();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasErrorSource() {
                return ((AppCrashOccurred) this.instance).hasErrorSource();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public ErrorSource getErrorSource() {
                return ((AppCrashOccurred) this.instance).getErrorSource();
            }

            public Builder setErrorSource(ErrorSource errorSource) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setErrorSource(errorSource);
                return this;
            }

            public Builder clearErrorSource() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearErrorSource();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasIsIncremental() {
                return ((AppCrashOccurred) this.instance).hasIsIncremental();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean getIsIncremental() {
                return ((AppCrashOccurred) this.instance).getIsIncremental();
            }

            public Builder setIsIncremental(boolean z) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setIsIncremental(z);
                return this;
            }

            public Builder clearIsIncremental() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearIsIncremental();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasLoadingProgress() {
                return ((AppCrashOccurred) this.instance).hasLoadingProgress();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public float getLoadingProgress() {
                return ((AppCrashOccurred) this.instance).getLoadingProgress();
            }

            public Builder setLoadingProgress(float f) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setLoadingProgress(f);
                return this;
            }

            public Builder clearLoadingProgress() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearLoadingProgress();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasMillisSinceOldestPendingRead() {
                return ((AppCrashOccurred) this.instance).hasMillisSinceOldestPendingRead();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public long getMillisSinceOldestPendingRead() {
                return ((AppCrashOccurred) this.instance).getMillisSinceOldestPendingRead();
            }

            public Builder setMillisSinceOldestPendingRead(long j) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setMillisSinceOldestPendingRead(j);
                return this;
            }

            public Builder clearMillisSinceOldestPendingRead() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearMillisSinceOldestPendingRead();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasStorageHealthCode() {
                return ((AppCrashOccurred) this.instance).hasStorageHealthCode();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getStorageHealthCode() {
                return ((AppCrashOccurred) this.instance).getStorageHealthCode();
            }

            public Builder setStorageHealthCode(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setStorageHealthCode(i);
                return this;
            }

            public Builder clearStorageHealthCode() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearStorageHealthCode();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasDataLoaderStatusCode() {
                return ((AppCrashOccurred) this.instance).hasDataLoaderStatusCode();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getDataLoaderStatusCode() {
                return ((AppCrashOccurred) this.instance).getDataLoaderStatusCode();
            }

            public Builder setDataLoaderStatusCode(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setDataLoaderStatusCode(i);
                return this;
            }

            public Builder clearDataLoaderStatusCode() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearDataLoaderStatusCode();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasReadLogsEnabled() {
                return ((AppCrashOccurred) this.instance).hasReadLogsEnabled();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean getReadLogsEnabled() {
                return ((AppCrashOccurred) this.instance).getReadLogsEnabled();
            }

            public Builder setReadLogsEnabled(boolean z) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setReadLogsEnabled(z);
                return this;
            }

            public Builder clearReadLogsEnabled() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearReadLogsEnabled();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasMillisSinceLastDataLoaderBind() {
                return ((AppCrashOccurred) this.instance).hasMillisSinceLastDataLoaderBind();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public long getMillisSinceLastDataLoaderBind() {
                return ((AppCrashOccurred) this.instance).getMillisSinceLastDataLoaderBind();
            }

            public Builder setMillisSinceLastDataLoaderBind(long j) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setMillisSinceLastDataLoaderBind(j);
                return this;
            }

            public Builder clearMillisSinceLastDataLoaderBind() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearMillisSinceLastDataLoaderBind();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasDataLoaderBindDelayMillis() {
                return ((AppCrashOccurred) this.instance).hasDataLoaderBindDelayMillis();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public long getDataLoaderBindDelayMillis() {
                return ((AppCrashOccurred) this.instance).getDataLoaderBindDelayMillis();
            }

            public Builder setDataLoaderBindDelayMillis(long j) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setDataLoaderBindDelayMillis(j);
                return this;
            }

            public Builder clearDataLoaderBindDelayMillis() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearDataLoaderBindDelayMillis();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasTotalDelayedReads() {
                return ((AppCrashOccurred) this.instance).hasTotalDelayedReads();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getTotalDelayedReads() {
                return ((AppCrashOccurred) this.instance).getTotalDelayedReads();
            }

            public Builder setTotalDelayedReads(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setTotalDelayedReads(i);
                return this;
            }

            public Builder clearTotalDelayedReads() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearTotalDelayedReads();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasTotalFailedReads() {
                return ((AppCrashOccurred) this.instance).hasTotalFailedReads();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getTotalFailedReads() {
                return ((AppCrashOccurred) this.instance).getTotalFailedReads();
            }

            public Builder setTotalFailedReads(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setTotalFailedReads(i);
                return this;
            }

            public Builder clearTotalFailedReads() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearTotalFailedReads();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasLastReadErrorUid() {
                return ((AppCrashOccurred) this.instance).hasLastReadErrorUid();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getLastReadErrorUid() {
                return ((AppCrashOccurred) this.instance).getLastReadErrorUid();
            }

            public Builder setLastReadErrorUid(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setLastReadErrorUid(i);
                return this;
            }

            public Builder clearLastReadErrorUid() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearLastReadErrorUid();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasLastReadErrorMillisSince() {
                return ((AppCrashOccurred) this.instance).hasLastReadErrorMillisSince();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public long getLastReadErrorMillisSince() {
                return ((AppCrashOccurred) this.instance).getLastReadErrorMillisSince();
            }

            public Builder setLastReadErrorMillisSince(long j) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setLastReadErrorMillisSince(j);
                return this;
            }

            public Builder clearLastReadErrorMillisSince() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearLastReadErrorMillisSince();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasLastReadErrorCode() {
                return ((AppCrashOccurred) this.instance).hasLastReadErrorCode();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public int getLastReadErrorCode() {
                return ((AppCrashOccurred) this.instance).getLastReadErrorCode();
            }

            public Builder setLastReadErrorCode(int i) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setLastReadErrorCode(i);
                return this;
            }

            public Builder clearLastReadErrorCode() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearLastReadErrorCode();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public boolean hasTotalDelayedReadsDurationMillis() {
                return ((AppCrashOccurred) this.instance).hasTotalDelayedReadsDurationMillis();
            }

            @Override // stepos.com.android.os.AtomsProto.AppCrashOccurredOrBuilder
            public long getTotalDelayedReadsDurationMillis() {
                return ((AppCrashOccurred) this.instance).getTotalDelayedReadsDurationMillis();
            }

            public Builder setTotalDelayedReadsDurationMillis(long j) {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).setTotalDelayedReadsDurationMillis(j);
                return this;
            }

            public Builder clearTotalDelayedReadsDurationMillis() {
                copyOnWrite();
                ((AppCrashOccurred) this.instance).clearTotalDelayedReadsDurationMillis();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AppCrashOccurred();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဌ\u0007\tဇ\b\nခ\t\u000bဂ\n\fင\u000b\rင\f\u000eဇ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011င\u0010\u0012င\u0011\u0013င\u0012\u0014ဂ\u0013\u0015င\u0014\u0016ဂ\u0015", new Object[]{"bitField0_", "uid_", "eventType_", "processName_", "pid_", "packageName_", "isInstantApp_", InstantApp.internalGetVerifier(), "foregroundState_", ForegroundState.internalGetVerifier(), "errorSource_", ErrorSource.internalGetVerifier(), "isIncremental_", "loadingProgress_", "millisSinceOldestPendingRead_", "storageHealthCode_", "dataLoaderStatusCode_", "readLogsEnabled_", "millisSinceLastDataLoaderBind_", "dataLoaderBindDelayMillis_", "totalDelayedReads_", "totalFailedReads_", "lastReadErrorUid_", "lastReadErrorMillisSince_", "lastReadErrorCode_", "totalDelayedReadsDurationMillis_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AppCrashOccurred> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (AppCrashOccurred.class) {
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
            AppCrashOccurred appCrashOccurred = new AppCrashOccurred();
            DEFAULT_INSTANCE = appCrashOccurred;
            GeneratedMessageLite.registerDefaultInstance(AppCrashOccurred.class, appCrashOccurred);
        }

        public static AppCrashOccurred getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AppCrashOccurred> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ANROccurred extends GeneratedMessageLite<ANROccurred, Builder> implements ANROccurredOrBuilder {
        public static final int DATA_LOADER_BIND_DELAY_MILLIS_FIELD_NUMBER = 16;
        public static final int DATA_LOADER_STATUS_CODE_FIELD_NUMBER = 13;
        private static final ANROccurred DEFAULT_INSTANCE;
        public static final int ERROR_SOURCE_FIELD_NUMBER = 7;
        public static final int FOREGROUND_STATE_FIELD_NUMBER = 6;
        public static final int IS_INCREMENTAL_FIELD_NUMBER = 9;
        public static final int IS_INSTANT_APP_FIELD_NUMBER = 5;
        public static final int LAST_READ_ERROR_CODE_FIELD_NUMBER = 21;
        public static final int LAST_READ_ERROR_MILLIS_SINCE_FIELD_NUMBER = 20;
        public static final int LAST_READ_ERROR_UID_FIELD_NUMBER = 19;
        public static final int LOADING_PROGRESS_FIELD_NUMBER = 10;
        public static final int MILLIS_SINCE_LAST_DATA_LOADER_BIND_FIELD_NUMBER = 15;
        public static final int MILLIS_SINCE_OLDEST_PENDING_READ_FIELD_NUMBER = 11;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 8;
        private static volatile Parser<ANROccurred> PARSER = null;
        public static final int PROCESS_NAME_FIELD_NUMBER = 2;
        public static final int READ_LOGS_ENABLED_FIELD_NUMBER = 14;
        public static final int REASON_FIELD_NUMBER = 4;
        public static final int SHORT_COMPONENT_NAME_FIELD_NUMBER = 3;
        public static final int STORAGE_HEALTH_CODE_FIELD_NUMBER = 12;
        public static final int TOTAL_DELAYED_READS_DURATION_MILLIS_FIELD_NUMBER = 22;
        public static final int TOTAL_DELAYED_READS_FIELD_NUMBER = 17;
        public static final int TOTAL_FAILED_READS_FIELD_NUMBER = 18;
        public static final int UID_FIELD_NUMBER = 1;
        private int bitField0_;
        private long dataLoaderBindDelayMillis_;
        private int dataLoaderStatusCode_;
        private int errorSource_;
        private int foregroundState_;
        private boolean isIncremental_;
        private int isInstantApp_;
        private int lastReadErrorCode_;
        private long lastReadErrorMillisSince_;
        private int lastReadErrorUid_;
        private float loadingProgress_;
        private long millisSinceLastDataLoaderBind_;
        private long millisSinceOldestPendingRead_;
        private boolean readLogsEnabled_;
        private int storageHealthCode_;
        private long totalDelayedReadsDurationMillis_;
        private int totalDelayedReads_;
        private int totalFailedReads_;
        private int uid_;
        private String processName_ = "";
        private String shortComponentName_ = "";
        private String reason_ = "";
        private String packageName_ = "";

        private ANROccurred() {
        }

        public enum InstantApp implements Internal.EnumLite {
            UNAVAILABLE(0),
            FALSE(1),
            TRUE(2);

            public static final int FALSE_VALUE = 1;
            public static final int TRUE_VALUE = 2;
            public static final int UNAVAILABLE_VALUE = 0;
            private static final Internal.EnumLiteMap<InstantApp> internalValueMap = new Internal.EnumLiteMap<InstantApp>() { // from class: stepos.com.android.os.AtomsProto.ANROccurred.InstantApp.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public InstantApp findValueByNumber(int i) {
                    return InstantApp.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static InstantApp valueOf(int i) {
                return forNumber(i);
            }

            public static InstantApp forNumber(int i) {
                if (i == 0) {
                    return UNAVAILABLE;
                }
                if (i == 1) {
                    return FALSE;
                }
                if (i != 2) {
                    return null;
                }
                return TRUE;
            }

            public static Internal.EnumLiteMap<InstantApp> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return InstantAppVerifier.INSTANCE;
            }

            private static final class InstantAppVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new InstantAppVerifier();

                private InstantAppVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return InstantApp.forNumber(i) != null;
                }
            }

            InstantApp(int i) {
                this.value = i;
            }
        }

        public enum ForegroundState implements Internal.EnumLite {
            UNKNOWN(0),
            BACKGROUND(1),
            FOREGROUND(2);

            public static final int BACKGROUND_VALUE = 1;
            public static final int FOREGROUND_VALUE = 2;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<ForegroundState> internalValueMap = new Internal.EnumLiteMap<ForegroundState>() { // from class: stepos.com.android.os.AtomsProto.ANROccurred.ForegroundState.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ForegroundState findValueByNumber(int i) {
                    return ForegroundState.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ForegroundState valueOf(int i) {
                return forNumber(i);
            }

            public static ForegroundState forNumber(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return BACKGROUND;
                }
                if (i != 2) {
                    return null;
                }
                return FOREGROUND;
            }

            public static Internal.EnumLiteMap<ForegroundState> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ForegroundStateVerifier.INSTANCE;
            }

            private static final class ForegroundStateVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ForegroundStateVerifier();

                private ForegroundStateVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return ForegroundState.forNumber(i) != null;
                }
            }

            ForegroundState(int i) {
                this.value = i;
            }
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
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

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasProcessName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public String getProcessName() {
            return this.processName_;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public ByteString getProcessNameBytes() {
            return ByteString.copyFromUtf8(this.processName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessName(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.processName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProcessName() {
            this.bitField0_ &= -3;
            this.processName_ = getDefaultInstance().getProcessName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessNameBytes(ByteString byteString) {
            this.processName_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasShortComponentName() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public String getShortComponentName() {
            return this.shortComponentName_;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public ByteString getShortComponentNameBytes() {
            return ByteString.copyFromUtf8(this.shortComponentName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShortComponentName(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.shortComponentName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShortComponentName() {
            this.bitField0_ &= -5;
            this.shortComponentName_ = getDefaultInstance().getShortComponentName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShortComponentNameBytes(ByteString byteString) {
            this.shortComponentName_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasReason() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.bitField0_ &= -9;
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            this.reason_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasIsInstantApp() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public InstantApp getIsInstantApp() {
            InstantApp instantAppForNumber = InstantApp.forNumber(this.isInstantApp_);
            return instantAppForNumber == null ? InstantApp.UNAVAILABLE : instantAppForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsInstantApp(InstantApp instantApp) {
            this.isInstantApp_ = instantApp.getNumber();
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsInstantApp() {
            this.bitField0_ &= -17;
            this.isInstantApp_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasForegroundState() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public ForegroundState getForegroundState() {
            ForegroundState foregroundStateForNumber = ForegroundState.forNumber(this.foregroundState_);
            return foregroundStateForNumber == null ? ForegroundState.UNKNOWN : foregroundStateForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setForegroundState(ForegroundState foregroundState) {
            this.foregroundState_ = foregroundState.getNumber();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearForegroundState() {
            this.bitField0_ &= -33;
            this.foregroundState_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasErrorSource() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public ErrorSource getErrorSource() {
            ErrorSource errorSourceForNumber = ErrorSource.forNumber(this.errorSource_);
            return errorSourceForNumber == null ? ErrorSource.ERROR_SOURCE_UNKNOWN : errorSourceForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSource(ErrorSource errorSource) {
            this.errorSource_ = errorSource.getNumber();
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorSource() {
            this.bitField0_ &= -65;
            this.errorSource_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasPackageName() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public String getPackageName() {
            return this.packageName_;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public ByteString getPackageNameBytes() {
            return ByteString.copyFromUtf8(this.packageName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageName(String str) {
            str.getClass();
            this.bitField0_ |= 128;
            this.packageName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageName() {
            this.bitField0_ &= -129;
            this.packageName_ = getDefaultInstance().getPackageName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageNameBytes(ByteString byteString) {
            this.packageName_ = byteString.toStringUtf8();
            this.bitField0_ |= 128;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasIsIncremental() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean getIsIncremental() {
            return this.isIncremental_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsIncremental(boolean z) {
            this.bitField0_ |= 256;
            this.isIncremental_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsIncremental() {
            this.bitField0_ &= -257;
            this.isIncremental_ = false;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasLoadingProgress() {
            return (this.bitField0_ & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public float getLoadingProgress() {
            return this.loadingProgress_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoadingProgress(float f) {
            this.bitField0_ |= ConstantsKt.MINIMUM_BLOCK_SIZE;
            this.loadingProgress_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoadingProgress() {
            this.bitField0_ &= -513;
            this.loadingProgress_ = 0.0f;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasMillisSinceOldestPendingRead() {
            return (this.bitField0_ & Segment.SHARE_MINIMUM) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public long getMillisSinceOldestPendingRead() {
            return this.millisSinceOldestPendingRead_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMillisSinceOldestPendingRead(long j) {
            this.bitField0_ |= Segment.SHARE_MINIMUM;
            this.millisSinceOldestPendingRead_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMillisSinceOldestPendingRead() {
            this.bitField0_ &= -1025;
            this.millisSinceOldestPendingRead_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasStorageHealthCode() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public int getStorageHealthCode() {
            return this.storageHealthCode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStorageHealthCode(int i) {
            this.bitField0_ |= 2048;
            this.storageHealthCode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStorageHealthCode() {
            this.bitField0_ &= -2049;
            this.storageHealthCode_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasDataLoaderStatusCode() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public int getDataLoaderStatusCode() {
            return this.dataLoaderStatusCode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataLoaderStatusCode(int i) {
            this.bitField0_ |= 4096;
            this.dataLoaderStatusCode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataLoaderStatusCode() {
            this.bitField0_ &= -4097;
            this.dataLoaderStatusCode_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasReadLogsEnabled() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean getReadLogsEnabled() {
            return this.readLogsEnabled_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReadLogsEnabled(boolean z) {
            this.bitField0_ |= 8192;
            this.readLogsEnabled_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReadLogsEnabled() {
            this.bitField0_ &= -8193;
            this.readLogsEnabled_ = false;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasMillisSinceLastDataLoaderBind() {
            return (this.bitField0_ & Http2.INITIAL_MAX_FRAME_SIZE) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public long getMillisSinceLastDataLoaderBind() {
            return this.millisSinceLastDataLoaderBind_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMillisSinceLastDataLoaderBind(long j) {
            this.bitField0_ |= Http2.INITIAL_MAX_FRAME_SIZE;
            this.millisSinceLastDataLoaderBind_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMillisSinceLastDataLoaderBind() {
            this.bitField0_ &= -16385;
            this.millisSinceLastDataLoaderBind_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasDataLoaderBindDelayMillis() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public long getDataLoaderBindDelayMillis() {
            return this.dataLoaderBindDelayMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataLoaderBindDelayMillis(long j) {
            this.bitField0_ |= 32768;
            this.dataLoaderBindDelayMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataLoaderBindDelayMillis() {
            this.bitField0_ &= -32769;
            this.dataLoaderBindDelayMillis_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasTotalDelayedReads() {
            return (this.bitField0_ & 65536) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public int getTotalDelayedReads() {
            return this.totalDelayedReads_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalDelayedReads(int i) {
            this.bitField0_ |= 65536;
            this.totalDelayedReads_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalDelayedReads() {
            this.bitField0_ &= -65537;
            this.totalDelayedReads_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasTotalFailedReads() {
            return (this.bitField0_ & 131072) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public int getTotalFailedReads() {
            return this.totalFailedReads_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalFailedReads(int i) {
            this.bitField0_ |= 131072;
            this.totalFailedReads_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalFailedReads() {
            this.bitField0_ &= -131073;
            this.totalFailedReads_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasLastReadErrorUid() {
            return (this.bitField0_ & Constants.DROPBOX_MAX_SIZE) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public int getLastReadErrorUid() {
            return this.lastReadErrorUid_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastReadErrorUid(int i) {
            this.bitField0_ |= Constants.DROPBOX_MAX_SIZE;
            this.lastReadErrorUid_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastReadErrorUid() {
            this.bitField0_ &= -262145;
            this.lastReadErrorUid_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasLastReadErrorMillisSince() {
            return (this.bitField0_ & 524288) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public long getLastReadErrorMillisSince() {
            return this.lastReadErrorMillisSince_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastReadErrorMillisSince(long j) {
            this.bitField0_ |= 524288;
            this.lastReadErrorMillisSince_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastReadErrorMillisSince() {
            this.bitField0_ &= -524289;
            this.lastReadErrorMillisSince_ = 0L;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasLastReadErrorCode() {
            return (this.bitField0_ & 1048576) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public int getLastReadErrorCode() {
            return this.lastReadErrorCode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastReadErrorCode(int i) {
            this.bitField0_ |= 1048576;
            this.lastReadErrorCode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastReadErrorCode() {
            this.bitField0_ &= -1048577;
            this.lastReadErrorCode_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public boolean hasTotalDelayedReadsDurationMillis() {
            return (this.bitField0_ & 2097152) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
        public long getTotalDelayedReadsDurationMillis() {
            return this.totalDelayedReadsDurationMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalDelayedReadsDurationMillis(long j) {
            this.bitField0_ |= 2097152;
            this.totalDelayedReadsDurationMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalDelayedReadsDurationMillis() {
            this.bitField0_ &= -2097153;
            this.totalDelayedReadsDurationMillis_ = 0L;
        }

        public static ANROccurred parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ANROccurred parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ANROccurred parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ANROccurred parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ANROccurred parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ANROccurred parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ANROccurred parseFrom(InputStream inputStream) throws IOException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ANROccurred parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ANROccurred parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ANROccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ANROccurred parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ANROccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ANROccurred parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ANROccurred parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ANROccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ANROccurred aNROccurred) {
            return DEFAULT_INSTANCE.createBuilder(aNROccurred);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ANROccurred, Builder> implements ANROccurredOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ANROccurred.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasUid() {
                return ((ANROccurred) this.instance).hasUid();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public int getUid() {
                return ((ANROccurred) this.instance).getUid();
            }

            public Builder setUid(int i) {
                copyOnWrite();
                ((ANROccurred) this.instance).setUid(i);
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearUid();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasProcessName() {
                return ((ANROccurred) this.instance).hasProcessName();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public String getProcessName() {
                return ((ANROccurred) this.instance).getProcessName();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public ByteString getProcessNameBytes() {
                return ((ANROccurred) this.instance).getProcessNameBytes();
            }

            public Builder setProcessName(String str) {
                copyOnWrite();
                ((ANROccurred) this.instance).setProcessName(str);
                return this;
            }

            public Builder clearProcessName() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearProcessName();
                return this;
            }

            public Builder setProcessNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ANROccurred) this.instance).setProcessNameBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasShortComponentName() {
                return ((ANROccurred) this.instance).hasShortComponentName();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public String getShortComponentName() {
                return ((ANROccurred) this.instance).getShortComponentName();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public ByteString getShortComponentNameBytes() {
                return ((ANROccurred) this.instance).getShortComponentNameBytes();
            }

            public Builder setShortComponentName(String str) {
                copyOnWrite();
                ((ANROccurred) this.instance).setShortComponentName(str);
                return this;
            }

            public Builder clearShortComponentName() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearShortComponentName();
                return this;
            }

            public Builder setShortComponentNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ANROccurred) this.instance).setShortComponentNameBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasReason() {
                return ((ANROccurred) this.instance).hasReason();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public String getReason() {
                return ((ANROccurred) this.instance).getReason();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public ByteString getReasonBytes() {
                return ((ANROccurred) this.instance).getReasonBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((ANROccurred) this.instance).setReason(str);
                return this;
            }

            public Builder clearReason() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearReason();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((ANROccurred) this.instance).setReasonBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasIsInstantApp() {
                return ((ANROccurred) this.instance).hasIsInstantApp();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public InstantApp getIsInstantApp() {
                return ((ANROccurred) this.instance).getIsInstantApp();
            }

            public Builder setIsInstantApp(InstantApp instantApp) {
                copyOnWrite();
                ((ANROccurred) this.instance).setIsInstantApp(instantApp);
                return this;
            }

            public Builder clearIsInstantApp() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearIsInstantApp();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasForegroundState() {
                return ((ANROccurred) this.instance).hasForegroundState();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public ForegroundState getForegroundState() {
                return ((ANROccurred) this.instance).getForegroundState();
            }

            public Builder setForegroundState(ForegroundState foregroundState) {
                copyOnWrite();
                ((ANROccurred) this.instance).setForegroundState(foregroundState);
                return this;
            }

            public Builder clearForegroundState() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearForegroundState();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasErrorSource() {
                return ((ANROccurred) this.instance).hasErrorSource();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public ErrorSource getErrorSource() {
                return ((ANROccurred) this.instance).getErrorSource();
            }

            public Builder setErrorSource(ErrorSource errorSource) {
                copyOnWrite();
                ((ANROccurred) this.instance).setErrorSource(errorSource);
                return this;
            }

            public Builder clearErrorSource() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearErrorSource();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasPackageName() {
                return ((ANROccurred) this.instance).hasPackageName();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public String getPackageName() {
                return ((ANROccurred) this.instance).getPackageName();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public ByteString getPackageNameBytes() {
                return ((ANROccurred) this.instance).getPackageNameBytes();
            }

            public Builder setPackageName(String str) {
                copyOnWrite();
                ((ANROccurred) this.instance).setPackageName(str);
                return this;
            }

            public Builder clearPackageName() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearPackageName();
                return this;
            }

            public Builder setPackageNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ANROccurred) this.instance).setPackageNameBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasIsIncremental() {
                return ((ANROccurred) this.instance).hasIsIncremental();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean getIsIncremental() {
                return ((ANROccurred) this.instance).getIsIncremental();
            }

            public Builder setIsIncremental(boolean z) {
                copyOnWrite();
                ((ANROccurred) this.instance).setIsIncremental(z);
                return this;
            }

            public Builder clearIsIncremental() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearIsIncremental();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasLoadingProgress() {
                return ((ANROccurred) this.instance).hasLoadingProgress();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public float getLoadingProgress() {
                return ((ANROccurred) this.instance).getLoadingProgress();
            }

            public Builder setLoadingProgress(float f) {
                copyOnWrite();
                ((ANROccurred) this.instance).setLoadingProgress(f);
                return this;
            }

            public Builder clearLoadingProgress() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearLoadingProgress();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasMillisSinceOldestPendingRead() {
                return ((ANROccurred) this.instance).hasMillisSinceOldestPendingRead();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public long getMillisSinceOldestPendingRead() {
                return ((ANROccurred) this.instance).getMillisSinceOldestPendingRead();
            }

            public Builder setMillisSinceOldestPendingRead(long j) {
                copyOnWrite();
                ((ANROccurred) this.instance).setMillisSinceOldestPendingRead(j);
                return this;
            }

            public Builder clearMillisSinceOldestPendingRead() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearMillisSinceOldestPendingRead();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasStorageHealthCode() {
                return ((ANROccurred) this.instance).hasStorageHealthCode();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public int getStorageHealthCode() {
                return ((ANROccurred) this.instance).getStorageHealthCode();
            }

            public Builder setStorageHealthCode(int i) {
                copyOnWrite();
                ((ANROccurred) this.instance).setStorageHealthCode(i);
                return this;
            }

            public Builder clearStorageHealthCode() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearStorageHealthCode();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasDataLoaderStatusCode() {
                return ((ANROccurred) this.instance).hasDataLoaderStatusCode();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public int getDataLoaderStatusCode() {
                return ((ANROccurred) this.instance).getDataLoaderStatusCode();
            }

            public Builder setDataLoaderStatusCode(int i) {
                copyOnWrite();
                ((ANROccurred) this.instance).setDataLoaderStatusCode(i);
                return this;
            }

            public Builder clearDataLoaderStatusCode() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearDataLoaderStatusCode();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasReadLogsEnabled() {
                return ((ANROccurred) this.instance).hasReadLogsEnabled();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean getReadLogsEnabled() {
                return ((ANROccurred) this.instance).getReadLogsEnabled();
            }

            public Builder setReadLogsEnabled(boolean z) {
                copyOnWrite();
                ((ANROccurred) this.instance).setReadLogsEnabled(z);
                return this;
            }

            public Builder clearReadLogsEnabled() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearReadLogsEnabled();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasMillisSinceLastDataLoaderBind() {
                return ((ANROccurred) this.instance).hasMillisSinceLastDataLoaderBind();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public long getMillisSinceLastDataLoaderBind() {
                return ((ANROccurred) this.instance).getMillisSinceLastDataLoaderBind();
            }

            public Builder setMillisSinceLastDataLoaderBind(long j) {
                copyOnWrite();
                ((ANROccurred) this.instance).setMillisSinceLastDataLoaderBind(j);
                return this;
            }

            public Builder clearMillisSinceLastDataLoaderBind() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearMillisSinceLastDataLoaderBind();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasDataLoaderBindDelayMillis() {
                return ((ANROccurred) this.instance).hasDataLoaderBindDelayMillis();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public long getDataLoaderBindDelayMillis() {
                return ((ANROccurred) this.instance).getDataLoaderBindDelayMillis();
            }

            public Builder setDataLoaderBindDelayMillis(long j) {
                copyOnWrite();
                ((ANROccurred) this.instance).setDataLoaderBindDelayMillis(j);
                return this;
            }

            public Builder clearDataLoaderBindDelayMillis() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearDataLoaderBindDelayMillis();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasTotalDelayedReads() {
                return ((ANROccurred) this.instance).hasTotalDelayedReads();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public int getTotalDelayedReads() {
                return ((ANROccurred) this.instance).getTotalDelayedReads();
            }

            public Builder setTotalDelayedReads(int i) {
                copyOnWrite();
                ((ANROccurred) this.instance).setTotalDelayedReads(i);
                return this;
            }

            public Builder clearTotalDelayedReads() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearTotalDelayedReads();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasTotalFailedReads() {
                return ((ANROccurred) this.instance).hasTotalFailedReads();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public int getTotalFailedReads() {
                return ((ANROccurred) this.instance).getTotalFailedReads();
            }

            public Builder setTotalFailedReads(int i) {
                copyOnWrite();
                ((ANROccurred) this.instance).setTotalFailedReads(i);
                return this;
            }

            public Builder clearTotalFailedReads() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearTotalFailedReads();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasLastReadErrorUid() {
                return ((ANROccurred) this.instance).hasLastReadErrorUid();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public int getLastReadErrorUid() {
                return ((ANROccurred) this.instance).getLastReadErrorUid();
            }

            public Builder setLastReadErrorUid(int i) {
                copyOnWrite();
                ((ANROccurred) this.instance).setLastReadErrorUid(i);
                return this;
            }

            public Builder clearLastReadErrorUid() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearLastReadErrorUid();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasLastReadErrorMillisSince() {
                return ((ANROccurred) this.instance).hasLastReadErrorMillisSince();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public long getLastReadErrorMillisSince() {
                return ((ANROccurred) this.instance).getLastReadErrorMillisSince();
            }

            public Builder setLastReadErrorMillisSince(long j) {
                copyOnWrite();
                ((ANROccurred) this.instance).setLastReadErrorMillisSince(j);
                return this;
            }

            public Builder clearLastReadErrorMillisSince() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearLastReadErrorMillisSince();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasLastReadErrorCode() {
                return ((ANROccurred) this.instance).hasLastReadErrorCode();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public int getLastReadErrorCode() {
                return ((ANROccurred) this.instance).getLastReadErrorCode();
            }

            public Builder setLastReadErrorCode(int i) {
                copyOnWrite();
                ((ANROccurred) this.instance).setLastReadErrorCode(i);
                return this;
            }

            public Builder clearLastReadErrorCode() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearLastReadErrorCode();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public boolean hasTotalDelayedReadsDurationMillis() {
                return ((ANROccurred) this.instance).hasTotalDelayedReadsDurationMillis();
            }

            @Override // stepos.com.android.os.AtomsProto.ANROccurredOrBuilder
            public long getTotalDelayedReadsDurationMillis() {
                return ((ANROccurred) this.instance).getTotalDelayedReadsDurationMillis();
            }

            public Builder setTotalDelayedReadsDurationMillis(long j) {
                copyOnWrite();
                ((ANROccurred) this.instance).setTotalDelayedReadsDurationMillis(j);
                return this;
            }

            public Builder clearTotalDelayedReadsDurationMillis() {
                copyOnWrite();
                ((ANROccurred) this.instance).clearTotalDelayedReadsDurationMillis();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ANROccurred();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဈ\u0007\tဇ\b\nခ\t\u000bဂ\n\fင\u000b\rင\f\u000eဇ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011င\u0010\u0012င\u0011\u0013င\u0012\u0014ဂ\u0013\u0015င\u0014\u0016ဂ\u0015", new Object[]{"bitField0_", "uid_", "processName_", "shortComponentName_", "reason_", "isInstantApp_", InstantApp.internalGetVerifier(), "foregroundState_", ForegroundState.internalGetVerifier(), "errorSource_", ErrorSource.internalGetVerifier(), "packageName_", "isIncremental_", "loadingProgress_", "millisSinceOldestPendingRead_", "storageHealthCode_", "dataLoaderStatusCode_", "readLogsEnabled_", "millisSinceLastDataLoaderBind_", "dataLoaderBindDelayMillis_", "totalDelayedReads_", "totalFailedReads_", "lastReadErrorUid_", "lastReadErrorMillisSince_", "lastReadErrorCode_", "totalDelayedReadsDurationMillis_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ANROccurred> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ANROccurred.class) {
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
            ANROccurred aNROccurred = new ANROccurred();
            DEFAULT_INSTANCE = aNROccurred;
            GeneratedMessageLite.registerDefaultInstance(ANROccurred.class, aNROccurred);
        }

        public static ANROccurred getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ANROccurred> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SystemServerWatchdogOccurred extends GeneratedMessageLite<SystemServerWatchdogOccurred, Builder> implements SystemServerWatchdogOccurredOrBuilder {
        private static final SystemServerWatchdogOccurred DEFAULT_INSTANCE;
        private static volatile Parser<SystemServerWatchdogOccurred> PARSER = null;
        public static final int SUBJECT_FIELD_NUMBER = 1;
        private int bitField0_;
        private String subject_ = "";

        private SystemServerWatchdogOccurred() {
        }

        @Override // stepos.com.android.os.AtomsProto.SystemServerWatchdogOccurredOrBuilder
        public boolean hasSubject() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.SystemServerWatchdogOccurredOrBuilder
        public String getSubject() {
            return this.subject_;
        }

        @Override // stepos.com.android.os.AtomsProto.SystemServerWatchdogOccurredOrBuilder
        public ByteString getSubjectBytes() {
            return ByteString.copyFromUtf8(this.subject_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubject(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.subject_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubject() {
            this.bitField0_ &= -2;
            this.subject_ = getDefaultInstance().getSubject();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubjectBytes(ByteString byteString) {
            this.subject_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static SystemServerWatchdogOccurred parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SystemServerWatchdogOccurred parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SystemServerWatchdogOccurred parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SystemServerWatchdogOccurred parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SystemServerWatchdogOccurred parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SystemServerWatchdogOccurred parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SystemServerWatchdogOccurred parseFrom(InputStream inputStream) throws IOException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SystemServerWatchdogOccurred parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SystemServerWatchdogOccurred parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SystemServerWatchdogOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SystemServerWatchdogOccurred parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SystemServerWatchdogOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SystemServerWatchdogOccurred parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SystemServerWatchdogOccurred parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SystemServerWatchdogOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SystemServerWatchdogOccurred systemServerWatchdogOccurred) {
            return DEFAULT_INSTANCE.createBuilder(systemServerWatchdogOccurred);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SystemServerWatchdogOccurred, Builder> implements SystemServerWatchdogOccurredOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SystemServerWatchdogOccurred.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.SystemServerWatchdogOccurredOrBuilder
            public boolean hasSubject() {
                return ((SystemServerWatchdogOccurred) this.instance).hasSubject();
            }

            @Override // stepos.com.android.os.AtomsProto.SystemServerWatchdogOccurredOrBuilder
            public String getSubject() {
                return ((SystemServerWatchdogOccurred) this.instance).getSubject();
            }

            @Override // stepos.com.android.os.AtomsProto.SystemServerWatchdogOccurredOrBuilder
            public ByteString getSubjectBytes() {
                return ((SystemServerWatchdogOccurred) this.instance).getSubjectBytes();
            }

            public Builder setSubject(String str) {
                copyOnWrite();
                ((SystemServerWatchdogOccurred) this.instance).setSubject(str);
                return this;
            }

            public Builder clearSubject() {
                copyOnWrite();
                ((SystemServerWatchdogOccurred) this.instance).clearSubject();
                return this;
            }

            public Builder setSubjectBytes(ByteString byteString) {
                copyOnWrite();
                ((SystemServerWatchdogOccurred) this.instance).setSubjectBytes(byteString);
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
                    return new SystemServerWatchdogOccurred();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "subject_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SystemServerWatchdogOccurred> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SystemServerWatchdogOccurred.class) {
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
            SystemServerWatchdogOccurred systemServerWatchdogOccurred = new SystemServerWatchdogOccurred();
            DEFAULT_INSTANCE = systemServerWatchdogOccurred;
            GeneratedMessageLite.registerDefaultInstance(SystemServerWatchdogOccurred.class, systemServerWatchdogOccurred);
        }

        public static SystemServerWatchdogOccurred getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SystemServerWatchdogOccurred> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventWifiCodeReport extends GeneratedMessageLite<StepOSEventWifiCodeReport, Builder> implements StepOSEventWifiCodeReportOrBuilder {
        private static final StepOSEventWifiCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventWifiCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventWifiCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventWifiCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventWifiCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventWifiCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventWifiCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventWifiCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventWifiCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventWifiCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventWifiCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventWifiCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventWifiCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventWifiCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventWifiCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventWifiCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventWifiCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventWifiCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventWifiCodeReport stepOSEventWifiCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventWifiCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventWifiCodeReport, Builder> implements StepOSEventWifiCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventWifiCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventWifiCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventWifiCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventWifiCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventWifiCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventWifiCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventWifiCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventWifiCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventWifiCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventWifiCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventWifiCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventWifiCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventWifiCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventWifiCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventWifiCodeReport.class) {
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
            StepOSEventWifiCodeReport stepOSEventWifiCodeReport = new StepOSEventWifiCodeReport();
            DEFAULT_INSTANCE = stepOSEventWifiCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventWifiCodeReport.class, stepOSEventWifiCodeReport);
        }

        public static StepOSEventWifiCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventWifiCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventNfcCodeReport extends GeneratedMessageLite<StepOSEventNfcCodeReport, Builder> implements StepOSEventNfcCodeReportOrBuilder {
        private static final StepOSEventNfcCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventNfcCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventNfcCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventNfcCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventNfcCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventNfcCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventNfcCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventNfcCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventNfcCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventNfcCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventNfcCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventNfcCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventNfcCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventNfcCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventNfcCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventNfcCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventNfcCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventNfcCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventNfcCodeReport stepOSEventNfcCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventNfcCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventNfcCodeReport, Builder> implements StepOSEventNfcCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventNfcCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventNfcCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventNfcCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventNfcCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventNfcCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventNfcCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventNfcCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventNfcCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventNfcCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventNfcCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventNfcCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventNfcCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventNfcCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventNfcCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventNfcCodeReport.class) {
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
            StepOSEventNfcCodeReport stepOSEventNfcCodeReport = new StepOSEventNfcCodeReport();
            DEFAULT_INSTANCE = stepOSEventNfcCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventNfcCodeReport.class, stepOSEventNfcCodeReport);
        }

        public static StepOSEventNfcCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventNfcCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventGNSSCodeReport extends GeneratedMessageLite<StepOSEventGNSSCodeReport, Builder> implements StepOSEventGNSSCodeReportOrBuilder {
        private static final StepOSEventGNSSCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventGNSSCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventGNSSCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventGNSSCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventGNSSCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventGNSSCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventGNSSCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventGNSSCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventGNSSCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventGNSSCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventGNSSCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventGNSSCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventGNSSCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventGNSSCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventGNSSCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventGNSSCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventGNSSCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventGNSSCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventGNSSCodeReport stepOSEventGNSSCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventGNSSCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventGNSSCodeReport, Builder> implements StepOSEventGNSSCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventGNSSCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventGNSSCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventGNSSCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventGNSSCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventGNSSCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventGNSSCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventGNSSCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventGNSSCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventGNSSCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventGNSSCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventGNSSCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventGNSSCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventGNSSCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventGNSSCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventGNSSCodeReport.class) {
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
            StepOSEventGNSSCodeReport stepOSEventGNSSCodeReport = new StepOSEventGNSSCodeReport();
            DEFAULT_INSTANCE = stepOSEventGNSSCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventGNSSCodeReport.class, stepOSEventGNSSCodeReport);
        }

        public static StepOSEventGNSSCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventGNSSCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventBluetoothCodeReport extends GeneratedMessageLite<StepOSEventBluetoothCodeReport, Builder> implements StepOSEventBluetoothCodeReportOrBuilder {
        private static final StepOSEventBluetoothCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventBluetoothCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventBluetoothCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventBluetoothCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventBluetoothCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventBluetoothCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventBluetoothCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventBluetoothCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventBluetoothCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventBluetoothCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventBluetoothCodeReport stepOSEventBluetoothCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventBluetoothCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventBluetoothCodeReport, Builder> implements StepOSEventBluetoothCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventBluetoothCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventBluetoothCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventBluetoothCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventBluetoothCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventBluetoothCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventBluetoothCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventBluetoothCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventBluetoothCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventBluetoothCodeReport.class) {
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
            StepOSEventBluetoothCodeReport stepOSEventBluetoothCodeReport = new StepOSEventBluetoothCodeReport();
            DEFAULT_INSTANCE = stepOSEventBluetoothCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventBluetoothCodeReport.class, stepOSEventBluetoothCodeReport);
        }

        public static StepOSEventBluetoothCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventBluetoothCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventModemCodeReport extends GeneratedMessageLite<StepOSEventModemCodeReport, Builder> implements StepOSEventModemCodeReportOrBuilder {
        private static final StepOSEventModemCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventModemCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventModemCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventModemCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventModemCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventModemCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventModemCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventModemCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventModemCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventModemCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventModemCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventModemCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventModemCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventModemCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventModemCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventModemCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventModemCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventModemCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventModemCodeReport stepOSEventModemCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventModemCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventModemCodeReport, Builder> implements StepOSEventModemCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventModemCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventModemCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventModemCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventModemCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventModemCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventModemCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventModemCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventModemCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventModemCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventModemCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventModemCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventModemCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventModemCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventModemCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventModemCodeReport.class) {
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
            StepOSEventModemCodeReport stepOSEventModemCodeReport = new StepOSEventModemCodeReport();
            DEFAULT_INSTANCE = stepOSEventModemCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventModemCodeReport.class, stepOSEventModemCodeReport);
        }

        public static StepOSEventModemCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventModemCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventPerformanceCodeReport extends GeneratedMessageLite<StepOSEventPerformanceCodeReport, Builder> implements StepOSEventPerformanceCodeReportOrBuilder {
        private static final StepOSEventPerformanceCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventPerformanceCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventPerformanceCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventPerformanceCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventPerformanceCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventPerformanceCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventPerformanceCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventPerformanceCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventPerformanceCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventPerformanceCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventPerformanceCodeReport stepOSEventPerformanceCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventPerformanceCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventPerformanceCodeReport, Builder> implements StepOSEventPerformanceCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventPerformanceCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventPerformanceCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventPerformanceCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventPerformanceCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPerformanceCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventPerformanceCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventPerformanceCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventPerformanceCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventPerformanceCodeReport.class) {
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
            StepOSEventPerformanceCodeReport stepOSEventPerformanceCodeReport = new StepOSEventPerformanceCodeReport();
            DEFAULT_INSTANCE = stepOSEventPerformanceCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventPerformanceCodeReport.class, stepOSEventPerformanceCodeReport);
        }

        public static StepOSEventPerformanceCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventPerformanceCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventPowerCodeReport extends GeneratedMessageLite<StepOSEventPowerCodeReport, Builder> implements StepOSEventPowerCodeReportOrBuilder {
        private static final StepOSEventPowerCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventPowerCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventPowerCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventPowerCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventPowerCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventPowerCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventPowerCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventPowerCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventPowerCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventPowerCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventPowerCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventPowerCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventPowerCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventPowerCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventPowerCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventPowerCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventPowerCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventPowerCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventPowerCodeReport stepOSEventPowerCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventPowerCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventPowerCodeReport, Builder> implements StepOSEventPowerCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventPowerCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventPowerCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventPowerCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventPowerCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventPowerCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventPowerCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventPowerCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventPowerCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventPowerCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventPowerCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventPowerCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventPowerCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventPowerCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventPowerCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventPowerCodeReport.class) {
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
            StepOSEventPowerCodeReport stepOSEventPowerCodeReport = new StepOSEventPowerCodeReport();
            DEFAULT_INSTANCE = stepOSEventPowerCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventPowerCodeReport.class, stepOSEventPowerCodeReport);
        }

        public static StepOSEventPowerCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventPowerCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventStabilityCodeReport extends GeneratedMessageLite<StepOSEventStabilityCodeReport, Builder> implements StepOSEventStabilityCodeReportOrBuilder {
        private static final StepOSEventStabilityCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventStabilityCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventStabilityCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventStabilityCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventStabilityCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventStabilityCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventStabilityCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventStabilityCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventStabilityCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventStabilityCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventStabilityCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventStabilityCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventStabilityCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventStabilityCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventStabilityCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventStabilityCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventStabilityCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventStabilityCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventStabilityCodeReport stepOSEventStabilityCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventStabilityCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventStabilityCodeReport, Builder> implements StepOSEventStabilityCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventStabilityCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventStabilityCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventStabilityCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventStabilityCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventStabilityCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventStabilityCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventStabilityCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventStabilityCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventStabilityCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventStabilityCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventStabilityCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventStabilityCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventStabilityCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventStabilityCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventStabilityCodeReport.class) {
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
            StepOSEventStabilityCodeReport stepOSEventStabilityCodeReport = new StepOSEventStabilityCodeReport();
            DEFAULT_INSTANCE = stepOSEventStabilityCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventStabilityCodeReport.class, stepOSEventStabilityCodeReport);
        }

        public static StepOSEventStabilityCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventStabilityCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventKernelCodeReport extends GeneratedMessageLite<StepOSEventKernelCodeReport, Builder> implements StepOSEventKernelCodeReportOrBuilder {
        private static final StepOSEventKernelCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventKernelCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventKernelCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventKernelCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventKernelCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventKernelCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventKernelCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventKernelCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventKernelCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventKernelCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventKernelCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventKernelCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventKernelCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventKernelCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventKernelCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventKernelCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventKernelCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventKernelCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventKernelCodeReport stepOSEventKernelCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventKernelCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventKernelCodeReport, Builder> implements StepOSEventKernelCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventKernelCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventKernelCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventKernelCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventKernelCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventKernelCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventKernelCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventKernelCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventKernelCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventKernelCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventKernelCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventKernelCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventKernelCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventKernelCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventKernelCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventKernelCodeReport.class) {
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
            StepOSEventKernelCodeReport stepOSEventKernelCodeReport = new StepOSEventKernelCodeReport();
            DEFAULT_INSTANCE = stepOSEventKernelCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventKernelCodeReport.class, stepOSEventKernelCodeReport);
        }

        public static StepOSEventKernelCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventKernelCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSEventFrameworkCodeReport extends GeneratedMessageLite<StepOSEventFrameworkCodeReport, Builder> implements StepOSEventFrameworkCodeReportOrBuilder {
        private static final StepOSEventFrameworkCodeReport DEFAULT_INSTANCE;
        public static final int EVENT_CODE_FIELD_NUMBER = 1;
        public static final int EVENT_INFO_FIELD_NUMBER = 3;
        private static volatile Parser<StepOSEventFrameworkCodeReport> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        private int bitField0_;
        private String eventCode_ = "";
        private String time_ = "";
        private String eventInfo_ = "";

        private StepOSEventFrameworkCodeReport() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public ByteString getEventCodeBytes() {
            return ByteString.copyFromUtf8(this.eventCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCode(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.eventCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCode() {
            this.bitField0_ &= -2;
            this.eventCode_ = getDefaultInstance().getEventCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCodeBytes(ByteString byteString) {
            this.eventCode_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public ByteString getTimeBytes() {
            return ByteString.copyFromUtf8(this.time_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.time_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.bitField0_ &= -3;
            this.time_ = getDefaultInstance().getTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeBytes(ByteString byteString) {
            this.time_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
        public ByteString getEventInfoBytes() {
            return ByteString.copyFromUtf8(this.eventInfo_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfo(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.eventInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventInfo() {
            this.bitField0_ &= -5;
            this.eventInfo_ = getDefaultInstance().getEventInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventInfoBytes(ByteString byteString) {
            this.eventInfo_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static StepOSEventFrameworkCodeReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventFrameworkCodeReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSEventFrameworkCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSEventFrameworkCodeReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventFrameworkCodeReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSEventFrameworkCodeReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSEventFrameworkCodeReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSEventFrameworkCodeReport stepOSEventFrameworkCodeReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSEventFrameworkCodeReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSEventFrameworkCodeReport, Builder> implements StepOSEventFrameworkCodeReportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSEventFrameworkCodeReport.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventFrameworkCodeReport) this.instance).hasEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getEventCode();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public ByteString getEventCodeBytes() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getEventCodeBytes();
            }

            public Builder setEventCode(String str) {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).setEventCode(str);
                return this;
            }

            public Builder clearEventCode() {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).clearEventCode();
                return this;
            }

            public Builder setEventCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).setEventCodeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventFrameworkCodeReport) this.instance).hasTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getTime();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public ByteString getTimeBytes() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getTimeBytes();
            }

            public Builder setTime(String str) {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).setTime(str);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).clearTime();
                return this;
            }

            public Builder setTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).setTimeBytes(byteString);
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventFrameworkCodeReport) this.instance).hasEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getEventInfo();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSEventFrameworkCodeReportOrBuilder
            public ByteString getEventInfoBytes() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getEventInfoBytes();
            }

            public Builder setEventInfo(String str) {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).setEventInfo(str);
                return this;
            }

            public Builder clearEventInfo() {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).clearEventInfo();
                return this;
            }

            public Builder setEventInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSEventFrameworkCodeReport) this.instance).setEventInfoBytes(byteString);
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
                    return new StepOSEventFrameworkCodeReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "eventCode_", "time_", "eventInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSEventFrameworkCodeReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSEventFrameworkCodeReport.class) {
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
            StepOSEventFrameworkCodeReport stepOSEventFrameworkCodeReport = new StepOSEventFrameworkCodeReport();
            DEFAULT_INSTANCE = stepOSEventFrameworkCodeReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSEventFrameworkCodeReport.class, stepOSEventFrameworkCodeReport);
        }

        public static StepOSEventFrameworkCodeReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSEventFrameworkCodeReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSSystemTombstoneOccurred extends GeneratedMessageLite<StepOSSystemTombstoneOccurred, Builder> implements StepOSSystemTombstoneOccurredOrBuilder {
        private static final StepOSSystemTombstoneOccurred DEFAULT_INSTANCE;
        private static volatile Parser<StepOSSystemTombstoneOccurred> PARSER = null;
        public static final int PID_FIELD_NUMBER = 1;
        public static final int PROCESS_NAME_FIELD_NUMBER = 2;
        private int bitField0_;
        private int pid_;
        private String processName_ = "";

        private StepOSSystemTombstoneOccurred() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
        public boolean hasPid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
        public int getPid() {
            return this.pid_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPid(int i) {
            this.bitField0_ |= 1;
            this.pid_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPid() {
            this.bitField0_ &= -2;
            this.pid_ = 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
        public boolean hasProcessName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
        public String getProcessName() {
            return this.processName_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
        public ByteString getProcessNameBytes() {
            return ByteString.copyFromUtf8(this.processName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessName(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.processName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProcessName() {
            this.bitField0_ &= -3;
            this.processName_ = getDefaultInstance().getProcessName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessNameBytes(ByteString byteString) {
            this.processName_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        public static StepOSSystemTombstoneOccurred parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(InputStream inputStream) throws IOException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSSystemTombstoneOccurred parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSSystemTombstoneOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSSystemTombstoneOccurred parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSSystemTombstoneOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSSystemTombstoneOccurred parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSSystemTombstoneOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSSystemTombstoneOccurred stepOSSystemTombstoneOccurred) {
            return DEFAULT_INSTANCE.createBuilder(stepOSSystemTombstoneOccurred);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSSystemTombstoneOccurred, Builder> implements StepOSSystemTombstoneOccurredOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSSystemTombstoneOccurred.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
            public boolean hasPid() {
                return ((StepOSSystemTombstoneOccurred) this.instance).hasPid();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
            public int getPid() {
                return ((StepOSSystemTombstoneOccurred) this.instance).getPid();
            }

            public Builder setPid(int i) {
                copyOnWrite();
                ((StepOSSystemTombstoneOccurred) this.instance).setPid(i);
                return this;
            }

            public Builder clearPid() {
                copyOnWrite();
                ((StepOSSystemTombstoneOccurred) this.instance).clearPid();
                return this;
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
            public boolean hasProcessName() {
                return ((StepOSSystemTombstoneOccurred) this.instance).hasProcessName();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
            public String getProcessName() {
                return ((StepOSSystemTombstoneOccurred) this.instance).getProcessName();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemTombstoneOccurredOrBuilder
            public ByteString getProcessNameBytes() {
                return ((StepOSSystemTombstoneOccurred) this.instance).getProcessNameBytes();
            }

            public Builder setProcessName(String str) {
                copyOnWrite();
                ((StepOSSystemTombstoneOccurred) this.instance).setProcessName(str);
                return this;
            }

            public Builder clearProcessName() {
                copyOnWrite();
                ((StepOSSystemTombstoneOccurred) this.instance).clearProcessName();
                return this;
            }

            public Builder setProcessNameBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSSystemTombstoneOccurred) this.instance).setProcessNameBytes(byteString);
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
                    return new StepOSSystemTombstoneOccurred();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"bitField0_", "pid_", "processName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSSystemTombstoneOccurred> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSSystemTombstoneOccurred.class) {
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
            StepOSSystemTombstoneOccurred stepOSSystemTombstoneOccurred = new StepOSSystemTombstoneOccurred();
            DEFAULT_INSTANCE = stepOSSystemTombstoneOccurred;
            GeneratedMessageLite.registerDefaultInstance(StepOSSystemTombstoneOccurred.class, stepOSSystemTombstoneOccurred);
        }

        public static StepOSSystemTombstoneOccurred getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSSystemTombstoneOccurred> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StepOSSystemRestartOccurred extends GeneratedMessageLite<StepOSSystemRestartOccurred, Builder> implements StepOSSystemRestartOccurredOrBuilder {
        private static final StepOSSystemRestartOccurred DEFAULT_INSTANCE;
        private static volatile Parser<StepOSSystemRestartOccurred> PARSER = null;
        public static final int SUBJECT_FIELD_NUMBER = 1;
        private int bitField0_;
        private String subject_ = "";

        private StepOSSystemRestartOccurred() {
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemRestartOccurredOrBuilder
        public boolean hasSubject() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemRestartOccurredOrBuilder
        public String getSubject() {
            return this.subject_;
        }

        @Override // stepos.com.android.os.AtomsProto.StepOSSystemRestartOccurredOrBuilder
        public ByteString getSubjectBytes() {
            return ByteString.copyFromUtf8(this.subject_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubject(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.subject_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubject() {
            this.bitField0_ &= -2;
            this.subject_ = getDefaultInstance().getSubject();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubjectBytes(ByteString byteString) {
            this.subject_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static StepOSSystemRestartOccurred parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSSystemRestartOccurred parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSSystemRestartOccurred parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSSystemRestartOccurred parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSSystemRestartOccurred parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSSystemRestartOccurred parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSSystemRestartOccurred parseFrom(InputStream inputStream) throws IOException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSSystemRestartOccurred parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSSystemRestartOccurred parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSSystemRestartOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSSystemRestartOccurred parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSSystemRestartOccurred) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSSystemRestartOccurred parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSSystemRestartOccurred parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSSystemRestartOccurred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSSystemRestartOccurred stepOSSystemRestartOccurred) {
            return DEFAULT_INSTANCE.createBuilder(stepOSSystemRestartOccurred);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSSystemRestartOccurred, Builder> implements StepOSSystemRestartOccurredOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StepOSSystemRestartOccurred.DEFAULT_INSTANCE);
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemRestartOccurredOrBuilder
            public boolean hasSubject() {
                return ((StepOSSystemRestartOccurred) this.instance).hasSubject();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemRestartOccurredOrBuilder
            public String getSubject() {
                return ((StepOSSystemRestartOccurred) this.instance).getSubject();
            }

            @Override // stepos.com.android.os.AtomsProto.StepOSSystemRestartOccurredOrBuilder
            public ByteString getSubjectBytes() {
                return ((StepOSSystemRestartOccurred) this.instance).getSubjectBytes();
            }

            public Builder setSubject(String str) {
                copyOnWrite();
                ((StepOSSystemRestartOccurred) this.instance).setSubject(str);
                return this;
            }

            public Builder clearSubject() {
                copyOnWrite();
                ((StepOSSystemRestartOccurred) this.instance).clearSubject();
                return this;
            }

            public Builder setSubjectBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSSystemRestartOccurred) this.instance).setSubjectBytes(byteString);
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
                    return new StepOSSystemRestartOccurred();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "subject_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSSystemRestartOccurred> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSSystemRestartOccurred.class) {
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
            StepOSSystemRestartOccurred stepOSSystemRestartOccurred = new StepOSSystemRestartOccurred();
            DEFAULT_INSTANCE = stepOSSystemRestartOccurred;
            GeneratedMessageLite.registerDefaultInstance(StepOSSystemRestartOccurred.class, stepOSSystemRestartOccurred);
        }

        public static StepOSSystemRestartOccurred getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSSystemRestartOccurred> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
