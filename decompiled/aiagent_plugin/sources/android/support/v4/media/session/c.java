package android.support.v4.media.session;

import android.media.session.MediaSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MediaSessionCompatApi22.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    public static void a(Object r2, int r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setRatingType(r3);
    }
}
