package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.color.i0;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.obric.oui.text.OTextView;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.s;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003^Ö\u0001B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001c2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010\u0013J\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020#H\u0016¢\u0006\u0004\b)\u0010%J9\u00101\u001a\u0002002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b1\u00102J9\u00103\u001a\u0002002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b3\u00102J%\u00105\u001a\u0002002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u00104\u001a\u00020\t¢\u0006\u0004\b5\u00106J\u001f\u0010:\u001a\u0002092\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00108\u001a\u000207H\u0007¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\r2\u0006\u0010<\u001a\u00020\t¢\u0006\u0004\b=\u0010(J\u0015\u0010=\u001a\u00020\r2\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b=\u0010@J\r\u0010B\u001a\u00020A¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\r2\u0006\u0010D\u001a\u00020#H\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\r2\u0006\u0010D\u001a\u00020#H\u0016¢\u0006\u0004\bG\u0010FJ\u0019\u0010H\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\r2\u0006\u0010J\u001a\u00020#H\u0016¢\u0006\u0004\bK\u0010FJ\u0017\u0010M\u001a\u00020\r2\u0006\u0010L\u001a\u00020\tH\u0016¢\u0006\u0004\bM\u0010(J\u001f\u0010P\u001a\u00020\r2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0014¢\u0006\u0004\bP\u0010QJ7\u0010W\u001a\u00020\r2\u0006\u0010R\u001a\u00020#2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tH\u0014¢\u0006\u0004\bW\u0010XJ\u0019\u0010[\u001a\u00020\r2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0014¢\u0006\u0004\b[\u0010\\R\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010g\u001a\u00020]8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b:\u0010_\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR\"\u0010n\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010q\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b5\u0010i\u001a\u0004\bo\u0010k\"\u0004\bp\u0010mR\u0016\u0010s\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u0010rR\u0016\u0010u\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u0010tR\u0016\u0010w\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010vR\u0016\u0010x\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010vR\u0016\u0010y\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010vR\u0016\u0010z\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010vR\u0016\u0010{\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010iR\u0016\u0010~\u001a\u00020|8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010\u0081\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0081\u0001R\u0018\u0010\u0086\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010\u007fR\u0019\u0010\u0088\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0081\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0081\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0081\u0001R'\u0010\u0090\u0001\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\b\u008d\u0001\u0010\u0081\u0001\u001a\u0005\b\u008e\u0001\u0010\u0019\"\u0005\b\u008f\u0001\u0010(R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010J\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010\u007fR\u0019\u0010\u0096\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0081\u0001R'\u0010\u009b\u0001\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0005\u0012\u00030\u0098\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010\u009e\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R)\u0010¥\u0001\u001a\u0002008\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R/\u0010ª\u0001\u001a\u00020#2\u0007\u0010¦\u0001\u001a\u00020#8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010\u007f\u001a\u0005\b¨\u0001\u0010%\"\u0005\b©\u0001\u0010FR5\u0010°\u0001\u001a\u0004\u0018\u00010>2\t\u0010¦\u0001\u001a\u0004\u0018\u00010>8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0005\b¯\u0001\u0010@R5\u0010´\u0001\u001a\u0004\u0018\u00010>2\t\u0010¦\u0001\u001a\u0004\u0018\u00010>8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b±\u0001\u0010¬\u0001\u001a\u0006\b²\u0001\u0010®\u0001\"\u0005\b³\u0001\u0010@R5\u0010¸\u0001\u001a\u0004\u0018\u00010>2\t\u0010¦\u0001\u001a\u0004\u0018\u00010>8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\bµ\u0001\u0010¬\u0001\u001a\u0006\b¶\u0001\u0010®\u0001\"\u0005\b·\u0001\u0010@R4\u0010À\u0001\u001a\u00030¹\u00012\b\u0010¦\u0001\u001a\u00030¹\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R*\u0010Ç\u0001\u001a\u00030Á\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R*\u0010Ë\u0001\u001a\u00030Á\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010Â\u0001\u001a\u0006\bÉ\u0001\u0010Ä\u0001\"\u0006\bÊ\u0001\u0010Æ\u0001R,\u0010Ó\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R\u0013\u0010Õ\u0001\u001a\u00020A8F¢\u0006\u0007\u001a\u0005\bÔ\u0001\u0010C¨\u0006×\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "i", "(Landroid/content/Context;)V", "j", "(Landroid/util/AttributeSet;)V", "n", "()V", "m", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "getCenterTitleGap", "()I", "getTitleBarContentWidth", "totalWidth", "Lkotlin/Pair;", "g", "(I)Lkotlin/Pair;", "l", "view", "h", "(Landroid/view/View;)I", "", "k", "()Z", "themeStyle", "applyDynamicTheme", "(I)V", "isDarkTheme", "Landroid/view/ViewGroup;", "root", "iconResId", "Landroid/content/res/ColorStateList;", "tintColor", "contentDescriptionResId", "Lcom/obric/oui/button/OIconButtonFloating;", "e", "(Landroid/content/Context;Landroid/view/ViewGroup;ILandroid/content/res/ColorStateList;Ljava/lang/Integer;)Lcom/obric/oui/button/OIconButtonFloating;", "f", "layoutResId", "d", "(Landroid/content/Context;Landroid/view/ViewGroup;I)Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "sheet", "Landroid/widget/ImageView;", "b", "(Landroid/content/Context;Lcom/obric/oui/sheet/v2/SheetMoveDelegate;)Landroid/widget/ImageView;", "resId", "setCenterText", "", "title", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "apply", "applyMaskMaterial", "(Z)V", "applyContentMaterial", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "getMRightContainer", "setMRightContainer", "mRightContainer", "c", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "Landroid/widget/ImageView;", "mHandleView", "Landroid/view/ViewGroup;", "mTitleBarRoot", "Landroid/widget/TextView;", "mCenterTitleView", "mLeftTitleView", "mFixedCenterTitleView", "mFixedCenterSubTitleView", "mDesContainerView", "Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/text/OTextView;", "mDesTextView", "Z", "isFixedCenterOverflow", "I", "fixedCenterTitleDefaultMaxWidth", "o", "fixedCenterSubTitleDefaultMaxWidth", "p", "mIsLargeFont", "q", "centerTitleGapPx", "r", "centerTitleGapLargeFontPx", "s", "centerTitleHorizontalPaddingPx", "t", "getCurrentTheme", "setCurrentTheme", "currentTheme", "u", "Landroid/view/View;", "backdropTarget", "v", "w", "materialSrcType", "Lkotlin/Function1;", "Lcom/obric/oui/material/b;", FixCard.FixStyle.KEY_X, "Lkotlin/jvm/functions/Function1;", "maskMaterial", FixCard.FixStyle.KEY_Y, "Lcom/obric/oui/material/b;", "currentMaskMaterialConfig", "z", "Lcom/obric/oui/button/OIconButtonFloating;", "getMLeftActionBack", "()Lcom/obric/oui/button/OIconButtonFloating;", "setMLeftActionBack", "(Lcom/obric/oui/button/OIconButtonFloating;)V", "mLeftActionBack", CommonKey.KEY_VALUE, "A", "getShowLeftBack", "setShowLeftBack", "showLeftBack", "B", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "subTitleText", "C", "getTitleText", "setTitleText", "titleText", "D", "getDesText", "setDesText", "desText", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "E", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;)V", "mTitlePosition", "", "F", "getTouchStartX", "()F", "setTouchStartX", "(F)V", "touchStartX", "G", "getTouchStartY", "setTouchStartY", "touchStartY", "Landroid/view/VelocityTracker;", "H", "Landroid/view/VelocityTracker;", "getVelocityTracker", "()Landroid/view/VelocityTracker;", "setVelocityTracker", "(Landroid/view/VelocityTracker;)V", "velocityTracker", "getMTitleView", "mTitleView", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSheetTitleBar extends FrameLayout implements MaskMaterialOwner, MaterialOwner, ODynamicThemeWidget {
    public static final a I = null;
    public boolean A;
    public String B;
    public String C;
    public String D;
    public TitlePosition E;
    public float F;
    public float G;
    public VelocityTracker H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f16888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f16889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f16890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f16891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f16892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f16893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f16894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f16895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f16896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f16897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f16898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OTextView f16899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16903p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16904q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16905r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16906s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16907t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f16908u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16909v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16910w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function1 f16911x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.obric.oui.material.b f16912y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OIconButtonFloating f16913z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        private static final /* synthetic */ TitlePosition[] $values() {
            return new TitlePosition[]{FIXED_CENTER, FLOW_WITH_ACTION, LEFT_IN_ACTION};
        }

        static {
            FIXED_CENTER = new TitlePosition("FIXED_CENTER", 0, 0);
            FLOW_WITH_ACTION = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            LEFT_IN_ACTION = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            $VALUES = $values();
        }

        private TitlePosition(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static TitlePosition valueOf(String r10) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r10);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16914a = null;

        static {
            int[] r10 = new int[TitlePosition.values().length];
            r10[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r10[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r10[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f16914a = r10;
        }
    }

    static {
        I = new a(null);
    }

    @JvmOverloads
    public OSheetTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ boolean a(OSheetTitleBar r10, SheetMoveDelegate r11, View r12, MotionEvent r13) {
        return c(r10, r11, r12, r13);
    }

    public static final boolean c(OSheetTitleBar r10, SheetMoveDelegate r11, View r12, MotionEvent r13) {
        q.g(r10, "this$0");
        q.g(r11, "$sheet");
        if (r10.H != null) goto L5;
        r10.H = VelocityTracker.obtain();
    L5:
        VelocityTracker r14 = r10.H;
        if (r14 == null) goto L9;
        r14.addMovement(r13);
    L9:
        int r15 = r13.getAction();
        if (r15 != 0) goto L12;
        r10.F = r13.getRawX();
        r10.G = r13.getRawY();
        r10.requestFocus();
        SheetMoveDelegate.a.a(r11, 0.0f, 0.0f, true, 3, null);
    L35:
        return true;
    L12:
        if (r15 != 1) goto L14;
    L19:
        VelocityTracker r16 = r10.H;
        if (r16 == null) goto L23;
        r16.computeCurrentVelocity(1000);
    L23:
        VelocityTracker r17 = r10.H;
        if (r17 != null) goto L26;
        float r18 = 0.0f;
    L27:
        VelocityTracker r19 = r10.H;
        if (r19 == null) goto L31;
        r19.recycle();
    L31:
        r10.H = null;
        if ((r13.getRawY() - r10.G) < 0.0f) goto L35;
        r11.fling(0.0f, r18);
        goto L35
    L26:
        r18 = r17.getYVelocity();
        goto L27
    L14:
        if (r15 != 2) goto L16;
        SheetMoveDelegate.a.a(r11, 0.0f, bg.h.c(r13.getRawY() - r10.G, 0.0f), false, 4, null);
        goto L35
    L16:
        if (r15 == 3) goto L19;
        goto L19
    }

    private final int getCenterTitleGap() {
        if (this.f16903p == false) goto L6;
        return this.f16905r;
    L6:
        return this.f16904q;
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.j() <= 1) goto L8;
        ViewGroup r10 = this.f16893f;
        if (r10 != null) goto L9;
        q.y("mTitleBarRoot");
        return null;
    L9:
        return r10;
    L8:
        return this;
    }

    private final int getTitleBarContentWidth() {
        ViewGroup r10 = this.f16893f;
        ViewGroup r11 = null;
        if (r10 != null) goto L6;
        q.y("mTitleBarRoot");
        r10 = null;
    L6:
        if (r10.getMeasuredWidth() <= 0) goto L13;
        ViewGroup r12 = this.f16893f;
        if (r12 != null) goto L10;
        q.y("mTitleBarRoot");
    L14:
        return r11.getMeasuredWidth();
    L10:
        r11 = r12;
        goto L14
    L13:
        return getMeasuredWidth();
    }

    private final void i(Context r10) {
        FrameLayout.inflate(r10, R$layout.o_sheet_title_bar_container_v2, this);
        View r11 = findViewById(R$id.sheet_title_bar_main);
        q.f(r11, "findViewById(R.id.sheet_title_bar_main)");
        this.f16893f = (ViewGroup) r11;
        View r12 = findViewById(R$id.center_title);
        q.f(r12, "findViewById(R.id.center_title)");
        this.f16894g = (TextView) r12;
        View r13 = findViewById(R$id.left_title);
        q.f(r13, "findViewById(R.id.left_title)");
        this.f16895h = (TextView) r13;
        View r14 = findViewById(R$id.ll_left_action_container);
        q.f(r14, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) r14);
        View r15 = findViewById(R$id.ll_right_action_container);
        q.f(r15, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) r15);
        View r16 = findViewById(R$id.fl_center_action_container);
        q.f(r16, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) r16);
        View r17 = findViewById(R$id.fl_fixed_center_action_container);
        q.f(r17, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) r17);
        View r18 = findViewById(R$id.fixed_center_title);
        q.f(r18, "findViewById(R.id.fixed_center_title)");
        this.f16896i = (TextView) r18;
        View r19 = findViewById(R$id.left_action_back);
        q.f(r19, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OIconButtonFloating) r19);
        View r20 = findViewById(R$id.fixed_center_sub_title);
        q.f(r20, "findViewById(R.id.fixed_center_sub_title)");
        this.f16897j = (TextView) r20;
        View r21 = findViewById(R$id.sheet_title_bar_des);
        q.f(r21, "findViewById(R.id.sheet_title_bar_des)");
        this.f16898k = (FrameLayout) r21;
        View r22 = findViewById(R$id.sheet_title_bar_des_text);
        q.f(r22, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r23 = (OTextView) r22;
        this.f16899l = r23;
        TextView r24 = null;
        if (r23 != null) goto L5;
        q.y("mDesTextView");
        r23 = null;
    L5:
        r23.setEnableAutoAlignLeft(true);
        TextView r25 = this.f16896i;
        if (r25 != null) goto L8;
        q.y("mFixedCenterTitleView");
        r25 = null;
    L8:
        this.f16901n = r25.getMaxWidth();
        TextView r26 = this.f16897j;
        if (r26 != null) goto L11;
        q.y("mFixedCenterSubTitleView");
    L12:
        this.f16902o = r24.getMaxWidth();
        return;
    L11:
        r24 = r26;
        goto L12
    }

    private final void j(AttributeSet r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCTitleBar, 0, 0);
        int r12 = r11.getInt(R$styleable.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r12]);     // Catch: Throwable -> L6
        setTitleText(r11.getString(R$styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setDesText(r11.getString(R$styleable.OCTitleBar_oui_title_des_text));     // Catch: Throwable -> L6
        setShowLeftBack(r11.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r11.getString(R$styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r11.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    private final void l() {
        this.f16904q = tc.f.r(this, 12);
        this.f16905r = tc.f.r(this, 4);
        this.f16906s = tc.f.r(this, 8);
    }

    private final void m() {
        View r10 = getDefaultTargetView();
        getMLeftActionBack().setBackdropTarget(r10);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        if (this.f16910w == (-1)) goto L6;
        com.obric.oui.material.f.c(s.e(getMLeftActionBack()), r10);
        com.obric.oui.material.f.a(this, r10, this.f16910w);
        return;
    L6:
        com.obric.oui.material.f.c(s.e(getMLeftActionBack()), r10);
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r10) {
        if (this.f16907t == r10) goto L6;
        this.f16907t = r10;
        n();
        return;
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r10) {
        int r11 = this.f16910w;
        if (r11 == (-1)) goto L6;
        com.obric.oui.material.f.a(this, r10, r11);
        return;
    L6:
        com.obric.oui.material.f.b(this, r10, this.f16909v);
    }

    public final ImageView b(Context r10, final SheetMoveDelegate r11) {
        q.g(r10, "context");
        q.g(r11, "sheet");
        View r12 = FrameLayout.inflate(r10, R$layout.o_widget_titlebar_handler, this).findViewById(R$id.title_handler);
        q.f(r12, "inflate(context, R.layou…wById(R.id.title_handler)");
        ImageView r13 = (ImageView) r12;
        this.f16892e = r13;
        if (r13 != null) goto L5;
        q.y("mHandleView");
        r13 = null;
    L5:
        r13.setOnTouchListener(new i(this, r11));
        ImageView r14 = this.f16892e;
        if (r14 != null) goto L9;
        q.y("mHandleView");
        return null;
    L9:
        return r14;
    }

    public final OIconButtonFloating d(Context r10, ViewGroup r11, int r12) {
        q.g(r10, "context");
        q.g(r11, "root");
        View r13 = FrameLayout.inflate(r10, r12, r11);
        if (r13 == null) goto L11;
        View r14 = ((ViewGroup) r13).getChildAt(r11.getChildCount() - 1);
        if (r14 == null) goto L9;
        return (OIconButtonFloating) r14;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OIconButtonFloating");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final OIconButtonFloating e(Context r10, ViewGroup r11, int r12, ColorStateList r13, Integer r14) {
        q.g(r10, "context");
        q.g(r11, "root");
        OIconButtonFloating r15 = d(r10, r11, R$layout.o_widget_titlebar_neutral_icon_button);
        o.n(r15, getDefaultTargetView());
        r15.setIcon(r12);
        if (r13 == null) goto L6;
        r15.setIconTintColor(r13);
    L6:
        if (r14 == null) goto L9;
        r15.setContentDescription(r15.getContext().getString(r14.intValue()));
    L9:
        return r15;
    }

    public final OIconButtonFloating f(Context r10, ViewGroup r11, int r12, ColorStateList r13, Integer r14) {
        q.g(r10, "context");
        q.g(r11, "root");
        OIconButtonFloating r15 = d(r10, r11, R$layout.o_widget_titlebar_primary_icon_button);
        o.n(r15, getDefaultTargetView());
        r15.setIcon(r12);
        if (r13 == null) goto L6;
        r15.setIconTintColor(r13);
    L6:
        if (r14 == null) goto L9;
        r15.setContentDescription(r15.getContext().getString(r14.intValue()));
    L9:
        return r15;
    }

    public final Pair g(int r10) {
        ViewGroup r11 = this.f16893f;
        ViewGroup r12 = null;
        if (r11 != null) goto L5;
        q.y("mTitleBarRoot");
        r11 = null;
    L5:
        int r13 = r11.getPaddingLeft();
        ViewGroup r14 = this.f16893f;
        if (r14 != null) goto L8;
        q.y("mTitleBarRoot");
    L9:
        int r15 = r12.getPaddingRight();
        int r16 = getCenterTitleGap();
        int r17 = h(getMLeftContainer());
        int r18 = h(getMRightContainer());
        if (r17 <= 0) goto L12;
        int r19 = (r13 + r17) + r16;
    L13:
        if (r18 <= 0) goto L15;
        int r20 = ((r10 - r15) - r18) - r16;
    L17:
        return kotlin.d.a(Integer.valueOf(r19), Integer.valueOf(r20));
    L15:
        r20 = (r10 - r15) - this.f16906s;
        goto L17
    L12:
        r19 = r13 + this.f16906s;
        goto L13
    L8:
        r12 = r14;
        goto L9
    }

    public final int getCurrentTheme() {
        return this.f16907t;
    }

    @Nullable
    public final String getDesText() {
        return this.D;
    }

    @NotNull
    public final FrameLayout getMCenterContainer() {
        FrameLayout r10 = this.f16890c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mCenterContainer");
        return null;
    }

    @NotNull
    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r10 = this.f16891d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mFixedCenterContainer");
        return null;
    }

    @NotNull
    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r10 = this.f16913z;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mLeftActionBack");
        return null;
    }

    @NotNull
    public final LinearLayout getMLeftContainer() {
        LinearLayout r10 = this.f16888a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mLeftContainer");
        return null;
    }

    @NotNull
    public final LinearLayout getMRightContainer() {
        LinearLayout r10 = this.f16889b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("mRightContainer");
        return null;
    }

    @NotNull
    public final TitlePosition getMTitlePosition() {
        return this.E;
    }

    @NotNull
    public final TextView getMTitleView() {
        TitlePosition r10 = this.E;
        int r11 = b.f16914a[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f16896i;
        if (r12 != null) goto L22;
        q.y("mFixedCenterTitleView");
        return null;
    L22:
        return r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = this.f16894g;
        if (r12 != null) goto L22;
        q.y("mCenterTitleView");
        return null;
    L7:
        if (r11 != 3) goto L13;
        r12 = this.f16895h;
        if (r12 != null) goto L22;
        q.y("mLeftTitleView");
        return null;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.A;
    }

    @Nullable
    public final String getSubTitleText() {
        return this.B;
    }

    @Nullable
    public final String getTitleText() {
        return this.C;
    }

    @NotNull
    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final float getTouchStartX() {
        return this.F;
    }

    public final float getTouchStartY() {
        return this.G;
    }

    @Nullable
    public final VelocityTracker getVelocityTracker() {
        return this.H;
    }

    public final int h(View r10) {
        int r11 = 0;
        if (r10.getVisibility() == 0) goto L5;
    L12:
        return 0;
    L5:
        if (r10.getMeasuredWidth() <= 0) goto L12;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r11 = r13.getMarginStart() + r13.getMarginEnd();
    L11:
        return r10.getMeasuredWidth() + r11;
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        int r10 = this.f16907t;
        if (r10 != 0) goto L5;
        TextView r11 = this.f16895h;
        TextView r12 = null;
        if (r11 != null) goto L13;
        q.y("mLeftTitleView");
        r11 = null;
    L13:
        if (r11.getVisibility() != 0) goto L19;
        TextView r13 = this.f16895h;
        if (r13 != null) goto L17;
        q.y("mLeftTitleView");
    L18:
        int r14 = r12.getTextColors().getDefaultColor();
    L31:
        return !i0.c(r14);
    L17:
        r12 = r13;
        goto L18
    L19:
        TextView r15 = this.f16896i;
        if (r15 != null) goto L23;
        q.y("mFixedCenterTitleView");
        r15 = null;
    L23:
        if (r15.getVisibility() != 0) goto L29;
        TextView r16 = this.f16896i;
        if (r16 != null) goto L27;
        q.y("mFixedCenterTitleView");
    L28:
        r14 = r12.getTextColors().getDefaultColor();
        goto L31
    L27:
        r12 = r16;
        goto L28
    L29:
        r14 = -16777216;
        goto L31
    L5:
        if (r10 == 2) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean k() {
        if (this.E == TitlePosition.FIXED_CENTER) goto L5;
    L19:
        return false;
    L5:
        if (getMFixedCenterContainer().getVisibility() != 0) goto L19;
        TextView r10 = this.f16896i;
        TextView r11 = null;
        if (r10 != null) goto L10;
        q.y("mFixedCenterTitleView");
        r10 = null;
    L10:
        if (r10.getVisibility() == 0) goto L18;
        TextView r12 = this.f16897j;
        if (r12 != null) goto L15;
        q.y("mFixedCenterSubTitleView");
    L17:
        if (r11.getVisibility() != 0) goto L19;
    L15:
        r11 = r12;
    L18:
        return true;
    }

    public final void n() {
        com.obric.oui.material.b r10 = (com.obric.oui.material.b) this.f16911x.invoke(Boolean.valueOf(!isDarkTheme()));
        this.f16912y = r10;
        if (r10 != null) goto L5;
        q.y("currentMaskMaterialConfig");
        r10 = null;
    L5:
        OMaterialHelper.E(this, r10, this.f16910w);
        View r11 = this.f16908u;
        if (r11 != null) goto L9;
        r11 = this;
    L9:
        o.n(this, r11);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        if (r10 == null) goto L6;
        this.f16903p = td.h.g(r10.fontScale);
    L6:
        l();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (k() == true) goto L5;
        return;
    L5:
        int r15 = getTitleBarContentWidth();
        if (r15 > 0) goto L8;
        return;
    L8:
        Pair r16 = g(r15);
        int r17 = ((Number) r16.component1()).intValue();
        int r18 = ((Number) r16.component2()).intValue();
        int r19 = Math.max(0, r18 - r17);
        int r20 = getMFixedCenterContainer().getMeasuredWidth();
        int r21 = (r15 - r20) / 2;
        int r22 = r21 + r20;
        if (r20 <= r19) goto L11;
    L10:
        r21 = r17;
    L17:
        if (this.f16900m == false) goto L20;
        if (r20 > r19) goto L20;
        r21 = r17 + ((r19 - r20) / 2);
        r18 = r21 + r20;
    L20:
        getMFixedCenterContainer().layout(r21, getMFixedCenterContainer().getTop(), r18, getMFixedCenterContainer().getBottom());
        return;
    L11:
        if (r21 >= r17) goto L13;
        r18 = r17 + r20;
        goto L10
    L13:
        if (r22 <= r18) goto L15;
        r21 = r18 - r20;
        goto L17
    L15:
        r18 = r22;
        goto L17
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r12 = false;
        this.f16900m = false;
        TextView r13 = this.f16896i;
        TextView r14 = null;
        if (r13 != null) goto L5;
        q.y("mFixedCenterTitleView");
        r13 = null;
    L5:
        r13.setMaxWidth(this.f16901n);
        TextView r15 = this.f16897j;
        if (r15 != null) goto L8;
        q.y("mFixedCenterSubTitleView");
        r15 = null;
    L8:
        r15.setMaxWidth(this.f16902o);
        super.onMeasure(r10, r11);
        if (k() == true) goto L11;
        return;
    L11:
        int r16 = getTitleBarContentWidth();
        if (r16 > 0) goto L14;
        return;
    L14:
        Pair r17 = g(r16);
        int r18 = ((Number) r17.component1()).intValue();
        int r19 = ((Number) r17.component2()).intValue();
        int r20 = r16 / 2;
        int r21 = Math.max(0, Math.min((r20 - r18) * 2, (r19 - r20) * 2));
        int r22 = Math.max(0, r19 - r18);
        if (getMFixedCenterContainer().getMeasuredWidth() <= r21) goto L39;
        boolean r23 = true;
        this.f16900m = true;
        int r24 = Math.min(this.f16901n, r22);
        int r25 = Math.min(this.f16902o, r22);
        TextView r26 = this.f16896i;
        if (r26 != null) goto L20;
        q.y("mFixedCenterTitleView");
        r26 = null;
    L20:
        if (r26.getMaxWidth() == r24) goto L25;
        TextView r27 = this.f16896i;
        if (r27 != null) goto L24;
        q.y("mFixedCenterTitleView");
        r27 = null;
    L24:
        r27.setMaxWidth(r24);
        r12 = true;
    L25:
        TextView r28 = this.f16897j;
        if (r28 != null) goto L29;
        q.y("mFixedCenterSubTitleView");
        r28 = null;
    L29:
        if (r28.getMaxWidth() == r25) goto L35;
        TextView r29 = this.f16897j;
        if (r29 != null) goto L33;
        q.y("mFixedCenterSubTitleView");
    L34:
        r14.setMaxWidth(r25);
    L36:
        if (r23 == false) goto L40;
        super.onMeasure(r10, r11);
        return;
    L40:
        return;
    L33:
        r14 = r29;
        goto L34
    L35:
        r23 = r12;
        goto L36
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        this.f16908u = r10;
        if (r10 != null) goto L6;
        o.n(this, this);
        m();
        return;
    L6:
        o.n(this, r10);
        com.obric.oui.material.f.g(s.e(getMLeftActionBack()), r10);
    }

    public final void setCenterText(int r10) {
        String r11 = getResources().getString(r10);
        q.f(r11, "resources.getString(resId)");
        setTitleText(r11);
    }

    public final void setCurrentTheme(int r10) {
        this.f16907t = r10;
    }

    public final void setDesText(@Nullable String r10) {
        this.D = r10;
        FrameLayout r11 = null;
        OTextView r12 = null;
        if (r10 != null) goto L5;
    L15:
        FrameLayout r13 = this.f16898k;
        if (r13 != null) goto L18;
        q.y("mDesContainerView");
    L19:
        r11.setVisibility(8);
        return;
    L18:
        r11 = r13;
        goto L19
    L5:
        if (r10.length() == 0) goto L15;
        FrameLayout r14 = this.f16898k;
        if (r14 != null) goto L10;
        q.y("mDesContainerView");
        r14 = null;
    L10:
        r14.setVisibility(0);
        OTextView r15 = this.f16899l;
        if (r15 != null) goto L13;
        q.y("mDesTextView");
    L14:
        r12.setText(r10);
        return;
    L13:
        r12 = r15;
        goto L14
    }

    public final void setMCenterContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16890c = r10;
    }

    public final void setMFixedCenterContainer(@NotNull FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16891d = r10;
    }

    public final void setMLeftActionBack(@NotNull OIconButtonFloating r10) {
        q.g(r10, "<set-?>");
        this.f16913z = r10;
    }

    public final void setMLeftContainer(@NotNull LinearLayout r10) {
        q.g(r10, "<set-?>");
        this.f16888a = r10;
    }

    public final void setMRightContainer(@NotNull LinearLayout r10) {
        q.g(r10, "<set-?>");
        this.f16889b = r10;
    }

    public final void setMTitlePosition(@NotNull TitlePosition r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.E = r10;
        int r11 = b.f16914a[r10.ordinal()];
        TextView r12 = null;
        if (r11 != 1) goto L5;
        TextView r13 = this.f16896i;
        if (r13 != null) goto L34;
        q.y("mFixedCenterTitleView");
        r13 = null;
    L34:
        r13.setVisibility(0);
        TextView r14 = this.f16894g;
        if (r14 != null) goto L37;
        q.y("mCenterTitleView");
        r14 = null;
    L37:
        r14.setVisibility(8);
        TextView r15 = this.f16895h;
        if (r15 != null) goto L40;
        q.y("mLeftTitleView");
    L41:
        r12.setVisibility(8);
    L42:
        getMTitleView().setText(this.C);
        return;
    L40:
        r12 = r15;
        goto L41
    L5:
        if (r11 != 2) goto L7;
        TextView r16 = this.f16896i;
        if (r16 != null) goto L23;
        q.y("mFixedCenterTitleView");
        r16 = null;
    L23:
        r16.setVisibility(8);
        TextView r17 = this.f16894g;
        if (r17 != null) goto L26;
        q.y("mCenterTitleView");
        r17 = null;
    L26:
        r17.setVisibility(0);
        TextView r18 = this.f16895h;
        if (r18 != null) goto L29;
        q.y("mLeftTitleView");
    L30:
        r12.setVisibility(8);
        goto L42
    L29:
        r12 = r18;
        goto L30
    L7:
        if (r11 != 3) goto L42;
        TextView r19 = this.f16896i;
        if (r19 != null) goto L12;
        q.y("mFixedCenterTitleView");
        r19 = null;
    L12:
        r19.setVisibility(8);
        TextView r20 = this.f16894g;
        if (r20 != null) goto L15;
        q.y("mCenterTitleView");
        r20 = null;
    L15:
        r20.setVisibility(8);
        TextView r21 = this.f16895h;
        if (r21 != null) goto L18;
        q.y("mLeftTitleView");
    L19:
        r12.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r12 = r21;
        goto L19
    }

    public final void setShowLeftBack(boolean r10) {
        this.A = r10;
        OIconButtonFloating r11 = getMLeftActionBack();
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        if (this.E != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void setSubTitleText(@Nullable String r10) {
        this.B = r10;
        TextView r11 = null;
        if (r10 != null) goto L9;
        TextView r12 = this.f16897j;
        if (r12 != null) goto L7;
        q.y("mFixedCenterSubTitleView");
    L8:
        r11.setVisibility(8);
        return;
    L7:
        r11 = r12;
        goto L8
    L9:
        TextView r13 = this.f16897j;
        if (r13 != null) goto L12;
        q.y("mFixedCenterSubTitleView");
        r13 = null;
    L12:
        r13.setVisibility(0);
        TextView r14 = this.f16897j;
        if (r14 != null) goto L15;
        q.y("mFixedCenterSubTitleView");
    L16:
        r11.setText(r10);
        return;
    L15:
        r11 = r14;
        goto L16
    }

    public final void setTitleText(@Nullable String r10) {
        this.C = r10;
        if (r10 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r10);
    }

    public final void setTouchStartX(float r10) {
        this.F = r10;
    }

    public final void setTouchStartY(float r10) {
        this.G = r10;
    }

    public final void setVelocityTracker(@Nullable VelocityTracker r10) {
        this.H = r10;
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.f16910w = r10;
        com.obric.oui.material.f.e(s.e(getMLeftActionBack()), r10);
        o.p(this, r10);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.f16909v == r10) goto L9;
        this.f16909v = r10;
        if (this.f16910w == (-1)) goto L7;
        return;
    L7:
        o.q(this, r10);
        com.obric.oui.material.f.i(s.e(getMLeftActionBack()), r10);
        return;
    }

    @JvmOverloads
    public OSheetTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSheetTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final void setCenterText(@NotNull String r10) {
        q.g(r10, "title");
        setTitleText(r10);
    }

    @JvmOverloads
    public OSheetTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16901n = Channel.UNLIMITED;
        this.f16902o = Channel.UNLIMITED;
        this.f16903p = td.h.g(r10.getResources().getConfiguration().fontScale);
        this.f16909v = true;
        this.f16910w = 2;
        this.f16911x = new OSheetTitleBar$maskMaterial$1(this);
        this.A = true;
        this.E = TitlePosition.FIXED_CENTER;
        l();
        i(r10);
        if (r11 == null) goto L5;
        j(r11);
    L5:
        n();
    }
}
