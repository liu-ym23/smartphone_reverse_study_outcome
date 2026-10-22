package G8;

import C8.f;
import Yb.t;
import com.autonavi.aps.amapapi.config.Const;
import io.noties.markwon.core.CoreProps;
import java.util.Arrays;
import java.util.Collection;
import u8.r;
import u8.u;
import u8.v;

/* loaded from: classes4.dex */
public class g extends C8.m {
    public static int d(f.a aVar) {
        int i10 = 0;
        while (true) {
            aVar = aVar.e();
            if (aVar == null) {
                return i10;
            }
            if ("ul".equals(aVar.name()) || Const.SP_KEY_ONCE_LOCATION.equals(aVar.name())) {
                i10++;
            }
        }
    }

    @Override // C8.m
    public void a(u8.m mVar, C8.j jVar, C8.f fVar) {
        if (fVar.c()) {
            f.a aVarA = fVar.a();
            boolean zEquals = Const.SP_KEY_ONCE_LOCATION.equals(aVarA.name());
            boolean zEquals2 = "ul".equals(aVarA.name());
            if (zEquals || zEquals2) {
                u8.g gVarZ = mVar.z();
                r rVarR = mVar.r();
                u uVar = gVarZ.e().get(t.class);
                int iD = d(aVarA);
                int i10 = 1;
                for (f.a aVar : aVarA.b()) {
                    C8.m.c(mVar, jVar, aVar);
                    if (uVar != null && "li".equals(aVar.name())) {
                        if (zEquals) {
                            CoreProps.f34200a.e(rVarR, CoreProps.ListItemType.ORDERED);
                            CoreProps.f34202c.e(rVarR, Integer.valueOf(i10));
                            i10++;
                        } else {
                            CoreProps.f34200a.e(rVarR, CoreProps.ListItemType.BULLET);
                            CoreProps.f34201b.e(rVarR, Integer.valueOf(iD));
                        }
                        v.k(mVar.builder(), uVar.a(gVarZ, rVarR), aVar.start(), aVar.end());
                    }
                }
            }
        }
    }

    @Override // C8.m
    public Collection<String> b() {
        return Arrays.asList(Const.SP_KEY_ONCE_LOCATION, "ul");
    }
}
