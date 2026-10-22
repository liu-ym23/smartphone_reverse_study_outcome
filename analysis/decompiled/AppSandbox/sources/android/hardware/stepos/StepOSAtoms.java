package android.hardware.stepos;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.io.ConstantsKt;
import okio.Segment;

/* loaded from: classes.dex */
public final class StepOSAtoms {

    public interface AtomOrBuilder extends MessageLiteOrBuilder {
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

        StepOSGamePowerInfoReport getSteposGamePowerInfoReport();

        StepOSSystemRestartOccurred getSteposSystemRestartOccurred();

        StepOSSystemTombstoneOccurred getSteposSystemTombstoneOccurred();

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

        boolean hasSteposGamePowerInfoReport();

        boolean hasSteposSystemRestartOccurred();

        boolean hasSteposSystemTombstoneOccurred();
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

    public interface StepOSGamePowerInfoReportOrBuilder extends MessageLiteOrBuilder {
        float getCurrentAvg();

        float getCurrentMax();

        float getFpsAvg();

        float getFpsMax();

        float getFpsMin();

        String getProcessName();

        ByteString getProcessNameBytes();

        String getSceneName();

        ByteString getSceneNameBytes();

        float getTemperatureAvg();

        float getTemperatureMax();

        float getVoltageAvg();

        String getWindowingMode();

        ByteString getWindowingModeBytes();

        boolean hasCurrentAvg();

        boolean hasCurrentMax();

        boolean hasFpsAvg();

        boolean hasFpsMax();

        boolean hasFpsMin();

        boolean hasProcessName();

        boolean hasSceneName();

        boolean hasTemperatureAvg();

        boolean hasTemperatureMax();

        boolean hasVoltageAvg();

        boolean hasWindowingMode();
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

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private StepOSAtoms() {
    }

    public static final class Atom extends GeneratedMessageLite<Atom, Builder> implements AtomOrBuilder {
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
        public static final int STEPOS_GAME_POWER_INFO_REPORT_FIELD_NUMBER = 110002;
        public static final int STEPOS_SYSTEM_RESTART_OCCURRED_FIELD_NUMBER = 110000;
        public static final int STEPOS_SYSTEM_TOMBSTONE_OCCURRED_FIELD_NUMBER = 110001;
        private int bitField0_;
        private int pushedCase_ = 0;
        private Object pushed_;

        private Atom() {
        }

