package com.bytedance.android.live.liveinteract.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.utils.t6;

/* JADX INFO: loaded from: classes46.dex */
public class CustomOnlineFriendsCircleContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f72488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f72489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72491d;

    public CustomOnlineFriendsCircleContainer(Context r100) {
        this(r100, null);
    }

    public CustomOnlineFriendsCircleContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CustomOnlineFriendsCircleContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f72489b = (int) t6.a(getContext(), 18.0f);
        this.f72488a = (int) t6.a(getContext(), 4.0f);
        this.f72490c = (int) t6.a(getContext(), 12.0f);
        this.f72491d = (int) t6.a(getContext(), 3.0f);
    }
}
