package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/obric/oui/lisitem/SettingsTrailingView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "text", "", "setTrailingText", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImage", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "setIconImageView", "(Landroid/widget/ImageView;)V", "iconImageView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SettingsTrailingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f15179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f15180b;

    @JvmOverloads
    public SettingsTrailingView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @NotNull
    public final ImageView getIconImageView() {
        return this.f15180b;
    }

    @NotNull
    public final TextView getTextView() {
        return this.f15179a;
    }

    public final void setIconImageView(@NotNull ImageView r10) {
        q.g(r10, "<set-?>");
        this.f15180b = r10;
    }

    public final void setTextView(@NotNull TextView r10) {
        q.g(r10, "<set-?>");
        this.f15179a = r10;
    }

    public final void setTrailingImage(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f15180b.setImageDrawable(r10);
    }

    public final void setTrailingText(@NotNull String r10) {
        q.g(r10, "text");
        this.f15179a.setText(r10);
    }

    @JvmOverloads
    public SettingsTrailingView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ SettingsTrailingView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public SettingsTrailingView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        View r13 = LayoutInflater.from(r10).inflate(R$layout.o_settings_trailing_view_2, this, false);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-1, -2);
        r14.gravity = 8388629;
        addView(r13, r14);
        View r15 = findViewById(R$id.trailingText);
        q.f(r15, "findViewById(R.id.trailingText)");
        this.f15179a = (TextView) r15;
        View r16 = findViewById(R$id.trailingImage);
        q.f(r16, "findViewById(R.id.trailingImage)");
        ImageView r17 = (ImageView) r16;
        this.f15180b = r17;
        r17.setImageDrawable(r10.getDrawable(R$drawable.ic_arrow_forward_list_item));
    }
}
