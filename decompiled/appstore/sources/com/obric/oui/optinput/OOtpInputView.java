package com.obric.oui.optinput;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import bg.h;
import com.bytedanceos.common.toolbox.ServerElements;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n*\u0002¢\u0001\u0018\u0000 k2\u00020\u0001:\u0006jµ\u0001¶\u0001nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\fJ\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\fJ\u0015\u0010\"\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u001cJ\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\u0019J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010$¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\r¢\u0006\u0004\b+\u0010\u0017J\u0015\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\r¢\u0006\u0004\b-\u0010\u0017J\u0017\u0010/\u001a\u00020\n2\b\b\u0001\u0010.\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\u001cJ\u0015\u00102\u001a\u00020\n2\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\n2\u0006\u00101\u001a\u000200¢\u0006\u0004\b4\u00103J\u0015\u00105\u001a\u00020\n2\u0006\u00101\u001a\u000200¢\u0006\u0004\b5\u00103J\u0017\u00106\u001a\u00020\n2\b\b\u0001\u0010.\u001a\u00020\u0006¢\u0006\u0004\b6\u0010\u001cJ\u0017\u00107\u001a\u00020\n2\b\b\u0001\u0010.\u001a\u00020\u0006¢\u0006\u0004\b7\u0010\u001cJ\u0015\u00109\u001a\u00020\n2\u0006\u00108\u001a\u000200¢\u0006\u0004\b9\u00103J\u0017\u0010:\u001a\u00020\n2\b\b\u0001\u0010.\u001a\u00020\u0006¢\u0006\u0004\b:\u0010\u001cJ\u001f\u0010=\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0014¢\u0006\u0004\b=\u0010>J7\u0010D\u001a\u00020\n2\u0006\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0006H\u0014¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020\n2\u0006\u0010G\u001a\u00020FH\u0014¢\u0006\u0004\bH\u0010IJ\u0019\u0010L\u001a\u00020\n2\b\u0010K\u001a\u0004\u0018\u00010JH\u0014¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\rH\u0016¢\u0006\u0004\bN\u0010\u000fJ\u0017\u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010V\u001a\u00020\n2\u0006\u0010U\u001a\u00020TH\u0000¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\rH\u0000¢\u0006\u0004\bX\u0010\u000fJ\u001f\u0010\\\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J)\u0010b\u001a\u00020\n2\u0006\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020\u00062\b\u0010a\u001a\u0004\u0018\u00010`H\u0014¢\u0006\u0004\bb\u0010cJ\u0017\u0010e\u001a\u00020\r2\u0006\u0010[\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020\rH\u0016¢\u0006\u0004\bg\u0010\u000fJ\u000f\u0010h\u001a\u00020\nH\u0014¢\u0006\u0004\bh\u0010\fJ\u000f\u0010i\u001a\u00020\nH\u0014¢\u0006\u0004\bi\u0010\fR\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010kR\u0016\u0010t\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010sR\u0016\u0010u\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010sR\u0016\u0010v\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010sR\u0016\u0010w\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010sR\u0016\u0010x\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010sR\u0016\u0010y\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bX\u0010kR\u0016\u0010z\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010kR\u0016\u0010{\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010kR\u0016\u0010|\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010sR\u0016\u0010}\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010kR\u0016\u0010\u007f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010~R\u0017\u0010\u0080\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010~R\u0017\u0010\u0083\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000e\u0010\u0082\u0001R\u0017\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001e\u0010\u0082\u0001R\u0017\u0010\u0085\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b \u0010\u0082\u0001R\u0017\u0010\u0086\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b!\u0010\u0082\u0001R\u0017\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0010\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008f\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010sR\u0016\u0010\u0091\u0001\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010oR\u0018\u0010\u0093\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010sR\u0018\u0010\u0095\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010sR\u0018\u0010\u0097\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010sR\u0018\u0010\u0099\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010sR\u0018\u0010\u009b\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010sR\u0018\u0010\u009d\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010sR\u0018\u0010\u009f\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010~R\u0018\u0010¡\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010~R\u0017\u0010¤\u0001\u001a\u00030¢\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bs\u0010£\u0001R,\u0010¬\u0001\u001a\u0005\u0018\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R,\u0010´\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001¨\u0006·\u0001"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "n", "()V", "", "p", "()Z", "t", "g", "k", "m", "l", "silence", "e", "(Z)V", "h", "()I", "length", "d", "(I)V", "o", "q", "j", "r", "s", "setCodeLength", "getCodeLength", "", "getCode", "()Ljava/lang/String;", ServerElements.CODE, "setCode", "(Ljava/lang/String;)V", "enabled", "setPasswordMode", "visible", "setCursorVisible", "color", "setCursorColor", "", "px", "setCellSpacing", "(F)V", "setCellCornerRadius", "setCellStrokeWidth", "setCellStrokeColor", "setCellBackgroundColor", CloudControlInf.SP, "setTextSizeSp", "setTextColor", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCheckIsTextEditor", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "", "text", "f", "(Ljava/lang/CharSequence;)V", "i", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "gainFocus", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "onFocusChanged", "(ZILandroid/graphics/Rect;)V", "Landroid/view/MotionEvent;", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "performClick", "onAttachedToWindow", "onDetachedFromWindow", "a", "I", "codeLength", "", "b", "[C", "codeChars", "c", "inputIndex", "F", "cellWidth", "cellHeight", "cellSpacing", "cellCornerRadius", "cellStrokeWidth", "cellBackgroundColor", "cellStrokeColor", "textColor", "textSizePx", "cursorColor", "Z", "passwordMode", "cursorVisible", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "boxPaintFill", "boxPaintStroke", "textPaint", "cursorPaint", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "cellRect", "Landroid/graphics/Paint$FontMetrics;", "u", "Landroid/graphics/Paint$FontMetrics;", "textFontMetrics", "v", "textCenterYOffset", "w", "oneCharArray", FixCard.FixStyle.KEY_X, "cellsStartX", FixCard.FixStyle.KEY_Y, "cellsTop", "z", "cellCenterY", "A", "actualCellSpacing", "B", "passwordCircleRadius", "C", "cursorHalfWidth", "D", "cursorBlinkOn", "E", "blinkStarted", "com/obric/oui/optinput/OOtpInputView$c", "Lcom/obric/oui/optinput/OOtpInputView$c;", "cursorBlinkRunnable", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "G", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "getOnCodeCompleteListener", "()Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "setOnCodeCompleteListener", "(Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;)V", "onCodeCompleteListener", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "H", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "getOnCodeChangeListener", "()Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "setOnCodeChangeListener", "(Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;)V", "onCodeChangeListener", "OnCodeChangeListener", "OnCodeCompleteListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OOtpInputView extends View {
    public static final a I = null;
    public float A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public final c F;
    public OnCodeCompleteListener G;
    public OnCodeChangeListener H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char[] f15304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f15306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f15307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f15308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f15309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f15310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f15314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15315m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f15316n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15317o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f15318p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f15319q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f15320r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f15321s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f15322t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint.FontMetrics f15323u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f15324v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final char[] f15325w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f15326x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f15327y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f15328z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "", "onCodeChange", "", ServerElements.CODE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCodeChangeListener {
        void onCodeChange(@NotNull String r10);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "", "onCodeComplete", "", ServerElements.CODE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCodeCompleteListener {
        void onCodeComplete(@NotNull String r10);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends BaseInputConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OOtpInputView f15329a;

        public b(OOtpInputView r10) {
            q.g(r10, "view");
            super(r10, false);
            this.f15329a = r10;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence r10, int r11) {
            if (r10 != null) goto L5;
        L8:
            return true;
        L5:
            if (r10.length() == 0) goto L8;
            this.f15329a.f(r10);
            goto L8
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int r10, int r11) {
            if (this.f15329a.i() == false) goto L6;
            return true;
        L6:
            return super.deleteSurroundingText(r10, r11);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent r10) {
            q.g(r10, "event");
            if (r10.getAction() != 0) goto L14;
            if (r10.getKeyCode() == 67) goto L7;
            char r11 = (char) r10.getUnicodeChar();
            if (Character.isDigit(r11) == false) goto L14;
            this.f15329a.f(String.valueOf(r11));
            return true;
        L7:
            if (this.f15329a.i() == false) goto L14;
            return true;
        L14:
            return super.sendKeyEvent(r10);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OOtpInputView f15330a;

        public c(OOtpInputView r10) {
            this.f15330a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OOtpInputView.a(this.f15330a) == true) goto L5;
            return;
        L5:
            OOtpInputView r10 = this.f15330a;
            OOtpInputView.c(r10, !OOtpInputView.b(r10));
            this.f15330a.invalidate();
            this.f15330a.postDelayed(this, 500);
        }
    }

    static {
        I = new a(null);
    }

    @JvmOverloads
    public OOtpInputView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ boolean a(OOtpInputView r10) {
        return r10.E;
    }

    public static final /* synthetic */ boolean b(OOtpInputView r10) {
        return r10.D;
    }

    public static final /* synthetic */ void c(OOtpInputView r10, boolean r11) {
        r10.D = r11;
    }

    public final void d(int r10) {
        int r11 = h.k(r10, 1, 6);
        if (r11 != this.f15303a) goto L5;
        return;
    L5:
        this.f15303a = r11;
        this.f15304b = new char[r11];
        this.f15305c = 0;
    }

    public final void e(boolean r10) {
        int r11 = this.f15303a;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f15304b[r12] = 0;
        r12 = r12 + 1;
        goto L3
    L5:
        this.f15305c = 0;
        if (r10 == true) goto L10;
        l();
        invalidate();
        return;
    }

    public final void f(CharSequence r10) {
        q.g(r10, "text");
        if (k() == false) goto L5;
        return;
    L5:
        int r11 = 0;
        boolean r12 = false;
    L7:
        if (r11 >= r10.length()) goto L16;
        char r13 = r10.charAt(r11);
        r11 = r11 + 1;
        if (Character.isDigit(r13) == false) goto L7;
        int r14 = this.f15305c;
        int r15 = this.f15303a;
        if (r14 >= r15) goto L16;
        this.f15304b[r14] = r13;
        int r16 = r14 + 1;
        this.f15305c = r16;
        r12 = true;
        if (r16 < r15) goto L7;
    L16:
        if (r12 == false) goto L28;
        l();
        invalidate();
        if (k() == false) goto L29;
        m();
        return;
    L29:
        return;
    }

    public final boolean g() {
        int r10 = this.f15305c;
        if (r10 > 0) goto L5;
        return false;
    L5:
        int r11 = h.d(r10 - 1, 0);
        char[] r12 = this.f15304b;
        if (r12[r11] != 0) goto L17;
        if (r11 < 0) goto L15;
    L8:
        int r13 = r11 - 1;
        char[] r14 = this.f15304b;
        if (r14[r11] != 0) goto L10;
        if (r13 < 0) goto L15;
        r11 = r13;
        goto L8
    L10:
        r14[r11] = 0;
        this.f15305c = r11;
        return true;
    L15:
        this.f15305c = 0;
        return false;
    L17:
        r12[r11] = 0;
        this.f15305c = r11;
        return true;
    }

    @NotNull
    public final String getCode() {
        StringBuilder r10 = new StringBuilder(this.f15303a);
        int r11 = this.f15303a;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L7;
        int r13 = r12 + 1;
        char r14 = this.f15304b[r12];
        if (r14 == 0) goto L7;
        r10.append(r14);
        r12 = r13;
    L7:
        String r15 = r10.toString();
        q.f(r15, "builder.toString()");
        return r15;
    }

    public final int getCodeLength() {
        return this.f15303a;
    }

    @Nullable
    public final OnCodeChangeListener getOnCodeChangeListener() {
        return this.H;
    }

    @Nullable
    public final OnCodeCompleteListener getOnCodeCompleteListener() {
        return this.G;
    }

    public final int h() {
        int r10 = this.f15303a;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        int r12 = r11 + 1;
        if (this.f15304b[r11] == 0) goto L6;
        r11 = r12;
        goto L3
    L6:
        return r11;
    L9:
        return this.f15303a;
    }

    public final boolean i() {
        boolean r10 = g();
        if (r10 == false) goto L5;
        l();
        invalidate();
    L5:
        return r10;
    }

    public final void j() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r11 = (InputMethodManager) r10;
    L6:
        if (r11 == null) goto L10;
        r11.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final boolean k() {
        if (this.f15305c < this.f15303a) goto L5;
        return true;
    L5:
        return false;
    }

    public final void l() {
        OnCodeChangeListener r10 = this.H;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.onCodeChange(getCode());
    }

    public final void m() {
        OnCodeCompleteListener r10 = this.G;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.onCodeComplete(getCode());
    }

    public final void n() {
        this.B = f.t(this, 4.0f);
        this.C = f.t(this, 1.0f);
    }

    public final void o() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r11 = (InputMethodManager) r10;
    L6:
        if (r11 == null) goto L10;
        r11.restartInput(this);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocusable() == false) goto L10;
        if (isFocusableInTouchMode() == false) goto L10;
        if (isInEditMode() == true) goto L10;
        requestFocus();
        q();
    L10:
        if (hasFocus() == true) goto L12;
        return;
    L12:
        if (this.f15317o == false) goto L16;
        r();
        return;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        n();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r10) {
        q.g(r10, "outAttrs");
        if (this.f15316n == false) goto L5;
        int r11 = 16;
    L6:
        r10.inputType = r11 | 2;
        r10.imeOptions = 268435462;
        int r12 = this.f15305c;
        r10.initialSelStart = r12;
        r10.initialSelEnd = r12;
        return new b(this);
    L5:
        r11 = 0;
        goto L6
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
    }

    @Override // android.view.View
    public void onDraw(Canvas r13) {
        q.g(r13, "canvas");
        super.onDraw(r13);
        this.f15318p.setColor(this.f15311i);
        this.f15319q.setColor(this.f15312j);
        int r10 = this.f15303a;
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L16;
        int r12 = r11 + 1;
        float r14 = this.f15326x;
        float r15 = this.f15306d;
        float r16 = r14 + (r11 * (this.A + r15));
        float r17 = this.f15327y;
        float r18 = this.f15307e + r17;
        this.f15322t.set(r16, r17, r15 + r16, r18);
        RectF r19 = this.f15322t;
        float r20 = this.f15309g;
        r13.drawRoundRect(r19, r20, r20, this.f15318p);
        float r21 = this.f15310h;
        if (r21 <= 0.0f) goto L8;
        float r22 = r21 / 2.0f;
        float r23 = h.c(this.f15309g - r22, 0.0f);
        this.f15322t.inset(r22, r22);
        r13.drawRoundRect(this.f15322t, r23, r23, this.f15319q);
        float r24 = -r22;
        this.f15322t.inset(r24, r24);
    L8:
        char r25 = this.f15304b[r11];
        if (r25 == 0) goto L14;
        float r26 = this.f15322t.centerX();
        if (this.f15316n == false) goto L13;
        r13.drawCircle(r26, this.f15328z, this.B, this.f15320r);
        goto L14
    L13:
        char[] r27 = this.f15325w;
        r27[0] = r25;
        r13.drawText(r27, 0, 1, r26, this.f15328z + this.f15324v, this.f15320r);
    L14:
        r11 = r12;
        goto L4
    L16:
        if (p() == false) goto L23;
        int r28 = h.k(this.f15305c, 0, this.f15303a - 1);
        float r29 = this.f15326x;
        float r30 = this.f15306d;
        float r31 = r29 + (r28 * (this.A + r30));
        float r32 = (r31 + (r30 + r31)) / 2.0f;
        float r33 = this.f15307e * 0.375f;
        float r34 = this.f15328z;
        float r35 = r33 / 2.0f;
        float r36 = r34 - r35;
        float r37 = r34 + r35;
        float r38 = this.C;
        r13.drawRect(r32 - r38, r36, r32 + r38, r37, this.f15321s);
        return;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r10, int r11, Rect r12) {
        super.onFocusChanged(r10, r11, r12);
        if (r10 == true) goto L5;
        s();
        j();
    L9:
        invalidate();
        return;
    L5:
        if (this.f15317o == false) goto L7;
        r();
    L7:
        q();
        goto L9
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        q.g(r11, "event");
        if (r10 != 67) goto L8;
        if (i() == false) goto L8;
        return true;
    L8:
        if (r10 < 7) goto L14;
        if (r10 > 16) goto L14;
        f(String.valueOf((char) (r10 + 41)));
        return true;
    L14:
        if (r10 < 144) goto L20;
        if (r10 > 153) goto L20;
        f(String.valueOf((char) (r10 - 96)));
        return true;
    L20:
        return super.onKeyDown(r10, r11);
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = ((r13 - r11) - getPaddingLeft()) - getPaddingRight();
        int r16 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        float r17 = this.f15308f;
        float r18 = this.f15306d;
        int r19 = this.f15303a;
        float r20 = r15;
        if (((r19 * r18) + ((r19 - 1) * r17)) <= r20) goto L8;
        if (r19 <= 1) goto L8;
        r17 = (r20 - (r19 * r18)) / (r19 - 1);
        if (r17 >= 0.0f) goto L8;
        r17 = 0.0f;
    L8:
        this.A = r17;
        this.f15326x = getPaddingLeft() + ((r20 - ((r18 * r19) + (r17 * (r19 - 1)))) / 2.0f);
        float r21 = getPaddingTop();
        float r22 = this.f15307e;
        float r23 = r21 + ((r16 - r22) / 2.0f);
        this.f15327y = r23;
        this.f15328z = r23 + (r22 / 2.0f);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        float r12 = this.f15306d;
        int r13 = this.f15303a;
        setMeasuredDimension(View.resolveSize((int) ((getPaddingLeft() + getPaddingRight()) + ((r12 * r13) + (this.f15308f * (r13 - 1)))), r10), View.resolveSize((int) ((getPaddingTop() + getPaddingBottom()) + this.f15307e), r11));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        int r11 = r10.getAction();
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
        performClick();
        return true;
    L6:
        return super.onTouchEvent(r10);
    L9:
        requestFocus();
        q();
        return true;
    }

    public final boolean p() {
        if (isFocused() == true) goto L5;
    L15:
        return false;
    L5:
        if (this.f15317o == false) goto L15;
        if (this.D == true) goto L11;
        return false;
    L11:
        if (this.f15305c < this.f15303a) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public final void q() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r11 = (InputMethodManager) r10;
    L6:
        if (r11 == null) goto L10;
        r11.showSoftInput(this, 1);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void r() {
        if (this.E == false) goto L5;
        return;
    L5:
        this.E = true;
        this.D = true;
        removeCallbacks(this.F);
        postDelayed(this.F, 500);
    }

    public final void s() {
        this.E = false;
        removeCallbacks(this.F);
    }

    public final void setCellBackgroundColor(@ColorInt int r10) {
        if (this.f15311i != r10) goto L5;
        return;
    L5:
        this.f15311i = r10;
        invalidate();
    }

    public final void setCellCornerRadius(float r10) {
        if (this.f15309g != r10) goto L5;
        return;
    L5:
        this.f15309g = r10;
        invalidate();
    }

    public final void setCellSpacing(float r10) {
        if (this.f15308f != r10) goto L5;
        return;
    L5:
        this.f15308f = r10;
        requestLayout();
    }

    public final void setCellStrokeColor(@ColorInt int r10) {
        if (this.f15312j != r10) goto L5;
        return;
    L5:
        this.f15312j = r10;
        invalidate();
    }

    public final void setCellStrokeWidth(float r10) {
        if (this.f15310h != r10) goto L5;
        return;
    L5:
        this.f15310h = r10;
        this.f15319q.setStrokeWidth(r10);
        invalidate();
    }

    public final void setCode(@Nullable String r10) {
        e(true);
        if (r10 != null) goto L5;
    L21:
        invalidate();
        return;
    L5:
        if (r10.length() == 0) goto L21;
        int r11 = 0;
        int r12 = 0;
    L9:
        if (r11 >= r10.length()) goto L17;
        char r13 = r10.charAt(r11);
        r11 = r11 + 1;
        if (Character.isDigit(r13) == false) goto L9;
        if (r12 >= this.f15303a) goto L17;
        this.f15304b[r12] = r13;
        r12 = r12 + 1;
    L17:
        this.f15305c = r12;
        l();
        invalidate();
        if (k() == false) goto L29;
        m();
        return;
    }

    public final void setCodeLength(int r10) {
        int r11 = h.k(r10, 1, 6);
        if (r11 != this.f15303a) goto L5;
        return;
    L5:
        this.f15303a = r11;
        char[] r12 = this.f15304b;
        this.f15304b = new char[r11];
        int r13 = Math.min(r12.length, r11);
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L8;
        this.f15304b[r14] = r12[r14];
        r14 = r14 + 1;
        goto L6
    L8:
        this.f15305c = h();
        requestLayout();
        invalidate();
    }

    public final void setCursorColor(@ColorInt int r10) {
        if (this.f15315m != r10) goto L5;
        return;
    L5:
        this.f15315m = r10;
        this.f15321s.setColor(r10);
        invalidate();
    }

    public final void setCursorVisible(boolean r10) {
        if (this.f15317o != r10) goto L5;
        return;
    L5:
        this.f15317o = r10;
        if (r10 == true) goto L9;
        s();
    L11:
        invalidate();
        return;
    L9:
        if (hasFocus() == false) goto L11;
        r();
        goto L11
    }

    public final void setOnCodeChangeListener(@Nullable OnCodeChangeListener r10) {
        this.H = r10;
    }

    public final void setOnCodeCompleteListener(@Nullable OnCodeCompleteListener r10) {
        this.G = r10;
    }

    public final void setPasswordMode(boolean r10) {
        if (this.f15316n != r10) goto L5;
        return;
    L5:
        this.f15316n = r10;
        invalidate();
        o();
    }

    public final void setTextColor(@ColorInt int r10) {
        if (this.f15313k != r10) goto L5;
        return;
    L5:
        this.f15313k = r10;
        this.f15320r.setColor(r10);
        invalidate();
    }

    public final void setTextSizeSp(float r10) {
        float r11 = f.v(this, r10);
        if (this.f15314l != r11) goto L5;
        return;
    L5:
        this.f15314l = r11;
        this.f15320r.setTextSize(r11);
        t();
        invalidate();
    }

    public final void t() {
        this.f15320r.getFontMetrics(this.f15323u);
        Paint.FontMetrics r10 = this.f15323u;
        this.f15324v = -((r10.ascent + r10.descent) / 2.0f);
    }

    @JvmOverloads
    public OOtpInputView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OOtpInputView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OOtpInputView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f15303a = 6;
        this.f15304b = new char[6];
        Paint r13 = new Paint(1);
        this.f15318p = r13;
        Paint r14 = new Paint(1);
        this.f15319q = r14;
        Paint r15 = new Paint(1);
        this.f15320r = r15;
        Paint r16 = new Paint(1);
        this.f15321s = r16;
        this.f15322t = new RectF();
        this.f15323u = new Paint.FontMetrics();
        this.f15325w = new char[1];
        this.D = true;
        this.F = new c(this);
        n();
        this.f15306d = f.t(this, 42.0f);
        this.f15307e = f.t(this, 48.0f);
        this.f15308f = f.t(this, 12.0f);
        this.f15309g = f.t(this, 10.0f);
        this.f15310h = f.t(this, 1.0f);
        this.f15314l = f.v(this, 20.0f);
        int r17 = R$color.oui_advanced_fill_list_item_card;
        this.f15311i = ContextCompat.b(r10, r17);
        this.f15312j = ContextCompat.b(r10, r17);
        this.f15313k = ContextCompat.b(r10, R$color.oui_basic_text_1);
        this.f15315m = ContextCompat.b(r10, R$color.oui_functional_blue_6);
        this.f15316n = false;
        this.f15317o = true;
        if (r11 == null) goto L10;
        TypedArray r18 = r10.obtainStyledAttributes(r11, R$styleable.OOtpInputView, r12, 0);
        q.f(r18, "context.obtainStyledAttr…putView, defStyleAttr, 0)");
        d(r18.getInt(R$styleable.OOtpInputView_o_otpCodeLength, 6));     // Catch: Throwable -> L7
        this.f15306d = r18.getDimension(R$styleable.OOtpInputView_o_otpCellWidth, this.f15306d);     // Catch: Throwable -> L7
        this.f15307e = r18.getDimension(R$styleable.OOtpInputView_o_otpCellHeight, this.f15307e);     // Catch: Throwable -> L7
        this.f15308f = r18.getDimension(R$styleable.OOtpInputView_o_otpCellSpacing, this.f15308f);     // Catch: Throwable -> L7
        this.f15309g = r18.getDimension(R$styleable.OOtpInputView_o_otpCellCornerRadius, this.f15309g);     // Catch: Throwable -> L7
        this.f15310h = r18.getDimension(R$styleable.OOtpInputView_o_otpCellStrokeWidth, this.f15310h);     // Catch: Throwable -> L7
        this.f15311i = r18.getColor(R$styleable.OOtpInputView_o_otpCellBackgroundColor, this.f15311i);     // Catch: Throwable -> L7
        this.f15312j = r18.getColor(R$styleable.OOtpInputView_o_otpCellStrokeColor, this.f15312j);     // Catch: Throwable -> L7
        this.f15313k = r18.getColor(R$styleable.OOtpInputView_o_otpTextColor, this.f15313k);     // Catch: Throwable -> L7
        this.f15314l = r18.getDimension(R$styleable.OOtpInputView_o_otpTextSize, this.f15314l);     // Catch: Throwable -> L7
        this.f15315m = r18.getColor(R$styleable.OOtpInputView_o_otpCursorColor, this.f15315m);     // Catch: Throwable -> L7
        this.f15316n = r18.getBoolean(R$styleable.OOtpInputView_o_otpPasswordMode, this.f15316n);     // Catch: Throwable -> L7
        this.f15317o = r18.getBoolean(R$styleable.OOtpInputView_o_otpCursorVisible, this.f15317o);     // Catch: Throwable -> L7
        r18.recycle();
    L7:
        th = move-exception;
        r18.recycle();
        throw th;
    L10:
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        Paint.Style r19 = Paint.Style.FILL;
        r13.setStyle(r19);
        r14.setStyle(Paint.Style.STROKE);
        r14.setStrokeWidth(this.f15310h);
        r15.setColor(this.f15313k);
        r15.setTextSize(this.f15314l);
        r15.setTextAlign(Paint.Align.CENTER);
        r15.setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        r16.setColor(this.f15315m);
        r16.setStyle(r19);
        t();
    }
}
