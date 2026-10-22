package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static final void g(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        r100.setVisibility(8);
        return;
    L7:
        r100.setVisibility(0);
    }

    public static Function0 h(final TextView r100) {
        final int r101 = 0;
        return new STIDebugHelperKt$intGetter$1(r100, r101);
    }

    public static final void a(View r100, int r101) {
        if (r100 == null) goto L6;
        GradientDrawable r102 = new GradientDrawable();
        r102.setStroke((int) UIUtils.dip2Px(r100.getContext(), 1.0f), r101);
        IESUIUtils.setViewBackground(r100, r102);
        return;
    }

    public static final int d(DataCenter r100, DataContext r101) {
        r r102 = z51.a.d(r101);
        if (r102 != null) goto L5;
    L14:
        return R.id.activity_indicator_container;
    L5:
        if (r102.j("long_touch") != true) goto L14;
        if (r100 == null) goto L10;
        Boolean r103 = (Boolean) r100.get("data_is_portrait", Boolean.TRUE);
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        if (r104 != true) goto L13;
        return R.id.portrait_activity_indicator_container;
    L13:
        return R.id.landscape_top_left_activity_banner;
    L10:
        r104 = true;
        goto L11
    }

    public static final int e(DataCenter r100, DataContext r101) {
        r r102 = z51.a.d(r101);
        if (r102 != null) goto L5;
    L14:
        return R.id.predictor_entrance_container;
    L5:
        if (r102.j("long_touch") != true) goto L14;
        if (r100 == null) goto L10;
        Boolean r103 = (Boolean) r100.get("data_is_portrait", Boolean.TRUE);
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        if (r104 != true) goto L13;
        return R.id.portrait_predictor_entrance_container;
    L13:
        return R.id.landscape_predictor_entrance_container;
    L10:
        r104 = true;
        goto L11
    }

    public static final int f(DataCenter r100, DataContext r101) {
        r r102 = z51.a.d(r101);
        if (r102 != null) goto L5;
    L14:
        return R.id.task_indicator_container;
    L5:
        if (r102.j("long_touch") != true) goto L14;
        if (r100 == null) goto L10;
        Boolean r103 = (Boolean) r100.get("data_is_portrait", Boolean.TRUE);
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        if (r104 != true) goto L13;
        return R.id.portrait_task_indicator_container;
    L13:
        return R.id.landscape_top_left_task_banner;
    L10:
        r104 = true;
        goto L11
    }

    public static final void i(ViewGroup r100, Function1 r101) {
        LinearLayout r102 = new LinearLayout(r100.getContext());
        r102.setOrientation(0);
        r101.invoke(r102);
        r100.addView(r102);
    }

    public static final void b(ViewGroup r100, CharSequence r110, Function1 r111) {
        TextView r101 = new TextView(r100.getContext());
        r101.setText(r110);
        GradientDrawable r112 = new GradientDrawable();
        r112.setStroke(UtilityKotlinExtentionsKt.i(1), -1);
        r112.setCornerRadius(UtilityKotlinExtentionsKt.h(3));
        r112.setColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{-256, 0}));
        r101.setBackground(r112);
        int r113 = UtilityKotlinExtentionsKt.i(6);
        r101.setPadding(r113, r113, r113, r113);
        r101.setTextColor(-1);
        r101.setOnClickListener(new i(r111));
        r100.addView(r101);
    }

    public static final EditText c(ViewGroup r100, CharSequence r101, Function1 r102) {
        EditText r103 = new EditText(r100.getContext());
        r103.setHint(r101);
        r102.invoke(r103);
        r100.addView(r103);
        return r103;
    }
}
