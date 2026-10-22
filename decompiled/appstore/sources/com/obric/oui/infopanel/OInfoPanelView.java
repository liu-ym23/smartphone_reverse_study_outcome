package com.obric.oui.infopanel;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;
import yf.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u00018\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010&\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/obric/oui/infopanel/OInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/ImageView;", "getTopBannerView", "()Landroid/widget/ImageView;", "getTopImgView", "", "resId", "", "setInsetTopImg", "(I)V", "setUnInsetImg", "Landroid/view/ViewGroup;", "getCustomContainer", "()Landroid/view/ViewGroup;", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "desc", "setDesc", "setScrollableDesc", "k", "()V", "m", "l", "a", "Landroid/view/ViewGroup;", "headerContainer", "b", "contentContainer", "c", "customContainer", "d", "Landroid/widget/ImageView;", "ivImg", "Lcom/obric/oui/text/OTextView;", "e", "Lcom/obric/oui/text/OTextView;", "tvTitle", "f", "tvDesc", "Landroidx/core/widget/NestedScrollView;", "g", "Landroidx/core/widget/NestedScrollView;", "descContainer", "Landroid/view/View;", "h", "Landroid/view/View;", "bottomView", "com/obric/oui/infopanel/OInfoPanelView$a", "i", "Lcom/obric/oui/infopanel/OInfoPanelView$a;", "fixDescHeightListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f15070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f15071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f15072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f15073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OTextView f15074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OTextView f15075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NestedScrollView f15076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f15077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f15078i;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OInfoPanelView f15079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f15080b;

        public a(OInfoPanelView r10, Context r11) {
            this.f15079a = r10;
            this.f15080b = r11;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (OInfoPanelView.g(this.f15079a) != null) goto L5;
            return;
        L5:
            int[] r10 = new int[2];
            View r11 = OInfoPanelView.g(this.f15079a);
            if (r11 == null) goto L9;
            r11.getLocationInWindow(r10);
        L9:
            View r12 = OInfoPanelView.g(this.f15079a);
            q.d(r12);
            int r13 = r12.getHeight() + r10[1];
            int r14 = f.m(this.f15080b);
            Log.e("jiangyunkai", q.p("height: ", Integer.valueOf(r14)));
            Log.e("jiangyunkai", q.p("bottom:", Integer.valueOf(r13)));
            if (r13 > r14) goto L12;
            return;
        L12:
            if (TextUtils.isEmpty(OInfoPanelView.i(this.f15079a).getText().toString()) == false) goto L14;
            OInfoPanelView.j(this.f15079a);
            return;
        L14:
            int r15 = (r13 - r14) - f.r(this.f15079a, 12);
            int r16 = OInfoPanelView.h(this.f15079a).getHeight() - r15;
            if (r16 >= f.r(this.f15079a, 15)) goto L17;
            OInfoPanelView.j(this.f15079a);
        L20:
            this.f15079a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L17:
            NestedScrollView r17 = OInfoPanelView.h(this.f15079a);
            ViewGroup.LayoutParams r18 = r17.getLayoutParams();
            if (r18 == null) goto L22;
            r18.height = r16;
            r17.setLayoutParams(r18);
            goto L20
        L22:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OInfoPanelView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ View g(OInfoPanelView r10) {
        return r10.f15077h;
    }

    public static final /* synthetic */ NestedScrollView h(OInfoPanelView r10) {
        return r10.f15076g;
    }

    public static final /* synthetic */ OTextView i(OInfoPanelView r10) {
        return r10.f15075f;
    }

    public static final /* synthetic */ void j(OInfoPanelView r10) {
        r10.l();
    }

    @NotNull
    public final ViewGroup getCustomContainer() {
        return this.f15072c;
    }

    @NotNull
    public final ImageView getTopBannerView() {
        m();
        return this.f15073d;
    }

    @NotNull
    public final ImageView getTopImgView() {
        k();
        return this.f15073d;
    }

    public final void k() {
        this.f15070a.setPadding(0, f.r(this, 32), 0, 0);
        if (this.f15071b.getLayoutParams() == null) goto L9;
        ViewGroup r10 = this.f15071b;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L8;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r12.setMargins(r12.leftMargin, f.r(this, 16), r12.rightMargin, r12.bottomMargin);
        r10.setLayoutParams(r12);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void l() {
    }

    public final void m() {
        this.f15070a.setPadding(0, 0, 0, 0);
        if (this.f15071b.getLayoutParams() == null) goto L9;
        ViewGroup r10 = this.f15071b;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L8;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r12.setMargins(r12.leftMargin, f.r(this, 24), r12.rightMargin, r12.bottomMargin);
        r10.setLayoutParams(r12);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setDesc(@Nullable CharSequence r10) {
        if (r10 != null) goto L8;
        l.k(this.f15075f);
        ViewGroup.LayoutParams r11 = this.f15075f.getLayoutParams();
        if (r11 == null) goto L7;
        ((ViewGroup.MarginLayoutParams) r11).topMargin = 0;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L8:
        this.f15075f.setText(r10);
        l.m(this.f15075f);
    }

    public final void setInsetTopImg(int r10) {
        getTopBannerView().setImageResource(r10);
    }

    public final void setScrollableDesc(@Nullable CharSequence r10) {
        setDesc(r10);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f15078i);
    }

    public final void setTitle(@NotNull CharSequence r10) {
        q.g(r10, "title");
        this.f15074e.setText(r10);
    }

    public final void setUnInsetImg(int r10) {
        getTopImgView().setImageResource(r10);
    }

    public /* synthetic */ OInfoPanelView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OInfoPanelView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setMinimumHeight(f.r(this, 290));
        ViewGroup.inflate(r10, R$layout.o_info_panel_frame, this);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-1, -2);
        setMinHeight(f.r(this, 290));
        setLayoutParams(r12);
        View r13 = findViewById(R$id.header_container);
        q.f(r13, "findViewById(R.id.header_container)");
        this.f15070a = (ViewGroup) r13;
        View r14 = findViewById(R$id.content_container);
        q.f(r14, "findViewById(R.id.content_container)");
        this.f15071b = (ViewGroup) r14;
        View r15 = findViewById(R$id.desc_container);
        q.f(r15, "findViewById(R.id.desc_container)");
        this.f15076g = (NestedScrollView) r15;
        View r16 = findViewById(R$id.custom_container);
        q.f(r16, "findViewById(R.id.custom_container)");
        this.f15072c = (ViewGroup) r16;
        View r17 = findViewById(R$id.iv_illustration);
        q.f(r17, "findViewById(R.id.iv_illustration)");
        this.f15073d = (ImageView) r17;
        View r18 = findViewById(R$id.tv_title);
        q.f(r18, "findViewById(R.id.tv_title)");
        this.f15074e = (OTextView) r18;
        View r19 = findViewById(R$id.tv_desc);
        OTextView r20 = (OTextView) r19;
        r20.setLineHeight(b.a(((double) r20.getTextSize()) * 1.4d));
        q.f(r19, "findViewById<OTextView>(…4).roundToInt()\n        }");
        this.f15075f = r20;
        this.f15078i = new a(this, r10);
    }
}
