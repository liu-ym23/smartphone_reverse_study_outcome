package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes17.dex */
public class IconCompatParcelizer {
    public IconCompatParcelizer() {
    }

    public static IconCompat read(VersionedParcel r100) {
        IconCompat r101 = new IconCompat();
        r101.mType = r100.readInt(r101.mType, 1);
        r101.mData = r100.readByteArray(r101.mData, 2);
        r101.mParcelable = r100.readParcelable(r101.mParcelable, 3);
        r101.mInt1 = r100.readInt(r101.mInt1, 4);
        r101.mInt2 = r100.readInt(r101.mInt2, 5);
        r101.mTintList = (ColorStateList) r100.readParcelable(r101.mTintList, 6);
        r101.mTintModeStr = r100.readString(r101.mTintModeStr, 7);
        r101.mString1 = r100.readString(r101.mString1, 8);
        r101.onPostParceling();
        return r101;
    }

    public static void write(IconCompat r100, VersionedParcel r101) {
        r101.setSerializationFlags(true, true);
        r100.onPreParceling(r101.isStream());
        int r102 = r100.mType;
        if ((-1) == r102) goto L5;
        r101.writeInt(r102, 1);
    L5:
        byte[] r103 = r100.mData;
        if (r103 == null) goto L8;
        r101.writeByteArray(r103, 2);
    L8:
        Parcelable r104 = r100.mParcelable;
        if (r104 == null) goto L11;
        r101.writeParcelable(r104, 3);
    L11:
        int r105 = r100.mInt1;
        if (r105 == 0) goto L14;
        r101.writeInt(r105, 4);
    L14:
        int r106 = r100.mInt2;
        if (r106 == 0) goto L17;
        r101.writeInt(r106, 5);
    L17:
        ColorStateList r107 = r100.mTintList;
        if (r107 == null) goto L20;
        r101.writeParcelable(r107, 6);
    L20:
        String r108 = r100.mTintModeStr;
        if (r108 == null) goto L23;
        r101.writeString(r108, 7);
    L23:
        String r109 = r100.mString1;
        if (r109 == null) goto L27;
        r101.writeString(r109, 8);
        return;
    }
}
