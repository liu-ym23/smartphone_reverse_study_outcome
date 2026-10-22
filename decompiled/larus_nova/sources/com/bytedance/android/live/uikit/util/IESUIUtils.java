package com.bytedance.android.live.uikit.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import bc1.b;
import bc1.c;
import bc1.d;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.common.util.HoneyCombMR2V13Compat;
import com.bytedance.common.util.JellyBeanV16Compat;
import com.bytedance.common.utility.ICustomToast;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public class IESUIUtils {
    public IESUIUtils() {
    }

    public static final String getDisplayCountChinese(long r100) {
        return getDisplayCount(r100, "万");
    }

    public static final int getNavigationBarHeight(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        boolean r101 = KeyCharacterMap.deviceHasKey(3);
        int r102 = r100.getResources().getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r101 == false) goto L11;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r100.getResources().getDimensionPixelSize(r102);
    L14:
        return 0;
    }

    public static boolean isChildWidthCountLTParentWidth(ViewGroup r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getChildCount() == 0) goto L16;
        int r101 = r100.getChildCount();
        int r102 = r100.getWidth();
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= r101) goto L10;
        r104 = r104 + r100.getChildAt(r103).getWidth();
        r103 = r103 + 1;
        goto L8
    L10:
        if (r104 <= r102) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static boolean isMaterialNotification(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        TypedArray r101 = null;
        int r102 = r100.getResources().getColor(R.color.notification_title);     // Catch: Throwable -> L12
        r101 = r100.obtainStyledAttributes(R.style.NotificationTitle, new int[]{android.R.attr.textColor, android.R.attr.textSize});     // Catch: Throwable -> L12
        if (r102 == r101.getColor(0, 0)) goto L21;
    L19:
        r101.recycle();     // Catch: Throwable -> L15
    L14:
        return false;
    L21:
        r101.recycle();     // Catch: Throwable -> L16
    L9:
        return true;
    L12:
        if (r101 == null) goto L14;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToast(Context r100, String r101) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if ((r100 instanceof ICustomToast) == false) goto L17;
        ((ICustomToast) r100).showCustomToast(r101);
        return;
    L17:
        Toast r102 = Toast.makeText(r100, r101, 0);     // Catch: Exception -> L14
        if (r102 == null) goto L21;
        r102.show();     // Catch: Exception -> L14
        return;
    L21:
        return;
    L14:
        e = move-exception;
        Logger.throwException(e);
    }

    public static final String getDisplayCount(long r100, String r101) {
        if (r100 <= 10000) goto L11;
        String r102 = String.format("%.1f", new Object[]{Double.valueOf((r100 * 1.0d) / 10000.0d)});
        if ('0' != r102.charAt(r102.length() - 1)) goto L9;
        return r102.substring(0, r102.length() - 2) + r101;
    L9:
        return r102 + r101;
    L11:
        return String.valueOf(r100);
    }

    public static boolean isRecycleViewCanScroll(RecyclerView r100, RecyclerView.Adapter r101) {
        if (r100 == null) goto L12;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getItemCount() <= r100.getChildCount()) goto L9;
    L10:
        return true;
    L9:
        if (isChildWidthCountLTParentWidth(r100) == true) goto L10;
        return false;
    L12:
        return false;
    }

    public static void setViewBackground(View r100, Drawable r101) {
        JellyBeanV16Compat.setViewBackground(r100, r101);
    }

    public static void displayToast(Context r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        displayToast(r100, r100.getString(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToast(Context r100, String r101, long r102) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if ((r100 instanceof c) == false) goto L17;
        ((c) r100).a();
        return;
    L17:
        Toast r103 = Toast.makeText(r100, r101, 0);     // Catch: Exception -> L14
        if (r103 == null) goto L21;
        r103.show();     // Catch: Exception -> L14
        return;
    L21:
        return;
    L14:
        e = move-exception;
        Logger.throwException(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToast(Context r100, int r101, d r102) {
        if (r100 == 0) goto L9;
        if (r101 > 0) goto L6;
        return;
    L6:
        if ((r100 instanceof b) == false) goto L10;
        ((b) r100).b();
        return;
    L10:
        return;
    }

    public static void displayToast(Context r100, int r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        displayToast(r100, r100.getString(r101), r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void displayToast(Context r100, int r101, d r102, int r103) {
        if (r100 == 0) goto L9;
        if (r101 > 0) goto L6;
        return;
    L6:
        if ((r100 instanceof b) == false) goto L10;
        ((b) r100).a();
        return;
    L10:
        return;
    }

    public static float viewInScreenRate(Context r100, View r101, int r102, Point r103, int[] r104) {
        if (r101 != null) goto L5;
        return 0.0f;
    L5:
        HoneyCombMR2V13Compat.getDisplaySize(r100, r103);
        int r105 = r103.y;
        r101.getLocationOnScreen(r104);
        ViewGroup.LayoutParams r106 = r101.getLayoutParams();
        if (r106 == null) goto L8;
        int r107 = r106.height;
    L9:
        int r108 = r104[1] - r102;
        int r109 = r108 + r107;
        if (r109 > r105) goto L13;
        r105 = r109;
    L13:
        if (r108 <= 0) goto L16;
        r105 = r105 - r108;
    L16:
        return r105 / r107;
    L8:
        r107 = r101.getMeasuredHeight();
        goto L9
    }
}
