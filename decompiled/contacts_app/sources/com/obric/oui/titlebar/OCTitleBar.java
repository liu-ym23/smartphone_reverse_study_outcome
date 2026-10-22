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
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OCTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\b\u0016\u0018\u0000 q2\u00020\u0001:\u0002qrB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u0016\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007J\u000e\u0010O\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u001e\u0010R\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u0007J\u0016\u0010U\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010V\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010W\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010X\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010Y\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0006\u0010Z\u001a\u00020\u0015J\u0010\u0010[\u001a\u00020I2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\\\u001a\u00020I2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J0\u0010]\u001a\u00020I2\u0006\u0010^\u001a\u0002062\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0014J\u0018\u0010c\u001a\u00020I2\u0006\u0010d\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u0007H\u0014J\u0006\u0010f\u001a\u00020IJ\b\u0010g\u001a\u00020IH\u0002J\u0006\u0010h\u001a\u00020IJ\u0006\u0010i\u001a\u00020IJ\u000e\u0010j\u001a\u00020I2\u0006\u0010k\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020I2\u0006\u0010l\u001a\u00020<J\u000e\u0010m\u001a\u00020I2\u0006\u0010n\u001a\u00020\u0007J\u0006\u0010o\u001a\u00020IJ\u0006\u0010p\u001a\u00020IR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R$\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00107\u001a\u0002062\u0006\u0010+\u001a\u000206@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R(\u0010=\u001a\u0004\u0018\u00010<2\b\u0010+\u001a\u0004\u0018\u00010<@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010B\u001a\u0004\u0018\u00010<2\b\u0010+\u001a\u0004\u0018\u00010<@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010A¨\u0006s"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fixedCenterTitleContainer", "Landroid/view/ViewGroup;", "getFixedCenterTitleContainer", "()Landroid/view/ViewGroup;", "setFixedCenterTitleContainer", "(Landroid/view/ViewGroup;)V", "mCenterContainer", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterTitleView", "Landroid/widget/TextView;", "mFixedCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterSubTitleView", "mFixedCenterTitleView", "mLeftActionBack", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftContainer", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftTitleView", "mRightContainer", "getMRightContainer", "setMRightContainer", "value", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "mTitlePosition", "getMTitlePosition", "()Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "minCenterTitleWidth", "", "showLeftBack", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "", "subTitleText", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "titleText", "getTitleText", "setTitleText", "addLeftImageView", "Landroid/widget/ImageView;", "drawableId", "addLeftView", "", "view", "Landroid/view/View;", "addRightButton", "style", "stringId", "addRightImageView", "addRightTransButton", "addRightView", "createButton", "root", "layoutResId", "createNeutralButton", "createPrimaryButton", "createPrimaryLightButton", "createTransButton", "createTransIconButton", "getTitleView", "init", "initAttrs", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshTitleView", "refreshTitleViewIfNeeded", "removeAllLeftViews", "removeAllRightViews", "setCenterText", "resId", "title", "setMinCenterTitleWidth", "minWidth", "startTitleMarquee", "stopTitleMarquee", "Companion", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCTitleBar extends FrameLayout {
    public static final Companion Companion = null;
    public static final int STYLE_HIGHLIGHT_BLUE = 1;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_PRIMARY_BLUE = 2;
    private static final String TAG = "OCTitleBarLegacy";
    public ViewGroup fixedCenterTitleContainer;
    public FrameLayout mCenterContainer;
    private TextView mCenterTitleView;
    public FrameLayout mFixedCenterContainer;
    private TextView mFixedCenterSubTitleView;
    private TextView mFixedCenterTitleView;
    public OButton mLeftActionBack;
    public LinearLayout mLeftContainer;
    private TextView mLeftTitleView;
    public LinearLayout mRightContainer;
    private TitlePosition mTitlePosition;
    private int minCenterTitleWidth;
    private boolean showLeftBack;
    private String subTitleText;
    private String titleText;

    /* JADX INFO: compiled from: OCTitleBar.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$Companion;", "", "()V", "STYLE_HIGHLIGHT_BLUE", "", "STYLE_NORMAL", "STYLE_PRIMARY_BLUE", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OCTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        private static final /* synthetic */ TitlePosition[] $values() {
            return new TitlePosition[]{FIXED_CENTER, FLOW_WITH_ACTION, LEFT_IN_ACTION};
        }

        public static TitlePosition valueOf(String r1) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r1);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) $VALUES.clone();
        }

        private TitlePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            FIXED_CENTER = new TitlePosition("FIXED_CENTER", 0, 0);
            FLOW_WITH_ACTION = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            LEFT_IN_ACTION = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OCTitleBar.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TitlePosition.values().length];
            r0[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r0[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r0[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-Pk24BIuKqRC_mXJCv2Ml0bgcfM, reason: not valid java name */
    public static /* synthetic */ void m728$r8$lambda$Pk24BIuKqRC_mXJCv2Ml0bgcfM(OCTitleBar r0) {
        m731setMinCenterTitleWidth$lambda1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$AsmVlZ-ppY0J1GApugPaAc-zCX4, reason: not valid java name */
    public static /* synthetic */ void m729$r8$lambda$AsmVlZppY0J1GApugPaAczCX4(OCTitleBar r0) {
        m730refreshTitleView$lambda2(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OCTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OCTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OCTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OCTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.minCenterTitleWidth = OUnitExtensionKt.vdp(this, 70);
        this.showLeftBack = true;
        this.mTitlePosition = TitlePosition.FIXED_CENTER;
        init(r2);
        if (r3 == null) goto L6;
        initAttrs(r3);
        return;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.mLeftContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftContainer = r2;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r0 = this.mRightContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final void setMRightContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mRightContainer = r2;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r0 = this.mCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final void setMCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCenterContainer = r2;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r0 = this.mFixedCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final void setMFixedCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFixedCenterContainer = r2;
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r0 = this.fixedCenterTitleContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fixedCenterTitleContainer");
        return null;
    }

    public final void setFixedCenterTitleContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fixedCenterTitleContainer = r2;
    }

    public final OButton getMLeftActionBack() {
        OButton r0 = this.mLeftActionBack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final void setMLeftActionBack(OButton r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftActionBack = r2;
    }

    public final boolean getShowLeftBack() {
        return this.showLeftBack;
    }

    public final void setShowLeftBack(boolean r3) {
        this.showLeftBack = r3;
        OButton r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.mTitlePosition != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final String getSubTitleText() {
        return this.subTitleText;
    }

    public final void setSubTitleText(String r5) {
        this.subTitleText = r5;
        TextView r1 = null;
        if (r5 != null) goto L9;
        TextView r4 = this.mFixedCenterSubTitleView;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r1.setVisibility(8);
        return;
    L7:
        r1 = r4;
        goto L8
    L9:
        TextView r2 = this.mFixedCenterSubTitleView;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r3 = this.mFixedCenterSubTitleView;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r3 = null;
    L15:
        r3.setText(r5);
        if (getResources().getConfiguration().fontScale <= 1.0f) goto L25;
        TextView r6 = this.mFixedCenterTitleView;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r6 = null;
    L20:
        r6.setTextSize(1, 16.0f);
        TextView r7 = this.mFixedCenterSubTitleView;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L24:
        r1.setTextSize(1, 12.0f);
        goto L25
    L23:
        r1 = r7;
    L25:
        refreshTitleViewIfNeeded();
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r3) {
        this.titleText = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r3);
        refreshTitleViewIfNeeded();
    }

    public final TextView getMTitleView() {
        TitlePosition r0 = this.mTitlePosition;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r3 = this.mFixedCenterTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L20:
        return r3;
    L5:
        if (r1 != 2) goto L7;
        r3 = this.mCenterTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r1 != 3) goto L12;
        r3 = this.mLeftTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final TitlePosition getMTitlePosition() {
        return this.mTitlePosition;
    }

    public final void setMTitlePosition(TitlePosition r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        this.mTitlePosition = r8;
        int r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        TextView r6 = null;
        if (r9 != 1) goto L5;
        TextView r10 = this.mFixedCenterTitleView;
        if (r10 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r10 = null;
    L34:
        r10.setVisibility(0);
        TextView r11 = this.mCenterTitleView;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r11 = null;
    L37:
        r11.setVisibility(8);
        TextView r12 = this.mLeftTitleView;
        if (r12 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r6.setVisibility(8);
    L42:
        getMTitleView().setText(this.titleText);
        return;
    L40:
        r6 = r12;
        goto L41
    L5:
        if (r9 != 2) goto L7;
        TextView r13 = this.mFixedCenterTitleView;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L23:
        r13.setVisibility(8);
        TextView r14 = this.mCenterTitleView;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L26:
        r14.setVisibility(0);
        TextView r15 = this.mLeftTitleView;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L30:
        r6.setVisibility(8);
        goto L42
    L29:
        r6 = r15;
        goto L30
    L7:
        if (r9 != 3) goto L42;
        TextView r16 = this.mFixedCenterTitleView;
        if (r16 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L12:
        r16.setVisibility(8);
        TextView r17 = this.mCenterTitleView;
        if (r17 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r17 = null;
    L15:
        r17.setVisibility(8);
        TextView r18 = this.mLeftTitleView;
        if (r18 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r6.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r6 = r18;
        goto L19
    }

    private final void init(Context r3) {
        FrameLayout.inflate(r3, R.layout.o_title_bar_container, this);
        View r4 = findViewById(R.id.center_title);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.center_title)");
        this.mCenterTitleView = (TextView) r4;
        View r5 = findViewById(R.id.left_title);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.left_title)");
        this.mLeftTitleView = (TextView) r5;
        View r6 = findViewById(R.id.ll_left_action_container);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) r6);
        View r7 = findViewById(R.id.ll_right_action_container);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) r7);
        View r8 = findViewById(R.id.fl_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) r8);
        View r9 = findViewById(R.id.fl_fixed_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) r9);
        View r10 = findViewById(R.id.fixed_center_title);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.fixed_center_title)");
        this.mFixedCenterTitleView = (TextView) r10;
        View r11 = findViewById(R.id.left_action_back);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OButton) r11);
        View r12 = findViewById(R.id.fixed_center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.fixed_center_sub_title)");
        this.mFixedCenterSubTitleView = (TextView) r12;
        View r13 = findViewById(R.id.fixed_center_title_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.fixed_center_title_container)");
        setFixedCenterTitleContainer((ViewGroup) r13);
    }

    private final void initAttrs(AttributeSet r4) {
        TypedArray r5 = getContext().getTheme().obtainStyledAttributes(r4, R.styleable.OCTitleBar, 0, 0);
        int r0 = r5.getInt(R.styleable.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r0]);     // Catch: Throwable -> L6
        setTitleText(r5.getString(R.styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setShowLeftBack(r5.getBoolean(R.styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r5.getString(R.styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r5.recycle();
        return;
    L6:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    public final OButton createNeutralButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_button_neutral);
    }

    public final OButton createPrimaryLightButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_primarylight_button);
    }

    public final OButton createTransButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_trans_button);
    }

    public final OButton createTransIconButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_trans_icon_button);
    }

    public final OButton createPrimaryButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_primary_button);
    }

    public final OButton createButton(Context r1, ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        if (((OButton) r2.findViewById(R.id.btn_titlebar)) != null) goto L5;
        View r0 = FrameLayout.inflate(r1, r3, r2).findViewById(R.id.btn_titlebar);
        Intrinsics.checkNotNull(r0);
        return (OButton) r0;
    L5:
        View r4 = LayoutInflater.from(r1).inflate(r3, r2, false);
        if (r4 == null) goto L10;
        OButton r5 = (OButton) r4;
        r5.setId(-1);
        r2.addView(r5);
        return r5;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    }

    public final ImageView addLeftImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        getMLeftContainer().addView(r0);
        return r0;
    }

    public final ImageView addRightImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        getMRightContainer().addView(r0);
        return r0;
    }

    public final OButton addRightButton(int r3, int r4) {
        if (r3 != 0) goto L5;
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        OButton r2 = createNeutralButton(r5, getMRightContainer());
    L12:
        r2.setText(r4);
        return r2;
    L5:
        if (r3 != 1) goto L7;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        r2 = createPrimaryLightButton(r6, getMRightContainer());
        goto L12
    L7:
        if (r3 == 2) goto L9;
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r2 = createPrimaryLightButton(r7, getMRightContainer());
        goto L12
    L9:
        Context r8 = getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        r2 = createPrimaryButton(r8, getMRightContainer());
        goto L12
    }

    public final OButton addRightTransButton(int r3) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        OButton r2 = createTransButton(r0, getMRightContainer());
        r2.setButtonSourceBitmap(r3);
        return r2;
    }

    public final void setCenterText(int r2) {
        String r3 = getResources().getString(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setCenterText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        setTitleText(r2);
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final void removeAllLeftViews() {
        getMLeftContainer().removeAllViews();
    }

    public final void addLeftView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        getMLeftContainer().addView(r2);
    }

    public final void addRightView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        getMRightContainer().addView(r2);
    }

    public final void removeAllRightViews() {
        getMRightContainer().removeAllViews();
    }

    public final void startTitleMarquee() {
        ViewUtil r0 = ViewUtil.INSTANCE;
        TextView r1 = this.mFixedCenterTitleView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r1 = null;
    L5:
        r0.forceStartMarquee$OUI_standardRelease(r1);
    }

    public final void stopTitleMarquee() {
        ViewUtil r0 = ViewUtil.INSTANCE;
        TextView r1 = this.mFixedCenterTitleView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r1 = null;
    L5:
        r0.forceStopMarquee$OUI_standardRelease(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        int r0 = 0;
        TextView r1 = null;
        if (this.mTitlePosition != TitlePosition.LEFT_IN_ACTION) goto L35;
        TextView r8 = this.mLeftTitleView;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r8 = null;
    L7:
        int r2 = ((getMeasuredWidth() - getMRightContainer().getMeasuredWidth()) - getMLeftContainer().getPaddingLeft()) - getMLeftContainer().getPaddingRight();
        TextView r3 = this.mLeftTitleView;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r3 = null;
    L10:
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r4 = null;
    L13:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L16;
        int r9 = r5.rightMargin;
    L17:
        int r10 = r2 - r9;
        TextView r11 = this.mLeftTitleView;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r11 = null;
    L20:
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
        r12 = null;
    L23:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 == null) goto L26;
        r0 = r13.rightMargin;
    L26:
        int r14 = r10 - r0;
        TextView r15 = this.mLeftTitleView;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r15 = null;
    L29:
        int r16 = r14 - r15.getPaddingLeft();
        TextView r17 = this.mLeftTitleView;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L33:
        r8.setMaxWidth(r16 - r1.getPaddingRight());
        return;
    L32:
        r1 = r17;
        goto L33
    L16:
        r9 = 0;
        goto L17
    L35:
        if (this.mTitlePosition == TitlePosition.FIXED_CENTER) goto L37;
        return;
    L37:
        if (getMLeftContainer().getVisibility() != 0) goto L46;
        int r18 = getMLeftContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r19 = getMLeftContainer().getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r19 = null;
    L41:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        if (r20 == null) goto L44;
        int r21 = r20.leftMargin;
    L45:
        int r22 = r18 + r21;
    L48:
        if (getMRightContainer().getVisibility() != 0) goto L57;
        int r23 = getMRightContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r24 = getMRightContainer().getLayoutParams();
        if ((r24 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r24 = null;
    L52:
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
        if (r25 == null) goto L55;
        int r26 = r25.rightMargin;
    L56:
        int r27 = r23 + r26;
    L58:
        int r28 = Math.max(r22, r27);
        if (getMFixedCenterContainer().getVisibility() != 0) goto L96;
        ViewGroup.LayoutParams r29 = getMFixedCenterContainer().getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == true) goto L63;
        r29 = null;
    L63:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
        if (r30 == null) goto L66;
        int r31 = r30.leftMargin;
    L67:
        ViewGroup.LayoutParams r32 = getMFixedCenterContainer().getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r32 = null;
    L70:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        if (r33 == null) goto L73;
        r0 = r33.rightMargin;
    L73:
        int r34 = Math.max((getMeasuredWidth() - (r28 * 2)) - (r31 + r0), this.minCenterTitleWidth);
        TextView r35 = this.mFixedCenterTitleView;
        if (r35 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r35 = null;
    L76:
        TextView r36 = this.mFixedCenterTitleView;
        if (r36 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r36 = null;
    L79:
        int r37 = r36.getPaddingLeft() + r34;
        TextView r38 = this.mFixedCenterTitleView;
        if (r38 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r38 = null;
    L82:
        r35.setMaxWidth(r37 + r38.getPaddingRight());
        TextView r39 = this.mFixedCenterSubTitleView;
        if (r39 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r39 = null;
    L85:
        TextView r40 = this.mFixedCenterSubTitleView;
        if (r40 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r40 = null;
    L88:
        int r41 = r34 + r40.getPaddingLeft();
        TextView r42 = this.mFixedCenterSubTitleView;
        if (r42 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L92:
        r39.setMaxWidth(r41 + r1.getPaddingRight());
        return;
    L91:
        r1 = r42;
        goto L92
    L66:
        r31 = 0;
        goto L67
    L96:
        return;
    L55:
        r26 = 0;
        goto L56
    L57:
        r27 = 0;
        goto L58
    L44:
        r21 = 0;
        goto L45
    L46:
        r22 = 0;
        goto L48
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    private final void refreshTitleViewIfNeeded() {
        TextView r2 = null;
        if (this.mTitlePosition != TitlePosition.LEFT_IN_ACTION) goto L10;
        TextView r3 = this.mLeftTitleView;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L8:
        r2.requestLayout();
        return;
    L7:
        r2 = r3;
        goto L8
    L10:
        if (this.mTitlePosition != TitlePosition.FIXED_CENTER) goto L21;
        TextView r0 = this.mFixedCenterTitleView;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r0 = null;
    L14:
        r0.requestLayout();
        TextView r1 = this.mFixedCenterSubTitleView;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L18:
        r2.requestLayout();
        getMFixedCenterContainer().requestLayout();
        return;
    L17:
        r2 = r1;
        goto L18
    }

    public final void setMinCenterTitleWidth(int r2) {
        this.minCenterTitleWidth = OUnitExtensionKt.vdp(this, r2);
        post(new OCTitleBar$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: setMinCenterTitleWidth$lambda-1, reason: not valid java name */
    private static final void m731setMinCenterTitleWidth$lambda1(OCTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.refreshTitleViewIfNeeded();
    }

    public final void refreshTitleView() {
        post(new OCTitleBar$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: refreshTitleView$lambda-2, reason: not valid java name */
    private static final void m730refreshTitleView$lambda2(OCTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.refreshTitleViewIfNeeded();
    }
}
