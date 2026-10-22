package com.bytedanceos.appstore.ui.fragment;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int[] f9528a;

    static {
        f9528a = new int[]{R.id.app_video_image, R.id.appImage1, R.id.appImage2, R.id.appImage3, R.id.appImage4, R.id.appImage5};
    }

    public static void a(ViewGroup r10) {
        if (r10 == null) goto L5;
        b(r10);
        c(r10);
        return;
    }

    public static void b(ViewGroup r10) {
        NetworkImageView r11 = (NetworkImageView) r10.findViewById(R.id.appIcon);
        if (r11 == null) goto L6;
        r11.setImageUrl(null);
        return;
    }

    public static void c(ViewGroup r10) {
        int[] r11 = f9528a;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        NetworkImageView r14 = (NetworkImageView) r10.findViewById(r11[r13]);
        if (r14 == null) goto L7;
        r14.setImageUrl(null);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    public static ViewGroup d(ViewGroup r10, View.OnClickListener r11, boolean r12) {
        return (ViewGroup) View.inflate(r10.getContext(), R.layout.appinfo, null);
    }

    public static void e(ViewGroup r10, AppInfo r11) {
        if (r10 == null) goto L5;
        f(r10, r11);
        h(r10, r11);
        return;
    }

    public static void f(ViewGroup r10, AppInfo r11) {
        ((NetworkImageView) r10.findViewById(R.id.appIcon)).e(r11.appIcon, d.f10012d);
    }

    public static void g(ViewGroup r10, AppInfo r11) {
    }

    public static void h(ViewGroup r11, AppInfo r12) {
        if (TextUtils.isEmpty(r12.mAppVideoUrl) == false) goto L9;
        List<String> r10 = r12.appScreenSnaps;
        if (r10 != null) goto L7;
    L8:
        r11.findViewById(R.id.appinfo_image_hsv).setVisibility(8);
    L10:
        ArrayList r13 = new ArrayList();
        String r14 = r12.mAppVideoImage;
        if (r14 != null) goto L13;
        r14 = "";
    L13:
        r13.add(r14);
        r13.addAll(r12.appScreenSnaps);
        Resources r15 = r11.getContext().getResources();
        int r16 = r15.getDimensionPixelOffset(R.dimen.oui_r_l3_rect);
        int r17 = 0;
    L14:
        int[] r18 = f9528a;
        if (r17 >= r18.length) goto L40;
        NetworkImageView r19 = (NetworkImageView) r11.findViewById(r18[r17]);
        if (r19 != null) goto L20;
        j.b("updateHorizontalScrollView:screenShot is null.");
    L39:
        r17 = r17 + 1;
        goto L14
    L20:
        if (r17 < r13.size()) goto L23;
        ((RelativeLayout) r19.getParent()).setVisibility(8);
        goto L39
    L23:
        if (r17 != 0) goto L28;
        if (TextUtils.isEmpty(r12.mAppVideoUrl) == false) goto L28;
        r11.findViewById(R.id.app_video_des).setVisibility(8);
    L28:
        if (TextUtils.equals(r12.appSource, AppInfo.SEARCH_SOURCE_EXTENAL) == false) goto L31;
        String r20 = (String) r13.get(r17);
    L38:
        r19.setDefaultImageResId(R.drawable.screenshot_default);
        r19.e(r20, r16);
        r19.setTag(r12);
        r19.setTag(R.id.image_index, Integer.valueOf(r17));
        r19.setVisibility(0);
        goto L39
    L31:
        if (r17 <= 0) goto L33;
        r20 = e.B((String) r13.get(r17), r15.getDimensionPixelSize(R.dimen.appinfo_image_hsv_width));
        goto L38
    L33:
        r11.findViewById(R.id.app_video_play).setTag(r12);
        RelativeLayout r21 = (RelativeLayout) r11.findViewById(R.id.app_video_des);
        r21.setVisibility(0);
        if (r12.mAppVideoType != 2) goto L36;
        int r22 = r15.getDimensionPixelOffset(R.dimen.video_landscape_margin);
        int r23 = r15.getDisplayMetrics().widthPixels - (r22 * 2);
        LinearLayout.LayoutParams r110 = (LinearLayout.LayoutParams) r21.getLayoutParams();
        r110.width = r23;
        r110.rightMargin = r22;
        r21.setLayoutParams(r110);
    L37:
        r20 = e.B((String) r13.get(r17), r23);
        goto L38
    L36:
        r23 = r15.getDimensionPixelSize(R.dimen.appinfo_image_hsv_width);
        goto L37
    L40:
        return;
    L7:
        if (r10.isEmpty() == true) goto L8;
    L9:
        r11.findViewById(R.id.appinfo_image_hsv).setVisibility(0);
        goto L10
    }
}
