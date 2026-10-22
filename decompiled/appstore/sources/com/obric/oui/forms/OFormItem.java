package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$style;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/forms/OFormItem;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "d", "()V", "Lcom/obric/oui/text/OTextView;", "getLabelView", "()Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "a", "Lcom/obric/oui/text/OTextView;", "vLabel", "b", "Lcom/obric/oui/forms/OInputView;", "vInput", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFormItem extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f14652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OInputView f14653b;

    @JvmOverloads
    public OFormItem(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void d() {
        this.f14653b.setShowLabel(false);
        OTextView r10 = this.f14652a;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L21;
        LinearLayoutCompat.LayoutParams r12 = (LinearLayoutCompat.LayoutParams) r11;
        if (getOrientation() != 0) goto L7;
        int r13 = tc.f.r(this, 72);
    L8:
        ((LinearLayout.LayoutParams) r12).width = r13;
        ((LinearLayout.LayoutParams) r12).height = -2;
        r10.setLayoutParams(r12);
        this.f14652a.setText(ServerElements.LABEL);
        this.f14653b.setHint("hint");
        OInputView r14 = this.f14653b;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L19;
        LinearLayoutCompat.LayoutParams r16 = (LinearLayoutCompat.LayoutParams) r15;
        ((LinearLayout.LayoutParams) r16).weight = 1.0f;
        ((LinearLayout.LayoutParams) r16).width = -1;
        ((LinearLayout.LayoutParams) r16).height = -2;
        if (getOrientation() != 1) goto L14;
        ((LinearLayout.LayoutParams) r16).topMargin = tc.f.r(this, 8);
    L16:
        r14.setLayoutParams(r16);
        return;
    L14:
        if (getOrientation() != 0) goto L16;
        r16.setMarginStart(tc.f.r(this, 12));
        ((LinearLayout.LayoutParams) r16).leftMargin = tc.f.r(this, 12);
        goto L16
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    L7:
        r13 = -1;
        goto L8
    L21:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    }

    @NotNull
    public final OInputView getInputView() {
        return this.f14653b;
    }

    @NotNull
    public final OTextView getLabelView() {
        return this.f14652a;
    }

    @JvmOverloads
    public OFormItem(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OFormItem(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OFormItem(@NotNull Context r17, @Nullable AttributeSet r18, int r19) {
        q.g(r17, "context");
        super(r17, r18, r19);
        OTextView r15 = new OTextView(new ContextThemeWrapper(r17, R$style.Label_L), null, 0, null, 14, null);
        this.f14652a = r15;
        OInputView r10 = new OInputView(r17, null, 0, 6, null);
        this.f14653b = r10;
        setGravity(16);
        TypedArray r11 = r17.obtainStyledAttributes(r18, R$styleable.LinearLayoutCompat, r19, 0);
        int r12 = r11.getInt(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (r12 < 0) goto L5;
        setGravity(r12);
    L5:
        r11.recycle();
        addView(r15);
        addView(r10);
        d();
    }
}
