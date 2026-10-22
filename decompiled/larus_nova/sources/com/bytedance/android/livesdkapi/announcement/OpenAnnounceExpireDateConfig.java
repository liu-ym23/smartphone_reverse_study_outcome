package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceExpireDateConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFromType", "", "minCanSelectTimestamp", "", "maxCanSelectTimestamp", "curSelectTimeStamp", "(Landroid/content/Context;IJJJ)V", "getContext", "()Landroid/content/Context;", "getCurSelectTimeStamp", "()J", "getEnterFromType", "()I", "getMaxCanSelectTimestamp", "getMinCanSelectTimestamp", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceExpireDateConfig {
    private final Context context;
    private final long curSelectTimeStamp;
    private final int enterFromType;
    private final long maxCanSelectTimestamp;
    private final long minCanSelectTimestamp;

    public final Context getContext() {
        return this.context;
    }

    public final long getCurSelectTimeStamp() {
        return this.curSelectTimeStamp;
    }

    public final int getEnterFromType() {
        return this.enterFromType;
    }

    public final long getMaxCanSelectTimestamp() {
        return this.maxCanSelectTimestamp;
    }

    public final long getMinCanSelectTimestamp() {
        return this.minCanSelectTimestamp;
    }

    public OpenAnnounceExpireDateConfig(Context r100, int r101, long r102, long r103, long r104) {
        this.context = r100;
        this.enterFromType = r101;
        this.minCanSelectTimestamp = r102;
        this.maxCanSelectTimestamp = r103;
        this.curSelectTimeStamp = r104;
    }
}
