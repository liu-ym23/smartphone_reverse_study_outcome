package com.stepos.statsapp.v3.utils.log;

import O6.l;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.utils.CommonUtils;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class EncryptLogger implements ILog {
    private static final String TAG = "EncryptLogger";
    private SimpleDateFormat mDateformat;
    private EncryptBase64 mEncryptor;
    private File mLogFile;
    private int mMyPid;
    private String mPath;
    private final long MAX_FILE_SIZE = 10485760;
    private final String FILE_NAME = "usage_logs_v2.txt";
    private final String OLD_FILE_NAME = "usage_logs_v2_old.txt";

    public EncryptLogger(String str) {
        this.mPath = str;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        this.mLogFile = new File(str, "usage_logs_v2.txt");
        this.mEncryptor = new EncryptBase64("copyright");
        this.mDateformat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        this.mMyPid = Process.myPid();
    }

    @Override // com.stepos.statsapp.v3.utils.log.ILog
    public void print(LogLevel logLevel, String str, String str2, long j10) throws Throwable {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mDateformat.format(new Date()));
            sb2.append("\t");
            sb2.append(this.mMyPid);
            sb2.append(l.DATE_SEPARATOR);
            sb2.append(j10);
            sb2.append("\t");
            sb2.append(logLevel == LogLevel.DEBUG ? "D" : logLevel == LogLevel.INFO ? "I" : logLevel == LogLevel.WARN ? ExifInterface.LONGITUDE_WEST : ExifInterface.LONGITUDE_EAST);
            sb2.append("/");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(str2);
            String strEncode = this.mEncryptor.encode(sb2.toString().getBytes(Charset.forName("UTF-8")));
            if (this.mLogFile.exists() && this.mLogFile.length() + strEncode.getBytes().length > 10485760) {
                String parent = this.mLogFile.getParent();
                File file = new File(parent, "usage_logs_v2_old.txt");
                if (file.exists()) {
                    file.delete();
                }
                this.mLogFile.renameTo(new File(parent, "usage_logs_v2_old.txt"));
                this.mLogFile = new File(this.mPath, "usage_logs_v2.txt");
            }
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(this.mLogFile, true);
                try {
                    fileWriter2.write(strEncode);
                    fileWriter2.write(ServerSentEventKt.END_OF_LINE);
                    CommonUtils.closeQuietly(fileWriter2);
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    CommonUtils.closeQuietly(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    CommonUtils.closeQuietly(fileWriter);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            Log.e(TAG, "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
        }
    }
}
