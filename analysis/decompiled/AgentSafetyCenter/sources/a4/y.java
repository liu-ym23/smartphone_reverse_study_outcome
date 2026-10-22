package a4;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends SpannableStringBuilder {

    /* renamed from: c, reason: collision with root package name */
    public Class f214c;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f215f;

    public final void a() {
        ArrayList arrayList = this.f215f;
        for (int i = 0; i < arrayList.size(); i++) {
            ((x) arrayList.get(i)).f213f.incrementAndGet();
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        ArrayList arrayList = this.f215f;
        for (int i = 0; i < arrayList.size(); i++) {
            ((x) arrayList.get(i)).onTextChanged(this, 0, length(), length());
        }
    }

    public final x c(Object obj) {
        ArrayList arrayList = this.f215f;
        for (int i = 0; i < arrayList.size(); i++) {
            x xVar = (x) arrayList.get(i);
            if (xVar.f212c == obj) {
                return xVar;
            }
        }
        return null;
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f214c == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i, int i3) {
        super.delete(i, i3);
        return this;
    }

    public final void e() {
        ArrayList arrayList = this.f215f;
        for (int i = 0; i < arrayList.size(); i++) {
            ((x) arrayList.get(i)).f213f.decrementAndGet();
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
    public final Object[] getSpans(int i, int i3, Class cls) {
        if (this.f214c != cls) {
            return super.getSpans(i, i3, cls);
        }
        x[] xVarArr = (x[]) super.getSpans(i, i3, x.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, xVarArr.length);
        for (int i10 = 0; i10 < xVarArr.length; i10++) {
            objArr[i10] = xVarArr[i10].f212c;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i, int i3, Class cls) {
        if (cls == null || this.f214c == cls) {
            cls = x.class;
        }
        return super.nextSpanTransition(i, i3, cls);
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
            this.f215f.remove(xVarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i3, CharSequence charSequence) {
        a();
        super.replace(i, i3, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i3, int i10) {
        if (d(obj)) {
            x xVar = new x();
            xVar.f213f = new AtomicInteger(0);
            xVar.f212c = obj;
            VarHandle.storeStoreFence();
            this.f215f.add(xVar);
            obj = xVar;
        }
        super.setSpan(obj, i, i3, i10);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i, int i3) {
        Class cls = this.f214c;
        y yVar = new y(this, i, i3);
        yVar.f215f = new ArrayList();
        p5.f.k(cls, "watcherClass cannot be null");
        yVar.f214c = cls;
        VarHandle.storeStoreFence();
        return yVar;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i, int i3) {
        super.delete(i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence, int i3, int i10) {
        super.insert(i, charSequence, i3, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence, int i3, int i10) {
        super.insert(i, charSequence, i3, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i, int i3) {
        super.append(charSequence, i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i, int i3) {
        super.append(charSequence, i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i3, CharSequence charSequence, int i10, int i11) {
        replace(i, i3, charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i3) {
        super.append(charSequence, i, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i3, CharSequence charSequence) {
        replace(i, i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i3, CharSequence charSequence, int i10, int i11) {
        a();
        super.replace(i, i3, charSequence, i10, i11);
        e();
        return this;
    }
}
