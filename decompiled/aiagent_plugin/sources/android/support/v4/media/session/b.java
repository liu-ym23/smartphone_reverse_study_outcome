package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MediaControllerCompatApi24.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: compiled from: MediaControllerCompatApi24.java */
    public static class a {
        public static void a(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).prepare();
        }

        public static void a(Object r2, String r3, Bundle r4) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).prepareFromMediaId(r3, r4);
        }

        public static void b(Object r2, String r3, Bundle r4) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).prepareFromSearch(r3, r4);
        }

        public static void a(Object r2, Uri r3, Bundle r4) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).prepareFromUri(r3, r4);
        }
    }
}
