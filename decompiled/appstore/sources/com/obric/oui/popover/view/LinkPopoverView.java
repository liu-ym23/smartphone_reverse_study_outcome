package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.popover.PopoverLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018¨\u0006#"}, d2 = {"Lcom/obric/oui/popover/view/LinkPopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "resId", "", "setLeftIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "", "charSequence", "setTips", "(Ljava/lang/CharSequence;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTvTips", "()Landroid/widget/TextView;", "tvTips", "c", "getIvArrow", "ivArrow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LinkPopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f16358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f16359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f16360c;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public LinkPopoverView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final ImageView getIvArrow() {
        return this.f16360c;
    }

    @NotNull
    public final ImageView getIvIcon() {
        return this.f16358a;
    }

    @NotNull
    public final TextView getTvTips() {
        return this.f16359b;
    }

    public void setLeftIcon(@DrawableRes int r10) {
        this.f16358a.setImageResource(r10);
        l.m(this.f16358a);
    }

    public final void setTips(@NotNull CharSequence r10) {
        q.g(r10, "charSequence");
        this.f16359b.setText(r10);
    }

    public /* synthetic */ LinkPopoverView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public LinkPopoverView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        LinearLayout.inflate(r10, R$layout.o_popover_link_view, this);
        setOrientation(0);
        int r12 = f.r(this, 12);
        setPadding(r12, r12, r12, r12);
        setBackground(ContextCompat.d(r10, R$drawable.o_popover_view_bg));
        View r13 = findViewById(R$id.iv_icon);
        q.f(r13, "findViewById(R.id.iv_icon)");
        this.f16358a = (ImageView) r13;
        View r14 = findViewById(R$id.tv_tips);
        q.f(r14, "findViewById(R.id.tv_tips)");
        this.f16359b = (TextView) r14;
        View r15 = findViewById(R$id.iv_arrow);
        q.f(r15, "findViewById(R.id.iv_arrow)");
        this.f16360c = (ImageView) r15;
    }

    public void setLeftIcon(@Nullable Drawable r10) {
        this.f16358a.setImageDrawable(r10);
        l.m(this.f16358a);
    }
}
