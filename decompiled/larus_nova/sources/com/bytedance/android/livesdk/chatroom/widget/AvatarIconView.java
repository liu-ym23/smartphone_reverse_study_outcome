package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class AvatarIconView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f118453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f118454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f118455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f118456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f118457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f118458f;

    public AvatarIconView(Context r100) {
        this(r100, null);
    }

    public void setAvatar(py.k r100) {
        if (r100 == null) goto L5;
        ImageView r101 = this.f118453a;
        int r102 = this.f118456d;
        com.bytedance.android.livesdk.chatroom.utils.a1.x(r101, r100, r102, r102, R.drawable.ttlive_img_avatar_empty);
        return;
    }

    public void setAvatarBorder(py.k r100) {
        if (r100 == null) goto L4;
        this.f118454b.setVisibility(0);
        ImageView r101 = this.f118454b;
        int r102 = this.f118457e;
        ImageUtil.loadImage(r101, r100, r102, r102, null);
        return;
    L4:
        this.f118454b.setVisibility(8);
    }

    public void setIcon(py.k r100) {
        if (r100 == null) goto L4;
        this.f118455c.setVisibility(0);
        ImageView r101 = this.f118455c;
        int r102 = this.f118458f;
        ImageUtil.loadImage(r101, r100, r102, r102, -1, null);
        return;
    L4:
        this.f118455c.setVisibility(4);
    }

    public void setAvatar(int r100) {
        ImageUtil.loadRoundResource(this.f118453a, r100, -1, -1);
    }

    public AvatarIconView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AvatarIconView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        int r103 = (int) UIUtils.dip2Px(r100, 100.0f);
        this.f118456d = r103;
        int r104 = (int) UIUtils.dip2Px(r100, 42.0f);
        this.f118458f = r104;
        if (r101 == null) goto L5;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_avatar_border_size, R.attr.ttlive_avatar_size, R.attr.ttlive_icon_size});
        this.f118456d = r105.getDimensionPixelSize(1, r103);
        this.f118457e = r105.getDimensionPixelSize(0, 0);
        this.f118458f = r105.getDimensionPixelSize(2, r104);
        r105.recycle();
    L5:
        ImageView r106 = new ImageView(r100);
        this.f118453a = r106;
        int r107 = this.f118456d;
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(r107, r107);
        r108.gravity = 17;
        r106.setLayoutParams(r108);
        addView(r106);
        ImageView r109 = new ImageView(r100);
        this.f118454b = r109;
        int r110 = this.f118457e;
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(r110, r110);
        r111.gravity = 17;
        r109.setLayoutParams(r111);
        addView(r109);
        ImageView r112 = new ImageView(r100);
        this.f118455c = r112;
        int r113 = this.f118458f;
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(r113, r113);
        r114.bottomMargin = (int) UIUtils.dip2Px(r100, 3.0f);
        r114.rightMargin = (int) UIUtils.dip2Px(r100, 2.0f);
        r114.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        r112.setLayoutParams(r114);
        addView(r112);
        r112.setVisibility(4);
    }
}
