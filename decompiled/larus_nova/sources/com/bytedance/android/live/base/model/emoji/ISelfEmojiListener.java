package com.bytedance.android.live.base.model.emoji;

import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface ISelfEmojiListener {
    void onAddSelfEmojis(List<SelfEmoji> r100, boolean r101, String r102);

    void onDeleteSelfEmojis(List<SelfEmoji> r100, boolean r101, String r102);

    void onGetSelfEmojis(List<SelfEmoji> r100);
}
