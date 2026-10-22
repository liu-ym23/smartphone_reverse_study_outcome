package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OIconButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R.\u00106\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u0010\u000eR.\u0010<\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010\u0012R.\u0010@\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010\u0012¨\u0006A"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImg;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "b", "()V", "", "text", "setTrailingText", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "enabled", "setListItemSettingsEnabled", "(Z)V", "", "getContentDefaultOneChildWidth", "()I", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "p", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Lcom/obric/oui/button/OIconButton;", "q", "Lcom/obric/oui/button/OIconButton;", "getContentImgCircle", "()Lcom/obric/oui/button/OIconButton;", "setContentImgCircle", "(Lcom/obric/oui/button/OIconButton;)V", "contentImgCircle", "Landroid/widget/ImageView;", "r", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "ivIcon", CommonKey.KEY_VALUE, "s", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "trailingTextString", "t", "Landroid/graphics/drawable/Drawable;", "getCircleImage", "()Landroid/graphics/drawable/Drawable;", "setCircleImage", "circleImage", "u", "getIconImage", "setIconImage", "iconImage", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCircleImg extends OListItemGeneral {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SettingsTrailingView f15137p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OIconButton f15138q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f15139r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f15140s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f15141t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Drawable f15142u;

    public OListItemCircleImg(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f15137p = new SettingsTrailingView(r10, null, 0, 6, null);
        View r12 = findViewById(R$id.contentImgCircle);
        q.f(r12, "findViewById(R.id.contentImgCircle)");
        this.f15138q = (OIconButton) r12;
        View r13 = findViewById(R$id.iv_icon);
        q.f(r13, "findViewById(R.id.iv_icon)");
        this.f15139r = (ImageView) r13;
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.OListItemGeneral);
        setTrailingTextString(r14.getString(R$styleable.OListItemGeneral_oui_list_item_trailing_text));
        r14.recycle();
        if (this.f15141t == null) goto L5;
        this.f15138q.setVisibility(0);
        getMContentElement().setVisibility(0);
        return;
    L5:
        this.f15138q.setVisibility(8);
        getMContentElement().setVisibility(8);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_circle_img, this);
    }

    @Nullable
    public final Drawable getCircleImage() {
        return this.f15141t;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return yf.b.b(getResources().getDimension(R$dimen.oui_listitem_content_width_large));
    }

    @NotNull
    public final OIconButton getContentImgCircle() {
        return this.f15138q;
    }

    @Nullable
    public final Drawable getIconImage() {
        return this.f15142u;
    }

    @NotNull
    public final ImageView getIvIcon() {
        return this.f15139r;
    }

    @NotNull
    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f15137p;
    }

    @Nullable
    public final String getTrailingTextString() {
        return this.f15140s;
    }

    public final void setCircleImage(@Nullable Drawable r10) {
        this.f15141t = r10;
        if (r10 == null) goto L5;
        this.f15138q.setImageDrawable(r10);
        this.f15138q.setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        g();
        return;
    L5:
        this.f15138q.setVisibility(8);
        getMContentElement().setVisibility(8);
        goto L6
    }

    public final void setContentImgCircle(@NotNull OIconButton r10) {
        q.g(r10, "<set-?>");
        this.f15138q = r10;
    }

    public final void setIconImage(@Nullable Drawable r10) {
        this.f15142u = r10;
        if (r10 == null) goto L5;
        this.f15139r.setImageDrawable(r10);
        this.f15139r.setVisibility(0);
    L6:
        g();
        return;
    L5:
        this.f15139r.setVisibility(8);
        goto L6
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(@Nullable Drawable r10) {
        this.f15137p.setTrailingImage(r10);
    }

    public final void setIvIcon(@NotNull ImageView r10) {
        q.g(r10, "<set-?>");
        this.f15139r = r10;
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

    public final void setTrailingText(@NotNull String r10) {
        q.g(r10, "text");
        this.f15137p.setTrailingText(r10);
    }

    public final void setTrailingTextString(@Nullable String r10) {
        this.f15140s = r10;
        g();
        String r11 = this.f15140s;
        if (r11 == null) goto L6;
        setTrailingText(r11);
    L6:
        setTrailingView(this.f15137p);
    }
}
