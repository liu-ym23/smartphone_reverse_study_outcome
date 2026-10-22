package com.bytedance.android.livesdk.chatroom.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ShortTermFrameLayout.a f114761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f114762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f114763c;

    public final boolean b() {
        ViewGroup r100 = this.f114763c;
        if (r100 == null) goto L5;
        int r101 = r100.getChildCount();
    L6:
        if (r101 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    public final void c() {
        ViewGroup r100 = this.f114763c;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r100, b());
    L5:
        ShortTermFrameLayout.a r101 = this.f114761a;
        if (r101 == null) goto L17;
        int r102 = this.f114762b.getChildCount() + (b() ? 1 : 0);
        int[] r103 = {0, 0};
        if (LiveInfraSettingKeys.LIVE_DISABLE_ENHANCED_SHORT_TOUCH.getValue().booleanValue() == false) goto L10;
        ViewGroup r104 = this.f114762b;
    L15:
        r104.getLocationInWindow(r103);
        int r105 = UtilityKotlinExtentionsKt.k(r103[0]);
        int r106 = UtilityKotlinExtentionsKt.k(r103[1]);
        int r107 = UtilityKotlinExtentionsKt.k(r104.getWidth());
        r101.a(r102, new Rect(r105, r106, r107 + r105, UtilityKotlinExtentionsKt.k(r104.getHeight()) + r106));
        return;
    L10:
        ViewGroup r108 = UtilityKotlinExtentionsKt.p(this.f114762b);
        if (r108 == null) goto L14;
        r104 = UtilityKotlinExtentionsKt.p(r108);
        if (r104 != null) goto L15;
    L14:
        r104 = this.f114762b;
        goto L15
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(r100.getTag(), Boolean.TRUE) == true) goto L5;
        this.f114762b.addView(r100);
    L16:
        c();
        return;
    L5:
        if (b() == false) goto L12;
        ViewGroup r101 = this.f114763c;
        if (r101 == null) goto L9;
        View r102 = r101.getChildAt(0);
    L11:
        if ((!Intrinsics.areEqual(r102, r100)) == false) goto L16;
    L9:
        r102 = null;
    L12:
        ViewGroup r103 = this.f114763c;
        if (r103 == null) goto L16;
        r103.removeAllViews();
        UtilityKotlinExtentionsKt.q(r100);
        r103.addView(r100);
        goto L16
    }

    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(r100.getTag(), Boolean.TRUE) == false) goto L7;
        ViewGroup r101 = this.f114763c;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        c();
        return;
    L7:
        this.f114762b.removeView(r100);
        goto L8
    }

    public l(ViewGroup r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultLayout");
        this.f114762b = r100;
        this.f114763c = r101;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }
}
