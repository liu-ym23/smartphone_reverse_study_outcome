package n6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.d0;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements Iterable, q5.a {

    /* renamed from: b, reason: collision with root package name */
    public static final k f4053b = new k(new String[0]);

    /* renamed from: a, reason: collision with root package name */
    public final String[] f4054a;

    public k(String[] namesAndValues) {
        kotlin.jvm.internal.p.e(namesAndValues, "namesAndValues");
        this.f4054a = namesAndValues;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return Arrays.equals(this.f4054a, ((k) obj).f4054a);
        }
        return false;
    }

    public final String f(String str) {
        String[] namesAndValues = this.f4054a;
        kotlin.jvm.internal.p.e(namesAndValues, "namesAndValues");
        int length = namesAndValues.length - 2;
        int iJ = a.a.J(length, 0, -2);
        if (iJ > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(namesAndValues[length])) {
            if (length == iJ) {
                return null;
            }
            length -= 2;
        }
        return namesAndValues[length + 1];
    }

    public final String g(int i8) {
        String str = (String) c5.l.f0(this.f4054a, i8 * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i8 + AbstractJsonLexerKt.END_LIST);
    }

    public final androidx.fragment.app.l h() {
        androidx.fragment.app.l lVar = new androidx.fragment.app.l(1);
        ArrayList arrayList = lVar.f682a;
        kotlin.jvm.internal.p.e(arrayList, "<this>");
        String[] elements = this.f4054a;
        kotlin.jvm.internal.p.e(elements, "elements");
        arrayList.addAll(c5.l.S(elements));
        return lVar;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4054a);
    }

    public final String i(int i8) {
        String str = (String) c5.l.f0(this.f4054a, (i8 * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i8 + AbstractJsonLexerKt.END_LIST);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        b5.g[] gVarArr = new b5.g[size];
        for (int i8 = 0; i8 < size; i8++) {
            gVarArr[i8] = new b5.g(g(i8), i(i8));
        }
        return d0.c(gVarArr);
    }

    public final int size() {
        return this.f4054a.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            String strG = g(i8);
            String strI = i(i8);
            sb.append(strG);
            sb.append(": ");
            if (o6.d.j(strG)) {
                strI = "██";
            }
            sb.append(strI);
            sb.append("\n");
        }
        return sb.toString();
    }
}
