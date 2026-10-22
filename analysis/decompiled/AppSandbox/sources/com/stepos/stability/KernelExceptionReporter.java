package com.stepos.stability;

import android.os.PersistableBundle;
import android.os.Process;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import com.stepos.pps.reflect.SystemProperties;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class KernelExceptionReporter {
    private static final int FILE_WAIT_INTERVAL_MS = 10000;
    private static final String FULLDUMP_COMPRESS_DIR = "/sdcard/sysmonfulldump/";
    private static final String FULLDUMP_OUT_DIR = "/data/misc/stability/fulldump/fulldump_out/";
    private static final String KERNEL_CALL_TRACE_INFO = "/data/misc/stability/minidump/kernel-call-trace.info";
    private static final int MAX_FILE_WAIT_RETRIES = 6;
    private static final String MINIDUMP_BIN = "/data/misc/stability/minidump/minidump.bin";
    private static final String MINIDUMP_INFO = "/data/misc/stability/minidump/minidump.info";
    private static final String PACKAGE_NAME = "com.stepos.pps";
    public static final String TAG = "KernelExceptionReporter";
    private static final AtomicLong sExpLogSeq = new AtomicLong();

    private static String newExpLogId() {
        return Long.toHexString(System.currentTimeMillis()) + "_" + Process.myPid() + "_" + sExpLogSeq.getAndIncrement();
    }

    private static class KernelCrashData {
        private final String filePath;
        private final boolean needDelete;
        private final String packageName;
        private final String processName;
        private final String tagPath;
        private final String type;

        private KernelCrashData(String str, String str2, String str3, String str4, String str5, boolean z) {
            this.type = str;
            this.packageName = str2;
            this.processName = str3;
            this.filePath = str4;
            this.tagPath = str5;
            this.needDelete = z;
        }

        public String toString() {
            return "KernelCrashData{type='" + this.type + "', packageName='" + this.packageName + "', processName='" + this.processName + "', filePath='" + this.filePath + "', tagPath='" + this.tagPath + "', needDelete=" + this.needDelete + '}';
        }
    }

    private void checkMinidump() throws JSONException {
        File file = new File(MINIDUMP_BIN);
        File file2 = new File(MINIDUMP_INFO);
        if (!waitForFilesCreation(file, file2)) {
            if (!file.exists()) {
                LogUtil.d(TAG, "Minidump binary file does not exist: /data/misc/stability/minidump/minidump.bin");
                return;
            } else if (!file2.exists()) {
                LogUtil.d(TAG, "Minidump info file does not exist: /data/misc/stability/minidump/minidump.info");
                return;
            }
        }
        KernelCrashData kernelCrashData = new KernelCrashData("minidump", PACKAGE_NAME, PACKAGE_NAME, MINIDUMP_BIN, MINIDUMP_INFO, false);
        reportException(kernelCrashData);
        if (kernelCrashData.needDelete) {
            deleteMinidumpFiles(file, file2);
        }
    }

    private boolean waitForFilesCreation(File file, File file2) throws InterruptedException {
        for (int i = 6; i > 0; i--) {
            if (file.exists() && file2.exists()) {
                return true;
            }
            try {
                LogUtil.d(TAG, "Waiting for minidump files, remaining retries: " + i);
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                LogUtil.w(TAG, "File wait interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return file.exists() && file2.exists();
    }

    private void deleteMinidumpFiles(File file, File file2) {
        boolean zDeleteFileIfExists = deleteFileIfExists(file);
        boolean zDeleteFileIfExists2 = deleteFileIfExists(file2);
        LogUtil.d(TAG, "Minidump file deletion result - binary: " + zDeleteFileIfExists + ", info: " + zDeleteFileIfExists2 + ", all: " + (zDeleteFileIfExists && zDeleteFileIfExists2));
    }

    private boolean deleteFileIfExists(File file) {
        if (!file.exists()) {
            return true;
        }
        boolean zDelete = file.delete();
        if (!zDelete) {
            LogUtil.w(TAG, "Failed to delete file: " + file.getAbsolutePath());
        }
        return zDelete;
    }

    private void checkFulldump() throws JSONException, InterruptedException {
        File file = new File(FULLDUMP_COMPRESS_DIR);
        if ((!file.exists() || !file.isDirectory()) && !new File(FULLDUMP_OUT_DIR).exists()) {
            LogUtil.d(TAG, "Fulldump directory does not exist: /sdcard/sysmonfulldump/");
            return;
        }
        File fileWaitForFulldumpFileCreation = waitForFulldumpFileCreation(file);
        if (fileWaitForFulldumpFileCreation == null) {
            LogUtil.d(TAG, "No Fulldump*.tar.gz file found after 6 retries");
            return;
        }
        LogUtil.d(TAG, "Found fulldump file: " + fileWaitForFulldumpFileCreation.getName());
        reportException(new KernelCrashData("fulldump", PACKAGE_NAME, PACKAGE_NAME, "", "", false));
    }

    private File waitForFulldumpFileCreation(File file) throws InterruptedException {
        for (int i = 6; i > 0; i--) {
            File fileFindFulldumpFile = findFulldumpFile(file);
            if (fileFindFulldumpFile != null) {
                return fileFindFulldumpFile;
            }
            try {
                LogUtil.d(TAG, "Waiting for fulldump file, remaining retries: " + i);
                Thread.sleep(Constants.SYSTEM_SERVER_INTERVAL);
            } catch (InterruptedException e) {
                LogUtil.w(TAG, "Fulldump file wait interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return findFulldumpFile(file);
    }

    private File findFulldumpFile(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (name.startsWith("Fulldump") && name.endsWith(".tar.gz")) {
                    return file2;
                }
            }
        }
        return null;
    }

    void checkCrash() throws JSONException {
        checkMinidump();
    }

    private void reportException(KernelCrashData kernelCrashData) throws JSONException {
        String string;
        String str = SystemProperties.get("sys.stepos.bootreason");
        LogUtil.d(TAG, "reportException boot_reason: " + str);
        StringBuilder sb = new StringBuilder();
        try {
            if (kernelCrashData.tagPath != null && !kernelCrashData.tagPath.isEmpty()) {
                File file = new File(kernelCrashData.tagPath);
                if (file.exists()) {
                    sb.append(new String(Files.readAllBytes(file.toPath())).strip());
                }
            }
            File file2 = new File(KERNEL_CALL_TRACE_INFO);
            if (file2.exists()) {
                String strStrip = new String(Files.readAllBytes(file2.toPath())).strip();
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strStrip);
            }
        } catch (IOException e) {
            LogUtil.e(TAG, "Error reading subject info: " + e.getMessage());
        }
        String string2 = sb.toString();
        String strNewExpLogId = newExpLogId();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", kernelCrashData.type);
            string = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtil.e(TAG, "build exp_detail failed: " + e2.getMessage());
            string = "";
        }
        HashMap map = new HashMap();
        map.put("proc_name", Constants.ANDROID_PROCESS);
        map.put("pkg_name", Constants.ANDROID_PROCESS);
        map.put("app_ver", SystemProperties.get("ro.build.aios_version"));
        map.put("exp_reason", str);
        map.put("exp_detail", string);
        map.put("exp_log_id", strNewExpLogId);
        ExceptionManagerStepOS.writeExceptionCode("8010000003", map);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt(ExceptionManagerStepOS.PID, 0);
        persistableBundle.putInt(ExceptionManagerStepOS.UID, 0);
        persistableBundle.putString(ExceptionManagerStepOS.PACKAGE, kernelCrashData.packageName);
        persistableBundle.putString(ExceptionManagerStepOS.PROCESS, kernelCrashData.packageName);
        persistableBundle.putString(ExceptionManagerStepOS.EXCEPTION_LOG_PATH, kernelCrashData.filePath);
        persistableBundle.putString(ExceptionManagerStepOS.SUBJECT, string2);
        persistableBundle.putString("exp_log_id", strNewExpLogId);
        ExceptionManagerStepOS.reportException(ExceptionManagerStepOS.getExceptionType("KE"), ExceptionManagerStepOS.getExceptionLevel(ExceptionManagerStepOS.EXCEPTION_LEVEL_TYPE_FATAL), persistableBundle);
    }
}
