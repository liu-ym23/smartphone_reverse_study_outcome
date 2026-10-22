package com.stepos.widget.inputbar;

import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.C1299l;
import androidx.core.content.a;
import androidx.core.widget.e;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.inputbar.StepOSInputBar;
import com.stepos.widget.internal.StepOSCapsuleInputBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import y7.o;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001:\u0001vB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\rJ\u0017\u0010'\u001a\u00020\u000b2\b\b\u0001\u0010&\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0014¢\u0006\u0004\b)\u0010\rJ\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0014¢\u0006\u0004\b,\u0010\rJ\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-H\u0014¢\u0006\u0004\b/\u00100R\u001a\u00102\u001a\u0002018\u0014X\u0094D¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010BR\u001a\u0010G\u001a\u00020F8UX\u0094\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u00068UX\u0094\u0004¢\u0006\f\n\u0004\bK\u0010:\u001a\u0004\bL\u0010MR.\u0010O\u001a\u0004\u0018\u0001062\b\u0010N\u001a\u0004\u0018\u0001068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bO\u00108\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR$\u0010^\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010V\u001a\u0004\b_\u0010X\"\u0004\b`\u0010ZR\u0014\u0010c\u001a\u00020\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR$\u0010d\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\u001d\"\u0004\be\u0010fR(\u0010l\u001a\u0004\u0018\u00010g2\b\u0010N\u001a\u0004\u0018\u00010g8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR(\u0010o\u001a\u0004\u0018\u0001062\b\u0010N\u001a\u0004\u0018\u0001068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bm\u0010Q\"\u0004\bn\u0010SR$\u0010p\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bp\u0010\u001d\"\u0004\bq\u0010fR(\u0010u\u001a\u0004\u0018\u00010\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\br\u0010\u0010\"\u0004\bs\u0010t¨\u0006w"}, d2 = {"Lcom/stepos/widget/inputbar/StepOSInputBar;", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LY8/t;", "onClearButtonClicked", "()V", "Landroid/graphics/drawable/Drawable;", "createStartButtonSurfaceDrawable", "()Landroid/graphics/drawable/Drawable;", "applyStartButton", "Landroid/widget/ImageView;", "createIconSlot", "(Landroid/content/Context;)Landroid/widget/ImageView;", "", "Landroid/view/View;", "touchDelegateSlots", "()Ljava/util/List;", "pressScaleTargets", "applyCapsuleSurface", "", "shouldApplyLocalGlass", "()Z", "child", "isExtraSlot", "(Landroid/view/View;)Z", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "resId", "setStartButtonResource", "(I)V", "applyIcons", "onViewRemoved", "(Landroid/view/View;)V", "onDetachedFromWindowExtra", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChangedExtra", "(Landroid/content/res/Configuration;)V", "", "widgetLogTag", "Ljava/lang/String;", "getWidgetLogTag", "()Ljava/lang/String;", "", "startIconContentDescriptionValue", "Ljava/lang/CharSequence;", "startButtonSize", "I", "startButtonSpacing", "Landroidx/appcompat/widget/l;", "startButtonView", "Landroidx/appcompat/widget/l;", "startButtonIconValue", "Landroid/graphics/drawable/Drawable;", "startButtonVisibleValue", "Z", "clearButtonView", "Landroid/widget/ImageView;", "glassEnabledValue", "", "capsuleFlatElevationPx", "F", "getCapsuleFlatElevationPx", "()F", "capsuleFlatSurfaceColor", "getCapsuleFlatSurfaceColor", "()I", UxipConstants.f30680s, "startButtonIconContentDescription", "getStartButtonIconContentDescription", "()Ljava/lang/CharSequence;", "setStartButtonIconContentDescription", "(Ljava/lang/CharSequence;)V", "Lcom/stepos/widget/inputbar/StepOSInputBar$OnIconClickListener;", "onStartIconClickListener", "Lcom/stepos/widget/inputbar/StepOSInputBar$OnIconClickListener;", "getOnStartIconClickListener", "()Lcom/stepos/widget/inputbar/StepOSInputBar$OnIconClickListener;", "setOnStartIconClickListener", "(Lcom/stepos/widget/inputbar/StepOSInputBar$OnIconClickListener;)V", "onEndIconClickListener", "getOnEndIconClickListener", "setOnEndIconClickListener", "onStartButtonClickListener", "getOnStartButtonClickListener", "setOnStartButtonClickListener", "getEditTextInsertAnchor", "()Landroid/view/View;", "editTextInsertAnchor", "isGlassEnabled", "setGlassEnabled", "(Z)V", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "glassEffect", "getStartIconContentDescription", "setStartIconContentDescription", "startIconContentDescription", "isStartButtonVisible", "setStartButtonVisible", "getStartButtonIcon", "setStartButtonIcon", "(Landroid/graphics/drawable/Drawable;)V", "startButtonIcon", "OnIconClickListener", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSInputBar extends StepOSCapsuleInputBase {
    private final float capsuleFlatElevationPx;
    private final int capsuleFlatSurfaceColor;
    private final ImageView clearButtonView;
    private boolean glassEnabledValue;
    private OnIconClickListener onEndIconClickListener;
    private OnIconClickListener onStartButtonClickListener;
    private OnIconClickListener onStartIconClickListener;
    private CharSequence startButtonIconContentDescription;
    private Drawable startButtonIconValue;
    private final int startButtonSize;
    private final int startButtonSpacing;
    private final C1299l startButtonView;
    private boolean startButtonVisibleValue;
    private CharSequence startIconContentDescriptionValue;
    private final String widgetLogTag;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/inputbar/StepOSInputBar$OnIconClickListener;", "", "LY8/t;", "onIconClick", "()V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnIconClickListener {
        void onIconClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSInputBar(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(StepOSInputBar stepOSInputBar, View view) {
        OnIconClickListener onIconClickListener = stepOSInputBar.onStartIconClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onIconClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(StepOSInputBar stepOSInputBar, View view) {
        OnIconClickListener onIconClickListener = stepOSInputBar.onEndIconClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onIconClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$9(StepOSInputBar stepOSInputBar, View view) {
        OnIconClickListener onIconClickListener = stepOSInputBar.onStartButtonClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onIconClick();
        }
    }

    private final void applyStartButton() {
        this.startButtonView.setImageDrawable(copyDrawable(this.startButtonIconValue));
        this.startButtonView.setContentDescription(this.startButtonIconContentDescription);
        this.startButtonView.setVisibility((!this.startButtonVisibleValue || this.startButtonIconValue == null) ? 8 : 0);
        warnIfUnlabeled(this.startButtonView, "steposInputBarStartButtonIconContentDescription");
    }

    private final Drawable createStartButtonSurfaceDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(a.c(getContext(), R.color.stepos_inputbar_start_button_surface));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClearButtonClicked() {
        EditText editTextValue = getEditTextValue();
        if (editTextValue != null) {
            editTextValue.setText("");
        }
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void applyCapsuleSurface() {
        if (!shouldApplyLocalGlass()) {
            applyCapsuleFlatSurface();
        } else {
            applyCapsuleFlatElevation(false);
            getCapsuleLayout().setBackground(getCapsuleFallbackBackground());
        }
    }

    public final void applyCustomGlass(GlassCustomizer customizer) {
        p.i(customizer, "customizer");
        setGlassCustomizer(customizer);
        releaseCapsuleGlass();
        requestCapsuleGlassRefresh();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void applyIcons() {
        getStartIconView().setImageDrawable(copyDrawable(getStartIconValue()));
        getEndIconView().setImageDrawable(copyDrawable(getEndIconValue()));
        this.clearButtonView.setImageDrawable(copyDrawable(getEndIconActivatedValue()));
        getStartIconView().setVisibility(getStartIconValue() == null ? 8 : 0);
        getEndIconView().setVisibility(getEndIconValue() == null ? 8 : 0);
        this.clearButtonView.setVisibility((!getEndIconActivatedFlag() || getEndIconActivatedValue() == null) ? 8 : 0);
        getStartIconView().setContentDescription(this.startIconContentDescriptionValue);
        getEndIconView().setContentDescription(getEndIconContentDescriptionValue());
        ImageView imageView = this.clearButtonView;
        CharSequence endIconActivatedContentDescriptionValue = getEndIconActivatedContentDescriptionValue();
        if (endIconActivatedContentDescriptionValue == null) {
            endIconActivatedContentDescriptionValue = getEndIconContentDescriptionValue();
        }
        imageView.setContentDescription(endIconActivatedContentDescriptionValue);
        e.c(getStartIconView(), getIconTintValue());
        e.c(getEndIconView(), getIconTintValue());
        e.c(this.clearButtonView, getIconTintValue());
        int iSlotInset = slotInset();
        getStartIconView().setPadding(iSlotInset, iSlotInset, iSlotInset, iSlotInset);
        getEndIconView().setPadding(iSlotInset, iSlotInset, iSlotInset, iSlotInset);
        this.clearButtonView.setPadding(iSlotInset, iSlotInset, iSlotInset, iSlotInset);
        if (isLaidOut()) {
            refreshTouchDelegates();
        }
        warnIfUnlabeled(getStartIconView(), "steposInputBarStartIconContentDescription");
        warnIfUnlabeled(getEndIconView(), "steposInputBarEndIconContentDescription");
        warnIfUnlabeled(this.clearButtonView, "steposInputBarEndIconActivatedContentDescription");
    }

    public final void clearCustomGlass() {
        if (getGlassCustomizer() == null) {
            return;
        }
        setGlassCustomizer(null);
        releaseCapsuleGlass();
        requestCapsuleGlassRefresh();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public ImageView createIconSlot(Context context) {
        p.i(context, "context");
        C1299l c1299l = new C1299l(context);
        c1299l.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        c1299l.setClickable(true);
        c1299l.setFocusable(true);
        c1299l.setPadding(0, 0, 0, 0);
        c1299l.setMinimumWidth(0);
        c1299l.setMinimumHeight(0);
        c1299l.setBackgroundTintList(null);
        c1299l.setBackground(null);
        c1299l.setForeground(a.e(context, R.drawable.stepos_ripple_inputbar_icon_slot));
        return c1299l;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public float getCapsuleFlatElevationPx() {
        return this.capsuleFlatElevationPx;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public int getCapsuleFlatSurfaceColor() {
        return this.capsuleFlatSurfaceColor;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public View getEditTextInsertAnchor() {
        return this.clearButtonView;
    }

    public final o getGlassEffect() {
        return getGlassEffectOverride();
    }

    public final OnIconClickListener getOnEndIconClickListener() {
        return this.onEndIconClickListener;
    }

    public final OnIconClickListener getOnStartButtonClickListener() {
        return this.onStartButtonClickListener;
    }

    public final OnIconClickListener getOnStartIconClickListener() {
        return this.onStartIconClickListener;
    }

    /* renamed from: getStartButtonIcon, reason: from getter */
    public final Drawable getStartButtonIconValue() {
        return this.startButtonIconValue;
    }

    public final CharSequence getStartButtonIconContentDescription() {
        return this.startButtonIconContentDescription;
    }

    /* renamed from: getStartIconContentDescription, reason: from getter */
    public final CharSequence getStartIconContentDescriptionValue() {
        return this.startIconContentDescriptionValue;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public String getWidgetLogTag() {
        return this.widgetLogTag;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public boolean isExtraSlot(View child) {
        p.i(child, "child");
        return child == this.clearButtonView;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getGlassEnabledValue() {
        return this.glassEnabledValue;
    }

    /* renamed from: isStartButtonVisible, reason: from getter */
    public final boolean getStartButtonVisibleValue() {
        return this.startButtonVisibleValue;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void onConfigurationChangedExtra(Configuration newConfig) {
        p.i(newConfig, "newConfig");
        getStartIconView().setBackground(null);
        getEndIconView().setBackground(null);
        ImageView startIconView = getStartIconView();
        Context context = getContext();
        int i10 = R.drawable.stepos_ripple_inputbar_icon_slot;
        startIconView.setForeground(a.e(context, i10));
        getEndIconView().setForeground(a.e(getContext(), i10));
        this.startButtonView.setBackground(createStartButtonSurfaceDrawable());
        this.startButtonView.setForeground(a.e(getContext(), i10));
        applyIcons();
        applyStartButton();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void onDetachedFromWindowExtra() {
        this.onStartIconClickListener = null;
        this.onEndIconClickListener = null;
        this.onStartButtonClickListener = null;
        EditText editTextValue = getEditTextValue();
        if (editTextValue != null) {
            editTextValue.removeTextChangedListener(getQueryWatcher());
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        p.i(child, "child");
        super.onViewRemoved(child);
        if (child == getCapsuleLayout()) {
            Log.w(getWidgetLogTag(), "StepOSInputBar 的内部胶囊被移除；请只添加或移除自己的 EditText 子 View");
        }
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public List<View> pressScaleTargets() {
        return C1172u.e(getCapsuleLayout());
    }

    public final void setGlassEffect(o oVar) {
        boolean z10 = getGlassCustomizer() != null;
        setGlassCustomizer(null);
        if (!p.d(getGlassEffectOverride(), oVar) || z10) {
            setGlassEffectOverride(oVar);
            releaseCapsuleGlass();
            requestCapsuleGlassRefresh();
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.glassEnabledValue == z10) {
            return;
        }
        this.glassEnabledValue = z10;
        releaseCapsuleGlass();
        requestCapsuleGlassRefresh();
    }

    public final void setOnEndIconClickListener(OnIconClickListener onIconClickListener) {
        this.onEndIconClickListener = onIconClickListener;
    }

    public final void setOnStartButtonClickListener(OnIconClickListener onIconClickListener) {
        this.onStartButtonClickListener = onIconClickListener;
    }

    public final void setOnStartIconClickListener(OnIconClickListener onIconClickListener) {
        this.onStartIconClickListener = onIconClickListener;
    }

    public final void setStartButtonIcon(Drawable drawable) {
        if (this.startButtonIconValue == drawable) {
            return;
        }
        this.startButtonIconValue = drawable;
        applyStartButton();
    }

    public final void setStartButtonIconContentDescription(CharSequence charSequence) {
        if (p.d(this.startButtonIconContentDescription, charSequence)) {
            return;
        }
        this.startButtonIconContentDescription = charSequence;
        applyStartButton();
    }

    public final void setStartButtonResource(int resId) {
        setStartButtonIcon(resId == 0 ? null : a.e(getContext(), resId));
    }

    public final void setStartButtonVisible(boolean z10) {
        if (this.startButtonVisibleValue == z10) {
            return;
        }
        this.startButtonVisibleValue = z10;
        applyStartButton();
    }

    public final void setStartIconContentDescription(CharSequence charSequence) {
        if (p.d(this.startIconContentDescriptionValue, charSequence)) {
            return;
        }
        this.startIconContentDescriptionValue = charSequence;
        applyIcons();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public boolean shouldApplyLocalGlass() {
        return this.glassEnabledValue;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public List<View> touchDelegateSlots() {
        return C1173v.p(getStartIconView(), this.clearButtonView, getEndIconView());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSInputBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSInputBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSInputBar(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposInputBarStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_InputBar : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSInputBar(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11, context.getResources().getDimensionPixelSize(R.dimen.stepos_inputbar_height), context.getResources().getDimensionPixelSize(R.dimen.stepos_inputbar_icon_slot_size), context.getResources().getDimensionPixelSize(R.dimen.stepos_inputbar_icon_size), context.getResources().getDimensionPixelSize(R.dimen.stepos_inputbar_icon_text_spacing));
        p.i(context, "context");
        this.widgetLogTag = "StepOSInputBar";
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_inputbar_start_button_size);
        this.startButtonSize = dimensionPixelSize;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_inputbar_start_button_spacing);
        this.startButtonSpacing = dimensionPixelSize2;
        C1299l c1299l = new C1299l(context);
        c1299l.setId(R.id.stepos_inputbar_start_side_button);
        c1299l.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        c1299l.setClickable(true);
        c1299l.setFocusable(true);
        c1299l.setMinimumWidth(0);
        c1299l.setMinimumHeight(0);
        c1299l.setBackgroundTintList(null);
        c1299l.setBackground(createStartButtonSurfaceDrawable());
        c1299l.setForeground(a.e(context, R.drawable.stepos_ripple_inputbar_icon_slot));
        c1299l.setVisibility(8);
        this.startButtonView = c1299l;
        ImageView imageViewCreateIconSlot = createIconSlot(context);
        imageViewCreateIconSlot.setId(R.id.stepos_inputbar_clear_button);
        this.clearButtonView = imageViewCreateIconSlot;
        this.glassEnabledValue = true;
        this.capsuleFlatElevationPx = getResources().getDimension(R.dimen.stepos_inputbar_input_elevation);
        this.capsuleFlatSurfaceColor = a.c(context, R.color.stepos_inputbar_input_surface);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 16;
        layoutParams.setMarginEnd(dimensionPixelSize2);
        t tVar = t.f7040a;
        addStructuralView(c1299l, 0, layoutParams);
        StepOSCapsuleInputBase.CapsuleLayout capsuleLayout = getCapsuleLayout();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, getInputHeight(), 1.0f);
        layoutParams2.gravity = 16;
        addStructuralView(capsuleLayout, 1, layoutParams2);
        getStartIconView().setId(R.id.stepos_inputbar_start_button);
        getEndIconView().setId(R.id.stepos_inputbar_end_button);
        StepOSCapsuleInputBase.CapsuleLayout capsuleLayout2 = getCapsuleLayout();
        LinearLayout.LayoutParams layoutParamsSlotLayoutParams = slotLayoutParams();
        layoutParamsSlotLayoutParams.setMarginStart(getIconTextSpacing());
        capsuleLayout2.addView(imageViewCreateIconSlot, 1, layoutParamsSlotLayoutParams);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSInputBar, i10, i11);
        p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setStartIconValue(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSInputBar_steposInputBarStartIcon));
        setEndIconValue(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSInputBar_steposInputBarEndIcon));
        setEndIconActivatedValue(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSInputBar_steposInputBarEndIconActivated));
        setIconTintValue(typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSInputBar_steposInputBarIconTint));
        this.startIconContentDescriptionValue = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSInputBar_steposInputBarStartIconContentDescription);
        setEndIconContentDescriptionValue(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSInputBar_steposInputBarEndIconContentDescription));
        setEndIconActivatedContentDescriptionValue(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSInputBar_steposInputBarEndIconActivatedContentDescription));
        setAutoClearButtonEnabledValue(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSInputBar_steposInputBarAutoClearButton, true));
        setGlassEffect(GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSInputBar_steposGlassEffect));
        this.glassEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSInputBar_steposGlassEnabled, true);
        setPressScaleEnabledValue(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSInputBar_steposPressScaleEnabled, false));
        this.startButtonIconValue = typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSInputBar_steposInputBarStartButtonIcon);
        this.startButtonVisibleValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSInputBar_steposInputBarStartButtonVisible, false);
        typedArrayObtainStyledAttributes.recycle();
        getStartIconView().setOnClickListener(new View.OnClickListener() { // from class: Q7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSInputBar._init_$lambda$6(this.f5426a, view);
            }
        });
        getEndIconView().setOnClickListener(new View.OnClickListener() { // from class: Q7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSInputBar._init_$lambda$7(this.f5427a, view);
            }
        });
        imageViewCreateIconSlot.setOnClickListener(new View.OnClickListener() { // from class: Q7.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5428a.onClearButtonClicked();
            }
        });
        c1299l.setOnClickListener(new View.OnClickListener() { // from class: Q7.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSInputBar._init_$lambda$9(this.f5429a, view);
            }
        });
        applyCapsuleSurface();
        applyIcons();
        applyStartButton();
        applyPressScale();
    }
}
