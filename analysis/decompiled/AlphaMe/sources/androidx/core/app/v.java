package androidx.core.app;

import android.app.Notification;
import android.app.Person;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class v {
    @DoNotInline
    public static Notification.Builder a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    @DoNotInline
    public static Notification.Action.Builder b(Notification.Action.Builder builder, int i4) {
        return builder.setSemanticAction(i4);
    }
}
