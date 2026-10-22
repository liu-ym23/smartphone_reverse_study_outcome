package w8;

import io.noties.markwon.core.CoreProps;
import u8.r;
import u8.u;

/* loaded from: classes4.dex */
public class g implements u {
    @Override // u8.u
    public Object a(u8.g gVar, r rVar) {
        if (CoreProps.ListItemType.BULLET == CoreProps.f34200a.d(rVar)) {
            return new x8.b(gVar.g(), CoreProps.f34201b.d(rVar).intValue());
        }
        return new x8.h(gVar.g(), String.valueOf(CoreProps.f34202c.d(rVar)) + ". ");
    }
}
