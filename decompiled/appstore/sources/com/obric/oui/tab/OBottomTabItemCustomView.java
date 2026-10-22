package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import o.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabItem")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0017\u0010 \u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R.\u0010/\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R4\u00108\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00158\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b0\u00101\u0012\u0004\b6\u00107\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/obric/oui/tab/OBottomTabItemCustomView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "selected", "", "setSelected", "(Z)V", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "selectedBg", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "iconContainer", "", "c", "I", "defaultTextColor", "d", "defaultSelectTextColor", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", ServerElements.ICON, "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "Landroid/content/res/ColorStateList;", CommonKey.KEY_VALUE, "g", "Landroid/content/res/ColorStateList;", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "textColor", "h", "Ljava/lang/Integer;", "getSelectedBgColor", "()Ljava/lang/Integer;", "setSelectedBgColor", "(Ljava/lang/Integer;)V", "getSelectedBgColor$annotations", "()V", "selectedBgColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItemCustomView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f17091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f17092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f17095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f17096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f17097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f17098h;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomTabItemCustomView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @Deprecated(message = "2024.11.4 最新的设计规范移除了选中状态的背景色")
    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    @NotNull
    public final ImageView getIcon() {
        return this.f17095e;
    }

    @Nullable
    public final Integer getSelectedBgColor() {
        return this.f17098h;
    }

    @Nullable
    public final ColorStateList getTextColor() {
        return this.f17097g;
    }

    @NotNull
    public final TextView getTitle() {
        return this.f17096f;
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        Integer r11 = null;
        if (r10 == false) goto L14;
        ColorStateList r12 = this.f17097g;
        if (r12 == null) goto L8;
        r11 = Integer.valueOf(r12.getColorForState(RelativeLayout.SELECTED_STATE_SET, this.f17094d));
    L8:
        if (r11 != null) goto L10;
        int r13 = this.f17094d;
    L11:
        this.f17096f.setTextColor(r13);
        if (this.f17095e.getDrawable() == null) goto L25;
        ImageView r14 = this.f17095e;
        Drawable r15 = a.l(r14.getDrawable());
        r15.setTint(r13);
        r14.setImageDrawable(r15);
        return;
    L25:
        return;
    L10:
        r13 = r11.intValue();
        goto L11
    L14:
        ColorStateList r16 = this.f17097g;
        if (r16 == null) goto L18;
        r11 = Integer.valueOf(r16.getDefaultColor());
    L18:
        if (r11 != null) goto L20;
        int r17 = this.f17093c;
    L21:
        this.f17096f.setTextColor(r17);
        if (this.f17095e.getDrawable() == null) goto L27;
        ImageView r18 = this.f17095e;
        Drawable r19 = a.l(r18.getDrawable());
        r19.setTint(r17);
        r18.setImageDrawable(r19);
        return;
    L27:
        return;
    L20:
        r17 = r11.intValue();
        goto L21
    }

    public final void setSelectedBgColor(@Nullable Integer r10) {
        this.f17098h = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        r11.setCornerRadius(getResources().getDimension(R$dimen.oui_r_m1));
        r11.setColor(r10.intValue());
        this.f17091a = r11;
    }

    public final void setTextColor(@Nullable ColorStateList r10) {
        this.f17097g = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        this.f17096f.setTextColor(r10.getDefaultColor());
        if (this.f17095e.getDrawable() == null) goto L9;
        ImageView r11 = this.f17095e;
        Drawable r12 = a.l(r11.getDrawable());
        r12.setTint(r10.getDefaultColor());
        r11.setImageDrawable(r12);
        return;
    }

    public /* synthetic */ OBottomTabItemCustomView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OBottomTabItemCustomView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r10).inflate(R$layout.o_tab_bottom_item, this, true);
        View r12 = findViewById(R$id.icon_container);
        q.f(r12, "findViewById(R.id.icon_container)");
        this.f17092b = (FrameLayout) r12;
        View r13 = findViewById(R$id.icon);
        q.f(r13, "findViewById(R.id.icon)");
        this.f17095e = (ImageView) r13;
        View r14 = findViewById(R$id.title);
        q.f(r14, "findViewById(R.id.title)");
        this.f17096f = (TextView) r14;
        this.f17093c = ContextCompat.b(getContext(), R$color.oui_text_3);
        this.f17094d = ContextCompat.b(getContext(), R$color.oui_accent_fg);
    }
}
