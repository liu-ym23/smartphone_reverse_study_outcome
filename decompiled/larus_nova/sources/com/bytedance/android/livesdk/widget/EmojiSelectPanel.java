package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.adapter.EmojiPanelAdapter;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class EmojiSelectPanel extends ConstraintLayout implements jf2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f160847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EmojiPanelAdapter f160848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RtlViewPagerShower f160849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.expression.k f160850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f160851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f160852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f160853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f160854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f160855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f160856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f160857k;

    private int getLayoutResource() {
        return R.layout.ttlive_view_emoji_select_panel;
    }

    @Override // jf2.b
    public final void S2(com.bytedance.android.live.base.model.data.activityemoji.b r100) {
    }

    @Override // jf2.b
    public final /* synthetic */ void W3(com.bytedance.android.livesdk.interactivity.api.emoji.a r100) {
    }

    @Override // jf2.b
    public final /* synthetic */ void t1(com.bytedance.android.live.base.model.message.h r100, String r101) {
    }

    public EmojiSelectPanel(Context r100) {
        super(r100);
        LayoutInflater.from(r100).inflate(getLayoutResource(), this);
    }

    public void setOnEmojiSelectListener(com.bytedance.android.livesdk.interactivity.api.expression.k r100) {
        this.f160850d = r100;
    }

    @Override // jf2.b
    public final void w(BaseEmoji r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f160850d != null) goto L7;
        return;
    L7:
        if (r100.getIconId() != R.drawable.ttlive_emoji_ic_input_delete) goto L9;
        this.f160850d.a();
        return;
    L9:
        this.f160850d.b(r100);
    }

    public static void R5(EmojiSelectPanel r100, int r101) {
        int r102 = r101 / r100.f160856j;
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r102 >= r100.f160853g) goto L10;
        r100.f160851e = r102;
        r100.f160849c.b(r102);
        return;
    }
}
