package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MediaDescriptionCompatApi23.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: compiled from: MediaDescriptionCompatApi23.java */
    static class a {
        public static void a(Object r2, Uri r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.aiagent.plugin")).setMediaUri(r3);
        }
    }

    public static Uri a(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.aiagent.plugin")).getMediaUri();
    }
}
