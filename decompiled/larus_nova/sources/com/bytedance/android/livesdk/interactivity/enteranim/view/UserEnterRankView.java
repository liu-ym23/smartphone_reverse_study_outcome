package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class UserEnterRankView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f136861a;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Context r100 = getContext();
        this.f136861a = new View(r100);
        int r101 = s1.f(16.0f);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(r101, r101);
        r102.gravity = 16;
        ImageView r103 = new ImageView(r100);
        ViewGroup.LayoutParams r104 = new LinearLayout.LayoutParams(s1.f(30.0f), s1.f(14.0f));
        r102.gravity = 16;
        r103.setImageResource(R.drawable.ttlive_ic_star_white);
        if (RTLUtil.isAppRTL(r100) == false) goto L5;
        addView(r103, 0, r104);
        addView(this.f136861a, r102);
        return;
    L5:
        addView(this.f136861a, 0, r102);
        addView(r103, r104);
    }

    public UserEnterRankView(Context r100) {
        super(r100);
    }

    public void setupUI(k32.a r100) {
        TextView r101 = (TextView) findViewById(R.id.tv_content);
        int r102 = r100.f501693j;
        if (r102 != 0) goto L6;
        setVisibility(8);
        return;
    L6:
        if (r102 != 1) goto L9;
        this.f136861a.setBackgroundResource(R.drawable.ttlive_ic_user_entry_yesterday_rank_1);
        r101.setText(R.string.ttlive_live_day_top1);
        return;
    L9:
        if (r102 != 2) goto L12;
        this.f136861a.setBackgroundResource(R.drawable.ttlive_ic_user_entry_yesterday_rank_2);
        r101.setText(R.string.ttlive_live_day_top2);
        return;
    L12:
        if (r102 != 3) goto L15;
        this.f136861a.setBackgroundResource(R.drawable.ttlive_ic_user_entry_yesterday_rank_3);
        r101.setText(R.string.ttlive_live_day_top3);
        return;
    L15:
        if (r102 != 4) goto L17;
        this.f136861a.setVisibility(8);
        r101.setText(R.string.ttlive_live_day_top10);
        return;
    L17:
        setVisibility(8);
    }

    public UserEnterRankView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public UserEnterRankView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
