package rc;

import java.lang.Character;
import java.util.Map;
import rc.a1;

/* loaded from: classes5.dex */
public class Z extends AbstractC5276d {
    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        Y0 y0B = y02.b(y02.n().copy());
        y0B.n().a(true);
        float fG = y0B.n().g();
        Map<Character.UnicodeBlock, a1.a> map = a1.f39208n;
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.BASIC_LATIN;
        a1.a aVar = map.get(unicodeBlock);
        if (aVar != null) {
            a1.f39208n.put(unicodeBlock, null);
        }
        I0 i02 = (I0) ((E0) new a1("\\mathrm{XETL}").f39212d).f39040d;
        if (aVar != null) {
            a1.f39208n.put(unicodeBlock, aVar);
        }
        Q q10 = new Q(i02.k().f(y0B));
        q10.b(new R0(0, (-0.35f) * fG, 0.0f, 0.0f).f(y0B));
        float fK = new R0(1, 0.45f * fG, 0.0f, 0.0f).f(y0B).k();
        float fK2 = new R0(1, 0.5f * fG, 0.0f, 0.0f).f(y0B).k();
        C5296n c5296n = new C5296n(y0B.n().F('A', "mathnormal", y0B.C().m()));
        c5296n.o(-fK);
        q10.b(c5296n);
        float f10 = fG * (-0.15f);
        q10.b(new R0(0, f10, 0.0f, 0.0f).f(y0B));
        q10.b(i02.k().f(y0B));
        q10.b(new R0(0, f10, 0.0f, 0.0f).f(y0B));
        AbstractC5284h abstractC5284hF = i02.k().f(y0B);
        abstractC5284hF.o(fK2);
        q10.b(abstractC5284hF);
        q10.b(new R0(0, f10, 0.0f, 0.0f).f(y0B));
        q10.b(i02.k().f(y0B));
        return q10;
    }
}
