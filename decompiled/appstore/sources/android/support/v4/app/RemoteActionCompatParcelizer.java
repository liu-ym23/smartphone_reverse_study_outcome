package android.support.v4.app;

import androidx.annotation.RestrictTo;
import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(VersionedParcel r10) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(r10);
    }

    public static void write(RemoteActionCompat r10, VersionedParcel r11) {
        androidx.core.app.RemoteActionCompatParcelizer.write(r10, r11);
    }
}
