package com.bytedance.android.livesdk.interactivity.api.quickcomment;

import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface f {
    List<IQuickCommentShowWord> getCurrentQuickComment(boolean r100);

    String getFixCommentToast();

    com.bytedance.android.live.core.arch.mvvm.d<String> getFixedCommentTips();

    c getOGCFixedChatInfo();

    com.bytedance.android.live.core.arch.mvvm.d<List<IQuickCommentShowWord>> getQuickComment();

    com.bytedance.android.live.core.arch.mvvm.d<Integer> getQuickCommentType();

    boolean isFixedComment();

    boolean isOGCFixedComment();

    boolean isOGCFixedCommentEmpty();

    void onLoginSuccess();

    void sendQuickComment(IQuickCommentShowWord r100);
}
