package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class NotificationTarget extends SimpleTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context r10, int r11, RemoteViews r12, Notification r13, int r14) {
        this(r10, r11, r12, r13, r14, null);
    }

    private void update() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.context.getSystemService("notification"))).notify(this.notificationTag, this.notificationId, this.notification);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object r10, @Nullable Transition r11) {
        onResourceReady((Bitmap) r10, r11);
    }

    public NotificationTarget(Context r10, int r11, RemoteViews r12, Notification r13, int r14, String r15) {
        this(r10, Integer.MIN_VALUE, Integer.MIN_VALUE, r11, r12, r13, r14, r15);
    }

    public void onResourceReady(@NonNull Bitmap r10, @Nullable Transition<? super Bitmap> r11) {
        this.remoteViews.setImageViewBitmap(this.viewId, r10);
        update();
    }

    public NotificationTarget(Context r10, int r11, int r12, int r13, RemoteViews r14, Notification r15, int r16, String r17) {
        super(r11, r12);
        this.context = (Context) Preconditions.checkNotNull(r10, "Context must not be null!");
        this.notification = (Notification) Preconditions.checkNotNull(r15, "Notification object can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r14, "RemoteViews object can not be null!");
        this.viewId = r13;
        this.notificationId = r16;
        this.notificationTag = r17;
    }
}
