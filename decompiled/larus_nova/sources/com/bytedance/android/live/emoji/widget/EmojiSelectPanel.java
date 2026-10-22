package com.bytedance.android.live.emoji.widget;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.adapter.EmojiPanelAdapter;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.interactivity.api.expression.k;
import com.larus.nova.R;
import t90.a;

/* JADX INFO: loaded from: classes45.dex */
public class EmojiSelectPanel extends ConstraintLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f68965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EmojiPanelAdapter f68966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RtlViewPagerShower f68967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f68968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f68969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f68971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f68972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f68973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f68974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f68975k;

    private int getLayoutResource() {
        return R.layout.ttlive_view_emoji_select_panel;
    }

    public EmojiSelectPanel(Context r100) {
        super(r100);
        LayoutInflater.from(r100).inflate(getLayoutResource(), this);
    }

    public void setOnEmojiSelectListener(k r100) {
        this.f68968d = r100;
    }

    @Override // t90.a
    public final void w(BaseEmoji r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f68968d != null) goto L7;
        return;
    L7:
        if (r100.getIconId() != R.drawable.ttlive_emoji_ic_input_delete) goto L9;
        this.f68968d.a();
        return;
    L9:
        this.f68968d.b(r100);
    }

    public static void R5(EmojiSelectPanel r100, int r101) {
        int r102 = r101 / r100.f68974j;
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r102 >= r100.f68971g) goto L10;
        r100.f68969e = r102;
        r100.f68967c.b(r102);
        return;
    }
}
