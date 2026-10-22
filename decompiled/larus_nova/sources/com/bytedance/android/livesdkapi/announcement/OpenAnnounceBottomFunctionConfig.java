package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceBottomFunctionConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "announceInfo", "Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "enterFromType", "", "callback", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "stickerShowSwitch", "", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;ILcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;Z)V", "getAnnounceInfo", "()Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "getCallback", "()Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "getContext", "()Landroid/content/Context;", "getEnterFromType", "()I", "getStickerShowSwitch", "()Z", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceBottomFunctionConfig {
    private final AnnouncementInfo announceInfo;
    private final IAnnouncementService.AnnouncementDialogCallback callback;
    private final Context context;
    private final int enterFromType;
    private final boolean stickerShowSwitch;

    public final AnnouncementInfo getAnnounceInfo() {
        return this.announceInfo;
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

    public final boolean getStickerShowSwitch() {
        return this.stickerShowSwitch;
    }

    public OpenAnnounceBottomFunctionConfig(Context r100, AnnouncementInfo r101, int r102, IAnnouncementService.AnnouncementDialogCallback r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "announceInfo");
        this.context = r100;
        this.announceInfo = r101;
        this.enterFromType = r102;
        this.callback = r103;
        this.stickerShowSwitch = r104;
    }

    public /* synthetic */ OpenAnnounceBottomFunctionConfig(Context r100, AnnouncementInfo r101, int r102, IAnnouncementService.AnnouncementDialogCallback r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
