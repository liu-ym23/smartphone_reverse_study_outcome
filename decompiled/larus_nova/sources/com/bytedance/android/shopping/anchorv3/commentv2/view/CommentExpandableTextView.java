package com.bytedance.android.shopping.anchorv3.commentv2.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.g1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J)\u0010\u000b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/view/CommentExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/view/View$OnTouchListener;", "getLinkClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "dy", "", "listener", "setRvScrollListener", "Landroid/text/SpannableString;", "text", "setOriginText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentExpandableTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpannableString f164743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f164744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f164745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f164746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f164747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f164748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f164749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f164750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f164751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Integer, Unit> f164752j;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Integer r102 = null;
            if ((r100 instanceof TextView) == true) goto L5;
            r100 = null;
        L5:
            TextView r103 = (TextView) r100;
            if (r103 != null) goto L8;
            return false;
        L8:
            CharSequence r104 = r103.getText();
            if ((r104 instanceof Spanned) == false) goto L23;
            if (r101 == null) goto L12;
            r102 = Integer.valueOf(r101.getAction());
        L12:
            if (r102 == null) goto L23;
            if (r102.intValue() != 1) goto L23;
            int r105 = (int) r101.getX();
            int r106 = (int) r101.getY();
            int r107 = r105 - (r103.getTotalPaddingLeft() + r103.getScrollX());
            int r108 = r106 - (r103.getTotalPaddingTop() + r103.getScrollY());
            Layout r109 = r103.getLayout();
            int r110 = r109.getOffsetForHorizontal(r109.getLineForVertical(r108), r107);
            ClickableSpan[] r111 = (ClickableSpan[]) ((Spanned) r104).getSpans(r110, r110, ClickableSpan.class);
            if (r111.length != 0) goto L19;
            boolean r112 = true;
        L21:
            if ((!r112) == false) goto L23;
            r111[0].onClick(r103);
            goto L23
        L19:
            r112 = false;
        L23:
            return true;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentExpandableTextView f164753a;

        public c(CommentExpandableTextView r100) {
            this.f164753a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CommentExpandableTextView.x(this.f164753a, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public CommentExpandableTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentExpandableTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View.OnTouchListener getLinkClickListener() {
        b r100 = this.f164751i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        b r101 = new b();
        this.f164751i = r101;
        return r101;
    }

    public static final /* synthetic */ View.OnTouchListener y(CommentExpandableTextView r100) {
        return r100.getLinkClickListener();
    }

    public final Layout A(SpannableString r110) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 <= 23) goto L12;
        StaticLayout.Builder r111 = StaticLayout.Builder.obtain(r110, 0, r110.length(), getPaint(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setIncludePad(getIncludeFontPadding()).setBreakStrategy(getBreakStrategy()).setHyphenationFrequency(getHyphenationFrequency()).setEllipsize(getEllipsize()).setEllipsizedWidth((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        if (r100 <= 28) goto L8;
        r111.setUseLineSpacingFromFallbacks(isFallbackLineSpacing());
    L8:
        if (r100 <= 26) goto L13;
        r111.setJustificationMode(getJustificationMode());
    L13:
        return r111.build();
    L12:
        return new StaticLayout(r110, getPaint(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
    }

    public final void setOriginText(SpannableString r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if ((!Intrinsics.areEqual(r100.toString(), this.f164743a.toString())) == false) goto L6;
        this.f164743a = r100;
        post(new c(this));
        return;
    }

    public final void setRvScrollListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f164752j = r100;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, android.text.SpannableStringBuilder, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, android.text.SpannableStringBuilder, java.lang.CharSequence] */
    public static final void x(final CommentExpandableTextView r100, boolean r101) {
        Layout r102 = r100.A(r100.f164743a);
        if (r100.f164750h <= 0) goto L13;
        int r103 = r102.getLineCount();
        int r104 = r100.f164750h;
        if (r103 <= r104) goto L13;
        int r105 = r102.getLineStart(r104) - 1;
        final Ref.ObjectRef r106 = new Ref.ObjectRef();
        ?? r107 = new SpannableStringBuilder(r100.f164743a.subSequence(0, r105)).append("... ").append(r100.f164744b);
        r106.element = r107;
        Layout r108 = r100.A(SpannableString.valueOf(r107));
    L8:
        if (r108.getLineCount() <= r100.f164750h) goto L12;
        r105 = r105 - 1;
        if (r105 <= 0) goto L12;
        ?? r109 = new SpannableStringBuilder(r100.f164743a.subSequence(0, r105)).append("... ").append(r100.f164744b);
        r106.element = r109;
        r108 = r100.A(SpannableString.valueOf(r109));
    L12:
        r100.z(r108.getHeight(), r101, new CommentExpandableTextView$closeTextView$1(r100, r106));
        return;
    L13:
        r100.setText(r100.f164743a);
        r100.z(r100.A(r100.f164743a).getHeight(), false, null);
    }

    public CommentExpandableTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f164743a = new SpannableString("");
        this.f164744b = r100.getString(R.string.expand);
        this.f164745c = r100.getString(R.string.collapsed);
        this.f164746d = com.bytedance.android.shopping.extensions.b.c(14);
        this.f164747e = com.bytedance.android.shopping.extensions.b.c(14);
        int r103 = g1.f45599a;
        this.f164748f = g1.a.a(r100, R.color.commerce_link4);
        this.f164749g = g1.a.a(r100, R.color.commerce_link4);
        this.f164750h = 4;
        TypedArray r104 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.closed_text, R.attr.closed_text_color, R.attr.closed_text_size, R.attr.expand_text, R.attr.expand_text_color, R.attr.expand_text_size, R.attr.max_fold_lines});
        String r105 = r104.getString(3);
        if (r105 != null) goto L5;
        r105 = getContext().getString(R.string.expand);
    L5:
        this.f164744b = r105;
        String r106 = r104.getString(0);
        if (r106 != null) goto L8;
        r106 = getContext().getString(R.string.collapsed);
    L8:
        this.f164745c = r106;
        this.f164746d = r104.getDimension(5, this.f164746d);
        this.f164747e = r104.getDimension(2, this.f164747e);
        this.f164748f = r104.getColor(4, g1.a.a(getContext(), R.color.commerce_link4));
        this.f164749g = r104.getColor(1, g1.a.a(getContext(), R.color.commerce_link4));
        r104.recycle();
    }

    public final void z(int r100, boolean r101, Function0 r102) {
        if (r101 == true) goto L7;
        ViewGroup.LayoutParams r103 = getLayoutParams();
        r103.height = r100;
        setLayoutParams(r103);
        if (r102 == null) goto L9;
        Unit r104 = (Unit) r102.invoke();
        return;
    L9:
        return;
    L7:
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{getHeight(), r100});
        r105.addUpdateListener(new com.bytedance.android.shopping.anchorv3.commentv2.view.a(this, r102));
        r105.addListener(new com.bytedance.android.shopping.anchorv3.commentv2.view.b(r102));
        r105.setDuration(300);
        r105.start();
    }

    public /* synthetic */ CommentExpandableTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
