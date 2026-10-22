package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.color.i0;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.o;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u001fJ\u00ad\u0001\u00103\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010&2\n\b\u0002\u00100\u001a\u0004\u0018\u00010&2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b3\u00104J\u0019\u00107\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0002H\u0016¢\u0006\u0004\b=\u0010>J\u0019\u0010?\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b?\u00108J\u0019\u0010@\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b@\u00108JS\u0010G\u001a\u00020\u00072\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010B\u001a\u00020\u000e2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010E\u001a\u00020\u000e2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\bG\u0010HJS\u0010G\u001a\u00020\u00072\n\b\u0002\u0010I\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010B\u001a\u00020\u000e2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010E\u001a\u00020\u000e2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\bG\u0010KJ\u000f\u0010L\u001a\u00020\u0002H\u0016¢\u0006\u0004\bL\u0010\u0004J\u000f\u0010M\u001a\u00020\u000eH\u0016¢\u0006\u0004\bM\u0010\u0010J\u0011\u0010N\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\bN\u0010OJ\u0011\u0010P\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\bP\u0010OJ\u0011\u0010Q\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\bQ\u0010OJ\u0011\u0010R\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\bR\u0010OJ\u0017\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u000eH\u0016¢\u0006\u0004\bT\u0010\u001fJ\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u0013J\u000f\u0010V\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010\u0013J\u000f\u0010W\u001a\u00020\u0007H\u0016¢\u0006\u0004\bW\u0010\u0013J\u000f\u0010X\u001a\u00020\u0007H\u0016¢\u0006\u0004\bX\u0010\u0013J\u000f\u0010Y\u001a\u00020\u0007H\u0016¢\u0006\u0004\bY\u0010\u0013J\u000f\u0010Z\u001a\u00020\u0007H\u0016¢\u0006\u0004\bZ\u0010\u0013J'\u0010_\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020[2\u0006\u0010^\u001a\u00020\u000eH\u0016¢\u0006\u0004\b_\u0010`J\u001f\u0010c\u001a\u00020\u00072\u0006\u0010a\u001a\u00020[2\u0006\u0010b\u001a\u00020[H\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0007H\u0016¢\u0006\u0004\be\u0010\u0013J\u0019\u0010f\u001a\u00020\u00072\b\b\u0002\u0010b\u001a\u00020[H\u0016¢\u0006\u0004\bf\u0010gJ#\u0010j\u001a\u00028\u0000\"\b\b\u0000\u0010h*\u0002052\b\b\u0001\u0010i\u001a\u00020\u0002H&¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\u0007H\u0016¢\u0006\u0004\bl\u0010\u0013J\u0017\u0010n\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u000eH\u0016¢\u0006\u0004\bn\u0010\u001fJ\u000f\u0010o\u001a\u00020\u0007H&¢\u0006\u0004\bo\u0010\u0013J\u000f\u0010p\u001a\u00020\u000eH\u0016¢\u0006\u0004\bp\u0010\u0010R\u0014\u0010s\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u001c\u0010y\u001a\u00020t8&@&X¦\u000e¢\u0006\f\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010\u007f\u001a\u00020z8&@&X¦\u000e¢\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\"\u0010\u0085\u0001\u001a\u00030\u0080\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001f\u0010\u0088\u0001\u001a\u00020\u00028&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010\u0004\"\u0005\b\u0087\u0001\u0010>R\u001f\u0010\u008b\u0001\u001a\u00020\u00028&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010\u0004\"\u0005\b\u008a\u0001\u0010>R\u001f\u0010\u008e\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010\u0010\"\u0005\b\u008d\u0001\u0010\u001fR\u001f\u0010\u0091\u0001\u001a\u0002058&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0001\u0010O\"\u0005\b\u0090\u0001\u00108R\"\u0010\u0094\u0001\u001a\u00030\u0080\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0092\u0001\u0010\u0082\u0001\"\u0006\b\u0093\u0001\u0010\u0084\u0001R\"\u0010\u009a\u0001\u001a\u00030\u0095\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\"\u0010\u009d\u0001\u001a\u00030\u0080\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u009b\u0001\u0010\u0082\u0001\"\u0006\b\u009c\u0001\u0010\u0084\u0001R\u001f\u0010\u009e\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u009e\u0001\u0010\u0010\"\u0005\b\u009f\u0001\u0010\u001fR \u0010£\u0001\u001a\u00020\u00198&@&X¦\u000e¢\u0006\u000f\u001a\u0006\b \u0001\u0010¡\u0001\"\u0005\b¢\u0001\u0010\u001cR\u001f\u0010¦\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¤\u0001\u0010\u0010\"\u0005\b¥\u0001\u0010\u001fR#\u0010«\u0001\u001a\u0004\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001f\u0010®\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¬\u0001\u0010\u0010\"\u0005\b\u00ad\u0001\u0010\u001fR\u001f\u0010±\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¯\u0001\u0010\u0010\"\u0005\b°\u0001\u0010\u001fR\u001f\u0010´\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b²\u0001\u0010\u0010\"\u0005\b³\u0001\u0010\u001fR\u001f\u0010·\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bµ\u0001\u0010\u0010\"\u0005\b¶\u0001\u0010\u001fR$\u0010½\u0001\u001a\u0005\u0018\u00010¸\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R \u0010Á\u0001\u001a\u00020[8&@&X¦\u000e¢\u0006\u000f\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0005\bÀ\u0001\u0010gR \u0010Ä\u0001\u001a\u00020[8&@&X¦\u000e¢\u0006\u000f\u001a\u0006\bÂ\u0001\u0010¿\u0001\"\u0005\bÃ\u0001\u0010gR\u001f\u0010Ç\u0001\u001a\u00020\u00028&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÅ\u0001\u0010\u0004\"\u0005\bÆ\u0001\u0010>R\u001f\u0010Ê\u0001\u001a\u00020\u00028&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÈ\u0001\u0010\u0004\"\u0005\bÉ\u0001\u0010>R\"\u0010Ð\u0001\u001a\u00030Ë\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u001f\u0010Ó\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÑ\u0001\u0010\u0010\"\u0005\bÒ\u0001\u0010\u001fR\u001f\u0010Ö\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÔ\u0001\u0010\u0010\"\u0005\bÕ\u0001\u0010\u001fR\u001f\u0010Ù\u0001\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b×\u0001\u0010\u0010\"\u0005\bØ\u0001\u0010\u001fR\"\u0010ß\u0001\u001a\u00030Ú\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R\u001f\u0010â\u0001\u001a\u00020\u00028&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bà\u0001\u0010\u0004\"\u0005\bá\u0001\u0010>¨\u0006ã\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetBase;", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "", "getContentLayoutResId", "()I", "Landroid/content/Context;", "context", "", "setupView", "(Landroid/content/Context;)V", "setupDimView", "Landroid/view/Window;", "windowForAnim", "()Landroid/view/Window;", "", "useWindowDim", "()Z", "needDimAnim", "onShowAnimStart", "()V", "onShowAnimEnd", "onDismissAnimStart", "onDismissAnimEnd", "onDismissComplete", "updateFullWindowSize", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", Style.KEY_HEIGHT, "setHeightMode", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "ignore", "enableIgnoreInsetBottom", "(Z)V", "enable", "setOverlayModeAutoBodyPaddingTopEnabled", "Lcom/obric/oui/sheet/v2/OSheet$Header;", "style", "titleResId", "subTitleResId", "", "title", "subTitle", "showHandleView", "Landroid/view/View$OnClickListener;", "startActionEvent", "endActionEvent", "startActionDesResId", "endActionDesResId", "startActionDes", "endActionDesRes", "startActionIconResId", "endActionIconResId", "setHeader", "(Lcom/obric/oui/sheet/v2/OSheet$Header;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/view/View;", "child", "setHeaderView", "(Landroid/view/View;)V", "Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "getHeaderTitleBar", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "color", "setSheetBgColor", "(I)V", "setBodyView", "setFooterView", "negativeBtnTextResId", "negativeIsPrimary", "negativeActionEvent", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "setFooterButton", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "negativeBtnText", "positiveBtnText", "(Ljava/lang/String;ZLandroid/view/View$OnClickListener;Ljava/lang/String;ZLandroid/view/View$OnClickListener;)V", "getMaxBodyHeight", "isRootContainerMaxHeight", "getStartActionButton", "()Landroid/view/View;", "getEndActionButton", "getNegativeButton", "getPositiveButton", "cancel", "setCanceledOnTouchOutside", "calculateBodyMaxHeight", "setOnApplyWindowInsetsListener", "removeOnApplyWindowInsetsListener", "onPostShow", "registerConfigurationCallbackIfNeeded", "unregisterConfigurationCallbackIfNeeded", "", "dx", "dy", "start", "move", "(FFZ)V", "xVelocity", "yVelocity", "fling", "(FF)V", "performEnterAnimation", "performExitAnimation", "(F)V", "T", "id", "getViewById", "(I)Landroid/view/View;", "initBgColor", "fromWindow", "applyMaterial", "updateMaterial", "isDarkTheme", "getSheetContext", "()Landroid/content/Context;", "sheetContext", "Lcom/obric/oui/sheet/v2/h;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/h;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/h;)V", "scaffoldController", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "setBodyContainer", "(Landroid/widget/FrameLayout;)V", "bodyContainer", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "bodyContentPaddingTop", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingBottom", "getAutoAddBodyPaddingTopWhenOverlay", "setAutoAddBodyPaddingTopWhenOverlay", "autoAddBodyPaddingTopWhenOverlay", "getDimView", "setDimView", "dimView", "getHeaderContainer", "setHeaderContainer", "headerContainer", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldContainer", "getFooterContainer", "setFooterContainer", "footerContainer", "isContentOverlayMode", "setContentOverlayMode", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "heightStyle", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "ignoreInsetBottom", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "(Ljava/lang/Boolean;)V", "systemInsetsAppearanceLightValue", "getMCancelable", "setMCancelable", "mCancelable", "getMClearDimFlag", "setMClearDimFlag", "mClearDimFlag", "getEnableDimAnim", "setEnableDimAnim", "enableDimAnim", "getEnableEnterAnim", "setEnableEnterAnim", "enableEnterAnim", "Ljb/d;", "getRunningAnim", "()Ljb/d;", "setRunningAnim", "(Ljb/d;)V", "runningAnim", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "rootTransMoveStartX", "getRootTransMoveStartY", "setRootTransMoveStartY", "rootTransMoveStartY", "getUserWindowWidth", "setUserWindowWidth", "userWindowWidth", "getUserWindowHeight", "setUserWindowHeight", "userWindowHeight", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "fullWindowSize", "getEnableMaterial", "setEnableMaterial", "enableMaterial", "getShowing", "setShowing", "showing", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationCallbackRegistered", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallback", "getBgColor", "setBgColor", Style.KEY_BG_COLOR, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OSheetBase extends SheetMoveDelegate {

    public static final class DefaultImpls {
        public static void A(OSheetBase r10, boolean r11) {
            q.g(r10, "this");
            r10.setMCancelable(r11);
        }

        public static void B(OSheetBase r10, Integer r11, boolean r12, View.OnClickListener r13, Integer r14, boolean r15, View.OnClickListener r16) {
            q.g(r10, "this");
            r10.getScaffoldController().m(r11, r12, r13, r14, r15, r16);
        }

        public static void C(OSheetBase r10, String r11, boolean r12, View.OnClickListener r13, String r14, boolean r15, View.OnClickListener r16) {
            q.g(r10, "this");
            r10.getScaffoldController().n(r11, r12, r13, r14, r15, r16);
        }

        public static void D(OSheetBase r10, View r11) {
            q.g(r10, "this");
            r10.getScaffoldController().o(r11);
        }

        public static void E(OSheetBase r17, OSheet.Header r18, Integer r19, Integer r20, String r21, String r22, boolean r23, View.OnClickListener r24, View.OnClickListener r25, Integer r26, Integer r27, String r28, String r29, Integer r30, Integer r31) {
            q.g(r17, "this");
            q.g(r18, "style");
            r17.getScaffoldController().p(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r17);
        }

        public static void F(OSheetBase r10, View r11) {
            q.g(r10, "this");
            r10.getScaffoldController().q(r11);
        }

        public static void G(OSheetBase r10, OSheet.HeightMode r11) {
            q.g(r10, "this");
            q.g(r11, Style.KEY_HEIGHT);
            r10.setHeightStyle(r11);
            r10.getScaffoldController().r(r11);
            r10.getScaffoldController().y();
        }

        public static void H(OSheetBase r10) {
            q.g(r10, "this");
            r10.getScaffoldController().t();
        }

        public static void I(OSheetBase r10, boolean r11) {
            q.g(r10, "this");
            if (r10.getAutoAddBodyPaddingTopWhenOverlay() == r11) goto L8;
            r10.setAutoAddBodyPaddingTopWhenOverlay(r11);
            if (r10.getShowing() == false) goto L9;
            r10.onPostShow();
            return;
        L9:
            return;
        }

        public static void J(OSheetBase r10, int r11) {
            q.g(r10, "this");
            if (r10.getBgColor() == r11) goto L17;
            boolean r12 = r10.isDarkTheme();
            r10.setBgColor(r11);
            boolean r13 = r10.isDarkTheme();
            if (r10.getEnableMaterial() == true) goto L7;
            r10.getRootContainer().setBackgroundColor(r11);
        L8:
            if (r12 == r13) goto L18;
            View r14 = r10.getScaffoldController().d().getChildAt(0);
            if ((r14 instanceof OSheetTitleBar) == false) goto L19;
            OSheetTitleBar r15 = (OSheetTitleBar) r14;
            if (r13 == false) goto L14;
            int r16 = 2;
        L15:
            r15.applyDynamicTheme(r16);
            return;
        L14:
            r16 = 1;
            goto L15
        L19:
            return;
        L18:
            return;
        L7:
            r10.updateMaterial();
            goto L8
        }

        public static void K(OSheetBase r10, Context r11) {
            q.g(r10, "this");
            q.g(r11, "context");
            r10.setRootContainer((RadiusLayout) r10.getViewById(R$id.root_constraint));
            r10.setupDimView(r11);
            r10.setHeaderContainer((FrameLayout) r10.getViewById(R$id.header_container));
            r10.setBodyContainer((FrameLayout) r10.getViewById(R$id.body_container));
            r10.setFooterContainer((FrameLayout) r10.getViewById(R$id.footer_container));
            r10.setScaffoldContainer((ViewGroup) r10.getViewById(R$id.scaffold_container));
            r10.updateFullWindowSize();
            r10.setScaffoldController(new h(r11, r10, r10.getRootContainer(), r10.getHeaderContainer(), r10.getBodyContainer(), r10.getFooterContainer(), r10.getScaffoldContainer(), r10.getDimView()));
            r10.getScaffoldController().r(r10.getHeightStyle());
            r10.getScaffoldController().s(r10.getIgnoreInsetBottom());
            r10.getScaffoldController().v(r10.getFullWindowSize());
            r10.initBgColor();
        }

        public static void L(OSheetBase r10) {
            q.g(r10, "this");
            if (r10.getConfigurationCallbackRegistered() == true) goto L5;
            return;
        L5:
            r10.getSheetContext().unregisterComponentCallbacks(r10.getConfigurationCallback());
            r10.setConfigurationCallbackRegistered(false);
        }

        public static void M(OSheetBase r10) {
            q.g(r10, "this");
            r10.setFullWindowSize(wd.a.c(r10.getSheetContext()));
            if (r10.getUserWindowWidth() <= 0) goto L8;
            if (r10.getUserWindowWidth() >= r10.getFullWindowSize().getWidth()) goto L8;
            r10.setFullWindowSize(new Size(r10.getUserWindowWidth(), r10.getFullWindowSize().getHeight()));
        L8:
            if (r10.getUserWindowHeight() > 0) goto L10;
            return;
        L10:
            if (r10.getUserWindowHeight() >= r10.getFullWindowSize().getHeight()) goto L14;
            r10.setFullWindowSize(new Size(r10.getFullWindowSize().getWidth(), r10.getUserWindowHeight()));
            return;
        }

        public static /* synthetic */ void a(OSheetBase r10) {
            w(r10);
        }

        public static /* synthetic */ void b(OSheetBase r10) {
            t(r10);
        }

        public static void c(OSheetBase r10, boolean r11) {
            q.g(r10, "this");
            if (r10.getEnableMaterial() == false) goto L9;
            r10.getRootContainer().getContext();
            com.obric.oui.material.b[] r12 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!r10.isDarkTheme()));
            r10.getRootContainer().setBackgroundColor(0);
            if (r11 == false) goto L7;
            o.l(r10.getRootContainer(), r12, false, null, 6, null);
            return;
        L7:
            o.j(r10.getRootContainer(), r12, false, 0, null, 14, null);
            return;
        }

        public static void d(OSheetBase r10) {
            q.g(r10, "this");
            r10.getScaffoldController().c();
        }

        public static void e(OSheetBase r10, boolean r11) {
            q.g(r10, "this");
            r10.setIgnoreInsetBottom(r11);
            r10.getScaffoldController().s(r11);
        }

        public static void f(final OSheetBase r12, float r13, float r14) {
            q.g(r12, "this");
            SheetAnimStyle r15 = SheetAnimStyle.f16915a;
            if (SheetAnimStyle.r(r15, r12.getRootContainer(), r14, 0.0f, 4, null) == false) goto L5;
            r12.performExitAnimation(r14);
            return;
        L5:
            jb.d r10 = r12.getRunningAnim();
            if (r10 == null) goto L9;
            jb.d.c(r10, false, 1, null);
        L9:
            r12.setRunningAnim(com.obric.common.oea.foundation.animation.builder.b.b(SheetAnimStyle.n(r15, r12.getRootContainer(), r12.windowForAnim(), r12.getDimView(), r12.needDimAnim(), r12.useWindowDim(), e.b(r12.getSheetContext()), r14, null, 64, null).f(new AnonymousClass1(r12)).b(), null, null, 3, null));
        }

        public static int g(OSheetBase r10) {
            q.g(r10, "this");
            if (r10.isContentOverlayMode() == false) goto L7;
            return R$layout.o_sheet_container_overlay;
        L7:
            return R$layout.o_sheet_container;
        }

        public static View h(OSheetBase r10) {
            q.g(r10, "this");
            return r10.getHeaderContainer().findViewById(R$id.btn_end_action);
        }

        public static OSheetTitleBar i(OSheetBase r10) {
            q.g(r10, "this");
            return r10.getScaffoldController().e();
        }

        public static int j(OSheetBase r10) {
            q.g(r10, "this");
            return r10.getScaffoldController().f();
        }

        public static View k(OSheetBase r10) {
            q.g(r10, "this");
            return r10.getFooterContainer().findViewById(R$id.btn_negative);
        }

        public static View l(OSheetBase r10) {
            q.g(r10, "this");
            return r10.getFooterContainer().findViewById(R$id.btn_positive);
        }

        public static View m(OSheetBase r10) {
            q.g(r10, "this");
            View r11 = r10.getHeaderContainer().findViewById(R$id.btn_start_action);
            if (r11 == null) goto L5;
            return r11;
        L5:
            return r10.getHeaderContainer().findViewById(R$id.left_action_back);
        }

        public static void n(OSheetBase r10) {
            q.g(r10, "this");
            if ((r10.getRootContainer().getBackground() instanceof ColorDrawable) == false) goto L10;
            Drawable r11 = r10.getRootContainer().getBackground();
            if (r11 == null) goto L8;
            r10.setBgColor(((ColorDrawable) r11).getColor());
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        L10:
            if ((r10.getRootContainer().getBackground() instanceof GradientDrawable) == false) goto L21;
            Drawable r12 = r10.getRootContainer().getBackground();
            if (r12 == null) goto L19;
            ColorStateList r13 = ((GradientDrawable) r12).getColor();
            if (r13 != null) goto L16;
            int r14 = -1;
        L17:
            r10.setBgColor(r14);
            return;
        L16:
            r14 = r13.getDefaultColor();
            goto L17
        L19:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }

        public static boolean o(OSheetBase r10) {
            q.g(r10, "this");
            if (r10.getBgColor() != 0) goto L7;
            return td.i.a(r10.getRootContainer());
        L7:
            return i0.c(r10.getBgColor());
        }

        public static boolean p(OSheetBase r10) {
            q.g(r10, "this");
            return r10.getScaffoldController().h();
        }

        public static void q(OSheetBase r10, float r11, float r12, boolean r13) {
            q.g(r10, "this");
            if (r13 == false) goto L9;
            r10.setRootTransMoveStartX(r10.getRootContainer().getTranslationX());
            r10.setRootTransMoveStartY(r10.getRootContainer().getTranslationY());
            jb.d r14 = r10.getRunningAnim();
            if (r14 == null) goto L11;
            r14.b(true);
            return;
        L11:
            return;
        L9:
            r10.getRootContainer().setTranslationX(r10.getRootTransMoveStartX() + r11);
            r10.getRootContainer().setTranslationY(r10.getRootTransMoveStartY() + r12);
        }

        public static void r(OSheetBase r10) {
            q.g(r10, "this");
            r10.calculateBodyMaxHeight();
            int r11 = 0;
            View r12 = r10.getBodyContainer().getChildAt(0);
            if ((r12 instanceof ViewGroup) == false) goto L5;
            ViewGroup r13 = (ViewGroup) r12;
        L7:
            if ((r10.getScaffoldContainer() instanceof LinearLayout) == false) goto L18;
            r10.getBodyContainer().setPadding(0, 0, 0, 0);
            if (r13 == null) goto L12;
            r13.setClipToPadding(true);
        L12:
            if (r13 == null) goto L15;
            r13.setPadding(r13.getPaddingLeft(), r10.getBodyContentPaddingTop(), r13.getPaddingRight(), r10.getBodyContentPaddingBottom());
        L15:
            if (r13 == null) goto L39;
            r13.requestLayout();
            return;
        L39:
            return;
        L18:
            FrameLayout r14 = r10.getBodyContainer();
            if (r10.getFooterContainer().getVisibility() != 0) goto L21;
            int r15 = r10.getFooterContainer().getMeasuredHeight();
        L22:
            r14.setPadding(0, 0, 0, r15);
            if (r13 == null) goto L26;
            r13.setClipToPadding(false);
        L26:
            if (r13 != null) goto L29;
        L34:
            if (r13 == null) goto L40;
            r13.requestLayout();
            return;
        L40:
            return;
        L29:
            if (r10.getAutoAddBodyPaddingTopWhenOverlay() == true) goto L31;
        L33:
            r13.setPadding(r13.getPaddingLeft(), r10.getBodyContentPaddingTop() + r11, r13.getPaddingRight(), r10.getBodyContentPaddingBottom());
            goto L34
        L31:
            if (r10.getHeaderContainer().getVisibility() != 0) goto L33;
            r11 = r10.getHeaderContainer().getMeasuredHeight();
            goto L33
        L21:
            r15 = 0;
            goto L22
        L5:
            r13 = null;
            goto L7
        }

        public static void s(final OSheetBase r10) {
            q.g(r10, "this");
            jb.d r11 = r10.getRunningAnim();
            if (r11 == null) goto L7;
            jb.d.c(r11, false, 1, null);
        L7:
            if (r10.getEnableEnterAnim() == true) goto L10;
            r10.calculateBodyMaxHeight();
            r10.getRootContainer().setAlpha(1.0f);
            r10.getRootContainer().setTranslationY(0.0f);
            SheetAnimStyle.f16915a.h(r10.getRootContainer(), R$id.o_dialog_anim_in);
            r10.setRunningAnim(null);
            r10.onShowAnimStart();
            r10.onShowAnimEnd();
            return;
        L10:
            r10.getRootContainer().setAlpha(0.0f);
            r10.getRootContainer().post(new c(r10));
        }

        public static void t(final OSheetBase r11) {
            q.g(r11, "this$0");
            r11.setRunningAnim(com.obric.common.oea.foundation.animation.builder.b.b(SheetAnimStyle.p(SheetAnimStyle.f16915a, r11.getRootContainer(), r11.windowForAnim(), r11.getDimView(), r11.needDimAnim(), r11.useWindowDim(), e.b(r11.getSheetContext()), null, 32, null).f(new OSheetBase$performEnterAnimation$1$animBuilder$1(r11)).b(), null, null, 3, null));
            r11.onShowAnimStart();
        }

        public static void u(final OSheetBase r16, float r17) {
            q.g(r16, "this");
            jb.d r10 = r16.getRunningAnim();
            if (r10 == null) goto L6;
            jb.d.c(r10, false, 1, null);
        L6:
            r16.setRunningAnim(com.obric.common.oea.foundation.animation.builder.b.b(SheetAnimStyle.l(SheetAnimStyle.f16915a, r16.getRootContainer(), r16.windowForAnim(), r16.getDimView(), r16.needDimAnim(), r16.useWindowDim(), r17, new d(r16), null, 64, null).f(new AnonymousClass2(r16)).b(), null, null, 3, null));
            r16.onDismissAnimStart();
        }

        public static /* synthetic */ void v(OSheetBase r10, float r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L6;
            r11 = 0.0f;
        L6:
            r10.performExitAnimation(r11);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performExitAnimation");
        }

        public static void w(OSheetBase r10) {
            q.g(r10, "this$0");
            jb.d r11 = r10.getRunningAnim();
            if (r11 == null) goto L6;
            r11.b(true);
        L6:
            r10.getRootContainer().setAlpha(0.0f);
        }

        public static void x(OSheetBase r10) {
            q.g(r10, "this");
            if (r10.getConfigurationCallbackRegistered() == false) goto L5;
            return;
        L5:
            r10.getSheetContext().registerComponentCallbacks(r10.getConfigurationCallback());
            r10.setConfigurationCallbackRegistered(true);
        }

        public static void y(OSheetBase r10) {
            q.g(r10, "this");
            r10.getScaffoldController().j();
        }

        public static void z(OSheetBase r10, View r11) {
            q.g(r10, "this");
            r10.getScaffoldController().k(r11);
            if (r11 == null) goto L5;
            r10.setBodyContentPaddingTop(r11.getPaddingTop());
            r10.setBodyContentPaddingBottom(r11.getPaddingBottom());
            return;
        L5:
            r10.setBodyContentPaddingTop(0);
            r10.setBodyContentPaddingBottom(0);
        }
    }

    void applyMaterial(boolean r10);

    void calculateBodyMaxHeight();

    void enableIgnoreInsetBottom(boolean r10);

    @Override // com.obric.oui.sheet.v2.SheetMoveDelegate
    void fling(float r10, float r11);

    boolean getAutoAddBodyPaddingTopWhenOverlay();

    int getBgColor();

    @NotNull
    FrameLayout getBodyContainer();

    int getBodyContentPaddingBottom();

    int getBodyContentPaddingTop();

    @NotNull
    ComponentCallbacks getConfigurationCallback();

    boolean getConfigurationCallbackRegistered();

    int getContentLayoutResId();

    @NotNull
    View getDimView();

    boolean getEnableDimAnim();

    boolean getEnableEnterAnim();

    boolean getEnableMaterial();

    @Nullable
    View getEndActionButton();

    @NotNull
    FrameLayout getFooterContainer();

    @NotNull
    Size getFullWindowSize();

    @NotNull
    FrameLayout getHeaderContainer();

    @Nullable
    OSheetTitleBar getHeaderTitleBar();

    @NotNull
    OSheet.HeightMode getHeightStyle();

    boolean getIgnoreInsetBottom();

    boolean getMCancelable();

    boolean getMClearDimFlag();

    int getMaxBodyHeight();

    @Nullable
    View getNegativeButton();

    @Nullable
    View getPositiveButton();

    @NotNull
    RadiusLayout getRootContainer();

    float getRootTransMoveStartX();

    float getRootTransMoveStartY();

    @Nullable
    jb.d getRunningAnim();

    @NotNull
    ViewGroup getScaffoldContainer();

    @NotNull
    h getScaffoldController();

    @NotNull
    Context getSheetContext();

    boolean getShowing();

    @Nullable
    View getStartActionButton();

    @Nullable
    Boolean getSystemInsetsAppearanceLightValue();

    int getUserWindowHeight();

    int getUserWindowWidth();

    @NotNull
    <T extends View> T getViewById(@IdRes int r10);

    void initBgColor();

    boolean isContentOverlayMode();

    boolean isDarkTheme();

    boolean isRootContainerMaxHeight();

    @Override // com.obric.oui.sheet.v2.SheetMoveDelegate
    void move(float r10, float r11, boolean r12);

    boolean needDimAnim();

    void onDismissAnimEnd();

    void onDismissAnimStart();

    void onDismissComplete();

    void onPostShow();

    void onShowAnimEnd();

    void onShowAnimStart();

    void performEnterAnimation();

    void performExitAnimation(float r10);

    void registerConfigurationCallbackIfNeeded();

    void removeOnApplyWindowInsetsListener();

    void setAutoAddBodyPaddingTopWhenOverlay(boolean r10);

    void setBgColor(int r10);

    void setBodyContainer(@NotNull FrameLayout r10);

    void setBodyContentPaddingBottom(int r10);

    void setBodyContentPaddingTop(int r10);

    void setBodyView(@Nullable View r10);

    void setCanceledOnTouchOutside(boolean r10);

    void setConfigurationCallback(@NotNull ComponentCallbacks r10);

    void setConfigurationCallbackRegistered(boolean r10);

    void setContentOverlayMode(boolean r10);

    void setDimView(@NotNull View r10);

    void setEnableDimAnim(boolean r10);

    void setEnableEnterAnim(boolean r10);

    void setEnableMaterial(boolean r10);

    void setFooterButton(@Nullable Integer r10, boolean r11, @Nullable View.OnClickListener r12, @Nullable Integer r13, boolean r14, @Nullable View.OnClickListener r15);

    void setFooterButton(@Nullable String r10, boolean r11, @Nullable View.OnClickListener r12, @Nullable String r13, boolean r14, @Nullable View.OnClickListener r15);

    void setFooterContainer(@NotNull FrameLayout r10);

    void setFooterView(@Nullable View r10);

    void setFullWindowSize(@NotNull Size r10);

    void setHeader(@NotNull OSheet.Header r10, @Nullable Integer r11, @Nullable Integer r12, @Nullable String r13, @Nullable String r14, boolean r15, @Nullable View.OnClickListener r16, @Nullable View.OnClickListener r17, @Nullable Integer r18, @Nullable Integer r19, @Nullable String r110, @Nullable String r111, @Nullable Integer r112, @Nullable Integer r113);

    void setHeaderContainer(@NotNull FrameLayout r10);

    void setHeaderView(@Nullable View r10);

    void setHeightMode(@NotNull OSheet.HeightMode r10);

    void setHeightStyle(@NotNull OSheet.HeightMode r10);

    void setIgnoreInsetBottom(boolean r10);

    void setMCancelable(boolean r10);

    void setMClearDimFlag(boolean r10);

    void setOnApplyWindowInsetsListener();

    void setOverlayModeAutoBodyPaddingTopEnabled(boolean r10);

    void setRootContainer(@NotNull RadiusLayout r10);

    void setRootTransMoveStartX(float r10);

    void setRootTransMoveStartY(float r10);

    void setRunningAnim(@Nullable jb.d r10);

    void setScaffoldContainer(@NotNull ViewGroup r10);

    void setScaffoldController(@NotNull h r10);

    void setSheetBgColor(int r10);

    void setShowing(boolean r10);

    void setSystemInsetsAppearanceLightValue(@Nullable Boolean r10);

    void setUserWindowHeight(int r10);

    void setUserWindowWidth(int r10);

    void setupDimView(@NotNull Context r10);

    void setupView(@NotNull Context r10);

    void unregisterConfigurationCallbackIfNeeded();

    void updateFullWindowSize();

    void updateMaterial();

    boolean useWindowDim();

    @Nullable
    Window windowForAnim();
}
