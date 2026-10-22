package com.android.common;

import android.util.EventLog;

/* JADX INFO: loaded from: classes.dex */
public class GoogleLogTags {
    public static final int C2DM = 204005;
    public static final int EXP_DET_SNET = 206003;
    public static final int GLS_ACCOUNT_SAVED = 205009;
    public static final int GLS_ACCOUNT_TRIED = 205008;
    public static final int GLS_AUTHENTICATE = 205010;
    public static final int GOOGLE_HTTP_REQUEST = 203002;
    public static final int GOOGLE_MAIL_SWITCH = 205011;
    public static final int GTALKSERVICE = 204001;
    public static final int GTALK_CONNECTION = 204002;
    public static final int GTALK_CONN_CLOSE = 204003;
    public static final int GTALK_HEARTBEAT_RESET = 204004;
    public static final int METRICS_HEARTBEAT = 208000;
    public static final int SETUP_COMPLETED = 205007;
    public static final int SETUP_IO_ERROR = 205003;
    public static final int SETUP_NO_DATA_NETWORK = 205006;
    public static final int SETUP_REQUIRED_CAPTCHA = 205002;
    public static final int SETUP_RETRIES_EXHAUSTED = 205005;
    public static final int SETUP_SERVER_ERROR = 205004;
    public static final int SETUP_SERVER_TIMEOUT = 205001;
    public static final int SNET = 206001;
    public static final int SYNC_DETAILS = 203001;
    public static final int SYSTEM_UPDATE = 201001;
    public static final int SYSTEM_UPDATE_USER = 201002;
    public static final int TRANSACTION_EVENT = 202901;
    public static final int VENDING_RECONSTRUCT = 202001;

    private GoogleLogTags() {
    }

    public static void writeSystemUpdate(int r2, int r3, long r4, String r6) {
        EventLog.writeEvent(SYSTEM_UPDATE, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), Long.valueOf(r4), r6});
    }

    public static void writeSystemUpdateUser(String r1) {
        EventLog.writeEvent(SYSTEM_UPDATE_USER, r1);
    }

    public static void writeVendingReconstruct(int r1) {
        EventLog.writeEvent(VENDING_RECONSTRUCT, r1);
    }

    public static void writeTransactionEvent(String r1) {
        EventLog.writeEvent(TRANSACTION_EVENT, r1);
    }

    public static void writeSyncDetails(String r2, int r3, int r4, String r5) {
        EventLog.writeEvent(SYNC_DETAILS, new Object[]{r2, Integer.valueOf(r3), Integer.valueOf(r4), r5});
    }

    public static void writeGoogleHttpRequest(long r2, int r4, String r5, int r6) {
        EventLog.writeEvent(GOOGLE_HTTP_REQUEST, new Object[]{Long.valueOf(r2), Integer.valueOf(r4), r5, Integer.valueOf(r6)});
    }

    public static void writeGtalkservice(int r1) {
        EventLog.writeEvent(GTALKSERVICE, r1);
    }

    public static void writeGtalkConnection(int r1) {
        EventLog.writeEvent(GTALK_CONNECTION, r1);
    }

    public static void writeGtalkConnClose(int r2, int r3) {
        EventLog.writeEvent(GTALK_CONN_CLOSE, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3)});
    }

    public static void writeGtalkHeartbeatReset(int r2, String r3) {
        EventLog.writeEvent(GTALK_HEARTBEAT_RESET, new Object[]{Integer.valueOf(r2), r3});
    }

    public static void writeC2Dm(int r2, String r3, int r4, int r5) {
        EventLog.writeEvent(C2DM, new Object[]{Integer.valueOf(r2), r3, Integer.valueOf(r4), Integer.valueOf(r5)});
    }

    public static void writeSetupServerTimeout() {
        EventLog.writeEvent(SETUP_SERVER_TIMEOUT, new Object[0]);
    }

    public static void writeSetupRequiredCaptcha(String r1) {
        EventLog.writeEvent(SETUP_REQUIRED_CAPTCHA, r1);
    }

    public static void writeSetupIoError(String r1) {
        EventLog.writeEvent(SETUP_IO_ERROR, r1);
    }

    public static void writeSetupServerError() {
        EventLog.writeEvent(SETUP_SERVER_ERROR, new Object[0]);
    }

    public static void writeSetupRetriesExhausted() {
        EventLog.writeEvent(SETUP_RETRIES_EXHAUSTED, new Object[0]);
    }

    public static void writeSetupNoDataNetwork() {
        EventLog.writeEvent(SETUP_NO_DATA_NETWORK, new Object[0]);
    }

    public static void writeSetupCompleted() {
        EventLog.writeEvent(SETUP_COMPLETED, new Object[0]);
    }

    public static void writeGlsAccountTried(int r1) {
        EventLog.writeEvent(GLS_ACCOUNT_TRIED, r1);
    }

    public static void writeGlsAccountSaved(int r1) {
        EventLog.writeEvent(GLS_ACCOUNT_SAVED, r1);
    }

    public static void writeGlsAuthenticate(int r2, String r3) {
        EventLog.writeEvent(GLS_AUTHENTICATE, new Object[]{Integer.valueOf(r2), r3});
    }

    public static void writeGoogleMailSwitch(int r1) {
        EventLog.writeEvent(GOOGLE_MAIL_SWITCH, r1);
    }

    public static void writeSnet(String r1) {
        EventLog.writeEvent(SNET, r1);
    }

    public static void writeExpDetSnet(String r1) {
        EventLog.writeEvent(EXP_DET_SNET, r1);
    }

    public static void writeMetricsHeartbeat() {
        EventLog.writeEvent(METRICS_HEARTBEAT, new Object[0]);
    }
}
