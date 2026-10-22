package obric.widget.support;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class ListPopupMenu extends PopupMenu {
    private static final String TAG = "BytedanceListPopMenu";
    private TextView mActionText;
    private ListAdapter mAdapter;
    private View mBottomActionBar;
    private View mBottomDivider;
    private boolean mIsGroupMenuAdapter;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private Button mLeftBtn;
    private View.OnClickListener mLeftBtnListener;
    private ImageView mLeftImageView;
    private int mListVerticalPadding;
    private ListView mListView;
    private TextView mMenuListTitle;
    private Button mRightBtn;
    private View.OnClickListener mRightBtnListener;
    private ImageView mRightImageView;
    private boolean mShowBottomActionBar;
    private boolean mShowDivider;
    private boolean mShowMenuListTitle;
    private boolean mShowPadding;
    private LinearLayout mTitleContainer;

    public ListPopupMenu(Context context) {
        super(context);
        this.mShowDivider = true;
        this.mContentAreaWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.popup_list_menu_default_width);
        initViews();
    }

    public ListPopupMenu(Context context, int width) {
        super(context);
        this.mShowDivider = true;
        this.mContentAreaWidth = width - (this.mBgLeftRightShadowWidth * 2);
        initViews();
    }

    private void initViews() {
        this.mListVerticalPadding = this.mContext.getResources().getDimensionPixelOffset(R.dimen.popup_list_menu_padding_vertical);
        this.mMenuPanelView = LayoutInflater.from(this.mContext).inflate(R.layout.menu_popupwindow_layout, null);
        this.mTitleContainer = (LinearLayout) this.mMenuPanelView.findViewById(R.id.menu_title_container);
        this.mListView = (ListView) this.mMenuPanelView.findViewById(R.id.menu_list);
        this.mMenuListTitle = (TextView) this.mMenuPanelView.findViewById(R.id.menu_title);
        this.mBottomActionBar = this.mMenuPanelView.findViewById(R.id.bottom_action_bar);
        this.mBottomDivider = this.mMenuPanelView.findViewById(R.id.menu_list_bottom_divider);
        this.mLeftImageView = (ImageView) this.mMenuPanelView.findViewById(R.id.left_icon);
        this.mRightImageView = (ImageView) this.mMenuPanelView.findViewById(R.id.right_icon);
        this.mLeftBtn = (Button) this.mMenuPanelView.findViewById(R.id.left_btn);
        this.mRightBtn = (Button) this.mMenuPanelView.findViewById(R.id.right_btn);
        this.mActionText = (TextView) this.mMenuPanelView.findViewById(R.id.action_text);
    }

    public void setAdapter(ListAdapter adapter) {
        this.mAdapter = adapter;
        ListView r0 = this.mListView;
        if (r0 == null) goto L5;
        r0.setAdapter(adapter);
    L5:
        boolean r2 = adapter instanceof GroupMenuAdapter;
        this.mIsGroupMenuAdapter = r2;
        if (r2 == false) goto L9;
        this.mContentAreaWidth = this.mContext.getResources().getDimensionPixelOffset(R.dimen.popup_list_menu_long_press_width);
        return;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener itemSelectedListener) {
        this.mItemSelectedListener = itemSelectedListener;
    }

    @Override // obric.widget.support.PopupMenu
    protected void prepareShow() {
        View r0 = this.mBottomActionBar;
        int r2 = 0;
        if (this.mShowBottomActionBar == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        View r3 = this.mBottomDivider;
        if (this.mShowBottomActionBar == false) goto L9;
        int r4 = 0;
    L10:
        r3.setVisibility(r4);
        LinearLayout r5 = this.mTitleContainer;
        if (this.mShowMenuListTitle == true) goto L14;
        r2 = 8;
    L14:
        r5.setVisibility(r2);
        if (this.mLeftBtn.getVisibility() != 0) goto L17;
        View r6 = this.mLeftBtn;
    L19:
        if (this.mRightBtn.getVisibility() != 0) goto L21;
        View r7 = this.mRightBtn;
    L22:
        r6.setOnClickListener(this.mLeftBtnListener);
        r7.setOnClickListener(this.mRightBtnListener);
        buildList();
        return;
    L21:
        r7 = this.mRightImageView;
        goto L22
    L17:
        r6 = this.mLeftImageView;
        goto L19
    L9:
        r4 = 8;
        goto L10
    L5:
        r1 = 8;
        goto L6
    }

    public void setBottomActionBarVisible(boolean visible) {
        this.mShowBottomActionBar = visible;
    }

    public void setLeftButtonText(CharSequence text) {
        this.mLeftBtn.setText(text);
    }

    public void setLeftImageViewRes(int res) {
        this.mLeftImageView.setImageResource(res);
    }

    public void setLeftButtonOnClickListener(View.OnClickListener listener) {
        this.mLeftBtnListener = listener;
    }

    public void setRightButtonText(CharSequence text) {
        this.mRightBtn.setText(text);
    }

    public void setRightImageViewRes(int res) {
        this.mRightImageView.setImageResource(res);
    }

    public void setRightButtonOnClickListener(View.OnClickListener listener) {
        this.mRightBtnListener = listener;
    }

    public void setLeftButtonVisible(boolean visible) {
        ImageView r0 = this.mLeftImageView;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setRightButtonVisible(boolean visible) {
        ImageView r0 = this.mRightImageView;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setBottomText(CharSequence text) {
        this.mActionText.setText(text);
    }

    public void setMenuListTitleVisible(boolean visible) {
        this.mShowMenuListTitle = visible;
    }

    public void setMenuListTitle(CharSequence text) {
        this.mMenuListTitle.setText(text);
    }

    public int getListViewHeight() {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mAdapter.getCount()) goto L10;
        View r3 = this.mAdapter.getView(r1, null, this.mListView);
        r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r2 = r2 + r3.getMeasuredHeight();
        if (this.mShowDivider == false) goto L8;
        r2 = r2 + this.mListView.getDividerHeight();
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        if (this.mShowPadding == true) goto L12;
        return r2;
    L12:
        return r2 + (this.mListVerticalPadding * 2);
    }

    public int getBottomActionBarHeight() {
        if (this.mBottomActionBar.getVisibility() != 8) goto L5;
        return 0;
    L5:
        this.mBottomActionBar.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mBottomActionBar.getMeasuredHeight();
    }

    public int getMenuListTitleHeight() {
        if (this.mMenuListTitle.getVisibility() != 8) goto L7;
        return 0;
    L7:
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.popup_list_menu_title_height);
    }

    private void buildList() {
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this.mItemClickListener);
        this.mListView.setOnItemSelectedListener(this.mItemSelectedListener);
        this.mListView.setFocusable(true);
        if (this.mShowDivider == false) goto L6;
        this.mListView.setDivider(this.mContext.getDrawable(R.drawable.list_divider_drawable));
    L6:
        if (this.mIsGroupMenuAdapter == false) goto L8;
        this.mListView.setSelector(R.drawable.menu_list_group_selector);
    L10:
        if (this.mShowPadding == false) goto L12;
        int r0 = this.mListView.getPaddingLeft();
        int r3 = this.mListView.getPaddingRight();
        int r4 = this.mListVerticalPadding;
        this.mListView.setPadding(r0, r4, r3, r4);
        this.mListView.setClipToPadding(false);
    L12:
        this.mListView.setFocusableInTouchMode(true);
        if (this.mShowBottomActionBar == false) goto L16;
        this.mListView.setOverscrollFooter(new ColorDrawable(0));
    L16:
        if (this.mShowMenuListTitle == false) goto L19;
        this.mListView.setOverscrollHeader(new ColorDrawable(0));
        return;
    L19:
        return;
    L8:
        this.mListView.setSelector(R.drawable.menu_list_selector);
        goto L10
    }

    @Override // obric.widget.support.PopupMenu
    public void show(int arrowDirection, int xoffset, int yoffset, int arrowXoffset, int arrowYoffset) {
        if (this.mIsGroupMenuAdapter == false) goto L5;
        setOnItemClickListener((AdapterView.OnItemClickListener) this.mAdapter);
        setShowPadding(true);
        setShowingDividers(false);
        setClipToScreenEnabled(false);
        setAutoAdjustPopupDirection(true);
        setArrowInvisible();
        yoffset = yoffset - this.mBgTopBottomShadowHeight;
        xoffset = xoffset - this.mBgLeftRightShadowWidth;
    L5:
        super.show(arrowDirection, xoffset, yoffset, arrowXoffset, arrowYoffset);
    }

    public void setTextOrIconViewVisibility(boolean left, boolean useText) {
        Button r0 = this.mRightBtn;
        ImageView r1 = this.mRightImageView;
        if (left == false) goto L5;
        r0 = this.mLeftBtn;
        r1 = this.mLeftImageView;
        int r5 = 1;
    L6:
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) this.mActionText.getLayoutParams();
        if (useText == false) goto L9;
        r0.setVisibility(0);
        r1.setVisibility(8);
        r4.addRule(r5, r0.getId());
        return;
    L9:
        r1.setVisibility(0);
        r0.setVisibility(8);
        r4.addRule(r5, r1.getId());
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public boolean isShowingDividers() {
        return this.mShowDivider;
    }

    public void setShowingDividers(boolean showDivider) {
        this.mShowDivider = showDivider;
    }

    public boolean isShowPadding() {
        return this.mShowPadding;
    }

    public void setShowPadding(boolean showPadding) {
        this.mShowPadding = showPadding;
    }

    public ImageView getLeftActionView() {
        return this.mLeftImageView;
    }

    public ImageView getRightActionView() {
        return this.mRightImageView;
    }

    public Button getLeftButton() {
        return this.mLeftBtn;
    }

    public Button getRightButton() {
        return this.mRightBtn;
    }

    public ListView getListView() {
        return this.mListView;
    }
}
