package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.base.AbstractDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.DefaultButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.ImageStyleController;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import com.obric.oui.dialog.v2.common.IImageLoader;
import com.obric.oui.dialog.v2.common.IOImageLoadDelegate;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAlertDialogBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u001bJ\u0010\u0010<\u001a\u00020\u00002\b\b\u0001\u0010>\u001a\u00020\fJ\u0016\u0010<\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\nJ\u000e\u0010A\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007J\b\u0010B\u001a\u00020\u0002H\u0017J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0000J\u0012\u0010F\u001a\u00020\u00002\b\b\u0002\u00105\u001a\u00020\u0007H\u0007J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u001bJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\nJ\u0010\u0010>\u001a\u00020\u00002\b\b\u0001\u0010>\u001a\u00020\fJ\u0018\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0007J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007J\u0016\u0010K\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fJ\u0010\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010'\u001a\u00020\u00002\b\b\u0001\u0010'\u001a\u00020\fJ\u0010\u0010L\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J(\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020(2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Q0\u000eJ&\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020(2\b\u0010O\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010.H\u0007J*\u0010M\u001a\u00020\u00002\b\b\u0001\u0010N\u001a\u00020\f2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Q0\u000eJ(\u0010M\u001a\u00020\u00002\b\b\u0001\u0010N\u001a\u00020\f2\b\u0010O\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010.H\u0007J(\u0010S\u001a\u00020\u00002\u0006\u0010N\u001a\u00020(2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Q0\u000eJ&\u0010S\u001a\u00020\u00002\u0006\u0010N\u001a\u00020(2\b\u0010O\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010.H\u0007J*\u0010S\u001a\u00020\u00002\b\b\u0001\u0010N\u001a\u00020\f2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Q0\u000eJ\u001a\u0010S\u001a\u00020\u00002\b\b\u0001\u0010N\u001a\u00020\f2\b\u0010O\u001a\u0004\u0018\u00010+J\u0018\u0010T\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0007H\u0017J>\u0010V\u001a\u00020\u000026\u0010W\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eJ(\u0010X\u001a\u00020\u00002\u0006\u0010N\u001a\u00020(2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Q0\u000eJ&\u0010X\u001a\u00020\u00002\u0006\u0010N\u001a\u00020(2\b\u0010O\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010.H\u0007J*\u0010X\u001a\u00020\u00002\b\b\u0001\u0010N\u001a\u00020\f2\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Q0\u000eJ(\u0010X\u001a\u00020\u00002\b\b\u0001\u0010N\u001a\u00020\f2\b\u0010O\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010.H\u0007J\u0006\u0010Y\u001a\u00020\u0000J\u0015\u0010Z\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\\J\u001a\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010]\u001a\u00020\u0007J\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u00106\u001a\u00020\fJ\u0018\u00107\u001a\u00020\u00002\u0006\u0010^\u001a\u0002082\b\b\u0002\u0010_\u001a\u00020\fJ\u0012\u0010`\u001a\u00020\u00002\b\b\u0002\u00105\u001a\u00020\u0007H\u0007J\u0010\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\fH\u0016J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0007J&\u0010d\u001a\u00020Q2\b\u0010>\u001a\u0004\u0018\u00010\u001b2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020Q0fH\u0002J&\u0010g\u001a\u00020Q2\b\u0010N\u001a\u0004\u0018\u00010(2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020Q0fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010#\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/OAlertDialogBuilder;", "Lcom/obric/oui/dialog/base/AbstractDialogBuilder;", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adaptWindowDim", "", "autoDismiss", "bodyController", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "buttonStyle", "", "customButtonStyleControllerProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "style", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "customNegativeView", "Landroid/view/View;", "forceHideCloseIcon", "forceHideFirstFrame", "iconClipToMask", "iconController", "iconStrokeEnabled", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "imageHeight", "Ljava/lang/Integer;", "imageLoadDelegate", "Lcom/obric/oui/dialog/v2/common/IOImageLoadDelegate;", "imageUrl", "", "imageWidth", "includeCutoutInLandscape", "Ljava/lang/Boolean;", "isBanner", "isOnlyTitle", "message", "", "messageMoreThanTwoLines", "negativeButtonClick", "Landroid/content/DialogInterface$OnClickListener;", "negativeButtonText", "negativeButtonTextColorType", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "neutralButtonClick", "neutralButtonText", "neutralButtonTextColorType", "positiveButtonClick", "positiveButtonText", "positiveButtonTextColorType", "positiveButtonWarning", "title", "topImageLoader", "Lcom/obric/oui/dialog/v2/common/IImageLoader;", "widthMatchParent", "withBodyHeightMatchParent", "enabled", "banner", "drawable", "icon", "body", "controller", "clipToMask", "createDialog", "customNegativeButton", "customView", "force", "horizontalButton", "iconSize", "widthPixel", "heightPixel", "iconStroke", "imageSize", "multiMessage", "negativeButton", "text", "listener", "Landroid/content/DialogInterface;", "", "textColorType", "neutralButton", "newDialogInstance", "withHeightMatchParent", "overrideButtonStyleController", "styleControllerProvider", "positiveButton", "primaryButton", "setCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/dialog/v2/alert/OAlertDialogBuilder;", "onlyTitle", "loader", "imageType", "verticalButton", "windowFixedHeight", "heightPx", "matchParent", "withIconValid", "block", "Lkotlin/Function1;", "withTextValid", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OAlertDialogBuilder extends AbstractDialogBuilder<OAlertDialog> {
    private boolean adaptWindowDim;
    private boolean autoDismiss;
    private StyleController bodyController;
    private int buttonStyle;
    private final Context context;
    private Function2<? super Context, ? super Integer, ? extends ButtonStyleController> customButtonStyleControllerProvider;
    private View customNegativeView;
    private boolean forceHideCloseIcon;
    private boolean forceHideFirstFrame;
    private boolean iconClipToMask;
    private StyleController iconController;
    private boolean iconStrokeEnabled;
    private Drawable imageDrawable;
    private Integer imageHeight;
    private IOImageLoadDelegate imageLoadDelegate;
    private String imageUrl;
    private Integer imageWidth;
    private Boolean includeCutoutInLandscape;
    private boolean isBanner;
    private boolean isOnlyTitle;
    private CharSequence message;
    private boolean messageMoreThanTwoLines;
    private DialogInterface.OnClickListener negativeButtonClick;
    private CharSequence negativeButtonText;
    private ButtonStyleController.TextColorType negativeButtonTextColorType;
    private DialogInterface.OnClickListener neutralButtonClick;
    private CharSequence neutralButtonText;
    private ButtonStyleController.TextColorType neutralButtonTextColorType;
    private DialogInterface.OnClickListener positiveButtonClick;
    private CharSequence positiveButtonText;
    private ButtonStyleController.TextColorType positiveButtonTextColorType;
    private boolean positiveButtonWarning;
    private CharSequence title;
    private IImageLoader topImageLoader;
    private boolean widthMatchParent;
    private boolean withBodyHeightMatchParent;

    /* JADX INFO: renamed from: $r8$lambda$LoNrik7-Un56hPS6EJ5D6vgNXB0, reason: not valid java name */
    public static /* synthetic */ void m474$r8$lambda$LoNrik7Un56hPS6EJ5D6vgNXB0(Function2 r0, DialogInterface r1, int r2) {
        m478neutralButton$lambda2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$e-WrRxdZwm8zVS-z7hH17ZbWzyU, reason: not valid java name */
    public static /* synthetic */ void m475$r8$lambda$eWrRxdZwm8zVSz7hH17ZbWzyU(Function2 r0, DialogInterface r1, int r2) {
        m477negativeButton$lambda1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$iUAKwT8Tv0nOk-5djBMgDLdY148, reason: not valid java name */
    public static /* synthetic */ void m476$r8$lambda$iUAKwT8Tv0nOk5djBMgDLdY148(Function2 r0, DialogInterface r1, int r2) {
        m479positiveButton$lambda0(r0, r1, r2);
    }

    public final OAlertDialogBuilder horizontalButton() {
        return horizontalButton$default(this, false, 1, null);
    }

    public final OAlertDialogBuilder negativeButton(int r7, DialogInterface.OnClickListener r8) {
        return negativeButton$default(this, r7, r8, null, 4, null);
    }

    public final OAlertDialogBuilder negativeButton(CharSequence r8, DialogInterface.OnClickListener r9) {
        Intrinsics.checkNotNullParameter(r8, "text");
        return negativeButton$default(this, r8, r9, null, 4, null);
    }

    public final OAlertDialogBuilder neutralButton(CharSequence r8, DialogInterface.OnClickListener r9) {
        Intrinsics.checkNotNullParameter(r8, "text");
        return neutralButton$default(this, r8, r9, null, 4, null);
    }

    public final OAlertDialogBuilder positiveButton(int r7, DialogInterface.OnClickListener r8) {
        return positiveButton$default(this, r7, r8, null, 4, null);
    }

    public final OAlertDialogBuilder positiveButton(CharSequence r8, DialogInterface.OnClickListener r9) {
        Intrinsics.checkNotNullParameter(r8, "text");
        return positiveButton$default(this, r8, r9, null, 4, null);
    }

    public final OAlertDialogBuilder verticalButton() {
        return verticalButton$default(this, false, 1, null);
    }

    public static final /* synthetic */ boolean access$getMessageMoreThanTwoLines$p(OAlertDialogBuilder r0) {
        return r0.messageMoreThanTwoLines;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogBuilder
    public /* bridge */ /* synthetic */ AbstractDialog createDialog() {
        return createDialog();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogBuilder
    public /* bridge */ /* synthetic */ AbstractDialogBuilder windowFixedHeight(int r1) {
        return windowFixedHeight(r1);
    }

    public OAlertDialogBuilder(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.context = r2;
        this.imageUrl = "";
        this.autoDismiss = true;
        super.cancelable(false);
    }

    public static /* synthetic */ OAlertDialogBuilder title$default(OAlertDialogBuilder r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = false;
    L7:
        return r0.title(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    public final OAlertDialogBuilder title(CharSequence r1, boolean r2) {
        this.isOnlyTitle = r2;
        this.title = r1;
        return this;
    }

    public final OAlertDialogBuilder title(int r4) {
        title$default(this, this.context.getText(r4), false, 2, null);
        return this;
    }

    public final OAlertDialogBuilder message(CharSequence r1) {
        this.message = r1;
        return this;
    }

    public final OAlertDialogBuilder message(int r2) {
        message(this.context.getText(r2));
        return this;
    }

    public final OAlertDialogBuilder multiMessage(CharSequence r1) {
        message(r1);
        this.messageMoreThanTwoLines = true;
        return this;
    }

    public final OAlertDialogBuilder icon(int r2) {
        Drawable r3 = AppCompatResources.getDrawable(this.context, r2);
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullExpressionValue(r3, "getDrawable(context, icon)!!");
        return icon(r3);
    }

    public final OAlertDialogBuilder icon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.imageDrawable = r2;
        this.isBanner = false;
        return this;
    }

    public final OAlertDialogBuilder iconStroke(boolean r1) {
        this.iconStrokeEnabled = r1;
        return this;
    }

    public final OAlertDialogBuilder clipToMask(boolean r1) {
        this.iconClipToMask = r1;
        return this;
    }

    @Deprecated(message = "使用imageSize代替", replaceWith = @ReplaceWith(expression = "imageSize(widthPixel, heightPixel)", imports = {}))
    public final OAlertDialogBuilder iconSize(int r1, int r2) {
        this.imageWidth = Integer.valueOf(r1);
        this.imageHeight = Integer.valueOf(r2);
        return this;
    }

    public final OAlertDialogBuilder imageSize(int r1, int r2) {
        this.imageWidth = Integer.valueOf(r1);
        this.imageHeight = Integer.valueOf(r2);
        return this;
    }

    public final OAlertDialogBuilder banner(int r2) {
        Drawable r3 = AppCompatResources.getDrawable(this.context, r2);
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullExpressionValue(r3, "getDrawable(context, icon)!!");
        return banner(r3);
    }

    public final OAlertDialogBuilder banner(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.imageDrawable = r2;
        this.isBanner = true;
        return this;
    }

    public final OAlertDialogBuilder banner(String r2, IOImageLoadDelegate r3) {
        Intrinsics.checkNotNullParameter(r2, "imageUrl");
        Intrinsics.checkNotNullParameter(r3, "imageLoadDelegate");
        this.imageUrl = r2;
        this.imageLoadDelegate = r3;
        this.isBanner = true;
        return this;
    }

    public static /* synthetic */ OAlertDialogBuilder topImageLoader$default(OAlertDialogBuilder r0, IImageLoader r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = 1;
    L7:
        return r0.topImageLoader(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: topImageLoader");
    }

    public final OAlertDialogBuilder topImageLoader(IImageLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        boolean r0 = true;
        if (r3 == 1) goto L6;
        r0 = false;
    L6:
        this.isBanner = r0;
        this.topImageLoader = r2;
        return this;
    }

    public static /* synthetic */ OAlertDialogBuilder verticalButton$default(OAlertDialogBuilder r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.verticalButton(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verticalButton");
    }

    public final OAlertDialogBuilder verticalButton(boolean r2) {
        this.buttonStyle = 1;
        this.positiveButtonWarning = r2;
        return this;
    }

    public static /* synthetic */ OAlertDialogBuilder horizontalButton$default(OAlertDialogBuilder r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.horizontalButton(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalButton");
    }

    public final OAlertDialogBuilder horizontalButton(boolean r2) {
        this.buttonStyle = 0;
        this.positiveButtonWarning = r2;
        return this;
    }

    public final OAlertDialogBuilder primaryButton() {
        this.buttonStyle = 1;
        this.positiveButtonWarning = true;
        return this;
    }

    public static /* synthetic */ OAlertDialogBuilder positiveButton$default(OAlertDialogBuilder r0, CharSequence r1, DialogInterface.OnClickListener r2, ButtonStyleController.TextColorType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = null;
    L7:
        return r0.positiveButton(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public final OAlertDialogBuilder positiveButton(CharSequence r2, DialogInterface.OnClickListener r3, ButtonStyleController.TextColorType r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.positiveButtonText = r2;
        this.positiveButtonClick = r3;
        this.positiveButtonTextColorType = r4;
        return this;
    }

    public final OAlertDialogBuilder positiveButton(CharSequence r2, final Function2<? super DialogInterface, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.positiveButtonText = r2;
        this.positiveButtonClick = new OAlertDialogBuilder$$ExternalSyntheticLambda0(r3);
        return this;
    }

    /* JADX INFO: renamed from: positiveButton$lambda-0, reason: not valid java name */
    private static final void m479positiveButton$lambda0(Function2 r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$listener");
        Intrinsics.checkNotNullExpressionValue(r2, "dialog");
        r1.invoke(r2, Integer.valueOf(r3));
    }

    public static /* synthetic */ OAlertDialogBuilder positiveButton$default(OAlertDialogBuilder r0, int r1, DialogInterface.OnClickListener r2, ButtonStyleController.TextColorType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = null;
    L7:
        return r0.positiveButton(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public final OAlertDialogBuilder positiveButton(int r2, DialogInterface.OnClickListener r3, ButtonStyleController.TextColorType r4) {
        String r5 = this.context.getString(r2);
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(text)");
        return positiveButton(r5, r3, r4);
    }

    public final OAlertDialogBuilder positiveButton(int r2, Function2<? super DialogInterface, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        String r4 = this.context.getString(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "context.getString(text)");
        return positiveButton(r4, r3);
    }

    public static /* synthetic */ OAlertDialogBuilder negativeButton$default(OAlertDialogBuilder r0, CharSequence r1, DialogInterface.OnClickListener r2, ButtonStyleController.TextColorType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = null;
    L7:
        return r0.negativeButton(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public final OAlertDialogBuilder negativeButton(CharSequence r2, DialogInterface.OnClickListener r3, ButtonStyleController.TextColorType r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.negativeButtonText = r2;
        this.negativeButtonClick = r3;
        this.negativeButtonTextColorType = r4;
        return this;
    }

    public final OAlertDialogBuilder negativeButton(CharSequence r2, final Function2<? super DialogInterface, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.negativeButtonText = r2;
        this.negativeButtonClick = new OAlertDialogBuilder$$ExternalSyntheticLambda1(r3);
        return this;
    }

    /* JADX INFO: renamed from: negativeButton$lambda-1, reason: not valid java name */
    private static final void m477negativeButton$lambda1(Function2 r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$listener");
        Intrinsics.checkNotNullExpressionValue(r2, "dialog");
        r1.invoke(r2, Integer.valueOf(r3));
    }

    public final OAlertDialogBuilder customNegativeButton(View r2) {
        Intrinsics.checkNotNullParameter(r2, "customView");
        this.customNegativeView = r2;
        return this;
    }

    public static /* synthetic */ OAlertDialogBuilder negativeButton$default(OAlertDialogBuilder r0, int r1, DialogInterface.OnClickListener r2, ButtonStyleController.TextColorType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = null;
    L7:
        return r0.negativeButton(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public final OAlertDialogBuilder negativeButton(int r7, DialogInterface.OnClickListener r8, ButtonStyleController.TextColorType r9) {
        String r10 = this.context.getString(r7);
        Intrinsics.checkNotNullExpressionValue(r10, "context.getString(text)");
        return negativeButton$default(this, r10, r8, null, 4, null);
    }

    public final OAlertDialogBuilder negativeButton(int r2, Function2<? super DialogInterface, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        String r4 = this.context.getString(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "context.getString(text)");
        return negativeButton(r4, r3);
    }

    public static /* synthetic */ OAlertDialogBuilder neutralButton$default(OAlertDialogBuilder r0, CharSequence r1, DialogInterface.OnClickListener r2, ButtonStyleController.TextColorType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = null;
    L7:
        return r0.neutralButton(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: neutralButton");
    }

    public final OAlertDialogBuilder neutralButton(CharSequence r2, DialogInterface.OnClickListener r3, ButtonStyleController.TextColorType r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.neutralButtonText = r2;
        this.neutralButtonClick = r3;
        this.neutralButtonTextColorType = r4;
        this.buttonStyle = 1;
        return this;
    }

    public final OAlertDialogBuilder neutralButton(CharSequence r2, final Function2<? super DialogInterface, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.neutralButtonText = r2;
        this.neutralButtonClick = new OAlertDialogBuilder$$ExternalSyntheticLambda2(r3);
        return this;
    }

    /* JADX INFO: renamed from: neutralButton$lambda-2, reason: not valid java name */
    private static final void m478neutralButton$lambda2(Function2 r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$listener");
        Intrinsics.checkNotNullExpressionValue(r2, "dialog");
        r1.invoke(r2, Integer.valueOf(r3));
    }

    public final OAlertDialogBuilder neutralButton(int r8, DialogInterface.OnClickListener r9) {
        String r10 = this.context.getString(r8);
        Intrinsics.checkNotNullExpressionValue(r10, "context.getString(text)");
        return neutralButton$default(this, r10, r9, null, 4, null);
    }

    public final OAlertDialogBuilder neutralButton(int r2, Function2<? super DialogInterface, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        String r4 = this.context.getString(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "context.getString(text)");
        return neutralButton(r4, r3);
    }

    public final OAlertDialogBuilder autoDismiss(boolean r1) {
        this.autoDismiss = r1;
        return this;
    }

    public final OAlertDialogBuilder body(StyleController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.bodyController = r2;
        return this;
    }

    public final OAlertDialogBuilder icon(StyleController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.iconController = r2;
        return this;
    }

    public final OAlertDialogBuilder forceHideCloseIcon(boolean r1) {
        this.forceHideCloseIcon = r1;
        return this;
    }

    public final OAlertDialogBuilder forceHideFirstFrame() {
        this.forceHideFirstFrame = true;
        return this;
    }

    public final OAlertDialogBuilder adaptWindowDim() {
        this.adaptWindowDim = true;
        return this;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogBuilder
    public OAlertDialogBuilder windowFixedHeight(int r1) {
        super.windowFixedHeight(r1);
        return this;
    }

    public final OAlertDialogBuilder withBodyHeightMatchParent(boolean r1) {
        this.withBodyHeightMatchParent = r1;
        return this;
    }

    public final OAlertDialogBuilder overrideButtonStyleController(Function2<? super Context, ? super Integer, ? extends ButtonStyleController> r2) {
        Intrinsics.checkNotNullParameter(r2, "styleControllerProvider");
        this.customButtonStyleControllerProvider = r2;
        return this;
    }

    public final OAlertDialogBuilder setCutoutInLandscape(Boolean r1) {
        this.includeCutoutInLandscape = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.oui.dialog.base.AbstractDialogBuilder
    public OAlertDialog createDialog() {
        final OAlertDialog r0 = newDialogInstance(this.context, this.withBodyHeightMatchParent);
        if (this.isOnlyTitle == false) goto L5;
        r0.setOnlyTitleText(this.title);
    L6:
        withTextValid(this.message, new AnonymousClass1(r0, this));
        StyleController r1 = this.iconController;
        if (r1 != null) goto L9;
        Unit r2 = null;
    L10:
        boolean r3 = true;
        if (r2 == null) goto L13;
    L41:
        r0.setAutoDismiss(this.autoDismiss);
        Function2<? super Context, ? super Integer, ? extends ButtonStyleController> r4 = this.customButtonStyleControllerProvider;
        if (r4 != null) goto L44;
        ButtonStyleController r5 = null;
    L45:
        if (r5 != null) goto L47;
        r5 = new DefaultButtonStyleController(this.context, this.buttonStyle);
    L47:
        r0.setButtonStyleController(r5);
        StyleController r6 = this.bodyController;
        if (r6 == null) goto L52;
        r0.setBodyStyleController(r6);
    L52:
        if (getShowCloseIcon$OUI_standardRelease() == true) goto L59;
        OAlertDialogBuilder r7 = this;
        if (this.buttonStyle == 2) goto L57;
        r3 = false;
    L57:
        AbstractDialogBuilder.showCloseIcon$default(r7, r3, null, 2, null);
    L59:
        if (this.forceHideCloseIcon == false) goto L62;
        AbstractDialogBuilder.showCloseIcon$default(this, false, null, 2, null);
    L62:
        if (this.forceHideFirstFrame == false) goto L65;
        r0.forceHideFirstFrame();
    L65:
        if (this.adaptWindowDim == false) goto L67;
        r0.adaptWindowDim();
    L67:
        r0.setIncludeCutoutInLandscape(this.includeCutoutInLandscape);
        r0.setOnShowListener(getShowListener$OUI_standardRelease());
        r0.setOnDismissListener(getDismissListener$OUI_standardRelease());
        r0.setOnCancelListener(getCancelListener$OUI_standardRelease());
        r5.setPositiveButton(this.positiveButtonText, this.positiveButtonClick, this.positiveButtonTextColorType, this.positiveButtonWarning);
        r5.setNegativeButton(this.negativeButtonText, this.negativeButtonClick, this.negativeButtonTextColorType);
        r5.setNeutralButton(this.neutralButtonText, this.neutralButtonClick, this.neutralButtonTextColorType);
        View r8 = this.customNegativeView;
        if (r8 == null) goto L70;
        Intrinsics.checkNotNull(r8);
        r5.setCustomNegativeButton(r8);
    L70:
        return r0;
    L44:
        r5 = r4.invoke(this.context, Integer.valueOf(this.buttonStyle));
        goto L45
    L13:
        if (this.imageUrl.length() <= 0) goto L15;
        Object[] r9 = true;
    L16:
        if (r9 == true) goto L18;
    L20:
        Object[] r10 = false;
    L21:
        Drawable r11 = this.imageDrawable;
        if (r11 != null) goto L26;
        if (r10 == true) goto L26;
        if (this.topImageLoader == null) goto L41;
    L26:
        ImageStyleController r12 = new ImageStyleController(this.context, this.isBanner ? 1 : 0);
        r12.setIconStrokeEnabled(this.iconStrokeEnabled);
        r12.setIconClipToMask(this.iconClipToMask);
        IImageLoader r13 = this.topImageLoader;
        if (r13 == null) goto L29;
        Intrinsics.checkNotNull(r13);
        r12.setTopImageLoader(r13);
    L40:
        r0.setTopImageStyleController(r12);
        goto L41
    L29:
        if (r11 == null) goto L31;
        r12.setImageDrawable(r11);
        r12.setSize(this.imageWidth, this.imageHeight);
        goto L40
    L31:
        r12.setImageUrl(this.imageUrl);
        IOImageLoadDelegate r14 = this.imageLoadDelegate;
        if (r14 == null) goto L35;
        r12.setImageUrlLoadDelegate(r14);
    L35:
        Integer r15 = this.imageWidth;
        if (r15 == null) goto L40;
        Integer r16 = this.imageHeight;
        if (r16 == null) goto L40;
        r12.setSize(r15, r16);
        goto L40
    L18:
        if (this.imageLoadDelegate == null) goto L20;
        r10 = true;
        goto L21
    L15:
        r9 = false;
        goto L16
    L9:
        r0.setTopImageStyleController(r1);
        r2 = Unit.INSTANCE;
        goto L10
    L5:
        r0.setTitleText(this.title);
        goto L6
    }

    public OAlertDialog newDialogInstance(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new OAlertDialog(r1, r2);
    }

    private final void withTextValid(CharSequence r1, Function1<? super CharSequence, Unit> r2) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        Intrinsics.checkNotNull(r1);
        r2.invoke(r1);
        return;
    }

    private final void withIconValid(Drawable r1, Function1<? super Drawable, Unit> r2) {
        if (r1 == null) goto L5;
        r2.invoke(r1);
        return;
    }
}
