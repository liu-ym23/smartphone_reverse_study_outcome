package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ComboTitleBar extends RelativeLayout {
    private static final int MSG_LAYOUT_TITLE = 1;
    public static final int STYLE_CONTENT_MARQUEE = 4;
    public static final int STYLE_CONTENT_NORMAL = 0;
    public static final int STYLE_CONTENT_RADIO_TAB = 1;
    public static final int STYLE_CONTENT_RANGE = 3;
    public static final int STYLE_CONTENT_SEPARATOR = 5;
    public static final int STYLE_CONTENT_SPINNER_DROP = 2;
    private static final int STYLE_DEFAULT = -1;
    private static final int[] mRightBtnIds = null;
    private boolean isSupportLayout;
    private String[] mCenterContentArray;
    private int mCenterContentRef;
    private int mCenterContentStyle;
    private String mCenterContentText;
    private View mCenterContentView;
    private CenterDropClickListener mCenterDropClickListener;
    private int mCenterLeftIconRef;
    private CenterRangeClickListener mCenterRangeClickListener;
    private String mCenterSubContentText;
    private CenterViewClickListener mCenterViewClickListener;
    private int mDefaultSpacingSize;
    private Handler mHandler;
    private boolean mIsRangeVerticalScroll;
    private Button mLeftButton;
    private int mLeftButtonStyle;
    private String mLeftButtonText;
    private FrameLayout mLeftContainer;
    private View mLeftPlaceholder;
    private LeftBtnClickListener mLeftViewClickListener;
    private RelativeLayout mMidContainer;
    private int mMidDefMargin;
    private RelativeLayout mPrimaryTitleLayout;
    private View mPrimaryTitleShadow;
    private RadioGroup.BytedanceRadioTabGroupCallback mRadioTabGroupCallback;
    private int mRightButtonIconRefList;
    private List<Button> mRightButtonList;
    private int mRightButtonStyle;
    private String mRightButtonText;
    private LinearLayout mRightContainer;
    private View mRightPlaceholder;
    private RightBtnClickListener mRightViewClickListener;
    private FrameLayout mSecondaryBarContainer;
    private View mSecondaryBarShadow;
    private int mSecondaryLayoutRef;
    private ColorStateList mSubtitleColor;
    private ColorStateList mTitleColor;

    /* JADX INFO: renamed from: obric.widget.ComboTitleBar$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$obric$widget$ComboTitleBar$TitleShadowType = null;

        static {
            int[] r0 = new int[TitleShadowType.values().length];
            $SwitchMap$obric$widget$ComboTitleBar$TitleShadowType = r0;
            r0[TitleShadowType.SHORT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$obric$widget$ComboTitleBar$TitleShadowType[TitleShadowType.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface CenterDropClickListener {
        void onCenterDropClickListener();
    }

    public interface CenterRangeClickListener {
        void onRangeLeftClickListener();

        void onRangeRightClickListener();
    }

    public interface CenterViewClickListener {
        void onCenterViewClickListener(View view, int position);
    }

    public interface LeftBtnClickListener {
        void onLeftViewClickListener(View view);
    }

    public interface RightBtnClickListener {
        void onRightViewClickListener(View view, int position);
    }

    public static final enum TitleShadowType extends Enum<TitleShadowType> {
        private static final /* synthetic */ TitleShadowType[] $VALUES = null;
        public static final TitleShadowType NORMAL = null;
        public static final TitleShadowType SHORT = null;

        private TitleShadowType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static TitleShadowType valueOf(String name) {
            return (TitleShadowType) Enum.valueOf(TitleShadowType.class, name);
        }

        public static TitleShadowType[] values() {
            return (TitleShadowType[]) $VALUES.clone();
        }

        static {
            TitleShadowType r0 = new TitleShadowType("NORMAL", 0);
            NORMAL = r0;
            TitleShadowType r1 = new TitleShadowType("SHORT", 1);
            SHORT = r1;
            $VALUES = new TitleShadowType[]{r0, r1};
        }
    }

    static /* synthetic */ void access$000(ComboTitleBar r0) {
        r0.adjustContainerParams();
    }

    static /* synthetic */ CenterViewClickListener access$100(ComboTitleBar r0) {
        return r0.mCenterViewClickListener;
    }

    static /* synthetic */ View access$200(ComboTitleBar r0) {
        return r0.mCenterContentView;
    }

    static /* synthetic */ LeftBtnClickListener access$300(ComboTitleBar r0) {
        return r0.mLeftViewClickListener;
    }

    static /* synthetic */ CenterDropClickListener access$400(ComboTitleBar r0) {
        return r0.mCenterDropClickListener;
    }

    static /* synthetic */ CenterRangeClickListener access$500(ComboTitleBar r0) {
        return r0.mCenterRangeClickListener;
    }

    static /* synthetic */ RightBtnClickListener access$600(ComboTitleBar r0) {
        return r0.mRightViewClickListener;
    }

    static /* synthetic */ List access$700(ComboTitleBar r0) {
        return r0.mRightButtonList;
    }

    static {
        mRightBtnIds = new int[]{R.id.obric_id_combo_titlebar_right_btn1, R.id.obric_id_combo_titlebar_right_btn2, R.id.obric_id_combo_titlebar_right_btn3, R.id.obric_id_combo_titlebar_right_btn4, R.id.obric_id_combo_titlebar_right_btn5, R.id.obric_id_combo_titlebar_right_btn6, R.id.obric_id_combo_titlebar_right_btn7, R.id.obric_id_combo_titlebar_right_btn8, R.id.obric_id_combo_titlebar_right_btn9, R.id.obric_id_combo_titlebar_right_btn10};
    }

    public void setLeftViewClickListener(LeftBtnClickListener leftClickListener) {
        this.mLeftViewClickListener = leftClickListener;
    }

    public void setRightViewClickListener(RightBtnClickListener rightClickListener) {
        this.mRightViewClickListener = rightClickListener;
    }

    public void setCenterViewClickListener(final CenterViewClickListener centerViewClickListener) {
        this.mCenterViewClickListener = centerViewClickListener;
        View r0 = this.mCenterContentView;
        if ((r0 instanceof RadioGroup) == true) goto L6;
        r0.setOnClickListener(null);
        this.mCenterContentView.setOnClickListener(new AnonymousClass2(this, centerViewClickListener));
        return;
    }

    public void setCenterRangeClickListener(CenterRangeClickListener centerRangeClickListener) {
        this.mCenterRangeClickListener = centerRangeClickListener;
    }

    public void setCenterDropClickListener(CenterDropClickListener centerDropClickListener) {
        this.mCenterDropClickListener = centerDropClickListener;
    }

    public void setCenterRangeWheelTextChangeListener(SpinnerView.SpinnerRangeWheelTextChangeListener mRangeWheelTextChangeListener) {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r1).setRangeWheelTextChangeListener(mRangeWheelTextChangeListener);
        return;
    }

    public Button getLeftButton() {
        return this.mLeftButton;
    }

    public Button getRightButton() {
        return getRightButtonByIndex(0);
    }

    public Button getRightButtonByIndex(int index) {
        List<Button> r0 = this.mRightButtonList;
        if (r0 != null) goto L5;
    L13:
        return null;
    L5:
        if (r0.size() <= 0) goto L13;
        if (index < 0) goto L13;
        if (index >= this.mRightButtonList.size()) goto L13;
        return this.mRightButtonList.get(index);
    }

    public List<Button> getRightButtonList() {
        return this.mRightButtonList;
    }

    public void setLeftButtonEnable(boolean enable) {
        Button r0 = this.mLeftButton;
        if (r0 == null) goto L6;
        r0.setEnabled(enable);
        this.mLeftButton.setEnabledStyle(enable);
        return;
    }

    public void setRightButtonEnable(boolean enable) {
        List<Button> r0 = this.mRightButtonList;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L13;
        Iterator<Button> r1 = this.mRightButtonList.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        Button r2 = r1.next();
        r2.setEnabled(enable);
        r2.setEnabledStyle(enable);
        goto L9
    L14:
        return;
    }

    public void setRightButtonEnable(int index, boolean enable) {
        List<Button> r0 = this.mRightButtonList;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L15;
        if (index >= 0) goto L9;
        return;
    L9:
        if (index >= this.mRightButtonList.size()) goto L16;
        Button r1 = this.mRightButtonList.get(index);
        r1.setEnabled(enable);
        r1.setEnabledStyle(enable);
        return;
    L16:
        return;
    }

    public void setCenterContentText(List<String> contentList) {
        if (contentList != null) goto L4;
        return;
    L4:
        if (contentList.size() == 0) goto L9;
        String[] r0 = new String[contentList.size()];
        contentList.toArray(r0);
        setCenterContentText(r0);
        return;
    }

    public void setCenterContentText(String[] contentArray) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r0).setSpinnerPickText(contentArray, null);
    L8:
        schedule2AdjustTitle();
        return;
    L6:
        if ((r0 instanceof RadioGroup) == false) goto L8;
        ((RadioGroup) r0).setRadioList(contentArray);
        goto L8
    }

    public void setCenterContentText(String text) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r0).setSpinnerPickText(null, text);
    L14:
        schedule2AdjustTitle();
        return;
    L6:
        if ((r0 instanceof RadioGroup) == false) goto L9;
        ((RadioGroup) r0).setRadioList(new String[]{text});
        goto L14
    L9:
        if ((r0 instanceof MarqueeView) == false) goto L12;
        ((MarqueeView) r0).setTitle(text);
        goto L14
    L12:
        if ((r0 instanceof SeparatorView) == false) goto L14;
        ((SeparatorView) r0).setTitle(text);
        goto L14
    }

    public void setCenterSubContentText(CharSequence text) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r0).setSubContentText(text);
    L11:
        schedule2AdjustTitle();
        return;
    L6:
        if ((r0 instanceof MarqueeView) == false) goto L9;
        ((MarqueeView) r0).setSubTitle(text);
        goto L11
    L9:
        if ((r0 instanceof SeparatorView) == false) goto L11;
        ((SeparatorView) r0).setSubTitle(text);
        goto L11
    }

    public void setCenterContentAndSubContentText(String contentText, String subContentText) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r0).setSpinnerPickText(null, contentText);
        ((SpinnerView) this.mCenterContentView).setSubContentText(subContentText);
    L11:
        schedule2AdjustTitle();
        return;
    L6:
        if ((r0 instanceof MarqueeView) == false) goto L9;
        ((MarqueeView) r0).setTitle(contentText);
        ((MarqueeView) this.mCenterContentView).setSubTitle(subContentText);
        goto L11
    L9:
        if ((r0 instanceof SeparatorView) == false) goto L11;
        ((SeparatorView) r0).setTitle(contentText);
        ((SeparatorView) this.mCenterContentView).setSubTitle(subContentText);
        goto L11
    }

    public void setLeftButtonText(String text) {
        Button r0 = this.mLeftButton;
        if (r0 == null) goto L6;
        r0.setText(text);
        return;
    }

    public void setRightButtonText(String... text) {
        List<Button> r0 = this.mRightButtonList;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L17;
        if (text != null) goto L9;
        return;
    L9:
        if (text.length < 0) goto L18;
        int r1 = Math.min(this.mRightButtonList.size(), text.length);
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L19;
        this.mRightButtonList.get(r2).setText(text[r2]);
        r2 = r2 + 1;
        goto L12
    L19:
        return;
    L18:
        return;
    }

    public View getTitleLayoutView() {
        return this.mPrimaryTitleLayout;
    }

    public View getCenterContentView() {
        return this.mCenterContentView;
    }

    public ImageView getCenterLeftIcon() {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == true) goto L7;
        return null;
    L7:
        return ((SpinnerView) r1).getTextLeftIcon();
    }

    public void setCenterLeftIcon(int leftIconRef) {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == true) goto L5;
        return;
    L5:
        ((SpinnerView) r1).setCenterLeftIcon(leftIconRef);
    }

    public ImageButton getCenterRangeLeftIcon() {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == true) goto L5;
        return null;
    L5:
        return ((SpinnerView) r1).getRangeLeftIcon();
    }

    public ImageButton getCenterRangeRightIcon() {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == true) goto L5;
        return null;
    L5:
        return ((SpinnerView) r1).getRangeRightIcon();
    }

    public void setCenterRangeLeftIconVisible(int leftIconVisible) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r0).setLeftRangeSpinnerIconVisible(leftIconVisible);
        schedule2AdjustTitle();
        return;
    }

    public void setCenterRangeRightIconVisible(int rightIconVisible) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r0).setRightRangeSpinnerIconVisible(rightIconVisible);
        schedule2AdjustTitle();
        return;
    }

    public void setCenterRangeIconVisible(int visibleState) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r0).setRangeSpinnerIconVisible(visibleState);
        schedule2AdjustTitle();
        return;
    }

    public void setCenterRangeVerticalScroll(boolean isVerticalScroll) {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r1).setIsNeedVerticalScroll(isVerticalScroll);
        return;
    }

    public void addSecondaryBarView(View view) {
        if (view != null) goto L4;
        return;
    L4:
        setWithSecondaryLayout(view);
    }

    public ComboTitleBar(Context context) {
        this(context, null);
    }

    public ComboTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ComboTitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHandler = new AnonymousClass1(this);
        this.mRadioTabGroupCallback = new AnonymousClass3(this);
        LayoutInflater.from(context).inflate(R.layout.combo_title_layout, this, true);
        this.mPrimaryTitleLayout = (RelativeLayout) findViewById(R.id.primary_title);
        this.mLeftContainer = (FrameLayout) findViewById(R.id.left_container);
        this.mMidContainer = (RelativeLayout) findViewById(R.id.mid_container);
        this.mRightContainer = (LinearLayout) findViewById(R.id.right_container);
        this.mLeftPlaceholder = findViewById(R.id.left_placeholder);
        this.mRightPlaceholder = findViewById(R.id.right_placeholder);
        this.mPrimaryTitleShadow = findViewById(R.id.primary_title_shadow);
        this.mSecondaryBarShadow = findViewById(R.id.secondary_bar_shadow);
        this.mSecondaryBarContainer = (FrameLayout) findViewById(R.id.secondary_bar_container);
        this.mMidDefMargin = getResources().getDimensionPixelOffset(R.dimen.mid_container_margin);
        TypedArray r5 = context.obtainStyledAttributes(attrs, R.styleable.BytedanceComboTitleBar);
        this.mLeftButtonStyle = r5.getInt(R.styleable.BytedanceComboTitleBar_leftButtonStyle, -1);
        this.mLeftButtonText = r5.getString(R.styleable.BytedanceComboTitleBar_leftButtonText);
        this.mCenterContentStyle = r5.getInt(R.styleable.BytedanceComboTitleBar_centerContentStyle, -1);
        this.mCenterLeftIconRef = r5.getResourceId(R.styleable.BytedanceComboTitleBar_centerLeftIcon, -1);
        this.mCenterContentRef = r5.getResourceId(R.styleable.BytedanceComboTitleBar_centerContentRef, -1);
        this.mSecondaryLayoutRef = r5.getResourceId(R.styleable.BytedanceComboTitleBar_secondaryLayout, -1);
        if (this.mCenterContentRef >= 0) goto L16;
        this.mCenterContentText = r5.getString(R.styleable.BytedanceComboTitleBar_centerContentRef);
    L8:
        this.mCenterSubContentText = r5.getString(R.styleable.BytedanceComboTitleBar_centerSubContentRef);
        this.mIsRangeVerticalScroll = r5.getBoolean(R.styleable.BytedanceComboTitleBar_isCenterRangeVerticalScroll, false);
        this.mRightButtonStyle = r5.getInt(R.styleable.BytedanceComboTitleBar_rightButtonStyle, -1);
        this.mRightButtonText = r5.getString(R.styleable.BytedanceComboTitleBar_rightButtonText);
        this.mRightButtonIconRefList = r5.getResourceId(R.styleable.BytedanceComboTitleBar_rightIconArray, -1);
        int r6 = r5.getResourceId(R.styleable.BytedanceComboTitleBar_rightStyleArray, -1);
        int r0 = r5.getResourceId(R.styleable.BytedanceComboTitleBar_rightResArray, -1);
        this.mTitleColor = r5.getColorStateList(R.styleable.BytedanceComboTitleBar_smtTitleTextColor);
        this.mSubtitleColor = r5.getColorStateList(R.styleable.BytedanceComboTitleBar_smtSubtitleTextColor);
        this.isSupportLayout = r5.getBoolean(R.styleable.BytedanceComboTitleBar_support_layout, false);
        r5.recycle();
        this.mDefaultSpacingSize = context.getResources().getDimensionPixelSize(R.dimen.obric_small_blank_spacing_width);
        initCenterTextStyle(this.mCenterContentStyle, this.mCenterContentArray, this.mCenterContentText);
        setLeftButtonStyle(this.mLeftButtonStyle, this.mLeftButtonText);
        int r4 = this.mRightButtonStyle;
        if (r4 != 10) goto L11;
        setRightButtonStyle(r6, r0);
    L12:
        setSecondaryLayoutStyle(this.mSecondaryLayoutRef);
        if (this.isSupportLayout == false) goto L18;
        addOnLayoutChangeListener(new AnonymousClass4(this));
        return;
    L18:
        return;
    L11:
        setRightButtonStyle(r4, this.mRightButtonText, this.mRightButtonIconRefList);
        goto L12
    L16:
        this.mCenterContentText = getContext().getResources().getString(this.mCenterContentRef);     // Catch: Resources.NotFoundException -> L7
    L7:
        this.mCenterContentArray = getContext().getResources().getStringArray(this.mCenterContentRef);
        goto L8
    }

    public void updatePrimaryShadowParent() {
        ViewParent r0 = this.mPrimaryTitleShadow.getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        ((ViewGroup) r0).removeView(this.mPrimaryTitleShadow);
        ViewParent r1 = getParent();
        if ((r1 instanceof RelativeLayout) == false) goto L13;
        RelativeLayout r2 = (RelativeLayout) r1;
        RelativeLayout.LayoutParams r3 = new RelativeLayout.LayoutParams(-1, -2);
        r3.addRule(3, getId());
        if (getId() == (-1)) goto L10;
        r3.addRule(3, getId());
    L11:
        r2.addView(this.mPrimaryTitleShadow, r3);
        return;
    L10:
        r3.topMargin = getBottom();
        goto L11
    }

    public void setLeftButtonStyle(int btnStyle, String leftButtonText) {
        if (btnStyle >= 0) goto L5;
        return;
    L5:
        if (this.mLeftButton != null) goto L7;
        Button r0 = new Button(getContext());
        this.mLeftButton = r0;
        r0.setId(R.id.obric_id_combo_titlebar_left_btn);
        this.mLeftContainer.addView(this.mLeftButton);
    L7:
        this.mLeftButton.setButtonStyle(btnStyle);
        this.mLeftButton.setButtonText(leftButtonText);
        this.mLeftButton.setOnClickListener(new AnonymousClass5(this));
    }

    private void initCenterTextStyle(int contentStyle, String[] mContentArray, String mContentText) {
        setCenterTextStyle(contentStyle, mContentArray, mContentText);
        setCenterSubContentText(this.mCenterSubContentText);
    }

    public void setCenterTextStyle(int contentStyle, String[] contentArray, String contentText) {
        if (contentStyle >= 0) goto L5;
        return;
    L5:
        if (this.mMidContainer.getChildCount() <= 0) goto L7;
        this.mMidContainer.removeView(this.mCenterContentView);
    L7:
        if (contentStyle != 0) goto L9;
        this.mCenterContentView = new SpinnerView(getContext());
        setCenterSpinnerStyle(0);
    L26:
        if (this.mMidContainer.getChildCount() <= 0) goto L28;
        this.mMidContainer.removeView(this.mCenterContentView);
    L28:
        this.mMidContainer.addView(this.mCenterContentView);
        setCenterContent(contentStyle, contentArray, contentText);
        return;
    L9:
        if (contentStyle != 1) goto L11;
        RadioGroup r0 = new RadioGroup(getContext());
        this.mCenterContentView = r0;
        r0.setBytedanceRadioGroupCallback(this.mRadioTabGroupCallback);
        goto L26
    L11:
        if (contentStyle != 2) goto L13;
        this.mCenterContentView = new SpinnerView(getContext());
        setCenterSpinnerStyle(1);
        ((SpinnerView) this.mCenterContentView).setDropDownClickListener(new AnonymousClass6(this));
        goto L26
    L13:
        if (contentStyle != 3) goto L15;
        this.mCenterContentView = new SpinnerView(getContext());
        setCenterSpinnerStyle(2);
        ((SpinnerView) this.mCenterContentView).setRangeClickListener(new AnonymousClass7(this));
        goto L26
    L15:
        if (contentStyle != 4) goto L17;
        this.mCenterContentView = new MarqueeView(getContext());
        setCenterSpinnerStyle(4);
        goto L26
    L17:
        if (contentStyle != 5) goto L26;
        this.mCenterContentView = new SeparatorView(getContext());
        goto L26
    }

    public void updateCenterTextStyle(int contentStyle, String[] contentArray, String contentText) {
        this.mCenterContentStyle = contentStyle;
        this.mCenterContentArray = contentArray;
        this.mCenterContentText = contentText;
        this.mMidContainer.removeAllViews();
        setCenterTextStyle(this.mCenterContentStyle, this.mCenterContentArray, this.mCenterContentText);
    }

    private void setRightButtonStyle(int btnStyle, String rightButtonText, int rightIconRefList) {
        this.mRightButtonList = new ArrayList();
        if (btnStyle != 0) goto L5;
    L44:
        Button r13 = new Button(getContext());
        r13.setId(mRightBtnIds[0]);
        this.mRightContainer.addView(r13);
        r13.setButtonStyle(btnStyle);
        r13.setButtonText(rightButtonText);
        this.mRightButtonList.add(r13);
    L45:
        Iterator<Button> r11 = this.mRightButtonList.iterator();
    L47:
        if (r11.hasNext() == false) goto L51;
        final Button r12 = r11.next();
        if (r12 == null) goto L47;
        r12.setOnClickListener(new AnonymousClass8(this, r12));
        goto L47
    L51:
        return;
    L5:
        if (btnStyle == 2) goto L44;
        if (btnStyle == 3) goto L44;
        if (btnStyle == 8) goto L44;
        if (rightIconRefList > 0) goto L13;
        return;
    L13:
        TypedArray r14 = getContext().getResources().obtainTypedArray(rightIconRefList);
        int r1 = r14.length();
        if (r1 != 0) goto L24;
        r14.recycle();
        Button r15 = new Button(getContext());
        r15.setId(mRightBtnIds[0]);
        this.mRightContainer.addView(r15);
        if (btnStyle == (-1)) goto L22;
        if (btnStyle == 6) goto L21;
        if (btnStyle != 7) goto L23;
        r15.setButtonStyle(7);
        r15.setBackgroundResource(rightIconRefList);
    L23:
        this.mRightButtonList.add(r15);
        goto L45
    L21:
        r15.setButtonStyle(6);
        r15.setButtonSourceBitmap(rightIconRefList);
        goto L23
    L22:
        r15.setBackgroundResource(rightIconRefList);
        goto L23
    L24:
        int[] r5 = new int[r1];
        int r6 = 0;
    L25:
        if (r6 >= r1) goto L27;
        r5[r6] = r14.getResourceId(r6, -1);
        r6 = r6 + 1;
        goto L25
    L27:
        r14.recycle();
        int r16 = 0;
    L28:
        if (r16 >= r1) goto L45;
        Button r7 = new Button(getContext());
        r7.setId(mRightBtnIds[r16]);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        r8.gravity = 15;
        int r9 = r1 - 1;
        if (r16 == r9) goto L32;
        r8.rightMargin = 0 - this.mDefaultSpacingSize;
    L32:
        if (r16 != r9) goto L35;
        if (btnStyle != (-1)) goto L35;
        r8.rightMargin = this.mDefaultSpacingSize;
    L35:
        this.mRightContainer.addView(r7, r8);
        if (btnStyle == (-1)) goto L42;
        if (btnStyle == 6) goto L41;
        if (btnStyle != 7) goto L43;
        r7.setButtonStyle(7);
        r7.setBackgroundResource(r5[r16]);
    L43:
        this.mRightButtonList.add(r7);
        r16 = r16 + 1;
        goto L28
    L41:
        r7.setButtonStyle(6);
        r7.setButtonSourceBitmap(r5[r16]);
        goto L43
    L42:
        r7.setBackgroundResource(rightIconRefList);
        goto L43
    }

    private void setRightButtonStyle(int styleList, int resourceList) {
        if (styleList > 0) goto L4;
        return;
    L4:
        this.mRightButtonList = new ArrayList();
        TypedArray r8 = getContext().getResources().obtainTypedArray(styleList);
        TypedArray r9 = getContext().getResources().obtainTypedArray(resourceList);
        int r1 = 0;
    L6:
        if (r1 >= r8.length()) goto L27;
        int r3 = r8.getInt(r1, -1);
        Button r4 = new Button(getContext());
        r4.setId(mRightBtnIds[r1]);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        r5.gravity = 15;
        if (r1 == (r8.length() - 1)) goto L11;
        r5.rightMargin = 0 - this.mDefaultSpacingSize;
    L11:
        if (r1 != (r8.length() - 1)) goto L14;
        if (r3 != (-1)) goto L14;
        r5.rightMargin = this.mDefaultSpacingSize;
    L14:
        this.mRightContainer.addView(r4, r5);
        r4.setButtonStyle(r3);
        if (r3 != 0) goto L17;
        r4.setButtonText(r9.getString(r1));
    L26:
        this.mRightButtonList.add(r4);
        r1 = r1 + 1;
        goto L6
    L17:
        if (r3 != 9) goto L19;
        r4.setBackgroundResource(r9.getResourceId(r1, -1));
        goto L26
    L19:
        if (r3 != 6) goto L21;
    L23:
        r4.setButtonSourceBitmap(r9.getResourceId(r1, -1));
        goto L26
    L21:
        if (r3 == 7) goto L23;
    L27:
        r8.recycle();
        r9.recycle();
        Iterator<Button> r10 = this.mRightButtonList.iterator();
    L29:
        if (r10.hasNext() == false) goto L33;
        final Button r11 = r10.next();
        if (r11 == null) goto L29;
        r11.setOnClickListener(new AnonymousClass9(this, r11));
        goto L29
    }

    private RelativeLayout.LayoutParams getMidContainerParams() {
        return (RelativeLayout.LayoutParams) this.mMidContainer.getLayoutParams();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        adjustContainerParams();
    }

    private void schedule2AdjustTitle() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 1);
    }

    private void setPlaceholderWidth(View ph, int width) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) ph.getLayoutParams();
        r0.width = width;
        ph.setLayoutParams(r0);
    }

    private void adjustContainerParams() {
        int r0 = this.mLeftContainer.getMeasuredWidth();
        int r1 = this.mMidContainer.getMeasuredWidth();
        int r2 = this.mRightContainer.getMeasuredWidth();
        int r3 = getMeasuredWidth();
        int r4 = Math.max(r0, r2);
        RelativeLayout.LayoutParams r5 = getMidContainerParams();
        if (r3 > 0) goto L5;
        return;
    L5:
        if (r1 <= 0) goto L22;
        int r8 = r4 * 2;
        if ((r1 + r8) < (r3 - (this.mMidDefMargin * 2))) goto L15;
        r5.removeRule(13);
        r5.addRule(9);
        setPlaceholderWidth(this.mLeftPlaceholder, r0);
        setPlaceholderWidth(this.mRightPlaceholder, r2);
        View r6 = this.mCenterContentView;
        if ((r6 instanceof SpinnerView) == false) goto L12;
        ((SpinnerView) r6).setPickerAvailWidth(((r3 - r0) - r2) - (this.mMidDefMargin * 2));
    L14:
        r5.leftMargin = r0 + this.mMidDefMargin;
        r5.rightMargin = r2 + this.mMidDefMargin;
        return;
    L12:
        if ((r6 instanceof RadioGroup) == false) goto L14;
        ((RadioGroup) r6).setAvailWidth(((r3 - r0) - r2) - (this.mMidDefMargin * 2));
        goto L14
    L15:
        setPlaceholderWidth(this.mLeftPlaceholder, r4);
        setPlaceholderWidth(this.mRightPlaceholder, r4);
        View r7 = this.mCenterContentView;
        if ((r7 instanceof SpinnerView) == false) goto L19;
        ((SpinnerView) r7).setPickerAvailWidth((r3 - r8) - (this.mMidDefMargin * 2));
    L21:
        r5.removeRule(9);
        r5.addRule(13);
        int r10 = this.mMidDefMargin;
        r5.leftMargin = r10;
        r5.rightMargin = r10;
        return;
    L19:
        if ((r7 instanceof RadioGroup) == false) goto L21;
        ((RadioGroup) r7).setAvailWidth((r3 - r8) - (this.mMidDefMargin * 2));
        goto L21
    L22:
        View r11 = this.mCenterContentView;
        if ((r11 instanceof SpinnerView) == false) goto L26;
        ((SpinnerView) r11).setPickerAvailWidth((r3 - r0) - r2);
    L28:
        r5.removeRule(9);
        r5.addRule(13);
        return;
    L26:
        if ((r11 instanceof RadioGroup) == false) goto L28;
        ((RadioGroup) r11).setAvailWidth((r3 - r0) - r2);
        goto L28
    }

    private void setCenterContent(int contentStyle, String[] mContentArray, String mContentText) {
        if (contentStyle != 1) goto L7;
        if (mContentArray == null) goto L6;
        ((RadioGroup) this.mCenterContentView).setRadioList(mContentArray);
        return;
    L6:
        ((RadioGroup) this.mCenterContentView).setRadioList(new String[]{mContentText});
        return;
    L7:
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == false) goto L11;
        ((SpinnerView) r1).setSpinnerPickText(mContentArray, mContentText);
        return;
    L11:
        if (contentStyle != 5) goto L14;
        ((SeparatorView) r1).setTitle(mContentText);
        return;
    L14:
        if (contentStyle != 4) goto L21;
        ((MarqueeView) r1).setTitle(mContentText);
        return;
    }

    private void setCenterSpinnerStyle(int spinnerStyle) {
        View r0 = this.mCenterContentView;
        if ((r0 instanceof SpinnerView) == false) goto L11;
        SpinnerView r1 = (SpinnerView) r0;
        r1.setIsNeedVerticalScroll(this.mIsRangeVerticalScroll);
        r1.setCenterLeftIcon(this.mCenterLeftIconRef);
        r1.setSpinnerPickText(this.mCenterContentArray, this.mCenterContentText);
        r1.setSpinnerStyle(spinnerStyle);
        ColorStateList r4 = this.mTitleColor;
        if (r4 == null) goto L7;
        setTitleColor(r4.getDefaultColor());
    L7:
        ColorStateList r5 = this.mSubtitleColor;
        if (r5 == null) goto L19;
        setSubtitleColor(r5.getDefaultColor());
        return;
    L19:
        return;
    L11:
        if ((r0 instanceof MarqueeView) == false) goto L21;
        ColorStateList r6 = this.mTitleColor;
        if (r6 == null) goto L15;
        setTitleColor(r6.getDefaultColor());
    L15:
        ColorStateList r7 = this.mSubtitleColor;
        if (r7 == null) goto L22;
        setSubtitleColor(r7.getDefaultColor());
        return;
    L22:
        return;
    }

    public void setTitleColor(int colorValue) {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r1).setTitleColor(colorValue);
        return;
    L6:
        if ((r1 instanceof MarqueeView) == false) goto L10;
        ((MarqueeView) r1).setTitleColor(colorValue);
        return;
    }

    public void setSubtitleColor(int colorValue) {
        View r1 = this.mCenterContentView;
        if ((r1 instanceof SpinnerView) == false) goto L6;
        ((SpinnerView) r1).setSubtitleColor(colorValue);
        return;
    L6:
        if ((r1 instanceof MarqueeView) == false) goto L10;
        ((MarqueeView) r1).setSubTitleColor(colorValue);
        return;
    }

    private void setSecondaryLayoutStyle(int secondaryLayoutRef) {
        if (secondaryLayoutRef > 0) goto L4;
        setWithOutSecondaryLayout();
        return;
    L4:
        View r3 = LayoutInflater.from(getContext()).inflate(secondaryLayoutRef, null);
        if (r3 != null) goto L7;
        setWithOutSecondaryLayout();
        return;
    L7:
        setWithSecondaryLayout(r3);
    }

    public void setTitleShadowVisibility(boolean vis) {
        View r0 = this.mPrimaryTitleShadow;
        if (vis == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setTitleShadowType(TitleShadowType type) {
        int r2 = AnonymousClass10.$SwitchMap$obric$widget$ComboTitleBar$TitleShadowType[type.ordinal()];
        if (r2 != 1) goto L5;
        this.mPrimaryTitleShadow.setBackgroundResource(R.drawable.title_bar_shadow_short);
        return;
    L5:
        if (r2 != 2) goto L11;
        this.mPrimaryTitleShadow.setBackgroundResource(R.drawable.obric_title_bar_shadow);
        return;
    }

    public void setSecondaryBarShadowVisibility(boolean vis) {
        View r0 = this.mSecondaryBarShadow;
        if (vis == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private void setWithOutSecondaryLayout() {
        this.mSecondaryBarContainer.setVisibility(8);
        this.mSecondaryBarShadow.setVisibility(8);
        this.mPrimaryTitleShadow.setBackgroundResource(R.drawable.obric_title_bar_shadow);
    }

    private void setWithSecondaryLayout(View view) {
        if (this.mSecondaryBarContainer.getChildCount() <= 0) goto L5;
        this.mSecondaryBarContainer.removeAllViews();
    L5:
        this.mSecondaryBarContainer.addView(view);
        this.mSecondaryBarContainer.setVisibility(0);
        this.mSecondaryBarShadow.setVisibility(0);
        this.mSecondaryBarShadow.setBackgroundResource(R.drawable.secondary_bar_shadow);
        this.mPrimaryTitleShadow.setBackgroundResource(R.drawable.title_bar_shadow_short);
    }
}
