package G8;

import io.noties.markwon.core.CoreProps;
import java.util.Arrays;
import java.util.Collection;
import u8.r;
import u8.u;

/* loaded from: classes4.dex */
public class c extends h {
    @Override // C8.m
    public Collection<String> b() {
        return Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6");
    }

    @Override // G8.h
    public Object d(u8.g gVar, r rVar, C8.f fVar) throws NumberFormatException {
        int i10;
        u uVar = gVar.e().get(Yb.l.class);
        if (uVar == null) {
            return null;
        }
        try {
            i10 = Integer.parseInt(fVar.name().substring(1));
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            i10 = 0;
        }
        if (i10 < 1 || i10 > 6) {
            return null;
        }
        CoreProps.f34203d.e(rVar, Integer.valueOf(i10));
        return uVar.a(gVar, rVar);
    }
}
