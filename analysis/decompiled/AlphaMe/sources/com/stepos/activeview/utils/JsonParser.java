package com.stepos.activeview.utils;

import android.os.AsyncTask;
import android.os.SystemClock;
import com.alibaba.fastjson.JSON;
import com.stepos.activeview.listener.OnJsonParserListener;
import com.stepos.activeview.task.ParseJsonTask;

/* loaded from: classes.dex */
public class JsonParser {
    private static final String LOG_TAG = "activeview.JsonParser";

    public static <T> T parseJson(String str, Class<T> cls) {
        if (str.isEmpty()) {
            LogUtil.e(LOG_TAG, "jsonStr to parse is NULL!");
            return null;
        }
        try {
            long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            T t4 = (T) JSON.parseObject(str, cls);
            LogUtil.i(LOG_TAG, "parse jsonStr.length=" + str.length() + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis));
            return t4;
        } catch (Exception e4) {
            LogUtil.e(LOG_TAG, "Exception e=" + e4.getMessage());
            return null;
        }
    }

    public static <T> AsyncTask parseJsonAsync(String str, Class<T> cls, OnJsonParserListener onJsonParserListener) {
        if (str.isEmpty()) {
            LogUtil.e(LOG_TAG, "jsonStr to parse is NULL!");
            return null;
        }
        ParseJsonTask parseJsonTask = new ParseJsonTask(str, cls, onJsonParserListener);
        parseJsonTask.execute(new Object[0]);
        return parseJsonTask;
    }
}
