package com.android.contacts.detail.item.action;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.android.contacts.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PhoneActionView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/android/contacts/detail/item/action/PhoneActionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "Lcom/obric/oui/layout/OUILinearLayout;", "getContainer", "()Lcom/obric/oui/layout/OUILinearLayout;", "iconImage", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconImage", "()Landroidx/appcompat/widget/AppCompatImageView;", "textTitle", "Lcom/obric/oui/text/OTextView;", "getTextTitle", "()Lcom/obric/oui/text/OTextView;", "setEnableState", "", "enabled", "", "setEnabled", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhoneActionView extends LinearLayout {
    private final OUILinearLayout container;
    private final AppCompatImageView iconImage;
    private final OTextView textTitle;

    public final OUILinearLayout getContainer() {
        return this.container;
    }

    public final AppCompatImageView getIconImage() {
        return this.iconImage;
    }

    public final OTextView getTextTitle() {
        return this.textTitle;
    }

    public PhoneActionView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public PhoneActionView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public PhoneActionView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        boolean r16 = true;
        setOrientation(1);
        View r0 = LayoutInflater.from(r13).inflate(R.layout.phone_action_container, this, false);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.oui.layout.OUILinearLayout");
        OUILinearLayout r1 = (OUILinearLayout) r0;
        this.container = r1;
        addView(r1, new LinearLayout.LayoutParams(-1, -1));
        AppCompatImageView r2 = new AppCompatImageView(r13);
        this.iconImage = r2;
        int r3 = MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()));
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(r3, r3);
        r4.gravity = 1;
        r4.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics()));
        r1.addView(r2, r4);
        OTextView r5 = new OTextView(r13, null, 0, null, 14, null);
        this.textTitle = r5;
        r5.setTextSize(10.0f);
        r5.setTextColor(ResourcesCompat.getColor(r13.getResources(), R.color.oui_basic_text_1, null));
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-2, -2);
        r12.gravity = 1;
        r12.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        r1.addView(r5, r12);
        TypedArray r17 = r13.obtainStyledAttributes(r14, R.styleable.PhoneActionView);
        Intrinsics.checkNotNullExpressionValue(r17, "context.obtainStyledAttr…tyleable.PhoneActionView)");
        Drawable r18 = r17.getDrawable(0);
        String r19 = r17.getString(1);
        r17.recycle();
        if (r18 == null) goto L5;
        r2.setImageDrawable(r18);
    L5:
        String r110 = r19;
        if (r110 != null) goto L8;
    L11:
        if (r16 == true) goto L14;
        r5.setText(r110);
        return;
    L14:
        return;
    L8:
        if (r110.length() == 0) goto L11;
        r16 = false;
        goto L11
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        setEnableState(r1);
    }

    public final void setEnableState(boolean r2) {
        if (r2 == false) goto L4;
        this.iconImage.setAlpha(1.0f);
        this.textTitle.setAlpha(1.0f);
        return;
    L4:
        this.iconImage.setAlpha(0.3f);
        this.textTitle.setAlpha(0.3f);
    }
}
