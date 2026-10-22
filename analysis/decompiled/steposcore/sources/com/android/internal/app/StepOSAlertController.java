package com.android.internal.app;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentExt;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.StepOSCtsUtils;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.Layout;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.Space;
import android.widget.TextView;
import com.android.internal.app.AlertController;
import com.android.internal.chooser.utils.StepOSPressAnimationHelper;
import com.android.internal.widget.StepOSAlertDialogLayout;
import com.stepos.settings.config.StepOSSettingsKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class StepOSAlertController extends AlertController {
    private static final int BIT_BUTTON_NEGATIVE_FLAG = 2;
    private static final int BIT_BUTTON_NEUTRAL_FLAG = 4;
    private static final int BIT_BUTTON_POSITIVE_FLAG = 1;
    private static final AdaptiveCallback DEFAULT_CALLBACK;
    private static final int HAS_BUTTON_PANEL = 4;
    private static final int HAS_CONTENT_PANEL = 2;
    private static final int HAS_TOP_PANEL = 1;
    private static final int POLE_STAR_BUTTON_DISABLE_TEXT_COLOR = 1090483456;
    private boolean hasCustomView;
    private boolean mActionDialog;
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private int mAlertDialogWidth;
    private boolean mAutoShowSoftInput;
    private final View.OnClickListener mButtonHandler;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem;
    private final Context mContext;
    private boolean mCustomPaddingRule;
    private View mCustomTitleView;
    private float mDensityRatio;
    final DialogInterface mDialog;
    private int mDividerHeight;
    private int mGravity;
    Handler mHandler;
    private int mHighLightButton;
    private int mHighLightColor;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private int mMaxHeight;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    private int mPaddingSpace1;
    private int mPaddingSpace2;
    private int mPaddingSpace3;
    private int mPaddingSpace4;
    ScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private LayoutInjector mStepOSLayoutInjector;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;
    private final StepOSPressAnimationHelper mzPressAnimationHelper;
    private static boolean mIsPoleStarTheme = false;
    private static List<PaddingRule> sPaddingRules = new ArrayList();
    private static List<PaddingRule> sSingleMessagePaddingRules = new ArrayList();
    private static List<PaddingRule> sCustomViewRules = new ArrayList();
    private static List<PaddingRule> sActionListPaddingRules = new ArrayList();
    private static List<PaddingRule> sListPaddingRules = new ArrayList();

    public interface AdaptiveCallback {
        void measure(TextView textView, int i, int i2);

        void setTextSize(TextView textView, int i, float f);
    }

    private interface LayoutInjector {
        int getAlertDialogLayout();

        int getListLayout();
    }

    static {
        sPaddingRules.add(new PaddingRule(7, 38, 22, 38, 24));
        sPaddingRules.add(new PaddingRule(3, 38, 22, 0, 24));
        sPaddingRules.add(new PaddingRule(5, 38, 0, 38, 24));
        sPaddingRules.add(new PaddingRule(1, 38, 0, 0, 24));
        sPaddingRules.add(new PaddingRule(6, 0, 26, 38, 24));
        sPaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sPaddingRules.add(new PaddingRule(4, 0, 0, 10, 24));
        sPaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(7, 38, 6, 38, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(3, 38, 6, 0, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(5, 38, 0, 38, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(1, 38, 0, 0, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(6, 0, 26, 38, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sSingleMessagePaddingRules.add(new PaddingRule(4, 0, 0, 10, 24));
        sSingleMessagePaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sCustomViewRules.add(new PaddingRule(7, 38, 22, 38, 24));
        sCustomViewRules.add(new PaddingRule(3, 38, 22, 0, 24));
        sCustomViewRules.add(new PaddingRule(5, 38, 0, 38, 24));
        sCustomViewRules.add(new PaddingRule(1, 38, 0, 0, 24));
        sCustomViewRules.add(new PaddingRule(6, 0, 0, 38, 24));
        sCustomViewRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sCustomViewRules.add(new PaddingRule(4, 0, 0, 10, 24));
        sCustomViewRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sListPaddingRules.add(new PaddingRule(7, 38, 26, 12, 0));
        sListPaddingRules.add(new PaddingRule(3, 38, 26, 0, 0));
        sListPaddingRules.add(new PaddingRule(5, 38, 0, 12, 0));
        sListPaddingRules.add(new PaddingRule(1, 38, 24, 0, 0));
        sListPaddingRules.add(new PaddingRule(6, 0, 26, 12, 0));
        sListPaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sListPaddingRules.add(new PaddingRule(4, 0, 0, 0, 0));
        sListPaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        sActionListPaddingRules.add(new PaddingRule(7, 38, 26, 12, 0));
        sActionListPaddingRules.add(new PaddingRule(3, 38, 26, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(5, 38, 0, 12, 0));
        sActionListPaddingRules.add(new PaddingRule(1, 38, 24, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(6, 0, 26, 12, 0));
        sActionListPaddingRules.add(new PaddingRule(2, 0, 0, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(4, 0, 0, 0, 0));
        sActionListPaddingRules.add(new PaddingRule(0, 10, 0, 0, 24));
        DEFAULT_CALLBACK = new AdaptiveCallback() { // from class: com.android.internal.app.StepOSAlertController.7
            @Override // com.android.internal.app.StepOSAlertController.AdaptiveCallback
            public void measure(TextView view, int widthMeasureSpec, int heightMeasureSpec) {
                view.measure(widthMeasureSpec, heightMeasureSpec);
            }

            @Override // com.android.internal.app.StepOSAlertController.AdaptiveCallback
            public void setTextSize(TextView view, int unit, float textSize) {
                view.setTextSize(unit, textSize);
            }
        };
    }

    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialog) {
            this.mDialog = new WeakReference<>(dialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -3:
                case StepOSWindowManager.LAYOUT_IN_DISPLAY_CUTOUT_MODE_UNSET /* -2 */:
                case -1:
                    ((DialogInterface.OnClickListener) msg.obj).onClick(this.mDialog.get(), msg.what);
                    break;
                case 1:
                    ((DialogInterface) msg.obj).dismiss();
                    break;
            }
        }
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(R.^attr-private.allowAutoRevokePermissionsExemption, outValue, true);
        return outValue.data != 0;
    }

    public static int getLightAlertDialogTheme() {
        return R.style.Widget.Holo.Light.ActivityChooserView;
    }

    public static int getAppErrorDialogTheme() {
        if (StepOSCtsUtils.isCtsRunning()) {
            return R.style.Theme.Material.Light.Dialog.NoActionBar.FixedSize;
        }
        return R.style.Widget.Holo.Light.ActivityChooserView;
    }

    public StepOSAlertController(Context context, DialogInterface di, Window window) {
        super(context, di, window);
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mAutoShowSoftInput = true;
        this.mHighLightColor = 1;
        this.mzPressAnimationHelper = new StepOSPressAnimationHelper();
        this.mButtonHandler = new View.OnClickListener() { // from class: com.android.internal.app.StepOSAlertController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Message m;
                if (v == StepOSAlertController.this.mButtonPositive && StepOSAlertController.this.mButtonPositiveMessage != null) {
                    m = Message.obtain(StepOSAlertController.this.mButtonPositiveMessage);
                } else if (v == StepOSAlertController.this.mButtonNegative && StepOSAlertController.this.mButtonNegativeMessage != null) {
                    m = Message.obtain(StepOSAlertController.this.mButtonNegativeMessage);
                } else if (v == StepOSAlertController.this.mButtonNeutral && StepOSAlertController.this.mButtonNeutralMessage != null) {
                    m = Message.obtain(StepOSAlertController.this.mButtonNeutralMessage);
                } else {
                    m = null;
                }
                if (m != null) {
                    m.sendToTarget();
                }
                StepOSAlertController.this.mHandler.obtainMessage(1, StepOSAlertController.this.mDialog).sendToTarget();
            }
        };
        this.mStepOSLayoutInjector = new LayoutInjector(this) { // from class: com.android.internal.app.StepOSAlertController.6
            @Override // com.android.internal.app.StepOSAlertController.LayoutInjector
            public int getAlertDialogLayout() {
                return 17367438;
            }

            @Override // com.android.internal.app.StepOSAlertController.LayoutInjector
            public int getListLayout() {
                return 17367439;
            }
        };
        this.mContext = context;
        this.mDialog = di;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(di);
        TypedArray a = context.obtainStyledAttributes(null, com.android.internal.R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = this.mStepOSLayoutInjector.getAlertDialogLayout();
        this.mButtonPanelSideLayout = a.getResourceId(11, 0);
        this.mListLayout = this.mStepOSLayoutInjector.getListLayout();
        this.mMultiChoiceItemLayout = a.getResourceId(16, 0);
        this.mSingleChoiceItemLayout = a.getResourceId(21, 0);
        this.mListItemLayout = a.getResourceId(14, 0);
        this.mShowTitle = a.getBoolean(20, true);
        this.mButtonIconDimen = dp2px(this.mContext, 48.0f);
        this.mActionDialog = false;
        this.mCustomPaddingRule = false;
        this.mPaddingSpace1 = 0;
        this.mPaddingSpace2 = 0;
        this.mPaddingSpace3 = 0;
        this.mPaddingSpace4 = 0;
        a.recycle();
        window.requestFeature(1);
        try {
            mIsPoleStarTheme = SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (IllegalArgumentException e) {
            Log.e("StepOSAlertController", "get ro.stepos.build.channel error");
        }
        int width = Math.min(getScreenWidth(), getScreenHeight());
        this.mAlertDialogWidth = width - (this.mContext.getResources().getDimensionPixelOffset(17106049) * 2);
        this.mDensityRatio = 1.0f;
        this.mDividerHeight = this.mContext.getResources().getDimensionPixelOffset(17106029);
    }

    static boolean canTextInput(View v) {
        if (v.onCheckIsTextEditor()) {
            return true;
        }
        if (!(v instanceof ViewGroup)) {
            return false;
        }
        ViewGroup vg = (ViewGroup) v;
        int i = vg.getChildCount();
        while (i > 0) {
            i--;
            if (canTextInput(vg.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    public void installContent(AlertController.AlertParams params) throws Resources.NotFoundException {
        params.apply(this);
        installContent();
    }

    public void installContent() throws Resources.NotFoundException {
        int contentView = selectContentView();
        this.mWindow.setContentView(contentView);
        resetIds();
        setupView();
        applyStepOSStyle();
    }

    private void resetIds() {
        resetId(R.id.showVoiceSearchButton, R.id.showVoiceSearchButton);
        resetId(16910096, 16910096);
        resetId(16910085, 16910085);
        resetId(R.id.autofill_dataset_picker, R.id.autofill_dataset_picker);
        resetId(R.id.disableHome, R.id.disableHome);
        resetId(R.id.twelvekey, R.id.twelvekey);
        resetId(R.id.find_next, R.id.find_next);
        resetId(R.id.collapsing, R.id.collapsing);
    }

    private void resetId(int from, int to) {
        View view = this.mWindow.findViewById(from);
        if (view != null) {
            view.setId(to);
        }
    }

    private int selectContentView() {
        if (this.mButtonPanelSideLayout == 0) {
            return this.mAlertDialogLayout;
        }
        if (this.mButtonPanelLayoutHint == 1) {
            return this.mButtonPanelSideLayout;
        }
        return this.mAlertDialogLayout;
    }

    public void setTitle(CharSequence title) {
        this.mTitle = title;
        if (this.mTitleView != null) {
            this.mTitleView.setText(title);
        }
    }

    public void setCustomTitle(View customTitleView) {
        this.mCustomTitleView = customTitleView;
    }

    public void setMessage(CharSequence message) {
        this.mMessage = message;
        if (this.mMessageView != null) {
            this.mMessageView.setText(message);
            this.mMessageView.setVisibility(0);
        }
    }

    public void setView(int layoutResId) {
        this.mView = null;
        this.mViewLayoutResId = layoutResId;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = viewSpacingLeft;
        this.mViewSpacingTop = viewSpacingTop;
        this.mViewSpacingRight = viewSpacingRight;
        this.mViewSpacingBottom = viewSpacingBottom;
    }

    public void setButtonPanelLayoutHint(int layoutHint) {
        this.mButtonPanelLayoutHint = layoutHint;
    }

    public void setButton(int whichButton, CharSequence text, DialogInterface.OnClickListener listener, Message msg) {
        setButton(whichButton, text, listener, msg, null);
    }

    public void setButton(int whichButton, CharSequence text, DialogInterface.OnClickListener listener, Message msg, Drawable icon) {
        if (msg == null && listener != null) {
            msg = this.mHandler.obtainMessage(whichButton, listener);
        }
        switch (whichButton) {
            case -3:
                this.mButtonNeutralText = text;
                this.mButtonNeutralMessage = msg;
                this.mButtonNeutralIcon = icon;
                return;
            case StepOSWindowManager.LAYOUT_IN_DISPLAY_CUTOUT_MODE_UNSET /* -2 */:
                this.mButtonNegativeText = text;
                this.mButtonNegativeMessage = msg;
                this.mButtonNegativeIcon = icon;
                return;
            case -1:
                this.mButtonPositiveText = text;
                this.mButtonPositiveMessage = msg;
                this.mButtonPositiveIcon = icon;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setIcon(int resId) {
        this.mIcon = null;
        this.mIconId = resId;
        if (this.mIconView != null) {
            if (resId != 0) {
                this.mIconView.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
            } else {
                this.mIconView.setVisibility(8);
            }
        }
    }

    public void setIcon(Drawable icon) {
        this.mIcon = icon;
        this.mIconId = 0;
        if (this.mIconView != null) {
            if (icon != null) {
                this.mIconView.setVisibility(0);
                this.mIconView.setImageDrawable(icon);
            } else {
                this.mIconView.setVisibility(8);
            }
        }
    }

    public int getIconAttributeResId(int attrId) {
        TypedValue out = new TypedValue();
        this.mContext.getTheme().resolveAttribute(attrId, out, true);
        return out.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public Button getButton(int whichButton) {
        switch (whichButton) {
            case -3:
                return this.mButtonNeutral;
            case StepOSWindowManager.LAYOUT_IN_DISPLAY_CUTOUT_MODE_UNSET /* -2 */:
                return this.mButtonNegative;
            case -1:
                return this.mButtonPositive;
            default:
                return null;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return this.mScrollView != null && this.mScrollView.executeKeyEvent(event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return this.mScrollView != null && this.mScrollView.executeKeyEvent(event);
    }

    private ViewGroup resolvePanel(View customPanel, View defaultPanel) {
        if (customPanel == null) {
            if (defaultPanel instanceof ViewStub) {
                defaultPanel = ((ViewStub) defaultPanel).inflate();
            }
            return (ViewGroup) defaultPanel;
        }
        if (defaultPanel != null) {
            ViewParent parent = defaultPanel.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(defaultPanel);
            }
        }
        if (customPanel instanceof ViewStub) {
            customPanel = ((ViewStub) customPanel).inflate();
        }
        return (ViewGroup) customPanel;
    }

    private void setupView() throws Resources.NotFoundException {
        int i;
        View spacer;
        View spacer2;
        View parentPanel = this.mWindow.findViewById(R.id.showVoiceSearchButton);
        View defaultTopPanel = parentPanel.findViewById(16910096);
        View defaultContentPanel = parentPanel.findViewById(R.id.disableHome);
        View defaultButtonPanel = parentPanel.findViewById(R.id.collapsing);
        ViewGroup customPanel = (ViewGroup) parentPanel.findViewById(R.id.find_next);
        setupCustomContent(customPanel);
        View customTopPanel = customPanel.findViewById(16910096);
        View customContentPanel = customPanel.findViewById(R.id.disableHome);
        View customButtonPanel = customPanel.findViewById(R.id.collapsing);
        ViewGroup topPanel = resolvePanel(customTopPanel, defaultTopPanel);
        ViewGroup contentPanel = resolvePanel(customContentPanel, defaultContentPanel);
        ViewGroup buttonPanel = resolvePanel(customButtonPanel, defaultButtonPanel);
        setupContent(contentPanel);
        setupButtons(buttonPanel);
        setupTitle(topPanel);
        boolean hasCustomPanel = (customPanel == null || customPanel.getVisibility() == 8) ? false : true;
        boolean hasTopPanel = (topPanel == null || topPanel.getVisibility() == 8) ? false : true;
        boolean hasButtonPanel = (buttonPanel == null || buttonPanel.getVisibility() == 8) ? false : true;
        if (!hasButtonPanel && contentPanel != null && (spacer2 = contentPanel.findViewById(16910053)) != null) {
            spacer2.setVisibility(0);
        }
        if (hasTopPanel) {
            if (this.mScrollView != null) {
                this.mScrollView.setClipToPadding(true);
            }
            View divider = null;
            if (this.mMessage != null || this.mListView != null) {
                divider = topPanel.findViewById(16910076);
            }
            if (divider != null) {
                divider.setVisibility(0);
            }
            i = 0;
        } else if (contentPanel == null || (spacer = contentPanel.findViewById(16910054)) == null) {
            i = 0;
        } else {
            i = 0;
            spacer.setVisibility(0);
        }
        if (this.mListView instanceof RecycleListView) {
            ((RecycleListView) this.mListView).setHasDecor(hasTopPanel, hasButtonPanel);
        }
        if (!hasCustomPanel && !this.mActionDialog) {
            View content = this.mListView != null ? this.mListView : this.mScrollView;
            if (content != null) {
                int i2 = hasTopPanel ? 1 : i;
                if (hasButtonPanel) {
                    i = 2;
                }
                int indicators = i2 | i;
                setScrollIndicators(contentPanel, content, indicators, 3);
            }
        }
        ListView listView = this.mListView;
        if (listView != null && this.mAdapter != null) {
            listView.setAdapter(this.mAdapter);
            int checkedItem = this.mCheckedItem;
            if (checkedItem > -1) {
                listView.setItemChecked(checkedItem, true);
                listView.setSelection(checkedItem);
            }
        }
        setupSpaceView(topPanel, contentPanel, customPanel, buttonPanel);
    }

    private void setScrollIndicators(ViewGroup contentPanel, View content, int indicators, int mask) {
        View indicatorUp = this.mWindow.findViewById(R.id.turn_off_screen);
        View indicatorDown = this.mWindow.findViewById(R.id.turkish_q);
        if (indicatorUp != null && (indicators & 1) == 0) {
            contentPanel.removeView(indicatorUp);
            indicatorUp = null;
        }
        if (indicatorDown != null && (indicators & 2) == 0) {
            contentPanel.removeView(indicatorDown);
            indicatorDown = null;
        }
        if (indicatorUp != null || indicatorDown != null) {
            final View top = indicatorUp;
            final View bottom = indicatorDown;
            if (this.mMessage != null) {
                this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener(this) { // from class: com.android.internal.app.StepOSAlertController.2
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                        StepOSAlertController.manageScrollIndicators(v, top, bottom);
                    }
                });
                this.mScrollView.postDelayed(new Runnable() { // from class: com.android.internal.app.StepOSAlertController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        StepOSAlertController.manageScrollIndicators(StepOSAlertController.this.mScrollView, top, bottom);
                    }
                }, 100L);
            } else {
                if (this.mListView != null) {
                    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener(this) { // from class: com.android.internal.app.StepOSAlertController.4
                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScrollStateChanged(AbsListView view, int scrollState) {
                        }

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScroll(AbsListView v, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                            StepOSAlertController.manageScrollIndicators(v, top, bottom);
                        }
                    });
                    this.mListView.postDelayed(new Runnable() { // from class: com.android.internal.app.StepOSAlertController.5
                        @Override // java.lang.Runnable
                        public void run() {
                            StepOSAlertController.manageScrollIndicators(StepOSAlertController.this.mListView, top, bottom);
                        }
                    }, 100L);
                    return;
                }
                if (top != null) {
                    contentPanel.removeView(top);
                }
                if (bottom != null) {
                    contentPanel.removeView(bottom);
                }
            }
        }
    }

    private void setupCustomContent(ViewGroup customPanel) {
        View customView;
        if (this.mView != null) {
            customView = this.mView;
        } else if (this.mViewLayoutResId != 0) {
            LayoutInflater inflater = LayoutInflater.from(this.mContext);
            customView = inflater.inflate(this.mViewLayoutResId, customPanel, false);
        } else {
            customView = null;
        }
        this.hasCustomView = customView != null;
        if (!this.hasCustomView || !canTextInput(customView)) {
            this.mWindow.setFlags(IntentExt.STEPOS_FLAG_PREVIEW_ON_KEYGUARD, IntentExt.STEPOS_FLAG_PREVIEW_ON_KEYGUARD);
        }
        if (this.hasCustomView) {
            FrameLayout custom = (FrameLayout) this.mWindow.findViewById(R.id.custom);
            custom.addView(customView, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                custom.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView != null) {
                ((LinearLayout.LayoutParams) customPanel.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        customPanel.setVisibility(8);
    }

    protected void setupTitle(ViewGroup topPanel) {
        if (this.mCustomTitleView != null) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(-1, -2);
            topPanel.addView(this.mCustomTitleView, 0, lp);
            View titleTemplate = this.mWindow.findViewById(16910085);
            titleTemplate.setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
        boolean hasTextTitle = !TextUtils.isEmpty(this.mTitle);
        if (hasTextTitle && this.mShowTitle) {
            this.mTitleView = (TextView) this.mWindow.findViewById(R.id.autofill_dataset_picker);
            if (this.mTitleView != null) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setFallbackLineSpacing(false);
                this.mTitleView.setTextDirection(5);
            }
            if (this.mIconId != 0) {
                this.mIconView.setImageResource(this.mIconId);
                return;
            } else if (this.mIcon != null) {
                this.mIconView.setImageDrawable(this.mIcon);
                return;
            } else {
                this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                this.mIconView.setVisibility(8);
                return;
            }
        }
        View titleTemplate2 = this.mWindow.findViewById(16910085);
        titleTemplate2.setVisibility(8);
        this.mIconView.setVisibility(8);
        topPanel.setVisibility(8);
    }

    protected void setupContent(ViewGroup contentPanel) {
        this.mScrollView = (ScrollView) this.mWindow.findViewById(R.id.twelvekey);
        this.mScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        this.mMessageView = (TextView) contentPanel.findViewById(R.id.message);
        if (this.mMessageView == null) {
            return;
        }
        this.mMessageView.setFallbackLineSpacing(false);
        if (this.mMessage != null) {
            this.mMessageView.setText(this.mMessage);
            this.mMessageView.setVisibility(0);
            return;
        }
        this.mMessageView.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView != null) {
            ViewGroup scrollParent = (ViewGroup) this.mScrollView.getParent();
            int childIndex = scrollParent.indexOfChild(this.mScrollView);
            scrollParent.removeViewAt(childIndex);
            scrollParent.addView(this.mListView, childIndex, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        contentPanel.setVisibility(8);
    }

    static void manageScrollIndicators(View v, View upIndicator, View downIndicator) {
        if (upIndicator != null) {
            upIndicator.setVisibility(v.canScrollVertically(-1) ? 0 : 4);
        }
        if (downIndicator != null) {
            downIndicator.setVisibility(v.canScrollVertically(1) ? 0 : 4);
        }
    }

    protected void setupButtons(ViewGroup buttonPanel) throws Resources.NotFoundException {
        int whichButtons = 0;
        this.mButtonPositive = (Button) buttonPanel.findViewById(R.id.button1);
        this.mzPressAnimationHelper.addTargetView(this.mButtonPositive, false);
        this.mButtonPositive.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonPositiveText) && this.mButtonPositiveIcon == null) {
            this.mButtonPositive.setVisibility(8);
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            if (this.mButtonPositiveIcon != null) {
                this.mButtonPositiveIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonPositive.setVisibility(0);
            whichButtons = 0 | 1;
        }
        this.mButtonNegative = (Button) buttonPanel.findViewById(R.id.button2);
        this.mzPressAnimationHelper.addTargetView(this.mButtonNegative, false);
        this.mButtonNegative.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText) && this.mButtonNegativeIcon == null) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            if (this.mButtonNegativeIcon != null) {
                this.mButtonNegativeIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
            }
            this.mButtonNegative.setVisibility(0);
            whichButtons |= 2;
        }
        this.mButtonNeutral = (Button) buttonPanel.findViewById(R.id.button3);
        this.mzPressAnimationHelper.addTargetView(this.mButtonNeutral, false);
        this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText) && this.mButtonNeutralIcon == null) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            if (this.mButtonPositiveIcon != null) {
                this.mButtonPositiveIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonNeutral.setVisibility(0);
            whichButtons |= 4;
        }
        boolean hasButtons = whichButtons != 0;
        if (!hasButtons) {
            buttonPanel.setVisibility(8);
            return;
        }
        if (!(this.mButtonNeutral.getParent() instanceof LinearLayout)) {
            return;
        }
        LinearLayout layout = (LinearLayout) this.mButtonNeutral.getParent();
        if (isButtonLayoutVertical(whichButtons)) {
            layout.setOrientation(1);
            layout.setGravity(1);
            layout.removeAllViews();
            if (this.mActionDialog || this.mListView != null) {
                View divider = new View(this.mContext);
                divider.setBackgroundColor(this.mContext.getColor(R.color.kg_widget_pager_gradient));
                ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(-1, this.mDividerHeight);
                int margin = this.mContext.getResources().getDimensionPixelOffset(17106061);
                lp.setMargins(margin, 0, margin, 0);
                layout.addView(divider, lp);
            }
            layout.addView(this.mButtonPositive);
            layout.addView(this.mButtonNeutral);
            layout.addView(this.mButtonNegative);
            int highlightIndex = calcButtonHighLight(whichButtons);
            applyVerticalButtonStyle(this.mButtonPositive, 1, whichButtons, 1 == highlightIndex);
            applyVerticalButtonStyle(this.mButtonNegative, 2, whichButtons, 2 == highlightIndex);
            applyVerticalButtonStyle(this.mButtonNeutral, 4, whichButtons, 4 == highlightIndex);
            return;
        }
        layout.setOrientation(0);
        layout.setGravity(1);
        int highlightIndex2 = calcButtonHighLight(whichButtons);
        applyHorizontalButtonStyle(this.mButtonPositive, 1, whichButtons, 1 == highlightIndex2);
        applyHorizontalButtonStyle(this.mButtonNegative, 2, whichButtons, 2 == highlightIndex2);
        applyHorizontalButtonStyle(this.mButtonNeutral, 4, whichButtons, 4 == highlightIndex2);
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = 1;
        params.weight = 0.5f;
        button.setLayoutParams(params);
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.mPaddingTopNoTitle = 0;
            this.mPaddingBottomNoButtons = 0;
        }

        public void setHasDecor(boolean hasTitle, boolean hasButtons) {
            if (!hasButtons || !hasTitle) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = hasTitle ? getPaddingTop() : this.mPaddingTopNoTitle;
                int paddingRight = getPaddingRight();
                int paddingBottom = hasButtons ? getPaddingBottom() : this.mPaddingBottomNoButtons;
                setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private static class ListItemCenterAdapter extends ArrayAdapter {
        Context context;
        private int resourceId;
        CharSequence[] strings;
        ColorStateList textColor;
        ColorStateList[] textColors;
        private int textViewResourceId;

        public ListItemCenterAdapter(Context context, int resource, int textViewResourceId, CharSequence[] objects, ColorStateList color) {
            super(context, resource, textViewResourceId, objects);
            this.context = context;
            this.resourceId = resource;
            this.textViewResourceId = textViewResourceId;
            this.strings = objects;
            this.textColor = color;
        }

        public ListItemCenterAdapter(Context context, int resource, int textViewResourceId, CharSequence[] objects, ColorStateList[] colors) {
            super(context, resource, textViewResourceId, objects);
            this.context = context;
            this.resourceId = resource;
            this.textViewResourceId = textViewResourceId;
            this.strings = objects;
            this.textColors = colors;
        }

        public ListItemCenterAdapter(Context context, int resource, int textViewResourceId, CharSequence[] objects) {
            super(context, resource, textViewResourceId, objects);
            this.context = context;
            this.resourceId = resource;
            this.textViewResourceId = textViewResourceId;
            this.strings = objects;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
                convertView = inflater.inflate(this.resourceId, (ViewGroup) null);
                holder = new ViewHolder();
                holder.item = (TextView) convertView.findViewById(this.textViewResourceId);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.item.setText(this.strings[position]);
            if (this.textColors != null) {
                holder.item.setTextColor(this.textColors[position]);
            } else if (this.textColor != null) {
                holder.item.setTextColor(this.textColor);
            }
            return convertView;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }
    }

    private static class ViewHolder {
        public TextView item;

        private ViewHolder() {
        }
    }

    public static class AlertParamsWrapper {
        private AlertController.AlertParams mAlertParams;

        public AlertParamsWrapper(AlertController.AlertParams alertParams) {
            this.mAlertParams = alertParams;
        }

        public void apply(StepOSAlertController dialog) throws Resources.NotFoundException {
            StepOSAlertController dialog2;
            if (this.mAlertParams.mCustomTitleView != null) {
                dialog.setCustomTitle(this.mAlertParams.mCustomTitleView);
            } else {
                if (this.mAlertParams.mTitle != null) {
                    dialog.setTitle(this.mAlertParams.mTitle);
                }
                if (this.mAlertParams.mIcon != null) {
                    dialog.setIcon(this.mAlertParams.mIcon);
                }
                if (this.mAlertParams.mIconId != 0) {
                    dialog.setIcon(this.mAlertParams.mIconId);
                }
                if (this.mAlertParams.mIconAttrId != 0) {
                    dialog.setIcon(dialog.getIconAttributeResId(this.mAlertParams.mIconAttrId));
                }
            }
            if (this.mAlertParams.mMessage != null) {
                dialog.setMessage(this.mAlertParams.mMessage);
            }
            if (this.mAlertParams.mPositiveButtonText == null) {
                dialog2 = dialog;
            } else {
                dialog.setButton(-1, this.mAlertParams.mPositiveButtonText, this.mAlertParams.mPositiveButtonListener, null, null);
                dialog2 = dialog;
            }
            if (this.mAlertParams.mNegativeButtonText != null) {
                dialog2.setButton(-2, this.mAlertParams.mNegativeButtonText, this.mAlertParams.mNegativeButtonListener, null, null);
            }
            if (this.mAlertParams.mNeutralButtonText != null) {
                dialog2.setButton(-3, this.mAlertParams.mNeutralButtonText, this.mAlertParams.mNeutralButtonListener, null, null);
            }
            if (this.mAlertParams.mItems != null || this.mAlertParams.mCursor != null || this.mAlertParams.mAdapter != null) {
                createListView(dialog2);
                if (this.mAlertParams.mNegativeButtonText == null && this.mAlertParams.mPositiveButtonText == null && this.mAlertParams.mNeutralButtonText == null) {
                    dialog2.setButton(-2, this.mAlertParams.mContext.getText(R.string.cancel), new OnNegativeListener(), null, null);
                }
            }
            if (this.mAlertParams.mView != null) {
                if (this.mAlertParams.mViewSpacingSpecified) {
                    dialog2.setView(this.mAlertParams.mView, this.mAlertParams.mViewSpacingLeft, this.mAlertParams.mViewSpacingTop, this.mAlertParams.mViewSpacingRight, this.mAlertParams.mViewSpacingBottom);
                } else {
                    dialog2.setView(this.mAlertParams.mView);
                }
            } else if (this.mAlertParams.mViewLayoutResId != 0) {
                dialog2.setView(this.mAlertParams.mViewLayoutResId);
            }
            dialog2.setGravity(this.mAlertParams.mGravity);
            dialog2.setMaxHeight(this.mAlertParams.mMaxHeight);
            dialog2.setHighLightButton(this.mAlertParams.mHighLightButton, this.mAlertParams.mHighLightColor);
        }

        private class OnNegativeListener implements DialogInterface.OnClickListener {
            private OnNegativeListener(AlertParamsWrapper alertParamsWrapper) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        }

        private void createListView(StepOSAlertController dialog) throws Resources.NotFoundException {
            AlertParamsWrapper alertParamsWrapper;
            final StepOSAlertController dialog2;
            int listViewLayout;
            int layout;
            ListAdapter adapter;
            final RecycleListView listView = (RecycleListView) this.mAlertParams.mInflater.inflate(dialog.mListLayout, (ViewGroup) null);
            if (this.mAlertParams.mIsMultiChoice) {
                listViewLayout = dialog.mMultiChoiceItemLayout;
                if (this.mAlertParams.mCursor == null) {
                    alertParamsWrapper = this;
                    adapter = new ArrayAdapter<CharSequence>(this.mAlertParams.mContext, dialog.mMultiChoiceItemLayout, R.id.text1, this.mAlertParams.mItems) { // from class: com.android.internal.app.StepOSAlertController.AlertParamsWrapper.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            if (StepOSAlertController.mIsPoleStarTheme) {
                                view.setBackgroundResource(17304335);
                            }
                            if (AlertParamsWrapper.this.mAlertParams.mCheckedItems != null) {
                                boolean isItemChecked = AlertParamsWrapper.this.mAlertParams.mCheckedItems[position];
                                if (isItemChecked) {
                                    listView.setItemChecked(position, true);
                                }
                            }
                            return view;
                        }
                    };
                    listView = listView;
                    dialog2 = dialog;
                } else {
                    alertParamsWrapper = this;
                    dialog2 = dialog;
                    adapter = new CursorAdapter(alertParamsWrapper.mAlertParams.mContext, alertParamsWrapper.mAlertParams.mCursor, false) { // from class: com.android.internal.app.StepOSAlertController.AlertParamsWrapper.2
                        private final int mIsCheckedIndex;
                        private final int mLabelIndex;

                        {
                            Cursor cursor = getCursor();
                            this.mLabelIndex = cursor.getColumnIndexOrThrow(AlertParamsWrapper.this.mAlertParams.mLabelColumn);
                            this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(AlertParamsWrapper.this.mAlertParams.mIsCheckedColumn);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            CheckedTextView text = (CheckedTextView) view.findViewById(R.id.text1);
                            text.setText(cursor.getString(this.mLabelIndex));
                            listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.mIsCheckedIndex) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup parent) {
                            return AlertParamsWrapper.this.mAlertParams.mInflater.inflate(dialog2.mMultiChoiceItemLayout, parent, false);
                        }
                    };
                }
            } else {
                alertParamsWrapper = this;
                dialog2 = dialog;
                if (alertParamsWrapper.mAlertParams.mIsSingleChoice) {
                    int layout2 = dialog2.mSingleChoiceItemLayout;
                    listViewLayout = layout2;
                    layout = layout2;
                } else {
                    int listViewLayout2 = dialog2.mListItemLayout;
                    listViewLayout = listViewLayout2;
                    layout = listViewLayout2;
                }
                if (alertParamsWrapper.mAlertParams.mCursor != null) {
                    adapter = new SimpleCursorAdapter(alertParamsWrapper.mAlertParams.mContext, layout, alertParamsWrapper.mAlertParams.mCursor, new String[]{alertParamsWrapper.mAlertParams.mLabelColumn}, new int[]{R.id.text1});
                } else if (alertParamsWrapper.mAlertParams.mAdapter != null) {
                    adapter = alertParamsWrapper.mAlertParams.mAdapter;
                    listViewLayout = 0;
                } else {
                    adapter = new CheckedItemAdapter(alertParamsWrapper.mAlertParams.mContext, layout, R.id.text1, alertParamsWrapper.mAlertParams.mItems);
                }
            }
            if (alertParamsWrapper.mAlertParams.mOnPrepareListViewListener != null) {
                alertParamsWrapper.mAlertParams.mOnPrepareListViewListener.onPrepareListView(listView);
            }
            dialog2.mAdapter = adapter;
            dialog2.mCheckedItem = alertParamsWrapper.mAlertParams.mCheckedItem;
            if (alertParamsWrapper.mAlertParams.mOnClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.internal.app.StepOSAlertController.AlertParamsWrapper.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        AlertParamsWrapper.this.mAlertParams.mOnClickListener.onClick(dialog2.mDialog, position);
                        if (!AlertParamsWrapper.this.mAlertParams.mIsSingleChoice) {
                            dialog2.mDialog.dismiss();
                        }
                    }
                });
            } else if (alertParamsWrapper.mAlertParams.mOnCheckboxClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.internal.app.StepOSAlertController.AlertParamsWrapper.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        if (AlertParamsWrapper.this.mAlertParams.mCheckedItems != null) {
                            AlertParamsWrapper.this.mAlertParams.mCheckedItems[position] = listView.isItemChecked(position);
                        }
                        AlertParamsWrapper.this.mAlertParams.mOnCheckboxClickListener.onClick(dialog2.mDialog, position, listView.isItemChecked(position));
                    }
                });
            }
            if (alertParamsWrapper.mAlertParams.mOnItemSelectedListener != null) {
                listView.setOnItemSelectedListener(alertParamsWrapper.mAlertParams.mOnItemSelectedListener);
            }
            int choicePadding = alertParamsWrapper.mAlertParams.mContext.getResources().getDimensionPixelOffset(17106045);
            boolean steposChoiceStyle = false;
            if (listViewLayout > 0 && (listViewLayout == 17367058 || listViewLayout == 17367059)) {
                steposChoiceStyle = true;
            }
            if (steposChoiceStyle) {
                listView.setPadding(choicePadding, 0, choicePadding, 0);
                listView.setSelector(R.color.transparent);
            }
            if (alertParamsWrapper.mAlertParams.mIsSingleChoice) {
                listView.setChoiceMode(1);
            } else if (alertParamsWrapper.mAlertParams.mIsMultiChoice) {
                listView.setChoiceMode(2);
            }
            dialog2.mListView = listView;
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int resource, int textViewResourceId, CharSequence[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            if (StepOSAlertController.mIsPoleStarTheme) {
                view.setBackgroundResource(17304335);
            }
            return view;
        }
    }

    public void setMaxHeight(int height) {
        this.mMaxHeight = (int) (height * this.mDensityRatio);
        StepOSAlertDialogLayout alertDialogLayout = (StepOSAlertDialogLayout) this.mWindow.findViewById(R.id.showVoiceSearchButton);
        if (alertDialogLayout != null) {
            alertDialogLayout.setMaxHeight(this.mMaxHeight);
        }
    }

    public void setGravity(int gravity) {
        this.mGravity = gravity;
    }

    public void setButtonTextColor(int whichButton, int textColorId) {
        if (this.mDialog instanceof AlertDialog) {
            AlertDialog dialog = (AlertDialog) this.mDialog;
            Button button = dialog.getButton(whichButton);
            if (button != null) {
                button.setTextColor(createColorList(textColorId));
            }
        }
    }

    public void setHighLightButton(int whichButton, int color) {
        this.mHighLightButton = whichButton;
        this.mHighLightColor = color;
    }

    private ColorStateList createColorList(int colorId) throws Resources.NotFoundException {
        int color = this.mContext.getResources().getColor(colorId);
        int disableColor = Color.argb(77, 0, 0, 0);
        if (mIsPoleStarTheme) {
            disableColor = POLE_STAR_BUTTON_DISABLE_TEXT_COLOR;
        }
        int[][] states = {new int[]{R.attr.state_enabled}, new int[0]};
        int[] colors = {color, disableColor};
        return new ColorStateList(states, colors);
    }

    public void setAutoShowSoftInput(boolean show) {
        this.mAutoShowSoftInput = show;
    }

    private void setupSpaceView(View topPanel, View contentPanel, View customPanel, View buttonPanel) {
        List<PaddingRule> paddingRules;
        PaddingRule rule;
        boolean hasTopPanel = topPanel != null && topPanel.getVisibility() == 0;
        boolean hasContentPanel = contentPanel != null && contentPanel.getVisibility() == 0;
        boolean hasCustomPanel = customPanel != null && customPanel.getVisibility() == 0;
        boolean hasButtonPanel = buttonPanel != null && buttonPanel.getVisibility() == 0;
        Space space1 = (Space) this.mWindow.findViewById(R.id.flagRequestTouchExplorationMode);
        Space space2 = (Space) this.mWindow.findViewById(R.id.flagRetrieveInteractiveWindows);
        Space space3 = (Space) this.mWindow.findViewById(R.id.flagSendMotionEvents);
        Space space4 = (Space) this.mWindow.findViewById(R.id.flagServiceHandlesDoubleTap);
        int mask = (hasTopPanel ? 1 : 0) | ((hasContentPanel || hasCustomPanel) ? 2 : 0) | (hasButtonPanel ? 4 : 0);
        PaddingRule rule2 = null;
        if (this.mCustomPaddingRule) {
            rule = new PaddingRule(0, this.mPaddingSpace1, this.mPaddingSpace2, this.mPaddingSpace3, this.mPaddingSpace4);
        } else {
            if (this.mListView != null) {
                if (this.mActionDialog) {
                    paddingRules = sActionListPaddingRules;
                } else {
                    paddingRules = sListPaddingRules;
                }
            } else if (hasCustomPanel) {
                paddingRules = sCustomViewRules;
            } else if (isMessageViewOneLine()) {
                paddingRules = sSingleMessagePaddingRules;
            } else {
                paddingRules = sPaddingRules;
            }
            Iterator<PaddingRule> it = paddingRules.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PaddingRule paddingRule = it.next();
                if (mask == paddingRule.mask) {
                    rule2 = paddingRule;
                    break;
                }
            }
            if (rule2 != null) {
                rule = rule2;
            } else {
                rule = sPaddingRules.get(0);
            }
        }
        rule.applyRule(this.mContext, space1, space2, space3, space4);
    }

    private static class PaddingRule {
        private int mask;
        private int space1;
        private int space2;
        private int space3;
        private int space4;

        public PaddingRule(int mask, int space1, int space2, int space3, int space4) {
            this.mask = mask;
            this.space1 = space1;
            this.space2 = space2;
            this.space3 = space3;
            this.space4 = space4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyRule(Context context, View spaceView1, View spaceView2, View spaceView3, View spaceView4) {
            if (spaceView1 != null) {
                spaceView1.getLayoutParams().height = StepOSAlertController.dp2px(context, this.space1);
            }
            if (spaceView2 != null) {
                spaceView2.getLayoutParams().height = StepOSAlertController.dp2px(context, this.space2);
            }
            if (spaceView3 != null) {
                spaceView3.getLayoutParams().height = StepOSAlertController.dp2px(context, this.space3);
            }
            if (spaceView4 != null) {
                spaceView4.getLayoutParams().height = StepOSAlertController.dp2px(context, this.space4);
            }
        }
    }

    private boolean isButtonLayoutVertical(int whichButtons) throws Resources.NotFoundException {
        int wordPadding = this.mContext.getResources().getDimensionPixelOffset(17106025);
        int buttonCount = calcButtonCount(whichButtons);
        if (buttonCount < 1) {
            return false;
        }
        int maxTextLength = calcButtonWidth(whichButtons) - (wordPadding * 2);
        if (this.mButtonPositive != null && this.mButtonPositive.getVisibility() == 0) {
            int textLength = getTextWidth(this.mButtonPositive, this.mButtonPositiveText);
            if (textLength > maxTextLength) {
                return true;
            }
        }
        if (this.mButtonNegative != null && this.mButtonNegative.getVisibility() == 0) {
            int textLength2 = getTextWidth(this.mButtonNegative, this.mButtonNegativeText);
            if (textLength2 > maxTextLength) {
                return true;
            }
        }
        if (this.mButtonNeutral != null && this.mButtonNeutral.getVisibility() == 0) {
            int textLength3 = getTextWidth(this.mButtonNeutral, this.mButtonNeutralText);
            if (textLength3 > maxTextLength) {
                return true;
            }
        }
        return this.mActionDialog || this.mListView != null;
    }

    private void applyVerticalButtonStyle(Button button, int buttonType, int whichButtons, boolean isHighLightIndex) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        int wordPadding = this.mContext.getResources().getDimensionPixelOffset(17106025);
        button.setPadding(wordPadding, 0, wordPadding, 0);
        if (this.mActionDialog || this.mListView != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
            params.width = -1;
            params.height = this.mContext.getResources().getDimensionPixelOffset(17106082);
            button.setBackgroundResource(17304333);
            this.mzPressAnimationHelper.addTargetViewCustomEffect(button, false, StepOSPressAnimationHelper.CUSTOM_PRESS_EFFECT_MASK);
            if (mIsPoleStarTheme) {
                button.setTextColor(createColorList(17171366));
                return;
            }
            return;
        }
        int paddingStart = this.mContext.getResources().getDimensionPixelOffset(17106061);
        int marginTop = this.mContext.getResources().getDimensionPixelOffset(17106021);
        int width = this.mAlertDialogWidth - (paddingStart * 2);
        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) button.getLayoutParams();
        params2.width = width;
        params2.height = this.mContext.getResources().getDimensionPixelOffset(17106044);
        if (buttonType == 4) {
            if ((whichButtons & 1) != 0) {
                params2.topMargin = marginTop;
            }
        } else if (buttonType == 2 && ((whichButtons & 1) != 0 || (whichButtons & 4) != 0)) {
            params2.topMargin = marginTop;
        }
        if (isHighLightIndex) {
            if (this.mHighLightColor == 2) {
                button.setTextColor(this.mContext.getResources().getColor(17171369));
                button.setBackgroundResource(17304332);
                return;
            } else {
                if (this.mHighLightColor == 1) {
                    if (mIsPoleStarTheme) {
                        button.setBackgroundResource(17304331);
                        button.setTextColor(createColorList(17171366));
                        return;
                    } else {
                        button.setBackgroundResource(17304330);
                        return;
                    }
                }
                button.setBackgroundResource(17304329);
                return;
            }
        }
        button.setBackgroundResource(17304329);
        if (mIsPoleStarTheme) {
            button.setTextColor(createColorList(17171366));
        }
    }

    private void applyHorizontalButtonStyle(Button button, int buttonType, int whichButtons, boolean isHighLightIndex) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.width = calcButtonWidth(whichButtons);
        params.height = this.mContext.getResources().getDimensionPixelOffset(17106044);
        button.setGravity(17);
        int wordPadding = this.mContext.getResources().getDimensionPixelOffset(17106025);
        button.setPadding(wordPadding, 0, wordPadding, 0);
        int marginStart = this.mContext.getResources().getDimensionPixelOffset(17106021);
        if (buttonType == 4) {
            if ((whichButtons & 2) != 0) {
                params.setMarginStart(marginStart);
            }
        } else if (buttonType == 1 && ((whichButtons & 2) != 0 || (whichButtons & 4) != 0)) {
            params.setMarginStart(marginStart);
        }
        if (isHighLightIndex) {
            if (this.mHighLightColor != 2) {
                if (this.mHighLightColor == 1) {
                    if (mIsPoleStarTheme) {
                        button.setBackgroundResource(17304331);
                        button.setTextColor(createColorList(17171366));
                        return;
                    } else {
                        button.setBackgroundResource(17304330);
                        return;
                    }
                }
                button.setBackgroundResource(17304329);
                return;
            }
            button.setTextColor(this.mContext.getResources().getColor(17171369));
            button.setBackgroundResource(17304332);
            return;
        }
        button.setBackgroundResource(17304329);
        if (mIsPoleStarTheme) {
            button.setTextColor(createColorList(17171366));
        }
    }

    private int calcButtonWidth(int whichButtons) throws Resources.NotFoundException {
        int paddingStart = this.mContext.getResources().getDimensionPixelOffset(17106061);
        int marginStart = this.mContext.getResources().getDimensionPixelOffset(17106021);
        int buttonCount = calcButtonCount(whichButtons);
        if (buttonCount == 0) {
            return this.mAlertDialogWidth - (paddingStart * 2);
        }
        return ((this.mAlertDialogWidth - (paddingStart * 2)) - ((buttonCount > 0 ? buttonCount - 1 : 0) * marginStart)) / buttonCount;
    }

    private int calcButtonCount(int whichButtons) {
        int buttonCount = 0;
        if ((whichButtons & 4) != 0) {
            buttonCount = 0 + 1;
        }
        if ((whichButtons & 2) != 0) {
            buttonCount++;
        }
        if ((whichButtons & 1) != 0) {
            return buttonCount + 1;
        }
        return buttonCount;
    }

    private int calcButtonHighLight(int whichButtons) {
        if (this.mHighLightButton == -1 && (whichButtons & 1) != 0) {
            return 1;
        }
        if (this.mHighLightButton == -2 && (whichButtons & 2) != 0) {
            return 2;
        }
        if (this.mHighLightButton == -3 && (whichButtons & 4) != 0) {
            return 4;
        }
        if ((whichButtons & 1) != 0) {
            return 1;
        }
        if ((whichButtons & 4) != 0) {
            return 4;
        }
        if ((whichButtons & 2) == 0) {
            return 0;
        }
        return 2;
    }

    private int calcButtonLayoutPadding() throws Resources.NotFoundException {
        int totalTextLength = 0;
        int buttonCount = 0;
        if (this.mButtonPositive != null && this.mButtonPositive.getVisibility() == 0) {
            int textLength = getTextWidth(this.mButtonPositive, this.mButtonPositiveText);
            totalTextLength = 0 + textLength;
            buttonCount = 0 + 1;
        }
        if (this.mButtonNegative != null && this.mButtonNegative.getVisibility() == 0) {
            int textLength2 = getTextWidth(this.mButtonNegative, this.mButtonNegativeText);
            totalTextLength += textLength2;
            buttonCount++;
        }
        if (this.mButtonNeutral != null && this.mButtonNeutral.getVisibility() == 0) {
            int textLength3 = getTextWidth(this.mButtonNeutral, this.mButtonNeutralText);
            totalTextLength += textLength3;
            buttonCount++;
        }
        int paddingStart = this.mContext.getResources().getDimensionPixelOffset(17106061);
        int marginStart = this.mContext.getResources().getDimensionPixelOffset(17106021);
        int space = ((this.mAlertDialogWidth - totalTextLength) - (paddingStart * 2)) - ((buttonCount > 0 ? buttonCount - 1 : 0) * marginStart);
        return (space / (buttonCount > 0 ? buttonCount : 1)) / 2;
    }

    private int getTextWidth(TextView textView, CharSequence str) {
        TransformationMethod transformation = textView.getTransformationMethod();
        if (transformation != null) {
            str = transformation.getTransformation(str, textView);
        }
        return (int) textView.getPaint().measureText(str.toString());
    }

    public void applyStepOSStyle() {
        View editText;
        boolean hasTitle = this.mTitleView != null && this.mTitleView.getVisibility() == 0;
        boolean hasIconView = this.mIconView != null && this.mIconView.getVisibility() == 0;
        if (this.mListView != null && this.mActionDialog && hasTitle) {
            this.mTitleView.setTextSize(2, 15.0f);
            this.mTitleView.setTextColor(1929379840);
            this.mTitleView.setTypeface(Typeface.DEFAULT);
        }
        if (hasTitle && !hasIconView && isTitleViewOneLine()) {
            this.mTitleView.setGravity(17);
        }
        if (this.mTitleView != null) {
            adaptiveTextSizeIfNeed(this.mTitleView, getTitleWidth());
        }
        boolean hasMessageView = this.mMessageView != null && this.mMessageView.getVisibility() == 0;
        if (hasMessageView && isMessageViewOneLine()) {
            this.mMessageView.setGravity(17);
        }
        if (!hasTitle && hasMessageView) {
            this.mMessageView.setTextSize(2, 17.0f);
            this.mMessageView.setTextColor(this.mContext.getColor(R.color.keyguard_text_color_unlock));
            this.mMessageView.setTypeface(Typeface.create("sans-serif-medium", 0));
        }
        if (this.mListView != null && this.mActionDialog) {
            this.mListView.setDivider(null);
        }
        ViewGroup customPanel = (ViewGroup) this.mWindow.findViewById(R.id.find_next);
        boolean hasCustomPanel = (customPanel == null || customPanel.getVisibility() == 8) ? false : true;
        if (hasCustomPanel && !this.mViewSpacingSpecified && (editText = findEditText(customPanel)) != null) {
            if (this.mContext.getApplicationInfo().targetSdkVersion >= 28) {
                editText.requestFocus();
            }
            if (!isCustomViewSpacingSpecified(editText)) {
                FrameLayout custom = (FrameLayout) this.mWindow.findViewById(R.id.custom);
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) custom.getLayoutParams();
                params.leftMargin = this.mContext.getResources().getDimensionPixelOffset(17106040);
                params.rightMargin = this.mContext.getResources().getDimensionPixelOffset(17106041);
            }
        }
        WindowManager.LayoutParams windowParams = this.mWindow.getAttributes();
        windowParams.width = this.mAlertDialogWidth;
        if (this.mMaxHeight == 0) {
            this.mMaxHeight = (getScreenHeight() - this.mContext.getResources().getDimensionPixelSize(17105977)) - this.mContext.getResources().getDimensionPixelOffset(17106049);
        }
        setMaxHeight(this.mMaxHeight);
        if (this.mGravity != 0) {
            windowParams.gravity = this.mGravity;
        } else {
            windowParams.gravity = 80;
        }
        if (windowParams.gravity != 80) {
            if (windowParams.gravity == 17 && this.mContext.getResources().getConfiguration().orientation == 2) {
                windowParams.y = (-this.mContext.getResources().getDimensionPixelSize(17105977)) / 2;
            }
        } else {
            windowParams.y = this.mContext.getResources().getDimensionPixelOffset(17106049);
        }
        if (this.mAutoShowSoftInput) {
            this.mWindow.setSoftInputMode(37);
        }
        this.mWindow.setElevation(0.0f);
    }

    private View findEditText(View v) {
        if (v == null || v.getVisibility() != 0) {
            return null;
        }
        if (v instanceof EditText) {
            return v;
        }
        if (v instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                View editText = findEditText(child);
                if (editText != null) {
                    return editText;
                }
            }
        }
        return null;
    }

    private boolean isCustomViewSpacingSpecified(View view) {
        if (!(view instanceof EditText) && view.getPaddingLeft() != 0) {
            return true;
        }
        if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (params.leftMargin != 0) {
                return true;
            }
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent.getId() != 16909029) {
                return isCustomViewSpacingSpecified(parent);
            }
            return false;
        }
        return false;
    }

    private int getScreenHeight() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager == null) {
            return this.mContext.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics metric = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(metric);
        return metric.heightPixels;
    }

    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager == null) {
            return this.mContext.getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics metric = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    private static float getRawDimension(Context context, int id) throws Resources.NotFoundException {
        TypedValue value = new TypedValue();
        context.getResources().getValue(id, value, true);
        return TypedValue.complexToFloat(value.data);
    }

    private static boolean isShowNavigationBar(Context context) {
        int showSplitBar = getShowNavigationBarValue(context, 0);
        return showSplitBar == 1;
    }

    private static int getShowNavigationBarValue(Context context, int defaultValue) {
        return Settings.System.getInt(context.getContentResolver(), StepOSSettingsKeys.SYSTEM_SHOW_NAVIGATION_BAR, defaultValue);
    }

    private static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    private int getTitleWidth() {
        int totalPadding = 0;
        int totalMargin = 0;
        int totalIconLength = 0;
        if (!TextUtils.isEmpty(this.mTitle)) {
            View titleTemplate = this.mWindow.findViewById(16910085);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) titleTemplate.getLayoutParams();
            int totalMargin2 = params.leftMargin + params.rightMargin;
            LinearLayout.LayoutParams mTitleViewParams = (LinearLayout.LayoutParams) this.mTitleView.getLayoutParams();
            int totalMargin3 = totalMargin2 + mTitleViewParams.leftMargin + mTitleViewParams.rightMargin;
            totalPadding = this.mTitleView.getPaddingLeft() + this.mTitleView.getPaddingRight() + titleTemplate.getPaddingLeft() + titleTemplate.getPaddingRight();
            if ((this.mIconId != 0 || this.mIcon != null) && this.mIconView != null && this.mIconView.getVisibility() == 0) {
                int totalIconLength2 = 0 + dp2px(this.mContext, 32.0f) + this.mIconView.getPaddingLeft() + this.mIconView.getPaddingRight();
                LinearLayout.LayoutParams mIconViewParams = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
                totalIconLength = totalIconLength2 + mIconViewParams.leftMargin + mIconViewParams.rightMargin;
                totalMargin = totalMargin3;
            } else {
                totalMargin = totalMargin3;
            }
        }
        return this.mAlertDialogWidth - ((totalPadding + totalMargin) + totalIconLength);
    }

    private boolean isTitleViewOneLine() {
        int textLength = 0;
        if (!TextUtils.isEmpty(this.mTitle)) {
            String[] titles = this.mTitle.toString().split("\n");
            if (titles.length > 1) {
                return false;
            }
            textLength = getTextWidth(this.mTitleView, this.mTitle);
        }
        return textLength <= getTitleWidth();
    }

    private boolean isMessageViewOneLine() {
        if (this.mMessageView == null || TextUtils.isEmpty(this.mMessage)) {
            return true;
        }
        String[] messages = this.mMessage.toString().split("\n");
        return messages.length <= 1 && (getTextWidth(this.mMessageView, this.mMessage) + this.mMessageView.getPaddingLeft()) + this.mMessageView.getPaddingRight() <= this.mAlertDialogWidth;
    }

    public static void adaptiveTextSizeIfNeed(TextView textView, int width) {
        adaptiveTextSizeIfNeed(textView, width, DEFAULT_CALLBACK);
    }

    public static void adaptiveTextSizeIfNeed(TextView textView, int width, AdaptiveCallback callback) {
        float textSize = textView.getTextSize();
        int maxLine = textView.getMaxLines();
        if (maxLine <= 0) {
            return;
        }
        textView.setMaxLines(Integer.MAX_VALUE);
        for (float adaptiveSize = textSize; adaptiveSize > 1.0f; adaptiveSize -= 1.0f) {
            try {
                callback.setTextSize(textView, 0, adaptiveSize);
                if (getLineCount(textView, width, callback) <= maxLine) {
                    textView.setMaxLines(maxLine);
                    return;
                }
            } catch (Exception e) {
            }
        }
        callback.setTextSize(textView, 0, textSize);
        textView.setMaxLines(maxLine);
    }

    private static int getLineCount(TextView textView, int width, AdaptiveCallback callback) {
        int lineCount;
        int widthSpec = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        callback.measure(textView, widthSpec, heightSpec);
        Layout layout = textView.getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0) {
            return lineCount;
        }
        throw new IllegalStateException();
    }

    private float computeDialogHeightRatio() {
        ListAdapter adapter;
        float heightRatio = 0.106000006f;
        if (!TextUtils.isEmpty(this.mTitle)) {
            int titleLines = (int) Math.ceil(this.mTitle.length() / 15.0f);
            heightRatio = 0.106000006f + (titleLines * 0.03f);
        }
        if (!TextUtils.isEmpty(this.mMessage)) {
            int messageLines = (int) Math.ceil(this.mMessage.length() / 19.0f);
            heightRatio += messageLines * 0.023f;
        }
        if (this.hasCustomView) {
            heightRatio += 0.3f;
        }
        if (this.mCustomTitleView != null) {
            heightRatio += 0.1f;
        }
        ListView listView = getListView();
        if (listView != null && (adapter = listView.getAdapter()) != null) {
            int itemCount = adapter.getCount();
            heightRatio += itemCount * 0.063f;
        }
        int[] buttonInfo = analyzeDialogButtons();
        if ((buttonInfo[1] != 0 || buttonInfo[0] <= 0) && buttonInfo[1] == 1 && buttonInfo[0] > 0) {
            return heightRatio + (buttonInfo[0] * 0.063f);
        }
        return heightRatio;
    }

    private int[] analyzeDialogButtons() {
        Button referenceButton;
        Button positiveButton = getButton(-1);
        Button negativeButton = getButton(-2);
        Button neutralButton = getButton(-3);
        int extraButtonCount = -1;
        if (positiveButton != null && !TextUtils.isEmpty(positiveButton.getText())) {
            extraButtonCount = (-1) + 1;
        }
        if (negativeButton != null && !TextUtils.isEmpty(negativeButton.getText())) {
            extraButtonCount++;
        }
        if (neutralButton != null && !TextUtils.isEmpty(neutralButton.getText())) {
            extraButtonCount++;
        }
        int orientation = 0;
        if (extraButtonCount > 0) {
            if (positiveButton != null && !TextUtils.isEmpty(positiveButton.getText())) {
                referenceButton = positiveButton;
            } else if (negativeButton != null && !TextUtils.isEmpty(negativeButton.getText())) {
                referenceButton = negativeButton;
            } else {
                referenceButton = neutralButton;
            }
            ViewGroup parent = (ViewGroup) referenceButton.getParent();
            if (parent instanceof LinearLayout) {
                orientation = ((LinearLayout) parent).getOrientation();
            }
        }
        return new int[]{extraButtonCount, orientation};
    }

    public void setUpAnimation() {
        int styleResource;
        float heightRatio = computeDialogHeightRatio();
        if (heightRatio < 0.33d) {
            styleResource = R.style.BaseErrorDialog.DeviceDefault;
        } else if (heightRatio < 0.66d) {
            styleResource = R.style.AutofillSaveUiTitle;
        } else {
            styleResource = R.style.AutofillSaveAnimation;
        }
        if (this.mWindow != null) {
            this.mWindow.setWindowAnimations(styleResource);
        }
    }
}
