package com.bytedance.android.livesdk.chatroom.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f114508a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f114509b = 1;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f114510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f114511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f114512c;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            ViewGroup.LayoutParams r102 = this.f114510a.getLayoutParams();
            r102.width = (int) ((this.f114511b * r101) + this.f114512c);
            this.f114510a.setLayoutParams(r102);
        }

        public a(View r100, int r101, int r102) {
            this.f114510a = r100;
            this.f114511b = r101;
            this.f114512c = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f114513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f114514b;

        @Override // java.lang.Runnable
        public final void run() {
            boolean r100 = this.f114513a;     // Catch: Throwable -> L7
            int r101 = this.f114514b;     // Catch: Throwable -> L7
            if (r100 == false) goto L5;
            i3.f114509b = r101;     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            i3.f114508a = r101;     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public b(boolean r100, int r101) {
            this.f114513a = r100;
            this.f114514b = r101;
        }
    }

    public static int a(boolean r100) {
        if (r100 == false) goto L5;
        return f114509b;
    L5:
        return f114508a;
    }

    public static void b(final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r100, final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r101, final boolean r102) {
        if (com.bytedance.android.live.core.setting.v4.f65439a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        View r103 = r100.f115174a;
        if (r103 != null) goto L8;
        return;
    L8:
        UIUtils.updateLayout(r103, com.bytedance.android.live.core.utils.s1.j(R.dimen.ttlive_room_top_right_banner_width), -2);
        r100.f115174a.post(new c3(r102, r100, r101));
    }

    public static void c(final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f r100, final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r101, final boolean r102) {
        if (com.bytedance.android.live.core.setting.v4.f65439a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        View r103 = r100.f115179b;
        View r104 = r100.f115180c;
        if (r103 == null) goto L11;
        if (r104 == null) goto L12;
        UIUtils.updateLayoutMargin(r103, -3, -3, 0, -3);
        UIUtils.updateLayout(r104, 0, 0);
        r104.post(new d3(r102, r100, r101));
        return;
    L12:
        return;
    }

    public static void d(com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.f r100, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r101, boolean r102) {
        View r103 = r100.f115180c;
        if (r103 == null) goto L5;
        UIUtils.updateLayout(r103, com.bytedance.android.live.core.utils.s1.j(R.dimen.ttlive_live_room_indicator_space_right), -1);
    L5:
        r101.Yb(8);
        RoomTopRightBannerEvent r104 = new RoomTopRightBannerEvent();
        r104.setStatus(1);
        r104.setAnimationTime(250);
        View r105 = r100.f115179b;
        r105.post(new e3(r104, r105, r102, r101));
    }

    public static void e(com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.d r100, final com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r101, final RoomTopRightBannerEvent r102, final boolean r103) {
        final View r104 = r100.f115174a;
        if (r104 == null) goto L8;
        if (r101 == null) goto L9;
        r104.post(new f3(r102, r104, r103, r101));
        return;
    L9:
        return;
    }

    public static Animator f(View r100, RoomTopRightBannerEvent r101, int r102, boolean r103, long r104) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r105 = r101.getStatus();
        int r106 = -r102;
        if (r106 <= 0) goto L8;
        int r107 = com.bytedance.android.live.core.utils.s1.f(21.0f);
    L13:
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.addUpdateListener(new a(r100, r106, r107));
        r100.postDelayed(new b(r103, r105), r104);
        return r108;
    L8:
        r107 = r100.getLayoutParams().width;
        if (r107 != (-2)) goto L11;
    L12:
        r107 = r100.getWidth();
        goto L13
    L11:
        if (r107 != (-1)) goto L13;
        goto L12
    }
}
