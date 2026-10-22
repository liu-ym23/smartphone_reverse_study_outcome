package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/TraySpecialComboRangeConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/w2;", "", "enable", "Z", "getEnable", "()Z", "Lcom/bytedance/android/livesdk/gift/configmodel/s2;", "bigGiftConfig", "Lcom/bytedance/android/livesdk/gift/configmodel/s2;", "L7", "()Lcom/bytedance/android/livesdk/gift/configmodel/s2;", "smallGiftConfig", "K1", "", "smallGiftComboDuration", "J", "M7", "()J", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TraySpecialComboRangeConfigSerializableObjectImpl implements w2 {

    @SerializedName("big_gift_config")
    private final s2 bigGiftConfig;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("live_small_gift_combo_view_show_time")
    private final long smallGiftComboDuration;

    @SerializedName("small_gift_config")
    private final s2 smallGiftConfig;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/TraySpecialComboRangeConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(TraySpecialComboRangeConfigSerializableObjectImpl.class);
        }
    }

    public TraySpecialComboRangeConfigSerializableObjectImpl() {
        this.enable = false;
        Class<?> r100 = ((JsonAdapter) s2.class.getAnnotation(JsonAdapter.class)).value();
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
        if (r104 == null) goto L31;
        this.bigGiftConfig = (s2) r104;
        Class<?> r105 = ((JsonAdapter) s2.class.getAnnotation(JsonAdapter.class)).value();
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
        if (r108 == null) goto L29;
        this.smallGiftConfig = (s2) r108;
        this.smallGiftComboDuration = 3;
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.TrayComboAnimationConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.TrayComboAnimationConfig");
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.w2
    public final s2 K1() {
        return this.smallGiftConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.w2
    public final s2 L7() {
        return this.bigGiftConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.w2
    public final long M7() {
        return this.smallGiftComboDuration;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.w2
    public final boolean getEnable() {
        return this.enable;
    }
}
