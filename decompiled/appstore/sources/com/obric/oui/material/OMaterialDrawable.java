package com.obric.oui.material;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$styleable;
import com.obric.oui.color.j0;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes4.dex */
@Keep
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \b\u0017\u0018\u0000 ³\u00012\u00020\u0001:\u0004´\u0001µ\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b!\u0010\"JG\u0010(\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000e2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0004\b(\u0010)JG\u0010,\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000e2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0004\b,\u0010)JC\u00100\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b8\u00107J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;J5\u0010D\u001a\u00020\u00052\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\f\u0010C\u001a\b\u0018\u00010BR\u00020<H\u0016¢\u0006\u0004\bD\u0010EJG\u0010L\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00172\b\b\u0002\u0010G\u001a\u00020\u00172\b\b\u0002\u0010H\u001a\u00020\u00172\b\b\u0002\u0010I\u001a\u00020\u00172\b\b\u0002\u0010J\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\u0017¢\u0006\u0004\bL\u0010MJ\u0017\u0010L\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bL\u0010PJO\u0010R\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u00172\b\b\u0002\u0010G\u001a\u00020\u00172\b\b\u0002\u0010H\u001a\u00020\u00172\b\b\u0002\u0010I\u001a\u00020\u00172\b\b\u0002\u0010J\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\u0017¢\u0006\u0004\bR\u0010SJ\u001f\u0010R\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00172\b\u0010T\u001a\u0004\u0018\u00010N¢\u0006\u0004\bR\u0010UJ\u0015\u0010W\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u000e¢\u0006\u0004\bW\u0010XJ\u001d\u0010Z\u001a\u00020\u00052\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010$¢\u0006\u0004\bZ\u0010[J\r\u0010\\\u001a\u00020\u0005¢\u0006\u0004\b\\\u0010\u0003J\u000f\u0010]\u001a\u00020\u000eH\u0016¢\u0006\u0004\b]\u0010^J5\u0010c\u001a\u00020\u00052\u0006\u0010_\u001a\u00020\u00192\b\b\u0002\u0010`\u001a\u00020\u00172\b\b\u0002\u0010a\u001a\u00020\u00172\b\b\u0002\u0010b\u001a\u00020\u000eH\u0007¢\u0006\u0004\bc\u0010dJ=\u0010f\u001a\u00020\u00052\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010$2\b\b\u0002\u0010`\u001a\u00020\u00172\b\b\u0002\u0010a\u001a\u00020\u00172\b\b\u0002\u0010b\u001a\u00020\u000eH\u0007¢\u0006\u0004\bf\u0010gJ\u0017\u0010i\u001a\u00020\u00052\u0006\u0010=\u001a\u00020hH\u0014¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\bk\u0010\u000bJ\u000f\u0010l\u001a\u00020\u0005H\u0016¢\u0006\u0004\bl\u0010\u0003J\u0017\u0010m\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\bm\u00103J\u0017\u0010n\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\bn\u00103R\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010oR\u0018\u0010T\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010oR\u0016\u0010p\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010qR\u0016\u0010s\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010qR\u0016\u0010t\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010qR\u0016\u0010u\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010qR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010xR#\u0010{\u001a\u00020z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001f\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\be\u0010\u008c\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010qR\u0018\u0010\u008e\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010qR\u001f\u0010Y\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bY\u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010\u0093\u0001\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010\u0095\u0001\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0094\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0098\u0001R/\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009a\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R(\u0010\u009f\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u009f\u0001\u0010q\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010¤\u0001\u001a\u00020\u00178\u0006¢\u0006\u000f\n\u0005\b¤\u0001\u0010q\u001a\u0006\b¥\u0001\u0010¡\u0001R'\u0010¦\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$0$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R'\u0010¨\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$0$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010§\u0001R'\u0010©\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$0$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010§\u0001R'\u0010ª\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$0$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010§\u0001R!\u0010«\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R!\u0010\u00ad\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R!\u0010¯\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010®\u0001R'\u0010°\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b°\u0001\u0010\u008b\u0001\u001a\u0005\b±\u0001\u0010^\"\u0005\b²\u0001\u0010X¨\u0006¶\u0001"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "<init>", "()V", ServerElements.TEMPLATE, "", "copyGradientInternalStateFrom", "(Landroid/graphics/drawable/GradientDrawable;)V", "Landroid/graphics/Canvas;", "canvas", "drawMultiLayerShadow", "(Landroid/graphics/Canvas;)V", "Lcom/obric/oui/shadow/a;", "config", "", "isShadowValid", "(Lcom/obric/oui/shadow/a;)Z", "Landroid/graphics/Path;", "path", "clipOutShadowPath", "(Landroid/graphics/Canvas;Landroid/graphics/Path;)V", "", "effectParams", "", SlideCard.KEY_INDEX, "Lcom/obric/oui/material/b;", "material", "setMaterialToEffectObjectIfNotInit", "(Ljava/lang/Object;ILcom/obric/oui/material/b;)V", "Landroid/view/View;", "view", "", "stateSet", "processMaterialOnStateChange", "(Landroid/view/View;Ljava/lang/Object;I[ILcom/obric/oui/material/b;)Z", "enableAnimate", "", "Lcom/obric/oui/color/a;", "fromBlendConfigs", "toBlendConfigs", "updateBlendConfigs", "(Ljava/lang/Object;IZ[Lcom/obric/oui/color/a;[Lcom/obric/oui/color/a;)Z", "fromOverlayBlendConfigs", "toOverlayBlendConfigs", "updateOverlayBlendConfigs", "Lcom/obric/oui/color/j0;", "fromStrokeConfig", "toStrokeConfig", "updateStrokeConfig", "(Landroid/view/View;Ljava/lang/Object;IZLcom/obric/oui/color/j0;Lcom/obric/oui/color/j0;)Z", "processSolidAndStrokeOnStateChange", "([I)Z", "toColor", "animate", "updateSolidColor", "(IZ)V", "updateStrokeColor", "Landroid/graphics/drawable/Drawable$ConstantState;", "getConstantState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "Landroid/content/res/Resources;", "r", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "Landroid/util/AttributeSet;", "attrs", "Landroid/content/res/Resources$Theme;", "theme", "inflate", "(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V", "normal", "pressed", "selected", CommonConfirmDialog.ARGS_CHECKED, "hover", "disabled", "setSolidColors", "(IIIIII)V", "Landroid/content/res/ColorStateList;", "solidColors", "(Landroid/content/res/ColorStateList;)V", Style.KEY_WIDTH, "setStrokeConfigs", "(IIIIIII)V", "strokeColors", "(ILandroid/content/res/ColorStateList;)V", "enable", "setEnableShadow", "(Z)V", "shadowConfigs", "setShadowConfigs", "([Lcom/obric/oui/shadow/a;)V", "endAnimation", "isStateful", "()Z", "materialConfig", "srcType", "drawMode", "applyImmediately", "setMaterialConfig", "(Lcom/obric/oui/material/b;IIZ)V", "materialConfigs", "setMaterialConfigs", "([Lcom/obric/oui/material/b;IIZ)V", "Landroid/graphics/Rect;", "onBoundsChange", "(Landroid/graphics/Rect;)V", "draw", "jumpToCurrentState", "setState", "onStateChange", "Landroid/content/res/ColorStateList;", "strokeWidth", "I", "targetSolidColor", "targetStrokeColor", "animatedSolidColor", "animatedStrokeColor", "Landroid/animation/ValueAnimator;", "colorAnimator", "Landroid/animation/ValueAnimator;", "strokeAnimator", "", "animDuration", "J", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "Landroid/view/animation/LinearInterpolator;", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "lastStateSet", "[I", "enableShadow", "Z", "[Lcom/obric/oui/material/b;", "materialSrcType", "materialDrawMode", "[Lcom/obric/oui/shadow/a;", "Landroid/graphics/Paint;", "shadowPaint", "Landroid/graphics/Paint;", "shadowClipPath", "Landroid/graphics/Path;", "shadowDrawPath", "Landroid/graphics/RectF;", "tmpRectF", "Landroid/graphics/RectF;", "tmpShadowRectF", "isCallbackInitArray", "[Ljava/lang/Boolean;", "()[Ljava/lang/Boolean;", "setCallbackInitArray", "([Ljava/lang/Boolean;)V", "requireApiVersion", "getRequireApiVersion", "()I", "setRequireApiVersion", "(I)V", "envMaterialApiVersion", "getEnvMaterialApiVersion", "currentBlendConfigsArray", "[[Lcom/obric/oui/color/a;", "drawBlendConfigsArray", "currentOverlayBlendConfigsArray", "drawOverlayBlendConfigsArray", "currentStrokeConfigArray", "[Lcom/obric/oui/color/j0;", "blendAnimatorArray", "[Landroid/animation/ValueAnimator;", "overlayBlendAnimatorArray", "enableStateChangeTransition", "getEnableStateChangeTransition", "setEnableStateChangeTransition", "Companion", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMaterialDrawable extends GradientDrawable {

    @NotNull
    public static final a Companion = null;
    public static final boolean DEBUGGABLE = false;
    private static final int MAX_MATERIAL_CONFIG_COUNT = 2;

    @NotNull
    public static final String TAG = "OMaterialDrawable";
    private long animDuration;

    @NotNull
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;

    @NotNull
    private ValueAnimator[] blendAnimatorArray;

    @Nullable
    private ValueAnimator colorAnimator;

    @NotNull
    private com.obric.oui.color.a[][] currentBlendConfigsArray;

    @NotNull
    private com.obric.oui.color.a[][] currentOverlayBlendConfigsArray;

    @NotNull
    private j0[] currentStrokeConfigArray;

    @NotNull
    private com.obric.oui.color.a[][] drawBlendConfigsArray;

    @NotNull
    private com.obric.oui.color.a[][] drawOverlayBlendConfigsArray;
    private boolean enableShadow;
    private boolean enableStateChangeTransition;
    private final int envMaterialApiVersion;

    @NotNull
    private Boolean[] isCallbackInitArray;

    @Nullable
    private int[] lastStateSet;

    @Nullable
    private com.obric.oui.material.b[] materialConfigs;
    private int materialDrawMode;
    private int materialSrcType;

    @NotNull
    private ValueAnimator[] overlayBlendAnimatorArray;
    private int requireApiVersion;

    @NotNull
    private final Path shadowClipPath;

    @Nullable
    private com.obric.oui.shadow.a[] shadowConfigs;

    @NotNull
    private final Path shadowDrawPath;

    @NotNull
    private final Paint shadowPaint;

    @Nullable
    private ColorStateList solidColors;

    @Nullable
    private ValueAnimator strokeAnimator;

    @Nullable
    private ColorStateList strokeColors;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;

    @NotNull
    private final RectF tmpRectF;

    @NotNull
    private final RectF tmpShadowRectF;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f15196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f15198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ColorStateList f15199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f15200e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ColorStateList f15201f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f15202g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f15203h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final com.obric.oui.material.b[] f15204i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f15205j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f15206k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final com.obric.oui.shadow.a[] f15207l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f15208m;

        public b(Drawable.ConstantState r10, int r11, boolean r12, ColorStateList r13, int r14, ColorStateList r15, long r16, boolean r17, com.obric.oui.material.b[] r18, int r19, int r110, com.obric.oui.shadow.a[] r111, int r112) {
            this.f15196a = r10;
            this.f15197b = r11;
            this.f15198c = r12;
            this.f15199d = r13;
            this.f15200e = r14;
            this.f15201f = r15;
            this.f15202g = r16;
            this.f15203h = r17;
            this.f15204i = r18;
            this.f15205j = r19;
            this.f15206k = r110;
            this.f15207l = r111;
            this.f15208m = r112;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f15197b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r10) {
            return newDrawable(r10, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r10, Resources.Theme r11) {
            GradientDrawable r12 = null;
            Drawable.ConstantState r13 = this.f15196a;     // Catch: Exception -> L21
            if (r13 == null) goto L12;
            if (r11 == null) goto L8;
            Drawable r14 = r13.newDrawable(r10, r11);     // Catch: Exception -> L21
        L13:
            OMaterialDrawable r15 = new OMaterialDrawable();
            if ((r14 instanceof GradientDrawable) == false) goto L16;
            r12 = (GradientDrawable) r14;
        L16:
            if (r12 == null) goto L19;
            OMaterialDrawable.access$copyGradientInternalStateFrom(r15, r12);
        L19:
            OMaterialDrawable.access$setEnableShadow$p(r15, this.f15198c);
            r15.setAnimDuration(this.f15202g);
            r15.setEnableStateChangeTransition(this.f15203h);
            r15.setMaterialConfigs(this.f15204i, this.f15205j, this.f15206k, false);
            r15.setShadowConfigs(this.f15207l);
            r15.setSolidColors(this.f15199d);
            r15.setStrokeConfigs(this.f15200e, this.f15201f);
            Boolean r16 = Boolean.FALSE;
            r15.setCallbackInitArray(new Boolean[]{r16, r16});
            r15.setRequireApiVersion(this.f15208m);
            return r15;
        L8:
            if (r10 == null) goto L10;
            r14 = r13.newDrawable(r10);     // Catch: Exception -> L21
            goto L13
        L10:
            r14 = r13.newDrawable();     // Catch: Exception -> L21
        L12:
            r14 = null;
            goto L13
        }
    }

    static {
        Companion = new a(null);
    }

    public OMaterialDrawable() {
        this.animDuration = Token$Duration.OUI_ANIMATION_DURATION_SHORT_3.getDuration();
        this.animInterpolator = new LinearInterpolator();
        this.materialSrcType = 2;
        this.materialDrawMode = 1;
        Paint r10 = new Paint(1);
        r10.setStyle(Paint.Style.FILL);
        this.shadowPaint = r10;
        this.shadowClipPath = new Path();
        this.shadowDrawPath = new Path();
        this.tmpRectF = new RectF();
        this.tmpShadowRectF = new RectF();
        Boolean r11 = Boolean.FALSE;
        this.isCallbackInitArray = new Boolean[]{r11, r11};
        this.requireApiVersion = 1;
        this.envMaterialApiVersion = OMaterialHelper.p();
        this.currentBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentStrokeConfigArray = new j0[2];
        this.blendAnimatorArray = new ValueAnimator[2];
        this.overlayBlendAnimatorArray = new ValueAnimator[2];
        this.enableStateChangeTransition = true;
    }

    public static /* synthetic */ void a(j0 r10, j0 r11, OMaterialDrawable r12, View r13, ValueAnimator r14) {
        m22updateStrokeConfig$lambda29$lambda28(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ void access$copyGradientInternalStateFrom(OMaterialDrawable r10, GradientDrawable r11) {
        r10.copyGradientInternalStateFrom(r11);
    }

    public static final /* synthetic */ void access$setEnableShadow$p(OMaterialDrawable r10, boolean r11) {
        r10.enableShadow = r11;
    }

    public static /* synthetic */ void b(OMaterialDrawable r10, ValueAnimator r11) {
        m20updateSolidColor$lambda31$lambda30(r10, r11);
    }

    public static /* synthetic */ void c(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, Object r12, OMaterialDrawable r13, int r14, ValueAnimator r15) {
        m19updateOverlayBlendConfigs$lambda26$lambda25(r10, r11, r12, r13, r14, r15);
    }

    private final void clipOutShadowPath(Canvas r10, Path r11) {
        r10.clipOutPath(r11);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private final void copyGradientInternalStateFrom(GradientDrawable r10) {
        Field r11 = GradientDrawable.class.getDeclaredField("mGradientState");     // Catch: Exception -> L4
        r11.setAccessible(true);     // Catch: Exception -> L4
        r11.set(this, r11.get(r10));     // Catch: Exception -> L4
        return;
    }

    public static /* synthetic */ void d(OMaterialDrawable r10, ValueAnimator r11) {
        m21updateStrokeColor$lambda33$lambda32(r10, r11);
    }

    @RequiresApi(24)
    private final void drawMultiLayerShadow(Canvas r17) {
        com.obric.oui.shadow.a[] r10 = this.shadowConfigs;
        int r11 = 0;
        if (r10 != null) goto L20;
        com.obric.oui.material.b[] r12 = this.materialConfigs;
        if (r12 != null) goto L7;
    L6:
        r10 = null;
    L17:
        if (r10 != null) goto L20;
        return;
    L7:
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        com.obric.oui.material.b r15 = r12[r14];
        if (r15.i() != null) goto L14;
        r14 = r14 + 1;
    L14:
        if (r15 == null) goto L6;
        r10 = r15.i();
        goto L17
    L13:
        r15 = null;
    L20:
        if (r10.length != 0) goto L22;
        return;
    L22:
        Rect r16 = getBounds();
        kotlin.jvm.internal.q.f(r16, "bounds");
        if (r16.isEmpty() == false) goto L25;
        return;
    L25:
        this.tmpRectF.set(r16);
        int r18 = getShape();
        float[] r19 = getCornerRadii();
        float r20 = getCornerRadius();
        this.shadowClipPath.reset();
        if (r18 != 1) goto L28;
        this.shadowClipPath.addOval(this.tmpRectF, Path.Direction.CW);
    L34:
        int r110 = r10.length;
    L35:
        if (r11 >= r110) goto L53;
        com.obric.oui.shadow.a r111 = r10[r11];
        r11 = r11 + 1;
        if (isShadowValid(r111) == false) goto L35;
        int r112 = r17.save();
        clipOutShadowPath(r17, this.shadowClipPath);
        this.tmpShadowRectF.set(this.tmpRectF);
        float r113 = r17.getDensity() / 160.0f;
        this.tmpShadowRectF.offset(tc.f.j(r111.e(), r113), tc.f.j(r111.f(), r113));
        this.tmpShadowRectF.inset(-r111.d(), -r111.d());
        this.shadowPaint.setColor(r111.c());
        Paint r21 = this.shadowPaint;
        if (r111.b() <= 0.0f) goto L42;
        BlurMaskFilter r114 = new BlurMaskFilter(r111.b(), BlurMaskFilter.Blur.NORMAL);
    L43:
        r21.setMaskFilter(r114);
        if (r18 != 1) goto L46;
        r17.drawOval(this.tmpShadowRectF, this.shadowPaint);
    L52:
        r17.restoreToCount(r112);
        goto L35
    L46:
        if (r19 == null) goto L49;
        this.shadowDrawPath.reset();
        this.shadowDrawPath.addRoundRect(this.tmpShadowRectF, r19, Path.Direction.CW);
        r17.drawPath(this.shadowDrawPath, this.shadowPaint);
        goto L52
    L49:
        if (r20 <= 0.0f) goto L51;
        r17.drawRoundRect(this.tmpShadowRectF, r20, r20, this.shadowPaint);
        goto L52
    L51:
        r17.drawRect(this.tmpShadowRectF, this.shadowPaint);
        goto L52
    L42:
        r114 = null;
        goto L43
    L53:
        return;
    L28:
        if (r19 == null) goto L31;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r19, Path.Direction.CW);
        goto L34
    L31:
        if (r20 <= 0.0f) goto L33;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r20, r20, Path.Direction.CW);
        goto L34
    L33:
        this.shadowClipPath.addRect(this.tmpRectF, Path.Direction.CW);
        goto L34
    }

    public static /* synthetic */ void e(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, OMaterialDrawable r12, int r13, Object r14, ValueAnimator r15) {
        m18updateBlendConfigs$lambda24$lambda23(r10, r11, r12, r13, r14, r15);
    }

    private final boolean isShadowValid(com.obric.oui.shadow.a r10) {
        if (r10.c() != 0) goto L6;
        return false;
    L6:
        if (r10.e() == 0.0f) goto L8;
    L14:
        return true;
    L8:
        if (r10.f() != 0.0f) goto L14;
        if (r10.b() != 0.0f) goto L14;
        if (r10.d() != 0.0f) goto L14;
        return false;
    }

    private final boolean processMaterialOnStateChange(View r15, Object r16, int r17, int[] r18, com.obric.oui.material.b r19) {
        setColor(0);
        this.targetSolidColor = 0;
        int[] r10 = this.lastStateSet;
        if (this.isCallbackInitArray[r17].booleanValue() == true) goto L18;
        OMaterialHelper.H(r16, this.materialSrcType, this.materialDrawMode);
        Float r11 = r19.e();
        if (r11 == null) goto L8;
        OMaterialHelper.R(r16, r11.floatValue());
    L8:
        com.obric.oui.fluid.a r12 = r19.g();
        if (r12 == null) goto L12;
        OMaterialHelper.K(r16, true, r12.a());
    L12:
        com.obric.oui.shadow.a[] r13 = r19.i();
        if (r13 == null) goto L18;
        com.obric.oui.shadow.a r14 = (com.obric.oui.shadow.a) kotlin.collections.n.s(r13);
        if (r14 == null) goto L18;
        Paint r20 = this.shadowPaint;
        int[] r21 = com.obric.oui.shadow.a.f16761g.b(r14);
        OMaterialHelper.A(r20, Arrays.copyOf(r21, r21.length));
    L18:
        ld.a r22 = r19.c();
        j0 r110 = null;
        if (r22 != null) goto L21;
        com.obric.oui.color.a[] r23 = null;
    L22:
        if (r23 != null) goto L24;
        r23 = r19.b();
    L24:
        com.obric.oui.color.a[] r24 = r23;
        if (r24 == null) goto L34;
        com.obric.oui.color.a[] r25 = this.drawBlendConfigsArray[r17];
        if (this.enableStateChangeTransition == false) goto L32;
        if (r22 == null) goto L32;
        if (r10 == null) goto L32;
        if (r25 == null) goto L32;
        boolean r26 = true;
    L33:
        updateBlendConfigs(r16, r17, r26, r25, r24);
    L32:
        r26 = false;
    L34:
        ld.a r27 = r19.h();
        if (r27 != null) goto L37;
        com.obric.oui.color.a[] r28 = null;
    L38:
        if (r28 == null) goto L46;
        com.obric.oui.color.a[] r29 = this.drawOverlayBlendConfigsArray[r17];
        if (this.enableStateChangeTransition == false) goto L44;
        if (r10 == null) goto L44;
        if (r29 == null) goto L44;
        boolean r30 = true;
    L45:
        updateOverlayBlendConfigs(r16, r17, r30, r29, r28);
    L44:
        r30 = false;
    L46:
        ld.c r31 = r19.k();
        if (r31 == null) goto L50;
        r110 = ld.c.b(r31, r18, null, 2, null);
    L50:
        if (r110 != null) goto L52;
        r110 = r19.j();
    L52:
        if (r110 == null) goto L61;
        j0 r32 = this.currentStrokeConfigArray[r17];
        if (this.enableStateChangeTransition == false) goto L59;
        if (r31 == null) goto L59;
        if (r10 == null) goto L59;
        if (r32 == null) goto L59;
        boolean r33 = true;
    L60:
        updateStrokeConfig(r15, r16, r17, r33, r32, r110);
    L59:
        r33 = false;
    L61:
        this.lastStateSet = (int[]) r18.clone();
        this.isCallbackInitArray[r17] = Boolean.TRUE;
        return false;
    L37:
        r28 = ld.a.b(r27, r18, null, 2, null);
        goto L38
    L21:
        r23 = ld.a.b(r22, r18, null, 2, null);
        goto L22
    }

    private final boolean processSolidAndStrokeOnStateChange(int[] r10) {
        ColorStateList r11 = this.solidColors;
        boolean r12 = false;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        ColorStateList r14 = this.solidColors;
        if (r14 != null) goto L9;
        int r15 = 0;
    L11:
        if (r15 == this.targetSolidColor) goto L16;
        if (r15 != r13) goto L14;
        boolean r16 = true;
    L15:
        updateSolidColor(r15, r16);
        this.targetSolidColor = r15;
        boolean r17 = true;
    L17:
        ColorStateList r18 = this.strokeColors;
        if (r18 != null) goto L20;
        int r19 = 0;
    L21:
        ColorStateList r20 = this.strokeColors;
        if (r20 != null) goto L24;
        int r21 = 0;
    L26:
        if (r21 == this.targetStrokeColor) goto L31;
        if (r21 != r19) goto L29;
        r12 = true;
    L29:
        updateStrokeColor(r21, r12);
        this.targetStrokeColor = r21;
        return true;
    L31:
        return r17;
    L24:
        r21 = r20.getColorForState(r10, r19);
        goto L26
    L20:
        r19 = r18.getDefaultColor();
        goto L21
    L14:
        r16 = false;
        goto L15
    L16:
        r17 = false;
        goto L17
    L9:
        r15 = r14.getColorForState(r10, r13);
        goto L11
    L5:
        r13 = r11.getDefaultColor();
        goto L6
    }

    public static /* synthetic */ void setMaterialConfig$default(OMaterialDrawable r10, com.obric.oui.material.b r11, int r12, int r13, boolean r14, int r15, Object r16) {
        if (r16 != null) goto L15;
        if ((r15 & 2) == 0) goto L7;
        r12 = 2;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = 1;
    L10:
        if ((r15 & 8) == 0) goto L12;
        r14 = true;
    L12:
        r10.setMaterialConfig(r11, r12, r13, r14);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfig");
    }

    public static /* synthetic */ void setMaterialConfigs$default(OMaterialDrawable r10, com.obric.oui.material.b[] r11, int r12, int r13, boolean r14, int r15, Object r16) {
        if (r16 != null) goto L15;
        if ((r15 & 2) == 0) goto L7;
        r12 = 2;
    L7:
        if ((r15 & 4) == 0) goto L10;
        r13 = 1;
    L10:
        if ((r15 & 8) == 0) goto L12;
        r14 = true;
    L12:
        r10.setMaterialConfigs(r11, r12, r13, r14);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    private final void setMaterialToEffectObjectIfNotInit(Object r10, int r11, com.obric.oui.material.b r12) {
        if (this.isCallbackInitArray[r11].booleanValue() == true) goto L20;
        OMaterialHelper.H(r10, this.materialSrcType, this.materialDrawMode);
        Float r13 = r12.e();
        if (r13 == null) goto L8;
        OMaterialHelper.R(r10, r13.floatValue());
    L8:
        com.obric.oui.fluid.a r14 = r12.g();
        if (r14 == null) goto L12;
        OMaterialHelper.K(r10, true, r14.a());
    L12:
        com.obric.oui.shadow.a[] r15 = r12.i();
        if (r15 == null) goto L18;
        com.obric.oui.shadow.a r16 = (com.obric.oui.shadow.a) kotlin.collections.n.s(r15);
        if (r16 == null) goto L18;
        Paint r17 = this.shadowPaint;
        int[] r18 = com.obric.oui.shadow.a.f16761g.b(r16);
        OMaterialHelper.A(r17, Arrays.copyOf(r18, r18.length));
    L18:
        this.isCallbackInitArray[r11] = Boolean.TRUE;
        return;
    }

    public static /* synthetic */ void setSolidColors$default(OMaterialDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if (r18 != null) goto L26;
        if ((r17 & 2) == 0) goto L6;
        int r19 = r11;
    L8:
        if ((r17 & 4) == 0) goto L10;
        int r20 = r11;
    L12:
        if ((r17 & 8) == 0) goto L14;
        int r21 = r20;
    L16:
        if ((r17 & 16) == 0) goto L18;
        int r22 = r19;
    L20:
        if ((r17 & 32) == 0) goto L22;
        int r23 = r11;
    L23:
        r10.setSolidColors(r11, r19, r20, r21, r22, r23);
        return;
    L22:
        r23 = r16;
        goto L23
    L18:
        r22 = r15;
        goto L20
    L14:
        r21 = r14;
        goto L16
    L10:
        r20 = r13;
        goto L12
    L6:
        r19 = r12;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSolidColors");
    }

    public static /* synthetic */ void setStrokeConfigs$default(OMaterialDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, Object r19) {
        if (r19 != null) goto L26;
        if ((r18 & 4) == 0) goto L6;
        int r20 = r12;
    L8:
        if ((r18 & 8) == 0) goto L10;
        int r21 = r12;
    L12:
        if ((r18 & 16) == 0) goto L14;
        int r22 = r21;
    L16:
        if ((r18 & 32) == 0) goto L18;
        int r23 = r20;
    L20:
        if ((r18 & 64) == 0) goto L22;
        int r24 = r12;
    L23:
        r10.setStrokeConfigs(r11, r12, r20, r21, r22, r23, r24);
        return;
    L22:
        r24 = r17;
        goto L23
    L18:
        r23 = r16;
        goto L20
    L14:
        r22 = r15;
        goto L16
    L10:
        r21 = r14;
        goto L12
    L6:
        r20 = r13;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStrokeConfigs");
    }

    private final boolean updateBlendConfigs(final Object r10, final int r11, boolean r12, final com.obric.oui.color.a[] r13, final com.obric.oui.color.a[] r14) {
        if (r13 != null) goto L5;
    L8:
        ValueAnimator r15 = this.blendAnimatorArray[r11];
        if (r15 == null) goto L13;
        r15.cancel();
    L13:
        if (r14 != null) goto L16;
        int[] r16 = OMaterialHelper.V(new com.obric.oui.color.a[0]);
        OMaterialHelper.z(r10, Arrays.copyOf(r16, r16.length));
        this.currentBlendConfigsArray[r11] = null;
        this.drawBlendConfigsArray[r11] = null;
        return true;
    L16:
        if (r12 == false) goto L18;
        ValueAnimator[] r17 = this.blendAnimatorArray;
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r18.setDuration(getAnimDuration());
        r18.setInterpolator(getAnimInterpolator());
        r18.addUpdateListener(new k(r13, r14, this, r11, r10));
        r18.start();
        Unit r19 = Unit.f21064a;
        r17[r11] = r18;
    L19:
        this.currentBlendConfigsArray[r11] = r14;
        this.drawBlendConfigsArray[r11] = r14;
        return true;
    L18:
        int[] r110 = OMaterialHelper.V(r14);
        OMaterialHelper.z(r10, Arrays.copyOf(r110, r110.length));
        goto L19
    L5:
        if (Arrays.equals(r13, r14) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateBlendConfigs$lambda-24$lambda-23, reason: not valid java name */
    private static final void m18updateBlendConfigs$lambda24$lambda23(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, OMaterialDrawable r12, int r13, Object r14, ValueAnimator r15) {
        kotlin.jvm.internal.q.g(r12, "this$0");
        kotlin.jvm.internal.q.g(r14, "$effectParams");
        kotlin.jvm.internal.q.g(r15, "animator");
        Object r16 = r15.getAnimatedValue();
        if (r16 == null) goto L7;
        float r17 = ((Float) r16).floatValue();
        ld.a.C0305a r18 = ld.a.f21932b;
        kotlin.jvm.internal.q.d(r10);
        com.obric.oui.color.a[] r19 = r18.b(r10, r11, r17);
        r12.drawBlendConfigsArray[r13] = r19;
        int[] r20 = OMaterialHelper.V(r19);
        OMaterialHelper.z(r14, Arrays.copyOf(r20, r20.length));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final boolean updateOverlayBlendConfigs(final Object r10, final int r11, boolean r12, final com.obric.oui.color.a[] r13, final com.obric.oui.color.a[] r14) {
        if (r13 != null) goto L4;
    L8:
        ValueAnimator r15 = this.overlayBlendAnimatorArray[r11];
        if (r15 == null) goto L13;
        r15.cancel();
    L13:
        if (r14 != null) goto L16;
        this.currentOverlayBlendConfigsArray[r11] = null;
        this.drawOverlayBlendConfigsArray[r11] = null;
        return true;
    L16:
        if (r12 == false) goto L18;
        ValueAnimator[] r16 = this.overlayBlendAnimatorArray;
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r17.setDuration(getAnimDuration());
        r17.setInterpolator(getAnimInterpolator());
        r17.addUpdateListener(new m(r13, r14, r10, this, r11));
        r17.start();
        Unit r18 = Unit.f21064a;
        r16[r11] = r17;
    L18:
        this.currentOverlayBlendConfigsArray[r11] = r14;
        this.drawOverlayBlendConfigsArray[r11] = r14;
        return true;
    L4:
        if (Arrays.equals(r13, r14) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateOverlayBlendConfigs$lambda-26$lambda-25, reason: not valid java name */
    private static final void m19updateOverlayBlendConfigs$lambda26$lambda25(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, Object r12, OMaterialDrawable r13, int r14, ValueAnimator r15) {
        kotlin.jvm.internal.q.g(r12, "$effectParams");
        kotlin.jvm.internal.q.g(r13, "this$0");
        kotlin.jvm.internal.q.g(r15, "animator");
        Object r16 = r15.getAnimatedValue();
        if (r16 == null) goto L7;
        float r17 = ((Float) r16).floatValue();
        ld.a.C0305a r18 = ld.a.f21932b;
        kotlin.jvm.internal.q.d(r10);
        com.obric.oui.color.a[] r19 = r18.b(r10, r11, r17);
        OMaterialHelper.S(r12, r19[0].c(), 1.0f, r19[0].b());
        r13.drawOverlayBlendConfigsArray[r14] = r19;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void updateSolidColor(int r10, boolean r11) {
        ValueAnimator r12 = this.colorAnimator;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        if (r11 == false) goto L8;
        int r13 = this.animatedSolidColor;
        ValueAnimator r14 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r13), Integer.valueOf(r10)});
        r14.setDuration(getAnimDuration());
        r14.setInterpolator(getAnimInterpolator());
        r14.addUpdateListener(new l(this));
        r14.start();
        this.colorAnimator = r14;
        return;
    L8:
        this.animatedSolidColor = r10;
        setColor(r10);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-31$lambda-30, reason: not valid java name */
    private static final void m20updateSolidColor$lambda31$lambda30(OMaterialDrawable r10, ValueAnimator r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "animator");
        Object r12 = r11.getAnimatedValue();
        if (r12 == null) goto L7;
        int r13 = ((Integer) r12).intValue();
        r10.animatedSolidColor = r13;
        r10.setColor(r13);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void updateStrokeColor(int r10, boolean r11) {
        ValueAnimator r12 = this.strokeAnimator;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        if (r11 == false) goto L8;
        int r13 = this.animatedStrokeColor;
        ValueAnimator r14 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r13), Integer.valueOf(r10)});
        r14.setDuration(getAnimDuration());
        r14.setInterpolator(getAnimInterpolator());
        r14.addUpdateListener(new j(this));
        r14.start();
        this.strokeAnimator = r14;
        return;
    L8:
        this.animatedStrokeColor = r10;
        setStroke(this.strokeWidth, r10);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-33$lambda-32, reason: not valid java name */
    private static final void m21updateStrokeColor$lambda33$lambda32(OMaterialDrawable r10, ValueAnimator r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "animator");
        Object r12 = r11.getAnimatedValue();
        if (r12 == null) goto L7;
        int r13 = ((Integer) r12).intValue();
        r10.animatedStrokeColor = r13;
        r10.setStroke(r10.strokeWidth, r13);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean updateStrokeConfig(final View r10, Object r11, int r12, boolean r13, final j0 r14, final j0 r15) {
        if (r14 != null) goto L4;
    L8:
        ValueAnimator r16 = this.strokeAnimator;
        if (r16 == null) goto L12;
        r16.cancel();
    L12:
        if (r13 == false) goto L14;
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r17.setDuration(getAnimDuration());
        r17.setInterpolator(getAnimInterpolator());
        r17.addUpdateListener(new n(r14, r15, this, r10));
        r17.start();
        this.strokeAnimator = r17;
    L15:
        j0[] r18 = this.currentStrokeConfigArray;
        kotlin.jvm.internal.q.d(r15);
        r18[r12] = r15;
        return true;
    L14:
        kotlin.jvm.internal.q.d(r15);
        setStroke(tc.f.q(r10, r15.c()), r15.b());
        goto L15
    L4:
        if (r14.equals(r15) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateStrokeConfig$lambda-29$lambda-28, reason: not valid java name */
    private static final void m22updateStrokeConfig$lambda29$lambda28(j0 r10, j0 r11, OMaterialDrawable r12, View r13, ValueAnimator r14) {
        kotlin.jvm.internal.q.g(r12, "this$0");
        kotlin.jvm.internal.q.g(r13, "$view");
        kotlin.jvm.internal.q.g(r14, "animator");
        Object r15 = r14.getAnimatedValue();
        if (r15 == null) goto L10;
        float r16 = ((Float) r15).floatValue();
        ld.c.a r17 = ld.c.f21939b;
        kotlin.jvm.internal.q.d(r10);
        kotlin.jvm.internal.q.d(r11);
        j0 r18 = r17.b(r10, r11, r16);
        if (r18 == null) goto L11;
        r12.setStroke(tc.f.q(r13, r18.c()), r18.b());
        return;
    L11:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas r10) {
        kotlin.jvm.internal.q.g(r10, "canvas");
        if (this.enableShadow == false) goto L5;
        drawMultiLayerShadow(r10);
    L5:
        super.draw(r10);
    }

    public final void endAnimation() {
        ValueAnimator r10 = this.colorAnimator;
        if (r10 == null) goto L6;
        r10.end();
    L6:
        ValueAnimator r11 = this.strokeAnimator;
        if (r11 == null) goto L10;
        r11.end();
    L10:
        ValueAnimator[] r12 = this.blendAnimatorArray;
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L11:
        if (r15 >= r13) goto L17;
        ValueAnimator r16 = r12[r15];
        if (r16 == null) goto L16;
        r16.end();
    L16:
        r15 = r15 + 1;
        goto L11
    L17:
        ValueAnimator[] r17 = this.overlayBlendAnimatorArray;
        int r18 = r17.length;
    L18:
        if (r14 >= r18) goto L24;
        ValueAnimator r19 = r17[r14];
        if (r19 == null) goto L23;
        r19.end();
    L23:
        r14 = r14 + 1;
        goto L18
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    @NotNull
    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return new b(super.getConstantState(), getChangingConfigurations(), this.enableShadow, this.solidColors, this.strokeWidth, this.strokeColors, this.animDuration, this.enableStateChangeTransition, this.materialConfigs, this.materialSrcType, this.materialDrawMode, this.shadowConfigs, this.requireApiVersion);
    }

    public final boolean getEnableStateChangeTransition() {
        return this.enableStateChangeTransition;
    }

    public final int getEnvMaterialApiVersion() {
        return this.envMaterialApiVersion;
    }

    public final int getRequireApiVersion() {
        return this.requireApiVersion;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void inflate(@NotNull Resources r17, @NotNull XmlPullParser r18, @NotNull AttributeSet r19, @Nullable Resources.Theme r20) {
        kotlin.jvm.internal.q.g(r17, "r");
        kotlin.jvm.internal.q.g(r18, "parser");
        kotlin.jvm.internal.q.g(r19, "attrs");
        if (r20 != null) goto L5;
        TypedArray r10 = null;
    L6:
        if (r10 != null) goto L55;
        r10 = r17.obtainAttributes(r19, R$styleable.OMaterialDrawable);
    L55:
        boolean r11 = true;
        this.requireApiVersion = r10.getInt(R$styleable.OMaterialDrawable_oui_widgetMaterialApiVersion, 1);     // Catch: Throwable -> L20
        ColorStateList r12 = r10.getColorStateList(R$styleable.OMaterialDrawable_oui_solidColor);     // Catch: Throwable -> L20
        ColorStateList r13 = r10.getColorStateList(R$styleable.OMaterialDrawable_oui_strokeColor);     // Catch: Throwable -> L20
        int r14 = r10.getDimensionPixelSize(R$styleable.OMaterialDrawable_oui_strokeWidth, -1);     // Catch: Throwable -> L20
        this.enableShadow = r10.getBoolean(R$styleable.OMaterialDrawable_oui_widgetEnableShadow, false);     // Catch: Throwable -> L20
        String r15 = r10.getString(R$styleable.OMaterialDrawable_oui_widgetMaterial);     // Catch: Throwable -> L20
        int r16 = r10.getInt(R$styleable.OMaterialDrawable_oui_widgetMaterialSrcType, 2);     // Catch: Throwable -> L20
        int r110 = r10.getInt(R$styleable.OMaterialDrawable_oui_widgetMaterialDrawMode, 1);     // Catch: Throwable -> L20
        if (r15 != null) goto L11;
    L40:
        this.materialSrcType = r16;     // Catch: Throwable -> L20
        this.materialDrawMode = r110;     // Catch: Throwable -> L20
    L41:
        r10.recycle();
        super.inflate(r17, r18, r19, r20);
        if (r12 != null) goto L44;
        r12 = getColor();
    L44:
        if (r12 != null) goto L46;
        r12 = ColorStateList.valueOf(0);
    L46:
        setSolidColors(r12);
        if (r13 != null) goto L49;
        r13 = ColorStateList.valueOf(0);
    L49:
        this.strokeColors = r13;
        if (r14 < 0) goto L56;
        setStrokeConfigs(r14, r13);
        return;
    L56:
        return;
    L11:
        if (kotlin.text.o.r(r15) == true) goto L40;
        if ((r17.getConfiguration().uiMode & 48) != 32) goto L17;
        r11 = false;
    L17:
        com.obric.oui.material.b[] r21 = MaterialToken.parseSet(r15, r11);     // Catch: Throwable -> L20
        if (r21 == null) goto L22;
        setMaterialConfigs(r21, r16, r110, false);     // Catch: Throwable -> L20
    L31:
        if (r12 != null) goto L41;
        com.obric.oui.material.b[] r22 = this.materialConfigs;     // Catch: Throwable -> L20
        if (r22 != null) goto L35;
    L34:
        ColorStateList r23 = null;
    L39:
        r12 = r23;
        goto L41
    L35:
        com.obric.oui.material.b r24 = (com.obric.oui.material.b) kotlin.collections.n.s(r22);     // Catch: Throwable -> L20
        if (r24 == null) goto L34;
        r23 = r24.f();     // Catch: Throwable -> L20
        goto L39
    L22:
        com.obric.oui.material.b r25 = MaterialToken.parse(r15, r11);     // Catch: Throwable -> L20
        if (r25 != null) goto L28;
        Function1<Boolean, com.obric.oui.material.b> r26 = MaterialToken.parse(r15);     // Catch: Throwable -> L20
        if (r26 != null) goto L27;
        r25 = null;
        goto L28
    L27:
        r25 = r26.invoke(Boolean.valueOf(r11));     // Catch: Throwable -> L20
    L28:
        if (r25 == null) goto L31;
        setMaterialConfig(r25, r16, r110, false);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r10.recycle();
        throw th;
    L5:
        r10 = r20.obtainStyledAttributes(r19, R$styleable.OMaterialDrawable, 0, 0);
        goto L6
    }

    @NotNull
    public final Boolean[] isCallbackInitArray() {
        return this.isCallbackInitArray;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        endAnimation();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(@NotNull Rect r10) {
        kotlin.jvm.internal.q.g(r10, "r");
        super.onBoundsChange(r10);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(@NotNull int[] r14) {
        kotlin.jvm.internal.q.g(r14, "stateSet");
        Drawable.Callback r10 = getCallback();
        if ((r10 instanceof View) == false) goto L5;
        View r11 = (View) r10;
    L7:
        if (r11 != null) goto L9;
    L39:
        boolean r12 = processSolidAndStrokeOnStateChange(r14);
        if (r12 == false) goto L42;
        invalidateSelf();
    L42:
        if (r12 == false) goto L44;
        return true;
    L44:
        if (super.onStateChange(r14) == false) goto L47;
        return true;
    L47:
        return false;
    L9:
        if (OMaterialHelper.u(r11.getContext()) == true) goto L11;
    L38:
        OMaterialHelper.H(r11, 0, this.materialDrawMode);
        goto L39
    L11:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L38;
        com.obric.oui.material.b[] r13 = this.materialConfigs;
        if (r13 == null) goto L39;
        int r15 = r13.length;
        boolean r16 = false;
        int r17 = 0;
    L16:
        if (r17 >= r15) goto L30;
        int r18 = r17 + 1;
        g r19 = OMaterialHelper.r(r11, r18);
        if (r19 != null) goto L20;
        Object r20 = null;
    L21:
        if (r20 == null) goto L29;
        com.obric.oui.material.b r21 = r13[r17];
        if (r16 == false) goto L25;
    L28:
        r16 = true;
        goto L29
    L25:
        if (processMaterialOnStateChange(r11, r20, r17, r14, r21) == true) goto L28;
        r16 = false;
    L29:
        r17 = r18;
        goto L16
    L20:
        r20 = r19.a();
        goto L21
    L30:
        if (r16 == false) goto L32;
        invalidateSelf();
    L32:
        if (r16 == false) goto L34;
        return true;
    L34:
        if (super.onStateChange(r14) == false) goto L37;
        return true;
    L37:
        return false;
    L5:
        r11 = null;
        goto L7
    }

    public final void setAnimDuration(long r10) {
        this.animDuration = r10;
    }

    public final void setAnimInterpolator(@NotNull LinearInterpolator r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.animInterpolator = r10;
    }

    public final void setCallbackInitArray(@NotNull Boolean[] r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.isCallbackInitArray = r10;
    }

    public final void setEnableShadow(boolean r10) {
        this.enableShadow = r10;
        invalidateSelf();
    }

    public final void setEnableStateChangeTransition(boolean r10) {
        this.enableStateChangeTransition = r10;
    }

    @JvmOverloads
    public final void setMaterialConfig(@NotNull com.obric.oui.material.b r10) {
        kotlin.jvm.internal.q.g(r10, "materialConfig");
        setMaterialConfig$default(this, r10, 0, 0, false, 14, null);
    }

    @JvmOverloads
    public final void setMaterialConfigs(@Nullable com.obric.oui.material.b[] r10) {
        setMaterialConfigs$default(this, r10, 0, 0, false, 14, null);
    }

    public final void setRequireApiVersion(int r10) {
        this.requireApiVersion = r10;
    }

    public final void setShadowConfigs(@Nullable com.obric.oui.shadow.a[] r10) {
        this.shadowConfigs = r10;
        invalidateSelf();
    }

    public final void setSolidColors(int r16, int r17, int r18, int r19, int r20, int r21) {
        setSolidColors(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{r19, r19, r18, r18, r18, r18, r17, r20, r18, r19, r21, r16}));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NotNull int[] r10) {
        kotlin.jvm.internal.q.g(r10, "stateSet");
        Drawable.Callback r11 = getCallback();
        if ((r11 instanceof View) == false) goto L5;
        View r12 = (View) r11;
    L6:
        if (r12 == null) goto L46;
        int r13 = 0;
        if (OMaterialHelper.u(r12.getContext()) == true) goto L10;
    L28:
        OMaterialHelper.H(r12, 0, this.materialDrawMode);
        ColorStateList r14 = this.solidColors;
        if (r14 != null) goto L31;
        int r15 = 0;
    L32:
        ColorStateList r16 = this.solidColors;
        if (r16 != null) goto L35;
        int r17 = 0;
    L36:
        setColor(r17);
        ColorStateList r18 = this.strokeColors;
        if (r18 != null) goto L39;
        int r19 = 0;
    L40:
        int r20 = tc.f.r(r12, this.strokeWidth);
        ColorStateList r21 = this.strokeColors;
        if (r21 == null) goto L44;
        r13 = r21.getColorForState(r10, r19);
    L44:
        setStroke(r20, r13);
        goto L46
    L39:
        r19 = r18.getDefaultColor();
        goto L40
    L35:
        r17 = r16.getColorForState(r10, r15);
        goto L36
    L31:
        r15 = r14.getDefaultColor();
        goto L32
    L10:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L28;
        Boolean[] r22 = this.isCallbackInitArray;
        int r23 = r22.length;
        int r24 = 0;
    L12:
        if (r24 >= r23) goto L46;
        if (r22[r24].booleanValue() == false) goto L15;
        r24 = r24 + 1;
        goto L12
    L15:
        com.obric.oui.material.b[] r25 = this.materialConfigs;
        if (r25 == null) goto L46;
        int r26 = r25.length;
    L19:
        if (r13 >= r26) goto L46;
        int r27 = r13 + 1;
        g r28 = OMaterialHelper.r(r12, r27);
        if (r28 != null) goto L23;
        Object r29 = null;
    L24:
        if (r29 == null) goto L26;
        setMaterialToEffectObjectIfNotInit(r29, r13, r25[r13]);
    L26:
        r13 = r27;
        goto L19
    L23:
        r29 = r28.a();
    L46:
        return super.setState(r10);
    L5:
        r12 = null;
        goto L6
    }

    public final void setStrokeConfigs(int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        this.strokeWidth = r18;
        ColorStateList r10 = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{r22, r22, r21, r21, r21, r21, r20, r23, r21, r22, r24, r19});
        this.strokeColors = r10;
        setStrokeConfigs(r18, r10);
    }

    @JvmOverloads
    public final void setMaterialConfig(@NotNull com.obric.oui.material.b r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "materialConfig");
        setMaterialConfig$default(this, r10, r11, 0, false, 12, null);
    }

    @JvmOverloads
    public final void setMaterialConfigs(@Nullable com.obric.oui.material.b[] r10, int r11) {
        setMaterialConfigs$default(this, r10, r11, 0, false, 12, null);
    }

    @JvmOverloads
    public final void setMaterialConfig(@NotNull com.obric.oui.material.b r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "materialConfig");
        setMaterialConfig$default(this, r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public final void setMaterialConfigs(@Nullable com.obric.oui.material.b[] r10, int r11, int r12) {
        setMaterialConfigs$default(this, r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public final void setMaterialConfig(@NotNull com.obric.oui.material.b r10, int r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "materialConfig");
        setMaterialConfigs(new com.obric.oui.material.b[]{r10}, r11, r12, r13);
    }

    @JvmOverloads
    public final void setMaterialConfigs(@Nullable com.obric.oui.material.b[] r10, int r11, int r12, boolean r13) {
        this.materialConfigs = r10;
        this.materialSrcType = r11;
        this.materialDrawMode = r12;
        this.currentBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentStrokeConfigArray = new j0[2];
        View r14 = null;
        this.lastStateSet = null;
        ValueAnimator[] r15 = this.blendAnimatorArray;
        int r16 = r15.length;
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r18 >= r16) goto L9;
        ValueAnimator r19 = r15[r18];
        if (r19 == null) goto L8;
        r19.cancel();
    L8:
        r18 = r18 + 1;
        goto L3
    L9:
        ValueAnimator[] r20 = this.overlayBlendAnimatorArray;
        int r21 = r20.length;
    L10:
        if (r17 >= r21) goto L16;
        ValueAnimator r22 = r20[r17];
        if (r22 == null) goto L15;
        r22.cancel();
    L15:
        r17 = r17 + 1;
        goto L10
    L16:
        if (r10 == null) goto L25;
        com.obric.oui.material.b r23 = (com.obric.oui.material.b) kotlin.collections.n.s(r10);
        if (r23 == null) goto L25;
        ColorStateList r24 = r23.f();
        if (r24 == null) goto L25;
        setSolidColors(r24);
    L25:
        Drawable.Callback r25 = getCallback();
        if ((r25 instanceof View) == false) goto L28;
        r14 = (View) r25;
    L28:
        if (r13 == false) goto L31;
        if (r14 == null) goto L31;
        int[] r26 = r14.getDrawableState();
        kotlin.jvm.internal.q.f(r26, "view.drawableState");
        onStateChange(r26);
    L31:
        invalidateSelf();
    }

    public final void setSolidColors(@Nullable ColorStateList r10) {
        this.solidColors = r10;
        if (r10 == null) goto L11;
        int r11 = r10.getColorForState(getState(), r10.getDefaultColor());
        this.targetSolidColor = r11;
        this.animatedSolidColor = r11;
        ValueAnimator r12 = this.colorAnimator;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        setColor(this.targetSolidColor);
        return;
    }

    public final void setStrokeConfigs(int r10, @Nullable ColorStateList r11) {
        if (r11 == null) goto L10;
        int r12 = r11.getDefaultColor();
        this.targetStrokeColor = r12;
        this.animatedStrokeColor = r12;
        ValueAnimator r13 = this.strokeAnimator;
        if (r13 == null) goto L8;
        r13.cancel();
    L8:
        setStroke(r10, this.targetStrokeColor);
        return;
    }
}
