package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f190049d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f190050e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f190051f = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f190052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f190053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f190054c;

    public static final class a {
    }

    static {
        f190049d = com.bytedance.android.shopping.extensions.b.b(2);
        f190050e = com.bytedance.android.ec.core.utils.q.a(7);
        f190051f = com.bytedance.android.ec.core.utils.q.a(5);
    }

    public final boolean getAscending() {
        return this.f190054c;
    }

    public final ImageView a(boolean r100) {
        ImageView r101 = new ImageView(getContext());
        r101.setLayoutParams(new LinearLayout.LayoutParams((int) f190050e, (int) f190051f));
        r101.setAdjustViewBounds(true);
        r101.setImageResource(R.drawable.ec_shop_ic_accending);
        if (r100 == true) goto L5;
        r101.setScaleY(-1.0f);
    L5:
        return r101;
    }

    public k(boolean r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null);
        this.f190054c = r100;
        setOrientation(1);
        ImageView r102 = a(true);
        this.f190052a = r102;
        addView(r102);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L7;
        int r104 = f190049d;
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = r104;
        ImageView r105 = a(false);
        this.f190053b = r105;
        addView(r105);
        b(this.f190054c, true);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void b(boolean r100, boolean r101) {
        this.f190054c = r100;
        if (r101 == false) goto L7;
        int r102 = (int) 4289769652L;
        this.f190052a.setColorFilter(r102);
        this.f190053b.setColorFilter(r102);
        return;
    L7:
        if (r100 == false) goto L9;
        this.f190052a.setColorFilter((int) 4294909001L);
        this.f190053b.setColorFilter((int) 4289769652L);
        return;
    L9:
        this.f190052a.setColorFilter((int) 4289769652L);
        this.f190053b.setColorFilter((int) 4294909001L);
    }
}
