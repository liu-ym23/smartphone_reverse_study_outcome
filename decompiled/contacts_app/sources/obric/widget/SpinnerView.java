package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes5.dex */
public class SpinnerView extends RelativeLayout {
    public static final int SPINNER_STYLE_DROP = 1;
    public static final int SPINNER_STYLE_NORMAL = 0;
    public static final int SPINNER_STYLE_RANGE = 2;
    private int mBasicBlankSpacingWidth;
    private SpinnerDropDownClickListener mDropDownListener;
    private ImageButton mDropIcon;
    private int mIconWidth;
    private boolean mIsVerticalScroll;
    private SpinnerRangeClickListener mRangeClickListener;
    private ImageButton mRangeLeftIcon;
    private ImageButton mRangeRightIcon;
    private SpinnerRangeWheelTextChangeListener mRangeWheelTextChangeListener;
    private int mSpinnerStyle;
    private ImageView mTextLeftIcon;
    private int mTextLeftIconRef;
    private WheelTextView mTextPicker;
    private String[] mTitleArray;
    private String mTitleText;

    public interface SpinnerDropDownClickListener {
        void onDropDownClick();
    }

    public interface SpinnerRangeClickListener {
        void onRangeLeftClick();

        void onRangeRightClick();
    }

    public interface SpinnerRangeWheelTextChangeListener {
        void onWheelTextChangeListener(WheelTextView view, int oldVal, int newVal);
    }

    static /* synthetic */ SpinnerRangeWheelTextChangeListener access$000(SpinnerView r0) {
        return r0.mRangeWheelTextChangeListener;
    }

    static /* synthetic */ SpinnerDropDownClickListener access$100(SpinnerView r0) {
        return r0.mDropDownListener;
    }

    static /* synthetic */ SpinnerRangeClickListener access$200(SpinnerView r0) {
        return r0.mRangeClickListener;
    }

    public ImageView getTextLeftIcon() {
        return this.mTextLeftIcon;
    }

    public SpinnerView(Context context) {
        this(context, null);
    }

