package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.style.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\bX\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\t\u0010\"\u001a\u00020\u0002H\u0096\u0001J-\u0010#\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010%0% &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010'0$H\u0096\u0001J\t\u0010(\u001a\u00020\u0015H\u0096\u0001J\t\u0010)\u001a\u00020\u0003H\u0096\u0001J\t\u0010*\u001a\u00020\nH\u0096\u0001J\t\u0010+\u001a\u00020,H\u0096\u0001J\t\u0010-\u001a\u00020\nH\u0096\u0001J\t\u0010.\u001a\u00020\nH\u0096\u0001J\u0019\u0010/\u001a\u00020\u00182\u000e\u0010\u001e\u001a\n &*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u00100\u001a\u00020\u0011H\u0096\u0001J\t\u00101\u001a\u00020\u0011H\u0096\u0001J\t\u00102\u001a\u00020\u0011H\u0096\u0001J\t\u00103\u001a\u00020\u0011H\u0096\u0001J\t\u00104\u001a\u00020\u0011H\u0096\u0001J \u00105\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\t\u00106\u001a\u00020\u0011H\u0096\u0001J\b\u00107\u001a\u00020\u0011H\u0016J\t\u00108\u001a\u00020\u0011H\u0096\u0001J\b\u00109\u001a\u00020\u0018H\u0014J\b\u0010:\u001a\u00020\u0018H\u0014J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u0011H\u0016J\u0018\u0010=\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\u0011\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\nH\u0096\u0001J!\u0010B\u001a\u00020\u00182\u000e\u0010C\u001a\n &*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0011H\u0096\u0001J!\u0010F\u001a\u00020\u00182\u000e\u0010C\u001a\n &*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\nH\u0014J)\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0096\u0001J)\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0096\u0001J)\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J)\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0096\u0001J\u0019\u0010]\u001a\u00020\u00182\u000e\u0010^\u001a\n &*\u0004\u0018\u00010_0_H\u0096\u0001J\t\u0010`\u001a\u00020\u0018H\u0096\u0001J\u0013\u0010a\u001a\u00020\u00182\b\b\u0001\u0010b\u001a\u00020\nH\u0096\u0001J\u0011\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\nH\u0096\u0001J\u0011\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0011\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010k\u001a\u00020\u00182\u0006\u0010l\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010m\u001a\u00020\u00182\u0006\u0010n\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010o\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011H\u0016J\u0010\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u0011H\u0016J\u0010\u0010s\u001a\u00020\u00112\u0006\u0010t\u001a\u00020\nH\u0016J\u0011\u0010u\u001a\u00020\u00182\u0006\u0010v\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010w\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0011\u0010x\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0096\u0001J\u0011\u0010z\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\u0011H\u0096\u0001J*\u0010|\u001a\u00020\u00182\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u0011H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020\u00182\u0007\u0010\u0084\u0001\u001a\u00020\nH\u0096\u0001J.\u0010\u0083\u0001\u001a\u00020\u00182\u0007\u0010\u0085\u0001\u001a\u00020\n2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0096\u0001J%\u0010\u0089\u0001\u001a\u00020\u00182\u0007\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u00020,H\u0096\u0001J.\u0010\u0089\u0001\u001a\u00020\u00182\u0007\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u00020,H\u0096\u0001J\u0012\u0010\u008d\u0001\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u008e\u0001\u001a\u00020\u00182\u0007\u0010\u008f\u0001\u001a\u00020\u0011H\u0016J-\u0010\u0090\u0001\u001a\u00020\u00182\u000b\b\u0001\u0010\u0091\u0001\u001a\u0004\u0018\u00010%2\u000b\b\u0001\u0010\u0092\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010\u0093\u0001\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0094\u0001\u001a\u00020\u00182\u0007\u0010\u008b\u0001\u001a\u00020,H\u0096\u0001J\u0013\u0010\u0095\u0001\u001a\u00020\u00182\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0096\u0001\u001a\u00020\u00182\u0007\u0010\u0084\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020\u00182\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u0099\u0001\u001a\u00020\u00182\u0007\u0010\u009a\u0001\u001a\u00020\n2\u0007\u0010\u009b\u0001\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u009c\u0001\u001a\u00020\u00182\t\b\u0001\u0010\u009d\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u009e\u0001\u001a\u00020\u00182\u0007\u0010\u009f\u0001\u001a\u00020\u00112\u0007\u0010\u0093\u0001\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010 \u0001\u001a\u00020\u00182\u0007\u0010¡\u0001\u001a\u00020\u0011H\u0096\u0001J\u000f\u0010¢\u0001\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011J\u0012\u0010£\u0001\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\n\u0010¤\u0001\u001a\u00020\u0018H\u0096\u0001J\u000f\u0010¥\u0001\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011J\u0012\u0010¦\u0001\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\nH\u0016J\u0013\u0010¨\u0001\u001a\u00020\u00182\u0007\u0010©\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010ª\u0001\u001a\u00020\u0011H\u0096\u0001J*\u0010«\u0001\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0096\u0001J\u0012\u0010¬\u0001\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u00ad\u0001\u001a\u00020\u00182\u0007\u0010®\u0001\u001a\u00020,H\u0096\u0001J*\u0010¯\u0001\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0096\u0001J\u0012\u0010°\u0001\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0096\u0001J*\u0010±\u0001\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J\u0012\u0010²\u0001\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0096\u0001J;\u0010³\u0001\u001a\u00020\u00182/\b\u0001\u0010´\u0001\u001a(\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u0001 &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010'0$H\u0096\u0001J*\u0010µ\u0001\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0096\u0001J\u0012\u0010¶\u0001\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0096\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Lcom/obric/oui/layout/OUIConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "provider", "Lcom/obric/oui/common/style/OUIStyleProvider;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/common/style/OUIStyleProvider;)V", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mIsFakePressed", "", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "decideIsNeedUpdatePressedForegroundBySelf", "disablePressReleaseAnim", "", "disable", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "draw", "getAlphaHelper", "getCurrentShadows", "", "Lcom/obric/oui/common/style/Shadow;", "kotlin.jvm.PlatformType", "", "getEffectHelper", "getLayoutHelper", "getRadius", "getShadowAlpha", "", "getShadowColor", "getShadowElevation", "handleTouchEvent", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "init", "isEnableShadowWidthRadius", "isFakePressed", "isShadowVisible", "onAttachedToWindow", "onDetachedFromWindow", "onHoverChanged", "hovered", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPressAlphaChange", "alpha", "onPressedChanged", PerfConsts.KEY_CURRENT_GALVANIC, "Landroid/view/View;", "pressed", "onSelectedChanged", "onWindowVisibilityChanged", "visibility", "onlyShowBottomDivider", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowLeftDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowRightDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowTopDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "refreshColors", "scene", "", "resetAlphaAnim", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBottomDividerAlpha", "dividerAlpha", "setChangeAlphaWhenDisable", "changeAlphaWhenDisable", "setChangeAlphaWhenPress", "changeAlphaWhenPress", "setChangeAlphaWhenSelected", "changeAlphaWhenSelected", "setEnableShadowWidthRadius", "enableShadowWidthRadius", "setEnabled", "enabled", "setFakePressed", "fakePressed", "setHeightLimit", "heightLimit", "setKeepPressAlpha", "keep", "setLeftDividerAlpha", "setOuterNormalColor", "color", "setOutlineExcludePadding", "outlineExcludePadding", "setOutlineInset", "left", "top", "right", "bottom", "setOverridePressColor", "setPressed", "setRadius", "radius", "tlRadius", "trRadius", "blRadius", "brRadius", "setRadiusAndShadow", "shadowElevation", "shadowAlpha", "shadowColor", "setRightDividerAlpha", "setSelected", "selected", "setShadow", "firstShadow", "secondShadow", "animate", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "setShadowElevation", "elevation", "setShadowInsets", "insetX", "insetY", "setShadowStyle", "styleResId", "setShadowVisible", "visible", "setShowBorderOnlyBeforeL", "showBorderOnlyBeforeL", "setSoundEffectEnabled", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "setVibrateEnabled", "setWidthLimit", "widthLimit", "setWidthMin", "minWidth", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "updateDividerColorStrength", "strength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateShadows", "shadows", "updateTopDivider", "updateTopSeparatorColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OUIConstraintLayout extends ConstraintLayout implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    private final /* synthetic */ IOUIAlpha $$delegate_0;
    private final /* synthetic */ IOUILayout $$delegate_1;
    private final /* synthetic */ OUIStyleProvider $$delegate_2;

    @Nullable
    private OUIAlphaHelper mAlphaHelper;
    private boolean mIsFakePressed;

    @Nullable
    private OUILayoutHelper mLayoutHelper;

    @Nullable
    private OUIEffectHelper mOUIEffectHelper;

    @JvmOverloads
    public OUIConstraintLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 14, null);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    public void disablePressReleaseAnim(boolean r10) {
        this.$$delegate_0.disablePressReleaseAnim(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas r10) {
        q.g(r10, "canvas");
        super.dispatchDraw(r10);
        OUILayoutHelper r11 = this.mLayoutHelper;
        if (r11 == null) goto L6;
        r11.s(r10, getWidth(), getHeight());
    L6:
        OUILayoutHelper r12 = this.mLayoutHelper;
        if (r12 == null) goto L11;
        r12.q(r10);
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(@NotNull MotionEvent r10) {
        q.g(r10, "event");
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L7;
        r11.dispatchGenericMotionEvent(r10);
    L7:
        return super.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "event");
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L6;
        r11.dispatchTouchEvent(r10);
    L6:
        OUIAlphaHelper r12 = this.mAlphaHelper;
        if (r12 == null) goto L11;
        r12.handleTouchEvent(r10);
    L11:
        return super.dispatchTouchEvent(r10);
    }

    @Override // android.view.View
    @RequiresApi(26)
    public void draw(@NotNull Canvas r10) {
        q.g(r10, "canvas");
        OUILayoutHelper r11 = this.mLayoutHelper;
        if (r11 == null) goto L6;
        r11.r(r10);
    L6:
        super.draw(r10);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.$$delegate_2.getAlphaHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        return this.$$delegate_1.getCurrentShadows();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.$$delegate_2.getEffectHelper();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.$$delegate_2.getLayoutHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.$$delegate_1.getRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.$$delegate_1.getShadowAlpha();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.$$delegate_1.getShadowColor();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.$$delegate_1.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r10) {
        this.$$delegate_0.handleTouchEvent(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        return this.$$delegate_1.hasBorder();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        return this.$$delegate_1.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        return this.$$delegate_1.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        return this.$$delegate_1.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        return this.$$delegate_1.hasTopSeparator();
    }

    public final void init(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.$$delegate_1.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isFakePressed() {
        return this.mIsFakePressed;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.$$delegate_1.isShadowVisible();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OUIEffectHelper r10 = this.mOUIEffectHelper;
        if (r10 == null) goto L7;
        r10.k();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OUIEffectHelper r10 = this.mOUIEffectHelper;
        if (r10 == null) goto L7;
        r10.l();
        return;
    }

    @Override // android.view.View
    public void onHoverChanged(boolean r10) {
        super.onHoverChanged(r10);
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L7;
        r11.m(r10);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        OUILayoutHelper r12 = this.mLayoutHelper;
        if (r12 == null) goto L8;
        q.d(r12);
        int r13 = r12.A(r10);
        OUILayoutHelper r14 = this.mLayoutHelper;
        q.d(r14);
        int r15 = r14.z(r11);
        super.onMeasure(r13, r15);
        OUILayoutHelper r16 = this.mLayoutHelper;
        q.d(r16);
        int r17 = r16.D(r13, getMeasuredWidth());
        OUILayoutHelper r18 = this.mLayoutHelper;
        q.d(r18);
        int r19 = r18.C(r15, getMeasuredHeight());
        if (r13 != r17) goto L7;
        if (r15 != r19) goto L7;
        return;
    L7:
        super.onMeasure(r17, r19);
        return;
    L8:
        super.onMeasure(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r10) {
        this.$$delegate_1.onPressAlphaChange(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r10, boolean r11) {
        this.$$delegate_0.onPressedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r10, boolean r11) {
        this.$$delegate_0.onSelectedChanged(r10, r11);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L7;
        r11.q(r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowTopDivider(r10, r11, r12, r13);
    }

    public void refreshColors(String r10) {
        this.$$delegate_0.refreshColors(r10);
    }

    public void resetAlphaAnim() {
        this.$$delegate_0.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(@ColorInt int r10) {
        this.$$delegate_1.setBorderColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r10) {
        this.$$delegate_1.setBorderWidth(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r10) {
        this.$$delegate_1.setBottomDividerAlpha(r10);
    }

    public void setChangeAlphaWhenDisable(boolean r10) {
        this.$$delegate_0.setChangeAlphaWhenDisable(r10);
    }

    public void setChangeAlphaWhenPress(boolean r10) {
        this.$$delegate_0.setChangeAlphaWhenPress(r10);
    }

    public void setChangeAlphaWhenSelected(boolean r10) {
        this.$$delegate_0.setChangeAlphaWhenSelected(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r10) {
        this.$$delegate_1.setEnableShadowWidthRadius(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        OUIAlphaHelper r11 = this.mAlphaHelper;
        if (r11 == null) goto L7;
        r11.o(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setFakePressed(boolean r10) {
        if (this.mIsFakePressed == r10) goto L13;
        this.mIsFakePressed = r10;
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L8;
        r11.s(r10);
    L8:
        OUIAlphaHelper r12 = this.mAlphaHelper;
        if (r12 == null) goto L14;
        r12.onPressedChanged(this, this.mIsFakePressed);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r10) {
        OUILayoutHelper r11 = this.mLayoutHelper;
        if (r11 == null) goto L8;
        q.d(r11);
        if (r11.setHeightLimit(r10) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public void setKeepPressAlpha(boolean r10) {
        this.$$delegate_0.setKeepPressAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r10) {
        this.$$delegate_1.setLeftDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r10) {
        this.$$delegate_1.setOuterNormalColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r10) {
        this.$$delegate_1.setOutlineExcludePadding(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.setOutlineInset(r10, r11, r12, r13);
    }

    public void setOverridePressColor(int r10) {
        this.$$delegate_0.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L6;
        r11.s(r10);
    L6:
        super.setPressed(r10);
        OUIAlphaHelper r12 = this.mAlphaHelper;
        if (r12 == null) goto L11;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10) {
        this.$$delegate_1.setRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.$$delegate_1.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r10) {
        this.$$delegate_1.setRightDividerAlpha(r10);
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        OUIAlphaHelper r11 = this.mAlphaHelper;
        if (r11 == null) goto L7;
        r11.onSelectedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(@androidx.annotation.Nullable @Nullable Shadow r10, @androidx.annotation.Nullable @Nullable Shadow r11, boolean r12) {
        this.$$delegate_1.setShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r10) {
        this.$$delegate_1.setShadowAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r10) {
        this.$$delegate_1.setShadowColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r10) {
        this.$$delegate_1.setShadowCornerRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r10) {
        this.$$delegate_1.setShadowElevation(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r10, int r11) {
        this.$$delegate_1.setShadowInsets(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(@StyleRes int r10) {
        this.$$delegate_1.setShadowStyle(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r10, boolean r11) {
        this.$$delegate_1.setShadowVisible(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.$$delegate_1.setShowBorderOnlyBeforeL(r10);
    }

    public final void setSoundEffectEnabled(boolean r10) {
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L7;
        r11.t(r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r10) {
        this.$$delegate_1.setTopDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.$$delegate_1.setUseThemeGeneralShadowElevation();
    }

    public final void setVibrateEnabled(boolean r10) {
        OUIEffectHelper r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L7;
        r11.u(r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r10) {
        OUILayoutHelper r11 = this.mLayoutHelper;
        if (r11 == null) goto L8;
        q.d(r11);
        if (r11.setWidthLimit(r10) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r10) {
        this.$$delegate_1.setWidthMin(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return this.$$delegate_1.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r10) {
        this.$$delegate_1.updateBottomSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r10) {
        this.$$delegate_1.updateDividerColorStrength(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r10) {
        this.$$delegate_1.updateLeftSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r10) {
        this.$$delegate_1.updateRightSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(@androidx.annotation.Nullable @Nullable List<Shadow> r10) {
        this.$$delegate_1.updateShadows(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r10) {
        this.$$delegate_1.updateTopSeparatorColor(r10);
    }

    @JvmOverloads
    public OUIConstraintLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 12, null);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.setRadius(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.$$delegate_1.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @JvmOverloads
    public OUIConstraintLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OUIConstraintLayout(Context r10, AttributeSet r11, int r12, OUIStyleProvider r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = new OUIStyleProvider(r10, r11, r12, 0);
    L11:
        this(r10, r11, r12, r13);
    }

    public OUIConstraintLayout(Context r10, AttributeSet r11, int r12, OUIStyleProvider r13) {
        q.g(r10, "context");
        q.g(r13, "provider");
        super(r10, r11);
        this.$$delegate_0 = r13.getAlphaHelper();
        this.$$delegate_1 = r13.getLayoutHelper();
        this.$$delegate_2 = r13;
        r13.a(this);
        this.mLayoutHelper = (OUILayoutHelper) getLayoutHelper();
        this.mAlphaHelper = (OUIAlphaHelper) getAlphaHelper();
        this.mOUIEffectHelper = getEffectHelper();
        init(r10, r11, r12);
    }
}
