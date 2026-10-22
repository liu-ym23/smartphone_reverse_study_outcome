package aa7;

import ca7.n;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes11.dex */
public final class m extends a {
    public m() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r110, ea7.b r111, int r112) {
        List<ca7.c> r100 = ba7.b.b(r110, (ea7.b) ListProtector.get(r111.f471627b, 0), r112);
        List<ca7.c> r113 = ba7.b.b(r110, (ea7.b) ListProtector.get(r111.f471627b, 1), r112);
        ca7.g r101 = (ca7.g) ListProtector.get(r100, 0);
        Object r114 = ((ca7.d) ListProtector.get(r113, 0)).f22958c;
        String r102 = r101.f22959c;
        n r103 = r110.f18425g.get(r102);
        if (r103 != null) goto L5;
        r103 = new n();
        r110.f18425g.put(r102, r103);
    L5:
        r103.f(r112);
        r101.a(r103);
        if ((r114 instanceof String) == false) goto L9;
        ArrayList r115 = new ArrayList();
        r115.add((String) r114);
        Collection r116 = r115;
    L14:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r116.iterator();
    L16:
        if (r118.hasNext() == false) goto L39;
        String r119 = (String) r118.next();
        n.a r104 = r103.f22968c;
        String[] r105 = r119.split(HTTP.URL_DEFAULT);
        int r106 = 0;
    L19:
        if (r106 >= r105.length) goto L38;
        String r107 = r105[r106];
        char[] r108 = {Typography.dollar, '*', '+', '.', '?', '^', '|', '\\', '(', '[', '{'};
        int r109 = 0;
    L22:
        if (r109 >= r107.length()) goto L30;
        int r120 = 0;
    L24:
        if (r120 >= 11) goto L29;
        if (r108[r120] == r107.charAt(r109)) goto L27;
        r120 = r120 + 1;
        goto L24
    L27:
        Boolean r121 = Boolean.TRUE;
    L32:
        if (r121.booleanValue() == true) goto L38;
        n.a r122 = r104.f22969a.get(r105[r106]);
        if (r122 != null) goto L37;
        String r123 = r105[r106];
        r122 = new n.a();
        r104.f22969a.put(r105[r106], r122);
    L37:
        r104 = r122;
        r106 = r106 + 1;
        goto L19
    L29:
        r109 = r109 + 1;
        goto L22
    L30:
        r121 = Boolean.FALSE;
    L38:
        ca7.i r124 = new ca7.i(Collections.singletonList(r119));
        r104.f22970b.add(r124);
        r117.add(r124);
        goto L16
    L39:
        return r117;
    L9:
        if ((r114 instanceof String[]) == false) goto L12;
        r116 = Arrays.asList((String[]) r114);
        goto L14
    L12:
        if ((r114 instanceof Collection) == false) goto L41;
        r116 = (Collection) r114;
        goto L14
    L41:
        throw new IllegalArgumentException();
    }
}
