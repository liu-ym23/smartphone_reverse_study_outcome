package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class DrawLiveCoverOptView extends LiveCoverOptView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f160808t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ImageView f160809u;

    @Override // com.bytedance.android.livesdk.widget.LiveCoverOptView
    public String getFrom() {
        return "draw";
    }

    @Override // com.bytedance.android.livesdk.widget.LiveCoverOptView
    public int getLayoutId() {
        if (getDrawCoverStyle() == 0) goto L7;
        return R.layout.ttlive_item_cover_style_opt_v1;
    L7:
        return super.getLayoutId();
    }

    public DrawLiveCoverOptView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveCoverOptView
    public final void d(boolean r100) {
        super.d(r100);
        View r101 = this.f160808t;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        UIUtils.setViewVisibility(r101, r103);
        ImageView r104 = this.f160809u;
        if (r100 == true) goto L10;
        r102 = 8;
    L10:
        UIUtils.setViewVisibility(r104, r102);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public DrawLiveCoverOptView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void e(IRoom r100, boolean r101) {
        ImageView r102 = this.f160809u;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r101 == false) goto L10;
        r102.setVisibility(0);
        if (com.bytedance.android.livesdk.utils.p1.c(r100) == false) goto L12;
        this.f160809u.setVisibility(8);
        return;
    L12:
        return;
    L10:
        r102.setVisibility(8);
    }

    public DrawLiveCoverOptView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160808t = findViewById(R.id.live_hotfire_container);
        this.f160809u = (ImageView) findViewById(R.id.live_hotfire);
    }
}
