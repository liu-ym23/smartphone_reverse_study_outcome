package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\"\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0017R$\u0010(\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitInteractionScoreMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/f2;", "Lcom/bytedance/android/livesdk/link/model/c8;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getScoreUpdateType", "()I", "scoreUpdateType", "", "getLinkStartTime", "()J", "linkStartTime", "getInteractionScoreStatus", "interactionScoreStatus", "", "getExtraJson", "()Ljava/lang/String;", "extraJson", "getChannelId", RemoteMessageConst.Notification.CHANNEL_ID, "", "Lcom/bytedance/android/livesdk/link/model/b8;", "getAnchorInfoMap", "()Ljava/util/Map;", "anchorInfoMap", "getGameExtraJson", "gameExtraJson", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/f2;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IProfitInteractionScoreMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.f2, c8> implements c8, com.bytedance.android.livesdk.link.model.bridge.f2 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.f2 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.f2>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.f2>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.c8, com.bytedance.android.livesdk.link.model.bridge.f2, yh6.c
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.c8, com.bytedance.android.livesdk.link.model.bridge.f2
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r100) {
        this.$$delegate_0.setCommonData(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.c8
    public Map<String, b8> getAnchorInfoMap() {
        return (Map) get(5000, c8.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c8
    public long getChannelId() {
        return ((Number) get(4, c8.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.c8
    public String getExtraJson() {
        return (String) get(7, c8.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.c8
    public String getGameExtraJson() {
        return (String) get(8, c8.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.c8
    public int getInteractionScoreStatus() {
        return ((Number) get(3, c8.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.c8
    public long getLinkStartTime() {
        return ((Number) get(5, c8.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.c8
    public int getScoreUpdateType() {
        return ((Number) get(6, c8.class, 0)).intValue();
    }

    public IProfitInteractionScoreMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.f2 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
