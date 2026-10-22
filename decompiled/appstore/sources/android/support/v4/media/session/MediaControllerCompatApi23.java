package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class MediaControllerCompatApi23 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void playFromUri(Object r10, Uri r11, Bundle r12) {
            ((MediaController.TransportControls) r10).playFromUri(r11, r12);
        }
    }

    private MediaControllerCompatApi23() {
    }
}
