package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 {2\u00020\u0001:\u00026|B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u001e\u001a\u00020\n2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001e\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010\u0010J\u001f\u0010)\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0014¢\u0006\u0004\b)\u0010*J7\u00101\u001a\u00020\n2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0014¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u001fR\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u0002058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\"\u0010E\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010H\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010@\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\"\u0010N\u001a\u00020\u00118\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010OR\u0016\u0010Q\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010OR\u0016\u0010R\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010OR\u0016\u0010T\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010OR\"\u0010[\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R*\u0010f\u001a\u00020+2\u0006\u0010_\u001a\u00020+8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR.\u0010l\u001a\u0004\u0018\u00010 2\b\u0010_\u001a\u0004\u0018\u00010 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010\"R.\u0010p\u001a\u0004\u0018\u00010 2\b\u0010_\u001a\u0004\u0018\u00010 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010h\u001a\u0004\bn\u0010j\"\u0004\bo\u0010\"R*\u0010x\u001a\u00020q2\u0006\u0010_\u001a\u00020q8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0011\u0010z\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\by\u0010%¨\u0006}"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "e", "(Landroid/content/Context;)V", "f", "(Landroid/util/AttributeSet;)V", "g", "()V", "Landroid/view/ViewGroup;", "root", "Lcom/obric/oui/button/OButton;", "d", "(Landroid/content/Context;Landroid/view/ViewGroup;)Lcom/obric/oui/button/OButton;", "layoutResId", "c", "(Landroid/content/Context;Landroid/view/ViewGroup;I)Lcom/obric/oui/button/OButton;", "drawableId", "Landroid/widget/ImageView;", "b", "(I)Landroid/widget/ImageView;", "resId", "setCenterText", "(I)V", "", "title", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "h", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "minWidth", "setMinCenterTitleWidth", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "getMRightContainer", "setMRightContainer", "mRightContainer", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "Landroid/view/ViewGroup;", "getFixedCenterTitleContainer", "()Landroid/view/ViewGroup;", "setFixedCenterTitleContainer", "(Landroid/view/ViewGroup;)V", "fixedCenterTitleContainer", "Landroid/widget/TextView;", "mCenterTitleView", "mLeftTitleView", "mFixedCenterTitleView", "i", "mFixedCenterSubTitleView", "j", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "k", "I", "minCenterTitleWidth", CommonKey.KEY_VALUE, "l", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "m", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "subTitleText", "n", "getTitleText", "setTitleText", "titleText", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "o", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;)V", "mTitlePosition", "getMTitleView", "mTitleView", "p", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f17374p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f17375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f17376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f17377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f17378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f17379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f17380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f17381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f17382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f17383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OButton f17384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f17386l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f17387m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f17388n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TitlePosition f17389o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        private static final /* synthetic */ TitlePosition[] $values() {
            return new TitlePosition[]{FIXED_CENTER, FLOW_WITH_ACTION, LEFT_IN_ACTION};
        }

        static {
            FIXED_CENTER = new TitlePosition("FIXED_CENTER", 0, 0);
            FLOW_WITH_ACTION = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            LEFT_IN_ACTION = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            $VALUES = $values();
        }

        private TitlePosition(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static TitlePosition valueOf(String r10) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r10);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17390a = null;

        static {
            int[] r10 = new int[TitlePosition.values().length];
            r10[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r10[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r10[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f17390a = r10;
        }
    }

    static {
        f17374p = new a(null);
    }

    @JvmOverloads
    public OCTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OCTitleBar r10) {
        m28setMinCenterTitleWidth$lambda1(r10);
    }

    /* JADX INFO: renamed from: setMinCenterTitleWidth$lambda-1, reason: not valid java name */
    private static final void m28setMinCenterTitleWidth$lambda1(OCTitleBar r10) {
        q.g(r10, "this$0");
        r10.g();
    }

    public final ImageView b(int r10) {
        ImageView r11 = new ImageView(getContext());
        r11.setImageResource(r10);
        getMRightContainer().addView(r11);
        return r11;
    }

    public final OButton c(Context r10, ViewGroup r11, int r12) {
        q.g(r10, "context");
        q.g(r11, "root");
        int r13 = R$id.btn_titlebar;
        if (((OButton) r11.findViewById(r13)) != null) goto L5;
        View r14 = FrameLayout.inflate(r10, r12, r11).findViewById(r13);
        q.d(r14);
        return (OButton) r14;
    L5:
        View r15 = LayoutInflater.from(r10).inflate(r12, r11, false);
        if (r15 == null) goto L10;
        OButton r16 = (OButton) r15;
        r16.setId(-1);
        r11.addView(r16);
        return r16;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    }

    public final OButton d(Context r10, ViewGroup r11) {
        q.g(r10, "context");
        q.g(r11, "root");
        return c(r10, r11, R$layout.o_widget_titlebar_button_neutral);
    }

    public final void e(Context r10) {
        FrameLayout.inflate(r10, R$layout.o_title_bar_container, this);
        View r11 = findViewById(R$id.center_title);
        q.f(r11, "findViewById(R.id.center_title)");
        this.f17380f = (TextView) r11;
        View r12 = findViewById(R$id.left_title);
        q.f(r12, "findViewById(R.id.left_title)");
        this.f17381g = (TextView) r12;
        View r13 = findViewById(R$id.ll_left_action_container);
        q.f(r13, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) r13);
        View r14 = findViewById(R$id.ll_right_action_container);
        q.f(r14, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) r14);
        View r15 = findViewById(R$id.fl_center_action_container);
        q.f(r15, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) r15);
        View r16 = findViewById(R$id.fl_fixed_center_action_container);
        q.f(r16, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) r16);
        View r17 = findViewById(R$id.fixed_center_title);
        q.f(r17, "findViewById(R.id.fixed_center_title)");
        this.f17382h = (TextView) r17;
        View r18 = findViewById(R$id.left_action_back);
        q.f(r18, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OButton) r18);
        View r19 = findViewById(R$id.fixed_center_sub_title);
        q.f(r19, "findViewById(R.id.fixed_center_sub_title)");
        this.f17383i = (TextView) r19;
        View r20 = findViewById(R$id.fixed_center_title_container);
        q.f(r20, "findViewById(R.id.fixed_center_title_container)");
        setFixedCenterTitleContainer((ViewGroup) r20);
    }

    public final void f(AttributeSet r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCTitleBar, 0, 0);
        int r12 = r11.getInt(R$styleable.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r12]);     // Catch: Throwable -> L6
        setTitleText(r11.getString(R$styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setShowLeftBack(r11.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r11.getString(R$styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r11.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public final void g() {
        TitlePosition r10 = this.f17389o;
        TextView r11 = null;
        if (r10 != TitlePosition.LEFT_IN_ACTION) goto L10;
        TextView r12 = this.f17381g;
        if (r12 != null) goto L7;
        q.y("mLeftTitleView");
    L8:
        r11.requestLayout();
        return;
    L7:
        r11 = r12;
        goto L8
    L10:
        if (r10 != TitlePosition.FIXED_CENTER) goto L21;
        TextView r13 = this.f17382h;
        if (r13 != null) goto L14;
        q.y("mFixedCenterTitleView");
        r13 = null;
    L14:
        r13.requestLayout();
        TextView r14 = this.f17383i;
        if (r14 != null) goto L17;
        q.y("mFixedCenterSubTitleView");
    L18:
        r11.requestLayout();
        getMFixedCenterContainer().requestLayout();
        return;
    L17:
        r11 = r14;
        goto L18
    }

    @NotNull
    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r10 = this.f17379e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("fixedCenterTitleContainer");
        return null;
    }

    @NotNull
    public final FrameLayout getMCenterContainer() {
        FrameLayout r10 = this.f17377c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mCenterContainer");
        return null;
    }

    @NotNull
    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r10 = this.f17378d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mFixedCenterContainer");
        return null;
    }

    @NotNull
    public final OButton getMLeftActionBack() {
        OButton r10 = this.f17384j;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mLeftActionBack");
        return null;
    }

    @NotNull
    public final LinearLayout getMLeftContainer() {
        LinearLayout r10 = this.f17375a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mLeftContainer");
        return null;
    }

    @NotNull
    public final LinearLayout getMRightContainer() {
        LinearLayout r10 = this.f17376b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mRightContainer");
        return null;
    }

    @NotNull
    public final TitlePosition getMTitlePosition() {
        return this.f17389o;
    }

    @NotNull
    public final TextView getMTitleView() {
        TitlePosition r10 = this.f17389o;
        int r11 = b.f17390a[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f17382h;
        if (r12 != null) goto L22;
        q.y("mFixedCenterTitleView");
        return null;
    L22:
        return r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = this.f17380f;
        if (r12 != null) goto L22;
        q.y("mCenterTitleView");
        return null;
    L7:
        if (r11 != 3) goto L13;
        r12 = this.f17381g;
        if (r12 != null) goto L22;
        q.y("mLeftTitleView");
        return null;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f17386l;
    }

    @Nullable
    public final String getSubTitleText() {
        return this.f17387m;
    }

    @Nullable
    public final String getTitleText() {
        return this.f17388n;
    }

    @NotNull
    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final void h() {
        getMRightContainer().removeAllViews();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        TitlePosition r12 = this.f17389o;
        int r13 = 0;
        TextView r14 = null;
        if (r12 != TitlePosition.LEFT_IN_ACTION) goto L35;
        TextView r15 = this.f17381g;
        if (r15 != null) goto L7;
        q.y("mLeftTitleView");
        r15 = null;
    L7:
        int r16 = ((getMeasuredWidth() - getMRightContainer().getMeasuredWidth()) - getMLeftContainer().getPaddingLeft()) - getMLeftContainer().getPaddingRight();
        TextView r17 = this.f17381g;
        if (r17 != null) goto L10;
        q.y("mLeftTitleView");
        r17 = null;
    L10:
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r18 = null;
    L13:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L16;
        int r20 = r19.rightMargin;
    L17:
        int r21 = r16 - r20;
        TextView r22 = this.f17381g;
        if (r22 != null) goto L20;
        q.y("mLeftTitleView");
        r22 = null;
    L20:
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
        r23 = null;
    L23:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        if (r24 == null) goto L26;
        r13 = r24.rightMargin;
    L26:
        int r25 = r21 - r13;
        TextView r26 = this.f17381g;
        if (r26 != null) goto L29;
        q.y("mLeftTitleView");
        r26 = null;
    L29:
        int r27 = r25 - r26.getPaddingLeft();
        TextView r28 = this.f17381g;
        if (r28 != null) goto L32;
        q.y("mLeftTitleView");
    L33:
        r15.setMaxWidth(r27 - r14.getPaddingRight());
        return;
    L32:
        r14 = r28;
        goto L33
    L16:
        r20 = 0;
        goto L17
    L35:
        if (r12 == TitlePosition.FIXED_CENTER) goto L37;
        return;
    L37:
        if (getMLeftContainer().getVisibility() != 0) goto L46;
        int r29 = getMLeftContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r30 = getMLeftContainer().getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r30 = null;
    L41:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L44;
        int r32 = r31.leftMargin;
    L45:
        int r33 = r29 + r32;
    L48:
        if (getMRightContainer().getVisibility() != 0) goto L57;
        int r34 = getMRightContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r35 = getMRightContainer().getLayoutParams();
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r35 = null;
    L52:
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
        if (r36 == null) goto L55;
        int r37 = r36.rightMargin;
    L56:
        int r38 = r34 + r37;
    L58:
        int r39 = Math.max(r33, r38);
        if (getMFixedCenterContainer().getVisibility() != 0) goto L96;
        ViewGroup.LayoutParams r40 = getMFixedCenterContainer().getLayoutParams();
        if ((r40 instanceof ViewGroup.MarginLayoutParams) == true) goto L63;
        r40 = null;
    L63:
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) r40;
        if (r41 == null) goto L66;
        int r42 = r41.leftMargin;
    L67:
        ViewGroup.LayoutParams r43 = getMFixedCenterContainer().getLayoutParams();
        if ((r43 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r43 = null;
    L70:
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
        if (r44 == null) goto L73;
        r13 = r44.rightMargin;
    L73:
        int r45 = Math.max((getMeasuredWidth() - (r39 * 2)) - (r42 + r13), this.f17385k);
        TextView r46 = this.f17382h;
        if (r46 != null) goto L76;
        q.y("mFixedCenterTitleView");
        r46 = null;
    L76:
        TextView r47 = this.f17382h;
        if (r47 != null) goto L79;
        q.y("mFixedCenterTitleView");
        r47 = null;
    L79:
        int r48 = r47.getPaddingLeft() + r45;
        TextView r49 = this.f17382h;
        if (r49 != null) goto L82;
        q.y("mFixedCenterTitleView");
        r49 = null;
    L82:
        r46.setMaxWidth(r48 + r49.getPaddingRight());
        TextView r50 = this.f17383i;
        if (r50 != null) goto L85;
        q.y("mFixedCenterSubTitleView");
        r50 = null;
    L85:
        TextView r51 = this.f17383i;
        if (r51 != null) goto L88;
        q.y("mFixedCenterSubTitleView");
        r51 = null;
    L88:
        int r52 = r45 + r51.getPaddingLeft();
        TextView r53 = this.f17383i;
        if (r53 != null) goto L91;
        q.y("mFixedCenterSubTitleView");
    L92:
        r50.setMaxWidth(r52 + r14.getPaddingRight());
        return;
    L91:
        r14 = r53;
        goto L92
    L66:
        r42 = 0;
        goto L67
    L96:
        return;
    L55:
        r37 = 0;
        goto L56
    L57:
        r38 = 0;
        goto L58
    L44:
        r32 = 0;
        goto L45
    L46:
        r33 = 0;
        goto L48
    }

    public final void setCenterText(int r10) {
        String r11 = getResources().getString(r10);
        q.f(r11, "resources.getString(resId)");
        setTitleText(r11);
    }

    public final void setFixedCenterTitleContainer(@NotNull ViewGroup r10) {
        q.g(r10, "<set-?>");
        this.f17379e = r10;
    }

    public final void setMCenterContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f17377c = r10;
    }

    public final void setMFixedCenterContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f17378d = r10;
    }

    public final void setMLeftActionBack(@NotNull OButton r10) {
        q.g(r10, "<set-?>");
        this.f17384j = r10;
    }

    public final void setMLeftContainer(@NotNull LinearLayout r10) {
        q.g(r10, "<set-?>");
        this.f17375a = r10;
    }

    public final void setMRightContainer(@NotNull LinearLayout r10) {
        q.g(r10, "<set-?>");
        this.f17376b = r10;
    }

    public final void setMTitlePosition(@NotNull TitlePosition r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.f17389o = r10;
        int r11 = b.f17390a[r10.ordinal()];
        TextView r12 = null;
        if (r11 != 1) goto L5;
        TextView r13 = this.f17382h;
        if (r13 != null) goto L34;
        q.y("mFixedCenterTitleView");
        r13 = null;
    L34:
        r13.setVisibility(0);
        TextView r14 = this.f17380f;
        if (r14 != null) goto L37;
        q.y("mCenterTitleView");
        r14 = null;
    L37:
        r14.setVisibility(8);
        TextView r15 = this.f17381g;
        if (r15 != null) goto L40;
        q.y("mLeftTitleView");
    L41:
        r12.setVisibility(8);
    L42:
        getMTitleView().setText(this.f17388n);
        return;
    L40:
        r12 = r15;
        goto L41
    L5:
        if (r11 != 2) goto L7;
        TextView r16 = this.f17382h;
        if (r16 != null) goto L23;
        q.y("mFixedCenterTitleView");
        r16 = null;
    L23:
        r16.setVisibility(8);
        TextView r17 = this.f17380f;
        if (r17 != null) goto L26;
        q.y("mCenterTitleView");
        r17 = null;
    L26:
        r17.setVisibility(0);
        TextView r18 = this.f17381g;
        if (r18 != null) goto L29;
        q.y("mLeftTitleView");
    L30:
        r12.setVisibility(8);
        goto L42
    L29:
        r12 = r18;
        goto L30
    L7:
        if (r11 != 3) goto L42;
        TextView r19 = this.f17382h;
        if (r19 != null) goto L12;
        q.y("mFixedCenterTitleView");
        r19 = null;
    L12:
        r19.setVisibility(8);
        TextView r20 = this.f17380f;
        if (r20 != null) goto L15;
        q.y("mCenterTitleView");
        r20 = null;
    L15:
        r20.setVisibility(8);
        TextView r21 = this.f17381g;
        if (r21 != null) goto L18;
        q.y("mLeftTitleView");
    L19:
        r12.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r12 = r21;
        goto L19
    }

    public final void setMinCenterTitleWidth(int r10) {
        this.f17385k = f.r(this, r10);
        post(new com.obric.oui.titlebar.a(this));
    }

    public final void setShowLeftBack(boolean r10) {
        this.f17386l = r10;
        OButton r11 = getMLeftActionBack();
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        if (this.f17389o != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void setSubTitleText(@Nullable String r10) {
        this.f17387m = r10;
        TextView r11 = null;
        if (r10 != null) goto L9;
        TextView r12 = this.f17383i;
        if (r12 != null) goto L7;
        q.y("mFixedCenterSubTitleView");
    L8:
        r11.setVisibility(8);
        return;
    L7:
        r11 = r12;
        goto L8
    L9:
        TextView r13 = this.f17383i;
        if (r13 != null) goto L12;
        q.y("mFixedCenterSubTitleView");
        r13 = null;
    L12:
        r13.setVisibility(0);
        TextView r14 = this.f17383i;
        if (r14 != null) goto L15;
        q.y("mFixedCenterSubTitleView");
        r14 = null;
    L15:
        r14.setText(r10);
        if (getResources().getConfiguration().fontScale <= 1.0f) goto L25;
        TextView r15 = this.f17382h;
        if (r15 != null) goto L20;
        q.y("mFixedCenterTitleView");
        r15 = null;
    L20:
        r15.setTextSize(1, 16.0f);
        TextView r16 = this.f17383i;
        if (r16 != null) goto L23;
        q.y("mFixedCenterSubTitleView");
    L24:
        r11.setTextSize(1, 12.0f);
        goto L25
    L23:
        r11 = r16;
    L25:
        g();
    }

    public final void setTitleText(@Nullable String r10) {
        this.f17388n = r10;
        if (r10 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r10);
        g();
    }

    @JvmOverloads
    public OCTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
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

    public final void setCenterText(@NotNull String r10) {
        q.g(r10, "title");
        setTitleText(r10);
    }

    @JvmOverloads
    public OCTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17385k = f.r(this, 70);
        this.f17386l = true;
        this.f17389o = TitlePosition.FIXED_CENTER;
        e(r10);
        if (r11 == null) goto L6;
        f(r11);
        return;
    }
}
