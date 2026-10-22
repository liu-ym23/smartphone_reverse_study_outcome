package b82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18011a = 0;

    static {
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (v.a() == false) goto L6;
        ALogger.i("TTLIVE_IM_INDUSTRY", r100);
        return;
    }

    public static void a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r101 != null) goto L5;
        ALogger.e("TTLIVE_IM_INDUSTRY", r100);
        return;
    L5:
        ALogger.e("TTLIVE_IM_INDUSTRY", r100, r101);
    }
}
