package com.android.contacts.PinnedHeaderList;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.list.SamContact;
import com.android.contacts.pick.PickerAdapter;
import com.android.contacts.widget.AutoScrollListView;

/* JADX INFO: loaded from: classes.dex */
public class HeadersListView extends AutoScrollListView implements QuickContactListView.OnQuickContactListViewScrollListener {
    private HeadersAdapterWrapper adapter;
    private boolean areHeadersSticky;
    private boolean clipToPaddingHasBeenSet;
    private final Rect clippingRect;
    private boolean clippingToPadding;
    private Long currentHeaderId;
    private Drawable divider;
    private int dividerHeight;
    private View header;
    private int headerBottomPosition;
    private int headerPosition;
    private boolean mChangePosition;
    private int mPosition;
    private boolean mPositionConsiderHeader;
    private boolean mSetTop;
    private boolean mTouchInHeader;
    private AbsListView.OnScrollListener scrollListener;
    private boolean useHeaderBlur;

    public interface OnHeaderClickListener {
        void onHeaderClick(HeadersListView r1, View r2, int r3, long r4, boolean r6);
    }

    private int getFixedFirstVisibleItem(int r1) {
        return r1;
    }

    @Override // com.android.contacts.list.SlideListView
    protected boolean isHeaderMode() {
        return true;
    }

