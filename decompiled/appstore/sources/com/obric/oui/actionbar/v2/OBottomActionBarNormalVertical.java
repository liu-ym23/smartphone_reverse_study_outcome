package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.divider.ODivider;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u0001!B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u0012J\u0015\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u0010J\u0015\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010\u001aR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010*R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010-¨\u00064"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalVertical;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "insetBottom", "d", "(I)V", "getButtonCount", "()I", "", "Landroid/view/View;", "buttons", "setButtons", "(Ljava/util/List;)V", "button", "b", "(Landroid/view/View;)V", "getMaxButtonCount", "maxCount", "setMaxButtonCount", "headerView", "setHeaderView", "Lcom/obric/oui/divider/ODivider;", "a", "Lcom/obric/oui/divider/ODivider;", "divider", "Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "verticalContainer", "Landroid/widget/FrameLayout;", "headerContainer", "e", "I", "buttonGap", "f", "maxButtons", "g", "defaultPaddingBottom", "h", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarNormalVertical extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f12257h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ODivider f12258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f12259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f12260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f12261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12264g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12257h = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomActionBarNormalVertical(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WindowInsets a(OBottomActionBarNormalVertical r10, View r11, WindowInsets r12) {
        return c(r10, r11, r12);
    }

    public static final WindowInsets c(OBottomActionBarNormalVertical r10, View r11, WindowInsets r12) {
        q.g(r10, "this$0");
        q.g(r11, "$noName_0");
        q.g(r12, "insets");
        r10.d(wd.a.i(r10, r12, true).f2559d);
        return r12;
    }

    public final void b(View r10) {
        q.g(r10, "button");
        int r11 = this.f12260c.getChildCount();
        int r12 = this.f12263f;
        if (r11 < r12) goto L6;
        L.j("OBottomActionBarNormalVertical", q.p("Maximum number of buttons reached: ", Integer.valueOf(r12)));
        return;
    L6:
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L9;
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(r13.width, r13.height);
    L10:
        LinearLayout r15 = this.f12260c;
        if (r15.getChildCount() <= 0) goto L13;
        r14.topMargin = this.f12262e;
    L13:
        Unit r16 = Unit.f21064a;
        r15.addView(r10, r14);
        return;
    L9:
        r14 = new LinearLayout.LayoutParams(-1, -2);
        goto L10
    }

    public final void d(int r10) {
        View r11 = this.f12259b;
        r11.setPaddingRelative(r11.getPaddingLeft(), this.f12259b.getPaddingTop(), this.f12259b.getPaddingRight(), Math.max(r10, this.f12264g));
    }

    public final int getButtonCount() {
        return this.f12260c.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.f12263f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f12261d.getChildCount() <= 0) goto L19;
        int r12 = View.MeasureSpec.getSize(r11);
        int r13 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r10), Integer.MIN_VALUE);
        int r14 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f12260c.measure(r13, r14);
        int r15 = this.f12260c.getMeasuredHeight();
        int r16 = this.f12259b.getPaddingTop() + this.f12259b.getPaddingBottom();
        ViewGroup.LayoutParams r17 = this.f12260c.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
    L8:
        if (r18 != null) goto L10;
        int r19 = 0;
    L11:
        int r20 = Math.max(0, r12 - ((r16 + r19) + r15));
        this.f12261d.measure(r13, r14);
        int r21 = this.f12261d.getMeasuredHeight();
        ViewGroup.LayoutParams r22 = this.f12261d.getLayoutParams();
        if (r20 >= r21) goto L17;
        if (r22.height == r20) goto L19;
        r22.height = r20;
        this.f12261d.setLayoutParams(r22);
        goto L19
    L17:
        if (r22.height == (-2)) goto L19;
        r22.height = -2;
        this.f12261d.setLayoutParams(r22);
        goto L19
    L10:
        r19 = r18.topMargin;
        goto L11
    L7:
        r18 = null;
    L19:
        super.onMeasure(r10, r11);
    }

    public final void setButtons(@NotNull List<? extends View> r10) {
        q.g(r10, "buttons");
        this.f12260c.removeAllViews();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        b((View) r11.next());
        goto L4
    }

    public final void setHeaderView(@NotNull View r10) {
        q.g(r10, "headerView");
        this.f12261d.removeAllViews();
        this.f12261d.addView(r10);
        ViewGroup.LayoutParams r11 = this.f12260c.getLayoutParams();
        if (r11 == null) goto L7;
        int r12 = f.r(this, 8);
        ((ViewGroup.MarginLayoutParams) r11).topMargin = r12;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setMaxButtonCount(int r10) {
        if (this.f12260c.getChildCount() <= r10) goto L6;
        L.b("OBottomActionBarNormalVertical", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r10 <= 0) goto L8;
        this.f12263f = r10;
        return;
    L8:
        L.b("OBottomActionBarNormalVertical", "Max button count must be greater than 0");
    }

    @JvmOverloads
    public OBottomActionBarNormalVertical(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f12262e = f.r(this, 12);
        this.f12263f = 3;
        FrameLayout.inflate(r10, R$layout.o_widget_bottom_action_bar_v2_normal_vertical, this);
        View r12 = findViewById(R$id.bottom_action_bar_root);
        q.f(r12, "findViewById(R.id.bottom_action_bar_root)");
        this.f12259b = r12;
        this.f12264g = r12.getPaddingBottom();
        ODivider r13 = new ODivider(r10, null, 0, 6, null);
        this.f12258a = r13;
        addView(r13, new FrameLayout.LayoutParams(-1, f.p(this, 0.6d)));
        View r14 = findViewById(R$id.action_bar_vertical_container);
        q.f(r14, "findViewById(R.id.action_bar_vertical_container)");
        this.f12260c = (LinearLayout) r14;
        View r15 = findViewById(R$id.action_bar_header_container);
        q.f(r15, "findViewById(R.id.action_bar_header_container)");
        this.f12261d = (FrameLayout) r15;
        setClipChildren(false);
        setClipToPadding(false);
        int[] r16 = R$styleable.OBottomActionBar;
        q.f(r16, "OBottomActionBar");
        TypedArray r17 = r10.obtainStyledAttributes(r11, r16, 0, 0);
        q.f(r17, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r17.getBoolean(R$styleable.OBottomActionBar_oui_widgetFitInsetBottom, true) == false) goto L5;
        d(wd.a.i(this, null, true).f2559d);
        setOnApplyWindowInsetsListener(new b(this));
    L5:
        r17.recycle();
    }

    public /* synthetic */ OBottomActionBarNormalVertical(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }
}
