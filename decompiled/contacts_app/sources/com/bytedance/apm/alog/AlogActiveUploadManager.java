package com.bytedance.apm.alog;

import android.content.Context;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.alog.net.AlogUploadService;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.entity.UploadRequest;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.ProcessUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AlogActiveUploadManager {
    private static volatile IAlogUploadStrategy sAlogUploadStrategy;

    public AlogActiveUploadManager() {
    }

    public static void init(Context r0, IAlogUploadStrategy r1) {
        if (sAlogUploadStrategy != null) goto L6;
        sAlogUploadStrategy = r1;
        return;
    }

    @Deprecated
    public static void activeUploadAlog(String r0, long r1, long r3, String r5, IALogActiveUploadObserver r6) {
        ApmAgent.activeUploadAlog(r0, r1, r3, r5, r6);
    }

    public static void tryUploadAlog(String r14, long r15, long r17, String r19, IALogActiveUploadObserver r20, IALogActiveUploadCallback r21) {
        long r9 = System.currentTimeMillis();
        ApmAgent.monitorStatusRate("apm_event_stats_alog", 0, null);
        String r1 = r14;
        AlogMonitor.log("begin upload alog:" + r14 + " startTime:" + r15 + " endTime:" + r17 + " scene:" + r19);
        boolean r7 = true;
        if (ApmContext.getContext() != null) goto L6;
        String r2 = "apm context is null";
        int r3 = 0;
    L18:
        JSONObject r4 = new JSONObject();
        r4.put(AlogMonitor.ALOG_RESULT_INFO, r2);     // Catch: JSONException -> L21
    L23:
        JSONObject r0 = AlogMonitor.getResult(!r7, r3, null, r4);
        if (r7 == false) goto L27;
        if (r21 == null) goto L27;
        r21.onCallback(false, r0);
    L27:
        if (r7 == false) goto L29;
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", r3, r0);
    L29:
        AlogMonitor.log("upload end. ".concat(r2));
        JSONObject r5 = new JSONObject();
        r5.put(DBHelper.COL_TIME, System.currentTimeMillis() - r9);     // Catch: JSONException -> L32
    L34:
        ApmAgent.monitorEvent(CommonConsts.MONITOR_EVENT_STATS_ALOG_UPLOAD_TIME, null, r5, null);
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L6:
        if (TextUtils.isEmpty(r14) == false) goto L12;
        if (TextUtils.isEmpty(ApmContext.getAlogFilesDir()) == false) goto L10;
        r2 = "alog file dir is null";
        r3 = 1;
        goto L18
    L10:
        r1 = ApmContext.getAlogFilesDir();
    L12:
        if (new File(r1).exists() == true) goto L14;
        r2 = "alog file dir do not exist";
        r3 = 2;
        goto L18
    L14:
        if (r20 == null) goto L16;
        r20.flushAlogDataToFile();
        AlogMonitor.log("flush alog data to file");
    L17:
        activeUploadAlogInternal(r1, r15, r17, r19, r21);
        r2 = "";
        r3 = -1;
        r7 = false;
        goto L18
    L16:
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 3, null);
        goto L17
    }

    private static void activeUploadAlogInternal(String r14, long r15, long r17, String r19, final IALogActiveUploadCallback r20) {
        if (sAlogUploadStrategy == null) goto L57;
        AlogMonitor.log("begin get alog file");
        List<String> r1 = sAlogUploadStrategy.getUploadAlogFiles(ApmContext.getContext(), r14, r15, r17);
        AlogMonitor.log("end get alog file:" + r14);
        Object r3 = "null";
        if (ListUtils.isEmpty(r1) == true) goto L41;
        UploadRequest r0 = buildUploadRequest(r1);
        if (checkParamsForUploadRequest(r0) == true) goto L21;
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 5, null);
        if (r20 == null) goto L19;
        JSONObject r2 = new JSONObject();
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L16
        r5.put("aid", r0.getAid());     // Catch: Exception -> L16
        r5.put("did", r0.getDid());     // Catch: Exception -> L16
        r5.put("processName", r0.getProcessName());     // Catch: Exception -> L16
        if (r0.getAlogFiles() == null) goto L14;
        r3 = Integer.valueOf(r0.getAlogFiles().size());     // Catch: Exception -> L16
    L14:
        r5.put("alogSize", r3);     // Catch: Exception -> L16
        r2.put(AlogMonitor.ALOG_RESULT_INFO, r5.toString());     // Catch: Exception -> L16
    L18:
        r20.onCallback(false, AlogMonitor.getResult(false, 5, null, r2));
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        AlogMonitor.log("upload param missed");
        return;
    L21:
        AlogMonitor.log("alog file begin zip");
        String r4 = zipUploadFile(r0.getAlogFiles());
        AlogMonitor.log("alog file end zip");
        final int[] r6 = {0};
        AlogUploadService.AlogCallBack r12 = new AnonymousClass1(r6, r20);
        if (TextUtils.isEmpty(r4) == false) goto L68;
        AlogMonitor.log("alog file upload origin file begin");
        boolean r7 = AlogUploadService.uploadAlogFiles(r0.getAid(), r0.getDid(), r0.getProcessName(), r0.getAlogFiles(), r19, r0.getCommonParams(), r12);
        if (r7 == true) goto L26;
        r7 = AlogUploadService.uploadAlogFiles(r0.getAid(), r0.getDid(), r0.getProcessName(), r0.getAlogFiles(), r19, r0.getCommonParams(), r12);
    L26:
        AlogMonitor.log("alog file upload origin file end. success :" + r7);
    L39:
        if (r7 == false) goto L71;
        ApmAgent.monitorStatusRate(CommonConsts.MONITOR_EVENT_STATS_ALOG_UPLOAD_SUCCESS, 0, null);
        return;
    L71:
        return;
    L68:
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L33
        r8.add(r4);     // Catch: Throwable -> L33
        AlogMonitor.log("alog file upload zip file begin");     // Catch: Throwable -> L33
        boolean r13 = AlogUploadService.uploadAlogFiles(r0.getAid(), r0.getDid(), r0.getProcessName(), r8, r19, r0.getCommonParams(), r12);     // Catch: Throwable -> L33
        if (r13 == false) goto L66;
    L38:
        AlogMonitor.log("alog file upload zip file end. success:" + r13 + " zip file:" + r4);
        new File(r4).delete();
        r7 = r13;
        goto L39
    L66:
        r13 = AlogUploadService.uploadAlogFiles(r0.getAid(), r0.getDid(), r0.getProcessName(), r8, r19, r0.getCommonParams(), r12);     // Catch: Throwable -> L31
    L31:
        th = th;
    L36:
        if (ApmContext.isDebugMode() == false) goto L38;
        th.printStackTrace();
    L33:
        th = th;
        r13 = false;
        goto L36
    L41:
        JSONObject r9 = new JSONObject();
        r9.put(AlogMonitor.ALOG_RESULT_INFO, "alog upload file failed,local file is null");     // Catch: Exception -> L60
        r9.put("e_dir", r14);     // Catch: Exception -> L60
        r9.put("e_start_time", r15);     // Catch: Exception -> L60
        r9.put("e_end_time", r17);     // Catch: Exception -> L60
        File r10 = new File(r14);     // Catch: Exception -> L60
        if (r10.exists() == true) goto L46;
    L51:
        r9.put("e_file", "null");     // Catch: Exception -> L60
        goto L52
    L46:
        if (r10.listFiles() == null) goto L51;
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L60
        r11.append("[");     // Catch: Exception -> L60
        File[] r16 = r10.listFiles();     // Catch: Exception -> L60
        int r18 = r16.length;     // Catch: Exception -> L60
        int r21 = 0;
    L48:
        if (r21 >= r18) goto L50;
        r11.append(r16[r21].getName());     // Catch: Exception -> L60
        r11.append(SimContactsConstants.EMAIL_SEP);     // Catch: Exception -> L60
        r21 = r21 + 1;     // Catch: Exception -> L60
        goto L48
    L50:
        r11.append("]");     // Catch: Exception -> L60
        r9.put("e_file", r11.toString());     // Catch: Exception -> L60
    L52:
        JSONObject r22 = AlogMonitor.getResult(false, 4, null, r9);
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 4, r22);
        if (r20 != null) goto L61;
    L55:
        AlogMonitor.log("alog upload file failed,local file is null");     // Catch: Exception -> L59
        return;
    L73:
        return;
    L61:
        r20.onCallback(false, r22);     // Catch: Exception -> L59
        goto L55
    L57:
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 12, AlogMonitor.getResult(false, 12, null, null));
    }

    public static void uploadAlogFiles(List<String> r9, String r10, IALogActiveUploadCallback r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.isEmpty() == true) goto L22;
        UploadRequest r12 = buildUploadRequest(r9);
        if (checkParamsForUploadRequest(r12) == true) goto L12;
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 5, null);
        if (r11 == null) goto L19;
        r11.onCallback(false, null);
        return;
    L19:
        return;
    L12:
        String r0 = zipUploadFile(r12.getAlogFiles());
        if (TextUtils.isEmpty(r0) == false) goto L15;
        boolean r13 = AlogUploadService.uploadAlogFiles(r12.getAid(), r12.getDid(), r12.getProcessName(), r12.getAlogFiles(), r10, r12.getCommonParams());
    L16:
        if (r11 == null) goto L21;
        r11.onCallback(r13, null);
        return;
    L21:
        return;
    L15:
        ArrayList r5 = new ArrayList();
        r5.add(r0);
        r13 = AlogUploadService.uploadAlogFiles(r12.getAid(), r12.getDid(), r12.getProcessName(), r5, r10, r12.getCommonParams());
        new File(r0).delete();
        goto L16
    }

    private static String zipUploadFile(List<String> r4) {
        File r0 = new File(r4.get(0));
        File r2 = new File(r0.getParent(), getZipFileName(r0.getName()));
        if (r2.exists() == false) goto L14;
        r2.delete();
    L14:
        FileUtils.compress(r2.getAbsolutePath(), (String[]) r4.toArray(new String[0]));     // Catch: Exception -> L8
        return r2.getAbsolutePath();
    L9:
        if (r2.exists() == false) goto L17;
        r2.delete();     // Catch: Exception -> L13
        return null;
    L17:
        return null;
    L18:
        return null;
    }

    private static String getZipFileName(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 != (-1)) goto L11;
        return r4 + ".zip";
    L11:
        return r4.substring(0, r0) + ".zip";
    }

    private static UploadRequest buildUploadRequest(List<String> r4) {
        UploadRequest r0 = new UploadRequest();
        JSONObject r1 = ApmContext.getHeaderInner();
        if (r1 == null) goto L6;
        r0.setAid(r1.optString("aid"));
        r0.setDid(r1.optString("device_id"));
    L6:
        if (ProcessUtils.getCurProcessName(ApmContext.getContext()).contains(SimContactsConstants.ANR_SEP) == false) goto L8;
        String r2 = ProcessUtils.getCurProcessName(ApmContext.getContext());
    L9:
        r0.setProcessName(r2);
        r0.setAlogFiles(r4);
        r0.setCommonParams(r1);
        return r0;
    L8:
        r2 = "main";
        goto L9
    }

    private static boolean checkParamsForUploadRequest(UploadRequest r1) {
        if (TextUtils.isEmpty(r1.getAid()) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r1.getDid()) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r1.getProcessName()) == false) goto L9;
        return false;
    L9:
        if (r1.getAlogFiles() != null) goto L11;
        return false;
    L11:
        if (r1.getAlogFiles().size() == 0) goto L20;
        return true;
    L20:
        return false;
    }
}
