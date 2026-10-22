package al3;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.android.ec.core.utils.font.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.android.ec.core.utils.font.a> f4127a;

    /* JADX INFO: renamed from: al3.a$a, reason: collision with other inner class name */
    public static final class C0079a {
    }

    static {
    }

    public a() {
        this.f4127a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.ec.core.utils.font.e
    public final Typeface a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (1 > r101) goto L9;
        if (400 < r101) goto L9;
    L20:
        String r102 = "fonts/douyin_number_abc_medium.otf";
    L21:
        com.bytedance.android.ec.core.utils.font.a r103 = this.f4127a.get(r102);
        if (r103 != null) goto L31;
        Typeface r104 = Typeface.createFromAsset(r100.getAssets(), r102);     // Catch: Throwable -> L26
    L27:
        this.f4127a.put(r102, new com.bytedance.android.ec.core.utils.font.a(r104));
        return r104;
    L26:
        r104 = null;
        goto L27
    L31:
        return r103.f45593a;
    L9:
        if (401 > r101) goto L15;
        if (500 < r101) goto L15;
        r102 = "fonts/douyin_number_abc_bold.otf";
    L15:
        if (501 > r101) goto L20;
        if (1000 < r101) goto L20;
        r102 = "fonts/douyin_number_abc_extra_bold.otf";
        goto L21
    }
}
