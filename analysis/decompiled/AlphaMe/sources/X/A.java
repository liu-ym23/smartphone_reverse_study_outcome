package X;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class A extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2031a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2032b;

    public A(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f2032b = new ArrayList();
        com.airbnb.lottie.h.h(cls, "watcherClass cannot be null");
        this.f2031a = cls;
    }

    public final void a() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f2032b;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((z) arrayList.get(i4)).f2106b.incrementAndGet();
            i4++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f2032b;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((z) arrayList.get(i4)).onTextChanged(this, 0, length(), length());
            i4++;
        }
    }

    public final z c(Object obj) {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f2032b;
            if (i4 >= arrayList.size()) {
                return null;
            }
            z zVar = (z) arrayList.get(i4);
            if (zVar.f2105a == obj) {
                return zVar;
            }
            i4++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            if (this.f2031a == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i4, int i5) {
        super.delete(i4, i5);
        return this;
    }

    public final void e() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f2032b;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((z) arrayList.get(i4)).f2106b.decrementAndGet();
            i4++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        z zVarC;
        if (d(obj) && (zVarC = c(obj)) != null) {
            obj = zVarC;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        z zVarC;
        if (d(obj) && (zVarC = c(obj)) != null) {
            obj = zVarC;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        z zVarC;
        if (d(obj) && (zVarC = c(obj)) != null) {
            obj = zVarC;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i4, int i5, Class cls) {
        if (this.f2031a != cls) {
            return super.getSpans(i4, i5, cls);
        }
        z[] zVarArr = (z[]) super.getSpans(i4, i5, z.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, zVarArr.length);
        for (int i6 = 0; i6 < zVarArr.length; i6++) {
            objArr[i6] = zVarArr[i6].f2105a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i4, CharSequence charSequence) {
        super.insert(i4, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i4, int i5, Class cls) {
        if (cls == null || this.f2031a == cls) {
            cls = z.class;
        }
        return super.nextSpanTransition(i4, i5, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        z zVarC;
        if (d(obj)) {
            zVarC = c(obj);
            if (zVarC != null) {
                obj = zVarC;
            }
        } else {
            zVarC = null;
        }
        super.removeSpan(obj);
        if (zVarC != null) {
            this.f2032b.remove(zVarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i4, int i5, CharSequence charSequence) {
        replace(i4, i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i4, int i5, int i6) {
        if (d(obj)) {
            z zVar = new z(obj);
            this.f2032b.add(zVar);
            obj = zVar;
        }
        super.setSpan(obj, i4, i5, i6);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i4, int i5) {
        return new A(this.f2031a, this, i4, i5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i4, int i5) {
        super.delete(i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i4, CharSequence charSequence) {
        super.insert(i4, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i4, int i5, CharSequence charSequence, int i6, int i7) {
        replace(i4, i5, charSequence, i6, i7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i4, CharSequence charSequence, int i5, int i6) {
        super.insert(i4, charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i4, int i5, CharSequence charSequence) {
        a();
        super.replace(i4, i5, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i4, CharSequence charSequence, int i5, int i6) {
        super.insert(i4, charSequence, i5, i6);
        return this;
    }

    public A(Class cls, CharSequence charSequence, int i4, int i5) {
        super(charSequence, i4, i5);
        this.f2032b = new ArrayList();
        com.airbnb.lottie.h.h(cls, "watcherClass cannot be null");
        this.f2031a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i4, int i5, CharSequence charSequence, int i6, int i7) {
        a();
        super.replace(i4, i5, charSequence, i6, i7);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i4, int i5) {
        super.append(charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i4, int i5) {
        super.append(charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i4, int i5) {
        super.append(charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i4) {
        super.append(charSequence, obj, i4);
        return this;
    }
}
