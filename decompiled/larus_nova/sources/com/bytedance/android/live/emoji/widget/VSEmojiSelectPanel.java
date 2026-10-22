package com.bytedance.android.live.emoji.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.adapter.EmojiPanelWaterfallAdapter;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.expression.k;
import com.larus.nova.R;
import t90.a;

/* JADX INFO: loaded from: classes45.dex */
public class VSEmojiSelectPanel extends VSEmojiSelectBasePanel implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f68976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f68977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EmojiPanelWaterfallAdapter f68978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f68979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f68980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f68982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f68983h;

    private int getLayoutResource() {
        return R.layout.ttlive_vs_view_emoji_select_panel;
    }

    @Override // com.bytedance.android.live.emoji.widget.VSEmojiSelectBasePanel
    public void setOnEmojiSelectListener(k r100) {
        this.f68980e = r100;
    }

    @Override // t90.a
    public final void w(BaseEmoji r100) {
        if (r100 == null) goto L8;
        k r101 = this.f68980e;
        if (r101 == null) goto L9;
        r101.b(r100);
        return;
    L9:
        return;
    }

    public VSEmojiSelectPanel(Context r100, int r101) {
        super(r100);
        this.f68983h = r101;
        LayoutInflater.from(r100).inflate(getLayoutResource(), this);
    }
}
