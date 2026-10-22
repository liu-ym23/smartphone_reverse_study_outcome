package com.android.server.hdmi;

import android.media.AudioDescriptor;
import android.os.Handler;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiEarcLocalDeviceTx extends HdmiEarcLocalDevice {
    private static final int EARC_CAPS_DATA_START = 3;
    private static final int EARC_CAPS_LENGTH_MASK = 31;
    private static final int EARC_CAPS_PAYLOAD_LENGTH = 2;
    private static final int EARC_CAPS_TAGCODE_MASK = 224;
    private static final int EARC_CAPS_TAGCODE_SHIFT = 5;
    private static final int EXTENDED_TAGCODE_VSADB = 17;
    static final long REPORT_CAPS_MAX_DELAY_MS = 2000;
    private static final String TAG = "HdmiEarcLocalDeviceTx";
    private static final int TAGCODE_AUDIO_DATA_BLOCK = 1;
    private static final int TAGCODE_SADB_DATA_BLOCK = 4;
    private static final int TAGCODE_USE_EXTENDED_TAG = 7;
    private static final String[] earcStatusNames = null;
    private Handler mReportCapsHandler;
    private ReportCapsRunnable mReportCapsRunnable;

    private class ReportCapsRunnable implements Runnable {
        final /* synthetic */ HdmiEarcLocalDeviceTx this$0;

        /* synthetic */ ReportCapsRunnable(HdmiEarcLocalDeviceTx r1, HdmiEarcLocalDeviceTxIA r2) {
            this(r1);
        }

        private ReportCapsRunnable(HdmiEarcLocalDeviceTx r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mEarcStatus != 3) goto L9;
            this.this$0.mService.notifyEarcStatusToAudioService(true, new ArrayList());     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    static {
        earcStatusNames = new String[]{"HDMI_EARC_STATUS_IDLE", "HDMI_EARC_STATUS_EARC_PENDING", "HDMI_EARC_STATUS_ARC_PENDING", "HDMI_EARC_STATUS_EARC_CONNECTED"};
    }

    HdmiEarcLocalDeviceTx(HdmiControlService service) {
        super(service, 0);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mEarcStatus = 1;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mReportCapsHandler = new Handler(service.getServiceLooper());
        this.mReportCapsRunnable = new ReportCapsRunnable(this, null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private String earcStatusToString(int status) {
        return earcStatusNames[status];
    }

    @Override // com.android.server.hdmi.HdmiEarcLocalDevice
    protected void handleEarcStateChange(int status) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        HdmiLogger.debug("eARC state change [old: %s(%d) new: %s(%d)]", new Object[]{earcStatusToString(this.mEarcStatus), Integer.valueOf(this.mEarcStatus), earcStatusToString(status), Integer.valueOf(status)});     // Catch: Throwable -> L21
        int oldEarcStatus = this.mEarcStatus;     // Catch: Throwable -> L21
        this.mEarcStatus = status;     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        this.mReportCapsHandler.removeCallbacksAndMessages(null);
        if (status != 0) goto L10;
        this.mService.notifyEarcStatusToAudioService(false, new ArrayList());
        this.mService.startArcAction(false, null);
        return;
    L10:
        if (status != 2) goto L12;
        this.mService.notifyEarcStatusToAudioService(false, new ArrayList());
        this.mService.startArcAction(true, null);
        return;
    L12:
        if (status != 1) goto L16;
        if (oldEarcStatus != 2) goto L16;
        this.mService.startArcAction(false, null);
        return;
    L16:
        if (status != 3) goto L29;
        if (oldEarcStatus != 2) goto L19;
        this.mService.startArcAction(false, null);
    L19:
        this.mReportCapsHandler.postDelayed(this.mReportCapsRunnable, 2000);
        return;
    L29:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.hdmi.HdmiEarcLocalDevice
    protected void handleEarcCapabilitiesReported(byte[] rawCapabilities) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mEarcStatus == 3) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mReportCapsHandler.hasCallbacks(this.mReportCapsRunnable) == false) goto L11;
        this.mReportCapsHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        List<AudioDescriptor> audioDescriptors = parseCapabilities(rawCapabilities);     // Catch: Throwable -> L9
        this.mService.notifyEarcStatusToAudioService(true, audioDescriptors);     // Catch: Throwable -> L9
        goto L11
    }

    private List<AudioDescriptor> parseCapabilities(byte[] rawCapabilities) {
        List<AudioDescriptor> audioDescriptors = new ArrayList();
        if (rawCapabilities.length >= 4) goto L6;
        Slog.i(TAG, "Raw eARC capabilities array doesn´t contain any blocks.");
        return audioDescriptors;
    L6:
        int earcCapsSize = rawCapabilities[2];
        if (rawCapabilities.length >= earcCapsSize) goto L10;
        Slog.i(TAG, "Raw eARC capabilities array is shorter than the reported payload length.");
        return audioDescriptors;
    L10:
        int firstByteOfBlock = 3;
    L11:
        if (firstByteOfBlock >= earcCapsSize) goto L30;
        int tagCode = (rawCapabilities[firstByteOfBlock] & 224) >> 5;
        int length = rawCapabilities[firstByteOfBlock] & 31;
        if (length == 0) goto L30;
        switch(tagCode) {
            case 1: goto L23;
            case 4: goto L21;
            case 7: goto L19;
            default: goto L17;
        };
    L17:
        Slog.w(TAG, "This tagcode was not handled: " + tagCode);
    L29:
        firstByteOfBlock = firstByteOfBlock + (length + 1);
        goto L11
    L21:
        int earcSadbLen = length + 1;
        byte[] earcSadb = new byte[earcSadbLen];
        System.arraycopy(rawCapabilities, firstByteOfBlock, earcSadb, 0, earcSadbLen);
        AudioDescriptor descriptor = new AudioDescriptor(2, 0, earcSadb);
        audioDescriptors.add(descriptor);
        goto L29
    L19:
        if (rawCapabilities[firstByteOfBlock + 1] != 17) goto L29;
        int earcVsadbLen = length + 1;
        byte[] earcVsadb = new byte[earcVsadbLen];
        System.arraycopy(rawCapabilities, firstByteOfBlock, earcVsadb, 0, earcVsadbLen);
        AudioDescriptor descriptor2 = new AudioDescriptor(3, 0, earcVsadb);
        audioDescriptors.add(descriptor2);
        goto L29
    L23:
        if ((length % 3) == 0) goto L25;
        Slog.e(TAG, "Invalid length of SAD block: expected a factor of 3 but got " + (length % 3));
        goto L29
    L25:
        byte[] earcSad = new byte[length];
        System.arraycopy(rawCapabilities, firstByteOfBlock + 1, earcSad, 0, length);
        int i = 0;
    L26:
        if (i >= length) goto L29;
        AudioDescriptor descriptor3 = new AudioDescriptor(1, 0, Arrays.copyOfRange(earcSad, i, i + 3));
        audioDescriptors.add(descriptor3);
        i = i + 3;
    L30:
        return audioDescriptors;
    }

    @Override // com.android.server.hdmi.HdmiEarcLocalDevice
    protected void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("TX, mEarcStatus: " + this.mEarcStatus);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
