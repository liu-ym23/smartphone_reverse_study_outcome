package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MediaControllerCompatApi23.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MediaControllerCompatApi23.java */
    public static class C0001a {
        public static void a(Object r2, Uri r3, Bundle r4) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).playFromUri(r3, r4);
        }
    }
}
