package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010 \u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u00060\u000fj\u0002`\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0012¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRoomLinkerContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/android/livesdk/link/model/b9;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getAnchorIdString", "()Ljava/lang/String;", "anchorIdString", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "isGuestAnchorBackground", "()J", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUsers", "()Ljava/util/List;", "linkedUsers", "getLiveRoomMode", "liveRoomMode", "getMVersion", "mVersion", "", "getRoomLinkSilenceStatus", "()I", "roomLinkSilenceStatus", "getVersion", "version", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/g2;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IRoomLinkerContentExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.g2, b9> implements b9, com.bytedance.android.livesdk.link.model.bridge.g2 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.g2 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g2>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g2>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.b9, com.bytedance.android.livesdk.link.model.bridge.g2
    public String getAnchorIdString() {
        return this.$$delegate_0.getAnchorIdString();
    }

    @Override // com.bytedance.android.livesdk.link.model.b9, com.bytedance.android.livesdk.link.model.bridge.g2
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers() {
        return this.$$delegate_0.getLinkedUsers();
    }

    @Override // com.bytedance.android.livesdk.link.model.b9, com.bytedance.android.livesdk.link.model.bridge.g2
    public long getLiveRoomMode() {
        return this.$$delegate_0.getLiveRoomMode();
    }

    @Override // com.bytedance.android.livesdk.link.model.b9, com.bytedance.android.livesdk.link.model.bridge.g2
    public long getMVersion() {
        return this.$$delegate_0.getMVersion();
    }

    @Override // com.bytedance.android.livesdk.link.model.b9, com.bytedance.android.livesdk.link.model.bridge.g2
    public int getRoomLinkSilenceStatus() {
        return this.$$delegate_0.getRoomLinkSilenceStatus();
    }

    @Override // com.bytedance.android.livesdk.link.model.b9, com.bytedance.android.livesdk.link.model.bridge.g2
    public long getVersion() {
        return this.$$delegate_0.getVersion();
    }

    @Override // com.bytedance.android.livesdk.link.model.b9, com.bytedance.android.livesdk.link.model.bridge.g2
    public long isGuestAnchorBackground() {
        return this.$$delegate_0.isGuestAnchorBackground();
    }

    public IRoomLinkerContentExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.g2 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
