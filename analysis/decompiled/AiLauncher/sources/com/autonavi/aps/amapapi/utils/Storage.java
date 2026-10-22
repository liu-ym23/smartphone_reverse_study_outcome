package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.sse.ServerSentEventKt;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class Storage {

    /* renamed from: a, reason: collision with root package name */
    private static Storage f18468a;

    /* renamed from: b, reason: collision with root package name */
    static Byte[] f18469b = new Byte[0];

    private Storage() {
    }

    public static Storage getInstance() {
        synchronized (f18469b) {
            try {
                if (f18468a == null) {
                    f18468a = new Storage();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f18468a;
    }

    public void writeLog(String str) {
    }

    public void writeLog(String str, String str2) {
        if (Utils.extMemAvl()) {
            StringBuilder sb2 = new StringBuilder();
            if (str.contains(Const.STR_KML)) {
                str = ((Const.STR_KML + File.separator) + Utils.formatUTC(0L, "yyyyMMdd") + ".") + Const.STR_KML;
            }
            sb2.append(DebugUtils.getWPath());
            sb2.append(str);
            String string = sb2.toString();
            File file = new File(string);
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                try {
                    sb2.delete(0, sb2.length());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (file.exists() || file.createNewFile()) {
                    if (!str.contains(Const.STR_KML)) {
                        sb2.append(Utils.formatUTC(0L, null));
                        sb2.append(Const.STR_MART_WELL);
                        sb2.append(CoreUtil.strAppname);
                        sb2.append(Const.STR_MART_WELL);
                    }
                    sb2.append(str2);
                    sb2.append(ServerSentEventKt.END_OF_LINE);
                    String string2 = sb2.toString();
                    FileOutputStream fileOutputStream = new FileOutputStream(string, true);
                    DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                    dataOutputStream.write(string2.getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    sb2.delete(0, sb2.length());
                }
            }
        }
    }

    public void writeLog(Context context, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getExternalFilesDir(Parameters.DEBUG).getAbsolutePath());
        sb2.append(File.separator);
        sb2.append(str);
        String string = sb2.toString();
        File file = new File(string);
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            try {
                sb2.delete(0, sb2.length());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (file.exists() || file.createNewFile()) {
                if (!str.contains(Const.STR_KML)) {
                    sb2.append(Utils.formatUTC(0L, null));
                    sb2.append(Const.STR_MART_WELL);
                    sb2.append(CoreUtil.strAppname);
                    sb2.append(Const.STR_MART_WELL);
                }
                sb2.append(str2);
                sb2.append(ServerSentEventKt.END_OF_LINE);
                String string2 = sb2.toString();
                FileOutputStream fileOutputStream = new FileOutputStream(string, true);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                dataOutputStream.write(string2.getBytes("UTF-8"));
                dataOutputStream.flush();
                dataOutputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                sb2.delete(0, sb2.length());
            }
        }
    }
}