    public SpinnerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpinnerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.BytedanceSpinner);
        this.mSpinnerStyle = r3.getInt(R.styleable.BytedanceSpinner_smtSpinnerStyle, 0);
        int r4 = r3.getResourceId(R.styleable.BytedanceSpinner_spinnerText, -1);
        if (r4 >= 0) goto L13;
        this.mTitleText = r3.getString(R.styleable.BytedanceComboTitleBar_centerContentRef);
    L8:
        this.mTextLeftIconRef = r3.getResourceId(R.styleable.BytedanceSpinner_spinnerLeftIcon, -1);
        this.mIsVerticalScroll = r3.getBoolean(R.styleable.BytedanceSpinner_isVerticalScroll, false);
        r3.recycle();
        int r5 = this.mSpinnerStyle;
        if (r5 < 0) goto L11;
        setSpinnerStyle(r5);
    L11:
        this.mBasicBlankSpacingWidth = getContext().getResources().getDimensionPixelOffset(R.dimen.obric_small_blank_spacing_width);
        this.mIconWidth = getContext().getResources().getDimensionPixelOffset(R.dimen.obric_spinner_small_icon_width);
        return;
    L13:
        this.mTitleText = getContext().getResources().getString(r4);     // Catch: Resources.NotFoundException -> L7
    L7:
        this.mTitleArray = getContext().getResources().getStringArray(r4);
        goto L8
    }

    public void setIsNeedVerticalScroll(boolean isNeedScroll) {
        this.mIsVerticalScroll = isNeedScroll;
        WheelTextView r0 = this.mTextPicker;
        if (r0 == null) goto L6;
        r0.setIsNeedRotate(isNeedScroll);
        return;
    }

    public void setCenterLeftIcon(int leftIconRef) {
        this.mTextLeftIconRef = leftIconRef;
    }

    public void setSpinnerPickText(String[] textArray, String text) {
        this.mTitleArray = textArray;
        this.mTitleText = text;
        if (this.mTextPicker == null) goto L6;
        setPickerText();
        return;
    }

    private int measureViewWith(View view) {
        if (view == null) goto L6;
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        return view.getMeasuredWidth();
    L6:
        return 0;
    }

    public void setPickerAvailWidth(int max) {
        int r0 = this.mSpinnerStyle;
        if (r0 != 1) goto L6;
        int r1 = measureViewWith(this.mDropIcon);
    L5:
        max = max - (r1 * 2);
    L8:
        WheelTextView r3 = this.mTextPicker;
        if (r3 == null) goto L12;
        r3.setAvailWidth(max);
        return;
    L12:
        return;
    L6:
        if (r0 != 2) goto L8;
        r1 = this.mIconWidth;
        goto L5
    }

    public void setSubContentText(CharSequence text) {
        if (text == null) goto L4;
        setSubContentText(text.toString());
        return;
    L4:
        setSubContentText(null);
    }

    public void setSubContentText(String text) {
        WheelTextView r0 = this.mTextPicker;
        if (r0 == null) goto L6;
        r0.setSubContentText(text);
        return;
    }

    public void setSpinnerStyle(int spinnerStyle) {
        this.mSpinnerStyle = spinnerStyle;
        setTitleStyle(spinnerStyle);
        if (spinnerStyle != 1) goto L5;
        setLeftIconStyle();
        setDropIconStyle();
        adjustTextPickerLayoutParams();
        return;
    L5:
        if (spinnerStyle != 2) goto L11;
        setRangeIconStyle();
        this.mTextPicker.setIsNeedRotate(this.mIsVerticalScroll);
        return;
    }

    private void adjustTextPickerLayoutParams() {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mTextPicker.getLayoutParams();
        if (this.mTextLeftIconRef > 0) goto L5;
        int r1 = this.mBasicBlankSpacingWidth * 2;
    L6:
        r0.leftMargin = r1;
        this.mTextPicker.setLayoutParams(r0);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public void setTitleColor(int colorValue) {
        this.mTextPicker.setTitleColor(colorValue);
    }

    public void setTitleSize(float size) {
        this.mTextPicker.setTextSize(size);
    }

    public void setTitleMaxSize(float maxSize) {
        this.mTextPicker.setTextMaxSize(maxSize);
    }

    public void setSubtitleColor(int colorValue) {
        this.mTextPicker.setSubtitleColor(colorValue);
    }

    public void setSubtitleTextSize(float size) {
        this.mTextPicker.setSubTextSize(size);
    }

    private void setTitleStyle(int spinnerStyle) {
        WheelTextView r2 = new WheelTextView(getContext());
        this.mTextPicker = r2;
        r2.setId(R.id.id_obric_spinner_text);
        setPickerText();
        RelativeLayout.LayoutParams r3 = new RelativeLayout.LayoutParams(-2, -2);
        r3.addRule(13);
        addView(this.mTextPicker, r3);
        this.mTextPicker.setEnabled(true);
        if (this.mSpinnerStyle != 2) goto L6;
        this.mTextPicker.setOnValueChangedListener(new AnonymousClass1(this));
        return;
    }

    private void setLeftIconStyle() {
        if (this.mTextLeftIconRef > 0) goto L5;
        return;
    L5:
        this.mTextLeftIcon = new ImageView(getContext());
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-2, -2);
        r0.addRule(15);
        r0.addRule(0, this.mTextPicker.getId());
        r0.rightMargin = this.mBasicBlankSpacingWidth;
        addView(this.mTextLeftIcon, r0);
        this.mTextLeftIcon.setImageResource(this.mTextLeftIconRef);
    }

    private void setDropIconStyle() {
        this.mDropIcon = new ImageButton(getContext());
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-2, -2);
        r0.addRule(15);
        r0.addRule(1, this.mTextPicker.getId());
        r0.rightMargin = this.mBasicBlankSpacingWidth;
        addView(this.mDropIcon, r0);
        this.mDropIcon.setBackgroundColor(0);
        this.mDropIcon.setImageResource(R.drawable.selector_dropdown_arrow);
        this.mDropIcon.setOnClickListener(new AnonymousClass2(this));
    }

    private void setRangeIconStyle() {
        this.mRangeLeftIcon = new ImageButton(getContext());
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-2, -2);
        r0.addRule(15);
        r0.addRule(0, this.mTextPicker.getId());
        r0.leftMargin = this.mBasicBlankSpacingWidth;
        addView(this.mRangeLeftIcon, r0);
        this.mRangeLeftIcon.setBackgroundColor(0);
        this.mRangeLeftIcon.setImageResource(R.drawable.selector_previous_arrow);
        this.mRangeRightIcon = new ImageButton(getContext());
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-2, -2);
        r1.addRule(15);
        r1.addRule(1, this.mTextPicker.getId());
        r1.rightMargin = this.mBasicBlankSpacingWidth;
        addView(this.mRangeRightIcon, r1);
        this.mRangeRightIcon.setBackgroundColor(0);
        this.mRangeRightIcon.setImageResource(R.drawable.selector_next_arrow);
        this.mRangeLeftIcon.setOnClickListener(new AnonymousClass3(this));
        this.mRangeRightIcon.setOnClickListener(new AnonymousClass4(this));
        int r2 = getResources().getDimensionPixelSize(R.dimen.obric_spinner_view_text_width);
        this.mTextPicker.setMinimumWidth(r2);
    }

    private void setPickerText() {
        String[] r0 = this.mTitleArray;
        if (r0 != null) goto L5;
        setTitleArray(new String[]{this.mTitleText});
        return;
    L5:
        setTitleArray(r0);
    }

    void setTitleArray(String... title) {
        this.mTitleArray = title;
        if (title.length != 1) goto L5;
        this.mTextPicker.setIsNeedRotate(false);
    L6:
        this.mTextPicker.setDisplayedValues(title);
        return;
    L5:
        this.mTextPicker.setIsNeedRotate(true);
        goto L6
    }

    public void seTextLeftIcon(int iconRef) {
        if (iconRef <= 0) goto L4;
    L6:
        this.mTextLeftIconRef = iconRef;
        ImageView r0 = this.mTextLeftIcon;
        if (r0 == null) goto L9;
        r0.setImageResource(iconRef);
    L10:
        adjustTextPickerLayoutParams();
        return;
    L9:
        setLeftIconStyle();
        goto L10
    L4:
        if (this.mSpinnerStyle != 2) goto L6;
    }

    public void setDropDownClickListener(SpinnerDropDownClickListener listener) {
        this.mDropDownListener = listener;
    }

    public void setRangeClickListener(SpinnerRangeClickListener listener) {
        this.mRangeClickListener = listener;
    }

    public void setRangeWheelTextChangeListener(SpinnerRangeWheelTextChangeListener listener) {
        this.mRangeWheelTextChangeListener = listener;
    }

    public void setLeftRangeSpinnerIconVisible(int visibleState) {
        if (this.mSpinnerStyle == 2) goto L5;
        return;
    L5:
        ImageButton r2 = this.mRangeLeftIcon;
        if (r2 != null) goto L8;
        return;
    L8:
        r2.setVisibility(visibleState);
    }

    public void setRightRangeSpinnerIconVisible(int visibleState) {
        if (this.mSpinnerStyle == 2) goto L5;
        return;
    L5:
        ImageButton r2 = this.mRangeRightIcon;
        if (r2 != null) goto L8;
        return;
    L8:
        r2.setVisibility(visibleState);
    }

    public void setRangeSpinnerIconVisible(int visibleState) {
        setLeftRangeSpinnerIconVisible(visibleState);
        setRightRangeSpinnerIconVisible(visibleState);
    }

    public void setDropdownIconVisibility(int visibleState) {
        ImageButton r0 = this.mDropIcon;
        if (r0 == null) goto L6;
        r0.setVisibility(visibleState);
        return;
    }

    public View getDropdownIconView() {
        return this.mDropIcon;
    }

    public ImageButton getRangeLeftIcon() {
        return this.mRangeLeftIcon;
    }

    public ImageButton getRangeRightIcon() {
        return this.mRangeRightIcon;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.mTextPicker.setOnClickListener(l);
    }

    public int getSpinnerStyle() {
        return this.mSpinnerStyle;
    }
}
