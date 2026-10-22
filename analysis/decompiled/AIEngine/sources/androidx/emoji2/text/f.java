package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.emoji2.text.d;
import androidx.emoji2.text.h;
import i1.i;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final d.j f1946a;

    /* renamed from: b, reason: collision with root package name */
    public final h f1947b;

    /* renamed from: c, reason: collision with root package name */
    public final d.e f1948c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements b<i> {

        /* renamed from: a, reason: collision with root package name */
        public i f1949a;

        /* renamed from: b, reason: collision with root package name */
        public final d.j f1950b;

        public a(i iVar, d.j jVar) {
            this.f1949a = iVar;
            this.f1950b = jVar;
        }

        @Override // androidx.emoji2.text.f.b
        public final boolean a(CharSequence charSequence, int i10, int i11, i1.g gVar) {
            if ((gVar.f9445c & 4) > 0) {
                return true;
            }
            if (this.f1949a == null) {
                this.f1949a = new i(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            ((d.C0014d) this.f1950b).getClass();
            this.f1949a.setSpan(new i1.h(gVar), i10, i11, 33);
            return true;
        }

        @Override // androidx.emoji2.text.f.b
        public final i getResult() {
            return this.f1949a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b<T> {
        boolean a(CharSequence charSequence, int i10, int i11, i1.g gVar);

        T getResult();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public int f1952a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final h.a f1953b;

        /* renamed from: c, reason: collision with root package name */
        public h.a f1954c;

        /* renamed from: d, reason: collision with root package name */
        public h.a f1955d;

        /* renamed from: e, reason: collision with root package name */
        public int f1956e;

        /* renamed from: f, reason: collision with root package name */
        public int f1957f;

        public d(h.a aVar) {
            this.f1953b = aVar;
            this.f1954c = aVar;
        }

        public final void a() {
            this.f1952a = 1;
            this.f1954c = this.f1953b;
            this.f1957f = 0;
        }

        public final boolean b() {
            j1.a aVarB = this.f1954c.f1971b.b();
            int iA = aVarB.a(6);
            return !(iA == 0 || aVarB.f9653b.get(iA + aVarB.f9652a) == 0) || this.f1956e == 65039;
        }
    }

    public f(h hVar, d.C0014d c0014d, androidx.emoji2.text.b bVar, Set set) {
        this.f1946a = c0014d;
        this.f1947b = hVar;
        this.f1948c = bVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            c(str, 0, str.length(), 1, true, new c(str));
        }
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        i1.e[] eVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (eVarArr = (i1.e[]) editable.getSpans(selectionStart, selectionEnd, i1.e.class)) != null && eVarArr.length > 0) {
                for (i1.e eVar : eVarArr) {
                    int spanStart = editable.getSpanStart(eVar);
                    int spanEnd = editable.getSpanEnd(eVar);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i10, int i11, i1.g gVar) {
        if ((gVar.f9445c & 3) == 0) {
            d.e eVar = this.f1948c;
            j1.a aVarB = gVar.b();
            int iA = aVarB.a(8);
            if (iA != 0) {
                aVarB.f9653b.getShort(iA + aVarB.f9652a);
            }
            androidx.emoji2.text.b bVar = (androidx.emoji2.text.b) eVar;
            bVar.getClass();
            ThreadLocal<StringBuilder> threadLocal = androidx.emoji2.text.b.f1923b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb2 = threadLocal.get();
            sb2.setLength(0);
            while (i10 < i11) {
                sb2.append(charSequence.charAt(i10));
                i10++;
            }
            TextPaint textPaint = bVar.f1924a;
            String string = sb2.toString();
            int i12 = n0.c.f10592a;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i13 = gVar.f9445c & 4;
            gVar.f9445c = zHasGlyph ? i13 | 2 : i13 | 1;
        }
        return (gVar.f9445c & 3) == 2;
    }

    public final <T> T c(CharSequence charSequence, int i10, int i11, int i12, boolean z, b<T> bVar) {
        int i13;
        char c9;
        d dVar = new d(this.f1947b.f1968c);
        int iCodePointAt = Character.codePointAt(charSequence, i10);
        int i14 = 0;
        boolean zA = true;
        int iCharCount = i10;
        loop0: while (true) {
            i13 = iCharCount;
            while (iCharCount < i11 && i14 < i12 && zA) {
                SparseArray<h.a> sparseArray = dVar.f1954c.f1970a;
                h.a aVar = sparseArray == null ? null : sparseArray.get(iCodePointAt);
                if (dVar.f1952a == 2) {
                    if (aVar != null) {
                        dVar.f1954c = aVar;
                        dVar.f1957f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            dVar.a();
                        } else if (iCodePointAt != 65039) {
                            h.a aVar2 = dVar.f1954c;
                            if (aVar2.f1971b != null) {
                                if (dVar.f1957f != 1) {
                                    dVar.f1955d = aVar2;
                                    dVar.a();
                                } else if (dVar.b()) {
                                    dVar.f1955d = dVar.f1954c;
                                    dVar.a();
                                } else {
                                    dVar.a();
                                }
                                c9 = 3;
                            } else {
                                dVar.a();
                            }
                        }
                        c9 = 1;
                    }
                    c9 = 2;
                } else if (aVar == null) {
                    dVar.a();
                    c9 = 1;
                } else {
                    dVar.f1952a = 2;
                    dVar.f1954c = aVar;
                    dVar.f1957f = 1;
                    c9 = 2;
                }
                dVar.f1956e = iCodePointAt;
                if (c9 == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i13)) + i13;
                    if (iCharCount < i11) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c9 == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i11) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c9 == 3) {
                    if (z || !b(charSequence, i13, iCharCount, dVar.f1955d.f1971b)) {
                        zA = bVar.a(charSequence, i13, iCharCount, dVar.f1955d.f1971b);
                        i14++;
                    }
                }
            }
            break loop0;
        }
        if (dVar.f1952a == 2 && dVar.f1954c.f1971b != null && ((dVar.f1957f > 1 || dVar.b()) && i14 < i12 && zA && (z || !b(charSequence, i13, iCharCount, dVar.f1954c.f1971b)))) {
            bVar.a(charSequence, i13, iCharCount, dVar.f1954c.f1971b);
        }
        return bVar.getResult();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements b<c> {

        /* renamed from: a, reason: collision with root package name */
        public final String f1951a;

        public c(String str) {
            this.f1951a = str;
        }

        @Override // androidx.emoji2.text.f.b
        public final boolean a(CharSequence charSequence, int i10, int i11, i1.g gVar) {
            if (!TextUtils.equals(charSequence.subSequence(i10, i11), this.f1951a)) {
                return true;
            }
            gVar.f9445c = (gVar.f9445c & 3) | 4;
            return false;
        }

        @Override // androidx.emoji2.text.f.b
        public final c getResult() {
            return this;
        }
    }
}
