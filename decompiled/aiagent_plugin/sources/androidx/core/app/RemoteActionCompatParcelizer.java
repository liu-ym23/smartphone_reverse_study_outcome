package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(androidx.versionedparcelable.a r4) {
        RemoteActionCompat r0 = new RemoteActionCompat();
        r0.f1070a = (IconCompat) ZeusTransformUtils.preCheckCast(r4.b(r0.f1070a, 1), IconCompat.class, "com.obric.aiagent.plugin");
        r0.f1071b = r4.b(r0.f1071b, 2);
        r0.f1072c = r4.b(r0.f1072c, 3);
        r0.f1073d = (PendingIntent) ZeusTransformUtils.preCheckCast(r4.b(r0.f1073d, 4), PendingIntent.class, "com.obric.aiagent.plugin");
        r0.f1074e = r4.b(r0.f1074e, 5);
        r0.f = r4.b(r0.f, 6);
        return r0;
    }

    public static void write(RemoteActionCompat r2, androidx.versionedparcelable.a r3) {
        r3.a(false, false);
        r3.a(r2.f1070a, 1);
        r3.a(r2.f1071b, 2);
        r3.a(r2.f1072c, 3);
        r3.a(r2.f1073d, 4);
        r3.a(r2.f1074e, 5);
        r3.a(r2.f, 6);
    }
}
