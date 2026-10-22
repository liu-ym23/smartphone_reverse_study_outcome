package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class q {
    @DoNotInline
    public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
        return builder.addAction(action);
    }

    @DoNotInline
    public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
        return builder.addExtras(bundle);
    }

    @DoNotInline
    public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
        return builder.addRemoteInput(remoteInput);
    }

    @DoNotInline
    public static Notification.Action d(Notification.Action.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    public static Notification.Action.Builder e(int i4, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(i4, charSequence, pendingIntent);
    }

    @DoNotInline
    public static String f(Notification notification) {
        return notification.getGroup();
    }

    @DoNotInline
    public static Notification.Builder g(Notification.Builder builder, String str) {
        return builder.setGroup(str);
    }

    @DoNotInline
    public static Notification.Builder h(Notification.Builder builder, boolean z4) {
        return builder.setGroupSummary(z4);
    }

    @DoNotInline
    public static Notification.Builder i(Notification.Builder builder, boolean z4) {
        return builder.setLocalOnly(z4);
    }

    @DoNotInline
    public static Notification.Builder j(Notification.Builder builder, String str) {
        return builder.setSortKey(str);
    }
}
