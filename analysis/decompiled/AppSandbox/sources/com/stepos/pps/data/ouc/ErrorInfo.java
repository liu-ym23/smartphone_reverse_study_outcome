package com.stepos.pps.data.ouc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.stepos.pps.data.ouc.cloud.CloudUserConfigManager;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.FileListContent;
import com.stepos.pps.data.util.FileUtils;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import java.io.File;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ErrorInfo extends FileListContent {
    public static final String ERROR_TYPE_ANR = "anr";
    public static final String ERROR_TYPE_CRASH = "crash";
    public static final String ERROR_TYPE_EMS = "ems";
    public static final String ERROR_TYPE_KERNAL = "kernel_restart";
    public static final String ERROR_TYPE_NATIVE_CRASH = "native_crash";
    public static final String ERROR_TYPE_PROCESS_SHRINKER = "process_shrinker";
    public static final String ERROR_TYPE_STRICTMODE_VM = "strictmode_vm";
    public static final String ERROR_TYPE_SYS_RESTART = "system_restart";
    public static final String ERROR_TYPE_SYS_UPDATE_ERROR = "system_update_error";
    public static final String ERROR_TYPE_THERMAL = "thermal";
    public static final String ERROR_TYPE_WATCHDOG = "watchdog";
    public String cellId;
    public String cpuUsage;
    public String dns;
    public String dropboxTag;
    public String dump;
    public File dumpFile;
    public String dumpSign;
    public String expLogId;
    public File extFile;
    public String extFileSign;
    public String ip;
    public String location;
    public String memUsage;
    public String network;
    public String packageName;
    public String processName;
    public String steposInsideId;
    public String steposVersion;
    public String tag;
    public String tagSign;
    public String type;
    public int version;
    public String versionName;
    public String versionType;

    public ErrorInfo() {
    }

    public ErrorInfo(String str, String str2, String str3, String str4, String str5, File file, File file2, Context context) {
        this.uuid = UUID.randomUUID().toString();
        this.type = str;
        this.packageName = str2;
        this.version = 0;
        this.processName = str3;
        this.tag = str4;
        this.dump = str5;
        this.dumpFile = file;
        this.extFile = file2;
        this.dropboxTag = null;
        this.versionName = null;
        this.network = Utils.getNetworkType(context);
        this.ip = Utils.getIpAddresses(context);
        this.dns = Utils.getDns(context);
        this.cellId = "";
        this.location = Utils.getLocation(context);
        this.memUsage = "";
        this.cpuUsage = "";
        this.time = System.currentTimeMillis();
        this.steposVersion = Build.DISPLAY;
        this.steposInsideId = Utils.getInsideId();
        this.versionType = CloudUserConfigManager.currentVersionType();
    }

    public ErrorInfo(String str, String str2, String str3, int i, String str4, String str5, String str6, File file, File file2, String str7, String str8, String str9, String str10, Context context) {
        this.uuid = str;
        this.type = str2;
        this.packageName = str3;
        this.version = i;
        this.processName = str4;
        this.tag = str5;
        this.dump = str6;
        this.dumpFile = file;
        this.extFile = file2;
        this.dropboxTag = str7;
        this.versionName = str8;
        this.network = Utils.getNetworkType(context);
        this.ip = Utils.getIpAddresses(context);
        this.dns = Utils.getDns(context);
        this.cellId = "";
        this.location = Utils.getLocation(context);
        this.memUsage = "";
        this.cpuUsage = "";
        this.time = System.currentTimeMillis();
        this.steposVersion = TextUtils.isEmpty(str9) ? Build.DISPLAY : str9;
        this.steposInsideId = TextUtils.isEmpty(str10) ? Utils.getInsideId() : str10;
        this.versionType = CloudUserConfigManager.currentVersionType();
    }

    public static ErrorInfo from(JSONObject jSONObject, Context context) throws JSONException, PackageManager.NameNotFoundException {
        PackageManager packageManager;
        String string = UUID.randomUUID().toString();
        String string2 = jSONObject.has("type") ? jSONObject.getString("type") : "";
        boolean zHas = jSONObject.has("Package");
        String string3 = Constants.UNKNOWN;
        String string4 = zHas ? jSONObject.getString("Package") : Constants.UNKNOWN;
        int i = jSONObject.has("version") ? jSONObject.getInt("version") : 0;
        if (jSONObject.has("Process")) {
            string3 = jSONObject.getString("Process");
        }
        String str = string3;
        String string5 = jSONObject.has("tag") ? jSONObject.getString("tag") : "";
        File file = jSONObject.has("dumpFile") ? new File(jSONObject.getString("dumpFile")) : null;
        File file2 = jSONObject.has("ZipLogFile") ? new File(jSONObject.getString("ZipLogFile")) : null;
        String string6 = jSONObject.has("dump") ? jSONObject.getString("dump") : "";
        String string7 = jSONObject.has("dropBoxTag") ? jSONObject.getString("dropBoxTag") : "";
        String string8 = jSONObject.has("versionName") ? jSONObject.getString("versionName") : "";
        String string9 = jSONObject.has("StepOS-Version") ? jSONObject.getString("StepOS-Version") : "";
        String string10 = jSONObject.has("StepOS-Inside-ID") ? jSONObject.getString("StepOS-Inside-ID") : "";
        String string11 = jSONObject.has("ExpLogId") ? jSONObject.getString("ExpLogId") : "";
        if (!TextUtils.isEmpty(string4) && i == 0 && (packageManager = context.getPackageManager()) != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(string4, 0);
                if (packageInfo != null) {
                    i = packageInfo.versionCode;
                    string8 = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                LogUtil.e("ErroInfo", "get package " + string4 + "info error.");
            }
        }
        ErrorInfo errorInfo = new ErrorInfo(string, string2, string4, i, str, string5, string6, file, file2, string7, string8, string9, string10, context);
        errorInfo.expLogId = string11;
        return errorInfo;
    }

    @Override // com.stepos.pps.data.util.FileListContent
    public boolean deleteFile() {
        File file = this.dumpFile;
        boolean zDelete = (file == null || !file.exists()) ? true : FileUtils.delete(this.dumpFile);
        File file2 = this.extFile;
        return (file2 == null || !file2.exists()) ? zDelete : zDelete && FileUtils.delete(this.extFile);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ErrorInfo{type='");
        sb.append(this.type);
        sb.append("', packageName='");
        sb.append(this.packageName);
        sb.append("', version=");
        sb.append(this.version);
        sb.append(", processName='");
        sb.append(this.processName);
        sb.append("', tagSign='");
        sb.append(this.tagSign);
        sb.append("', tag='");
        sb.append(this.tag);
        sb.append("', dumpSign='");
        sb.append(this.dumpSign);
        sb.append("', dumpFile exists:");
        sb.append(this.dumpFile != null);
        sb.append("', extFile exists:");
        sb.append(this.extFile != null);
        sb.append("', extFileSign='");
        sb.append(this.extFileSign);
        sb.append("', dropboxTag='");
        sb.append(this.dropboxTag);
        sb.append("', steposVersion='");
        sb.append(this.steposVersion);
        sb.append("', steposInsideId='");
        sb.append(this.steposInsideId);
        sb.append("', expLogId='");
        sb.append(this.expLogId);
        sb.append("', versionType='");
        sb.append(this.versionType);
        sb.append("'}");
        return sb.toString();
    }
}
