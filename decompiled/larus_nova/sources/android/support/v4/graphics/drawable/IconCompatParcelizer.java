package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes2.dex */
public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    public IconCompatParcelizer() {
    }

    public static IconCompat read(VersionedParcel r100) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read(r100);
    }

    public static void write(IconCompat r100, VersionedParcel r101) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write(r100, r101);
    }
}
