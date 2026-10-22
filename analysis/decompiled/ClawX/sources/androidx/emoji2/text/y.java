package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Class f648a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f649b;

    public y(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f649b = new ArrayList();
        a.a.j(cls, "watcherClass cannot be null");
        this.f648a = cls;
    }

    public final void a() {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f649b;
            if (i8 >= arrayList.size()) {
                return;
            }
            ((x) arrayList.get(i8)).f647b.incrementAndGet();
            i8++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f649b;
            if (i8 >= arrayList.size()) {
                return;
            }
            ((x) arrayList.get(i8)).onTextChanged(this, 0, length(), length());
            i8++;
        }
    }

    public final x c(Object obj) {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f649b;
            if (i8 >= arrayList.size()) {
                return null;
            }
            x xVar = (x) arrayList.get(i8);
            if (xVar.f646a == obj) {
                return xVar;
            }
            i8++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f648a == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i8, int i9) {
        super.delete(i8, i9);
        return this;
    }

    public final void e() {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f649b;
            if (i8 >= arrayList.size()) {
                return;
            }
            ((x) arrayList.get(i8)).f647b.decrementAndGet();
            i8++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        x xVarC;
        if (d(obj) && (xVarC = c(obj)) != null) {
            obj = xVarC;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        x xVarC;
        if (d(obj) && (xVarC = c(obj)) != null) {
            obj = xVarC;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        x xVarC;
        if (d(obj) && (xVarC = c(obj)) != null) {
            obj = xVarC;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i8, int i9, Class cls) {
        if (this.f648a != cls) {
            return super.getSpans(i8, i9, cls);
        }
        x[] xVarArr = (x[]) super.getSpans(i8, i9, x.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, xVarArr.length);
        for (int i10 = 0; i10 < xVarArr.length; i10++) {
            objArr[i10] = xVarArr[i10].f646a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i8, CharSequence charSequence) {
        super.insert(i8, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i8, int i9, Class cls) {
        if (cls == null || this.f648a == cls) {
            cls = x.class;
        }
        return super.nextSpanTransition(i8, i9, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        x xVarC;
        if (d(obj)) {
            xVarC = c(obj);
            if (xVarC != null) {
                obj = xVarC;
            }
        } else {
            xVarC = null;
        }
        super.removeSpan(obj);
        if (xVarC != null) {
            this.f649b.remove(xVarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i8, int i9, CharSequence charSequence) {
        replace(i8, i9, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i8, int i9, int i10) {
        if (d(obj)) {
            x xVar = new x(obj);
            this.f649b.add(xVar);
            obj = xVar;
        }
        super.setSpan(obj, i8, i9, i10);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i8, int i9) {
        return new y(this.f648a, this, i8, i9);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i8, int i9) {
        super.delete(i8, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i8, CharSequence charSequence) {
        super.insert(i8, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i8, int i9, CharSequence charSequence, int i10, int i11) {
        replace(i8, i9, charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i8, CharSequence charSequence, int i9, int i10) {
        super.insert(i8, charSequence, i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i8, int i9, CharSequence charSequence) {
        a();
        super.replace(i8, i9, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i8, CharSequence charSequence, int i9, int i10) {
        super.insert(i8, charSequence, i9, i10);
        return this;
    }

    public y(Class cls, y yVar, int i8, int i9) {
        super(yVar, i8, i9);
        this.f649b = new ArrayList();
        a.a.j(cls, "watcherClass cannot be null");
        this.f648a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i8, int i9, CharSequence charSequence, int i10, int i11) {
        a();
        super.replace(i8, i9, charSequence, i10, i11);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i8, int i9) {
        super.append(charSequence, i8, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i8, int i9) {
        super.append(charSequence, i8, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i8, int i9) {
        super.append(charSequence, i8, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i8) {
        super.append(charSequence, obj, i8);
        return this;
    }
}
