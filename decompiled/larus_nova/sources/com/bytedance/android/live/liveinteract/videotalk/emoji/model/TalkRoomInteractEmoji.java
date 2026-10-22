package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TalkRoomInteractEmoji extends FlexModelBase<m> implements m {

    @SerializedName("pass_image")
    public InteractEmojiAnim pathEmoji;

    @SerializedName("to_image")
    public InteractEmojiAnim receiverEmoji;

    @IgnoreProtoDecode
    public transient String resourcePath;

    @IgnoreProtoDecode
    public transient p revenueData;

    @SerializedName("from_image")
    public InteractEmojiAnim senderEmoji;

    public TalkRoomInteractEmoji() {
        super(m.class);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public boolean isValid() {
        InteractEmojiAnim r100 = this.pathEmoji;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isValid() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public /* bridge */ /* synthetic */ f getPathEmoji() {
        return getPathEmoji();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public /* bridge */ /* synthetic */ f getReceiverEmoji() {
        return getReceiverEmoji();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public /* bridge */ /* synthetic */ f getSenderEmoji() {
        return getSenderEmoji();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public p getRevenueData() {
        return this.revenueData;
    }

    public InteractEmojiAnim pathEmoji() {
        return this.pathEmoji;
    }

    public InteractEmojiAnim receiverEmoji() {
        return this.receiverEmoji;
    }

    public InteractEmojiAnim senderEmoji() {
        return this.senderEmoji;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public InteractEmojiAnim getPathEmoji() {
        return this.pathEmoji;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public InteractEmojiAnim getReceiverEmoji() {
        return this.receiverEmoji;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public InteractEmojiAnim getSenderEmoji() {
        return this.senderEmoji;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public void setPathEmoji(f r100) {
        this.pathEmoji = (InteractEmojiAnim) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public void setReceiverEmoji(f r100) {
        this.receiverEmoji = (InteractEmojiAnim) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public void setRevenueData(p r100) {
        this.revenueData = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.m
    public void setSenderEmoji(f r100) {
        this.senderEmoji = (InteractEmojiAnim) r100;
    }
}
