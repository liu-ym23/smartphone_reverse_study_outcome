package com.stepos.ailauncher.chat.adapter;

import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", UxipConstants.f30680s, "query", "", "Lv9/i;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class M {
    public static final List<C5680i> a(String value, String query) {
        int iQ0;
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(query, "query");
        if (La.H.x0(query)) {
            return C1173v.m();
        }
        List listC = C1172u.c();
        int length = 0;
        while (length <= value.length() - query.length() && (iQ0 = La.H.q0(value, query, length, true)) >= 0) {
            listC.add(C5685n.s(iQ0, query.length() + iQ0));
            length = iQ0 + query.length();
        }
        return C1172u.a(listC);
    }
}
