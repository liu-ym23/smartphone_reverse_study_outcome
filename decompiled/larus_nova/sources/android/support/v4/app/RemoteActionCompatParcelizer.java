package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(VersionedParcel r100) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(r100);
    }

    public static void write(RemoteActionCompat r100, VersionedParcel r101) {
        androidx.core.app.RemoteActionCompatParcelizer.write(r100, r101);
    }
}
