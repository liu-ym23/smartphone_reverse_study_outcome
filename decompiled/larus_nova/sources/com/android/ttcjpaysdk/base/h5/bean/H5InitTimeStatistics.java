package com.android.ttcjpaysdk.base.h5.bean;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import qd4.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/bean/H5InitTimeStatistics;", "Lqd4/b;", "", "time", "", "setOnPageStartedTime", "getStartTime", "getInitTime", "getOnCreateDuration", "getLoadUrlDuration", "getLoadResourceTime", "getOnPageStartedDuration", "getOnPageFinishedDuration", DyPayConstant.KEY_START_TIME, "J", "onPageStartedTime", "onPageFinishedTime", "onCreateTime", "loadUrlTime", "loadResourceTime", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class H5InitTimeStatistics implements b {
    public long loadResourceTime;
    public long loadUrlTime;
    public long onCreateTime;
    public long onPageFinishedTime;
    public long onPageStartedTime;
    public long startTime;

    public H5InitTimeStatistics() {
    }

    @Override // qd4.b
    public long getInitTime() {
        long r100 = this.startTime;
        if (r100 == 0) goto L9;
        long r101 = this.loadUrlTime;
        if ((r101 - r100) > 30000) goto L9;
        return r101 - r100;
    L9:
        CJPayCallBackCenter.getInstance().uploadExceptionLog("H5InitTimeStatistics", "getInitTime", "H5初始化时间统计异常");
        return 0;
    }

    @Override // qd4.b
    public long getLoadUrlDuration() {
        return this.loadUrlTime - this.startTime;
    }

    @Override // qd4.b
    public long getOnCreateDuration() {
        return this.onCreateTime - this.startTime;
    }

    public long getOnPageFinishedDuration() {
        return this.onPageFinishedTime - this.startTime;
    }

    @Override // qd4.b
    public long getOnPageStartedDuration() {
        return this.onPageStartedTime - this.startTime;
    }

    @Override // qd4.b
    public long getLoadResourceTime() {
        return this.loadResourceTime;
    }

    @Override // qd4.b
    public long getStartTime() {
        return this.startTime;
    }

    public final void setOnPageStartedTime(long r100) {
        if (this.onPageStartedTime != 0) goto L6;
        this.onPageStartedTime = r100;
        return;
    }
}
