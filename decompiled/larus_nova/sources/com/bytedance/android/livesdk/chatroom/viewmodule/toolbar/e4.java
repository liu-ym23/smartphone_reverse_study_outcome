package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e4 extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f116241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f116242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f116243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f116244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f116245e;

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f116243c.contains((int) r100.getX(), (int) r100.getY()) == false) goto L6;
        return this.f116244d.b(r100.getAction(), r100.getRawX() - this.f116241a, r100.getRawY() - this.f116242b, "3");
    L6:
        return super.onTouchEvent(r100);
    }

    public e4(Rect r100, r0 r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        Intrinsics.checkNotNullParameter(r101, BitableAnalytic.LinkSceneClickType.EXPAND);
        Intrinsics.checkNotNullParameter(r102, "delegateView");
        super(r100, r102);
        this.f116243c = r100;
        this.f116244d = r101;
        this.f116245e = r102;
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        this.f116241a = r103[0];
        this.f116242b = r103[1];
    }
}
