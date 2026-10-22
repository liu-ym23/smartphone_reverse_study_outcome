package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b8.h;
import c.a;
import com.stepos.stepclaw.R;
import e0.a0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f279a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f280b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f281c;
    public CharSequence d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f282e;

    /* renamed from: f, reason: collision with root package name */
    public View f283f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayout f284g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f285h;

    /* renamed from: j, reason: collision with root package name */
    public TextView f286j;

    /* renamed from: k, reason: collision with root package name */
    public final int f287k;

    /* renamed from: l, reason: collision with root package name */
    public final int f288l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f289m;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.d, R.attr.actionModeStyle, 0);
        setBackground((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : h.p(context, resourceId));
        this.f287k = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f288l = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f279a = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int b(View view, int i8, int i9, int i10, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = ((i10 - measuredHeight) / 2) + i9;
        if (z) {
            view.layout(i8 - measuredWidth, i11, i8, measuredHeight + i11);
        } else {
            view.layout(i8, i11, i8 + measuredWidth, measuredHeight + i11);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public final void a() {
        if (this.f284g == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f284g = linearLayout;
            this.f285h = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f286j = (TextView) this.f284g.findViewById(R.id.action_bar_subtitle);
            int i8 = this.f287k;
            if (i8 != 0) {
                this.f285h.setTextAppearance(getContext(), i8);
            }
            int i9 = this.f288l;
            if (i9 != 0) {
                this.f286j.setTextAppearance(getContext(), i9);
            }
        }
        this.f285h.setText(this.d);
        this.f286j.setText(this.f282e);
        boolean zIsEmpty = TextUtils.isEmpty(this.d);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f282e);
        this.f286j.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f284g.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f284g.getParent() == null) {
            addView(this.f284g);
        }
    }

    @Override // android.view.View
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i8) {
        if (i8 != getVisibility()) {
            super.setVisibility(i8);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f279a;
    }

    public CharSequence getSubtitle() {
        return this.f282e;
    }

    public CharSequence getTitle() {
        return this.d;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, a.f1014a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f281c = false;
        }
        if (!this.f281c) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f281c = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f281c = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        boolean z2 = getLayoutDirection() == 1;
        int paddingRight = z2 ? (i10 - i8) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i9) - getPaddingTop()) - getPaddingBottom();
        LinearLayout linearLayout = this.f284g;
        if (linearLayout != null && this.f283f == null && linearLayout.getVisibility() != 8) {
            paddingRight += b(this.f284g, paddingRight, paddingTop, paddingTop2, z2);
        }
        View view = this.f283f;
        if (view != null) {
            b(view, paddingRight, paddingTop, paddingTop2, z2);
        }
        if (z2) {
            getPaddingLeft();
        } else {
            getPaddingRight();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        if (View.MeasureSpec.getMode(i8) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i9) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i8);
        int size2 = this.f279a;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i9);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        LinearLayout linearLayout = this.f284g;
        if (linearLayout != null && this.f283f == null) {
            if (this.f289m) {
                this.f284g.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f284g.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f284g.setVisibility(z ? 0 : 8);
            } else {
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), iMakeMeasureSpec);
                paddingLeft = Math.max(0, paddingLeft - linearLayout.getMeasuredWidth());
            }
        }
        View view = this.f283f;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i10 = layoutParams.width;
            int i11 = i10 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i10 >= 0) {
                paddingLeft = Math.min(i10, paddingLeft);
            }
            int i12 = layoutParams.height;
            int i13 = i12 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i12 >= 0) {
                iMin = Math.min(i12, iMin);
            }
            this.f283f.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i11), View.MeasureSpec.makeMeasureSpec(iMin, i13));
        }
        if (this.f279a > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            int measuredHeight = getChildAt(i15).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i14) {
                i14 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i14);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f280b = false;
        }
        if (!this.f280b) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f280b = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f280b = false;
        return true;
    }

    public void setContentHeight(int i8) {
        this.f279a = i8;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f283f;
        if (view2 != null) {
            removeView(view2);
        }
        this.f283f = view;
        if (view != null && (linearLayout = this.f284g) != null) {
            removeView(linearLayout);
            this.f284g = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f282e = charSequence;
        a();
    }

    public void setTitle(CharSequence charSequence) {
        this.d = charSequence;
        a();
        a0.f(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f289m) {
            requestLayout();
        }
        this.f289m = z;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
