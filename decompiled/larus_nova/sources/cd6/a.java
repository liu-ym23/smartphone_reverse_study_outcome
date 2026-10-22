package cd6;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.LinkedHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f23395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23396b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23397c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23398d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23399e = null;

    static {
        f23395a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "DIY_GIFT_TOOLBAR_CACHE", "getDIY_GIFT_TOOLBAR_CACHE()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "GIFT_DIY_CARD_LAST_SEND_IDS", "getGIFT_DIY_CARD_LAST_SEND_IDS()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "GIFT_DIY_CARD_LAST_SEND_CARD_NAME", "getGIFT_DIY_CARD_LAST_SEND_CARD_NAME()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "GIFT_DIY_CARD_LAST_SEND_TIME", "getGIFT_DIY_CARD_LAST_SEND_TIME()Ljava/util/Map;", 1))};
        f23396b = SpongePreferenceManager.a().a("diy_gift_toolbar_cache", new LinkedHashMap(), rl3.a.f538457a);
        f23397c = SpongePreferenceManager.a().a("gift_diy_card_last_send_ids", MapsKt.emptyMap(), rl3.a.f538467k);
        f23398d = SpongePreferenceManager.a().a("gift_diy_card_last_send_card_name", MapsKt.emptyMap(), rl3.a.f538466j);
        f23399e = SpongePreferenceManager.a().a("gift_diy_card_last_send_time", MapsKt.emptyMap(), rl3.a.f538463g);
    }
}
