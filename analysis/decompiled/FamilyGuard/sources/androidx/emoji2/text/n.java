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

/* loaded from: classes.dex */
public final class n extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f10373a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f10374b;

    private static class a implements TextWatcher, SpanWatcher {

        /* renamed from: a, reason: collision with root package name */
        final Object f10375a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f10376b = new AtomicInteger(0);

        a(Object obj) {
            this.f10375a = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof i;
        }

        final void a() {
            this.f10376b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f10375a).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.f10375a).beforeTextChanged(charSequence, i5, i6, i7);
        }

        final void c() {
            this.f10376b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i5, int i6) {
            if (this.f10376b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f10375a).onSpanAdded(spannable, obj, i5, i6);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i5, int i6, int i7, int i8) {
            if (this.f10376b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f10375a).onSpanChanged(spannable, obj, i5, i6, i7, i8);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i5, int i6) {
            if (this.f10376b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f10375a).onSpanRemoved(spannable, obj, i5, i6);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.f10375a).onTextChanged(charSequence, i5, i6, i7);
        }
    }

    n(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.f10374b = new ArrayList();
        D.h.f(cls, "watcherClass cannot be null");
        this.f10373a = cls;
    }

    private void b() {
        for (int i5 = 0; i5 < this.f10374b.size(); i5++) {
            this.f10374b.get(i5).a();
        }
    }

    public static n c(Class<?> cls, CharSequence charSequence) {
        return new n(cls, charSequence);
    }

    private void e() {
        for (int i5 = 0; i5 < this.f10374b.size(); i5++) {
            this.f10374b.get(i5).onTextChanged(this, 0, length(), length());
        }
    }

    private a f(Object obj) {
        for (int i5 = 0; i5 < this.f10374b.size(); i5++) {
            a aVar = this.f10374b.get(i5);
            if (aVar.f10375a == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean g(Class<?> cls) {
        return this.f10373a == cls;
    }

    private boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i5 = 0; i5 < this.f10374b.size(); i5++) {
            this.f10374b.get(i5).c();
        }
    }

    public void a() {
        b();
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int i5, int i6, Class<T> cls) {
        if (!g(cls)) {
            return (T[]) super.getSpans(i5, i6, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i5, i6, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            tArr[i7] = aVarArr[i7].f10375a;
        }
        return tArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i5, int i6, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVarF;
        if (h(obj)) {
            aVarF = f(obj);
            if (aVarF != null) {
                obj = aVarF;
            }
        } else {
            aVarF = null;
        }
        super.removeSpan(obj);
        if (aVarF != null) {
            this.f10374b.remove(aVarF);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i5, int i6, int i7) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f10374b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i5, i6, i7);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        return new n(this.f10373a, this, i5, i6);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence) {
        b();
        super.replace(i5, i6, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    n(Class<?> cls, CharSequence charSequence, int i5, int i6) {
        super(charSequence, i5, i6);
        this.f10374b = new ArrayList();
        D.h.f(cls, "watcherClass cannot be null");
        this.f10373a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        b();
        super.replace(i5, i6, charSequence, i7, i8);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c6) {
        super.append(c6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i5) {
        super.append(charSequence, obj, i5);
        return this;
    }
}
