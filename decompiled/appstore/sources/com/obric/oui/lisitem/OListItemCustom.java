package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b\r\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R.\u0010?\u001a\u0004\u0018\u00010\u000b2\b\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u000e¨\u0006@"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCustom;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "b", "()V", "", "text", "setTrailingText", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "enabled", "setListItemSettingsEnabled", "(Z)V", "", "getContentDefaultOneChildWidth", "()I", "Landroid/widget/FrameLayout;", "p", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", "Lcom/obric/oui/layout/OUIFrameLayout;", "q", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", "Lcom/obric/oui/text/OTextView;", "r", "Lcom/obric/oui/text/OTextView;", "getTrailingText", "()Lcom/obric/oui/text/OTextView;", "(Lcom/obric/oui/text/OTextView;)V", "trailingText", "Landroid/widget/ImageView;", "s", "Landroid/widget/ImageView;", "getTrailingImageView", "()Landroid/widget/ImageView;", "setTrailingImageView", "(Landroid/widget/ImageView;)V", "trailingImageView", CommonKey.KEY_VALUE, "t", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "trailingTextString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCustom extends OListItemGeneral {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FrameLayout f15145p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OUIFrameLayout f15146q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OTextView f15147r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f15148s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f15149t;

    public OListItemCustom(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        View r12 = findViewById(R$id.title_info);
        q.f(r12, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) r12);
        View r13 = findViewById(R$id.iv_content_img_background);
        q.f(r13, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) r13);
        View r14 = findViewById(R$id.trailingText);
        q.f(r14, "findViewById(R.id.trailingText)");
        setTrailingText((OTextView) r14);
        View r15 = findViewById(R$id.trailingImage);
        q.f(r15, "findViewById(R.id.trailingImage)");
        setTrailingImageView((ImageView) r15);
        TypedArray r16 = r10.obtainStyledAttributes(r11, R$styleable.OListItemGeneral);
        setTrailingTextString(r16.getString(R$styleable.OListItemGeneral_oui_list_item_trailing_text));
        r16.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_custom_trailing, this);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return yf.b.b(getResources().getDimension(R$dimen.oui_listitem_content_width_large));
    }

    @NotNull
    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r10 = this.f15146q;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("contentImgBackground");
        return null;
    }

    @NotNull
    public final FrameLayout getMTitleInfo() {
        FrameLayout r10 = this.f15145p;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mTitleInfo");
        return null;
    }

    @NotNull
    public final ImageView getTrailingImageView() {
        ImageView r10 = this.f15148s;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("trailingImageView");
        return null;
    }

    @NotNull
    public final OTextView getTrailingText() {
        OTextView r10 = this.f15147r;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("trailingText");
        return null;
    }

    @Nullable
    public final String getTrailingTextString() {
        return this.f15149t;
    }

    public final void setContentImgBackground(@NotNull OUIFrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f15146q = r10;
    }

    public final void setImageView(@Nullable Drawable r10) {
        getTrailingImageView().setImageDrawable(r10);
    }

    public final void setListItemSettingsEnabled(boolean r10) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r10);
        if (r10 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    public final void setMTitleInfo(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f15145p = r10;
    }

    public final void setTrailingImageView(@NotNull ImageView r10) {
        q.g(r10, "<set-?>");
        this.f15148s = r10;
    }

    public final void setTrailingText(@NotNull OTextView r10) {
        q.g(r10, "<set-?>");
        this.f15147r = r10;
    }

    public final void setTrailingTextString(@Nullable String r10) {
        this.f15149t = r10;
        g();
        String r11 = this.f15149t;
        if (r11 == null) goto L7;
        setTrailingText(r11);
        return;
    }

    public final void setTrailingText(@NotNull String r10) {
        q.g(r10, "text");
        getTrailingText().setText(r10);
    }
}
