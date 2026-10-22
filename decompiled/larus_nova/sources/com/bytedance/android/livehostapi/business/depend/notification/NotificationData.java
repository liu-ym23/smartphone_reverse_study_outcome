package com.bytedance.android.livehostapi.business.depend.notification;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/notification/NotificationData;", "", "roomCover", "Landroid/graphics/Bitmap;", "roomTitle", "", "anchorNickname", "isPlaying", "", "contentIntent", "Landroid/app/PendingIntent;", "playActionIntent", RemoteMessageConst.Notification.CHANNEL_ID, "pauseCancelNotificationActionIntent", "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;ZLandroid/app/PendingIntent;Landroid/app/PendingIntent;Ljava/lang/String;Landroid/app/PendingIntent;)V", "getAnchorNickname", "()Ljava/lang/String;", "getChannelId", "getContentIntent", "()Landroid/app/PendingIntent;", "()Z", "getPauseCancelNotificationActionIntent", "getPlayActionIntent", "getRoomCover", "()Landroid/graphics/Bitmap;", "getRoomTitle", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NotificationData {
    private final String anchorNickname;
    private final String channelId;
    private final PendingIntent contentIntent;
    private final boolean isPlaying;
    private final PendingIntent pauseCancelNotificationActionIntent;
    private final PendingIntent playActionIntent;
    private final Bitmap roomCover;
    private final String roomTitle;

    public final String getAnchorNickname() {
        return this.anchorNickname;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final PendingIntent getContentIntent() {
        return this.contentIntent;
    }

    public final PendingIntent getPauseCancelNotificationActionIntent() {
        return this.pauseCancelNotificationActionIntent;
    }

    public final PendingIntent getPlayActionIntent() {
        return this.playActionIntent;
    }

    public final Bitmap getRoomCover() {
        return this.roomCover;
    }

    public final String getRoomTitle() {
        return this.roomTitle;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public NotificationData(Bitmap r100, String r101, String r102, boolean r103, PendingIntent r104, PendingIntent r105, String r106, PendingIntent r107) {
        Intrinsics.checkNotNullParameter(r104, "contentIntent");
        Intrinsics.checkNotNullParameter(r106, RemoteMessageConst.Notification.CHANNEL_ID);
        this.roomCover = r100;
        this.roomTitle = r101;
        this.anchorNickname = r102;
        this.isPlaying = r103;
        this.contentIntent = r104;
        this.playActionIntent = r105;
        this.channelId = r106;
        this.pauseCancelNotificationActionIntent = r107;
    }

    public /* synthetic */ NotificationData(Bitmap r110, String r111, String r112, boolean r113, PendingIntent r114, PendingIntent r115, String r116, PendingIntent r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 128) == 0) goto L5;
        PendingIntent r100 = null;
    L6:
        this(r110, r111, r112, r113, r114, r115, r116, r100);
        return;
    L5:
        r100 = r117;
        goto L6
    }
}
