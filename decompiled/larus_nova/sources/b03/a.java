package b03;

import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16857a = null;

    public a() {
    }

    static {
        f16857a = new a();
    }

    public static boolean a() {
        if (FoldScreenUtils.f() == true) goto L5;
    L7:
        return false;
    L5:
        if (FoldScreenUtils.a() != 0) goto L7;
        return true;
    }

    public static boolean b() {
        if (PadConfigUtils.c() == false) goto L5;
    L8:
        return true;
    L5:
        if (PadConfigUtils.c() == true) goto L8;
        return false;
    }

    public static boolean c() {
        return !e5.n();
    }
}
