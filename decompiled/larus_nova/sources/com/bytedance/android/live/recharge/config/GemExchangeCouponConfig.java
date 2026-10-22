package com.bytedance.android.live.recharge.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(GemExchangeCouponConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/config/GemExchangeCouponConfig;", "Lvh7/j;", "Companion", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface GemExchangeCouponConfig extends j<GemExchangeCouponConfig> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f89677d = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Lazy f89678a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f89679b = null;

        public Companion() {
        }

        static {
            f89679b = new Companion();
            f89678a = LazyKt.lazy(GemExchangeCouponConfig$Companion$DEFAULT$2.INSTANCE);
        }
    }

    @JsonAdapter(GemExchangeCouponConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        f89677d = Companion.f89679b;
    }

    @FieldName(name = "scheme#setter")
    void M4();

    @FieldName(name = "scheme")
    String getScheme();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "title#setter")
    void v();
}
