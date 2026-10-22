package com.obric.oui.sheet.v2;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0018\u0018\u00002\u00020\u00012\u00020\u0002:\b\u0080\u0002\u0081\u0002\u0082\u0002\u0083\u0002B;\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0013*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010%¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010(¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\t¢\u0006\u0004\b/\u0010$J\u0015\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b1\u0010$J\u0015\u00103\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\t¢\u0006\u0004\b3\u0010$J\u0015\u00105\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\t¢\u0006\u0004\b5\u0010$J\u000f\u00106\u001a\u00020\u000eH\u0014¢\u0006\u0004\b6\u0010\u0010J\u000f\u00107\u001a\u00020\u000eH\u0014¢\u0006\u0004\b7\u0010\u0010J\u0011\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\tH\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\tH\u0016¢\u0006\u0004\b=\u0010<J\u000f\u0010>\u001a\u00020\u000eH\u0016¢\u0006\u0004\b>\u0010\u0010J\u000f\u0010?\u001a\u00020\u000eH\u0016¢\u0006\u0004\b?\u0010\u0010J\u000f\u0010@\u001a\u00020\u000eH\u0016¢\u0006\u0004\b@\u0010\u0010J\u000f\u0010A\u001a\u00020\u000eH\u0016¢\u0006\u0004\bA\u0010\u0010J\u000f\u0010B\u001a\u00020\u000eH\u0016¢\u0006\u0004\bB\u0010\u0010R\"\u0010I\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010Q\u001a\u00020J8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010T\u001a\u00020\u00128\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0011\u0010D\u001a\u0004\bR\u0010F\"\u0004\bS\u0010HR\"\u0010[\u001a\u00020U8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u000f\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010b\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010f\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bc\u0010]\u001a\u0004\bd\u0010_\"\u0004\be\u0010aR\"\u0010j\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bg\u0010]\u001a\u0004\bh\u0010_\"\u0004\bi\u0010aR\"\u0010o\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010<\"\u0004\bn\u0010$R\"\u0010s\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bp\u0010l\u001a\u0004\bq\u0010<\"\u0004\br\u0010$R\"\u0010w\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bt\u0010l\u001a\u0004\bu\u0010<\"\u0004\bv\u0010$R\"\u0010\u007f\u001a\u00020x8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R*\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R&\u0010\u0089\u0001\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010l\u001a\u0005\b\u0089\u0001\u0010<\"\u0005\b\u008a\u0001\u0010$R&\u0010\u008e\u0001\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010l\u001a\u0005\b\u008c\u0001\u0010<\"\u0005\b\u008d\u0001\u0010$R&\u0010\u0092\u0001\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010l\u001a\u0005\b\u0090\u0001\u0010<\"\u0005\b\u0091\u0001\u0010$R)\u0010\u0099\u0001\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R)\u0010\u009d\u0001\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u0094\u0001\u001a\u0006\b\u009b\u0001\u0010\u0096\u0001\"\u0006\b\u009c\u0001\u0010\u0098\u0001R*\u0010¥\u0001\u001a\u00030\u009e\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R,\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¦\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R&\u0010±\u0001\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010l\u001a\u0005\b¯\u0001\u0010<\"\u0005\b°\u0001\u0010$R&\u0010µ\u0001\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010l\u001a\u0005\b³\u0001\u0010<\"\u0005\b´\u0001\u0010$R*\u0010»\u0001\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0006\b¶\u0001\u0010·\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0005\bº\u0001\u0010-R\u0018\u0010½\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¼\u0001\u0010lR\u0018\u0010¿\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¾\u0001\u0010lR\u001b\u0010Â\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001b\u0010È\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u001b\u0010Î\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001b\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Í\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R&\u0010Ø\u0001\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010l\u001a\u0005\bÖ\u0001\u0010<\"\u0005\b×\u0001\u0010$R*\u0010à\u0001\u001a\u00030Ù\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R)\u0010ä\u0001\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010\u0094\u0001\u001a\u0006\bâ\u0001\u0010\u0096\u0001\"\u0006\bã\u0001\u0010\u0098\u0001R)\u0010ç\u0001\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0094\u0001\u001a\u0006\bå\u0001\u0010\u0096\u0001\"\u0006\bæ\u0001\u0010\u0098\u0001R&\u0010ë\u0001\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bè\u0001\u0010l\u001a\u0005\bé\u0001\u0010<\"\u0005\bê\u0001\u0010$R*\u0010ò\u0001\u001a\u00030ì\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bí\u0001\u0010Õ\u0001\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001R*\u0010ö\u0001\u001a\u00030ì\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010Õ\u0001\u001a\u0006\bô\u0001\u0010ï\u0001\"\u0006\bõ\u0001\u0010ñ\u0001R)\u0010ú\u0001\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b÷\u0001\u0010\u0094\u0001\u001a\u0006\bø\u0001\u0010\u0096\u0001\"\u0006\bù\u0001\u0010\u0098\u0001R\u001c\u0010ü\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010Ó\u0001R\u0017\u0010ÿ\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001¨\u0006\u0084\u0002"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/sheet/v2/OSheetBase;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "contentOverlay", "userEnableMaterial", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZZ)V", "", "d", "()V", "c", "Landroid/view/View;", "T", "id", "getViewById", "(I)Landroid/view/View;", "setupView", "(Landroid/content/Context;)V", "updateMaterial", "setupDimView", "Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;", "listener", "setOnShowAnimListener", "(Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;)V", "Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;", "setOnDismissAnimListener", "(Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;)V", "enable", "setOverlayModeAutoBodyPaddingTopEnabled", "(Z)V", "Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;", "setOnConfigurationListener", "(Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;)V", "Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;", "setOnCancelListener", "(Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;)V", "appearanceLight", "setSystemInsetsAppearanceLight", "(Ljava/lang/Boolean;)V", "remove", "setRemoveOnDismiss", "cancelable", "setCancelable", "passThrough", "setPassThroughTouchOutside", "dim", "setClearDimFlag", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/view/Window;", "windowForAnim", "()Landroid/view/Window;", "useWindowDim", "()Z", "needDimAnim", "onShowAnimStart", "onShowAnimEnd", "onDismissAnimStart", "onDismissAnimEnd", "onDismissComplete", "a", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldContainer", "getDimView", "setDimView", "dimView", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootContainer", "e", "Landroid/widget/FrameLayout;", "getHeaderContainer", "()Landroid/widget/FrameLayout;", "setHeaderContainer", "(Landroid/widget/FrameLayout;)V", "headerContainer", "f", "getFooterContainer", "setFooterContainer", "footerContainer", "g", "getBodyContainer", "setBodyContainer", "bodyContainer", "h", "Z", "getMClearDimFlag", "setMClearDimFlag", "mClearDimFlag", "i", "getEnableDimAnim", "setEnableDimAnim", "enableDimAnim", "j", "getEnableEnterAnim", "setEnableEnterAnim", "enableEnterAnim", "Lcom/obric/oui/sheet/v2/h;", "k", "Lcom/obric/oui/sheet/v2/h;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/h;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/h;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "l", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "heightStyle", "m", "isContentOverlayMode", "setContentOverlayMode", "n", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "ignoreInsetBottom", "o", "getMCancelable", "setMCancelable", "mCancelable", "p", "I", "getUserWindowWidth", "()I", "setUserWindowWidth", "(I)V", "userWindowWidth", "q", "getUserWindowHeight", "setUserWindowHeight", "userWindowHeight", "Landroid/util/Size;", "r", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "fullWindowSize", "Ljb/d;", "s", "Ljb/d;", "getRunningAnim", "()Ljb/d;", "setRunningAnim", "(Ljb/d;)V", "runningAnim", "t", "getShowing", "setShowing", "showing", "u", "getEnableMaterial", "setEnableMaterial", "enableMaterial", "v", "Ljava/lang/Boolean;", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "systemInsetsAppearanceLightValue", "w", "removeOnDismiss", FixCard.FixStyle.KEY_X, "passThroughTouchOutside", FixCard.FixStyle.KEY_Y, "Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;", "showAnimListener", "z", "Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;", "dismissAnimListener", "A", "Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;", "configurationListener", "B", "Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;", "cancelListener", "C", "Ljava/lang/Integer;", "originalStatusBarAppearance", "D", "originalNavigationBarAppearance", "Landroid/view/Window$Callback;", "E", "Landroid/view/Window$Callback;", "originalWindowCallback", "F", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationCallbackRegistered", "Landroid/content/ComponentCallbacks;", "G", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallback", "H", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "bodyContentPaddingTop", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingBottom", "J", "getAutoAddBodyPaddingTopWhenOverlay", "setAutoAddBodyPaddingTopWhenOverlay", "autoAddBodyPaddingTopWhenOverlay", "", "K", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartX", "L", "getRootTransMoveStartY", "setRootTransMoveStartY", "rootTransMoveStartY", "M", "getBgColor", "setBgColor", Style.KEY_BG_COLOR, "N", "myWindowCallback", "getSheetContext", "()Landroid/content/Context;", "sheetContext", "OnCancelListener", "OnConfigurationListener", "OnDismissAnimListener", "OnShowAnimListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetModal extends FrameLayout implements OSheetBase {
    public OnConfigurationListener A;
    public OnCancelListener B;
    public Integer C;
    public Integer D;
    public Window.Callback E;
    public boolean F;
    public ComponentCallbacks G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f16859J;
    public float K;
    public float L;
    public int M;
    public Window.Callback N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f16860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f16861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f16862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RadiusLayout f16863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f16864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f16865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f16866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f16870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OSheet.HeightMode f16871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16873n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f16874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16875p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16876q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Size f16877r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public jb.d f16878s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16879t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16880u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f16881v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f16882w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f16883x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OnShowAnimListener f16884y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OnDismissAnimListener f16885z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;", "", "onCancel", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCancelListener {
        void onCancel(@NotNull OSheetModal r10);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;", "", "onConfigurationChanged", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "configuration", "Landroid/content/res/Configuration;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnConfigurationListener {
        void onConfigurationChanged(@NotNull OSheetModal r10, @NotNull Configuration r11);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;", "", "onDismissAnimEnd", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "onDismissAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDismissAnimListener {
        void onDismissAnimEnd(@NotNull OSheetModal r10);

        void onDismissAnimStart(@NotNull OSheetModal r10);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;", "", "onShowAnimEnd", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "onShowAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnShowAnimListener {
        void onShowAnimEnd(@NotNull OSheetModal r10);

        void onShowAnimStart(@NotNull OSheetModal r10);
    }

    public static final class a implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSheetModal f16886a;

        public a(OSheetModal r10) {
            this.f16886a = r10;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            OSheetModal.b(this.f16886a);
        }
    }

    public static final class b implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSheetModal f16887a;

        public b(OSheetModal r10) {
            this.f16887a = r10;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r10) {
            q.g(r10, "newConfig");
            this.f16887a.updateFullWindowSize();
            this.f16887a.getScaffoldController().i(this.f16887a.getFullWindowSize());
            OnConfigurationListener r11 = OSheetModal.a(this.f16887a);
            if (r11 == null) goto L7;
            r11.onConfigurationChanged(this.f16887a, r10);
            return;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    @JvmOverloads
    public OSheetModal(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        boolean r13 = false;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 30, null);
    }

    public static final /* synthetic */ OnConfigurationListener a(OSheetModal r10) {
        return r10.A;
    }

    public static final /* synthetic */ void b(OSheetModal r10) {
        r10.d();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void applyMaterial(boolean r10) {
        OSheetBase.DefaultImpls.c(this, r10);
    }

    public final void c() {
        Context r10 = getContext();
        if ((r10 instanceof Activity) == false) goto L5;
        Activity r11 = (Activity) r10;
    L6:
        if (r11 != null) goto L8;
        Window r12 = null;
    L9:
        if (r12 != null) goto L11;
        return;
    L11:
        Integer r13 = this.C;
        if (r13 == null) goto L18;
        int r14 = r13.intValue();
        WindowInsetsController r15 = r12.getInsetsController();
        if (r15 == null) goto L18;
        r15.setSystemBarsAppearance(r14, 8);
    L18:
        Integer r16 = this.D;
        if (r16 == null) goto L25;
        int r17 = r16.intValue();
        WindowInsetsController r18 = r12.getInsetsController();
        if (r18 == null) goto L25;
        r18.setSystemBarsAppearance(r17, 16);
    L25:
        this.C = null;
        this.D = null;
        return;
    L8:
        r12 = r11.getWindow();
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void calculateBodyMaxHeight() {
        OSheetBase.DefaultImpls.d(this);
    }

    public final void d() {
        wd.a r10 = wd.a.f25402a;
        Context r11 = getContext();
        q.f(r11, "context");
        Activity r12 = r10.b(r11);
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.getWindow().getCallback() == this.N) goto L8;
    L10:
        this.E = null;
        this.N = null;
        return;
    L8:
        if (this.E == null) goto L10;
        r12.getWindow().setCallback(this.E);
        goto L10
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void enableIgnoreInsetBottom(boolean r10) {
        OSheetBase.DefaultImpls.e(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void fling(float r10, float r11) {
        OSheetBase.DefaultImpls.f(this, r10, r11);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.f16859J;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBgColor() {
        return this.M;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public FrameLayout getBodyContainer() {
        FrameLayout r10 = this.f16866g;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingBottom() {
        return this.I;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingTop() {
        return this.H;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public ComponentCallbacks getConfigurationCallback() {
        return this.G;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getConfigurationCallbackRegistered() {
        return this.F;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getContentLayoutResId() {
        return OSheetBase.DefaultImpls.g(this);
    }

    @NotNull
    public final View getContentView() {
        View r10 = this.f16860a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("contentView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public View getDimView() {
        View r10 = this.f16862c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("dimView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableDimAnim() {
        return this.f16868i;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableEnterAnim() {
        return this.f16869j;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableMaterial() {
        return this.f16880u;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @Nullable
    public View getEndActionButton() {
        return OSheetBase.DefaultImpls.h(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public FrameLayout getFooterContainer() {
        FrameLayout r10 = this.f16865f;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public Size getFullWindowSize() {
        return this.f16877r;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public FrameLayout getHeaderContainer() {
        FrameLayout r10 = this.f16864e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @Nullable
    public OSheetTitleBar getHeaderTitleBar() {
        return OSheetBase.DefaultImpls.i(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public OSheet.HeightMode getHeightStyle() {
        return this.f16871l;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getIgnoreInsetBottom() {
        return this.f16873n;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMCancelable() {
        return this.f16874o;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMClearDimFlag() {
        return this.f16867h;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getMaxBodyHeight() {
        return OSheetBase.DefaultImpls.j(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @Nullable
    public View getNegativeButton() {
        return OSheetBase.DefaultImpls.k(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @Nullable
    public View getPositiveButton() {
        return OSheetBase.DefaultImpls.l(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public RadiusLayout getRootContainer() {
        RadiusLayout r10 = this.f16863d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartX() {
        return this.K;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartY() {
        return this.L;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @Nullable
    public jb.d getRunningAnim() {
        return this.f16878s;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public ViewGroup getScaffoldContainer() {
        ViewGroup r10 = this.f16861b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public h getScaffoldController() {
        h r10 = this.f16870k;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @NotNull
    public Context getSheetContext() {
        Context r10 = getContext();
        q.f(r10, "context");
        return r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getShowing() {
        return this.f16879t;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @Nullable
    public View getStartActionButton() {
        return OSheetBase.DefaultImpls.m(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    @Nullable
    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.f16881v;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowHeight() {
        return this.f16876q;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowWidth() {
        return this.f16875p;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getViewById(int r10) {
        View r11 = getContentView().findViewById(r10);
        q.f(r11, "contentView.findViewById(id)");
        return r11;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void initBgColor() {
        OSheetBase.DefaultImpls.n(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isContentOverlayMode() {
        return this.f16872m;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isDarkTheme() {
        return OSheetBase.DefaultImpls.o(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isRootContainerMaxHeight() {
        return OSheetBase.DefaultImpls.p(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void move(float r10, float r11, boolean r12) {
        OSheetBase.DefaultImpls.q(this, r10, r11, r12);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean needDimAnim() {
        if (getEnableDimAnim() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMClearDimFlag() == true) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerConfigurationCallbackIfNeeded();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        unregisterConfigurationCallbackIfNeeded();
        super.onDetachedFromWindow();
        d();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimEnd() {
        OnDismissAnimListener r10 = this.f16885z;
        if (r10 == null) goto L7;
        r10.onDismissAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimStart() {
        OnDismissAnimListener r10 = this.f16885z;
        if (r10 == null) goto L7;
        r10.onDismissAnimStart(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissComplete() {
        setShowing(false);
        setVisibility(8);
        c();
        d();
        if (this.f16882w == false) goto L12;
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewGroup) == false) goto L7;
        ViewGroup r11 = (ViewGroup) r10;
    L8:
        if (r11 == null) goto L13;
        r11.removeView(this);
        return;
    L13:
        return;
    L7:
        r11 = null;
        goto L8
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onPostShow() {
        OSheetBase.DefaultImpls.r(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimEnd() {
        OnShowAnimListener r10 = this.f16884y;
        if (r10 == null) goto L7;
        r10.onShowAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimStart() {
        OnShowAnimListener r10 = this.f16884y;
        if (r10 == null) goto L7;
        r10.onShowAnimStart(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performEnterAnimation() {
        OSheetBase.DefaultImpls.s(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performExitAnimation(float r10) {
        OSheetBase.DefaultImpls.u(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void registerConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.x(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void removeOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.y(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r10) {
        this.f16859J = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBgColor(int r10) {
        this.M = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16866g = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingBottom(int r10) {
        this.I = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingTop(int r10) {
        this.H = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyView(@Nullable View r10) {
        OSheetBase.DefaultImpls.z(this, r10);
    }

    public final void setCancelable(boolean r10) {
        setMCancelable(r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setCanceledOnTouchOutside(boolean r10) {
        OSheetBase.DefaultImpls.A(this, r10);
    }

    public final void setClearDimFlag(boolean r10) {
        setMClearDimFlag(r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallback(@NotNull ComponentCallbacks r10) {
        q.g(r10, "<set-?>");
        this.G = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallbackRegistered(boolean r10) {
        this.F = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setContentOverlayMode(boolean r10) {
        this.f16872m = r10;
    }

    public final void setContentView(@NotNull View r10) {
        q.g(r10, "<set-?>");
        this.f16860a = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setDimView(@NotNull View r10) {
        q.g(r10, "<set-?>");
        this.f16862c = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableDimAnim(boolean r10) {
        this.f16868i = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableEnterAnim(boolean r10) {
        this.f16869j = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableMaterial(boolean r10) {
        this.f16880u = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        OSheetBase.DefaultImpls.B(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16865f = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterView(@Nullable View r10) {
        OSheetBase.DefaultImpls.D(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFullWindowSize(@NotNull Size r10) {
        q.g(r10, "<set-?>");
        this.f16877r = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeader(OSheet.Header r10, Integer r11, Integer r12, String r13, String r14, boolean r15, View.OnClickListener r16, View.OnClickListener r17, Integer r18, Integer r19, String r110, String r111, Integer r112, Integer r113) {
        OSheetBase.DefaultImpls.E(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16864e = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderView(@Nullable View r10) {
        OSheetBase.DefaultImpls.F(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightMode(@NotNull OSheet.HeightMode r10) {
        OSheetBase.DefaultImpls.G(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightStyle(@NotNull OSheet.HeightMode r10) {
        q.g(r10, "<set-?>");
        this.f16871l = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setIgnoreInsetBottom(boolean r10) {
        this.f16873n = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMCancelable(boolean r10) {
        this.f16874o = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMClearDimFlag(boolean r10) {
        this.f16867h = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.H(this);
    }

    public final void setOnCancelListener(@Nullable OnCancelListener r10) {
        this.B = r10;
    }

    public final void setOnConfigurationListener(@Nullable OnConfigurationListener r10) {
        this.A = r10;
    }

    public final void setOnDismissAnimListener(@Nullable OnDismissAnimListener r10) {
        this.f16885z = r10;
    }

    public final void setOnShowAnimListener(@Nullable OnShowAnimListener r10) {
        this.f16884y = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r10) {
        OSheetBase.DefaultImpls.I(this, r10);
    }

    public final void setPassThroughTouchOutside(boolean r10) {
        this.f16883x = r10;
    }

    public final void setRemoveOnDismiss(boolean r10) {
        this.f16882w = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootContainer(@NotNull RadiusLayout r10) {
        q.g(r10, "<set-?>");
        this.f16863d = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartX(float r10) {
        this.K = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartY(float r10) {
        this.L = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRunningAnim(@Nullable jb.d r10) {
        this.f16878s = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldContainer(@NotNull ViewGroup r10) {
        q.g(r10, "<set-?>");
        this.f16861b = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldController(@NotNull h r10) {
        q.g(r10, "<set-?>");
        this.f16870k = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSheetBgColor(int r10) {
        OSheetBase.DefaultImpls.J(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setShowing(boolean r10) {
        this.f16879t = r10;
    }

    public final void setSystemInsetsAppearanceLight(@Nullable Boolean r10) {
        setSystemInsetsAppearanceLightValue(r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSystemInsetsAppearanceLightValue(@Nullable Boolean r10) {
        this.f16881v = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowHeight(int r10) {
        this.f16876q = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowWidth(int r10) {
        this.f16875p = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupDimView(@NotNull Context r10) {
        q.g(r10, "context");
        setDimView(new View(r10));
        addView(getDimView(), 0, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupView(@NotNull Context r10) {
        q.g(r10, "context");
        OSheetBase.DefaultImpls.K(this, r10);
        updateMaterial();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void unregisterConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.L(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateFullWindowSize() {
        OSheetBase.DefaultImpls.M(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateMaterial() {
        applyMaterial(false);
        o.n(getRootContainer(), this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean useWindowDim() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Window windowForAnim() {
        return null;
    }

    @JvmOverloads
    public OSheetModal(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        boolean r13 = false;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 28, null);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15) {
        OSheetBase.DefaultImpls.C(this, r10, r11, r12, r13, r14, r15);
    }

    @JvmOverloads
    public OSheetModal(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        boolean r13 = false;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 24, null);
    }

    public /* synthetic */ OSheetModal(Context r10, AttributeSet r11, int r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r17 = r11;
        if ((r15 & 4) == 0) goto L8;
        int r18 = 0;
    L10:
        if ((r15 & 8) == 0) goto L12;
        boolean r19 = false;
    L14:
        if ((r15 & 16) == 0) goto L16;
        r14 = true;
    L16:
        this(r10, r17, r18, r19, r14);
        return;
    L12:
        r19 = r13;
        goto L14
    L8:
        r18 = r12;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSheetModal(Context r10, AttributeSet r11, int r12, boolean r13, boolean r14) {
        q.g(r10, "context");
        super(r10, r11, r12);
        boolean r15 = true;
        this.f16868i = true;
        this.f16869j = true;
        this.f16871l = OSheet.HeightMode.WRAP_HEIGHT;
        this.f16872m = r13;
        this.f16874o = true;
        this.f16877r = new Size(0, 0);
        this.f16882w = true;
        this.G = new b(this);
        this.f16859J = true;
        this.M = -1;
        if (r14 == true) goto L5;
    L11:
        setVisibility(8);
        View r16 = LayoutInflater.from(r10).inflate(getContentLayoutResId(), this, false);
        q.f(r16, "from(context)\n          …youtResId(), this, false)");
        setContentView(r16);
        View r17 = getContentView();
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-1, -2);
        r18.gravity = 80;
        Unit r19 = Unit.f21064a;
        addView(r17, r18);
        setupView(r10);
        if ((r10 instanceof LifecycleOwner) == false) goto L14;
        LifecycleOwner r20 = (LifecycleOwner) r10;
    L15:
        if (r20 == null) goto L22;
        Lifecycle r21 = r20.getLifecycle();
        if (r21 == null) goto L23;
        r21.a(new a(this));
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r20 = null;
        goto L15
    L5:
        if (o.e(r10) == true) goto L7;
    L9:
        r15 = false;
    L10:
        setEnableMaterial(r15);
        goto L11
    L7:
        if (OMaterialHelper.w() == false) goto L9;
        goto L9
    }
}
