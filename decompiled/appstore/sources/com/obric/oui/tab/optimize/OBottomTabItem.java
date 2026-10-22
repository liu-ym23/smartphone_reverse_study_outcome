package com.obric.oui.tab.optimize;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 72\u00020\u0001:\u0001\u0013B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u00102\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00106\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010/\"\u0004\b5\u00101¨\u00068"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "selectedColor", "unSelectedColor", Style.KEY_BG_COLOR, "", "b", "(III)V", "", "selected", "setSelected", "(Z)V", "a", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "selectedBg", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "iconContainer", "c", "I", "defaultTextColor", "d", "defaultSelectTextColor", "e", "selectBgColor", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", ServerElements.ICON, "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "h", "getSelectedIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectedIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "selectedIconDrawable", "i", "getUnselectedIconDrawable", "setUnselectedIconDrawable", "unselectedIconDrawable", "j", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItem extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f17230j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f17231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f17232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f17236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f17237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f17238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f17239i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f17230j = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomTabItem(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void c(OBottomTabItem r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = ContextCompat.b(r10.getContext(), R$color.oui_accent_fg);
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = ContextCompat.b(r10.getContext(), R$color.oui_text_3b);
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = ContextCompat.b(r10.getContext(), R$color.oui_accent_bg_low_contrast);
    L11:
        r10.b(r11, r12, r13);
    }

    public final void a(boolean r10) {
        Drawable r11 = this.f17238h;
        if (r11 == null) goto L11;
        Drawable r12 = this.f17239i;
        if (r12 == null) goto L11;
        if (r10 == false) goto L9;
        this.f17236f.setImageDrawable(r11);
        return;
    L9:
        this.f17236f.setImageDrawable(r12);
        return;
    L11:
        L.j("optimize.OBottomTabItem", "please set selectedIconDrawable and unselectedIconDrawable");
    }

    public final void b(int r10, int r11, int r12) {
        ColorStateList r13 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{r10, r11});
        this.f17231a = null;
        this.f17235e = r12;
        this.f17236f.setImageTintList(r13);
        this.f17237g.setTextColor(r13);
    }

    @NotNull
    public final ImageView getIcon() {
        return this.f17236f;
    }

    @Nullable
    public final Drawable getSelectedIconDrawable() {
        return this.f17238h;
    }

    @NotNull
    public final TextView getTitle() {
        return this.f17237g;
    }

    @Nullable
    public final Drawable getUnselectedIconDrawable() {
        return this.f17239i;
    }

    @JvmOverloads
    public final void setImageAndTextTintColor(int r10) {
        c(this, r10, 0, 0, 6, null);
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        a(r10);
        if (r10 == false) goto L5;
        this.f17237g.setTextAppearance(R$style.Label_S_Thick);
        return;
    L5:
        this.f17237g.setTextAppearance(R$style.Label_S);
    }

    public final void setSelectedIconDrawable(@Nullable Drawable r10) {
        this.f17238h = r10;
    }

    public final void setUnselectedIconDrawable(@Nullable Drawable r10) {
        this.f17239i = r10;
    }

    public /* synthetic */ OBottomTabItem(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OBottomTabItem(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r10).inflate(R$layout.o_tab_bottom_item, this, true);
        View r12 = findViewById(R$id.icon_container);
        q.f(r12, "findViewById(R.id.icon_container)");
        this.f17232b = (FrameLayout) r12;
        View r13 = findViewById(R$id.icon);
        q.f(r13, "findViewById(R.id.icon)");
        this.f17236f = (ImageView) r13;
        View r14 = findViewById(R$id.title);
        q.f(r14, "findViewById(R.id.title)");
        this.f17237g = (TextView) r14;
        int r15 = ContextCompat.b(getContext(), R$color.oui_accent_fg);
        this.f17234d = r15;
        int r16 = ContextCompat.b(getContext(), R$color.oui_text_3b);
        this.f17233c = r16;
        int r17 = ContextCompat.b(getContext(), R$color.oui_accent_bg_low_contrast);
        this.f17235e = r17;
        b(r15, r16, r17);
    }
}
