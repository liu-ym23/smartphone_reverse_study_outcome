package com.obric.oui.paneltitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010!J7\u0010'\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0014¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\rR\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010-R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00107R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00107R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010;R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "(I)V", "", "title", "setTitle", "(Ljava/lang/String;)V", ServerElements.INFO, "setInfo", "", "show", "j", "(Z)V", "i", "h", "Landroid/view/View;", "view", "setActionView", "(Landroid/view/View;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "g", "a", "I", "b", "Z", "showInfo", "c", "showInfoIcon", "d", "showExpandIcon", "e", "Ljava/lang/String;", "f", "Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/text/OTextView;", "vTitleText", "vInfoText", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "vExpandIcon", "vInfoIcon", "Landroid/widget/FrameLayout;", "k", "Landroid/widget/FrameLayout;", "vActionContainer", "l", "Landroid/view/View;", "vActionView", "m", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelTitleBar extends ConstraintLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f15903m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f15908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OTextView f15910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OTextView f15911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f15912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f15913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f15914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f15915l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f15903m = new a(null);
    }

    @JvmOverloads
    public OPanelTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void g(int r10) {
        if (r10 == 0) goto L7;
        if (r10 == 1) goto L6;
        setPadding(f.r(this, 12), f.r(this, 12), f.r(this, 12), f.r(this, 12));
        int r11 = R$layout.o_panel_title_bar_regular;
    L8:
        removeAllViews();
        View r12 = LayoutInflater.from(getContext()).inflate(r11, this, true);
        this.f15910g = (OTextView) r12.findViewById(R$id.panel_title);
        this.f15911h = (OTextView) r12.findViewById(R$id.panel_info);
        this.f15912i = (ImageView) r12.findViewById(R$id.panel_expand_icon);
        this.f15913j = (ImageView) r12.findViewById(R$id.panel_info_icon);
        this.f15914k = (FrameLayout) r12.findViewById(R$id.panel_action_container);
        return;
    L6:
        setPadding(f.r(this, 12), f.r(this, 12), f.r(this, 12), f.r(this, 12));
        r11 = R$layout.o_panel_title_bar_regular;
        goto L8
    L7:
        setPadding(f.r(this, 12), f.r(this, 14), f.r(this, 12), f.r(this, 8));
        r11 = R$layout.o_panel_title_bar_display;
        goto L8
    }

    public final void h(boolean r10) {
        this.f15907d = r10;
        ImageView r11 = this.f15912i;
        if (r11 == null) goto L7;
        l.p(r11, r10);
        return;
    }

    public final void i(boolean r10) {
        this.f15905b = r10;
        OTextView r11 = this.f15911h;
        if (r11 == null) goto L7;
        l.p(r11, r10);
        return;
    }

    public final void j(boolean r10) {
        this.f15906c = r10;
        ImageView r11 = this.f15913j;
        if (r11 == null) goto L7;
        l.p(r11, r10);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setActionView(@Nullable View r10) {
        this.f15915l = r10;
        FrameLayout r11 = this.f15914k;
        if (r11 == null) goto L6;
        r11.removeAllViews();
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        FrameLayout r12 = this.f15914k;
        if (r12 == null) goto L13;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 21;
        Unit r14 = Unit.f21064a;
        r12.addView(r10, r13);
        return;
    }

    public final void setInfo(@Nullable String r10) {
        this.f15909f = r10;
        OTextView r11 = this.f15911h;
        if (r11 == null) goto L7;
        r11.setText(r10);
        return;
    }

    public final void setTitle(@Nullable String r10) {
        this.f15908e = r10;
        OTextView r11 = this.f15910g;
        if (r11 == null) goto L7;
        r11.setText(r10);
        return;
    }

    public final void setType(int r10) {
        if (r10 == 0) goto L6;
        if (r10 == 1) goto L6;
        return;
    L6:
        if (r10 == this.f15904a) goto L13;
        this.f15904a = r10;
        g(r10);
        setTitle(this.f15908e);
        setInfo(this.f15909f);
        i(this.f15905b);
        h(this.f15907d);
        j(this.f15906c);
        View r11 = this.f15915l;
        if (r11 == null) goto L14;
        setActionView(r11);
        return;
    L14:
        return;
    }

    @JvmOverloads
    public OPanelTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OPanelTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OPanelTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        boolean r13 = true;
        this.f15904a = 1;
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OPanelTitleBar, r12, 0);
        this.f15904a = r14.getInt(R$styleable.OPanelTitleBar_oui_panel_type, 1);
        this.f15905b = r14.getBoolean(R$styleable.OPanelTitleBar_oui_panel_show_info, true);
        this.f15906c = r14.getBoolean(R$styleable.OPanelTitleBar_oui_panel_show_info_icon, false);
        this.f15907d = r14.getBoolean(R$styleable.OPanelTitleBar_oui_panel_show_expand_icon, false);
        this.f15908e = r14.getString(R$styleable.OPanelTitleBar_oui_panel_title);
        this.f15909f = r14.getString(R$styleable.OPanelTitleBar_oui_panel_info);
        r14.recycle();
        g(this.f15904a);
        setTitle(this.f15908e);
        setInfo(this.f15909f);
        if (this.f15905b == false) goto L8;
        String r15 = this.f15909f;
        if (r15 == null) goto L8;
        if (r15.length() == 0) goto L8;
    L9:
        i(r13);
        h(this.f15907d);
        j(this.f15906c);
        return;
    L8:
        r13 = false;
        goto L9
    }
}
