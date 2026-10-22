package com.bytedance.android.livesdkapi.depend.model.live.emoji;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes12.dex */
public interface IBaseEmoji {
    String getDescription();

    Drawable getDrawable();

    int getIconId();

    String getLocalFilePath();

    int getPosition();

    IEmojiType getType();

    boolean isLatestUseEmoji();
}
