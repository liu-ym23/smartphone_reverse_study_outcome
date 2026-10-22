package com.stepos.widget.password;

import Y8.t;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.N;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.circlebutton.StepOSCircleButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;
import v9.C5685n;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 ¿\u00012\u00020\u0001:\u0006À\u0001Á\u0001¿\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u000f\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u0012J3\u0010'\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00132\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000eH\u0002¢\u0006\u0004\b)\u0010\u0012J\u000f\u0010*\u001a\u00020\u000eH\u0002¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\u000eH\u0002¢\u0006\u0004\b+\u0010\u0012J\u000f\u0010,\u001a\u00020\u000eH\u0002¢\u0006\u0004\b,\u0010\u0012J\u000f\u0010-\u001a\u00020\u000eH\u0002¢\u0006\u0004\b-\u0010\u0012J\u000f\u0010.\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010\u0012J\u000f\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010\u0012J\r\u00100\u001a\u00020!¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020!¢\u0006\u0004\b2\u00101J\r\u00104\u001a\u000203¢\u0006\u0004\b4\u00105J\r\u00107\u001a\u000206¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u0004\u0018\u000109¢\u0006\u0004\b<\u0010;J\r\u0010>\u001a\u00020=¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u000e2\b\b\u0002\u0010@\u001a\u00020\f¢\u0006\u0004\bA\u0010\u001fJ\u0015\u0010B\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\f¢\u0006\u0004\bB\u0010\u001fJ\u0015\u0010D\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0013¢\u0006\u0004\bD\u0010\u0016J\u0015\u0010E\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0013¢\u0006\u0004\bE\u0010\u0016J\u0015\u0010G\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\f¢\u0006\u0004\bG\u0010\u001fJ\u0017\u0010J\u001a\u00020\u000e2\b\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bJ\u0010KJ\u0015\u0010M\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u0006¢\u0006\u0004\bM\u0010NJ!\u0010Q\u001a\u00020\u000e2\b\b\u0001\u0010O\u001a\u00020\u00062\b\b\u0001\u0010P\u001a\u00020\u0006¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\u000e2\b\b\u0001\u0010S\u001a\u00020\u0006¢\u0006\u0004\bT\u0010NJ\u0015\u0010U\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\f¢\u0006\u0004\bU\u0010\u001fJ\u001d\u0010X\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0006¢\u0006\u0004\bX\u0010RJ\r\u0010Y\u001a\u00020\u0006¢\u0006\u0004\bY\u0010ZJ\u0015\u0010[\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\f¢\u0006\u0004\b[\u0010\u001fJ\r\u0010\\\u001a\u00020\u000e¢\u0006\u0004\b\\\u0010\u0012J\r\u0010]\u001a\u00020\f¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\f¢\u0006\u0004\b_\u0010^J9\u0010b\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00132\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\f¢\u0006\u0004\bb\u0010cJ\u0015\u0010d\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0013¢\u0006\u0004\bd\u0010\u0016J\u0015\u0010e\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0013¢\u0006\u0004\be\u0010\u0016J\u000f\u0010f\u001a\u00020\u000eH\u0014¢\u0006\u0004\bf\u0010\u0012R\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010iR\u0014\u0010k\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010m\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010lR\u0014\u0010n\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010p\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010t\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010x\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010wR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R$\u0010~\u001a\u0012\u0012\u0004\u0012\u0002090|j\b\u0012\u0004\u0012\u000209`}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001d\u0010\u0082\u0001\u001a\b0\u0080\u0001j\u0003`\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0085\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0085\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0085\u0001R\u0019\u0010\u0089\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0085\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u0010\u008f\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010lR\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010lR\u0019\u0010\u0091\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008b\u0001R5\u0010C\u001a\u0005\u0018\u00010\u0092\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\bC\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0005\bD\u0010\u0097\u0001R7\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0092\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u0098\u0001\u0010\u0094\u0001\u001a\u0006\b\u0099\u0001\u0010\u0096\u0001\"\u0005\bE\u0010\u0097\u0001R'\u0010\u009a\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u009a\u0001\u0010\u0085\u0001\u001a\u0005\b\u009a\u0001\u0010^\"\u0005\b\u009b\u0001\u0010\u001fR'\u0010\u009c\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u009c\u0001\u0010\u0085\u0001\u001a\u0005\b\u009c\u0001\u0010^\"\u0005\b\u009d\u0001\u0010\u001fR0\u0010\u009e\u0001\u001a\u00020\f2\u0007\u0010\u0093\u0001\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u009e\u0001\u0010\u0085\u0001\u001a\u0005\b\u009e\u0001\u0010^\"\u0005\b\u009f\u0001\u0010\u001fR \u0010 \u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u000f\n\u0006\b \u0001\u0010\u008b\u0001\u0012\u0005\b¡\u0001\u0010\u0012R\u0019\u0010¢\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u008b\u0001R*\u0010£\u0001\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0005\b§\u0001\u0010KR\u0018\u0010©\u0001\u001a\u00030¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R(\u0010\u00ad\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b«\u0001\u0010Z\"\u0005\b¬\u0001\u0010NR(\u0010°\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b®\u0001\u0010Z\"\u0005\b¯\u0001\u0010NR*\u0010³\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b±\u0001\u0010Z\"\u0005\b²\u0001\u0010NR.\u0010¸\u0001\u001a\u0004\u0018\u00010$2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R.\u0010»\u0001\u001a\u0004\u0018\u00010$2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010µ\u0001\"\u0006\bº\u0001\u0010·\u0001R\u0014\u0010¾\u0001\u001a\u00020\u00138G¢\u0006\b\u001a\u0006\b¼\u0001\u0010½\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/stepos/widget/password/StepOSPasswordPad;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "type", "", "resetMaxLen", "LY8/t;", "applyKeyPadType", "(IZ)V", "attachTextWatcher", "()V", "", "pressed", "addPassword", "(Ljava/lang/String;)V", "digit", "addCell", "notifyCellAdded", "wireKeys", "wireInputTextButton", "onDigitClicked", "isLeft", "onCornerKeyClicked", "(Z)V", "onInputTextButtonClicked", "Lcom/stepos/widget/circlebutton/StepOSCircleButton;", "key", "label", "Landroid/graphics/drawable/Drawable;", "icon", x5.d.EXTRA_ENABLED, "applyCornerKey", "(Lcom/stepos/widget/circlebutton/StepOSCircleButton;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Z)V", "inflateBottomLayout", "updateInputTextButtonStatus", "rebuildDots", "refreshDots", "showSoftInput", "performHaptic", "cancelTipAnimator", "getLeftKeyButton", "()Lcom/stepos/widget/circlebutton/StepOSCircleButton;", "getRightKeyButton", "Landroid/widget/ImageView;", "getInputTextButton", "()Landroid/widget/ImageView;", "Landroid/widget/GridLayout;", "getKeyPad", "()Landroid/widget/GridLayout;", "Landroid/view/View;", "getLeftButton", "()Landroid/view/View;", "getRightButton", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "clearAll", "clear", "clearCell", "tip", "setTip", "setTip2", "visibility", "setTip2_Visibility", "Lcom/stepos/widget/password/StepOSPasswordPad$OnPanelListener;", "listener", "setPanelListener", "(Lcom/stepos/widget/password/StepOSPasswordPad$OnPanelListener;)V", "len", "setMaxLen", "(I)V", "width", "height", "setDigitKeyBoardSize", "(II)V", "space", "setDisplaySpace", "setWidgetLayoutVisibility", "stat", "resId", "setInputTextButtonStat", "getTopButtonStat", "()I", "setInputTextButtonVisibility", "getEnteredPassword", "checkChar", "()Z", "checkIllegal", "row", "column", "setCellInfo", "(IILjava/lang/String;Landroid/graphics/drawable/Drawable;Z)V", "setTipAnim", "setTipAnimShake", "onDetachedFromWindow", "Landroid/widget/TextView;", "tipView", "Landroid/widget/TextView;", "tip2View", "displayGroup", "Landroid/view/View;", "dotsRow", "dotsContainer", "Landroid/widget/LinearLayout;", "inputTextButton", "Landroid/widget/ImageView;", "passwordEdit", "Landroid/widget/EditText;", "keypad", "Landroid/widget/GridLayout;", "leftKey", "Lcom/stepos/widget/circlebutton/StepOSCircleButton;", "rightKey", "Landroid/view/ViewGroup;", "bottomFrame", "Landroid/view/ViewGroup;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dots", "Ljava/util/ArrayList;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "entered", "Ljava/lang/StringBuilder;", "finishedNotified", "Z", "hasChar", "illegal", "textWatcherAttached", "inputTextButtonVisible", "inputTextButtonStat", "I", "Landroid/animation/Animator;", "tipAnimator", "Landroid/animation/Animator;", "bottomLeftButton", "bottomRightButton", "maxCellLength", "", UxipConstants.f30680s, "Ljava/lang/CharSequence;", "getTip", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "tip2", "getTip2", "isTactileFeedbackEnabled", "setTactileFeedbackEnabled", "isInStealthMode", "setInStealthMode", "isHollowVisible", "setHollowVisible", "keyPadTypeField", "getKeyPadTypeField$annotations", "bottomLayoutResId", "onPanelListener", "Lcom/stepos/widget/password/StepOSPasswordPad$OnPanelListener;", "getOnPanelListener", "()Lcom/stepos/widget/password/StepOSPasswordPad$OnPanelListener;", "setOnPanelListener", "Landroid/text/TextWatcher;", "complicateWatcher", "Landroid/text/TextWatcher;", "getPinLength", "setPinLength", "pinLength", "getKeyPadType", "setKeyPadType", "keyPadType", "getBottomLayout", "setBottomLayout", "bottomLayout", "getLeftKeyIcon", "()Landroid/graphics/drawable/Drawable;", "setLeftKeyIcon", "(Landroid/graphics/drawable/Drawable;)V", "leftKeyIcon", "getRightKeyIcon", "setRightKeyIcon", "rightKeyIcon", "getPassword", "()Ljava/lang/String;", "password", "Companion", "KeyPadType", "OnPanelListener", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSPasswordPad extends LinearLayout {
    public static final int COMPLICATE = 1;
    private static final int DEFAULT_PIN_LENGTH = 6;
    public static final int INPUT_TEXT_BUTTON_DELETE = 0;
    public static final int INPUT_TEXT_BUTTON_OK = 1;
    public static final int MAX_CELL = 17;
    public static final int SIMPLE = 0;
    private static final long TIP_ANIM_DURATION_MS = 180;
    private static final long TIP_SHAKE_DURATION_MS = 417;
    private final ViewGroup bottomFrame;
    private int bottomLayoutResId;
    private View bottomLeftButton;
    private View bottomRightButton;
    private final TextWatcher complicateWatcher;
    private final View displayGroup;
    private final ArrayList<View> dots;
    private final LinearLayout dotsContainer;
    private final View dotsRow;
    private final StringBuilder entered;
    private boolean finishedNotified;
    private boolean hasChar;
    private boolean illegal;
    private final ImageView inputTextButton;
    private int inputTextButtonStat;
    private boolean inputTextButtonVisible;
    private boolean isHollowVisible;
    private boolean isInStealthMode;
    private boolean isTactileFeedbackEnabled;
    private int keyPadTypeField;
    private final GridLayout keypad;
    private final StepOSCircleButton leftKey;
    private int maxCellLength;
    private OnPanelListener onPanelListener;
    private final EditText passwordEdit;
    private final StepOSCircleButton rightKey;
    private boolean textWatcherAttached;
    private CharSequence tip;
    private CharSequence tip2;
    private final TextView tip2View;
    private Animator tipAnimator;
    private final TextView tipView;

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/password/StepOSPasswordPad$KeyPadType;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface KeyPadType {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/stepos/widget/password/StepOSPasswordPad$OnPanelListener;", "", "<init>", "()V", "", "password", "LY8/t;", "onCellAdded", "(Ljava/lang/String;)V", "onCellCleared", "onCellFhish", "onLeftButtonClick", "onRightButtonClick", "onInputTextButtonClick", "onKeyLeftButtonClick", "onKeyRightButtonClick", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class OnPanelListener {
        public void onCellAdded(String password) {
            p.i(password, "password");
        }

        public void onCellCleared(String password) {
            p.i(password, "password");
        }

        public void onCellFhish(String password) {
            p.i(password, "password");
        }

        public void onInputTextButtonClick(String password) {
            p.i(password, "password");
        }

        public void onKeyLeftButtonClick(String password) {
            p.i(password, "password");
        }

        public void onKeyRightButtonClick(String password) {
            p.i(password, "password");
        }

        public void onLeftButtonClick(String password) {
            p.i(password, "password");
        }

        public void onRightButtonClick(String password) {
            p.i(password, "password");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPasswordPad(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    private final void addCell(String digit) {
        this.entered.append(digit);
        refreshDots();
        updateInputTextButtonStatus();
        performHaptic();
        notifyCellAdded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPassword(String pressed) {
        this.entered.setLength(0);
        this.entered.append(pressed);
        refreshDots();
        updateInputTextButtonStatus();
        notifyCellAdded();
    }

    private final void applyCornerKey(StepOSCircleButton key, String label, Drawable icon, boolean enabled) {
        if (!enabled) {
            key.setImageDrawable(null);
            key.setText("");
            key.setVisibility(4);
            return;
        }
        if (icon != null) {
            key.setImageDrawable(icon);
        } else {
            key.setImageDrawable(null);
            if (label == null) {
                label = "";
            }
            key.setText(label);
        }
        key.setVisibility(0);
    }

    private final void applyKeyPadType(int type, boolean resetMaxLen) throws Resources.NotFoundException {
        this.keyPadTypeField = type;
        if (type == 1) {
            if (resetMaxLen) {
                setMaxLen(17);
            }
            this.tip2View.setVisibility(0);
            this.keypad.setVisibility(8);
            this.dotsRow.setVisibility(8);
            this.passwordEdit.setVisibility(0);
            attachTextWatcher();
            showSoftInput();
        } else {
            if (resetMaxLen) {
                setMaxLen(6);
            }
            this.tip2View.setVisibility(8);
            this.keypad.setVisibility(0);
            this.dotsRow.setVisibility(0);
            this.passwordEdit.setVisibility(8);
        }
        refreshDots();
        updateInputTextButtonStatus();
    }

    private final void attachTextWatcher() {
        if (this.textWatcherAttached) {
            return;
        }
        this.passwordEdit.addTextChangedListener(this.complicateWatcher);
        this.textWatcherAttached = true;
    }

    private final void cancelTipAnimator() {
        Animator animator = this.tipAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.tipAnimator = null;
        this.tipView.setAlpha(1.0f);
        this.tipView.setTranslationX(0.0f);
        this.inputTextButton.setAlpha(1.0f);
    }

    public static /* synthetic */ void clear$default(StepOSPasswordPad stepOSPasswordPad, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clear");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        stepOSPasswordPad.clear(z10);
    }

    private static /* synthetic */ void getKeyPadTypeField$annotations() {
    }

    private final void inflateBottomLayout() {
        this.bottomFrame.removeAllViews();
        this.bottomLeftButton = null;
        this.bottomRightButton = null;
        if (this.bottomLayoutResId == 0) {
            this.bottomFrame.setVisibility(8);
            return;
        }
        LayoutInflater.from(getContext()).inflate(this.bottomLayoutResId, this.bottomFrame, true);
        this.bottomLeftButton = this.bottomFrame.findViewById(R.id.stepos_password_pad_left_button);
        this.bottomRightButton = this.bottomFrame.findViewById(R.id.stepos_password_pad_right_button);
        View view = this.bottomLeftButton;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.password.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StepOSPasswordPad.inflateBottomLayout$lambda$9(this.f31305a, view2);
                }
            });
        }
        View view2 = this.bottomRightButton;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.password.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    StepOSPasswordPad.inflateBottomLayout$lambda$10(this.f31306a, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inflateBottomLayout$lambda$10(StepOSPasswordPad stepOSPasswordPad, View view) {
        OnPanelListener onPanelListener = stepOSPasswordPad.onPanelListener;
        if (onPanelListener != null) {
            String string = stepOSPasswordPad.entered.toString();
            p.h(string, "toString(...)");
            onPanelListener.onRightButtonClick(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inflateBottomLayout$lambda$9(StepOSPasswordPad stepOSPasswordPad, View view) {
        OnPanelListener onPanelListener = stepOSPasswordPad.onPanelListener;
        if (onPanelListener != null) {
            String string = stepOSPasswordPad.entered.toString();
            p.h(string, "toString(...)");
            onPanelListener.onLeftButtonClick(string);
        }
    }

    private final void notifyCellAdded() {
        OnPanelListener onPanelListener = this.onPanelListener;
        if (onPanelListener != null) {
            String string = this.entered.toString();
            p.h(string, "toString(...)");
            onPanelListener.onCellAdded(string);
        }
        if (this.entered.length() < this.maxCellLength || this.finishedNotified) {
            return;
        }
        this.finishedNotified = true;
        OnPanelListener onPanelListener2 = this.onPanelListener;
        if (onPanelListener2 != null) {
            String string2 = this.entered.toString();
            p.h(string2, "toString(...)");
            onPanelListener2.onCellFhish(string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCornerKeyClicked(boolean isLeft) {
        if ((isLeft ? this.leftKey : this.rightKey).getVisibility() != 0) {
            return;
        }
        performHaptic();
        String string = this.entered.toString();
        p.h(string, "toString(...)");
        if (isLeft) {
            OnPanelListener onPanelListener = this.onPanelListener;
            if (onPanelListener != null) {
                onPanelListener.onKeyLeftButtonClick(string);
                return;
            }
            return;
        }
        OnPanelListener onPanelListener2 = this.onPanelListener;
        if (onPanelListener2 != null) {
            onPanelListener2.onKeyRightButtonClick(string);
        }
    }

    private final void onDigitClicked(String digit) {
        if (digit.length() == 0) {
            return;
        }
        addCell(digit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInputTextButtonClicked() {
        if (this.keyPadTypeField == 1) {
            showSoftInput();
            return;
        }
        if (this.inputTextButtonStat == 0) {
            clearCell(true);
            return;
        }
        OnPanelListener onPanelListener = this.onPanelListener;
        if (onPanelListener != null) {
            String string = this.entered.toString();
            p.h(string, "toString(...)");
            onPanelListener.onInputTextButtonClick(string);
        }
    }

    private final void performHaptic() {
        if (this.isTactileFeedbackEnabled) {
            performHapticFeedback(3);
        }
    }

    private final void rebuildDots() throws Resources.NotFoundException {
        this.dotsContainer.removeAllViews();
        this.dots.clear();
        int iF = C5685n.f(this.maxCellLength, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_password_dot_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_password_dot_spacing);
        for (int i10 = 0; i10 < iF; i10++) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            if (i10 > 0) {
                layoutParams.setMarginStart(dimensionPixelSize2);
            }
            view.setLayoutParams(layoutParams);
            N.r0(view, 2);
            Drawable drawableE = androidx.core.content.a.e(getContext(), R.drawable.stepos_bg_password_dot);
            view.setBackground(drawableE != null ? drawableE.mutate() : null);
            this.dotsContainer.addView(view);
            this.dots.add(view);
        }
        refreshDots();
    }

    private final void refreshDots() {
        ColorStateList colorStateListD = androidx.core.content.a.d(getContext(), R.color.stepos_password_dot);
        ColorStateList colorStateListD2 = androidx.core.content.a.d(getContext(), R.color.stepos_password_dot_empty);
        int length = this.entered.length();
        int size = this.dots.size();
        int i10 = 0;
        while (i10 < size) {
            boolean z10 = i10 < length;
            this.dots.get(i10).setBackgroundTintList(z10 ? colorStateListD : colorStateListD2);
            this.dots.get(i10).setVisibility((z10 || this.isHollowVisible) ? 0 : 4);
            i10++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTipAnim$lambda$3(StepOSPasswordPad stepOSPasswordPad, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        stepOSPasswordPad.inputTextButton.setAlpha(fFloatValue);
        if (fFloatValue < 0.001f) {
            stepOSPasswordPad.inputTextButton.setAlpha(1.0f);
            stepOSPasswordPad.setInputTextButtonVisibility(false);
        }
    }

    private final void showSoftInput() {
        this.passwordEdit.setVisibility(0);
        this.passwordEdit.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.passwordEdit, 0);
        }
    }

    private final void updateInputTextButtonStatus() {
        if (this.inputTextButtonVisible && this.inputTextButtonStat == 0) {
            this.inputTextButton.setVisibility(this.entered.length() == 0 ? 8 : 0);
        }
    }

    private final void wireInputTextButton() {
        this.inputTextButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.password.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31308a.onInputTextButtonClicked();
            }
        });
        this.inputTextButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.widget.password.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return StepOSPasswordPad.wireInputTextButton$lambda$8(this.f31309a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean wireInputTextButton$lambda$8(StepOSPasswordPad stepOSPasswordPad, View view) {
        stepOSPasswordPad.onInputTextButtonClicked();
        return true;
    }

    private final void wireKeys() {
        this.leftKey.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.password.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31301a.onCornerKeyClicked(true);
            }
        });
        this.rightKey.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.password.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31302a.onCornerKeyClicked(false);
            }
        });
        int childCount = this.keypad.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            final View childAt = this.keypad.getChildAt(i10);
            if (childAt instanceof StepOSCircleButton) {
                StepOSCircleButton stepOSCircleButton = (StepOSCircleButton) childAt;
                if (stepOSCircleButton.getId() != R.id.stepos_password_pad_key_left && stepOSCircleButton.getId() != R.id.stepos_password_pad_key_right) {
                    stepOSCircleButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.password.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            StepOSPasswordPad.wireKeys$lambda$6(this.f31303a, childAt, view);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireKeys$lambda$6(StepOSPasswordPad stepOSPasswordPad, View view, View view2) {
        CharSequence text = ((StepOSCircleButton) view).getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        stepOSPasswordPad.onDigitClicked(string);
    }

    /* renamed from: checkChar, reason: from getter */
    public final boolean getHasChar() {
        return this.hasChar;
    }

    /* renamed from: checkIllegal, reason: from getter */
    public final boolean getIllegal() {
        return this.illegal;
    }

    public final void clear(boolean clearAll) {
        clearCell(clearAll);
    }

    public final void clearCell(boolean clearAll) {
        if (this.entered.length() == 0) {
            return;
        }
        if (clearAll) {
            this.entered.setLength(0);
            if (this.keyPadTypeField == 1) {
                this.passwordEdit.setText("");
            }
        } else {
            StringBuilder sb2 = this.entered;
            sb2.deleteCharAt(sb2.length() - 1);
        }
        refreshDots();
        updateInputTextButtonStatus();
        this.finishedNotified = false;
        performHaptic();
        OnPanelListener onPanelListener = this.onPanelListener;
        if (onPanelListener != null) {
            String string = this.entered.toString();
            p.h(string, "toString(...)");
            onPanelListener.onCellCleared(string);
        }
    }

    /* renamed from: getBottomLayout, reason: from getter */
    public final int getBottomLayoutResId() {
        return this.bottomLayoutResId;
    }

    /* renamed from: getEditText, reason: from getter */
    public final EditText getPasswordEdit() {
        return this.passwordEdit;
    }

    public final void getEnteredPassword() {
        OnPanelListener onPanelListener = this.onPanelListener;
        if (onPanelListener != null) {
            String string = this.entered.toString();
            p.h(string, "toString(...)");
            onPanelListener.onKeyRightButtonClick(string);
        }
        if (this.keyPadTypeField == 1) {
            showSoftInput();
        }
    }

    public final ImageView getInputTextButton() {
        return this.inputTextButton;
    }

    /* renamed from: getKeyPad, reason: from getter */
    public final GridLayout getKeypad() {
        return this.keypad;
    }

    /* renamed from: getKeyPadType, reason: from getter */
    public final int getKeyPadTypeField() {
        return this.keyPadTypeField;
    }

    /* renamed from: getLeftButton, reason: from getter */
    public final View getBottomLeftButton() {
        return this.bottomLeftButton;
    }

    /* renamed from: getLeftKeyButton, reason: from getter */
    public final StepOSCircleButton getLeftKey() {
        return this.leftKey;
    }

    public final Drawable getLeftKeyIcon() {
        return this.leftKey.getIcon();
    }

    public final OnPanelListener getOnPanelListener() {
        return this.onPanelListener;
    }

    public final String getPassword() {
        String string = this.entered.toString();
        p.h(string, "toString(...)");
        return string;
    }

    /* renamed from: getPinLength, reason: from getter */
    public final int getMaxCellLength() {
        return this.maxCellLength;
    }

    /* renamed from: getRightButton, reason: from getter */
    public final View getBottomRightButton() {
        return this.bottomRightButton;
    }

    /* renamed from: getRightKeyButton, reason: from getter */
    public final StepOSCircleButton getRightKey() {
        return this.rightKey;
    }

    public final Drawable getRightKeyIcon() {
        return this.rightKey.getIcon();
    }

    public final CharSequence getTip() {
        return this.tip;
    }

    public final CharSequence getTip2() {
        return this.tip2;
    }

    /* renamed from: getTopButtonStat, reason: from getter */
    public final int getInputTextButtonStat() {
        return this.inputTextButtonStat;
    }

    /* renamed from: isHollowVisible, reason: from getter */
    public final boolean getIsHollowVisible() {
        return this.isHollowVisible;
    }

    /* renamed from: isInStealthMode, reason: from getter */
    public final boolean getIsInStealthMode() {
        return this.isInStealthMode;
    }

    /* renamed from: isTactileFeedbackEnabled, reason: from getter */
    public final boolean getIsTactileFeedbackEnabled() {
        return this.isTactileFeedbackEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        cancelTipAnimator();
        super.onDetachedFromWindow();
    }

    public final void setBottomLayout(int i10) {
        if (this.bottomLayoutResId == i10) {
            return;
        }
        this.bottomLayoutResId = i10;
        inflateBottomLayout();
    }

    public final void setCellInfo(int row, int column, String label, Drawable icon, boolean enabled) {
        if (row < 0 || row >= 4) {
            throw new IllegalArgumentException(("row must be in 0..3 but was " + row).toString());
        }
        if (column < 0 || column >= 3) {
            throw new IllegalArgumentException(("column must be in 0..2 but was " + column).toString());
        }
        int i10 = (row * 3) + column;
        if (i10 == 9) {
            applyCornerKey(this.leftKey, label, icon, enabled);
        } else {
            if (i10 != 11) {
                return;
            }
            applyCornerKey(this.rightKey, label, icon, enabled);
        }
    }

    public final void setDigitKeyBoardSize(int width, int height) {
        ViewGroup.LayoutParams layoutParams = this.keypad.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.keypad.setLayoutParams(layoutParams);
    }

    public final void setDisplaySpace(int space) {
        View view = this.displayGroup;
        view.setPaddingRelative(view.getPaddingStart(), this.displayGroup.getPaddingTop(), this.displayGroup.getPaddingEnd(), space);
    }

    public final void setHollowVisible(boolean z10) {
        if (this.isHollowVisible == z10) {
            return;
        }
        this.isHollowVisible = z10;
        refreshDots();
    }

    public final void setInStealthMode(boolean z10) {
        this.isInStealthMode = z10;
    }

    public final void setInputTextButtonStat(int stat, int resId) {
        if (stat == 0) {
            this.inputTextButtonStat = 0;
            this.inputTextButton.setContentDescription(getResources().getString(R.string.stepos_password_key_delete_content_description));
        } else if (stat == 1) {
            this.inputTextButtonStat = 1;
            this.inputTextButton.setContentDescription(getResources().getString(R.string.stepos_password_key_ok_content_description));
        } else if (resId != 0) {
            this.inputTextButton.setBackgroundResource(resId);
        }
        updateInputTextButtonStatus();
    }

    public final void setInputTextButtonVisibility(boolean visibility) {
        this.inputTextButtonVisible = visibility;
        this.inputTextButton.setVisibility(visibility ? 0 : 4);
        if (visibility) {
            updateInputTextButtonStatus();
        }
    }

    public final void setKeyPadType(int i10) throws Resources.NotFoundException {
        applyKeyPadType(i10 == 1 ? 1 : 0, true);
    }

    public final void setLeftKeyIcon(Drawable drawable) {
        setCellInfo(3, 0, null, drawable, drawable != null);
    }

    public final void setMaxLen(int len) throws Resources.NotFoundException {
        int iMin = Math.min(len, 17);
        if (this.maxCellLength == iMin) {
            rebuildDots();
        } else {
            this.maxCellLength = iMin;
            rebuildDots();
        }
    }

    public final void setOnPanelListener(OnPanelListener onPanelListener) {
        this.onPanelListener = onPanelListener;
    }

    public final void setPanelListener(OnPanelListener listener) {
        this.onPanelListener = listener;
    }

    public final void setPinLength(int i10) throws Resources.NotFoundException {
        setMaxLen(i10);
    }

    public final void setRightKeyIcon(Drawable drawable) {
        setCellInfo(3, 2, null, drawable, drawable != null);
    }

    public final void setTactileFeedbackEnabled(boolean z10) {
        this.isTactileFeedbackEnabled = z10;
    }

    public final void setTip(CharSequence charSequence) {
        this.tip = charSequence;
        this.tipView.setText(charSequence);
    }

    public final void setTip2(CharSequence charSequence) {
        this.tip2 = charSequence;
        this.tip2View.setText(charSequence);
    }

    public final void setTip2_Visibility(boolean visibility) {
        this.tip2View.setVisibility(visibility ? 0 : 4);
    }

    public final void setTipAnim(final String tip) {
        p.i(tip, "tip");
        cancelTipAnimator();
        this.inputTextButton.setVisibility(0);
        Property property = LinearLayout.ALPHA;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tipView, (Property<TextView, Float>) property, 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.tipView, (Property<TextView, Float>) property, 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.tipView, (Property<TextView, Float>) LinearLayout.TRANSLATION_X, 180.0f, 0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.password.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StepOSPasswordPad.setTipAnim$lambda$3(this.f31307a, valueAnimator);
            }
        });
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.widget.password.StepOSPasswordPad.setTipAnim.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                p.i(animation, "animation");
                StepOSPasswordPad.this.tipView.setText(tip);
                StepOSPasswordPad.this.setTip((CharSequence) tip);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                p.i(animation, "animation");
                StepOSPasswordPad.this.tipView.setText(tip);
                StepOSPasswordPad.this.setTip((CharSequence) tip);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(180L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(objectAnimatorOfFloat).before(objectAnimatorOfFloat2);
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat);
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        this.tipAnimator = animatorSet;
        animatorSet.start();
    }

    public final void setTipAnimShake(String tip) {
        p.i(tip, "tip");
        cancelTipAnimator();
        setTip((CharSequence) tip);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tipView, (Property<TextView, Float>) LinearLayout.TRANSLATION_X, 0.6f, 2.9f, 8.4f, 14.9f, 20.4f, 22.7f, 20.0f, 13.4f, 4.8f, -3.8f, -10.5f, -13.1f, -11.5f, -7.5f, -2.5f, 2.8f, 6.8f, 8.4f, 7.9f, 6.8f, 5.3f, 3.7f, 2.2f, 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(TIP_SHAKE_DURATION_MS);
        this.tipAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.start();
    }

    public final void setWidgetLayoutVisibility(boolean visibility) {
        ViewGroup viewGroup = this.bottomFrame;
        int i10 = 8;
        if (visibility && this.bottomLayoutResId != 0) {
            i10 = 0;
        }
        viewGroup.setVisibility(i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPasswordPad(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPasswordPad(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public final void setTip(String tip) {
        p.i(tip, "tip");
        setTip((CharSequence) tip);
    }

    public final void setTip2(String tip) {
        p.i(tip, "tip");
        setTip2((CharSequence) tip);
    }

    public /* synthetic */ StepOSPasswordPad(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposPasswordPadStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_PasswordPad : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSPasswordPad(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.dots = new ArrayList<>();
        this.entered = new StringBuilder();
        this.inputTextButtonVisible = true;
        this.maxCellLength = 6;
        this.isTactileFeedbackEnabled = true;
        this.isHollowVisible = true;
        int i12 = R.layout.stepos_view_password_pad_buttons;
        this.bottomLayoutResId = i12;
        setOrientation(1);
        setGravity(1);
        LayoutInflater.from(getContext()).inflate(R.layout.stepos_view_password_pad, (ViewGroup) this, true);
        this.tipView = (TextView) findViewById(R.id.stepos_password_pad_tip);
        this.tip2View = (TextView) findViewById(R.id.stepos_password_pad_tip2);
        this.displayGroup = findViewById(R.id.stepos_password_pad_display);
        this.dotsRow = findViewById(R.id.stepos_password_pad_dots_row);
        this.dotsContainer = (LinearLayout) findViewById(R.id.stepos_password_pad_dots);
        this.inputTextButton = (ImageView) findViewById(R.id.stepos_password_pad_input_button);
        this.passwordEdit = (EditText) findViewById(R.id.stepos_password_pad_edit);
        this.keypad = (GridLayout) findViewById(R.id.stepos_password_pad_keypad);
        this.leftKey = (StepOSCircleButton) findViewById(R.id.stepos_password_pad_key_left);
        this.rightKey = (StepOSCircleButton) findViewById(R.id.stepos_password_pad_key_right);
        this.bottomFrame = (ViewGroup) findViewById(R.id.stepos_password_pad_bottom);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSPasswordPad, i10, i11);
        try {
            setPinLength(Math.min(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSPasswordPad_steposPasswordLength, 6), 17));
            setTip(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSPasswordPad_steposPasswordTip));
            setTip2(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSPasswordPad_steposPasswordTip2));
            this.isTactileFeedbackEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSPasswordPad_steposPasswordHapticFeedback, true);
            this.isInStealthMode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSPasswordPad_steposPasswordStealthMode, false);
            setHollowVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSPasswordPad_steposPasswordHollowVisible, true));
            this.inputTextButtonStat = typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSPasswordPad_steposPasswordTopButtonStat, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSPasswordPad_steposPasswordKeyPadType, 0);
            this.bottomLayoutResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSPasswordPad_steposPasswordBottomLayout, i12);
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            rebuildDots();
            wireKeys();
            wireInputTextButton();
            inflateBottomLayout();
            setWidgetLayoutVisibility(false);
            applyKeyPadType(i13, false);
            updateInputTextButtonStatus();
            this.complicateWatcher = new TextWatcher() { // from class: com.stepos.widget.password.StepOSPasswordPad$complicateWatcher$1
                private CharSequence temp = "";

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s10) {
                    p.i(s10, "s");
                    int length = this.temp.length();
                    this.this$0.illegal = false;
                    for (int i14 = 0; i14 < length; i14++) {
                        char cCharAt = s10.charAt(i14);
                        if (cCharAt < ' ' || cCharAt > 127) {
                            this.this$0.illegal = true;
                            break;
                        }
                    }
                    this.this$0.hasChar = false;
                    String string = this.temp.toString();
                    int length2 = string.length();
                    for (int i15 = 0; i15 < length2; i15++) {
                        char cCharAt2 = string.charAt(i15);
                        if (('A' <= cCharAt2 && cCharAt2 < '[') || ('a' <= cCharAt2 && cCharAt2 < '{')) {
                            this.this$0.hasChar = true;
                            break;
                        }
                    }
                    if (this.temp.length() <= 17) {
                        this.this$0.addPassword(s10.toString());
                        return;
                    }
                    int selectionEnd = this.this$0.passwordEdit.getSelectionEnd();
                    if (selectionEnd > 0) {
                        s10.delete(selectionEnd - 1, selectionEnd);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
                    p.i(s10, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s10, int start, int before, int count) {
                    p.i(s10, "s");
                    this.temp = s10;
                }
            };
        } finally {
        }
    }
}
