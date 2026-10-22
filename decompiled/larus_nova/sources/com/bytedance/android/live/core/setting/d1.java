package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class d1 extends SSettingKey<List<? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f65278a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/core/setting/d1$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Integer>> {
        public a() {
        }
    }

    static {
        f65278a = new d1();
    }

    public d1() {
        super("live_enable_temp_short_touch_list", new a().getType(), CollectionsKt.mutableListOf(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
