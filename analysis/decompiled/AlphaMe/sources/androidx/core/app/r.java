package androidx.core.app;

import android.app.Notification;
import android.media.AudioAttributes;
import android.net.Uri;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class r {
    @DoNotInline
    public static Notification.Builder a(Notification.Builder builder, String str) {
        return builder.addPerson(str);
    }

    @DoNotInline
    public static Notification.Builder b(Notification.Builder builder, String str) {
        return builder.setCategory(str);
    }

    @DoNotInline
    public static Notification.Builder c(Notification.Builder builder, int i4) {
        return builder.setColor(i4);
    }

    @DoNotInline
    public static Notification.Builder d(Notification.Builder builder, Notification notification) {
        return builder.setPublicVersion(notification);
    }

    @DoNotInline
    public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
        return builder.setSound(uri, (AudioAttributes) obj);
    }

    @DoNotInline
    public static Notification.Builder f(Notification.Builder builder, int i4) {
        return builder.setVisibility(i4);
    }
}
