package com.stepos.core.common.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.widget.RemoteViews;
import com.stepos.core.common.R;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDownloadNotificationViews {
    public static final ModelDownloadNotificationViews INSTANCE = new ModelDownloadNotificationViews();

    private ModelDownloadNotificationViews() {
    }

    public final RemoteViews build(Context context, CharSequence title, CharSequence subtitle, ModelDownloadNotifier.NotifVisualSpec spec, PendingIntent pendingIntent) {
        g.f(context, "context");
        g.f(title, "title");
        g.f(subtitle, "subtitle");
        g.f(spec, "spec");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notif_model_download);
        remoteViews.setTextViewText(R.id.notif_title, title);
        remoteViews.setTextViewText(R.id.notif_subtitle, subtitle);
        remoteViews.setImageViewBitmap(R.id.notif_action, NotifRingBitmap.INSTANCE.create(context, spec.getProgress(), spec.getState(), spec.getShowProgressRing()));
        remoteViews.setOnClickPendingIntent(R.id.notif_root, spec.getContentIntent());
        int i10 = R.id.notif_action;
        if (pendingIntent == null) {
            pendingIntent = spec.getContentIntent();
        }
        remoteViews.setOnClickPendingIntent(i10, pendingIntent);
        return remoteViews;
    }
}
