package q2;

import a9.d;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static String a(List list, String str, d dVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        if ((i & 32) != 0) {
            dVar = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int size = list.size();
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            i3++;
            if (i3 > 1) {
                sb2.append((CharSequence) str);
            }
            if (dVar != null) {
                sb2.append((CharSequence) dVar.invoke(obj));
            } else if (obj != null ? obj instanceof CharSequence : true) {
                sb2.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb2.append(((Character) obj).charValue());
            } else {
                sb2.append((CharSequence) obj.toString());
            }
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public static final void b(String str) {
        throw new UnsupportedOperationException(str);
    }
}
