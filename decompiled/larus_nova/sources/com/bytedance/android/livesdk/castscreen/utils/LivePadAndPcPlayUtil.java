package com.bytedance.android.livesdk.castscreen.utils;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.e4;
import com.bytedance.android.livesdk.config.r61;
import com.bytedance.android.livesdk.config.z61;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LivePadAndPcPlayUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f104718a = 0;

    @JvmStatic
    public static final boolean f() {
        return r61.f121106a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean h() {
        return z61.f121740a.getValue().booleanValue();
    }

    static {
    }

    @JvmStatic
    public static final boolean g(DataCenter r100) {
        if (r100 == null) goto L6;
        lk1.c.f509546i2.getClass();
        mk1.a r101 = lk1.c.a.a(r100).getComponentStatus("room_auth_pad_play");
        if (r101 == null) goto L6;
        Boolean r102 = Boolean.valueOf(r101.a());
    L8:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L6:
        r102 = null;
        goto L8
    }

    @JvmStatic
    public static final boolean i(DataCenter r100) {
        if (r100 == null) goto L6;
        lk1.c.f509546i2.getClass();
        mk1.a r101 = lk1.c.a.a(r100).getComponentStatus("room_auth_pc_play");
        if (r101 == null) goto L6;
        Boolean r102 = Boolean.valueOf(r101.a());
    L8:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L6:
        r102 = null;
        goto L8
    }

    @JvmStatic
    public static final void a(View r100, boolean r101) {
        if (r100 == null) goto L20;
        if (r101 == false) goto L5;
        int r102 = R.color.white;
    L6:
        r100.setBackgroundColor(s1.h(r102));
        d((ImageView) r100.findViewById(R.id.ivPadIcon), r101);
        e((TextView) r100.findViewById(R.id.tvPadTitle), r101);
        TextView r103 = (TextView) r100.findViewById(R.id.tvSubPadTitle);
        if (r101 == false) goto L9;
        int r104 = R.color.ttlive_color_80_161823;
    L10:
        int r105 = s1.h(r104);
        if (r103 == null) goto L13;
        r103.setTextColor(r105);
    L13:
        ImageView r106 = (ImageView) r100.findViewById(R.id.ivPadArrow);
        if (r106 == null) goto L21;
        if (r101 == false) goto L17;
        int r107 = R.drawable.ttlive_ic_pad_pc_play_arrow_light_theme;
    L18:
        r106.setBackground(s1.m(r107));
        return;
    L17:
        r107 = R.drawable.ttlive_ic_pad_pc_play_arrow_dark_theme;
        goto L18
    L21:
        return;
    L9:
        r104 = R.color.ttlive_color_66_FFFFFF;
        goto L10
    L5:
        r102 = R.color.ttlive_color_1A_FFFFFF;
        goto L6
    }

    @JvmStatic
    public static final void b(View r100, boolean r101) {
        if (r100 == null) goto L20;
        if (r101 == false) goto L5;
        int r102 = R.color.white;
    L6:
        r100.setBackgroundColor(s1.h(r102));
        d((ImageView) r100.findViewById(R.id.ivPcIcon), r101);
        e((TextView) r100.findViewById(R.id.tvPcTitle), r101);
        TextView r103 = (TextView) r100.findViewById(R.id.tvSubPcTitle);
        if (r101 == false) goto L9;
        int r104 = R.color.ttlive_color_80_161823;
    L10:
        int r105 = s1.h(r104);
        if (r103 == null) goto L13;
        r103.setTextColor(r105);
    L13:
        ImageView r106 = (ImageView) r100.findViewById(R.id.ivPcArrow);
        if (r106 == null) goto L21;
        if (r101 == false) goto L17;
        int r107 = R.drawable.ttlive_ic_pad_pc_play_arrow_light_theme;
    L18:
        r106.setBackground(s1.m(r107));
        return;
    L17:
        r107 = R.drawable.ttlive_ic_pad_pc_play_arrow_dark_theme;
        goto L18
    L21:
        return;
    L9:
        r104 = R.color.ttlive_color_66_FFFFFF;
        goto L10
    L5:
        r102 = R.color.ttlive_color_1A_FFFFFF;
        goto L6
    }

    @JvmStatic
    public static final void c(TextView r100, final boolean r101) {
        SpannableStringBuilder r102 = new SpannableStringBuilder("电脑打开");
        e4.a(r102, "douyin.com", new LivePadAndPcPlayUtil$adaptPcSubtitle$$inlined$also$lambda$1(r101));
        r100.setText(r102.append("或抖音桌面端，登录相同账号"));
    }

    @JvmStatic
    public static final void d(ImageView r100, boolean r101) {
        if (r100 == null) goto L12;
        if (r101 == false) goto L5;
        int r102 = R.color.ttlive_color_161823;
    L6:
        int r103 = s1.h(r102);
        Drawable r104 = r100.getBackground();
        if (r104 == null) goto L13;
        Drawable r105 = r104.mutate();
        if (r105 == null) goto L14;
        r105.setColorFilter(r103, PorterDuff.Mode.SRC_ATOP);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r102 = R.color.white;
        goto L6
    }

    @JvmStatic
    public static final void e(TextView r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = R.color.ttlive_color_161823;
    L5:
        int r103 = s1.h(r102);
        if (r100 == null) goto L9;
        r100.setTextColor(r103);
        return;
    L9:
        return;
    L4:
        r102 = R.color.white;
        goto L5
    }
}
