package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.obric.capabilitykit.common.UiType;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OTextView;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0003g\u009d\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u000eJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u000eJ\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\u000eJ\u0017\u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u0015J\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001eH\u0016¢\u0006\u0004\b*\u0010(J\u0015\u0010+\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u0015J\r\u0010,\u001a\u00020\u0006¢\u0006\u0004\b,\u0010%J\u0017\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010\u0015J\u0017\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0015J\u000f\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001eH\u0016¢\u0006\u0004\b5\u0010(J\u0017\u00108\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u0004\u0018\u000106¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001e¢\u0006\u0004\b<\u0010(J\u0017\u0010>\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u000106¢\u0006\u0004\b>\u00109J\u0011\u0010?\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b?\u0010;J\u0019\u0010@\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b@\u0010AJ\u0019\u0010D\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u000106¢\u0006\u0004\bG\u00109J\u000f\u0010H\u001a\u0004\u0018\u000106¢\u0006\u0004\bH\u0010;J\u0015\u0010I\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\bI\u0010\u0015J\r\u0010J\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010%J\u0017\u0010L\u001a\u00020\n2\b\u0010K\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bN\u0010OJ\u0015\u0010P\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0006¢\u0006\u0004\bP\u0010\u0015J\u000f\u0010Q\u001a\u0004\u0018\u000101¢\u0006\u0004\bQ\u00103J\u0015\u0010R\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001e¢\u0006\u0004\bR\u0010(J\r\u0010S\u001a\u00020\u001e¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u000106¢\u0006\u0004\bV\u00109J\u000f\u0010W\u001a\u0004\u0018\u000106¢\u0006\u0004\bW\u0010;J\u0015\u0010X\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001e¢\u0006\u0004\bX\u0010(J\u0015\u0010[\u001a\u00020\n2\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\J\u0017\u0010^\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u0006H\u0016¢\u0006\u0004\b^\u0010\u0015J\r\u0010_\u001a\u00020\u0006¢\u0006\u0004\b_\u0010%J\u0015\u0010`\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001e¢\u0006\u0004\b`\u0010(J\r\u0010a\u001a\u00020\n¢\u0006\u0004\ba\u0010\u000eJ\u0015\u0010c\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u001e¢\u0006\u0004\bc\u0010(J\u0015\u0010e\u001a\u00020\n2\u0006\u0010d\u001a\u00020\u001e¢\u0006\u0004\be\u0010(J\r\u0010f\u001a\u00020\n¢\u0006\u0004\bf\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010\rR\u0016\u0010i\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010\rR\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010\rR\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010\rR\u0018\u0010p\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010v\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010sR\u0014\u0010y\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010{\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010xR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001d\u0010\u0085\u0001\u001a\u00030\u0080\u00018\u0006¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bD\u0010\u0086\u0001R\u0017\u0010\u0088\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010\rR\u0017\u0010\u008b\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b@\u0010\u008a\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010\u008c\u0001R\u0017\u0010\u008e\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0010\u0010\u008a\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bS\u0010\u008c\u0001R\u0015\u0010\u0090\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010xR\u0016\u0010\u0092\u0001\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0091\u0001R\u0015\u0010\u0093\u0001\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010~R\u0015\u0010\u0094\u0001\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010~R\u0015\u0010\u0095\u0001\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010~R\u0017\u0010\u0096\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010\rR\u0018\u0010\u0097\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b'\u0010\u008c\u0001R\u0018\u0010\u0098\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b<\u0010\u008c\u0001R\u0018\u0010\u0099\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b`\u0010\u008c\u0001R\u0018\u0010\u009a\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010\u008c\u0001R\u0019\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bX\u0010\u009b\u0001R\u0018\u0010\u009c\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u008c\u0001¨\u0006\u009e\u0001"}, d2 = {"Lcom/obric/oui/forms/OInputLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "s", "(Landroid/util/AttributeSet;I)V", "I", "()V", "u", "p", "A", "o", "lines", "H", "(I)V", "F", CommonKey.KEY_VALUE, "Landroid/text/TextUtils$TruncateAt;", "t", "(I)Landroid/text/TextUtils$TruncateAt;", "C", "D", "type", "", "r", "(I)Z", "E", "J", "setType", "getType", "()I", "showBg", FixCard.FixStyle.KEY_X, "(Z)V", "enabled", "setEnabled", "setInputType", "getInputType", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "Landroid/view/View;", "getCustomStart", "()Landroid/view/View;", "show", "w", "", ServerElements.LABEL, "setLabel", "(Ljava/lang/CharSequence;)V", "getLabel", "()Ljava/lang/CharSequence;", FixCard.FixStyle.KEY_Y, "text", "setText", "getText", "n", "(Ljava/lang/CharSequence;)I", "Landroid/text/Editable;", "editable", "l", "(Landroid/text/Editable;)V", "hint", "setHint", "getHint", "setMaxLines", "getMaxLines", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "setCustomEnd", "getCustomEnd", "v", "q", "()Z", "tip", "setTip", "getTip", "B", "Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;", "limitStateChangeListener", "setLimitStateChangeListener", "(Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;)V", "count", "setLimitCount", "getLimitCount", "z", "G", "auto", "setAutoChangeWithLimit", "isError", "setTextState", "m", "a", "b", "customMinHeight", "c", "customMaxHeight", "d", "customMaxLines", "e", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "vInputContainer", "g", "vEditContainer", "h", "Landroid/widget/FrameLayout;", "vHelperContainer", "i", "vCustomStart", "Lcom/obric/oui/text/OTextView;", "j", "Lcom/obric/oui/text/OTextView;", "vLabel", "Lcom/obric/oui/forms/OEditText;", "k", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", "Ljava/lang/CharSequence;", "digits", "inputType", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "vClear", "Z", "showClear", "vEyes", "showEyes", "vCustomEnd", "Landroid/view/View;", "vDivider", "vTip", "vLimitSingle", "vLimitMulti", "limitCount", "showLimit", "autoChangeWithLimit", "isInAutoChanging", "overLimit", "Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;", "isErrorState", "LimitStateChangeObserver", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OInputLayout extends FrameLayout {
    public static final a D = null;
    public boolean A;
    public LimitStateChangeObserver B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextUtils.TruncateAt f14658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f14659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f14660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f14661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f14662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTextView f14663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OEditText f14664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f14665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f14667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f14669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14670q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FrameLayout f14671r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f14672s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OTextView f14673t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OTextView f14674u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OTextView f14675v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14676w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14677x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14678y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f14679z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;", "", "onLimitStateChange", "", "over", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LimitStateChangeObserver {
        void onLimitStateChange(boolean r10);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OInputLayout f14680a;

        public b(OInputLayout r10) {
            this.f14680a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            q.g(r10, "view");
            q.g(r11, "outline");
            r11.setRoundRect(0, 0, r10.getWidth(), r10.getHeight(), tc.f.r(this.f14680a, 16));
        }
    }

    static {
        D = new a(null);
    }

    @JvmOverloads
    public OInputLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OInputLayout r10, View r11) {
        d(r10, r11);
    }

    public static /* synthetic */ void b(OInputLayout r10, View r11) {
        f(r10, r11);
    }

    public static /* synthetic */ void c(OInputLayout r10, View r11) {
        e(r10, r11);
    }

    public static final void d(OInputLayout r10, View r11) {
        q.g(r10, "this$0");
        r10.setText("");
        r10.C();
    }

    public static final void e(OInputLayout r10, View r11) {
        q.g(r10, "this$0");
        if ((r10.f14664k.getInputType() & 4080) != 144) goto L5;
        r10.f14669p.setImageResource(R$drawable.o_input_view_eyes_close);
        r10.F();
    L7:
        if (r10.f14664k.hasFocus() == false) goto L14;
        OEditText r12 = r10.f14664k;
        Editable r13 = r12.getText();
        if (r13 != null) goto L11;
        int r14 = 0;
    L12:
        r12.setSelection(r14);
        return;
    L11:
        r14 = r13.length();
        goto L12
    L14:
        return;
    L5:
        r10.f14669p.setImageResource(R$drawable.o_input_view_eyes_open);
        int r15 = r10.f14664k.getInputType() & (-4081);
        r10.f14664k.setInputType(r15 | SearchChipsView.BROWN);
        goto L7
    }

    public static final void f(OInputLayout r10, View r11) {
        q.g(r10, "this$0");
        r10.f14664k.requestFocus();
        if (r10.f14664k.hasFocus() == false) goto L8;
        if (r10.f14664k.isCursorVisible() == true) goto L8;
        r10.f14664k.setCursorVisible(true);
    L8:
        if (r10.f14664k.hasFocus() == false) goto L14;
        Editable r12 = r10.f14664k.getText();
        if (r12 != null) goto L12;
        int r13 = 0;
    L13:
        r10.f14664k.setSelection(r13);
        goto L14
    L12:
        r13 = r12.length();
    L14:
        r10.A();
    }

    public static final /* synthetic */ void g(OInputLayout r10) {
        r10.o();
    }

    public static final /* synthetic */ boolean h(OInputLayout r10) {
        return r10.f14679z;
    }

    public static final /* synthetic */ void i(OInputLayout r10) {
        r10.A();
    }

    public static final /* synthetic */ void j(OInputLayout r10) {
        r10.C();
    }

    public static final /* synthetic */ void k(OInputLayout r10) {
        r10.D();
    }

    public final void A() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r11 = (InputMethodManager) r10;
    L6:
        if (r11 == null) goto L10;
        r11.showSoftInput(this.f14664k, 0);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void B(boolean r10) {
        CharSequence r11 = getTip();
        int r12 = 8;
        if (r11 != null) goto L5;
    L11:
        this.f14673t.setVisibility(8);
    L12:
        E();
        return;
    L5:
        if (r11.length() == 0) goto L11;
        OTextView r13 = this.f14673t;
        if (r10 == false) goto L10;
        r12 = 0;
    L10:
        r13.setVisibility(r12);
        goto L12
    }

    public final void C() {
        ImageView r10 = this.f14667n;
        if (this.f14654a == 0) goto L5;
    L12:
        int r11 = 8;
    L13:
        r10.setVisibility(r11);
        return;
    L5:
        if (this.f14668o == false) goto L12;
        Editable r12 = this.f14664k.getText();
        if (r12 == null) goto L12;
        if (r12.length() == 0) goto L12;
        r11 = 0;
        goto L13
    }

    public final void D() {
        ImageView r10 = this.f14669p;
        if (this.f14654a == 0) goto L5;
    L14:
        int r11 = 8;
    L15:
        r10.setVisibility(r11);
        return;
    L5:
        if (this.f14670q == false) goto L14;
        if (q() == false) goto L14;
        Editable r12 = this.f14664k.getText();
        if (r12 == null) goto L14;
        if (r12.length() == 0) goto L14;
        r11 = 0;
        goto L15
    }

    public final void E() {
        FrameLayout r10 = this.f14661h;
        if (this.f14673t.getVisibility() != 0) goto L6;
    L7:
        int r11 = 0;
    L9:
        r10.setVisibility(r11);
        return;
    L6:
        if (this.f14675v.getVisibility() == 0) goto L7;
        r11 = 8;
        goto L9
    }

    public final void F() {
        boolean r10 = true;
        if (getMaxLines() != 1) goto L6;
        r10 = false;
    L6:
        int r11 = this.f14666m;
        if (r10 == true) goto L9;
    L11:
        int r12 = r11 ^ UiType.FLAG_PHONE_CARD;
    L12:
        this.f14664k.setInputType(r12);
        this.f14664k.invalidate();
        return;
    L9:
        if (r(r11) == true) goto L11;
        r12 = r11 | UiType.FLAG_PHONE_CARD;
        goto L12
    }

    public final void G() {
        if (this.f14676w <= 0) goto L5;
        OTextView r10 = this.f14674u;
        StringBuilder r11 = new StringBuilder();
        Editable r12 = this.f14664k.getText();
        q.d(r12);
        r11.append(n(r12));
        r11.append('/');
        r11.append(this.f14676w);
        r10.setText(r11.toString());
        OTextView r13 = this.f14675v;
        StringBuilder r14 = new StringBuilder();
        Editable r15 = this.f14664k.getText();
        q.d(r15);
        r14.append(n(r15));
        r14.append('/');
        r14.append(this.f14676w);
        r13.setText(r14.toString());
    L5:
        OTextView r16 = this.f14674u;
        int r17 = 8;
        boolean r18 = false;
        if (this.f14654a == 0) goto L8;
    L10:
        int r19 = 8;
    L11:
        r16.setVisibility(r19);
        OTextView r20 = this.f14675v;
        if (this.f14654a == 1) goto L14;
    L16:
        r20.setVisibility(r17);
        if (this.f14676w <= 0) goto L26;
        Editable r21 = this.f14664k.getText();
        if (r21 == null) goto L26;
        if (r21.length() == 0) goto L26;
        Editable r22 = this.f14664k.getText();
        q.d(r22);
        if (n(r22) <= this.f14676w) goto L26;
        r18 = true;
    L26:
        boolean r23 = this.A;
        if (r18 == r23) goto L33;
        this.A = r18;
        LimitStateChangeObserver r24 = this.B;
        if (r24 == null) goto L32;
        r24.onLimitStateChange(r18);
    L32:
        J();
        return;
    L33:
        if (r23 == false) goto L37;
        J();
        return;
    L37:
        return;
    L14:
        if (this.f14677x == false) goto L16;
        r17 = 0;
        goto L16
    L8:
        if (this.f14677x == false) goto L10;
        r19 = 0;
        goto L11
    }

    public final void H(int r10) {
        OEditText r11 = this.f14664k;
        boolean r12 = true;
        if (r10 == 1) goto L6;
        r12 = false;
    L6:
        r11.setSingleLine(r12);
        this.f14664k.setMaxLines(r10);
        F();
    }

    public final void I() {
        if (this.f14654a == 0) goto L5;
        LinearLayout r10 = this.f14659f;
        int r11 = tc.f.r(this, 12);
        int r12 = tc.f.r(this, 8);
        if (this.f14661h.getVisibility() != 0) goto L12;
        int r13 = tc.f.r(this, 0);
    L13:
        r10.setPadding(r11, r12, 0, r13);
        this.f14663j.setPadding(0, 0, tc.f.r(this, 12), 0);
        this.f14664k.setPadding(0, 0, tc.f.r(this, 12), 0);
        this.f14664k.setScrollBarStyle(33554432);
        this.f14661h.setPadding(tc.f.r(this, 12), tc.f.r(this, 6), tc.f.r(this, 12), tc.f.r(this, 8));
        return;
    L12:
        r13 = tc.f.r(this, 8);
        goto L13
    L5:
        if (this.f14663j.getVisibility() != 0) goto L7;
        int r14 = tc.f.p(this, 8.5d);
    L8:
        this.f14659f.setPadding(tc.f.r(this, 12), r14, tc.f.r(this, 8), r14);
        this.f14663j.setPadding(0, 0, 0, 0);
        this.f14664k.setPadding(0, 0, 0, 0);
        this.f14664k.setScrollBarStyle(0);
        int r15 = tc.f.r(this, 5);
        this.f14661h.setPadding(tc.f.r(this, 12), r15, tc.f.r(this, 8), r15);
        return;
    L7:
        r14 = tc.f.r(this, 13);
        goto L8
    }

    public final void J() {
        if (this.A == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        setTextState(r10);
        return;
    L5:
        if (this.f14678y == false) goto L7;
        r10 = true;
        goto L8
    }

    @Nullable
    public final View getCustomEnd() {
        if (this.f14671r.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f14671r.getChildAt(0);
    }

    @Nullable
    public final View getCustomStart() {
        if (this.f14662i.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f14662i.getChildAt(0);
    }

    @Nullable
    public final TextUtils.TruncateAt getEllipsize() {
        return this.f14664k.getEllipsize();
    }

    @Nullable
    public final CharSequence getHint() {
        return this.f14664k.getHint();
    }

    public final int getInputType() {
        return this.f14666m;
    }

    @Nullable
    public final CharSequence getLabel() {
        return this.f14663j.getText();
    }

    public final int getLimitCount() {
        return this.f14676w;
    }

    public final int getMaxLines() {
        return this.f14664k.getMaxLines();
    }

    @Nullable
    public CharSequence getText() {
        return this.f14664k.getText();
    }

    @Nullable
    public final CharSequence getTip() {
        return this.f14673t.getText();
    }

    public final int getType() {
        return this.f14654a;
    }

    @NotNull
    public final OEditText getVInput() {
        return this.f14664k;
    }

    public void l(Editable r10) {
    }

    public final void m() {
        Method r10 = TextView.class.getDeclaredMethod("enableUpdateCursorDrawable", null);     // Catch: Exception -> L4
        q.f(r10, "TextView::class.java.get…orDrawable\"\n            )");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        r10.invoke(this.f14664k, null);     // Catch: Exception -> L4
        return;
    }

    public int n(CharSequence r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.length();
    }

    public final void o() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r11 = (InputMethodManager) r10;
    L6:
        if (r11 == null) goto L10;
        r11.hideSoftInputFromWindow(this.f14664k.getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void p() {
        m();
        CharSequence r10 = this.f14665l;
        if (r10 == null) goto L9;
        this.f14664k.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r10)));
        int r11 = this.f14666m;
        if (r11 != 0) goto L8;
        r11 = 1;
    L8:
        this.f14666m = r11;
    L9:
        int r12 = this.f14666m;
        if (r12 == 0) goto L12;
        setInputType(r12);
    L12:
        this.f14664k.d(new OInputLayout$initInput$1(this));
        this.f14664k.f(new OInputLayout$initInput$2(this));
        this.f14664k.a(new OInputLayout$initInput$3(this));
    }

    public final boolean q() {
        return r(this.f14666m);
    }

    public final boolean r(int r10) {
        int r11 = r10 & 4095;
        if (r11 != 129) goto L5;
        boolean r12 = true;
    L7:
        if (r11 != 225) goto L9;
        boolean r13 = true;
    L11:
        if (r11 != 18) goto L13;
        boolean r14 = true;
    L14:
        if (r12 == true) goto L18;
        if (r13 == true) goto L18;
        if (r14 == true) goto L18;
        return false;
    L18:
        return true;
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L11
    L5:
        r12 = false;
        goto L7
    }

    public final void s(AttributeSet r10, int r11) {
        TypedArray r12 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OInputLayout, r11, 0);
        setType(r12.getInt(R$styleable.OInputLayout_oinput_type, 0));
        x(r12.getBoolean(R$styleable.OInputLayout_oinput_showInputBackground, false));
        this.f14655b = r12.getDimensionPixelSize(R$styleable.OInputLayout_oinput_minHeight, -1);
        this.f14656c = r12.getDimensionPixelSize(R$styleable.OInputLayout_oinput_maxHeight, -1);
        setCustomStart(r12.getResourceId(R$styleable.OInputLayout_oinput_customStart, 0));
        w(r12.getBoolean(R$styleable.OInputLayout_oinput_showCustomStart, false));
        setLabel(r12.getString(R$styleable.OInputLayout_oinput_label));
        y(r12.getBoolean(R$styleable.OInputLayout_oinput_showLabel, false));
        setText(r12.getString(R$styleable.OInputLayout_oinput_text));
        setHint(r12.getString(R$styleable.OInputLayout_oinput_hint));
        this.f14665l = r12.getText(R$styleable.OInputLayout_android_digits);
        this.f14666m = r12.getInt(R$styleable.OInputLayout_android_inputType, this.f14666m);
        setMaxLines(r12.getInt(R$styleable.OInputLayout_android_maxLines, -1));
        int r13 = R$styleable.OInputLayout_android_ellipsize;
        if (r12.hasValue(r13) == false) goto L5;
        setEllipsize(t(r12.getInt(r13, 0)));
    L5:
        setCustomEnd(r12.getResourceId(R$styleable.OInputLayout_oinput_customEnd, 0));
        v(r12.getBoolean(R$styleable.OInputLayout_oinput_showCustomEnd, false));
        this.f14668o = r12.getBoolean(R$styleable.OInputLayout_oinput_showClear, false);
        this.f14670q = r12.getBoolean(R$styleable.OInputLayout_oinput_showEyes, false);
        setTip(r12.getString(R$styleable.OInputLayout_oinput_tip));
        B(r12.getBoolean(R$styleable.OInputLayout_oinput_showTip, false));
        setLimitCount(r12.getInt(R$styleable.OInputLayout_oinput_limitCount, -1));
        z(r12.getBoolean(R$styleable.OInputLayout_oinput_showLimit, false));
        setAutoChangeWithLimit(r12.getBoolean(R$styleable.OInputLayout_oinput_autoChangeWithLimit, false));
    }

    public final void setAutoChangeWithLimit(boolean r10) {
        this.f14678y = r10;
        J();
    }

    public final void setCustomEnd(int r10) {
        this.f14671r.removeAllViews();
        if (r10 == 0) goto L9;
        FrameLayout.inflate(getContext(), r10, this.f14671r);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setCustomStart(int r10) {
        this.f14662i.removeAllViews();
        if (r10 == 0) goto L9;
        FrameLayout.inflate(getContext(), r10, this.f14662i);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setDefaultCustomStart(int r10) {
        this.f14662i.removeAllViews();
        if (r10 != 0) goto L5;
        setCustomStart(R$layout.o_input_custom_start_area_code);
        return;
    L5:
        w(false);
    }

    public final void setEllipsize(@Nullable TextUtils.TruncateAt r10) {
        this.f14658e = r10;
        this.f14664k.setEllipsize(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator r11 = ViewGroupKt.a(this).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((View) r11.next()).setEnabled(r10);
        goto L4
    L6:
        this.f14664k.setEnabled(r10);
    }

    public final void setHint(@Nullable CharSequence r10) {
        this.f14664k.setHint(r10);
    }

    public final void setInputType(int r10) {
        if ((r10 & 1) != 0) goto L12;
        if ((r10 & 2) != 0) goto L12;
        if ((r10 & 3) != 0) goto L12;
        if ((r10 & 4) != 0) goto L12;
        r10 = r10 | 1;
    L12:
        if (this.f14666m == r10) goto L14;
        this.f14666m = r10;
    L14:
        F();
        D();
        l(this.f14664k.getText());
    }

    public final void setLabel(@Nullable CharSequence r10) {
        this.f14663j.setText(r10);
    }

    public void setLimitCount(int r10) {
        if (this.f14676w != r10) goto L5;
        return;
    L5:
        this.f14676w = r10;
        G();
        l(this.f14664k.getText());
    }

    public final void setLimitStateChangeListener(@NotNull LimitStateChangeObserver r10) {
        q.g(r10, "limitStateChangeListener");
        this.B = r10;
    }

    public final void setMaxLines(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f14657d = r10;
        H(r10);
    }

    public final void setText(@Nullable CharSequence r10) {
        this.f14664k.setText(r10);
        l(this.f14664k.getText());
    }

    public final void setTextState(boolean r12) {
        if (this.f14679z == false) goto L5;
        return;
    L5:
        this.f14679z = true;
        int r10 = this.f14664k.getSelectionStart();
        int r11 = this.f14664k.getSelectionEnd();
        Editable r13 = this.f14664k.getText();
        if (r13 == null) goto L41;
        int r14 = r13.length();     // Catch: Exception -> L10
        if (r12 == false) goto L12;
        int r15 = ContextCompat.b(getContext(), R$color.oui_functional_red_2);     // Catch: Exception -> L10
    L13:
        ErrorBackgroundSpan[] r16 = (ErrorBackgroundSpan[]) r13.getSpans(0, r14, ErrorBackgroundSpan.class);     // Catch: Exception -> L10
        q.f(r16, "existingSpans");     // Catch: Exception -> L10
        int r17 = r16.length;     // Catch: Exception -> L10
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L19;
        ErrorBackgroundSpan r19 = r16[r18];     // Catch: Exception -> L10
        if (r19.getBackgroundColor() == r15) goto L20;
        r18 = r18 + 1;     // Catch: Exception -> L10
    L20:
        if (r19 != null) goto L22;
        r19 = new ErrorBackgroundSpan(r15);     // Catch: Exception -> L10
    L22:
        int r20 = r16.length;     // Catch: Exception -> L10
        int r21 = 0;
    L23:
        if (r21 >= r20) goto L25;
        r13.removeSpan(r16[r21]);     // Catch: Exception -> L10
        r21 = r21 + 1;     // Catch: Exception -> L10
        goto L23
    L25:
        r13.setSpan(r19, 0, r14, 33);     // Catch: Exception -> L10
        p[] r22 = (p[]) r13.getSpans(0, r14, p.class);     // Catch: Exception -> L10
        q.f(r22, "existingPasswordTransSpans");     // Catch: Exception -> L10
        int r23 = r22.length;     // Catch: Exception -> L10
        int r24 = 0;
    L26:
        if (r24 >= r23) goto L32;
        p r25 = r22[r24];     // Catch: Exception -> L10
        if (r25 == null) goto L31;
        r25.c(r12);     // Catch: Exception -> L10
        r24 = r24 + 1;     // Catch: Exception -> L10
        goto L26
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.forms.OPasswordTransformationMethod");     // Catch: Exception -> L10
    L32:
        if (r10 < 0) goto L37;
        if (r10 > r14) goto L37;
        if (r11 < 0) goto L37;
        if (r11 > r14) goto L37;
        this.f14664k.setSelection(r10, r11);     // Catch: Exception -> L10
    L37:
        this.f14664k.setSelection(r10, r14);     // Catch: Exception -> L10
        goto L41
    L19:
        r19 = null;
        goto L20
    L12:
        r15 = 0;
    L10:
        e = move-exception;
        Log.e("OInputLayout", q.p("Error setTextState: ", e));
    L41:
        if (this.C == r12) goto L47;
        this.C = r12;
        OEditText r26 = this.f14664k;
        if (r12 == false) goto L45;
        int r27 = R$drawable.o_input_cursor_red;
    L46:
        r26.setTextCursorDrawable(r27);
        goto L47
    L45:
        r27 = R$drawable.o_input_cursor_blue;
    L47:
        OTextView r28 = this.f14673t;
        Resources r29 = getResources();
        if (r12 == false) goto L50;
        int r30 = R$color.oui_functional_red_6;
    L51:
        r28.setTextColor(r29.getColor(r30));
        OTextView r31 = this.f14674u;
        Resources r32 = getResources();
        if (r12 == false) goto L54;
        int r33 = R$color.oui_functional_red_6;
    L55:
        r31.setTextColor(r32.getColor(r33));
        OTextView r34 = this.f14675v;
        Resources r35 = getResources();
        if (r12 == false) goto L58;
        int r110 = R$color.oui_functional_red_6;
    L59:
        r34.setTextColor(r35.getColor(r110));
        this.f14679z = false;
        return;
    L58:
        r110 = R$color.oui_basic_text_3b;
        goto L59
    L54:
        r33 = R$color.oui_basic_text_3b;
        goto L55
    L50:
        r30 = R$color.oui_basic_text_3b;
        goto L51
    }

    public final void setTip(@Nullable CharSequence r10) {
        this.f14673t.setText(r10);
    }

    public void setType(int r10) {
        int r11 = 1;
        if (r10 == 0) goto L6;
        if (r10 == 1) goto L6;
        return;
    L6:
        this.f14654a = r10;
        OEditText r12 = this.f14664k;
        int r13 = this.f14655b;
        if (r13 != (-1)) goto L12;
        if (r10 != 0) goto L11;
        r13 = (int) tc.f.v(this, 22.0f);
        goto L12
    L11:
        r13 = tc.f.r(this, 120);
    L12:
        r12.setMinimumHeight(r13);
        OEditText r14 = this.f14664k;
        int r15 = this.f14656c;
        if (r15 != (-1)) goto L19;
        if (r10 != 0) goto L18;
        int r16 = 66;
    L17:
        r15 = tc.f.r(this, r16);
        goto L19
    L18:
        r16 = 240;
    L19:
        r14.setMaxHeight(r15);
        int r17 = this.f14657d;
        if (r17 == (-1)) goto L22;
        r11 = r17;
    L25:
        H(r11);
        I();
        G();
        C();
        D();
        return;
    L22:
        if (r10 == 0) goto L25;
        r11 = 12;
        goto L25
    }

    public final TextUtils.TruncateAt t(int r10) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    public final void u() {
        this.f14659f.setClipToOutline(true);
        this.f14659f.setOutlineProvider(new b(this));
        this.f14659f.invalidateOutline();
    }

    public final void v(boolean r10) {
        if (this.f14654a != 1) goto L5;
        return;
    L5:
        int r11 = 8;
        if (this.f14671r.getChildCount() == 0) goto L11;
        FrameLayout r12 = this.f14671r;
        if (r10 == false) goto L10;
        r11 = 0;
    L10:
        r12.setVisibility(r11);
        return;
    L11:
        this.f14671r.setVisibility(8);
    }

    public void w(boolean r10) {
        if (this.f14654a != 1) goto L5;
        return;
    L5:
        int r11 = 8;
        if (this.f14662i.getChildCount() == 0) goto L11;
        FrameLayout r12 = this.f14662i;
        if (r10 == false) goto L10;
        r11 = 0;
    L10:
        r12.setVisibility(r11);
        return;
    L11:
        this.f14662i.setVisibility(8);
    }

    public final void x(boolean r10) {
        LinearLayout r11 = this.f14659f;
        if (r10 == false) goto L5;
        int r12 = getResources().getColor(R$color.oui_fill_list_item_card);
    L6:
        r11.setBackgroundColor(r12);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public final void y(boolean r10) {
        CharSequence r11 = getLabel();
        int r12 = 8;
        if (r11 != null) goto L5;
    L11:
        this.f14663j.setVisibility(8);
    L12:
        I();
        return;
    L5:
        if (r11.length() == 0) goto L11;
        OTextView r13 = this.f14663j;
        if (r10 == false) goto L10;
        r12 = 0;
    L10:
        r13.setVisibility(r12);
        goto L12
    }

    public final void z(boolean r10) {
        if (this.f14677x != r10) goto L5;
        return;
    L5:
        this.f14677x = r10;
        G();
        E();
    }

    @JvmOverloads
    public OInputLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OInputLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OInputLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f14655b = -1;
        this.f14656c = -1;
        this.f14657d = -1;
        this.f14666m = 131073;
        this.f14676w = -1;
        View r13 = LayoutInflater.from(r10).inflate(R$layout.o_input_view_layout, this, true);
        if (r13 == null) goto L20;
        FrameLayout r14 = (FrameLayout) r13;
        View r15 = findViewById(R$id.input_container);
        q.f(r15, "findViewById(R.id.input_container)");
        LinearLayout r16 = (LinearLayout) r15;
        this.f14659f = r16;
        View r17 = findViewById(R$id.edit_container);
        q.f(r17, "findViewById(R.id.edit_container)");
        this.f14660g = (LinearLayout) r17;
        View r18 = findViewById(R$id.helper_container);
        q.f(r18, "findViewById(R.id.helper_container)");
        this.f14661h = (FrameLayout) r18;
        View r19 = findViewById(R$id.custom_start_container);
        q.f(r19, "findViewById(R.id.custom_start_container)");
        this.f14662i = (FrameLayout) r19;
        View r20 = findViewById(R$id.label);
        q.f(r20, "findViewById(R.id.label)");
        this.f14663j = (OTextView) r20;
        View r21 = findViewById(R$id.input);
        q.f(r21, "findViewById(R.id.input)");
        OEditText r22 = (OEditText) r21;
        this.f14664k = r22;
        if (this.f14654a != 0) goto L7;
        int r23 = (int) tc.f.v(this, 22.0f);
    L8:
        r22.setMinimumHeight(r23);
        if (this.f14654a != 0) goto L12;
        int r24 = 66;
    L13:
        r22.setMaxHeight(tc.f.r(this, r24));
        View r25 = findViewById(R$id.custom_end_container);
        q.f(r25, "findViewById(R.id.custom_end_container)");
        this.f14671r = (FrameLayout) r25;
        View r26 = findViewById(R$id.input_divider);
        q.f(r26, "findViewById(R.id.input_divider)");
        this.f14672s = r26;
        View r27 = findViewById(R$id.clear);
        q.f(r27, "findViewById(R.id.clear)");
        ImageView r28 = (ImageView) r27;
        this.f14667n = r28;
        View r29 = findViewById(R$id.eyes);
        q.f(r29, "findViewById(R.id.eyes)");
        ImageView r30 = (ImageView) r29;
        this.f14669p = r30;
        View r31 = findViewById(R$id.tip);
        q.f(r31, "findViewById(R.id.tip)");
        this.f14673t = (OTextView) r31;
        View r32 = findViewById(R$id.limit_single);
        q.f(r32, "findViewById(R.id.limit_single)");
        this.f14674u = (OTextView) r32;
        View r33 = findViewById(R$id.limit_multi);
        q.f(r33, "findViewById(R.id.limit_multi)");
        this.f14675v = (OTextView) r33;
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
        r22.setFocusable(true);
        r22.setFocusableInTouchMode(true);
        if (r11 == null) goto L17;
        s(r11, r12);
    L17:
        p();
        r28.setOnClickListener(new d(this));
        r30.setOnClickListener(new e(this));
        r16.setOnClickListener(new f(this));
        u();
        return;
    L12:
        r24 = 240;
        goto L13
    L7:
        r23 = tc.f.r(this, 120);
        goto L8
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
}
