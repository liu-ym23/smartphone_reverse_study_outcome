package com.bytedance.android.gamecp.business.monitor;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import wu.j1;
import wu.l1;

/* JADX INFO: loaded from: classes44.dex */
public final class GameDetailFmpConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f56152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f56153b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f56154c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f56155d = null;

    public static boolean a() {
        return ((Boolean) f56153b.getValue()).booleanValue();
    }

    static {
        List<String> r100 = CollectionsKt.listOf(new String[]{"tab_navi", "lynx_tab", "title_bar_info", "title_score_info", "two_action_button", "col", "nav_bar_v3", SlcFlexDirection.FLEX_ROW, "title_beta_test_button", "title_download_button", "title_miniplay_button", "title_reserve_button", "security_info", "tab_col_list_v3", "row_title_bar", "release_game_button", "col_game_intro_v3"});
        f56152a = r100;
        f56153b = LazyKt.lazy(GameDetailFmpConfig$loadPerfEnable$2.INSTANCE);
        if (a() == false) goto L8;
        List<String> r101 = j1.f561331a.getValue();
        if (r101 == null) goto L8;
        r100 = r101;
    L8:
        f56154c = r100;
        if (a() == false) goto L13;
        List<String> r102 = l1.f561343a.getValue();
        if (r102 != null) goto L14;
        r102 = CollectionsKt.emptyList();
    L14:
        f56155d = r102;
        return;
    L13:
        r102 = CollectionsKt.emptyList();
        goto L14
    }
}
