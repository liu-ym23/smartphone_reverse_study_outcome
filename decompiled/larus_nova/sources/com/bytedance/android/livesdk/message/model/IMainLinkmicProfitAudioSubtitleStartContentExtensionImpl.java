package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/IMainLinkmicProfitAudioSubtitleStartContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/message/model/o9;", "Lcom/bytedance/android/livesdk/message/model/ua;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "value", "getLinkmicSubtitleSettingStatus", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "setLinkmicSubtitleSettingStatus", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;)V", "linkmicSubtitleSettingStatus", "", "getVersionId", "()J", "versionId", "base", "<init>", "(Lcom/bytedance/android/livesdk/message/model/o9;)V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainLinkmicProfitAudioSubtitleStartContentExtensionImpl extends ModelExtensionBase<o9, ua> implements ua, o9 {
    private final /* synthetic */ o9 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<o9>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<o9>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.message.model.ua
    public com.bytedance.android.livesdk.chatroom.model.interact.q2 getLinkmicSubtitleSettingStatus() {
        return (com.bytedance.android.livesdk.chatroom.model.interact.q2) get(2, ua.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.ua, com.bytedance.android.livesdk.message.model.o9
    public long getVersionId() {
        return this.$$delegate_0.getVersionId();
    }

    public IMainLinkmicProfitAudioSubtitleStartContentExtensionImpl(o9 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.ua
    public void setLinkmicSubtitleSettingStatus(com.bytedance.android.livesdk.chatroom.model.interact.q2 r100) {
        set(2, "linkmic_subtitle_status", ua.class, r100);
    }
}
