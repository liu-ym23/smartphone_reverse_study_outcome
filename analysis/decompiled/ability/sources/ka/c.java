package ka;

import ha.AbstractC1551g;
import java.util.HashMap;
import na.C1752b;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4880a;
    public final oa.d b;
    public final /* synthetic */ e c;

    public /* synthetic */ c(e eVar, oa.d dVar, int i) {
        this.f4880a = i;
        this.c = eVar;
        this.b = dVar;
    }

    @Override // ka.f
    public final AbstractC1551g a() throws NumberFormatException {
        int i = this.f4880a;
        Token$ID token$ID = Token$ID.BlockEnd;
        Token$ID token$ID2 = Token$ID.BlockEntry;
        Token$ID token$ID3 = Token$ID.Comment;
        e eVar = this.c;
        oa.d dVar = this.b;
        int i6 = 0;
        int i10 = 1;
        switch (i) {
            case 0:
                C1752b c1752b = eVar.f4882a;
                C1752b c1752b2 = eVar.f4882a;
                if (!c1752b.c(token$ID3)) {
                    boolean zD = c1752b2.d(token$ID2, token$ID);
                    int i11 = 4;
                    if (!zD) {
                        eVar.c.b(new C1652a(eVar, i11));
                        HashMap map = e.g;
                        break;
                    } else {
                        eVar.e = new C1652a(eVar, i11);
                        break;
                    }
                } else {
                    eVar.e = new c(eVar, dVar, i6);
                    break;
                }
            default:
                C1752b c1752b3 = eVar.f4882a;
                C1752b c1752b4 = eVar.f4882a;
                if (!c1752b3.c(token$ID3)) {
                    boolean zD2 = c1752b4.d(token$ID2, Token$ID.Key, Token$ID.Value, token$ID);
                    int i12 = 18;
                    if (!zD2) {
                        eVar.c.b(new C1652a(eVar, i12));
                        HashMap map2 = e.g;
                        break;
                    } else {
                        eVar.e = new C1652a(eVar, i12);
                        break;
                    }
                } else {
                    eVar.e = new c(eVar, dVar, i10);
                    break;
                }
        }
        return e.a(eVar, dVar.b);
    }
}
