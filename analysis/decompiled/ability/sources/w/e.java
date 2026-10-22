package w;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f6802a;

    public static String a(Context context, s.g gVar) {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (TextUtils.isEmpty(f6802a)) {
            synchronized (e.class) {
                if (!TextUtils.isEmpty(f6802a)) {
                    return f6802a;
                }
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        th.printStackTrace();
                    }
                }
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = gVar.e.getString("google_aid", null);
                } else if (!TextUtils.equals(gVar.e.getString("google_aid", null), id) && !TextUtils.isEmpty(id)) {
                    gVar.e.edit().putString("google_aid", id).apply();
                }
                f6802a = id;
            }
        }
        return f6802a;
    }
}
