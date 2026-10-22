package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.extensions.j;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f183323a;

    private final View getSpaceView() {
        return (View) this.f183323a.getValue();
    }

    public final void a(boolean r100) {
        View r101 = getSpaceView();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    public f(final Context r100, String r110, com.bytedance.android.ecom.arch.slice.render.context.b r111) {
        Intrinsics.checkNotNullParameter(r111, "metrics");
        super(r100, null, 0);
        TextView r101 = new TextView(r100);
        TextView r102 = new TextView(r100);
        this.f183323a = LazyKt.lazy(new SpecificationTitleView$spaceView$2(r100));
        View r103 = getSpaceView();
        GradientDrawable r104 = new GradientDrawable();
        r104.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r104.setColors(new int[]{j.b(R.color.white_0), -1});
        Unit r105 = Unit.INSTANCE;
        r103.setBackground(r104);
        r103.setVisibility(4);
        addView(r103, new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(24, r111), -1));
        r101.setBackgroundColor(-1);
        r101.setText(r110);
        r101.setGravity(16);
        r101.setTextColor(j.b(R.color.shopping_std_bg_primary_2));
        r101.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -1);
        r106.gravity = 16;
        addView(r101, r106);
        r101.setMaxWidth(SlcDimensExtensionsKt.a(180, r111));
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setSingleLine(true);
        r102.setText(j.c(R.string.shopping_choices));
        r102.setBackgroundColor(-1);
        r102.setGravity(16);
        r102.setTextColor(j.b(R.color.shopping_std_bg_primary_2));
        r102.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -1);
        r112.gravity = 16;
        addView(r102, r112);
    }
}
