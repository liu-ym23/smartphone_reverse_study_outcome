package android.support.v4.graphics.drawable;

import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    public IconCompatParcelizer() {
    }

    public static IconCompat read(VersionedParcel r10) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read(r10);
    }

    public static void write(IconCompat r10, VersionedParcel r11) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write(r10, r11);
    }
}
