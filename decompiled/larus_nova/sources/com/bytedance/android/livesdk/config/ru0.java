package com.bytedance.android.livesdk.config;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public final class ru0 extends SSettingKey<List<? extends gi1>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ru0 f121159a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/config/ru0$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/config/gi1;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends gi1>> {
        public a() {
        }
    }

    static {
        f121159a = new ru0();
    }

    public ru0() {
        super("live_toolbartip_counter_expire", new a().getType(), null);
    }
}
