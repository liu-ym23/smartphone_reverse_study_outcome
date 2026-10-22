package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/config/BuffAndDiyCardConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/business/config/a;", "", "", "enableManualSelectLockedCardTabs", "Ljava/util/List;", "a5", "()Ljava/util/List;", "enableDefaultSelectLockedCardTabs", "l6", "", "enableShowIconForLastSendCard", "Z", "u6", "()Z", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BuffAndDiyCardConfigSerializableObjectImpl implements a {

    @SerializedName("enable_default_select_locked_card_tabs")
    private final List<Integer> enableDefaultSelectLockedCardTabs;

    @SerializedName("enable_manual_select_locked_card_tabs")
    private final List<Integer> enableManualSelectLockedCardTabs;

    @SerializedName("enable_show_icon_for_last_send_card")
    private final boolean enableShowIconForLastSendCard;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/config/BuffAndDiyCardConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(BuffAndDiyCardConfigSerializableObjectImpl.class);
        }
    }

    public BuffAndDiyCardConfigSerializableObjectImpl() {
        this.enableManualSelectLockedCardTabs = com.bytedance.revenue.platform.api.core.c.a(new Integer[0]);
        this.enableDefaultSelectLockedCardTabs = com.bytedance.revenue.platform.api.core.c.a(new Integer[0]);
        this.enableShowIconForLastSendCard = false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.a
    public final List<Integer> a5() {
        return this.enableManualSelectLockedCardTabs;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.a
    public final List<Integer> l6() {
        return this.enableDefaultSelectLockedCardTabs;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.a
    public final boolean u6() {
        return this.enableShowIconForLastSendCard;
    }
}
