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
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.text.OBaseTextView;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OCTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0019\u0018\u0000 v2\u00020\u0001:\u0001vB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010H\u001a\u00020IH\u0002J\u000e\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u0010J(\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020\u0007J\u0016\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u0007J\u001e\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020I2\u0006\u0010K\u001a\u00020\u0010J(\u0010P\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00072\b\b\u0002\u0010Q\u001a\u00020\u0007J\b\u0010R\u001a\u00020IH\u0002J\u0010\u0010S\u001a\u00020I2\u0006\u0010T\u001a\u00020;H\u0002J\u0018\u0010U\u001a\u00020M2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\nH\u0002J\b\u0010W\u001a\u00020MH\u0002J\b\u0010X\u001a\u00020,H\u0003J\b\u0010Y\u001a\u00020,H\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u0007J\u0010\u0010[\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u0007J\"\u0010\\\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u00072\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^H\u0002J\u0018\u0010_\u001a\u00020\u00072\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^H\u0002J\u0006\u0010`\u001a\u00020\nJ\u0006\u0010a\u001a\u00020\nJ\u0018\u0010b\u001a\u00020\n2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^H\u0002J\u0006\u0010c\u001a\u00020IJ\u0006\u0010d\u001a\u00020IJ\u0010\u0010e\u001a\u00020I2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010f\u001a\u00020\nH\u0002J\u0018\u0010g\u001a\u00020I2\u0006\u0010h\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u0007H\u0014J\u0006\u0010j\u001a\u00020IJ\u0006\u0010k\u001a\u00020IJ\b\u0010l\u001a\u00020IH\u0002J\b\u0010m\u001a\u00020IH\u0002J\u000e\u0010n\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0007J\u000e\u0010o\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0007J\u0012\u0010p\u001a\u00020I2\b\u0010q\u001a\u0004\u0018\u00010;H\u0002J\u000e\u0010r\u001a\u00020I2\u0006\u0010s\u001a\u00020\u0007J\u0012\u0010r\u001a\u00020I2\b\u0010q\u001a\u0004\u0018\u00010;H\u0002J\u0018\u0010t\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010t\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b7\u0010\rR\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0012R(\u0010<\u001a\u0004\u0018\u00010;2\b\u0010:\u001a\u0004\u0018\u00010;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010.R(\u0010C\u001a\u0004\u0018\u00010;2\b\u0010:\u001a\u0004\u0018\u00010;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010>\"\u0004\bE\u0010@R\u0014\u0010F\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010.¨\u0006w"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoAdjustTitleSpace", "", "leftViewCount", "getLeftViewCount", "()I", "leftViewListOrCreate", "", "Landroid/view/View;", "getLeftViewListOrCreate", "()Ljava/util/List;", "mCenterView", "getMCenterView", "()Landroid/view/View;", "setMCenterView", "(Landroid/view/View;)V", "mLeftActionBack", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftLastView", "getMLeftLastView", "setMLeftLastView", "mLeftViewList", "getMLeftViewList", "setMLeftViewList", "(Ljava/util/List;)V", "mRightLastView", "getMRightLastView", "setMRightLastView", "mRightViewList", "getMRightViewList", "setMRightViewList", "mSubTitleView", "Landroid/widget/TextView;", "getMSubTitleView", "()Landroid/widget/TextView;", "setMSubTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "getMTitleView", "setMTitleView", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "rightViewCount", "getRightViewCount", "rightViewListOrCreate", "getRightViewListOrCreate", "value", "", "subTitleText", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subtitleViewOrCreate", "getSubtitleViewOrCreate", "titleText", "getTitleText", "setTitleText", "titleViewOrCreate", "getTitleViewOrCreate", "addGlobalLayoutListener", "", "addLeftView", "view", "layoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "index", "marginLeft", "addRightView", "marginRight", "adjustTitlePosition", "adjustTitleViewSpace", "scene", "findLayoutParams", "centerView", "generateCenterViewLayoutParams", "generateSubTitleView", "generateTitleView", "getLeftViewByIndex", "getRightViewByIndex", "getViewByIndex", "list", "", "getViewCount", "hasLeftView", "hasRightView", "hasView", "hideAllLeftView", "hideAllRightView", "initAttrs", "isNeedListenGlobalLayout", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeAllLeftViews", "removeAllRightViews", "removeCenterView", "removeGlobalLayoutListener", "removeLeftView", "removeRightView", "setCenterSubText", "title", "setCenterText", "resId", "setCenterView", "params", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCTitleBar extends RelativeLayout {
    private static final int BACK_ICON_RES = 0;
    public static final Companion Companion = null;
    private static final int SUB_TITLE_TEXT_COLOR = 0;
    public static final float SUB_TITLE_TEXT_SIZE = 12.5f;
    private static final String TAG = "OCTitleBar";
    private static final int TITLE_TEXT_COLOR = 0;
    public static final float TITLE_TEXT_SIZE = 16.0f;
    private boolean autoAdjustTitleSpace;
    private View mCenterView;
    private OButton mLeftActionBack;
    private View mLeftLastView;
    private List<View> mLeftViewList;
    private View mRightLastView;
    private List<View> mRightViewList;
    private TextView mSubTitleView;
    private TextView mTitleView;
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private String subTitleText;
    private String titleText;

    /* JADX INFO: compiled from: OCTitleBar.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar$Companion;", "", "()V", "BACK_ICON_RES", "", "getBACK_ICON_RES", "()I", "SUB_TITLE_TEXT_COLOR", "getSUB_TITLE_TEXT_COLOR", "SUB_TITLE_TEXT_SIZE", "", "TAG", "", "TITLE_TEXT_COLOR", "getTITLE_TEXT_COLOR", "TITLE_TEXT_SIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getBACK_ICON_RES() {
            return OCTitleBar.access$getBACK_ICON_RES$cp();
        }

        public final int getTITLE_TEXT_COLOR() {
            return OCTitleBar.access$getTITLE_TEXT_COLOR$cp();
        }

        public final int getSUB_TITLE_TEXT_COLOR() {
            return OCTitleBar.access$getSUB_TITLE_TEXT_COLOR$cp();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$oNtyMbcjyTrgLFSJN-wlYJawg1M, reason: not valid java name */
    public static /* synthetic */ void m735$r8$lambda$oNtyMbcjyTrgLFSJNwlYJawg1M(OCTitleBar r0) {
        m736onGlobalLayoutListener$lambda0(r0);
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

    public static final /* synthetic */ int access$getBACK_ICON_RES$cp() {
        return BACK_ICON_RES;
    }

    public static final /* synthetic */ int access$getSUB_TITLE_TEXT_COLOR$cp() {
        return SUB_TITLE_TEXT_COLOR;
    }

    public static final /* synthetic */ int access$getTITLE_TEXT_COLOR$cp() {
        return TITLE_TEXT_COLOR;
    }

    public OCTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.onGlobalLayoutListener = new OCTitleBar$$ExternalSyntheticLambda0(this);
        if (r3 == null) goto L6;
        initAttrs(r3);
    L6:
        if (isNeedListenGlobalLayout() == false) goto L9;
        addGlobalLayoutListener();
        return;
    }

    static {
        Companion = new Companion(null);
        BACK_ICON_RES = R.drawable.o_ic_titlebar_back;
        TITLE_TEXT_COLOR = R.color.oui_text_1;
        SUB_TITLE_TEXT_COLOR = R.color.oui_text_3b;
    }

    public final View getMCenterView() {
        return this.mCenterView;
    }

    public final void setMCenterView(View r1) {
        this.mCenterView = r1;
    }

    public final View getMLeftLastView() {
        return this.mLeftLastView;
    }

    public final void setMLeftLastView(View r1) {
        this.mLeftLastView = r1;
    }

    public final View getMRightLastView() {
        return this.mRightLastView;
    }

    public final void setMRightLastView(View r1) {
        this.mRightLastView = r1;
    }

    public final List<View> getMLeftViewList() {
        return this.mLeftViewList;
    }

    public final void setMLeftViewList(List<View> r1) {
        this.mLeftViewList = r1;
    }

    public final List<View> getMRightViewList() {
        return this.mRightViewList;
    }

    public final void setMRightViewList(List<View> r1) {
        this.mRightViewList = r1;
    }

    public final OButton getMLeftActionBack() {
        return this.mLeftActionBack;
    }

    public final void setMLeftActionBack(OButton r1) {
        this.mLeftActionBack = r1;
    }

    public final TextView getMTitleView() {
        return this.mTitleView;
    }

    public final void setMTitleView(TextView r1) {
        this.mTitleView = r1;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r1) {
        this.titleText = r1;
        setCenterText(r1);
    }

    public final TextView getMSubTitleView() {
        return this.mSubTitleView;
    }

    public final void setMSubTitleView(TextView r1) {
        this.mSubTitleView = r1;
    }

    public final String getSubTitleText() {
        return this.subTitleText;
    }

    public final void setSubTitleText(String r1) {
        this.subTitleText = r1;
        setCenterSubText(r1);
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r0 = this.mSubTitleView;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        this.mSubTitleView = generateSubTitleView();
        ViewGroup.LayoutParams r1 = generateDefaultLayoutParams();
        if (r1 == null) goto L11;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
        r2.addRule(14);
        r2.topMargin = OUnitExtensionKt.vdp(this, 30);
        addView(this.mSubTitleView, r2);
        TextView r3 = this.mSubTitleView;
        Intrinsics.checkNotNull(r3);
        return r3;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final TextView getTitleViewOrCreate() {
        View r0 = this.mCenterView;
        if (r0 == null) goto L8;
        TextView r1 = this.mTitleView;
        if (r0 != r1) goto L8;
        Intrinsics.checkNotNull(r1);
        return r1;
    L8:
        if (this.mTitleView != null) goto L11;
        this.mTitleView = generateTitleView();
    L11:
        if (this.mCenterView == null) goto L13;
        removeCenterView();
    L13:
        addView(this.mTitleView, generateCenterViewLayoutParams());
        TextView r2 = this.mTitleView;
        this.mCenterView = r2;
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.mRightViewList != null) goto L5;
        this.mRightViewList = new ArrayList();
    L5:
        List<View> r1 = this.mRightViewList;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.mLeftViewList != null) goto L5;
        this.mLeftViewList = new ArrayList();
    L5:
        List<View> r1 = this.mLeftViewList;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    /* JADX INFO: renamed from: onGlobalLayoutListener$lambda-0, reason: not valid java name */
    private static final void m736onGlobalLayoutListener$lambda0(OCTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.removeGlobalLayoutListener();
        if (r1.isNeedListenGlobalLayout() == true) goto L5;
        return;
    L5:
        r1.adjustTitleViewSpace("OnGlobalLayoutListener");
    }

    private final void addGlobalLayoutListener() {
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        L.e(TAG, "addGlobalLayoutListener: ", e);
    }

    private final void removeGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        L.e(TAG, "removeGlobalLayoutListener: ", e);
    }

    private final void initAttrs(AttributeSet r5) {
        TypedArray r6 = getContext().getTheme().obtainStyledAttributes(r5, R.styleable.OCTitleBar, 0, 0);
        int r0 = r6.getInt(R.styleable.OCTitleBar_oui_title_pos, com.obric.oui.titlebar.OCTitleBar.TitlePosition.FIXED_CENTER.getValue());
        com.obric.oui.titlebar.OCTitleBar.TitlePosition r1 = com.obric.oui.titlebar.OCTitleBar.TitlePosition.values()[r0];
        String r2 = r6.getString(R.styleable.OCTitleBar_oui_title_text);
        if (r2 == null) goto L6;
        setCenterText(r2);
    L6:
        if (r6.getBoolean(R.styleable.OCTitleBar_oui_useBackIcon, true) == false) goto L8;
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        OButton r4 = OCTitleBarExtKt.createTransIconButton(this, r3);
        r4.setButtonSourceBitmap(BACK_ICON_RES);
        setMLeftActionBack(r4);
        addLeftView(r4);
    L8:
        String r7 = r6.getString(R.styleable.OCTitleBar_oui_sub_title_text);
        if (r7 == null) goto L11;
        setCenterSubText(r7);
    L11:
        this.autoAdjustTitleSpace = r6.getBoolean(R.styleable.OCTitleBar_oui_autoAdjustTitleSpace, true);
        int r8 = (int) getContext().getResources().getDimension(R.dimen.oui_p_title_bar_default);
        setPadding(r8, 0, r8, 0);
    }

    private final boolean isNeedListenGlobalLayout() {
        return this.autoAdjustTitleSpace;
    }

    public final void setCenterView(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        setCenterView(r2, findLayoutParams(r2, true));
    }

    private final void setCenterView(View r2, RelativeLayout.LayoutParams r3) {
        if (Intrinsics.areEqual(this.mCenterView, r2) == false) goto L5;
        return;
    L5:
        removeCenterView();
        this.mCenterView = r2;
        addView(r2, r3);
    }

    public final void setCenterText(int r2) {
        setCenterText(getContext().getString(r2));
    }

    private final void setCenterText(String r1) {
        getTitleViewOrCreate().setText(r1);
    }

    private final void setCenterSubText(String r2) {
        getSubtitleViewOrCreate().setText(r2);
        adjustTitlePosition();
    }

    private final void adjustTitlePosition() {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L6;
        return;
    L6:
        if (getMSubTitleView() == null) goto L21;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L20;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
        r2.removeRule(13);
        r2.addRule(14);
        OCTitleBar r3 = this;
        r2.topMargin = OUnitExtensionKt.vdp(r3, 9);
        if (getContext().getResources().getConfiguration().fontScale <= 1.0f) goto L22;
        r2.topMargin = OUnitExtensionKt.vdp(r3, 6);
        TextView r5 = getMSubTitleView();
        if (r5 == null) goto L25;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L18;
        int r4 = OUnitExtensionKt.vdp(r3, 31);
        ((RelativeLayout.LayoutParams) r6).topMargin = r4;
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

    private final void removeCenterView() {
        View r0 = this.mCenterView;
        if (r0 == null) goto L6;
        removeView(r0);
        this.mCenterView = null;
        return;
    }

    private final TextView generateTitleView() {
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(R.style.Title_Title_M_Thick);
        r6.setTextColor(r6.getContext().getResources().getColor(TITLE_TEXT_COLOR));
        return r6;
    }

    private final TextView generateSubTitleView() {
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(R.style.Label_M);
        r6.setTextColor(r6.getContext().getResources().getColor(SUB_TITLE_TEXT_COLOR));
        return r6;
    }

    private final RelativeLayout.LayoutParams generateCenterViewLayoutParams() {
        ViewGroup.LayoutParams r1 = generateDefaultLayoutParams();
        if (r1 == null) goto L7;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
        r2.addRule(13);
        return r2;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void addLeftView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        addLeftView(r4, findLayoutParams(r4, false), getLeftViewCount(), 0);
    }

    public final void addLeftView(View r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        addLeftView$default(this, r9, findLayoutParams(r9, false), r10, 0, 8, null);
    }

    public final void addLeftView(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        addLeftView(r2, findLayoutParams(r2, false), r3, r4);
    }

    public static /* synthetic */ void addLeftView$default(OCTitleBar r0, View r1, RelativeLayout.LayoutParams r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = OUnitExtensionKt.vdp(r0, 8);
    L5:
        r0.addLeftView(r1, r2, r3, r4);
    }

    public final void addLeftView(View r4, RelativeLayout.LayoutParams r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "layoutParams");
        r5.alignWithParent = true;
        r5.leftMargin = r7;
        r4.setId(View.generateViewId());
        if (this.mLeftLastView != null) goto L5;
        r5.addRule(9);
        r6 = 0;
    L22:
        r5.addRule(15);
        List<View> r8 = this.mLeftViewList;
        if (r8 == null) goto L26;
        Intrinsics.checkNotNull(r8);
        if (r6 == r8.size()) goto L26;
    L27:
        getLeftViewListOrCreate().add(r6, r4);
        addView(r4, r5);
        return;
    L26:
        this.mLeftLastView = r4;
        goto L27
    L5:
        if (r6 < 0) goto L21;
        List<View> r9 = this.mLeftViewList;
        Intrinsics.checkNotNull(r9);
        if (r6 >= r9.size()) goto L21;
        if (r6 != 0) goto L16;
        r5.addRule(9);
        List<View> r2 = this.mLeftViewList;
        Intrinsics.checkNotNull(r2);
        ViewGroup.LayoutParams r3 = r2.get(r6).getLayoutParams();
        if (r3 == null) goto L15;
        RelativeLayout.LayoutParams r10 = (RelativeLayout.LayoutParams) r3;
        r10.removeRule(9);
        r10.addRule(1, r4.getId());
        goto L22
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L16:
        List<View> r1 = this.mLeftViewList;
        Intrinsics.checkNotNull(r1);
        View r11 = r1.get(r6 - 1);
        List<View> r12 = this.mLeftViewList;
        Intrinsics.checkNotNull(r12);
        View r13 = r12.get(r6);
        r5.addRule(1, r11.getId());
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L20;
        ((RelativeLayout.LayoutParams) r14).addRule(1, r4.getId());
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L21:
        List<View> r15 = this.mLeftViewList;
        Intrinsics.checkNotNull(r15);
        r6 = r15.size();
        View r16 = this.mLeftLastView;
        Intrinsics.checkNotNull(r16);
        r5.addRule(1, r16.getId());
        goto L22
    }

    public final void hideAllLeftView() {
        List<View> r2 = this.mLeftViewList;
        if (r2 == null) goto L9;
        Iterator<View> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        r3.next().setVisibility(4);
        goto L7
    L11:
        return;
    }

    public final void removeAllLeftViews() {
        List<View> r0 = this.mLeftViewList;
        if (r0 == null) goto L12;
        Iterator<View> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        removeViewInLayout(r1.next());
        goto L7
    L9:
        setMLeftLastView(null);
        List<View> r2 = getMLeftViewList();
        Intrinsics.checkNotNull(r2);
        r2.clear();
        requestLayout();
        return;
    }

    public final void removeLeftView(int r6) {
        if (r6 < 0) goto L26;
        List<View> r0 = this.mLeftViewList;
        Intrinsics.checkNotNull(r0);
        if (r6 < r0.size()) goto L7;
        return;
    L7:
        if (r6 != 0) goto L16;
        int r2 = r6 + 1;
        List<View> r3 = this.mLeftViewList;
        Intrinsics.checkNotNull(r3);
        if (r2 >= r3.size()) goto L15;
        List<View> r4 = this.mLeftViewList;
        Intrinsics.checkNotNull(r4);
        ViewGroup.LayoutParams r5 = r4.get(r2).getLayoutParams();
        if (r5 == null) goto L14;
        RelativeLayout.LayoutParams r7 = (RelativeLayout.LayoutParams) r5;
        r7.removeRule(1);
        r7.addRule(9);
    L22:
        List<View> r1 = this.mLeftViewList;
        Intrinsics.checkNotNull(r1);
        removeView(r1.get(r6));
        List<View> r8 = this.mLeftViewList;
        Intrinsics.checkNotNull(r8);
        r8.remove(r6);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L15:
        this.mLeftLastView = null;
        goto L22
    L16:
        List<View> r9 = this.mLeftViewList;
        Intrinsics.checkNotNull(r9);
        if (r6 != (r9.size() - 1)) goto L19;
        List<View> r10 = this.mLeftViewList;
        Intrinsics.checkNotNull(r10);
        this.mLeftLastView = r10.get(r6 - 1);
        goto L22
    L19:
        List<View> r11 = this.mLeftViewList;
        Intrinsics.checkNotNull(r11);
        View r12 = r11.get(r6 - 1);
        List<View> r13 = this.mLeftViewList;
        Intrinsics.checkNotNull(r13);
        ViewGroup.LayoutParams r14 = r13.get(r6 + 1).getLayoutParams();
        if (r14 == null) goto L25;
        ((RelativeLayout.LayoutParams) r14).addRule(1, r12.getId());
        goto L22
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void hideAllRightView() {
        List<View> r2 = this.mRightViewList;
        if (r2 == null) goto L9;
        Iterator<View> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        r3.next().setVisibility(4);
        goto L7
    L11:
        return;
    }

    public final void addRightView(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        addRightView$default(this, r9, findLayoutParams(r9, false), 0, 0, 8, null);
    }

    public static /* synthetic */ void addRightView$default(OCTitleBar r0, View r1, RelativeLayout.LayoutParams r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = OUnitExtensionKt.vdp(r0, 0);
    L5:
        r0.addRightView(r1, r2, r3, r4);
    }

    public final void addRightView(View r5, RelativeLayout.LayoutParams r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "layoutParams");
        r6.alignWithParent = true;
        r5.setId(View.generateViewId());
        if (this.mRightLastView != null) goto L5;
        r6.rightMargin = r8;
        r6.addRule(11);
        r7 = 0;
    L22:
        r6.addRule(15);
        List<View> r9 = this.mRightViewList;
        if (r9 == null) goto L26;
        Intrinsics.checkNotNull(r9);
        if (r7 == r9.size()) goto L26;
    L27:
        getRightViewListOrCreate().add(r7, r5);
        addView(r5, r6);
        return;
    L26:
        this.mRightLastView = r5;
        goto L27
    L5:
        if (r7 < 0) goto L21;
        List<View> r0 = this.mRightViewList;
        Intrinsics.checkNotNull(r0);
        if (r7 >= r0.size()) goto L21;
        if (r7 != 0) goto L16;
        r6.rightMargin = r8;
        r6.addRule(11);
        List<View> r10 = this.mRightViewList;
        Intrinsics.checkNotNull(r10);
        ViewGroup.LayoutParams r11 = r10.get(r7).getLayoutParams();
        if (r11 == null) goto L15;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.removeRule(11);
        r12.addRule(0, r5.getId());
        goto L22
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L16:
        List<View> r1 = this.mRightViewList;
        Intrinsics.checkNotNull(r1);
        View r2 = r1.get(r7 - 1);
        List<View> r3 = this.mRightViewList;
        Intrinsics.checkNotNull(r3);
        View r4 = r3.get(r7);
        r6.addRule(0, r2.getId());
        r6.rightMargin = r8;
        ViewGroup.LayoutParams r13 = r4.getLayoutParams();
        if (r13 == null) goto L20;
        ((RelativeLayout.LayoutParams) r13).addRule(0, r5.getId());
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L21:
        List<View> r14 = this.mRightViewList;
        Intrinsics.checkNotNull(r14);
        r7 = r14.size();
        View r15 = this.mRightLastView;
        Intrinsics.checkNotNull(r15);
        r6.addRule(0, r15.getId());
        r6.rightMargin = r8;
        goto L22
    }

    public final void removeAllRightViews() {
        List<View> r0 = this.mRightViewList;
        if (r0 == null) goto L12;
        Iterator<View> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        removeViewInLayout(r1.next());
        goto L7
    L9:
        setMRightLastView(null);
        List<View> r2 = getMRightViewList();
        Intrinsics.checkNotNull(r2);
        r2.clear();
        requestLayout();
        invalidate();
        return;
    }

    public final void removeRightView(int r6) {
        if (r6 < 0) goto L26;
        List<View> r0 = this.mRightViewList;
        Intrinsics.checkNotNull(r0);
        if (r6 < r0.size()) goto L7;
        return;
    L7:
        if (r6 != 0) goto L16;
        int r2 = r6 + 1;
        List<View> r3 = this.mRightViewList;
        Intrinsics.checkNotNull(r3);
        if (r2 >= r3.size()) goto L15;
        List<View> r4 = this.mRightViewList;
        Intrinsics.checkNotNull(r4);
        ViewGroup.LayoutParams r5 = r4.get(r2).getLayoutParams();
        if (r5 == null) goto L14;
        RelativeLayout.LayoutParams r7 = (RelativeLayout.LayoutParams) r5;
        r7.removeRule(0);
        r7.addRule(11);
    L22:
        List<View> r1 = this.mRightViewList;
        Intrinsics.checkNotNull(r1);
        removeView(r1.get(r6));
        List<View> r8 = this.mRightViewList;
        Intrinsics.checkNotNull(r8);
        r8.remove(r6);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L15:
        this.mRightLastView = null;
        goto L22
    L16:
        List<View> r9 = this.mRightViewList;
        Intrinsics.checkNotNull(r9);
        if (r6 != (r9.size() - 1)) goto L19;
        List<View> r10 = this.mRightViewList;
        Intrinsics.checkNotNull(r10);
        this.mRightLastView = r10.get(r6 - 1);
        goto L22
    L19:
        List<View> r11 = this.mRightViewList;
        Intrinsics.checkNotNull(r11);
        View r12 = r11.get(r6 - 1);
        List<View> r13 = this.mRightViewList;
        Intrinsics.checkNotNull(r13);
        ViewGroup.LayoutParams r14 = r13.get(r6 + 1).getLayoutParams();
        if (r14 == null) goto L25;
        ((RelativeLayout.LayoutParams) r14).addRule(0, r12.getId());
        goto L22
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final boolean hasLeftView() {
        return hasView(this.mLeftViewList);
    }

    public final int getLeftViewCount() {
        return getViewCount(this.mLeftViewList);
    }

    public final View getLeftViewByIndex(int r2) {
        return getViewByIndex(r2, this.mLeftViewList);
    }

    public final boolean hasRightView() {
        return hasView(this.mRightViewList);
    }

    public final int getRightViewCount() {
        return getViewCount(this.mRightViewList);
    }

    public final View getRightViewByIndex(int r2) {
        return getViewByIndex(r2, this.mRightViewList);
    }

    private final void adjustTitleViewSpace(String r8) {
        Rect r0 = new Rect();
        Rect r1 = new Rect();
        List<View> r2 = this.mLeftViewList;
        if (r2 == null) goto L9;
        Iterator<T> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        View r4 = (View) r3.next();
        Rect r5 = new Rect();
        r4.getGlobalVisibleRect(r5);
        r0.union(r5.left, r5.top, r5.right, r5.bottom);
    L9:
        List<View> r6 = this.mRightViewList;
        if (r6 == null) goto L17;
        Iterator<T> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        View r9 = (View) r7.next();
        Rect r10 = new Rect();
        r9.getGlobalVisibleRect(r10);
        r1.union(r10.left, r10.top, r10.right, r10.bottom);
    L17:
        if (r0.isEmpty() == false) goto L19;
        int r11 = 0;
    L20:
        int r12 = RangesKt.coerceAtLeast(r11, 0);
        if (r1.isEmpty() == false) goto L23;
        int r13 = 0;
    L24:
        int r14 = RangesKt.coerceAtLeast(r13, 0);
        int r15 = Math.max(r12, r14);
        L.d(TAG, "adjustTitleViewSpace, scene: " + r8 + ", leftSpace: " + r12 + ", rightSpace: " + r14 + ", leftViewRectF: " + r0 + ", rightViewRectF: " + r1 + ", width: " + getWidth() + ", height: " + getHeight());
        if (r15 <= 0) goto L55;
        KtExt r16 = KtExt.INSTANCE;
        TextView r17 = this.mTitleView;
        ViewGroup.LayoutParams r18 = null;
        if (r17 != null) goto L29;
        ViewGroup.LayoutParams r19 = null;
    L30:
        if (r19 != null) goto L33;
    L31:
        r19 = null;
    L34:
        RelativeLayout.LayoutParams r20 = (RelativeLayout.LayoutParams) r19;
        if (r20 == null) goto L38;
        r20.leftMargin = r15;
        r20.rightMargin = r15;
    L38:
        KtExt r21 = KtExt.INSTANCE;
        TextView r22 = this.mSubTitleView;
        if (r22 != null) goto L41;
        ViewGroup.LayoutParams r23 = null;
    L42:
        if (r23 != null) goto L45;
    L47:
        RelativeLayout.LayoutParams r24 = (RelativeLayout.LayoutParams) r18;
        if (r24 == null) goto L51;
        r24.leftMargin = r15;
        r24.rightMargin = r15;
    L51:
        requestLayout();
        return;
    L45:
        if ((r23 instanceof RelativeLayout.LayoutParams) == false) goto L47;
        r18 = r23;
        goto L47
    L41:
        r23 = r22.getLayoutParams();
        goto L42
    L33:
        if ((r19 instanceof RelativeLayout.LayoutParams) == false) goto L31;
    L29:
        r19 = r17.getLayoutParams();
        goto L30
    L55:
        return;
    L23:
        r13 = getWidth() - r1.left;
        goto L24
    L19:
        r11 = r0.right;
        goto L20
    }

    private final boolean hasView(List<? extends View> r5) {
        if (r5 != null) goto L5;
    L13:
        return false;
    L5:
        if (r5.size() <= 0) goto L13;
        int r0 = r5.size();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L13;
        int r2 = r1 + 1;
        if (r5.get(r1).getVisibility() != 8) goto L10;
        r1 = r2;
        goto L7
    L10:
        return true;
    }

    private final View getViewByIndex(int r6, List<? extends View> r7) {
        if (r7 == null) goto L15;
        if (r6 >= 0) goto L5;
        return null;
    L5:
        if (r6 >= r7.size()) goto L25;
        int r5 = r7.size();
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r0 >= r5) goto L26;
        r0 = r0 + 1;
        View r2 = r7.get(r0);
        if (r2.getVisibility() == 8) goto L7;
        int r3 = r1 + 1;
        if (r6 == r1) goto L12;
        r1 = r3;
        goto L7
    L12:
        return r2;
    L26:
        return null;
    L25:
        return null;
    L15:
        return null;
    }

    private final int getViewCount(List<? extends View> r5) {
        int r4 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.size() <= 0) goto L18;
        int r0 = r5.size();
        int r1 = 0;
    L7:
        if (r4 >= r0) goto L13;
        int r2 = r4 + 1;
        if (r5.get(r4).getVisibility() == 8) goto L11;
        r1 = r1 + 1;
    L11:
        r4 = r2;
        goto L7
    L13:
        return r1;
    L18:
        return 0;
    }

    private final RelativeLayout.LayoutParams findLayoutParams(View r2, boolean r3) {
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if ((r4 instanceof RelativeLayout.LayoutParams) == true) goto L13;
        if (r3 == false) goto L7;
        RelativeLayout.LayoutParams r1 = generateCenterViewLayoutParams();
    L8:
        if (r1 == null) goto L12;
        return (RelativeLayout.LayoutParams) r1;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L7:
        r1 = generateDefaultLayoutParams();
        goto L8
    L13:
        return (RelativeLayout.LayoutParams) r4;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec((int) getContext().getResources().getDimension(R.dimen.oui_h_title_bar_window), 1073741824));
    }
}