        public enum PushedCase {
            STEPOS_SYSTEM_RESTART_OCCURRED(110000),
            STEPOS_SYSTEM_TOMBSTONE_OCCURRED(110001),
            STEPOS_GAME_POWER_INFO_REPORT(Atom.STEPOS_GAME_POWER_INFO_REPORT_FIELD_NUMBER),
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
                if (i != 0) {
                    switch (i) {
                        case 110000:
                            return STEPOS_SYSTEM_RESTART_OCCURRED;
                        case 110001:
                            return STEPOS_SYSTEM_TOMBSTONE_OCCURRED;
                        case Atom.STEPOS_GAME_POWER_INFO_REPORT_FIELD_NUMBER /* 110002 */:
                            return STEPOS_GAME_POWER_INFO_REPORT;
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
                return PUSHED_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public PushedCase getPushedCase() {
            return PushedCase.forNumber(this.pushedCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPushed() {
            this.pushedCase_ = 0;
            this.pushed_ = null;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposSystemRestartOccurred() {
            return this.pushedCase_ == 110000;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposSystemTombstoneOccurred() {
            return this.pushedCase_ == 110001;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposGamePowerInfoReport() {
            return this.pushedCase_ == 110002;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public StepOSGamePowerInfoReport getSteposGamePowerInfoReport() {
            if (this.pushedCase_ == 110002) {
                return (StepOSGamePowerInfoReport) this.pushed_;
            }
            return StepOSGamePowerInfoReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSteposGamePowerInfoReport(StepOSGamePowerInfoReport stepOSGamePowerInfoReport) {
            stepOSGamePowerInfoReport.getClass();
            this.pushed_ = stepOSGamePowerInfoReport;
            this.pushedCase_ = STEPOS_GAME_POWER_INFO_REPORT_FIELD_NUMBER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSteposGamePowerInfoReport(StepOSGamePowerInfoReport stepOSGamePowerInfoReport) {
            stepOSGamePowerInfoReport.getClass();
            if (this.pushedCase_ == 110002 && this.pushed_ != StepOSGamePowerInfoReport.getDefaultInstance()) {
                this.pushed_ = StepOSGamePowerInfoReport.newBuilder((StepOSGamePowerInfoReport) this.pushed_).mergeFrom((StepOSGamePowerInfoReport.Builder) stepOSGamePowerInfoReport).buildPartial();
            } else {
                this.pushed_ = stepOSGamePowerInfoReport;
            }
            this.pushedCase_ = STEPOS_GAME_POWER_INFO_REPORT_FIELD_NUMBER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSteposGamePowerInfoReport() {
            if (this.pushedCase_ == 110002) {
                this.pushedCase_ = 0;
                this.pushed_ = null;
            }
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventWifiCodeReport() {
            return this.pushedCase_ == 120000;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventNfcCodeReport() {
            return this.pushedCase_ == 120001;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventGnssCodeReport() {
            return this.pushedCase_ == 120002;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventBluetoothCodeReport() {
            return this.pushedCase_ == 120003;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventModemCodeReport() {
            return this.pushedCase_ == 120004;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventPerformanceCodeReport() {
            return this.pushedCase_ == 120005;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventPowerCodeReport() {
            return this.pushedCase_ == 120006;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventStabilityCodeReport() {
            return this.pushedCase_ == 120007;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventKernelCodeReport() {
            return this.pushedCase_ == 120008;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
        public boolean hasSteposEventFrameworkCodeReport() {
            return this.pushedCase_ == 120009;
        }

        @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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
            private Builder() {
                super(Atom.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public PushedCase getPushedCase() {
                return ((Atom) this.instance).getPushedCase();
            }

            public Builder clearPushed() {
                copyOnWrite();
                ((Atom) this.instance).clearPushed();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposSystemRestartOccurred() {
                return ((Atom) this.instance).hasSteposSystemRestartOccurred();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposSystemTombstoneOccurred() {
                return ((Atom) this.instance).hasSteposSystemTombstoneOccurred();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposGamePowerInfoReport() {
                return ((Atom) this.instance).hasSteposGamePowerInfoReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public StepOSGamePowerInfoReport getSteposGamePowerInfoReport() {
                return ((Atom) this.instance).getSteposGamePowerInfoReport();
            }

            public Builder setSteposGamePowerInfoReport(StepOSGamePowerInfoReport stepOSGamePowerInfoReport) {
                copyOnWrite();
                ((Atom) this.instance).setSteposGamePowerInfoReport(stepOSGamePowerInfoReport);
                return this;
            }

            public Builder setSteposGamePowerInfoReport(StepOSGamePowerInfoReport.Builder builder) {
                copyOnWrite();
                ((Atom) this.instance).setSteposGamePowerInfoReport(builder.build());
                return this;
            }

            public Builder mergeSteposGamePowerInfoReport(StepOSGamePowerInfoReport stepOSGamePowerInfoReport) {
                copyOnWrite();
                ((Atom) this.instance).mergeSteposGamePowerInfoReport(stepOSGamePowerInfoReport);
                return this;
            }

            public Builder clearSteposGamePowerInfoReport() {
                copyOnWrite();
                ((Atom) this.instance).clearSteposGamePowerInfoReport();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventWifiCodeReport() {
                return ((Atom) this.instance).hasSteposEventWifiCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventNfcCodeReport() {
                return ((Atom) this.instance).hasSteposEventNfcCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventGnssCodeReport() {
                return ((Atom) this.instance).hasSteposEventGnssCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventBluetoothCodeReport() {
                return ((Atom) this.instance).hasSteposEventBluetoothCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventModemCodeReport() {
                return ((Atom) this.instance).hasSteposEventModemCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventPerformanceCodeReport() {
                return ((Atom) this.instance).hasSteposEventPerformanceCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventPowerCodeReport() {
                return ((Atom) this.instance).hasSteposEventPowerCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventStabilityCodeReport() {
                return ((Atom) this.instance).hasSteposEventStabilityCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventKernelCodeReport() {
                return ((Atom) this.instance).hasSteposEventKernelCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
            public boolean hasSteposEventFrameworkCodeReport() {
                return ((Atom) this.instance).hasSteposEventFrameworkCodeReport();
            }

            @Override // android.hardware.stepos.StepOSAtoms.AtomOrBuilder
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
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Atom();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\r\u0001\u0001\uedb0\r\uf4c9\u000e\r\u0000\u0000\u0000\uedb0\rြ\u0000\uedb1\rြ\u0000\uedb2\rြ\u0000\uf4c0\u000eြ\u0000\uf4c1\u000eြ\u0000\uf4c2\u000eြ\u0000\uf4c3\u000eြ\u0000\uf4c4\u000eြ\u0000\uf4c5\u000eြ\u0000\uf4c6\u000eြ\u0000\uf4c7\u000eြ\u0000\uf4c8\u000eြ\u0000\uf4c9\u000eြ\u0000", new Object[]{"pushed_", "pushedCase_", "bitField0_", StepOSSystemRestartOccurred.class, StepOSSystemTombstoneOccurred.class, StepOSGamePowerInfoReport.class, StepOSEventWifiCodeReport.class, StepOSEventNfcCodeReport.class, StepOSEventGNSSCodeReport.class, StepOSEventBluetoothCodeReport.class, StepOSEventModemCodeReport.class, StepOSEventPerformanceCodeReport.class, StepOSEventPowerCodeReport.class, StepOSEventStabilityCodeReport.class, StepOSEventKernelCodeReport.class, StepOSEventFrameworkCodeReport.class});
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

    /* renamed from: android.hardware.stepos.StepOSAtoms$1, reason: invalid class name */
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventWifiCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventWifiCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventWifiCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventWifiCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventWifiCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventWifiCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventWifiCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventWifiCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventWifiCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventNfcCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventNfcCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventNfcCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventNfcCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventNfcCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventNfcCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventNfcCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventNfcCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventNfcCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventGNSSCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventGNSSCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventGNSSCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventGNSSCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventGNSSCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventGNSSCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventGNSSCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventGNSSCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventGNSSCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventBluetoothCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventBluetoothCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventBluetoothCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventBluetoothCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventBluetoothCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventBluetoothCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventBluetoothCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventModemCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventModemCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventModemCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventModemCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventModemCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventModemCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventModemCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventModemCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventModemCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventPerformanceCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventPerformanceCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventPerformanceCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventPerformanceCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventPerformanceCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPerformanceCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventPerformanceCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventPowerCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventPowerCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventPowerCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventPowerCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventPowerCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventPowerCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventPowerCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventPowerCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventPowerCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventStabilityCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventStabilityCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventStabilityCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventStabilityCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventStabilityCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventStabilityCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventStabilityCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventStabilityCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventStabilityCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventKernelCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventKernelCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventKernelCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventKernelCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventKernelCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventKernelCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventKernelCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventKernelCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventKernelCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
        public boolean hasEventCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
        public String getEventCode() {
            return this.eventCode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
        public String getTime() {
            return this.time_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
        public boolean hasEventInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
        public String getEventInfo() {
            return this.eventInfo_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
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
            private Builder() {
                super(StepOSEventFrameworkCodeReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
            public boolean hasEventCode() {
                return ((StepOSEventFrameworkCodeReport) this.instance).hasEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
            public String getEventCode() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getEventCode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
            public boolean hasTime() {
                return ((StepOSEventFrameworkCodeReport) this.instance).hasTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
            public String getTime() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getTime();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
            public boolean hasEventInfo() {
                return ((StepOSEventFrameworkCodeReport) this.instance).hasEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
            public String getEventInfo() {
                return ((StepOSEventFrameworkCodeReport) this.instance).getEventInfo();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSEventFrameworkCodeReportOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSEventFrameworkCodeReport();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
        public boolean hasPid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
        public boolean hasProcessName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
        public String getProcessName() {
            return this.processName_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
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
            private Builder() {
                super(StepOSSystemTombstoneOccurred.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
            public boolean hasPid() {
                return ((StepOSSystemTombstoneOccurred) this.instance).hasPid();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
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

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
            public boolean hasProcessName() {
                return ((StepOSSystemTombstoneOccurred) this.instance).hasProcessName();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
            public String getProcessName() {
                return ((StepOSSystemTombstoneOccurred) this.instance).getProcessName();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemTombstoneOccurredOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSSystemTombstoneOccurred();
                case 2:
                    return new Builder();
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

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemRestartOccurredOrBuilder
        public boolean hasSubject() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemRestartOccurredOrBuilder
        public String getSubject() {
            return this.subject_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemRestartOccurredOrBuilder
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
            private Builder() {
                super(StepOSSystemRestartOccurred.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemRestartOccurredOrBuilder
            public boolean hasSubject() {
                return ((StepOSSystemRestartOccurred) this.instance).hasSubject();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemRestartOccurredOrBuilder
            public String getSubject() {
                return ((StepOSSystemRestartOccurred) this.instance).getSubject();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSSystemRestartOccurredOrBuilder
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
            switch (i) {
                case 1:
                    return new StepOSSystemRestartOccurred();
                case 2:
                    return new Builder();
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

    public static final class StepOSGamePowerInfoReport extends GeneratedMessageLite<StepOSGamePowerInfoReport, Builder> implements StepOSGamePowerInfoReportOrBuilder {
        public static final int CURRENT_AVG_FIELD_NUMBER = 8;
        public static final int CURRENT_MAX_FIELD_NUMBER = 9;
        private static final StepOSGamePowerInfoReport DEFAULT_INSTANCE;
        public static final int FPS_AVG_FIELD_NUMBER = 3;
        public static final int FPS_MAX_FIELD_NUMBER = 5;
        public static final int FPS_MIN_FIELD_NUMBER = 4;
        private static volatile Parser<StepOSGamePowerInfoReport> PARSER = null;
        public static final int PROCESS_NAME_FIELD_NUMBER = 1;
        public static final int SCENE_NAME_FIELD_NUMBER = 2;
        public static final int TEMPERATURE_AVG_FIELD_NUMBER = 6;
        public static final int TEMPERATURE_MAX_FIELD_NUMBER = 7;
        public static final int VOLTAGE_AVG_FIELD_NUMBER = 10;
        public static final int WINDOWING_MODE_FIELD_NUMBER = 11;
        private int bitField0_;
        private float currentAvg_;
        private float currentMax_;
        private float fpsAvg_;
        private float fpsMax_;
        private float fpsMin_;
        private float temperatureAvg_;
        private float temperatureMax_;
        private float voltageAvg_;
        private String processName_ = "";
        private String sceneName_ = "";
        private String windowingMode_ = "";

        private StepOSGamePowerInfoReport() {
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasProcessName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public String getProcessName() {
            return this.processName_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public ByteString getProcessNameBytes() {
            return ByteString.copyFromUtf8(this.processName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.processName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProcessName() {
            this.bitField0_ &= -2;
            this.processName_ = getDefaultInstance().getProcessName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessNameBytes(ByteString byteString) {
            this.processName_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasSceneName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public String getSceneName() {
            return this.sceneName_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public ByteString getSceneNameBytes() {
            return ByteString.copyFromUtf8(this.sceneName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSceneName(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.sceneName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSceneName() {
            this.bitField0_ &= -3;
            this.sceneName_ = getDefaultInstance().getSceneName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSceneNameBytes(ByteString byteString) {
            this.sceneName_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasFpsAvg() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getFpsAvg() {
            return this.fpsAvg_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFpsAvg(float f) {
            this.bitField0_ |= 4;
            this.fpsAvg_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFpsAvg() {
            this.bitField0_ &= -5;
            this.fpsAvg_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasFpsMin() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getFpsMin() {
            return this.fpsMin_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFpsMin(float f) {
            this.bitField0_ |= 8;
            this.fpsMin_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFpsMin() {
            this.bitField0_ &= -9;
            this.fpsMin_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasFpsMax() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getFpsMax() {
            return this.fpsMax_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFpsMax(float f) {
            this.bitField0_ |= 16;
            this.fpsMax_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFpsMax() {
            this.bitField0_ &= -17;
            this.fpsMax_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasTemperatureAvg() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getTemperatureAvg() {
            return this.temperatureAvg_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTemperatureAvg(float f) {
            this.bitField0_ |= 32;
            this.temperatureAvg_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTemperatureAvg() {
            this.bitField0_ &= -33;
            this.temperatureAvg_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasTemperatureMax() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getTemperatureMax() {
            return this.temperatureMax_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTemperatureMax(float f) {
            this.bitField0_ |= 64;
            this.temperatureMax_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTemperatureMax() {
            this.bitField0_ &= -65;
            this.temperatureMax_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasCurrentAvg() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getCurrentAvg() {
            return this.currentAvg_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrentAvg(float f) {
            this.bitField0_ |= 128;
            this.currentAvg_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCurrentAvg() {
            this.bitField0_ &= -129;
            this.currentAvg_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasCurrentMax() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getCurrentMax() {
            return this.currentMax_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrentMax(float f) {
            this.bitField0_ |= 256;
            this.currentMax_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCurrentMax() {
            this.bitField0_ &= -257;
            this.currentMax_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasVoltageAvg() {
            return (this.bitField0_ & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public float getVoltageAvg() {
            return this.voltageAvg_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVoltageAvg(float f) {
            this.bitField0_ |= ConstantsKt.MINIMUM_BLOCK_SIZE;
            this.voltageAvg_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVoltageAvg() {
            this.bitField0_ &= -513;
            this.voltageAvg_ = 0.0f;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public boolean hasWindowingMode() {
            return (this.bitField0_ & Segment.SHARE_MINIMUM) != 0;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public String getWindowingMode() {
            return this.windowingMode_;
        }

        @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
        public ByteString getWindowingModeBytes() {
            return ByteString.copyFromUtf8(this.windowingMode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWindowingMode(String str) {
            str.getClass();
            this.bitField0_ |= Segment.SHARE_MINIMUM;
            this.windowingMode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWindowingMode() {
            this.bitField0_ &= -1025;
            this.windowingMode_ = getDefaultInstance().getWindowingMode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWindowingModeBytes(ByteString byteString) {
            this.windowingMode_ = byteString.toStringUtf8();
            this.bitField0_ |= Segment.SHARE_MINIMUM;
        }

        public static StepOSGamePowerInfoReport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StepOSGamePowerInfoReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StepOSGamePowerInfoReport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StepOSGamePowerInfoReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StepOSGamePowerInfoReport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StepOSGamePowerInfoReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StepOSGamePowerInfoReport parseFrom(InputStream inputStream) throws IOException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSGamePowerInfoReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSGamePowerInfoReport parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StepOSGamePowerInfoReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StepOSGamePowerInfoReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSGamePowerInfoReport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StepOSGamePowerInfoReport parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StepOSGamePowerInfoReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StepOSGamePowerInfoReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StepOSGamePowerInfoReport stepOSGamePowerInfoReport) {
            return DEFAULT_INSTANCE.createBuilder(stepOSGamePowerInfoReport);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StepOSGamePowerInfoReport, Builder> implements StepOSGamePowerInfoReportOrBuilder {
            private Builder() {
                super(StepOSGamePowerInfoReport.DEFAULT_INSTANCE);
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasProcessName() {
                return ((StepOSGamePowerInfoReport) this.instance).hasProcessName();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public String getProcessName() {
                return ((StepOSGamePowerInfoReport) this.instance).getProcessName();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public ByteString getProcessNameBytes() {
                return ((StepOSGamePowerInfoReport) this.instance).getProcessNameBytes();
            }

            public Builder setProcessName(String str) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setProcessName(str);
                return this;
            }

            public Builder clearProcessName() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearProcessName();
                return this;
            }

            public Builder setProcessNameBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setProcessNameBytes(byteString);
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasSceneName() {
                return ((StepOSGamePowerInfoReport) this.instance).hasSceneName();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public String getSceneName() {
                return ((StepOSGamePowerInfoReport) this.instance).getSceneName();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public ByteString getSceneNameBytes() {
                return ((StepOSGamePowerInfoReport) this.instance).getSceneNameBytes();
            }

            public Builder setSceneName(String str) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setSceneName(str);
                return this;
            }

            public Builder clearSceneName() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearSceneName();
                return this;
            }

            public Builder setSceneNameBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setSceneNameBytes(byteString);
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasFpsAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).hasFpsAvg();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getFpsAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).getFpsAvg();
            }

            public Builder setFpsAvg(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setFpsAvg(f);
                return this;
            }

            public Builder clearFpsAvg() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearFpsAvg();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasFpsMin() {
                return ((StepOSGamePowerInfoReport) this.instance).hasFpsMin();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getFpsMin() {
                return ((StepOSGamePowerInfoReport) this.instance).getFpsMin();
            }

            public Builder setFpsMin(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setFpsMin(f);
                return this;
            }

            public Builder clearFpsMin() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearFpsMin();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasFpsMax() {
                return ((StepOSGamePowerInfoReport) this.instance).hasFpsMax();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getFpsMax() {
                return ((StepOSGamePowerInfoReport) this.instance).getFpsMax();
            }

            public Builder setFpsMax(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setFpsMax(f);
                return this;
            }

            public Builder clearFpsMax() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearFpsMax();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasTemperatureAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).hasTemperatureAvg();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getTemperatureAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).getTemperatureAvg();
            }

            public Builder setTemperatureAvg(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setTemperatureAvg(f);
                return this;
            }

            public Builder clearTemperatureAvg() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearTemperatureAvg();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasTemperatureMax() {
                return ((StepOSGamePowerInfoReport) this.instance).hasTemperatureMax();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getTemperatureMax() {
                return ((StepOSGamePowerInfoReport) this.instance).getTemperatureMax();
            }

            public Builder setTemperatureMax(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setTemperatureMax(f);
                return this;
            }

            public Builder clearTemperatureMax() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearTemperatureMax();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasCurrentAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).hasCurrentAvg();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getCurrentAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).getCurrentAvg();
            }

            public Builder setCurrentAvg(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setCurrentAvg(f);
                return this;
            }

            public Builder clearCurrentAvg() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearCurrentAvg();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasCurrentMax() {
                return ((StepOSGamePowerInfoReport) this.instance).hasCurrentMax();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getCurrentMax() {
                return ((StepOSGamePowerInfoReport) this.instance).getCurrentMax();
            }

            public Builder setCurrentMax(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setCurrentMax(f);
                return this;
            }

            public Builder clearCurrentMax() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearCurrentMax();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasVoltageAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).hasVoltageAvg();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public float getVoltageAvg() {
                return ((StepOSGamePowerInfoReport) this.instance).getVoltageAvg();
            }

            public Builder setVoltageAvg(float f) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setVoltageAvg(f);
                return this;
            }

            public Builder clearVoltageAvg() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearVoltageAvg();
                return this;
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public boolean hasWindowingMode() {
                return ((StepOSGamePowerInfoReport) this.instance).hasWindowingMode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public String getWindowingMode() {
                return ((StepOSGamePowerInfoReport) this.instance).getWindowingMode();
            }

            @Override // android.hardware.stepos.StepOSAtoms.StepOSGamePowerInfoReportOrBuilder
            public ByteString getWindowingModeBytes() {
                return ((StepOSGamePowerInfoReport) this.instance).getWindowingModeBytes();
            }

            public Builder setWindowingMode(String str) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setWindowingMode(str);
                return this;
            }

            public Builder clearWindowingMode() {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).clearWindowingMode();
                return this;
            }

            public Builder setWindowingModeBytes(ByteString byteString) {
                copyOnWrite();
                ((StepOSGamePowerInfoReport) this.instance).setWindowingModeBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new StepOSGamePowerInfoReport();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tခ\b\nခ\t\u000bဈ\n", new Object[]{"bitField0_", "processName_", "sceneName_", "fpsAvg_", "fpsMin_", "fpsMax_", "temperatureAvg_", "temperatureMax_", "currentAvg_", "currentMax_", "voltageAvg_", "windowingMode_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StepOSGamePowerInfoReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StepOSGamePowerInfoReport.class) {
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
            StepOSGamePowerInfoReport stepOSGamePowerInfoReport = new StepOSGamePowerInfoReport();
            DEFAULT_INSTANCE = stepOSGamePowerInfoReport;
            GeneratedMessageLite.registerDefaultInstance(StepOSGamePowerInfoReport.class, stepOSGamePowerInfoReport);
        }

        public static StepOSGamePowerInfoReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StepOSGamePowerInfoReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
