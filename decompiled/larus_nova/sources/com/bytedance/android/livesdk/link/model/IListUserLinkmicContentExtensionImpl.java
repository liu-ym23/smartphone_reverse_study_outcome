package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0014\u0010 \u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0014\u0010$\u001a\u00020!8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\u0011¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IListUserLinkmicContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/m1;", "Lcom/bytedance/android/livesdk/link/model/IListUserLinkmicContent;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getRole", "()I", "role", "", "getFanTicket", "()Ljava/lang/String;", "fanTicket", "getAnchorAuthRole", "anchorAuthRole", "Lcom/bytedance/android/livesdk/link/model/bridge/j;", "getAnchorLinkMicIdInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j;", "anchorLinkMicIdInfo", "getGameName", "gameName", "getHostLabelBackgroundColor", "hostLabelBackgroundColor", "getHostLabelName", "hostLabelName", "getHostLabelNameColor", "hostLabelNameColor", "", "getHostSwitch", "()Z", "hostSwitch", "", "getLiveRoomMode", "()J", "liveRoomMode", "getVirtualTool", "virtualTool", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/m1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IListUserLinkmicContentExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.m1, IListUserLinkmicContent> implements IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.m1 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m1>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m1>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public int getAnchorAuthRole() {
        return this.$$delegate_0.getAnchorAuthRole();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public com.bytedance.android.livesdk.link.model.bridge.j getAnchorLinkMicIdInfo() {
        return this.$$delegate_0.getAnchorLinkMicIdInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public String getGameName() {
        return this.$$delegate_0.getGameName();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public String getHostLabelBackgroundColor() {
        return this.$$delegate_0.getHostLabelBackgroundColor();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public String getHostLabelName() {
        return this.$$delegate_0.getHostLabelName();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public String getHostLabelNameColor() {
        return this.$$delegate_0.getHostLabelNameColor();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public boolean getHostSwitch() {
        return this.$$delegate_0.getHostSwitch();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public long getLiveRoomMode() {
        return this.$$delegate_0.getLiveRoomMode();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent, com.bytedance.android.livesdk.link.model.bridge.m1
    public String getVirtualTool() {
        return this.$$delegate_0.getVirtualTool();
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent
    public String getFanTicket() {
        return (String) get(5, IListUserLinkmicContent.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.IListUserLinkmicContent
    public int getRole() {
        return ((Number) get(3, IListUserLinkmicContent.class, 0)).intValue();
    }

    public IListUserLinkmicContentExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.m1 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
