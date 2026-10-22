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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u000eJ\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\fJ\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010)R\u0016\u0010-\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010,¨\u00063"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "insetBottom", "", "d", "(I)V", "getButtonCount", "()I", "", "Landroid/view/View;", "buttons", "setButtons", "(Ljava/util/List;)V", "getMaxButtonCount", "maxCount", "setMaxButtonCount", "headerView", "setHeaderView", "(Landroid/view/View;)V", "button", "", "isSingleButton", "b", "(Landroid/view/View;Z)V", "Lcom/obric/oui/divider/ODivider;", "a", "Lcom/obric/oui/divider/ODivider;", "divider", "Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "horizontalContainer", "Landroid/widget/FrameLayout;", "headerContainer", "e", "I", "buttonGap", "f", "maxButtons", "g", "defaultPaddingBottom", "h", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarNormalHorizontal extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f12249h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ODivider f12250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f12251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f12252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f12253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12256g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12249h = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomActionBarNormalHorizontal(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WindowInsets a(OBottomActionBarNormalHorizontal r10, View r11, WindowInsets r12) {
        return c(r10, r11, r12);
    }

    public static final WindowInsets c(OBottomActionBarNormalHorizontal r10, View r11, WindowInsets r12) {
        q.g(r10, "this$0");
        q.g(r11, "$noName_0");
        q.g(r12, "insets");
        r10.d(wd.a.i(r10, r12, true).f2559d);
        return r12;
    }

    public final void b(View r10, boolean r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L5;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r12.width, r12.height);
    L6:
        if (r11 == false) goto L8;
        r13.width = -1;
    L9:
        LinearLayout r14 = this.f12252c;
        if (r14.getChildCount() <= 0) goto L12;
        r13.leftMargin = this.f12254e;
    L12:
        Unit r15 = Unit.f21064a;
        r14.addView(r10, r13);
        return;
    L8:
        r13.width = 0;
        r13.weight = 1.0f;
        goto L9
    L5:
        r13 = new LinearLayout.LayoutParams(-1, -2);
        goto L6
    }

    public final void d(int r10) {
        View r11 = this.f12251b;
        r11.setPaddingRelative(r11.getPaddingLeft(), this.f12251b.getPaddingTop(), this.f12251b.getPaddingRight(), Math.max(r10, this.f12256g));
    }

    public final int getButtonCount() {
        return this.f12252c.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.f12255f;
    }

    public final void setButtons(@NotNull List<? extends View> r10) {
        q.g(r10, "buttons");
        if (r10.size() <= this.f12255f) goto L6;
        L.j("OBottomActionBarNormalHorizontal", "Cannot set more than " + this.f12255f + " buttons");
        return;
    L6:
        this.f12252c.removeAllViews();
        Iterator<T> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        View r12 = (View) r11.next();
        boolean r13 = true;
        if (r10.size() == 1) goto L13;
        r13 = false;
    L13:
        b(r12, r13);
        goto L8
    }

    public final void setHeaderView(@NotNull View r10) {
        q.g(r10, "headerView");
        this.f12253d.removeAllViews();
        this.f12253d.addView(r10);
        ViewGroup.LayoutParams r11 = this.f12252c.getLayoutParams();
        if (r11 == null) goto L7;
        int r12 = f.r(this, 8);
        ((ViewGroup.MarginLayoutParams) r11).topMargin = r12;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setMaxButtonCount(int r10) {
        if (this.f12252c.getChildCount() <= r10) goto L6;
        L.b("OBottomActionBarNormalHorizontal", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r10 <= 0) goto L8;
        this.f12255f = r10;
        return;
    L8:
        L.b("OBottomActionBarNormalHorizontal", "Max button count must be greater than 0");
    }

    @JvmOverloads
    public OBottomActionBarNormalHorizontal(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f12254e = f.r(this, 12);
        this.f12255f = 2;
        View.inflate(r10, R$layout.o_widget_bottom_action_bar_v2_normal_horizontal, this);
        View r12 = findViewById(R$id.bottom_action_bar_root);
        q.f(r12, "findViewById(R.id.bottom_action_bar_root)");
        this.f12251b = r12;
        this.f12256g = r12.getPaddingBottom();
        ODivider r13 = new ODivider(r10, null, 0, 6, null);
        this.f12250a = r13;
        addView(r13, new FrameLayout.LayoutParams(-1, f.p(this, 0.6d)));
        View r14 = findViewById(R$id.action_bar_horizontal_container);
        q.f(r14, "findViewById(R.id.action_bar_horizontal_container)");
        this.f12252c = (LinearLayout) r14;
        View r15 = findViewById(R$id.action_bar_header_container);
        q.f(r15, "findViewById(R.id.action_bar_header_container)");
        this.f12253d = (FrameLayout) r15;
        setClipChildren(false);
        setClipToPadding(false);
        int[] r16 = R$styleable.OBottomActionBar;
        q.f(r16, "OBottomActionBar");
        TypedArray r17 = r10.obtainStyledAttributes(r11, r16, 0, 0);
        q.f(r17, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r17.getBoolean(R$styleable.OBottomActionBar_oui_widgetFitInsetBottom, true) == false) goto L5;
        d(wd.a.i(this, null, true).f2559d);
        setOnApplyWindowInsetsListener(new com.obric.oui.actionbar.v2.a(this));
    L5:
        r17.recycle();
    }

    public /* synthetic */ OBottomActionBarNormalHorizontal(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }
}
