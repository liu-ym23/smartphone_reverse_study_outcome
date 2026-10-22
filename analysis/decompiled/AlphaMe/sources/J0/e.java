package J0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final List f872a;

    /* renamed from: b, reason: collision with root package name */
    public f f873b;

    public e(String... strArr) {
        this.f872a = Arrays.asList(strArr);
    }

    public final boolean a(int i4, String str) {
        List list = this.f872a;
        if (i4 >= list.size()) {
            return false;
        }
        boolean z4 = i4 == list.size() - 1;
        String str2 = (String) list.get(i4);
        if (!str2.equals("**")) {
            return (z4 || (i4 == list.size() + (-2) && ((String) B0.g.h(list, 1)).equals("**"))) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z4 && ((String) list.get(i4 + 1)).equals(str)) {
            return i4 == list.size() + (-2) || (i4 == list.size() + (-3) && ((String) B0.g.h(list, 1)).equals("**"));
        }
        if (z4) {
            return true;
        }
        int i5 = i4 + 1;
        if (i5 < list.size() - 1) {
            return false;
        }
        return ((String) list.get(i5)).equals(str);
    }

    public final int b(int i4, String str) {
        if (str.equals("__container")) {
            return 0;
        }
        List list = this.f872a;
        if (((String) list.get(i4)).equals("**")) {
            return (i4 != list.size() - 1 && ((String) list.get(i4 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean c(int i4, String str) {
        if (str.equals("__container")) {
            return true;
        }
        List list = this.f872a;
        if (i4 >= list.size()) {
            return false;
        }
        return ((String) list.get(i4)).equals(str) || ((String) list.get(i4)).equals("**") || ((String) list.get(i4)).equals("*");
    }

    public final boolean d(int i4, String str) {
        if (str.equals("__container")) {
            return true;
        }
        List list = this.f872a;
        return i4 < list.size() - 1 || ((String) list.get(i4)).equals("**");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.f872a);
        sb.append(",resolved=");
        sb.append(this.f873b != null);
        sb.append('}');
        return sb.toString();
    }

    public e(e eVar) {
        this.f872a = new ArrayList(eVar.f872a);
        this.f873b = eVar.f873b;
    }
}
