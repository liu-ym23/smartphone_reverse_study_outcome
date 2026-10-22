package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Parcel;
import androidx.annotation.RequiresApi;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaMetadataCompatApi21 {

    public static class Builder {
        private Builder() {
        }

        public static Object build(Object r10) {
            return ((MediaMetadata.Builder) r10).build();
        }

        public static Object newInstance() {
            return new MediaMetadata.Builder();
        }

        public static void putBitmap(Object r10, String r11, Bitmap r12) {
            ((MediaMetadata.Builder) r10).putBitmap(r11, r12);
        }

        public static void putLong(Object r10, String r11, long r12) {
            ((MediaMetadata.Builder) r10).putLong(r11, r12);
        }

        public static void putRating(Object r10, String r11, Object r12) {
            ((MediaMetadata.Builder) r10).putRating(r11, (Rating) r12);
        }

        public static void putString(Object r10, String r11, String r12) {
            ((MediaMetadata.Builder) r10).putString(r11, r12);
        }

        public static void putText(Object r10, String r11, CharSequence r12) {
            ((MediaMetadata.Builder) r10).putText(r11, r12);
        }
    }

    private MediaMetadataCompatApi21() {
    }

    public static Object createFromParcel(Parcel r10) {
        return MediaMetadata.CREATOR.createFromParcel(r10);
    }

    public static Bitmap getBitmap(Object r10, String r11) {
        return ((MediaMetadata) r10).getBitmap(r11);
    }

    public static long getLong(Object r10, String r11) {
        return ((MediaMetadata) r10).getLong(r11);
    }

    public static Object getRating(Object r10, String r11) {
        return ((MediaMetadata) r10).getRating(r11);
    }

    public static CharSequence getText(Object r10, String r11) {
        return ((MediaMetadata) r10).getText(r11);
    }

    public static Set<String> keySet(Object r10) {
        return ((MediaMetadata) r10).keySet();
    }

    public static void writeToParcel(Object r10, Parcel r11, int r12) {
        ((MediaMetadata) r10).writeToParcel(r11, r12);
    }
}
