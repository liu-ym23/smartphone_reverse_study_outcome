package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.CircleProgressView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f115295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f115296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f115297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f115298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CircleProgressView f115299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f115300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObjectAnimator f115301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f115302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bundle f115303i;

    public k1(Context r100, Lifecycle r101, ViewGroup r102) {
        this.f115300f = 0;
        this.f115296b = r102;
        this.f115302h = r100;
        if (r100 == null) goto L6;
        this.f115297c = (HSImageView) r102.findViewById(R.id.user_avatar);
        this.f115298d = (TextView) r102.findViewById(R.id.back_pre_desc_tv);
        this.f115299e = (CircleProgressView) r102.findViewById(R.id.circle_progress_view);
        UIUtils.updateLayout(r102, -3, com.bytedance.android.live.core.utils.s1.f(26.0f));
        r102.setAlpha(0.9f);
    L6:
        this.f115295a = (int) UIUtils.dip2Px(r100, 20.0f);
    }
}
