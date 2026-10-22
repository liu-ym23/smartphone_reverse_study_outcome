package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceMoreSettingConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFromType", "", "isCreateAnnounce", "", "(Landroid/content/Context;IZ)V", "getContext", "()Landroid/content/Context;", "getEnterFromType", "()I", "()Z", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceMoreSettingConfig {
    private final Context context;
    private final int enterFromType;
    private final boolean isCreateAnnounce;

    public final Context getContext() {
        return this.context;
    }

    public final int getEnterFromType() {
        return this.enterFromType;
    }

    public final boolean isCreateAnnounce() {
        return this.isCreateAnnounce;
    }

    public OpenAnnounceMoreSettingConfig(Context r100, int r101, boolean r102) {
        this.context = r100;
        this.enterFromType = r101;
        this.isCreateAnnounce = r102;
    }
}
