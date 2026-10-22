package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public class AppWidgetTarget extends CustomTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    private void update() {
        AppWidgetManager r100 = AppWidgetManager.getInstance(this.context);
        ComponentName r101 = this.componentName;
        if (r101 == null) goto L5;
        r100.updateAppWidget(r101, this.remoteViews);
        return;
    L5:
        r100.updateAppWidget(this.widgetIds, this.remoteViews);
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

    public AppWidgetTarget(Context r100, int r101, RemoteViews r110, ComponentName r111) {
        this(r100, Integer.MIN_VALUE, Integer.MIN_VALUE, r101, r110, r111);
    }

    public AppWidgetTarget(Context r100, int r101, RemoteViews r110, int... r111) {
        this(r100, Integer.MIN_VALUE, Integer.MIN_VALUE, r101, r110, r111);
    }

    public AppWidgetTarget(Context r100, int r101, int r102, int r103, RemoteViews r104, int... r105) {
        super(r101, r102);
        if (r105.length == 0) goto L7;
        this.context = (Context) Preconditions.checkNotNull(r100, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r104, "RemoteViews object can not be null!");
        this.widgetIds = (int[]) Preconditions.checkNotNull(r105, "WidgetIds can not be null!");
        this.viewId = r103;
        this.componentName = null;
        return;
    L7:
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    public AppWidgetTarget(Context r100, int r101, int r102, int r103, RemoteViews r104, ComponentName r105) {
        super(r101, r102);
        this.context = (Context) Preconditions.checkNotNull(r100, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r104, "RemoteViews object can not be null!");
        this.componentName = (ComponentName) Preconditions.checkNotNull(r105, "ComponentName can not be null!");
        this.viewId = r103;
        this.widgetIds = null;
    }
}
