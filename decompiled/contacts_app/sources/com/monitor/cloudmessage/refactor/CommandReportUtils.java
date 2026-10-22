package com.monitor.cloudmessage.refactor;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CommandReportUtils {
    public CommandReportUtils() {
    }

    public static void uploadRunningMessage(String r2, CloudMessage r3) {
        report(r3.getCommandId(), r2, 0, null);
    }

    public static void uploadRunningMessage(String r1, CloudMessage r2, Map<String, String> r3) {
        report(r2.getCommandId(), r1, 0, r3);
    }

    public static void uploadSuccessMessage(String r3) {
        report(r3, "上传成功", 2, null);
    }

    public static void uploadFailureMessage(String r2, String r3) {
        report(r3, r2, 3, null);
    }

    public static void report(String r7, String r8, int r9, Map<String, String> r10) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("cloudmessage", new String[]{"report: commandId=" + r7, ", message=" + r8, ", code=" + r9, ", specificParams=" + r10});
    L5:
        if (r10 == null) goto L7;
        HashMap r0 = new HashMap(r10);
    L8:
        UploadInfo r11 = new UploadInfo(0, false, r7, r0);
        r11.setCloudMsgResponseCode(r9);
        r11.setErrorMsg(r8);
        CloudMessageUploadManager.upload(r11);
        return;
    L7:
        r0 = null;
        goto L8
    }

    public static boolean uploadFile(String r10, File r11, String r12, String r13) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d("cloudmessage", new String[]{"postFile: commandId=" + r10, "postFile=" + r11.getAbsolutePath(), ", uploadMessage=" + r13, ", fileType=" + r12});
    L6:
        return CloudMessageUploadService.uploadFile(r11, 1, r12, r10, r13, System.currentTimeMillis(), null);
    }
}
