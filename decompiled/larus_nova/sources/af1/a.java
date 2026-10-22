package af1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3135a = 0;

    public a() {
    }

    static {
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "content");
        if (v.a() == true) goto L6;
        return;
    }

    public static void a(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r102, "content");
        if (r103 == false) goto L5;
        ALogger.e("LiveBackupSei", r100 + '#' + r101 + ", " + r102);
        return;
    L5:
        ALogger.i("LiveBackupSei", r100 + '#' + r101 + ", " + r102);
    }
}
