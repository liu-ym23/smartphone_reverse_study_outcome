package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.j;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\"\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0013J!\u0010\u0017\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001c\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\u000fJ/\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%H\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u0010\rJ\u0017\u00104\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u0010\rJ\u001f\u00107\u001a\u00020\b2\u0006\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020%H\u0014¢\u0006\u0004\b7\u00108J7\u0010>\u001a\u00020\b2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%H\u0014¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\nH\u0016¢\u0006\u0004\b@\u0010AR\"\u0010H\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010C\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\"\u0010N\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010C\u001a\u0004\bL\u0010E\"\u0004\bM\u0010GR\"\u0010U\u001a\u00020O8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010]\u001a\u00020V8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010`\u001a\u00020V8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010X\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\"\u0010g\u001a\u00020a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR.\u0010o\u001a\u0004\u0018\u00010h2\b\u0010i\u001a\u0004\u0018\u00010h8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR.\u0010s\u001a\u0004\u0018\u00010h2\b\u0010i\u001a\u0004\u0018\u00010h8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010j\u001a\u0004\bq\u0010l\"\u0004\br\u0010nR.\u0010y\u001a\u0004\u0018\u00010\u001e2\b\u0010i\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010!R.\u0010}\u001a\u0004\u0018\u00010\u001e2\b\u0010i\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010u\u001a\u0004\b{\u0010w\"\u0004\b|\u0010!R-\u0010\u0082\u0001\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u0014\n\u0004\b~\u0010\u007f\u001a\u0005\b\u0080\u0001\u0010A\"\u0005\b\u0081\u0001\u0010\rR.\u0010\u0086\u0001\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010\u007f\u001a\u0005\b\u0084\u0001\u0010A\"\u0005\b\u0085\u0001\u0010\rR.\u0010\u008a\u0001\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u007f\u001a\u0005\b\u0088\u0001\u0010A\"\u0005\b\u0089\u0001\u0010\rR3\u0010\u0092\u0001\u001a\u00030\u008b\u00012\u0007\u0010i\u001a\u00030\u008b\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006\u0093\u0001"}, d2 = {"Lcom/obric/oui/lisitem/OListItemGeneral;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "c", "", "enabled", "setAlpha", "(Z)V", "b", "()V", "Landroid/view/View;", "view", "setLeadingView", "(Landroid/view/View;)V", "setTrailingView", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "f", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup;", "parent", "child", "d", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "(Landroid/graphics/drawable/Drawable;)V", "a", "(Landroid/view/ViewGroup;)Z", "g", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "getContentDefaultOneChildWidth", "()I", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "selected", "setSelected", "setEnabled", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "shouldUpdateDividerColorOnPress", "()Z", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "getMLeadingElement", "()Landroid/widget/FrameLayout;", "setMLeadingElement", "(Landroid/widget/FrameLayout;)V", "mLeadingElement", "getMTrailingElement", "setMTrailingElement", "mTrailingElement", "getMContentElement", "setMContentElement", "mContentElement", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getMIvContent", "()Landroid/widget/ImageView;", "setMIvContent", "(Landroid/widget/ImageView;)V", "mIvContent", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvSubtitle", "setMTvSubtitle", "mTvSubtitle", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMClContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMClContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mClContent", "", CommonKey.KEY_VALUE, "Ljava/lang/CharSequence;", "getTitleString", "()Ljava/lang/CharSequence;", "setTitleString", "(Ljava/lang/CharSequence;)V", "titleString", "i", "getSubTitleString", "setSubTitleString", "subTitleString", "j", "Landroid/graphics/drawable/Drawable;", "getContentImage", "()Landroid/graphics/drawable/Drawable;", "setContentImage", "contentImage", "k", "getTrailingImage", "setTrailingImage", "trailingImage", "l", "Z", "getShowBackground", "setShowBackground", "showBackground", "m", "getShowPreDefineBackground", "setShowPreDefineBackground", "showPreDefineBackground", "n", "getShowDivider", "setShowDivider", "showDivider", "", "o", "F", "getMContentElementWidth", "()F", "setMContentElementWidth", "(F)V", "mContentElementWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemGeneral extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f15150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f15151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f15152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f15153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f15154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f15155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintLayout f15156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f15157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f15158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f15159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f15160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f15161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f15163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f15164o;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f15165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OListItemGeneral f15167c;

        public a(View r10, boolean r11, OListItemGeneral r12) {
            this.f15165a = r10;
            this.f15166b = r11;
            this.f15167c = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f15166b == false) goto L5;
            OListItemGeneral r10 = this.f15167c;
            r10.updateBottomDivider(r10.getMClContent().getLeft(), 0, f.p(this.f15167c, 0.6d), this.f15167c.getResources().getColor(R$color.oui_line_2));
            return;
        L5:
            OListItemGeneral r11 = this.f15167c;
            r11.updateBottomDivider(r11.getMClContent().getLeft(), 0, 0, R$color.oui_line_2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OListItemGeneral(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    private final void c(Context r10, AttributeSet r11) {
        b();
        ViewParent r12 = (ViewGroup) findViewById(R$id.ll_root);
        td.c r13 = td.c.f24796a;
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L7:
        IOUIAlpha r14 = (IOUIAlpha) r12;
        if (r14 == null) goto L11;
        r14.setChangeAlphaWhenPress(false);
    L11:
        View r15 = findViewById(R$id.fl_leading_element);
        q.f(r15, "findViewById(R.id.fl_leading_element)");
        setMLeadingElement((FrameLayout) r15);
        View r16 = findViewById(R$id.fl_trailing_element);
        q.f(r16, "findViewById(R.id.fl_trailing_element)");
        setMTrailingElement((FrameLayout) r16);
        View r17 = findViewById(R$id.fl_content_element);
        q.f(r17, "findViewById(R.id.fl_content_element)");
        setMContentElement((FrameLayout) r17);
        View r18 = findViewById(R$id.iv_content_img);
        q.f(r18, "findViewById(R.id.iv_content_img)");
        setMIvContent((ImageView) r18);
        View r19 = findViewById(R$id.cl_content_container);
        q.f(r19, "findViewById(R.id.cl_content_container)");
        setMClContent((ConstraintLayout) r19);
        View r20 = findViewById(R$id.tv_content_title);
        q.f(r20, "findViewById(R.id.tv_content_title)");
        setMTvTitle((TextView) r20);
        View r21 = findViewById(R$id.tv_content_subtitle);
        q.f(r21, "findViewById(R.id.tv_content_subtitle)");
        setMTvSubtitle((TextView) r21);
        TypedArray r22 = r10.obtainStyledAttributes(r11, R$styleable.OListItemGeneral);
        setTitleString(r22.getString(R$styleable.OListItemGeneral_oui_list_item_title));
        setSubTitleString(r22.getString(R$styleable.OListItemGeneral_oui_list_item_subtitle));
        setTrailingImage(r22.getDrawable(R$styleable.OListItemGeneral_oui_list_item_trailing_image));
        setContentImage(r22.getDrawable(R$styleable.OListItemGeneral_oui_list_item_content_image));
        setShowPreDefineBackground(r22.getBoolean(R$styleable.OListItemGeneral_oui_list_item_show_background, true));
        setShowDivider(r22.getBoolean(R$styleable.OListItemGeneral_oui_list_item_show_divider, false));
        setMContentElementWidth(r22.getDimension(R$styleable.OListItemGeneral_oui_list_item_content_width, 0.0f));
        r22.recycle();
        setRadius((int) getResources().getDimension(R$dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r12 instanceof IOUIAlpha) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void e(OListItemGeneral r10, ViewGroup r11, View r12, ViewGroup.LayoutParams r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L6;
        r13 = null;
    L6:
        r10.d(r11, r12, r13);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChildToParent");
    }

    public final boolean a(ViewGroup r10) {
        q.g(r10, "parent");
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        int r13 = r12 + 1;
        if (r10.getChildAt(r12).getVisibility() == 0) goto L6;
        r12 = r13;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_general, this);
    }

    public final void d(ViewGroup r10, View r11, ViewGroup.LayoutParams r12) {
        if (r11 == null) goto L16;
        if (r10 == null) goto L6;
        l.m(r10);
    L6:
        if (r10 == null) goto L9;
        r10.removeAllViews();
    L9:
        if (r12 != null) goto L13;
        if (r10 == null) goto L22;
        r10.addView(r11);
        return;
    L22:
        return;
    L13:
        if (r10 == null) goto L23;
        r10.addView(r11, r12);
        return;
    L23:
        return;
    L16:
        if (r10 == null) goto L24;
        l.k(r10);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r10);
    }

    public final void f(View r10, ViewGroup.LayoutParams r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L5;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
        r12.gravity = 8388629;
        ViewGroup.LayoutParams r13 = r12;
    L5:
        d(getMTrailingElement(), r10, r13);
        return;
    }

    public final void g() {
        if (a(getMContentElement()) == false) goto L5;
        com.obric.oui.indicator.c.e(getMContentElement(), getContentDefaultOneChildWidth());
    L7:
        if (this.f15164o == 0.0f) goto L11;
        com.obric.oui.indicator.c.e(getMContentElement(), (int) this.f15164o);
        return;
    L11:
        return;
    L5:
        com.obric.oui.indicator.c.e(getMContentElement(), yf.b.b(getResources().getDimension(R$dimen.oui_listitem_content_width_empty)));
        goto L7
    }

    public int getContentDefaultOneChildWidth() {
        return yf.b.b(getResources().getDimension(R$dimen.oui_listitem_content_width_middle));
    }

    @Nullable
    public final Drawable getContentImage() {
        return this.f15159j;
    }

    @NotNull
    public final ConstraintLayout getMClContent() {
        ConstraintLayout r10 = this.f15156g;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mClContent");
        return null;
    }

    @NotNull
    public final FrameLayout getMContentElement() {
        FrameLayout r10 = this.f15152c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mContentElement");
        return null;
    }

    public final float getMContentElementWidth() {
        return this.f15164o;
    }

    @NotNull
    public final ImageView getMIvContent() {
        ImageView r10 = this.f15153d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mIvContent");
        return null;
    }

    @NotNull
    public final FrameLayout getMLeadingElement() {
        FrameLayout r10 = this.f15150a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mLeadingElement");
        return null;
    }

    @NotNull
    public final FrameLayout getMTrailingElement() {
        FrameLayout r10 = this.f15151b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mTrailingElement");
        return null;
    }

    @NotNull
    public final TextView getMTvSubtitle() {
        TextView r10 = this.f15155f;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mTvSubtitle");
        return null;
    }

    @NotNull
    public final TextView getMTvTitle() {
        TextView r10 = this.f15154e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mTvTitle");
        return null;
    }

    public final boolean getShowBackground() {
        return this.f15162m;
    }

    public final boolean getShowDivider() {
        return this.f15163n;
    }

    public final boolean getShowPreDefineBackground() {
        return this.f15162m;
    }

    @Nullable
    public final CharSequence getSubTitleString() {
        return this.f15158i;
    }

    @Nullable
    public final CharSequence getTitleString() {
        return this.f15157h;
    }

    @Nullable
    public final Drawable getTrailingImage() {
        return this.f15160k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        setShowDivider(this.f15163n);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
    }

    public final void setAlpha(boolean r10) {
        if (r10 == true) goto L4;
        float r11 = 0.3f;
    L5:
        setAlpha(r11);
        return;
    L4:
        r11 = 1.0f;
        goto L5
    }

    public final void setContentImage(@Nullable Drawable r10) {
        this.f15159j = r10;
        if (r10 == null) goto L5;
        getMIvContent().setImageDrawable(this.f15159j);
        getMIvContent().setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        g();
        return;
    L5:
        getMIvContent().setVisibility(8);
        goto L6
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
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

    public final void setLeadingView(@Nullable View r10) {
        if (r10 == null) goto L5;
        e(this, getMLeadingElement(), r10, null, 4, null);
        return;
    }

    public final void setMClContent(@NotNull ConstraintLayout r10) {
        q.g(r10, "<set-?>");
        this.f15156g = r10;
    }

    public final void setMContentElement(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f15152c = r10;
    }

    public final void setMContentElementWidth(float r10) {
        this.f15164o = r10;
        if (r10 == 0.0f) goto L7;
        com.obric.oui.indicator.c.e(getMContentElement(), (int) r10);
        return;
    }

    public final void setMIvContent(@NotNull ImageView r10) {
        q.g(r10, "<set-?>");
        this.f15153d = r10;
    }

    public final void setMLeadingElement(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f15150a = r10;
    }

    public final void setMTrailingElement(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f15151b = r10;
    }

    public final void setMTvSubtitle(@NotNull TextView r10) {
        q.g(r10, "<set-?>");
        this.f15155f = r10;
    }

    public final void setMTvTitle(@NotNull TextView r10) {
        q.g(r10, "<set-?>");
        this.f15154e = r10;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        getAlphaHelper().onSelectedChanged(this, r10);
    }

    public final void setShowBackground(boolean r10) {
        this.f15161l = r10;
        setShowPreDefineBackground(r10);
    }

    public final void setShowDivider(boolean r10) {
        this.f15163n = r10;
        q.f(j.a(this, new a(this, r10, this)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setShowPreDefineBackground(boolean r10) {
        this.f15162m = r10;
        if (getBackground() != null) goto L9;
        ColorDrawable r11 = null;
        if (r10 == false) goto L7;
        r11 = new ColorDrawable(getResources().getColor(R$color.oui_fill_list_item_card, null));
    L7:
        setBackground(r11);
        return;
    }

    public final void setSubTitleString(@Nullable CharSequence r10) {
        this.f15158i = r10;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        l.k(getMTvSubtitle());
        return;
    L5:
        l.m(getMTvSubtitle());
        getMTvSubtitle().setText(this.f15158i);
    }

    public final void setTitleString(@Nullable CharSequence r10) {
        this.f15157h = r10;
        getMTvTitle().setText(r10);
    }

    public final void setTrailingImage(@Nullable Drawable r10) {
        this.f15160k = r10;
        setTrailingImageView(r10);
    }

    public final void setTrailingImageView(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ImageView r11 = new ImageView(getContext());
        r11.setImageDrawable(r10);
        setTrailingView(r11);
    }

    public final void setTrailingView(@Nullable View r10) {
        if (r10 == null) goto L5;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 8388629;
        d(getMTrailingElement(), r10, r11);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }

    public /* synthetic */ OListItemGeneral(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OListItemGeneral(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11, 0, null, 12, null);
        c(r10, r11);
    }
}
