package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u000f\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAIAssistantUserExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/d;", "Lcom/bytedance/android/livesdk/link/model/e;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatar", "()Lpy/k;", "avatar", "", "getBelongRoomId", "()Ljava/lang/String;", "belongRoomId", "getBelongUserId", "belongUserId", "getId", "id", "getLinkmicIdStr", "linkmicIdStr", "getNickName", "nickName", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/d;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAIAssistantUserExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.d, e> implements e, com.bytedance.android.livesdk.link.model.bridge.d {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.d $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.e, com.bytedance.android.livesdk.link.model.bridge.d
    public py.k getAvatar() {
        return this.$$delegate_0.getAvatar();
    }

    @Override // com.bytedance.android.livesdk.link.model.e, com.bytedance.android.livesdk.link.model.bridge.d
    public String getBelongRoomId() {
        return this.$$delegate_0.getBelongRoomId();
    }

    @Override // com.bytedance.android.livesdk.link.model.e, com.bytedance.android.livesdk.link.model.bridge.d
    public String getBelongUserId() {
        return this.$$delegate_0.getBelongUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.e, com.bytedance.android.livesdk.link.model.bridge.d
    public String getId() {
        return this.$$delegate_0.getId();
    }

    @Override // com.bytedance.android.livesdk.link.model.e, com.bytedance.android.livesdk.link.model.bridge.d
    public String getLinkmicIdStr() {
        return this.$$delegate_0.getLinkmicIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.e, com.bytedance.android.livesdk.link.model.bridge.d
    public String getNickName() {
        return this.$$delegate_0.getNickName();
    }

    public IAIAssistantUserExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.d r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
