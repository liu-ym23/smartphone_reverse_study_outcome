package com.bytedance.android.gamecp.business.comment.edit;

import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f52114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f52115b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f52116c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f52117d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f52118e = null;

    static {
        f52114a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(0, "轻点星星打个分"), TuplesKt.to(1, "很讨厌"), TuplesKt.to(2, "不推荐"), TuplesKt.to(3, "还可以"), TuplesKt.to(4, "很不错"), TuplesKt.to(5, "非常喜欢")});
        f52115b = y0.i(R.string.ttlive_game_promote_click_to_rate_toast);
        f52116c = y0.i(R.string.ttlive_game_promote_comment_no_text);
        f52117d = y0.i(R.string.ttlive_game_promote_comment_min_limit);
        f52118e = y0.j(R.string.ttlive_game_promote_comment_max_limit, new Object[]{5000});
    }
}
