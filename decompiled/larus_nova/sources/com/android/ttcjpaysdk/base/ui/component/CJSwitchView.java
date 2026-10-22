package com.android.ttcjpaysdk.base.ui.component;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020*H\u0002J\n\u0010+\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010\r\u001a\u00020\fJ0\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\u000e\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\fJ\u000e\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\fJ\u000e\u00106\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkedIdx", "", "forbidStateChange", "", "isChecked", "listener", "Lcom/android/ttcjpaysdk/base/ui/component/OnCheckedChangeListener;", GXTemplateKey.FLEXBOX_PADDING, "switchThumbView", "Landroid/view/View;", "switchTrackView", "Landroid/widget/LinearLayout;", "thumbColor", "thumbDiameter", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "trackCheckedColor", "trackCornerRadius", "trackDrawable", "trackHeight", "trackUnCheckedColor", "trackWidth", "unCheckedIdx", "animateThumb", "", "fromWidth", "toWidth", "duration", "", "createRectangleDrawable", "color", "createThumbDrawable", "createTrackDrawable", "Landroid/graphics/drawable/StateListDrawable;", "getTrackDrawable", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "setForbidStateChange", "disable", "setIsChecked", "state", "setOnCheckedChangeListener", "updateState", "isPressed", "noChangedNotify", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSwitchView extends ConstraintLayout {
    private int[] checkedIdx;
    private boolean forbidStateChange;
    private boolean isChecked;
    private OnCheckedChangeListener listener;
    private int padding;
    private View switchThumbView;
    private LinearLayout switchTrackView;
    private int thumbColor;
    private int thumbDiameter;
    private Drawable thumbDrawable;
    private int trackCheckedColor;
    private int trackCornerRadius;
    private Drawable trackDrawable;
    private int trackHeight;
    private int trackUnCheckedColor;
    private int trackWidth;
    private int[] unCheckedIdx;

    public CJSwitchView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJSwitchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final Drawable createThumbDrawable() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setShape(1);
        r100.setColor(this.thumbColor);
        int r101 = this.thumbDiameter;
        r100.setSize(r101, r101);
        r100.setStroke(CJPayBasicExtensionKt.dp(1), 0);
        return r100;
    }

    private final StateListDrawable createTrackDrawable() {
        StateListDrawable r100 = new StateListDrawable();
        Drawable r101 = createRectangleDrawable(this.trackCheckedColor);
        Drawable r102 = createRectangleDrawable(this.trackUnCheckedColor);
        r100.addState(new int[]{R.attr.state_checked}, r101);
        r100.addState(new int[]{-16842912}, r102);
        return r100;
    }

    private final Drawable getTrackDrawable() {
        if (this.isChecked == false) goto L5;
        int[] r100 = this.checkedIdx;
    L6:
        Drawable r101 = this.trackDrawable;
        StateListDrawable r102 = null;
        if (r101 == null) goto L9;
        Boolean r103 = Boolean.valueOf(r101.isStateful());
    L10:
        if (r103 == null) goto L12;
        boolean r104 = r103.booleanValue();
    L13:
        if (r104 == false) goto L26;
        Drawable r105 = this.trackDrawable;
        if (r105 == null) goto L17;
        Drawable r106 = r105.mutate();
    L19:
        if ((r106 instanceof StateListDrawable) == false) goto L21;
        r102 = (StateListDrawable) r106;
    L21:
        if (r102 == null) goto L24;
        r102.setState(r100);
    L24:
        return r102;
    L17:
        r106 = null;
        goto L19
    L26:
        return this.trackDrawable;
    L12:
        r104 = false;
        goto L13
    L9:
        r103 = null;
        goto L10
    L5:
        r100 = this.unCheckedIdx;
        goto L6
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public static final /* synthetic */ boolean access$getForbidStateChange$p(CJSwitchView r100) {
        return r100.forbidStateChange;
    }

    public static final /* synthetic */ boolean access$isChecked$p(CJSwitchView r100) {
        return r100.isChecked;
    }

    private final Drawable createRectangleDrawable(int r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setSize(this.trackWidth, this.trackHeight);
        r101.setColor(r100);
        r101.setCornerRadius(this.trackCornerRadius);
        return r101;
    }

    public final void setForbidStateChange(boolean r100) {
        this.forbidStateChange = r100;
        if (r100 == false) goto L5;
        setAlpha(0.5f);
        setEnabled(false);
        return;
    L5:
        setAlpha(1.0f);
        setEnabled(true);
    }

    public final void setIsChecked(boolean r100) {
        if (this.isChecked != r100) goto L5;
        return;
    L5:
        this.isChecked = r100;
        updateState$default(this, false, false, 2, null);
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.listener = r100;
    }

    public static final /* synthetic */ void access$setChecked$p(CJSwitchView r100, boolean r101) {
        r100.isChecked = r101;
    }

    private final void updateState(boolean r110, boolean r111) {
        if (CJPayOptimizeSwitch.Companion.get().cjSwitchViewCheckedOpt == false) goto L8;
        if (r111 == true) goto L36;
        OnCheckedChangeListener r112 = this.listener;
        if (r112 == null) goto L36;
        r112.onCheckedChanged(this.isChecked, r110);
    L36:
        LinearLayout r113 = this.switchTrackView;     // Catch: Exception -> L33
        Drawable r100 = getTrackDrawable();     // Catch: Exception -> L33
        if (r100 == null) goto L14;
        Drawable r101 = r100.getCurrent();     // Catch: Exception -> L33
    L15:
        r113.setBackgroundDrawable(r101);     // Catch: Exception -> L33
        Drawable r114 = this.trackDrawable;     // Catch: Exception -> L33
        int r102 = 0;
        if (r114 == null) goto L18;
        int r115 = r114.getIntrinsicWidth();     // Catch: Exception -> L33
    L19:
        Drawable r103 = this.thumbDrawable;     // Catch: Exception -> L33
        if (r103 == null) goto L22;
        r102 = r103.getIntrinsicWidth();     // Catch: Exception -> L33
    L22:
        int r116 = r115 - r102;     // Catch: Exception -> L33
        int r104 = this.padding;     // Catch: Exception -> L33
        int r117 = r116 - r104;     // Catch: Exception -> L33
        boolean r105 = this.isChecked;     // Catch: Exception -> L33
        if (r105 == false) goto L25;
        int r106 = r104;
    L26:
        if (r105 == false) goto L28;
        int r107 = r117;
    L29:
        if (r110 == false) goto L31;
        animateThumb$default(this, r106, r107, 0, 4, null);     // Catch: Exception -> L33
        return;
    L31:
        this.switchThumbView.setTranslationX(r107);     // Catch: Exception -> L33
        return;
    L28:
        r107 = r104;
        goto L29
    L25:
        r106 = r117;
        goto L26
    L18:
        r115 = 0;
        goto L19
    L14:
        r101 = null;
    L33:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJSwitchView#updateState", e);
        CJLogger.b("CJPayCJSwitchStyle", "switch Exception: msg=" + e.getMessage());
        return;
    L8:
        OnCheckedChangeListener r118 = this.listener;
        if (r118 == null) goto L36;
        r118.onCheckedChanged(this.isChecked, r110);
        goto L36
    }

    public CJSwitchView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.thumbDiameter = CJPayBasicExtensionKt.dp(16);
        this.thumbColor = ColorProtector.parseColor("#ffffff");
        this.trackCheckedColor = ColorProtector.parseColor("#33E088");
        this.trackUnCheckedColor = ColorProtector.parseColor("#D0D1D3");
        this.trackCornerRadius = CJPayBasicExtensionKt.dp(10);
        this.trackWidth = CJPayBasicExtensionKt.dp(32);
        this.trackHeight = CJPayBasicExtensionKt.dp(16);
        this.checkedIdx = new int[]{R.attr.state_checked};
        this.unCheckedIdx = new int[]{-16842912};
        View r103 = LayoutInflater.from(r100).inflate(com.larus.nova.R.layout.cj_pay_layout_std_ui_switch, this, true);
        this.switchTrackView = (LinearLayout) r103.findViewById(com.larus.nova.R.id.cj_pay_layout_std_ui_switch_track);
        this.switchThumbView = r103.findViewById(com.larus.nova.R.id.cj_pay_layout_std_ui_switch_thumb);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.cjSwitchForbidStateChange, com.larus.nova.R.attr.cjSwitchIsChecked, com.larus.nova.R.attr.cjSwitchPadding, com.larus.nova.R.attr.cjSwitchThumb, com.larus.nova.R.attr.cjSwitchThumbColor, com.larus.nova.R.attr.cjSwitchThumbDiameter, com.larus.nova.R.attr.cjSwitchTrack, com.larus.nova.R.attr.cjSwitchTrackCheckedColor, com.larus.nova.R.attr.cjSwitchTrackCornerRadius, com.larus.nova.R.attr.cjSwitchTrackUncheckedColor});
        this.padding = (int) r104.getDimension(2, 0.0f);
        this.isChecked = r104.getBoolean(1, false);
        this.forbidStateChange = r104.getBoolean(0, false);
        this.thumbDiameter = (int) r104.getDimension(5, CJPayBasicExtensionKt.dp(16));
        this.thumbColor = r104.getColor(4, this.thumbColor);
        this.trackCheckedColor = r104.getColor(7, this.trackCheckedColor);
        this.trackUnCheckedColor = r104.getColor(9, this.trackUnCheckedColor);
        this.trackCornerRadius = (int) r104.getDimension(8, this.trackCornerRadius);
        r104.recycle();
        if (this.forbidStateChange == false) goto L5;
        setAlpha(0.5f);
        setEnabled(false);
    L6:
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.switchTrackView, new AnonymousClass1(this));
        this.trackDrawable = createTrackDrawable();
        Drawable r105 = createThumbDrawable();
        this.thumbDrawable = r105;
        this.switchThumbView.setBackground(r105);
        ViewGroup.LayoutParams r106 = this.switchThumbView.getLayoutParams();
        if (r106 == null) goto L9;
        int r107 = this.thumbDiameter;
        r106.width = r107;
        r106.height = r107;
    L9:
        updateState$default(this, false, false, 2, null);
        return;
    L5:
        setAlpha(1.0f);
        setEnabled(true);
        goto L6
    }

    private final void animateThumb(int r100, int r101, long r102) {
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.switchThumbView, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r100, r101});
        r103.setDuration(r102);
        r103.setInterpolator(new DecelerateInterpolator());
        r103.start();
    }

    public /* synthetic */ CJSwitchView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void updateState$default(CJSwitchView r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.updateState(r101, r102);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.trackWidth == getWidth()) goto L5;
    L6:
        this.trackWidth = getWidth();
        this.trackHeight = getHeight();
        this.trackDrawable = createTrackDrawable();
        updateState(false, true);
        return;
    L5:
        if (this.trackHeight != getHeight()) goto L6;
    }

    public static /* synthetic */ void animateThumb$default(CJSwitchView r100, int r101, int r102, long r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = 320;
    L5:
        r100.animateThumb(r101, r102, r103);
    }
}
