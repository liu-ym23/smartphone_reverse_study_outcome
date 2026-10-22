package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class k extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3105b;

    public static class a implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f3106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f3107b;

        public a(Object r10) {
            this.f3107b = new AtomicInteger(0);
            this.f3106a = r10;
        }

        public final void a() {
            this.f3107b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            ((TextWatcher) this.f3106a).afterTextChanged(r10);
        }

        public final boolean b(Object r10) {
            return r10 instanceof g;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
            ((TextWatcher) this.f3106a).beforeTextChanged(r10, r11, r12, r13);
        }

        public final void c() {
            this.f3107b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable r10, Object r11, int r12, int r13) {
            if (this.f3107b.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.f3106a).onSpanAdded(r10, r11, r12, r13);
            return;
        L5:
            if (b(r11) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable r10, Object r11, int r12, int r13, int r14, int r15) {
            if (this.f3107b.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.f3106a).onSpanChanged(r10, r11, r12, r13, r14, r15);
            return;
        L5:
            if (b(r11) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable r10, Object r11, int r12, int r13) {
            if (this.f3107b.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.f3106a).onSpanRemoved(r10, r11, r12, r13);
            return;
        L5:
            if (b(r11) == false) goto L7;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            ((TextWatcher) this.f3106a).onTextChanged(r10, r11, r12, r13);
        }
    }

    public k(Class r10, CharSequence r11) {
        super(r11);
        this.f3105b = new ArrayList();
        androidx.core.util.e.h(r10, "watcherClass cannot be null");
        this.f3104a = r10;
    }

    public static k c(Class r10, CharSequence r11) {
        return new k(r10, r11);
    }

    public void a() {
        b();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Editable append(char r10) {
        return append(r10);
    }

    public final void b() {
        int r10 = 0;
    L4:
        if (r10 >= this.f3105b.size()) goto L6;
        ((a) this.f3105b.get(r10)).a();
        r10 = r10 + 1;
        goto L4
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable delete(int r10, int r11) {
        return delete(r10, r11);
    }

    public final void e() {
        int r10 = 0;
    L4:
        if (r10 >= this.f3105b.size()) goto L6;
        ((a) this.f3105b.get(r10)).onTextChanged(this, 0, length(), length());
        r10 = r10 + 1;
        goto L4
    }

    public final a f(Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f3105b.size()) goto L9;
        a r12 = (a) this.f3105b.get(r11);
        if (r12.f3106a == r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return null;
    }

    public final boolean g(Class r10) {
        if (this.f3104a != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object r10) {
        if (h(r10) == false) goto L8;
        a r11 = f(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        return super.getSpanEnd(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object r10) {
        if (h(r10) == false) goto L8;
        a r11 = f(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        return super.getSpanFlags(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object r10) {
        if (h(r10) == false) goto L8;
        a r11 = f(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        return super.getSpanStart(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int r10, int r11, Class r12) {
        if (g(r12) == false) goto L10;
        a[] r13 = (a[]) super.getSpans(r10, r11, a.class);
        Object[] r14 = (Object[]) Array.newInstance(r12, r13.length);
        int r15 = 0;
    L6:
        if (r15 >= r13.length) goto L8;
        r14[r15] = r13[r15].f3106a;
        r15 = r15 + 1;
        goto L6
    L8:
        return r14;
    L10:
        return super.getSpans(r10, r11, r12);
    }

    public final boolean h(Object r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (g(r10.getClass()) == false) goto L6;
        return true;
    }

    public final void i() {
        int r10 = 0;
    L4:
        if (r10 >= this.f3105b.size()) goto L6;
        ((a) this.f3105b.get(r10)).c();
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable insert(int r10, CharSequence r11) {
        return insert(r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int r10, int r11, Class r12) {
        if (r12 != null) goto L4;
    L5:
        r12 = a.class;
    L7:
        return super.nextSpanTransition(r10, r11, r12);
    L4:
        if (g(r12) == false) goto L7;
        goto L5
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object r10) {
        if (h(r10) == false) goto L7;
        a r11 = f(r10);
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        super.removeSpan(r10);
        if (r11 == null) goto L12;
        this.f3105b.remove(r11);
        return;
    L12:
        return;
    L7:
        r11 = null;
        goto L8
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable replace(int r10, int r11, CharSequence r12) {
        return replace(r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object r10, int r11, int r12, int r13) {
        if (h(r10) == false) goto L5;
        a r14 = new a(r10);
        this.f3105b.add(r14);
        r10 = r14;
    L5:
        super.setSpan(r10, r11, r12, r13);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int r10, int r11) {
        return new k(this.f3104a, this, r10, r11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Editable append(CharSequence r10) {
        return append(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int r10, int r11) {
        super.delete(r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable insert(int r10, CharSequence r11, int r12, int r13) {
        return insert(r10, r11, r12, r13);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable replace(int r10, int r11, CharSequence r12, int r13, int r14) {
        return replace(r10, r11, r12, r13, r14);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Editable append(CharSequence r10, int r11, int r12) {
        return append(r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int r10, CharSequence r11) {
        super.insert(r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int r10, int r11, CharSequence r12) {
        b();
        super.replace(r10, r11, r12);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r10) {
        return append(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int r10, CharSequence r11, int r12, int r13) {
        super.insert(r10, r11, r12, r13);
        return this;
    }

    public k(Class r10, CharSequence r11, int r12, int r13) {
        super(r11, r12, r13);
        this.f3105b = new ArrayList();
        androidx.core.util.e.h(r10, "watcherClass cannot be null");
        this.f3104a = r10;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r10) {
        return append(r10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r10, int r11, int r12) {
        return append(r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int r10, int r11, CharSequence r12, int r13, int r14) {
        b();
        super.replace(r10, r11, r12, r13, r14);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence r10) {
        super.append(r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char r10) {
        super.append(r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence r10, int r11, int r12) {
        super.append(r10, r11, r12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence r10, Object r11, int r12) {
        super.append(r10, r11, r12);
        return this;
    }
}
