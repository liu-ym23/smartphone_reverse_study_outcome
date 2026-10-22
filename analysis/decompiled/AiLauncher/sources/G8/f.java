package G8;

import Yb.q;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.caverock.androidsvg.SVGParser;
import io.noties.markwon.core.CoreProps;
import java.util.Collection;
import java.util.Collections;
import u8.r;
import u8.u;

/* loaded from: classes4.dex */
public class f extends h {
    @Override // C8.m
    public Collection<String> b() {
        return Collections.singleton(Const.INTENT_KEY_APIKEY);
    }

    @Override // G8.h
    public Object d(u8.g gVar, r rVar, C8.f fVar) {
        u uVar;
        String str = fVar.d().get(SVGParser.XML_STYLESHEET_ATTR_HREF);
        if (TextUtils.isEmpty(str) || (uVar = gVar.e().get(q.class)) == null) {
            return null;
        }
        CoreProps.f34204e.e(rVar, str);
        return uVar.a(gVar, rVar);
    }
}
