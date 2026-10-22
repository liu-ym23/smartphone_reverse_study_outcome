package com.slardaros.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.obric.olog.OLog;
import com.slardaros.client.monitor.network.ttnet.TTNetMonitor;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class SlardarAgent {
    public static final String TAG = "SlardarAgent";
    private static volatile boolean sIsFirstInstall = false;

    static {
    }

    public SlardarAgent() {
    }

    public static void init(Context r3) {
        OLog.d(TAG, "on init");     // Catch: Throwable -> L7
        BaseHandler.getSlardarHandler().init(r3);     // Catch: Throwable -> L7
        if (SlardarUtil.isMainProcess() == false) goto L12;
        checkWhetherFirstInstall();     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        OLog.e(TAG, "init " + th.getMessage());
    }

    public static void onInstantEvent(String r4, JSONObject r5) {
        OLog.d(TAG, "onInstantEvent");     // Catch: Throwable -> L5
        BaseHandler.getSlardarHandler().onEvent(new SlardarEvent(r4, r5, true));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "onInstantEvent " + th.getMessage());
    }

    public static void onEvent(String r3, JSONObject r4) {
        OLog.d(TAG, "onEvent");     // Catch: Throwable -> L5
        BaseHandler.getSlardarHandler().onEvent(new SlardarEvent(r3, r4));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "onEvent " + th.getMessage());
    }

    public static void onEventList(ArrayList<SlardarEvent> r3) {
        OLog.d(TAG, "onEventList");     // Catch: Throwable -> L5
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L5
        r1.addAll(r3);     // Catch: Throwable -> L5
        BaseHandler.getSlardarHandler().onEvents(r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "onEventList " + th.getMessage());
    }

    public static void onAgentEventList(ArrayList<AgentEvent> r3) {
        OLog.d(TAG, "onAgentEventList");     // Catch: Throwable -> L5
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L5
        r1.addAll(r3);     // Catch: Throwable -> L5
        BaseHandler.getSlardarHandler().onEvents(r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "onAgentEventList " + th.getMessage());
    }

    public static void onAbResult(String r2, int r3, String r4) {
        OLog.d(TAG, "onAbResult");     // Catch: Throwable -> L5
        BaseHandler.getSlardarHandler().onAbResult(r2, r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "onAbResult " + th.getMessage());
    }

    public static void sendCustomError(String r8, String r9, String r10, boolean r11) {
        OLog.d(TAG, "sendCustomError");     // Catch: Throwable -> L5
        sendCustomError(r8, r9, r10, r11, null, false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "sendCustomError " + th.getMessage());
    }

    public static void sendCustomError(String r9, String r10, String r11, boolean r12, String r13) {
        OLog.d(TAG, "sendCustomError");     // Catch: Throwable -> L5
        sendCustomError("custom_error", r9, r10, r11, r12, r13, false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "sendCustomError " + th.getMessage());
    }

    public static void sendCustomError(String r9, String r10, String r11, boolean r12, String r13, boolean r14) {
        OLog.d(TAG, "sendCustomError");     // Catch: Throwable -> L5
        sendCustomError("custom_error", r9, r10, r11, r12, r13, r14);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "sendCustomError " + th.getMessage());
    }

    public static void sendKernelPanicError(String r10, String r11, boolean r12, String r13, boolean r14) {
        if (SlardarUtil.checkReachLimit(((SlardarHandler) BaseHandler.getSlardarHandler()).getContext(), "kernel") == false) goto L6;
        OLog.d(TAG, "sendKernelPanicError over limit");
        return;
    L6:
        OLog.d(TAG, "sendKernelPanicError");
        BaseHandler.getSlardarHandler().onEvent(new ErrorEvent("kernel", "panic", r10, r11, r12, r13, r14));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    private static void sendCustomError(String r7, String r8, String r9, String r10, boolean r11) {
        if (SlardarUtil.checkArgsNotEmpty(new String[]{r7, r8, r9}) == true) goto L7;
        OLog.e(Constants.TAG, "tag, type, summary can't be empty");
        return;
    L7:
        if (SlardarUtil.checkReachLimit(((SlardarHandler) BaseHandler.getSlardarHandler()).getContext(), r7) == false) goto L14;
        return;
    L14:
        sendCustomError("custom_error", r8, r9, r10, r11, null, false);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        OLog.e(TAG, "sendCustomError " + th.getMessage());
    }

    private static void sendCustomError(String r8, String r9, String r10, String r11, boolean r12, String r13, boolean r14) {
        if (SlardarUtil.checkArgsNotEmpty(new String[]{r8, r9, r10}) == true) goto L7;
        OLog.e(Constants.TAG, "tag, type, summary can't be empty");
        return;
    L7:
        if (SlardarUtil.checkReachLimit(((SlardarHandler) BaseHandler.getSlardarHandler()).getContext(), r8) == false) goto L9;
        return;
    L9:
        if (r13 != null) goto L22;
        r13 = ((SlardarHandler) BaseHandler.getSlardarHandler()).getContext().getPackageName();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        r13 = EnvironmentCompat.MEDIA_UNKNOWN;
    L22:
        BaseHandler.getSlardarHandler().onEvent(new ErrorEvent("custom_error", r9, r10, r11, r12, r13, r14));     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        OLog.e(TAG, "sendCustomError " + th.getMessage());
    }

    public static void sendCustomInfo(String r3, String r4, boolean r5) {
        if (SlardarUtil.checkArgsNotEmpty(new String[]{r3, r4}) == true) goto L7;
        OLog.e(Constants.TAG, "logType, logPath can't be empty");
        return;
    L7:
        if (SlardarUtil.checkReachLimit(((SlardarHandler) BaseHandler.getSlardarHandler()).getContext(), r3) == false) goto L14;
        return;
    L14:
        OLog.d(TAG, "sendCustomInfo");     // Catch: Throwable -> L11
        sendCustomInfo(r3, r4, r5, "");     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        OLog.e(TAG, "sendCustomInfo " + th.getMessage());
    }

    public static void sendCustomInfo(String r3, String r4, boolean r5, String r6) {
        if (SlardarUtil.checkArgsNotEmpty(new String[]{r3, r4}) == true) goto L7;
        OLog.e(Constants.TAG, "logType, logPath can't be empty");
        return;
    L7:
        if (SlardarUtil.checkReachLimit(((SlardarHandler) BaseHandler.getSlardarHandler()).getContext(), r3) == false) goto L14;
        return;
    L14:
        OLog.d(TAG, "sendCustomInfo");     // Catch: Throwable -> L11
        BaseHandler.getSlardarHandler().onEvent(new InfoEvent(r3, r4, r5, r6));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        OLog.e(TAG, "sendCustomInfo " + th.getMessage());
    }

    public static void sendCustomInfo(String r9, String r10, String r11, boolean r12) {
        if (SlardarUtil.checkArgsNotEmpty(new String[]{r9, r10, r11}) == true) goto L7;
        OLog.e(Constants.TAG, "logid, logType, logPath can't be empty");
        return;
    L7:
        if (SlardarUtil.checkReachLimit(((SlardarHandler) BaseHandler.getSlardarHandler()).getContext(), r10) == false) goto L14;
        return;
    L14:
        OLog.d(TAG, "sendCustomInfo");     // Catch: Throwable -> L11
        BaseHandler.getSlardarHandler().onEvent(new InfoEvent(r9, r10, r11, r12, ""));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        OLog.e(TAG, "sendCustomInfo " + th.getMessage());
    }

    public static int queryAppInfoProfile(String r7, String r8, String r9, String r10) {
        return BaseHandler.getSlardarHandler().onRequestAppProfile(r7, r8, r9, r10, SlardarHandler.APPINFO, true);
    }

    public static boolean queryIoRapProfile(String r7, String r8, String r9, String r10) {
        return BaseHandler.getSlardarHandler().onRequestProfile(r7, r8, r9, r10, SlardarHandler.IORAP, true);
    }

    public static boolean queryProfile(String r7, String r8, String r9, String r10, String r11) {
        return BaseHandler.getSlardarHandler().onRequestProfile(r8, r9, r10, r11, r7, true);
    }

    public static boolean uploadIoRapProfile(String r7, String r8, String r9, String r10) {
        return BaseHandler.getSlardarHandler().onRequestProfile(r7, r8, r9, r10, SlardarHandler.IORAP, false);
    }

    @Deprecated
    public static void onUnbind() {
        BaseHandler.getSlardarHandler().onUnbind();
    }

    public static void onExit() {
        BaseHandler.getSlardarHandler().onExit();
    }

    public static boolean isInited() {
        if (SlardarHandler.sInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Context getContext() {
        return ((SlardarHandler) BaseHandler.getSlardarHandler()).getContext();
    }

    public static void monitorTTNetApiOk(long r1, JSONObject r3) {
        TTNetMonitor.sendTTNetMetricEvent(r1, r3, null);
    }

    public static void monitorTTNetApiError(long r0, JSONObject r2, Throwable r3) {
        TTNetMonitor.sendTTNetMetricEvent(r0, r2, r3);
    }

    public static boolean isFirstInstall() {
        return sIsFirstInstall;
    }

    private static void checkWhetherFirstInstall() {
        Context r1 = getContext();
        if (r1 != null) goto L14;
        return;
    L14:
        SharedPreferences r2 = r1.getSharedPreferences(Constants.SP_NAME, 0);     // Catch: Exception -> L10
        String r4 = r2.getString(Constants.LAST_VERSION_CODE, "");     // Catch: Exception -> L10
        String r3 = SlardarUtil.getVersionCode(r1);     // Catch: Exception -> L10
        if (TextUtils.equals(r4, r3) == true) goto L8;
        sIsFirstInstall = true;     // Catch: Exception -> L10
        r2.edit().putString(Constants.LAST_VERSION_CODE, r3).apply();     // Catch: Exception -> L10
    L13:
        return;
    L8:
        sIsFirstInstall = false;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        OLog.e(TAG, "checkWhetherFirstInstall" + e.getMessage());
    }
}
