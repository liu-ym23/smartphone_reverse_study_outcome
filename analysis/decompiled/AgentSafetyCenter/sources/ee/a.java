package ee;

import g5.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f3843b = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f3844c = Pattern.compile("^([-+]?(?:[0-9][0-9_]*)\\.[0-9_]*(?:[eE][-+]?[0-9]+)?|[-+]?(?:[0-9][0-9_]*)(?:[eE][-+]?[0-9]+)|[-+]?\\.[0-9_]+(?:[eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f3845d = Pattern.compile("^(?:[-+]?0b_*[0-1][0-1_]*|[-+]?0_*[0-7][0-7_]*|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x_*[0-9a-fA-F][0-9a-fA-F_]*|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3846e = Pattern.compile("^(?:<<)$");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f3847f = Pattern.compile("^(?:~|null|Null|NULL| )$");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f3848g = Pattern.compile("^$");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f3849h = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern i;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f3850a;

    static {
        Pattern.compile("^(?:=)$");
        i = Pattern.compile("^(?:!|&|\\*)$");
    }

    public final void a(be.a aVar, Pattern pattern, String str, int i3) {
        HashMap map = this.f3850a;
        if (pattern == null) {
            f.r(aVar, "No pattern provided for Tag=");
            return;
        }
        if (str == null) {
            List arrayList = (List) map.get(null);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(null, arrayList);
            }
            arrayList.add(new b(aVar, pattern, i3));
            return;
        }
        for (char c9 : str.toCharArray()) {
            Character chValueOf = Character.valueOf(c9);
            if (c9 == 0) {
                chValueOf = null;
            }
            List arrayList2 = (List) map.get(chValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(chValueOf, arrayList2);
            }
            arrayList2.add(new b(aVar, pattern, i3));
        }
    }
}
