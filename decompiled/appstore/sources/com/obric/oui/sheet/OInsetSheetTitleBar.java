package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 q2\u00020\u0001:\u0002\u000brB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010$\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0014¢\u0006\u0004\b$\u0010%R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\"\u00105\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010@\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010;R\u0016\u0010B\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010;R\u0016\u0010D\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u00100R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010GR\"\u0010P\u001a\u00020I8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR*\u0010X\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR.\u0010^\u001a\u0004\u0018\u00010\u00122\b\u0010Q\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010\u0014R.\u0010b\u001a\u0004\u0018\u00010\u00122\b\u0010Q\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010Z\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010\u0014R.\u0010f\u001a\u0004\u0018\u00010\u00122\b\u0010Q\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010Z\u001a\u0004\bd\u0010\\\"\u0004\be\u0010\u0014R*\u0010n\u001a\u00020g2\u0006\u0010Q\u001a\u00020g8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0011\u0010p\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bo\u0010\u0017¨\u0006s"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "a", "(Landroid/content/Context;)V", "b", "(Landroid/util/AttributeSet;)V", "resId", "setCenterText", "(I)V", "", "title", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "c", "()V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "getMRightContainer", "setMRightContainer", "mRightContainer", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "d", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "e", "Landroid/widget/TextView;", "mCenterTitleView", "f", "mLeftTitleView", "g", "mFixedCenterTitleView", "h", "mFixedCenterSubTitleView", "i", "mDesContainerView", "Lcom/obric/oui/text/OTextView;", "j", "Lcom/obric/oui/text/OTextView;", "mDesTextView", "Lcom/obric/oui/button/OButton;", "k", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", CommonKey.KEY_VALUE, "l", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "m", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "subTitleText", "n", "getTitleText", "setTitleText", "titleText", "o", "getDesText", "setDesText", "desText", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "p", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;)V", "mTitlePosition", "getMTitleView", "mTitleView", "q", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInsetSheetTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f16798q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f16799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f16800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f16801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f16802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f16803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f16804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f16805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f16806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f16807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OTextView f16808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OButton f16809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f16810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f16811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f16812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f16813o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TitlePosition f16814p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public static final /* synthetic */ int[] f16815a = null;

        static {
            int[] r10 = new int[TitlePosition.values().length];
            r10[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r10[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r10[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f16815a = r10;
        }
    }

    static {
        f16798q = new a(null);
    }

    @JvmOverloads
    public OInsetSheetTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(Context r10) {
        FrameLayout.inflate(r10, R$layout.o_sheet_title_bar_container, this);
        View r11 = findViewById(R$id.center_title);
        q.f(r11, "findViewById(R.id.center_title)");
        this.f16803e = (TextView) r11;
        View r12 = findViewById(R$id.left_title);
        q.f(r12, "findViewById(R.id.left_title)");
        this.f16804f = (TextView) r12;
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
        this.f16805g = (TextView) r17;
        View r18 = findViewById(R$id.left_action_back);
        q.f(r18, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OButton) r18);
        View r19 = findViewById(R$id.fixed_center_sub_title);
        q.f(r19, "findViewById(R.id.fixed_center_sub_title)");
        this.f16806h = (TextView) r19;
        View r20 = findViewById(R$id.sheet_title_bar_des);
        q.f(r20, "findViewById(R.id.sheet_title_bar_des)");
        this.f16807i = (FrameLayout) r20;
        View r21 = findViewById(R$id.sheet_title_bar_des_text);
        q.f(r21, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r22 = (OTextView) r21;
        this.f16808j = r22;
        if (r22 != null) goto L5;
        q.y("mDesTextView");
        r22 = null;
    L5:
        r22.setEnableAutoAlignLeft(true);
    }

    public final void b(AttributeSet r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCTitleBar, 0, 0);
        int r12 = r11.getInt(R$styleable.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r12]);     // Catch: Throwable -> L6
        setTitleText(r11.getString(R$styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setDesText(r11.getString(R$styleable.OCTitleBar_oui_title_des_text));     // Catch: Throwable -> L6
        setShowLeftBack(r11.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r11.getString(R$styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r11.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public final void c() {
        getMTitleView().setTextSize(16.0f);
    }

    @Nullable
    public final String getDesText() {
        return this.f16813o;
    }

    @NotNull
    public final FrameLayout getMCenterContainer() {
        FrameLayout r10 = this.f16801c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mCenterContainer");
        return null;
    }

    @NotNull
    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r10 = this.f16802d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mFixedCenterContainer");
        return null;
    }

    @NotNull
    public final OButton getMLeftActionBack() {
        OButton r10 = this.f16809k;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mLeftActionBack");
        return null;
    }

    @NotNull
    public final LinearLayout getMLeftContainer() {
        LinearLayout r10 = this.f16799a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mLeftContainer");
        return null;
    }

    @NotNull
    public final LinearLayout getMRightContainer() {
        LinearLayout r10 = this.f16800b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mRightContainer");
        return null;
    }

    @NotNull
    public final TitlePosition getMTitlePosition() {
        return this.f16814p;
    }

    @NotNull
    public final TextView getMTitleView() {
        TitlePosition r10 = this.f16814p;
        int r11 = b.f16815a[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f16805g;
        if (r12 != null) goto L22;
        q.y("mFixedCenterTitleView");
        return null;
    L22:
        return r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = this.f16803e;
        if (r12 != null) goto L22;
        q.y("mCenterTitleView");
        return null;
    L7:
        if (r11 != 3) goto L13;
        r12 = this.f16804f;
        if (r12 != null) goto L22;
        q.y("mLeftTitleView");
        return null;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f16810l;
    }

    @Nullable
    public final String getSubTitleText() {
        return this.f16811m;
    }

    @Nullable
    public final String getTitleText() {
        return this.f16812n;
    }

    @NotNull
    public final TextView getTitleView() {
        return getMTitleView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setCenterText(int r10) {
        String r11 = getResources().getString(r10);
        q.f(r11, "resources.getString(resId)");
        setTitleText(r11);
    }

    public final void setDesText(@Nullable String r10) {
        this.f16813o = r10;
        FrameLayout r11 = null;
        OTextView r12 = null;
        if (r10 != null) goto L5;
    L15:
        FrameLayout r13 = this.f16807i;
        if (r13 != null) goto L18;
        q.y("mDesContainerView");
    L19:
        r11.setVisibility(8);
        return;
    L18:
        r11 = r13;
        goto L19
    L5:
        if (r10.length() == 0) goto L15;
        FrameLayout r14 = this.f16807i;
        if (r14 != null) goto L10;
        q.y("mDesContainerView");
        r14 = null;
    L10:
        r14.setVisibility(0);
        OTextView r15 = this.f16808j;
        if (r15 != null) goto L13;
        q.y("mDesTextView");
    L14:
        r12.setText(r10);
        return;
    L13:
        r12 = r15;
        goto L14
    }

    public final void setMCenterContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16801c = r10;
    }

    public final void setMFixedCenterContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16802d = r10;
    }

    public final void setMLeftActionBack(@NotNull OButton r10) {
        q.g(r10, "<set-?>");
        this.f16809k = r10;
    }

    public final void setMLeftContainer(@NotNull LinearLayout r10) {
        q.g(r10, "<set-?>");
        this.f16799a = r10;
    }

    public final void setMRightContainer(@NotNull LinearLayout r10) {
        q.g(r10, "<set-?>");
        this.f16800b = r10;
    }

    public final void setMTitlePosition(@NotNull TitlePosition r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.f16814p = r10;
        int r11 = b.f16815a[r10.ordinal()];
        TextView r12 = null;
        if (r11 != 1) goto L5;
        TextView r13 = this.f16805g;
        if (r13 != null) goto L34;
        q.y("mFixedCenterTitleView");
        r13 = null;
    L34:
        r13.setVisibility(0);
        TextView r14 = this.f16803e;
        if (r14 != null) goto L37;
        q.y("mCenterTitleView");
        r14 = null;
    L37:
        r14.setVisibility(8);
        TextView r15 = this.f16804f;
        if (r15 != null) goto L40;
        q.y("mLeftTitleView");
    L41:
        r12.setVisibility(8);
    L42:
        getMTitleView().setText(this.f16812n);
        return;
    L40:
        r12 = r15;
        goto L41
    L5:
        if (r11 != 2) goto L7;
        TextView r16 = this.f16805g;
        if (r16 != null) goto L23;
        q.y("mFixedCenterTitleView");
        r16 = null;
    L23:
        r16.setVisibility(8);
        TextView r17 = this.f16803e;
        if (r17 != null) goto L26;
        q.y("mCenterTitleView");
        r17 = null;
    L26:
        r17.setVisibility(0);
        TextView r18 = this.f16804f;
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
        TextView r19 = this.f16805g;
        if (r19 != null) goto L12;
        q.y("mFixedCenterTitleView");
        r19 = null;
    L12:
        r19.setVisibility(8);
        TextView r20 = this.f16803e;
        if (r20 != null) goto L15;
        q.y("mCenterTitleView");
        r20 = null;
    L15:
        r20.setVisibility(8);
        TextView r21 = this.f16804f;
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

    public final void setShowLeftBack(boolean r10) {
        this.f16810l = r10;
        OButton r11 = getMLeftActionBack();
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        if (this.f16814p != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void setSubTitleText(@Nullable String r10) {
        this.f16811m = r10;
        TextView r11 = null;
        if (r10 != null) goto L9;
        TextView r12 = this.f16806h;
        if (r12 != null) goto L7;
        q.y("mFixedCenterSubTitleView");
    L8:
        r11.setVisibility(8);
        return;
    L7:
        r11 = r12;
        goto L8
    L9:
        TextView r13 = this.f16806h;
        if (r13 != null) goto L12;
        q.y("mFixedCenterSubTitleView");
        r13 = null;
    L12:
        r13.setVisibility(0);
        TextView r14 = this.f16806h;
        if (r14 != null) goto L15;
        q.y("mFixedCenterSubTitleView");
    L16:
        r11.setText(r10);
        return;
    L15:
        r11 = r14;
        goto L16
    }

    public final void setTitleText(@Nullable String r10) {
        this.f16812n = r10;
        if (r10 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r10);
    }

    @JvmOverloads
    public OInsetSheetTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OInsetSheetTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
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
    public OInsetSheetTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16810l = true;
        this.f16814p = TitlePosition.FIXED_CENTER;
        a(r10);
        if (r11 == null) goto L6;
        b(r11);
        return;
    }
}
