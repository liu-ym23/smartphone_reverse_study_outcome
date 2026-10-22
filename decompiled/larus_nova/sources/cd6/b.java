package cd6;

import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f23400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23401b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f23402c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23403d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f23404e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23405f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f23406g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f23407h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0435b f23408i = null;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: cd6.b$b, reason: collision with other inner class name */
    public static final class C0435b {
        public C0435b() {
        }
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d {
        public d() {
        }
    }

    static {
        f23400a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_ALL_MIC_STATE_CACHE", "getLIVE_GIFT_ALL_MIC_STATE_CACHE()Lcom/bytedance/android/live/core/cache/LruCache;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_IS_MULTI_USER_CACHE", "getLIVE_GIFT_IS_MULTI_USER_CACHE()Lcom/bytedance/android/live/core/cache/LruCache;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_CACHE", "getLIVE_GIFT_RECEIVER_CACHE()Lcom/bytedance/android/live/core/cache/LruCache;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_GROUP_RECEIVER_CACHE", "getLIVE_GIFT_GROUP_RECEIVER_CACHE()Lcom/bytedance/android/live/core/cache/LruCache;", 1))};
        f23401b = SpongePreferenceManager.a().a("live_gift_all_mic_state_cache", new LruCache(40), rl3.a.f538468l);
        f23402c = new a();
        f23403d = SpongePreferenceManager.a().a("live_gift_is_multi_user_state_cache", new LruCache(40), rl3.a.f538464h);
        f23404e = new c();
        f23405f = SpongePreferenceManager.a().a("live_gift_receiver_cache", new LruCache(40), rl3.a.f538462f);
        f23406g = new d();
        f23407h = SpongePreferenceManager.a().a("live_gift_group_receiver_cache", new LruCache(40), rl3.a.f538465i);
        f23408i = new C0435b();
    }
}
