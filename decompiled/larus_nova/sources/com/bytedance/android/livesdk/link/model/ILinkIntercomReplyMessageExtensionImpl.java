package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0015\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u00060\u000bj\u0002`\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u001c\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkIntercomReplyMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/l0;", "Lcom/bytedance/android/livesdk/link/model/u4;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getChannelId", "()J", RemoteMessageConst.Notification.CHANNEL_ID, "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getReplyStatus", "replyStatus", "", "getToast", "()Ljava/lang/String;", "toast", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/l0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkIntercomReplyMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.l0, u4> implements u4, com.bytedance.android.livesdk.link.model.bridge.l0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.l0 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.l0>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.l0>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.u4, com.bytedance.android.livesdk.link.model.bridge.l0, yh6.c
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.u4, com.bytedance.android.livesdk.link.model.bridge.l0
    public long getReplyStatus() {
        return this.$$delegate_0.getReplyStatus();
    }

    @Override // com.bytedance.android.livesdk.link.model.u4, com.bytedance.android.livesdk.link.model.bridge.l0
    public String getToast() {
        return this.$$delegate_0.getToast();
    }

    @Override // com.bytedance.android.livesdk.link.model.u4, com.bytedance.android.livesdk.link.model.bridge.l0
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r100) {
        this.$$delegate_0.setCommonData(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.u4
    public long getChannelId() {
        return ((Number) get(2, u4.class, 0L)).longValue();
    }

    public ILinkIntercomReplyMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.l0 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
