package com.monitor.cloudmessage.refactor;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CommandResultUploader {
    private static final long IGNORE_WIFI_ONLY_PARAMS_THRESHOLD = 2097152;
    private static final String PENDING_UPLOAD_DIR = "cloud_uploading";
    private volatile File pendingDir;
    private final Map<String, Boolean> wifiOnlyResultMap;

    private static class InnerHolder {
        private static final CommandResultUploader instance = null;

        private InnerHolder() {
        }

        static /* synthetic */ CommandResultUploader access$000() {
            return instance;
        }

        static {
            instance = new CommandResultUploader();
        }
    }

    public CommandResultUploader() {
        this.wifiOnlyResultMap = new HashMap();
    }

    public static CommandResultUploader getInstance() {
        return InnerHolder.access$000();
    }

    public File getPendingDir() {
        if (this.pendingDir == null) goto L5;
    L9:
        ensureDirExist();
        return this.pendingDir;
    L5:
        if (ApmContext.getContext() == null) goto L7;
        this.pendingDir = new File(ApmContext.getContext().getFilesDir(), PENDING_UPLOAD_DIR);
        goto L9
    L7:
        return null;
    }

    public boolean isWifiOnly(String r1) {
        if (this.wifiOnlyResultMap.get(r1) != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized void upload(CloudMessage r11, File r12, String r13) throws Exception {
        monitor-enter(this);
        CommandReportUtils.uploadRunningMessage("命令产物已生成，等待上传", r11);     // Catch: Throwable -> L39
        ensureDirExist();     // Catch: Throwable -> L39
        String r1 = r11.getCommandId();     // Catch: Throwable -> L39
        File r2 = getPendingDir();     // Catch: Throwable -> L39
        if (r2 == null) goto L38;
        File r3 = new File(r2, r1);     // Catch: Throwable -> L39
        if (r3.exists() == false) goto L9;
        FileUtils.deleteFile(r3);     // Catch: Throwable -> L39
    L9:
        r12.renameTo(r3);     // Catch: Throwable -> L39
        long r4 = CommonMonitorUtil.getFileDirSize(r3);     // Catch: Throwable -> L39
        boolean r5 = true;
        if (r11.isWifiOnly() == true) goto L12;
    L14:
        boolean r14 = false;
    L15:
        this.wifiOnlyResultMap.put(r1, Boolean.valueOf(r14));     // Catch: Throwable -> L39
        if (r14 == true) goto L18;
    L22:
        File[] r15 = r3.listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L39
        int r0 = r15.length;     // Catch: Throwable -> L39
        int r6 = 0;
    L23:
        if (r6 >= r0) goto L32;
        File r7 = r15[r6];     // Catch: Throwable -> L39
        boolean r8 = CommandReportUtils.uploadFile(r1, r7, r13, "正在上传:" + r7.getName());     // Catch: Throwable -> L39
        StringBuilder r9 = new StringBuilder().append("文件上传");     // Catch: Throwable -> L39
        if (r8 == false) goto L27;
        String r10 = "成功";
    L28:
        CommandReportUtils.uploadRunningMessage(r9.append(r10).append(SimContactsConstants.ANR_SEP).append(r7.getName()).toString(), r11);     // Catch: Throwable -> L39
        if (r8 == true) goto L31;
        r5 = false;
    L31:
        r6 = r6 + 1;     // Catch: Throwable -> L39
        goto L23
    L27:
        r10 = "失败";
        goto L28
    L32:
        if (r5 == false) goto L34;
        CommandReportUtils.uploadSuccessMessage(r1);     // Catch: Throwable -> L39
    L34:
        FileUtils.deleteFile(r3);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L18:
        if (NetworkUtils.isWifi(CloudMessageManager.getInstance().getContext()) == true) goto L22;
        CommandReportUtils.uploadRunningMessage("产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r4, r11);     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L12:
        if (r4 <= 2097152) goto L14;
        r14 = true;
        goto L15
    L38:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    private void ensureDirExist() {
        if (this.pendingDir != null) goto L5;
        return;
    L5:
        if (this.pendingDir.exists() == true) goto L9;
        this.pendingDir.mkdirs();
        return;
    }
}
