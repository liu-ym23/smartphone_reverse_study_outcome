package stepos.inputmethod;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.display.StepOSDisplayManager;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.StepOSDateTimeUrlHelper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowInsetsController;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.policy.StepOSSystemBarController;
import java.util.List;
import stepos.inputmethod.IQsActionListener;

/* loaded from: classes.dex */
public class QsActionItemsView extends FrameLayout implements View.OnClickListener, View.OnLongClickListener, WindowInsetsController.OnControllableInsetsChangedListener {
    private static final String DEBUG_TAG = "LOCAL_IME_QS_COLOR";
    private static final String TAG = "QsActionItemsView";
    private QsActionExecutorImpl mActionExecutor;
    private final IQsActionListener mActionListener;
    private QsActionItem mCenterActionItem;
    private ImageButton mCenterButton;
    private Animation mCenterInAnimation;
    private Animation mCenterOutAnimation;
    private QsActionItem mLeftActionItem;
    private ImageButton mLeftButton;
    private Animation mLeftInAnimation;
    private Animation mLeftOutAnimation;
    private boolean mLightIcon;
    private ImageView mMessageIconView;
    private TextView mMessageTextView;
    private View mMessageView;
    private QsActionManager mQsManager;
    private QsActionItem mRightActionItem;
    private ImageButton mRightButton;
    private QsActionItem mSlideActionItem;
    private QsActionSlideView mSlideView;
    private QsActionItem mTextActionItem;
    private int mUiMode;

