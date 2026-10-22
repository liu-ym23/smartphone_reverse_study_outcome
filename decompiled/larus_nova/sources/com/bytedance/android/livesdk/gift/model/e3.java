package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015R&\u0010\n\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007RB\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/e3;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getPluginId", "()J", "setPluginId", "(J)V", "getPluginId$annotations", "()V", "pluginId", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getItemPotentialValueHint", "()Ljava/util/Map;", "setItemPotentialValueHint", "(Ljava/util/Map;)V", "getItemPotentialValueHint$annotations", "itemPotentialValueHint", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e3 extends vh7.c<e3> {
    public static final a Companion = null;
    public static final int FORMAT_ARRAY = 0;
    public static final int FORMAT_JSON = 1;
    public static final String KEY_ITEM_POTENTIAL_VALUE_HINT = "item_potential_value_hint";
    public static final String KEY_PLUGIN_ID = "plugin_id";
    public static final String TAG = "PluginInfo";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126382a = null;

        public a() {
        }

        static {
            f126382a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f126382a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = KEY_ITEM_POTENTIAL_VALUE_HINT)
    Map<String, String> getItemPotentialValueHint();

    @FieldName(name = "plugin_id")
    long getPluginId();

    @FieldName(name = "item_potential_value_hint#setter")
    void setItemPotentialValueHint(Map<String, String> r100);

    @FieldName(name = "plugin_id#setter")
    void setPluginId(long r100);
}
