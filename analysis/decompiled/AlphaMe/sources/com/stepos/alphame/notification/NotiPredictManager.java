package com.stepos.alphame.notification;

import B0.g;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import ch.qos.logback.classic.net.SyslogAppender;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.FileUtil;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* loaded from: classes.dex */
public final class NotiPredictManager {
    private static NotiPredictManager sInstance;
    private NotiPredictor mPredictor;
    private ArrayList<Pair<String, String[]>> mWhitList = new ArrayList<>();

    private NotiPredictManager() {
        AlphaMeLogger.costLogBegin();
        init();
    }

    public static NotiPredictManager getInstance() {
        if (sInstance == null) {
            sInstance = new NotiPredictManager();
        }
        return sInstance;
    }

    private String getTagByWhiteList(String str) {
        Iterator<Pair<String, String[]>> it = this.mWhitList.iterator();
        while (it.hasNext()) {
            Pair<String, String[]> next = it.next();
            String[] strArr = (String[]) next.second;
            int length = strArr.length;
            for (int i4 = 0; i4 < length && str.contains(strArr[i4]); i4++) {
                if (i4 == length - 1) {
                    return (String) next.first;
                }
            }
        }
        return null;
    }

    private void unzipLocalResource() {
        try {
            FileUtil.unzipAssertFile(ApplicationImpl.getApplication(), "model_full.zip", NotiPredictor.getSzPath());
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        AlphaMeLogger.costLog("unzip end, mPredictor.isFileExist() = " + NotiPredictor.isFileExist());
    }

    public void addWhitelist(String str, String[] strArr) {
        this.mWhitList.add(new Pair<>(str, strArr));
    }

    public void clearFiles() {
        FileUtil.deleteFile(NotiPredictor.getParamPath());
        FileUtil.deleteFile(NotiPredictor.getCnnModelPath());
        FileUtil.deleteFile(NotiPredictor.getW2vModelPath());
        FileUtil.deleteFile(NotiPredictor.getStopwordsPath());
        FileUtil.clearFolder(new File(NotiPredictor.getDataPath()));
    }

    public void clearWhitelist() {
        this.mWhitList.clear();
    }

    public void init() {
        AlphaMeLogger.costLogBegin();
        if (!NotiPredictor.isFileExist()) {
            unzipLocalResource();
        }
        try {
            this.mPredictor = new NotiPredictor();
        } catch (Throwable th) {
            Log.e("NotiPredictManager", "init error:" + th);
            unzipLocalResource();
            this.mPredictor = new NotiPredictor();
        }
        AlphaMeLogger.costLog("init end");
    }

    public boolean isWhitelistEmpty() {
        return this.mWhitList.size() == 0;
    }

    public String notiPredict(String str) {
        NotiPredictor notiPredictor;
        String tagByWhiteList = getTagByWhiteList(str);
        if (TextUtils.isEmpty(tagByWhiteList) && (notiPredictor = this.mPredictor) != null) {
            tagByWhiteList = notiPredictor.predict(str).getTag();
        }
        if (Utils.DEBUG.get()) {
            StringBuilder sbW = g.w("notiPredict result = ", tagByWhiteList, ", whitelist tag = ");
            sbW.append(getTagByWhiteList(str));
            sbW.append(", content = ");
            sbW.append(str);
            AlphaMeLogger.dLog(sbW.toString());
        }
        return tagByWhiteList;
    }

    public void testNotiPredict(PrintWriter printWriter) throws IOException {
        AlphaMeLogger.costLogBegin();
        printWriter.println("ver: " + Property.getNotiVersion() + AwarenessDataItem.PERMISSION_SPLITTER);
        List<String> listLl = FileUtil.ll(new File(NotiPredictor.getSzPath()));
        if (listLl == null) {
            printWriter.println("not exist");
        } else {
            Iterator<String> it = listLl.iterator();
            while (it.hasNext()) {
                printWriter.println(it.next());
            }
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(NotiPredictor.getSzPath() + "data/dev.dat");
            try {
                Scanner scanner = new Scanner(fileInputStream, Constants.UTF_8_CODE);
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i4 = 0;
                int i5 = 0;
                while (scanner.hasNext()) {
                    String strNextLine = scanner.nextLine();
                    if (strNextLine.contains(SyslogAppender.DEFAULT_STACKTRACE_PATTERN)) {
                        String[] strArrSplit = strNextLine.split(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                        String str = strArrSplit[0];
                        AlphaMeLogger.costLogBegin();
                        String strNotiPredict = notiPredict(strArrSplit[1]);
                        if (str.equals(strNotiPredict)) {
                            i5++;
                        }
                        i4++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(AlphaMeLogger.costLog(strNotiPredict + "/" + str + ", " + i5 + "  " + i4));
                        sb.append(", content: ");
                        sb.append(strNextLine);
                        printWriter.println(sb.toString());
                    } else {
                        printWriter.println("invalid splitter, content: " + strNextLine);
                        i4++;
                    }
                }
                printWriter.println(AlphaMeLogger.costLog("平均：  " + ((System.currentTimeMillis() - jCurrentTimeMillis) / i4)));
                printWriter.println(AlphaMeLogger.costLog("end " + i5 + "  " + i4));
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}
