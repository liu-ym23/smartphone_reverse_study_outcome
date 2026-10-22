package G8;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.Collection;
import u8.r;
import u8.u;

/* loaded from: classes4.dex */
public class b extends h {
    @Override // C8.m
    public Collection<String> b() {
        return Arrays.asList(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "em", "cite", "dfn");
    }

    @Override // G8.h
    public Object d(u8.g gVar, r rVar, C8.f fVar) {
        u uVar = gVar.e().get(Yb.i.class);
        if (uVar == null) {
            return null;
        }
        return uVar.a(gVar, rVar);
    }
}
