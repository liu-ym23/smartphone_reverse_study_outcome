package ak3;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.store.router.hybridpage.slice.HybridPageSlcTemplateManager;
import com.bytedance.android.shopping.store.router.hybridpage.view.HybridPageCustomElementManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vj3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3998b = null;

    public a() {
    }

    static {
        f3998b = new a();
    }

    public final synchronized void a(Context r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L11
        if (f3997a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        f3997a = true;     // Catch: Throwable -> L11
        dm.a.a("HybridPageSlcPreloadManager").i("initTemplateManager");     // Catch: Throwable -> L11
        HybridPageSlcTemplateManager.b(r100);     // Catch: Throwable -> L11
        HybridPageCustomElementManager.a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static String c(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "originalUrl");
        Intrinsics.checkNotNullParameter(r110, "suffix");
        List r101 = StringsKt.split$default(r100, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if ((!r101.isEmpty()) == true) goto L5;
        return r100;
    L5:
        if (Intrinsics.areEqual((String) CollectionsKt.lastOrNull(r101), "main.json") == true) goto L7;
        return r100;
    L7:
        return CollectionsKt.joinToString$default(CollectionsKt.plus(CollectionsKt.dropLast(r101, 1), r110), HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
    }

    public final void b(Context r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "setting");
        a(r100);
        Intrinsics.checkNotNullParameter(r101, "setting");
        String r102 = r101.b();
        if (r102 == null) goto L6;
        ECLiveHybridUtil.l(c(r102, ComposerHelper.CONFIG_FILE_NAME), false);
    L6:
        Intrinsics.checkNotNullParameter(r101, "setting");
        String r103 = r101.b();
        if (r103 == null) goto L11;
        ECLiveHybridUtil.l(c(r103, "page_card.js"), true);
        return;
    }
}
