package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
class MediaControllerCompatApi23 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void playFromUri(Object r100, Uri r101, Bundle r102) {
            ((MediaController.TransportControls) r100).playFromUri(r101, r102);
        }
    }

    private MediaControllerCompatApi23() {
    }
}
