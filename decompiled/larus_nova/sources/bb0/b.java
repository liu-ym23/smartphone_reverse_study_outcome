package bb0;

import com.bytedance.android.live.ktv.common.model.KtvMode;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes45.dex */
@Deprecated(message = "后续不要使用这个单例回调到业务侧")
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f18525a;

    public static KtvMode a() {
        a r100 = f18525a;
        if (r100 == null) goto L7;
        KtvMode r101 = r100.d();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return KtvMode.LIVE_KTV;
    }

    public static String b() {
        a r100 = f18525a;
        if (r100 == null) goto L6;
        String r101 = r100.k();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "ttlive_ktv";
    }

    static {
    }
}
