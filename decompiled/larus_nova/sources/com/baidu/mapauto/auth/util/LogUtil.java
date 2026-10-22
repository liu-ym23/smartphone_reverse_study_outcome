package com.baidu.mapauto.auth.util;

import com.baidu.mapauto.auth.base.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class LogUtil implements e {
    private static volatile LogUtil sUtil;
    private Boolean openLog;
    private final List<WeakReference<e>> wrOutput;

    private LogUtil() {
        this.openLog = Boolean.FALSE;
        this.wrOutput = new ArrayList(10);
    }

    public static LogUtil getInstance() {
        if (sUtil != null) goto L15;
        monitor-enter(LogUtil.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sUtil != null) goto L9;
        sUtil = new LogUtil();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LogUtil.class);     // Catch: Throwable -> L11
    L15:
        return sUtil;
    }

    public void addOutput(e r100) {
        this.wrOutput.add(new WeakReference(r100));
    }

    @Override // com.baidu.mapauto.auth.base.e
    public void e(String r100, String r101) {
        if (this.openLog.booleanValue() == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<e>> r102 = this.wrOutput.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        e r103 = r102.next().get();
        if (r103 == null) goto L10;
        r103.e(r100, r101);
        goto L7
    L10:
        r102.remove();
        goto L7
    }

    @Override // com.baidu.mapauto.auth.base.e
    public void i(String r100, String r101) {
        if (this.openLog.booleanValue() == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<e>> r102 = this.wrOutput.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        e r103 = r102.next().get();
        if (r103 == null) goto L10;
        r103.i(r100, r101);
        goto L7
    L10:
        r102.remove();
        goto L7
    }

    public void openLog(Boolean r100) {
        this.openLog = Boolean.FALSE;
    }

    public void removeOutput(e r100) {
        Iterator<WeakReference<e>> r101 = this.wrOutput.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        e r102 = r101.next().get();
        if (r102 == null) goto L8;
        if (r102 != r100) goto L4;
    L8:
        r101.remove();
        goto L4
    }
}
