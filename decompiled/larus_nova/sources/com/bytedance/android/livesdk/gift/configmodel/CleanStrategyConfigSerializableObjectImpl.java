package com.bytedance.android.livesdk.gift.configmodel;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R \u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/CleanStrategyConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/m;", "", "enable", "Z", "getEnable", "()Z", "", "", "Lcom/bytedance/android/livesdk/gift/configmodel/g;", "poolConfig", "Ljava/util/Map;", "K8", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdk/gift/configmodel/k;", "downloadBlackConfig", "Lcom/bytedance/android/livesdk/gift/configmodel/k;", "G6", "()Lcom/bytedance/android/livesdk/gift/configmodel/k;", "cleanWhiteConfig", "E7", "", "assetExpireDuration", "J", "d3", "()J", "diffCleanEnable", "k9", "Lcom/bytedance/android/livesdk/gift/configmodel/q;", "effectApiAddParam", "Lcom/bytedance/android/livesdk/gift/configmodel/q;", OuterPayLoginWrapper.LOGIN_STYLE_V1, "()Lcom/bytedance/android/livesdk/gift/configmodel/q;", "relatedPoolCheckInterval", "u1", "", "assetPoolNotAddBlackList", "Ljava/util/List;", "c3", "()Ljava/util/List;", "roomCleanEnable", "g0", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CleanStrategyConfigSerializableObjectImpl implements m {

    @SerializedName("asset_expire_duration")
    private final long assetExpireDuration;

    @SerializedName("live_asset_pool_not_add_black_list")
    private final List<String> assetPoolNotAddBlackList;

    @SerializedName("clean_white_list_config")
    private final k cleanWhiteConfig;

    @SerializedName("diff_clean_enable")
    private final boolean diffCleanEnable;

    @SerializedName("download_black_list_config")
    private final k downloadBlackConfig;

    @SerializedName("live_effect_api_add_user_portrait_param")
    private final q effectApiAddParam;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("pool_config")
    private final Map<String, g> poolConfig;

    @SerializedName("download_asset_trigger_related_pool_clean_interval")
    private final long relatedPoolCheckInterval;

    @SerializedName("clean_in_room_enable")
    private final boolean roomCleanEnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/CleanStrategyConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(CleanStrategyConfigSerializableObjectImpl.class);
        }
    }

    public CleanStrategyConfigSerializableObjectImpl() {
        this.enable = false;
        this.poolConfig = MapsKt.emptyMap();
        Class<?> r100 = ((JsonAdapter) k.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r101 = vh7.b.f554981a;
        Constructor r102 = r101.get(r100);
        if (r102 != null) goto L12;
        r102 = r100.getConstructor(new Class[0]);
        if (r102 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r103 = r101.putIfAbsent(r100, (Constructor<? extends SerializableObjectJsonAdapterBase>) r102);
        if (r103 == null) goto L12;
        r102 = r103;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r104 = ((SerializableObjectJsonAdapterBase) r102.newInstance(new Object[0])).createInstance();
        if (r104 == null) goto L45;
        this.downloadBlackConfig = (k) r104;
        Class<?> r105 = ((JsonAdapter) k.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r106 = r101.get(r105);
        if (r106 != null) goto L24;
        r106 = r105.getConstructor(new Class[0]);
        if (r106 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r107 = r101.putIfAbsent(r105, r106);
        if (r107 == null) goto L24;
        r106 = r107;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r108 = r106.newInstance(new Object[0]).createInstance();
        if (r108 == null) goto L43;
        this.cleanWhiteConfig = (k) r108;
        long r109 = 60;
        this.assetExpireDuration = r109;
        this.diffCleanEnable = true;
        Class<?> r110 = ((JsonAdapter) q.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r111 = r101.get(r110);
        if (r111 != null) goto L36;
        r111 = r110.getConstructor(new Class[0]);
        if (r111 == null) goto L35;
        Constructor<? extends SerializableObjectJsonAdapterBase> r112 = r101.putIfAbsent(r110, r111);
        if (r112 == null) goto L36;
        r111 = r112;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r113 = r111.newInstance(new Object[0]).createInstance();
        if (r113 == null) goto L41;
        this.effectApiAddParam = (q) r113;
        this.relatedPoolCheckInterval = r109;
        this.assetPoolNotAddBlackList = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
        this.roomCleanEnable = true;
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.DeviceStorageSetting");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.BlackAndWhiteListConfig");
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.BlackAndWhiteListConfig");
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final k E7() {
        return this.cleanWhiteConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final k G6() {
        return this.downloadBlackConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final Map<String, g> K8() {
        return this.poolConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final q V1() {
        return this.effectApiAddParam;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final List<String> c3() {
        return this.assetPoolNotAddBlackList;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final long d3() {
        return this.assetExpireDuration;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final boolean g0() {
        return this.roomCleanEnable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final boolean k9() {
        return this.diffCleanEnable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final long u1() {
        return this.relatedPoolCheckInterval;
    }
}
