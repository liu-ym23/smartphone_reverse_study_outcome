package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    private void update() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.context.getSystemService("notification"))).notify(this.notificationTag, this.notificationId, this.notification);
    }

    private void setBitmap(Bitmap r100) {
        this.remoteViews.setImageViewBitmap(this.viewId, r100);
        update();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r100) {
        setBitmap(null);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object r100, Transition r101) {
        onResourceReady((Bitmap) r100, r101);
    }

    public void onResourceReady(Bitmap r100, Transition<? super Bitmap> r101) {
        setBitmap(r100);
    }

    public NotificationTarget(Context r100, int r101, RemoteViews r110, Notification r111, int r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public NotificationTarget(Context r110, int r111, RemoteViews r112, Notification r113, int r114, String r115) {
        this(r110, Integer.MIN_VALUE, Integer.MIN_VALUE, r111, r112, r113, r114, r115);
    }

    public NotificationTarget(Context r100, int r101, int r102, int r103, RemoteViews r104, Notification r105, int r106, String r107) {
        super(r101, r102);
        this.context = (Context) Preconditions.checkNotNull(r100, "Context must not be null!");
        this.notification = (Notification) Preconditions.checkNotNull(r105, "Notification object can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r104, "RemoteViews object can not be null!");
        this.viewId = r103;
        this.notificationId = r106;
        this.notificationTag = r107;
    }
}
