package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
class MediaDescriptionCompatApi23 {

    public static class Builder {
        private Builder() {
        }

        public static void setMediaUri(Object r100, Uri r101) {
            ((MediaDescription.Builder) r100).setMediaUri(r101);
        }
    }

    private MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object r100) {
        return ((MediaDescription) r100).getMediaUri();
    }
}
