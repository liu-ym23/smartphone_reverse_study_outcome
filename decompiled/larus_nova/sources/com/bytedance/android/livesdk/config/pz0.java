package com.bytedance.android.livesdk.config;

import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class pz0 extends SSettingKey<Map<String, ? extends Map<String, ? extends String>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pz0 f121018a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/config/pz0$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends Map<String, ? extends String>>> {
        public a() {
        }
    }

    static {
        f121018a = new pz0();
    }

    public pz0() {
        super("live_anchor_preview_custom_layout", new a().getType(), MapsKt.emptyMap());
    }
}
