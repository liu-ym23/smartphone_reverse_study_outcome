package com.baidu.mshield.rp;

import android.content.Context;
import com.baidu.mshield.utility.b;

/* JADX INFO: loaded from: classes39.dex */
public class Report {
    private static Report mReporter;
    private Context mContext;

    public void fr() {
        b.a(this.mContext).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public void n() {
        b.a(this.mContext).c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    private Report(Context r100) {
        this.mContext = r100.getApplicationContext();
    }

    public static synchronized Report getInstance(Context r100) {
        monitor-enter(Report.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mReporter != null) goto L7;
        mReporter = new Report(r100);     // Catch: Throwable -> L10
    L7:
        Report r101 = mReporter;     // Catch: Throwable -> L10
        monitor-exit(Report.class);
        return r101;
    }

    public void r(boolean r100) {
        b.a(this.mContext).a(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public void s(String r100) {
        com.baidu.mshield.b.c.a.b("send log : " + r100);     // Catch: Throwable -> L5
        com.baidu.mshield.utility.a.b(this.mContext, r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public void sr(String r100) {
        com.baidu.mshield.b.c.a.b("send log : " + r100);     // Catch: Throwable -> L5
        b.a(this.mContext).a(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public void w(String r100) {
        com.baidu.mshield.utility.a.a(this.mContext, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public void i(String r100, String r101, String r102, String r110, String r111) {
        com.baidu.mshield.utility.a.a(this.mContext, r100, r101, r102, r110, r111);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }
}
