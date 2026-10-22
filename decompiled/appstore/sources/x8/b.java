package x8;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.network.core.ImageLoader;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class b extends LruCache implements ImageLoader.ImageCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f25847a;

    static {
    }

    public b(int r10) {
        super(r10);
    }

    public static int b(Context r10, float r11) {
        return (int) (((((ActivityManager) r10.getSystemService("activity")).getMemoryClass() * r11) * 1024.0f) * 1024.0f);
    }

    public static synchronized b c() {
        monitor-enter(b.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f25847a != null) goto L9;
        f25847a = new b(b(BaseApplication.c(), 0.1f));     // Catch: Throwable -> L7
    L9:
        b r10 = f25847a;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r10;
    }

    public void a() {
        evictAll();
    }

    @Override // com.bytedanceos.common.network.core.ImageLoader.ImageCache
    public Bitmap getBitmap(String r10) {
        SoftReference r11 = (SoftReference) get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.get() != null) goto L7;
        return null;
    L7:
        if (((Bitmap) r11.get()).isRecycled() == false) goto L10;
        return null;
    L10:
        return (Bitmap) r11.get();
    }

    @Override // com.bytedanceos.common.network.core.ImageLoader.ImageCache
    public void putBitmap(String r10, Bitmap r11) {
        put(r10, new SoftReference(r11));
    }
}
