package com.android.internal.chooser;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentExt;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.internal.chooser.adapter.BaseResolverAdapter;
import com.android.internal.chooser.base.BaseResolverContract;
import com.android.internal.chooser.base.IntentModifier;
import com.android.internal.chooser.base.OnTargetClickHandler;
import com.android.internal.chooser.base.OnViewClickListener;
import com.android.internal.chooser.bean.ChooserTargets;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.db.ChooserRepository;
import com.android.internal.chooser.hook.ResolverHooker;
import com.android.internal.chooser.utils.ChooserAnimUtils;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.chooser.widget.ChooserListItemAnimator;
import com.android.internal.chooser.widget.CustomRoundImageView;
import com.android.internal.chooser.widget.LitePopup;
import com.android.internal.chooser.widget.NestedScrollView;
import com.android.internal.chooser.widget.NestedScrollingLayout;
import com.android.internal.dynamicanimation.animation.DynamicAnimation;
import com.android.internal.dynamicanimation.animation.SpringAnimation;
import com.android.internal.dynamicanimation.animation.SpringForce;
import com.android.internal.policy.StepOSSystemBarController;
import com.android.internal.widget.LinearLayoutManager;
import com.android.internal.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import stepos.app.StepOSWindowManager;
import stepos.widget.CircleProgressBar;

