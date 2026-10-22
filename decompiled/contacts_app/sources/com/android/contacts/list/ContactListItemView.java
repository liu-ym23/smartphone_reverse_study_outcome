package com.android.contacts.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import com.android.contacts.ContactPresenceIconUtil;
import com.android.contacts.ContactStatusUtil;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.format.PrefixHighlighter;
import com.android.contacts.widget.AvatarImageView;
import com.obric.contacts.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class ContactListItemView extends ViewGroup implements AbsListView.SelectionBoundsAdjuster {
    public static final PhotoPosition DEFAULT_PHOTO_POSITION = null;
    private static final int QUICK_CONTACT_BADGE_STYLE = 0;
    private Drawable mActivatedBackgroundDrawable;
    private boolean mActivatedStateSupported;
    private Rect mBoundsWithoutHeader;
    private DontPressWithParentImageView mCallButton;
    private View.OnClickListener mCallButtonClickListener;
    private final int mCallButtonPadding;
    private final int mContactsCountTextColor;
    protected final Context mContext;
    private TextView mCountView;
    private final int mCountViewTextSize;
    private final CharArrayBuffer mDataBuffer;
    private TextView mDataView;
    private int mDataViewHeight;
    private final int mDataViewWidthWeight;
    private int mDefaultPhotoViewSize;
    private final int mGapBetweenImageAndText;
    private final int mGapBetweenLabelAndData;
    private int mHeaderBackgroundHeight;
    private View mHeaderDivider;
    private final int mHeaderTextColor;
    private final int mHeaderTextIndent;
    private final int mHeaderTextSize;
    private TextView mHeaderTextView;
    private final int mHeaderUnderlineColor;
    private final int mHeaderUnderlineHeight;
    private boolean mHeaderVisible;
    private char[] mHighlightedPrefix;
    private Drawable mHorizontalDividerDrawable;
    private int mHorizontalDividerHeight;
    private boolean mHorizontalDividerVisible;
    private boolean mKeepHorizontalPaddingForPhotoView;
    private boolean mKeepVerticalPaddingForPhotoView;
    private int mLabelAndDataViewMaxHeight;
    private TextView mLabelView;
    private int mLabelViewHeight;
    private final int mLabelViewWidthWeight;
    private TextView mNameTextView;
    private int mNameTextViewHeight;
    private final CharArrayBuffer mPhoneticNameBuffer;
    private TextView mPhoneticNameTextView;
    private int mPhoneticNameTextViewHeight;
    private PhotoPosition mPhotoPosition;
    private AvatarImageView mPhotoView;
    private int mPhotoViewHeight;
    private int mPhotoViewWidth;
    private boolean mPhotoViewWidthAndHeightAreReady;
    private final int mPreferredHeight;
    private PrefixHighlighter mPrefixHighligher;
    private ImageView mPresenceIcon;
    private final int mPresenceIconMargin;
    private final int mPresenceIconSize;
    private QuickContactBadge mQuickContact;
    private boolean mQuickContactEnabled;
    private ColorStateList mSecondaryTextColor;
    private int mSelectionBoundsMarginLeft;
    private int mSelectionBoundsMarginRight;
    private int mSnippetTextViewHeight;
    private TextView mSnippetView;
    private int mStatusTextViewHeight;
    private TextView mStatusView;
    private final int mTextIndent;
    private CharSequence mUnknownNameText;
    private Drawable mVerticalDividerDrawable;
    private final int mVerticalDividerMargin;
    private boolean mVerticalDividerVisible;
    private int mVerticalDividerWidth;
    private int mViewMode;

    private static class DontPressWithParentImageView extends ImageView {
        public DontPressWithParentImageView(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        @Override // android.view.View
        public void setPressed(boolean r2) {
            if (r2 == true) goto L4;
        L6:
            super.setPressed(r2);
            return;
        L4:
            if (((View) getParent()).isPressed() == false) goto L6;
        }
    }

    public static final enum PhotoPosition extends Enum<PhotoPosition> {
        private static final /* synthetic */ PhotoPosition[] $VALUES = null;
        public static final PhotoPosition LEFT = null;
        public static final PhotoPosition RIGHT = null;

        private static /* synthetic */ PhotoPosition[] $values() {
            return new PhotoPosition[]{LEFT, RIGHT};
        }

        private PhotoPosition(String r1, int r2) {
            super(r1, r2);
        }

        public static PhotoPosition valueOf(String r1) {
            return (PhotoPosition) Enum.valueOf(PhotoPosition.class, r1);
        }

        public static PhotoPosition[] values() {
            return (PhotoPosition[]) $VALUES.clone();
        }

        static {
            LEFT = new PhotoPosition("LEFT", 0);
            RIGHT = new PhotoPosition("RIGHT", 1);
            $VALUES = $values();
        }
    }

    static {
        DEFAULT_PHOTO_POSITION = PhotoPosition.RIGHT;
    }

    public ContactListItemView(Context r8, AttributeSet r9) {
        super(r8, r9);
        this.mHorizontalDividerVisible = true;
        this.mPhotoPosition = DEFAULT_PHOTO_POSITION;
        this.mQuickContactEnabled = true;
        this.mPhotoViewWidthAndHeightAreReady = false;
        this.mDataBuffer = new CharArrayBuffer(128);
        this.mPhoneticNameBuffer = new CharArrayBuffer(128);
        this.mBoundsWithoutHeader = new Rect();
        this.mContext = r8;
        TypedArray r10 = getContext().obtainStyledAttributes(r9, R.styleable.ContactListItemView);
        this.mPreferredHeight = r10.getDimensionPixelSize(14, 0);
        this.mActivatedBackgroundDrawable = r10.getDrawable(0);
        this.mHorizontalDividerDrawable = r10.getDrawable(5);
        this.mVerticalDividerMargin = ContactsUtils.dipTopx(getContext(), 14.0d);
        this.mGapBetweenImageAndText = r10.getDimensionPixelOffset(6, 0);
        this.mGapBetweenLabelAndData = r10.getDimensionPixelOffset(7, 0);
        this.mCallButtonPadding = ContactsUtils.dipTopx(getContext(), 14.0d);
        this.mPresenceIconMargin = r10.getDimensionPixelOffset(24, 4);
        this.mPresenceIconSize = r10.getDimensionPixelOffset(25, 16);
        this.mDefaultPhotoViewSize = r10.getDimensionPixelOffset(22, 0);
        this.mHeaderTextIndent = r10.getDimensionPixelOffset(10, 0);
        this.mHeaderTextColor = r10.getColor(9, -16777216);
        this.mHeaderTextSize = r10.getDimensionPixelSize(11, 12);
        this.mHeaderBackgroundHeight = r10.getDimensionPixelSize(8, 30);
        this.mHeaderUnderlineHeight = r10.getDimensionPixelSize(13, 1);
        this.mHeaderUnderlineColor = r10.getColor(12, 0);
        this.mTextIndent = r10.getDimensionPixelOffset(27, 0);
        this.mCountViewTextSize = r10.getDimensionPixelSize(3, 12);
        this.mContactsCountTextColor = r10.getColor(2, -16777216);
        this.mDataViewWidthWeight = r10.getInteger(4, 5);
        this.mLabelViewWidthWeight = r10.getInteger(15, 3);
        setPadding(r10.getDimensionPixelOffset(19, 0), r10.getDimensionPixelOffset(21, 0), r10.getDimensionPixelOffset(20, 0), r10.getDimensionPixelOffset(18, 0));
        this.mPrefixHighligher = new PrefixHighlighter(r10.getColor(23, -16711936));
        r10.recycle();
        TypedArray r11 = getContext().obtainStyledAttributes(android.R.styleable.Theme);
        this.mSecondaryTextColor = r11.getColorStateList(8);
        r11.recycle();
        this.mHorizontalDividerHeight = this.mHorizontalDividerDrawable.getIntrinsicHeight();
        Drawable r12 = this.mActivatedBackgroundDrawable;
        if (r12 == null) goto L6;
        r12.setCallback(this);
        return;
    }

    public void setOnCallButtonClickListener(View.OnClickListener r1) {
        this.mCallButtonClickListener = r1;
    }

    public void setUnknownNameText(CharSequence r1) {
        this.mUnknownNameText = r1;
    }

    public void setQuickContactEnabled(boolean r1) {
        this.mQuickContactEnabled = r1;
    }

    @Override // android.view.View
    protected void onMeasure(int r9, int r10) {
        int r11 = resolveSize(0, r9);
        if (this.mHorizontalDividerVisible == false) goto L5;
        int r0 = this.mPreferredHeight + this.mHorizontalDividerHeight;
    L6:
        this.mNameTextViewHeight = 0;
        this.mPhoneticNameTextViewHeight = 0;
        this.mLabelViewHeight = 0;
        this.mDataViewHeight = 0;
        this.mLabelAndDataViewMaxHeight = 0;
        this.mSnippetTextViewHeight = 0;
        this.mStatusTextViewHeight = 0;
        ensurePhotoViewSize();
        if (this.mPhotoViewWidth <= 0) goto L9;
    L12:
        int r1 = (r11 - getPaddingLeft()) - getPaddingRight();
        int r2 = this.mPhotoViewWidth + this.mGapBetweenImageAndText;
    L13:
        int r3 = r1 - r2;
        if (isVisible(this.mNameTextView) == false) goto L17;
        this.mNameTextView.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mNameTextViewHeight = this.mNameTextView.getMeasuredHeight();
    L17:
        if (isVisible(this.mPhoneticNameTextView) == false) goto L20;
        this.mPhoneticNameTextView.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mPhoneticNameTextViewHeight = this.mPhoneticNameTextView.getMeasuredHeight();
    L20:
        if (isVisible(this.mDataView) == false) goto L26;
        if (isVisible(this.mLabelView) == false) goto L24;
        int r4 = r3 - this.mGapBetweenLabelAndData;
        int r5 = this.mDataViewWidthWeight;
        int r6 = this.mLabelViewWidthWeight;
        int r7 = (r4 * r5) / (r5 + r6);
        int r8 = (r4 * r6) / (r5 + r6);
    L30:
        if (isVisible(this.mDataView) == false) goto L33;
        this.mDataView.measure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mDataViewHeight = this.mDataView.getMeasuredHeight();
    L33:
        if (isVisible(this.mLabelView) == true) goto L35;
    L39:
        this.mLabelAndDataViewMaxHeight = Math.max(this.mLabelViewHeight, this.mDataViewHeight);
        if (isVisible(this.mSnippetView) == false) goto L43;
        this.mSnippetView.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mSnippetTextViewHeight = this.mSnippetView.getMeasuredHeight();
    L43:
        if (isVisible(this.mPresenceIcon) == false) goto L46;
        ImageView r12 = this.mPresenceIcon;
        int r13 = this.mPresenceIconSize;
        r12.measure(r13, r13);
        this.mStatusTextViewHeight = this.mPresenceIcon.getMeasuredHeight();
    L46:
        if (isVisible(this.mStatusView) == true) goto L48;
    L51:
        int r14 = (((this.mNameTextViewHeight + this.mPhoneticNameTextViewHeight) + this.mLabelAndDataViewMaxHeight) + this.mSnippetTextViewHeight) + this.mStatusTextViewHeight;
        if (isVisible(this.mCallButton) == false) goto L54;
        this.mCallButton.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L54:
        int r15 = Math.max(r14, (this.mPhotoViewHeight + getPaddingBottom()) + getPaddingTop());
        if (this.mHorizontalDividerVisible == false) goto L58;
        r15 = r15 + this.mHorizontalDividerHeight;
    L58:
        if (this.mViewMode != 1) goto L61;
        r15 = Math.max(r15, r0);
    L61:
        if (this.mHeaderVisible == false) goto L66;
        this.mHeaderTextView.measure(View.MeasureSpec.makeMeasureSpec(r11, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeaderBackgroundHeight, 1073741824));
        TextView r16 = this.mCountView;
        if (r16 == null) goto L65;
        r16.measure(View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.mHeaderBackgroundHeight, 1073741824));
    L65:
        int r17 = Math.max(this.mHeaderBackgroundHeight, this.mHeaderTextView.getMeasuredHeight());
        this.mHeaderBackgroundHeight = r17;
        r15 = r15 + (r17 + this.mHeaderUnderlineHeight);
    L66:
        setMeasuredDimension(r11, r15);
        return;
    L48:
        if (isVisible(this.mPresenceIcon) == false) goto L50;
        r3 = (r3 - this.mPresenceIcon.getMeasuredWidth()) - this.mPresenceIconMargin;
    L50:
        this.mStatusView.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mStatusTextViewHeight = Math.max(this.mStatusTextViewHeight, this.mStatusView.getMeasuredHeight());
        goto L51
    L35:
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L37;
        int r18 = 1073741824;
    L38:
        this.mLabelView.measure(View.MeasureSpec.makeMeasureSpec(r8, r18), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mLabelViewHeight = this.mLabelView.getMeasuredHeight();
        goto L39
    L37:
        r18 = Integer.MIN_VALUE;
        goto L38
    L24:
        r8 = 0;
        r7 = r3;
        goto L30
    L26:
        if (isVisible(this.mLabelView) == false) goto L28;
        r7 = 0;
        r8 = r3;
        goto L30
    L28:
        r8 = 0;
        r7 = 0;
        goto L30
    L9:
        if (this.mKeepHorizontalPaddingForPhotoView == true) goto L12;
        r1 = r11 - getPaddingLeft();
        r2 = getPaddingRight();
        goto L13
    L5:
        r0 = this.mPreferredHeight;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = r9 - r7;
        int r11 = r8 - r6;
        int r12 = getPaddingLeft();
        int r13 = r11 - getPaddingRight();
        if (this.mHeaderVisible == false) goto L8;
        this.mHeaderTextView.layout(this.mHeaderTextIndent + r12, 0, r13, this.mHeaderBackgroundHeight);
        TextView r14 = this.mCountView;
        if (r14 == null) goto L7;
        r14.layout(r13 - r14.getMeasuredWidth(), 0, r13, this.mHeaderBackgroundHeight);
    L7:
        View r15 = this.mHeaderDivider;
        int r1 = this.mHeaderBackgroundHeight;
        r15.layout(r12, r1, r13, this.mHeaderUnderlineHeight + r1);
        int r16 = (this.mHeaderBackgroundHeight + this.mHeaderUnderlineHeight) + 0;
    L10:
        if (this.mHorizontalDividerVisible == false) goto L12;
        this.mHorizontalDividerDrawable.setBounds(r12, r10 - this.mHorizontalDividerHeight, r13, r10);
        int r2 = r10 - this.mHorizontalDividerHeight;
    L13:
        this.mBoundsWithoutHeader.set(0, r16, r11, r2);
        if (this.mActivatedStateSupported == true) goto L16;
    L18:
        View r17 = this.mQuickContact;
        if (r17 != null) goto L23;
        r17 = this.mPhotoView;
    L23:
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L30;
        if (r17 == null) goto L28;
        int r3 = this.mPhotoViewHeight;
        int r0 = (((r2 - r16) - r3) / 2) + r16;
        r17.layout(r12, r0, this.mPhotoViewWidth + r12, r3 + r0);
        int r18 = this.mPhotoViewWidth;
        int r4 = this.mGapBetweenImageAndText;
    L26:
        int r19 = r18 + r4;
    L33:
        r12 = r12 + r19;
    L34:
        int r20 = layoutRightSide(r10, r16, r2, r13);
        int r21 = ((r2 + r16) - ((((this.mNameTextViewHeight + this.mPhoneticNameTextViewHeight) + this.mLabelAndDataViewMaxHeight) + this.mSnippetTextViewHeight) + this.mStatusTextViewHeight)) / 2;
        if (isVisible(this.mNameTextView) == false) goto L38;
        this.mNameTextView.layout(r12, r21, r20, this.mNameTextViewHeight + r21);
        r21 = r21 + this.mNameTextViewHeight;
    L38:
        if (isVisible(this.mPresenceIcon) == false) goto L40;
        int r22 = this.mPresenceIcon.getMeasuredWidth();
        this.mPresenceIcon.layout(r12, r21, r12 + r22, this.mStatusTextViewHeight + r21);
        int r23 = (r22 + this.mPresenceIconMargin) + r12;
    L42:
        if (isVisible(this.mStatusView) == false) goto L45;
        this.mStatusView.layout(r23, r21, r20, this.mStatusTextViewHeight + r21);
    L45:
        if (isVisible(this.mStatusView) == false) goto L47;
    L48:
        r21 = r21 + this.mStatusTextViewHeight;
    L50:
        if (isVisible(this.mPhoneticNameTextView) == false) goto L53;
        this.mPhoneticNameTextView.layout(r12, r21, r20, this.mPhoneticNameTextViewHeight + r21);
        r21 = r21 + this.mPhoneticNameTextViewHeight;
    L53:
        if (isVisible(this.mLabelView) == true) goto L55;
    L58:
        int r24 = r12;
    L60:
        if (isVisible(this.mDataView) == false) goto L63;
        TextView r25 = this.mDataView;
        int r26 = this.mLabelAndDataViewMaxHeight;
        r25.layout(r24, (r21 + r26) - this.mDataViewHeight, r20, r26 + r21);
    L63:
        if (isVisible(this.mLabelView) == false) goto L65;
    L66:
        r21 = r21 + this.mLabelAndDataViewMaxHeight;
    L68:
        if (isVisible(this.mSnippetView) == false) goto L71;
        this.mSnippetView.layout(r12, r21, r20, this.mSnippetTextViewHeight + r21);
        return;
    L71:
        return;
    L65:
        if (isVisible(this.mDataView) == false) goto L68;
    L55:
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L57;
        TextView r27 = this.mLabelView;
        int r28 = r20 - r27.getMeasuredWidth();
        int r29 = this.mLabelAndDataViewMaxHeight;
        r27.layout(r28, (r21 + r29) - this.mLabelViewHeight, r20, r29 + r21);
        r20 = r20 - this.mLabelView.getMeasuredWidth();
        goto L58
    L57:
        int r30 = this.mLabelView.getMeasuredWidth() + r12;
        TextView r31 = this.mLabelView;
        int r32 = this.mLabelAndDataViewMaxHeight;
        r31.layout(r12, (r21 + r32) - this.mLabelViewHeight, r30, r32 + r21);
        r24 = r30 + this.mGapBetweenLabelAndData;
        goto L60
    L47:
        if (isVisible(this.mPresenceIcon) == false) goto L50;
    L40:
        r23 = r12;
        goto L42
    L28:
        if (this.mKeepHorizontalPaddingForPhotoView == false) goto L34;
        r18 = this.mPhotoViewWidth;
        r4 = this.mGapBetweenImageAndText;
        goto L26
    L30:
        if (r17 == null) goto L32;
        int r33 = this.mPhotoViewHeight;
        int r34 = (((r2 - r16) - r33) / 2) + r16;
        r17.layout(r13 - this.mPhotoViewWidth, r34, r13, r33 + r34);
        r13 = r13 - (this.mPhotoViewWidth + this.mGapBetweenImageAndText);
    L32:
        r19 = this.mTextIndent;
        goto L33
    L16:
        if (isActivated() == false) goto L18;
        this.mActivatedBackgroundDrawable.setBounds(this.mBoundsWithoutHeader);
        goto L18
    L12:
        r2 = r10;
        goto L13
    L8:
        r16 = 0;
        goto L10
    }

    protected int layoutRightSide(int r3, int r4, int r5, int r6) {
        if (isVisible(this.mCallButton) == false) goto L5;
        int r7 = this.mCallButton.getMeasuredWidth();
        int r8 = r6 - r7;
        this.mCallButton.layout(r8, r4, r7 + r8, r3 - this.mHorizontalDividerHeight);
        this.mVerticalDividerVisible = true;
        ensureVerticalDivider();
        int r9 = this.mVerticalDividerWidth;
        int r10 = r8 - r9;
        Drawable r0 = this.mVerticalDividerDrawable;
        int r2 = this.mVerticalDividerMargin;
        r0.setBounds(r10, r4 + r2, r9 + r10, r3 - r2);
        return r10;
    L5:
        this.mVerticalDividerVisible = false;
        return r6;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect r3) {
        r3.top += this.mBoundsWithoutHeader.top;
        r3.bottom = r3.top + this.mBoundsWithoutHeader.height();
        r3.left += this.mSelectionBoundsMarginLeft;
        r3.right -= this.mSelectionBoundsMarginRight;
    }

    protected boolean isVisible(View r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getVisibility() != 0) goto L6;
        return true;
    }

    private void ensureVerticalDivider() {
        if (this.mVerticalDividerDrawable != null) goto L6;
        Drawable r0 = this.mContext.getResources().getDrawable(R.drawable.divider_vertical_dark);
        this.mVerticalDividerDrawable = r0;
        this.mVerticalDividerWidth = r0.getIntrinsicWidth();
        return;
    }

    private void ensurePhotoViewSize() {
        if (this.mPhotoViewWidthAndHeightAreReady == true) goto L23;
        int r2 = 0;
        if (this.mQuickContactEnabled == false) goto L8;
        TypedArray r0 = this.mContext.obtainStyledAttributes(null, Constants.ViewGroup_Layout, 0, 0);
        this.mPhotoViewWidth = r0.getLayoutDimension(0, -2);
        this.mPhotoViewHeight = r0.getLayoutDimension(1, -2);
        r0.recycle();
    L19:
        if (this.mViewMode != 2) goto L21;
        this.mPhotoViewWidth /= 2;
        this.mPhotoViewHeight /= 2;
    L21:
        this.mPhotoViewWidthAndHeightAreReady = true;
        return;
    L8:
        if (this.mPhotoView == null) goto L10;
        int r1 = getDefaultPhotoViewSize();
        this.mPhotoViewHeight = r1;
        this.mPhotoViewWidth = r1;
        goto L19
    L10:
        int r3 = getDefaultPhotoViewSize();
        if (this.mKeepHorizontalPaddingForPhotoView == false) goto L13;
        int r4 = r3;
    L14:
        this.mPhotoViewWidth = r4;
        if (this.mKeepVerticalPaddingForPhotoView == false) goto L17;
        r2 = r3;
    L17:
        this.mPhotoViewHeight = r2;
        goto L19
    L13:
        r4 = 0;
        goto L14
    }

    protected void setDefaultPhotoViewSize(int r1) {
        this.mDefaultPhotoViewSize = r1;
    }

    protected int getDefaultPhotoViewSize() {
        return this.mDefaultPhotoViewSize;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mActivatedStateSupported == false) goto L6;
        this.mActivatedBackgroundDrawable.setState(getDrawableState());
        return;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r2) {
        if (r2 != this.mActivatedBackgroundDrawable) goto L5;
    L8:
        return true;
    L5:
        if (super.verifyDrawable(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mActivatedStateSupported == false) goto L6;
        this.mActivatedBackgroundDrawable.jumpToCurrentState();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r2) {
        if (this.mActivatedStateSupported == false) goto L8;
        if (isActivated() == false) goto L8;
        this.mActivatedBackgroundDrawable.draw(r2);
    L8:
        if (this.mHorizontalDividerVisible == false) goto L11;
        this.mHorizontalDividerDrawable.draw(r2);
    L11:
        if (this.mVerticalDividerVisible == false) goto L13;
        this.mVerticalDividerDrawable.draw(r2);
    L13:
        super.dispatchDraw(r2);
    }

    public void setDividerVisible(boolean r1) {
        this.mHorizontalDividerVisible = r1;
    }

    public void setSectionHeader(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        TextView r6 = this.mHeaderTextView;
        if (r6 == null) goto L14;
        r6.setVisibility(8);
    L14:
        View r7 = this.mHeaderDivider;
        if (r7 == null) goto L17;
        r7.setVisibility(8);
    L17:
        this.mHeaderVisible = false;
        return;
    L5:
        if (this.mHeaderTextView != null) goto L8;
        TextView r0 = new TextView(this.mContext);
        this.mHeaderTextView = r0;
        r0.setTextColor(this.mHeaderTextColor);
        this.mHeaderTextView.setTextSize(0, this.mHeaderTextSize);
        TextView r1 = this.mHeaderTextView;
        r1.setTypeface(r1.getTypeface(), 1);
        this.mHeaderTextView.setGravity(16);
        addView(this.mHeaderTextView);
    L8:
        if (this.mHeaderDivider != null) goto L10;
        View r2 = new View(this.mContext);
        this.mHeaderDivider = r2;
        r2.setBackgroundColor(this.mHeaderUnderlineColor);
        addView(this.mHeaderDivider);
    L10:
        setMarqueeText(this.mHeaderTextView, r5);
        this.mHeaderTextView.setVisibility(0);
        this.mHeaderDivider.setVisibility(0);
        this.mHeaderTextView.setAllCaps(true);
        this.mHeaderVisible = true;
    }

    public QuickContactBadge getQuickContact() {
        if (this.mQuickContactEnabled == false) goto L13;
        if (this.mQuickContact != null) goto L11;
        QuickContactBadge r0 = new QuickContactBadge(this.mContext, null, 0);
        this.mQuickContact = r0;
        TextView r1 = this.mNameTextView;
        if (r1 == null) goto L9;
        r0.setContentDescription(this.mContext.getString(R.string.description_quick_contact_for, new Object[]{r1.getText()}));
    L9:
        addView(this.mQuickContact);
        this.mPhotoViewWidthAndHeightAreReady = false;
    L11:
        return this.mQuickContact;
    L13:
        throw new IllegalStateException("QuickContact is disabled for this view");
    }

    public AvatarImageView getPhotoView() {
        if (this.mPhotoView != null) goto L10;
        if (this.mQuickContactEnabled == false) goto L7;
        this.mPhotoView = new AvatarImageView(this.mContext, null, 0);
    L8:
        this.mPhotoView.setBackgroundDrawable(null);
        addView(this.mPhotoView);
        this.mPhotoViewWidthAndHeightAreReady = false;
        goto L10
    L7:
        this.mPhotoView = new AvatarImageView(this.mContext);
    L10:
        return this.mPhotoView;
    }

    public void removePhotoView() {
        removePhotoView(false, true);
    }

    public void removePhotoView(boolean r2, boolean r3) {
        this.mPhotoViewWidthAndHeightAreReady = false;
        this.mKeepHorizontalPaddingForPhotoView = r2;
        this.mKeepVerticalPaddingForPhotoView = r3;
        AvatarImageView r4 = this.mPhotoView;
        if (r4 == null) goto L5;
        removeView(r4);
        this.mPhotoView = null;
    L5:
        QuickContactBadge r5 = this.mQuickContact;
        if (r5 == null) goto L9;
        removeView(r5);
        this.mQuickContact = null;
        return;
    }

    public void setHighlightedPrefix(char[] r1) {
        this.mHighlightedPrefix = r1;
    }

    public TextView getNameTextView() {
        if (this.mNameTextView != null) goto L6;
        TextView r0 = new TextView(this.mContext);
        this.mNameTextView = r0;
        r0.setSingleLine(true);
        this.mNameTextView.setEllipsize(getTextEllipsis());
        this.mNameTextView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Medium);
        this.mNameTextView.setActivated(isActivated());
        this.mNameTextView.setGravity(16);
        addView(this.mNameTextView);
    L6:
        return this.mNameTextView;
    }

    public void showCallButton(int r5, int r6) {
        if (this.mCallButton != null) goto L5;
        DontPressWithParentImageView r0 = new DontPressWithParentImageView(this.mContext, null);
        this.mCallButton = r0;
        r0.setId(r5);
        this.mCallButton.setOnClickListener(this.mCallButtonClickListener);
        this.mCallButton.setBackgroundResource(R.drawable.call_background);
        this.mCallButton.setImageResource(android.R.drawable.sym_action_call);
        DontPressWithParentImageView r7 = this.mCallButton;
        int r1 = this.mCallButtonPadding;
        r7.setPadding(r1, 0, r1, 0);
        this.mCallButton.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.mCallButton);
    L5:
        this.mCallButton.setTag(Integer.valueOf(r6));
        this.mCallButton.setVisibility(0);
    }

    public void hideCallButton() {
        DontPressWithParentImageView r1 = this.mCallButton;
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }

    public void setPhoneticName(char[] r2, int r3) {
        if (r2 == null) goto L6;
        if (r3 == 0) goto L6;
        getPhoneticNameTextView();
        setMarqueeText(this.mPhoneticNameTextView, r2, r3);
        this.mPhoneticNameTextView.setVisibility(0);
        return;
    L6:
        TextView r1 = this.mPhoneticNameTextView;
        if (r1 == null) goto L11;
        r1.setVisibility(8);
        return;
    }

    public TextView getPhoneticNameTextView() {
        if (this.mPhoneticNameTextView != null) goto L6;
        TextView r0 = new TextView(this.mContext);
        this.mPhoneticNameTextView = r0;
        r0.setSingleLine(true);
        this.mPhoneticNameTextView.setEllipsize(getTextEllipsis());
        this.mPhoneticNameTextView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Small);
        TextView r1 = this.mPhoneticNameTextView;
        r1.setTypeface(r1.getTypeface(), 1);
        this.mPhoneticNameTextView.setActivated(isActivated());
        addView(this.mPhoneticNameTextView);
    L6:
        return this.mPhoneticNameTextView;
    }

    public void setLabel(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        TextView r1 = this.mLabelView;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    L9:
        return;
    L7:
        getLabelView();
        setMarqueeText(this.mLabelView, r2);
        this.mLabelView.setVisibility(0);
    }

    public TextView getLabelView() {
        if (this.mLabelView != null) goto L10;
        TextView r0 = new TextView(this.mContext);
        this.mLabelView = r0;
        r0.setSingleLine(true);
        this.mLabelView.setEllipsize(getTextEllipsis());
        this.mLabelView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Small);
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L7;
        this.mLabelView.setTextSize(2, this.mCountViewTextSize);
        this.mLabelView.setAllCaps(true);
        this.mLabelView.setGravity(5);
    L8:
        this.mLabelView.setActivated(isActivated());
        addView(this.mLabelView);
        goto L10
    L7:
        TextView r1 = this.mLabelView;
        r1.setTypeface(r1.getTypeface(), 1);
    L10:
        return this.mLabelView;
    }

    public void setData(char[] r2, int r3) {
        if (r2 == null) goto L6;
        if (r3 == 0) goto L6;
        getDataView();
        setMarqueeText(this.mDataView, r2, r3);
        this.mDataView.setVisibility(0);
        return;
    L6:
        TextView r1 = this.mDataView;
        if (r1 == null) goto L11;
        r1.setVisibility(8);
        return;
    }

    private void setMarqueeText(TextView r4, char[] r5, int r6) {
        if (getTextEllipsis() != TextUtils.TruncateAt.MARQUEE) goto L5;
        setMarqueeText(r4, new String(r5, 0, r6));
        return;
    L5:
        r4.setText(r5, 0, r6);
    }

    private void setMarqueeText(TextView r4, CharSequence r5) {
        if (getTextEllipsis() != TextUtils.TruncateAt.MARQUEE) goto L5;
        SpannableString r3 = new SpannableString(r5);
        r3.setSpan(TextUtils.TruncateAt.MARQUEE, 0, r3.length(), 33);
        r4.setText(r3);
        return;
    L5:
        r4.setText(r5);
    }

    public TextView getDataView() {
        if (this.mDataView != null) goto L6;
        TextView r0 = new TextView(this.mContext);
        this.mDataView = r0;
        r0.setSingleLine(true);
        this.mDataView.setEllipsize(getTextEllipsis());
        this.mDataView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Small);
        this.mDataView.setActivated(isActivated());
        addView(this.mDataView);
    L6:
        return this.mDataView;
    }

    public void setSnippet(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        TextView r3 = this.mSnippetView;
        if (r3 == null) goto L9;
        r3.setVisibility(8);
        return;
    L9:
        return;
    L7:
        this.mPrefixHighligher.setText(getSnippetView(), r4, this.mHighlightedPrefix);
        this.mSnippetView.setVisibility(0);
    }

    public TextView getSnippetView() {
        if (this.mSnippetView != null) goto L6;
        TextView r0 = new TextView(this.mContext);
        this.mSnippetView = r0;
        r0.setSingleLine(true);
        this.mSnippetView.setEllipsize(getTextEllipsis());
        this.mSnippetView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Small);
        TextView r1 = this.mSnippetView;
        r1.setTypeface(r1.getTypeface(), 1);
        this.mSnippetView.setActivated(isActivated());
        addView(this.mSnippetView);
    L6:
        return this.mSnippetView;
    }

    public TextView getStatusView() {
        if (this.mStatusView != null) goto L6;
        TextView r0 = new TextView(this.mContext);
        this.mStatusView = r0;
        r0.setSingleLine(true);
        this.mStatusView.setEllipsize(getTextEllipsis());
        this.mStatusView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Small);
        this.mStatusView.setTextColor(this.mSecondaryTextColor);
        this.mStatusView.setActivated(isActivated());
        addView(this.mStatusView);
    L6:
        return this.mStatusView;
    }

    public TextView getCountView() {
        if (this.mCountView != null) goto L6;
        TextView r0 = new TextView(this.mContext);
        this.mCountView = r0;
        r0.setSingleLine(true);
        this.mCountView.setEllipsize(getTextEllipsis());
        this.mCountView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Medium);
        this.mCountView.setTextColor(getResources().getColor(R.color.contact_count_text_color));
        addView(this.mCountView);
    L6:
        return this.mCountView;
    }

    public void setCountView(CharSequence r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        TextView r2 = this.mCountView;
        if (r2 == null) goto L9;
        r2.setVisibility(8);
        return;
    L9:
        return;
    L7:
        getCountView();
        setMarqueeText(this.mCountView, r3);
        this.mCountView.setTextSize(0, this.mCountViewTextSize);
        this.mCountView.setGravity(16);
        this.mCountView.setTextColor(this.mContactsCountTextColor);
        this.mCountView.setVisibility(0);
    }

    public void setStatus(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        TextView r1 = this.mStatusView;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    L9:
        return;
    L7:
        getStatusView();
        setMarqueeText(this.mStatusView, r2);
        this.mStatusView.setVisibility(0);
    }

    public void setPresence(Drawable r3) {
        if (r3 != null) goto L4;
        ImageView r2 = this.mPresenceIcon;
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    L12:
        return;
    L4:
        if (this.mPresenceIcon != null) goto L6;
        ImageView r0 = new ImageView(this.mContext);
        this.mPresenceIcon = r0;
        addView(r0);
    L6:
        this.mPresenceIcon.setImageDrawable(r3);
        this.mPresenceIcon.setScaleType(ImageView.ScaleType.CENTER);
        this.mPresenceIcon.setVisibility(0);
    }

    private TextUtils.TruncateAt getTextEllipsis() {
        return TextUtils.TruncateAt.MARQUEE;
    }

    public void showDisplayName(Cursor r2, int r3, int r4) {
        String r5 = r2.getString(r3);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        CharSequence r6 = this.mPrefixHighligher.apply(r5, this.mHighlightedPrefix);
    L6:
        setMarqueeText(getNameTextView(), r6);
        QuickContactBadge r7 = this.mQuickContact;
        if (r7 == null) goto L10;
        r7.setContentDescription(this.mContext.getString(R.string.description_quick_contact_for, new Object[]{this.mNameTextView.getText()}));
        return;
    L10:
        return;
    L5:
        r6 = this.mUnknownNameText;
        goto L6
    }

    public void hideDisplayName() {
        TextView r0 = this.mNameTextView;
        if (r0 == null) goto L6;
        removeView(r0);
        this.mNameTextView = null;
        return;
    }

    public void showPhoneticName(Cursor r2, int r3) {
        r2.copyStringToBuffer(r3, this.mPhoneticNameBuffer);
        int r4 = this.mPhoneticNameBuffer.sizeCopied;
        if (r4 == 0) goto L5;
        setPhoneticName(this.mPhoneticNameBuffer.data, r4);
        return;
    L5:
        setPhoneticName(null, 0);
    }

    public void hidePhoneticName() {
        TextView r0 = this.mPhoneticNameTextView;
        if (r0 == null) goto L6;
        removeView(r0);
        this.mPhoneticNameTextView = null;
        return;
    }

    public void showPresenceAndStatusMessage(Cursor r3, int r4, int r5) {
        String r1 = null;
        if (r3.isNull(r4) == true) goto L5;
        int r6 = r3.getInt(r4);
        Drawable r0 = ContactPresenceIconUtil.getPresenceIcon(getContext(), r6);
    L6:
        setPresence(r0);
        if (r5 != 0) goto L9;
    L11:
        if (r1 != null) goto L14;
        if (r6 == 0) goto L14;
        r1 = ContactStatusUtil.getStatusString(getContext(), r6);
    L14:
        setStatus(r1);
        return;
    L9:
        if (r3.isNull(r5) == true) goto L11;
        r1 = r3.getString(r5);
        goto L11
    L5:
        r6 = 0;
        r0 = null;
        goto L6
    }

    public void showSnippet(Cursor r6, int r7) {
        String r1 = null;
        if (r6.getColumnCount() > r7) goto L6;
        setSnippet(null);
        return;
    L6:
        String r8 = r6.getString(r7);
        if (r6.getExtras().getBoolean(com.android.contacts.util.Constants.DEFERRED_SNIPPETING_KEY) == false) goto L9;
        r6.getColumnIndex("display_name");
    L9:
        if (r8 == null) goto L29;
        int r9 = r8.length();
        int r2 = r8.indexOf(1);
        if (r2 == (-1)) goto L30;
        int r3 = r8.lastIndexOf(10, r2);
        if (r3 == (-1)) goto L16;
        int r4 = r3 + 1;
    L17:
        int r5 = r8.lastIndexOf(1);
        if (r5 == (-1)) goto L22;
        int r10 = r8.indexOf(10, r5);
        if (r10 == (-1)) goto L22;
        r9 = r10;
    L22:
        StringBuilder r11 = new StringBuilder();
    L23:
        if (r4 >= r9) goto L28;
        char r12 = r8.charAt(r4);
        if (r12 == 1) goto L27;
        r11.append(r12);
    L27:
        r4 = r4 + 1;
        goto L23
    L28:
        r1 = r11.toString();
        goto L30
    L16:
        r4 = 0;
    L30:
        setSnippet(r1);
        return;
    L29:
        r1 = r8;
        goto L30
    }

    public void showData(Cursor r2, int r3) {
        r2.copyStringToBuffer(r3, this.mDataBuffer);
        setData(this.mDataBuffer.data, this.mDataBuffer.sizeCopied);
    }

    public void setActivatedStateSupported(boolean r1) {
        this.mActivatedStateSupported = r1;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        forceLayout();
    }

    public void setPhotoPosition(PhotoPosition r1) {
        this.mPhotoPosition = r1;
    }

    public PhotoPosition getPhotoPosition() {
        return this.mPhotoPosition;
    }

    public void setSelectionBoundsHorizontalMargin(int r1, int r2) {
        this.mSelectionBoundsMarginLeft = r1;
        this.mSelectionBoundsMarginRight = r2;
    }
}
