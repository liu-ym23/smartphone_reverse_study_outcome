package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ICloseChorusContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/g0;", "Lcom/bytedance/android/livesdk/link/model/x3;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getToast", "()Ljava/lang/String;", "toast", "Lcom/bytedance/android/live/liveinteract/model/a;", "getChorusInfo", "()Lcom/bytedance/android/live/liveinteract/model/a;", "chorusInfo", "", "getCloseReason", "()I", "closeReason", "getCloserId", "closerId", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/g0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ICloseChorusContentExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.g0, x3> implements x3, com.bytedance.android.livesdk.link.model.bridge.g0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.g0 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g0>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g0>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.x3, com.bytedance.android.livesdk.link.model.bridge.g0
    public com.bytedance.android.live.liveinteract.model.a getChorusInfo() {
        return this.$$delegate_0.getChorusInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.x3, com.bytedance.android.livesdk.link.model.bridge.g0
    public int getCloseReason() {
        return this.$$delegate_0.getCloseReason();
    }

    @Override // com.bytedance.android.livesdk.link.model.x3, com.bytedance.android.livesdk.link.model.bridge.g0
    public String getCloserId() {
        return this.$$delegate_0.getCloserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.x3
    public String getToast() {
        return (String) get(3, x3.class, "");
    }

    public ICloseChorusContentExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
