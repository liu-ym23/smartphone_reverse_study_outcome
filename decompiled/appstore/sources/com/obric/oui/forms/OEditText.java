package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0004j$\u000b\u000fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u0016\u001a\u00020\n2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0011H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J4\u0010\u001a\u001a\u00020\n2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n0\u0011H\u0000¢\u0006\u0004\b\u001a\u0010\u0017Js\u0010!\u001a\u00020\n2b\u0010\u0015\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\u001bH\u0000¢\u0006\u0004\b!\u0010\"J4\u0010$\u001a\u00020\n2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\n0\u0011H\u0000¢\u0006\u0004\b$\u0010\u0017J\u000f\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020%H\u0014¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020%H\u0014¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020%H\u0014¢\u0006\u0004\b*\u0010'J\u0019\u0010-\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u00104J\u0011\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b6\u00107J\u0019\u00108\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010<\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0014¢\u0006\u0004\b<\u0010=J7\u0010C\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0006H\u0014¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u000eH\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010I\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H\u0014¢\u0006\u0004\bI\u0010=R\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010QR$\u0010Y\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010ZR\u0016\u0010\\\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010ZR\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010aR\u0016\u0010h\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010i\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010a¨\u0006k"}, d2 = {"Lcom/obric/oui/forms/OEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "b", "()V", "type", "", "c", "(I)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hasFocus", "action", "d", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/view/MotionEvent;", "event", "e", "Lkotlin/Function4;", "", "s", "start", "before", "count", "f", "(Lkotlin/jvm/functions/Function4;)V", "Landroid/text/Editable;", "a", "", "getLeftFadingEdgeStrength", "()F", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Landroid/view/View$OnTouchListener;", "l", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Landroid/view/inputmethod/CompletionInfo;", "text", "onCommitCompletion", "(Landroid/view/inputmethod/CompletionInfo;)V", "setInputType", "(I)V", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "performLongClick", "()Z", "selStart", "selEnd", "onSelectionChanged", "Lcom/obric/oui/forms/OEditText$a;", "Lcom/obric/oui/forms/OEditText$a;", "onFocusChangeListenerWrapper", "Lcom/obric/oui/forms/OEditText$b;", "Lcom/obric/oui/forms/OEditText$b;", "onTouchListenerWrapper", "Lcom/obric/oui/forms/OEditText$c;", "Lcom/obric/oui/forms/OEditText$c;", "textWatcherWrapper", "Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$CommitCompletionListener;)V", "commitCompletionListener", "F", "mPasswordMaskDotSizeRatio", "mPasswordMaskDotSpacingRatio", "g", "I", "mErrorBackgroundColor", "h", "Z", "isLeftFading", "i", "isRightFading", "j", "isTopFading", "k", "isBottomFading", "isPerformingLongClick", "CommitCompletionListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f14630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f14631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommitCompletionListener f14632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f14633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f14634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14640l;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "", "onCommitCompletion", "", "text", "Landroid/view/inputmethod/CompletionInfo;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CommitCompletionListener {
        void onCommitCompletion(@Nullable CompletionInfo r10);
    }

    public static final class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1 f14641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View.OnFocusChangeListener f14642b;

        public a() {
        }

        public final View.OnFocusChangeListener a() {
            return this.f14642b;
        }

        public final void b(Function1 r10) {
            this.f14641a = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r10, boolean r11) {
            Function1 r12 = this.f14641a;
            if (r12 == null) goto L6;
            r12.invoke(Boolean.valueOf(r11));
        L6:
            View.OnFocusChangeListener r13 = this.f14642b;
            if (r13 == null) goto L11;
            r13.onFocusChange(r10, r11);
            return;
        }

        public final void setListener(@Nullable View.OnFocusChangeListener r10) {
            this.f14642b = r10;
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1 f14643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View.OnTouchListener f14644b;

        public b() {
        }

        public final void a(Function1 r10) {
            this.f14643a = r10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            Function1 r12 = this.f14643a;
            if (r12 == null) goto L6;
            r12.invoke(r11);
        L6:
            View.OnTouchListener r13 = this.f14644b;
            if (r13 != null) goto L10;
            return false;
        L10:
            return r13.onTouch(r10, r11);
        }

        public final void setListener(@Nullable View.OnTouchListener r10) {
            this.f14644b = r10;
        }
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function4 f14645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function4 f14646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function1 f14647c;

        public c() {
        }

        public final void a(Function1 r10) {
            this.f14647c = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            Function1 r11 = this.f14647c;
            if (r11 == null) goto L7;
            r11.invoke(r10);
            return;
        }

        public final void b(Function4 r10) {
            this.f14645a = r10;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
            Function4 r14 = this.f14646b;
            if (r14 == null) goto L7;
            r14.invoke(r10, Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13));
            return;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            Function4 r14 = this.f14645a;
            if (r14 == null) goto L7;
            r14.invoke(r10, Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13));
            return;
        }
    }

    @JvmOverloads
    public OEditText(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(Function1 r10) {
        q.g(r10, "action");
        this.f14631c.a(r10);
    }

    public final void b() {
        if (c(getInputType()) == false) goto L5;
        TransformationMethod r10 = getTransformationMethod();
        if ((r10 instanceof p) == false) goto L15;
        p r11 = (p) r10;
        if (r11.a() != this.f14633e) goto L15;
        if (r11.b() != this.f14634f) goto L15;
        return;
    L15:
        super.setTransformationMethod(new p(this.f14633e, this.f14634f, this.f14635g));
        return;
    L5:
        if ((getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L17;
        super.setTransformationMethod(null);
        return;
    }

    public final boolean c(int r10) {
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

    public final void d(Function1 r10) {
        q.g(r10, "action");
        this.f14629a.b(r10);
    }

    public final void e(Function1 r10) {
        q.g(r10, "action");
        this.f14630b.a(r10);
    }

    public final void f(Function4 r10) {
        q.g(r10, "action");
        this.f14631c.b(r10);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.f14639k == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    @Nullable
    public final CommitCompletionListener getCommitCompletionListener() {
        return this.f14632d;
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.f14636h == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.view.View
    @Nullable
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r10 = super.getOnFocusChangeListener();
        if ((r10 instanceof a) == true) goto L5;
        return r10;
    L5:
        return ((a) r10).a();
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.f14637i == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.f14638j == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo r10) {
        super.onCommitCompletion(r10);
        CommitCompletionListener r11 = this.f14632d;
        if (r11 == null) goto L7;
        r11.onCommitCompletion(r10);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int r10, int r11) {
        super.onSelectionChanged(r10, r11);
        if (r10 == r11) goto L5;
        boolean r12 = true;
    L7:
        if (this.f14640l == true) goto L11;
        if (r12 == false) goto L12;
        dd.a.b(getContext(), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r12 = false;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.f14640l = true;
        boolean r10 = super.performLongClick();
        this.f14640l = false;
        return r10;
    }

    public final void setCommitCompletionListener(@Nullable CommitCompletionListener r10) {
        this.f14632d = r10;
    }

    @Override // android.widget.TextView
    public void setInputType(int r10) {
        super.setInputType(r10);
        b();
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(@Nullable View.OnFocusChangeListener r10) {
        if ((r10 instanceof a) == false) goto L5;
        super.setOnFocusChangeListener(r10);
        return;
    L5:
        this.f14629a.setListener(r10);
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener r10) {
        this.f14630b.setListener(r10);
    }

    @JvmOverloads
    public OEditText(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OEditText(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OEditText(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        a r13 = new a();
        this.f14629a = r13;
        b r14 = new b();
        this.f14630b = r14;
        c r15 = new c();
        this.f14631c = r15;
        this.f14633e = 0.38f;
        this.f14634f = 0.19f;
        this.f14635g = ContextCompat.b(r10, R$color.oui_functional_red_2);
        setOnFocusChangeListener(r13);
        super.setOnTouchListener(r14);
        addTextChangedListener(r15);
        setHighlightColor(r10.getColor(R$color.oui_text_highlight_color));
        b();
    }
}
