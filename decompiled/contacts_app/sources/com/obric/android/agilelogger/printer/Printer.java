package com.obric.android.agilelogger.printer;

import com.obric.android.agilelogger.LogItem;

/* JADX INFO: loaded from: classes3.dex */
public interface Printer {
    void flush();

    void println(LogItem r1);

    void release();
}
