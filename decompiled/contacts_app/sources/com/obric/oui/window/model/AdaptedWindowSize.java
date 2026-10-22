package com.obric.oui.window.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.GlobalProxyLancet;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.window.bean.AvailableWindowSize;
import com.obric.oui.window.bean.PageGridConfig;
import com.obric.oui.window.bean.WindowSizeClass;
import com.obric.oui.window.bean.WindowSizeWithPageSize;
import com.obric.oui.window.interfaces.OnWindowConfigChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: AdaptedWindowSize.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fJ\u001e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u0013J\u0006\u0010.\u001a\u00020\u0015J\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004002\u0006\u0010%\u001a\u00020&H\u0007J\u0012\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0006\u00104\u001a\u00020\"J\u000e\u00105\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fJ(\u00106\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\nJ.\u0010:\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010;\u001a\u00020\u00042\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000400H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/oui/window/model/AdaptedWindowSize;", "", "()V", "FULL_SCREEN", "", "MULTI_WINDOW", "NO_SUPPORT", "TAG", "", "<set-?>", "", "isHSplit", "()Z", "isInMultiWindowMode", "isVSplit", "mBaseGridColumnWidth", "", "mCurrentOrientation", "mCurrentPageSize", "Lcom/obric/oui/window/bean/AvailableWindowSize;", "mCurrentWindowSize", "Lcom/obric/oui/window/bean/WindowSizeClass;", "mLastPageSize", "mScreenMode", "getMScreenMode", "()I", "mWindowSizeInit", "sScreenSize", "", "windowConfigChangeListenersList", "Ljava/util/ArrayList;", "Lcom/obric/oui/window/interfaces/OnWindowConfigChangeListener;", "Lkotlin/collections/ArrayList;", "addListener", "", "listener", "changeScreenMode", "activity", "Landroid/app/Activity;", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "getBaseColumnWidth", "getCurrentNestedColumnWidth", "nestedPageGridConfig", "Lcom/obric/oui/window/bean/PageGridConfig;", "getCurrentPageSize", "getCurrentWindowSizeClass", "getHeightPair", "Lkotlin/Pair;", "initScreenSize", "context", "Landroid/content/Context;", "onWindowConfigChange", "removeListener", "setCurrentWindowSize", "decorViewWidth", "decorViewHeight", "forceUseDecorSize", "contains", "key", "pair", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdaptedWindowSize {
    private static final int FULL_SCREEN = 0;
    public static final AdaptedWindowSize INSTANCE = null;
    private static final int MULTI_WINDOW = 2;
    private static final int NO_SUPPORT = -1;
    private static final String TAG = "AdaptedWindowSize";
    private static boolean isHSplit;
    private static boolean isInMultiWindowMode;
    private static boolean isVSplit;
    private static float mBaseGridColumnWidth;
    private static volatile int mCurrentOrientation;
    private static AvailableWindowSize mCurrentPageSize;
    private static volatile WindowSizeClass mCurrentWindowSize;
    private static AvailableWindowSize mLastPageSize;
    private static int mScreenMode;
    private static boolean mWindowSizeInit;
    private static Set<Integer> sScreenSize;
    private static ArrayList<OnWindowConfigChangeListener> windowConfigChangeListenersList;

    private AdaptedWindowSize() {
    }

    static {
        INSTANCE = new AdaptedWindowSize();
        mCurrentWindowSize = WindowSizeClass.MINUS_ERROR_SIZE;
        mCurrentOrientation = 1;
        AvailableWindowSize r0 = new AvailableWindowSize(0.0f, 0.0f);
        mCurrentPageSize = r0;
        mLastPageSize = r0;
        mScreenMode = -1;
        sScreenSize = new LinkedHashSet();
        windowConfigChangeListenersList = new ArrayList();
    }

    public final int getMScreenMode() {
        return mScreenMode;
    }

    public final boolean isVSplit() {
        return isVSplit;
    }

    public final boolean isHSplit() {
        return isHSplit;
    }

    public final boolean isInMultiWindowMode() {
        if (mScreenMode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void addListener(OnWindowConfigChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        windowConfigChangeListenersList.add(r1);
    }

    public final void removeListener(OnWindowConfigChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        windowConfigChangeListenersList.remove(r1);
    }

    private final void initScreenSize(Context r2) {
        if ((!sScreenSize.isEmpty()) == false) goto L5;
        return;
    L5:
        WindowManager r1 = null;
        if (r2 != null) goto L8;
        Object r3 = null;
    L10:
        if ((r3 instanceof WindowManager) == false) goto L12;
        r1 = (WindowManager) r3;
    L12:
        if (r1 == null) goto L16;
        Point r4 = new Point();
        r1.getDefaultDisplay().getRealSize(r4);
        sScreenSize.add(Integer.valueOf(r4.x));
        sScreenSize.add(Integer.valueOf(r4.y));
        return;
    L16:
        return;
    L8:
        r3 = r2.getSystemService("window");
        goto L10
    }

    private final boolean contains(Set<Integer> r5, int r6, Pair<Integer, Integer> r7) {
        if (r5.contains(Integer.valueOf(r6)) == true) goto L24;
        Set<Integer> r8 = r5;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r1 = r8.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r4.add(Integer.valueOf((((Number) r1.next()).intValue() - r7.getSecond().intValue()) - r7.getFirst().intValue()));
        goto L6
    L9:
        if (r4.contains(Integer.valueOf(r6)) == true) goto L24;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r2 = r8.iterator();
    L12:
        if (r2.hasNext() == false) goto L15;
        r9.add(Integer.valueOf(((Number) r2.next()).intValue() - r7.getSecond().intValue()));
        goto L12
    L15:
        if (r9.contains(Integer.valueOf(r6)) == true) goto L24;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r11 = r8.iterator();
    L18:
        if (r11.hasNext() == false) goto L21;
        r10.add(Integer.valueOf(((Number) r11.next()).intValue() - r7.getFirst().intValue()));
        goto L18
    L21:
        if (r10.contains(Integer.valueOf(r6)) == true) goto L24;
        return false;
    L24:
        return true;
    }

    public final Pair<Integer, Integer> getHeightPair(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Resources r4 = r5.getResources();
        return new Pair(Integer.valueOf(r4.getDimensionPixelSize(r4.getIdentifier("status_bar_height", "dimen", "android"))), Integer.valueOf(r4.getDimensionPixelSize(r4.getIdentifier("navigation_bar_height", "dimen", "android"))));
    }

    public final void changeScreenMode(Activity r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        initScreenSize(r3);
        Pair<Integer, Integer> r0 = getHeightPair(r3);
        int r1 = 0;
        if (r3.isInMultiWindowMode() == true) goto L5;
        isVSplit = false;
        isHSplit = false;
    L13:
        mScreenMode = r1;
        return;
    L5:
        if (contains(sScreenSize, r4, r0) == false) goto L8;
        isVSplit = true;
        isHSplit = false;
    L11:
        r1 = 2;
        goto L13
    L8:
        if (contains(sScreenSize, r5, r0) == false) goto L10;
        isVSplit = false;
        isHSplit = true;
        goto L11
    L10:
        isVSplit = false;
        isHSplit = false;
        goto L11
    }

    public final void onWindowConfigChange() {
        Iterator<OnWindowConfigChangeListener> r4 = windowConfigChangeListenersList.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().onChange(new WindowSizeWithPageSize(mCurrentWindowSize, mCurrentPageSize));
        goto L4
    }

    public final WindowSizeClass setCurrentWindowSize(Activity r5, int r6, int r7, boolean r8) {
        if (r5 == null) goto L58;
        float r4 = Resources.getSystem().getDisplayMetrics().density;
        float r9 = r6 / r4;
        float r0 = r7 / r4;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setCurrentWindowSize: widthDP = " + r9 + ",heightDp = " + r0);
        mCurrentPageSize = new AvailableWindowSize(r9, r0);
        if (r9 >= WindowSizeClass.FLOATING_WINDOW.getDpSize()) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "error,can not be minus status!!");
        WindowSizeClass r10 = WindowSizeClass.MINUS_ERROR_SIZE;
    L44:
        if (mCurrentWindowSize == r10) goto L48;
        if (r10 == WindowSizeClass.MINUS_ERROR_SIZE) goto L48;
    L49:
        mCurrentWindowSize = r10;
        Resources r11 = r5.getResources();
        int r2 = 1;
        if (r11 == null) goto L56;
        Configuration r12 = r11.getConfiguration();
        if (r12 == null) goto L56;
        r2 = r12.orientation;
    L56:
        mCurrentOrientation = r2;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, Intrinsics.stringPlus("windowMsg = ", "当前档位：" + mCurrentWindowSize.getBaseGridConfig().getGridMode() + "\n当前页面可用宽高：" + r9 + ',' + r0 + "\ndecorViewWidth：" + r6 + "，decorVideHeight: " + r7 + "\nmultiWindowMode = " + r5.isInMultiWindowMode() + '\n'));
    L48:
        if (mCurrentOrientation == r5.getResources().getConfiguration().orientation) goto L58;
    L8:
        if (r9 < WindowSizeClass.FLOATING_WINDOW.getDpSize()) goto L13;
        if (r9 >= WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L13;
        r10 = WindowSizeClass.FLOATING_WINDOW;
    L13:
        if (r9 < WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L18;
        if (r9 >= WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L18;
        r10 = WindowSizeClass.SMALL_SPLIT_SCREEN;
    L18:
        if (r9 < WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L23;
        if (r9 >= WindowSizeClass.SMALL.getDpSize()) goto L23;
        r10 = WindowSizeClass.SMALLER_ANDROID_SCREEN;
    L23:
        if (r9 < WindowSizeClass.SMALL.getDpSize()) goto L28;
        if (r9 >= WindowSizeClass.STANDARD.getDpSize()) goto L28;
        r10 = WindowSizeClass.SMALL;
    L28:
        if (r9 < WindowSizeClass.STANDARD.getDpSize()) goto L33;
        if (r9 >= WindowSizeClass.NORMAL.getDpSize()) goto L33;
        r10 = WindowSizeClass.STANDARD;
    L33:
        if (r9 < WindowSizeClass.NORMAL.getDpSize()) goto L38;
        if (r9 >= WindowSizeClass.LARGE.getDpSize()) goto L38;
        r10 = WindowSizeClass.NORMAL;
    L38:
        if (r9 >= WindowSizeClass.LARGE.getDpSize()) goto L40;
    L42:
        r10 = WindowSizeClass.OVERSIZE;
        goto L44
    L40:
        if (r9 >= WindowSizeClass.OVERSIZE.getDpSize()) goto L42;
        r10 = WindowSizeClass.LARGE;
    L58:
        return mCurrentWindowSize;
    }

    public final WindowSizeClass getCurrentWindowSizeClass() {
        return mCurrentWindowSize;
    }

    public final AvailableWindowSize getCurrentPageSize() {
        return mCurrentPageSize;
    }

    public final float getBaseColumnWidth() {
        if (Intrinsics.areEqual(mLastPageSize, mCurrentPageSize) == true) goto L6;
        mLastPageSize = mCurrentPageSize;
        int r0 = mCurrentWindowSize.getBaseGridConfig().getPageMargin().getMarginDp();
        int r1 = mCurrentWindowSize.getBaseGridConfig().getPageColumns().getColumnNum();
        mBaseGridColumnWidth = ((getCurrentPageSize().getWidthInPx() - (r0 * 2)) - ((r1 - 1) * mCurrentWindowSize.getBaseGridConfig().getPageGutter().getGutterDp())) / r1;
    L6:
        return mBaseGridColumnWidth;
    }

    public final float getCurrentNestedColumnWidth(PageGridConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "nestedPageGridConfig");
        int r0 = r4.getPageColumns().getColumnNum();
        int r1 = r4.getPageGutter().getGutterDp();
        return (((getCurrentPageSize().getWidthInPx() - (mCurrentWindowSize.getBaseGridConfig().getPageMargin().getMarginDp() * 2)) - (r4.getPageMargin().getMarginDp() * 2)) - ((r0 - 1) * r1)) / r0;
    }
}
