package com.bytedance.android.live.recharge.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(RechargePanelDynamicConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/model/RechargePanelDynamicConfig;", "Lvh7/j;", "Companion", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface RechargePanelDynamicConfig extends j<RechargePanelDynamicConfig> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f89996f = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Lazy f89997a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f89998b = null;

        public Companion() {
        }

        static {
            f89998b = new Companion();
            f89997a = LazyKt.lazy(RechargePanelDynamicConfig$Companion$DEFAULT$2.INSTANCE);
        }
    }

    @JsonAdapter(RechargePanelDynamicConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        f89996f = Companion.f89998b;
    }

    @FieldName(name = "enable_refresh_cache_after_recharge_success")
    boolean X7();

    @FieldName(name = "cache_req_entrance")
    int e0();

    @FieldName(name = "cached_time_limit")
    long e3();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "scheme")
    String getScheme();

    @FieldName(name = "enable_cache")
    boolean j1();

    @FieldName(name = "enable_refresh_cache_on_enter_panel")
    boolean p0();
}
