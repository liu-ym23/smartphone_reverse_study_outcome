package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R.\u0010A\u001a\u0004\u0018\u00010\u000b2\b\u0010;\u001a\u0004\u0018\u00010\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u000eR\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSettings;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "b", "()V", "", "text", "setTrailingText", "(Ljava/lang/String;)V", "", "minWidth", "setTrailingViewMinWidth", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "enabled", "setListItemSettingsEnabled", "(Z)V", "getContentDefaultOneChildWidth", "()I", "Lcom/obric/oui/lisitem/ListItemHeightMode;", "mode", "setListItemHeightMode", "(Lcom/obric/oui/lisitem/ListItemHeightMode;)V", "Landroid/view/ViewGroup;", "p", "Landroid/view/ViewGroup;", "rootLayout", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "q", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Landroid/widget/FrameLayout;", "r", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", "Lcom/obric/oui/layout/OUIFrameLayout;", "s", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", CommonKey.KEY_VALUE, "t", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "trailingTextString", "u", "I", "contentIconWidth", "v", "Lcom/obric/oui/lisitem/ListItemHeightMode;", "heightMode", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemSettings extends OListItemGeneral {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ViewGroup f15168p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SettingsTrailingView f15169q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FrameLayout f15170r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OUIFrameLayout f15171s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f15172t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f15173u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ListItemHeightMode f15174v;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15175a = null;

        static {
            int[] r10 = new int[ListItemHeightMode.values().length];
            r10[ListItemHeightMode.DEFAULT.ordinal()] = 1;
            r10[ListItemHeightMode.COMPACT.ordinal()] = 2;
            f15175a = r10;
        }
    }

    public OListItemSettings(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f15173u = r10.getResources().getDimensionPixelSize(R$dimen.oui_listitem_content_width_large);
        this.f15174v = ListItemHeightMode.DEFAULT;
        View r12 = findViewById(R$id.ll_root);
        q.f(r12, "findViewById(R.id.ll_root)");
        this.f15168p = (ViewGroup) r12;
        this.f15169q = new SettingsTrailingView(r10, null, 0, 6, null);
        View r13 = findViewById(R$id.title_info);
        q.f(r13, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) r13);
        View r14 = findViewById(R$id.iv_content_img_background);
        q.f(r14, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) r14);
        TypedArray r15 = r10.obtainStyledAttributes(r11, R$styleable.OListItemGeneral);
        setTrailingTextString(r15.getString(R$styleable.OListItemGeneral_oui_list_item_trailing_text));
        r15.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_settings, this);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return this.f15173u;
    }

    @NotNull
    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r10 = this.f15171s;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("contentImgBackground");
        return null;
    }

    @NotNull
    public final FrameLayout getMTitleInfo() {
        FrameLayout r10 = this.f15170r;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mTitleInfo");
        return null;
    }

    @NotNull
    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f15169q;
    }

    @Nullable
    public final String getTrailingTextString() {
        return this.f15172t;
    }

    public final void setContentImgBackground(@NotNull OUIFrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f15171s = r10;
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(@Nullable Drawable r10) {
        this.f15169q.setTrailingImage(r10);
    }

    public final void setListItemHeightMode(@NotNull ListItemHeightMode r10) {
        q.g(r10, "mode");
        if (this.f15174v != r10) goto L5;
        return;
    L5:
        int r11 = a.f15175a[r10.ordinal()];
        if (r11 != 1) goto L8;
        int r12 = getResources().getDimensionPixelSize(R$dimen.oui_listitem_content_width_large);
    L13:
        this.f15168p.setMinimumHeight(r12);
        getMClContent().setMinimumHeight(r12);
        getMClContent().setMinHeight(r12);
        ViewGroup.LayoutParams r13 = getMTrailingElement().getLayoutParams();
        if (r13 != null) goto L17;
    L21:
        this.f15173u = r12;
        g();
        this.f15174v = r10;
        return;
    L17:
        if ((r13 instanceof ConstraintLayout.LayoutParams) == false) goto L21;
        int r14 = (r12 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r13;
        if (r14 >= r15.S) goto L21;
        FrameLayout r16 = getMTrailingElement();
        r15.S = r14;
        r16.setLayoutParams(r13);
        goto L21
    L8:
        if (r11 != 2) goto L11;
        r12 = getResources().getDimensionPixelSize(R$dimen.oui_listitem_content_width_middle);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
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
        this.f15170r = r10;
    }

    public final void setTrailingText(@NotNull String r10) {
        q.g(r10, "text");
        this.f15169q.setTrailingText(r10);
    }

    public final void setTrailingTextString(@Nullable String r10) {
        this.f15172t = r10;
        g();
        String r11 = this.f15172t;
        if (r11 == null) goto L6;
        setTrailingText(r11);
    L6:
        setTrailingView(this.f15169q);
    }

    public final void setTrailingViewMinWidth(int r10) {
        ViewGroup.LayoutParams r11 = getMTrailingElement().getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        FrameLayout r12 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) r11).R = r10;
        r12.setLayoutParams(r11);
        return;
    }
}
