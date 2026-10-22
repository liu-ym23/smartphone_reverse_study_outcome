package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/m;", "Lvh7/c;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/f;", "getSenderEmoji", "()Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/f;", "setSenderEmoji", "(Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/f;)V", "getSenderEmoji$annotations", "()V", "senderEmoji", "getPathEmoji", "setPathEmoji", "getPathEmoji$annotations", "pathEmoji", "getReceiverEmoji", "setReceiverEmoji", "getReceiverEmoji$annotations", "receiverEmoji", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/p;", "getRevenueData", "()Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/p;", "setRevenueData", "(Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/p;)V", "revenueData", "", "isValid", "()Z", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m extends vh7.c<m> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "pass_image")
    f getPathEmoji();

    @FieldName(name = "to_image")
    f getReceiverEmoji();

    p getRevenueData();

    @FieldName(name = "from_image")
    f getSenderEmoji();

    boolean isValid();

    @FieldName(name = "pass_image#setter")
    void setPathEmoji(f r100);

    @FieldName(name = "to_image#setter")
    void setReceiverEmoji(f r100);

    void setRevenueData(p r100);

    @FieldName(name = "from_image#setter")
    void setSenderEmoji(f r100);
}
