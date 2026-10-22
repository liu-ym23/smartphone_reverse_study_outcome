package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceLinkExistVideoConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "announcementInfo", "Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "enterFromType", "", "isPostLink", "", "calendarStartTime", "", "callback", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;IZLjava/lang/Long;Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;)V", "getAnnouncementInfo", "()Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "getCalendarStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCallback", "()Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "getContext", "()Landroid/content/Context;", "getEnterFromType", "()I", "()Z", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceLinkExistVideoConfig {
    private final AnnouncementInfo announcementInfo;
    private final Long calendarStartTime;
    private final IAnnouncementService.AnnouncementDialogCallback callback;
    private final Context context;
    private final int enterFromType;
    private final boolean isPostLink;

    public final AnnouncementInfo getAnnouncementInfo() {
        return this.announcementInfo;
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

    public final boolean isPostLink() {
        return this.isPostLink;
    }

    public OpenAnnounceLinkExistVideoConfig(Context r100, AnnouncementInfo r101, int r102, boolean r103, Long r104, IAnnouncementService.AnnouncementDialogCallback r105) {
        Intrinsics.checkNotNullParameter(r101, "announcementInfo");
        Intrinsics.checkNotNullParameter(r105, "callback");
        this.context = r100;
        this.announcementInfo = r101;
        this.enterFromType = r102;
        this.isPostLink = r103;
        this.calendarStartTime = r104;
        this.callback = r105;
    }
}
