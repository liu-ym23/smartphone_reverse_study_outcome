package com.bytedance.android.livesdk.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes11.dex */
public final class p extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiSelectPanel f161906a;

    public p(EmojiSelectPanel r100) {
        this.f161906a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        if (r101 != 0) goto L4;
        return;
    L4:
        EmojiSelectPanel r102 = this.f161906a;
        EmojiSelectPanel.R5(r102, r102.f160852f);
        super.onScrollStateChanged(r100, r101);
    }
}
