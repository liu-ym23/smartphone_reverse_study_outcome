package com.bytedance.android.live.profile.ui.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;

/* JADX INFO: loaded from: classes47.dex */
public interface d {
    <T extends View> T a(int r100);

    void addView(View r100, ViewGroup.LayoutParams r101);

    View b(ProfilePreInflateViewInfo r100, boolean r101);

    void c(int r100);

    boolean d(int r100);

    void e(View r100);

    View f(int r100, boolean r101);

    Context getContext();

    void removeAllViews();

    void removeView(View r100);
}
