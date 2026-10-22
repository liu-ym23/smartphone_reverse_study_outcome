package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010&\u001a\u00020!2\u0006\u0010\f\u001a\u00020!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleToastMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/d0;", "Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content", "", "getNotifyType", "()I", "setNotifyType", "(I)V", "notifyType", "", "getDuration", "()J", "setDuration", "(J)V", "duration", "getBattleId", "setBattleId", "battleId", "Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b;", "getUiConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b;", "setUiConfig", "(Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b;)V", "uiConfig", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/d0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleToastMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.d0, IBattleToastMessage> implements IBattleToastMessage, com.bytedance.android.livesdk.link.model.bridge.d0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.d0 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d0>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d0>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage, com.bytedance.android.livesdk.link.model.bridge.d0, yh6.c
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public String getContent() {
        return (String) get(2, IBattleToastMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage, com.bytedance.android.livesdk.link.model.bridge.d0
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r100) {
        this.$$delegate_0.setCommonData(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public long getBattleId() {
        return ((Number) get(5, IBattleToastMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public long getDuration() {
        return ((Number) get(4, IBattleToastMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public int getNotifyType() {
        return ((Number) get(3, IBattleToastMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public IBattleToastMessage.b getUiConfig() {
        return (IBattleToastMessage.b) get(6, IBattleToastMessage.class, IBattleToastMessage.b.class);
    }

    public IBattleToastMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public void setBattleId(long r100) {
        set(5, "battle_id", IBattleToastMessage.class, Long.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public void setContent(String r100) {
        set(2, "content", IBattleToastMessage.class, r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public void setDuration(long r100) {
        set(4, "duration", IBattleToastMessage.class, Long.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public void setNotifyType(int r100) {
        set(3, "notify_type", IBattleToastMessage.class, Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleToastMessage
    public void setUiConfig(IBattleToastMessage.b r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        set(6, "ui_config", IBattleToastMessage.class, r100);
    }
}
