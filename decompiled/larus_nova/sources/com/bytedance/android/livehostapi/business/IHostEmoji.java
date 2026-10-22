package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.livehostapi.business.model.emoji.SelfEmoji;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostEmoji extends IMiddleWareHostEmoji {
    void addSelfEmoji(Context r100, SelfEmoji r101);

    void manageSelfEmoji(Context r100);

    void previewSelfEmoji(Context r100, SelfEmoji r101);
}
