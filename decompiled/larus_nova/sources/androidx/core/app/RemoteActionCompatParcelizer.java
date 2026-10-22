package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes17.dex */
public class RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(VersionedParcel r100) {
        RemoteActionCompat r101 = new RemoteActionCompat();
        r101.mIcon = (IconCompat) r100.readVersionedParcelable(r101.mIcon, 1);
        r101.mTitle = r100.readCharSequence(r101.mTitle, 2);
        r101.mContentDescription = r100.readCharSequence(r101.mContentDescription, 3);
        r101.mActionIntent = (PendingIntent) r100.readParcelable(r101.mActionIntent, 4);
        r101.mEnabled = r100.readBoolean(r101.mEnabled, 5);
        r101.mShouldShowIcon = r100.readBoolean(r101.mShouldShowIcon, 6);
        return r101;
    }

    public static void write(RemoteActionCompat r100, VersionedParcel r101) {
        r101.setSerializationFlags(false, false);
        r101.writeVersionedParcelable(r100.mIcon, 1);
        r101.writeCharSequence(r100.mTitle, 2);
        r101.writeCharSequence(r100.mContentDescription, 3);
        r101.writeParcelable(r100.mActionIntent, 4);
        r101.writeBoolean(r100.mEnabled, 5);
        r101.writeBoolean(r100.mShouldShowIcon, 6);
    }
}
