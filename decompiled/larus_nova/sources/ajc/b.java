package ajc;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes40.dex */
public final class b {
    public static void onEvent(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        a("video_shop_log", r100 + ":");
        return;
    }

    public static void a(String r100, String r101) {
        Logger.d("VideoShop", r100 + ":" + r101);
    }

    public static void b(String r100, String r101) {
        Logger.e("VideoShop", r100 + ":" + r101);
    }

    public static void c(String r100, String r101) {
        Logger.v("VideoShop", r100 + ":" + r101);
    }
}
