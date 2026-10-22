package com.stepos.ailauncher.express.net;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.express.net.AmooExpressData;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/ailauncher/express/net/b$a;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/express/net/b$a;)Ljava/lang/String;", "firstText", "express_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final String a(AmooExpressData.Edited edited) {
        p.i(edited, "<this>");
        for (String str : edited.b()) {
            if (!H.x0(str)) {
                return str;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
