package com.bytedance.android.ui.ec.widget.ecdraweeview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 Q2\u00020\u0001:\u0001QB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0018\u0010B\u001a\u00020?2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0012\u0010E\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0012\u0010F\u001a\u00020?2\b\u0010G\u001a\u0004\u0018\u00010AH\u0016J&\u0010)\u001a\u00020?2\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u0018J\u001a\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u00020\u00072\n\b\u0002\u0010N\u001a\u0004\u0018\u00010OJ\b\u0010P\u001a\u00020?H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R$\u00104\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR$\u00107\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u0015\u0010:\u001a\u00020\u0007*\u00020;8G¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006R"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "adjustMode", "getAdjustMode", "()I", "setAdjustMode", "(I)V", "autoPlayAnimation", "", "getAutoPlayAnimation", "()Z", "setAutoPlayAnimation", "(Z)V", "borderColor", "getBorderColor", "setBorderColor", "", "borderWidth", "getBorderWidth", "()F", "setBorderWidth", "(F)V", "bottomLeftCornerRadius", "getBottomLeftCornerRadius", "setBottomLeftCornerRadius", "bottomRightCornerRadius", "getBottomRightCornerRadius", "setBottomRightCornerRadius", "controllerListener", "Lcom/facebook/drawee/controller/ControllerListener;", "", "cornerRadius", "getCornerRadius", "setCornerRadius", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "getImageInfo", "()Lcom/facebook/imagepipeline/image/ImageInfo;", "setImageInfo", "(Lcom/facebook/imagepipeline/image/ImageInfo;)V", "roundingParams", "Lcom/facebook/drawee/generic/RoundingParams;", "getRoundingParams", "()Lcom/facebook/drawee/generic/RoundingParams;", "topLeftCornerRadius", "getTopLeftCornerRadius", "setTopLeftCornerRadius", "topRightCornerRadius", "getTopRightCornerRadius", "setTopRightCornerRadius", "dp", "", "getDp", "(Ljava/lang/Number;)I", "addControllerListener", "", "controller", "Lcom/facebook/drawee/interfaces/DraweeController;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeControllerListener", "setController", "draweeController", "topLeftRadius", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "setPlaceholderImage", "resourceId", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "update", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECDraweeView extends GenericDraweeView {
    public static final Companion Companion = null;
    public static final int HEIGHT_SELF_ADJUST = 2;
    public static final int NONE = 0;
    public static final int ROUND = 2000;
    public static final int SELF_ADJUST_1X_TO_DP = 31;
    public static final int SELF_ADJUST_2X_TO_DP = 32;
    public static final int SELF_ADJUST_3X_TO_DP = 33;
    public static final int SELF_ADJUST_PIXEL = 30;
    public static final int SQUARE = 1000;
    public static final int WIDTH_SELF_ADJUST = 1;
    private int adjustMode;
    private boolean autoPlayAnimation;
    private int borderColor;
    private float borderWidth;
    private float bottomLeftCornerRadius;
    private float bottomRightCornerRadius;
    private final ControllerListener<Object> controllerListener;
    private float cornerRadius;
    private ImageInfo imageInfo;
    private final RoundingParams roundingParams;
    private float topLeftCornerRadius;
    private float topRightCornerRadius;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView$Companion;", "", "()V", "HEIGHT_SELF_ADJUST", "", UserProfileEvent.POSITION_NONE, "ROUND", "SELF_ADJUST_1X_TO_DP", "SELF_ADJUST_2X_TO_DP", "SELF_ADJUST_3X_TO_DP", "SELF_ADJUST_PIXEL", "SQUARE", "WIDTH_SELF_ADJUST", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ECDraweeView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void update() {
        float r100 = this.borderWidth;
        if (r100 <= 0) goto L5;
        this.roundingParams.setBorderWidth(r100);
    L5:
        int r101 = this.borderColor;
        if (r101 == (-1)) goto L8;
        this.roundingParams.setBorderColor(r101);
    L8:
        this.roundingParams.setCornersRadii(this.topLeftCornerRadius, this.topRightCornerRadius, this.bottomRightCornerRadius, this.bottomLeftCornerRadius);
        invalidate();
    }

    public final int getAdjustMode() {
        return this.adjustMode;
    }

    public final boolean getAutoPlayAnimation() {
        return this.autoPlayAnimation;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final float getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    public final float getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final ImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final RoundingParams getRoundingParams() {
        return this.roundingParams;
    }

    public final float getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    public final float getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_ecdraweeview_ECDraweeView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void addControllerListener(DraweeController r100) {
        if ((r100 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r100).addControllerListener(this.controllerListener);
        return;
    }

    private final void removeControllerListener(DraweeController r100) {
        if ((r100 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r100).removeControllerListener(this.controllerListener);
        return;
    }

    public final int getDp(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        return (int) TypedValue.applyDimension(1, r100.floatValue(), INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_ecdraweeview_ECDraweeView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()));
    }

    public final void setAdjustMode(int r100) {
        this.adjustMode = r100;
        if (r100 != 2000) goto L6;
        this.roundingParams.setRoundAsCircle(true);
    L6:
        requestLayout();
    }

    public final void setAutoPlayAnimation(boolean r100) {
        this.autoPlayAnimation = r100;
    }

    public final void setBorderColor(int r100) {
        this.borderColor = r100;
        update();
    }

    public final void setBorderWidth(float r100) {
        this.borderWidth = r100;
        update();
    }

    public final void setBottomLeftCornerRadius(float r100) {
        this.bottomLeftCornerRadius = r100;
        update();
    }

    public final void setBottomRightCornerRadius(float r100) {
        this.bottomRightCornerRadius = r100;
        update();
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(DraweeController r100) {
        this.imageInfo = null;
        removeControllerListener(getController());
        addControllerListener(r100);
        super.setController(r100);
    }

    public final void setCornerRadius(float r100) {
        setTopLeftCornerRadius(r100);
        setTopRightCornerRadius(r100);
        setBottomRightCornerRadius(r100);
        setBottomLeftCornerRadius(r100);
        this.cornerRadius = r100;
        update();
    }

    public final void setImageInfo(ImageInfo r100) {
        this.imageInfo = r100;
    }

    public final void setTopLeftCornerRadius(float r100) {
        this.topLeftCornerRadius = r100;
        update();
    }

    public final void setTopRightCornerRadius(float r100) {
        this.topRightCornerRadius = r100;
        update();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        ImageInfo r102 = this.imageInfo;
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.adjustMode == 0) goto L29;
        int r103 = getMeasuredWidth();
        int r104 = getMeasuredHeight();
        int r105 = this.adjustMode;
        if (r105 == 1) goto L25;
        if (r105 == 2) goto L22;
        if (r105 == 1000) goto L20;
        switch(r105) {
            case 30: goto L18;
            case 31: goto L17;
            case 32: goto L16;
            case 33: goto L15;
            default: goto L27;
        };
    L15:
        float r106 = 3;
        int r107 = getDp(Float.valueOf(r102.getHeight() / r106));
        int r108 = getDp(Float.valueOf(r102.getWidth() / r106));
    L19:
        r104 = r107;
        r103 = r108;
        goto L27
    L16:
        float r109 = 2;
        r107 = getDp(Float.valueOf(r102.getHeight() / r109));
        r108 = getDp(Float.valueOf(r102.getWidth() / r109));
        goto L19
    L17:
        r107 = getDp(Integer.valueOf(r102.getHeight()));
        r108 = getDp(Integer.valueOf(r102.getWidth()));
        goto L19
    L18:
        r107 = r102.getHeight();
        r108 = r102.getWidth();
    L27:
        setMeasuredDimension(r103, r104);
        return;
    L20:
        r104 = r103;
        goto L27
    L22:
        if (r102.getWidth() == 0) goto L27;
        r104 = (int) ((r102.getHeight() * (r103 / r102.getWidth())) + 0.5f);
        goto L27
    L25:
        if (r102.getHeight() == 0) goto L27;
        r103 = (int) ((r102.getWidth() * (r104 / r102.getHeight())) + 0.5f);
        goto L27
    }

    public final void setPlaceholderImage(int r100, ScalingUtils.ScaleType r101) {
        getHierarchy().setPlaceholderImage(r100, r101);
    }

    public ECDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.borderColor = -1;
        RoundingParams r103 = new RoundingParams();
        this.roundingParams = r103;
        getHierarchy().setRoundingParams(r103);
        getHierarchy().setFadeDuration(0);
        if (r101 == null) goto L5;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.autoPlayAnimation, R.attr.borderColor, R.attr.borderWidth, R.attr.bottomLeftCornerRadius, R.attr.bottomRightCornerRadius, R.attr.cornerRadius, R.attr.layoutMode, R.attr.topLeftCornerRadius, R.attr.topRightCornerRadius});
        setAdjustMode(r104.getInt(6, 0));
        this.autoPlayAnimation = r104.getBoolean(0, false);
        setCornerRadius(r104.getDimension(5, 0.0f));
        setTopLeftCornerRadius(r104.getDimension(5, this.cornerRadius));
        setTopRightCornerRadius(r104.getDimension(5, this.cornerRadius));
        setBottomRightCornerRadius(r104.getDimension(5, this.cornerRadius));
        setBottomLeftCornerRadius(r104.getDimension(5, this.cornerRadius));
        setBorderWidth(r104.getDimension(2, 0.0f));
        setBorderColor(r104.getColor(1, -1));
        r104.recycle();
    L5:
        this.controllerListener = new ECDraweeView$controllerListener$1(this);
    }

    public final void setCornerRadius(float r100, float r101, float r102, float r103) {
        setTopLeftCornerRadius(r100);
        setTopRightCornerRadius(r101);
        setBottomRightCornerRadius(r102);
        setBottomLeftCornerRadius(r103);
    }

    public /* synthetic */ ECDraweeView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void setPlaceholderImage$default(ECDraweeView r100, int r101, ScalingUtils.ScaleType r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = ScalingUtils.ScaleType.CENTER_INSIDE;
    L6:
        r100.setPlaceholderImage(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPlaceholderImage");
    }
}
