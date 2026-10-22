package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi23 {

    public interface Callback extends MediaSessionCompatApi21.a {
        void onPlayFromUri(Uri r1, Bundle r2);
    }

    static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T r3) {
            super((Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri r3, Bundle r4) {
            MediaSessionCompat.a(r4);
            ((Callback) ZeusTransformUtils.preCheckCast(this.mCallback, Callback.class, "com.obric.aiagent.plugin")).onPlayFromUri(r3, r4);
        }
    }

    public static Object a(Callback r2) {
        return new CallbackProxy((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.aiagent.plugin"));
    }
}
