package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.obric.oui.dialog.alert.view.IOImageLoadDelegate;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.base.AbstractDialogBuilder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAlertDialogBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001XB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0013J\u0010\u00102\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\fJ\u0016\u00102\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\nJ\b\u00107\u001a\u00020\u0002H\u0017J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\u0012\u0010;\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u0007H\u0007J\u000e\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\u00002\u0006\u00106\u001a\u00020\nJ\u0010\u00104\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\fJ\u0018\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fH\u0007J\u0016\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001d\u001a\u00020\u00002\b\b\u0001\u0010\u001d\u001a\u00020\fJ\u0010\u0010@\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ(\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ&\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J*\u0010A\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ(\u0010A\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J(\u0010H\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ&\u0010H\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J*\u0010H\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ\u001a\u0010H\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010!J \u0010I\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0017J(\u0010L\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ&\u0010L\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J*\u0010L\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ(\u0010L\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J\u0006\u0010M\u001a\u00020\u0000J\u001a\u0010,\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010N\u001a\u00020\u0007J\u0010\u0010,\u001a\u00020\u00002\b\b\u0001\u0010,\u001a\u00020\fJ\u0018\u0010-\u001a\u00020\u00002\u0006\u0010O\u001a\u00020.2\b\b\u0002\u0010P\u001a\u00020\fJ\u0012\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u0007H\u0007J\u000e\u00100\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0007J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0007J&\u0010T\u001a\u00020F2\b\u00104\u001a\u0004\u0018\u00010\u00132\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020F0VH\u0002J&\u0010W\u001a\u00020F2\b\u0010B\u001a\u0004\u0018\u00010\u001e2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020F0VH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/oui/dialog/alert/OAlertDialogBuilder;", "Lcom/obric/oui/dialog/base/AbstractDialogBuilder;", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adaptWindowDim", "", "autoDismiss", "bodyController", "Lcom/obric/oui/dialog/alert/StyleController;", "buttonStyle", "", "customNegativeView", "Landroid/view/View;", "forceHideCloseIcon", "forceHideFirstFrame", "iconController", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "imageHeight", "Ljava/lang/Integer;", "imageLoadDelegate", "Lcom/obric/oui/dialog/alert/view/IOImageLoadDelegate;", "imageUrl", "", "imageWidth", "isBanner", "isOnlyTitle", "message", "", "messageMoreThanTwoLines", "negativeButtonClick", "Landroid/content/DialogInterface$OnClickListener;", "negativeButtonText", "negativeButtonTextColorType", "Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "neutralButtonClick", "neutralButtonText", "neutralButtonTextColorType", "positiveButtonBgPrimary", "positiveButtonClick", "positiveButtonText", "positiveButtonTextColorType", "title", "topImageLoader", "Lcom/obric/oui/dialog/alert/OAlertDialogBuilder$IImageLoader;", "widthMatchParent", "withBodyHeightMatchParent", "enabled", "banner", "drawable", "icon", "body", "controller", "createDialog", "customNegativeButton", "customView", "force", "horizontalButton", "iconSize", "widthPixel", "heightPixel", "imageSize", "multiMessage", "negativeButton", "text", "listener", "Lkotlin/Function2;", "Landroid/content/DialogInterface;", "", "textColorType", "neutralButton", "newDialogInstance", "widthMatch", "withHeightMatchParent", "positiveButton", "primaryButton", "onlyTitle", "loader", "imageType", "verticalButton", "matchParent", "withBodyWithMatchParent", "withIconValid", "block", "Lkotlin/Function1;", "withTextValid", "IImageLoader", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
public class OAlertDialogBuilder extends AbstractDialogBuilder<OAlertDialog> {
    private boolean adaptWindowDim;
    private boolean autoDismiss;
    private StyleController bodyController;
    private int buttonStyle;
    private final Context context;
    private View customNegativeView;
    private boolean forceHideCloseIcon;
    private boolean forceHideFirstFrame;
    private StyleController iconController;
    private Drawable imageDrawable;
    private Integer imageHeight;
    private IOImageLoadDelegate imageLoadDelegate;
    private String imageUrl;
    private Integer imageWidth;
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
    private boolean positiveButtonBgPrimary;
    private DialogInterface.OnClickListener positiveButtonClick;
    private CharSequence positiveButtonText;
    private ButtonStyleController.TextColorType positiveButtonTextColorType;
    private CharSequence title;
    private IImageLoader topImageLoader;
    private boolean widthMatchParent;
    private boolean withBodyHeightMatchParent;

    /* JADX INFO: compiled from: OAlertDialogBuilder.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/OAlertDialogBuilder$IImageLoader;", "", "loadTopImg", "", "imageView", "Landroid/widget/ImageView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IImageLoader {
        void loadTopImg(ImageView r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$0DGdb9A-sxxs91PlBTO9imjOPbE, reason: not valid java name */
    public static /* synthetic */ void m453$r8$lambda$0DGdb9Asxxs91PlBTO9imjOPbE(Function2 r0, DialogInterface r1, int r2) {
        m455neutralButton$lambda2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$aAZ8UeEKmWueCvVA2xSKrj8hc0w(Function2 r0, DialogInterface r1, int r2) {
        m456positiveButton$lambda0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$kLxY3jnT3_1ppUB26BaZgw5mBo8(Function2 r0, DialogInterface r1, int r2) {
        m454negativeButton$lambda1(r0, r1, r2);
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

    public static final /* synthetic */ boolean access$isOnlyTitle$p(OAlertDialogBuilder r0) {
        return r0.isOnlyTitle;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogBuilder
    public /* bridge */ /* synthetic */ AbstractDialog createDialog() {
        return createDialog();
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
        title$default(this, this.context.getString(r4), false, 2, null);
        return this;
    }

    public final OAlertDialogBuilder message(CharSequence r1) {
        this.message = r1;
        return this;
    }

    public final OAlertDialogBuilder message(int r2) {
        message(this.context.getString(r2));
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
        this.positiveButtonBgPrimary = r2;
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
        this.positiveButtonBgPrimary = r2;
        return this;
    }

    public final OAlertDialogBuilder primaryButton() {
        this.buttonStyle = 1;
        this.positiveButtonBgPrimary = true;
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
        this.positiveButtonClick = new OAlertDialogBuilder$$ExternalSyntheticLambda2(r3);
        return this;
    }

    /* JADX INFO: renamed from: positiveButton$lambda-0, reason: not valid java name */
    private static final void m456positiveButton$lambda0(Function2 r1, DialogInterface r2, int r3) {
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
    private static final void m454negativeButton$lambda1(Function2 r1, DialogInterface r2, int r3) {
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
        this.neutralButtonClick = new OAlertDialogBuilder$$ExternalSyntheticLambda0(r3);
        return this;
    }

    /* JADX INFO: renamed from: neutralButton$lambda-2, reason: not valid java name */
    private static final void m455neutralButton$lambda2(Function2 r1, DialogInterface r2, int r3) {
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

    public final OAlertDialogBuilder withBodyHeightMatchParent(boolean r1) {
        this.withBodyHeightMatchParent = r1;
        return this;
    }

    public final OAlertDialogBuilder withBodyWithMatchParent(boolean r1) {
        this.widthMatchParent = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.oui.dialog.base.AbstractDialogBuilder
    public OAlertDialog createDialog() {
        final OAlertDialog r0 = newDialogInstance(this.context, this.widthMatchParent, this.withBodyHeightMatchParent);
        withTextValid(this.title, new AnonymousClass1(this, r0));
        withTextValid(this.message, new AnonymousClass2(r0, this));
        StyleController r1 = this.iconController;
        if (r1 != null) goto L5;
        Unit r2 = null;
    L6:
        boolean r3 = true;
        if (r2 == null) goto L9;
    L37:
        r0.setAutoDismiss(this.autoDismiss);
        ButtonStyleController r4 = new ButtonStyleController(this.context, this.buttonStyle);
        r0.setButtonStyleController(r4);
        StyleController r5 = this.bodyController;
        if (r5 == null) goto L42;
        r0.setBodyStyleController(r5);
    L42:
        if (getShowCloseIcon$OUI_standardRelease() == true) goto L49;
        OAlertDialogBuilder r6 = this;
        if (this.buttonStyle == 2) goto L47;
        r3 = false;
    L47:
        AbstractDialogBuilder.showCloseIcon$default(r6, r3, null, 2, null);
    L49:
        if (this.forceHideCloseIcon == false) goto L52;
        AbstractDialogBuilder.showCloseIcon$default(this, false, null, 2, null);
    L52:
        if (this.forceHideFirstFrame == false) goto L55;
        r0.forceHideFirstFrame();
    L55:
        if (this.adaptWindowDim == false) goto L57;
        r0.adaptWindowDim();
    L57:
        r0.setOnShowListener(getShowListener$OUI_standardRelease());
        r0.setOnDismissListener(getDismissListener$OUI_standardRelease());
        r0.setOnCancelListener(getCancelListener$OUI_standardRelease());
        r4.setPositiveButton(this.positiveButtonText, this.positiveButtonClick, this.positiveButtonTextColorType, this.positiveButtonBgPrimary);
        r4.setNegativeButton(this.negativeButtonText, this.negativeButtonClick, this.negativeButtonTextColorType);
        r4.setNeutralButton(this.neutralButtonText, this.neutralButtonClick, this.neutralButtonTextColorType);
        View r8 = this.customNegativeView;
        if (r8 == null) goto L60;
        Intrinsics.checkNotNull(r8);
        r4.setCustomNegativeButton(r8);
    L60:
        return r0;
    L9:
        if (this.imageUrl.length() <= 0) goto L11;
        Object[] r7 = true;
    L12:
        if (r7 == true) goto L14;
    L16:
        Object[] r9 = false;
    L17:
        Drawable r10 = this.imageDrawable;
        if (r10 != null) goto L22;
        if (r9 == true) goto L22;
        if (this.topImageLoader == null) goto L37;
    L22:
        ImageStyleController r11 = new ImageStyleController(this.context, this.isBanner ? 1 : 0);
        IImageLoader r12 = this.topImageLoader;
        if (r12 == null) goto L25;
        Intrinsics.checkNotNull(r12);
        r11.setTopImageLoader(r12);
    L36:
        r0.setTopImageStyleController(r11);
        goto L37
    L25:
        if (r10 == null) goto L27;
        r11.setImageDrawable(r10);
        r11.setSize(this.imageWidth, this.imageHeight);
        goto L36
    L27:
        r11.setImageUrl(this.imageUrl);
        IOImageLoadDelegate r13 = this.imageLoadDelegate;
        if (r13 == null) goto L31;
        r11.setImageUrlLoadDelegate(r13);
    L31:
        Integer r14 = this.imageWidth;
        if (r14 == null) goto L36;
        Integer r15 = this.imageHeight;
        if (r15 == null) goto L36;
        r11.setSize(r14, r15);
        goto L36
    L14:
        if (this.imageLoadDelegate == null) goto L16;
        r9 = true;
        goto L17
    L11:
        r7 = false;
        goto L12
    L5:
        r0.setTopImageStyleController(r1);
        r2 = Unit.INSTANCE;
        goto L6
    }

    public OAlertDialog newDialogInstance(Context r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new OAlertDialog(r1, r2, r3);
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
