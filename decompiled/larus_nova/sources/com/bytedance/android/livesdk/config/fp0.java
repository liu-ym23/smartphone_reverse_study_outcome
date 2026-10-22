package com.bytedance.android.livesdk.config;

import com.google.gson.reflect.TypeToken;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public final class fp0 extends SSettingKey<Map<String, ? extends ih1>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fp0 f120222a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/config/fp0$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdk/config/ih1;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends ih1>> {
        public a() {
        }
    }

    static {
        f120222a = new fp0();
    }

    public fp0() {
        super("live_room_swipe_guide_configs", new a().getType(), new LinkedHashMap());
    }
}
