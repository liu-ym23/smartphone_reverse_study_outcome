package com.bytedance.android.live.base.model.message;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public interface g4 {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final a f58859e0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<String> f58860a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final List<String> f58861b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final List<String> f58862c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final List<String> f58863d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a f58864e = null;

        public a() {
        }

        static {
            f58864e = new a();
            f58860a = CollectionsKt.listOf(new String[]{"livehead_enter_prompt_goods_ab1", "livehead_enter_prompt_goods_ab2"});
            f58861b = CollectionsKt.listOf(new String[]{"game_cp_user_multi_download", "game_cp_user_single_download"});
            f58862c = CollectionsKt.listOf(new String[]{"auction_bid_notify", "auction_end_notify"});
            f58863d = CollectionsKt.listOf("instance_role_show_real_grade");
        }
    }

    static {
        f58859e0 = a.f58864e;
    }

    String getScene();
}
