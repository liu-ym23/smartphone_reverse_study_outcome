package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import obric.InvokeApi;
import obric.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ListContentItem extends RelativeLayout {
    public static final int BG_STYLE_BOTTOM = 4;
    public static final int BG_STYLE_MIDDLE = 3;
    public static final int BG_STYLE_SINGLE = 1;
    public static final int BG_STYLE_TOP = 2;
    private static final int CACHE_LIMITE_SIZE = 3;
    private static volatile HashMap<Float, Bitmap[]> mCacheMap;
    private static ContentObserver mObserver;
    private static float mPhoneDensity;
    private int mBackgroundStyle;
    private final int[] mBgResId;
    private final int[] mBgShadowResId;
    private float mDensity;
    protected int mDisableReasonStringId;
    protected ImageView mIcon;
    protected boolean mIsCustomMidView;
    protected boolean mIsCustomRightView;
    protected FrameLayout mLeftContainer;
    protected LinearLayout mMidContainer;
    private OnDisabledClickListener mOnDisabledClickListener;
    private Paint mPaint;
    protected boolean mPressable;
    protected LinearLayout mRightContainer;
    private ShadowDrawableHelper mShadowHelper;
    protected TextView mSummary;
    protected TextView mTitle;
    protected Toast mToast;

    public interface OnDisabledClickListener {
        void onDisabledClick();
    }

    protected abstract int getDefaultRightLayout();

    protected abstract void initRightWidget();

    protected boolean rightContainerHasFixedWidth() {
        return true;
    }

    static {
        mCacheMap = new HashMap();
    }

    public ListContentItem(Context context) {
        this(context, null);
    }

    public ListContentItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListContentItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBgShadowResId = new int[]{R.drawable.list_content_item_single_shadow, R.drawable.list_content_item_top_shadow, R.drawable.list_content_item_middle_shadow, R.drawable.list_content_item_bottom_shadow};
        this.mBgResId = new int[]{R.drawable.group_list_item_bg_single, R.drawable.group_list_item_bg_top, R.drawable.group_list_item_bg_mid, R.drawable.group_list_item_bg_bottom};
        this.mPaint = new Paint(-16777216);
        init(context, attrs, defStyleAttr);
    }

    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setGravity(15);
        LayoutInflater r0 = LayoutInflater.from(context);
        boolean r2 = true;
        View r1 = r0.inflate(R.layout.list_content_item_layout, this, true);
        this.mLeftContainer = (FrameLayout) r1.findViewById(R.id.left_container);
        this.mMidContainer = (LinearLayout) r1.findViewById(R.id.mid_container);
        this.mRightContainer = (LinearLayout) r1.findViewById(R.id.right_container);
        TypedArray r11 = context.obtainStyledAttributes(attrs, R.styleable.ListContentItem, defStyleAttr, 0);
        int r3 = r11.getResourceId(R.styleable.ListContentItem_smtIcon, -1);
        String r5 = r11.getString(R.styleable.ListContentItem_smtTitle);
        String r6 = r11.getString(R.styleable.ListContentItem_smtSummary);
        this.mBackgroundStyle = r11.getInt(R.styleable.ListContentItem_backgroundStyle, -1);
        this.mPressable = r11.getBoolean(R.styleable.ListContentItem_isPressable, true);
        int r7 = r11.getResourceId(R.styleable.ListContentItem_customMidView, -1);
        int r8 = r11.getResourceId(R.styleable.ListContentItem_customRightView, -1);
        if (r8 <= 0) goto L5;
        boolean r9 = true;
    L6:
        this.mIsCustomRightView = r9;
        if (r7 > 0) goto L10;
        r2 = false;
    L10:
        this.mIsCustomMidView = r2;
        int r4 = getDefaultLeftLayout();
        if (this.mIsCustomMidView == true) goto L15;
        r7 = getDefaultMidLayout();
    L15:
        if (this.mIsCustomRightView == true) goto L18;
        r8 = getDefaultRightLayout();
    L18:
        inflateView(r4, this.mLeftContainer, r0);
        inflateView(r7, this.mMidContainer, r0);
        inflateView(r8, this.mRightContainer, r0);
        initViews();
        ShadowDrawableHelper r10 = new ShadowDrawableHelper(this, attrs, defStyleAttr);
        this.mShadowHelper = r10;
        if (r10.hasNewShadowFeature() == true) goto L21;
    L25:
        r11.recycle();
        setTitle(r5);
        setSummary(r6);
        setIcon(r3);
        updateBackgroundShadow();
        return;
    L21:
        if (this.mBackgroundStyle == (-1)) goto L25;
        if (getBackground() == null) goto L25;
        setBackground(getBackground());
        goto L25
    L5:
        r9 = false;
        goto L6
    }

    private void clearPcCacheWhenExitPcMode() {
        Iterator<Map.Entry<Float, Bitmap[]>> r2 = mCacheMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (Float.compare(r2.next().getKey().floatValue(), mPhoneDensity) == 0) goto L4;
        r2.remove();
        goto L4
    }

    protected void inflateView(int id, ViewGroup container, LayoutInflater inflater) {
        if (id <= 0) goto L5;
        inflater.inflate(id, container);
        return;
    }

    private void initViews() {
        initLeftWidget();
        if (this.mIsCustomMidView == true) goto L6;
        initMidWidget();
    L6:
        if (this.mIsCustomRightView == true) goto L9;
        initRightWidget();
        return;
    }

    protected void initLeftWidget() {
        this.mIcon = (ImageView) findViewById(R.id.left_icon);
    }

    protected void initMidWidget() {
        this.mTitle = (TextView) findViewById(R.id.item_title);
        this.mSummary = (TextView) findViewById(R.id.item_summary);
    }

    public void setOnDisabledClickListener(OnDisabledClickListener disabledClickListener) {
        this.mOnDisabledClickListener = disabledClickListener;
    }

    public void setTitle(CharSequence s) {
        TextView r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setText(s);
        return;
    }

    public void setTitle(int resId) {
        setTitle(getContext().getString(resId));
    }

    public CharSequence getTitle() {
        TextView r0 = this.mTitle;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText();
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    public void setSummary(CharSequence s) {
        TextView r0 = this.mSummary;
        if (r0 == null) goto L10;
        r0.setText(s);
        TextView r1 = this.mSummary;
        if (TextUtils.isEmpty(s) == false) goto L7;
        int r2 = 8;
    L8:
        r1.setVisibility(r2);
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public void setSummary(int resId) {
        setSummary(getContext().getString(resId));
    }

    public CharSequence getSummary() {
        TextView r0 = this.mSummary;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText();
    }

    public TextView getSummaryView() {
        return this.mSummary;
    }

    public void setIcon(int resId) {
        if (resId <= 0) goto L6;
        ImageView r0 = this.mIcon;
        if (r0 == null) goto L6;
        r0.setImageResource(resId);
    L6:
        if (resId <= 0) goto L8;
        boolean r2 = true;
    L9:
        setLeftContainerVisible(r2);
        return;
    L8:
        r2 = false;
        goto L9
    }

    public void setIcon(Drawable d) {
        ImageView r0 = this.mIcon;
        if (r0 == null) goto L5;
        r0.setImageDrawable(d);
    L5:
        if (d == null) goto L7;
        boolean r2 = true;
    L8:
        setLeftContainerVisible(r2);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public ImageView getIconView() {
        return this.mIcon;
    }

    public void setDisabledTips(int stringId) {
        this.mDisableReasonStringId = stringId;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (shouldHandleDisabledTouchEvent(ev) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(ev) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (shouldHandleDisabledTouchEvent(event) == false) goto L18;
        if (event.getAction() != 1) goto L16;
        OnDisabledClickListener r3 = this.mOnDisabledClickListener;
        if (r3 == null) goto L10;
        r3.onDisabledClick();
    L10:
        if (this.mDisableReasonStringId <= 0) goto L16;
        Toast r4 = this.mToast;
        if (r4 != null) goto L14;
    L15:
        Toast r5 = Toast.makeText(getContext(), this.mDisableReasonStringId, 1);
        this.mToast = r5;
        r5.show();
        goto L16
    L14:
        if (r4.getView().getWindowVisibility() != 0) goto L15;
    L16:
        return true;
    L18:
        return super.onTouchEvent(event);
    }

    protected boolean shouldHandleDisabledTouchEvent(MotionEvent event) {
        if (isEnabled() == false) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L13;
        Rect r1 = new Rect();
        getGlobalVisibleRect(r1);
        return r1.contains((int) event.getRawX(), (int) event.getRawY());
    L13:
        return false;
    L5:
        if (this.mOnDisabledClickListener == null) goto L7;
    L8:
        r0 = true;
        goto L10
    L7:
        if (this.mDisableReasonStringId <= 0) goto L9;
        goto L8
    }

    public void cancelToast() {
        Toast r0 = this.mToast;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public void setLeftContainerVisible(boolean visible) {
        FrameLayout r0 = this.mLeftContainer;
        int r1 = 0;
        if (visible == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) this.mMidContainer.getLayoutParams();
        if (visible == false) goto L9;
        r3.removeRule(9);
        r3.addRule(1, R.id.left_container);
    L10:
        this.mMidContainer.setLayoutParams(r3);
        int r4 = getResources().getDimensionPixelSize(R.dimen.flexible_space);
        if (visible == true) goto L14;
        r1 = r4;
    L14:
        setMidContentPaddingLeft(r1);
        return;
    L9:
        r3.addRule(9);
        goto L10
    L5:
        r2 = 8;
        goto L6
    }

    protected void setMidContainerWidth(int width) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mMidContainer.getLayoutParams();
        r0.width = width;
        this.mMidContainer.setLayoutParams(r0);
    }

    protected float getLeftContentWidth() {
        if (this.mLeftContainer.getVisibility() == 0) goto L5;
        return 0.0f;
    L5:
        return getResources().getDimensionPixelSize(R.dimen.left_icon_area_width);
    }

    protected float getMidContentWidth() {
        float r0 = Utils.calculateTextWidth(this.mTitle);
        float r1 = Utils.calculateTextWidth(this.mSummary);
        return Math.max(r0, r1) + this.mMidContainer.getPaddingLeft();
    }

    protected void setMidContentPaddingLeft(int paddingLeft) {
        LinearLayout r0 = this.mMidContainer;
        r0.setPadding(paddingLeft, r0.getPaddingTop(), this.mMidContainer.getPaddingRight(), this.mMidContainer.getPaddingBottom());
    }

    protected float getRightContentWidth() {
        throw new RuntimeException("calculate your width");
    }

    protected int getDefaultLeftLayout() {
        return R.layout.list_content_left_image_view;
    }

    protected int getDefaultMidLayout() {
        return R.layout.list_content_mid_primary_2line;
    }

    public void setBackgroundStyle(int style) {
        if (this.mBackgroundStyle != style) goto L6;
        return;
    L6:
        if (style >= 1) goto L8;
        return;
    L8:
        if (style > 4) goto L12;
        int r0 = this.mBgResId[style - 1];
        this.mBackgroundStyle = style;
        setBackgroundResource(r0);
        updateBackgroundShadow();
        return;
    }

    private void initShadowResource(Context context) {
        this.mDensity = getResources().getConfiguration().densityDpi;
        if (mCacheMap.get(Float.valueOf(this.mDensity)) == null) goto L6;
        return;
    L6:
        if (mCacheMap.size() != 3) goto L13;
        float r5 = mPhoneDensity;
        if (r5 != 0.0f) goto L11;
        r5 = mCacheMap.keySet().iterator().next().floatValue();
    L11:
        this.mDensity = r5;
        return;
    L13:
        mPhoneDensity = this.mDensity;
        Resources r6 = context.getResources();
        Bitmap[] r0 = new Bitmap[this.mBgShadowResId.length];
        int r1 = 0;
    L14:
        int[] r2 = this.mBgShadowResId;
        if (r1 >= r2.length) goto L17;
        r0[r1] = BitmapFactory.decodeResource(r6, r2[r1]);
        r1 = r1 + 1;
        goto L14
    L17:
        mCacheMap.put(Float.valueOf(this.mDensity), r0);
    }

    private void updateBackgroundShadow() {
        if (this.mShadowHelper.hasNewShadowFeature() == false) goto L5;
        return;
    L5:
        initShadowResource(getContext());
        Bitmap[] r0 = mCacheMap.get(Float.valueOf(this.mDensity));
        int r1 = this.mBackgroundStyle;
        if (r1 >= 1) goto L8;
        return;
    L8:
        if (r1 > 4) goto L12;
        setBgShadowBitmap(r0[r1 - 1]);
        return;
    }

    private void setBgShadowBitmap(Bitmap bitmap) {
        if (bitmap == null) goto L5;
        NinePatch r1 = new NinePatch(bitmap, bitmap.getNinePatchChunk());
        Drawable r0 = getBackground();
        int r2 = r0.getIntrinsicWidth();
        int r3 = r0.getIntrinsicHeight();
        int r4 = (bitmap.getWidth() - r2) / 2;
        float r5 = r4;
        float r6 = (bitmap.getHeight() - r3) / 2;
        InvokeApi.xView.setShadowProperty(this, r1, this.mPaint, r5, r6, r5, r6);
        setElevation(0.1f);
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        if (this.mPressable == true) goto L5;
        return;
    L5:
        if (pressed == true) goto L7;
    L11:
        boolean r0 = false;
    L12:
        boolean r1 = isInScrollingContainer();
        if (r0 == false) goto L15;
        if (r1 == true) goto L15;
        return;
    L15:
        super.setPressed(pressed);
        return;
    L7:
        if (isClickable() == true) goto L11;
        if (isLongClickable() == true) goto L11;
        r0 = true;
        goto L12
    }

    public void setPressable(boolean pressable) {
        this.mPressable = pressable;
    }

    public boolean isPressable() {
        return this.mPressable;
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        ShadowDrawableHelper r0 = this.mShadowHelper;
        if (r0 != null) goto L5;
    L11:
        super.setBackground(background);
        return;
    L5:
        if (r0.hasNewShadowFeature() == false) goto L11;
        if (validStyle() == false) goto L11;
        if (this.mShadowHelper.setBackground(background, this.mBgShadowResId[this.mBackgroundStyle - 1]) == false) goto L11;
    }

    public void setShadowEnabled(boolean enabled) {
        this.mShadowHelper.setShadowEnabled(enabled);
    }

    public void setShadowShouldProjects(boolean shouldProjects) {
        this.mShadowHelper.setShadowShouldProjects(shouldProjects);
    }

    private boolean validStyle() {
        int r2 = this.mBackgroundStyle;
        if (r2 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 4) goto L7;
        return true;
    }
}
