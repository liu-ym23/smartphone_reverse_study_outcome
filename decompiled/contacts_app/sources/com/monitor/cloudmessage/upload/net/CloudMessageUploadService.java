package com.monitor.cloudmessage.upload.net;

import android.text.TextUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.utils.StringUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class CloudMessageUploadService {
    public static final String API_PATH = "monitor/collect/c/cloudcontrol/file";
    static final String BOUNDARY = null;
    static final String COMMON_PARAMS_FILETYPE = "command_commonparams";
    static final String CONTENT_TYPE = "multipart/form-data";
    public static String ENCODE = "UTF-8";
    static final String LINE_END = "\r\n";
    static final String PREFIX = "--";
    static final String SPECIFIC_PARAMS_FILETYPE = "command_specificparams";
    public static String UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/cloudcontrol/file";
    public static Map<String, String> map;

    public CloudMessageUploadService() {
    }

    static {
        map = new HashMap();
        BOUNDARY = "cloudMessage" + UUID.randomUUID().toString();
    }

    public static boolean uploadFile(FileUploadInfo r15) {
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r15.getUploadFileAbsluteNames().size()) goto L27;
        File r3 = new File(r15.getUploadFileAbsluteNames().get(r1));
        if (r3.exists() == false) goto L26;
        if (r1 >= (r15.getUploadFileAbsluteNames().size() - 1)) goto L11;
        int r4 = 1;
    L13:
        if (r15.isForceUseState() == false) goto L15;
        r4 = r15.getCloudMsgResponseCode();
    L15:
        boolean r5 = postFile(UPLOAD_URL, r3, null, r4, r15.getFileType(), r15.getCommandId(), r15.getErrorMsg(), r15.getOperateTime(), r15.getSpecificParams());
        if (r5 == true) goto L18;
    L20:
        if (r1 != 0) goto L22;
        r2 = r5;
        goto L26
    L22:
        if (r2 == false) goto L25;
        if (r5 == false) goto L25;
        r2 = true;
    L25:
        r2 = false;
        goto L26
    L18:
        if (r15.isCompress() == false) goto L20;
        r3.delete();
        goto L20
    L11:
        r4 = 2;
    L26:
        r1 = r1 + 1;
        goto L4
    L27:
        return r2;
    }

    public static boolean uploadData(UploadInfo r8) {
        return postWithoutFile(UPLOAD_URL, null, r8.getCloudMsgResponseCode(), r8.getCommandId(), r8.getErrorMsg(), r8.getOperateTime(), r8.getSpecificParams());
    }

    public static boolean uploadFile(File r10, int r11, String r12, String r13, String r14, long r15, HashMap<String, String> r17) {
        return postFile(UPLOAD_URL, r10, null, r11, r12, r13, r14, r15, r17);
    }

    private static boolean postFile(String r14, File r15, Map<String, String> r16, int r17, String r18, String r19, String r20, long r21, HashMap<String, String> r23) {
        if (TextUtils.isEmpty(r14) == true) goto L81;
        if (r15 == null) goto L81;
        if (r15.exists() == false) goto L81;
        HttpURLConnection r6 = null;
        HttpURLConnection r8 = NetUtils.getUrlConnection(r14);     // Catch: Throwable -> L59
        r8.setReadTimeout(30000);     // Catch: Throwable -> L56
        r8.setConnectTimeout(30000);     // Catch: Throwable -> L56
        r8.setDoInput(true);     // Catch: Throwable -> L56
        r8.setDoOutput(true);     // Catch: Throwable -> L56
        r8.setUseCaches(false);     // Catch: Throwable -> L56
        r8.setRequestMethod("POST");     // Catch: Throwable -> L56
        r8.setRequestProperty("Charset", ENCODE);     // Catch: Throwable -> L56
        r8.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L56
        r8.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);     // Catch: Throwable -> L56
        Map<String, String> r5 = map;     // Catch: Throwable -> L56
        if (r5 != null) goto L13;
    L23:
        r8.connect();     // Catch: Throwable -> L56
        DataOutputStream r7 = new DataOutputStream(r8.getOutputStream());     // Catch: Throwable -> L56
        StringBuffer r9 = new StringBuffer();     // Catch: Throwable -> L54
        r9.append(PREFIX);     // Catch: Throwable -> L54
        String r10 = BOUNDARY;     // Catch: Throwable -> L54
        r9.append(r10);     // Catch: Throwable -> L54
        r9.append("\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r17 + "\r\n" + PREFIX + r10 + "\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r19 + "\r\n" + PREFIX + r10 + "\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r20 + "\r\n" + PREFIX + r10 + "\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r21 + "\r\n" + PREFIX + r10 + "\r\n");     // Catch: Throwable -> L54
        StringBuilder r11 = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L54
        CloudMessageManager.getInstance();     // Catch: Throwable -> L54
        r9.append(r11.append(CloudMessageManager.getAid()).append("\r\n").append(PREFIX).append(r10).append("\r\n").toString());     // Catch: Throwable -> L54
        StringBuilder r12 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L54
        CloudMessageManager.getInstance();     // Catch: Throwable -> L54
        r9.append(r12.append(CloudMessageManager.getUpdateVersionCode()).append("\r\n").append(PREFIX).append(r10).append("\r\n").toString());     // Catch: Throwable -> L54
        StringBuilder r13 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L54
        CloudMessageManager.getInstance();     // Catch: Throwable -> L54
        r9.append(r13.append(CloudMessageManager.getUid()).append("\r\n").append(PREFIX).append(r10).append("\r\n").toString());     // Catch: Throwable -> L54
        if (r17 != 2) goto L27;
    L32:
        r7.write(r9.toString().getBytes());     // Catch: Throwable -> L54
        writeAddtionalInfo(r7, r23);     // Catch: Throwable -> L54
        r9.setLength(0);     // Catch: Throwable -> L54
    L33:
        r9.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + r18 + "\"; filename=\"" + r15.getName() + "\"\r\n");     // Catch: Throwable -> L54
        r9.append("Content-Type: text/plain\r\n");     // Catch: Throwable -> L54
        r9.append("\r\n");     // Catch: Throwable -> L54
        r7.write(r9.toString().getBytes());     // Catch: Throwable -> L54
        FileInputStream r1 = new FileInputStream(r15);     // Catch: Throwable -> L54
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L54
    L34:
        int r2 = r1.read(r0);     // Catch: Throwable -> L54
        if (r2 == (-1)) goto L37;
        r7.write(r0, 0, r2);     // Catch: Throwable -> L54
        goto L34
    L37:
        r1.close();     // Catch: Throwable -> L54
        r7.write("\r\n".getBytes());     // Catch: Throwable -> L54
        r7.write((PREFIX + BOUNDARY + PREFIX + "\r\n").getBytes());     // Catch: Throwable -> L54
        r7.flush();     // Catch: Throwable -> L54
        r7.close();     // Catch: Throwable -> L54
        if (r8.getResponseCode() != 200) goto L47;
        if (r8 == null) goto L84;
        r8.disconnect();
    L84:
        r7.close();     // Catch: Throwable -> L44
    L46:
        return true;
    L44:
        th = move-exception;
        th.printStackTrace();
        goto L46
    L47:
        if (r8 == null) goto L82;
        r8.disconnect();
    L82:
        r7.close();     // Catch: Throwable -> L51
    L53:
        return false;
    L51:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L27:
        if (r17 == 3) goto L32;
        if (r17 != 0) goto L33;
        if (r23 == null) goto L33;
        if (r23.isEmpty() == true) goto L33;
    L54:
        th = th;
    L58:
        r6 = r8;
    L86:
        th.printStackTrace();     // Catch: Throwable -> L70
        if (r6 == null) goto L64;
        r6.disconnect();
    L64:
        if (r7 != null) goto L92;
    L69:
        return false;
    L92:
        r7.close();     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        th.printStackTrace();
    L70:
        th = move-exception;
        if (r6 == null) goto L74;
        r6.disconnect();
    L74:
        if (r7 == null) goto L107;
        r7.close();     // Catch: Throwable -> L77
        throw th;
    L77:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L107:
        throw th;
    L13:
        if (r5.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r22 = map.entrySet().iterator();     // Catch: Throwable -> L56
    L16:
        if (r22.hasNext() == false) goto L23;
        Map.Entry<String, String> r110 = r22.next();     // Catch: Throwable -> L56
        String r111 = r110.getKey();     // Catch: Throwable -> L56
        String r112 = r110.getValue();     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r111) == true) goto L16;
        if (TextUtils.isEmpty(r112) == true) goto L16;
        r8.setRequestProperty(r111, r112);     // Catch: Throwable -> L56
    L56:
        th = th;
        r7 = null;
    L59:
        th = th;
        r7 = null;
    L81:
        throw new IllegalArgumentException("url and file not be null ");
    }

    private static void writeAddtionalInfo(DataOutputStream r4, HashMap<String, String> r5) throws Throwable {
        if (CloudMessageManager.getInstance().getCommonParams() != null) goto L5;
    L7:
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.size() == 0) goto L13;
        r4.write("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
        r4.write(StringUtils.getJsonString(r5).getBytes());
        r4.write("\r\n".getBytes());
        r4.write((PREFIX + BOUNDARY + "\r\n").getBytes());
        r4.flush();
        return;
    L13:
        return;
    L5:
        if (CloudMessageManager.getInstance().getCommonParams().size() == 0) goto L7;
        r4.write("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
        r4.write(StringUtils.getJsonString(CloudMessageManager.getInstance().getCommonParams()).getBytes());
        r4.write("\r\n".getBytes());
        r4.write((PREFIX + BOUNDARY + "\r\n").getBytes());
        r4.flush();
        goto L7
    }

    private static boolean postWithoutFile(String r8, Map<String, String> r9, int r10, String r11, String r12, long r13, HashMap<String, String> r15) {
        HttpURLConnection r3 = null;
        HttpURLConnection r14 = NetUtils.getUrlConnection(r8);     // Catch: Throwable -> L50
        r14.setReadTimeout(30000);     // Catch: Throwable -> L47
        r14.setConnectTimeout(30000);     // Catch: Throwable -> L47
        r14.setDoInput(true);     // Catch: Throwable -> L47
        r14.setDoOutput(true);     // Catch: Throwable -> L47
        r14.setUseCaches(false);     // Catch: Throwable -> L47
        r14.setRequestMethod("POST");     // Catch: Throwable -> L47
        r14.setRequestProperty("Charset", ENCODE);     // Catch: Throwable -> L47
        r14.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L47
        r14.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);     // Catch: Throwable -> L47
        Map<String, String> r1 = map;     // Catch: Throwable -> L47
        if (r1 != null) goto L8;
    L18:
        r14.connect();     // Catch: Throwable -> L47
        DataOutputStream r2 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L47
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L45
        r4.append(PREFIX);     // Catch: Throwable -> L45
        String r5 = BOUNDARY;     // Catch: Throwable -> L45
        r4.append(r5);     // Catch: Throwable -> L45
        r4.append("\r\n");     // Catch: Throwable -> L45
        r4.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r10 + "\r\n" + PREFIX + r5 + "\r\n");     // Catch: Throwable -> L45
        r4.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r11 + "\r\n" + PREFIX + r5 + "\r\n");     // Catch: Throwable -> L45
        r4.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r12 + "\r\n" + PREFIX + r5 + "\r\n");     // Catch: Throwable -> L45
        StringBuilder r16 = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L45
        CloudMessageManager.getInstance();     // Catch: Throwable -> L45
        r4.append(r16.append(CloudMessageManager.getAid()).append("\r\n").append(PREFIX).append(r5).append("\r\n").toString());     // Catch: Throwable -> L45
        StringBuilder r17 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L45
        CloudMessageManager.getInstance();     // Catch: Throwable -> L45
        r4.append(r17.append(CloudMessageManager.getUpdateVersionCode()).append("\r\n").append(PREFIX).append(r5).append("\r\n").toString());     // Catch: Throwable -> L45
        r4.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r13 + "\r\n" + PREFIX + r5 + "\r\n");     // Catch: Throwable -> L45
        if (r10 != 2) goto L22;
    L27:
        r2.write(r4.toString().getBytes());     // Catch: Throwable -> L45
        writeAddtionalInfo(r2, r15);     // Catch: Throwable -> L45
        r4.setLength(0);     // Catch: Throwable -> L45
    L28:
        StringBuilder r18 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L45
        CloudMessageManager.getInstance();     // Catch: Throwable -> L45
        r4.append(r18.append(CloudMessageManager.getUid()).append("\r\n").append(PREFIX).append(r5).append("\r\n").toString());     // Catch: Throwable -> L45
        r2.write(r4.toString().getBytes());     // Catch: Throwable -> L45
        r2.flush();     // Catch: Throwable -> L45
        r2.close();     // Catch: Throwable -> L45
        if (r14.getResponseCode() != 200) goto L38;
        if (r14 == null) goto L70;
        r14.disconnect();
    L70:
        r2.close();     // Catch: Throwable -> L35
    L37:
        return true;
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L38:
        if (r14 == null) goto L84;
        r14.disconnect();
    L84:
        r2.close();     // Catch: Throwable -> L42
    L44:
        return false;
    L42:
        th = move-exception;
        th.printStackTrace();
        goto L44
    L22:
        if (r10 == 3) goto L27;
        if (r10 != 0) goto L28;
        if (r15 == null) goto L28;
        if (r15.isEmpty() == true) goto L28;
    L45:
        th = th;
    L49:
        r3 = r14;
    L82:
        th.printStackTrace();     // Catch: Throwable -> L61
        if (r3 == null) goto L55;
        r3.disconnect();
    L55:
        if (r2 != null) goto L76;
    L60:
        return false;
    L76:
        r2.close();     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        th.printStackTrace();
    L61:
        th = move-exception;
        if (r3 == null) goto L64;
        r3.disconnect();
    L64:
        if (r2 != null) goto L80;
    L69:
        throw th;
    L80:
        r2.close();     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        th.printStackTrace();
        goto L69
    L8:
        if (r1.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r6 = map.entrySet().iterator();     // Catch: Throwable -> L47
    L11:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<String, String> r7 = r6.next();     // Catch: Throwable -> L47
        String r19 = r7.getKey();     // Catch: Throwable -> L47
        String r20 = r7.getValue();     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r19) == true) goto L11;
        if (TextUtils.isEmpty(r20) == true) goto L11;
        r14.setRequestProperty(r19, r20);     // Catch: Throwable -> L47
    L47:
        th = th;
        r2 = null;
    L50:
        th = th;
        r2 = null;
        goto L82
    }
}
