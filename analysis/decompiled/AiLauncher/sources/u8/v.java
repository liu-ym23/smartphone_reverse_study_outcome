package u8;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class v implements Appendable, CharSequence {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f42508a;

    /* renamed from: b, reason: collision with root package name */
    public final Deque<a> f42509b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42510a;

        /* renamed from: b, reason: collision with root package name */
        public int f42511b;

        /* renamed from: c, reason: collision with root package name */
        public int f42512c;

        /* renamed from: d, reason: collision with root package name */
        public final int f42513d;

        public a(Object obj, int i10, int i11, int i12) {
            this.f42510a = obj;
            this.f42511b = i10;
            this.f42512c = i11;
            this.f42513d = i12;
        }
    }

    public static class b extends SpannableStringBuilder {
        public b(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public v() {
        this("");
    }

    public static boolean g(int i10, int i11, int i12) {
        return i12 > i11 && i11 >= 0 && i12 <= i10;
    }

    public static void k(v vVar, Object obj, int i10, int i11) {
        if (obj == null || !g(vVar.length(), i10, i11)) {
            return;
        }
        l(vVar, obj, i10, i11);
    }

    public static void l(v vVar, Object obj, int i10, int i11) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                vVar.j(obj, i10, i11, 33);
                return;
            }
            for (Object obj2 : (Object[]) obj) {
                l(vVar, obj2, i10, i11);
            }
        }
    }

    @Override // java.lang.Appendable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v append(char c10) {
        this.f42508a.append(c10);
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v append(CharSequence charSequence) {
        e(length(), charSequence);
        this.f42508a.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v append(CharSequence charSequence, int i10, int i11) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i10, i11);
        e(length(), charSequenceSubSequence);
        this.f42508a.append(charSequenceSubSequence);
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f42508a.charAt(i10);
    }

    public v d(String str) {
        this.f42508a.append(str);
        return this;
    }

    public final void e(int i10, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z10 = spanned instanceof b;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                if (!z10) {
                    for (int i11 = 0; i11 < length; i11++) {
                        Object obj = spans[i11];
                        j(obj, spanned.getSpanStart(obj) + i10, spanned.getSpanEnd(obj) + i10, spanned.getSpanFlags(obj));
                    }
                    return;
                }
                for (int i12 = length - 1; i12 >= 0; i12--) {
                    Object obj2 = spans[i12];
                    j(obj2, spanned.getSpanStart(obj2) + i10, spanned.getSpanEnd(obj2) + i10, spanned.getSpanFlags(obj2));
                }
            }
        }
    }

    public List<a> f(int i10, int i11) {
        int i12;
        int length = length();
        if (!g(length, i10, i11)) {
            return Collections.EMPTY_LIST;
        }
        if (i10 == 0 && length == i11) {
            ArrayList arrayList = new ArrayList(this.f42509b);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator<a> itDescendingIterator = this.f42509b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            a next = itDescendingIterator.next();
            int i13 = next.f42511b;
            if ((i13 >= i10 && i13 < i11) || (((i12 = next.f42512c) <= i11 && i12 > i10) || (i13 < i10 && i12 > i11))) {
                arrayList2.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char h() {
        return this.f42508a.charAt(length() - 1);
    }

    public CharSequence i(int i10) {
        a next;
        int i11;
        int length = length();
        b bVar = new b(this.f42508a.subSequence(i10, length));
        Iterator<a> it = this.f42509b.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            int i12 = next.f42511b;
            if (i12 >= i10 && (i11 = next.f42512c) <= length) {
                bVar.setSpan(next.f42510a, i12 - i10, i11 - i10, 33);
                it.remove();
            }
        }
        this.f42508a.replace(i10, length, "");
        return bVar;
    }

    public v j(Object obj, int i10, int i11, int i12) {
        this.f42509b.push(new a(obj, i10, i11, i12));
        return this;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f42508a.length();
    }

    public SpannableStringBuilder m() {
        b bVar = new b(this.f42508a);
        for (a aVar : this.f42509b) {
            bVar.setSpan(aVar.f42510a, aVar.f42511b, aVar.f42512c, aVar.f42513d);
        }
        return bVar;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        List<a> listF = f(i10, i11);
        if (listF.isEmpty()) {
            return this.f42508a.subSequence(i10, i11);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f42508a.subSequence(i10, i11));
        int length = spannableStringBuilder.length();
        for (a aVar : listF) {
            int iMax = Math.max(0, aVar.f42511b - i10);
            spannableStringBuilder.setSpan(aVar.f42510a, iMax, Math.min(length, (aVar.f42512c - aVar.f42511b) + iMax), aVar.f42513d);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f42508a.toString();
    }

    public v(CharSequence charSequence) {
        this.f42509b = new ArrayDeque(8);
        this.f42508a = new StringBuilder(charSequence);
        e(0, charSequence);
    }
}
