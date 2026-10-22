package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OBaseTextView;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sd.b;
import tc.f;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00112\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\fJ\u000f\u0010!\u001a\u00020 H\u0003¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0003¢\u0006\u0004\b#\u0010\"J\u000f\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0019H\u0002¢\u0006\u0004\b'\u0010\u001cJ\u001f\u0010*\u001a\u00020\u00062\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010(H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0010H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b/\u00100J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u00102J\u0015\u00103\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b3\u00100J/\u00107\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00062\b\b\u0002\u00106\u001a\u00020\u0006¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0014¢\u0006\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010D\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u00100R$\u0010G\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010@\u001a\u0004\bE\u0010B\"\u0004\bF\u00100R$\u0010J\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010@\u001a\u0004\bH\u0010B\"\u0004\bI\u00100R*\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010L\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR$\u0010[\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010`\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\\\u001a\u0004\b]\u0010\"\"\u0004\b^\u0010_R.\u0010f\u001a\u0004\u0018\u00010\u00192\b\u0010a\u001a\u0004\u0018\u00010\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010\u001cR$\u0010i\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\\\u001a\u0004\bg\u0010\"\"\u0004\bh\u0010_R.\u0010l\u001a\u0004\u0018\u00010\u00192\b\u0010a\u001a\u0004\u0018\u00010\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010b\u001a\u0004\bj\u0010d\"\u0004\bk\u0010\u001cR\u0014\u0010o\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010nR\u0014\u0010q\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\"R\u0014\u0010s\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010\"R\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00130K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010NR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00130K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010NR\u0011\u0010z\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0011\u0010|\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b{\u0010y¨\u0006}"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "b", "()V", "p", "l", "(Landroid/util/AttributeSet;)V", "", "m", "()Z", "Landroid/view/View;", "view", "Landroid/widget/RelativeLayout$LayoutParams;", "params", "q", "(Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V", "", "title", "setCenterText", "(Ljava/lang/String;)V", "setCenterSubText", "e", "o", "Landroid/widget/TextView;", "j", "()Landroid/widget/TextView;", "i", "h", "()Landroid/widget/RelativeLayout$LayoutParams;", "scene", "f", "", ServerElements.LIST, "k", "(Ljava/util/List;)I", "centerView", "g", "(Landroid/view/View;Z)Landroid/widget/RelativeLayout$LayoutParams;", "setCenterView", "(Landroid/view/View;)V", "resId", "(I)V", "c", "layoutParams", SlideCard.KEY_INDEX, "marginLeft", "d", "(Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;II)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "a", "Z", "autoAdjustTitleSpace", "Landroid/view/View;", "getMCenterView", "()Landroid/view/View;", "setMCenterView", "mCenterView", "getMLeftLastView", "setMLeftLastView", "mLeftLastView", "getMRightLastView", "setMRightLastView", "mRightLastView", "", "Ljava/util/List;", "getMLeftViewList", "()Ljava/util/List;", "setMLeftViewList", "(Ljava/util/List;)V", "mLeftViewList", "getMRightViewList", "setMRightViewList", "mRightViewList", "Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "Landroid/widget/TextView;", "getMTitleView", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", CommonKey.KEY_VALUE, "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "titleText", "getMSubTitleView", "setMSubTitleView", "mSubTitleView", "getSubTitleText", "setSubTitleText", "subTitleText", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayoutListener", "getSubtitleViewOrCreate", "subtitleViewOrCreate", "getTitleViewOrCreate", "titleViewOrCreate", "getRightViewListOrCreate", "rightViewListOrCreate", "getLeftViewListOrCreate", "leftViewListOrCreate", "getLeftViewCount", "()I", "leftViewCount", "getRightViewCount", "rightViewCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCTitleBar extends RelativeLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f17541m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f17542n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17543o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f17544p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f17546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f17547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f17548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f17549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f17550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OButton f17551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f17552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f17553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f17554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f17555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f17556l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f17541m = new a(null);
        f17542n = R$drawable.o_ic_titlebar_back;
        f17543o = R$color.oui_text_1;
        f17544p = R$color.oui_text_3b;
    }

    @JvmOverloads
    public OCTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OCTitleBar r10) {
        n(r10);
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.f17549e != null) goto L5;
        this.f17549e = new ArrayList();
    L5:
        List<View> r10 = this.f17549e;
        q.d(r10);
        return r10;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.f17550f != null) goto L5;
        this.f17550f = new ArrayList();
    L5:
        List<View> r10 = this.f17550f;
        q.d(r10);
        return r10;
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r10 = this.f17554j;
        if (r10 == null) goto L6;
        q.d(r10);
        return r10;
    L6:
        this.f17554j = i();
        ViewGroup.LayoutParams r11 = generateDefaultLayoutParams();
        if (r11 == null) goto L11;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.addRule(14);
        r12.topMargin = f.r(this, 30);
        addView(this.f17554j, r12);
        TextView r13 = this.f17554j;
        q.d(r13);
        return r13;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final TextView getTitleViewOrCreate() {
        View r10 = this.f17546b;
        if (r10 == null) goto L8;
        TextView r11 = this.f17552h;
        if (r10 != r11) goto L8;
        q.d(r11);
        return r11;
    L8:
        if (this.f17552h != null) goto L11;
        this.f17552h = j();
    L11:
        if (this.f17546b == null) goto L13;
        o();
    L13:
        addView(this.f17552h, h());
        TextView r12 = this.f17552h;
        this.f17546b = r12;
        q.d(r12);
        return r12;
    }

    public static final void n(OCTitleBar r10) {
        q.g(r10, "this$0");
        r10.p();
        if (r10.m() == true) goto L5;
        return;
    L5:
        r10.f("OnGlobalLayoutListener");
    }

    private final void setCenterSubText(String r10) {
        getSubtitleViewOrCreate().setText(r10);
        e();
    }

    public final void b() {
        getViewTreeObserver().addOnGlobalLayoutListener(this.f17556l);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        L.c("OCTitleBar", "addGlobalLayoutListener: ", e);
    }

    public final void c(View r10) {
        q.g(r10, "view");
        d(r10, g(r10, false), getLeftViewCount(), 0);
    }

    public final void d(View r10, RelativeLayout.LayoutParams r11, int r12, int r13) {
        q.g(r10, "view");
        q.g(r11, "layoutParams");
        r11.alignWithParent = true;
        r11.leftMargin = r13;
        r10.setId(View.generateViewId());
        if (this.f17547c != null) goto L5;
        r11.addRule(9);
        r12 = 0;
    L22:
        r11.addRule(15);
        List r14 = this.f17549e;
        if (r14 == null) goto L26;
        q.d(r14);
        if (r12 == r14.size()) goto L26;
    L27:
        getLeftViewListOrCreate().add(r12, r10);
        addView(r10, r11);
        return;
    L26:
        this.f17547c = r10;
        goto L27
    L5:
        if (r12 < 0) goto L21;
        List r15 = this.f17549e;
        q.d(r15);
        if (r12 >= r15.size()) goto L21;
        if (r12 != 0) goto L16;
        r11.addRule(9);
        List r16 = this.f17549e;
        q.d(r16);
        ViewGroup.LayoutParams r17 = ((View) r16.get(r12)).getLayoutParams();
        if (r17 == null) goto L15;
        RelativeLayout.LayoutParams r18 = (RelativeLayout.LayoutParams) r17;
        r18.removeRule(9);
        r18.addRule(1, r10.getId());
        goto L22
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L16:
        List r19 = this.f17549e;
        q.d(r19);
        View r20 = (View) r19.get(r12 - 1);
        List r21 = this.f17549e;
        q.d(r21);
        View r22 = (View) r21.get(r12);
        r11.addRule(1, r20.getId());
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L20;
        ((RelativeLayout.LayoutParams) r23).addRule(1, r10.getId());
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L21:
        List r24 = this.f17549e;
        q.d(r24);
        r12 = r24.size();
        View r25 = this.f17547c;
        q.d(r25);
        r11.addRule(1, r25.getId());
        goto L22
    }

    public final void e() {
        TextView r10 = this.f17552h;
        if (r10 != null) goto L6;
        return;
    L6:
        if (getMSubTitleView() == null) goto L21;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L20;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.removeRule(13);
        r12.addRule(14);
        r12.topMargin = f.r(this, 9);
        if (getContext().getResources().getConfiguration().fontScale <= 1.0f) goto L22;
        r12.topMargin = f.r(this, 6);
        TextView r13 = getMSubTitleView();
        if (r13 == null) goto L25;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L18;
        int r15 = f.r(this, 31);
        ((RelativeLayout.LayoutParams) r14).topMargin = r15;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L25:
        return;
    L22:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void f(String r10) {
        Rect r11 = new Rect();
        Rect r12 = new Rect();
        List r13 = this.f17549e;
        if (r13 == null) goto L9;
        Iterator r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        View r15 = (View) r14.next();
        Rect r16 = new Rect();
        r15.getGlobalVisibleRect(r16);
        r11.union(r16.left, r16.top, r16.right, r16.bottom);
    L9:
        List r17 = this.f17550f;
        if (r17 == null) goto L17;
        Iterator r18 = r17.iterator();
    L14:
        if (r18.hasNext() == false) goto L17;
        View r19 = (View) r18.next();
        Rect r20 = new Rect();
        r19.getGlobalVisibleRect(r20);
        r12.union(r20.left, r20.top, r20.right, r20.bottom);
    L17:
        if (r11.isEmpty() == false) goto L19;
        int r21 = 0;
    L20:
        int r22 = h.d(r21, 0);
        if (r12.isEmpty() == false) goto L23;
        int r23 = 0;
    L24:
        int r24 = h.d(r23, 0);
        int r25 = Math.max(r22, r24);
        L.a("OCTitleBar", "adjustTitleViewSpace, scene: " + r10 + ", leftSpace: " + r22 + ", rightSpace: " + r24 + ", leftViewRectF: " + r11 + ", rightViewRectF: " + r12 + ", width: " + getWidth() + ", height: " + getHeight());
        if (r25 <= 0) goto L55;
        c r26 = c.f24796a;
        TextView r27 = this.f17552h;
        ViewGroup.LayoutParams r28 = null;
        if (r27 != null) goto L29;
        ViewGroup.LayoutParams r29 = null;
    L30:
        if (r29 != null) goto L33;
    L31:
        r29 = null;
    L34:
        RelativeLayout.LayoutParams r30 = (RelativeLayout.LayoutParams) r29;
        if (r30 == null) goto L38;
        r30.leftMargin = r25;
        r30.rightMargin = r25;
    L38:
        TextView r31 = this.f17554j;
        if (r31 != null) goto L41;
        ViewGroup.LayoutParams r32 = null;
    L42:
        if (r32 != null) goto L45;
    L47:
        RelativeLayout.LayoutParams r33 = (RelativeLayout.LayoutParams) r28;
        if (r33 == null) goto L51;
        r33.leftMargin = r25;
        r33.rightMargin = r25;
    L51:
        requestLayout();
        return;
    L45:
        if ((r32 instanceof RelativeLayout.LayoutParams) == false) goto L47;
        r28 = r32;
        goto L47
    L41:
        r32 = r31.getLayoutParams();
        goto L42
    L33:
        if ((r29 instanceof RelativeLayout.LayoutParams) == false) goto L31;
    L29:
        r29 = r27.getLayoutParams();
        goto L30
    L55:
        return;
    L23:
        r23 = getWidth() - r12.left;
        goto L24
    L19:
        r21 = r11.right;
        goto L20
    }

    public final RelativeLayout.LayoutParams g(View r10, boolean r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof RelativeLayout.LayoutParams) == true) goto L13;
        if (r11 == false) goto L7;
        ViewGroup.LayoutParams r13 = h();
    L8:
        if (r13 == null) goto L12;
        return (RelativeLayout.LayoutParams) r13;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L7:
        r13 = generateDefaultLayoutParams();
        goto L8
    L13:
        return (RelativeLayout.LayoutParams) r12;
    }

    public final int getLeftViewCount() {
        return k(this.f17549e);
    }

    @Nullable
    public final View getMCenterView() {
        return this.f17546b;
    }

    @Nullable
    public final OButton getMLeftActionBack() {
        return this.f17551g;
    }

    @Nullable
    public final View getMLeftLastView() {
        return this.f17547c;
    }

    @Nullable
    public final List<View> getMLeftViewList() {
        return this.f17549e;
    }

    @Nullable
    public final View getMRightLastView() {
        return this.f17548d;
    }

    @Nullable
    public final List<View> getMRightViewList() {
        return this.f17550f;
    }

    @Nullable
    public final TextView getMSubTitleView() {
        return this.f17554j;
    }

    @Nullable
    public final TextView getMTitleView() {
        return this.f17552h;
    }

    public final int getRightViewCount() {
        return k(this.f17550f);
    }

    @Nullable
    public final String getSubTitleText() {
        return this.f17555k;
    }

    @Nullable
    public final String getTitleText() {
        return this.f17553i;
    }

    public final RelativeLayout.LayoutParams h() {
        ViewGroup.LayoutParams r10 = generateDefaultLayoutParams();
        if (r10 == null) goto L7;
        RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) r10;
        r11.addRule(13);
        return r11;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final TextView i() {
        Context r10 = getContext();
        q.f(r10, "context");
        OBaseTextView r11 = new OBaseTextView(r10, null, 0, 6, null);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setTextAppearance(R$style.Label_M);
        r11.setTextColor(r11.getContext().getResources().getColor(f17544p));
        return r11;
    }

    public final TextView j() {
        Context r10 = getContext();
        q.f(r10, "context");
        OBaseTextView r11 = new OBaseTextView(r10, null, 0, 6, null);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setTextAppearance(R$style.Title_Title_M_Thick);
        r11.setTextColor(r11.getContext().getResources().getColor(f17543o));
        return r11;
    }

    public final int k(List r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (r10.size() <= 0) goto L18;
        int r12 = r10.size();
        int r13 = 0;
    L7:
        if (r11 >= r12) goto L13;
        int r14 = r11 + 1;
        if (((View) r10.get(r11)).getVisibility() == 8) goto L11;
        r13 = r13 + 1;
    L11:
        r11 = r14;
        goto L7
    L13:
        return r13;
    L18:
        return 0;
    }

    public final void l(AttributeSet r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCTitleBar, 0, 0);
        int r12 = r11.getInt(R$styleable.OCTitleBar_oui_title_pos, com.obric.oui.titlebar.OCTitleBar.TitlePosition.FIXED_CENTER.getValue());
        com.obric.oui.titlebar.OCTitleBar.TitlePosition r13 = com.obric.oui.titlebar.OCTitleBar.TitlePosition.values()[r12];
        String r14 = r11.getString(R$styleable.OCTitleBar_oui_title_text);
        if (r14 == null) goto L6;
        setCenterText(r14);
    L6:
        if (r11.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true) == false) goto L8;
        Context r15 = getContext();
        q.f(r15, "context");
        OButton r16 = b.b(this, r15);
        r16.setButtonSourceBitmap(f17542n);
        setMLeftActionBack(r16);
        c(r16);
    L8:
        String r17 = r11.getString(R$styleable.OCTitleBar_oui_sub_title_text);
        if (r17 == null) goto L11;
        setCenterSubText(r17);
    L11:
        this.f17545a = r11.getBoolean(R$styleable.OCTitleBar_oui_autoAdjustTitleSpace, true);
        int r18 = (int) getContext().getResources().getDimension(R$dimen.oui_p_title_bar_default);
        setPadding(r18, 0, r18, 0);
    }

    public final boolean m() {
        return this.f17545a;
    }

    public final void o() {
        View r10 = this.f17546b;
        if (r10 == null) goto L6;
        removeView(r10);
        this.f17546b = null;
        return;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec((int) getContext().getResources().getDimension(R$dimen.oui_h_title_bar_window), Ints.MAX_POWER_OF_TWO));
    }

    public final void p() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f17556l);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        L.c("OCTitleBar", "removeGlobalLayoutListener: ", e);
    }

    public final void q(View r10, RelativeLayout.LayoutParams r11) {
        if (q.b(this.f17546b, r10) == false) goto L5;
        return;
    L5:
        o();
        this.f17546b = r10;
        addView(r10, r11);
    }

    public final void setCenterText(int r10) {
        setCenterText(getContext().getString(r10));
    }

    public final void setCenterView(@Nullable View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        q(r10, g(r10, true));
    }

    public final void setMCenterView(@Nullable View r10) {
        this.f17546b = r10;
    }

    public final void setMLeftActionBack(@Nullable OButton r10) {
        this.f17551g = r10;
    }

    public final void setMLeftLastView(@Nullable View r10) {
        this.f17547c = r10;
    }

    public final void setMLeftViewList(@Nullable List<View> r10) {
        this.f17549e = r10;
    }

    public final void setMRightLastView(@Nullable View r10) {
        this.f17548d = r10;
    }

    public final void setMRightViewList(@Nullable List<View> r10) {
        this.f17550f = r10;
    }

    public final void setMSubTitleView(@Nullable TextView r10) {
        this.f17554j = r10;
    }

    public final void setMTitleView(@Nullable TextView r10) {
        this.f17552h = r10;
    }

    public final void setSubTitleText(@Nullable String r10) {
        this.f17555k = r10;
        setCenterSubText(r10);
    }

    public final void setTitleText(@Nullable String r10) {
        this.f17553i = r10;
        setCenterText(r10);
    }

    @JvmOverloads
    public OCTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    private final void setCenterText(String r10) {
        getTitleViewOrCreate().setText(r10);
    }

    public /* synthetic */ OCTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OCTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17556l = new sd.a(this);
        if (r11 == null) goto L6;
        l(r11);
    L6:
        if (m() == false) goto L9;
        b();
        return;
    }
}
