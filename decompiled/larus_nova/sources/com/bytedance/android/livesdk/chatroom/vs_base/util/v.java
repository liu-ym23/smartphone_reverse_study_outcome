package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes8.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f118218a = 0;

    static {
    }

    public static void a(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L8;
        return;
    L8:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103.leftMargin == (-3)) goto L12;
    L18:
        if (r101 == (-3)) goto L20;
        r103.topMargin = r101;
    L20:
        r100.setLayoutParams(r103);
        return;
    L12:
        if (r103.topMargin != r101) goto L18;
        if (r103.rightMargin != (-3)) goto L18;
        if (r103.bottomMargin != (-3)) goto L18;
        return;
    }
}
