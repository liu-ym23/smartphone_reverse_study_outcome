package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.a;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(a r0) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(r0);
    }

    public static void write(RemoteActionCompat r0, a r1) {
        androidx.core.app.RemoteActionCompatParcelizer.write(r0, r1);
    }
}
