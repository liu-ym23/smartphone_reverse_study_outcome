package X;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.KeyEvent;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final y1.f f2086a;

    /* renamed from: b, reason: collision with root package name */
    public final t.d f2087b;

    /* renamed from: c, reason: collision with root package name */
    public final g f2088c;

    public t(t.d dVar, y1.f fVar, C0112c c0112c, Set set) {
        this.f2086a = fVar;
        this.f2087b = dVar;
        this.f2088c = c0112c;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            c(str, 0, str.length(), 1, true, new r(str, 0));
        }
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z4) {
        C[] cArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (cArr = (C[]) editable.getSpans(selectionStart, selectionEnd, C.class)) != null && cArr.length > 0) {
            for (C c4 : cArr) {
                int spanStart = editable.getSpanStart(c4);
                int spanEnd = editable.getSpanEnd(c4);
                if ((z4 && spanStart == selectionStart) || ((!z4 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i4, int i5, B b4) {
        if ((b4.f2036c & 3) == 0) {
            g gVar = this.f2088c;
            Y.a aVarC = b4.c();
            int iA = aVarC.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarC.f2114d).getShort(iA + aVarC.f2111a);
            }
            C0112c c0112c = (C0112c) gVar;
            c0112c.getClass();
            ThreadLocal threadLocal = C0112c.f2045b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i4 < i5) {
                sb.append(charSequence.charAt(i4));
                i4++;
            }
            TextPaint textPaint = c0112c.f2046a;
            String string = sb.toString();
            int i6 = D.e.f361a;
            boolean zA = D.d.a(textPaint, string);
            int i7 = b4.f2036c & 4;
            b4.f2036c = zA ? i7 | 2 : i7 | 1;
        }
        return (b4.f2036c & 3) == 2;
    }

    public final Object c(CharSequence charSequence, int i4, int i5, int i6, boolean z4, q qVar) {
        char c4;
        y yVar = null;
        s sVar = new s((y) this.f2087b.f15275c, false, null);
        int iCodePointAt = Character.codePointAt(charSequence, i4);
        int i7 = 0;
        boolean zC = true;
        int iCharCount = i4;
        int i8 = iCharCount;
        while (iCharCount < i5 && i7 < i6 && zC) {
            SparseArray sparseArray = sVar.f2080c.f2103a;
            y yVar2 = sparseArray == null ? yVar : (y) sparseArray.get(iCodePointAt);
            if (sVar.f2078a == 2) {
                if (yVar2 != null) {
                    sVar.f2080c = yVar2;
                    sVar.f2083f++;
                } else {
                    if (iCodePointAt == 65038) {
                        sVar.a();
                    } else if (iCodePointAt != 65039) {
                        y yVar3 = sVar.f2080c;
                        if (yVar3.f2104b != null) {
                            if (sVar.f2083f != 1) {
                                sVar.f2081d = yVar3;
                                sVar.a();
                            } else if (sVar.b()) {
                                sVar.f2081d = sVar.f2080c;
                                sVar.a();
                            } else {
                                sVar.a();
                            }
                            c4 = 3;
                        } else {
                            sVar.a();
                        }
                    }
                    c4 = 1;
                }
                c4 = 2;
            } else if (yVar2 == null) {
                sVar.a();
                c4 = 1;
            } else {
                sVar.f2078a = 2;
                sVar.f2080c = yVar2;
                sVar.f2083f = 1;
                c4 = 2;
            }
            sVar.f2082e = iCodePointAt;
            if (c4 != 1) {
                if (c4 == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i5) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c4 == 3) {
                    if (z4 || !b(charSequence, i8, iCharCount, sVar.f2081d.f2104b)) {
                        zC = qVar.c(charSequence, i8, iCharCount, sVar.f2081d.f2104b);
                        i7++;
                    }
                }
                yVar = null;
            } else {
                iCharCount = Character.charCount(Character.codePointAt(charSequence, i8)) + i8;
                if (iCharCount < i5) {
                    iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                }
            }
            i8 = iCharCount;
            yVar = null;
        }
        if (sVar.f2078a == 2 && sVar.f2080c.f2104b != null && ((sVar.f2083f > 1 || sVar.b()) && i7 < i6 && zC && (z4 || !b(charSequence, i8, iCharCount, sVar.f2080c.f2104b)))) {
            qVar.c(charSequence, i8, iCharCount, sVar.f2080c.f2104b);
        }
        return qVar.b();
    }
}
