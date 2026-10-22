package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
class MediaDescriptionCompatApi21 {

    public static class Builder {
        public static Object newInstance() {
            return new MediaDescription.Builder();
        }

        private Builder() {
        }

        public static Object build(Object r100) {
            return ((MediaDescription.Builder) r100).build();
        }

        public static void setDescription(Object r100, CharSequence r101) {
            ((MediaDescription.Builder) r100).setDescription(r101);
        }

        public static void setExtras(Object r100, Bundle r101) {
            ((MediaDescription.Builder) r100).setExtras(r101);
        }

        public static void setIconBitmap(Object r100, Bitmap r101) {
            ((MediaDescription.Builder) r100).setIconBitmap(r101);
        }

        public static void setIconUri(Object r100, Uri r101) {
            ((MediaDescription.Builder) r100).setIconUri(r101);
        }

        public static void setMediaId(Object r100, String r101) {
            ((MediaDescription.Builder) r100).setMediaId(r101);
        }

        public static void setSubtitle(Object r100, CharSequence r101) {
            ((MediaDescription.Builder) r100).setSubtitle(r101);
        }

        public static void setTitle(Object r100, CharSequence r101) {
            ((MediaDescription.Builder) r100).setTitle(r101);
        }
    }

    private MediaDescriptionCompatApi21() {
    }

    public static Object fromParcel(Parcel r100) {
        return MediaDescription.CREATOR.createFromParcel(r100);
    }

    public static CharSequence getDescription(Object r100) {
        return ((MediaDescription) r100).getDescription();
    }

    public static Bundle getExtras(Object r100) {
        return ((MediaDescription) r100).getExtras();
    }

    public static Bitmap getIconBitmap(Object r100) {
        return ((MediaDescription) r100).getIconBitmap();
    }

    public static Uri getIconUri(Object r100) {
        return ((MediaDescription) r100).getIconUri();
    }

    public static String getMediaId(Object r100) {
        return ((MediaDescription) r100).getMediaId();
    }

    public static CharSequence getSubtitle(Object r100) {
        return ((MediaDescription) r100).getSubtitle();
    }

    public static CharSequence getTitle(Object r100) {
        return ((MediaDescription) r100).getTitle();
    }

    public static void writeToParcel(Object r100, Parcel r101, int r102) {
        ((MediaDescription) r100).writeToParcel(r101, r102);
    }
}
