package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/AnnounceSequenceTipConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFromType", "", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "getEnterFromType", "()I", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnounceSequenceTipConfig {
    private final Context context;
    private final int enterFromType;

    public final Context getContext() {
        return this.context;
    }

    public final int getEnterFromType() {
        return this.enterFromType;
    }

    public AnnounceSequenceTipConfig(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.enterFromType = r101;
    }
}
