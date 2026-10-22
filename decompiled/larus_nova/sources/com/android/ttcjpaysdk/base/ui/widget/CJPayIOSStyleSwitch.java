package com.android.ttcjpaysdk.base.ui.widget;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPayIOSStyleSwitch;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkedIdx", "", "forbidStateChange", "", "isChecked", "leftPaddingView", "Landroid/view/View;", "listener", "Lcom/android/ttcjpaysdk/base/ui/widget/OnCheckedChangeListener;", GXTemplateKey.FLEXBOX_PADDING, "switchThumbView", "switchTrackView", "Landroid/widget/LinearLayout;", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "trackDrawable", "unCheckedIdx", "animateThumb", "", "fromWidth", "toWidth", "duration", "", "getTrackDrawable", "setIsChecked", "state", "setOnCheckedChangeListener", "updateState", "isPressed", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayIOSStyleSwitch extends ConstraintLayout {
    private int[] checkedIdx;
    private boolean forbidStateChange;
    private boolean isChecked;
    private View leftPaddingView;
    private OnCheckedChangeListener listener;
    private int padding;
    private View switchThumbView;
    private LinearLayout switchTrackView;
    private Drawable thumbDrawable;
    private Drawable trackDrawable;
    private int[] unCheckedIdx;

    public CJPayIOSStyleSwitch(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJPayIOSStyleSwitch(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
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

    public static final /* synthetic */ boolean access$getForbidStateChange$p(CJPayIOSStyleSwitch r100) {
        return r100.forbidStateChange;
    }

    public static final /* synthetic */ View access$getLeftPaddingView$p(CJPayIOSStyleSwitch r100) {
        return r100.leftPaddingView;
    }

    public static final /* synthetic */ boolean access$isChecked$p(CJPayIOSStyleSwitch r100) {
        return r100.isChecked;
    }

    private final void updateState(boolean r110) {
        OnCheckedChangeListener r100 = this.listener;
        if (r100 == null) goto L30;
        r100.onCheckedChanged(this.isChecked, r110);
    L30:
        LinearLayout r101 = this.switchTrackView;     // Catch: Exception -> L27
        Drawable r102 = getTrackDrawable();     // Catch: Exception -> L27
        if (r102 == null) goto L8;
        Drawable r103 = r102.getCurrent();     // Catch: Exception -> L27
    L9:
        r101.setBackgroundDrawable(r103);     // Catch: Exception -> L27
        Drawable r104 = this.trackDrawable;     // Catch: Exception -> L27
        int r105 = 0;
        if (r104 == null) goto L12;
        int r106 = r104.getIntrinsicWidth();     // Catch: Exception -> L27
    L13:
        Drawable r107 = this.thumbDrawable;     // Catch: Exception -> L27
        if (r107 == null) goto L16;
        r105 = r107.getIntrinsicWidth();     // Catch: Exception -> L27
    L16:
        int r108 = r106 - r105;     // Catch: Exception -> L27
        int r109 = this.padding;     // Catch: Exception -> L27
        int r111 = r108 - r109;     // Catch: Exception -> L27
        boolean r112 = this.isChecked;     // Catch: Exception -> L27
        if (r112 == false) goto L19;
        int r113 = r109;
    L20:
        if (r112 == false) goto L22;
        int r114 = r111;
    L23:
        if (r110 == false) goto L25;
        animateThumb$default(this, r113, r114, 0, 4, null);     // Catch: Exception -> L27
        return;
    L25:
        this.leftPaddingView.getLayoutParams().width = r114;     // Catch: Exception -> L27
        this.leftPaddingView.requestLayout();     // Catch: Exception -> L27
        return;
    L22:
        r114 = r109;
        goto L23
    L19:
        r113 = r111;
        goto L20
    L12:
        r106 = 0;
        goto L13
    L8:
        r103 = null;
    L27:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayIOSStyleSwitch#updateState", e);
        CJLogger.b("CJPayIOSStyleSwitch", "switch Exception: msg=" + e.getMessage());
    }

    public final void setIsChecked(boolean r100) {
        if (this.isChecked != r100) goto L5;
        return;
    L5:
        this.isChecked = r100;
        updateState(false);
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.listener = r100;
    }

    public static final /* synthetic */ void access$setChecked$p(CJPayIOSStyleSwitch r100, boolean r101) {
        r100.isChecked = r101;
    }

    public static final /* synthetic */ void access$updateState(CJPayIOSStyleSwitch r100, boolean r101) {
        r100.updateState(r101);
    }

    public CJPayIOSStyleSwitch(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.checkedIdx = new int[]{R.attr.state_checked};
        this.unCheckedIdx = new int[]{-16842912};
        View r103 = LayoutInflater.from(r100).inflate(com.larus.nova.R.layout.cj_pay_ios_style_switch_layout, this, true);
        this.switchTrackView = (LinearLayout) r103.findViewById(com.larus.nova.R.id.switch_track);
        this.switchThumbView = r103.findViewById(com.larus.nova.R.id.switch_thumb);
        this.leftPaddingView = r103.findViewById(com.larus.nova.R.id.switch_left_padding_view);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.forbidStateChange, com.larus.nova.R.attr.isChecked, com.larus.nova.R.attr.switchPadding, com.larus.nova.R.attr.switchThumb, com.larus.nova.R.attr.switchTrack});
        Drawable r105 = r104.getDrawable(3);
        if (r105 != null) goto L5;
        r105 = getResources().getDrawable(com.larus.nova.R.drawable.cj_pay_switch_default_thumb_icon);
    L5:
        this.thumbDrawable = r105;
        Drawable r106 = r104.getDrawable(4);
        if (r106 != null) goto L8;
        r106 = getResources().getDrawable(com.larus.nova.R.drawable.cj_pay_switch_default_track_selector);
    L8:
        this.trackDrawable = r106;
        this.padding = (int) r104.getDimension(2, 0.0f);
        this.isChecked = r104.getBoolean(1, false);
        this.forbidStateChange = r104.getBoolean(0, false);
        r104.recycle();
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.switchTrackView, new AnonymousClass1(this));
        this.switchThumbView.setBackgroundDrawable(this.thumbDrawable);
        ViewGroup.LayoutParams r107 = this.switchThumbView.getLayoutParams();
        if (r107 == null) goto L19;
        Drawable r108 = this.thumbDrawable;
        if (r108 == null) goto L13;
        int r109 = r108.getIntrinsicWidth();
    L14:
        r107.width = r109;
        Drawable r110 = this.thumbDrawable;
        if (r110 == null) goto L17;
        int r111 = r110.getIntrinsicHeight();
    L18:
        r107.height = r111;
        goto L19
    L17:
        r111 = CJPayBasicExtensionKt.dp(0);
        goto L18
    L13:
        r109 = CJPayBasicExtensionKt.dp(0);
    L19:
        updateState(false);
    }

    private final void animateThumb(int r100, int r101, long r102) {
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r100, r101});
        r103.setDuration(r102);
        r103.setInterpolator(new DecelerateInterpolator());
        r103.addUpdateListener(new C89221(this));
        r103.start();
    }

    public /* synthetic */ CJPayIOSStyleSwitch(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void animateThumb$default(CJPayIOSStyleSwitch r100, int r101, int r102, long r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = 320;
    L5:
        r100.animateThumb(r101, r102, r103);
    }
}
