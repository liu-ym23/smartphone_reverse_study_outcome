package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
public final class j2 extends SSettingKey<Map<Integer, ? extends com.bytedance.android.livesdk.config.l8>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j2 f142015a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/j2$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdk/config/l8;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<Integer, ? extends com.bytedance.android.livesdk.config.l8>> {
        public a() {
        }
    }

    static {
        j2 r100 = new j2();
        f142015a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public j2() {
        Type r100 = new a().getType();
        int r101 = com.bytedance.android.livesdk.config.l8.f120658a;
        super("live_player_view_layout_config", r100, com.bytedance.android.livesdk.config.l8.a.a());
    }
}
