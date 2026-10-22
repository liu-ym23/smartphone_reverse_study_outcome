package v0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.DoNotInline;

/* renamed from: v0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0952a {
    @DoNotInline
    public static void a(AlarmManager alarmManager, int i4, long j4, PendingIntent pendingIntent) {
        alarmManager.setExact(i4, j4, pendingIntent);
    }
}
