package ma;

import ja.C1618a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: ma.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1734a {
    public static final Pattern b = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
    public static final Pattern c = Pattern.compile("^([-+]?(?:[0-9][0-9_]*)\\.[0-9_]*(?:[eE][-+]?[0-9]+)?|[-+]?(?:[0-9][0-9_]*)(?:[eE][-+]?[0-9]+)|[-+]?\\.[0-9_]+(?:[eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
    public static final Pattern d = Pattern.compile("^(?:[-+]?0b_*[0-1][0-1_]*|[-+]?0_*[0-7][0-7_]*|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x_*[0-9a-fA-F][0-9a-fA-F_]*|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
    public static final Pattern e = Pattern.compile("^(?:<<)$");
    public static final Pattern f = Pattern.compile("^(?:~|null|Null|NULL| )$");
    public static final Pattern g = Pattern.compile("^$");
    public static final Pattern h = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern i;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f5341a;

    static {
        Pattern.compile("^(?:=)$");
        i = Pattern.compile("^(?:!|&|\\*)$");
    }

    public final void a(C1618a c1618a, Pattern pattern, String str, int i6) {
        HashMap map = this.f5341a;
        if (pattern == null) {
            throw new IllegalStateException("No pattern provided for Tag=" + c1618a);
        }
        if (str == null) {
            List arrayList = (List) map.get(null);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(null, arrayList);
            }
            arrayList.add(new b(c1618a, pattern, i6));
            return;
        }
        for (char c2 : str.toCharArray()) {
            Character chValueOf = Character.valueOf(c2);
            if (c2 == 0) {
                chValueOf = null;
            }
            List arrayList2 = (List) map.get(chValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(chValueOf, arrayList2);
            }
            arrayList2.add(new b(c1618a, pattern, i6));
        }
    }
}
