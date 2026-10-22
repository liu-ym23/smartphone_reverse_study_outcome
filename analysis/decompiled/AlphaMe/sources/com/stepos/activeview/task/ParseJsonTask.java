package com.stepos.activeview.task;

import android.os.AsyncTask;
import com.stepos.activeview.listener.OnJsonParserListener;
import com.stepos.activeview.utils.JsonParser;

/* loaded from: classes.dex */
public class ParseJsonTask<T> extends AsyncTask<Object, Integer, T> {
    private Class<T> mClass;
    private String mJsonStr;
    private OnJsonParserListener mListener;

    public ParseJsonTask(String str, Class<T> cls, OnJsonParserListener onJsonParserListener) {
        this.mJsonStr = str;
        this.mClass = cls;
        this.mListener = onJsonParserListener;
    }

    @Override // android.os.AsyncTask
    public T doInBackground(Object... objArr) {
        return (T) JsonParser.parseJson(this.mJsonStr, this.mClass);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(T t4) {
        if (isCancelled()) {
            this.mListener = null;
            return;
        }
        OnJsonParserListener onJsonParserListener = this.mListener;
        if (onJsonParserListener != null) {
            onJsonParserListener.onParseResult(t4);
        }
        this.mListener = null;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }
}
