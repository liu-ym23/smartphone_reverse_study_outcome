package com.bytedance.android.livesdk.vs.model.message;

import com.bytedance.android.live.base.model.message.p5;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ku2.c;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/vs/model/message/VSLinkRoomMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/base/model/message/p5;", "Lku2/c;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "value", "getLinkedRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "setLinkedRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;)V", "linkedRoomInfo", "base", "<init>", "(Lcom/bytedance/android/live/base/model/message/p5;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSLinkRoomMessageExtensionImpl extends ModelExtensionBase<p5, c> implements c, p5 {
    private final /* synthetic */ p5 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<p5>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<p5>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // ku2.c
    public VSLinkedRoomInfo getLinkedRoomInfo() {
        return (VSLinkedRoomInfo) get(2, c.class);
    }

    public VSLinkRoomMessageExtensionImpl(p5 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }

    @Override // ku2.c
    public void setLinkedRoomInfo(VSLinkedRoomInfo r100) {
        set(2, "link_info", c.class, r100);
    }
}
