package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.VectorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* JADX INFO: loaded from: classes5.dex */
public class BottomBarItemView extends LinearLayout implements Checkable {
    private static final int ANIM_DURATION = 200;
    private static final float BIG_SCALE = 1.0f;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int ITEM_TEXT_NORMAL_SIZE = 9;
    private static final float NORMAL_SCALE = 0.9f;
    private boolean mBroadcasting;
    private boolean mChecked;
    private ImageView mImageView;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private boolean mScalable;
    private SpringForce mSpringForce;
    private SpringAnimation mSpringImageAnimationX;
    private SpringAnimation mSpringImageAnimationY;
    private SpringAnimation mSpringTextAnimationX;
    private SpringAnimation mSpringTextAnimationY;
    private TextView mTextView;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(BottomBarItemView itemView, boolean isChecked);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    static {
        CHECKED_STATE_SET = new int[]{android.R.attr.state_checked};
    }

    public BottomBarItemView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public BottomBarItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public BottomBarItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setGravity(17);
        setOrientation(1);
        setClickable(true);
        this.mSpringForce = new SpringForce().setDampingRatio(0.55f).setStiffness(800.0f);
    }

    public void setDrawableResource(int id) {
        getImageViewOrCreate().setImageResource(id);
    }

    public void setDrawableResource(int id, String description) {
        setDrawableResource(id);
        getImageViewOrCreate().setContentDescription(description);
    }

    public void setDrawableColorList(int colorStateList) {
        if (this.mScalable == true) goto L5;
        return;
    L5:
        if ((this.mImageView.getDrawable() instanceof VectorDrawable) == false) goto L9;
        ((VectorDrawable) this.mImageView.getDrawable()).setTintList(getResources().getColorStateList(colorStateList));
        return;
    }

    public void setTextColor(ColorStateList colors) {
        getTextViewOrCreate().setTextColor(colors);
    }

    public void setTextSize(float size) {
        getTextViewOrCreate().setTextSize(size);
    }

    public void setText(String text) {
        if (TextUtils.isEmpty(text) == false) goto L5;
        return;
    L5:
        getTextViewOrCreate().setText(text);
    }

    public void setScaleable(boolean scaleable) {
        this.mScalable = scaleable;
    }

    private ImageView getImageViewOrCreate() {
        ImageView r0 = this.mImageView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ImageView r1 = new ImageView(getContext());
        this.mImageView = r1;
        r1.setDuplicateParentStateEnabled(true);
        if (this.mScalable == false) goto L8;
        this.mImageView.setScaleX(NORMAL_SCALE);
        this.mImageView.setScaleY(NORMAL_SCALE);
        this.mSpringImageAnimationX = new SpringAnimation(this.mImageView, BarsHelper.SCALE).setMinimumVisibleChange(0.00390625f);
        this.mSpringImageAnimationY = new SpringAnimation(this.mImageView, BarsHelper.SCALE).setMinimumVisibleChange(0.00390625f);
    L8:
        addView(this.mImageView, generateDefaultLayoutParams());
        return this.mImageView;
    }

    private TextView getTextViewOrCreate() {
        TextView r0 = this.mTextView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        TextView r1 = new TextView(getContext());
        this.mTextView = r1;
        r1.setTextSize(9.0f);
        this.mTextView.setGravity(49);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setSingleLine();
        this.mTextView.setTypeface(Typeface.DEFAULT_BOLD);
        this.mTextView.setDuplicateParentStateEnabled(true);
        LinearLayout.LayoutParams r2 = generateDefaultLayoutParams();
        r2.topMargin = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_drawablePadding);
        if (this.mScalable == false) goto L8;
        this.mTextView.setScaleX(NORMAL_SCALE);
        this.mTextView.setScaleY(NORMAL_SCALE);
        this.mSpringTextAnimationX = new SpringAnimation(this.mTextView, BarsHelper.SCALE).setMinimumVisibleChange(0.00390625f);
        this.mSpringTextAnimationY = new SpringAnimation(this.mTextView, BarsHelper.SCALE).setMinimumVisibleChange(0.00390625f);
    L8:
        addView(this.mTextView, r2);
        return this.mTextView;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] r1 = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked() == false) goto L5;
        mergeDrawableStates(r1, CHECKED_STATE_SET);
    L5:
        return r1;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.mChecked == checked) goto L12;
        this.mChecked = checked;
        refreshDrawableState();
        if (this.mBroadcasting == false) goto L7;
        return;
    L7:
        this.mBroadcasting = true;
        startAnimIfNeed(checked, false);
        OnCheckedChangeListener r3 = this.mOnCheckedChangeListener;
        if (r3 == null) goto L10;
        r3.onCheckedChanged(this, this.mChecked);
    L10:
        this.mBroadcasting = false;
        return;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isChecked() == true) goto L6;
        setChecked(!this.mChecked);
        return;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int r0 = event.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        startAnimIfNeed(false, true);
    L11:
        return super.onTouchEvent(event);
    L6:
        if (r0 == 3) goto L8;
    L9:
        startAnimIfNeed(true, true);
        goto L11
    }

    private void startAnimIfNeed(boolean zoomin, boolean fromTouch) {
        if (this.mScalable == true) goto L5;
        return;
    L5:
        float r0 = 1.0f;
        if (fromTouch == false) goto L9;
        if (zoomin == false) goto L12;
        r0 = 1.1f;
    L12:
        this.mSpringForce.setFinalPosition(r0);
        SpringAnimation r2 = this.mSpringImageAnimationX;
        if (r2 == null) goto L15;
        r2.setSpring(this.mSpringForce).start();
        this.mSpringImageAnimationY.setSpring(this.mSpringForce).start();
    L15:
        SpringAnimation r3 = this.mSpringTextAnimationX;
        if (r3 == null) goto L19;
        r3.setSpring(this.mSpringForce).start();
        this.mSpringTextAnimationY.setSpring(this.mSpringForce).start();
        return;
    L19:
        return;
    L9:
        if (zoomin == true) goto L12;
        r0 = NORMAL_SCALE;
        goto L12
    }
}
