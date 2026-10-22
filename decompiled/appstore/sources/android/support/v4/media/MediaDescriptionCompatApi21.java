package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaDescriptionCompatApi21 {

    public static class Builder {
        private Builder() {
        }

        public static Object build(Object r10) {
            return ((MediaDescription.Builder) r10).build();
        }

        public static Object newInstance() {
            return new MediaDescription.Builder();
        }

        public static void setDescription(Object r10, CharSequence r11) {
            ((MediaDescription.Builder) r10).setDescription(r11);
        }

        public static void setExtras(Object r10, Bundle r11) {
            ((MediaDescription.Builder) r10).setExtras(r11);
        }

        public static void setIconBitmap(Object r10, Bitmap r11) {
            ((MediaDescription.Builder) r10).setIconBitmap(r11);
        }

        public static void setIconUri(Object r10, Uri r11) {
            ((MediaDescription.Builder) r10).setIconUri(r11);
        }

        public static void setMediaId(Object r10, String r11) {
            ((MediaDescription.Builder) r10).setMediaId(r11);
        }

        public static void setSubtitle(Object r10, CharSequence r11) {
            ((MediaDescription.Builder) r10).setSubtitle(r11);
        }

        public static void setTitle(Object r10, CharSequence r11) {
            ((MediaDescription.Builder) r10).setTitle(r11);
        }
    }

    private MediaDescriptionCompatApi21() {
    }

    public static Object fromParcel(Parcel r10) {
        return MediaDescription.CREATOR.createFromParcel(r10);
    }

    public static CharSequence getDescription(Object r10) {
        return ((MediaDescription) r10).getDescription();
    }

    public static Bundle getExtras(Object r10) {
        return ((MediaDescription) r10).getExtras();
    }

    public static Bitmap getIconBitmap(Object r10) {
        return ((MediaDescription) r10).getIconBitmap();
    }

    public static Uri getIconUri(Object r10) {
        return ((MediaDescription) r10).getIconUri();
    }

    public static String getMediaId(Object r10) {
        return ((MediaDescription) r10).getMediaId();
    }

    public static CharSequence getSubtitle(Object r10) {
        return ((MediaDescription) r10).getSubtitle();
    }

    public static CharSequence getTitle(Object r10) {
        return ((MediaDescription) r10).getTitle();
    }

    public static void writeToParcel(Object r10, Parcel r11, int r12) {
        ((MediaDescription) r10).writeToParcel(r11, r12);
    }
}
