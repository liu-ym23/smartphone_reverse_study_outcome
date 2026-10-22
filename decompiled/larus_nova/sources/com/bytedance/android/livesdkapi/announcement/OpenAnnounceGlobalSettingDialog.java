package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.bytedance.android.livesdk.announce.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceGlobalSettingDialog;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "enterFromType", "I", "getEnterFromType", "()I", "Lcom/bytedance/android/livesdk/announce/a;", "announceInfo", "Lcom/bytedance/android/livesdk/announce/a;", "getAnnounceInfo", "()Lcom/bytedance/android/livesdk/announce/a;", "<init>", "(Landroid/content/Context;ILcom/bytedance/android/livesdk/announce/a;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceGlobalSettingDialog {
    private final a announceInfo;
    private final Context context;
    private final int enterFromType;

    public final a getAnnounceInfo() {
        return this.announceInfo;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getEnterFromType() {
        return this.enterFromType;
    }

    public OpenAnnounceGlobalSettingDialog(Context r100, int r101, a r102) {
        Intrinsics.checkNotNullParameter(r102, "announceInfo");
        this.context = r100;
        this.enterFromType = r101;
        this.announceInfo = r102;
    }
}
