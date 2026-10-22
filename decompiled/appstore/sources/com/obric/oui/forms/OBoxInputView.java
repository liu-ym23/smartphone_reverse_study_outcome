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
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 ^2\u00020\u0001:\u0002_`B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010\u0011J\r\u0010 \u001a\u00020\r¢\u0006\u0004\b \u0010\u0011J\r\u0010!\u001a\u00020\r¢\u0006\u0004\b!\u0010\u0011J\r\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u0010<\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010?\u001a\u0002018\u0006¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u00105R\u0017\u0010B\u001a\u0002018\u0006¢\u0006\f\n\u0004\b@\u00103\u001a\u0004\bA\u00105R\u0017\u0010H\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010M\u001a\u00020I8\u0006¢\u0006\f\n\u0004\b\u0010\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010O\u001a\u00020I8\u0006¢\u0006\f\n\u0004\b\u0014\u0010J\u001a\u0004\bN\u0010LR\"\u0010S\u001a\u00020I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010RR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010TR\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010UR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010WR\u0016\u0010Y\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010,R\u0018\u0010[\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010ZR\u0014\u0010]\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\\\u0010,¨\u0006a"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView;", "Lcom/obric/oui/forms/AbsOForm;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "arrangeDirection", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroid/view/View;", "view", "", "setPrefixView", "(Landroid/view/View;)V", "k", "()V", "o", "m", "l", "Lcom/obric/oui/forms/OBoxInputView$b;", "config", "r", "(Lcom/obric/oui/forms/OBoxInputView$b;)V", "", "getText", "()Ljava/lang/String;", "text", "setText", "(Ljava/lang/String;)V", "q", "p", "n", "getConfig", "()Lcom/obric/oui/forms/OBoxInputView$b;", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "e", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Landroidx/appcompat/widget/AppCompatEditText;", "g", "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "editText", "h", "getTvErrorTips", "tvErrorTips", "i", "getTvCounter", "tvCounter", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "ivTitleIcon", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "inputContainer", "getPrefixContainer", "prefixContainer", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "titleContainer", "Ljava/lang/String;", "Lcom/obric/oui/forms/OBoxInputView$b;", "", "Z", "showTitleDefaultIcon", "textGravity", "Landroid/text/TextWatcher;", "counterTextWatcher", "s", "DEFAULT_MAX_LINES", "t", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBoxInputView extends AbsOForm {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f14587t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f14588u = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f14590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatEditText f14591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f14592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f14593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f14594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f14595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f14596l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f14597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f14598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f14599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextWatcher f14602r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f14603s;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f14607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f14608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f14609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TextWatcher f14610g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14611h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14612i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f14613j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Drawable f14614k;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f14615a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f14616b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f14617c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Integer f14618d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f14619e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public View f14620f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public TextWatcher f14621g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public int f14622h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f14623i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f14624j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public Drawable f14625k;

            public a(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110) {
                this.f14615a = r10;
                this.f14616b = r11;
                this.f14617c = r12;
                this.f14618d = r13;
                this.f14619e = r14;
                this.f14620f = r15;
                this.f14621g = r16;
                this.f14622h = r17;
                this.f14623i = r18;
                this.f14624j = r19;
                this.f14625k = r110;
            }

            public final b a() {
                boolean r10 = this.f14615a;
                String r11 = this.f14616b;
                boolean r12 = this.f14617c;
                String r13 = this.f14619e;
                Integer r14 = this.f14618d;
                TextWatcher r15 = this.f14621g;
                return new b(r10, r11, r12, r14, r13, this.f14620f, r15, this.f14622h, this.f14623i, this.f14624j, this.f14625k, null);
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L8;
                return false;
            L8:
                a r11 = (a) r10;
                if (this.f14615a == r11.f14615a) goto L12;
                return false;
            L12:
                if (q.b(this.f14616b, r11.f14616b) == true) goto L15;
                return false;
            L15:
                if (this.f14617c == r11.f14617c) goto L18;
                return false;
            L18:
                if (q.b(this.f14618d, r11.f14618d) == true) goto L21;
                return false;
            L21:
                if (q.b(this.f14619e, r11.f14619e) == true) goto L24;
                return false;
            L24:
                if (q.b(this.f14620f, r11.f14620f) == true) goto L27;
                return false;
            L27:
                if (q.b(this.f14621g, r11.f14621g) == true) goto L30;
                return false;
            L30:
                if (this.f14622h == r11.f14622h) goto L33;
                return false;
            L33:
                if (this.f14623i == r11.f14623i) goto L36;
                return false;
            L36:
                if (this.f14624j == r11.f14624j) goto L39;
                return false;
            L39:
                if (q.b(this.f14625k, r11.f14625k) == true) goto L41;
                return false;
            L41:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v28 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            public int hashCode() {
                boolean r10 = this.f14615a;
                ?? r11 = 1;
                ?? r12 = r10;
                if (r10 == false) goto L5;
                r12 = 1;
            L5:
                int r13 = r12 * 31;
                String r14 = this.f14616b;
                int r15 = 0;
                if (r14 != null) goto L8;
                int r16 = 0;
            L9:
                int r17 = (r13 + r16) * 31;
                boolean r18 = this.f14617c;
                ?? r19 = r18;
                if (r18 == false) goto L12;
                r19 = 1;
            L12:
                int r20 = (r17 + r19) * 31;
                Integer r21 = this.f14618d;
                if (r21 != null) goto L15;
                int r22 = 0;
            L16:
                int r23 = (r20 + r22) * 31;
                String r24 = this.f14619e;
                if (r24 != null) goto L19;
                int r25 = 0;
            L20:
                int r26 = (r23 + r25) * 31;
                View r27 = this.f14620f;
                if (r27 != null) goto L23;
                int r28 = 0;
            L24:
                int r29 = (r26 + r28) * 31;
                TextWatcher r30 = this.f14621g;
                if (r30 != null) goto L27;
                int r31 = 0;
            L28:
                int r32 = (((((r29 + r31) * 31) + Integer.hashCode(this.f14622h)) * 31) + Integer.hashCode(this.f14623i)) * 31;
                boolean r33 = this.f14624j;
                if (r33 == true) goto L32;
                r11 = r33;
            L32:
                int r34 = (r32 + r11) * 31;
                Drawable r35 = this.f14625k;
                if (r35 == null) goto L37;
                r15 = r35.hashCode();
            L37:
                return r34 + r15;
            L27:
                r31 = r30.hashCode();
                goto L28
            L23:
                r28 = r27.hashCode();
                goto L24
            L19:
                r25 = r24.hashCode();
                goto L20
            L15:
                r22 = r21.hashCode();
                goto L16
            L8:
                r16 = r14.hashCode();
                goto L9
            }

            public String toString() {
                return "Builder(showTitle=" + this.f14615a + ", title=" + this.f14616b + ", showCounter=" + this.f14617c + ", lengthLimit=" + this.f14618d + ", hintText=" + this.f14619e + ", prefixView=" + this.f14620f + ", textWatcher=" + this.f14621g + ", inputBoxHeight=" + this.f14622h + ", inputBoxMaxHeight=" + this.f14623i + ", autoAdjustHeight=" + this.f14624j + ", ivTitleIcon=" + this.f14625k + ')';
            }

            public /* synthetic */ a(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110, int r111, DefaultConstructorMarker r112) {
                if ((r111 & 1) == 0) goto L6;
                r10 = false;
            L6:
                if ((r111 & 2) == 0) goto L9;
                r11 = null;
            L9:
                if ((r111 & 4) == 0) goto L12;
                r12 = false;
            L12:
                if ((r111 & 8) == 0) goto L15;
                r13 = null;
            L15:
                if ((r111 & 16) == 0) goto L18;
                r14 = null;
            L18:
                if ((r111 & 32) == 0) goto L21;
                r15 = null;
            L21:
                if ((r111 & 64) == 0) goto L24;
                r16 = null;
            L24:
                if ((r111 & 128) == 0) goto L27;
                r17 = OBoxInputView.j();
            L27:
                if ((r111 & 256) == 0) goto L30;
                r18 = Channel.UNLIMITED;
            L30:
                if ((r111 & 512) == 0) goto L33;
                r19 = false;
            L33:
                if ((r111 & 1024) == 0) goto L35;
                r110 = null;
            L35:
                this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
            }
        }

        public /* synthetic */ b(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110, DefaultConstructorMarker r111) {
            this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
        }

        public final boolean a() {
            return this.f14613j;
        }

        public final String b() {
            return this.f14608e;
        }

        public final int c() {
            return this.f14611h;
        }

        public final int d() {
            return this.f14612i;
        }

        public final Drawable e() {
            return this.f14614k;
        }

        public final Integer f() {
            return this.f14607d;
        }

        public final View g() {
            return this.f14609f;
        }

        public final boolean h() {
            return this.f14606c;
        }

        public final boolean i() {
            return this.f14604a;
        }

        public final TextWatcher j() {
            return this.f14610g;
        }

        public final String k() {
            return this.f14605b;
        }

        public final void l(boolean r10) {
            this.f14613j = r10;
        }

        public final void m(String r10) {
            this.f14608e = r10;
        }

        public final void n(int r10) {
            this.f14611h = r10;
        }

        public final void o(int r10) {
            this.f14612i = r10;
        }

        public final void p(Integer r10) {
            this.f14607d = r10;
        }

        public final void q(boolean r10) {
            this.f14606c = r10;
        }

        public final void r(boolean r10) {
            this.f14604a = r10;
        }

        public final void s(String r10) {
            this.f14605b = r10;
        }

        public b(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110) {
            this.f14604a = r10;
            this.f14605b = r11;
            this.f14606c = r12;
            this.f14607d = r13;
            this.f14608e = r14;
            this.f14609f = r15;
            this.f14610g = r16;
            this.f14611h = r17;
            this.f14612i = r18;
            this.f14613j = r19;
            this.f14614k = r110;
        }
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBoxInputView f14626a;

        public c(OBoxInputView r10) {
            this.f14626a = r10;
        }

        public static /* synthetic */ void a(OBoxInputView r10) {
            b(r10);
        }

        public static final void b(OBoxInputView r10) {
            q.g(r10, "this$0");
            OBoxInputView.i(r10);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            q.g(r10, "s");
            AppCompatEditText r11 = this.f14626a.getEditText();
            final OBoxInputView r12 = this.f14626a;
            r11.post(new com.obric.oui.forms.b(r12));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
            q.g(r10, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            q.g(r10, "s");
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f14627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OBoxInputView f14628b;

        public d(b r10, OBoxInputView r11) {
            this.f14627a = r10;
            this.f14628b = r11;
        }

        public static /* synthetic */ void a(OBoxInputView r10) {
            b(r10);
        }

        public static final void b(OBoxInputView r10) {
            q.g(r10, "this$0");
            OBoxInputView.i(r10);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (this.f14627a.a() == false) goto L6;
            AppCompatEditText r11 = this.f14628b.getEditText();
            final OBoxInputView r12 = this.f14628b;
            r11.post(new com.obric.oui.forms.c(r12));
            return;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            if (this.f14627a.f() == null) goto L24;
            Resources r14 = this.f14628b.getResources();
            int r15 = R$string.oui_form_counter;
            if (r10 != null) goto L7;
            String r16 = null;
        L8:
            String r17 = r14.getString(r15, new Object[]{r16, String.valueOf(this.f14627a.f())});
            q.f(r17, "resources.getString(\n   …                        )");
            SpannableString r18 = new SpannableString(r17);
            if (r10 != null) goto L11;
            int r19 = 0;
        L12:
            Integer r20 = this.f14627a.f();
            q.d(r20);
            if (r19 <= r20.intValue()) goto L22;
            ForegroundColorSpan r21 = new ForegroundColorSpan(ContextCompat.b(this.f14628b.getContext(), R$color.Primary));
            if (r10 != null) goto L17;
        L16:
            int r22 = 0;
        L21:
            r18.setSpan(r21, 0, r22, 18);
            goto L22
        L17:
            String r23 = Integer.valueOf(r10.length()).toString();
            if (r23 == null) goto L16;
            r22 = r23.length();
        L22:
            this.f14628b.getTvCounter().setText(r18, TextView.BufferType.SPANNABLE);
            return;
        L11:
            r19 = r10.length();
            goto L12
        L7:
            r16 = Integer.valueOf(r10.length()).toString();
            goto L8
        }
    }

    static {
        f14587t = new a(null);
        f14588u = SearchChipsView.BROWN;
    }

    @JvmOverloads
    public OBoxInputView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    public static /* synthetic */ void g(OBoxInputView r10, View r11, boolean r12) {
        h(r10, r11, r12);
    }

    public static final void h(OBoxInputView r10, View r11, boolean r12) {
        q.g(r10, "this$0");
        if (r12 == false) goto L5;
        r10.o();
        return;
    L5:
        r10.m();
    }

    public static final /* synthetic */ void i(OBoxInputView r10) {
        r10.k();
    }

    public static final /* synthetic */ int j() {
        return f14588u;
    }

    private final void l() {
        Iterator<WeakReference<TextWatcher>> r10 = getTextWatchers().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r11 = r10.next();
        this.f14591g.removeTextChangedListener(r11.get());
        goto L4
    }

    private final void setPrefixView(View r10) {
        if (r10 == null) goto L5;
        this.f14596l.removeAllViews();
        this.f14596l.addView(r10, new ConstraintLayout.LayoutParams(-2, -2));
        return;
    }

    public final int getArrangeDirection() {
        return this.f14589e;
    }

    @NotNull
    public final b getConfig() {
        return this.f14599o;
    }

    @NotNull
    public final AppCompatEditText getEditText() {
        return this.f14591g;
    }

    @NotNull
    public final ViewGroup getInputContainer() {
        return this.f14595k;
    }

    @Override // com.obric.oui.forms.AbsOForm
    @NotNull
    public EditText getInterEditText() {
        return this.f14591g;
    }

    @NotNull
    public final ImageView getIvTitleIcon() {
        return this.f14594j;
    }

    @NotNull
    public final ViewGroup getPrefixContainer() {
        return this.f14596l;
    }

    @NotNull
    public final String getText() {
        return String.valueOf(this.f14591g.getText());
    }

    @NotNull
    public final ViewGroup getTitleContainer() {
        return this.f14597m;
    }

    @NotNull
    public final TextView getTvCounter() {
        return this.f14593i;
    }

    @NotNull
    public final TextView getTvErrorTips() {
        return this.f14592h;
    }

    @NotNull
    public final TextView getTvTitle() {
        return this.f14590f;
    }

    public final void k() {
        int r10 = this.f14591g.getLineCount();
        int r11 = this.f14591g.getLineHeight();
        int r12 = this.f14591g.getHeight();
        int r13 = this.f14595k.getHeight();
        int r14 = ((r10 * r11) + r13) - r12;
        if (r14 >= this.f14599o.c()) goto L5;
    L8:
        ViewGroup.LayoutParams r15 = this.f14595k.getLayoutParams();
        q.f(r15, "inputContainer.getLayoutParams()");
        r15.height = r13;
        this.f14595k.setLayoutParams(r15);
        return;
    L5:
        if (r14 >= this.f14599o.d()) goto L8;
        r13 = r14;
        goto L8
    }

    public final void m() {
        Object r10 = getContext().getSystemService("input_method");
        if (r10 == null) goto L7;
        ((InputMethodManager) r10).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public final void n() {
        tc.l.k(this.f14590f);
        if (this.f14594j.getVisibility() == 0) goto L6;
        tc.l.k(this.f14597m);
    L6:
        this.f14599o.r(false);
    }

    public final void o() {
        Object r10 = getContext().getSystemService("input_method");
        if (r10 == null) goto L7;
        ((InputMethodManager) r10).showSoftInput(this, 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public final void p() {
        tc.l.m(this.f14590f);
        if (this.f14597m.getVisibility() == 0) goto L6;
        tc.l.m(this.f14597m);
    L6:
        this.f14599o.r(true);
    }

    public final void q() {
        if (this.f14597m.getVisibility() == 0) goto L6;
        tc.l.m(this.f14597m);
    L6:
        tc.l.m(this.f14594j);
    }

    public final void r(b r10) {
        q.g(r10, "config");
        this.f14599o = r10;
        String r11 = r10.k();
        if (r11 == null) goto L9;
        if (kotlin.text.o.r(r11) == true) goto L9;
        this.f14590f.setText(r10.k());
    L9:
        if (r10.i() == false) goto L11;
        p();
    L13:
        if (r10.g() == null) goto L16;
        View r12 = r10.g();
        q.d(r12);
        setPrefixView(r12);
    L16:
        if (TextUtils.isEmpty(r10.b()) == true) goto L19;
        this.f14591g.setHint(r10.b());
    L19:
        if (r10.a() == false) goto L22;
        this.f14591g.addTextChangedListener(new c(this));
    L22:
        if (r10.h() == true) goto L24;
    L30:
        r10.c();
        if (r10.c() <= 0) goto L38;
        ViewGroup r13 = this.f14595k;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L36;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        ((ViewGroup.MarginLayoutParams) r15).height = r10.c();
        r13.setLayoutParams(r15);
        goto L38
    L36:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L38:
        if (r10.j() == null) goto L41;
        TextWatcher r16 = r10.j();
        q.d(r16);
        setTextWatcher(r16);
    L41:
        if (r10.e() == null) goto L44;
        this.f14594j.setImageDrawable(r10.e());
    L44:
        if (this.f14600p == true) goto L46;
    L48:
        String r17 = this.f14598n;
        if (r17 != null) goto L51;
    L54:
        this.f14591g.setGravity(this.f14601q);
        return;
    L51:
        if (r17.length() == 0) goto L54;
        setText(this.f14598n);
        goto L54
    L46:
        if (r10.e() != null) goto L48;
        q();
        goto L48
    L24:
        if (r10.f() == null) goto L30;
        this.f14602r = new d(r10, this);
        ArrayList<WeakReference<TextWatcher>> r18 = getTextWatchers();
        TextWatcher r19 = this.f14602r;
        q.d(r19);
        r18.add(new WeakReference(r19));
        this.f14591g.addTextChangedListener(this.f14602r);
        TextWatcher r20 = this.f14602r;
        if (r20 == null) goto L29;
        r20.onTextChanged(this.f14591g.getText(), 0, 0, 0);
    L29:
        tc.l.m(this.f14593i);
        goto L30
    L11:
        n();
        goto L13
    }

    public final void setArrangeDirection(int r10) {
        this.f14589e = r10;
    }

    public final void setText(@Nullable String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() == 0) goto L12;
        this.f14591g.setText(r10);
        TextWatcher r11 = this.f14602r;
        if (r11 == null) goto L13;
        q.d(r10);
        r11.onTextChanged(r10, 0, 0, r10.length());
        return;
    L13:
        return;
    }

    public final void setTextWatcher(@NotNull TextWatcher r10) {
        q.g(r10, "textWatcher");
        l();
        getTextWatchers().add(new WeakReference(r10));
        this.f14591g.addTextChangedListener(r10);
    }

    public final void setTitleContainer(@NotNull ViewGroup r10) {
        q.g(r10, "<set-?>");
        this.f14597m = r10;
    }

    @JvmOverloads
    public OBoxInputView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OBoxInputView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OBoxInputView(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
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

    public OBoxInputView(Context r18, AttributeSet r19, int r20, int r21) {
        q.g(r18, "context");
        super(r18, r19, r20);
        this.f14589e = r21;
        boolean r10 = false;
        String r11 = null;
        boolean r12 = false;
        Integer r13 = null;
        String r14 = null;
        View r15 = null;
        TextWatcher r16 = null;
        int r17 = 0;
        int r110 = 0;
        boolean r111 = false;
        Drawable r112 = null;
        this.f14599o = new b.a(r10, r11, r12, r13, r14, r15, r16, r17, r110, r111, r112, 2047, null).a();
        this.f14601q = 48;
        this.f14603s = 20;
        TypedArray r22 = r18.getTheme().obtainStyledAttributes(r19, R$styleable.OBoxInputView, 0, 0);
        setArrangeDirection(r22.getInt(R$styleable.OBoxInputView_oui_formArrangeDirection, 1));     // Catch: Throwable -> L6
        String r23 = r22.getString(R$styleable.OBoxInputView_android_hint);     // Catch: Throwable -> L6
        this.f14599o.m(r23);     // Catch: Throwable -> L6
        boolean r24 = r22.getBoolean(R$styleable.OBoxInputView_oui_formShowCounter, false);     // Catch: Throwable -> L6
        this.f14599o.q(r24);     // Catch: Throwable -> L6
        int r25 = r22.getInt(R$styleable.OBoxInputView_oui_formLengthLimit, 0);     // Catch: Throwable -> L6
        if (r25 <= 0) goto L8;
        this.f14599o.p(Integer.valueOf(r25));     // Catch: Throwable -> L6
    L8:
        String r26 = r22.getString(R$styleable.OBoxInputView_oui_formTitle);     // Catch: Throwable -> L6
        if (r26 != null) goto L11;
    L14:
        this.f14599o.s("标题");     // Catch: Throwable -> L6
    L15:
        this.f14599o.n(r22.getDimensionPixelSize(R$styleable.OBoxInputView_oui_formInputHeight, tc.f.b(r18, f14588u)));     // Catch: Throwable -> L6
        this.f14599o.o(r22.getDimensionPixelSize(R$styleable.OBoxInputView_oui_formInputMaxHeight, Channel.UNLIMITED));     // Catch: Throwable -> L6
        this.f14598n = r22.getString(R$styleable.OBoxInputView_android_text);     // Catch: Throwable -> L6
        this.f14600p = r22.getBoolean(R$styleable.OBoxInputView_oui_formShowTitleDefaultIcon, false);     // Catch: Throwable -> L6
        this.f14599o.l(r22.getBoolean(R$styleable.OBoxInputView_oui_formAutoAdjustHeight, false));     // Catch: Throwable -> L6
        this.f14601q = r22.getInt(R$styleable.OBoxInputView_android_gravity, 48);     // Catch: Throwable -> L6
        r22.recycle();
        if (this.f14589e != 1) goto L19;
        int r27 = R$layout.o_form_box_horizontal;
    L20:
        LayoutInflater.from(r18).inflate(r27, this);
        View r28 = findViewById(R$id.tv_title);
        q.f(r28, "findViewById(R.id.tv_title)");
        this.f14590f = (TextView) r28;
        View r29 = findViewById(R$id.iv_title_icon);
        q.f(r29, "findViewById(R.id.iv_title_icon)");
        this.f14594j = (ImageView) r29;
        View r30 = findViewById(R$id.prefix_container);
        q.f(r30, "findViewById(R.id.prefix_container)");
        this.f14596l = (ViewGroup) r30;
        View r31 = findViewById(R$id.edittext);
        q.f(r31, "findViewById(R.id.edittext)");
        AppCompatEditText r32 = (AppCompatEditText) r31;
        this.f14591g = r32;
        View r33 = findViewById(R$id.tv_counter);
        q.f(r33, "findViewById(R.id.tv_counter)");
        this.f14593i = (TextView) r33;
        View r34 = findViewById(R$id.tv_error_tips);
        q.f(r34, "findViewById(R.id.tv_error_tips)");
        this.f14592h = (TextView) r34;
        r32.setOnFocusChangeListener(new com.obric.oui.forms.a(this));
        View r35 = findViewById(R$id.input_container);
        q.f(r35, "findViewById(R.id.input_container)");
        this.f14595k = (ViewGroup) r35;
        View r36 = findViewById(R$id.title_container);
        q.f(r36, "findViewById(R.id.title_container)");
        this.f14597m = (ViewGroup) r36;
        r(this.f14599o);
        r32.setLines(20);
        r32.setSingleLine(false);
        return;
    L19:
        r27 = R$layout.o_form_box_vertical;
        goto L20
    L11:
        if (r26.length() == 0) goto L14;
        this.f14599o.s(r26);     // Catch: Throwable -> L6
        this.f14599o.r(true);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r22.recycle();
        throw th;
    }
}
