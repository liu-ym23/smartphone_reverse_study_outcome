package com.gyf.barlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImmersionBar {
    private static final int BOUNDARY_COLOR = -4539718;
    private static final int FLAG_FITS_DEFAULT = 0;
    private static final int FLAG_FITS_STATUS = 3;
    private static final int FLAG_FITS_SYSTEM_WINDOWS = 4;
    private static final int FLAG_FITS_TITLE = 1;
    private static final int FLAG_FITS_TITLE_MARGIN_TOP = 2;
    private static final int IMMERSION_NAVIGATION_BAR_VIEW = 0;
    private static final int IMMERSION_STATUS_BAR_VIEW = 0;
    private static final String MIUI_NAVIGATION_BAR_DARK = "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE";
    private static final String MIUI_STATUS_BAR_DARK = "EXTRA_FLAG_STATUS_BAR_DARK_MODE";
    private static final String NAVIGATIONBAR_IS_MIN = "navigationbar_is_min";
    private static Map<String, ImmersionBar> mImmersionBarMap;
    private Activity mActivity;
    private BarConfig mBarConfig;
    private BarParams mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private FitsKeyboard mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mHasNavigationBarColor;
    private String mImmersionBarName;
    private boolean mIsFitsLayoutOverlap;
    private boolean mIsFitsNotch;
    private boolean mIsFragment;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private ContentObserver mNavigationObserver;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Map<String, BarParams> mTagMap;
    private Window mWindow;

    /* JADX INFO: renamed from: com.gyf.barlibrary.ImmersionBar$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$gyf$barlibrary$BarHide = null;

        static {
            int[] r0 = new int[BarHide.values().length];
            $SwitchMap$com$gyf$barlibrary$BarHide = r0;
            r0[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static /* synthetic */ BarConfig access$000(ImmersionBar r0) {
        return r0.mBarConfig;
    }

    static /* synthetic */ BarConfig access$002(ImmersionBar r0, BarConfig r1) {
        r0.mBarConfig = r1;
        return r1;
    }

    static /* synthetic */ Activity access$100(ImmersionBar r0) {
        return r0.mActivity;
    }

    static /* synthetic */ ViewGroup access$200(ImmersionBar r0) {
        return r0.mContentView;
    }

    static /* synthetic */ ViewGroup access$300(ImmersionBar r0) {
        return r0.mDecorView;
    }

    static /* synthetic */ int access$400(ImmersionBar r0) {
        return r0.mNavigationBarHeight;
    }

    static /* synthetic */ int access$402(ImmersionBar r0, int r1) {
        r0.mNavigationBarHeight = r1;
        return r1;
    }

    static /* synthetic */ int access$500(ImmersionBar r0) {
        return r0.mNavigationBarWidth;
    }

    static /* synthetic */ int access$502(ImmersionBar r0, int r1) {
        r0.mNavigationBarWidth = r1;
        return r1;
    }

    static /* synthetic */ BarParams access$600(ImmersionBar r0) {
        return r0.mBarParams;
    }

    static /* synthetic */ void access$700(ImmersionBar r0, int r1, int r2, int r3, int r4) {
        r0.setPadding(r1, r2, r3, r4);
    }

    static {
        IMMERSION_STATUS_BAR_VIEW = R.id.immersion_status_bar_view;
        IMMERSION_NAVIGATION_BAR_VIEW = R.id.immersion_navigation_bar_view;
        mImmersionBarMap = new HashMap();
    }

    private ImmersionBar(Activity r3) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = r3;
        this.mWindow = r3.getWindow();
        this.mImmersionBarName = this.mActivity.toString();
        this.mBarParams = new BarParams();
        ViewGroup r4 = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = r4;
        this.mContentView = (ViewGroup) r4.findViewById(android.R.id.content);
    }

    private ImmersionBar(Fragment r2) {
        this(r2.getActivity(), r2);
    }

    private ImmersionBar(Activity r3, Fragment r4) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = r3;
        this.mFragment = r4;
        if (r3 == null) goto L11;
        if (mImmersionBarMap.get(r3.toString()) == null) goto L9;
        this.mIsFragment = true;
        this.mWindow = this.mActivity.getWindow();
        this.mImmersionBarName = r3.toString() + r4.toString();
        initParams();
        return;
    L9:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L11:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    private ImmersionBar(DialogFragment r2) {
        this(r2, r2.getDialog());
    }

    private ImmersionBar(DialogFragment r3, Dialog r4) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        FragmentActivity r0 = r3.getActivity();
        this.mActivity = r0;
        this.mFragment = r3;
        this.mDialog = r4;
        if (r0 == null) goto L14;
        if (r4 == null) goto L12;
        if (mImmersionBarMap.get(r0.toString()) == null) goto L10;
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = this.mActivity.toString() + r3.toString();
        initParams();
        return;
    L10:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L12:
        throw new IllegalArgumentException("dialog in DialogFragment cannot be null");
    L14:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    private ImmersionBar(Activity r2, Dialog r3) {
        this(r2, r3, "");
    }

    private ImmersionBar(Activity r3, Dialog r4, String r5) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = r3;
        this.mDialog = r4;
        if (r3 == null) goto L14;
        if (r4 == null) goto L12;
        if (mImmersionBarMap.get(r3.toString()) == null) goto L10;
        this.mWindow = this.mDialog.getWindow();
        this.mImmersionBarName = r3.toString() + r4.toString() + r5;
        initParams();
        return;
    L10:
        throw new IllegalArgumentException("you should initialize ImmersionBar in Activity first if used in Fragment");
    L12:
        throw new IllegalArgumentException("dialog cannot be null");
    L14:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    private void initParams() {
        this.mBarParams = new BarParams();
        ViewGroup r0 = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = r0;
        this.mContentView = (ViewGroup) r0.findViewById(android.R.id.content);
    }

    public static ImmersionBar with(Activity r2) {
        ImmersionBar r0 = mImmersionBarMap.get(r2.toString());
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r2);
        mImmersionBarMap.put(r2.toString(), r1);
        return r1;
    L6:
        return r0;
    }

    public static ImmersionBar with(Fragment r4) {
        if (r4.getActivity() == null) goto L9;
        ImmersionBar r0 = mImmersionBarMap.get(r4.getActivity().toString() + r4.toString());
        if (r0 != null) goto L10;
        ImmersionBar r1 = new ImmersionBar(r4);
        mImmersionBarMap.put(r4.getActivity().toString() + r4.toString(), r1);
        return r1;
    L10:
        return r0;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public static ImmersionBar with(Activity r3, Fragment r4) {
        ImmersionBar r0 = mImmersionBarMap.get(r3.toString() + r4.toString());
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r3, r4);
        mImmersionBarMap.put(r3.toString() + r4.toString(), r1);
        return r1;
    L6:
        return r0;
    }

    public static ImmersionBar with(DialogFragment r4) {
        if (r4.getActivity() == null) goto L9;
        ImmersionBar r0 = mImmersionBarMap.get(r4.getActivity().toString() + r4.toString());
        if (r0 != null) goto L10;
        ImmersionBar r1 = new ImmersionBar(r4);
        mImmersionBarMap.put(r4.getActivity().toString() + r4.toString(), r1);
        return r1;
    L10:
        return r0;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    @Deprecated
    public static ImmersionBar with(DialogFragment r3, Dialog r4) {
        if (r3.getActivity() == null) goto L9;
        ImmersionBar r0 = mImmersionBarMap.get(r3.getActivity().toString() + r3.toString());
        if (r0 != null) goto L10;
        ImmersionBar r1 = new ImmersionBar(r3, r4);
        mImmersionBarMap.put(r3.getActivity().toString() + r3.toString(), r1);
        return r1;
    L10:
        return r0;
    L9:
        throw new IllegalArgumentException("Activity cannot be null!!!");
    }

    public static ImmersionBar with(Activity r3, Dialog r4) {
        ImmersionBar r0 = mImmersionBarMap.get(r3.toString() + r4.toString());
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r3, r4);
        mImmersionBarMap.put(r3.toString() + r4.toString(), r1);
        return r1;
    L6:
        return r0;
    }

    @Deprecated
    public static ImmersionBar with(Activity r3, Dialog r4, String r5) {
        ImmersionBar r0 = mImmersionBarMap.get(r3.toString() + r4.toString() + r5);
        if (r0 != null) goto L6;
        ImmersionBar r1 = new ImmersionBar(r3, r4, r5);
        mImmersionBarMap.put(r3.toString() + r4.toString() + r5, r1);
        return r1;
    L6:
        return r0;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        this.mBarParams.navigationBarColor = 0;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentBar() {
        this.mBarParams.statusBarColor = 0;
        this.mBarParams.navigationBarColor = 0;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.fullScreen = true;
        return this;
    }

    public ImmersionBar statusBarColor(int r2) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar statusBarColor(int r2, float r3) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r2), r3);
    }

    public ImmersionBar statusBarColor(int r2, int r3, float r4) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, r2), ContextCompat.getColor(this.mActivity, r3), r4);
    }

    public ImmersionBar statusBarColor(String r1) {
        return statusBarColorInt(Color.parseColor(r1));
    }

    public ImmersionBar statusBarColor(String r1, float r2) {
        return statusBarColorInt(Color.parseColor(r1), r2);
    }

    public ImmersionBar statusBarColor(String r1, String r2, float r3) {
        return statusBarColorInt(Color.parseColor(r1), Color.parseColor(r2), r3);
    }

    public ImmersionBar statusBarColorInt(int r2) {
        this.mBarParams.statusBarColor = r2;
        return this;
    }

    public ImmersionBar statusBarColorInt(int r2, float r3) {
        this.mBarParams.statusBarColor = r2;
        this.mBarParams.statusBarAlpha = r3;
        return this;
    }

    public ImmersionBar statusBarColorInt(int r2, int r3, float r4) {
        this.mBarParams.statusBarColor = r2;
        this.mBarParams.statusBarColorTransform = r3;
        this.mBarParams.statusBarAlpha = r4;
        return this;
    }

    public ImmersionBar navigationBarColor(int r2) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar navigationBarColor(int r2, float r3) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r2), r3);
    }

    public ImmersionBar navigationBarColor(int r2, int r3, float r4) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, r2), ContextCompat.getColor(this.mActivity, r3), r4);
    }

    public ImmersionBar navigationBarColor(String r1) {
        return navigationBarColorInt(Color.parseColor(r1));
    }

    public ImmersionBar navigationBarColor(String r1, float r2) {
        return navigationBarColorInt(Color.parseColor(r1), r2);
    }

    public ImmersionBar navigationBarColor(String r1, String r2, float r3) {
        return navigationBarColorInt(Color.parseColor(r1), Color.parseColor(r2), r3);
    }

    public ImmersionBar navigationBarColorInt(int r2) {
        this.mBarParams.navigationBarColor = r2;
        this.mBarParams.useDefaultNavigationBarColor = false;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int r2, float r3) {
        this.mBarParams.navigationBarColor = r2;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.navigationBarAlpha = r3;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int r2, int r3, float r4) {
        this.mBarParams.navigationBarColor = r2;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.navigationBarColorTransform = r3;
        this.mBarParams.navigationBarAlpha = r4;
        return this;
    }

    public ImmersionBar barColor(int r2) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar barColor(int r1, float r2) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r1), r1);
    }

    public ImmersionBar barColor(int r2, int r3, float r4) {
        return barColorInt(ContextCompat.getColor(this.mActivity, r2), ContextCompat.getColor(this.mActivity, r3), r4);
    }

    public ImmersionBar barColor(String r1) {
        return barColorInt(Color.parseColor(r1));
    }

    public ImmersionBar barColor(String r1, float r2) {
        return barColorInt(Color.parseColor(r1), r2);
    }

    public ImmersionBar barColor(String r1, String r2, float r3) {
        return barColorInt(Color.parseColor(r1), Color.parseColor(r2), r3);
    }

    public ImmersionBar barColorInt(int r2) {
        this.mBarParams.statusBarColor = r2;
        this.mBarParams.navigationBarColor = r2;
        this.mBarParams.useDefaultNavigationBarColor = false;
        return this;
    }

    public ImmersionBar barColorInt(int r2, float r3) {
        this.mBarParams.statusBarColor = r2;
        this.mBarParams.navigationBarColor = r2;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.statusBarAlpha = r3;
        this.mBarParams.navigationBarAlpha = r3;
        return this;
    }

    public ImmersionBar barColorInt(int r2, int r3, float r4) {
        this.mBarParams.statusBarColor = r2;
        this.mBarParams.navigationBarColor = r2;
        this.mBarParams.useDefaultNavigationBarColor = false;
        this.mBarParams.statusBarColorTransform = r3;
        this.mBarParams.navigationBarColorTransform = r3;
        this.mBarParams.statusBarAlpha = r4;
        this.mBarParams.navigationBarAlpha = r4;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int r2) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar statusBarColorTransform(String r1) {
        return statusBarColorTransformInt(Color.parseColor(r1));
    }

    public ImmersionBar statusBarColorTransformInt(int r2) {
        this.mBarParams.statusBarColorTransform = r2;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int r2) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar navigationBarColorTransform(String r1) {
        return navigationBarColorTransformInt(Color.parseColor(r1));
    }

    public ImmersionBar navigationBarColorTransformInt(int r2) {
        this.mBarParams.navigationBarColorTransform = r2;
        return this;
    }

    public ImmersionBar barColorTransform(int r2) {
        return barColorTransformInt(ContextCompat.getColor(this.mActivity, r2));
    }

    public ImmersionBar barColorTransform(String r1) {
        return barColorTransformInt(Color.parseColor(r1));
    }

    public ImmersionBar barColorTransformInt(int r2) {
        this.mBarParams.statusBarColorTransform = r2;
        this.mBarParams.navigationBarColorTransform = r2;
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View r2) {
        return addViewSupportTransformColorInt(r2, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColor(View r2, int r3) {
        return addViewSupportTransformColorInt(r2, ContextCompat.getColor(this.mActivity, r3));
    }

    public ImmersionBar addViewSupportTransformColor(View r2, int r3, int r4) {
        return addViewSupportTransformColorInt(r2, ContextCompat.getColor(this.mActivity, r3), ContextCompat.getColor(this.mActivity, r4));
    }

    public ImmersionBar addViewSupportTransformColor(View r1, String r2) {
        return addViewSupportTransformColorInt(r1, Color.parseColor(r2));
    }

    public ImmersionBar addViewSupportTransformColor(View r1, String r2, String r3) {
        return addViewSupportTransformColorInt(r1, Color.parseColor(r2), Color.parseColor(r3));
    }

    public ImmersionBar addViewSupportTransformColorInt(View r3, int r4) {
        if (r3 == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(r4));
        this.mBarParams.viewMap.put(r3, r0);
        return this;
    L6:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar addViewSupportTransformColorInt(View r2, int r3, int r4) {
        if (r2 == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put(Integer.valueOf(r3), Integer.valueOf(r4));
        this.mBarParams.viewMap.put(r2, r0);
        return this;
    L6:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar viewAlpha(float r2) {
        this.mBarParams.viewAlpha = r2;
        return this;
    }

    public ImmersionBar removeSupportView(View r2) {
        if (r2 == null) goto L10;
        Map<Integer, Integer> r0 = this.mBarParams.viewMap.get(r2);
        if (r0 != null) goto L6;
    L8:
        return this;
    L6:
        if (r0.size() == 0) goto L8;
        this.mBarParams.viewMap.remove(r2);
        goto L8
    L10:
        throw new IllegalArgumentException("view cannot be null");
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() == 0) goto L5;
        this.mBarParams.viewMap.clear();
    L5:
        return this;
    }

    public ImmersionBar fullScreen(boolean r2) {
        this.mBarParams.fullScreen = r2;
        return this;
    }

    public ImmersionBar statusBarAlpha(float r2) {
        this.mBarParams.statusBarAlpha = r2;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float r2) {
        this.mBarParams.navigationBarAlpha = r2;
        return this;
    }

    public ImmersionBar barAlpha(float r2) {
        this.mBarParams.statusBarAlpha = r2;
        this.mBarParams.navigationBarAlpha = r2;
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean r2) {
        return autoDarkModeEnable(r2, 0.2f);
    }

    public ImmersionBar autoDarkModeEnable(boolean r2, float r3) {
        this.mBarParams.autoStatusBarDarkModeEnable = r2;
        this.mBarParams.autoStatusBarDarkModeAlpha = r3;
        this.mBarParams.autoNavigationBarDarkModeEnable = r2;
        this.mBarParams.autoNavigationBarDarkModeAlpha = r3;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean r2) {
        return autoStatusBarDarkModeEnable(r2, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean r2, float r3) {
        this.mBarParams.autoStatusBarDarkModeEnable = r2;
        this.mBarParams.autoStatusBarDarkModeAlpha = r3;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean r2) {
        return autoNavigationBarDarkModeEnable(r2, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean r2, float r3) {
        this.mBarParams.autoNavigationBarDarkModeEnable = r2;
        this.mBarParams.autoNavigationBarDarkModeAlpha = r3;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean r2) {
        return statusBarDarkFont(r2, 0.2f);
    }

    public ImmersionBar statusBarDarkFont(boolean r2, float r3) {
        this.mBarParams.statusBarDarkFont = r2;
        if (r2 == true) goto L5;
    L7:
        this.mBarParams.flymeOSStatusBarFontColor = 0;
        this.mBarParams.statusBarAlpha = 0.0f;
    L8:
        return this;
    L5:
        if (isSupportStatusBarDarkFont() == true) goto L7;
        this.mBarParams.statusBarAlpha = r3;
        goto L8
    }

    public ImmersionBar navigationBarDarkIcon(boolean r2) {
        return navigationBarDarkIcon(r2, 0.2f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean r2, float r3) {
        this.mBarParams.navigationBarDarkIcon = r2;
        if (r2 == true) goto L5;
    L7:
        this.mBarParams.navigationBarAlpha = 0.0f;
    L8:
        return this;
    L5:
        if (isSupportNavigationIconDark() == true) goto L7;
        this.mBarParams.navigationBarAlpha = r3;
        goto L8
    }

    public ImmersionBar flymeOSStatusBarFontColor(int r3) {
        BarParams r0 = this.mBarParams;
        r0.flymeOSStatusBarFontColor = ContextCompat.getColor(this.mActivity, r3);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String r2) {
        BarParams r0 = this.mBarParams;
        r0.flymeOSStatusBarFontColor = Color.parseColor(r2);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int r2) {
        this.mBarParams.flymeOSStatusBarFontColor = r2;
        return this;
    }

    public ImmersionBar hideBar(BarHide r3) {
        this.mBarParams.barHide = r3;
        if (OSUtils.isEMUI3_x() == false) goto L11;
        this.mBarParams.useDefaultNavigationBarColor = false;
        if (this.mBarParams.barHide != BarHide.FLAG_HIDE_NAVIGATION_BAR) goto L7;
    L10:
        this.mBarParams.hideNavigationBar = true;
        goto L11
    L7:
        if (this.mBarParams.barHide == BarHide.FLAG_HIDE_BAR) goto L10;
        this.mBarParams.hideNavigationBar = false;
    L11:
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean r2) {
        this.mBarParams.fits = r2;
        if (this.mBarParams.fits == true) goto L5;
        this.mFitsStatusBarType = 0;
    L8:
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L8;
        this.mFitsStatusBarType = 4;
        goto L8
    }

    public ImmersionBar fitsSystemWindows(boolean r2, int r3) {
        return fitsSystemWindowsInt(r2, ContextCompat.getColor(this.mActivity, r3));
    }

    public ImmersionBar fitsSystemWindows(boolean r2, int r3, int r4, float r5) {
        return fitsSystemWindowsInt(r2, ContextCompat.getColor(this.mActivity, r3), ContextCompat.getColor(this.mActivity, r4), r5);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean r3, int r4) {
        return fitsSystemWindowsInt(r3, r4, -16777216, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean r2, int r3, int r4, float r5) {
        this.mBarParams.fits = r2;
        this.mBarParams.contentColor = r3;
        this.mBarParams.contentColorTransform = r4;
        this.mBarParams.contentAlpha = r5;
        if (this.mBarParams.fits == true) goto L5;
        this.mFitsStatusBarType = 0;
    L8:
        this.mContentView.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.contentColor, this.mBarParams.contentColorTransform, this.mBarParams.contentAlpha));
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L8;
        this.mFitsStatusBarType = 4;
        goto L8
    }

    public ImmersionBar statusBarView(View r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        this.mBarParams.statusBarView = r2;
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 3;
    L7:
        return this;
    }

    public ImmersionBar statusBarView(int r2) {
        return statusBarView(this.mActivity.findViewById(r2));
    }

    public ImmersionBar statusBarView(int r1, View r2) {
        return statusBarView(r2.findViewById(r1));
    }

    public ImmersionBar supportActionBar(boolean r2) {
        this.mBarParams.isSupportActionBar = r2;
        return this;
    }

    public ImmersionBar titleBar(View r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return titleBar(r2, true);
    }

    public ImmersionBar titleBar(View r2, boolean r3) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 1;
    L7:
        this.mBarParams.titleBarView = r2;
        this.mBarParams.statusBarColorEnabled = r3;
        return this;
    }

    public ImmersionBar titleBar(int r2) {
        return titleBar(r2, true);
    }

    public ImmersionBar titleBar(int r2, boolean r3) {
        Fragment r0 = this.mFragment;
        if (r0 == null) goto L9;
        if (r0.getView() == null) goto L9;
        return titleBar(this.mFragment.getView().findViewById(r2), r3);
    L9:
        return titleBar(this.mActivity.findViewById(r2), r3);
    }

    public ImmersionBar titleBar(int r1, View r2) {
        return titleBar(r2.findViewById(r1), true);
    }

    public ImmersionBar titleBar(int r1, View r2, boolean r3) {
        return titleBar(r2.findViewById(r1), r3);
    }

    public ImmersionBar titleBarMarginTop(int r2) {
        Fragment r0 = this.mFragment;
        if (r0 == null) goto L9;
        if (r0.getView() == null) goto L9;
        return titleBarMarginTop(this.mFragment.getView().findViewById(r2));
    L9:
        return titleBarMarginTop(this.mActivity.findViewById(r2));
    }

    public ImmersionBar titleBarMarginTop(int r1, View r2) {
        return titleBarMarginTop(r2.findViewById(r1));
    }

    public ImmersionBar titleBarMarginTop(View r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.mFitsStatusBarType != 0) goto L7;
        this.mFitsStatusBarType = 2;
    L7:
        this.mBarParams.titleBarView = r2;
        return this;
    }

    public ImmersionBar statusBarColorTransformEnable(boolean r2) {
        this.mBarParams.statusBarColorEnabled = r2;
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public ImmersionBar addTag(String r3) {
        if (isEmpty(r3) == true) goto L7;
        BarParams r0 = this.mBarParams.clone();
        this.mTagMap.put(r3, r0);
        return this;
    L7:
        throw new IllegalArgumentException("tag cannot be null");
    }

    public ImmersionBar getTag(String r2) {
        if (isEmpty(r2) == true) goto L9;
        BarParams r3 = this.mTagMap.get(r2);
        if (r3 == null) goto L7;
        this.mBarParams = r3.clone();
    L7:
        return this;
    L9:
        throw new IllegalArgumentException("tag cannot be null");
    }

    public ImmersionBar keyboardEnable(boolean r2) {
        return keyboardEnable(r2, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardEnable(boolean r2, int r3) {
        this.mBarParams.keyboardEnable = r2;
        this.mBarParams.keyboardMode = r3;
        return this;
    }

    public ImmersionBar keyboardMode(int r2) {
        this.mBarParams.keyboardMode = r2;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener r2) {
        if (this.mBarParams.onKeyboardListener != null) goto L5;
        this.mBarParams.onKeyboardListener = r2;
    L5:
        return this;
    }

    public ImmersionBar navigationBarEnable(boolean r2) {
        this.mBarParams.navigationBarEnable = r2;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean r2) {
        this.mBarParams.navigationBarWithKitkatEnable = r2;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean r2) {
        this.mBarParams.navigationBarWithEMUI3Enable = r2;
        return this;
    }

    @Deprecated
    public ImmersionBar fixMarginAtBottom(boolean r2) {
        this.mBarParams.fixMarginAtBottom = r2;
        return this;
    }

    public void init() {
        updateBarParams();
        setBar();
        fitsLayoutOverlap();
        fitsKeyboard();
        transformView();
    }

    public void destroy() {
        cancelListener();
        Iterator<Map.Entry<String, ImmersionBar>> r0 = mImmersionBarMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<String, ImmersionBar> r1 = r0.next();
        if (r1.getKey().contains(this.mImmersionBarName) == true) goto L9;
        if (r1.getKey().equals(this.mImmersionBarName) == false) goto L4;
    L9:
        r0.remove();
        goto L4
    }

    private void updateBarParams() {
        adjustDarkModeParams();
        if (OSUtils.isEMUI3_x() == true) goto L5;
    L7:
        this.mBarConfig = new BarConfig(this.mActivity);
        if (this.mIsFragment == false) goto L13;
        ImmersionBar r0 = mImmersionBarMap.get(this.mActivity.toString());
        if (r0 == null) goto L14;
        r0.mBarParams = this.mBarParams;
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (this.mBarParams.navigationBarWithKitkatEnable == false) goto L7;
        BarParams r1 = this.mBarParams;
        r1.navigationBarWithKitkatEnable = r1.navigationBarWithEMUI3Enable;
        goto L7
    }

    private void setBar() {
        checkNavigationBarInitialized();
        int r1 = 256;
        if (OSUtils.isEMUI3_x() == true) goto L5;
        fitsNotchScreen();
        int r0 = setStatusBarDarkFont(initBarAboveLOLLIPOP(256));
        checkNavigationBarFlag();
        r1 = setNavigationIconDark(r0);
    L6:
        int r2 = hideBar(r1);
        fitsWindows();
        this.mDecorView.setSystemUiVisibility(r2);
        if (OSUtils.isMIUI6Later() == false) goto L12;
        setMIUIBarDark(this.mWindow, MIUI_STATUS_BAR_DARK, this.mBarParams.statusBarDarkFont);
        if (this.mBarParams.navigationBarEnable == false) goto L12;
        setMIUIBarDark(this.mWindow, MIUI_NAVIGATION_BAR_DARK, this.mBarParams.navigationBarDarkIcon);
    L12:
        if (OSUtils.isFlymeOS4Later() == true) goto L14;
        return;
    L14:
        if (this.mBarParams.flymeOSStatusBarFontColor == 0) goto L16;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.flymeOSStatusBarFontColor);
        return;
    L16:
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.statusBarDarkFont);
        return;
    L5:
        initBarBelowLOLLIPOP();
        goto L6
    }

    private void fitsNotchScreen() {
        if (this.mIsFitsNotch == true) goto L6;
        WindowManager.LayoutParams r0 = this.mWindow.getAttributes();
        r0.layoutInDisplayCutoutMode = 1;
        this.mWindow.setAttributes(r0);
        this.mIsFitsNotch = true;
        return;
    }

    private void checkNavigationBarInitialized() {
        if (this.mBarParams.useDefaultNavigationBarColor == false) goto L6;
        this.mBarParams.navigationBarColor = this.mWindow.getNavigationBarColor();
        return;
    }

    private void checkNavigationBarFlag() {
        if (this.mBarParams.useDefaultNavigationBarColor == false) goto L10;
        BarParams r0 = this.mBarParams;
        if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) == 0) goto L7;
        boolean r1 = true;
    L8:
        r0.navigationBarDarkIcon = r1;
        return;
    L7:
        r1 = false;
        goto L8
    }

    private int initBarAboveLOLLIPOP(int r5) {
        if (this.mHasNavigationBarColor == true) goto L5;
        BarParams r0 = this.mBarParams;
        r0.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
        this.mHasNavigationBarColor = true;
    L5:
        int r6 = r5 | 1024;
        if (this.mBarParams.fullScreen == true) goto L8;
    L10:
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar() == false) goto L13;
        this.mWindow.clearFlags(134217728);
    L13:
        this.mWindow.addFlags(Integer.MIN_VALUE);
        if (this.mBarParams.statusBarColorEnabled == false) goto L16;
        this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
    L18:
        if (this.mBarParams.navigationBarEnable == false) goto L20;
        this.mWindow.setNavigationBarColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
    L21:
        return r6;
    L20:
        this.mWindow.setNavigationBarColor(this.mBarParams.defaultNavigationBarColor);
        goto L21
    L16:
        this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
        goto L18
    L8:
        if (this.mBarParams.navigationBarEnable == false) goto L10;
        r6 = r6 | 512;
        goto L10
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() == true) goto L7;
        if (OSUtils.isEMUI3_x() == true) goto L7;
        return;
    L7:
        if (this.mBarParams.navigationBarEnable == true) goto L9;
    L11:
        this.mWindow.clearFlags(134217728);
    L13:
        if (this.mNavigationBarHeight != 0) goto L16;
        this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
    L16:
        if (this.mNavigationBarWidth != 0) goto L18;
        this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
    L18:
        setupNavBarView();
        return;
    L9:
        if (this.mBarParams.navigationBarWithKitkatEnable == false) goto L11;
        this.mWindow.addFlags(134217728);
        goto L13
    }

    private void setupStatusBarView() {
        ViewGroup r0 = this.mDecorView;
        int r1 = IMMERSION_STATUS_BAR_VIEW;
        View r2 = r0.findViewById(r1);
        if (r2 != null) goto L6;
        r2 = new View(this.mActivity);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
        r3.gravity = 48;
        r2.setLayoutParams(r3);
        r2.setVisibility(0);
        r2.setId(r1);
        this.mDecorView.addView(r2);
    L6:
        if (this.mBarParams.statusBarColorEnabled == false) goto L8;
        r2.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
        return;
    L8:
        r2.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
    }

    private void setupNavBarView() {
        ViewGroup r0 = this.mDecorView;
        int r1 = IMMERSION_NAVIGATION_BAR_VIEW;
        View r2 = r0.findViewById(r1);
        if (r2 != null) goto L6;
        r2 = new View(this.mActivity);
        r2.setId(r1);
        this.mDecorView.addView(r2);
    L6:
        if (this.mBarConfig.isNavigationAtBottom() == false) goto L8;
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
        r3.gravity = 80;
    L9:
        r2.setLayoutParams(r3);
        r2.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
        if (this.mBarParams.navigationBarEnable == true) goto L12;
    L16:
        r2.setVisibility(8);
        return;
    L12:
        if (this.mBarParams.navigationBarWithKitkatEnable == false) goto L16;
        if (this.mBarParams.hideNavigationBar == true) goto L16;
        r2.setVisibility(0);
        return;
    L8:
        r3 = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
        r3.gravity = GravityCompat.END;
        goto L9
    }

    private void adjustDarkModeParams() {
        boolean r1 = true;
        if (this.mBarParams.autoStatusBarDarkModeEnable == false) goto L12;
        if (this.mBarParams.statusBarColor != 0) goto L7;
    L9:
        boolean r0 = false;
    L10:
        statusBarDarkFont(r0, this.mBarParams.autoStatusBarDarkModeAlpha);
        goto L12
    L7:
        if (this.mBarParams.statusBarColor <= BOUNDARY_COLOR) goto L9;
        r0 = true;
    L12:
        if (this.mBarParams.autoNavigationBarDarkModeEnable == true) goto L14;
        return;
    L14:
        if (this.mBarParams.navigationBarColor != 0) goto L16;
    L18:
        r1 = false;
    L19:
        navigationBarDarkIcon(r1, this.mBarParams.autoNavigationBarDarkModeAlpha);
        return;
    L16:
        if (this.mBarParams.navigationBarColor <= BOUNDARY_COLOR) goto L18;
        goto L18
    }

    private int hideBar(int r2) {
        int r1 = AnonymousClass3.$SwitchMap$com$gyf$barlibrary$BarHide[this.mBarParams.barHide.ordinal()];
        if (r1 != 1) goto L5;
        r2 = r2 | 518;
    L16:
        return r2 | 4096;
    L5:
        if (r1 != 2) goto L7;
        r2 = r2 | 1028;
        goto L16
    L7:
        if (r1 != 3) goto L9;
        r2 = r2 | 514;
        goto L16
    L9:
        if (r1 != 4) goto L16;
        r2 = r2 | 0;
        goto L16
    }

    private void fitsWindows() {
        if (OSUtils.isEMUI3_x() == true) goto L5;
        fitsWindowsAboveLOLLIPOP();
        return;
    L5:
        fitsWindowsBelowLOLLIPOP();
        if (this.mIsFragment == false) goto L8;
        return;
    L8:
        if (OSUtils.isEMUI3_x() == false) goto L13;
        fitsWindowsEMUI();
        return;
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content)) == false) goto L9;
        if (this.mBarParams.isSupportActionBar == false) goto L19;
        setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
        return;
    L19:
        return;
    L9:
        if (this.mBarParams.fits == true) goto L11;
    L13:
        int r0 = 0;
    L15:
        if (this.mBarParams.isSupportActionBar == false) goto L17;
        r0 = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
    L17:
        setPadding(0, r0, 0, 0);
        return;
    L11:
        if (this.mFitsStatusBarType != 4) goto L13;
        r0 = this.mBarConfig.getStatusBarHeight();
        goto L15
    }

    private void fitsWindowsBelowLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content)) == false) goto L9;
        if (this.mBarParams.isSupportActionBar == false) goto L42;
        setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
        return;
    L42:
        return;
    L9:
        if (this.mBarParams.fits == true) goto L11;
    L13:
        int r0 = 0;
    L15:
        if (this.mBarParams.isSupportActionBar == false) goto L18;
        r0 = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
    L18:
        if (this.mBarConfig.hasNavigationBar() == true) goto L20;
    L39:
        int r2 = 0;
        int r3 = 0;
    L40:
        setPadding(0, r0, r2, r3);
        return;
    L20:
        if (this.mBarParams.navigationBarEnable == false) goto L39;
        if (this.mBarParams.navigationBarWithKitkatEnable == false) goto L39;
        if (this.mBarParams.fullScreen == false) goto L26;
        r2 = 0;
        r3 = 0;
    L31:
        if (this.mBarParams.hideNavigationBar == false) goto L37;
        if (this.mBarConfig.isNavigationAtBottom() == false) goto L35;
        r3 = 0;
        goto L40
    L35:
        r2 = 0;
        goto L40
    L37:
        if (this.mBarConfig.isNavigationAtBottom() == true) goto L40;
        r2 = this.mBarConfig.getNavigationBarWidth();
        goto L40
    L26:
        if (this.mBarConfig.isNavigationAtBottom() == false) goto L28;
        r3 = this.mBarConfig.getNavigationBarHeight();
        r2 = 0;
        goto L31
    L28:
        r2 = this.mBarConfig.getNavigationBarWidth();
        r3 = 0;
        goto L31
    L11:
        if (this.mFitsStatusBarType != 4) goto L13;
        r0 = this.mBarConfig.getStatusBarHeight();
        goto L15
    }

    private void fitsWindowsEMUI() {
        final View r0 = this.mDecorView.findViewById(IMMERSION_NAVIGATION_BAR_VIEW);
        if (this.mBarParams.navigationBarEnable == true) goto L5;
    L16:
        r0.setVisibility(8);
        return;
    L5:
        if (this.mBarParams.navigationBarWithKitkatEnable == false) goto L16;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.mNavigationObserver != null) goto L19;
        final Handler r2 = new Handler();
        this.mNavigationObserver = new AnonymousClass1(this, r2, r0);
        Activity r1 = this.mActivity;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.getContentResolver() != null) goto L14;
        return;
    L14:
        if (this.mNavigationObserver == null) goto L22;
        this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor(NAVIGATIONBAR_IS_MIN), true, this.mNavigationObserver);
        return;
    L22:
        return;
    }

    private int setStatusBarDarkFont(int r1) {
        if (this.mBarParams.statusBarDarkFont == true) goto L5;
        return r1;
    L5:
        return r1 | 8192;
    }

    private int setNavigationIconDark(int r1) {
        if (this.mBarParams.navigationBarDarkIcon == true) goto L5;
        return r1;
    L5:
        return r1 | 16;
    }

    private void setMIUIBarDark(Window r7, String r8, boolean r9) {
        if (r7 == null) goto L13;
        Class<?> r6 = r7.getClass();
        Class<?> r0 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Exception -> L9
        int r10 = r0.getField(r8).getInt(r0);     // Catch: Exception -> L9
        Method r11 = r6.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L9
        if (r9 == false) goto L7;
        r11.invoke(r7, new Object[]{Integer.valueOf(r10), Integer.valueOf(r10)});     // Catch: Exception -> L9
    L10:
        return;
    L7:
        r11.invoke(r7, new Object[]{0, Integer.valueOf(r10)});     // Catch: Exception -> L9
    L14:
        return;
    }

    private void fitsLayoutOverlap() {
        if (this.mIsFitsLayoutOverlap == true) goto L15;
        int r0 = this.mFitsStatusBarType;
        if (r0 != 1) goto L7;
        setTitleBar(this.mActivity, this.mBarParams.titleBarView);
        this.mIsFitsLayoutOverlap = true;
        return;
    L7:
        if (r0 != 2) goto L9;
        setTitleBarMarginTop(this.mActivity, this.mBarParams.titleBarView);
        this.mIsFitsLayoutOverlap = true;
        return;
    L9:
        if (r0 != 3) goto L18;
        setStatusBarView(this.mActivity, this.mBarParams.statusBarView);
        this.mIsFitsLayoutOverlap = true;
        return;
    L18:
        return;
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() == 0) goto L16;
        Iterator<Map.Entry<View, Map<Integer, Integer>>> r0 = this.mBarParams.viewMap.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L26;
        Map.Entry<View, Map<Integer, Integer>> r1 = r0.next();
        View r2 = r1.getKey();
        Map<Integer, Integer> r3 = r1.getValue();
        Integer r4 = Integer.valueOf(this.mBarParams.statusBarColor);
        Integer r5 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
        Iterator<Map.Entry<Integer, Integer>> r6 = r3.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<Integer, Integer> r7 = r6.next();
        Integer r8 = r7.getKey();
        r5 = r7.getValue();
        r4 = r8;
        goto L9
    L11:
        if (r2 == null) goto L6;
        if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) goto L14;
        r2.setBackgroundColor(ColorUtils.blendARGB(r4.intValue(), r5.intValue(), this.mBarParams.viewAlpha));
        goto L6
    L14:
        r2.setBackgroundColor(ColorUtils.blendARGB(r4.intValue(), r5.intValue(), this.mBarParams.statusBarAlpha));
        goto L6
    L26:
        return;
    }

    private void cancelListener() {
        Activity r0 = this.mActivity;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mNavigationObserver == null) goto L7;
        r0.getContentResolver().unregisterContentObserver(this.mNavigationObserver);
        this.mNavigationObserver = null;
    L7:
        FitsKeyboard r1 = this.mFitsKeyboard;
        if (r1 == null) goto L12;
        r1.cancel();
        this.mFitsKeyboard = null;
        return;
    }

    private void fitsKeyboard() {
        if (this.mIsFragment == false) goto L5;
        ImmersionBar r3 = mImmersionBarMap.get(this.mActivity.toString());
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.mBarParams.keyboardEnable == true) goto L18;
        FitsKeyboard r4 = r3.mFitsKeyboard;
        if (r4 == null) goto L30;
        r4.disable();
        return;
    L30:
        return;
    L18:
        if (r3.mFitsKeyboard != null) goto L20;
        r3.mFitsKeyboard = new FitsKeyboard(r3, r3.mActivity, r3.mWindow);
    L20:
        r3.mFitsKeyboard.enable(r3.mBarParams.keyboardMode);
        return;
    L5:
        if (this.mBarParams.keyboardEnable == true) goto L7;
        FitsKeyboard r5 = this.mFitsKeyboard;
        if (r5 == null) goto L26;
        r5.disable();
        return;
    L26:
        return;
    L7:
        if (this.mFitsKeyboard != null) goto L9;
        this.mFitsKeyboard = new FitsKeyboard(this, this.mActivity, this.mWindow);
    L9:
        this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    private void setPadding(int r2, int r3, int r4, int r5) {
        ViewGroup r0 = this.mContentView;
        if (r0 == null) goto L5;
        r0.setPadding(r2, r3, r4, r5);
    L5:
        this.mPaddingLeft = r2;
        this.mPaddingTop = r3;
        this.mPaddingRight = r4;
        this.mPaddingBottom = r5;
    }

    int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    int getPaddingTop() {
        return this.mPaddingTop;
    }

    int getPaddingRight() {
        return this.mPaddingRight;
    }

    int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (OSUtils.isMIUI6Later() == true) goto L7;
        OSUtils.isFlymeOS4Later();
        return true;
    L7:
        return true;
    }

    public static boolean isSupportNavigationIconDark() {
        OSUtils.isMIUI6Later();
        return true;
    }

    public static void setTitleBar(final Activity r3, final View r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
        return;
    L6:
        final ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0.height != (-2)) goto L9;
    L12:
        r4.post(new AnonymousClass2(r0, r4, r3));
        return;
    L9:
        if (r0.height == (-1)) goto L12;
        r0.height += getStatusBarHeight(r3);
        r4.setPadding(r4.getPaddingLeft(), r4.getPaddingTop() + getStatusBarHeight(r3), r4.getPaddingRight(), r4.getPaddingBottom());
    }

    public static void setTitleBarMarginTop(Activity r3, View r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
        return;
    L6:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        r5.setMargins(r5.leftMargin, r5.topMargin + getStatusBarHeight(r3), r5.rightMargin, r5.bottomMargin);
    }

    public static void setStatusBarView(Activity r1, View r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        return;
    L6:
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.height = getStatusBarHeight(r1);
        r2.setLayoutParams(r0);
    }

    public static void setFitsSystemWindows(Activity r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ViewGroup r5 = (ViewGroup) r4.findViewById(android.R.id.content);
        int r0 = r5.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        View r2 = r5.getChildAt(r1);
        if ((r2 instanceof ViewGroup) == false) goto L12;
        if ((r2 instanceof DrawerLayout) == true) goto L12;
        r2.setFitsSystemWindows(true);
        ((ViewGroup) r2).setClipToPadding(true);
    L12:
        r1 = r1 + 1;
        goto L5
    }

    public static boolean checkFitsSystemWindows(View r6) {
        if (r6.getFitsSystemWindows() == false) goto L6;
        return true;
    L6:
        if ((r6 instanceof ViewGroup) == false) goto L18;
        ViewGroup r7 = (ViewGroup) r6;
        int r0 = r7.getChildCount();
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L18;
        View r4 = r7.getChildAt(r3);
        if ((r4 instanceof DrawerLayout) == false) goto L15;
        if (checkFitsSystemWindows(r4) == false) goto L15;
        return true;
    L15:
        if (r4.getFitsSystemWindows() == true) goto L16;
        r3 = r3 + 1;
        goto L8
    L16:
        return true;
    L18:
        return false;
    }

    public static boolean hasNavigationBar(Activity r1) {
        return new BarConfig(r1).hasNavigationBar();
    }

    public static int getNavigationBarHeight(Activity r1) {
        return new BarConfig(r1).getNavigationBarHeight();
    }

    public static int getNavigationBarWidth(Activity r1) {
        return new BarConfig(r1).getNavigationBarWidth();
    }

    public static boolean isNavigationAtBottom(Activity r1) {
        return new BarConfig(r1).isNavigationAtBottom();
    }

    public static int getStatusBarHeight(Activity r1) {
        return new BarConfig(r1).getStatusBarHeight();
    }

    public static int getActionBarHeight(Activity r1) {
        return new BarConfig(r1).getActionBarHeight();
    }

    public static boolean hasNotchScreen(Activity r1) {
        return new BarConfig(r1).hasNotchScreen();
    }

    public static boolean hasNotchScreen(View r0) {
        return NotchUtils.hasNotchScreen(r0);
    }

    public static void hideStatusBar(Window r1) {
        r1.setFlags(1024, 1024);
    }

    private static boolean isEmpty(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.trim().length() == 0) goto L7;
        return false;
    }
}
