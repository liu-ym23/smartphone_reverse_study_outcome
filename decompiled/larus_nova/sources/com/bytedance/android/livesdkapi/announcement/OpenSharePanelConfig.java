package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenSharePanelConfig;", "", "appointmentId", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "getAppointmentId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenSharePanelConfig {
    private final String appointmentId;
    private final Context context;

    public final String getAppointmentId() {
        return this.appointmentId;
    }

    public final Context getContext() {
        return this.context;
    }

    public OpenSharePanelConfig(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "appointmentId");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.appointmentId = r100;
        this.context = r101;
    }
}
