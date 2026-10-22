package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.capabilitykit.common.UiType;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.divider.ODivider;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b(\u0018\u0000 22\u00020\u0001:\b½\u0001¾\u0001¿\u0001À\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0015\u0010\rJ\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b#\u0010$J\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u0011¢\u0006\u0004\b,\u0010\u0014J\u0017\u0010.\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b.\u0010$J\r\u0010/\u001a\u00020\u000b¢\u0006\u0004\b/\u0010\rJ\u0017\u00100\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b0\u0010$J\r\u00101\u001a\u00020\u000b¢\u0006\u0004\b1\u0010\rJ\r\u00102\u001a\u00020\u000b¢\u0006\u0004\b2\u0010\rJ\r\u00103\u001a\u00020\u000b¢\u0006\u0004\b3\u0010\rJ\r\u00104\u001a\u00020\u000b¢\u0006\u0004\b4\u0010\rJ\r\u00105\u001a\u00020\u000b¢\u0006\u0004\b5\u0010\rJ\r\u00106\u001a\u00020\u000b¢\u0006\u0004\b6\u0010\rJ\r\u00107\u001a\u00020\u000b¢\u0006\u0004\b7\u0010\rJ\r\u00108\u001a\u00020\u000b¢\u0006\u0004\b8\u0010\rJ\r\u00109\u001a\u00020\u000b¢\u0006\u0004\b9\u0010\rJ\r\u0010:\u001a\u00020\u000b¢\u0006\u0004\b:\u0010\rJ\r\u0010;\u001a\u00020\u000b¢\u0006\u0004\b;\u0010\rJ\r\u0010<\u001a\u00020\u000b¢\u0006\u0004\b<\u0010\rJ\r\u0010=\u001a\u00020\u000b¢\u0006\u0004\b=\u0010\rJ\r\u0010>\u001a\u00020\u000b¢\u0006\u0004\b>\u0010\rJ\r\u0010?\u001a\u00020\u000b¢\u0006\u0004\b?\u0010\rJ\r\u0010@\u001a\u00020\u000b¢\u0006\u0004\b@\u0010\rJ\r\u0010A\u001a\u00020\u000b¢\u0006\u0004\bA\u0010\rJ\r\u0010B\u001a\u00020\u000b¢\u0006\u0004\bB\u0010\rJ\r\u0010C\u001a\u00020\u000b¢\u0006\u0004\bC\u0010\rJ\u0015\u0010F\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u0015\u0010M\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ\u0015\u0010Q\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001a\u00020\u000b2\b\u0010T\u001a\u0004\u0018\u00010S¢\u0006\u0004\bU\u0010VR\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u00108\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0017\u0010a\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010g\u001a\u00020b8\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0017\u0010j\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\bh\u0010^\u001a\u0004\bi\u0010`R\u0017\u0010m\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\bk\u0010^\u001a\u0004\bl\u0010`R\u0017\u0010p\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\bn\u0010^\u001a\u0004\bo\u0010`R\u0017\u0010v\u001a\u00020q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u0017\u0010{\u001a\u00020w8\u0006¢\u0006\f\n\u0004\b\u0010\u0010x\u001a\u0004\by\u0010zR\u0017\u0010}\u001a\u00020q8\u0006¢\u0006\f\n\u0004\b;\u0010s\u001a\u0004\b|\u0010uR\u0017\u0010\u007f\u001a\u00020w8\u0006¢\u0006\f\n\u0004\bC\u0010x\u001a\u0004\b~\u0010zR\u001c\u0010\u0084\u0001\u001a\u00030\u0080\u00018\u0006¢\u0006\u000f\n\u0005\b9\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0089\u0001\u001a\u00030\u0085\u00018\u0006¢\u0006\u000f\n\u0005\bA\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008b\u0001\u001a\u00030\u0085\u00018\u0006¢\u0006\u000f\n\u0005\b/\u0010\u0086\u0001\u001a\u0006\b\u008a\u0001\u0010\u0088\u0001R\u0019\u0010\u008d\u0001\u001a\u00020q8\u0006¢\u0006\r\n\u0004\b1\u0010s\u001a\u0005\b\u008c\u0001\u0010uR\u0019\u0010\u008f\u0001\u001a\u00020\\8\u0006¢\u0006\r\n\u0004\b=\u0010^\u001a\u0005\b\u008e\u0001\u0010`R\u001c\u0010\u0094\u0001\u001a\u00030\u0090\u00018\u0006¢\u0006\u000f\n\u0005\b\u000f\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0096\u0001\u001a\u00030\u0090\u00018\u0006¢\u0006\u000f\n\u0005\b?\u0010\u0091\u0001\u001a\u0006\b\u0095\u0001\u0010\u0093\u0001R\u001c\u0010\u0098\u0001\u001a\u00030\u0090\u00018\u0006¢\u0006\u000f\n\u0005\b7\u0010\u0091\u0001\u001a\u0006\b\u0097\u0001\u0010\u0093\u0001R+\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b3\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R+\u0010¢\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\f\u0010\u009a\u0001\u001a\u0006\b \u0001\u0010\u009c\u0001\"\u0006\b¡\u0001\u0010\u009e\u0001R\u001a\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u0019\u0010§\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0017\u0010®\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00108R\u0017\u0010¯\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00108R\u0019\u0010±\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010¬\u0001R\u0018\u0010²\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b4\u0010¬\u0001R\u0018\u0010³\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b:\u0010¬\u0001R\u0018\u0010´\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bB\u0010¬\u0001R\u0018\u0010µ\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b8\u0010¬\u0001R\u0018\u0010¶\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b@\u0010¬\u0001R\u0018\u0010·\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b.\u0010¬\u0001R\u0018\u0010¸\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b0\u0010¬\u0001R\u0018\u0010¹\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b<\u0010¬\u0001R\u0015\u0010º\u0001\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000e\u00108R\u0018\u0010»\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010¤\u0001R\u0018\u0010¼\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b6\u0010¤\u0001¨\u0006Á\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView;", "Lcom/obric/oui/forms/AbsOForm;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "arrangeDirection", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", FixCard.FixStyle.KEY_X, "()V", "N", "t", "l", "", "enabled", "setEnabled", "(Z)V", "onAttachedToWindow", "Landroid/graphics/drawable/Drawable;", "drawable", "setInputContainerBackground", "(Landroid/graphics/drawable/Drawable;)V", "mode", "Landroid/view/View$OnClickListener;", "clickListener", "D", "(ILandroid/view/View$OnClickListener;)V", "", "getText", "()Ljava/lang/String;", "text", "setText", "(Ljava/lang/String;)V", "Lcom/obric/oui/forms/OLineInputView$b;", "getConfig", "()Lcom/obric/oui/forms/OLineInputView$b;", "newConfig", "R", "(Lcom/obric/oui/forms/OLineInputView$b;)V", "flag", "setAutoHideClearWhenTextEmpty", "tips", "K", "q", "L", "r", "Q", "w", "F", "C", "P", "v", "I", "o", "G", "m", "M", "s", "O", "u", "J", "p", "H", "n", "Landroid/view/View$OnFocusChangeListener;", "listener", "setEditTextOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "textExceedLengthListener", "setTextExceedLengthListener", "(Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;)V", "Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "textClearedListener", "setTextClearedListener", "(Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "e", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Lcom/obric/oui/forms/OFormEditText;", "g", "Lcom/obric/oui/forms/OFormEditText;", "getEditText", "()Lcom/obric/oui/forms/OFormEditText;", "editText", "h", "getTvErrorTips", "tvErrorTips", "i", "getTvCounter", "tvCounter", "j", "getTvAction", "tvAction", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "getIvClear", "()Landroid/widget/ImageView;", "ivClear", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "getIvClearContainer", "()Landroid/widget/LinearLayout;", "ivClearContainer", "getIvAction", "ivAction", "getIvActionContainer", "ivActionContainer", "Lcom/obric/oui/divider/ODivider;", "Lcom/obric/oui/divider/ODivider;", "getDivider", "()Lcom/obric/oui/divider/ODivider;", "divider", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "getPrefixContainer", "()Landroid/widget/RelativeLayout;", "prefixContainer", "getSuffixContainer", "suffixContainer", "getIvTitleIcon", "ivTitleIcon", "getTvInputTips", "tvInputTips", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "getTitleContainer", "()Landroid/view/ViewGroup;", "titleContainer", "getInputContainer", "inputContainer", "getActionContainer", "actionContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getActiveBorderView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setActiveBorderView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "activeBorderView", "getLeftContainer", "setLeftContainer", "leftContainer", FixCard.FixStyle.KEY_Y, "Ljava/lang/String;", "z", "Lcom/obric/oui/forms/OLineInputView$b;", "config", "A", "Landroid/text/TextWatcher;", "counterTextWatcher", "B", "Z", "showTitleDefaultIcon", "titleDefaultIconSize", "textGravity", "E", "isShowTitle", "isShowErrorTips", "isShowInputTips", "isShowPrefix", "isShowSuffix", "isShowActionText", "isShowActionImage", "isShowTitleIcon", "isErrorState", "DEFAULT_MAX_LINES", "errorTips", "inputTips", "a", "b", "TextClearedListener", "TextExceedLengthListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OLineInputView extends AbsOForm {
    public static final a Q = null;
    public TextWatcher A;
    public boolean B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f14721J;
    public boolean K;
    public boolean L;
    public boolean M;
    public final int N;
    public String O;
    public String P;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f14723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OFormEditText f14724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f14725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f14726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f14727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f14728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinearLayout f14729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f14730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f14731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ODivider f14732o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RelativeLayout f14733p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RelativeLayout f14734q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ImageView f14735r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f14736s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f14737t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewGroup f14738u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f14739v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ConstraintLayout f14740w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ConstraintLayout f14741x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f14742y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f14743z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "", "afterClear", "", "beforeClear", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TextClearedListener {
        void afterClear();

        void beforeClear();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "", "textExceedLength", "", "s", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TextExceedLengthListener {
        void textExceedLength(@NotNull String r10);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f14747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f14748e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f14749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f14750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f14751h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f14752i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public TextWatcher f14753j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View.OnFocusChangeListener f14754k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f14755l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f14756m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public View.OnClickListener f14757n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public View.OnClickListener f14758o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f14759p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Integer f14760q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Integer f14761r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Drawable f14762s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f14763t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f14764u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f14765v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f14766w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f14767x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public TextExceedLengthListener f14768y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public TextClearedListener f14769z;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f14770a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f14771b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Drawable f14772c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f14773d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Integer f14774e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f14775f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f14776g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public View f14777h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public View f14778i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f14779j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public String f14780k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public Integer f14781l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public boolean f14782m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public View.OnClickListener f14783n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public Drawable f14784o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public View.OnClickListener f14785p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public TextWatcher f14786q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public View.OnFocusChangeListener f14787r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public Integer f14788s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public boolean f14789t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public boolean f14790u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public boolean f14791v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public int f14792w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public boolean f14793x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public TextExceedLengthListener f14794y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public TextClearedListener f14795z;

            public a(String r10, String r11, Drawable r12, boolean r13, Integer r14, boolean r15, String r16, View r17, View r18, boolean r19, String r110, Integer r111, boolean r112, View.OnClickListener r113, Drawable r114, View.OnClickListener r115, TextWatcher r20, View.OnFocusChangeListener r21, Integer r22, boolean r23, boolean r24, boolean r25, int r26, boolean r27, TextExceedLengthListener r28, TextClearedListener r29) {
                q.g(r10, "title");
                this.f14770a = r10;
                this.f14771b = r11;
                this.f14772c = r12;
                this.f14773d = r13;
                this.f14774e = r14;
                this.f14775f = r15;
                this.f14776g = r16;
                this.f14777h = r17;
                this.f14778i = r18;
                this.f14779j = r19;
                this.f14780k = r110;
                this.f14781l = r111;
                this.f14782m = r112;
                this.f14783n = r113;
                this.f14784o = r114;
                this.f14785p = r115;
                this.f14786q = r20;
                this.f14787r = r21;
                this.f14788s = r22;
                this.f14789t = r23;
                this.f14790u = r24;
                this.f14791v = r25;
                this.f14792w = r26;
                this.f14793x = r27;
                this.f14794y = r28;
                this.f14795z = r29;
            }

            public final b a() {
                String r10 = this.f14770a;
                String r11 = this.f14771b;
                Drawable r12 = this.f14772c;
                boolean r13 = this.f14773d;
                boolean r14 = this.f14775f;
                String r15 = this.f14776g;
                Integer r16 = this.f14774e;
                boolean r17 = this.f14779j;
                String r18 = this.f14780k;
                TextWatcher r19 = this.f14786q;
                View r20 = this.f14777h;
                View r21 = this.f14778i;
                boolean r110 = this.f14782m;
                View.OnClickListener r111 = this.f14783n;
                Drawable r112 = this.f14784o;
                View.OnClickListener r22 = this.f14785p;
                Integer r23 = this.f14781l;
                return new b(r10, r13, r14, r15, r20, r21, r16, r17, r18, r19, this.f14787r, r110, r112, r111, r22, r11, r23, this.f14788s, r12, this.f14789t, this.f14790u, this.f14791v, this.f14792w, this.f14793x, this.f14794y, this.f14795z, null);
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L8;
                return false;
            L8:
                a r11 = (a) r10;
                if (q.b(this.f14770a, r11.f14770a) == true) goto L12;
                return false;
            L12:
                if (q.b(this.f14771b, r11.f14771b) == true) goto L15;
                return false;
            L15:
                if (q.b(this.f14772c, r11.f14772c) == true) goto L18;
                return false;
            L18:
                if (this.f14773d == r11.f14773d) goto L21;
                return false;
            L21:
                if (q.b(this.f14774e, r11.f14774e) == true) goto L24;
                return false;
            L24:
                if (this.f14775f == r11.f14775f) goto L27;
                return false;
            L27:
                if (q.b(this.f14776g, r11.f14776g) == true) goto L30;
                return false;
            L30:
                if (q.b(this.f14777h, r11.f14777h) == true) goto L33;
                return false;
            L33:
                if (q.b(this.f14778i, r11.f14778i) == true) goto L36;
                return false;
            L36:
                if (this.f14779j == r11.f14779j) goto L39;
                return false;
            L39:
                if (q.b(this.f14780k, r11.f14780k) == true) goto L42;
                return false;
            L42:
                if (q.b(this.f14781l, r11.f14781l) == true) goto L45;
                return false;
            L45:
                if (this.f14782m == r11.f14782m) goto L48;
                return false;
            L48:
                if (q.b(this.f14783n, r11.f14783n) == true) goto L51;
                return false;
            L51:
                if (q.b(this.f14784o, r11.f14784o) == true) goto L54;
                return false;
            L54:
                if (q.b(this.f14785p, r11.f14785p) == true) goto L57;
                return false;
            L57:
                if (q.b(this.f14786q, r11.f14786q) == true) goto L60;
                return false;
            L60:
                if (q.b(this.f14787r, r11.f14787r) == true) goto L63;
                return false;
            L63:
                if (q.b(this.f14788s, r11.f14788s) == true) goto L66;
                return false;
            L66:
                if (this.f14789t == r11.f14789t) goto L69;
                return false;
            L69:
                if (this.f14790u == r11.f14790u) goto L72;
                return false;
            L72:
                if (this.f14791v == r11.f14791v) goto L75;
                return false;
            L75:
                if (this.f14792w == r11.f14792w) goto L78;
                return false;
            L78:
                if (this.f14793x == r11.f14793x) goto L81;
                return false;
            L81:
                if (q.b(this.f14794y, r11.f14794y) == true) goto L84;
                return false;
            L84:
                if (q.b(this.f14795z, r11.f14795z) == true) goto L86;
                return false;
            L86:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v23, types: [int] */
            /* JADX WARN: Type inference failed for: r1v31, types: [int] */
            /* JADX WARN: Type inference failed for: r1v51, types: [int] */
            /* JADX WARN: Type inference failed for: r1v53, types: [int] */
            /* JADX WARN: Type inference failed for: r1v55, types: [int] */
            /* JADX WARN: Type inference failed for: r1v63 */
            /* JADX WARN: Type inference failed for: r1v64 */
            /* JADX WARN: Type inference failed for: r1v65 */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v72 */
            /* JADX WARN: Type inference failed for: r1v75 */
            /* JADX WARN: Type inference failed for: r1v79 */
            /* JADX WARN: Type inference failed for: r1v81 */
            /* JADX WARN: Type inference failed for: r1v84 */
            /* JADX WARN: Type inference failed for: r1v85 */
            /* JADX WARN: Type inference failed for: r1v86 */
            /* JADX WARN: Type inference failed for: r1v87 */
            /* JADX WARN: Type inference failed for: r1v88 */
            /* JADX WARN: Type inference failed for: r1v89 */
            /* JADX WARN: Type inference failed for: r1v90 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                int r10 = this.f14770a.hashCode() * 31;
                String r11 = this.f14771b;
                int r12 = 0;
                if (r11 != null) goto L5;
                int r13 = 0;
            L6:
                int r14 = (r10 + r13) * 31;
                Drawable r15 = this.f14772c;
                if (r15 != null) goto L9;
                int r16 = 0;
            L10:
                int r17 = (r14 + r16) * 31;
                boolean r18 = this.f14773d;
                ?? r19 = 1;
                ?? r20 = r18;
                if (r18 == false) goto L13;
                r20 = 1;
            L13:
                int r21 = (r17 + r20) * 31;
                Integer r22 = this.f14774e;
                if (r22 != null) goto L16;
                int r23 = 0;
            L17:
                int r24 = (r21 + r23) * 31;
                boolean r25 = this.f14775f;
                ?? r26 = r25;
                if (r25 == false) goto L20;
                r26 = 1;
            L20:
                int r27 = (r24 + r26) * 31;
                String r28 = this.f14776g;
                if (r28 != null) goto L23;
                int r29 = 0;
            L24:
                int r30 = (r27 + r29) * 31;
                View r31 = this.f14777h;
                if (r31 != null) goto L27;
                int r32 = 0;
            L28:
                int r33 = (r30 + r32) * 31;
                View r34 = this.f14778i;
                if (r34 != null) goto L31;
                int r35 = 0;
            L32:
                int r36 = (r33 + r35) * 31;
                boolean r37 = this.f14779j;
                ?? r38 = r37;
                if (r37 == false) goto L35;
                r38 = 1;
            L35:
                int r39 = (r36 + r38) * 31;
                String r40 = this.f14780k;
                if (r40 != null) goto L38;
                int r41 = 0;
            L39:
                int r42 = (r39 + r41) * 31;
                Integer r43 = this.f14781l;
                if (r43 != null) goto L42;
                int r44 = 0;
            L43:
                int r45 = (r42 + r44) * 31;
                boolean r46 = this.f14782m;
                ?? r47 = r46;
                if (r46 == false) goto L46;
                r47 = 1;
            L46:
                int r48 = (r45 + r47) * 31;
                View.OnClickListener r49 = this.f14783n;
                if (r49 != null) goto L49;
                int r50 = 0;
            L50:
                int r51 = (r48 + r50) * 31;
                Drawable r52 = this.f14784o;
                if (r52 != null) goto L53;
                int r53 = 0;
            L54:
                int r54 = (r51 + r53) * 31;
                View.OnClickListener r55 = this.f14785p;
                if (r55 != null) goto L57;
                int r56 = 0;
            L58:
                int r57 = (r54 + r56) * 31;
                TextWatcher r58 = this.f14786q;
                if (r58 != null) goto L61;
                int r59 = 0;
            L62:
                int r60 = (r57 + r59) * 31;
                View.OnFocusChangeListener r61 = this.f14787r;
                if (r61 != null) goto L65;
                int r62 = 0;
            L66:
                int r63 = (r60 + r62) * 31;
                Integer r64 = this.f14788s;
                if (r64 != null) goto L69;
                int r65 = 0;
            L70:
                int r66 = (r63 + r65) * 31;
                boolean r67 = this.f14789t;
                ?? r68 = r67;
                if (r67 == false) goto L73;
                r68 = 1;
            L73:
                int r69 = (r66 + r68) * 31;
                boolean r70 = this.f14790u;
                ?? r71 = r70;
                if (r70 == false) goto L76;
                r71 = 1;
            L76:
                int r72 = (r69 + r71) * 31;
                boolean r73 = this.f14791v;
                ?? r74 = r73;
                if (r73 == false) goto L79;
                r74 = 1;
            L79:
                int r75 = (((r72 + r74) * 31) + Integer.hashCode(this.f14792w)) * 31;
                boolean r76 = this.f14793x;
                if (r76 == true) goto L83;
                r19 = r76;
            L83:
                int r77 = (r75 + r19) * 31;
                TextExceedLengthListener r78 = this.f14794y;
                if (r78 != null) goto L86;
                int r79 = 0;
            L87:
                int r80 = (r77 + r79) * 31;
                TextClearedListener r81 = this.f14795z;
                if (r81 == null) goto L92;
                r12 = r81.hashCode();
            L92:
                return r80 + r12;
            L86:
                r79 = r78.hashCode();
                goto L87
            L69:
                r65 = r64.hashCode();
                goto L70
            L65:
                r62 = r61.hashCode();
                goto L66
            L61:
                r59 = r58.hashCode();
                goto L62
            L57:
                r56 = r55.hashCode();
                goto L58
            L53:
                r53 = r52.hashCode();
                goto L54
            L49:
                r50 = r49.hashCode();
                goto L50
            L42:
                r44 = r43.hashCode();
                goto L43
            L38:
                r41 = r40.hashCode();
                goto L39
            L31:
                r35 = r34.hashCode();
                goto L32
            L27:
                r32 = r31.hashCode();
                goto L28
            L23:
                r29 = r28.hashCode();
                goto L24
            L16:
                r23 = r22.hashCode();
                goto L17
            L9:
                r16 = r15.hashCode();
                goto L10
            L5:
                r13 = r11.hashCode();
                goto L6
            }

            public final void setActionImageDrawableListener(@Nullable View.OnClickListener r10) {
                this.f14785p = r10;
            }

            public final void setActionTextListener(@Nullable View.OnClickListener r10) {
                this.f14783n = r10;
            }

            public final void setEditTextOnFocusChangeListener(@Nullable View.OnFocusChangeListener r10) {
                this.f14787r = r10;
            }

            public String toString() {
                return "Builder(title=" + this.f14770a + ", inputTips=" + this.f14771b + ", titleIcon=" + this.f14772c + ", showCounter=" + this.f14773d + ", lengthLimit=" + this.f14774e + ", showClear=" + this.f14775f + ", hintText=" + this.f14776g + ", prefixView=" + this.f14777h + ", suffixView=" + this.f14778i + ", showDivider=" + this.f14779j + ", actionText=" + this.f14780k + ", actionTextColor=" + this.f14781l + ", actionTextClickable=" + this.f14782m + ", actionTextListener=" + this.f14783n + ", actionImageDrawable=" + this.f14784o + ", actionImageDrawableListener=" + this.f14785p + ", textWatcher=" + this.f14786q + ", editTextOnFocusChangeListener=" + this.f14787r + ", inputBoxHeight=" + this.f14788s + ", isInSearchBar=" + this.f14789t + ", autoHideClearWhenTextEmpty=" + this.f14790u + ", multiLine=" + this.f14791v + ", mode=" + this.f14792w + ", hideClearWhenNoFocus=" + this.f14793x + ", textExceedLengthListener=" + this.f14794y + ", textClearedListener=" + this.f14795z + ')';
            }

            public /* synthetic */ a(String r28, String r29, Drawable r30, boolean r31, Integer r32, boolean r33, String r34, View r35, View r36, boolean r37, String r38, Integer r39, boolean r40, View.OnClickListener r41, Drawable r42, View.OnClickListener r43, TextWatcher r44, View.OnFocusChangeListener r45, Integer r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, TextExceedLengthListener r52, TextClearedListener r53, int r54, DefaultConstructorMarker r55) {
                if ((r54 & 1) == 0) goto L5;
                String r10 = "标题";
            L7:
                if ((r54 & 2) == 0) goto L9;
                String r11 = null;
            L11:
                if ((r54 & 4) == 0) goto L13;
                Drawable r12 = null;
            L15:
                if ((r54 & 8) == 0) goto L17;
                boolean r13 = false;
            L19:
                if ((r54 & 16) == 0) goto L21;
                Integer r14 = null;
            L23:
                if ((r54 & 32) == 0) goto L25;
                boolean r15 = false;
            L27:
                if ((r54 & 64) == 0) goto L29;
                String r16 = null;
            L31:
                if ((r54 & 128) == 0) goto L33;
                View r17 = null;
            L35:
                if ((r54 & 256) == 0) goto L37;
                View r18 = null;
            L39:
                if ((r54 & 512) == 0) goto L41;
                boolean r19 = true;
            L43:
                if ((r54 & 1024) == 0) goto L45;
                String r110 = null;
            L47:
                if ((r54 & 2048) == 0) goto L49;
                Integer r111 = null;
            L51:
                if ((r54 & 4096) == 0) goto L53;
                boolean r20 = false;
            L55:
                if ((r54 & 8192) == 0) goto L57;
                View.OnClickListener r21 = null;
            L59:
                if ((r54 & 16384) == 0) goto L61;
                Drawable r112 = null;
            L63:
                if ((r54 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
                View.OnClickListener r113 = null;
            L67:
                if ((r54 & 65536) == 0) goto L69;
                TextWatcher r114 = null;
            L71:
                if ((r54 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
                View.OnFocusChangeListener r115 = null;
            L75:
                if ((r54 & UiType.FLAG_TIMER_CARD) == 0) goto L77;
                Integer r116 = null;
            L79:
                if ((r54 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
                boolean r22 = false;
            L83:
                if ((r54 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L85;
                boolean r23 = false;
            L87:
                if ((r54 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
                boolean r24 = false;
            L91:
                if ((r54 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
                int r25 = 2;
            L95:
                if ((r54 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
                boolean r26 = true;
            L99:
                if ((r54 & 16777216) == 0) goto L101;
                TextExceedLengthListener r27 = null;
            L103:
                if ((r54 & 33554432) == 0) goto L105;
                TextClearedListener r56 = null;
            L106:
                this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r112, r113, r114, r115, r116, r22, r23, r24, r25, r26, r27, r56);
                return;
            L105:
                r56 = r53;
                goto L106
            L101:
                r27 = r52;
                goto L103
            L97:
                r26 = r51;
                goto L99
            L93:
                r25 = r50;
                goto L95
            L89:
                r24 = r49;
                goto L91
            L85:
                r23 = r48;
                goto L87
            L81:
                r22 = r47;
                goto L83
            L77:
                r116 = r46;
                goto L79
            L73:
                r115 = r45;
                goto L75
            L69:
                r114 = r44;
                goto L71
            L65:
                r113 = r43;
                goto L67
            L61:
                r112 = r42;
                goto L63
            L57:
                r21 = r41;
                goto L59
            L53:
                r20 = r40;
                goto L55
            L49:
                r111 = r39;
                goto L51
            L45:
                r110 = r38;
                goto L47
            L41:
                r19 = r37;
                goto L43
            L37:
                r18 = r36;
                goto L39
            L33:
                r17 = r35;
                goto L35
            L29:
                r16 = r34;
                goto L31
            L25:
                r15 = r33;
                goto L27
            L21:
                r14 = r32;
                goto L23
            L17:
                r13 = r31;
                goto L19
            L13:
                r12 = r30;
                goto L15
            L9:
                r11 = r29;
                goto L11
            L5:
                r10 = r28;
                goto L7
            }
        }

        public /* synthetic */ b(String r10, boolean r11, boolean r12, String r13, View r14, View r15, Integer r16, boolean r17, String r18, TextWatcher r19, View.OnFocusChangeListener r110, boolean r111, Drawable r112, View.OnClickListener r113, View.OnClickListener r114, String r115, Integer r116, Integer r117, Drawable r118, boolean r20, boolean r21, boolean r22, int r23, boolean r24, TextExceedLengthListener r25, TextClearedListener r26, DefaultConstructorMarker r27) {
            this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r20, r21, r22, r23, r24, r25, r26);
        }

        public final void A(boolean r10) {
            this.f14764u = r10;
        }

        public final void B(String r10) {
            this.f14747d = r10;
        }

        public final void C(Integer r10) {
            this.f14761r = r10;
        }

        public final void D(String r10) {
            this.f14759p = r10;
        }

        public final void E(Integer r10) {
            this.f14750g = r10;
        }

        public final void F(boolean r10) {
            this.f14765v = r10;
        }

        public final void G(boolean r10) {
            this.f14746c = r10;
        }

        public final void H(boolean r10) {
            this.f14745b = r10;
        }

        public final void I(boolean r10) {
            this.f14751h = r10;
        }

        public final void J(TextClearedListener r10) {
            this.f14769z = r10;
        }

        public final void K(TextExceedLengthListener r10) {
            this.f14768y = r10;
        }

        public final void L(TextWatcher r10) {
            this.f14753j = r10;
        }

        public final void M(String r10) {
            q.g(r10, "<set-?>");
            this.f14744a = r10;
        }

        public final Drawable a() {
            return this.f14756m;
        }

        public final View.OnClickListener b() {
            return this.f14758o;
        }

        public final String c() {
            return this.f14752i;
        }

        public final boolean d() {
            return this.f14755l;
        }

        public final Integer e() {
            return this.f14760q;
        }

        public final View.OnClickListener f() {
            return this.f14757n;
        }

        public final boolean g() {
            return this.f14764u;
        }

        public final View.OnFocusChangeListener h() {
            return this.f14754k;
        }

        public final boolean i() {
            return this.f14767x;
        }

        public final String j() {
            return this.f14747d;
        }

        public final Integer k() {
            return this.f14761r;
        }

        public final String l() {
            return this.f14759p;
        }

        public final Drawable m() {
            return this.f14762s;
        }

        public final Integer n() {
            return this.f14750g;
        }

        public final int o() {
            return this.f14766w;
        }

        public final boolean p() {
            return this.f14765v;
        }

        public final View q() {
            return this.f14748e;
        }

        public final boolean r() {
            return this.f14746c;
        }

        public final boolean s() {
            return this.f14745b;
        }

        public final void setActionImageDrawableListener(@Nullable View.OnClickListener r10) {
            this.f14758o = r10;
        }

        public final void setActionTextListener(@Nullable View.OnClickListener r10) {
            this.f14757n = r10;
        }

        public final void setEditTextOnFocusChangeListener(@Nullable View.OnFocusChangeListener r10) {
            this.f14754k = r10;
        }

        public final boolean t() {
            return this.f14751h;
        }

        public final View u() {
            return this.f14749f;
        }

        public final TextClearedListener v() {
            return this.f14769z;
        }

        public final TextExceedLengthListener w() {
            return this.f14768y;
        }

        public final TextWatcher x() {
            return this.f14753j;
        }

        public final String y() {
            return this.f14744a;
        }

        public final boolean z() {
            return this.f14763t;
        }

        public b(String r10, boolean r11, boolean r12, String r13, View r14, View r15, Integer r16, boolean r17, String r18, TextWatcher r19, View.OnFocusChangeListener r110, boolean r111, Drawable r112, View.OnClickListener r113, View.OnClickListener r114, String r115, Integer r116, Integer r20, Drawable r21, boolean r22, boolean r23, boolean r24, int r25, boolean r26, TextExceedLengthListener r27, TextClearedListener r28) {
            this.f14744a = r10;
            this.f14745b = r11;
            this.f14746c = r12;
            this.f14747d = r13;
            this.f14748e = r14;
            this.f14749f = r15;
            this.f14750g = r16;
            this.f14751h = r17;
            this.f14752i = r18;
            this.f14753j = r19;
            this.f14754k = r110;
            this.f14755l = r111;
            this.f14756m = r112;
            this.f14757n = r113;
            this.f14758o = r114;
            this.f14759p = r115;
            this.f14760q = r116;
            this.f14761r = r20;
            this.f14762s = r21;
            this.f14763t = r22;
            this.f14764u = r23;
            this.f14765v = r24;
            this.f14766w = r25;
            this.f14767x = r26;
            this.f14768y = r27;
            this.f14769z = r28;
        }
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OLineInputView f14796a;

        public c(OLineInputView r10) {
            this.f14796a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (OLineInputView.k(this.f14796a).n() == null) goto L18;
            int r11 = 0;
            if (r10 != null) goto L7;
            int r12 = 0;
        L8:
            Integer r13 = OLineInputView.k(this.f14796a).n();
            if (r13 == null) goto L12;
            r11 = r13.intValue();
        L12:
            if (r12 <= r11) goto L19;
            TextExceedLengthListener r14 = OLineInputView.k(this.f14796a).w();
            if (r14 == null) goto L20;
            r14.textExceedLength(String.valueOf(r10));
            return;
        L20:
            return;
        L19:
            return;
        L7:
            r12 = r10.length();
            goto L8
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            if (OLineInputView.k(this.f14796a).n() == null) goto L28;
            Resources r14 = this.f14796a.getResources();
            int r15 = R$string.oui_form_counter;
            if (r10 != null) goto L7;
            String r16 = null;
        L8:
            String r17 = r14.getString(r15, new Object[]{r16, String.valueOf(OLineInputView.k(this.f14796a).n())});
            q.f(r17, "resources.getString(\n   …                        )");
            SpannableString r18 = new SpannableString(r17);
            if (r10 != null) goto L11;
            int r19 = 0;
        L12:
            Integer r20 = OLineInputView.k(this.f14796a).n();
            if (r20 != null) goto L15;
            int r21 = 0;
        L16:
            if (r19 <= r21) goto L25;
            Context r22 = this.f14796a.getContext();
            int r23 = R$color.Primary;
            ForegroundColorSpan r24 = new ForegroundColorSpan(ContextCompat.b(r22, r23));
            if (r10 != null) goto L20;
        L19:
            int r25 = 0;
        L24:
            r18.setSpan(r24, 0, r25, 18);
            this.f14796a.getDivider().setBackgroundColor(ContextCompat.b(this.f14796a.getContext(), r23));
        L26:
            this.f14796a.getTvCounter().setText(r18, TextView.BufferType.SPANNABLE);
            return;
        L20:
            String r26 = Integer.valueOf(r10.length()).toString();
            if (r26 == null) goto L19;
            r25 = r26.length();
            goto L24
        L25:
            this.f14796a.getDivider().setStyle(0);
            goto L26
        L15:
            r21 = r20.intValue();
            goto L16
        L11:
            r19 = r10.length();
            goto L12
        L7:
            r16 = Integer.valueOf(r10.length()).toString();
            goto L8
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OLineInputView f14797a;

        public d(OLineInputView r10) {
            this.f14797a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (r10 != null) goto L4;
        L7:
            this.f14797a.o();
            return;
        L4:
            if (r10.length() == 0) goto L7;
            this.f14797a.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }
    }

    static {
        Q = new a(null);
    }

    @JvmOverloads
    public OLineInputView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    public static final void A(OLineInputView r10, View r11, boolean r12) {
        q.g(r10, "this$0");
        if (r12 == false) goto L12;
        if (r10.f14743z.g() == true) goto L7;
    L9:
        r10.I();
    L10:
        r10.N();
        return;
    L7:
        if (TextUtils.isEmpty(r10.getText()) == false) goto L9;
        r10.o();
        goto L10
    L12:
        if (r10.f14743z.i() == false) goto L14;
    L15:
        r10.o();
    L16:
        r10.t();
        return;
    L14:
        if (TextUtils.isEmpty(r10.getText()) == false) goto L16;
        goto L15
    }

    public static final boolean B(OLineInputView r10, View r11, MotionEvent r12) {
        q.g(r10, "this$0");
        q.g(r12, "event");
        int r13 = r12.getActionMasked();
        if (r13 == 0) goto L26;
        if (r13 == 1) goto L10;
        if (r13 == 3) goto L10;
        return false;
    L10:
        if (r10.M == false) goto L16;
        ConstraintLayout r14 = r10.f14740w;
        if (r14 == null) goto L49;
        r14.setBackgroundResource(R$drawable.o_line_box_input_error_default_border);
        return false;
    L49:
        return false;
    L16:
        if (r10.f14724g.hasFocus() == false) goto L21;
        ConstraintLayout r15 = r10.f14740w;
        if (r15 == null) goto L50;
        r15.setBackgroundResource(R$drawable.o_line_box_input_focused_default_border);
        return false;
    L50:
        return false;
    L21:
        ConstraintLayout r16 = r10.f14740w;
        if (r16 == null) goto L51;
        r16.setBackgroundResource(R$drawable.o_line_box_input_normal_default_border);
        return false;
    L51:
        return false;
    L26:
        if (r10.M == false) goto L32;
        ConstraintLayout r17 = r10.f14740w;
        if (r17 == null) goto L52;
        r17.setBackgroundResource(R$drawable.o_line_box_input_error_pressed_border);
        return false;
    L52:
        return false;
    L32:
        if (r10.f14724g.hasFocus() == false) goto L37;
        ConstraintLayout r18 = r10.f14740w;
        if (r18 == null) goto L53;
        r18.setBackgroundResource(R$drawable.o_line_box_input_focused_pressed_border);
        return false;
    L53:
        return false;
    L37:
        ConstraintLayout r19 = r10.f14740w;
        if (r19 == null) goto L54;
        r19.setBackgroundResource(R$drawable.o_line_box_input_normal_pressed_border);
        return false;
    L54:
        return false;
    }

    public static /* synthetic */ void E(OLineInputView r10, int r11, View.OnClickListener r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.D(r11, r12);
    }

    private final void N() {
        Object r10 = getContext().getSystemService("input_method");
        if (r10 == null) goto L7;
        ((InputMethodManager) r10).showSoftInput(this, 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static /* synthetic */ void g(OLineInputView r10, View r11, boolean r12) {
        A(r10, r11, r12);
    }

    public static /* synthetic */ void h(OLineInputView r10, View r11, boolean r12) {
        y(r10, r11, r12);
    }

    public static /* synthetic */ boolean i(OLineInputView r10, View r11, MotionEvent r12) {
        return B(r10, r11, r12);
    }

    public static /* synthetic */ void j(OLineInputView r10, View r11) {
        z(r10, r11);
    }

    public static final /* synthetic */ b k(OLineInputView r10) {
        return r10.f14743z;
    }

    private final void l() {
        Iterator<WeakReference<TextWatcher>> r10 = getTextWatchers().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r11 = r10.next();
        this.f14724g.removeTextChangedListener(r11.get());
        goto L4
    }

    private final void t() {
        Object r10 = getContext().getSystemService("input_method");
        if (r10 == null) goto L7;
        ((InputMethodManager) r10).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final void y(OLineInputView r10, View r11, boolean r12) {
        q.g(r10, "this$0");
        if (r12 == false) goto L5;
        r10.N();
        return;
    L5:
        r10.t();
    }

    public static final void z(OLineInputView r10, View r11) {
        q.g(r10, "this$0");
        TextClearedListener r12 = r10.f14743z.v();
        if (r12 == null) goto L6;
        r12.beforeClear();
    L6:
        r10.setText("");
        TextClearedListener r13 = r10.f14743z.v();
        if (r13 == null) goto L11;
        r13.afterClear();
        return;
    }

    public final void C() {
        ViewGroup.LayoutParams r10 = this.f14735r.getLayoutParams();
        q.f(r10, "ivTitleIcon.getLayoutParams()");
        r10.width = tc.f.r(this, 16);
        r10.height = tc.f.r(this, 16);
        this.f14735r.setLayoutParams(r10);
    }

    public final void D(int r10, View.OnClickListener r11) {
        if (r10 != 2) goto L5;
        this.f14724g.setFocusable(true);
        this.f14724g.setFocusableInTouchMode(true);
        this.f14724g.setOnClickListener(null);
        setOnClickListener(null);
        return;
    L5:
        if (r10 != 3) goto L15;
        this.f14724g.setFocusable(false);
        this.f14724g.setFocusableInTouchMode(false);
        if (r11 != null) goto L10;
        this.f14724g.setOnClickListener(this.f14743z.b());
        setOnClickListener(this.f14743z.b());
        return;
    L10:
        this.f14724g.setOnClickListener(r11);
        setOnClickListener(r11);
        return;
    }

    public final void F() {
        ViewGroup.LayoutParams r10 = this.f14735r.getLayoutParams();
        q.f(r10, "ivTitleIcon.getLayoutParams()");
        r10.width = tc.f.r(this, 10);
        r10.height = tc.f.r(this, 10);
        this.f14735r.setLayoutParams(r10);
    }

    public final void G() {
        if (this.f14730m.getVisibility() == 0) goto L6;
        tc.l.m(this.f14730m);
    L6:
        this.K = true;
    }

    public final void H() {
        tc.l.m(this.f14727j);
        this.f14721J = true;
    }

    public final void I() {
        tc.l.m(this.f14729l);
        tc.l.m(this.f14728k);
        this.f14743z.G(false);
    }

    public final void J() {
        tc.l.m(this.f14732o);
        this.f14743z.I(true);
    }

    public final void K(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        tc.l.m(this.f14725h);
        this.f14725h.setText(r10);
        this.f14732o.setBackgroundColor(ContextCompat.b(getContext(), R$color.Primary));
        if (tc.l.j(this.f14736s) == false) goto L7;
        r();
    L7:
        this.F = true;
        this.O = r10;
    }

    public final void L(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f14736s.setText(r10);
        tc.l.m(this.f14736s);
        if (this.f14725h.getVisibility() != 0) goto L7;
        q();
    L7:
        this.G = true;
        this.P = r10;
    }

    public final void M() {
        tc.l.m(this.f14733p);
        this.H = true;
    }

    public final void O() {
        tc.l.m(this.f14734q);
        this.I = true;
    }

    public final void P() {
        tc.l.m(this.f14723f);
        if (this.f14737t.getVisibility() == 0) goto L6;
        tc.l.m(this.f14737t);
    L6:
        this.E = true;
    }

    public final void Q() {
        if (this.f14737t.getVisibility() == 0) goto L6;
        tc.l.m(this.f14737t);
    L6:
        tc.l.m(this.f14735r);
        this.L = true;
    }

    public final void R(b r10) {
        q.g(r10, "newConfig");
        this.f14743z = r10;
        l();
        x();
    }

    @NotNull
    public final ViewGroup getActionContainer() {
        return this.f14739v;
    }

    @Nullable
    public final ConstraintLayout getActiveBorderView() {
        return this.f14740w;
    }

    public final int getArrangeDirection() {
        return this.f14722e;
    }

    @NotNull
    public final b getConfig() {
        return this.f14743z;
    }

    @NotNull
    public final ODivider getDivider() {
        return this.f14732o;
    }

    @NotNull
    public final OFormEditText getEditText() {
        return this.f14724g;
    }

    @NotNull
    public final ViewGroup getInputContainer() {
        return this.f14738u;
    }

    @Override // com.obric.oui.forms.AbsOForm
    @NotNull
    public EditText getInterEditText() {
        return this.f14724g;
    }

    @NotNull
    public final ImageView getIvAction() {
        return this.f14730m;
    }

    @NotNull
    public final LinearLayout getIvActionContainer() {
        return this.f14731n;
    }

    @NotNull
    public final ImageView getIvClear() {
        return this.f14728k;
    }

    @NotNull
    public final LinearLayout getIvClearContainer() {
        return this.f14729l;
    }

    @NotNull
    public final ImageView getIvTitleIcon() {
        return this.f14735r;
    }

    @Nullable
    public final ConstraintLayout getLeftContainer() {
        return this.f14741x;
    }

    @NotNull
    public final RelativeLayout getPrefixContainer() {
        return this.f14733p;
    }

    @NotNull
    public final RelativeLayout getSuffixContainer() {
        return this.f14734q;
    }

    @NotNull
    public final String getText() {
        return String.valueOf(this.f14724g.getText());
    }

    @NotNull
    public final ViewGroup getTitleContainer() {
        return this.f14737t;
    }

    @NotNull
    public final TextView getTvAction() {
        return this.f14727j;
    }

    @NotNull
    public final TextView getTvCounter() {
        return this.f14726i;
    }

    @NotNull
    public final TextView getTvErrorTips() {
        return this.f14725h;
    }

    @NotNull
    public final TextView getTvInputTips() {
        return this.f14736s;
    }

    @NotNull
    public final TextView getTvTitle() {
        return this.f14723f;
    }

    public final void m() {
        if (this.f14730m.getVisibility() != 0) goto L5;
        tc.l.k(this.f14730m);
    L5:
        this.K = false;
    }

    public final void n() {
        tc.l.k(this.f14727j);
        this.f14721J = false;
    }

    public final void o() {
        tc.l.k(this.f14729l);
        tc.l.k(this.f14728k);
        this.f14743z.G(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r10 = tc.f.r(this, 44);
        tc.l.c(this.f14739v, tc.f.r(this, 44));
        tc.l.g(this.f14739v, r10, r10, new View[]{this.f14727j, this.f14730m});
    }

    public final void p() {
        tc.l.k(this.f14732o);
        this.f14743z.I(false);
    }

    public final void q() {
        tc.l.k(this.f14725h);
        this.f14732o.setStyle(0);
        CharSequence r10 = this.f14736s.getText();
        q.f(r10, "tvInputTips.text");
        if (r10.length() <= 0) goto L5;
        L(this.f14736s.getText().toString());
    L5:
        this.F = false;
    }

    public final void r() {
        tc.l.k(this.f14736s);
        this.G = false;
    }

    public final void s() {
        tc.l.k(this.f14733p);
        this.H = false;
    }

    public final void setActiveBorderView(@Nullable ConstraintLayout r10) {
        this.f14740w = r10;
    }

    public final void setArrangeDirection(int r10) {
        this.f14722e = r10;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r10) {
        b r11 = getConfig();
        r11.A(r10);
        R(r11);
    }

    public final void setEditTextOnFocusChangeListener(@NotNull View.OnFocusChangeListener r10) {
        q.g(r10, "listener");
        this.f14724g.setOnFocusChangeListener(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        this.f14724g.setEnabled(r10);
        super.setEnabled(r10);
    }

    public final void setInputContainerBackground(@NotNull Drawable r10) {
        q.g(r10, "drawable");
        this.f14738u.setBackground(r10);
    }

    public final void setLeftContainer(@Nullable ConstraintLayout r10) {
        this.f14741x = r10;
    }

    public final void setText(@Nullable String r10) {
        if (r10 == null) goto L8;
        this.f14724g.setText(r10);
        TextWatcher r11 = this.A;
        if (r11 == null) goto L9;
        r11.onTextChanged(r10, 0, 0, r10.length());
        return;
    L9:
        return;
    }

    public final void setTextClearedListener(@NotNull TextClearedListener r10) {
        q.g(r10, "textClearedListener");
        this.f14743z.J(r10);
    }

    public final void setTextExceedLengthListener(@NotNull TextExceedLengthListener r10) {
        q.g(r10, "textExceedLengthListener");
        this.f14743z.K(r10);
    }

    public final void setTextWatcher(@Nullable TextWatcher r10) {
        this.f14743z.L(r10);
        x();
    }

    public final void u() {
        tc.l.k(this.f14734q);
        this.I = false;
    }

    public final void v() {
        tc.l.k(this.f14723f);
        if (this.f14735r.getVisibility() == 0) goto L6;
        tc.l.k(this.f14737t);
    L6:
        this.E = false;
    }

    public final void w() {
        tc.l.k(this.f14735r);
        if (this.f14723f.getVisibility() == 0) goto L5;
    L6:
        tc.l.k(this.f14737t);
    L7:
        this.L = false;
        return;
    L5:
        if (TextUtils.isEmpty(this.f14723f.getText()) == false) goto L7;
        goto L6
    }

    public final void x() {
        String r10 = this.f14743z.y();
        if (r10 != null) goto L5;
    L8:
        this.E = false;
    L10:
        if (this.E == false) goto L12;
        P();
    L14:
        if (this.f14743z.m() == null) goto L17;
        this.f14735r.setImageDrawable(this.f14743z.m());
        this.L = true;
    L17:
        if (this.L == false) goto L19;
        Q();
    L20:
        int r11 = this.C;
        if (r11 == 0) goto L25;
        if (r11 == 1) goto L24;
        F();
    L27:
        if (this.f14743z.g() == false) goto L30;
        d r12 = new d(this);
        getTextWatchers().add(new WeakReference(r12));
        this.f14724g.addTextChangedListener(r12);
    L30:
        if (this.f14743z.s() == false) goto L35;
        if (this.f14743z.n() == null) goto L35;
        this.A = new c(this);
        ArrayList<WeakReference<TextWatcher>> r13 = getTextWatchers();
        TextWatcher r14 = this.A;
        q.d(r14);
        r13.add(new WeakReference(r14));
        this.f14724g.addTextChangedListener(this.A);
        tc.l.m(this.f14726i);
    L35:
        if (this.f14743z.r() == true) goto L37;
        o();
        this.f14724g.setOnFocusChangeListener(new l(this));
    L41:
        String r15 = this.f14743z.j();
        if (r15 == null) goto L48;
        if (r15.length() == 0) goto L48;
        this.f14724g.setHint(this.f14743z.j());
    L48:
        if (this.f14743z.q() == null) goto L51;
        this.f14733p.removeAllViews();
        this.f14733p.addView(this.f14743z.q(), new ConstraintLayout.LayoutParams(-2, -2));
        M();
    L51:
        if (this.f14743z.u() == null) goto L54;
        this.f14734q.removeAllViews();
        this.f14734q.addView(this.f14743z.u(), new ConstraintLayout.LayoutParams(-2, -2));
        O();
    L54:
        if (this.f14743z.z() == false) goto L57;
        this.f14743z.I(false);
    L57:
        if (this.f14743z.t() == false) goto L59;
        J();
    L60:
        String r16 = this.f14743z.c();
        if (r16 == null) goto L76;
        if (r16.length() == 0) goto L76;
        this.f14727j.setText(this.f14743z.c());
        if (this.f14743z.e() == null) goto L68;
        TextView r17 = this.f14727j;
        Integer r18 = this.f14743z.e();
        q.d(r18);
        r17.setTextColor(r18.intValue());
    L70:
        if (this.f14743z.d() == true) goto L72;
    L74:
        H();
        goto L76
    L72:
        if (this.f14743z.f() == null) goto L74;
        this.f14727j.setOnClickListener(this.f14743z.f());
        goto L74
    L68:
        this.f14727j.setTextColor(ContextCompat.b(getContext(), R$color.TextPrimary));
    L76:
        if (this.f14743z.x() == null) goto L79;
        ArrayList<WeakReference<TextWatcher>> r19 = getTextWatchers();
        TextWatcher r20 = this.f14743z.x();
        q.d(r20);
        r19.add(new WeakReference(r20));
        this.f14724g.addTextChangedListener(this.f14743z.x());
    L79:
        if (this.f14743z.a() == null) goto L85;
        this.f14730m.setImageDrawable(this.f14743z.a());
        if (this.f14743z.b() == null) goto L83;
        this.f14730m.setOnClickListener(this.f14743z.b());
    L83:
        G();
    L85:
        if (TextUtils.isEmpty(this.f14743z.l()) == true) goto L88;
        String r21 = this.f14743z.l();
        q.d(r21);
        L(r21);
    L88:
        if (this.f14743z.k() == null) goto L94;
        ViewGroup r22 = this.f14738u;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L93;
        ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        Integer r25 = this.f14743z.k();
        q.d(r25);
        ((ViewGroup.MarginLayoutParams) r24).height = r25.intValue();
        r22.setLayoutParams(r24);
    L108:
        if (this.f14743z.p() == false) goto L110;
        OFormEditText r26 = this.f14724g;
        r26.setSingleLine(false);
        r26.setLines(this.N);
    L111:
        String r27 = this.f14742y;
        if (r27 == null) goto L118;
        if (r27.length() == 0) goto L118;
        setText(this.f14742y);
    L118:
        if (this.B == true) goto L120;
    L122:
        this.f14724g.setGravity(this.D);
        if (this.f14743z.h() == null) goto L126;
        View.OnFocusChangeListener r28 = this.f14743z.h();
        q.d(r28);
        setEditTextOnFocusChangeListener(r28);
    L126:
        if (this.E == false) goto L128;
        P();
    L130:
        if (this.F == false) goto L132;
        String r29 = this.O;
        q.d(r29);
        K(r29);
    L134:
        if (this.G == false) goto L136;
        String r30 = this.P;
        q.d(r30);
        L(r30);
    L138:
        if (this.H == false) goto L140;
        M();
    L142:
        if (this.I == false) goto L144;
        O();
    L146:
        if (this.f14721J == false) goto L148;
        H();
    L150:
        if (this.K == false) goto L152;
        G();
    L153:
        E(this, this.f14743z.o(), null, 2, null);
        return;
    L152:
        m();
        goto L153
    L148:
        n();
        goto L150
    L144:
        u();
        goto L146
    L140:
        s();
        goto L142
    L136:
        r();
        goto L138
    L132:
        q();
        goto L134
    L128:
        v();
        goto L130
    L120:
        if (this.f14743z.m() != null) goto L122;
        Q();
        goto L122
    L110:
        this.f14724g.setSingleLine(true);
        goto L111
    L93:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L94:
        ViewGroup r31 = this.f14738u;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
        if (r32 == null) goto L156;
        ConstraintLayout.LayoutParams r33 = (ConstraintLayout.LayoutParams) r32;
        int r34 = getArrangeDirection();
        if (r34 == 1) goto L103;
        if (r34 == 2) goto L101;
        int r35 = tc.f.r(this, 40);
    L106:
        ((ViewGroup.MarginLayoutParams) r33).height = r35;
        r31.setLayoutParams(r33);
        goto L108
    L101:
        r35 = tc.f.r(this, 40);
        goto L106
    L103:
        if (this.f14743z.z() == false) goto L105;
        r35 = tc.f.r(this, 36);
        goto L106
    L105:
        r35 = tc.f.r(this, 52);
        goto L106
    L156:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L59:
        p();
        goto L60
    L37:
        this.f14728k.setOnClickListener(new m(this));
        if (TextUtils.isEmpty(this.f14724g.getText()) == false) goto L40;
        tc.l.k(this.f14728k);
        tc.l.k(this.f14729l);
    L40:
        this.f14724g.setOnFocusChangeListener(new n(this));
        this.f14724g.setOnTouchListener(new o(this));
        goto L41
    L24:
        C();
        goto L27
    L25:
        F();
        goto L27
    L19:
        w();
        goto L20
    L12:
        v();
        goto L14
    L5:
        if (kotlin.text.o.r(r10) == true) goto L8;
        this.f14723f.setText(this.f14743z.y());
        goto L10
    }

    @JvmOverloads
    public OLineInputView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OLineInputView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OLineInputView(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 1;
    L11:
        this(r10, r11, r12, r13);
    }

    public OLineInputView(Context r33, AttributeSet r34, int r35, int r36) {
        q.g(r33, "context");
        super(r33, r34, r35);
        this.f14722e = r36;
        String r10 = null;
        String r11 = null;
        Drawable r12 = null;
        boolean r13 = false;
        Integer r14 = null;
        boolean r15 = false;
        String r16 = null;
        View r17 = null;
        View r18 = null;
        boolean r19 = false;
        String r110 = null;
        Integer r111 = null;
        boolean r112 = false;
        View.OnClickListener r113 = null;
        Drawable r114 = null;
        View.OnClickListener r115 = null;
        TextWatcher r20 = null;
        View.OnFocusChangeListener r21 = null;
        Integer r22 = null;
        boolean r23 = false;
        boolean r24 = false;
        boolean r25 = false;
        int r26 = 0;
        boolean r27 = false;
        TextExceedLengthListener r28 = null;
        TextClearedListener r29 = null;
        this.f14743z = new b.a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, 67108863, null).a();
        this.D = 16;
        this.E = true;
        this.N = 20;
        this.O = "";
        this.P = "";
        TypedArray r30 = r33.getTheme().obtainStyledAttributes(r34, R$styleable.OLineInputView, r35, 0);
        setArrangeDirection(r30.getInt(R$styleable.OLineInputView_oui_formArrangeDirection, 0));
        String r31 = r30.getString(R$styleable.OLineInputView_oui_formTitle);
        b r32 = this.f14743z;
        if (r31 != null) goto L5;
        r31 = "title";
    L5:
        r32.M(r31);
        boolean r37 = r30.getBoolean(R$styleable.OLineInputView_oui_formShowClear, true);
        this.f14743z.G(r37);
        String r38 = r30.getString(R$styleable.OLineInputView_android_hint);
        this.f14743z.B(r38);
        boolean r39 = r30.getBoolean(R$styleable.OLineInputView_oui_formShowCounter, false);
        this.f14743z.H(r39);
        int r40 = r30.getInt(R$styleable.OLineInputView_oui_formLengthLimit, 0);
        if (r40 <= 0) goto L8;
        this.f14743z.E(Integer.valueOf(r40));
    L8:
        int r41 = r30.getDimensionPixelSize(R$styleable.OLineInputView_oui_formInputHeight, 0);
        if (r41 <= 0) goto L11;
        this.f14743z.C(Integer.valueOf(r41));
    L11:
        this.f14743z.F(r30.getBoolean(R$styleable.OLineInputView_oui_formMultiLine, false));
        boolean r42 = r30.getBoolean(R$styleable.OLineInputView_oui_formShowDivider, true);
        this.f14743z.I(r42);
        String r43 = r30.getString(R$styleable.OLineInputView_oui_formInputTips);
        this.f14743z.D(r43);
        this.f14742y = r30.getString(R$styleable.OLineInputView_android_text);
        this.B = r30.getBoolean(R$styleable.OLineInputView_oui_formShowTitleDefaultIcon, false);
        this.C = r30.getInt(R$styleable.OLineInputView_oui_formTitleDefaultIconSize, 0);
        this.D = r30.getInt(R$styleable.OLineInputView_android_gravity, 16);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
        int r44 = this.f14722e;
        if (r44 == 0) goto L19;
        if (r44 != 1) goto L15;
        int r45 = R$layout.o_form_line_input_horizontal;
    L20:
        LayoutInflater.from(r33).inflate(r45, this);
        View r46 = findViewById(R$id.tv_title);
        q.f(r46, "findViewById(R.id.tv_title)");
        this.f14723f = (TextView) r46;
        View r47 = findViewById(R$id.et_input);
        q.f(r47, "findViewById(R.id.et_input)");
        OFormEditText r48 = (OFormEditText) r47;
        this.f14724g = r48;
        View r49 = findViewById(R$id.tv_error_tips);
        q.f(r49, "findViewById(R.id.tv_error_tips)");
        this.f14725h = (TextView) r49;
        View r50 = findViewById(R$id.tv_counter);
        q.f(r50, "findViewById(R.id.tv_counter)");
        this.f14726i = (TextView) r50;
        View r51 = findViewById(R$id.tv_action);
        q.f(r51, "findViewById(R.id.tv_action)");
        this.f14727j = (TextView) r51;
        View r52 = findViewById(R$id.iv_clear);
        q.f(r52, "findViewById(R.id.iv_clear)");
        this.f14728k = (ImageView) r52;
        View r53 = findViewById(R$id.iv_action);
        q.f(r53, "findViewById(R.id.iv_action)");
        this.f14730m = (ImageView) r53;
        View r54 = findViewById(R$id.divider);
        q.f(r54, "findViewById(R.id.divider)");
        this.f14732o = (ODivider) r54;
        View r55 = findViewById(R$id.iv_title_icon);
        q.f(r55, "findViewById(R.id.iv_title_icon)");
        this.f14735r = (ImageView) r55;
        View r56 = findViewById(R$id.prefix_container);
        q.f(r56, "findViewById(R.id.prefix_container)");
        this.f14733p = (RelativeLayout) r56;
        View r57 = findViewById(R$id.suffix_container);
        q.f(r57, "findViewById(R.id.suffix_container)");
        this.f14734q = (RelativeLayout) r57;
        View r58 = findViewById(R$id.tv_input_tips);
        q.f(r58, "findViewById(R.id.tv_input_tips)");
        this.f14736s = (TextView) r58;
        View r59 = findViewById(R$id.title_container);
        q.f(r59, "findViewById(R.id.title_container)");
        this.f14737t = (ViewGroup) r59;
        View r60 = findViewById(R$id.input_container);
        q.f(r60, "findViewById(R.id.input_container)");
        this.f14738u = (ViewGroup) r60;
        this.f14741x = (ConstraintLayout) findViewById(R$id.left_container);
        View r61 = findViewById(R$id.action_container);
        q.f(r61, "findViewById(R.id.action_container)");
        this.f14739v = (ViewGroup) r61;
        this.f14740w = (ConstraintLayout) findViewById(R$id.active_border_view);
        View r62 = findViewById(R$id.iv_clear_container);
        q.f(r62, "findViewById(R.id.iv_clear_container)");
        this.f14729l = (LinearLayout) r62;
        View r63 = findViewById(R$id.iv_action_container);
        q.f(r63, "findViewById(R.id.iv_action_container)");
        this.f14731n = (LinearLayout) r63;
        R(this.f14743z);
        r48.setVerticalScrollBarEnabled(false);
        return;
    L15:
        if (r44 == 2) goto L17;
        r45 = R$layout.o_form_line_input_vertical;
        goto L20
    L17:
        r45 = R$layout.o_form_line_input_vertical_single_box;
        goto L20
    L19:
        r45 = R$layout.o_form_line_input_vertical;
        goto L20
    }
}
