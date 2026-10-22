package androidx.webkit;

import android.os.Handler;
import android.webkit.WebMessagePort;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes17.dex */
public abstract class WebMessagePortCompat {

    public static abstract class WebMessageCallbackCompat {
        public WebMessageCallbackCompat() {
        }

        public void onMessage(WebMessagePortCompat r100, WebMessageCompat r101) {
        }
    }

    public WebMessagePortCompat() {
    }

    public abstract void close();

    public abstract WebMessagePort getFrameworkPort();

    public abstract InvocationHandler getInvocationHandler();

    public abstract void postMessage(WebMessageCompat r100);

    public abstract void setWebMessageCallback(Handler r100, WebMessageCallbackCompat r101);

    public abstract void setWebMessageCallback(WebMessageCallbackCompat r100);
}