    static /* synthetic */ void access$000(HeadersListView r0) {
        r0.reset();
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    public HeadersListView(Context r2) {
        this(r2, null);
    }

    public HeadersListView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.listViewStyle);
    }

    public HeadersListView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.areHeadersSticky = true;
        this.useHeaderBlur = false;
        this.clippingRect = new Rect();
        this.currentHeaderId = null;
        this.mChangePosition = false;
        this.mPosition = 0;
        this.mSetTop = false;
        this.mPositionConsiderHeader = false;
        this.mTouchInHeader = false;
        initViewByAttrs(r3, r4);
        setOnQuickContactListViewOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
    }

    private void initViewByAttrs(AttributeSet r4, int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r4, com.android.contacts.R.styleable.HeadersListView, r5, 0);
        this.useHeaderBlur = r6.getBoolean(0, false);     // Catch: Throwable -> L6
        r6.recycle();
        return;
    L6:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    private void reset() {
        this.headerBottomPosition = 0;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public boolean performItemClick(View r1, int r2, long r3) {
        return super.performItemClick(((WrapperView) r1).item, r2, r3);
    }

    @Override // android.view.View
    public void setVerticalFadingEdgeEnabled(boolean r2) {
        if (this.areHeadersSticky == false) goto L5;
        super.setVerticalFadingEdgeEnabled(false);
        return;
    L5:
        super.setVerticalFadingEdgeEnabled(r2);
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener r1) {
        this.scrollListener = r1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r3) {
        if (this.clipToPaddingHasBeenSet == true) goto L5;
        this.clippingToPadding = true;
    L5:
        if (r3 != null) goto L7;
    L11:
        super.setAdapter(this.adapter);
        return;
    L7:
        if ((r3 instanceof HeadersAdapter) == false) goto L10;
        this.adapter = new HeadersAdapterWrapper(getContext(), (HeadersAdapter) r3);
        DataSetObserver r4 = new AnonymousClass1(this);
        this.adapter.registerDataSetObserver(r4);
        reset();
        goto L11
    L10:
        throw new IllegalArgumentException("Adapter must implement StickyListHeadersAdapter");
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public HeadersAdapter getAdapter() {
        HeadersAdapterWrapper r0 = this.adapter;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.delegate;
    }

    @Override // com.android.contacts.list.SlideListView, com.android.contacts.bytedanceosquickcontact.QuickContactListView, com.android.contacts.list.HorizontalScrollListView, com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (r4.getActionMasked() != 0) goto L14;
        if (this.areHeadersSticky == true) goto L7;
    L11:
        boolean r0 = false;
    L12:
        this.mTouchInHeader = r0;
        goto L14
    L7:
        if (getHeaderHeight() <= 0) goto L11;
        if (r4.getY() >= getHeaderHeight()) goto L11;
        r0 = true;
    L14:
        if (this.mTouchInHeader == false) goto L17;
        return true;
    L17:
        return super.onTouchEvent(r4);
    }

    @Override // com.android.contacts.list.SlideListView, com.obric.oui.bouncelayout.OListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r1) {
        super.dispatchDraw(r1);
        drawHeader(r1);
    }

    protected void drawHeader(Canvas r6) {
        if (canDrawHeader() == true) goto L5;
        return;
    L5:
        int r0 = getHeaderHeight();
        int r1 = this.headerBottomPosition - r0;
        this.clippingRect.left = getPaddingLeft();
        this.clippingRect.right = getWidth() - getPaddingRight();
        this.clippingRect.bottom = r0 + r1;
        if (this.clippingToPadding == false) goto L8;
        this.clippingRect.top = getPaddingTop();
    L9:
        r6.save();
        r6.clipRect(this.clippingRect);
        r6.translate(getPaddingLeft(), r1);
        this.header.draw(r6);
        r6.restore();
        return;
    L8:
        this.clippingRect.top = 0;
        goto L9
    }

    protected boolean canDrawHeader() {
        if (this.header != null) goto L5;
    L7:
        return false;
    L5:
        if (this.areHeadersSticky == false) goto L7;
        return true;
    }

    private void measureHeader() {
        int r0 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
        ViewGroup.LayoutParams r2 = this.header.getLayoutParams();
        if (r2 != null) goto L5;
    L7:
        int r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L8:
        this.header.measure(r0, r1);
        this.header.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.header.getMeasuredHeight());
        return;
    L5:
        if (r2.height <= 0) goto L7;
        r1 = View.MeasureSpec.makeMeasureSpec(r2.height, 1073741824);
        goto L8
    }

    private int getHeaderHeight() {
        View r0 = this.header;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getMeasuredHeight();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r1) {
        super.setClipToPadding(r1);
        setMyClippingToPadding(r1);
    }

    protected void setMyClippingToPadding(boolean r1) {
        this.clippingToPadding = r1;
        this.clipToPaddingHasBeenSet = true;
    }

    public void setPosition(int r1, boolean r2) {
        this.mPosition = r1;
        this.mChangePosition = true;
        this.mSetTop = r2;
        layoutChildren();
        layoutChildren();
    }

    public void setPositionConsiderHeader(int r1) {
        if (r1 >= 0) goto L4;
        return;
    L4:
        this.mPosition = r1;
        this.mChangePosition = true;
        this.mPositionConsiderHeader = true;
        layoutChildren();
        layoutChildren();
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListView.OnQuickContactListViewScrollListener
    public void onQuickContactListViewScroll(AbsListView r7, int r8, int r9, int r10) {
        if (this.mChangePosition == false) goto L52;
        ViewGroup r1 = (ViewGroup) r7.getChildAt(0);
        ViewGroup r3 = (ViewGroup) r7.getChildAt(1);
        if (r1 == null) goto L51;
        if (r3 == null) goto L57;
        if (r8 != 0) goto L15;
        if ((r7 instanceof HeadersListView) == false) goto L15;
        if (r1.getBottom() > ((HeadersListView) r7).getHeaderHeight()) goto L15;
        this.mPosition++;
    L15:
        if (this.mSetTop == false) goto L32;
        if (r8 != 0) goto L28;
        if ((this.mPosition - r8) > 2) goto L28;
        if (r1.getChildCount() != 2) goto L28;
        if (r1.getChildAt(1).getBottom() <= 0) goto L28;
        if (r3 == null) goto L28;
        if (r3.getChildCount() != 1) goto L28;
        int r2 = r1.getChildAt(0).getTop();
    L31:
        this.mSetTop = false;
    L34:
        if (this.mPositionConsiderHeader == false) goto L48;
        HeadersAdapter r4 = getAdapter();
        if (r4 == null) goto L46;
        int r5 = this.mPosition;
        if (r5 <= 0) goto L46;
        if (r5 >= r4.getCount()) goto L46;
        Object r6 = r4.getItem(this.mPosition - 1);
        Object r11 = r4.getItem(this.mPosition);
        if ((r11 instanceof SamContact) == false) goto L46;
        if (TextUtils.equals(((SamContact) r6).section, ((SamContact) r11).section) == false) goto L46;
        r2 = ContactsUtils.dipTopx(getContext(), 27.0d);
    L46:
        this.mPositionConsiderHeader = false;
    L48:
        if (this.mPosition >= 0) goto L50;
        this.mPosition = 0;
    L50:
        setSelectionFromTop(this.mPosition, r2);
        this.mChangePosition = false;
    L28:
        if (this.mPosition <= 0) goto L30;
        r2 = r1.getTop();
        goto L31
    L30:
        r2 = 0;
        goto L31
    L32:
        r2 = 0;
        goto L34
    L57:
        return;
    L51:
        return;
    L52:
        AbsListView.OnScrollListener r0 = this.scrollListener;
        if (r0 == null) goto L55;
        r0.onScroll(r7, r8, r9, r10);
    L55:
        scrollChanged(r8);
    }

    private void scrollChanged(int r9) {
        HeadersAdapterWrapper r0 = this.adapter;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getCount() != 0) goto L7;
        return;
    L7:
        if (this.areHeadersSticky == false) goto L81;
        int r10 = getFixedFirstVisibleItemMayWithBlur(r9);
        long r1 = this.adapter.delegate.getHeaderId(r10);
        Long r2 = this.currentHeaderId;
        if (r2 != null) goto L12;
    L13:
        this.headerPosition = r10;
        View r3 = this.header;
        View r4 = this.adapter.delegate.getHeaderView(this.headerPosition, this.header, this);
        this.header = r4;
        updateHeaderView(r3, r4);
        measureHeader();
    L14:
        this.currentHeaderId = Long.valueOf(r1);
        int r5 = getChildCount();
        if (r5 == 0) goto L58;
        WrapperView r6 = null;
        int r7 = 99999;
        int r8 = 0;
    L17:
        if (r8 >= r5) goto L32;
        WrapperView r11 = (WrapperView) super.getChildAt(r8);
        if (this.clippingToPadding == false) goto L21;
        int r12 = r11.getTop() - getPaddingTop();
    L22:
        if (r12 < 0) goto L31;
        if (r6 != null) goto L26;
    L30:
        r6 = r11;
        r7 = r12;
        goto L31
    L26:
        if (r6.hasHeader() == false) goto L30;
        if (r11.hasHeader() == false) goto L31;
        if (r12 < r7) goto L30;
    L31:
        r8 = r8 + 1;
        goto L17
    L21:
        r12 = r11.getTop();
        goto L22
    L32:
        int r13 = getHeaderHeight();
        if (r6 != null) goto L35;
    L54:
        this.headerBottomPosition = r13;
        if (this.clippingToPadding == false) goto L58;
        this.headerBottomPosition = r13 + getPaddingTop();
        goto L58
    L35:
        if (r6.hasHeader() == false) goto L54;
        if (r10 != 0) goto L43;
        if (super.getChildAt(0).getTop() <= 0) goto L43;
        if (this.clippingToPadding == true) goto L43;
        this.headerBottomPosition = 0;
    L43:
        if (this.clippingToPadding == false) goto L49;
        int r14 = Math.min(r6.getTop(), getPaddingTop() + r13);
        this.headerBottomPosition = r14;
        if (r14 >= getPaddingTop()) goto L47;
        int r15 = r13 + getPaddingTop();
    L48:
        this.headerBottomPosition = r15;
        goto L58
    L47:
        r15 = this.headerBottomPosition;
        goto L48
    L49:
        int r16 = Math.min(r6.getTop(), r13);
        this.headerBottomPosition = r16;
        if (r16 < 0) goto L53;
        r13 = r16;
    L53:
        this.headerBottomPosition = r13;
    L58:
        if (this.clippingToPadding == false) goto L60;
        int r17 = getPaddingTop();
    L61:
        int r18 = 0;
    L62:
        if (r18 >= r5) goto L82;
        WrapperView r19 = (WrapperView) super.getChildAt(r18);
        if (r19.hasHeader() == false) goto L69;
        View r20 = r19.header;
        if (r19.getTop() >= r17) goto L68;
        r20.setVisibility(4);
        goto L69
    L68:
        r20.setVisibility(0);
    L69:
        r18 = r18 + 1;
        goto L62
    L82:
        return;
    L60:
        r17 = 0;
        goto L61
    L12:
        if (r2.longValue() == r1) goto L14;
    }

    private void updateHeaderView(View r4, View r5) {
        if (this.useHeaderBlur == true) goto L5;
        if (r4 != null) goto L15;
    L17:
        if (r5 != null) goto L19;
        return;
    L19:
        if (r5.findViewById(com.android.contacts.R.id.header_diver) == null) goto L25;
        r5.findViewById(com.android.contacts.R.id.header_diver).setVisibility(0);
        return;
    L25:
        return;
    L15:
        if (r4.findViewById(com.android.contacts.R.id.header_diver) == null) goto L17;
        r4.findViewById(com.android.contacts.R.id.header_diver).setVisibility(8);
        goto L17
    L5:
        if (r4 != null) goto L7;
    L11:
        if (r5 == null) goto L22;
        r5.findViewById(com.android.contacts.R.id.text);
        return;
    L22:
        return;
    L7:
        if (r4.findViewById(com.android.contacts.R.id.header_diver) == null) goto L11;
        if (r4.findViewById(com.android.contacts.R.id.text) == null) goto L11;
        r4.findViewById(com.android.contacts.R.id.header_diver).setVisibility(8);
        goto L11
    }

    private int getFixedFirstVisibleItemMayWithBlur(int r5) {
        if (this.useHeaderBlur == false) goto L13;
        int r0 = getLastVisiblePosition();
        int r1 = r5;
    L5:
        if (r1 > r0) goto L11;
        if ((getChildAt(r1 - r5).getBottom() - getPaddingTop()) >= 0) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return r1;
    L11:
        return getFixedFirstVisibleItem(r5);
    L13:
        return getFixedFirstVisibleItem(r5);
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListView.OnQuickContactListViewScrollListener
    public void onQuickContactListViewScrollStateChanged(AbsListView r1, int r2) {
        AbsListView.OnScrollListener r0 = this.scrollListener;
        if (r0 == null) goto L6;
        r0.onScrollStateChanged(r1, r2);
        return;
    }

    public void refreshHintViewSize() {
        View r0 = this.header;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.findViewById(com.android.contacts.R.id.text) == null) goto L11;
        TextView r1 = (TextView) this.header.findViewById(com.android.contacts.R.id.text);
        if (r1.length() <= 1) goto L12;
        int r2 = ((PickerAdapter) getAdapter()).mCopiedSelectedContacts.size();
        r1.setText(getContext().getResources().getQuantityString(com.android.contacts.R.plurals.selected_contact, r2, new Object[]{Integer.valueOf(r2)}));
        return;
    L12:
        return;
    }
}
