package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSubmitSuccessConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "announcementId", "", "callback", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "enterFromType", "", "fromChosenDialog", "", "calendarStartTime", "(Landroid/content/Context;JLcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;IZLjava/lang/Long;)V", "getAnnouncementId", "()J", "getCalendarStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCallback", "()Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "getContext", "()Landroid/content/Context;", "getEnterFromType", "()I", "getFromChosenDialog", "()Z", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceSubmitSuccessConfig {
    private final long announcementId;
    private final Long calendarStartTime;
    private final IAnnouncementService.AnnouncementDialogCallback callback;
    private final Context context;
    private final int enterFromType;
    private final boolean fromChosenDialog;

    public final long getAnnouncementId() {
        return this.announcementId;
    }

    public final Long getCalendarStartTime() {
        return this.calendarStartTime;
    }

    public final IAnnouncementService.AnnouncementDialogCallback getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getEnterFromType() {
        return this.enterFromType;
    }

    public final boolean getFromChosenDialog() {
        return this.fromChosenDialog;
    }

    public OpenAnnounceSubmitSuccessConfig(Context r100, long r101, IAnnouncementService.AnnouncementDialogCallback r102, int r103, boolean r104, Long r105) {
        this.context = r100;
        this.announcementId = r101;
        this.callback = r102;
        this.enterFromType = r103;
        this.fromChosenDialog = r104;
        this.calendarStartTime = r105;
    }

    public /* synthetic */ OpenAnnounceSubmitSuccessConfig(Context r110, long r111, IAnnouncementService.AnnouncementDialogCallback r112, int r113, boolean r114, Long r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        IAnnouncementService.AnnouncementDialogCallback r100 = null;
    L6:
        this(r110, r111, r100, r113, r114, r115);
        return;
    L5:
        r100 = r112;
        goto L6
    }
}
