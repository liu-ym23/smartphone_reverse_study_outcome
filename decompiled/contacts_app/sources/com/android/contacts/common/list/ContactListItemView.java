package com.android.contacts.common.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.android.contacts.common.ContactPresenceIconUtil;
import com.android.contacts.common.ContactStatusUtil;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.CompatUtils;
import com.android.contacts.common.compat.PhoneNumberUtilsCompat;
import com.android.contacts.common.format.TextHighlighter;
import com.android.contacts.common.util.ContactDisplayUtils;
import com.android.contacts.common.util.SearchUtil;
import com.android.contacts.common.util.ViewUtil;
import com.android.contacts.common.widget.CheckableImageView;
import com.android.contacts.common.widget.CheckableQuickContactBadge;
import com.android.contacts.util.Constants;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class ContactListItemView extends ViewGroup implements AbsListView.SelectionBoundsAdjuster {
    private static final Pattern SPLIT_PATTERN = null;
    private static final String TAG = "ContactListItemView";
    private Drawable mActivatedBackgroundDrawable;
    private boolean mActivatedStateSupported;
    private boolean mAdjustSelectionBoundsEnabled;
    private Rect mBoundsWithoutHeader;
    private CheckBox mCheckBox;
    private int mCheckBoxHeight;
    private int mCheckBoxWidth;
    private final CharArrayBuffer mDataBuffer;
    private TextView mDataView;
    private int mDataViewHeight;
    private int mDataViewWidthWeight;
    private int mDefaultPhotoViewSize;
    private int mGapBetweenImageAndText;
    private int mGapBetweenLabelAndData;
    private TextView mHeaderTextView;
    private int mHeaderWidth;
    private String mHighlightedPrefix;
    private boolean mIsSectionHeaderEnabled;
    private boolean mKeepHorizontalPaddingForPhotoView;
    private boolean mKeepVerticalPaddingForPhotoView;
    private int mLabelAndDataViewMaxHeight;
    private TextView mLabelView;
    private int mLabelViewHeight;
    private int mLabelViewWidthWeight;
    private int mLeftOffset;
    private ArrayList<HighlightSequence> mNameHighlightSequence;
    private TextView mNameTextView;
    private int mNameTextViewHeight;
    private int mNameTextViewTextColor;
    private int mNameTextViewTextSize;
    private ArrayList<HighlightSequence> mNumberHighlightSequence;
    private PhoneNumberListAdapter.Listener mPhoneNumberListAdapterListener;
    private final CharArrayBuffer mPhoneticNameBuffer;
    private TextView mPhoneticNameTextView;
    private int mPhoneticNameTextViewHeight;
    private PhotoPosition mPhotoPosition;
    private CheckableImageView mPhotoView;
    private int mPhotoViewHeight;
    private int mPhotoViewWidth;
    private boolean mPhotoViewWidthAndHeightAreReady;
    private int mPosition;
    private int mPreferredHeight;
    private ImageView mPresenceIcon;
    private int mPresenceIconMargin;
    private int mPresenceIconSize;
    private CheckableQuickContactBadge mQuickContact;
    private boolean mQuickContactEnabled;
    private int mRightOffset;
    private ColorStateList mSecondaryTextColor;
    private boolean mShowVideoCallIcon;
    private int mSnippetTextViewHeight;
    private TextView mSnippetView;
    private int mStatusTextViewHeight;
    private TextView mStatusView;
    private boolean mSupportVideoCallIcon;
    private final TextHighlighter mTextHighlighter;
    private int mTextIndent;
    private int mTextOffsetTop;
    private CharSequence mUnknownNameText;
    private ImageView mVideoCallIcon;
    private int mVideoCallIconMargin;
    private int mVideoCallIconSize;
    private ImageView mWorkProfileIcon;

    protected static class HighlightSequence {
        private final int end;
        private final int start;

        static /* synthetic */ int access$200(HighlightSequence r0) {
            return r0.start;
        }

        static /* synthetic */ int access$300(HighlightSequence r0) {
            return r0.end;
        }

        HighlightSequence(int r1, int r2) {
            this.start = r1;
            this.end = r2;
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

    public void setDividerVisible(boolean r1) {
    }

    static /* synthetic */ PhoneNumberListAdapter.Listener access$000(ContactListItemView r0) {
        return r0.mPhoneNumberListAdapterListener;
    }

    static /* synthetic */ int access$100(ContactListItemView r0) {
        return r0.mPosition;
    }

    public static final PhotoPosition getDefaultPhotoPosition(boolean r2) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L8;
        if (r2 == false) goto L7;
        return PhotoPosition.RIGHT;
    L7:
        return PhotoPosition.LEFT;
    L8:
        if (r2 == false) goto L11;
        return PhotoPosition.LEFT;
    L11:
        return PhotoPosition.RIGHT;
    }

    public ContactListItemView(Context r3) {
        super(r3);
        this.mPreferredHeight = 0;
        this.mGapBetweenImageAndText = 0;
        this.mGapBetweenLabelAndData = 0;
        this.mPresenceIconMargin = 4;
        this.mPresenceIconSize = 16;
        this.mTextIndent = 0;
        this.mVideoCallIconSize = 32;
        this.mVideoCallIconMargin = 16;
        this.mLabelViewWidthWeight = 3;
        this.mDataViewWidthWeight = 5;
        this.mShowVideoCallIcon = false;
        this.mSupportVideoCallIcon = false;
        this.mPhotoPosition = getDefaultPhotoPosition(false);
        this.mQuickContactEnabled = true;
        this.mDefaultPhotoViewSize = 0;
        this.mPhotoViewWidthAndHeightAreReady = false;
        this.mNameTextViewTextColor = -16777216;
        this.mDataBuffer = new CharArrayBuffer(128);
        this.mPhoneticNameBuffer = new CharArrayBuffer(128);
        this.mAdjustSelectionBoundsEnabled = true;
        this.mBoundsWithoutHeader = new Rect();
        this.mTextHighlighter = new TextHighlighter(1);
        this.mNameHighlightSequence = new ArrayList();
        this.mNumberHighlightSequence = new ArrayList();
    }

    public ContactListItemView(Context r1, AttributeSet r2, boolean r3) {
        this(r1, r2);
        this.mSupportVideoCallIcon = r3;
    }

    public ContactListItemView(Context r7, AttributeSet r8) {
        super(r7, r8);
        this.mPreferredHeight = 0;
        this.mGapBetweenImageAndText = 0;
        this.mGapBetweenLabelAndData = 0;
        this.mPresenceIconMargin = 4;
        this.mPresenceIconSize = 16;
        this.mTextIndent = 0;
        this.mVideoCallIconSize = 32;
        this.mVideoCallIconMargin = 16;
        this.mLabelViewWidthWeight = 3;
        this.mDataViewWidthWeight = 5;
        this.mShowVideoCallIcon = false;
        this.mSupportVideoCallIcon = false;
        this.mPhotoPosition = getDefaultPhotoPosition(false);
        this.mQuickContactEnabled = true;
        this.mDefaultPhotoViewSize = 0;
        this.mPhotoViewWidthAndHeightAreReady = false;
        this.mNameTextViewTextColor = -16777216;
        this.mDataBuffer = new CharArrayBuffer(128);
        this.mPhoneticNameBuffer = new CharArrayBuffer(128);
        this.mAdjustSelectionBoundsEnabled = true;
        this.mBoundsWithoutHeader = new Rect();
        if (R.styleable.ContactListItemView == null) goto L5;
        TypedArray r9 = getContext().obtainStyledAttributes(r8, R.styleable.ContactListItemView);
        this.mPreferredHeight = r9.getDimensionPixelSize(R.styleable.ContactListItemView_list_item_height, this.mPreferredHeight);
        this.mActivatedBackgroundDrawable = r9.getDrawable(R.styleable.ContactListItemView_activated_background);
        this.mGapBetweenImageAndText = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_gap_between_image_and_text, this.mGapBetweenImageAndText);
        this.mGapBetweenLabelAndData = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_gap_between_label_and_data, this.mGapBetweenLabelAndData);
        this.mPresenceIconMargin = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_presence_icon_margin, this.mPresenceIconMargin);
        this.mPresenceIconSize = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_presence_icon_size, this.mPresenceIconSize);
        this.mDefaultPhotoViewSize = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_photo_size, this.mDefaultPhotoViewSize);
        this.mTextIndent = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_text_indent, this.mTextIndent);
        this.mTextOffsetTop = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_text_offset_top, this.mTextOffsetTop);
        this.mDataViewWidthWeight = r9.getInteger(R.styleable.ContactListItemView_list_item_data_width_weight, this.mDataViewWidthWeight);
        this.mLabelViewWidthWeight = r9.getInteger(R.styleable.ContactListItemView_list_item_label_width_weight, this.mLabelViewWidthWeight);
        this.mNameTextViewTextColor = r9.getColor(R.styleable.ContactListItemView_list_item_name_text_color, this.mNameTextViewTextColor);
        this.mNameTextViewTextSize = (int) r9.getDimension(R.styleable.ContactListItemView_list_item_name_text_size, (int) getResources().getDimension(R.dimen.contact_browser_list_item_text_size));
        this.mVideoCallIconSize = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_video_call_icon_size, this.mVideoCallIconSize);
        this.mVideoCallIconMargin = r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_video_call_icon_margin, this.mVideoCallIconMargin);
        setPaddingRelative(r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_padding_left, 0), r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_padding_top, 0), r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_padding_right, 0), r9.getDimensionPixelOffset(R.styleable.ContactListItemView_list_item_padding_bottom, 0));
        r9.recycle();
    L5:
        this.mTextHighlighter = new TextHighlighter(1);
        if (R.styleable.Theme == null) goto L8;
        TypedArray r10 = getContext().obtainStyledAttributes(R.styleable.Theme);
        this.mSecondaryTextColor = r10.getColorStateList(R.styleable.Theme_android_textColorSecondary);
        r10.recycle();
    L8:
        this.mHeaderWidth = getResources().getDimensionPixelSize(R.dimen.contact_list_section_header_width);
        Drawable r11 = this.mActivatedBackgroundDrawable;
        if (r11 == null) goto L11;
        r11.setCallback(this);
    L11:
        this.mNameHighlightSequence = new ArrayList();
        this.mNumberHighlightSequence = new ArrayList();
        setLayoutDirection(3);
    }

    public void setUnknownNameText(CharSequence r1) {
        this.mUnknownNameText = r1;
    }

    public void setQuickContactEnabled(boolean r1) {
        this.mQuickContactEnabled = r1;
    }

    public void setShowVideoCallIcon(boolean r1, PhoneNumberListAdapter.Listener r2, int r3) {
        this.mShowVideoCallIcon = r1;
        this.mPhoneNumberListAdapterListener = r2;
        this.mPosition = r3;
        if (r1 == true) goto L5;
        ImageView r0 = this.mVideoCallIcon;
        if (r0 == null) goto L13;
        r0.setVisibility(8);
        return;
    L13:
        return;
    L5:
        if (this.mVideoCallIcon != null) goto L7;
        ImageView r4 = new ImageView(getContext());
        this.mVideoCallIcon = r4;
        addView(r4);
    L7:
        this.mVideoCallIcon.setContentDescription(getContext().getString(R.string.common_start_video_call));
        this.mVideoCallIcon.setImageResource(R.drawable.ic_search_video_call);
        this.mVideoCallIcon.setScaleType(ImageView.ScaleType.CENTER);
        this.mVideoCallIcon.setVisibility(0);
        this.mVideoCallIcon.setOnClickListener(new AnonymousClass1(this));
    }

    public void setSupportVideoCallIcon(boolean r1) {
        this.mSupportVideoCallIcon = r1;
    }

    @Override // android.view.View
    protected void onMeasure(int r9, int r10) {
        int r11 = resolveSize(0, r9);
        int r0 = this.mPreferredHeight;
        this.mNameTextViewHeight = 0;
        this.mPhoneticNameTextViewHeight = 0;
        this.mLabelViewHeight = 0;
        this.mDataViewHeight = 0;
        this.mLabelAndDataViewMaxHeight = 0;
        this.mSnippetTextViewHeight = 0;
        this.mStatusTextViewHeight = 0;
        this.mCheckBoxWidth = 0;
        this.mCheckBoxHeight = 0;
        ensurePhotoViewSize();
        if (this.mPhotoViewWidth <= 0) goto L5;
    L8:
        int r1 = (r11 - getPaddingLeft()) - getPaddingRight();
        int r2 = this.mPhotoViewWidth + this.mGapBetweenImageAndText;
    L9:
        int r3 = r1 - r2;
        if (this.mIsSectionHeaderEnabled == false) goto L13;
        r3 = r3 - (this.mHeaderWidth + this.mGapBetweenImageAndText);
    L13:
        if (this.mSupportVideoCallIcon == false) goto L16;
        r3 = r3 - (this.mVideoCallIconSize + this.mVideoCallIconMargin);
    L16:
        if (isVisible(this.mCheckBox) == false) goto L19;
        this.mCheckBox.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mCheckBoxWidth = this.mCheckBox.getMeasuredWidth();
        this.mCheckBoxHeight = this.mCheckBox.getMeasuredHeight();
        r3 = r3 - (this.mCheckBoxWidth + this.mGapBetweenImageAndText);
    L19:
        if (isVisible(this.mNameTextView) == false) goto L26;
        if (this.mPhotoPosition == PhotoPosition.LEFT) goto L23;
        int r4 = r3 - this.mTextIndent;
    L24:
        this.mNameTextView.measure(View.MeasureSpec.makeMeasureSpec(r4, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mNameTextViewHeight = this.mNameTextView.getMeasuredHeight();
        goto L26
    L23:
        r4 = r3;
    L26:
        if (isVisible(this.mPhoneticNameTextView) == false) goto L29;
        this.mPhoneticNameTextView.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mPhoneticNameTextViewHeight = this.mPhoneticNameTextView.getMeasuredHeight();
    L29:
        if (isVisible(this.mDataView) == false) goto L35;
        if (isVisible(this.mLabelView) == false) goto L33;
        int r5 = r3 - this.mGapBetweenLabelAndData;
        int r6 = this.mDataViewWidthWeight;
        int r7 = this.mLabelViewWidthWeight;
        int r8 = (r5 * r6) / (r6 + r7);
        int r12 = (r5 * r7) / (r6 + r7);
    L39:
        if (isVisible(this.mDataView) == false) goto L42;
        this.mDataView.measure(View.MeasureSpec.makeMeasureSpec(r8, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mDataViewHeight = this.mDataView.getMeasuredHeight();
    L42:
        if (isVisible(this.mLabelView) == false) goto L44;
        this.mLabelView.measure(View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mLabelViewHeight = this.mLabelView.getMeasuredHeight();
    L44:
        this.mLabelAndDataViewMaxHeight = Math.max(this.mLabelViewHeight, this.mDataViewHeight);
        if (isVisible(this.mSnippetView) == false) goto L48;
        this.mSnippetView.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mSnippetTextViewHeight = this.mSnippetView.getMeasuredHeight();
    L48:
        if (isVisible(this.mPresenceIcon) == false) goto L51;
        this.mPresenceIcon.measure(View.MeasureSpec.makeMeasureSpec(this.mPresenceIconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mPresenceIconSize, 1073741824));
        this.mStatusTextViewHeight = this.mPresenceIcon.getMeasuredHeight();
    L51:
        if (this.mSupportVideoCallIcon == false) goto L56;
        if (isVisible(this.mVideoCallIcon) == false) goto L56;
        this.mVideoCallIcon.measure(View.MeasureSpec.makeMeasureSpec(this.mVideoCallIconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mVideoCallIconSize, 1073741824));
    L56:
        if (isVisible(this.mWorkProfileIcon) == false) goto L59;
        this.mWorkProfileIcon.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mNameTextViewHeight = Math.max(this.mNameTextViewHeight, this.mWorkProfileIcon.getMeasuredHeight());
    L59:
        if (isVisible(this.mStatusView) == true) goto L61;
    L64:
        int r13 = Math.max(Math.max((((this.mNameTextViewHeight + this.mPhoneticNameTextViewHeight) + this.mLabelAndDataViewMaxHeight) + this.mSnippetTextViewHeight) + this.mStatusTextViewHeight, (this.mPhotoViewHeight + getPaddingBottom()) + getPaddingTop()), r0);
        TextView r14 = this.mHeaderTextView;
        if (r14 != null) goto L67;
    L69:
        setMeasuredDimension(r11, r13);
        return;
    L67:
        if (r14.getVisibility() != 0) goto L69;
        this.mHeaderTextView.measure(View.MeasureSpec.makeMeasureSpec(this.mHeaderWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        goto L69
    L61:
        if (isVisible(this.mPresenceIcon) == false) goto L63;
        r3 = (r3 - this.mPresenceIcon.getMeasuredWidth()) - this.mPresenceIconMargin;
    L63:
        this.mStatusView.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mStatusTextViewHeight = Math.max(this.mStatusTextViewHeight, this.mStatusView.getMeasuredHeight());
        goto L64
    L33:
        r12 = 0;
        r8 = r3;
        goto L39
    L35:
        if (isVisible(this.mLabelView) == false) goto L37;
        r8 = 0;
        r12 = r3;
        goto L39
    L37:
        r12 = 0;
        r8 = 0;
        goto L39
    L5:
        if (this.mKeepHorizontalPaddingForPhotoView == true) goto L8;
        r1 = r11 - getPaddingLeft();
        r2 = getPaddingRight();
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        int r11 = r10 - r8;
        int r12 = getPaddingLeft();
        int r13 = (r9 - r7) - getPaddingRight();
        boolean r14 = ViewUtil.isViewLayoutRtl(this);
        if (this.mIsSectionHeaderEnabled == false) goto L17;
        TextView r0 = this.mHeaderTextView;
        if (r0 == null) goto L14;
        int r1 = r0.getMeasuredHeight();
        int r2 = (((r11 + 0) - r1) / 2) + this.mTextOffsetTop;
        TextView r3 = this.mHeaderTextView;
        if (r14 == false) goto L9;
        int r4 = r13 - this.mHeaderWidth;
    L10:
        if (r14 == false) goto L12;
        int r5 = r13;
    L13:
        r3.layout(r4, r2, r5, r1 + r2);
        goto L14
    L12:
        r5 = this.mHeaderWidth + r12;
        goto L13
    L9:
        r4 = r12;
    L14:
        if (r14 == false) goto L16;
        r13 = r13 - this.mHeaderWidth;
        goto L17
    L16:
        r12 = r12 + this.mHeaderWidth;
    L17:
        int r15 = r7 + r12;
        int r16 = r7 + r13;
        int r17 = 0;
        this.mBoundsWithoutHeader.set(r15, 0, r16, r11);
        this.mLeftOffset = r15;
        this.mRightOffset = r16;
        if (this.mIsSectionHeaderEnabled == false) goto L23;
        if (r14 == false) goto L21;
        r13 = r13 - this.mGapBetweenImageAndText;
        goto L23
    L21:
        r12 = r12 + this.mGapBetweenImageAndText;
    L23:
        if (this.mActivatedStateSupported == false) goto L28;
        if (isActivated() == false) goto L28;
        this.mActivatedBackgroundDrawable.setBounds(this.mBoundsWithoutHeader);
    L28:
        if (isVisible(this.mCheckBox) == false) goto L33;
        int r18 = (((r11 + 0) - this.mCheckBoxHeight) / 2) + 0;
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L32;
        this.mCheckBox.layout(r13 - this.mCheckBoxWidth, r18, r13, this.mCheckBoxHeight + r18);
        goto L33
    L32:
        this.mCheckBox.layout(r12, r18, this.mCheckBoxWidth + r12, this.mCheckBoxHeight + r18);
    L33:
        View r19 = this.mQuickContact;
        if (r19 != null) goto L38;
        r19 = this.mPhotoView;
    L38:
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L46;
        if (r19 == null) goto L44;
        int r20 = this.mPhotoViewHeight;
        int r21 = (((r11 + 0) - r20) / 2) + 0;
        r19.layout(r12, r21, this.mPhotoViewWidth + r12, r20 + r21);
        int r22 = this.mPhotoViewWidth;
        int r23 = this.mGapBetweenImageAndText;
    L41:
        int r24 = r22 + r23;
    L42:
        r12 = r12 + r24;
    L54:
        if (this.mSupportVideoCallIcon == true) goto L56;
    L65:
        int r110 = (((r11 + 0) - ((((this.mNameTextViewHeight + this.mPhoneticNameTextViewHeight) + this.mLabelAndDataViewMaxHeight) + this.mSnippetTextViewHeight) + this.mStatusTextViewHeight)) / 2) + this.mTextOffsetTop;
        if (isVisible(this.mWorkProfileIcon) == false) goto L75;
        int r25 = this.mWorkProfileIcon.getMeasuredWidth();
        int r26 = this.mCheckBoxWidth;
        if (r26 <= 0) goto L70;
        int r27 = r26 + this.mGapBetweenImageAndText;
    L72:
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L74;
        this.mWorkProfileIcon.layout((r13 - r25) - r27, r110, r13 - r27, this.mNameTextViewHeight + r110);
    L77:
        if (isVisible(this.mNameTextView) == false) goto L86;
        int r28 = this.mCheckBoxWidth;
        if (r28 <= 0) goto L81;
        r17 = r28 + this.mGapBetweenImageAndText;
    L81:
        int r29 = r25 + r17;
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L84;
        this.mNameTextView.layout(r12, r110, r13 - r29, this.mNameTextViewHeight + r110);
        goto L86
    L84:
        this.mNameTextView.layout(r29 + r12, r110, r13, this.mNameTextViewHeight + r110);
    L86:
        if (isVisible(this.mNameTextView) == false) goto L88;
    L89:
        r110 = r110 + this.mNameTextViewHeight;
    L90:
        if (r14 == false) goto L99;
        if (isVisible(this.mPresenceIcon) == false) goto L94;
        int r30 = this.mPresenceIcon.getMeasuredWidth();
        this.mPresenceIcon.layout(r13 - r30, r110, r13, this.mStatusTextViewHeight + r110);
        int r31 = r13 - (r30 + this.mPresenceIconMargin);
    L96:
        if (isVisible(this.mStatusView) == false) goto L106;
        this.mStatusView.layout(r12, r110, r31, this.mStatusTextViewHeight + r110);
    L106:
        if (isVisible(this.mStatusView) == false) goto L108;
    L109:
        r110 = r110 + this.mStatusTextViewHeight;
    L111:
        if (isVisible(this.mPhoneticNameTextView) == false) goto L114;
        this.mPhoneticNameTextView.layout(r12, r110, r13, this.mPhoneticNameTextViewHeight + r110);
        r110 = r110 + this.mPhoneticNameTextViewHeight;
    L114:
        if (isVisible(this.mLabelView) == false) goto L118;
        if (r14 == true) goto L117;
        TextView r32 = this.mLabelView;
        int r33 = this.mLabelAndDataViewMaxHeight;
        r32.layout(r12, (r110 + r33) - this.mLabelViewHeight, r13, r33 + r110);
        int r34 = (this.mLabelView.getMeasuredWidth() + this.mGapBetweenLabelAndData) + r12;
    L120:
        if (isVisible(this.mDataView) == false) goto L125;
        if (r14 == true) goto L123;
        TextView r35 = this.mDataView;
        int r36 = this.mLabelAndDataViewMaxHeight;
        r35.layout(r34, (r110 + r36) - this.mDataViewHeight, r13, r36 + r110);
        goto L125
    L123:
        TextView r37 = this.mDataView;
        int r38 = r13 - r37.getMeasuredWidth();
        int r39 = this.mLabelAndDataViewMaxHeight;
        r37.layout(r38, (r110 + r39) - this.mDataViewHeight, r13, r39 + r110);
    L125:
        if (isVisible(this.mLabelView) == false) goto L127;
    L128:
        r110 = r110 + this.mLabelAndDataViewMaxHeight;
    L130:
        if (isVisible(this.mSnippetView) == false) goto L133;
        this.mSnippetView.layout(r12, r110, r13, this.mSnippetTextViewHeight + r110);
        return;
    L133:
        return;
    L127:
        if (isVisible(this.mDataView) == false) goto L130;
    L117:
        r34 = this.mLabelView.getMeasuredWidth() + r12;
        TextView r40 = this.mLabelView;
        int r41 = r13 - r40.getMeasuredWidth();
        int r42 = this.mLabelAndDataViewMaxHeight;
        r40.layout(r41, (r110 + r42) - this.mLabelViewHeight, r13, r42 + r110);
        r13 = r13 - (this.mLabelView.getMeasuredWidth() + this.mGapBetweenLabelAndData);
        goto L120
    L118:
        r34 = r12;
        goto L120
    L108:
        if (isVisible(this.mPresenceIcon) == false) goto L111;
    L94:
        r31 = r13;
        goto L96
    L99:
        if (isVisible(this.mPresenceIcon) == false) goto L101;
        int r43 = this.mPresenceIcon.getMeasuredWidth();
        this.mPresenceIcon.layout(r12, r110, r12 + r43, this.mStatusTextViewHeight + r110);
        int r44 = (r43 + this.mPresenceIconMargin) + r12;
    L103:
        if (isVisible(this.mStatusView) == false) goto L106;
        this.mStatusView.layout(r44, r110, r13, this.mStatusTextViewHeight + r110);
        goto L106
    L101:
        r44 = r12;
        goto L103
    L88:
        if (isVisible(this.mWorkProfileIcon) == false) goto L90;
    L74:
        this.mWorkProfileIcon.layout(r12 + r27, r110, (r12 + r25) + r27, this.mNameTextViewHeight + r110);
        goto L77
    L70:
        r27 = 0;
        goto L72
    L75:
        r25 = 0;
        goto L77
    L56:
        if (isVisible(this.mVideoCallIcon) == false) goto L62;
        int r45 = this.mVideoCallIconSize;
        int r46 = (((r11 + 0) - r45) / 2) + 0;
        if (r14 == true) goto L60;
        this.mVideoCallIcon.layout(r13 - r45, r46, r13, r45 + r46);
        goto L62
    L60:
        this.mVideoCallIcon.layout(r12, r46, r12 + r45, r45 + r46);
    L62:
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L64;
        r13 = r13 - (this.mVideoCallIconSize + this.mVideoCallIconMargin);
        goto L65
    L64:
        r12 = r12 + (this.mVideoCallIconSize + this.mVideoCallIconMargin);
        goto L65
    L44:
        if (this.mKeepHorizontalPaddingForPhotoView == false) goto L54;
        r22 = this.mPhotoViewWidth;
        r23 = this.mGapBetweenImageAndText;
        goto L41
    L46:
        if (r19 == null) goto L50;
        int r47 = this.mPhotoViewHeight;
        int r48 = (((r11 + 0) - r47) / 2) + 0;
        r19.layout(r13 - this.mPhotoViewWidth, r48, r13, r47 + r48);
        int r49 = this.mPhotoViewWidth;
        int r50 = this.mGapBetweenImageAndText;
    L48:
        r13 = r13 - (r49 + r50);
    L52:
        r24 = this.mTextIndent;
        goto L42
    L50:
        if (this.mKeepHorizontalPaddingForPhotoView == false) goto L52;
        r49 = this.mPhotoViewWidth;
        r50 = this.mGapBetweenImageAndText;
        goto L48
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect r3) {
        if (this.mAdjustSelectionBoundsEnabled == false) goto L6;
        r3.top += this.mBoundsWithoutHeader.top;
        r3.bottom = r3.top + this.mBoundsWithoutHeader.height();
        r3.left = this.mBoundsWithoutHeader.left;
        r3.right = this.mBoundsWithoutHeader.right;
        return;
    }

    protected boolean isVisible(View r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getVisibility() != 0) goto L6;
        return true;
    }

    private void ensurePhotoViewSize() {
        if (this.mPhotoViewWidthAndHeightAreReady == true) goto L16;
        int r0 = getDefaultPhotoViewSize();
        this.mPhotoViewHeight = r0;
        this.mPhotoViewWidth = r0;
        if (this.mQuickContactEnabled == false) goto L7;
    L14:
        this.mPhotoViewWidthAndHeightAreReady = true;
        return;
    L7:
        if (this.mPhotoView != null) goto L14;
        if (this.mKeepHorizontalPaddingForPhotoView == true) goto L12;
        this.mPhotoViewWidth = 0;
    L12:
        if (this.mKeepVerticalPaddingForPhotoView == true) goto L14;
        this.mPhotoViewHeight = 0;
        goto L14
    }

    protected int getDefaultPhotoViewSize() {
        return this.mDefaultPhotoViewSize;
    }

    private ViewGroup.LayoutParams getDefaultPhotoLayoutParams() {
        ViewGroup.LayoutParams r0 = generateDefaultLayoutParams();
        r0.width = getDefaultPhotoViewSize();
        r0.height = r0.width;
        return r0;
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
        if (this.mActivatedStateSupported == true) goto L5;
    L7:
        super.dispatchDraw(r2);
        return;
    L5:
        if (isActivated() == false) goto L7;
        this.mActivatedBackgroundDrawable.draw(r2);
        goto L7
    }

    public void setSectionHeader(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        TextView r3 = this.mHeaderTextView;
        if (r3 == null) goto L17;
        r3.setVisibility(8);
        return;
    L17:
        return;
    L5:
        if (this.mHeaderTextView != null) goto L11;
        TextView r0 = new TextView(getContext());
        this.mHeaderTextView = r0;
        r0.setTextAppearance(getContext(), R.style.SectionHeaderStyle);
        TextView r1 = this.mHeaderTextView;
        if (ViewUtil.isViewLayoutRtl(this) == false) goto L9;
        int r2 = 5;
    L10:
        r1.setGravity(r2);
        addView(this.mHeaderTextView);
        goto L11
    L9:
        r2 = 3;
    L11:
        setMarqueeText(this.mHeaderTextView, r4);
        this.mHeaderTextView.setVisibility(0);
        this.mHeaderTextView.setAllCaps(true);
    }

    public void setIsSectionHeaderEnabled(boolean r1) {
        this.mIsSectionHeaderEnabled = r1;
    }

    public QuickContactBadge getQuickContact() {
        if (this.mQuickContactEnabled == false) goto L16;
        if (this.mQuickContact != null) goto L14;
        this.mQuickContact = new CheckableQuickContactBadge(getContext());
        if (CompatUtils.isLollipopCompatible() == false) goto L9;
        this.mQuickContact.setOverlay(null);
    L9:
        this.mQuickContact.setLayoutParams(getDefaultPhotoLayoutParams());
        if (this.mNameTextView == null) goto L12;
        this.mQuickContact.setContentDescription(getContext().getString(R.string.description_quick_contact_for, new Object[]{this.mNameTextView.getText()}));
    L12:
        addView(this.mQuickContact);
        this.mPhotoViewWidthAndHeightAreReady = false;
    L14:
        return this.mQuickContact;
    L16:
        throw new IllegalStateException("QuickContact is disabled for this view");
    }

    public void setChecked(boolean r2, boolean r3) {
        CheckableQuickContactBadge r0 = this.mQuickContact;
        if (r0 == null) goto L5;
        r0.setChecked(r2, r3);
    L5:
        CheckableImageView r1 = this.mPhotoView;
        if (r1 == null) goto L9;
        r1.setChecked(r2, r3);
        return;
    }

    public ImageView getPhotoView() {
        if (this.mPhotoView != null) goto L6;
        CheckableImageView r0 = new CheckableImageView(getContext());
        this.mPhotoView = r0;
        r0.setLayoutParams(getDefaultPhotoLayoutParams());
        this.mPhotoView.setBackground(null);
        addView(this.mPhotoView);
        this.mPhotoViewWidthAndHeightAreReady = false;
    L6:
        return this.mPhotoView;
    }

    public void removePhotoView() {
        removePhotoView(false, true);
    }

    public void removePhotoView(boolean r2, boolean r3) {
        this.mPhotoViewWidthAndHeightAreReady = false;
        this.mKeepHorizontalPaddingForPhotoView = r2;
        this.mKeepVerticalPaddingForPhotoView = r3;
        CheckableImageView r4 = this.mPhotoView;
        if (r4 == null) goto L5;
        removeView(r4);
        this.mPhotoView = null;
    L5:
        CheckableQuickContactBadge r5 = this.mQuickContact;
        if (r5 == null) goto L9;
        removeView(r5);
        this.mQuickContact = null;
        return;
    }

    public void setHighlightedPrefix(String r1) {
        this.mHighlightedPrefix = r1;
    }

    public void clearHighlightSequences() {
        this.mNameHighlightSequence.clear();
        this.mNumberHighlightSequence.clear();
        this.mHighlightedPrefix = null;
    }

    public void addNameHighlightSequence(int r2, int r3) {
        this.mNameHighlightSequence.add(new HighlightSequence(r2, r3));
    }

    public void addNumberHighlightSequence(int r2, int r3) {
        this.mNumberHighlightSequence.add(new HighlightSequence(r2, r3));
    }

    public TextView getNameTextView() {
        if (this.mNameTextView != null) goto L9;
        TextView r0 = new TextView(getContext());
        this.mNameTextView = r0;
        r0.setSingleLine(true);
        this.mNameTextView.setEllipsize(getTextEllipsis());
        this.mNameTextView.setTextColor(this.mNameTextViewTextColor);
        this.mNameTextView.setTextSize(0, this.mNameTextViewTextSize);
        this.mNameTextView.setActivated(isActivated());
        this.mNameTextView.setGravity(16);
        this.mNameTextView.setTextAlignment(5);
        this.mNameTextView.setId(R.id.cliv_name_textview);
        if (CompatUtils.isLollipopCompatible() == false) goto L7;
        this.mNameTextView.setElegantTextHeight(false);
    L7:
        addView(this.mNameTextView);
    L9:
        return this.mNameTextView;
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
        TextView r0 = new TextView(getContext());
        this.mPhoneticNameTextView = r0;
        r0.setSingleLine(true);
        this.mPhoneticNameTextView.setEllipsize(getTextEllipsis());
        this.mPhoneticNameTextView.setTextAppearance(getContext(), android.R.style.TextAppearance.Small);
        this.mPhoneticNameTextView.setTextAlignment(5);
        TextView r1 = this.mPhoneticNameTextView;
        r1.setTypeface(r1.getTypeface(), 1);
        this.mPhoneticNameTextView.setActivated(isActivated());
        this.mPhoneticNameTextView.setId(R.id.cliv_phoneticname_textview);
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
        TextView r0 = new TextView(getContext());
        this.mLabelView = r0;
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mLabelView.setSingleLine(true);
        this.mLabelView.setEllipsize(getTextEllipsis());
        this.mLabelView.setTextAppearance(getContext(), R.style.TextAppearanceSmall);
        if (this.mPhotoPosition != PhotoPosition.LEFT) goto L7;
        this.mLabelView.setAllCaps(true);
    L8:
        this.mLabelView.setActivated(isActivated());
        this.mLabelView.setId(R.id.cliv_label_textview);
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

    public void setPhoneNumber(String r4, String r5) {
        if (r4 != null) goto L6;
        TextView r3 = this.mDataView;
        if (r3 == null) goto L11;
        r3.setVisibility(8);
        return;
    L11:
        return;
    L6:
        getDataView();
        SpannableString r6 = new SpannableString(r4);
        if (this.mNumberHighlightSequence.size() == 0) goto L9;
        HighlightSequence r7 = this.mNumberHighlightSequence.get(0);
        this.mTextHighlighter.applyMaskingHighlight(r6, HighlightSequence.access$200(r7), HighlightSequence.access$300(r7));
    L9:
        setMarqueeText(this.mDataView, r6);
        this.mDataView.setVisibility(0);
        this.mDataView.setTextDirection(3);
        this.mDataView.setTextAlignment(5);
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

    public CheckBox getCheckBox() {
        if (this.mCheckBox != null) goto L6;
        CheckBox r0 = new CheckBox(getContext());
        this.mCheckBox = r0;
        r0.setFocusable(false);
        addView(this.mCheckBox);
    L6:
        return this.mCheckBox;
    }

    public TextView getDataView() {
        if (this.mDataView != null) goto L9;
        TextView r0 = new TextView(getContext());
        this.mDataView = r0;
        r0.setSingleLine(true);
        this.mDataView.setEllipsize(getTextEllipsis());
        this.mDataView.setTextAppearance(getContext(), R.style.TextAppearanceSmall);
        this.mDataView.setTextAlignment(5);
        this.mDataView.setActivated(isActivated());
        this.mDataView.setId(R.id.cliv_data_view);
        if (CompatUtils.isLollipopCompatible() == false) goto L7;
        this.mDataView.setElegantTextHeight(false);
    L7:
        addView(this.mDataView);
    L9:
        return this.mDataView;
    }

    public void setSnippet(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        TextView r3 = this.mSnippetView;
        if (r3 == null) goto L12;
        r3.setVisibility(8);
        return;
    L12:
        return;
    L7:
        this.mTextHighlighter.setPrefixText(getSnippetView(), r4, this.mHighlightedPrefix);
        this.mSnippetView.setVisibility(0);
        if (ContactDisplayUtils.isPossiblePhoneNumber(r4) == false) goto L10;
        this.mSnippetView.setContentDescription(PhoneNumberUtilsCompat.createTtsSpannable(r4));
        return;
    L10:
        this.mSnippetView.setContentDescription(null);
    }

    public TextView getSnippetView() {
        if (this.mSnippetView != null) goto L6;
        TextView r0 = new TextView(getContext());
        this.mSnippetView = r0;
        r0.setSingleLine(true);
        this.mSnippetView.setEllipsize(getTextEllipsis());
        this.mSnippetView.setTextAppearance(getContext(), android.R.style.TextAppearance.Small);
        this.mSnippetView.setTextAlignment(5);
        this.mSnippetView.setActivated(isActivated());
        addView(this.mSnippetView);
    L6:
        return this.mSnippetView;
    }

    public TextView getStatusView() {
        if (this.mStatusView != null) goto L6;
        TextView r0 = new TextView(getContext());
        this.mStatusView = r0;
        r0.setSingleLine(true);
        this.mStatusView.setEllipsize(getTextEllipsis());
        this.mStatusView.setTextAppearance(getContext(), android.R.style.TextAppearance.Small);
        this.mStatusView.setTextColor(this.mSecondaryTextColor);
        this.mStatusView.setActivated(isActivated());
        this.mStatusView.setTextAlignment(5);
        addView(this.mStatusView);
    L6:
        return this.mStatusView;
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
        ImageView r0 = new ImageView(getContext());
        this.mPresenceIcon = r0;
        addView(r0);
    L6:
        this.mPresenceIcon.setImageDrawable(r3);
        this.mPresenceIcon.setScaleType(ImageView.ScaleType.CENTER);
        this.mPresenceIcon.setVisibility(0);
    }

    public void setWorkProfileIconEnabled(boolean r3) {
        ImageView r0 = this.mWorkProfileIcon;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r3 == true) goto L7;
        r1 = 8;
    L7:
        r0.setVisibility(r1);
        return;
    L8:
        if (r3 == false) goto L12;
        ImageView r4 = new ImageView(getContext());
        this.mWorkProfileIcon = r4;
        addView(r4);
        this.mWorkProfileIcon.setImageResource(R.drawable.ic_work_profile);
        this.mWorkProfileIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mWorkProfileIcon.setVisibility(0);
        return;
    }

    private TextUtils.TruncateAt getTextEllipsis() {
        return TextUtils.TruncateAt.MARQUEE;
    }

    public void showDisplayName(Cursor r3, int r4, int r5) {
        setDisplayName(r3.getString(r4));
        CheckableQuickContactBadge r6 = this.mQuickContact;
        if (r6 == null) goto L6;
        r6.setContentDescription(getContext().getString(R.string.description_quick_contact_for, new Object[]{this.mNameTextView.getText()}));
        return;
    }

    public void setDisplayName(CharSequence r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        if (r3 == false) goto L6;
        clearHighlightSequences();
        addNameHighlightSequence(0, r2.length());
    L6:
        setDisplayName(r2);
    }

    public void setDisplayName(CharSequence r5) {
        if (TextUtils.isEmpty(r5) == true) goto L14;
        String r0 = this.mHighlightedPrefix;
        if (r0 == null) goto L8;
        r5 = this.mTextHighlighter.applyPrefixHighlight(r5, r0);
    L15:
        setMarqueeText(getNameTextView(), r5);
        if (ContactDisplayUtils.isPossiblePhoneNumber(r5) == false) goto L18;
        this.mNameTextView.setTextDirection(3);
        this.mNameTextView.setContentDescription(PhoneNumberUtilsCompat.createTtsSpannable(r5.toString()));
        return;
    L18:
        this.mNameTextView.setContentDescription(r5.toString());
        return;
    L8:
        if (this.mNameHighlightSequence.size() == 0) goto L15;
        SpannableString r1 = new SpannableString(r5);
        Iterator<HighlightSequence> r6 = this.mNameHighlightSequence.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        HighlightSequence r2 = r6.next();
        this.mTextHighlighter.applyMaskingHighlight(r1, HighlightSequence.access$200(r2), HighlightSequence.access$300(r2));
        goto L11
    L13:
        r5 = r1;
        goto L15
    L14:
        r5 = this.mUnknownNameText;
        goto L15
    }

    public void hideCheckBox() {
        CheckBox r0 = this.mCheckBox;
        if (r0 == null) goto L6;
        removeView(r0);
        this.mCheckBox = null;
        return;
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

    public void showSnippet(Cursor r4, String r5, int r6) {
        String r7 = r4.getString(r6);
        if (r7 != null) goto L7;
        setSnippet(null);
        return;
    L7:
        if (r4.getColumnIndex("display_name") < 0) goto L9;
        String r8 = r4.getString(r4.getColumnIndex("display_name"));
    L11:
        if (r7.equals(r8) == false) goto L14;
        setSnippet(null);
        return;
    L14:
        setSnippet(updateSnippet(r7, r5, r8));
        return;
    L9:
        r8 = null;
        goto L11
    }

    public void showSnippet(Cursor r7, int r8) {
        String r1 = null;
        if (r7.getColumnCount() > r8) goto L5;
    L37:
        setSnippet(null);
        return;
    L5:
        if (Constants.SNIPPET.equals(r7.getColumnName(r8)) == false) goto L37;
        String r9 = r7.getString(r8);
        Bundle r0 = r7.getExtras();
        if (r0.getBoolean(Constants.DEFERRED_SNIPPETING_KEY) == false) goto L13;
        String r2 = r0.getString("deferred_snippeting_query");
        int r3 = r7.getColumnIndex("display_name");
        if (r3 < 0) goto L12;
        r1 = r7.getString(r3);
    L12:
        r1 = updateSnippet(r9, r2, r1);
    L35:
        setSnippet(r1);
        return;
    L13:
        if (r9 == null) goto L34;
        int r10 = r9.length();
        int r4 = r9.indexOf(91);
        if (r4 == (-1)) goto L35;
        int r5 = r9.lastIndexOf(10, r4);
        if (r5 == (-1)) goto L20;
        int r6 = r5 + 1;
    L21:
        int r11 = r9.lastIndexOf(93);
        if (r11 == (-1)) goto L26;
        int r12 = r9.indexOf(10, r11);
        if (r12 == (-1)) goto L26;
        r10 = r12;
    L26:
        StringBuilder r13 = new StringBuilder();
    L27:
        if (r6 >= r10) goto L33;
        char r14 = r9.charAt(r6);
        if (r14 == '[') goto L32;
        if (r14 == ']') goto L32;
        r13.append(r14);
    L32:
        r6 = r6 + 1;
        goto L27
    L33:
        r1 = r13.toString();
        goto L35
    L20:
        r6 = 0;
        goto L21
    L34:
        r1 = r9;
        goto L35
    }

    private String updateSnippet(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L25:
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        String r6 = SearchUtil.cleanStartAndEndOfSearchQuery(r4.toLowerCase());
        if (TextUtils.isEmpty(r5) == true) goto L15;
        Iterator<String> r7 = split(r5.toLowerCase()).iterator();
    L11:
        if (r7.hasNext() == false) goto L15;
        if (r7.next().startsWith(r6) == false) goto L11;
        return null;
    L15:
        SearchUtil.MatchedLine r8 = SearchUtil.findMatchingLine(r3, r6);
        if (r8 == null) goto L25;
        if (r8.line == null) goto L25;
        int r9 = getResources().getInteger(R.integer.snippet_length_before_tokenize);
        if (r8.line.length() <= r9) goto L24;
        return snippetize(r8.line, r8.startIndex, r9);
    L24:
        return r8.line;
    }

    private String snippetize(String r4, int r5, int r6) {
        int r3 = r5;
        int r0 = r6;
    L4:
        if (r3 >= r4.length()) goto L9;
        if (Character.isLetterOrDigit(r4.charAt(r3)) == false) goto L7;
        r0 = r0 - 1;
        r3 = r3 + 1;
        goto L4
    L7:
        r6 = r0;
    L10:
        int r1 = r5 - 1;
        int r2 = r6;
    L12:
        if (r1 <= (-1)) goto L18;
        if (r6 <= 0) goto L18;
        if (Character.isLetterOrDigit(r4.charAt(r1)) == true) goto L17;
        r2 = r6;
        r5 = r1;
    L17:
        r6 = r6 - 1;
        r1 = r1 - 1;
    L18:
        int r7 = r3;
    L20:
        if (r3 >= r4.length()) goto L26;
        if (r2 <= 0) goto L26;
        if (Character.isLetterOrDigit(r4.charAt(r3)) == true) goto L25;
        r7 = r3;
    L25:
        r2 = r2 - 1;
        r3 = r3 + 1;
    L26:
        StringBuilder r8 = new StringBuilder();
        if (r5 <= 0) goto L29;
        r8.append("...");
    L29:
        r8.append(r4.substring(r5, r7));
        if (r7 >= r4.length()) goto L33;
        r8.append("...");
    L33:
        return r8.toString();
    L9:
        r3 = r5;
        goto L10
    }

    static {
        SPLIT_PATTERN = Pattern.compile("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+");
    }

    private static List<String> split(String r2) {
        Matcher r3 = SPLIT_PATTERN.matcher(r2);
        ArrayList r0 = Lists.newArrayList();
    L4:
        if (r3.find() == false) goto L6;
        r0.add(r3.group());
        goto L4
    L6:
        return r0;
    }

    public void showData(Cursor r2, int r3) {
        r2.copyStringToBuffer(r3, this.mDataBuffer);
        setData(this.mDataBuffer.data, this.mDataBuffer.sizeCopied);
    }

    public void setActivatedStateSupported(boolean r1) {
        this.mActivatedStateSupported = r1;
    }

    public void setAdjustSelectionBoundsEnabled(boolean r1) {
        this.mAdjustSelectionBoundsEnabled = r1;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        forceLayout();
    }

    public void setPhotoPosition(PhotoPosition r1) {
        this.mPhotoPosition = r1;
    }

    public PhotoPosition getPhotoPosition() {
        return this.mPhotoPosition;
    }

    public void setDrawableResource(int r3) {
        ImageView r0 = getPhotoView();
        r0.setScaleType(ImageView.ScaleType.CENTER);
        Drawable r4 = ContextCompat.getDrawable(getContext(), r3);
        int r2 = ContextCompat.getColor(getContext(), R.color.search_shortcut_icon_color);
        if (CompatUtils.isLollipopCompatible() == false) goto L5;
        r0.setImageDrawable(r4);
        r0.setImageTintList(ColorStateList.valueOf(r2));
        return;
    L5:
        Drawable r5 = DrawableCompat.wrap(r4).mutate();
        DrawableCompat.setTint(r5, r2);
        r0.setImageDrawable(r5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        float r0 = r6.getX();
        float r1 = r6.getY();
        if (this.mBoundsWithoutHeader.contains((int) r0, (int) r1) == true) goto L10;
        if (pointIsInView(r0, r1) == false) goto L10;
        return true;
    L10:
        return super.onTouchEvent(r6);
    }

    private final boolean pointIsInView(float r2, float r3) {
        if (r2 >= this.mLeftOffset) goto L5;
    L11:
        return false;
    L5:
        if (r2 >= this.mRightOffset) goto L11;
        if (r3 < 0.0f) goto L11;
        if (r3 >= (getBottom() - getTop())) goto L11;
        return true;
    }
}
