package com.stepos.alphame.utils;

import B0.g;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.http.HttpClient;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class AlphaMeLogger {
    private static final long DBAKTIME = 2592000000L;
    private static final boolean DBG = true;
    private static final String DBG_TAG = "AlphaMeLogger";
    private static int DEF_INDEX = 1;
    private static final long DMAXSIZE = 52428800;
    private static final String TAG = "alphame";
    private static final boolean USE_CLASS_NAME_FOR_TAG = false;
    private static boolean WRITE_TO_FILE_ENABLED = true;
    private static long lBakTime = 2592000000L;
    private static long lMaxSize = 52428800;
    private static String mClassFilter = "";
    private static long sCostLogBegin = 0;
    private static String strFileName = "alphame.log";
    private static LoggerThread thread;

    public static class Bean {
        String info;
        String level;
        String tag;

        private Bean() {
        }

        public /* synthetic */ Bean(int i4) {
            this();
        }

        public String toString() {
            if (TextUtils.isEmpty(this.level) && TextUtils.isEmpty(this.tag)) {
                return this.info;
            }
            StringBuilder sb = new StringBuilder("level [");
            sb.append(this.level);
            sb.append("] tag:[");
            sb.append(this.tag);
            sb.append("] msg[");
            return g.r(sb, this.info, "]");
        }
    }

    public static class LogConst {
        static final String BAK_SUFFIX = ".log.bak";
        static final String SUFFIX = ".log";

        private LogConst() {
        }
    }

    public static class LoggerThread extends HandlerThread implements Handler.Callback {
        private final String TAG;
        private int bytes;
        private Handler handler;
        private MessageQueue.IdleHandler idleHandler;
        private long lastWriteTime;
        private List<Bean> list;
        private FileWriter writer;

        public LoggerThread() {
            super("LoaderThread", 10);
            this.TAG = "LoggerThread";
            this.lastWriteTime = 0L;
            this.idleHandler = new MessageQueue.IdleHandler() { // from class: com.stepos.alphame.utils.AlphaMeLogger.LoggerThread.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() throws IOException {
                    try {
                        if (LoggerThread.this.writer != null) {
                            LoggerThread.this.writer.flush();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    Log.d(AlphaMeLogger.DBG_TAG, "FileWriter flush.");
                    LoggerThread.this.verifyFile();
                    synchronized (LoggerThread.this) {
                        try {
                            LoggerThread.this.notify();
                        } catch (IllegalMonitorStateException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return false;
                }
            };
        }

        private void executeFileOperation() {
            this.lastWriteTime = System.currentTimeMillis();
            List<Bean> list = this.list;
            if (list == null || list.size() == 0) {
                return;
            }
            for (Bean bean : this.list) {
                Message messageObtainMessage = this.handler.obtainMessage(0);
                messageObtainMessage.obj = bean;
                this.handler.sendMessage(messageObtainMessage);
            }
            this.list.clear();
            this.bytes = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void verifyFile() throws IOException {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(ApplicationImpl.getApplication().getExternalCacheDir().getPath());
                String str = File.separator;
                sb.append(str);
                sb.append("alphame_logger");
                sb.append(str);
                sb.append(AlphaMeLogger.strFileName);
                String string = sb.toString();
                File file = new File(string + ".log.bak");
                if (Math.abs(System.currentTimeMillis() - file.lastModified()) > AlphaMeLogger.lBakTime && file.exists()) {
                    file.delete();
                    Log.w("LoggerThread", "Timeout,del bak file.");
                }
                File file2 = new File(string);
                long length = file2.length();
                if (length > AlphaMeLogger.lMaxSize) {
                    Log.w("LoggerThread", "Log file size is too large : " + length + " ,backup it to new file");
                    file2.renameTo(file);
                    file2.createNewFile();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        private void write(Bean bean) throws IOException {
            String str = bean.level;
            String str2 = bean.tag;
            String str3 = bean.info;
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (this.writer == null) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(ApplicationImpl.getApplication().getExternalCacheDir().getPath());
                        String str4 = File.separator;
                        sb.append(str4);
                        sb.append("alphame_logger");
                        String string = sb.toString();
                        new File(string).mkdirs();
                        File file = new File(string + str4 + AlphaMeLogger.strFileName);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        this.writer = new FileWriter(file, true);
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                String str5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str5);
                sb2.append("  ");
                sb2.append(str);
                sb2.append("---");
                sb2.append(str2);
                String strR = g.r(sb2, AwarenessDataItem.USERID_SPLITTER, str3);
                if (str != null || str2 != null) {
                    str3 = strR;
                }
                try {
                    FileWriter fileWriter = this.writer;
                    if (fileWriter != null) {
                        fileWriter.append((CharSequence) str3);
                        this.writer.append((CharSequence) HttpClient.NEWLINE);
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        }

        public void execute(Bean bean) {
            if (this.handler == null) {
                this.handler = new Handler(getLooper(), this);
                ArrayList arrayList = new ArrayList();
                this.list = arrayList;
                this.list = Collections.synchronizedList(arrayList);
            }
            this.list.add(bean);
            this.bytes = bean.info.length() + this.bytes;
            executeFileOperation();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws IOException {
            Looper.myQueue().removeIdleHandler(this.idleHandler);
            Looper.myQueue().addIdleHandler(this.idleHandler);
            write((Bean) message.obj);
            return true;
        }

        @Override // android.os.HandlerThread
        public boolean quit() throws IOException {
            List<Bean> list = this.list;
            if (list != null && list.size() != 0) {
                executeFileOperation();
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            this.writer = null;
            Log.i("LoggerThread", "Logger thread quit.");
            return super.quit();
        }
    }

    public static void Log() {
        if (Utils.DEBUG.get()) {
            printLog("");
        }
    }

    public static String costLog(String str) {
        String str2 = "[ " + (System.currentTimeMillis() - sCostLogBegin) + " ] " + str;
        debugLog(TAG, str2);
        return str2;
    }

    public static void costLogAndRefresh(String str) {
        sCostLogBegin = System.currentTimeMillis();
        costLog(str);
    }

    public static void costLogBegin() {
        sCostLogBegin = System.currentTimeMillis();
    }

    public static void dLog(String str, boolean z4) {
        doDLog(str);
    }

    public static void debugILog(String str, String str2) {
        if (Utils.DEBUG.get()) {
            if (str == null) {
                str = TAG;
            }
            Log.i(str, str2);
        }
    }

    public static void debugLog(String str) {
        if (Utils.DEBUG.get()) {
            doDLog(str);
        }
    }

    public static void deleteLogFile() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(ApplicationImpl.getApplication().getExternalCacheDir().getPath());
            String str = File.separator;
            sb.append(str);
            sb.append("alphame_logger");
            String string = sb.toString();
            new File(string).mkdirs();
            File file = new File(string + str + strFileName);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static void doDLog(String str) {
        if (Utils.DEBUG.get()) {
            Log.d(getTag(), str);
        }
    }

    private static void doELog(String str) {
        Log.e(getTag(), str);
    }

    private static void doILog(String str) {
        if (Utils.DEBUG.get()) {
            Log.i(getTag(), str);
        }
    }

    private static void doVLog(String str) {
        if (Utils.DEBUG.get()) {
            Log.v(getTag(), str);
        }
    }

    public static void eLog(String str) {
        doELog(str);
    }

    public static void exceptionLog(String str, Exception exc) {
        Log.w(TAG, str, exc);
    }

    private static String getLogClassName() {
        Throwable th = new Throwable();
        int i4 = DEF_INDEX;
        StackTraceElement[] stackTrace = th.getStackTrace();
        while (stackTrace[i4].getClassName().equalsIgnoreCase("com.android.mms.util.MyLog")) {
            i4++;
        }
        String[] strArrSplit = stackTrace[i4].getClassName().split("\\.");
        return strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
    }

    private static String getTag() {
        return TAG;
    }

    public static void iLog(String str) {
        doILog(str);
    }

    private static void printLog(String str) {
        Throwable th = new Throwable();
        int i4 = DEF_INDEX;
        StackTraceElement[] stackTrace = th.getStackTrace();
        while (stackTrace[i4].getMethodName().equalsIgnoreCase("Log")) {
            i4++;
        }
        String className = stackTrace[i4].getClassName();
        String str2 = mClassFilter;
        if ("" == str2 || className.equalsIgnoreCase(str2)) {
            String methodName = stackTrace[i4].getMethodName();
            String strP = className + "[" + stackTrace[i4].getLineNumber() + "]--> " + methodName;
            int length = 100 - strP.length();
            for (int i5 = 0; i5 < length; i5++) {
                strP = AbstractC0351g.p(strP, AwarenessDataItem.PERMISSION_SPLITTER);
            }
            StringBuilder sbV = g.v(strP, "   | <-- ( ");
            int i6 = i4 + 1;
            sbV.append(stackTrace[i6].getClassName());
            sbV.append("[");
            sbV.append(stackTrace[i6].getLineNumber());
            sbV.append("]--> ");
            sbV.append(stackTrace[i6].getMethodName());
            sbV.append(" ) ");
            doDLog(sbV.toString());
            if (str == null || "" == str) {
                return;
            }
            doDLog(g.m("---> ", str));
        }
    }

    public static void printLogStack() {
        printLogStack("");
    }

    public static void vLog(String str) {
        doVLog(str);
    }

    public static void wLog(String str) {
        Log.w(getTag(), str);
    }

    public static void writeToFile(String str, String str2, String str3) {
        Log.i(str2, str3);
        if (WRITE_TO_FILE_ENABLED) {
            Bean bean = new Bean(0);
            bean.level = str;
            bean.tag = str2;
            bean.info = str3;
            if (thread == null) {
                synchronized (LoggerThread.class) {
                    try {
                        if (thread == null) {
                            LoggerThread loggerThread = new LoggerThread();
                            thread = loggerThread;
                            loggerThread.start();
                        }
                    } finally {
                    }
                }
            }
            thread.execute(bean);
        }
    }

    public static void dLog(String str) {
        doDLog(str);
    }

    public static void iLog(String str, String str2) {
        if (Utils.DEBUG.get()) {
            if (str == null) {
                str = TAG;
            }
            Log.i(str, str2);
        }
    }

    public static void printLogStack(String str) {
        Throwable th = new Throwable();
        int i4 = DEF_INDEX;
        StackTraceElement[] stackTrace = th.getStackTrace();
        while (stackTrace[i4].getMethodName().equalsIgnoreCase("printLogStack")) {
            i4++;
        }
        String className = stackTrace[i4].getClassName();
        String str2 = mClassFilter;
        if ("" == str2 || className.equalsIgnoreCase(str2)) {
            String methodName = stackTrace[i4].getMethodName();
            String string = className + "[" + stackTrace[i4].getLineNumber() + "]--> " + methodName;
            int length = 100 - string.length();
            for (int i5 = 0; i5 < length; i5++) {
                string = AbstractC0351g.p(string, AwarenessDataItem.PERMISSION_SPLITTER);
            }
            while (true) {
                i4++;
                if (i4 >= stackTrace.length) {
                    break;
                }
                StringBuilder sbV = g.v(string, "   | <-- ( ");
                sbV.append(stackTrace[i4].getClassName());
                sbV.append("[");
                sbV.append(stackTrace[i4].getLineNumber());
                sbV.append("]--> ");
                sbV.append(stackTrace[i4].getMethodName());
                sbV.append(" ) ");
                string = sbV.toString();
            }
            doDLog(string);
            if (str == null || "" == str) {
                return;
            }
            doDLog(g.m("---> ", str));
        }
    }

    public static void Log(Object... objArr) {
        if (Utils.DEBUG.get()) {
            printLog("");
            for (Object obj : objArr) {
                doDLog(obj.toString());
            }
        }
    }

    public static void dLog(Rect rect) {
        doDLog("| left = " + rect.left + " | top = " + rect.top + " | right = " + rect.right + " | bottom = " + rect.bottom);
    }

    public static void debugLog(String str, String str2) {
        if (Utils.DEBUG.get()) {
            if (str == null) {
                str = TAG;
            }
            Log.d(str, str2);
        }
    }
}
