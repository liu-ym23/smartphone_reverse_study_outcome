package com.bytedance.android.shopping.anchorv4.bottom;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class CartNumberComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f165750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f165751b;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f165752a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(Function0 r100) {
            this.f165752a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f165752a.invoke();
        }
    }

    static {
    }

    public final TextView a() {
        return (TextView) this.f165750a.getValue();
    }

    public final Context getContext() {
        return this.f165751b;
    }

    public CartNumberComponent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f165751b = r100;
        this.f165750a = LazyKt.lazy(new CartNumberComponent$numberDotView$2(this));
    }

    public final TextView b(EnterCartMeta r100) {
        if (com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(r100.getFirstCount())) <= 0) goto L13;
        a().setVisibility(0);
        TextView r101 = a();
        if ((r101 instanceof TextView) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L15;
        int r102 = com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(r100.getFirstCount()));
        if (r102 <= 99) goto L11;
        String r103 = "99+";
    L12:
        r101.setText(r103);
        goto L15
    L11:
        r103 = String.valueOf(r102);
    L15:
        return a();
    L13:
        a().setVisibility(8);
        goto L15
    }

    public final void c(int r100) {
        if (r100 <= 0) goto L12;
        a().setVisibility(0);
        TextView r101 = a();
        if ((r101 instanceof TextView) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r100 <= 99) goto L10;
        String r102 = "99+";
    L11:
        r101.setText(r102);
        return;
    L10:
        r102 = String.valueOf(r100);
        goto L11
    L12:
        a().setVisibility(8);
    }

    public final void d(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "showToast");
        if (r100 <= 0) goto L5;
        c(r100);
        a().setVisibility(0);
        Animation r102 = AnimationUtils.loadAnimation(this.f165751b, R.anim.anim_cart_dot_scale);
        r102.setAnimationListener(new b(r101));
        a().startAnimation(r102);
        return;
    L5:
        a().setVisibility(4);
    }
}
