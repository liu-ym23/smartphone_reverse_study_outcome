package com.bytedance.android.livehostapi.business.depend.openplatform.dux;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0002lmB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R-\u0010;\u001a\u0015\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00102\"\u0004\b?\u00104R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER-\u0010F\u001a\u0015\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00102\"\u0004\bI\u00104R-\u0010J\u001a\u0015\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00102\"\u0004\bL\u00104R\u001c\u0010M\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010C\"\u0004\bO\u0010ER(\u0010P\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00102\"\u0004\bR\u00104R\u001c\u0010S\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00108\"\u0004\bU\u0010:R-\u0010V\u001a\u0015\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00102\"\u0004\bX\u00104R-\u0010Y\u001a\u0015\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00102\"\u0004\b\\\u00104R\u001c\u0010]\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010C\"\u0004\b_\u0010ER\u001a\u0010`\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0018\"\u0004\bb\u0010\u001aR\u001e\u0010c\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bd\u0010#\"\u0004\be\u0010%R\u001a\u0010f\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u001e\"\u0004\bh\u0010 R\u001a\u0010i\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u001e\"\u0004\bk\u0010 ¨\u0006n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig;", "", "()V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "callback", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$Callback;", "getCallback", "()Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$Callback;", "setCallback", "(Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$Callback;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "enableAutoDismiss", "", "getEnableAutoDismiss", "()Z", "setEnableAutoDismiss", "(Z)V", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "getGravity", "()I", "setGravity", "(I)V", "height", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hideCallback", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$HideCallback;", "getHideCallback", "()Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$HideCallback;", "setHideCallback", "(Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$HideCallback;)V", "leftAction", "Lkotlin/Function1;", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/ILiveDuxPopupNotice;", "", "getLeftAction", "()Lkotlin/jvm/functions/Function1;", "setLeftAction", "(Lkotlin/jvm/functions/Function1;)V", "leftIcon", "Landroid/graphics/drawable/Drawable;", "getLeftIcon", "()Landroid/graphics/drawable/Drawable;", "setLeftIcon", "(Landroid/graphics/drawable/Drawable;)V", "leftIconAttrs", "Landroid/widget/ImageView;", "Lkotlin/ExtensionFunctionType;", "getLeftIconAttrs", "setLeftIconAttrs", "leftSubTitle", "", "getLeftSubTitle", "()Ljava/lang/String;", "setLeftSubTitle", "(Ljava/lang/String;)V", "leftSubTitleAttrs", "Landroid/widget/TextView;", "getLeftSubTitleAttrs", "setLeftSubTitleAttrs", "leftTextAttrs", "getLeftTextAttrs", "setLeftTextAttrs", "leftTitle", "getLeftTitle", "setLeftTitle", "rightAction", "getRightAction", "setRightAction", "rightIcon", "getRightIcon", "setRightIcon", "rightIconAttrs", "getRightIconAttrs", "setRightIconAttrs", "rightTextAttrs", "Landroid/widget/Button;", "getRightTextAttrs", "setRightTextAttrs", "rightTitle", "getRightTitle", "setRightTitle", "useButtonStyleAtEnd", "getUseButtonStyleAtEnd", "setUseButtonStyleAtEnd", "width", "getWidth", "setWidth", "xOffset", "getXOffset", "setXOffset", "yOffset", "getYOffset", "setYOffset", "Callback", "HideCallback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DuxPopupNoticeConfig {
    private View anchorView;
    private Callback callback;
    private long duration;
    private boolean enableAutoDismiss;
    private int gravity;
    private Integer height;
    private HideCallback hideCallback;
    private Function1<? super ILiveDuxPopupNotice, Unit> leftAction;
    private Drawable leftIcon;
    private Function1<? super ImageView, Unit> leftIconAttrs;
    private String leftSubTitle;
    private Function1<? super TextView, Unit> leftSubTitleAttrs;
    private Function1<? super TextView, Unit> leftTextAttrs;
    private String leftTitle;
    private Function1<? super ILiveDuxPopupNotice, Unit> rightAction;
    private Drawable rightIcon;
    private Function1<? super ImageView, Unit> rightIconAttrs;
    private Function1<? super Button, Unit> rightTextAttrs;
    private String rightTitle;
    private boolean useButtonStyleAtEnd;
    private Integer width;
    private int xOffset;
    private int yOffset;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$Callback;", "", "beforeHide", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/ILiveDuxPopupNotice;", "beforeShow", "onHide", SendEventContainerMethodParamModel.EventKinds.onShow, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {

        /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig$Callback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$beforeHide(Callback r100, ILiveDuxPopupNotice r101) {
                Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            }

            public static void $default$beforeShow(Callback r100, ILiveDuxPopupNotice r101) {
                Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            }

            public static /* synthetic */ void access$beforeHide$jd(Callback r100, ILiveDuxPopupNotice r101) {
                $default$beforeHide(r100, r101);
            }

            public static /* synthetic */ void access$beforeShow$jd(Callback r100, ILiveDuxPopupNotice r101) {
                $default$beforeShow(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void beforeHide(Callback r100, ILiveDuxPopupNotice r101) {
                CC.access$beforeHide$jd(r100, r101);
            }

            public static void beforeShow(Callback r100, ILiveDuxPopupNotice r101) {
                CC.access$beforeShow$jd(r100, r101);
            }
        }

        void beforeHide(ILiveDuxPopupNotice r100);

        void beforeShow(ILiveDuxPopupNotice r100);

        void onHide(ILiveDuxPopupNotice r100);

        void onShow(ILiveDuxPopupNotice r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/DuxPopupNoticeConfig$HideCallback;", "", "beforeHide", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lcom/bytedance/android/livehostapi/business/depend/openplatform/dux/ILiveDuxPopupNotice;", "reason", "", "onHide", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface HideCallback {

        /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig$HideCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$beforeHide(HideCallback r100, ILiveDuxPopupNotice r101, int r102) {
                Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            }

            public static /* synthetic */ void access$beforeHide$jd(HideCallback r100, ILiveDuxPopupNotice r101, int r102) {
                $default$beforeHide(r100, r101, r102);
            }
        }

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void beforeHide(HideCallback r100, ILiveDuxPopupNotice r101, int r102) {
                CC.access$beforeHide$jd(r100, r101, r102);
            }
        }

        void beforeHide(ILiveDuxPopupNotice r100, int r101);

        void onHide(ILiveDuxPopupNotice r100, int r101);
    }

    public DuxPopupNoticeConfig() {
        this.gravity = 81;
        this.yOffset = MathKt.roundToInt(TypedValue.applyDimension(1, 12, INVOKEVIRTUAL_com_bytedance_android_livehostapi_business_depend_openplatform_dux_DuxPopupNoticeConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.duration = 5000;
        this.enableAutoDismiss = true;
    }

    public final View getAnchorView() {
        return this.anchorView;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getEnableAutoDismiss() {
        return this.enableAutoDismiss;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final HideCallback getHideCallback() {
        return this.hideCallback;
    }

    public final Function1<ILiveDuxPopupNotice, Unit> getLeftAction() {
        return this.leftAction;
    }

    public final Drawable getLeftIcon() {
        return this.leftIcon;
    }

    public final Function1<ImageView, Unit> getLeftIconAttrs() {
        return this.leftIconAttrs;
    }

    public final String getLeftSubTitle() {
        return this.leftSubTitle;
    }

    public final Function1<TextView, Unit> getLeftSubTitleAttrs() {
        return this.leftSubTitleAttrs;
    }

    public final Function1<TextView, Unit> getLeftTextAttrs() {
        return this.leftTextAttrs;
    }

    public final String getLeftTitle() {
        return this.leftTitle;
    }

    public final Function1<ILiveDuxPopupNotice, Unit> getRightAction() {
        return this.rightAction;
    }

    public final Drawable getRightIcon() {
        return this.rightIcon;
    }

    public final Function1<ImageView, Unit> getRightIconAttrs() {
        return this.rightIconAttrs;
    }

    public final Function1<Button, Unit> getRightTextAttrs() {
        return this.rightTextAttrs;
    }

    public final String getRightTitle() {
        return this.rightTitle;
    }

    public final boolean getUseButtonStyleAtEnd() {
        return this.useButtonStyleAtEnd;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final int getXOffset() {
        return this.xOffset;
    }

    public final int getYOffset() {
        return this.yOffset;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_livehostapi_business_depend_openplatform_dux_DuxPopupNoticeConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setAnchorView(View r100) {
        this.anchorView = r100;
    }

    public final void setCallback(Callback r100) {
        this.callback = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setEnableAutoDismiss(boolean r100) {
        this.enableAutoDismiss = r100;
    }

    public final void setGravity(int r100) {
        this.gravity = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setHideCallback(HideCallback r100) {
        this.hideCallback = r100;
    }

    public final void setLeftAction(Function1<? super ILiveDuxPopupNotice, Unit> r100) {
        this.leftAction = r100;
    }

    public final void setLeftIcon(Drawable r100) {
        this.leftIcon = r100;
    }

    public final void setLeftIconAttrs(Function1<? super ImageView, Unit> r100) {
        this.leftIconAttrs = r100;
    }

    public final void setLeftSubTitle(String r100) {
        this.leftSubTitle = r100;
    }

    public final void setLeftSubTitleAttrs(Function1<? super TextView, Unit> r100) {
        this.leftSubTitleAttrs = r100;
    }

    public final void setLeftTextAttrs(Function1<? super TextView, Unit> r100) {
        this.leftTextAttrs = r100;
    }

    public final void setLeftTitle(String r100) {
        this.leftTitle = r100;
    }

    public final void setRightAction(Function1<? super ILiveDuxPopupNotice, Unit> r100) {
        this.rightAction = r100;
    }

    public final void setRightIcon(Drawable r100) {
        this.rightIcon = r100;
    }

    public final void setRightIconAttrs(Function1<? super ImageView, Unit> r100) {
        this.rightIconAttrs = r100;
    }

    public final void setRightTextAttrs(Function1<? super Button, Unit> r100) {
        this.rightTextAttrs = r100;
    }

    public final void setRightTitle(String r100) {
        this.rightTitle = r100;
    }

    public final void setUseButtonStyleAtEnd(boolean r100) {
        this.useButtonStyleAtEnd = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public final void setXOffset(int r100) {
        this.xOffset = r100;
    }

    public final void setYOffset(int r100) {
        this.yOffset = r100;
    }
}
