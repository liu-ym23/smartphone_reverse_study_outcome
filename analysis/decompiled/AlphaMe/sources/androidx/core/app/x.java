package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class x {
    @DoNotInline
    public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
        return builder.setAuthenticationRequired(z4);
    }

    @DoNotInline
    public static Notification.Builder b(Notification.Builder builder, int i4) {
        return builder.setForegroundServiceBehavior(i4);
    }
}
