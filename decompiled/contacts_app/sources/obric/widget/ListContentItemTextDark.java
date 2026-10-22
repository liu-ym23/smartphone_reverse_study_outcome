package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import obric.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class ListContentItemTextDark extends ListContentItemDark {
    private ImageView mArrow;
    private boolean mDirty;
    private LinearLayout mRightSlotView;
    private TextView mSubtitle;

    @Override // obric.widget.ListContentItem
    protected boolean rightContainerHasFixedWidth() {
        return false;
    }

    public ListContentItemTextDark(Context context) {
        super(context);
    }

    public ListContentItemTextDark(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListContentItemTextDark(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.ListContentItemText, defStyleAttr, 0);
        boolean r4 = r3.getBoolean(R.styleable.ListContentItemText_show_arrow, true);
        String r5 = r3.getString(R.styleable.ListContentItemText_subTitle);
        setArrowVisible(r4);
        setSubtitle(r5);
        r3.recycle();
    }

    @Override // obric.widget.ListContentItemDark, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ImageView r1 = this.mArrow;
        if (r1 == null) goto L6;
        r1.setImageResource(R.drawable.selector_list_content_item_arrow);
        return;
    }

    @Override // obric.widget.ListContentItem
    protected void initRightWidget() {
        this.mSubtitle = (TextView) findViewById(R.id.subtitle);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mRightSlotView = (LinearLayout) findViewById(R.id.rightExpandView);
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return R.layout.list_content_right_subtitle_arrow;
    }

    @Override // obric.widget.ListContentItem
    public void setTitle(CharSequence s) {
        if (this.mIsCustomMidView == false) goto L5;
        return;
    L5:
        super.setTitle(s);
    }

    @Override // obric.widget.ListContentItem
    public void setSummary(CharSequence s) {
        if (this.mIsCustomMidView == false) goto L5;
        return;
    L5:
        super.setSummary(s);
    }

    public void setSubtitle(CharSequence s) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        TextView r0 = this.mSubtitle;
        if (r0 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(s) == false) goto L10;
        int r1 = 8;
    L11:
        r0.setVisibility(r1);
        this.mSubtitle.setText(s);
        return;
    L10:
        r1 = 0;
        goto L11
    }

    public void setSubtitle(int resId) {
        setSubtitle(getContext().getString(resId));
    }

    public CharSequence getSubTitle() {
        if (this.mIsCustomRightView == false) goto L7;
        return null;
    L7:
        return this.mSubtitle.getText();
    }

    public TextView getSubTitleView() {
        return this.mSubtitle;
    }

    public void setArrowVisible(boolean showArrow) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        ImageView r0 = this.mArrow;
        if (showArrow == false) goto L8;
        int r2 = 0;
    L9:
        r0.setVisibility(r2);
        setSubtitleRightPadding(getSubtitleRightPadding());
        return;
    L8:
        r2 = 8;
        goto L9
    }

    public void setSubtitleRightPadding(int rightPadding) {
        this.mSubtitle.setPadding(getPaddingLeft(), getPaddingTop(), rightPadding, getPaddingBottom());
    }

    private int getSubtitleRightPadding() {
        if (this.mArrow.getVisibility() == 8) goto L7;
        return 0;
    L7:
        return getResources().getDimensionPixelSize(R.dimen.list_right_text_right_padding);
    }

    protected void limitContainerWidth() {
        if (this.mIsCustomMidView == false) goto L5;
        return;
    L5:
        if (this.mIsCustomRightView == false) goto L8;
        return;
    L8:
        if (rightContainerHasFixedWidth() == false) goto L10;
        return;
    L10:
        if (getMeasuredWidth() <= 0) goto L31;
        int r0 = getMeasuredWidth();
        float r1 = getLeftContentWidth();
        float r2 = getMidContentWidth();
        float r3 = getRightContentWidth();
        float r4 = r0;
        if (((r1 + r2) + r3) <= r4) goto L26;
        int r5 = getResources().getDimensionPixelSize(R.dimen.item_text_mid_width_limit);
        if (r1 != 0.0f) goto L16;
        r5 = r5 + getResources().getDimensionPixelSize(R.dimen.left_icon_area_width);
    L16:
        float r7 = r5;
        if (r2 <= r7) goto L19;
        setMidContainerWidth(r5);
        float r6 = (r4 - r1) - r7;
        this.mDirty = true;
    L21:
        if (r6 <= 0.0f) goto L32;
        TextView r8 = this.mSubtitle;
        if (r8 == null) goto L33;
        r8.setMaxWidth((int) (r6 - ((r3 - Utils.calculateTextWidth(r8)) - getSubtitleRightPadding())));
        this.mDirty = true;
        return;
    L33:
        return;
    L32:
        return;
    L19:
        r6 = (r4 - r1) - r2;
        goto L21
    L26:
        if (this.mSubtitle.getMaxWidth() == Integer.MAX_VALUE) goto L35;
        this.mSubtitle.setMaxWidth(Integer.MAX_VALUE);
        this.mDirty = true;
        return;
    L35:
        return;
    }

    @Override // obric.widget.ListContentItem
    protected float getRightContentWidth() {
        if (this.mIsCustomRightView == true) goto L5;
        float r0 = (Utils.calculateTextWidth(this.mSubtitle) + getSubtitleRightPadding()) + 0.0f;
        Resources r1 = getResources();
        if (this.mArrow.getVisibility() == 8) goto L10;
        r0 = r0 + r1.getDrawable(R.drawable.selector_list_content_item_arrow).getIntrinsicWidth();
    L10:
        if (hasRightExpandView() == false) goto L13;
        r0 = r0 + this.mRightSlotView.getMeasuredWidth();
    L13:
        return r0 + (r1.getDimensionPixelSize(R.dimen.right_container_margin) + r1.getDimensionPixelSize(R.dimen.flexible_space));
    L5:
        return this.mRightContainer.getMeasuredWidth();
    }

    public void setRightExpandView(View view) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        this.mRightSlotView.removeAllViews();
        if (view == null) goto L8;
        this.mRightSlotView.addView(view);
        this.mRightSlotView.setVisibility(0);
        return;
    L8:
        if (this.mRightSlotView.getVisibility() == 8) goto L12;
        this.mRightSlotView.setVisibility(8);
        return;
    }

    public boolean hasRightExpandView() {
        int r0 = this.mRightSlotView.getChildCount();
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        if (this.mRightSlotView.getChildAt(r1).getVisibility() == 8) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        limitContainerWidth();
        if (this.mDirty == false) goto L6;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mDirty = false;
        return;
    }
}
