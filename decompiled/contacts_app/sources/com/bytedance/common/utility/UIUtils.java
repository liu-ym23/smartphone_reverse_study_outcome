package com.bytedance.common.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;
import com.android.contacts.ContactsUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class UIUtils {
    public static final boolean API_ET_20 = false;
    private static final int BURY_WIDTH_DP = 20;
    public static final char ELLIPSIS_CHAR = 8230;
    private static final float FLOAT_BIAS = 0.5f;
    private static final float FLOAT_DOT999 = 0.999f;
    public static final int LAYOUT_PARAMS_KEEP_OLD = -3;
    private static final int MASK_1000 = 16777216;
    private static final int MASK_FF = 255;
    private static final int MASK_FFFF = 16777215;
    private static final int MAX_COUNT = 10000;
    private static final int MAX_WIDTH = 1375;
    private static int mDpi;
    private static String sScreenResolution;
    public static EllipsisMeasureResult sTempEllipsisResult;
    private static ToastHook sToastHook;

    public static class EllipsisMeasureResult {
        public String ellipsisStr;
        public int length;

        public EllipsisMeasureResult() {
        }
    }

    public interface ToastHook {
        boolean showToast(Context r1, int r2, CharSequence r3, long r4, int r6);
    }

    public static int floatToIntBig(float r1) {
        return (int) (r1 + FLOAT_DOT999);
    }

    public static int setColorAlpha(int r1, int r2) {
        if (r2 <= 255) goto L5;
        r2 = 255;
    L8:
        return (r1 & 16777215) | (r2 * 16777216);
    L5:
        if (r2 >= 0) goto L8;
        r2 = 0;
        goto L8
    }

    private static boolean visibilityValid(int r1) {
        if (r1 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r1 == 8) goto L9;
        if (r1 == 4) goto L9;
        return false;
    }

    static /* synthetic */ void access$000(Context r0, int r1, String r2, int r3, int r4) {
        displayToastInternal(r0, r1, r2, r3, r4);
    }

    private UIUtils() {
    }

    static {
        API_ET_20 = true;
        sScreenResolution = "";
        mDpi = -1;
        sTempEllipsisResult = new EllipsisMeasureResult();
    }

    public static void setToastHook(ToastHook r0) {
        sToastHook = r0;
    }

    public static void displayToast(Context r1, String r2) {
        displayToast(r1, 0, r2);
    }

    public static void displayToast(Context r0, int r1) {
        displayToast(r0, r0.getString(r1));
    }

    public static void displayToastWithIcon(Context r0, int r1, int r2) {
        displayToast(r0, r1, r0.getString(r2));
    }

    public static void displayToastWithIcon(Context r0, int r1, String r2) {
        displayToast(r0, r1, r2);
    }

    public static void displayToast(Context r0, int r1, int r2) {
        displayToast(r0, r0.getString(r1), r2);
    }

    public static void displayToast(Context r1, String r2, int r3) {
        displayToastInternal(r1, 0, r2, 0, r3);
    }

    public static void displayToast(Context r2, int r3, String r4) {
        displayToastInternal(r2, r3, r4, 0, 17);
    }

    public static void displayLongTimeToast(Context r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        String r5 = r2.getString(r4);
        if (StringUtils.isEmpty(r5) == false) goto L7;
        return;
    L7:
        displayToastInternal(r2, r3, r5, 1, 17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void displayToastInternal(final Context r9, final int r10, final String r11, final int r12, final int r13) {
        if (r9 != 0) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r11) == false) goto L7;
        return;
    L7:
        if (isInUIThread() == true) goto L9;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r9, r10, r11, r12, r13));
        return;
    L9:
        ToastHook r2 = sToastHook;
        if (r2 == null) goto L15;
        if (r2.showToast(r9, r10, r11, r12, r13) == false) goto L15;
        return;
    L15:
        if ((r9 instanceof ICustomToast) == true) goto L17;
        Toast r14 = Toast.makeText(r9, r11, r12);     // Catch: Exception -> L27
        if (r14 == null) goto L36;
        r14.setGravity(r13, 0, 0);     // Catch: Exception -> L27
        r14.show();     // Catch: Exception -> L27
        return;
    L36:
        return;
    L27:
        e = move-exception;
        Logger.throwException(e);
        return;
    L17:
        if (r12 != 1) goto L19;
        ((ICustomToast) r9).showCustomLongToast(r10, r11);
        return;
    L19:
        ICustomToast r15 = (ICustomToast) r9;
        if (r12 != 0) goto L22;
        r12 = 2000;
    L22:
        r15.showCustomToast(r10, r11, r12, r13);
    }

    public static float sp2px(Context r1, float r2) {
        if (r1 != null) goto L4;
        return 0.0f;
    L4:
        return TypedValue.applyDimension(2, r2, r1.getResources().getDisplayMetrics());
    }

    public static float dip2Px(Context r0, float r1) {
        if (r0 != null) goto L4;
        return 0.0f;
    L4:
        return (r1 * r0.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int px2dip(Context r0, float r1) {
        if (r0 != null) goto L4;
        return 0;
    L4:
        return (int) ((r1 / r0.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void expandClickRegion(final View r7, final int r8, final int r9, final int r10, final int r11) {
        r7.post(new AnonymousClass2(r7, r9, r11, r8, r10));
    }

    public static void setViewBackgroundWithPadding(View r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getPaddingLeft();
        int r1 = r4.getPaddingRight();
        int r2 = r4.getPaddingTop();
        int r3 = r4.getPaddingBottom();
        r4.setBackgroundResource(r5);
        r4.setPadding(r0, r2, r1, r3);
    }

    public static void setViewBackgroundWithPadding(View r4, Resources r5, int r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getPaddingLeft();
        int r1 = r4.getPaddingRight();
        int r2 = r4.getPaddingTop();
        int r3 = r4.getPaddingBottom();
        r4.setBackgroundColor(r5.getColor(r6));
        r4.setPadding(r0, r2, r1, r3);
    }

    public static void setViewBackgroundWithPadding(View r4, Drawable r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getPaddingLeft();
        int r1 = r4.getPaddingRight();
        int r2 = r4.getPaddingTop();
        int r3 = r4.getPaddingBottom();
        r4.setBackgroundDrawable(r5);
        r4.setPadding(r0, r2, r1, r3);
    }

    public static String getDisplayCount(int r7) {
        if (r7 <= 10000) goto L11;
        String r8 = String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf((((double) r7) * 1.0d) / 10000.0d)});
        if ('0' != r8.charAt(r8.length() - 1)) goto L9;
        return r8.substring(0, r8.length() - 2) + "万";
    L9:
        return r8 + "万";
    L11:
        return String.valueOf(r7);
    }

    public static int getScreenWidth(Context r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r2 = r1.getResources().getDisplayMetrics();
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.widthPixels;
    }

    public static int getRatioOfScreen(Context r0, float r1) {
        DisplayMetrics r2 = r0.getResources().getDisplayMetrics();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return (int) (r2.widthPixels * r1);
    }

    public static boolean isInUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void assertInUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Logger.alertErrorInfo("not in UI thread");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static int getScreenHeight(Context r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r2 = r1.getResources().getDisplayMetrics();
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.heightPixels;
    }

    public static String getScreenResolution(Context r2) {
        if (StringUtils.isEmpty(sScreenResolution) == false) goto L10;
        if (r2 == null) goto L10;
        int r0 = getScreenWidth(r2);
        int r3 = getScreenHeight(r2);
        if (r0 <= 0) goto L10;
        if (r3 <= 0) goto L10;
        sScreenResolution = r0 + ContactsUtils.CHAR_STAR + r3;
    L10:
        return sScreenResolution;
    }

    public static int getDpi(Context r2) {
        if (mDpi != (-1)) goto L7;
        if (r2 == null) goto L7;
        mDpi = r2.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L7:
        return mDpi;
    }

    public static int getDiggBuryWidth(Context r2) {
        return ((r2.getResources().getDisplayMetrics().widthPixels * MAX_WIDTH) / 10000) + ((int) dip2Px(r2, 20.0f));
    }

    public static int getStatusBarHeight(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = r5.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r1 > 0) goto L8;
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r1);
    }

    public static void setViewVisibility(View r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.getVisibility() != r2) goto L6;
        return;
    L6:
        if (visibilityValid(r2) == false) goto L12;
        r1.setVisibility(r2);
        return;
    }

    public static boolean isViewVisible(View r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static void getLocationInUpView(View r5, View r6, int[] r7, boolean r8) {
        if (r5 == null) goto L13;
        if (r6 == null) goto L14;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.length < 2) goto L16;
        r5.getLocationInWindow(r7);
        int r0 = r7[0];
        int r3 = r7[1];
        r6.getLocationInWindow(r7);
        int r4 = r7[0] - r0;
        int r1 = r7[1] - r3;
        if (r8 == false) goto L11;
        int r9 = r6.getWidth();
        r4 = r4 + (r9 / 2);
        r1 = r1 + (r6.getHeight() / 2);
    L11:
        r7[0] = r4;
        r7[1] = r1;
        return;
    L16:
        return;
    L14:
        return;
    }

    public static void updateLayout(View r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.width != r3) goto L12;
        if (r0.height != r4) goto L12;
        return;
    L12:
        if (r3 == (-3)) goto L14;
        r0.width = r3;
    L14:
        if (r4 == (-3)) goto L16;
        r0.height = r4;
    L16:
        r2.setLayoutParams(r0);
    }

    public static void updateLayoutMargin(View r8, int r9, int r10, int r11, int r12) {
        if (r8 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        updateMargin(r8, (ViewGroup.MarginLayoutParams) r0, r9, r10, r11, r12);
        return;
    }

    private static void updateMargin(View r1, ViewGroup.MarginLayoutParams r2, int r3, int r4, int r5, int r6) {
        if (r1 == null) goto L25;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.leftMargin != r3) goto L15;
        if (r2.topMargin != r4) goto L15;
        if (r2.rightMargin != r5) goto L15;
        if (r2.bottomMargin != r6) goto L15;
        return;
    L15:
        if (r3 == (-3)) goto L17;
        r2.leftMargin = r3;
    L17:
        if (r4 == (-3)) goto L19;
        r2.topMargin = r4;
    L19:
        if (r5 == (-3)) goto L21;
        r2.rightMargin = r5;
    L21:
        if (r6 == (-3)) goto L23;
        r2.bottomMargin = r6;
    L23:
        r1.setLayoutParams(r2);
        return;
    }

    public static void setTopMargin(View r2, float r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        updateLayoutMargin(r2, -3, (int) TypedValue.applyDimension(1, r3, r2.getContext().getResources().getDisplayMetrics()), -3, -3);
    }

    public static void setLayoutParams(View r1, int r2, int r3) {
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        if (r4 != null) goto L6;
        return;
    L6:
        if (r2 == Integer.MIN_VALUE) goto L8;
        r4.width = r2;
    L8:
        if (r3 == Integer.MIN_VALUE) goto L11;
        r4.height = r3;
        return;
    }

    public static void setTxtAndAdjustVisible(TextView r1, CharSequence r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        setViewVisibility(r1, 8);
        return;
    L7:
        setViewVisibility(r1, 0);
        r1.setText(r2);
    }

    public static void setText(TextView r1, CharSequence r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r1.setText(r2);
        return;
    }

    public static void detachFromParent(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getParent() == null) goto L17;
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L14;
        return;
    L14:
        ((ViewGroup) r0).removeView(r2);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Logger.throwException(e);
        return;
    }

    public static void setViewMinHeight(View r1, int r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getMinimumHeight() != r2) goto L7;
        return;
    L7:
        r1.setMinimumHeight(r2);
    }

    public static void setTextViewMaxLines(TextView r1, int r2) {
        if (r1 == null) goto L14;
        if (r2 > 0) goto L6;
        return;
    L6:
        if (r1.getMaxLines() != r2) goto L8;
        return;
    L8:
        boolean r0 = true;
        if (r2 == 1) goto L12;
        r0 = false;
    L12:
        r1.setSingleLine(r0);
        r1.setMaxLines(r2);
        return;
    }

    public static int[] getLocationInAncestor(View r8, View r9) {
        if (r8 == null) goto L19;
        if (r9 == null) goto L19;
        int[] r2 = new int[2];
        float[] r1 = {0.0f, 0.0f};
        r1[0] = r1[0] + r8.getLeft();
        r1[1] = r1[1] + r8.getTop();
        ViewParent r5 = r8.getParent();
    L8:
        if ((r5 instanceof View) == false) goto L13;
        View r6 = (View) r5;
        if (r5 == r9) goto L11;
        r1[0] = r1[0] - r6.getScrollX();
        r1[1] = r1[1] - r6.getScrollY();
        r1[0] = r1[0] + r6.getLeft();
        r1[1] = r1[1] + r6.getTop();
        r5 = r6.getParent();
        goto L8
    L11:
        boolean r7 = true;
    L14:
        if (r7 == true) goto L17;
        Logger.alertErrorInfo("ancestorView:" + r9 + " is not the ancestor of child : " + r8);
        return null;
    L17:
        r2[0] = (int) (r1[0] + 0.5f);
        r2[1] = (int) (r1[1] + 0.5f);
        return r2;
    L13:
        r7 = false;
    L19:
        Logger.alertErrorInfo("invalid params: child:" + r8 + ",ancestor:" + r9);
        return null;
    }

    public static void ellipseSingleLineStr(String r10, int r11, Paint r12, int r13, EllipsisMeasureResult r14) {
        if (r11 > r13) goto L5;
    L17:
        r14.ellipsisStr = "";
        r14.length = 0;
        return;
    L5:
        if (StringUtils.isEmpty(r10) == true) goto L17;
        int r2 = floatToIntBig(r12.measureText(r10));
        if (r2 > r11) goto L11;
        r14.ellipsisStr = r10;
        r14.length = r2;
        return;
    L11:
        StringBuilder r3 = new StringBuilder();
        int r15 = r12.breakText(r10, 0, r10.length(), true, r11 - r13, null);
        if (r15 >= 1) goto L15;
        r14.ellipsisStr = "";
        r14.length = 0;
        return;
    L15:
        r3.append(r10.substring(0, r15));
        r3.append(8230);
        r14.ellipsisStr = r3.toString();
        r14.length = r11;
    }

    public static void requestOrienation(Activity r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isFinishing() == true) goto L13;
        r1.setRequestedOrientation(!r2 ? 1 : 0);
        if (r2 == false) goto L9;
        r1.getWindow().setFlags(1024, 1024);
        return;
    L9:
        r1.getWindow().clearFlags(1024);
        return;
    }

    public static int getIndexInParent(View r3) {
        if (r3 != null) goto L5;
    L11:
        return -1;
    L5:
        if (r3.getParent() == null) goto L11;
        ViewParent r1 = r3.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L11;
        return ((ViewGroup) r1).indexOfChild(r3);
    }

    public static boolean clearAnimation(View r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.getAnimation() == null) goto L10;
        r1.clearAnimation();
        return true;
    L10:
        return false;
    }

    public static void setClickListener(boolean r0, View r1, View.OnClickListener r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r0 == false) goto L6;
        r1.setOnClickListener(r2);
        r1.setClickable(true);
        return;
    L6:
        r1.setOnClickListener(null);
        r1.setClickable(false);
    }
}
