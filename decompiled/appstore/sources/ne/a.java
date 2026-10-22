package ne;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedanceos.common.toolbox.i;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f22449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f22450b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f22451c = null;

    static {
        f22449a = Uri.parse("content://com.bytedanceos.appbaselayer");
        f22450b = Uri.parse("content://os.teatracker");
        f22451c = Uri.parse("content://com.obric.idprovider");
    }

    public static String a(Context r10) {
        Bundle r11 = r10.getContentResolver().call(f22450b, "getDeviceId", null, null);     // Catch: Exception -> L5
    L7:
        if (r11 != null) goto L9;
        return null;
    L9:
        return r11.getString("key_device_info", null);
    L5:
        e = move-exception;
        i.k("Utils", e.getMessage());
        r11 = null;
        goto L7
    }
}
