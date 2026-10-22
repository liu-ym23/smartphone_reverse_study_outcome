package androidx.core.app;

import android.app.Notification;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class t {
    @DoNotInline
    public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
        return builder.setAllowGeneratedReplies(z4);
    }

    @DoNotInline
    public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomBigContentView(remoteViews);
    }

    @DoNotInline
    public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomContentView(remoteViews);
    }

    @DoNotInline
    public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomHeadsUpContentView(remoteViews);
    }

    @DoNotInline
    public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
        return builder.setRemoteInputHistory(charSequenceArr);
    }
}
