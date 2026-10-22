package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R$\u0010(\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/o;", "Lcom/bytedance/android/livesdk/link/model/t0;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/link/model/t0$d;", "getInviteContent", "()Lcom/bytedance/android/livesdk/link/model/t0$d;", "inviteContent", "Lcom/bytedance/android/livesdk/link/model/t0$f;", "getReplyContent", "()Lcom/bytedance/android/livesdk/link/model/t0$f;", "replyContent", "Lcom/bytedance/android/livesdk/link/model/t0$g;", "getSwitchContent", "()Lcom/bytedance/android/livesdk/link/model/t0$g;", "switchContent", "Lcom/bytedance/android/livesdk/link/model/t0$b;", "getCloseContent", "()Lcom/bytedance/android/livesdk/link/model/t0$b;", "closeContent", "Lcom/bytedance/android/livesdk/link/model/t0$e;", "getRejectContent", "()Lcom/bytedance/android/livesdk/link/model/t0$e;", "rejectContent", "", "getType", "()I", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/o;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleAuxiliaryMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.o, t0> implements t0, com.bytedance.android.livesdk.link.model.bridge.o {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.o $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.o>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.o>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0, com.bytedance.android.livesdk.link.model.bridge.o, yh6.c
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.t0, com.bytedance.android.livesdk.link.model.bridge.o
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r100) {
        this.$$delegate_0.setCommonData(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0
    public t0.b getCloseContent() {
        return (t0.b) get(6, t0.class, t0.b.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0
    public t0.d getInviteContent() {
        return (t0.d) get(3, t0.class, t0.d.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0
    public t0.e getRejectContent() {
        return (t0.e) get(7, t0.class, t0.e.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0
    public t0.f getReplyContent() {
        return (t0.f) get(4, t0.class, t0.f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0
    public t0.g getSwitchContent() {
        return (t0.g) get(5, t0.class, t0.g.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.t0
    public int getType() {
        return ((Number) get(2, t0.class, 0)).intValue();
    }

    public IBattleAuxiliaryMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.o r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
