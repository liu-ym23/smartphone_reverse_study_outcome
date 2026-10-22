package com.stepos.common.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$drawable;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class ContentToastLayout extends FrameLayout {
    private static final int MAX_ICON_SIZE = 32;
    public static final int TOAST_TYPE_ERROR = 1;
    public static final int TOAST_TYPE_NORMAL = 0;
    public static final int TOAST_TYPE_TEXT = 2;
    private ImageView mActionIconView;
    private int mActionTextAppearance;
    private TextView mActionTextView;
    private Drawable mActionViewBackground;
    private LinearLayout mContainerLayout;
    private Drawable mDefaultActionIcon;
    private Drawable mDefaultWarningIcon;
    private Drawable mLayoutBackground;
    private int mMaxIconSize;
    private LinearLayout mParentLayout;
    private View mSeparatorView;
    private String mText;
    private int mTitleTextAppearance;
    private TextView mTitleView;
    private int mToastType;
    private Drawable mWarningIcon;
    private ImageView mWarningView;
    private LinearLayout mWidgetLayout;
    private View mWidgetView;

    public ContentToastLayout(Context context) {
        this(context, null);
    }

    private void ensureActionView() {
        int i10 = this.mToastType;
        if (i10 == 0 || i10 == 1) {
            this.mActionIconView.setVisibility(0);
            this.mActionTextView.setVisibility(8);
        } else {
            if (i10 != 2) {
                return;
            }
            this.mActionTextView.setVisibility(0);
            this.mActionIconView.setVisibility(8);
        }
    }

    public String getText() {
        return this.mText;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ContentToastLayout.class.getName());
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        ensureActionView();
        this.mWidgetLayout.setOnClickListener(onClickListener);
    }

    public void setActionIcon(Drawable drawable) {
        ensureActionView();
        this.mDefaultActionIcon = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.mMaxIconSize;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        this.mActionIconView.setImageDrawable(drawable);
    }

    public void setActionText(CharSequence charSequence) {
        ensureActionView();
        this.mActionTextView.setText(charSequence);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        LinearLayout linearLayout = this.mParentLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(drawable);
        }
    }

    public void setContainerLayoutPadding(int i10) {
        this.mContainerLayout.setPadding(i10, 0, i10, 0);
    }

    public void setIsShowSeparator(boolean z10) {
        if (z10) {
            this.mSeparatorView.setVisibility(0);
        } else {
            this.mSeparatorView.setVisibility(8);
        }
    }

    public void setLayoutBackground(Drawable drawable) {
        this.mLayoutBackground = drawable;
        this.mParentLayout.setBackgroundDrawable(drawable);
    }

    public void setParentLayoutPadding(int i10) {
        this.mParentLayout.setPadding(i10, 0, i10, 0);
    }

    public void setText(String str) {
        this.mText = str;
        this.mTitleView.setText(str);
    }

    public void setTextColor(int i10) {
        this.mTitleView.setTextColor(i10);
    }

    public void setTitleGravity(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
        int i11 = i10 & 112;
        if (i11 == 16) {
            layoutParams.addRule(15);
        } else if (i11 == 48) {
            layoutParams.addRule(10);
        } else if (i11 == 80) {
            layoutParams.addRule(12);
        }
        int i12 = i10 & 7;
        if (i12 == 1) {
            layoutParams.addRule(14);
        } else if (i12 == 3) {
            layoutParams.addRule(9);
        } else if (i12 == 5) {
            layoutParams.addRule(11);
        }
        layoutParams.addRule(14);
        this.mTitleView.setLayoutParams(layoutParams);
    }

    public void setTitleTextMaxLine(int i10) {
        this.mTitleView.setMaxLines(i10);
    }

    public void setToastType(int i10) throws Resources.NotFoundException {
        this.mToastType = i10;
        if (i10 == 0) {
            setWarningIcon(null);
            setActionIcon(this.mDefaultActionIcon);
            return;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleTextAppearance);
                this.mParentLayout.setBackgroundDrawable(this.mLayoutBackground);
                this.mWarningView.setVisibility(8);
            }
            setActionIcon(null);
            setWarningIcon(null);
            return;
        }
        Drawable drawable = getResources().getDrawable(R$drawable.stepos_ic_content_toast_warning);
        this.mDefaultWarningIcon = drawable;
        setWarningIcon(drawable);
        setActionIcon(getResources().getDrawable(R$drawable.stepos_arrow_next_right_warning));
        this.mTitleView.setTextColor(getResources().getColor(R$color.mc_content_toast_text_color_error));
        this.mParentLayout.setBackgroundDrawable(getResources().getDrawable(R$drawable.mc_content_toast_bg_error));
        this.mWarningView.setVisibility(0);
    }

    public void setWarningIcon(Drawable drawable) {
        this.mWarningIcon = drawable;
        this.mWarningView.setImageDrawable(drawable);
    }

    public ContentToastLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.steposContentToastLayoutStyle);
    }

    public ContentToastLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mToastType = 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.steposContentToastLayout, i10, 0);
        this.mActionTextAppearance = typedArrayObtainStyledAttributes.getResourceId(R$styleable.steposContentToastLayout_steposActionTextAppearance, 0);
        this.mTitleTextAppearance = typedArrayObtainStyledAttributes.getResourceId(R$styleable.steposContentToastLayout_steposTitleTextAppearance, 0);
        this.mLayoutBackground = typedArrayObtainStyledAttributes.getDrawable(R$styleable.steposContentToastLayout_steposContentToastBackground);
        this.mDefaultActionIcon = typedArrayObtainStyledAttributes.getDrawable(R$styleable.steposContentToastLayout_steposActionIcon);
        this.mActionViewBackground = typedArrayObtainStyledAttributes.getDrawable(R$styleable.steposContentToastLayout_steposActionViewBackground);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.steposContentToastLayout_steposContentLayout, R$layout.mc_content_toast_layout_light);
        typedArrayObtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((getResources().getDisplayMetrics().density * 32.0f) + 0.5f);
        LayoutInflater.from(context).inflate(resourceId, this);
        this.mParentLayout = (LinearLayout) findViewById(R$id.mc_content_toast_parent);
        this.mLayoutBackground.setTint(getContext().getColor(R$color.fd_sys_color_surface_container_lowest_default));
        this.mParentLayout.setBackgroundDrawable(this.mLayoutBackground);
        this.mWidgetLayout = (LinearLayout) findViewById(R.id.widget_frame);
        TextView textView = (TextView) findViewById(R.id.title);
        this.mTitleView = textView;
        textView.setTextAppearance(context, this.mTitleTextAppearance);
        this.mWarningView = (ImageView) findViewById(R.id.icon);
        this.mSeparatorView = findViewById(R$id.mc_toast_separator);
        this.mContainerLayout = (LinearLayout) findViewById(R$id.mc_content_toast_container);
        this.mActionTextView = (TextView) findViewById(R$id.stepos_action_text);
        this.mActionIconView = (ImageView) findViewById(R$id.stepos_action_icon);
    }
}
