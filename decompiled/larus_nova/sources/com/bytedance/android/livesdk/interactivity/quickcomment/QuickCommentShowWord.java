package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/quickcomment/QuickCommentShowWord;", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/IQuickCommentShowWord;", "content", "", "source", "", "backgroundColor", "(Ljava/lang/String;ILjava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getContent", "getSource", "()I", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QuickCommentShowWord implements IQuickCommentShowWord {
    private final String backgroundColor;
    private final String content;
    private final int source;

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord
    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord
    public String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord
    public int getSource() {
        return this.source;
    }

    public QuickCommentShowWord(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.content = r100;
        this.source = r101;
        this.backgroundColor = r102;
    }
}