/* loaded from: classes.dex */
public abstract class BaseResolverHooker implements ResolverHooker, BaseResolverContract.View {
    public static final float ENTER_TRANS_Y_DAMP = 0.88f;
    public static final float ENTER_TRANS_Y_STIFFNESS = 340.0f;
    public static final float EXIT_TRANS_Y_DAMP = 0.93f;
    public static final float EXIT_TRANS_Y_STIFFNESS = 400.0f;
    public static final String FIRST_IMAGE_PREVIEW_TRANSITION_NAME = "screenshot_preview_image";
    public static float IN_THRESHOLD_DAMP = 0.98f;
    public static float IN_THRESHOLD_DAMP_STIFFNESS = 300.0f;
    private static final String NIGHT_MODE_ACTION = "com.stepos.steposlab.nightmode.action.steposlab.SETTINGS_CHANGED";
    private static final String STEPOS_FLAG_SKIP_TASK_SCREENSHOT = "STEPOS_FLAG_SKIP_TASK_SCREENSHOT";
    private static final String TAG = "BaseResolverHooker";
    private static WeakReference<TextView> sTextViewRef;
    protected boolean isTypeGeoUri;
    protected Activity mActivity;
    private ResolverHooker.ActivityBridge mActivityBridge;
    private BitmapHandlerThread mBitmapHandlerThread;
    private CheckBox mCheckBox;
    private FrameLayout mChooserPreviewLayout;
    private View mChooserTitleLayout;
    private OnTargetClickHandler mClickHandler;
    protected Intent mExtraIntent;
    protected String mExtraIntentType;
    private Runnable mFinishTask;
    private IntentModifier mIntentModifier;
    protected IntentParser mIntentParser;
    protected int mIntentUriNum;
    private boolean mIsLandscape;
    private boolean mIsPause;
    protected boolean mIsSharingScreenshotOrRecod;
    private ImageView mIvFilePolicy;
    private CustomRoundImageView mIvFileThumbnail;
    protected NestedScrollView mNestedScrollView;
    protected NestedScrollingLayout mNestedScrollingLayout;
    private CheckBox mOpenFileCheckBox;
    private TextView mOpenFileCheckBoxTip;
    private List<ResolveInfo> mOriginTarget;
    private BaseResolverContract.Presenter mPresenter;
    private View mPreview;
    protected Intent mQueryIntent;
    private NightModeChangeReceiver mReceiver;
    protected RecyclerView mRecyclerView;
    private BaseResolverAdapter mResolverAdapter;
    private boolean mRetainInOnStop;
    private CustomRoundImageView mScreenShotPreview;
    protected View mTitleScrollIndicatorUp;
    private SpringAnimation mTranYSpringAnimation;
    private TextView mTvFileName;
    private TextView mTvFilePolicy;
    private TextView mTvFileSize;
    private TextView mTvFileType;
    protected ArrayList<Uri> mUris;
    private Window mWindow;
    private boolean needSkipCaptureScreenshot;
    private final ColorDrawable mDimBackground = new ColorDrawable(0);
    private float mDimAmount = 0.0f;
    private final int THUMBNAIL_WIDTH = 50;
    private final int PREVIEW_WIDTH_VERTICAL = 212;
    private final int PREVIEW_HEIGHT_VERTICAL = 376;
    private final int PREVIEW_WIDTH_HORIZONTAL = 490;
    private final int PREVIEW_HEIGHT_HORIZONTAL = 216;
    private final TimeInterpolator mAlphaInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private final TimeInterpolator mSlideInterpolator = new PathInterpolator(0.26f, 1.0f, 0.48f, 1.0f);
    private boolean mAllItemsLoaded = false;
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    private boolean isDestroy = false;
    private boolean mIsRepositoryUpdateWhenPause = false;
    private boolean mNightMode = false;
    protected boolean mSafeForwardingMode = false;
    private final ChooserListItemAnimator mItemAnimator = new ChooserListItemAnimator();
    protected boolean mDoubleFiles = false;
    protected boolean mHasFilePolicyInfo = false;
    protected final String APP_ICON = "app_icon";
    protected final String APP_LABEL = "app_label";
    protected final int CHOOSER_FILEPOLICY_REQUEST_CODE = StepOSWindowManager.VERSION_CODE;
    protected int mFilePolicyType = 1;
    private ChooserRepository.OnDataChangedListener mOnDataChangedListener = new ChooserRepository.OnDataChangedListener() { // from class: com.android.internal.chooser.BaseResolverHooker.4
        @Override // com.android.internal.chooser.db.ChooserRepository.OnDataChangedListener
        public void onDataChanged() {
            if (BaseResolverHooker.this.mIsPause) {
                BaseResolverHooker.this.mIsRepositoryUpdateWhenPause = true;
            } else {
                BaseResolverHooker.this.mPresenter.fetchUnsortedNormalTargets(BaseResolverHooker.this.mActivity, BaseResolverHooker.this.mQueryIntent, BaseResolverHooker.this.getInitialIntents(), BaseResolverHooker.this.getInitialResolveInfo());
            }
        }
    };
    private final LitePopup.OnDismissedListener mDismissedListener = new LitePopup.OnDismissedListener() { // from class: com.android.internal.chooser.BaseResolverHooker.6
        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDismissed(boolean needExitAnim) {
            BaseResolverHooker.this.finishAfterAnimator(needExitAnim);
        }

        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDragTriggered() {
        }

        @Override // com.android.internal.chooser.widget.LitePopup.OnDismissedListener
        public void onDismissProgress(float progress) {
            if (progress > 0.8d) {
                BaseResolverHooker.this.transparentNavigationBar();
                BaseResolverHooker.this.finishAfterAnimator(true);
            }
        }
    };
    private final OnViewClickListener mOnViewClickListener = new OnViewClickListener() { // from class: com.android.internal.chooser.BaseResolverHooker.7
        /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01e6  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.android.internal.chooser.base.OnViewClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(com.android.internal.chooser.bean.DisplayResolveInfo r23, com.android.internal.chooser.QuickLookStrategy r24, com.android.internal.chooser.ShareStrategy r25) throws android.content.IntentSender.SendIntentException {
            /*
                Method dump skipped, instructions count: 554
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.internal.chooser.BaseResolverHooker.AnonymousClass7.onClick(com.android.internal.chooser.bean.DisplayResolveInfo, com.android.internal.chooser.QuickLookStrategy, com.android.internal.chooser.ShareStrategy):void");
        }

        @Override // com.android.internal.chooser.base.OnViewClickListener
        public void onMoreButtonClick(boolean isCollapse) {
            if (BaseResolverHooker.this.mRecyclerView != null) {
                BaseResolverHooker.this.mRecyclerView.setItemAnimator(isCollapse ? null : BaseResolverHooker.this.mItemAnimator);
            }
            if (!isCollapse && BaseResolverHooker.this.mNestedScrollingLayout.getCurrentState() != 0) {
                BaseResolverHooker.this.mNestedScrollingLayout.smoothScrollToPositionState(0, 300);
            }
        }

        @Override // com.android.internal.chooser.base.OnViewClickListener
        public void onEditButtonClick(List<DisplayResolveInfo> favorites, List<DisplayResolveInfo> collapses) {
            ChooserSettingActivity.openChooserSettingActivity(BaseResolverHooker.this.mActivity, favorites, collapses);
        }

        @Override // com.android.internal.chooser.base.OnViewClickListener
        public void onPopupMenuChanged(boolean show) {
            BaseResolverHooker.this.mNestedScrollingLayout.setConsumedScrollEnable(show);
        }
    };
    private final PackageMonitor mPackageMonitor = new PackageMonitor() { // from class: com.android.internal.chooser.BaseResolverHooker.8
        @Override // com.android.internal.chooser.PackageMonitor
        protected void onPackageChanged() {
            BaseResolverHooker.this.mPresenter.fetchUnsortedNormalTargets(BaseResolverHooker.this.mActivity, BaseResolverHooker.this.mQueryIntent, BaseResolverHooker.this.getInitialIntents(), BaseResolverHooker.this.getInitialResolveInfo());
        }
    };
    private ContentObserver contentObserver = new ContentObserver(new Handler()) { // from class: com.android.internal.chooser.BaseResolverHooker.10
        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            if (uri.equals(Settings.Global.getUriFor("chooser_file_policy_status"))) {
                BaseResolverHooker.this.updateFilePolicy();
            }
        }
    };

    protected abstract Intent[] getInitialIntents();

    protected abstract List<ResolveInfo> getInitialResolveInfo();

    protected abstract IntentModifier getIntentModifier();

    protected abstract BaseResolverContract.Presenter getPresenter();

    protected abstract Intent getQueryIntent();

    protected abstract OnTargetClickHandler getTargetClickHandler();

    protected abstract boolean isChooserActivity();

    protected abstract void setupCheckBox(CheckBox checkBox);

    protected abstract void setupFileName(TextView textView);

    protected abstract void setupFilePolicy(TextView textView, ImageView imageView);

    protected abstract void setupFileSize(TextView textView);

    protected abstract void setupFileThumbnail(CustomRoundImageView customRoundImageView);

    protected abstract void setupFileType(TextView textView);

    protected abstract void setupOpenFileCheckBox(TextView textView, CheckBox checkBox);

    protected abstract void setupPreview(FrameLayout frameLayout, View view);

    protected abstract void setupTitleLayout(View view);

    protected abstract boolean showRecommendTagIfNeed();

    private class BitmapHandlerThread extends HandlerThread {
        private static final String THREAD_NAME = "BitmapHandlerThread";
        private Handler mBitmapHandler;

        public BitmapHandlerThread(BaseResolverHooker baseResolverHooker, String name) {
            super(name);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            this.mBitmapHandler = new Handler(getLooper());
        }

        public Handler getBitmapHandler() {
            if (this.mBitmapHandler == null) {
                LogUtils.w("Bitmap thread is not prepared");
                return null;
            }
            return this.mBitmapHandler;
        }
    }

    public BaseResolverHooker(Activity activity, Runnable finishTask) {
        this.mActivity = activity;
        this.mFinishTask = finishTask;
        this.mWindow = this.mActivity.getWindow();
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void registerActivityBridgeListener(ResolverHooker.ActivityBridge activityBridge) {
        if (this.mResolverAdapter == null) {
            LogUtils.w("registerLayoutListener failed");
        }
        this.mActivityBridge = activityBridge;
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onCreate(Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        this.mBitmapHandlerThread = new BitmapHandlerThread(this, "BitmapHandlerThread");
        this.mBitmapHandlerThread.start();
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
        this.mWindow.requestFeature(12);
        ChooserAnimUtils.transparentNavigationBar(this.mWindow);
        LogUtils.initLog();
        LogUtils.dumpIntent(this.mActivity.getIntent());
        this.mIntentParser = new IntentParser(this.mActivity.getIntent());
        this.mExtraIntent = this.mIntentParser.getExtraIntent();
        if (this.mExtraIntent == null) {
            this.mExtraIntent = this.mIntentParser.getOriginIntent();
        }
        this.mExtraIntentType = this.mExtraIntent.getType();
        this.mIsLandscape = Utils.isLandscape(this.mActivity);
        this.mIsSharingScreenshotOrRecod = isSharingScreenshotOrRecod();
        if (this.mIsSharingScreenshotOrRecod && getResources().getConfiguration().isScreenWideColorGamut()) {
            this.mWindow.setColorMode(1);
        }
        this.mUris = Utils.getIntentUris(this.mExtraIntent);
        this.needSkipCaptureScreenshot = isNeedSkipCaptureScreenshot();
        if (this.needSkipCaptureScreenshot) {
            addStepOSWindowFlags(this.mWindow.getAttributes(), getStepOSSkipTaskFlag(this.mWindow.getAttributes()));
        }
        if (this.mUris != null && this.mUris.size() > 0) {
            Iterator<Uri> it = this.mUris.iterator();
            while (it.hasNext()) {
                Uri uri = it.next();
                Utils.grantUriPermission(this.mActivity, uri);
            }
        }
        this.isTypeGeoUri = Utils.isTypeGeoUri(Utils.getIntentUri(this.mExtraIntent));
        initFilePolicy();
        hideStatusBafIfNeed();
        View view = LayoutInflater.from(this.mActivity).inflate(17367442, (ViewGroup) null);
        this.mActivity.setContentView(view);
        initView(view);
        this.mWindow.addFlags(2);
        this.mWindow.setDimAmount(0.1f);
        if (this.mIsSharingScreenshotOrRecod) {
            this.mWindow.setWindowAnimations(R.style.TextAppearance.Holo.Light.Widget.Switch);
            this.mActivity.postponeEnterTransition();
            startShareElementTransition();
        } else {
            this.mNestedScrollingLayout.setAlpha(0.0f);
        }
        if (this.mIntentParser.dismissKeyguard()) {
            this.mWindow.addFlags(IntentExt.STEPOS_FLAG_START_FROM_JOB_SERVICE);
        }
        if (this.mIntentParser.showWhenLocked()) {
            this.mWindow.addFlags(IntentExt.STEPOS_FLAG_START_FROM_REMOTE);
        }
        if (savedInstanceState != null && savedInstanceState.containsKey(IntentParser.KEY_IS_NIGHT_MODE)) {
            this.mNightMode = savedInstanceState.getBoolean(IntentParser.KEY_IS_NIGHT_MODE);
        } else if (this.mIntentParser.isNightModeSet()) {
            this.mNightMode = this.mIntentParser.isNightMode();
        } else {
            this.mNightMode = Utils.isNightMode(this.mActivity);
        }
        Intent queryIntent = getQueryIntent();
        if (queryIntent == null) {
            finishAfterAnimator(false);
            return;
        }
        this.mIntentModifier = getIntentModifier();
        this.mQueryIntent = this.mIntentModifier.modifyQueryIntent(queryIntent);
        this.mPresenter = getPresenter();
        this.mClickHandler = getTargetClickHandler();
        this.mPackageMonitor.register(this.mActivity);
        this.mActivity.getContentResolver().registerContentObserver(Settings.Global.getUriFor("chooser_file_policy_status"), true, this.contentObserver);
        String updateOwner = Settings.System.getString(getContentResolver(), ChooserRepository.CHOOSER_REPOSITORY_UPDATE_BY);
        if (!TextUtils.equals(updateOwner, this.mActivity.getPackageName())) {
            ChooserRepository.getInstance(this.mActivity).loadAll();
        }
        this.mPresenter.fetchUnsortedNormalTargets(this.mActivity, this.mQueryIntent, getInitialIntents(), getInitialResolveInfo());
        onActivityStart();
        ChooserRepository.getInstance(this.mActivity).registerListener(this.mOnDataChangedListener);
        this.mTranYSpringAnimation = new SpringAnimation(this.mNestedScrollingLayout, SpringAnimation.TRANSLATION_Y);
    }

    private void startShareElementTransition() {
        this.mWindow.setAllowEnterTransitionOverlap(true);
        this.mWindow.setSharedElementsUseOverlay(true);
        Transition transition = this.mWindow.getSharedElementEnterTransition();
        transition.setInterpolator(this.mSlideInterpolator);
        transition.setDuration(350L);
        this.mWindow.setSharedElementEnterTransition(transition);
        this.mActivity.setEnterSharedElementCallback(new SharedElementCallback() { // from class: com.android.internal.chooser.BaseResolverHooker.1
            @Override // android.app.SharedElementCallback
            public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots);
                LogUtils.d("onSharedElementEnd sharedElementNames = " + sharedElementNames + " , sharedElements = " + sharedElements);
                if (BaseResolverHooker.this.mScreenShotPreview != null && BaseResolverHooker.this.mNestedScrollView != null) {
                    BaseResolverHooker.this.mScreenShotPreview.setPaintPreviewStrokeBlack(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startEnterAnimation() {
        ValueAnimator alpha = ValueAnimator.ofFloat(this.mDimAmount, 0.1f);
        alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.internal.chooser.BaseResolverHooker.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                BaseResolverHooker.this.mDimAmount = ((Float) animation.getAnimatedValue()).floatValue();
                BaseResolverHooker.this.updateDimBackground();
            }
        });
        alpha.setInterpolator(this.mAlphaInterpolator);
        alpha.setDuration(200L);
        this.mNestedScrollingLayout.setAlpha(1.0f);
        int height = this.mNestedScrollingLayout.getMeasuredHeight();
        this.mNestedScrollingLayout.setTranslationY(height);
        alpha.start();
        this.mTranYSpringAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.android.internal.chooser.BaseResolverHooker.3
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                View firstView = BaseResolverHooker.this.mRecyclerView.getChildCount() > 0 ? BaseResolverHooker.this.mRecyclerView.getChildAt(0) : null;
                if (firstView == null) {
                    return;
                }
                RecyclerView.ViewHolder holder = BaseResolverHooker.this.mRecyclerView.getChildViewHolder(firstView);
                if (holder instanceof BaseResolverAdapter.ResolveInfoViewHolder) {
                    View itemView = holder.itemView;
                    if (BaseResolverHooker.this.mActivityBridge != null) {
                        BaseResolverHooker.this.mActivityBridge.showUserGuide(itemView.findViewById(R.id.nokeys));
                    }
                }
            }
        });
        this.mTranYSpringAnimation.setSpring(new SpringForce().setDampingRatio(0.88f).setStiffness(340.0f));
        this.mTranYSpringAnimation.getSpring().setFinalPosition(0.0f);
        this.mTranYSpringAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDimBackground() {
        this.mDimBackground.setColor(Color.argb(this.mDimAmount, 0.0f, 0.0f, 0.0f));
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onStart() {
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onResume() {
        this.mIsPause = false;
        if (this.mIsRepositoryUpdateWhenPause) {
            this.mPresenter.fetchUnsortedNormalTargets(this.mActivity, this.mQueryIntent, getInitialIntents(), getInitialResolveInfo());
            this.mIsRepositoryUpdateWhenPause = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIfAllItemsAreDisplayed() {
        LinearLayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();
        int totalItemCount = this.mRecyclerView.getAdapter().getItemCount();
        if (lastVisiblePosition == totalItemCount - 1) {
            this.mAllItemsLoaded = true;
        }
    }

    protected void onAllItemsLoaded() {
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onPause() {
        this.mIsPause = true;
    }

    protected void setRetainInOnStop(boolean retainInOnStop) {
        this.mRetainInOnStop = retainInOnStop;
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onStop() {
        Intent intent = this.mActivity.getIntent();
        boolean resolvingHome = false;
        Set<String> categories = intent.getCategories();
        if ("android.intent.action.MAIN".equals(intent.getAction()) && categories != null && categories.size() == 1 && categories.contains("android.intent.category.HOME")) {
            resolvingHome = true;
        }
        if ((intent.getFlags() & IntentExt.STEPOS_FLAG_IMMEDIATE_BROADCAST) != 0 && !resolvingHome && !this.mRetainInOnStop && !this.mActivity.isChangingConfigurations()) {
            finishAfterAnimator(true);
        }
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onRestart() {
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onDestroy() {
        if (this.mBitmapHandlerThread != null) {
            this.mBitmapHandlerThread.quit();
            this.isDestroy = true;
        }
        unRegisterReceiverIfNeed();
        if (this.contentObserver != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.contentObserver);
            this.contentObserver = null;
        }
        this.mPackageMonitor.unregister();
        ChooserRepository.getInstance(this.mActivity).unregisterListener(this.mOnDataChangedListener);
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(IntentParser.KEY_IS_NIGHT_MODE, this.mNightMode);
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAfterAnimator(boolean needExitAnim) {
        if (needExitAnim) {
            ChooserAnimUtils.startSpringExitAnimation(this.mWindow, this.mNestedScrollingLayout, this.mDimBackground, 1.0f, this.mFinishTask);
        } else {
            this.mFinishTask.run();
        }
    }

    public void onActivityStart() {
    }

    public void onTargetClick(Intent intent, ResolveInfo resolveInfo, boolean isChecked) {
    }

    private void updateScrollingLayoutPadding() throws Resources.NotFoundException {
        if (this.mNestedScrollingLayout == null) {
            return;
        }
        int paddingHorizontal = getResources().getDimensionPixelOffset(17106491);
        boolean isInMultiWindow = this.mActivity.isInMultiWindowMode();
        LogUtils.d("updateScrollingLayoutPadding and multiWindow:" + isInMultiWindow);
        if (isInMultiWindow) {
            paddingHorizontal = 0;
        }
        this.mNestedScrollingLayout.setPadding(paddingHorizontal, this.mNestedScrollingLayout.getPaddingTop(), paddingHorizontal, this.mNestedScrollingLayout.getPaddingBottom());
    }

    private void initView(View root) throws Resources.NotFoundException {
        this.mNestedScrollingLayout = (NestedScrollingLayout) root.findViewById(R.id.conversation_icon_badge_ring);
        this.mNestedScrollingLayout.setOnDismissedListener(this.mDismissedListener);
        updateScrollingLayoutPadding();
        this.mNestedScrollView = (NestedScrollView) root.findViewById(16909934);
        this.mTitleScrollIndicatorUp = root.findViewById(R.id.costsMoney);
        this.mRecyclerView = root.findViewById(R.id.conversation_icon_badge);
        this.mRecyclerView.setItemAnimator(this.mItemAnimator);
        this.mResolverAdapter = new BaseResolverAdapter(this.mActivity, this.mActivity, this.mOnViewClickListener, isChooserActivity(), showRecommendTagIfNeed());
        this.mRecyclerView.setAdapter(this.mResolverAdapter);
        this.mChooserTitleLayout = root.findViewById(16909954);
        this.mChooserPreviewLayout = (FrameLayout) root.findViewById(16909945);
        this.mIvFileThumbnail = (CustomRoundImageView) root.findViewById(16909937);
        this.mTvFileName = (TextView) root.findViewById(16909935);
        this.mTvFileType = (TextView) root.findViewById(16909938);
        this.mTvFileSize = (TextView) root.findViewById(16909936);
        this.mTvFilePolicy = (TextView) root.findViewById(16909955);
        this.mIvFilePolicy = (ImageView) root.findViewById(16909942);
        this.mIntentUriNum = Utils.getIntentUriNum(this.mExtraIntent);
        this.mDoubleFiles = this.mIntentUriNum > 1;
        this.mCheckBox = (CheckBox) root.findViewById(R.id.controlScreen_icon);
        this.mOpenFileCheckBoxTip = (TextView) root.findViewById(16909944);
        this.mOpenFileCheckBox = (CheckBox) root.findViewById(16909943);
        sTextViewRef = new WeakReference<>(this.mTvFilePolicy);
        if ((this.mActivity instanceof RecommendActivity) && getQueryIntent() == null) {
            finish();
            return;
        }
        setupFileName(this.mTvFileName);
        setupTitleLayout(this.mChooserTitleLayout);
        setupFileType(this.mTvFileType);
        setupFileThumbnail(this.mIvFileThumbnail);
        setupFileSize(this.mTvFileSize);
        setupFilePolicy(this.mTvFilePolicy, this.mIvFilePolicy);
        setupCheckBox(this.mCheckBox);
        setupOpenFileCheckBox(this.mOpenFileCheckBoxTip, this.mOpenFileCheckBox);
        this.mRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.chooser.BaseResolverHooker.5
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (BaseResolverHooker.this.mAllItemsLoaded) {
                    BaseResolverHooker.this.mRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                    BaseResolverHooker.this.onAllItemsLoaded();
                    if (BaseResolverHooker.this.mIsSharingScreenshotOrRecod) {
                        BaseResolverHooker.this.mActivity.startPostponedEnterTransition();
                    } else {
                        BaseResolverHooker.this.startEnterAnimation();
                    }
                    return true;
                }
                BaseResolverHooker.this.checkIfAllItemsAreDisplayed();
                return true;
            }
        });
        if (this.mIsSharingScreenshotOrRecod) {
            this.mNestedScrollingLayout.setStyle(2);
            startCheckboxAnimation(this.mCheckBox);
        } else {
            this.mNestedScrollingLayout.setStyle(this.mIntentParser.getStyleState());
        }
        if (this.mNestedScrollingLayout.getCurrentState() == 1) {
            this.mRecyclerView.setNestedScrollingEnabled(false);
        }
        if (this.mIsSharingScreenshotOrRecod) {
            this.mPreview = createCustomView();
            if (this.mPreview != null) {
                setupPreview(this.mChooserPreviewLayout, this.mPreview);
                this.mScreenShotPreview.setPaintPreviewStrokeBlack(true);
            }
        }
    }

    private View createCustomView() {
        final View customView = LayoutInflater.from(this.mActivity).inflate(17367450, (ViewGroup) null);
        this.mScreenShotPreview = (CustomRoundImageView) customView.findViewById(16909947);
        this.mScreenShotPreview.setTransitionName(FIRST_IMAGE_PREVIEW_TRANSITION_NAME);
        ArrayList<Uri> uris = Utils.getIntentUris(this.mExtraIntent);
        if (uris.isEmpty() || this.mExtraIntent == null) {
            return null;
        }
        final Uri uri = uris.get(0);
        if (isSharingUriWithoutScheme(uri)) {
            return null;
        }
        Handler bitmapHandler = this.mBitmapHandlerThread.getBitmapHandler();
        final Bitmap[] bitmapTmp = new Bitmap[1];
        Bitmap bitmap = null;
        if (bitmapHandler == null) {
            bitmap = createBitmap(this.mActivity, uri, this.mExtraIntent, false);
        } else {
            bitmapHandler.post(new Runnable() { // from class: com.android.internal.chooser.BaseResolverHooker$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createCustomView$1(bitmapTmp, uri, customView);
                }
            });
        }
        if (bitmap == null) {
            LogUtils.d("Bitmap from Uri is null, set gone");
            return null;
        }
        if (this.mExtraIntentType != null && this.mExtraIntentType.startsWith("video/")) {
            String duration = Utils.screenRecordingDuration(this.mActivity, uri);
            if (!TextUtils.isEmpty(duration)) {
                this.mScreenShotPreview.setDrawText(duration);
            }
        }
        this.mScreenShotPreview.setBorderRadius(12);
        this.mScreenShotPreview.setImageBitmap(bitmap);
        this.mScreenShotPreview.setVisibility(0);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mTitleScrollIndicatorUp.getLayoutParams();
        int padding = Utils.dp2px(this.mActivity, 8.0f);
        customView.setPadding(padding, padding, padding, 0);
        lp.topMargin = Utils.dp2px(this.mActivity, 24.0f);
        return customView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createCustomView$1(final Bitmap[] bitmapTmp, final Uri uri, final View customView) {
        bitmapTmp[0] = createBitmap(this.mActivity, uri, this.mExtraIntent, false);
        if (bitmapTmp[0] == null) {
            return;
        }
        this.mUiHandler.post(new Runnable() { // from class: com.android.internal.chooser.BaseResolverHooker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createCustomView$0(customView, bitmapTmp, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createCustomView$0(View customView, Bitmap[] bitmapTmp, Uri uri) {
        if (this.isDestroy) {
            return;
        }
        handleCustomView(customView, bitmapTmp[0], uri);
    }

    private void handleCustomView(View customView, Bitmap bitmap, Uri uri) {
        if (this.mExtraIntentType != null && this.mExtraIntentType.startsWith("video/")) {
            String duration = Utils.screenRecordingDuration(this.mActivity, uri);
            if (!TextUtils.isEmpty(duration)) {
                this.mScreenShotPreview.setDrawText(duration);
            }
        }
        this.mScreenShotPreview.setBorderRadius(12);
        this.mScreenShotPreview.setImageBitmap(bitmap);
        this.mScreenShotPreview.setVisibility(0);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mTitleScrollIndicatorUp.getLayoutParams();
        int padding = Utils.dp2px(this.mActivity, 8.0f);
        customView.setPadding(padding, padding, padding, 0);
        lp.topMargin = Utils.dp2px(this.mActivity, 24.0f);
        if (this.mIsSharingScreenshotOrRecod) {
            this.mPreview = customView;
            setupPreview(this.mChooserPreviewLayout, this.mPreview);
            this.mScreenShotPreview.setPaintPreviewStrokeBlack(true);
        }
    }

    private static class IntentSenderFinishedCallback implements IntentSender.OnFinished {
        private final WeakReference<BaseResolverHooker> mReference;

        private IntentSenderFinishedCallback(BaseResolverHooker hooker) {
            this.mReference = new WeakReference<>(hooker);
        }

        @Override // android.content.IntentSender.OnFinished
        public void onSendFinished(IntentSender IntentSender, Intent intent, int resultCode, String resultData, Bundle resultExtras) {
            BaseResolverHooker hooker = this.mReference.get();
            if (hooker == null) {
                LogUtils.e("onSendFinished, but activity == null");
            } else {
                hooker.finishAfterAnimator(true);
            }
        }
    }

    @Override // com.android.internal.chooser.base.BaseResolverContract.View
    public void showNormalTargets(ChooserTargets targets, boolean sorted, boolean animation) {
        if (targets == null) {
            return;
        }
        this.mOriginTarget = targets.getOriginTarget();
        List<DisplayResolveInfo> list = targets.getAllTarget();
        LogUtils.dumpDisplayResolverInfo("all target before filter", list);
        List<DisplayResolveInfo> list2 = filterResolve(list);
        LogUtils.dumpDisplayResolverInfo("all target after filter", list2);
        if (list2.size() == 0) {
            finishAfterAnimator(false);
            return;
        }
        if (list2.size() == 1) {
            this.mOnViewClickListener.onClick(list2.get(0), QuickLookStrategy.FORCE_FULL_SCREEN, ShareStrategy.SHARE_FOLLOW_SYSTEM);
            finishAfterAnimator(false);
        } else if (!sorted) {
            this.mPresenter.fetchSortedNormalTargets(this.mActivity, targets);
        } else {
            this.mResolverAdapter.setData(list2);
        }
    }

    private void registerReceiverIfNeed() {
        if (this.mReceiver == null && !this.mIntentParser.isForceKeepNightMode()) {
            this.mReceiver = new NightModeChangeReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction(NIGHT_MODE_ACTION);
            if (Build.VERSION.SDK_INT >= 34) {
                this.mActivity.registerReceiver(this.mReceiver, filter, 4);
            } else {
                this.mActivity.registerReceiver(this.mReceiver, filter);
            }
        }
    }

    private void unRegisterReceiverIfNeed() {
        if (this.mReceiver != null) {
            this.mActivity.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
        }
    }

    private class NightModeChangeReceiver extends BroadcastReceiver {
        private NightModeChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BaseResolverHooker.NIGHT_MODE_ACTION.equals(intent.getAction())) {
                BaseResolverHooker.this.mNightMode = intent.getBooleanExtra("steposlab_stepos_night_mode", false);
                BaseResolverHooker.this.onNightModeChange(BaseResolverHooker.this.mNightMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNightModeChange(boolean isNightMode) {
        if (isNightMode) {
            this.mCheckBox.setTextColor(1929379840);
            this.mResolverAdapter.setTextColor(StepOSSystemBarController.COLO_BLACK);
            this.mResolverAdapter.setItemSelector(17304676);
            this.mResolverAdapter.notifyDataSetChanged();
            return;
        }
        this.mCheckBox.setTextColor(1929379840);
        this.mResolverAdapter.setTextColor(StepOSSystemBarController.COLO_BLACK);
        this.mResolverAdapter.setItemSelector(17304676);
        this.mResolverAdapter.notifyDataSetChanged();
    }

    private void hideStatusBafIfNeed() {
        if ((getResources().getConfiguration().orientation == 2 && this.mIntentParser.isHideStatusBarLandscape()) || (getResources().getConfiguration().orientation == 1 && this.mIntentParser.isHideStatusBarPortrait())) {
            this.mWindow.addFlags(1024);
        } else {
            this.mWindow.clearFlags(1024);
        }
    }

    private void setNavigationAndStatusBar(boolean transparentNavigation) {
        this.mWindow.clearFlags(CircleProgressBar.RIM_COLOR_DEF);
        this.mWindow.addFlags(IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT);
        if (transparentNavigation) {
            transparentNavigationBar();
        } else {
            this.mWindow.setNavigationBarColor(Color.parseColor("#E6FFFFFF"));
        }
        this.mWindow.setDecorFitsSystemWindows(false);
        this.mWindow.setStatusBarColor(0);
        this.mWindow.setStatusBarContrastEnforced(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transparentNavigationBar() {
        this.mWindow.setNavigationBarContrastEnforced(false);
        this.mWindow.setNavigationBarColor(0);
    }

    private List<DisplayResolveInfo> filterResolve(List<DisplayResolveInfo> list) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        Iterator<DisplayResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            DisplayResolveInfo displayResolveInfo = it.next();
            if (isComponentFiltered(displayResolveInfo.resolveInfo.activityInfo.packageName, displayResolveInfo.resolveInfo.activityInfo.name)) {
                it.remove();
            }
        }
        return list;
    }

    private boolean isComponentFiltered(String pkg, String cls) {
        ComponentName[] filteredComponents = this.mIntentParser.getFilteredComponents();
        if (filteredComponents == null) {
            return false;
        }
        for (ComponentName filteredComponentName : filteredComponents) {
            if (filteredComponentName.getPackageName().equals(pkg) && filteredComponentName.getClassName().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onConfigurationChanged(Configuration newConfig) throws Resources.NotFoundException {
        this.mIsLandscape = newConfig.orientation == 2;
        if (this.mIsSharingScreenshotOrRecod) {
            this.mPreview = createCustomView();
            if (this.mPreview != null) {
                setupPreview(this.mChooserPreviewLayout, this.mPreview);
                this.mScreenShotPreview.setPaintPreviewStrokeBlack(true);
            }
        }
        hideStatusBafIfNeed();
        if (this.mIsLandscape) {
            transparentNavigationBar();
        }
        this.mResolverAdapter.updateLayoutManager(this.mRecyclerView);
        this.mResolverAdapter.refresh();
        updateScrollingLayoutPadding();
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onBackPressed() {
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void finish() {
        finishAfterAnimator(true);
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void setSafeForwardingMode(boolean safeForwarding) {
        this.mSafeForwardingMode = safeForwarding;
    }

    protected Resources getResources() {
        return this.mActivity.getResources();
    }

    protected ContentResolver getContentResolver() {
        return this.mActivity.getContentResolver();
    }

    protected final IBinder getActivityToken() {
        return this.mActivity.getActivityToken();
    }

    private void startCheckboxAnimation(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.setAlpha(0.0f);
        view.setVisibility(0);
        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        fadeAnim.setInterpolator(this.mAlphaInterpolator);
        fadeAnim.setDuration(200L);
        fadeAnim.setStartDelay(250L);
        fadeAnim.start();
    }

    public boolean isSharingScreenshotOrRecod() {
        if (this.mExtraIntent == null) {
            return false;
        }
        ArrayList<Uri> uris = new ArrayList<>();
        Object uriObject = Utils.getIntentUris(this.mExtraIntent);
        if (uriObject instanceof ArrayList) {
            Iterator it = ((ArrayList) uriObject).iterator();
            while (it.hasNext()) {
                Object obj = it.next();
                if (obj instanceof Uri) {
                    uris.add((Uri) obj);
                }
            }
        }
        if (uris.size() == 0 || uris.get(0) == null) {
            return false;
        }
        Uri uri = uris.get(0);
        return uri.getAuthority() != null && "media".equals(uri.getAuthority());
    }

    public void handleFileThumbnail(CustomRoundImageView fileThumbnailIv, Intent mDefaultIntent, String mFileType) {
        fileThumbnailIv.setVisibility(0);
        if (handledSingleFileThumbnail(fileThumbnailIv, mDefaultIntent)) {
            return;
        }
        Drawable drawable = this.mActivity.getDrawable(getDefaultThumbnailResId(mFileType));
        fileThumbnailIv.setImageBitmap(Utils.getBitmapFromDrawable(drawable));
    }

    public boolean handledSingleFileThumbnail(CustomRoundImageView fileThumbnailIv, final Intent mDefaultIntent) {
        final CustomRoundImageView fileThumbnailIv2;
        final Uri mIntentUri = Utils.getIntentUri(mDefaultIntent);
        if (isSharingUriWithoutScheme(mIntentUri)) {
            Bitmap bitmap = createThumbnail(mIntentUri);
            if (bitmap == null) {
                return false;
            }
            fileThumbnailIv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            fileThumbnailIv.setBorderRadius(10);
            fileThumbnailIv.setImageBitmap(bitmap);
            return true;
        }
        if (Utils.isTypeApplication(mDefaultIntent, this.mActivity)) {
            Drawable drawable = (Drawable) Utils.loadApplictionInfo(mDefaultIntent, this.mActivity, "app_icon");
            Bitmap bitmap2 = Utils.getBitmapFromDrawable(drawable);
            if (bitmap2 == null) {
                return false;
            }
            fileThumbnailIv.setImageBitmap(bitmap2);
            return true;
        }
        Handler bitmapHandler = this.mBitmapHandlerThread.getBitmapHandler();
        final Bitmap[] bitmapTmp = new Bitmap[1];
        Bitmap bitmap3 = null;
        if (bitmapHandler == null) {
            bitmap3 = createBitmap(this.mActivity, mIntentUri, mDefaultIntent, true);
            fileThumbnailIv2 = fileThumbnailIv;
        } else {
            fileThumbnailIv2 = fileThumbnailIv;
            bitmapHandler.post(new Runnable() { // from class: com.android.internal.chooser.BaseResolverHooker$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handledSingleFileThumbnail$3(bitmapTmp, mIntentUri, mDefaultIntent, fileThumbnailIv2);
                }
            });
        }
        if (bitmap3 == null) {
            return false;
        }
        handledSingleFileThumbnail(fileThumbnailIv2, bitmap3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handledSingleFileThumbnail$3(final Bitmap[] bitmapTmp, Uri mIntentUri, Intent mDefaultIntent, final CustomRoundImageView fileThumbnailIv) {
        bitmapTmp[0] = createBitmap(this.mActivity, mIntentUri, mDefaultIntent, true);
        if (bitmapTmp[0] == null) {
            return;
        }
        this.mUiHandler.post(new Runnable() { // from class: com.android.internal.chooser.BaseResolverHooker$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handledSingleFileThumbnail$2(fileThumbnailIv, bitmapTmp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handledSingleFileThumbnail$2(CustomRoundImageView fileThumbnailIv, Bitmap[] bitmapTmp) {
        if (this.isDestroy) {
            return;
        }
        handledSingleFileThumbnail(fileThumbnailIv, bitmapTmp[0]);
    }

    private void handledSingleFileThumbnail(CustomRoundImageView fileThumbnailIv, Bitmap bitmap) {
        fileThumbnailIv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fileThumbnailIv.setBorderRadius(10);
        fileThumbnailIv.setImageBitmap(bitmap);
    }

    public int getDefaultThumbnailResId(String type) {
        int resId = this.mDoubleFiles ? 17304631 : 17304630;
        if (getResources().getString(17042482).equals(type)) {
            int resId2 = this.mDoubleFiles ? 17304623 : 17304622;
            return resId2;
        }
        if (getResources().getString(17042486).equals(type)) {
            int resId3 = this.mDoubleFiles ? 17304633 : 17304632;
            return resId3;
        }
        if (getResources().getString(17042469).equals(type)) {
            int resId4 = this.mDoubleFiles ? 17304611 : 17304610;
            return resId4;
        }
        if (getResources().getString(17042488).equals(type)) {
            int resId5 = this.mDoubleFiles ? 17304637 : 17304636;
            return resId5;
        }
        if (getResources().getString(17042487).equals(type)) {
            int resId6 = this.mDoubleFiles ? 17304635 : 17304634;
            return resId6;
        }
        if (getResources().getString(17042473).equals(type)) {
            int resId7 = this.mDoubleFiles ? 17304613 : 17304612;
            return resId7;
        }
        if (getResources().getString(17042483).equals(type)) {
            int resId8 = this.mDoubleFiles ? 17304625 : 17304624;
            return resId8;
        }
        if (getResources().getString(17042481).equals(type)) {
            int resId9 = this.mDoubleFiles ? 17304621 : 17304620;
            return resId9;
        }
        if (getResources().getString(17042485).equals(type)) {
            if (isShareText()) {
                int resId10 = this.mDoubleFiles ? 17304627 : 17304626;
                return resId10;
            }
            int resId11 = this.mDoubleFiles ? 17304629 : 17304628;
            return resId11;
        }
        if (getResources().getString(17042479).equals(type)) {
            int resId12 = this.mDoubleFiles ? 17304618 : 17304617;
            return resId12;
        }
        return resId;
    }

    public String sharingType(String intentType, ArrayList<Uri> uris) throws Resources.NotFoundException {
        String type = getResources().getString(17042474);
        LogUtils.d("mIntentType  = " + intentType);
        if (intentType == null) {
            return type;
        }
        if (intentType.startsWith("image/")) {
            return getResources().getString(17042482);
        }
        if (intentType.startsWith("video/")) {
            return getResources().getString(17042486);
        }
        if (intentType.startsWith("audio/")) {
            return getResources().getString(17042479);
        }
        if (intentType.startsWith("application/")) {
            if (intentType.startsWith("application/vnd.ms-powerpoint") || intentType.startsWith("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
                return getResources().getString(17042483);
            }
            if (intentType.startsWith("application/vnd.ms-excel") || intentType.startsWith("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
                return getResources().getString(17042473);
            }
            if (intentType.startsWith("application/msword") || intentType.startsWith("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
                return getResources().getString(17042487);
            }
            if (intentType.startsWith("application/pdf")) {
                return getResources().getString(17042481);
            }
            if (intentType.startsWith("application/zip") || intentType.startsWith("application/x-rar-compressed") || intentType.startsWith("application/x-tar")) {
                return getResources().getString(17042488);
            }
            if (intentType.startsWith("application/vnd.android.package-archive") || intentType.startsWith("application/octet-stream")) {
                return getResources().getString(17042469);
            }
            return type;
        }
        if (intentType.startsWith("text/")) {
            return getResources().getString(17042485);
        }
        if (intentType.startsWith("vnd.android.cursor.dir/")) {
            return getResources().getString(17042470);
        }
        return type;
    }

    public String multiUrisType(ArrayList<Uri> uris) throws Resources.NotFoundException {
        String type = getResources().getString(17042474);
        if (uris != null && uris.size() != 0 && Utils.isTypeAllTheSame(this.mActivity, uris)) {
            return singleUriType(uris.get(0));
        }
        return type;
    }

    public String singleUriType(Uri uri) {
        String type = this.mActivity.getContentResolver().getType(uri);
        return sharingType(type, null);
    }

    public boolean isShareText() throws Resources.NotFoundException {
        if (this.mExtraIntent == null) {
            return false;
        }
        ArrayList<Uri> uris = Utils.getIntentUris(this.mExtraIntent);
        if (uris.isEmpty()) {
            return false;
        }
        String type = sharingType(this.mExtraIntentType, uris);
        return getResources().getString(17042485).equals(type) && this.mExtraIntentType.startsWith("text/plain") && uris.get(0) == null;
    }

    private Bitmap createBitmap(Context context, Uri uri, Intent intent, boolean isThumbnail) {
        if (isThumbnail) {
            int width = Utils.dp2px(context, 50.0f);
            return Utils.createUriBitmap(context, uri, intent, width, width, this.mIsSharingScreenshotOrRecod);
        }
        int width2 = this.mIsLandscape ? 490 : 212;
        int height = this.mIsLandscape ? 216 : 376;
        return Utils.createUriBitmap(context, uri, intent, Utils.dp2px(context, width2), Utils.dp2px(context, height), this.mIsSharingScreenshotOrRecod);
    }

    private Bitmap createThumbnail(Uri uri) {
        Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());
        int width = Utils.dp2px(this.mActivity, 50.0f);
        return Utils.scaleBitmap(bitmap, width, width);
    }

    public boolean isSharingUriWithoutScheme(Uri uri) {
        if (uri == null) {
            return false;
        }
        return TextUtils.isEmpty(uri.getScheme());
    }

    private void initFilePolicy() {
        if (shouldInitFilePolicy()) {
            this.mHasFilePolicyInfo = hasLocationInfo() || hasShootingInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldInitFilePolicy() {
        if (!this.mIsSharingScreenshotOrRecod && this.mUris != null && Utils.isTypeImageOrVideo(this.mExtraIntentType)) {
            return true;
        }
        if (this.mUris != null && this.mExtraIntentType != null && this.mExtraIntentType.startsWith("*/*")) {
            Iterator<Uri> it = this.mUris.iterator();
            while (it.hasNext()) {
                Uri uri = it.next();
                if (Utils.isTypeImageOrVideo(uri, this.mActivity)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean confineQuickLookIfPickImage() {
        return this.mExtraIntentType != null && this.mExtraIntentType.startsWith("image/") && Objects.equals(this.mExtraIntent.getAction(), "android.intent.action.PICK");
    }

    protected void updateFilePolicy() {
        this.mFilePolicyType = Utils.getChooserFilePolicyStatus(this.mActivity);
        if (this.mTvFilePolicy == null) {
            this.mTvFilePolicy = sTextViewRef.get();
        }
        if (this.mTvFilePolicy != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.android.internal.chooser.BaseResolverHooker.9
                @Override // java.lang.Runnable
                public void run() {
                    BaseResolverHooker.this.mTvFilePolicy.setText(BaseResolverHooker.this.currentPolicyType());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String currentPolicyType() throws Resources.NotFoundException {
        String text = getResources().getString(17042493);
        switch (this.mFilePolicyType) {
            case 2:
                String text2 = getResources().getString(17042496);
                return text2;
            case 3:
                String text3 = getResources().getString(17042499);
                return text3;
            case 4:
                String text4 = getResources().getString(17042494);
                return text4;
            default:
                return text;
        }
    }

    private boolean hasLocationInfo() {
        Iterator<Uri> it = this.mUris.iterator();
        while (it.hasNext()) {
            Uri uri = it.next();
            if (Utils.isTypeImage(this.mActivity, uri, this.mExtraIntent) && Utils.hasImageLocationInfo(uri)) {
                return true;
            }
            if (Utils.isTypeVideo(this.mActivity, uri, this.mExtraIntent) && Utils.hasVideoLocationInfo(this.mActivity, uri)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasShootingInfo() {
        Iterator<Uri> it = this.mUris.iterator();
        while (it.hasNext()) {
            Uri uri = it.next();
            if (Utils.isTypeImage(this.mActivity, uri, this.mExtraIntent) && Utils.hasImageShootingInfo(uri)) {
                return true;
            }
            if (Utils.isTypeVideo(this.mActivity, uri, this.mExtraIntent) && Utils.hasVideoShootingInfo(this.mActivity, uri)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNeedSkipCaptureScreenshot() {
        return this.mExtraIntent != null && this.mExtraIntent.getBooleanExtra("needSkipCaptureScreenshot", false);
    }

    public static void addStepOSWindowFlags(WindowManager.LayoutParams layoutParams, int flag) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        LogUtils.d("addStepOSWindowFlags 0 flag: " + flag);
        try {
            try {
                Field field = layoutParams.getClass().getField("steposFlags");
                int steposFlags = field.getInt(layoutParams);
                field.setInt(layoutParams, steposFlags | flag);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                LogUtils.d("addStepOSWindowFlags: e= " + e.getMessage());
            }
            LogUtils.d("addStepOSWindowFlags 1 flag: " + flag);
        } catch (Exception e2) {
            LogUtils.d("addStepOSWindowFlags: e= " + e2.getMessage());
        }
    }

    public static int getStepOSSkipTaskFlag(WindowManager.LayoutParams winParams) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        LogUtils.d("getStepOSSkipTaskFlag");
        try {
            Field f = winParams.getClass().getDeclaredField(STEPOS_FLAG_SKIP_TASK_SCREENSHOT);
            f.setAccessible(true);
            int steposFlags = f.getInt(winParams);
            return steposFlags;
        } catch (Exception e) {
            LogUtils.d("getStepOSSkipTaskFlag e: " + e.getMessage());
            return -1;
        }
    }
}
