package androidx.core.app;

import android.app.Notification;
import android.content.LocusId;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class w {
    @DoNotInline
    public static Notification.Builder a(Notification.Builder builder, boolean z4) {
        return builder.setAllowSystemGeneratedContextualActions(z4);
    }

    @DoNotInline
    public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
        return builder.setBubbleMetadata(bubbleMetadata);
    }

    @DoNotInline
    public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z4) {
        return builder.setContextual(z4);
    }

    @DoNotInline
    public static Notification.Builder d(Notification.Builder builder, Object obj) {
        return builder.setLocusId((LocusId) obj);
    }
}
