package I0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f831d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f832a;

    /* renamed from: b, reason: collision with root package name */
    public final String f833b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f834c;

    public a(Drawable.Callback callback, String str, Map map) {
        this.f833b = str;
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f833b = str.concat("/");
        }
        if (callback instanceof View) {
            this.f832a = ((View) callback).getContext();
            this.f834c = map;
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f834c = new HashMap();
            this.f832a = null;
        }
    }

    public final void a(String str, Bitmap bitmap) {
        synchronized (f831d) {
            ((w) this.f834c.get(str)).f4587b = bitmap;
        }
    }

    public final void b() {
        synchronized (f831d) {
            try {
                Iterator it = this.f834c.entrySet().iterator();
                while (it.hasNext()) {
                    w wVar = (w) ((Map.Entry) it.next()).getValue();
                    Bitmap bitmap = wVar.f4587b;
                    if (bitmap != null) {
                        bitmap.recycle();
                        wVar.f4587b = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
