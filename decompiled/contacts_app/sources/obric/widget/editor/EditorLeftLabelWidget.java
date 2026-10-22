package obric.widget.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import obric.util.Utils;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class EditorLeftLabelWidget extends LinearLayout {
    private ImageView mArrow;
    private View mDividerView;
    private ImageView mIcon;
    private View.OnClickListener mIconClickListener;
    private ViewGroup mIconContainer;
    private TextView mLabel;
    private View.OnClickListener mLabelClickListener;
    private LinearLayout mRightSlotView;

    static /* synthetic */ View.OnClickListener access$000(EditorLeftLabelWidget r0) {
        return r0.mIconClickListener;
    }

    static /* synthetic */ ImageView access$100(EditorLeftLabelWidget r0) {
        return r0.mIcon;
    }

    static /* synthetic */ View.OnClickListener access$200(EditorLeftLabelWidget r0) {
        return r0.mLabelClickListener;
    }

    public EditorLeftLabelWidget(Context context) {
        this(context, null);
    }

    public EditorLeftLabelWidget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditorLeftLabelWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(0);
        setGravity(16);
        setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.editor_left_right_widget_min_height));
        View r1 = LayoutInflater.from(context).inflate(R.layout.editor_left_label_layout, this, true);
        this.mIcon = (ImageView) r1.findViewById(R.id.icon);
        this.mLabel = (TextView) r1.findViewById(R.id.label);
        this.mArrow = (ImageView) r1.findViewById(R.id.arrow);
        this.mRightSlotView = (LinearLayout) r1.findViewById(R.id.rightExpandView);
        this.mIconContainer = (ViewGroup) r1.findViewById(R.id.iconContainer);
        this.mDividerView = r1.findViewById(R.id.divider);
        this.mIcon.setOnClickListener(new AnonymousClass1(this));
        this.mLabel.setOnClickListener(new AnonymousClass2(this));
    }

    public void setIconContainerBackground(int drawable) {
        this.mIconContainer.setBackgroundResource(drawable);
    }

    public void setIconDrawable(Drawable d) {
        if (d != null) goto L4;
        this.mIconContainer.setVisibility(8);
    L5:
        this.mIcon.setImageDrawable(d);
        return;
    L4:
        this.mIconContainer.setVisibility(0);
        goto L5
    }

    public void setIconResource(int resId) {
        this.mIconContainer.setVisibility(0);
        this.mIcon.setImageResource(resId);
    }

    public void setOnIconClickListener(View.OnClickListener listener) {
        this.mIconClickListener = listener;
    }

    public void setOnLabelClickListener(View.OnClickListener listener) {
        this.mLabelClickListener = listener;
    }

    public void setArrowVisible(boolean visible) {
        ImageView r0 = this.mArrow;
        if (visible == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        int r1 = getResources().getDimensionPixelSize(R.dimen.editor_element_margin_left_right);
        if (visible == false) goto L9;
        setArrowRightMargin(r1);
        setLabelRightMargin(0);
        return;
    L9:
        setArrowRightMargin(0);
        setLabelRightMargin(r1);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setLabelRightMargin(int margin) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mLabel.getLayoutParams();
        r0.rightMargin = margin;
        this.mLabel.setLayoutParams(r0);
    }

    public void setLabelLeftMargin(int margin) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mLabel.getLayoutParams();
        r0.leftMargin = margin;
        this.mLabel.setLayoutParams(r0);
    }

    private void setArrowRightMargin(int margin) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mArrow.getLayoutParams();
        r0.rightMargin = margin;
        this.mArrow.setLayoutParams(r0);
    }

    public void setLabelGravity(int gravity) {
        if (gravity != 48) goto L5;
        this.mLabel.setPadding(0, 30, 0, 30);
    L6:
        this.mLabel.setGravity(gravity);
        return;
    L5:
        this.mLabel.setPadding(0, 18, 0, 18);
        goto L6
    }

    public void setText(CharSequence s) {
        this.mLabel.setText(s);
        TextView r1 = this.mLabel;
        if (TextUtils.isEmpty(s) == false) goto L5;
        int r2 = 8;
    L6:
        r1.setVisibility(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setText(int resId) {
        setText(getResources().getString(resId));
    }

    public CharSequence getText() {
        return this.mLabel.getText();
    }

    public float getTextWidth() {
        return Utils.calculateTextWidth(this.mLabel);
    }

    public void setScale(int width, int height) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new FrameLayout.LayoutParams(width, height);
    L6:
        setLayoutParams(r0);
        return;
    L5:
        r0.width = width;
        r0.height = height;
        goto L6
    }

    public void setLabelWidth(int width) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mLabel.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new LinearLayout.LayoutParams(width, -1);
    L6:
        this.mLabel.setLayoutParams(r0);
        return;
    L5:
        r0.width = width;
        goto L6
    }

    public void setRightExpandView(View view) {
        this.mRightSlotView.removeAllViews();
        if (view == null) goto L5;
        this.mRightSlotView.addView(view);
        this.mRightSlotView.setVisibility(0);
        return;
    L5:
        if (this.mRightSlotView.getVisibility() == 8) goto L9;
        this.mRightSlotView.setVisibility(8);
        return;
    }

    public View getIconView() {
        return this.mIcon;
    }

    public void setShowDivider(boolean showDivider) {
        View r0 = this.mDividerView;
        if (showDivider == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }
}
