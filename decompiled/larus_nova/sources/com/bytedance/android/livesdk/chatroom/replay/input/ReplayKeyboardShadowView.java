package com.bytedance.android.livesdk.chatroom.replay.input;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ReplayKeyboardShadowView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f108796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f108797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f108798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f108799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f108800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f108801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f108802g;

    public ReplayKeyboardShadowView(Context r100) {
        super(r100);
        this.f108800e = true;
        this.f108801f = false;
        this.f108802g = false;
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f108800e == true) goto L7;
        return super.dispatchTouchEvent(r100);
    L7:
        if (this.f108796a == null) goto L19;
        if (this.f108798c == false) goto L11;
    L12:
        r100.offsetLocation(0.0f, this.f108799d);
    L14:
        if (this.f108796a.getWindow() != null) goto L20;
        return false;
    L20:
        return super.dispatchTouchEvent(r100);
    L11:
        if (this.f108797b == false) goto L14;
    L19:
        return super.dispatchTouchEvent(r100);
    }

    public void setActivity(Activity r100) {
        this.f108796a = r100;
        this.f108797b = DigHoleScreenUtil.isNeedStatusBarAdapt(r100, this.f108801f, this.f108802g);
        this.f108799d = UIUtils.getStatusBarHeight(r100);
    }

    public void setIsAnchor(boolean r100) {
        this.f108802g = r100;
    }

    public void setIsPortrait(boolean r100) {
        this.f108801f = r100;
    }

    public void setShowStatusBar(boolean r100) {
        this.f108798c = r100;
    }

    public ReplayKeyboardShadowView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f108800e = true;
        this.f108801f = false;
        this.f108802g = false;
    }

    public ReplayKeyboardShadowView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f108800e = true;
        this.f108801f = false;
        this.f108802g = false;
    }
}
