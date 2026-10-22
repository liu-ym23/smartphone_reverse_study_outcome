package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorGameRoleInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;", "Lcom/bytedance/android/livesdk/link/model/k;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content", "", "getRole", "()Ljava/lang/Integer;", "setRole", "(Ljava/lang/Integer;)V", "role", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAnchorGameRoleInfoExtensionImpl extends ModelExtensionBase<IAnchorGameRoleBridge, k> implements k, IAnchorGameRoleBridge {
    private final /* synthetic */ IAnchorGameRoleBridge $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<IAnchorGameRoleBridge>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<IAnchorGameRoleBridge>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.k, com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public String getContent() {
        return this.$$delegate_0.getContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.k, com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public Integer getRole() {
        return this.$$delegate_0.getRole();
    }

    @Override // com.bytedance.android.livesdk.link.model.k, com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public void setContent(String r100) {
        this.$$delegate_0.setContent(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.k, com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public void setRole(Integer r100) {
        this.$$delegate_0.setRole(r100);
    }

    public IAnchorGameRoleInfoExtensionImpl(IAnchorGameRoleBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
