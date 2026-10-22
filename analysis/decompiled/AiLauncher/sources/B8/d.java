package B8;

import Yb.AbstractC1127a;
import Yb.t;
import Yb.u;
import Yb.w;
import Yb.z;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class d implements Zb.e {

    public static class b extends AbstractC1127a {

        /* renamed from: a, reason: collision with root package name */
        public static final Pattern f1471a = Pattern.compile("^\\[([xX\\s])]\\s+(.*)");

        public b() {
        }

        @Override // Yb.AbstractC1127a, Yb.B
        public void j(t tVar) {
            u uVarC = tVar.c();
            if (uVarC instanceof w) {
                u uVarC2 = uVarC.c();
                if (uVarC2 instanceof z) {
                    Matcher matcher = f1471a.matcher(((z) uVarC2).m());
                    if (matcher.matches()) {
                        boolean z10 = true;
                        String strGroup = matcher.group(1);
                        if (!"x".equals(strGroup) && !"X".equals(strGroup)) {
                            z10 = false;
                        }
                        B8.b bVar = new B8.b(z10);
                        w wVar = new w();
                        tVar.i(bVar);
                        String strGroup2 = matcher.group(2);
                        if (!TextUtils.isEmpty(strGroup2)) {
                            wVar.b(new z(strGroup2));
                        }
                        N8.e.a(wVar, uVarC2);
                        bVar.b(wVar);
                        N8.e.a(bVar, uVarC);
                        tVar.l();
                        g(bVar);
                        return;
                    }
                }
            }
            g(tVar);
        }
    }

    @Override // Zb.e
    public u a(u uVar) {
        uVar.a(new b());
        return uVar;
    }
}
