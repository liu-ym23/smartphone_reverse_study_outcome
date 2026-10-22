package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
class MediaControllerCompatApi24 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void prepare(Object r100) {
            ((MediaController.TransportControls) r100).prepare();
        }

        public static void prepareFromMediaId(Object r100, String r101, Bundle r102) {
            ((MediaController.TransportControls) r100).prepareFromMediaId(r101, r102);
        }

        public static void prepareFromSearch(Object r100, String r101, Bundle r102) {
            ((MediaController.TransportControls) r100).prepareFromSearch(r101, r102);
        }

        public static void prepareFromUri(Object r100, Uri r101, Bundle r102) {
            ((MediaController.TransportControls) r100).prepareFromUri(r101, r102);
        }
    }

    private MediaControllerCompatApi24() {
    }
}
