package com.stepos.pps.data.ouc;

import android.os.DropBoxManager;
import android.text.TextUtils;
import com.stepos.pps.data.util.FileUtils;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DropBoxParseHelper {
    private static final Pattern APP = Pattern.compile("^pid: (\\d+), tid: (\\d+)(, name: .+)?  >>> (\\S+) <<<$");
    private static final String TAG = "PPS:DropBoxHeaderParser";

    public static JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        InputStream inputStream;
        JSONObject jSONObject = new JSONObject();
        BufferedReader bufferedReader = null;
        StringBuilder sb = null;
        bufferedReader = null;
        try {
            inputStream = entry.getInputStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    StringBuilder sb2 = new StringBuilder();
                    boolean zHas = false;
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (TextUtils.isEmpty(line) && sb == null) {
                            LogUtil.d(TAG, "First Empty line!!!, body start");
                            sb = new StringBuilder();
                            zHas = jSONObject.has(ExceptionManagerStepOS.SUBJECT);
                        } else if (sb != null) {
                            sb.append(line);
                            sb.append("\n");
                            if (!zHas && line.startsWith("Subject: ")) {
                                String[] strArrSplit = line.split(": ", 2);
                                if (strArrSplit.length == 2) {
                                    jSONObject.put(strArrSplit[0], strArrSplit[1]);
                                    LogUtil.d(TAG, "k = " + strArrSplit[0] + ", v = " + strArrSplit[1]);
                                }
                                zHas = true;
                            }
                        } else {
                            String[] strArrSplit2 = line.split(": ", 2);
                            if (strArrSplit2.length == 2) {
                                jSONObject.put(strArrSplit2[0], strArrSplit2[1]);
                                LogUtil.d(TAG, "k = " + strArrSplit2[0] + ", v = " + strArrSplit2[1]);
                            } else {
                                LogUtil.w(TAG, "Invalid line: " + line);
                            }
                        }
                        sb2.append(line);
                        sb2.append("\n");
                    }
                    if (sb != null) {
                        jSONObject.put("body", sb.toString());
                    }
                    jSONObject.put("dump", sb2.toString());
                    FileUtils.closeQuietly(bufferedReader2);
                    FileUtils.closeQuietly(inputStream);
                    FileUtils.closeQuietly(entry);
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    FileUtils.closeQuietly(bufferedReader);
                    FileUtils.closeQuietly(inputStream);
                    FileUtils.closeQuietly(entry);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public static JSONObject parseTombstone(String str) throws JSONException {
        String[] strArrSplit = str.split("\n");
        int length = strArrSplit.length;
        StringBuilder sb = null;
        int i = 0;
        JSONObject jSONObject = null;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = strArrSplit[i];
            Matcher matcher = APP.matcher(str2);
            if (matcher.matches()) {
                jSONObject = new JSONObject();
                jSONObject.put("PID", matcher.group(1));
                jSONObject.put("app", matcher.group(4));
            }
            if (str2.contains("backtrace:")) {
                sb = new StringBuilder();
            }
            if (sb != null) {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                    sb.append("\n");
                } else {
                    LogUtil.d(TAG, "reach the first empty line in backtrace, stop it.");
                    break;
                }
            }
            i++;
        }
        if (jSONObject != null) {
            jSONObject.put("backtrace", sb == null ? "null" : sb.toString().trim());
        }
        return jSONObject;
    }
}
