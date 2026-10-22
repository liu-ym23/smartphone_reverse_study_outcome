package com.bytedance.android.livesdk.chatroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;

/* JADX INFO: loaded from: classes8.dex */
public final class c6 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditIntroductionFragment f112660a;

    public c6(EditIntroductionFragment r100) {
        this.f112660a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        ViewParent r102 = r100.getParent();
        if (r102 == null) goto L5;
        r102.requestDisallowInterceptTouchEvent(true);
    L5:
        int r103 = r101.getAction() & 255;
        if (r103 != 1) goto L8;
        EditIntroductionFragment r104 = this.f112660a;
        EditText r105 = r104.f112145f;
        if (r105 == null) goto L16;
        r105.setFocusable(true);
    L16:
        EditText r106 = r104.f112145f;
        if (r106 == null) goto L19;
        r106.setFocusableInTouchMode(true);
    L19:
        EditText r107 = r104.f112145f;
        if (r107 == null) goto L22;
        r107.requestFocus();
    L22:
        EditText r108 = r104.f112145f;
        if (r108 == null) goto L25;
        r108.requestFocusFromTouch();
    L25:
        ViewParent r109 = r100.getParent();
        if (r109 == null) goto L28;
        r109.requestDisallowInterceptTouchEvent(false);
    L28:
        return false;
    L8:
        if (r103 != 2) goto L28;
        EditText r110 = this.f112660a.f112145f;
        if (r110 == null) goto L28;
        r110.setFocusable(false);
        goto L28
    }
}
