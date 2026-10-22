package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Parcel;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class MediaMetadataCompatApi21 {

    public static class Builder {
        public static Object newInstance() {
            return new MediaMetadata.Builder();
        }

        private Builder() {
        }

        public static Object build(Object r100) {
            return ((MediaMetadata.Builder) r100).build();
        }

        public static void putBitmap(Object r100, String r101, Bitmap r102) {
            ((MediaMetadata.Builder) r100).putBitmap(r101, r102);
        }

        public static void putLong(Object r100, String r101, long r102) {
            ((MediaMetadata.Builder) r100).putLong(r101, r102);
        }

        public static void putRating(Object r100, String r101, Object r102) {
            ((MediaMetadata.Builder) r100).putRating(r101, (Rating) r102);
        }

        public static void putString(Object r100, String r101, String r102) {
            ((MediaMetadata.Builder) r100).putString(r101, r102);
        }

        public static void putText(Object r100, String r101, CharSequence r102) {
            ((MediaMetadata.Builder) r100).putText(r101, r102);
        }
    }

    private MediaMetadataCompatApi21() {
    }

    public static Object createFromParcel(Parcel r100) {
        return MediaMetadata.CREATOR.createFromParcel(r100);
    }

    public static Set<String> keySet(Object r100) {
        return ((MediaMetadata) r100).keySet();
    }

    public static Bitmap getBitmap(Object r100, String r101) {
        return ((MediaMetadata) r100).getBitmap(r101);
    }

    public static long getLong(Object r100, String r101) {
        return ((MediaMetadata) r100).getLong(r101);
    }

    public static Object getRating(Object r100, String r101) {
        return ((MediaMetadata) r100).getRating(r101);
    }

    public static CharSequence getText(Object r100, String r101) {
        return ((MediaMetadata) r100).getText(r101);
    }

    public static void writeToParcel(Object r100, Parcel r101, int r102) {
        ((MediaMetadata) r100).writeToParcel(r101, r102);
    }
}
