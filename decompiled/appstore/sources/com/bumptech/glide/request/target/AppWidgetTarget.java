package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class AppWidgetTarget extends SimpleTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context r10, int r11, int r12, int r13, RemoteViews r14, int... r15) {
        super(r11, r12);
        if (r15.length == 0) goto L7;
        this.context = (Context) Preconditions.checkNotNull(r10, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r14, "RemoteViews object can not be null!");
        this.widgetIds = (int[]) Preconditions.checkNotNull(r15, "WidgetIds can not be null!");
        this.viewId = r13;
        this.componentName = null;
        return;
    L7:
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void update() {
        AppWidgetManager r10 = AppWidgetManager.getInstance(this.context);
        ComponentName r11 = this.componentName;
        if (r11 == null) goto L5;
        r10.updateAppWidget(r11, this.remoteViews);
        return;
    L5:
        r10.updateAppWidget(this.widgetIds, this.remoteViews);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object r10, @Nullable Transition r11) {
        onResourceReady((Bitmap) r10, r11);
    }

    public void onResourceReady(@NonNull Bitmap r10, @Nullable Transition<? super Bitmap> r11) {
        this.remoteViews.setImageViewBitmap(this.viewId, r10);
        update();
    }

    public AppWidgetTarget(Context r10, int r11, RemoteViews r12, int... r13) {
        this(r10, Integer.MIN_VALUE, Integer.MIN_VALUE, r11, r12, r13);
    }

    public AppWidgetTarget(Context r10, int r11, int r12, int r13, RemoteViews r14, ComponentName r15) {
        super(r11, r12);
        this.context = (Context) Preconditions.checkNotNull(r10, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r14, "RemoteViews object can not be null!");
        this.componentName = (ComponentName) Preconditions.checkNotNull(r15, "ComponentName can not be null!");
        this.viewId = r13;
        this.widgetIds = null;
    }

    public AppWidgetTarget(Context r10, int r11, RemoteViews r12, ComponentName r13) {
        this(r10, Integer.MIN_VALUE, Integer.MIN_VALUE, r11, r12, r13);
    }
}
