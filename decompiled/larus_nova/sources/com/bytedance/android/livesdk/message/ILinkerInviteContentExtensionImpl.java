package com.bytedance.android.livesdk.message;

import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import gm2.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0014\u0010 \u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0014\u0010$\u001a\u00020!8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R(\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`&8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R(\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`&8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0014\u0010/\u001a\u00020,8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/message/ILinkerInviteContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/g1;", "Lgm2/e;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getClientAttachedInfoStr", "()Ljava/lang/String;", "clientAttachedInfoStr", "getBattleAttachedInfoStr", "battleAttachedInfoStr", "", "getFromUserId", "()J", "fromUserId", "getSecFromUserId", "secFromUserId", "getWaitSec", "waitSec", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getAnchorLinkUser", "()Lcom/bytedance/android/livesdk/link/model/bridge/k;", "anchorLinkUser", "get_fromUid", "_fromUid", "get_secFromUid", "_secFromUid", "", "getInviteSource", "()I", "inviteSource", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getInviteeFollowUsers", "()Ljava/util/List;", "inviteeFollowUsers", "getInviterUsers", "inviterUsers", "", "getInviterWithAudience", "()Z", "inviterWithAudience", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/g1;)V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkerInviteContentExtensionImpl extends ModelExtensionBase<g1, e> implements e, g1 {
    private final /* synthetic */ g1 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<g1>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<g1>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // gm2.e, com.bytedance.android.livesdk.link.model.bridge.g1
    public int getInviteSource() {
        return this.$$delegate_0.getInviteSource();
    }

    @Override // gm2.e, com.bytedance.android.livesdk.link.model.bridge.g1
    public List<k> getInviteeFollowUsers() {
        return this.$$delegate_0.getInviteeFollowUsers();
    }

    @Override // gm2.e, com.bytedance.android.livesdk.link.model.bridge.g1
    public List<k> getInviterUsers() {
        return this.$$delegate_0.getInviterUsers();
    }

    @Override // gm2.e, com.bytedance.android.livesdk.link.model.bridge.g1
    public boolean getInviterWithAudience() {
        return this.$$delegate_0.getInviterWithAudience();
    }

    @Override // gm2.e
    public String getSecFromUserId() {
        return (String) get(6, e.class);
    }

    @Override // gm2.e, com.bytedance.android.livesdk.link.model.bridge.g1
    public String get_fromUid() {
        return this.$$delegate_0.get_fromUid();
    }

    @Override // gm2.e, com.bytedance.android.livesdk.link.model.bridge.g1
    public String get_secFromUid() {
        return this.$$delegate_0.get_secFromUid();
    }

    @Override // gm2.e
    public k getAnchorLinkUser() {
        return (k) get(31, e.class, k.class);
    }

    @Override // gm2.e
    public String getBattleAttachedInfoStr() {
        return (String) get(38, e.class);
    }

    @Override // gm2.e
    public String getClientAttachedInfoStr() {
        return (String) get(32, e.class, "");
    }

    @Override // gm2.e
    public long getFromUserId() {
        return ((Number) get(1, e.class, 0L)).longValue();
    }

    @Override // gm2.e
    public long getWaitSec() {
        return ((Number) get(29, e.class, 0L)).longValue();
    }

    public ILinkerInviteContentExtensionImpl(g1 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
