package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String r1, Bundle r2);

        void onPrepareFromSearch(String r1, Bundle r2);

        void onPrepareFromUri(Uri r1, Bundle r2);
    }

    static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        public CallbackProxy(T r3) {
            super((Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) ZeusTransformUtils.preCheckCast(this.mCallback, Callback.class, "com.obric.aiagent.plugin")).onPrepare();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String r3, Bundle r4) {
            MediaSessionCompat.a(r4);
            ((Callback) ZeusTransformUtils.preCheckCast(this.mCallback, Callback.class, "com.obric.aiagent.plugin")).onPrepareFromMediaId(r3, r4);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String r3, Bundle r4) {
            MediaSessionCompat.a(r4);
            ((Callback) ZeusTransformUtils.preCheckCast(this.mCallback, Callback.class, "com.obric.aiagent.plugin")).onPrepareFromSearch(r3, r4);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri r3, Bundle r4) {
            MediaSessionCompat.a(r4);
            ((Callback) ZeusTransformUtils.preCheckCast(this.mCallback, Callback.class, "com.obric.aiagent.plugin")).onPrepareFromUri(r3, r4);
        }
    }

    public static Object a(Callback r2) {
        return new CallbackProxy((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.aiagent.plugin"));
    }

    public static String a(Object r5) {
        MediaSession r6 = (MediaSession) ZeusTransformUtils.preCheckCast(r5, MediaSession.class, "com.obric.aiagent.plugin");
        return (String) ZeusTransformUtils.preCheckCast(r6.getClass().getMethod("getCallingPackage", new Class[0]).invoke(r6, new Object[0]), String.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        a(TAG, "Cannot execute MediaSession.getCallingPackage()", e);
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
