package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
class MediaControllerCompatApi24 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void prepare(Object r10) {
            ((MediaController.TransportControls) r10).prepare();
        }

        public static void prepareFromMediaId(Object r10, String r11, Bundle r12) {
            ((MediaController.TransportControls) r10).prepareFromMediaId(r11, r12);
        }

        public static void prepareFromSearch(Object r10, String r11, Bundle r12) {
            ((MediaController.TransportControls) r10).prepareFromSearch(r11, r12);
        }

        public static void prepareFromUri(Object r10, Uri r11, Bundle r12) {
            ((MediaController.TransportControls) r10).prepareFromUri(r11, r12);
        }
    }

    private MediaControllerCompatApi24() {
    }
}
