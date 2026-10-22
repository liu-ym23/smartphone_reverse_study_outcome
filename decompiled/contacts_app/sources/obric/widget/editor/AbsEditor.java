package obric.widget.editor;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import obric.widget.PasswordEditText;
import obric.widget.QuickDeleteEditText;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbsEditor extends LinearLayout implements View.OnClickListener {
    public static final int BG_STYLE_BOTTOM = 4;
    public static final int BG_STYLE_MIDDLE = 3;
    public static final int BG_STYLE_SINGLE = 1;
    public static final int BG_STYLE_TOP = 2;
    public static final int EDITOR_TYPE_DEFAULT = 0;
    public static final int EDITOR_TYPE_PASSWORD = 1;
    public static final int EDITOR_TYPE_QUICK_DELETE = 2;
    protected int mBackgroundStyle;
    protected EditText mEditor;
    private int mEditorType;
    private InputMethodManager mInputMethodManager;
    private FrameLayout mLeftContainer;
    protected LinearLayout mMidContainer;
    private LinearLayout mRightContainer;

    protected abstract int getDefaultLeftLayout();

    protected abstract int getDefaultRightLayout();

    protected abstract void initLeftWidget();

    protected abstract void initRightWidget();

    public AbsEditor(Context context) {
        this(context, null);
    }

    public AbsEditor(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AbsEditor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        boolean r0 = false;
        this.mEditorType = 0;
        setOrientation(0);
        LayoutInflater r1 = LayoutInflater.from(context);
        r1.inflate(R.layout.abs_editor_layout, this, true);
        this.mLeftContainer = (FrameLayout) findViewById(R.id.left_container);
        this.mMidContainer = (LinearLayout) findViewById(R.id.mid_container);
        this.mRightContainer = (LinearLayout) findViewById(R.id.right_container);
        TypedArray r6 = context.obtainStyledAttributes(attrs, R.styleable.AbsEditor, defStyleAttr, 0);
        this.mEditorType = r6.getInt(R.styleable.AbsEditor_editorType, 0);
        this.mBackgroundStyle = r6.getInt(R.styleable.AbsEditor_backgroundStyle, -1);
        int r7 = getDefaultLeftLayout();
        int r8 = getDefaultMidLayout();
        int r2 = getDefaultRightLayout();
        if (r7 <= 0) goto L5;
        r1.inflate(r7, this.mLeftContainer);
        boolean r9 = false;
    L6:
        r1.inflate(r8, this.mMidContainer);
        if (r2 <= 0) goto L9;
        r1.inflate(r2, this.mRightContainer);
    L10:
        initViews();
        EditText r10 = this.mEditor;
        if (r10 == null) goto L15;
        r10.setHint(r6.getText(R.styleable.AbsEditor_android_hint));
        setSingleLine(r6.getBoolean(R.styleable.AbsEditor_singleLine, true));
        setEditable(r6.getBoolean(R.styleable.AbsEditor_editable, true));
        if (r0 == false) goto L15;
        setOnClickListener(this);
    L15:
        r6.recycle();
        requestLayout();
        return;
    L9:
        r0 = r9;
        goto L10
    L5:
        setLeftContainerVisible(false);
        r9 = true;
        goto L6
    }

    public void setEditorType(int type) {
        if (type <= 2) goto L6;
        type = 0;
    L6:
        if (type != this.mEditorType) goto L8;
        return;
    L8:
        this.mEditorType = type;
        reInflateMidView();
    }

    private void reInflateMidView() {
        this.mMidContainer.removeAllViews();
        LayoutInflater.from(getContext()).inflate(getDefaultMidLayout(), this.mMidContainer);
        initMidWidget();
    }

    private void initViews() {
        initLeftWidget();
        initMidWidget();
        initRightWidget();
    }

    private void setLeftContainerVisible(boolean visible) {
        FrameLayout r0 = this.mLeftContainer;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) this.mMidContainer.getLayoutParams();
        if (visible == false) goto L9;
        r2.removeRule(9);
        r2.addRule(1, R.id.left_container);
    L10:
        this.mMidContainer.setLayoutParams(r2);
        return;
    L9:
        r2.addRule(9);
        goto L10
    L5:
        r1 = 8;
        goto L6
    }

    protected void initMidWidget() {
        EditText r0 = (EditText) findViewById(R.id.editor);
        this.mEditor = r0;
        if (r0 == null) goto L5;
        r0.setId(generateViewId());
    L5:
        setRightPaddingForSpecialEditor();
    }

    public void setParagraphMode(boolean paragraphMode) {
        setSingleLine(!paragraphMode);
        if (paragraphMode == false) goto L5;
        int r0 = getResources().getDimensionPixelSize(R.dimen.editor_large_vertical_margin);
    L6:
        setEditorMarginVertically(r0, r0);
        EditText r2 = this.mEditor;
        if (paragraphMode == false) goto L9;
        int r3 = 48;
    L10:
        r2.setGravity(r3);
        return;
    L9:
        r3 = 16;
        goto L10
    L5:
        r0 = getResources().getDimensionPixelSize(R.dimen.editor_small_vertical_margin);
        goto L6
    }

    public EditText getEditText() {
        return this.mEditor;
    }

    public void setEditable(boolean enable) {
        this.mEditor.setFocusable(enable);
        this.mEditor.setFocusableInTouchMode(enable);
    }

    public void setEditorMarginVertically(int top, int bottom) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mEditor.getLayoutParams();
        r0.topMargin = top;
        r0.bottomMargin = bottom;
        this.mEditor.setLayoutParams(r0);
    }

    public void setText(CharSequence s) {
        this.mEditor.setText(s);
    }

    public void setText(int resId) {
        setText(getResources().getString(resId));
    }

    public void setInputType(int type) {
        this.mEditor.setInputType(type);
    }

    public void setTransformationMethod(TransformationMethod method) {
        this.mEditor.setTransformationMethod(method);
    }

    public void setSingleLine(boolean singleLine) {
        if (this.mEditorType == 1) goto L6;
        this.mEditor.setSingleLine(singleLine);
        return;
    }

    public void setLeftContainerCenterVertical(boolean centerVertical) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mLeftContainer.getLayoutParams();
        if (centerVertical == true) goto L5;
        r0.removeRule(15);
    L6:
        this.mLeftContainer.setLayoutParams(r0);
        return;
    L5:
        r0.addRule(15);
        goto L6
    }

    public void setEditorGravity(int gravity) {
        this.mEditor.setGravity(gravity);
    }

    protected int getDefaultMidLayout() {
        int r1 = this.mEditorType;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return R.layout.edit_text;
    L9:
        return R.layout.quick_del_edit_text;
    L11:
        return R.layout.pwd_edit_text;
    }

    private void setRightPaddingForSpecialEditor() {
        int r0 = getResources().getDimensionPixelOffset(R.dimen.editor_text_icon_horizontal_margin);
        EditText r1 = this.mEditor;
        if ((r1 instanceof PasswordEditText) == false) goto L6;
        ((PasswordEditText) r1).setEyePaddingLeft(r0);
        ((PasswordEditText) this.mEditor).setEyePaddingRight(0);
        return;
    L6:
        if ((r1 instanceof QuickDeleteEditText) == false) goto L10;
        ((QuickDeleteEditText) r1).setIconPaddingLeft(r0);
        ((QuickDeleteEditText) this.mEditor).setIconPaddingRight(0);
        return;
    }

    public EditText getEditor() {
        return this.mEditor;
    }

    public void setBackgroundStyle(int style) {
        if (this.mBackgroundStyle != style) goto L6;
        return;
    L6:
        if (style != 1) goto L8;
        int r0 = R.drawable.editor_bg_single;
    L18:
        if (r0 <= 0) goto L21;
        this.mBackgroundStyle = style;
        setBackgroundResource(r0);
        return;
    L21:
        return;
    L8:
        if (style != 2) goto L10;
        r0 = R.drawable.editor_bg_top;
        goto L18
    L10:
        if (style != 3) goto L12;
        r0 = R.drawable.editor_bg_middle;
        goto L18
    L12:
        if (style == 4) goto L14;
        r0 = -1;
        goto L18
    L14:
        r0 = R.drawable.editor_bg_bottom;
        goto L18
    }

    public void addRightViewComponent(View view) {
        if (view != null) goto L4;
        return;
    L4:
        FrameLayout r1 = (FrameLayout) findViewById(R.id.right_view_component);
        if (r1 != null) goto L7;
        return;
    L7:
        r1.setVisibility(0);
        r1.addView(view);
    }

    protected void setContainerRightPadding(int rightPadding) {
        View r3 = findViewById(R.id.container);
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), rightPadding, r3.getPaddingBottom());
    }

    protected void setContainerLeftPadding(int leftPadding) {
        View r3 = findViewById(R.id.container);
        r3.setPadding(leftPadding, r3.getPaddingTop(), r3.getPaddingRight(), r3.getPaddingBottom());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        this.mEditor.requestFocus();
        if (this.mEditor.isFocused() == true) goto L5;
        return;
    L5:
        if (this.mInputMethodManager != null) goto L7;
        this.mInputMethodManager = (InputMethodManager) this.mEditor.getContext().getSystemService("input_method");
    L7:
        this.mInputMethodManager.showSoftInput(this.mEditor, 0);
    }
}
