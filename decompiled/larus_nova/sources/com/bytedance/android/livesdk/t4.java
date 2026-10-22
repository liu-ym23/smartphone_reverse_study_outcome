package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class t4 extends SSettingKey<HashMap<String, List<? extends String>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t4 f158507a = null;

    public t4() {
        super("live_comment_request_source_type_match_map", "评论request_source与评论类型的映射表", MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, CollectionsKt.listOf("lottery")), TuplesKt.to(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, CollectionsKt.listOf("super_lottery"))}), MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, CollectionsKt.listOf("lottery")), TuplesKt.to(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, CollectionsKt.listOf("super_lottery"))}));
    }

    static {
        f158507a = new t4();
    }
}