    public QsActionItemsView(Context context) {
        super(context);
        this.mActionListener = new IQsActionListener.Stub() { // from class: stepos.inputmethod.QsActionItemsView.1
            @Override // stepos.inputmethod.IQsActionListener
            public void onItemActionChange(QsActionItem actionItem, int position) {
                Slog.i(QsActionItemsView.TAG, "onItemActionChange actionItem=" + actionItem + ",position=" + position);
                switch (position) {
                    case 1:
                        QsActionItemsView.this.mLeftActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mLeftButton, QsActionItemsView.this.mLeftActionItem, true);
                        break;
                    case 2:
                        QsActionItemsView.this.mCenterActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mCenterButton, QsActionItemsView.this.mCenterActionItem, false);
                        break;
                    case 4:
                        QsActionItemsView.this.mRightActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mRightButton, QsActionItemsView.this.mRightActionItem, false);
                        break;
                    case 8:
                        QsActionItemsView.this.mSlideActionItem = actionItem;
                        QsActionItemsView.this.postUpdateSlideState(QsActionItemsView.this.mSlideActionItem);
                        break;
                    case 16:
                        QsActionItemsView.this.mTextActionItem = actionItem;
                        QsActionItemsView.this.postUpdateTextState(QsActionItemsView.this.mTextActionItem);
                        break;
                }
            }
        };
    }

    public QsActionItemsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mActionListener = new IQsActionListener.Stub() { // from class: stepos.inputmethod.QsActionItemsView.1
            @Override // stepos.inputmethod.IQsActionListener
            public void onItemActionChange(QsActionItem actionItem, int position) {
                Slog.i(QsActionItemsView.TAG, "onItemActionChange actionItem=" + actionItem + ",position=" + position);
                switch (position) {
                    case 1:
                        QsActionItemsView.this.mLeftActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mLeftButton, QsActionItemsView.this.mLeftActionItem, true);
                        break;
                    case 2:
                        QsActionItemsView.this.mCenterActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mCenterButton, QsActionItemsView.this.mCenterActionItem, false);
                        break;
                    case 4:
                        QsActionItemsView.this.mRightActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mRightButton, QsActionItemsView.this.mRightActionItem, false);
                        break;
                    case 8:
                        QsActionItemsView.this.mSlideActionItem = actionItem;
                        QsActionItemsView.this.postUpdateSlideState(QsActionItemsView.this.mSlideActionItem);
                        break;
                    case 16:
                        QsActionItemsView.this.mTextActionItem = actionItem;
                        QsActionItemsView.this.postUpdateTextState(QsActionItemsView.this.mTextActionItem);
                        break;
                }
            }
        };
    }

    public QsActionItemsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mActionListener = new IQsActionListener.Stub() { // from class: stepos.inputmethod.QsActionItemsView.1
            @Override // stepos.inputmethod.IQsActionListener
            public void onItemActionChange(QsActionItem actionItem, int position) {
                Slog.i(QsActionItemsView.TAG, "onItemActionChange actionItem=" + actionItem + ",position=" + position);
                switch (position) {
                    case 1:
                        QsActionItemsView.this.mLeftActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mLeftButton, QsActionItemsView.this.mLeftActionItem, true);
                        break;
                    case 2:
                        QsActionItemsView.this.mCenterActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mCenterButton, QsActionItemsView.this.mCenterActionItem, false);
                        break;
                    case 4:
                        QsActionItemsView.this.mRightActionItem = actionItem;
                        QsActionItemsView.this.postUpdateButtonState(QsActionItemsView.this.mRightButton, QsActionItemsView.this.mRightActionItem, false);
                        break;
                    case 8:
                        QsActionItemsView.this.mSlideActionItem = actionItem;
                        QsActionItemsView.this.postUpdateSlideState(QsActionItemsView.this.mSlideActionItem);
                        break;
                    case 16:
                        QsActionItemsView.this.mTextActionItem = actionItem;
                        QsActionItemsView.this.postUpdateTextState(QsActionItemsView.this.mTextActionItem);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postUpdateButtonState$0(ImageButton button, QsActionItem qsActionItem, boolean checkMessage) {
        updateButtonState(button, qsActionItem, checkMessage, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUpdateButtonState(final ImageButton button, final QsActionItem qsActionItem, final boolean checkMessage) {
        post(new Runnable() { // from class: stepos.inputmethod.QsActionItemsView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$postUpdateButtonState$0(button, qsActionItem, checkMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUpdateSlideState(final QsActionItem qsActionItem) {
        post(new Runnable() { // from class: stepos.inputmethod.QsActionItemsView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$postUpdateSlideState$1(qsActionItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUpdateTextState(final QsActionItem qsActionItem) {
        post(new Runnable() { // from class: stepos.inputmethod.QsActionItemsView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$postUpdateTextState$2(qsActionItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postUpdateTextState$2(QsActionItem qsActionItem) {
        updateMessageState(qsActionItem);
        updateButtonState(this.mLeftButton, this.mLeftActionItem, true, true);
        lambda$postUpdateSlideState$1(this.mSlideActionItem);
    }

    private boolean isValidItem(QsActionItem item) {
        if (item == null) {
            return false;
        }
        return item.getDisplayId() == -1 || item.getDisplayId() == this.mContext.getDisplayId();
    }

    private void updateMessageState(QsActionItem item) {
        if (isValidItem(item)) {
            int tintColor = this.mLightIcon ? -1 : -16777216;
            this.mMessageIconView.setColorFilter(tintColor);
            Slog.i(DEBUG_TAG, "updateMessageState message=" + viewToDebugString(this.mMessageView) + ", item=" + itemToDebugString(item) + ", lightIcon=" + this.mLightIcon + ", tint=" + colorToString(tintColor));
            this.mMessageIconView.setImageIcon(item.getIcon());
            this.mMessageTextView.setTextColor(this.mLightIcon ? -1 : -16777216);
            this.mMessageView.setBackgroundColor(this.mLightIcon ? 234881023 : 218103808);
            this.mMessageView.setTag(item);
            this.mMessageTextView.setText(item.getLabel());
            int state = item.getState();
            switch (state) {
                case 0:
                    if (this.mMessageView.getVisibility() != 0) {
                        this.mMessageView.startAnimation(this.mLeftInAnimation);
                        this.mMessageView.setVisibility(0);
                    }
                    this.mMessageView.setEnabled(true);
                    break;
                case 1:
                    if (this.mMessageView.getVisibility() != 4) {
                        this.mMessageView.startAnimation(this.mLeftOutAnimation);
                        this.mMessageView.setVisibility(4);
                    }
                    this.mMessageView.setEnabled(true);
                    break;
                case 2:
                    if (this.mMessageView.getVisibility() != 0) {
                        this.mMessageView.startAnimation(this.mLeftInAnimation);
                        this.mMessageView.setVisibility(0);
                    }
                    this.mMessageView.setEnabled(false);
                    break;
            }
        }
        if (this.mMessageView.getVisibility() != 4) {
            this.mMessageView.startAnimation(this.mLeftOutAnimation);
            this.mMessageView.setVisibility(4);
        }
        this.mMessageIconView.setImageIcon(null);
        this.mMessageTextView.setTag(null);
        this.mMessageTextView.setText((CharSequence) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSlideState, reason: merged with bridge method [inline-methods] */
    public void lambda$postUpdateSlideState$1(QsActionItem item) {
        if (isValidItem(item) && this.mTextActionItem == null) {
            int tintColor = this.mLightIcon ? -1 : StepOSSystemBarController.COLO_BLACK;
            this.mSlideView.getBackground().setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP);
            Slog.i(DEBUG_TAG, "updateSlideState slide=" + viewToDebugString(this.mSlideView) + ", item=" + itemToDebugString(item) + ", lightIcon=" + this.mLightIcon + ", tint=" + colorToString(tintColor));
            int state = item.getState();
            switch (state) {
                case 0:
                    this.mSlideView.setVisibility(0);
                    this.mSlideView.setEnabled(true);
                    break;
                case 1:
                    this.mSlideView.setVisibility(4);
                    this.mSlideView.setEnabled(false);
                    break;
                case 2:
                    this.mSlideView.setVisibility(0);
                    this.mSlideView.setEnabled(false);
                    break;
            }
        }
        this.mSlideView.setVisibility(4);
    }

    private void updateButtonState(ImageButton button, QsActionItem item, boolean checkMessage, boolean anim) {
        if (isValidItem(item) && (!checkMessage || this.mTextActionItem == null)) {
            int state = item.getState();
            int tintColor = -1;
            switch (state) {
                case 0:
                    if (anim && button.getVisibility() != 0) {
                        button.startAnimation(this.mCenterInAnimation);
                    }
                    button.setVisibility(0);
                    button.setColorFilter(this.mLightIcon ? -1 : -16777216);
                    button.setEnabled(true);
                    break;
                case 1:
                    if (anim && button.getVisibility() != 4) {
                        button.startAnimation(this.mCenterOutAnimation);
                    }
                    button.setVisibility(4);
                    button.setEnabled(false);
                    break;
                case 2:
                    if (anim && button.getVisibility() != 0) {
                        button.startAnimation(this.mCenterOutAnimation);
                    }
                    button.setVisibility(0);
                    button.setColorFilter(-7829368);
                    button.setEnabled(false);
                    break;
            }
            if (state == 2) {
                tintColor = -7829368;
            } else if (!this.mLightIcon) {
                tintColor = -16777216;
            }
            Slog.i(DEBUG_TAG, "updateButtonState button=" + viewToDebugString(button) + ", item=" + itemToDebugString(item) + ", lightIcon=" + this.mLightIcon + ", tint=" + colorToString(tintColor) + ", checkMessage=" + checkMessage + ", anim=" + anim);
            button.setTag(item);
            button.setImageIcon(item.getIcon());
            return;
        }
        if (anim && button.getVisibility() != 4) {
            button.startAnimation(this.mCenterInAnimation);
        }
        button.setVisibility(4);
        Slog.i(DEBUG_TAG, "updateButtonState hide button=" + viewToDebugString(button) + ", item=" + itemToDebugString(item) + ", checkMessage=" + checkMessage + ", textItem=" + itemToDebugString(this.mTextActionItem));
        button.setTag(null);
        button.setImageIcon(null);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mLeftInAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.options_panel_exit);
        this.mLeftOutAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.popup_enter_material);
        this.mCenterInAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.lock_screen_wallpaper_exit);
        this.mCenterOutAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.options_panel_enter);
        this.mQsManager = QsActionManager.getInstance(this.mContext);
        this.mLeftButton = (ImageButton) findViewById(R.id.modeMedium);
        this.mRightButton = (ImageButton) findViewById(R.id.modeSmall);
        this.mCenterButton = (ImageButton) findViewById(R.id.modeLarge);
        this.mSlideView = (QsActionSlideView) findViewById(R.id.mode_in);
        this.mMessageTextView = (TextView) findViewById(R.id.module);
        this.mMessageIconView = (ImageView) findViewById(R.id.mode_out);
        this.mMessageView = findViewById(R.id.mode_normal);
        this.mUiMode = getResources().getConfiguration().uiMode;
        this.mLeftButton.setLongClickable(true);
        this.mLeftButton.setOnClickListener(this);
        this.mLeftButton.setOnLongClickListener(this);
        this.mRightButton.setOnClickListener(this);
        this.mRightButton.setLongClickable(true);
        this.mCenterButton.setOnClickListener(this);
        this.mCenterButton.setLongClickable(true);
        this.mMessageView.setOnClickListener(this);
        this.mMessageView.setClipToOutline(true);
        this.mMessageView.setOutlineProvider(new ViewOutlineProvider(this) { // from class: stepos.inputmethod.QsActionItemsView.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                int width = view.getWidth();
                int height = view.getHeight();
                Rect rect = new Rect(0, 0, width, height);
                outline.setRoundRect(rect, height / 2.0f);
            }
        });
    }

    private void initData() {
        List<QsActionItem> items = this.mQsManager.getActionItemList(-1);
        Slog.i(DEBUG_TAG, "initData package=" + this.mContext.getPackageName() + ", displayId=" + this.mContext.getDisplayId() + ", itemsSize=" + items.size() + ", root=" + viewToDebugString(getRootView()) + ", self=" + viewToDebugString(this));
        for (int i = 0; i < items.size(); i++) {
            QsActionItem item = items.get(i);
            Slog.i(DEBUG_TAG, "initData item[" + i + "] " + itemToDebugString(item));
            switch (item.getPosition()) {
                case 1:
                    this.mLeftActionItem = item;
                    break;
                case 2:
                    this.mCenterActionItem = item;
                    break;
                case 4:
                    this.mRightActionItem = item;
                    break;
                case 8:
                    this.mSlideActionItem = item;
                    break;
                case 16:
                    this.mTextActionItem = item;
                    break;
            }
        }
        updateSystemUiVisibility(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Slog.i(DEBUG_TAG, "onDetachedFromWindow package=" + this.mContext.getPackageName() + ", displayId=" + this.mContext.getDisplayId());
        super.onDetachedFromWindow();
        this.mQsManager.unRegisterActionListener(this.mActionListener);
        if (this.mActionExecutor != null) {
            this.mActionExecutor.resetState();
            this.mQsManager.unRegisterActionExecutor(this.mContext.getDisplayId(), this.mActionExecutor);
            this.mActionExecutor = null;
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int visible) {
        Slog.i(DEBUG_TAG, "onWindowSystemUiVisibilityChanged visible=0x" + Integer.toHexString(visible) + ", package=" + this.mContext.getPackageName());
        updateSystemUiVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Slog.i(DEBUG_TAG, "onAttachedToWindow package=" + this.mContext.getPackageName() + ", displayId=" + this.mContext.getDisplayId() + ", root=" + viewToDebugString(getRootView()) + ", parent=" + viewToDebugString((View) getParent()) + ", self=" + viewToDebugString(this));
        initData();
        this.mQsManager.registerActionListener(this.mActionListener);
        if (this.mActionExecutor == null) {
            if (this.mContext instanceof InputMethodService) {
                this.mActionExecutor = new QsActionExecutorImpl(this, (InputMethodService) this.mContext);
                this.mQsManager.registerActionExecutor(this.mContext.getDisplayId(), this.mActionExecutor);
                Slog.i(TAG, "registerActionExecutor pkg=" + this.mContext.getPackageName());
                return;
            }
            Slog.e(TAG, "not registerActionExecutor pkg=" + this.mContext.getPackageName());
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Slog.i(DEBUG_TAG, "onWindowVisibilityChanged visibility=" + visibilityToString(visibility) + ", package=" + this.mContext.getPackageName());
        if (visibility == 0) {
            updateSystemUiVisibility(false);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mUiMode = newConfig.uiMode;
        Slog.i(DEBUG_TAG, "onConfigurationChanged uiMode=0x" + Integer.toHexString(newConfig.uiMode) + ", package=" + this.mContext.getPackageName());
        updateSystemUiVisibility(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        QsActionItem actionItem;
        if (!(v.getTag() instanceof QsActionItem) || (actionItem = (QsActionItem) v.getTag()) == null) {
            return;
        }
        Slog.i(TAG, "onClick v=" + v + ",item=" + actionItem.getKey());
        Bundle data = new Bundle();
        this.mQsManager.callItemAction(actionItem.getKey(), 7, this.mContext.getUserId(), this.mContext.getDisplayId(), data);
    }

    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
    public void onControllableInsetsChanged(WindowInsetsController controller, int typeMask) {
        Slog.i(DEBUG_TAG, "onControllableInsetsChanged typeMask=0x" + Integer.toHexString(typeMask) + ", controller=" + controller);
        updateSystemUiVisibility(false);
    }

    private void updateLightIcon() {
        updateButtonState(this.mLeftButton, this.mLeftActionItem, true, false);
        updateButtonState(this.mCenterButton, this.mCenterActionItem, false, false);
        updateButtonState(this.mRightButton, this.mRightActionItem, false, false);
        lambda$postUpdateSlideState$1(this.mSlideActionItem);
        updateMessageState(this.mTextActionItem);
    }

    private static String colorToString(int color) {
        return String.format("#%08X(a=%d,r=%d,g=%d,b=%d,grey=%d)", Integer.valueOf(color), Integer.valueOf(Color.alpha(color)), Integer.valueOf(Color.red(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.blue(color)), Integer.valueOf(toGrey(color)));
    }

    private static String visibilityToString(int visibility) {
        switch (visibility) {
            case 0:
                return "VISIBLE";
            case 4:
                return "INVISIBLE";
            case 8:
                return "GONE";
            default:
                return String.valueOf(visibility);
        }
    }

    private String itemToDebugString(QsActionItem item) {
        if (item == null) {
            return "null";
        }
        return "key=" + item.getKey() + ", position=" + item.getPosition() + ", state=" + item.getState() + ", displayId=" + item.getDisplayId() + ", icon=" + item.getIcon();
    }

    private String viewToDebugString(View view) {
        if (view == null) {
            return "null";
        }
        Drawable background = view.getBackground();
        return view.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(view)) + " id=0x" + Integer.toHexString(view.getId()) + " size=" + view.getWidth() + "x" + view.getHeight() + " visibility=" + visibilityToString(view.getVisibility()) + " shown=" + view.isShown() + " alpha=" + view.getAlpha() + " bg=" + drawableToDebugString(background);
    }

    private String drawableToDebugString(Drawable drawable) {
        if (drawable == null) {
            return "null";
        }
        String result = drawable.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(drawable));
        if (drawable instanceof ColorDrawable) {
            return result + StepOSDateTimeUrlHelper.COLON_STRING + colorToString(((ColorDrawable) drawable).getColor());
        }
        return result;
    }

    private int isBlackBackgroundColor() {
        ViewParent viewGroup = getParent();
        int depth = 0;
        while (viewGroup instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) viewGroup;
            Drawable drawable = group.getBackground();
            Slog.i(DEBUG_TAG, "parentBg depth=" + depth + ", view=" + viewToDebugString(group));
            if (drawable instanceof ColorDrawable) {
                int color = ((ColorDrawable) drawable).getColor();
                if (Color.alpha(color) > 200) {
                    boolean black = isBlackColor(color, 50);
                    Slog.i(DEBUG_TAG, "parentBg choose depth=" + depth + ", color=" + colorToString(color) + ", result=" + (black ? 1 : -1));
                    return black ? 1 : -1;
                }
            }
            viewGroup = viewGroup.getParent();
            depth++;
        }
        Slog.i(DEBUG_TAG, "parentBg no opaque ColorDrawable found");
        return 0;
    }

    private void updateSystemUiVisibility(boolean force) {
        View rootView = getRootView();
        boolean lightIcon = false;
        int flag = 0;
        int systemUiVisibility = 0;
        int appearance = 0;
        WindowInsetsController windowInsetsController = null;
        String reason = "root-null";
        if (rootView != null) {
            flag = isBlackBackgroundColor();
            if (flag != 0) {
                lightIcon = flag == 1;
                reason = "parent-bg-black-means-light-icon";
            } else {
                systemUiVisibility = rootView.getSystemUiVisibility();
                boolean darkIconByLegacyFlag = (systemUiVisibility & 16) != 0;
                windowInsetsController = rootView.getWindowInsetsController();
                appearance = windowInsetsController != null ? windowInsetsController.getSystemBarsAppearance() : 0;
                boolean darkIconByAppearance = (appearance & 16) != 0;
                boolean darkIconRequested = darkIconByLegacyFlag || darkIconByAppearance;
                boolean nightMode = (this.mUiMode & 48) == 32;
                lightIcon = darkIconRequested ? false : nightMode;
                reason = "system-ui-appearance-ui-mode-v2";
            }
        }
        boolean darkIconByLegacyFlag2 = this.mLightIcon;
        boolean uiModeChange = darkIconByLegacyFlag2 != lightIcon;
        Slog.i(DEBUG_TAG, "updateSystemUiVisibility package=" + this.mContext.getPackageName() + ", displayId=" + this.mContext.getDisplayId() + ", force=" + force + ", reason=" + reason + ", bgFlag=" + flag + ", root=" + viewToDebugString(rootView) + ", self=" + viewToDebugString(this) + ", systemUiVisibility=0x" + Integer.toHexString(systemUiVisibility) + ", hasLightNavLegacy=" + ((systemUiVisibility & 16) != 0) + ", appearance=0x" + Integer.toHexString(appearance) + ", hasLightNavAppearance=" + ((appearance & 16) != 0) + ", darkIconRequested=" + (((systemUiVisibility & 16) == 0 && (appearance & 16) == 0) ? false : true) + ", nightMode=" + ((this.mUiMode & 48) == 32) + ", uiMode=0x" + Integer.toHexString(this.mUiMode) + ", controller=" + windowInsetsController + ", oldLightIcon=" + this.mLightIcon + ", newLightIcon=" + lightIcon + ", uiModeChange=" + uiModeChange);
        if (uiModeChange || force) {
            this.mLightIcon = lightIcon;
            updateLightIcon();
            if (uiModeChange) {
                this.mQsManager.callItemActionSystemUiVisibilityChange(this.mContext.getDisplayId(), true);
            }
        }
    }

    private static boolean isBlackColor(int color, int level) {
        int grey = toGrey(color);
        return grey < level;
    }

    private static int toGrey(int rgb) {
        int blue = rgb & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int green = (65280 & rgb) >> 8;
        int red = (16711680 & rgb) >> 16;
        return (((red * 38) + (green * 75)) + (blue * 15)) >> 7;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        if (v.getTag() instanceof QsActionItem) {
            Bundle data = new Bundle();
            QsActionItem actionItem = (QsActionItem) v.getTag();
            if (actionItem == null) {
                return true;
            }
            this.mQsManager.callItemAction(actionItem.getKey(), 8, this.mContext.getUserId(), this.mContext.getDisplayId(), data);
        }
        return true;
    }
}
